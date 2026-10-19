import org.opensearch.action.ingest.SimulatePipelineRequestBuilder;
        return this.threadPool;
import org.opensearch.action.admin.indices.recovery.RecoveryRequest;  
        }  
        }
        @Override
            return new PutPipelineRequestBuilder(this, PutPipelineAction.INSTANCE, id, source, mediaType);
import org.opensearch.action.admin.indices.template.put.PutIndexTemplateRequestBuilder;  
            return new ClusterHealthRequestBuilder(this, ClusterHealthAction.INSTANCE).setIndices(indices);  
import org.opensearch.action.admin.cluster.state.ClusterStateRequest;
    }
            return new FlushRequestBuilder(this, FlushAction.INSTANCE).setIndices(indices);
        execute(SearchScrollAction.INSTANCE, request, listener);  
        execute(FieldCapabilitiesAction.INSTANCE, request, listener);
import org.opensearch.action.admin.indices.streamingingestion.state.GetIngestionStateRequest;
        }  
        ActionListener<Response> listener  
            execute(CreateDataStreamAction.INSTANCE, request, listener);
        @Override
        public void delete(final DeleteIndexRequest request, final ActionListener<AcknowledgedResponse> listener) {  
import org.opensearch.action.admin.cluster.node.stats.NodesStatsAction;
        }
        public ActionFuture<ResolveIndexAction.Response> resolveIndex(ResolveIndexAction.Request request) {  
        public void deleteSearchPipeline(DeleteSearchPipelineRequest request, ActionListener<AcknowledgedResponse> listener) {
        }  
import org.opensearch.action.admin.cluster.snapshots.create.CreateSnapshotAction;  
import org.opensearch.action.ingest.GetPipelineResponse;
            return new GetSettingsRequestBuilder(this, GetSettingsAction.INSTANCE, indices);
            return new PutStoredScriptRequestBuilder(this, PutStoredScriptAction.INSTANCE);
import org.opensearch.action.admin.indices.create.CreateIndexResponse;
        return new UpdateRequestBuilder(this, UpdateAction.INSTANCE, index, id);  
            return new DeleteStoredScriptRequestBuilder(client, DeleteStoredScriptAction.INSTANCE);  
        }  
        public ActionFuture<ClusterRerouteResponse> reroute(final ClusterRerouteRequest request) {
        @Override
    public void index(final IndexRequest request, final ActionListener<IndexResponse> listener) {
        @Override  
        @Override  
        }
import org.opensearch.action.admin.cluster.node.tasks.list.ListTasksResponse;
        }
            execute(GetDataStreamAction.INSTANCE, request, listener);
        @Override
            return new ClusterPutWeightedRoutingRequestBuilder(this, ClusterAddWeightedRoutingAction.INSTANCE);
        public void forceMerge(final ForceMergeRequest request, final ActionListener<ForceMergeResponse> listener) {
        public ActionFuture<GetIngestionStateResponse> getIngestionState(final GetIngestionStateRequest request) {
        @Override
        public ActionFuture<GetFieldMappingsResponse> getFieldMappings(GetFieldMappingsRequest request) {  
    @Override
        public ActionFuture<CreateSnapshotResponse> createSnapshot(CreateSnapshotRequest request) {
        }
        public ActionFuture<ListDanglingIndicesResponse> listDanglingIndices(ListDanglingIndicesRequest request) {
import org.opensearch.common.Nullable;  
        @Override
    }
import org.opensearch.action.search.MultiSearchRequest;
        }
import org.opensearch.common.util.concurrent.ThreadContext;  
                this,  
        }
        }  
        public void getSnapshots(GetSnapshotsRequest request, ActionListener<GetSnapshotsResponse> listener) {  
            execute(CreateSnapshotAction.INSTANCE, request, listener);
        @Override
import org.opensearch.action.admin.indices.upgrade.get.UpgradeStatusResponse;
        public ActionFuture<NodesUsageResponse> nodesUsage(final NodesUsageRequest request) {
            execute(RemoteStoreStatsAction.INSTANCE, request, listener);  
        @Override  
        }
    @Override
        private final OpenSearchClient client;
import org.opensearch.action.search.CreatePitAction;
        @Override
import org.opensearch.action.admin.cluster.shards.routing.weighted.delete.ClusterDeleteWeightedRoutingResponse;  
import org.opensearch.action.admin.indices.open.OpenIndexRequest;
        @Override  
        public void listTasks(final ListTasksRequest request, final ActionListener<ListTasksResponse> listener) {  
    }
    public void search(final SearchRequest request, final ActionListener<SearchResponse> listener) {  
    public void explain(ExplainRequest request, ActionListener<ExplainResponse> listener) {
        public GetIndexRequestBuilder prepareGetIndex() {
    }
import org.opensearch.action.admin.indices.get.GetIndexResponse;  
import org.opensearch.action.admin.indices.template.delete.DeleteIndexTemplateAction;  
            execute(ImportDanglingIndexAction.INSTANCE, request, listener);  
import org.opensearch.action.admin.cluster.repositories.get.GetRepositoriesAction;
        return admin;
import org.opensearch.action.admin.cluster.snapshots.create.CreateSnapshotResponse;  
        @Override
    public void bulk(final BulkRequest request, final ActionListener<BulkResponse> listener) {
        }
    @Override
import org.opensearch.action.update.UpdateRequestBuilder;  
        @Override  
        }
            return execute(RolloverAction.INSTANCE, request);  
        @Override
        public AnalyzeRequestBuilder prepareAnalyze(@Nullable String index, String text) {  
            execute(ClusterGetWeightedRoutingAction.INSTANCE, request, listener);  
        public ActionFuture<ValidateQueryResponse> validateQuery(final ValidateQueryRequest request) {  
        @Override  
        }
    @Override
        @Override
    @Override
            execute(GetRepositoriesAction.INSTANCE, request, listener);
        this.admin = new Admin(this);  
        /** Pause ingestion */
import org.opensearch.action.admin.indices.create.CreateIndexRequestBuilder;  
    }
import org.opensearch.action.admin.cluster.snapshots.status.SnapshotsStatusRequestBuilder;
            return new GetIndexRequestBuilder(this, GetIndexAction.INSTANCE);
        @Override
        execute(DeleteAction.INSTANCE, request, listener);
import org.opensearch.action.admin.cluster.settings.ClusterUpdateSettingsResponse;
        }  
import org.opensearch.action.admin.cluster.node.info.NodesInfoRequestBuilder;
        @Override
        @Override
        public ActionFuture<RestoreSnapshotResponse> restoreSnapshot(RestoreSnapshotRequest request) {
    }
import org.opensearch.action.admin.indices.template.get.GetIndexTemplatesResponse;  
        public void cancelTasks(CancelTasksRequest request, ActionListener<CancelTasksResponse> listener) {
            if (shardId != null) {  
        }  
        @Override  
        public ActionFuture<AcknowledgedResponse> aliases(final IndicesAliasesRequest request) {
    }
        return execute(MultiGetAction.INSTANCE, request);
        @Override  
 * You may obtain a copy of the License at  
        public GetMappingsRequestBuilder prepareGetMappings(String... indices) {  
            return new UpdateSettingsRequestBuilder(this, UpdateSettingsAction.INSTANCE).setIndices(indices);
        }  
        public ActionFuture<GetIndexTemplatesResponse> getTemplates(final GetIndexTemplatesRequest request) {  
import org.opensearch.action.index.IndexRequestBuilder;  
        }  
    }  
            return new ClusterSearchShardsRequestBuilder(this, ClusterSearchShardsAction.INSTANCE).setIndices(indices);  
import org.opensearch.action.admin.cluster.repositories.delete.DeleteRepositoryAction;
import org.opensearch.action.admin.cluster.repositories.delete.DeleteRepositoryRequestBuilder;  
        @Override
            return execute(ClearIndicesCacheAction.INSTANCE, request);
        public ActionFuture<GetDataStreamAction.Response> getDataStreams(GetDataStreamAction.Request request) {
        }
        }
import org.opensearch.action.bulk.BulkResponse;
        @Override
        public ActionFuture<ResumeIngestionResponse> resumeIngestion(final ResumeIngestionRequest request) {
        public ClusterSearchShardsRequestBuilder prepareSearchShards() {  
    }
        @Override
import org.opensearch.action.admin.indices.forcemerge.ForceMergeRequest;  
        @Override
        }  
        execute(SearchAction.INSTANCE, request, listener);
        execute(CreatePitAction.INSTANCE, createPITRequest, listener);
            execute(ListTasksAction.INSTANCE, request, listener);
        public NodesStatsRequestBuilder prepareNodesStats(String... nodesIds) {
import org.opensearch.action.admin.indices.alias.get.GetAliasesRequestBuilder;
            return new DeleteSnapshotRequestBuilder(this, DeleteSnapshotAction.INSTANCE, repository, names);  
        public void recoveries(final RecoveryRequest request, final ActionListener<RecoveryResponse> listener) {
    protected final Settings settings;
        }  
        public void decommission(DecommissionRequest request, ActionListener<DecommissionResponse> listener) {
import org.opensearch.core.common.bytes.BytesReference;
        public ActionFuture<RefreshResponse> refresh(final RefreshRequest request) {
        @Override  
import org.opensearch.action.admin.indices.readonly.AddIndexBlockRequest;
        }
        this.logger = LogManager.getLogger(this.getClass());
    ) {
        @Override  
import org.opensearch.action.admin.cluster.node.tasks.delete.DeleteTaskRequest;
        }
        public void deleteWeightedRouting(
        return new BulkRequestBuilder(this, BulkAction.INSTANCE, globalIndex);
        /** Get ingestion state */
            return clusterAdmin;  
        public ActionFuture<CancelTasksResponse> cancelTasks(CancelTasksRequest request) {
        }
 * KIND, either express or implied.  See the License for the
import org.opensearch.action.fieldcaps.FieldCapabilitiesResponse;
        }  
        public ActionFuture<ClusterDeleteWeightedRoutingResponse> deleteWeightedRouting(ClusterDeleteWeightedRoutingRequest request) {  
        }  
import org.opensearch.action.admin.cluster.node.tasks.get.GetTaskRequestBuilder;  
        public void verifyRepository(VerifyRepositoryRequest request, ActionListener<VerifyRepositoryResponse> listener) {  
                ) {  
    @Override
    public void clearScroll(ClearScrollRequest request, ActionListener<ClearScrollResponse> listener) {
            return client.threadPool();  
import org.opensearch.action.admin.indices.get.GetIndexRequest;
            return execute(ClusterDeleteWeightedRoutingAction.INSTANCE, request);
        @Override  
        }  
            execute(NodesUsageAction.INSTANCE, request, listener);
     */
        @Override
import org.opensearch.action.admin.cluster.node.tasks.list.ListTasksRequest;  
import org.opensearch.action.admin.indices.streamingingestion.pause.PauseIngestionAction;  
        @Override
    public ActionFuture<GetResponse> get(final GetRequest request) {
        }
import org.opensearch.action.admin.cluster.node.reload.NodesReloadSecureSettingsRequestBuilder;
 * GitHub history for details.
    public final ThreadPool threadPool() {
    public GetRequestBuilder prepareGet(String index, String id) {
        public void deleteTask(DeleteTaskRequest request, ActionListener<AcknowledgedResponse> listener) {
            execute(PutMappingAction.INSTANCE, request, listener);
import org.opensearch.action.admin.indices.cache.clear.ClearIndicesCacheRequestBuilder;
        }  
import org.opensearch.action.admin.indices.shrink.ResizeAction;
import org.opensearch.action.admin.cluster.snapshots.restore.RestoreSnapshotRequestBuilder;
            return new NodesInfoRequestBuilder(this, NodesInfoAction.INSTANCE).setNodesIds(nodesIds);
        public void getIndex(GetIndexRequest request, ActionListener<GetIndexResponse> listener) {
            return prepareDeleteStoredScript().setId(id);
import org.opensearch.action.admin.indices.streamingingestion.resume.ResumeIngestionResponse;
            execute(PauseIngestionAction.INSTANCE, request, listener);
import org.opensearch.action.admin.indices.delete.DeleteIndexRequestBuilder;
import org.opensearch.action.admin.cluster.storedscripts.GetStoredScriptRequest;
        public void getTemplates(final GetIndexTemplatesRequest request, final ActionListener<GetIndexTemplatesResponse> listener) {
        public ActionFuture<GetTaskResponse> getTask(final GetTaskRequest request) {
    @Override  
import org.opensearch.action.admin.cluster.reroute.ClusterRerouteRequest;
    @Override  
import org.opensearch.action.search.GetSearchPipelineRequest;
import org.opensearch.action.fieldcaps.FieldCapabilitiesRequest;
    @Override
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.action.admin.indices.refresh.RefreshRequestBuilder;
        doExecute(action, request, listener);
        }
import org.opensearch.action.admin.cluster.health.ClusterHealthAction;  
        }
import org.opensearch.action.admin.indices.mapping.get.GetMappingsAction;
        }  
import org.opensearch.action.search.MultiSearchAction;
            return execute(CancelTasksAction.INSTANCE, request);  
        @Override  
    @Override
        }
            execute(WlmStatsAction.INSTANCE, request, listener);
        }
        @Override  
import org.opensearch.action.admin.cluster.snapshots.restore.RestoreSnapshotResponse;
import org.opensearch.action.admin.indices.flush.FlushRequestBuilder;  
import org.opensearch.action.admin.cluster.decommission.awareness.get.GetDecommissionStateRequestBuilder;  
        public void analyze(final AnalyzeAction.Request request, final ActionListener<AnalyzeAction.Response> listener) {
import org.opensearch.action.admin.indices.upgrade.post.UpgradeRequest;  
        @Override
        public ActionFuture<CloseIndexResponse> close(final CloseIndexRequest request) {
        }
            return execute(DeleteDataStreamAction.INSTANCE, request);
        @Override
        }
        }
        public ActionFuture<GetSettingsResponse> getSettings(GetSettingsRequest request) {  
            return new UpgradeStatusRequestBuilder(this, UpgradeStatusAction.INSTANCE).setIndices(indices);
        public ActionFuture<UpgradeResponse> upgrade(final UpgradeRequest request) {
        }  
        public ActionFuture<GetDecommissionStateResponse> getDecommissionState(GetDecommissionStateRequest request) {  
import org.opensearch.action.search.CreatePitResponse;
        @Override
import org.opensearch.action.admin.indices.alias.IndicesAliasesRequest;  
        private final OpenSearchClient client;
        public ActionFuture<ClusterHealthResponse> health(final ClusterHealthRequest request) {
        public void segments(final IndicesSegmentsRequest request, final ActionListener<IndicesSegmentResponse> listener) {
        public <Request extends ActionRequest, Response extends ActionResponse> ActionFuture<Response> execute(  
            return execute(IndicesStatsAction.INSTANCE, request);  
        @Override
        }
import org.opensearch.cluster.metadata.IndexMetadata.APIBlock;
        }
        @Override
        }  
        }
import org.opensearch.action.admin.indices.template.delete.DeleteIndexTemplateRequest;
            return execute(CreateSnapshotAction.INSTANCE, request);
            return execute(CreateIndexAction.INSTANCE, request);
            return execute(UpdateSettingsAction.INSTANCE, request);  
        }
        public ClusterStatsRequestBuilder prepareClusterStats() {
import org.opensearch.action.admin.indices.close.CloseIndexResponse;  
        }
        public void searchShards(final ClusterSearchShardsRequest request, final ActionListener<ClusterSearchShardsResponse> listener) {
            execute(ClusterUpdateSettingsAction.INSTANCE, request, listener);
        public void cleanupRepository(CleanupRepositoryRequest request, ActionListener<CleanupRepositoryResponse> listener) {
import org.opensearch.action.admin.cluster.repositories.get.GetRepositoriesResponse;
        public ThreadPool threadPool() {
        }
            return new DeletePipelineRequestBuilder(this, DeletePipelineAction.INSTANCE);
        public DeleteIndexRequestBuilder prepareDelete(String... indices) {
import org.opensearch.action.search.SearchAction;
        return new DeleteRequestBuilder(this, DeleteAction.INSTANCE, null);  
import org.opensearch.action.admin.indices.mapping.put.PutMappingRequestBuilder;
        @Override  
import org.opensearch.action.admin.cluster.repositories.verify.VerifyRepositoryResponse;
            return new ScaleIndexRequestBuilder(this, searchOnly, index);
        return execute(GetAction.INSTANCE, request);  
        @Override
        }  
import org.opensearch.action.ingest.GetPipelineRequestBuilder;
import org.opensearch.action.admin.cluster.storedscripts.GetStoredScriptRequestBuilder;
        @Override  
        @Override  
        public void putMapping(final PutMappingRequest request, final ActionListener<AcknowledgedResponse> listener) {
        @Override  
import org.opensearch.action.admin.cluster.wlm.WlmStatsAction;
import org.opensearch.action.search.GetSearchPipelineAction;
import org.opensearch.action.admin.cluster.remotestore.stats.RemoteStoreStatsRequest;  
        @Override  
            return new SegmentReplicationStatsRequestBuilder(this, SegmentReplicationStatsAction.INSTANCE).setIndices(indices);
        }  
        public ActionFuture<FlushResponse> flush(final FlushRequest request) {
        public void getAliases(GetAliasesRequest request, ActionListener<GetAliasesResponse> listener) {  
import org.opensearch.action.search.SearchScrollRequestBuilder;
        }  
    }
        }
 * @opensearch.internal
            return execute(SimulatePipelineAction.INSTANCE, request);
            return new GetMappingsRequestBuilder(this, GetMappingsAction.INSTANCE, indices);
import org.opensearch.action.admin.cluster.node.tasks.get.GetTaskAction;
            final ActionListener<RemoteStoreMetadataResponse> listener  
        }
            execute(ValidateQueryAction.INSTANCE, request, listener);  
        }  
        }
        @Override  
        }
import org.opensearch.action.admin.cluster.shards.routing.weighted.get.ClusterGetWeightedRoutingAction;
            return execute(OpenIndexAction.INSTANCE, request);
        public GetDecommissionStateRequestBuilder prepareGetDecommissionState() {
import org.opensearch.action.search.SearchScrollAction;
            return new GetSnapshotsRequestBuilder(this, GetSnapshotsAction.INSTANCE, repository);  
        }  
    }
        @Override
import org.opensearch.action.admin.indices.settings.put.UpdateSettingsRequest;
        @Override
        }
        @Override  
import org.opensearch.action.admin.cluster.snapshots.get.GetSnapshotsResponse;
        @Override  
 * software distributed under the License is distributed on an
        }  
import org.opensearch.action.admin.cluster.node.tasks.list.ListTasksRequestBuilder;
            return new SnapshotsStatusRequestBuilder(this, SnapshotsStatusAction.INSTANCE, repository);
        public void create(final CreateIndexRequest request, final ActionListener<CreateIndexResponse> listener) {  
    }
        @Override
        @Override  
        @Override
        public DeletePipelineRequestBuilder prepareDeletePipeline(String id) {
            return execute(ResumeIngestionAction.INSTANCE, request);
/*  
        public ActionFuture<ClusterGetWeightedRoutingResponse> getWeightedRouting(ClusterGetWeightedRoutingRequest request) {  
import org.opensearch.action.search.GetAllPitsAction;  
        public void allocationExplain(ClusterAllocationExplainRequest request, ActionListener<ClusterAllocationExplainResponse> listener) {
        @Override
        }  
import org.opensearch.action.admin.indices.readonly.AddIndexBlockAction;
        @Override
        }
        }
    public ActionFuture<IndexResponse> index(final IndexRequest request) {  
        }
        }  
import org.opensearch.action.admin.cluster.node.hotthreads.NodesHotThreadsRequestBuilder;  
        public ActionFuture<IndicesSegmentResponse> segments(final IndicesSegmentsRequest request) {
        @Override  
import org.opensearch.core.tasks.TaskId;
        @Override
        public DeleteSnapshotRequestBuilder prepareDeleteSnapshot(String repository, String... names) {
            return execute(PutIndexTemplateAction.INSTANCE, request);
import org.opensearch.action.bulk.BulkRequest;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            return new GetStoredScriptRequestBuilder(this, GetStoredScriptAction.INSTANCE);  
        @Override
            execute(DeleteIndexAction.INSTANCE, request, listener);
import org.opensearch.action.admin.cluster.repositories.verify.VerifyRepositoryAction;
            return new CloseIndexRequestBuilder(this, CloseIndexAction.INSTANCE, indices);  
            return execute(GetIngestionStateAction.INSTANCE, request);
    public ActionFuture<DeleteResponse> delete(final DeleteRequest request) {
        public ActionFuture<AcknowledgedResponse> deleteDataStream(DeleteDataStreamAction.Request request) {
        public AnalyzeRequestBuilder prepareAnalyze(String text) {
            execute(IndicesExistsAction.INSTANCE, request, listener);
    ) {
        }
        }
        }  
import org.opensearch.action.admin.cluster.node.hotthreads.NodesHotThreadsRequest;
        @Override  
import org.opensearch.action.admin.indices.datastream.DeleteDataStreamAction;
    }
    }
package org.opensearch.transport.client.support;
        public void deleteSnapshot(DeleteSnapshotRequest request, ActionListener<AcknowledgedResponse> listener) {  
        @Override
import org.opensearch.action.admin.indices.shards.IndicesShardStoresRequest;
import org.opensearch.action.ingest.PutPipelineRequestBuilder;
        public void wlmStats(final WlmStatsRequest request, final ActionListener<WlmStatsResponse> listener) {  
import org.opensearch.action.admin.indices.analyze.AnalyzeAction;  
import org.opensearch.action.admin.indices.streamingingestion.resume.ResumeIngestionAction;  
import org.opensearch.action.admin.indices.flush.FlushRequest;
        @Override
import org.opensearch.action.admin.indices.mapping.put.PutMappingAction;  
        public ActionFuture<ClusterAllocationExplainResponse> allocationExplain(ClusterAllocationExplainRequest request) {  
import org.opensearch.action.admin.indices.template.put.PutIndexTemplateAction;
import org.opensearch.action.search.MultiSearchResponse;
        ActionType<Response> action,  
        public DeleteDecommissionStateRequestBuilder prepareDeleteDecommissionRequest() {
            return new AnalyzeRequestBuilder(this, AnalyzeAction.INSTANCE);
        public NodesHotThreadsRequestBuilder prepareNodesHotThreads(String... nodesIds) {
        @Override  
        public void cloneSnapshot(CloneSnapshotRequest request, ActionListener<AcknowledgedResponse> listener) {
        }
            Request request
        public ActionFuture<UpgradeStatusResponse> upgradeStatus(final UpgradeStatusRequest request) {
        }
    public void get(final GetRequest request, final ActionListener<GetResponse> listener) {
        public ForceMergeRequestBuilder prepareForceMerge(String... indices) {  
        public ActionFuture<AcknowledgedResponse> updateSettings(final UpdateSettingsRequest request) {
        @Override  
        }  
import org.opensearch.action.admin.indices.dangling.delete.DeleteDanglingIndexAction;
    @Override  
        ) {
import org.opensearch.action.admin.indices.upgrade.post.UpgradeResponse;
        public void validateQuery(final ValidateQueryRequest request, final ActionListener<ValidateQueryResponse> listener) {
        public ActionFuture<IndicesShardStoresResponse> shardStores(IndicesShardStoresRequest request) {
        public ActionFuture<AcknowledgedResponse> putTemplate(final PutIndexTemplateRequest request) {  
    @Override
        }
        }
            return new PendingClusterTasksRequestBuilder(this, PendingClusterTasksAction.INSTANCE);
     * This is the single execution point of *all* clients.  
import org.opensearch.action.admin.indices.create.CreateIndexRequest;
    public DeleteRequestBuilder prepareDelete() {
        }
import org.opensearch.action.admin.indices.mapping.get.GetFieldMappingsRequestBuilder;  
        }
        }
            execute(OpenIndexAction.INSTANCE, request, listener);
    public final Settings settings() {
        Admin(OpenSearchClient client) {
        public void aliases(final IndicesAliasesRequest request, final ActionListener<AcknowledgedResponse> listener) {  
        ActionType<Response> action,  
    @Override
    public ActionFuture<FieldCapabilitiesResponse> fieldCaps(FieldCapabilitiesRequest request) {  
        public RecoveryRequestBuilder prepareRecoveries(String... indices) {  
            return execute(RestoreSnapshotAction.INSTANCE, request);
            return new DecommissionRequestBuilder(this, DecommissionAction.INSTANCE, request);
        public ActionFuture<AcknowledgedResponse> putStoredScript(final PutStoredScriptRequest request) {
        }
        @Override
            ActionListener<ClusterPutWeightedRoutingResponse> listener
import org.opensearch.action.admin.cluster.node.info.NodesInfoResponse;
import org.opensearch.action.admin.indices.mapping.get.GetMappingsRequestBuilder;
        }  
        }
    }
        }  
            execute(NodesStatsAction.INSTANCE, request, listener);  
 * specific language governing permissions and limitations
    }
import org.opensearch.action.explain.ExplainRequestBuilder;
    @Override
            execute(RestoreSnapshotAction.INSTANCE, request, listener);
import org.opensearch.action.delete.DeleteRequest;  
        public CreateSnapshotRequestBuilder prepareCreateSnapshot(String repository, String name) {
import org.opensearch.action.admin.cluster.storedscripts.PutStoredScriptRequest;
import org.opensearch.action.admin.indices.refresh.RefreshResponse;  
        public void open(final OpenIndexRequest request, final ActionListener<OpenIndexResponse> listener) {  
        public ActionFuture<NodesHotThreadsResponse> nodesHotThreads(NodesHotThreadsRequest request) {
        public ActionFuture<VerifyRepositoryResponse> verifyRepository(VerifyRepositoryRequest request) {
import org.opensearch.action.search.SearchRequest;
            execute(IndicesAliasesAction.INSTANCE, request, listener);
        @Override  
import org.opensearch.action.search.CreatePitRequest;  
        }
import org.opensearch.action.admin.indices.rollover.RolloverResponse;  
 *
            execute(NodesInfoAction.INSTANCE, request, listener);  
            return new GetAliasesRequestBuilder(this, GetAliasesAction.INSTANCE, aliases);  
        @Override  
            ActionType<Response> action,  
        public ActionFuture<GetMappingsResponse> getMappings(GetMappingsRequest request) {
        @Override  
        public CleanupRepositoryRequestBuilder prepareCleanupRepository(String repository) {
        execute(action, request, actionFuture);
        }
    }
        public ThreadPool threadPool() {
        }
        @Override
        private final IndicesAdmin indicesAdmin;  
        @Override
        @Override
        return execute(MultiTermVectorsAction.INSTANCE, request);
import org.opensearch.action.search.GetSearchPipelineResponse;  
            return execute(GetFieldMappingsAction.INSTANCE, request);
 */
import org.opensearch.action.admin.indices.settings.put.UpdateSettingsAction;  
    }  
        public void stats(final IndicesStatsRequest request, final ActionListener<IndicesStatsResponse> listener) {
        public PutRepositoryRequestBuilder preparePutRepository(String name) {
        @Override
    @Override
            return client.execute(action, request);
import org.opensearch.action.admin.cluster.settings.ClusterUpdateSettingsAction;
        public ActionFuture<NodesInfoResponse> nodesInfo(final NodesInfoRequest request) {  
        IndicesAdmin(OpenSearchClient client) {
        public ClusterAllocationExplainRequestBuilder prepareAllocationExplain() {
            return new ValidateQueryRequestBuilder(this, ValidateQueryAction.INSTANCE).setIndices(indices);
    }  
        @Override  
            return execute(DeleteIndexTemplateAction.INSTANCE, request);
        @Override  
        }  
        return new SearchRequestBuilder(this, StreamSearchAction.INSTANCE).setIndices(indices);
import org.opensearch.action.admin.cluster.snapshots.restore.RestoreSnapshotAction;
    @Override
        }
import org.opensearch.action.admin.cluster.remotestore.stats.RemoteStoreStatsAction;
import org.opensearch.action.update.UpdateAction;
import org.opensearch.action.admin.indices.shards.IndicesShardStoresResponse;  
    @Override  
            return new DeleteTaskRequestBuilder(this, DeleteTaskAction.INSTANCE).setTaskId(taskId);
            return new AddIndexBlockRequestBuilder(this, AddIndexBlockAction.INSTANCE, block, indices);  
        public void getIngestionState(final GetIngestionStateRequest request, final ActionListener<GetIngestionStateResponse> listener) {
        @Override  
        }
        @Override
            execute(ClearIndicesCacheAction.INSTANCE, request, listener);
import org.opensearch.action.admin.indices.template.get.GetIndexTemplatesAction;  
import org.opensearch.action.search.ClearScrollAction;
import org.opensearch.action.admin.cluster.storedscripts.DeleteStoredScriptAction;  
        execute(IndexAction.INSTANCE, request, listener);  
        @Override  
        @Override
            return execute(ClusterStateAction.INSTANCE, request);
    @Override
import org.opensearch.action.admin.indices.dangling.import_index.ImportDanglingIndexRequest;
import org.opensearch.action.search.SearchScrollRequest;  
import org.opensearch.action.admin.cluster.tasks.PendingClusterTasksAction;
        }
        @Override
import org.opensearch.action.explain.ExplainAction;  
            return execute(GetSettingsAction.INSTANCE, request);
        @Override
        }  
    }  
        @Override  
    }  
    public final AdminClient admin() {  
        @Override  
import org.opensearch.action.admin.indices.mapping.get.GetMappingsResponse;
    @Override
import org.opensearch.action.admin.indices.refresh.RefreshAction;  
        @Override
import org.apache.logging.log4j.LogManager;
            return execute(GetDecommissionStateAction.INSTANCE, request);
            execute(ClusterHealthAction.INSTANCE, request, listener);
        @Override
            return execute(UpgradeStatusAction.INSTANCE, request);  
import org.opensearch.action.search.SearchResponse;
        }  
        }
            return execute(ResolveIndexAction.INSTANCE, request);
import org.opensearch.action.admin.cluster.tasks.PendingClusterTasksResponse;
        @Override  
        }
import org.opensearch.action.bulk.BulkRequestBuilder;  
        public ActionFuture<CreateIndexResponse> create(final CreateIndexRequest request) {
        @Override
import org.opensearch.action.admin.cluster.allocation.ClusterAllocationExplainAction;
import org.opensearch.action.admin.cluster.snapshots.delete.DeleteSnapshotRequestBuilder;  
import org.opensearch.action.get.GetRequest;  
        }
import org.opensearch.action.admin.indices.readonly.AddIndexBlockResponse;
    @Override  
import org.opensearch.action.admin.cluster.stats.ClusterStatsResponse;
import org.opensearch.action.admin.indices.replication.SegmentReplicationStatsAction;
import org.opensearch.action.ingest.SimulatePipelineAction;  
        execute(MultiSearchAction.INSTANCE, request, listener);
        @Override  
        public ActionFuture<ClusterSearchShardsResponse> searchShards(final ClusterSearchShardsRequest request) {
            RemoteStoreMetadataRequestBuilder builder = new RemoteStoreMetadataRequestBuilder(this, RemoteStoreMetadataAction.INSTANCE)
    @Override  
        return execute(SearchScrollAction.INSTANCE, request);
        }  
            return new NodesUsageRequestBuilder(this, NodesUsageAction.INSTANCE).setNodesIds(nodesIds);  
import org.opensearch.action.admin.cluster.shards.ClusterSearchShardsResponse;
        return execute(IndexAction.INSTANCE, request);
            Request request
        }
        public AddIndexBlockRequestBuilder prepareAddBlock(APIBlock block, String... indices) {
        @Override
import org.opensearch.action.admin.cluster.node.tasks.cancel.CancelTasksRequestBuilder;
    public MultiSearchRequestBuilder prepareMultiSearch() {  
        @Override  
        }  
        }  
        }
        }
        public void deleteDanglingIndex(DeleteDanglingIndexRequest request, ActionListener<AcknowledgedResponse> listener) {  
import org.opensearch.action.termvectors.MultiTermVectorsRequest;  
        @Override
        @Override
        @Override
        @Override
    public AbstractClient(Settings settings, ThreadPool threadPool) {  
        public RolloverRequestBuilder prepareRolloverIndex(String alias) {  
        }  
                builder.setShards(shardId);
        @Override
        public ActionFuture<NodesStatsResponse> nodesStats(final NodesStatsRequest request) {  
            return execute(DeleteSearchPipelineAction.INSTANCE, request);
            execute(AnalyzeAction.INSTANCE, request, listener);
            execute(GetPipelineAction.INSTANCE, request, listener);
        public void close(final CloseIndexRequest request, final ActionListener<CloseIndexResponse> listener) {  
        }
        public ActionFuture<GetIndexResponse> getIndex(GetIndexRequest request) {  
            return execute(GetSnapshotsAction.INSTANCE, request);
        @Override
            execute(PendingClusterTasksAction.INSTANCE, request, listener);  
        @Override
            this.client = client;
    public TermVectorsRequestBuilder prepareTermVectors() {  
        execute(BulkAction.INSTANCE, request, listener);  
 * Base client used to create concrete client implementations  
        public void getWeightedRouting(
    public final <Request extends ActionRequest, Response extends ActionResponse> ActionFuture<Response> execute(
    }
import org.opensearch.action.admin.cluster.reroute.ClusterRerouteAction;  
        @Override
import org.opensearch.action.admin.indices.streamingingestion.resume.ResumeIngestionRequest;
            execute(DeleteDecommissionStateAction.INSTANCE, request, listener);  
        }
            execute(GetFieldMappingsAction.INSTANCE, request, listener);
            ActionListener<DeleteDecommissionStateResponse> listener
        @Override  
            return new ListTasksRequestBuilder(this, ListTasksAction.INSTANCE).setNodesIds(nodesIds);  
        execute(MultiTermVectorsAction.INSTANCE, request, listener);
                .setIndices(index);
        @Override  
            return prepareGetStoredScript().setId(id);
    @Override  
        @Override
        }  
import org.opensearch.common.action.ActionFuture;
import org.opensearch.action.admin.indices.open.OpenIndexRequestBuilder;
        }  
                remoteStoreStatsRequestBuilder.setShards(shardId);
        }
import org.opensearch.action.admin.cluster.remotestore.stats.RemoteStoreStatsResponse;
        public void createDataStream(CreateDataStreamAction.Request request, ActionListener<AcknowledgedResponse> listener) {
            return execute(ClusterStatsAction.INSTANCE, request);
        @Override  
            return execute(GetTaskAction.INSTANCE, request);
        public DeleteRepositoryRequestBuilder prepareDeleteRepository(String name) {
            ActionListener<ClusterGetWeightedRoutingResponse> listener
import org.opensearch.action.admin.indices.dangling.list.ListDanglingIndicesAction;  
        }
import org.opensearch.action.admin.indices.create.CreateIndexAction;
        }
        public ClusterStateRequestBuilder prepareState() {
            return execute(PutMappingAction.INSTANCE, request);  
        @Override
        public ClusterAdminClient cluster() {
import org.opensearch.action.admin.indices.settings.get.GetSettingsRequestBuilder;
        public DeleteTaskRequestBuilder prepareDeleteTask(String taskId) {
        @Override
            execute(CleanupRepositoryAction.INSTANCE, request, listener);  
        }  
import org.opensearch.action.admin.cluster.node.stats.NodesStatsRequest;  
        }  
import org.opensearch.action.admin.cluster.storedscripts.PutStoredScriptRequestBuilder;  
        public void state(final ClusterStateRequest request, final ActionListener<ClusterStateResponse> listener) {  
        }  
import org.opensearch.action.admin.indices.shrink.ResizeResponse;
        execute(ClearScrollAction.INSTANCE, request, listener);
import org.opensearch.action.admin.indices.settings.get.GetSettingsAction;
            ActionType<Response> action,  
import org.opensearch.action.admin.indices.mapping.put.PutMappingRequest;
        }  
    @Override
    public GetRequestBuilder prepareGet() {  
        @Override
import org.opensearch.threadpool.ThreadPool;
        @Override  
        @Override
            return new AnalyzeRequestBuilder(this, AnalyzeAction.INSTANCE, null, text);  
                ActionListener<Response> listener
import org.opensearch.action.ingest.SimulatePipelineResponse;  
        public ActionFuture<AcknowledgedResponse> putPipeline(PutPipelineRequest request) {
        }  
        return new IndexRequestBuilder(this, IndexAction.INSTANCE, index);
            execute(AddIndexBlockAction.INSTANCE, request, listener);
        public GetPipelineRequestBuilder prepareGetPipeline(String... ids) {
        @Override
            return new ClusterDeleteWeightedRoutingRequestBuilder(this, ClusterDeleteWeightedRoutingAction.INSTANCE);
            return new RefreshRequestBuilder(this, RefreshAction.INSTANCE).setIndices(indices);
            execute(DeleteDataStreamAction.INSTANCE, request, listener);  
            execute(RolloverAction.INSTANCE, request, listener);
import org.opensearch.action.explain.ExplainResponse;  
        public void deletePipeline(DeletePipelineRequest request, ActionListener<AcknowledgedResponse> listener) {
import org.opensearch.action.admin.indices.upgrade.get.UpgradeStatusRequestBuilder;  
        @Override  
import org.opensearch.action.admin.indices.template.delete.DeleteIndexTemplateRequestBuilder;
import org.opensearch.action.admin.cluster.shards.routing.weighted.delete.ClusterDeleteWeightedRoutingAction;  
            return prepareGetTask(new TaskId(taskId));  
        }
        public ActionFuture<CleanupRepositoryResponse> cleanupRepository(CleanupRepositoryRequest request) {  
import org.opensearch.action.admin.cluster.decommission.awareness.delete.DeleteDecommissionStateRequest;
import org.opensearch.action.admin.cluster.node.usage.NodesUsageRequestBuilder;
            return new IndicesStatsRequestBuilder(this, IndicesStatsAction.INSTANCE).setIndices(indices);
        return new MultiSearchRequestBuilder(this, MultiSearchAction.INSTANCE);
            return execute(GetAliasesAction.INSTANCE, request);
    }
    @Override
        }
        public DeleteStoredScriptRequestBuilder prepareDeleteStoredScript() {
import org.opensearch.action.admin.cluster.node.tasks.delete.DeleteTaskRequestBuilder;  
import org.opensearch.action.admin.cluster.node.usage.NodesUsageAction;  
        @Override  
        public GetSnapshotsRequestBuilder prepareGetSnapshots(String repository) {
            execute(IndicesSegmentsAction.INSTANCE, request, listener);
        @Override
        execute(DeletePitAction.INSTANCE, deletePITRequest, listener);  
        public GetAliasesRequestBuilder prepareGetAliases(String... aliases) {
    public DeleteRequestBuilder prepareDelete(String index, String id) {
import org.opensearch.action.admin.indices.streamingingestion.pause.PauseIngestionRequest;
    @Override
            return execute(PutStoredScriptAction.INSTANCE, request);  
            execute(GetSettingsAction.INSTANCE, request, listener);  
        return execute(SearchAction.INSTANCE, request);
    }
import org.opensearch.action.admin.indices.get.GetIndexAction;  
            execute(GetSearchPipelineAction.INSTANCE, request, listener);
import org.opensearch.action.admin.cluster.decommission.awareness.put.DecommissionRequestBuilder;
        }  
            return new IndicesExistsRequestBuilder(this, IndicesExistsAction.INSTANCE, indices);  
import org.opensearch.action.admin.cluster.tasks.PendingClusterTasksRequest;
            return execute(DeletePipelineAction.INSTANCE, request);
        public void pauseIngestion(final PauseIngestionRequest request, final ActionListener<PauseIngestionResponse> listener) {
        @Override  
        }  
        @Override
import org.opensearch.common.util.concurrent.ThreadContextAccess;
    public SearchScrollRequestBuilder prepareSearchScroll(String scrollId) {
import org.opensearch.action.admin.indices.shrink.ResizeRequestBuilder;  
        }
        public void createSnapshot(CreateSnapshotRequest request, ActionListener<CreateSnapshotResponse> listener) {  
            return execute(IndicesSegmentsAction.INSTANCE, request);  
        }
            return execute(IndicesShardStoresAction.INSTANCE, request);  
import org.opensearch.action.admin.cluster.stats.ClusterStatsRequest;  
import org.opensearch.action.termvectors.TermVectorsResponse;  
        public PutIndexTemplateRequestBuilder preparePutTemplate(String name) {
            return new RecoveryRequestBuilder(this, RecoveryAction.INSTANCE).setIndices(indices);
            execute(DeleteSnapshotAction.INSTANCE, request, listener);
        }  
            return execute(AnalyzeAction.INSTANCE, request);  
        @Override
        public DecommissionRequestBuilder prepareDecommission(DecommissionRequest request) {
import org.opensearch.action.admin.cluster.stats.ClusterStatsAction;
    @Override  
        @Override
    @Override
import org.opensearch.action.search.PutSearchPipelineAction;
                Request request,  
    @Override
            return execute(NodesInfoAction.INSTANCE, request);
import org.opensearch.action.get.MultiGetRequestBuilder;
    }  
        }
        }
 * not use this file except in compliance with the License.
            return execute(ClusterSearchShardsAction.INSTANCE, request);  
            execute(ListDanglingIndicesAction.INSTANCE, request, listener);
        }
    public UpdateRequestBuilder prepareUpdate() {  
            return new ClusterSearchShardsRequestBuilder(this, ClusterSearchShardsAction.INSTANCE);
        ActionListener<Response> listener
import org.opensearch.action.admin.cluster.decommission.awareness.delete.DeleteDecommissionStateRequestBuilder;
        public ActionFuture<DeleteDecommissionStateResponse> deleteDecommissionState(DeleteDecommissionStateRequest request) {  
import org.opensearch.action.admin.cluster.repositories.verify.VerifyRepositoryRequestBuilder;
        }
        }
        public ScaleIndexRequestBuilder prepareScaleSearchOnly(String index, boolean searchOnly) {
        @Override
import org.opensearch.action.search.DeletePitAction;
            execute(ResolveIndexAction.INSTANCE, request, listener);
        public RemoteStoreMetadataRequestBuilder prepareRemoteStoreMetadata(String index, String shardId) {  
        }
import org.opensearch.action.admin.indices.streamingingestion.state.GetIngestionStateResponse;
            return new IndicesAliasesRequestBuilder(this, IndicesAliasesAction.INSTANCE);  
    public SearchRequestBuilder prepareStreamSearch(String... indices) {
        }  
        public ActionFuture<ResizeResponse> resizeIndex(ResizeRequest request) {
        }
import org.opensearch.action.admin.cluster.snapshots.clone.CloneSnapshotRequestBuilder;
import org.opensearch.action.admin.cluster.node.tasks.delete.DeleteTaskAction;
 * ownership. Elasticsearch licenses this file to you under  
        }
        public ActionFuture<AcknowledgedResponse> deleteStoredScript(DeleteStoredScriptRequest request) {  
        @Override
import org.opensearch.action.admin.cluster.node.stats.NodesStatsResponse;
        public ActionFuture<ClearIndicesCacheResponse> clearCache(final ClearIndicesCacheRequest request) {
            ).setIndices(index);
    @Override  
        execute(TermVectorsAction.INSTANCE, request, listener);
        public void addBlock(AddIndexBlockRequest request, ActionListener<AddIndexBlockResponse> listener) {
import org.opensearch.action.admin.indices.segments.PitSegmentsRequest;
import org.opensearch.action.admin.cluster.snapshots.restore.RestoreSnapshotRequest;  
        public ActionFuture<AcknowledgedResponse> createDataStream(CreateDataStreamAction.Request request) {  
        @Override
import org.opensearch.action.admin.cluster.node.tasks.list.ListTasksAction;
    /**
    public UpdateRequestBuilder prepareUpdate(String index, String id) {
        @Override
        public void restoreRemoteStore(RestoreRemoteStoreRequest request, ActionListener<RestoreRemoteStoreResponse> listener) {
 * Licensed to Elasticsearch under one or more contributor  
        @Override  
        @Override
        public ActionFuture<ClusterUpdateSettingsResponse> updateSettings(final ClusterUpdateSettingsRequest request) {
        @Override  
import org.opensearch.action.admin.cluster.reroute.ClusterRerouteRequestBuilder;
        @Override  
            return execute(CleanupRepositoryAction.INSTANCE, request);
    }
/**
            execute(ClusterAllocationExplainAction.INSTANCE, request, listener);
            return execute(UpgradeAction.INSTANCE, request);  
        }  
            return new ClearIndicesCacheRequestBuilder(this, ClearIndicesCacheAction.INSTANCE).setIndices(indices);  
        }
 * compatible open source license.
import org.opensearch.action.admin.indices.dangling.delete.DeleteDanglingIndexRequest;  
        public void simulatePipeline(SimulatePipelineRequest request, ActionListener<SimulatePipelineResponse> listener) {
    );  
        @Override
    public MultiTermVectorsRequestBuilder prepareMultiTermVectors() {
            execute(ForceMergeAction.INSTANCE, request, listener);
        @Override
import org.opensearch.action.admin.indices.upgrade.post.UpgradeAction;
            ActionListener<ClusterDeleteWeightedRoutingResponse> listener
        }
        public void getDecommissionState(GetDecommissionStateRequest request, ActionListener<GetDecommissionStateResponse> listener) {
import org.opensearch.action.admin.cluster.node.hotthreads.NodesHotThreadsAction;
    }
        @Override  
        PlainActionFuture<Response> actionFuture = PlainActionFuture.newFuture();  
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;
        public void upgradeStatus(final UpgradeStatusRequest request, final ActionListener<UpgradeStatusResponse> listener) {
        public DeleteStoredScriptRequestBuilder prepareDeleteStoredScript(String id) {
import org.opensearch.action.admin.indices.template.get.GetIndexTemplatesRequest;
import org.opensearch.action.admin.indices.settings.get.GetSettingsRequest;  
            if (shardId != null) {  
import org.opensearch.action.ActionType;
        @Override
import org.opensearch.action.admin.cluster.settings.ClusterUpdateSettingsRequestBuilder;  
            this.clusterAdmin = new ClusterAdmin(client);  
import org.opensearch.action.admin.cluster.shards.routing.weighted.put.ClusterPutWeightedRoutingRequest;  
        @Override
        @Override
    }
import org.opensearch.action.admin.cluster.settings.ClusterUpdateSettingsRequest;
        @Override  
            return execute(PauseIngestionAction.INSTANCE, request);
        @Override  
        @Override
            execute(GetDecommissionStateAction.INSTANCE, request, listener);  
        public ActionFuture<IndicesExistsResponse> exists(final IndicesExistsRequest request) {
        @Override  
        @Override
    @Override
        @Override
            return new CreateIndexRequestBuilder(this, CreateIndexAction.INSTANCE, index);  
                    super.doExecute(action, request, listener);
    @Override  
import org.opensearch.action.termvectors.MultiTermVectorsRequestBuilder;
        public CancelTasksRequestBuilder prepareCancelTasks(String... nodesIds) {  
        }
import org.opensearch.transport.client.ClusterAdminClient;
        }  
        public ClusterDeleteWeightedRoutingRequestBuilder prepareDeleteWeightedRouting() {
        public GetTaskRequestBuilder prepareGetTask(String taskId) {
        @Override
        }
        return execute(TermVectorsAction.INSTANCE, request);  
import org.opensearch.action.admin.indices.upgrade.post.UpgradeRequestBuilder;
        @Override
        @Override
        public GetRepositoriesRequestBuilder prepareGetRepositories(String... name) {
        @Override
    }
import org.opensearch.common.settings.Settings;
    @Override  
        }  
import org.opensearch.action.admin.cluster.node.info.NodesInfoAction;
import org.opensearch.action.admin.indices.mapping.get.GetFieldMappingsRequest;
        @Override
            this.client = client;
import org.opensearch.action.search.MultiSearchRequestBuilder;  
            return execute(GetPipelineAction.INSTANCE, request);
        /** Pause ingestion */
        @Override  
            return execute(GetIndexAction.INSTANCE, request);
import org.opensearch.action.admin.cluster.snapshots.create.CreateSnapshotRequestBuilder;
        public DeleteTaskRequestBuilder prepareDeleteTask(TaskId taskId) {  
import org.opensearch.action.admin.indices.recovery.RecoveryResponse;
import org.opensearch.action.admin.cluster.health.ClusterHealthResponse;  
import org.opensearch.action.admin.cluster.node.hotthreads.NodesHotThreadsResponse;
import org.opensearch.action.admin.indices.settings.get.GetSettingsResponse;
import org.opensearch.action.admin.cluster.state.ClusterStateResponse;
        public NodesReloadSecureSettingsRequestBuilder prepareReloadSecureSettings() {
import org.opensearch.action.admin.indices.cache.clear.ClearIndicesCacheResponse;
        }
    }
        }
        public void shardStores(IndicesShardStoresRequest request, ActionListener<IndicesShardStoresResponse> listener) {
        @Override  
        }  
import org.opensearch.action.admin.indices.recovery.RecoveryAction;
import org.opensearch.action.admin.indices.stats.IndicesStatsAction;
        @Override
        @Override
        /** Get ingestion state */
        public void remoteStoreMetadata(
        public void resolveIndex(ResolveIndexAction.Request request, ActionListener<ResolveIndexAction.Response> listener) {
import org.opensearch.action.search.ClearScrollRequest;
        @Override  
            return new ResizeRequestBuilder(this, ResizeAction.INSTANCE).setSourceIndex(sourceIndex)  
import org.opensearch.action.ingest.PutPipelineAction;  
            return execute(FlushAction.INSTANCE, request);  
    public void searchScroll(final SearchScrollRequest request, final ActionListener<SearchResponse> listener) {
import org.opensearch.core.xcontent.MediaType;  
            return execute(GetMappingsAction.INSTANCE, request);  
            return new NodesStatsRequestBuilder(this, NodesStatsAction.INSTANCE).setNodesIds(nodesIds);
        }
        public ActionFuture<ListTasksResponse> listTasks(final ListTasksRequest request) {
        return execute(ExplainAction.INSTANCE, request);
import org.opensearch.action.search.DeletePitRequest;  
        }
            execute(IndicesStatsAction.INSTANCE, request, listener);
            execute(GetIngestionStateAction.INSTANCE, request, listener);
        @Override  
            Request request,
        }
        }  
        public ActionFuture<AcknowledgedResponse> putRepository(PutRepositoryRequest request) {
import org.opensearch.action.admin.indices.stats.IndicesStatsRequest;  
        public ActionFuture<PendingClusterTasksResponse> pendingClusterTasks(PendingClusterTasksRequest request) {  
            RemoteStoreStatsRequestBuilder remoteStoreStatsRequestBuilder = new RemoteStoreStatsRequestBuilder(
import org.opensearch.action.get.MultiGetRequest;
    public SearchRequestBuilder prepareSearch(String... indices) {
            return execute(DeleteStoredScriptAction.INSTANCE, request);
        }  
        public void nodesHotThreads(NodesHotThreadsRequest request, ActionListener<NodesHotThreadsResponse> listener) {  
        @Override
        @Override
        }
        @Override
import org.opensearch.action.admin.indices.analyze.AnalyzeRequestBuilder;
import org.opensearch.action.ingest.DeletePipelineRequestBuilder;
        @Override
        /** Resume ingestion */
        }
        }  
    public ActionFuture<MultiTermVectorsResponse> multiTermVectors(final MultiTermVectorsRequest request) {
        }
        @Override
        @Override
        @Override  
            return execute(GetDataStreamAction.INSTANCE, request);  
import org.opensearch.action.admin.cluster.allocation.ClusterAllocationExplainRequestBuilder;
        }  
        public CloneSnapshotRequestBuilder prepareCloneSnapshot(String repository, String source, String target) {
import org.opensearch.action.admin.indices.streamingingestion.state.GetIngestionStateAction;  
        }
        }  
    @Override  
        this.threadPool = threadPool;
        }  
        }
import org.opensearch.action.search.DeleteSearchPipelineRequest;  
import org.opensearch.action.admin.indices.alias.IndicesAliasesRequestBuilder;
        public void getTask(final GetTaskRequest request, final ActionListener<GetTaskResponse> listener) {  
        public GetIndexTemplatesRequestBuilder prepareGetTemplates(String... names) {
import org.opensearch.action.admin.cluster.snapshots.delete.DeleteSnapshotAction;
import org.opensearch.transport.client.IndicesAdminClient;  
import org.opensearch.action.admin.indices.forcemerge.ForceMergeRequestBuilder;
        }
        }
        public AnalyzeRequestBuilder prepareAnalyze() {
        public ActionFuture<SnapshotsStatusResponse> snapshotsStatus(SnapshotsStatusRequest request) {  
        }
        }
            return new ClusterStateRequestBuilder(this, ClusterStateAction.INSTANCE);  
import org.opensearch.action.admin.cluster.health.ClusterHealthRequest;
            return execute(ClusterGetWeightedRoutingAction.INSTANCE, request);
        @Override
        public PutPipelineRequestBuilder preparePutPipeline(String id, BytesReference source, MediaType mediaType) {  
        }
        }
    public BulkRequestBuilder prepareBulk() {
import org.opensearch.action.admin.cluster.snapshots.status.SnapshotsStatusAction;  
import org.opensearch.action.search.SearchRequestBuilder;  
        }  
        }  
        }
        public SimulatePipelineRequestBuilder prepareSimulatePipeline(BytesReference source, MediaType mediaType) {
    public TermVectorsRequestBuilder prepareTermVectors(String index, String id) {
        public void getSearchPipeline(GetSearchPipelineRequest request, ActionListener<GetSearchPipelineResponse> listener) {
        public void refresh(final RefreshRequest request, final ActionListener<RefreshResponse> listener) {
                }
    @Override
            return new CreateSnapshotRequestBuilder(this, CreateSnapshotAction.INSTANCE, repository, name);  
        }
            execute(PutPipelineAction.INSTANCE, request, listener);  
        public ClusterGetWeightedRoutingRequestBuilder prepareGetWeightedRouting() {
    protected final Logger logger;  
import org.opensearch.action.admin.cluster.repositories.delete.DeleteRepositoryRequest;
        public ActionFuture<AnalyzeAction.Response> analyze(final AnalyzeAction.Request request) {
        }
        public void resizeIndex(ResizeRequest request, ActionListener<ResizeResponse> listener) {
            execute(ClusterAddWeightedRoutingAction.INSTANCE, request, listener);  
            execute(ResumeIngestionAction.INSTANCE, request, listener);
import org.apache.logging.log4j.Logger;
        public IndicesSegmentsRequestBuilder prepareSegments(String... indices) {  
import org.opensearch.action.admin.cluster.repositories.put.PutRepositoryAction;
            return execute(PendingClusterTasksAction.INSTANCE, request);
        @Override  
                .setTargetIndex(new CreateIndexRequest(targetIndex));
        public ActionFuture<AcknowledgedResponse> deleteSnapshot(DeleteSnapshotRequest request) {
        @Override
        @Override
        }
        @Override  
        @Override
            execute(CancelTasksAction.INSTANCE, request, listener);
            final SegmentReplicationStatsRequest request,
        }
    }
            return execute(VerifyRepositoryAction.INSTANCE, request);
        @Override
        @Override
            ClusterGetWeightedRoutingRequest request,  
import org.opensearch.action.ingest.GetPipelineRequest;  
        public void pendingClusterTasks(PendingClusterTasksRequest request, ActionListener<PendingClusterTasksResponse> listener) {
    public final <Request extends ActionRequest, Response extends ActionResponse> void execute(  
import org.opensearch.action.admin.indices.segments.IndicesSegmentsRequestBuilder;
        public RemoteStoreStatsRequestBuilder prepareRemoteStoreStats(String index, String shardId) {
import org.opensearch.action.admin.cluster.storedscripts.PutStoredScriptAction;
        @Override
            return execute(ForceMergeAction.INSTANCE, request);  
        public ClusterUpdateSettingsRequestBuilder prepareUpdateSettings() {
import org.opensearch.action.admin.cluster.decommission.awareness.put.DecommissionResponse;
        }
        return new MultiGetRequestBuilder(this, MultiGetAction.INSTANCE);  
import org.opensearch.action.admin.indices.open.OpenIndexResponse;  
import org.opensearch.action.admin.cluster.remotestore.restore.RestoreRemoteStoreAction;
import org.opensearch.action.admin.cluster.state.ClusterStateAction;
import org.opensearch.action.admin.cluster.wlm.WlmStatsResponse;
    }
        public ActionFuture<IndicesStatsResponse> stats(final IndicesStatsRequest request) {
        @Override
        public IndicesShardStoreRequestBuilder prepareShardStores(String... indices) {  
        }  
        }
        @Override
            execute(CreateIndexAction.INSTANCE, request, listener);
        public void putRepository(PutRepositoryRequest request, ActionListener<AcknowledgedResponse> listener) {  
        }
    }
    @Override
        @Override
            return execute(NodesUsageAction.INSTANCE, request);
            ClusterPutWeightedRoutingRequest request,  
        @Override
        public PendingClusterTasksRequestBuilder preparePendingClusterTasks() {
        @Override
            return new GetDecommissionStateRequestBuilder(this, GetDecommissionStateAction.INSTANCE);
        public ActionFuture<DecommissionResponse> decommission(DecommissionRequest request) {  
            protected <Request extends ActionRequest, Response extends ActionResponse> void doExecute(
        @Override  
        @Override  
        @Override  
    public ActionFuture<SearchResponse> searchScroll(final SearchScrollRequest request) {  
        @Override
        public void resumeIngestion(final ResumeIngestionRequest request, final ActionListener<ResumeIngestionResponse> listener) {
        }
    }
            @Override  
            return new DeleteDecommissionStateRequestBuilder(this, DeleteDecommissionStateAction.INSTANCE);
import org.opensearch.action.admin.cluster.repositories.get.GetRepositoriesRequestBuilder;  
    @Override  
    }  
import org.opensearch.action.search.PutSearchPipelineRequest;  
            Request request,
        @Override
            return new CancelTasksRequestBuilder(this, CancelTasksAction.INSTANCE).setNodesIds(nodesIds);
import org.opensearch.action.admin.indices.validate.query.ValidateQueryResponse;  
            return execute(PutSearchPipelineAction.INSTANCE, request);  
        @Override
import org.opensearch.action.admin.indices.template.put.PutIndexTemplateRequest;
        public void clusterStats(ClusterStatsRequest request, ActionListener<ClusterStatsResponse> listener) {  
            ActionType<Response> action,
        this.settings = settings;
            execute(ClusterRerouteAction.INSTANCE, request, listener);
            return execute(ClusterAddWeightedRoutingAction.INSTANCE, request);
    public void createPit(final CreatePitRequest createPITRequest, final ActionListener<CreatePitResponse> listener) {  
        }  
            return new ClusterUpdateSettingsRequestBuilder(this, ClusterUpdateSettingsAction.INSTANCE);  
        }  
    }
        }
import org.opensearch.action.admin.cluster.decommission.awareness.delete.DeleteDecommissionStateAction;  
        }
    public MultiGetRequestBuilder prepareMultiGet() {
        public DeletePipelineRequestBuilder prepareDeletePipeline() {  
        @Override
            execute(RestoreRemoteStoreAction.INSTANCE, request, listener);  
            return new RolloverRequestBuilder(this, RolloverAction.INSTANCE).setRolloverTarget(alias);
        public RestoreSnapshotRequestBuilder prepareRestoreSnapshot(String repository, String snapshot) {
        return execute(FieldCapabilitiesAction.INSTANCE, request);
            return execute(DeleteDecommissionStateAction.INSTANCE, request);
            execute(GetIndexAction.INSTANCE, request, listener);  
        return execute(UpdateAction.INSTANCE, request);  
        public ActionFuture<GetSearchPipelineResponse> getSearchPipeline(GetSearchPipelineRequest request) {  
import org.opensearch.action.admin.cluster.allocation.ClusterAllocationExplainResponse;
            execute(FlushAction.INSTANCE, request, listener);
            return execute(DeleteDanglingIndexAction.INSTANCE, request);
        public void updateSettings(final UpdateSettingsRequest request, final ActionListener<AcknowledgedResponse> listener) {
        Request request,
        public ActionFuture<SimulatePipelineResponse> simulatePipeline(SimulatePipelineRequest request) {  
import org.opensearch.action.explain.ExplainRequest;
        @Override
        execute(UpdateAction.INSTANCE, request, listener);
            execute(DecommissionAction.INSTANCE, request, listener);  
import org.opensearch.action.admin.indices.template.get.GetIndexTemplatesRequestBuilder;
            execute(DeleteIndexTemplateAction.INSTANCE, request, listener);  
import org.opensearch.action.index.IndexRequest;
 *
    public ActionFuture<TermVectorsResponse> termVectors(final TermVectorsRequest request) {
            return execute(DeleteRepositoryAction.INSTANCE, request);
import org.opensearch.action.ingest.DeletePipelineRequest;  
        }
    }
    }
import org.opensearch.action.admin.cluster.repositories.cleanup.CleanupRepositoryRequestBuilder;
            return execute(CreateDataStreamAction.INSTANCE, request);
    @Override
        }
import org.opensearch.action.admin.cluster.stats.ClusterStatsRequestBuilder;
        public void deleteRepository(DeleteRepositoryRequest request, ActionListener<AcknowledgedResponse> listener) {  
        @Override
        public void flush(final FlushRequest request, final ActionListener<FlushResponse> listener) {
    public void multiTermVectors(final MultiTermVectorsRequest request, final ActionListener<MultiTermVectorsResponse> listener) {  
        @Override
        public UpgradeStatusRequestBuilder prepareUpgradeStatus(String... indices) {  
    @Override
        }
            return client.threadPool();  
            execute(PutStoredScriptAction.INSTANCE, request, listener);  
        public void deleteTemplate(final DeleteIndexTemplateRequest request, final ActionListener<AcknowledgedResponse> listener) {
        public void putWeightedRouting(
import org.opensearch.action.admin.indices.resolve.ResolveIndexAction;
        public ActionFuture<ClusterStateResponse> state(final ClusterStateRequest request) {
import org.opensearch.action.admin.cluster.shards.routing.weighted.delete.ClusterDeleteWeightedRoutingRequest;
        }  
        execute(PitSegmentsAction.INSTANCE, request, listener);
        public void deleteDataStream(DeleteDataStreamAction.Request request, ActionListener<AcknowledgedResponse> listener) {
        }  
    }  
            final ActionListener<ClusterUpdateSettingsResponse> listener
            return client.execute(action, request);
        public ClearIndicesCacheRequestBuilder prepareClearCache(String... indices) {
        }
            return new GetRepositoriesRequestBuilder(this, GetRepositoriesAction.INSTANCE, name);  
        @Override  
        public ActionFuture<AcknowledgedResponse> deleteTask(DeleteTaskRequest request) {  
    }
        return new GetRequestBuilder(this, GetAction.INSTANCE, null);
        @Override
import java.util.Map;  
        @Override
        @Override
import org.opensearch.action.admin.indices.upgrade.get.UpgradeStatusRequest;
        @Override
    @Override  
            return new GetIndexTemplatesRequestBuilder(this, GetIndexTemplatesAction.INSTANCE, names);
import org.opensearch.action.admin.indices.dangling.import_index.ImportDanglingIndexAction;
        public void exists(final IndicesExistsRequest request, final ActionListener<IndicesExistsResponse> listener) {  
        }
        public void putPipeline(PutPipelineRequest request, ActionListener<AcknowledgedResponse> listener) {
            return new GetPipelineRequestBuilder(this, GetPipelineAction.INSTANCE, ids);  
            client.execute(action, request, listener);
        public NodesUsageRequestBuilder prepareNodesUsage(String... nodesIds) {
        ClusterAdmin(OpenSearchClient client) {
        }
        }  
    public ActionFuture<SearchResponse> search(final SearchRequest request) {
        @Override
import org.opensearch.action.search.StreamSearchAction;
        }
            return new ClusterStatsRequestBuilder(this, ClusterStatsAction.INSTANCE);  
        public void nodesStats(final NodesStatsRequest request, final ActionListener<NodesStatsResponse> listener) {
        }
import org.opensearch.action.admin.cluster.decommission.awareness.get.GetDecommissionStateAction;
import org.opensearch.action.admin.cluster.reroute.ClusterRerouteResponse;  
            execute(UpdateSettingsAction.INSTANCE, request, listener);
import org.opensearch.action.admin.indices.replication.SegmentReplicationStatsRequest;
            execute(PutSearchPipelineAction.INSTANCE, request, listener);
import org.opensearch.action.admin.cluster.snapshots.delete.DeleteSnapshotRequest;
        }  
        }
        }  
        @Override
import org.opensearch.action.fieldcaps.FieldCapabilitiesRequestBuilder;  
        public ActionFuture<ForceMergeResponse> forceMerge(final ForceMergeRequest request) {
import org.opensearch.action.admin.indices.validate.query.ValidateQueryRequest;
import org.opensearch.action.get.GetAction;
import org.opensearch.action.admin.indices.segments.IndicesSegmentsRequest;
        return prepareDelete().setIndex(index).setId(id);
        @Override
            return execute(CloseIndexAction.INSTANCE, request);
import org.opensearch.action.admin.cluster.decommission.awareness.get.GetDecommissionStateRequest;
import org.opensearch.action.search.ClearScrollResponse;
        }
import org.opensearch.action.update.UpdateResponse;
/*  
        }  
        public void clearCache(final ClearIndicesCacheRequest request, final ActionListener<ClearIndicesCacheResponse> listener) {  
            return new PutMappingRequestBuilder(this, PutMappingAction.INSTANCE).setIndices(indices);
            ActionListener<Response> listener
        @Override
        }
        public void snapshotsStatus(SnapshotsStatusRequest request, ActionListener<SnapshotsStatusResponse> listener) {
            execute(DeleteSearchPipelineAction.INSTANCE, request, listener);  
        }
import org.opensearch.action.admin.cluster.snapshots.status.SnapshotsStatusRequest;
        }
import org.opensearch.action.admin.indices.delete.DeleteIndexRequest;
        }
import org.opensearch.action.admin.indices.forcemerge.ForceMergeAction;
            return execute(DeleteSnapshotAction.INSTANCE, request);
        ) {
import org.opensearch.action.ActionRequest;  
        @Override
            return execute(ResizeAction.INSTANCE, request);  
            return execute(RefreshAction.INSTANCE, request);  
            ) {
import org.opensearch.action.admin.cluster.shards.ClusterSearchShardsRequest;  
import org.opensearch.action.search.DeletePitResponse;
        }
import org.opensearch.action.update.UpdateRequest;
import org.opensearch.action.admin.indices.scale.searchonly.ScaleIndexRequestBuilder;
            return execute(SnapshotsStatusAction.INSTANCE, request);
            return new IndicesSegmentsRequestBuilder(this, IndicesSegmentsAction.INSTANCE).setIndices(indices);
            return new NodesReloadSecureSettingsRequestBuilder(this, NodesReloadSecureSettingsAction.INSTANCE);
import org.opensearch.action.admin.cluster.remotestore.metadata.RemoteStoreMetadataRequestBuilder;  
import org.opensearch.action.admin.indices.alias.get.GetAliasesAction;
import org.opensearch.action.admin.indices.cache.clear.ClearIndicesCacheRequest;  
            ActionType<Response> action,
            return remoteStoreStatsRequestBuilder;  
        }
import org.opensearch.action.admin.cluster.state.ClusterStateRequestBuilder;  
        public ActionFuture<AcknowledgedResponse> putMapping(final PutMappingRequest request) {
        }  
        }
        @Override
    public ExplainRequestBuilder prepareExplain(String index, String id) {
        public ActionFuture<AcknowledgedResponse> delete(final DeleteIndexRequest request) {
        }
        @Override  
            return execute(ClusterHealthAction.INSTANCE, request);
            return execute(ClusterAllocationExplainAction.INSTANCE, request);
        return execute(ClearScrollAction.INSTANCE, request);
import org.opensearch.action.admin.indices.streamingingestion.pause.PauseIngestionResponse;
import org.opensearch.action.admin.cluster.remotestore.metadata.RemoteStoreMetadataAction;
import org.opensearch.action.termvectors.MultiTermVectorsResponse;
        return new TermVectorsRequestBuilder(this, TermVectorsAction.INSTANCE, index, id);  
        }
            return new ForceMergeRequestBuilder(this, ForceMergeAction.INSTANCE).setIndices(indices);
        public ListTasksRequestBuilder prepareListTasks(String... nodesIds) {
            execute(GetIndexTemplatesAction.INSTANCE, request, listener);  
        public void getDataStreams(GetDataStreamAction.Request request, ActionListener<GetDataStreamAction.Response> listener) {  
        @Override
        public PutStoredScriptRequestBuilder preparePutStoredScript() {  
import org.opensearch.action.admin.indices.exists.indices.IndicesExistsRequest;
import org.opensearch.action.admin.indices.segments.PitSegmentsAction;  
        }
        }
        private final ClusterAdmin clusterAdmin;
    }  
            return execute(CloneSnapshotAction.INSTANCE, request);
import org.opensearch.transport.client.Client;  
 */  
        }
    public FieldCapabilitiesRequestBuilder prepareFieldCaps(String... indices) {
    public ActionFuture<UpdateResponse> update(final UpdateRequest request) {
 *     http://www.apache.org/licenses/LICENSE-2.0
            return execute(PutPipelineAction.INSTANCE, request);
        public void getRepositories(GetRepositoriesRequest request, ActionListener<GetRepositoriesResponse> listener) {  
 * Unless required by applicable law or agreed to in writing,
            execute(DeletePipelineAction.INSTANCE, request, listener);  
        @Override  
    @Override
import org.opensearch.action.admin.indices.stats.IndicesStatsRequestBuilder;
        @Override
    public ActionFuture<ExplainResponse> explain(ExplainRequest request) {  
            execute(PutIndexTemplateAction.INSTANCE, request, listener);  
            execute(PutRepositoryAction.INSTANCE, request, listener);
        @Override
            return indicesAdmin;
    }
        public GetStoredScriptRequestBuilder prepareGetStoredScript(String id) {
        public ActionFuture<ClusterStatsResponse> clusterStats(ClusterStatsRequest request) {
            execute(ClusterSearchShardsAction.INSTANCE, request, listener);
import org.opensearch.action.ingest.DeletePipelineAction;
            return new AnalyzeRequestBuilder(this, AnalyzeAction.INSTANCE, index, text);
        public UpgradeRequestBuilder prepareUpgrade(String... indices) {  
            return new SnapshotsStatusRequestBuilder(this, SnapshotsStatusAction.INSTANCE);
    public IndexRequestBuilder prepareIndex() {
import org.opensearch.action.admin.cluster.shards.ClusterSearchShardsRequestBuilder;
    @Override  
        public ActionFuture<RecoveryResponse> recoveries(final RecoveryRequest request) {
            }
import org.opensearch.action.admin.indices.close.CloseIndexRequest;
    }  
        @Override
    @Override
        public SegmentReplicationStatsRequestBuilder prepareSegmentReplicationStats(String... indices) {  
 *
        return prepareGet().setIndex(index).setId(id);  
            return new ClusterAllocationExplainRequestBuilder(this, ClusterAllocationExplainAction.INSTANCE);  
            return execute(ClusterRerouteAction.INSTANCE, request);
        @Override
            ClusterDeleteWeightedRoutingRequest request,  
        @Override
            execute(RemoteStoreMetadataAction.INSTANCE, request, listener);
    }  
            execute(CloseIndexAction.INSTANCE, request, listener);
import org.opensearch.action.admin.cluster.repositories.cleanup.CleanupRepositoryRequest;
import org.opensearch.action.admin.cluster.shards.routing.weighted.get.ClusterGetWeightedRoutingResponse;
import org.opensearch.action.admin.indices.recovery.RecoveryRequestBuilder;
        }  
        @Override  
        }
            execute(DeleteRepositoryAction.INSTANCE, request, listener);
import org.opensearch.action.admin.indices.readonly.AddIndexBlockRequestBuilder;  
        @Override
        public ActionFuture<GetStoredScriptResponse> getStoredScript(final GetStoredScriptRequest request) {
        }  
        execute(GetAllPitsAction.INSTANCE, getAllPitNodesRequest, listener);
        public ClusterPutWeightedRoutingRequestBuilder prepareWeightedRouting() {
        }
import org.opensearch.action.admin.indices.refresh.RefreshRequest;
        public ActionFuture<GetRepositoriesResponse> getRepositories(GetRepositoriesRequest request) {
import org.opensearch.action.admin.indices.close.CloseIndexRequestBuilder;
    }  
    }
    }
        public void getFieldMappings(GetFieldMappingsRequest request, ActionListener<GetFieldMappingsResponse> listener) {
            return new GetFieldMappingsRequestBuilder(this, GetFieldMappingsAction.INSTANCE, indices);
    @Override
            ActionListener<Response> listener
    @Override  
        public <Request extends ActionRequest, Response extends ActionResponse> void execute(
        @Override  
    }
        @Override
        @Override
        }
        @Override  
            final ClusterUpdateSettingsRequest request,
        ) {  
        public void remoteStoreStats(final RemoteStoreStatsRequest request, final ActionListener<RemoteStoreStatsResponse> listener) {
import org.opensearch.action.admin.cluster.tasks.PendingClusterTasksRequestBuilder;  
    static class Admin implements AdminClient {  
        @Override  
            return new CleanupRepositoryRequestBuilder(this, CleanupRepositoryAction.INSTANCE, repository);
        }  
            execute(CloneSnapshotAction.INSTANCE, request, listener);  
 */  
        }
import org.opensearch.action.admin.indices.replication.SegmentReplicationStatsResponse;
            return new DeletePipelineRequestBuilder(this, DeletePipelineAction.INSTANCE, id);  
            return execute(IndicesAliasesAction.INSTANCE, request);
        public void listDanglingIndices(ListDanglingIndicesRequest request, ActionListener<ListDanglingIndicesResponse> listener) {
        @Override
    static class IndicesAdmin implements IndicesAdminClient {  
            return new CloneSnapshotRequestBuilder(this, CloneSnapshotAction.INSTANCE, repository, source, target);
import org.opensearch.action.admin.cluster.node.stats.NodesStatsRequestBuilder;
        @Override  
import org.opensearch.action.admin.indices.settings.put.UpdateSettingsRequestBuilder;
        @Override
                ActionType<Response> action,
            execute(DeleteStoredScriptAction.INSTANCE, request, listener);
    }
        public void deleteStoredScript(DeleteStoredScriptRequest request, ActionListener<AcknowledgedResponse> listener) {
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.action.admin.indices.validate.query.ValidateQueryAction;  
import org.opensearch.action.termvectors.MultiTermVectorsAction;
import org.opensearch.action.admin.cluster.node.tasks.cancel.CancelTasksRequest;
    public void fieldCaps(FieldCapabilitiesRequest request, ActionListener<FieldCapabilitiesResponse> listener) {
import org.opensearch.action.index.IndexResponse;
            return prepareDeleteTask(new TaskId(taskId));
        @Override
        }  
        @Override  
    @Override
        @Override  
        public void nodesInfo(final NodesInfoRequest request, final ActionListener<NodesInfoResponse> listener) {
        @Override
            }
import org.opensearch.action.admin.indices.rollover.RolloverRequestBuilder;
        @Override
 * Modifications Copyright OpenSearch Contributors. See
            return new IndicesShardStoreRequestBuilder(this, IndicesShardStoresAction.INSTANCE, indices);
            return execute(NodesHotThreadsAction.INSTANCE, request);
        public ActionFuture<AcknowledgedResponse> deleteDanglingIndex(DeleteDanglingIndexRequest request) {
import org.opensearch.action.admin.cluster.snapshots.get.GetSnapshotsRequest;
        @Override
        public ActionFuture<OpenIndexResponse> open(final OpenIndexRequest request) {
            return execute(RecoveryAction.INSTANCE, request);  
        ) {
        }
        public RefreshRequestBuilder prepareRefresh(String... indices) {  
        return new ExplainRequestBuilder(this, ExplainAction.INSTANCE, index, id);
import org.opensearch.action.admin.indices.stats.IndicesStatsResponse;
        @Override
            execute(GetTaskAction.INSTANCE, request, listener);
        @Override  
            return execute(GetSearchPipelineAction.INSTANCE, request);
import org.opensearch.action.support.PlainActionFuture;  
        @Override
import org.opensearch.action.admin.indices.segments.IndicesSegmentsAction;  
            execute(VerifyRepositoryAction.INSTANCE, request, listener);
        }
        public ActionFuture<AcknowledgedResponse> deleteRepository(DeleteRepositoryRequest request) {
        public void nodesUsage(final NodesUsageRequest request, final ActionListener<NodesUsageResponse> listener) {  
        public FlushRequestBuilder prepareFlush(String... indices) {  
            execute(ClusterDeleteWeightedRoutingAction.INSTANCE, request, listener);  
import org.opensearch.action.admin.cluster.node.reload.NodesReloadSecureSettingsAction;  
        public ActionFuture<AcknowledgedResponse> deletePipeline(DeletePipelineRequest request) {
        @Override
    }
    @Override
        @Override
        return new TermVectorsRequestBuilder(this, TermVectorsAction.INSTANCE);
import org.opensearch.action.admin.cluster.node.usage.NodesUsageResponse;  
            execute(SimulatePipelineAction.INSTANCE, request, listener);
        execute(MultiGetAction.INSTANCE, request, listener);
        public GetStoredScriptRequestBuilder prepareGetStoredScript() {
import org.opensearch.action.admin.cluster.repositories.verify.VerifyRepositoryRequest;  
            return builder;  
import org.opensearch.action.admin.indices.mapping.get.GetMappingsRequest;  
        @Override
        }  
import org.opensearch.transport.client.AdminClient;
import org.opensearch.action.admin.cluster.allocation.ClusterAllocationExplainRequest;  
        @Override  
import org.opensearch.action.admin.indices.delete.DeleteIndexAction;  
        }
        @Override
        public void segmentReplicationStats(
        public ActionFuture<AcknowledgedResponse> deleteSearchPipeline(DeleteSearchPipelineRequest request) {
        public void health(final ClusterHealthRequest request, final ActionListener<ClusterHealthResponse> listener) {  
        return execute(MultiSearchAction.INSTANCE, request);  
import org.opensearch.action.fieldcaps.FieldCapabilitiesAction;
        }  
        @Override  
        }
        public void upgrade(final UpgradeRequest request, final ActionListener<UpgradeResponse> listener) {
        }
        public IndicesAdminClient indices() {
import org.opensearch.action.admin.cluster.snapshots.status.SnapshotsStatusResponse;  
            execute(RefreshAction.INSTANCE, request, listener);
        @Override
        }  
            execute(SnapshotsStatusAction.INSTANCE, request, listener);  
import org.opensearch.action.get.MultiGetResponse;  
            return execute(GetRepositoriesAction.INSTANCE, request);
        public void getPipeline(GetPipelineRequest request, ActionListener<GetPipelineResponse> listener) {
    }
        @Override
        execute(ExplainAction.INSTANCE, request, listener);  
    }  
            execute(UpgradeAction.INSTANCE, request, listener);
        public void putSearchPipeline(PutSearchPipelineRequest request, ActionListener<AcknowledgedResponse> listener) {  
        }
        }
    public void pitSegments(final PitSegmentsRequest request, final ActionListener<IndicesSegmentResponse> listener) {  
    }
        }
            return execute(ImportDanglingIndexAction.INSTANCE, request);
        return new FieldCapabilitiesRequestBuilder(this, FieldCapabilitiesAction.INSTANCE, indices);  
import org.opensearch.action.admin.cluster.node.tasks.get.GetTaskRequest;
import org.opensearch.action.admin.cluster.repositories.cleanup.CleanupRepositoryAction;  
        @Override
            return execute(SegmentReplicationStatsAction.INSTANCE, request);  
import org.opensearch.action.ingest.SimulatePipelineRequest;
        @Override
        @Override  
import org.opensearch.action.termvectors.TermVectorsAction;  
        @Override  
                ThreadContext threadContext = threadPool().getThreadContext();  
import org.opensearch.action.admin.indices.mapping.get.GetFieldMappingsResponse;
import org.opensearch.action.admin.indices.datastream.GetDataStreamAction;
            execute(GetAliasesAction.INSTANCE, request, listener);
        public ValidateQueryRequestBuilder prepareValidateQuery(String... indices) {
    public ActionFuture<ClearScrollResponse> clearScroll(ClearScrollRequest request) {  
        }
        }
import org.opensearch.action.admin.cluster.decommission.awareness.put.DecommissionRequest;  
        }
        }
import org.opensearch.action.admin.cluster.storedscripts.DeleteStoredScriptRequest;
import org.opensearch.action.admin.cluster.storedscripts.GetStoredScriptAction;  
            return execute(DecommissionAction.INSTANCE, request);
import org.opensearch.action.search.GetAllPitNodesResponse;
import org.opensearch.action.admin.cluster.repositories.put.PutRepositoryRequest;  
import org.opensearch.action.admin.cluster.snapshots.get.GetSnapshotsRequestBuilder;  
import org.opensearch.action.admin.cluster.node.info.NodesInfoRequest;  
import org.opensearch.action.admin.indices.exists.indices.IndicesExistsRequestBuilder;
    }
    }  
    public BulkRequestBuilder prepareBulk(@Nullable String globalIndex) {  
        }  
                    ThreadContext.StoredContext ctx = ThreadContextAccess.doPrivileged(() -> threadContext.stashAndMergeHeaders(headers))
import org.opensearch.action.termvectors.TermVectorsRequestBuilder;
        }  
        ) {  
        public ClusterSearchShardsRequestBuilder prepareSearchShards(String... indices) {
        @Override  
        public SnapshotsStatusRequestBuilder prepareSnapshotStatus(String repository) {
        public IndicesExistsRequestBuilder prepareExists(String... indices) {
import org.opensearch.action.admin.indices.dangling.list.ListDanglingIndicesResponse;
        }
        ActionType<Response> action,
import org.opensearch.action.admin.indices.segments.IndicesSegmentResponse;
        /** Resume ingestion */
        public ResizeRequestBuilder prepareResizeIndex(String sourceIndex, String targetIndex) {
    public void delete(final DeleteRequest request, final ActionListener<DeleteResponse> listener) {  
        return new SearchScrollRequestBuilder(this, SearchScrollAction.INSTANCE, scrollId);
import org.opensearch.action.admin.indices.close.CloseIndexAction;  
        @Override
            execute(UpgradeStatusAction.INSTANCE, request, listener);
        Request request
        @Override  
import org.opensearch.action.admin.cluster.shards.routing.weighted.put.ClusterPutWeightedRoutingRequestBuilder;
    }  
        public void rolloverIndex(RolloverRequest request, ActionListener<RolloverResponse> listener) {
import org.opensearch.action.admin.indices.shrink.ResizeRequest;
        public void reroute(final ClusterRerouteRequest request, final ActionListener<ClusterRerouteResponse> listener) {  
import org.opensearch.action.delete.DeleteAction;
    public void getAllPits(final GetAllPitNodesRequest getAllPitNodesRequest, final ActionListener<GetAllPitNodesResponse> listener) {
    public Client filterWithHeader(Map<String, String> headers) {
        public ActionFuture<GetPipelineResponse> getPipeline(GetPipelineRequest request) {  
        }  
        public VerifyRepositoryRequestBuilder prepareVerifyRepository(String name) {
import org.opensearch.action.admin.cluster.repositories.get.GetRepositoriesRequest;
        }
    }  
    @Override
        }  
import org.opensearch.action.admin.cluster.repositories.cleanup.CleanupRepositoryResponse;  
        public UpdateSettingsRequestBuilder prepareUpdateSettings(String... indices) {  
        public GetSettingsRequestBuilder prepareGetSettings(String... indices) {  
    @Override
        }  
 */  
    @Override
public abstract class AbstractClient implements Client {
import org.opensearch.action.delete.DeleteResponse;
        }
import org.opensearch.transport.client.FilterClient;
import org.opensearch.action.admin.indices.shards.IndicesShardStoresAction;
        public ActionFuture<ClusterPutWeightedRoutingResponse> putWeightedRouting(ClusterPutWeightedRoutingRequest request) {  
import org.opensearch.action.admin.cluster.node.tasks.cancel.CancelTasksResponse;  
import org.opensearch.action.get.MultiGetAction;  
import org.opensearch.action.admin.cluster.decommission.awareness.get.GetDecommissionStateResponse;
import org.opensearch.action.admin.cluster.health.ClusterHealthRequestBuilder;
        return new FilterClient(this) {
import org.opensearch.action.admin.cluster.shards.routing.weighted.put.ClusterPutWeightedRoutingResponse;
            return new OpenIndexRequestBuilder(this, OpenIndexAction.INSTANCE, indices);
        public ClusterHealthRequestBuilder prepareHealth(String... indices) {
    public void termVectors(final TermVectorsRequest request, final ActionListener<TermVectorsResponse> listener) {
import org.opensearch.action.admin.cluster.shards.routing.weighted.get.ClusterGetWeightedRoutingRequest;
        @Override  
        public <Request extends ActionRequest, Response extends ActionResponse> ActionFuture<Response> execute(  
import org.opensearch.action.admin.cluster.wlm.WlmStatsRequest;  
    public void multiGet(final MultiGetRequest request, final ActionListener<MultiGetResponse> listener) {  
    public void deletePits(final DeletePitRequest deletePITRequest, final ActionListener<DeletePitResponse> listener) {
        }
            execute(GetMappingsAction.INSTANCE, request, listener);  
            return execute(DeleteTaskAction.INSTANCE, request);
        @Override  
        public DeleteIndexTemplateRequestBuilder prepareDeleteTemplate(String name) {
        @Override
    }  
        @Override
        return new SearchRequestBuilder(this, SearchAction.INSTANCE).setIndices(indices);  
            execute(SegmentReplicationStatsAction.INSTANCE, request, listener);
        }
        }
import org.opensearch.action.admin.indices.flush.FlushAction;
    @Override
        @Override
        return new BulkRequestBuilder(this, BulkAction.INSTANCE);
 * this work for additional information regarding copyright
        }
}  
        ) {
        @Override
import org.opensearch.action.admin.cluster.snapshots.clone.CloneSnapshotRequest;
 * under the License.  
            return new PutIndexTemplateRequestBuilder(this, PutIndexTemplateAction.INSTANCE, name);
import org.opensearch.action.admin.indices.exists.indices.IndicesExistsAction;  
        @Override  
            DeleteDecommissionStateRequest request,  
        }
            return execute(GetStoredScriptAction.INSTANCE, request);
            return execute(NodesStatsAction.INSTANCE, request);
    }
        }
        }
            return new NodesHotThreadsRequestBuilder(this, NodesHotThreadsAction.INSTANCE).setNodesIds(nodesIds);  
    @Override
        @Override  
    public void update(final UpdateRequest request, final ActionListener<UpdateResponse> listener) {
        }
import org.opensearch.action.termvectors.TermVectorsRequest;
import org.opensearch.action.admin.cluster.snapshots.create.CreateSnapshotRequest;
        }  
        }
        public GetFieldMappingsRequestBuilder prepareGetFieldMappings(String... indices) {
    @Override
            final RemoteStoreMetadataRequest request,
import org.opensearch.action.admin.cluster.remotestore.stats.RemoteStoreStatsRequestBuilder;
        public ActionFuture<AcknowledgedResponse> cloneSnapshot(CloneSnapshotRequest request) {  
import org.opensearch.action.admin.indices.get.GetIndexRequestBuilder;
        };
        public ActionFuture<PauseIngestionResponse> pauseIngestion(final PauseIngestionRequest request) {
        return execute(DeleteAction.INSTANCE, request);
            execute(GetStoredScriptAction.INSTANCE, request, listener);
        }
            return execute(ListTasksAction.INSTANCE, request);
        @Override
            return new RestoreSnapshotRequestBuilder(this, RestoreSnapshotAction.INSTANCE, repository, snapshot);
        public OpenIndexRequestBuilder prepareOpen(String... indices) {  
            execute(NodesHotThreadsAction.INSTANCE, request, listener);
        @Override
        }  
        return this.settings;  
        }
            return new DeleteIndexTemplateRequestBuilder(this, DeleteIndexTemplateAction.INSTANCE, name);
        public CloseIndexRequestBuilder prepareClose(String... indices) {
            return new UpgradeRequestBuilder(this, UpgradeAction.INSTANCE).setIndices(indices);
import org.opensearch.action.search.GetAllPitNodesRequest;
        @Override
        public SnapshotsStatusRequestBuilder prepareSnapshotStatus() {  
        @Override
        }  
            return execute(DeleteIndexAction.INSTANCE, request);
        @Override  
            execute(ClusterStatsAction.INSTANCE, request, listener);
import org.opensearch.action.admin.indices.alias.IndicesAliasesAction;
            this.indicesAdmin = new IndicesAdmin(client);
        @Override
        public <Request extends ActionRequest, Response extends ActionResponse> void execute(
import org.opensearch.action.admin.indices.rollover.RolloverRequest;
        }
        }
            return new DeleteIndexRequestBuilder(this, DeleteIndexAction.INSTANCE, indices);  
        public ActionFuture<AcknowledgedResponse> importDanglingIndex(ImportDanglingIndexRequest request) {  
        @Override  
        @Override  
import org.opensearch.action.admin.cluster.shards.routing.weighted.delete.ClusterDeleteWeightedRoutingRequestBuilder;
        @Override
        public void importDanglingIndex(ImportDanglingIndexRequest request, ActionListener<AcknowledgedResponse> listener) {
        @Override  
import org.opensearch.action.delete.DeleteRequestBuilder;
            execute(ClusterStateAction.INSTANCE, request, listener);
        @Override  
 * license agreements. See the NOTICE file distributed with
    }
        public void getSettings(GetSettingsRequest request, ActionListener<GetSettingsResponse> listener) {
import org.opensearch.action.admin.indices.open.OpenIndexAction;  
import org.opensearch.action.admin.cluster.remotestore.restore.RestoreRemoteStoreResponse;
    private final Admin admin;
import org.opensearch.action.admin.indices.upgrade.get.UpgradeStatusAction;
        @Override  
            return new SimulatePipelineRequestBuilder(this, SimulatePipelineAction.INSTANCE, source, mediaType);  
import org.opensearch.action.admin.cluster.node.tasks.get.GetTaskResponse;
    public IndexRequestBuilder prepareIndex(String index) {  
 *  
            execute(RecoveryAction.INSTANCE, request, listener);
        public IndicesStatsRequestBuilder prepareStats(String... indices) {  
        Request request,
        public void updateSettings(  
import org.opensearch.transport.client.OpenSearchClient;
            return new ClusterRerouteRequestBuilder(this, ClusterRerouteAction.INSTANCE);  
        public NodesInfoRequestBuilder prepareNodesInfo(String... nodesIds) {
                try (
import org.opensearch.action.admin.indices.validate.query.ValidateQueryRequestBuilder;
        }  
import org.opensearch.action.admin.indices.alias.get.GetAliasesRequest;  
        @Override
import org.opensearch.action.admin.indices.datastream.CreateDataStreamAction;  
        }
import org.opensearch.action.bulk.BulkAction;
        }  
        public void getMappings(GetMappingsRequest request, ActionListener<GetMappingsResponse> listener) {
        public void putStoredScript(final PutStoredScriptRequest request, ActionListener<AcknowledgedResponse> listener) {
import org.opensearch.action.admin.cluster.remotestore.restore.RestoreRemoteStoreRequest;  
            execute(DeleteTaskAction.INSTANCE, request, listener);  
import org.opensearch.action.admin.cluster.snapshots.get.GetSnapshotsAction;
        }  
        public ActionFuture<SegmentReplicationStatsResponse> segmentReplicationStats(final SegmentReplicationStatsRequest request) {
import org.opensearch.action.admin.cluster.node.tasks.cancel.CancelTasksAction;  
import org.opensearch.action.admin.cluster.remotestore.metadata.RemoteStoreMetadataRequest;
        @Override
            execute(DeleteDanglingIndexAction.INSTANCE, request, listener);
    protected abstract <Request extends ActionRequest, Response extends ActionResponse> void doExecute(
        public void deleteDecommissionState(
            execute(IndicesShardStoresAction.INSTANCE, request, listener);
        ) {  
        @Override
        @Override  
        }
import org.opensearch.action.admin.cluster.snapshots.clone.CloneSnapshotAction;  
        }
    public ActionFuture<MultiSearchResponse> multiSearch(MultiSearchRequest request) {
            return new VerifyRepositoryRequestBuilder(this, VerifyRepositoryAction.INSTANCE, name);  
        public PutMappingRequestBuilder preparePutMapping(String... indices) {  
        }  
    private final ThreadPool threadPool;  
        }
        return execute(BulkAction.INSTANCE, request);
import org.opensearch.action.admin.indices.alias.get.GetAliasesResponse;
        ) {
        }
import org.opensearch.core.action.ActionResponse;  
import org.opensearch.action.admin.indices.shards.IndicesShardStoreRequestBuilder;  
    }  
        ) {  
/*
        @Override
    @Override  
import org.opensearch.action.admin.cluster.decommission.awareness.delete.DeleteDecommissionStateResponse;  
        @Override
import org.opensearch.action.ingest.GetPipelineAction;
            final ActionListener<SegmentReplicationStatsResponse> listener  
    public ActionFuture<BulkResponse> bulk(final BulkRequest request) {  
        }
import org.opensearch.action.admin.indices.mapping.get.GetFieldMappingsAction;
        public ClusterRerouteRequestBuilder prepareReroute() {
    @Override
        public CreateIndexRequestBuilder prepareCreate(String index) {
        @Override
            return new PutRepositoryRequestBuilder(this, PutRepositoryAction.INSTANCE, name);  
import org.opensearch.action.search.ClearScrollRequestBuilder;  
 * the Apache License, Version 2.0 (the "License"); you may
    @Override  
import org.opensearch.action.admin.cluster.shards.routing.weighted.put.ClusterAddWeightedRoutingAction;
            return execute(ListDanglingIndicesAction.INSTANCE, request);  
        public ActionFuture<GetAliasesResponse> getAliases(GetAliasesRequest request) {
import org.opensearch.action.admin.cluster.repositories.put.PutRepositoryRequestBuilder;
import org.opensearch.action.admin.indices.flush.FlushResponse;
        return actionFuture;
            return new GetTaskRequestBuilder(this, GetTaskAction.INSTANCE).setTaskId(taskId);
        public ActionFuture<RolloverResponse> rolloverIndex(RolloverRequest request) {
import org.opensearch.action.get.GetRequestBuilder;
            }  
        }  
import org.opensearch.action.admin.cluster.node.usage.NodesUsageRequest;
            execute(ResizeAction.INSTANCE, request, listener);
import org.opensearch.action.admin.cluster.shards.ClusterSearchShardsAction;
        public void getStoredScript(final GetStoredScriptRequest request, final ActionListener<GetStoredScriptResponse> listener) {  
        }
    @Override
        public IndicesAliasesRequestBuilder prepareAliases() {
        public GetTaskRequestBuilder prepareGetTask(TaskId taskId) {
        }
            client.execute(action, request, listener);
        @Override  
import org.opensearch.action.admin.cluster.decommission.awareness.put.DecommissionAction;
import org.opensearch.action.ingest.PutPipelineRequest;
import org.opensearch.action.admin.indices.forcemerge.ForceMergeResponse;
        @Override
import org.opensearch.action.admin.indices.cache.clear.ClearIndicesCacheAction;
        @Override
        @Override  
                RemoteStoreStatsAction.INSTANCE
        }  
            return execute(PutRepositoryAction.INSTANCE, request);
        return new MultiTermVectorsRequestBuilder(this, MultiTermVectorsAction.INSTANCE);  
        @Override
        public void putTemplate(final PutIndexTemplateRequest request, final ActionListener<AcknowledgedResponse> listener) {
    @Override  
        }
import org.opensearch.action.admin.indices.dangling.list.ListDanglingIndicesRequest;
            return execute(GetIndexTemplatesAction.INSTANCE, request);
    public ActionFuture<MultiGetResponse> multiGet(final MultiGetRequest request) {
import org.opensearch.action.search.DeleteSearchPipelineAction;
    }  
    public ClearScrollRequestBuilder prepareClearScroll() {
        public ActionFuture<AcknowledgedResponse> deleteTemplate(final DeleteIndexTemplateRequest request) {  
    public void multiSearch(MultiSearchRequest request, ActionListener<MultiSearchResponse> listener) {
import org.opensearch.action.admin.cluster.storedscripts.GetStoredScriptResponse;  
import org.opensearch.action.admin.cluster.storedscripts.DeleteStoredScriptRequestBuilder;
    @Override
        ) {
import org.opensearch.action.admin.cluster.remotestore.metadata.RemoteStoreMetadataResponse;
        }  
import org.opensearch.action.admin.indices.replication.SegmentReplicationStatsRequestBuilder;  
        public ActionFuture<AcknowledgedResponse> putSearchPipeline(PutSearchPipelineRequest request) {
            return execute(IndicesExistsAction.INSTANCE, request);
        }
import org.opensearch.core.action.ActionListener;
        return new UpdateRequestBuilder(this, UpdateAction.INSTANCE, null, null);
        }  
        public void restoreSnapshot(RestoreSnapshotRequest request, ActionListener<RestoreSnapshotResponse> listener) {  
        }
        @Override
import org.opensearch.action.admin.cluster.shards.routing.weighted.get.ClusterGetWeightedRoutingRequestBuilder;  
        @Override
            return new DeleteRepositoryRequestBuilder(this, DeleteRepositoryAction.INSTANCE, name);  
        return new ClearScrollRequestBuilder(this, ClearScrollAction.INSTANCE);  
import org.opensearch.action.admin.indices.exists.indices.IndicesExistsResponse;  
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.action.admin.indices.rollover.RolloverAction;  
        @Override
        return new IndexRequestBuilder(this, IndexAction.INSTANCE, null);
import org.opensearch.action.get.GetResponse;
        public ActionFuture<GetSnapshotsResponse> getSnapshots(GetSnapshotsRequest request) {
            execute(GetSnapshotsAction.INSTANCE, request, listener);
            return execute(ValidateQueryAction.INSTANCE, request);
        @Override
        }  
        @Override
    }  
import org.opensearch.action.index.IndexAction;
        }
    static class ClusterAdmin implements ClusterAdminClient {  
        @Override
    @Override
            return new ClusterGetWeightedRoutingRequestBuilder(this, ClusterGetWeightedRoutingAction.INSTANCE);
        execute(GetAction.INSTANCE, request, listener);
        ) {  
            return execute(ClusterUpdateSettingsAction.INSTANCE, request);
