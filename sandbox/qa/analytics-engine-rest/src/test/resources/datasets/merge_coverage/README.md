(function isolation); this suite is the distributed-stress companion and is purely additive.
  ("Lucene as a driving backend for shard-local count fragments") the bare `[ source ]` join arm / union
| `TwoShardShapeIT` | `shape/`, `window/` | exact differential |
## Determinism rule (important)
## Dataset shape
index names and runs the query against both. A `merge_coverage_lookup` dimension index backs the
## Adding coverage
join_inner_category_count     TwoShardJoinIT
## Structure
| `price` | double | `amount × 1.5` — double agg target |
(`<name>` → reason). Listed queries are **skipped** (never run) and logged as `MUTED: <reason>`; there
A single abstract base `TwoShardReduceTestCase` holds all the cross-shard machinery; thin per-category
`lookup` command.
  node** during the Arrow variable-width-view C-data export (`upcallLinker.cpp:137`). These *must* be
| `id` | integer | 0–29, unique — sort tie-breaker |
  skipped rather than run — a crash would break unrelated tests.
| `opt` | integer | present on even `id` only (15 docs) — null-handling fns |
| `TwoShardAggregationIT` | `agg/`, `approx/` | exact differential + approximate-golden |
  reject the mixed backends. Reduce-sound before #21867.
- **`window/`:** eventstats by group, streamstats running sum.
cmd_appendcols                TwoShardCommandIT
  drift across a partition merge, so differential equality is *not* used. Each ships a **required**
join_left_count               TwoShardJoinIT
- **`agg/` aggregations:** count, count(field), sum, avg, min, max (int + double), stddev_pop,
  golden truth in `approx/expected/<name>.json`; the 2-shard result is asserted within tolerance
or the 2-shard gather returns a nondeterministic subset and the comparison is meaningless.
  gather computes the running aggregate over the wrong order (1-shard `1,3,6,10,…` vs 2-shard `216,2,5,9,…`).
  *additionally* pinned to that absolute golden (catches a bug wrong identically at both shard counts).
| IT class | dataset subdir(s) | tier |
- **all 6 join queries** (`TwoShardJoinIT`) and **cmd_appendpipe** (`TwoShardCommandIT`) — since #21867
The complete current list (keep in sync with the `knownIssues()` maps):
IT classes only declare which dataset subdirs they cover and which queries are known-broken:
| `TwoShardJoinIT` | `join/` | exact differential (all queries muted, see below) |
The dataset is provisioned twice from this directory's `mapping.json` + `bulk.json`:
- **`scalar/`:** round, round/2, pow, abs, upper, lower, substring, replace, cast (→double/int/string),
distinct_count_by_cat         TwoShardAggregationIT
  hand-computed expected needed. If `<dir>/expected/<name>.json` exists, the 2-shard result is
  string sort, dedup.
Any `head N` / `sort … | head` test **must** carry a total ordering with a unique tie-breaker (`id`),
Every known-broken query is listed in exactly one place: the overriding IT's `knownIssues()` map
  stddev_samp, var_pop, var_samp, span; collection aggs `values`/`list` (multiset-normalized).
- **approximate (golden + tolerance):** sketch aggregations (`distinct_count`=HLL, `percentile`=t-digest)
Drop a `<name>.ppl` in the appropriate subdir using `%INDEX%` as the source — that's the whole test.
| `flag` | boolean | `amount` even |
What's muted and why:
- **`cmd/`:** rex, table, spath, rename, fillnull, bin, top, chart, lookup, appendpipe.
| `TwoShardCommandIT` | `cmd/` | exact differential |
  predicate that routes through the DataFusion indexed executor, which at 2 shards **SIGSEGVs the data
| `TwoShardScalarIT` | `scalar/` | exact differential |
|---|---|---|
cmd_append                    TwoShardCommandIT
join_inner_by_category        TwoShardJoinIT
# merge_coverage — 2-shard reduce-correctness suite
| `label` | keyword | `lbl(amount%5)` — string fns / dedup / distinct |
| `ts` | date | `2024-01-(id+1)` — date fns |
Purpose: prove that **sharding the data across two shards does not change the answer** for the
cmd_search                    TwoShardCommandIT
streamstats_sum               TwoShardShapeIT
| `payload` | keyword | JSON string `{"v":amount}` — for `spath` |
- **cmd_search / cmd_append / cmd_regex / cmd_multisearch** (`TwoShardCommandIT`) — carry a residual
## Muted (skipped) queries — single mechanism
|---|---|---|
analytics-engine route — i.e. that partial→final aggregation, sort-merge, top-N gather, window
| field | type | notes |
(the per-shard partials are still merged arrival-ordered). Not a reduce-correctness signal; left out.
  branch is lucene-driven while the main arm stays datafusion, and `OpenSearchJoin` / `OpenSearchUnion`
| `category` | keyword | group key (A/B/C) |
  percentile_approx, median.
join_anti_count               TwoShardJoinIT
```
## How it works
join_inner_id_count           TwoShardJoinIT
cmd_multisearch               TwoShardCommandIT
  (unordered, numeric-tolerant; multi-value `values`/`list` cells compared as multisets). No
is no `@AwaitsFix` and no separate directory.
## Not covered — inherently nondeterministic at 2 shards
30 docs, 3 categories (`A`/`B`/`C`) × 10. Designed so every group spans both shards.
| `merge_coverage_2shard` | 2 | system under test (suite asserts both primaries are populated) |
  merge over-counts repeated keyword sets: `distinct_count(label)` = 5 at 1 shard, 9 at 2; by-category
cmd_timechart                 TwoShardCommandIT
Add `<dir>/expected/<name>.json` to also pin the absolute value. Approximate functions go under
Each query file uses the literal token `%INDEX%` for its source; the harness substitutes the two
distinct_count_label          TwoShardAggregationIT
`take(field, N)` returns the first N values in *arrival* order with no ordering guarantee, so 2 shards
- **`approx/`:** distinct_count (global, by-group, several columns), `dc`, percentile (50/90),
join_semi_count               TwoShardJoinIT
- **exact (differential):** the 1-shard result is the oracle — 1-shard must **equal** 2-shard
(`IpFieldMultiShardIT` is a sibling — see the separate `ip_multishard` dataset.)
  (rel 15% / abs 1.0) of it.
- **distinct_count / dc / distinct_count_by_cat** (`TwoShardAggregationIT`) — HLL cross-shard sketch
cmd_appendpipe                TwoShardCommandIT
| `amount` | integer | A:1–10 B:11–20 C:21–30 — int agg target |
### Tiers
combine, and join shuffle are correct. The on-main `*PplIT` / `*CommandIT` suites stay at 1 shard
- **cmd_appendcols** (not in the PPL grammar) and **cmd_timechart** (needs an `@timestamp` field).
| index | shards | role |
dc_label                      TwoShardAggregationIT
| `region` | keyword | 2nd group key (east/west) |
- **streamstats_sum** (`TwoShardShapeIT`) — cumulative window, order-sensitive; the arrival-ordered
|---|---|---|
| `merge_coverage_1shard` | 1 | baseline / oracle |
legitimately yield a different subset (same hazard as `head N` without sort). A sort doesn't fix it
cmd_regex                     TwoShardCommandIT
- **`shape/`:** group-by single/multi-key/multi-agg, filtered group-by, sort/limit top-N with tie-break,
```
  5/5/5 vs 4/7/8. Correct for all-unique (`amount`=30) and low-card (`category`=3). Genuine merge bug.
`approx/` **with** a golden.
  coalesce, ifnull, isnull, isnotnull, nullif, case, if, date_format.
## Coverage
- **`join/`:** inner / left / semi / anti + join-then-group (self-joined on `%INDEX%`).
