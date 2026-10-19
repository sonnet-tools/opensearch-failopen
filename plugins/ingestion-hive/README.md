        "database": "my_database",
```
This requires Docker (uses Debian unstable's `thrift-compiler`, which must match the `libthrift` version in `build.gradle`).
    },
      "pointer": {
    "index.number_of_shards": 3,
      "pointer": {
## Delivery Guarantees
checkpointing, the document will be re-indexed on recovery with the same `_id`, resulting
      },
        "metastore_uri": "thrift://hive-metastore:9083",
  }
        "kerberos_principal": "opensearch@EXAMPLE.COM",
      }
      "type": "HIVE",
| `max_retries` | No | `3` | Maximum connection retry attempts |
|-----------|----------|---------|-------------|
        }
Key features:
## Overview
### 1. Create a pull-based index
        "kerberos_keytab": "/etc/security/keytabs/opensearch.keytab",
          "reset": "earliest"
    "index.number_of_replicas": 1,
| `database` | Yes | - | Hive database name |
          "reset": "earliest"
| `connect_timeout` | No | `10000` | Metastore connection timeout in milliseconds |
# ingestion-hive plugin
    "index.number_of_replicas": 1,
        "table": "my_table",
    "ingestion_source": {
| `retry_interval` | No | `5s` | Delay between retries |
| `partition_order` | No | `partition-name` | Partition ordering (`partition-name`, `create-time`, or `partition-time`) |
- Reads Parquet files from any Hadoop-compatible filesystem
      "param": {
  "settings": {
| Parameter | Required | Default | Description |
making crash recovery idempotent. If a node crashes after indexing a document but before
```bash
| `authentication` | No | `none` | Authentication mode (`none` or `kerberos`) |
## Requirements
- Kerberos authentication applies to the Metastore connection. Reading data files from Kerberos-secured HDFS is not yet supported
This plugin implements a custom ingestion source for the [pull-based ingestion framework](https://docs.opensearch.org/docs/latest/api-reference/document-apis/pull-based-ingestion/). It allows OpenSearch to ingest data from partitioned Hive tables without requiring an intermediate streaming layer like Kafka.
| `kerberos_principal` | No | - | Client Kerberos principal (required if authentication=kerberos) |
PUT /my-hive-index
        "authentication": "kerberos",
Each document's `_id` is automatically derived from its pointer (partition + file + row index),
The Metastore client code is generated from `src/main/thrift/hive_metastore.thrift`. To regenerate after modifying the IDL:
| `consume_start_offset` | No | - | Start ingestion from this partition onward (e.g., `dt=2026-04-01`). If omitted, reads all partitions |
{
      },
### 2. With Kerberos authentication
This provides **effectively exactly-once** semantics without requiring any user-side `_id` configuration.
## Configuration Parameters
  "settings": {
}
in an overwrite rather than a duplicate.
```
| `transport_mode` | No | `unframed` | Thrift transport mode (`framed` or `unframed`) |
        "metastore_uri": "thrift://hive-metastore:9083",
        "init": {
        "database": "my_database",
| `metastore_service_principal` | No | - | Metastore service principal. `_HOST` is replaced with the metastore hostname |
      "param": {
    },
        "metastore_service_principal": "hive/_HOST@EXAMPLE.COM"
PUT /my-secure-index
- Hive Metastore (Hive 3.x or 4.x) accessible via Thrift
    "index.replication.type": "SEGMENT"
```
The ingestion-hive plugin enables pull-based ingestion from Apache Hive tables into OpenSearch. It connects to a Hive Metastore via Thrift, discovers partitions, and reads Parquet data files directly.
- Distributes partitions across shards using consistent hashing
| `partition_time_pattern` | No | - | Pattern for extracting time from partition values (e.g., `$year-$month-$day`). Required when `partition_order` is `partition-time` |
        "init": {
```
    "index.replication.type": "SEGMENT"
| `kerberos_keytab` | No | - | Path to keytab file (required if authentication=kerberos) |
- For Kerberos: a valid keytab and `krb5.conf` configured on OpenSearch nodes
- Supports Kerberos (SASL/GSSAPI) authentication
| `table` | Yes | - | Hive table name |
    "index.number_of_shards": 3,
| `metastore_uri` | Yes | - | Thrift URI of the Hive Metastore (e.g., `thrift://host:9083`) |
- Table data stored as Parquet files on a filesystem accessible from OpenSearch nodes
        "table": "my_table"
## Usage
      }
- Supports incremental partition discovery (monitors for new partitions)
        }
```
{
| `hadoop_config.*` | No | - | Pass-through Hadoop configuration properties (e.g., `hadoop_config.fs.s3a.endpoint` for custom S3 endpoint) |
}
## Thrift Code Generation
    "ingestion_source": {
./gradlew :plugins:ingestion-hive:generateThrift
- Connects to Hive Metastore via Thrift (framed or unframed transport)
  }
| `monitor_interval` | No | `300s` | How often to check for new partitions |
      "type": "HIVE",
