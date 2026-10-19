    }  
    public void recordResourceUsageMetrics(ResourceUsageMetric... resourceUsageMetrics) {  
    /**  
    @Override  
    public String toString() {
 * <p>
 *
     * Updates thread's resource consumption information.
        return statsType;
        this.threadId = threadId;
    }
        return isActive;  
    public long getThreadId() {
    private final ResourceUsageInfo resourceUsageInfo;
    private volatile boolean isActive = true;
    public boolean isActive() {
 * this file be licensed under the Apache-2.0 license or a
@PublicApi(since = "2.1.0")
        this.isActive = isActive;
 *  @opensearch.api  
public class ThreadResourceInfo {  
import org.opensearch.common.annotation.PublicApi;
        return resourceUsageInfo + ", stats_type=" + statsType + ", is_active=" + isActive + ", threadId=" + threadId;
    }  
 * compatible open source license.
package org.opensearch.core.tasks.resourcetracker;
}
 * Resource consumption information about a particular execution of thread.
    }
    private final long threadId;
 */
    public ResourceStatsType getStatsType() {  
 *
    }
 * for a specific stats type like worker_stats or response_stats etc.,
    }
/*  
        this.statsType = statsType;
 * It captures the resource usage information about a particular execution of thread  
    public void setActive(boolean isActive) {
        this.resourceUsageInfo = new ResourceUsageInfo(resourceUsageMetrics);  
        return threadId;
        return resourceUsageInfo;  
        resourceUsageInfo.recordResourceUsageMetrics(resourceUsageMetrics);
    public ResourceUsageInfo getResourceUsageInfo() {
    public ThreadResourceInfo(long threadId, ResourceStatsType statsType, ResourceUsageMetric... resourceUsageMetrics) {  
    }  
 * SPDX-License-Identifier: Apache-2.0
/**  
 */  
 * The OpenSearch Contributors require contributions made to  
    }
     */
    private final ResourceStatsType statsType;  
