 * <p>  
    default void close() {}  
 * compatible open source license.
     * {@code ceilDiv(maxDoc - minDoc, 64) * 8} bytes. Implementations
 * this file be licensed under the Apache-2.0 license or a
import java.lang.foreign.MemorySegment;
 * Callers should use try-with-resources to ensure cleanup.
import org.opensearch.common.annotation.ExperimentalApi;
 * A per-segment document collector returned by
    @Override
import java.io.Closeable;  
     * That is, bit {@code k} represents absolute doc id {@code minDoc + k}.  
     * @param out    destination {@link MemorySegment} to write the packed bitset into  
     *
 *
     * <p>Bit layout: the {@code out} segment receives a packed bitset where  
 *
public interface SegmentCollector extends Closeable {  
     *
     * @param maxDoc exclusive upper bound
     * {@link MemorySegment}.
 */  
     * @return the number of 64-bit words written into {@code out}
 * The OpenSearch Contributors require contributions made to  
     * Collect matching document IDs in the given range into the provided  
    /**
     * are one-shot cursors and cannot seek backwards; violating the
     * non-overlapping {@code [minDoc, maxDoc)} ranges. Backing iterators  
 * @opensearch.experimental  
     * @param minDoc inclusive lower bound
    int collectDocs(int minDoc, int maxDoc, MemorySegment out);  
 * {@link IndexFilterProvider#createCollector}.
     * word {@code j} bit {@code i} (LSB-first) represents the doc at
     */
     * <p>Forward-only: successive calls MUST use non-decreasing,
 */
}
@ExperimentalApi
/*  
     * The caller must provide a segment of at least
 * SPDX-License-Identifier: Apache-2.0
/**  
     * relative position {@code j*64 + i} within {@code [minDoc, maxDoc)}.
     *  
     * MUST NOT skip trailing zero words.  
package org.opensearch.index.engine.exec;
     * invariant silently yields wrong results for ranges already passed.
