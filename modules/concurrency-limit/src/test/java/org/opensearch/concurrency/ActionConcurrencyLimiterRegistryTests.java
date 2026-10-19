        ActionConcurrencyLimiterRegistry registry = newRegistry(s, clusterSettings(s));
        );
        assertTrue("limiter should still work after rejecting bad config", token.isAcquired());
        registry.setMetricsListener(listener);
        AcquireResult first = registry.tryAcquire("indices:data/read/search", null, null);
        RecordingMetricsListener listener = new RecordingMetricsListener();
        ClusterSettings cs = clusterSettings(s);
    }
    // -------------------------------------------------------------------------
        ActionConcurrencyLimiterRegistry registry = newRegistry(s, clusterSettings(s));
            .put(ConcurrencyLimitSettings.SETTING_PREFIX + "search.mode", "enforced")
        token.token().onSuccess();
    // -------------------------------------------------------------------------
            .build();
        AcquireResult token = registry.tryAcquire("indices:data/read/search", null, null);
        ActionConcurrencyLimiterRegistry registry = newRegistry(s, clusterSettings(s));
            t = t.getCause();
            Settings.builder()
        ActionConcurrencyLimiterRegistry registry = newRegistry(initial, cs);
        assertFalse("disabled alias removed from reverse map", registry.hasLimiterFor("indices:data/read/search"));
    public void testInvalidInitialLimitRejected() {
    // -------------------------------------------------------------------------
    public void testSetMetricsListenerReplaysActiveAliases() {
        ClusterSettings cs = clusterSettings(initial);
    // -------------------------------------------------------------------------
        );
        assertFalse("disabled mode should not appear in reverse map", registry.hasLimiterFor("indices:data/read/search"));
    }
                .putList(ConcurrencyLimitSettings.SETTING_PREFIX + "search.partitions", "premium", "standard")
        assertTrue(registry.hasLimiterFor("indices:data/read/search"));
        token.token().onSuccess();
        assertEquals(List.of("search"), listener.active);
        assertEquals("enforced", stats.getSnapshots().get(0).getMode());
        ClusterSettings cs = clusterSettings(initial);
                .put(ConcurrencyLimitSettings.SETTING_PREFIX + "search.limit.max", 2)
                    .build()
        assertEquals(1, stats.getSnapshots().get(0).getInFlight());
 */
        ActionConcurrencyLimiterRegistry registry = newRegistry(s, clusterSettings(s));
    public void testModeTransitionDisabledToEnforced() {
        assertTrue(rootCauseMessage(e), rootCauseMessage(e).contains("burst.capacity must be >= 0"));
            () -> cs.applySettings(
    public void testPartitionedLimiterBuildsAndAcquires() {
        token.token().onSuccess();
        );
    // -------------------------------------------------------------------------
        Settings initial = enabled("search", "indices:data/read/search");
        Settings initial = enabled("search", "indices:data/read/search");
        assertTrue(registry.hasLimiterFor("indices:data/read/search"));
    private static Settings.Builder partitionedBase() {
            .put(ConcurrencyLimitSettings.SETTING_PREFIX + "search.partition.resolver.fixed.partition", "premium")
        Settings s = Settings.builder()
        AcquireResult second = registry.tryAcquire("indices:data/read/search", null, null);
            .put(ConcurrencyLimitSettings.SETTING_PREFIX + "search.limit.max", 1)
        // fill the single slot
    }
        assertTrue(registry.hasLimiterFor("indices:data/read/search"));
            .put(ConcurrencyLimitSettings.SETTING_PREFIX + "search.limit.initial", 1)
                .build()
        );
        assertEquals(0, registry.getStats().getSnapshots().get(0).getInFlight());
                .build()
        // disabled — not in reverse map
        ActionConcurrencyLimiterRegistry registry = newRegistry(initial, cs);
        assertTrue(e.getMessage(), e.getMessage().contains("no partition.resolver"));
        );
                Settings.builder().put(ConcurrencyLimitSettings.SETTING_PREFIX + "search.vegas.baseline_reset_load_threshold", 2.0).build()
        Settings initial = Settings.builder()
import org.opensearch.action.search.SearchRequest;
        assertTrue("should acquire a token", token.isAcquired());
        int activeCountBefore = listener.active.size();
    // -------------------------------------------------------------------------
            IllegalArgumentException.class,
        Settings s = enabled("search", "indices:data/read/search");
        assertTrue("limit should be > 0 while enabled", registry.getStats().getSnapshots().get(0).getCurrentLimit() > 0);
                .put(ConcurrencyLimitSettings.SETTING_PREFIX + "search.action_name", "indices:data/read/search")
        IllegalArgumentException e = expectThrows(
    }
        assertTrue("should not reject in monitor_only mode", registry.tryAcquire("indices:data/read/search", null, null).isAcquired());
        cs.applySettings(Settings.builder().put(ConcurrencyLimitSettings.SETTING_PREFIX + "search.mode", "disabled").build());
            .build();
                .put(ConcurrencyLimitSettings.SETTING_PREFIX + "search.limit.max", 100)
        cs.applySettings(
            .put(ConcurrencyLimitSettings.SETTING_PREFIX + "search.warmup_duration", "0s")
            .put(ConcurrencyLimitSettings.SETTING_PREFIX + "search.action_name", "indices:data/read/search")
    public void testClearingActionNameRemovesLimiterAndAllowsReactivation() {
        Settings initial = Settings.builder()
            .build();
        // switch to monitor_only
                    .put(ConcurrencyLimitSettings.SETTING_PREFIX + "search.limit.initial", 50)
    // -------------------------------------------------------------------------
    private static String rootCauseMessage(Throwable t) {
            .put(ConcurrencyLimitSettings.SETTING_PREFIX + "search.warmup_duration", "0s")
                .build()
 * this file be licensed under the Apache-2.0 license or a
    // -------------------------------------------------------------------------
        // Now change limit — this triggers reconfigure. Warmup should stay expired.
        registry.setMetricsListener(listener);
        SearchRequest aggSearch = new SearchRequest().source(
            .build();
        assertTrue(registry.hasLimiterFor("indices:data/write/bulk"));
        token.token().onSuccess();
        cs.applySettings(
        cs.applySettings(
            () -> cs.applySettings(Settings.builder().put(ConcurrencyLimitSettings.SETTING_PREFIX + "search.limit.initial", 0).build())
            .build();
            .put(ConcurrencyLimitSettings.SETTING_PREFIX + "search.action_name", "indices:data/read/search")
        IllegalArgumentException e = expectThrows(
            .put(ConcurrencyLimitSettings.SETTING_PREFIX + alias + ".mode", "enforced")
        // All valid values — should not throw
        // Re-enable with a fresh config — must work without any stale state.
        Settings s = enabled("search", "indices:data/read/search");
            IllegalArgumentException.class,
                Settings.builder().put(ConcurrencyLimitSettings.SETTING_PREFIX + "search.gradient2.rtt_tolerance", 0.5).build()
    }
        assertFalse(registry.hasLimiterFor("indices:data/read/get"));
        AcquireResult token = registry.tryAcquire("indices:data/read/search", null, null);
        Settings s = enabled("search", "indices:data/read/search");
                .put(ConcurrencyLimitSettings.SETTING_PREFIX + "search.partition.resolver", "bySearchType")
        public void onInactive(String alias) {
import java.util.List;
            () -> cs.applySettings(
        );
        ActionConcurrencyLimiterRegistry registry = newRegistry(initial, cs);
                    .put(ConcurrencyLimitSettings.SETTING_PREFIX + "search.partition.resolver", "fixed")
    public void testMetricsListenerNotFiredOnReconfigureFailure() {
        assertTrue(registry.hasLimiterFor("indices:data/read/search"));
                    .put(ConcurrencyLimitSettings.SETTING_PREFIX + "search.partition.premium.percent", 0.5)
    // partitioning
        assertTrue(first.isAcquired());
        assertTrue(searchToken.isAcquired());
        ActionConcurrencyLimiterStats stats = registry.getStats();
        @Override
        }
        ActionConcurrencyLimiterRegistry registry = newRegistry(s, cs);
            registry.tryAcquire("indices:data/read/search", null, null).isAcquired()
            .put(ConcurrencyLimitSettings.SETTING_PREFIX + "search.mode", "enforced")
    }
            )
        return Settings.builder()
            () -> cs.applySettings(
            .put(ConcurrencyLimitSettings.SETTING_PREFIX + "search.warmup_duration", "0s")
        cs.applySettings(Settings.builder().put(ConcurrencyLimitSettings.SETTING_PREFIX + "search.mode", "disabled").build());
    }
        // reconfigure an active alias (mode change) → re-fire onActive so tags can refresh
            IllegalArgumentException.class,
        assertFalse(registry.hasLimiterFor("indices:data/read/search"));
            .build();
        assertEquals("indices:data/read/search", listener.lastSnapshot.getActionName());
        }
    }
        Settings initial = enabled("search", "indices:data/read/search");
    public void testValidConfigAccepted() {
    public void testNoLimiterPassesThrough() {
        ClusterSettings cs = clusterSettings(initial);
            .put(ConcurrencyLimitSettings.SETTING_PREFIX + "search.mode", "enforced")
        t2.token().onSuccess();
                .put(ConcurrencyLimitSettings.SETTING_PREFIX + "search.partition.filter.percent", 0.5)
                    .put(ConcurrencyLimitSettings.SETTING_PREFIX + "search.partition.resolver", "byTenant")
import java.util.HashSet;
        assertEquals("would-be rejections counted in monitor_only", 1L, registry.getStats().getSnapshots().get(0).getTotalRejected());
        // disable → onInactive
import org.opensearch.common.settings.Setting;
        AcquireResult token = registry.tryAcquire("indices:data/read/search", null, null);
                Settings.builder().put(ConcurrencyLimitSettings.SETTING_PREFIX + "search.aimd.backoff_ratio", 0.3).build()
        assertTrue("valid partitioned config should grant a token", token.isAcquired());
            .build();
        assertTrue(e.getMessage(), e.getMessage().contains("<= 1.0"));
    // -------------------------------------------------------------------------
            .put(ConcurrencyLimitSettings.SETTING_PREFIX + "search.action_name", "indices:data/read/search")
        Settings s = Settings.builder()
            )
        ClusterSettings cs = clusterSettings(initial);
        // disable dynamically
            .put(ConcurrencyLimitSettings.SETTING_PREFIX + "search.action_name", "indices:data/read/search")
    }
            lastSnapshot = snapshotSupplier.get();
        );
        IllegalArgumentException e = expectThrows(
        IllegalArgumentException e = expectThrows(
        ActionConcurrencyLimiterStats stats = registry.getStats();
            .put(ConcurrencyLimitSettings.SETTING_PREFIX + "search.action_name", "indices:data/read/search")
            .put(ConcurrencyLimitSettings.SETTING_PREFIX + "bulk.mode", "enforced")
        newRegistry(initial, cs);
        ActionConcurrencyLimiterRegistry registry = newRegistry(s, cs);
        Settings initial = enabled("search", "indices:data/read/search");
                    .put(ConcurrencyLimitSettings.SETTING_PREFIX + "search.limit.max", 10)
                Settings.builder()
        assertEquals("indices:data/read/search", stats.getSnapshots().get(0).getActionName());
            "warmup should not restart on limit change — should still reject",
            .put(ConcurrencyLimitSettings.SETTING_PREFIX + "search.action_name", "indices:data/read/search")
            IllegalArgumentException.class,
        Settings s = enabled("search", "indices:data/read/search");
        assertTrue(e.getMessage(), e.getMessage().contains("is not in partitions"));
    }
    }
            .put(ConcurrencyLimitSettings.SETTING_PREFIX + "search.warmup_duration", "0s")
        assertTrue(registry.hasLimiterFor("indices:data/read/search"));
    }
        ClusterSettings cs = clusterSettings(s);
        cs.applySettings(Settings.builder().put(ConcurrencyLimitSettings.SETTING_PREFIX + "search.aimd.backoff_ratio", 0.9).build());
        ClusterSettings cs = clusterSettings(initial);
        AcquireResult t2 = registry.tryAcquire("indices:data/read/search", null, null);
        Settings s = enabled("my_search", "indices:data/read/search");
    public void testMonitorOnlyNeverRejects() {
        assertEquals(List.of("search"), listener.inactive);
        Settings initial = enabled("search", "indices:data/read/search");
        token.token().onSuccess();
        // Simulate operator clearing all settings for the alias via null (REST API sends null).
        newRegistry(initial, cs);
        assertTrue(first.isAcquired());
    }
            .put(ConcurrencyLimitSettings.SETTING_PREFIX + "search.limit.max", 1)
            .put(ConcurrencyLimitSettings.SETTING_PREFIX + "search.limit.initial", 1)
        assertTrue(registry.hasLimiterFor("indices:data/read/search"));
        cs.applySettings(Settings.builder().put(ConcurrencyLimitSettings.SETTING_PREFIX + "search.mode", "enforced").build());
            .put(ConcurrencyLimitSettings.SETTING_PREFIX + "search.limit.initial", 1)
            .put(ConcurrencyLimitSettings.SETTING_PREFIX + "search.warmup_duration", "5m")
            Settings.builder().put(ConcurrencyLimitSettings.SETTING_PREFIX + "search.action_name", "indices:data/read/msearch").build()
            Settings.builder()
            .put(ConcurrencyLimitSettings.SETTING_PREFIX + "search.warmup_duration", "0s")
        // premium 0.7 + standard 0.5 = 1.2 > 1.0 — must be rejected at PUT time.
        cs.applySettings(
        // percent > 1.0 must be rejected at PUT time (HTTP 400), not silently swallowed.
    }
                Settings.builder()
    }
        Set<Setting<?>> all = new HashSet<>(ConcurrencyLimitSettings.ALL_SETTINGS);
    // -------------------------------------------------------------------------
            .put(ConcurrencyLimitSettings.SETTING_PREFIX + "bulk.warmup_duration", "0s")
        );
            .put(ConcurrencyLimitSettings.SETTING_PREFIX + "search.limit.max", 1)
    }
        Settings s = Settings.builder()
                    .putList(ConcurrencyLimitSettings.SETTING_PREFIX + "search.partitions", "premium")
        // acquire and release a token so the limiter has a non-zero limit snapshot
        return new ActionConcurrencyLimiterRegistry(s, cs, new ThreadContext(Settings.EMPTY));
            // mode defaults to "disabled"
    }
        assertEquals(activeCountBefore + 1, listener.active.size());
        RecordingMetricsListener listener = new RecordingMetricsListener();
                    .build()
        // Fill up the new limit (2 slots)
        // fill slot and verify rejection while enforced
    // -------------------------------------------------------------------------
        assertEquals("no active limiters reported", 0, registry.getStats().getSnapshots().size());
            )
        // Consumers fire with their default values; action_name default is "".
        ActionConcurrencyLimiterRegistry registry = newRegistry(s, clusterSettings(s));
        ActionConcurrencyLimiterRegistry registry = newRegistry(s, cs);
        ActionConcurrencyLimiterRegistry registry = newRegistry(initial, cs);
/*
    }
        assertTrue("during warmup, second acquire should return NOOP not empty", second.isAcquired());
        assertTrue(registry.tryAcquire("indices:data/read/search", null, null).isNoLimiter());
        ClusterSettings cs = clusterSettings(initial);
    public void testDynamicActionNameChange() {
        assertTrue("disabled alias should not be replayed as active", listener.active.isEmpty());
    public void testPartitionPercentSumOverOneRejectedAtUpdate() {
    public void testListenerFiresOnEnableAndDisable() {
    public void testModeTransitionEnforcedToMonitorOnly() {
        assertTrue(t1.isAcquired());
    // -------------------------------------------------------------------------
        cs.applySettings(Settings.builder().put(ConcurrencyLimitSettings.SETTING_PREFIX + "search.mode", "enforced").build());
        ClusterSettings cs = clusterSettings(initial);
        ActionConcurrencyLimiterRegistry registry = newRegistry(s, clusterSettings(s));
        ClusterSettings cs = clusterSettings(initial);
        );
            IllegalArgumentException.class,
            .put(ConcurrencyLimitSettings.SETTING_PREFIX + "search.limit.max", 1)
                .put(ConcurrencyLimitSettings.SETTING_PREFIX + "search.partition.aggregation.percent", 0.5)
                Settings.builder()
        ActionConcurrencyLimiterRegistry registry = newRegistry(s, cs);
        // partitions set but no resolver → all traffic would funnel to unknownPartition. Reject.
                .build()
        cs.applySettings(Settings.builder().putNull(ConcurrencyLimitSettings.SETTING_PREFIX + "search.action_name").build());
            IllegalArgumentException.class,
import java.util.ArrayList;
            Settings.builder()
        Settings s = enabled("search", "indices:data/read/search");
import org.opensearch.test.OpenSearchTestCase;
        assertTrue("partitioned limiter should grant a token", token.isAcquired());
        Settings initial = enabled("search", "indices:data/read/search");
    // -------------------------------------------------------------------------
            .put(ConcurrencyLimitSettings.SETTING_PREFIX + "search.partition.default.percent", 0.1)
    }
                Settings.builder()
            () -> cs.applySettings(Settings.builder().put(ConcurrencyLimitSettings.SETTING_PREFIX + "search.burst.capacity", -1).build())
        Settings initial = enabled("search", "indices:data/read/search");
        cs.applySettings(Settings.builder().put(ConcurrencyLimitSettings.SETTING_PREFIX + "search.mode", "monitor_only").build());
            )
    private static Settings enabled(String alias, String actionName) {
            .put(ConcurrencyLimitSettings.SETTING_PREFIX + "search.mode", "disabled")
 * SPDX-License-Identifier: Apache-2.0
        );
        assertTrue(e.getMessage(), e.getMessage().contains("must be in [0.0, 1.0]"));
        ActionConcurrencyLimiterRegistry registry = newRegistry(initial, cs);
    public void testValidPartitionConfigAccepted() {
        assertTrue("monitor_only should appear in reverse map", registry.hasLimiterFor("indices:data/read/search"));
 *
import org.opensearch.common.settings.Settings;
        bulkToken.token().onSuccess();
        );
        // now even at limit, requests pass through
        AcquireResult bulkToken = registry.tryAcquire("indices:data/write/bulk", null, null);
        );
        newRegistry(initial, cs);
        ClusterSettings cs = clusterSettings(initial);
        cs.applySettings(Settings.builder().put(ConcurrencyLimitSettings.SETTING_PREFIX + "search.mode", "enforced").build());
        AcquireResult first = registry.tryAcquire("indices:data/read/search", null, null);
                    .put(ConcurrencyLimitSettings.SETTING_PREFIX + "search.partition.premium.percent", 0.5)
    }
        assertEquals(1L, registry.getStats().getSnapshots().get(0).getTotalRejected());
    }
            .put(ConcurrencyLimitSettings.SETTING_PREFIX + "search.partition.standard.percent", 0.3)
        AcquireResult second = registry.tryAcquire("indices:data/read/search", null, null);
        );
        IllegalArgumentException e = expectThrows(
        cs.applySettings(
        registry.tryAcquire("indices:data/read/search", null, null); // fill slot
        ActionLimiterSnapshot lastSnapshot;
                Settings.builder()
        ActionConcurrencyLimiterRegistry registry = newRegistry(s, cs);
        Settings initial = enabled("search", "indices:data/read/search");
    // multiple independent actions
        assertTrue(registry.hasLimiterFor("indices:data/read/search"));
    public void testLimitChangePreservesWarmupExpired() {
import org.opensearch.common.settings.ClusterSettings;
    public void testBySearchTypeResolverConfigAccepted() {
import org.opensearch.common.util.concurrent.ThreadContext;
    }
        assertTrue(rootCauseMessage(e), rootCauseMessage(e).contains("limit.initial must be >= 1"));
    // -------------------------------------------------------------------------
import org.opensearch.search.builder.SearchSourceBuilder;
                    .put(ConcurrencyLimitSettings.SETTING_PREFIX + "search.partition.premium.percent", 0.7)
        assertEquals(0L, registry.getStats().getSnapshots().get(0).getTotalRejected());
        @Override
                .putList(ConcurrencyLimitSettings.SETTING_PREFIX + "search.partitions", "filter", "aggregation")
import org.opensearch.search.aggregations.AggregationBuilders;
    public void testDisabledModePassesThrough() {
        Settings initial = enabled("search", "indices:data/read/search");
        );
        assertFalse("old action name removed", registry.hasLimiterFor("indices:data/read/search"));
        assertTrue("new action name mapped", registry.hasLimiterFor("indices:data/read/msearch"));
    public void testInvalidGradient2RttToleranceRejected() {
            .put(ConcurrencyLimitSettings.SETTING_PREFIX + "search.mode", "enforced")
        assertFalse("should reject after warmup expired", registry.tryAcquire("indices:data/read/search", null, null).isAcquired());
import org.opensearch.concurrency.ActionConcurrencyLimiterRegistry.AcquireResult;
    public void testWarmupAllowsRequestsDuringWarmup() {
        AcquireResult token = registry.tryAcquire("indices:data/read/search", null, null);
        assertEquals("monitor_only", listener.lastSnapshot.getMode());
                .put(ConcurrencyLimitSettings.SETTING_PREFIX + "search.vegas.updrift_factor", 2)
        Settings s = Settings.builder()
        assertFalse("limiter must be gone after clearing action_name", registry.hasLimiterFor("indices:data/read/search"));
            .put(ConcurrencyLimitSettings.SETTING_PREFIX + alias + ".warmup_duration", "0s")
    // Removing config entirely
    }
                    .put(ConcurrencyLimitSettings.SETTING_PREFIX + "search.partition.resolver.fixed.partition", "ghost")
        newRegistry(initial, cs);
        assertTrue("monitor_only should never return empty", second.isAcquired());
    }
        // even at limit, monitor_only never rejects
            () -> cs.applySettings(
        registry.setMetricsListener(listener);
            .put(ConcurrencyLimitSettings.SETTING_PREFIX + "search.action_name", "indices:data/read/search")
    }
            active.add(alias);
        assertTrue(registry.hasLimiterFor("indices:data/read/search"));
    // mode-specific behaviour
        assertEquals("enforced", listener.lastSnapshot.getMode());
    // -------------------------------------------------------------------------
    public void testListenerRefiresOnReconfigure() {
        RecordingMetricsListener listener = new RecordingMetricsListener();
        assertTrue(registry.hasLimiterFor("indices:data/read/search"));
        ClusterSettings cs = clusterSettings(s);
package org.opensearch.concurrency;
                .build()
    }
        assertTrue(e.getMessage(), e.getMessage().contains("Unknown partition resolver"));
        public void onActive(String alias, Supplier<ActionLimiterSnapshot> snapshotSupplier) {
    // -------------------------------------------------------------------------
        assertEquals("one active limiter after re-enabling", 1, registry.getStats().getSnapshots().size());
    }
    // no limiter configured
            IllegalArgumentException.class,
        assertTrue("after transition to enforced, limiter should be active", registry.hasLimiterFor("indices:data/read/search"));
    }
                .put(ConcurrencyLimitSettings.SETTING_PREFIX + "search.warmup_duration", "0s")
        ActionConcurrencyLimiterRegistry registry = newRegistry(s, clusterSettings(s));
        assertTrue(registry.hasLimiterFor("indices:data/read/search"));
            .put(ConcurrencyLimitSettings.SETTING_PREFIX + "search.mode", "enforced")
        assertTrue(token.isAcquired());
                .put(ConcurrencyLimitSettings.SETTING_PREFIX + "search.vegas.baseline_reset_load_threshold", 0.8)
            .put(ConcurrencyLimitSettings.SETTING_PREFIX + "search.limit.max", 1)
            () -> cs.applySettings(
        AcquireResult second = registry.tryAcquire("indices:data/read/search", null, null);
        IllegalArgumentException e = expectThrows(
            .build();
        ClusterSettings cs = clusterSettings(initial);
    }
    }
        ActionConcurrencyLimiterRegistry registry = newRegistry(s, cs);
        assertTrue(registry.hasLimiterFor("indices:data/read/search"));
                    .putList(ConcurrencyLimitSettings.SETTING_PREFIX + "search.partitions", "premium")
            Settings.builder()
        newRegistry(initial, cs);
    // -------------------------------------------------------------------------
        assertEquals(List.of("search"), listener.active);
        registry.setMetricsListener(listener);
        return new ClusterSettings(settings, all);
        Settings initial = enabled("search", "indices:data/read/search");
        Settings initial = enabled("search", "indices:data/read/search");
        while (t.getCause() != null) {
                .build()
    // -------------------------------------------------------------------------
        ActionConcurrencyLimiterRegistry registry = newRegistry(initial, cs);
        ActionConcurrencyLimiterRegistry registry = newRegistry(s, clusterSettings(s));
                .put(ConcurrencyLimitSettings.SETTING_PREFIX + "search.partition.premium.percent", 0.6)
        assertFalse("should reject in enforced mode", registry.tryAcquire("indices:data/read/search", null, null).isAcquired());
            )
                    .build()
        Settings s = partitionedBase().put(ConcurrencyLimitSettings.SETTING_PREFIX + "search.partition.premium.percent", 0.6)
        return Settings.builder()
        // enable dynamically
    // setting validation
    private static ClusterSettings clusterSettings(Settings settings) {
        assertTrue(rootCauseMessage(e), rootCauseMessage(e).contains("limit.max"));
    // -------------------------------------------------------------------------
                Settings.builder()
            .put(ConcurrencyLimitSettings.SETTING_PREFIX + "search.mode", "disabled")
            .putList(ConcurrencyLimitSettings.SETTING_PREFIX + "search.partitions", "premium", "standard", "default");
    public void testInvalidPartitionPercentRejectedAtUpdate() {
        assertFalse(registry.hasLimiterFor("indices:data/read/search"));
        AcquireResult token = registry.tryAcquire("indices:data/read/search", null, aggSearch);
                .put(ConcurrencyLimitSettings.SETTING_PREFIX + "search.limit.initial", 2)
        assertEquals(2, listener.active.size());
            .put(ConcurrencyLimitSettings.SETTING_PREFIX + "search.partition.resolver", "fixed")
            () -> cs.applySettings(
                    .put(ConcurrencyLimitSettings.SETTING_PREFIX + "search.partition.premium.percent", 0.5)
    public void testInvalidBurstCapacityRejected() {
        ActionConcurrencyLimiterRegistry registry = newRegistry(s, clusterSettings(s));
            .put(ConcurrencyLimitSettings.SETTING_PREFIX + "search.warmup_duration", "0s")
    // single action
        IllegalArgumentException e = expectThrows(
        );
                .put(ConcurrencyLimitSettings.SETTING_PREFIX + "search.partition.standard.percent", 0.3)
        ClusterSettings cs = clusterSettings(initial);
        final List<String> active = new ArrayList<>();
    }
        // enable → onActive
        Settings initial = Settings.builder()
        // Change algorithm — this is a successful reconfigure, listener should fire
        assertTrue(t2.isAcquired());
    // -------------------------------------------------------------------------
        assertTrue(registry.tryAcquire("indices:data/read/search", null, null).isAcquired());
            .put(ConcurrencyLimitSettings.SETTING_PREFIX + "search.action_name", "indices:data/read/search")
    public void testInvalidAimdBackoffRatioRejected() {
        assertEquals(1, stats.getSnapshots().size());
        cs.applySettings(Settings.builder().put(ConcurrencyLimitSettings.SETTING_PREFIX + "search.algorithm", "aimd").build());
        Settings initial = enabled("search", "indices:data/read/search");
        ActionConcurrencyLimiterRegistry registry = newRegistry(initial, cs);
            IllegalArgumentException.class,
        ClusterSettings cs = clusterSettings(initial);
        ActionConcurrencyLimiterRegistry registry = newRegistry(initial, cs);
import org.opensearch.action.ActionConcurrencyLimiterStats;
        IllegalArgumentException e = expectThrows(
            IllegalArgumentException.class,
        assertTrue(rootCauseMessage(e), rootCauseMessage(e).contains("gradient2.rtt_tolerance must be >= 1.0"));
import org.opensearch.action.ActionConcurrencyLimiterStats.ActionLimiterSnapshot;
        AcquireResult searchToken = registry.tryAcquire("indices:data/read/search", null, null);
            .build();
        assertFalse("second acquire should be rejected at limit=1", second.isAcquired());
    private static ActionConcurrencyLimiterRegistry newRegistry(Settings s, ClusterSettings cs) {
        searchToken.token().onSuccess();
        Settings s = Settings.builder()
        first.token().onSuccess();
            Settings.builder()
    }
        assertEquals("snapshot limit should be 0 after disable", 0, registry.getStats().getSnapshots().get(0).getCurrentLimit());
        cs.applySettings(
        assertTrue(registry.hasLimiterFor("indices:data/read/search"));
                    .put(ConcurrencyLimitSettings.SETTING_PREFIX + "search.partition.premium.percent", 1.5)
        return t.getMessage();
    public void testMultipleActionsAreIndependent() {
            .put(ConcurrencyLimitSettings.SETTING_PREFIX + "search.action_name", "indices:data/read/search")
    }
    public void testMaxLimitBelowInitialRejected() {
        AcquireResult token = registry.tryAcquire("indices:data/read/search", null, null);
}
    public void testAcquireAndRelease() {
        }
        cs.applySettings(Settings.builder().put(ConcurrencyLimitSettings.SETTING_PREFIX + "search.mode", "monitor_only").build());
                .put(ConcurrencyLimitSettings.SETTING_PREFIX + "search.mode", "enforced")
        cs.applySettings(Settings.builder().put(ConcurrencyLimitSettings.SETTING_PREFIX + "search.burst.capacity", 5).build());
        Settings s = Settings.builder()
    public void testUnknownResolverRejected() {
            .put(ConcurrencyLimitSettings.SETTING_PREFIX + "search.mode", "enforced")
                    .build()
    }
        assertTrue(token.isAcquired());
        assertTrue(first.isAcquired());
            .put(ConcurrencyLimitSettings.SETTING_PREFIX + "search.warmup_duration", "0s")
        newRegistry(initial, cs);
            .put(ConcurrencyLimitSettings.SETTING_PREFIX + alias + ".action_name", actionName)
        t1.token().onSuccess();
    public void testDynamicDisableClearsState() {
    public void testInvalidVegasBaselineThresholdRejected() {
            inactive.add(alias);
        AcquireResult first = registry.tryAcquire("indices:data/read/search", null, null);
        );
        // Stats has two snapshots
                .put(ConcurrencyLimitSettings.SETTING_PREFIX + "search.limit.initial", 10)
        // The previous (non-partitioned) limiter is retained and still functional.
        newRegistry(initial, cs);
        registry.tryAcquire("indices:data/read/search", null, null);
            .build();
        cs.applySettings(Settings.builder().put(ConcurrencyLimitSettings.SETTING_PREFIX + "search.gradient2.rtt_tolerance", 2.0).build());
    public void testDynamicEnableViaSettings() {
import java.util.function.Supplier;
        token.token().onSuccess();
            .put(ConcurrencyLimitSettings.SETTING_PREFIX + "search.mode", "monitor_only")
        // Node stays healthy; previous limiter retained.
        newRegistry(initial, cs);
            .build();
            Settings.builder()
        );
            .put(ConcurrencyLimitSettings.SETTING_PREFIX + "search.limit.initial", 1)
        assertFalse(
            )
            .put(ConcurrencyLimitSettings.SETTING_PREFIX + "search.action_name", "indices:data/read/search")
        assertTrue("bySearchType partitioned limiter should grant a token", token.isAcquired());
            () -> cs.applySettings(
    }
        ClusterSettings cs = clusterSettings(s);
        Settings s = enabled("search", "indices:data/read/search");
        Settings initial = enabled("search", "indices:data/read/search");
            new SearchSourceBuilder().aggregation(AggregationBuilders.max("m").field("f"))
        ClusterSettings cs = clusterSettings(initial);
    private static final class RecordingMetricsListener implements ActionConcurrencyLimiterRegistry.MetricsListener {
    public void testFixedResolverTargetNotInListRejected() {
        token.token().onSuccess();
            .put(ConcurrencyLimitSettings.SETTING_PREFIX + "search.action_name", "indices:data/read/search")
    public void testPartitionsWithoutResolverRejected() {
        Settings s = Settings.EMPTY;
    // stats
        ClusterSettings cs = clusterSettings(s);
    public void testRejectionAfterLimit() {
    // dynamic settings changes
public class ActionConcurrencyLimiterRegistryTests extends OpenSearchTestCase {
            .build();
    }
    // metrics listener (push telemetry wiring)
        ClusterSettings cs = clusterSettings(initial);
            () -> cs.applySettings(
                    .build()
        IllegalArgumentException e = expectThrows(
        Settings initial = enabled("search", "indices:data/read/search");
        ClusterSettings cs = clusterSettings(s);
    }
        assertEquals("my_search", stats.getSnapshots().get(0).getAlias());
        IllegalArgumentException e = expectThrows(
        assertNotNull(listener.lastSnapshot);
        newRegistry(initial, cs);
        assertEquals(1, listener.active.size()); // initial replay
        );
        assertTrue(rootCauseMessage(e), rootCauseMessage(e).contains("aimd.backoff_ratio must be in [0.5, 1.0)"));
            .put(ConcurrencyLimitSettings.SETTING_PREFIX + "bulk.action_name", "indices:data/write/bulk")
        RecordingMetricsListener listener = new RecordingMetricsListener();
        assertFalse(registry.hasLimiterFor("indices:data/read/search"));
        AcquireResult token = registry.tryAcquire("indices:data/read/search", null, null);
    }
        assertEquals(1, stats.getSnapshots().size());
 * compatible open source license.
            IllegalArgumentException.class,
        assertTrue(listener.inactive.isEmpty());
                .put(ConcurrencyLimitSettings.SETTING_PREFIX + "search.partition.resolver", "byHeader")
            .put(ConcurrencyLimitSettings.SETTING_PREFIX + "search.limit.initial", 1)
        ActionConcurrencyLimiterRegistry registry = newRegistry(initial, cs);
import java.util.Set;
        IllegalArgumentException e = expectThrows(
            )
                    .build()
        ClusterSettings cs = clusterSettings(initial);
        final List<String> inactive = new ArrayList<>();
        assertEquals(2, registry.getStats().getSnapshots().size());
        );
                    .put(ConcurrencyLimitSettings.SETTING_PREFIX + "search.partition.standard.percent", 0.5)
            () -> cs.applySettings(
                    .putList(ConcurrencyLimitSettings.SETTING_PREFIX + "search.partitions", "premium")
        );
            )
    public void testStatsAlias() {
    }
        AcquireResult t1 = registry.tryAcquire("indices:data/read/search", null, null);
        // Warmup is 0s so it's already expired — limiter should reject
        ClusterSettings cs = clusterSettings(initial);
            IllegalArgumentException.class,
        ClusterSettings cs = clusterSettings(initial);
        assertTrue(rootCauseMessage(e), rootCauseMessage(e).contains("baseline_reset_load_threshold must be in [0.0, 1.0]"));
        assertTrue("limiter is active again after re-enabling", registry.hasLimiterFor("indices:data/read/search"));
        ClusterSettings cs = clusterSettings(initial);
                    .putList(ConcurrencyLimitSettings.SETTING_PREFIX + "search.partitions", "premium", "standard")
            )
        assertEquals(1, listener.active.size());
        cs.applySettings(
 * The OpenSearch Contributors require contributions made to
    }
        Settings s = Settings.builder()
        Settings initial = enabled("search", "indices:data/read/search");
        // Third should be rejected (not pass-through via warmup restart)
        assertTrue(bulkToken.isAcquired());
                    .putList(ConcurrencyLimitSettings.SETTING_PREFIX + "search.partitions", "premium")
        ActionConcurrencyLimiterRegistry registry = newRegistry(s, clusterSettings(s));
