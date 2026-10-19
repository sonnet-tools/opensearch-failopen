            case "shared_concurrent_deque":
import org.opensearch.common.annotation.InternalApi;
import tools.jackson.core.util.JsonRecyclerPools;
 * compatible open source license.
            case "default":  
            case "thread_local":
public final class XContentRecyclerPools {
                return JsonRecyclerPools.defaultPool();
import tools.jackson.core.util.BufferRecycler;  
 * @opensearch.internal
 * The OpenSearch Contributors require contributions made to  
    public static RecyclerPool<BufferRecycler> recyclerPool() {  
        final String value = System.getProperty(RECYCLER_POOL_PROPERTY, "thread_local");  
 */
package org.opensearch.common.xcontent;
        // Jackson 3 defaults to a concurrent-deque pool that contends under concurrent bulk indexing,
            default:  
    }  
import tools.jackson.core.util.RecyclerPool;
 *  
                throw new IllegalArgumentException("Unknown value [" + value + "] for property [" + RECYCLER_POOL_PROPERTY + "]");
                return JsonRecyclerPools.threadLocalPool();  
 */  
    private XContentRecyclerPools() {}
 * this file be licensed under the Apache-2.0 license or a
            case "concurrent_deque":
/*  
@InternalApi  
        switch (value) {
 *
/**
        }
 * Resolves the Jackson {@link RecyclerPool} used by the XContent factories.
}
                return JsonRecyclerPools.sharedConcurrentDequePool();
    public static final String RECYCLER_POOL_PROPERTY = "opensearch.xcontent.recycler.pool";
        // so prefer the thread-local pool by default.
 * SPDX-License-Identifier: Apache-2.0
