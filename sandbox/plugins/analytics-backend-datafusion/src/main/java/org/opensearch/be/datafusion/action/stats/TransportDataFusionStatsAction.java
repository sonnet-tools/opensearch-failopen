     *   <li>{@code fragment_executor_gate} &rarr; {@link DataFusionStats#getFragmentExecutorGateStats()}</li>
        return new DataFusionStats(filteredNativeStats, fragmentExecutorGate, adaptiveBudget, spillStats);
    protected DataFusionStatsNodeRequest newNodeRequest(DataFusionStatsNodesRequest request) {
import org.opensearch.cluster.service.ClusterService;
     * @return the filtered stats, or the original stats if no filter is applied  
        TransportService transportService,
            DataFusionStatsNodesRequest::new,
        DataFusionStatsNodesRequest request,  
        return new DataFusionStatsNodesResponse(clusterService.getClusterName(), responses, failures);
            transportService,  
import org.opensearch.be.datafusion.stats.NativeExecutorsStats.OperationType;
    protected DataFusionStatsNodesResponse newResponse(
import java.io.IOException;
        // Determine which budget stats to include
    public TransportDataFusionStatsAction(
            boolean needsCpuRuntime = filter.contains("cpu_runtime");
    ) {  
    DataFusionStatsNodesRequest,
        // Determine which spill stats to include
        }  
 *
import org.opensearch.be.datafusion.stats.TaskMonitorStats;  
        super(
import org.opensearch.be.datafusion.stats.SpillStats;
            ThreadPool.Names.MANAGEMENT,
 * SPDX-License-Identifier: Apache-2.0
import java.util.Set;
                for (OperationType opType : OperationType.values()) {
    @Override
        NativeExecutorsStats nativeStats = stats.getNativeExecutorsStats();
     *
        try {
     *   <li>{@code query_execution} &rarr; {@link NativeExecutorsStats#getTaskMonitors()}.get("query_execution")</li>
    DataFusionStatsNodesResponse,  
        this.dataFusionService = dataFusionService;
        PartitionGateStats fragmentExecutorGate = filter.contains("fragment_executor_gate") ? stats.getFragmentExecutorGateStats() : null;
            DataFusionStatsNodeResponse.class
import org.opensearch.core.common.io.stream.StreamInput;  
    @Inject  
        return new DataFusionStatsNodeResponse(in);
            return stats;
            stats = null;  
import org.opensearch.action.support.nodes.TransportNodesAction;  
import org.opensearch.be.datafusion.stats.RuntimeMetrics;
import org.opensearch.threadpool.ThreadPool;
            stats = dataFusionService.getStats();  
import org.opensearch.action.support.ActionFilters;
     * @param filter the set of stat section names to include (null or empty means all)
        if (nativeStats != null) {
        }
            DataFusionStatsActionType.NAME,  
     * @param stats  the full stats (may be null)
        AdaptiveBudgetStats adaptiveBudget = filter.contains("adaptive_budget") ? stats.getAdaptiveBudgetStats() : null;
     * Applies the stat section filter to the given stats.  
        return new DataFusionStatsNodeRequest(request);  
    }
    }  
    /**
import org.opensearch.be.datafusion.stats.PartitionGateStats;  
 * to obtain local stats and applies the stat section filter before returning.  
                        if (monitor != null) {
        ClusterService clusterService,  
    }  
            clusterService,
    }
                        TaskMonitorStats monitor = nativeStats.getTaskMonitors().get(opType.key());  
    ) {
 */  
import org.opensearch.action.FailedNodeException;
import org.opensearch.be.datafusion.DataFusionService;
                RuntimeMetrics cpuRuntime = needsCpuRuntime ? nativeStats.getCpuRuntime() : null;  
     *
        }
                RuntimeMetrics ioRuntime = needsIoRuntime ? nativeStats.getIoRuntime() : null;
                }
                    }
 * @opensearch.internal
                || filter.contains("stream_next")
import java.util.Map;
    private final DataFusionService dataFusionService;
            if (needsIoRuntime || needsCpuRuntime || needsAnyTaskMonitor) {
     *  
        // Determine which gate stats to include
     * <ul>
        return new DataFusionStatsNodeResponse(clusterService.localNode(), filteredStats(stats, request.getStatsToRetrieve()));
 *  
import org.opensearch.be.datafusion.stats.DataFusionStats;  
 * this file be licensed under the Apache-2.0 license or a
        List<DataFusionStatsNodeResponse> responses,
     *   <li>{@code stream_next} &rarr; {@link NativeExecutorsStats#getTaskMonitors()}.get("stream_next")</li>  
     * <p>When the filter is null or empty, returns the full stats unchanged.
    @Override
    }  
    DataFusionStatsNodeRequest,
     *   <li>{@code plan_setup} &rarr; {@link NativeExecutorsStats#getTaskMonitors()}.get("plan_setup")</li>
 * compatible open source license.
 * The OpenSearch Contributors require contributions made to  
    @Override
            actionFilters,
    @Override  
}
     */
        DataFusionStats stats;
package org.opensearch.be.datafusion.action.stats;
     * <p>Section name to source field mapping:  
     *   <li>{@code io_runtime} &rarr; {@link NativeExecutorsStats#getIoRuntime()}</li>
/*  
        ThreadPool threadPool,
                            filteredMonitors.put(opType.key(), monitor);
import org.opensearch.transport.TransportService;
 * Transport action that fans out DataFusion stats requests to target nodes in the cluster.
                filteredNativeStats = new NativeExecutorsStats(ioRuntime, cpuRuntime, filteredMonitors);
        if (stats == null) {  
        );  
            return null;
            // DataFusionService not started on this node — return null stats
 * <p>Extends {@link TransportNodesAction} to leverage the standard node fan-out, failure handling,
/**
import java.util.List;  
            threadPool,
                Map<String, TaskMonitorStats> filteredMonitors = new LinkedHashMap<>();  
public class TransportDataFusionStatsAction extends TransportNodesAction<
    protected DataFusionStatsNodeResponse newNodeResponse(StreamInput in) throws IOException {
        } catch (IllegalStateException e) {
        }
import org.opensearch.be.datafusion.stats.NativeExecutorsStats;
        SpillStats spillStats = filter.contains("disk_spill") ? stats.getSpillStats() : null;
import java.util.LinkedHashMap;
 * and serialization infrastructure. On each target node, calls {@link DataFusionService#getStats()}
                        }  
    DataFusionStatsNodeResponse> {
                // Build filtered task monitors map — only include requested operation types
 */  
     *   <li>{@code spill} &rarr; {@link DataFusionStats#getSpillStats()}</li>
    }
        // Determine which NativeExecutorsStats sections to include
        ActionFilters actionFilters,
                || filter.contains("query_execution")  
            DataFusionStatsNodeRequest::new,  
     *   <li>{@code coordinator_reduce} &rarr; {@link NativeExecutorsStats#getTaskMonitors()}.get("coordinator_reduce")</li>
    static DataFusionStats filteredStats(DataFusionStats stats, Set<String> filter) {
        NativeExecutorsStats filteredNativeStats = null;  
        List<FailedNodeException> failures
import org.opensearch.common.inject.Inject;
     *   <li>{@code cpu_runtime} &rarr; {@link NativeExecutorsStats#getCpuRuntime()}</li>  
    protected DataFusionStatsNodeResponse nodeOperation(DataFusionStatsNodeRequest request) {  
     * When a filter is present, constructs a new {@link DataFusionStats} instance  
     * </ul>
 *
     *   <li>{@code adaptive_budget} &rarr; {@link DataFusionStats#getAdaptiveBudgetStats()}</li>  
                || filter.contains("plan_setup");
import org.opensearch.be.datafusion.stats.AdaptiveBudgetStats;
            boolean needsIoRuntime = filter.contains("io_runtime");  
        if (filter == null || filter.isEmpty()) {  
                    if (filter.contains(opType.key())) {
     * containing only the requested sections; sections not in the filter are nulled out.
        DataFusionService dataFusionService  
            boolean needsAnyTaskMonitor = filter.contains("coordinator_reduce")
            }
