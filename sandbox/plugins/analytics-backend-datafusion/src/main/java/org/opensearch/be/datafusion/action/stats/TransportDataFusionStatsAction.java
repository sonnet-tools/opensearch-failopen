     * @return the filtered stats, or the original stats if no filter is applied
            threadPool,
        return new DataFusionStatsNodeResponse(in);
            return null;
                    if (filter.contains(opType.key())) {
        PartitionGateStats fragmentExecutorGate = filter.contains("fragment_executor_gate") ? stats.getFragmentExecutorGateStats() : null;
            boolean needsIoRuntime = filter.contains("io_runtime");
import java.util.Map;
     * <p>Section name to source field mapping:
        ThreadPool threadPool,
        DataFusionStats stats;
     *   <li>{@code spill} &rarr; {@link DataFusionStats#getSpillStats()}</li>
import org.opensearch.be.datafusion.stats.SpillStats;
     * Applies the stat section filter to the given stats.
            return stats;
            stats = dataFusionService.getStats();
    ) {
        AdaptiveBudgetStats adaptiveBudget = filter.contains("adaptive_budget") ? stats.getAdaptiveBudgetStats() : null;
                        if (monitor != null) {
            stats = null;
            transportService,
    static DataFusionStats filteredStats(DataFusionStats stats, Set<String> filter) {
        SpillStats spillStats = filter.contains("disk_spill") ? stats.getSpillStats() : null;
 * @opensearch.internal
    /**
import java.util.LinkedHashMap;
     * <p>When the filter is null or empty, returns the full stats unchanged.
        this.dataFusionService = dataFusionService;
 * and serialization infrastructure. On each target node, calls {@link DataFusionService#getStats()}
    protected DataFusionStatsNodeResponse newNodeResponse(StreamInput in) throws IOException {
    DataFusionStatsNodesResponse,
 * <p>Extends {@link TransportNodesAction} to leverage the standard node fan-out, failure handling,
     *   <li>{@code coordinator_reduce} &rarr; {@link NativeExecutorsStats#getTaskMonitors()}.get("coordinator_reduce")</li>
import org.opensearch.be.datafusion.stats.RuntimeMetrics;
    protected DataFusionStatsNodesResponse newResponse(
     *   <li>{@code query_execution} &rarr; {@link NativeExecutorsStats#getTaskMonitors()}.get("query_execution")</li>
    @Override
 * Transport action that fans out DataFusion stats requests to target nodes in the cluster.
            if (needsIoRuntime || needsCpuRuntime || needsAnyTaskMonitor) {
     *   <li>{@code adaptive_budget} &rarr; {@link DataFusionStats#getAdaptiveBudgetStats()}</li>
            DataFusionStatsNodeRequest::new,
 * SPDX-License-Identifier: Apache-2.0
        }
    private final DataFusionService dataFusionService;
 * The OpenSearch Contributors require contributions made to
                for (OperationType opType : OperationType.values()) {
            DataFusionStatsNodeResponse.class
                    }
        if (filter == null || filter.isEmpty()) {
        NativeExecutorsStats nativeStats = stats.getNativeExecutorsStats();
                // Build filtered task monitors map — only include requested operation types
                }
     *   <li>{@code stream_next} &rarr; {@link NativeExecutorsStats#getTaskMonitors()}.get("stream_next")</li>
        } catch (IllegalStateException e) {
import org.opensearch.action.support.nodes.TransportNodesAction;
        TransportService transportService,
import org.opensearch.threadpool.ThreadPool;
 *
/*
        if (nativeStats != null) {
    public TransportDataFusionStatsAction(
 *
import org.opensearch.action.FailedNodeException;
     *   <li>{@code fragment_executor_gate} &rarr; {@link DataFusionStats#getFragmentExecutorGateStats()}</li>
 * compatible open source license.
public class TransportDataFusionStatsAction extends TransportNodesAction<
        // Determine which budget stats to include
        return new DataFusionStatsNodeResponse(clusterService.localNode(), filteredStats(stats, request.getStatsToRetrieve()));
            DataFusionStatsNodesRequest::new,
        return new DataFusionStats(filteredNativeStats, fragmentExecutorGate, adaptiveBudget, spillStats);
        );
                filteredNativeStats = new NativeExecutorsStats(ioRuntime, cpuRuntime, filteredMonitors);
package org.opensearch.be.datafusion.action.stats;
import org.opensearch.transport.TransportService;
import org.opensearch.be.datafusion.stats.TaskMonitorStats;
import org.opensearch.be.datafusion.stats.NativeExecutorsStats;
            }
                RuntimeMetrics cpuRuntime = needsCpuRuntime ? nativeStats.getCpuRuntime() : null;
import java.io.IOException;
}
    protected DataFusionStatsNodeResponse nodeOperation(DataFusionStatsNodeRequest request) {
    }
    DataFusionStatsNodeRequest,
     *
            DataFusionStatsActionType.NAME,
                Map<String, TaskMonitorStats> filteredMonitors = new LinkedHashMap<>();
import java.util.List;
        return new DataFusionStatsNodesResponse(clusterService.getClusterName(), responses, failures);
    @Override
import org.opensearch.be.datafusion.DataFusionService;
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.be.datafusion.stats.DataFusionStats;
        // Determine which spill stats to include
        ActionFilters actionFilters,
    protected DataFusionStatsNodeRequest newNodeRequest(DataFusionStatsNodesRequest request) {
    @Override
        }
     */
                RuntimeMetrics ioRuntime = needsIoRuntime ? nativeStats.getIoRuntime() : null;
        DataFusionService dataFusionService
    @Inject
     * @param stats  the full stats (may be null)
/**
                || filter.contains("stream_next")
        NativeExecutorsStats filteredNativeStats = null;
import org.opensearch.action.support.ActionFilters;
import org.opensearch.cluster.service.ClusterService;
import org.opensearch.core.common.io.stream.StreamInput;
        }
     * <ul>
            boolean needsCpuRuntime = filter.contains("cpu_runtime");
        List<DataFusionStatsNodeResponse> responses,
    DataFusionStatsNodeResponse> {
            ThreadPool.Names.MANAGEMENT,
 *
    }
 */
                        }
            clusterService,
        if (stats == null) {
    }
     * @param filter the set of stat section names to include (null or empty means all)
 * to obtain local stats and applies the stat section filter before returning.
     * containing only the requested sections; sections not in the filter are nulled out.
            boolean needsAnyTaskMonitor = filter.contains("coordinator_reduce")
        super(
     *   <li>{@code cpu_runtime} &rarr; {@link NativeExecutorsStats#getCpuRuntime()}</li>
    ) {
     *   <li>{@code io_runtime} &rarr; {@link NativeExecutorsStats#getIoRuntime()}</li>
import org.opensearch.be.datafusion.stats.NativeExecutorsStats.OperationType;
    @Override
            // DataFusionService not started on this node — return null stats
    }
        // Determine which gate stats to include
        List<FailedNodeException> failures
    }
     * When a filter is present, constructs a new {@link DataFusionStats} instance
                        TaskMonitorStats monitor = nativeStats.getTaskMonitors().get(opType.key());
    }
        ClusterService clusterService,
     *
import org.opensearch.common.inject.Inject;
 */
        try {
import org.opensearch.be.datafusion.stats.AdaptiveBudgetStats;
     *
     * </ul>
import org.opensearch.be.datafusion.stats.PartitionGateStats;
     *   <li>{@code plan_setup} &rarr; {@link NativeExecutorsStats#getTaskMonitors()}.get("plan_setup")</li>
                || filter.contains("plan_setup");
            actionFilters,
                || filter.contains("query_execution")
        DataFusionStatsNodesRequest request,
import java.util.Set;
                            filteredMonitors.put(opType.key(), monitor);
        return new DataFusionStatsNodeRequest(request);
    DataFusionStatsNodesRequest,
        }
        // Determine which NativeExecutorsStats sections to include
