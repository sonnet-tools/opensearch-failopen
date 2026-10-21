import org.apache.calcite.plan.RelOptRule;
    public void onMatch(RelOptRuleCall call) {
        // Default: cluster's data-node count. Defensive against partially-mocked ClusterState
            workerJoin = join.copy(joinTraits, join.getCondition(), probeSide, broadcastBuild, join.getJoinType(), join.isSemiJoinDone());
        org.opensearch.cluster.ClusterState state = context.getClusterState();
            return;
                return 4d;
    private static double estimateRowWidthBytes(org.apache.calcite.rel.type.RelDataType rowType) {
import org.apache.logging.log4j.Logger;
        // distribution copy preserves probe's tableId / shardCount (used by the cost gate).
    private final PlannerContext context;
 * the other side (the probe) keeps its SHARD+RANDOM trait. The join itself runs at
        if (!fits && logger.isDebugEnabled()) {
            return true;
 * compatible open source license.
        if (type.getSqlTypeName() == null) {
    public boolean matches(RelOptRuleCall call) {
 * side can be probe; the other must be build. SEMI/ANTI: build is always the right side.
 * <ul>
        // since most values are small even in wide columns. We also USE this as the width when the
 * <p>For INNER joins, emits two alternatives (left-as-build, right-as-build) and lets cost
    private static boolean isShardScan(RelNode rel) {
        // the worker join, so the probe-side HashJoinExec applies the residual as a join filter after
        // OpenSearchBroadcastExchange via OpenSearchDistributionTraitDef.convert.
        // routes coord-centric, matching the existing policy that pure-theta joins are not broadcast.
 *       traits but no exchange has wrapped them yet). Without this gate the rule re-fires
        // Width estimate for variable-width string/binary columns: Calcite caps these at 100 bytes
        if (joinDist == null) return false;
        // SHARD-distributed scans (untouched by an exchange).
        }
 *       Broadcast materializes the whole build side in coordinator memory and replicates it to
            return false;
        return dist.getLocality() == OpenSearchDistribution.Locality.SHARD;
    /** Resolves the probe-node estimate from the cluster setting, defaulting to the cluster's
import org.opensearch.analytics.planner.rel.OpenSearchDistribution;
        if (override != null && override > 0) {
     * <p><b>Optimistic, selectivity-aware row count.</b> We gate on {@code getRowCount} — the
 *       every probe node; the runtime {@code BroadcastCaptureSink} hard-fails with
        // SEMI / ANTI — build = right (M0/M1 contract).
        // Broadcast made ineligible for this planning attempt — the re-plan after a runtime
    }
        this.context = context;
 * <p>Gates:
     * expected post-filter estimate — NOT the selectivity-ignoring {@code getMaxRowCount} upper
 *   <li><b>Estimated build-side bytes must be within {@code analytics.mpp.broadcast.max_bytes}.</b>
     * matches Calcite's own per-type width heuristics (see {@code RelMdSize.averageTypeValueSize}).
     *
        if (maxBytes <= 0) {
        OpenSearchDistribution dist = distributionOf(rel);
        // Decide which sides are eligible as the build:
                avgRowWidth,
        // AND a residual non-equi predicate (e.g. TPC-H q14: l_partkey=p_partkey AND l_shipdate
 *       {@code BroadcastSizeExceededException} when the captured payload exceeds that cap. This
            case TIMESTAMP:
        }
     * <p>Row width is derived from the build-side {@code RelDataType} directly (sum of per-column
import org.apache.calcite.rel.RelDistribution;
                return precision > 0 ? precision : variableWidthCap;
     * Estimate = {@code rows × avgRowWidth} (the whole build side is materialized + replicated, so
 * SHARD+RANDOM alongside the probe scan; CBO ranks broadcast vs hash via the cost model
        RelNode workerJoin;
import org.opensearch.analytics.planner.rel.OpenSearchDistributionTraitDef;
            case REAL:
        RelNode probeSide = leftIsBuild ? join.getRight() : join.getLeft();
import org.apache.calcite.rel.metadata.RelMetadataQuery;
     * total — not per-shard — rows are the right quantity).
     * <p>Returns {@code true} (admit broadcast) when the row count is unknown or the row width can't
     * variable-width CHAR/VARCHAR/BINARY capped). Unknown column types contribute a conservative
 * (broadcast cost = build_rows × probe_nodes; hash cost = total_rows + setup × N).
 *
import org.apache.calcite.rel.core.JoinRelType;
        boolean rightAsBuildEligible = joinType == JoinRelType.INNER
    private final OpenSearchDistributionTraitDef distTraitDef;
        final double variableWidthCap = 100d;
/**
     * type widths), NOT from {@code RelMetadataQuery.getAverageRowSize}: the {@code OpenSearch*}
            // COORDINATOR_CENTRIC for telemetry.
        // (test fixtures often stub metadata() but not nodes()).
            || joinType == JoinRelType.ANTI;
            case FLOAT:
        // Probe side keeps its SHARD+RANDOM trait — no exchange. The join sits at the same
        double estimatedBytes = rows * avgRowWidth;
            case BIGINT:
        // precision is unspecified — OpenSearch keyword/text fields commonly arrive as bare VARCHAR
        call.transformTo(workerJoin);
    /**
        OpenSearchDistribution probeDist = distributionOf(probeSide);
        }
    }
        OpenSearchJoin join = call.rel(0);
    public OpenSearchBroadcastJoinSplitRule(PlannerContext context) {
        return null;
    private static final Logger logger = LogManager.getLogger(OpenSearchBroadcastJoinSplitRule.class);
     * RelNodes don't register a {@code BuiltInMetadata.Size} handler, so {@code getAverageRowSize}
        if (leftIsBuild) {
        OpenSearchJoin join = call.rel(0);
        boolean fits = estimatedBytes <= maxBytes;
     * behind a selective filter (e.g. TPC-H q17's {@code part WHERE p_brand=… AND p_container=…})
        boolean leftAsBuildEligible = joinType == JoinRelType.INNER || joinType == JoinRelType.RIGHT;
        }
        // Require at least one EQUI key, but do NOT require info.isEqui(): a join may carry equi keys
        final double defaultWidth = 8d; // conservative fallback for types we don't special-case
            default:
        return Math.max(state.nodes().getDataNodes().size(), 1);
        // Pre-flight size gate: only emit a broadcast alternative for a build side whose estimated
/*
            RelTrait trait = rel.getTraitSet().getTrait(i);
            if (trait instanceof OpenSearchDistribution dist) return dist;
    /** True when {@code rel}'s OpenSearchDistribution is SHARD-localized — i.e. the rel is an
        // bytes fit the configured cap. A build that would exceed it is left to OpenSearchHashJoinSplitRule
     * join's own trait is the probe side's SHARD+RANDOM, which propagates the probe's
        }
 * @opensearch.internal
 */
        double avgRowWidth = estimateRowWidthBytes(buildSide.getRowType());
 *       estimated to blow the cap, so a too-large build falls back to hash-shuffle /
            // (or in test fixtures with a stubbed ClusterState). Leave alternative space to
     *  benefit) which causes the rule to bail. */
            total += averageTypeWidthBytes(field.getType());
     */
 */
     *  unwrapped scan (or scan-shaped subtree) without an exchange already on top. */
                return precision > 0 ? Math.min(precision, variableWidthCap) : variableWidthCap;
 *   <li>Both inputs must already carry SHARD+RANDOM (i.e. the planner has stamped scan
        }
        // the equi match. A PURE-theta / cross join (no equi key) still bails (empty leftKeys) and
            case DOUBLE:
            return defaultWidth;
    }
        this.distTraitDef = context.getDistributionTraitDef();
     *  fixtures where ClusterState mocks don't stub {@code nodes()}: returns 1 (no broadcast
        if (dist == null) return false;
        RelNode broadcastBuild = convert(buildSide, buildTraits);
                "[BroadcastJoinSplitRule] suppressing broadcast alternative: estimated build-side {} bytes "
    private static double averageTypeWidthBytes(org.apache.calcite.rel.type.RelDataType type) {
        RelMetadataQuery mq = call.getMetadataQuery();
        if (state == null || state.nodes() == null) {
    }
            return 1;
            case TIME:
 *
        // RIGHT — right rows preserved → build = left.
        if (!AnalyticsSettings.MPP_ENABLED.get(context.getSettings())) {
     * Calcite's {@code RelMdSize.averageTypeValueSize} heuristics (fixed-width types by precision;
 * this file be licensed under the Apache-2.0 license or a
        // broadcast either side but neither preserves rows, so emit both).
        JoinInfo info = join.analyzeCondition();
        long maxBytes = AnalyticsSettings.BROADCAST_MAX_BYTES.get(context.getSettings()).getBytes();
            return true;
        return (ld != null && ld.getLocality() == OpenSearchDistribution.Locality.REPLICATED)
     * Emits one broadcast alternative: the chosen build side is wrapped in a broadcast
        if (info.leftKeys.isEmpty()) {
        }
     *  keep the API forward-compatible if we ever want per-side estimates. Tolerant of test
            case CHAR:
            return false;
        if (joinDist.getType() != RelDistribution.Type.RANDOM_DISTRIBUTED) return false;
import org.apache.calcite.plan.RelTraitSet;
        OpenSearchDistribution ld = distributionOf(join.getLeft());
            case BOOLEAN:
                // precision (the common OpenSearch keyword/text case) falls back to the cap.
            return false;
            emitBroadcastAlternative(call, join, /* buildSide = */ false, probeNodes);
        return fits;
    }
        // BYTES_PER_CHARACTER in Calcite's RelMdSize is 2 (UTF-16 estimate).
            || (rd != null && rd.getLocality() == OpenSearchDistribution.Locality.REPLICATED);
        return isShardScan(join.getLeft()) && isShardScan(join.getRight());
 *   <li>{@code analytics.mpp.enabled} must be true (master MPP kill switch).</li>
    private static boolean joinAlreadyResolvedAsBroadcast(OpenSearchJoin join) {
        OpenSearchDistribution broadcastDist = distTraitDef.broadcast(probeNodes);
        }
        // with RelDataType.PRECISION_NOT_SPECIFIED (-1), and feeding -1 into the formulas below would
        if (probeNodes <= 1) {
    }
 * </ul>
import org.apache.calcite.rel.RelNode;
import org.apache.logging.log4j.LogManager;
 *   <li>{@code JoinInfo.isEqui()} must be true. Theta routes through the coord-centric path.</li>
                return precision > 0 ? Math.min((double) precision * bytesPerChar, variableWidthCap) : variableWidthCap;
     * tableId so the cost gate can validate.
        Double rows = mq.getRowCount(buildSide);
        // INNER, FULL? — both sides eligible (full not handled in M2 spike; left/right could
    /**
        if (rightAsBuildEligible && buildSideFitsBroadcast(join.getRight(), mq, maxBytes)) {
        }
        }
package org.opensearch.analytics.planner.rules;
        if (probeDist == null) {
    }
                (long) estimatedBytes,
 *
        Integer override = AnalyticsSettings.MPP_BROADCAST_PROBE_ESTIMATE.get(context.getSettings());
        convert(workerJoin, coordTraits);
        // (shuffle) / OpenSearchJoinSplitRule (coord-centric), so CBO never picks a doomed broadcast that
     * {@code RelMdSize.averageTypeValueSize} (fixed-width types by size, variable-width CHAR/VARCHAR/
     * -with-zone, intervals) fall through to {@code defaultWidth} rather than their exact Calcite
                return defaultWidth;
        // BETWEEN …). emitBroadcastAlternative copies the FULL join condition (equi + residual) onto
                maxBytes
            return;
        // Demand BROADCAST+REPLICATED on the build side. Volcano materializes an
 * and {@link OpenSearchHashJoinSplitRule}. Fires on {@link OpenSearchJoin}; emits a
     *  data-node count when the setting is unset (-1). The {@code anyChild} parameter lets us
     * runtime cap + retry, not anything that needs byte-exact accounting.
            case SMALLINT:
            || joinType == JoinRelType.SEMI
 * SPDX-License-Identifier: Apache-2.0
 * decide which side to broadcast. For LEFT/RIGHT/FULL outer joins, only the row-preserved
     * by the runtime {@code BroadcastSizeExceededException} + broadcast→shuffle re-plan
        // Coord still gathers the joined output. Register the gather alternative in the memo
    }
            // Broadcast offers no parallelism gain over coord-centric on a 1-node cluster
     * @param leftIsBuild true if the left side is broadcast (probe = right); false otherwise.
import org.apache.calcite.plan.RelTrait;
            case VARBINARY:
 *   <li>Probe-node estimate (from cluster setting / data-node count) must be ≥ 1.</li>
        return total;
        OpenSearchDistribution rd = distributionOf(join.getRight());
     * BINARY capped), but not an exact mirror: less-common SQL types (unsigned ints, time/timestamp
     * returns {@code null} for them. Computing from the row type keeps the gate self-contained and
        } else {
        }
        }
            || joinType == JoinRelType.LEFT
     * Average bytes per row for a {@code RelDataType}, summed over per-column type widths. Mirrors
        switch (type.getSqlTypeName()) {
        int probeNodes = resolveProbeNodeEstimate(join.getLeft());
 *
    /**
     */
        if (!leftAsBuildEligible && !rightAsBuildEligible) {
        if (!context.isBroadcastEligible()) {
        // LEFT — left rows must be preserved → left is probe → build = right.
        // trait so it runs alongside the probe scan on probe-side data nodes. The
            case DECIMAL:
     * sizes. That's acceptable here — the result feeds a coarse broadcast size gate backed by a
 *       on the alternatives it produced.</li>
 * Broadcast-join split rule (M2). Sibling of {@link OpenSearchJoinSplitRule} (coord-centric)
        final int bytesPerChar = 2;
     * exchange (via trait conversion); the other side (probe) keeps its SHARD trait. The
    @Override
            return;
     * ({@code DefaultPlanExecutor}). Spark relies on AQE measuring materialized shuffle output to
            return true;
        RelTraitSet buildTraits = buildSide.getTraitSet().replace(broadcastDist);
        for (org.apache.calcite.rel.type.RelDataTypeField field : rowType.getFieldList()) {
     * the same end; we re-plan on the capture-sink overflow instead.
        RelNode buildSide = leftIsBuild ? join.getLeft() : join.getRight();
 *       {@code rowCount × avgRowSize}; when either is unknown (no seeded stats) the gate admits
        // broadcast-size overflow (see DefaultPlanExecutor's broadcast→shuffle retry). Stay out of
                    + "(rows={}, avgRowWidth={}) exceeds analytics.mpp.broadcast.max_bytes={} — leaving shuffle/coord-centric to CBO",
        }
}
                // Even in large (e.g. VARCHAR(2000)) columns most strings are small; unspecified
        if (leftAsBuildEligible && buildSideFitsBroadcast(join.getLeft(), mq, maxBytes)) {
    private void emitBroadcastAlternative(RelOptRuleCall call, OpenSearchJoin join, boolean leftIsBuild, int probeNodes) {
        JoinRelType joinType = join.getJoinType();
    }
                return 8d;
     * estimate — a build that filters less than predicted and overflows the runtime cap — is caught
 *       pre-flight gate stops CBO from ever emitting a broadcast alternative whose build side is
                return 1d;
     */
            case VARCHAR:
        }
        OpenSearchDistribution joinDist = distributionOf(join);
        super(operand(OpenSearchJoin.class, any()), "OpenSearchBroadcastJoinSplitRule");
import org.apache.calcite.plan.RelOptRuleCall;
        }
     * means "no limit configured" → always admit.
import org.opensearch.analytics.AnalyticsSettings;
 * The OpenSearch Contributors require contributions made to
     * bound. This mirrors Spark's plan-time {@code canBroadcastBySize}, which compares the
        for (int i = 0; i < rel.getTraitSet().size(); i++) {
        if (rows == null || rows.isInfinite() || rows.isNaN()) {
        // CBO so the join routes through hash-shuffle / coordinator-centric instead.
import org.opensearch.analytics.planner.rel.OpenSearchJoin;
        double total = 0d;
        }
                rows,
    static boolean buildSideFitsBroadcast(RelNode buildSide, RelMetadataQuery mq, long maxBytes) {
     * Estimates whether replicating {@code buildSide} stays within the broadcast byte cap.
            workerJoin = join.copy(joinTraits, join.getCondition(), broadcastBuild, probeSide, join.getJoinType(), join.isSemiJoinDone());
                return precision > 0 ? (double) precision * bytesPerChar : variableWidthCap;
            // OpenSearchJoinSplitRule (coord-centric); the strategy advisor will record
import org.apache.calcite.rel.core.JoinInfo;
        RelTraitSet joinTraits = join.getTraitSet().replace(distTraitDef.from(probeDist));
 *       wrongly suppress broadcast for un-analyzed indices.</li>
            logger.debug(
            case TINYINT:
        // Refuse to fire on already-resolved alternatives. Both inputs must be vanilla
            return override;
     *
    private int resolveProbeNodeEstimate(RelNode anyChild) {
        int precision = type.getPrecision(); // may be PRECISION_NOT_SPECIFIED (-1)
            case DATE:
        }
 * worker via {@link org.opensearch.analytics.planner.rel.OpenSearchBroadcastExchange} and
            emitBroadcastAlternative(call, join, /* buildSide = */ true, probeNodes);
        // Already a broadcast-shape join — at least one input should be REPLICATED.
    @SuppressWarnings("unused")
     * estimates small and is allowed to broadcast, even though the unfiltered table is huge. A
        // so a parent demanding COORDINATOR+SINGLETON can find it.
     *
            case INTEGER:
     * conservative max-bound would suppress those legitimate broadcasts. The cost of trusting the
        // yield a negative width that silently zeroes the row estimate and no-ops the size gate.
public class OpenSearchBroadcastJoinSplitRule extends RelOptRule {
    /**
     *
     */
        RelTraitSet coordTraits = join.getTraitSet().replace(distTraitDef.coordSingleton());
        }
 *       broadcast and the runtime cap stays the safety net — gating on missing stats would
            );
 * broadcast-shape alternative where one side (the build) is replicated to every probe-side
        if (avgRowWidth <= 0) {
import org.opensearch.analytics.planner.PlannerContext;
        }
                return 2d;
 *       coordinator-centric at planning time instead of failing at runtime. The estimate is
    @Override
        if (joinDist.getLocality() != OpenSearchDistribution.Locality.SHARD) return false;
        // FULL — neither side can be duplicated; broadcast doesn't apply.
     * Per-column average width in bytes — a LOCAL heuristic in the spirit of Calcite's
            case BINARY:
    }
        // the runtime BroadcastCaptureSink would reject. See the class javadoc "build-side bytes" gate.
    private static OpenSearchDistribution distributionOf(RelNode rel) {
     * be estimated: missing stats must not suppress broadcast. A cap of {@code 0} (or negative)
     * filter-reduced {@code stats.sizeInBytes} against {@code autoBroadcastJoinThreshold}: a build
     * default so a partially-typed row still estimates non-zero rather than collapsing to 0.
    }
