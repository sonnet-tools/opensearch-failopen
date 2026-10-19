- **`CompositeWriter`** — A composite `Writer` that delegates write, flush, and sync to each per-format writer.
3. Routes fields to the appropriate data format based on `FieldTypeCapabilities` declared by each format.
## Key classes
- **`CompositeIndexingExecutionEngine`** — Orchestrates indexing across primary and secondary format engines.
- **`CompositeDataFormatPlugin`** — The `ExtensiblePlugin` entry point. Discovers format plugins, validates settings, and creates the composite engine.
# composite-engine
| `index.composite.primary_data_format` | `"lucene"` | The authoritative format used for merge operations |
Format plugins (e.g., Parquet) extend this plugin by declaring `extendedPlugins = ['composite-engine']` in their `build.gradle` and implementing `DataFormatPlugin`. The `ExtensiblePlugin` SPI discovers them automatically during node bootstrap.
1. During `loadExtensions`, discovers all `DataFormatPlugin` implementations (e.g., Parquet, Arrow) via the `ExtensiblePlugin` SPI.
|---|---|---|
2. When composite indexing is enabled for an index, creates a `CompositeIndexingExecutionEngine` that delegates writes, refresh, and file management to each per-format engine.
- **`CompositeDataFormat`** — A `DataFormat` that wraps multiple per-format instances.
- **`CompositeDataFormatWriterPool`** — Thread-safe pool of `CompositeWriter` instances with lock-based checkout/release.
| Setting | Default | Description |
| `index.composite.secondary_data_formats` | `[]` | Additional formats that receive writes alongside the primary |
| `index.composite.enabled` | `false` | Activates composite indexing for the index |
- **`CompositeDocumentInput`** — Routes field additions to the appropriate per-format `DocumentInput` based on field type capabilities.
Sandbox plugin that orchestrates multi-format indexing across multiple data format engines behind a single `IndexingExecutionEngine` interface.
## What it does
## Index settings
4. Manages a pool of `CompositeWriter` instances for concurrent indexing with lock-based checkout/release semantics.
- **`RowIdGenerator`** — Generates monotonically increasing row IDs for cross-format document synchronization.
## How it fits in
