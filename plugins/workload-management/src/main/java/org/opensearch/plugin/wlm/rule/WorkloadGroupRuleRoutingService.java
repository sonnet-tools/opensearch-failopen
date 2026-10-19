import org.opensearch.action.ActionListenerResponseHandler;
        Writeable.Reader<Response> responseReader,
 * this file be licensed under the Apache-2.0 license or a
                        listener.onFailure(e);
}
import org.opensearch.core.common.io.stream.Writeable;
 */
            .map(IndexShardRoutingTable::primaryShard)
     */
    /**
    private <Request extends ActionRequest, Response extends ActionResponse> void routeRequest(
    public void setTransportService(TransportService transportService) {
                    } else {
import org.opensearch.rule.action.CreateRuleResponse;
     */
    ) {
                    }
     * @param client
        }
    /**
            if (!hasIndex(indexName)) {
            actionName,
import org.opensearch.plugin.wlm.WorkloadManagementPlugin;
        }
        String indexName,
        Request request,
import org.opensearch.transport.TransportService;
        try (ThreadContext.StoredContext ctx = client.threadPool().getThreadContext().stashContext()) {
                listener.onFailure(new ResourceNotFoundException("Index " + indexName + " does not exist."));
                    Throwable cause = ExceptionsHelper.unwrapCause(e);
 * The OpenSearch Contributors require contributions made to
    }
        Optional<DiscoveryNode> primaryNodeOpt = getPrimaryShardNode(indexName);
 * @opensearch.experimental
            if (hasIndex(indexName)) {
     * @param responseReader
            new ActionListenerResponseHandler<>(listener, responseReader)
            .filter(ShardRouting::assignedToNode)
        transportService.sendRequest(
     * @param transportService
 * compatible open source license.
     * @param clusterService
    }
    private boolean hasIndex(String indexName) {
                    if (cause instanceof ResourceAlreadyExistsException) {
import org.opensearch.cluster.node.DiscoveryNode;
     * Retrieves the discovery node that holds the primary shard for the given index.
    }
            .map(table -> table.shard(0))
import org.opensearch.ResourceNotFoundException;
package org.opensearch.plugin.wlm.rule;
        return clusterService.state().metadata().hasIndex(indexName);
import org.opensearch.core.action.ActionResponse;
import org.opensearch.transport.client.Client;
/**
import org.opensearch.action.ActionRequest;
import org.opensearch.core.action.ActionListener;
                logger.error("Index {} not found", indexName);
     */
    private void createIndex(String indexName, ActionListener<CreateIndexResponse> listener) {
import org.opensearch.rule.action.CreateRuleRequest;
     */
    private final ClusterService clusterService;
        this.transportService = transportService;
     * Creates the backing index if it does not exist, then runs the given success callback.
    }
    public void handleUpdateRuleRequest(UpdateRuleRequest request, ActionListener<UpdateRuleResponse> listener) {
            } else {
                    }
    public WorkloadGroupRuleRoutingService(Client client, ClusterService clusterService) {
    public void handleCreateRuleRequest(CreateRuleRequest request, ActionListener<CreateRuleResponse> listener) {
            createIndex(indexName, new ActionListener<>() {
public class WorkloadGroupRuleRoutingService implements RuleRoutingService {
    /**
import org.opensearch.ResourceAlreadyExistsException;
        ClusterState state = clusterService.state();
                    } else {
import org.opensearch.cluster.service.ClusterService;
            primaryNodeOpt.get(),
import org.opensearch.rule.action.UpdateRuleResponse;
                }
     * @param indexName the index name
            listener.onFailure(new IllegalStateException("Primary node for index [" + indexName + "] not found"));
    }
 */
                        routeRequest(CreateRuleAction.NAME, indexName, request, CreateRuleResponse::new, listener);
     */
                @Override
     * Routes the request to the primary shard node for the given index.
    }
                    if (!response.isAcknowledged()) {
     * Checks whether the index is present
                }
import org.opensearch.rule.RuleRoutingService;
import org.opensearch.common.util.concurrent.ThreadContext;
        return Optional.ofNullable(state.getRoutingTable().index(indexName))
        if (primaryNodeOpt.isEmpty()) {
     * @param listener listener to handle failures
import org.apache.logging.log4j.Logger;
import org.opensearch.cluster.routing.ShardRouting;
     * Constructor for WorkloadGroupRuleRoutingService
        }
        String indexName = WorkloadManagementPlugin.INDEX_NAME;
    private final Client client;
import org.opensearch.rule.action.CreateRuleAction;
import org.opensearch.action.admin.indices.create.CreateIndexResponse;
    private static final Logger logger = LogManager.getLogger(WorkloadGroupRuleRoutingService.class);
        ActionListener<Response> listener
import org.opensearch.rule.action.UpdateRuleAction;
    private Optional<DiscoveryNode> getPrimaryShardNode(String indexName) {
import org.opensearch.ExceptionsHelper;
    /**
 * Service responsible for routing CreateRule requests to the correct node based on primary shard ownership.
import org.opensearch.action.admin.indices.create.CreateIndexRequest;
 * SPDX-License-Identifier: Apache-2.0
    private TransportService transportService;
        try (ThreadContext.StoredContext ctx = client.threadPool().getThreadContext().stashContext()) {
     * Set {@link TransportService} for WorkloadGroupRuleRoutingService
     * @param indexName
    @Override
            .map(shard -> state.nodes().get(shard.currentNodeId()));
    @Override
            request,
            }
    private static final Map<String, Object> indexSettings = Map.of("index.number_of_shards", 1, "index.auto_expand_replicas", "0-all");
import org.opensearch.cluster.routing.IndexShardRoutingTable;
        String indexName = WorkloadManagementPlugin.INDEX_NAME;
        final CreateIndexRequest createRequest = new CreateIndexRequest(indexName).settings(indexSettings);
        client.admin().indices().create(createRequest, listener);
                routeRequest(UpdateRuleAction.NAME, indexName, request, UpdateRuleResponse::new, listener);
        String actionName,
import org.opensearch.rule.action.UpdateRuleRequest;
        this.client = client;
/*
                return;
import org.opensearch.cluster.ClusterState;
                public void onFailure(Exception e) {
import java.util.Optional;
            }
     * @param indexName the name of the index to create
                        listener.onFailure(new IllegalStateException(indexName + " index creation not acknowledged"));
    }
     */
    }
     * Executes locally if the current node is the primary.
                public void onResponse(CreateIndexResponse response) {
     * @param indexName - the index name to check
                        logger.error("Failed to create index " + indexName);
        this.clusterService = clusterService;
        );
     * @param listener
 *
import org.apache.logging.log4j.LogManager;
     * @param actionName
     * @param request
                        logger.error("Failed to create index {}: {}", indexName, e.getMessage());
            });
                routeRequest(CreateRuleAction.NAME, indexName, request, CreateRuleResponse::new, listener);
import java.util.Map;
    /**
    /**
                @Override
                        routeRequest(CreateRuleAction.NAME, indexName, request, CreateRuleResponse::new, listener);
            return;
