#!/bin/bash

today=`date '+%Y_%m_%d__%H_%M_%S'`;
mkdir -p first_task/data-queries/

#source 1
cat route_queries.csv|grep -v 'user_id'|tr ',' '' |sed  's/$/1/'>> first_task/data-queries/queries_$today.csv
#source 2
cat searches.csv |grep -v 'origin'|first_task/scripts/parseSource2.py|sed  's/$/2/'>> first_task/data-queries/queries_$today.csv

s3cmd sync first_task/data-queries/ s3://mangat-test-data-queries/
sed -i -e "s/{today_date}/$today/g" first_task/scripts/load_query.sql
psql -h redshift-mangat-test.cp4b9vqldicx.us-east-1.redshift.amazonaws.com -U root -d dev -p 5439 -f first_task/scripts/load_query.sql||true
sed -i -e "s/$today/{today_date}/g" first_task/scripts/load_query.sql
