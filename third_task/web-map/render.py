#test.py
import sys
import folium
map_osm = folium.Map(location=[-6.8224933,39.2796017 ],zoom_start=12)
folium.GeoJson(open('/Users/mangat/git/data-code-challenge/activity_points.geojson'),
               name='geojson'
              ).add_to(map_osm)
folium.GeoJson(open('/Users/mangat/git/data-code-challenge/routes.geojson'),
               name='geojson'
              ).add_to(map_osm)
map_osm.save('map.html')