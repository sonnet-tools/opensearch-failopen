| `ParquetDataFusionIT` | Sanity check: creates a parquet-format index, validates settings are persisted, ingests docs, runs a simple search |
    (client, dataset, queryBody) -> {
  -Dtests.jvm.argline="-Djava.library.path=$NATIVE_LIB_DIR -Dopensearch.experimental.feature.pluggable.dataformat.enabled=true" \
        return assertOkAndParse(response, "PPL query");
### Validation Strategies
- `Dataset` / `DatasetProvisioner` / `DatasetQueryRunner` — generic test infrastructure. Any new dataset can plug in by adding a directory under `resources/datasets/{name}/`.
### Rust toolchain (native library)
    [value1, value2, ...],
    mapping_index1.json       # mapping for first index
Tests support validating query results against expected responses stored in `src/test/resources/datasets/{name}/{language}/expected/q{N}.json`.
```java
# DSL ClickBench
- `AnalyticsRestTestCase` — handles cluster preservation, resource loading, JSON escaping, and assertion helpers. Extend this for any new integration test.
DatasetQueryRunner              ← auto-discovers queries and runs them against a cluster
|------|-------------|
```
```
- Single index: `mapping.json`, `bulk.json`
    ppl/expected/q1.json ...  # expected responses (optional)
```bash
        // execute query
```
Dataset myDataset = new Dataset("myDatasetName", indexes);
./gradlew :sandbox:qa:analytics-engine-rest:integTest -Dsandbox.enabled=true \
    client(), dataset, "ppl", "ppl", queryNumbers,
## Test Classes
For datasets with multiple indexes (e.g., for joins, unions):
# Analytics Engine REST Integration Tests
Dataset myDataset = new Dataset("myDatasetName", "index1", "index2", "index3");
```bash
```
- Parquet indexing uses the composite data format framework: `index.composite.primary_data_format = parquet`
### Expected Response Format
  --tests "org.opensearch.analytics.qa.ParquetDataFusionIT"
| `DslClickBenchIT` | Runs ClickBench DSL queries via `_search` → dsl-query-executor → Calcite → Substrait → DataFusion |
The sandbox requires JDK 25 or newer:
{
NATIVE_LIB_DIR=$(pwd)/sandbox/libs/dataformat-native/rust/target/release
REST-based integration tests for the analytics engine, running against a live OpenSearch cluster with sandbox plugins installed.
    dsl/q1.json ... qN.json   # DSL queries (auto-discovered)
  {name}/
## Notes
```
    ppl/q1.ppl ... qN.ppl     # queries using multiple indexes
datasets/
    dsl/expected/q1.json ...  # expected responses (optional)
  -x javadoc -x test -x missingJavadoc
- Multi-index: `mapping_{indexName}.json`, `bulk_{indexName}.json`
  --tests "org.opensearch.analytics.qa.DslClickBenchIT"
### Single-Index Dataset
```java
The cluster configuration (plugins, feature flag, native library path) is defined in `build.gradle` — no manual setup needed.
- **`SKIP_VALIDATION`** — Only checks for 200 OK response, no content validation
./gradlew :sandbox:libs:dataformat-native:buildRustLibrary -Dsandbox.enabled=true
**Resource Naming Convention:**
```
```
    mapping.json              # index mapping + settings
The DataFusion backend requires a native Rust library. Build it once (re-run after Rust code changes):
```
| `PplClickBenchIT` | Runs ClickBench PPL queries via `/_analytics/ppl` → test-ppl-frontend → analytics-engine → Calcite → Substrait → DataFusion |
```
```
- `ClickBenchTestHelper` — thin wrapper that declares the ClickBench dataset descriptor.
    ppl/expected/q1.json ...  # expected responses (optional)
    ppl/q1.ppl ... qN.ppl     # PPL queries (auto-discovered)
datasets/
```
```
- DSL path: `_search` → dsl-query-executor → Calcite planning → Substrait → DataFusion
- Parses expected JSON using OpenSearch's `XContentHelper`
To add a new dataset, create a directory under `src/test/resources/datasets/{name}/` with this structure:
### External cluster (restTest) — manually provisioned
// Using varargs
- Extracts `rows` or `datarows` from both responses
- The `pluggable.dataformat.enabled` feature flag must be set at cluster startup (already configured for `integTest`)
### Running individual tests
```bash
```
## Running Tests
## Architecture
- Returns `null` if validation passes, error message if it fails
  "rows": [
# Custom cluster
# PPL ClickBench
```
Then declare the dataset in Java:
```bash
- `PplClickBenchIT` runs all discovered queries (39 of 43) with `PASS_ON_MISSING` strategy and skipping SKIP_QUERIES.
## Adding a New Dataset
- Queries skipped: Q19, Q29, Q40, Q43 (PPL frontend gaps, not validation issues)
./gradlew :sandbox:qa:analytics-engine-rest:restTest -Dsandbox.enabled=true -PrestCluster=host:port
### Managed testClusters (integTest) — auto-provisioned
./gradlew :sandbox:qa:analytics-engine-rest:restTest -Dsandbox.enabled=true
Dataset                         ← descriptor for a test dataset (mapping, bulk data, queries)
`DatasetProvisioner.provision(client, myDataset)` creates all indexes with parquet data format and ingests the bulk data. `DatasetQueryRunner.discoverQueryNumbers(myDataset, "dsl")` auto-discovers all query files.
Configure via `ExpectedResponseStrategy` constant in test classes:
    bulk_index2.json          # bulk data for second index
    bulk_index1.json          # bulk data for first index
    bulk.json                 # bulk-indexable documents (NDJSON)
└── PplClickBenchIT             ← PPL queries via /_analytics/ppl → DataFusion
export JAVA_HOME=/Library/Java/JavaVirtualMachines/jdk-25.jdk/Contents/Home  # macOS example
```
```
### Usage in Tests
## Expected Response Validation
# Default: localhost:9200
- PPL path: `/_analytics/ppl` → test-ppl-frontend → analytics-engine → Calcite → Substrait → DataFusion
ClickBenchTestHelper            ← ClickBench dataset constants
### Multi-Index Dataset
    },
// Using list
| Test | Description |
- Only Q1, Q2 has an expected response file; validation passes for Q1 & Q2 and skips for others except from response 200 validation.
## Prerequisites
./gradlew publishToMavenLocal -Dsandbox.enabled=true -x test -x javadoc
```json
```java
./gradlew :sandbox:qa:analytics-engine-rest:integTest -Dsandbox.enabled=true \
./gradlew run -Dsandbox.enabled=true \
    STRATEGY  // pass strategy to enable validation
    [value1, value2, ...]
Start a cluster manually (see below), then run tests against it:
`ResponseValidator.validate()` compares actual vs expected responses:
DatasetProvisioner              ← provisions any dataset into a parquet-backed index
- **`FAIL_ON_MISSING`** — Fails test if expected response file is missing
AnalyticsRestTestCase           ← abstract base (cluster config, helpers)
Note: PPL tests via `/_analytics/ppl` require the `test-ppl-frontend` plugin. It is included in the `integTest` cluster config and can also be added to `./gradlew run` via `-PinstalledPlugins`.
private static final ExpectedResponseStrategy STRATEGY = ExpectedResponseStrategy.PASS_ON_MISSING;
  {name}/
### Starting a cluster manually
# Parquet sanity
List<String> failures = DatasetQueryRunner.runQueries(
The `integTest` task auto-starts a single-node cluster with all required plugins and runs the tests:
List<String> indexes = Arrays.asList("index1", "index2", "index3");
├── ParquetDataFusionIT         ← parquet indexing sanity + index settings validation
### Validation Method
Then declare the dataset in Java:
./gradlew :sandbox:qa:analytics-engine-rest:integTest -Dsandbox.enabled=true \
Dataset myDataset = new Dataset("myDatasetName", "my_index_name");
  --tests "org.opensearch.analytics.qa.PplClickBenchIT"
- Compares row count, column count, and values with numeric tolerance (1e-9)
./gradlew :sandbox:qa:analytics-engine-rest:integTest -Dsandbox.enabled=true
- **`PASS_ON_MISSING`** — Validates if expected response exists, passes if it doesn't
### JDK 25+
}
```bash
);
    mapping_index2.json       # mapping for second index
  ]
  -PinstalledPlugins="['analytics-engine', 'parquet-data-format', 'analytics-backend-datafusion', 'analytics-backend-lucene', 'dsl-query-executor', 'composite-engine', 'test-ppl-frontend']" \
├── DslClickBenchIT             ← DSL queries via _search → DataFusion
```bash
