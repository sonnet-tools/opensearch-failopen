     * @see Requests#indicesSegmentsRequest(String...)
        CompletableFuture<GetDataStreamAction.Response> future = new CompletableFuture<>();
    /** Validate query - CompletionStage version */
        CompletableFuture<AcknowledgedResponse> future = new CompletableFuture<>();
     * @see Requests#forceMergeRequest(String...)
     * @param index The index name to create
     * Open an index based on the index name.
import org.opensearch.action.admin.indices.mapping.get.GetMappingsRequest;
     *
     */
    AddIndexBlockRequestBuilder prepareAddBlock(APIBlock block, String... indices);
     * @return The result future
import org.opensearch.action.admin.indices.upgrade.post.UpgradeRequestBuilder;  
     */
     * @param request  The force merge request
     *
     * Explicitly force merge one or more indices into a the number of segments.  
        CompletableFuture<AcknowledgedResponse> future = new CompletableFuture<>();
    }  
        CompletableFuture<GetAliasesResponse> future = new CompletableFuture<>();  
     * Validate a query for correctness.  
    void upgradeStatus(UpgradeStatusRequest request, ActionListener<UpgradeStatusResponse> listener);
import org.opensearch.action.admin.indices.alias.get.GetAliasesRequestBuilder;
     */
     * The shard stores info of one or more indices.  
     */  
    void deleteTemplate(DeleteIndexTemplateRequest request, ActionListener<AcknowledgedResponse> listener);
        return future;
     * @see Requests#createIndexRequest(String)  
    }
     * Explicitly force merge one or more indices into a the number of segments.  
    /**
     * @param request  The upgrade request  
    /** Create data stream - CompletionStage version */
     * Puts an index template.
import org.opensearch.action.admin.indices.template.get.GetIndexTemplatesRequest;  
     */
    void pauseIngestion(PauseIngestionRequest request, ActionListener<PauseIngestionResponse> listener);  
        CompletableFuture<ResolveIndexAction.Response> future = new CompletableFuture<>();  
    void recoveries(RecoveryRequest request, ActionListener<RecoveryResponse> listener);
     * @param index      The name of the index to scale
import org.opensearch.action.admin.indices.mapping.get.GetMappingsResponse;  
 * You may obtain a copy of the License at  
     *  
    ActionFuture<GetAliasesResponse> getAliases(GetAliasesRequest request);
import org.opensearch.action.admin.indices.forcemerge.ForceMergeRequest;
        CompletableFuture<GetSettingsResponse> future = new CompletableFuture<>();
     *  
        upgrade(request, ActionListener.wrap(future::complete, future::completeExceptionally));
    /** Put template - CompletionStage version */
import org.opensearch.action.admin.indices.flush.FlushResponse;  
     *  
    /**  
     * @return The result future
    /** Delete template - CompletionStage version */
        putMapping(request, ActionListener.wrap(future::complete, future::completeExceptionally));
    default CompletionStage<GetSettingsResponse> getSettingsAsync(GetSettingsRequest request) {  
    PutIndexTemplateRequestBuilder preparePutTemplate(String name);
import org.opensearch.action.admin.indices.template.get.GetIndexTemplatesResponse;
    void getAliases(GetAliasesRequest request, ActionListener<GetAliasesResponse> listener);
     * @see Requests#deleteIndexRequest(String)
        return future;
     */  
    }
    /**
     * @return The result future
     * Resize an index using an explicit request allowing to specify the settings, mappings and aliases of the target index of the index.
    /**  
    /**  
     * @see Requests#flushRequest(String...)
        addBlock(request, ActionListener.wrap(future::complete, future::completeExceptionally));  
    IndicesShardStoreRequestBuilder prepareShardStores(String... indices);
import org.opensearch.action.admin.indices.settings.get.GetSettingsResponse;
     * Creates an index using an explicit request allowing to specify the settings of the index.
     *
        getTemplates(request, ActionListener.wrap(future::complete, future::completeExceptionally));  
     * @return The result future  
     * @see Requests#indexAliasesRequest()  
    default CompletionStage<ResolveIndexAction.Response> resolveIndexAsync(ResolveIndexAction.Request request) {
        CompletableFuture<CreateIndexResponse> future = new CompletableFuture<>();
    void segmentReplicationStats(SegmentReplicationStatsRequest request, ActionListener<SegmentReplicationStatsResponse> listener);  
     */
    /**  
     * @param request The upgrade request  
    void analyze(AnalyzeAction.Request request, ActionListener<AnalyzeAction.Response> listener);
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;
    /**
    }
     */  
        resumeIngestion(request, ActionListener.wrap(future::complete, future::completeExceptionally));  
    ActionFuture<UpgradeResponse> upgrade(UpgradeRequest request);
        CompletableFuture<CloseIndexResponse> future = new CompletableFuture<>();  
import org.opensearch.action.admin.indices.scale.searchonly.ScaleIndexRequestBuilder;
    void rolloverIndex(RolloverRequest request, ActionListener<RolloverResponse> listener);
     * @param listener A listener to be notified with a result
     */
    /**
import org.opensearch.action.admin.indices.template.get.GetIndexTemplatesRequestBuilder;
    /** Resolve index - CompletionStage version */
public interface IndicesAdminClient extends OpenSearchClient {
    /**  
import org.opensearch.common.Nullable;
    /** Pause ingestion */
import org.opensearch.action.admin.indices.streamingingestion.resume.ResumeIngestionResponse;
     */
     */  
    ForceMergeRequestBuilder prepareForceMerge(String... indices);
     * @param request  The flush request  
     * @return A result future  
     */
        close(request, ActionListener.wrap(future::complete, future::completeExceptionally));
import org.opensearch.action.admin.indices.settings.put.UpdateSettingsRequest;
    /**
    ActionFuture<PauseIngestionResponse> pauseIngestion(PauseIngestionRequest request);  
 * software distributed under the License is distributed on an
        CompletableFuture<RecoveryResponse> future = new CompletableFuture<>();  
        CompletableFuture<AcknowledgedResponse> future = new CompletableFuture<>();
    ActionFuture<AcknowledgedResponse> updateSettings(UpdateSettingsRequest request);  
     */  
    ActionFuture<CreateIndexResponse> create(CreateIndexRequest request);
     * Allows to add/remove aliases from indices.
        return future;
    ActionFuture<AcknowledgedResponse> aliases(IndicesAliasesRequest request);
     * @param request The refresh request
     * Deletes an index based on the index name.  
     *
    void upgrade(UpgradeRequest request, ActionListener<UpgradeResponse> listener);
     * @return A result future
    /**
     */
     */
     * Puts an index template.
import org.opensearch.action.admin.indices.mapping.put.PutMappingRequest;
    void resolveIndex(ResolveIndexAction.Request request, ActionListener<ResolveIndexAction.Response> listener);
     * @param request The index aliases request
    /**
import org.opensearch.action.admin.indices.upgrade.post.UpgradeResponse;
     * @param request the update settings request  
 * @see AdminClient#indices()  
     *
     * Allows to add/remove aliases from indices.
     *  
     * @param listener A listener to be notified with a result
     *Indices recoveries  
    /**
    /**
 *
    /** Clear cache - CompletionStage version */  
     */  
     * @param listener A listener to be notified with a result
    /**  
import org.opensearch.action.admin.indices.cache.clear.ClearIndicesCacheRequest;
    /**  
     * @param request  the update settings request
        CompletableFuture<UpgradeResponse> future = new CompletableFuture<>();  
 * not use this file except in compliance with the License.
import org.opensearch.action.admin.indices.streamingingestion.pause.PauseIngestionRequest;
     */  
     * @param listener A listener to be notified with a result  
    }  
    /**  
     *  
        getIngestionState(request, ActionListener.wrap(future::complete, future::completeExceptionally));
     */
 * specific language governing permissions and limitations
     */
    void open(OpenIndexRequest request, ActionListener<OpenIndexResponse> listener);
import org.opensearch.action.admin.indices.delete.DeleteIndexRequest;
     */
import org.opensearch.action.admin.indices.alias.IndicesAliasesRequestBuilder;
    /**
    default CompletionStage<GetIngestionStateResponse> getIngestionStateAsync(GetIngestionStateRequest request) {
    void getFieldMappings(GetFieldMappingsRequest request, ActionListener<GetFieldMappingsResponse> listener);
        shardStores(request, ActionListener.wrap(future::complete, future::completeExceptionally));
 * KIND, either express or implied.  See the License for the
        return future;  
     * Explicitly flush one or more indices (releasing memory from the node).
    /**
    /** Get data streams - CompletionStage version */  
     * @param request The delete index request
     *  
        getAliases(request, ActionListener.wrap(future::complete, future::completeExceptionally));
    ActionFuture<GetSettingsResponse> getSettings(GetSettingsRequest request);
     *
     *  
     * @param request  The refresh request
     * @param listener A listener to be notified with a result
     */
    /** Create index - CompletionStage version */
     * @param listener A listener to be notified with a result  
    void resumeIngestion(ResumeIngestionRequest request, ActionListener<ResumeIngestionResponse> listener);  
import org.opensearch.action.admin.indices.validate.query.ValidateQueryRequest;
     * Indices recoveries
    /** Resume ingestion */
     * The status of one or more indices.
    /**
    /** Get field mappings - CompletionStage version */
     * @see Requests#putMappingRequest(String...)
    default CompletionStage<RolloverResponse> rolloverIndexAsync(RolloverRequest request) {
    default CompletionStage<ResumeIngestionResponse> resumeIngestionAsync(ResumeIngestionRequest request) {
     */
     * Analyze text under the provided index.
    ActionFuture<GetIndexTemplatesResponse> getTemplates(GetIndexTemplatesRequest request);
     */
    ActionFuture<RolloverResponse> rolloverIndex(RolloverRequest request);  
     * @see Requests#openIndexRequest(String)  
    /** Get aliases - CompletionStage version */
     */
        rolloverIndex(request, ActionListener.wrap(future::complete, future::completeExceptionally));  
     * The shard stores info of one or more indices.  
    default CompletionStage<CreateIndexResponse> createAsync(CreateIndexRequest request) {  
     * @param indices the indices to fetch the setting for.
     *  
        CompletableFuture<GetMappingsResponse> future = new CompletableFuture<>();
     */  
     */  
    default CompletionStage<PauseIngestionResponse> pauseIngestionAsync(PauseIngestionRequest request) {  
     * @return The result future  
    ActionFuture<IndicesSegmentResponse> segments(IndicesSegmentsRequest request);
     */
    /**
        CompletableFuture<AcknowledgedResponse> future = new CompletableFuture<>();
     * @param listener A listener to be notified with a result
     *
 * @opensearch.api
        return future;
    /**
import org.opensearch.action.admin.indices.refresh.RefreshRequest;  
    /**
     * @param request The indices shard stores request
        return future;  
    void getDataStreams(GetDataStreamAction.Request request, ActionListener<GetDataStreamAction.Response> listener);  
import org.opensearch.action.admin.indices.flush.FlushRequest;
        CompletableFuture<FlushResponse> future = new CompletableFuture<>();
    /**
    }
     *
     * Add mapping definition for a type into one or more indices.  
import org.opensearch.action.admin.indices.template.put.PutIndexTemplateRequest;  
     */  
    /**
        return future;
    }
     *
    /**
        pauseIngestion(request, ActionListener.wrap(future::complete, future::completeExceptionally));
     * Store a data stream
     */  
    }
 */  
    ActionFuture<GetMappingsResponse> getMappings(GetMappingsRequest request);
import org.opensearch.action.admin.indices.rollover.RolloverRequestBuilder;
     */
    /**  
     * @param name The name of the template.
    /** Indices Exists - CompletionStage version */
     * @param request The result future
        return future;
     * Deletes index template.
     * @param listener A listener to be notified with a result
    ActionFuture<AcknowledgedResponse> deleteTemplate(DeleteIndexTemplateRequest request);  
    ActionFuture<ResizeResponse> resizeIndex(ResizeRequest request);  
     * Get specific index aliases that exists in particular indices and / or by name.
     *
    /**
        getFieldMappings(request, ActionListener.wrap(future::complete, future::completeExceptionally));
import org.opensearch.action.admin.indices.mapping.get.GetFieldMappingsResponse;  
import org.opensearch.action.admin.indices.rollover.RolloverRequest;
    }
    ActionFuture<RefreshResponse> refresh(RefreshRequest request);
     */
     * @param request The count request
     * Get index metadata for particular indices.  
     */
    /**  
import org.opensearch.action.admin.indices.shrink.ResizeRequest;
    /**
        segmentReplicationStats(request, ActionListener.wrap(future::complete, future::completeExceptionally));
        deleteDataStream(request, ActionListener.wrap(future::complete, future::completeExceptionally));
    /**
     * Swaps the index pointed to by an alias given all provided conditions are satisfied
        return future;
     * @param request  The count request
    /**
    /** Upgrade - CompletionStage version */
     * Explicitly refresh one or more indices (making the content indexed since the last refresh searchable).
    /**
     * Indices recoveries  
    /**
     * @param block   The block to add
    void getSettings(GetSettingsRequest request, ActionListener<GetSettingsResponse> listener);
        return future;
     * @see Requests#indicesShardStoresRequest(String...)
 * GitHub history for details.
    OpenIndexRequestBuilder prepareOpen(String... indices);
    /** Pause ingestion */
     * @param request  The index aliases request
        updateSettings(request, ActionListener.wrap(future::complete, future::completeExceptionally));
     * Executed a per index settings get request and returns the settings for the indices specified.  
    /**
     */
     * Explicitly upgrade one or more indices
     */
    ActionFuture<ClearIndicesCacheResponse> clearCache(ClearIndicesCacheRequest request);
     * Check upgrade status of one or more indices
import java.util.concurrent.CompletableFuture;  
     */  
    default CompletionStage<AcknowledgedResponse> deleteTemplateAsync(DeleteIndexTemplateRequest request) {  
    default CompletionStage<AcknowledgedResponse> createDataStreamAsync(CreateDataStreamAction.Request request) {
     */
    /**  
import org.opensearch.action.admin.indices.streamingingestion.pause.PauseIngestionResponse;
    void stats(IndicesStatsRequest request, ActionListener<IndicesStatsResponse> listener);
     * @param request  The indices status request
     */
     *  
     */  
    /**  
     * Indices stats.  
    default CompletionStage<AcknowledgedResponse> deleteDataStreamAsync(DeleteDataStreamAction.Request request) {  
     * Adds a block to an index
     * Explicitly refresh one or more indices (making the content indexed since the last refresh searchable).
     *
     * @param request The create index request
     * @param listener A listener to be notified with a result
     * @return A result future
     * Store a data stream
 */  
    /**
     *  
        CompletableFuture<GetIngestionStateResponse> future = new CompletableFuture<>();  
    default CompletionStage<UpgradeResponse> upgradeAsync(UpgradeRequest request) {
    }  
     */
    ActionFuture<ResumeIngestionResponse> resumeIngestion(ResumeIngestionRequest request);  
     */
     * Gets an index template.
import org.opensearch.action.admin.indices.upgrade.get.UpgradeStatusResponse;
        return future;
    /**
     * Get index metadata for particular indices.  
        getMappings(request, ActionListener.wrap(future::complete, future::completeExceptionally));  
     */
        CompletableFuture<AddIndexBlockResponse> future = new CompletableFuture<>();
    void refresh(RefreshRequest request, ActionListener<RefreshResponse> listener);
import org.opensearch.action.admin.indices.create.CreateIndexRequest;
     * Indices Exists.
    }
        return future;
import org.opensearch.action.admin.indices.refresh.RefreshRequestBuilder;
     */  
    /**  
    }
    /**
import org.opensearch.action.admin.indices.create.CreateIndexRequestBuilder;  
        CompletableFuture<IndicesShardStoresResponse> future = new CompletableFuture<>();  
    default CompletionStage<UpgradeStatusResponse> upgradeStatusAsync(UpgradeStatusRequest request) {  
    /** Resume ingestion */
     */
    default CompletionStage<AcknowledgedResponse> updateSettingsAsync(UpdateSettingsRequest request) {
    /** Segment replication stats - CompletionStage version */
     */
     * Delete a data stream
        return future;  
    /**
     *
        resolveIndex(request, ActionListener.wrap(future::complete, future::completeExceptionally));
    }
    }  
     * @see Requests#indicesExistsRequest(String...)  
    default CompletionStage<ValidateQueryResponse> validateQueryAsync(ValidateQueryRequest request) {
     * Deletes an index template.
    default CompletionStage<GetMappingsResponse> getMappingsAsync(GetMappingsRequest request) {
    AnalyzeRequestBuilder prepareAnalyze(@Nullable String index, String text);
        CompletableFuture<GetFieldMappingsResponse> future = new CompletableFuture<>();  
     */
 * this work for additional information regarding copyright
     * Deletes an index template.  
     */  
    /**  
     */
    /** Resume ingestion - CompletionStage version */  
        resizeIndex(request, ActionListener.wrap(future::complete, future::completeExceptionally));
    /**  
     */  
     */
    /** Get ingestion state */
    void validateQuery(ValidateQueryRequest request, ActionListener<ValidateQueryResponse> listener);
    /** Rollover index - CompletionStage version */  
        return future;
    default CompletionStage<IndicesStatsResponse> statsAsync(IndicesStatsRequest request) {
     * The segments of one or more indices.
     * @param request The indices exists request
        return future;
import org.opensearch.action.admin.indices.alias.get.GetAliasesRequest;  
    default CompletionStage<AnalyzeAction.Response> analyzeAsync(AnalyzeAction.Request request) {
    /** Delete index - CompletionStage version */  
     * @param indices The indices to delete. Use "_all" to delete all indices.
        CompletableFuture<RolloverResponse> future = new CompletableFuture<>();
import org.opensearch.action.admin.indices.readonly.AddIndexBlockRequest;  
     * Get the mappings of specific fields
        return future;  
     * @param request The upgrade request
     * @param request  The close index request  
    void shardStores(IndicesShardStoresRequest request, ActionListener<IndicesShardStoresResponse> listener);  
    default CompletionStage<FlushResponse> flushAsync(FlushRequest request) {  
    /**  
     * @return The result future
     * @see Requests#upgradeRequest(String...)  
     */
    /**
     *
    /**
import org.opensearch.action.admin.indices.upgrade.get.UpgradeStatusRequest;
    /**
     */
    }
    /**
    /**
    /** Get settings - CompletionStage version */
     */
        CompletableFuture<IndicesSegmentResponse> future = new CompletableFuture<>();
        getSettings(request, ActionListener.wrap(future::complete, future::completeExceptionally));
 * under the License.  
        getDataStreams(request, ActionListener.wrap(future::complete, future::completeExceptionally));  
     *
 * Administrative actions/operations against indices.
        recoveries(request, ActionListener.wrap(future::complete, future::completeExceptionally));
    ActionFuture<IndicesShardStoresResponse> shardStores(IndicesShardStoresRequest request);  
import org.opensearch.action.admin.indices.flush.FlushRequestBuilder;
     * @param request The clear indices cache request
    }  
    ActionFuture<AcknowledgedResponse> createDataStream(CreateDataStreamAction.Request request);  
     * @param request The result future  
    /** Force-merge - CompletionStage version */  
     */
     */
     * @param text  The text to analyze
    /** Resize index - CompletionStage version */
    /**
import org.opensearch.action.admin.indices.close.CloseIndexRequestBuilder;  
    UpdateSettingsRequestBuilder prepareUpdateSettings(String... indices);
     * @see #getSettings(GetSettingsRequest)  
import org.opensearch.action.admin.indices.segments.IndicesSegmentResponse;
import org.opensearch.action.admin.indices.validate.query.ValidateQueryRequestBuilder;  
     * Indices segment replication
     */
    /**
import org.opensearch.action.admin.indices.datastream.CreateDataStreamAction;
import org.opensearch.action.admin.indices.resolve.ResolveIndexAction;  
    /**
     */
    }
import org.opensearch.common.action.ActionFuture;
     * @see Requests#indicesSegmentsRequest(String...)
        CompletableFuture<AcknowledgedResponse> future = new CompletableFuture<>();
     * @return The result future
     * @param request  The add index block request  
     * Analyze text/texts.
    default CompletionStage<AcknowledgedResponse> aliasesAsync(IndicesAliasesRequest request) {
    }  
     * Puts an index template.  
     */  
    GetIndexRequestBuilder prepareGetIndex();
    /**
    /**  
    /**
    default CompletionStage<RecoveryResponse> recoveriesAsync(RecoveryRequest request) {
    ActionFuture<FlushResponse> flush(FlushRequest request);
     */  
        CompletableFuture<AcknowledgedResponse> future = new CompletableFuture<>();  
     */  
    }
    /**
     * Creates an index using an explicit request allowing to specify the settings of the index.
     * @param request  The index aliases request  
    /**
     */
    void close(CloseIndexRequest request, ActionListener<CloseIndexResponse> listener);
import org.opensearch.action.admin.indices.get.GetIndexRequest;
     * @param name The name of the template.
        return future;  
    /** Get templates - CompletionStage version */  
        return future;
 *
    /** Shard stores - CompletionStage version */
        delete(request, ActionListener.wrap(future::complete, future::completeExceptionally));  
        CompletableFuture<SegmentReplicationStatsResponse> future = new CompletableFuture<>();
    default CompletionStage<GetAliasesResponse> getAliasesAsync(GetAliasesRequest request) {
        validateQuery(request, ActionListener.wrap(future::complete, future::completeExceptionally));
     */
/**  
    ActionFuture<RecoveryResponse> recoveries(RecoveryRequest request);  
     * Get specific index aliases that exists in particular indices and / or by name.
     * Returns a builder for a per index settings get request.
     * @param listener A listener to be notified with a result
    ActionFuture<CloseIndexResponse> close(CloseIndexRequest request);
    default CompletionStage<GetFieldMappingsResponse> getFieldMappingsAsync(GetFieldMappingsRequest request) {
import org.opensearch.action.admin.indices.delete.DeleteIndexRequestBuilder;  
import java.util.concurrent.CompletionStage;
    AnalyzeRequestBuilder prepareAnalyze(String text);
     *
    default CompletionStage<AcknowledgedResponse> deleteAsync(DeleteIndexRequest request) {
     * @param request The indices shard stores request
    ActionFuture<ValidateQueryResponse> validateQuery(ValidateQueryRequest request);
    /**
import org.opensearch.action.admin.indices.open.OpenIndexRequestBuilder;
     * @return The result future
    UpgradeStatusRequestBuilder prepareUpgradeStatus(String... indices);
    /**
        CompletableFuture<PauseIngestionResponse> future = new CompletableFuture<>();
        return future;
    }
     * Open an index based on the index name.
    default CompletionStage<IndicesShardStoresResponse> shardStoresAsync(IndicesShardStoresRequest request) {
     */  
     * @return The request builder configured with the specified scaling direction
     */
    void exists(IndicesExistsRequest request, ActionListener<IndicesExistsResponse> listener);
    ActionFuture<AcknowledgedResponse> delete(DeleteIndexRequest request);  
    /** Analyze - CompletionStage version */  
     * @return The result future
     * Update indices settings.
import org.opensearch.action.admin.indices.stats.IndicesStatsRequestBuilder;
     * @see Requests#openIndexRequest(String)
     */
     * Analyze text.
     *
     */  
     */
import org.opensearch.action.admin.indices.exists.indices.IndicesExistsRequestBuilder;
    void flush(FlushRequest request, ActionListener<FlushResponse> listener);
     */  
import org.opensearch.action.admin.indices.settings.get.GetSettingsRequestBuilder;  
    IndicesAliasesRequestBuilder prepareAliases();
     * Add mapping definition for a type into one or more indices.  
     */
    /**  
    /**
     */
     *
        CompletableFuture<IndicesStatsResponse> future = new CompletableFuture<>();
    ClearIndicesCacheRequestBuilder prepareClearCache(String... indices);
    ActionFuture<GetIngestionStateResponse> getIngestionState(GetIngestionStateRequest request);  
 */  
     * Resolves names and wildcard expressions to indices, aliases, and data streams
     * @param listener A listener to be notified with a result
     *
import org.opensearch.action.admin.indices.replication.SegmentReplicationStatsResponse;
    void forceMerge(ForceMergeRequest request, ActionListener<ForceMergeResponse> listener);  
import org.opensearch.action.admin.indices.datastream.GetDataStreamAction;
    /** Segments - CompletionStage version */  
import org.opensearch.action.admin.indices.rollover.RolloverResponse;  
    GetMappingsRequestBuilder prepareGetMappings(String... indices);  
    void clearCache(ClearIndicesCacheRequest request, ActionListener<ClearIndicesCacheResponse> listener);
     * Resolves names and wildcard expressions to indices, aliases, and data streams
     * Explicitly force merge one or more indices into a the number of segments.  
     * @see Requests#indicesShardStoresRequest(String...)
     *
    }
    default CompletionStage<SegmentReplicationStatsResponse> segmentReplicationStatsAsync(SegmentReplicationStatsRequest request) {  
    PutMappingRequestBuilder preparePutMapping(String... indices);
     * @param request The close index request  
    /**
import org.opensearch.action.admin.indices.open.OpenIndexResponse;
    /** Delete data stream - CompletionStage version */
 * this file be licensed under the Apache-2.0 license or a
     * Get index metadata for particular indices.
 *  
    ScaleIndexRequestBuilder prepareScaleSearchOnly(String index, boolean searchOnly);  
     * Get the complete mappings of one or more types  
import org.opensearch.action.admin.indices.template.put.PutIndexTemplateRequestBuilder;
    /**
     */
import org.opensearch.action.admin.indices.shrink.ResizeRequestBuilder;
    /**
    /** Refresh - CompletionStage version */
import org.opensearch.action.admin.indices.cache.clear.ClearIndicesCacheRequestBuilder;  
import org.opensearch.action.admin.indices.template.delete.DeleteIndexTemplateRequestBuilder;
    }
/*  
    }
import org.opensearch.action.admin.indices.forcemerge.ForceMergeResponse;  
    default CompletionStage<AddIndexBlockResponse> addBlockAsync(AddIndexBlockRequest request) {
    /**
     * Prepares a request to scale an index between normal and search-only modes.  
    /**
     * Note: this is a per index request and will not include settings that are set on the cluster
    /**  
import org.opensearch.action.admin.indices.shrink.ResizeResponse;  
        refresh(request, ActionListener.wrap(future::complete, future::completeExceptionally));
import org.opensearch.action.admin.indices.streamingingestion.state.GetIngestionStateRequest;
     * @param request  The index aliases request
import org.opensearch.action.admin.indices.recovery.RecoveryRequestBuilder;
    /** Recoveries - CompletionStage version */
    /**
     */  
     * @see Requests#closeIndexRequest(String)
     * @param request  The clear indices cache request
    /**  
     * @see Requests#createIndexRequest(String)  
     * @param indices The name of the indices to close  
    ValidateQueryRequestBuilder prepareValidateQuery(String... indices);  
     *
        return future;
    /** Indices stats - CompletionStage version */  
    default CompletionStage<GetIndexResponse> getIndexAsync(GetIndexRequest request) {  
import org.opensearch.action.admin.indices.get.GetIndexResponse;  
 * The OpenSearch Contributors require contributions made to  
     * Closes an index based on the index name.
     *
import org.opensearch.action.admin.indices.mapping.get.GetFieldMappingsRequestBuilder;
import org.opensearch.action.admin.indices.refresh.RefreshResponse;
     * Explicitly refresh one or more indices (making the content indexed since the last refresh searchable).
    /**  
    SegmentReplicationStatsRequestBuilder prepareSegmentReplicationStats(String... indices);
     */
    default CompletionStage<IndicesSegmentResponse> segmentsAsync(IndicesSegmentsRequest request) {
    }
        forceMerge(request, ActionListener.wrap(future::complete, future::completeExceptionally));  
 *
    }  
    ActionFuture<IndicesStatsResponse> stats(IndicesStatsRequest request);  
import org.opensearch.action.admin.indices.settings.get.GetSettingsRequest;
    default CompletionStage<IndicesExistsResponse> existsAsync(IndicesExistsRequest request) {  
     * Closes an index based on the index name.
        getIndex(request, ActionListener.wrap(future::complete, future::completeExceptionally));
     */  
     * @param listener A listener to be notified of the result
import org.opensearch.action.admin.indices.recovery.RecoveryResponse;
    /**  
     */
     * Analyze text under the provided index.
     * @return A result future
    RolloverRequestBuilder prepareRolloverIndex(String sourceAlias);
     * @param request The indices segments request  
     * Updates settings of one or more indices.  
        CompletableFuture<AnalyzeAction.Response> future = new CompletableFuture<>();
import org.opensearch.action.admin.indices.mapping.get.GetMappingsRequestBuilder;
     *Indices segment replication
     * Add mapping definition for a type into one or more indices.  
     * Analyze text under the provided index.  
     */  
import org.opensearch.action.admin.indices.close.CloseIndexResponse;
    /**  
     * @param listener A listener to be notified with the response  
    /**  
    ResizeRequestBuilder prepareResizeIndex(String sourceIndex, String targetIndex);
     * @see Requests#upgradeRequest(String...)
import org.opensearch.action.admin.indices.forcemerge.ForceMergeRequestBuilder;
import org.opensearch.action.admin.indices.segments.IndicesSegmentsRequest;  
    ActionFuture<AnalyzeAction.Response> analyze(AnalyzeAction.Request request);  
    default CompletionStage<ResizeResponse> resizeIndexAsync(ResizeRequest request) {  
    /** Flush - CompletionStage version */
     * @param request The create mapping request
     */
    ActionFuture<ResolveIndexAction.Response> resolveIndex(ResolveIndexAction.Request request);  
import org.opensearch.action.admin.indices.get.GetIndexRequestBuilder;
    IndicesSegmentsRequestBuilder prepareSegments(String... indices);  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
     */  
     * Explicitly flush one or more indices (releasing memory from the node).
     */  
     */
    /**  
        return future;
        return future;
     */
        return future;  
import org.opensearch.action.admin.indices.stats.IndicesStatsRequest;
import org.opensearch.action.admin.indices.streamingingestion.resume.ResumeIngestionRequest;  
     * @param listener A listener to be notified with a result  
        open(request, ActionListener.wrap(future::complete, future::completeExceptionally));
    CreateIndexRequestBuilder prepareCreate(String index);  
    IndicesExistsRequestBuilder prepareExists(String... indices);
import org.opensearch.action.admin.indices.settings.put.UpdateSettingsRequestBuilder;  
     * Get the mappings of specific fields
    DeleteIndexRequestBuilder prepareDelete(String... indices);
    RefreshRequestBuilder prepareRefresh(String... indices);
import org.opensearch.action.admin.indices.segments.IndicesSegmentsRequestBuilder;
     */  
import org.opensearch.action.admin.indices.shards.IndicesShardStoreRequestBuilder;
    default CompletionStage<RefreshResponse> refreshAsync(RefreshRequest request) {
     * @return The result future
     *
import org.opensearch.cluster.metadata.IndexMetadata.APIBlock;  
 * SPDX-License-Identifier: Apache-2.0
     */  
     * @see Requests#flushRequest(String...)
 * license agreements. See the NOTICE file distributed with
    /** Upgrade status - CompletionStage version */
import org.opensearch.action.admin.indices.datastream.DeleteDataStreamAction;  
    /** Get mappings - CompletionStage version */  
    default CompletionStage<GetIndexTemplatesResponse> getTemplatesAsync(GetIndexTemplatesRequest request) {
        deleteTemplate(request, ActionListener.wrap(future::complete, future::completeExceptionally));
    /**
     * The segments of one or more indices.
    /** Add index block - CompletionStage version */  
    ActionFuture<GetDataStreamAction.Response> getDataStreams(GetDataStreamAction.Request request);
 * compatible open source license.
import org.opensearch.action.admin.indices.streamingingestion.state.GetIngestionStateResponse;  
     * Clear indices cache.
    default CompletionStage<AcknowledgedResponse> putMappingAsync(PutMappingRequest request) {  
        CompletableFuture<UpgradeStatusResponse> future = new CompletableFuture<>();
     * Indices exists.
import org.opensearch.action.admin.indices.replication.SegmentReplicationStatsRequest;  
        analyze(request, ActionListener.wrap(future::complete, future::completeExceptionally));  
    /**
     *  
import org.opensearch.action.admin.indices.stats.IndicesStatsResponse;  
     * Opens one or more indices based on their index name.
import org.opensearch.action.admin.indices.open.OpenIndexRequest;  
     *  
    }
 * Modifications Copyright OpenSearch Contributors. See
     * Resize an index using an explicit request allowing to specify the settings, mappings and aliases of the target index of the index.
    ActionFuture<SegmentReplicationStatsResponse> segmentReplicationStats(SegmentReplicationStatsRequest request);
     * @param searchOnly Whether to scale to search-only mode (true) or back to normal mode (false)  
     * @see Requests#deleteIndexRequest(String)
/*  
    /**  
     */  
import org.opensearch.action.admin.indices.cache.clear.ClearIndicesCacheResponse;
     * @param request  The upgrade request
     * @see Requests#indexAliasesRequest()  
     * @param listener A listener to be notified with a result
import org.opensearch.action.admin.indices.analyze.AnalyzeAction;  
    /**
    default CompletionStage<AcknowledgedResponse> putTemplateAsync(PutIndexTemplateRequest request) {
    /**  
     */
    /**
    }  
     * @see Requests#forceMergeRequest(String...)
        return future;
import org.opensearch.action.admin.indices.alias.IndicesAliasesRequest;
    /**  
        CompletableFuture<GetIndexResponse> future = new CompletableFuture<>();
     * @see Requests#openIndexRequest(String)  
    /**
     * @see #getSettings(GetSettingsRequest)
     * The shard stores info of one or more indices.  
     * Executed a per index settings get request.
    default CompletionStage<OpenIndexResponse> openAsync(OpenIndexRequest request) {  
    /**  
     * Swaps the index pointed to by an alias given all provided conditions are satisfied  
     * Clear indices cache.
     *  
     */  
     *
import org.opensearch.action.admin.indices.template.delete.DeleteIndexTemplateRequest;
    /**
     *  Explicitly upgrade one or more indices
     */
     * Clear indices cache.
        CompletableFuture<RefreshResponse> future = new CompletableFuture<>();  
     * @param listener A listener to be notified with a result
     * @see Requests#closeIndexRequest(String)
    /**  
    void updateSettings(UpdateSettingsRequest request, ActionListener<AcknowledgedResponse> listener);
        return future;
     *  
     *  
/*
        stats(request, ActionListener.wrap(future::complete, future::completeExceptionally));  
 */
import org.opensearch.action.admin.indices.recovery.RecoveryRequest;  
    }
     */
     * Get specific index aliases that exists in particular indices and / or by name.
     */
     * @param request  The delete index request
     *  
        CompletableFuture<IndicesExistsResponse> future = new CompletableFuture<>();
     *  
        upgradeStatus(request, ActionListener.wrap(future::complete, future::completeExceptionally));
        CompletableFuture<AcknowledgedResponse> future = new CompletableFuture<>();  
    }
     */
    /** Get ingestion state - CompletionStage version */
     * @param request  The close index request
     *  
     * @return The result future  
    }
     */
     * Get data streams  
        return future;  
     * @param request  The create mapping request
        CompletableFuture<ResizeResponse> future = new CompletableFuture<>();
    /**
     * @param indices The name of the indices to add the block to
    DeleteIndexTemplateRequestBuilder prepareDeleteTemplate(String name);  
     */
    /** Get index - CompletionStage version */
    default CompletionStage<ClearIndicesCacheResponse> clearCacheAsync(ClearIndicesCacheRequest request) {
    IndicesStatsRequestBuilder prepareStats(String... indices);
 * Unless required by applicable law or agreed to in writing,
        createDataStream(request, ActionListener.wrap(future::complete, future::completeExceptionally));
    }
     * @see Requests#upgradeRequest(String...)  
    void putMapping(PutMappingRequest request, ActionListener<AcknowledgedResponse> listener);  
    ActionFuture<GetIndexResponse> getIndex(GetIndexRequest request);
    void create(CreateIndexRequest request, ActionListener<CreateIndexResponse> listener);
     */  
     *Indices segment replication
     */  
    /**
    /**  
        return future;
    GetFieldMappingsRequestBuilder prepareGetFieldMappings(String... indices);
 * ownership. Elasticsearch licenses this file to you under  
     * @see Requests#clearIndicesCacheRequest(String...)  
    void segments(IndicesSegmentsRequest request, ActionListener<IndicesSegmentResponse> listener);
import org.opensearch.action.admin.indices.analyze.AnalyzeRequestBuilder;
     * Get the complete mappings of one or more types
 *
        CompletableFuture<ResumeIngestionResponse> future = new CompletableFuture<>();
        segments(request, ActionListener.wrap(future::complete, future::completeExceptionally));  
        return future;  
    }
    void getIngestionState(GetIngestionStateRequest request, ActionListener<GetIngestionStateResponse> listener);  
     */
    void putTemplate(PutIndexTemplateRequest request, ActionListener<AcknowledgedResponse> listener);  
    default CompletionStage<CloseIndexResponse> closeAsync(CloseIndexRequest request) {
     * Explicitly flush one or more indices (releasing memory from the node).
    }  
     * @param listener A listener to be notified with a result
import org.opensearch.action.admin.indices.close.CloseIndexRequest;
     *
import org.opensearch.action.admin.indices.mapping.get.GetFieldMappingsRequest;
     * Indices stats.
     * @param request The flush request  
     * Get the mappings of specific fields  
     * @see Requests#refreshRequest(String...)  
     * Validate a query for correctness.
    void resizeIndex(ResizeRequest request, ActionListener<ResizeResponse> listener);
import org.opensearch.action.admin.indices.shards.IndicesShardStoresRequest;
     * level. This request is not exhaustive, it will not return default values for setting.
     */
     * @see Requests#putMappingRequest(String...)
    AnalyzeRequestBuilder prepareAnalyze();
     *  
import org.opensearch.action.admin.indices.readonly.AddIndexBlockRequestBuilder;
     *
     *
    ActionFuture<AcknowledgedResponse> putMapping(PutMappingRequest request);  
     */  
import org.opensearch.action.admin.indices.alias.get.GetAliasesResponse;
    void delete(DeleteIndexRequest request, ActionListener<AcknowledgedResponse> listener);  
import org.opensearch.action.admin.indices.exists.indices.IndicesExistsResponse;  
    /**
     */
    void getIndex(GetIndexRequest request, ActionListener<GetIndexResponse> listener);  
     * Deletes an index based on the index name.  
 * the Apache License, Version 2.0 (the "License"); you may
    void deleteDataStream(DeleteDataStreamAction.Request request, ActionListener<AcknowledgedResponse> listener);
     * Check upgrade status of one or more indices
        return future;  
import org.opensearch.core.action.ActionListener;
     */
    ActionFuture<AcknowledgedResponse> putTemplate(PutIndexTemplateRequest request);
     * @param index The index name
    /**
        return future;  
     */
    ActionFuture<ForceMergeResponse> forceMerge(ForceMergeRequest request);  
import org.opensearch.action.admin.indices.replication.SegmentReplicationStatsRequestBuilder;
        CompletableFuture<ClearIndicesCacheResponse> future = new CompletableFuture<>();
    ActionFuture<IndicesExistsResponse> exists(IndicesExistsRequest request);
     * Updates settings of one or more indices.
    FlushRequestBuilder prepareFlush(String... indices);  
package org.opensearch.transport.client;
     * Deletes an index based on the index name.  
    /**
     * @param text The text to analyze  
    ActionFuture<UpgradeStatusResponse> upgradeStatus(UpgradeStatusRequest request);
     * Get the complete mappings of one or more types
    }  
import org.opensearch.action.admin.indices.upgrade.get.UpgradeStatusRequestBuilder;  
     * Creates an index using an explicit request allowing to specify the settings of the index.
        return future;
    ActionFuture<OpenIndexResponse> open(OpenIndexRequest request);
    /** Open index - CompletionStage version */
        return future;  
        putTemplate(request, ActionListener.wrap(future::complete, future::completeExceptionally));
@PublicApi(since = "1.0.0")
    }  
     */
    /**
     */  
    /** Pause ingestion - CompletionStage version */
    /**  
import org.opensearch.action.admin.indices.mapping.put.PutMappingRequestBuilder;
     * Indices stats.
     */
    /** Put mapping - CompletionStage version */
     * Allows to add/remove aliases from indices.
     * @param listener A listener to be notified with a result
    /**
     * Shrinks an index using an explicit request allowing to specify the settings, mappings and aliases of the target index of the index.  
import org.opensearch.common.annotation.PublicApi;  
     * @param request The close index request
     * @see Requests#upgradeRequest(String...)
    void addBlock(AddIndexBlockRequest request, ActionListener<AddIndexBlockResponse> listener);
     * @see Requests#refreshRequest(String...)  
        CompletableFuture<GetIndexTemplatesResponse> future = new CompletableFuture<>();
     */
    default CompletionStage<GetDataStreamAction.Response> getDataStreamsAsync(GetDataStreamAction.Request request) {
 * Licensed to Elasticsearch under one or more contributor  
        aliases(request, ActionListener.wrap(future::complete, future::completeExceptionally));  
    void createDataStream(CreateDataStreamAction.Request request, ActionListener<AcknowledgedResponse> listener);
     */
    /**
     * @param request The optimize request
     * Swaps the index pointed to by an alias given all provided conditions are satisfied
    /** Update settings - CompletionStage version */
    }  
    /**  
     * Adds a block to an index
     *
     * @param request  The create index request
     *
     * Check upgrade status of one or more indices
    /** Get ingestion state */
        return future;
import org.opensearch.action.admin.indices.readonly.AddIndexBlockResponse;
import org.opensearch.action.admin.indices.upgrade.post.UpgradeRequest;
        return future;
    /**
    /**  
    /**
     *
        clearCache(request, ActionListener.wrap(future::complete, future::completeExceptionally));  
    /**  
     * Validate a query for correctness.
     * @see Requests#clearIndicesCacheRequest(String...)  
        return future;
        return future;
}
     *  
    CloseIndexRequestBuilder prepareClose(String... indices);
    UpgradeRequestBuilder prepareUpgrade(String... indices);  
        create(request, ActionListener.wrap(future::complete, future::completeExceptionally));
        return future;  
import org.opensearch.action.admin.indices.validate.query.ValidateQueryResponse;
    GetAliasesRequestBuilder prepareGetAliases(String... aliases);  
    void getMappings(GetMappingsRequest request, ActionListener<GetMappingsResponse> listener);
    ActionFuture<GetFieldMappingsResponse> getFieldMappings(GetFieldMappingsRequest request);  
    /**
    /** Aliases - CompletionStage version */  
     * @return The result future
     *  
     * @return A result future  
    /**  
     * Get data streams
     */
    void getTemplates(GetIndexTemplatesRequest request, ActionListener<GetIndexTemplatesResponse> listener);
    /**
    }
import org.opensearch.action.admin.indices.create.CreateIndexResponse;
    GetIndexTemplatesRequestBuilder prepareGetTemplates(String... name);  
        exists(request, ActionListener.wrap(future::complete, future::completeExceptionally));
    /**
    }  
     * @param listener A listener to be notified with a result
        CompletableFuture<AcknowledgedResponse> future = new CompletableFuture<>();  
    default CompletionStage<ForceMergeResponse> forceMergeAsync(ForceMergeRequest request) {
    void aliases(IndicesAliasesRequest request, ActionListener<AcknowledgedResponse> listener);
    }
    /** Close index - CompletionStage version */
     */  
     * Delete a data stream  
     * Explicitly upgrade one or more indices
    ActionFuture<AcknowledgedResponse> deleteDataStream(DeleteDataStreamAction.Request request);
        CompletableFuture<ForceMergeResponse> future = new CompletableFuture<>();
import org.opensearch.action.admin.indices.exists.indices.IndicesExistsRequest;
     * @param indices The name of the indices to close  
     * @see Requests#indicesExistsRequest(String...)  
     * The segments of one or more indices.
     * Gets index template.  
    /**
     * Closes one or more indices based on their index name.
import org.opensearch.action.admin.indices.shards.IndicesShardStoresResponse;  
        CompletableFuture<OpenIndexResponse> future = new CompletableFuture<>();
        return future;  
    GetSettingsRequestBuilder prepareGetSettings(String... indices);
     * @param listener A listener to be notified with a result  
 *     http://www.apache.org/licenses/LICENSE-2.0
        CompletableFuture<ValidateQueryResponse> future = new CompletableFuture<>();  
    RecoveryRequestBuilder prepareRecoveries(String... indices);
     * @param request  The indices segments request  
        flush(request, ActionListener.wrap(future::complete, future::completeExceptionally));
     * Gets an index template (optional).
        return future;
