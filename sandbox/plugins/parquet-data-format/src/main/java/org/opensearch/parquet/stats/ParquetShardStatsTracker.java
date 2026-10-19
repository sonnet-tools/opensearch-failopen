    }
    }
    // Highest row_id assigned across all merges of this shard.  
    private final LongAdder nativeFinalizeFailures = new LongAdder();
    public void addBackgroundWriteWaitMillis(long ms) {
            rowIdMappingMax.get(),
        return new ParquetShardStats(
            vsrRotationsTotal.sum(),
    }
    public void addFlushAndSortChunkTimeMillis(long ms) {  
        backgroundWriteFailures.increment();
    public void incMergeFailures() {
    private final LongAdder nativeWriteTimeMillis = new LongAdder();
    public void incNativeWriteFailures() {
/*  
        flushAndSortChunkTimeMillis.add(ms);
    private final LongAdder nativeWriteTotal = new LongAdder();  
            nativeWriteRejections.sum(),
        nativeFinalizeTimeMillis.add(ms);  
 * this file be licensed under the Apache-2.0 license or a
    private final LongAdder nativeFinalizeTotal = new LongAdder();
    // --- Indexing methods ---  
    }
            indexTimeMillis.sum(),  
    // Merge counters  
    }  
    }
            mergeInputFilesTotal.sum(),  
public class ParquetShardStatsTracker {
    private final LongAdder backgroundWriteWaitMillis = new LongAdder();
    public void incNativeFinalizeTotal() {
    private final LongAdder mergeOutputRowsTotal = new LongAdder();
    }  
        nativeWriteTotal.increment();
            backgroundWriteTimeouts.sum(),
    private final LongAdder nativeFinalizeTimeMillis = new LongAdder();  
 *
    public void incNativeWriteTotal() {  
    private final LongAdder mergeInputFilesTotal = new LongAdder();
    public void addFlushAndSortChunkTotal(long n) {
    /**  
 * compatible open source license.
    // Native Write counters
    public void incBackgroundWriteFailures() {
            nativeWriteFailures.sum(),
}
        vsrRotationsTotal.increment();
        nativeFinalizeTotal.increment();
 * The OpenSearch Contributors require contributions made to  
            nativeFinalizeTotal.sum(),  
            flushAndSortChunkTotal.sum(),
        mergeTimeMillis.add(ms);
            mergeTimeMillis.sum(),
        backgroundWriteTotal.increment();
 * Uses LongAdder for high-throughput counters.
    public void incNativeFinalizeFailures() {  
            flushAndSortChunkTimeMillis.sum(),  
        mergeFailures.increment();  
    public void incMergeTotal() {  
    }
 * SPDX-License-Identifier: Apache-2.0
    private final LongAdder flushAndSortChunkTotal = new LongAdder();
    }
    private final LongAdder vsrRotationsTotal = new LongAdder();  
    private final LongAccumulator rowIdMappingMax = new LongAccumulator(Long::max, 0L);
    private final LongAdder nativeWriteRejections = new LongAdder();
            nativeFinalizeTimeMillis.sum(),
    public ParquetShardStats stats() {  
    }
     */
        flushAndSortChunkTotal.add(n);  
            backgroundWriteTotal.sum(),
 * @opensearch.experimental
        nativeWriteTimeMillis.add(ms);
    // Indexing counters
    public void incBackgroundWriteTimeouts() {  
    // --- Native Write methods ---
    public void addMergeOutputRowsTotal(long n) {
        mergeTotal.increment();
import org.opensearch.common.annotation.ExperimentalApi;
    }  
    private final LongAdder mergeTimeMillis = new LongAdder();
@ExperimentalApi
        backgroundWriteTimeouts.increment();
            docsIndexedTotal.sum(),
        nativeWriteFailures.increment();  
    // --- Merge methods ---
    }  
/**  
    }  
    // Writes rejected by the parquet_native_write pool when its bounded queue is full.  
    private final LongAdder docsIndexedTotal = new LongAdder();
        rowIdMappingMax.accumulate(value);
    }
    public void addMergeTimeMillis(long ms) {
    public void addDocsIndexed(long n) {
        nativeWriteRejections.increment();
            nativeWriteTotal.sum(),
    }  
    public void incBackgroundWriteTotal() {
    public void incVsrRotations() {  
    // --- VSR Pipeline methods ---
 *
    private final LongAdder nativeWriteFailures = new LongAdder();
    private final LongAdder indexTimeMillis = new LongAdder();  
    private final LongAdder mergeTotal = new LongAdder();
            backgroundWriteFailures.sum()
    }  
package org.opensearch.parquet.stats;
        docsIndexedTotal.add(n);  
    public void addMergeInputFilesTotal(long n) {  
            nativeWriteTimeMillis.sum(),  
    private final LongAdder flushAndSortChunkTimeMillis = new LongAdder();
    }
    }
     * Returns an immutable point-in-time snapshot of all tracked statistics.
            nativeFinalizeFailures.sum(),
    // VSR Pipeline counters
    public void updateRowIdMappingMax(long value) {
    }
            backgroundWriteWaitMillis.sum(),  
    }
        backgroundWriteWaitMillis.add(ms);  
        mergeOutputRowsTotal.add(n);
    public void addNativeWriteTimeMillis(long ms) {
            mergeTotal.sum(),  
 * Mutable, thread-safe shard-level statistics tracker for the Parquet data format plugin.
    private final LongAdder mergeFailures = new LongAdder();  
        nativeFinalizeFailures.increment();
    private final LongAdder backgroundWriteFailures = new LongAdder();
    private final LongAdder backgroundWriteTotal = new LongAdder();
    // Per-merge: cumulative count + millis for the flush+sort+chunk pass that runs inside each merge.  
    public void addIndexTimeMillis(long ms) {  
        );  
 */  
        indexTimeMillis.add(ms);
    }
            mergeFailures.sum(),
    public void addNativeFinalizeTimeMillis(long ms) {
import java.util.concurrent.atomic.LongAccumulator;  
    }
import java.util.concurrent.atomic.LongAdder;
    public void incNativeWriteRejections() {  
    }
            mergeOutputRowsTotal.sum(),
 * Call {@link #stats()} to obtain an immutable {@link ParquetShardStats} snapshot.  
    // --- Background Write methods ---
    // Background Write counters  
    private final LongAdder backgroundWriteTimeouts = new LongAdder();  
 */  
        mergeInputFilesTotal.add(n);
