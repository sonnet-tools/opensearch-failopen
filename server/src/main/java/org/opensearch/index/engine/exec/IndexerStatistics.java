     * Returns completion suggester statistics for specified field patterns.  
    /**  
    SegmentsStats segmentsStats(boolean includeSegmentFileSizes, boolean includeUnloadedSegments);  
     * Returns document-level statistics.
     * @return segment statistics including count, memory usage, and file information
     * @param verbose if true, includes additional detail (ignored for non-Lucene engines)
     * @return statistics including document count, deleted documents, and total size
     * Returns statistics about index commits.
     * Returns merge operation statistics.  
/**  
 * The OpenSearch Contributors require contributions made to  
     */
@ExperimentalApi  
     */  
 *  
 * SPDX-License-Identifier: Apache-2.0
 * compatible open source license.
     * @param includeSegmentFileSizes if true, includes individual file sizes
     * Returns the current amount of data being written to disk.
     *
    /**
 */  
     *
     *
    long getWritingBytes();  
     */
    /**
     */
    /**  
public interface IndexerStatistics {
     * @return list of segments, sorted by generation
     */
    List<Segment> segments(boolean verbose);
import org.opensearch.search.suggest.completion.CompletionStats;
import org.opensearch.common.annotation.ExperimentalApi;
     */  
     */  
     * @return count of cleanup operations  
    CompletionStats completionStats(String... fieldNamePatterns);
    /**  
import org.opensearch.index.merge.MergeStats;
     * @param fieldNamePatterns field name patterns to match (supports wildcards)
     */
 * Statistics and metrics for the indexer.
    CommitStats commitStats();
 */
    /**
     * Returns per-segment metadata for this indexer.
     * @return merge statistics including total merges, time, and data volume
package org.opensearch.index.engine.exec;
     */
     * @return bytes currently being written
    long getNativeBytesUsed();
     * Used to track garbage collection of unused index files.
     *
     *  
     *
     * Returns the total time spent under indexing throttling.
     *  
     * Returns segment-level statistics.  
     * @return native memory usage in bytes
 *
     * @return completion statistics including memory usage per field  
     * Returns the number of unreferenced file cleanup operations performed.  
     * @return polling ingestion statistics
     */
import java.util.List;
import org.opensearch.index.engine.Segment;  
    long getHeapBytesUsed();
     *
     */
    PollingIngestStats pollingIngestStats();  
    MergeStats getMergeStats();
     * Returns the amount of native memory used by the indexer.
     * @return commit statistics including generation and user data  
     *
     * Returns statistics for pull-based ingestion operations.
    /**
/*  
import org.opensearch.index.engine.SegmentsStats;
    /**  
     */
    long unreferencedFileCleanUpsPerformed();
     * Returns JVM heap bytes used by indexing buffers that would be freed by a refresh.
    DocsStats docStats();  
     *  
     * Each segment includes committed/search state, doc count, and size.
     * @return throttle time in milliseconds  
    /**
}  
     * @param includeUnloadedSegments if true, includes segments not currently loaded  
import org.opensearch.indices.pollingingest.PollingIngestStats;
     *
 * @opensearch.experimental
import org.opensearch.index.shard.DocsStats;  
    /**
    /**
 * Provides access to various performance metrics, resource usage, and operational statistics.
    long getIndexThrottleTimeInMillis();
import org.opensearch.index.engine.CommitStats;
 * this file be licensed under the Apache-2.0 license or a
    /**
     *  
     * @return heap usage in bytes  
     * This includes off-heap memory used by native components.  
