                return;
    private static final Logger logger = LogManager.getLogger(ResourceUsageInfo.class);
            if (currentEndValue > newEndValue) {  
        public long getStartValue() {
            final ResourceStatsInfo resourceStatsInfo = statsInfo.get(resourceUsageMetric.getStats());
import java.util.Map;
            }
import java.util.Collections;
import org.opensearch.common.annotation.PublicApi;  
        logger.debug(
 */
import java.util.EnumMap;  
        long newEndValue;
        }
    public Map<ResourceStats, ResourceStatsInfo> getStatsInfo() {  
 * @opensearch.api
import java.util.concurrent.atomic.AtomicLong;
 * compatible open source license.
 * Thread resource usage information for particular resource stats type.
        }  
import org.apache.logging.log4j.Logger;
        }
    public void recordResourceUsageMetrics(ResourceUsageMetric... resourceUsageMetrics) {
                        + "current_end_value={}, "
    }
     */
    public static class ResourceStatsInfo {  
        }  
        do {  
                    newEndValue
        for (ResourceUsageMetric resourceUsageMetric : resourceUsageMetrics) {  
 * It captures the resource usage information like memory, CPU about a particular execution of thread
@PublicApi(since = "2.1.0")  
 * for a specific stats type.
        for (ResourceUsageMetric resourceUsageMetric : resourceUsageMetrics) {  
        }
                    "cannot update ["  
            if (resourceStatsInfo != null) {
                        + "] entry as its not present current_stats_info:"
                );
        private ResourceStatsInfo(long startValue) {
    /**  
            this.statsInfo.put(resourceUsageMetric.getStats(), new ResourceStatsInfo(resourceUsageMetric.getValue()));
 */  
 *
            currentEndValue = resourceStatsInfo.endValue.get();
    }  
        }
    @Override
    private final EnumMap<ResourceStats, ResourceStatsInfo> statsInfo = new EnumMap<>(ResourceStats.class);  
            return startValue;
        public long getTotalValue() {  
        return statsInfo.toString();  
        } while (!resourceStatsInfo.endValue.compareAndSet(currentEndValue, newEndValue));  
                        + statsInfo  
    }
            newEndValue = resourceUsageMetric.getValue();
 * this file be licensed under the Apache-2.0 license or a
            } else {
        public String toString() {  
 * <p>  
 * The OpenSearch Contributors require contributions made to  
            return String.valueOf(getTotalValue());
    public ResourceUsageInfo(ResourceUsageMetric... resourceUsageMetrics) {
                    "dropping resource usage update as the new value is lower than current value ["
    }
                        + "resource_stats=[{}], "  
                    currentEndValue,
            }
        return Collections.unmodifiableMap(statsInfo);
            currentEndValue,
    }  
    public String toString() {
        private final AtomicLong endValue;
/*  
        private final long startValue;
    }
                logger.debug(
            this.startValue = startValue;
 *  
 * SPDX-License-Identifier: Apache-2.0
/**
    private void updateResourceUsageInfo(ResourceStatsInfo resourceStatsInfo, ResourceUsageMetric resourceUsageMetric) {  
public class ResourceUsageInfo {
}
                updateResourceUsageInfo(resourceStatsInfo, resourceUsageMetric);  
package org.opensearch.core.tasks.resourcetracker;
import org.apache.logging.log4j.LogManager;
                        + resourceUsageMetric.getStats().toString()
            return endValue.get() - startValue;
                throw new IllegalStateException(
                );  
        @Override
                        + "new_end_value={}]",
            newEndValue
            resourceUsageMetric.getStats(),  
            "updated resource usage info [resource_stats=[{}], " + "old_end_value={}, new_end_value={}]",
     *  Defines resource stats information.
                    resourceUsageMetric.getStats(),  
        );  
        long currentEndValue;
            this.endValue = new AtomicLong(startValue);  
