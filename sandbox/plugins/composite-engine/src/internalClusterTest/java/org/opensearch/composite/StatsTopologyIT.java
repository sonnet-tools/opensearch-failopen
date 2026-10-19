        assertCounter("_shards.successful", r, "_shards.successful", 6L);
     * includes both open and closed indices in the resolution (though closed indices may have empty stats).
        Map<String, Object> rA = parquetIndexStats("multi-node-filter-idx", "level", "shards", "nodes", nodeA);
            assertEquals("copy must be primary", Boolean.TRUE, routing.get("primary"));
        Map<String, Object> rs = parquetIndexStats("routing-idx", "level", "shards");
        internalCluster().startNodes(1);
    public void testDefaultLevelExcludesShardsBlock() throws Exception {
            Map<String, Object> nodeStats = (Map<String, Object>) e.getValue();
     */
        internalCluster().startNodes(1);
        createIndexWithShards("pat-idx-b", 1, 0, true);
        Map<String, Object> indices = (Map<String, Object>) sf.get("indices");
        }
        assertCounter("_shards.failed", r, "_shards.failed", 0L);
        assertTrue(shards3.containsKey("3"));
        indexDocs("other-idx", 30, 0);
        refreshIndex("wildcard-closed-idx");
        createIndexWithShards("cluster-agg-idx", 6, 0, true);
@ClusterScope(scope = Scope.TEST, numDataNodes = 0)
     */
        Map<String, Object> rBoth = parquetIndexStats("multi-node-filter-idx", "level", "shards", "nodes", nodeA + "," + nodeB);
            .put("index.composite.primary_data_format", "parquet");
        createIndexWithShards("wildcard-open-idx", 1, 0, true);
        // nodes=A,B — should return ALL 4 shards (across both nodes).
        assertEquals("pre-restart parquet docs", 50L, preRestartDocs);
        Map<String, Object> indexBlockIdx = (Map<String, Object>) indicesIdx.get("default-level-idx");
        // expand_wildcards=all with ignore_unavailable=true — the open index must still appear.
     *
     * In the single-JVM test framework, the JVM-wide {@code DataFormatStatsProviderRegistry}
            assertNotNull("each shard copy must have a routing block", routing);
    // testReplicasExcludedFromAggregation: deferred. DFA replicas in current upstream require
        // action cannot execute on closed shards so the response may omit it. Assert that
        createIndexWithShards("node-filter-idx", 3, 0, true);
     * 3 shards, query level=shards, verify each shard entry has primary field and stats.
import org.opensearch.test.OpenSearchIntegTestCase.ClusterScope;
        Map<String, Object> shards = (Map<String, Object>) indexBlock.get("shards");
        assertEquals("node-id-filter response must have exactly 1 node", 1, singleNodes.size());
        }
        // Close one of the indices.
        indexDocs("multi-shard-filter-idx", 80, 0);
     * Verifies that stats survive a data node restart and continue accumulating correctly.
     * Verifies that node-stats endpoint with a specific nodeId returns only that node.
        Map<String, Object> wildIndices = (Map<String, Object>) wildResp.get("indices");
     * trackers from every node, so summing per-node values triple-counts. In production
        indexDocs("wildcard-closed-idx", 20, 0);
    public void testAllowNoIndices() throws Exception {
 */
    }
            assertNotNull("routing.state must be set", routing.get("state"));
    @SuppressWarnings("unchecked")
        // iterate closed shards. We verify the open index is present and that the response
        createIndexWithShards("multi-shard-filter-idx", 4, 0, true);
        // Must have at most as many entries as shards on that node (4 shards across 2 nodes).
        indexDocs(idx, 30, 50);
        internalCluster().startNodes(3);
            for (Map<String, Object> copy : copies) {
/**
        assertTrue("default expand must include open index", indicesDefault.containsKey("wildcard-open-idx"));
        Map<String, Object> nfIndices = (Map<String, Object>) nf.get("indices");
        assertTrue("indices block must be empty for no-match wildcard", indicesOk.isEmpty());
        assertFalse("comma list must NOT match unspecified pat-idx-b", commaIndices.containsKey("pat-idx-b"));
     * Multiple indices, test wildcard, comma-separated, and ignore_unavailable resolution.
 */
        Map<String, Object> nf = parquetIndexStats("filter-idx", "level", "shards", "nodes", someNodeId);
    public void testShardLevelRoutingMetadata() throws Exception {
    }
        refreshIndex("wildcard-open-idx");
        refreshIndex("default-level-idx");
        // Query for just that node
     */
 *
     */
        createIndexWithShards("bad-shard-idx", 3, 0, true);
        Map<String, Object> rLocal = parquetIndexStats("multi-node-filter-idx", "level", "shards", "nodes", "_local");
    public void testInvalidShardIdReturnsBadRequest() throws Exception {
    }
 * compatible open source license.
            Map<String, Object> routing = (Map<String, Object>) copy.get("routing");
    @SuppressWarnings("unchecked")
        try {
        refreshIndex("pat-idx-b");
        Map<String, Object> shardsA = (Map<String, Object>) ((Map<String, Object>) ((Map<String, Object>) rA.get("indices")).get(
    }
        }
     * Verifies that the {@code nodes=} param accepts a comma-separated list and that the
        } catch (ResponseException e) {
        assertEquals("shards=0,2 must return exactly 2 entries", 2, shards2.size());
    @SuppressWarnings("unchecked")
        Map<String, Object> nfShards = (Map<String, Object>) nfIndex.get("shards");
    protected void createIndexWithShards(String name, int numShards, int numReplicas, boolean withLuceneSecondary) {
        indexDocs("pat-idx-b", 20, 0);
        refreshIndex("bad-shard-idx");
    /**
        assertTrue("shards block must exist for level=shards", hasPath(rs, "indices.shard-sum-idx.shards"));
        // expand_wildcards=open — same as default.
        for (Map.Entry<String, Object> e : nodes.entrySet()) {
        assertFalse("wildcard must NOT match other-idx", wildIndices.containsKey("other-idx"));
import org.opensearch.client.Request;
    // primary-only aggregation we'd need to extend RemoteStoreBaseIntegTestCase and configure
        assertTrue(commaIndices.containsKey("pat-idx-a"));
        }
        } catch (ResponseException e) {
        assertTrue(shards3.containsKey("1"));
    @SuppressWarnings("unchecked")
        // Index more docs — counters must accumulate from wherever they were.
    /**
            // Stats fields must be present in the copy.
            getRestClient().performRequest(new Request("GET", "/_plugins/parquet/bad-shard-idx/_stats?level=shards&shards=99"));
     * stats endpoint remains functional after restart and new indexing is tracked.
            getRestClient().performRequest(new Request("GET", "/_plugins/parquet/no-match-*/_stats?allow_no_indices=false"));
        assertTrue(commaIndices.containsKey("other-idx"));
        client().admin().indices().prepareClose("wildcard-closed-idx").get();
    }
        assertFalse("explicit level=index must NOT have a shards block", indexBlockIdx.containsKey("shards"));
    public void testStatsAccumulateAfterNodeRestart() throws Exception {
        client().admin().indices().prepareCreate(name).setSettings(s).setMapping("name", "type=keyword", "value", "type=integer").get();
     * Verifies that the {@code shards=} param accepts a comma-separated list and filters
    public void testNodeStatsSpecificNodeFilter() throws Exception {
        long luceneAfter = getCounter(luceneIndexStats(idx), "indices." + idx + ".indexing.docs_indexed_total");
     * special token {@code _local} resolves to the coordinating node.
        assertCounter("_shards.total", r, "_shards.total", 6L);
     * {@code DataFormatStatsProviderRegistry} is JVM-wide. Each node's local registry sees
        createIndexWithShards("default-level-idx", 3, 0, true);
        ensureGreen(idx);
        refreshIndex("shard-sum-idx");
        String firstNodeId = nodes.keySet().iterator().next();
        Map<String, Object> singleNodes = (Map<String, Object>) single.get("nodes");
     * when queried with level=shards.
        // Do NOT sum per-node — see javadoc above for why.
        assertTrue(indicesOpen.containsKey("wildcard-open-idx"));
    /**
    /**
    @SuppressWarnings("unchecked")
     * Verifies that an out-of-range shard ID in the {@code shards=} param returns a clear 400.
    public void testIndexLevelEqualsShardSum() throws Exception {
        )).get("shards");
            "multi-shard-filter-idx"
        // Explicit level=index — also excludes shards.
        assertTrue("response must contain the requested node", singleNodes.containsKey(firstNodeId));
        // the response size is >= the open-only response (no regression).
     * Response shape: indices.{idx}.shards."{shardId}".[{routing: {primary: bool, ...}, indexing: {...}, ...}]
     * positive values are added. Negative values from missing paths are ignored rather
        assertTrue("expand=all must include open", indicesAll.containsKey("wildcard-open-idx"));
            int code = e.getResponse().getStatusLine().getStatusCode();
        assertEquals("shard filter must restrict to 1 entry", 1, shards.size());
        internalCluster().startNodes(1);
        Map<String, Object> shards2 = (Map<String, Object>) ((Map<String, Object>) ((Map<String, Object>) r2.get("indices")).get(
        Map<String, Object> postRestart = parquetIndexStats(idx);
    /**
        if (withLuceneSecondary) {
        createIndexWithShards("filter-idx", 4, 0, true);
        // shards=0,1,3 — exactly 3 entries.
        assertTrue("response must have indices key after restart", postRestart.containsKey("indices"));
        Map<String, Object> rAll = parquetIndexStats("wildcard-*", "expand_wildcards", "all", "ignore_unavailable", "true");
        Map<String, Object> indexBlock = (Map<String, Object>) indices.get("default-level-idx");
        // Default (no expand_wildcards) — wildcard matches only the open index.
            List<Map<String, Object>> copies = (List<Map<String, Object>>) e.getValue();
     */
     */
            .put("index.pluggable.dataformat.enabled", true)
        }
                Map<String, Object> routing = (Map<String, Object>) copy.get("routing");
     * Verifies that stats aggregate correctly across a 3-node cluster with 6 shards.
        // Create an index to ensure cluster is green, then use a non-matching wildcard.
    }
     * Cluster-aggregate via /{idx}/_stats is the authoritative aggregation path.
        assertFalse(indicesOpen.containsKey("wildcard-closed-idx"));
    // segment replication via remote store. This is moved to Wave 3 / a follow-up PR.
        indexDocs("filter-idx", 80, 0);
     * Verifies that index-level doc total equals the sum of per-shard doc totals
        internalCluster().startNodes(2);
            // routing sub-object must be present with expected fields.
            List<Map<String, Object>> copies = (List<Map<String, Object>>) shardEntry.getValue();
            }
        ensureGreen(name);
        Map<String, Object> nfIndex = (Map<String, Object>) nfIndices.get("filter-idx");
     * Verifies the {@code allow_no_indices} param controls whether a wildcard pattern matching
    /**
     */
        Map<String, Object> rOk = parquetIndexStats("no-match-*", "allow_no_indices", "true");
        Map<String, Object> nodes = (Map<String, Object>) nr.get("nodes");
        String nodeA = nodeInfos.get(0).getNode().getId();
        Map<String, Object> sf = parquetIndexStats("filter-idx", "level", "shards", "shards", "2");
     */
    // non-remote replica fails with TranslogCorruptedException at recovery time. To test
        long preRestartDocs = getCounter(parquetIndexStats(idx), "indices." + idx + ".indexing.docs_indexed_total");
    @SuppressWarnings("unchecked")
        // allow_no_indices=true — must succeed with empty indices block.
     */
        assertTrue("node filter must return at least 1 shard", nfShards.size() >= 1);
    }
        Map<String, Object> r2 = parquetIndexStats("multi-shard-filter-idx", "level", "shards", "shards", "0,2");
        Map<String, Object> indicesOpen = (Map<String, Object>) rOpen.get("indices");
        assertFalse("must NOT include shard 1", shards2.containsKey("1"));
        long postRestartBefore = getCounter(parquetIndexStats(idx), "indices." + idx + ".indexing.docs_indexed_total");
        )).get("shards");
            fail("expected 400 for non-integer shard id");
        // Pre-restart: counters reflect the 50 docs.
        Map<String, Object> indices = (Map<String, Object>) r.get("indices");
    }
    public void testIndexPatternResolution() throws Exception {
     * Test the shard= and node= query parameters for filtering shard-level results.
        assertCounter("index-level total", r, "indices.shard-sum-idx.indexing.docs_indexed_total", 300L);
        Map<String, Object> rOpen = parquetIndexStats("wildcard-*", "expand_wildcards", "open");
            s.putList("index.composite.secondary_data_formats", "lucene");
        internalCluster().startNodes(1);
        for (Map.Entry<String, Object> shardEntry : shards.entrySet()) {
    public void testShardAndNodeFilters() throws Exception {
            }
    @SuppressWarnings("unchecked")
        Map<String, Object> all = parquetNodeStats("");
        createIndexWithShards("shard-sum-idx", 3, 0, true);
    private long computeShardSum(Map<String, Object> response, String indexName, String counterPath) {
        Map<String, Object> indices = (Map<String, Object>) rs.get("indices");
        assertTrue("_local must return at least 1 shard", shardsLocal.size() >= 1);
        Map<String, Object> r = parquetIndexStats("default-level-idx");
        String dataNode = internalCluster().startDataOnlyNode();
    /**
            List<Map<String, Object>> copies = (List<Map<String, Object>>) shardEntry.getValue();
    /**
                if (val >= 0) sum += val;
     */
    /**
        assertEquals("expected 3 node entries", 3, nodes.size());
        Settings.Builder s = Settings.builder()
        assertTrue(shards3.containsKey("0"));
        Map<String, Object> rIndex = parquetIndexStats("default-level-idx", "level", "index");
        Map<String, Object> rDefault = parquetIndexStats("wildcard-*");
        // nodes=_local must succeed and return shards on the coordinating node.
        internalCluster().startClusterManagerOnlyNode();
        var nodeInfos = client().admin().cluster().prepareNodesInfo().get().getNodes();
        assertTrue("must include shard 2", shards.containsKey("2"));
import org.opensearch.common.settings.Settings;
        }
import org.opensearch.test.OpenSearchIntegTestCase.Scope;
            assertTrue("expected 4xx, got " + code, code >= 400 && code < 500);
     * With no level param, response must NOT include shards block.
        createIndexWithShards("other-idx", 1, 0, true);
        createIndexWithShards("multi-node-filter-idx", 4, 0, true);
    public void testMultiNodeClusterAggregation() throws Exception {
            assertNull("routing.relocating_node must be null for stable shards", routing.get("relocating_node"));
        refreshIndex(idx);
        refreshIndex("cluster-agg-idx");
        )).get("shards");
            assertEquals("expected exactly 400 for non-integer shard", 400, code);
        Map<String, Object> indices = (Map<String, Object>) response.get("indices");
        assertEquals("new docs must be tracked after restart", postRestartBefore + 30L, postRestartAfter);
        // Comma-separated must match both (use a and other).
        Map<String, Object> r = parquetIndexStats("cluster-agg-idx");
        // nodes=A — only shards on node A. Each shard's routing.node must match nodeA.
        long sum = computeShardSum(rs, "shard-sum-idx", "indexing.docs_indexed_total");
        String nodeB = nodeInfos.get(1).getNode().getId();
 *
        refreshIndex("multi-shard-filter-idx");
        for (Map.Entry<String, Object> shardEntry : shards.entrySet()) {
        Map<String, Object> indexBlock = (Map<String, Object>) indices.get("filter-idx");
        assertFalse("default expand must NOT include closed index", indicesDefault.containsKey("wildcard-closed-idx"));
        Map<String, Object> nr = parquetNodeStats("");
        internalCluster().startNodes(3);
        createIndexWithShards(idx, 1, 0, true);
        assertTrue("expand=all must return at least as many indices as expand=open", indicesAll.size() >= indicesOpen.size());
 * The OpenSearch Contributors require contributions made to
        createIndexWithShards("wildcard-closed-idx", 1, 0, true);
            s.putList("index.composite.secondary_data_formats");
        }
            .put("index.pluggable.dataformat", "composite")
    @SuppressWarnings("unchecked")
        assertEquals("lucene must match parquet after restart", postRestartAfter, luceneAfter);
        Map<String, Object> rs = parquetIndexStats("shard-sum-idx", "level", "shards");
        )).get("shards");
        assertCounter("index-level total still present", r, "indices.default-level-idx.indexing.docs_indexed_total", 30L);
        assertTrue("must include shard 0", shards2.containsKey("0"));
    }
            assertTrue("node entry must have indexing block", hasPath(nodeStats, "indexing.docs_indexed_total"));
        // Verify _shards header
import java.util.Map;
        assertEquals("nodes=A,B (all nodes) must return all 4 shards", 4, shardsBoth.size());
        }
        for (Map.Entry<String, Object> e : shardsA.entrySet()) {
        Map<String, Object> shards3 = (Map<String, Object>) ((Map<String, Object>) ((Map<String, Object>) r3.get("indices")).get(
        indexDocs("routing-idx", 60, 0);
    public void testMultiValueShardFilter() throws Exception {
        Map<String, Object> indicesIdx = (Map<String, Object>) rIndex.get("indices");
        indexDocs("wildcard-open-idx", 10, 0);
        assertFalse("must NOT include shard 3", shards2.containsKey("3"));
        assertFalse("must NOT include shard 2", shards3.containsKey("2"));
        indexDocs("node-filter-idx", 90, 0);
}
        refreshIndex("pat-idx-a");
import java.util.List;
            assertEquals("expected exactly 400 for out-of-range shard", 400, code);
            fail("expected 400 for out-of-range shard id");
    }
        // Default — no level param.
            for (Map<String, Object> copy : copies) {
        indexDocs("pat-idx-a", 10, 0);
     */
        refreshIndex("node-filter-idx");
     * Default {@code open} excludes closed indices; {@code all} with {@code ignore_unavailable=true}
        Map<String, Object> nodes = (Map<String, Object>) all.get("nodes");
        internalCluster().startNodes(1);
        assertFalse("default level response must NOT have a shards block", indexBlock.containsKey("shards"));
     */
        refreshIndex("filter-idx");
        internalCluster().startNodes(1);
            "multi-node-filter-idx"
    }
     * <p>Note: per-node breakdown via /_nodes/_stats is NOT asserted with a sum here because
        // includes MORE indices than expand_wildcards=open (or at minimum the same set).
        refreshIndex("multi-node-filter-idx");
        // The closed index may or may not appear depending on whether the broadcast action can
        Map<String, Object> commaIndices = (Map<String, Object>) commaResp.get("indices");
     * retains trackers across node restarts, so counters persist. This test verifies the
        // shards=foo — non-integer must also return 400.
        Map<String, Object> r3 = parquetIndexStats("multi-shard-filter-idx", "level", "shards", "shards", "0,1,3");
        indexDocs("cluster-agg-idx", 600, 0);
        Map<String, Object> wildResp = parquetIndexStats("pat-idx-*");
        Map<String, Object> shardsBoth = (Map<String, Object>) ((Map<String, Object>) ((Map<String, Object>) rBoth.get("indices")).get(
        // Get one node's id
        long sum = 0L;
        // Start a dedicated cluster manager (keeps REST client alive) + 1 data node.
        String idx = "restart-idx";
        refreshIndex(idx);
    @SuppressWarnings("unchecked")
        internalCluster().restartNode(dataNode);
    /**
/*
import org.opensearch.client.ResponseException;
        refreshIndex("routing-idx");
     */
        // Query default level
        Map<String, Object> commaResp = parquetIndexStats("pat-idx-a,other-idx");
        assertCounter("cluster-aggregate doc total", r, "indices.cluster-agg-idx.indexing.docs_indexed_total", 600L);
        assertTrue("node filter must return at most 4 shards", nfShards.size() <= 4);
            int code = e.getResponse().getStatusLine().getStatusCode();
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, numShards)
        Map<String, Object> indicesAll = (Map<String, Object>) rAll.get("indices");
     * {@code internalCluster()} runs all "nodes" in a single JVM, where the
public class StatsTopologyIT extends BaseStatsIT {
        // expand_wildcards=all resolves the closed index in the pattern, but the broadcast
     * <p>Treats both 0 and absent (-1L from {@code getCounter}) as no-contribution; only
     */
            "multi-node-filter-idx"
    public void testExpandWildcardsHonored() throws Exception {
    /**
        Map<String, Object> shards = (Map<String, Object>) indexStats.get("shards");
        Map<String, Object> indexStats = (Map<String, Object>) indices.get(indexName);
        assertEquals("expected 3 shard entries (one per primary)", 3, shards.size());
        // Per-node endpoint: assert response structure (3 nodes present, each has indexing block).
        indexDocs(idx, 50, 0);
        // Wildcard pat-idx-* must match a + b but NOT other-idx.
        long postRestartAfter = getCounter(parquetIndexStats(idx), "indices." + idx + ".indexing.docs_indexed_total");
        Map<String, Object> shards = (Map<String, Object>) indexBlock.get("shards");
     * shard-level results to exactly those shard IDs.
        assertTrue("shards block must exist", hasPath(rs, "indices.routing-idx.shards"));
            int code = e.getResponse().getStatusLine().getStatusCode();
    }
        internalCluster().startNodes(1);
        createIndexWithShards("routing-idx", 3, 0, true);
     *
        assertEquals("shard sum must equal index total", 300L, sum);
        // allow_no_indices=false — must fail with 4xx.
        Map<String, Object> r = parquetIndexStats("shard-sum-idx");
 * @opensearch.experimental
        Map<String, Object> indicesOk = (Map<String, Object>) rOk.get("indices");
 * Integration tests for stats API behavior across different cluster topologies.
        return sum;
     * Computes the sum of a counter across all shards in the shard-level response.
        try {
        Map<String, Object> single = parquetNodeStats(firstNodeId);
            "multi-node-filter-idx"
    }
        // shards=0,2 — exactly 2 entries.
    /**
            assertNotNull("routing.node must be set", routing.get("node"));
        refreshIndex("other-idx");
        } else {
            Map<String, Object> copy = copies.get(0);
    // a remote-store-backed cluster (RemoteStoreBaseIntegTestCase). Plain peer recovery to a
    @SuppressWarnings("unchecked")
     * Verifies that the {@code expand_wildcards} param controls wildcard expansion semantics.
        // Query level=shards
    }
            getRestClient().performRequest(new Request("GET", "/_plugins/parquet/bad-shard-idx/_stats?level=shards&shards=foo"));
     * each node has its own JVM, so per-node values are correctly partitioned by shard ownership.
        // shards=2 — only that shard in shard-level response.
            "multi-shard-filter-idx"
        Map<String, Object> indexBlock = (Map<String, Object>) indices.get("routing-idx");
    @SuppressWarnings("unchecked")
        assertTrue("nodes key present", nr.containsKey("nodes"));
        Map<String, Object> indicesDefault = (Map<String, Object>) rDefault.get("indices");
        Map<String, Object> mixResp = parquetIndexStats("pat-idx-a,no-such-idx", "ignore_unavailable", "true");
        assertTrue("wildcard must match pat-idx-b", wildIndices.containsKey("pat-idx-b"));
    public void testMultiValueNodeFilter() throws Exception {
        try {
                assertEquals("every entry must be on node A", nodeA, routing.get("node"));
        indexDocs("shard-sum-idx", 300, 0);
        // ignore_unavailable=true with one missing must succeed and return only the existing one.
 * SPDX-License-Identifier: Apache-2.0
        assertTrue("wildcard must match pat-idx-a", wildIndices.containsKey("pat-idx-a"));
        // Get both node IDs.
        } catch (ResponseException e) {
     * than throwing — callers that need strict path validation should use {@code hasPath}.
        assertTrue("must include shard 2", shards2.containsKey("2"));
        assertEquals("shards=0,1,3 must return exactly 3 entries", 3, shards3.size());
    }
        assertFalse("missing index must not appear in response", mixIndices.containsKey("no-such-idx"));
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, numReplicas)
    /**
     * zero indices returns 200 with empty results or 404.
            assertTrue("copy must have indexing block", copy.containsKey("indexing"));
        // node filter — pick a real node id from the cluster, query restricting to that node.
        internalCluster().startNodes(2);
        indexDocs("default-level-idx", 30, 0);
package org.opensearch.composite;
    @SuppressWarnings("unchecked")
        createIndexWithShards("allow-no-anchor-idx", 1, 0, true);
        assertTrue("nodes=A must return at least 1 shard", shardsA.size() >= 1);
        createIndexWithShards("pat-idx-a", 1, 0, true);
            assertEquals("each shard list must have exactly 1 entry (primary only)", 1, copies.size());
        // Lucene secondary must also track the new docs.
        indexDocs("multi-node-filter-idx", 40, 0);
        internalCluster().startNodes(2);
import org.opensearch.cluster.metadata.IndexMetadata;
        // shards=99 — out of range for a 3-shard index.
        Map<String, Object> shardsLocal = (Map<String, Object>) ((Map<String, Object>) ((Map<String, Object>) rLocal.get("indices")).get(
 * this file be licensed under the Apache-2.0 license or a
        // Post-restart: stats endpoint must still be functional.
        String someNodeId = client().admin().cluster().prepareNodesInfo().get().getNodes().get(0).getNode().getId();
        Map<String, Object> mixIndices = (Map<String, Object>) mixResp.get("indices");
        // Restart the data node.
    /**
    @SuppressWarnings("unchecked")
                long val = getCounter(copy, counterPath);
            fail("expected 4xx for allow_no_indices=false on no-match wildcard");
        indexDocs("bad-shard-idx", 30, 0);
        assertTrue("existing index pat-idx-a must appear in response", mixIndices.containsKey("pat-idx-a"));
        assertNotNull("response must have indices key", indicesOk);
        )).get("shards");
 * Each test starts its own cluster nodes since Scope.TEST destroys between tests.
