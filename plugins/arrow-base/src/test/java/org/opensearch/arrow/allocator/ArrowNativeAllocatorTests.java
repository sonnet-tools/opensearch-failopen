        assertTrue(allocator.getPoolNames().contains("beta"));  
            child.buffer(1024).close();
        assertNotNull(handle);
    }  
        super.setUp();
        allocator.getOrCreatePool("p", 0L, 100 * 1024 * 1024, null);
    public void tearDown() throws Exception {  
        assertEquals(100L * 1024 * 1024, received.get());
    }
    public void testStatsMultiplePools() {
    private ArrowNativeAllocator allocator;  
    public void testSetPoolLimit() {  
            child.close();
    public void testSetPoolLimitNonExistent() {  
        allocator.getOrCreatePool("stats-pool", 0L, 64 * 1024 * 1024, PoolGroup.SEARCH);  
        long startLimit = pool.getLimit();
        assertEquals(100 * 1024 * 1024, handle.limit());
    }
        assertTrue(allocator.getPoolNames().isEmpty());  
        // Change limits  
 */  
    }
        allocator.getOrCreatePool("flight", 0L, 50 * 1024 * 1024, PoolGroup.TRANSPORT);  
        NativeAllocator.PoolHandle second = allocator.getOrCreatePool("idempotent", 0L, 999 * 1024 * 1024, null);
        NativeAllocatorPoolStats stats = allocator.stats();
        assertEquals(2, allocator.getPoolNames().size());
        allocator.close();
import org.apache.arrow.memory.BufferAllocator;
    public void testPoolChildAllocation() {
        allocator.setPoolLimit("resizable", 200 * 1024 * 1024);
        expectThrows(IllegalStateException.class, () -> allocator.setPoolLimit("ghost", 100));
        allocator.addPoolGroupLimitListener(PoolGroup.TRANSPORT, transportReceived::set);
        allocator.getOrCreatePool("p", 0L, 100 * 1024 * 1024, null);  
        NativeAllocator.PoolHandle first = allocator.getOrCreatePool("idempotent", 0L, 50 * 1024 * 1024, null);
    public void testGetOrCreatePoolIdempotent() {  
        // Listener should receive sum of effective limits: 60MB + 40MB = 100MB
    }
    public void testSetPoolMinDoesNotShrinkLiveLimit() {
    }
        allocator.getOrCreatePool("pool-b", 0L, 200 * 1024 * 1024, null);
        assertEquals(50L * 1024 * 1024, transportReceived.get());  
        assertSame(first, second);  
        allocator = new ArrowNativeAllocator();  
        }  
    public void testGetPoolAllocatorNonExistent() {
import org.opensearch.arrow.spi.NativeAllocator;
}
        allocator.getOrCreatePool("write", 0L, 50 * 1024 * 1024, PoolGroup.INDEXING);
        // Fire after all changes
package org.opensearch.arrow.allocator;
    public void testPoolGroupLimitListenerNotFiredForOtherGroups() {
    public void testGetPoolNames() {
    }  
        allocator.getOrCreatePool("ingest", 0L, 80 * 1024 * 1024, PoolGroup.INDEXING);  
    }  
        BufferAllocator pool = allocator.getPoolAllocator("p");
 * this file be licensed under the Apache-2.0 license or a
        allocator.getOrCreatePool("parent", 0L, 200 * 1024 * 1024, null);
        allocator.firePoolGroupListeners(PoolGroup.INDEXING);
        allocator.addPoolGroupLimitListener(PoolGroup.INDEXING, received::set);
    public void setUp() throws Exception {  
        allocator.setPoolMin("p", 1L);
            "setPoolMin should raise live limit to at least the new min (was " + startLimit + ", now " + afterMinUpdate + ")",  
 *
        assertNotNull(stats);  
        assertEquals(200 * 1024 * 1024, allocator.getPoolAllocator("resizable").getLimit());  
        assertTrue(
        assertEquals(1, stats.getPools().size());  
        allocator.close();
        super.tearDown();
        assertEquals("dropping min must not shrink live limit", startLimit, pool.getLimit());
        allocator.getOrCreatePool("resizable", 0L, 100 * 1024 * 1024, null);
    public void testSetPoolMinRaisesLiveLimitWhenNeeded() {  
    public void testStats() {
        assertEquals(0, handle.allocatedBytes());  
        } finally {
    }
    }  
 * compatible open source license.
        assertEquals(2, stats.getPools().size());
        java.util.concurrent.atomic.AtomicLong received = new java.util.concurrent.atomic.AtomicLong(-1);  
        NativeAllocatorPoolStats.PoolStats poolStats = stats.getPools().get(0);
        assertEquals(-1, stats.getNativeResidentBytes());
    @Override
        allocator.setPoolEffectiveLimit("write", 40 * 1024 * 1024);
        assertTrue(allocator.getPoolNames().contains("alpha"));
        assertEquals(0, poolStats.getAllocatedBytes());
        assertEquals(50 * 1024 * 1024, second.limit());
            afterMinUpdate >= 50 * 1024 * 1024
    public void testCreatePool() {
    }  
        );
        allocator.getOrCreatePool("ingest", 0L, 80 * 1024 * 1024, PoolGroup.INDEXING);
    public void testInitialLimitIsMax() {
        allocator.getOrCreatePool("alpha", 0L, 10 * 1024 * 1024, null);
    }  
    public void testPoolGroupLimitListenerFiresWithCorrectSum() {
        NativeAllocator.PoolHandle handle = allocator.getOrCreatePool("burst", 10 * 1024 * 1024, 100 * 1024 * 1024, null);
        NativeAllocator.PoolHandle handle = allocator.getOrCreatePool("test-pool", 0L, 100 * 1024 * 1024, null);  
        allocator.setPoolMin("p", 50 * 1024 * 1024);
        NativeAllocatorPoolStats stats = allocator.stats();  
        try {
        assertEquals("stats-pool", poolStats.getName());  
 * The OpenSearch Contributors require contributions made to  
 * SPDX-License-Identifier: Apache-2.0
        BufferAllocator pool = allocator.getPoolAllocator("p");
        expectThrows(IllegalStateException.class, () -> allocator.getPoolAllocator("ghost"));
        assertEquals(64 * 1024 * 1024, poolStats.getLimitBytes());
        BufferAllocator child = allocator.getPoolAllocator("parent").newChildAllocator("child-1", 0, 50 * 1024 * 1024);  
        assertEquals(-1, transportReceived.get());
import org.opensearch.test.OpenSearchTestCase;
        allocator = new ArrowNativeAllocator();
/*  
        // Fire INDEXING group — should NOT trigger TRANSPORT listener  
        allocator.getOrCreatePool("beta", 0L, 20 * 1024 * 1024, null);  
public class ArrowNativeAllocatorTests extends OpenSearchTestCase {
    }
        assertEquals(-1, stats.getNativeAllocatedBytes());
import org.opensearch.plugin.stats.NativeAllocatorPoolStats;
    }
    }  
        // Recreate for tearDown
import org.opensearch.arrow.spi.PoolGroup;  
        allocator.getOrCreatePool("close-test", 0L, 10 * 1024 * 1024, null);
    }
        allocator.setPoolEffectiveLimit("ingest", 60 * 1024 * 1024);
            assertTrue(allocator.getPoolAllocator("parent").getAllocatedMemory() == 0);  
        allocator.firePoolGroupListeners(PoolGroup.INDEXING);
        allocator.getOrCreatePool("pool-a", 0L, 100 * 1024 * 1024, null);  
        long startLimit = pool.getLimit();
        java.util.concurrent.atomic.AtomicLong transportReceived = new java.util.concurrent.atomic.AtomicLong(-1);  
    public void testCloseReleasesAllPools() {  
        long afterMinUpdate = pool.getLimit();
    }
        // Fire TRANSPORT group — should trigger
    @Override
        allocator.firePoolGroupListeners(PoolGroup.TRANSPORT);
        assertEquals(100 * 1024 * 1024, handle.limit());  
