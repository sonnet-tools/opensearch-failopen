```
```
| `ParquetDataFusionIT` | Sanity check: creates a parquet-format index, validates settings are persisted, ingests docs, runs a simple search |
    (client, dataset, queryBody) -> {
./gradlew :sandbox:qa:analytics-engine-rest:restTest -Dsandbox.enabled=true -PrestCluster=host:port
```json
| `PplClickBenchIT` | Runs ClickBench PPL queries via `/_analytics/ppl` → test-ppl-frontend → analytics-engine → Calcite → Substrait → DataFusion |
  -PinstalledPlugins="['analytics-engine', 'parquet-data-format', 'analytics-backend-datafusion', 'analytics-backend-lucene', 'dsl-query-executor', 'composite-engine', 'test-ppl-frontend']" \
```bash
export JAVA_HOME=/Library/Java/JavaVirtualMachines/jdk-25.jdk/Contents/Home  # macOS example
DatasetQueryRunner              ← auto-discovers queries and runs them against a cluster
```
// Using varargs
### Starting a cluster manually
### Usage in Tests
}
For datasets with multiple indexes (e.g., for joins, unions):
```bash
- Single index: `mapping.json`, `bulk.json`
DatasetProvisioner              ← provisions any dataset into a parquet-backed index
- Queries skipped: Q19, Q29, Q40, Q43 (PPL frontend gaps, not validation issues)
Then declare the dataset in Java:
```bash
```bash
  -x javadoc -x test -x missingJavadoc
    mapping.json              # index mapping + settings
- Parquet indexing uses the composite data format framework: `index.composite.primary_data_format = parquet`
# PPL ClickBench
## Running Tests
- `AnalyticsRestTestCase` — handles cluster preservation, resource loading, JSON escaping, and assertion helpers. Extend this for any new integration test.
  "rows": [
    STRATEGY  // pass strategy to enable validation
├── ParquetDataFusionIT         ← parquet indexing sanity + index settings validation
```
ClickBenchTestHelper            ← ClickBench dataset constants
- `ClickBenchTestHelper` — thin wrapper that declares the ClickBench dataset descriptor.
- PPL path: `/_analytics/ppl` → test-ppl-frontend → analytics-engine → Calcite → Substrait → DataFusion
## Test Classes
- DSL path: `_search` → dsl-query-executor → Calcite planning → Substrait → DataFusion
├── DslClickBenchIT             ← DSL queries via _search → DataFusion
./gradlew :sandbox:qa:analytics-engine-rest:restTest -Dsandbox.enabled=true
- The `pluggable.dataformat.enabled` feature flag must be set at cluster startup (already configured for `integTest`)
REST-based integration tests for the analytics engine, running against a live OpenSearch cluster with sandbox plugins installed.
# DSL ClickBench
- Extracts `rows` or `datarows` from both responses
    ppl/expected/q1.json ...  # expected responses (optional)
### JDK 25+
        return assertOkAndParse(response, "PPL query");
Note: PPL tests via `/_analytics/ppl` require the `test-ppl-frontend` plugin. It is included in the `integTest` cluster config and can also be added to `./gradlew run` via `-PinstalledPlugins`.
| Test | Description |
# Custom cluster
```
|------|-------------|
./gradlew run -Dsandbox.enabled=true \
```
datasets/
### Expected Response Format
```
List<String> indexes = Arrays.asList("index1", "index2", "index3");
    mapping_index1.json       # mapping for first index
```java
    ppl/q1.ppl ... qN.ppl     # PPL queries (auto-discovered)
    },
- Parses expected JSON using OpenSearch's `XContentHelper`
    dsl/expected/q1.json ...  # expected responses (optional)
Dataset myDataset = new Dataset("myDatasetName", indexes);
Tests support validating query results against expected responses stored in `src/test/resources/datasets/{name}/{language}/expected/q{N}.json`.
The cluster configuration (plugins, feature flag, native library path) is defined in `build.gradle` — no manual setup needed.
List<String> failures = DatasetQueryRunner.runQueries(
  --tests "org.opensearch.analytics.qa.PplClickBenchIT"
- **`FAIL_ON_MISSING`** — Fails test if expected response file is missing
  --tests "org.opensearch.analytics.qa.ParquetDataFusionIT"
    ppl/expected/q1.json ...  # expected responses (optional)
- Returns `null` if validation passes, error message if it fails
datasets/
        // execute query
    bulk.json                 # bulk-indexable documents (NDJSON)
Configure via `ExpectedResponseStrategy` constant in test classes:
  ]
Dataset                         ← descriptor for a test dataset (mapping, bulk data, queries)
- Compares row count, column count, and values with numeric tolerance (1e-9)
    mapping_index2.json       # mapping for second index
- `Dataset` / `DatasetProvisioner` / `DatasetQueryRunner` — generic test infrastructure. Any new dataset can plug in by adding a directory under `resources/datasets/{name}/`.
- `PplClickBenchIT` runs all discovered queries (39 of 43) with `PASS_ON_MISSING` strategy and skipping SKIP_QUERIES.
./gradlew :sandbox:libs:dataformat-native:buildRustLibrary -Dsandbox.enabled=true
```bash
```java
```
### External cluster (restTest) — manually provisioned
```
    ppl/q1.ppl ... qN.ppl     # queries using multiple indexes
### Rust toolchain (native library)
### Multi-Index Dataset
```
```bash
NATIVE_LIB_DIR=$(pwd)/sandbox/libs/dataformat-native/rust/target/release
private static final ExpectedResponseStrategy STRATEGY = ExpectedResponseStrategy.PASS_ON_MISSING;
```
    [value1, value2, ...],
- Multi-index: `mapping_{indexName}.json`, `bulk_{indexName}.json`
### Validation Method
    bulk_index1.json          # bulk data for first index
### Validation Strategies
The DataFusion backend requires a native Rust library. Build it once (re-run after Rust code changes):
./gradlew :sandbox:qa:analytics-engine-rest:integTest -Dsandbox.enabled=true \
./gradlew publishToMavenLocal -Dsandbox.enabled=true -x test -x javadoc
## Expected Response Validation
### Single-Index Dataset
AnalyticsRestTestCase           ← abstract base (cluster config, helpers)
### Running individual tests
The `integTest` task auto-starts a single-node cluster with all required plugins and runs the tests:
```
  {name}/
  {name}/
./gradlew :sandbox:qa:analytics-engine-rest:integTest -Dsandbox.enabled=true \
./gradlew :sandbox:qa:analytics-engine-rest:integTest -Dsandbox.enabled=true
{
`ResponseValidator.validate()` compares actual vs expected responses:
```
# Default: localhost:9200
    bulk_index2.json          # bulk data for second index
  -Dtests.jvm.argline="-Djava.library.path=$NATIVE_LIB_DIR -Dopensearch.experimental.feature.pluggable.dataformat.enabled=true" \
└── PplClickBenchIT             ← PPL queries via /_analytics/ppl → DataFusion
Dataset myDataset = new Dataset("myDatasetName", "index1", "index2", "index3");
    dsl/q1.json ... qN.json   # DSL queries (auto-discovered)
  --tests "org.opensearch.analytics.qa.DslClickBenchIT"
Dataset myDataset = new Dataset("myDatasetName", "my_index_name");
- Only Q1, Q2 has an expected response file; validation passes for Q1 & Q2 and skips for others except from response 200 validation.
# Parquet sanity
    [value1, value2, ...]
Then declare the dataset in Java:
- **`PASS_ON_MISSING`** — Validates if expected response exists, passes if it doesn't
| `DslClickBenchIT` | Runs ClickBench DSL queries via `_search` → dsl-query-executor → Calcite → Substrait → DataFusion |
The sandbox requires JDK 25 or newer:
# Analytics Engine REST Integration Tests
To add a new dataset, create a directory under `src/test/resources/datasets/{name}/` with this structure:
);
```
## Prerequisites
`DatasetProvisioner.provision(client, myDataset)` creates all indexes with parquet data format and ingests the bulk data. `DatasetQueryRunner.discoverQueryNumbers(myDataset, "dsl")` auto-discovers all query files.
Start a cluster manually (see below), then run tests against it:
- **`SKIP_VALIDATION`** — Only checks for 200 OK response, no content validation
    client(), dataset, "ppl", "ppl", queryNumbers,
## Notes
## Adding a New Dataset
./gradlew :sandbox:qa:analytics-engine-rest:integTest -Dsandbox.enabled=true \
**Resource Naming Convention:**
## Architecture
```
### Managed testClusters (integTest) — auto-provisioned
```
// Using list
```java
