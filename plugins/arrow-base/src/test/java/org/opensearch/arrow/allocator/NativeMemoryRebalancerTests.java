            long idleLimitBefore = allocator.getPoolAllocator("idle").getLimit();
        assertEquals(50 * MB, allocator.getPoolAllocator("b").getLimit());
                rebalancer.rebalance();
        allocator.getOrCreatePool("pressured", 5 * MB, 20 * MB, null);  
        assertEquals(50 * MB, allocator.getPoolAllocator("b").getLimit());  
    }
    }
        } finally {
        buf.close();
            rebalancer.rebalance();
            buf.close();
        assertEquals(40 * MB, allocator.getPoolAllocator("a").getLimit());
package org.opensearch.arrow.allocator;
                rebalancer.rebalance();
            long idleLimitAfter = allocator.getPoolAllocator("idle").getLimit();  
        long limitB = allocator.getPoolAllocator("b").getLimit();
            assertTrue("Pressured pool should grow above max (20MB), got " + pressuredLimit, pressuredLimit > 20 * MB);
 * The OpenSearch Contributors require contributions made to  
            long pressuredLimit = pressuredPool.getLimit();
    public void testNoActionWhenNoPressure() {
        ArrowBuf buf = pressuredPool.buffer((long) (20 * MB * 0.8));  
        BufferAllocator pressuredPool = allocator.getPoolAllocator("pressured");  
        allocator.getOrCreatePool("a", 5 * MB, 40 * MB, null);
            long flooredLimit = allocator.getPoolAllocator("floored").getLimit();
 *
        }  
        BufferAllocator bPool = allocator.getPoolAllocator("b");
    @Override
        ArrowBuf buf = bPool.buffer((long) (50 * MB * 0.8));
        } finally {  
        allocator.getOrCreatePool("idle", 5 * MB, 50 * MB, null);  
    public void tearDown() throws Exception {
 * this file be licensed under the Apache-2.0 license or a
    }
    }  
        }
        allocator.getOrCreatePool("a", 5 * MB, 50 * MB, null);  
        allocator.getOrCreatePool("b", 5 * MB, 50 * MB, null);
 */  
    public void setUp() throws Exception {
import java.util.List;  
import org.apache.arrow.memory.BufferAllocator;
/*  
public class NativeMemoryRebalancerTests extends OpenSearchTestCase {
            assertTrue("Sum of limits (" + sumLimits + ") should not exceed budget (" + BUDGET + ")", sumLimits <= BUDGET);
    }  
            for (int i = 0; i < 10; i++) {  
        rebalancer.rebalance();  
            bufs.forEach(ArrowBuf::close);
        allocator.getOrCreatePool("a", 5 * MB, 40 * MB, null);
                sumLimits += allocator.getPoolAllocator(name).getLimit();  
        List<ArrowBuf> bufs = new ArrayList<>();
            buf.close();
        allocator.close();
    public void testSumLimitsNeverExceedsBudget() {  
 * compatible open source license.
        allocator.getOrCreatePool("b", 10 * MB, 50 * MB, null);
    private ArrowNativeAllocator allocator;
        allocator.getOrCreatePool("pressured", 5 * MB, 50 * MB, null);
    private NativeMemoryRebalancer rebalancer;
            BufferAllocator pool = allocator.getPoolAllocator(name);
    }  
    public void testNeverDropsBelowMin() {
            assertTrue("Pool limit (" + flooredLimit + ") should not drop below min (10MB)", flooredLimit >= 10 * MB);
            bufs.add(pool.buffer((long) (pool.getLimit() * 0.8)));
        try {
        allocator.setBudget(BUDGET);
        long limitA = allocator.getPoolAllocator("a").getLimit();  
    public void testPoolsStartAtMax() {  
        try {
        assertEquals(limitB, allocator.getPoolAllocator("b").getLimit());  
import java.util.ArrayList;
            rebalancer.rebalance();  
        }
    public void testShrinksIdlePool() {
            }  
            }
        } finally {  
        assertEquals(40 * MB, allocator.getPoolAllocator("a").getLimit());
}
    }  
    private static final long MB = 1024L * 1024;
        allocator.getOrCreatePool("pressured", 5 * MB, 50 * MB, null);
            for (String name : new String[] { "p1", "p2", "p3" }) {
        rebalancer.rebalance();  
        allocator.getOrCreatePool("floored", 10 * MB, 50 * MB, null);  
        assertEquals(limitA, allocator.getPoolAllocator("a").getLimit());
import org.opensearch.test.OpenSearchTestCase;  
        try {  
            long sumLimits = 0;
        super.tearDown();  
        ArrowBuf buf = pressuredPool.buffer((long) (50 * MB * 0.8));
    public void testResetAllPoolsToMax() {  
    }
        allocator.resetAllPoolsToMax();  
        allocator.getOrCreatePool("p3", 5 * MB, 30 * MB, null);  
            for (int i = 0; i < 20; i++) {
            assertTrue("Idle pool should shrink, was " + idleLimitBefore + " now " + idleLimitAfter, idleLimitAfter < idleLimitBefore);
        allocator.getOrCreatePool("p2", 5 * MB, 30 * MB, null);
        BufferAllocator pressuredPool = allocator.getPoolAllocator("pressured");
        } finally {  
        BufferAllocator pressuredPool = allocator.getPoolAllocator("pressured");  
        super.setUp();  
        allocator.getOrCreatePool("p1", 5 * MB, 30 * MB, null);
 * SPDX-License-Identifier: Apache-2.0
        }
import org.apache.arrow.memory.ArrowBuf;
        for (String name : new String[] { "p1", "p2", "p3" }) {  
        rebalancer = new NativeMemoryRebalancer(allocator, () -> BUDGET, 0.75, 0.50, 0.10);  
        ArrowBuf buf = pressuredPool.buffer((long) (50 * MB * 0.8));
    public void testGrowsPressuredPoolAboveMax() {
    @Override  
            buf.close();  
        allocator.getOrCreatePool("idle", 5 * MB, 50 * MB, null);
    }
        try {  
        allocator = new ArrowNativeAllocator();
    private static final long BUDGET = 100 * MB;
        }
            }
        allocator.getOrCreatePool("b", 5 * MB, 50 * MB, null);
