| `DatafusionReader` | Per-shard point-in-time snapshot of data files. Wraps a `ReaderHandle`.                                                                                                                                                                |
│          (RelNode → Substrait bytes → DatafusionQuery)          │
│    NativeBridge ──→ rust       │
│    ├── searcher(ExecutionContext) → DatafusionSearchExecEngine   │
│    ├── createComponents() → DataFusionService (node-level)      │
└──────────────┬──────────────────────────────────────────────────┘
| `DataFusionPlugin` | Plugin entry point. Implements `SearchBackEndPlugin` (server SPI — provides `createReaderManager` for shard-level data access) and `AnalyticsSearchBackendPlugin` (analytics-framework SPI — provides `searcher` for query execution).
| `DatafusionContext` | Execution context carrying the query plan, `DatafusionSearcher`, optional `IndexFilterTree`, native runtime pointer, result `StreamHandle` etc. Implements `SearchExecutionContext<DatafusionSearcher>`.                               |
│  Routes query plan fragments to back-ends via DefaultPlanExecutor│
│  ExtensiblePlugin — discovers AnalyticsSearchBackendPlugin SPIs │
│  Native layer (JNI):                                            │
## Architecture
┌─────────────────────────────────────────────────────────────────┐
│      → DatafusionSearchExecEngine.execute()                     │
│      createDatafusionReader / closeDatafusionReader              │
│    └── createReaderManager(format, shardPath)                   │
│  Execution flow:                                                │
│  analytics-engine (hub)                                         │
│            → DatafusionReaderManager                            │
│      → DatafusionSearchExecEngine.prepare()                     │
│                                                                 │
| `DatafusionSearcher` | Executes the Substrait plan against a native reader via `NativeBridge.executeQuery()`. Owns no resources - reader lifecycle is managed by `DatafusionReaderManager`.                                                                   |
│          → DatafusionResultStream (Arrow record batches)        │
│                                                                 │
```
|---|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
└─────────────────────────────────────────────────────────────────┘
│      createGlobalRuntime / closeGlobalRuntime                   │
| `DatafusionReaderManager` | Manages `DatafusionReader` lifecycle per `CatalogSnapshot`. Handles refresh (swap in new reader) and deletion (close old reader).                                                                                                      |
## Key classes
| `NativeRuntimeHandle` | Thread-safe wrapper around the native runtime pointer with liveness checks.                                                                                                                                                            |
| `DataFusionService` | Node-level lifecycle service. Loads the native JNI library, creates the Tokio runtime , global runtime environment and memory pool. Shared by all per-shard engines.                                                                   |
| Class | Role                                                                                                                                                                                                                                   |
│      executeQuery / streamNext / streamClose                    │
| `DatafusionSearchExecEngine` | Per-query engine. `prepare()` converts the Calcite `RelNode` to a Substrait plan; `execute()` delegates to `DatafusionSearcher` and returns a `DatafusionResultStream`.                                                                |
┌─────────────────────────────────────────────────────────────────┐
               │ SPI (extendedPlugins = ['analytics-engine'])
# analytics-backend-datafusion
│          → DatafusionSearcher.search(DatafusionContext)          │
│    ExecutionContext                                              │
               ▼
│                                                                 │
```
│  analytics-backend-datafusion                                   │
│  DataFusionPlugin                                               │
DataFusion native execution engine plugin for the OpenSearch analytics framework. Implements `SearchBackEndPlugin` (server SPI for shard-level reader management) and `AnalyticsSearchBackendPlugin` (analytics-framework SPI for query execution) to execute query plan fragments via a Rust/DataFusion runtime over JNI.
│              → NativeBridge.executeQuery() [JNI]                │
