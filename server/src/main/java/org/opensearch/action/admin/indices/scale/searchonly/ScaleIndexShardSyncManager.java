    ) {
            final String nodeId = entry.getKey();  
        Map<String, List<ShardId>> nodeShardGroups = primaryShardsNodes.entrySet()
        boolean hasUncommittedOps = false;
                @Override
                if (shardResponse.needsSync()) {
import org.opensearch.cluster.node.DiscoveryNode;
import java.util.Map;
     * The listener is notified once all nodes have responded or if any errors occur.
            ShardId shardId = new ShardId(indexMetadata.getIndex(), i);
            targetNode,
     *   <li>Dispatches sync requests to each relevant node</li>
 * compatible open source license.
     * This method:  
     * a scale operation. If any shard reports conditions that would make scaling unsafe, the  
     *
     * @param index      the name of the index being scaled
            for (ScaleIndexShardResponse shardResponse : nodeResponse.getShardResponses()) {  
import java.util.ArrayList;
 *   <li>Validating that shards are ready for scale operations</li>
    void validateNodeResponses(Collection<ScaleIndexNodeResponse> responses, ActionListener<ScaleIndexResponse> listener) {  
                    failedShards.add(shardResponse.getShardId().toString());
import org.opensearch.core.action.ActionListener;
    void sendNodeRequest(DiscoveryNode targetNode, String index, List<ShardId> shards, ActionListener<ScaleIndexNodeResponse> listener) {  
/*  
    /**
     */  
    }
                    hasUncommittedOps = true;
 *   <li>Tracking primary shard assignments across the cluster</li>
     * @param listener   the listener to notify with the response
     * Sends a sync request to a specific node for the given shards.
 * The synchronization process is a critical safety mechanism that prevents data loss
        ActionListener<Collection<ScaleIndexNodeResponse>> listener
     * @param shards     the list of shards to synchronize on the target node  
        Map<ShardId, String> primaryShardsNodes,  
     */
     *
     * Aggregates node responses and verifies that no shard reports uncommitted operations or a pending sync.  
    /**  
import org.opensearch.transport.TransportResponseHandler;  
        if (hasUncommittedOps || needsSync) {  
            String errorDetails = "Pre-scale sync failed for shards: "
 */  
    }
/**
        Map<ShardId, String> assignments = new HashMap<>();
     * @param listener  the listener to notify with the aggregated result
            sendNodeRequest(targetNode, index, shards, groupedListener);  
            ShardRouting primaryShard = state.routingTable().index(indexMetadata.getIndex().getName()).shard(i).primaryShard();
            .collect(Collectors.groupingBy(Map.Entry::getValue, Collectors.mapping(Map.Entry::getKey, Collectors.toList())));
import org.opensearch.core.common.io.stream.StreamInput;
                public String executor() {
                + (needsSync ? " - sync needed" : "");
 *
                @Override  
import org.opensearch.cluster.metadata.IndexMetadata;  
        }
        if (primaryShardsNodes.isEmpty()) {  
     * <p>
     * <p>
 * <p>
     * <p>
            final DiscoveryNode targetNode = clusterService.state().nodes().get(nodeId);
        } else {  
        this.transportActionName = transportActionName;  
import org.opensearch.transport.TransportService;
}  
     * <p>  
        }
                }  
     * @param state         the current cluster state
    }  
    private final TransportService transportService;
     * @param listener          the listener to notify when all nodes have responded
     * Returns the primary shard node assignments for a given index.  
 * SPDX-License-Identifier: Apache-2.0
        List<String> failedShards = new ArrayList<>();  
    /**
                @Override  
                + String.join(", ", failedShards)
        return assignments;
            new TransportResponseHandler<ScaleIndexNodeResponse>() {
 *   <li>Aggregating responses from multiple nodes</li>  
    Map<ShardId, String> getPrimaryShardAssignments(IndexMetadata indexMetadata, ClusterState state) {
     */  
     * @param clusterService     the cluster service for accessing cluster state
                public void handleException(TransportException exp) {
                    listener.onResponse(response);
        this.transportService = transportService;
     * </ul>
import org.opensearch.cluster.service.ClusterService;  
import java.util.HashMap;  
 * The OpenSearch Contributors require contributions made to  
            return;
import java.util.List;
     * @param transportService   the transport service for sending requests to other nodes  
     * @param targetNode the node to send the request to
    void sendShardSyncRequests(
     * This mapping is used to determine which nodes need to be contacted for shard  
import java.util.Collection;
import org.opensearch.cluster.routing.ShardRouting;
                }  
 * <ul>
     * @param transportActionName the transport action name for shard sync requests
                @Override
 * This manager coordinates the necessary synchronization across nodes to ensure all shards
import org.opensearch.threadpool.ThreadPool;
/**
            listener.onFailure(new IllegalStateException(errorDetails));
                groupedListener.onFailure(new IllegalStateException("Node [" + nodeId + "] not found"));
                    failedShards.add(shardResponse.getShardId().toString());  
     * @param index             the name of the index being scaled  
import org.opensearch.cluster.ClusterState;
     *  
     * @return a map of shard IDs to node IDs for all assigned primary shards
     * <ul>
                continue;  
            }
                assignments.put(shardId, primaryShard.currentNodeId());
        this.clusterService = clusterService;
                + (hasUncommittedOps ? " - uncommitted operations remain" : "")  
                }
        );
        for (int i = 0; i < indexMetadata.getNumberOfShards(); i++) {  
            }
                    listener.onFailure(exp);  
                if (shardResponse.hasUncommittedOperations()) {
 *   <li>Dispatching sync requests to nodes hosting primary shards</li>
     *
            }
     * This validation ensures that all shards are in a consistent state before proceeding with
     * Constructs a new ShardSyncManager.  
        }
        transportService.sendRequest(
import org.opensearch.transport.TransportException;
     *
                public ScaleIndexNodeResponse read(StreamInput in) throws IOException {
     * This method creates and sends a transport request to perform shard synchronization
import java.io.IOException;  
                }
     *   <li>Creates a grouped listener to aggregate responses</li>  
        }  
                public void handleResponse(ScaleIndexNodeResponse response) {  
 * </ul>  
     * on a target node, registering appropriate response and error handlers.
            }  
     */
 * <p>
    /**
                }
    private final String transportActionName;  
        for (Map.Entry<String, List<ShardId>> entry : nodeShardGroups.entrySet()) {
            transportActionName,  
    }
        String index,
    }  
     * Sends shard sync requests to each node that holds a primary shard.
 * this file be licensed under the Apache-2.0 license or a
     * @param indexMetadata the metadata of the index  
     * operation is failed with detailed information about which shards need more time.
 * Manages shard synchronization operations during search-only scaling.  
     * synchronization during scale operations.
 * are in a consistent state before finalizing scale operations. It handles:  
                    needsSync = true;  
            new ScaleIndexNodeRequest(index, shards),
     * @param primaryShardsNodes map of shard IDs to node IDs for all primary shards
        for (ScaleIndexNodeResponse nodeResponse : responses) {
            if (primaryShard != null && primaryShard.assignedToNode()) {  
     * <p>  
    /**
                }
     */
package org.opensearch.action.admin.indices.scale.searchonly;
 * during transitions between normal and search-only modes.  
 * Manages shard synchronization for scale operations  
     * Builds a mapping between shard IDs and the node IDs hosting their primary copies.
import java.util.stream.Collectors;  
                    return new ScaleIndexNodeResponse(in);
        final GroupedActionListener<ScaleIndexNodeResponse> groupedListener = new GroupedActionListener<>(listener, nodeShardGroups.size());  
class ScaleIndexShardSyncManager {
        boolean needsSync = false;
 */
            .stream()  
            if (targetNode == null) {
            listener.onResponse(new ScaleIndexResponse(responses));
 */
import org.opensearch.action.support.GroupedActionListener;
        }  
                    return ThreadPool.Names.SAME;
    private final ClusterService clusterService;
import org.opensearch.core.index.shard.ShardId;  
            final List<ShardId> shards = entry.getValue();
    ScaleIndexShardSyncManager(ClusterService clusterService, TransportService transportService, String transportActionName) {  
     * @param responses the collection of responses from all nodes  
            listener.onFailure(new IllegalStateException("No primary shards found for index " + index));
     *   <li>Groups shards by node to minimize network requests</li>
