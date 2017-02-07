#!/usr/bin/env python

import sys
for line in sys.stdin: 
   data = line.strip().split(',');
   if len(data)!=3:
     #malformed csv
     continue
   data[1] = data[1].replace('POINT(','').replace(')','').replace(' ','')
   data[2] = data[2].replace('POINT(','').replace(')','').replace(' ','')
   print ''+data[0]+'+00'+data[1]+''+data[2]
