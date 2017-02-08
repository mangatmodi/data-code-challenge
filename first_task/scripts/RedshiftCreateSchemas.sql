CREATE TABLE route
(
  id         Integer,
  amount     float8,
  currency   varchar(50),
  type       varchar(100),
  provider   varchar(100),
  created_at timestamp  DEFAULT getdate()
 )
  distkey(id)
  interleaved sortkey(created_at,provider,type);

  CREATE TABLE segment
(
  id          Integer,
  num_stops   integer,
  polyline    varchar(1000),
  color    varchar(20),
  description varchar(500),
  name        varchar(100),
  icon_url   varchar(1000),
  travel_mode varchar(100),
  created_at timestamp  DEFAULT getdate()
 )
  distkey(id)
  interleaved sortkey(created_at,polyline,id);

CREATE TABLE stop
(
  id          Integer,
  name        varchar(100),
  lat    float8,
  lng   float8,
  property   varchar(100),
  date_time TIMESTAMPTZ,
  created_at timestamp  DEFAULT getdate()
 )
  distkey(id)
  interleaved sortkey(created_at,lat,lng);

CREATE TABLE taxi_company
(
  id          Integer,
  phone       varchar(20),
  name        varchar(100),
  created_at timestamp  DEFAULT getdate()
 )
  distkey(id)
  interleaved sortkey(created_at,id);

CREATE TABLE route_segment
(
  route_id          Integer,
  segment_id        Integer,
  sequence          Integer,
  created_at timestamp  DEFAULT getdate()
 )
  distkey (segment_id)
  sortkey(created_at,route_id);

CREATE TABLE bike_sharing_route
(
  route_id          Integer,
  id        Integer,
  available_bikes          Integer,
  created_at timestamp  DEFAULT getdate()
 )
  distkey (route_id)
  interleaved sortkey(created_at,route_id,available_bikes);

CREATE TABLE taxi_route_company
(
  company_id        Integer,
  route_id          Integer,
  created_at timestamp  DEFAULT getdate()
 )
  distkey (company_id)
  interleaved sortkey(created_at,route_id);

  CREATE TABLE segment_stop
(
  segment_id        Integer,
  stop_id          Integer,
  sequence          Integer,
  created_at timestamp  DEFAULT getdate()
 )
  distkey (stop_id)
  sortkey(created_at,segment_id);

  CREATE TABLE car_sharing_route
(
  route_id          Integer,
  doors     Integer,
  license_plate   varchar(50),
  model       varchar(100),
  address       varchar(800),  
  description   varchar(500),
  fuel_level   varchar(50),
  engine_type   varchar(50),
  seats   Integer,
  internal_cleanliness varchar(50),
  created_at timestamp  DEFAULT getdate()
 )
  distkey(route_id)
  interleaved sortkey(created_at,route_id,seats);


  CREATE TABLE user_search_queries
(
  user_id          varchar(80),
  query_time     TIMESTAMPTZ,
  search_time     TIMESTAMPTZ,
  search_mode       varchar(100),
  search_origin_lat   float8,
  search_origin_lng   float8,
  search_destination_lat   float8,
  search_destination_long   float8,
  created_at timestamp  DEFAULT getdate()
 )
interleaved sortkey(created_at,search_origin_lat,search_origin_lng);






