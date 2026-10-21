    }
            caughtResponse.get().getResponses()[0].getResponse().getResponse()
        assertTrue(
        // Template: 10 stored fields → raw ~60 B, rendered ~80 B, parsed serialised ~80 B
    private static CircuitBreakerService circuitBreakerServiceWithLimit(long limitBytes) {
            "Breaker should hold the rendered source bytes while the request is in-flight",
    }
     */
        );
        assertNotNull("Failure listener should have been called", caughtFailure.get());
        // multiSearch should be called with only the 2 valid requests.
        assertNull("No failure expected for a small batch within limits", caughtFailure.get());
        }).when(client).multiSearch(any(MultiSearchRequest.class), any(ActionListener.class));
        Map<String, ScriptEngine> engines = Collections.singletonMap(MustacheScriptEngine.NAME, new MustacheScriptEngine());
        // Templates 1-2: valid.
        assertSame(
     * heap. With the fix the breaker fires after the first template that tips the limit.
        assertNotNull(multiSearchListener.get());
            settings,
     * {@code IN_FLIGHT_REQUESTS} breaker limit must be rejected with a
            return null;
        assertNotNull("multiSearch should be called for an expanding template within limit", multiSearchListener.get());
    public void testBreakerReleasedOnMultiSearchFailure() {
     * Build a {@link MultiSearchTemplateRequest} with {@code n} inline Mustache templates.
            multiSearchListener.set(inv.getArgument(1));
        }).when(client).multiSearch(any(MultiSearchRequest.class), any(ActionListener.class));
    /**
    // Test 4: hard count-limit guard rejects batch before any rendering
     * must still be released via the failure-path {@code finally} block.
        for (int i = 0; i < items.length; i++) {
            .put(HierarchyCircuitBreakerService.IN_FLIGHT_REQUESTS_CIRCUIT_BREAKER_OVERHEAD_SETTING.getKey(), 1.0)
    public void testMaxConcurrentSearchRequestsPropagated() {
            .put(HierarchyCircuitBreakerService.IN_FLIGHT_REQUESTS_CIRCUIT_BREAKER_LIMIT_SETTING.getKey(), limitBytes + "b")
        tmpl.setRequest(new SearchRequest());
        doAnswer(inv -> {
    }
import org.opensearch.core.common.breaker.CircuitBreakingException;
     * was within the old limit must be rejected after the limit is lowered via the cluster
import org.opensearch.action.search.SearchResponse;
    @SuppressWarnings("unchecked")
        action.doExecute(mock(Task.class), buildRequest(5, 10), ActionListener.wrap(r -> {}, caughtFailure::set));
            clusterSettings
     * {@link CircuitBreakingException} rather than causing an OOM error.
        AtomicReference<MultiSearchTemplateResponse> caughtResponse = new AtomicReference<>();
import static org.mockito.ArgumentMatchers.any;
        assertNull("No failure expected for successful sub-response", caughtFailure.get());
    // ---------------------------------------------------------------------------
    private static MultiSearchTemplateRequest buildRequest(int n, int storedFieldCount) {
            breakerService.getBreaker(CircuitBreaker.IN_FLIGHT_REQUESTS).getUsed()
        Map<String, ScriptContext<?>> contexts = new HashMap<>(ScriptModule.CORE_CONTEXTS);
    // ---------------------------------------------------------------------------
     * and the overall response is returned correctly.
        // is larger than 4× the raw script — use a param that injects a long string.
        tmpl.setScriptParams(Collections.singletonMap("field", "x".repeat(300)));
        return multiRequest;
            breakerService,
        }
            Settings.builder().put(TransportMultiSearchTemplateAction.MAX_TEMPLATE_BATCH_SIZE_SETTING.getKey(), 2).build()
        );
     * settings consumer registered in the constructor.
import org.opensearch.common.settings.Settings;
    public void testDynamicCountLimitUpdate() {
    public void testCircuitBreakerTripsBeforeOOM() {
        TransportMultiSearchTemplateAction action = buildAction(breakerService, client);
        AtomicReference<Exception> caughtFailure = new AtomicReference<>();
            0L,
     * Each template renders to a valid {@code SearchSourceBuilder} JSON body with
        MultiSearchTemplateRequest request = new MultiSearchTemplateRequest();
     * record the per-item error and continue processing remaining templates rather than
     * Build a {@link MultiSearchTemplateRequest} with {@code n} inline Mustache templates.
            breakerService,
            "Breaker must be untouched when count limit rejects the request",
            clusterSettings
            caughtFailure.get() instanceof CircuitBreakingException
     * A small batch whose cumulative rendered bytes fit within the breaker limit must
        long limitBytes = 10 * 1024 * 1024L;
        valid.requests().forEach(request::add);
        long limitBytes = 10 * 1_024 * 1_024L;
            multiSearchListener.set(inv.getArgument(1));
        );
        action.doExecute(mock(Task.class), request, ActionListener.wrap(caughtResponse::set, caughtFailure::set));
     */
    }
        AtomicReference<MultiSearchTemplateResponse> caughtResponse = new AtomicReference<>();
    @SuppressWarnings("unchecked")
        //
        assertNotNull("multiSearch listener should have been captured after doExecute", multiSearchListener.get());
    }
        assertEquals("Response should have 3 slots (including the failed one)", 3, caughtResponse.get().getResponses().length);
            new ActionFilters(Collections.emptySet()),
        assertTrue(caughtFailure.get().getMessage().contains("search.max_multi_search_template_requests"));
        NodeClient client = mock(NodeClient.class);
import org.opensearch.script.ScriptService;
     * succeed normally. After the response is delivered the breaker must report zero used
        TransportService ts = mock(TransportService.class);
            items[i] = new MultiSearchResponse.Item(null, new RuntimeException("stub"));
            "Failure must be a CircuitBreakingException, got: " + caughtFailure.get().getClass().getName(),
        multiSearchListener.get().onResponse(new MultiSearchResponse(items, 1L));
    // ---------------------------------------------------------------------------
            caughtFailure.get() instanceof IllegalArgumentException
import org.opensearch.script.ScriptType;
        CircuitBreakerService breakerService = circuitBreakerServiceWithLimit(10 * 1024 * 1024L);
        assertNotNull(caughtResponse.get());
            client,
            settings,
    }
     */
        // Limit = 10 MB; 3 templates × ~100 B each is well within limit.
            MultiSearchResponse.Item[] items = { new MultiSearchResponse.Item(null, new RuntimeException("stub")) };
import org.opensearch.script.ScriptEngine;
        assertEquals(
            if (j > 0) fields.append(',');
    @SuppressWarnings("unchecked")
     */
        SearchTemplateRequest tmpl = new SearchTemplateRequest();
        }
        action.doExecute(mock(Task.class), request, ActionListener.wrap(caughtResponse::set, caughtFailure::set));
import org.opensearch.script.ScriptModule;
            templateRequest.setRequest(new SearchRequest());
        // Lower limit to 2 via dynamic update.
        for (int i = 0; i < items.length; i++) {
        CircuitBreakerService breakerService = circuitBreakerServiceWithLimit(10 * 1024 * 1024L);
            mock(NodeClient.class),
    // Test 3: breaker bytes are released even when multiSearch itself fails
import org.opensearch.action.search.MultiSearchResponse;
        long limitBytes = 10 * 1024 * 1024L;
            7,
        fields.append(']');
        TransportMultiSearchTemplateAction action = buildAction(breakerService, client);
        AtomicReference<MultiSearchTemplateResponse> caughtResponse = new AtomicReference<>();
        AtomicReference<ActionListener<MultiSearchResponse>> multiSearchListener = new AtomicReference<>();
        );
     * When the incoming request specifies {@code maxConcurrentSearchRequests}, that value
        assertNotNull("Response should be returned even when some templates failed", caughtResponse.get());
            items[i] = new MultiSearchResponse.Item(null, new RuntimeException("test stub"));
     * A batch that exceeds {@code search.max_multi_search_template_requests} must be
     */
            "Breaker bytes must be fully released after CircuitBreakingException",
            breakerService.getBreaker(CircuitBreaker.IN_FLIGHT_REQUESTS).getUsed()
        );
        TransportMultiSearchTemplateAction action = buildAction(breakerService, mock(NodeClient.class));
        }).when(client).multiSearch(any(MultiSearchRequest.class), any(ActionListener.class));
import org.opensearch.transport.TransportService;
        doAnswer(inv -> {
 *
            NamedXContentRegistry.EMPTY,
        assertEquals(
        for (int j = 0; j < storedFieldCount; j++) {
        // Set limit large enough for a 1x raw pre-charge but not for the actual 1x rendered
    // Test 1: circuit breaker trips instead of OOM for an oversized batch
        request.add(tmpl);
        assertTrue(
            0L,
     */
import java.util.Map;
    private static TransportService mockTransportService() {
import static org.mockito.Mockito.when;
        // 5 templates > limit of 3
        NodeClient client = mock(NodeClient.class);
        // Simulate downstream transport failure.
    public void testPositiveDeltaChargedWhenActualExceedsEstimate() {
        );
    }
     * Each template renders to a static JSON body with a padding string large enough
            multiSearchListener.set(inv.getArgument(1));
        bad.setScript("{not valid json {{{{");
            return null;
     */
        doAnswer(inv -> {
            multiSearchListener.set(inv.getArgument(1));
        // + parsed bytes. We force delta > 0 by setting the initial EMA multiplier to 1.0
        MultiSearchResponse.Item[] items = new MultiSearchResponse.Item[3];
            NamedXContentRegistry.EMPTY,
        action.doExecute(mock(Task.class), request, ActionListener.wrap(r -> {}, caughtFailure::set));
            breakerService.getBreaker(CircuitBreaker.IN_FLIGHT_REQUESTS).getUsed()
     * that the rendered size is at least {@code bytesPerTemplate} bytes.
        MultiSearchTemplateRequest request = new MultiSearchTemplateRequest();
     * Merges {@code TemplateScript.CONTEXT} into {@link ScriptModule#CORE_CONTEXTS}.
        MultiSearchTemplateRequest request = buildRequest(2, 100);
            mustacheScriptService(),
            0L,
import java.util.Set;
     * rejected immediately with an {@link IllegalArgumentException}, before any Mustache
        multiSearchListener.get().onResponse(new MultiSearchResponse(items, 1L));
    @SuppressWarnings("unchecked")
        // Breaker must be at zero — count guard fires before any CB charges.
        assertNull("No overall failure expected when only individual templates fail", caughtFailure.get());
        CircuitBreakerService breakerService = circuitBreakerServiceWithLimit(limitBytes);
        // renders to ~309 bytes vs raw ~38 bytes (>4×38=152), guaranteeing delta > 0.
            settings,
        // After the render loop, multiSearch has been called; breaker should be charged.
        MultiSearchResponse.Item successItem = new MultiSearchResponse.Item(searchResponse, null);
    /**
    // Helpers
        action.doExecute(mock(Task.class), request, ActionListener.wrap(caughtResponse::set, caughtFailure::set));
        AtomicReference<MultiSearchTemplateResponse> caughtResponse = new AtomicReference<>();
        tmpl.setScript("{\"size\":0,\"stored_fields\":[\"{{field}}\"]}");
        long limitBytes = 10 * 1_024 * 1_024L;
        assertFalse("Sub-response item must not be a failure", caughtResponse.get().getResponses()[0].isFailure());
            multiRequest.add(templateRequest);
    }
        NodeClient client = mock(NodeClient.class);
            return null;
    }
     * {@code storedFieldCount} stored-field names, making the rendered size predictably large
    // ---------------------------------------------------------------------------
        assertEquals("Breaker fully released", 0L, breakerService.getBreaker(CircuitBreaker.IN_FLIGHT_REQUESTS).getUsed());
import org.opensearch.core.action.ActionListener;
            Set.of(TransportMultiSearchTemplateAction.MAX_TEMPLATE_BATCH_SIZE_SETTING)
    }
            settings,
import org.opensearch.test.OpenSearchTestCase;
        AtomicReference<Exception> caughtFailure = new AtomicReference<>();
        SearchTemplateRequest bad = new SearchTemplateRequest();
            searchResponse,
        CircuitBreakerService breakerService = circuitBreakerServiceWithLimit(limitBytes);
        assertTrue(
        // Limit = 1 KB; each template renders to ~2 KB → breaker must trip after ~1 item.
            capturedMultiSearch.set(inv.getArgument(0));
 * Unit tests for circuit breaker accounting in {@link TransportMultiSearchTemplateAction}.
        return new HierarchyCircuitBreakerService(settings, new ArrayList<>(), clusterSettings);
        CircuitBreakerService breakerService = circuitBreakerServiceWithLimit(10 * 1024 * 1024L);
    // Test 2: small batch succeeds and breaker bytes are released on completion
            settings,
    private static ScriptService mustacheScriptService() {
import org.opensearch.script.ScriptContext;
        );
            return null;
    // ---------------------------------------------------------------------------
        assertNotNull("Expected a successful response for a small batch", caughtResponse.get());
    public void testSuccessfulSubResponsePopulatesItem() {
     */
    // Test 6: individual template convert() failure — batch continues, breaker released
        AtomicReference<Exception> caughtFailure = new AtomicReference<>();
 */
        AtomicReference<MultiSearchTemplateResponse> caughtResponse = new AtomicReference<>();
        AtomicReference<Exception> caughtFailure = new AtomicReference<>();
     * When an individual sub-request fails to convert (bad script syntax), the action must
        assertNotNull("multiSearch should have been called", capturedMultiSearch.get());
        TransportMultiSearchTemplateAction action = buildAction(breakerService, client);
        assertNotNull("Response must be returned", caughtResponse.get());
        request.maxConcurrentSearchRequests(7);
        AtomicReference<MultiSearchTemplateResponse> caughtResponse = new AtomicReference<>();
        AtomicReference<Exception> caughtFailure = new AtomicReference<>();
        );
            breakerService,
        return ts;
    /**
    @SuppressWarnings("unchecked")
        assertEquals(
    }
    // ---------------------------------------------------------------------------
        MultiSearchTemplateRequest request = buildRequest(1, 5);
    /**
     * A batch whose cumulative rendered source bytes exceed the configured
        // All charged bytes must be released after the failure path.
     * If the downstream {@code multiSearch} transport call fails, the charged breaker bytes
        bad.setRequest(new SearchRequest());
import org.opensearch.core.xcontent.NamedXContentRegistry;
        ClusterSettings clusterSettings = new ClusterSettings(
            fields.append("\"f").append(j).append('"');
        assertTrue(caughtFailure.get() instanceof IllegalArgumentException);
    /**
        }).when(client).multiSearch(any(MultiSearchRequest.class), any(ActionListener.class));
     * rendering occurs. This is the primary OOM guard.
            caughtFailure.get().getMessage().contains("search.max_multi_search_template_requests")
        );
        SearchResponse searchResponse = mock(SearchResponse.class);
import org.opensearch.transport.client.node.NodeClient;
            // Pure static Mustache source — rendered verbatim, so rendered size is deterministic.
        bad.setScriptParams(Collections.emptyMap());
    // ---------------------------------------------------------------------------
        // Craft a template that expands beyond 4× its raw script size without needing
 * charged against the {@link CircuitBreaker#IN_FLIGHT_REQUESTS} breaker, preventing OOM when the
            mustacheScriptService(),
import java.util.HashMap;
        }
            breakerService.getBreaker(CircuitBreaker.IN_FLIGHT_REQUESTS).getUsed() > 0
    // Test 5: dynamic count-limit setting update is respected immediately
import org.opensearch.action.search.SearchRequest;
        MultiSearchTemplateRequest request = buildRequest(3, 100);
        CircuitBreakerService breakerService = circuitBreakerServiceWithLimit(limitBytes);
    // ---------------------------------------------------------------------------
    // Test 8: maxConcurrentSearchRequests propagation to inner MultiSearchRequest
    }
    // ---------------------------------------------------------------------------
    /** Build a {@link TransportService} mock that returns a no-op {@link TaskManager}. */
    // ---------------------------------------------------------------------------
        assertNotNull("Slot 0 should record the convert() failure", caughtResponse.get().getResponses()[0].getFailure());
        // via a very tight breaker that accepts the raw pre-charge but trips on the extra.
        action.doExecute(mock(Task.class), request, ActionListener.wrap(caughtResponse::set, caughtFailure::set));
        return new TransportMultiSearchTemplateAction(
        NodeClient client = mock(NodeClient.class);
        );
        AtomicReference<ActionListener<MultiSearchResponse>> multiSearchListener = new AtomicReference<>();
        TaskManager tm = mock(TaskManager.class);
     * must be propagated to the inner {@link MultiSearchRequest} sent to the client.
        String source = "{\"size\":0,\"stored_fields\":" + fields + "}";
        );
 * rendered batch exceeds the configured limit.
        assertNull("Expected no successful response when breaker should trip", caughtResponse.get());
    /**
        NodeClient client = mock(NodeClient.class);
        AtomicReference<ActionListener<MultiSearchResponse>> multiSearchListener = new AtomicReference<>();
        AtomicReference<ActionListener<MultiSearchResponse>> multiSearchListener = new AtomicReference<>();
        // To trigger delta > 0 we need actual > estimated. This happens when params cause
        assertEquals("Breaker fully released after response", 0L, breakerService.getBreaker(CircuitBreaker.IN_FLIGHT_REQUESTS).getUsed());
        );
        tmpl.setScriptType(ScriptType.INLINE);
 * SPDX-License-Identifier: Apache-2.0
    /**
            templateRequest.setScriptType(ScriptType.INLINE);
        assertNotNull("Expected failure when batch exceeds count limit", caughtFailure.get());
package org.opensearch.script.mustache;
        action.doExecute(mock(Task.class), request, ActionListener.wrap(caughtResponse::set, caughtFailure::set));
        clusterSettings.applySettings(
     */
            breakerService.getBreaker(CircuitBreaker.IN_FLIGHT_REQUESTS).getUsed()
        assertNull("No failure expected within the limit", caughtFailure.get());
        MultiSearchTemplateRequest multiRequest = new MultiSearchTemplateRequest();
import org.opensearch.tasks.TaskManager;
        multiSearchListener.get().onResponse(new MultiSearchResponse(items, 1L));
            return null;
        Settings settings = Settings.EMPTY;
        Settings settings = Settings.builder()
    // ---------------------------------------------------------------------------
        MultiSearchTemplateRequest request = buildRequest(1, 5);
    /**
            new ActionFilters(Collections.emptySet()),
import org.opensearch.tasks.Task;
        assertNotNull("multiSearch should be dispatched for valid templates", multiSearchListener.get());
            templateRequest.setScript(source);
    // ---------------------------------------------------------------------------
     *
            mockTransportService(),
        // Build a JSON array of field names: ["f0","f1",...] — valid SearchSourceBuilder content.
        AtomicReference<Exception> caughtFailure = new AtomicReference<>();
            listener.onResponse(new MultiSearchResponse(items, 1L));
            "maxConcurrentSearchRequests must be propagated to inner MultiSearchRequest",
import org.opensearch.action.search.MultiSearchRequest;
import org.opensearch.common.settings.ClusterSettings;
        doAnswer(inv -> {
    // ---------------------------------------------------------------------------
 * compatible open source license.
        NodeClient client = mock(NodeClient.class);
        AtomicReference<ActionListener<MultiSearchResponse>> multiSearchListener = new AtomicReference<>();
     */
            0L,
        assertNotNull("Expected rejection after dynamic limit decrease", caughtFailure.get());
    // ---------------------------------------------------------------------------
import static org.mockito.Mockito.doAnswer;
        action.doExecute(mock(Task.class), request, ActionListener.wrap(r -> {}, e -> {}));
            .put(HierarchyCircuitBreakerService.USE_REAL_MEMORY_USAGE_SETTING.getKey(), false)
    // Test 7: delta > 0 — actual footprint exceeds initial EMA estimate
        StringBuilder fields = new StringBuilder("[");
        TransportMultiSearchTemplateAction action = new TransportMultiSearchTemplateAction(
        ClusterSettings clusterSettings = new ClusterSettings(
            client,
            "Failure must be IllegalArgumentException, got: " + caughtFailure.get().getClass().getName(),
        action.doExecute(mock(Task.class), request, ActionListener.wrap(caughtResponse::set, caughtFailure::set));
        when(ts.getTaskManager()).thenReturn(tm);
    public void testIndividualTemplateConvertFailureContinuesBatch() {
        for (int i = 0; i < n; i++) {
     * mirrors the PoC payload shape: each template requests many stored fields.
     * without the fix, rendering 7,000 large inline templates exhausted the coordinator
    }
    public void testBreakerReleasedOnSuccessfulResponse() {
/*
        // Capture the multiSearch listener so we can simulate a response.
/**
        assertEquals(
            return null;
     * so the test is deterministic.
        // Respond with a successful (non-failure) item.
import org.opensearch.indices.breaker.HierarchyCircuitBreakerService;
        doAnswer(inv -> {
    // ---------------------------------------------------------------------------
        );
        MultiSearchTemplateRequest valid = buildRequest(2, 5);
            mockTransportService(),
import java.util.concurrent.atomic.AtomicReference;
        contexts.put(TemplateScript.CONTEXT.name, TemplateScript.CONTEXT);
import org.opensearch.core.indices.breaker.CircuitBreakerService;
        Settings settings = Settings.builder().put(TransportMultiSearchTemplateAction.MAX_TEMPLATE_BATCH_SIZE_SETTING.getKey(), 3).build();
    private static TransportMultiSearchTemplateAction buildAction(CircuitBreakerService breakerService, NodeClient client) {
        multiSearchListener.get().onFailure(new RuntimeException("simulated transport error"));
 */
        // Simulate multiSearch returning with (error) stub items — we only care about breaker release.
        Settings settings = Settings.builder().put(TransportMultiSearchTemplateAction.MAX_TEMPLATE_BATCH_SIZE_SETTING.getKey(), 10).build();
}
     * bytes — all charged bytes released in the {@code finally} block.
            capturedMultiSearch.get().maxConcurrentSearchRequests()
     * When a template renders to a size larger than the initial EMA pre-charge estimate,
     */
        TransportMultiSearchTemplateAction action = buildAction(breakerService, client);
import org.opensearch.script.TemplateScript;
     * <p>This directly tests the OOM fix:
     * is successful (not a failure), {@code setResponse} is called on the corresponding item
        TransportMultiSearchTemplateAction action = buildAction(breakerService, client);
            mustacheScriptService(),
        CircuitBreakerService breakerService = circuitBreakerServiceWithLimit(limitBytes);
        assertNotNull("Expected a failure when rendered bytes exceed breaker limit", caughtFailure.get());
        // Template 0: invalid script — convert() will throw when parsing rendered output.
        ClusterSettings clusterSettings = new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
        // significant expansion. We simulate it with a template whose param-expanded output
        CircuitBreakerService breakerService = circuitBreakerServiceWithLimit(10 * 1024 * 1024L);
        int bytesPerTemplate = 2_048;
 * <p>Validates that the rendered-source byte footprint of an {@code _msearch/template} batch is
        MultiSearchResponse.Item[] items = { new MultiSearchResponse.Item(null, new RuntimeException("stub")) };
            "Error message should mention the limit",
        // A batch of 5 should now be rejected with the new limit of 2.
        return new ScriptService(Settings.builder().put("script.allowed_types", "inline").build(), engines, contexts);
    // ---------------------------------------------------------------------------
    /**
     * Build a {@link HierarchyCircuitBreakerService} with the {@code IN_FLIGHT_REQUESTS}
            mockTransportService(),
     * aborting the whole batch. Breaker bytes are released normally at the end.
     * the batch must fail with {@link CircuitBreakingException} and all bytes released.
        MultiSearchTemplateRequest request = buildRequest(5, 10);
            templateRequest.setScriptParams(Collections.emptyMap());
        AtomicReference<Exception> caughtFailure = new AtomicReference<>();
        NodeClient client = mock(NodeClient.class);
        doAnswer(inv -> {
        // a query-parser registry. A single stored_fields param injecting a 300-char value
import org.opensearch.action.support.ActionFilters;
        );
        );
            multiSearchListener.set(inv.getArgument(1));
     * The {@code search.max_multi_search_template_requests} setting is dynamic. A batch that
import org.opensearch.core.common.breaker.CircuitBreaker;
     * Create a minimal {@link ScriptService} backed by the {@link MustacheScriptEngine}.
        );
import java.util.ArrayList;
        TransportMultiSearchTemplateAction action = buildAction(breakerService, client);
        MultiSearchTemplateRequest request = buildRequest(5, bytesPerTemplate);
import java.util.Collections;
    /**
 * this file be licensed under the Apache-2.0 license or a
 * The OpenSearch Contributors require contributions made to
            SearchTemplateRequest templateRequest = new SearchTemplateRequest();
        AtomicReference<Exception> caughtFailure = new AtomicReference<>();
    /**
            clusterSettings
        }).when(client).multiSearch(any(MultiSearchRequest.class), any(ActionListener.class));
     * breaker limit pinned to {@code limitBytes} and real-memory tracking disabled
     */
    }
        // Should have proceeded to multiSearch (no breaker trip on 1 template within 10 MB).
        assertEquals("Breaker must be fully released", 0L, breakerService.getBreaker(CircuitBreaker.IN_FLIGHT_REQUESTS).getUsed());
     * Verifies the success path inside the multiSearch response handler: when a sub-response
        request.add(bad);
        //
            settings,
            Set.of(TransportMultiSearchTemplateAction.MAX_TEMPLATE_BATCH_SIZE_SETTING)
import static org.mockito.Mockito.mock;
        bad.setScriptType(ScriptType.INLINE);
        CircuitBreakerService breakerService = circuitBreakerServiceWithLimit(limitBytes);
        // Complete the multiSearch for the 2 valid slots.
            "Breaker bytes must be fully released after multiSearch failure",
    public void testCountLimitRejectsOversizedBatch() {
            .build();
            Set.of(TransportMultiSearchTemplateAction.MAX_TEMPLATE_BATCH_SIZE_SETTING)
        AtomicReference<MultiSearchRequest> capturedMultiSearch = new AtomicReference<>();
        long limitBytes = 1_024L;
        // Set a very small limit (3) and send 5 templates.
    // ---------------------------------------------------------------------------
            new ActionFilters(Collections.emptySet()),
    // Test 9: successful sub-response path — item.isFailure() == false
        assertNull("No response expected when count limit is exceeded", caughtResponse.get());
     * the positive delta must be charged to the breaker. If that extra charge causes a trip,
        ClusterSettings clusterSettings = new ClusterSettings(
        }
        assertNotNull(multiSearchListener.get());
        // Pre-charge at EMA=4.0 → 240 B, actual ≈ 160 B → delta < 0 (normal case).
            NamedXContentRegistry.EMPTY,
        multiSearchListener.get().onResponse(new MultiSearchResponse(new MultiSearchResponse.Item[] { successItem }, 5L));
public class TransportMultiSearchTemplateActionTests extends OpenSearchTestCase {
            "SearchResponse must be set on the item",
    @SuppressWarnings("unchecked")
            ActionListener<MultiSearchResponse> listener = inv.getArgument(1);
        TransportMultiSearchTemplateAction action = new TransportMultiSearchTemplateAction(
     */
        // Build a request with 3 templates: first is invalid JSON (will fail convert()), rest are valid.
    // ---------------------------------------------------------------------------
        );
    // ---------------------------------------------------------------------------
        }).when(client).multiSearch(any(MultiSearchRequest.class), any(ActionListener.class));
        assertTrue(
    // ---------------------------------------------------------------------------
        MultiSearchResponse.Item[] items = new MultiSearchResponse.Item[2];
    /**
        assertEquals(
 *
            "Breaker bytes must be fully released after response is delivered",
    /**
