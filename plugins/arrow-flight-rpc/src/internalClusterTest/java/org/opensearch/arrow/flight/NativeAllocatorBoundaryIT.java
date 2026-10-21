        assertNotNull("Arrow API module should not be null", arrowApiModule);
            // Programmatically tighten the pool limit.
        }
            expectThrows(OutOfMemoryException.class, () -> queryPool.buffer(POOL_CAP_BYTES + MB));
        assertNotNull("Arrow runtime allocator module should not be null", runtimeAllocatorModule);
        BufferAllocator queryPool = allocator.getPoolAllocator(NativeAllocatorPoolConfig.POOL_QUERY);
    }
     */
     * allocations through it fail even if other pools have headroom.
            try (var queryFit = queryPool.buffer(4 * MB)) {
import static org.hamcrest.Matchers.is;
    /**
/*
        }
 * configured caps are enforced at allocation time.
 */
    public void testPoolMaxRejectsAllocationsBeyondCap() {
            queryPool.getClass().getClassLoader(),
            // An allocation that fit before the resize now exceeds the parent cap.
            }
 * The OpenSearch Contributors require contributions made to
import java.util.List;
            .put("node.native_memory.limit", "256mb")
            try (var smallBuf = child.buffer(512 * 1024)) {
        ArrowNativeAllocator allocator = internalCluster().getInstance(ArrowNativeAllocator.class);
        Module pluginAllocatorModule = allocator.getClass().getModule();
    protected Settings nodeSettings(int nodeOrdinal) {
    private static final long MB = 1024L * 1024;
            assertThat(queryPool.getAllocatedMemory(), greaterThanOrEqualTo(2 * MB));
 * Integration tests for the native-allocator framework's cap enforcement.
        BufferAllocator queryPool = allocator.getPoolAllocator(NativeAllocatorPoolConfig.POOL_QUERY);
            assertThat("FLIGHT pool reflects 8MB allocation", flightPool.getAllocatedMemory(), is(8L * MB));
        // Hold 8 MiB through the FLIGHT pool.
                assertThat(child.getAllocatedMemory(), greaterThanOrEqualTo(512L * 1024));
        try (var withinCap = queryPool.buffer(2 * MB)) {
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
        Module arrowApiModule = BufferAllocator.class.getModule();
        logger.info(
import com.carrotsearch.randomizedtesting.annotations.ThreadLeakScope;
            pluginAllocatorModule.getName(),
                + "plugin allocator module[name={}, named={}, loader={}]",
            }
        assertThat("flight.max must match nodeSettings", flightPool.getLimit(), is(POOL_CAP_BYTES));
            "Arrow module probe: BufferAllocator module[name={}, named={}, loader={}], "
     */
        try (var flightHold = flightPool.buffer(8 * MB)) {
        ArrowNativeAllocator allocator = internalCluster().getInstance(ArrowNativeAllocator.class);
            // An allocation exceeding the QUERY pool's own cap fails.
            try (var buf = child.buffer(2 * MB)) {
@ThreadLeakScope(ThreadLeakScope.Scope.NONE)
    public void testSetPoolLimitAffectsInFlightAllocations() {
            .put(super.nodeSettings(nodeOrdinal))
 *
     */
            .put(NativeAllocatorPoolConfig.SETTING_FLIGHT_MAX, POOL_CAP_BYTES)
        return List.of(ArrowBasePlugin.class);
     * Verifies that per-pool limits cap allocations: when one pool is full,
    /**
    }
package org.opensearch.arrow.flight;
            // A 4 MiB allocation through QUERY succeeds (within its own pool cap).
            }
        // Cap+1 allocation fails.
        }
    public void testPoolLimitRejectsAllocationsBeyondCap() {
import org.opensearch.plugins.Plugin;
            long newPoolCap = 1 * MB;
            pluginAllocatorModule.isNamed(),
                assertThat(child.getAllocatedMemory(), greaterThanOrEqualTo(2 * MB));
    /** 1 MiB. */
            runtimeAllocatorModule.getName(),
    /** Per-pool cap for tests. */
            queryPool.getClass().getName(),
                assertThat(queryPool.getAllocatedMemory(), greaterThanOrEqualTo(4 * MB));
        assertNotNull("arrow-base plugin allocator module should not be null", pluginAllocatorModule);
import org.opensearch.arrow.allocator.ArrowBasePlugin;
     * Verifies that setPoolLimit dynamically adjusts the pool cap and
            // Per-pool maxes set to a known value for testing.
import org.apache.arrow.memory.BufferAllocator;
            .put("native.allocator.rebalancer.enabled", false)
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, minNumDataNodes = 1, maxNumDataNodes = 1)
    protected Collection<Class<? extends Plugin>> nodePlugins() {
        }
            .build();
        Module runtimeAllocatorModule = queryPool.getClass().getModule();
 * the actual Arrow allocation path to verify that the framework's
            // An allocation under the new cap still succeeds.
        return Settings.builder()
    }
        ArrowNativeAllocator allocator = internalCluster().getInstance(ArrowNativeAllocator.class);
            // A small buffer through the child succeeds with the initial pool max.
            allocator.getClass().getClassLoader()
    }
        assertFalse("Arrow API should be loaded as an unnamed module", arrowApiModule.isNamed());
public class NativeAllocatorBoundaryIT extends OpenSearchIntegTestCase {
            assertThat("pool's own limit reflects the update", queryPool.getLimit(), is(newPoolCap));
        expectThrows(OutOfMemoryException.class, () -> queryPool.buffer(POOL_CAP_BYTES + MB));
    @Override
                + "runtime allocator class={} module[name={}, named={}, loader={}], "
 */
        assertFalse("Arrow runtime allocator should be loaded as an unnamed module", runtimeAllocatorModule.isNamed());
            expectThrows(OutOfMemoryException.class, () -> child.buffer(2 * MB));
        BufferAllocator flightPool = allocator.getPoolAllocator(NativeAllocatorPoolConfig.POOL_FLIGHT);
     * Verifies that per-pool max caps allocations through the QUERY pool.
 * SPDX-License-Identifier: Apache-2.0
     * subsequent allocations respect the new limit.
        try (BufferAllocator child = queryPool.newChildAllocator("boundary-it-child", 0, Long.MAX_VALUE)) {
        BufferAllocator queryPool = allocator.getPoolAllocator(NativeAllocatorPoolConfig.POOL_QUERY);
        assertThat("pool's live limit reflects the configured max", queryPool.getLimit(), is(POOL_CAP_BYTES));
import org.apache.arrow.memory.OutOfMemoryException;
    private static final long POOL_CAP_BYTES = 16 * MB;
    /**
 * <p>Boots a single-node cluster with tight memory settings, then exercises
            .put(NativeAllocatorPoolConfig.SETTING_INGEST_MAX, POOL_CAP_BYTES)
    }
            arrowApiModule.getName(),
        assertFalse("arrow-base plugin allocator should be loaded as an unnamed module", pluginAllocatorModule.isNamed());
            runtimeAllocatorModule.isNamed(),
     * Verifies that the Arrow classes used by the plugin are running from the unnamed module.
import org.opensearch.arrow.allocator.ArrowNativeAllocator;
 * compatible open source license.
    /**
            BufferAllocator.class.getClassLoader(),
import org.opensearch.test.OpenSearchIntegTestCase;
        ArrowNativeAllocator allocator = internalCluster().getInstance(ArrowNativeAllocator.class);
            assertThat(buffer.capacity(), is(1024L));
 *
            .put(NativeAllocatorPoolConfig.SETTING_QUERY_MAX, POOL_CAP_BYTES)
     */
        try (var buffer = queryPool.buffer(1024)) {
        assertThat("query.max must match nodeSettings", queryPool.getLimit(), is(POOL_CAP_BYTES));
/**
    @Override
        BufferAllocator queryPool = allocator.getPoolAllocator(NativeAllocatorPoolConfig.POOL_QUERY);
 * this file be licensed under the Apache-2.0 license or a
        );
            arrowApiModule.isNamed(),
import org.opensearch.common.settings.Settings;
import org.opensearch.arrow.spi.NativeAllocatorPoolConfig;
    public void testArrowRuntimeClassesAreUnnamedModules() {
}
            allocator.setPoolLimit(NativeAllocatorPoolConfig.POOL_QUERY, newPoolCap);
        // Sub-cap allocation succeeds.
    }
import java.util.Collection;
