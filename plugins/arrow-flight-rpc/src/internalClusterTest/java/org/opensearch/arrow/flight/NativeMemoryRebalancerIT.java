    }  
 * compatible open source license.
        ArrowNativeAllocator allocator = internalCluster().getInstance(ArrowNativeAllocator.class);
import java.util.List;
/**
 * Integration test for the NativeMemoryRebalancer.  
        assertThat("Ingest pool limit should be >= min", limit, org.hamcrest.Matchers.greaterThanOrEqualTo(5 * MB));
import static org.hamcrest.Matchers.lessThanOrEqualTo;  
 * SPDX-License-Identifier: Apache-2.0
    /**
        return Settings.builder()  
            .put(NativeAllocatorPoolConfig.SETTING_QUERY_MIN, 5 * MB)  
 */  
        long max = allocator.getPoolMax(NativeAllocatorPoolConfig.POOL_INGEST);  
/*  
            .build();
public class NativeMemoryRebalancerIT extends OpenSearchIntegTestCase {
            .put("node.native_memory.limit", "1gb")
        } finally {
            .put("native.allocator.rebalance.interval_seconds", 1)  
    /**
    @Override
import org.apache.arrow.memory.ArrowBuf;  
import com.carrotsearch.randomizedtesting.annotations.ThreadLeakScope;
                assertThat("Flight pool should shrink when idle", flightLimit, org.hamcrest.Matchers.lessThan(200 * MB));  
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, minNumDataNodes = 1, maxNumDataNodes = 1)  
        // Allocate > 75% of ingest pool to create pressure
    private static final long MB = 1024L * 1024;  
            .put(NativeAllocatorPoolConfig.SETTING_FLIGHT_MIN, 5 * MB)
                long flightLimit = flightPool.getLimit();
import org.opensearch.plugins.Plugin;  
    protected Settings nodeSettings(int nodeOrdinal) {
import org.opensearch.test.OpenSearchIntegTestCase;
            .put(super.nodeSettings(nodeOrdinal))
     * Verifies that an idle pool shrinks after rebalancer ticks when another pool is pressured.  
package org.opensearch.arrow.flight;
    }
        BufferAllocator ingestPool = allocator.getPoolAllocator(NativeAllocatorPoolConfig.POOL_INGEST);
            .put(NativeAllocatorPoolConfig.SETTING_INGEST_MAX, 200 * MB)
 * The OpenSearch Contributors require contributions made to  
    }
        long toAllocate = (long) (ingestPool.getLimit() * 0.8);
        assertEquals("Ingest pool max should be configured at 200MB", 200 * MB, max);
            // Flight pool is idle — wait for rebalancer to shrink it  
            buf.close();  
 */
            .put(NativeAllocatorPoolConfig.SETTING_FLIGHT_MAX, 200 * MB)  
     */
        return List.of(ArrowBasePlugin.class);
        BufferAllocator flightPool = allocator.getPoolAllocator(NativeAllocatorPoolConfig.POOL_FLIGHT);
    public void testIdlePoolShrinksWhenOtherPressured() throws Exception {
        // The rebalancer may have already run (1s interval), so the pool may have shrunk.
        }
            assertBusy(() -> {
        // Verify it's at least at min and the configured max is correct.
    protected Collection<Class<? extends Plugin>> nodePlugins() {  
        try {
            .put(NativeAllocatorPoolConfig.SETTING_QUERY_MAX, 200 * MB)
            });
import org.apache.arrow.memory.BufferAllocator;
        BufferAllocator ingestPool = allocator.getPoolAllocator(NativeAllocatorPoolConfig.POOL_INGEST);
        long limit = ingestPool.getLimit();  
            .put("native.allocator.rebalancer.enabled", true)
    }  
 * <p>Boots a single-node cluster with the rebalancer enabled and verifies that
}  
 * pools start at their max and the rebalancer shrinks idle pools / grows pressured ones.  
import org.opensearch.common.settings.Settings;
     */
    public void testPoolsStartAtMax() {  
import java.util.Collection;  
 *
            .put(NativeAllocatorPoolConfig.SETTING_INGEST_MIN, 5 * MB)
import org.opensearch.arrow.spi.NativeAllocatorPoolConfig;
        // Pool limit should be between min and max (rebalancer may have shrunk it)
        assertThat("Ingest pool limit should be <= max", limit, lessThanOrEqualTo(200 * MB));
     * Uses a long rebalancer interval to avoid race conditions.
import org.opensearch.arrow.allocator.ArrowNativeAllocator;  
    @Override
@ThreadLeakScope(ThreadLeakScope.Scope.NONE)
 * this file be licensed under the Apache-2.0 license or a
        ArrowNativeAllocator allocator = internalCluster().getInstance(ArrowNativeAllocator.class);  
     * Verifies that pools start at their max (before rebalancer shrinks them).  
        ArrowBuf buf = ingestPool.buffer(toAllocate);  
import org.opensearch.arrow.allocator.ArrowBasePlugin;
 *
