        Request request = new Request(HttpPut.METHOD_NAME, endpoint);  
        parameters.withIndicesOptions(forceMergeRequest.indicesOptions());
        return request;  
        return request;  
    }
        return request;
import org.opensearch.client.indices.GetIndexTemplatesRequest;
        final Request request = new Request(HttpHead.METHOD_NAME, endpoint);
        request.setEntity(RequestConverters.createEntity(updateSettingsRequest, RequestConverters.REQUEST_BODY_CONTENT_TYPE));
import org.opensearch.action.admin.indices.template.delete.DeleteIndexTemplateRequest;
        parameters.withPreserveExisting(updateSettingsRequest.isPreserveExisting());
        final String endpoint = new RequestConverters.EndpointBuilder().addPathPartAsIs("_template")
 * software distributed under the License is distributed on an
        return request;
    }
        request.addParameters(parameters.asMap());
        RequestConverters.Params parameters = new RequestConverters.Params();
    }  
        parameters.withClusterManagerTimeout(deleteAliasRequest.clusterManagerNodeTimeout());
        String endpoint = RequestConverters.endpoint(indices, "_settings", names);
import org.opensearch.client.indices.ResizeRequest;
        parameters.putParam("fields", String.join(",", clearIndicesCacheRequest.fields()));
        }
        String[] indices = getAliasesRequest.indices() == null ? Strings.EMPTY_ARRAY : getAliasesRequest.indices();
        request.addParameters(parameters.asMap());
import org.opensearch.client.indices.GetMappingsRequest;  
        return request;
import org.opensearch.action.admin.indices.settings.get.GetSettingsRequest;
        Request request = new Request(HttpPost.METHOD_NAME, endpoint);
        String endpoint = RequestConverters.endpoint(indices, "_alias", aliases);  
        return request;  
 * not use this file except in compliance with the License.
        String name = deleteDataStreamRequest.getName();  
 * GitHub history for details.
 * this work for additional information regarding copyright
        Request request = new Request(HttpGet.METHOD_NAME, endpoint);
        params.withWaitForActiveShards(resizeRequest.getWaitForActiveShards());  
    }  
    static Request deleteIndex(DeleteIndexRequest deleteIndexRequest) {
        params.withLocal(getIndexTemplatesRequest.isLocal());  
        request.addParameters(parameters.asMap());  
        builder.addPathPartAsIs("_analyze");  
        RequestConverters.Params params = new RequestConverters.Params();
        RequestConverters.Params parameters = new RequestConverters.Params();  
import org.apache.hc.client5.http.classic.methods.HttpGet;
        RequestConverters.Params parameters = new RequestConverters.Params();
        String endpoint = RequestConverters.endpoint(indices);
        }  
        parameters.withTimeout(createIndexRequest.timeout());
        params.withClusterManagerTimeout(getIndexTemplatesRequest.getClusterManagerNodeTimeout());
    static Request updateAliases(IndicesAliasesRequest indicesAliasesRequest) throws IOException {  
 * compatible open source license.
            .addPathPart(putIndexTemplateRequest.name())
    }  
            .build();  
        parameters.withClusterManagerTimeout(deleteIndexRequest.clusterManagerNodeTimeout());
import org.opensearch.action.admin.indices.open.OpenIndexRequest;  
    static Request rollover(RolloverRequest rolloverRequest) throws IOException {
        RequestConverters.Params parameters = new RequestConverters.Params();
            params.putParam("dry_run", Boolean.TRUE.toString());
        request.addParameters(params.asMap());  
        params.withIndicesOptions(validateQueryRequest.indicesOptions());  
    }
            .build();  
                params.putParam("cause", putComposableIndexTemplateRequest.cause());  
        return request;
import org.opensearch.client.indices.DeleteAliasRequest;
        RequestConverters.Params parameters = new RequestConverters.Params();
        RequestConverters.Params parameters = new RequestConverters.Params();  
import org.opensearch.client.indices.GetFieldMappingsRequest;  
    }
        RequestConverters.Params parameters = new RequestConverters.Params();  
            }
        RequestConverters.Params parameters = new RequestConverters.Params();  
        RequestConverters.Params params = new RequestConverters.Params();  
        parameters.withTimeout(deleteAliasRequest.timeout());  
        return request;  
        params.withWaitForActiveShards(rolloverRequest.getCreateIndexRequest().waitForActiveShards());  
        if (resizeRequest.getResizeType() != ResizeType.SHRINK) {
    }
        parameters.putParam("wait_if_ongoing", Boolean.toString(flushRequest.waitIfOngoing()));
    }
        request.addParameters(params.asMap());  
            params.putParam("create", Boolean.TRUE.toString());
        params.withLocal(indexTemplatesExistRequest.isLocal());  
        parameters.withIndicesOptions(updateSettingsRequest.indicesOptions());
        final RequestConverters.Params params = new RequestConverters.Params();
 *
        parameters.withTimeout(putMappingRequest.timeout());  
        params.withClusterManagerTimeout(deleteIndexTemplateRequest.clusterManagerNodeTimeout());
        String[] indices = refreshRequest.indices() == null ? Strings.EMPTY_ARRAY : refreshRequest.indices();
        return resize(resizeRequest);
        final String endpoint = new RequestConverters.EndpointBuilder().addPathPartAsIs("_index_template")
    static Request clearCache(ClearIndicesCacheRequest clearIndicesCacheRequest) {  
        final RequestConverters.Params params = new RequestConverters.Params();
        }
        String endpoint = RequestConverters.endpoint(closeIndexRequest.indices(), "_close");  
/*  
 * the Apache License, Version 2.0 (the "License"); you may
        final String endpoint = new RequestConverters.EndpointBuilder().addPathPartAsIs("_index_template")
        if (getIndexRequest.indices() == null || getIndexRequest.indices().length == 0) {  
        return request;
        request.addParameters(params.asMap());
        parameters.putParam("fielddata", Boolean.toString(clearIndicesCacheRequest.fieldDataCache()));
            .build();
        }
        return request;
    static Request getTemplates(GetIndexTemplatesRequest getIndexTemplatesRequest) {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        String endpoint = new RequestConverters.EndpointBuilder().addPathPartAsIs("_template")  
    @Deprecated  
        parameters.withWaitForActiveShards(openIndexRequest.waitForActiveShards());
    static Request flush(FlushRequest flushRequest) {
    }
    static Request split(ResizeRequest resizeRequest) throws IOException {
        if (IndexMetadata.INDEX_NUMBER_OF_SHARDS_SETTING.exists(resizeRequest.getSettings()) == false) {  
        request.addParameters(params.asMap());  
        return resize(resizeRequest, ResizeType.SPLIT);  
        params.withIndicesOptions(getAliasesRequest.indicesOptions());  
            .addPathPart(getIndexTemplatesRequest.name())
        params.withClusterManagerTimeout(indexTemplatesExistRequest.getClusterManagerNodeTimeout());
        String[] expressions = dataStreamsStatsRequest.indices() == null ? Strings.EMPTY_ARRAY : dataStreamsStatsRequest.indices();
    static Request putDataStream(CreateDataStreamRequest createDataStreamRequest) {  
        request.addParameters(parameters.asMap());
        parameters.putParam("query", Boolean.toString(clearIndicesCacheRequest.queryCache()));  
        return request;
        final String endpoint = new RequestConverters.EndpointBuilder().addPathPartAsIs("_template")
    }
    }
import org.opensearch.client.indices.rollover.RolloverRequest;
    }
        params.withIncludeDefaults(getIndexRequest.includeDefaults());
    }
 * license agreements. See the NOTICE file distributed with
        }
 */  
        params.withClusterManagerTimeout(deleteIndexTemplateRequest.clusterManagerNodeTimeout());  
                RequestConverters.createEntity(putComposableIndexTemplateRequest, RequestConverters.REQUEST_BODY_CONTENT_TYPE)  
    }  
        Request request = new Request(HttpPost.METHOD_NAME, RequestConverters.endpoint(indices, "_flush"));
 * specific language governing permissions and limitations
        Request request = new Request(HttpDelete.METHOD_NAME, endpoint);  
import org.opensearch.action.admin.indices.cache.clear.ClearIndicesCacheRequest;
    static Request shrink(org.opensearch.action.admin.indices.shrink.ResizeRequest resizeRequest) throws IOException {
    static Request deleteAlias(DeleteAliasRequest deleteAliasRequest) {
            throw new IllegalArgumentException("Wrong resize type [" + resizeRequest.getResizeType() + "] for indices split request");  
    static Request getSettings(GetSettingsRequest getSettingsRequest) {  
        request.addParameters(parameters.asMap());
        return request;
        final String endpoint = new RequestConverters.EndpointBuilder().addPathPartAsIs("_data_stream")  
        if (resizeRequest.getResizeType() != ResizeType.CLONE) {
        parameters.withIncludeDefaults(getFieldMappingsRequest.includeDefaults());
    static Request getIndexTemplates(GetComposableIndexTemplateRequest getIndexTemplatesRequest) {  
            .addPathPartAsIs("field")  
        RequestConverters.Params params = new RequestConverters.Params();
        return request;  
        request.addParameters(params.asMap());
        return request;  
        params.withClusterManagerTimeout(putIndexTemplateRequest.clusterManagerNodeTimeout());
                params.putParam("create", Boolean.TRUE.toString());  
            .addPathPart(indexTemplatesExistRequest.name())
        params.withLocal(getIndexRequest.local());
    }  
        String endpoint = RequestConverters.endpoint(indices, "_validate/query");  
        final RequestConverters.Params params = new RequestConverters.Params();
}
    private static Request resize(ResizeRequest resizeRequest, ResizeType type) throws IOException {
        String endpoint = new RequestConverters.EndpointBuilder().addPathPartAsIs("_template").addPathPart(name).build();
            throw new IllegalArgumentException("indices are mandatory");
        }
        return resize(resizeRequest, ResizeType.SHRINK);  
    static Request forceMerge(ForceMergeRequest forceMergeRequest) {
        request.addParameters(params.asMap());  
        Request request = new Request(HttpDelete.METHOD_NAME, endpoint);
    static Request templatesExist(IndexTemplatesExistRequest indexTemplatesExistRequest) {  
        }
    private IndicesRequestConverters() {}
        String endpoint = new RequestConverters.EndpointBuilder().addPathPart(createIndexRequest.index()).build();  
        String[] indices = getMappingsRequest.indices() == null ? Strings.EMPTY_ARRAY : getMappingsRequest.indices();  
        String name = deleteIndexTemplateRequest.getName();
        request.addParameters(parameters.asMap());
 */  
    }  
        Request request = new Request(HttpPost.METHOD_NAME, endpoint);  
        request.setEntity(RequestConverters.createEntity(validateQueryRequest, RequestConverters.REQUEST_BODY_CONTENT_TYPE));
        String[] indices = validateQueryRequest.indices() == null ? Strings.EMPTY_ARRAY : validateQueryRequest.indices();
 * You may obtain a copy of the License at  
        RequestConverters.Params params = new RequestConverters.Params();
        params.withLocal(getSettingsRequest.local());  
        params.withTimeout(resizeRequest.timeout());
            .build();
        return request;  
        final Request request = new Request(HttpHead.METHOD_NAME, endpoint);
    }
            .addCommaSeparatedPathParts(fields)
        RequestConverters.Params parameters = new RequestConverters.Params();
        String[] indices = flushRequest.indices() == null ? Strings.EMPTY_ARRAY : flushRequest.indices();  
            );
import org.opensearch.client.indices.IndexTemplatesExistRequest;
            builder.addPathPart(index);
 * KIND, either express or implied.  See the License for the
import org.opensearch.client.indices.AnalyzeRequest;
    }
        request.setEntity(RequestConverters.createEntity(putIndexTemplateRequest, RequestConverters.REQUEST_BODY_CONTENT_TYPE));
        Request request = new Request(HttpPut.METHOD_NAME, endpoint);
        Request request = new Request(HttpDelete.METHOD_NAME, endpoint);  
        Request request = new Request(HttpDelete.METHOD_NAME, endpoint);
        String name = deleteIndexTemplateRequest.name();
        request.setEntity(RequestConverters.createEntity(resizeRequest, RequestConverters.REQUEST_BODY_CONTENT_TYPE));
    }  
        if (Strings.hasText(putIndexTemplateRequest.cause())) {  
        request.addParameters(params.asMap());
        parameters.putParam("force", Boolean.toString(flushRequest.force()));  
import org.opensearch.action.admin.indices.forcemerge.ForceMergeRequest;
    static Request deleteIndexTemplate(DeleteComposableIndexTemplateRequest deleteIndexTemplateRequest) {
import org.opensearch.cluster.metadata.IndexMetadata;
        String[] indices = getFieldMappingsRequest.indices() == null ? Strings.EMPTY_ARRAY : getFieldMappingsRequest.indices();
import org.opensearch.client.indices.DeleteComposableIndexTemplateRequest;
        return new Request(HttpGet.METHOD_NAME, endpoint);
        RequestConverters.Params parameters = new RequestConverters.Params();  
        parameters.withIndicesOptions(deleteIndexRequest.indicesOptions());
        Request request = new Request(HttpPut.METHOD_NAME, endpoint);
        String[] indices = getAliasesRequest.indices() == null ? Strings.EMPTY_ARRAY : getAliasesRequest.indices();
        if (rolloverRequest.isDryRun()) {
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.client.indices.GetIndexRequest;
        request.addParameters(parameters.asMap());
        params.withClusterManagerTimeout(resizeRequest.clusterManagerNodeTimeout());
        request.setEntity(RequestConverters.createEntity(indicesAliasesRequest, RequestConverters.REQUEST_BODY_CONTENT_TYPE));
            .addPathPart(resizeRequest.getTargetIndex())
        Request request = new Request(HttpGet.METHOD_NAME, endpoint);
    }
    static Request openIndex(OpenIndexRequest openIndexRequest) {
        request.setEntity(RequestConverters.createEntity(putIndexTemplateRequest, RequestConverters.REQUEST_BODY_CONTENT_TYPE));
        params.withLocal(getAliasesRequest.local());  
    }  
        RequestConverters.Params params = new RequestConverters.Params();
        request.addParameters(parameters.asMap());  
        params.putParam("explain", Boolean.toString(validateQueryRequest.explain()));
        Request request = new Request(HttpPost.METHOD_NAME, "/_aliases");
        String endpoint = RequestConverters.endpoint(openIndexRequest.indices(), "_open");
/*
        String[] indices = getSettingsRequest.indices() == null ? Strings.EMPTY_ARRAY : getSettingsRequest.indices();
            throw new IllegalArgumentException("Wrong resize type [" + resizeRequest.getResizeType() + "] for indices clone request");  
            .addPathPartAsIs("_stats")
        return request;  
        }
package org.opensearch.client;
    static Request clone(org.opensearch.action.admin.indices.shrink.ResizeRequest resizeRequest) throws IOException {
        RequestConverters.Params parameters = new RequestConverters.Params();
            .build();
        final Request request = new Request(HttpGet.METHOD_NAME, endpoint);
        RequestConverters.Params params = new RequestConverters.Params();
            .build();  
    private static Request resize(org.opensearch.action.admin.indices.shrink.ResizeRequest resizeRequest) throws IOException {
        request.addParameters(params.asMap());
 * Licensed to Elasticsearch under one or more contributor  
 *  
            .addPathPartAsIs("_mapping")
    }  
    }  
            && (getAliasesRequest.aliases() == null || getAliasesRequest.aliases().length == 0)) {
        return request;  
        params.withIncludeDefaults(getIndexRequest.includeDefaults());
            .build();
    static Request getMappings(GetMappingsRequest getMappingsRequest) {
    static Request split(org.opensearch.action.admin.indices.shrink.ResizeRequest resizeRequest) throws IOException {
    static Request templatesExist(ComposableIndexTemplateExistRequest indexTemplatesExistRequest) {  
        parameters.withIndicesOptions(getFieldMappingsRequest.indicesOptions());
import org.apache.hc.client5.http.classic.methods.HttpDelete;
    }  
        RequestConverters.Params params = new RequestConverters.Params();
        request.addParameters(params.asMap());
import org.opensearch.client.indices.PutIndexTemplateRequest;  
        params.withClusterManagerTimeout(indexTemplatesExistRequest.getClusterManagerNodeTimeout());
        parameters.withIndicesOptions(getMappingsRequest.indicesOptions());  
        return resize(resizeRequest);
            params.putParam("cause", putIndexTemplateRequest.cause());
        request.addParameters(parameters.asMap());  
import org.opensearch.client.indices.DataStreamsStatsRequest;  
        request.setEntity(RequestConverters.createEntity(resizeRequest, RequestConverters.REQUEST_BODY_CONTENT_TYPE));
            .addPathPart(createDataStreamRequest.getName())
        request.addParameters(parameters.asMap());  
        String[] indices = getIndexRequest.indices() == null ? Strings.EMPTY_ARRAY : getIndexRequest.indices();
    }  
    static Request indexPutSettings(UpdateSettingsRequest updateSettingsRequest) throws IOException {  
        return resize(resizeRequest);
        String[] names = getSettingsRequest.names() == null ? Strings.EMPTY_ARRAY : getSettingsRequest.names();
        return request;
        RequestConverters.Params parameters = new RequestConverters.Params();
        request.addParameters(params.asMap());
        Request request = new Request(HttpPost.METHOD_NAME, RequestConverters.endpoint(indices, "_cache/clear"));
        return request;  
    }
        parameters.withTimeout(deleteIndexRequest.timeout());  
import org.opensearch.client.indices.GetComposableIndexTemplateRequest;
        params.withLocal(getAliasesRequest.local());
            .addPathPart(rolloverRequest.getNewIndexName())
        RequestConverters.Params params = new RequestConverters.Params();  
    static Request validateQuery(ValidateQueryRequest validateQueryRequest) throws IOException {
    }  
        return req;  
        params.withIndicesOptions(getAliasesRequest.indicesOptions());
        request.addParameters(parameters.asMap());
        params.withClusterManagerTimeout(rolloverRequest.clusterManagerNodeTimeout());
        parameters.withClusterManagerTimeout(putMappingRequest.clusterManagerNodeTimeout());
    }
        String endpoint = RequestConverters.endpoint(getIndexRequest.indices(), "");  
        String endpoint = new RequestConverters.EndpointBuilder().addPathPart(resizeRequest.getSourceIndex())  
        Request request = new Request(HttpGet.METHOD_NAME, endpoint);
            .addPathPart(deleteAliasRequest.getAlias())
        if (putIndexTemplateRequest.create()) {  
        RequestConverters.Params parameters = new RequestConverters.Params();  
    }  
import org.apache.hc.client5.http.classic.methods.HttpPut;
        String endpoint = new RequestConverters.EndpointBuilder().addPathPartAsIs("_index_template")  
        parameters.withClusterManagerTimeout(createIndexRequest.clusterManagerNodeTimeout());
        RequestConverters.Params params = new RequestConverters.Params();  
        request.addParameters(params.asMap());
import org.opensearch.client.indices.DeleteDataStreamRequest;  
            .addCommaSeparatedPathParts(expressions)
    static Request getIndex(GetIndexRequest getIndexRequest) {
        if ((getAliasesRequest.indices() == null || getAliasesRequest.indices().length == 0)
            .build();  
    static Request deleteDataStream(DeleteDataStreamRequest deleteDataStreamRequest) {
        Request request = new Request(HttpHead.METHOD_NAME, RequestConverters.endpoint(indices, "_alias", aliases));
    static Request shrink(ResizeRequest resizeRequest) throws IOException {
    static Request dataStreamsStats(DataStreamsStatsRequest dataStreamsStatsRequest) {
            params.putParam("create", Boolean.TRUE.toString());
        if (Strings.hasText(putIndexTemplateRequest.cause())) {  
            if (putComposableIndexTemplateRequest.create()) {
    static Request getFieldMapping(GetFieldMappingsRequest getFieldMappingsRequest) {  
            request.setEntity(
/*  
import org.opensearch.action.admin.indices.delete.DeleteIndexRequest;  
import org.opensearch.core.common.Strings;  
        String endpoint = new RequestConverters.EndpointBuilder().addPathPart(resizeRequest.getSourceIndex())
        parameters.withTimeout(indicesAliasesRequest.timeout());
        parameters.putParam("file", Boolean.toString(clearIndicesCacheRequest.fileCache()));
        return request;
        request.addParameters(params.asMap());  
import org.opensearch.client.indices.PutComposableIndexTemplateRequest;
        request.addParameters(params.asMap());  
        }
        String[] indices = forceMergeRequest.indices() == null ? Strings.EMPTY_ARRAY : forceMergeRequest.indices();  
 * SPDX-License-Identifier: Apache-2.0
            throw new IllegalArgumentException("index.number_of_shards is required for split operations");
        params.withClusterManagerTimeout(simulateIndexTemplateRequest.clusterManagerNodeTimeout());
import org.opensearch.action.admin.indices.refresh.RefreshRequest;
 *    http://www.apache.org/licenses/LICENSE-2.0
        request.setEntity(RequestConverters.createEntity(createIndexRequest, RequestConverters.REQUEST_BODY_CONTENT_TYPE));
        parameters.withTimeout(updateSettingsRequest.timeout());
        }
            .addPathPartAsIs("_rollover")
        parameters.withIndicesOptions(putMappingRequest.indicesOptions());
    }  
        RequestConverters.Params params = new RequestConverters.Params();
        request.addParameters(params.asMap());
 */
        PutComposableIndexTemplateRequest putComposableIndexTemplateRequest = simulateIndexTemplateRequest.indexTemplateV2Request();  
        Request request = new Request(HttpPost.METHOD_NAME, RequestConverters.endpoint(indices, "_refresh"));  
    }  
            .build();  
        return request;
        Request request = new Request(HttpPut.METHOD_NAME, endpoint);  
        parameters.withClusterManagerTimeout(indicesAliasesRequest.clusterManagerNodeTimeout());
        String endpoint = new RequestConverters.EndpointBuilder().addPathPartAsIs("_data_stream").addPathPart(name).build();
        return request;  
import org.opensearch.action.admin.indices.shrink.ResizeType;
            .build();  
        params.withTimeout(rolloverRequest.timeout());
    }
        return resize(resizeRequest, ResizeType.CLONE);  
        parameters.withTimeout(closeIndexRequest.timeout());
import org.opensearch.action.admin.indices.settings.put.UpdateSettingsRequest;  
        String endpoint = RequestConverters.endpoint(deleteIndexRequest.indices());
        parameters.putParam("only_expunge_deletes", Boolean.toString(forceMergeRequest.onlyExpungeDeletes()));  
        return request;
import org.apache.hc.client5.http.classic.methods.HttpHead;  
        request.addParameters(parameters.asMap());  
    }
            }
        Request request = new Request(HttpPut.METHOD_NAME, endpoint);  
        params.withIndicesOptions(getIndexRequest.indicesOptions());  
 * Unless required by applicable law or agreed to in writing,
        parameters.putParam("request", Boolean.toString(clearIndicesCacheRequest.requestCache()));  
import org.opensearch.client.indices.CloseIndexRequest;
        Request request = new Request(HttpPost.METHOD_NAME, endpoint);  
        String[] indices = updateSettingsRequest.indices() == null ? Strings.EMPTY_ARRAY : updateSettingsRequest.indices();
        String[] indices = clearIndicesCacheRequest.indices() == null ? Strings.EMPTY_ARRAY : clearIndicesCacheRequest.indices();
    }
        final String endpoint = new RequestConverters.EndpointBuilder().addPathPartAsIs("_data_stream")
        request.addParameters(params.asMap());
        request.addParameters(parameters.asMap());
    static Request clone(ResizeRequest resizeRequest) throws IOException {
        return request;  
        Request request = new Request(HttpGet.METHOD_NAME, RequestConverters.endpoint(indices, "_mapping"));
import org.opensearch.action.admin.indices.validate.query.ValidateQueryRequest;  
        String endpoint = new RequestConverters.EndpointBuilder().addCommaSeparatedPathParts(indices)
        final RequestConverters.Params params = new RequestConverters.Params();
        return request;
        return request;
        params.withClusterManagerTimeout(resizeRequest.clusterManagerNodeTimeout());
        return request;  
        Request request = new Request(HttpPut.METHOD_NAME, endpoint);
        if (index != null) {  
    }
        }
        params.withClusterManagerTimeout(putIndexTemplateRequest.clusterManagerNodeTimeout());
        request.addParameters(params.asMap());
            .addPathPart(simulateIndexTemplateRequest.indexName())
import org.opensearch.action.admin.indices.alias.IndicesAliasesRequest;  
        request.setEntity(RequestConverters.createEntity(rolloverRequest, RequestConverters.REQUEST_BODY_CONTENT_TYPE));
        String index = request.index();
        Request req = new Request(HttpGet.METHOD_NAME, builder.build());
        parameters.withClusterManagerTimeout(updateSettingsRequest.clusterManagerNodeTimeout());  
        parameters.withIndicesOptions(refreshRequest.indicesOptions());  
        return request;  
        parameters.withIndicesOptions(flushRequest.indicesOptions());
import org.opensearch.client.indices.PutMappingRequest;
        RequestConverters.Params parameters = new RequestConverters.Params();
 * The OpenSearch Contributors require contributions made to  
        final Request request = new Request(HttpGet.METHOD_NAME, endpoint);
            .build();  
        params.withTimeout(resizeRequest.timeout());  
import org.opensearch.client.indices.SimulateIndexTemplateRequest;  
 * Modifications Copyright OpenSearch Contributors. See
    static Request createIndex(CreateIndexRequest createIndexRequest) throws IOException {
    }
        String endpoint = new RequestConverters.EndpointBuilder().addPathPartAsIs("_data_stream")
        String endpoint = new RequestConverters.EndpointBuilder().addPathPart(rolloverRequest.getAlias())  
        params.withHuman(getIndexRequest.humanReadable());
        parameters.putParam("max_num_segments", Integer.toString(forceMergeRequest.maxNumSegments()));
            throw new IllegalArgumentException("existsAlias requires at least an alias or an index");  
        parameters.withClusterManagerTimeout(openIndexRequest.clusterManagerNodeTimeout());
        params.withIndicesOptions(getSettingsRequest.indicesOptions());
    }
            .build();
        if (putComposableIndexTemplateRequest != null) {
        String[] fields = getFieldMappingsRequest.fields() == null ? Strings.EMPTY_ARRAY : getFieldMappingsRequest.fields();
    static Request getDataStreams(GetDataStreamRequest dataStreamRequest) {  
        return new Request(HttpGet.METHOD_NAME, endpoint);
        parameters.putParam("flush", Boolean.toString(forceMergeRequest.flush()));
            .addCommaSeparatedPathParts(getIndexTemplatesRequest.names())
        return request;
        return request;
        String endpoint = new RequestConverters.EndpointBuilder().addPathPartAsIs("_index_template", "_simulate_index")  
        parameters.withIndicesOptions(clearIndicesCacheRequest.indicesOptions());
    static Request simulateIndexTemplate(SimulateIndexTemplateRequest simulateIndexTemplateRequest) throws IOException {
    @Deprecated  
        params.withClusterManagerTimeout(getIndexTemplatesRequest.getClusterManagerNodeTimeout());
    @Deprecated  
    @Deprecated  
        params.withLocal(getIndexRequest.local());  
    static Request putIndexTemplate(PutComposableIndexTemplateRequest putIndexTemplateRequest) throws IOException {
    static Request analyze(AnalyzeRequest request) throws IOException {  
        String endpoint = new RequestConverters.EndpointBuilder().addPathPart(deleteAliasRequest.getIndex())  
import java.io.IOException;
    }
        Request request = new Request(HttpDelete.METHOD_NAME, endpoint);
            .build();  
    }  
    static Request existsAlias(GetAliasesRequest getAliasesRequest) {  
            params.putParam("cause", putIndexTemplateRequest.cause());
        params.withLocal(getIndexTemplatesRequest.isLocal());  
        RequestConverters.Params params = new RequestConverters.Params();
        parameters.withLocal(getMappingsRequest.local());
        }
import org.opensearch.client.indices.CreateIndexRequest;
        return request;
        request.setEntity(RequestConverters.createEntity(putMappingRequest, RequestConverters.REQUEST_BODY_CONTENT_TYPE));
        params.withLocal(indexTemplatesExistRequest.isLocal());  
        parameters.withWaitForActiveShards(createIndexRequest.waitForActiveShards());  
import org.apache.hc.client5.http.classic.methods.HttpPost;
        request.addParameters(params.asMap());
        String[] aliases = getAliasesRequest.aliases() == null ? Strings.EMPTY_ARRAY : getAliasesRequest.aliases();
    static Request deleteTemplate(DeleteIndexTemplateRequest deleteIndexTemplateRequest) {  
        return request;  
        params.withClusterManagerTimeout(getSettingsRequest.clusterManagerNodeTimeout());
            .addCommaSeparatedPathParts(indexTemplatesExistRequest.names())
        params.putParam("all_shards", Boolean.toString(validateQueryRequest.allShards()));
    static Request getAlias(GetAliasesRequest getAliasesRequest) {  
        return request;
        RequestConverters.EndpointBuilder builder = new RequestConverters.EndpointBuilder();
        parameters.withClusterManagerTimeout(closeIndexRequest.clusterManagerNodeTimeout());
        parameters.withTimeout(openIndexRequest.timeout());  
    static Request putMapping(PutMappingRequest putMappingRequest) throws IOException {
        req.setEntity(RequestConverters.createEntity(request, RequestConverters.REQUEST_BODY_CONTENT_TYPE));
        Request request = new Request(HttpPost.METHOD_NAME, endpoint);
        if (resizeRequest.getResizeType() != ResizeType.SPLIT) {
        params.withWaitForActiveShards(resizeRequest.getTargetIndexRequest().waitForActiveShards());
        request.addParameters(params.asMap());
 * under the License.  
        request.addParameters(parameters.asMap());
            .build();  
 *
            .build();  
        params.withIndicesOptions(getIndexRequest.indicesOptions());
            .addPathPartAsIs("_" + resizeRequest.getResizeType().name().toLowerCase(Locale.ROOT))  
import org.opensearch.client.indices.ComposableIndexTemplateExistRequest;  
        }
            .addPathPart(resizeRequest.getTargetIndexRequest().index())
import org.opensearch.action.admin.indices.alias.get.GetAliasesRequest;
        Request request = new Request(HttpGet.METHOD_NAME, endpoint);
    static Request putTemplate(PutIndexTemplateRequest putIndexTemplateRequest) throws IOException {
        RequestConverters.Params params = new RequestConverters.Params();
        Request request = new Request(HttpHead.METHOD_NAME, endpoint);
        if (putIndexTemplateRequest.create()) {  
        Request request = new Request(HttpPost.METHOD_NAME, RequestConverters.endpoint(indices, "_forcemerge"));
        RequestConverters.Params params = new RequestConverters.Params();
        parameters.withIndicesOptions(openIndexRequest.indicesOptions());  
            .addPathPart(dataStreamRequest.getName())
        params.withClusterManagerTimeout(getIndexRequest.clusterManagerNodeTimeout());  
import org.opensearch.client.indices.GetDataStreamRequest;
        String endpoint = new RequestConverters.EndpointBuilder().addPathPartAsIs("_index_template").addPathPart(name).build();  
        params.withIncludeDefaults(getSettingsRequest.includeDefaults());
        parameters.withClusterManagerTimeout(getMappingsRequest.clusterManagerNodeTimeout());
            .addPathPartAsIs("_" + type.name().toLowerCase(Locale.ROOT))
    static Request indicesExist(GetIndexRequest getIndexRequest) {
final class IndicesRequestConverters {
        RequestConverters.Params params = new RequestConverters.Params();
        params.putParam("rewrite", Boolean.toString(validateQueryRequest.rewrite()));  
    static Request closeIndex(CloseIndexRequest closeIndexRequest) {
            .addPathPartAsIs("_alias")
            throw new IllegalArgumentException("Wrong resize type [" + resizeRequest.getResizeType() + "] for indices shrink request");  
            if (Strings.hasText(putComposableIndexTemplateRequest.cause())) {
        Request request = new Request(HttpPut.METHOD_NAME, RequestConverters.endpoint(indices, "_settings"));
    }
        Request request = new Request(HttpPut.METHOD_NAME, RequestConverters.endpoint(putMappingRequest.indices(), "_mapping"));  
    static Request refresh(RefreshRequest refreshRequest) {
        params.withHuman(getIndexRequest.humanReadable());
import java.util.Locale;  
        Request request = new Request(HttpGet.METHOD_NAME, endpoint);
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.action.admin.indices.flush.FlushRequest;
    }
        return request;
        String[] aliases = getAliasesRequest.aliases() == null ? Strings.EMPTY_ARRAY : getAliasesRequest.aliases();  
import org.opensearch.client.indices.CreateDataStreamRequest;
            .addPathPart(putIndexTemplateRequest.name())
    }
        parameters.withIndicesOptions(closeIndexRequest.indicesOptions());  
