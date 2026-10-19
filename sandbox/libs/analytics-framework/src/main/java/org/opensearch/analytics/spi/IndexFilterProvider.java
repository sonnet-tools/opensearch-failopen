 *       registers it in the backend's internal provider registry, returning
import org.opensearch.common.annotation.ExperimentalApi;
    /**
     * Release resources for a collector when the native engine is done
    void releaseCollector(int collectorKey);
 * this file be licensed under the Apache-2.0 license or a
     */
     * @param maxDoc       exclusive upper bound of the doc range.
 *       per (segment, row-group range). Internally this routes to
 *       a {@code providerKey}.</li>
 *   <li>Native upcalls {@code createProvider(queryBytes)} on the registered
     * @param out          destination {@link MemorySegment} buffer;
}
 *
 * {@code out.setAtIndex(ValueLayout.JAVA_LONG, i, word)}.
 *   <li>Native upcalls {@code releaseCollector(collectorKey)} when done with
 * implementations can write doc-id bitsets directly into caller-owned
 */  
/**  
@ExperimentalApi
 *   <li>Native upcalls {@code createCollector(providerKey, seg, min, max)}  
 * <p>Lifecycle is driven by the native engine:  
 *       a segment, {@code releaseProvider(providerKey)} when the query ends.</li>  
 */
 * (possibly native) memory without an intermediate {@code long[]}
     *  
     * iterating its segment.
 *
     *
     * Fill {@code out} with the matching doc-id bitset for the given
import java.io.Closeable;  
     * Create a collector for one (segment, [minDoc, maxDoc)) range.  
import java.lang.foreign.MemorySegment;
     * collector over doc range {@code [minDoc, maxDoc)}.  
     * Implementations write words using
 * vector, columnar, etc.) can satisfy it.
 * Produces doc-id bitsets for one index-backed filter leaf.
     * @param collectorKey provider-internal collector key returned by
 *       {@link IndexFilterProviderFactory}; this produces a provider and  
     * @param minDoc       inclusive lower bound of the doc range.  
    int collectDocs(int collectorKey, int minDoc, int maxDoc, MemorySegment out);
 * SPDX-License-Identifier: Apache-2.0
 * <ol>
     *
     *                     {@code out.byteSize() / 8} words.
    /**  
     */  
 * cheap per-segment matchers that materialize doc-id bitsets on demand.
 *       {@link #createCollector(int, int, int)} on this provider.</li>
     *                     implementation may write up to  
 * per shard from an opaque serialized query payload, then used to create
     */  
 * The OpenSearch Contributors require contributions made to  
     * {@code [minDoc + i*64, minDoc + (i+1)*64)}, LSB-first within each word.  
 *
 * <p>The SPI uses a {@link MemorySegment} destination buffer so that  
 * allocation. Implementations write words using  
     * <p>Bit layout: the word at index {@code i} contains matches for docs
package org.opensearch.analytics.spi;
 * The SPI is backend-agnostic — any index implementation (inverted, sparse  
     *                     {@link #createCollector(int, int, int)}.
 * </ol>
 *
     * @return number of words actually written, or {@code -1} on error.
    /**
     * @return a provider-internal collector key {@code >= 0}, or {@code -1}
 *
 *   <li>Native upcalls {@code collectDocs(collectorKey, min, max, out)}  
 * compatible open source license.
 * <p>Conceptually a compiled query bound to a shard: built once per query  
 *       per row group while iterating.</li>
     * {@code out.setAtIndex(ValueLayout.JAVA_LONG, i, word)}.
    int createCollector(int segmentOrd, int minDoc, int maxDoc);
 * @opensearch.experimental  
/*  
public interface IndexFilterProvider extends Closeable {  
     *         if the collector cannot be created (e.g. empty range).  
