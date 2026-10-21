        AtomicBoolean proceeded = new AtomicBoolean(false);
    }
        assertThat(captured.get(), org.hamcrest.Matchers.instanceOf(OpenSearchRejectedExecutionException.class));
            clusterSettings(s),
        ActionConcurrencyLimiterRegistry registry = limitedRegistry("search", SEARCH_ACTION, 1);
        );
            noopListener(),
            .put(ConcurrencyLimitSettings.SETTING_PREFIX + alias + ".warmup_duration", "0s")
            null,
import org.opensearch.common.settings.Setting;
        assertEquals(1, registry.getStats().getSnapshots().get(0).getInFlight());
                new SearchRequest(),
            s,
            );
    private static final Task TASK = null;
            }
        );
        ActionConcurrencyLimiterRegistry registry = registryFor("search", SEARCH_ACTION, "enforced");
        filter.apply(
import org.opensearch.core.action.ActionResponse;
    private static <Resp extends ActionResponse> ActionListener<Resp> noopListener() {
import org.opensearch.test.OpenSearchTestCase;
        Settings s = Settings.builder()
            .build();
            fail("should have propagated the exception");
            .put(ConcurrencyLimitSettings.SETTING_PREFIX + alias + ".limit.max", limit)
            new SearchRequest(),
import org.opensearch.core.concurrency.OpenSearchRejectedExecutionException;
                throwingListener,
        ActionConcurrencyLimitFilter filter = new ActionConcurrencyLimitFilter(registry);
            .put(ConcurrencyLimitSettings.SETTING_PREFIX + alias + ".mode", mode)
                (ActionFilterChain<SearchRequest, SearchResponse>) (t, a, req, listener) -> listener.onResponse(mock(SearchResponse.class))
}
            SEARCH_ACTION,
 * SPDX-License-Identifier: Apache-2.0
        );
            s,
 * this file be licensed under the Apache-2.0 license or a
    public void testTokenReleasedExactlyOnceWhenListenerThrows() {
    private static ActionConcurrencyLimiterRegistry registryFor(String alias, String actionName, String mode) {
    }
        assertNotNull(captured.get());
    }
        assertEquals(0, registry.getStats().getSnapshots().get(0).getInFlight());
        return new ActionConcurrencyLimiterRegistry(
        filter.apply(TASK, SEARCH_ACTION, new SearchRequest(), null, noopListener(), passThroughChain(new AtomicBoolean()));
        // Use a downstream listener that throws after the filter's wrapped listener releases the token.
            .put(ConcurrencyLimitSettings.SETTING_PREFIX + alias + ".action_name", actionName)
import static org.mockito.Mockito.mock;
        // fill the one slot
        AtomicBoolean proceeded
            TASK,
 *
 */
        return new ActionConcurrencyLimiterRegistry(
 * The OpenSearch Contributors require contributions made to
    private static <Req extends ActionRequest, Resp extends ActionResponse> ActionFilterChain<Req, Resp> neverProceedChain() {
        };
            @Override
        // Without the AtomicBoolean guard, the outer catch would call onIgnore() a second time,
    }
            new org.opensearch.common.util.concurrent.ThreadContext(org.opensearch.common.settings.Settings.EMPTY)
/*
        ActionConcurrencyLimiterRegistry registry = registryFor("search", SEARCH_ACTION, "enforced");
public class ActionConcurrencyLimitFilterTests extends OpenSearchTestCase {
        filter.apply(
    @SuppressWarnings("unchecked")
        assertEquals(1, new ActionConcurrencyLimitFilter(registry).order());
            public void onFailure(Exception e) {}
        try {
    }
        ActionConcurrencyLimiterRegistry registry = registryFor("search", SEARCH_ACTION, "disabled");
            TASK,
import org.opensearch.action.search.SearchRequest;
        return new ClusterSettings(settings, all);
            @Override
import org.opensearch.action.ActionRequest;
    private static ClusterSettings clusterSettings(Settings settings) {
        // next should be rejected
        ActionConcurrencyLimiterRegistry registry = registryFor("search", SEARCH_ACTION, "enforced");
        filter.apply(TASK, SEARCH_ACTION, new SearchRequest(), null, noopListener(), passThroughChain(proceeded));
            null,
            (ActionFilterChain<SearchRequest, SearchResponse>) (t, a, req, listener) -> wrappedRef.set(listener)
    @SuppressWarnings("unchecked")
        ActionConcurrencyLimiterRegistry registry = limitedRegistry("search", SEARCH_ACTION, 1);
        return ActionListener.wrap(r -> {}, e -> {});
        AtomicBoolean proceeded = new AtomicBoolean(false);
    // -------------------------------------------------------------------------
import org.opensearch.common.settings.Settings;
import java.util.Set;
            .put(ConcurrencyLimitSettings.SETTING_PREFIX + alias + ".warmup_duration", "0s")
        ActionConcurrencyLimiterRegistry registry = registryFor("search", SEARCH_ACTION, "enforced");
        AtomicReference<ActionListener<SearchResponse>> wrappedRef = new AtomicReference<>();
        filter.apply(TASK, SEARCH_ACTION, new SearchRequest(), null, noopListener(), passThroughChain(new AtomicBoolean()));
    }
import java.util.concurrent.atomic.AtomicBoolean;
package org.opensearch.concurrency;
        Settings s = Settings.builder()
        );
import java.util.concurrent.atomic.AtomicReference;
    ) {
import org.opensearch.tasks.Task;
        assertEquals(0, registry.getStats().getSnapshots().get(0).getInFlight());
        AtomicReference<Exception> captured = new AtomicReference<>();
            noopListener(),
        wrappedRef.get().onFailure(new RuntimeException("error"));
import java.util.HashSet;
    }
            SEARCH_ACTION,
        }
    // -------------------------------------------------------------------------
        assertEquals("token must be released exactly once", 0, registry.getStats().getSnapshots().get(0).getInFlight());
            filter.apply(
        ActionConcurrencyLimitFilter filter = new ActionConcurrencyLimitFilter(registry);
        } catch (RuntimeException e) {
        return ActionListener.wrap(r -> {}, ref::set);
        RuntimeException listenerBoom = new RuntimeException("downstream listener exploded");
    public void testRejectsWhenLimitFull() {
        AtomicReference<ActionListener<SearchResponse>> wrappedRef = new AtomicReference<>();
            .build();
    }
    @SuppressWarnings("unchecked")
    }
                TASK,
    public void testPassesThroughUnlimitedAction() {
    public void testSuccessReleasesSlot() {
import org.opensearch.core.action.ActionListener;
    }
import org.opensearch.action.support.ActionFilterChain;
    @SuppressWarnings("unchecked")
        filter.apply(TASK, OTHER_ACTION, new SearchRequest(), null, noopListener(), passThroughChain(proceeded));
        ActionConcurrencyLimitFilter filter = new ActionConcurrencyLimitFilter(registry);
        ActionConcurrencyLimitFilter filter = new ActionConcurrencyLimitFilter(registry);
            (ActionFilterChain<SearchRequest, SearchResponse>) (t, a, req, listener) -> wrappedRef.set(listener)
        // inFlight should be 0, not -1 (which would happen on double release)
        ActionConcurrencyLimitFilter filter = new ActionConcurrencyLimitFilter(registry);
import org.opensearch.action.search.SearchResponse;
    private static final String SEARCH_ACTION = "indices:data/read/search";
import org.opensearch.common.settings.ClusterSettings;
    public void testFailureReleasesSlot() {
        assertEquals(1L, registry.getStats().getSnapshots().get(0).getTotalRejected());
        ActionListener<SearchResponse> throwingListener = new ActionListener<SearchResponse>() {
    public void testPassesThroughWhenWithinLimit() {
        ActionConcurrencyLimiterRegistry registry = registryFor("search", SEARCH_ACTION, "enforced");
            .put(ConcurrencyLimitSettings.SETTING_PREFIX + alias + ".limit.initial", limit)
        return (task, action, request, listener) -> fail("chain.proceed should not have been called");
    private static <Req extends ActionRequest, Resp extends ActionResponse> ActionFilterChain<Req, Resp> passThroughChain(
    private static <Resp extends ActionResponse> ActionListener<Resp> capturingFailureListener(AtomicReference<Exception> ref) {
        // double-decrementing inFlight.
        assertTrue("should pass through unconfigured action", proceeded.get());
            new SearchRequest(),
        filter.apply(TASK, SEARCH_ACTION, new SearchRequest(), null, capturingFailureListener(captured), neverProceedChain());
            .put(ConcurrencyLimitSettings.SETTING_PREFIX + alias + ".mode", "enforced")
        ActionConcurrencyLimitFilter filter = new ActionConcurrencyLimitFilter(registry);
                null,
            clusterSettings(s),
    }
        // chain.proceed calls onResponse immediately, which triggers the throwing listener
    }
 * compatible open source license.
        wrappedRef.get().onResponse(mock(SearchResponse.class));
    }
        ActionConcurrencyLimitFilter filter = new ActionConcurrencyLimitFilter(registry);
    public void testRejectIncrementsTotalRejected() {
        Set<Setting<?>> all = new HashSet<>(ConcurrencyLimitSettings.ALL_SETTINGS);
        filter.apply(TASK, SEARCH_ACTION, new SearchRequest(), null, noopListener(), neverProceedChain());
    private static ActionConcurrencyLimiterRegistry limitedRegistry(String alias, String actionName, int limit) {
    }
    public void testOrderIsOne() {
    private static final String OTHER_ACTION = "indices:data/write/bulk";
            assertSame(listenerBoom, e);
        return (task, action, request, listener) -> proceeded.set(true);
            public void onResponse(SearchResponse response) {
            .put(ConcurrencyLimitSettings.SETTING_PREFIX + alias + ".action_name", actionName)
        assertTrue("should pass through when within limit", proceeded.get());
                throw listenerBoom;
                SEARCH_ACTION,
    // helpers
            new org.opensearch.common.util.concurrent.ThreadContext(org.opensearch.common.settings.Settings.EMPTY)
    }
