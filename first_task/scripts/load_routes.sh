#!/bin/bash
java -jar first_task/target/coding-challenge-0.0.1-SNAPSHOT-jar-with-dependencies.jar $1 $2
today=`date '+%Y_%m_%d'`;
mkdir -p first_task/data/
cat $2|grep '^RouteSegmentRow'|sed "s/RouteSegmentRow//g" > first_task/data/RouteSegment_$today.csv
cat $2|grep '^RouteRow'|sed "s/RouteRow//g" > first_task/data/Route_$today.csv
cat $2|grep '^StopRow'|sed "s/StopRow//g" > first_task/data/Stop_$today.csv
cat $2|grep '^SegmentRow'|sed "s/SegmentRow//g" > first_task/data/Segment_$today.csv
cat $2|grep '^SegmentStopRow'|sed "s/SegmentStopRow//g" > first_task/data/SegmentStop_$today.csv
cat $2|grep '^CarSharingProperty'|sed "s/CarSharingProperty//g" > first_task/data/CarSharingRoute_$today.csv
cat $2|grep '^BikeSharingProperty'|sed "s/BikeSharingProperty//g" > first_task/data/BikeSharingRoute_$today.csv
cat $2|grep '^TaxiProperty'|sed "s/TaxiProperty//g" > first_task/data/TaxiCompany_$today.csv
cat $2|grep '^TaxiRoute'|sed "s/TaxiRoute//g" > first_task/data/TaxiRoute_$today.csv

s3cmd sync first_task/data/ s3://mangat-test-data/

sed -i -e "s/{today_date}/$today/g" first_task/scripts/load_data.sql
psql -h redshift-mangat-test.cp4b9vqldicx.us-east-1.redshift.amazonaws.com -U root -d dev -p 5439 -f first_task/scripts/load_data.sql||true
sed -i -e "s/$today/{today_date}/g" first_task/scripts/load_data.sql
