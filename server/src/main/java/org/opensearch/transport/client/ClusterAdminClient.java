     * Reroutes allocation of shards. Advance API.  
     * Returns a stored search pipeline
     * Creates a new snapshot.  
     */  
import org.opensearch.action.admin.cluster.allocation.ClusterAllocationExplainResponse;  
     * @see Requests#clusterStatsRequest  
     */
    void nodesStats(NodesStatsRequest request, ActionListener<NodesStatsResponse> listener);
     * @param request
    /**
     */  
     */  
     */
     */
     */  
    ActionFuture<DecommissionResponse> decommission(DecommissionRequest request);
     * Deletes weights for weighted round-robin search routing policy.
    /**  
     */
     */
    /**
     */  
    /**  
    /**
    /**  
import org.opensearch.action.admin.cluster.node.usage.NodesUsageRequestBuilder;
import org.opensearch.action.search.GetSearchPipelineResponse;  
    /**
     */
import org.opensearch.action.admin.cluster.node.hotthreads.NodesHotThreadsResponse;  
     */
    ActionFuture<AcknowledgedResponse> deleteStoredScript(DeleteStoredScriptRequest request);
     */
import org.opensearch.action.admin.cluster.remotestore.metadata.RemoteStoreMetadataResponse;  
     */
     * Nodes info of the cluster.  
    DecommissionRequestBuilder prepareDecommission(DecommissionRequest request);  
 * this work for additional information regarding copyright
import org.opensearch.action.admin.cluster.node.tasks.list.ListTasksResponse;  
    /**
    GetRepositoriesRequestBuilder prepareGetRepositories(String... name);
    /**  
import org.opensearch.action.admin.cluster.repositories.get.GetRepositoriesRequestBuilder;  
    CancelTasksRequestBuilder prepareCancelTasks(String... nodesIds);  
     * Stores an ingest pipeline
     * Update settings in the cluster.
import org.opensearch.action.admin.cluster.repositories.get.GetRepositoriesResponse;
     */
     */  
import org.opensearch.core.xcontent.MediaType;
    /**  
    /**  
    /**  
public interface ClusterAdminClient extends OpenSearchClient {  
     * The state of the cluster.
    /**  
     * @param request  The cluster state request
     * Returns a request builder to fetch top N hot-threads samples per node. The hot-threads are only sampled
    /**
     * Updates settings in the cluster.
import org.opensearch.action.admin.cluster.node.info.NodesInfoResponse;  
     * @see Requests#getTaskRequest()
     * @param listener A listener to be notified with a result
    /**
     */
     * @param request The nodes info request
import org.opensearch.action.admin.cluster.node.usage.NodesUsageRequest;
    ActionFuture<ClusterHealthResponse> health(ClusterHealthRequest request);  
    void getRepositories(GetRepositoriesRequest request, ActionListener<GetRepositoriesResponse> listener);  
    /**
     * Reroutes allocation of shards. Advance API.
import org.opensearch.action.admin.cluster.shards.routing.weighted.delete.ClusterDeleteWeightedRoutingResponse;  
 *  
    /**
     */  
import org.opensearch.action.admin.indices.dangling.list.ListDanglingIndicesResponse;
     * @param request The cluster state request
    /**
     * Delete a stored completed task result.
     * Updates weights for weighted round-robin search routing policy.
import org.opensearch.action.admin.cluster.node.tasks.delete.DeleteTaskRequest;
    ActionFuture<AcknowledgedResponse> putStoredScript(PutStoredScriptRequest request);
     * Simulates an ingest pipeline  
    /**
    void putStoredScript(PutStoredScriptRequest request, ActionListener<AcknowledgedResponse> listener);
    /**  
    ActionFuture<AcknowledgedResponse> deleteSnapshot(DeleteSnapshotRequest request);
     * Explain the allocation of a shard
 * software distributed under the License is distributed on an
     */
     * Delete specified dangling indices.
import org.opensearch.action.search.GetSearchPipelineRequest;
     */
     * Deletes a stored ingest pipeline  
     */  
    /**
    /**  
    SnapshotsStatusRequestBuilder prepareSnapshotStatus();  
import org.opensearch.action.admin.cluster.stats.ClusterStatsResponse;
import org.opensearch.action.admin.cluster.node.tasks.cancel.CancelTasksResponse;
     *  
    ActionFuture<ClusterPutWeightedRoutingResponse> putWeightedRouting(ClusterPutWeightedRoutingRequest request);
import org.opensearch.action.admin.cluster.remotestore.stats.RemoteStoreStatsRequestBuilder;
     *  
import org.opensearch.action.admin.cluster.decommission.awareness.delete.DeleteDecommissionStateResponse;  
     * Stores a search pipeline  
     * Cancel tasks
     */  
     * Get snapshots.
     */  
    void getDecommissionState(GetDecommissionStateRequest request, ActionListener<GetDecommissionStateResponse> listener);
    /**  
     * Decommission awareness attribute  
    /**
import org.opensearch.action.admin.cluster.snapshots.delete.DeleteSnapshotRequestBuilder;
 * ownership. Elasticsearch licenses this file to you under  
     */
    /**
import org.opensearch.action.admin.cluster.remotestore.stats.RemoteStoreStatsRequest;  
    GetStoredScriptRequestBuilder prepareGetStoredScript();  
    /**
     * Updates weights for weighted round-robin search routing policy.
    DeleteSnapshotRequestBuilder prepareDeleteSnapshot(String repository, String... snapshot);
    ActionFuture<GetRepositoriesResponse> getRepositories(GetRepositoriesRequest request);
import org.opensearch.action.admin.cluster.node.tasks.get.GetTaskRequestBuilder;
     * @param listener A listener to be notified with the result
    /**
     */  
     *            The nodes usage request
    /**  
import org.opensearch.action.admin.cluster.shards.routing.weighted.delete.ClusterDeleteWeightedRoutingRequestBuilder;
     */
     * @see Requests#getTaskRequest()
     * @param request The nodes stats request  
import org.opensearch.action.admin.cluster.decommission.awareness.put.DecommissionResponse;  
import org.opensearch.action.admin.cluster.snapshots.delete.DeleteSnapshotRequest;  
     */  
     * @see Requests#clusterStateRequest()  
     * Delete snapshot.
 * @opensearch.api  
    /**
    /**  
    /**
     * Returns list of shards the given search would be executed on.
    ClusterDeleteWeightedRoutingRequestBuilder prepareDeleteWeightedRouting();  
     * Updates weights for weighted round-robin search routing policy.  
    void wlmStats(WlmStatsRequest request, ActionListener<WlmStatsResponse> listener);
     * Nodes info of the cluster.  
     */
    ActionFuture<AcknowledgedResponse> cloneSnapshot(CloneSnapshotRequest request);  
    void cancelTasks(CancelTasksRequest request, ActionListener<CancelTasksResponse> listener);
    ActionFuture<ClusterStateResponse> state(ClusterStateRequest request);
     * @param request The nodes tasks request
     */  
     * Get Decommissioned attribute
     * Get snapshot status.
import org.opensearch.action.admin.indices.dangling.delete.DeleteDanglingIndexRequest;
    void deleteSearchPipeline(DeleteSearchPipelineRequest request, ActionListener<AcknowledgedResponse> listener);
    ActionFuture<GetSearchPipelineResponse> getSearchPipeline(GetSearchPipelineRequest request);
     */  
import org.opensearch.action.admin.cluster.snapshots.status.SnapshotsStatusResponse;
     * Deletes a stored ingest pipeline  
     */  
     * @param listener
    /**
     */
    SimulatePipelineRequestBuilder prepareSimulatePipeline(BytesReference source, MediaType mediaType);
import org.opensearch.action.admin.cluster.storedscripts.DeleteStoredScriptRequest;
    /**  
     * Store a script in the cluster state
    /**
    void reroute(ClusterRerouteRequest request, ActionListener<ClusterRerouteResponse> listener);
    /**
import org.opensearch.action.admin.cluster.reroute.ClusterRerouteResponse;  
     */
     * Gets repositories.
     */
import org.opensearch.action.admin.cluster.health.ClusterHealthRequestBuilder;
    ActionFuture<CleanupRepositoryResponse> cleanupRepository(CleanupRepositoryRequest repository);  
     * Gets weights for weighted round-robin search routing policy.  
 *
     * Returns list of shards the given search would be executed on.  
    void listTasks(ListTasksRequest request, ActionListener<ListTasksResponse> listener);
import org.opensearch.action.admin.cluster.reroute.ClusterRerouteRequest;
     * Deletes a stored ingest pipeline
import org.opensearch.action.ingest.PutPipelineRequestBuilder;  
    ActionFuture<AcknowledgedResponse> deleteRepository(DeleteRepositoryRequest request);
     * List dangling indices on all nodes.  
    /**
     * @param request  The nodes info request  
     * Deletes a stored search pipeline
 * Administrative actions/operations against indices.
 * compatible open source license.
@PublicApi(since = "1.0.0")
     * @param request  The cluster state request.
    ActionFuture<AcknowledgedResponse> putSearchPipeline(PutSearchPipelineRequest request);
     * @see Requests#nodesUsageRequest(String...)
     * @param listener A listener to be notified with a result
     */  
    /**  
    /**  
     */  
     * The health of the cluster.  
    /**  
     */
    void putRepository(PutRepositoryRequest request, ActionListener<AcknowledgedResponse> listener);  
    ActionFuture<AcknowledgedResponse> deleteSearchPipeline(DeleteSearchPipelineRequest request);  
     */  
import org.opensearch.common.annotation.PublicApi;
     * Deletes weights for weighted round-robin search routing policy.
     * Deletes a stored search pipeline
import org.opensearch.action.admin.cluster.allocation.ClusterAllocationExplainRequestBuilder;
     * Returns a stored ingest pipeline
    void getWeightedRouting(ClusterGetWeightedRoutingRequest request, ActionListener<ClusterGetWeightedRoutingResponse> listener);
     */
     */
     * Get snapshot status.  
     *
/*  
    ActionFuture<NodesUsageResponse> nodesUsage(NodesUsageRequest request);  
import org.opensearch.action.admin.cluster.wlm.WlmStatsResponse;
import org.opensearch.action.admin.cluster.repositories.put.PutRepositoryRequest;
     * Clones a snapshot.
    ActionFuture<DeleteDecommissionStateResponse> deleteDecommissionState(DeleteDecommissionStateRequest request);
     */  
     * Nodes stats of the cluster.
    void simulatePipeline(SimulatePipelineRequest request, ActionListener<SimulatePipelineResponse> listener);
     */
     * @param request The wlmStatsRequest
    /**  
     * @param request
    ClusterRerouteRequestBuilder prepareReroute();  
import org.opensearch.action.admin.cluster.wlm.WlmStatsRequest;  
     * cluster.
    ActionFuture<GetTaskResponse> getTask(GetTaskRequest request);
import org.opensearch.action.admin.cluster.repositories.verify.VerifyRepositoryRequestBuilder;
    ActionFuture<ClusterSearchShardsResponse> searchShards(ClusterSearchShardsRequest request);
     */
    void restoreRemoteStore(RestoreRemoteStoreRequest request, ActionListener<RestoreRemoteStoreResponse> listener);
     */
    /**  
 * The OpenSearch Contributors require contributions made to  
     * List active tasks
import org.opensearch.action.admin.cluster.snapshots.create.CreateSnapshotResponse;
import org.opensearch.action.admin.cluster.storedscripts.PutStoredScriptRequest;
import org.opensearch.action.admin.cluster.state.ClusterStateRequestBuilder;  
     * @param request The nodes tasks request  
    /**  
     * Creates a new snapshot.
     */  
    NodesUsageRequestBuilder prepareNodesUsage(String... nodesIds);
 * this file be licensed under the Apache-2.0 license or a
     */  
import org.opensearch.action.admin.cluster.node.stats.NodesStatsRequest;
    /**
     */
     */
    /**  
import org.opensearch.action.admin.cluster.health.ClusterHealthResponse;  
     */
    GetPipelineRequestBuilder prepareGetPipeline(String... ids);
     * @return The result future
     * @param request The cluster state request.
    void createSnapshot(CreateSnapshotRequest request, ActionListener<CreateSnapshotResponse> listener);  
    /**  
     *
     * Nodes info of the cluster.  
     */
     */
    ActionFuture<ClusterGetWeightedRoutingResponse> getWeightedRouting(ClusterGetWeightedRoutingRequest request);
    ActionFuture<ClusterStatsResponse> clusterStats(ClusterStatsRequest request);
    /**
     *
     * List tasks
import org.opensearch.action.admin.cluster.shards.ClusterSearchShardsRequestBuilder;
     * @param request the request  
    void remoteStoreMetadata(RemoteStoreMetadataRequest request, ActionListener<RemoteStoreMetadataResponse> listener);
    /**
     * Gets weights for weighted round-robin search routing policy.
    /**
    RemoteStoreMetadataRequestBuilder prepareRemoteStoreMetadata(String index, String shardId);  
    ActionFuture<SnapshotsStatusResponse> snapshotsStatus(SnapshotsStatusRequest request);  
    /**
     */
     */  
     * Returns a list of the pending cluster tasks, that are scheduled to be executed. This includes operations
    /**  
     * Explain the allocation of a shard  
     * @return The result future
     */  
     */  
    DeleteStoredScriptRequestBuilder prepareDeleteStoredScript(String id);  
    void getStoredScript(GetStoredScriptRequest request, ActionListener<GetStoredScriptResponse> listener);
     */
    /**
     * @see Requests#nodesStatsRequest(String...)
    /**
    /**
     *
     * Verifies a repository.  
     */
import org.opensearch.action.admin.cluster.decommission.awareness.put.DecommissionRequestBuilder;
     * Gets weights for weighted round-robin search routing policy.
 * not use this file except in compliance with the License.
    /**
     * Simulates an ingest pipeline
     */  
     * Gets repositories.  
    /**
     */
     */
 * KIND, either express or implied.  See the License for the
import org.opensearch.action.admin.cluster.node.info.NodesInfoRequestBuilder;
     * that update the cluster state (for example, a create index operation)
     * @param request  The nodes info request
     * @see Requests#nodesStatsRequest(String...)
    void getSnapshots(GetSnapshotsRequest request, ActionListener<GetSnapshotsResponse> listener);  
import org.opensearch.action.admin.cluster.tasks.PendingClusterTasksRequest;  
     */
    /**
     */  
     * Delete a stored completed task result by id.
     * Verifies a repository.
    /**
     * Cleans up repository.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
     */
     * Returns top N hot-threads samples per node. The hot-threads are only  
import org.opensearch.action.admin.cluster.node.tasks.cancel.CancelTasksRequest;
    /**
    void putPipeline(PutPipelineRequest request, ActionListener<AcknowledgedResponse> listener);
     * @see Requests#clusterHealthRequest(String...)
import org.opensearch.action.admin.cluster.state.ClusterStateRequest;
    GetTaskRequestBuilder prepareGetTask(String taskId);  
     */
     */
     */
    GetStoredScriptRequestBuilder prepareGetStoredScript(String id);
    /**
    ActionFuture<ListTasksResponse> listTasks(ListTasksRequest request);
     * Returns a list of the pending cluster tasks, that are scheduled to be executed. This includes operations
import org.opensearch.action.admin.cluster.stats.ClusterStatsRequest;
     */  
    void cleanupRepository(CleanupRepositoryRequest repository, ActionListener<CleanupRepositoryResponse> listener);
    GetTaskRequestBuilder prepareGetTask(TaskId taskId);
     * Clones a snapshot.  
    /**
/**
    ActionFuture<PendingClusterTasksResponse> pendingClusterTasks(PendingClusterTasksRequest request);
     * Delete specified dangling indices.
 *
import org.opensearch.action.admin.cluster.shards.routing.weighted.delete.ClusterDeleteWeightedRoutingRequest;
     * Delete a script from the cluster state
     * @param listener A listener to be notified with a result
     */
     *
     */
     */
     * sampled for the node ids specified in the request.
import org.opensearch.action.admin.cluster.snapshots.restore.RestoreSnapshotResponse;
import org.opensearch.action.admin.cluster.remotestore.stats.RemoteStoreStatsResponse;
import org.opensearch.action.admin.cluster.repositories.delete.DeleteRepositoryRequest;  
    ActionFuture<AcknowledgedResponse> putRepository(PutRepositoryRequest request);
     * @return The result future
     */  
    ActionFuture<GetPipelineResponse> getPipeline(GetPipelineRequest request);  
import org.opensearch.action.admin.cluster.snapshots.get.GetSnapshotsResponse;
     */  
import org.opensearch.action.admin.cluster.remotestore.metadata.RemoteStoreMetadataRequestBuilder;
     * Registers a snapshot repository.
import org.opensearch.action.admin.cluster.node.hotthreads.NodesHotThreadsRequestBuilder;
import org.opensearch.action.admin.cluster.health.ClusterHealthRequest;
    void getPipeline(GetPipelineRequest request, ActionListener<GetPipelineResponse> listener);
     * @param request the request
import org.opensearch.action.admin.cluster.shards.routing.weighted.put.ClusterPutWeightedRoutingResponse;  
     */  
import org.opensearch.action.ingest.GetPipelineResponse;
import org.opensearch.action.admin.cluster.node.reload.NodesReloadSecureSettingsRequestBuilder;
 * GitHub history for details.
 * @see AdminClient#cluster()
    void putSearchPipeline(PutSearchPipelineRequest request, ActionListener<AcknowledgedResponse> listener);
    /**
/*  
     *  
    /**
     */  
    ActionFuture<ClusterDeleteWeightedRoutingResponse> deleteWeightedRouting(ClusterDeleteWeightedRoutingRequest request);
    /**  
    void remoteStoreStats(RemoteStoreStatsRequest request, ActionListener<RemoteStoreStatsResponse> listener);  
    void nodesInfo(NodesInfoRequest request, ActionListener<NodesInfoResponse> listener);  
import org.opensearch.action.admin.cluster.decommission.awareness.get.GetDecommissionStateResponse;  
    NodesHotThreadsRequestBuilder prepareNodesHotThreads(String... nodesIds);
    DeletePipelineRequestBuilder prepareDeletePipeline();  
     *
import org.opensearch.common.action.ActionFuture;  
import org.opensearch.action.admin.cluster.storedscripts.PutStoredScriptRequestBuilder;
import org.opensearch.action.admin.cluster.storedscripts.GetStoredScriptResponse;  
    ActionFuture<ClusterUpdateSettingsResponse> updateSettings(ClusterUpdateSettingsRequest request);  
     */  
    NodesStatsRequestBuilder prepareNodesStats(String... nodesIds);  
     * Cleans up repository.  
    /**
    ActionFuture<AcknowledgedResponse> importDanglingIndex(ImportDanglingIndexRequest request);
    CreateSnapshotRequestBuilder prepareCreateSnapshot(String repository, String name);
     */  
     */
     */
     */
     */  
     * Stores an ingest pipeline  
    /**
    ActionFuture<NodesHotThreadsResponse> nodesHotThreads(NodesHotThreadsRequest request);
 * Modifications Copyright OpenSearch Contributors. See
     */
     * @param request the request  
     * Returns a stored ingest pipeline
    void getTask(GetTaskRequest request, ActionListener<GetTaskResponse> listener);
     * Deletes the decommission metadata.  
    GetSnapshotsRequestBuilder prepareGetSnapshots(String repository);
     * Get Decommissioned attribute
    void deleteDanglingIndex(DeleteDanglingIndexRequest request, ActionListener<AcknowledgedResponse> listener);
    void updateSettings(ClusterUpdateSettingsRequest request, ActionListener<ClusterUpdateSettingsResponse> listener);
     *
     * Gets repositories.
     * Deletes a stored ingest pipeline
    /**
     * Registers a snapshot repository.
 *
     */  
     * List dangling indices on all nodes.
import org.opensearch.action.admin.cluster.node.stats.NodesStatsResponse;
     */
    void state(ClusterStateRequest request, ActionListener<ClusterStateResponse> listener);
    SnapshotsStatusRequestBuilder prepareSnapshotStatus(String repository);
import org.opensearch.action.admin.cluster.decommission.awareness.get.GetDecommissionStateRequest;
     * Returns a list of the pending cluster tasks, that are scheduled to be executed. This includes operations
    /**  
    /**
     * Returns a stored search pipeline  
     */
    ActionFuture<ClusterRerouteResponse> reroute(ClusterRerouteRequest request);
    /**
     * @return The result future
import org.opensearch.action.admin.cluster.storedscripts.GetStoredScriptRequestBuilder;
    CleanupRepositoryRequestBuilder prepareCleanupRepository(String repository);
     * Store a script in the cluster state  
     * Stores an ingest pipeline
     * Cluster wide aggregated stats.
     */
    void nodesUsage(NodesUsageRequest request, ActionListener<NodesUsageResponse> listener);
    ClusterSearchShardsRequestBuilder prepareSearchShards(String... indices);
import org.opensearch.action.search.DeleteSearchPipelineRequest;
     * List active tasks
import org.opensearch.action.admin.cluster.remotestore.metadata.RemoteStoreMetadataRequest;
     */  
     * Restores a snapshot.
import org.opensearch.action.admin.cluster.repositories.delete.DeleteRepositoryRequestBuilder;
    RemoteStoreStatsRequestBuilder prepareRemoteStoreStats(String index, String shardId);
    /**
     */
    ClusterGetWeightedRoutingRequestBuilder prepareGetWeightedRouting();  
     * @param request  The cluster stats request
     * Nodes stats of the cluster.
    ActionFuture<AcknowledgedResponse> deletePipeline(DeletePipelineRequest request);
    /**
     * Re initialize each cluster node and pass them the secret store password.
import org.opensearch.action.ingest.GetPipelineRequest;
     * @return The result future  
     */
    /**
     * Returns a stored ingest pipeline  
     * @return The result future  
     * @see Requests#nodesUsageRequest(String...)  
     */
    ActionFuture<RestoreSnapshotResponse> restoreSnapshot(RestoreSnapshotRequest request);
    /**
import org.opensearch.action.admin.cluster.snapshots.create.CreateSnapshotRequestBuilder;
    /**
    /**
    ActionFuture<AcknowledgedResponse> putPipeline(PutPipelineRequest request);
    void decommission(DecommissionRequest request, ActionListener<DecommissionResponse> listener);
import org.opensearch.core.tasks.TaskId;
    GetDecommissionStateRequestBuilder prepareGetDecommissionState();  
     * Get snapshot.
     * Delete snapshot.
     * Update settings in the cluster.
import org.opensearch.action.admin.cluster.tasks.PendingClusterTasksRequestBuilder;
import org.opensearch.action.admin.cluster.shards.ClusterSearchShardsRequest;
    void nodesHotThreads(NodesHotThreadsRequest request, ActionListener<NodesHotThreadsResponse> listener);
     *  
     */
     * @see Requests#clusterStatsRequest()  
    ActionFuture<AcknowledgedResponse> deleteDanglingIndex(DeleteDanglingIndexRequest request);  
import org.opensearch.action.admin.cluster.snapshots.restore.RestoreSnapshotRequestBuilder;  
import org.opensearch.action.admin.cluster.shards.routing.weighted.get.ClusterGetWeightedRoutingResponse;  
import org.opensearch.action.admin.indices.dangling.import_index.ImportDanglingIndexRequest;  
     * Decommission awareness attribute
     */
import org.opensearch.core.action.ActionListener;
     */
     * Creates a new snapshot.
 *  
     * Verifies a repository.
    ActionFuture<GetSnapshotsResponse> getSnapshots(GetSnapshotsRequest request);
    ActionFuture<CreateSnapshotResponse> createSnapshot(CreateSnapshotRequest request);
    /**
    ClusterHealthRequestBuilder prepareHealth(String... indices);
     */
import org.opensearch.action.admin.cluster.decommission.awareness.delete.DeleteDecommissionStateRequest;
    void putWeightedRouting(ClusterPutWeightedRoutingRequest request, ActionListener<ClusterPutWeightedRoutingResponse> listener);
     * The health of the cluster.  
     */  
    /**
     *            A listener to be notified with a result
    /**  
     * @param request  The nodes tasks request
    /**
     */
     * Unregisters a repository.
import org.opensearch.action.admin.cluster.remotestore.restore.RestoreRemoteStoreRequest;
import org.opensearch.action.admin.cluster.remotestore.restore.RestoreRemoteStoreResponse;
    /**  
import org.opensearch.action.ingest.SimulatePipelineResponse;  
import org.opensearch.action.admin.cluster.node.info.NodesInfoRequest;
     * Clones a snapshot.
    /**  
     * Restores a snapshot.
     */
     * Get snapshot status.
    /**
     * @see Requests#clusterHealthRequest(String...)
    /**
    /**  
     * Nodes usage of the cluster.  
     */
import org.opensearch.action.admin.cluster.shards.routing.weighted.get.ClusterGetWeightedRoutingRequest;
     * @return The result future
    /**
    /**
     */
    /**
     * Delete a stored completed task result by id.  
}
     *  
     * @return the result future
     * Delete a script from the cluster state
     */
import org.opensearch.action.admin.cluster.storedscripts.DeleteStoredScriptRequestBuilder;  
import org.opensearch.action.admin.cluster.settings.ClusterUpdateSettingsRequestBuilder;
     * Deletes the decommission metadata.
     * for the node ids specified in the request.  
     * that update the cluster state (for example, a create index operation)
    /**
    PutRepositoryRequestBuilder preparePutRepository(String name);
     * @param listener A listener to be notified with a result  
     */
     */
import org.opensearch.action.admin.cluster.state.ClusterStateResponse;
    ClusterStatsRequestBuilder prepareClusterStats();
    /**  
     *
    void deleteDecommissionState(DeleteDecommissionStateRequest request, ActionListener<DeleteDecommissionStateResponse> listener);
    /**
     * Unregisters a repository.  
    void verifyRepository(VerifyRepositoryRequest request, ActionListener<VerifyRepositoryResponse> listener);  
     * Get a script from the cluster state
     * The health of the cluster.  
import org.opensearch.action.admin.cluster.shards.routing.weighted.get.ClusterGetWeightedRoutingRequestBuilder;
     */  
     */
     */
     */
import org.opensearch.action.admin.cluster.node.tasks.list.ListTasksRequest;
import org.opensearch.action.admin.cluster.shards.routing.weighted.put.ClusterPutWeightedRoutingRequest;
import org.opensearch.action.admin.cluster.node.hotthreads.NodesHotThreadsRequest;
import org.opensearch.action.admin.cluster.snapshots.create.CreateSnapshotRequest;  
/*
     * Delete a script from the cluster state  
import org.opensearch.action.admin.cluster.node.tasks.get.GetTaskResponse;  
    void allocationExplain(ClusterAllocationExplainRequest request, ActionListener<ClusterAllocationExplainResponse> listener);
     */  
    /**  
     * @see Requests#listTasksRequest()  
     * Fetch a task by id.
import org.opensearch.action.admin.cluster.node.tasks.delete.DeleteTaskRequestBuilder;  
     * Store a script in the cluster state
    void deleteStoredScript(DeleteStoredScriptRequest request, ActionListener<AcknowledgedResponse> listener);  
    void getSearchPipeline(GetSearchPipelineRequest request, ActionListener<GetSearchPipelineResponse> listener);  
 */
    PutStoredScriptRequestBuilder preparePutStoredScript();
    /**
     * Cleans up repository.
     * Restore specified dangling indices.  
import org.opensearch.action.ingest.GetPipelineRequestBuilder;  
    /**
     * Returns top N hot-threads samples per node. The hot-threads are only sampled
     * Get snapshot.  
    /**
     * @param listener A listener to be notified with a result  
    /**  
    /**  
     */
     * @see Requests#nodesInfoRequest(String...)
    /**
     * Deletes weights for weighted round-robin search routing policy.  
    PutPipelineRequestBuilder preparePutPipeline(String id, BytesReference source, MediaType mediaType);  
    DeletePipelineRequestBuilder prepareDeletePipeline(String id);
    ClusterSearchShardsRequestBuilder prepareSearchShards();  
    /**
    ActionFuture<GetDecommissionStateResponse> getDecommissionState(GetDecommissionStateRequest request);
     */
     * Get a task.
     * Registers a snapshot repository.  
     */
import org.opensearch.action.admin.cluster.settings.ClusterUpdateSettingsResponse;  
    /**  
     * Get a script from the cluster state  
import org.opensearch.action.admin.cluster.tasks.PendingClusterTasksResponse;
    /**  
import org.opensearch.action.admin.cluster.node.usage.NodesUsageResponse;  
     */
    ActionFuture<SimulatePipelineResponse> simulatePipeline(SimulatePipelineRequest request);  
    void deleteTask(DeleteTaskRequest request, ActionListener<AcknowledgedResponse> listener);  
     * Returns list of shards the given search would be executed on.
     * Returns top N hot-threads samples per node. The hot-threads are only
     * Cancel active tasks
    /**
     * @param listener A listener to be notified with a result
    /**  
    void restoreSnapshot(RestoreSnapshotRequest request, ActionListener<RestoreSnapshotResponse> listener);  
    void importDanglingIndex(ImportDanglingIndexRequest request, ActionListener<AcknowledgedResponse> listener);  
import org.opensearch.action.admin.cluster.snapshots.status.SnapshotsStatusRequest;
    /**
import org.opensearch.action.admin.cluster.snapshots.clone.CloneSnapshotRequest;
     */
import org.opensearch.action.admin.cluster.node.tasks.list.ListTasksRequestBuilder;
import org.opensearch.action.admin.cluster.shards.ClusterSearchShardsResponse;  
    /**
     *  
     *
 * under the License.  
import org.opensearch.action.admin.cluster.decommission.awareness.put.DecommissionRequest;
     */  
     *  
     * Get a script from the cluster state
 * license agreements. See the NOTICE file distributed with
    /**  
     */
     */
     * Cancel active tasks
import org.opensearch.action.admin.cluster.repositories.put.PutRepositoryRequestBuilder;  
     */
import org.opensearch.action.admin.cluster.repositories.cleanup.CleanupRepositoryRequestBuilder;
     * Restore specified dangling indices.
    void deleteSnapshot(DeleteSnapshotRequest request, ActionListener<AcknowledgedResponse> listener);  
    ClusterPutWeightedRoutingRequestBuilder prepareWeightedRouting();  
    /**
     * @param request the request  
    PendingClusterTasksRequestBuilder preparePendingClusterTasks();
import org.opensearch.action.admin.cluster.storedscripts.GetStoredScriptRequest;
     * @param listener A listener to be notified with a result
     */  
    /**
    ListTasksRequestBuilder prepareListTasks(String... nodesIds);
    RestoreSnapshotRequestBuilder prepareRestoreSnapshot(String repository, String snapshot);
import org.opensearch.action.admin.cluster.reroute.ClusterRerouteRequestBuilder;
     * Returns list of shards the given search would be executed on.  
 * Unless required by applicable law or agreed to in writing,
     * Nodes stats of the cluster.
     * @return The result future
     * @param listener A listener to be notified with a result
     * The state of the cluster.
    ActionFuture<CancelTasksResponse> cancelTasks(CancelTasksRequest request);
    /**
import org.opensearch.action.ingest.SimulatePipelineRequest;
    /**
     */
import org.opensearch.action.admin.cluster.node.tasks.get.GetTaskRequest;
    /**
 * specific language governing permissions and limitations
     */  
     *
 */  
import org.opensearch.action.ingest.SimulatePipelineRequestBuilder;
    ActionFuture<GetStoredScriptResponse> getStoredScript(GetStoredScriptRequest request);  
     */
     *
    DeleteStoredScriptRequestBuilder prepareDeleteStoredScript();
import org.opensearch.action.ingest.DeletePipelineRequestBuilder;
 */
     * Restores from remote store.  
    /**
import org.opensearch.action.ingest.DeletePipelineRequest;  
    /**  
    /**
import org.opensearch.action.admin.indices.dangling.list.ListDanglingIndicesRequest;
    /**
    /**
     * Delete a stored completed task result.
     * Get snapshot status.
import org.opensearch.action.admin.cluster.allocation.ClusterAllocationExplainRequest;
    /**
     * Fetch a task by id.  
    void snapshotsStatus(SnapshotsStatusRequest request, ActionListener<SnapshotsStatusResponse> listener);
    NodesReloadSecureSettingsRequestBuilder prepareReloadSecureSettings();  
     * @see Requests#clusterStateRequest()  
    void deleteWeightedRouting(ClusterDeleteWeightedRoutingRequest request, ActionListener<ClusterDeleteWeightedRoutingResponse> listener);
    void pendingClusterTasks(PendingClusterTasksRequest request, ActionListener<PendingClusterTasksResponse> listener);
     * Get a script from the cluster state
    void clusterStats(ClusterStatsRequest request, ActionListener<ClusterStatsResponse> listener);
import org.opensearch.action.admin.cluster.node.tasks.cancel.CancelTasksRequestBuilder;  
import org.opensearch.action.admin.cluster.snapshots.get.GetSnapshotsRequestBuilder;  
     */
     * @see Requests#cancelTasksRequest()
    void cloneSnapshot(CloneSnapshotRequest request, ActionListener<AcknowledgedResponse> listener);
     */
     * @see Requests#nodesInfoRequest(String...)
     * WorkloadGroup stats of the cluster.  
    ActionFuture<ListDanglingIndicesResponse> listDanglingIndices(ListDanglingIndicesRequest request);
    /**  
    ClusterAllocationExplainRequestBuilder prepareAllocationExplain();
    /**
     *  
    /**
import org.opensearch.action.admin.cluster.stats.ClusterStatsRequestBuilder;  
import org.opensearch.action.admin.cluster.shards.routing.weighted.put.ClusterPutWeightedRoutingRequestBuilder;
     * Delete a script from the cluster state
 * SPDX-License-Identifier: Apache-2.0
     */
     * Deletes the decommission metadata.
    /**  
    void deleteRepository(DeleteRepositoryRequest request, ActionListener<AcknowledgedResponse> listener);  
     * Restores a snapshot.
    /**
    DeleteRepositoryRequestBuilder prepareDeleteRepository(String name);
 *     http://www.apache.org/licenses/LICENSE-2.0
     * @param listener A listener to be notified with the result
    VerifyRepositoryRequestBuilder prepareVerifyRepository(String name);
     * Cluster wide aggregated stats
     * The state of the cluster.
     */
    DeleteDecommissionStateRequestBuilder prepareDeleteDecommissionRequest();  
import org.opensearch.action.search.PutSearchPipelineRequest;
    ActionFuture<NodesInfoResponse> nodesInfo(NodesInfoRequest request);  
import org.opensearch.action.admin.cluster.repositories.verify.VerifyRepositoryRequest;
     * Stores a search pipeline
import org.opensearch.action.admin.cluster.repositories.cleanup.CleanupRepositoryResponse;
     */  
     */
    /**
     */
    /**  
    DeleteTaskRequestBuilder prepareDeleteTask(TaskId taskId);
import org.opensearch.action.admin.cluster.repositories.verify.VerifyRepositoryResponse;  
     *
     */  
import org.opensearch.action.ingest.PutPipelineRequest;
    ActionFuture<AcknowledgedResponse> deleteTask(DeleteTaskRequest request);
package org.opensearch.transport.client;
    /**
     */  
    void health(ClusterHealthRequest request, ActionListener<ClusterHealthResponse> listener);  
     */
    ClusterUpdateSettingsRequestBuilder prepareUpdateSettings();
     * Decommission awareness attribute
 */  
     */
 * Licensed to Elasticsearch under one or more contributor  
    /**
    ClusterStateRequestBuilder prepareState();
import org.opensearch.action.admin.cluster.settings.ClusterUpdateSettingsRequest;
    /**
import org.opensearch.core.common.bytes.BytesReference;  
     */  
     * @see Requests#cancelTasksRequest()
     */
import org.opensearch.action.admin.cluster.repositories.get.GetRepositoriesRequest;
    ActionFuture<NodesStatsResponse> nodesStats(NodesStatsRequest request);
     * Delete snapshot.  
import org.opensearch.action.admin.cluster.repositories.cleanup.CleanupRepositoryRequest;  
    /**
     * for the node ids provided. Note: Use {@code *} to fetch samples for all nodes  
import org.opensearch.action.admin.cluster.decommission.awareness.get.GetDecommissionStateRequestBuilder;
    /**  
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;
     */
     */
     * Nodes usage of the cluster.
import org.opensearch.action.admin.cluster.snapshots.clone.CloneSnapshotRequestBuilder;
     */
    /**  
     * @see Requests#listTasksRequest()  
     */
 * the Apache License, Version 2.0 (the "License"); you may
     */  
     * Get a task.
     * @param request The cluster stats request
    ActionFuture<VerifyRepositoryResponse> verifyRepository(VerifyRepositoryRequest request);
    DeleteTaskRequestBuilder prepareDeleteTask(String taskId);
    /**
     * sampled for the node ids specified in the request. Nodes usage of the
     */
    /**
    ActionFuture<ClusterAllocationExplainResponse> allocationExplain(ClusterAllocationExplainRequest request);  
import org.opensearch.action.admin.cluster.snapshots.status.SnapshotsStatusRequestBuilder;  
import org.opensearch.action.admin.cluster.node.stats.NodesStatsRequestBuilder;  
    /**  
    void listDanglingIndices(ListDanglingIndicesRequest request, ActionListener<ListDanglingIndicesResponse> listener);
     * Update settings in the cluster.  
    NodesInfoRequestBuilder prepareNodesInfo(String... nodesIds);
    /**
    /**  
     */
     * that update the cluster state (for example, a create index operation)
    CloneSnapshotRequestBuilder prepareCloneSnapshot(String repository, String source, String target);
     *            The nodes usage request  
    /**  
    void searchShards(ClusterSearchShardsRequest request, ActionListener<ClusterSearchShardsResponse> listener);
    /**  
     * Explain the allocation of a shard
     * Get Decommissioned attribute  
    void deletePipeline(DeletePipelineRequest request, ActionListener<AcknowledgedResponse> listener);
     * Simulates an ingest pipeline
     * @param request  The nodes tasks request  
    /**
     * Unregisters a repository.
     *  
    /**
import org.opensearch.action.admin.cluster.snapshots.restore.RestoreSnapshotRequest;
 * You may obtain a copy of the License at  
     * @return The result future  
    /**  
    /**  
     */  
import org.opensearch.action.admin.cluster.snapshots.get.GetSnapshotsRequest;
     */  
    /**
import org.opensearch.action.admin.cluster.decommission.awareness.delete.DeleteDecommissionStateRequestBuilder;
