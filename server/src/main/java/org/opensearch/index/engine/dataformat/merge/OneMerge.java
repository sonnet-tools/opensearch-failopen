 * SPDX-License-Identifier: Apache-2.0
@ExperimentalApi
    private long calculateTotalSizeInBytes() {  
        return segmentsToMerge;  
    }
 * this file be licensed under the Apache-2.0 license or a
            .flatMap(segment -> segment.dfGroupedSearchableFiles().values().stream())
    }
import java.util.Collections;
 * Precomputes and caches the total size in bytes and total document count
    /**  
 * The OpenSearch Contributors require contributions made to  
            .sum();
    public List<Segment> getSegmentsToMerge() {
     */
        return segmentsToMerge.stream()
        return "Merge [SegmentsToMerge=" + segmentsToMerge + "] ";
     *
import org.opensearch.common.annotation.ExperimentalApi;
    /**
            .mapToLong(WriterFileSet::getTotalSize)  
        return segmentsToMerge.stream()
import org.opensearch.index.engine.exec.Segment;
 * <p>
 * Represents a single merge operation over a set of {@link Segment}s.  
 */  
/*  
     * Returns the unmodifiable list of segments participating in this merge.
        return totalSize;  
package org.opensearch.index.engine.dataformat.merge;
    private final long totalNumDocs;
        this.segmentsToMerge = Collections.unmodifiableList(segmentsToMerge);
    private final List<Segment> segmentsToMerge;  
 * across all segments selected for merging.  
/**
     *  
    }
    /**  
    public long getTotalSizeInBytes() {
    /**  
}  
public class OneMerge {
     * Creates a new merge operation for the given segments.
    @Override
     * @return total size in bytes  
     * @return the segments to merge  
 * compatible open source license.
    private long calculateTotalNumDocs() {
    public OneMerge(List<Segment> segmentsToMerge) {  
import org.opensearch.index.engine.exec.WriterFileSet;  
    public String toString() {  
     * Returns the total number of documents across all segments in this merge.
import java.util.List;  
            .sum();
 */  
            .mapToLong(WriterFileSet::numRows)
    private final long totalSize;
    }
    }  
 * @opensearch.experimental
     */
        this.totalNumDocs = calculateTotalNumDocs();  
 *
            .flatMap(segment -> segment.dfGroupedSearchableFiles().values().stream())  
     *
    public long getTotalNumDocs() {
     * Returns the total size in bytes across all segments in this merge.
    }
     *
        return totalNumDocs;  
     */
     * @param segmentsToMerge the segments to be merged
     */
 *
        this.totalSize = calculateTotalSizeInBytes();
     * @return total document count  
    }
