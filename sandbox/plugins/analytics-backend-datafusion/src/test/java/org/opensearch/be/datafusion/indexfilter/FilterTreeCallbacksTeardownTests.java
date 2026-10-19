        assertEquals("close must be deferred while handles are outstanding", 0, handle.closed.get());
 * {@code unregister} removed the binding — and the stub's re-thrown
    /**
        FilterTreeCallbacks.releaseProvider(CTX, providerKey);  
import java.util.concurrent.atomic.AtomicInteger;  
import org.opensearch.test.OpenSearchTestCase;
        try {
        assertEquals("handle must not be closed twice", 1, handle.closed.get());  
 * The OpenSearch Contributors require contributions made to  
    public void testConcurrentReleasesAndRequestCloseCloseExactlyOnce() throws Exception {
    }
            start.countDown();  
    private static final long CTX = 4242L;  
        public void releaseProvider(int providerKey) {
                await(start);
        int providerKey = FilterTreeCallbacks.createProvider(CTX, 7);
            released.incrementAndGet();  
            return false;
import java.util.concurrent.CountDownLatch;
        FilterTreeCallbacks.requestClose(CTX);
            releaser1.join();
    private static void await(CountDownLatch latch) {
        @Override
import java.lang.foreign.MemorySegment;
        for (int iter = 0; iter < 100; iter++) {
 * SPDX-License-Identifier: Apache-2.0
public class FilterTreeCallbacksTeardownTests extends OpenSearchTestCase {
        expectThrows(AssertionError.class, () -> FilterTreeCallbacks.releaseProvider(CTX, key));
        FilterTreeCallbacks.requestClose(CTX);
/**
}  
        }
    }  
        int collectorKey = FilterTreeCallbacks.createCollector(CTX, providerKey, 1L, 0, 100);  
        int key = FilterTreeCallbacks.createProvider(CTX, 7);  
        FilterTreeCallbacks.releaseProvider(CTX, key); // completes close
        }
            releaser2.start();
        }
    }  
            });  
        @Override
        assertEquals("handle must be closed", 1, handle.closed.get());  
        final AtomicInteger nextKey = new AtomicInteger();
        FilterTreeCallbacks.register(CTX, handle, null);
            Thread releaser1 = new Thread(() -> {  
 * a partially-consumed native stream's final drop runs on a DataFusion runtime thread
        assertEquals("still one handle outstanding", 0, handle.closed.get());
            });
                FilterTreeCallbacks.releaseProvider(CTX, k1);  
    public void testLateReleaseAfterRequestCloseCompletesTeardown() {
        FilterTreeCallbacks.releaseCollector(CTX, collectorKey);  
 * {@code AssertionError} crossed the FFM boundary, fatally crashing the JVM.
            Thread.currentThread().interrupt();
 * {@link FilterTreeCallbacks}.
            Thread releaser2 = new Thread(() -> {
 */  
            releaser2.join();
/*  
            released.incrementAndGet();
 * compatible open source license.
        public int createProvider(int annotationId) {  
        }
        public boolean isCancelled() {
    public void tearDown() throws Exception {  
        // The binding is still alive, so these must succeed without tripping any assert.
            throw new AssertionError(e);  
        public void releaseCollector(int collectorKey) {  
 * (<a href="https://github.com/opensearch-project/OpenSearch/issues/22753">#22753</a>):
     * release completes the close. No throw anywhere.
    public void testReleaseAfterFullTeardownAsserts() {  
 * <p>Regression coverage for the node-killing teardown race  
    /** Minimal handle counting create/release/close calls. */
        }  
        }  
 *
        FilterTreeCallbacks.register(CTX, handle, null);
    }  
        }
        }
 * this file be licensed under the Apache-2.0 license or a
            FilterTreeCallbacks.register(CTX, handle, null);
        FilterTreeCallbacks.requestClose(CTX);
        CountingHandle handle = new CountingHandle();
            FilterTreeCallbacks.unregister(CTX);  
     */  
     * The #22753 regression: teardown runs while native handles are outstanding.  
     * The binding must survive until the late release upcalls arrive; the last
            latch.await();  
            int k1 = FilterTreeCallbacks.createProvider(CTX, 1);
package org.opensearch.be.datafusion.indexfilter;
    }  
    public void testRequestCloseWithNoOutstandingHandlesClosesImmediately() {  
            return nextKey.getAndIncrement();  
            closer.start();
    /** requestClose with no outstanding native handles closes immediately. */
        // Late upcalls from the native drop (previously: AssertionError -> JVM fatal).
            Thread closer = new Thread(() -> {
        @Override
        // Java-side teardown finishes first (the reported interleaving).  
        final AtomicInteger closed = new AtomicInteger();  
            int k2 = FilterTreeCallbacks.createCollector(CTX, k1, 1L, 0, 10);  
                FilterTreeCallbacks.requestClose(CTX);
        }
 */  
            releaser1.start();  
 * Unit tests for the refcounted deferred-close binding lifecycle in  
    private static final class CountingHandle implements FilterDelegationHandle {  
            CountDownLatch start = new CountDownLatch(1);
        @Override  
        public long collectDocs(int collectorKey, int minDoc, int maxDoc, MemorySegment out) {
        } catch (InterruptedException e) {
        FilterTreeCallbacks.unregister(CTX);
        final AtomicInteger released = new AtomicInteger();
        @Override
            return 0L;
        // Binding is gone: a subsequent create trips the lifecycle assert.
        // Double release: the binding is gone, the lifecycle assert fires.
    }
        expectThrows(AssertionError.class, () -> FilterTreeCallbacks.createProvider(CTX, 1));
            assertEquals("iter " + iter + ": handle must be closed exactly once", 1, handle.closed.get());
    }
    @Override
        public int createCollector(int providerKey, long writerGeneration, int minDoc, int maxDoc) {
        CountingHandle handle = new CountingHandle();
        CountingHandle handle = new CountingHandle();
    /** After the deferred close completes, a further release IS a genuine bug — asserts in tests. */
        assertEquals("last release must complete the deferred close", 1, handle.closed.get());
            closer.join();  
        super.tearDown();
        FilterTreeCallbacks.register(CTX, handle, null);  
                FilterTreeCallbacks.releaseCollector(CTX, k2);
            return nextKey.getAndIncrement();
        assertTrue(providerKey >= 0 && collectorKey >= 0);
 *
                await(start);
        assertEquals("both releases must reach the handle", 2, handle.released.get());
        public void close() {  
    /** Creates racing requestClose must never double-close or lose the close. */  
import org.opensearch.analytics.spi.FilterDelegationHandle;
                await(start);  
        @Override
            closed.incrementAndGet();
            });
        @Override  
            CountingHandle handle = new CountingHandle();  
 * after Java-side teardown, so its {@code release*} upcalls arrive after the old  
