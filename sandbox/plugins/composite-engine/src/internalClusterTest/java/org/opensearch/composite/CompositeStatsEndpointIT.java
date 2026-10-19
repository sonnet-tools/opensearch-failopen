    /** After indexing + refresh, composite refresh counters increment and failures stay zero. */
        Map<String, Object> p = parquetIndexStats(idx);
        // A successful per-node response carries a "nodes" object (one entry per responding node).
        );
        assertTrue(
        long refreshMerge = StatsITHelpers.getCounter(c, "indices." + idx + ".refresh.refresh_merge_total");  
        assertCounter("fresh write_secondary_failures", c, "indices." + idx + ".write.write_secondary_failures", 0L);
        assertTrue("at least one node must expose native_ingest_pool", sawPool);
        Map<?, ?> nodes = (Map<?, ?>) n.get("nodes");
    /** The parquet per-node endpoint exposes the live native_ingest_pool block (queue/active/rejected). */
        assertCounter("native_write_rejections zero", p, "indices." + idx + ".native_write.native_write_rejections", 0L);
    public void testCompositeStatsZeroOnFreshIndex() throws Exception {
/*  
        refreshIndex(idx);
        refreshIndex(idx);
 * ({@code /_plugins/composite/...}) and the parquet {@code native_write_rejections} counter.
        createCompositeIndex(idx, true);  
 * compatible open source license.
        Map<String, Object> c = compositeIndexStats(idx);
        String idx = "parquet-rejection-idx";
    /** The composite per-node endpoint aggregates and responds after indexing. */
        createCompositeIndex(idx, true);
    }
 *  
            if (pool instanceof Map) {
        assertTrue("per-node response must contain a 'nodes' object", n.get("nodes") instanceof Map);
    }  
        assertCounterAtLeast("write_total", c, "indices." + idx + ".write.write_total", 100L);
        long mergeTotal = StatsITHelpers.getCounter(c, "indices." + idx + ".merge.merge_total");
        assertCounter("fresh write_total", c, "indices." + idx + ".write.write_total", 0L);
    public void testCompositeNodeStatsEndpoint() throws Exception {  
        refreshIndex(idx);
        createCompositeIndex(idx, true);  
            refreshMerge <= mergeTotal
        indexDocs(idx, 50, 0);  
 * @opensearch.experimental
import java.util.Map;
 * The OpenSearch Contributors require contributions made to  
    public void testParquetNodeStatsExposesIngestPool() throws Exception {  
        assertFalse("per-node response 'nodes' object must not be empty", ((Map<?, ?>) n.get("nodes")).isEmpty());  
        assertCounter("merge_failures", c, "indices." + idx + ".merge.merge_failures", 0L);
        }
        // Happy path: no write or merge failures.
        assertCounter("write_primary_failures", c, "indices." + idx + ".write.write_primary_failures", 0L);  
                sawPool = true;
 */
                assertTrue("native_ingest_pool must report queue_depth", ((Map<?, ?>) pool).containsKey("queue_depth"));  
@ClusterScope(scope = Scope.SUITE, numDataNodes = 1)  
        assertCounter("refresh_merge_failures", c, "indices." + idx + ".refresh.refresh_merge_failures", 0L);  
        assertNotNull("per-node response must contain 'nodes'", nodes);  
/**  
        String idx = "composite-refresh-idx";
        Map<String, Object> n = compositeNodeStats("");  
 * Integration tests for the composite-engine per-format stats endpoint
        assertCounter("fresh write_primary_failures", c, "indices." + idx + ".write.write_primary_failures", 0L);  
import org.opensearch.test.OpenSearchIntegTestCase.Scope;
public class CompositeStatsEndpointIT extends BaseStatsIT {
}
        assertCounter("write_secondary_failures", c, "indices." + idx + ".write.write_secondary_failures", 0L);
        indexDocs(idx, 100, 0);
        // Each responding node must carry a native_ingest_pool block with the pool fields.
        for (Object node : nodes.values()) {  
        refreshIndex(idx);
        assertCounter("fresh merge_failures", c, "indices." + idx + ".merge.merge_failures", 0L);
        // refresh_merge_total is the merge-on-refresh subset of merge_total — it must never exceed it.
        assertCounter("fresh refresh_total", c, "indices." + idx + ".refresh.refresh_total", 0L);  
        createCompositeIndex(idx, true);
package org.opensearch.composite;
    /** Parquet native_write_rejections is wired and reads zero on the happy path. */  
        assertCounter("fresh mapping_update_executed_total", c, "indices." + idx + ".mapping.mapping_update_executed_total", 0L);
 */  
            }  
 *
import org.opensearch.test.OpenSearchIntegTestCase.ClusterScope;
        String idx = "composite-zero-idx";
    /** Fresh composite index: endpoint responds and all counters are zero. */  
            Object pool = ((Map<?, ?>) node).get("native_ingest_pool");
    public void testCompositeRefreshAndMergeCountersIncrement() throws Exception {  
    }  
    }  
        indexDocs(idx, 50, 0);  
    }  
        assertCounter("fresh refresh_merge_failures", c, "indices." + idx + ".refresh.refresh_merge_failures", 0L);
                assertTrue("native_ingest_pool must report rejected", ((Map<?, ?>) pool).containsKey("rejected"));
            "refresh_merge_total (" + refreshMerge + ") must not exceed merge_total (" + mergeTotal + ")",  
        boolean sawPool = false;
    public void testParquetNativeWriteRejectionsZeroOnHappyPath() throws Exception {
        assertCounterAtLeast("refresh_time_millis", c, "indices." + idx + ".refresh.refresh_time_millis", 0L);
        String idx = "composite-node-idx";
        // write_total counts every indexed doc attempt; 100 docs were indexed.  
        indexDocs(idx, 100, 0);  
        assertCounter("fresh refresh_merge_total", c, "indices." + idx + ".refresh.refresh_merge_total", 0L);
 * this file be licensed under the Apache-2.0 license or a
        Map<String, Object> c = compositeIndexStats(idx);  
        assertFalse("'nodes' must not be empty", nodes.isEmpty());
        assertCounterAtLeast("refresh_total", c, "indices." + idx + ".refresh.refresh_total", 1L);
        Map<String, Object> n = parquetNodeStats("");  
 * SPDX-License-Identifier: Apache-2.0
        createCompositeIndex(idx, true);
        assertCounter("fresh merge_total", c, "indices." + idx + ".merge.merge_total", 0L);  
        String idx = "parquet-ingest-pool-idx";
