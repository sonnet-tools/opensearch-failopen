            case TINYINT:
        // Default: cluster's data-node count. Defensive against partially-mocked ClusterState  
        } else {  
        JoinInfo info = join.analyzeCondition();  
    }  
            case SMALLINT:  
    @Override  
import org.opensearch.analytics.planner.PlannerContext;
        org.opensearch.cluster.ClusterState state = context.getClusterState();
        // the worker join, so the probe-side HashJoinExec applies the residual as a join filter after
            return true;  
            // Broadcast offers no parallelism gain over coord-centric on a 1-node cluster
 *       every probe node; the runtime {@code BroadcastCaptureSink} hard-fails with
import org.apache.calcite.rel.RelDistribution;
            case REAL:  
        int probeNodes = resolveProbeNodeEstimate(join.getLeft());  
 * (broadcast cost = build_rows × probe_nodes; hash cost = total_rows + setup × N).
import org.opensearch.analytics.planner.rel.OpenSearchJoin;
        OpenSearchJoin join = call.rel(0);
            || joinType == JoinRelType.SEMI
     * tableId so the cost gate can validate.
    public OpenSearchBroadcastJoinSplitRule(PlannerContext context) {  
     *  benefit) which causes the rule to bail. */  
    private static final Logger logger = LogManager.getLogger(OpenSearchBroadcastJoinSplitRule.class);
 */  
            case BIGINT:
 *       traits but no exchange has wrapped them yet). Without this gate the rule re-fires  
            emitBroadcastAlternative(call, join, /* buildSide = */ false, probeNodes);
    }
                return defaultWidth;  
        // OpenSearchBroadcastExchange via OpenSearchDistributionTraitDef.convert.  
            workerJoin = join.copy(joinTraits, join.getCondition(), probeSide, broadcastBuild, join.getJoinType(), join.isSemiJoinDone());
            total += averageTypeWidthBytes(field.getType());
 *
                return precision > 0 ? Math.min(precision, variableWidthCap) : variableWidthCap;
     * estimate — a build that filters less than predicted and overflows the runtime cap — is caught
    @Override  
        OpenSearchDistribution ld = distributionOf(join.getLeft());
        // Demand BROADCAST+REPLICATED on the build side. Volcano materializes an
        // CBO so the join routes through hash-shuffle / coordinator-centric instead.
     */
     * expected post-filter estimate — NOT the selectivity-ignoring {@code getMaxRowCount} upper
import org.apache.calcite.rel.RelNode;  
 *       coordinator-centric at planning time instead of failing at runtime. The estimate is  
    public boolean matches(RelOptRuleCall call) {
            return false;  
        double estimatedBytes = rows * avgRowWidth;
        Integer override = AnalyticsSettings.MPP_BROADCAST_PROBE_ESTIMATE.get(context.getSettings());
        }  
 * <p>For INNER joins, emits two alternatives (left-as-build, right-as-build) and lets cost  
        if (probeNodes <= 1) {
            return true;
        // AND a residual non-equi predicate (e.g. TPC-H q14: l_partkey=p_partkey AND l_shipdate
        // BYTES_PER_CHARACTER in Calcite's RelMdSize is 2 (UTF-16 estimate).
    /**
 *
        call.transformTo(workerJoin);
                "[BroadcastJoinSplitRule] suppressing broadcast alternative: estimated build-side {} bytes "  
     *  data-node count when the setting is unset (-1). The {@code anyChild} parameter lets us  
     * Estimates whether replicating {@code buildSide} stays within the broadcast byte cap.  
        // BETWEEN …). emitBroadcastAlternative copies the FULL join condition (equi + residual) onto  
            || joinType == JoinRelType.ANTI;  
        if (!leftAsBuildEligible && !rightAsBuildEligible) {
     * Calcite's {@code RelMdSize.averageTypeValueSize} heuristics (fixed-width types by precision;
/*  
            );  
                return precision > 0 ? (double) precision * bytesPerChar : variableWidthCap;  
        }  
     * estimates small and is allowed to broadcast, even though the unfiltered table is huge. A  
        // yield a negative width that silently zeroes the row estimate and no-ops the size gate.
 * the other side (the probe) keeps its SHARD+RANDOM trait. The join itself runs at
            case TIMESTAMP:
        final int bytesPerChar = 2;
     * -with-zone, intervals) fall through to {@code defaultWidth} rather than their exact Calcite
    /**
        // Require at least one EQUI key, but do NOT require info.isEqui(): a join may carry equi keys
     * Per-column average width in bytes — a LOCAL heuristic in the spirit of Calcite's
        }
            RelTrait trait = rel.getTraitSet().getTrait(i);
        return total;
    }
        // the equi match. A PURE-theta / cross join (no equi key) still bails (empty leftKeys) and
        }
        for (org.apache.calcite.rel.type.RelDataTypeField field : rowType.getFieldList()) {
    }  
            return override;
                maxBytes
        }  
        boolean rightAsBuildEligible = joinType == JoinRelType.INNER  
     * <p>Row width is derived from the build-side {@code RelDataType} directly (sum of per-column
    /** Resolves the probe-node estimate from the cluster setting, defaulting to the cluster's
 * this file be licensed under the Apache-2.0 license or a
            return defaultWidth;
    /**
            case FLOAT:
        long maxBytes = AnalyticsSettings.BROADCAST_MAX_BYTES.get(context.getSettings()).getBytes();  
                    + "(rows={}, avgRowWidth={}) exceeds analytics.mpp.broadcast.max_bytes={} — leaving shuffle/coord-centric to CBO",
 * @opensearch.internal  
            // (or in test fixtures with a stubbed ClusterState). Leave alternative space to  
        final double variableWidthCap = 100d;
        OpenSearchDistribution probeDist = distributionOf(probeSide);  
        }
            return;
 *       {@code BroadcastSizeExceededException} when the captured payload exceeds that cap. This  
        }
                return precision > 0 ? Math.min((double) precision * bytesPerChar, variableWidthCap) : variableWidthCap;
     * {@code RelMdSize.averageTypeValueSize} (fixed-width types by size, variable-width CHAR/VARCHAR/  
        return dist.getLocality() == OpenSearchDistribution.Locality.SHARD;
     * behind a selective filter (e.g. TPC-H q17's {@code part WHERE p_brand=… AND p_container=…})
     * conservative max-bound would suppress those legitimate broadcasts. The cost of trusting the
        // SHARD-distributed scans (untouched by an exchange).
            case INTEGER:
     *  unwrapped scan (or scan-shaped subtree) without an exchange already on top. */
/**  
 *  
     * RelNodes don't register a {@code BuiltInMetadata.Size} handler, so {@code getAverageRowSize}  
        convert(workerJoin, coordTraits);
        // routes coord-centric, matching the existing policy that pure-theta joins are not broadcast.  
import org.apache.logging.log4j.LogManager;
        // Decide which sides are eligible as the build:
        JoinRelType joinType = join.getJoinType();  
                return 8d;  
     * <p>Returns {@code true} (admit broadcast) when the row count is unknown or the row width can't
     * default so a partially-typed row still estimates non-zero rather than collapsing to 0.  
import org.opensearch.analytics.AnalyticsSettings;  
                avgRowWidth,
 * decide which side to broadcast. For LEFT/RIGHT/FULL outer joins, only the row-preserved
        // Coord still gathers the joined output. Register the gather alternative in the memo
        }
            return;
        }  
     */
            return 1;
import org.apache.calcite.rel.metadata.RelMetadataQuery;  
        return Math.max(state.nodes().getDataNodes().size(), 1);  
        RelNode buildSide = leftIsBuild ? join.getLeft() : join.getRight();
     * join's own trait is the probe side's SHARD+RANDOM, which propagates the probe's
     * Estimate = {@code rows × avgRowWidth} (the whole build side is materialized + replicated, so
    }  
        this.context = context;
        RelNode broadcastBuild = convert(buildSide, buildTraits);  
 *       pre-flight gate stops CBO from ever emitting a broadcast alternative whose build side is
     *  
            // COORDINATOR_CENTRIC for telemetry.
            case DOUBLE:  
        // SEMI / ANTI — build = right (M0/M1 contract).  
     * matches Calcite's own per-type width heuristics (see {@code RelMdSize.averageTypeValueSize}).
                // Even in large (e.g. VARCHAR(2000)) columns most strings are small; unspecified
 */
            workerJoin = join.copy(joinTraits, join.getCondition(), broadcastBuild, probeSide, join.getJoinType(), join.isSemiJoinDone());
                rows,  
 * worker via {@link org.opensearch.analytics.planner.rel.OpenSearchBroadcastExchange} and
        if (!fits && logger.isDebugEnabled()) {
 *   <li>{@code JoinInfo.isEqui()} must be true. Theta routes through the coord-centric path.</li>
import org.opensearch.analytics.planner.rel.OpenSearchDistribution;
import org.apache.calcite.plan.RelTraitSet;
        this.distTraitDef = context.getDistributionTraitDef();  
        if (state == null || state.nodes() == null) {  
        // LEFT — left rows must be preserved → left is probe → build = right.
        }
    /** True when {@code rel}'s OpenSearchDistribution is SHARD-localized — i.e. the rel is an  
        }  
     * filter-reduced {@code stats.sizeInBytes} against {@code autoBroadcastJoinThreshold}: a build
        boolean leftAsBuildEligible = joinType == JoinRelType.INNER || joinType == JoinRelType.RIGHT;
        // (shuffle) / OpenSearchJoinSplitRule (coord-centric), so CBO never picks a doomed broadcast that
     *  
 *   <li>Probe-node estimate (from cluster setting / data-node count) must be ≥ 1.</li>
        }  
        OpenSearchDistribution rd = distributionOf(join.getRight());  
public class OpenSearchBroadcastJoinSplitRule extends RelOptRule {
     * be estimated: missing stats must not suppress broadcast. A cap of {@code 0} (or negative)
                return 1d;
 * </ul>
     *  
        // so a parent demanding COORDINATOR+SINGLETON can find it.
     * the same end; we re-plan on the capture-sink overflow instead.
 * Broadcast-join split rule (M2). Sibling of {@link OpenSearchJoinSplitRule} (coord-centric)
     *  
        if (avgRowWidth <= 0) {
        if (joinDist.getLocality() != OpenSearchDistribution.Locality.SHARD) return false;  
        // with RelDataType.PRECISION_NOT_SPECIFIED (-1), and feeding -1 into the formulas below would  
    private final OpenSearchDistributionTraitDef distTraitDef;
        return isShardScan(join.getLeft()) && isShardScan(join.getRight());  
        RelTraitSet joinTraits = join.getTraitSet().replace(distTraitDef.from(probeDist));
    private int resolveProbeNodeEstimate(RelNode anyChild) {
     * type widths), NOT from {@code RelMetadataQuery.getAverageRowSize}: the {@code OpenSearch*}
            emitBroadcastAlternative(call, join, /* buildSide = */ true, probeNodes);
    }
import org.apache.calcite.rel.core.JoinRelType;
    }
    private static double averageTypeWidthBytes(org.apache.calcite.rel.type.RelDataType type) {  
        // distribution copy preserves probe's tableId / shardCount (used by the cost gate).
        }  
 *       {@code rowCount × avgRowSize}; when either is unknown (no seeded stats) the gate admits
            || joinType == JoinRelType.LEFT
        }
    private void emitBroadcastAlternative(RelOptRuleCall call, OpenSearchJoin join, boolean leftIsBuild, int probeNodes) {  
        RelMetadataQuery mq = call.getMetadataQuery();
            return false;
        int precision = type.getPrecision(); // may be PRECISION_NOT_SPECIFIED (-1)
        }
import org.apache.calcite.rel.core.JoinInfo;
            case DATE:
        // Width estimate for variable-width string/binary columns: Calcite caps these at 100 bytes  
     * returns {@code null} for them. Computing from the row type keeps the gate self-contained and
                // precision (the common OpenSearch keyword/text case) falls back to the cap.  
        // the runtime BroadcastCaptureSink would reject. See the class javadoc "build-side bytes" gate.
        if (joinDist == null) return false;
        if (type.getSqlTypeName() == null) {
    private static boolean joinAlreadyResolvedAsBroadcast(OpenSearchJoin join) {
        // Probe side keeps its SHARD+RANDOM trait — no exchange. The join sits at the same
 *       estimated to blow the cap, so a too-large build falls back to hash-shuffle /
        return fits;
                (long) estimatedBytes,
 *       broadcast and the runtime cap stays the safety net — gating on missing stats would
     * <p><b>Optimistic, selectivity-aware row count.</b> We gate on {@code getRowCount} — the
        super(operand(OpenSearchJoin.class, any()), "OpenSearchBroadcastJoinSplitRule");
        // Already a broadcast-shape join — at least one input should be REPLICATED.
     * by the runtime {@code BroadcastSizeExceededException} + broadcast→shuffle re-plan  
    }  
import org.apache.calcite.plan.RelOptRuleCall;
     * means "no limit configured" → always admit.  
        // FULL — neither side can be duplicated; broadcast doesn't apply.
     * Average bytes per row for a {@code RelDataType}, summed over per-column type widths. Mirrors  
        if (dist == null) return false;
        OpenSearchDistribution broadcastDist = distTraitDef.broadcast(probeNodes);
            // OpenSearchJoinSplitRule (coord-centric); the strategy advisor will record
            case VARCHAR:
 * compatible open source license.
 *       on the alternatives it produced.</li>
        final double defaultWidth = 8d; // conservative fallback for types we don't special-case  
        RelTraitSet coordTraits = join.getTraitSet().replace(distTraitDef.coordSingleton());  
     * variable-width CHAR/VARCHAR/BINARY capped). Unknown column types contribute a conservative
        // Pre-flight size gate: only emit a broadcast alternative for a build side whose estimated
        // (test fixtures often stub metadata() but not nodes()).
 * SHARD+RANDOM alongside the probe scan; CBO ranks broadcast vs hash via the cost model  
        // broadcast either side but neither preserves rows, so emit both).  
    @SuppressWarnings("unused")
     * BINARY capped), but not an exact mirror: less-common SQL types (unsigned ints, time/timestamp
 * The OpenSearch Contributors require contributions made to  
        double total = 0d;  
import org.apache.calcite.plan.RelOptRule;
     *  keep the API forward-compatible if we ever want per-side estimates. Tolerant of test
        boolean fits = estimatedBytes <= maxBytes;  
        if (override != null && override > 0) {  
 * SPDX-License-Identifier: Apache-2.0
            || (rd != null && rd.getLocality() == OpenSearchDistribution.Locality.REPLICATED);
    private static OpenSearchDistribution distributionOf(RelNode rel) {
                return precision > 0 ? precision : variableWidthCap;
import org.opensearch.analytics.planner.rel.OpenSearchDistributionTraitDef;  
        }
        OpenSearchDistribution dist = distributionOf(rel);  
     * ({@code DefaultPlanExecutor}). Spark relies on AQE measuring materialized shuffle output to
        if (joinDist.getType() != RelDistribution.Type.RANDOM_DISTRIBUTED) return false;
    }
        RelNode probeSide = leftIsBuild ? join.getRight() : join.getLeft();
        }
            case DECIMAL:
        if (info.leftKeys.isEmpty()) {
            return false;  
            case BINARY:
        Double rows = mq.getRowCount(buildSide);  
        if (rightAsBuildEligible && buildSideFitsBroadcast(join.getRight(), mq, maxBytes)) {  
        // precision is unspecified — OpenSearch keyword/text fields commonly arrive as bare VARCHAR
 *   <li>{@code analytics.mpp.enabled} must be true (master MPP kill switch).</li>  
        RelNode workerJoin;  
            case VARBINARY:  
        // RIGHT — right rows preserved → build = left.
    }  
        for (int i = 0; i < rel.getTraitSet().size(); i++) {  
 * <ul>
            return true;
import org.apache.logging.log4j.Logger;
        OpenSearchDistribution joinDist = distributionOf(join);  
 *       Broadcast materializes the whole build side in coordinator memory and replicates it to
                return 4d;
     * bound. This mirrors Spark's plan-time {@code canBroadcastBySize}, which compares the  
     *  fixtures where ClusterState mocks don't stub {@code nodes()}: returns 1 (no broadcast
        // Broadcast made ineligible for this planning attempt — the re-plan after a runtime
     * Emits one broadcast alternative: the chosen build side is wrapped in a broadcast
 *   <li><b>Estimated build-side bytes must be within {@code analytics.mpp.broadcast.max_bytes}.</b>  
     * total — not per-shard — rows are the right quantity).
package org.opensearch.analytics.planner.rules;
     * @param leftIsBuild true if the left side is broadcast (probe = right); false otherwise.
                return 2d;
 *   <li>Both inputs must already carry SHARD+RANDOM (i.e. the planner has stamped scan
     */
     * sizes. That's acceptable here — the result feeds a coarse broadcast size gate backed by a  
        // bytes fit the configured cap. A build that would exceed it is left to OpenSearchHashJoinSplitRule  
import org.apache.calcite.plan.RelTrait;  
    private final PlannerContext context;  
    private static double estimateRowWidthBytes(org.apache.calcite.rel.type.RelDataType rowType) {
            if (trait instanceof OpenSearchDistribution dist) return dist;
        if (probeDist == null) {
    static boolean buildSideFitsBroadcast(RelNode buildSide, RelMetadataQuery mq, long maxBytes) {
            case BOOLEAN:  
        return null;
        if (!AnalyticsSettings.MPP_ENABLED.get(context.getSettings())) {
 * side can be probe; the other must be build. SEMI/ANTI: build is always the right side.
        // since most values are small even in wide columns. We also USE this as the width when the
            return;  
            case TIME:  
 * and {@link OpenSearchHashJoinSplitRule}. Fires on {@link OpenSearchJoin}; emits a
        }
    public void onMatch(RelOptRuleCall call) {
    }
        switch (type.getSqlTypeName()) {
        if (leftIsBuild) {
        if (!context.isBroadcastEligible()) {
 * broadcast-shape alternative where one side (the build) is replicated to every probe-side  
 * <p>Gates:
 *       wrongly suppress broadcast for un-analyzed indices.</li>  
        // INNER, FULL? — both sides eligible (full not handled in M2 spike; left/right could
        return (ld != null && ld.getLocality() == OpenSearchDistribution.Locality.REPLICATED)
 *
            case CHAR:
     * runtime cap + retry, not anything that needs byte-exact accounting.
        OpenSearchJoin join = call.rel(0);
        if (rows == null || rows.isInfinite() || rows.isNaN()) {
    /**
        if (leftAsBuildEligible && buildSideFitsBroadcast(join.getLeft(), mq, maxBytes)) {  
     * exchange (via trait conversion); the other side (probe) keeps its SHARD trait. The  
            default:
        RelTraitSet buildTraits = buildSide.getTraitSet().replace(broadcastDist);
     */
        if (maxBytes <= 0) {  
}
        // broadcast-size overflow (see DefaultPlanExecutor's broadcast→shuffle retry). Stay out of  
        // trait so it runs alongside the probe scan on probe-side data nodes. The  
    private static boolean isShardScan(RelNode rel) {
        // Refuse to fire on already-resolved alternatives. Both inputs must be vanilla
        }
        double avgRowWidth = estimateRowWidthBytes(buildSide.getRowType());
            logger.debug(
