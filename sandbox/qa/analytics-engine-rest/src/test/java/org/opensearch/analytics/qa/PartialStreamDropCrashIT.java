 *       partially consumed.</li>
            // index may not exist yet
 */
/*
                + "},"
    }
                + "}"
 * Reproduction for the reported node-killing crash on partially-consumed stream drop
                + "  }"
            Response health = client().performRequest(new Request("GET", "/_cluster/health"));
 * <p><b>Why this lives in the REST QA module:</b> the crash needs (a) a real
                bulk.setLength(0);
 * node dying at round 5, or up to ~30s after a single query (deferred drop).
    public void testAlternatingPplRoundsDoNotKillTheNode() throws Exception {
                + "\"mappings\": {"
        }
 *       {@code System.exit(1)}, the security policy forbids it, and the JVM dies
            assertRowCount("round " + round + " q3", executePpl("source=" + INDEX + " | where brand='brand-3' | stats count()"), 1);
 * SPDX-License-Identifier: Apache-2.0
        client().performRequest(new Request("POST", "/" + INDEX + "/_flush"));
 * {@code ProviderHandle}), and (c) enough matching rows that batches are still
    }
        List<Object> rows = (List<Object>) pplResponse.get("datarows");
public class PartialStreamDropCrashIT extends AnalyticsRestTestCase {
 * distribution with the agent security policy (so {@code System.exit} is denied),
                + "  \"index.composite.secondary_data_formats\": \"lucene\""
}
 * ({@code upcallLinker.cpp:137} fatal, {@code SecurityException: SharedUtils is not
        createBenchIndex();
            sendBulk(bulk.toString());
        // Probe through that window; if the upcall fatal fires the node is gone and
    }
 * </ol>
        // The reported crash can be deferred up to ~30s after the triggering query
        Response response = client().performRequest(bulk);
                // Indexed keyword: makes `where brand=...` a delegation-possible leaf so
 *   <li>An unsorted filter + LIMIT query satisfies the limit and DataFusion's
    /** 500k docs (reporter's scale), brand-0..brand-4 round-robin → 100k rows per brand. */
                .append(i % 5)
            assertRowCount("round " + round + " q2", executePpl("source=" + INDEX + " | where brand='brand-3' | head 10"), 10);
    private void createBenchIndex() throws IOException {
    private static final int ROUNDS = 5;
            client().performRequest(new Request("DELETE", "/" + INDEX));
        }
    private static final int TOTAL_DOCS = 500_000;
            "{"
 *   <li>An exception cannot cross an FFM upcall; the JDK falls back to
    private void seedDocs() throws IOException {
import java.util.List;
        assertEquals(200, response.getStatusLine().getStatusCode());
 *       {@code LimitStream} stops reading; the {@code IndexedStream} is dropped
                + "    \"brand\": { \"type\": \"keyword\" },"
        assertEquals(200, response.getStatusLine().getStatusCode());
 *
                    logger.info("--> seeded {} docs", i + 1);
            assertEquals("node must survive deferred cleanup (t+" + i * 5 + "s)", 200, health.getStatusLine().getStatusCode());
        );
                // the per-query ProviderHandle map is populated — required to reach the
                + "  \"number_of_shards\": 1,"
        client().performRequest(new Request("POST", "/" + INDEX + "/_refresh"));
    private void sendBulk(String body) throws IOException {
 *
 * The OpenSearch Contributors require contributions made to
            bulk.append("{\"index\":{}}\n")
    }
/**
 * @opensearch.internal
        }
 * <p><b>Reported mechanism (from the reporter's hs_err):</b>
 * If the bug fires, the cluster stops answering — asserted by the post-round probes.
            assertRowCount("post-round probe t+" + i * 5 + "s", executePpl("source=" + INDEX + " | head 10"), 10);
 *   <li>The drop releases the last {@code Arc} to the per-query
 *
 * allowed to call System::exit(1)}).
 *   <li>The Java side throws (binding already unregistered / handle already closed).</li>
        for (int round = 1; round <= ROUNDS; round++) {
            logger.info("--> round {} ok", round);
        assertEquals(context + ": row count", expected, rows.size());
 *       {@code HashMap<annotationId, OnceLock<ProviderHandle>>};
 * this file be licensed under the Apache-2.0 license or a
            Thread.sleep(5_000);
import java.io.IOException;
                + "  \"index.pluggable.dataformat.enabled\": true,"
 * (b) the Lucene secondary so the filter leaf is delegation-possible and the
        // (native drop on a runtime thread after Java tore down the query binding).
        Request bulk = new Request("POST", "/" + INDEX + "/_bulk");
        StringBuilder bulk = new StringBuilder();
        create.setJsonEntity(
                + "\"settings\": {"
                + "  \"number_of_replicas\": 0,"
 *
    }
                    client().performRequest(new Request("POST", "/" + INDEX + "/_refresh"));
            assertRowCount("round " + round + " q4", executePpl("source=" + INDEX + " | stats avg(price) by brand"), 5);
            if ((i + 1) % BULK_BATCH == 0) {
            }
                // crashing drop path.
    private void assertRowCount(String context, Map<String, Object> pplResponse, int expected) {
                + "  \"index.composite.primary_data_format\": \"parquet\","
                .append("{\"brand\":\"brand-")
                }
        try {
        Response response = client().performRequest(create);
 * compatible open source license.
                sendBulk(bulk.toString());
        for (int i = 0; i < TOTAL_DOCS; i++) {
 *       {@code ProviderHandle::drop} upcalls {@code releaseProvider} into Java.</li>
                + "}"
    // ── Helpers ────────────────────────────────────────────────────────────
                .append(i % 1000)
import java.util.Map;
                + "  \"index.pluggable.dataformat\": \"composite\","
                .append("}\n");
        }
 *
        Request create = new Request("PUT", "/" + INDEX);
 * in flight when LIMIT stops reading.
        }
        assertNotNull(context + ": datarows missing in " + pplResponse.keySet(), rows);
    @SuppressWarnings("unchecked")
 * provider map is actually populated (parquet-only fixtures never allocate a
        seedDocs();
                if ((i + 1) % 100_000 == 0) {
        if (bulk.length() > 0) {
 *       fatally.</li>
                .append("\",\"price\":")
        for (int i = 1; i <= 7; i++) {
package org.opensearch.analytics.qa;
 * <p>The alternation below is the reporter's exact PPL sequence; they observed the
import org.opensearch.client.Request;
                + "  \"properties\": {"
    private static final int BULK_BATCH = 10_000;
            assertRowCount("round " + round + " q1", executePpl("source=" + INDEX + " | head 10"), 10);
                    client().performRequest(new Request("POST", "/" + INDEX + "/_flush"));
 * <ol>
        // the probe request fails.
        } catch (Exception ignored) {
 */
    private static final String INDEX = "bench";
        bulk.setJsonEntity(body);
import org.opensearch.client.Response;
                + "    \"price\": { \"type\": \"integer\" }"
