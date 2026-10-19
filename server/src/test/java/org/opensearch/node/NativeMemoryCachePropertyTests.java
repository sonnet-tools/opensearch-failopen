public class NativeMemoryCachePropertyTests extends OpenSearchTestCase {
            // Multiple calls within TTL should return the same reference
                    + refreshCount.get(),
    /**
                    + ", got "
            AtomicInteger refreshCount = new AtomicInteger(0);
import org.opensearch.test.OpenSearchTestCase;
            // Each call should trigger a refresh since TTL is 0
            int callCount = randomIntBetween(2, 10);
                ttl,  
                TimeValue.timeValueSeconds(60),  
     * Within the TTL window, all calls to getOrRefresh() return the same reference.  
            assertEquals("allocatedBytes should match on iteration " + iteration, allocatedBytes, result.getAllocatedBytes());
                cache.getOrRefresh();
import org.opensearch.plugin.stats.AnalyticsBackendNativeMemoryStats;  
    /**  
            );
                TimeValue.timeValueMillis(0),
                assertSame(
            // Force the cache to think it was just refreshed by calling getOrRefresh once
                }
    }
 * The OpenSearch Contributors require contributions made to  
                    return new AnalyticsBackendNativeMemoryStats(  
            ) {
                refreshCount.get() >= callCount  
            }
                "With TTL=0, refresh should be called at least "  
import java.util.concurrent.atomic.AtomicInteger;  
                    "Within TTL, getOrRefresh() should return the same reference on iteration " + iteration + ", call " + i,  
            // With TTL=0, every call should trigger a refresh
                @Override
 * Property-based tests for {@link SingleObjectCache} TTL consistency with AnalyticsBackendNativeMemoryStats.  
/**
                );  
                    );  
    }  
            long allocatedBytes = randomLongBetween(0, Long.MAX_VALUE);  
            // TTL of 0ms means every call triggers a refresh  
                initialStats  
     * <p>
        }  
import org.opensearch.common.util.SingleObjectCache;
            };  
            long residentBytes = randomLongBetween(0, Long.MAX_VALUE);
            long residentBytes = randomLongBetween(-1, Long.MAX_VALUE);
package org.opensearch.node;
            };
        for (int iteration = 0; iteration < 100; iteration++) {
     * <b>Validates: Requirements 7.2, 7.3, 7.4</b>
            assertEquals(
            AnalyticsBackendNativeMemoryStats result = cache.getOrRefresh();  
 * compatible open source license.
            ) {
            }
 *
     * <p>
                        randomLongBetween(0, Long.MAX_VALUE),
    }
                    + " times on iteration "
        for (int iteration = 0; iteration < 100; iteration++) {
            AnalyticsBackendNativeMemoryStats initialStats = new AnalyticsBackendNativeMemoryStats(allocatedBytes, residentBytes, 0);
/*  
     * <b>Validates: Requirements 7.2, 7.3, 7.4</b>  
                refreshCount.get()
}
            int callCount = randomIntBetween(2, 5);
            AtomicInteger refreshCount = new AtomicInteger(0);  
                    refreshCount.incrementAndGet();
        }  
            );
                protected AnalyticsBackendNativeMemoryStats refresh() {  
                }
                        randomLongBetween(0, Long.MAX_VALUE),  
                    );
 */  
                    + callCount
 * For any SearchBackEndPlugin and any TTL duration, all calls to SingleObjectCache.getOrRefresh()
 */  
 * this file be licensed under the Apache-2.0 license or a
     * <p>
    public void testCacheRefreshesAfterTTLExpiry() {
            for (int i = 0; i < callCount; i++) {  
            long allocatedBytes = randomLongBetween(-1, Long.MAX_VALUE);
 * <p>
     * with various random field values.
 * within the TTL window SHALL return the same AnalyticsBackendNativeMemoryStats instance (reference equality),
     * <p>
    public void testCacheReturnsConsistentValueWithinTTL() {
            long residentBytes = randomLongBetween(0, Long.MAX_VALUE);  
                    return expectedStats;
     * <b>Validates: Requirements 7.2, 7.3, 7.4</b>
                        0
                refreshesAfterInit,  
     */  
            SingleObjectCache<AnalyticsBackendNativeMemoryStats> cache = new SingleObjectCache<AnalyticsBackendNativeMemoryStats>(
     */  
                initialStats
 * <b>Validates: Requirements 7.2, 7.3, 7.4</b>
        for (int iteration = 0; iteration < 100; iteration++) {  
            ) {
            long ttlMillis = randomLongBetween(1000, 60000);
                    + iteration  
            // No additional refreshes should have occurred  
     * Property 1: Cache returns consistent value within TTL.
                    return new AnalyticsBackendNativeMemoryStats(
 * <p>  
                protected AnalyticsBackendNativeMemoryStats refresh() {
import org.opensearch.common.unit.TimeValue;
            for (int i = 0; i < callCount; i++) {  
        }
 * <p>
            };
                    result
                    refreshCount.incrementAndGet();
                }  
                expectedStats
     */
     * Uses a zero-millisecond TTL to guarantee expiry on every call.  
 * <b>Feature: native-stats-refactor, Property 1: Cache returns consistent value within TTL</b>
            AnalyticsBackendNativeMemoryStats initialStats = new AnalyticsBackendNativeMemoryStats(allocatedBytes, residentBytes, 0);
            assertEquals("residentBytes should match on iteration " + iteration, residentBytes, result.getResidentBytes());
                @Override  
                AnalyticsBackendNativeMemoryStats result = cache.getOrRefresh();
     * <p>
            assertTrue(
    /**  
            // (the initial lastRefreshTimestamp is 0, so first call always refreshes)  
            // Generate a random TTL between 1 second and 60 seconds  
            int refreshesAfterInit = refreshCount.get();
 * and a call after TTL expiry SHALL trigger a refresh.  
     * Tests that the cache correctly stores and returns AnalyticsBackendNativeMemoryStats values  
                        0  
            AnalyticsBackendNativeMemoryStats firstResult = cache.getOrRefresh();
            // Generate random initial stats
                        randomLongBetween(0, Long.MAX_VALUE),
                protected AnalyticsBackendNativeMemoryStats refresh() {
            SingleObjectCache<AnalyticsBackendNativeMemoryStats> cache = new SingleObjectCache<AnalyticsBackendNativeMemoryStats>(
     * Property 1 (expiry path): After TTL expiry, getOrRefresh() triggers a refresh.
            long allocatedBytes = randomLongBetween(0, Long.MAX_VALUE);
                @Override  
            AnalyticsBackendNativeMemoryStats expectedStats = new AnalyticsBackendNativeMemoryStats(allocatedBytes, residentBytes, 0);  
 * SPDX-License-Identifier: Apache-2.0
                "No additional refreshes should occur within TTL on iteration " + iteration,
            TimeValue ttl = TimeValue.timeValueMillis(ttlMillis);
                        randomLongBetween(0, Long.MAX_VALUE),
                    firstResult,
            SingleObjectCache<AnalyticsBackendNativeMemoryStats> cache = new SingleObjectCache<AnalyticsBackendNativeMemoryStats>(
    public void testCacheStoresCorrectValues() {
