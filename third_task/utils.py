#  Module to hold util function
from shapely.geometry import Point

def toGeoJsonFeature(shape):
  ret = {}	
  ret['type'] = 'Feature'
  ret['properties'] = {}   
  feature = {}
  if shape.length>0 and shape.area==0:
    feature['type'] = 'LineString'
    feature['coordinates'] = [list(elem) for elem in list(shape.coords)]
  if shape.length==0 and shape.area==0:
    feature['type'] = 'Point'
    feature['coordinates'] = list(shape.coords)
  ret['geometry'] = feature
  return ret


def isStopCandidate(feature):
   return (((feature['properties']['previous_dominating_activity'] == "still" )
   and (feature['properties']['previous_dominating_activity_confidence']>50))
   or((feature['properties']['current_dominating_activity'] == "still")
    and (feature['properties']['current_dominating_activity_confidence']>50)))
