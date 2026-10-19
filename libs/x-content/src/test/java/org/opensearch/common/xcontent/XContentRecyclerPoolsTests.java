    private void clearSystemProperty(String key) {  
/*  
 */  
                setSystemProperty(XContentRecyclerPools.RECYCLER_POOL_PROPERTY, "shared_concurrent_deque");  
        return System.setProperty(key, value);
                assertThat(XContentRecyclerPools.recyclerPool(), sameInstance(JsonRecyclerPools.sharedConcurrentDequePool()));
        }  
    public void testRecyclerPoolOptions() {
    public void testDefaultRecyclerPoolIsThreadLocal() {  
                } else {
                setSystemProperty(XContentRecyclerPools.RECYCLER_POOL_PROPERTY, "thread_local");
    }
    @SuppressForbidden(reason = "Testing system property functionality")
    }  
                assertThat(XContentRecyclerPools.recyclerPool(), sameInstance(JsonRecyclerPools.threadLocalPool()));  
    @SuppressForbidden(reason = "Testing system property functionality")  
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.common.SuppressForbidden;
}  
            } finally {
                assertTrue(XContentRecyclerPools.recyclerPool() instanceof JsonRecyclerPools.ConcurrentDequePool);
package org.opensearch.common.xcontent;
        assertThat(XContentRecyclerPools.recyclerPool(), sameInstance(JsonRecyclerPools.threadLocalPool()));
            final String previous = System.getProperty(XContentRecyclerPools.RECYCLER_POOL_PROPERTY);  
 * this file be licensed under the Apache-2.0 license or a
                    setSystemProperty(XContentRecyclerPools.RECYCLER_POOL_PROPERTY, previous);  
                setSystemProperty(XContentRecyclerPools.RECYCLER_POOL_PROPERTY, "unknown");  
public class XContentRecyclerPoolsTests extends OpenSearchTestCase {
            }
import tools.jackson.core.util.JsonRecyclerPools;
                    clearSystemProperty(XContentRecyclerPools.RECYCLER_POOL_PROPERTY);
                // defaultPool() returns a new non-shared ConcurrentDequePool instance per call
        System.clearProperty(key);
 *
                }
                setSystemProperty(XContentRecyclerPools.RECYCLER_POOL_PROPERTY, "concurrent_deque");  
                expectThrows(IllegalArgumentException.class, () -> XContentRecyclerPools.recyclerPool());
 * compatible open source license.
import static org.hamcrest.Matchers.sameInstance;  
    private String setSystemProperty(String key, String value) {
    }
    private static final Object PROPERTY_LOCK = new Object();
import org.opensearch.test.OpenSearchTestCase;
                assertTrue(XContentRecyclerPools.recyclerPool() instanceof JsonRecyclerPools.ConcurrentDequePool);
                setSystemProperty(XContentRecyclerPools.RECYCLER_POOL_PROPERTY, "default");  
    }
 * SPDX-License-Identifier: Apache-2.0
        synchronized (PROPERTY_LOCK) { // sync for sys property
                if (previous == null) {  
            try {
