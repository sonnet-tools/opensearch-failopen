        OpenSearchTableScan scan = makeShardScan(/* shardCount */ 3);
 *
        OpenSearchBroadcastExchange broadcast = (OpenSearchBroadcastExchange) converted;
        OpenSearchTableScan scan = makeShardScan(/* shardCount */ 1);
     * Builds an {@link OpenSearchTableScan} attached to {@code volcanoCluster} (rather than the
 * this file be licensed under the Apache-2.0 license or a
        return OpenSearchTableScan.create(
            converted instanceof OpenSearchExchangeReducer
import org.opensearch.analytics.planner.BasePlannerRulesTests;
import org.apache.calcite.rel.RelNode;
    private OpenSearchDistributionTraitDef traitDef;
 * path.
        OpenSearchTableScan scan = makeShardScan(/* shardCount */ 3);
package org.opensearch.analytics.planner.rel;
    public void testConvertHashWithNullPartitionCountThrows() {
            converted instanceof OpenSearchShuffleExchange
    }
 * stores the result as an alternative the cost model evaluates against the no-conversion
        RelOptTable indexNameTable = new TestIndexNameTable(mockTable, "test_index");
                + converted.getClass().getSimpleName(),
        );
        // 1-shard scan is already SHARD+SINGLETON which satisfies anySingleton() (null
        assertTrue(
        volcano.addRelTraitDef(traitDef);
import java.util.List;
        super.setUp();
    }
import org.apache.calcite.plan.volcano.RelSubset;
 */
        RelNode converted = unwrapSubset(traitDef.convert(volcano, scan, broadcastTrait, false));
    }
        RelNode converted = traitDef.convert(volcano, scan, traitDef.anySingleton(), false);
        }
        OpenSearchTableScan scan = makeShardScan(/* shardCount */ 3);
import org.apache.calcite.plan.volcano.VolcanoPlanner;
 *
        // then asking convert() to register them on a different planner would trip that
     * scan against the test's VolcanoPlanner. The scan is otherwise equivalent to what
 * operator demands a trait the input doesn't satisfy, Volcano calls {@code convert(...)} and
    private VolcanoPlanner volcano;
            shardCount,
        assertEquals("partitionCount must propagate from the demanded trait", 4, shuffle.getPartitionCount());
import org.apache.calcite.plan.RelOptCluster;
    }
 * Verifies {@link OpenSearchDistributionTraitDef#convert} materializes the right exchange
        OpenSearchDistribution hashAny = traitDef.hashAny(List.of(0));
 * compatible open source license.
    /** Matches the production {@code IndexNameTable} from {@code OpenSearchTableScanRule}.
    public void setUp() throws Exception {
 * inserting transport between operators with mismatched localities — when a downstream
        // ShuffleExchange would have no concrete count to size partitions against.
     * AssertionError that would fire if {@code convert(...)} tried to register a HEP-cluster
        // hashAny() carries null partitionCount — converter rejects it because the produced
    private static RelNode unwrapSubset(RelNode node) {
public class OpenSearchDistributionTraitDefConvertTests extends BasePlannerRulesTests {
    /** Volcano's {@code planner.register(...)} wraps registered nodes in {@link RelSubset};
 * The OpenSearch Contributors require contributions made to
        );
     * inherited HEP test cluster). This avoids the "RelNode belongs to a different planner"
        traitDef = context.getDistributionTraitDef();
    private static class TestIndexNameTable extends org.apache.calcite.plan.RelOptAbstractTable {
            List.<FieldStorageInfo>of(),
        assertSame("Already-satisfying input must be returned unchanged", scan, converted);
        // Wrap the mock table to carry the bare index name (matches what OpenSearchTableScanRule
/*
    /**
    }
        RelOptTable mockTable = mockTable("test_index", "status", "size");
     */
        if (node instanceof RelSubset subset) {
     * {@code OpenSearchTableScanRule} produces in the real planner pipeline.
    }
    @Override
    }
import org.opensearch.analytics.spi.FieldStorageInfo;
 * manifest as wrong-shaped plans or as the converter throwing where it shouldn't.
     *  unwrap to inspect the underlying RelNode. */
}
        return node;
    private PlannerContext context;
 * RelNode for each demanded trait. This is the cost-driven planner's primary mechanism for
        OpenSearchDistribution hashTrait = traitDef.hash(List.of(0), /* partitionCount */ 4);
import org.apache.calcite.rex.RexBuilder;
            "Converting SHARD+RANDOM to BROADCAST must insert OpenSearchBroadcastExchange, got " + converted.getClass().getSimpleName(),
/**
            traitDef
    private OpenSearchTableScan makeShardScan(int shardCount) {
import org.apache.calcite.plan.RelOptTable;
 * right metadata (partition keys, partition count, probe-node estimate). A bug here would
    public void testConvertReturnsInputUnchangedWhenAlreadySatisfied() {
     *  We can't directly reuse it (private inner class), so we replicate the minimum needed. */
            List.of("mock-parquet"),
 * SPDX-License-Identifier: Apache-2.0
            return best != null ? best : node;
        // locality) — no exchange should be inserted.
    public void testConvertSingletonInsertsExchangeReducer() {
            indexNameTable,
 * <p>Each test asserts the produced RelNode is the right exchange type and carries the
        );
        // invariant. So we build the scan against the volcano-cluster directly.
            "Converting SHARD+RANDOM to HASH must insert OpenSearchShuffleExchange, got " + converted.getClass().getSimpleName(),
        assertTrue("Error message should mention partitionCount; got: " + ex.getMessage(), ex.getMessage().contains("partitionCount"));
        );
            RelNode best = subset.getBestOrOriginal();
        OpenSearchTableScan scan = makeShardScan(/* shardCount */ 3);
        assertEquals("probeNodeEstimate must propagate from the demanded trait", 3, broadcast.getProbeNodeEstimate());
    private RelOptCluster volcanoCluster;
        // distinct from the BasePlannerRulesTests HEP cluster. Calcite enforces "a RelNode
        TestIndexNameTable(RelOptTable delegate, String indexName) {
        OpenSearchDistribution broadcastTrait = traitDef.broadcast(/* probeNodes */ 3);
        OpenSearchShuffleExchange shuffle = (OpenSearchShuffleExchange) converted;
    public void testConvertBroadcastInsertsBroadcastExchange() {
        RelNode converted = unwrapSubset(traitDef.convert(volcano, scan, hashTrait, false));
            "Converting SHARD+RANDOM to COORDINATOR+SINGLETON must insert OpenSearchExchangeReducer, got "
            converted instanceof OpenSearchBroadcastExchange
        // belongs to exactly one planner" — building scans against the test's cluster and
        assertEquals("hashKeys must propagate from the demanded trait", List.of(0), shuffle.getHashKeys());
        }
    }
            volcanoCluster,
        context = buildContext("parquet", /* shardCount */ 3, intFields());
        volcano.addRelTraitDef(org.apache.calcite.plan.ConventionTraitDef.INSTANCE);
    }
        RelNode converted = unwrapSubset(traitDef.convert(volcano, scan, traitDef.coordSingleton(), false));
        IllegalStateException ex = expectThrows(IllegalStateException.class, () -> traitDef.convert(volcano, scan, hashAny, false));
        volcanoCluster = RelOptCluster.create(volcano, new RexBuilder(typeFactory));
        // does in production via its private IndexNameTable).
        assertTrue(
        // We need a context (for the trait def) plus a *fresh* VolcanoPlanner whose cluster is
        volcano = new VolcanoPlanner();
 */
    public void testConvertHashInsertsShuffleExchange() {
        assertTrue(
            super(delegate.getRelOptSchema(), indexName, delegate.getRowType());
import org.opensearch.analytics.planner.PlannerContext;
