#!/bin/bash

java -jar target/coding-challenge-0.0.1-SNAPSHOT-jar-with-dependencies.jar $1 $2
today=`date '+%Y_%m_%d'`;
mkdir -p data/
cat out|grep '^RouteSegmentRow'|sed "s/RouteSegmentRow//g" > data/RouteSegment_$today.csv
cat out|grep '^RouteRow'|sed "s/RouteRow//g" > data/Route_$today.csv
cat out|grep '^StopRow'|sed "s/StopRow//g" > data/Stop_$today.csv
cat out|grep '^SegmentRow'|sed "s/SegmentRow//g" > data/Segment_$today.csv
cat out|grep '^SegmentStopRow'|sed "s/SegmentStopRow//g" > data/SegmentStop_$today.csv
cat out|grep '^CarSharingProperty'|sed "s/CarSharingProperty//g" > data/CarSharingRoute_$today.csv
cat out|grep '^BikeSharingProperty'|sed "s/BikeSharingProperty//g" > data/BikeSharingRoute_$today.csv
cat out|grep '^TaxiProperty'|sed "s/TaxiProperty//g" > data/TaxiCompany_$today.csv
cat out|grep '^TaxiRoute'|sed "s/TaxiRoute//g" > data/TaxiRoute_$today.csv

sed -i -e "s/{today_date}/$today/g" load_data.sql
#cat load_data.sql
s3cmd sync data/ s3://mangat-test-data/

psql -h redshift-mangat-test.cp4b9vqldicx.us-east-1.redshift.amazonaws.com -U root -d dev -p 5439 -f load_data.sql

sed -i -e "s/$today/{today_date}/g" load_data.sql
#cat load_data.sql
