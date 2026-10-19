        Request request = new Request("POST", "/_plugins/_sql");  
        try (InputStream is = getClass().getClassLoader().getResourceAsStream(path)) {
        return assertOkAndParse(response, "PPL: " + ppl);  
     * provisioning here.  
     * sees the dataset present.
import org.apache.logging.log4j.Logger;
            }
        return true;
        request.setJsonEntity("{\"query\": \"" + escapeJson(ppl) + "\"}");
        return entityAsMap(response);
     * Load a classpath resource as a UTF-8 string.  
    /**
import java.io.IOException;  
     * JVM). Default: no-op.
            return new ArrayList<>();
 * this file be licensed under the Apache-2.0 license or a
    @Override  
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8))) {  
    protected String loadResource(String path) throws IOException {  
                return reader.lines().collect(Collectors.joining("\n"));
import java.nio.charset.StandardCharsets;  
     * hook flow as {@link #executePpl(String)} — subclasses don't need to ensure datasets here.  
    protected static final Logger logger = LogManager.getLogger(AnalyticsRestTestCase.class);
    /**
        }  
            assertNotNull("Resource not found: " + path, is);
import org.opensearch.client.Request;
/**  
    protected void onBeforeQuery() throws IOException {}
        Object schema = response.get("schema");  
     * asserting HTTP 200 and returning the parsed JSON body. The {@link #onBeforeQuery}
    }
import org.opensearch.test.rest.OpenSearchRestTestCase;  
     * Execute a PPL query against the {@code test-ppl-frontend} shim at {@code /_analytics/ppl}.
     * if no schema is present.
     * Assert that the response has HTTP 200 status and return the body as a parsed Map.
     */  
     */
import java.util.ArrayList;
    }  
    protected static String escapeJson(String text) {  
        Response response = client().performRequest(request);
import java.io.BufferedReader;
     */
 * compatible open source license.
    protected static List<String> extractColumnNames(Map<String, Object> response) {
     * opensearch-sql shim's bare {@code "columns": [name, ...]}). Returns an empty list
    @Before  
    protected Map<String, Object> executePpl(String ppl) throws IOException {
     */
    }
     */  
     * provisioned datasets should override to call their {@code DatasetProvisioner.provision}
        Response response = client().performRequest(request);
    /**  
     * <p>Routing through {@code @Before} means setup that doesn't go through  
    protected boolean preserveClusterUponCompletion() {
    }  
     * The {@code context} string is included in failure messages for easier debugging.  
    protected Map<String, Object> executeSql(String sql) throws IOException {
 * The OpenSearch Contributors require contributions made to  
        return text.replace("\\", "\\\\").replace("\"", "\\\"");
    @SuppressWarnings("unchecked")
     */  
     * Use this for tests that exercise <em>engine-internal</em> behavior (e.g. perf-delegation
        Request request = new Request("POST", "/_plugins/_ppl");  
        // Normalize: shim returns {columns, rows}; real SQL plugin returns {schema, datarows}.  
    /**  
     * plugin emits {@code "schema": [{"name": "...", "type": "..."}, ...]} (vs. the legacy  
     * surface isn't on the hook. Tests that exercise a real user-typed PPL feature should keep
    }  
    protected Map<String, Object> assertOkAndParse(Response response, String context) throws IOException {
public abstract class AnalyticsRestTestCase extends OpenSearchRestTestCase {  
        request.setJsonEntity("{\"query\": \"" + escapeJson(ppl) + "\"}");  
    public final void invokeOnBeforeQueryHook() throws IOException {
    }
     * using {@link #executePpl(String)} so they validate the production path end-to-end.
        }  
}
 * Test data provisioning is handled separately by dataset-specific helpers  
    }
    }
 */
        Request request = new Request("POST", "/_analytics/ppl");
     * asserting HTTP 200 and returning the parsed JSON body. Same {@code @Before} provisioning
    protected boolean preserveIndicesUponCompletion() {
 */  
 * Abstract base class for all analytics REST integration tests in the sandbox QA package.
     * each {@link #executePpl} call as a belt-and-braces guard. Subclasses with lazily-
package org.opensearch.analytics.qa;
    /**
        return true;  
     * (gated on a static {@code dataProvisioned} flag so the work only happens once per  
import java.util.Map;  
import org.opensearch.client.Response;
     */
 * <p>
/*  
        onBeforeQuery();
        // Tests that share assertions across both helpers read 'datarows' — mirror it for shim.
     * Extract column names from a PPL response's {@code schema} field. The real opensearch-sql
     * Fails with an assertion error if the resource does not exist.
import java.io.InputStreamReader;
        Map<String, Object> parsed = assertOkAndParse(response, "PPL (shim): " + ppl);
    }
     *
     * {@link #executePpl} (alias creation, raw {@code _search}, expect-failure paths) still
    /**
        if (schema == null) {
     */
     * Hook invoked before each test method via JUnit's {@code @Before}, and also before  
        }
        Response response = client().performRequest(request);
 * loading classpath resources, JSON escaping, and common assertion helpers.
 * <p>
import java.io.InputStream;
        if (parsed.containsKey("rows") && parsed.containsKey("datarows") == false) {
        return entries.stream().map(e -> (String) e.get("name")).collect(Collectors.toList());
 *
    protected Map<String, Object> executePplViaShim(String ppl) throws IOException {
 * SPDX-License-Identifier: Apache-2.0
        request.setJsonEntity("{\"query\": \"" + escapeJson(sql) + "\"}");
     * marker placement, explain output shape) where the opensearch-sql plugin's user-facing PPL  
     * Execute a PPL query against the real opensearch-sql plugin at {@code /_plugins/_ppl},  
 * Handles cluster-level concerns: preserving cluster/indices across test methods,  
import java.util.List;
     * Escape backslashes and double quotes for safe embedding in JSON string values.
            parsed.put("datarows", parsed.get("rows"));  
import org.junit.Before;  
        return assertOkAndParse(response, "SQL: " + sql);  
     * Execute a SQL query against the real opensearch-sql plugin at {@code /_plugins/_sql},
     * hook has already fired via {@code @Before}, so subclasses don't need to ensure data
    /**  
        List<Map<String, Object>> entries = (List<Map<String, Object>>) schema;
 * (e.g. {@link ClickBenchTestHelper}) to keep cluster config orthogonal to test data.
import org.apache.logging.log4j.LogManager;
    /**
        return parsed;
    }  
        assertEquals(context + ": expected HTTP 200", 200, response.getStatusLine().getStatusCode());  
    @Override
import java.util.stream.Collectors;
