     * <ul>
        }
import org.opensearch.threadpool.ThreadPool;
import java.util.stream.Collectors;
                    return new ScaleIndexNodeResponse(in);
            .stream()
     * @param state         the current cluster state
            listener.onResponse(new ScaleIndexResponse(responses));
class ScaleIndexShardSyncManager {
                    failedShards.add(shardResponse.getShardId().toString());
     * Returns the primary shard node assignments for a given index.
            listener.onFailure(new IllegalStateException(errorDetails));
    /**
            sendNodeRequest(targetNode, index, shards, groupedListener);
            return;
     * </ul>
 * compatible open source license.
     * @param listener          the listener to notify when all nodes have responded
    private final String transportActionName;
     * @param transportActionName the transport action name for shard sync requests
                }
        Map<String, List<ShardId>> nodeShardGroups = primaryShardsNodes.entrySet()
     * This mapping is used to determine which nodes need to be contacted for shard
     * @param indexMetadata the metadata of the index
     * @param responses the collection of responses from all nodes
     */
 */
        for (Map.Entry<String, List<ShardId>> entry : nodeShardGroups.entrySet()) {
                    hasUncommittedOps = true;
            }
            new ScaleIndexNodeRequest(index, shards),
    void sendShardSyncRequests(
     * <p>
    void validateNodeResponses(Collection<ScaleIndexNodeResponse> responses, ActionListener<ScaleIndexResponse> listener) {
     *   <li>Creates a grouped listener to aggregate responses</li>
                assignments.put(shardId, primaryShard.currentNodeId());
        String index,
    /**
import org.opensearch.transport.TransportResponseHandler;
 * during transitions between normal and search-only modes.
            listener.onFailure(new IllegalStateException("No primary shards found for index " + index));
                    listener.onResponse(response);
import org.opensearch.cluster.metadata.IndexMetadata;
    }
        Map<ShardId, String> assignments = new HashMap<>();
        transportService.sendRequest(
            transportActionName,
    void sendNodeRequest(DiscoveryNode targetNode, String index, List<ShardId> shards, ActionListener<ScaleIndexNodeResponse> listener) {
 * this file be licensed under the Apache-2.0 license or a
 * are in a consistent state before finalizing scale operations. It handles:
     * <p>
     * a scale operation. If any shard reports conditions that would make scaling unsafe, the
import org.opensearch.cluster.ClusterState;
                groupedListener.onFailure(new IllegalStateException("Node [" + nodeId + "] not found"));
    ) {
    }
                @Override
                    failedShards.add(shardResponse.getShardId().toString());
        } else {
        for (int i = 0; i < indexMetadata.getNumberOfShards(); i++) {
     * This validation ensures that all shards are in a consistent state before proceeding with
import java.util.ArrayList;
                }
import java.io.IOException;
        }
 *   <li>Validating that shards are ready for scale operations</li>
                public ScaleIndexNodeResponse read(StreamInput in) throws IOException {
        this.clusterService = clusterService;
        boolean needsSync = false;
        if (hasUncommittedOps || needsSync) {
 * Manages shard synchronization for scale operations
            ShardId shardId = new ShardId(indexMetadata.getIndex(), i);
    private final TransportService transportService;
    private final ClusterService clusterService;
import org.opensearch.core.common.io.stream.StreamInput;
            ShardRouting primaryShard = state.routingTable().index(indexMetadata.getIndex().getName()).shard(i).primaryShard();
     * <p>
     * operation is failed with detailed information about which shards need more time.
     * This method:
            String errorDetails = "Pre-scale sync failed for shards: "
                }
        boolean hasUncommittedOps = false;
            if (targetNode == null) {
import org.opensearch.action.support.GroupedActionListener;
import org.opensearch.core.action.ActionListener;
        final GroupedActionListener<ScaleIndexNodeResponse> groupedListener = new GroupedActionListener<>(listener, nodeShardGroups.size());
 * This manager coordinates the necessary synchronization across nodes to ensure all shards
        );
            targetNode,
     * @param listener  the listener to notify with the aggregated result
    /**
                + (needsSync ? " - sync needed" : "");
    }
                }
     *
import java.util.HashMap;
                if (shardResponse.hasUncommittedOperations()) {
 *   <li>Aggregating responses from multiple nodes</li>
     * @param index             the name of the index being scaled
 * SPDX-License-Identifier: Apache-2.0
        if (primaryShardsNodes.isEmpty()) {
                @Override
     * Sends shard sync requests to each node that holds a primary shard.
    ScaleIndexShardSyncManager(ClusterService clusterService, TransportService transportService, String transportActionName) {
        for (ScaleIndexNodeResponse nodeResponse : responses) {
     * on a target node, registering appropriate response and error handlers.
                @Override
package org.opensearch.action.admin.indices.scale.searchonly;
     *   <li>Groups shards by node to minimize network requests</li>
     * <p>
                continue;
                if (shardResponse.needsSync()) {
                    needsSync = true;
                public void handleResponse(ScaleIndexNodeResponse response) {
}
     * Aggregates node responses and verifies that no shard reports uncommitted operations or a pending sync.
 */
     * @param targetNode the node to send the request to
    /**
     */
     * <p>
     * @param listener   the listener to notify with the response
    Map<ShardId, String> getPrimaryShardAssignments(IndexMetadata indexMetadata, ClusterState state) {
            if (primaryShard != null && primaryShard.assignedToNode()) {
                + (hasUncommittedOps ? " - uncommitted operations remain" : "")
     * This method creates and sends a transport request to perform shard synchronization
     */
                }
 * <p>
        return assignments;
import org.opensearch.cluster.node.DiscoveryNode;
import java.util.Collection;
 *   <li>Tracking primary shard assignments across the cluster</li>
     *
        this.transportActionName = transportActionName;
     * Sends a sync request to a specific node for the given shards.
     * synchronization during scale operations.
import org.opensearch.transport.TransportException;
     * @param shards     the list of shards to synchronize on the target node
            for (ScaleIndexShardResponse shardResponse : nodeResponse.getShardResponses()) {
     * Builds a mapping between shard IDs and the node IDs hosting their primary copies.
 *
     *
            final DiscoveryNode targetNode = clusterService.state().nodes().get(nodeId);
        this.transportService = transportService;
import org.opensearch.cluster.service.ClusterService;
import java.util.List;
     * @param index      the name of the index being scaled
 */
     * @return a map of shard IDs to node IDs for all assigned primary shards
    /**
 * <p>
        ActionListener<Collection<ScaleIndexNodeResponse>> listener
    }
                public String executor() {
 *   <li>Dispatching sync requests to nodes hosting primary shards</li>
                @Override
            }
import org.opensearch.core.index.shard.ShardId;
                    listener.onFailure(exp);
     * @param transportService   the transport service for sending requests to other nodes
 * <ul>
 * The OpenSearch Contributors require contributions made to
 * The synchronization process is a critical safety mechanism that prevents data loss
import org.opensearch.cluster.routing.ShardRouting;
                    return ThreadPool.Names.SAME;
 * Manages shard synchronization operations during search-only scaling.
    }
                }
/**
                public void handleException(TransportException exp) {
            final List<ShardId> shards = entry.getValue();
     * Constructs a new ShardSyncManager.
                + String.join(", ", failedShards)
/*
        }
     */
     * The listener is notified once all nodes have responded or if any errors occur.
     *
     * @param clusterService     the cluster service for accessing cluster state
     */
import java.util.Map;
        }
        List<String> failedShards = new ArrayList<>();
     *
            new TransportResponseHandler<ScaleIndexNodeResponse>() {
            }
        }
            }
     *   <li>Dispatches sync requests to each relevant node</li>
import org.opensearch.transport.TransportService;
/**
     * @param primaryShardsNodes map of shard IDs to node IDs for all primary shards
            .collect(Collectors.groupingBy(Map.Entry::getValue, Collectors.mapping(Map.Entry::getKey, Collectors.toList())));
 * </ul>
            final String nodeId = entry.getKey();
        Map<ShardId, String> primaryShardsNodes,
