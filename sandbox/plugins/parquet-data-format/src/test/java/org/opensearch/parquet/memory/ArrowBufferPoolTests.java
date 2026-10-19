            assertTrue(pool.getTotalAllocatedBytes() > 0);
        // the *child* that we closed returned its bytes to the parent.
     */  
    }
    }
            c2.close();  
            assertTrue(pool.getTotalAllocatedBytes() > 0);
            child.close();
        pool1.close();  
            pool.close();
            pool.close();
        // Constrain the framework's ingest pool to a finite limit.
        ArrowBuf buf1 = child1.buffer(1024);
        ArrowBufferPool pool = new ArrowBufferPool(Settings.EMPTY, nativeAllocator);
            ArrowBuf buf = child.buffer(1024);  
}  
            assertTrue(pool.getTotalAllocatedBytes() >= 1024);
            b2.close();  
    @Override  
    public void testChildAllocatorEnforcedByParentPoolLimit() {
    public void tearDown() throws Exception {
        } finally {
import org.opensearch.arrow.allocator.ArrowNativeAllocator;  
    }
    }
        assertEquals("Sum of per-pool bytes must equal actual total", actualTotal, sum);  
        try {
        super.tearDown();  
        BufferAllocator c2 = pool.createChildAllocator("c2");  
            assertEquals(0, pool.getTotalAllocatedBytes());
import org.apache.arrow.memory.BufferAllocator;
            // Child can allocate within the parent pool's limit  
            ArrowBuf buf = child.buffer(1024);  
        BufferAllocator c1 = pool.createChildAllocator("c1");
            buf.close();  
            ArrowBuf buf = child.buffer(512 * 1024);
            c1.close();
            b1.close();
        // Production code receives this via dependency injection; tests build it explicitly.
        ArrowBufferPool pool = new ArrowBufferPool(Settings.EMPTY, nativeAllocator);
            assertNotNull(buf);
    }
        // Pool's BufferAllocator is owned by the framework; the assertion now confirms
        // Each test gets its own allocator with the standard pools pre-created.  
            buf.close();
package org.opensearch.parquet.memory;
        buf1.close();
    public void setUp() throws Exception {
        } finally {  
        }
    private ArrowNativeAllocator nativeAllocator;
        assertEquals(0, pool.getTotalAllocatedBytes());  
        BufferAllocator child = pool.createChildAllocator("c-full");
        pool2.close();
        ArrowBufferPool pool2 = new ArrowBufferPool(Settings.EMPTY, nativeAllocator);  
        } finally {  
            nativeAllocator.close();  
        long actualTotal = 1024 + 2048;
        } finally {
        buf2.close();  
        long sum = pool1.getTotalAllocatedBytes() + pool2.getTotalAllocatedBytes();
    }
import org.opensearch.test.OpenSearchTestCase;  
 * this file be licensed under the Apache-2.0 license or a
        nativeAllocator.setPoolLimit(NativeAllocatorPoolConfig.POOL_INGEST, poolLimit);
 *
        try {  
        }
        child1.close();
            child.close();
    public void testAllocatedBytesIncreasesOnAllocation() {  
        nativeAllocator = new ArrowNativeAllocator();
        try {
        try {
 */  
        ArrowBufferPool pool = new ArrowBufferPool(Settings.EMPTY, nativeAllocator);  
            expectThrows(org.apache.arrow.memory.OutOfMemoryException.class, () -> child.buffer(poolLimit + 1));  
        BufferAllocator child1 = pool1.createChildAllocator("pool-1");
    public void testAllocatedBytesDecreasesAfterFree() {
import org.opensearch.common.settings.Settings;
        if (nativeAllocator != null) {
            ArrowBuf b2 = c2.buffer(512);  
    /**  
import org.opensearch.arrow.spi.NativeAllocatorPoolConfig;
        }
        BufferAllocator child = pool.createChildAllocator("free-test");
            ArrowBuf b1 = c1.buffer(512);
        ArrowBufferPool pool1 = new ArrowBufferPool(Settings.EMPTY, nativeAllocator);
 * The OpenSearch Contributors require contributions made to  
        long poolLimit = 1024L * 1024;  
        super.setUp();
 * SPDX-License-Identifier: Apache-2.0
/*  
            child.close();
    @Override  
        BufferAllocator child2 = pool2.createChildAllocator("pool-2");  
        }  
    public void testMultiplePoolInstancesReportOwnUsageNotPoolWideTotal() {
            assertNotNull(child);
    }  
            pool.close();
 * compatible open source license.
    public void testMultipleChildAllocators() {  
        nativeAllocator.getOrCreatePool(NativeAllocatorPoolConfig.POOL_INGEST, 0L, Long.MAX_VALUE, null);  
            // Child cannot allocate more than the parent pool's limit
        child2.close();
     * their own memory usage via getTotalAllocatedBytes(), not the pool-wide total.
            nativeAllocator = null;
            pool.close();  
        BufferAllocator child = pool.createChildAllocator("alloc-test");
        // Sum of individual pool reports must equal the actual total.
     * Multiple ArrowBufferPool instances backed by the same NativeAllocator must report only
            buf.close();
public class ArrowBufferPoolTests extends OpenSearchTestCase {
        ArrowBufferPool pool = new ArrowBufferPool(Settings.EMPTY, nativeAllocator);  
import org.apache.arrow.memory.ArrowBuf;
        }  
        ArrowBuf buf2 = child2.buffer(2048);  
