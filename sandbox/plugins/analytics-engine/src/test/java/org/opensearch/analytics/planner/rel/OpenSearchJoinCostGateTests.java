 *       the join's tableId.</li>
        RelNode right = scanWith(probeTrait);
        // condition; it operates on traits only.
    // ── HASH shape ────────────────────────────────────────────────────────
    private RelOptTable testTable;
        int tableId = testTable.getQualifiedName().hashCode();
    private OpenSearchTableScan scanWith(OpenSearchDistribution dist) {
        assertInfinite("HASH+WORKER join with mismatched partition counts must be rejected", costOf(join));
        // Different partition counts on the two sides — the actual rows can't co-locate.
            rexBuilder.makeInputRef(typeFactory.createSqlType(SqlTypeName.INTEGER), 0),
    public void testCoordSingletonAcceptsCoordSingletonInputs() {
        OpenSearchJoin join = makeJoin(left, right, traitDef.hash(List.of(0), 4));
    // ── helpers ───────────────────────────────────────────────────────────
    private RelOptCluster volcanoCluster;
        OpenSearchJoin join = makeJoin(left, right, traitDef.hash(List.of(0), 4));
    // ── SINGLETON shape ───────────────────────────────────────────────────
        assertNotInfinite("COORD+SINGLETON join with COORD+SINGLETON inputs must be accepted", costOf(join));
        int tableId = testTable.getQualifiedName().hashCode();
        assertTrue(message + " (got " + cost + ")", cost.isInfinite());
/**
 */
    public void testBroadcastShapeAcceptsBroadcastBuildPlusShardProbe() {
    public void testBroadcastShapeRejectsWrongTableIdProbe() {
        RelNode build = scanWith(traitDef.broadcast(/* probeNodes */ 3));
 * compatible open source license.
            SqlStdOperatorTable.EQUALS,
        traitDef = context.getDistributionTraitDef();
        OpenSearchJoin join = makeJoin(left, right, traitDef.from(probeTrait));
import org.apache.calcite.rex.RexBuilder;
        // Both inputs broadcast → no probe → no localized execution location for the join.
import org.apache.calcite.plan.RelOptCost;
    @Override
        int tableId = testTable.getQualifiedName().hashCode();
}
    }
import org.apache.calcite.rel.core.JoinRelType;
    }
        // Equi condition on the first column of each side. The cost gate ignores the
    public void testHashWorkerAcceptsMatchingHashInputs() {
    }
        );
import org.apache.calcite.plan.RelTraitSet;
        RelNode left = scanWith(traitDef.hash(List.of(0), 4));
    }
        // Need a self trait that's broadcast-shape (RANDOM+SHARD); use any tableId.
 * the load-bearing constraint that prevents Volcano from producing nonsensical plans like
        RelNode right = scanWith(traitDef.hash(List.of(2), 4));
import org.apache.calcite.rel.metadata.RelMetadataQuery;
 * with explicit (selfTrait, leftInputTrait, rightInputTrait) traits and asserts the cost
        OpenSearchDistribution wrongProbe = traitDef.shardRandom(wrongTableId, 3);
        OpenSearchJoin join = makeJoin(b1, b2, traitDef.shardRandom(tableId, 3));
        RelNode right = scanWith(traitDef.coordSingleton());
    public void setUp() throws Exception {
    }
        OpenSearchJoin join = makeJoin(probe, build, traitDef.from(probeTrait));
    public void testBroadcastShapeRejectsTwoBroadcastInputs() {
        assertNotInfinite("Broadcast shape with left=probe, right=build must be accepted", costOf(join));
 *   <li>HASH+WORKER (hash-shuffle): both inputs HASH+WORKER with same partition count.</li>
    }
        PlannerContext context = buildContext("parquet", /* shardCount */ 3, intFields());
        RelTraitSet joinTraits = RelTraitSet.createEmpty().plus(OpenSearchConvention.INSTANCE).plus(selfTrait);
    }
    }
 *   <li>SINGLETON: COORDINATOR+SINGLETON or SHARD+SINGLETON, inputs match self.</li>
import org.opensearch.analytics.spi.FieldStorageInfo;
        int tableId = testTable.getQualifiedName().hashCode();
        assertInfinite("Broadcast shape with mismatched probe tableId must be rejected", costOf(join));
        RelNode probe = scanWith(probeTrait);
 *
 * <ol>
    }
        RelNode left = scanWith(traitDef.coordSingleton());
import org.apache.calcite.plan.ConventionTraitDef;
     *  go through the full table-scan rule pipeline — that triggers planner registration and
        RexNode condition = rexBuilder.makeCall(
        OpenSearchJoin join = makeJoin(build, probe, traitDef.shardRandom(joinTableId, 3));
 * <p>The three legal join shapes:
        OpenSearchDistribution probeTrait = traitDef.shardRandom(tableId, /* shardCount */ 3);
import org.apache.calcite.rex.RexNode;
import org.apache.calcite.sql.type.SqlTypeName;
        RelNode build = scanWith(traitDef.broadcast(/* probeNodes */ 3));
    }
        OpenSearchJoin join = makeJoin(left, right, traitDef.coordSingleton());
        return join.computeSelfCost(volcano, RelMetadataQuery.instance());
            rexBuilder.makeInputRef(typeFactory.createSqlType(SqlTypeName.INTEGER), left.getRowType().getFieldCount())
    private RelOptCost costOf(OpenSearchJoin join) {
public class OpenSearchJoinCostGateTests extends BasePlannerRulesTests {
        RelNode probe = scanWith(probeTrait);
    private OpenSearchDistributionTraitDef traitDef;
        volcano.addRelTraitDef(traitDef);
    }
        RelNode right = scanWith(traitDef.hash(List.of(2), 8));
     *  changes the trait we care about. Direct construction with a custom trait set lets each
 * "HASH-localized join with one SINGLETON input."
import org.apache.calcite.sql.fun.SqlStdOperatorTable;
        OpenSearchJoin join = makeJoin(left, right, traitDef.hash(List.of(0), 4));
        volcano = new VolcanoPlanner();
    }
    }
        assertInfinite("Broadcast shape requires exactly one REPLICATED build", costOf(join));
        RelNode left = scanWith(traitDef.coordSingleton());
    private VolcanoPlanner volcano;
        OpenSearchDistribution probeTrait = traitDef.shardRandom(tableId, /* shardCount */ 3);
        RelNode left = scanWith(traitDef.hash(List.of(0), 4));
        int tableId = testTable.getQualifiedName().hashCode();
        RelNode probe = scanWith(wrongProbe);
        RelNode build = scanWith(traitDef.broadcast(3));
        RelTraitSet traits = RelTraitSet.createEmpty().plus(OpenSearchConvention.INSTANCE).plus(dist);
package org.opensearch.analytics.planner.rel;
        int wrongTableId = joinTableId + 1;
/*
    public void testBroadcastShapeAcceptsLeftAsProbeRightAsBuild() {
        assertNotInfinite("Broadcast shape (build=REPLICATED, probe=SHARD+RANDOM) must be accepted", costOf(join));
        // Both shards, no broadcast — that's the regular SHARD+SINGLETON co-location, but
    private OpenSearchJoin makeJoin(RelNode left, RelNode right, OpenSearchDistribution selfTrait) {
        // Locality mismatch: SHARD-localized inputs into a COORD-localized join.
        assertInfinite("HASH+WORKER join with mixed SINGLETON/HASH inputs must be rejected", costOf(join));
    private static void assertNotInfinite(String message, RelOptCost cost) {
    public void testHashWorkerRejectsSingletonInput() {
    public void testCoordSingletonRejectsShardSingletonInputs() {
 *
        super.setUp();
 * gate either accepts (returns a finite cost) or rejects (returns infinite). The gate is
import java.util.List;
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.analytics.planner.BasePlannerRulesTests;
import org.apache.calcite.plan.RelOptTable;
        OpenSearchDistribution probeTrait = traitDef.shardRandom(tableId, 3);
        int joinTableId = testTable.getQualifiedName().hashCode();
        assertInfinite("COORD+SINGLETON join with SHARD inputs must be rejected", costOf(join));
        volcano.addRelTraitDef(ConventionTraitDef.INSTANCE);
        RelNode left = scanWith(probeTrait);
import org.apache.calcite.plan.RelOptCluster;
 * Cost-gate matrix for {@link OpenSearchJoin#computeSelfCost}. Each test constructs a join
    }
        return new OpenSearchTableScan(volcanoCluster, traits, testTable, List.of("mock-parquet"), List.<FieldStorageInfo>of());
    /** Build an OpenSearchTableScan stub carrying the requested distribution trait. We don't
import org.apache.calcite.rel.RelNode;
        OpenSearchJoin join = makeJoin(left, right, traitDef.coordSingleton());
import org.opensearch.analytics.planner.PlannerContext;
        return new OpenSearchJoin(volcanoCluster, joinTraits, left, right, condition, JoinRelType.INNER, List.of("mock-parquet"));
        RelNode right = scanWith(traitDef.shardSingleton(tableId, 1));
        // Probe's tableId doesn't match the join's self tableId → the probe is from a
    /** Build an OpenSearchJoin over two inputs at the requested self trait. */
        RelNode left = scanWith(traitDef.shardSingleton(tableId, 1));
        assertInfinite("Broadcast shape with two REPLICATED inputs must be rejected (no probe)", costOf(join));
        // Probe-side trait drives the join's own trait (tableId/shardCount carry over).
        RelNode b2 = scanWith(traitDef.broadcast(3));
        volcanoCluster = RelOptCluster.create(volcano, new RexBuilder(typeFactory));
import org.apache.calcite.plan.volcano.VolcanoPlanner;
        OpenSearchJoin join = makeJoin(build, probe, traitDef.from(probeTrait));
    }
    public void testBroadcastShapeRejectsTwoShardProbeInputs() {
     *  cost-gate case isolate the trait combination under test. */
    private static void assertInfinite(String message, RelOptCost cost) {
 */
 * The OpenSearch Contributors require contributions made to
 *   <li>RANDOM+SHARD (broadcast): one BROADCAST+REPLICATED build, one SHARD probe matching
        // RANDOM doesn't co-locate by key. The gate doesn't recognize this combo as broadcast.
        assertFalse(message + " (got " + cost + ")", cost.isInfinite());
        // different index, can't be the join's local probe.
        // Build can be on either side; the gate doesn't care which.
        // Type mismatch: SINGLETON input into HASH-localized join.
        testTable = mockTable("test_index", "status", "size");
    // ── BROADCAST shape ───────────────────────────────────────────────────
        RelNode right = scanWith(traitDef.hash(List.of(2), 4));
        assertNotInfinite("HASH+WORKER join with matching-N HASH inputs must be accepted", costOf(join));
 * </ol>
 * this file be licensed under the Apache-2.0 license or a
        RelNode b1 = scanWith(traitDef.broadcast(3));
    }
    public void testHashWorkerRejectsMismatchedPartitionCounts() {
