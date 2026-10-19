import org.opensearch.core.index.Index;
import org.opensearch.analytics.planner.BasePlannerRulesTests;
        dataNodes.put("node-2", mock(DiscoveryNode.class));
    private static ClusterState mockClusterState() {  
import org.apache.calcite.rel.core.JoinRelType;
import org.apache.calcite.rel.RelNode;
        // 60M rows × 8 bytes = 480MB — TPC-H q18-class build side, ~15x the 32MB default cap.  
import org.opensearch.analytics.planner.CapabilityRegistry;  
    }
    }  
    }
        when(mq.getRowCount(build)).thenReturn(null);
    }  
        assertTrue(  
    private RelOptCluster volcanoCluster;
        // (the rules under test don't go through table-scan resolution, but keeping this
        // multi-shard tables — the broadcast rule's matches() requires this trait).  
    }
        OpenSearchJoin equi = makeJoin(/* equi */ true);  
            traits,  
            "a 60M-row VARCHAR build must be suppressed — unspecified precision must not zero the width",  
        // ignoring upper bound. A selective filter (e.g. q17's part WHERE p_brand=… AND p_container=…)
                SqlStdOperatorTable.EQUALS,  
import org.opensearch.cluster.ClusterState;
     *  enough. */
        when(mq.getRowCount(build)).thenReturn(1_000.0); // 1000 × 8B = ~8KB
    // ── equi, mpp.enabled=false ───────────────────────────────────────────  
 *   <tr><td>theta, any settings</td><td>fires</td><td>does NOT</td><td>does NOT</td></tr>
import org.opensearch.analytics.planner.rel.OpenSearchTableScan;
    }
                rexBuilder.makeInputRef(typeFactory.createSqlType(SqlTypeName.INTEGER), leftCols)
        assertFalse("Broadcast rule must not match theta", broadcastRule(/* mppEnabled */ true).matches(stubCallFor(theta)));
        RelNode build = scanWith(traitDef.shardRandom(/* tableId */ 1, /* shardCount */ 3));
        RelMetadataQuery mq = mock(RelMetadataQuery.class);
        // cap + retry stay the safety net.  
import org.opensearch.analytics.spi.AnalyticsSearchBackendPlugin;
        assertFalse(
 */  
 * <table>
        );
import static org.mockito.Mockito.mock;
import org.opensearch.cluster.metadata.MappingMetadata;  
    public void testEquiJoinMppEnabledFiresBroadcastAndHashRulesNotCoord() {
    public void testBroadcastGateSuppressesBuildOverCap() {  
        // Spark-style optimism: the gate uses the EXPECTED (post-filter) count, not a selectivity-  
        return new OpenSearchJoin(volcanoCluster, joinTraits, left, right, condition, JoinRelType.INNER, List.of("mock-parquet"));
        RelNode build = scanWith(traitDef.shardRandom(/* tableId */ 1, /* shardCount */ 3));  
        RelNode build = scanWithVarcharColumn(traitDef.shardRandom(/* tableId */ 1, /* shardCount */ 3));
                .build()
    }
        assertTrue("Broadcast rule must match equi when mpp.enabled", broadcastRule(/* mppEnabled */ true).matches(stubCallFor(equi)));
                rexBuilder.makeInputRef(typeFactory.createSqlType(SqlTypeName.INTEGER), leftCols)
    public void testBroadcastGateAdmitsBuildWithinCap() {
import org.apache.calcite.plan.volcano.VolcanoPlanner;  
        RelTraitSet traits = RelTraitSet.createEmpty().plus(OpenSearchConvention.INSTANCE).plus(dist);  
        when(indexMetadata.getSettings()).thenReturn(  
 * </table>
        // it. getMaxRowCount is deliberately NOT consulted.
import org.opensearch.cluster.metadata.Metadata;
    }
import org.apache.calcite.sql.fun.SqlStdOperatorTable;  
        // Both mpp settings: theta routes coord-centric.  
        super.setUp();
import org.opensearch.analytics.planner.FieldStorageResolver;
    private PlannerContext makeContext(boolean mppEnabled) {
    private OpenSearchDistributionTraitDef traitDef;  
        MappingMetadata mappingMetadata = mock(MappingMetadata.class);  
            List.<FieldStorageInfo>of()
    }
 *
        // A naive width formula (precision × bytesPerChar) would go negative and zero the estimate,
    public void testThetaJoinDoesNotFireBroadcastRule() {
        RelNode build = scanWith(traitDef.shardRandom(/* tableId */ 1, /* shardCount */ 3));  
            traits,
        assertTrue("Coord rule must match theta when mpp.enabled", coordRule(/* mppEnabled */ true).matches(stubCallFor(theta)));
        OpenSearchJoin theta = makeJoin(/* equi */ false);
    }
        RelMetadataQuery mq = mock(RelMetadataQuery.class);
 * — Volcano picks within the set by cost, but it can only pick from what the rules emit.
import java.util.List;
import org.apache.calcite.rex.RexBuilder;
 */
            "build estimated at ~8KB must be admitted under a 32MB cap",
            OpenSearchBroadcastJoinSplitRule.buildSideFitsBroadcast(build, mq, 32L * 1024 * 1024)
            settings  
import org.apache.calcite.plan.RelTraitSet;
                .putList("index.composite.secondary_data_formats", "lucene")  
        when(nodes.getDataNodes()).thenReturn(dataNodes);
        when(state.metadata()).thenReturn(metadata);  
            "a non-positive cap means 'no limit' — always admit",
        // silently no-op-ing the gate for string-heavy builds. The width must fall back to a positive  
        return state;
     */
        when(state.nodes()).thenReturn(nodes);
        volcanoCluster = RelOptCluster.create(volcano, new RexBuilder(typeFactory));
 * <p>The contract is what makes CBO produce exactly the legal alternative set for each case  
        );
        );  
        OpenSearchJoin equi = makeJoin(/* equi */ true);  
        org.apache.calcite.plan.RelOptRuleCall call = mock(org.apache.calcite.plan.RelOptRuleCall.class);  
     * Tiny ClusterState mock — just enough to satisfy the broadcast rule's
            List.<FieldStorageInfo>of()  
import java.util.Map;  
        );
            : rexBuilder.makeCall(
    }
    /** RelOptRuleCall is awkward to construct directly (package-private constructor in
        // Build two SHARD+RANDOM scans (matches what OpenSearchTableScanRule produces for
     *  VolcanoRuleCall). All matches() calls need is `call.rel(0)`, so a Mockito stub is  
    public void testEquiJoinMppDisabledFiresOnlyCoordRule() {
        return call;
        RelNode build = scanWith(traitDef.shardRandom(/* tableId */ 1, /* shardCount */ 3));  
    // ── helpers ───────────────────────────────────────────────────────────
        );  
            OpenSearchBroadcastJoinSplitRule.buildSideFitsBroadcast(build, mq, 32L * 1024 * 1024)
        assertFalse("Broadcast rule must not match when mpp.disabled", broadcastRule(/* mppEnabled */ false).matches(stubCallFor(equi)));
            "build estimated at 480MB must be suppressed under a 32MB cap so CBO falls back to shuffle/coord",  
        // cap so a large-row-count build is still suppressed.
 *   <caption>Strategy = f(joinType, mpp.enabled, shuffle.enabled)</caption>
        // construct contexts per-test with different settings.
            Settings.builder()
            List.of("mock-parquet"),
 * Validates the matches() contract for the three join split rules per M2's strategy table:  
import org.opensearch.cluster.node.DiscoveryNodes;  
    // the OPTIMISTIC selectivity-aware expected count (getRowCount), Spark-style; the runtime cap +
    public void testThetaJoinFiresCoordRuleRegardlessOfSettings() {
    public void testBroadcastGateEstimatesUnspecifiedPrecisionVarchar() {  
        // A bare VARCHAR column (OpenSearch keyword/text) has precision = PRECISION_NOT_SPECIFIED (-1).
            OpenSearchBroadcastJoinSplitRule.buildSideFitsBroadcast(build, mq, 0L)
    }
    // ── equi, mpp.enabled=true ────────────────────────────────────────────  
    }
        RelTraitSet joinTraits = RelTraitSet.createEmpty().plus(OpenSearchConvention.INSTANCE).plus(traitDef.coordSingleton());  
        DiscoveryNodes nodes = mock(DiscoveryNodes.class);
        traitDef = new OpenSearchDistributionTraitDef(mock(PlannerContext.class));
    }  
        assertTrue(
            "Coord rule must NOT match equi when mpp.enabled — coord-centric is not a competitor for MPP equi joins",
        );
        // makes the mock more robust if a future rule path needs it).
        assertTrue(  
    // which returns null for OpenSearch RelNodes — the bug this gate works around). The gate uses
        RelMetadataQuery mq = mock(RelMetadataQuery.class);
    // The build side here is a scan over two INTEGER columns (status, size) → estimated row width
            volcanoCluster,
    // broadcast→shuffle retry corrects builds whose filter under-delivers.  
 *   <tr><td>equi, mpp.enabled=false</td><td>fires</td><td>does NOT</td><td>does NOT</td></tr>
            OpenSearchBroadcastJoinSplitRule.buildSideFitsBroadcast(build, mq, 32L * 1024 * 1024)
        );
        assertTrue(
    private OpenSearchJoin makeJoin(boolean equi) {
        assertFalse(
 * compatible open source license.
        );
        return new PlannerContext(  
        VolcanoPlanner volcano = new VolcanoPlanner();
            )  
                rexBuilder.makeInputRef(typeFactory.createSqlType(SqlTypeName.INTEGER), 0),  
 * The OpenSearch Contributors require contributions made to  
            volcanoCluster,
        assertTrue("Coord rule must match theta when mpp.disabled", coordRule(/* mppEnabled */ false).matches(stubCallFor(theta)));
    private static org.apache.calcite.plan.RelOptRuleCall stubCallFor(RelNode rel) {
            mockTable("text_index", new String[] { "body" }, new SqlTypeName[] { SqlTypeName.VARCHAR }),
        when(mq.getRowCount(build)).thenReturn(60_000_000.0);
        int leftCols = left.getRowType().getFieldCount();  
            new CapabilityRegistry(List.<AnalyticsSearchBackendPlugin>of(DATAFUSION, LUCENE), FieldStorageResolver::new),
     * resolveProbeNodeEstimate() defensive-check path. Returns a 3-data-node cluster so  
    }  
 * SPDX-License-Identifier: Apache-2.0
        OpenSearchTableScan right = scanWith(traitDef.shardRandom(/* tableId */ 2, /* shardCount */ 3));
            OpenSearchBroadcastJoinSplitRule.buildSideFitsBroadcast(build, mq, 32L * 1024 * 1024)
    public void setUp() throws Exception {  
    private OpenSearchJoinSplitRule coordRule(boolean mppEnabled) {
import org.opensearch.cluster.metadata.IndexMetadata;
import org.opensearch.analytics.spi.FieldStorageInfo;  
     * probeNodes > 1 and the rule actually fires (rather than bailing on the 1-node fallback).
        assertFalse("Hash rule must not match theta", hashRule(/* mppEnabled */ true).matches(stubCallFor(theta)));  
import org.opensearch.analytics.planner.rel.OpenSearchDistribution;
        when(mq.getRowCount(build)).thenReturn(60_000_000.0);
import org.opensearch.analytics.planner.PlannerContext;
            "filtered build estimated at ~8KB must be admitted (optimistic), runtime retry is the backstop",  
import static org.mockito.Mockito.when;  
    }  
            ? rexBuilder.makeCall(
import org.apache.calcite.plan.RelOptCluster;
        assertFalse(
import org.apache.calcite.sql.type.SqlTypeName;
    public void testBroadcastGateTrustsOptimisticFilteredEstimate() {
        when(indexMetadata.getIndex()).thenReturn(new Index("test_index", "test_index-uuid"));
 *
        when(mq.getRowCount(build)).thenReturn(1_000.0); // optimistic post-filter: ~8KB
        assertTrue("Hash rule must match equi when mpp.enabled", hashRule(/* mppEnabled */ true).matches(stubCallFor(equi)));  
        // drops the expected count below the cap → broadcast is admitted even though the unfiltered
        return new OpenSearchBroadcastJoinSplitRule(makeContext(mppEnabled));  
        // table is huge. If the filter under-delivers at runtime, the broadcast→shuffle retry corrects  
    }  
 * this file be licensed under the Apache-2.0 license or a
            );
        when(metadata.index("test_index")).thenReturn(indexMetadata);  
            coordRule(/* mppEnabled */ true).matches(stubCallFor(equi))  
        RelTraitSet traits = RelTraitSet.createEmpty().plus(OpenSearchConvention.INSTANCE).plus(dist);
import org.opensearch.cluster.node.DiscoveryNode;
    // is 4 + 4 = 8 bytes/row, derived from the RelDataType (not RelMetadataQuery.getAverageRowSize,  
    public void testThetaJoinDoesNotFireHashRule() {
        Map<String, DiscoveryNode> dataNodes = new HashMap<>();  
        when(mappingMetadata.sourceAsMap()).thenReturn(Map.of("properties", Map.of()));
    @Override
        OpenSearchTableScan left = scanWith(traitDef.shardRandom(/* tableId */ 1, /* shardCount */ 3));
/**
import org.opensearch.analytics.planner.rel.OpenSearchJoin;  
            OpenSearchBroadcastJoinSplitRule.buildSideFitsBroadcast(build, mq, 32L * 1024 * 1024)
import org.opensearch.analytics.planner.rel.OpenSearchConvention;  
        when(call.<RelNode>rel(0)).thenReturn(rel);
}
            mockClusterState(),
        );  
    private OpenSearchTableScan scanWithVarcharColumn(OpenSearchDistribution dist) {
        RelMetadataQuery mq = mock(RelMetadataQuery.class);
    public void testBroadcastGateAdmitsWhenRowCountUnknown() {
import org.opensearch.common.settings.Settings;
import org.opensearch.analytics.planner.rel.OpenSearchDistributionTraitDef;
        // getRowCount null (no seeded stats). Missing stats must NOT suppress broadcast; the runtime
        return new OpenSearchTableScan(  
public class SplitRuleContractTests extends BasePlannerRulesTests {  
    private OpenSearchHashJoinSplitRule hashRule(boolean mppEnabled) {  
            List.of("mock-parquet"),
package org.opensearch.analytics.planner.rules;
 *   <tr><th>Case</th><th>Coord rule</th><th>Broadcast rule</th><th>Hash rule</th></tr>  
        Settings settings = Settings.builder().put("analytics.mpp.enabled", mppEnabled).build();
        when(mq.getRowCount(build)).thenReturn(60_000_000.0); // 60M rows × ~100B/row ≫ 32MB
        dataNodes.put("node-1", mock(DiscoveryNode.class));
                rexBuilder.makeInputRef(typeFactory.createSqlType(SqlTypeName.INTEGER), 0),
        assertFalse("Hash rule must not match when mpp.disabled", hashRule(/* mppEnabled */ false).matches(stubCallFor(equi)));  
        volcano.addRelTraitDef(org.apache.calcite.plan.ConventionTraitDef.INSTANCE);  
        // Build a minimal trait def that doesn't require a full PlannerContext yet — we'll  
    /** A scan over a single bare VARCHAR column (precision unspecified = PRECISION_NOT_SPECIFIED),  
        when(indexMetadata.mapping()).thenReturn(mappingMetadata);
    // ── theta joins ───────────────────────────────────────────────────────
        RelMetadataQuery mq = mock(RelMetadataQuery.class);  
        RexNode condition = equi
        OpenSearchJoin theta = makeJoin(/* equi */ false);  
/*  
    private OpenSearchBroadcastJoinSplitRule broadcastRule(boolean mppEnabled) {
import org.apache.calcite.rel.metadata.RelMetadataQuery;  
        IndexMetadata indexMetadata = mock(IndexMetadata.class);  
    /**
                SqlStdOperatorTable.LESS_THAN,
        );
            "unknown row count must admit broadcast (runtime backstop)",  
    }  
        RelNode build = scanWith(traitDef.shardRandom(/* tableId */ 1, /* shardCount */ 3));
    // ── broadcast build-side byte gate ─────────────────────────────────────  
        ClusterState state = mock(ClusterState.class);
        );
     *  mirroring an OpenSearch keyword/text field — the case where a naive width formula goes negative. */
        dataNodes.put("node-3", mock(DiscoveryNode.class));  
    }  
        OpenSearchJoin theta = makeJoin(/* equi */ false);
        assertTrue("Coord rule must match equi when mpp.disabled", coordRule(/* mppEnabled */ false).matches(stubCallFor(equi)));
        return new OpenSearchHashJoinSplitRule(makeContext(mppEnabled));
        // Stub a test_index with 3 shards so the table-scan rule could resolve it if invoked  
        return new OpenSearchTableScan(
        volcano.addRelTraitDef(traitDef);
    private OpenSearchTableScan scanWith(OpenSearchDistribution dist) {
 *   <tr><td>equi, mpp.enabled=true</td><td>does NOT</td><td>fires</td><td>fires (if shuffle.enabled)</td></tr>  
import org.apache.calcite.rex.RexNode;
    }  
            mockTable("test_index", "status", "size"),  
                .put("index.composite.primary_data_format", "parquet")
    }
import java.util.HashMap;
        Metadata metadata = mock(Metadata.class);
        return new OpenSearchJoinSplitRule(makeContext(mppEnabled));
    public void testBroadcastGateDisabledWhenCapNonPositive() {
        when(indexMetadata.getNumberOfShards()).thenReturn(3);
        RelMetadataQuery mq = mock(RelMetadataQuery.class);  
