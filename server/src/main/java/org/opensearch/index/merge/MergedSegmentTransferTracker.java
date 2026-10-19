        totalWarmTimeMillis.inc(time);  
    private final CounterMetric totalWarmTimeMillis = new CounterMetric();
/*  
    private final CounterMetric ongoingWarms = new CounterMetric();
 * SPDX-License-Identifier: Apache-2.0
    private final CounterMetric totalBytesReceived = new CounterMetric();
 *
            totalSendTimeMillis.count(),  
        totalSendTimeMillis.inc(time);
    private final CounterMetric totalBytesSent = new CounterMetric();
    public void incrementTotalWarmInvocationsCount() {
    private final CounterMetric totalWarmFailureCount = new CounterMetric();  
    public MergedSegmentWarmerStats stats() {
    private final CounterMetric totalSendTimeMillis = new CounterMetric();  
        ongoingWarms.inc();  
public class MergedSegmentTransferTracker {
        stats.add(  
 * This includes metrics for pre-copy(warm) invocations, failures, bytes transferred, and timing information.  
    }
/**
 *
            totalWarmTimeMillis.count(),
            totalReceiveTimeMillis.count(),
    public void decrementOngoingWarms() {  
    }  
            totalBytesSent.count(),
            ongoingWarms.count()
 * @opensearch.experimental
    public void addTotalBytesReceived(long bytes) {  
        totalWarmFailureCount.inc();
        final MergedSegmentWarmerStats stats = new MergedSegmentWarmerStats();
package org.opensearch.index.merge;
        totalReceiveTimeMillis.inc(time);
    private final CounterMetric totalReceiveTimeMillis = new CounterMetric();
        return stats;
@ExperimentalApi
    }
    }
 * this file be licensed under the Apache-2.0 license or a
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.common.annotation.ExperimentalApi;
            totalWarmInvocationsCount.count(),
        totalBytesReceived.inc(bytes);
    public void addTotalSendTimeMillis(long time) {  
    }
 * compatible open source license.
        totalWarmInvocationsCount.inc();
        ongoingWarms.dec();
    public void addTotalBytesSent(long bytes) {
    public void addTotalWarmTimeMillis(long time) {
    }  
 * A component that tracks stats related to merged segment replication operations.
        );  
    }
        totalBytesSent.inc(bytes);  
            totalBytesReceived.count(),
    }
}  
            totalWarmFailureCount.count(),  
    public void addTotalReceiveTimeMillis(long time) {
 */  
    public void incrementTotalWarmFailureCount() {
    private final CounterMetric totalWarmInvocationsCount = new CounterMetric();
    public void incrementOngoingWarms() {
    }  
    }
import org.opensearch.common.metrics.CounterMetric;
 */  
