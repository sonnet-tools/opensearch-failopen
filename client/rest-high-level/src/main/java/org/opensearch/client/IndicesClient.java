     * @param getMappingsRequest the request
import org.opensearch.client.indices.GetIndexTemplatesRequest;  
            emptySet()
    }
     */
            AcknowledgedResponse::fromXContent,  
        return restHighLevelClient.performRequestAsyncAndParseEntity(  
     * Retrieve information about one or more indexes  
        ForceMergeRequest forceMergeRequest,
     * @param listener the listener to be notified upon request completion  
            openIndexRequest,
            GetFieldMappingsResponse::fromXContent,  
            emptySet()
     * @param updateSettingsRequest the request
        GetMappingsRequest getMappingsRequest,
            ResizeResponse::fromXContent,
            IndicesRequestConverters::getMappings,
            putIndexTemplateRequest,
            GetComposableIndexTemplatesResponse::fromXContent,
    public AcknowledgedResponse putSettings(UpdateSettingsRequest updateSettingsRequest, RequestOptions options) throws IOException {
            AcknowledgedResponse::fromXContent,
        return restHighLevelClient.performRequestAndParseEntity(  
            options,  
     * @param listener the listener to be notified upon request completion
            options,  
     */
        DeleteDataStreamRequest deleteDataStreamRequest,  
        RequestOptions options,
     */
            getIndexTemplatesRequest,
    /**
            options,
     * @return the response  
     * @return cancellable that may be used to cancel the request  
    }  
     * Updates aliases using the Index Aliases API.
            options,  
import org.opensearch.client.indices.AnalyzeRequest;  
     * @throws IOException in case there is a problem sending the request or parsing back the response  
     * @param rolloverRequest the request
     * @return the response
            forceMergeRequest,  
            GetMappingsResponse::fromXContent,  
     * @param request the request
     *
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
     */
            emptySet()  
    }  
            singleton(RestStatus.NOT_FOUND.getStatus())
    /**
        );
            emptySet()
            IndicesRequestConverters::flush,
            options,
     * @return cancellable that may be used to cancel the request
     */
     */
     *  
     *  
    ) {  
            options,
            options,  
            IndicesRequestConverters::getFieldMapping,
            options,  
            options,  
     *  
    public ResizeResponse shrink(ResizeRequest resizeRequest, RequestOptions options) throws IOException {
    /**
     *  
     * @return the response  
     * @param validateQueryRequest the request
            IndicesRequestConverters::rollover,
    @Deprecated
    public boolean exists(GetIndexRequest request, RequestOptions options) throws IOException {  
     * @param putMappingRequest the request  
            IndicesRequestConverters::dataStreamsStats,
            options,  
    /**
    }
            options,
            IndicesRequestConverters::clearCache,
        return restHighLevelClient.performRequestAsyncAndParseEntity(
    @Deprecated  
    public GetAliasesResponse getAlias(GetAliasesRequest getAliasesRequest, RequestOptions options) throws IOException {
        ActionListener<ClearIndicesCacheResponse> listener
    /**  
import java.io.IOException;
    public CreateIndexResponse create(CreateIndexRequest createIndexRequest, RequestOptions options) throws IOException {
 */  
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
            indexTemplatesExistRequest,
    }
            options,  
            listener,  
     * @param options                 the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be
     * @return cancellable that may be used to cancel the request
            IndicesRequestConverters::split,
     * Checks if one or more aliases exist using the Aliases Exist API.
            emptySet()
            GetDataStreamResponse::fromXContent,
     * @param listener the listener to be notified upon request completion
            emptySet()
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized  
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;
     */
            getIndexTemplatesRequest,
import org.opensearch.client.indices.AnalyzeResponse;
     * @return the response  
     * @throws IOException in case there is a problem sending the request or parsing back the response
     *
            listener,
        RequestOptions options,
    }
import org.opensearch.client.indices.GetFieldMappingsRequest;
 * The OpenSearch Contributors require contributions made to  
    /**  
     * Splits an index using the Split Index API.
    }  
    public Cancellable getSettingsAsync(
        );  
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
    public Cancellable dataStreamsStatsAsync(  
    }
     */
     * @return cancellable that may be used to cancel the request
     * @param forceMergeRequest the request  
        return restHighLevelClient.performRequestAndParseEntity(
    /**  
            emptySet()  
    /**
    /**  
    /**
        RequestOptions options,
            emptySet()
        ActionListener<org.opensearch.client.core.AcknowledgedResponse> listener  
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized  
     *
        RequestOptions options,
            emptySet()  
        RequestOptions options,
    }
     * Updates specific index level settings using the Update Indices Settings API.  
            GetAliasesResponse::fromXContent,
     */
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
    /**
     * Asynchronously splits an index using the Split Index API.
            IndicesRequestConverters::getIndexTemplates,
        return restHighLevelClient.performRequestAsyncAndParseEntity(
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
            emptySet()  
     */
            IndicesRequestConverters::putTemplate,  
        return restHighLevelClient.performRequestAndParseEntity(
        ActionListener<AcknowledgedResponse> listener
    /**  
    }  
     *  
            IndicesRequestConverters::refresh,  
        org.opensearch.action.admin.indices.shrink.ResizeRequest resizeRequest,  
     * @param getFieldMappingsRequest the request
        return restHighLevelClient.performRequestAndParseEntity(
        ActionListener<GetComposableIndexTemplatesResponse> listener  
 * Modifications Copyright OpenSearch Contributors. See
            IndicesRequestConverters::getSettings,
     * Closes an index using the Close Index API.
    ) {
     */
    /**
        return restHighLevelClient.performRequestAsyncAndParseEntity(
    }
            emptySet()
            options,
     * @return cancellable that may be used to cancel the request  
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
        );  
        );
    public Cancellable cloneAsync(ResizeRequest resizeRequest, RequestOptions options, ActionListener<ResizeResponse> listener) {
     * @return cancellable that may be used to cancel the request
    }
        return restHighLevelClient.performRequestAndParseEntity(  
     */
 * Unless required by applicable law or agreed to in writing,
        RequestOptions options,  
            getMappingsRequest,  
        return restHighLevelClient.performRequestAndParseEntity(
    public AnalyzeResponse analyze(AnalyzeRequest request, RequestOptions options) throws IOException {
     * @return cancellable that may be used to cancel the request
            IndicesRequestConverters::getIndex,
     * Updates the mappings on an index using the Put Mapping API.
     *
     * @return cancellable that may be used to cancel the request
     * @return cancellable that may be used to cancel the request  
     *  
    /**
    ) {
        RequestOptions options  
            GetAliasesResponse::fromXContent,
            listener,  
            dataStreamsStatsRequest,  
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
            getAliasesRequest,
    public GetDataStreamResponse getDataStream(GetDataStreamRequest dataStreamRequest, RequestOptions options) throws IOException {
        IndexTemplatesExistRequest indexTemplatesExistRequest,
    }
        throws IOException {
     */  
            FlushResponse::fromXContent,  
     * @deprecated use {@link #splitAsync(ResizeRequest, RequestOptions, ActionListener)}
            emptySet()  
            RestHighLevelClient::convertExistsResponse,
            emptySet()
     * @param getAliasesRequest the request  
    /**  
import org.opensearch.client.indices.DeleteAliasRequest;
     * @param request the request  
        );
            getIndexTemplatesRequest,  
            AcknowledgedResponse::fromXContent,
            options,
        GetAliasesRequest getAliasesRequest,  
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized  
    }
        return restHighLevelClient.performRequestAndParseEntity(
        ActionListener<AcknowledgedResponse> listener  
     */  
     * @param listener the listener to be notified upon request completion
     * @param listener the listener to be notified upon request completion
     * Clones an index using the Clone Index API.
     *
     *  
     *
     * @param listener the listener to be notified upon request completion
     * @throws IOException in case there is a problem sending the request or parsing back the response
     *
            IndicesRequestConverters::indexPutSettings,
        );  
    public AcknowledgedResponse deleteDataStream(DeleteDataStreamRequest deleteDataStreamRequest, RequestOptions options)  
    /**  
        ActionListener<AcknowledgedResponse> listener  
     * @param resizeRequest the request
        );
    public Cancellable validateQueryAsync(
            options,
        RequestOptions options,  
        );
    }
        RequestOptions options,  
 */
    /**  
    }  
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized  
     *
            ResizeResponse::fromXContent,
        RequestOptions options,
            options,
            IndicesRequestConverters::shrink,
            rolloverRequest,  
            emptySet()
     * @return true if any index templates in the request exist, false otherwise
            IndicesRequestConverters::templatesExist,
    /**
            emptySet()
    /**
     * @return cancellable that may be used to cancel the request
     * @param resizeRequest the request  
import org.opensearch.client.indices.CloseIndexRequest;
        );  
    public Cancellable getAliasAsync(
            Collections.emptySet()  
import org.opensearch.client.indices.CreateIndexRequest;  
    public GetIndexTemplatesResponse getIndexTemplate(GetIndexTemplatesRequest getIndexTemplatesRequest, RequestOptions options)
            GetMappingsResponse::fromXContent,
    private final RestHighLevelClient restHighLevelClient;  
     * @param rolloverRequest the request
        ActionListener<GetFieldMappingsResponse> listener
        return restHighLevelClient.performRequestAndParseEntity(
     * @return the response
        RequestOptions options,
            AnalyzeResponse::fromXContent,
    public Cancellable cloneAsync(
     * @throws IOException in case there is a problem sending the request or parsing back the response
            emptySet()  
     * @return the response  
            options,  
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
        );
     * @param openIndexRequest the request  
            updateSettingsRequest,  
     */
     * Asynchronously gets index templates using the Index Templates API
        );  
        return restHighLevelClient.performRequestAsyncAndParseEntity(
            emptySet()
     * @param listener the listener to be notified upon request completion
}
        return restHighLevelClient.performRequestAndParseEntity(
    @Deprecated  
            emptySet()  
     */
        );
import org.opensearch.action.admin.indices.settings.get.GetSettingsRequest;
        PutIndexTemplateRequest putIndexTemplateRequest,
            emptySet()  
     *
        );
    }
     * Force merge one or more indices using the Force Merge API.  
     * @param getIndexTemplatesRequest the request
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            IndicesRequestConverters::getDataStreams,
    public Cancellable deleteAsync(
     */  
     * @param resizeRequest the request
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
     * @param options                 the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be
        );
     */
            listener,
     */
     * Asynchronously force merge one or more indices using the Force Merge API.  
    /**
     * @return cancellable that may be used to cancel the request
    ) {
    public boolean existsIndexTemplate(ComposableIndexTemplateExistRequest indexTemplatesRequest, RequestOptions options)
    }  
     */
            IndicesRequestConverters::deleteIndexTemplate,
            putMappingRequest,
            IndicesRequestConverters::deleteAlias,
        ActionListener<GetDataStreamResponse> listener
            ResizeResponse::fromXContent,  
    }
            listener,
        return restHighLevelClient.performRequestAsync(
     * @return cancellable that may be used to cancel the request  
    ) throws IOException {
     * @return the response
     * @deprecated use {@link #clone(ResizeRequest, RequestOptions)}
    /**
     * @param resizeRequest the request
     *
        return restHighLevelClient.performRequestAndParseEntity(  
        );  
            AcknowledgedResponse::fromXContent,
     */  
     * @return the response
            dataStreamRequest,  
        );
     */  
            listener,
     *
import org.opensearch.client.indices.PutIndexTemplateRequest;  
    public AcknowledgedResponse putTemplate(PutIndexTemplateRequest putIndexTemplateRequest, RequestOptions options) throws IOException {  
            AcknowledgedResponse::fromXContent,  
     * @return the response  
    }
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized  
        org.opensearch.action.admin.indices.shrink.ResizeRequest resizeRequest,
        GetComposableIndexTemplateRequest getIndexTemplatesRequest,
            resizeRequest,  
     * Puts an index template using the Index Templates API.
     * @throws IOException in case there is a problem sending the request or parsing back the response
        return restHighLevelClient.performRequestAndParseEntity(
     * @param flushRequest the request
     *
     *
     *
        ActionListener<GetMappingsResponse> listener
        RequestOptions options,
        return restHighLevelClient.performRequestAsync(
     * @return the response
     * @param dataStreamsStatsRequest the request  
        );
            org.opensearch.action.admin.indices.shrink.ResizeResponse::fromXContent,
        );  
     * Asynchronously retrieve the settings of one or more indices.
            emptySet()
     * Uses the Index Templates API to determine if index templates exist
    public Cancellable updateAliasesAsync(  
import org.opensearch.client.indices.DeleteComposableIndexTemplateRequest;
     * @return the response
 * this work for additional information regarding copyright
     * Gets one or more data streams using the Get Data Stream API.  
            ResizeResponse::fromXContent,
import org.opensearch.core.rest.RestStatus;  
            IndicesRequestConverters::closeIndex,
            emptySet()  
    }
     * @param dataStreamRequest the request
     */  
            options,
            options,
    public org.opensearch.action.admin.indices.shrink.ResizeResponse clone(
    public org.opensearch.action.admin.indices.shrink.ResizeResponse split(
     * @param listener the listener to be notified upon request completion
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized  
     */  
     * @return cancellable that may be used to cancel the request  
import org.opensearch.client.indices.rollover.RolloverResponse;
            AcknowledgedResponse::fromXContent,
    }  
     *  
            IndicesRequestConverters::refresh,  
     * @throws IOException in case there is a problem sending the request or parsing back the response
        return restHighLevelClient.performRequestAsyncAndParseEntity(  
    /**
     *                                customized
     * @param getIndexRequest the request
     *  
     *
        );
    public Cancellable deleteTemplateAsync(
            emptySet()  
     * @return cancellable that may be used to cancel the request
     * Uses the Index Templates API to determine if index templates exist  
    /**
            emptySet()
            OpenIndexResponse::fromXContent,
    }  
     */
        );
    /**
    }
        return restHighLevelClient.performRequestAsyncAndParseEntity(
     * @throws IOException in case there is a problem sending the request or parsing back the response
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
    public Cancellable openAsync(OpenIndexRequest openIndexRequest, RequestOptions options, ActionListener<OpenIndexResponse> listener) {
     * Creates an index using the Create Index API.  
            org.opensearch.action.admin.indices.shrink.ResizeResponse::fromXContent,
        CreateIndexRequest createIndexRequest,
     * Asynchronously opens an index using the Open Index API.
     * @return cancellable that may be used to cancel the request  
     * Asynchronously shrinks an index using the Shrink index API.
            IndicesRequestConverters::updateAliases,  
     * @return the response
    public ResizeResponse split(ResizeRequest resizeRequest, RequestOptions options) throws IOException {
     * @param resizeRequest the request  
     * @param options           the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized  
            IndicesRequestConverters::simulateIndexTemplate,  
     * @param options   the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized  
    public Cancellable shrinkAsync(ResizeRequest resizeRequest, RequestOptions options, ActionListener<ResizeResponse> listener) {  
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized  
            createIndexRequest,  
     *
        return restHighLevelClient.performRequestAsyncAndParseEntity(  
import org.opensearch.client.indices.SimulateIndexTemplateRequest;
    public ValidateQueryResponse validateQuery(ValidateQueryRequest validateQueryRequest, RequestOptions options) throws IOException {
            options,  
    public AcknowledgedResponse deleteTemplate(DeleteIndexTemplateRequest request, RequestOptions options) throws IOException {
            options,
    }  
            listener,  
        return restHighLevelClient.performRequestAsyncAndParseEntity(
/*  
            IndicesRequestConverters::createIndex,
     *
            emptySet()  
import org.opensearch.client.indices.GetIndexTemplatesResponse;
            emptySet()
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
            options,
        return restHighLevelClient.performRequestAndParseEntity(
        CloseIndexRequest closeIndexRequest,
            IndicesRequestConverters::putTemplate,
    @Deprecated
            options,
    ) {
     * Asynchronously refresh one or more indices using the Refresh API.
     */
 *
        return restHighLevelClient.performRequestAndParseEntity(  
            emptySet()
            listener,
    }
    /**
     * @return cancellable that may be used to cancel the request
            IndicesRequestConverters::analyze,
    ) {  
            options,  
    ) {
            listener,
            FlushResponse::fromXContent,  
            IndicesRequestConverters::templatesExist,  
    ) {
            request,
     * Asynchronously force merge one or more indices using the Force Merge API.  
        RequestOptions options
     *  
    ) {
     * @return the response
     * @return the response  
            indicesAliasesRequest,
     * @param deleteIndexRequest the request  
            deleteDataStreamRequest,
        return restHighLevelClient.performRequestAsyncAndParseEntity(
    /**  
import org.opensearch.action.admin.indices.delete.DeleteIndexRequest;
            emptySet()
     * @return cancellable that may be used to cancel the request
     * Creates a data stream using the Create Data Stream API.
            emptySet()
     * Asynchronously gets statistics about one or more data streams using the Get Data Streams Stats API.
            IndicesRequestConverters::deleteTemplate,
     * @param listener                     the listener to be notified upon request completion
        return restHighLevelClient.performRequestAndParseEntity(  
     * @param listener                the listener to be notified upon request completion  
     */
    /**  
     *
     *
     */
        throws IOException {
            resizeRequest,
     *
        RequestOptions options,  
     * @throws IOException in case there is a problem sending the request or parsing back the response
        return restHighLevelClient.performRequestAndParseEntity(
     * Asynchronously gets index templates using the Index Templates API
     * @throws IOException in case there is a problem sending the request or parsing back the response  
        );
     * @param getAliasesRequest the request  
            listener,
     * @param indicesAliasesRequest the request
     * @param listener the listener to be notified upon request completion
            listener,  
     * @param closeIndexRequest the request
            CloseIndexResponse::fromXContent,
     *
     */
     * @param getMappingsRequest the request
    public AcknowledgedResponse putMapping(PutMappingRequest putMappingRequest, RequestOptions options) throws IOException {
        return restHighLevelClient.performRequestAsyncAndParseEntity(
            options,  
     */
            IndicesRequestConverters::putMapping,  
     * @param deleteIndexRequest the request  
     * @throws IOException in case there is a problem sending the request or parsing back the response
            options,  
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized  
        return restHighLevelClient.performRequestAndParseEntity(  
    public AcknowledgedResponse delete(DeleteIndexRequest deleteIndexRequest, RequestOptions options) throws IOException {
     * Clones an index using the Clone Index API.
        );
            RestHighLevelClient::convertExistsResponse,
     * Checks if the index (indices) exists or not.
     * Force merge one or more indices using the Force Merge API.
        return forcemergeAsync(forceMergeRequest, options, listener);
        DeleteComposableIndexTemplateRequest request,
import org.opensearch.client.indices.DataStreamsStatsRequest;
     * @param putMappingRequest the request  
     *
    }
     * Gets index templates using the Index Templates API
        return restHighLevelClient.performRequestAndParseEntity(
     * Asynchronously gets one or more aliases using the Get Index Aliases API.
     * Asynchronously gets one or more data streams using the Get Data Stream API.  
     * @return cancellable that may be used to cancel the request
            RestHighLevelClient::convertExistsResponse,
     *
    }  
     */
            IndicesRequestConverters::shrink,  
        );
        ActionListener<ValidateQueryResponse> listener
            IndicesRequestConverters::getAlias,  
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized  
 *  
        return restHighLevelClient.performRequestAsyncAndParseEntity(
            options,
            AcknowledgedResponse::fromXContent,  
        CreateDataStreamRequest createDataStreamRequest,
            deleteIndexRequest,
        RequestOptions options,
    public Cancellable simulateIndexTemplateAsync(
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
    /**
     */
        PutMappingRequest putMappingRequest,  
        ActionListener<GetAliasesResponse> listener
        ActionListener<ForceMergeResponse> listener  
        );
    }
    ) {
     * Asynchronously rolls over an index using the Rollover Index API.  
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
            IndicesRequestConverters::getIndexTemplates,  
     * @return cancellable that may be used to cancel the request  
        );
            IndicesRequestConverters::clone,  
            resizeRequest,
    /**  
    @Deprecated
 * SPDX-License-Identifier: Apache-2.0
     * @param closeIndexRequest the request
    public RefreshResponse refresh(RefreshRequest refreshRequest, RequestOptions options) throws IOException {  
            IndicesRequestConverters::flush,
     *
    }
            IndicesRequestConverters::deleteTemplate,  
    /**
     */  
     * @param listener the listener to be notified upon request completion
        return restHighLevelClient.performRequestAndParseEntity(
     * Gets statistics about one or more data streams using the Get Data Streams Stats API.
    /**  
     * @param listener the listener to be notified upon request completion
            emptySet()
     */
    public Cancellable shrinkAsync(  
        return restHighLevelClient.performRequestAsyncAndParseEntity(  
            IndicesRequestConverters::deleteIndexTemplate,
    IndicesClient(RestHighLevelClient restHighLevelClient) {
    ) {
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized  
     * @throws IOException in case there is a problem sending the request or parsing back the response  
     * @param getFieldMappingsRequest the request
        org.opensearch.action.admin.indices.shrink.ResizeRequest resizeRequest,
            emptySet()
    public SimulateIndexTemplateResponse simulateIndexTemplate(
            AcknowledgedResponse::fromXContent,
            GetIndexTemplatesResponse::fromXContent,
     * @param listener                the listener to be notified upon request completion
            options,
            clearIndicesCacheRequest,  
     * Retrieve the settings of one or more indices.
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized  
            listener,
     * @return the response  
     */
            emptySet()
     * @return the response
    }
     * Deletes a data stream using the Delete Data Stream API.
        GetIndexTemplatesRequest getIndexTemplatesRequest,
     *
            options,
            IndicesRequestConverters::indicesExist,  
    public Cancellable deleteAliasAsync(  
    ) {  
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
     *  
     */  
            options,  
            request,
    public Cancellable closeAsync(  
        );
     */  
        return restHighLevelClient.performRequestAsyncAndParseEntity(  
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized  
            GetDataStreamResponse::fromXContent,  
        return restHighLevelClient.performRequestAsyncAndParseEntity(
     * Uses the Index Templates API to determine if index templates exist
     * @param dataStreamRequest the request
    public Cancellable putTemplateAsync(  
     */  
     * @return the response
        SimulateIndexTemplateRequest simulateIndexTemplateRequest,  
    /**  
     */
     * @param listener the listener to be notified upon request completion
     * @return cancellable that may be used to cancel the request
        return restHighLevelClient.performRequestAndParseEntity(
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized  
        ActionListener<DataStreamsStatsResponse> listener  
     * @param dataStreamsStatsRequest the request
    @Deprecated
     * @param indicesAliasesRequest the request
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
     */  
     * @throws IOException in case there is a problem sending the request or parsing back the response
    /**  
 * the Apache License, Version 2.0 (the "License"); you may
     * @param listener the listener to be notified upon request completion
     *
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
            IndicesRequestConverters::clone,
            IndicesRequestConverters::dataStreamsStats,
 * A wrapper for the {@link RestHighLevelClient} that provides methods for accessing the Indices API.  
     *
    }  
            listener,
            validateQueryRequest,  
     * Asynchronously calls the analyze API
     */
            listener,
            listener,  
    /**
     * @throws IOException in case there is a problem sending the request or parsing back the response
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized  
            emptySet()
     * @deprecated use {@link #forcemerge(ForceMergeRequest, RequestOptions)} instead
     *                                customized
        throws IOException {
     * @param putIndexTemplateRequest the request  
        );
        return restHighLevelClient.performRequestAndParseEntity(
     * @param createIndexRequest the request
            updateSettingsRequest,
    public Cancellable existsAliasAsync(GetAliasesRequest getAliasesRequest, RequestOptions options, ActionListener<Boolean> listener) {
/*  
            options,
        return restHighLevelClient.performRequestAndParseEntity(
     * @throws IOException in case there is a problem sending the request or parsing back the response
    public Cancellable putMappingAsync(
    }
        );
     * @throws IOException in case there is a problem sending the request or parsing back the response
            emptySet()
        return restHighLevelClient.performRequestAndParseEntity(
     * @param openIndexRequest the request  
        return restHighLevelClient.performRequestAsyncAndParseEntity(
     */
            emptySet()
     * @param deleteDataStreamRequest the request
            emptySet()  
     * @param options                 the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be
        );
            options,
        );
     * Asynchronously clears the cache of one or more indices using the Clear Cache API.  
     */  
     *  
            getSettingsRequest,
    /**
            indexTemplatesExistRequest,
     *
     * @throws IOException in case there is a problem sending the request or parsing back the response
    }
     * @param listener the listener to be notified upon request completion
import org.opensearch.client.indices.IndexTemplatesExistRequest;
            IndicesRequestConverters::getTemplates,
        ActionListener<SimulateIndexTemplateResponse> listener
            emptySet()
        ActionListener<Boolean> listener
    public ResizeResponse clone(ResizeRequest resizeRequest, RequestOptions options) throws IOException {  
            emptySet()
     * Gets index templates using the Index Templates API
        );  
            options,  
     * Asynchronously validate a potentially expensive query without executing it.  
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized  
            options,
        ActionListener<AcknowledgedResponse> listener  
            options,
            IndicesRequestConverters::putDataStream,
    /**  
     */
        ActionListener<AcknowledgedResponse> listener  
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
            clearIndicesCacheRequest,
            ResizeResponse::fromXContent,
            emptySet()
            listener,  
            IndicesRequestConverters::split,
     */  
 * You may obtain a copy of the License at  
     * Uses the Index Templates API to determine if index templates exist
import org.opensearch.client.indices.GetIndexResponse;
     * @param options           the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized  
     * Gets one or more aliases using the Get Index Aliases API.
            emptySet()
     *
            listener,  
     * @param listener the listener to be notified upon request completion
import org.opensearch.client.indices.PutMappingRequest;
        RequestOptions options,
     * @return cancellable that may be used to cancel the request
import org.opensearch.action.admin.indices.open.OpenIndexRequest;
        );
            request,
    ) throws IOException {
     * @throws IOException in case there is a problem sending the request or parsing back the response  
     * Delete an index template using the Index Templates API
     * Simulates matching index name against the existing index templates in the system.
        );  
        GetComposableIndexTemplateRequest getIndexTemplatesRequest,
 * not use this file except in compliance with the License.
     * @throws IOException in case there is a problem sending the request or parsing back the response
            indexTemplatesRequest,
        return restHighLevelClient.performRequest(
import org.opensearch.client.indices.ResizeRequest;
            IndicesRequestConverters::deleteAlias,
     */  
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
    /**  
     * @param listener the listener to be notified upon request completion  
        return restHighLevelClient.performRequestAndParseEntity(
    public Cancellable getMappingAsync(
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
    }
        ActionListener<org.opensearch.action.admin.indices.shrink.ResizeResponse> listener  
        ClearIndicesCacheRequest clearIndicesCacheRequest,
    /**
            ClearIndicesCacheResponse::fromXContent,
    /**
            RolloverResponse::fromXContent,  
            listener,
import org.opensearch.action.admin.indices.settings.get.GetSettingsResponse;  
     * @deprecated use {@link #forcemergeAsync(ForceMergeRequest, RequestOptions, ActionListener)} instead
        ForceMergeRequest forceMergeRequest,
            singleton(RestStatus.NOT_FOUND.getStatus())
        );
     *
            listener,
import static java.util.Collections.emptySet;
        ActionListener<CloseIndexResponse> listener  
     * Asynchronously deletes a data stream using the Delete Data Stream API.  
            listener,
    /**  
     * @param getIndexTemplatesRequest the request
    ) {  
     * @return cancellable that may be used to cancel the request  
            IndicesRequestConverters::putIndexTemplate,  
            OpenIndexResponse::fromXContent,
            listener,
     *                                     customized  
            AcknowledgedResponse::fromXContent,
    /**
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
        throws IOException {
            IndicesRequestConverters::deleteIndex,
     * @return cancellable that may be used to cancel the request  
    /**
            getMappingsRequest,
            IndicesRequestConverters::closeIndex,  
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
        );
    }  
     * @param getIndexTemplatesRequest the request
import org.opensearch.core.action.ActionListener;
     * @param request the request  
            options,
     */  
     * @param request  the request  
            options,
     * @return the response
     * @throws IOException in case there is a problem sending the request or parsing back the response
     * @param options                      the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be
        DataStreamsStatsRequest dataStreamsStatsRequest,
     * @param listener the listener to be notified upon request completion  
    /**  
            RestHighLevelClient::convertExistsResponse,
     * @param getAliasesRequest the request  
    }
import org.opensearch.client.indices.CloseIndexResponse;  
            openIndexRequest,
     *
     * @param validateQueryRequest the request
     * @return the response
        RequestOptions options,
    /**
            dataStreamsStatsRequest,
     */  
            IndicesRequestConverters::templatesExist,
    ) {
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
     */
        IndicesAliasesRequest indicesAliasesRequest,
    }  
        );
 * KIND, either express or implied.  See the License for the
            options,
     * Refresh one or more indices using the Refresh API.
            IndicesRequestConverters::analyze,
     * @param request   the request
            IndicesRequestConverters::rollover,
     */
    }  
     */  
     *  
     * @param getSettingsRequest the request  
    public AcknowledgedResponse putIndexTemplate(PutComposableIndexTemplateRequest putIndexTemplateRequest, RequestOptions options)
    /**
        );  
     * @param listener the listener to be notified upon request completion  
            options,
            DataStreamsStatsResponse::fromXContent,
    }
        );
     * @return cancellable that may be used to cancel the request
     */
     * @param request the request
            options,
     * @param resizeRequest the request  
            IndicesRequestConverters::getMappings,
            request,  
            emptySet()
            emptySet()
     *
    }  
import org.opensearch.action.admin.indices.cache.clear.ClearIndicesCacheResponse;
            options,
        );
    }  
     * @throws IOException in case there is a problem sending the request or parsing back the response  
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized  
     * @param putIndexTemplateRequest the request
    ) {
        RequestOptions options,
            ClearIndicesCacheResponse::fromXContent,  
            emptySet()
     * @param listener the listener to be notified upon request completion
     * @param indexTemplatesExistRequest the request
        return restHighLevelClient.performRequestAndParseEntity(  
        ActionListener<AcknowledgedResponse> listener
     * @param listener the listener to be notified upon request completion  
    public Cancellable getAsync(GetIndexRequest getIndexRequest, RequestOptions options, ActionListener<GetIndexResponse> listener) {
     * Asynchronously updates the mappings on an index using the Put Mapping API.
     * Retrieve information about one or more indexes  
import org.opensearch.client.indices.GetDataStreamRequest;  
     * @param request the request
            AcknowledgedResponse::fromXContent,
        return restHighLevelClient.performRequest(  
        return restHighLevelClient.performRequestAsyncAndParseEntity(
            IndicesRequestConverters::split,
            IndicesRequestConverters::getAlias,
    @Deprecated  
     *                                customized
     * @throws IOException in case there is a problem sending the request or parsing back the response  
     *                                customized
    public Cancellable putIndexTemplateAsync(  
    public Cancellable flushAsync(FlushRequest flushRequest, RequestOptions options, ActionListener<FlushResponse> listener) {
        return restHighLevelClient.performRequestAndParseEntity(
     * @return the response
            IndicesRequestConverters::shrink,
     * Asynchronously updates aliases using the Index Aliases API.
import org.opensearch.client.indices.GetComposableIndexTemplateRequest;
     * @return cancellable that may be used to cancel the request
    /**
        GetFieldMappingsRequest getFieldMappingsRequest,
        PutComposableIndexTemplateRequest putIndexTemplateRequest,
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
            options,
            emptySet()  
     * Delete an index template using the Index Templates API  
        org.opensearch.action.admin.indices.shrink.ResizeRequest resizeRequest,  
    /**
            IndicesRequestConverters::putDataStream,
     * @throws IOException in case there is a problem sending the request or parsing back the response  
        this.restHighLevelClient = restHighLevelClient;  
    /**  
        ComposableIndexTemplateExistRequest indexTemplatesExistRequest,
        RequestOptions options  
        return restHighLevelClient.performRequestAndParseEntity(  
            emptySet()
            ResizeResponse::fromXContent,  
     * @deprecated use {@link #split(ResizeRequest, RequestOptions)}
     * @return cancellable that may be used to cancel the request
     * @param listener the listener to be notified upon request completion
     * @return cancellable that may be used to cancel the request
     * Asynchronously splits an index using the Split Index API.  
    @Deprecated
            IndicesRequestConverters::getIndex,
            emptySet()
     * @param listener          the listener to be notified upon request completion
    /**
            options,
            IndicesRequestConverters::putIndexTemplate,
    public Cancellable forceMergeAsync(  
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
            options,
            emptySet()
            options,
     */  
    ) throws IOException {  
            AcknowledgedResponse::fromXContent,  
    public Cancellable putSettingsAsync(
    /**  
    public GetIndexResponse get(GetIndexRequest getIndexRequest, RequestOptions options) throws IOException {
import org.opensearch.action.admin.indices.alias.IndicesAliasesRequest;
     */
            getSettingsRequest,
    }
        RequestOptions options,  
    /**
            GetIndexResponse::fromXContent,  
    /**
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized  
        return restHighLevelClient.performRequestAsync(
     * @throws IOException in case there is a problem sending the request or parsing back the response
     *
            ForceMergeResponse::fromXContent,  
            IndicesRequestConverters::deleteIndex,  
        return restHighLevelClient.performRequestAndParseEntity(  
    public CloseIndexResponse close(CloseIndexRequest closeIndexRequest, RequestOptions options) throws IOException {  
    public GetMappingsResponse getMapping(GetMappingsRequest getMappingsRequest, RequestOptions options) throws IOException {
        ActionListener<AcknowledgedResponse> listener
    public boolean existsAlias(GetAliasesRequest getAliasesRequest, RequestOptions options) throws IOException {
            CloseIndexResponse::fromXContent,  
    /**
        return restHighLevelClient.performRequestAndParseEntity(
     */  
    public Cancellable getDataStreamAsync(
            emptySet()
    ) {  
    /**
        );
import org.opensearch.client.indices.PutComposableIndexTemplateRequest;
     * @param options                 the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be  
            listener,  
            refreshRequest,
            GetComposableIndexTemplatesResponse::fromXContent,  
    }  
            flushRequest,  
        );  
            putIndexTemplateRequest,  
import org.opensearch.client.indices.GetFieldMappingsResponse;  
        RequestOptions options,
            options,
            options,  
            listener,
        );
            request,  
     *
            options,
            org.opensearch.action.admin.indices.shrink.ResizeResponse::fromXContent,  
        );
            resizeRequest,
     */  
        );
     * @return cancellable that may be used to cancel the request
     *
     *  
     *  
     */  
    /**  
     */
    /**
            emptySet()
        return restHighLevelClient.performRequestAsyncAndParseEntity(
     * Puts an index template using the Index Templates API.
     * Asynchronously clones an index using the Clone Index API.
            emptySet()
            deleteDataStreamRequest,  
     * @param forceMergeRequest the request
            emptySet()  
            options,
            GetSettingsResponse::fromXContent,
     *
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
     * @param options                 the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be
     * @param resizeRequest the request
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
        RequestOptions options,
        );
/*
            RestHighLevelClient::convertExistsResponse,
            options,
    public Cancellable deleteDataStreamAsync(
            IndicesRequestConverters::simulateIndexTemplate,
            listener,  
        ActionListener<AcknowledgedResponse> listener
     * Rolls over an index using the Rollover Index API.  
            options,  
        return restHighLevelClient.performRequestAndParseEntity(
            request,
            listener,
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
    /**  
import org.opensearch.action.admin.indices.cache.clear.ClearIndicesCacheRequest;  
     */
            AcknowledgedResponse::fromXContent,
        );
     */  
import org.opensearch.action.admin.indices.validate.query.ValidateQueryResponse;
            emptySet()
     *  
    public Cancellable refreshAsync(RefreshRequest refreshRequest, RequestOptions options, ActionListener<RefreshResponse> listener) {  
            options,
            CreateIndexResponse::fromXContent,
     * Opens an index using the Open Index API.
     * @return the response
     * @param clearIndicesCacheRequest the request
        );  
            validateQueryRequest,
 */  
    }
    public org.opensearch.action.admin.indices.shrink.ResizeResponse shrink(  
        );  
    public Cancellable rolloverAsync(RolloverRequest rolloverRequest, RequestOptions options, ActionListener<RolloverResponse> listener) {
            GetFieldMappingsResponse::fromXContent,
        return restHighLevelClient.performRequestAsyncAndParseEntity(  
     */
        ActionListener<ForceMergeResponse> listener
            org.opensearch.action.admin.indices.shrink.ResizeResponse::fromXContent,
            deleteIndexRequest,
        RequestOptions options,
            listener,
        );  
     * @throws IOException in case there is a problem sending the request  
        UpdateSettingsRequest updateSettingsRequest,
            options,
    ) {
        return restHighLevelClient.performRequestAndParseEntity(
            getAliasesRequest,
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized  
        return restHighLevelClient.performRequestAsyncAndParseEntity(  
     */  
     * @param listener the listener to be notified upon request completion
     * @param listener the listener to be notified upon request completion
     * @throws IOException in case there is a problem sending the request or parsing back the response
        return forcemerge(forceMergeRequest, options);
            emptySet()  
            emptySet()
     */
     * @param updateSettingsRequest the request
    }  
     * @param listener the listener to be notified upon request completion
public final class IndicesClient {
    public Cancellable analyzeAsync(AnalyzeRequest request, RequestOptions options, ActionListener<AnalyzeResponse> listener) {
        return restHighLevelClient.performRequestAndParseEntity(
    }
import org.opensearch.action.admin.indices.refresh.RefreshResponse;
        );  
     * @param resizeRequest the request
    ) {
            emptySet()
     * @return the response  
        return restHighLevelClient.performRequestAsyncAndParseEntity(
    }
     *
            emptySet()
     * @param listener the listener to be notified upon request completion
     * @return cancellable that may be used to cancel the request
        return restHighLevelClient.performRequestAsyncAndParseEntity(
    }
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
    public org.opensearch.client.core.AcknowledgedResponse deleteAlias(DeleteAliasRequest request, RequestOptions options)  
    }
import org.opensearch.action.admin.indices.forcemerge.ForceMergeResponse;  
     * Asynchronously puts an index template using the Index Templates API.
     * @param forceMergeRequest the request
        return restHighLevelClient.performRequestAsyncAndParseEntity(
            options,
            listener,
        DeleteIndexRequest deleteIndexRequest,  
    ) {
            options,  
        throws IOException {
    }  
            options,
     * @return cancellable that may be used to cancel the request
import org.opensearch.client.indices.rollover.RolloverRequest;  
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized  
    }  
    }
        );  
            emptySet()
     * Validate a potentially expensive query without executing it.  
    ) {
     * @param refreshRequest the request
    public Cancellable splitAsync(
     *  
        );  
        org.opensearch.action.admin.indices.shrink.ResizeRequest resizeRequest,
        ActionListener<org.opensearch.action.admin.indices.shrink.ResizeResponse> listener
    }
        );  
            options,  
     * @param listener the listener to be notified upon request completion
    }  
        ActionListener<GetSettingsResponse> listener
            indicesAliasesRequest,  
     */  
        RequestOptions options,  
        return restHighLevelClient.performRequestAsyncAndParseEntity(  
        RequestOptions options,  
            options,  
        return restHighLevelClient.performRequestAsync(  
        ActionListener<GetIndexTemplatesResponse> listener  
     * Clears the cache of one or more indices using the Clear Cache API.
     * @throws IOException in case there is a problem sending the request or parsing back the response
    /**
        throws IOException {  
            emptySet()
            refreshRequest,
    }
     *                                customized  
        RequestOptions options,  
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized  
            IndicesRequestConverters::getSettings,  
     * @param putIndexTemplateRequest the request
            Collections.emptySet()
            IndicesRequestConverters::createIndex,
            AnalyzeResponse::fromXContent,
     * @param flushRequest the request
    }  
     * @throws IOException in case there is a problem sending the request
        RequestOptions options,
import org.opensearch.action.admin.indices.refresh.RefreshRequest;  
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized  
        RequestOptions options,
    /**
     *
     *
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
     * @param createDataStreamRequest the request
            emptySet()  
            IndicesRequestConverters::getFieldMapping,
     * @param createIndexRequest the request
     * @return the response
            options,  
    public ForceMergeResponse forcemerge(ForceMergeRequest forceMergeRequest, RequestOptions options) throws IOException {
     * Retrieves the mappings on an index or indices using the Get Mapping API.  
        );  
     * @throws IOException in case there is a problem sending the request or parsing back the response
            AcknowledgedResponse::fromXContent,
            options,  
            emptySet()  
            IndicesRequestConverters::shrink,  
     * Asynchronously delete an index template using the Index Templates API  
            emptySet()
    }
    /**
     *  
        );  
            indexTemplatesRequest,
    /**
            emptySet()  
     * @return cancellable that may be used to cancel the request
     */
    /**  
            emptySet()
            listener,
     * @param listener the listener to be notified upon request completion  
import org.opensearch.action.admin.indices.open.OpenIndexResponse;
     * @param forceMergeRequest the request
    }
        ActionListener<Boolean> listener
     *
    }  
     * Asynchronously puts an index template using the Index Templates API.
            emptySet()
        return restHighLevelClient.performRequest(  
    public Cancellable createDataStreamAsync(  
    /**
    /**
    /**  
            getFieldMappingsRequest,
            flushRequest,  
     * @param listener the listener to be notified upon request completion
     * @param resizeRequest the request
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
    }  
        return restHighLevelClient.performRequestAsyncAndParseEntity(  
     * Asynchronously flush one or more indices using the Flush API.  
     * @deprecated use {@link #cloneAsync(ResizeRequest, RequestOptions, ActionListener)}
    /**
        );
            listener,
            options,
        return restHighLevelClient.performRequestAndParseEntity(  
     */
            CreateIndexResponse::fromXContent,  
     * @throws IOException in case there is a problem sending the request or parsing back the response
        return restHighLevelClient.performRequestAndParseEntity(
            options,  
        return restHighLevelClient.performRequestAsyncAndParseEntity(  
        return restHighLevelClient.performRequestAsyncAndParseEntity(
    }  
     *
import org.opensearch.client.indices.GetComposableIndexTemplatesResponse;
     * @deprecated use {@link #shrink(ResizeRequest, RequestOptions)}  
    public AcknowledgedResponse updateAliases(IndicesAliasesRequest indicesAliasesRequest, RequestOptions options) throws IOException {  
    ) {
     * @return the response
     * @param resizeRequest the request  
     * @return the response  
            resizeRequest,
 * this file be licensed under the Apache-2.0 license or a
            AcknowledgedResponse::fromXContent,
     */
     * @param listener the listener to be notified upon request completion  
 * GitHub history for details.
     *
     *  
    /**  
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
     * @return the response
     * @return cancellable that may be used to cancel the request
    ) {
        );
     */
     * Asynchronously simulates matching index name against the existing index templates in the system.  
     */  
    public Cancellable splitAsync(ResizeRequest resizeRequest, RequestOptions options, ActionListener<ResizeResponse> listener) {
     * @return cancellable that may be used to cancel the request  
     *
    }  
 */
            AcknowledgedResponse::fromXContent,
     *
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
     * @param listener the listener to be notified upon request completion. The listener will be called with the value {@code true}
        ActionListener<AcknowledgedResponse> listener
            options,  
     * @return the response
     */
        );  
            options,  
        );
     * @return the response
    }
        );  
            options,
            RolloverResponse::fromXContent,  
    }
        return restHighLevelClient.performRequestAsyncAndParseEntity(  
            org.opensearch.client.core.AcknowledgedResponse::fromXContent,  
        return restHighLevelClient.performRequestAsyncAndParseEntity(
            listener,
import org.opensearch.client.indices.GetDataStreamResponse;
            forceMergeRequest,
     * @deprecated use {@link #shrinkAsync(ResizeRequest, RequestOptions, ActionListener)}  
            options,
    }
     * Asynchronously checks if the index (indices) exists or not.
 *
            simulateIndexTemplateRequest,
    public Cancellable getIndexTemplateAsync(  
        );  
    /**  
        RequestOptions options
import org.opensearch.action.admin.indices.alias.get.GetAliasesRequest;
            ForceMergeResponse::fromXContent,
     * @throws IOException in case there is a problem sending the request or parsing back the response  
     * Asynchronously retrieves the mappings on an index on indices using the Get Mapping API.  
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized  
    /**
    /**
            org.opensearch.action.admin.indices.shrink.ResizeResponse::fromXContent,  
import org.opensearch.client.indices.GetMappingsResponse;  
     * @param listener the listener to be notified upon request completion
    }
    public Cancellable clearCacheAsync(
     *
import org.opensearch.action.admin.indices.flush.FlushResponse;
            rolloverRequest,  
        );
            options,
 * specific language governing permissions and limitations
            closeIndexRequest,  
            listener,  
    public Cancellable getIndexTemplateAsync(  
        );
     * @param createDataStreamRequest the request  
        );
            options,
     *
            getIndexTemplatesRequest,  
        );
    /**
     * Asynchronously updates specific index level settings using the Update Indices Settings API.  
        GetSettingsRequest getSettingsRequest,  
     * @return cancellable that may be used to cancel the request
     * @throws IOException in case there is a problem sending the request or parsing back the response  
            emptySet()
    }
    public Cancellable existsIndexTemplateAsync(
            SimulateIndexTemplateResponse::fromXContent,  
        );
        );  
            AcknowledgedResponse::fromXContent,  
     * Asynchronously creates a data stream using the Create Data Stream API.
            IndicesRequestConverters::existsAlias,
            IndicesRequestConverters::clone,
    ) {  
     * @throws IOException in case there is a problem sending the request or parsing back the response  
            IndicesRequestConverters::getTemplates,  
            getAliasesRequest,
            IndicesRequestConverters::openIndex,
            dataStreamRequest,
    /**
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
        RequestOptions options,  
        throws IOException {
     */
     *
     * @throws IOException in case there is a problem sending the request or parsing back the response
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized  
            IndicesRequestConverters::indexPutSettings,
        throws IOException {
     *
     * @return cancellable that may be used to cancel the request
            listener,  
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
     * @param listener                the listener to be notified upon request completion  
            ValidateQueryResponse::fromXContent,
     * Asynchronously delete an index template using the Index Templates API
            options,  
        SimulateIndexTemplateRequest simulateIndexTemplateRequest,
import org.opensearch.client.indices.CreateIndexResponse;
            createDataStreamRequest,
     * @param request the request
    }
     *  
    public Cancellable existsTemplateAsync(
            IndicesRequestConverters::indicesExist,  
            options,
     */  
            IndicesRequestConverters::clone,  
     */
     *
     * @return cancellable that may be used to cancel the request
            listener,
    }  
     * @param clearIndicesCacheRequest the request
        );
        return restHighLevelClient.performRequestAsyncAndParseEntity(  
     * Synchronously calls the delete alias api
     * @param listener the listener to be notified upon request completion  
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized  
            getAliasesRequest,
            options,  
    public Cancellable forcemergeAsync(
     * @param resizeRequest the request
            resizeRequest,  
            IndicesRequestConverters::validateQuery,
     * Asynchronously retrieves the field mappings on an index or indices using the Get Field Mapping API.  
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
     * Splits an index using the Split Index API.
     * @throws IOException in case there is a problem sending the request or parsing back the response  
            RefreshResponse::fromXContent,
     * Asynchronously deletes an index using the Delete Index API.
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
    public AcknowledgedResponse createDataStream(CreateDataStreamRequest createDataStreamRequest, RequestOptions options)
            emptySet()  
    /**
import org.opensearch.action.admin.indices.template.delete.DeleteIndexTemplateRequest;
        RequestOptions options,
     * @throws IOException in case there is a problem sending the request or parsing back the response
            AcknowledgedResponse::fromXContent,
     *                                     customized
     */  
            IndicesRequestConverters::templatesExist,  
    }
     * @return the response
            emptySet()  
        );
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
            listener,
import org.opensearch.client.indices.ComposableIndexTemplateExistRequest;
    /**
     * @return cancellable that may be used to cancel the request  
     *  
    /**
     *
            options,
import org.opensearch.client.indices.ResizeResponse;  
    public ForceMergeResponse forceMerge(ForceMergeRequest forceMergeRequest, RequestOptions options) throws IOException {
            GetIndexResponse::fromXContent,  
        GetDataStreamRequest dataStreamRequest,
     * @return cancellable that may be used to cancel the request
import static java.util.Collections.singleton;  
            ValidateQueryResponse::fromXContent,  
 * software distributed under the License is distributed on an
        DeleteAliasRequest request,
     *
     * @param getIndexTemplatesRequest the request
    ) {
            getFieldMappingsRequest,  
     * @param getAliasesRequest the request  
            emptySet()
            options,
            IndicesRequestConverters::deleteDataStream,  
        RequestOptions options,
    public RolloverResponse rollover(RolloverRequest rolloverRequest, RequestOptions options) throws IOException {
        );
            options,
     * @param simulateIndexTemplateRequest the request
    public GetSettingsResponse getSettings(GetSettingsRequest getSettingsRequest, RequestOptions options) throws IOException {
        ActionListener<CreateIndexResponse> listener
     * Shrinks an index using the Shrink Index API.  
    public boolean existsTemplate(IndexTemplatesExistRequest indexTemplatesRequest, RequestOptions options) throws IOException {
            DataStreamsStatsResponse::fromXContent,  
     * @param listener the listener to be notified upon request completion
        return restHighLevelClient.performRequestAndParseEntity(
     */
            emptySet()
            options,
     * Deletes an index using the Delete Index API.
    ) throws IOException {
            request,  
            options,
        );  
            listener,
    public Cancellable deleteIndexTemplateAsync(
        return restHighLevelClient.performRequestAsyncAndParseEntity(
     * @param getIndexRequest the request
            resizeRequest,
            listener,  
    }
            emptySet()
    }  
        return restHighLevelClient.performRequestAndParseEntity(  
 * under the License.  
            IndicesRequestConverters::openIndex,
        );
        return restHighLevelClient.performRequestAsyncAndParseEntity(
            IndicesRequestConverters::updateAliases,
     * @param options                      the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be  
 * license agreements. See the NOTICE file distributed with
     * @param indexTemplatesRequest the request  
            AcknowledgedResponse::fromXContent,  
    ) throws IOException {  
    }
     * @return the response
            createDataStreamRequest,  
            org.opensearch.client.core.AcknowledgedResponse::fromXContent,  
            options,
    ) {
    ) {
        );
    }
            closeIndexRequest,
            IndicesRequestConverters::deleteDataStream,
     * Calls the analyze API  
    ) {  
     * @param putIndexTemplateRequest the request
     * @param request  the request
     *  
     * @return cancellable that may be used to cancel the request  
            IndicesRequestConverters::existsAlias,
     * @return cancellable that may be used to cancel the request
            simulateIndexTemplateRequest,  
            options,
package org.opensearch.client;
     * @param options  the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
        return restHighLevelClient.performRequestAndParseEntity(
     * @return true if any index templates in the request exist, false otherwise
        DeleteIndexTemplateRequest request,  
     * @param resizeRequest the request
        );
            IndicesRequestConverters::forceMerge,
    /**
            resizeRequest,  
            createIndexRequest,
    /**  
import org.opensearch.action.admin.indices.flush.FlushRequest;  
     */
            putIndexTemplateRequest,
     *
            RestHighLevelClient::convertExistsResponse,
        throws IOException {  
    ) {
        return restHighLevelClient.performRequestAsyncAndParseEntity(  
    public FlushResponse flush(FlushRequest flushRequest, RequestOptions options) throws IOException {
        ActionListener<org.opensearch.action.admin.indices.shrink.ResizeResponse> listener
     *
            IndicesRequestConverters::putMapping,
     * @param listener the listener to be notified upon request completion  
    public Cancellable getFieldMappingAsync(
            listener,
    ) {  
     * @param indexTemplatesRequest the request
    public OpenIndexResponse open(OpenIndexRequest openIndexRequest, RequestOptions options) throws IOException {
     * Asynchronously closes an index using the Close Index API.
     */  
 * compatible open source license.
            options,
            emptySet()
     * @param simulateIndexTemplateRequest the request
     *  
    /**
        return restHighLevelClient.performRequest(  
import org.opensearch.client.indices.DataStreamsStatsResponse;  
            request,
        );
 * ownership. Elasticsearch licenses this file to you under  
     * Asynchronously shrinks an index using the Shrink index API.  
import org.opensearch.action.admin.indices.forcemerge.ForceMergeRequest;
     * @return cancellable that may be used to cancel the request  
            IndicesRequestConverters::split,
     * @param options                 the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be
        throws IOException {
import org.opensearch.client.indices.GetMappingsRequest;
        return restHighLevelClient.performRequestAsyncAndParseEntity(
        RequestOptions options,  
            emptySet()  
            resizeRequest,
    }  
     * Flush one or more indices using the Flush API.  
     * @param listener the listener to be notified upon request completion  
import org.opensearch.client.indices.CreateDataStreamRequest;
    }
    /**
            IndicesRequestConverters::forceMerge,
     * @return the response
            IndicesRequestConverters::validateQuery,
import org.opensearch.client.indices.SimulateIndexTemplateResponse;
     */
     *
            IndicesRequestConverters::clearCache,
        return restHighLevelClient.performRequestAsyncAndParseEntity(
     * Asynchronously calls the delete alias api  
            AcknowledgedResponse::fromXContent,  
            request,
import org.opensearch.action.admin.indices.settings.put.UpdateSettingsRequest;
     * @throws IOException in case there is a problem sending the request or parsing back the response  
     * @param options  the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized  
     * @return the response
     * @param deleteDataStreamRequest the request  
        );
            putMappingRequest,
            getIndexRequest,  
    }
            emptySet()
     * Asynchronously clones an index using the Clone Index API.
            resizeRequest,
     *
    /**
     * @throws IOException in case there is a problem sending the request or parsing back the response
            emptySet()
    }  
        return restHighLevelClient.performRequestAsyncAndParseEntity(
            RestHighLevelClient::convertExistsResponse,
        ValidateQueryRequest validateQueryRequest,
    public GetFieldMappingsResponse getFieldMapping(GetFieldMappingsRequest getFieldMappingsRequest, RequestOptions options)  
     */
            request,
     */  
        );
            emptySet()
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized  
     */  
import org.opensearch.action.admin.indices.validate.query.ValidateQueryRequest;  
        );  
            RestHighLevelClient::convertExistsResponse,
        );
    public ClearIndicesCacheResponse clearCache(ClearIndicesCacheRequest clearIndicesCacheRequest, RequestOptions options)  
     * @param request the request
        org.opensearch.action.admin.indices.shrink.ResizeRequest resizeRequest,
     *
     * @return the response
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized  
            listener,
            putIndexTemplateRequest,  
            listener,
    public AcknowledgedResponse deleteIndexTemplate(DeleteComposableIndexTemplateRequest request, RequestOptions options)  
    }
            IndicesRequestConverters::getDataStreams,
        ActionListener<AcknowledgedResponse> listener
            emptySet()
            options,
     * Retrieves the field mappings on an index or indices using the Get Field Mapping API.
     * Asynchronously creates an index using the Create Index API.  
     * @param getSettingsRequest the request  
    }
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
     *  
     */
     * @return cancellable that may be used to cancel the request
        RequestOptions options
     * @param listener the listener to be notified upon request completion  
            getIndexRequest,  
            listener,
    /**  
    /**
     */
            resizeRequest,  
        RequestOptions options,  
    ) {
    public DataStreamsStatsResponse dataStreamsStats(DataStreamsStatsRequest dataStreamsStatsRequest, RequestOptions options)
     * @param listener the listener to be notified upon request completion. The listener will be called with the value {@code true}
            org.opensearch.action.admin.indices.shrink.ResizeResponse::fromXContent,
            RefreshResponse::fromXContent,
     *
    public Cancellable existsAsync(GetIndexRequest request, RequestOptions options, ActionListener<Boolean> listener) {  
            GetSettingsResponse::fromXContent,
            SimulateIndexTemplateResponse::fromXContent,
        );
     * @return the response
        return restHighLevelClient.performRequestAsyncAndParseEntity(
     * @throws IOException in case there is a problem sending the request or parsing back the response
    ) {
            listener,  
    }  
 * Licensed to Elasticsearch under one or more contributor  
     * Shrinks an index using the Shrink Index API.  
     * @return the response  
 *    http://www.apache.org/licenses/LICENSE-2.0
     * @param refreshRequest the request
     * @return the response  
        RequestOptions options,  
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized  
     *                                customized  
/**
    public Cancellable createAsync(
    /**
        );  
    }  
     * @param indexTemplatesExistRequest the request
            options,  
            AcknowledgedResponse::fromXContent,
import java.util.Collections;  
            emptySet()  
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
    /**
     */
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
        return restHighLevelClient.performRequestAndParseEntity(
            GetIndexTemplatesResponse::fromXContent,  
     * @throws IOException in case there is a problem sending the request or parsing back the response
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized  
     * Asynchronously checks if one or more aliases exist using the Aliases Exist API.
            resizeRequest,
            emptySet()
    }
            emptySet()  
import org.opensearch.client.indices.GetIndexRequest;
    public GetComposableIndexTemplatesResponse getIndexTemplate(  
    }
        );  
     * @throws IOException in case there is a problem sending the request or parsing back the response
import org.opensearch.client.indices.DeleteDataStreamRequest;  
            options,
