## How it fits in
## Key classes
Central hub plugin. Implements `ExtensiblePlugin` to discover and wire all analytics extensions at startup.
# analytics-engine
- **`AnalyticsPlugin`** — The `ExtensiblePlugin` hub. Handles discovery, wiring, and Guice binding.
4. Binds `QueryPlanExecutor` and `SchemaProvider` into Guice via lazy providers, so front-end transport actions can `@Inject` them.
## What it does
- **`OpenSearchSchemaBuilder`** — Converts `ClusterState` index mappings into Calcite tables with typed columns.
3. Calls `QueryPlanExecutorPlugin.createExecutor(backEnds)` to build the `QueryPlanExecutor`.
2. Creates the `SchemaProvider` (via `OpenSearchSchemaBuilder`, which converts OpenSearch `ClusterState` index mappings into a Calcite `SchemaPlus`).
1. During `loadExtensions`, discovers all `QueryPlanExecutorPlugin`, `AnalyticsBackEndPlugin`, and `AnalyticsFrontEndPlugin` implementations from extending plugins.
This is the stable plugin name that all extending plugins declare in `extendedPlugins`. It owns no query language logic and no execution logic — it just discovers, wires, and exposes the components that other plugins provide.
