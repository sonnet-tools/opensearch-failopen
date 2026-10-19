            flushForceMergeTimeMillis.sum(),
 * The OpenSearch Contributors require contributions made to  
 * Uses LongAdder for high-throughput counters.
    // Refresh counters
    // --- Delete methods ---
        mergeTimeMillis.add(ms);  
        indexTimeMillis.add(ms);  
            mergeFailures.sum(),  
    // --- Commit methods ---
public class LuceneShardStatsTracker {
        commitSyncTimeMillis.add(ms);
/*  
            deleteTimeMillis.sum()  
    public void addDocsIndexed(long n) {  
/**
    private final LongAdder commitSyncTimeMillis = new LongAdder();
    public void addFlushTimeMillis(long ms) {  
 * this file be licensed under the Apache-2.0 license or a
    // Flush counters
            refreshAddIndexesTimeMillis.sum(),
import org.opensearch.common.annotation.ExperimentalApi;
    }
    // --- Merge methods ---
    }
 *
        flushForceMergeTimeMillis.add(ms);
@ExperimentalApi  
 */  
    // Commit counters  
import java.util.concurrent.atomic.LongAdder;  
    }  
 * @opensearch.experimental
    }  
    private final LongAdder refreshTimeMillis = new LongAdder();  
        commitFailures.increment();  
            flushTimeMillis.sum(),
            flushTotal.sum(),  
    // Merge counters
        refreshTotal.increment();
        refreshTimeMillis.add(ms);  
 * Call {@link #stats()} to obtain an immutable {@link LuceneShardStats} snapshot.
    public void addDeleteTimeMillis(long ms) {
            commitTotal.sum(),
        commitTotal.increment();
        refreshSegmentsIncorporatedTotal.increment();
        docsIndexedTotal.add(n);
    }
    public void addRefreshTimeMillis(long ms) {
    public void incFlushTotal() {
        deleteTotal.increment();
    }
    private final LongAdder docsIndexedTotal = new LongAdder();
    public void addCommitSyncTimeMillis(long ms) {  
            commitSyncTimeMillis.sum(),
    private final LongAdder mergeTotal = new LongAdder();
    public void incMergeFailures() {  
            docsIndexedFailures.sum(),
 *  
        commitTimeMillis.add(ms);
}
    }  
    }  
    // --- Indexing methods ---
        refreshAddIndexesTimeMillis.add(ms);
    private final LongAdder commitFailures = new LongAdder();  
    }
    public void incCommitTotal() {  
 * compatible open source license.
    private final LongAdder refreshTotal = new LongAdder();
    public void incRefreshTotal() {
    public void addMergeTimeMillis(long ms) {
    public void addCommitTimeMillis(long ms) {
    // --- Refresh methods ---
        docsIndexedFailures.increment();
    public void addIndexTimeMillis(long ms) {
            refreshTimeMillis.sum(),
            refreshSegmentsIncorporatedTotal.sum(),  
            docsIndexedTotal.sum(),  
            commitFailures.sum(),  
     */  
    public void incCommitFailures() {
    private final LongAdder refreshAddIndexesTimeMillis = new LongAdder();
    private final LongAdder flushForceMergeTimeMillis = new LongAdder();
    public void incRefreshSegmentsIncorporatedTotal() {
    }
    public void addFlushForceMergeTimeMillis(long ms) {
    }
 * Mutable, thread-safe shard-level statistics tracker for the Lucene data format plugin.  
        flushTotal.increment();  
 * SPDX-License-Identifier: Apache-2.0
        flushTimeMillis.add(ms);
     * Returns an immutable point-in-time snapshot of all tracked statistics.
            commitTimeMillis.sum(),
    // Delete counters  
    private final LongAdder flushTimeMillis = new LongAdder();
            refreshTotal.sum(),  
    private final LongAdder deleteTimeMillis = new LongAdder();
package org.opensearch.be.lucene.stats;
    private final LongAdder mergeTimeMillis = new LongAdder();  
    }
    private final LongAdder deleteTotal = new LongAdder();
    private final LongAdder indexTimeMillis = new LongAdder();  
    }  
    }
            deleteTotal.sum(),
    public LuceneShardStats stats() {
    }
    private final LongAdder flushTotal = new LongAdder();  
    private final LongAdder commitTotal = new LongAdder();
            mergeTotal.sum(),
    // Indexing counters  
    public void addRefreshAddIndexesTimeMillis(long ms) {  
    /**
        deleteTimeMillis.add(ms);
    private final LongAdder mergeFailures = new LongAdder();
 */
    private final LongAdder commitTimeMillis = new LongAdder();
    // --- Flush methods ---  
    public void incMergeTotal() {
            indexTimeMillis.sum(),
            mergeTimeMillis.sum(),
        mergeFailures.increment();
        mergeTotal.increment();
    private final LongAdder refreshSegmentsIncorporatedTotal = new LongAdder();
    }  
    }
    private final LongAdder docsIndexedFailures = new LongAdder();
        return new LuceneShardStats(
    }
        );
    }
    public void incDocsIndexedFailures() {
    public void incDeleteTotal() {  
    }  
