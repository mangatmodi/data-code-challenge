# data-code-challenge
Code challenge for Data Engineer

# First task

We'd like you to grab data from the files listed below and propose interrelated data model and schemas. After that, load it into a free-tier AWS Redshift and provide code and documentation.

* [route_queries.csv](https://github.com/door2door-io/data-code-challenge/blob/master/route_queries.csv)
* [routes.json](https://github.com/door2door-io/data-code-challenge/blob/master/routes.json)
* [searches.csv](https://github.com/door2door-io/data-code-challenge/blob/master/searches.csv)

# Second task

We'd like you to propose a way (setup and tools) for daily loading of mobile app related metadata from app stores to AWS Redshift.

# Third task

We'd also like to learn more about your coding skills.

## Data Description
The file [activity_points.geojson](https://github.com/door2door-io/data-code-challenge/blob/master/activity_points.geojson) contains crowdsourced locations in Dar es Salaam, Tanzania.
The quality and the source of the data is unknown. Not all attributes of the data always contain a value. There is no additional metadata.

Your task is to derive bus stop locations from the data.

##### 1. Develop an algorithm in Python that processes the data.
##### 2. Visualise your results in a web map.