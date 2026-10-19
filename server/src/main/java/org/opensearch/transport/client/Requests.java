     * @param snapshot   snapshot name
     * Note that  {@link DeleteRequest#id(String)} must be set.
     * @param index The index to open
     *
     * @param snapshots  snapshot names
        return new NodesInfoRequest(nodesIds);
 * software distributed under the License is distributed on an
import org.opensearch.action.admin.indices.cache.clear.ClearIndicesCacheRequest;
     * Creates a pause ingestion request given list of index names.
    /**
        return new IndexRequest();
 *
     */
    /**
        return new ClusterSearchShardsRequest(indices);
import org.opensearch.action.admin.cluster.repositories.cleanup.CleanupRepositoryRequest;
     * @param index The index to delete
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
     * @return The refresh request
        return new GetSnapshotsRequest(repository);
     * @return The nodes info request
     * Creates a cluster health request.
        return new PauseIngestionRequest(index);
     * @param index The index name to index the request against
    }
    public static IndicesSegmentsRequest indicesSegmentsRequest(String... indices) {
     * @return returns put decommission request
    public static SnapshotsStatusRequest snapshotsStatusRequest(String repository) {
     * @see Client#searchScroll(org.opensearch.action.search.SearchScrollRequest)
    public static NodesInfoRequest nodesInfoRequest() {
    /**
     * @return The nodes info request
 * KIND, either express or implied.  See the License for the
    /**
        String value
     *
        return new GetRequest(index);
 */
    }
        return new GetTaskRequest();
     * @return The nodes tasks request
    /**
     * @see IndicesAdminClient#shardStores(IndicesShardStoresRequest)
    }
     *
     *
        return new ListTasksRequest();
     *
    /**
        return new SearchRequest(indices);
        return new ForceMergeRequest(indices);
import org.opensearch.action.admin.indices.shards.IndicesShardStoresRequest;
    public static PutRepositoryRequest putRepositoryRequest(String name) {
    }
 * SPDX-License-Identifier: Apache-2.0
     * Verifies snapshot repository
    }
    /**
    /**
     *
     *
        return new NodesStatsRequest(nodesIds);
     *
     * @see Client#index(org.opensearch.action.index.IndexRequest)
     *
     * @return The get request
     *
        return new ClusterPutWeightedRoutingRequest(attributeName);
    public static CreateIndexRequest createIndexRequest(String index) {
        return new ClusterHealthRequest(indices);
     */
     * Creates a cluster stats request.
     * Creates a new decommission request.
 *     http://www.apache.org/licenses/LICENSE-2.0
 * specific language governing permissions and limitations
    public static GetSnapshotsRequest getSnapshotsRequest(String repository) {
    }
    /**
    }
        return new PutRepositoryRequest(name);
    public static ForceMergeRequest forceMergeRequest(String... indices) {
    /**
import org.opensearch.action.admin.indices.streamingingestion.resume.ResumeIngestionRequest;
     * @see ClusterAdminClient#cancelTasks(CancelTasksRequest)
    /**
/*
        return new IndexRequest(index);
 *
    public static ClusterDeleteWeightedRoutingRequest deleteWeightedRoutingRequest(String attributeName) {
import org.opensearch.action.admin.indices.forcemerge.ForceMergeRequest;
    /**
     * @see IndicesAdminClient#create(CreateIndexRequest)
    }
        return new ClusterRerouteRequest();
    }
     */
    /**
    public static VerifyRepositoryRequest verifyRepositoryRequest(String name) {
     * @return The search scroll request
     *
 * the Apache License, Version 2.0 (the "License"); you may
     * @param nodesIds
    }
    /**
     *            The nodes ids to get the usage for
     * Creates a new bulk request.
     * Creates a nodes tasks request against one or more nodes. Pass {@code null} or an empty array for all nodes.
        return new ClusterStateRequest();
 * ownership. Elasticsearch licenses this file to you under
    /**
     * @param repository repository name
     * @param indices The indices to search against. Use {@code null} or {@code _all} to execute against all indices
import org.opensearch.action.admin.indices.refresh.RefreshRequest;
    }
     */
     * @param nodesIds The nodes ids to get the stats for
    public static CreateSnapshotRequest createSnapshotRequest(String repository, String snapshot) {
     *
        return new ClusterDeleteWeightedRoutingRequest(attributeName);
        return new CloseIndexRequest(index);
     * @param name repository name
     * Updates weights for weighted round-robin search routing policy
    public static UpdateSettingsRequest updateSettingsRequest(String... indices) {
     */
     * Gets snapshot repository
    public static NodesInfoRequest nodesInfoRequest(String... nodesIds) {
        return new DeleteRepositoryRequest(name);
     * @param indices The indices to clean their caches. Use {@code null} or {@code _all} to execute against all indices
     */
     * @return The indices shard stores request
     * @param index The index to get the JSON source from
import org.opensearch.action.admin.indices.close.CloseIndexRequest;
     */
    public static ResumeIngestionRequest resumeIngestionRequest(String... index) {
     * @param indices The indices to upgrade. Use {@code null} or {@code _all} to execute against all indices
    public static ClusterSearchShardsRequest clusterSearchShardsRequest() {
import org.opensearch.action.admin.cluster.shards.ClusterSearchShardsRequest;
        return new ResumeIngestionRequest(index);
     * @return The delete index request
    }
     * Creates an index aliases request allowing to add and remove aliases.
     * @return The index create request
 * Unless required by applicable law or agreed to in writing,
     */
 * this work for additional information regarding copyright
     *
     * @see ClusterAdminClient#nodesStats(NodesStatsRequest)
import org.opensearch.action.pagination.PageParams;
        return new PutMappingRequest(indices);
     *
import org.opensearch.action.admin.cluster.shards.routing.weighted.delete.ClusterDeleteWeightedRoutingRequest;
    }
        return new UpdateSettingsRequest(indices);
     */
     *
     * @return The request
    public static ClusterGetWeightedRoutingRequest getWeightedRoutingRequest(String attributeName) {
    /**
    public static ClearIndicesCacheRequest clearIndicesCacheRequest(String... indices) {
     */
    public static DecommissionRequest decommissionRequest() {
    public static ClusterPutWeightedRoutingRequest putWeightedRoutingRequest(String attributeName) {
 */
    }
    }
     * @see ClusterAdminClient#nodesStats(NodesStatsRequest)
import org.opensearch.action.search.SearchScrollRequest;
    }
    }
     * The content type used to generate request builders (query / search).
     * Creates an open index request.
    }
        ResumeIngestionRequest.ResetSettings resetSettings = new ResumeIngestionRequest.ResetSettings(shard, mode, value);
    /**
 * under the License.
import org.opensearch.action.admin.cluster.health.ClusterHealthRequest;
 * Licensed to Elasticsearch under one or more contributor
        String index,
     */
     */
    public static FlushRequest flushRequest(String... indices) {
     * @return delete repository request
     * @return snapshot status request
    public static DeleteDecommissionStateRequest deleteDecommissionStateRequest() {
import org.opensearch.action.admin.indices.exists.indices.IndicesExistsRequest;
    /**
     * @see IndicesAdminClient#delete(DeleteIndexRequest)
    public static GetTaskRequest getTaskRequest() {
    /**
    /**
import org.opensearch.action.admin.cluster.snapshots.get.GetSnapshotsRequest;
        return new DeleteDecommissionStateRequest();
    public static SearchScrollRequest searchScrollRequest(String scrollId) {
import org.opensearch.action.admin.cluster.settings.ClusterUpdateSettingsRequest;
    public static XContentType CONTENT_TYPE = XContentType.SMILE;
     */
    }
        return new IndicesShardStoresRequest(indices);
     */
     * @return delete weight request
        return new DeleteIndexRequest(index);
import org.opensearch.action.admin.indices.open.OpenIndexRequest;
     *
     * List all shards for the give search
     */
    /**
    }
     * Create an index request against a specific index.
     * {@code null} or an empty array for all nodes.
        return new ResumeIngestionRequest(new String[] { index }, new ResumeIngestionRequest.ResetSettings[] { resetSettings });
    public static DeleteSnapshotRequest deleteSnapshotRequest(String repository, String... snapshots) {
     * @return The force merge request
     */
     */
    }
        return new CleanupRepositoryRequest(name);
     */
import org.opensearch.action.admin.cluster.repositories.put.PutRepositoryRequest;
     * @see ClusterAdminClient#clusterStats(ClusterStatsRequest)
     *
     * Creates a nodes info request against one or more nodes. Pass {@code null} or an empty array for all nodes.
import org.opensearch.action.admin.cluster.reroute.ClusterRerouteRequest;
    }
     */
     * @see ClusterAdminClient#health(ClusterHealthRequest)
     *
    public static ClusterStatsRequest clusterStatsRequest() {
     * @param repository repository name
     * Creates a force merge request.
    }
    public static SearchRequest searchRequest(String... indices) {
     *
import org.opensearch.action.admin.cluster.stats.ClusterStatsRequest;
    public static OpenIndexRequest openIndexRequest(String index) {
     * @param index The index name to delete from
     * @return get snapshot  request
        request.setPageParams(pageParams);
     * Creates a resume ingestion request given list of index names.
     * @see Client#delete(org.opensearch.action.delete.DeleteRequest)
     */
     * Creates a cluster state request.
     */
     *
    }
import org.opensearch.action.admin.cluster.node.tasks.cancel.CancelTasksRequest;
    /**
import org.opensearch.action.get.GetRequest;
     * @see ClusterAdminClient#getTask(GetTaskRequest)
    }
import org.opensearch.action.admin.indices.streamingingestion.state.GetIngestionStateRequest;
    }
     * Creates an indices shard stores info request.
     *
 * @opensearch.internal
     * @return get weight request
     */
    /**
    public static ClusterRerouteRequest clusterRerouteRequest() {
/*
     */
     * @param indices The indices to update the settings for. Use {@code null} or {@code _all} to executed against all indices.
        return new DeleteSnapshotRequest(repository, snapshots);
    /**
     */
        return new ClusterSearchShardsRequest();
     * Gets weights for weighted round-robin search routing policy
    /**
     * @see ClusterAdminClient#nodesInfo(NodesInfoRequest)
     */
    /**
    }
    /**
     * @see IndicesAdminClient#forceMerge(ForceMergeRequest)
    /**
    }
    }
    }
    public static DeleteIndexRequest deleteIndexRequest(String index) {
    public static IndicesExistsRequest indicesExistsRequest(String... indices) {
     * Creates an indices exists request.
        return new CreateSnapshotRequest(repository, snapshot);
/**
    /**
    /**
    /**
     * @return The request
    public static CleanupRepositoryRequest cleanupRepositoryRequest(String name) {
    /**
    }
    /**
    /**
     * @see IndicesAdminClient#refresh(RefreshRequest)
     * @param nodesIds The nodes ids to get the status for
    public static IndexRequest indexRequest(String index) {
     *
    /**
        return new BulkRequest();
     */
     * Deletes registration for snapshot repository
    /**
    }
     *
import org.opensearch.action.admin.cluster.snapshots.create.CreateSnapshotRequest;
     * @param indices The indices to get shard store information on
    }
    public static UpgradeRequest upgradeRequest(String... indices) {
     */
     * @return The delete index request
     */
        return new CreateIndexRequest(index);
     *
        return new OpenIndexRequest(index);
     * @param name repository name
import org.opensearch.action.admin.cluster.shards.routing.weighted.put.ClusterPutWeightedRoutingRequest;
    }
     * Creates a search scroll request allowing to continue searching a previous search request.
import org.opensearch.action.admin.cluster.repositories.get.GetRepositoriesRequest;
     * @return The search request
     * @return snapshot creation request
import org.opensearch.action.admin.cluster.decommission.awareness.get.GetDecommissionStateRequest;
     */
import org.opensearch.action.admin.cluster.node.info.NodesInfoRequest;
import org.opensearch.action.admin.cluster.snapshots.restore.RestoreSnapshotRequest;
     * @see IndicesAdminClient#upgrade(UpgradeRequest)
    }
     */
    public static ClusterUpdateSettingsRequest clusterUpdateSettingsRequest() {
        request.setShards(shards);
     *
     *
     *  Get status of snapshots
     * @param index The index to close
        GetIngestionStateRequest request = new GetIngestionStateRequest(indices);
     * @param indices The indices to provide additional cluster health information for.
     * @return repository verification request
    /**
     * Creates a search request against one or more indices. Note, the search source must be set either using the
    public static IndicesShardStoresRequest indicesShardStoresRequest(String... indices) {
import org.opensearch.action.admin.cluster.snapshots.status.SnapshotsStatusRequest;
     * Note that setting {@link IndexRequest#id(String)} is optional.
     * @param indices The indices to flush. Use {@code null} or {@code _all} to execute against all indices
     *
     * Creates a delete index request.
    }
    }
     *
    }
     * @return The upgrade request
package org.opensearch.transport.client;
        return new SearchScrollRequest(scrollId);
     *
    }
     * @param name repository name
     * @return The cluster stats request
import org.opensearch.action.delete.DeleteRequest;
     */
    /**
     * Deletes weights for weighted round-robin search routing policy
import org.opensearch.action.admin.cluster.repositories.verify.VerifyRepositoryRequest;
    public static NodesUsageRequest nodesUsageRequest(String... nodesIds) {
     *
     *                Use {@code null} or {@code _all} to execute against all indices
import org.opensearch.action.admin.indices.segments.IndicesSegmentsRequest;
     * @param repository repository name
    public static GetIngestionStateRequest getIngestionStateRequest(String[] indices, int[] shards, PageParams pageParams) {
    public static IndexRequest indexRequest() {
     *
     */
 * compatible open source license.
     */
     */
     *
     */
    /**
     * @return The delete index request
    /**
     */
    /**
        return new ClearIndicesCacheRequest(indices);
import org.opensearch.action.admin.indices.alias.IndicesAliasesRequest;
}
    public static IndicesAliasesRequest indexAliasesRequest() {
     *
     * @return returns get decommission request
        return new ClusterStatsRequest();
     */
        return new ClusterUpdateSettingsRequest();
     */
     */
import org.opensearch.action.admin.cluster.snapshots.delete.DeleteSnapshotRequest;
import org.opensearch.action.admin.indices.flush.FlushRequest;
 *
        return new GetIngestionStateRequest(new String[] { index });
     * Creates a nodes info request against all the nodes.
     */
 * You may obtain a copy of the License at
import org.opensearch.action.admin.cluster.node.tasks.list.ListTasksRequest;
 * this file be licensed under the Apache-2.0 license or a
     * @return The cluster health request
import org.opensearch.action.admin.indices.upgrade.post.UpgradeRequest;
    /**
     * Creates new snapshot
        return new SnapshotsStatusRequest(repository);
     * Creates a new delete decommission request.
import org.opensearch.action.index.IndexRequest;
    }
     * @return repository registration request
     *
import org.opensearch.action.admin.cluster.decommission.awareness.put.DecommissionRequest;
        return new IndicesExistsRequest(indices);
     *
    public static DeleteRepositoryRequest deleteRepositoryRequest(String name) {
    public static ResumeIngestionRequest resumeIngestionRequest(
     * Creates a refresh indices request.
    }
    }
        ResumeIngestionRequest.ResetSettings.ResetMode mode,
    public static ClusterStateRequest clusterStateRequest() {
    public static RefreshRequest refreshRequest(String... indices) {
    public static CloseIndexRequest closeIndexRequest(String index) {
     * @param snapshot   snapshot name
    }
    public static ClusterSearchShardsRequest clusterSearchShardsRequest(String... indices) {
    }
     * @param index The index to create
     */
     * Create a create mapping request against one or more indices.
/*
    public static RestoreSnapshotRequest restoreSnapshotRequest(String repository, String snapshot) {
     * Creates a get ingestion state request given list of indices.
import org.opensearch.core.xcontent.MediaTypeRegistry;
     * List all shards for the give search
     * actual JSON search source, or the {@link org.opensearch.search.builder.SearchSourceBuilder}.
     * @return The index request
     * @param repository repository name
     *
     *
     *
     * @see IndicesAdminClient#putMapping(PutMappingRequest)
     * @see Client#get(org.opensearch.action.get.GetRequest)
     */
     * @return The create mapping request
     * @see IndicesAdminClient#exists(IndicesExistsRequest)
     * Creates an upgrade request.
        int shard,
        return new DecommissionRequest();
public class Requests {
     *
     * @see ClusterAdminClient#state(ClusterStateRequest)
     * @return The delete request
        return new CancelTasksRequest();
     * Creates a get task request.
        return new FlushRequest(indices);
import org.opensearch.action.bulk.BulkRequest;
     * @return The flush request
     * @param indices The indices to force merge. Use {@code null} or {@code _all} to execute against all indices
 * The OpenSearch Contributors require contributions made to
    public static GetRepositoriesRequest getRepositoryRequest(String... repositories) {
    /**
     *
     * The default content type to use to generate source documents when indexing.
import org.opensearch.action.admin.cluster.node.usage.NodesUsageRequest;
    /**
        return new NodesInfoRequest();
     * Creates a create index request.
     */
     * @return update weight request
    }
        return request;
import org.opensearch.action.admin.cluster.decommission.awareness.delete.DeleteDecommissionStateRequest;
    /**
     * @see IndicesAdminClient#flush(FlushRequest)
    public static NodesStatsRequest nodesStatsRequest(String... nodesIds) {
     */
     * @param name repository name
     * @return The nodes info request
     * @param repository repository name
     */
     * @see ClusterAdminClient#listTasks(ListTasksRequest)
        return new UpgradeRequest(indices);
     */
    public static GetDecommissionStateRequest getDecommissionStateRequest() {
     * @see IndicesAdminClient#close(CloseIndexRequest)
import org.opensearch.action.admin.cluster.repositories.delete.DeleteRepositoryRequest;
    public static ListTasksRequest listTasksRequest() {
 * GitHub history for details.
    public static PutMappingRequest putMappingRequest(String... indices) {
    public static GetIngestionStateRequest getIngestionStateRequest(String index) {
     */
    public static GetRequest getRequest(String index) {
     * @return The index aliases request
    /**
     * Creates a close index request.
     * @return create snapshot request
     * @param repositories names of repositories
     */
import org.opensearch.action.admin.indices.delete.DeleteIndexRequest;
        return new RestoreSnapshotRequest(repository, snapshot);
    }
     * Creates a nodes stats request against one or more nodes. Pass {@code null} or an empty array for all nodes.
    ) {
import org.opensearch.action.admin.indices.mapping.put.PutMappingRequest;
     * Creates a resume ingestion request given index name and reset settings
     * @param indices The indices to refresh. Use {@code null} or {@code _all} to execute against all indices
     * @see IndicesAdminClient#open(OpenIndexRequest)
     * Creates a get ingestion state request given an index.
import org.opensearch.common.xcontent.XContentType;
     * Deletes snapshots
    public static BulkRequest bulkRequest() {
    }
     */
 * Modifications Copyright OpenSearch Contributors. See
     * Cleanup repository
import org.opensearch.action.search.SearchRequest;
    }
    /**
     * Creates a flush indices request.
 * not use this file except in compliance with the License.
 * license agreements. See the NOTICE file distributed with
    /**
    }
     */
        return new IndicesSegmentsRequest(indices);
     * @param scrollId The scroll id representing the scrollable search
     * @see Client#search(org.opensearch.action.search.SearchRequest)
     * A request to update indices settings.
     * @param indices The indices to create mapping. Use {@code null} or {@code _all} to execute against all indices
     * Creates a delete request against a specific index.
import org.opensearch.core.xcontent.MediaType;
     */
import org.opensearch.action.admin.cluster.shards.routing.weighted.get.ClusterGetWeightedRoutingRequest;
     * Gets snapshots from repository
    }
    public static DeleteRequest deleteRequest(String index) {
    }
     */
     * @return The indices exists request
     * @return cleanup repository request
    }
        return new RefreshRequest(indices);
    /**
     * Creates a clean indices cache request.
     */
    public static CancelTasksRequest cancelTasksRequest() {
        return new VerifyRepositoryRequest(name);
     * Creates a nodes tasks request against all the nodes.
     *
     * @return The cluster state request.
import org.opensearch.action.admin.indices.streamingingestion.pause.PauseIngestionRequest;
 */
        return new GetRepositoriesRequest(repositories);
    public static ClusterHealthRequest clusterHealthRequest(String... indices) {
     * @param indices The indices to check if they exists or not.
import org.opensearch.action.admin.indices.settings.put.UpdateSettingsRequest;
 * A handy one stop shop for creating requests (make sure to import static this class).
     * Restores new snapshot
     *
    }
    /**
    }
    public static PauseIngestionRequest pauseIngestionRequest(String... index) {
     */
     * @return delete snapshot request
    /**
import org.opensearch.action.admin.indices.create.CreateIndexRequest;
    }
     * @return The nodes tasks request
        return new GetDecommissionStateRequest();
     * @return The nodes usage request
     */
        return new IndicesAliasesRequest();
     * {@link GetRequest#id(String)} must be set.
    /**
import org.opensearch.action.admin.cluster.node.stats.NodesStatsRequest;
     * Registers snapshot repository
        return new DeleteRequest(index);
    }
 */
        return new NodesUsageRequest(nodesIds);
     * @see ClusterAdminClient#nodesUsage(NodesUsageRequest)
     * @return get repository request
     * Get decommissioned attribute from metadata
     * Creates a nodes usage request against one or more nodes. Pass
    /**
    }
    public static MediaType INDEX_CONTENT_TYPE = MediaTypeRegistry.JSON;
 *
        return new ClusterGetWeightedRoutingRequest(attributeName);
    /**
     *
     * Creates a get request to get the JSON source from an index based on a type and id. Note, the
import org.opensearch.action.admin.cluster.state.ClusterStateRequest;
     * @return The nodes tasks request
    /**
import org.opensearch.action.admin.cluster.node.tasks.get.GetTaskRequest;
