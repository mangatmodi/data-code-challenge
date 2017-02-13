import main
import math
from shapely.ops import transform


if __name__ == "__main__":
   getMSErr()    



def haversine(lon1, lat1, lon2, lat2):
    """
    Calculate the great circle distance between two points 
    on the earth (specified in decimal degrees)
    """
    # convert decimal degrees to radians 
    lon1, lat1, lon2, lat2 = map(math.radians, [lon1, lat1, lon2, lat2])

    # haversine formula 
    dlon = lon2 - lon1 
    dlat = lat2 - lat1 
    a = math.sin(dlat/2)**2 + math.cos(lat1) * math.cos(lat2) * math.sin(dlon/2)**2
    c = 2 * math.asin(math.sqrt(a)) 
    r = 6371 # Radius of earth in kilometers. Use 3956 for miles
    return c * r


def getMSErr(project_back,pointDict,pointProperty):
    sumRouteSelection=0.0
    sumClustering=0.0
    countRouteSelection=0.0
    countClustering=0.0
    for k1,v1 in pointDict.iteritems():
      origin = v1
      origin_4326 = transform(project_back,origin)    
      for k2,v2 in pointDict.iteritems():
        if v1.distance(v2) < int(pointProperty[k2]['accuracy']) and k1!=k2:
          v2_4326 = transform(project_back,v2)
          sumRouteSelection+=((haversine(v2_4326.x,v2_4326.y,origin_4326.x,origin_4326.y)*1000 - (v2.distance(origin)))**2)
          countRouteSelection=countRouteSelection+1  
        if v1.distance(v2) < 100 and k1!=k2:
          v2_4326 = transform(project_back,v2)
          sumClustering+=((haversine(v2_4326.x,v2_4326.y,origin_4326.x,origin_4326.y)*1000 - (v2.distance(origin)))**2)
          countClustering=countClustering+1  

    print "MSE in Selecting closeness to Route: "+str(sumRouteSelection/countRouteSelection)+" sq. m"
    print "MSE in Selecting cluster membership: "+str(sumClustering/countClustering)+" sq. m"