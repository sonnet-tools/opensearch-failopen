## Usage
      }
  "mappings": {
        "base_directory": "path to the base directory"
```
{
</pre>
    "index.number_of_shards": 1,
### 2. Start OpenSearch with the Plugin
    "properties": {
<pre>
    }
  }
        "stream": "test_stream",
${base_directory}/${stream}/${shard_id}.ndjson
./gradlew run -PinstalledPlugins="['ingestion-fs']"
### 1. Prepare test data
This plugin implements a custom ingestion source for the [pull-based ingestion framework](https://docs.opensearch.org/docs/latest/api-reference/document-apis/pull-based-ingestion/). It allows OpenSearch to ingest documents from `.ndjson` files on the file system.
      },
PUT /test-index
        "type": "integer"
      "name": {
  },
        "type": "text"
    "index": {
Each shard-specific file is expected to follow the path:
```
    },
# ingestion-fs plugin
}
  "settings": {
      "param": {
    }
      "replication.type": "SEGMENT"
{"_id":"2","_version":"1","_op_type":"index","_source":{"name":"name2", "age": 31}}
```
      "age": {
```
### 3. Create a pull-based index
    "index.number_of_replicas": 0,
```
Create an index by specifying ingestion source settings as follows
```
{"_id":"1","_version":"1","_op_type":"index","_source":{"name":"name1", "age": 30}}
      }
The ingestion-fs plugin enables pull-based ingestion from the local file system into OpenSearch. It is primarily intended for local testing and development purposes to facilitate testing without setting up Kafka/Kinesis.
      "type": "file",
For example, create a file `${base_directory}/test-stream/0.ndjson` with data
    "ingestion_source": {
Create the `ndjson` files with sample data following the format mentioned [here](https://docs.opensearch.org/docs/latest/api-reference/document-apis/pull-based-ingestion/).
## Overview
