#!/bin/bash

mkdir -p data/
cat out|grep '^RouteSegmentRow'|sed "s/RouteSegmentRow//g" > data/RouteSegment.csv
cat out|grep '^RouteRow'|sed "s/RouteRow//g" > data/Route.csv
cat out|grep '^SegmentRow'|sed "s/SegmentRow//g" > data/Segment.csv
cat out|grep '^SegmentStopRow'|sed "s/SegmentStopRow//g" > data/SegmentStop.csv
cat out|grep '^CarSharingProperty'|sed "s/CarSharingProperty//g" > data/CarSharingRoute.csv
cat out|grep '^BikeSharingProperty'|sed "s/BikeSharingProperty//g" > data/BikeSharingRoute.csv
cat out|grep '^TaxiProperty'|sed "s/TaxiProperty//g" > data/TaxiCompany.csv
cat out|grep '^TaxiRoute'|sed "s/TaxiRoute//g" > data/TaxiRoute.csv
