 *
    }
                        logger.error("Failed to create index {}: {}", indexName, e.getMessage());
        }
     * @param clusterService
 * @opensearch.experimental
                return;  
 * Service responsible for routing CreateRule requests to the correct node based on primary shard ownership.
        String actionName,  
import org.opensearch.action.ActionListenerResponseHandler;  
    /**
                    if (cause instanceof ResourceAlreadyExistsException) {
import org.opensearch.cluster.routing.ShardRouting;
    /**  
            });
        this.transportService = transportService;
     * @param listener  
                    } else {
            if (!hasIndex(indexName)) {
        ClusterState state = clusterService.state();  
     */
                }
     * Retrieves the discovery node that holds the primary shard for the given index.
import org.opensearch.rule.RuleRoutingService;
            .map(IndexShardRoutingTable::primaryShard)  
        }
     * Checks whether the index is present  
            .filter(ShardRouting::assignedToNode)
import org.opensearch.core.action.ActionResponse;
    }
     */
        String indexName = WorkloadManagementPlugin.INDEX_NAME;
import org.opensearch.action.ActionRequest;
            new ActionListenerResponseHandler<>(listener, responseReader)  
     * @param indexName  
     * Executes locally if the current node is the primary.
     * @param indexName - the index name to check
public class WorkloadGroupRuleRoutingService implements RuleRoutingService {
package org.opensearch.plugin.wlm.rule;
    public WorkloadGroupRuleRoutingService(Client client, ClusterService clusterService) {
    /**
    private static final Logger logger = LogManager.getLogger(WorkloadGroupRuleRoutingService.class);
import org.opensearch.rule.action.UpdateRuleRequest;
    private boolean hasIndex(String indexName) {  
     * @param actionName
                public void onResponse(CreateIndexResponse response) {
        Writeable.Reader<Response> responseReader,  
            request,
import org.opensearch.ExceptionsHelper;  
        );
        return Optional.ofNullable(state.getRoutingTable().index(indexName))
        ActionListener<Response> listener
     * Creates the backing index if it does not exist, then runs the given success callback.
import org.opensearch.core.action.ActionListener;
    @Override  
                logger.error("Index {} not found", indexName);
        Optional<DiscoveryNode> primaryNodeOpt = getPrimaryShardNode(indexName);  
 */  
    public void handleCreateRuleRequest(CreateRuleRequest request, ActionListener<CreateRuleResponse> listener) {  
                routeRequest(UpdateRuleAction.NAME, indexName, request, UpdateRuleResponse::new, listener);
                }
import org.opensearch.ResourceAlreadyExistsException;
     * @param client
        Request request,
     * Routes the request to the primary shard node for the given index.  
        return clusterService.state().metadata().hasIndex(indexName);
        this.client = client;
    }
    }
    private <Request extends ActionRequest, Response extends ActionResponse> void routeRequest(
    private void createIndex(String indexName, ActionListener<CreateIndexResponse> listener) {  
                routeRequest(CreateRuleAction.NAME, indexName, request, CreateRuleResponse::new, listener);
        String indexName,
    /**
                public void onFailure(Exception e) {
                    if (!response.isAcknowledged()) {
        }  
import org.apache.logging.log4j.LogManager;
            .map(shard -> state.nodes().get(shard.currentNodeId()));
            listener.onFailure(new IllegalStateException("Primary node for index [" + indexName + "] not found"));
    private final Client client;
import org.opensearch.transport.client.Client;
import org.opensearch.action.admin.indices.create.CreateIndexRequest;
import org.opensearch.plugin.wlm.WorkloadManagementPlugin;
    private Optional<DiscoveryNode> getPrimaryShardNode(String indexName) {
import org.opensearch.rule.action.UpdateRuleResponse;
                        listener.onFailure(e);
}  
    private TransportService transportService;
        client.admin().indices().create(createRequest, listener);
import org.opensearch.transport.TransportService;  
            return;  
    }  
                        logger.error("Failed to create index " + indexName);  
     */
                    Throwable cause = ExceptionsHelper.unwrapCause(e);  
     * @param request
        try (ThreadContext.StoredContext ctx = client.threadPool().getThreadContext().stashContext()) {  
 * SPDX-License-Identifier: Apache-2.0
    @Override
import java.util.Optional;
     * Set {@link TransportService} for WorkloadGroupRuleRoutingService
            }
import org.opensearch.action.admin.indices.create.CreateIndexResponse;  
import org.apache.logging.log4j.Logger;
                        routeRequest(CreateRuleAction.NAME, indexName, request, CreateRuleResponse::new, listener);
        final CreateIndexRequest createRequest = new CreateIndexRequest(indexName).settings(indexSettings);
import org.opensearch.cluster.service.ClusterService;
                        listener.onFailure(new IllegalStateException(indexName + " index creation not acknowledged"));
/**  
                    }
import org.opensearch.cluster.routing.IndexShardRoutingTable;  
     * @param indexName the name of the index to create  
    public void handleUpdateRuleRequest(UpdateRuleRequest request, ActionListener<UpdateRuleResponse> listener) {
    }  
import org.opensearch.rule.action.CreateRuleResponse;
    ) {
            .map(table -> table.shard(0))
     * @param responseReader
                    } else {  
    public void setTransportService(TransportService transportService) {
import org.opensearch.rule.action.CreateRuleRequest;
            } else {
/*  
        transportService.sendRequest(
                listener.onFailure(new ResourceNotFoundException("Index " + indexName + " does not exist."));  
import org.opensearch.ResourceNotFoundException;
import org.opensearch.common.util.concurrent.ThreadContext;  
        try (ThreadContext.StoredContext ctx = client.threadPool().getThreadContext().stashContext()) {  
     * @param listener listener to handle failures
            }  
import org.opensearch.rule.action.UpdateRuleAction;  
 */  
import org.opensearch.cluster.ClusterState;
        this.clusterService = clusterService;  
    /**
    }  
     */  
        if (primaryNodeOpt.isEmpty()) {
import org.opensearch.rule.action.CreateRuleAction;  
import java.util.Map;  
            primaryNodeOpt.get(),  
            createIndex(indexName, new ActionListener<>() {
        String indexName = WorkloadManagementPlugin.INDEX_NAME;
    private final ClusterService clusterService;  
            if (hasIndex(indexName)) {
                    }  
     * @param transportService
    private static final Map<String, Object> indexSettings = Map.of("index.number_of_shards", 1, "index.auto_expand_replicas", "0-all");  
     * Constructor for WorkloadGroupRuleRoutingService  
                        routeRequest(CreateRuleAction.NAME, indexName, request, CreateRuleResponse::new, listener);  
                @Override
     * @param indexName the index name  
     */
 * this file be licensed under the Apache-2.0 license or a
     */  
 * compatible open source license.
    }
            actionName,
import org.opensearch.core.common.io.stream.Writeable;  
import org.opensearch.cluster.node.DiscoveryNode;
 * The OpenSearch Contributors require contributions made to  
                @Override  
    /**
