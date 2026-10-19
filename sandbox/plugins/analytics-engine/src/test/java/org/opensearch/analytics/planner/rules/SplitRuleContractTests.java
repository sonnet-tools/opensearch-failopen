    public void testBroadcastGateAdmitsWhenRowCountUnknown() {
        );
            Settings.builder()
    private PlannerContext makeContext(boolean mppEnabled) {
    /** RelOptRuleCall is awkward to construct directly (package-private constructor in
        OpenSearchTableScan left = scanWith(traitDef.shardRandom(/* tableId */ 1, /* shardCount */ 3));
        MappingMetadata mappingMetadata = mock(MappingMetadata.class);
    private OpenSearchHashJoinSplitRule hashRule(boolean mppEnabled) {
            List.<FieldStorageInfo>of()
        return new OpenSearchBroadcastJoinSplitRule(makeContext(mppEnabled));
        );
    }
    }
     * probeNodes > 1 and the rule actually fires (rather than bailing on the 1-node fallback).
    }
        // A bare VARCHAR column (OpenSearch keyword/text) has precision = PRECISION_NOT_SPECIFIED (-1).
import org.opensearch.analytics.planner.CapabilityRegistry;
import org.apache.calcite.plan.RelOptCluster;
        assertTrue("Coord rule must match theta when mpp.enabled", coordRule(/* mppEnabled */ true).matches(stubCallFor(theta)));
            OpenSearchBroadcastJoinSplitRule.buildSideFitsBroadcast(build, mq, 0L)
     */
                rexBuilder.makeInputRef(typeFactory.createSqlType(SqlTypeName.INTEGER), leftCols)
        ClusterState state = mock(ClusterState.class);
}
        return call;
        when(mq.getRowCount(build)).thenReturn(60_000_000.0);
            new CapabilityRegistry(List.<AnalyticsSearchBackendPlugin>of(DATAFUSION, LUCENE), FieldStorageResolver::new),
        OpenSearchTableScan right = scanWith(traitDef.shardRandom(/* tableId */ 2, /* shardCount */ 3));
        return new OpenSearchTableScan(
 */
 * SPDX-License-Identifier: Apache-2.0
        // getRowCount null (no seeded stats). Missing stats must NOT suppress broadcast; the runtime
        assertTrue("Hash rule must match equi when mpp.enabled", hashRule(/* mppEnabled */ true).matches(stubCallFor(equi)));
    }
        );
            OpenSearchBroadcastJoinSplitRule.buildSideFitsBroadcast(build, mq, 32L * 1024 * 1024)
        );
    public void testBroadcastGateEstimatesUnspecifiedPrecisionVarchar() {
        RelMetadataQuery mq = mock(RelMetadataQuery.class);
            )
            "build estimated at 480MB must be suppressed under a 32MB cap so CBO falls back to shuffle/coord",
        );
import org.opensearch.cluster.metadata.MappingMetadata;
        when(indexMetadata.mapping()).thenReturn(mappingMetadata);
import org.opensearch.analytics.planner.FieldStorageResolver;
     *  enough. */
        // Build a minimal trait def that doesn't require a full PlannerContext yet — we'll
        assertFalse(
import org.opensearch.cluster.node.DiscoveryNodes;
                .build()
 *   <tr><th>Case</th><th>Coord rule</th><th>Broadcast rule</th><th>Hash rule</th></tr>
import org.opensearch.cluster.metadata.Metadata;
            List.of("mock-parquet"),
        traitDef = new OpenSearchDistributionTraitDef(mock(PlannerContext.class));
        // silently no-op-ing the gate for string-heavy builds. The width must fall back to a positive
        RelNode build = scanWith(traitDef.shardRandom(/* tableId */ 1, /* shardCount */ 3));
    private OpenSearchTableScan scanWith(OpenSearchDistribution dist) {
        assertFalse("Broadcast rule must not match theta", broadcastRule(/* mppEnabled */ true).matches(stubCallFor(theta)));
        when(state.nodes()).thenReturn(nodes);
    public void testThetaJoinFiresCoordRuleRegardlessOfSettings() {
        );
    }
        return new OpenSearchJoinSplitRule(makeContext(mppEnabled));
            "unknown row count must admit broadcast (runtime backstop)",
        when(mq.getRowCount(build)).thenReturn(60_000_000.0); // 60M rows × ~100B/row ≫ 32MB
            volcanoCluster,
    }
import org.opensearch.analytics.spi.AnalyticsSearchBackendPlugin;
    // ── equi, mpp.enabled=false ───────────────────────────────────────────
        assertFalse("Hash rule must not match when mpp.disabled", hashRule(/* mppEnabled */ false).matches(stubCallFor(equi)));
            "Coord rule must NOT match equi when mpp.enabled — coord-centric is not a competitor for MPP equi joins",
            mockTable("test_index", "status", "size"),
    // ── broadcast build-side byte gate ─────────────────────────────────────
        when(mq.getRowCount(build)).thenReturn(1_000.0); // 1000 × 8B = ~8KB
public class SplitRuleContractTests extends BasePlannerRulesTests {
import org.opensearch.common.settings.Settings;
    }
 * The OpenSearch Contributors require contributions made to
        Settings settings = Settings.builder().put("analytics.mpp.enabled", mppEnabled).build();
        RexNode condition = equi
        OpenSearchJoin theta = makeJoin(/* equi */ false);
    public void testBroadcastGateAdmitsBuildWithinCap() {
        RelNode build = scanWith(traitDef.shardRandom(/* tableId */ 1, /* shardCount */ 3));
import org.opensearch.analytics.planner.rel.OpenSearchTableScan;
            ? rexBuilder.makeCall(
        when(mq.getRowCount(build)).thenReturn(60_000_000.0);
 *
        // cap so a large-row-count build is still suppressed.
        IndexMetadata indexMetadata = mock(IndexMetadata.class);
    // ── helpers ───────────────────────────────────────────────────────────
 * — Volcano picks within the set by cost, but it can only pick from what the rules emit.
        assertTrue("Coord rule must match theta when mpp.disabled", coordRule(/* mppEnabled */ false).matches(stubCallFor(theta)));
        VolcanoPlanner volcano = new VolcanoPlanner();
        assertTrue("Broadcast rule must match equi when mpp.enabled", broadcastRule(/* mppEnabled */ true).matches(stubCallFor(equi)));
            OpenSearchBroadcastJoinSplitRule.buildSideFitsBroadcast(build, mq, 32L * 1024 * 1024)
        RelMetadataQuery mq = mock(RelMetadataQuery.class);
    private OpenSearchBroadcastJoinSplitRule broadcastRule(boolean mppEnabled) {
    /** A scan over a single bare VARCHAR column (precision unspecified = PRECISION_NOT_SPECIFIED),
import java.util.List;
 * <table>
import org.opensearch.cluster.metadata.IndexMetadata;
        return new OpenSearchJoin(volcanoCluster, joinTraits, left, right, condition, JoinRelType.INNER, List.of("mock-parquet"));
        OpenSearchJoin theta = makeJoin(/* equi */ false);
        when(indexMetadata.getNumberOfShards()).thenReturn(3);
import org.opensearch.analytics.planner.rel.OpenSearchConvention;
import org.opensearch.cluster.ClusterState;
    private OpenSearchJoinSplitRule coordRule(boolean mppEnabled) {
        assertTrue(
            OpenSearchBroadcastJoinSplitRule.buildSideFitsBroadcast(build, mq, 32L * 1024 * 1024)
import org.apache.calcite.sql.type.SqlTypeName;
    public void testEquiJoinMppDisabledFiresOnlyCoordRule() {
        assertTrue(
        // table is huge. If the filter under-delivers at runtime, the broadcast→shuffle retry corrects
            OpenSearchBroadcastJoinSplitRule.buildSideFitsBroadcast(build, mq, 32L * 1024 * 1024)
            traits,
import org.opensearch.analytics.planner.rel.OpenSearchDistributionTraitDef;
        RelTraitSet traits = RelTraitSet.createEmpty().plus(OpenSearchConvention.INSTANCE).plus(dist);
        // Stub a test_index with 3 shards so the table-scan rule could resolve it if invoked
        when(metadata.index("test_index")).thenReturn(indexMetadata);
        RelMetadataQuery mq = mock(RelMetadataQuery.class);
            List.of("mock-parquet"),
import org.opensearch.core.index.Index;
     *  VolcanoRuleCall). All matches() calls need is `call.rel(0)`, so a Mockito stub is
import org.apache.calcite.rex.RexNode;
 *
        );
    }
     * resolveProbeNodeEstimate() defensive-check path. Returns a 3-data-node cluster so
    public void setUp() throws Exception {
        // Spark-style optimism: the gate uses the EXPECTED (post-filter) count, not a selectivity-
    private OpenSearchTableScan scanWithVarcharColumn(OpenSearchDistribution dist) {
import static org.mockito.Mockito.mock;
        Map<String, DiscoveryNode> dataNodes = new HashMap<>();
        );
    }
                SqlStdOperatorTable.LESS_THAN,
        assertFalse(
            "build estimated at ~8KB must be admitted under a 32MB cap",
            List.<FieldStorageInfo>of()
 *   <caption>Strategy = f(joinType, mpp.enabled, shuffle.enabled)</caption>
    @Override
import static org.mockito.Mockito.when;
/**
        dataNodes.put("node-2", mock(DiscoveryNode.class));
import java.util.Map;
    }
        // cap + retry stay the safety net.
    }
    private OpenSearchDistributionTraitDef traitDef;
    private OpenSearchJoin makeJoin(boolean equi) {
        when(state.metadata()).thenReturn(metadata);
     *  mirroring an OpenSearch keyword/text field — the case where a naive width formula goes negative. */
        when(call.<RelNode>rel(0)).thenReturn(rel);
        volcano.addRelTraitDef(org.apache.calcite.plan.ConventionTraitDef.INSTANCE);
        OpenSearchJoin equi = makeJoin(/* equi */ true);
        );
        RelMetadataQuery mq = mock(RelMetadataQuery.class);
            : rexBuilder.makeCall(
    // the OPTIMISTIC selectivity-aware expected count (getRowCount), Spark-style; the runtime cap +
                rexBuilder.makeInputRef(typeFactory.createSqlType(SqlTypeName.INTEGER), leftCols)
    private static ClusterState mockClusterState() {
        return state;
        RelNode build = scanWith(traitDef.shardRandom(/* tableId */ 1, /* shardCount */ 3));
    /**
    }
        super.setUp();
        org.apache.calcite.plan.RelOptRuleCall call = mock(org.apache.calcite.plan.RelOptRuleCall.class);
    private RelOptCluster volcanoCluster;
/*
        assertTrue("Coord rule must match equi when mpp.disabled", coordRule(/* mppEnabled */ false).matches(stubCallFor(equi)));
            "filtered build estimated at ~8KB must be admitted (optimistic), runtime retry is the backstop",
 *   <tr><td>equi, mpp.enabled=true</td><td>does NOT</td><td>fires</td><td>fires (if shuffle.enabled)</td></tr>
        // A naive width formula (precision × bytesPerChar) would go negative and zero the estimate,
            volcanoCluster,
    }
import org.opensearch.analytics.planner.BasePlannerRulesTests;
        // construct contexts per-test with different settings.
import org.apache.calcite.rel.RelNode;
        );
        // makes the mock more robust if a future rule path needs it).
    }
        RelNode build = scanWithVarcharColumn(traitDef.shardRandom(/* tableId */ 1, /* shardCount */ 3));
                SqlStdOperatorTable.EQUALS,
                .put("index.composite.primary_data_format", "parquet")
            "a 60M-row VARCHAR build must be suppressed — unspecified precision must not zero the width",
 * this file be licensed under the Apache-2.0 license or a
        // Build two SHARD+RANDOM scans (matches what OpenSearchTableScanRule produces for
    public void testBroadcastGateTrustsOptimisticFilteredEstimate() {
        assertTrue(
    }
import org.apache.calcite.plan.RelTraitSet;
            );
    // is 4 + 4 = 8 bytes/row, derived from the RelDataType (not RelMetadataQuery.getAverageRowSize,
        RelMetadataQuery mq = mock(RelMetadataQuery.class);
 * Validates the matches() contract for the three join split rules per M2's strategy table:
        // drops the expected count below the cap → broadcast is admitted even though the unfiltered
        RelNode build = scanWith(traitDef.shardRandom(/* tableId */ 1, /* shardCount */ 3));
    private static org.apache.calcite.plan.RelOptRuleCall stubCallFor(RelNode rel) {
    public void testThetaJoinDoesNotFireBroadcastRule() {
        RelTraitSet traits = RelTraitSet.createEmpty().plus(OpenSearchConvention.INSTANCE).plus(dist);
package org.opensearch.analytics.planner.rules;
        RelNode build = scanWith(traitDef.shardRandom(/* tableId */ 1, /* shardCount */ 3));
        RelTraitSet joinTraits = RelTraitSet.createEmpty().plus(OpenSearchConvention.INSTANCE).plus(traitDef.coordSingleton());
    public void testBroadcastGateDisabledWhenCapNonPositive() {
import org.apache.calcite.rex.RexBuilder;
        volcanoCluster = RelOptCluster.create(volcano, new RexBuilder(typeFactory));
        return new OpenSearchTableScan(
    }
        // ignoring upper bound. A selective filter (e.g. q17's part WHERE p_brand=… AND p_container=…)
        when(mq.getRowCount(build)).thenReturn(null);
            coordRule(/* mppEnabled */ true).matches(stubCallFor(equi))
    public void testBroadcastGateSuppressesBuildOverCap() {
    }
        assertFalse(
    public void testThetaJoinDoesNotFireHashRule() {
 * compatible open source license.
import org.opensearch.analytics.planner.rel.OpenSearchJoin;
        OpenSearchJoin equi = makeJoin(/* equi */ true);
            "a non-positive cap means 'no limit' — always admit",
    }
import java.util.HashMap;
            mockTable("text_index", new String[] { "body" }, new SqlTypeName[] { SqlTypeName.VARCHAR }),
        return new OpenSearchHashJoinSplitRule(makeContext(mppEnabled));
        when(mappingMetadata.sourceAsMap()).thenReturn(Map.of("properties", Map.of()));
            traits,
        assertFalse("Hash rule must not match theta", hashRule(/* mppEnabled */ true).matches(stubCallFor(theta)));
    public void testEquiJoinMppEnabledFiresBroadcastAndHashRulesNotCoord() {
        int leftCols = left.getRowType().getFieldCount();
 * </table>
import org.opensearch.analytics.planner.rel.OpenSearchDistribution;
 */
        when(nodes.getDataNodes()).thenReturn(dataNodes);
import org.apache.calcite.rel.metadata.RelMetadataQuery;
    }
        dataNodes.put("node-3", mock(DiscoveryNode.class));
    // ── theta joins ───────────────────────────────────────────────────────
            mockClusterState(),
import org.apache.calcite.sql.fun.SqlStdOperatorTable;
     * Tiny ClusterState mock — just enough to satisfy the broadcast rule's
        volcano.addRelTraitDef(traitDef);
import org.opensearch.analytics.planner.PlannerContext;
        DiscoveryNodes nodes = mock(DiscoveryNodes.class);
 *   <tr><td>equi, mpp.enabled=false</td><td>fires</td><td>does NOT</td><td>does NOT</td></tr>
        // multi-shard tables — the broadcast rule's matches() requires this trait).
import org.opensearch.analytics.spi.FieldStorageInfo;
        // it. getMaxRowCount is deliberately NOT consulted.
        // Both mpp settings: theta routes coord-centric.
        assertFalse("Broadcast rule must not match when mpp.disabled", broadcastRule(/* mppEnabled */ false).matches(stubCallFor(equi)));
                .putList("index.composite.secondary_data_formats", "lucene")
import org.apache.calcite.rel.core.JoinRelType;
    // broadcast→shuffle retry corrects builds whose filter under-delivers.
        Metadata metadata = mock(Metadata.class);
import org.opensearch.cluster.node.DiscoveryNode;
    }
        // (the rules under test don't go through table-scan resolution, but keeping this
            settings
    // The build side here is a scan over two INTEGER columns (status, size) → estimated row width
        // 60M rows × 8 bytes = 480MB — TPC-H q18-class build side, ~15x the 32MB default cap.
        OpenSearchJoin theta = makeJoin(/* equi */ false);
        );
                rexBuilder.makeInputRef(typeFactory.createSqlType(SqlTypeName.INTEGER), 0),
    // ── equi, mpp.enabled=true ────────────────────────────────────────────
 *   <tr><td>theta, any settings</td><td>fires</td><td>does NOT</td><td>does NOT</td></tr>
            OpenSearchBroadcastJoinSplitRule.buildSideFitsBroadcast(build, mq, 32L * 1024 * 1024)
        RelMetadataQuery mq = mock(RelMetadataQuery.class);
import org.apache.calcite.plan.volcano.VolcanoPlanner;
        when(mq.getRowCount(build)).thenReturn(1_000.0); // optimistic post-filter: ~8KB
    // which returns null for OpenSearch RelNodes — the bug this gate works around). The gate uses
    }
        assertTrue(
                rexBuilder.makeInputRef(typeFactory.createSqlType(SqlTypeName.INTEGER), 0),
        when(indexMetadata.getSettings()).thenReturn(
        return new PlannerContext(
 * <p>The contract is what makes CBO produce exactly the legal alternative set for each case
        when(indexMetadata.getIndex()).thenReturn(new Index("test_index", "test_index-uuid"));
        dataNodes.put("node-1", mock(DiscoveryNode.class));
