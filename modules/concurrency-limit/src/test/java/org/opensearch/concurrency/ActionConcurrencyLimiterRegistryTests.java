    public void testNoLimiterPassesThrough() {  
        Settings initial = enabled("search", "indices:data/read/search");
    // -------------------------------------------------------------------------
import java.util.ArrayList;
        cs.applySettings(  
        assertTrue("during warmup, second acquire should return NOOP not empty", second.isAcquired());
            )
                    .put(ConcurrencyLimitSettings.SETTING_PREFIX + "search.partition.premium.percent", 0.7)  
            "warmup should not restart on limit change — should still reject",
    public void testPartitionedLimiterBuildsAndAcquires() {  
        ClusterSettings cs = clusterSettings(initial);  
        // reconfigure an active alias (mode change) → re-fire onActive so tags can refresh
        ClusterSettings cs = clusterSettings(initial);  
        Settings s = partitionedBase().put(ConcurrencyLimitSettings.SETTING_PREFIX + "search.partition.premium.percent", 0.6)
        // acquire and release a token so the limiter has a non-zero limit snapshot  
        assertEquals(activeCountBefore + 1, listener.active.size());
        );
        newRegistry(initial, cs);  
                .putList(ConcurrencyLimitSettings.SETTING_PREFIX + "search.partitions", "premium", "standard")
                .put(ConcurrencyLimitSettings.SETTING_PREFIX + "search.partition.standard.percent", 0.3)
            .put(ConcurrencyLimitSettings.SETTING_PREFIX + "search.action_name", "indices:data/read/search")  
        ActionConcurrencyLimiterRegistry registry = newRegistry(initial, cs);
        registry.tryAcquire("indices:data/read/search", null, null);
    }
        registry.tryAcquire("indices:data/read/search", null, null); // fill slot
import org.opensearch.common.util.concurrent.ThreadContext;
    private static Settings.Builder partitionedBase() {
    // -------------------------------------------------------------------------
        Settings initial = enabled("search", "indices:data/read/search");  
            IllegalArgumentException.class,
        assertTrue("limit should be > 0 while enabled", registry.getStats().getSnapshots().get(0).getCurrentLimit() > 0);
            .put(ConcurrencyLimitSettings.SETTING_PREFIX + "bulk.action_name", "indices:data/write/bulk")
        ActionConcurrencyLimiterRegistry registry = newRegistry(s, clusterSettings(s));
        RecordingMetricsListener listener = new RecordingMetricsListener();
                    .put(ConcurrencyLimitSettings.SETTING_PREFIX + "search.partition.premium.percent", 0.5)
        assertTrue(e.getMessage(), e.getMessage().contains("must be in [0.0, 1.0]"));
        // Change algorithm — this is a successful reconfigure, listener should fire
        IllegalArgumentException e = expectThrows(  
        cs.applySettings(Settings.builder().put(ConcurrencyLimitSettings.SETTING_PREFIX + "search.mode", "disabled").build());
    // multiple independent actions  
                .put(ConcurrencyLimitSettings.SETTING_PREFIX + "search.vegas.baseline_reset_load_threshold", 0.8)
                    .putList(ConcurrencyLimitSettings.SETTING_PREFIX + "search.partitions", "premium")
    // -------------------------------------------------------------------------
            Settings.builder()
            .build();  
        // now even at limit, requests pass through
        ClusterSettings cs = clusterSettings(s);  
        );  
        assertFalse("second acquire should be rejected at limit=1", second.isAcquired());  
        ActionConcurrencyLimiterRegistry registry = newRegistry(initial, cs);
        assertTrue(t1.isAcquired());
        assertFalse("should reject in enforced mode", registry.tryAcquire("indices:data/read/search", null, null).isAcquired());  
        assertTrue(e.getMessage(), e.getMessage().contains("<= 1.0"));
        RecordingMetricsListener listener = new RecordingMetricsListener();
        IllegalArgumentException e = expectThrows(  
        return Settings.builder()
        IllegalArgumentException e = expectThrows(
        cs.applySettings(Settings.builder().put(ConcurrencyLimitSettings.SETTING_PREFIX + "search.gradient2.rtt_tolerance", 2.0).build());  
import org.opensearch.action.ActionConcurrencyLimiterStats;
        ClusterSettings cs = clusterSettings(initial);
    }  
                .build()
    public void testModeTransitionEnforcedToMonitorOnly() {
        assertFalse(registry.hasLimiterFor("indices:data/read/search"));
import java.util.HashSet;
        Settings initial = enabled("search", "indices:data/read/search");
        // fill slot and verify rejection while enforced
        RecordingMetricsListener listener = new RecordingMetricsListener();  
            () -> cs.applySettings(
        newRegistry(initial, cs);
        AcquireResult token = registry.tryAcquire("indices:data/read/search", null, null);
import org.opensearch.common.settings.Setting;
        AcquireResult first = registry.tryAcquire("indices:data/read/search", null, null);
        assertTrue(registry.hasLimiterFor("indices:data/read/search"));  
        ClusterSettings cs = clusterSettings(initial);
                .put(ConcurrencyLimitSettings.SETTING_PREFIX + "search.partition.resolver", "bySearchType")
            .put(ConcurrencyLimitSettings.SETTING_PREFIX + "search.limit.initial", 1)  
        newRegistry(initial, cs);
        );
        ClusterSettings cs = clusterSettings(initial);
                    .putList(ConcurrencyLimitSettings.SETTING_PREFIX + "search.partitions", "premium")  
    // setting validation
            IllegalArgumentException.class,  
        );
    public void testSetMetricsListenerReplaysActiveAliases() {  
    }
        ClusterSettings cs = clusterSettings(initial);  
        );  
    public void testListenerRefiresOnReconfigure() {
        cs.applySettings(
            .put(ConcurrencyLimitSettings.SETTING_PREFIX + "search.action_name", "indices:data/read/search")
            () -> cs.applySettings(Settings.builder().put(ConcurrencyLimitSettings.SETTING_PREFIX + "search.limit.initial", 0).build())  
                .put(ConcurrencyLimitSettings.SETTING_PREFIX + "search.limit.max", 2)
        newRegistry(initial, cs);
    }
            .put(ConcurrencyLimitSettings.SETTING_PREFIX + "search.limit.max", 1)
            .put(ConcurrencyLimitSettings.SETTING_PREFIX + "search.mode", "monitor_only")
        // enable dynamically
    public void testInvalidAimdBackoffRatioRejected() {  
        token.token().onSuccess();  
        ClusterSettings cs = clusterSettings(s);
        // even at limit, monitor_only never rejects  
        assertFalse("should reject after warmup expired", registry.tryAcquire("indices:data/read/search", null, null).isAcquired());  
                    .put(ConcurrencyLimitSettings.SETTING_PREFIX + "search.partition.premium.percent", 0.5)
            .put(ConcurrencyLimitSettings.SETTING_PREFIX + "search.action_name", "indices:data/read/search")  
            .put(ConcurrencyLimitSettings.SETTING_PREFIX + "search.warmup_duration", "0s")
            .put(ConcurrencyLimitSettings.SETTING_PREFIX + "search.warmup_duration", "0s")
            .put(ConcurrencyLimitSettings.SETTING_PREFIX + "search.mode", "disabled")
        Settings initial = enabled("search", "indices:data/read/search");
        Settings initial = enabled("search", "indices:data/read/search");
                    .put(ConcurrencyLimitSettings.SETTING_PREFIX + "search.partition.resolver.fixed.partition", "ghost")  
            .build();
        assertTrue(registry.hasLimiterFor("indices:data/read/search"));
                .putList(ConcurrencyLimitSettings.SETTING_PREFIX + "search.partitions", "filter", "aggregation")
        assertTrue("bySearchType partitioned limiter should grant a token", token.isAcquired());
            .put(ConcurrencyLimitSettings.SETTING_PREFIX + "search.warmup_duration", "0s")
        assertFalse("disabled alias removed from reverse map", registry.hasLimiterFor("indices:data/read/search"));  
            .putList(ConcurrencyLimitSettings.SETTING_PREFIX + "search.partitions", "premium", "standard", "default");  
import org.opensearch.action.ActionConcurrencyLimiterStats.ActionLimiterSnapshot;
        assertEquals(2, listener.active.size());
            .build();
        @Override  
    public void testMonitorOnlyNeverRejects() {
        AcquireResult searchToken = registry.tryAcquire("indices:data/read/search", null, null);  
/*  
        Settings s = Settings.builder()
            )  
                Settings.builder().put(ConcurrencyLimitSettings.SETTING_PREFIX + "search.aimd.backoff_ratio", 0.3).build()
        assertTrue(bulkToken.isAcquired());  
        assertTrue(first.isAcquired());
        assertTrue(e.getMessage(), e.getMessage().contains("Unknown partition resolver"));  
    }  
            .put(ConcurrencyLimitSettings.SETTING_PREFIX + "bulk.warmup_duration", "0s")
            .build();  
        AcquireResult second = registry.tryAcquire("indices:data/read/search", null, null);
        assertFalse(  
    // -------------------------------------------------------------------------
        ActionConcurrencyLimiterRegistry registry = newRegistry(s, clusterSettings(s));  
            .put(ConcurrencyLimitSettings.SETTING_PREFIX + "search.mode", "disabled")
    }  
        ClusterSettings cs = clusterSettings(initial);  
        token.token().onSuccess();  
        assertTrue(token.isAcquired());
        ActionConcurrencyLimiterRegistry registry = newRegistry(initial, cs);
        // switch to monitor_only
        assertTrue(rootCauseMessage(e), rootCauseMessage(e).contains("aimd.backoff_ratio must be in [0.5, 1.0)"));
            // mode defaults to "disabled"
        assertTrue(registry.hasLimiterFor("indices:data/read/search"));
            Settings.builder().put(ConcurrencyLimitSettings.SETTING_PREFIX + "search.action_name", "indices:data/read/msearch").build()  
        assertTrue("valid partitioned config should grant a token", token.isAcquired());
    }  
        assertTrue(token.isAcquired());  
            .build();
        assertTrue(registry.hasLimiterFor("indices:data/read/search"));
        ClusterSettings cs = clusterSettings(initial);
        assertTrue(registry.hasLimiterFor("indices:data/read/search"));  
                    .build()
        assertEquals("snapshot limit should be 0 after disable", 0, registry.getStats().getSnapshots().get(0).getCurrentLimit());
        assertEquals(1, listener.active.size());
    public void testClearingActionNameRemovesLimiterAndAllowsReactivation() {  
        ClusterSettings cs = clusterSettings(initial);  
        public void onInactive(String alias) {
        assertTrue(registry.tryAcquire("indices:data/read/search", null, null).isNoLimiter());
        Settings s = Settings.builder()  
        assertTrue(searchToken.isAcquired());
        ClusterSettings cs = clusterSettings(initial);
    public void testListenerFiresOnEnableAndDisable() {
    }
        // fill the single slot
    }
            .put(ConcurrencyLimitSettings.SETTING_PREFIX + "search.limit.max", 1)
        assertTrue(registry.hasLimiterFor("indices:data/read/search"));
            .put(ConcurrencyLimitSettings.SETTING_PREFIX + "search.limit.initial", 1)
    }
 * this file be licensed under the Apache-2.0 license or a
import java.util.Set;
    public void testPartitionPercentSumOverOneRejectedAtUpdate() {
            .put(ConcurrencyLimitSettings.SETTING_PREFIX + "search.action_name", "indices:data/read/search")
        ClusterSettings cs = clusterSettings(initial);
                .build()
        while (t.getCause() != null) {
        assertTrue(listener.inactive.isEmpty());  
        cs.applySettings(
        assertTrue("disabled alias should not be replayed as active", listener.active.isEmpty());
        // disable dynamically  
            .put(ConcurrencyLimitSettings.SETTING_PREFIX + "bulk.mode", "enforced")  
    }  
        AcquireResult token = registry.tryAcquire("indices:data/read/search", null, null);
            .put(ConcurrencyLimitSettings.SETTING_PREFIX + "search.partition.resolver", "fixed")
        assertEquals("indices:data/read/search", listener.lastSnapshot.getActionName());  
        assertTrue("after transition to enforced, limiter should be active", registry.hasLimiterFor("indices:data/read/search"));
        assertTrue(registry.hasLimiterFor("indices:data/read/search"));
    // partitioning
    public void testDisabledModePassesThrough() {
        int activeCountBefore = listener.active.size();  
    public void testRejectionAfterLimit() {
        ActionConcurrencyLimiterRegistry registry = newRegistry(s, cs);
        ClusterSettings cs = clusterSettings(s);  
        ActionConcurrencyLimiterRegistry registry = newRegistry(initial, cs);
        // Re-enable with a fresh config — must work without any stale state.
        assertTrue(e.getMessage(), e.getMessage().contains("no partition.resolver"));  
        );  
    }
            .put(ConcurrencyLimitSettings.SETTING_PREFIX + "search.action_name", "indices:data/read/search")
    public void testInvalidBurstCapacityRejected() {  
    // -------------------------------------------------------------------------
        AcquireResult token = registry.tryAcquire("indices:data/read/search", null, null);
        Set<Setting<?>> all = new HashSet<>(ConcurrencyLimitSettings.ALL_SETTINGS);
            () -> cs.applySettings(
        Settings initial = enabled("search", "indices:data/read/search");
        assertTrue(rootCauseMessage(e), rootCauseMessage(e).contains("burst.capacity must be >= 0"));  
        // Node stays healthy; previous limiter retained.
            () -> cs.applySettings(
        return new ActionConcurrencyLimiterRegistry(s, cs, new ThreadContext(Settings.EMPTY));  
            IllegalArgumentException.class,
            .put(ConcurrencyLimitSettings.SETTING_PREFIX + "search.action_name", "indices:data/read/search")  
            IllegalArgumentException.class,
        final List<String> active = new ArrayList<>();
        );
import org.opensearch.action.search.SearchRequest;  
    // -------------------------------------------------------------------------
        registry.setMetricsListener(listener);
        // Warmup is 0s so it's already expired — limiter should reject  
            () -> cs.applySettings(  
        assertTrue(rootCauseMessage(e), rootCauseMessage(e).contains("limit.max"));
        cs.applySettings(Settings.builder().put(ConcurrencyLimitSettings.SETTING_PREFIX + "search.mode", "enforced").build());
    }
            .put(ConcurrencyLimitSettings.SETTING_PREFIX + "search.mode", "enforced")
        );  
                .put(ConcurrencyLimitSettings.SETTING_PREFIX + "search.mode", "enforced")
        // premium 0.7 + standard 0.5 = 1.2 > 1.0 — must be rejected at PUT time.  
        Settings s = Settings.builder()  
    // -------------------------------------------------------------------------
        ActionConcurrencyLimiterRegistry registry = newRegistry(s, clusterSettings(s));
            )
    }  
        AcquireResult token = registry.tryAcquire("indices:data/read/search", null, null);
        ClusterSettings cs = clusterSettings(initial);  
        ActionConcurrencyLimiterRegistry registry = newRegistry(s, clusterSettings(s));
        cs.applySettings(
        newRegistry(initial, cs);  
        IllegalArgumentException e = expectThrows(
            .put(ConcurrencyLimitSettings.SETTING_PREFIX + "search.limit.max", 1)  
            .build();  
        assertEquals(1, listener.active.size()); // initial replay
        ClusterSettings cs = clusterSettings(initial);
    // metrics listener (push telemetry wiring)
        assertTrue(e.getMessage(), e.getMessage().contains("is not in partitions"));
                .put(ConcurrencyLimitSettings.SETTING_PREFIX + "search.vegas.updrift_factor", 2)  
        cs.applySettings(
    // -------------------------------------------------------------------------  
        IllegalArgumentException e = expectThrows(
        // Simulate operator clearing all settings for the alias via null (REST API sends null).  
                Settings.builder().put(ConcurrencyLimitSettings.SETTING_PREFIX + "search.gradient2.rtt_tolerance", 0.5).build()
                .put(ConcurrencyLimitSettings.SETTING_PREFIX + "search.limit.max", 100)
    public void testFixedResolverTargetNotInListRejected() {  
    }
            .build();
        Settings initial = enabled("search", "indices:data/read/search");
package org.opensearch.concurrency;
    }
        assertTrue(registry.tryAcquire("indices:data/read/search", null, null).isAcquired());  
        Settings initial = enabled("search", "indices:data/read/search");  
        assertEquals("one active limiter after re-enabling", 1, registry.getStats().getSnapshots().size());
        ActionConcurrencyLimiterRegistry registry = newRegistry(s, cs);
        );
                    .put(ConcurrencyLimitSettings.SETTING_PREFIX + "search.partition.premium.percent", 1.5)  
        Settings s = Settings.builder()
        ActionConcurrencyLimiterRegistry registry = newRegistry(s, cs);
    }  
        );  
    }
    public void testWarmupAllowsRequestsDuringWarmup() {
        assertFalse(registry.hasLimiterFor("indices:data/read/get"));
        assertEquals(List.of("search"), listener.active);
            )  
        );  
        ActionLimiterSnapshot lastSnapshot;
        assertFalse(registry.hasLimiterFor("indices:data/read/search"));
        assertEquals(1, stats.getSnapshots().get(0).getInFlight());
        AcquireResult first = registry.tryAcquire("indices:data/read/search", null, null);  
                    .putList(ConcurrencyLimitSettings.SETTING_PREFIX + "search.partitions", "premium")  
        @Override  
            .put(ConcurrencyLimitSettings.SETTING_PREFIX + alias + ".mode", "enforced")  
    }  
        Settings initial = enabled("search", "indices:data/read/search");
        Settings initial = enabled("search", "indices:data/read/search");
        assertTrue("should not reject in monitor_only mode", registry.tryAcquire("indices:data/read/search", null, null).isAcquired());  
        assertFalse(registry.hasLimiterFor("indices:data/read/search"));
            .put(ConcurrencyLimitSettings.SETTING_PREFIX + "search.warmup_duration", "0s")
        newRegistry(initial, cs);
    }
        }  
    public void testValidConfigAccepted() {
    public void testDynamicEnableViaSettings() {
            .put(ConcurrencyLimitSettings.SETTING_PREFIX + "search.warmup_duration", "0s")
    public void testInvalidPartitionPercentRejectedAtUpdate() {  
            .put(ConcurrencyLimitSettings.SETTING_PREFIX + "search.action_name", "indices:data/read/search")  
    // Removing config entirely  
    private static String rootCauseMessage(Throwable t) {
 * compatible open source license.
    public void testInvalidVegasBaselineThresholdRejected() {
 * SPDX-License-Identifier: Apache-2.0
        t2.token().onSuccess();  
        Settings initial = Settings.builder()
    // -------------------------------------------------------------------------
        public void onActive(String alias, Supplier<ActionLimiterSnapshot> snapshotSupplier) {
        searchToken.token().onSuccess();
        ClusterSettings cs = clusterSettings(initial);
    }
        AcquireResult second = registry.tryAcquire("indices:data/read/search", null, null);  
    // -------------------------------------------------------------------------  
                    .build()  
        ActionConcurrencyLimiterRegistry registry = newRegistry(s, cs);  
        cs.applySettings(Settings.builder().put(ConcurrencyLimitSettings.SETTING_PREFIX + "search.mode", "enforced").build());
        Settings initial = enabled("search", "indices:data/read/search");  
        assertEquals(0L, registry.getStats().getSnapshots().get(0).getTotalRejected());
        newRegistry(initial, cs);  
        t1.token().onSuccess();
                Settings.builder()
import org.opensearch.common.settings.Settings;  
            .put(ConcurrencyLimitSettings.SETTING_PREFIX + "search.limit.initial", 1)
            .put(ConcurrencyLimitSettings.SETTING_PREFIX + alias + ".warmup_duration", "0s")
                Settings.builder()
        return new ClusterSettings(settings, all);
    public void testModeTransitionDisabledToEnforced() {  
    public void testMultipleActionsAreIndependent() {  
            IllegalArgumentException.class,
    public void testInvalidGradient2RttToleranceRejected() {
    // -------------------------------------------------------------------------
            )
        );
        AcquireResult token = registry.tryAcquire("indices:data/read/search", null, null);
        ActionConcurrencyLimiterStats stats = registry.getStats();  
        Settings initial = enabled("search", "indices:data/read/search");
        assertTrue("new action name mapped", registry.hasLimiterFor("indices:data/read/msearch"));
        assertEquals(List.of("search"), listener.inactive);
        ActionConcurrencyLimiterRegistry registry = newRegistry(initial, cs);  
            )
        ActionConcurrencyLimiterRegistry registry = newRegistry(s, clusterSettings(s));
        assertEquals(1L, registry.getStats().getSnapshots().get(0).getTotalRejected());
        assertTrue(rootCauseMessage(e), rootCauseMessage(e).contains("baseline_reset_load_threshold must be in [0.0, 1.0]"));  
        IllegalArgumentException e = expectThrows(
    private static Settings enabled(String alias, String actionName) {  
        assertEquals("my_search", stats.getSnapshots().get(0).getAlias());
    // -------------------------------------------------------------------------
        first.token().onSuccess();
            active.add(alias);
        cs.applySettings(Settings.builder().put(ConcurrencyLimitSettings.SETTING_PREFIX + "search.mode", "monitor_only").build());  
        cs.applySettings(Settings.builder().putNull(ConcurrencyLimitSettings.SETTING_PREFIX + "search.action_name").build());
                Settings.builder()
        Settings s = enabled("search", "indices:data/read/search");
import org.opensearch.common.settings.ClusterSettings;
        assertEquals(2, registry.getStats().getSnapshots().size());  
        assertNotNull(listener.lastSnapshot);
        ActionConcurrencyLimiterRegistry registry = newRegistry(initial, cs);
            t = t.getCause();  
}
            Settings.builder()  
        AcquireResult first = registry.tryAcquire("indices:data/read/search", null, null);
            .build();  
    // -------------------------------------------------------------------------
            .put(ConcurrencyLimitSettings.SETTING_PREFIX + "search.mode", "enforced")  
    // -------------------------------------------------------------------------
    }  
        // Stats has two snapshots
    public void testMaxLimitBelowInitialRejected() {
    public void testValidPartitionConfigAccepted() {
import org.opensearch.search.builder.SearchSourceBuilder;
    // -------------------------------------------------------------------------
            .put(ConcurrencyLimitSettings.SETTING_PREFIX + "search.action_name", "indices:data/read/search")
            )
    // -------------------------------------------------------------------------  
        // disabled — not in reverse map
        assertTrue("should acquire a token", token.isAcquired());  
    }
            IllegalArgumentException.class,
        assertTrue(t2.isAcquired());  
        ActionConcurrencyLimiterRegistry registry = newRegistry(initial, cs);
        );  
        assertEquals("indices:data/read/search", stats.getSnapshots().get(0).getActionName());  
        Settings s = enabled("search", "indices:data/read/search");
        IllegalArgumentException e = expectThrows(
    // stats  
        newRegistry(initial, cs);  
            .build();  
        return t.getMessage();
            IllegalArgumentException.class,  
        SearchRequest aggSearch = new SearchRequest().source(
            .put(ConcurrencyLimitSettings.SETTING_PREFIX + "search.mode", "enforced")
    // -------------------------------------------------------------------------
        assertEquals(List.of("search"), listener.active);  
                .build()
        // All valid values — should not throw  
        IllegalArgumentException e = expectThrows(
        ClusterSettings cs = clusterSettings(s);  
        Settings initial = enabled("search", "indices:data/read/search");
    }  
                .put(ConcurrencyLimitSettings.SETTING_PREFIX + "search.partition.aggregation.percent", 0.5)  
            () -> cs.applySettings(  
            IllegalArgumentException.class,  
            .put(ConcurrencyLimitSettings.SETTING_PREFIX + "search.limit.max", 1)  
        ActionConcurrencyLimiterRegistry registry = newRegistry(s, clusterSettings(s));
        );
        assertFalse("limiter must be gone after clearing action_name", registry.hasLimiterFor("indices:data/read/search"));
                    .put(ConcurrencyLimitSettings.SETTING_PREFIX + "search.limit.initial", 50)
        IllegalArgumentException e = expectThrows(
        assertTrue(first.isAcquired());
        ClusterSettings cs = clusterSettings(s);  
                    .put(ConcurrencyLimitSettings.SETTING_PREFIX + "search.partition.standard.percent", 0.5)
    // -------------------------------------------------------------------------  
        token.token().onSuccess();
    // dynamic settings changes
    }
            .put(ConcurrencyLimitSettings.SETTING_PREFIX + "search.mode", "enforced")
    }  
    public void testInvalidInitialLimitRejected() {
        assertTrue("limiter is active again after re-enabling", registry.hasLimiterFor("indices:data/read/search"));
                Settings.builder()
        // percent > 1.0 must be rejected at PUT time (HTTP 400), not silently swallowed.
        ActionConcurrencyLimiterRegistry registry = newRegistry(s, cs);
        assertTrue(rootCauseMessage(e), rootCauseMessage(e).contains("gradient2.rtt_tolerance must be >= 1.0"));
        cs.applySettings(Settings.builder().put(ConcurrencyLimitSettings.SETTING_PREFIX + "search.algorithm", "aimd").build());  
    // mode-specific behaviour
                    .build()
        );  
    }  
    }
        cs.applySettings(Settings.builder().put(ConcurrencyLimitSettings.SETTING_PREFIX + "search.mode", "monitor_only").build());
            .put(ConcurrencyLimitSettings.SETTING_PREFIX + "search.partition.default.percent", 0.1)  
        ActionConcurrencyLimiterRegistry registry = newRegistry(s, clusterSettings(s));
            new SearchSourceBuilder().aggregation(AggregationBuilders.max("m").field("f"))
        ActionConcurrencyLimiterRegistry registry = newRegistry(s, clusterSettings(s));  
    private static ActionConcurrencyLimiterRegistry newRegistry(Settings s, ClusterSettings cs) {
        ActionConcurrencyLimiterStats stats = registry.getStats();
        token.token().onSuccess();  
import java.util.function.Supplier;
        assertTrue("monitor_only should appear in reverse map", registry.hasLimiterFor("indices:data/read/search"));  
        AcquireResult token = registry.tryAcquire("indices:data/read/search", null, aggSearch);
            Settings.builder()  
        newRegistry(initial, cs);
        ClusterSettings cs = clusterSettings(initial);
        // The previous (non-partitioned) limiter is retained and still functional.  
    }
        AcquireResult token = registry.tryAcquire("indices:data/read/search", null, null);
        Settings s = enabled("search", "indices:data/read/search");
        ActionConcurrencyLimiterRegistry registry = newRegistry(s, clusterSettings(s));  
        );
                Settings.builder()
import java.util.List;  
        assertTrue(first.isAcquired());  
        ClusterSettings cs = clusterSettings(s);
    public void testMetricsListenerNotFiredOnReconfigureFailure() {  
import org.opensearch.search.aggregations.AggregationBuilders;  
        return Settings.builder()
    }
        Settings initial = Settings.builder()
    public void testDynamicDisableClearsState() {
            IllegalArgumentException.class,
    public void testUnknownResolverRejected() {  
        Settings initial = enabled("search", "indices:data/read/search");
            .put(ConcurrencyLimitSettings.SETTING_PREFIX + "search.action_name", "indices:data/read/search")
        cs.applySettings(
            .build();  
            () -> cs.applySettings(  
        }
            .put(ConcurrencyLimitSettings.SETTING_PREFIX + "search.warmup_duration", "0s")
        cs.applySettings(Settings.builder().put(ConcurrencyLimitSettings.SETTING_PREFIX + "search.mode", "disabled").build());  
        assertEquals("enforced", listener.lastSnapshot.getMode());
    public void testBySearchTypeResolverConfigAccepted() {  
                    .build()  
        // Consumers fire with their default values; action_name default is "".
import org.opensearch.concurrency.ActionConcurrencyLimiterRegistry.AcquireResult;
    }
            .put(ConcurrencyLimitSettings.SETTING_PREFIX + "search.limit.initial", 1)  
        assertTrue(registry.hasLimiterFor("indices:data/write/bulk"));  
    }
        registry.setMetricsListener(listener);
                    .put(ConcurrencyLimitSettings.SETTING_PREFIX + "search.partition.resolver", "fixed")
    }
    }
    }
        assertEquals("would-be rejections counted in monitor_only", 1L, registry.getStats().getSnapshots().get(0).getTotalRejected());  
                .build()
            .put(ConcurrencyLimitSettings.SETTING_PREFIX + "search.mode", "enforced")
        final List<String> inactive = new ArrayList<>();  
        Settings s = Settings.builder()  
 *
    public void testAcquireAndRelease() {  
    }
        // Third should be rejected (not pass-through via warmup restart)
        assertTrue(registry.hasLimiterFor("indices:data/read/search"));  
public class ActionConcurrencyLimiterRegistryTests extends OpenSearchTestCase {
                    .putList(ConcurrencyLimitSettings.SETTING_PREFIX + "search.partitions", "premium")
        }
                    .build()
        // Now change limit — this triggers reconfigure. Warmup should stay expired.  
                    .putList(ConcurrencyLimitSettings.SETTING_PREFIX + "search.partitions", "premium", "standard")
        IllegalArgumentException e = expectThrows(
        // disable → onInactive
            () -> cs.applySettings(Settings.builder().put(ConcurrencyLimitSettings.SETTING_PREFIX + "search.burst.capacity", -1).build())
        token.token().onSuccess();
    private static final class RecordingMetricsListener implements ActionConcurrencyLimiterRegistry.MetricsListener {
    public void testDynamicActionNameChange() {
                Settings.builder().put(ConcurrencyLimitSettings.SETTING_PREFIX + "search.vegas.baseline_reset_load_threshold", 2.0).build()  
        Settings s = enabled("search", "indices:data/read/search");
            .put(ConcurrencyLimitSettings.SETTING_PREFIX + "search.limit.max", 1)  
        ClusterSettings cs = clusterSettings(initial);
    // single action  
        RecordingMetricsListener listener = new RecordingMetricsListener();  
        cs.applySettings(Settings.builder().put(ConcurrencyLimitSettings.SETTING_PREFIX + "search.aimd.backoff_ratio", 0.9).build());
                Settings.builder()  
    }
        registry.setMetricsListener(listener);
        Settings initial = Settings.builder()
        Settings s = enabled("my_search", "indices:data/read/search");
        );  
        // Fill up the new limit (2 slots)
                    .put(ConcurrencyLimitSettings.SETTING_PREFIX + "search.partition.premium.percent", 0.5)
        ClusterSettings cs = clusterSettings(initial);
        assertEquals(1, stats.getSnapshots().size());
                .put(ConcurrencyLimitSettings.SETTING_PREFIX + "search.limit.initial", 10)  
            .put(ConcurrencyLimitSettings.SETTING_PREFIX + alias + ".action_name", actionName)
                .put(ConcurrencyLimitSettings.SETTING_PREFIX + "search.partition.premium.percent", 0.6)  
        AcquireResult t1 = registry.tryAcquire("indices:data/read/search", null, null);  
        ActionConcurrencyLimiterRegistry registry = newRegistry(initial, cs);  
    // no limiter configured  
            Settings.builder()
        assertTrue("limiter should still work after rejecting bad config", token.isAcquired());  
 * The OpenSearch Contributors require contributions made to  
        assertFalse("disabled mode should not appear in reverse map", registry.hasLimiterFor("indices:data/read/search"));
        assertEquals("no active limiters reported", 0, registry.getStats().getSnapshots().size());
        bulkToken.token().onSuccess();  
        Settings s = enabled("search", "indices:data/read/search");
                .build()
        ClusterSettings cs = clusterSettings(initial);  
    // -------------------------------------------------------------------------
    }
        Settings s = Settings.EMPTY;
                .put(ConcurrencyLimitSettings.SETTING_PREFIX + "search.partition.filter.percent", 0.5)
        AcquireResult second = registry.tryAcquire("indices:data/read/search", null, null);
        assertTrue(registry.hasLimiterFor("indices:data/read/search"));
                    .put(ConcurrencyLimitSettings.SETTING_PREFIX + "search.partition.resolver", "byTenant")
    private static ClusterSettings clusterSettings(Settings settings) {  
    }
    public void testPartitionsWithoutResolverRejected() {  
        assertEquals(0, registry.getStats().getSnapshots().get(0).getInFlight());
                .put(ConcurrencyLimitSettings.SETTING_PREFIX + "search.partition.resolver", "byHeader")
            IllegalArgumentException.class,  
            () -> cs.applySettings(
                .put(ConcurrencyLimitSettings.SETTING_PREFIX + "search.limit.initial", 2)  
            () -> cs.applySettings(
        );
                .put(ConcurrencyLimitSettings.SETTING_PREFIX + "search.action_name", "indices:data/read/search")
        );
        ActionConcurrencyLimiterRegistry registry = newRegistry(s, cs);
        token.token().onSuccess();  
                    .put(ConcurrencyLimitSettings.SETTING_PREFIX + "search.limit.max", 10)  
        ActionConcurrencyLimiterRegistry registry = newRegistry(initial, cs);
    }
        assertTrue("partitioned limiter should grant a token", token.isAcquired());
    // -------------------------------------------------------------------------  
        assertFalse("old action name removed", registry.hasLimiterFor("indices:data/read/search"));  
    public void testLimitChangePreservesWarmupExpired() {
        assertTrue(registry.hasLimiterFor("indices:data/read/search"));
        Settings initial = enabled("search", "indices:data/read/search");
                .build()  
        Settings s = Settings.builder()
        cs.applySettings(
            inactive.add(alias);
        assertTrue("monitor_only should never return empty", second.isAcquired());
        );  
        assertEquals(1, stats.getSnapshots().size());  
        assertTrue(rootCauseMessage(e), rootCauseMessage(e).contains("limit.initial must be >= 1"));
        token.token().onSuccess();  
            )
            .put(ConcurrencyLimitSettings.SETTING_PREFIX + "search.limit.initial", 1)
        cs.applySettings(Settings.builder().put(ConcurrencyLimitSettings.SETTING_PREFIX + "search.burst.capacity", 5).build());
        assertTrue(registry.hasLimiterFor("indices:data/read/search"));
            Settings.builder()
            .build();
 */  
        // enable → onActive
            Settings.builder()
        cs.applySettings(Settings.builder().put(ConcurrencyLimitSettings.SETTING_PREFIX + "search.mode", "enforced").build());  
        assertEquals("enforced", stats.getSnapshots().get(0).getMode());
import org.opensearch.test.OpenSearchTestCase;
            .put(ConcurrencyLimitSettings.SETTING_PREFIX + "search.mode", "enforced")
        assertTrue(registry.hasLimiterFor("indices:data/read/search"));
        AcquireResult bulkToken = registry.tryAcquire("indices:data/write/bulk", null, null);
            .put(ConcurrencyLimitSettings.SETTING_PREFIX + "search.action_name", "indices:data/read/search")  
            () -> cs.applySettings(  
        assertEquals("monitor_only", listener.lastSnapshot.getMode());
            .put(ConcurrencyLimitSettings.SETTING_PREFIX + "search.warmup_duration", "0s")
    public void testStatsAlias() {  
        ActionConcurrencyLimiterRegistry registry = newRegistry(s, clusterSettings(s));
        Settings s = enabled("search", "indices:data/read/search");
        // partitions set but no resolver → all traffic would funnel to unknownPartition. Reject.
            .put(ConcurrencyLimitSettings.SETTING_PREFIX + "search.warmup_duration", "5m")
        AcquireResult t2 = registry.tryAcquire("indices:data/read/search", null, null);
            .put(ConcurrencyLimitSettings.SETTING_PREFIX + "search.action_name", "indices:data/read/search")  
            .put(ConcurrencyLimitSettings.SETTING_PREFIX + "search.partition.standard.percent", 0.3)
                    .build()
            lastSnapshot = snapshotSupplier.get();  
            )
        registry.setMetricsListener(listener);  
            .put(ConcurrencyLimitSettings.SETTING_PREFIX + "search.partition.resolver.fixed.partition", "premium")
        Settings s = Settings.builder()
            registry.tryAcquire("indices:data/read/search", null, null).isAcquired()
        IllegalArgumentException e = expectThrows(
            IllegalArgumentException.class,
                .put(ConcurrencyLimitSettings.SETTING_PREFIX + "search.warmup_duration", "0s")  
            .build();
