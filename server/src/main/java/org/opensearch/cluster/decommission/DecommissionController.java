        this.nodeRemovalExecutor = new NodeRemovalClusterStateTaskExecutor(allocationService, logger);
import org.opensearch.transport.TransportException;
            @Override
    }
import org.opensearch.cluster.node.DiscoveryNode;
                        "timed out [{}] while waiting for removal of decommissioned nodes [{}]",
            return;
        final ClusterStateObserver.Listener removalListener = new ClusterStateObserver.Listener() {
            nodesToBeDecommissioned.size()
import org.opensearch.cluster.coordination.NodeRemovalClusterStateTaskExecutor;
    }
 *
                }
                    "cluster service closed while waiting for removal of decommissioned nodes [{}]",
                );
                public void handleException(TransportException exp) {
            @Override
        this.clusterService = clusterService;
import org.opensearch.core.common.io.stream.StreamInput;
 */
 */
                );
 * this file be licensed under the Apache-2.0 license or a
                    decommissionStatus,
                    return new NodesStatsResponse(in);
import java.io.IOException;
    ) {
                @Override
     * Once the tasks are submitted, it waits for an expected cluster state to guarantee
            @Override
}
            intersection.retainAll(nodesToBeDecommissioned);
import org.opensearch.core.action.ActionListener;
            transportService.getLocalNode(),
            public void clusterStateProcessed(String source, ClusterState oldState, ClusterState newState) {
import java.util.Map;
     */
                    new OpenSearchTimeoutException(
            public ClusterState execute(ClusterState currentState) {
     * @param nodesToBeDecommissioned set of the node to be decommissioned
        List<NodeStats> responseNodes = nodesStatsResponse.getNodes();
import java.util.Arrays;
        nodesStatsRequest.addMetric(NodesStatsRequest.Metric.HTTP.metricName());
        clusterService.submitStateUpdateTask("update-decommission-status", new ClusterStateUpdateTask(Priority.URGENT) {
            logger.info("Node stats response received is null/empty.");
 * Helper controller class to remove list of nodes from the cluster and update status
        };
            new TransportResponseHandler<NodesStatsResponse>() {
                        nodesToBeDecommissioned.toString()
                    .metadata(Metadata.builder(currentState.metadata()).decommissionAttributeMetadata(decommissionAttributeMetadata))
 *
    public void updateMetadataWithDecommissionStatus(DecommissionStatus decommissionStatus, ActionListener<DecommissionStatus> listener) {
 * compatible open source license.
import org.opensearch.cluster.ClusterStateTaskListener;
    public synchronized void removeDecommissionedNodes(
        );
            @Override
        if (nodes.length == 0) {
                return newState;
                logger.info("successfully removed all decommissioned nodes [{}] from the cluster", nodesToBeDecommissioned.toString());
     * @param listener listener for response and failure
                assert decommissionAttributeMetadata.status().equals(decommissionStatus);
            }
                listener.onResponse(decommissionAttributeMetadata.status());
        final Map<NodeRemovalClusterStateTaskExecutor.Task, ClusterStateTaskListener> nodesDecommissionTasks = new LinkedHashMap<>(
import org.opensearch.action.admin.cluster.node.stats.NodesStatsResponse;
                    return ThreadPool.Names.SAME;
        ThreadPool threadPool
     * that the expected decommissioned nodes are removed from the cluster
            Set<DiscoveryNode> intersection = Arrays.stream(clusterState.nodes().getNodes().values().toArray(new DiscoveryNode[0]))
import java.util.HashMap;
                DecommissionAttributeMetadata decommissionAttributeMetadata = newState.metadata().decommissionAttributeMetadata();
            return intersection.size() == 0;
            ClusterStateTaskConfig.build(Priority.URGENT),
                nodesRemovedListener.onResponse(null);
            return;
import org.opensearch.cluster.ClusterState;
    private final ThreadPool threadPool;
        }
                logger.info(
     */
        Set<DiscoveryNode> nodesToBeDecommissioned,
            }
        Predicate<ClusterState> allDecommissionedNodesRemovedPredicate = clusterState -> {
import org.opensearch.action.admin.cluster.node.stats.NodesStatsAction;
                    newState = clearExclusionsAndGetState(newState);
    private final NodeRemovalClusterStateTaskExecutor nodeRemovalExecutor;
import java.util.List;
        String[] nodes = decommissionedNodes.stream().map(DiscoveryNode::getId).toArray(String[]::new);
import java.util.Set;
            }
            nodesStatsRequest,
        clusterService.submitStateUpdateTasks(
                listener.onFailure(e);
                logger.warn(
import org.opensearch.cluster.ClusterStateTaskConfig;
                if (decommissionStatus.equals(DecommissionStatus.SUCCESSFUL) || decommissionStatus.equals(DecommissionStatus.FAILED)) {
                @Override
import org.opensearch.cluster.ClusterStateObserver;
     *
import org.opensearch.transport.TransportService;
import org.opensearch.cluster.service.ClusterService;
                nodesRemovedListener.onFailure(
                assert decommissionAttributeMetadata != null;
                .collect(Collectors.toSet());
     * @param decommissionStatus status to update decommission metadata with
        });
 * The OpenSearch Contributors require contributions made to
     *
                public String executor() {
        nodesToBeDecommissioned.forEach(discoveryNode -> {
            removalListener.onNewClusterState(clusterService.getClusterApplierService().state());
                    timeout.toString(),
                        timeout.toString(),
import org.opensearch.cluster.metadata.Metadata;
                }
            nodesDecommissionTasks.put(task, nodeRemovalExecutor);
    void getActiveRequestCountOnDecommissionedNodes(Set<DiscoveryNode> decommissionedNodes) {
                public void handleResponse(NodesStatsResponse response) {
        AllocationService allocationService,
        ClusterService clusterService,
                assert decommissionAttributeMetadata != null && decommissionAttributeMetadata.decommissionAttribute() != null;
 * @opensearch.internal
import org.opensearch.cluster.routing.allocation.AllocationService;
            @Override
            public void onClusterServiceClose() {
                    decommissionAttributeMetadata.requestID()
        this.threadPool = threadPool;
    }
                }
        } else {
        this.transportService = transportService;
import java.util.stream.Collectors;
     * @param nodesRemovedListener callback for the success or failure
            }
                    )
                    "timed out [{}] while waiting for removal of decommissioned nodes [{}]",
        }
import org.opensearch.transport.TransportResponseHandler;
                }
/**
import org.opensearch.OpenSearchTimeoutException;
import java.util.function.Predicate;
            }
            "node-decommissioned",
     * This method triggers batch of tasks for nodes to be decommissioned using executor {@link NodeRemovalClusterStateTaskExecutor}
import org.opensearch.common.Priority;
import org.opensearch.action.admin.cluster.node.stats.NodeStats;
        logger.info("Decommissioning node with connections : [{}]", nodeActiveConnectionMap);
        if (allDecommissionedNodesRemovedPredicate.test(clusterService.getClusterApplierService().state())) {
    /**
        final NodesStatsRequest nodesStatsRequest = new NodesStatsRequest(nodes);
    }
    DecommissionController(
            public void onFailure(String source, Exception e) {
    private final ClusterService clusterService;
        TransportService transportService,
            NodesStatsAction.NAME,
                    .build();
                // validateNewStatus can throw IllegalStateException if the sequence of update is not valid
            HttpStats httpStats = responseNodes.get(i).getHttp();
        nodesStatsRequest.clear();
            final NodeRemovalClusterStateTaskExecutor.Task task = new NodeRemovalClusterStateTaskExecutor.Task(discoveryNode, reason);
            }
                // For terminal status we will go ahead and clear any exclusion that was added as part of decommission action
                    decommissionAttributeMetadata.decommissionAttribute(),
                logger.info(
public class DecommissionController {
        if (decommissionedNodes == null || decommissionedNodes.isEmpty()) {
        }
                }
 * SPDX-License-Identifier: Apache-2.0
                    logActiveConnections(response);
    /**
            public void onTimeout(TimeValue timeout) {
                    nodesToBeDecommissioned.toString()
import org.opensearch.cluster.ClusterStateUpdateTask;
    private void logActiveConnections(NodesStatsResponse nodesStatsResponse) {
import org.apache.logging.log4j.LogManager;
        );
                decommissionAttributeMetadata = new DecommissionAttributeMetadata(
                @Override
        );
                decommissionAttributeMetadata.validateNewStatus(decommissionStatus);
        Map<String, Long> nodeActiveConnectionMap = new HashMap<>();
     * @param timeout timeout for the request
                    decommissionAttributeMetadata.status(),
import org.opensearch.common.unit.TimeValue;
    private static final Logger logger = LogManager.getLogger(DecommissionController.class);
            nodesDecommissionTasks,
        final ClusterStateObserver observer = new ClusterStateObserver(clusterService, timeout, logger, threadPool.getThreadContext());
                );
        for (int i = 0; i < responseNodes.size(); i++) {
        if (nodesStatsResponse == null || nodesStatsResponse.getNodes() == null) {
        transportService.sendRequest(
                );
                DecommissionAttributeMetadata decommissionAttributeMetadata = currentState.metadata().decommissionAttributeMetadata();
        TimeValue timeout,
        }
            DiscoveryNode node = responseNodes.get(i).getNode();
            return;
import org.opensearch.action.admin.cluster.node.stats.NodesStatsRequest;
import static org.opensearch.action.admin.cluster.configuration.VotingConfigExclusionsHelper.clearExclusionsAndGetState;
                );
    private final TransportService transportService;
    }
     * This method updates the status in the currently registered metadata.
            }
import org.apache.logging.log4j.Logger;
package org.opensearch.cluster.decommission;
            public void onNewClusterState(ClusterState state) {
    ) {
            nodeRemovalExecutor
        };
                    decommissionStatus
import org.opensearch.http.HttpStats;
        }
            observer.waitForNextChange(removalListener, allDecommissionedNodesRemovedPredicate);
            nodeActiveConnectionMap.put(node.getId(), httpStats.getServerOpen());
        logger.info("submitting state update task to remove [{}] nodes due to decommissioning", nodesToBeDecommissioned.toString());
            @Override
        ActionListener<Void> nodesRemovedListener
/*
                    nodesToBeDecommissioned.toString()
                @Override
                    "attempting to update current decommission status [{}] with expected status [{}]",
     * @param reason reason of removal
import org.opensearch.threadpool.ThreadPool;
                public NodesStatsResponse read(StreamInput in) throws IOException {
                ClusterState newState = ClusterState.builder(currentState)
        String reason,
import java.util.LinkedHashMap;
                    logger.error("Failure occurred while dumping connection for decommission nodes - ", exp.unwrapCause());
        });
