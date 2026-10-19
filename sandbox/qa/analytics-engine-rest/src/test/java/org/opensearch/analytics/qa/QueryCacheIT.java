     *   if (isCostly(query))       → return costlyMinFrequency;
        createIndex();
        executePpl(ppl);  
 * Integration tests verifying the node-level query cache interaction with Lucene filter
        configureCacheSettings(2, 1);  
            + "  \"index.composite.secondary_data_formats\": \"lucene\""  
        long cacheSizeAfterSecond = getQueryCacheStat("cache_size");
 *
        indexDocs();
import java.util.List;
            bulk.append("{\"index\": {}}\n");
        for (int i = 0; i < 10; i++) {
        executePpl(ppl);  
        executePpl(ppl1);
        Request health = new Request("GET", "/_cluster/health/" + INDEX_NAME);  
        long cacheSizeBefore = getQueryCacheStat("cache_size");  
     * <p>match(message, 'hello world') with default OR operator produces
            + "}"
 *       segment size predicate so caching works with small test data sets</li>
        long cacheSizeAfter = getQueryCacheStat("cache_size");
        Request createIdx = new Request("PUT", "/" + INDEX_NAME);
        executePpl(ppl);  
            + "  \"analytics.planner.prefer_metadata_driver\": false"  
    /**
/**
            cacheSizeAfterFirst
            "Cache hit_count should increase on repeat. Before: " + hitsBefore + ", After: " + hitsAfter,
        );
            "BooleanQuery should NOT cache on first use when min_frequency=3 (threshold=2)",  
        // query cache. Under prefer=true (the default), single-MATCH count fragments take the  
        assertEquals("scalar agg must return exactly 1 row", 1, rows.size());  
                + cacheSizeAfterFirst + ", After: " + cacheSizeAfterSecond,
            cacheSizeBefore,
                + cacheSizeAfterFirst + ", After second: " + cacheSizeAfterSecond,
        client().performRequest(new Request("POST", "/" + INDEX_NAME + "/_flush?force=true"));
        // Second call — should produce a cache hit
     * {@code IndicesQueryCache.OpenseachUsageTrackingQueryCachingPolicy#minFrequencyToCache}:
    public void testTermQuery_neverCached() throws Exception {
     * term queries are already fast enough without caching. Verify the cache does NOT grow.  
 * <p>Requires the test cluster to be configured with:
        Request bulkRequest = new Request("POST", "/" + INDEX_NAME + "/_bulk");
 * <p>Cache frequency thresholds are lowered via dynamic cluster settings within the tests.
     * Sets the dynamic cluster settings that control query cache frequency thresholds.  
    private void createIndex() throws Exception {  
            hitsAfter > hitsBefore
     */
        String ppl = "source = " + INDEX_NAME + " | where match(message, 'hello') | stats count() as c";
/*  
            + "\"mappings\": {"
            Map<String, Object> queryCache = (Map<String, Object>) indices.get("query_cache");
    private long getQueryCacheStat(String statName) throws Exception {
     * </pre>
            + "    \"tag\": { \"type\": \"keyword\" },"
        );  
        List<List<Object>> rows = (List<List<Object>>) result.get("datarows");
        // Second call — frequency=2 → threshold met → cache populates
            + "  \"indices.queries.cache.min_frequency\": " + minFrequency + ","
 * and executed via an IndexSearcher that has the node's IndicesQueryCache set. These tests
        );  
        String ppl2 = "source = " + INDEX_NAME + " | where match(message, 'goodbye world') | stats count() as c";
        for (Object nodeObj : nodes.values()) {
 */  
        long cacheSizeAfterFirst = getQueryCacheStat("cache_size");
 * <ul>
            + "}");
        } catch (Exception ignored) {}  
     *   if (query instanceof BooleanQuery || DisjunctionMaxQuery) threshold--;  
        // First call — BooleanQuery threshold=1 → caches immediately
        long cacheSizeBefore = getQueryCacheStat("cache_size");
        client().performRequest(bulkRequest);
            total += ((Number) queryCache.get(statName)).longValue();
        // All 20 docs match because default operator is OR ("hello" OR "world")  
     * Verifies: cache populates immediately and subsequent calls produce hits.
            bulk.append("{\"message\": \"hello world\", \"tag\": \"hello\", \"value\": 5}\n");
            "BooleanQuery should cache on first use (discount -1, threshold=1). Before: "  
     * The effective caching threshold for a query is determined by
 */  
        try {
        String body = "{"
            cacheSizeAfterSecond > cacheSizeAfterFirst
        executePpl(ppl);
            hitsAfter > hitsBefore
    public void testBooleanQuery_higherFrequency_cachesOnSecondUse() throws Exception {
     * <pre>  
        assertNotNull("rows must not be null", rows);
        createIndex();
        bulkRequest.addParameter("refresh", "true");
    private static final String INDEX_NAME = "query_cache_e2e";  
    private void indexDocs() throws Exception {  
            + "},"
            + "  \"indices.queries.cache.costly_min_frequency\": " + costlyMinFrequency  
     * Verifies that different delegated queries produce independent cache entries.
        assertTrue(
            + "  \"properties\": {"  
        // collector entirely.
import org.opensearch.client.Request;
        configureCacheSettings(3, 1);  
        bulkRequest.setJsonEntity(bulk.toString());  
 * SPDX-License-Identifier: Apache-2.0
     * BooleanQuery(TermQuery("hello"), TermQuery("world")) which matches all 20 docs
     */
    // ── Helpers ──────────────────────────────────────────────────────────────────  
        assertEquals(
            + "  \"number_of_replicas\": 0,"
        String ppl = "source = " + INDEX_NAME + " | where match(message, 'hello world') | stats count() as c";
            bulk.append("{\"message\": \"goodbye world\", \"tag\": \"goodbye\", \"value\": 3}\n");
    public void testDistinctQueries_cachedIndependently() throws Exception {
     * (both "hello world" and "goodbye world" contain "world").  
    }
            + "\"persistent\": {"
     * Single-term match produces a TermQuery. Lucene's UsageTrackingQueryCachingPolicy
        executePpl(ppl);
        }
     * Verifies the discount arithmetic works as expected at a higher threshold.  
            + "\"settings\": {"  
        Request settings = new Request("PUT", "/_cluster/settings");  
        assertEquals(  
    private void assertRowCount(Map<String, Object> result, long expectedCount) {  
            + "}"
        long hitsAfter = getQueryCacheStat("hit_count");
        // Multiple calls — TermQuery should never be cached regardless of frequency  
        client().performRequest(settings);  
    private void configureCacheSettings(int minFrequency, int costlyMinFrequency) throws Exception {
     */
        for (int i = 0; i < 10; i++) {  
        // Third call — cache hit
        indexDocs();
        indexDocs();
        assertTrue(
    }
        health.addParameter("wait_for_status", "green");
}  
        long hitsBefore = getQueryCacheStat("hit_count");  
        return total;
            cacheSizeAfterSecond > cacheSizeAfterFirst
     *   return max(1, threshold);
    @SuppressWarnings("unchecked")
    }
        // Single-term match → TermQuery (excluded from caching by policy)
        long cacheSizeAfter = getQueryCacheStat("cache_size");
 *  
        Map<String, Object> result = executePpl(ppl);
     *  
        client().performRequest(health);  
        settings.setJsonEntity("{"  
 * this file be licensed under the Apache-2.0 license or a
                + cacheSizeBefore + ", After: " + cacheSizeAfter,
    }
        health.addParameter("timeout", "30s");
 * delegation. Delegated queries (MATCH, EQUALS on keyword) are compiled into Lucene Queries  
 *  
    }
     * With min_frequency=3: BooleanQuery threshold = max(1, 3-1) = 2 → caches on second use.
        long cacheSizeBefore = getQueryCacheStat("cache_size");
        indexDocs();
            Map<String, Object> indices = (Map<String, Object>) node.get("indices");  
        assertTrue(cacheSizeAfterFirst > cacheSizeBefore);  
            cacheSizeAfter  
            "Second distinct query should add its own cache entry. After first: "  
     */
            + "    \"value\": { \"type\": \"integer\" }"  
            + "},"
        );  
        executePpl(ppl2);  
     * BooleanQuery (from multi-term match) gets a -1 frequency discount.  
     */
        Map<String, Object> nodes = (Map<String, Object>) stats.get("nodes");
    /**  
 * The OpenSearch Contributors require contributions made to  
        // First call — BooleanQuery threshold=2, frequency=1 → not cached
    public void testBooleanQuery_cachesOnFirstUse() throws Exception {
        // Cache first query (BooleanQuery, threshold=1 → immediate)  
        );  
        createIdx.setJsonEntity(body);  
 * verify that the cache is populated and produces hits on repeated executions.
            bulk.append("{\"index\": {}}\n");  
     * Two distinct BooleanQueries should each get cached separately.
        String ppl = "source = " + INDEX_NAME + " | where match(message, 'hello world') | stats count() as c";
        assertTrue(
package org.opensearch.analytics.qa;
            cacheSizeBefore,
            cacheSizeAfter > cacheSizeBefore
     * With min_frequency=2: threshold = max(1, 2-1) = 1 → caches on first use.
        long hitsAfter = getQueryCacheStat("hit_count");
        assertTrue(  
        assertRowCount(result, 20);
        long cacheSizeBefore = getQueryCacheStat("cache_size");  
import org.opensearch.client.Response;
        long cacheSizeAfterSecond = getQueryCacheStat("cache_size");
            Map<String, Object> node = (Map<String, Object>) nodeObj;
            "TermQuery should never be cached by UsageTrackingQueryCachingPolicy",
            "BooleanQuery should cache on second use when min_frequency=3. Before: "  
    }
    }
            + "    \"message\": { \"type\": \"text\" },"
        executePpl(ppl);
     * Multi term queries [ "match[hello world]"  == "match either hello OR world" ] for example gets resolved as costly queries.  
 *
     * A query is cached once its observed frequency >= threshold.  
        Request statsRequest = new Request("GET", "/_nodes/stats/indices/query_cache");  
        long hitsBefore = getQueryCacheStat("hit_count");  
            + "\"transient\": {"
    /**
            "Cache hit should occur on third call. Before: " + hitsBefore + ", After: " + hitsAfter,
        configureCacheSettings(2, 1);  
    }
    /**  
        }  
        );  
    }
        }  
     *   int threshold = minFrequency;
            + "  }"
        // Cache second query
        assertOkAndParse(client().performRequest(createIdx), "Create cache test index");
    /**
            + "  \"index.composite.primary_data_format\": \"parquet\","
        long total = 0;  
        StringBuilder bulk = new StringBuilder();
            + "  \"number_of_shards\": 1,"
        assertTrue(  
            client().performRequest(new Request("DELETE", "/" + INDEX_NAME));
            + "  \"index.pluggable.dataformat\": \"composite\","
 * compatible open source license.
        // Force prefer_metadata_driver=false so the predicate goes through DataFusion's
 * </ul>
        // Lucene-as-driver shortcut via IndexSearcher.count, bypassing the cache-tracking
            + "  \"index.pluggable.dataformat.enabled\": true,"  
        configureCacheSettings(2, 1);  
    @SuppressWarnings("unchecked")
        createIndex();
        long cacheSizeAfterFirst = getQueryCacheStat("cache_size");
import java.util.Map;
     * explicitly excludes TermQuery from caching (shouldNeverCache returns true) because
        // FilterDelegationHandle / Lucene Collector path — which is what populates the
        Map<String, Object> stats = entityAsMap(client().performRequest(statsRequest));
        createIndex();
        assertEquals(expectedCount, ((Number) rows.get(0).get(0)).longValue());
            + "}";  
        executePpl(ppl);
        String ppl1 = "source = " + INDEX_NAME + " | where match(message, 'hello world') | stats count() as c";
 *   <li>{@code indices.queries.cache.all_segments=true} — bypasses the 10k-doc minimum  
        );  
public class QueryCacheIT extends AnalyticsRestTestCase {
