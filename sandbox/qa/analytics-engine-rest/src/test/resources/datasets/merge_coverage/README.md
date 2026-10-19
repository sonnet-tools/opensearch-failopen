| `TwoShardCommandIT` | `cmd/` | exact differential |
Add `<dir>/expected/<name>.json` to also pin the absolute value. Approximate functions go under
What's muted and why:
| `payload` | keyword | JSON string `{"v":amount}` — for `spath` |
join_inner_id_count           TwoShardJoinIT
  predicate that routes through the DataFusion indexed executor, which at 2 shards **SIGSEGVs the data
```
  percentile_approx, median.
| `category` | keyword | group key (A/B/C) |
join_inner_category_count     TwoShardJoinIT
  branch is lucene-driven while the main arm stays datafusion, and `OpenSearchJoin` / `OpenSearchUnion`
| index | shards | role |
(function isolation); this suite is the distributed-stress companion and is purely additive.
  reject the mixed backends. Reduce-sound before #21867.
dc_label                      TwoShardAggregationIT
`take(field, N)` returns the first N values in *arrival* order with no ordering guarantee, so 2 shards
join_anti_count               TwoShardJoinIT
| `label` | keyword | `lbl(amount%5)` — string fns / dedup / distinct |
## Muted (skipped) queries — single mechanism
  coalesce, ifnull, isnull, isnotnull, nullif, case, if, date_format.
combine, and join shuffle are correct. The on-main `*PplIT` / `*CommandIT` suites stay at 1 shard
  skipped rather than run — a crash would break unrelated tests.
  drift across a partition merge, so differential equality is *not* used. Each ships a **required**
- **distinct_count / dc / distinct_count_by_cat** (`TwoShardAggregationIT`) — HLL cross-shard sketch
| IT class | dataset subdir(s) | tier |
cmd_multisearch               TwoShardCommandIT
## Coverage
  (rel 15% / abs 1.0) of it.
cmd_appendcols                TwoShardCommandIT
- **`cmd/`:** rex, table, spath, rename, fillnull, bin, top, chart, lookup, appendpipe.
Purpose: prove that **sharding the data across two shards does not change the answer** for the
(`<name>` → reason). Listed queries are **skipped** (never run) and logged as `MUTED: <reason>`; there
- **`scalar/`:** round, round/2, pow, abs, upper, lower, substring, replace, cast (→double/int/string),
| `TwoShardAggregationIT` | `agg/`, `approx/` | exact differential + approximate-golden |
cmd_append                    TwoShardCommandIT
Any `head N` / `sort … | head` test **must** carry a total ordering with a unique tie-breaker (`id`),
| `TwoShardShapeIT` | `shape/`, `window/` | exact differential |
| `merge_coverage_1shard` | 1 | baseline / oracle |
### Tiers
join_inner_by_category        TwoShardJoinIT
- **streamstats_sum** (`TwoShardShapeIT`) — cumulative window, order-sensitive; the arrival-ordered
- **`window/`:** eventstats by group, streamstats running sum.
cmd_appendpipe                TwoShardCommandIT
  merge over-counts repeated keyword sets: `distinct_count(label)` = 5 at 1 shard, 9 at 2; by-category
- **`agg/` aggregations:** count, count(field), sum, avg, min, max (int + double), stddev_pop,
(the per-shard partials are still merged arrival-ordered). Not a reduce-correctness signal; left out.
  golden truth in `approx/expected/<name>.json`; the 2-shard result is asserted within tolerance
legitimately yield a different subset (same hazard as `head N` without sort). A sort doesn't fix it
| `price` | double | `amount × 1.5` — double agg target |
join_semi_count               TwoShardJoinIT
The dataset is provisioned twice from this directory's `mapping.json` + `bulk.json`:
|---|---|---|
## Determinism rule (important)
| `region` | keyword | 2nd group key (east/west) |
|---|---|---|
IT classes only declare which dataset subdirs they cover and which queries are known-broken:
## Adding coverage
- **approximate (golden + tolerance):** sketch aggregations (`distinct_count`=HLL, `percentile`=t-digest)
- **cmd_search / cmd_append / cmd_regex / cmd_multisearch** (`TwoShardCommandIT`) — carry a residual
`lookup` command.
index names and runs the query against both. A `merge_coverage_lookup` dimension index backs the
| field | type | notes |
Each query file uses the literal token `%INDEX%` for its source; the harness substitutes the two
distinct_count_label          TwoShardAggregationIT
| `ts` | date | `2024-01-(id+1)` — date fns |
(`IpFieldMultiShardIT` is a sibling — see the separate `ip_multishard` dataset.)
| `flag` | boolean | `amount` even |
## Structure
cmd_regex                     TwoShardCommandIT
30 docs, 3 categories (`A`/`B`/`C`) × 10. Designed so every group spans both shards.
  gather computes the running aggregate over the wrong order (1-shard `1,3,6,10,…` vs 2-shard `216,2,5,9,…`).
is no `@AwaitsFix` and no separate directory.
| `id` | integer | 0–29, unique — sort tie-breaker |
cmd_search                    TwoShardCommandIT
| `opt` | integer | present on even `id` only (15 docs) — null-handling fns |
  (unordered, numeric-tolerant; multi-value `values`/`list` cells compared as multisets). No
Every known-broken query is listed in exactly one place: the overriding IT's `knownIssues()` map
## Dataset shape
Drop a `<name>.ppl` in the appropriate subdir using `%INDEX%` as the source — that's the whole test.
| `TwoShardJoinIT` | `join/` | exact differential (all queries muted, see below) |
  ("Lucene as a driving backend for shard-local count fragments") the bare `[ source ]` join arm / union
```
  stddev_samp, var_pop, var_samp, span; collection aggs `values`/`list` (multiset-normalized).
## Not covered — inherently nondeterministic at 2 shards
| `TwoShardScalarIT` | `scalar/` | exact differential |
  *additionally* pinned to that absolute golden (catches a bug wrong identically at both shard counts).
- **`approx/`:** distinct_count (global, by-group, several columns), `dc`, percentile (50/90),
- **`join/`:** inner / left / semi / anti + join-then-group (self-joined on `%INDEX%`).
  string sort, dedup.
streamstats_sum               TwoShardShapeIT
join_left_count               TwoShardJoinIT
# merge_coverage — 2-shard reduce-correctness suite
analytics-engine route — i.e. that partial→final aggregation, sort-merge, top-N gather, window
The complete current list (keep in sync with the `knownIssues()` maps):
  hand-computed expected needed. If `<dir>/expected/<name>.json` exists, the 2-shard result is
| `amount` | integer | A:1–10 B:11–20 C:21–30 — int agg target |
|---|---|---|
`approx/` **with** a golden.
A single abstract base `TwoShardReduceTestCase` holds all the cross-shard machinery; thin per-category
cmd_timechart                 TwoShardCommandIT
- **cmd_appendcols** (not in the PPL grammar) and **cmd_timechart** (needs an `@timestamp` field).
| `merge_coverage_2shard` | 2 | system under test (suite asserts both primaries are populated) |
or the 2-shard gather returns a nondeterministic subset and the comparison is meaningless.
- **exact (differential):** the 1-shard result is the oracle — 1-shard must **equal** 2-shard
- **`shape/`:** group-by single/multi-key/multi-agg, filtered group-by, sort/limit top-N with tie-break,
distinct_count_by_cat         TwoShardAggregationIT
- **all 6 join queries** (`TwoShardJoinIT`) and **cmd_appendpipe** (`TwoShardCommandIT`) — since #21867
  5/5/5 vs 4/7/8. Correct for all-unique (`amount`=30) and low-card (`category`=3). Genuine merge bug.
  node** during the Arrow variable-width-view C-data export (`upcallLinker.cpp:137`). These *must* be
## How it works
