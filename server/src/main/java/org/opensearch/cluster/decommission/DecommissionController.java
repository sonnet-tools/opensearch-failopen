import java.util.Map;  
            observer.waitForNextChange(removalListener, allDecommissionedNodesRemovedPredicate);
import java.util.List;
        }  
        clusterService.submitStateUpdateTask("update-decommission-status", new ClusterStateUpdateTask(Priority.URGENT) {
            "node-decommissioned",  
                    .build();
    private final ThreadPool threadPool;
            }  
    ) {
 * SPDX-License-Identifier: Apache-2.0
        }
        };  
            NodesStatsAction.NAME,  
        }  
                if (decommissionStatus.equals(DecommissionStatus.SUCCESSFUL) || decommissionStatus.equals(DecommissionStatus.FAILED)) {
import org.opensearch.cluster.ClusterStateObserver;  
                listener.onResponse(decommissionAttributeMetadata.status());  
                    "timed out [{}] while waiting for removal of decommissioned nodes [{}]",  
                @Override  
            public void onTimeout(TimeValue timeout) {
/**
        });
                listener.onFailure(e);
                decommissionAttributeMetadata = new DecommissionAttributeMetadata(
import org.apache.logging.log4j.Logger;
                logger.info(  
            nodeRemovalExecutor  
import org.opensearch.cluster.metadata.Metadata;
            final NodeRemovalClusterStateTaskExecutor.Task task = new NodeRemovalClusterStateTaskExecutor.Task(discoveryNode, reason);  
                // validateNewStatus can throw IllegalStateException if the sequence of update is not valid
            @Override
        this.nodeRemovalExecutor = new NodeRemovalClusterStateTaskExecutor(allocationService, logger);  
                }  
        logger.info("submitting state update task to remove [{}] nodes due to decommissioning", nodesToBeDecommissioned.toString());
            DiscoveryNode node = responseNodes.get(i).getNode();  
        };
        if (nodes.length == 0) {
import org.opensearch.common.Priority;  
import java.util.Set;
        });
                    decommissionStatus,  
                nodesRemovedListener.onFailure(
        String[] nodes = decommissionedNodes.stream().map(DiscoveryNode::getId).toArray(String[]::new);
import java.io.IOException;
                );
            @Override
                );  
        ThreadPool threadPool
     * Once the tasks are submitted, it waits for an expected cluster state to guarantee  
        final ClusterStateObserver observer = new ClusterStateObserver(clusterService, timeout, logger, threadPool.getThreadContext());
                    newState = clearExclusionsAndGetState(newState);  
import java.util.function.Predicate;
    }
                    logActiveConnections(response);
    private final ClusterService clusterService;  
        Map<String, Long> nodeActiveConnectionMap = new HashMap<>();
            public void clusterStateProcessed(String source, ClusterState oldState, ClusterState newState) {
 *  
            public void onNewClusterState(ClusterState state) {
            HttpStats httpStats = responseNodes.get(i).getHttp();
import static org.opensearch.action.admin.cluster.configuration.VotingConfigExclusionsHelper.clearExclusionsAndGetState;
            }
            }
                    nodesToBeDecommissioned.toString()
                @Override
                .collect(Collectors.toSet());
        ClusterService clusterService,
    private void logActiveConnections(NodesStatsResponse nodesStatsResponse) {
                        nodesToBeDecommissioned.toString()
import org.opensearch.cluster.service.ClusterService;
            @Override
        if (decommissionedNodes == null || decommissionedNodes.isEmpty()) {
                assert decommissionAttributeMetadata.status().equals(decommissionStatus);
    }
            return;  
                public NodesStatsResponse read(StreamInput in) throws IOException {
        List<NodeStats> responseNodes = nodesStatsResponse.getNodes();  
import org.opensearch.core.action.ActionListener;
import org.opensearch.threadpool.ThreadPool;
        );
public class DecommissionController {
import org.opensearch.transport.TransportService;
import org.opensearch.action.admin.cluster.node.stats.NodesStatsResponse;
        );
                    "cluster service closed while waiting for removal of decommissioned nodes [{}]",
/*  
        Predicate<ClusterState> allDecommissionedNodesRemovedPredicate = clusterState -> {  
                assert decommissionAttributeMetadata != null && decommissionAttributeMetadata.decommissionAttribute() != null;
        String reason,
                );  
        final Map<NodeRemovalClusterStateTaskExecutor.Task, ClusterStateTaskListener> nodesDecommissionTasks = new LinkedHashMap<>(
                );
        Set<DiscoveryNode> nodesToBeDecommissioned,  
                ClusterState newState = ClusterState.builder(currentState)  
     * @param reason reason of removal
import java.util.LinkedHashMap;
                    decommissionAttributeMetadata.requestID()
            public void onFailure(String source, Exception e) {  
                }  
                    decommissionAttributeMetadata.decommissionAttribute(),
 * Helper controller class to remove list of nodes from the cluster and update status
                // For terminal status we will go ahead and clear any exclusion that was added as part of decommission action
                    timeout.toString(),
                public void handleResponse(NodesStatsResponse response) {
    /**
import org.opensearch.transport.TransportResponseHandler;
            @Override
            Set<DiscoveryNode> intersection = Arrays.stream(clusterState.nodes().getNodes().values().toArray(new DiscoveryNode[0]))
            nodesDecommissionTasks,
                    .metadata(Metadata.builder(currentState.metadata()).decommissionAttributeMetadata(decommissionAttributeMetadata))
        transportService.sendRequest(
     */
            }
import org.opensearch.core.common.io.stream.StreamInput;  
        nodesStatsRequest.addMetric(NodesStatsRequest.Metric.HTTP.metricName());
            @Override  
        if (allDecommissionedNodesRemovedPredicate.test(clusterService.getClusterApplierService().state())) {
                    return ThreadPool.Names.SAME;  
import java.util.HashMap;  
                decommissionAttributeMetadata.validateNewStatus(decommissionStatus);  
            ClusterStateTaskConfig.build(Priority.URGENT),
     * that the expected decommissioned nodes are removed from the cluster
                    return new NodesStatsResponse(in);
                logger.info("successfully removed all decommissioned nodes [{}] from the cluster", nodesToBeDecommissioned.toString());  
            nodesStatsRequest,
import java.util.stream.Collectors;  
                    new OpenSearchTimeoutException(
import org.opensearch.action.admin.cluster.node.stats.NodesStatsAction;
 *
        ActionListener<Void> nodesRemovedListener  
 * this file be licensed under the Apache-2.0 license or a
        }  
        }
            }
import java.util.Arrays;
import org.opensearch.cluster.node.DiscoveryNode;  
                public String executor() {
            return;
        TimeValue timeout,
                @Override  
                logger.info(
 * @opensearch.internal
    private final NodeRemovalClusterStateTaskExecutor nodeRemovalExecutor;
    public void updateMetadataWithDecommissionStatus(DecommissionStatus decommissionStatus, ActionListener<DecommissionStatus> listener) {  
package org.opensearch.cluster.decommission;
        for (int i = 0; i < responseNodes.size(); i++) {
                logger.warn(  
                        "timed out [{}] while waiting for removal of decommissioned nodes [{}]",  
            public void onClusterServiceClose() {
                    decommissionAttributeMetadata.status(),
                @Override
import org.opensearch.cluster.ClusterStateTaskConfig;
            transportService.getLocalNode(),
                    decommissionStatus  
            }
                public void handleException(TransportException exp) {  
        nodesStatsRequest.clear();
                }
                nodesRemovedListener.onResponse(null);
import org.opensearch.transport.TransportException;  
            return intersection.size() == 0;
    /**  
     * @param nodesToBeDecommissioned set of the node to be decommissioned  
        if (nodesStatsResponse == null || nodesStatsResponse.getNodes() == null) {  
import org.opensearch.cluster.coordination.NodeRemovalClusterStateTaskExecutor;
            nodesToBeDecommissioned.size()  
     * @param nodesRemovedListener callback for the success or failure  
import org.opensearch.cluster.ClusterState;
import org.opensearch.action.admin.cluster.node.stats.NodeStats;
    }  
    }
        this.transportService = transportService;
            nodeActiveConnectionMap.put(node.getId(), httpStats.getServerOpen());
        this.threadPool = threadPool;
            nodesDecommissionTasks.put(task, nodeRemovalExecutor);
import org.apache.logging.log4j.LogManager;
import org.opensearch.http.HttpStats;
            new TransportResponseHandler<NodesStatsResponse>() {
     * This method updates the status in the currently registered metadata.
import org.opensearch.action.admin.cluster.node.stats.NodesStatsRequest;  
 * compatible open source license.
            intersection.retainAll(nodesToBeDecommissioned);  
     * @param timeout timeout for the request
    DecommissionController(
        logger.info("Decommissioning node with connections : [{}]", nodeActiveConnectionMap);  
        final NodesStatsRequest nodesStatsRequest = new NodesStatsRequest(nodes);  
    private final TransportService transportService;
        TransportService transportService,  
        final ClusterStateObserver.Listener removalListener = new ClusterStateObserver.Listener() {  
     *
                    logger.error("Failure occurred while dumping connection for decommission nodes - ", exp.unwrapCause());
        this.clusterService = clusterService;
                }
 * The OpenSearch Contributors require contributions made to  
     *
     * @param listener listener for response and failure
    void getActiveRequestCountOnDecommissionedNodes(Set<DiscoveryNode> decommissionedNodes) {  
            @Override
                }
     */
    private static final Logger logger = LogManager.getLogger(DecommissionController.class);  
import org.opensearch.OpenSearchTimeoutException;  
        } else {
                    nodesToBeDecommissioned.toString()
    ) {  
import org.opensearch.cluster.routing.allocation.AllocationService;
        nodesToBeDecommissioned.forEach(discoveryNode -> {
            }
            removalListener.onNewClusterState(clusterService.getClusterApplierService().state());  
                    )  
                DecommissionAttributeMetadata decommissionAttributeMetadata = newState.metadata().decommissionAttributeMetadata();  
                assert decommissionAttributeMetadata != null;
                    "attempting to update current decommission status [{}] with expected status [{}]",
            public ClusterState execute(ClusterState currentState) {  
            return;
    public synchronized void removeDecommissionedNodes(
            logger.info("Node stats response received is null/empty.");
     * This method triggers batch of tasks for nodes to be decommissioned using executor {@link NodeRemovalClusterStateTaskExecutor}
 */
     * @param decommissionStatus status to update decommission metadata with  
}
import org.opensearch.cluster.ClusterStateTaskListener;
        AllocationService allocationService,
        );
                DecommissionAttributeMetadata decommissionAttributeMetadata = currentState.metadata().decommissionAttributeMetadata();
    }  
 */  
                return newState;
                        timeout.toString(),
import org.opensearch.cluster.ClusterStateUpdateTask;  
import org.opensearch.common.unit.TimeValue;
        clusterService.submitStateUpdateTasks(
                );
