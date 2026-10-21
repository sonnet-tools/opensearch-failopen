        @Override
        public void deleteDataStream(DeleteDataStreamAction.Request request, ActionListener<AcknowledgedResponse> listener) {
        public void importDanglingIndex(ImportDanglingIndexRequest request, ActionListener<AcknowledgedResponse> listener) {
        public ActionFuture<IndicesStatsResponse> stats(final IndicesStatsRequest request) {
        @Override
        public FlushRequestBuilder prepareFlush(String... indices) {
    public void multiTermVectors(final MultiTermVectorsRequest request, final ActionListener<MultiTermVectorsResponse> listener) {
            final ActionListener<ClusterUpdateSettingsResponse> listener
        }
            execute(SimulatePipelineAction.INSTANCE, request, listener);
import org.opensearch.action.admin.cluster.wlm.WlmStatsRequest;
            execute(IndicesSegmentsAction.INSTANCE, request, listener);
        @Override
import org.opensearch.action.search.MultiSearchAction;
import org.opensearch.action.get.GetRequest;
        }
    public final Settings settings() {
        @Override
import org.opensearch.action.get.MultiGetResponse;
            return new GetIndexRequestBuilder(this, GetIndexAction.INSTANCE);
import org.opensearch.action.admin.cluster.tasks.PendingClusterTasksRequestBuilder;
        }
        }
import org.opensearch.action.admin.cluster.shards.routing.weighted.get.ClusterGetWeightedRoutingResponse;
import org.opensearch.action.admin.indices.alias.IndicesAliasesAction;
        @Override
        }
        @Override
import org.opensearch.action.search.SearchResponse;
    }
import org.opensearch.action.admin.cluster.snapshots.delete.DeleteSnapshotRequest;
        public CreateSnapshotRequestBuilder prepareCreateSnapshot(String repository, String name) {
    public void termVectors(final TermVectorsRequest request, final ActionListener<TermVectorsResponse> listener) {
            execute(DeleteIndexTemplateAction.INSTANCE, request, listener);
import org.opensearch.action.search.GetAllPitNodesResponse;
    public void multiSearch(MultiSearchRequest request, ActionListener<MultiSearchResponse> listener) {
            return new NodesInfoRequestBuilder(this, NodesInfoAction.INSTANCE).setNodesIds(nodesIds);
import org.opensearch.action.search.GetAllPitsAction;
import org.opensearch.action.admin.indices.exists.indices.IndicesExistsAction;
        return new SearchRequestBuilder(this, StreamSearchAction.INSTANCE).setIndices(indices);
        }
        private final OpenSearchClient client;
            execute(GetTaskAction.INSTANCE, request, listener);
    }
 *
        return execute(UpdateAction.INSTANCE, request);
    @Override
        public ActionFuture<ClusterRerouteResponse> reroute(final ClusterRerouteRequest request) {
        public ScaleIndexRequestBuilder prepareScaleSearchOnly(String index, boolean searchOnly) {
import org.opensearch.action.admin.cluster.shards.routing.weighted.get.ClusterGetWeightedRoutingAction;
    }
import org.opensearch.action.admin.indices.exists.indices.IndicesExistsRequest;
            return new VerifyRepositoryRequestBuilder(this, VerifyRepositoryAction.INSTANCE, name);
import org.opensearch.common.settings.Settings;
        }
import org.opensearch.action.admin.cluster.repositories.get.GetRepositoriesAction;
        @Override
import org.opensearch.action.fieldcaps.FieldCapabilitiesRequestBuilder;
     * This is the single execution point of *all* clients.
            return new ClusterSearchShardsRequestBuilder(this, ClusterSearchShardsAction.INSTANCE).setIndices(indices);
        }
 * under the License.
        public GetPipelineRequestBuilder prepareGetPipeline(String... ids) {
    public SearchScrollRequestBuilder prepareSearchScroll(String scrollId) {
        }
            return new PutRepositoryRequestBuilder(this, PutRepositoryAction.INSTANCE, name);
            Request request
            return new UpdateSettingsRequestBuilder(this, UpdateSettingsAction.INSTANCE).setIndices(indices);
        PlainActionFuture<Response> actionFuture = PlainActionFuture.newFuture();
        @Override
import org.opensearch.action.admin.cluster.node.hotthreads.NodesHotThreadsRequestBuilder;
        public PutIndexTemplateRequestBuilder preparePutTemplate(String name) {
import org.opensearch.action.admin.indices.alias.IndicesAliasesRequest;
    }
import org.opensearch.action.admin.indices.template.delete.DeleteIndexTemplateRequestBuilder;
        execute(IndexAction.INSTANCE, request, listener);
        }
import org.opensearch.action.admin.indices.segments.IndicesSegmentsRequest;
import org.opensearch.action.admin.indices.create.CreateIndexResponse;
        }
        public CancelTasksRequestBuilder prepareCancelTasks(String... nodesIds) {
            return clusterAdmin;
        }
import org.opensearch.action.admin.cluster.node.reload.NodesReloadSecureSettingsRequestBuilder;
        public ActionFuture<AcknowledgedResponse> putTemplate(final PutIndexTemplateRequest request) {
}
            return execute(NodesUsageAction.INSTANCE, request);
        @Override
        public void putWeightedRouting(
            }
        return execute(IndexAction.INSTANCE, request);
import org.opensearch.action.index.IndexRequestBuilder;
            return execute(CreateDataStreamAction.INSTANCE, request);
            execute(ClusterUpdateSettingsAction.INSTANCE, request, listener);
        @Override
        }
        @Override
        }
        }
        }
            return execute(PutPipelineAction.INSTANCE, request);
        }
 * @opensearch.internal
        }
        @Override
            return execute(UpdateSettingsAction.INSTANCE, request);
        }
import org.opensearch.action.admin.cluster.shards.ClusterSearchShardsAction;
    @Override
            final RemoteStoreMetadataRequest request,
        @Override
    }
        @Override
        @Override
        public void cancelTasks(CancelTasksRequest request, ActionListener<CancelTasksResponse> listener) {
            return execute(OpenIndexAction.INSTANCE, request);
        @Override
import org.opensearch.action.admin.indices.template.delete.DeleteIndexTemplateAction;
        public ActionFuture<CancelTasksResponse> cancelTasks(CancelTasksRequest request) {
            return prepareDeleteStoredScript().setId(id);
        public ActionFuture<ListTasksResponse> listTasks(final ListTasksRequest request) {
import org.opensearch.action.admin.cluster.stats.ClusterStatsAction;
            return execute(DeleteDecommissionStateAction.INSTANCE, request);
        return new MultiSearchRequestBuilder(this, MultiSearchAction.INSTANCE);
        @Override
        public ClusterHealthRequestBuilder prepareHealth(String... indices) {
        public ActionFuture<IndicesSegmentResponse> segments(final IndicesSegmentsRequest request) {
        public ActionFuture<PendingClusterTasksResponse> pendingClusterTasks(PendingClusterTasksRequest request) {
    public IndexRequestBuilder prepareIndex() {
    }
        public DeletePipelineRequestBuilder prepareDeletePipeline(String id) {
        }
        @Override
import org.opensearch.action.admin.cluster.node.reload.NodesReloadSecureSettingsAction;
        public NodesInfoRequestBuilder prepareNodesInfo(String... nodesIds) {
        }
        public void exists(final IndicesExistsRequest request, final ActionListener<IndicesExistsResponse> listener) {
import org.opensearch.action.ingest.GetPipelineRequest;
        }
        @Override
        public void getIngestionState(final GetIngestionStateRequest request, final ActionListener<GetIngestionStateResponse> listener) {
        @Override
    @Override
            return execute(DeleteRepositoryAction.INSTANCE, request);
        public void addBlock(AddIndexBlockRequest request, ActionListener<AddIndexBlockResponse> listener) {
        public SegmentReplicationStatsRequestBuilder prepareSegmentReplicationStats(String... indices) {
    }
        return execute(FieldCapabilitiesAction.INSTANCE, request);
import org.opensearch.action.update.UpdateResponse;
        private final ClusterAdmin clusterAdmin;
import org.opensearch.action.admin.cluster.snapshots.status.SnapshotsStatusRequestBuilder;
        public ActionFuture<AcknowledgedResponse> deleteTemplate(final DeleteIndexTemplateRequest request) {
import org.opensearch.threadpool.ThreadPool;
        ) {
    public DeleteRequestBuilder prepareDelete() {
import org.opensearch.action.admin.indices.mapping.get.GetMappingsRequestBuilder;
import org.opensearch.action.admin.cluster.allocation.ClusterAllocationExplainAction;
            return new NodesReloadSecureSettingsRequestBuilder(this, NodesReloadSecureSettingsAction.INSTANCE);
import org.opensearch.action.admin.cluster.remotestore.restore.RestoreRemoteStoreRequest;
        return new FieldCapabilitiesRequestBuilder(this, FieldCapabilitiesAction.INSTANCE, indices);
            return execute(GetStoredScriptAction.INSTANCE, request);
        }
    }
        @Override
        @Override
        }
        public void deletePipeline(DeletePipelineRequest request, ActionListener<AcknowledgedResponse> listener) {
        public AnalyzeRequestBuilder prepareAnalyze(String text) {
import org.opensearch.action.admin.indices.dangling.list.ListDanglingIndicesRequest;
        public ActionFuture<AcknowledgedResponse> createDataStream(CreateDataStreamAction.Request request) {
        execute(TermVectorsAction.INSTANCE, request, listener);
    @Override
        @Override
            return execute(DeleteIndexTemplateAction.INSTANCE, request);
import org.opensearch.action.index.IndexResponse;
            execute(ClusterHealthAction.INSTANCE, request, listener);
        return prepareDelete().setIndex(index).setId(id);
        public GetSnapshotsRequestBuilder prepareGetSnapshots(String repository) {
        @Override
import org.opensearch.core.xcontent.MediaType;
import org.opensearch.action.admin.cluster.node.stats.NodesStatsResponse;
        public void putTemplate(final PutIndexTemplateRequest request, final ActionListener<AcknowledgedResponse> listener) {
import org.opensearch.action.admin.indices.delete.DeleteIndexRequest;
        @Override
        @Override
    public SearchRequestBuilder prepareStreamSearch(String... indices) {
    @Override
            execute(IndicesShardStoresAction.INSTANCE, request, listener);
        @Override
        @Override
    @Override
            ActionListener<Response> listener
        }
    @Override
        @Override
            }
import org.opensearch.action.admin.indices.flush.FlushResponse;
            return new ClusterUpdateSettingsRequestBuilder(this, ClusterUpdateSettingsAction.INSTANCE);
        @Override
import org.opensearch.action.admin.cluster.node.info.NodesInfoRequest;
import org.opensearch.action.admin.indices.shards.IndicesShardStoresAction;
import org.opensearch.action.admin.cluster.repositories.delete.DeleteRepositoryRequestBuilder;
        }
import org.opensearch.action.admin.cluster.allocation.ClusterAllocationExplainResponse;
    public ActionFuture<MultiSearchResponse> multiSearch(MultiSearchRequest request) {
    }
        public ClusterAllocationExplainRequestBuilder prepareAllocationExplain() {
        @Override
        public ActionFuture<RecoveryResponse> recoveries(final RecoveryRequest request) {
            execute(CloseIndexAction.INSTANCE, request, listener);
            execute(NodesInfoAction.INSTANCE, request, listener);
        }
        return execute(MultiGetAction.INSTANCE, request);
        @Override
import org.opensearch.action.admin.indices.mapping.get.GetFieldMappingsRequest;
import org.opensearch.action.admin.cluster.node.tasks.cancel.CancelTasksAction;
        }
import org.opensearch.action.update.UpdateAction;
        }
    @Override
        }
    @Override
        }
            return new CreateIndexRequestBuilder(this, CreateIndexAction.INSTANCE, index);
    public void pitSegments(final PitSegmentsRequest request, final ActionListener<IndicesSegmentResponse> listener) {
import org.opensearch.action.admin.indices.datastream.GetDataStreamAction;
 * not use this file except in compliance with the License.
        @Override
import org.opensearch.action.admin.indices.replication.SegmentReplicationStatsResponse;
        public void updateSettings(
            return indicesAdmin;
        public void refresh(final RefreshRequest request, final ActionListener<RefreshResponse> listener) {
        @Override
        public GetAliasesRequestBuilder prepareGetAliases(String... aliases) {
import org.opensearch.action.admin.cluster.decommission.awareness.delete.DeleteDecommissionStateResponse;
import org.opensearch.action.admin.cluster.decommission.awareness.put.DecommissionRequestBuilder;
 * the Apache License, Version 2.0 (the "License"); you may
        }
    @Override
        }
import org.opensearch.action.get.MultiGetAction;
import org.opensearch.action.admin.cluster.shards.routing.weighted.delete.ClusterDeleteWeightedRoutingAction;
        }
import org.opensearch.action.search.MultiSearchRequestBuilder;
import org.opensearch.action.ingest.SimulatePipelineAction;
        }
        }
    public final <Request extends ActionRequest, Response extends ActionResponse> ActionFuture<Response> execute(
        }
        public UpgradeRequestBuilder prepareUpgrade(String... indices) {
    /**
            execute(ResumeIngestionAction.INSTANCE, request, listener);
import org.opensearch.action.admin.indices.upgrade.post.UpgradeResponse;
            execute(GetIngestionStateAction.INSTANCE, request, listener);
        @Override
        @Override
        public PutMappingRequestBuilder preparePutMapping(String... indices) {
            return new AnalyzeRequestBuilder(this, AnalyzeAction.INSTANCE, null, text);
        }
        /** Pause ingestion */
        public CloseIndexRequestBuilder prepareClose(String... indices) {
        doExecute(action, request, listener);
        @Override
        }
        }
        }
        public void putPipeline(PutPipelineRequest request, ActionListener<AcknowledgedResponse> listener) {
import org.opensearch.action.admin.indices.close.CloseIndexRequestBuilder;
            return new ClusterStatsRequestBuilder(this, ClusterStatsAction.INSTANCE);
        public void cleanupRepository(CleanupRepositoryRequest request, ActionListener<CleanupRepositoryResponse> listener) {
import org.opensearch.action.admin.cluster.storedscripts.PutStoredScriptRequestBuilder;
import org.opensearch.action.admin.cluster.decommission.awareness.put.DecommissionResponse;
            return client.threadPool();
        @Override
        @Override
        public ActionFuture<NodesStatsResponse> nodesStats(final NodesStatsRequest request) {
    }
        }
        @Override
    @Override
import org.opensearch.action.admin.cluster.allocation.ClusterAllocationExplainRequestBuilder;
        }
        @Override
        public ActionFuture<ForceMergeResponse> forceMerge(final ForceMergeRequest request) {
import org.opensearch.action.bulk.BulkRequest;
            return new ScaleIndexRequestBuilder(this, searchOnly, index);
    }
        }
        execute(GetAllPitsAction.INSTANCE, getAllPitNodesRequest, listener);
        }
        @Override
        @Override
        ) {
        public ActionFuture<GetDecommissionStateResponse> getDecommissionState(GetDecommissionStateRequest request) {
            execute(NodesHotThreadsAction.INSTANCE, request, listener);
    @Override
            return execute(ListDanglingIndicesAction.INSTANCE, request);
        }
                remoteStoreStatsRequestBuilder.setShards(shardId);
import org.opensearch.action.admin.cluster.tasks.PendingClusterTasksRequest;
    }
import org.opensearch.action.search.CreatePitAction;
        public void open(final OpenIndexRequest request, final ActionListener<OpenIndexResponse> listener) {
            execute(CloneSnapshotAction.INSTANCE, request, listener);
            return execute(GetTaskAction.INSTANCE, request);
import org.opensearch.action.ingest.SimulatePipelineRequestBuilder;
        }
        @Override
        public void allocationExplain(ClusterAllocationExplainRequest request, ActionListener<ClusterAllocationExplainResponse> listener) {
 * Modifications Copyright OpenSearch Contributors. See
    @Override
    }
import org.opensearch.action.admin.indices.recovery.RecoveryRequest;
    }
import org.opensearch.action.admin.cluster.node.usage.NodesUsageAction;
import org.opensearch.action.admin.indices.upgrade.post.UpgradeRequestBuilder;
import org.opensearch.action.admin.indices.recovery.RecoveryAction;
import org.opensearch.action.get.MultiGetRequestBuilder;
        }
        public ActionFuture<GetSettingsResponse> getSettings(GetSettingsRequest request) {
            return new GetPipelineRequestBuilder(this, GetPipelineAction.INSTANCE, ids);
import org.opensearch.action.admin.cluster.state.ClusterStateRequestBuilder;
            return execute(ClusterAllocationExplainAction.INSTANCE, request);
        @Override
        }
        @Override
        public void nodesStats(final NodesStatsRequest request, final ActionListener<NodesStatsResponse> listener) {
        }
        public void health(final ClusterHealthRequest request, final ActionListener<ClusterHealthResponse> listener) {
    public ActionFuture<IndexResponse> index(final IndexRequest request) {
    @Override
        }
        @Override
    public ActionFuture<UpdateResponse> update(final UpdateRequest request) {
        public void nodesInfo(final NodesInfoRequest request, final ActionListener<NodesInfoResponse> listener) {
        }
        }
        }
            execute(UpgradeAction.INSTANCE, request, listener);
import org.opensearch.action.admin.indices.stats.IndicesStatsRequest;
        public void putRepository(PutRepositoryRequest request, ActionListener<AcknowledgedResponse> listener) {
    public void delete(final DeleteRequest request, final ActionListener<DeleteResponse> listener) {
        public ClusterUpdateSettingsRequestBuilder prepareUpdateSettings() {
import org.opensearch.action.admin.indices.stats.IndicesStatsResponse;
            execute(PutIndexTemplateAction.INSTANCE, request, listener);
    static class Admin implements AdminClient {
import org.opensearch.action.admin.cluster.repositories.verify.VerifyRepositoryRequestBuilder;
    public ActionFuture<BulkResponse> bulk(final BulkRequest request) {
        @Override
        public ActionFuture<PauseIngestionResponse> pauseIngestion(final PauseIngestionRequest request) {
        @Override
            return new NodesHotThreadsRequestBuilder(this, NodesHotThreadsAction.INSTANCE).setNodesIds(nodesIds);
        @Override
import org.opensearch.action.search.SearchScrollRequest;
 * The OpenSearch Contributors require contributions made to
        }
        @Override
    }
            execute(RecoveryAction.INSTANCE, request, listener);
import org.opensearch.action.admin.indices.segments.PitSegmentsRequest;
        public ActionFuture<AcknowledgedResponse> cloneSnapshot(CloneSnapshotRequest request) {
        @Override
        @Override
            return new ClusterStateRequestBuilder(this, ClusterStateAction.INSTANCE);
        return prepareGet().setIndex(index).setId(id);
import org.opensearch.action.admin.indices.streamingingestion.pause.PauseIngestionResponse;
import org.opensearch.action.admin.cluster.node.info.NodesInfoResponse;
import org.opensearch.action.admin.indices.close.CloseIndexRequest;
import org.opensearch.action.admin.indices.shrink.ResizeResponse;
    public void createPit(final CreatePitRequest createPITRequest, final ActionListener<CreatePitResponse> listener) {
import org.opensearch.action.termvectors.MultiTermVectorsRequest;
        public void clusterStats(ClusterStatsRequest request, ActionListener<ClusterStatsResponse> listener) {
        }
import org.opensearch.common.util.concurrent.ThreadContextAccess;
        @Override
import org.opensearch.action.admin.cluster.node.tasks.list.ListTasksResponse;
import org.opensearch.action.admin.indices.upgrade.get.UpgradeStatusRequestBuilder;
        }
        }
import org.opensearch.action.admin.cluster.remotestore.metadata.RemoteStoreMetadataAction;
        public <Request extends ActionRequest, Response extends ActionResponse> ActionFuture<Response> execute(
        }
        @Override
        @Override
        public DeleteTaskRequestBuilder prepareDeleteTask(TaskId taskId) {
    public void fieldCaps(FieldCapabilitiesRequest request, ActionListener<FieldCapabilitiesResponse> listener) {
import org.opensearch.action.admin.cluster.health.ClusterHealthRequest;
        return new MultiGetRequestBuilder(this, MultiGetAction.INSTANCE);
        public ActionFuture<ClusterUpdateSettingsResponse> updateSettings(final ClusterUpdateSettingsRequest request) {
        @Override
import org.opensearch.action.admin.indices.stats.IndicesStatsAction;
        }
    public ActionFuture<SearchResponse> search(final SearchRequest request) {
            execute(GetSnapshotsAction.INSTANCE, request, listener);
            return client.threadPool();
            return execute(PutMappingAction.INSTANCE, request);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    @Override
        }
        @Override
import org.opensearch.common.action.ActionFuture;
        }
import org.opensearch.action.get.GetAction;
        return new FilterClient(this) {
    private final Admin admin;
import org.opensearch.action.admin.cluster.node.tasks.delete.DeleteTaskRequestBuilder;
        public ActionFuture<ClusterAllocationExplainResponse> allocationExplain(ClusterAllocationExplainRequest request) {
        }
        }
        public void nodesUsage(final NodesUsageRequest request, final ActionListener<NodesUsageResponse> listener) {
    }
    public IndexRequestBuilder prepareIndex(String index) {
    }
import org.opensearch.action.admin.indices.stats.IndicesStatsRequestBuilder;
        ActionType<Response> action,
    protected abstract <Request extends ActionRequest, Response extends ActionResponse> void doExecute(
        public ActionFuture<ResolveIndexAction.Response> resolveIndex(ResolveIndexAction.Request request) {
            return execute(GetIngestionStateAction.INSTANCE, request);
        public void pauseIngestion(final PauseIngestionRequest request, final ActionListener<PauseIngestionResponse> listener) {
        @Override
        public NodesStatsRequestBuilder prepareNodesStats(String... nodesIds) {
        }
        execute(FieldCapabilitiesAction.INSTANCE, request, listener);
        public RestoreSnapshotRequestBuilder prepareRestoreSnapshot(String repository, String snapshot) {
    @Override
        @Override
import org.opensearch.action.search.CreatePitRequest;
import org.opensearch.action.admin.indices.streamingingestion.pause.PauseIngestionAction;
        @Override
        public void putMapping(final PutMappingRequest request, final ActionListener<AcknowledgedResponse> listener) {
            return execute(GetFieldMappingsAction.INSTANCE, request);
        public OpenIndexRequestBuilder prepareOpen(String... indices) {
            return new GetAliasesRequestBuilder(this, GetAliasesAction.INSTANCE, aliases);
import org.opensearch.action.ingest.GetPipelineResponse;
        @Override
        ) {
    }
        public DeleteIndexTemplateRequestBuilder prepareDeleteTemplate(String name) {
        public void deleteWeightedRouting(
import org.opensearch.action.admin.cluster.shards.ClusterSearchShardsResponse;
        public ClusterStateRequestBuilder prepareState() {
        };
        public ActionFuture<RestoreSnapshotResponse> restoreSnapshot(RestoreSnapshotRequest request) {
import org.opensearch.action.admin.indices.alias.get.GetAliasesAction;
        @Override
import org.opensearch.action.admin.cluster.wlm.WlmStatsAction;
        }
        public GetTaskRequestBuilder prepareGetTask(String taskId) {
    }
        @Override
        }
            return remoteStoreStatsRequestBuilder;
        return execute(DeleteAction.INSTANCE, request);
import org.opensearch.action.search.GetSearchPipelineAction;
            return execute(CloneSnapshotAction.INSTANCE, request);
            execute(ClusterSearchShardsAction.INSTANCE, request, listener);
        public ActionFuture<GetAliasesResponse> getAliases(GetAliasesRequest request) {
            return execute(RefreshAction.INSTANCE, request);
        }
            return execute(ImportDanglingIndexAction.INSTANCE, request);
        }
    @Override
import org.opensearch.action.admin.cluster.node.tasks.list.ListTasksRequestBuilder;
import org.opensearch.action.admin.indices.cache.clear.ClearIndicesCacheRequest;
import org.opensearch.action.admin.indices.forcemerge.ForceMergeRequestBuilder;
import org.opensearch.action.admin.indices.template.delete.DeleteIndexTemplateRequest;
import org.opensearch.action.admin.cluster.decommission.awareness.delete.DeleteDecommissionStateAction;
        }
        @Override
import org.opensearch.action.admin.indices.analyze.AnalyzeRequestBuilder;
        public void aliases(final IndicesAliasesRequest request, final ActionListener<AcknowledgedResponse> listener) {
        private final IndicesAdmin indicesAdmin;
import org.opensearch.action.admin.cluster.node.tasks.get.GetTaskAction;
import org.opensearch.action.admin.cluster.shards.routing.weighted.get.ClusterGetWeightedRoutingRequest;
            return new RestoreSnapshotRequestBuilder(this, RestoreSnapshotAction.INSTANCE, repository, snapshot);
        }
import org.opensearch.action.admin.cluster.node.tasks.cancel.CancelTasksRequestBuilder;
import org.opensearch.action.admin.cluster.reroute.ClusterRerouteRequestBuilder;
    protected final Logger logger;
        @Override
        @Override
                this,
        public void recoveries(final RecoveryRequest request, final ActionListener<RecoveryResponse> listener) {
        }
        @Override
        public ClusterRerouteRequestBuilder prepareReroute() {
import org.opensearch.action.admin.indices.create.CreateIndexRequest;
        public ClusterDeleteWeightedRoutingRequestBuilder prepareDeleteWeightedRouting() {
    }
        }
import org.opensearch.action.search.DeletePitResponse;
            execute(AnalyzeAction.INSTANCE, request, listener);
        }
            return execute(IndicesExistsAction.INSTANCE, request);
        public ClusterSearchShardsRequestBuilder prepareSearchShards(String... indices) {
import org.opensearch.action.admin.indices.mapping.put.PutMappingAction;
import org.opensearch.action.delete.DeleteRequestBuilder;
    public SearchRequestBuilder prepareSearch(String... indices) {
        public ActionFuture<AcknowledgedResponse> importDanglingIndex(ImportDanglingIndexRequest request) {
        @Override
            execute(DeleteRepositoryAction.INSTANCE, request, listener);
import org.opensearch.action.admin.cluster.storedscripts.DeleteStoredScriptRequestBuilder;
        public ActionFuture<NodesHotThreadsResponse> nodesHotThreads(NodesHotThreadsRequest request) {
            execute(NodesUsageAction.INSTANCE, request, listener);
        Request request,
 *     http://www.apache.org/licenses/LICENSE-2.0
        @Override
        @Override
import org.opensearch.action.admin.cluster.node.tasks.delete.DeleteTaskRequest;
        }
        }
import org.opensearch.action.admin.cluster.node.tasks.delete.DeleteTaskAction;
        @Override
        public void getTemplates(final GetIndexTemplatesRequest request, final ActionListener<GetIndexTemplatesResponse> listener) {
            execute(CreateSnapshotAction.INSTANCE, request, listener);
    }
 * this file be licensed under the Apache-2.0 license or a
            return new PutPipelineRequestBuilder(this, PutPipelineAction.INSTANCE, id, source, mediaType);
            return client.execute(action, request);
        public RefreshRequestBuilder prepareRefresh(String... indices) {
        }
            ClusterDeleteWeightedRoutingRequest request,
            execute(ImportDanglingIndexAction.INSTANCE, request, listener);
import org.opensearch.transport.client.ClusterAdminClient;
    @Override
        public void rolloverIndex(RolloverRequest request, ActionListener<RolloverResponse> listener) {
import org.opensearch.action.search.GetSearchPipelineResponse;
    @Override
import org.opensearch.action.admin.cluster.snapshots.create.CreateSnapshotAction;
            return execute(GetPipelineAction.INSTANCE, request);
    }
import org.opensearch.action.admin.cluster.repositories.get.GetRepositoriesResponse;
    );
import org.opensearch.action.admin.indices.cache.clear.ClearIndicesCacheRequestBuilder;
import org.opensearch.action.admin.indices.alias.IndicesAliasesRequestBuilder;
    public void deletePits(final DeletePitRequest deletePITRequest, final ActionListener<DeletePitResponse> listener) {
        }
        @Override
        }
    public BulkRequestBuilder prepareBulk(@Nullable String globalIndex) {
        public void deleteTemplate(final DeleteIndexTemplateRequest request, final ActionListener<AcknowledgedResponse> listener) {
            execute(PauseIngestionAction.INSTANCE, request, listener);
    @Override
 */
        public ActionFuture<ClearIndicesCacheResponse> clearCache(final ClearIndicesCacheRequest request) {
        execute(MultiTermVectorsAction.INSTANCE, request, listener);
import org.opensearch.action.admin.indices.template.get.GetIndexTemplatesRequest;
        public ActionFuture<GetTaskResponse> getTask(final GetTaskRequest request) {
        public void putStoredScript(final PutStoredScriptRequest request, ActionListener<AcknowledgedResponse> listener) {
        execute(PitSegmentsAction.INSTANCE, request, listener);
        public ActionFuture<DeleteDecommissionStateResponse> deleteDecommissionState(DeleteDecommissionStateRequest request) {
    @Override
            execute(DeleteDanglingIndexAction.INSTANCE, request, listener);
import org.opensearch.action.admin.indices.readonly.AddIndexBlockAction;
        }
        @Override
import org.opensearch.action.search.ClearScrollResponse;
import org.opensearch.action.search.MultiSearchRequest;
        }
        public GetIndexTemplatesRequestBuilder prepareGetTemplates(String... names) {
        @Override
        execute(DeleteAction.INSTANCE, request, listener);
        return new IndexRequestBuilder(this, IndexAction.INSTANCE, index);
            return new CreateSnapshotRequestBuilder(this, CreateSnapshotAction.INSTANCE, repository, name);
        @Override
import java.util.Map;
import org.opensearch.action.admin.indices.readonly.AddIndexBlockRequest;
            ActionListener<ClusterPutWeightedRoutingResponse> listener
    }
            return new DeletePipelineRequestBuilder(this, DeletePipelineAction.INSTANCE);
import org.opensearch.action.admin.indices.delete.DeleteIndexRequestBuilder;
        @Override
    public ActionFuture<MultiGetResponse> multiGet(final MultiGetRequest request) {
            execute(ClearIndicesCacheAction.INSTANCE, request, listener);
import org.opensearch.action.admin.indices.template.put.PutIndexTemplateAction;
        public CloneSnapshotRequestBuilder prepareCloneSnapshot(String repository, String source, String target) {
            execute(ResolveIndexAction.INSTANCE, request, listener);
        public ActionFuture<ClusterSearchShardsResponse> searchShards(final ClusterSearchShardsRequest request) {
import org.opensearch.action.admin.indices.mapping.get.GetMappingsRequest;
        public IndicesAdminClient indices() {
        @Override
        @Override
import org.opensearch.action.admin.indices.shards.IndicesShardStoresRequest;
import org.opensearch.action.admin.cluster.node.stats.NodesStatsRequestBuilder;
 * this work for additional information regarding copyright
        @Override
        public ActionFuture<IndicesExistsResponse> exists(final IndicesExistsRequest request) {
        this.admin = new Admin(this);
 *
        }
        }
        @Override
import org.opensearch.action.admin.indices.get.GetIndexRequestBuilder;
        return execute(TermVectorsAction.INSTANCE, request);
        }
        }
        public void resolveIndex(ResolveIndexAction.Request request, ActionListener<ResolveIndexAction.Response> listener) {
        public CleanupRepositoryRequestBuilder prepareCleanupRepository(String repository) {
        }
        }
        @Override
import org.opensearch.action.search.DeletePitAction;
import org.opensearch.action.admin.indices.upgrade.get.UpgradeStatusResponse;
        }
            return new GetTaskRequestBuilder(this, GetTaskAction.INSTANCE).setTaskId(taskId);
    }
        @Override
            return execute(ResizeAction.INSTANCE, request);
import org.opensearch.action.admin.indices.upgrade.get.UpgradeStatusRequest;
import org.opensearch.action.admin.cluster.reroute.ClusterRerouteRequest;
        public void forceMerge(final ForceMergeRequest request, final ActionListener<ForceMergeResponse> listener) {
import org.opensearch.action.admin.cluster.snapshots.restore.RestoreSnapshotRequestBuilder;
import org.opensearch.action.admin.cluster.shards.routing.weighted.put.ClusterAddWeightedRoutingAction;
            return new ValidateQueryRequestBuilder(this, ValidateQueryAction.INSTANCE).setIndices(indices);
        ) {
            return new NodesStatsRequestBuilder(this, NodesStatsAction.INSTANCE).setNodesIds(nodesIds);
import org.opensearch.action.ingest.SimulatePipelineResponse;
        @Override
import org.opensearch.action.admin.cluster.snapshots.get.GetSnapshotsRequest;
        public ActionFuture<AcknowledgedResponse> delete(final DeleteIndexRequest request) {
import org.opensearch.action.admin.cluster.snapshots.get.GetSnapshotsAction;
        @Override
import org.opensearch.action.admin.cluster.allocation.ClusterAllocationExplainRequest;
import org.opensearch.action.admin.indices.scale.searchonly.ScaleIndexRequestBuilder;
        }
        }
            return client.execute(action, request);
    public void clearScroll(ClearScrollRequest request, ActionListener<ClearScrollResponse> listener) {
                ) {
        }
import org.opensearch.action.get.GetResponse;
        }
            ActionType<Response> action,
import org.opensearch.action.admin.indices.rollover.RolloverRequestBuilder;
        @Override
        }
        public ActionFuture<ClusterGetWeightedRoutingResponse> getWeightedRouting(ClusterGetWeightedRoutingRequest request) {
                ActionType<Response> action,
        @Override
        public ActionFuture<NodesInfoResponse> nodesInfo(final NodesInfoRequest request) {
        public void getStoredScript(final GetStoredScriptRequest request, final ActionListener<GetStoredScriptResponse> listener) {
        public ActionFuture<ClusterStateResponse> state(final ClusterStateRequest request) {
    public MultiSearchRequestBuilder prepareMultiSearch() {
            execute(ForceMergeAction.INSTANCE, request, listener);
        }
    @Override
            return execute(SimulatePipelineAction.INSTANCE, request);
            Request request,
        }
        public void listDanglingIndices(ListDanglingIndicesRequest request, ActionListener<ListDanglingIndicesResponse> listener) {
        return execute(SearchScrollAction.INSTANCE, request);
        execute(ExplainAction.INSTANCE, request, listener);
            execute(RolloverAction.INSTANCE, request, listener);
        @Override
import org.opensearch.action.admin.indices.mapping.get.GetFieldMappingsRequestBuilder;
        public <Request extends ActionRequest, Response extends ActionResponse> ActionFuture<Response> execute(
import org.opensearch.action.ActionRequest;
            execute(IndicesStatsAction.INSTANCE, request, listener);
    public final AdminClient admin() {
        }
    }
        Request request
        }
        public ActionFuture<AcknowledgedResponse> deleteStoredScript(DeleteStoredScriptRequest request) {
            return new ResizeRequestBuilder(this, ResizeAction.INSTANCE).setSourceIndex(sourceIndex)
        @Override
import org.opensearch.action.admin.cluster.decommission.awareness.get.GetDecommissionStateRequest;
import org.opensearch.action.admin.cluster.repositories.verify.VerifyRepositoryRequest;
import org.opensearch.action.admin.cluster.snapshots.create.CreateSnapshotResponse;
        public void putSearchPipeline(PutSearchPipelineRequest request, ActionListener<AcknowledgedResponse> listener) {
        public ClusterSearchShardsRequestBuilder prepareSearchShards() {
        @Override
    public TermVectorsRequestBuilder prepareTermVectors(String index, String id) {
import org.opensearch.action.admin.cluster.health.ClusterHealthAction;
        @Override
import org.opensearch.action.admin.indices.mapping.put.PutMappingRequestBuilder;
            return execute(ResumeIngestionAction.INSTANCE, request);
        @Override
import org.opensearch.action.search.MultiSearchResponse;
import org.opensearch.action.admin.indices.mapping.get.GetFieldMappingsResponse;
import org.opensearch.action.admin.indices.mapping.get.GetFieldMappingsAction;
import org.opensearch.action.admin.indices.open.OpenIndexRequestBuilder;
        @Override
        }
        @Override
import org.opensearch.action.admin.cluster.storedscripts.GetStoredScriptResponse;
        }
    @Override
        @Override
        public void close(final CloseIndexRequest request, final ActionListener<CloseIndexResponse> listener) {
    public AbstractClient(Settings settings, ThreadPool threadPool) {
import org.opensearch.action.admin.indices.settings.get.GetSettingsRequest;
    public final ThreadPool threadPool() {
import org.opensearch.transport.client.Client;
        @Override
            return execute(UpgradeAction.INSTANCE, request);
import org.opensearch.action.admin.indices.validate.query.ValidateQueryAction;
import org.opensearch.action.admin.indices.alias.get.GetAliasesRequest;
import org.opensearch.action.admin.indices.shrink.ResizeAction;
import org.opensearch.action.search.SearchRequestBuilder;
    @Override
        @Override
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.action.admin.indices.alias.get.GetAliasesRequestBuilder;
        @Override
        }
        public NodesUsageRequestBuilder prepareNodesUsage(String... nodesIds) {
            execute(VerifyRepositoryAction.INSTANCE, request, listener);
import org.opensearch.action.admin.cluster.storedscripts.GetStoredScriptAction;
                try (
        @Override
            return execute(ClusterSearchShardsAction.INSTANCE, request);
        }
        }
        }
import org.opensearch.action.admin.cluster.node.stats.NodesStatsAction;
import org.opensearch.action.admin.indices.alias.get.GetAliasesResponse;
            return execute(NodesInfoAction.INSTANCE, request);
            return execute(RolloverAction.INSTANCE, request);
        public ActionFuture<GetRepositoriesResponse> getRepositories(GetRepositoriesRequest request) {
        public IndicesSegmentsRequestBuilder prepareSegments(String... indices) {
        }
        ) {
import org.opensearch.action.admin.cluster.node.hotthreads.NodesHotThreadsAction;
        @Override
        public SnapshotsStatusRequestBuilder prepareSnapshotStatus() {
        }
        }
    @Override
import org.opensearch.action.admin.cluster.decommission.awareness.put.DecommissionAction;
            return execute(GetDecommissionStateAction.INSTANCE, request);
        @Override
        public IndicesShardStoreRequestBuilder prepareShardStores(String... indices) {
            execute(GetPipelineAction.INSTANCE, request, listener);
import org.opensearch.action.admin.indices.segments.PitSegmentsAction;
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;
        }
        }
        @Override
    @Override
        }
        public void getFieldMappings(GetFieldMappingsRequest request, ActionListener<GetFieldMappingsResponse> listener) {
        }
import org.opensearch.action.admin.cluster.remotestore.restore.RestoreRemoteStoreAction;
import org.opensearch.action.admin.cluster.node.tasks.get.GetTaskResponse;
        }
            execute(DeleteIndexAction.INSTANCE, request, listener);
import org.opensearch.action.admin.cluster.snapshots.clone.CloneSnapshotRequest;
            execute(CreateDataStreamAction.INSTANCE, request, listener);
            return execute(NodesStatsAction.INSTANCE, request);
        return execute(SearchAction.INSTANCE, request);
    public DeleteRequestBuilder prepareDelete(String index, String id) {
    public Client filterWithHeader(Map<String, String> headers) {
        public GetDecommissionStateRequestBuilder prepareGetDecommissionState() {
import org.opensearch.action.explain.ExplainRequest;
        public void validateQuery(final ValidateQueryRequest request, final ActionListener<ValidateQueryResponse> listener) {
        }
        public ActionFuture<ClusterPutWeightedRoutingResponse> putWeightedRouting(ClusterPutWeightedRoutingRequest request) {
        public AnalyzeRequestBuilder prepareAnalyze(@Nullable String index, String text) {
import org.opensearch.action.admin.indices.get.GetIndexRequest;
     */
        public ActionFuture<ResizeResponse> resizeIndex(ResizeRequest request) {
        @Override
    }
        return new TermVectorsRequestBuilder(this, TermVectorsAction.INSTANCE);
        @Override
import org.opensearch.action.admin.cluster.node.tasks.get.GetTaskRequestBuilder;
        }
        @Override
    @Override
    public GetRequestBuilder prepareGet() {
        }
        return execute(ClearScrollAction.INSTANCE, request);
    @Override
import org.opensearch.action.admin.indices.streamingingestion.state.GetIngestionStateAction;
import org.opensearch.action.admin.cluster.node.usage.NodesUsageRequestBuilder;
        @Override
        /** Resume ingestion */
        }
        }
        @Override
            return new AddIndexBlockRequestBuilder(this, AddIndexBlockAction.INSTANCE, block, indices);
import org.opensearch.action.fieldcaps.FieldCapabilitiesRequest;
        public void createSnapshot(CreateSnapshotRequest request, ActionListener<CreateSnapshotResponse> listener) {
import org.opensearch.action.admin.cluster.node.stats.NodesStatsRequest;
        @Override
        return new SearchRequestBuilder(this, SearchAction.INSTANCE).setIndices(indices);
        }
        @Override
        }
        }
import org.opensearch.action.ingest.DeletePipelineRequestBuilder;
        ) {
            return new GetSnapshotsRequestBuilder(this, GetSnapshotsAction.INSTANCE, repository);
import org.opensearch.action.admin.cluster.node.usage.NodesUsageResponse;
        }
        }
        }
import org.opensearch.action.admin.indices.segments.IndicesSegmentsAction;
        }
            execute(UpdateSettingsAction.INSTANCE, request, listener);
            return execute(ClusterDeleteWeightedRoutingAction.INSTANCE, request);
        this.threadPool = threadPool;
        @Override
import org.opensearch.action.admin.indices.get.GetIndexResponse;
        }
        public ActionFuture<ResumeIngestionResponse> resumeIngestion(final ResumeIngestionRequest request) {
            execute(NodesStatsAction.INSTANCE, request, listener);
            this.client = client;
        public void segments(final IndicesSegmentsRequest request, final ActionListener<IndicesSegmentResponse> listener) {
import org.opensearch.cluster.metadata.IndexMetadata.APIBlock;
        public ActionFuture<GetSearchPipelineResponse> getSearchPipeline(GetSearchPipelineRequest request) {
            return new ListTasksRequestBuilder(this, ListTasksAction.INSTANCE).setNodesIds(nodesIds);
    }
import org.opensearch.action.admin.cluster.tasks.PendingClusterTasksResponse;
        public void getIndex(GetIndexRequest request, ActionListener<GetIndexResponse> listener) {
            execute(RefreshAction.INSTANCE, request, listener);
            Request request,
import org.opensearch.action.admin.indices.replication.SegmentReplicationStatsAction;
        }
        }
            execute(PutMappingAction.INSTANCE, request, listener);
        }
        public ActionFuture<UpgradeStatusResponse> upgradeStatus(final UpgradeStatusRequest request) {
        }
        }
        @Override
        execute(MultiSearchAction.INSTANCE, request, listener);
import org.opensearch.action.admin.indices.settings.get.GetSettingsRequestBuilder;
import org.opensearch.action.admin.indices.template.put.PutIndexTemplateRequest;
            return execute(DecommissionAction.INSTANCE, request);
        return new ClearScrollRequestBuilder(this, ClearScrollAction.INSTANCE);
        return this.threadPool;
    public void searchScroll(final SearchScrollRequest request, final ActionListener<SearchResponse> listener) {
        @Override
/*
import org.opensearch.action.admin.cluster.node.info.NodesInfoAction;
            return execute(CleanupRepositoryAction.INSTANCE, request);
        }
import org.opensearch.action.admin.cluster.tasks.PendingClusterTasksAction;
        ActionListener<Response> listener
        public ActionFuture<CreateSnapshotResponse> createSnapshot(CreateSnapshotRequest request) {
    }
import org.opensearch.action.admin.cluster.shards.routing.weighted.put.ClusterPutWeightedRoutingResponse;
        public GetStoredScriptRequestBuilder prepareGetStoredScript(String id) {
import org.opensearch.action.admin.indices.rollover.RolloverResponse;
        public void getRepositories(GetRepositoriesRequest request, ActionListener<GetRepositoriesResponse> listener) {
import org.opensearch.core.action.ActionResponse;
        public void create(final CreateIndexRequest request, final ActionListener<CreateIndexResponse> listener) {
        }
        }
        return execute(ExplainAction.INSTANCE, request);
        @Override
            return execute(IndicesStatsAction.INSTANCE, request);
    }
            if (shardId != null) {
    }
        }
        public DeleteDecommissionStateRequestBuilder prepareDeleteDecommissionRequest() {
        @Override
        public ClusterPutWeightedRoutingRequestBuilder prepareWeightedRouting() {
import org.opensearch.action.admin.indices.open.OpenIndexAction;
import org.opensearch.action.admin.cluster.remotestore.metadata.RemoteStoreMetadataRequestBuilder;
        @Override
    protected final Settings settings;
import org.opensearch.action.admin.cluster.wlm.WlmStatsResponse;
        }
import org.opensearch.action.support.PlainActionFuture;
        }
    @Override
import org.opensearch.action.admin.cluster.stats.ClusterStatsRequestBuilder;
import org.opensearch.action.admin.indices.template.get.GetIndexTemplatesAction;
        public void deleteSearchPipeline(DeleteSearchPipelineRequest request, ActionListener<AcknowledgedResponse> listener) {
        public PutRepositoryRequestBuilder preparePutRepository(String name) {
        @Override
            return new DeleteSnapshotRequestBuilder(this, DeleteSnapshotAction.INSTANCE, repository, names);
            execute(RestoreRemoteStoreAction.INSTANCE, request, listener);
import org.opensearch.action.admin.cluster.repositories.delete.DeleteRepositoryAction;
        }
        }
import org.opensearch.action.explain.ExplainRequestBuilder;
        }
    }
import org.opensearch.action.admin.cluster.storedscripts.GetStoredScriptRequest;
import org.opensearch.action.admin.cluster.stats.ClusterStatsRequest;
            return new PutIndexTemplateRequestBuilder(this, PutIndexTemplateAction.INSTANCE, name);
            ClusterPutWeightedRoutingRequest request,
        public RecoveryRequestBuilder prepareRecoveries(String... indices) {
        }
        public void getWeightedRouting(
            return new DeletePipelineRequestBuilder(this, DeletePipelineAction.INSTANCE, id);
        @Override
        }
    public GetRequestBuilder prepareGet(String index, String id) {
        @Override
            return new ClusterHealthRequestBuilder(this, ClusterHealthAction.INSTANCE).setIndices(indices);
            execute(DeletePipelineAction.INSTANCE, request, listener);
        }
import org.opensearch.action.admin.cluster.repositories.delete.DeleteRepositoryRequest;
            return execute(GetIndexTemplatesAction.INSTANCE, request);
        }
import org.opensearch.action.admin.cluster.snapshots.status.SnapshotsStatusResponse;
            ActionListener<DeleteDecommissionStateResponse> listener
    }
    @Override
import org.opensearch.action.admin.cluster.remotestore.restore.RestoreRemoteStoreResponse;
            execute(RemoteStoreMetadataAction.INSTANCE, request, listener);
        IndicesAdmin(OpenSearchClient client) {
        public ActionFuture<AcknowledgedResponse> deleteSnapshot(DeleteSnapshotRequest request) {
            execute(ClusterRerouteAction.INSTANCE, request, listener);
        }
        @Override
    }
    @Override
            return execute(CreateSnapshotAction.INSTANCE, request);
import org.opensearch.action.admin.cluster.snapshots.status.SnapshotsStatusRequest;
            return execute(GetMappingsAction.INSTANCE, request);
        @Override
        @Override
    }
    @Override
        }
    public void explain(ExplainRequest request, ActionListener<ExplainResponse> listener) {
import org.opensearch.action.admin.indices.settings.put.UpdateSettingsRequestBuilder;
        }
        public ActionFuture<VerifyRepositoryResponse> verifyRepository(VerifyRepositoryRequest request) {
        public ClearIndicesCacheRequestBuilder prepareClearCache(String... indices) {
        public ActionFuture<ClusterHealthResponse> health(final ClusterHealthRequest request) {
        @Override
import org.opensearch.action.admin.indices.streamingingestion.resume.ResumeIngestionAction;
        ActionType<Response> action,
        public IndicesStatsRequestBuilder prepareStats(String... indices) {
            return execute(DeletePipelineAction.INSTANCE, request);
        }
        }
        public ActionFuture<AcknowledgedResponse> deleteSearchPipeline(DeleteSearchPipelineRequest request) {
        execute(BulkAction.INSTANCE, request, listener);
        @Override
        }
        @Override
        @Override
    @Override
            execute(PutRepositoryAction.INSTANCE, request, listener);
    }
        }
import org.opensearch.action.ActionType;
        }
            execute(ListTasksAction.INSTANCE, request, listener);
        @Override
            ActionListener<ClusterDeleteWeightedRoutingResponse> listener
import org.opensearch.action.admin.cluster.decommission.awareness.delete.DeleteDecommissionStateRequest;
            return execute(NodesHotThreadsAction.INSTANCE, request);
 * license agreements. See the NOTICE file distributed with
        public ActionFuture<GetPipelineResponse> getPipeline(GetPipelineRequest request) {
    @Override
        return new GetRequestBuilder(this, GetAction.INSTANCE, null);
        }
        }
            return builder;
        public AddIndexBlockRequestBuilder prepareAddBlock(APIBlock block, String... indices) {
        @Override
            client.execute(action, request, listener);
            return new FlushRequestBuilder(this, FlushAction.INSTANCE).setIndices(indices);
        return execute(GetAction.INSTANCE, request);
            return execute(ClusterGetWeightedRoutingAction.INSTANCE, request);
        }
        @Override
            return execute(DeleteDanglingIndexAction.INSTANCE, request);
        public ActionFuture<GetStoredScriptResponse> getStoredScript(final GetStoredScriptRequest request) {
    public ActionFuture<DeleteResponse> delete(final DeleteRequest request) {
        public ActionFuture<AcknowledgedResponse> deleteDataStream(DeleteDataStreamAction.Request request) {
            return execute(ResolveIndexAction.INSTANCE, request);
        @Override
            execute(GetSettingsAction.INSTANCE, request, listener);
            return execute(SnapshotsStatusAction.INSTANCE, request);
                    ThreadContext.StoredContext ctx = ThreadContextAccess.doPrivileged(() -> threadContext.stashAndMergeHeaders(headers))
            return new ClusterRerouteRequestBuilder(this, ClusterRerouteAction.INSTANCE);
            execute(ClusterAllocationExplainAction.INSTANCE, request, listener);
import org.opensearch.action.admin.cluster.snapshots.restore.RestoreSnapshotRequest;
        @Override
            execute(SegmentReplicationStatsAction.INSTANCE, request, listener);
        @Override
    }
            return execute(ClusterHealthAction.INSTANCE, request);
        @Override
import org.opensearch.action.admin.cluster.node.tasks.list.ListTasksRequest;
        }
            return new IndicesExistsRequestBuilder(this, IndicesExistsAction.INSTANCE, indices);
        public ForceMergeRequestBuilder prepareForceMerge(String... indices) {
            return execute(VerifyRepositoryAction.INSTANCE, request);
        public ResizeRequestBuilder prepareResizeIndex(String sourceIndex, String targetIndex) {
        public ActionFuture<CreateIndexResponse> create(final CreateIndexRequest request) {
import org.opensearch.action.admin.cluster.snapshots.create.CreateSnapshotRequestBuilder;
        }
        public void getAliases(GetAliasesRequest request, ActionListener<GetAliasesResponse> listener) {
import org.opensearch.action.admin.cluster.remotestore.stats.RemoteStoreStatsAction;
            return execute(RecoveryAction.INSTANCE, request);
        public void decommission(DecommissionRequest request, ActionListener<DecommissionResponse> listener) {
        public void pendingClusterTasks(PendingClusterTasksRequest request, ActionListener<PendingClusterTasksResponse> listener) {
import org.opensearch.action.admin.indices.delete.DeleteIndexAction;
            final SegmentReplicationStatsRequest request,
            RemoteStoreMetadataRequestBuilder builder = new RemoteStoreMetadataRequestBuilder(this, RemoteStoreMetadataAction.INSTANCE)
        }
        public ActionFuture<SimulatePipelineResponse> simulatePipeline(SimulatePipelineRequest request) {
import org.opensearch.action.admin.indices.forcemerge.ForceMergeResponse;
import org.opensearch.action.search.SearchScrollRequestBuilder;
        @Override
        }
    public UpdateRequestBuilder prepareUpdate() {
            ClusterGetWeightedRoutingRequest request,
        }
        @Override
        @Override
        }
        public void state(final ClusterStateRequest request, final ActionListener<ClusterStateResponse> listener) {
    public ActionFuture<MultiTermVectorsResponse> multiTermVectors(final MultiTermVectorsRequest request) {
import org.opensearch.action.admin.indices.rollover.RolloverAction;
        }
import org.opensearch.action.admin.cluster.remotestore.stats.RemoteStoreStatsRequest;
        @Override
import org.opensearch.action.search.ClearScrollRequestBuilder;
import org.opensearch.action.ingest.DeletePipelineRequest;
        execute(SearchScrollAction.INSTANCE, request, listener);
        @Override
    }
        @Override
        public void delete(final DeleteIndexRequest request, final ActionListener<AcknowledgedResponse> listener) {
        public ActionFuture<FlushResponse> flush(final FlushRequest request) {
import org.opensearch.common.util.concurrent.ThreadContext;
            ActionListener<ClusterGetWeightedRoutingResponse> listener
import org.opensearch.action.bulk.BulkRequestBuilder;
    }
        public void reroute(final ClusterRerouteRequest request, final ActionListener<ClusterRerouteResponse> listener) {
        public DeletePipelineRequestBuilder prepareDeletePipeline() {
 * specific language governing permissions and limitations
import org.opensearch.action.admin.cluster.decommission.awareness.get.GetDecommissionStateAction;
            final ClusterUpdateSettingsRequest request,
        ) {
        public RemoteStoreMetadataRequestBuilder prepareRemoteStoreMetadata(String index, String shardId) {
import org.apache.logging.log4j.LogManager;
import org.opensearch.action.admin.cluster.shards.routing.weighted.delete.ClusterDeleteWeightedRoutingResponse;
            return execute(ClusterStateAction.INSTANCE, request);
        @Override
        @Override
    }
import org.opensearch.action.ingest.GetPipelineAction;
import org.opensearch.action.admin.indices.validate.query.ValidateQueryRequest;
import org.opensearch.action.admin.indices.template.get.GetIndexTemplatesRequestBuilder;
            execute(IndicesExistsAction.INSTANCE, request, listener);
import org.opensearch.action.search.SearchAction;
    public ActionFuture<TermVectorsResponse> termVectors(final TermVectorsRequest request) {
        public void segmentReplicationStats(
import org.opensearch.action.admin.cluster.shards.routing.weighted.get.ClusterGetWeightedRoutingRequestBuilder;
import org.opensearch.action.admin.indices.flush.FlushRequest;
        public ActionFuture<GetDataStreamAction.Response> getDataStreams(GetDataStreamAction.Request request) {
        public void cloneSnapshot(CloneSnapshotRequest request, ActionListener<AcknowledgedResponse> listener) {
        }
        public void deleteStoredScript(DeleteStoredScriptRequest request, ActionListener<AcknowledgedResponse> listener) {
        }
        }
            return execute(GetAliasesAction.INSTANCE, request);
        public void getDataStreams(GetDataStreamAction.Request request, ActionListener<GetDataStreamAction.Response> listener) {
    public ActionFuture<FieldCapabilitiesResponse> fieldCaps(FieldCapabilitiesRequest request) {
            execute(UpgradeStatusAction.INSTANCE, request, listener);
        }
            return new GetMappingsRequestBuilder(this, GetMappingsAction.INSTANCE, indices);
import org.opensearch.action.admin.cluster.shards.routing.weighted.delete.ClusterDeleteWeightedRoutingRequestBuilder;
        }
        public VerifyRepositoryRequestBuilder prepareVerifyRepository(String name) {
        return new MultiTermVectorsRequestBuilder(this, MultiTermVectorsAction.INSTANCE);
        }
        }
        public PendingClusterTasksRequestBuilder preparePendingClusterTasks() {
        }
import org.opensearch.action.admin.indices.flush.FlushAction;
 * KIND, either express or implied.  See the License for the
        }
            execute(DeleteStoredScriptAction.INSTANCE, request, listener);
        public ActionFuture<ValidateQueryResponse> validateQuery(final ValidateQueryRequest request) {
            execute(GetDecommissionStateAction.INSTANCE, request, listener);
import org.opensearch.action.admin.indices.shards.IndicesShardStoreRequestBuilder;
        @Override
        execute(GetAction.INSTANCE, request, listener);
        public ActionFuture<AcknowledgedResponse> putStoredScript(final PutStoredScriptRequest request) {
import org.opensearch.action.update.UpdateRequestBuilder;
    public void getAllPits(final GetAllPitNodesRequest getAllPitNodesRequest, final ActionListener<GetAllPitNodesResponse> listener) {
        }
        @Override
    @Override
import org.opensearch.action.search.PutSearchPipelineAction;
import org.opensearch.action.admin.cluster.decommission.awareness.put.DecommissionRequest;
        @Override
        Request request,
            return new PutMappingRequestBuilder(this, PutMappingAction.INSTANCE).setIndices(indices);
            return new RolloverRequestBuilder(this, RolloverAction.INSTANCE).setRolloverTarget(alias);
    @Override
        public ActionFuture<AcknowledgedResponse> deleteDanglingIndex(DeleteDanglingIndexRequest request) {
        public ActionFuture<AcknowledgedResponse> deleteRepository(DeleteRepositoryRequest request) {
import org.opensearch.action.admin.indices.recovery.RecoveryResponse;
import org.opensearch.action.admin.cluster.node.info.NodesInfoRequestBuilder;
            execute(GetAliasesAction.INSTANCE, request, listener);
        public void getTask(final GetTaskRequest request, final ActionListener<GetTaskResponse> listener) {
        return new IndexRequestBuilder(this, IndexAction.INSTANCE, null);
        @Override
        }
import org.opensearch.core.action.ActionListener;
        public void clearCache(final ClearIndicesCacheRequest request, final ActionListener<ClearIndicesCacheResponse> listener) {
import org.opensearch.action.search.GetSearchPipelineRequest;
 * Base client used to create concrete client implementations
 * Unless required by applicable law or agreed to in writing,
    @Override
        @Override
        @Override
        public void simulatePipeline(SimulatePipelineRequest request, ActionListener<SimulatePipelineResponse> listener) {
import org.opensearch.action.admin.indices.settings.get.GetSettingsResponse;
            return prepareDeleteTask(new TaskId(taskId));
        public GetIndexRequestBuilder prepareGetIndex() {
import org.opensearch.action.admin.indices.settings.get.GetSettingsAction;
        @Override
    @Override
        public UpdateSettingsRequestBuilder prepareUpdateSettings(String... indices) {
        @Override
        /** Resume ingestion */
            return execute(DeleteSnapshotAction.INSTANCE, request);
import org.opensearch.action.search.ClearScrollAction;
            execute(ClusterStateAction.INSTANCE, request, listener);
        ) {
            ActionType<Response> action,
        public ThreadPool threadPool() {
    @Override
import org.opensearch.action.admin.cluster.repositories.put.PutRepositoryRequestBuilder;
        @Override
    @Override
        }
            return new GetSettingsRequestBuilder(this, GetSettingsAction.INSTANCE, indices);
    public void update(final UpdateRequest request, final ActionListener<UpdateResponse> listener) {
import org.opensearch.action.bulk.BulkAction;
        @Override
        @Override
        @Override
            execute(ListDanglingIndicesAction.INSTANCE, request, listener);
import org.opensearch.action.admin.indices.shards.IndicesShardStoresResponse;
import org.opensearch.action.admin.indices.exists.indices.IndicesExistsResponse;
                ActionListener<Response> listener
        @Override
        }
            return new ClusterSearchShardsRequestBuilder(this, ClusterSearchShardsAction.INSTANCE);
        @Override
        }
        @Override
import org.opensearch.action.search.StreamSearchAction;
import org.opensearch.action.admin.indices.replication.SegmentReplicationStatsRequest;
    public void search(final SearchRequest request, final ActionListener<SearchResponse> listener) {
        @Override
    }
        @Override
        @Override
    }
            execute(GetDataStreamAction.INSTANCE, request, listener);
            execute(PutStoredScriptAction.INSTANCE, request, listener);
        }
            return execute(ClusterAddWeightedRoutingAction.INSTANCE, request);
        }
            return execute(GetSearchPipelineAction.INSTANCE, request);
        public void searchShards(final ClusterSearchShardsRequest request, final ActionListener<ClusterSearchShardsResponse> listener) {
import org.opensearch.action.admin.indices.template.get.GetIndexTemplatesResponse;
        public CreateIndexRequestBuilder prepareCreate(String index) {
 * compatible open source license.
        }
import org.opensearch.action.admin.cluster.remotestore.metadata.RemoteStoreMetadataRequest;
            return execute(GetRepositoriesAction.INSTANCE, request);
        public ActionFuture<AcknowledgedResponse> aliases(final IndicesAliasesRequest request) {
        @Override
        }
        /** Get ingestion state */
import org.opensearch.action.admin.cluster.shards.ClusterSearchShardsRequestBuilder;
import org.opensearch.action.admin.indices.forcemerge.ForceMergeRequest;
import org.opensearch.action.index.IndexRequest;
        public DecommissionRequestBuilder prepareDecommission(DecommissionRequest request) {
        @Override
        ) {
    @Override
import org.opensearch.action.admin.cluster.node.usage.NodesUsageRequest;
        public ActionFuture<AcknowledgedResponse> deletePipeline(DeletePipelineRequest request) {
import org.opensearch.action.admin.cluster.repositories.verify.VerifyRepositoryResponse;
    @Override
        @Override
import org.opensearch.action.termvectors.MultiTermVectorsAction;
            this.client = client;
        public RemoteStoreStatsRequestBuilder prepareRemoteStoreStats(String index, String shardId) {
        @Override
    @Override
import org.opensearch.action.admin.indices.get.GetIndexAction;
import org.opensearch.action.admin.cluster.shards.routing.weighted.put.ClusterPutWeightedRoutingRequestBuilder;
            execute(RestoreSnapshotAction.INSTANCE, request, listener);
        }
            return new ClusterDeleteWeightedRoutingRequestBuilder(this, ClusterDeleteWeightedRoutingAction.INSTANCE);
        }
import org.opensearch.action.search.SearchRequest;
        return new ExplainRequestBuilder(this, ExplainAction.INSTANCE, index, id);
        public void getPipeline(GetPipelineRequest request, ActionListener<GetPipelineResponse> listener) {
        public ActionFuture<AcknowledgedResponse> deleteTask(DeleteTaskRequest request) {
    }
            return execute(AnalyzeAction.INSTANCE, request);
    }
            execute(CleanupRepositoryAction.INSTANCE, request, listener);
        return new DeleteRequestBuilder(this, DeleteAction.INSTANCE, null);
    }
        public ActionFuture<ListDanglingIndicesResponse> listDanglingIndices(ListDanglingIndicesRequest request) {
        }
        @Override
            execute(CancelTasksAction.INSTANCE, request, listener);
            return execute(SegmentReplicationStatsAction.INSTANCE, request);
    }
import org.opensearch.action.delete.DeleteRequest;
        @Override
        public GetFieldMappingsRequestBuilder prepareGetFieldMappings(String... indices) {
        }
            return new ClearIndicesCacheRequestBuilder(this, ClearIndicesCacheAction.INSTANCE).setIndices(indices);
import org.opensearch.action.admin.indices.validate.query.ValidateQueryResponse;
 * ownership. Elasticsearch licenses this file to you under
        public <Request extends ActionRequest, Response extends ActionResponse> void execute(
        }
    public ActionFuture<GetResponse> get(final GetRequest request) {
import org.opensearch.action.admin.cluster.settings.ClusterUpdateSettingsResponse;
        @Override
        }
import org.opensearch.action.admin.indices.datastream.DeleteDataStreamAction;
        }
import org.opensearch.action.admin.indices.recovery.RecoveryRequestBuilder;
import org.opensearch.action.delete.DeleteResponse;
    @Override
        @Override
        public ActionFuture<AcknowledgedResponse> updateSettings(final UpdateSettingsRequest request) {
/*
        }
        public PutPipelineRequestBuilder preparePutPipeline(String id, BytesReference source, MediaType mediaType) {
import org.opensearch.action.admin.cluster.stats.ClusterStatsResponse;
    @Override
import org.opensearch.transport.client.AdminClient;
        }
        @Override
            return execute(DeleteStoredScriptAction.INSTANCE, request);
        }
            return new ClusterAllocationExplainRequestBuilder(this, ClusterAllocationExplainAction.INSTANCE);
    public FieldCapabilitiesRequestBuilder prepareFieldCaps(String... indices) {
import org.opensearch.action.ingest.PutPipelineRequestBuilder;
import org.opensearch.action.admin.cluster.snapshots.clone.CloneSnapshotRequestBuilder;
        @Override
        ActionListener<Response> listener
    static class ClusterAdmin implements ClusterAdminClient {
        }
            return execute(ForceMergeAction.INSTANCE, request);
import org.opensearch.action.admin.indices.streamingingestion.state.GetIngestionStateResponse;
        }
import org.opensearch.action.ingest.SimulatePipelineRequest;
        @Override
            ).setIndices(index);
    public ActionFuture<ClearScrollResponse> clearScroll(ClearScrollRequest request) {
        @Override
import org.opensearch.action.admin.cluster.node.hotthreads.NodesHotThreadsResponse;
            execute(GetStoredScriptAction.INSTANCE, request, listener);
        public ActionFuture<IndicesShardStoresResponse> shardStores(IndicesShardStoresRequest request) {
import org.opensearch.action.admin.indices.flush.FlushRequestBuilder;
        @Override
        public ActionFuture<ClusterDeleteWeightedRoutingResponse> deleteWeightedRouting(ClusterDeleteWeightedRoutingRequest request) {
            return prepareGetTask(new TaskId(taskId));
            return new IndicesShardStoreRequestBuilder(this, IndicesShardStoresAction.INSTANCE, indices);
        execute(UpdateAction.INSTANCE, request, listener);
import org.opensearch.action.admin.cluster.snapshots.delete.DeleteSnapshotAction;
        public ActionFuture<AcknowledgedResponse> putMapping(final PutMappingRequest request) {
    @Override
import org.opensearch.action.admin.cluster.snapshots.get.GetSnapshotsRequestBuilder;
        @Override
        @Override
            return new OpenIndexRequestBuilder(this, OpenIndexAction.INSTANCE, indices);
import org.opensearch.action.termvectors.TermVectorsRequestBuilder;
        }
        @Override
        @Override
        public ActionFuture<UpgradeResponse> upgrade(final UpgradeRequest request) {
import org.opensearch.action.admin.cluster.repositories.cleanup.CleanupRepositoryResponse;
                    super.doExecute(action, request, listener);
        @Override
    }
        return new TermVectorsRequestBuilder(this, TermVectorsAction.INSTANCE, index, id);
    }
            execute(DeleteSearchPipelineAction.INSTANCE, request, listener);
        }
            return new PendingClusterTasksRequestBuilder(this, PendingClusterTasksAction.INSTANCE);
package org.opensearch.transport.client.support;
        public GetTaskRequestBuilder prepareGetTask(TaskId taskId) {
            return execute(IndicesShardStoresAction.INSTANCE, request);
        this.logger = LogManager.getLogger(this.getClass());
import org.opensearch.action.admin.indices.streamingingestion.resume.ResumeIngestionRequest;
        @Override
            return execute(DeleteSearchPipelineAction.INSTANCE, request);
            return new UpgradeStatusRequestBuilder(this, UpgradeStatusAction.INSTANCE).setIndices(indices);
        @Override
import org.opensearch.transport.client.FilterClient;
        }
    public MultiGetRequestBuilder prepareMultiGet() {
import org.opensearch.action.admin.indices.shrink.ResizeRequest;
            execute(ClusterGetWeightedRoutingAction.INSTANCE, request, listener);
        public ListTasksRequestBuilder prepareListTasks(String... nodesIds) {
        }
        public ActionFuture<DecommissionResponse> decommission(DecommissionRequest request) {
            execute(ClusterStatsAction.INSTANCE, request, listener);
        @Override
    ) {
        @Override
        @Override
import org.opensearch.action.admin.indices.close.CloseIndexAction;
        @Override
            return execute(DeleteTaskAction.INSTANCE, request);
import org.opensearch.action.update.UpdateRequest;
            return execute(ValidateQueryAction.INSTANCE, request);
        }
            return execute(PutRepositoryAction.INSTANCE, request);
            return new AnalyzeRequestBuilder(this, AnalyzeAction.INSTANCE);
import org.opensearch.action.admin.cluster.decommission.awareness.delete.DeleteDecommissionStateRequestBuilder;
import org.opensearch.action.admin.indices.refresh.RefreshResponse;
            execute(GetSearchPipelineAction.INSTANCE, request, listener);
            return new IndicesAliasesRequestBuilder(this, IndicesAliasesAction.INSTANCE);
        public void remoteStoreMetadata(
        @Override
import org.opensearch.action.admin.indices.segments.IndicesSegmentResponse;
        }
        public void getSnapshots(GetSnapshotsRequest request, ActionListener<GetSnapshotsResponse> listener) {
    @Override
import org.opensearch.action.admin.indices.open.OpenIndexRequest;
            execute(IndicesAliasesAction.INSTANCE, request, listener);
import org.opensearch.action.admin.cluster.health.ClusterHealthResponse;
import org.opensearch.action.fieldcaps.FieldCapabilitiesResponse;
        }
import org.opensearch.action.admin.cluster.settings.ClusterUpdateSettingsAction;
            this.indicesAdmin = new IndicesAdmin(client);
            execute(DeleteDecommissionStateAction.INSTANCE, request, listener);
        execute(CreatePitAction.INSTANCE, createPITRequest, listener);
        @Override
    public ExplainRequestBuilder prepareExplain(String index, String id) {
        public PutStoredScriptRequestBuilder preparePutStoredScript() {
import org.opensearch.action.admin.cluster.repositories.get.GetRepositoriesRequest;
        @Override
        }
        }
        @Override
            ActionListener<Response> listener
        public GetRepositoriesRequestBuilder prepareGetRepositories(String... name) {
            execute(GetIndexAction.INSTANCE, request, listener);
        @Override
        execute(ClearScrollAction.INSTANCE, request, listener);
        @Override
    }
    }
        public DeleteIndexRequestBuilder prepareDelete(String... indices) {
import org.opensearch.action.admin.cluster.snapshots.delete.DeleteSnapshotRequestBuilder;
import org.opensearch.action.admin.cluster.repositories.cleanup.CleanupRepositoryRequestBuilder;
import org.opensearch.action.admin.indices.forcemerge.ForceMergeAction;
        public ActionFuture<GetIndexTemplatesResponse> getTemplates(final GetIndexTemplatesRequest request) {
import org.opensearch.action.admin.indices.dangling.import_index.ImportDanglingIndexRequest;
                ThreadContext threadContext = threadPool().getThreadContext();
        public UpgradeStatusRequestBuilder prepareUpgradeStatus(String... indices) {
import org.opensearch.action.explain.ExplainResponse;
        @Override
import org.opensearch.action.admin.cluster.state.ClusterStateRequest;
        @Override
        public void deleteRepository(DeleteRepositoryRequest request, ActionListener<AcknowledgedResponse> listener) {
            execute(PutPipelineAction.INSTANCE, request, listener);
import org.opensearch.action.search.SearchScrollAction;
        public void getMappings(GetMappingsRequest request, ActionListener<GetMappingsResponse> listener) {
import org.opensearch.action.admin.cluster.repositories.get.GetRepositoriesRequestBuilder;
        public GetMappingsRequestBuilder prepareGetMappings(String... indices) {
import org.opensearch.action.ingest.GetPipelineRequestBuilder;
        execute(MultiGetAction.INSTANCE, request, listener);
    @Override
        @Override
    }
            return execute(ClusterStatsAction.INSTANCE, request);
        public SimulatePipelineRequestBuilder prepareSimulatePipeline(BytesReference source, MediaType mediaType) {
import org.opensearch.action.search.DeleteSearchPipelineAction;
            this.clusterAdmin = new ClusterAdmin(client);
        this.settings = settings;
            return new UpgradeRequestBuilder(this, UpgradeAction.INSTANCE).setIndices(indices);
    public void multiGet(final MultiGetRequest request, final ActionListener<MultiGetResponse> listener) {
import org.opensearch.action.admin.indices.shrink.ResizeRequestBuilder;
        }
        }
        public DeleteStoredScriptRequestBuilder prepareDeleteStoredScript() {
            return new AnalyzeRequestBuilder(this, AnalyzeAction.INSTANCE, index, text);
        @Override
import org.opensearch.action.ingest.PutPipelineAction;
    @Override
        ActionType<Response> action,
        }
        @Override
    }
        /** Pause ingestion */
        @Override
        }
import org.opensearch.action.admin.indices.segments.IndicesSegmentsRequestBuilder;
import org.opensearch.action.admin.indices.dangling.delete.DeleteDanglingIndexAction;
        public void updateSettings(final UpdateSettingsRequest request, final ActionListener<AcknowledgedResponse> listener) {
        public ActionFuture<CloseIndexResponse> close(final CloseIndexRequest request) {
        public void restoreRemoteStore(RestoreRemoteStoreRequest request, ActionListener<RestoreRemoteStoreResponse> listener) {
import org.opensearch.action.admin.cluster.remotestore.metadata.RemoteStoreMetadataResponse;
        @Override
import org.opensearch.action.get.MultiGetRequest;
public abstract class AbstractClient implements Client {
        }
        return new BulkRequestBuilder(this, BulkAction.INSTANCE, globalIndex);
        public void getSettings(GetSettingsRequest request, ActionListener<GetSettingsResponse> listener) {
import org.opensearch.action.admin.cluster.snapshots.get.GetSnapshotsResponse;
        }
import org.opensearch.core.tasks.TaskId;
        public ActionFuture<GetFieldMappingsResponse> getFieldMappings(GetFieldMappingsRequest request) {
        @Override
        @Override
        }
        @Override
            return execute(CloseIndexAction.INSTANCE, request);
import org.opensearch.action.admin.cluster.node.tasks.list.ListTasksAction;
        }
        @Override
        public void resizeIndex(ResizeRequest request, ActionListener<ResizeResponse> listener) {
import org.opensearch.action.admin.indices.close.CloseIndexResponse;
            return new DeleteIndexTemplateRequestBuilder(this, DeleteIndexTemplateAction.INSTANCE, name);
import org.opensearch.action.termvectors.MultiTermVectorsResponse;
    public void get(final GetRequest request, final ActionListener<GetResponse> listener) {
        @Override
        public NodesHotThreadsRequestBuilder prepareNodesHotThreads(String... nodesIds) {
import org.opensearch.action.admin.indices.cache.clear.ClearIndicesCacheResponse;
    @Override
        @Override
            return execute(GetSnapshotsAction.INSTANCE, request);
        @Override
        @Override
import org.opensearch.action.admin.indices.dangling.list.ListDanglingIndicesAction;
import org.opensearch.action.admin.cluster.storedscripts.PutStoredScriptRequest;
    }
import org.opensearch.action.admin.cluster.repositories.cleanup.CleanupRepositoryAction;
            execute(DeleteTaskAction.INSTANCE, request, listener);
import org.opensearch.action.admin.indices.mapping.get.GetMappingsAction;
        public GetStoredScriptRequestBuilder prepareGetStoredScript() {
        @Override
        }
            return new GetIndexTemplatesRequestBuilder(this, GetIndexTemplatesAction.INSTANCE, names);
        public void upgrade(final UpgradeRequest request, final ActionListener<UpgradeResponse> listener) {
            client.execute(action, request, listener);
        public ActionFuture<GetIndexResponse> getIndex(GetIndexRequest request) {
import org.opensearch.action.admin.cluster.snapshots.restore.RestoreSnapshotResponse;
    }
import org.opensearch.action.admin.cluster.repositories.verify.VerifyRepositoryAction;
        @Override
 */
            return execute(FlushAction.INSTANCE, request);
            return new IndicesSegmentsRequestBuilder(this, IndicesSegmentsAction.INSTANCE).setIndices(indices);
        }
        }
    }
        }
import org.opensearch.action.admin.cluster.node.tasks.cancel.CancelTasksRequest;
        }
import org.opensearch.action.admin.cluster.snapshots.create.CreateSnapshotRequest;
        @Override
    @Override
            execute(PendingClusterTasksAction.INSTANCE, request, listener);
        execute(DeletePitAction.INSTANCE, deletePITRequest, listener);
        @Override
            return new DeleteIndexRequestBuilder(this, DeleteIndexAction.INSTANCE, indices);
            execute(ClusterAddWeightedRoutingAction.INSTANCE, request, listener);
            execute(GetFieldMappingsAction.INSTANCE, request, listener);
import org.opensearch.action.admin.cluster.storedscripts.DeleteStoredScriptRequest;
import org.opensearch.action.admin.cluster.remotestore.stats.RemoteStoreStatsRequestBuilder;
        }
import org.opensearch.action.admin.cluster.repositories.put.PutRepositoryRequest;
        @Override
        @Override
        @Override
        }
        }
            return execute(RestoreSnapshotAction.INSTANCE, request);
        }
        @Override
        public void snapshotsStatus(SnapshotsStatusRequest request, ActionListener<SnapshotsStatusResponse> listener) {
        @Override
import org.opensearch.action.admin.cluster.storedscripts.DeleteStoredScriptAction;
            return new DeleteStoredScriptRequestBuilder(client, DeleteStoredScriptAction.INSTANCE);
        @Override
import org.opensearch.transport.client.OpenSearchClient;
            return execute(ClearIndicesCacheAction.INSTANCE, request);
        @Override
/**
        @Override
import org.opensearch.action.admin.indices.open.OpenIndexResponse;
        }
import org.opensearch.action.admin.cluster.snapshots.status.SnapshotsStatusAction;
        execute(SearchAction.INSTANCE, request, listener);
            return new CloseIndexRequestBuilder(this, CloseIndexAction.INSTANCE, indices);
    @Override
        @Override
import org.opensearch.core.common.bytes.BytesReference;
import org.opensearch.action.admin.cluster.node.tasks.cancel.CancelTasksResponse;
        public ActionFuture<GetMappingsResponse> getMappings(GetMappingsRequest request) {
            return new GetFieldMappingsRequestBuilder(this, GetFieldMappingsAction.INSTANCE, indices);
            return execute(GetSettingsAction.INSTANCE, request);
        @Override
        }
            return prepareGetStoredScript().setId(id);
    static class IndicesAdmin implements IndicesAdminClient {
        }
        }
        @Override
import org.opensearch.action.explain.ExplainAction;
            execute(CreateIndexAction.INSTANCE, request, listener);
        public ThreadPool threadPool() {
        public void getDecommissionState(GetDecommissionStateRequest request, ActionListener<GetDecommissionStateResponse> listener) {
            execute(ResizeAction.INSTANCE, request, listener);
import org.opensearch.action.admin.indices.streamingingestion.state.GetIngestionStateRequest;
import org.opensearch.action.admin.indices.template.put.PutIndexTemplateRequestBuilder;
        }
import org.opensearch.action.search.ClearScrollRequest;
import org.opensearch.action.admin.cluster.node.tasks.get.GetTaskRequest;
            return new IndicesStatsRequestBuilder(this, IndicesStatsAction.INSTANCE).setIndices(indices);
        @Override
import org.opensearch.action.admin.cluster.shards.ClusterSearchShardsRequest;
        @Override
    @Override
        @Override
        public DeleteRepositoryRequestBuilder prepareDeleteRepository(String name) {
        }
    }
        }
    }
        public ActionFuture<AcknowledgedResponse> putPipeline(PutPipelineRequest request) {
        return new UpdateRequestBuilder(this, UpdateAction.INSTANCE, index, id);
import org.opensearch.action.termvectors.TermVectorsResponse;
        public void remoteStoreStats(final RemoteStoreStatsRequest request, final ActionListener<RemoteStoreStatsResponse> listener) {
        public ActionFuture<AnalyzeAction.Response> analyze(final AnalyzeAction.Request request) {
        return execute(BulkAction.INSTANCE, request);
            return new PutStoredScriptRequestBuilder(this, PutStoredScriptAction.INSTANCE);
        public ActionFuture<RolloverResponse> rolloverIndex(RolloverRequest request) {
        }
        @Override
            return new SimulatePipelineRequestBuilder(this, SimulatePipelineAction.INSTANCE, source, mediaType);
import org.opensearch.action.admin.indices.validate.query.ValidateQueryRequestBuilder;
        public void analyze(final AnalyzeAction.Request request, final ActionListener<AnalyzeAction.Response> listener) {
import org.opensearch.action.delete.DeleteAction;
        public void deleteTask(DeleteTaskRequest request, ActionListener<AcknowledgedResponse> listener) {
            execute(DeleteSnapshotAction.INSTANCE, request, listener);
import org.opensearch.action.admin.indices.refresh.RefreshRequestBuilder;
        }
        }
import org.opensearch.action.admin.indices.replication.SegmentReplicationStatsRequestBuilder;
import org.opensearch.action.admin.indices.streamingingestion.pause.PauseIngestionRequest;
            return execute(PauseIngestionAction.INSTANCE, request);
    }
        execute(action, request, actionFuture);
 *
    @Override
        @Override
    public final <Request extends ActionRequest, Response extends ActionResponse> void execute(
        }
        return execute(MultiSearchAction.INSTANCE, request);
import org.opensearch.action.admin.cluster.reroute.ClusterRerouteResponse;
        @Override
import org.opensearch.action.admin.indices.upgrade.post.UpgradeRequest;
import org.opensearch.action.fieldcaps.FieldCapabilitiesAction;
        private final OpenSearchClient client;
    public void bulk(final BulkRequest request, final ActionListener<BulkResponse> listener) {
 *
            execute(DecommissionAction.INSTANCE, request, listener);
        @Override
            execute(SnapshotsStatusAction.INSTANCE, request, listener);
        @Override
            @Override
        @Override
import org.opensearch.action.admin.cluster.settings.ClusterUpdateSettingsRequest;
        @Override
            return new CleanupRepositoryRequestBuilder(this, CleanupRepositoryAction.INSTANCE, repository);
        return new BulkRequestBuilder(this, BulkAction.INSTANCE);
            return new ClusterPutWeightedRoutingRequestBuilder(this, ClusterAddWeightedRoutingAction.INSTANCE);
        @Override
        }
            return new SnapshotsStatusRequestBuilder(this, SnapshotsStatusAction.INSTANCE);
        @Override
        ClusterAdmin(OpenSearchClient client) {
    }
import org.opensearch.action.admin.cluster.node.hotthreads.NodesHotThreadsRequest;
        public IndicesAliasesRequestBuilder prepareAliases() {
import org.opensearch.action.admin.indices.mapping.put.PutMappingRequest;
        @Override
            return execute(CancelTasksAction.INSTANCE, request);
        }
        public RolloverRequestBuilder prepareRolloverIndex(String alias) {
        }
            return new CloneSnapshotRequestBuilder(this, CloneSnapshotAction.INSTANCE, repository, source, target);
        return execute(MultiTermVectorsAction.INSTANCE, request);
    private final ThreadPool threadPool;
        }
        }
        }
    ) {
            final ActionListener<SegmentReplicationStatsResponse> listener
        @Override
import org.opensearch.action.admin.cluster.storedscripts.PutStoredScriptAction;
import org.opensearch.action.search.CreatePitResponse;
        }
        public void getSearchPipeline(GetSearchPipelineRequest request, ActionListener<GetSearchPipelineResponse> listener) {
            execute(GetMappingsAction.INSTANCE, request, listener);
            if (shardId != null) {
        }
            execute(AddIndexBlockAction.INSTANCE, request, listener);
        public GetSettingsRequestBuilder prepareGetSettings(String... indices) {
import org.opensearch.action.search.PutSearchPipelineRequest;
        @Override
        public void deleteDecommissionState(
        public NodesReloadSecureSettingsRequestBuilder prepareReloadSecureSettings() {
        public void flush(final FlushRequest request, final ActionListener<FlushResponse> listener) {
        @Override
        @Override
        public ActionFuture<SnapshotsStatusResponse> snapshotsStatus(SnapshotsStatusRequest request) {
        public SnapshotsStatusRequestBuilder prepareSnapshotStatus(String repository) {
        }
import org.opensearch.action.termvectors.TermVectorsAction;
        public ValidateQueryRequestBuilder prepareValidateQuery(String... indices) {
        }
import org.opensearch.action.admin.cluster.shards.routing.weighted.put.ClusterPutWeightedRoutingRequest;
    @Override
    @Override
        return new SearchScrollRequestBuilder(this, SearchScrollAction.INSTANCE, scrollId);
import org.opensearch.action.admin.indices.rollover.RolloverRequest;
        public void deleteSnapshot(DeleteSnapshotRequest request, ActionListener<AcknowledgedResponse> listener) {
    }
    public void index(final IndexRequest request, final ActionListener<IndexResponse> listener) {
    }
        @Override
import org.opensearch.action.admin.indices.create.CreateIndexRequestBuilder;
        return admin;
        public <Request extends ActionRequest, Response extends ActionResponse> void execute(
            return execute(DeleteIndexAction.INSTANCE, request);
            return execute(IndicesSegmentsAction.INSTANCE, request);
        }
        }
        public ClusterAdminClient cluster() {
        @Override
import org.opensearch.action.admin.cluster.shards.routing.weighted.delete.ClusterDeleteWeightedRoutingRequest;
        public void stats(final IndicesStatsRequest request, final ActionListener<IndicesStatsResponse> listener) {
import org.opensearch.action.admin.cluster.health.ClusterHealthRequestBuilder;
        }
            return execute(PutIndexTemplateAction.INSTANCE, request);
    public ActionFuture<SearchResponse> searchScroll(final SearchScrollRequest request) {
 * Licensed to Elasticsearch under one or more contributor
                RemoteStoreStatsAction.INSTANCE
        ) {
        @Override
import org.opensearch.action.ingest.PutPipelineRequest;
        public IndicesExistsRequestBuilder prepareExists(String... indices) {
        }
        @Override
        }
        }
            return new DecommissionRequestBuilder(this, DecommissionAction.INSTANCE, request);
    public TermVectorsRequestBuilder prepareTermVectors() {
            return new DeleteDecommissionStateRequestBuilder(this, DeleteDecommissionStateAction.INSTANCE);
        }
import org.opensearch.action.search.DeletePitRequest;
            execute(WlmStatsAction.INSTANCE, request, listener);
        }
        public ActionFuture<GetIngestionStateResponse> getIngestionState(final GetIngestionStateRequest request) {
            execute(PutSearchPipelineAction.INSTANCE, request, listener);
import org.opensearch.action.admin.indices.resolve.ResolveIndexAction;
            Request request
        }
            execute(ValidateQueryAction.INSTANCE, request, listener);
        @Override
import org.opensearch.action.admin.indices.upgrade.post.UpgradeAction;
    }
        public void shardStores(IndicesShardStoresRequest request, ActionListener<IndicesShardStoresResponse> listener) {
 */
                }
import org.opensearch.action.admin.indices.dangling.delete.DeleteDanglingIndexRequest;
import org.opensearch.action.admin.indices.upgrade.get.UpgradeStatusAction;
        @Override
    @Override
import org.opensearch.action.admin.cluster.remotestore.stats.RemoteStoreStatsResponse;
        public void resumeIngestion(final ResumeIngestionRequest request, final ActionListener<ResumeIngestionResponse> listener) {
            return execute(CreateIndexAction.INSTANCE, request);
            return new GetDecommissionStateRequestBuilder(this, GetDecommissionStateAction.INSTANCE);
    public ActionFuture<ExplainResponse> explain(ExplainRequest request) {
        }
            return execute(DeleteDataStreamAction.INSTANCE, request);
        @Override
        @Override
            return execute(PendingClusterTasksAction.INSTANCE, request);
        }
import org.opensearch.action.admin.cluster.reroute.ClusterRerouteAction;
        public ActionFuture<NodesUsageResponse> nodesUsage(final NodesUsageRequest request) {
        @Override
            return new RefreshRequestBuilder(this, RefreshAction.INSTANCE).setIndices(indices);
        }
import org.opensearch.action.admin.indices.cache.clear.ClearIndicesCacheAction;
import org.opensearch.action.admin.indices.exists.indices.IndicesExistsRequestBuilder;
        }
        public DeleteStoredScriptRequestBuilder prepareDeleteStoredScript(String id) {
                .setTargetIndex(new CreateIndexRequest(targetIndex));
            return new RecoveryRequestBuilder(this, RecoveryAction.INSTANCE).setIndices(indices);
        return actionFuture;
            return new ForceMergeRequestBuilder(this, ForceMergeAction.INSTANCE).setIndices(indices);
            return new CancelTasksRequestBuilder(this, CancelTasksAction.INSTANCE).setNodesIds(nodesIds);
        public ClusterStatsRequestBuilder prepareClusterStats() {
            DeleteDecommissionStateRequest request,
            return execute(GetDataStreamAction.INSTANCE, request);
    public MultiTermVectorsRequestBuilder prepareMultiTermVectors() {
        public ActionFuture<CleanupRepositoryResponse> cleanupRepository(CleanupRepositoryRequest request) {
        }
import org.opensearch.action.admin.cluster.storedscripts.GetStoredScriptRequestBuilder;
        @Override
        }
        public void deleteDanglingIndex(DeleteDanglingIndexRequest request, ActionListener<AcknowledgedResponse> listener) {
        }
        @Override
        @Override
        }
        public void upgradeStatus(final UpgradeStatusRequest request, final ActionListener<UpgradeStatusResponse> listener) {
import org.opensearch.action.admin.cluster.snapshots.clone.CloneSnapshotAction;
import org.opensearch.action.admin.indices.create.CreateIndexAction;
        public AnalyzeRequestBuilder prepareAnalyze() {
        public ClusterGetWeightedRoutingRequestBuilder prepareGetWeightedRouting() {
import org.opensearch.action.admin.cluster.snapshots.restore.RestoreSnapshotAction;
    }
import org.opensearch.action.admin.indices.readonly.AddIndexBlockRequestBuilder;
        @Override
import org.opensearch.action.bulk.BulkResponse;
import org.opensearch.transport.client.IndicesAdminClient;
import org.opensearch.action.admin.indices.datastream.CreateDataStreamAction;
import org.opensearch.action.admin.indices.refresh.RefreshRequest;
import org.opensearch.action.admin.indices.streamingingestion.resume.ResumeIngestionResponse;
            ActionType<Response> action,
import org.opensearch.action.admin.cluster.state.ClusterStateAction;
import org.opensearch.action.termvectors.TermVectorsRequest;
        return new UpdateRequestBuilder(this, UpdateAction.INSTANCE, null, null);
import org.opensearch.action.search.GetAllPitNodesRequest;
        public ActionFuture<SegmentReplicationStatsResponse> segmentReplicationStats(final SegmentReplicationStatsRequest request) {
import org.opensearch.action.admin.indices.analyze.AnalyzeAction;
            return execute(ListTasksAction.INSTANCE, request);
        public void restoreSnapshot(RestoreSnapshotRequest request, ActionListener<RestoreSnapshotResponse> listener) {
        return this.settings;
        }
    }
        @Override
import org.opensearch.action.index.IndexAction;
import org.opensearch.action.admin.cluster.state.ClusterStateResponse;
            protected <Request extends ActionRequest, Response extends ActionResponse> void doExecute(
        @Override
import org.opensearch.common.Nullable;
        public DeleteSnapshotRequestBuilder prepareDeleteSnapshot(String repository, String... names) {
        }
        public void nodesHotThreads(NodesHotThreadsRequest request, ActionListener<NodesHotThreadsResponse> listener) {
        @Override
import org.opensearch.action.admin.indices.settings.put.UpdateSettingsAction;
            execute(FlushAction.INSTANCE, request, listener);
            return new NodesUsageRequestBuilder(this, NodesUsageAction.INSTANCE).setNodesIds(nodesIds);
            return new SnapshotsStatusRequestBuilder(this, SnapshotsStatusAction.INSTANCE, repository);
            return execute(GetIndexAction.INSTANCE, request);
import org.opensearch.action.admin.cluster.decommission.awareness.get.GetDecommissionStateRequestBuilder;
        }
        @Override
        public void createDataStream(CreateDataStreamAction.Request request, ActionListener<AcknowledgedResponse> listener) {
                builder.setShards(shardId);
/*
            final ActionListener<RemoteStoreMetadataResponse> listener
        @Override
            return new DeleteRepositoryRequestBuilder(this, DeleteRepositoryAction.INSTANCE, name);
import org.opensearch.action.admin.indices.mapping.get.GetMappingsResponse;
        @Override
        }
    @Override
        @Override
 * GitHub history for details.
        public ActionFuture<GetSnapshotsResponse> getSnapshots(GetSnapshotsRequest request) {
        @Override
import org.opensearch.action.admin.cluster.decommission.awareness.get.GetDecommissionStateResponse;
            return new GetRepositoriesRequestBuilder(this, GetRepositoriesAction.INSTANCE, name);
            return new SegmentReplicationStatsRequestBuilder(this, SegmentReplicationStatsAction.INSTANCE).setIndices(indices);
        @Override
        }
        }
        public void verifyRepository(VerifyRepositoryRequest request, ActionListener<VerifyRepositoryResponse> listener) {
            RemoteStoreStatsRequestBuilder remoteStoreStatsRequestBuilder = new RemoteStoreStatsRequestBuilder(
        public ActionFuture<ClusterStatsResponse> clusterStats(ClusterStatsRequest request) {
        ) {
        @Override
                Request request,
import org.apache.logging.log4j.Logger;
        public void wlmStats(final WlmStatsRequest request, final ActionListener<WlmStatsResponse> listener) {
        @Override
        public ActionFuture<AcknowledgedResponse> putSearchPipeline(PutSearchPipelineRequest request) {
 */
            return execute(UpgradeStatusAction.INSTANCE, request);
            return execute(ClusterRerouteAction.INSTANCE, request);
        public ActionFuture<AcknowledgedResponse> putRepository(PutRepositoryRequest request) {
        public ActionFuture<RefreshResponse> refresh(final RefreshRequest request) {
import org.opensearch.action.admin.indices.dangling.list.ListDanglingIndicesResponse;
import org.opensearch.action.termvectors.MultiTermVectorsRequestBuilder;
            execute(ClusterDeleteWeightedRoutingAction.INSTANCE, request, listener);
        }
            return execute(PutSearchPipelineAction.INSTANCE, request);
        @Override
        }
        }
import org.opensearch.action.search.DeleteSearchPipelineRequest;
        public DeleteTaskRequestBuilder prepareDeleteTask(String taskId) {
        }
        /** Get ingestion state */
 * software distributed under the License is distributed on an
        @Override
import org.opensearch.action.admin.cluster.settings.ClusterUpdateSettingsRequestBuilder;
            return new ClusterGetWeightedRoutingRequestBuilder(this, ClusterGetWeightedRoutingAction.INSTANCE);
            ActionType<Response> action,
import org.opensearch.action.admin.cluster.repositories.put.PutRepositoryAction;
        public void listTasks(final ListTasksRequest request, final ActionListener<ListTasksResponse> listener) {
            execute(OpenIndexAction.INSTANCE, request, listener);
        @Override
            execute(RemoteStoreStatsAction.INSTANCE, request, listener);
        @Override
            return execute(PutStoredScriptAction.INSTANCE, request);
        }
        }
        @Override
        public ActionFuture<OpenIndexResponse> open(final OpenIndexRequest request) {
 * You may obtain a copy of the License at
import org.opensearch.action.admin.cluster.repositories.cleanup.CleanupRepositoryRequest;
            execute(GetIndexTemplatesAction.INSTANCE, request, listener);
        }
            return new GetStoredScriptRequestBuilder(this, GetStoredScriptAction.INSTANCE);
        Admin(OpenSearchClient client) {
import org.opensearch.action.admin.indices.dangling.import_index.ImportDanglingIndexAction;
                .setIndices(index);
        }
            }
import org.opensearch.action.admin.indices.settings.put.UpdateSettingsRequest;
import org.opensearch.action.get.GetRequestBuilder;
        @Override
            ) {
import org.opensearch.action.admin.indices.refresh.RefreshAction;
            execute(GetRepositoriesAction.INSTANCE, request, listener);
    public ClearScrollRequestBuilder prepareClearScroll() {
    @Override
            return execute(IndicesAliasesAction.INSTANCE, request);
            execute(DeleteDataStreamAction.INSTANCE, request, listener);
    public BulkRequestBuilder prepareBulk() {
import org.opensearch.action.ingest.DeletePipelineAction;
            return new DeleteTaskRequestBuilder(this, DeleteTaskAction.INSTANCE).setTaskId(taskId);
import org.opensearch.action.admin.indices.readonly.AddIndexBlockResponse;
        }
            return execute(ClusterUpdateSettingsAction.INSTANCE, request);
    public UpdateRequestBuilder prepareUpdate(String index, String id) {
