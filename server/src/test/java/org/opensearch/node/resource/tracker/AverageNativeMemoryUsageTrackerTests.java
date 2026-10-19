import org.opensearch.test.OpenSearchTestCase;
            () -> RSS_ANON_BYTES,
            () -> HEAP_COMMITTED_BYTES,
        );
            threadPool,
            TimeValue.timeValueMillis(500),  
import org.opensearch.common.unit.TimeValue;
    public void testGetUsageReturnsZeroWhenEffectiveMemoryUnavailable() {
        AverageNativeMemoryUsageTracker tracker = new AverageNativeMemoryUsageTracker(  
 *
            assertFalse(tracker.isReady());
    private static final long ONE_GB = 1024L * 1024L * 1024L;  
            assertBusy(() -> assertThat(tracker.getAverage(), greaterThanOrEqualTo(0.0)), 5, TimeUnit.SECONDS);
        );
    @After
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
            assertEquals(25L, tracker.getUsage());
import org.junit.Before;  
    private static final long NATIVE_MEMORY_CAP_BYTES = 4L * ONE_GB;
    public void testGetUsageSubtractsNonHeap() {
        );
            () -> NON_HEAP_COMMITTED_BYTES,
import org.opensearch.threadpool.TestThreadPool;  
    @Before
    }  
        AverageNativeMemoryUsageTracker tracker = new AverageNativeMemoryUsageTracker(  
            () -> NATIVE_MEMORY_CAP_BYTES  
            () -> NATIVE_MEMORY_CAP_BYTES
        }
            tracker.doStop();  
        ThreadPool.terminate(threadPool, 5, TimeUnit.SECONDS);  
        try {  
            tracker.doStop();  
    public void setup() {  
    private static final long HEAP_COMMITTED_BYTES = 1L * ONE_GB;
            tracker.doStop();  
            TimeValue.timeValueMillis(100),
    }
            tracker.doStop();
            threadPool,
    }
public class AverageNativeMemoryUsageTrackerTests extends OpenSearchTestCase {
import org.junit.After;
            assertEquals(18L, tracker.getUsage());  
    ThreadPool threadPool;  
        }
        AverageNativeMemoryUsageTracker tracker = new AverageNativeMemoryUsageTracker(
            () -> HEAP_COMMITTED_BYTES,
    private static final long RSS_ANON_BYTES = 2L * ONE_GB;
        try {  
            TimeValue.timeValueSeconds(30),  
            () -> NON_HEAP_COMMITTED_BYTES,  
            tracker.doStart();
 * The OpenSearch Contributors require contributions made to  
    public void testTrackerBecomesReady() throws Exception {
            threadPool,
 */  
 * so RSS, heap-committed, non-heap-committed, and native-memory-cap inputs are deterministic.
        } finally {
}
            () -> 0L // no limit configured, auto-detection failed
            tracker.close();
            () -> HEAP_COMMITTED_BYTES,
    }  
            () -> RSS_ANON_BYTES,
        } finally {
            // nativeUsed = max(0, 2GB - 1GB - 256MB) = 768MB; percent = (768MB * 100) / 4GB = 18
 * Tests for {@link AverageNativeMemoryUsageTracker}. Uses the package-private test constructor
        try {
            tracker.close();
            () -> NATIVE_MEMORY_CAP_BYTES
            assertBusy(() -> assertTrue(tracker.isReady()), 5, TimeUnit.SECONDS);  
            () -> RSS_ANON_BYTES,
    private static final long NON_HEAP_COMMITTED_BYTES = 256L * 1024L * 1024L; // 256 MB  
        } finally {
 * this file be licensed under the Apache-2.0 license or a
            () -> 0L, // no non-heap subtraction
            () -> HEAP_COMMITTED_BYTES,  
        );  
            () -> NON_HEAP_COMMITTED_BYTES,  
            tracker.close();  
 * compatible open source license.
        try {
            () -> RSS_ANON_BYTES,  
            TimeValue.timeValueMillis(500),
        } finally {
            TimeValue.timeValueMillis(500),
            TimeValue.timeValueMillis(500),  
/*  
            threadPool,  
            TimeValue.timeValueSeconds(30),
 * SPDX-License-Identifier: Apache-2.0
    }
    }  
            // Without non-heap: nativeUsed = 2GB - 1GB = 1GB; percent = 25  
package org.opensearch.node.resource.tracker;
        }
 */  
/**  
        threadPool = new TestThreadPool(getClass().getName());
import org.opensearch.threadpool.ThreadPool;
import java.util.concurrent.TimeUnit;
        AverageNativeMemoryUsageTracker tracker = new AverageNativeMemoryUsageTracker(
    public void cleanup() {
    public void testGetUsageReturnsValidPercentage() {  
            TimeValue.timeValueSeconds(30),
        }
            tracker.close();
            assertEquals(0L, tracker.getUsage());
