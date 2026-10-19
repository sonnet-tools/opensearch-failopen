    // Test 1: circuit breaker trips instead of OOM for an oversized batch
        CircuitBreakerService breakerService = circuitBreakerServiceWithLimit(limitBytes);  
        // Lower limit to 2 via dynamic update.  
import org.opensearch.core.indices.breaker.CircuitBreakerService;
        MultiSearchTemplateRequest request = buildRequest(1, 5);
     * Build a {@link MultiSearchTemplateRequest} with {@code n} inline Mustache templates.  
        AtomicReference<ActionListener<MultiSearchResponse>> multiSearchListener = new AtomicReference<>();
        request.add(tmpl);
            Set.of(TransportMultiSearchTemplateAction.MAX_TEMPLATE_BATCH_SIZE_SETTING)  
            NamedXContentRegistry.EMPTY,  
            "Failure must be a CircuitBreakingException, got: " + caughtFailure.get().getClass().getName(),
import org.opensearch.indices.breaker.HierarchyCircuitBreakerService;
        assertNotNull("Expected a failure when rendered bytes exceed breaker limit", caughtFailure.get());
        assertEquals("Breaker fully released", 0L, breakerService.getBreaker(CircuitBreaker.IN_FLIGHT_REQUESTS).getUsed());
    /**  
import org.opensearch.action.search.SearchResponse;
        MultiSearchTemplateRequest request = buildRequest(3, 100);
        multiSearchListener.get().onFailure(new RuntimeException("simulated transport error"));
        valid.requests().forEach(request::add);  
     */
            .put(HierarchyCircuitBreakerService.IN_FLIGHT_REQUESTS_CIRCUIT_BREAKER_LIMIT_SETTING.getKey(), limitBytes + "b")
            SearchTemplateRequest templateRequest = new SearchTemplateRequest();  
        TaskManager tm = mock(TaskManager.class);
        // Set limit large enough for a 1x raw pre-charge but not for the actual 1x rendered
        Settings settings = Settings.builder().put(TransportMultiSearchTemplateAction.MAX_TEMPLATE_BATCH_SIZE_SETTING.getKey(), 3).build();
        tmpl.setScriptParams(Collections.singletonMap("field", "x".repeat(300)));  
        // Capture the multiSearch listener so we can simulate a response.  
        NodeClient client = mock(NodeClient.class);
    // ---------------------------------------------------------------------------
            7,  
            return null;
        action.doExecute(mock(Task.class), request, ActionListener.wrap(r -> {}, caughtFailure::set));  
 * compatible open source license.
            0L,
            multiSearchListener.set(inv.getArgument(1));
        when(ts.getTaskManager()).thenReturn(tm);  
        );
        assertTrue(
     */
        CircuitBreakerService breakerService = circuitBreakerServiceWithLimit(limitBytes);  
    /** Build a {@link TransportService} mock that returns a no-op {@link TaskManager}. */
    // ---------------------------------------------------------------------------
        );
     */
     * must be propagated to the inner {@link MultiSearchRequest} sent to the client.
    /**  
     */
        multiSearchListener.get().onResponse(new MultiSearchResponse(items, 1L));
        AtomicReference<MultiSearchRequest> capturedMultiSearch = new AtomicReference<>();
        );
        AtomicReference<Exception> caughtFailure = new AtomicReference<>();
        AtomicReference<Exception> caughtFailure = new AtomicReference<>();
 * <p>Validates that the rendered-source byte footprint of an {@code _msearch/template} batch is
        assertNotNull("Response should be returned even when some templates failed", caughtResponse.get());
        NodeClient client = mock(NodeClient.class);
import org.opensearch.common.settings.Settings;
     * must still be released via the failure-path {@code finally} block.
        MultiSearchTemplateRequest request = new MultiSearchTemplateRequest();
            return null;
    public void testMaxConcurrentSearchRequestsPropagated() {
        // A batch of 5 should now be rejected with the new limit of 2.
    // ---------------------------------------------------------------------------
     * {@code storedFieldCount} stored-field names, making the rendered size predictably large
        // significant expansion. We simulate it with a template whose param-expanded output  
import java.util.ArrayList;
            listener.onResponse(new MultiSearchResponse(items, 1L));
     * without the fix, rendering 7,000 large inline templates exhausted the coordinator
    // Test 9: successful sub-response path — item.isFailure() == false  
        // Simulate downstream transport failure.  
        // renders to ~309 bytes vs raw ~38 bytes (>4×38=152), guaranteeing delta > 0.
        // After the render loop, multiSearch has been called; breaker should be charged.  
     * rendering occurs. This is the primary OOM guard.  
    /**
    }
            if (j > 0) fields.append(',');  
    // Test 4: hard count-limit guard rejects batch before any rendering  
            templateRequest.setRequest(new SearchRequest());
            "Breaker bytes must be fully released after CircuitBreakingException",
        );
        assertNull("No failure expected for successful sub-response", caughtFailure.get());  
            return null;
    /**  
        }).when(client).multiSearch(any(MultiSearchRequest.class), any(ActionListener.class));  
        // Template 0: invalid script — convert() will throw when parsing rendered output.  
        assertEquals(
        SearchTemplateRequest tmpl = new SearchTemplateRequest();  
import org.opensearch.action.search.SearchRequest;  
            return null;
        assertNotNull("multiSearch should be dispatched for valid templates", multiSearchListener.get());
    /**
 * The OpenSearch Contributors require contributions made to  
        AtomicReference<MultiSearchTemplateResponse> caughtResponse = new AtomicReference<>();
        TransportMultiSearchTemplateAction action = buildAction(breakerService, client);
            multiSearchListener.set(inv.getArgument(1));
        SearchResponse searchResponse = mock(SearchResponse.class);
        assertTrue(  
            "Breaker bytes must be fully released after multiSearch failure",
        // 5 templates > limit of 3  
        AtomicReference<MultiSearchTemplateResponse> caughtResponse = new AtomicReference<>();  
            breakerService.getBreaker(CircuitBreaker.IN_FLIGHT_REQUESTS).getUsed()
     * Verifies the success path inside the multiSearch response handler: when a sub-response
     */  
        // + parsed bytes. We force delta > 0 by setting the initial EMA multiplier to 1.0
        );
    // Test 5: dynamic count-limit setting update is respected immediately  
     */
    }  
        AtomicReference<Exception> caughtFailure = new AtomicReference<>();  
        // Pre-charge at EMA=4.0 → 240 B, actual ≈ 160 B → delta < 0 (normal case).  
        AtomicReference<ActionListener<MultiSearchResponse>> multiSearchListener = new AtomicReference<>();
        assertNotNull("Expected failure when batch exceeds count limit", caughtFailure.get());
        MultiSearchTemplateRequest request = new MultiSearchTemplateRequest();
            mockTransportService(),  
        return multiRequest;
/**
    // ---------------------------------------------------------------------------  
        AtomicReference<ActionListener<MultiSearchResponse>> multiSearchListener = new AtomicReference<>();
        assertNotNull(multiSearchListener.get());
    // Test 7: delta > 0 — actual footprint exceeds initial EMA estimate  
        }
     * succeed normally. After the response is delivered the breaker must report zero used
import org.opensearch.action.support.ActionFilters;
            .put(HierarchyCircuitBreakerService.USE_REAL_MEMORY_USAGE_SETTING.getKey(), false)  
import org.opensearch.script.ScriptService;
    @SuppressWarnings("unchecked")
        action.doExecute(mock(Task.class), request, ActionListener.wrap(caughtResponse::set, caughtFailure::set));  
        // Breaker must be at zero — count guard fires before any CB charges.  
    /**
        contexts.put(TemplateScript.CONTEXT.name, TemplateScript.CONTEXT);
        assertSame(  
        doAnswer(inv -> {
        assertNull("No response expected when count limit is exceeded", caughtResponse.get());
     * A small batch whose cumulative rendered bytes fit within the breaker limit must  
    private static ScriptService mustacheScriptService() {
    /**
        assertTrue(caughtFailure.get().getMessage().contains("search.max_multi_search_template_requests"));
            breakerService.getBreaker(CircuitBreaker.IN_FLIGHT_REQUESTS).getUsed()
        // Craft a template that expands beyond 4× its raw script size without needing
        assertNotNull("multiSearch listener should have been captured after doExecute", multiSearchListener.get());
        assertFalse("Sub-response item must not be a failure", caughtResponse.get().getResponses()[0].isFailure());
        TransportMultiSearchTemplateAction action = buildAction(breakerService, client);
        MultiSearchTemplateRequest multiRequest = new MultiSearchTemplateRequest();
        assertEquals(
        assertTrue(caughtFailure.get() instanceof IllegalArgumentException);
            multiSearchListener.set(inv.getArgument(1));  
        MultiSearchTemplateRequest request = buildRequest(2, 100);  
     * is successful (not a failure), {@code setResponse} is called on the corresponding item
 */
     * A batch that exceeds {@code search.max_multi_search_template_requests} must be
            settings,  
            caughtResponse.get().getResponses()[0].getResponse().getResponse()  
    // ---------------------------------------------------------------------------
            fields.append("\"f").append(j).append('"');
     * Each template renders to a static JSON body with a padding string large enough
import org.opensearch.transport.client.node.NodeClient;  
        MultiSearchResponse.Item[] items = new MultiSearchResponse.Item[2];
        StringBuilder fields = new StringBuilder("[");
        ClusterSettings clusterSettings = new ClusterSettings(  
            "maxConcurrentSearchRequests must be propagated to inner MultiSearchRequest",
            caughtFailure.get().getMessage().contains("search.max_multi_search_template_requests")  
        // Build a request with 3 templates: first is invalid JSON (will fail convert()), rest are valid.
     */  
        action.doExecute(mock(Task.class), request, ActionListener.wrap(caughtResponse::set, caughtFailure::set));
     * The {@code search.max_multi_search_template_requests} setting is dynamic. A batch that
        SearchTemplateRequest bad = new SearchTemplateRequest();
    }  
        assertNull("Expected no successful response when breaker should trip", caughtResponse.get());
        );
        //
    private static TransportMultiSearchTemplateAction buildAction(CircuitBreakerService breakerService, NodeClient client) {
     * aborting the whole batch. Breaker bytes are released normally at the end.  
            0L,  
        long limitBytes = 10 * 1024 * 1024L;
        assertEquals(
    // ---------------------------------------------------------------------------  
    // Test 3: breaker bytes are released even when multiSearch itself fails  
        MultiSearchTemplateRequest request = buildRequest(5, bytesPerTemplate);  
        assertNull("No failure expected for a small batch within limits", caughtFailure.get());
        }).when(client).multiSearch(any(MultiSearchRequest.class), any(ActionListener.class));
import org.opensearch.script.ScriptType;  
    // ---------------------------------------------------------------------------
            ActionListener<MultiSearchResponse> listener = inv.getArgument(1);
        MultiSearchTemplateRequest request = buildRequest(1, 5);
            client,
     */
        MultiSearchResponse.Item successItem = new MultiSearchResponse.Item(searchResponse, null);  
        TransportMultiSearchTemplateAction action = buildAction(breakerService, client);
            settings,
        }
        }).when(client).multiSearch(any(MultiSearchRequest.class), any(ActionListener.class));
        Map<String, ScriptContext<?>> contexts = new HashMap<>(ScriptModule.CORE_CONTEXTS);  
    }  
    // ---------------------------------------------------------------------------
            clusterSettings  
    private static CircuitBreakerService circuitBreakerServiceWithLimit(long limitBytes) {
    // ---------------------------------------------------------------------------
import org.opensearch.core.xcontent.NamedXContentRegistry;  
        long limitBytes = 10 * 1_024 * 1_024L;  
        AtomicReference<MultiSearchTemplateResponse> caughtResponse = new AtomicReference<>();  
        // Complete the multiSearch for the 2 valid slots.  
        }).when(client).multiSearch(any(MultiSearchRequest.class), any(ActionListener.class));  
    // ---------------------------------------------------------------------------
            items[i] = new MultiSearchResponse.Item(null, new RuntimeException("stub"));  
            NamedXContentRegistry.EMPTY,  
        tmpl.setScript("{\"size\":0,\"stored_fields\":[\"{{field}}\"]}");
    }
        MultiSearchResponse.Item[] items = { new MultiSearchResponse.Item(null, new RuntimeException("stub")) };
import org.opensearch.script.ScriptModule;
        for (int j = 0; j < storedFieldCount; j++) {
     * settings consumer registered in the constructor.  
 */  
            clusterSettings  
    // ---------------------------------------------------------------------------
        AtomicReference<Exception> caughtFailure = new AtomicReference<>();
import java.util.HashMap;
            client,
        // Respond with a successful (non-failure) item.
import org.opensearch.script.ScriptEngine;  
            caughtFailure.get() instanceof IllegalArgumentException
        return new TransportMultiSearchTemplateAction(
        );
            "Breaker bytes must be fully released after response is delivered",
        action.doExecute(mock(Task.class), request, ActionListener.wrap(caughtResponse::set, caughtFailure::set));
            "SearchResponse must be set on the item",
        MultiSearchResponse.Item[] items = new MultiSearchResponse.Item[3];
            breakerService.getBreaker(CircuitBreaker.IN_FLIGHT_REQUESTS).getUsed() > 0
        CircuitBreakerService breakerService = circuitBreakerServiceWithLimit(limitBytes);
        ClusterSettings clusterSettings = new ClusterSettings(
            templateRequest.setScript(source);  
import org.opensearch.script.ScriptContext;
    public void testDynamicCountLimitUpdate() {
        assertNotNull("Response must be returned", caughtResponse.get());
import org.opensearch.common.settings.ClusterSettings;  
import java.util.Set;  
    // ---------------------------------------------------------------------------
        long limitBytes = 1_024L;
import org.opensearch.test.OpenSearchTestCase;
        assertNotNull(caughtResponse.get());  
        doAnswer(inv -> {  
            items[i] = new MultiSearchResponse.Item(null, new RuntimeException("test stub"));
            capturedMultiSearch.set(inv.getArgument(0));
        assertNotNull(multiSearchListener.get());
        );
        request.add(bad);  
        // Build a JSON array of field names: ["f0","f1",...] — valid SearchSourceBuilder content.  
        bad.setScriptType(ScriptType.INLINE);
     * When an individual sub-request fails to convert (bad script syntax), the action must
    }
        Settings settings = Settings.builder().put(TransportMultiSearchTemplateAction.MAX_TEMPLATE_BATCH_SIZE_SETTING.getKey(), 10).build();  
        // Should have proceeded to multiSearch (no breaker trip on 1 template within 10 MB).
    // ---------------------------------------------------------------------------
        // a query-parser registry. A single stored_fields param injecting a 300-char value  
        NodeClient client = mock(NodeClient.class);  
import org.opensearch.transport.TransportService;
     */
        request.maxConcurrentSearchRequests(7);
        assertNotNull("Expected rejection after dynamic limit decrease", caughtFailure.get());  
        assertEquals(
        action.doExecute(mock(Task.class), request, ActionListener.wrap(r -> {}, e -> {}));
import java.util.Map;
        assertNull("No overall failure expected when only individual templates fail", caughtFailure.get());
    // Helpers  
    // ---------------------------------------------------------------------------
        doAnswer(inv -> {  
            mockTransportService(),  
        CircuitBreakerService breakerService = circuitBreakerServiceWithLimit(limitBytes);
            searchResponse,
            0L,  
     * so the test is deterministic.  
import static org.mockito.Mockito.mock;
    }  
        bad.setScript("{not valid json {{{{");  
import org.opensearch.core.action.ActionListener;
            mustacheScriptService(),
    @SuppressWarnings("unchecked")
        );
        assertNotNull("Failure listener should have been called", caughtFailure.get());  
     * mirrors the PoC payload shape: each template requests many stored fields.
        for (int i = 0; i < items.length; i++) {  
        String source = "{\"size\":0,\"stored_fields\":" + fields + "}";
        NodeClient client = mock(NodeClient.class);
        ClusterSettings clusterSettings = new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
/*  
     * and the overall response is returned correctly.  
        MultiSearchTemplateRequest valid = buildRequest(2, 5);
        }).when(client).multiSearch(any(MultiSearchRequest.class), any(ActionListener.class));
     */  
import static org.mockito.ArgumentMatchers.any;  
import java.util.concurrent.atomic.AtomicReference;
     * breaker limit pinned to {@code limitBytes} and real-memory tracking disabled
            new ActionFilters(Collections.emptySet()),
        for (int i = 0; i < items.length; i++) {
            templateRequest.setScriptType(ScriptType.INLINE);
        doAnswer(inv -> {
        multiSearchListener.get().onResponse(new MultiSearchResponse(items, 1L));  
            multiSearchListener.set(inv.getArgument(1));
        AtomicReference<MultiSearchTemplateResponse> caughtResponse = new AtomicReference<>();
            settings,
        assertEquals("Breaker must be fully released", 0L, breakerService.getBreaker(CircuitBreaker.IN_FLIGHT_REQUESTS).getUsed());
        // multiSearch should be called with only the 2 valid requests.  
        );
    // ---------------------------------------------------------------------------  
        AtomicReference<MultiSearchTemplateResponse> caughtResponse = new AtomicReference<>();
            multiSearchListener.set(inv.getArgument(1));  
     * the batch must fail with {@link CircuitBreakingException} and all bytes released.  
            breakerService.getBreaker(CircuitBreaker.IN_FLIGHT_REQUESTS).getUsed()  
     * rejected immediately with an {@link IllegalArgumentException}, before any Mustache
        // Limit = 10 MB; 3 templates × ~100 B each is well within limit.  
        // To trigger delta > 0 we need actual > estimated. This happens when params cause
        return ts;
 * this file be licensed under the Apache-2.0 license or a
    public void testPositiveDeltaChargedWhenActualExceedsEstimate() {  
        AtomicReference<Exception> caughtFailure = new AtomicReference<>();  
            "Failure must be IllegalArgumentException, got: " + caughtFailure.get().getClass().getName(),
        AtomicReference<Exception> caughtFailure = new AtomicReference<>();
    // Test 6: individual template convert() failure — batch continues, breaker released  
 * charged against the {@link CircuitBreaker#IN_FLIGHT_REQUESTS} breaker, preventing OOM when the  
     * When a template renders to a size larger than the initial EMA pre-charge estimate,
     * that the rendered size is at least {@code bytesPerTemplate} bytes.
            capturedMultiSearch.get().maxConcurrentSearchRequests()
    public void testBreakerReleasedOnSuccessfulResponse() {
    public void testBreakerReleasedOnMultiSearchFailure() {
        // All charged bytes must be released after the failure path.
        NodeClient client = mock(NodeClient.class);  
        bad.setScriptParams(Collections.emptyMap());
import org.opensearch.tasks.TaskManager;  
            "Breaker should hold the rendered source bytes while the request is in-flight",  
            settings,
            "Breaker must be untouched when count limit rejects the request",
    }  
        }).when(client).multiSearch(any(MultiSearchRequest.class), any(ActionListener.class));  
import org.opensearch.script.TemplateScript;
        Settings settings = Settings.builder()  
     * {@link CircuitBreakingException} rather than causing an OOM error.
        assertEquals("Breaker fully released after response", 0L, breakerService.getBreaker(CircuitBreaker.IN_FLIGHT_REQUESTS).getUsed());
    }  
        TransportService ts = mock(TransportService.class);
     * record the per-item error and continue processing remaining templates rather than
            mock(NodeClient.class),
        //
        AtomicReference<ActionListener<MultiSearchResponse>> multiSearchListener = new AtomicReference<>();
            breakerService,
 * Unit tests for circuit breaker accounting in {@link TransportMultiSearchTemplateAction}.  
    /**  
            mustacheScriptService(),
        );  
        assertEquals(  
            .put(HierarchyCircuitBreakerService.IN_FLIGHT_REQUESTS_CIRCUIT_BREAKER_OVERHEAD_SETTING.getKey(), 1.0)
     * Each template renders to a valid {@code SearchSourceBuilder} JSON body with  
        doAnswer(inv -> {
     * Build a {@link MultiSearchTemplateRequest} with {@code n} inline Mustache templates.
    /**
import static org.mockito.Mockito.when;  
     */  
 * SPDX-License-Identifier: Apache-2.0
     *  
        MultiSearchTemplateRequest request = buildRequest(5, 10);
        ClusterSettings clusterSettings = new ClusterSettings(
            new ActionFilters(Collections.emptySet()),
        Settings settings = Settings.EMPTY;
        // Templates 1-2: valid.
            caughtFailure.get() instanceof CircuitBreakingException
        action.doExecute(mock(Task.class), buildRequest(5, 10), ActionListener.wrap(r -> {}, caughtFailure::set));
    @SuppressWarnings("unchecked")
        TransportMultiSearchTemplateAction action = buildAction(breakerService, client);
    /**  
     */
import org.opensearch.action.search.MultiSearchRequest;
            "Error message should mention the limit",
     * Build a {@link HierarchyCircuitBreakerService} with the {@code IN_FLIGHT_REQUESTS}
    /**  
        assertNull("No failure expected within the limit", caughtFailure.get());
    }  
        AtomicReference<Exception> caughtFailure = new AtomicReference<>();
    // ---------------------------------------------------------------------------
            clusterSettings  
        );
     * was within the old limit must be rejected after the limit is lowered via the cluster
        action.doExecute(mock(Task.class), request, ActionListener.wrap(caughtResponse::set, caughtFailure::set));
        for (int i = 0; i < n; i++) {
import org.opensearch.action.search.MultiSearchResponse;
     * If the downstream {@code multiSearch} transport call fails, the charged breaker bytes
     * {@code IN_FLIGHT_REQUESTS} breaker limit must be rejected with a
        );  
    // ---------------------------------------------------------------------------
            multiRequest.add(templateRequest);  
    public void testCountLimitRejectsOversizedBatch() {
        NodeClient client = mock(NodeClient.class);
}
            settings,
        AtomicReference<Exception> caughtFailure = new AtomicReference<>();
import static org.mockito.Mockito.doAnswer;
        long limitBytes = 10 * 1_024 * 1_024L;
        // via a very tight breaker that accepts the raw pre-charge but trips on the extra.  
        tmpl.setScriptType(ScriptType.INLINE);
        );
        AtomicReference<MultiSearchTemplateResponse> caughtResponse = new AtomicReference<>();
    }  
            breakerService,
        bad.setRequest(new SearchRequest());
    public void testSuccessfulSubResponsePopulatesItem() {  
            mockTransportService(),  
        CircuitBreakerService breakerService = circuitBreakerServiceWithLimit(10 * 1024 * 1024L);
        tmpl.setRequest(new SearchRequest());
        multiSearchListener.get().onResponse(new MultiSearchResponse(new MultiSearchResponse.Item[] { successItem }, 5L));
        action.doExecute(mock(Task.class), request, ActionListener.wrap(caughtResponse::set, caughtFailure::set));  
    // ---------------------------------------------------------------------------
    // Test 8: maxConcurrentSearchRequests propagation to inner MultiSearchRequest
    @SuppressWarnings("unchecked")
        assertNotNull("multiSearch should be called for an expanding template within limit", multiSearchListener.get());  
        Map<String, ScriptEngine> engines = Collections.singletonMap(MustacheScriptEngine.NAME, new MustacheScriptEngine());
import org.opensearch.core.common.breaker.CircuitBreaker;  
        // Template: 10 stored fields → raw ~60 B, rendered ~80 B, parsed serialised ~80 B
            Set.of(TransportMultiSearchTemplateAction.MAX_TEMPLATE_BATCH_SIZE_SETTING)
            .build();
        }
        CircuitBreakerService breakerService = circuitBreakerServiceWithLimit(10 * 1024 * 1024L);  
    @SuppressWarnings("unchecked")
import java.util.Collections;  
 *
            MultiSearchResponse.Item[] items = { new MultiSearchResponse.Item(null, new RuntimeException("stub")) };  
            new ActionFilters(Collections.emptySet()),
    private static MultiSearchTemplateRequest buildRequest(int n, int storedFieldCount) {
     * When the incoming request specifies {@code maxConcurrentSearchRequests}, that value  
    /**  
        assertNotNull("multiSearch should have been called", capturedMultiSearch.get());  
 *
     * <p>This directly tests the OOM fix:
import org.opensearch.tasks.Task;
        CircuitBreakerService breakerService = circuitBreakerServiceWithLimit(10 * 1024 * 1024L);
     * A batch whose cumulative rendered source bytes exceed the configured  
     * bytes — all charged bytes released in the {@code finally} block.
        fields.append(']');  
            Settings.builder().put(TransportMultiSearchTemplateAction.MAX_TEMPLATE_BATCH_SIZE_SETTING.getKey(), 2).build()
     * heap. With the fix the breaker fires after the first template that tips the limit.  
    // ---------------------------------------------------------------------------
        AtomicReference<ActionListener<MultiSearchResponse>> multiSearchListener = new AtomicReference<>();  
import org.opensearch.core.common.breaker.CircuitBreakingException;
     */  
    // Test 2: small batch succeeds and breaker bytes are released on completion
        multiSearchListener.get().onResponse(new MultiSearchResponse(items, 1L));  
            templateRequest.setScriptParams(Collections.emptyMap());
        CircuitBreakerService breakerService = circuitBreakerServiceWithLimit(limitBytes);
        // Limit = 1 KB; each template renders to ~2 KB → breaker must trip after ~1 item.  
            return null;
        return new HierarchyCircuitBreakerService(settings, new ArrayList<>(), clusterSettings);  
    /**  
    }  
        );  
            breakerService.getBreaker(CircuitBreaker.IN_FLIGHT_REQUESTS).getUsed()
        TransportMultiSearchTemplateAction action = buildAction(breakerService, client);
        TransportMultiSearchTemplateAction action = buildAction(breakerService, client);  
    public void testCircuitBreakerTripsBeforeOOM() {
            Set.of(TransportMultiSearchTemplateAction.MAX_TEMPLATE_BATCH_SIZE_SETTING)
            mustacheScriptService(),
    }
     * Merges {@code TemplateScript.CONTEXT} into {@link ScriptModule#CORE_CONTEXTS}.
        );  
        return new ScriptService(Settings.builder().put("script.allowed_types", "inline").build(), engines, contexts);
        assertTrue(  
    }
        TransportMultiSearchTemplateAction action = new TransportMultiSearchTemplateAction(
        CircuitBreakerService breakerService = circuitBreakerServiceWithLimit(10 * 1024 * 1024L);
        int bytesPerTemplate = 2_048;
    private static TransportService mockTransportService() {  
public class TransportMultiSearchTemplateActionTests extends OpenSearchTestCase {  
package org.opensearch.script.mustache;
    // ---------------------------------------------------------------------------
        clusterSettings.applySettings(
            NamedXContentRegistry.EMPTY,  
        // is larger than 4× the raw script — use a param that injects a long string.
        long limitBytes = 10 * 1024 * 1024L;
        );
        assertNotNull("Expected a successful response for a small batch", caughtResponse.get());  
        TransportMultiSearchTemplateAction action = new TransportMultiSearchTemplateAction(
        // Set a very small limit (3) and send 5 templates.  
    public void testIndividualTemplateConvertFailureContinuesBatch() {  
        assertEquals("Response should have 3 slots (including the failed one)", 3, caughtResponse.get().getResponses().length);  
            return null;  
     * Create a minimal {@link ScriptService} backed by the {@link MustacheScriptEngine}.
            // Pure static Mustache source — rendered verbatim, so rendered size is deterministic.
        // Simulate multiSearch returning with (error) stub items — we only care about breaker release.
        NodeClient client = mock(NodeClient.class);  
    @SuppressWarnings("unchecked")  
        doAnswer(inv -> {  
        TransportMultiSearchTemplateAction action = buildAction(breakerService, mock(NodeClient.class));
            settings,
            breakerService,
        assertTrue(
        action.doExecute(mock(Task.class), request, ActionListener.wrap(caughtResponse::set, caughtFailure::set));
     * the positive delta must be charged to the breaker. If that extra charge causes a trip,
        }
 * rendered batch exceeds the configured limit.
            0L,  
        assertNotNull("Slot 0 should record the convert() failure", caughtResponse.get().getResponses()[0].getFailure());
