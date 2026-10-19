            serverThreadsTotal,
        return FlightCallTracker.createServerTracker(metrics);
            serverThreadsActive,  
        );
    }
     * @return A new server call tracker
        return metrics;  
    }  
    protected void doStart() {}
        int clientThreadsTotal = 0;  
    /**
 * SPDX-License-Identifier: Apache-2.0
        }
     */
        clientChannelsActive.decrementAndGet();
import org.opensearch.common.lifecycle.AbstractLifecycleComponent;  
     * Sets the thread pool for thread stats
            clientChannelsActive.get(),
        long arrowPeakBytes = 0;
        this.threadPool = threadPool;
/*  
    }
     */
     *
     */
import org.apache.arrow.memory.BufferAllocator;
    }
     * Increments the count of active server channels.
    /**
                if (ServerConfig.FLIGHT_CLIENT_THREAD_POOL_NAME.equals(stat.getName())) {
     * @param threadPool the thread pool
        int clientThreadsActive = 0;
        clientChannelsActive.incrementAndGet();
    /**
     * Creates a new server call tracker for tracking metrics of a server call.
                    serverThreadsTotal += stat.getThreads();  
}  
                }
     * @param bufferAllocator the buffer allocator
    /**  
                    clientThreadsTotal += stat.getThreads();  
    public void setBufferAllocator(BufferAllocator bufferAllocator) {  
    /**
 */
        updateResourceMetrics();
     * Collects current Flight transport statistics  
        // Update metrics with resource utilization
     * Decrements the count of active server channels.  
    private final AtomicInteger clientChannelsActive = new AtomicInteger(0);
                    serverThreadsActive += stat.getActive();
     * Creates a new Flight stats collector  
        try {
        int serverThreadsActive = 0;
        metrics.updateResourceMetrics(  
     *  
    }  
    @Override
    @Override
     * Sets the Arrow buffer allocator for memory stats
    }
     */
    @Override
 * The OpenSearch Contributors require contributions made to  
    public void decrementClientChannelsActive() {
 * This is the main entry point for metrics collection in the Arrow Flight transport.
            }
    /**
     *  
    private void updateResourceMetrics() {  
     * @return The current metrics
    }
    private volatile BufferAllocator bufferAllocator;
    }
import org.opensearch.threadpool.ThreadPool;
            arrowAllocatedBytes = bufferAllocator.getAllocatedMemory();
            directMemoryBytes = memoryBean.getNonHeapMemoryUsage().getUsed();  
     */
    public FlightCallTracker createClientCallTracker() {  
        int serverThreadsTotal = 0;
            arrowPeakBytes = bufferAllocator.getPeakMemoryAllocation();  
     */
 */  
    protected void doStop() {}
     *  
        if (threadPool != null) {
     * @return A new client call tracker
    }
    /**
    public FlightStatsCollector() {}
            clientThreadsTotal,
    public void incrementServerChannelsActive() {
    public void incrementClientChannelsActive() {  
            java.lang.management.MemoryMXBean memoryBean = java.lang.management.ManagementFactory.getMemoryMXBean();
            arrowPeakBytes,
     * Decrements the count of active client channels.
    private final AtomicInteger serverChannelsActive = new AtomicInteger(0);
        this.bufferAllocator = bufferAllocator;
    public void decrementServerChannelsActive() {
 * Collects Flight transport statistics from various components.  
package org.opensearch.arrow.flight.stats;
     */  
     * Creates a new client call tracker for tracking metrics of a client call.
    private final FlightMetrics metrics = new FlightMetrics();  
            arrowAllocatedBytes,
        } catch (Exception e) {
        if (bufferAllocator != null) {
     *  
            serverChannelsActive.get()  
        }  
     * Increments the count of active client channels.
 *
     */  
        }  
            directMemoryBytes = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
            directMemoryBytes,  
        return FlightCallTracker.createClientTracker(metrics);
import java.util.concurrent.atomic.AtomicInteger;  
 * compatible open source license.
                    clientThreadsActive += stat.getActive();
     */
        serverChannelsActive.decrementAndGet();  
/**
 * this file be licensed under the Apache-2.0 license or a
            var allStats = threadPool.stats();
    /**
                } else if (ServerConfig.FLIGHT_SERVER_THREAD_POOL_NAME.equals(stat.getName())) {
            for (var stat : allStats) {  
public class FlightStatsCollector extends AbstractLifecycleComponent {  
        long directMemoryBytes = 0;  
    public void setThreadPool(ThreadPool threadPool) {  
import org.opensearch.arrow.flight.bootstrap.ServerConfig;
    /**
        long arrowAllocatedBytes = 0;
    private volatile ThreadPool threadPool;  
    protected void doClose() {}
    public FlightMetrics collectStats() {
     */  
    public FlightCallTracker createServerCallTracker() {  
    /**
    }
        serverChannelsActive.incrementAndGet();
            clientThreadsActive,
