        ActionConcurrencyLimiterRegistry registry = registryFor("search", SEARCH_ACTION, "enforced");
    public void testPassesThroughUnlimitedAction() {  
        ActionConcurrencyLimiterRegistry registry = registryFor("search", SEARCH_ACTION, "enforced");  
    public void testPassesThroughWhenWithinLimit() {
    private static <Req extends ActionRequest, Resp extends ActionResponse> ActionFilterChain<Req, Resp> neverProceedChain() {  
import org.opensearch.core.action.ActionResponse;  
                TASK,
public class ActionConcurrencyLimitFilterTests extends OpenSearchTestCase {  
        return new ActionConcurrencyLimiterRegistry(
        filter.apply(  
        assertEquals(1, registry.getStats().getSnapshots().get(0).getInFlight());  
            new org.opensearch.common.util.concurrent.ThreadContext(org.opensearch.common.settings.Settings.EMPTY)
            assertSame(listenerBoom, e);
            .put(ConcurrencyLimitSettings.SETTING_PREFIX + alias + ".limit.max", limit)
    public void testTokenReleasedExactlyOnceWhenListenerThrows() {
        Set<Setting<?>> all = new HashSet<>(ConcurrencyLimitSettings.ALL_SETTINGS);
    }  
        );
        AtomicBoolean proceeded = new AtomicBoolean(false);
        wrappedRef.get().onResponse(mock(SearchResponse.class));
import org.opensearch.common.settings.Settings;
            null,
                new SearchRequest(),  
            null,
        assertTrue("should pass through unconfigured action", proceeded.get());
            (ActionFilterChain<SearchRequest, SearchResponse>) (t, a, req, listener) -> wrappedRef.set(listener)  
        assertEquals(0, registry.getStats().getSnapshots().get(0).getInFlight());
    }  
            public void onResponse(SearchResponse response) {
    private static <Req extends ActionRequest, Resp extends ActionResponse> ActionFilterChain<Req, Resp> passThroughChain(
            public void onFailure(Exception e) {}
        ActionConcurrencyLimiterRegistry registry = registryFor("search", SEARCH_ACTION, "disabled");  
 * SPDX-License-Identifier: Apache-2.0
    private static ActionConcurrencyLimiterRegistry limitedRegistry(String alias, String actionName, int limit) {  
                throw listenerBoom;  
        ActionConcurrencyLimitFilter filter = new ActionConcurrencyLimitFilter(registry);  
        assertThat(captured.get(), org.hamcrest.Matchers.instanceOf(OpenSearchRejectedExecutionException.class));  
    @SuppressWarnings("unchecked")
        filter.apply(
            s,  
        assertNotNull(captured.get());
        try {
    }  
    public void testOrderIsOne() {
            .build();
        return new ClusterSettings(settings, all);
            TASK,
    private static final Task TASK = null;
        // next should be rejected
import org.opensearch.action.search.SearchResponse;  
        ActionConcurrencyLimitFilter filter = new ActionConcurrencyLimitFilter(registry);
import org.opensearch.tasks.Task;
    }
            .put(ConcurrencyLimitSettings.SETTING_PREFIX + alias + ".action_name", actionName)
                (ActionFilterChain<SearchRequest, SearchResponse>) (t, a, req, listener) -> listener.onResponse(mock(SearchResponse.class))  
 */  
        ActionConcurrencyLimiterRegistry registry = registryFor("search", SEARCH_ACTION, "enforced");
import org.opensearch.action.search.SearchRequest;
    public void testRejectsWhenLimitFull() {
        wrappedRef.get().onFailure(new RuntimeException("error"));
            .put(ConcurrencyLimitSettings.SETTING_PREFIX + alias + ".warmup_duration", "0s")  
            noopListener(),
            clusterSettings(s),
        // chain.proceed calls onResponse immediately, which triggers the throwing listener
            s,  
}  
        assertEquals(0, registry.getStats().getSnapshots().get(0).getInFlight());
        }
    public void testRejectIncrementsTotalRejected() {  
        ActionListener<SearchResponse> throwingListener = new ActionListener<SearchResponse>() {  
        assertTrue("should pass through when within limit", proceeded.get());
import org.opensearch.common.settings.ClusterSettings;
        AtomicBoolean proceeded = new AtomicBoolean(false);  
    // -------------------------------------------------------------------------
        filter.apply(TASK, SEARCH_ACTION, new SearchRequest(), null, noopListener(), neverProceedChain());
            }
        // inFlight should be 0, not -1 (which would happen on double release)
import org.opensearch.action.support.ActionFilterChain;
    }
import java.util.HashSet;
        return (task, action, request, listener) -> proceeded.set(true);
            .put(ConcurrencyLimitSettings.SETTING_PREFIX + alias + ".mode", "enforced")  
    }
            (ActionFilterChain<SearchRequest, SearchResponse>) (t, a, req, listener) -> wrappedRef.set(listener)
        } catch (RuntimeException e) {  
            new org.opensearch.common.util.concurrent.ThreadContext(org.opensearch.common.settings.Settings.EMPTY)
            @Override
 * this file be licensed under the Apache-2.0 license or a
    }  
        ActionConcurrencyLimitFilter filter = new ActionConcurrencyLimitFilter(registry);  
        return (task, action, request, listener) -> fail("chain.proceed should not have been called");
 * compatible open source license.
    ) {
            .put(ConcurrencyLimitSettings.SETTING_PREFIX + alias + ".action_name", actionName)
        return ActionListener.wrap(r -> {}, e -> {});
        assertEquals(1, new ActionConcurrencyLimitFilter(registry).order());
    public void testSuccessReleasesSlot() {
            filter.apply(  
            .put(ConcurrencyLimitSettings.SETTING_PREFIX + alias + ".warmup_duration", "0s")  
        filter.apply(TASK, SEARCH_ACTION, new SearchRequest(), null, noopListener(), passThroughChain(new AtomicBoolean()));  
        ActionConcurrencyLimitFilter filter = new ActionConcurrencyLimitFilter(registry);  
        filter.apply(TASK, OTHER_ACTION, new SearchRequest(), null, noopListener(), passThroughChain(proceeded));
        ActionConcurrencyLimiterRegistry registry = registryFor("search", SEARCH_ACTION, "enforced");  
    private static ClusterSettings clusterSettings(Settings settings) {  
        filter.apply(TASK, SEARCH_ACTION, new SearchRequest(), null, capturingFailureListener(captured), neverProceedChain());
    }  
import org.opensearch.test.OpenSearchTestCase;  
package org.opensearch.concurrency;
    @SuppressWarnings("unchecked")
    // helpers  
import org.opensearch.core.concurrency.OpenSearchRejectedExecutionException;
        // Use a downstream listener that throws after the filter's wrapped listener releases the token.
        assertEquals("token must be released exactly once", 0, registry.getStats().getSnapshots().get(0).getInFlight());
        AtomicReference<Exception> captured = new AtomicReference<>();  
    // -------------------------------------------------------------------------
    private static final String SEARCH_ACTION = "indices:data/read/search";  
 *
        filter.apply(TASK, SEARCH_ACTION, new SearchRequest(), null, noopListener(), passThroughChain(proceeded));  
            new SearchRequest(),  
        // Without the AtomicBoolean guard, the outer catch would call onIgnore() a second time,  
            .build();
        // double-decrementing inFlight.
            @Override  
            );
import org.opensearch.common.settings.Setting;  
        AtomicReference<ActionListener<SearchResponse>> wrappedRef = new AtomicReference<>();
        );  
        ActionConcurrencyLimiterRegistry registry = limitedRegistry("search", SEARCH_ACTION, 1);
                SEARCH_ACTION,
            fail("should have propagated the exception");
    private static final String OTHER_ACTION = "indices:data/write/bulk";
        assertEquals(1L, registry.getStats().getSnapshots().get(0).getTotalRejected());
        ActionConcurrencyLimitFilter filter = new ActionConcurrencyLimitFilter(registry);
            .put(ConcurrencyLimitSettings.SETTING_PREFIX + alias + ".mode", mode)
    }
        );  
                null,
            noopListener(),  
        Settings s = Settings.builder()  
            SEARCH_ACTION,  
    public void testFailureReleasesSlot() {
import java.util.Set;  
        return ActionListener.wrap(r -> {}, ref::set);
        ActionConcurrencyLimitFilter filter = new ActionConcurrencyLimitFilter(registry);
    @SuppressWarnings("unchecked")
        };
    }  
    private static <Resp extends ActionResponse> ActionListener<Resp> capturingFailureListener(AtomicReference<Exception> ref) {  
import org.opensearch.action.ActionRequest;
        AtomicReference<ActionListener<SearchResponse>> wrappedRef = new AtomicReference<>();
    }
    private static <Resp extends ActionResponse> ActionListener<Resp> noopListener() {
import java.util.concurrent.atomic.AtomicBoolean;
/*  
                throwingListener,
    @SuppressWarnings("unchecked")  
            clusterSettings(s),
import org.opensearch.core.action.ActionListener;
            SEARCH_ACTION,
    }  
            .put(ConcurrencyLimitSettings.SETTING_PREFIX + alias + ".limit.initial", limit)
        filter.apply(TASK, SEARCH_ACTION, new SearchRequest(), null, noopListener(), passThroughChain(new AtomicBoolean()));
    }
        // fill the one slot
        AtomicBoolean proceeded  
 * The OpenSearch Contributors require contributions made to  
        Settings s = Settings.builder()
        RuntimeException listenerBoom = new RuntimeException("downstream listener exploded");
    }
import java.util.concurrent.atomic.AtomicReference;
        );
            new SearchRequest(),
        return new ActionConcurrencyLimiterRegistry(
        ActionConcurrencyLimitFilter filter = new ActionConcurrencyLimitFilter(registry);
import static org.mockito.Mockito.mock;
            TASK,
        ActionConcurrencyLimiterRegistry registry = registryFor("search", SEARCH_ACTION, "enforced");
        ActionConcurrencyLimiterRegistry registry = limitedRegistry("search", SEARCH_ACTION, 1);
    private static ActionConcurrencyLimiterRegistry registryFor(String alias, String actionName, String mode) {
    }
