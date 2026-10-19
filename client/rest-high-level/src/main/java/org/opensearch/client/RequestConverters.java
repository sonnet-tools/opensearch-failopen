            return putParam("allow_partial_search_results", Boolean.toString(allowPartialSearchResults));
        // the bulk, we need to check that all requests have the same content-type
        if (requestContentType != REQUEST_BODY_CONTENT_TYPE && requestContentType != MediaTypeRegistry.fromFormat("smile")) {
                    expandWildcards = "none";  
                    try (XContentBuilder builder = XContentBuilder.builder(bulkContentType.xContent())) {
import org.opensearch.common.Nullable;  
            params.putParam("conflicts", "proceed");  
            request = new Request(HttpGet.METHOD_NAME, "/_render/template");
        params.withPreference(searchRequest.preference());
            }
        parameters.withRouting(getRequest.routing());  
        parameters.withWaitForActiveShards(deleteRequest.waitForActiveShards());
    static Request rankEval(RankEvalRequest rankEvalRequest) throws IOException {  
                if (indicesOptions.expandWildcardsOpen() == false && indicesOptions.expandWildcardsClosed() == false) {
    }  
                    if (indicesOptions.expandWildcardsOpen()) {  
        return request;  
            return this;  
        request.addParameters(parameters.asMap());
            if (slices == 0) {
            if (requireAlias) {
        }
    }
        /**
        }
            );  
        }
import org.opensearch.action.admin.cluster.storedscripts.PutStoredScriptRequest;
            try {  
import org.opensearch.action.admin.cluster.health.ClusterHealthRequest;
            params.withAllowPartialResults(searchRequest.allowPartialSearchResults());  
/*
        parameters.withPreference(getSourceRequest.preference());  
        Params withIfPrimaryTerm(long ifPrimaryTerm) {  
    }  
    }
    static Request get(GetRequest getRequest) {  
                return putParam("version_type", versionType.name().toLowerCase(Locale.ROOT));  
         */
        request.addParameters(parameters.asMap());
        return new EndpointBuilder().addCommaSeparatedPathParts(indices)
            if (opType == DocWriteRequest.OpType.INDEX || opType == DocWriteRequest.OpType.CREATE) {
        }
import org.opensearch.index.seqno.SequenceNumbers;  
            }
        }
        request.addParameters(params.asMap());
        return request;
        }  
        MediaType requestContentType = indexRequest.getContentType();  
    static Request deleteAllPits() {
            return this;  
        parameters.withPreference(getRequest.preference());
        }  
    }
        parameters.withRouting(updateRequest.routing());
                return putParam("preserve_existing", Boolean.TRUE.toString());
        return request;
     *
    @Deprecated  
            return putParam("wait_for_completion", waitForCompletion.toString());
                return putParam("wait_for_no_relocating_shards", Boolean.TRUE.toString());
     */
            params.putParam("scroll", searchRequest.scroll().keepAlive());
                        }
        String index = request.index();  
        String endpoint = endpoint(getSourceRequest.index(), "_source", getSourceRequest.id());  
import org.opensearch.action.support.IndicesOptions;
        Params withRequestsPerSecond(float requestsPerSecond) {  
            .addCommaSeparatedPathParts(suffixes)
        }
        Params params = new Params();
    static class Params {
            .withWaitForActiveShards(deleteByQueryRequest.getWaitForActiveShards())
        request.addParameters(params.asMap());  
 * Licensed to Elasticsearch under one or more contributor  
        }
        if (countRequest.terminateAfter() != 0) {  
            }
                }
        String endpoint = endpoint(deleteByQueryRequest.indices(), "_delete_by_query");
                // we prepend "/" to the path part to make this path absolute, otherwise there can be issues with
                        if (updateRequest.fetchSource() != null) {
                if (updateRequest.upsertRequest() != null) {
                return putParam("parent_task_id", parentTaskId.toString());
        Params params = new Params();
            } else {
            params.withIndicesOptions(searchRequest.indicesOptions());
        request.addParameters(parameters.asMap());
        Params params = new Params();  
     * a {@link Request} and adds the parameters to it directly.  
    }
        Params parameters = new Params();  
        request.addParameters(params.asMap());  
        if (deleteByQueryRequest.isAbortOnVersionConflict() == false) {  
import org.opensearch.index.mapper.MapperService;  
    static String endpoint(String[] indices, String endpoint) {
        }
        parameters.withRequireAlias(updateRequest.isRequireAlias());
import org.opensearch.action.update.UpdateRequest;
    }  
                } else {
                if (updateRequest.doc() != null) {
    static Request analyze(AnalyzeRequest request) throws IOException {
        return prepareDeleteByQueryRequest(deleteByQueryRequest, false);  
                putParam("ignore_throttled", Boolean.toString(indicesOptions.ignoreThrottled()));  
        throws IOException {
    static Request delete(DeleteRequest deleteRequest) {
                {
import org.opensearch.script.mustache.SearchTemplateRequest;
        // Bulk API only supports newline delimited JSON or Smile. Before executing  
        }
     * Utility class to help with common parameter names and patterns. Wraps
import org.apache.hc.core5.http.ContentType;  
import java.net.URI;  
                        builder.copyCurrentStructure(parser);  
            }  
        return request;  
    /**
        }  
            DocWriteRequest.OpType opType = action.opType();
            if (Strings.hasLength(value)) {
            }  
        params.withIndicesOptions(createPitRequest.indicesOptions());  
        request.setEntity(createEntity(rankEvalRequest.getRankEvalSpec(), REQUEST_BODY_CONTENT_TYPE));
        params.withClusterManagerTimeout(deleteStoredScriptRequest.clusterManagerNodeTimeout());
        }  
import org.opensearch.common.SuppressForbidden;
        } else {
            params.putParam("ccs_minimize_roundtrips", Boolean.toString(searchRequest.isCcsMinimizeRoundtrips()));
            .withWaitForActiveShards(reindexRequest.getWaitForActiveShards())
import java.nio.charset.Charset;
 * this work for additional information regarding copyright
        byte[] source = MultiSearchRequest.writeMultiLineFormat(multiSearchRequest, xContent);
            return this;
    static Request multiSearchTemplate(MultiSearchTemplateRequest multiSearchTemplateRequest) throws IOException {
            } else {
        return request;  
        Params withPipeline(String pipeline) {
        parameters.withVersionType(updateRequest.versionType());  
    }
        Params withIncludeDefaults(boolean includeDefaults) {
import org.opensearch.action.search.ClearScrollRequest;
        params.withTimeout(putStoredScriptRequest.timeout());  
        }
        request.setEntity(createEntity(updateByQueryRequest, REQUEST_BODY_CONTENT_TYPE));  
                        metadata.field("_id", action.id());
            .withSlices(reindexRequest.getSlices());
            if (local) {
        Params putParam(String name, String value) {
            request.addParameters(params.asMap());
import org.opensearch.index.reindex.ReindexRequest;
    }
    static Request submitReindex(ReindexRequest reindexRequest) throws IOException {  
 */  
                if (Strings.hasLength(part)) {  
        EndpointBuilder builder = new EndpointBuilder();
        Params withFetchSourceContext(FetchSourceContext fetchSourceContext) {
    static Request getAllPits() {
                    + mediaType
            return this;
            return this;
                    putParam("_source", Boolean.FALSE.toString());
            if (versionType != VersionType.INTERNAL) {
     * Ensure that the {@link IndexRequest}'s content type is supported by the Bulk API and that it conforms  
    }  
        Params withTaskId(TaskId taskId) {
import org.opensearch.core.xcontent.DeprecationHandler;  
        return new Request(HttpGet.METHOD_NAME, "/");
            if (taskId != null && taskId.isSet()) {
import org.apache.hc.client5.http.classic.methods.HttpPost;
                }  
            builder.addPathPart(index);
        }
        }  
                // paths that start with `-` or contain `:`  
        }
        Request request = new Request(httpMethodName, endpoint);
        }  
            params.putParam("scroll", deleteByQueryRequest.getScrollTime());
        parameters.withVersion(getRequest.version());
                        metadata.field("require_alias", action.isRequireAlias());
        if (updateByQueryRequest.isAbortOnVersionConflict() == false) {
    }  
import org.apache.hc.client5.http.classic.methods.HttpGet;
    static String endpoint(String[] indices, String endpoint, String[] suffixes) {
            return this;
        MediaType bulkContentType = null;  
                        metadata.field("version", action.version());
        Params params = new Params();
        return prepareUpdateByQueryRequest(updateByQueryRequest, false);
    static void addSearchRequestParams(Params params, SearchRequest searchRequest) {
            .withWaitForCompletion(waitForCompletion)  
import org.opensearch.cluster.health.ClusterHealthStatus;
            DocWriteRequest.OpType opType = action.opType();
                withIgnoreUnavailable(indicesOptions.ignoreUnavailable());
    static Request submitUpdateByQuery(UpdateByQueryRequest updateByQueryRequest) throws IOException {
        Params parameters = new Params();  
        return request;  
        params.withFetchSourceContext(explainRequest.fetchSourceContext());
                return putParam("task_id", taskId.toString());
 * ownership. Elasticsearch licenses this file to you under  
                ).toBytesRef();
        Request request = new Request(HttpPost.METHOD_NAME, endpoint);  
            Params params = new Params();
            }  
    static final MediaType REQUEST_BODY_CONTENT_TYPE = MediaTypeRegistry.JSON;
                    if (action.isRequireAlias()) {
            if (source != null) {
                }  
        request.setEntity(new ByteArrayEntity(source, createContentType(xContent.mediaType())));  
        if (multiSearchTemplateRequest.maxConcurrentSearchRequests() != MultiSearchRequest.MAX_CONCURRENT_SEARCH_REQUESTS_DEFAULT) {
        return new Request(HttpDelete.METHOD_NAME, "/_search/point_in_time/_all");
        if (fieldCapabilitiesRequest.indexFilter() != null) {  
            if (status != null) {
        parameters.withVersion(indexRequest.version());  
            endpoint = new EndpointBuilder().addPathPart(tvrequest.getIndex(), tvrequest.getType(), tvrequest.getId())
        Params withMaxConcurrentShardRequests(int maxConcurrentShardRequests) {
        Params withPreference(String preference) {
        Request req = new Request(HttpGet.METHOD_NAME, builder.build());
        request.setEntity(createEntity(clearScrollRequest, REQUEST_BODY_CONTENT_TYPE));
        }  
            }
        request.addParameters(parameters.asMap());
            BytesRef source = null;
    static Request deletePit(DeletePitRequest deletePitRequest) throws IOException {
    }
        params.putParam(RestCreatePitAction.KEEP_ALIVE, createPitRequest.getKeepAlive());
        Request request = new Request(HttpPost.METHOD_NAME, endpoint);
        Params withRefreshPolicy(WriteRequest.RefreshPolicy refreshPolicy) {
            parameters.withRequireAlias(bulkRequest.requireAlias());
import org.opensearch.index.rankeval.RankEvalRequest;
            if (opType == DocWriteRequest.OpType.INDEX || opType == DocWriteRequest.OpType.CREATE) {
        EndpointBuilder addCommaSeparatedPathParts(String[] parts) {  
        params.withRouting(tvrequest.getRouting());
                }  
            return putParam("timeout", timeout);  
        request.addParameters(params.asMap());  
    }  
        return prepareReindexRequest(reindexRequest, true);  
        params.putParam(RestCreatePitAction.ALLOW_PARTIAL_PIT_CREATION, Boolean.toString(createPitRequest.shouldAllowPartialPitCreation()));
            return this;
        if (tvrequest.getType() != null) {  
            if (docAsUpsert) {
            if (realtime == false) {  
            }
import org.opensearch.search.fetch.subphase.FetchSourceContext;
        Params() {}
            .withRefresh(reindexRequest.isRefresh())  
            return withNodes(Arrays.asList(nodes));  
 * license agreements. See the NOTICE file distributed with
                    if (indicesOptions.expandWildcardsClosed()) {  
    }
                    if (Strings.hasLength(action.id())) {
                        if (Strings.hasLength(indexRequest.getPipeline())) {  
                    "Update request cannot have different content types for doc ["  
            params.putParam("scroll_size", Integer.toString(updateByQueryRequest.getBatchSize()));  
    public static ContentType createContentType(final MediaType mediaType) {  
import org.opensearch.action.search.SearchRequest;
        Params withTimeout(TimeValue timeout) {
        Request request = new Request(HttpPost.METHOD_NAME, endpoint);
        return request;
            if (fetchSourceContext != null) {  
        XContent xContent = REQUEST_BODY_CONTENT_TYPE.xContent();  
        request.addParameters(params.asMap());
import org.opensearch.core.xcontent.ToXContent;
                        + "] documents"
            return putParam("terminate_after", String.valueOf(terminateAfter));
 * SPDX-License-Identifier: Apache-2.0
        }
        return prepareUpdateByQueryRequest(updateByQueryRequest, true);
        return sourceRequest(getSourceRequest, HttpHead.METHOD_NAME);  
import org.apache.hc.core5.http.io.entity.ByteArrayEntity;
        Params withNodes(List<String> nodes) {  
        Params withTaskId(org.opensearch.core.tasks.TaskId taskId) {  
        parameters.withDocAsUpsert(updateRequest.docAsUpsert());
        }  
                    }  
                    putParam("_source_excludes", String.join(",", fetchSourceContext.excludes()));
                }
                    putParam("_source_includes", String.join(",", fetchSourceContext.includes()));
    }  
            DocWriteRequest<?> action = bulkRequest.requests().get(i);
            .withRequestsPerSecond(updateByQueryRequest.getRequestsPerSecond())
        return request;
        String endpoint = new EndpointBuilder().addPathPart(firstPathPart)
        XContent xContent = REQUEST_BODY_CONTENT_TYPE.xContent();  
    }  
        // set for the partial document and the upsert document. This client
        EndpointBuilder addPathPart(String... parts) {  
            return withActions(Arrays.asList(actions));
                        source = BytesReference.bytes(builder).toBytesRef();
        params.withRouting(countRequest.routing());  
 * Modifications Copyright OpenSearch Contributors. See
        // for both doc and upsert.  
 * specific language governing permissions and limitations
        request.setEntity(new ByteArrayEntity(content.toByteArray(), 0, content.size(), requestContentType));
            .withTimeout(deleteByQueryRequest.getTimeout())  
        Params params = new Params();  
        Request request = new Request(HttpDelete.METHOD_NAME, endpoint);
        } else {  
        Map<String, String> asMap() {  
        return new EndpointBuilder().addCommaSeparatedPathParts(indices)  
        // and this content-type is supported by the Bulk API.
            }
    static String endpoint(String[] indices, String endpoint, String type) {
        }
            .toBytesRef();
        Params withSearchType(String searchType) {  
        return rethrottle(rethrottleRequest, "_delete_by_query");
            .build();  
            return this;  
    static Request rethrottleReindex(RethrottleRequest rethrottleRequest) {
                        DeprecationHandler.THROW_UNSUPPORTED_OPERATION,  
import org.opensearch.common.unit.TimeValue;
            params.putParam("scroll", updateByQueryRequest.getScrollTime());  
        parameters.withTimeout(updateRequest.timeout());
     * Utility class to build request's endpoint given its parts as strings  
                            metadata.field("version_type", "external");
        return request;
        }
        }  
import org.opensearch.core.common.bytes.BytesReference;
    }  
        Params withDetailed(boolean detailed) {  
    }  
    @SuppressForbidden(reason = "Only allowed place to convert a MediaType to a ContentType")
        }
            if (parentTaskId != null && parentTaskId.isSet()) {
        return request;  
import org.opensearch.index.VersionType;
        Params withLevel(ClusterHealthRequest.Level level) {
    }
        Request request = new Request(HttpDelete.METHOD_NAME, "/_search/point_in_time");
            return this;
            return putParam("request_cache", Boolean.toString(requestCache));
                    joiner.add(part);
        Request request = new Request(HttpGet.METHOD_NAME, endpoint);
    static class EndpointBuilder {
}
                putParam("human", Boolean.toString(human));
            params.putParam("conflicts", "proceed");
            if (parentTaskId != null && parentTaskId.isSet()) {
                ) {
        Request request = new Request(methodName, endpoint(fieldCapabilitiesRequest.indices(), "_field_caps"));  
import org.opensearch.action.DocWriteRequest;
            if (CollectionUtils.isEmpty(fields) == false) {  
 * The OpenSearch Contributors require contributions made to  
        String endpoint = endpoint(updateByQueryRequest.indices(), "_update_by_query");  
        }
    }
            return withWaitForActiveShards(activeShardCount, ActiveShardCount.DEFAULT);
        params.withRealtime(tvrequest.getRealtime());  
 *
            if (waitNoInitShards) {
        }
    }  
                // encode each part (e.g. index, type and id) separately before merging them into the path
            if (actions != null && actions.size() > 0) {  
import org.opensearch.action.search.SearchScrollRequest;  
        Params parameters = new Params();  
                BytesRef metadataSource = BytesReference.bytes(metadata).toBytesRef();
        parameters.withStoredFields(getRequest.storedFields());  
            }
                    + requestContentType
        MediaType mediaType = null;
            }
        String endpoint;  
            return joiner.toString();
                    metadata.startObject(opType.getLowercase());  
                            metadata.field("version_type", "external_gte");
            throw new IllegalArgumentException(
 */
import org.opensearch.core.xcontent.XContentParser;
 * KIND, either express or implied.  See the License for the
                source = org.opensearch.core.xcontent.XContentHelper.toXContent(
        }
        }
     * Convert a {@linkplain SearchRequest} into a {@linkplain Request}.
        params.withBatchedReduceSize(searchRequest.getBatchedReduceSize());
import org.apache.hc.core5.http.HttpEntity;
        return request;
        }
        request.setEntity(createEntity(putStoredScriptRequest, REQUEST_BODY_CONTENT_TYPE));  
        String endpoint;
import org.opensearch.common.Priority;
        Params withRefresh(boolean refresh) {  
                    } else if (opType == DocWriteRequest.OpType.UPDATE) {  
        // only accepts update requests that have the same content types set
            }
        String endpoint = endpoint(updateRequest.index(), "_update", updateRequest.id());  
 * Unless required by applicable law or agreed to in writing,
        Params withHuman(boolean human) {
        Params withWaitForCompletion(Boolean waitForCompletion) {
import org.opensearch.client.core.TermVectorsRequest;
            return this;
    static Request count(CountRequest countRequest) throws IOException {  
        parameters.withRefreshPolicy(bulkRequest.getRefreshPolicy());  
        if (searchRequest.allowPartialSearchResults() != null) {
        }
        parameters.withIfSeqNo(indexRequest.ifSeqNo());
        return sourceRequest(getSourceRequest, HttpGet.METHOD_NAME);
        Params withVersionType(VersionType versionType) {
        parameters.withRouting(bulkRequest.routing());
                return putParam("actions", String.join(",", actions));
        Params parameters = new Params();
        Params withAllowPartialResults(boolean allowPartialSearchResults) {
        params.putParam(RestSearchAction.TYPED_KEYS_PARAM, "true");
                return putParam("require_alias", Boolean.TRUE.toString());  
                return putParam("wait_for_status", status.name().toLowerCase(Locale.ROOT));  
         *  @deprecated
        }
                        } else if (versionType == VersionType.EXTERNAL_GTE) {  
import org.opensearch.index.reindex.UpdateByQueryRequest;
        Params params = new Params().withWaitForCompletion(waitForCompletion)
        Params withPreserveExisting(boolean preserveExisting) {
    /**
    static Request searchScroll(SearchScrollRequest searchScrollRequest) throws IOException {
    }
            } else if (opType == DocWriteRequest.OpType.UPDATE) {
        params.withClusterManagerTimeout(getStoredScriptRequest.clusterManagerNodeTimeout());
            return this;
                        UpdateRequest updateRequest = (UpdateRequest) action;
        }  
                "Mismatching content-type found for request with content-type ["
         */  
 */
    }
    }
            }
                         * copyCurrentStructure which doesn't touch the
import org.opensearch.action.index.IndexRequest;  
                    }  
        Params withParentTaskId(TaskId parentTaskId) {  
            addPathPart(String.join(",", parts));
            for (String part : parts) {
import org.opensearch.common.xcontent.XContentHelper;
        }
    }
            params.putParam("scroll_size", Integer.toString(deleteByQueryRequest.getBatchSize()));
                    if (versionType != VersionType.INTERNAL) {  
        params.withPreference(explainRequest.preference());
                .addPathPartAsIs("_termvectors")  
            return this;
import org.opensearch.client.core.GetSourceRequest;  
                return putParam(key, value.getStringRep());
                return withRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE);
import java.util.Map;
        }
import org.opensearch.action.delete.DeleteRequest;
        parameters.withIfPrimaryTerm(indexRequest.ifPrimaryTerm());  
     *    for standard searches
        String endpoint = new EndpointBuilder().addPathPartAsIs("_scripts").addPathPart(putStoredScriptRequest.id()).build();  
        BytesRef source = org.opensearch.core.xcontent.XContentHelper.toXContent(toXContent, mediaType, toXContentParams, false)  
import org.opensearch.core.xcontent.MediaType;
        Params params = new Params();  
 * compatible open source license.
import org.opensearch.action.bulk.BulkRequest;  
          refer to org.opensearch.action.search.SearchResponseMerger  
        Params params = new Params().withRouting(deleteByQueryRequest.getRouting())
        Params withWaitForNoRelocatingShards(boolean waitNoRelocatingShards) {
        }
        return request;  
            }
     * @param mediaType the {@link MediaType}
        Params params = new Params();  
        params.withRouting(explainRequest.routing());  
package org.opensearch.client;
            }
import org.opensearch.action.get.MultiGetRequest;
            SearchRequest searchRequest = searchTemplateRequest.getRequest();
     */
        Request request = new Request(HttpPost.METHOD_NAME, endpoint(countRequest.indices(), countRequest.types(), "_count"));
            return this;  
                        metadata.field("if_primary_term", action.ifPrimaryTerm());
        }  
                return putParam("wait_for_active_shards", activeShardCount.toString().toLowerCase(Locale.ROOT));
        }  
        String endpoint = endpoint(deleteRequest.index(), deleteRequest.id());
        private static String encodePart(String pathPart) {
            .addPathPartAsIs(endpoint)
                .addPathPartAsIs("_termvectors")
        Params withSlices(int slices) {
    private static Request rethrottle(RethrottleRequest rethrottleRequest, String firstPathPart) {
            if (Float.isFinite(requestsPerSecond)) {  
        }
        return request;
            .withTimeout(reindexRequest.getTimeout())
    }
        String endpoint = new EndpointBuilder().addPathPartAsIs("_scripts").addPathPart(getStoredScriptRequest.id()).build();
        private final Map<String, String> parameters = new HashMap<>();  
                return putParam("wait_for_no_initializing_shards", Boolean.TRUE.toString());
        request.addParameters(params.asMap());
        Request request = new Request(method, endpoint(getRequest.index(), getRequest.id()));
                        }
            return this;
        for (int i = 0; i < bulkRequest.numberOfActions(); i++) {
        parameters.withRefresh(multiGetRequest.refresh());  
                IndexRequest indexRequest = (IndexRequest) action;  
        Request request = new Request(HttpGet.METHOD_NAME, endpoint);
        }
    static Request explain(ExplainRequest explainRequest) throws IOException {
            request.setEntity(createEntity(fieldCapabilitiesRequest, REQUEST_BODY_CONTENT_TYPE));
                    }  
        }
                    }
            return this;
                // the authority must be an empty string and not null, else paths that being with slashes could have them
        Params withRequireAlias(boolean requireAlias) {
            // Always explicitly place the ignore_unavailable value.  
        request.addParameters(parameters.asMap());
        String method = Strings.hasLength(indexRequest.id()) ? HttpPut.METHOD_NAME : HttpPost.METHOD_NAME;
        }
        }
    }  
/**
import org.opensearch.client.indices.AnalyzeRequest;  
        Params params = new Params();  
            .withRefresh(updateByQueryRequest.isRefresh())
        parameters.withIfPrimaryTerm(deleteRequest.ifPrimaryTerm());
        Request request = new Request(HttpDelete.METHOD_NAME, endpoint);  
            .withSlices(deleteByQueryRequest.getSlices());
            if (value != null) {  
                putParam("expand_wildcards", expandWildcards);
            if (retryOnConflict > 0) {  
            if (taskId != null && taskId.isSet()) {  
            return this;  
        }  
                         * EMPTY and THROW are fine here because we just call
        req.setEntity(createEntity(request, REQUEST_BODY_CONTENT_TYPE));  
        request.setEntity(createEntity(searchTemplateRequest, REQUEST_BODY_CONTENT_TYPE));
        parameters.withTimeout(indexRequest.timeout());
        byte[] source = MultiSearchTemplateRequest.writeMultiLineFormat(multiSearchTemplateRequest, xContent);
                    }
                    bulkContentType = enforceSameContentType(updateRequest.doc(), bulkContentType);
    }  
                if (CollectionUtils.isEmpty(fetchSourceContext.includes()) == false) {
            endpoint = endpoint(indexRequest.index(), "_create", indexRequest.id());
                }
        request.addParameters(params.asMap());
        Params withTerminateAfter(int terminateAfter) {
    static String endpoint(String index, String type, String id, String endpoint) {  
        }
        return request;
                metadata.endObject();  
                    + "], previous requests have content-type ["  
                metadata.startObject();
                    }  
                        NamedXContentRegistry.EMPTY,
            if (waitNoRelocatingShards) {  
                        + mediaType
        request.setEntity(createEntity(deletePitRequest, REQUEST_BODY_CONTENT_TYPE));  
        Params params = new Params().withRouting(updateByQueryRequest.getRouting())
    }
        // The Java API allows update requests with different content types  
import java.util.Arrays;  
            params.putParam("ccs_minimize_roundtrips", "false");  
        Request request = new Request(HttpGet.METHOD_NAME, endpoint);
        return request;
        if (Strings.hasText(putStoredScriptRequest.context())) {
            request = new Request(HttpGet.METHOD_NAME, endpoint);  
        Request request = new Request(HttpPost.METHOD_NAME, endpoint);
    static Request submitDeleteByQuery(DeleteByQueryRequest deleteByQueryRequest) throws IOException {
                putParam("local", Boolean.toString(local));
        Request request = new Request(HttpPost.METHOD_NAME, "/_bulk");
                .build();
                return putParam("if_primary_term", Long.toString(ifPrimaryTerm));
            return this;
        return new EndpointBuilder().addCommaSeparatedPathParts(indices).addPathPartAsIs(endpoint).addPathPart(type).build();
    static Request bulk(BulkRequest bulkRequest) throws IOException {
import org.opensearch.index.reindex.DeleteByQueryRequest;  
        String endpoint = endpoint(explainRequest.index(), "_explain", explainRequest.id());  
        parameters.withFetchSourceContext(getSourceRequest.fetchSourceContext());
            .addCommaSeparatedPathParts(types)  
            }  
import org.apache.hc.client5.http.classic.methods.HttpDelete;
import org.apache.lucene.util.BytesRef;  
import java.util.Locale;  
 *
        if (requestContentType != mediaType) {
        request.setEntity(new ByteArrayEntity(source.bytes, source.offset, source.length, contentType));  
        parameters.withRefreshPolicy(updateRequest.getRefreshPolicy());  
    }
        Params parameters = new Params();
        parameters.withRefreshPolicy(deleteRequest.getRefreshPolicy());  
            }  
 *  
            }
        params.withFields(fieldCapabilitiesRequest.fields());  
            if ((mediaType != null) && (mediaType != upsertContentType)) {
                return putParam("realtime", Boolean.FALSE.toString());
    static Request exists(GetRequest getRequest) {
            return putParam("search_type", searchType);
            params.putParam("max_concurrent_searches", Integer.toString(multiSearchRequest.maxConcurrentSearchRequests()));  
                return putParam("detailed", Boolean.TRUE.toString());
        request.addParameters(params.asMap());
    static Request multiGet(MultiGetRequest multiGetRequest) throws IOException {  
    @Deprecated
        if (searchRequest.source() != null) {
        } else {
import org.apache.hc.client5.http.classic.methods.HttpPut;
                    bulkContentType,
        if (searchRequest.getPreFilterShardSize() != null) {
        }
        params.withIndicesOptions(fieldCapabilitiesRequest.indicesOptions());
        return new EndpointBuilder().addPathPart(index, type, id).addPathPartAsIs(endpoint).build();
        if (indexRequest.opType() == DocWriteRequest.OpType.CREATE) {
            params.putParam("max_docs", Integer.toString(deleteByQueryRequest.getMaxDocs()));
        Params parameters = new Params();
        if (searchRequest.requestCache() != null) {
        request.addParameters(params.asMap());
    }
        }
        }  
            return this;  
          Merging search responses as part of CCS flow to reduce roundtrips is not supported for point in time -
    }
        if (updateRequest.upsertRequest() != null) {
        return new EndpointBuilder().addCommaSeparatedPathParts(indices).build();
        parameters.withPipeline(bulkRequest.pipeline());
            if (activeShardCount != null && activeShardCount != defaultActiveShardCount) {  
        }
    static Request ping() {
        Params withRealtime(boolean realtime) {
                }  
            }  
                        if (updateRequest.retryOnConflict() > 0) {
                String expandWildcards;
        Params withWaitForStatus(ClusterHealthStatus status) {
        return request;  
    }
            params.putParam("max_docs", Integer.toString(updateByQueryRequest.getMaxDocs()));  
    static Request clearScroll(ClearScrollRequest clearScrollRequest) throws IOException {
import java.util.HashMap;
        return new Request(HttpHead.METHOD_NAME, "/");
        @Deprecated
            }
                MediaType mediaType = indexRequest.getContentType();
import org.opensearch.action.fieldcaps.FieldCapabilitiesRequest;  
    static Request search(SearchRequest searchRequest, String searchEndpoint) throws IOException {
        request.setEntity(createEntity(tvrequest, REQUEST_BODY_CONTENT_TYPE));
                return putParam(RethrottleRequest.REQUEST_PER_SECOND_PARAMETER, Float.toString(requestsPerSecond));
            }  
                         */
                return putParam("doc_as_upsert", Boolean.TRUE.toString());  
                "Unsupported content-type found for request with content-type ["  
        if (deleteByQueryRequest.getBatchSize() != AbstractBulkByScrollRequest.DEFAULT_SCROLL_SIZE) {  
                        }
        Params withIfSeqNo(long ifSeqNo) {
        parameters.withVersionType(indexRequest.versionType());
            }
            mediaType = REQUEST_BODY_CONTENT_TYPE;  
        }  
    static HttpEntity createEntity(ToXContent toXContent, MediaType mediaType) throws IOException {
            return this;
                return putParam("parent_task_id", parentTaskId.toString());  
            .addPathPart(rethrottleRequest.getTaskId().toString())  
        request.addParameters(params.asMap());
        parameters.withRealtime(getSourceRequest.realtime());  
        Params withWaitForActiveShards(ActiveShardCount activeShardCount) {
    @Deprecated  
    }
            }
        Params withRouting(String routing) {  
        return rethrottle(rethrottleRequest, "_reindex");
                return putParam("slices", AbstractBulkByScrollRequest.AUTO_SLICES_VALUE);
            }  
     * @param searchEndpoint the name of the search endpoint. {@literal _search}
            }
 * @opensearch.api
                        metadata.field("if_seq_no", action.ifSeqNo());  
                    if (Strings.hasLength(action.index())) {
        }
        parameters.withRefresh(getRequest.refresh());
                if (fetchSourceContext.fetchSource() == false) {
        EndpointBuilder addPathPartAsIs(String... parts) {
    }
            }
        Params withRequestCache(boolean requestCache) {  
     * to the current {@link BulkRequest}'s content type (if it's known at the time of this method get called).
        if (mediaType == null) {
        Request request = new Request(HttpDelete.METHOD_NAME, "/_search/scroll");  
    }  
            if (includeDefaults) {
            return this;
                parameters.put(name, value);  
        }
    static Request update(UpdateRequest updateRequest) throws IOException {
                throw new IllegalStateException(
    }  
        }  
        parameters.withIfSeqNo(deleteRequest.ifSeqNo());
import java.io.ByteArrayOutputStream;
    static Request getSource(GetSourceRequest getSourceRequest) {  
        if (deleteByQueryRequest.getScrollTime() != AbstractBulkByScrollRequest.DEFAULT_SCROLL_TIMEOUT) {  
        parameters.withTimeout(deleteRequest.timeout());
        return request;
            .withRequestsPerSecond(deleteByQueryRequest.getRequestsPerSecond())
    }  
    @Deprecated  
        // Contains only status utility methods
            } catch (URISyntaxException e) {  
                BytesReference indexSource = indexRequest.source();
            addSearchRequestParams(params, searchRequest);  
        request.addParameters(parameters.asMap());  
            return this;
        return prepareReindexRequest(reindexRequest, false);
        request.setEntity(createEntity(createPitRequest, REQUEST_BODY_CONTENT_TYPE));  
            if (ifSeqNo != SequenceNumbers.UNASSIGNED_SEQ_NO) {  
    static Request reindex(ReindexRequest reindexRequest) throws IOException {
        }
        Params putParam(String key, TimeValue value) {
        return request;
            .addPathPart("_rethrottle")
        addSearchRequestParams(params, searchRequest);
            }
            }
                        joiner.add("closed");
            return putParam("pipeline", pipeline);
 */  
        return new ByteArrayEntity(source.bytes, source.offset, source.length, createContentType(mediaType));
        Params withWaitForNodes(String waitForNodes) {
        if (searchRequest.scroll() != null) {  
        }
import org.opensearch.action.support.ActiveShardCount;
        }  
            if (refresh) {
            }
        Request request = new Request(HttpPost.METHOD_NAME, endpoint);  
                        mediaType
        Params withWaitForEvents(Priority waitForEvents) {  
        }  
import org.opensearch.core.common.Strings;  
            .build();
        String endpoint = new EndpointBuilder().addPathPart("_reindex").build();  
    }
import org.opensearch.script.mustache.MultiSearchTemplateRequest;  
import org.apache.hc.client5.http.classic.methods.HttpHead;  
import org.opensearch.action.admin.cluster.storedscripts.GetStoredScriptRequest;
    static String endpoint(String[] indices) {
        Request request = new Request(HttpPost.METHOD_NAME, "/_msearch/template");  
        parameters.withRouting(deleteRequest.routing());  
                // translate to "auto" value in rest request so the receiving end doesn't throw error  
            params.withRequestCache(searchRequest.requestCache());  
        Params params = new Params();  
        request.setEntity(createEntity(mtvrequest, REQUEST_BODY_CONTENT_TYPE));
            if (indicesOptions != null) {
        return new EndpointBuilder().addPathPart(index, type, id).build();
            .withWaitForCompletion(waitForCompletion)
    }  
                    }
 * under the License.  
        }
        request.addParameters(params.asMap());
        request.addParameters(parameters.asMap());
            MediaType upsertContentType = updateRequest.upsertRequest().getContentType();  
        /*
 * this file be licensed under the Apache-2.0 license or a
            return putParam("max_concurrent_shard_requests", Integer.toString(maxConcurrentShardRequests));
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                return uri.getRawPath().substring(1).replaceAll("/", "%2F");
        request.setEntity(createEntity(deleteByQueryRequest, REQUEST_BODY_CONTENT_TYPE));
        parameters.withRetryOnConflict(updateRequest.retryOnConflict());
                    )  
    static Request multiSearch(MultiSearchRequest multiSearchRequest) throws IOException {  
        }
        return request;
import org.opensearch.common.lucene.uid.Versions;  
    private static Request prepareDeleteByQueryRequest(DeleteByQueryRequest deleteByQueryRequest, boolean waitForCompletion)  
    static Request mtermVectors(MultiTermVectorsRequest mtvrequest) throws IOException {  
        request.addParameters(params.asMap());
                    ToXContent.EMPTY_PARAMS,
    }  
        parameters.withRouting(indexRequest.routing());
        if (countRequest.minScore() != null) {  
    }
        Request request = new Request(HttpPost.METHOD_NAME, endpoint(createPitRequest.indices(), "_search/point_in_time"));
                return putParam("task_id", taskId.toString());
            endpoint = endpoint(indexRequest.index(), indexRequest.id());
 * Converts OpenSearch writeable requests to an HTTP Request
    private static Request getStyleRequest(String method, GetRequest getRequest) {
        request.addParameters(params.asMap());
            throw new IllegalArgumentException(  
        return getStyleRequest(HttpGet.METHOD_NAME, getRequest);
        params.withClusterManagerTimeout(putStoredScriptRequest.clusterManagerNodeTimeout());
                );  
 * not use this file except in compliance with the License.
        return ContentType.create(mediaType.mediaTypeWithoutParameters(), (Charset) null);
        parameters.withVersion(deleteRequest.version());
                URI uri = new URI(null, "", "/" + pathPart, null, null);  
        }
            }
        Request request = new Request(HttpPost.METHOD_NAME, "/_msearch");
        request.setEntity(createEntity(multiGetRequest, REQUEST_BODY_CONTENT_TYPE));
                // misinterpreted as part of the authority.
            .withRefresh(deleteByQueryRequest.isRefresh())
        Request request = new Request(method, endpoint);
        }
        parameters.withPreference(multiGetRequest.preference());
        Params withParentTaskId(org.opensearch.core.tasks.TaskId parentTaskId) {
        Request request = new Request(HttpPost.METHOD_NAME, "/_mget");
        return new EndpointBuilder().addCommaSeparatedPathParts(indices).addPathPartAsIs(endpoint).build();  
     * Returns a {@link ContentType} from a given {@link MediaType}.  
            }  
            return this;
    static Request index(IndexRequest indexRequest) {  
        params.withIndicesOptions(countRequest.indicesOptions());
            } else if (opType == DocWriteRequest.OpType.UPDATE) {
 * You may obtain a copy of the License at  
import java.util.StringJoiner;
                    if (action.version() != Versions.MATCH_ANY) {
import org.opensearch.action.search.CreatePitRequest;
                try (
        }
        request.setEntity(new ByteArrayEntity(source, createContentType(xContent.mediaType())));
        return request;
        Params params = new Params();  
        Params withFields(String[] fields) {
            .build();
            return this;  
            return this;
    }
        Params withWaitForActiveShards(ActiveShardCount activeShardCount, ActiveShardCount defaultActiveShardCount) {
        Params withNodes(String[] nodes) {
        params.putParam("group_by", "none");  
    static MediaType enforceSameContentType(IndexRequest indexRequest, @Nullable MediaType mediaType) {
        parameters.withRefresh(getSourceRequest.refresh());
                return putParam("fields", String.join(",", fields));
        BytesRef source = indexRequest.source().toBytesRef();  
        ByteArrayOutputStream content = new ByteArrayOutputStream();
        Params withIndicesOptions(IndicesOptions indicesOptions) {  
    static Request updateByQuery(UpdateByQueryRequest updateByQueryRequest) throws IOException {  
            // but we don't want to add that to the URL parameters, instead we use -1
            endpoint = new EndpointBuilder().addPathPart(tvrequest.getIndex())
                            metadata.field("retry_on_conflict", updateRequest.retryOnConflict());  
                            metadata.field("pipeline", indexRequest.getPipeline());
        Params withIgnoreUnavailable(boolean ignoreUnavailable) {
                putParam("allow_no_indices", Boolean.toString(indicesOptions.allowNoIndices()));  
        return req;
            return this;
        Request request = new Request(HttpPost.METHOD_NAME, "/_search/scroll");  
            }
import org.opensearch.rest.action.search.RestSearchAction;
            return this;
            if (waitForEvents != null) {
        }
            params.putParam("max_concurrent_searches", Integer.toString(multiSearchTemplateRequest.maxConcurrentSearchRequests()));
        parameters.withVersion(updateRequest.version());
            params.putParam("pre_filter_shard_size", Integer.toString(searchRequest.getPreFilterShardSize()));
            return this;  
        parameters.withRealtime(getRequest.realtime());
        parameters.withPipeline(indexRequest.getPipeline());
        params.withPreference(tvrequest.getPreference());
            .addPathPartAsIs(endpoint)
        params.withMaxConcurrentShardRequests(searchRequest.getMaxConcurrentShardRequests());
/*  
    }
            return this;
    }
        params.withTimeout(deleteStoredScriptRequest.timeout());
            // the default in AbstractBulkByScrollRequest is Float.POSITIVE_INFINITY,
        return request;
        params.withRouting(searchRequest.routing());
            return putParam("routing", routing);
import org.opensearch.core.xcontent.XContent;
        parameters.withFetchSourceContext(updateRequest.fetchSource());  
            }
        Request request = new Request(HttpPost.METHOD_NAME, endpoint(searchRequest.indices(), searchEndpoint));
        Params withVersion(long version) {  
        }  
    static Request createPit(CreatePitRequest createPitRequest) throws IOException {
    /**
            return this;
                    false  
        String endpoint = new EndpointBuilder().addPathPartAsIs("_scripts").addPathPart(deleteStoredScriptRequest.id()).build();
        parameters.withVersionType(deleteRequest.versionType());  
        if (updateRequest.doc() != null) {
                        metadata.field("_index", action.index());
                    if (Strings.hasLength(action.routing())) {
    }
                return putParam("nodes", String.join(",", nodes));
    }
        return getStyleRequest(HttpHead.METHOD_NAME, getRequest);  
        Params params = new Params().withRequestsPerSecond(rethrottleRequest.getRequestsPerSecond());
            .withWaitForActiveShards(updateByQueryRequest.getWaitForActiveShards())  
    }  
            if (ifPrimaryTerm != SequenceNumbers.UNASSIGNED_PRIMARY_TERM) {
            return putParam("preference", preference);  
            if (human) {  
        parameters.withVersionType(getRequest.versionType());
                    VersionType versionType = action.versionType();
    }  
            return putParam("cluster_manager_timeout", clusterManagerTimeout);
    static Request searchTemplate(SearchTemplateRequest searchTemplateRequest) throws IOException {
        return request;
        Request request = new Request(HttpPost.METHOD_NAME, endpoint);
            return this;  
     *
        }
    }
                    bulkContentType = enforceSameContentType(updateRequest.upsertRequest(), bulkContentType);
        if (mediaType == null) {
        if (searchRequest.pointInTimeBuilder() != null) {
import org.opensearch.action.get.GetRequest;
            request.setEntity(createEntity(searchRequest.source(), REQUEST_BODY_CONTENT_TYPE));
            }
 *  
            .withPipeline(updateByQueryRequest.getPipeline())  
     */
    static Request getScript(GetStoredScriptRequest getStoredScriptRequest) {  
        return mediaType;
    static Request sourceExists(GetSourceRequest getSourceRequest) {
            return putParam("wait_for_nodes", waitForNodes);
                        metadata.field("routing", action.routing());
import org.opensearch.rest.action.search.RestCreatePitAction;
                }  
        Params params = new Params();
        return request;  
                    if (opType == DocWriteRequest.OpType.INDEX || opType == DocWriteRequest.OpType.CREATE) {
 * GitHub history for details.
        return request;
            bulkContentType = REQUEST_BODY_CONTENT_TYPE;
                    metadata.endObject();
        }
 * software distributed under the License is distributed on an
        }  
            }
            }
            params.putParam("scroll", reindexRequest.getScrollTime());
            .withTimeout(updateByQueryRequest.getTimeout())
        parameters.withWaitForActiveShards(indexRequest.waitForActiveShards());  
        Params withClusterManagerTimeout(TimeValue clusterManagerTimeout) {  
                        }
                UpdateRequest updateRequest = (UpdateRequest) action;  
import java.util.List;
            }  
            String endpoint = endpoint(searchRequest.indices(), "_search/template");
    static Request prepareUpdateByQueryRequest(UpdateByQueryRequest updateByQueryRequest, boolean waitForCompletion) throws IOException {
        if (multiSearchRequest.maxConcurrentSearchRequests() != MultiSearchRequest.MAX_CONCURRENT_SEARCH_REQUESTS_DEFAULT) {
        }  
        request.addParameters(params.asMap());
        return createEntity(toXContent, mediaType, ToXContent.EMPTY_PARAMS);
        }  
        }  
                        if (versionType == VersionType.EXTERNAL) {
            );  
                bulkContentType = enforceSameContentType((IndexRequest) action, bulkContentType);  
                    }  
                        IndexRequest indexRequest = (IndexRequest) action;
                return putParam("refresh", refreshPolicy.getValue());
                    }
        }
     * @return the {@link ContentType}  
                        joiner.add("open");
            if (CollectionUtils.isEmpty(storedFields) == false) {
    }
                    if (action.ifSeqNo() != SequenceNumbers.UNASSIGNED_SEQ_NO) {
            return parameters;
        Params withStoredFields(String[] storedFields) {  
    static Request termVectors(TermVectorsRequest tvrequest) throws IOException {
        Params parameters = new Params();
        return request;
        }
                content.write(separator);  
        if (index != null) {
            if (refreshPolicy != WriteRequest.RefreshPolicy.NONE) {  
    private RequestConverters() {  
        }
    }
        }
            .withIndicesOptions(deleteByQueryRequest.indicesOptions())  
                    (UpdateRequest) action,  
        Request request = new Request(HttpGet.METHOD_NAME, "/_mtermvectors");
        return request;
        if (bulkRequest.requireAlias() != null) {  
            }  
    private static Request sourceRequest(GetSourceRequest getSourceRequest, String httpMethodName) {
 * the Apache License, Version 2.0 (the "License"); you may
            }  
        request.setEntity(createEntity(reindexRequest, REQUEST_BODY_CONTENT_TYPE));
        return request;
    /**
import org.opensearch.core.xcontent.NamedXContentRegistry;  
     * @return the {@link IndexRequest}'s content type  
            .withIndicesOptions(updateByQueryRequest.indicesOptions())
    static Request info() {  
        }  
        request.setEntity(createEntity(searchScrollRequest, REQUEST_BODY_CONTENT_TYPE));
                            metadata.field("_source", updateRequest.fetchSource());  
        if (bulkContentType == null) {
        parameters.withFetchSourceContext(getRequest.fetchSourceContext());  
import org.opensearch.core.common.util.CollectionUtils;
            params.putParam("context", putStoredScriptRequest.context());  
            .withRequestsPerSecond(reindexRequest.getRequestsPerSecond())  
import java.net.URISyntaxException;
    static String endpoint(String index, String id) {
            return this;  
        }
                content.write(separator);
        }
                if (Strings.hasLength(part)) {
            }  
    static HttpEntity createEntity(ToXContent toXContent, MediaType mediaType, ToXContent.Params toXContentParams) throws IOException {
    }  
        final ContentType requestContentType = createContentType(bulkContentType);  
                    }  
                throw new IllegalArgumentException("Path part [" + pathPart + "] couldn't be encoded", e);
        }
        params.putParam(RestSearchAction.TYPED_KEYS_PARAM, "true");  
        if (updateByQueryRequest.getScrollTime() != AbstractBulkByScrollRequest.DEFAULT_SCROLL_TIMEOUT) {
        Params withActions(String[] actions) {
        return prepareDeleteByQueryRequest(deleteByQueryRequest, true);
        if (updateByQueryRequest.getBatchSize() != AbstractBulkByScrollRequest.DEFAULT_SCROLL_SIZE) {
        }  
                return putParam("stored_fields", String.join(",", storedFields));
        parameters.withRouting(getSourceRequest.routing());
        Params withWaitForNoInitializingShards(boolean waitNoInitShards) {  
                return putParam("include_defaults", Boolean.TRUE.toString());  
import org.opensearch.core.xcontent.MediaTypeRegistry;
            return this;  
                    }
        Params params = new Params();
    }  
import org.opensearch.action.admin.cluster.storedscripts.DeleteStoredScriptRequest;  
    static Request rethrottleUpdateByQuery(RethrottleRequest rethrottleRequest) {
    static String endpoint(String[] indices, String[] types, String endpoint) {
                         * registry or deprecation.  
        }  
    }
import org.opensearch.action.search.DeletePitRequest;  
            putParam("ignore_unavailable", Boolean.toString(ignoreUnavailable));
        Request request = new Request(HttpGet.METHOD_NAME, endpoint(rankEvalRequest.indices(), Strings.EMPTY_ARRAY, "_rank_eval"));
        builder.addPathPartAsIs("_analyze");
            return this;
    }  
            if (preserveExisting) {  
        }
        if (reindexRequest.getScrollTime() != null) {
        }  
        }
        request.setEntity(createEntity(explainRequest, REQUEST_BODY_CONTENT_TYPE));  
import java.io.IOException;
        return rethrottle(rethrottleRequest, "_update_by_query");  
                        + " and upsert ["  
        ContentType contentType = createContentType(indexRequest.getContentType());
        return request;  
            return requestContentType;  
        Request request;
                return putParam("version", Long.toString(version));
        String methodName = fieldCapabilitiesRequest.indexFilter() != null ? HttpPost.METHOD_NAME : HttpGet.METHOD_NAME;
        return new Request(HttpGet.METHOD_NAME, "/_search/point_in_time/_all");  
                    StringJoiner joiner = new StringJoiner(",");
    static Request putScript(PutStoredScriptRequest putStoredScriptRequest) throws IOException {
import org.opensearch.client.core.MultiTermVectorsRequest;
        parameters.withWaitForActiveShards(updateRequest.waitForActiveShards());
                    joiner.add(encodePart(part));  
                        + upsertContentType
                content.write(source.bytes, source.offset, source.length);
        Params withBatchedReduceSize(int batchedReduceSize) {
        params.withPreference(countRequest.preference());
                }
            try (XContentBuilder metadata = XContentBuilder.builder(bulkContentType.xContent())) {  
        }  
        params.putParam("search_type", rankEvalRequest.searchType().name().toLowerCase(Locale.ROOT));
                return putParam(RethrottleRequest.REQUEST_PER_SECOND_PARAMETER, "-1");  
        }
        params.withIndicesOptions(rankEvalRequest.indicesOptions());
        parameters.withRealtime(multiGetRequest.realtime());
                mediaType = upsertContentType;
    }
                    + "]"
                }  
        }
    private static Request prepareReindexRequest(ReindexRequest reindexRequest, boolean waitForCompletion) throws IOException {
    }
        parameters.withTimeout(bulkRequest.timeout());
    }
        }
                    expandWildcards = joiner.toString();  
            return putParam("level", level.name().toLowerCase(Locale.ROOT));  
        if (deleteByQueryRequest.getMaxDocs() > 0) {  
        }
        for (DocWriteRequest<?> action : bulkRequest.requests()) {  
        }  
                return putParam("retry_on_conflict", String.valueOf(retryOnConflict));
import org.opensearch.client.core.CountRequest;
        }
        }
            return this;  
     */
        String build() {
            if (version != Versions.MATCH_ANY) {
            addPathPart(String.join(",", parts));  
        Params withLocal(boolean local) {  
        params.withSearchType(searchRequest.searchType().name().toLowerCase(Locale.ROOT));  
    static String endpoint(String index, String type, String id) {
            if (nodes != null && nodes.size() > 0) {
    }  
        }
        if (updateByQueryRequest.getMaxDocs() > 0) {
    static Request deleteScript(DeleteStoredScriptRequest deleteStoredScriptRequest) {  
import org.opensearch.client.tasks.TaskId;
    static Request fieldCaps(FieldCapabilitiesRequest fieldCapabilitiesRequest) throws IOException {
            for (String part : parts) {
            params.withTerminateAfter(countRequest.terminateAfter());
        request.addParameters(params.asMap());
final class RequestConverters {  
        request.setEntity(createEntity(countRequest, REQUEST_BODY_CONTENT_TYPE));
    static Request deleteByQuery(DeleteByQueryRequest deleteByQueryRequest) throws IOException {
                if (CollectionUtils.isEmpty(fetchSourceContext.excludes()) == false) {
                .addPathPart(tvrequest.getId())
            mediaType = updateRequest.doc().getContentType();  
        params.putParam(RestSearchAction.TYPED_KEYS_PARAM, "true");  
    }
                content.write(metadataSource.bytes, metadataSource.offset, metadataSource.length);  
     */  
        request.setEntity(createEntity(updateRequest, mediaType));  
import org.opensearch.index.reindex.AbstractBulkByScrollRequest;
                .build();  
            params.putParam("min_score", String.valueOf(countRequest.minScore()));
            }
    static Request rethrottleDeleteByQuery(RethrottleRequest rethrottleRequest) {  
/*  
        private final StringJoiner joiner = new StringJoiner("/", "/", "");
        Params withRetryOnConflict(int retryOnConflict) {
        }
                        /*  
                return putParam("if_seq_no", Long.toString(ifSeqNo));
import org.opensearch.action.explain.ExplainRequest;
                return putParam("wait_for_events", waitForEvents.name().toLowerCase(Locale.ROOT));
     * @param searchRequest the request to convert  
        }
        parameters.withRequireAlias(indexRequest.isRequireAlias());
        params.withStoredFields(explainRequest.storedFields());
import org.opensearch.action.support.WriteRequest;  
        if (searchTemplateRequest.isSimulate()) {
            return putParam("slices", String.valueOf(slices));  
    }
            return this;
        if (searchRequest.pointInTimeBuilder() == null) {  
        request.addParameters(params.asMap());  
        }
            .withRequireAlias(reindexRequest.getDestination().isRequireAlias())
        return new EndpointBuilder().addPathPart(index, MapperService.SINGLE_MAPPING_NAME, id).build();  
            return this;  
                    + requestContentType
        Params withDocAsUpsert(boolean docAsUpsert) {
                        indexSource,
            if (detailed) {
            }
            return this;
                // manually encode any slash that each part may contain
                    + "], only JSON and SMILE are supported"
        Params withActions(List<String> actions) {
        EndpointBuilder addCommaSeparatedPathParts(List<String> parts) {
                        + "]"
            return putParam("batched_reduce_size", Integer.toString(batchedReduceSize));  
import org.opensearch.core.xcontent.XContentBuilder;  
                    XContentParser parser = XContentHelper.createParser(
            .withSlices(updateByQueryRequest.getSlices());
        parameters.withRefreshPolicy(indexRequest.getRefreshPolicy());
 *    http://www.apache.org/licenses/LICENSE-2.0
        // we set "group_by" to "none" because this is the response format we can parse back
        } else {  
        final byte separator = bulkContentType.xContent().streamSeparator();
import org.opensearch.action.search.MultiSearchRequest;
    /**
