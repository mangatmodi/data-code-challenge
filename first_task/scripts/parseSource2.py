#!/usr/bin/env python

import sys
import re
from shapely.wkt import dumps, loads
from shapely.geometry import Point

for line in sys.stdin:
   data = line.strip().split(',')
   if len(data)!=3:
     #malformed csv
     continue
   source_p = loads(data[1])
   dest_p = loads(data[2])
   print ''+data[0]+'+00'+str(source_p.y)+''+str(source_p.x)+''+str(dest_p.y)+''+str(dest_p.x)
