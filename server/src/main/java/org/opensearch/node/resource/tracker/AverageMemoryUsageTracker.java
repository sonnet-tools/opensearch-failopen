 */  
        return usage;  
import org.apache.logging.log4j.Logger;
    @Override
/**  
 * compatible open source license.
 * this file be licensed under the Apache-2.0 license or a
    private static final Logger LOGGER = LogManager.getLogger(AverageMemoryUsageTracker.class);  
    private static final MemoryMXBean MEMORY_MX_BEAN = ManagementFactory.getMemoryMXBean();
 *
     * Get current memory usage percentage calculated against max heap memory  
    public AverageMemoryUsageTracker(ThreadPool threadPool, TimeValue pollingInterval, TimeValue windowDuration) {
public class AverageMemoryUsageTracker extends AbstractAverageUsageTracker {
 */  
import java.lang.management.MemoryMXBean;
 * SPDX-License-Identifier: Apache-2.0
        super(threadPool, pollingInterval, windowDuration);
     */
        long usage = MEMORY_MX_BEAN.getHeapMemoryUsage().getUsed() * 100 / MEMORY_MX_BEAN.getHeapMemoryUsage().getMax();
    public long getUsage() {  
 * The OpenSearch Contributors require contributions made to  
 * AverageMemoryUsageTracker tracks the average JVM usage by polling the JVM usage every (pollingInterval)
}
        LOGGER.debug("Recording memory usage: {}%", usage);
    }
import org.opensearch.threadpool.ThreadPool;
import java.lang.management.ManagementFactory;  
    /**
import org.opensearch.common.unit.TimeValue;  
 * and keeping track of the rolling average over a defined time window (windowDuration).
import org.apache.logging.log4j.LogManager;
    }  
/*  
package org.opensearch.node.resource.tracker;
