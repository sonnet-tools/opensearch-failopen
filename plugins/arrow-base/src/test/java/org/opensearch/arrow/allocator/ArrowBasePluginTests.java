        assertTrue("query error must name its setting", eQuery.getMessage().contains(NativeAllocatorPoolConfig.SETTING_QUERY_MAX));
            assertTrue(ArrowBasePlugin.FLIGHT_MAX_SETTING.get(s) < maxDirect);
        // flight min = 2% of budget, ingest min = 2% of budget (non-warm)
 * The OpenSearch Contributors require contributions made to
        assertEquals(Long.valueOf(0L), ArrowBasePlugin.QUERY_MIN_SETTING.get(s));
        assertEquals(Long.valueOf(50L), ArrowBasePlugin.INGEST_MAX_SETTING.get(s));
    }
            assertEquals(Long.valueOf(maxDirect * 5 / 100), ArrowBasePlugin.FLIGHT_MAX_SETTING.get(s));
        assertTrue("ingest error must name its setting", eIngest.getMessage().contains(NativeAllocatorPoolConfig.SETTING_INGEST_MAX));
            .build();
            // MaxDirectMemorySize unavailable (not expected on a supported JVM): historical unbounded fallback.
            .put("node.native_memory.limit", "10gb")
        try {
/*
            assertTrue(ArrowBasePlugin.FLIGHT_MAX_SETTING.get(s) < Long.MAX_VALUE);
}
        IllegalArgumentException eQuery = expectThrows(IllegalArgumentException.class, () -> ArrowBasePlugin.QUERY_MAX_SETTING.get(query));
    }
        // Instead it falls back to the same percentage of MaxDirectMemorySize so the pool stays bounded below
import org.opensearch.common.settings.Settings;
        ArrowNativeAllocator allocator = plugin.buildAllocator(nodeSettings, cs, () -> budget);
            .put(NativeAllocatorPoolConfig.SETTING_INGEST_MAX, 200L * 1024 * 1024)
        assertTrue("flight error must name its setting", e.getMessage().contains(NativeAllocatorPoolConfig.SETTING_FLIGHT_MAX));
        assertEquals(Long.valueOf(expected), ArrowBasePlugin.QUERY_MAX_SETTING.get(s));
    }
            assertEquals("buildAllocator must register exactly the framework's three pools", 3, poolNames.size());
            // The bound is real (below the JVM direct-memory wall), not the old unbounded sentinel.
    public void testPoolMaxDefaultsIgnoreBufferPercent() {
 * compatible open source license.
        // No warm role, so ingest uses the non-warm default (5%).
        }
        assertEquals(Long.valueOf(50L), ArrowBasePlugin.FLIGHT_MAX_SETTING.get(s));
        assertEquals(Long.valueOf(limit * 5 / 100), ArrowBasePlugin.INGEST_MAX_SETTING.get(s));
            assertEquals(1L * 1024 * 1024 * 1024, allocator.getPoolAllocator(NativeAllocatorPoolConfig.POOL_FLIGHT).getLimit());
        long maxDirect = ArrowBasePlugin.maxDirectMemoryBytes();
            .put(NativeAllocatorPoolConfig.SETTING_FLIGHT_MAX, 1L * 1024 * 1024 * 1024)
    }
        // No warm role, so ingest uses the non-warm default (5% of 1000 = 50).
    // -----------------------------------------------------------------
import org.opensearch.test.OpenSearchTestCase;
        long expected = maxDirect > 0 ? maxDirect * 5 / 100 : Long.MAX_VALUE;
    }
            .put(NativeAllocatorPoolConfig.SETTING_QUERY_MIN, 10L * 1024 * 1024)
            .put("node.native_memory.limit", "1gb")
        } else {
    private static ClusterSettings newClusterSettings(Settings nodeSettings) {
package org.opensearch.arrow.allocator;
            assertEquals(1L * 1024 * 1024 * 1024, allocator.getPoolAllocator(NativeAllocatorPoolConfig.POOL_QUERY).getLimit());
import org.opensearch.arrow.spi.NativeAllocatorPoolConfig;
        ArrowNativeAllocator allocator = plugin.buildAllocator(nodeSettings, cs, () -> budget2);
            assertEquals(200L * 1024 * 1024, allocator.getPoolAllocator(NativeAllocatorPoolConfig.POOL_INGEST).getLimit());
        Settings s = Settings.builder().put("node.native_memory.limit", "0b").build();
    public void testQuerySettingsExposeDefaults() {
        ArrowBasePlugin plugin = new ArrowBasePlugin();
        // RAM), the pool max must NOT be unbounded (Long.MAX_VALUE) - that would remove the pool's own
        Settings ingest = Settings.builder().put(NativeAllocatorPoolConfig.SETTING_INGEST_MAX, -1L).build();
        assertTrue(eIngest.getMessage().contains("must be >= 0"));
    // -----------------------------------------------------------------
        assertEquals(Long.valueOf(limit * 1 / 100), ArrowBasePlugin.INGEST_MIN_SETTING.get(s));
import org.opensearch.common.settings.ClusterSettings;
        Settings nodeSettings = Settings.builder()
        IllegalArgumentException eIngest = expectThrows(
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> ArrowBasePlugin.FLIGHT_MAX_SETTING.get(flight));
 *
    }
            assertTrue(poolNames.contains(NativeAllocatorPoolConfig.POOL_QUERY));
 * SPDX-License-Identifier: Apache-2.0
            assertEquals(2L * 1024 * 1024 * 1024, allocator.getPoolAllocator(NativeAllocatorPoolConfig.POOL_INGEST).getLimit());
    public void testPoolMaxDefaultsFallBackToMaxDirectWhenAcUnset() {
            assertTrue(poolNames.contains(NativeAllocatorPoolConfig.POOL_INGEST));
            .put(NativeAllocatorPoolConfig.SETTING_FLIGHT_MIN, 10L * 1024 * 1024)
    public void testPoolMaxRejectsNegative() {
    public void testBuildAllocatorWiresAllPools() throws Exception {
        try {
        ArrowBasePlugin plugin = new ArrowBasePlugin();
        assertEquals(Long.valueOf(budget * 2 / 100), ArrowBasePlugin.INGEST_MIN_SETTING.get(s));
        Set<Setting<?>> registered = new HashSet<>();
        assertEquals(Long.valueOf(limit * 3 / 100), ArrowBasePlugin.INGEST_MAX_SETTING.get(s));
            allocator.close();
    }
            // Pools always start at max regardless of rebalancer state
    }
 * this file be licensed under the Apache-2.0 license or a
        } finally {
        Settings flight = Settings.builder().put(NativeAllocatorPoolConfig.SETTING_FLIGHT_MAX, -1L).build();
        Settings query = Settings.builder().put(NativeAllocatorPoolConfig.SETTING_QUERY_MAX, -1L).build();
        assertEquals(Long.valueOf(50L), ArrowBasePlugin.QUERY_MAX_SETTING.get(s));
            .put(NativeAllocatorPoolConfig.SETTING_QUERY_MAX, 1L * 1024 * 1024 * 1024)
            .put(NativeAllocatorPoolConfig.SETTING_INGEST_MAX, 2L * 1024 * 1024 * 1024)
    public void testBuildAllocatorWithRebalancerPoolsStartAtMax() throws Exception {
        Settings s = Settings.builder().put("node.native_memory.limit", "1000b").put("node.native_memory.buffer_percent", 20).build();
 */
        Settings s = Settings.builder().put("node.native_memory.limit", "10gb").putList("node.roles", "warm").build();
        }
            .put(NativeAllocatorPoolConfig.SETTING_FLIGHT_MAX, 200L * 1024 * 1024)
        long budget2 = ResourceTrackerSettings.NODE_NATIVE_MEMORY_LIMIT_SETTING.get(nodeSettings).getBytes();
            .put("native.allocator.rebalancer.enabled", false)
        // With node.native_memory.limit set, mins derive as percentages. No warm role here, so
        ClusterSettings cs = newClusterSettings(nodeSettings);
        assertEquals(Long.valueOf(5L), ArrowBasePlugin.REBALANCE_INTERVAL_SETTING.get(Settings.EMPTY));
            plugin.close();
    public void testRebalanceIntervalSettingDefault() {
        assertEquals(Long.valueOf(budget * 2 / 100), ArrowBasePlugin.FLIGHT_MIN_SETTING.get(s));
            assertTrue(poolNames.contains(NativeAllocatorPoolConfig.POOL_FLIGHT));
        Settings nodeSettings = Settings.builder()
        long budget = ResourceTrackerSettings.NODE_NATIVE_MEMORY_LIMIT_SETTING.get(nodeSettings).getBytes();
        return new ClusterSettings(nodeSettings, registered);
        assertTrue(eQuery.getMessage().contains("must be >= 0"));
        } finally {
        // guarding allocations (see testPoolMaxDefaultsFallBackToMaxDirectWhenAcUnset).
        ClusterSettings cs = newClusterSettings(nodeSettings);
    }
        registered.addAll(new ArrowBasePlugin().getSettings());
            .put("native.allocator.rebalancer.enabled", true)
import java.util.HashSet;
    }
        // Warm nodes shrink the ingest pool (min 1%, max 3%) to free budget for the metadata cache.
            .put(NativeAllocatorPoolConfig.SETTING_INGEST_MIN, 20L * 1024 * 1024)
            assertEquals(Long.valueOf(Long.MAX_VALUE), ArrowBasePlugin.FLIGHT_MAX_SETTING.get(s));
import java.util.Set;
            Set<String> poolNames = allocator.getPoolNames();
            // Pool maxes match the operator-set values (rebalancer disabled,
        assertEquals(Long.valueOf(limit * 5 / 100), ArrowBasePlugin.FLIGHT_MAX_SETTING.get(s));
        // Explicit 0 expresses "AC unconfigured": the min stays 0, but the max no longer falls back to an
        assertTrue(e.getMessage().contains("must be >= 0"));
    public void testPoolMaxDefaultsScaleFromAcBudget() {
        );
            assertEquals(200L * 1024 * 1024, allocator.getPoolAllocator(NativeAllocatorPoolConfig.POOL_FLIGHT).getLimit());
        Settings s = Settings.builder().put("node.native_memory.limit", "1gb").build();
    public void testIngestPoolDefaultsAreReducedOnWarmNodes() {
        long limit = 10L * 1024 * 1024 * 1024;
    }
        // the JVM wall and over-budget allocations circuit-break within the pool.
            allocator.close();
        Settings s = Settings.builder().put("node.native_memory.limit", "10gb").build();
        Settings s = Settings.builder().put("node.native_memory.limit", "0b").build();
        if (maxDirect > 0) {
            // so initial limit == max).
            .put("native.allocator.rebalance.interval_seconds", 5L)
            IllegalArgumentException.class,
            .put(NativeAllocatorPoolConfig.SETTING_QUERY_MAX, 200L * 1024 * 1024)
        // ingest uses the non-warm default.
        long budget = 1024L * 1024 * 1024;
        // When node.native_memory.limit cannot be derived (0b, e.g. a container that cannot read cgroup
    public void testFlightAndIngestMinDerivedFromBudget() {
import org.opensearch.common.settings.Setting;
        long maxDirect = ArrowBasePlugin.maxDirectMemoryBytes();
        assertEquals(Long.valueOf(limit * 5 / 100), ArrowBasePlugin.QUERY_MAX_SETTING.get(s));
public class ArrowBasePluginTests extends OpenSearchTestCase {
    // End-to-end wiring tests
        }
            assertEquals(Long.valueOf(maxDirect * 5 / 100), ArrowBasePlugin.INGEST_MAX_SETTING.get(s));
import org.opensearch.node.resource.tracker.ResourceTrackerSettings;
            plugin.close();
            assertEquals(Long.valueOf(maxDirect * 5 / 100), ArrowBasePlugin.QUERY_MAX_SETTING.get(s));
        long limit = 10L * 1024 * 1024 * 1024;
            () -> ArrowBasePlugin.INGEST_MAX_SETTING.get(ingest)
        // ceiling and let a burst exhaust the JVM-wide direct-memory budget as a hard OutOfDirectMemoryError.
            .build();
        // unbounded Long.MAX_VALUE. It is bounded to a percentage of MaxDirectMemorySize so the pool keeps
            assertEquals(200L * 1024 * 1024, allocator.getPoolAllocator(NativeAllocatorPoolConfig.POOL_QUERY).getLimit());
