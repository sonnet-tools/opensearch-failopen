 */  
    @Override
        OpenSearchDistribution any = traitDef.any();
        assertFalse(h.satisfies(b));
        // The converter would need a gather to satisfy SINGLETON from BROADCAST.  
 * this file be licensed under the Apache-2.0 license or a
    // ── HASH ──────────────────────────────────────────────────────────────  
        super.setUp();  
    }  
 *
    }
        OpenSearchDistribution shardSingleton = traitDef.shardSingleton(/* tableId */ 1, /* shardCount */ 1);  
    }
 * satisfies the demand (no exchange needed) or doesn't (Volcano inserts the corresponding
    public void testShardSingletonDoesNotSatisfyCoordSingleton() {
        // Broadcast replicates to many nodes; SINGLETON expects all rows on one node.
    }
        // SHARD-localized data does NOT satisfy a COORDINATOR-localized demand even though
        // would insert a re-shuffle if the planner chose two different N values upstream.
        // satisfies the other regardless of keys. Cost-model implication: the converter
    }
        // both are SINGLETON — the locality must match. This is what forces an ER above a  
        assertFalse(b.satisfies(traitDef.coordSingleton()));
        assertTrue(h.satisfies(h));
 * changes don't silently break the cost model's discrimination ability.
    public void testBroadcastDoesNotSatisfyHash() {  
        OpenSearchDistribution h4 = traitDef.hash(List.of(0), 4);  
        OpenSearchDistribution h = traitDef.hash(List.of(0), 4);  
 * Each test case asserts a specific (produced, demanded) pair: the produced trait either
        // rows by k2.
        assertTrue(traitDef.hash(List.of(0), 4).satisfies(any));
    public void testHashSatisfiesItself() {
        assertTrue(finer.satisfies(coarser));  
 * <p>The satisfies semantics are load-bearing for cost-driven plan selection — they decide
        // — neither satisfies the other regardless of keys. (A hash join needs partitioned
    public void setUp() throws Exception {
        OpenSearchDistribution coarser = traitDef.hash(List.of(0), 4);  
    }  
        OpenSearchDistribution b = traitDef.broadcast(/* probeNodes */ 3);
 *
        // Broadcast replicates everywhere; hash partitions by key. They're not interchangeable
import org.opensearch.test.OpenSearchTestCase;
        PlannerContext context = mock(PlannerContext.class);  
        assertTrue(traitDef.coordSingleton().satisfies(traitDef.coordSingleton()));
        assertTrue(traitDef.broadcast(3).satisfies(any));
    public void testCoarserHashDoesNotSatisfyFinerHash() {  
package org.opensearch.analytics.planner.rel;
    public void testAnyTraitIsSatisfiedByEverything() {
 * which alternatives Volcano explores. The matrix here pins the contract so future trait  
        // inputs; a broadcast input is not partitioned, it's full-data.)  
 * OpenSearch exchange via {@link OpenSearchDistributionTraitDef#convert}).  
        assertTrue(shardSingleton.satisfies(traitDef.anySingleton()));
    // ── BROADCAST ─────────────────────────────────────────────────────────
        assertFalse(h8.satisfies(h4));  
    // ── ANY ───────────────────────────────────────────────────────────────
        OpenSearchDistribution finer = traitDef.hash(List.of(0, 1), 4);
        // PlannerContext is mocked — satisfies() doesn't consult it; we only need the trait def
        // HASH(k, 4) and HASH(k, 8) place rows in entirely different buckets — neither  
    // ── SINGLETON ────────────────────────────────────────────────────────
import static org.mockito.Mockito.mock;  
    public void testShardSingletonSatisfiesNullLocalitySingleton() {
    }
        OpenSearchDistribution h = traitDef.hash(List.of(0), 4);
        // shard scan when a downstream operator demands COORD.
        // when a SINGLETON consumer reads HASH-partitioned input.  
    }
        OpenSearchDistribution b = traitDef.broadcast(/* probeNodes */ 3);
    }  
        // HASH(k1) does NOT satisfy HASH(k1, k2) — partitioning by k1 alone doesn't colocate
        OpenSearchDistribution finer = traitDef.hash(List.of(0, 1), 4);
        assertFalse(h.satisfies(traitDef.coordSingleton()));
    public void testBroadcastDoesNotSatisfySingleton() {
 */
    public void testFinerHashSatisfiesCoarserHash() {
        // Used at root demand: anySingleton() accepts a 1-shard SHARD source without an ER.
    public void testCoordSingletonSatisfiesItself() {  
        // to be a valid object so the OpenSearchDistribution instances can reference it.
        OpenSearchDistribution shardSingleton = traitDef.shardSingleton(/* tableId */ 1, /* shardCount */ 1);
        // by hash(k1). Demanded keys must be a prefix of produced keys.  
public class OpenSearchDistributionSatisfiesTests extends OpenSearchTestCase {  
        assertFalse(b.satisfies(h));  
    public void testHashWithDifferentPartitionCountsDoNotSatisfy() {
}
/*  
/**
        OpenSearchDistribution b = traitDef.broadcast(/* probeNodes */ 3);
import org.opensearch.analytics.planner.PlannerContext;
    }  
        OpenSearchDistribution h = traitDef.hash(List.of(0), 4);
        traitDef = new OpenSearchDistributionTraitDef(context);
    }
    private OpenSearchDistributionTraitDef traitDef;
        assertFalse(shardSingleton.satisfies(traitDef.coordSingleton()));  
        assertFalse(h4.satisfies(h8));
        assertFalse(coarser.satisfies(finer));
        // HASH(k1, k2) satisfies HASH(k1) — rows colocated by hash(k1, k2) are also colocated
 * compatible open source license.
 * Verifies the trait satisfies matrix that drives Volcano's exchange-insertion logic.  
    public void testBroadcastSatisfiesItself() {
        OpenSearchDistribution h8 = traitDef.hash(List.of(0), 8);
 * SPDX-License-Identifier: Apache-2.0
    public void testHashDoesNotSatisfySingleton() {  
        OpenSearchDistribution coarser = traitDef.hash(List.of(0), 4);
        // workers. The converter must insert a gather (ExchangeReducer) above the shuffle
    }
        // Hash-partitioned data does NOT satisfy a SINGLETON demand — it's spread across
        assertTrue(traitDef.coordSingleton().satisfies(any));  
import java.util.List;
 * The OpenSearch Contributors require contributions made to  
    }
        assertTrue(b.satisfies(b));  
