     * Collects matching document IDs for the collector identified by {@code key}.  
 * {@link #releaseCollector}. Java owns the collector state; the native (Rust) side
        SegmentCollector collector = collectors.get(key);  
import java.util.concurrent.ConcurrentHashMap;  
     * @return a unique key that identifies this collector  
}
            collector.close();
 * this file be licensed under the Apache-2.0 license or a
    public void releaseCollector(int key) {
 * Manages the lifecycle of {@link SegmentCollector} instances for a single query.
import java.util.concurrent.atomic.AtomicInteger;
    private final AtomicInteger nextKey = new AtomicInteger(1);
    }  
     * @param key the collector key returned by {@link #registerCollector}
        }
 * from {@link #registerCollector} and use it to invoke {@link #collectDocs} and
 *
     *
     * Registers a collector and returns its int key.  
 * <p>
        }  
 * <p>
     *
import org.opensearch.common.annotation.ExperimentalApi;
 * Provides a JNI-friendly primitives-only API: callers receive an {@code int} key  
    }  
 * compatible open source license.
        collectors.put(key, collector);
 * only holds lightweight int keys.  
import java.io.Closeable;  
    /**
        int key = nextKey.getAndIncrement();  
    }  
     * Closes all remaining collectors. Acts as a safety net for any  
 * SPDX-License-Identifier: Apache-2.0
     * @param out    destination {@link MemorySegment} to write the packed bitset into
    }
package org.opensearch.index.engine.exec;
     * removing it from the registry.  
        return collector.collectDocs(minDoc, maxDoc, out);
public class CollectorQueryLifecycleManager implements Closeable {  
 * One manager is created per query and closed when the query finishes.
        return key;
import java.util.Map;
        collectors.clear();
 * {@link #close()} acts as a safety net, releasing any collectors that were not  
@ExperimentalApi
 */  
     * Releases the collector identified by {@code key}, closing it and
/**  
     * @param maxDoc exclusive upper bound
     * @param minDoc inclusive lower bound  
 * explicitly released by the caller.
        for (SegmentCollector collector : collectors.values()) {
    /**
        SegmentCollector collector = collectors.remove(key);
            collector.close();  
     * @param key    the collector key returned by {@link #registerCollector}
    public void close() {
 *
    private final Map<Integer, SegmentCollector> collectors = new ConcurrentHashMap<>();  
import java.lang.foreign.MemorySegment;
     */  
     * @return the number of 64-bit words written into {@code out}, or {@code 0} if key is invalid  
    public int registerCollector(SegmentCollector collector) {
     */
    /**
/*  
        }
            return 0;
        if (collector != null) {  
    public int collectDocs(int key, int minDoc, int maxDoc, MemorySegment out) {
     */
     * collectors that were not explicitly released.
     * @param collector the segment collector to manage
    /**
 * @opensearch.experimental  
        if (collector == null) {
    @Override  
     */
 * The OpenSearch Contributors require contributions made to  
 */
     *
