        assertTrue(  
        ensureDataProvisioned();
    /**
 * traffic.
    public void testQueryTotalScalesWithShardFanOut() throws IOException {
import org.opensearch.client.Response;
     */
    private static final int NUMBER_OF_SHARDS = 3;
        Map<String, Object> nodes = (Map<String, Object>) body.get("nodes");
import org.opensearch.client.Request;
    }  
        long before = getQueryTotalAcrossNodes();
    private static final Dataset DATASET = new Dataset("calcs", "calcs");
    }  
 */
        long total = 0;
        return sumSearchField("query_total");
                + " on " + NUMBER_OF_SHARDS + "-shard index, expected ≥ " + minExpected
        if (dataProvisioned == false) {
 * compatible open source license.
 * {@code search.query_total} / {@code search.query_time_in_millis} counters under  
            executePpl("source=" + DATASET.indexName + " | where num0 > 0 | fields str0, num0");
    /**
        long before = getQueryTotalAcrossNodes();
     * dropped every recording (e.g. an all-or-nothing window that collapsed).
     * by the shard fan-out factor to downstream consumers of node stats.
 * analytics counters there means no tooling changes are required to observe analytics  
            Map<String, Object> search = (Map<String, Object>) indices.get("search");
/**
 * SPDX-License-Identifier: Apache-2.0
    /**  
     * Multi-shard index so the test can distinguish the per-query contributor
            "search.query_total must grow with shard fan-out (fired " + TOTAL_QUERIES  
        return total;
                total += value.longValue();
    @SuppressWarnings("unchecked")
        fireQueries();
        for (Object nodeValue : nodes.values()) {  
        long before = getQueryTimeAcrossNodes();  
        ensureDataProvisioned();  
package org.opensearch.analytics.qa;
    private void ensureDataProvisioned() throws IOException {
    }  
     * Minimum-viable check: every fired query must contribute at least once to  
    private long sumSearchField(String field) throws IOException {  
    private static boolean dataProvisioned = false;
import java.io.IOException;
        fireQueries();  
        fireQueries();
 *
    private void fireQueries() throws IOException {  
        // Varied shapes so the contributor sees both real elapsed time and a non-trivial count.
 * Integration test verifying that analytics-engine queries surface in the standard
     */  
        assertTrue("search.query_time_in_millis must grow > 0 after PPL work, observed delta=" + delta, delta > 0);
        );
                + ", observed delta=" + delta + ")",
                + ", observed delta=" + delta + ")",
    /**
        for (int i = 0; i < 5; i++) {
    }
     * (instead of N × shards), under-reporting search rate by the shard fan-out
            executePpl("source=" + DATASET.indexName + " | fields str0");  
        Request request = new Request("GET", "/_nodes/stats/indices/search");
     */
    public void testQueryTimeIncrementsAfterAnalyticsQueries() throws IOException {  
            if (indices == null) continue;  
    }
    private long getQueryTotalAcrossNodes() throws IOException {  
            delta >= minExpected  
            if (value != null) {
     * firing entirely (e.g. returns null, or filters out all stages).
        Response response = client().performRequest(request);
     * shard fan-out factor. A 1-per-query contributor would produce delta ≈ N
    private static final int TOTAL_QUERIES = 15;
     * Guards the latency-aggregation bug: query_time_in_millis must move when
 * extension point. Existing tooling (e.g. Tumbler) polls these fields, so wiring the
        return sumSearchField("query_time_in_millis");
            executePpl("source=" + DATASET.indexName + " | stats avg(num0)");
        assertTrue(
     */  
 * {@code GET /_nodes/stats} via the {@link org.opensearch.plugins.SearchStatsContributor}
        long delta = after - before;
 * this file be licensed under the Apache-2.0 license or a
            "search.query_total must grow by at least one per query (fired " + TOTAL_QUERIES
     * (queryCount delta ≈ N × shards). Catches the regression class where the  
     * real PPL work runs. A delta of 0 means the contributor's time source  
        long delta = after - before;
     * (queryCount delta ≈ N) from the per-shard Lucene-equivalent contributor
            }  
        Map<String, Object> body = entityAsMap(response);  
        );
            DatasetProvisioner.provision(client(), DATASET, NUMBER_OF_SHARDS);  
            delta >= TOTAL_QUERIES  
        long after = getQueryTotalAcrossNodes();  
            Map<String, Object> indices = (Map<String, Object>) nodeStats.get("indices");
    }
     * Guards the 1-per-query bug: cluster-wide query_total must grow with the  
        ensureDataProvisioned();
            dataProvisioned = true;
        long delta = after - before;  
        }
public class SearchStatsContributorIT extends AnalyticsRestTestCase {  
/*  
    }
    public void testQueryTotalIncrementsAtLeastOncePerQuery() throws IOException {
}
            Map<String, Object> nodeStats = (Map<String, Object>) nodeValue;
     * cluster-wide query_total. Catches regressions where the contributor stops
import java.util.Map;
            Number value = (Number) search.get(field);  
    private long getQueryTimeAcrossNodes() throws IOException {
     * factor to downstream consumers of node stats.  
    }  
            if (search == null) continue;
        long after = getQueryTotalAcrossNodes();
 */  
     * contributor counts 1-per-query and silently under-reports search rate
        long minExpected = (long) TOTAL_QUERIES * NUMBER_OF_SHARDS / 2;
        }
        long after = getQueryTimeAcrossNodes();
        }  
 * The OpenSearch Contributors require contributions made to  
