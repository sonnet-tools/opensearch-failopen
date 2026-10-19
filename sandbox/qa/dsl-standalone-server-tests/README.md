```
The dataset runner infrastructure (`Dataset` / `DatasetProvisioner` / `DatasetQueryRunner`) is shared:
```
`tags` is a single scalar value, which parquet accepts — isolating the multi-value array as the sole
### Default: self-provisioned cluster (`integTest`)
"index.composite.secondary_data_formats": ["lucene"]
```
```
`DslQueryTypeCatalog.all()`. Additional queries per type are auto-discovered as `dsl/q2.json`, ….
## Known engine gaps
## Why REST (and how it runs)
Tagged parameters are reported as **SKIPPED** with the reason in the test report instead of failing red,
## Running
provision time — this is the **single place** those settings live:
only when the parquet response matches the true answer, so any place parquet deviates surfaces as red.
`integTest` is wired into `check`, so it runs in the sandbox CI. A `restTest` task remains for running
                            effect and fails on per-item bulk ingest errors)
The DSL/analytics/parquet plugin stack targets **JDK 25**. An in-JVM `internalClusterTest` would load
with the same plugin stack). Defaults to `localhost:9200` (cluster name `runTask`).
`OpenSearchRestTestCase`, so the test JVM loads no plugins.
```
```bash
Each query type is a folder under `src/test/resources/datasets/<type>/`:
DslQueryTypeCatalog.java  ← one entry per type: type, family, Dataset, tags (known engine gaps)
provisioned into a parquet-backed index over REST and its response validated against a committed
DslSearchBehaviorIT.java  ← behavioral checks the golden sweep can't express (e.g. randomized-preference stability)
### Single-valued-tags variants
expected answer.
start. It is wired into `check`, so it also runs in the sandbox CI.
cause and confirming the query type itself is supported once `tags` is single-valued.
Each expected answer (`datasets/<type>/dsl/expected/q<N>.json`) is the **true answer** produced on a
DslResponseValidator.java ← compares a response against the committed expected answer
## Adding a query type
datasets/
Types the engine cannot serve today can be **tagged** on their entry in `DslQueryTypeCatalog` (e.g.
engine supports the shape.
time as more query types are covered.
    dsl/q1.json           # the DSL query body (auto-discovered as q<N>.json)
```
"index.pluggable.dataformat": "composite",
  --tests "org.opensearch.dsl.types.DslQueryTypesIT"
"index.composite.primary_data_format": "parquet",
## Layout — one resource folder per query type
                            (DSL uses provisionAndVerifyParquet: asserts the parquet format took
```
those plugins into the test JVM (pinning it to JDK 25); these tests instead talk HTTP to a cluster via
By default the module **self-provisions** that cluster: it applies `opensearch.testclusters` +
  term/
DslQueryTypesIT.java      ← provisions each type + runs its query, validates against the expected answer
`DatasetProvisioner` splices the canonical parquet/composite settings into each `mapping.json` at
```bash
`opensearch.standalone-rest-test` + `opensearch.rest-test`, and the `integTest` task boots a
# From the analytics-qa-fixtures test-jar (shared):
multiple values for field [tags] of type [keyword]"). The `*_scalar` variants are identical except
# Custom cluster
**self-provisioned** cluster (`integTest`, wired into `check`), with the option to target an external
# DSL Query-Type REST Tests
    dsl/expected/q1.json  # the expected answer (see below)
### Alternative: external cluster (`restTest`)
## What is asserted
## Java
Dataset.java              ← dataset descriptor (folder name == index name == query type)
Runs the same ITs against a server you started yourself (e.g. `./gradlew run -Dsandbox.enabled=true`
./gradlew :sandbox:qa:dsl-standalone-server-tests:restTest -Dsandbox.enabled=true
    mapping.json          # index mapping (keeps the literal "number_of_shards" token)
the same ITs against an external server you started yourself.
`integTest` boots its own cluster with the full plugin stack and runs the ITs against it — no server to
    bulk.json             # sample docs (NDJSON)
Create `datasets/<type>/` with `mapping.json` + `bulk.json` + `dsl/q1.json` + `dsl/expected/q1.json`
"index.pluggable.dataformat.enabled": true,
# Local to this module:
DatasetProvisioner.java   ← reads mapping/bulk, injects parquet settings, creates + ingests
provisions the dataset with parquet enabled, runs the query, and validates the parquet response against
`Dsl*` classes below are local to this module.
`term` / `bool` store `tags` as a multi-valued array, which parquet rejects at ingest ("Cannot accept
so `check` stays green while the gap stays visible. Remove the tag to reactivate the test once the
# Just one test
(the expected answer generated on a vanilla index), and add a matching `e("<type>", family)` entry to
DatasetQueryRunner.java   ← auto-discovers dsl/q*.json
OpenSearch server via `restTest -PrestCluster=host:port`. One resource folder per DSL query type; each is
Per-query-type integration tests for the parquet/composite data format, run by default against a
vanilla OpenSearch index (default Lucene backend, no parquet settings) and committed. `DslQueryTypesIT`
./gradlew :sandbox:qa:dsl-standalone-server-tests:integTest -Dsandbox.enabled=true
# Default: localhost:9200 (cluster runTask)
./gradlew :sandbox:qa:dsl-standalone-server-tests:integTest -Dsandbox.enabled=true \
that expected answer via `DslResponseValidator` (order-independent, numeric tolerance). A type is green
testClusters cluster with the analytics/DataFusion/DSL plugin stack on JDK 25 (see `build.gradle`).
This module seeds the suite with a small set of query types. It is intended to grow one folder at a
it comes from the `analytics-qa-fixtures` test-jar (`testArtifacts`), not a local copy. Only the
# Run the suite (self-provisions the cluster)
./gradlew :sandbox:qa:dsl-standalone-server-tests:restTest -Dsandbox.enabled=true -PrestCluster=host:port
`TAG_MULTI_VALUED_KEYWORD` on `term` / `bool`, whose multi-valued `tags` keyword array parquet rejects).
```
