- **`QueryPlanExecutorPlugin`** — Factory for creating a `QueryPlanExecutor` from discovered back-end plugins.
## Dependencies
- **`AnalyticsEngineContext`** — Provides schema and aggregated operator table to front-ends for parsing and validation.
- **`QueryPlanExecutor`** — Executes a Calcite `RelNode` plan fragment and returns result rows.
- **`EngineBridge<T>`** — JNI/native boundary for engine-specific plan conversion and execution (e.g., Substrait → Arrow batches).
Shared library containing the SPI interfaces and core types for the analytics engine. All plugins depend on this library — it defines the contracts but contains no implementation logic.
## SPI Interfaces
# analytics-framework
## Core Types
- **`AnalyticsFrontEndPlugin`** — Marker interface for query language front-ends (PPL, SQL). Discovered by the hub for lifecycle tracking.
- **`AnalyticsBackEndPlugin`** — Extension point for native execution engines (DataFusion, Lucene, etc.). Exposes engine name, bridge, and capabilities.
Calcite and Arrow — no dependency on the OpenSearch server module.
- **`SchemaProvider`** — Functional interface that builds a Calcite `SchemaPlus` from cluster state.
