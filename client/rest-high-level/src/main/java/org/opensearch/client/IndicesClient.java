     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
        return restHighLevelClient.performRequestAsyncAndParseEntity(
     *
            request,
            putIndexTemplateRequest,
            getAliasesRequest,
    ) {
    }
    /**
    }
     * @throws IOException in case there is a problem sending the request or parsing back the response
    /**
            createDataStreamRequest,
            options,
     */
            simulateIndexTemplateRequest,
            options,
    /**
            IndicesRequestConverters::validateQuery,
     * @param listener the listener to be notified upon request completion
    /**
        GetAliasesRequest getAliasesRequest,
        return restHighLevelClient.performRequestAsyncAndParseEntity(
    public RolloverResponse rollover(RolloverRequest rolloverRequest, RequestOptions options) throws IOException {
import org.opensearch.client.indices.GetIndexTemplatesResponse;
     * Clears the cache of one or more indices using the Clear Cache API.
     * @param listener the listener to be notified upon request completion
            emptySet()
    ) {
    @Deprecated
            getIndexTemplatesRequest,
     * @return the response
        return restHighLevelClient.performRequestAndParseEntity(
     * Deletes an index using the Delete Index API.
    /**
import org.opensearch.client.indices.CreateDataStreamRequest;
     */
     * @param getMappingsRequest the request
     * @deprecated use {@link #shrink(ResizeRequest, RequestOptions)}
            options,
            options,
        return restHighLevelClient.performRequestAndParseEntity(
     *                                     customized
     */
            options,
            listener,
            options,
     */
            listener,
            RestHighLevelClient::convertExistsResponse,
        return restHighLevelClient.performRequestAndParseEntity(
            listener,
    /**
     */
            options,
        );
            options,
            options,
 * Licensed to Elasticsearch under one or more contributor
     * @param listener the listener to be notified upon request completion
    }
     * @param listener the listener to be notified upon request completion
    /**
            IndicesRequestConverters::getIndexTemplates,
            RolloverResponse::fromXContent,
import org.opensearch.core.action.ActionListener;
            emptySet()
     *
            dataStreamsStatsRequest,
            options,
     * Asynchronously shrinks an index using the Shrink index API.
     *
     * @param deleteIndexRequest the request
     * @param options  the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
    public Cancellable createAsync(
            emptySet()
        return restHighLevelClient.performRequestAsyncAndParseEntity(
        DeleteDataStreamRequest deleteDataStreamRequest,
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
     * Shrinks an index using the Shrink Index API.
     * @param listener                the listener to be notified upon request completion
    }
        return restHighLevelClient.performRequestAndParseEntity(
        ActionListener<GetMappingsResponse> listener
     * @deprecated use {@link #cloneAsync(ResizeRequest, RequestOptions, ActionListener)}
    }
            options,
            IndicesRequestConverters::deleteTemplate,
    ) {
            resizeRequest,
     *
        RequestOptions options,
     * @param resizeRequest the request
            indexTemplatesExistRequest,
    /**
import org.opensearch.action.admin.indices.template.delete.DeleteIndexTemplateRequest;
     * @param getFieldMappingsRequest the request
     * Asynchronously checks if one or more aliases exist using the Aliases Exist API.
     * Updates aliases using the Index Aliases API.
    /**
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
        RequestOptions options,
     * @param dataStreamsStatsRequest the request
     *
            emptySet()
    }
        ActionListener<SimulateIndexTemplateResponse> listener
    ) {
        this.restHighLevelClient = restHighLevelClient;
     *
     */
     * @param request the request
        return restHighLevelClient.performRequestAsyncAndParseEntity(
     * @return the response
import org.opensearch.client.indices.GetMappingsResponse;
    /**
     * @param getAliasesRequest the request
    /**
     * @param resizeRequest the request
     * @param listener the listener to be notified upon request completion
            emptySet()
        );
     * @param getAliasesRequest the request
     * Retrieve information about one or more indexes
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
    /**
    }
            IndicesRequestConverters::putMapping,
 * not use this file except in compliance with the License.
        return restHighLevelClient.performRequestAndParseEntity(
        );
     *
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
     * @param createDataStreamRequest the request
    }
        );
     * Asynchronously updates aliases using the Index Aliases API.
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
     * @return the response
        return restHighLevelClient.performRequestAndParseEntity(
     *
    public AcknowledgedResponse delete(DeleteIndexRequest deleteIndexRequest, RequestOptions options) throws IOException {
    /**
     * @param indicesAliasesRequest the request
            closeIndexRequest,
    /**
     * @return the response
import org.opensearch.client.indices.PutIndexTemplateRequest;
            putIndexTemplateRequest,
     */
     */
import org.opensearch.action.admin.indices.validate.query.ValidateQueryRequest;
            AcknowledgedResponse::fromXContent,
import org.opensearch.core.rest.RestStatus;
            emptySet()
        RequestOptions options,
        );
            options,
     * @param options                 the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be
            options,
            IndicesRequestConverters::refresh,
 * specific language governing permissions and limitations
            getAliasesRequest,
            resizeRequest,
     * @param getIndexTemplatesRequest the request
     * @return cancellable that may be used to cancel the request
     * @param deleteDataStreamRequest the request
            listener,
    }
import org.opensearch.action.admin.indices.alias.get.GetAliasesRequest;
        IndexTemplatesExistRequest indexTemplatesExistRequest,
     *
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
    ) {
     * @param listener the listener to be notified upon request completion
     * @param listener the listener to be notified upon request completion
    /**
    }
        RequestOptions options,
     *
     *
        RequestOptions options,
    }
        ActionListener<ForceMergeResponse> listener
            listener,
        );
            listener,
     * @return the response
     * @param listener the listener to be notified upon request completion
            IndicesRequestConverters::closeIndex,
        );
     * @return cancellable that may be used to cancel the request
            AcknowledgedResponse::fromXContent,
     * @return cancellable that may be used to cancel the request
        throws IOException {
     *
            RestHighLevelClient::convertExistsResponse,
    }
            options,
    /**
            listener,
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
     * @param listener the listener to be notified upon request completion
     */
            listener,
            options,
     * Creates a data stream using the Create Data Stream API.
     * @param listener the listener to be notified upon request completion
    ) {
     *
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
        return restHighLevelClient.performRequestAsyncAndParseEntity(
     * Updates specific index level settings using the Update Indices Settings API.
            emptySet()
    /**
        return restHighLevelClient.performRequestAndParseEntity(
     *
        RequestOptions options,
            options,
    /**
     *
     * @param simulateIndexTemplateRequest the request
     */
        RequestOptions options,
     *
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
     * @param options           the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.action.admin.indices.validate.query.ValidateQueryResponse;
     */
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
        DeleteIndexRequest deleteIndexRequest,
            options,
     *
            emptySet()
     *
    /**
    }
     *
            emptySet()
     * @param listener the listener to be notified upon request completion
     * @throws IOException in case there is a problem sending the request or parsing back the response
        return restHighLevelClient.performRequestAndParseEntity(
            emptySet()
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
            org.opensearch.action.admin.indices.shrink.ResizeResponse::fromXContent,
    public GetSettingsResponse getSettings(GetSettingsRequest getSettingsRequest, RequestOptions options) throws IOException {
     * Asynchronously deletes an index using the Delete Index API.
            RestHighLevelClient::convertExistsResponse,
     *                                     customized
        );
     * @param openIndexRequest the request
            IndicesRequestConverters::getIndexTemplates,
     *
            updateSettingsRequest,
     */
     */
            emptySet()
     * @throws IOException in case there is a problem sending the request or parsing back the response
    }
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
            clearIndicesCacheRequest,
 *
            options,
            org.opensearch.client.core.AcknowledgedResponse::fromXContent,
        return restHighLevelClient.performRequestAsyncAndParseEntity(
            IndicesRequestConverters::split,
     * @return cancellable that may be used to cancel the request
        GetMappingsRequest getMappingsRequest,
        );
 * license agreements. See the NOTICE file distributed with
            options,
            options,
    /**
     * @param listener the listener to be notified upon request completion. The listener will be called with the value {@code true}
     * @return the response
        );
     * Delete an index template using the Index Templates API
import org.opensearch.client.indices.GetDataStreamRequest;
     *                                customized
import java.io.IOException;
    /**
    public AcknowledgedResponse putIndexTemplate(PutComposableIndexTemplateRequest putIndexTemplateRequest, RequestOptions options)
        );
import org.opensearch.client.indices.rollover.RolloverResponse;
import org.opensearch.action.admin.indices.refresh.RefreshResponse;
        );
    public Cancellable closeAsync(
     *
    public GetFieldMappingsResponse getFieldMapping(GetFieldMappingsRequest getFieldMappingsRequest, RequestOptions options)
     *
    /**
            listener,
    ) {
 * The OpenSearch Contributors require contributions made to
            deleteIndexRequest,
            updateSettingsRequest,
    public Cancellable getDataStreamAsync(
            request,
            indicesAliasesRequest,
            IndicesRequestConverters::forceMerge,
    }
            putIndexTemplateRequest,
            emptySet()
        return restHighLevelClient.performRequestAsync(
     * @return cancellable that may be used to cancel the request
    /**
            listener,
     * Clones an index using the Clone Index API.
            IndicesRequestConverters::clone,
     */
import org.opensearch.action.admin.indices.settings.put.UpdateSettingsRequest;
     * Asynchronously calls the delete alias api
            getIndexTemplatesRequest,
     *
     * Asynchronously closes an index using the Close Index API.
        ForceMergeRequest forceMergeRequest,
     *
     * Splits an index using the Split Index API.
            FlushResponse::fromXContent,
    /**
        return restHighLevelClient.performRequestAsyncAndParseEntity(
     * Asynchronously gets one or more data streams using the Get Data Stream API.
     * @return cancellable that may be used to cancel the request
            getSettingsRequest,
        return restHighLevelClient.performRequestAndParseEntity(
     *
    public Cancellable getIndexTemplateAsync(
    }
     * @throws IOException in case there is a problem sending the request or parsing back the response
            listener,
        RequestOptions options,
            GetFieldMappingsResponse::fromXContent,
            AcknowledgedResponse::fromXContent,
    /**
    public Cancellable getIndexTemplateAsync(
        ActionListener<org.opensearch.action.admin.indices.shrink.ResizeResponse> listener
            listener,
    /**
     *
     * @param listener          the listener to be notified upon request completion
    public ForceMergeResponse forcemerge(ForceMergeRequest forceMergeRequest, RequestOptions options) throws IOException {
    @Deprecated
        ActionListener<Boolean> listener
     * Closes an index using the Close Index API.
     *
 * SPDX-License-Identifier: Apache-2.0
            IndicesRequestConverters::getAlias,
        );
     * @return the response
import org.opensearch.client.indices.AnalyzeResponse;
     * @param validateQueryRequest the request
    public AcknowledgedResponse updateAliases(IndicesAliasesRequest indicesAliasesRequest, RequestOptions options) throws IOException {
            options,
     *
import org.opensearch.client.indices.AnalyzeRequest;
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
            AnalyzeResponse::fromXContent,
    ) throws IOException {
            listener,
            emptySet()
    }
     *
            validateQueryRequest,
     * @param dataStreamsStatsRequest the request
    public RefreshResponse refresh(RefreshRequest refreshRequest, RequestOptions options) throws IOException {
        return restHighLevelClient.performRequestAsyncAndParseEntity(
     * @return the response
     * @return cancellable that may be used to cancel the request
    /**
     * @param getFieldMappingsRequest the request
    public Cancellable putIndexTemplateAsync(
     * Asynchronously gets one or more aliases using the Get Index Aliases API.
        UpdateSettingsRequest updateSettingsRequest,
    }
    }
        );
     * @throws IOException in case there is a problem sending the request or parsing back the response
     * @deprecated use {@link #split(ResizeRequest, RequestOptions)}
     * @return the response
            emptySet()
     * @throws IOException in case there is a problem sending the request
        return restHighLevelClient.performRequestAsyncAndParseEntity(
    /**
        RequestOptions options
    ) throws IOException {
     */
        );
        ActionListener<GetAliasesResponse> listener
import org.opensearch.action.admin.indices.refresh.RefreshRequest;
        return restHighLevelClient.performRequestAsync(
     *
     */
    }
            ValidateQueryResponse::fromXContent,
            emptySet()
     * Puts an index template using the Index Templates API.
     */
            emptySet()
        );
            openIndexRequest,
     *
    }
            ResizeResponse::fromXContent,
        return restHighLevelClient.performRequestAndParseEntity(
    }
        );
        return restHighLevelClient.performRequestAsyncAndParseEntity(
     * @return cancellable that may be used to cancel the request
            options,
            options,
            resizeRequest,
     * @param request  the request
            IndicesRequestConverters::validateQuery,
    ) {
     * @return cancellable that may be used to cancel the request
            IndicesRequestConverters::closeIndex,
        return restHighLevelClient.performRequestAndParseEntity(
     * @return cancellable that may be used to cancel the request
     * @param forceMergeRequest the request
            emptySet()
            IndicesRequestConverters::clearCache,
     *
     *
    /**
     * @throws IOException in case there is a problem sending the request or parsing back the response
     * @return true if any index templates in the request exist, false otherwise
     * @return true if any index templates in the request exist, false otherwise
     * @param putMappingRequest the request
        );
     *                                customized
            emptySet()
        return restHighLevelClient.performRequestAsyncAndParseEntity(
    }
            CreateIndexResponse::fromXContent,
        );
            GetSettingsResponse::fromXContent,
            options,
        CreateDataStreamRequest createDataStreamRequest,
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
            IndicesRequestConverters::createIndex,
     * @return cancellable that may be used to cancel the request
        ActionListener<AcknowledgedResponse> listener
    /**
     *
            IndicesRequestConverters::getAlias,
     * @return the response
     * @return cancellable that may be used to cancel the request
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
            IndicesRequestConverters::templatesExist,
    public Cancellable cloneAsync(ResizeRequest resizeRequest, RequestOptions options, ActionListener<ResizeResponse> listener) {
    }
    public Cancellable getMappingAsync(
     */
     * @throws IOException in case there is a problem sending the request or parsing back the response
    }
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
            GetIndexTemplatesResponse::fromXContent,
     *
            IndicesRequestConverters::shrink,
    ) {
            listener,
            GetDataStreamResponse::fromXContent,
     * Asynchronously splits an index using the Split Index API.
    public Cancellable getAsync(GetIndexRequest getIndexRequest, RequestOptions options, ActionListener<GetIndexResponse> listener) {
    }
    ) {
     *                                customized
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
import static java.util.Collections.emptySet;
            emptySet()
    public boolean existsTemplate(IndexTemplatesExistRequest indexTemplatesRequest, RequestOptions options) throws IOException {
        ActionListener<AcknowledgedResponse> listener
            IndicesRequestConverters::existsAlias,
     * @param resizeRequest the request
            org.opensearch.action.admin.indices.shrink.ResizeResponse::fromXContent,
     */
            emptySet()
            flushRequest,
    ) {
            options,
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
            options,
     * Asynchronously gets index templates using the Index Templates API
     * @param request the request
            IndicesRequestConverters::deleteDataStream,
     */
     * Asynchronously splits an index using the Split Index API.
            request,
     * @param resizeRequest the request
    public Cancellable getFieldMappingAsync(
    ) throws IOException {
            GetDataStreamResponse::fromXContent,
    public ClearIndicesCacheResponse clearCache(ClearIndicesCacheRequest clearIndicesCacheRequest, RequestOptions options)
            IndicesRequestConverters::deleteIndexTemplate,
import org.opensearch.client.indices.PutComposableIndexTemplateRequest;
        throws IOException {
            options,
            singleton(RestStatus.NOT_FOUND.getStatus())
     *
            emptySet()
            forceMergeRequest,
        );
            emptySet()
        );
     * @param listener the listener to be notified upon request completion. The listener will be called with the value {@code true}
 *    http://www.apache.org/licenses/LICENSE-2.0
     * @return cancellable that may be used to cancel the request
        RequestOptions options,
     * @return cancellable that may be used to cancel the request
        RequestOptions options,
            indexTemplatesRequest,
    /**
        return restHighLevelClient.performRequestAsyncAndParseEntity(
    /**
            org.opensearch.action.admin.indices.shrink.ResizeResponse::fromXContent,
     * @param createIndexRequest the request
            options,
    }
    }
     */
    public Cancellable deleteTemplateAsync(
     */
            options,
import org.opensearch.action.admin.indices.open.OpenIndexRequest;
     * @param options                 the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be
     *                                customized
            options,
     * @return the response
            options,
import org.opensearch.client.indices.DataStreamsStatsResponse;
     * Checks if one or more aliases exist using the Aliases Exist API.
     */
     */
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
            getSettingsRequest,
    public AcknowledgedResponse deleteTemplate(DeleteIndexTemplateRequest request, RequestOptions options) throws IOException {
            OpenIndexResponse::fromXContent,
    }
     * @param getIndexTemplatesRequest the request
     * @return the response
 * compatible open source license.
        );
        return restHighLevelClient.performRequestAndParseEntity(
            emptySet()
     * @param dataStreamRequest the request
            GetIndexResponse::fromXContent,
            IndicesRequestConverters::clone,
     * Flush one or more indices using the Flush API.
    public GetIndexTemplatesResponse getIndexTemplate(GetIndexTemplatesRequest getIndexTemplatesRequest, RequestOptions options)
        );
            emptySet()
            emptySet()
     */
            listener,
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
            getFieldMappingsRequest,
            IndicesRequestConverters::openIndex,
    /**
        return restHighLevelClient.performRequestAndParseEntity(
        ComposableIndexTemplateExistRequest indexTemplatesExistRequest,
     * @throws IOException in case there is a problem sending the request or parsing back the response
    }
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
        );
import org.opensearch.client.indices.SimulateIndexTemplateRequest;
    }
     *
     * @param indexTemplatesExistRequest the request
import org.opensearch.client.indices.DeleteAliasRequest;
            AcknowledgedResponse::fromXContent,
            resizeRequest,
     * @param flushRequest the request
     * @param getIndexTemplatesRequest the request
     * Synchronously calls the delete alias api
            GetAliasesResponse::fromXContent,
            options,
import org.opensearch.action.admin.indices.forcemerge.ForceMergeRequest;
import org.opensearch.client.indices.ComposableIndexTemplateExistRequest;
     * @param refreshRequest the request
/*
     * @return the response
            RolloverResponse::fromXContent,
        return restHighLevelClient.performRequestAsyncAndParseEntity(
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
     * @param resizeRequest the request
            IndicesRequestConverters::indexPutSettings,
     * @return cancellable that may be used to cancel the request
        GetFieldMappingsRequest getFieldMappingsRequest,
    }
     */
     * Uses the Index Templates API to determine if index templates exist
            options,
    /**
    ) throws IOException {
        );
            emptySet()
            options,
     * @return the response
    public org.opensearch.action.admin.indices.shrink.ResizeResponse clone(
    ) {
 * software distributed under the License is distributed on an
        );
            Collections.emptySet()
        return restHighLevelClient.performRequestAndParseEntity(
     *
     */
    public AcknowledgedResponse putSettings(UpdateSettingsRequest updateSettingsRequest, RequestOptions options) throws IOException {
            emptySet()
            emptySet()
    }
        RequestOptions options,
            emptySet()
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
     * @param request the request
    public Cancellable existsAsync(GetIndexRequest request, RequestOptions options, ActionListener<Boolean> listener) {
    public AcknowledgedResponse deleteDataStream(DeleteDataStreamRequest deleteDataStreamRequest, RequestOptions options)
import org.opensearch.action.admin.indices.open.OpenIndexResponse;
        );
            options,
            org.opensearch.action.admin.indices.shrink.ResizeResponse::fromXContent,
     * @throws IOException in case there is a problem sending the request
     * @throws IOException in case there is a problem sending the request or parsing back the response
            emptySet()
     *
import org.opensearch.client.indices.DeleteDataStreamRequest;
     * @return cancellable that may be used to cancel the request
     * @param request the request
import org.opensearch.action.admin.indices.alias.IndicesAliasesRequest;
     * @param resizeRequest the request
        ActionListener<AcknowledgedResponse> listener
        return restHighLevelClient.performRequestAndParseEntity(
            IndicesRequestConverters::putDataStream,
     * @param listener the listener to be notified upon request completion
import org.opensearch.client.indices.GetIndexResponse;
     * @return the response
     *
     *
        return restHighLevelClient.performRequest(
     */
     * @param request the request
            emptySet()
        RequestOptions options
        );
import org.opensearch.action.admin.indices.cache.clear.ClearIndicesCacheResponse;
            refreshRequest,
     * Gets index templates using the Index Templates API
    }
            IndicesRequestConverters::dataStreamsStats,
        return restHighLevelClient.performRequestAsyncAndParseEntity(
        return restHighLevelClient.performRequest(
            RefreshResponse::fromXContent,
            options,
            emptySet()
import org.opensearch.client.indices.GetFieldMappingsRequest;
     *
     * Simulates matching index name against the existing index templates in the system.
        RequestOptions options,
        SimulateIndexTemplateRequest simulateIndexTemplateRequest,
        RequestOptions options,
        DataStreamsStatsRequest dataStreamsStatsRequest,
    }
            emptySet()
            ResizeResponse::fromXContent,
     * Delete an index template using the Index Templates API
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
     * @param getAliasesRequest the request
    /**
            AcknowledgedResponse::fromXContent,
     * @param deleteIndexRequest the request
     * @param indexTemplatesRequest the request
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
     * @param flushRequest the request
            IndicesRequestConverters::putTemplate,
            org.opensearch.action.admin.indices.shrink.ResizeResponse::fromXContent,
     * Asynchronously updates specific index level settings using the Update Indices Settings API.
     * @return cancellable that may be used to cancel the request
     * Uses the Index Templates API to determine if index templates exist
            getIndexTemplatesRequest,
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
            IndicesRequestConverters::clearCache,
            forceMergeRequest,
            request,
    /**
            IndicesRequestConverters::templatesExist,
            refreshRequest,
            rolloverRequest,
        IndicesAliasesRequest indicesAliasesRequest,
}
            indexTemplatesRequest,
    /**
            clearIndicesCacheRequest,
        ActionListener<GetFieldMappingsResponse> listener
package org.opensearch.client;
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
     *
    public Cancellable flushAsync(FlushRequest flushRequest, RequestOptions options, ActionListener<FlushResponse> listener) {
        RequestOptions options,
            options,
    }
     * @param listener the listener to be notified upon request completion
            options,
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
            IndicesRequestConverters::simulateIndexTemplate,
        DeleteComposableIndexTemplateRequest request,
     * @return the response
        ActionListener<GetIndexTemplatesResponse> listener
import org.opensearch.client.indices.CreateIndexResponse;
    }
        );
            emptySet()
        throws IOException {
import org.opensearch.client.indices.GetIndexTemplatesRequest;
    public GetDataStreamResponse getDataStream(GetDataStreamRequest dataStreamRequest, RequestOptions options) throws IOException {
     * Gets statistics about one or more data streams using the Get Data Streams Stats API.
    public Cancellable deleteDataStreamAsync(
        ActionListener<GetDataStreamResponse> listener
            resizeRequest,
        return restHighLevelClient.performRequestAndParseEntity(
            emptySet()
     * @param request the request
    }
            AcknowledgedResponse::fromXContent,
            IndicesRequestConverters::getIndex,
        RequestOptions options,
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
     * Asynchronously gets index templates using the Index Templates API
     * @param getIndexRequest the request
     */
     */
            createIndexRequest,
     * Asynchronously delete an index template using the Index Templates API
     * @param updateSettingsRequest the request
        return restHighLevelClient.performRequestAndParseEntity(
     */
     */
     *
     * @param request the request
     * Asynchronously refresh one or more indices using the Refresh API.
/**
     * @deprecated use {@link #clone(ResizeRequest, RequestOptions)}
     * @return cancellable that may be used to cancel the request
     */
     * @param putIndexTemplateRequest the request
    /**
     * @param options   the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
            listener,
        );
    public Cancellable existsAliasAsync(GetAliasesRequest getAliasesRequest, RequestOptions options, ActionListener<Boolean> listener) {
        RequestOptions options,
        RequestOptions options,
     */
    public ForceMergeResponse forceMerge(ForceMergeRequest forceMergeRequest, RequestOptions options) throws IOException {
        );
     * Asynchronously checks if the index (indices) exists or not.
            IndicesRequestConverters::putIndexTemplate,
     * @param resizeRequest the request
            IndicesRequestConverters::getMappings,
        RequestOptions options,
     * @param listener                the listener to be notified upon request completion
     * Asynchronously deletes a data stream using the Delete Data Stream API.
        RequestOptions options,
        );
     * @throws IOException in case there is a problem sending the request or parsing back the response
            listener,
     * @return the response
            org.opensearch.action.admin.indices.shrink.ResizeResponse::fromXContent,
     * @param listener the listener to be notified upon request completion
     * @param clearIndicesCacheRequest the request
            closeIndexRequest,
            org.opensearch.client.core.AcknowledgedResponse::fromXContent,
     * @param listener the listener to be notified upon request completion
    }
            options,
     */
import org.opensearch.action.admin.indices.cache.clear.ClearIndicesCacheRequest;
     * Asynchronously clones an index using the Clone Index API.
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
            AcknowledgedResponse::fromXContent,
            getMappingsRequest,
    /**
     *
     * @param options                 the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be
        throws IOException {
     * @param options                      the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be
import org.opensearch.client.indices.DataStreamsStatsRequest;
            AnalyzeResponse::fromXContent,
            options,
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
    /**
     * @param updateSettingsRequest the request
        );
            IndicesRequestConverters::indexPutSettings,
        return forcemergeAsync(forceMergeRequest, options, listener);
    /**
     * @throws IOException in case there is a problem sending the request or parsing back the response
    ) {
 */
    /**
            deleteIndexRequest,
    public boolean existsAlias(GetAliasesRequest getAliasesRequest, RequestOptions options) throws IOException {
    /**
    public org.opensearch.action.admin.indices.shrink.ResizeResponse split(
     * Asynchronously delete an index template using the Index Templates API
    public Cancellable splitAsync(ResizeRequest resizeRequest, RequestOptions options, ActionListener<ResizeResponse> listener) {
     */
        );
    ) {
     * @param listener                     the listener to be notified upon request completion
            listener,
            emptySet()
            options,
     * @throws IOException in case there is a problem sending the request or parsing back the response
import java.util.Collections;
    ) {
    /**
     * @return cancellable that may be used to cancel the request
        ClearIndicesCacheRequest clearIndicesCacheRequest,
            request,
            listener,
     */
            emptySet()
     */
            SimulateIndexTemplateResponse::fromXContent,
            IndicesRequestConverters::clone,
    }
import org.opensearch.action.admin.indices.delete.DeleteIndexRequest;
     */
     * Asynchronously validate a potentially expensive query without executing it.
    }
import org.opensearch.client.indices.GetMappingsRequest;
        RequestOptions options,
            resizeRequest,
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
            IndicesRequestConverters::flush,
     * @return cancellable that may be used to cancel the request
     * Calls the analyze API
    ) {
     */
    public Cancellable existsIndexTemplateAsync(
            emptySet()
     * Updates the mappings on an index using the Put Mapping API.
        );
            putMappingRequest,
     * @param options  the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
     * Asynchronously retrieves the mappings on an index on indices using the Get Mapping API.
    /**
     * @throws IOException in case there is a problem sending the request or parsing back the response
    ) {
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
     * @return the response
    /**
     * Puts an index template using the Index Templates API.
            options,
        );
     *
        );
            emptySet()
            resizeRequest,
    }
            IndicesRequestConverters::deleteDataStream,
import org.opensearch.client.indices.CreateIndexRequest;
            emptySet()
        ActionListener<ClearIndicesCacheResponse> listener
     */
    /**
     * @return cancellable that may be used to cancel the request
            options,
            flushRequest,
     * Asynchronously force merge one or more indices using the Force Merge API.
     * @deprecated use {@link #forcemergeAsync(ForceMergeRequest, RequestOptions, ActionListener)} instead
        );
        return restHighLevelClient.performRequestAsyncAndParseEntity(
     * Asynchronously simulates matching index name against the existing index templates in the system.
import org.opensearch.client.indices.GetIndexRequest;
     */
     */
            listener,
            emptySet()
        );
     *
            AcknowledgedResponse::fromXContent,
     * @return cancellable that may be used to cancel the request
     */
        return restHighLevelClient.performRequestAndParseEntity(
     *
            emptySet()
     * @param openIndexRequest the request
            listener,
        return restHighLevelClient.performRequestAsyncAndParseEntity(
     * @param resizeRequest the request
     * @param createDataStreamRequest the request
     * @param listener the listener to be notified upon request completion
        return restHighLevelClient.performRequestAsyncAndParseEntity(
    public CloseIndexResponse close(CloseIndexRequest closeIndexRequest, RequestOptions options) throws IOException {
            emptySet()
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
     * @return the response
    public GetComposableIndexTemplatesResponse getIndexTemplate(
            listener,
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
            FlushResponse::fromXContent,
            putIndexTemplateRequest,
            emptySet()
            options,
            CloseIndexResponse::fromXContent,
    }
            options,
     *
            listener,
            SimulateIndexTemplateResponse::fromXContent,
            GetIndexTemplatesResponse::fromXContent,
    }
     * @throws IOException in case there is a problem sending the request or parsing back the response
     * @param getAliasesRequest the request
     * @throws IOException in case there is a problem sending the request or parsing back the response
     * @return cancellable that may be used to cancel the request
 */
     */
    ) {
     * Opens an index using the Open Index API.
            options,
            getIndexTemplatesRequest,
     *                                customized
    public CreateIndexResponse create(CreateIndexRequest createIndexRequest, RequestOptions options) throws IOException {
     *
            RestHighLevelClient::convertExistsResponse,
     */
            IndicesRequestConverters::getMappings,
        return restHighLevelClient.performRequestAsyncAndParseEntity(
    /**
            simulateIndexTemplateRequest,
     * @param options                      the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be
        ActionListener<ForceMergeResponse> listener
     * @return cancellable that may be used to cancel the request
        return restHighLevelClient.performRequestAsyncAndParseEntity(
        throws IOException {
    ) throws IOException {
    public Cancellable validateQueryAsync(
     */
            IndicesRequestConverters::getSettings,
     * @param options                 the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be
     * @throws IOException in case there is a problem sending the request or parsing back the response
     * @param putIndexTemplateRequest the request
        );
     * @param getSettingsRequest the request
    /**
            options,
            GetMappingsResponse::fromXContent,
            IndicesRequestConverters::shrink,
        return restHighLevelClient.performRequestAsyncAndParseEntity(
        );
     * @return the response
     * Splits an index using the Split Index API.
    public Cancellable analyzeAsync(AnalyzeRequest request, RequestOptions options, ActionListener<AnalyzeResponse> listener) {
     * Creates an index using the Create Index API.
    public AcknowledgedResponse putMapping(PutMappingRequest putMappingRequest, RequestOptions options) throws IOException {
            createDataStreamRequest,
        return restHighLevelClient.performRequestAsyncAndParseEntity(
     * Asynchronously shrinks an index using the Shrink index API.
            rolloverRequest,
     * @param options                 the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be
        );
     * @throws IOException in case there is a problem sending the request or parsing back the response
     * @throws IOException in case there is a problem sending the request or parsing back the response
        return restHighLevelClient.performRequestAsync(
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
    ) {
        return restHighLevelClient.performRequestAndParseEntity(
        return restHighLevelClient.performRequestAndParseEntity(
    /**
     */
    }
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
     * @throws IOException in case there is a problem sending the request or parsing back the response
        );
        return restHighLevelClient.performRequest(
            options,
     * Retrieves the mappings on an index or indices using the Get Mapping API.
     * Retrieve information about one or more indexes
        ActionListener<GetComposableIndexTemplatesResponse> listener
     * @throws IOException in case there is a problem sending the request or parsing back the response
        return restHighLevelClient.performRequestAndParseEntity(
            AcknowledgedResponse::fromXContent,
            IndicesRequestConverters::putIndexTemplate,
            listener,
    public ResizeResponse shrink(ResizeRequest resizeRequest, RequestOptions options) throws IOException {
    public Cancellable shrinkAsync(
    /**
    /**
        return restHighLevelClient.performRequestAndParseEntity(
     * Asynchronously clears the cache of one or more indices using the Clear Cache API.
    public AcknowledgedResponse createDataStream(CreateDataStreamRequest createDataStreamRequest, RequestOptions options)
            options,
     * @return the response
     * Asynchronously rolls over an index using the Rollover Index API.
    ) {
        return restHighLevelClient.performRequest(
     */
            resizeRequest,
     * @param resizeRequest the request
     *
            DataStreamsStatsResponse::fromXContent,
    public Cancellable clearCacheAsync(
     * @return cancellable that may be used to cancel the request
     * @return cancellable that may be used to cancel the request
        ActionListener<DataStreamsStatsResponse> listener
            IndicesRequestConverters::flush,
     */
            options,
        );
            emptySet()
            ForceMergeResponse::fromXContent,
            IndicesRequestConverters::deleteIndex,
 * Modifications Copyright OpenSearch Contributors. See
            listener,
            DataStreamsStatsResponse::fromXContent,
     *
        ActionListener<AcknowledgedResponse> listener
     * @return the response
    /**
            listener,
            IndicesRequestConverters::split,
    }
        );
            emptySet()
            IndicesRequestConverters::clone,
            AcknowledgedResponse::fromXContent,
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
            getIndexRequest,
        ActionListener<AcknowledgedResponse> listener
    /**
        GetComposableIndexTemplateRequest getIndexTemplatesRequest,
import org.opensearch.client.indices.GetComposableIndexTemplateRequest;
    /**
     * @param forceMergeRequest the request
    }
        RequestOptions options,
        PutIndexTemplateRequest putIndexTemplateRequest,
            emptySet()
            GetIndexResponse::fromXContent,
     *
        RequestOptions options,
            openIndexRequest,
     * @param resizeRequest the request
        );
        return forcemerge(forceMergeRequest, options);
    }
     * @throws IOException in case there is a problem sending the request or parsing back the response
     * @return the response
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
import org.opensearch.client.indices.IndexTemplatesExistRequest;
    }
            RefreshResponse::fromXContent,
            options,
     */
     * Asynchronously puts an index template using the Index Templates API.
        throws IOException {
            options,
     *
     * @return the response
        return restHighLevelClient.performRequestAndParseEntity(
 * this file be licensed under the Apache-2.0 license or a
    }
 * KIND, either express or implied.  See the License for the
     * Asynchronously puts an index template using the Index Templates API.
            IndicesRequestConverters::getDataStreams,
            IndicesRequestConverters::getFieldMapping,
    public Cancellable rolloverAsync(RolloverRequest rolloverRequest, RequestOptions options, ActionListener<RolloverResponse> listener) {
    /**
     * Asynchronously creates an index using the Create Index API.
    @Deprecated
            AcknowledgedResponse::fromXContent,
            options,
 * You may obtain a copy of the License at
     */
    public Cancellable updateAliasesAsync(
    }
    }
     * @param listener the listener to be notified upon request completion
    }
        );
    public Cancellable createDataStreamAsync(
    public FlushResponse flush(FlushRequest flushRequest, RequestOptions options) throws IOException {
    /**
    public Cancellable refreshAsync(RefreshRequest refreshRequest, RequestOptions options, ActionListener<RefreshResponse> listener) {
     * @return the response
        return restHighLevelClient.performRequestAsyncAndParseEntity(
            options,
            emptySet()
            Collections.emptySet()
     * @param request   the request
    public AnalyzeResponse analyze(AnalyzeRequest request, RequestOptions options) throws IOException {
        ActionListener<AcknowledgedResponse> listener
     * @param listener                the listener to be notified upon request completion
    /**
            options,
        return restHighLevelClient.performRequestAsync(
            resizeRequest,
            AcknowledgedResponse::fromXContent,
            options,
            ResizeResponse::fromXContent,
    public AcknowledgedResponse deleteIndexTemplate(DeleteComposableIndexTemplateRequest request, RequestOptions options)
     * @return the response
            emptySet()
     * @throws IOException in case there is a problem sending the request or parsing back the response
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
        RequestOptions options,
import org.opensearch.action.admin.indices.flush.FlushRequest;
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
     *
     * @return cancellable that may be used to cancel the request
            options,
     */
     *
     */
     * @param listener the listener to be notified upon request completion
            IndicesRequestConverters::forceMerge,
        return restHighLevelClient.performRequestAndParseEntity(
            options,
     * @return cancellable that may be used to cancel the request
     * @param options           the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
            GetMappingsResponse::fromXContent,
            getIndexRequest,
    }
    public Cancellable forcemergeAsync(
        RequestOptions options,
     */
            CreateIndexResponse::fromXContent,
 * GitHub history for details.
     * Asynchronously updates the mappings on an index using the Put Mapping API.
            emptySet()
    public DataStreamsStatsResponse dataStreamsStats(DataStreamsStatsRequest dataStreamsStatsRequest, RequestOptions options)
        );
        RequestOptions options
     * Uses the Index Templates API to determine if index templates exist
    }
            RestHighLevelClient::convertExistsResponse,
        );
     * @param indicesAliasesRequest the request
     *
        return restHighLevelClient.performRequestAsyncAndParseEntity(
            emptySet()
        return restHighLevelClient.performRequestAsyncAndParseEntity(
    public GetAliasesResponse getAlias(GetAliasesRequest getAliasesRequest, RequestOptions options) throws IOException {
            resizeRequest,
     */
        );
            listener,
        return restHighLevelClient.performRequestAsyncAndParseEntity(
            listener,
     * @return cancellable that may be used to cancel the request
            emptySet()
     *
            listener,
    /**
        return restHighLevelClient.performRequestAsyncAndParseEntity(
        );
            options,
    public ValidateQueryResponse validateQuery(ValidateQueryRequest validateQueryRequest, RequestOptions options) throws IOException {
    /**
     * @return cancellable that may be used to cancel the request
     * @return the response
     *
     * Checks if the index (indices) exists or not.
    }
     * @return cancellable that may be used to cancel the request
        );
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
     */
            options,
    ) {
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
            IndicesRequestConverters::simulateIndexTemplate,
        return restHighLevelClient.performRequestAsyncAndParseEntity(
    public AcknowledgedResponse putTemplate(PutIndexTemplateRequest putIndexTemplateRequest, RequestOptions options) throws IOException {
            IndicesRequestConverters::indicesExist,
            IndicesRequestConverters::deleteIndexTemplate,
     * @param getIndexTemplatesRequest the request
     * Asynchronously retrieves the field mappings on an index or indices using the Get Field Mapping API.
    }
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
    }
            getMappingsRequest,
     * @return cancellable that may be used to cancel the request
            emptySet()
     * @param listener the listener to be notified upon request completion
            IndicesRequestConverters::deleteAlias,
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
    }
        );
    public ResizeResponse split(ResizeRequest resizeRequest, RequestOptions options) throws IOException {
    ) {
    private final RestHighLevelClient restHighLevelClient;
            options,
        return restHighLevelClient.performRequestAsyncAndParseEntity(
    /**
     */
            IndicesRequestConverters::existsAlias,
        RequestOptions options,
            indexTemplatesExistRequest,
     * @param listener the listener to be notified upon request completion
            AcknowledgedResponse::fromXContent,
            listener,
        PutComposableIndexTemplateRequest putIndexTemplateRequest,
        );
    public ResizeResponse clone(ResizeRequest resizeRequest, RequestOptions options) throws IOException {
    }
    /**
    }
     * @param getIndexRequest the request
    }
    public Cancellable existsTemplateAsync(
        );
     * @param request  the request
     * Asynchronously opens an index using the Open Index API.
     * @return cancellable that may be used to cancel the request
     * @param listener the listener to be notified upon request completion
    public Cancellable shrinkAsync(ResizeRequest resizeRequest, RequestOptions options, ActionListener<ResizeResponse> listener) {
    @Deprecated
        CloseIndexRequest closeIndexRequest,
        throws IOException {
import org.opensearch.client.indices.ResizeResponse;
        return restHighLevelClient.performRequestAndParseEntity(
     * Asynchronously creates a data stream using the Create Data Stream API.
    /**
            request,
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
     * @return cancellable that may be used to cancel the request
            indicesAliasesRequest,
     * Rolls over an index using the Rollover Index API.
            IndicesRequestConverters::shrink,
            resizeRequest,
     * @param listener the listener to be notified upon request completion
        RequestOptions options,
        org.opensearch.action.admin.indices.shrink.ResizeRequest resizeRequest,
            options,
import org.opensearch.client.indices.DeleteComposableIndexTemplateRequest;
        );
    ) {
     * @param clearIndicesCacheRequest the request
 * this work for additional information regarding copyright
            AcknowledgedResponse::fromXContent,
        GetIndexTemplatesRequest getIndexTemplatesRequest,
            options,
     * Gets index templates using the Index Templates API
    /**
            options,
     * Retrieves the field mappings on an index or indices using the Get Field Mapping API.
        );
        SimulateIndexTemplateRequest simulateIndexTemplateRequest,
    }
import org.opensearch.action.admin.indices.settings.get.GetSettingsResponse;
        );
     */
        return restHighLevelClient.performRequestAsyncAndParseEntity(
        return restHighLevelClient.performRequestAndParseEntity(
        ActionListener<AcknowledgedResponse> listener
            IndicesRequestConverters::updateAliases,
     * @throws IOException in case there is a problem sending the request or parsing back the response
            ClearIndicesCacheResponse::fromXContent,
     * @param resizeRequest the request
     * @param listener the listener to be notified upon request completion
        org.opensearch.action.admin.indices.shrink.ResizeRequest resizeRequest,
        GetComposableIndexTemplateRequest getIndexTemplatesRequest,
        );
        return restHighLevelClient.performRequestAsyncAndParseEntity(
            AcknowledgedResponse::fromXContent,
        RequestOptions options,
    }
     *
            validateQueryRequest,
    }
     */
        return restHighLevelClient.performRequestAsyncAndParseEntity(
            IndicesRequestConverters::createIndex,
    public SimulateIndexTemplateResponse simulateIndexTemplate(
     * @return the response
     * Gets one or more data streams using the Get Data Stream API.
    /**
    public GetMappingsResponse getMapping(GetMappingsRequest getMappingsRequest, RequestOptions options) throws IOException {
import org.opensearch.action.admin.indices.forcemerge.ForceMergeResponse;
    /**
            IndicesRequestConverters::split,
     * @param listener the listener to be notified upon request completion
    public boolean exists(GetIndexRequest request, RequestOptions options) throws IOException {
    /**
     */
     *                                customized
    }
     * @return cancellable that may be used to cancel the request
    public Cancellable putTemplateAsync(
    @Deprecated
        );
            listener,
     * @return cancellable that may be used to cancel the request
     * @return the response
        return restHighLevelClient.performRequestAndParseEntity(
     * @return the response
    public OpenIndexResponse open(OpenIndexRequest openIndexRequest, RequestOptions options) throws IOException {
        ForceMergeRequest forceMergeRequest,
import org.opensearch.action.admin.indices.settings.get.GetSettingsRequest;
        ActionListener<AcknowledgedResponse> listener
    /**
            IndicesRequestConverters::updateAliases,
        );
            createIndexRequest,
     * @param indexTemplatesExistRequest the request
            listener,
     *
/*
            emptySet()
            IndicesRequestConverters::putTemplate,
     * @param listener the listener to be notified upon request completion
     *
     * @param forceMergeRequest the request
            ResizeResponse::fromXContent,
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
            IndicesRequestConverters::getDataStreams,
     */
            emptySet()
        return restHighLevelClient.performRequestAsyncAndParseEntity(
import org.opensearch.client.indices.ResizeRequest;
        return restHighLevelClient.performRequestAndParseEntity(
            options,
            listener,
     *
    ) {
            AcknowledgedResponse::fromXContent,
        ActionListener<GetSettingsResponse> listener
    }
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
            IndicesRequestConverters::deleteIndex,
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
     * Force merge one or more indices using the Force Merge API.
        return restHighLevelClient.performRequestAndParseEntity(
            IndicesRequestConverters::indicesExist,
     * @param listener the listener to be notified upon request completion
        return restHighLevelClient.performRequestAndParseEntity(
     * @param deleteDataStreamRequest the request
     * @return cancellable that may be used to cancel the request
     * Force merge one or more indices using the Force Merge API.
            options,
     *
     * Uses the Index Templates API to determine if index templates exist
            options,
    }
     * Refresh one or more indices using the Refresh API.
    /**
     * @param forceMergeRequest the request
            request,
            options,
        DeleteAliasRequest request,
 *
    }
     */
            request,
    @Deprecated
    /**
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
     * @return the response
        );
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
        );
     */
     * @throws IOException in case there is a problem sending the request or parsing back the response
        ActionListener<org.opensearch.action.admin.indices.shrink.ResizeResponse> listener
 * Unless required by applicable law or agreed to in writing,
     */
     */
            emptySet()
            OpenIndexResponse::fromXContent,
     * @param createIndexRequest the request
     * @throws IOException in case there is a problem sending the request or parsing back the response
            options,
            emptySet()
            RestHighLevelClient::convertExistsResponse,
        org.opensearch.action.admin.indices.shrink.ResizeRequest resizeRequest,
            emptySet()
     *
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
    ) {
            resizeRequest,
            emptySet()
            ForceMergeResponse::fromXContent,
    ) {
            options,
            CloseIndexResponse::fromXContent,
        return restHighLevelClient.performRequestAsyncAndParseEntity(
 * A wrapper for the {@link RestHighLevelClient} that provides methods for accessing the Indices API.
     * @throws IOException in case there is a problem sending the request or parsing back the response
     */
            options,
     * @param resizeRequest the request
     */
            ValidateQueryResponse::fromXContent,
     * Asynchronously clones an index using the Clone Index API.
 * ownership. Elasticsearch licenses this file to you under
            listener,
            IndicesRequestConverters::getTemplates,
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
            AcknowledgedResponse::fromXContent,
     * @throws IOException in case there is a problem sending the request or parsing back the response
    }
    }
     */
        );
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
     */
    }
     * @return cancellable that may be used to cancel the request
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;
    ) {
     *
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
     * @param closeIndexRequest the request
     * Retrieve the settings of one or more indices.
    }
     *
        return restHighLevelClient.performRequestAsyncAndParseEntity(
        RequestOptions options,
    /**
            options,
            emptySet()
public final class IndicesClient {
            IndicesRequestConverters::templatesExist,
import org.opensearch.client.indices.GetFieldMappingsResponse;
        return restHighLevelClient.performRequestAsyncAndParseEntity(
            options,
     * Asynchronously flush one or more indices using the Flush API.
            options,
            IndicesRequestConverters::rollover,
 * under the License.
     * @param simulateIndexTemplateRequest the request
            emptySet()
            IndicesRequestConverters::shrink,
        return restHighLevelClient.performRequestAsyncAndParseEntity(
     * @return the response
    }
            IndicesRequestConverters::getIndex,
    /**
    public Cancellable openAsync(OpenIndexRequest openIndexRequest, RequestOptions options, ActionListener<OpenIndexResponse> listener) {
     * @throws IOException in case there is a problem sending the request or parsing back the response
        CreateIndexRequest createIndexRequest,
     *
     * Clones an index using the Clone Index API.
            listener,
        );
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
    /**
     */
        );
            IndicesRequestConverters::getFieldMapping,
    /**
            AcknowledgedResponse::fromXContent,
            IndicesRequestConverters::refresh,
            emptySet()
     * @deprecated use {@link #forcemerge(ForceMergeRequest, RequestOptions)} instead
     * @param putIndexTemplateRequest the request
    public Cancellable forceMergeAsync(
     * @param refreshRequest the request
        );
    }
        RequestOptions options,
            emptySet()
            ResizeResponse::fromXContent,
            getAliasesRequest,
import org.opensearch.client.indices.SimulateIndexTemplateResponse;
        return restHighLevelClient.performRequestAndParseEntity(
    public Cancellable cloneAsync(
    public org.opensearch.client.core.AcknowledgedResponse deleteAlias(DeleteAliasRequest request, RequestOptions options)
            options,
        return restHighLevelClient.performRequestAndParseEntity(
     * Shrinks an index using the Shrink Index API.
import org.opensearch.client.indices.PutMappingRequest;
    ) {
     *
     * @return cancellable that may be used to cancel the request
    ) {
            IndicesRequestConverters::dataStreamsStats,
     * @param listener the listener to be notified upon request completion
     * @param rolloverRequest the request
     * @return the response
     *
     *
     */
     * @param listener the listener to be notified upon request completion
import org.opensearch.client.indices.CloseIndexResponse;
        ActionListener<org.opensearch.client.core.AcknowledgedResponse> listener
        return restHighLevelClient.performRequestAndParseEntity(
    public Cancellable getSettingsAsync(
            AcknowledgedResponse::fromXContent,
     * Asynchronously force merge one or more indices using the Force Merge API.
            IndicesRequestConverters::putMapping,
     */
        ActionListener<CloseIndexResponse> listener
    public Cancellable deleteAliasAsync(
    public Cancellable dataStreamsStatsAsync(
            emptySet()
 *
            getFieldMappingsRequest,
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
        return restHighLevelClient.performRequestAndParseEntity(
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
        org.opensearch.action.admin.indices.shrink.ResizeRequest resizeRequest,
    public GetIndexResponse get(GetIndexRequest getIndexRequest, RequestOptions options) throws IOException {
            emptySet()
        RequestOptions options
        return restHighLevelClient.performRequestAndParseEntity(
        org.opensearch.action.admin.indices.shrink.ResizeRequest resizeRequest,
            options,
        );
            dataStreamRequest,
     * Validate a potentially expensive query without executing it.
    }
            getAliasesRequest,
     *
        );
        );
        );
 */
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
     * Deletes a data stream using the Delete Data Stream API.
     * @return cancellable that may be used to cancel the request
     * @throws IOException in case there is a problem sending the request or parsing back the response
     * @param getMappingsRequest the request
     *
     * @return the response
    }
     *
    /**
     * @param dataStreamRequest the request
            listener,
            listener,
            GetComposableIndexTemplatesResponse::fromXContent,
     * @throws IOException in case there is a problem sending the request or parsing back the response
     * @return cancellable that may be used to cancel the request
        ActionListener<AcknowledgedResponse> listener
     * @return the response
     */
            options,
     * @param listener the listener to be notified upon request completion
    /**
     * Gets one or more aliases using the Get Index Aliases API.
    }
            deleteDataStreamRequest,
    public Cancellable deleteAsync(
            options,
    /**
     * @param options                 the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be
     * @param putIndexTemplateRequest the request
        ActionListener<AcknowledgedResponse> listener
    public Cancellable splitAsync(
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
            emptySet()
        GetDataStreamRequest dataStreamRequest,
    public org.opensearch.action.admin.indices.shrink.ResizeResponse shrink(
     *
        );
    /**
            IndicesRequestConverters::templatesExist,
            request,
    /**
            options,
    /**
    /**
     * @throws IOException in case there is a problem sending the request or parsing back the response
     * @param listener the listener to be notified upon request completion
    public Cancellable putSettingsAsync(
        PutMappingRequest putMappingRequest,
        );
        );
     */
        GetSettingsRequest getSettingsRequest,
        );
            listener,
     * @param putMappingRequest the request
            RestHighLevelClient::convertExistsResponse,
     */
            IndicesRequestConverters::analyze,
            putMappingRequest,
     */
    }
     */
        ActionListener<CreateIndexResponse> listener
            RestHighLevelClient::convertExistsResponse,
    }
            options,
     * @throws IOException in case there is a problem sending the request or parsing back the response
            GetComposableIndexTemplatesResponse::fromXContent,
    }
    public Cancellable putMappingAsync(
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
            dataStreamsStatsRequest,
            IndicesRequestConverters::rollover,
            IndicesRequestConverters::analyze,
     */
    public Cancellable deleteIndexTemplateAsync(
        throws IOException {
     *
     *
            emptySet()
    public Cancellable simulateIndexTemplateAsync(
            emptySet()
     * @deprecated use {@link #splitAsync(ResizeRequest, RequestOptions, ActionListener)}
        return restHighLevelClient.performRequestAndParseEntity(
            listener,
        );
     *
    }
     * @throws IOException in case there is a problem sending the request or parsing back the response
     * @param listener the listener to be notified upon request completion
    @Deprecated
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
     * Asynchronously gets statistics about one or more data streams using the Get Data Streams Stats API.
            emptySet()
            IndicesRequestConverters::getTemplates,
            GetSettingsResponse::fromXContent,
import org.opensearch.action.admin.indices.flush.FlushResponse;
            emptySet()
     * @deprecated use {@link #shrinkAsync(ResizeRequest, RequestOptions, ActionListener)}
            emptySet()
        );
            emptySet()
 */
            IndicesRequestConverters::deleteAlias,
            deleteDataStreamRequest,
     * @throws IOException in case there is a problem sending the request or parsing back the response
        RequestOptions options
    ) {
            listener,
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
     */
     * Asynchronously retrieve the settings of one or more indices.
        ActionListener<ValidateQueryResponse> listener
    /**
     */
    }
            ResizeResponse::fromXContent,
            emptySet()
     * @param listener the listener to be notified upon request completion
            options,
        throws IOException {
import org.opensearch.client.indices.CloseIndexRequest;
import org.opensearch.client.indices.GetDataStreamResponse;
    ) {
            emptySet()
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
            ClearIndicesCacheResponse::fromXContent,
            GetAliasesResponse::fromXContent,
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
            IndicesRequestConverters::openIndex,
        );
     */
        ActionListener<org.opensearch.action.admin.indices.shrink.ResizeResponse> listener
            GetFieldMappingsResponse::fromXContent,
            dataStreamRequest,
        RequestOptions options,
     * Asynchronously calls the analyze API
            emptySet()
     * @param listener the listener to be notified upon request completion
    public boolean existsIndexTemplate(ComposableIndexTemplateExistRequest indexTemplatesRequest, RequestOptions options)
            request,
     * @param listener the listener to be notified upon request completion
    }
     * @param closeIndexRequest the request
        ActionListener<Boolean> listener
    IndicesClient(RestHighLevelClient restHighLevelClient) {
            emptySet()
    public Cancellable getAliasAsync(
     * @throws IOException in case there is a problem sending the request or parsing back the response
            IndicesRequestConverters::deleteTemplate,
     * @throws IOException in case there is a problem sending the request or parsing back the response
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
     *
     *
            AcknowledgedResponse::fromXContent,
            emptySet()
     * @return cancellable that may be used to cancel the request
     * @throws IOException in case there is a problem sending the request or parsing back the response
        return restHighLevelClient.performRequestAndParseEntity(
     */
import static java.util.Collections.singleton;
            emptySet()
     * @param listener the listener to be notified upon request completion
     * @param getSettingsRequest the request
            IndicesRequestConverters::putDataStream,
     * @throws IOException in case there is a problem sending the request or parsing back the response
            IndicesRequestConverters::getSettings,
        return restHighLevelClient.performRequestAsyncAndParseEntity(
        );
     * @param indexTemplatesRequest the request
            singleton(RestStatus.NOT_FOUND.getStatus())
     * @param rolloverRequest the request
import org.opensearch.client.indices.rollover.RolloverRequest;
        RequestOptions options,
/*
    /**
    @Deprecated
            IndicesRequestConverters::split,
     *
        throws IOException {
        ValidateQueryRequest validateQueryRequest,
        DeleteIndexTemplateRequest request,
            listener,
        );
        );
    /**
            options,
        org.opensearch.action.admin.indices.shrink.ResizeRequest resizeRequest,
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
import org.opensearch.client.indices.GetComposableIndexTemplatesResponse;
        );
    }
     * @param validateQueryRequest the request
     */
     * @return the response
