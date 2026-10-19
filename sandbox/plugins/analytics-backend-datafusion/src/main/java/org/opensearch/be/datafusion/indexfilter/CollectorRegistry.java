     * provider's own inner collector key.  
 * {@link CollectorHandle}, so no second map lookup is needed.
    }
        int key = nextKey.getAndIncrement();  
    }  
 * The OpenSearch Contributors require contributions made to  
import java.util.concurrent.ConcurrentHashMap;  
    record CollectorHandle(IndexFilterProvider provider, int innerCollectorKey) {
 * cheap FFM marshaling.
import java.util.concurrent.atomic.AtomicInteger;
import org.opensearch.analytics.spi.IndexFilterProvider;
 *
 * <p>This is the hot-path registry: {@code collectDocs} and
        collectors.put(key, new CollectorHandle(provider, innerCollectorKey));
        return key;
    void unregisterCollector(int key) {  
/*  
    private final AtomicInteger nextKey = new AtomicInteger(1);  
 */
 */  
package org.opensearch.be.datafusion.indexfilter;
    /** Creates an empty collector registry. */
 * SPDX-License-Identifier: Apache-2.0
    }
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 * Per-segment collector bookkeeping, keyed by small positive ints for
    private final ConcurrentHashMap<Integer, CollectorHandle> collectors = new ConcurrentHashMap<>();
    CollectorHandle collector(int key) {
    /**
public final class CollectorRegistry {  
}
     */
    int registerCollector(IndexFilterProvider provider, int innerCollectorKey) {
 * {@code releaseCollector} upcalls only touch this map. The provider
        return collectors.get(key);  
 *  
/**  
        collectors.remove(key);
 * reference is captured at collector-creation time in  
    }  
     * Maps an outer collector key to the provider instance + the
    public CollectorRegistry() {}  
