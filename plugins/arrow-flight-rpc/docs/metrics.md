          }
The response includes a `cluster_stats` section with aggregated metrics for:
            "min": "6ms",
```
        "avg_duration_nanos": 169,
| `response_bytes` | Total size of responses sent by servers (in bytes) |
}
        "duration_nanos": 556,
```
      "batches": {
```bash
            "sum": "5.9kb",
          }
      }
          "processing_time": {
            "min": "3.3kb",
indices:data/read/search[phase/query] TVk0SciMQtSwplV6rQwyMA:2166 TVk0SciMQtSwplV6rQwyMA:2165 stream-transport 1754082449786 21:07:29  168.4ms      127.0.0.1 node-1
```
```
        "response_bytes": 25276
GET /_flight/stats
| `arrow_allocated` | Current Arrow memory allocation (human-readable format) |
        }
  "cluster_stats": {
          "response_bytes": 13083
| `response` | Total size of responses received by clients (with human-readable format) |
      "name": "node_name",
          "client_channels_active": 2,
            "min": "4.2kb",
        "avg_duration": "92.6ms",
| `client_threads_active` | Number of active client threads |
Metrics related to server-side calls:
|--------|-------------|
          "received": 6,
        },
        "avg_processing_time": "2ms",
            "sum": "12.7kb",
| `started` | Number of server calls started |
          "arrow_allocated": "0b",
        "avg_duration_nanos": 92,
        "client_calls": {
            "sum": "147.9ms",
```
          "request_bytes": {
      "batches": {
            "max_bytes": 1022,
| `arrow_peak_bytes` | Peak Arrow memory allocation in bytes |
      "calls": {
### Client Batch Metrics
        "server_calls": {
- **Batch efficiency**: Compare `client_batches.received` with `client_batches.requested`
            "count": 3,
        "started": 6,
            "min_nanos": 6,
        "client_batches": {
          },
          "server": {
          "direct_memory_bytes": 126642920,
            "avg_bytes": 4361
| `direct_memory_bytes` | Current direct memory usage in bytes |
            "max_nanos": 135,
        "status": {
- Average durations and throughput
          "response_bytes": 25276
GET /_flight/stats
            "min": "9ms",
            "avg": "2.1ms",
            "avg_bytes": 1022
            "avg_nanos": 2
      "flight_metrics": {
### Client Call Metrics
        },
            "avg_nanos": 2
        "response": "24.6kb",
        "sent_size": "24.6kb",
            "sum": "24.6kb",
            "sum_bytes": 3066,
The Arrow Flight RPC plugin provides comprehensive metrics to monitor the performance and health of the transport. These metrics are available through the Flight Stats API.
| Metric | Description |
| `received` | Number of batches received by clients |
          "received_bytes": {
            "avg_bytes": 4212
## Metrics Structure
  "nodes": {
            "count": 6,
  }
          "requested": 6,
Metrics related to client-side calls:
- **Thread pool saturation**: Check `client_thread_utilization_percent` and `server_thread_utilization_percent`
          "completed": 3,
            "max_nanos": 743,
| `duration` | Duration statistics for server calls (min, max, avg, sum) |
| Metric | Description |
      },
Note: All duration and size fields include both human-readable formats (e.g., "1s", "24.6kb") and raw values in nanoseconds/bytes.
          "client_threads_active": 0,
| `arrow_peak` | Peak Arrow memory allocation (human-readable format) |
            "max": "9.5ms",
| `request_bytes` | Size statistics for requests received by servers (min, max, avg, sum) |
          },
## Example Response
# Arrow Flight RPC Metrics
```
  },
|--------|-------------|
| `request_bytes` | Size statistics for requests sent by clients (min, max, avg, sum) |
            "count": 6,
            "avg": "2ms",
            "sum_bytes": 13083,
| `requested` | Number of batches requested by clients |
            "max": "5.3ms",
        "avg_processing_time_nanos": 2
| `started` | Number of client calls started |
```
- **Request throughput**: Monitor `client_calls.started` and `server_calls.started` rates
            "sum": "12.1ms",
### Server Call Metrics
| `response` | Total size of responses sent by servers (with human-readable format) |
      },
        "server_batches": {
            "avg": "4.1kb",
        "request_bytes": 6132,
          "direct_memory": "120.7mb",
- **Data throughput**: Track `client_calls.request_bytes` and `server_batches.sent_bytes` rates
Streaming transport tasks can be monitored using the existing Tasks API:
{
    }
          "arrow_peak": "48kb",
          "sent": 3,
          "request_bytes": {
            "max": "1022b",
| `server_threads_active` | Number of active server threads |
            "sum_bytes": 6132,
| `processing_time` | Time statistics for processing and sending batches (min, max, avg, sum) |
            "count": 6,
          "client": {
- **Memory pressure**: Monitor `arrow_allocated_bytes` and `arrow_peak_bytes`
### Performance Monitoring
### Server Batch Metrics
        "received": 6,
- **Resource exhaustion**: Watch for `RESOURCE_EXHAUSTED` status counts
    "client": {
| `arrow_allocated_bytes` | Current Arrow memory allocation in bytes |
## Monitoring Streaming Tasks
            "max": "743.7ms",
        "avg_processing_time_nanos": 34
            "OK": 6
| `client_channels_active` | Number of active client channels |
This returns metrics for all nodes. To get metrics for a specific node:
    "server": {
Metrics are organized into the following categories:
| `completed` | Number of server calls completed |
            "sum_nanos": 147,
```
- **Cancelled operations**: Check `CANCELLED` status counts
          "server_threads_total": 0,
Metrics related to call status codes:
          "server_channels_active": 1
          "response": "24.6kb",
            "avg_bytes": 1022
          },
          }
- **High latency**: Check `duration` metrics for client and server calls
### Resource Metrics
          "arrow_peak_bytes": 49152,
            "sum_nanos": 1019,
            "avg_nanos": 169
            "max_bytes": 4361,
            "max_bytes": 4361,
| `direct_memory` | Current direct memory usage (human-readable format) |
| `sent` | Number of batches sent by servers |
            "count": 6,
        "requested": 6,
indices:data/read/search              TVk0SciMQtSwplV6rQwyMA:2165 -                           transport        1754082449785 21:07:29  169.5ms      127.0.0.1 node-1
            "min_bytes": 1022,
| `response_bytes` | Total size of responses received by clients (in bytes) |
            "max": "4.2kb",
| `server_threads_total` | Total number of server threads |
```
      "streamAddress": "localhost:9400",
        "request": "5.9kb",
            "avg": "1022b",
        },
| Metric | Description |
            "min_nanos": 9,
        "completed": 6,
          "started": 6,
            "min_bytes": 3477,
        "sent_bytes": 25276,
| `server.{status}` | Count of server calls completed with each status code (OK, CANCELLED, UNAVAILABLE, etc.) |
      }
- **Failed calls**: Monitor non-OK status counts in `status.client` and `status.server`
            "sum": "6.4ms",
            "max": "4.2kb",
            "max_bytes": 1022,
          "completed": 6,
      }
            "min": "352micros",
        "response_bytes": 25276
| `client_threads_total` | Total number of client threads |
GET /_flight/stats/{node_id}
          "duration": {
          "processing_time": {
| `duration` | Duration statistics for client calls (min, max, avg, sum) |
        "started": 6,
        "avg_processing_time": "34.6ms",
            "count": 3,
            "min": "1022b",
        "duration": "1s",
| Metric | Description |
## Cluster-Level Metrics
            "min": "525.4micros",
```json
        "response": "24.6kb",
| `completed` | Number of client calls completed |
        "duration_nanos": 1019,
Metrics related to client-side batch operations:
          "sent_bytes": {
        "request": "5.9kb",
    },
            "min_bytes": 1022,
| `client.{status}` | Count of client calls completed with each status code (OK, CANCELLED, UNAVAILABLE, etc.) |
| `server_channels_active` | Number of active server channels |
            "min_nanos": 0,
            "sum_nanos": 6,
        "avg_duration": "169.8ms",
action                                task_id                     parent_task_id              type             start_time    timestamp running_time ip        node
      "calls": {
        "sent": 6,
            "min_nanos": 0,
            "max_nanos": 9,
Metrics related to server-side batch operations:
The API also provides cluster-level aggregated metrics that combine data from all nodes:
| `received_bytes` | Size statistics for batches received by clients (min, max, avg, sum) |
        "request_bytes": 6132,
| `processing_time` | Time statistics for processing received batches (min, max, avg, sum) |
## Accessing Metrics
            "max": "1022b",
            "max_nanos": 5,
          },
        },
Metrics related to resource usage:
            "avg": "4.2kb",
## Interpreting Metrics
        },
            "min_bytes": 4361,
            "avg": "1022b",
Streaming tasks are identified by the `stream-transport` type:
            "OK": 3
          "started": 3,
  "cluster_name": "opensearch",
| Metric | Description |
curl "localhost:9200/_cat/tasks?v"
        "duration": "556ms",
| Metric | Description |
| `sent_bytes` | Size statistics for batches sent by servers (min, max, avg, sum) |
          "arrow_allocated_bytes": 0,
            "max": "135.7ms",
          },
- Server calls and batches (aggregated across all nodes)
            "avg_nanos": 49
        "completed": 6,
          "client_threads_total": 0,
            "sum": "2.9kb",
            "avg": "49.3ms",
            "sum_bytes": 25276,
### Throughput Analysis
            "avg": "169.8ms",
          "server_threads_active": 0,
|--------|-------------|
|--------|-------------|
          "duration": {
            "sum_nanos": 12,
        "received_bytes": 25276,
        "resources": {
            "min": "1022b",
|--------|-------------|
          },
        "received_size": "24.6kb",
          "response": "12.7kb",
### Error Detection
    }
|--------|-------------|
    "node_id": {
            "count": 3,
            "count": 3,
Metrics can be accessed using the Flight Stats API:
- Client calls and batches (aggregated across all nodes)
          },
### Status Metrics
```
            "sum": "1s",
