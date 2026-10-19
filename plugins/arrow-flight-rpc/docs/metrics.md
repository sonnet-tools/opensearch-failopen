          "client_threads_total": 0,
            "max_nanos": 135,
            "count": 3,
## Metrics Structure
| `completed` | Number of server calls completed |
        "sent_size": "24.6kb",
        }
          "response_bytes": 13083
## Monitoring Streaming Tasks
          "direct_memory_bytes": 126642920,
          },
            "max": "4.2kb",
Streaming tasks are identified by the `stream-transport` type:
        "avg_processing_time_nanos": 2
      "calls": {
Metrics related to server-side calls:
| `started` | Number of client calls started |
        "response_bytes": 25276
        "duration": "1s",
# Arrow Flight RPC Metrics
          }
GET /_flight/stats/{node_id}
```
          "requested": 6,
    "client": {
          "processing_time": {
          "server": {
        },
curl "localhost:9200/_cat/tasks?v"
            "sum_nanos": 147,
          }
            "max_bytes": 4361,
|--------|-------------|
            "avg": "1022b",
        "received_size": "24.6kb",
            "min": "352micros",
            "min_bytes": 1022,
### Resource Metrics
            "max": "1022b",
        },
            "sum": "2.9kb",
            "max": "9.5ms",
### Status Metrics
            "max": "1022b",
| `arrow_peak_bytes` | Peak Arrow memory allocation in bytes |
        "avg_duration": "169.8ms",
- **Data throughput**: Track `client_calls.request_bytes` and `server_batches.sent_bytes` rates
        },
          "response": "24.6kb",
```
- **Batch efficiency**: Compare `client_batches.received` with `client_batches.requested`
Metrics related to call status codes:
| Metric | Description |
            "avg_nanos": 2
| `started` | Number of server calls started |
```
This returns metrics for all nodes. To get metrics for a specific node:
            "count": 6,
          },
            "count": 3,
| `request_bytes` | Size statistics for requests received by servers (min, max, avg, sum) |
        "client_batches": {
            "avg": "4.2kb",
          },
  "cluster_stats": {
        "request": "5.9kb",
```
          "completed": 6,
### Performance Monitoring
            "avg": "2.1ms",
          "request_bytes": {
            "avg_bytes": 4361
            "min_nanos": 0,
            "min_nanos": 0,
        "response": "24.6kb",
```bash
        "response": "24.6kb",
indices:data/read/search[phase/query] TVk0SciMQtSwplV6rQwyMA:2166 TVk0SciMQtSwplV6rQwyMA:2165 stream-transport 1754082449786 21:07:29  168.4ms      127.0.0.1 node-1
            "sum": "6.4ms",
- Average durations and throughput
        "started": 6,
            "min_nanos": 6,
        "avg_processing_time_nanos": 34
      "calls": {
            "sum": "24.6kb",
          "started": 3,
        "received": 6,
The response includes a `cluster_stats` section with aggregated metrics for:
          "started": 6,
          "arrow_peak": "48kb",
            "min": "1022b",
| `requested` | Number of batches requested by clients |
            "min": "1022b",
Streaming transport tasks can be monitored using the existing Tasks API:
```
| Metric | Description |
          "server_channels_active": 1
### Throughput Analysis
### Error Detection
| `received_bytes` | Size statistics for batches received by clients (min, max, avg, sum) |
      "batches": {
            "min": "525.4micros",
    "node_id": {
| `response` | Total size of responses received by clients (with human-readable format) |
            "OK": 6
            "max_bytes": 4361,
| `direct_memory_bytes` | Current direct memory usage in bytes |
            "max_bytes": 1022,
### Client Call Metrics
| `server_threads_total` | Total number of server threads |
          "response_bytes": 25276
            "max": "743.7ms",
    "server": {
      "batches": {
## Cluster-Level Metrics
## Example Response
            "avg": "2ms",
| `duration` | Duration statistics for server calls (min, max, avg, sum) |
```
| `server_threads_active` | Number of active server threads |
        "duration_nanos": 1019,
| Metric | Description |
        "status": {
          "received": 6,
    },
| Metric | Description |
|--------|-------------|
Metrics related to resource usage:
            "sum_nanos": 12,
        "started": 6,
| Metric | Description |
            "min_nanos": 9,
Metrics related to server-side batch operations:
          "arrow_peak_bytes": 49152,
| `arrow_allocated` | Current Arrow memory allocation (human-readable format) |
          "client_threads_active": 0,
            "max_nanos": 9,
            "count": 6,
          "sent_bytes": {
| `processing_time` | Time statistics for processing and sending batches (min, max, avg, sum) |
| `response` | Total size of responses sent by servers (with human-readable format) |
| `server.{status}` | Count of server calls completed with each status code (OK, CANCELLED, UNAVAILABLE, etc.) |
| `client.{status}` | Count of client calls completed with each status code (OK, CANCELLED, UNAVAILABLE, etc.) |
            "avg_nanos": 169
      }
            "avg_bytes": 4212
          },
            "sum_bytes": 13083,
            "sum": "12.1ms",
  }
          "arrow_allocated_bytes": 0,
| `response_bytes` | Total size of responses received by clients (in bytes) |
| `request_bytes` | Size statistics for requests sent by clients (min, max, avg, sum) |
          "arrow_allocated": "0b",
- Client calls and batches (aggregated across all nodes)
### Server Call Metrics
        "server_batches": {
          "processing_time": {
      "name": "node_name",
        "received_bytes": 25276,
- **Request throughput**: Monitor `client_calls.started` and `server_calls.started` rates
            "sum": "1s",
        "sent_bytes": 25276,
        "duration_nanos": 556,
Metrics related to client-side calls:
Note: All duration and size fields include both human-readable formats (e.g., "1s", "24.6kb") and raw values in nanoseconds/bytes.
            "sum_bytes": 25276,
- **Memory pressure**: Monitor `arrow_allocated_bytes` and `arrow_peak_bytes`
```json
          "duration": {
            "min": "9ms",
  "cluster_name": "opensearch",
### Server Batch Metrics
        "duration": "556ms",
Metrics can be accessed using the Flight Stats API:
        "avg_duration_nanos": 92,
        "sent": 6,
| `received` | Number of batches received by clients |
## Interpreting Metrics
          "direct_memory": "120.7mb",
          "sent": 3,
|--------|-------------|
            "count": 3,
      "flight_metrics": {
- **Resource exhaustion**: Watch for `RESOURCE_EXHAUSTED` status counts
        "completed": 6,
          },
          },
}
        "avg_duration": "92.6ms",
        "avg_processing_time": "34.6ms",
```
| `direct_memory` | Current direct memory usage (human-readable format) |
| `client_threads_total` | Total number of client threads |
          "completed": 3,
{
            "max_bytes": 1022,
        "resources": {
          "client_channels_active": 2,
          }
The Arrow Flight RPC plugin provides comprehensive metrics to monitor the performance and health of the transport. These metrics are available through the Flight Stats API.
| `completed` | Number of client calls completed |
        "completed": 6,
            "sum_nanos": 1019,
        "requested": 6,
        "response_bytes": 25276
        "request": "5.9kb",
|--------|-------------|
```
      }
            "max": "5.3ms",
            "avg": "4.1kb",
            "count": 6,
            "sum_nanos": 6,
- Server calls and batches (aggregated across all nodes)
            "avg_nanos": 49
          "request_bytes": {
      },
| `arrow_allocated_bytes` | Current Arrow memory allocation in bytes |
action                                task_id                     parent_task_id              type             start_time    timestamp running_time ip        node
| `sent` | Number of batches sent by servers |
            "avg_bytes": 1022
      }
        "avg_duration_nanos": 169,
### Client Batch Metrics
| `client_threads_active` | Number of active client threads |
  "nodes": {
      },
            "min_bytes": 3477,
        },
| `processing_time` | Time statistics for processing received batches (min, max, avg, sum) |
## Accessing Metrics
          "received_bytes": {
| `server_channels_active` | Number of active server channels |
            "avg": "169.8ms",
            "sum": "12.7kb",
    }
            "max": "4.2kb",
GET /_flight/stats
| `client_channels_active` | Number of active client channels |
            "min": "3.3kb",
Metrics related to client-side batch operations:
            "avg_nanos": 2
            "min": "4.2kb",
            "count": 6,
          "duration": {
      "streamAddress": "localhost:9400",
Metrics are organized into the following categories:
            "max_nanos": 743,
|--------|-------------|
```
        "server_calls": {
  },
            "avg": "49.3ms",
            "sum_bytes": 6132,
            "min_bytes": 1022,
            "min_bytes": 4361,
        "client_calls": {
            "avg": "1022b",
indices:data/read/search              TVk0SciMQtSwplV6rQwyMA:2165 -                           transport        1754082449785 21:07:29  169.5ms      127.0.0.1 node-1
        },
- **Cancelled operations**: Check `CANCELLED` status counts
            "max_nanos": 5,
| `sent_bytes` | Size statistics for batches sent by servers (min, max, avg, sum) |
            "sum_bytes": 3066,
            "count": 3,
            "max": "135.7ms",
          "response": "12.7kb",
        "avg_processing_time": "2ms",
| Metric | Description |
| `arrow_peak` | Peak Arrow memory allocation (human-readable format) |
The API also provides cluster-level aggregated metrics that combine data from all nodes:
            "min": "6ms",
        "request_bytes": 6132,
          "server_threads_total": 0,
- **Failed calls**: Monitor non-OK status counts in `status.client` and `status.server`
          "client": {
    }
GET /_flight/stats
| `duration` | Duration statistics for client calls (min, max, avg, sum) |
|--------|-------------|
            "OK": 3
          },
        "request_bytes": 6132,
```
          "server_threads_active": 0,
| `response_bytes` | Total size of responses sent by servers (in bytes) |
            "avg_bytes": 1022
            "sum": "147.9ms",
            "sum": "5.9kb",
- **High latency**: Check `duration` metrics for client and server calls
- **Thread pool saturation**: Check `client_thread_utilization_percent` and `server_thread_utilization_percent`
