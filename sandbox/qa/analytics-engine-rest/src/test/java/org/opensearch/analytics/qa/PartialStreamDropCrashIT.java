 *  
    }  
                + "  \"number_of_shards\": 1,"  
 * <p>The alternation below is the reporter's exact PPL sequence; they observed the
 *       {@code ProviderHandle::drop} upcalls {@code releaseProvider} into Java.</li>
                    client().performRequest(new Request("POST", "/" + INDEX + "/_refresh"));  
 * node dying at round 5, or up to ~30s after a single query (deferred drop).
    }  
            bulk.append("{\"index\":{}}\n")
                + "    \"brand\": { \"type\": \"keyword\" },"  
            }
 * Reproduction for the reported node-killing crash on partially-consumed stream drop  
        Response response = client().performRequest(bulk);
        List<Object> rows = (List<Object>) pplResponse.get("datarows");  
    private static final int BULK_BATCH = 10_000;
/**
        );
import org.opensearch.client.Request;
        try {  
            "{"
        for (int i = 0; i < TOTAL_DOCS; i++) {
        }
        assertEquals(context + ": row count", expected, rows.size());
                + "  \"index.pluggable.dataformat\": \"composite\","  
            assertRowCount("round " + round + " q4", executePpl("source=" + INDEX + " | stats avg(price) by brand"), 5);
                // the per-query ProviderHandle map is populated — required to reach the
    /** 500k docs (reporter's scale), brand-0..brand-4 round-robin → 100k rows per brand. */
        if (bulk.length() > 0) {  
        } catch (Exception ignored) {
        create.setJsonEntity(  
                .append("\",\"price\":")
    private static final int TOTAL_DOCS = 500_000;
            Thread.sleep(5_000);
                + "},"  
 * in flight when LIMIT stops reading.
import java.io.IOException;
        seedDocs();
 * @opensearch.internal
package org.opensearch.analytics.qa;
                + "  \"index.pluggable.dataformat.enabled\": true,"
                    logger.info("--> seeded {} docs", i + 1);
 *  
    }
 *       {@code HashMap<annotationId, OnceLock<ProviderHandle>>};
                // Indexed keyword: makes `where brand=...` a delegation-possible leaf so  
        assertNotNull(context + ": datarows missing in " + pplResponse.keySet(), rows);
 *
        }
/*  
        createBenchIndex();  
                sendBulk(bulk.toString());  
 * provider map is actually populated (parquet-only fixtures never allocate a  
            sendBulk(bulk.toString());
 */  
            assertEquals("node must survive deferred cleanup (t+" + i * 5 + "s)", 200, health.getStatusLine().getStatusCode());  
        Request create = new Request("PUT", "/" + INDEX);
 * The OpenSearch Contributors require contributions made to  
 *   <li>An unsorted filter + LIMIT query satisfies the limit and DataFusion's  
            assertRowCount("post-round probe t+" + i * 5 + "s", executePpl("source=" + INDEX + " | head 10"), 10);
                + "\"mappings\": {"
    public void testAlternatingPplRoundsDoNotKillTheNode() throws Exception {
 *   <li>The Java side throws (binding already unregistered / handle already closed).</li>  
 * {@code ProviderHandle}), and (c) enough matching rows that batches are still
                + "  \"index.composite.secondary_data_formats\": \"lucene\""
        for (int round = 1; round <= ROUNDS; round++) {  
 * compatible open source license.
        for (int i = 1; i <= 7; i++) {  
    private static final int ROUNDS = 5;  
        assertEquals(200, response.getStatusLine().getStatusCode());
                .append("{\"brand\":\"brand-")  
import java.util.Map;  
    }
        }
 * </ol>
        assertEquals(200, response.getStatusLine().getStatusCode());
            assertRowCount("round " + round + " q2", executePpl("source=" + INDEX + " | where brand='brand-3' | head 10"), 10);
 * <p><b>Reported mechanism (from the reporter's hs_err):</b>
 *
        // The reported crash can be deferred up to ~30s after the triggering query
            logger.info("--> round {} ok", round);
 * <p><b>Why this lives in the REST QA module:</b> the crash needs (a) a real  
 *       fatally.</li>  
                + "  \"number_of_replicas\": 0,"
                + "  \"index.composite.primary_data_format\": \"parquet\","
    private void seedDocs() throws IOException {
    }  
        Response response = client().performRequest(create);  
                + "\"settings\": {"
 *   <li>The drop releases the last {@code Arc} to the per-query  
        }
 *       {@code System.exit(1)}, the security policy forbids it, and the JVM dies
 *       {@code LimitStream} stops reading; the {@code IndexedStream} is dropped
            if ((i + 1) % BULK_BATCH == 0) {
            client().performRequest(new Request("DELETE", "/" + INDEX));
                // crashing drop path.
 * <ol>
                if ((i + 1) % 100_000 == 0) {
                + "}"
        // (native drop on a runtime thread after Java tore down the query binding).  
    @SuppressWarnings("unchecked")
 * If the bug fires, the cluster stops answering — asserted by the post-round probes.  
            assertRowCount("round " + round + " q1", executePpl("source=" + INDEX + " | head 10"), 10);
        StringBuilder bulk = new StringBuilder();  
                .append(i % 1000)  
}
            Response health = client().performRequest(new Request("GET", "/_cluster/health"));
                + "  }"
    private void createBenchIndex() throws IOException {
                    client().performRequest(new Request("POST", "/" + INDEX + "/_flush"));
        Request bulk = new Request("POST", "/" + INDEX + "/_bulk");
        // Probe through that window; if the upcall fatal fires the node is gone and
                .append(i % 5)
 * distribution with the agent security policy (so {@code System.exit} is denied),
import java.util.List;
                bulk.setLength(0);
    // ── Helpers ────────────────────────────────────────────────────────────
 *       partially consumed.</li>
            assertRowCount("round " + round + " q3", executePpl("source=" + INDEX + " | where brand='brand-3' | stats count()"), 1);  
        client().performRequest(new Request("POST", "/" + INDEX + "/_refresh"));  
                + "}"  
                .append("}\n");
 */  
 * allowed to call System::exit(1)}).
 *
                + "    \"price\": { \"type\": \"integer\" }"
        // the probe request fails.
    private static final String INDEX = "bench";  
            // index may not exist yet  
                + "  \"properties\": {"
    private void assertRowCount(String context, Map<String, Object> pplResponse, int expected) {
public class PartialStreamDropCrashIT extends AnalyticsRestTestCase {
    private void sendBulk(String body) throws IOException {
        client().performRequest(new Request("POST", "/" + INDEX + "/_flush"));
        }  
 * SPDX-License-Identifier: Apache-2.0
 * (b) the Lucene secondary so the filter leaf is delegation-possible and the
                }  
 * ({@code upcallLinker.cpp:137} fatal, {@code SecurityException: SharedUtils is not
 * this file be licensed under the Apache-2.0 license or a
 *   <li>An exception cannot cross an FFM upcall; the JDK falls back to
        bulk.setJsonEntity(body);  
import org.opensearch.client.Response;
