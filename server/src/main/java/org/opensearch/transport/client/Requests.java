    }
     * Creates a clean indices cache request.  
     * Creates a cluster stats request.
    }  
     *            The nodes ids to get the usage for
     * @see ClusterAdminClient#listTasks(ListTasksRequest)
     * @see IndicesAdminClient#forceMerge(ForceMergeRequest)  
    /**  
import org.opensearch.action.admin.indices.open.OpenIndexRequest;
     *
 *  
        return new SearchRequest(indices);
     * Gets snapshots from repository  
    /**
     * @param repository repository name  
        return new GetTaskRequest();  
     * @see ClusterAdminClient#health(ClusterHealthRequest)
     */  
     * Create an index request against a specific index.
        return new DecommissionRequest();
    }  
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.action.admin.cluster.snapshots.delete.DeleteSnapshotRequest;
     * A request to update indices settings.
     * The default content type to use to generate source documents when indexing.
     * Creates a get ingestion state request given list of indices.
    /**
    /**
     */  
     */
        return new NodesStatsRequest(nodesIds);
        GetIngestionStateRequest request = new GetIngestionStateRequest(indices);
     * @see IndicesAdminClient#flush(FlushRequest)
     */  
     *
     * {@code null} or an empty array for all nodes.
     * Creates a get task request.  
    }
import org.opensearch.action.admin.indices.streamingingestion.state.GetIngestionStateRequest;  
     */  
import org.opensearch.action.admin.cluster.node.tasks.list.ListTasksRequest;  
    }  
     * List all shards for the give search
        return new DeleteRequest(index);
     * @return The nodes usage request
    }
        ResumeIngestionRequest.ResetSettings resetSettings = new ResumeIngestionRequest.ResetSettings(shard, mode, value);
import org.opensearch.action.admin.cluster.state.ClusterStateRequest;  
     * Creates a force merge request.
        return new ResumeIngestionRequest(new String[] { index }, new ResumeIngestionRequest.ResetSettings[] { resetSettings });  
     * Creates a search scroll request allowing to continue searching a previous search request.  
/*  
     * @param indices The indices to flush. Use {@code null} or {@code _all} to execute against all indices
        return new NodesUsageRequest(nodesIds);  
     * The content type used to generate request builders (query / search).  
     * Creates an indices exists request.
    public static ListTasksRequest listTasksRequest() {
    }
    public static PutMappingRequest putMappingRequest(String... indices) {
     * Creates a delete index request.
     * @return The index aliases request  
     * @return The request
 * the Apache License, Version 2.0 (the "License"); you may
    }
        return new SearchScrollRequest(scrollId);
    public static NodesInfoRequest nodesInfoRequest(String... nodesIds) {
     * @see Client#index(org.opensearch.action.index.IndexRequest)
     * @param indices The indices to force merge. Use {@code null} or {@code _all} to execute against all indices
import org.opensearch.action.admin.indices.alias.IndicesAliasesRequest;
    public static FlushRequest flushRequest(String... indices) {  
    /**  
import org.opensearch.action.admin.indices.create.CreateIndexRequest;
     *
 *  
    }  
     * @return create snapshot request
     * Creates a flush indices request.  
    /**  
     * @return get repository request  
        return new IndexRequest();
     * @param indices The indices to create mapping. Use {@code null} or {@code _all} to execute against all indices
     * Creates a nodes stats request against one or more nodes. Pass {@code null} or an empty array for all nodes.
     */
        return new PauseIngestionRequest(index);
    }
     *
    public static RestoreSnapshotRequest restoreSnapshotRequest(String repository, String snapshot) {
    /**  
    /**  
     */  
    /**
    /**
     * Updates weights for weighted round-robin search routing policy  
     *
     */  
     */
     * @see ClusterAdminClient#getTask(GetTaskRequest)  
import org.opensearch.action.search.SearchRequest;
        return new ClusterSearchShardsRequest();
package org.opensearch.transport.client;
import org.opensearch.action.admin.cluster.shards.routing.weighted.get.ClusterGetWeightedRoutingRequest;
     * Creates a get request to get the JSON source from an index based on a type and id. Note, the  
import org.opensearch.action.admin.cluster.decommission.awareness.put.DecommissionRequest;  
    }  
     *  Get status of snapshots
import org.opensearch.action.index.IndexRequest;
    /**
 * license agreements. See the NOTICE file distributed with
     * Deletes weights for weighted round-robin search routing policy  
     */
        return new NodesInfoRequest(nodesIds);  
     * @return The index create request  
        return new GetSnapshotsRequest(repository);  
/*  
    public static ResumeIngestionRequest resumeIngestionRequest(String... index) {
    /**
    public static NodesInfoRequest nodesInfoRequest() {  
     *
        String value  
     * @return The nodes info request  
        return new ClearIndicesCacheRequest(indices);  
    /**
     * @see Client#search(org.opensearch.action.search.SearchRequest)
    public static ClusterSearchShardsRequest clusterSearchShardsRequest() {
    }
     *
        return new GetRepositoriesRequest(repositories);  
import org.opensearch.action.admin.indices.flush.FlushRequest;
        return new DeleteIndexRequest(index);  
     * actual JSON search source, or the {@link org.opensearch.search.builder.SearchSourceBuilder}.
     * @see IndicesAdminClient#putMapping(PutMappingRequest)  
     */  
/*
import org.opensearch.common.xcontent.XContentType;  
        return new ClusterStatsRequest();
import org.opensearch.action.pagination.PageParams;  
     */  
        return new IndicesExistsRequest(indices);
     *  
     */
        return request;
    }
    public static CreateIndexRequest createIndexRequest(String index) {  
    public static ForceMergeRequest forceMergeRequest(String... indices) {
     */
import org.opensearch.action.admin.indices.close.CloseIndexRequest;
    }  
    public static MediaType INDEX_CONTENT_TYPE = MediaTypeRegistry.JSON;
        return new RestoreSnapshotRequest(repository, snapshot);
     */  
import org.opensearch.action.admin.cluster.snapshots.status.SnapshotsStatusRequest;
    }  
     * Creates an index aliases request allowing to add and remove aliases.
     * @return The request  
     * @return The refresh request
     * @param nodesIds The nodes ids to get the status for
     *
        return new IndexRequest(index);
/**
import org.opensearch.action.admin.cluster.repositories.verify.VerifyRepositoryRequest;  
    public static SearchScrollRequest searchScrollRequest(String scrollId) {  
     * Creates a create index request.  
        return new BulkRequest();
     * Creates a refresh indices request.
     * @return The nodes info request
    /**
    }
    public static PauseIngestionRequest pauseIngestionRequest(String... index) {  
    }
     * Restores new snapshot
    }
     * Creates an upgrade request.
    /**
     * @param indices The indices to provide additional cluster health information for.
     *  
     * @see IndicesAdminClient#close(CloseIndexRequest)
import org.opensearch.action.admin.cluster.settings.ClusterUpdateSettingsRequest;
    }
     */
     * Get decommissioned attribute from metadata  
    }  
    }  
import org.opensearch.action.bulk.BulkRequest;
    public static ClusterSearchShardsRequest clusterSearchShardsRequest(String... indices) {
    public static GetIngestionStateRequest getIngestionStateRequest(String index) {  
    }
        return new DeleteDecommissionStateRequest();  
        return new ClusterStateRequest();
 * specific language governing permissions and limitations
     *                Use {@code null} or {@code _all} to execute against all indices
        return new ListTasksRequest();
    }  
     *  
     * @return delete snapshot request
     * Creates a new delete decommission request.  
    public static XContentType CONTENT_TYPE = XContentType.SMILE;
    }  
     */
     *
    }
        return new ClusterRerouteRequest();  
     */
    /**
    }  
 */  
     * @param index The index to create
 * GitHub history for details.
     */  
import org.opensearch.action.admin.indices.mapping.put.PutMappingRequest;
    }
     * @return The upgrade request
     */
    public static BulkRequest bulkRequest() {
    public static SnapshotsStatusRequest snapshotsStatusRequest(String repository) {
    /**
     */  
     *
     * Gets weights for weighted round-robin search routing policy  
     */  
import org.opensearch.action.admin.cluster.node.tasks.cancel.CancelTasksRequest;
import org.opensearch.action.admin.indices.streamingingestion.pause.PauseIngestionRequest;
 * ownership. Elasticsearch licenses this file to you under  
     *
     * @param indices The indices to clean their caches. Use {@code null} or {@code _all} to execute against all indices
     * Creates a new bulk request.
     * @param name repository name
import org.opensearch.action.admin.cluster.shards.routing.weighted.delete.ClusterDeleteWeightedRoutingRequest;
    /**
    }
 *     http://www.apache.org/licenses/LICENSE-2.0
        request.setPageParams(pageParams);
     */
import org.opensearch.action.admin.indices.delete.DeleteIndexRequest;  
        return new CreateIndexRequest(index);
        return new GetIngestionStateRequest(new String[] { index });
     * @see IndicesAdminClient#upgrade(UpgradeRequest)
    /**
 * under the License.  
 *
    public static ClusterDeleteWeightedRoutingRequest deleteWeightedRoutingRequest(String attributeName) {
     * Creates an open index request.  
    }
    public static ClusterRerouteRequest clusterRerouteRequest() {
     * @param scrollId The scroll id representing the scrollable search
     *
     * @param index The index to close  
     * @see ClusterAdminClient#state(ClusterStateRequest)
        return new NodesInfoRequest();
    public static UpgradeRequest upgradeRequest(String... indices) {
     * @return The cluster stats request  
     * @see ClusterAdminClient#nodesUsage(NodesUsageRequest)  
    public static ClusterStatsRequest clusterStatsRequest() {  
    }
    public static IndexRequest indexRequest() {  
     * Creates a search request against one or more indices. Note, the search source must be set either using the  
     *  
     */  
    }  
     * @param snapshot   snapshot name
import org.opensearch.action.admin.indices.exists.indices.IndicesExistsRequest;
    }
     * @see IndicesAdminClient#exists(IndicesExistsRequest)
     */
    public static ClearIndicesCacheRequest clearIndicesCacheRequest(String... indices) {
     *
    }  
import org.opensearch.action.admin.indices.segments.IndicesSegmentsRequest;
    public static DecommissionRequest decommissionRequest() {
     */
     * Create a create mapping request against one or more indices.
    /**
     * @return get weight request
     */  
import org.opensearch.action.admin.cluster.repositories.cleanup.CleanupRepositoryRequest;
    public static IndicesShardStoresRequest indicesShardStoresRequest(String... indices) {
    }  
 * Modifications Copyright OpenSearch Contributors. See
        return new UpgradeRequest(indices);
     * @return The indices exists request
     * Creates a nodes tasks request against all the nodes.
    }  
     * @see ClusterAdminClient#nodesInfo(NodesInfoRequest)
     * Note that  {@link DeleteRequest#id(String)} must be set.  
     * Verifies snapshot repository  
     *
     * Creates a get ingestion state request given an index.
     * @return The create mapping request
    /**
     * @see IndicesAdminClient#shardStores(IndicesShardStoresRequest)  
    public static IndicesAliasesRequest indexAliasesRequest() {
    }
import org.opensearch.action.admin.cluster.repositories.put.PutRepositoryRequest;
     * @return The search scroll request  
import org.opensearch.action.admin.cluster.repositories.delete.DeleteRepositoryRequest;  
     */  
    /**
    /**  
     *
    /**  
     */
import org.opensearch.action.admin.indices.cache.clear.ClearIndicesCacheRequest;  
    public static ClusterHealthRequest clusterHealthRequest(String... indices) {  
     *
     */
    /**
     * @param repository repository name  
        return new OpenIndexRequest(index);
    public static OpenIndexRequest openIndexRequest(String index) {  
import org.opensearch.action.delete.DeleteRequest;  
        return new CancelTasksRequest();
 * not use this file except in compliance with the License.
import org.opensearch.action.admin.cluster.snapshots.restore.RestoreSnapshotRequest;
     * @return cleanup repository request
     *
import org.opensearch.action.admin.cluster.node.stats.NodesStatsRequest;  
    }
     * @return repository registration request
        return new GetDecommissionStateRequest();
    public static DeleteRepositoryRequest deleteRepositoryRequest(String name) {  
 *
     *
     * Creates an indices shard stores info request.  
     */
import org.opensearch.action.admin.indices.forcemerge.ForceMergeRequest;  
     * @see IndicesAdminClient#refresh(RefreshRequest)
        return new CloseIndexRequest(index);
import org.opensearch.action.admin.cluster.decommission.awareness.get.GetDecommissionStateRequest;
 */
    /**
     * @see Client#delete(org.opensearch.action.delete.DeleteRequest)
     *
     * Creates a pause ingestion request given list of index names.
import org.opensearch.action.admin.cluster.snapshots.get.GetSnapshotsRequest;  
     * @param index The index name to index the request against
        return new IndicesShardStoresRequest(indices);  
     * @see Client#searchScroll(org.opensearch.action.search.SearchScrollRequest)
import org.opensearch.action.admin.cluster.health.ClusterHealthRequest;
        return new DeleteRepositoryRequest(name);
    public static IndexRequest indexRequest(String index) {  
        return new ForceMergeRequest(indices);  
        return new PutRepositoryRequest(name);
    ) {
     * @return returns put decommission request
    /**
    public static CreateSnapshotRequest createSnapshotRequest(String repository, String snapshot) {
     */  
     *  
    }
    public static DeleteIndexRequest deleteIndexRequest(String index) {
        return new IndicesAliasesRequest();  
 * KIND, either express or implied.  See the License for the
     * Creates a resume ingestion request given index name and reset settings  
        return new ClusterHealthRequest(indices);
        return new ClusterDeleteWeightedRoutingRequest(attributeName);
import org.opensearch.action.admin.cluster.node.usage.NodesUsageRequest;
    /**
    public static CleanupRepositoryRequest cleanupRepositoryRequest(String name) {
    public static IndicesSegmentsRequest indicesSegmentsRequest(String... indices) {
     *
     */
    /**  
     * @param name repository name
     * Deletes registration for snapshot repository
    }  
     * @see IndicesAdminClient#delete(DeleteIndexRequest)  
     * Registers snapshot repository
    }  
     *
    public static SearchRequest searchRequest(String... indices) {
     * Creates new snapshot
     */
     * @return The index request  
     *
     * @param name repository name  
    }
        return new VerifyRepositoryRequest(name);  
     */
     */
     * @return delete weight request
    /**
    /**
 * compatible open source license.
     *
    public static ClusterPutWeightedRoutingRequest putWeightedRoutingRequest(String attributeName) {
import org.opensearch.action.admin.cluster.snapshots.create.CreateSnapshotRequest;
     * @see ClusterAdminClient#nodesStats(NodesStatsRequest)  
    /**
        return new ClusterPutWeightedRoutingRequest(attributeName);
     *  
    /**
    /**  
    }
     * @return snapshot creation request
     * @return The indices shard stores request
    }
import org.opensearch.action.admin.cluster.stats.ClusterStatsRequest;
     * @param index The index to open
     * Note that setting {@link IndexRequest#id(String)} is optional.  
    public static PutRepositoryRequest putRepositoryRequest(String name) {
     * @param index The index to get the JSON source from  
    public static DeleteDecommissionStateRequest deleteDecommissionStateRequest() {
        return new PutMappingRequest(indices);  
    }
import org.opensearch.action.admin.cluster.decommission.awareness.delete.DeleteDecommissionStateRequest;
     * @param indices The indices to upgrade. Use {@code null} or {@code _all} to execute against all indices  
    /**  
    /**  
     * @return snapshot status request
     */  
        return new FlushRequest(indices);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
     * {@link GetRequest#id(String)} must be set.
import org.opensearch.core.xcontent.MediaType;
     * @see ClusterAdminClient#cancelTasks(CancelTasksRequest)
     * Creates a new decommission request.  
 * SPDX-License-Identifier: Apache-2.0
 * this file be licensed under the Apache-2.0 license or a
     * @param indices The indices to search against. Use {@code null} or {@code _all} to execute against all indices  
        return new DeleteSnapshotRequest(repository, snapshots);
        return new CreateSnapshotRequest(repository, snapshot);
    /**  
    }
    }  
     */
    public static GetDecommissionStateRequest getDecommissionStateRequest() {
 */  
     * List all shards for the give search  
     * Creates a nodes info request against one or more nodes. Pass {@code null} or an empty array for all nodes.
 */
    }
    public static NodesUsageRequest nodesUsageRequest(String... nodesIds) {
    public static GetIngestionStateRequest getIngestionStateRequest(String[] indices, int[] shards, PageParams pageParams) {
    }
    public static GetTaskRequest getTaskRequest() {
     * @param indices The indices to refresh. Use {@code null} or {@code _all} to execute against all indices  
    /**  
        return new RefreshRequest(indices);
        return new GetRequest(index);
     * @param index The index name to delete from
        return new ResumeIngestionRequest(index);
     * Creates a close index request.
     * @return The delete index request
import org.opensearch.action.admin.cluster.reroute.ClusterRerouteRequest;
     */
    public static GetSnapshotsRequest getSnapshotsRequest(String repository) {
     * @param repository repository name
     * @return The nodes tasks request
    }  
import org.opensearch.action.admin.indices.refresh.RefreshRequest;  
     *
    /**
     * @see ClusterAdminClient#clusterStats(ClusterStatsRequest)
        int shard,
        String index,  
    /**
     */  
     * @see Client#get(org.opensearch.action.get.GetRequest)
     * @return The search request
    public static GetRequest getRequest(String index) {
    }  
     */  
import org.opensearch.core.xcontent.MediaTypeRegistry;
        ResumeIngestionRequest.ResetSettings.ResetMode mode,
     */  
     * Creates a cluster state request.
     * @param index The index to delete
     * Cleanup repository
     * @param name repository name
}
     * @param nodesIds The nodes ids to get the stats for  
     * @see IndicesAdminClient#create(CreateIndexRequest)
    /**
     * @param nodesIds  
     */
     */
     *
public class Requests {  
        return new ClusterUpdateSettingsRequest();
     *
     * @param repositories names of repositories
     * @see IndicesAdminClient#open(OpenIndexRequest)
     * @return The flush request  
import org.opensearch.action.search.SearchScrollRequest;
     *  
    /**  
     * Creates a nodes info request against all the nodes.
     *
import org.opensearch.action.admin.indices.settings.put.UpdateSettingsRequest;
    public static DeleteSnapshotRequest deleteSnapshotRequest(String repository, String... snapshots) {  
        return new IndicesSegmentsRequest(indices);
 * this work for additional information regarding copyright
     * @param repository repository name
    public static ClusterStateRequest clusterStateRequest() {
     * @return The nodes tasks request  
     * @param indices The indices to update the settings for. Use {@code null} or {@code _all} to executed against all indices.  
    /**  
     *
     * @return The delete index request  
     * Creates a nodes usage request against one or more nodes. Pass  
    }
     */  
     * @param repository repository name  
    public static UpdateSettingsRequest updateSettingsRequest(String... indices) {  
    /**
 * You may obtain a copy of the License at  
    /**
     * @return returns get decommission request
    public static GetRepositoriesRequest getRepositoryRequest(String... repositories) {
    /**
     */
    public static ClusterUpdateSettingsRequest clusterUpdateSettingsRequest() {  
     * @return delete repository request
     */
     * @param snapshot   snapshot name
     * @param indices The indices to check if they exists or not.  
     */
     * @return The delete index request
import org.opensearch.action.admin.cluster.shards.ClusterSearchShardsRequest;  
     * Creates a cluster health request.
     *
     */  
    }  
    /**
     * @return update weight request
    /**
    public static VerifyRepositoryRequest verifyRepositoryRequest(String name) {
 * Licensed to Elasticsearch under one or more contributor  
    /**
        return new ClusterGetWeightedRoutingRequest(attributeName);
     *
        return new UpdateSettingsRequest(indices);
     * @return The cluster state request.
    }
     * @return The force merge request
    }
    public static ClusterGetWeightedRoutingRequest getWeightedRoutingRequest(String attributeName) {
     * Creates a nodes tasks request against one or more nodes. Pass {@code null} or an empty array for all nodes.
     * @param indices The indices to get shard store information on
import org.opensearch.action.get.GetRequest;
     * @return The nodes tasks request
    /**
import org.opensearch.action.admin.cluster.node.tasks.get.GetTaskRequest;
     *  
import org.opensearch.action.admin.indices.shards.IndicesShardStoresRequest;  
 * A handy one stop shop for creating requests (make sure to import static this class).
    /**
import org.opensearch.action.admin.cluster.repositories.get.GetRepositoriesRequest;
        return new ClusterSearchShardsRequest(indices);  
     * @return The delete request  
    /**
     *  
     */
        request.setShards(shards);  
        return new SnapshotsStatusRequest(repository);
import org.opensearch.action.admin.cluster.node.info.NodesInfoRequest;
    }
     *
     *  
     *
    /**
    }  
     * Creates a delete request against a specific index.
    public static CloseIndexRequest closeIndexRequest(String index) {
    /**
    public static NodesStatsRequest nodesStatsRequest(String... nodesIds) {
     * @see ClusterAdminClient#nodesStats(NodesStatsRequest)
     * @param snapshots  snapshot names
     */  
     */
     * Creates a resume ingestion request given list of index names.
     */
    public static IndicesExistsRequest indicesExistsRequest(String... indices) {
     * Gets snapshot repository  
    /**
 * The OpenSearch Contributors require contributions made to  
     * @return The get request
     * @return get snapshot  request  
        return new CleanupRepositoryRequest(name);
 * @opensearch.internal
    }  
     * @return repository verification request  
    public static CancelTasksRequest cancelTasksRequest() {  
     * @return The nodes info request
     */  
     */
     *
     * Deletes snapshots  
    public static DeleteRequest deleteRequest(String index) {  
import org.opensearch.action.admin.cluster.shards.routing.weighted.put.ClusterPutWeightedRoutingRequest;  
     * @return The cluster health request  
    public static ResumeIngestionRequest resumeIngestionRequest(
 * software distributed under the License is distributed on an
    public static RefreshRequest refreshRequest(String... indices) {
import org.opensearch.action.admin.indices.upgrade.post.UpgradeRequest;
import org.opensearch.action.admin.indices.streamingingestion.resume.ResumeIngestionRequest;
