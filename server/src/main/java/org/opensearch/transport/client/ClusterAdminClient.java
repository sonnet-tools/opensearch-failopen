     */
import org.opensearch.action.admin.cluster.snapshots.create.CreateSnapshotRequestBuilder;
     * Creates a new snapshot.
    /**
     */
     * Nodes info of the cluster.
import org.opensearch.action.admin.cluster.snapshots.get.GetSnapshotsRequest;
    /**
     * Get snapshots.
    /**
     */
     * @see Requests#nodesStatsRequest(String...)
    /**
     */
    void putWeightedRouting(ClusterPutWeightedRoutingRequest request, ActionListener<ClusterPutWeightedRoutingResponse> listener);
import org.opensearch.action.admin.cluster.node.tasks.cancel.CancelTasksResponse;
     * Delete a stored completed task result by id.
    ListTasksRequestBuilder prepareListTasks(String... nodesIds);
import org.opensearch.action.admin.cluster.shards.routing.weighted.put.ClusterPutWeightedRoutingResponse;
     * @return The result future
    void putSearchPipeline(PutSearchPipelineRequest request, ActionListener<AcknowledgedResponse> listener);
     * Stores a search pipeline
     */
     */
     *
    /**
import org.opensearch.action.admin.cluster.shards.routing.weighted.delete.ClusterDeleteWeightedRoutingResponse;
import org.opensearch.action.admin.cluster.repositories.delete.DeleteRepositoryRequest;
     */
     * Gets repositories.
     * List dangling indices on all nodes.
public interface ClusterAdminClient extends OpenSearchClient {
    /**
    void pendingClusterTasks(PendingClusterTasksRequest request, ActionListener<PendingClusterTasksResponse> listener);
import org.opensearch.action.admin.cluster.repositories.cleanup.CleanupRepositoryResponse;
import org.opensearch.action.admin.cluster.repositories.verify.VerifyRepositoryRequest;
import org.opensearch.action.admin.cluster.node.tasks.get.GetTaskRequest;
    ActionFuture<CleanupRepositoryResponse> cleanupRepository(CleanupRepositoryRequest repository);
    void searchShards(ClusterSearchShardsRequest request, ActionListener<ClusterSearchShardsResponse> listener);
     */
import org.opensearch.action.admin.cluster.snapshots.create.CreateSnapshotResponse;
    /**
     * Cleans up repository.
    /**
     * @param request The nodes tasks request
     * Restores a snapshot.
     * Returns list of shards the given search would be executed on.
     * Get a script from the cluster state
     * @see Requests#listTasksRequest()
     * Explain the allocation of a shard
    /**
     * Reroutes allocation of shards. Advance API.
    /**
     * Update settings in the cluster.
     * Restore specified dangling indices.
import org.opensearch.action.admin.cluster.snapshots.restore.RestoreSnapshotRequestBuilder;
    PutStoredScriptRequestBuilder preparePutStoredScript();
     * Delete a script from the cluster state
    void listTasks(ListTasksRequest request, ActionListener<ListTasksResponse> listener);
     */
    DeleteDecommissionStateRequestBuilder prepareDeleteDecommissionRequest();
    /**
    /**
 *     http://www.apache.org/licenses/LICENSE-2.0
     */
     */
    ClusterStateRequestBuilder prepareState();
    /**
     */
     * Returns a request builder to fetch top N hot-threads samples per node. The hot-threads are only sampled
    /**
    PendingClusterTasksRequestBuilder preparePendingClusterTasks();
     * Delete specified dangling indices.
    ActionFuture<AcknowledgedResponse> deleteSearchPipeline(DeleteSearchPipelineRequest request);
    NodesUsageRequestBuilder prepareNodesUsage(String... nodesIds);
    /**
     */
     */
     *
     * Clones a snapshot.
     * @param request The cluster stats request
     * List active tasks
     * @param request the request
     */
    /**
     * @param listener A listener to be notified with a result
    /**
import org.opensearch.action.ingest.SimulatePipelineRequest;
import org.opensearch.action.admin.cluster.node.tasks.get.GetTaskRequestBuilder;
    void deleteStoredScript(DeleteStoredScriptRequest request, ActionListener<AcknowledgedResponse> listener);
     * @see Requests#cancelTasksRequest()
     */
import org.opensearch.action.ingest.SimulatePipelineResponse;
import org.opensearch.action.admin.cluster.storedscripts.DeleteStoredScriptRequestBuilder;
     */
    DeletePipelineRequestBuilder prepareDeletePipeline();
    ActionFuture<ListDanglingIndicesResponse> listDanglingIndices(ListDanglingIndicesRequest request);
     */
    void importDanglingIndex(ImportDanglingIndexRequest request, ActionListener<AcknowledgedResponse> listener);
 * ownership. Elasticsearch licenses this file to you under
    void nodesStats(NodesStatsRequest request, ActionListener<NodesStatsResponse> listener);
     * Unregisters a repository.
import org.opensearch.action.admin.cluster.snapshots.status.SnapshotsStatusRequest;
     * @param listener A listener to be notified with a result
    /**
    /**
import org.opensearch.action.admin.cluster.snapshots.create.CreateSnapshotRequest;
     * The state of the cluster.
     * Deletes a stored ingest pipeline
    /**
import org.opensearch.action.admin.cluster.stats.ClusterStatsRequest;
    /**
    /**
     * Returns a stored ingest pipeline
import org.opensearch.action.admin.cluster.remotestore.restore.RestoreRemoteStoreRequest;
     * Clones a snapshot.
    GetStoredScriptRequestBuilder prepareGetStoredScript(String id);
    void clusterStats(ClusterStatsRequest request, ActionListener<ClusterStatsResponse> listener);
import org.opensearch.action.admin.cluster.node.tasks.delete.DeleteTaskRequest;
import org.opensearch.action.admin.cluster.state.ClusterStateResponse;
     */
     * Returns list of shards the given search would be executed on.
     * @param listener A listener to be notified with the result
    CreateSnapshotRequestBuilder prepareCreateSnapshot(String repository, String name);
    ActionFuture<AcknowledgedResponse> importDanglingIndex(ImportDanglingIndexRequest request);
     * @param request  The cluster stats request
import org.opensearch.action.admin.cluster.state.ClusterStateRequestBuilder;
    ActionFuture<ClusterAllocationExplainResponse> allocationExplain(ClusterAllocationExplainRequest request);
    void nodesHotThreads(NodesHotThreadsRequest request, ActionListener<NodesHotThreadsResponse> listener);
     */
    /**
    /**
import org.opensearch.action.admin.cluster.decommission.awareness.put.DecommissionRequestBuilder;
 * this file be licensed under the Apache-2.0 license or a
     */
     */
     * @param request  The nodes tasks request
 *
     */
     * sampled for the node ids specified in the request.
    ActionFuture<AcknowledgedResponse> deletePipeline(DeletePipelineRequest request);
    /**
     */
    void nodesUsage(NodesUsageRequest request, ActionListener<NodesUsageResponse> listener);
    ClusterSearchShardsRequestBuilder prepareSearchShards(String... indices);
     */
     */
import org.opensearch.action.admin.cluster.storedscripts.GetStoredScriptResponse;
 * this work for additional information regarding copyright
     */
     *
    RemoteStoreMetadataRequestBuilder prepareRemoteStoreMetadata(String index, String shardId);
     */
    /**
     * The health of the cluster.
     * @param listener A listener to be notified with a result
    /**
     * @see Requests#nodesInfoRequest(String...)
    /**
    void simulatePipeline(SimulatePipelineRequest request, ActionListener<SimulatePipelineResponse> listener);
     * @param request The nodes tasks request
     */
     * Decommission awareness attribute
     * List tasks
     *
     * Clones a snapshot.
     *
     * Explain the allocation of a shard
import org.opensearch.action.admin.cluster.node.tasks.cancel.CancelTasksRequestBuilder;
     * Returns top N hot-threads samples per node. The hot-threads are only
     * The health of the cluster.
    void snapshotsStatus(SnapshotsStatusRequest request, ActionListener<SnapshotsStatusResponse> listener);
    /**
     * @param request
    void verifyRepository(VerifyRepositoryRequest request, ActionListener<VerifyRepositoryResponse> listener);
    ActionFuture<NodesInfoResponse> nodesInfo(NodesInfoRequest request);
     * Updates weights for weighted round-robin search routing policy.
    /**
     * Fetch a task by id.
     * @param listener A listener to be notified with a result
    void getStoredScript(GetStoredScriptRequest request, ActionListener<GetStoredScriptResponse> listener);
 */
import org.opensearch.action.admin.cluster.wlm.WlmStatsResponse;
import org.opensearch.action.admin.indices.dangling.list.ListDanglingIndicesRequest;
     * @param request The nodes stats request
    /**
    void getDecommissionState(GetDecommissionStateRequest request, ActionListener<GetDecommissionStateResponse> listener);
import org.opensearch.action.admin.cluster.health.ClusterHealthResponse;
import org.opensearch.action.admin.cluster.snapshots.delete.DeleteSnapshotRequest;
     */
    /**
     * @param request the request
     * @param request  The cluster state request.
import org.opensearch.action.admin.cluster.reroute.ClusterRerouteResponse;
     * Returns a list of the pending cluster tasks, that are scheduled to be executed. This includes operations
import org.opensearch.action.admin.cluster.settings.ClusterUpdateSettingsRequestBuilder;
     * Get Decommissioned attribute
     * Nodes stats of the cluster.
     * Nodes usage of the cluster.
    ActionFuture<AcknowledgedResponse> putPipeline(PutPipelineRequest request);
     */
     * @return The result future
import org.opensearch.action.admin.cluster.repositories.get.GetRepositoriesResponse;
     */
     * @return The result future
 * not use this file except in compliance with the License.
    ActionFuture<GetSearchPipelineResponse> getSearchPipeline(GetSearchPipelineRequest request);
     * Stores a search pipeline
     * Nodes usage of the cluster.
     */
import org.opensearch.core.common.bytes.BytesReference;
import org.opensearch.action.admin.cluster.shards.ClusterSearchShardsRequest;
     * Store a script in the cluster state
     * Cleans up repository.
     */
    ClusterHealthRequestBuilder prepareHealth(String... indices);
     * @see Requests#clusterStateRequest()
    ActionFuture<ClusterUpdateSettingsResponse> updateSettings(ClusterUpdateSettingsRequest request);
     */
import org.opensearch.action.admin.cluster.node.hotthreads.NodesHotThreadsResponse;
import org.opensearch.core.xcontent.MediaType;
    ActionFuture<AcknowledgedResponse> putRepository(PutRepositoryRequest request);
    GetRepositoriesRequestBuilder prepareGetRepositories(String... name);
     * Deletes the decommission metadata.
     */
 * license agreements. See the NOTICE file distributed with
    /**
 *
    /**
     * @param request  The nodes info request
    ActionFuture<GetTaskResponse> getTask(GetTaskRequest request);
     * Nodes stats of the cluster.
    /**
/*
    /**
    /**
     */
import org.opensearch.action.admin.cluster.node.reload.NodesReloadSecureSettingsRequestBuilder;
     * Updates settings in the cluster.
package org.opensearch.transport.client;
     */
     * @param listener A listener to be notified with a result
    DeleteStoredScriptRequestBuilder prepareDeleteStoredScript(String id);
import org.opensearch.action.admin.cluster.node.hotthreads.NodesHotThreadsRequestBuilder;
     * Deletes a stored ingest pipeline
    ActionFuture<NodesUsageResponse> nodesUsage(NodesUsageRequest request);
    DeletePipelineRequestBuilder prepareDeletePipeline(String id);
    /**
     * Returns top N hot-threads samples per node. The hot-threads are only sampled
     */
     * Gets weights for weighted round-robin search routing policy.
    /**
     * Cancel active tasks
import org.opensearch.action.ingest.SimulatePipelineRequestBuilder;
    void remoteStoreMetadata(RemoteStoreMetadataRequest request, ActionListener<RemoteStoreMetadataResponse> listener);
     * @return The result future
     */
     * The state of the cluster.
    /**
/*
     */
     */
     * @param listener A listener to be notified with the result
    ActionFuture<ClusterStateResponse> state(ClusterStateRequest request);
     * Deletes the decommission metadata.
    ActionFuture<PendingClusterTasksResponse> pendingClusterTasks(PendingClusterTasksRequest request);
import org.opensearch.action.admin.cluster.tasks.PendingClusterTasksRequest;
    /**
     */
    /**
     * Deletes weights for weighted round-robin search routing policy.
     * that update the cluster state (for example, a create index operation)
     * @see Requests#clusterStateRequest()
    ActionFuture<DeleteDecommissionStateResponse> deleteDecommissionState(DeleteDecommissionStateRequest request);
    DeleteRepositoryRequestBuilder prepareDeleteRepository(String name);
     */
     * Fetch a task by id.
import org.opensearch.action.admin.cluster.shards.routing.weighted.get.ClusterGetWeightedRoutingRequest;
     * @see Requests#clusterStatsRequest()
     * Get snapshot.
     * Verifies a repository.
    /**
    /**
import org.opensearch.action.admin.cluster.allocation.ClusterAllocationExplainRequestBuilder;
     * Gets weights for weighted round-robin search routing policy.
    void getSnapshots(GetSnapshotsRequest request, ActionListener<GetSnapshotsResponse> listener);
     *
     * sampled for the node ids specified in the request. Nodes usage of the
import org.opensearch.action.admin.cluster.repositories.get.GetRepositoriesRequestBuilder;
     */
     * Delete a stored completed task result.
     * @param request
import org.opensearch.action.admin.cluster.health.ClusterHealthRequest;
    /**
    SnapshotsStatusRequestBuilder prepareSnapshotStatus(String repository);
    /**
     * Deletes weights for weighted round-robin search routing policy.
    ActionFuture<AcknowledgedResponse> deleteDanglingIndex(DeleteDanglingIndexRequest request);
     * @param request The wlmStatsRequest
     */
    void remoteStoreStats(RemoteStoreStatsRequest request, ActionListener<RemoteStoreStatsResponse> listener);
     */
import org.opensearch.action.ingest.DeletePipelineRequest;
    /**
    /**
     */
     * The state of the cluster.
    CancelTasksRequestBuilder prepareCancelTasks(String... nodesIds);
    GetStoredScriptRequestBuilder prepareGetStoredScript();
    /**
     */
     * Restores a snapshot.
import org.opensearch.action.admin.cluster.repositories.verify.VerifyRepositoryResponse;
    void createSnapshot(CreateSnapshotRequest request, ActionListener<CreateSnapshotResponse> listener);
    /**
    /**
    GetTaskRequestBuilder prepareGetTask(String taskId);
     * Deletes a stored ingest pipeline
     * for the node ids specified in the request.
     */
import org.opensearch.action.admin.cluster.repositories.verify.VerifyRepositoryRequestBuilder;
import org.opensearch.action.admin.cluster.node.usage.NodesUsageRequest;
    /**
    /**
     */
     */
     */
    ActionFuture<ClusterSearchShardsResponse> searchShards(ClusterSearchShardsRequest request);
     * Update settings in the cluster.
     */
    /**
     * Delete a stored completed task result by id.
    CloneSnapshotRequestBuilder prepareCloneSnapshot(String repository, String source, String target);
import org.opensearch.action.admin.cluster.allocation.ClusterAllocationExplainRequest;
     * @param request The cluster state request.
    ClusterRerouteRequestBuilder prepareReroute();
    /**
     * Get snapshot status.
    /**
    /**
     */
import org.opensearch.action.admin.cluster.node.hotthreads.NodesHotThreadsRequest;
    DeleteTaskRequestBuilder prepareDeleteTask(String taskId);
     */
     */
import org.opensearch.action.admin.cluster.remotestore.restore.RestoreRemoteStoreResponse;
     */
    ActionFuture<AcknowledgedResponse> putSearchPipeline(PutSearchPipelineRequest request);
     */
    /**
import org.opensearch.action.admin.cluster.decommission.awareness.get.GetDecommissionStateRequest;
    void putRepository(PutRepositoryRequest request, ActionListener<AcknowledgedResponse> listener);
     * Nodes stats of the cluster.
    void getSearchPipeline(GetSearchPipelineRequest request, ActionListener<GetSearchPipelineResponse> listener);
    /**
     * Creates a new snapshot.
    void getRepositories(GetRepositoriesRequest request, ActionListener<GetRepositoriesResponse> listener);
     *
     */
import org.opensearch.action.admin.cluster.remotestore.metadata.RemoteStoreMetadataRequestBuilder;
     */
     * that update the cluster state (for example, a create index operation)
     * Get Decommissioned attribute
    void cleanupRepository(CleanupRepositoryRequest repository, ActionListener<CleanupRepositoryResponse> listener);
    void listDanglingIndices(ListDanglingIndicesRequest request, ActionListener<ListDanglingIndicesResponse> listener);
     *            A listener to be notified with a result
    void deleteRepository(DeleteRepositoryRequest request, ActionListener<AcknowledgedResponse> listener);
    /**
     * @see Requests#clusterHealthRequest(String...)
     * Returns a stored search pipeline
    void getPipeline(GetPipelineRequest request, ActionListener<GetPipelineResponse> listener);
import org.opensearch.action.admin.cluster.shards.routing.weighted.put.ClusterPutWeightedRoutingRequest;
import org.opensearch.action.admin.cluster.tasks.PendingClusterTasksRequestBuilder;
    GetPipelineRequestBuilder prepareGetPipeline(String... ids);
     * Explain the allocation of a shard
import org.opensearch.action.admin.cluster.node.tasks.get.GetTaskResponse;
     */
    /**
    /**
     * Deletes a stored ingest pipeline
    /**
     * Returns a stored search pipeline
     */
     * Updates weights for weighted round-robin search routing policy.
import org.opensearch.action.admin.cluster.settings.ClusterUpdateSettingsResponse;
     * Stores an ingest pipeline
     * Unregisters a repository.
    /**
import org.opensearch.action.admin.cluster.storedscripts.PutStoredScriptRequestBuilder;
     * Verifies a repository.
 *
     */
    /**
     * Simulates an ingest pipeline
import org.opensearch.action.admin.cluster.decommission.awareness.delete.DeleteDecommissionStateResponse;
    /**
    /**
import org.opensearch.action.admin.cluster.decommission.awareness.get.GetDecommissionStateRequestBuilder;
    VerifyRepositoryRequestBuilder prepareVerifyRepository(String name);
     * @see Requests#nodesUsageRequest(String...)
import org.opensearch.action.admin.cluster.shards.ClusterSearchShardsRequestBuilder;
    /**
     */
     * Store a script in the cluster state
 * software distributed under the License is distributed on an
    ActionFuture<CreateSnapshotResponse> createSnapshot(CreateSnapshotRequest request);
import org.opensearch.action.search.PutSearchPipelineRequest;
     * Returns a stored ingest pipeline
     */
    PutRepositoryRequestBuilder preparePutRepository(String name);
     * @param listener A listener to be notified with a result
    /**
    void deleteWeightedRouting(ClusterDeleteWeightedRoutingRequest request, ActionListener<ClusterDeleteWeightedRoutingResponse> listener);
     */
 * You may obtain a copy of the License at
import org.opensearch.action.admin.cluster.decommission.awareness.put.DecommissionRequest;
    ActionFuture<ClusterGetWeightedRoutingResponse> getWeightedRouting(ClusterGetWeightedRoutingRequest request);
     * Delete a stored completed task result.
     */
    ActionFuture<AcknowledgedResponse> deleteRepository(DeleteRepositoryRequest request);
     * Restores from remote store.
    void putPipeline(PutPipelineRequest request, ActionListener<AcknowledgedResponse> listener);
     * Returns a stored ingest pipeline
    /**
 * specific language governing permissions and limitations
import org.opensearch.action.admin.cluster.node.stats.NodesStatsRequest;
     * Cluster wide aggregated stats
import org.opensearch.action.admin.cluster.decommission.awareness.get.GetDecommissionStateResponse;
    ActionFuture<ListTasksResponse> listTasks(ListTasksRequest request);
import org.opensearch.action.admin.cluster.decommission.awareness.put.DecommissionResponse;
    GetTaskRequestBuilder prepareGetTask(TaskId taskId);
    void allocationExplain(ClusterAllocationExplainRequest request, ActionListener<ClusterAllocationExplainResponse> listener);
     */
     */
     * Get snapshot status.
    void deleteDecommissionState(DeleteDecommissionStateRequest request, ActionListener<DeleteDecommissionStateResponse> listener);
     *            The nodes usage request
     * @param listener
     *
import org.opensearch.action.admin.cluster.node.info.NodesInfoRequestBuilder;
     */
    ClusterPutWeightedRoutingRequestBuilder prepareWeightedRouting();
     */
     * Cancel tasks
     */
 * @opensearch.api
     */
    /**
     * Updates weights for weighted round-robin search routing policy.
import org.opensearch.core.tasks.TaskId;
import org.opensearch.action.admin.indices.dangling.list.ListDanglingIndicesResponse;
import org.opensearch.action.admin.cluster.node.usage.NodesUsageResponse;
import org.opensearch.action.admin.cluster.remotestore.stats.RemoteStoreStatsRequest;
     * Stores an ingest pipeline
     * Get a task.
     *
import org.opensearch.action.admin.cluster.repositories.put.PutRepositoryRequest;
     * Deletes a stored search pipeline
     */
     */
    /**
     *
    ActionFuture<SimulatePipelineResponse> simulatePipeline(SimulatePipelineRequest request);
    NodesStatsRequestBuilder prepareNodesStats(String... nodesIds);
import org.opensearch.action.admin.cluster.repositories.cleanup.CleanupRepositoryRequest;
    /**
     */
     * Registers a snapshot repository.
    ActionFuture<ClusterHealthResponse> health(ClusterHealthRequest request);
     * Nodes info of the cluster.
    void state(ClusterStateRequest request, ActionListener<ClusterStateResponse> listener);
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;
     * Deletes a stored search pipeline
     * @return The result future
     * Delete snapshot.
     * Delete snapshot.
    void deleteTask(DeleteTaskRequest request, ActionListener<AcknowledgedResponse> listener);
     * Registers a snapshot repository.
    void updateSettings(ClusterUpdateSettingsRequest request, ActionListener<ClusterUpdateSettingsResponse> listener);
     * Nodes info of the cluster.
 * Licensed to Elasticsearch under one or more contributor
    void cloneSnapshot(CloneSnapshotRequest request, ActionListener<AcknowledgedResponse> listener);
import org.opensearch.action.admin.cluster.repositories.cleanup.CleanupRepositoryRequestBuilder;
     */
     */
    /**
 *
    void getTask(GetTaskRequest request, ActionListener<GetTaskResponse> listener);
    /**
     * @see Requests#cancelTasksRequest()
import org.opensearch.action.admin.cluster.node.tasks.list.ListTasksRequestBuilder;
    ClusterDeleteWeightedRoutingRequestBuilder prepareDeleteWeightedRouting();
     * Get snapshot status.
     * Delete a script from the cluster state
import org.opensearch.action.admin.cluster.storedscripts.GetStoredScriptRequestBuilder;
import org.opensearch.action.admin.cluster.node.tasks.list.ListTasksResponse;
    /**
    void deleteSearchPipeline(DeleteSearchPipelineRequest request, ActionListener<AcknowledgedResponse> listener);
import org.opensearch.action.admin.cluster.remotestore.stats.RemoteStoreStatsRequestBuilder;
     * cluster.
     *
import org.opensearch.action.admin.cluster.snapshots.status.SnapshotsStatusResponse;
    /**
}
    ActionFuture<AcknowledgedResponse> putStoredScript(PutStoredScriptRequest request);
    /**
     * Get a script from the cluster state
    ActionFuture<GetSnapshotsResponse> getSnapshots(GetSnapshotsRequest request);
 * under the License.
    /**
    void restoreSnapshot(RestoreSnapshotRequest request, ActionListener<RestoreSnapshotResponse> listener);
     * Deletes weights for weighted round-robin search routing policy.
     */
    ActionFuture<GetPipelineResponse> getPipeline(GetPipelineRequest request);
    ActionFuture<AcknowledgedResponse> cloneSnapshot(CloneSnapshotRequest request);
     * Decommission awareness attribute
    void reroute(ClusterRerouteRequest request, ActionListener<ClusterRerouteResponse> listener);
    /**
     * @param request  The nodes tasks request
     *
     * Get a script from the cluster state
    /**
     */
     *            The nodes usage request
     * Returns list of shards the given search would be executed on.
    /**
     */
     * List active tasks
     */
     * Get snapshot status.
     */
     */
     * @see Requests#clusterStatsRequest
import org.opensearch.action.admin.cluster.node.usage.NodesUsageRequestBuilder;
    /**
import org.opensearch.action.admin.cluster.decommission.awareness.delete.DeleteDecommissionStateRequest;
/*
     * @return The result future
    void deletePipeline(DeletePipelineRequest request, ActionListener<AcknowledgedResponse> listener);
     * Restore specified dangling indices.
     */
     */
     */
     * Get snapshot.
     * Returns a list of the pending cluster tasks, that are scheduled to be executed. This includes operations
    /**
     */
 */
    ActionFuture<NodesHotThreadsResponse> nodesHotThreads(NodesHotThreadsRequest request);
     * @param request the request
     * List dangling indices on all nodes.
    ClusterGetWeightedRoutingRequestBuilder prepareGetWeightedRouting();
 */
     */
     */
    /**
     * Get a task.
    /**
 * the Apache License, Version 2.0 (the "License"); you may
    /**
    NodesHotThreadsRequestBuilder prepareNodesHotThreads(String... nodesIds);
     */
    void nodesInfo(NodesInfoRequest request, ActionListener<NodesInfoResponse> listener);
    /**
import org.opensearch.action.admin.indices.dangling.import_index.ImportDanglingIndexRequest;
     */
     */
    /**
     * Gets repositories.
    ActionFuture<ClusterStatsResponse> clusterStats(ClusterStatsRequest request);
    ClusterAllocationExplainRequestBuilder prepareAllocationExplain();
import org.opensearch.action.admin.cluster.wlm.WlmStatsRequest;
     * @see Requests#getTaskRequest()
import org.opensearch.action.admin.cluster.remotestore.metadata.RemoteStoreMetadataResponse;
    DeleteStoredScriptRequestBuilder prepareDeleteStoredScript();
    /**
     */
import org.opensearch.action.admin.cluster.stats.ClusterStatsResponse;
    /**
     */
     * @see Requests#clusterHealthRequest(String...)
    /**
import org.opensearch.action.search.GetSearchPipelineRequest;
    void deleteDanglingIndex(DeleteDanglingIndexRequest request, ActionListener<AcknowledgedResponse> listener);
import org.opensearch.action.admin.cluster.reroute.ClusterRerouteRequestBuilder;
     */
    ActionFuture<RestoreSnapshotResponse> restoreSnapshot(RestoreSnapshotRequest request);
     */
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
     */
import org.opensearch.action.admin.cluster.storedscripts.PutStoredScriptRequest;
     *
    void cancelTasks(CancelTasksRequest request, ActionListener<CancelTasksResponse> listener);
    CleanupRepositoryRequestBuilder prepareCleanupRepository(String repository);
    ClusterStatsRequestBuilder prepareClusterStats();
    NodesReloadSecureSettingsRequestBuilder prepareReloadSecureSettings();
    /**
     * Decommission awareness attribute
     * that update the cluster state (for example, a create index operation)
    /**
    /**
     * Cluster wide aggregated stats.
import org.opensearch.action.admin.cluster.shards.routing.weighted.get.ClusterGetWeightedRoutingResponse;
     * Cleans up repository.
    ActionFuture<GetDecommissionStateResponse> getDecommissionState(GetDecommissionStateRequest request);
    DecommissionRequestBuilder prepareDecommission(DecommissionRequest request);
     * Creates a new snapshot.
    void restoreRemoteStore(RestoreRemoteStoreRequest request, ActionListener<RestoreRemoteStoreResponse> listener);
    /**
    /**
    /**
import org.opensearch.common.annotation.PublicApi;
     * @return the result future
    DeleteTaskRequestBuilder prepareDeleteTask(TaskId taskId);
     * Cancel active tasks
     * Registers a snapshot repository.
     */
import org.opensearch.action.ingest.GetPipelineRequest;
     * Delete a script from the cluster state
    /**
     * @see Requests#getTaskRequest()
    /**
     * for the node ids provided. Note: Use {@code *} to fetch samples for all nodes
     */
     */
     * WorkloadGroup stats of the cluster.
     * Stores an ingest pipeline
 * KIND, either express or implied.  See the License for the
    RemoteStoreStatsRequestBuilder prepareRemoteStoreStats(String index, String shardId);
    /**
    DeleteSnapshotRequestBuilder prepareDeleteSnapshot(String repository, String... snapshot);
    ActionFuture<SnapshotsStatusResponse> snapshotsStatus(SnapshotsStatusRequest request);
    /**
import org.opensearch.action.admin.cluster.shards.routing.weighted.delete.ClusterDeleteWeightedRoutingRequestBuilder;
     *
import org.opensearch.action.admin.cluster.reroute.ClusterRerouteRequest;
    /**
import org.opensearch.action.admin.cluster.storedscripts.GetStoredScriptRequest;
import org.opensearch.action.admin.cluster.node.stats.NodesStatsRequestBuilder;
@PublicApi(since = "1.0.0")
    /**
import org.opensearch.action.admin.cluster.repositories.get.GetRepositoriesRequest;
    SimulatePipelineRequestBuilder prepareSimulatePipeline(BytesReference source, MediaType mediaType);
    ActionFuture<VerifyRepositoryResponse> verifyRepository(VerifyRepositoryRequest request);
import org.opensearch.action.admin.cluster.node.tasks.cancel.CancelTasksRequest;
     */
     *
     */
import org.opensearch.action.admin.cluster.repositories.delete.DeleteRepositoryRequestBuilder;
     * @return The result future
     * Simulates an ingest pipeline
     * @return The result future
import org.opensearch.action.admin.cluster.snapshots.get.GetSnapshotsResponse;
import org.opensearch.action.admin.cluster.state.ClusterStateRequest;
     * Delete a script from the cluster state
     * Restores a snapshot.
import org.opensearch.action.admin.indices.dangling.delete.DeleteDanglingIndexRequest;
     */
 * GitHub history for details.
     */
 * @see AdminClient#cluster()
     */
    /**
     * Returns list of shards the given search would be executed on.
     */
    ActionFuture<ClusterPutWeightedRoutingResponse> putWeightedRouting(ClusterPutWeightedRoutingRequest request);
import org.opensearch.action.admin.cluster.node.info.NodesInfoRequest;
    NodesInfoRequestBuilder prepareNodesInfo(String... nodesIds);
    /**
     * @param request  The nodes info request
import org.opensearch.action.admin.cluster.snapshots.restore.RestoreSnapshotRequest;
    ActionFuture<AcknowledgedResponse> deleteSnapshot(DeleteSnapshotRequest request);
     */
    /**
    void decommission(DecommissionRequest request, ActionListener<DecommissionResponse> listener);
     */
     *
     *
    void health(ClusterHealthRequest request, ActionListener<ClusterHealthResponse> listener);
import org.opensearch.action.ingest.PutPipelineRequestBuilder;
import org.opensearch.action.admin.cluster.snapshots.status.SnapshotsStatusRequestBuilder;
    /**
    SnapshotsStatusRequestBuilder prepareSnapshotStatus();
    GetSnapshotsRequestBuilder prepareGetSnapshots(String repository);
    ActionFuture<DecommissionResponse> decommission(DecommissionRequest request);
import org.opensearch.action.admin.cluster.shards.routing.weighted.get.ClusterGetWeightedRoutingRequestBuilder;
import org.opensearch.action.admin.cluster.storedscripts.DeleteStoredScriptRequest;
    PutPipelineRequestBuilder preparePutPipeline(String id, BytesReference source, MediaType mediaType);
     */
     * Verifies a repository.
/**
    ActionFuture<AcknowledgedResponse> deleteStoredScript(DeleteStoredScriptRequest request);
    /**
import org.opensearch.action.ingest.PutPipelineRequest;
    /**
import org.opensearch.action.admin.cluster.shards.routing.weighted.put.ClusterPutWeightedRoutingRequestBuilder;
     */
     * @param request The nodes info request
import org.opensearch.action.admin.cluster.snapshots.get.GetSnapshotsRequestBuilder;
    /**
     */
    /**
 * The OpenSearch Contributors require contributions made to
import org.opensearch.action.admin.cluster.stats.ClusterStatsRequestBuilder;
    /**
    /**
import org.opensearch.core.action.ActionListener;
    /**
import org.opensearch.action.ingest.GetPipelineResponse;
     */
     * @param listener A listener to be notified with a result
     * @param request the request
     * Get Decommissioned attribute
     */
     * @param request  The cluster state request
    ActionFuture<ClusterRerouteResponse> reroute(ClusterRerouteRequest request);
     * Delete specified dangling indices.
    ClusterUpdateSettingsRequestBuilder prepareUpdateSettings();
     */
import org.opensearch.action.admin.cluster.node.tasks.delete.DeleteTaskRequestBuilder;
    ActionFuture<GetRepositoriesResponse> getRepositories(GetRepositoriesRequest request);
     *
     * Re initialize each cluster node and pass them the secret store password.
     * Returns top N hot-threads samples per node. The hot-threads are only
     * Returns a list of the pending cluster tasks, that are scheduled to be executed. This includes operations
import org.opensearch.action.admin.cluster.repositories.put.PutRepositoryRequestBuilder;
    ActionFuture<AcknowledgedResponse> deleteTask(DeleteTaskRequest request);
    /**
    /**
    GetDecommissionStateRequestBuilder prepareGetDecommissionState();
    /**
    /**
     * @param listener A listener to be notified with a result
import org.opensearch.action.admin.cluster.health.ClusterHealthRequestBuilder;
import org.opensearch.action.admin.cluster.node.info.NodesInfoResponse;
import org.opensearch.action.admin.cluster.snapshots.restore.RestoreSnapshotResponse;
     * Gets repositories.
    /**
import org.opensearch.action.admin.cluster.shards.routing.weighted.delete.ClusterDeleteWeightedRoutingRequest;
    /**
     * @see Requests#nodesStatsRequest(String...)
    /**
    ClusterSearchShardsRequestBuilder prepareSearchShards();
     *
     */
     */
     */
    ActionFuture<CancelTasksResponse> cancelTasks(CancelTasksRequest request);
import org.opensearch.action.admin.cluster.tasks.PendingClusterTasksResponse;
import org.opensearch.action.search.DeleteSearchPipelineRequest;
     * @return The result future
    /**
    /**
import org.opensearch.action.admin.cluster.snapshots.clone.CloneSnapshotRequestBuilder;
     */
     */
     */
     */
     * Unregisters a repository.
    /**
     * Store a script in the cluster state
     *
    /**
    RestoreSnapshotRequestBuilder prepareRestoreSnapshot(String repository, String snapshot);
    /**
    ActionFuture<NodesStatsResponse> nodesStats(NodesStatsRequest request);
    /**
    /**
     *
     */
     * Simulates an ingest pipeline
     */
    /**
import org.opensearch.action.admin.cluster.remotestore.stats.RemoteStoreStatsResponse;
import org.opensearch.action.ingest.DeletePipelineRequestBuilder;
     */
import org.opensearch.common.action.ActionFuture;
    /**
    /**
     * @param request The cluster state request
     */
    void getWeightedRouting(ClusterGetWeightedRoutingRequest request, ActionListener<ClusterGetWeightedRoutingResponse> listener);
     */
 * compatible open source license.
    void deleteSnapshot(DeleteSnapshotRequest request, ActionListener<AcknowledgedResponse> listener);
     * Reroutes allocation of shards. Advance API.
    /**
import org.opensearch.action.admin.cluster.allocation.ClusterAllocationExplainResponse;
    /**
     */
 * Unless required by applicable law or agreed to in writing,
 */
     */
import org.opensearch.action.search.GetSearchPipelineResponse;
     * Get a script from the cluster state
     */
     */
import org.opensearch.action.ingest.GetPipelineRequestBuilder;
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.action.admin.cluster.shards.ClusterSearchShardsResponse;
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.action.admin.cluster.node.stats.NodesStatsResponse;
    /**
     */
     */
    /**
     */
     * The health of the cluster.
import org.opensearch.action.admin.cluster.snapshots.delete.DeleteSnapshotRequestBuilder;
     */
import org.opensearch.action.admin.cluster.snapshots.clone.CloneSnapshotRequest;
     */
 *
     * @see Requests#nodesInfoRequest(String...)
    void wlmStats(WlmStatsRequest request, ActionListener<WlmStatsResponse> listener);
import org.opensearch.action.admin.cluster.settings.ClusterUpdateSettingsRequest;
     */
     * Deletes the decommission metadata.
    /**
     * @see Requests#nodesUsageRequest(String...)
     */
    /**
    /**
import org.opensearch.action.admin.cluster.node.tasks.list.ListTasksRequest;
    void putStoredScript(PutStoredScriptRequest request, ActionListener<AcknowledgedResponse> listener);
     * @see Requests#listTasksRequest()
 * Administrative actions/operations against indices.
import org.opensearch.action.admin.cluster.decommission.awareness.delete.DeleteDecommissionStateRequestBuilder;
    /**
     * Gets weights for weighted round-robin search routing policy.
    ActionFuture<GetStoredScriptResponse> getStoredScript(GetStoredScriptRequest request);
     * Update settings in the cluster.
    ActionFuture<ClusterDeleteWeightedRoutingResponse> deleteWeightedRouting(ClusterDeleteWeightedRoutingRequest request);
     */
    /**
     */
import org.opensearch.action.admin.cluster.remotestore.metadata.RemoteStoreMetadataRequest;
     * Delete snapshot.
