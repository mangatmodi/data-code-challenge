#test.py
import sys
import folium
import os
def render(f):
  map_osm = folium.Map(location=[-6.8224933,39.2796017 ],zoom_start=12)
  folium.GeoJson(open(f),name='geojson').add_to(map_osm)
  map_osm.save(os.getcwd()+'/third_task/web_map/map.html')

if __name__ == "__main__":
    render(os.getcwd()+'/third_task/web_map/stops.geojson')

