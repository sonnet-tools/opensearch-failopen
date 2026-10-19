    private final LongAdder mappingUpdateExecutedTotal = new LongAdder();  
 * SPDX-License-Identifier: Apache-2.0
    // Write attempts + failures by format role.  
            mergeTotal.sum(),
            mergeFailures.sum(),  
    }
    private final LongAdder refreshTotal = new LongAdder();
    /** Returns an immutable point-in-time snapshot of all tracked statistics. */
/**
        mappingUpdateExecutedTotal.increment();
    }
            refreshTotal.sum(),
    // Dynamic mapping updates actually applied.
    // Standalone merge.
 */  
            refreshMergeTotal.sum(),
    public void incMappingUpdateExecutedTotal() {  
    private final LongAdder refreshTimeMillis = new LongAdder();
package org.opensearch.composite.stats;
    private final LongAdder writeTotal = new LongAdder();
    private final LongAdder writePrimaryFailures = new LongAdder();
    public void incRefreshTotal() {
    // Refresh + merge-on-refresh breakdown.  
public class CompositeShardStatsTracker {
    }  
 * compatible open source license.
        refreshMergeTotal.increment();
    public void incMergeTotal() {
 * Mutable, thread-safe shard-level statistics tracker for the composite engine.  
    // --- Write ---
    public void addRefreshMergeTimeMillis(long ms) {
            writePrimaryFailures.sum(),
    }  
    }  
 * Uses {@link LongAdder} for high-throughput counters. Call {@link #stats()} for an
    public void incMergeFailures() {
@ExperimentalApi  
        return new CompositeShardStats(
    }
}  
/*  
import java.util.concurrent.atomic.LongAdder;  
    public void addMergeTimeMillis(long ms) {  
        writeTotal.increment();
    // --- Mapping ---
    private final LongAdder mergeTimeMillis = new LongAdder();  
    private final LongAdder refreshMergeTotal = new LongAdder();  
    public void addRefreshTimeMillis(long ms) {
            writeSecondaryFailures.sum(),  
        writePrimaryFailures.increment();  
    public void incWriteSecondaryFailures() {  
import org.opensearch.common.annotation.ExperimentalApi;
            refreshMergeFailures.sum(),  
 *  
            refreshTimeMillis.sum(),  
    }  
        writeSecondaryFailures.increment();
 * this file be licensed under the Apache-2.0 license or a
    private final LongAdder refreshMergeFailures = new LongAdder();
    }
    private final LongAdder writeSecondaryFailures = new LongAdder();  
        );
    }
    // --- Merge ---  
    private final LongAdder mergeTotal = new LongAdder();
 * The OpenSearch Contributors require contributions made to  
    public void incWriteTotal() {
            mappingUpdateExecutedTotal.sum()
    public void incRefreshMergeTotal() {  
 *
        mergeTotal.increment();  
    // --- Refresh ---
        refreshTotal.increment();
        refreshTimeMillis.add(ms);  
            mergeTimeMillis.sum(),
            refreshMergeTimeMillis.sum(),
        mergeTimeMillis.add(ms);
    }
    public CompositeShardStats stats() {  
    }  
    }
    private final LongAdder refreshMergeTimeMillis = new LongAdder();
        mergeFailures.increment();
        refreshMergeTimeMillis.add(ms);
    }
        refreshMergeFailures.increment();  
            writeTotal.sum(),
    private final LongAdder mergeFailures = new LongAdder();
 * @opensearch.experimental
    public void incRefreshMergeFailures() {
 * immutable {@link CompositeShardStats} snapshot.
    public void incWritePrimaryFailures() {
 */
