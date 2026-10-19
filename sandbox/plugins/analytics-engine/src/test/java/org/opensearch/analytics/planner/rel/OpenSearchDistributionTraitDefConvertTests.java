 * SPDX-License-Identifier: Apache-2.0
        IllegalStateException ex = expectThrows(IllegalStateException.class, () -> traitDef.convert(volcano, scan, hashAny, false));
        OpenSearchDistribution broadcastTrait = traitDef.broadcast(/* probeNodes */ 3);  
        // belongs to exactly one planner" — building scans against the test's cluster and
        // Wrap the mock table to carry the bare index name (matches what OpenSearchTableScanRule  
import org.apache.calcite.plan.RelOptTable;
import org.apache.calcite.plan.volcano.RelSubset;  
            super(delegate.getRelOptSchema(), indexName, delegate.getRowType());
        TestIndexNameTable(RelOptTable delegate, String indexName) {
     * {@code OpenSearchTableScanRule} produces in the real planner pipeline.
            converted instanceof OpenSearchShuffleExchange  
import org.opensearch.analytics.planner.BasePlannerRulesTests;
            List.of("mock-parquet"),  
            RelNode best = subset.getBestOrOriginal();
            indexNameTable,
        // then asking convert() to register them on a different planner would trip that
    /** Matches the production {@code IndexNameTable} from {@code OpenSearchTableScanRule}.
        OpenSearchTableScan scan = makeShardScan(/* shardCount */ 3);  
        RelNode converted = unwrapSubset(traitDef.convert(volcano, scan, traitDef.coordSingleton(), false));
        OpenSearchDistribution hashAny = traitDef.hashAny(List.of(0));  
        context = buildContext("parquet", /* shardCount */ 3, intFields());
 * this file be licensed under the Apache-2.0 license or a
 * inserting transport between operators with mismatched localities — when a downstream
 * The OpenSearch Contributors require contributions made to  
    private RelOptCluster volcanoCluster;
     *  unwrap to inspect the underlying RelNode. */
        volcano = new VolcanoPlanner();  
    }  
    public void testConvertHashWithNullPartitionCountThrows() {
        RelNode converted = traitDef.convert(volcano, scan, traitDef.anySingleton(), false);  
        volcano.addRelTraitDef(traitDef);
            converted instanceof OpenSearchBroadcastExchange
    }
        return node;
        // ShuffleExchange would have no concrete count to size partitions against.
    }
    public void testConvertBroadcastInsertsBroadcastExchange() {
import org.apache.calcite.rex.RexBuilder;  
}
            "Converting SHARD+RANDOM to HASH must insert OpenSearchShuffleExchange, got " + converted.getClass().getSimpleName(),
 * path.
 * RelNode for each demanded trait. This is the cost-driven planner's primary mechanism for  
        assertEquals("partitionCount must propagate from the demanded trait", 4, shuffle.getPartitionCount());
    }  
import org.apache.calcite.plan.RelOptCluster;
    /**  
            traitDef  
        RelOptTable mockTable = mockTable("test_index", "status", "size");
        OpenSearchShuffleExchange shuffle = (OpenSearchShuffleExchange) converted;
        // does in production via its private IndexNameTable).
        RelNode converted = unwrapSubset(traitDef.convert(volcano, scan, broadcastTrait, false));
public class OpenSearchDistributionTraitDefConvertTests extends BasePlannerRulesTests {
        RelNode converted = unwrapSubset(traitDef.convert(volcano, scan, hashTrait, false));
    }
 * manifest as wrong-shaped plans or as the converter throwing where it shouldn't.
        );
    private OpenSearchTableScan makeShardScan(int shardCount) {
    private PlannerContext context;
        assertTrue(
    private static class TestIndexNameTable extends org.apache.calcite.plan.RelOptAbstractTable {  
 *
        if (node instanceof RelSubset subset) {
 * <p>Each test asserts the produced RelNode is the right exchange type and carries the  
            converted instanceof OpenSearchExchangeReducer
        OpenSearchBroadcastExchange broadcast = (OpenSearchBroadcastExchange) converted;
    public void setUp() throws Exception {  
package org.opensearch.analytics.planner.rel;
        // 1-shard scan is already SHARD+SINGLETON which satisfies anySingleton() (null
        volcanoCluster = RelOptCluster.create(volcano, new RexBuilder(typeFactory));  
            shardCount,
            "Converting SHARD+RANDOM to COORDINATOR+SINGLETON must insert OpenSearchExchangeReducer, got "
        assertTrue(  
        OpenSearchTableScan scan = makeShardScan(/* shardCount */ 3);
        volcano.addRelTraitDef(org.apache.calcite.plan.ConventionTraitDef.INSTANCE);
        assertTrue("Error message should mention partitionCount; got: " + ex.getMessage(), ex.getMessage().contains("partitionCount"));  
        assertSame("Already-satisfying input must be returned unchanged", scan, converted);
        // distinct from the BasePlannerRulesTests HEP cluster. Calcite enforces "a RelNode  
        // hashAny() carries null partitionCount — converter rejects it because the produced
     *  We can't directly reuse it (private inner class), so we replicate the minimum needed. */
        }
    public void testConvertHashInsertsShuffleExchange() {
        // We need a context (for the trait def) plus a *fresh* VolcanoPlanner whose cluster is
 * compatible open source license.
 * operator demands a trait the input doesn't satisfy, Volcano calls {@code convert(...)} and
    private OpenSearchDistributionTraitDef traitDef;  
                + converted.getClass().getSimpleName(),  
        return OpenSearchTableScan.create(  
     * scan against the test's VolcanoPlanner. The scan is otherwise equivalent to what
        OpenSearchTableScan scan = makeShardScan(/* shardCount */ 1);  
 * right metadata (partition keys, partition count, probe-node estimate). A bug here would
    public void testConvertReturnsInputUnchangedWhenAlreadySatisfied() {
        // invariant. So we build the scan against the volcano-cluster directly.  
            "Converting SHARD+RANDOM to BROADCAST must insert OpenSearchBroadcastExchange, got " + converted.getClass().getSimpleName(),
        assertEquals("hashKeys must propagate from the demanded trait", List.of(0), shuffle.getHashKeys());  
        OpenSearchDistribution hashTrait = traitDef.hash(List.of(0), /* partitionCount */ 4);
        assertEquals("probeNodeEstimate must propagate from the demanded trait", 3, broadcast.getProbeNodeEstimate());
        );  
        // locality) — no exchange should be inserted.
 * stores the result as an alternative the cost model evaluates against the no-conversion  
 */  
        OpenSearchTableScan scan = makeShardScan(/* shardCount */ 3);  
        );
            return best != null ? best : node;  
import org.apache.calcite.plan.volcano.VolcanoPlanner;
     * inherited HEP test cluster). This avoids the "RelNode belongs to a different planner"
 *
 */  
 * Verifies {@link OpenSearchDistributionTraitDef#convert} materializes the right exchange
    public void testConvertSingletonInsertsExchangeReducer() {  
import java.util.List;
        assertTrue(
     * AssertionError that would fire if {@code convert(...)} tried to register a HEP-cluster  
     */  
    /** Volcano's {@code planner.register(...)} wraps registered nodes in {@link RelSubset};
import org.apache.calcite.rel.RelNode;
    }
        }  
    private static RelNode unwrapSubset(RelNode node) {  
/*  
    private VolcanoPlanner volcano;  
import org.opensearch.analytics.planner.PlannerContext;
        traitDef = context.getDistributionTraitDef();
/**
     * Builds an {@link OpenSearchTableScan} attached to {@code volcanoCluster} (rather than the
    }
    }  
        RelOptTable indexNameTable = new TestIndexNameTable(mockTable, "test_index");
            volcanoCluster,
        super.setUp();
import org.opensearch.analytics.spi.FieldStorageInfo;  
        OpenSearchTableScan scan = makeShardScan(/* shardCount */ 3);
    }
            List.<FieldStorageInfo>of(),
    @Override
        );
