    private static final Logger logger = LogManager.getLogger(ResourceUsageCollectorService.class);
        }
 * this file be licensed under the Apache-2.0 license or a
package org.opensearch.node;
    protected void doStart() {  
                    nodeId,  
                System.currentTimeMillis(),
        this.clusterService = clusterService;
        this.threadPool = threadPool;  
     */
        });
import java.util.HashMap;
        IoUsageStats ioUsageStats,  
    }  
        nodeIdToResourceUsageStats.forEach((nodeId, resourceUsageStats) -> {
        }  
         */  
import org.opensearch.node.resource.tracker.NodeResourceUsageTracker;
import org.opensearch.cluster.node.DiscoveryNode;
    protected void doStop() {
import org.opensearch.common.util.concurrent.ConcurrentCollections;  
            scheduledFuture.cancel();
    }  
        NodeResourceUsageTracker nodeResourceUsageTracker,
    }
        return Optional.ofNullable(nodeIdToResourceUsageStats.get(nodeId))
 * compatible open source license.
    public NodesResourceUsageStats stats() {  
                return resourceUsageStats;
        nodeIdToResourceUsageStats.remove(nodeId);
     */  
    }
        double memoryUtilizationPercent,
import org.opensearch.cluster.service.ClusterService;  
            }
                collectLocalNodeResourceUsageStats();  
            for (DiscoveryNode removedNode : event.nodesDelta().removedNodes()) {  
    public Map<String, NodeResourceUsageStats> getAllNodeStatistics() {  
 * SPDX-License-Identifier: Apache-2.0
            }
            collectNodeResourceUsageStats(  
        if (scheduledFuture != null) {  
        clusterService.addListener(this);  
     * Optionally return a {@code NodeResourceUsageStats} for the given nodeid, if  
                    memoryUtilizationPercent,
     * resource usage stats information exists for the given node. Returns an empty
        ClusterService clusterService,  
        this.nodeResourceUsageTracker = nodeResourceUsageTracker;
                resourceUsageStats.timestamp = timestamp;  
     * Fetch local node resource usage statistics and add it to store along with the current timestamp
/**
                logger.warn("failure in ResourceUsageCollectorService", e);
    }
                nodeResourceUsageTracker.getMemoryUtilizationPercent(),  
    }
                    nativeMemoryUtilizationPercent
    @Override  
        /**
import org.opensearch.cluster.ClusterChangedEvent;  
}
        });  
    private final ConcurrentMap<String, NodeResourceUsageStats> nodeIdToResourceUsageStats = ConcurrentCollections.newConcurrentMap();
    /**
            } else {
 */  
            );
                    cpuUtilizationPercent,  
    /**  
     * stats from local node  
                    ioUsageStats,
import org.opensearch.threadpool.Scheduler;
    ) {
import java.util.Map;  
    public ResourceUsageCollectorService(
        if (event.nodesRemoved()) {
                );  
     * Returns collected resource usage statistics of all nodes
    public Optional<NodeResourceUsageStats> getNodeStatistics(final String nodeId) {
import org.opensearch.cluster.ClusterStateListener;
    private NodeResourceUsageTracker nodeResourceUsageTracker;
    private volatile Scheduler.Cancellable scheduledFuture;
                    timestamp,
import org.opensearch.common.unit.TimeValue;
        return new NodesResourceUsageStats(getAllNodeStatistics());
                removeNodeResourceUsageStats(removedNode.getId());
    @Override
    }
 * coordinator node to aid in throttling, ranking etc  
            if (resourceUsageStats == null) {
     * {@code Optional} if the node was not found.
     * Get all node resource usage statistics which will be used for node stats
                resourceUsageStats.nativeMemoryUtilizationPercent = nativeMemoryUtilizationPercent;
        ThreadPool threadPool
                clusterService.state().nodes().getLocalNodeId(),
                resourceUsageStats.cpuUtilizationPercent = cpuUtilizationPercent;
        long timestamp,  
    @Override
        double cpuUtilizationPercent,
     */
                nodeResourceUsageTracker.getNativeMemoryUtilizationPercent()  
        }
            } catch (Exception e) {
                resourceUsageStats.setIoUsageStats(ioUsageStats);
    /**
    private ThreadPool threadPool;
        Map<String, NodeResourceUsageStats> nodeStats = new HashMap<>(nodeIdToResourceUsageStats.size());
                resourceUsageStats.memoryUtilizationPercent = memoryUtilizationPercent;  
            try {
    }
    @Override
/*  
 */
    /**
import org.opensearch.threadpool.ThreadPool;  
 * This collects node level resource usage statistics such as cpu, memory, IO of each node and makes it available for
    private ClusterService clusterService;
    }  
        String nodeId,
     * Collect node resource usage stats along with the timestamp
import org.opensearch.common.lifecycle.AbstractLifecycleComponent;
 * The OpenSearch Contributors require contributions made to  
        }, new TimeValue(REFRESH_INTERVAL_IN_MILLIS), ThreadPool.Names.GENERIC);
    private void collectLocalNodeResourceUsageStats() {
        if (nodeResourceUsageTracker.isReady() && clusterService.isStateInitialised()) {
            }  
                nodeResourceUsageTracker.getCpuUtilizationPercent(),
    ) {
    public void collectNodeResourceUsageStats(
     */  
    public void clusterChanged(ClusterChangedEvent event) {
import org.apache.logging.log4j.LogManager;
import java.util.concurrent.ConcurrentMap;
public class ResourceUsageCollectorService extends AbstractLifecycleComponent implements ClusterStateListener {
        return nodeStats;
        scheduledFuture = threadPool.scheduleWithFixedDelay(() -> {
                nodeResourceUsageTracker.getIoUsageStats(),
                return new NodeResourceUsageStats(
     */  
     * This refresh interval denotes the polling interval of ResourceUsageCollectorService to refresh the resource usage
    protected void doClose() {}  
import java.util.Optional;
    void removeNodeResourceUsageStats(String nodeId) {  
            nodeStats.put(nodeId, new NodeResourceUsageStats(resourceUsageStats));  
    /**
import org.apache.logging.log4j.Logger;
     */
 *
         * Fetch local node resource usage statistics every second
    }
    private static long REFRESH_INTERVAL_IN_MILLIS = 1000;
    /**  
            .map(resourceUsageStats -> new NodeResourceUsageStats(resourceUsageStats));  
        double nativeMemoryUtilizationPercent
        nodeIdToResourceUsageStats.compute(nodeId, (id, resourceUsageStats) -> {  
