import sys
import json
import shapely.geometry as geometry
from shapely.ops import transform
from functools import partial
import pyproj
from web_map import render
from shapely import speedups
from rtree import index	
import utils
import hypothesis

idPoint = index.Index()
project = partial(pyproj.transform,pyproj.Proj(init='EPSG:4326'),pyproj.Proj(init='EPSG:21037'))
project_back = partial(pyproj.transform,pyproj.Proj(init='EPSG:21037'),pyproj.Proj(init='EPSG:4326'))

pointDict = {}
lineDict = {}
pointProperty = {}
ans = {}

def main():
    if speedups.available:
      speedups.enable()
    prepareAns();
    if len(sys.argv) <4:
        print "Usage: python third_task/main.py <routes.geojson> <activity_points.geojson> <map_file_location>"
        sys.exit(-1)
    parseToGeo(sys.argv[1],isRouteFile=True)
    parseToGeo(sys.argv[2],isRouteFile=False)    
    features = []
    count = 0
    for k1,v1 in lineDict.iteritems():
      features.append(utils.toGeoJsonFeature(transform(project_back,v1)))    	
      for k2,v2 in pointDict.iteritems():
        if v1.distance(v2) < min(int(pointProperty[k2]['accuracy']),20):
           projected_point = transform(project_back,v1.interpolate(v1.project(v2)))
           nearestIds = idPoint.nearest((projected_point.x,projected_point.y),1,False)
           for nearestId in nearestIds:
             if v2.distance(pointDict[nearestId]) > 100:
               p = utils.toGeoJsonFeature(v2)
               p['geometry']['coordinates'] = [projected_point.x,projected_point.y]
               features.append(p)
           idPoint.insert(k2,(projected_point.bounds))        	           



    ans['features'] =   features 
    with open(sys.argv[3],'w') as f:
        f.write(json.dumps(ans)+'\n')
    render.render(sys.argv[3])
    hypothesis.getMSErr(project_back,pointDict,pointProperty)                    


def parseToGeo(routeFile,isRouteFile):
  with open(routeFile) as f:
    data = json.load(f)
  for feature in data['features']:
    g = geometry.asShape(feature['geometry'])
    if isRouteFile:
      lineDict[feature['properties']['route_id']]=transform(project,g)
    else:
      if feature['properties']['previous_dominating_activity'] == "still" or feature['properties']['current_dominating_activity'] == "still":
      #  if utils.isStopCandidate(feature):
          pointDict[feature['properties']['id']]=transform(project,g)
          pointProperty[feature['properties']['id']] = feature['properties']

def prepareAns():
  ans["type"]= "FeatureCollection"
  ans["crs"] = json.loads('{ "type": "name", "properties": { "name": "urn:ogc:def:crs:OGC:1.3:CRS84" } }')

if __name__ == "__main__":
    main()
