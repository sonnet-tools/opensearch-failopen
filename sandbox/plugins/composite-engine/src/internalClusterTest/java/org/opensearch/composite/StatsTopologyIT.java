        Map<String, Object> sf = parquetIndexStats("filter-idx", "level", "shards", "shards", "2");
        Map<String, Object> nfIndices = (Map<String, Object>) nf.get("indices");
            assertNotNull("routing.node must be set", routing.get("node"));
        createIndexWithShards("default-level-idx", 3, 0, true);
        long postRestartAfter = getCounter(parquetIndexStats(idx), "indices." + idx + ".indexing.docs_indexed_total");
        // iterate closed shards. We verify the open index is present and that the response
        ensureGreen(name);  
        Map<String, Object> indices = (Map<String, Object>) sf.get("indices");
    @SuppressWarnings("unchecked")
     * Response shape: indices.{idx}.shards."{shardId}".[{routing: {primary: bool, ...}, indexing: {...}, ...}]
        Map<String, Object> wildResp = parquetIndexStats("pat-idx-*");  
        assertTrue("node filter must return at most 4 shards", nfShards.size() <= 4);
        internalCluster().startNodes(1);  
        refreshIndex("bad-shard-idx");  
        assertTrue("existing index pat-idx-a must appear in response", mixIndices.containsKey("pat-idx-a"));
    @SuppressWarnings("unchecked")  
        assertEquals("expected 3 shard entries (one per primary)", 3, shards.size());
        indexDocs("multi-node-filter-idx", 40, 0);
        // Wildcard pat-idx-* must match a + b but NOT other-idx.
        assertEquals("lucene must match parquet after restart", postRestartAfter, luceneAfter);
     * zero indices returns 200 with empty results or 404.
    /**
    @SuppressWarnings("unchecked")  
        } catch (ResponseException e) {
    @SuppressWarnings("unchecked")  
        // Start a dedicated cluster manager (keeps REST client alive) + 1 data node.
        Map<String, Object> indices = (Map<String, Object>) response.get("indices");
        assertFalse("must NOT include shard 2", shards3.containsKey("2"));
        // Comma-separated must match both (use a and other).  
        Map<String, Object> rOpen = parquetIndexStats("wildcard-*", "expand_wildcards", "open");  
        Map<String, Object> indicesOk = (Map<String, Object>) rOk.get("indices");  
        String dataNode = internalCluster().startDataOnlyNode();
        createIndexWithShards("routing-idx", 3, 0, true);  
    /**
        assertTrue(indicesOpen.containsKey("wildcard-open-idx"));
        assertTrue("shards block must exist", hasPath(rs, "indices.routing-idx.shards"));
        createIndexWithShards("wildcard-open-idx", 1, 0, true);
        // shards=0,2 — exactly 2 entries.  
    }
/*  
    }
        // Must have at most as many entries as shards on that node (4 shards across 2 nodes).
        createIndexWithShards("cluster-agg-idx", 6, 0, true);  
        } catch (ResponseException e) {  
import org.opensearch.test.OpenSearchIntegTestCase.ClusterScope;
        assertTrue("shards block must exist for level=shards", hasPath(rs, "indices.shard-sum-idx.shards"));
        assertCounter("_shards.successful", r, "_shards.successful", 6L);
            "multi-shard-filter-idx"
        refreshIndex("default-level-idx");  
        assertFalse("default level response must NOT have a shards block", indexBlock.containsKey("shards"));  
            for (Map<String, Object> copy : copies) {  
        indexDocs("cluster-agg-idx", 600, 0);
        Map<String, Object> indexStats = (Map<String, Object>) indices.get(indexName);
        assertTrue(commaIndices.containsKey("other-idx"));
        assertEquals("shards=0,2 must return exactly 2 entries", 2, shards2.size());
 * compatible open source license.
        indexDocs("default-level-idx", 30, 0);
    }  
        Map<String, Object> indicesAll = (Map<String, Object>) rAll.get("indices");
 *
        internalCluster().restartNode(dataNode);  
            int code = e.getResponse().getStatusLine().getStatusCode();
                assertEquals("every entry must be on node A", nodeA, routing.get("node"));
        Map<String, Object> shards = (Map<String, Object>) indexBlock.get("shards");  
                if (val >= 0) sum += val;  
            List<Map<String, Object>> copies = (List<Map<String, Object>>) shardEntry.getValue();  
        refreshIndex("multi-shard-filter-idx");
     * Verifies that the {@code expand_wildcards} param controls wildcard expansion semantics.  
        return sum;  
    }
            .put("index.composite.primary_data_format", "parquet");
        }
        assertCounter("index-level total", r, "indices.shard-sum-idx.indexing.docs_indexed_total", 300L);
        // Close one of the indices.
        internalCluster().startNodes(1);  
    }  
        assertEquals("pre-restart parquet docs", 50L, preRestartDocs);  
     */  
     */  
    public void testStatsAccumulateAfterNodeRestart() throws Exception {
        // Query level=shards  
        Map<String, Object> shards = (Map<String, Object>) indexStats.get("shards");  
        String idx = "restart-idx";
        internalCluster().startNodes(3);
    /**
        indexDocs("other-idx", 30, 0);  
        assertTrue(shards3.containsKey("0"));
        // Pre-restart: counters reflect the 50 docs.
        assertTrue("default expand must include open index", indicesDefault.containsKey("wildcard-open-idx"));
}  
        assertFalse("missing index must not appear in response", mixIndices.containsKey("no-such-idx"));
        indexDocs("filter-idx", 80, 0);  
        assertFalse("wildcard must NOT match other-idx", wildIndices.containsKey("other-idx"));
        }
import org.opensearch.common.settings.Settings;
     * Verifies that index-level doc total equals the sum of per-shard doc totals
    public void testShardAndNodeFilters() throws Exception {  
            s.putList("index.composite.secondary_data_formats");  
        createIndexWithShards(idx, 1, 0, true);  
     */  
        indexDocs("pat-idx-a", 10, 0);
        // shards=2 — only that shard in shard-level response.  
    public void testIndexPatternResolution() throws Exception {
            assertTrue("copy must have indexing block", copy.containsKey("indexing"));  
     */
     */
     * stats endpoint remains functional after restart and new indexing is tracked.
        Map<String, Object> single = parquetNodeStats(firstNodeId);  
    public void testInvalidShardIdReturnsBadRequest() throws Exception {
    @SuppressWarnings("unchecked")
        // Query default level
        refreshIndex("pat-idx-b");
        indexDocs("bad-shard-idx", 30, 0);
    public void testNodeStatsSpecificNodeFilter() throws Exception {  
        assertFalse("must NOT include shard 3", shards2.containsKey("3"));  
     * Verifies that the {@code shards=} param accepts a comma-separated list and filters
        Map<String, Object> mixResp = parquetIndexStats("pat-idx-a,no-such-idx", "ignore_unavailable", "true");
        refreshIndex("wildcard-closed-idx");  
        internalCluster().startNodes(3);
        // node filter — pick a real node id from the cluster, query restricting to that node.
        Map<String, Object> nfIndex = (Map<String, Object>) nfIndices.get("filter-idx");  
        )).get("shards");
 */  
        internalCluster().startNodes(1);
        Map<String, Object> rOk = parquetIndexStats("no-match-*", "allow_no_indices", "true");
        internalCluster().startNodes(1);  
     * In the single-JVM test framework, the JVM-wide {@code DataFormatStatsProviderRegistry}
        )).get("shards");
    @SuppressWarnings("unchecked")
            assertEquals("expected exactly 400 for non-integer shard", 400, code);
     */
    public void testIndexLevelEqualsShardSum() throws Exception {
        refreshIndex("routing-idx");
    }
            // Stats fields must be present in the copy.
        Map<String, Object> r3 = parquetIndexStats("multi-shard-filter-idx", "level", "shards", "shards", "0,1,3");  
 * SPDX-License-Identifier: Apache-2.0
        Map<String, Object> rs = parquetIndexStats("shard-sum-idx", "level", "shards");
        internalCluster().startNodes(2);
        refreshIndex("wildcard-open-idx");
        assertEquals("new docs must be tracked after restart", postRestartBefore + 30L, postRestartAfter);  
        Map<String, Object> nodes = (Map<String, Object>) nr.get("nodes");  
    /**
        Map<String, Object> mixIndices = (Map<String, Object>) mixResp.get("indices");  
        String nodeB = nodeInfos.get(1).getNode().getId();
        // shards=0,1,3 — exactly 3 entries.
        Map<String, Object> shardsBoth = (Map<String, Object>) ((Map<String, Object>) ((Map<String, Object>) rBoth.get("indices")).get(
            assertNotNull("each shard copy must have a routing block", routing);  
        internalCluster().startClusterManagerOnlyNode();  
        Map<String, Object> rDefault = parquetIndexStats("wildcard-*");  
    /**
        refreshIndex("multi-node-filter-idx");
     * special token {@code _local} resolves to the coordinating node.
    @SuppressWarnings("unchecked")
        // the response size is >= the open-only response (no regression).
            // routing sub-object must be present with expected fields.
        long sum = 0L;
            s.putList("index.composite.secondary_data_formats", "lucene");
 * Integration tests for stats API behavior across different cluster topologies.  
    protected void createIndexWithShards(String name, int numShards, int numReplicas, boolean withLuceneSecondary) {
            Map<String, Object> copy = copies.get(0);  
        assertEquals("shards=0,1,3 must return exactly 3 entries", 3, shards3.size());
        // Query for just that node
     * Verifies that stats survive a data node restart and continue accumulating correctly.
        assertTrue("must include shard 2", shards2.containsKey("2"));
     *  
            }
        internalCluster().startNodes(1);  
        Map<String, Object> r = parquetIndexStats("shard-sum-idx");  
        assertTrue("indices block must be empty for no-match wildcard", indicesOk.isEmpty());
    /**
        Map<String, Object> commaIndices = (Map<String, Object>) commaResp.get("indices");
        Map<String, Object> r = parquetIndexStats("cluster-agg-idx");
        refreshIndex("filter-idx");
    /**
    }
        indexDocs(idx, 30, 50);  
                Map<String, Object> routing = (Map<String, Object>) copy.get("routing");
            assertTrue("node entry must have indexing block", hasPath(nodeStats, "indexing.docs_indexed_total"));
        indexDocs("node-filter-idx", 90, 0);  
    // testReplicasExcludedFromAggregation: deferred. DFA replicas in current upstream require
        // Per-node endpoint: assert response structure (3 nodes present, each has indexing block).
     * Verifies that node-stats endpoint with a specific nodeId returns only that node.  
        internalCluster().startNodes(1);  
        try {
        }
     */
import org.opensearch.client.Request;
     * {@code DataFormatStatsProviderRegistry} is JVM-wide. Each node's local registry sees
import org.opensearch.test.OpenSearchIntegTestCase.Scope;  
        long luceneAfter = getCounter(luceneIndexStats(idx), "indices." + idx + ".indexing.docs_indexed_total");  
        assertFalse("explicit level=index must NOT have a shards block", indexBlockIdx.containsKey("shards"));
        Map<String, Object> indices = (Map<String, Object>) r.get("indices");
package org.opensearch.composite;
    // a remote-store-backed cluster (RemoteStoreBaseIntegTestCase). Plain peer recovery to a
        try {  
        // Restart the data node.
    }
        for (Map.Entry<String, Object> shardEntry : shards.entrySet()) {
     * Cluster-aggregate via /{idx}/_stats is the authoritative aggregation path.
        client().admin().indices().prepareClose("wildcard-closed-idx").get();  
        refreshIndex("node-filter-idx");
        assertEquals("node-id-filter response must have exactly 1 node", 1, singleNodes.size());
        assertFalse("comma list must NOT match unspecified pat-idx-b", commaIndices.containsKey("pat-idx-b"));
        // ignore_unavailable=true with one missing must succeed and return only the existing one.
    }  
    /**  
        for (Map.Entry<String, Object> e : nodes.entrySet()) {
        createIndexWithShards("allow-no-anchor-idx", 1, 0, true);
     */  
     */
        // Get both node IDs.
        // nodes=_local must succeed and return shards on the coordinating node.  
        Map<String, Object> indexBlockIdx = (Map<String, Object>) indicesIdx.get("default-level-idx");  
        assertTrue(shards3.containsKey("3"));
        createIndexWithShards("wildcard-closed-idx", 1, 0, true);
 * Each test starts its own cluster nodes since Scope.TEST destroys between tests.
    }
/**
     * shard-level results to exactly those shard IDs.  
        // Index more docs — counters must accumulate from wherever they were.
    // primary-only aggregation we'd need to extend RemoteStoreBaseIntegTestCase and configure
 * this file be licensed under the Apache-2.0 license or a
 *
        )).get("shards");  
import org.opensearch.cluster.metadata.IndexMetadata;  
        refreshIndex(idx);
        assertTrue("response must have indices key after restart", postRestart.containsKey("indices"));
    /**  
            assertEquals("each shard list must have exactly 1 entry (primary only)", 1, copies.size());
        // Get one node's id  
        Map<String, Object> r = parquetIndexStats("default-level-idx");  
        assertTrue(commaIndices.containsKey("pat-idx-a"));  
     * Verifies that the {@code nodes=} param accepts a comma-separated list and that the  
    public void testDefaultLevelExcludesShardsBlock() throws Exception {
        }  
        )).get("shards");
            "multi-node-filter-idx"  
    /**  
        if (withLuceneSecondary) {  
        Map<String, Object> wildIndices = (Map<String, Object>) wildResp.get("indices");
        assertTrue("wildcard must match pat-idx-b", wildIndices.containsKey("pat-idx-b"));  
        String someNodeId = client().admin().cluster().prepareNodesInfo().get().getNodes().get(0).getNode().getId();  
        // includes MORE indices than expand_wildcards=open (or at minimum the same set).
    /**  
     * Test the shard= and node= query parameters for filtering shard-level results.  
        Map<String, Object> rA = parquetIndexStats("multi-node-filter-idx", "level", "shards", "nodes", nodeA);
     * Computes the sum of a counter across all shards in the shard-level response.
        Map<String, Object> singleNodes = (Map<String, Object>) single.get("nodes");
        Map<String, Object> nfShards = (Map<String, Object>) nfIndex.get("shards");
        for (Map.Entry<String, Object> shardEntry : shards.entrySet()) {  
        assertTrue("nodes key present", nr.containsKey("nodes"));
        Map<String, Object> rIndex = parquetIndexStats("default-level-idx", "level", "index");
        createIndexWithShards("pat-idx-b", 1, 0, true);
            int code = e.getResponse().getStatusLine().getStatusCode();  
        // Explicit level=index — also excludes shards.  
     * {@code internalCluster()} runs all "nodes" in a single JVM, where the
        // shards=foo — non-integer must also return 400.
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, numReplicas)
        // shards=99 — out of range for a 3-shard index.
    public void testAllowNoIndices() throws Exception {
        indexDocs("routing-idx", 60, 0);
        indexDocs("wildcard-open-idx", 10, 0);  
            }  
        String firstNodeId = nodes.keySet().iterator().next();  
import org.opensearch.client.ResponseException;
    @SuppressWarnings("unchecked")
    }
        // Create an index to ensure cluster is green, then use a non-matching wildcard.
        var nodeInfos = client().admin().cluster().prepareNodesInfo().get().getNodes();
        createIndexWithShards("pat-idx-a", 1, 0, true);
        indexDocs(idx, 50, 0);
        // Do NOT sum per-node — see javadoc above for why.  
    }  
        // action cannot execute on closed shards so the response may omit it. Assert that
        assertTrue("expand=all must include open", indicesAll.containsKey("wildcard-open-idx"));
    private long computeShardSum(Map<String, Object> response, String indexName, String counterPath) {  
     * includes both open and closed indices in the resolution (though closed indices may have empty stats).
    @SuppressWarnings("unchecked")
        Map<String, Object> indicesOpen = (Map<String, Object>) rOpen.get("indices");
     * each node has its own JVM, so per-node values are correctly partitioned by shard ownership.
        refreshIndex("cluster-agg-idx");
        assertTrue("node filter must return at least 1 shard", nfShards.size() >= 1);  
        Map<String, Object> all = parquetNodeStats("");
        }
        Map<String, Object> commaResp = parquetIndexStats("pat-idx-a,other-idx");
            assertNull("routing.relocating_node must be null for stable shards", routing.get("relocating_node"));
        assertNotNull("response must have indices key", indicesOk);
        // expand_wildcards=all with ignore_unavailable=true — the open index must still appear.
        // nodes=A — only shards on node A. Each shard's routing.node must match nodeA.
            List<Map<String, Object>> copies = (List<Map<String, Object>>) e.getValue();
        assertTrue("expand=all must return at least as many indices as expand=open", indicesAll.size() >= indicesOpen.size());  
        refreshIndex("shard-sum-idx");  
     * <p>Treats both 0 and absent (-1L from {@code getCounter}) as no-contribution; only
            assertEquals("copy must be primary", Boolean.TRUE, routing.get("primary"));
            getRestClient().performRequest(new Request("GET", "/_plugins/parquet/bad-shard-idx/_stats?level=shards&shards=foo"));
        assertFalse("must NOT include shard 1", shards2.containsKey("1"));
        Map<String, Object> shards2 = (Map<String, Object>) ((Map<String, Object>) ((Map<String, Object>) r2.get("indices")).get(
     * when queried with level=shards.
        assertTrue("nodes=A must return at least 1 shard", shardsA.size() >= 1);  
        // Post-restart: stats endpoint must still be functional.  
 */
        // Verify _shards header  
            for (Map<String, Object> copy : copies) {
     * With no level param, response must NOT include shards block.
     * retains trackers across node restarts, so counters persist. This test verifies the  
        Map<String, Object> indexBlock = (Map<String, Object>) indices.get("filter-idx");  
        refreshIndex("pat-idx-a");
        assertCounter("index-level total still present", r, "indices.default-level-idx.indexing.docs_indexed_total", 30L);
        Map<String, Object> shardsA = (Map<String, Object>) ((Map<String, Object>) ((Map<String, Object>) rA.get("indices")).get(  
        assertTrue("must include shard 2", shards.containsKey("2"));  
    // non-remote replica fails with TranslogCorruptedException at recovery time. To test  
 * @opensearch.experimental  
    @SuppressWarnings("unchecked")  
        // expand_wildcards=open — same as default.
        long preRestartDocs = getCounter(parquetIndexStats(idx), "indices." + idx + ".indexing.docs_indexed_total");
        assertTrue("response must contain the requested node", singleNodes.containsKey(firstNodeId));  
        // Lucene secondary must also track the new docs.
     * 3 shards, query level=shards, verify each shard entry has primary field and stats.
        Settings.Builder s = Settings.builder()  
    @SuppressWarnings("unchecked")
        Map<String, Object> rBoth = parquetIndexStats("multi-node-filter-idx", "level", "shards", "nodes", nodeA + "," + nodeB);
            List<Map<String, Object>> copies = (List<Map<String, Object>>) shardEntry.getValue();
            .put("index.pluggable.dataformat.enabled", true)  
        indexDocs("shard-sum-idx", 300, 0);
        assertEquals("nodes=A,B (all nodes) must return all 4 shards", 4, shardsBoth.size());
     */
            Map<String, Object> routing = (Map<String, Object>) copy.get("routing");
import java.util.List;
        Map<String, Object> nf = parquetIndexStats("filter-idx", "level", "shards", "nodes", someNodeId);
        Map<String, Object> rLocal = parquetIndexStats("multi-node-filter-idx", "level", "shards", "nodes", "_local");
        Map<String, Object> indicesDefault = (Map<String, Object>) rDefault.get("indices");
        Map<String, Object> shards3 = (Map<String, Object>) ((Map<String, Object>) ((Map<String, Object>) r3.get("indices")).get(
    /**
        // The closed index may or may not appear depending on whether the broadcast action can  
     * Verifies that an out-of-range shard ID in the {@code shards=} param returns a clear 400.  
        // allow_no_indices=true — must succeed with empty indices block.
        Map<String, Object> nodes = (Map<String, Object>) all.get("nodes");
            Map<String, Object> nodeStats = (Map<String, Object>) e.getValue();  
    }  
            "multi-node-filter-idx"
        indexDocs("wildcard-closed-idx", 20, 0);
@ClusterScope(scope = Scope.TEST, numDataNodes = 0)
        String nodeA = nodeInfos.get(0).getNode().getId();  
                long val = getCounter(copy, counterPath);
        internalCluster().startNodes(2);
            assertEquals("expected exactly 400 for out-of-range shard", 400, code);
            fail("expected 400 for out-of-range shard id");
     * <p>Note: per-node breakdown via /_nodes/_stats is NOT asserted with a sum here because  
        Map<String, Object> shardsLocal = (Map<String, Object>) ((Map<String, Object>) ((Map<String, Object>) rLocal.get("indices")).get(
        } else {
        Map<String, Object> shards = (Map<String, Object>) indexBlock.get("shards");
        assertFalse(indicesOpen.containsKey("wildcard-closed-idx"));  
     */  
        assertEquals("expected 3 node entries", 3, nodes.size());
        assertCounter("_shards.total", r, "_shards.total", 6L);
        Map<String, Object> indexBlock = (Map<String, Object>) indices.get("default-level-idx");
        }
     * than throwing — callers that need strict path validation should use {@code hasPath}.  
        long postRestartBefore = getCounter(parquetIndexStats(idx), "indices." + idx + ".indexing.docs_indexed_total");
            int code = e.getResponse().getStatusLine().getStatusCode();
public class StatsTopologyIT extends BaseStatsIT {  
 * The OpenSearch Contributors require contributions made to  
        assertTrue(shards3.containsKey("1"));  
        }
        for (Map.Entry<String, Object> e : shardsA.entrySet()) {
        createIndexWithShards("bad-shard-idx", 3, 0, true);
        ensureGreen(idx);
    public void testExpandWildcardsHonored() throws Exception {
        internalCluster().startNodes(2);
        createIndexWithShards("multi-node-filter-idx", 4, 0, true);  
        try {  
        Map<String, Object> nr = parquetNodeStats("");
    public void testMultiValueNodeFilter() throws Exception {
        assertTrue("must include shard 0", shards2.containsKey("0"));  
     * Verifies the {@code allow_no_indices} param controls whether a wildcard pattern matching
     * positive values are added. Negative values from missing paths are ignored rather
            .put("index.pluggable.dataformat", "composite")
        internalCluster().startNodes(1);  
     * Multiple indices, test wildcard, comma-separated, and ignore_unavailable resolution.
        assertFalse("default expand must NOT include closed index", indicesDefault.containsKey("wildcard-closed-idx"));  
    // segment replication via remote store. This is moved to Wave 3 / a follow-up PR.
        refreshIndex(idx);
    /**  
            assertNotNull("routing.state must be set", routing.get("state"));  
        assertCounter("cluster-aggregate doc total", r, "indices.cluster-agg-idx.indexing.docs_indexed_total", 600L);
    public void testMultiValueShardFilter() throws Exception {  
     * Verifies that stats aggregate correctly across a 3-node cluster with 6 shards.  
        indexDocs("multi-shard-filter-idx", 80, 0);  
     */
            "multi-shard-filter-idx"  
        // nodes=A,B — should return ALL 4 shards (across both nodes).  
    }
            getRestClient().performRequest(new Request("GET", "/_plugins/parquet/bad-shard-idx/_stats?level=shards&shards=99"));
            fail("expected 4xx for allow_no_indices=false on no-match wildcard");
     * trackers from every node, so summing per-node values triple-counts. In production  
        createIndexWithShards("multi-shard-filter-idx", 4, 0, true);
    @SuppressWarnings("unchecked")
        Map<String, Object> indicesIdx = (Map<String, Object>) rIndex.get("indices");
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, numShards)
    }  
        createIndexWithShards("shard-sum-idx", 3, 0, true);
        Map<String, Object> postRestart = parquetIndexStats(idx);
            assertTrue("expected 4xx, got " + code, code >= 400 && code < 500);
        assertTrue("_local must return at least 1 shard", shardsLocal.size() >= 1);
        createIndexWithShards("filter-idx", 4, 0, true);
        Map<String, Object> rAll = parquetIndexStats("wildcard-*", "expand_wildcards", "all", "ignore_unavailable", "true");  
            "multi-node-filter-idx"  
        Map<String, Object> indexBlock = (Map<String, Object>) indices.get("routing-idx");
    @SuppressWarnings("unchecked")
            fail("expected 400 for non-integer shard id");
     */
        assertEquals("shard filter must restrict to 1 entry", 1, shards.size());
        indexDocs("pat-idx-b", 20, 0);
import java.util.Map;  
            getRestClient().performRequest(new Request("GET", "/_plugins/parquet/no-match-*/_stats?allow_no_indices=false"));  
        refreshIndex("other-idx");  
        }  
    public void testShardLevelRoutingMetadata() throws Exception {
    public void testMultiNodeClusterAggregation() throws Exception {
        Map<String, Object> rs = parquetIndexStats("routing-idx", "level", "shards");
        createIndexWithShards("node-filter-idx", 3, 0, true);
     */
        createIndexWithShards("other-idx", 1, 0, true);  
     *
        )).get("shards");
        long sum = computeShardSum(rs, "shard-sum-idx", "indexing.docs_indexed_total");
        } catch (ResponseException e) {  
        // expand_wildcards=all resolves the closed index in the pattern, but the broadcast  
        assertEquals("shard sum must equal index total", 300L, sum);
        assertCounter("_shards.failed", r, "_shards.failed", 0L);  
        // Default — no level param.
    /**
        Map<String, Object> indices = (Map<String, Object>) rs.get("indices");
     * Default {@code open} excludes closed indices; {@code all} with {@code ignore_unavailable=true}
        assertTrue("wildcard must match pat-idx-a", wildIndices.containsKey("pat-idx-a"));
        client().admin().indices().prepareCreate(name).setSettings(s).setMapping("name", "type=keyword", "value", "type=integer").get();
        Map<String, Object> r2 = parquetIndexStats("multi-shard-filter-idx", "level", "shards", "shards", "0,2");
        // allow_no_indices=false — must fail with 4xx.
        // Default (no expand_wildcards) — wildcard matches only the open index.
