public class OpenSearchJoinCostGateTests extends BasePlannerRulesTests {
    private OpenSearchDistributionTraitDef traitDef;  
        RelNode right = scanWith(traitDef.hash(List.of(2), 8));  
        OpenSearchJoin join = makeJoin(left, right, traitDef.hash(List.of(0), 4));
import org.apache.calcite.plan.RelOptCluster;
        RelNode build = scanWith(traitDef.broadcast(/* probeNodes */ 3));
        traitDef = context.getDistributionTraitDef();
        OpenSearchDistribution probeTrait = traitDef.shardRandom(tableId, /* shardCount */ 3);
        OpenSearchJoin join = makeJoin(left, right, traitDef.from(probeTrait));
    public void testBroadcastShapeRejectsWrongTableIdProbe() {
        // Probe-side trait drives the join's own trait (tableId/shardCount carry over).
        int tableId = testTable.getQualifiedName().hashCode();  
import org.apache.calcite.sql.type.SqlTypeName;
import org.opensearch.analytics.spi.FieldStorageInfo;
        // Probe's tableId doesn't match the join's self tableId → the probe is from a  
    public void testHashWorkerAcceptsMatchingHashInputs() {
        assertNotInfinite("Broadcast shape with left=probe, right=build must be accepted", costOf(join));
 * "HASH-localized join with one SINGLETON input."
    private RelOptCost costOf(OpenSearchJoin join) {
import org.apache.calcite.plan.RelOptCost;  
        return new OpenSearchTableScan(volcanoCluster, traits, testTable, List.of("mock-parquet"), List.<FieldStorageInfo>of());
        OpenSearchJoin join = makeJoin(build, probe, traitDef.shardRandom(joinTableId, 3));
    public void setUp() throws Exception {
    }
    }  
        volcano = new VolcanoPlanner();
    }
        RelNode left = scanWith(traitDef.hash(List.of(0), 4));  
/*  
 * the load-bearing constraint that prevents Volcano from producing nonsensical plans like  
        OpenSearchJoin join = makeJoin(b1, b2, traitDef.shardRandom(tableId, 3));
        return new OpenSearchJoin(volcanoCluster, joinTraits, left, right, condition, JoinRelType.INNER, List.of("mock-parquet"));
        RelNode left = scanWith(traitDef.coordSingleton());  
        // Build can be on either side; the gate doesn't care which.
        RelNode build = scanWith(traitDef.broadcast(3));
        OpenSearchJoin join = makeJoin(build, probe, traitDef.from(probeTrait));  
 * gate either accepts (returns a finite cost) or rejects (returns infinite). The gate is
    }
    }  
        assertInfinite("HASH+WORKER join with mixed SINGLETON/HASH inputs must be rejected", costOf(join));
    public void testCoordSingletonAcceptsCoordSingletonInputs() {
    }
import org.apache.calcite.sql.fun.SqlStdOperatorTable;  
import org.apache.calcite.rel.core.JoinRelType;
     *  go through the full table-scan rule pipeline — that triggers planner registration and
 * compatible open source license.
    }
    private OpenSearchTableScan scanWith(OpenSearchDistribution dist) {
        // Locality mismatch: SHARD-localized inputs into a COORD-localized join.
 *   <li>HASH+WORKER (hash-shuffle): both inputs HASH+WORKER with same partition count.</li>  
            rexBuilder.makeInputRef(typeFactory.createSqlType(SqlTypeName.INTEGER), left.getRowType().getFieldCount())  
    private VolcanoPlanner volcano;
        // Both shards, no broadcast — that's the regular SHARD+SINGLETON co-location, but
import org.apache.calcite.rel.RelNode;
        RelNode probe = scanWith(wrongProbe);  
        RelNode right = scanWith(probeTrait);  
        // condition; it operates on traits only.
        RexNode condition = rexBuilder.makeCall(  
    }  
 * with explicit (selfTrait, leftInputTrait, rightInputTrait) traits and asserts the cost
    // ── helpers ───────────────────────────────────────────────────────────
        volcanoCluster = RelOptCluster.create(volcano, new RexBuilder(typeFactory));
    @Override  
        RelNode right = scanWith(traitDef.shardSingleton(tableId, 1));
        OpenSearchJoin join = makeJoin(left, right, traitDef.coordSingleton());
    // ── BROADCAST shape ───────────────────────────────────────────────────
    private RelOptTable testTable;
        RelNode right = scanWith(traitDef.hash(List.of(2), 4));
package org.opensearch.analytics.planner.rel;
        super.setUp();
    private static void assertInfinite(String message, RelOptCost cost) {  
import org.apache.calcite.rex.RexNode;
 * The OpenSearch Contributors require contributions made to  
import org.apache.calcite.rel.metadata.RelMetadataQuery;  
import org.opensearch.analytics.planner.BasePlannerRulesTests;
        int tableId = testTable.getQualifiedName().hashCode();
}
    public void testCoordSingletonRejectsShardSingletonInputs() {  
        RelNode left = scanWith(traitDef.shardSingleton(tableId, 1));  
        RelNode left = scanWith(traitDef.hash(List.of(0), 4));
        assertInfinite("HASH+WORKER join with mismatched partition counts must be rejected", costOf(join));
        RelNode b1 = scanWith(traitDef.broadcast(3));
        int wrongTableId = joinTableId + 1;  
    }
    public void testBroadcastShapeRejectsTwoShardProbeInputs() {  
    }
        RelNode probe = scanWith(probeTrait);
    }
 *   <li>RANDOM+SHARD (broadcast): one BROADCAST+REPLICATED build, one SHARD probe matching
 */  
 * <p>The three legal join shapes:  
        OpenSearchJoin join = makeJoin(left, right, traitDef.hash(List.of(0), 4));
        OpenSearchJoin join = makeJoin(left, right, traitDef.hash(List.of(0), 4));  
    // ── HASH shape ────────────────────────────────────────────────────────  
    private OpenSearchJoin makeJoin(RelNode left, RelNode right, OpenSearchDistribution selfTrait) {
        assertNotInfinite("COORD+SINGLETON join with COORD+SINGLETON inputs must be accepted", costOf(join));  
        );
        int joinTableId = testTable.getQualifiedName().hashCode();
    public void testBroadcastShapeRejectsTwoBroadcastInputs() {
        RelNode probe = scanWith(probeTrait);
        OpenSearchJoin join = makeJoin(left, right, traitDef.coordSingleton());
        OpenSearchDistribution probeTrait = traitDef.shardRandom(tableId, 3);
        RelNode b2 = scanWith(traitDef.broadcast(3));
        assertNotInfinite("Broadcast shape (build=REPLICATED, probe=SHARD+RANDOM) must be accepted", costOf(join));
        // Need a self trait that's broadcast-shape (RANDOM+SHARD); use any tableId.  
        assertInfinite("Broadcast shape with mismatched probe tableId must be rejected", costOf(join));
import org.apache.calcite.plan.volcano.VolcanoPlanner;  
        PlannerContext context = buildContext("parquet", /* shardCount */ 3, intFields());  
        // Both inputs broadcast → no probe → no localized execution location for the join.  
        assertFalse(message + " (got " + cost + ")", cost.isInfinite());
/**
    public void testBroadcastShapeAcceptsLeftAsProbeRightAsBuild() {
import org.apache.calcite.plan.RelTraitSet;
        int tableId = testTable.getQualifiedName().hashCode();  
    public void testHashWorkerRejectsSingletonInput() {
    public void testBroadcastShapeAcceptsBroadcastBuildPlusShardProbe() {  
        RelNode right = scanWith(traitDef.coordSingleton());
        testTable = mockTable("test_index", "status", "size");  
     *  cost-gate case isolate the trait combination under test. */
        RelNode left = scanWith(probeTrait);
 *
        // Equi condition on the first column of each side. The cost gate ignores the
        int tableId = testTable.getQualifiedName().hashCode();
        // Type mismatch: SINGLETON input into HASH-localized join.  
        RelNode left = scanWith(traitDef.coordSingleton());
        assertInfinite("Broadcast shape with two REPLICATED inputs must be rejected (no probe)", costOf(join));  
 */
import org.apache.calcite.plan.RelOptTable;
    }
        // Different partition counts on the two sides — the actual rows can't co-locate.
    private RelOptCluster volcanoCluster;
 * this file be licensed under the Apache-2.0 license or a
 * Cost-gate matrix for {@link OpenSearchJoin#computeSelfCost}. Each test constructs a join  
        OpenSearchDistribution wrongProbe = traitDef.shardRandom(wrongTableId, 3);
        // different index, can't be the join's local probe.
        RelNode right = scanWith(traitDef.hash(List.of(2), 4));
        RelNode build = scanWith(traitDef.broadcast(/* probeNodes */ 3));  
    }
import org.apache.calcite.rex.RexBuilder;
    private static void assertNotInfinite(String message, RelOptCost cost) {
    }  
        assertInfinite("Broadcast shape requires exactly one REPLICATED build", costOf(join));
import org.opensearch.analytics.planner.PlannerContext;  
        RelTraitSet traits = RelTraitSet.createEmpty().plus(OpenSearchConvention.INSTANCE).plus(dist);  
        OpenSearchJoin join = makeJoin(probe, build, traitDef.from(probeTrait));
        assertNotInfinite("HASH+WORKER join with matching-N HASH inputs must be accepted", costOf(join));  
    /** Build an OpenSearchJoin over two inputs at the requested self trait. */
     *  changes the trait we care about. Direct construction with a custom trait set lets each  
        // RANDOM doesn't co-locate by key. The gate doesn't recognize this combo as broadcast.
        assertInfinite("COORD+SINGLETON join with SHARD inputs must be rejected", costOf(join));  
        OpenSearchDistribution probeTrait = traitDef.shardRandom(tableId, /* shardCount */ 3);  
        return join.computeSelfCost(volcano, RelMetadataQuery.instance());  
        int tableId = testTable.getQualifiedName().hashCode();
    public void testHashWorkerRejectsMismatchedPartitionCounts() {  
 *
        volcano.addRelTraitDef(ConventionTraitDef.INSTANCE);  
            rexBuilder.makeInputRef(typeFactory.createSqlType(SqlTypeName.INTEGER), 0),
    }  
import org.apache.calcite.plan.ConventionTraitDef;
            SqlStdOperatorTable.EQUALS,
 * </ol>  
        assertTrue(message + " (got " + cost + ")", cost.isInfinite());
    }  
 * <ol>
    // ── SINGLETON shape ───────────────────────────────────────────────────  
import java.util.List;  
    /** Build an OpenSearchTableScan stub carrying the requested distribution trait. We don't
 *   <li>SINGLETON: COORDINATOR+SINGLETON or SHARD+SINGLETON, inputs match self.</li>
 * SPDX-License-Identifier: Apache-2.0
 *       the join's tableId.</li>
        volcano.addRelTraitDef(traitDef);
        RelTraitSet joinTraits = RelTraitSet.createEmpty().plus(OpenSearchConvention.INSTANCE).plus(selfTrait);  
