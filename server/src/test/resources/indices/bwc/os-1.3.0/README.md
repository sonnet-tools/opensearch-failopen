```
        "testNum": { "type": "short" },
        "testRange": {"type": "integer_range" },
  "testMessage": "The OpenSearch Project",
      }
              "analyzer": "standard"
  "testRange": {
  "settings": {
      "properties": {
  "testDate": "1970-01-02",
'
        "testBlob": { "type": "binary", "index": false },
    "number_of_replicas": 0
curl -X POST "localhost:9200/testindex/_flush" -H 'Content-Type: application/json' -d'{}'
  },
        "id": { "type": "keyword" },
    "number_of_shards": 1,
  "isTestData": true,
then compressing the contents of the underlying Lucene index directory i.e.
{
the files under `<elasticsearch-root>/data/nodes/0/indices/<index-uuid>/0/index`.
  }
```
          }
  "id": "testData1",
The index contains one document.
        "isTestData": { "type": "boolean" },
{
        "testMessage": {
}'
  },
        "testLocation": { "type": "geo_point"}
    "gte": 0,
  "testLocation": "48.553532,-113.022881"
        "testDate": { "type": "date" },
        },
            }
## Commands
}
    "lte": 100
  "testBlob": "VGhlIE9wZW5TZWFyY2ggUHJvamVjdA==",
curl -X PUT -H 'Content-Type: application/json' 'localhost:9200/testindex?pretty' -d'
  "testNum": 99,
  "mappings": {
Flushing is essential to commit the changes to ensure tests don't fail complaining there are no docs in segment.
# README for _testIndex-os-1.3.0.zip_
This zip file holds a Lucene index created using OpenSearch 1.3.0 downloaded from https://opensearch.org/versions/opensearch-1-3-0.html
It was created by running the underlying commands against a single-node cluster,
curl -X POST "localhost:9200/testindex/_doc/1" -H 'Content-Type: application/json' -d'
              "type": "token_count",
            "length": {
          "type": "text",
          "fields": {
