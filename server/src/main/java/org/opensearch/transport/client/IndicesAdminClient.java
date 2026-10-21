import org.opensearch.action.admin.indices.mapping.get.GetFieldMappingsRequest;
    /**
        CompletableFuture<AcknowledgedResponse> future = new CompletableFuture<>();
import org.opensearch.action.admin.indices.segments.IndicesSegmentsRequest;
     */
    /**
     *
    /**
     * Adds a block to an index
    }
    ActionFuture<AcknowledgedResponse> putMapping(PutMappingRequest request);
     *
     * @see Requests#createIndexRequest(String)
     * Explicitly upgrade one or more indices
        aliases(request, ActionListener.wrap(future::complete, future::completeExceptionally));
import org.opensearch.action.admin.indices.upgrade.post.UpgradeRequestBuilder;
import org.opensearch.action.admin.indices.delete.DeleteIndexRequest;
        CompletableFuture<ValidateQueryResponse> future = new CompletableFuture<>();
    /**
    /** Get aliases - CompletionStage version */
    ActionFuture<RefreshResponse> refresh(RefreshRequest request);
        upgrade(request, ActionListener.wrap(future::complete, future::completeExceptionally));
     * @return The result future
     * @param listener A listener to be notified with a result
     */
    }
 * @opensearch.api
/**
     */
    /**
     * @see Requests#refreshRequest(String...)
        CompletableFuture<UpgradeResponse> future = new CompletableFuture<>();
import org.opensearch.action.admin.indices.close.CloseIndexRequest;
     *
     * @param index The index name to create
    void delete(DeleteIndexRequest request, ActionListener<AcknowledgedResponse> listener);
    ActionFuture<GetDataStreamAction.Response> getDataStreams(GetDataStreamAction.Request request);
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;
        deleteTemplate(request, ActionListener.wrap(future::complete, future::completeExceptionally));
        return future;
    /** Create index - CompletionStage version */
    /** Shard stores - CompletionStage version */
     * Get the mappings of specific fields
     */
     * Executed a per index settings get request and returns the settings for the indices specified.
    /**
    ActionFuture<SegmentReplicationStatsResponse> segmentReplicationStats(SegmentReplicationStatsRequest request);
     * Allows to add/remove aliases from indices.
        close(request, ActionListener.wrap(future::complete, future::completeExceptionally));
    /**
    GetIndexRequestBuilder prepareGetIndex();
        return future;
     * @param listener A listener to be notified with a result
     * Deletes an index based on the index name.
     */
    RecoveryRequestBuilder prepareRecoveries(String... indices);
    DeleteIndexRequestBuilder prepareDelete(String... indices);
    }
import org.opensearch.action.admin.indices.cache.clear.ClearIndicesCacheResponse;
     */
        segmentReplicationStats(request, ActionListener.wrap(future::complete, future::completeExceptionally));
    /**
    /**
    }
    }
    /** Put template - CompletionStage version */
     */
     * Puts an index template.
     *
import org.opensearch.action.admin.indices.upgrade.post.UpgradeResponse;
     * @return The result future
     */
import org.opensearch.action.admin.indices.shards.IndicesShardStoresResponse;
    ActionFuture<AcknowledgedResponse> putTemplate(PutIndexTemplateRequest request);
        addBlock(request, ActionListener.wrap(future::complete, future::completeExceptionally));
     * @param listener A listener to be notified with a result
     * Validate a query for correctness.
    }
import org.opensearch.action.admin.indices.create.CreateIndexRequest;
     * Updates settings of one or more indices.
     * Get the complete mappings of one or more types
        stats(request, ActionListener.wrap(future::complete, future::completeExceptionally));
import org.opensearch.action.admin.indices.flush.FlushResponse;
import org.opensearch.action.admin.indices.mapping.get.GetFieldMappingsResponse;
     * @see Requests#upgradeRequest(String...)
    AnalyzeRequestBuilder prepareAnalyze();
    ActionFuture<OpenIndexResponse> open(OpenIndexRequest request);
        CompletableFuture<AcknowledgedResponse> future = new CompletableFuture<>();
     *
        return future;
 *
    }
import org.opensearch.common.annotation.PublicApi;
 * Modifications Copyright OpenSearch Contributors. See
    /**
    }
    /**
        getAliases(request, ActionListener.wrap(future::complete, future::completeExceptionally));
     * Indices segment replication
    }
    IndicesShardStoreRequestBuilder prepareShardStores(String... indices);
import org.opensearch.action.admin.indices.shrink.ResizeRequest;
     */
        CompletableFuture<GetDataStreamAction.Response> future = new CompletableFuture<>();
    /**
    /**
     *
    default CompletionStage<AcknowledgedResponse> updateSettingsAsync(UpdateSettingsRequest request) {
        CompletableFuture<ResizeResponse> future = new CompletableFuture<>();
        getDataStreams(request, ActionListener.wrap(future::complete, future::completeExceptionally));
    /**
     * Get the mappings of specific fields
    /**
     */
        CompletableFuture<IndicesSegmentResponse> future = new CompletableFuture<>();
import org.opensearch.action.admin.indices.create.CreateIndexResponse;
     *
     * @param request The indices exists request
        CompletableFuture<AcknowledgedResponse> future = new CompletableFuture<>();
import org.opensearch.action.admin.indices.rollover.RolloverRequest;
     * @param indices The name of the indices to close
    default CompletionStage<OpenIndexResponse> openAsync(OpenIndexRequest request) {
    void updateSettings(UpdateSettingsRequest request, ActionListener<AcknowledgedResponse> listener);
        CompletableFuture<IndicesExistsResponse> future = new CompletableFuture<>();
     */
    default CompletionStage<CloseIndexResponse> closeAsync(CloseIndexRequest request) {
        getIngestionState(request, ActionListener.wrap(future::complete, future::completeExceptionally));
        return future;
import org.opensearch.action.admin.indices.template.put.PutIndexTemplateRequestBuilder;
        exists(request, ActionListener.wrap(future::complete, future::completeExceptionally));
    }
     * Gets index template.
    ClearIndicesCacheRequestBuilder prepareClearCache(String... indices);
     *
    /**
    /** Indices stats - CompletionStage version */
    /**
     * Closes one or more indices based on their index name.
    }
     */
    void exists(IndicesExistsRequest request, ActionListener<IndicesExistsResponse> listener);
     * Indices Exists.
    RefreshRequestBuilder prepareRefresh(String... indices);
        return future;
     * The shard stores info of one or more indices.
/*
     * @param block   The block to add
     * @param listener A listener to be notified with a result
     * @see Requests#clearIndicesCacheRequest(String...)
import org.opensearch.action.admin.indices.create.CreateIndexRequestBuilder;
        putMapping(request, ActionListener.wrap(future::complete, future::completeExceptionally));
     */
    }
     *
     */
    ActionFuture<GetMappingsResponse> getMappings(GetMappingsRequest request);
     */
    }
     */
        getSettings(request, ActionListener.wrap(future::complete, future::completeExceptionally));
import org.opensearch.action.admin.indices.streamingingestion.pause.PauseIngestionResponse;
     * @param request The create mapping request
    /**
    void clearCache(ClearIndicesCacheRequest request, ActionListener<ClearIndicesCacheResponse> listener);
    /** Force-merge - CompletionStage version */
        return future;
    CreateIndexRequestBuilder prepareCreate(String index);
    /**
    void forceMerge(ForceMergeRequest request, ActionListener<ForceMergeResponse> listener);
    }
import org.opensearch.action.admin.indices.streamingingestion.resume.ResumeIngestionResponse;
    /** Put mapping - CompletionStage version */
     */
     */
    /** Get ingestion state */
        CompletableFuture<AcknowledgedResponse> future = new CompletableFuture<>();
import org.opensearch.action.admin.indices.streamingingestion.pause.PauseIngestionRequest;
import org.opensearch.action.admin.indices.template.delete.DeleteIndexTemplateRequest;
     */
     */
    }
    }
import org.opensearch.action.admin.indices.open.OpenIndexRequestBuilder;
     */
import org.opensearch.action.admin.indices.readonly.AddIndexBlockResponse;
     * @see Requests#indexAliasesRequest()
     * @param index The index name
    /**
    void shardStores(IndicesShardStoresRequest request, ActionListener<IndicesShardStoresResponse> listener);
    /** Flush - CompletionStage version */
     * @param request The result future
        CompletableFuture<IndicesStatsResponse> future = new CompletableFuture<>();
     */
    void getMappings(GetMappingsRequest request, ActionListener<GetMappingsResponse> listener);
        return future;
     * Swaps the index pointed to by an alias given all provided conditions are satisfied
    void flush(FlushRequest request, ActionListener<FlushResponse> listener);
     * Store a data stream
     *
    void rolloverIndex(RolloverRequest request, ActionListener<RolloverResponse> listener);
    /**
     * Closes an index based on the index name.
import org.opensearch.action.admin.indices.rollover.RolloverResponse;
        return future;
     * Swaps the index pointed to by an alias given all provided conditions are satisfied
        return future;
    /**
import org.opensearch.action.admin.indices.mapping.get.GetMappingsRequestBuilder;
     * Add mapping definition for a type into one or more indices.
     * @param request  The add index block request
 * ownership. Elasticsearch licenses this file to you under
    CloseIndexRequestBuilder prepareClose(String... indices);
     * @return A result future
     * @return A result future
    void segmentReplicationStats(SegmentReplicationStatsRequest request, ActionListener<SegmentReplicationStatsResponse> listener);
    /** Create data stream - CompletionStage version */
    /**
     * Allows to add/remove aliases from indices.
    ActionFuture<IndicesExistsResponse> exists(IndicesExistsRequest request);
     */
    PutMappingRequestBuilder preparePutMapping(String... indices);
    /** Get data streams - CompletionStage version */
     * Swaps the index pointed to by an alias given all provided conditions are satisfied
     */
     */
     * @see #getSettings(GetSettingsRequest)
        return future;
    default CompletionStage<AnalyzeAction.Response> analyzeAsync(AnalyzeAction.Request request) {
    void createDataStream(CreateDataStreamAction.Request request, ActionListener<AcknowledgedResponse> listener);
     * @see Requests#indicesExistsRequest(String...)
     *
     */
import org.opensearch.action.admin.indices.settings.get.GetSettingsRequest;
import org.opensearch.action.admin.indices.upgrade.get.UpgradeStatusRequest;
     * @param request The index aliases request
     * Indices stats.
import org.opensearch.action.admin.indices.shrink.ResizeResponse;
        return future;
     */
     * @param request The result future
import org.opensearch.action.admin.indices.validate.query.ValidateQueryRequestBuilder;
     * Explicitly force merge one or more indices into a the number of segments.
    ActionFuture<ResizeResponse> resizeIndex(ResizeRequest request);
    default CompletionStage<AcknowledgedResponse> deleteDataStreamAsync(DeleteDataStreamAction.Request request) {
     * @see Requests#putMappingRequest(String...)
import org.opensearch.action.admin.indices.flush.FlushRequestBuilder;
import org.opensearch.action.admin.indices.datastream.CreateDataStreamAction;
     * Explicitly upgrade one or more indices
    /**
    /**
import org.opensearch.action.admin.indices.settings.put.UpdateSettingsRequest;
    /**
    /**
        CompletableFuture<IndicesShardStoresResponse> future = new CompletableFuture<>();
import org.opensearch.action.admin.indices.exists.indices.IndicesExistsRequestBuilder;
    }
     * @param listener A listener to be notified with a result
import java.util.concurrent.CompletableFuture;
     */
     */
     *
     * Closes an index based on the index name.
import org.opensearch.action.admin.indices.mapping.get.GetMappingsResponse;
    /**
    /** Get settings - CompletionStage version */
     *
import org.opensearch.action.admin.indices.streamingingestion.state.GetIngestionStateRequest;
     *
    }
import org.opensearch.action.admin.indices.datastream.DeleteDataStreamAction;
    ValidateQueryRequestBuilder prepareValidateQuery(String... indices);
     * Analyze text.
        refresh(request, ActionListener.wrap(future::complete, future::completeExceptionally));
    /**
    }
    /**
     */
     */
        putTemplate(request, ActionListener.wrap(future::complete, future::completeExceptionally));
    /** Analyze - CompletionStage version */
    ActionFuture<GetIndexTemplatesResponse> getTemplates(GetIndexTemplatesRequest request);
     * @param text The text to analyze
        upgradeStatus(request, ActionListener.wrap(future::complete, future::completeExceptionally));
        return future;
     */
     * @param listener A listener to be notified of the result
        CompletableFuture<AcknowledgedResponse> future = new CompletableFuture<>();
     * @param listener A listener to be notified with a result
        validateQuery(request, ActionListener.wrap(future::complete, future::completeExceptionally));
    void deleteTemplate(DeleteIndexTemplateRequest request, ActionListener<AcknowledgedResponse> listener);
     * Get data streams
    void open(OpenIndexRequest request, ActionListener<OpenIndexResponse> listener);
     * @param indices The indices to delete. Use "_all" to delete all indices.
     * @param listener A listener to be notified with a result
     * @param request  The create index request
import org.opensearch.action.admin.indices.settings.put.UpdateSettingsRequestBuilder;
     *
     * @param text  The text to analyze
    default CompletionStage<CreateIndexResponse> createAsync(CreateIndexRequest request) {
 * not use this file except in compliance with the License.
        clearCache(request, ActionListener.wrap(future::complete, future::completeExceptionally));
import org.opensearch.action.admin.indices.datastream.GetDataStreamAction;
     * Add mapping definition for a type into one or more indices.
import org.opensearch.action.admin.indices.stats.IndicesStatsRequestBuilder;
    void getIndex(GetIndexRequest request, ActionListener<GetIndexResponse> listener);
    UpgradeRequestBuilder prepareUpgrade(String... indices);
     * Explicitly force merge one or more indices into a the number of segments.
    ActionFuture<AcknowledgedResponse> deleteTemplate(DeleteIndexTemplateRequest request);
        CompletableFuture<AcknowledgedResponse> future = new CompletableFuture<>();
     *
     * @param request The optimize request
    /**
        return future;
     * @see Requests#closeIndexRequest(String)
    /**
     * @return The request builder configured with the specified scaling direction
    /**
     * @see Requests#deleteIndexRequest(String)
     */
     *
import org.opensearch.action.admin.indices.alias.get.GetAliasesRequestBuilder;
    /**
import org.opensearch.action.admin.indices.stats.IndicesStatsRequest;
     * Explicitly flush one or more indices (releasing memory from the node).
    /**
     *
     */
     */
     */
     * @see Requests#indicesShardStoresRequest(String...)
    /**
     * Resolves names and wildcard expressions to indices, aliases, and data streams
     */
     * Adds a block to an index
     */
    default CompletionStage<GetIndexTemplatesResponse> getTemplatesAsync(GetIndexTemplatesRequest request) {
     * @param request  the update settings request
     * @param request The create index request
 *
    IndicesSegmentsRequestBuilder prepareSegments(String... indices);
     * Check upgrade status of one or more indices
    /** Clear cache - CompletionStage version */
    /**
     */
    }
     * Add mapping definition for a type into one or more indices.
import org.opensearch.action.admin.indices.template.delete.DeleteIndexTemplateRequestBuilder;
    void aliases(IndicesAliasesRequest request, ActionListener<AcknowledgedResponse> listener);
    default CompletionStage<IndicesSegmentResponse> segmentsAsync(IndicesSegmentsRequest request) {
    /**
    default CompletionStage<GetIndexResponse> getIndexAsync(GetIndexRequest request) {
     */
    /** Delete index - CompletionStage version */
    default CompletionStage<GetDataStreamAction.Response> getDataStreamsAsync(GetDataStreamAction.Request request) {
     * @see Requests#closeIndexRequest(String)
import org.opensearch.action.admin.indices.recovery.RecoveryRequestBuilder;
     */
     */
     * Update indices settings.
     * The shard stores info of one or more indices.
        rolloverIndex(request, ActionListener.wrap(future::complete, future::completeExceptionally));
     *
    }
    default CompletionStage<RefreshResponse> refreshAsync(RefreshRequest request) {
     */
     * Clear indices cache.
    FlushRequestBuilder prepareFlush(String... indices);
    /**
     * Validate a query for correctness.
     * @return A result future
    default CompletionStage<SegmentReplicationStatsResponse> segmentReplicationStatsAsync(SegmentReplicationStatsRequest request) {
        return future;
        segments(request, ActionListener.wrap(future::complete, future::completeExceptionally));
    /**
import org.opensearch.action.admin.indices.readonly.AddIndexBlockRequestBuilder;
     * @see Requests#openIndexRequest(String)
 * The OpenSearch Contributors require contributions made to
     * @param request the update settings request
        getFieldMappings(request, ActionListener.wrap(future::complete, future::completeExceptionally));
     */
    /**
     * Puts an index template.
     */
     * @param listener A listener to be notified with a result
     * Analyze text under the provided index.
     * @param listener A listener to be notified with a result
    IndicesAliasesRequestBuilder prepareAliases();
     */
     * @param request  The delete index request
    ActionFuture<GetAliasesResponse> getAliases(GetAliasesRequest request);
    /** Get templates - CompletionStage version */
    /** Resolve index - CompletionStage version */
    void pauseIngestion(PauseIngestionRequest request, ActionListener<PauseIngestionResponse> listener);
     *
     */
    /**
    /**
import org.opensearch.action.admin.indices.settings.get.GetSettingsRequestBuilder;
     */
        return future;
    default CompletionStage<IndicesExistsResponse> existsAsync(IndicesExistsRequest request) {
        flush(request, ActionListener.wrap(future::complete, future::completeExceptionally));
     * @see #getSettings(GetSettingsRequest)
        return future;
        return future;
        return future;
    }
        return future;
        CompletableFuture<CreateIndexResponse> future = new CompletableFuture<>();
    /**
        CompletableFuture<RolloverResponse> future = new CompletableFuture<>();
import org.opensearch.action.admin.indices.upgrade.post.UpgradeRequest;
import org.opensearch.action.admin.indices.streamingingestion.resume.ResumeIngestionRequest;
    SegmentReplicationStatsRequestBuilder prepareSegmentReplicationStats(String... indices);
     * @param listener A listener to be notified with a result
import org.opensearch.action.admin.indices.template.put.PutIndexTemplateRequest;
    /**
     * Resolves names and wildcard expressions to indices, aliases, and data streams
        return future;
     *
@PublicApi(since = "1.0.0")
    /**
        return future;
     * @param request The indices shard stores request
    ActionFuture<RecoveryResponse> recoveries(RecoveryRequest request);
        createDataStream(request, ActionListener.wrap(future::complete, future::completeExceptionally));
 * SPDX-License-Identifier: Apache-2.0
     */
    ForceMergeRequestBuilder prepareForceMerge(String... indices);
     * @return The result future
        updateSettings(request, ActionListener.wrap(future::complete, future::completeExceptionally));
     *
    /**
import org.opensearch.action.admin.indices.stats.IndicesStatsResponse;
    /**
     * Open an index based on the index name.
     * @param request The indices segments request
     * Get specific index aliases that exists in particular indices and / or by name.
    /** Resize index - CompletionStage version */
    ActionFuture<RolloverResponse> rolloverIndex(RolloverRequest request);
     * @see Requests#forceMergeRequest(String...)
     * Explicitly refresh one or more indices (making the content indexed since the last refresh searchable).
import org.opensearch.action.admin.indices.get.GetIndexRequestBuilder;
    }
     *
        resumeIngestion(request, ActionListener.wrap(future::complete, future::completeExceptionally));
     *
    void putTemplate(PutIndexTemplateRequest request, ActionListener<AcknowledgedResponse> listener);
    OpenIndexRequestBuilder prepareOpen(String... indices);
    /** Segments - CompletionStage version */
    void segments(IndicesSegmentsRequest request, ActionListener<IndicesSegmentResponse> listener);
import org.opensearch.action.admin.indices.readonly.AddIndexBlockRequest;
     * @param request The upgrade request
import org.opensearch.action.admin.indices.alias.IndicesAliasesRequestBuilder;
     */
    void getSettings(GetSettingsRequest request, ActionListener<GetSettingsResponse> listener);
     * @param listener A listener to be notified with a result
    default CompletionStage<PauseIngestionResponse> pauseIngestionAsync(PauseIngestionRequest request) {
    /**
     *Indices segment replication
    }
    default CompletionStage<GetFieldMappingsResponse> getFieldMappingsAsync(GetFieldMappingsRequest request) {
     * @param listener A listener to be notified with a result
    ActionFuture<PauseIngestionResponse> pauseIngestion(PauseIngestionRequest request);
     */
        resolveIndex(request, ActionListener.wrap(future::complete, future::completeExceptionally));
     *
    void getIngestionState(GetIngestionStateRequest request, ActionListener<GetIngestionStateResponse> listener);
    UpdateSettingsRequestBuilder prepareUpdateSettings(String... indices);
        CompletableFuture<AnalyzeAction.Response> future = new CompletableFuture<>();
     * Indices stats.
    /** Upgrade - CompletionStage version */
    default CompletionStage<GetIngestionStateResponse> getIngestionStateAsync(GetIngestionStateRequest request) {
    default CompletionStage<RecoveryResponse> recoveriesAsync(RecoveryRequest request) {
     */
     * @see Requests#clearIndicesCacheRequest(String...)
     * Deletes an index based on the index name.
    ActionFuture<ForceMergeResponse> forceMerge(ForceMergeRequest request);
     * @param searchOnly Whether to scale to search-only mode (true) or back to normal mode (false)
     * Store a data stream
    /**
    void recoveries(RecoveryRequest request, ActionListener<RecoveryResponse> listener);
     * Prepares a request to scale an index between normal and search-only modes.
     * level. This request is not exhaustive, it will not return default values for setting.
    ActionFuture<AcknowledgedResponse> aliases(IndicesAliasesRequest request);
     * Returns a builder for a per index settings get request.
    /**
    default CompletionStage<AcknowledgedResponse> deleteAsync(DeleteIndexRequest request) {
import org.opensearch.action.admin.indices.settings.get.GetSettingsResponse;
        CompletableFuture<GetAliasesResponse> future = new CompletableFuture<>();
     *
     *
     */
     *
     * @param listener A listener to be notified with the response
import org.opensearch.action.admin.indices.flush.FlushRequest;
import org.opensearch.action.admin.indices.shrink.ResizeRequestBuilder;
     * @param request  The flush request
     * @param request  The indices segments request
 * license agreements. See the NOTICE file distributed with
     */
        CompletableFuture<GetIndexResponse> future = new CompletableFuture<>();
    ActionFuture<GetIndexResponse> getIndex(GetIndexRequest request);
    default CompletionStage<ResolveIndexAction.Response> resolveIndexAsync(ResolveIndexAction.Request request) {
     *
        CompletableFuture<GetFieldMappingsResponse> future = new CompletableFuture<>();
public interface IndicesAdminClient extends OpenSearchClient {
     */
        return future;
     * Indices stats.
     * @see Requests#forceMergeRequest(String...)
     * @return The result future
    ResizeRequestBuilder prepareResizeIndex(String sourceIndex, String targetIndex);
     * Indices recoveries
     * @see Requests#indexAliasesRequest()
    /**
    }
    ActionFuture<AcknowledgedResponse> deleteDataStream(DeleteDataStreamAction.Request request);
    /**
     */
    void putMapping(PutMappingRequest request, ActionListener<AcknowledgedResponse> listener);
import org.opensearch.action.admin.indices.refresh.RefreshResponse;
     */
    void resizeIndex(ResizeRequest request, ActionListener<ResizeResponse> listener);
    ActionFuture<ResolveIndexAction.Response> resolveIndex(ResolveIndexAction.Request request);
     */
    ActionFuture<GetSettingsResponse> getSettings(GetSettingsRequest request);
    /**
     * Deletes an index based on the index name.
     * Puts an index template.
     * @param request The flush request
     */
        CompletableFuture<GetMappingsResponse> future = new CompletableFuture<>();
     * @param request  The close index request
 */
     */
     * @see Requests#flushRequest(String...)
     */
    /**
    default CompletionStage<AddIndexBlockResponse> addBlockAsync(AddIndexBlockRequest request) {
        return future;
    }
        CompletableFuture<ForceMergeResponse> future = new CompletableFuture<>();
    /**
     */
    /**
    /**
     * Get index metadata for particular indices.
    }
     */
     * @param request The count request
     */
    /** Recoveries - CompletionStage version */
     */
     *
    default CompletionStage<AcknowledgedResponse> putTemplateAsync(PutIndexTemplateRequest request) {
     * The segments of one or more indices.
 *
    /**
    /** Get ingestion state */
    /** Update settings - CompletionStage version */
    /**
    ActionFuture<IndicesSegmentResponse> segments(IndicesSegmentsRequest request);
     * Allows to add/remove aliases from indices.
    /** Segment replication stats - CompletionStage version */
    ActionFuture<IndicesStatsResponse> stats(IndicesStatsRequest request);
    /**
     */
import java.util.concurrent.CompletionStage;
     *
        return future;
        create(request, ActionListener.wrap(future::complete, future::completeExceptionally));
     * @param listener A listener to be notified with a result
import org.opensearch.action.admin.indices.rollover.RolloverRequestBuilder;
    default CompletionStage<GetMappingsResponse> getMappingsAsync(GetMappingsRequest request) {
    /** Pause ingestion */
     */
        return future;
     *
import org.opensearch.action.admin.indices.validate.query.ValidateQueryResponse;
 *
    /**
        CompletableFuture<ResumeIngestionResponse> future = new CompletableFuture<>();
     *
 * this work for additional information regarding copyright
        return future;
    default CompletionStage<IndicesStatsResponse> statsAsync(IndicesStatsRequest request) {
     */
    /**
    /**
    ActionFuture<CloseIndexResponse> close(CloseIndexRequest request);
    void create(CreateIndexRequest request, ActionListener<CreateIndexResponse> listener);
    /**
     */
    ActionFuture<AcknowledgedResponse> updateSettings(UpdateSettingsRequest request);
     * @param indices The name of the indices to close
    /**
     * @param name The name of the template.
     */
        CompletableFuture<CloseIndexResponse> future = new CompletableFuture<>();
    /**
     */
        analyze(request, ActionListener.wrap(future::complete, future::completeExceptionally));
     * Get index metadata for particular indices.
     */
    void upgradeStatus(UpgradeStatusRequest request, ActionListener<UpgradeStatusResponse> listener);
import org.opensearch.core.action.ActionListener;
     * @param request  The create mapping request
 *     http://www.apache.org/licenses/LICENSE-2.0
    /**
     * Deletes an index template.
     * Explicitly refresh one or more indices (making the content indexed since the last refresh searchable).
    /**
     * @param request The close index request
import org.opensearch.action.admin.indices.forcemerge.ForceMergeRequest;
     * Explicitly force merge one or more indices into a the number of segments.
    /** Get field mappings - CompletionStage version */
    void resumeIngestion(ResumeIngestionRequest request, ActionListener<ResumeIngestionResponse> listener);
     */
        deleteDataStream(request, ActionListener.wrap(future::complete, future::completeExceptionally));
import org.opensearch.action.admin.indices.cache.clear.ClearIndicesCacheRequestBuilder;
        CompletableFuture<OpenIndexResponse> future = new CompletableFuture<>();
     * @param request  The index aliases request
    /**
     */
     * Shrinks an index using an explicit request allowing to specify the settings, mappings and aliases of the target index of the index.
     * @see Requests#createIndexRequest(String)
package org.opensearch.transport.client;
    default CompletionStage<AcknowledgedResponse> putMappingAsync(PutMappingRequest request) {
        CompletableFuture<PauseIngestionResponse> future = new CompletableFuture<>();
    default CompletionStage<UpgradeStatusResponse> upgradeStatusAsync(UpgradeStatusRequest request) {
    GetFieldMappingsRequestBuilder prepareGetFieldMappings(String... indices);
     * @see Requests#openIndexRequest(String)
     */
        return future;
/*
     * Resize an index using an explicit request allowing to specify the settings, mappings and aliases of the target index of the index.
        return future;
     */
     * Get specific index aliases that exists in particular indices and / or by name.
    void stats(IndicesStatsRequest request, ActionListener<IndicesStatsResponse> listener);
     */
     * Analyze text/texts.
     * Clear indices cache.
    default CompletionStage<ForceMergeResponse> forceMergeAsync(ForceMergeRequest request) {
import org.opensearch.action.admin.indices.upgrade.get.UpgradeStatusResponse;
     * Resize an index using an explicit request allowing to specify the settings, mappings and aliases of the target index of the index.
    }
    AnalyzeRequestBuilder prepareAnalyze(@Nullable String index, String text);
        CompletableFuture<AcknowledgedResponse> future = new CompletableFuture<>();
import org.opensearch.action.admin.indices.mapping.get.GetFieldMappingsRequestBuilder;
    }
 * compatible open source license.
     */
import org.opensearch.action.admin.indices.exists.indices.IndicesExistsRequest;
     */
    /** Validate query - CompletionStage version */
import org.opensearch.action.admin.indices.template.get.GetIndexTemplatesResponse;
    IndicesStatsRequestBuilder prepareStats(String... indices);
    UpgradeStatusRequestBuilder prepareUpgradeStatus(String... indices);
     * @param request  The close index request
     * @see Requests#indicesSegmentsRequest(String...)
        return future;
    /**
        recoveries(request, ActionListener.wrap(future::complete, future::completeExceptionally));
     */
    ActionFuture<IndicesShardStoresResponse> shardStores(IndicesShardStoresRequest request);
     */
     *
     * @see Requests#indicesExistsRequest(String...)
        return future;
     */
    /**
     * Indices exists.
     * @param listener A listener to be notified with a result
import org.opensearch.action.admin.indices.segments.IndicesSegmentsRequestBuilder;
import org.opensearch.action.admin.indices.recovery.RecoveryRequest;
     */
 * Administrative actions/operations against indices.
    /**
     */
     * Explicitly flush one or more indices (releasing memory from the node).
    /** Delete template - CompletionStage version */
     * Gets an index template (optional).
        return future;
import org.opensearch.action.admin.indices.get.GetIndexRequest;
    /**
    /**
     * The shard stores info of one or more indices.
    /**
    ActionFuture<AcknowledgedResponse> delete(DeleteIndexRequest request);
import org.opensearch.action.admin.indices.segments.IndicesSegmentResponse;
        shardStores(request, ActionListener.wrap(future::complete, future::completeExceptionally));
     *
    /** Get mappings - CompletionStage version */
    AnalyzeRequestBuilder prepareAnalyze(String text);
        return future;
    ActionFuture<ValidateQueryResponse> validateQuery(ValidateQueryRequest request);
    /**
    /**
     */
     * @param request The upgrade request
        pauseIngestion(request, ActionListener.wrap(future::complete, future::completeExceptionally));
     *
 * You may obtain a copy of the License at
     */
    default CompletionStage<RolloverResponse> rolloverIndexAsync(RolloverRequest request) {
     *
 * Unless required by applicable law or agreed to in writing,
     * Clear indices cache.
import org.opensearch.action.admin.indices.alias.get.GetAliasesResponse;
     * Check upgrade status of one or more indices
    }
import org.opensearch.action.admin.indices.analyze.AnalyzeRequestBuilder;
     * @param request The clear indices cache request
    /**
    default CompletionStage<AcknowledgedResponse> deleteTemplateAsync(DeleteIndexTemplateRequest request) {
    ActionFuture<ResumeIngestionResponse> resumeIngestion(ResumeIngestionRequest request);
import org.opensearch.action.admin.indices.open.OpenIndexRequest;
     * Open an index based on the index name.
import org.opensearch.action.admin.indices.delete.DeleteIndexRequestBuilder;
    /**
import org.opensearch.action.admin.indices.refresh.RefreshRequest;
     * The segments of one or more indices.
    ActionFuture<GetFieldMappingsResponse> getFieldMappings(GetFieldMappingsRequest request);
     */
import org.opensearch.action.admin.indices.replication.SegmentReplicationStatsRequest;
     * @see Requests#flushRequest(String...)
     * @return The result future
 * @see AdminClient#indices()
import org.opensearch.common.action.ActionFuture;
        CompletableFuture<SegmentReplicationStatsResponse> future = new CompletableFuture<>();
        getTemplates(request, ActionListener.wrap(future::complete, future::completeExceptionally));
    void close(CloseIndexRequest request, ActionListener<CloseIndexResponse> listener);
    ActionFuture<FlushResponse> flush(FlushRequest request);
    }
     *
        CompletableFuture<ClearIndicesCacheResponse> future = new CompletableFuture<>();
     * Gets an index template.
     *Indices recoveries
     * @return A result future
    }
    /**
 * software distributed under the License is distributed on an
    default CompletionStage<GetAliasesResponse> getAliasesAsync(GetAliasesRequest request) {
    /**
    /** Aliases - CompletionStage version */
    GetIndexTemplatesRequestBuilder prepareGetTemplates(String... name);
import org.opensearch.action.admin.indices.alias.IndicesAliasesRequest;
        CompletableFuture<AddIndexBlockResponse> future = new CompletableFuture<>();
    /** Rollover index - CompletionStage version */
     * Get data streams
     * @return The result future
    void refresh(RefreshRequest request, ActionListener<RefreshResponse> listener);
    default CompletionStage<FlushResponse> flushAsync(FlushRequest request) {
    /**
 * under the License.
    ActionFuture<GetIngestionStateResponse> getIngestionState(GetIngestionStateRequest request);
     * @param index      The name of the index to scale
 * GitHub history for details.
    void validateQuery(ValidateQueryRequest request, ActionListener<ValidateQueryResponse> listener);
     * @param request  The indices status request
    /**
     * @see Requests#openIndexRequest(String)
    default CompletionStage<UpgradeResponse> upgradeAsync(UpgradeRequest request) {
    /** Resume ingestion */
     * @see Requests#deleteIndexRequest(String)
    ScaleIndexRequestBuilder prepareScaleSearchOnly(String index, boolean searchOnly);
    /**
     * @param request  The upgrade request
import org.opensearch.action.admin.indices.template.get.GetIndexTemplatesRequestBuilder;
     * @see Requests#upgradeRequest(String...)
     * @param request  The index aliases request
     * Get the complete mappings of one or more types
     *
    /** Resume ingestion */
     */
    /** Delete data stream - CompletionStage version */
    default CompletionStage<GetSettingsResponse> getSettingsAsync(GetSettingsRequest request) {
 * specific language governing permissions and limitations
     * @param request  The upgrade request
     *
    /**
    default CompletionStage<ValidateQueryResponse> validateQueryAsync(ValidateQueryRequest request) {
    }
     */
     * Updates settings of one or more indices.
     */
     * Analyze text under the provided index.
    /** Open index - CompletionStage version */
        return future;
     * Explicitly refresh one or more indices (making the content indexed since the last refresh searchable).
     * Explicitly flush one or more indices (releasing memory from the node).
import org.opensearch.action.admin.indices.mapping.put.PutMappingRequestBuilder;
     */
     */
    /**
    GetAliasesRequestBuilder prepareGetAliases(String... aliases);
     * @param listener A listener to be notified with a result
     * @return The result future
    }
    }
 *
     * Delete a data stream
 * Licensed to Elasticsearch under one or more contributor
     * @param listener A listener to be notified with a result
    /**
    /**
import org.opensearch.action.admin.indices.forcemerge.ForceMergeResponse;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    AddIndexBlockRequestBuilder prepareAddBlock(APIBlock block, String... indices);
     *  Explicitly upgrade one or more indices
    /** Close index - CompletionStage version */
     * @param request  The force merge request
     * @return The result future
        CompletableFuture<AcknowledgedResponse> future = new CompletableFuture<>();
    ActionFuture<UpgradeResponse> upgrade(UpgradeRequest request);
    RolloverRequestBuilder prepareRolloverIndex(String sourceAlias);
    /**
     * @see Requests#upgradeRequest(String...)
    /**
    DeleteIndexTemplateRequestBuilder prepareDeleteTemplate(String name);
        return future;
    /**
        CompletableFuture<GetIndexTemplatesResponse> future = new CompletableFuture<>();
     * The segments of one or more indices.
     */
import org.opensearch.action.admin.indices.mapping.get.GetMappingsRequest;
import org.opensearch.action.admin.indices.alias.get.GetAliasesRequest;
     *
     * @see Requests#refreshRequest(String...)
    GetMappingsRequestBuilder prepareGetMappings(String... indices);
import org.opensearch.action.admin.indices.get.GetIndexResponse;
     * Deletes index template.
     * Validate a query for correctness.
     * @see Requests#upgradeRequest(String...)
        getMappings(request, ActionListener.wrap(future::complete, future::completeExceptionally));
     * @see Requests#indicesSegmentsRequest(String...)
    IndicesExistsRequestBuilder prepareExists(String... indices);
    default CompletionStage<AcknowledgedResponse> aliasesAsync(IndicesAliasesRequest request) {
     *
    void getFieldMappings(GetFieldMappingsRequest request, ActionListener<GetFieldMappingsResponse> listener);
        return future;
    }
    /**
     * @param request  The clear indices cache request
     */
     */
    /**
     *
     * @param request The close index request
import org.opensearch.action.admin.indices.replication.SegmentReplicationStatsResponse;
    default CompletionStage<ResizeResponse> resizeIndexAsync(ResizeRequest request) {
    default CompletionStage<ResumeIngestionResponse> resumeIngestionAsync(ResumeIngestionRequest request) {
     * @param request  The refresh request
        CompletableFuture<FlushResponse> future = new CompletableFuture<>();
import org.opensearch.action.admin.indices.cache.clear.ClearIndicesCacheRequest;
     * @param request The indices shard stores request
     * Get the complete mappings of one or more types
     *
import org.opensearch.action.admin.indices.template.get.GetIndexTemplatesRequest;
     * @param request The refresh request
    /**
    void addBlock(AddIndexBlockRequest request, ActionListener<AddIndexBlockResponse> listener);
        return future;
}
    /**
     * Get index metadata for particular indices.
    void getTemplates(GetIndexTemplatesRequest request, ActionListener<GetIndexTemplatesResponse> listener);
     *
 * this file be licensed under the Apache-2.0 license or a
        CompletableFuture<GetSettingsResponse> future = new CompletableFuture<>();
    default CompletionStage<AcknowledgedResponse> createDataStreamAsync(CreateDataStreamAction.Request request) {
    /** Add index block - CompletionStage version */
    void deleteDataStream(DeleteDataStreamAction.Request request, ActionListener<AcknowledgedResponse> listener);
import org.opensearch.action.admin.indices.replication.SegmentReplicationStatsRequestBuilder;
        return future;
        CompletableFuture<RecoveryResponse> future = new CompletableFuture<>();
     * @return The result future
import org.opensearch.common.Nullable;
import org.opensearch.action.admin.indices.exists.indices.IndicesExistsResponse;
    default CompletionStage<ClearIndicesCacheResponse> clearCacheAsync(ClearIndicesCacheRequest request) {
    }
     */
     */
        CompletableFuture<GetIngestionStateResponse> future = new CompletableFuture<>();
        CompletableFuture<RefreshResponse> future = new CompletableFuture<>();
     * Executed a per index settings get request.
    /**
     * The status of one or more indices.
     * @param listener A listener to be notified with a result
import org.opensearch.action.admin.indices.shards.IndicesShardStoresRequest;
     */
import org.opensearch.action.admin.indices.recovery.RecoveryResponse;
     * @return The result future
     * @param name The name of the template.
import org.opensearch.action.admin.indices.validate.query.ValidateQueryRequest;
    ActionFuture<CreateIndexResponse> create(CreateIndexRequest request);
     */
     */
     *
        resizeIndex(request, ActionListener.wrap(future::complete, future::completeExceptionally));
     * @param listener A listener to be notified with a result
import org.opensearch.action.admin.indices.close.CloseIndexRequestBuilder;
 * the Apache License, Version 2.0 (the "License"); you may
     */
    }
     */
        forceMerge(request, ActionListener.wrap(future::complete, future::completeExceptionally));
     * Get specific index aliases that exists in particular indices and / or by name.
    /**
        delete(request, ActionListener.wrap(future::complete, future::completeExceptionally));
    /**
     * @param request  The count request
     * Delete a data stream
        return future;
     *Indices segment replication
import org.opensearch.action.admin.indices.shards.IndicesShardStoreRequestBuilder;
     * Creates an index using an explicit request allowing to specify the settings of the index.
     * @see Requests#putMappingRequest(String...)
     * Check upgrade status of one or more indices
        getIndex(request, ActionListener.wrap(future::complete, future::completeExceptionally));
     * @return The result future
     * @return The result future
    void getAliases(GetAliasesRequest request, ActionListener<GetAliasesResponse> listener);
    /**
import org.opensearch.action.admin.indices.analyze.AnalyzeAction;
     *
    /**
     * Opens one or more indices based on their index name.
import org.opensearch.action.admin.indices.streamingingestion.state.GetIngestionStateResponse;
    /**
 */
     * Note: this is a per index request and will not include settings that are set on the cluster
     * Analyze text under the provided index.
    /** Upgrade status - CompletionStage version */
     *
        CompletableFuture<UpgradeStatusResponse> future = new CompletableFuture<>();
    PutIndexTemplateRequestBuilder preparePutTemplate(String name);
     * @param request The delete index request
    /**
     * Indices recoveries
    void getDataStreams(GetDataStreamAction.Request request, ActionListener<GetDataStreamAction.Response> listener);
import org.opensearch.action.admin.indices.resolve.ResolveIndexAction;
import org.opensearch.action.admin.indices.upgrade.get.UpgradeStatusRequestBuilder;
     */
    ActionFuture<AnalyzeAction.Response> analyze(AnalyzeAction.Request request);
    ActionFuture<UpgradeStatusResponse> upgradeStatus(UpgradeStatusRequest request);
    /**
     * Creates an index using an explicit request allowing to specify the settings of the index.
import org.opensearch.cluster.metadata.IndexMetadata.APIBlock;
     * Get the mappings of specific fields
 */
     * @see Requests#indicesShardStoresRequest(String...)
    void upgrade(UpgradeRequest request, ActionListener<UpgradeResponse> listener);
    GetSettingsRequestBuilder prepareGetSettings(String... indices);
/*
     * @param request  The index aliases request
     */
    ActionFuture<ClearIndicesCacheResponse> clearCache(ClearIndicesCacheRequest request);
    /**
 */
        return future;
    /** Get ingestion state - CompletionStage version */
    /** Get index - CompletionStage version */
    /** Pause ingestion - CompletionStage version */
    void resolveIndex(ResolveIndexAction.Request request, ActionListener<ResolveIndexAction.Response> listener);
     * @param indices the indices to fetch the setting for.
    /** Refresh - CompletionStage version */
    /** Pause ingestion */
        CompletableFuture<ResolveIndexAction.Response> future = new CompletableFuture<>();
    ActionFuture<AcknowledgedResponse> createDataStream(CreateDataStreamAction.Request request);
     */
     * @return A result future
    /** Resume ingestion - CompletionStage version */
     *
import org.opensearch.action.admin.indices.open.OpenIndexResponse;
     * @param indices The name of the indices to add the block to
    /** Indices Exists - CompletionStage version */
 * KIND, either express or implied.  See the License for the
    /**
import org.opensearch.action.admin.indices.refresh.RefreshRequestBuilder;
     * Deletes an index template.
import org.opensearch.action.admin.indices.scale.searchonly.ScaleIndexRequestBuilder;
        open(request, ActionListener.wrap(future::complete, future::completeExceptionally));
import org.opensearch.action.admin.indices.close.CloseIndexResponse;
     */
     * Creates an index using an explicit request allowing to specify the settings of the index.
    }
    void analyze(AnalyzeAction.Request request, ActionListener<AnalyzeAction.Response> listener);
import org.opensearch.action.admin.indices.forcemerge.ForceMergeRequestBuilder;
     *
import org.opensearch.action.admin.indices.mapping.put.PutMappingRequest;
    default CompletionStage<IndicesShardStoresResponse> shardStoresAsync(IndicesShardStoresRequest request) {
