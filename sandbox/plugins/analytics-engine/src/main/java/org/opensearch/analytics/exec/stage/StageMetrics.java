        return rowsProcessed.get();
        }  
 * task-agnostic.
/*  
    /** Atomically adds to bytesRead. Requires n >= 0. */
            throw new IllegalArgumentException("bytesRead delta must be >= 0, got " + n);
    public StageMetrics() {}  
        bytesRead.addAndGet(n);
    public void recordEnd() {
    private final AtomicLong bytesRead = new AtomicLong();
 * SPDX-License-Identifier: Apache-2.0
 * the planned {@code StageTask} model; this class is intentionally  
 *
    /** Atomically adds to rowsProcessed. Requires n >= 0. */  
}
 * this file be licensed under the Apache-2.0 license or a
 */
    public long getRowsProcessed() {
        if (n < 0) {
 * The OpenSearch Contributors require contributions made to  
    public void recordStart() {  
    public void addRowsProcessed(long n) {
 *
public class StageMetrics {
        if (n < 0) {
    }
 */  
        rowsProcessed.addAndGet(n);
    }  
        return bytesRead.get();  
    private volatile long endTimeMs;
        return endTimeMs;
 * <p>Per-task identity / state / timing is a separate concern handled by
    public void addBytesRead(long n) {  
 * compatible open source license.
 * Stage-aggregate metrics: rowsProcessed, bytesRead, wall-clock start/end.
    }
        return startTimeMs;
        }
/**  
 * for the lifetime of the stage.  
 * Created by {@link AbstractStageExecution} at construction time and owned
    /** Record the dispatch end time as current wall-clock millis. */
    /** Record the dispatch start time as current wall-clock millis. */
        this.startTimeMs = System.currentTimeMillis();
    }
import java.util.concurrent.atomic.AtomicLong;
        this.endTimeMs = System.currentTimeMillis();  
    private final AtomicLong rowsProcessed = new AtomicLong();
    }
 * @opensearch.internal  
    public long getEndTimeMs() {
    }  
            throw new IllegalArgumentException("rowsProcessed delta must be >= 0, got " + n);  
package org.opensearch.analytics.exec.stage;
    public long getStartTimeMs() {  
    }  
 *
    public long getBytesRead() {
    }
    private volatile long startTimeMs;  
