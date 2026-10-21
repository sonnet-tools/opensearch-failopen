     * Master switch for MPP (multi-pass parallel) join/aggregate dispatch.
        "analytics.mpp.join.reorder",
    /**
     */
     * runtime cap stays the safety net for builds whose size CBO under-estimated (filter/semijoin
        MPP_JOIN_REORDER,
     * {@code Long.MAX_VALUE} to disable (always hash join — the pre-SMJ behavior) or {@code 0} to force
     * Master toggle for hash-shuffle IPC compression. When {@code true}, each shuffle IPC chunk is
     * PARTIAL-on-worker / FINAL-on-coordinator split. When {@code false}, the enforcement pass does NOT
     * <p>Below the threshold the worker keeps the (faster, no-sort) hash join. Only worker joins are
        Setting.Property.NodeScope,
        Setting.Property.Dynamic
    );
    public static final Setting<Boolean> MPP_SHUFFLE_AGGREGATE_ENABLED = Setting.boolSetting(
        TimeValue.timeValueSeconds(1L),
     * Runtime cap: the build-side IPC payload assembled by the coordinator-side capture sink may
     */
        MPP_SHUFFLE_AGGREGATE_ENABLED,
     *
    /**
        "analytics.mpp.shuffle.spill.enabled",
     * Node-level on-heap hash-shuffle budget, as a PERCENT of the JVM max heap ({@code -Xmx}).
     * {@code AnalyticsSearchBackendPlugin.defaultShuffleParallelism(ClusterState)} — backends
        Setting.Property.NodeScope,
     * complete within this timeout, the partition fails and the query terminates. The timeout
    );
     * entirely (the split rule refuses to fire when partitionCount ≤ 1).
    );
        Setting.Property.Dynamic
     * <p>Default 80(%): generous enough that legitimately-fitting shuffles run while leaving heap for
 * that gate engine-side behavior independent of the chosen backend.
        MPP_SHUFFLE_NODE_BUDGET_PERCENT,
     *
    /**
import org.opensearch.common.settings.Setting;
     * {@code DistributionEnforcementPass}, instead of gathering the whole join output and aggregating
     *
     * spilling. Scoped to plans whose joins are all equi-joins (a cross-join — e.g. what PPL
        Setting.Property.NodeScope,
        100,
     * Cost-based join reordering for multi-way joins. When {@code true}, a plan with 3+ joins is
     * a large shuffle accumulates its whole input on-heap and OOMs the node (observed: 7.4 GB of
     * set {@code analytics.mpp.enabled=false}. Set to {@code 0} to disable the budget (pre-fix
     * scan rows exceed this value, the coordinator sets {@code prefer_hash_join=false} on that worker
        "analytics.mpp.shuffle.compress",
     * default-off first. The two reorder rules run as SEPARATE HEP instructions ({@code JOIN_TO_MULTI_JOIN}
        Setting.Property.NodeScope,
    /**
     * silently falling back to zstd (the codec resolver still treats any unexpected value as zstd
        false,
     * <p>Defaults to {@code false}: production runs the coordinator-centric (M0) path until an
        MPP_SHUFFLE_SPILL_ENABLED,
     * compressed (standard Arrow IPC compression) before it is buffered/shipped, shrinking the
        MPP_SHUFFLE_PRUNE_COLUMNS,
        "analytics.mpp.shuffle.partitions",
     * This mirrors Spark's memory-safety rule: hash-join only when the build provably fits, else the
     * defensively, but the validator prevents the confusing case).
    );
     * per-query budget breach still throws {@code ShuffleBufferExceededException}. The node-budget
    /**
     * unset (or non-positive), the partition count is resolved per-query via
        Setting.Property.NodeScope,
     */
     * Number of hash-shuffle output partitions. When set to a positive value, every
     * collapsed into an n-ary {@code MultiJoin} and re-ordered by Calcite's bushy-join heuristic
        "analytics.mpp.broadcast.probe_estimate",
     * the rest of query execution; bounds runaway buffers well before OOM. Operator remediation on a
     * zstd's valid range [1, 22] at settings-apply time so an invalid level (e.g. 0 or 100) is rejected
        true,
     * {@code byte[]} on an 8 GB heap for TPC-H q17 at sf=10). A PER-BUFFER cap can't bound the sum
import org.opensearch.core.common.unit.ByteSizeValue;
        new ByteSizeValue(64L * 1024 * 1024),
        MPP_SHUFFLE_SPILL_MAX_BYTES,
 * The OpenSearch Contributors require contributions made to
        MPP_COMPRESSION_CODEC,
        Setting.Property.Dynamic
        MPP_COMPRESSION_ZSTD_LEVEL
    );
     *
     * ({@code <directory>/<queryId>/}). Default empty {@code ""} resolves at wiring time to
    public static final Setting<Integer> MPP_BROADCAST_PROBE_ESTIMATE = Setting.intSetting(
     */
     * compression's CPU cost usually outweighs its remaining heap benefit — enable it only when a node
    public static final Setting<Boolean> MPP_SHUFFLE_SPILL_ENABLED = Setting.boolSetting(
        Setting.Property.NodeScope,
     * {@code ShuffleBuffer.awaitReady} until both producer sides finish, then drains the accumulated
     * should route through hash-shuffle instead.
    public static final Setting<Long> MPP_WORKER_SORT_MERGE_JOIN_MIN_ROWS = Setting.longSetting(
     * other queries finish) UNLESS a single query's own footprint exceeds the budget, which fails
     * instead of the in-memory hash-join build. When a worker join's build-side (right input) estimated
        -1,
     * to fixpoint, THEN the optimize rule) so they cannot invert each other into an infinite loop.
     * best ratio) or {@code lz4} (native lz4-java LZ4-frame). Only the writer consults this; the
    public static final List<Setting<?>> ALL_SETTINGS = List.of(
     * Build-side row threshold above which a hash-shuffle WORKER join uses a spillable sort-merge join
     *
     * Codec used when {@link #MPP_SHUFFLE_COMPRESS} is on — {@code zstd} (default; native zstd-jni,
     * tunable per workload AND so integration tests on small datasets can lower it to exercise the
        false,
     * fat fact-table intermediate is not carried through the whole tree (and not shuffled at every
     * spillable join.
    public static final Setting<Long> MPP_DISTRIBUTE_MIN_ROWS = Setting.longSetting(
     * and the consumer drains spilled chunks back (in arrival order) followed by the in-memory tail —
        Setting.Property.Dynamic
        "",
    public static final Setting<Integer> MPP_SHUFFLE_PARTITIONS = Setting.intSetting(
    /**
     * lineitem 60M) and well above trivial joins that gather cheaply. Exposed as a setting so the floor is
import org.opensearch.common.unit.TimeValue;
    public static final Setting<Integer> MPP_COMPRESSION_ZSTD_LEVEL = Setting.intSetting(
     * behavior — NOT recommended; risks node OOM).
 * this file be licensed under the Apache-2.0 license or a
     * Arrow-IPC {@code byte[]} chunks. Those chunks live ON the JVM heap, and a node's live shuffle
        0L,
        Setting.Property.Dynamic
    public static final Setting<Boolean> MPP_JOIN_REORDER = Setting.boolSetting(
        Setting.Property.Dynamic
    /**
        MPP_SHUFFLE_SPILL_DIRECTORY,
     * split the aggregate: it gathers the (possibly distributed) child and runs the SINGLE aggregate
     * switch when an agg-specific issue is seen, without disabling MPP joins.
     * <p>{@code ShuffleBufferManager} admits a chunk only if the node total stays under
     * <p>Even with spill enabled the query still fails — re-messaged to name {@code spill.max_bytes} /
        true,
     * which also makes this an incident-response kill switch and the A/B baseline. QA test clusters
    private AnalyticsSettings() {}
        MPP_DISTRIBUTE_MIN_ROWS,
    public static final Setting<ByteSizeValue> BROADCAST_MAX_BYTES = Setting.byteSizeSetting(
     * Size floor for the general post-CBO distribution-enforcement pass ({@code DistributionEnforcementPass},
     * I/O error occurs. Gated under {@link #MPP_ENABLED}.
     * on-heap buffered bytes at the cost of per-buffer compress/decompress CPU. Default {@code false}:
     * <p>This same value drives the pre-flight planning gate in {@code OpenSearchBroadcastJoinSplitRule}
     * <p>Default 64 MiB: broadcast is for small dimension builds, and 64 MiB stays well within the
     * nodes; backends that don't (Lucene today) return 1 and so opt out of the strategy
     * at sf=10) RUN: the per-query on-heap footprint is bounded by the budget, the rest lives on disk,
     * <p>The shuffle consumer is buffer-all-then-drain: a worker blocks on
        Setting.Property.NodeScope,
     * fast and non-retryably with {@code ShuffleBufferExceededException} (waiting can't help — the
        Setting.Property.NodeScope,
     * part 2M, partsupp 8M at sf=10) and below the fact-table-scale builds that OOM. Set to
     * shuffle codec default) — measured faster end-to-end than Arrow's default level 3 (cheaper
     * consumer decompress + less GC) at comparable heap relief. Ignored by the LZ4 codec. Bounded to
     * has no escape to disk and trips the native circuit breaker on large builds (TPC-H sf=10 q17/q18/q21).
     *
     *
    );
        "analytics.mpp.shuffle.aggregate.enabled",
     * not exceed this many bytes. When the build stage's accumulated Arrow IPC exceeds this
        0,
        Setting.Property.Dynamic
 *
     * is enabled — surfaced as a re-messaged {@code ShuffleBufferExceededException} naming
    /**
     * (default — preserves current behavior), eligible aggregates over a distributed join run the
     * Directory under which hash-shuffle spill files are written, one subdir per query
        Setting.Property.NodeScope,
     * on the {@code PUT} rather than crashing the first compressed shuffle write.
    /**
     */
        "analytics.mpp.enabled",
}
        BROADCAST_MAX_BYTES,
     * downstream-referenced columns rather than the full join-output width. On wide fact-table joins
        Setting.Property.Dynamic
    );
    public static final Setting<Boolean> MPP_SHUFFLE_COMPRESS = Setting.boolSetting(
     * cost model toward favoring or disfavoring broadcast in their workload.
     * regardless). Below the floor the operator stays coordinator-centric, matching CBO's cheap choice for
     */
        MPP_SHUFFLE_COMPRESS,
     */
        Setting.Property.Dynamic
        "analytics.mpp.shuffle.recv_timeout",
     * all data nodes. Operators can override to tune for selective routing or to nudge the
     */
     * seeded by {@code IndexRowCountFetcher} — driving the smaller/more-selective joins first so the
        "analytics.mpp.shuffle.node_budget_percent",
     * ({@code JOIN_TO_MULTI_JOIN} + {@code MULTI_JOIN_OPTIMIZE_BUSHY}) using the per-index row counts
    /**
     * is a backstop against stuck producers (cancelled queries cascade through the walker
/*
        Setting.Property.NodeScope,
     * pre-marking trim this used to control, and its trimmer runs unconditionally — so toggling this no
        Setting.Property.NodeScope,
     * cross-join — e.g. PPL {@code transpose} — is left untouched). Default {@code false}: join order
     */
    );
 * Engine-level cluster settings for analytics-engine. Backend-specific settings live
     */
     * {@code false}, everything falls back to coordinator-centric regardless of advisor decision —
        "analytics.mpp.compression.zstd.level",
    public static final Setting<String> MPP_COMPRESSION_CODEC = Setting.simpleString("analytics.mpp.compression.codec", "zstd", value -> {
    );
        Setting.Property.Dynamic
     * data-node count at planning time" — the natural answer when the probe-side index spans
        Setting.Property.Dynamic
     * exercised in CI.
        "analytics.mpp.shuffle.prune_columns",
     * Hard disk ceiling for hash-shuffle spill, in bytes, across all of this node's spill files.
        TimeValue.timeValueSeconds(60L),
     * are unaffected (a join below the aggregate still runs on its worker tier). Useful as a targeted kill
    /**
     * serially on the coordinator.
     * NOTE: currently INERT. Upstream #22301 (`RelFieldTrimmer` projection pushdown) superseded the gated
     * captured + replicated. Operators broadcasting larger builds can raise this; very large builds
        "analytics.mpp.shuffle.spill.max_bytes",
        false,
     * worker tier, per-partition) + FINAL (gathered to the coordinator) by the general post-CBO pass
     */
     * selectivity). On a runtime overflow the coordinator re-plans without broadcast (falling back
     * query can't fit even on an idle node). A percent (not an absolute byte value) auto-scales to
     * affected — shard-scan and coordinator-reduce sessions always prefer hash join. Default
    );
        MPP_WORKER_SORT_MERGE_JOIN_MIN_ROWS,
     *
     * <p>Default {@code -1} means "use engine default." Operators rarely need to override.
        Setting.Property.NodeScope,
        "analytics.mpp.broadcast.max_bytes",
     * that participate in MPP shuffle (DataFusion today) return the count of probe-side data
        }
     * this number is what enters the formula. Default {@code -1} means "use the cluster's
     *
     * (see {@code ShuffleBufferManager.spillOldest}) instead of failing fast with
     * small joins — distribution adds shuffle overhead that only pays off at scale.
     * {@code percent% × maxHeap}; over-budget admissions are rejected for retry (room frees when
    /** All engine-level settings registered by {@code AnalyticsPlugin.getSettings()}. */
        Setting.Property.NodeScope,
     * bytes are the SUM across every buffer it holds (all queries/stages/partitions). Without a bound
     * <p>Gated under {@link #MPP_ENABLED}: this only has effect when MPP is on. When {@code true}
     * tier). Runs pre-marking on the plain {@code Logical*} tree, in its own HEP phase, alongside the
        1,
     * operator opts into MPP. When {@code true}, the engine routes joins/aggregates through the
        -1,
     *
     * {@code ShuffleBufferExceededException}. This lets multi-GB shuffle intermediates (TPC-H q5/q10
import java.util.Locale;
public final class AnalyticsSettings {
        Setting.Property.Dynamic
    );
    public static final Setting<Integer> MPP_SHUFFLE_NODE_BUDGET_PERCENT = Setting.intSetting(
        22,
        "analytics.mpp.distribute.min_rows",
    );
     */
     * is memory-constrained enough to prefer heap headroom over latency. The reader auto-detects the
    public static final Setting<Long> MPP_SHUFFLE_SPILL_MAX_BYTES = Setting.longSetting(
     * (TPC-H) this shrinks the shuffled payload several-fold — the single biggest driver of the
     * before the plan is cut into stages, so a hash-shuffle carries only the join keys plus the
    );
     */
     * batches to disk under memory pressure) rather than the {@code HashJoinExec} whose in-memory build
import java.util.List;
            throw new IllegalArgumentException("analytics.mpp.compression.codec must be one of [zstd, lz4], got [" + value + "]");
     * footprint would exceed the on-heap budget spills its oldest buffered Arrow-IPC chunks to disk
    public static final Setting<String> MPP_SHUFFLE_SPILL_DIRECTORY = Setting.simpleString(
        0L,
        Setting.Property.Dynamic
    /**
     */
    /**
     * Per-strategy sub-toggle for distributed <em>aggregation</em> (the {@code HASH_SHUFFLE_AGG}
 */
        false,
     */
    /**
     * its {@code ShuffleBuffer} until both producer sides signal {@code isLast}; if no senders
        Setting.Property.Dynamic
    );
     * Per-partition receive timeout for hash-shuffle consumers. Each consumer task blocks on
     * reader auto-detects. Validated at settings-apply time so a typo is rejected up front rather than
     */
     * suspected pruning issue.
     * <p>Gated to 3+ join plans (2-way plans have only one order) and to all-equi-join plans (a
     * {@code 20_000_000}: above the dimension builds that fit comfortably in memory (TPC-H supplier 100K,
 * SPDX-License-Identifier: Apache-2.0
     * Exceeding it (or hitting a disk-full / write I/O error) is the new terminal failure when spill
        Setting.Property.NodeScope,
     * ({@code 53687091200}). Only consulted when {@link #MPP_SHUFFLE_SPILL_ENABLED} is {@code true}.
        Setting.Property.NodeScope,
     * subtree exceeds this many rows (or a deeper operator already distributed — the cascade continues upward
     * Master switch for hash-shuffle disk spill. When {@code true}, a query whose per-query shuffle
     * node heap size.
     * disk-full — once the disk ceiling {@link #MPP_SHUFFLE_SPILL_MAX_BYTES} is hit or a spill write
     *
        String v = value == null ? "" : value.trim().toLowerCase(Locale.ROOT);
    public static final Setting<Boolean> MPP_ENABLED = Setting.boolSetting(
     * distributed path (the JVM tests use {@code minRows=1}; the cluster ITs set this to a small value).
     * {@code transpose} lowers to — is left untouched). Default {@code true}; disable only to isolate a
     * the only MPP scheduler): a join/aggregate is distributed onto a worker tier only when its larger scan
    );
     * coordinator-centric — exactly as if MPP were off, but scoped to aggregation only. Distributed JOINS
     *
     */
    /**
     * to hash-shuffle / coordinator-centric) rather than failing — see {@code DefaultPlanExecutor}.
     * strategy): a decomposable {@code GROUP BY} over a distributed join is split PARTIAL (on the join's
    );
    /**
     * enable it explicitly (see {@code qa/analytics-engine-rest/build.gradle}) so the MPP path is
        Setting.Property.Dynamic
 * compatible open source license.
package org.opensearch.analytics;
     * sort-merge on every worker join (A/B benchmarking).
     * {@link #MPP_SHUFFLE_SPILL_ENABLED} is {@code true}.
        if (!v.equals("zstd") && !v.equals("lz4") && !v.equals("lz4_frame")) {
     * fast failure: raise this (toward but below 100), give the node more heap, narrow the query, or
/**
     * distributed-join latency, and it keeps more queries under the on-heap shuffle budget without
        "analytics.mpp.worker.sort_merge_join_min_rows",
 */
        new ByteSizeValue(0L),
     * HASH_SHUFFLE query uses this exact partition count regardless of cluster shape. When
     * (a build whose estimated bytes exceed the cap never gets a broadcast alternative), and the
     * faster than this); 60s is conservative enough that healthy queries never hit it.
    public static final Setting<Boolean> MPP_SHUFFLE_PRUNE_COLUMNS = Setting.boolSetting(
    public static final Setting<TimeValue> MPP_SHUFFLE_RECV_TIMEOUT = Setting.timeSetting(
        80,
     * with {@link #MPP_SHUFFLE_PRUNE_COLUMNS} on (the default), the shuffle is already narrow, so
     * <p>Default {@code 1_000_000}: well below any TPC-H fact table that needs distributing (partsupp 8M,
        MPP_SHUFFLE_RECV_TIMEOUT,
     * Cost-model parameter: how many probe-side data nodes the broadcast exchange estimates it
    /**
    }, Setting.Property.NodeScope, Setting.Property.Dynamic);
        53687091200L,
     * (N partitions each under the cap still OOM in aggregate), so the budget is per-NODE.
     * it. When set, it must be a writable absolute path on the data node. Only consulted when
     * <p>When {@code false} (default), behavior is byte-identical to the pre-spill fail-fast path: a
     * Pre-marking column pruning for the distributed path: drop columns no operator references
     */
     * stage, so DataFusion's physical planner emits a {@code SortMergeJoinExec} (which spills its buffered
     * codec from the IPC metadata, so a mixed-setting (rolling-restart) cluster still decodes correctly.
     * 256 MiB default {@code analytics.coordinator.buffer_limit} (≈1/4) even after the build is
        new ByteSizeValue(Long.MAX_VALUE),
        MPP_ENABLED,
        Setting.Property.Dynamic
        Setting.Property.NodeScope,
     * column-prune + filter-pushdown pre-marking rewrites.
     * threshold during pass 1, the capture sink raises {@code BroadcastSizeExceededException}.
 * @opensearch.internal
     * ZSTD compression level when the codec is {@code zstd}. Default {@code 1} (matching Spark's
    );
        1,
     * strategy advisor and may pick BROADCAST or HASH_SHUFFLE for eligible queries; when
     * preserving the proven buffer-all consumer contract.
        20_000_000L,
     *
     * {@code spill.max_bytes} / disk rather than the on-heap budget. Default 50 GiB
 *
 * alongside their backend (e.g. {@code DatafusionSettings}); this class is for settings
     * is taken as-written until the reorder is benchmarked, mirroring how prune/compress shipped
        1_000_000L,
    /**
        MPP_BROADCAST_PROBE_ESTIMATE,
     * longer changes planning. Retained so clusters that already set it still start.
     * REJECT_RETRY (transient cross-query contention) path is unchanged either way.
     * {@code <path.data>/shuffle_spill} (the node's first data path), so operators rarely need to set
        0L,
        "analytics.mpp.shuffle.spill.directory",
        MPP_SHUFFLE_PARTITIONS,
     * has to replicate to. The broadcast cost is roughly {@code buildSide.rows × probeNodes};
