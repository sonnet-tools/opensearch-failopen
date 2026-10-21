        createIndex();
/**
            bulk.append("{\"message\": \"goodbye world\", \"tag\": \"goodbye\", \"value\": 3}\n");
            "Cache hit should occur on third call. Before: " + hitsBefore + ", After: " + hitsAfter,
        long cacheSizeBefore = getQueryCacheStat("cache_size");
        executePpl(ppl);
        bulkRequest.addParameter("refresh", "true");
            + "  \"index.pluggable.dataformat.enabled\": true,"
        // All 20 docs match because default operator is OR ("hello" OR "world")
    private void assertRowCount(Map<String, Object> result, long expectedCount) {
        indexDocs();
        String ppl = "source = " + INDEX_NAME + " | where match(message, 'hello world') | stats count() as c";
        // Cache second query
        indexDocs();
            + "  \"number_of_shards\": 1,"
        long cacheSizeAfter = getQueryCacheStat("cache_size");
        indexDocs();
     * (both "hello world" and "goodbye world" contain "world").
     * term queries are already fast enough without caching. Verify the cache does NOT grow.
                + cacheSizeAfterFirst + ", After: " + cacheSizeAfterSecond,
     */
    private void configureCacheSettings(int minFrequency, int costlyMinFrequency) throws Exception {
    public void testBooleanQuery_higherFrequency_cachesOnSecondUse() throws Exception {
            cacheSizeAfterSecond > cacheSizeAfterFirst
            + "  \"index.composite.primary_data_format\": \"parquet\","
public class QueryCacheIT extends AnalyticsRestTestCase {
        // Second call — frequency=2 → threshold met → cache populates
            "Second distinct query should add its own cache entry. After first: "
    /**
            "BooleanQuery should cache on second use when min_frequency=3. Before: "
        createIdx.setJsonEntity(body);
        client().performRequest(health);
        long cacheSizeAfter = getQueryCacheStat("cache_size");
        createIndex();
        // Force prefer_metadata_driver=false so the predicate goes through DataFusion's
    private void createIndex() throws Exception {
     * With min_frequency=2: threshold = max(1, 2-1) = 1 → caches on first use.
            bulk.append("{\"index\": {}}\n");
            + "\"transient\": {"
        long cacheSizeBefore = getQueryCacheStat("cache_size");
        // Second call — should produce a cache hit
     */
        // collector entirely.
        executePpl(ppl);
        indexDocs();
        long hitsAfter = getQueryCacheStat("hit_count");
        client().performRequest(settings);
        Request health = new Request("GET", "/_cluster/health/" + INDEX_NAME);
    }
 */
            hitsAfter > hitsBefore
     * {@code IndicesQueryCache.OpenseachUsageTrackingQueryCachingPolicy#minFrequencyToCache}:
     *   int threshold = minFrequency;
     * BooleanQuery (from multi-term match) gets a -1 frequency discount.
     * <pre>
    /**
        long cacheSizeBefore = getQueryCacheStat("cache_size");
        );
        } catch (Exception ignored) {}
            hitsAfter > hitsBefore
            client().performRequest(new Request("DELETE", "/" + INDEX_NAME));
}
 * delegation. Delegated queries (MATCH, EQUALS on keyword) are compiled into Lucene Queries
        String ppl1 = "source = " + INDEX_NAME + " | where match(message, 'hello world') | stats count() as c";
        assertTrue(
    public void testBooleanQuery_cachesOnFirstUse() throws Exception {
    private void indexDocs() throws Exception {
                + cacheSizeAfterFirst + ", After second: " + cacheSizeAfterSecond,
    public void testTermQuery_neverCached() throws Exception {
        long cacheSizeAfterSecond = getQueryCacheStat("cache_size");
        health.addParameter("wait_for_status", "green");
            + "  \"index.composite.secondary_data_formats\": \"lucene\""
        long hitsBefore = getQueryCacheStat("hit_count");
        // Single-term match → TermQuery (excluded from caching by policy)
        String ppl = "source = " + INDEX_NAME + " | where match(message, 'hello world') | stats count() as c";
    }
            + "}");
                + cacheSizeBefore + ", After: " + cacheSizeAfter,
        assertTrue(
import java.util.List;
 *
     * Sets the dynamic cluster settings that control query cache frequency thresholds.
        configureCacheSettings(2, 1);
 * verify that the cache is populated and produces hits on repeated executions.
        String ppl2 = "source = " + INDEX_NAME + " | where match(message, 'goodbye world') | stats count() as c";
     */
        assertRowCount(result, 20);
        );
        // query cache. Under prefer=true (the default), single-MATCH count fragments take the
            cacheSizeBefore,
 * Integration tests verifying the node-level query cache interaction with Lucene filter
        bulkRequest.setJsonEntity(bulk.toString());
    @SuppressWarnings("unchecked")
 * <ul>
    }
    }
        Map<String, Object> result = executePpl(ppl);
     * With min_frequency=3: BooleanQuery threshold = max(1, 3-1) = 2 → caches on second use.
 *   <li>{@code indices.queries.cache.all_segments=true} — bypasses the 10k-doc minimum
 */
        health.addParameter("timeout", "30s");
        List<List<Object>> rows = (List<List<Object>>) result.get("datarows");
package org.opensearch.analytics.qa;
     *   if (query instanceof BooleanQuery || DisjunctionMaxQuery) threshold--;
            + "  }"
        createIndex();
        );
     * Single-term match produces a TermQuery. Lucene's UsageTrackingQueryCachingPolicy
        assertTrue(cacheSizeAfterFirst > cacheSizeBefore);
        }
            + "  \"indices.queries.cache.costly_min_frequency\": " + costlyMinFrequency
        // First call — BooleanQuery threshold=2, frequency=1 → not cached
            cacheSizeAfter
     * Two distinct BooleanQueries should each get cached separately.
        client().performRequest(new Request("POST", "/" + INDEX_NAME + "/_flush?force=true"));
            cacheSizeAfterFirst
        for (Object nodeObj : nodes.values()) {
     * The effective caching threshold for a query is determined by
        createIndex();
            bulk.append("{\"message\": \"hello world\", \"tag\": \"hello\", \"value\": 5}\n");
        String body = "{"
    }
        // First call — BooleanQuery threshold=1 → caches immediately
            + "  \"index.pluggable.dataformat\": \"composite\","
        long hitsBefore = getQueryCacheStat("hit_count");
        long cacheSizeAfterSecond = getQueryCacheStat("cache_size");
     *   return max(1, threshold);
     */
    /**
     * </pre>
    @SuppressWarnings("unchecked")
        Map<String, Object> nodes = (Map<String, Object>) stats.get("nodes");
            + "    \"value\": { \"type\": \"integer\" }"
    private static final String INDEX_NAME = "query_cache_e2e";
     *
            + "}"
 * this file be licensed under the Apache-2.0 license or a
            + "\"persistent\": {"
        executePpl(ppl);
        configureCacheSettings(3, 1);
     */
            "BooleanQuery should cache on first use (discount -1, threshold=1). Before: "
 *
        configureCacheSettings(2, 1);
 * and executed via an IndexSearcher that has the node's IndicesQueryCache set. These tests
            + "  \"properties\": {"
     * Verifies: cache populates immediately and subsequent calls produce hits.
        executePpl(ppl2);
            + "  \"analytics.planner.prefer_metadata_driver\": false"
            cacheSizeAfter > cacheSizeBefore
        }
        );
        assertEquals(
 * The OpenSearch Contributors require contributions made to
        assertNotNull("rows must not be null", rows);
    }
import org.opensearch.client.Request;
        StringBuilder bulk = new StringBuilder();
    // ── Helpers ──────────────────────────────────────────────────────────────────
        executePpl(ppl);
 * <p>Cache frequency thresholds are lowered via dynamic cluster settings within the tests.
        long cacheSizeAfterFirst = getQueryCacheStat("cache_size");
        long cacheSizeBefore = getQueryCacheStat("cache_size");
            + "    \"tag\": { \"type\": \"keyword\" },"
            + "},"
            + "\"mappings\": {"
        return total;
        executePpl(ppl1);
    /**
        Request statsRequest = new Request("GET", "/_nodes/stats/indices/query_cache");
        Request createIdx = new Request("PUT", "/" + INDEX_NAME);
        // Cache first query (BooleanQuery, threshold=1 → immediate)
     * A query is cached once its observed frequency >= threshold.
        configureCacheSettings(2, 1);
        assertEquals(expectedCount, ((Number) rows.get(0).get(0)).longValue());
            bulk.append("{\"index\": {}}\n");
            Map<String, Object> node = (Map<String, Object>) nodeObj;
            + "},"
     * BooleanQuery(TermQuery("hello"), TermQuery("world")) which matches all 20 docs
 * compatible open source license.
        assertOkAndParse(client().performRequest(createIdx), "Create cache test index");
        Request bulkRequest = new Request("POST", "/" + INDEX_NAME + "/_bulk");
        Request settings = new Request("PUT", "/_cluster/settings");
        );
        // Third call — cache hit
        );
     *   if (isCostly(query))       → return costlyMinFrequency;
        long total = 0;
            total += ((Number) queryCache.get(statName)).longValue();
            + "\"settings\": {"
        executePpl(ppl);
        assertEquals(
            Map<String, Object> queryCache = (Map<String, Object>) indices.get("query_cache");
    }
        assertEquals("scalar agg must return exactly 1 row", 1, rows.size());
        Map<String, Object> stats = entityAsMap(client().performRequest(statsRequest));
        assertTrue(
        // Lucene-as-driver shortcut via IndexSearcher.count, bypassing the cache-tracking
        long cacheSizeAfterFirst = getQueryCacheStat("cache_size");
        for (int i = 0; i < 10; i++) {
            + "}";
        );
        long hitsAfter = getQueryCacheStat("hit_count");
        settings.setJsonEntity("{"
    private long getQueryCacheStat(String statName) throws Exception {
 *
     * explicitly excludes TermQuery from caching (shouldNeverCache returns true) because
     * <p>match(message, 'hello world') with default OR operator produces
 *       segment size predicate so caching works with small test data sets</li>
import java.util.Map;
            + "}"
 * <p>Requires the test cluster to be configured with:
            + "  \"indices.queries.cache.min_frequency\": " + minFrequency + ","
            "TermQuery should never be cached by UsageTrackingQueryCachingPolicy",
    /**
    }
            cacheSizeBefore,
 * SPDX-License-Identifier: Apache-2.0
            cacheSizeAfterSecond > cacheSizeAfterFirst
        client().performRequest(bulkRequest);
        assertTrue(
        for (int i = 0; i < 10; i++) {
 * </ul>
    public void testDistinctQueries_cachedIndependently() throws Exception {
            Map<String, Object> indices = (Map<String, Object>) node.get("indices");
     * Multi term queries [ "match[hello world]"  == "match either hello OR world" ] for example gets resolved as costly queries.
import org.opensearch.client.Response;
            + "    \"message\": { \"type\": \"text\" },"
        executePpl(ppl);
        executePpl(ppl);
     * Verifies that different delegated queries produce independent cache entries.
            "Cache hit_count should increase on repeat. Before: " + hitsBefore + ", After: " + hitsAfter,
     * Verifies the discount arithmetic works as expected at a higher threshold.
    }
        }
/*
            + "  \"number_of_replicas\": 0,"
        String ppl = "source = " + INDEX_NAME + " | where match(message, 'hello') | stats count() as c";
 *
        try {
        assertTrue(
        // Multiple calls — TermQuery should never be cached regardless of frequency
        // FilterDelegationHandle / Lucene Collector path — which is what populates the
            "BooleanQuery should NOT cache on first use when min_frequency=3 (threshold=2)",
