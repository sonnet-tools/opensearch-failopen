- **Operators**: `gte`, `gt`, `lte`, `lt`
- `analytics-engine` — provides `QueryPlanExecutor` and `EngineContext` via Guice (declared as `extendedPlugins`)
### Known Divergences (prefix / wildcard)
- **Millisecond Precision**: TIMESTAMP(3) for accurate date comparisons
- **Range Query** - Numeric and date range queries with full date math support
Supported parameters: `value` (verbatim), `case_insensitive` (delegated to builder; ASCII-only folding),
      {"term": {"deleted": "true"}}
- Multiple combinations: `"3<-1 5<50%"` - threshold-based rules
| `prefix` | Delegated `PREFIX_QUERY` RexCall — Lucene `PrefixQueryBuilder` on data node |
serializer is used because the existing `WildcardQuerySerializer` expects SQL-form patterns
{"prefix": {"name": "lap"}}           → PREFIX_QUERY(MAP('field',name), MAP('query','lap'))
**Clauses:**
```
    "must": [
  "bool": {
## Testing
**minimum_should_match formats:**
and would reinterpret a literal `%` in customer data as a wildcard.
Emits a delegated `WILDCARD_QUERY_DSL` RexCall (Category.FULL_TEXT). The Lucene wildcard
Emits a delegated `PREFIX_QUERY` RexCall (Category.FULL_TEXT). The prefix value is passed
Converts to Calcite logical expressions with support for all clauses. `minimum_should_match` is
- **Relation**: INTERSECTS relation support
- `analytics-framework` — provides Calcite and shared SPI interfaces
./gradlew :sandbox:plugins:dsl-query-executor:test --tests "BoolQueryTranslatorTests" -Dsandbox.enabled=true
|-----------|------------------------|
`index_prefixes` O(1) fast path.
verbatim to `PrefixQuerySerializer`, which builds a real `PrefixQueryBuilder` on the data node.
### Calcite Representation
- **Bool Query** - Compound query with `must`, `should`, `must_not`, `filter` and `minimum_should_match`
```json
# Unit tests
pattern (`*`, `?`, `\` escapes) is passed verbatim — no SQL conversion occurs. A dedicated
respectively); intermediate values (greater than 1 and below the should-clause count) are
| # | Divergence | Detail |
```
./gradlew run -PinstalledPlugins="['analytics-engine','dsl-query-executor']"
```bash
| `terms` | `SEARCH($field, Sarg[v1, v2, ...])` — multi-value equality |
- Non-negative integer: `"2"` - exactly 2 clauses must match
```
- **Match All Query** - Match all documents
- **Date Math**: Expressions like `now-7d`, `now/d`, `now-1M/M`
unsupported on this path.
**Example:**
### Range Query Features
    ],
## Running locally
      → SearchSourceConverter (DSL → Calcite RelNode)
| 3 | Field types not storable in this engine mode | `wildcard`, `constant_keyword`, `version` and `flat_object` support prefix/wildcard in vanilla, but indexes using them cannot be created in optimized engine mode at all — the Parquet primary format (`CoreDataFieldPlugin`) and the Lucene secondary format (`LuceneFieldFactoryRegistry`) register no writers for them, so index creation fails with `MapperParsingException` (see `CompositeFieldCapabilityIT`). Storage-layer limitation shared by every query front-end via `OpenSearchSchemaBuilder`, not a prefix/wildcard behaviour difference. |
- Non-negative percentage: `"70%"` - 70% of clauses (rounded down)
      {"term": {"priority": "low"}}
  }
| `wildcard` | Delegated `WILDCARD_QUERY_DSL` RexCall — Lucene `WildcardQueryBuilder` on data node |
| DSL Query | Calcite Representation |
| 2 | Page pruning lost | A delegated predicate yields an all-true bitmap at the pruning stage (page_pruner.rs:779-782); the previous LIKE form was prunable (page_pruner.rs:24). Correctness preserved by residual re-evaluation (single_collector.rs:604-611). Follow-up: schema enrichment would enable a prunable fast path. |
{
}
- **Date Format**: Custom date formats (e.g., `dd/MM/yyyy`)
Lucene performs the matching against the term dictionary, inheriting normalizer handling and the
- **Wildcard Query** - Wildcard pattern matching via Calcite LIKE
- Single combination: `"2<75%"` - if total ≤ 2 match all, else 75%
## Supported Features
    "minimum_should_match": "2"
_search request
    → TransportDslExecuteAction (resolves index, orchestrates pipeline)
{"wildcard": {"name": "l?ptop"}}      → WILDCARD_QUERY_DSL(MAP('field',name), MAP('query','l?ptop'))
| 1 | `search.allow_expensive_queries=false` not honoured | The Lucene backend hardcodes an always-true supplier (LuceneAnalyticsBackendPlugin:284). Vanilla refuses prefix/wildcard when this setting is false. Pre-existing property of the delegation layer. |
supported for 0, 1, and values at or above the should-clause count (optional, OR, and AND
    ],
- **Prefix Query** - Prefix matching via Calcite LIKE with wildcard suffix
```bash
    "should": [
- `must_not` - Exclusion clauses (NOT logic)
## Architecture
## Dependencies
### Query Types
      → SearchResponseBuilder (builds SearchResponse)
### Prefix Query
- **Rounding**: Automatic end-of-day rounding for upper bounds without explicit `/`
### Wildcard Query
| `match_all` | Skipped (boolean literal `TRUE`) |
{"wildcard": {"name": "lap*"}}        → WILDCARD_QUERY_DSL(MAP('field',name), MAP('query','lap*'))
| `exists` | `IS NOT NULL($field)` — field existence check (boost not supported) |
### Bool Query
`rewrite` (passed through to builder, validated on data node). Rejected: `boost` (throws ConversionException —
      → DslQueryPlanExecutor (delegates to analytics engine)
  → PREFIX_QUERY(MAP('field',name), MAP('query','LAP'), MAP('case_insensitive','true'))
    ],
A front-end sandbox plugin to the analytics engine that intercepts `_search` requests, converts DSL queries into Calcite RelNode logical plans, and executes them through the analytics engine's query pipeline.
```
```
```
    "must_not": [
| `term` | `=($field, value)` — equality filter |
```
      {"term": {"priority": "high"}},
scores are not surfaced). Rejected: `_name` (throws ConversionException — matched_queries not surfaced).
|---|---|---|
      {"term": {"status": "active"}}
- **Timezone**: Timezone handling (defaults to UTC)
# Integration tests
- Negative percentage: `"-30%"` - can miss 30% of clauses
```json
- `should` - Optional clauses (OR logic)
- **Term Query** - Exact term matching
# Specific test class
./gradlew :sandbox:plugins:dsl-query-executor:test -Dsandbox.enabled=true
./gradlew :sandbox:plugins:dsl-query-executor:internalClusterTest -Dsandbox.enabled=true
  → SearchActionFilter (intercepts SearchAction)
# dsl-query-executor
- `filter` - Filtering clauses (AND logic, no scoring)
      {"term": {"priority": "medium"}},
- Negative integer: `"-1"` - total minus 1 must match
```json
- `must` - Required clauses (AND logic)
{"prefix": {"name": {"value": "LAP", "case_insensitive": true}}}
