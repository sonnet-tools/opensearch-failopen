            .addPathPartAsIs("_rollover")
 * Unless required by applicable law or agreed to in writing,
        parameters.withTimeout(indicesAliasesRequest.timeout());
        parameters.withTimeout(closeIndexRequest.timeout());
    }
        return request;
            .build();
            params.putParam("create", Boolean.TRUE.toString());
        return request;
        return request;
            .addPathPart(simulateIndexTemplateRequest.indexName())
        RequestConverters.Params params = new RequestConverters.Params();
        RequestConverters.Params parameters = new RequestConverters.Params();
    }
 */
        parameters.putParam("request", Boolean.toString(clearIndicesCacheRequest.requestCache()));
        request.addParameters(params.asMap());
        Request request = new Request(HttpDelete.METHOD_NAME, endpoint);
        String endpoint = RequestConverters.endpoint(indices);
        }
        RequestConverters.Params parameters = new RequestConverters.Params();
    static Request clone(ResizeRequest resizeRequest) throws IOException {
        params.withClusterManagerTimeout(getIndexTemplatesRequest.getClusterManagerNodeTimeout());
        request.addParameters(parameters.asMap());
 * this work for additional information regarding copyright
        parameters.putParam("force", Boolean.toString(flushRequest.force()));
        Request request = new Request(HttpPost.METHOD_NAME, RequestConverters.endpoint(indices, "_forcemerge"));
        return request;
    static Request putTemplate(PutIndexTemplateRequest putIndexTemplateRequest) throws IOException {
    static Request validateQuery(ValidateQueryRequest validateQueryRequest) throws IOException {
        if (resizeRequest.getResizeType() != ResizeType.SPLIT) {
    }
        request.addParameters(parameters.asMap());
                RequestConverters.createEntity(putComposableIndexTemplateRequest, RequestConverters.REQUEST_BODY_CONTENT_TYPE)
import org.opensearch.client.indices.rollover.RolloverRequest;
    static Request clearCache(ClearIndicesCacheRequest clearIndicesCacheRequest) {
        params.withClusterManagerTimeout(resizeRequest.clusterManagerNodeTimeout());
        return request;
        Request request = new Request(HttpPut.METHOD_NAME, endpoint);
        String name = deleteIndexTemplateRequest.getName();
            );
            .addPathPart(deleteAliasRequest.getAlias())
    private static Request resize(ResizeRequest resizeRequest, ResizeType type) throws IOException {
        RequestConverters.Params params = new RequestConverters.Params();
            .build();
            .addPathPart(indexTemplatesExistRequest.name())
            .build();
        parameters.withTimeout(updateSettingsRequest.timeout());
        Request request = new Request(HttpPut.METHOD_NAME, endpoint);
        }
        return request;
    @Deprecated
        request.addParameters(parameters.asMap());
import org.apache.hc.client5.http.classic.methods.HttpPut;
    }
        params.withClusterManagerTimeout(indexTemplatesExistRequest.getClusterManagerNodeTimeout());
        request.addParameters(params.asMap());
    static Request refresh(RefreshRequest refreshRequest) {
            params.putParam("cause", putIndexTemplateRequest.cause());
    }
        String index = request.index();
        String[] indices = getAliasesRequest.indices() == null ? Strings.EMPTY_ARRAY : getAliasesRequest.indices();
        parameters.withClusterManagerTimeout(createIndexRequest.clusterManagerNodeTimeout());
        params.withTimeout(resizeRequest.timeout());
        return request;
        params.withClusterManagerTimeout(putIndexTemplateRequest.clusterManagerNodeTimeout());
        request.addParameters(params.asMap());
            params.putParam("cause", putIndexTemplateRequest.cause());
            if (putComposableIndexTemplateRequest.create()) {
 * Modifications Copyright OpenSearch Contributors. See
    private static Request resize(org.opensearch.action.admin.indices.shrink.ResizeRequest resizeRequest) throws IOException {
        params.putParam("all_shards", Boolean.toString(validateQueryRequest.allShards()));
        final RequestConverters.Params params = new RequestConverters.Params();
        params.withIncludeDefaults(getIndexRequest.includeDefaults());
    }
    }
    static Request deleteIndex(DeleteIndexRequest deleteIndexRequest) {
        final Request request = new Request(HttpHead.METHOD_NAME, endpoint);
 * You may obtain a copy of the License at
}
    }
        params.withClusterManagerTimeout(indexTemplatesExistRequest.getClusterManagerNodeTimeout());
    static Request deleteTemplate(DeleteIndexTemplateRequest deleteIndexTemplateRequest) {
        }
        String[] indices = updateSettingsRequest.indices() == null ? Strings.EMPTY_ARRAY : updateSettingsRequest.indices();
 *
    }
        parameters.putParam("query", Boolean.toString(clearIndicesCacheRequest.queryCache()));
        String[] indices = getFieldMappingsRequest.indices() == null ? Strings.EMPTY_ARRAY : getFieldMappingsRequest.indices();
import org.opensearch.client.indices.CreateDataStreamRequest;
    }
    static Request openIndex(OpenIndexRequest openIndexRequest) {
 */
        request.addParameters(params.asMap());
 * The OpenSearch Contributors require contributions made to
        RequestConverters.Params params = new RequestConverters.Params();
            .addCommaSeparatedPathParts(expressions)
        return request;
import org.opensearch.client.indices.GetDataStreamRequest;
        if (Strings.hasText(putIndexTemplateRequest.cause())) {
    }
import org.opensearch.action.admin.indices.shrink.ResizeType;
        request.addParameters(params.asMap());
import org.opensearch.client.indices.PutComposableIndexTemplateRequest;
        parameters.withClusterManagerTimeout(deleteAliasRequest.clusterManagerNodeTimeout());
    }
        String name = deleteDataStreamRequest.getName();
        return resize(resizeRequest, ResizeType.SHRINK);
import org.opensearch.client.indices.AnalyzeRequest;
    }
        return resize(resizeRequest, ResizeType.CLONE);
        parameters.withIndicesOptions(refreshRequest.indicesOptions());
 * not use this file except in compliance with the License.
        if (Strings.hasText(putIndexTemplateRequest.cause())) {
    static Request getIndex(GetIndexRequest getIndexRequest) {
        request.setEntity(RequestConverters.createEntity(resizeRequest, RequestConverters.REQUEST_BODY_CONTENT_TYPE));
import org.opensearch.client.indices.IndexTemplatesExistRequest;
        return new Request(HttpGet.METHOD_NAME, endpoint);
import org.opensearch.client.indices.GetFieldMappingsRequest;
import org.opensearch.action.admin.indices.settings.get.GetSettingsRequest;
        params.withIncludeDefaults(getSettingsRequest.includeDefaults());
import org.opensearch.client.indices.GetIndexRequest;
        params.withClusterManagerTimeout(getSettingsRequest.clusterManagerNodeTimeout());
 * software distributed under the License is distributed on an
        String[] aliases = getAliasesRequest.aliases() == null ? Strings.EMPTY_ARRAY : getAliasesRequest.aliases();
        String endpoint = new RequestConverters.EndpointBuilder().addPathPartAsIs("_index_template")
        }
        String endpoint = RequestConverters.endpoint(indices, "_alias", aliases);
    }
import org.opensearch.action.admin.indices.validate.query.ValidateQueryRequest;
        String endpoint = RequestConverters.endpoint(indices, "_settings", names);
        return request;
        RequestConverters.Params parameters = new RequestConverters.Params();
        return request;
        return request;
        parameters.withIndicesOptions(updateSettingsRequest.indicesOptions());
        String endpoint = new RequestConverters.EndpointBuilder().addPathPart(resizeRequest.getSourceIndex())
        request.setEntity(RequestConverters.createEntity(indicesAliasesRequest, RequestConverters.REQUEST_BODY_CONTENT_TYPE));
    }
    static Request putIndexTemplate(PutComposableIndexTemplateRequest putIndexTemplateRequest) throws IOException {
    }
 * this file be licensed under the Apache-2.0 license or a
    static Request indexPutSettings(UpdateSettingsRequest updateSettingsRequest) throws IOException {
        parameters.putParam("only_expunge_deletes", Boolean.toString(forceMergeRequest.onlyExpungeDeletes()));
            .build();
        return request;
        String endpoint = new RequestConverters.EndpointBuilder().addPathPart(deleteAliasRequest.getIndex())
        String endpoint = new RequestConverters.EndpointBuilder().addPathPart(rolloverRequest.getAlias())
    }
        final String endpoint = new RequestConverters.EndpointBuilder().addPathPartAsIs("_data_stream")
import org.opensearch.core.common.Strings;
        Request request = new Request(HttpPost.METHOD_NAME, endpoint);
        params.putParam("rewrite", Boolean.toString(validateQueryRequest.rewrite()));
import org.opensearch.client.indices.CloseIndexRequest;
        request.addParameters(params.asMap());
    }
import org.opensearch.action.admin.indices.forcemerge.ForceMergeRequest;
        params.withWaitForActiveShards(resizeRequest.getWaitForActiveShards());
            throw new IllegalArgumentException("Wrong resize type [" + resizeRequest.getResizeType() + "] for indices shrink request");
        request.addParameters(params.asMap());
        Request request = new Request(HttpDelete.METHOD_NAME, endpoint);
        params.withLocal(indexTemplatesExistRequest.isLocal());
        request.addParameters(params.asMap());
    static Request getTemplates(GetIndexTemplatesRequest getIndexTemplatesRequest) {
            .addPathPart(resizeRequest.getTargetIndexRequest().index())
        params.withLocal(getAliasesRequest.local());
        parameters.putParam("file", Boolean.toString(clearIndicesCacheRequest.fileCache()));
        String endpoint = RequestConverters.endpoint(deleteIndexRequest.indices());
    static Request shrink(org.opensearch.action.admin.indices.shrink.ResizeRequest resizeRequest) throws IOException {
        final String endpoint = new RequestConverters.EndpointBuilder().addPathPartAsIs("_template")
    static Request putMapping(PutMappingRequest putMappingRequest) throws IOException {
        Request request = new Request(HttpPut.METHOD_NAME, RequestConverters.endpoint(putMappingRequest.indices(), "_mapping"));
            .addPathPartAsIs("_alias")
        params.withClusterManagerTimeout(simulateIndexTemplateRequest.clusterManagerNodeTimeout());
        PutComposableIndexTemplateRequest putComposableIndexTemplateRequest = simulateIndexTemplateRequest.indexTemplateV2Request();
            .addPathPart(rolloverRequest.getNewIndexName())
import org.opensearch.client.indices.GetIndexTemplatesRequest;
        parameters.withClusterManagerTimeout(deleteIndexRequest.clusterManagerNodeTimeout());
import org.opensearch.client.indices.DeleteComposableIndexTemplateRequest;
    static Request shrink(ResizeRequest resizeRequest) throws IOException {
        params.withLocal(getIndexTemplatesRequest.isLocal());
 * license agreements. See the NOTICE file distributed with
        String endpoint = new RequestConverters.EndpointBuilder().addPathPartAsIs("_data_stream")
import java.io.IOException;
        final RequestConverters.Params params = new RequestConverters.Params();
        params.withIndicesOptions(getAliasesRequest.indicesOptions());
                params.putParam("cause", putComposableIndexTemplateRequest.cause());
    }
            .build();
    }
            throw new IllegalArgumentException("index.number_of_shards is required for split operations");
import org.apache.hc.client5.http.classic.methods.HttpDelete;
        params.withClusterManagerTimeout(getIndexTemplatesRequest.getClusterManagerNodeTimeout());
        return request;
        params.withIndicesOptions(getAliasesRequest.indicesOptions());
            params.putParam("dry_run", Boolean.TRUE.toString());
        parameters.withWaitForActiveShards(createIndexRequest.waitForActiveShards());
        return request;
        parameters.withIndicesOptions(forceMergeRequest.indicesOptions());
    static Request dataStreamsStats(DataStreamsStatsRequest dataStreamsStatsRequest) {
        String[] indices = forceMergeRequest.indices() == null ? Strings.EMPTY_ARRAY : forceMergeRequest.indices();
    static Request getAlias(GetAliasesRequest getAliasesRequest) {
    static Request deleteDataStream(DeleteDataStreamRequest deleteDataStreamRequest) {
        if (getIndexRequest.indices() == null || getIndexRequest.indices().length == 0) {
    static Request flush(FlushRequest flushRequest) {
        RequestConverters.Params params = new RequestConverters.Params();
        String endpoint = RequestConverters.endpoint(openIndexRequest.indices(), "_open");
        }
        return resize(resizeRequest, ResizeType.SPLIT);
        parameters.withTimeout(deleteIndexRequest.timeout());
        return request;
    }
        params.withHuman(getIndexRequest.humanReadable());
        Request request = new Request(HttpHead.METHOD_NAME, endpoint);
            .build();
            .addCommaSeparatedPathParts(getIndexTemplatesRequest.names())
    }
        params.withTimeout(rolloverRequest.timeout());
import org.opensearch.client.indices.CreateIndexRequest;
 *
        parameters.putParam("wait_if_ongoing", Boolean.toString(flushRequest.waitIfOngoing()));
        return request;
        params.withHuman(getIndexRequest.humanReadable());
        return request;
 *
        request.setEntity(RequestConverters.createEntity(rolloverRequest, RequestConverters.REQUEST_BODY_CONTENT_TYPE));
    }
        Request request = new Request(HttpGet.METHOD_NAME, RequestConverters.endpoint(indices, "_mapping"));
import org.opensearch.client.indices.ResizeRequest;
        params.withClusterManagerTimeout(deleteIndexTemplateRequest.clusterManagerNodeTimeout());
 * under the License.
    static Request indicesExist(GetIndexRequest getIndexRequest) {
        Request request = new Request(HttpPost.METHOD_NAME, RequestConverters.endpoint(indices, "_refresh"));
        RequestConverters.EndpointBuilder builder = new RequestConverters.EndpointBuilder();
    static Request templatesExist(ComposableIndexTemplateExistRequest indexTemplatesExistRequest) {
        Request request = new Request(HttpPost.METHOD_NAME, RequestConverters.endpoint(indices, "_cache/clear"));
        final String endpoint = new RequestConverters.EndpointBuilder().addPathPartAsIs("_index_template")
        return request;
        params.withLocal(getIndexRequest.local());
        request.addParameters(params.asMap());
        return request;
        String endpoint = new RequestConverters.EndpointBuilder().addPathPartAsIs("_index_template").addPathPart(name).build();
        String[] names = getSettingsRequest.names() == null ? Strings.EMPTY_ARRAY : getSettingsRequest.names();
    }
        request.addParameters(params.asMap());
    }
        parameters.withPreserveExisting(updateSettingsRequest.isPreserveExisting());
        return request;
                params.putParam("create", Boolean.TRUE.toString());
        final RequestConverters.Params params = new RequestConverters.Params();
        RequestConverters.Params parameters = new RequestConverters.Params();
        request.addParameters(params.asMap());
    static Request rollover(RolloverRequest rolloverRequest) throws IOException {
    }
        Request request = new Request(HttpPut.METHOD_NAME, endpoint);
    @Deprecated
        Request request = new Request(HttpPost.METHOD_NAME, "/_aliases");
        parameters.withLocal(getMappingsRequest.local());
        RequestConverters.Params parameters = new RequestConverters.Params();
        return request;
        return request;
            .addPathPartAsIs("_" + resizeRequest.getResizeType().name().toLowerCase(Locale.ROOT))
import org.opensearch.cluster.metadata.IndexMetadata;
            params.putParam("create", Boolean.TRUE.toString());
        parameters.withClusterManagerTimeout(putMappingRequest.clusterManagerNodeTimeout());
        params.withLocal(getAliasesRequest.local());
        Request request = new Request(HttpPost.METHOD_NAME, endpoint);
 * Licensed to Elasticsearch under one or more contributor
        Request request = new Request(HttpPut.METHOD_NAME, endpoint);
        request.setEntity(RequestConverters.createEntity(putIndexTemplateRequest, RequestConverters.REQUEST_BODY_CONTENT_TYPE));
import org.opensearch.client.indices.SimulateIndexTemplateRequest;
    }
    }
    }
        request.addParameters(params.asMap());
        request.addParameters(parameters.asMap());
        params.withIncludeDefaults(getIndexRequest.includeDefaults());
        RequestConverters.Params parameters = new RequestConverters.Params();
        parameters.withClusterManagerTimeout(getMappingsRequest.clusterManagerNodeTimeout());
    }
        if ((getAliasesRequest.indices() == null || getAliasesRequest.indices().length == 0)
        if (IndexMetadata.INDEX_NUMBER_OF_SHARDS_SETTING.exists(resizeRequest.getSettings()) == false) {
    static Request deleteAlias(DeleteAliasRequest deleteAliasRequest) {
 * GitHub history for details.
        params.putParam("explain", Boolean.toString(validateQueryRequest.explain()));
        request.addParameters(parameters.asMap());
        RequestConverters.Params params = new RequestConverters.Params();
import java.util.Locale;
        request.setEntity(RequestConverters.createEntity(validateQueryRequest, RequestConverters.REQUEST_BODY_CONTENT_TYPE));
        request.setEntity(RequestConverters.createEntity(createIndexRequest, RequestConverters.REQUEST_BODY_CONTENT_TYPE));
        params.withIndicesOptions(validateQueryRequest.indicesOptions());
    }
        Request request = new Request(HttpPut.METHOD_NAME, endpoint);
        parameters.withClusterManagerTimeout(indicesAliasesRequest.clusterManagerNodeTimeout());
        parameters.putParam("flush", Boolean.toString(forceMergeRequest.flush()));
        return request;
import org.apache.hc.client5.http.classic.methods.HttpPost;
        String name = deleteIndexTemplateRequest.name();
        request.setEntity(RequestConverters.createEntity(putMappingRequest, RequestConverters.REQUEST_BODY_CONTENT_TYPE));
            .addPathPart(putIndexTemplateRequest.name())
        params.withWaitForActiveShards(resizeRequest.getTargetIndexRequest().waitForActiveShards());
    static Request getMappings(GetMappingsRequest getMappingsRequest) {
        params.withClusterManagerTimeout(deleteIndexTemplateRequest.clusterManagerNodeTimeout());
        return request;
        params.withClusterManagerTimeout(rolloverRequest.clusterManagerNodeTimeout());
    }
        params.withClusterManagerTimeout(getIndexRequest.clusterManagerNodeTimeout());
    }
            .addPathPartAsIs("_stats")
import org.opensearch.client.indices.GetComposableIndexTemplateRequest;
        return request;
    }
        return request;
        Request request = new Request(HttpGet.METHOD_NAME, endpoint);
            .addPathPart(putIndexTemplateRequest.name())
            .build();
        final String endpoint = new RequestConverters.EndpointBuilder().addPathPartAsIs("_template")
            .addPathPart(dataStreamRequest.getName())
    private IndicesRequestConverters() {}
        Request request = new Request(HttpDelete.METHOD_NAME, endpoint);
        String endpoint = new RequestConverters.EndpointBuilder().addPathPart(createIndexRequest.index()).build();
        request.setEntity(RequestConverters.createEntity(updateSettingsRequest, RequestConverters.REQUEST_BODY_CONTENT_TYPE));
    static Request updateAliases(IndicesAliasesRequest indicesAliasesRequest) throws IOException {
            }
            .build();
        parameters.withClusterManagerTimeout(openIndexRequest.clusterManagerNodeTimeout());
        RequestConverters.Params params = new RequestConverters.Params();
        final RequestConverters.Params params = new RequestConverters.Params();
        Request request = new Request(HttpHead.METHOD_NAME, RequestConverters.endpoint(indices, "_alias", aliases));
        request.addParameters(params.asMap());
        Request request = new Request(HttpDelete.METHOD_NAME, endpoint);
        return request;
        RequestConverters.Params parameters = new RequestConverters.Params();
        final Request request = new Request(HttpGet.METHOD_NAME, endpoint);
        return request;
    }
        }
        parameters.withIndicesOptions(putMappingRequest.indicesOptions());
        Request request = new Request(HttpPost.METHOD_NAME, RequestConverters.endpoint(indices, "_flush"));
import org.opensearch.client.indices.DeleteAliasRequest;
        request.addParameters(parameters.asMap());
        String[] indices = refreshRequest.indices() == null ? Strings.EMPTY_ARRAY : refreshRequest.indices();
            throw new IllegalArgumentException("Wrong resize type [" + resizeRequest.getResizeType() + "] for indices clone request");
import org.opensearch.action.admin.indices.alias.get.GetAliasesRequest;
        request.addParameters(params.asMap());
        params.withLocal(indexTemplatesExistRequest.isLocal());
            }
        RequestConverters.Params params = new RequestConverters.Params();
    static Request simulateIndexTemplate(SimulateIndexTemplateRequest simulateIndexTemplateRequest) throws IOException {
        params.withClusterManagerTimeout(putIndexTemplateRequest.clusterManagerNodeTimeout());
        parameters.putParam("max_num_segments", Integer.toString(forceMergeRequest.maxNumSegments()));
import org.opensearch.action.admin.indices.flush.FlushRequest;
        if (rolloverRequest.isDryRun()) {
        params.withIndicesOptions(getSettingsRequest.indicesOptions());
            .build();
        String[] indices = getIndexRequest.indices() == null ? Strings.EMPTY_ARRAY : getIndexRequest.indices();
        Request request = new Request(HttpGet.METHOD_NAME, endpoint);
        builder.addPathPartAsIs("_analyze");
            .addPathPart(resizeRequest.getTargetIndex())
        return request;
/*
        return request;
 * specific language governing permissions and limitations
        String endpoint = new RequestConverters.EndpointBuilder().addPathPartAsIs("_data_stream").addPathPart(name).build();
import org.opensearch.client.indices.GetMappingsRequest;
        req.setEntity(RequestConverters.createEntity(request, RequestConverters.REQUEST_BODY_CONTENT_TYPE));
            request.setEntity(
        }
            if (Strings.hasText(putComposableIndexTemplateRequest.cause())) {
        String endpoint = RequestConverters.endpoint(indices, "_validate/query");
        Request request = new Request(HttpGet.METHOD_NAME, endpoint);
    }
import org.opensearch.client.indices.PutMappingRequest;
        return resize(resizeRequest);
        params.withLocal(getSettingsRequest.local());
    static Request getFieldMapping(GetFieldMappingsRequest getFieldMappingsRequest) {
        request.addParameters(parameters.asMap());
        params.withLocal(getIndexTemplatesRequest.isLocal());
        return resize(resizeRequest);
            .build();
        Request request = new Request(HttpPut.METHOD_NAME, RequestConverters.endpoint(indices, "_settings"));
 * compatible open source license.
        String[] indices = flushRequest.indices() == null ? Strings.EMPTY_ARRAY : flushRequest.indices();
import org.apache.hc.client5.http.classic.methods.HttpGet;
            .addCommaSeparatedPathParts(indexTemplatesExistRequest.names())
            .addPathPartAsIs("_mapping")
            throw new IllegalArgumentException("existsAlias requires at least an alias or an index");
        String endpoint = new RequestConverters.EndpointBuilder().addPathPartAsIs("_index_template", "_simulate_index")
        request.addParameters(params.asMap());
        RequestConverters.Params params = new RequestConverters.Params();
    }
        String[] fields = getFieldMappingsRequest.fields() == null ? Strings.EMPTY_ARRAY : getFieldMappingsRequest.fields();
/*
        String endpoint = RequestConverters.endpoint(closeIndexRequest.indices(), "_close");
        params.withIndicesOptions(getIndexRequest.indicesOptions());
        RequestConverters.Params params = new RequestConverters.Params();
            .build();
            throw new IllegalArgumentException("indices are mandatory");
 * SPDX-License-Identifier: Apache-2.0
    @Deprecated
        parameters.withTimeout(putMappingRequest.timeout());
            .build();
            .build();
        parameters.withIndicesOptions(closeIndexRequest.indicesOptions());
        parameters.withIndicesOptions(getMappingsRequest.indicesOptions());
        String endpoint = new RequestConverters.EndpointBuilder().addPathPart(resizeRequest.getSourceIndex())
        parameters.withIndicesOptions(flushRequest.indicesOptions());
        String[] indices = validateQueryRequest.indices() == null ? Strings.EMPTY_ARRAY : validateQueryRequest.indices();
        String[] indices = getAliasesRequest.indices() == null ? Strings.EMPTY_ARRAY : getAliasesRequest.indices();
    static Request split(org.opensearch.action.admin.indices.shrink.ResizeRequest resizeRequest) throws IOException {
import org.opensearch.action.admin.indices.template.delete.DeleteIndexTemplateRequest;
        RequestConverters.Params parameters = new RequestConverters.Params();
/*
            .addPathPart(getIndexTemplatesRequest.name())
        return request;
        Request request = new Request(HttpPut.METHOD_NAME, endpoint);
        RequestConverters.Params parameters = new RequestConverters.Params();
        }
        if (index != null) {
        RequestConverters.Params parameters = new RequestConverters.Params();
 * KIND, either express or implied.  See the License for the
        if (putIndexTemplateRequest.create()) {
import org.opensearch.action.admin.indices.settings.put.UpdateSettingsRequest;
        if (putComposableIndexTemplateRequest != null) {
            builder.addPathPart(index);
    static Request existsAlias(GetAliasesRequest getAliasesRequest) {
        request.addParameters(params.asMap());
        String endpoint = new RequestConverters.EndpointBuilder().addCommaSeparatedPathParts(indices)
    static Request clone(org.opensearch.action.admin.indices.shrink.ResizeRequest resizeRequest) throws IOException {
    static Request closeIndex(CloseIndexRequest closeIndexRequest) {
        parameters.withWaitForActiveShards(openIndexRequest.waitForActiveShards());
        String[] indices = clearIndicesCacheRequest.indices() == null ? Strings.EMPTY_ARRAY : clearIndicesCacheRequest.indices();
        Request request = new Request(HttpGet.METHOD_NAME, endpoint);
        final Request request = new Request(HttpHead.METHOD_NAME, endpoint);
        request.setEntity(RequestConverters.createEntity(putIndexTemplateRequest, RequestConverters.REQUEST_BODY_CONTENT_TYPE));
        request.addParameters(parameters.asMap());
    static Request createIndex(CreateIndexRequest createIndexRequest) throws IOException {
import org.opensearch.action.admin.indices.open.OpenIndexRequest;
import org.opensearch.action.admin.indices.refresh.RefreshRequest;
 *    http://www.apache.org/licenses/LICENSE-2.0
        if (resizeRequest.getResizeType() != ResizeType.CLONE) {
import org.opensearch.action.admin.indices.delete.DeleteIndexRequest;
    static Request getIndexTemplates(GetComposableIndexTemplateRequest getIndexTemplatesRequest) {
        String[] indices = getSettingsRequest.indices() == null ? Strings.EMPTY_ARRAY : getSettingsRequest.indices();
import org.opensearch.action.admin.indices.alias.IndicesAliasesRequest;
import org.apache.hc.client5.http.classic.methods.HttpHead;
        params.withIndicesOptions(getIndexRequest.indicesOptions());
        request.addParameters(parameters.asMap());
        RequestConverters.Params parameters = new RequestConverters.Params();
        request.addParameters(params.asMap());
        RequestConverters.Params parameters = new RequestConverters.Params();
 * ownership. Elasticsearch licenses this file to you under
        parameters.withTimeout(deleteAliasRequest.timeout());
        parameters.withTimeout(openIndexRequest.timeout());
        RequestConverters.Params parameters = new RequestConverters.Params();
        final String endpoint = new RequestConverters.EndpointBuilder().addPathPartAsIs("_data_stream")
 * the Apache License, Version 2.0 (the "License"); you may
final class IndicesRequestConverters {
            .addPathPartAsIs("field")
        final String endpoint = new RequestConverters.EndpointBuilder().addPathPartAsIs("_index_template")
        parameters.withIndicesOptions(getFieldMappingsRequest.indicesOptions());
    static Request split(ResizeRequest resizeRequest) throws IOException {
        }
        request.addParameters(parameters.asMap());
        params.withLocal(getIndexRequest.local());
        Request request = new Request(HttpGet.METHOD_NAME, endpoint);
            throw new IllegalArgumentException("Wrong resize type [" + resizeRequest.getResizeType() + "] for indices split request");
        String endpoint = RequestConverters.endpoint(getIndexRequest.indices(), "");
        request.addParameters(params.asMap());
    }
        return resize(resizeRequest);
            .addPathPart(createDataStreamRequest.getName())
 */
            .build();
        request.addParameters(parameters.asMap());
    static Request getDataStreams(GetDataStreamRequest dataStreamRequest) {
    static Request putDataStream(CreateDataStreamRequest createDataStreamRequest) {
        parameters.withIndicesOptions(deleteIndexRequest.indicesOptions());
        final Request request = new Request(HttpGet.METHOD_NAME, endpoint);
        }
    static Request getSettings(GetSettingsRequest getSettingsRequest) {
        return req;
import org.opensearch.client.indices.DataStreamsStatsRequest;
        parameters.withIndicesOptions(openIndexRequest.indicesOptions());
        return request;
import org.opensearch.client.indices.PutIndexTemplateRequest;
        }
            .addPathPartAsIs("_" + type.name().toLowerCase(Locale.ROOT))
        return request;
        Request request = new Request(HttpDelete.METHOD_NAME, endpoint);
        String[] expressions = dataStreamsStatsRequest.indices() == null ? Strings.EMPTY_ARRAY : dataStreamsStatsRequest.indices();
        }
        if (putIndexTemplateRequest.create()) {
        RequestConverters.Params params = new RequestConverters.Params();
        RequestConverters.Params params = new RequestConverters.Params();
        params.withClusterManagerTimeout(resizeRequest.clusterManagerNodeTimeout());
        return request;
    static Request forceMerge(ForceMergeRequest forceMergeRequest) {
    static Request deleteIndexTemplate(DeleteComposableIndexTemplateRequest deleteIndexTemplateRequest) {
    }
        String[] aliases = getAliasesRequest.aliases() == null ? Strings.EMPTY_ARRAY : getAliasesRequest.aliases();
import org.opensearch.action.admin.indices.cache.clear.ClearIndicesCacheRequest;
        String endpoint = new RequestConverters.EndpointBuilder().addPathPartAsIs("_template")
import org.opensearch.client.indices.ComposableIndexTemplateExistRequest;
        parameters.withClusterManagerTimeout(closeIndexRequest.clusterManagerNodeTimeout());
            && (getAliasesRequest.aliases() == null || getAliasesRequest.aliases().length == 0)) {
        if (resizeRequest.getResizeType() != ResizeType.SHRINK) {
    }
        Request request = new Request(HttpPost.METHOD_NAME, endpoint);
        request.addParameters(parameters.asMap());
        parameters.putParam("fields", String.join(",", clearIndicesCacheRequest.fields()));
    @Deprecated
        parameters.withIncludeDefaults(getFieldMappingsRequest.includeDefaults());
        parameters.putParam("fielddata", Boolean.toString(clearIndicesCacheRequest.fieldDataCache()));
        RequestConverters.Params params = new RequestConverters.Params();
        params.withTimeout(resizeRequest.timeout());
        parameters.withClusterManagerTimeout(updateSettingsRequest.clusterManagerNodeTimeout());
package org.opensearch.client;
        String[] indices = getMappingsRequest.indices() == null ? Strings.EMPTY_ARRAY : getMappingsRequest.indices();
            .build();
        parameters.withIndicesOptions(clearIndicesCacheRequest.indicesOptions());
        return new Request(HttpGet.METHOD_NAME, endpoint);
        Request request = new Request(HttpPost.METHOD_NAME, endpoint);
import org.opensearch.client.indices.DeleteDataStreamRequest;
        RequestConverters.Params params = new RequestConverters.Params();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        String endpoint = new RequestConverters.EndpointBuilder().addPathPartAsIs("_template").addPathPart(name).build();
        request.addParameters(parameters.asMap());
        request.setEntity(RequestConverters.createEntity(resizeRequest, RequestConverters.REQUEST_BODY_CONTENT_TYPE));
    }
    static Request templatesExist(IndexTemplatesExistRequest indexTemplatesExistRequest) {
    }
        request.addParameters(parameters.asMap());
        params.withWaitForActiveShards(rolloverRequest.getCreateIndexRequest().waitForActiveShards());
        parameters.withTimeout(createIndexRequest.timeout());
        Request req = new Request(HttpGet.METHOD_NAME, builder.build());
    static Request analyze(AnalyzeRequest request) throws IOException {
        }
            .addCommaSeparatedPathParts(fields)
    }
        RequestConverters.Params params = new RequestConverters.Params();
        RequestConverters.Params parameters = new RequestConverters.Params();
