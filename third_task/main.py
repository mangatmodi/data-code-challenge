import sys
import json
import shapely.geometry as geometry
from shapely.ops import transform
from functools import partial
import pyproj
from web_map import render

project = partial(pyproj.transform,pyproj.Proj(init='EPSG:4326'),pyproj.Proj(init='EPSG:32633'))
pointDict = {}
lineDict = {}
ans = {}

def main():
    prepareAns();
    if len(sys.argv) <4:
        print "Usage: python third_task/main.py <routes.geojson> <activity_points.geojson> <map_file_location>"
        sys.exit(-1)
    parseToGeo(sys.argv[1],isRouteFile=True)
    parseToGeo(sys.argv[2],isRouteFile=False)
    features = []
    count = 0
    for k2,v2 in pointDict.iteritems():
      p = json.loads(k2);	
      for k1,v1 in lineDict.iteritems():
        if v1.distance(v2) < int(p['properties']['accuracy']):
           features.append(json.loads(k1))
           features.append(p)
    ans['features'] =   features 
    with open(sys.argv[3],'w') as f:
        f.write(json.dumps(ans)+'\n')
    render.render(sys.argv[3])    


def parseToGeo(routeFile,isRouteFile):
  with open(routeFile) as f:
    data = json.load(f)
  for feature in data['features']:
    g = geometry.asShape(feature['geometry'])
    if isRouteFile:
      lineDict[json.dumps(feature)]=transform(project,g)
    else:
       if feature['properties']['previous_dominating_activity'] == "still" or feature['properties']['current_dominating_activity'] == "still":
        pointDict[json.dumps(feature)]=transform(project,g)
	

def prepareAns():
  ans["type"]= "FeatureCollection"
  ans["crs"] = json.loads('{ "type": "name", "properties": { "name": "urn:ogc:def:crs:OGC:1.3:CRS84" } }')

if __name__ == "__main__":
    main()
