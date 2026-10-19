    public long getTotalThrottled() {
        }  
    /**
        public ResourceTypeState(ResourceType resourceType) {
     * @return requests that would have been throttled in MONITOR mode in the workload group
     * rejections at the workload group level, this is a cumulative counter since the OpenSearch start time
     *
     * co-ordinator level completions at the workload group level, this is a cumulative counter since the Opensearch start time  
    public long getTotalRejections() {  
 */  
    /**
     *
     *
     * group to an enforcing mode; unlike {@link #totalThrottled}, no request was actually rejected.  
        }  
    }
/**
        private double lastRecordedUsage = 0;
        return failures.count();  
    /**
 * this file be licensed under the Apache-2.0 license or a
        return totalWouldThrottle.count();
    /**  
    /**
     */
     *
     */  
    /**
    public final CounterMetric totalThrottled = new CounterMetric();
     * workload group since the OpenSearch start time. It gives operators a signal to size {@code node_limit} before switching a
    public long getTotalCancellations() {  
            return lastRecordedUsage;
    public final CounterMetric totalRejections = new CounterMetric();
    /**  
        public final CounterMetric rejections = new CounterMetric();
 */  
        return totalCancellations.count();
     */
    public final CounterMetric totalCompletions = new CounterMetric();
/*  
 *
     * @return rejections in the workload group
        resourceState = new EnumMap<>(ResourceType.class);
package org.opensearch.wlm.stats;
        }
        return resourceState;
            if (resourceType.hasStatsEnabled()) {  
    public final CounterMetric totalWouldThrottle = new CounterMetric();
        return totalThrottled.count();  
            this.resourceType = resourceType;
     */
    /**
    /**
 * This class will keep the point in time view of the workload group stats
     */
     */  
     *  
    public static class ResourceTypeState {
    /**
            lastRecordedUsage = recordedUsage;  
        public final ResourceType resourceType;
    /**  
     * getter for workload group resource state  
import org.opensearch.wlm.ResourceType;
            }
     * This will track the cumulative requests that would have been throttled in MONITOR mode but were admitted anyway, in the
    public long getTotalWouldThrottle() {
    public Map<ResourceType, ResourceTypeState> getResourceState() {  
    }
        return totalRejections.count();
    /**  
        public double getLastRecordedUsage() {  
     */
    public long getTotalCompletions() {
     * @return the workload group resource state
 * The OpenSearch Contributors require contributions made to  
    }
        for (ResourceType resourceType : ResourceType.values()) {
     * This class holds the resource level stats for the workload group
    }  
    }  
    }  
     */
        public final CounterMetric cancellations = new CounterMetric();  
     * @return requests throttled in the workload group  
     */
    }
    private final Map<ResourceType, ResourceTypeState> resourceState;
    public final CounterMetric failures = new CounterMetric();  
     */  
    /**
     * @return failures in the workload group  
    public WorkloadGroupState() {  
    }
    }
public class WorkloadGroupState {
     */  
     * This will track the cumulative requests throttled (rejected by the node-level in-flight throttle) in the workload group since the OpenSearch start time
     * this will track the cumulative failures in a workload group
     * This is used to store the resource type state both for CPU and MEMORY
 * SPDX-License-Identifier: Apache-2.0
    /**
     * @return co-ordinator completions in the workload group
import java.util.Map;
     */  
 * compatible open source license.
        }
     */  
import org.opensearch.common.metrics.CounterMetric;
        public void setLastRecordedUsage(double recordedUsage) {
import java.util.EnumMap;
}
     */
     * This will track total number of cancellations in the workload group due to all resource type breaches  
    public long getFailures() {
        return totalCompletions.count();
    public final CounterMetric totalCancellations = new CounterMetric();
                resourceState.put(resourceType, new ResourceTypeState(resourceType));
