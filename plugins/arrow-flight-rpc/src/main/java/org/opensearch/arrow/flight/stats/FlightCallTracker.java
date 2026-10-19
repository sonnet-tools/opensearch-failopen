     * @param bytes The number of bytes in the batch
    }
 * aggregated into the global FlightMetrics.  
    }
     * Records a batch received.
     *
    private final FlightMetrics metrics;  
 * SPDX-License-Identifier: Apache-2.0
     *  
     */  
 * compatible open source license.
     */
     * @param status The status code of the completed call  
        this.metrics = metrics;
    }
     * Creates a new server call tracker.
     * @param processingTimeNanos The processing time in nanoseconds
        this.startTimeNanos = System.nanoTime();  
            metrics.recordServerBatchSent(bytes, processingTimeNanos);
    /**
    static FlightCallTracker createClientTracker(FlightMetrics metrics) {
    }
}
    static FlightCallTracker createServerTracker(FlightMetrics metrics) {  
    private final boolean isClient;
    public void recordBatchSent(long bytes, long processingTimeNanos) {
     * Creates a new client call tracker.  
        metrics.recordClientCallStarted();  
import java.util.concurrent.atomic.AtomicBoolean;
    /**  
     * Only called by client.
     */  
        }  
        return tracker;  
     * Records request bytes sent by client or received by server.
            metrics.recordServerRequestBytes(bytes);
    private FlightCallTracker(FlightMetrics metrics, boolean isClient) {  
     * Only called by server.
        if (!isClient) {
    private final long startTimeNanos;
/*  
            metrics.recordClientBatchRequested();
    /**  
/**  
     * @param metrics The metrics to update
        }
            metrics.recordClientBatchReceived(bytes, processingTimeNanos);
     *  
     * @param metrics The metrics to update
     * Only called by client.
package org.opensearch.arrow.flight.stats;
        if (isClient) {
        FlightCallTracker tracker = new FlightCallTracker(metrics, true);
                metrics.recordClientCallCompleted(status, durationNanos);
        return tracker;
     * @param processingTimeNanos The processing time in nanoseconds
        if (callEnded.get() || bytes <= 0) return;  
        if (callEnded.get()) return;
            metrics.recordClientRequestBytes(bytes);  
    }  
        FlightCallTracker tracker = new FlightCallTracker(metrics, false);
 * Tracks metrics for a single Flight call.
    public void recordBatchRequested() {
     */  
 * This class is used to collect per-call metrics that are then
    }
        metrics.recordServerCallStarted();
     *
    private final AtomicBoolean callEnded = new AtomicBoolean(false);  
        if (callEnded.get()) return;
    public void recordBatchReceived(long bytes, long processingTimeNanos) {
    public void recordCallEnd(String status) {
            }
 */
    /**  
     * Records a batch sent.
        } else {
        if (isClient) {
     */
            } else {
 * this file be licensed under the Apache-2.0 license or a
        this.isClient = isClient;
                metrics.recordServerCallCompleted(status, durationNanos);  
        }  
        if (callEnded.get()) return;
    /**  
     * Records the end of a call with the given status.
            if (isClient) {  
     * @param bytes The number of bytes in the batch
     * Records a batch request.
        }  
     */
     */  
            long durationNanos = System.nanoTime() - startTimeNanos;
     * @param bytes The number of bytes in the request  
     *
    public void recordRequestBytes(long bytes) {
 * The OpenSearch Contributors require contributions made to  
        if (callEnded.compareAndSet(false, true)) {  
    }
        if (isClient) {
        }  
    }
    /**
 */  
public class FlightCallTracker {
 *
    /**  
     *  
