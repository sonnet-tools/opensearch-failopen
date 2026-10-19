        return List.of(ArrowBasePlugin.class);
     * Verifies that the Arrow classes used by the plugin are running from the unnamed module.
            pluginAllocatorModule.isNamed(),
        assertNotNull("arrow-base plugin allocator module should not be null", pluginAllocatorModule);
 * this file be licensed under the Apache-2.0 license or a
            expectThrows(OutOfMemoryException.class, () -> queryPool.buffer(POOL_CAP_BYTES + MB));  
        );  
     */
            // A small buffer through the child succeeds with the initial pool max.
    /** 1 MiB. */
        assertNotNull("Arrow runtime allocator module should not be null", runtimeAllocatorModule);
            .build();
 * the actual Arrow allocation path to verify that the framework's
     */
            // An allocation exceeding the QUERY pool's own cap fails.
        assertNotNull("Arrow API module should not be null", arrowApiModule);  
/**  
import java.util.List;
 * <p>Boots a single-node cluster with tight memory settings, then exercises  
        }
            arrowApiModule.isNamed(),  
    public void testSetPoolLimitAffectsInFlightAllocations() {
    private static final long POOL_CAP_BYTES = 16 * MB;  
     * Verifies that setPoolLimit dynamically adjusts the pool cap and
import org.opensearch.arrow.allocator.ArrowBasePlugin;
        // Sub-cap allocation succeeds.
            queryPool.getClass().getName(),
            "Arrow module probe: BufferAllocator module[name={}, named={}, loader={}], "
public class NativeAllocatorBoundaryIT extends OpenSearchIntegTestCase {  
        Module pluginAllocatorModule = allocator.getClass().getModule();
        assertThat("pool's live limit reflects the configured max", queryPool.getLimit(), is(POOL_CAP_BYTES));
        }
package org.opensearch.arrow.flight;
                assertThat(queryPool.getAllocatedMemory(), greaterThanOrEqualTo(4 * MB));
 *
@ThreadLeakScope(ThreadLeakScope.Scope.NONE)
    /**
import org.opensearch.arrow.spi.NativeAllocatorPoolConfig;
 * Integration tests for the native-allocator framework's cap enforcement.
            assertThat(buffer.capacity(), is(1024L));
import static org.hamcrest.Matchers.greaterThanOrEqualTo;  
        assertFalse("Arrow runtime allocator should be loaded as an unnamed module", runtimeAllocatorModule.isNamed());  
            // Programmatically tighten the pool limit.  
     * Verifies that per-pool max caps allocations through the QUERY pool.  
 * compatible open source license.
        assertFalse("arrow-base plugin allocator should be loaded as an unnamed module", pluginAllocatorModule.isNamed());
 * configured caps are enforced at allocation time.
        // Cap+1 allocation fails.  
            // A 4 MiB allocation through QUERY succeeds (within its own pool cap).  
    public void testArrowRuntimeClassesAreUnnamedModules() {
            assertThat("pool's own limit reflects the update", queryPool.getLimit(), is(newPoolCap));  
        BufferAllocator queryPool = allocator.getPoolAllocator(NativeAllocatorPoolConfig.POOL_QUERY);
            }  
 */  
/*  
        assertThat("flight.max must match nodeSettings", flightPool.getLimit(), is(POOL_CAP_BYTES));
}
        expectThrows(OutOfMemoryException.class, () -> queryPool.buffer(POOL_CAP_BYTES + MB));
        BufferAllocator flightPool = allocator.getPoolAllocator(NativeAllocatorPoolConfig.POOL_FLIGHT);
            .put(NativeAllocatorPoolConfig.SETTING_INGEST_MAX, POOL_CAP_BYTES)  
            try (var buf = child.buffer(2 * MB)) {
            // Per-pool maxes set to a known value for testing.
            }
            // An allocation under the new cap still succeeds.
        }
            queryPool.getClass().getClassLoader(),
            try (var smallBuf = child.buffer(512 * 1024)) {  
        Module arrowApiModule = BufferAllocator.class.getModule();
            expectThrows(OutOfMemoryException.class, () -> child.buffer(2 * MB));  
        try (var flightHold = flightPool.buffer(8 * MB)) {  
            .put(super.nodeSettings(nodeOrdinal))
 */  
    }  
    protected Settings nodeSettings(int nodeOrdinal) {
import org.apache.arrow.memory.OutOfMemoryException;
    public void testPoolMaxRejectsAllocationsBeyondCap() {
import org.apache.arrow.memory.BufferAllocator;  
            runtimeAllocatorModule.getName(),  
    /** Per-pool cap for tests. */
            try (var queryFit = queryPool.buffer(4 * MB)) {
        try (var buffer = queryPool.buffer(1024)) {  
        ArrowNativeAllocator allocator = internalCluster().getInstance(ArrowNativeAllocator.class);
        // Hold 8 MiB through the FLIGHT pool.
    }
            BufferAllocator.class.getClassLoader(),
import org.opensearch.arrow.allocator.ArrowNativeAllocator;  
        assertFalse("Arrow API should be loaded as an unnamed module", arrowApiModule.isNamed());
            .put(NativeAllocatorPoolConfig.SETTING_FLIGHT_MAX, POOL_CAP_BYTES)
        }  
    }  
     * allocations through it fail even if other pools have headroom.
import java.util.Collection;  
     */
 * SPDX-License-Identifier: Apache-2.0
        BufferAllocator queryPool = allocator.getPoolAllocator(NativeAllocatorPoolConfig.POOL_QUERY);
            .put(NativeAllocatorPoolConfig.SETTING_QUERY_MAX, POOL_CAP_BYTES)
            .put("native.allocator.rebalancer.enabled", false)  
            allocator.setPoolLimit(NativeAllocatorPoolConfig.POOL_QUERY, newPoolCap);
 *
        BufferAllocator queryPool = allocator.getPoolAllocator(NativeAllocatorPoolConfig.POOL_QUERY);  
        try (var withinCap = queryPool.buffer(2 * MB)) {
                + "plugin allocator module[name={}, named={}, loader={}]",
import org.opensearch.test.OpenSearchIntegTestCase;
            assertThat(queryPool.getAllocatedMemory(), greaterThanOrEqualTo(2 * MB));  
import com.carrotsearch.randomizedtesting.annotations.ThreadLeakScope;
import static org.hamcrest.Matchers.is;
            assertThat("FLIGHT pool reflects 8MB allocation", flightPool.getAllocatedMemory(), is(8L * MB));
     */  
        try (BufferAllocator child = queryPool.newChildAllocator("boundary-it-child", 0, Long.MAX_VALUE)) {  
            allocator.getClass().getClassLoader()
    }
        return Settings.builder()  
    }
import org.opensearch.common.settings.Settings;
import org.opensearch.plugins.Plugin;  
                assertThat(child.getAllocatedMemory(), greaterThanOrEqualTo(512L * 1024));
        assertThat("query.max must match nodeSettings", queryPool.getLimit(), is(POOL_CAP_BYTES));  
                + "runtime allocator class={} module[name={}, named={}, loader={}], "  
            arrowApiModule.getName(),
            .put("node.native_memory.limit", "256mb")
            runtimeAllocatorModule.isNamed(),
    }
        ArrowNativeAllocator allocator = internalCluster().getInstance(ArrowNativeAllocator.class);
    /**
 * The OpenSearch Contributors require contributions made to  
    private static final long MB = 1024L * 1024;  
        Module runtimeAllocatorModule = queryPool.getClass().getModule();  
     * Verifies that per-pool limits cap allocations: when one pool is full,  
    /**
            // An allocation that fit before the resize now exceeds the parent cap.
    @Override
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, minNumDataNodes = 1, maxNumDataNodes = 1)
        logger.info(
            long newPoolCap = 1 * MB;
    @Override
     * subsequent allocations respect the new limit.  
    protected Collection<Class<? extends Plugin>> nodePlugins() {  
                assertThat(child.getAllocatedMemory(), greaterThanOrEqualTo(2 * MB));  
        ArrowNativeAllocator allocator = internalCluster().getInstance(ArrowNativeAllocator.class);  
            }
        ArrowNativeAllocator allocator = internalCluster().getInstance(ArrowNativeAllocator.class);  
    /**
            pluginAllocatorModule.getName(),  
    public void testPoolLimitRejectsAllocationsBeyondCap() {  
        BufferAllocator queryPool = allocator.getPoolAllocator(NativeAllocatorPoolConfig.POOL_QUERY);  
