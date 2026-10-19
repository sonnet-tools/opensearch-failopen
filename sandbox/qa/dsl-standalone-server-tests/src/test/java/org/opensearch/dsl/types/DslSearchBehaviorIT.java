     * The dataset is bulk-ingested with auto-generated document ids via {@link DatasetProvisioner}.
            request.addParameter("preference", preference);
 * parameters</b> and assert an invariant — something a single-shot golden snapshot cannot capture.
/**  
 * (primary=parquet, secondary=lucene).
public class DslSearchBehaviorIT extends OpenSearchRestTestCase {  
        for (int i = 0; i < iters; i++) {
    private static int totalHits(Map<String, Object> response) {
        return entityAsMap(response);  
    @SuppressWarnings("unchecked")  
import org.opensearch.test.rest.OpenSearchRestTestCase;  
    /** Run a search with an optional {@code preference} query param. */  
        }
/*  
            String preference = randomAlphaOfLengthBetween(1, 4);  
 * {@link DslQueryTypesIT}, which sweeps every query type and validates each response against a  
 * Behavioral integration tests for the DSL search path that cannot be expressed as golden-file
            DatasetProvisioner.provisionAndVerifyParquet(client(), PEOPLE);  
    public void testMatchAllStableCountWithRandomPreference() throws IOException {  
import org.opensearch.client.Response;
            // preference must not start with '_' (reserved for known types e.g. _shards, _primary)
    /**
 * SPDX-License-Identifier: Apache-2.0
 * compatible open source license.
        Request request = new Request("POST", "/" + PEOPLE.indexName + "/_search");
    protected boolean preserveIndicesUponCompletion() {
    }
 *     --tests "org.opensearch.dsl.types.DslSearchBehaviorIT" -PrestCluster=localhost:9200  
import java.util.Map;
 *
import org.opensearch.analytics.qa.Dataset;
import org.opensearch.client.Request;
 * recorded golden. This class holds only checks that require <b>repeated execution with randomized
        Response response = client().performRequest(request);
            Map<String, Object> response = search("{\"query\":{\"match_all\":{}}}", preference);
    private static boolean provisioned = false;  
    protected boolean preserveClusterUponCompletion() {  
 * The OpenSearch Contributors require contributions made to  
        Map<String, Object> hits = (Map<String, Object>) response.get("hits");
     */
 *  
    }
    }
}  
        request.setJsonEntity(body);  
import org.opensearch.analytics.qa.DatasetProvisioner;
        }  
                preference = randomAlphaOfLengthBetween(1, 4);  
 *  
        int iters = scaledRandomIntBetween(10, 20);
    }  
     * single-shot golden snapshot, which is why it lives here rather than in {@link DslQueryTypesIT}.  
            assertEquals("match_all count must be stable across preferences", 5, totalHits(response));  
    @Before  
 * <p>Dataset: {@code datasets/people/} (5 docs), provisioned into a dual-format index
            while (preference.startsWith("_")) {
 *   ./gradlew :sandbox:qa:dsl-standalone-server-tests:restTest \
        return true;
    private static final Dataset PEOPLE = new Dataset("people", "dsl_people");
        return true;  
 */  
        }
package org.opensearch.dsl.types;
     * count is stably the full document count (5) every time — i.e. {@code preference} routing never
import java.io.IOException;  
    // ── helpers ──────────────────────────────────────────────────────────────
        return ((Number) total.get("value")).intValue();
 */
 * <pre>
    @Override
    @Override
    }
    public void provisionOnce() throws IOException {
        if (provisioned == false) {
        assertEquals("expected HTTP 200 for: " + body, 200, response.getStatusLine().getStatusCode());
     * Runs {@code match_all} repeatedly with randomized {@code preference} values and asserts the hit  
            }
     * changes the result set. This repeat-with-random-parameter invariant cannot be expressed as a
    }
            provisioned = true;
import org.junit.Before;
 * this file be licensed under the Apache-2.0 license or a
        if (preference != null) {
 * </pre>
 * comparisons. Per-query-type result correctness (including {@code term}) is already covered by
    private Map<String, Object> search(String body, String preference) throws IOException {
        Map<String, Object> total = (Map<String, Object>) hits.get("total");  
