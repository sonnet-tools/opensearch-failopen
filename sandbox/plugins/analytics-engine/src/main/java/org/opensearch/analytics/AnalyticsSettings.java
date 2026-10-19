        MPP_SHUFFLE_AGGREGATE_ENABLED,  
     * data-node count at planning time" — the natural answer when the probe-side index spans
     * <p>Gated under {@link #MPP_ENABLED}: this only has effect when MPP is on. When {@code true}
     */
    );
        Setting.Property.Dynamic  
    );
     * {@link #MPP_SHUFFLE_SPILL_ENABLED} is {@code true}.  
    public static final Setting<Integer> MPP_SHUFFLE_NODE_BUDGET_PERCENT = Setting.intSetting(
public final class AnalyticsSettings {  
 */  
     * NOTE: currently INERT. Upstream #22301 (`RelFieldTrimmer` projection pushdown) superseded the gated
     * zstd's valid range [1, 22] at settings-apply time so an invalid level (e.g. 0 or 100) is rejected
     * Master toggle for hash-shuffle IPC compression. When {@code true}, each shuffle IPC chunk is
     */  
     * Pre-marking column pruning for the distributed path: drop columns no operator references
        new ByteSizeValue(Long.MAX_VALUE),  
        Setting.Property.Dynamic
     * Master switch for hash-shuffle disk spill. When {@code true}, a query whose per-query shuffle
     * 256 MiB default {@code analytics.coordinator.buffer_limit} (≈1/4) even after the build is
        Setting.Property.NodeScope,
        "analytics.mpp.shuffle.aggregate.enabled",
        Setting.Property.NodeScope,
     * it. When set, it must be a writable absolute path on the data node. Only consulted when
     * per-query budget breach still throws {@code ShuffleBufferExceededException}. The node-budget
     * Cost-model parameter: how many probe-side data nodes the broadcast exchange estimates it
     * has to replicate to. The broadcast cost is roughly {@code buildSide.rows × probeNodes};
        MPP_SHUFFLE_NODE_BUDGET_PERCENT,
    /** All engine-level settings registered by {@code AnalyticsPlugin.getSettings()}. */
     * with {@link #MPP_SHUFFLE_PRUNE_COLUMNS} on (the default), the shuffle is already narrow, so
     * compressed (standard Arrow IPC compression) before it is buffered/shipped, shrinking the  
    /**  
     *
     * has no escape to disk and trips the native circuit breaker on large builds (TPC-H sf=10 q17/q18/q21).
    public static final Setting<Boolean> MPP_JOIN_REORDER = Setting.boolSetting(
     * <p>Default {@code -1} means "use engine default." Operators rarely need to override.
        String v = value == null ? "" : value.trim().toLowerCase(Locale.ROOT);
     * on-heap buffered bytes at the cost of per-buffer compress/decompress CPU. Default {@code false}:
        0,
     * scan rows exceed this value, the coordinator sets {@code prefer_hash_join=false} on that worker
     * is enabled — surfaced as a re-messaged {@code ShuffleBufferExceededException} naming  
        MPP_WORKER_SORT_MERGE_JOIN_MIN_ROWS,  
     * {@code false}, everything falls back to coordinator-centric regardless of advisor decision —
    /**
        "analytics.mpp.shuffle.spill.max_bytes",
        20_000_000L,  
 * compatible open source license.
     * threshold during pass 1, the capture sink raises {@code BroadcastSizeExceededException}.
        Setting.Property.NodeScope,  
     * downstream-referenced columns rather than the full join-output width. On wide fact-table joins  
     * <p>Defaults to {@code false}: production runs the coordinator-centric (M0) path until an
package org.opensearch.analytics;
     * query can't fit even on an idle node). A percent (not an absolute byte value) auto-scales to
     * cross-join — e.g. PPL {@code transpose} — is left untouched). Default {@code false}: join order
     * consumer decompress + less GC) at comparable heap relief. Ignored by the LZ4 codec. Bounded to
        "analytics.mpp.enabled",
     * is taken as-written until the reorder is benchmarked, mirroring how prune/compress shipped  
        true,
     * runtime cap stays the safety net for builds whose size CBO under-estimated (filter/semijoin
     * to fixpoint, THEN the optimize rule) so they cannot invert each other into an infinite loop.
    );  
 */
     * Number of hash-shuffle output partitions. When set to a positive value, every  
     * fast failure: raise this (toward but below 100), give the node more heap, narrow the query, or
     * spillable join.
     * split the aggregate: it gathers the (possibly distributed) child and runs the SINGLE aggregate
     * collapsed into an n-ary {@code MultiJoin} and re-ordered by Calcite's bushy-join heuristic  
 * The OpenSearch Contributors require contributions made to  
     * set {@code analytics.mpp.enabled=false}. Set to {@code 0} to disable the budget (pre-fix
        Setting.Property.NodeScope,
     * silently falling back to zstd (the codec resolver still treats any unexpected value as zstd  
        22,  
 * SPDX-License-Identifier: Apache-2.0
        Setting.Property.Dynamic  
    );  
     * Per-strategy sub-toggle for distributed <em>aggregation</em> (the {@code HASH_SHUFFLE_AGG}
        Setting.Property.NodeScope,
    public static final Setting<Long> MPP_SHUFFLE_SPILL_MAX_BYTES = Setting.longSetting(
        "",
     * pre-marking trim this used to control, and its trimmer runs unconditionally — so toggling this no  
    }, Setting.Property.NodeScope, Setting.Property.Dynamic);
        Setting.Property.NodeScope,  
     * This mirrors Spark's memory-safety rule: hash-join only when the build provably fits, else the  
        Setting.Property.NodeScope,
     * before the plan is cut into stages, so a hash-shuffle carries only the join keys plus the
        "analytics.mpp.worker.sort_merge_join_min_rows",
     * faster than this); 60s is conservative enough that healthy queries never hit it.
     *  
    );
import org.opensearch.common.settings.Setting;
     * should route through hash-shuffle instead.  
     * this number is what enters the formula. Default {@code -1} means "use the cluster's  
    );  
     * batches to disk under memory pressure) rather than the {@code HashJoinExec} whose in-memory build
        Setting.Property.Dynamic  
     * longer changes planning. Retained so clusters that already set it still start.
        MPP_ENABLED,
     * part 2M, partsupp 8M at sf=10) and below the fact-table-scale builds that OOM. Set to  
        "analytics.mpp.shuffle.node_budget_percent",  
        Setting.Property.Dynamic
     * Directory under which hash-shuffle spill files are written, one subdir per query
     * sort-merge on every worker join (A/B benchmarking).
     */
        false,  
    public static final Setting<Integer> MPP_COMPRESSION_ZSTD_LEVEL = Setting.intSetting(
    /**  
    );  
        new ByteSizeValue(0L),
     * unset (or non-positive), the partition count is resolved per-query via
        Setting.Property.Dynamic
        true,
     * {@code Long.MAX_VALUE} to disable (always hash join — the pre-SMJ behavior) or {@code 0} to force
    /**
     *
     * suspected pruning issue.
        1_000_000L,
     * seeded by {@code IndexRowCountFetcher} — driving the smaller/more-selective joins first so the
     * that participate in MPP shuffle (DataFusion today) return the count of probe-side data
        -1,  
     * at sf=10) RUN: the per-query on-heap footprint is bounded by the budget, the rest lives on disk,  
     * <p>Default 64 MiB: broadcast is for small dimension builds, and 64 MiB stays well within the  
        -1,
     * affected — shard-scan and coordinator-reduce sessions always prefer hash join. Default
        "analytics.mpp.shuffle.partitions",
    public static final Setting<String> MPP_SHUFFLE_SPILL_DIRECTORY = Setting.simpleString(
        MPP_SHUFFLE_SPILL_DIRECTORY,
        Setting.Property.NodeScope,
        MPP_SHUFFLE_SPILL_ENABLED,
     *
     * <p>Even with spill enabled the query still fails — re-messaged to name {@code spill.max_bytes} /
        new ByteSizeValue(64L * 1024 * 1024),
     * fat fact-table intermediate is not carried through the whole tree (and not shuffled at every  
    );  
    /**
     * disk-full — once the disk ceiling {@link #MPP_SHUFFLE_SPILL_MAX_BYTES} is hit or a spill write  
        Setting.Property.Dynamic
        false,
     * compression's CPU cost usually outweighs its remaining heap benefit — enable it only when a node  
        Setting.Property.Dynamic
 * @opensearch.internal
        MPP_BROADCAST_PROBE_ESTIMATE,
        0L,
     * (default — preserves current behavior), eligible aggregates over a distributed join run the
     */
     * strategy advisor and may pick BROADCAST or HASH_SHUFFLE for eligible queries; when  
        MPP_SHUFFLE_PRUNE_COLUMNS,
     */  
     * tier). Runs pre-marking on the plain {@code Logical*} tree, in its own HEP phase, alongside the
     * ZSTD compression level when the codec is {@code zstd}. Default {@code 1} (matching Spark's
     * HASH_SHUFFLE query uses this exact partition count regardless of cluster shape. When
     * default-off first. The two reorder rules run as SEPARATE HEP instructions ({@code JOIN_TO_MULTI_JOIN}
        "analytics.mpp.shuffle.spill.directory",  
     * regardless). Below the floor the operator stays coordinator-centric, matching CBO's cheap choice for  
     * stage, so DataFusion's physical planner emits a {@code SortMergeJoinExec} (which spills its buffered  
     * Build-side row threshold above which a hash-shuffle WORKER join uses a spillable sort-merge join  
        Setting.Property.NodeScope,  
     */  
        Setting.Property.NodeScope,  
     * distributed path (the JVM tests use {@code minRows=1}; the cluster ITs set this to a small value).  
     *  
        false,  
     * worker tier, per-partition) + FINAL (gathered to the coordinator) by the general post-CBO pass  
        "analytics.mpp.compression.zstd.level",  
        Setting.Property.NodeScope,
     * which also makes this an incident-response kill switch and the A/B baseline. QA test clusters
 * that gate engine-side behavior independent of the chosen backend.
     * Exceeding it (or hitting a disk-full / write I/O error) is the new terminal failure when spill
    /**
    public static final Setting<Boolean> MPP_SHUFFLE_PRUNE_COLUMNS = Setting.boolSetting(  
import org.opensearch.common.unit.TimeValue;
     *
     * not exceed this many bytes. When the build stage's accumulated Arrow IPC exceeds this  
     *  
    );  
        MPP_SHUFFLE_SPILL_MAX_BYTES,  
     * best ratio) or {@code lz4} (native lz4-java LZ4-frame). Only the writer consults this; the
    public static final Setting<Long> MPP_DISTRIBUTE_MIN_ROWS = Setting.longSetting(
     * selectivity). On a runtime overflow the coordinator re-plans without broadcast (falling back  
}
     * {@code transpose} lowers to — is left untouched). Default {@code true}; disable only to isolate a
        TimeValue.timeValueSeconds(1L),  
     * other queries finish) UNLESS a single query's own footprint exceeds the budget, which fails  
    public static final Setting<String> MPP_COMPRESSION_CODEC = Setting.simpleString("analytics.mpp.compression.codec", "zstd", value -> {  
    /**
 * Engine-level cluster settings for analytics-engine. Backend-specific settings live  
    /**
     * I/O error occurs. Gated under {@link #MPP_ENABLED}.
     * are unaffected (a join below the aggregate still runs on its worker tier). Useful as a targeted kill  
     * codec from the IPC metadata, so a mixed-setting (rolling-restart) cluster still decodes correctly.
        Setting.Property.NodeScope,
    public static final Setting<Integer> MPP_SHUFFLE_PARTITIONS = Setting.intSetting(
     * Master switch for MPP (multi-pass parallel) join/aggregate dispatch.
/*  
     * shuffle codec default) — measured faster end-to-end than Arrow's default level 3 (cheaper  
     * Per-partition receive timeout for hash-shuffle consumers. Each consumer task blocks on  
     * (N partitions each under the cap still OOM in aggregate), so the budget is per-NODE.
        MPP_COMPRESSION_ZSTD_LEVEL
 *
        MPP_SHUFFLE_COMPRESS,  
        MPP_SHUFFLE_PARTITIONS,  
     */
     */
     */
     * (see {@code ShuffleBufferManager.spillOldest}) instead of failing fast with
     *
        "analytics.mpp.shuffle.compress",
     * {@code ShuffleBufferExceededException}. This lets multi-GB shuffle intermediates (TPC-H q5/q10
     * Arrow-IPC {@code byte[]} chunks. Those chunks live ON the JVM heap, and a node's live shuffle
    public static final Setting<TimeValue> MPP_SHUFFLE_RECV_TIMEOUT = Setting.timeSetting(  
     * instead of the in-memory hash-join build. When a worker join's build-side (right input) estimated
     * is a backstop against stuck producers (cancelled queries cascade through the walker  
     * serially on the coordinator.
    );
     * Cost-based join reordering for multi-way joins. When {@code true}, a plan with 3+ joins is
        MPP_SHUFFLE_RECV_TIMEOUT,
        TimeValue.timeValueSeconds(60L),
     * cost model toward favoring or disfavoring broadcast in their workload.  
     * all data nodes. Operators can override to tune for selective routing or to nudge the
     */  
    /**
    public static final Setting<Boolean> MPP_SHUFFLE_AGGREGATE_ENABLED = Setting.boolSetting(  
     */
     * Node-level on-heap hash-shuffle budget, as a PERCENT of the JVM max heap ({@code -Xmx}).  
     * defensively, but the validator prevents the confusing case).
     * {@code spill.max_bytes} / disk rather than the on-heap budget. Default 50 GiB
    );
        Setting.Property.Dynamic  
     * on the {@code PUT} rather than crashing the first compressed shuffle write.  
    );  
    public static final Setting<Integer> MPP_BROADCAST_PROBE_ESTIMATE = Setting.intSetting(
        1,
     */  
        "analytics.mpp.broadcast.probe_estimate",  
     * {@code DistributionEnforcementPass}, instead of gathering the whole join output and aggregating
import org.opensearch.core.common.unit.ByteSizeValue;  
        }
        100,  
        "analytics.mpp.shuffle.spill.enabled",
        0L,
        MPP_DISTRIBUTE_MIN_ROWS,
     *
     * PARTIAL-on-worker / FINAL-on-coordinator split. When {@code false}, the enforcement pass does NOT  
        Setting.Property.NodeScope,
     * the rest of query execution; bounds runaway buffers well before OOM. Operator remediation on a  
import java.util.Locale;  
 *  
    /**
     * its {@code ShuffleBuffer} until both producer sides signal {@code isLast}; if no senders
        Setting.Property.Dynamic
     * <p>Below the threshold the worker keeps the (faster, no-sort) hash join. Only worker joins are  
     * is memory-constrained enough to prefer heap headroom over latency. The reader auto-detects the
    /**
        Setting.Property.NodeScope,  
    /**
        "analytics.mpp.shuffle.prune_columns",
    public static final Setting<Boolean> MPP_SHUFFLE_SPILL_ENABLED = Setting.boolSetting(  
     *  
     * behavior — NOT recommended; risks node OOM).  
     * column-prune + filter-pushdown pre-marking rewrites.
     */
        MPP_COMPRESSION_CODEC,
     * Hard disk ceiling for hash-shuffle spill, in bytes, across all of this node's spill files.
     * <p>Default {@code 1_000_000}: well below any TPC-H fact table that needs distributing (partsupp 8M,  
     * spilling. Scoped to plans whose joins are all equi-joins (a cross-join — e.g. what PPL  
        Setting.Property.Dynamic
        Setting.Property.Dynamic
     * coordinator-centric — exactly as if MPP were off, but scoped to aggregation only. Distributed JOINS
     */
     * and the consumer drains spilled chunks back (in arrival order) followed by the in-memory tail —
     * {@code ShuffleBuffer.awaitReady} until both producer sides finish, then drains the accumulated  
     * {@code byte[]} on an 8 GB heap for TPC-H q17 at sf=10). A PER-BUFFER cap can't bound the sum
     * complete within this timeout, the partition fails and the query terminates. The timeout
        BROADCAST_MAX_BYTES,
     * footprint would exceed the on-heap budget spills its oldest buffered Arrow-IPC chunks to disk  
import java.util.List;
     * nodes; backends that don't (Lucene today) return 1 and so opt out of the strategy
    public static final Setting<ByteSizeValue> BROADCAST_MAX_BYTES = Setting.byteSizeSetting(
     * node heap size.  
    );
            throw new IllegalArgumentException("analytics.mpp.compression.codec must be one of [zstd, lz4], got [" + value + "]");  
    );
     * fast and non-retryably with {@code ShuffleBufferExceededException} (waiting can't help — the
     *  
     * Size floor for the general post-CBO distribution-enforcement pass ({@code DistributionEnforcementPass},  
        1,
     */  
    /**
        Setting.Property.NodeScope,
    );
     * {@code 20_000_000}: above the dimension builds that fit comfortably in memory (TPC-H supplier 100K,
/**
        "analytics.mpp.shuffle.recv_timeout",
 * this file be licensed under the Apache-2.0 license or a
     * (a build whose estimated bytes exceed the cap never gets a broadcast alternative), and the
     * lineitem 60M) and well above trivial joins that gather cheaply. Exposed as a setting so the floor is
    );
     * the only MPP scheduler): a join/aggregate is distributed onto a worker tier only when its larger scan
     * tunable per workload AND so integration tests on small datasets can lower it to exercise the
        Setting.Property.Dynamic
     * <p>{@code ShuffleBufferManager} admits a chunk only if the node total stays under
        if (!v.equals("zstd") && !v.equals("lz4") && !v.equals("lz4_frame")) {
     * <p>Gated to 3+ join plans (2-way plans have only one order) and to all-equi-join plans (a
     */
     * Codec used when {@link #MPP_SHUFFLE_COMPRESS} is on — {@code zstd} (default; native zstd-jni,  
     * captured + replicated. Operators broadcasting larger builds can raise this; very large builds
     *
        Setting.Property.Dynamic
     * Runtime cap: the build-side IPC payload assembled by the coordinator-side capture sink may
     * entirely (the split rule refuses to fire when partitionCount ≤ 1).  
        0L,
    public static final Setting<Boolean> MPP_ENABLED = Setting.boolSetting(  
     * a large shuffle accumulates its whole input on-heap and OOMs the node (observed: 7.4 GB of  
     */
        "analytics.mpp.join.reorder",
     * to hash-shuffle / coordinator-centric) rather than failing — see {@code DefaultPlanExecutor}.
        53687091200L,  
    );  
        "analytics.mpp.broadcast.max_bytes",  
     * <p>The shuffle consumer is buffer-all-then-drain: a worker blocks on
        MPP_JOIN_REORDER,
     * <p>Default 80(%): generous enough that legitimately-fitting shuffles run while leaving heap for
     * switch when an agg-specific issue is seen, without disabling MPP joins.
     * <p>When {@code false} (default), behavior is byte-identical to the pre-spill fail-fast path: a
     * subtree exceeds this many rows (or a deeper operator already distributed — the cascade continues upward
        Setting.Property.Dynamic
        Setting.Property.NodeScope,
    /**
    private AnalyticsSettings() {}
     * preserving the proven buffer-all consumer contract.
     * operator opts into MPP. When {@code true}, the engine routes joins/aggregates through the
        "analytics.mpp.distribute.min_rows",  
    /**  
    /**
    public static final List<Setting<?>> ALL_SETTINGS = List.of(  
     * {@code AnalyticsSearchBackendPlugin.defaultShuffleParallelism(ClusterState)} — backends  
     * distributed-join latency, and it keeps more queries under the on-heap shuffle budget without
     * small joins — distribution adds shuffle overhead that only pays off at scale.
     * ({@code <directory>/<queryId>/}). Default empty {@code ""} resolves at wiring time to  
     * REJECT_RETRY (transient cross-query contention) path is unchanged either way.  
        false,
     * ({@code 53687091200}). Only consulted when {@link #MPP_SHUFFLE_SPILL_ENABLED} is {@code true}.
    /**
        Setting.Property.Dynamic
     * {@code percent% × maxHeap}; over-budget admissions are rejected for retry (room frees when
     * enable it explicitly (see {@code qa/analytics-engine-rest/build.gradle}) so the MPP path is  
     * reader auto-detects. Validated at settings-apply time so a typo is rejected up front rather than
     */
     * strategy): a decomposable {@code GROUP BY} over a distributed join is split PARTIAL (on the join's
    /**  
    public static final Setting<Boolean> MPP_SHUFFLE_COMPRESS = Setting.boolSetting(
 * alongside their backend (e.g. {@code DatafusionSettings}); this class is for settings
        80,
    public static final Setting<Long> MPP_WORKER_SORT_MERGE_JOIN_MIN_ROWS = Setting.longSetting(
     * ({@code JOIN_TO_MULTI_JOIN} + {@code MULTI_JOIN_OPTIMIZE_BUSHY}) using the per-index row counts
     * exercised in CI.
     * bytes are the SUM across every buffer it holds (all queries/stages/partitions). Without a bound
     * <p>This same value drives the pre-flight planning gate in {@code OpenSearchBroadcastJoinSplitRule}  
     *
     * {@code <path.data>/shuffle_spill} (the node's first data path), so operators rarely need to set
     * (TPC-H) this shrinks the shuffled payload several-fold — the single biggest driver of the
