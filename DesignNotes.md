Design Consideration
=====================

1. routes.json could be a big fat json object. So we are doing gson streaming instead of deserializing whole file in the memory.
2. Wrapper Classes are used instead of primitive types to identify the missing/null values from the zero values.