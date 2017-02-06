Design Consideration
=====================

1. routes.json could be a big fat json object. So we are doing gson streaming instead of deserializing whole file in the memory.
2. Wrapper Classes are used instead of primitive types to identify the missing/null values from the zero values.
3. Since property structure depends on the route type. We need to provide concrete implementation everytime a new route is added. There is no easier way of handling this
4. Some segments don't have any polyline, these are the segments with no route like waiting, changing, setup etc.

=========================================================================================================================