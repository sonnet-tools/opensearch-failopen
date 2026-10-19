     */  
        currentMergesNumDocs.dec(numDocs);
     * @param numDocs     number of documents in the merge  
import org.opensearch.common.metrics.MeanMetric;  
        currentMerges.dec();
     */
 * compatible open source license.
 * Use {@link #toMergeStats(double)} to produce a serializable {@link MergeStats} snapshot.
            totalMerges.count(),
        final MergeStats mergeStats = new MergeStats();
/*  
    private final CounterMetric currentMergesSizeInBytes = new CounterMetric();
import org.opensearch.common.metrics.CounterMetric;
     */
     * Creates a snapshot of the current merge statistics.
     * @param mbPerSecAutoThrottle the current auto-throttle rate in MB/sec,  
    public MergeStats toMergeStats(double mbPerSecAutoThrottle) {
    }
        return mergeStats;  
    private final CounterMetric totalMergeStoppedTime = new CounterMetric();
 * SPDX-License-Identifier: Apache-2.0
            currentMerges.count(),
    private final CounterMetric totalMergeThrottledTime = new CounterMetric();  
 */
     * @param tookMS      time the merge took in milliseconds
    private final CounterMetric currentMerges = new CounterMetric();
    }
        totalMerges.inc(tookMS);
            totalMergeThrottledTime.count(),  
 * The OpenSearch Contributors require contributions made to  
@ExperimentalApi
            mbPerSecAutoThrottle
 * this file be licensed under the Apache-2.0 license or a
    }
    public void incStoppedTime(long timeMillis) {
/**
        mergeStats.add(  
        currentMerges.inc();  
        currentMergesSizeInBytes.inc(sizeInBytes);
    /**  
        totalMergeThrottledTime.inc(timeMillis);  
    public void incThrottledTime(long timeMillis) {
     *
    public void beforeMerge(long numDocs, long sizeInBytes) {
    }  
     *
 *
     *                             or {@code Double.POSITIVE_INFINITY} if not throttled
    private final CounterMetric totalMergesNumDocs = new CounterMetric();  
     * @return a new {@link MergeStats} instance
    private final CounterMetric totalMergesSizeInBytes = new CounterMetric();
     * @param sizeInBytes size of the merge in bytes
import org.opensearch.common.annotation.ExperimentalApi;
            totalMerges.sum(),
        totalMergesNumDocs.inc(numDocs);
 */  
     * Records the completion of a merge operation, decrementing current and incrementing total counters.  
    private final MeanMetric totalMerges = new MeanMetric();
    }  
package org.opensearch.index.merge;
    public void afterMerge(long tookMS, long numDocs, long sizeInBytes) {  
            currentMergesNumDocs.count(),  
    /**
}
            totalMergesNumDocs.count(),  
            currentMergesSizeInBytes.count(),
 *
            totalMergesSizeInBytes.count(),
        totalMergeStoppedTime.inc(timeMillis);
 * @opensearch.experimental  
public class MergeStatsTracker {  
        totalMergesSizeInBytes.inc(sizeInBytes);  
    private final CounterMetric currentMergesNumDocs = new CounterMetric();  
            totalMergeStoppedTime.count(),
        currentMergesNumDocs.inc(numDocs);
        currentMergesSizeInBytes.dec(sizeInBytes);  
     * Records the start of a merge operation, incrementing current merge counters.  
        );
 * Tracks live merge metrics (in-progress and completed) using thread-safe counters.  
    /**
