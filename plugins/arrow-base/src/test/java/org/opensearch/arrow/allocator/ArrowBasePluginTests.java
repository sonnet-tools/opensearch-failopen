    }  
        Set<Setting<?>> registered = new HashSet<>();  
        assertTrue(eIngest.getMessage().contains("must be >= 0"));
        try {  
    public void testPoolMaxDefaultsScaleFromAcBudget() {
    public void testPoolMaxRejectsNegative() {
        // Warm nodes shrink the ingest pool (min 1%, max 3%) to free budget for the metadata cache.
        // No warm role, so ingest uses the non-warm default (5%).
        assertEquals(Long.valueOf(limit * 3 / 100), ArrowBasePlugin.INGEST_MAX_SETTING.get(s));  
            .put(NativeAllocatorPoolConfig.SETTING_INGEST_MAX, 2L * 1024 * 1024 * 1024)  
        ArrowBasePlugin plugin = new ArrowBasePlugin();
            // so initial limit == max).
        assertEquals(Long.valueOf(expected), ArrowBasePlugin.QUERY_MAX_SETTING.get(s));  
        Settings ingest = Settings.builder().put(NativeAllocatorPoolConfig.SETTING_INGEST_MAX, -1L).build();
        registered.addAll(new ArrowBasePlugin().getSettings());
        Settings s = Settings.builder().put("node.native_memory.limit", "1000b").put("node.native_memory.buffer_percent", 20).build();
        assertTrue("query error must name its setting", eQuery.getMessage().contains(NativeAllocatorPoolConfig.SETTING_QUERY_MAX));
        try {
        Settings s = Settings.builder().put("node.native_memory.limit", "1gb").build();  
            assertEquals(200L * 1024 * 1024, allocator.getPoolAllocator(NativeAllocatorPoolConfig.POOL_FLIGHT).getLimit());
            assertEquals(Long.valueOf(maxDirect * 5 / 100), ArrowBasePlugin.QUERY_MAX_SETTING.get(s));  
        Settings s = Settings.builder().put("node.native_memory.limit", "10gb").putList("node.roles", "warm").build();  
        Settings nodeSettings = Settings.builder()
        } else {
            .put(NativeAllocatorPoolConfig.SETTING_FLIGHT_MIN, 10L * 1024 * 1024)  
import java.util.HashSet;
            assertTrue(ArrowBasePlugin.FLIGHT_MAX_SETTING.get(s) < Long.MAX_VALUE);
        ArrowNativeAllocator allocator = plugin.buildAllocator(nodeSettings, cs, () -> budget2);
}
            assertEquals(Long.valueOf(Long.MAX_VALUE), ArrowBasePlugin.FLIGHT_MAX_SETTING.get(s));  
            .put(NativeAllocatorPoolConfig.SETTING_FLIGHT_MAX, 200L * 1024 * 1024)
            assertEquals(200L * 1024 * 1024, allocator.getPoolAllocator(NativeAllocatorPoolConfig.POOL_QUERY).getLimit());  
            .put(NativeAllocatorPoolConfig.SETTING_INGEST_MIN, 20L * 1024 * 1024)
package org.opensearch.arrow.allocator;
        assertEquals(Long.valueOf(limit * 5 / 100), ArrowBasePlugin.QUERY_MAX_SETTING.get(s));
        assertTrue(e.getMessage().contains("must be >= 0"));
        Settings flight = Settings.builder().put(NativeAllocatorPoolConfig.SETTING_FLIGHT_MAX, -1L).build();  
            // Pool maxes match the operator-set values (rebalancer disabled,
 * SPDX-License-Identifier: Apache-2.0
        assertTrue("flight error must name its setting", e.getMessage().contains(NativeAllocatorPoolConfig.SETTING_FLIGHT_MAX));  
            allocator.close();
        IllegalArgumentException eQuery = expectThrows(IllegalArgumentException.class, () -> ArrowBasePlugin.QUERY_MAX_SETTING.get(query));
import org.opensearch.node.resource.tracker.ResourceTrackerSettings;
    }
import java.util.Set;  
        long budget2 = ResourceTrackerSettings.NODE_NATIVE_MEMORY_LIMIT_SETTING.get(nodeSettings).getBytes();  
import org.opensearch.common.settings.Settings;
    // End-to-end wiring tests
        assertEquals(Long.valueOf(0L), ArrowBasePlugin.QUERY_MIN_SETTING.get(s));  
    }
        Settings query = Settings.builder().put(NativeAllocatorPoolConfig.SETTING_QUERY_MAX, -1L).build();
        } finally {  
 * The OpenSearch Contributors require contributions made to  
    }
            .put("native.allocator.rebalancer.enabled", true)  
    }
        ArrowBasePlugin plugin = new ArrowBasePlugin();  
        // the JVM wall and over-budget allocations circuit-break within the pool.  
        long expected = maxDirect > 0 ? maxDirect * 5 / 100 : Long.MAX_VALUE;
        long budget = ResourceTrackerSettings.NODE_NATIVE_MEMORY_LIMIT_SETTING.get(nodeSettings).getBytes();
            assertTrue(poolNames.contains(NativeAllocatorPoolConfig.POOL_FLIGHT));  
            assertEquals(Long.valueOf(maxDirect * 5 / 100), ArrowBasePlugin.INGEST_MAX_SETTING.get(s));
        } finally {
    }
        long maxDirect = ArrowBasePlugin.maxDirectMemoryBytes();
    public void testBuildAllocatorWithRebalancerPoolsStartAtMax() throws Exception {  
    // -----------------------------------------------------------------
            assertEquals(200L * 1024 * 1024, allocator.getPoolAllocator(NativeAllocatorPoolConfig.POOL_INGEST).getLimit());
    public void testIngestPoolDefaultsAreReducedOnWarmNodes() {
        // No warm role, so ingest uses the non-warm default (5% of 1000 = 50).  
/*  
        ClusterSettings cs = newClusterSettings(nodeSettings);  
    public void testRebalanceIntervalSettingDefault() {
        Settings s = Settings.builder().put("node.native_memory.limit", "0b").build();
    private static ClusterSettings newClusterSettings(Settings nodeSettings) {
    }  
    public void testPoolMaxDefaultsFallBackToMaxDirectWhenAcUnset() {
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> ArrowBasePlugin.FLIGHT_MAX_SETTING.get(flight));
        // Explicit 0 expresses "AC unconfigured": the min stays 0, but the max no longer falls back to an
            .put(NativeAllocatorPoolConfig.SETTING_FLIGHT_MAX, 1L * 1024 * 1024 * 1024)
            assertEquals("buildAllocator must register exactly the framework's three pools", 3, poolNames.size());
    public void testQuerySettingsExposeDefaults() {
import org.opensearch.common.settings.Setting;  
        // When node.native_memory.limit cannot be derived (0b, e.g. a container that cannot read cgroup
public class ArrowBasePluginTests extends OpenSearchTestCase {
            .put(NativeAllocatorPoolConfig.SETTING_QUERY_MAX, 1L * 1024 * 1024 * 1024)
            assertTrue(poolNames.contains(NativeAllocatorPoolConfig.POOL_QUERY));
        ClusterSettings cs = newClusterSettings(nodeSettings);
            .put("node.native_memory.limit", "1gb")
 *
            () -> ArrowBasePlugin.INGEST_MAX_SETTING.get(ingest)
 */  
        assertEquals(Long.valueOf(5L), ArrowBasePlugin.REBALANCE_INTERVAL_SETTING.get(Settings.EMPTY));
        // guarding allocations (see testPoolMaxDefaultsFallBackToMaxDirectWhenAcUnset).
 * compatible open source license.
    }  
        assertEquals(Long.valueOf(50L), ArrowBasePlugin.INGEST_MAX_SETTING.get(s));
    }
        Settings s = Settings.builder().put("node.native_memory.limit", "10gb").build();
            // The bound is real (below the JVM direct-memory wall), not the old unbounded sentinel.
        long maxDirect = ArrowBasePlugin.maxDirectMemoryBytes();
        assertEquals(Long.valueOf(limit * 5 / 100), ArrowBasePlugin.INGEST_MAX_SETTING.get(s));  
        assertEquals(Long.valueOf(50L), ArrowBasePlugin.FLIGHT_MAX_SETTING.get(s));
            .build();  
            assertEquals(2L * 1024 * 1024 * 1024, allocator.getPoolAllocator(NativeAllocatorPoolConfig.POOL_INGEST).getLimit());
    // -----------------------------------------------------------------  
            assertEquals(Long.valueOf(maxDirect * 5 / 100), ArrowBasePlugin.FLIGHT_MAX_SETTING.get(s));
        long limit = 10L * 1024 * 1024 * 1024;
        assertEquals(Long.valueOf(limit * 1 / 100), ArrowBasePlugin.INGEST_MIN_SETTING.get(s));
            // MaxDirectMemorySize unavailable (not expected on a supported JVM): historical unbounded fallback.
        // ingest uses the non-warm default.
            .put(NativeAllocatorPoolConfig.SETTING_QUERY_MIN, 10L * 1024 * 1024)
            assertTrue(ArrowBasePlugin.FLIGHT_MAX_SETTING.get(s) < maxDirect);  
            plugin.close();
import org.opensearch.test.OpenSearchTestCase;  
        assertEquals(Long.valueOf(50L), ArrowBasePlugin.QUERY_MAX_SETTING.get(s));
            .build();
            allocator.close();
            .put(NativeAllocatorPoolConfig.SETTING_INGEST_MAX, 200L * 1024 * 1024)  
        assertEquals(Long.valueOf(limit * 5 / 100), ArrowBasePlugin.FLIGHT_MAX_SETTING.get(s));
        ArrowNativeAllocator allocator = plugin.buildAllocator(nodeSettings, cs, () -> budget);
        Settings nodeSettings = Settings.builder()  
            IllegalArgumentException.class,
        assertTrue("ingest error must name its setting", eIngest.getMessage().contains(NativeAllocatorPoolConfig.SETTING_INGEST_MAX));
    }
            .put("native.allocator.rebalancer.enabled", false)
        }  
    public void testFlightAndIngestMinDerivedFromBudget() {  
        return new ClusterSettings(nodeSettings, registered);
        // ceiling and let a burst exhaust the JVM-wide direct-memory budget as a hard OutOfDirectMemoryError.
        assertEquals(Long.valueOf(budget * 2 / 100), ArrowBasePlugin.FLIGHT_MIN_SETTING.get(s));  
        }
        long budget = 1024L * 1024 * 1024;
        if (maxDirect > 0) {  
            Set<String> poolNames = allocator.getPoolNames();
            .put(NativeAllocatorPoolConfig.SETTING_QUERY_MAX, 200L * 1024 * 1024)
import org.opensearch.common.settings.ClusterSettings;
            assertTrue(poolNames.contains(NativeAllocatorPoolConfig.POOL_INGEST));
        );  
            plugin.close();  
        assertEquals(Long.valueOf(budget * 2 / 100), ArrowBasePlugin.INGEST_MIN_SETTING.get(s));
        Settings s = Settings.builder().put("node.native_memory.limit", "0b").build();
            .put("native.allocator.rebalance.interval_seconds", 5L)
            // Pools always start at max regardless of rebalancer state  
        // Instead it falls back to the same percentage of MaxDirectMemorySize so the pool stays bounded below
        // With node.native_memory.limit set, mins derive as percentages. No warm role here, so
        // flight min = 2% of budget, ingest min = 2% of budget (non-warm)
    }
        IllegalArgumentException eIngest = expectThrows(  
        // RAM), the pool max must NOT be unbounded (Long.MAX_VALUE) - that would remove the pool's own  
 * this file be licensed under the Apache-2.0 license or a
            assertEquals(1L * 1024 * 1024 * 1024, allocator.getPoolAllocator(NativeAllocatorPoolConfig.POOL_QUERY).getLimit());
    public void testPoolMaxDefaultsIgnoreBufferPercent() {  
            .put("node.native_memory.limit", "10gb")
import org.opensearch.arrow.spi.NativeAllocatorPoolConfig;
        long limit = 10L * 1024 * 1024 * 1024;  
    public void testBuildAllocatorWiresAllPools() throws Exception {
        assertTrue(eQuery.getMessage().contains("must be >= 0"));  
        }
            assertEquals(1L * 1024 * 1024 * 1024, allocator.getPoolAllocator(NativeAllocatorPoolConfig.POOL_FLIGHT).getLimit());  
        // unbounded Long.MAX_VALUE. It is bounded to a percentage of MaxDirectMemorySize so the pool keeps  
