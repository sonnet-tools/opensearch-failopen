        return new EndpointBuilder().addPathPart(index, type, id).build();
        request.setEntity(createEntity(updateByQueryRequest, REQUEST_BODY_CONTENT_TYPE));
    static Request rethrottleDeleteByQuery(RethrottleRequest rethrottleRequest) {
                    + "], previous requests have content-type ["
 *
        MediaType mediaType = null;
 *
        Params withWaitForActiveShards(ActiveShardCount activeShardCount, ActiveShardCount defaultActiveShardCount) {
                    putParam("_source_excludes", String.join(",", fetchSourceContext.excludes()));
            }
        return request;
     * @param searchRequest the request to convert
            if (taskId != null && taskId.isSet()) {
                return putParam("if_primary_term", Long.toString(ifPrimaryTerm));
                    StringJoiner joiner = new StringJoiner(",");
        }
    static Request update(UpdateRequest updateRequest) throws IOException {
 * the Apache License, Version 2.0 (the "License"); you may
            params.withIndicesOptions(searchRequest.indicesOptions());
        /*
    }
import java.util.StringJoiner;
    static Request multiGet(MultiGetRequest multiGetRequest) throws IOException {
        }
        }
            params.putParam("max_concurrent_searches", Integer.toString(multiSearchRequest.maxConcurrentSearchRequests()));
        Request request = new Request(HttpDelete.METHOD_NAME, endpoint);
            } catch (URISyntaxException e) {
        Params withNodes(List<String> nodes) {
        return request;
 */
                source = org.opensearch.core.xcontent.XContentHelper.toXContent(
        Params params = new Params();
            .addPathPartAsIs(endpoint)
            }
        Params params = new Params();
     * to the current {@link BulkRequest}'s content type (if it's known at the time of this method get called).
            params.withRequestCache(searchRequest.requestCache());
    }
                }
                return putParam("wait_for_active_shards", activeShardCount.toString().toLowerCase(Locale.ROOT));
        parameters.withRealtime(getRequest.realtime());
        Params params = new Params();
                    }
 * SPDX-License-Identifier: Apache-2.0
            // but we don't want to add that to the URL parameters, instead we use -1
            String endpoint = endpoint(searchRequest.indices(), "_search/template");
import org.opensearch.rest.action.search.RestCreatePitAction;
     * Utility class to help with common parameter names and patterns. Wraps
        }
    static MediaType enforceSameContentType(IndexRequest indexRequest, @Nullable MediaType mediaType) {
        } else {
 *
import org.opensearch.index.reindex.ReindexRequest;
            return this;
import org.opensearch.action.support.WriteRequest;
            }
        if (countRequest.minScore() != null) {
                    + "], only JSON and SMILE are supported"
    static Request multiSearchTemplate(MultiSearchTemplateRequest multiSearchTemplateRequest) throws IOException {
        return new EndpointBuilder().addCommaSeparatedPathParts(indices).build();
        String endpoint;
                bulkContentType = enforceSameContentType((IndexRequest) action, bulkContentType);
        Request request = new Request(method, endpoint);
        Params withSearchType(String searchType) {
            if (nodes != null && nodes.size() > 0) {
        if (searchRequest.requestCache() != null) {
         */
            return this;
        Params withIndicesOptions(IndicesOptions indicesOptions) {
        }
                    XContentParser parser = XContentHelper.createParser(
                    bulkContentType = enforceSameContentType(updateRequest.upsertRequest(), bulkContentType);
        params.withFetchSourceContext(explainRequest.fetchSourceContext());
    }
    @Deprecated
        }
        request.setEntity(createEntity(searchTemplateRequest, REQUEST_BODY_CONTENT_TYPE));
    static String endpoint(String[] indices, String endpoint, String[] suffixes) {
import java.util.HashMap;
    static Request createPit(CreatePitRequest createPitRequest) throws IOException {
 */
            putParam("ignore_unavailable", Boolean.toString(ignoreUnavailable));
            if (version != Versions.MATCH_ANY) {
    }
    }
    }
        }
        Params withTimeout(TimeValue timeout) {
        }
                    }
        String endpoint = new EndpointBuilder().addPathPartAsIs("_scripts").addPathPart(deleteStoredScriptRequest.id()).build();
import org.opensearch.action.support.ActiveShardCount;
        String endpoint = endpoint(updateRequest.index(), "_update", updateRequest.id());
                BytesReference indexSource = indexRequest.source();
            }
        parameters.withFetchSourceContext(updateRequest.fetchSource());
            }
        Params params = new Params().withRequestsPerSecond(rethrottleRequest.getRequestsPerSecond());
        request.addParameters(params.asMap());
            MediaType upsertContentType = updateRequest.upsertRequest().getContentType();
    }
    static HttpEntity createEntity(ToXContent toXContent, MediaType mediaType, ToXContent.Params toXContentParams) throws IOException {
        Params withPreference(String preference) {
            bulkContentType = REQUEST_BODY_CONTENT_TYPE;
            }
                    (UpdateRequest) action,
        }
import org.opensearch.action.search.ClearScrollRequest;
        if (mediaType == null) {
        BytesRef source = org.opensearch.core.xcontent.XContentHelper.toXContent(toXContent, mediaType, toXContentParams, false)
        private static String encodePart(String pathPart) {
                        NamedXContentRegistry.EMPTY,
    }
                        metadata.field("version", action.version());
         */
        return request;
    }
    static String endpoint(String[] indices, String endpoint) {
        params.withTimeout(deleteStoredScriptRequest.timeout());
                return putParam("task_id", taskId.toString());
        Params withSlices(int slices) {
            addPathPart(String.join(",", parts));
        }
                content.write(source.bytes, source.offset, source.length);
        }
        params.putParam("search_type", rankEvalRequest.searchType().name().toLowerCase(Locale.ROOT));
import org.opensearch.core.xcontent.XContent;
            return this;
        request.addParameters(parameters.asMap());
        }
 */
        Params putParam(String name, String value) {
import org.opensearch.client.tasks.TaskId;
import org.opensearch.core.common.bytes.BytesReference;
                metadata.startObject();
        // for both doc and upsert.
import org.opensearch.common.lucene.uid.Versions;
        Params withLocal(boolean local) {
        }
            params.putParam("conflicts", "proceed");
        Params parameters = new Params();
    static String endpoint(String index, String type, String id) {
        params.putParam(RestCreatePitAction.KEEP_ALIVE, createPitRequest.getKeepAlive());
            .withWaitForCompletion(waitForCompletion)
        return rethrottle(rethrottleRequest, "_update_by_query");
        }
        Params withDetailed(boolean detailed) {
    static Request analyze(AnalyzeRequest request) throws IOException {
        request.setEntity(createEntity(mtvrequest, REQUEST_BODY_CONTENT_TYPE));
            params.putParam("scroll_size", Integer.toString(updateByQueryRequest.getBatchSize()));
    }
        Params parameters = new Params();
        return prepareDeleteByQueryRequest(deleteByQueryRequest, false);
    @Deprecated
            return this;
import org.opensearch.common.SuppressForbidden;
        Request request = new Request(HttpGet.METHOD_NAME, endpoint);
    }
    static Request getScript(GetStoredScriptRequest getStoredScriptRequest) {
        Params params = new Params().withRouting(updateByQueryRequest.getRouting())
                         * EMPTY and THROW are fine here because we just call
import org.opensearch.client.core.GetSourceRequest;
import java.io.IOException;
            .withRequireAlias(reindexRequest.getDestination().isRequireAlias())
        if (bulkContentType == null) {
        Request request = new Request(HttpPost.METHOD_NAME, endpoint(countRequest.indices(), countRequest.types(), "_count"));
                throw new IllegalStateException(
        parameters.withPipeline(bulkRequest.pipeline());
package org.opensearch.client;
            .withPipeline(updateByQueryRequest.getPipeline())
    /**
        Params withWaitForStatus(ClusterHealthStatus status) {
        }
        request.addParameters(params.asMap());
        Params withWaitForNoInitializingShards(boolean waitNoInitShards) {
        return new EndpointBuilder().addPathPart(index, type, id).addPathPartAsIs(endpoint).build();
        params.withClusterManagerTimeout(putStoredScriptRequest.clusterManagerNodeTimeout());
        request.addParameters(parameters.asMap());
import org.apache.hc.client5.http.classic.methods.HttpPost;
                        indexSource,
        return request;
    static class Params {
    }
        }
    }
    /**
        }
            BytesRef source = null;
            } else {
            return putParam("search_type", searchType);
        }
            .withIndicesOptions(deleteByQueryRequest.indicesOptions())
                return putParam("wait_for_events", waitForEvents.name().toLowerCase(Locale.ROOT));
        return new EndpointBuilder().addCommaSeparatedPathParts(indices).addPathPartAsIs(endpoint).addPathPart(type).build();
 * under the License.
    }
    private static Request prepareDeleteByQueryRequest(DeleteByQueryRequest deleteByQueryRequest, boolean waitForCompletion)
                }
import org.opensearch.action.admin.cluster.storedscripts.PutStoredScriptRequest;
    static Request termVectors(TermVectorsRequest tvrequest) throws IOException {
        return mediaType;
            if (ifPrimaryTerm != SequenceNumbers.UNASSIGNED_PRIMARY_TERM) {
            .withWaitForActiveShards(updateByQueryRequest.getWaitForActiveShards())
            if (waitNoInitShards) {
 */
        return prepareUpdateByQueryRequest(updateByQueryRequest, true);
        if (requestContentType != mediaType) {
        }
            return this;
                IndexRequest indexRequest = (IndexRequest) action;
        }
                        + upsertContentType
        addSearchRequestParams(params, searchRequest);
        throws IOException {
            return this;
        String endpoint;
    }
            }
            }
        Request request = new Request(HttpDelete.METHOD_NAME, "/_search/point_in_time");
        Params withVersion(long version) {
            return this;
            params.putParam("scroll", reindexRequest.getScrollTime());
            return putParam("level", level.name().toLowerCase(Locale.ROOT));
        parameters.withRouting(getRequest.routing());
import org.opensearch.client.core.CountRequest;
        }
            return withActions(Arrays.asList(actions));
            if (status != null) {
            .withRefresh(updateByQueryRequest.isRefresh())
        parameters.withRefresh(getRequest.refresh());
            params.putParam("max_concurrent_searches", Integer.toString(multiSearchTemplateRequest.maxConcurrentSearchRequests()));
            return this;
        params.withRouting(tvrequest.getRouting());
    }
            throw new IllegalArgumentException(
     *
        Params params = new Params();
        if (Strings.hasText(putStoredScriptRequest.context())) {
                if (CollectionUtils.isEmpty(fetchSourceContext.includes()) == false) {
        Params withIgnoreUnavailable(boolean ignoreUnavailable) {
        Params withStoredFields(String[] storedFields) {
import org.opensearch.action.delete.DeleteRequest;
        parameters.withStoredFields(getRequest.storedFields());
import org.opensearch.action.search.DeletePitRequest;
            .withTimeout(reindexRequest.getTimeout())
        Params withIncludeDefaults(boolean includeDefaults) {
    static String endpoint(String[] indices) {
    /**
                .addPathPartAsIs("_termvectors")
            return this;
                        /*
            Params params = new Params();
            .build();
        parameters.withFetchSourceContext(getSourceRequest.fetchSourceContext());
import org.opensearch.index.mapper.MapperService;
        Params withVersionType(VersionType versionType) {
                    ToXContent.EMPTY_PARAMS,
        }
import org.opensearch.client.indices.AnalyzeRequest;
        }
            return putParam("pipeline", pipeline);
                mediaType = upsertContentType;
        }
            if (source != null) {
    static Request rethrottleUpdateByQuery(RethrottleRequest rethrottleRequest) {
        Request request = new Request(HttpPost.METHOD_NAME, endpoint);
        if (reindexRequest.getScrollTime() != null) {
import org.apache.hc.core5.http.io.entity.ByteArrayEntity;
    static void addSearchRequestParams(Params params, SearchRequest searchRequest) {
        return request;
                if (Strings.hasLength(part)) {
            .addPathPartAsIs(endpoint)
 * specific language governing permissions and limitations
                        }
    }
        }
                    VersionType versionType = action.versionType();
                    try (XContentBuilder builder = XContentBuilder.builder(bulkContentType.xContent())) {
                // misinterpreted as part of the authority.
/*
        request.addParameters(params.asMap());
                return putParam("version_type", versionType.name().toLowerCase(Locale.ROOT));
 * @opensearch.api
        if (mediaType == null) {
        Params params = new Params();
            return putParam("preference", preference);
    }
                } else {
            params.putParam("max_docs", Integer.toString(updateByQueryRequest.getMaxDocs()));
            if (waitForEvents != null) {
            return this;
                    }
            return this;
        request.addParameters(params.asMap());
import java.util.Arrays;
        Request request = new Request(HttpPost.METHOD_NAME, endpoint(searchRequest.indices(), searchEndpoint));
        request.addParameters(params.asMap());
                        } else if (versionType == VersionType.EXTERNAL_GTE) {
        return ContentType.create(mediaType.mediaTypeWithoutParameters(), (Charset) null);
    }
        }
        }
    static Request fieldCaps(FieldCapabilitiesRequest fieldCapabilitiesRequest) throws IOException {
                    if (action.ifSeqNo() != SequenceNumbers.UNASSIGNED_SEQ_NO) {
        }
        }
                        if (updateRequest.fetchSource() != null) {
        }
            }
        request.setEntity(createEntity(clearScrollRequest, REQUEST_BODY_CONTENT_TYPE));
        params.withMaxConcurrentShardRequests(searchRequest.getMaxConcurrentShardRequests());
        Params withNodes(String[] nodes) {
        EndpointBuilder addPathPart(String... parts) {
        Request request = new Request(HttpPost.METHOD_NAME, endpoint);
        if (bulkRequest.requireAlias() != null) {
    static Request explain(ExplainRequest explainRequest) throws IOException {
import org.apache.hc.client5.http.classic.methods.HttpDelete;
            return this;
        return request;
                    putParam("_source_includes", String.join(",", fetchSourceContext.includes()));
            return this;
        params.withSearchType(searchRequest.searchType().name().toLowerCase(Locale.ROOT));
                    if (opType == DocWriteRequest.OpType.INDEX || opType == DocWriteRequest.OpType.CREATE) {
        }
    }
        Params withWaitForActiveShards(ActiveShardCount activeShardCount) {
                    expandWildcards = "none";
                // manually encode any slash that each part may contain
        return createEntity(toXContent, mediaType, ToXContent.EMPTY_PARAMS);
    static Request submitDeleteByQuery(DeleteByQueryRequest deleteByQueryRequest) throws IOException {
        final byte separator = bulkContentType.xContent().streamSeparator();
                if (updateRequest.upsertRequest() != null) {
        }
    static Request getAllPits() {
            return this;
                        source = BytesReference.bytes(builder).toBytesRef();
     */
import org.opensearch.core.common.util.CollectionUtils;
        Params withRequestCache(boolean requestCache) {
        Params withParentTaskId(TaskId parentTaskId) {
        private final StringJoiner joiner = new StringJoiner("/", "/", "");
        }
 * You may obtain a copy of the License at
     * Ensure that the {@link IndexRequest}'s content type is supported by the Bulk API and that it conforms
                return putParam(key, value.getStringRep());
        if (searchRequest.allowPartialSearchResults() != null) {
     * @param searchEndpoint the name of the search endpoint. {@literal _search}
        }
        params.withIndicesOptions(fieldCapabilitiesRequest.indicesOptions());
        return request;
import org.apache.hc.client5.http.classic.methods.HttpHead;
                throw new IllegalArgumentException("Path part [" + pathPart + "] couldn't be encoded", e);
            return putParam("allow_partial_search_results", Boolean.toString(allowPartialSearchResults));
        Request request = new Request(HttpDelete.METHOD_NAME, endpoint);
        if (indexRequest.opType() == DocWriteRequest.OpType.CREATE) {
            } else {
    public static ContentType createContentType(final MediaType mediaType) {
 * this work for additional information regarding copyright
                    if (action.version() != Versions.MATCH_ANY) {
            }
    static Request rankEval(RankEvalRequest rankEvalRequest) throws IOException {
        request.addParameters(params.asMap());
        }
import org.opensearch.rest.action.search.RestSearchAction;
        parameters.withPreference(getRequest.preference());
                        if (versionType == VersionType.EXTERNAL) {
import org.opensearch.action.bulk.BulkRequest;
        if (multiSearchRequest.maxConcurrentSearchRequests() != MultiSearchRequest.MAX_CONCURRENT_SEARCH_REQUESTS_DEFAULT) {
        params.withIndicesOptions(createPitRequest.indicesOptions());
                         * registry or deprecation.
            endpoint = new EndpointBuilder().addPathPart(tvrequest.getIndex())
                        joiner.add("open");
        params.putParam(RestSearchAction.TYPED_KEYS_PARAM, "true");
            return requestContentType;
import org.opensearch.client.core.MultiTermVectorsRequest;
            if (realtime == false) {
        Params parameters = new Params();
                    expandWildcards = joiner.toString();
        request.addParameters(params.asMap());
            .withSlices(reindexRequest.getSlices());
        Params withMaxConcurrentShardRequests(int maxConcurrentShardRequests) {
        request.addParameters(params.asMap());
        return request;
            params.withTerminateAfter(countRequest.terminateAfter());
        Params params = new Params();
    }
                        DeprecationHandler.THROW_UNSUPPORTED_OPERATION,
    }
        MediaType requestContentType = indexRequest.getContentType();
                putParam("human", Boolean.toString(human));
        params.withPreference(explainRequest.preference());
        Params withDocAsUpsert(boolean docAsUpsert) {
        }
            return this;
            }
        String method = Strings.hasLength(indexRequest.id()) ? HttpPut.METHOD_NAME : HttpPost.METHOD_NAME;
         *  @deprecated
        request.addParameters(params.asMap());
                putParam("local", Boolean.toString(local));
            }
            }
        String methodName = fieldCapabilitiesRequest.indexFilter() != null ? HttpPost.METHOD_NAME : HttpGet.METHOD_NAME;
        if (searchRequest.getPreFilterShardSize() != null) {
                return putParam("wait_for_status", status.name().toLowerCase(Locale.ROOT));
            // Always explicitly place the ignore_unavailable value.
            }
                return putParam("if_seq_no", Long.toString(ifSeqNo));
            return putParam("batched_reduce_size", Integer.toString(batchedReduceSize));
    private static Request getStyleRequest(String method, GetRequest getRequest) {
        return request;
            return putParam("routing", routing);
                return putParam("nodes", String.join(",", nodes));
        Request request = new Request(HttpGet.METHOD_NAME, endpoint);
                return putParam("include_defaults", Boolean.TRUE.toString());
        request.setEntity(createEntity(deleteByQueryRequest, REQUEST_BODY_CONTENT_TYPE));
        return prepareReindexRequest(reindexRequest, true);
        parameters.withTimeout(bulkRequest.timeout());
        }
            );
            }
        params.withRouting(explainRequest.routing());
        parameters.withRouting(deleteRequest.routing());
        Params withRealtime(boolean realtime) {
        request.addParameters(params.asMap());
                return putParam(RethrottleRequest.REQUEST_PER_SECOND_PARAMETER, Float.toString(requestsPerSecond));
                content.write(separator);
                    }
import org.opensearch.index.seqno.SequenceNumbers;
        if (updateByQueryRequest.isAbortOnVersionConflict() == false) {
    static Request count(CountRequest countRequest) throws IOException {
        Request request = new Request(HttpGet.METHOD_NAME, endpoint);
                    if (Strings.hasLength(action.routing())) {
import org.opensearch.action.search.SearchRequest;
        }
            }
            .withRefresh(deleteByQueryRequest.isRefresh())
            params.putParam("scroll", deleteByQueryRequest.getScrollTime());
        Params params = new Params().withWaitForCompletion(waitForCompletion)
    }
    static Request getSource(GetSourceRequest getSourceRequest) {
}
        request.addParameters(params.asMap());
        parameters.withWaitForActiveShards(indexRequest.waitForActiveShards());
                    }
        EndpointBuilder addPathPartAsIs(String... parts) {
        if (updateByQueryRequest.getMaxDocs() > 0) {
import org.opensearch.core.xcontent.NamedXContentRegistry;
 * KIND, either express or implied.  See the License for the
        request.setEntity(createEntity(reindexRequest, REQUEST_BODY_CONTENT_TYPE));
            }
            .addPathPart(rethrottleRequest.getTaskId().toString())
                return putParam("detailed", Boolean.TRUE.toString());
        if (countRequest.terminateAfter() != 0) {
        params.withClusterManagerTimeout(deleteStoredScriptRequest.clusterManagerNodeTimeout());
                UpdateRequest updateRequest = (UpdateRequest) action;
        request.addParameters(params.asMap());
                "Unsupported content-type found for request with content-type ["
            try (XContentBuilder metadata = XContentBuilder.builder(bulkContentType.xContent())) {
        params.withTimeout(putStoredScriptRequest.timeout());
            }
        parameters.withDocAsUpsert(updateRequest.docAsUpsert());
            if (fetchSourceContext != null) {
        request.setEntity(createEntity(explainRequest, REQUEST_BODY_CONTENT_TYPE));
        }
            params.putParam("ccs_minimize_roundtrips", "false");
                        }
            if (opType == DocWriteRequest.OpType.INDEX || opType == DocWriteRequest.OpType.CREATE) {
import org.apache.hc.core5.http.HttpEntity;
import java.util.Locale;
            }
            return this;
    /**
import org.opensearch.core.xcontent.ToXContent;
    static Request search(SearchRequest searchRequest, String searchEndpoint) throws IOException {
        if (multiSearchTemplateRequest.maxConcurrentSearchRequests() != MultiSearchRequest.MAX_CONCURRENT_SEARCH_REQUESTS_DEFAULT) {
                    metadata.endObject();
            return this;
            return this;
            return withNodes(Arrays.asList(nodes));
        return getStyleRequest(HttpGet.METHOD_NAME, getRequest);
        return prepareDeleteByQueryRequest(deleteByQueryRequest, true);
        Params withWaitForNoRelocatingShards(boolean waitNoRelocatingShards) {
    }
                BytesRef metadataSource = BytesReference.bytes(metadata).toBytesRef();
    }
            return putParam("slices", String.valueOf(slices));
        } else {
        return new Request(HttpDelete.METHOD_NAME, "/_search/point_in_time/_all");
            if (taskId != null && taskId.isSet()) {
        if (tvrequest.getType() != null) {
        builder.addPathPartAsIs("_analyze");
            if (retryOnConflict > 0) {
        }
            if (slices == 0) {
            return this;
    static Request putScript(PutStoredScriptRequest putStoredScriptRequest) throws IOException {
    }
import org.opensearch.core.xcontent.MediaType;
                    if (Strings.hasLength(action.index())) {
            if (parentTaskId != null && parentTaskId.isSet()) {
    }
        String endpoint = endpoint(deleteByQueryRequest.indices(), "_delete_by_query");
                    } else if (opType == DocWriteRequest.OpType.UPDATE) {
            request = new Request(HttpGet.METHOD_NAME, "/_render/template");
        parameters.withTimeout(deleteRequest.timeout());
    static Request reindex(ReindexRequest reindexRequest) throws IOException {
            .withTimeout(deleteByQueryRequest.getTimeout())
            .withRequestsPerSecond(deleteByQueryRequest.getRequestsPerSecond())
                    }
                return putParam("fields", String.join(",", fields));
     * @return the {@link ContentType}
        return request;
        return request;
    static HttpEntity createEntity(ToXContent toXContent, MediaType mediaType) throws IOException {
        // the bulk, we need to check that all requests have the same content-type
import org.opensearch.action.DocWriteRequest;
                putParam("allow_no_indices", Boolean.toString(indicesOptions.allowNoIndices()));
        parameters.withIfSeqNo(indexRequest.ifSeqNo());
        Params withFields(String[] fields) {
    /**
     */
            }
                    joiner.add(part);
        parameters.withRealtime(multiGetRequest.realtime());
            request.setEntity(createEntity(fieldCapabilitiesRequest, REQUEST_BODY_CONTENT_TYPE));
        params.putParam(RestSearchAction.TYPED_KEYS_PARAM, "true");
        return request;
        // Bulk API only supports newline delimited JSON or Smile. Before executing
        parameters.withRequireAlias(updateRequest.isRequireAlias());
        }
        }
    }
            for (String part : parts) {
        params.withFields(fieldCapabilitiesRequest.fields());
            .withRequestsPerSecond(reindexRequest.getRequestsPerSecond())
    private static Request sourceRequest(GetSourceRequest getSourceRequest, String httpMethodName) {
import org.opensearch.core.xcontent.DeprecationHandler;
        if (searchRequest.pointInTimeBuilder() == null) {
        request.addParameters(params.asMap());
                .addPathPart(tvrequest.getId())
 * not use this file except in compliance with the License.
                        metadata.field("_index", action.index());
            params.putParam("scroll", searchRequest.scroll().keepAlive());
            if (CollectionUtils.isEmpty(fields) == false) {
    }
        Request request = new Request(method, endpoint(getRequest.index(), getRequest.id()));
                        }
    static String endpoint(String index, String type, String id, String endpoint) {
     *    for standard searches
        String endpoint = new EndpointBuilder().addPathPartAsIs("_scripts").addPathPart(getStoredScriptRequest.id()).build();
            if (preserveExisting) {
            return putParam("timeout", timeout);
     * Returns a {@link ContentType} from a given {@link MediaType}.
    }
        Request request = new Request(HttpPost.METHOD_NAME, endpoint);
            SearchRequest searchRequest = searchTemplateRequest.getRequest();
            return this;
import org.opensearch.action.update.UpdateRequest;
        Params withTerminateAfter(int terminateAfter) {
        Params params = new Params();
            endpoint = endpoint(indexRequest.index(), "_create", indexRequest.id());
    }
                    if (action.isRequireAlias()) {
        Params withClusterManagerTimeout(TimeValue clusterManagerTimeout) {
import org.opensearch.core.common.Strings;
        Params withParentTaskId(org.opensearch.core.tasks.TaskId parentTaskId) {
        request.setEntity(createEntity(tvrequest, REQUEST_BODY_CONTENT_TYPE));
            return this;
 *
        // set for the partial document and the upsert document. This client
        String endpoint = endpoint(explainRequest.index(), "_explain", explainRequest.id());
import org.opensearch.index.reindex.AbstractBulkByScrollRequest;
            }
                return uri.getRawPath().substring(1).replaceAll("/", "%2F");
        if (searchRequest.pointInTimeBuilder() != null) {
                return putParam("realtime", Boolean.FALSE.toString());
        Params withRequestsPerSecond(float requestsPerSecond) {
    static Request bulk(BulkRequest bulkRequest) throws IOException {
            parameters.withRequireAlias(bulkRequest.requireAlias());
        return rethrottle(rethrottleRequest, "_reindex");
            if (opType == DocWriteRequest.OpType.INDEX || opType == DocWriteRequest.OpType.CREATE) {
                return putParam("preserve_existing", Boolean.TRUE.toString());
import java.net.URISyntaxException;
            .addCommaSeparatedPathParts(types)
    }
            .withRequestsPerSecond(updateByQueryRequest.getRequestsPerSecond())
        parameters.withIfPrimaryTerm(deleteRequest.ifPrimaryTerm());
                ).toBytesRef();
     * Utility class to build request's endpoint given its parts as strings
    static Request clearScroll(ClearScrollRequest clearScrollRequest) throws IOException {
        Params params = new Params();
                withIgnoreUnavailable(indicesOptions.ignoreUnavailable());
                return putParam("retry_on_conflict", String.valueOf(retryOnConflict));
        return sourceRequest(getSourceRequest, HttpGet.METHOD_NAME);
            DocWriteRequest.OpType opType = action.opType();
    }
            return putParam("max_concurrent_shard_requests", Integer.toString(maxConcurrentShardRequests));
    static Request rethrottleReindex(RethrottleRequest rethrottleRequest) {
        if (searchRequest.scroll() != null) {
        }
        if (deleteByQueryRequest.isAbortOnVersionConflict() == false) {
    }
                            metadata.field("_source", updateRequest.fetchSource());
        request.addParameters(parameters.asMap());
        }
            if (parentTaskId != null && parentTaskId.isSet()) {
        }
        }
        }
    private static Request rethrottle(RethrottleRequest rethrottleRequest, String firstPathPart) {
        return request;
            }
    }
        for (DocWriteRequest<?> action : bulkRequest.requests()) {
            DocWriteRequest<?> action = bulkRequest.requests().get(i);
            return this;
        parameters.withVersion(getRequest.version());
            .withSlices(deleteByQueryRequest.getSlices());
            request = new Request(HttpGet.METHOD_NAME, endpoint);
                if (CollectionUtils.isEmpty(fetchSourceContext.excludes()) == false) {
                    }
        }
            return putParam("wait_for_completion", waitForCompletion.toString());
            params.putParam("scroll_size", Integer.toString(deleteByQueryRequest.getBatchSize()));
                if (Strings.hasLength(part)) {
        }
    }
        request.setEntity(createEntity(rankEvalRequest.getRankEvalSpec(), REQUEST_BODY_CONTENT_TYPE));
        }
    static Request delete(DeleteRequest deleteRequest) {
import org.opensearch.core.xcontent.XContentParser;
    static Request multiSearch(MultiSearchRequest multiSearchRequest) throws IOException {
        }
        Request req = new Request(HttpGet.METHOD_NAME, builder.build());
        }
                return putParam("doc_as_upsert", Boolean.TRUE.toString());
        Request request = new Request(HttpPost.METHOD_NAME, "/_mget");
import org.opensearch.core.xcontent.XContentBuilder;
                    )
                return putParam("wait_for_no_relocating_shards", Boolean.TRUE.toString());
            }
import org.opensearch.action.search.CreatePitRequest;
        String endpoint = endpoint(deleteRequest.index(), deleteRequest.id());
            } else if (opType == DocWriteRequest.OpType.UPDATE) {
        return request;
                URI uri = new URI(null, "", "/" + pathPart, null, null);
    }
            return this;
        parameters.withVersionType(getRequest.versionType());
        parameters.withTimeout(updateRequest.timeout());
                return putParam("actions", String.join(",", actions));
        } else {
                MediaType mediaType = indexRequest.getContentType();
    }
        parameters.withVersion(updateRequest.version());
            return putParam("cluster_manager_timeout", clusterManagerTimeout);
                content.write(separator);
        params.withPreference(searchRequest.preference());
            params.withAllowPartialResults(searchRequest.allowPartialSearchResults());
            return this;
import java.util.Map;
                putParam("ignore_throttled", Boolean.toString(indicesOptions.ignoreThrottled()));
        request.setEntity(createEntity(createPitRequest, REQUEST_BODY_CONTENT_TYPE));
        }
            builder.addPathPart(index);
                        + "] documents"
        String endpoint = endpoint(getSourceRequest.index(), "_source", getSourceRequest.id());
                        builder.copyCurrentStructure(parser);
    static String endpoint(String[] indices, String endpoint, String type) {
        XContent xContent = REQUEST_BODY_CONTENT_TYPE.xContent();
                return putParam("slices", AbstractBulkByScrollRequest.AUTO_SLICES_VALUE);
                    if (Strings.hasLength(action.id())) {
/*
                return withRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE);
            .withIndicesOptions(updateByQueryRequest.indicesOptions())
    }
                return putParam("parent_task_id", parentTaskId.toString());
import org.opensearch.index.reindex.DeleteByQueryRequest;
        request.setEntity(createEntity(putStoredScriptRequest, REQUEST_BODY_CONTENT_TYPE));
                        metadata.field("routing", action.routing());
import org.opensearch.index.rankeval.RankEvalRequest;
            addSearchRequestParams(params, searchRequest);
                // the authority must be an empty string and not null, else paths that being with slashes could have them
        params.putParam(RestSearchAction.TYPED_KEYS_PARAM, "true");
            if (includeDefaults) {
    static Request searchTemplate(SearchTemplateRequest searchTemplateRequest) throws IOException {
        return request;
        Params params = new Params();
        return new Request(HttpHead.METHOD_NAME, "/");
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            }
        Params withWaitForEvents(Priority waitForEvents) {
        EndpointBuilder addCommaSeparatedPathParts(String[] parts) {
            return this;
                content.write(metadataSource.bytes, metadataSource.offset, metadataSource.length);
        parameters.withFetchSourceContext(getRequest.fetchSourceContext());
                {
        }
        // we set "group_by" to "none" because this is the response format we can parse back
        return request;
        parameters.withVersion(indexRequest.version());
            endpoint = new EndpointBuilder().addPathPart(tvrequest.getIndex(), tvrequest.getType(), tvrequest.getId())
            return this;
                            metadata.field("pipeline", indexRequest.getPipeline());
        return request;
        // and this content-type is supported by the Bulk API.
                    bulkContentType = enforceSameContentType(updateRequest.doc(), bulkContentType);
        EndpointBuilder builder = new EndpointBuilder();
                        IndexRequest indexRequest = (IndexRequest) action;
                    "Update request cannot have different content types for doc ["
                         * copyCurrentStructure which doesn't touch the
                    }
        }
 * Unless required by applicable law or agreed to in writing,
            if (detailed) {
            }
    static Request updateByQuery(UpdateByQueryRequest updateByQueryRequest) throws IOException {
    }
        request.setEntity(createEntity(searchScrollRequest, REQUEST_BODY_CONTENT_TYPE));
    static Request mtermVectors(MultiTermVectorsRequest mtvrequest) throws IOException {
    }
                        UpdateRequest updateRequest = (UpdateRequest) action;
            return this;
        Request request = new Request(httpMethodName, endpoint);
            }
                    bulkContentType,
        Request request = new Request(HttpPost.METHOD_NAME, endpoint);
                         */
                .build();
        }
        request.setEntity(new ByteArrayEntity(content.toByteArray(), 0, content.size(), requestContentType));
 * GitHub history for details.
                return putParam(RethrottleRequest.REQUEST_PER_SECOND_PARAMETER, "-1");
                        if (Strings.hasLength(indexRequest.getPipeline())) {
        ByteArrayOutputStream content = new ByteArrayOutputStream();
        Request request = new Request(HttpPost.METHOD_NAME, endpoint);
 * The OpenSearch Contributors require contributions made to
            .addPathPart("_rethrottle")
    private RequestConverters() {
        Params parameters = new Params();
                    putParam("_source", Boolean.FALSE.toString());
    }
        Request request;
        request.addParameters(parameters.asMap());
import org.opensearch.script.mustache.MultiSearchTemplateRequest;
        request.setEntity(createEntity(multiGetRequest, REQUEST_BODY_CONTENT_TYPE));
            }
        }
        parameters.withPreference(multiGetRequest.preference());
        parameters.withIfSeqNo(deleteRequest.ifSeqNo());
        }
        Params parameters = new Params();
        }
    static Request submitUpdateByQuery(UpdateByQueryRequest updateByQueryRequest) throws IOException {
        Params withRefreshPolicy(WriteRequest.RefreshPolicy refreshPolicy) {
                }
            return this;
            if (value != null) {
        Params withFetchSourceContext(FetchSourceContext fetchSourceContext) {
import org.opensearch.cluster.health.ClusterHealthStatus;
    static final MediaType REQUEST_BODY_CONTENT_TYPE = MediaTypeRegistry.JSON;
        if (updateByQueryRequest.getBatchSize() != AbstractBulkByScrollRequest.DEFAULT_SCROLL_SIZE) {
                        metadata.field("require_alias", action.isRequireAlias());
        // Contains only status utility methods
        return request;
                    if (indicesOptions.expandWildcardsOpen()) {
        return req;
    static Request ping() {
        return request;
            }
    static Request exists(GetRequest getRequest) {
        Request request = new Request(HttpPost.METHOD_NAME, endpoint(createPitRequest.indices(), "_search/point_in_time"));
        }
import org.opensearch.action.admin.cluster.health.ClusterHealthRequest;
        }
        parameters.withRefreshPolicy(bulkRequest.getRefreshPolicy());
        return new Request(HttpGet.METHOD_NAME, "/_search/point_in_time/_all");
    static Request searchScroll(SearchScrollRequest searchScrollRequest) throws IOException {
            .withWaitForCompletion(waitForCompletion)
        params.withStoredFields(explainRequest.storedFields());
          refer to org.opensearch.action.search.SearchResponseMerger
        Params parameters = new Params();
                );
            return this;
    }
        Request request = new Request(methodName, endpoint(fieldCapabilitiesRequest.indices(), "_field_caps"));
            );
import org.opensearch.index.VersionType;
        Params withHuman(boolean human) {
     * Convert a {@linkplain SearchRequest} into a {@linkplain Request}.
        Request request = new Request(HttpGet.METHOD_NAME, "/_mtermvectors");
    }
import org.opensearch.action.fieldcaps.FieldCapabilitiesRequest;
            .build();
 * Converts OpenSearch writeable requests to an HTTP Request
    static Request get(GetRequest getRequest) {
        Params params = new Params();
                    if (versionType != VersionType.INTERNAL) {
                    joiner.add(encodePart(part));
                    + "]"
            .withRefresh(reindexRequest.isRefresh())
            return this;
        params.putParam("group_by", "none");
                return putParam("require_alias", Boolean.TRUE.toString());
        }
    static Request deleteByQuery(DeleteByQueryRequest deleteByQueryRequest) throws IOException {
        Params parameters = new Params();
            if (refreshPolicy != WriteRequest.RefreshPolicy.NONE) {
            if (Strings.hasLength(value)) {
        }
        return prepareReindexRequest(reindexRequest, false);
        }
        params.withRealtime(tvrequest.getRealtime());
        private final Map<String, String> parameters = new HashMap<>();
            params.putParam("ccs_minimize_roundtrips", Boolean.toString(searchRequest.isCcsMinimizeRoundtrips()));
     *
    @SuppressForbidden(reason = "Only allowed place to convert a MediaType to a ContentType")
                            metadata.field("retry_on_conflict", updateRequest.retryOnConflict());
            if ((mediaType != null) && (mediaType != upsertContentType)) {
            }
        params.withIndicesOptions(rankEvalRequest.indicesOptions());
        request.setEntity(createEntity(countRequest, REQUEST_BODY_CONTENT_TYPE));
        }
                    metadata.startObject(opType.getLowercase());
                String expandWildcards;
    }
        Params withAllowPartialResults(boolean allowPartialSearchResults) {
        Params withRetryOnConflict(int retryOnConflict) {
        Params withLevel(ClusterHealthRequest.Level level) {
        request.setEntity(new ByteArrayEntity(source, createContentType(xContent.mediaType())));
        Params withTaskId(org.opensearch.core.tasks.TaskId taskId) {
        }
        Request request = new Request(HttpDelete.METHOD_NAME, "/_search/scroll");
                .build();
        params.withRouting(countRequest.routing());
                        metadata.field("if_seq_no", action.ifSeqNo());
        parameters.withRetryOnConflict(updateRequest.retryOnConflict());
        }
import org.apache.hc.core5.http.ContentType;
import org.apache.hc.client5.http.classic.methods.HttpGet;
            if (CollectionUtils.isEmpty(storedFields) == false) {
                return putParam("task_id", taskId.toString());
                        + "]"
            }
            DocWriteRequest.OpType opType = action.opType();
import org.opensearch.core.xcontent.MediaTypeRegistry;
import org.opensearch.action.explain.ExplainRequest;
                return putParam("version", Long.toString(version));
    }
        }
            return this;
        params.putParam(RestCreatePitAction.ALLOW_PARTIAL_PIT_CREATION, Boolean.toString(createPitRequest.shouldAllowPartialPitCreation()));
    }
        if (updateByQueryRequest.getScrollTime() != AbstractBulkByScrollRequest.DEFAULT_SCROLL_TIMEOUT) {
                }
        return rethrottle(rethrottleRequest, "_delete_by_query");
            .build();
        parameters.withVersionType(indexRequest.versionType());
        }
            return joiner.toString();
        Params withTaskId(TaskId taskId) {
                }
            return parameters;
            .addCommaSeparatedPathParts(suffixes)
        if (deleteByQueryRequest.getMaxDocs() > 0) {
     */
                return putParam("wait_for_no_initializing_shards", Boolean.TRUE.toString());
            for (String part : parts) {
                    }
    static Request info() {
        EndpointBuilder addCommaSeparatedPathParts(List<String> parts) {
    static class EndpointBuilder {
            .withSlices(updateByQueryRequest.getSlices());
        Params withPreserveExisting(boolean preserveExisting) {
        Request request = new Request(HttpPost.METHOD_NAME, "/_msearch/template");
    }
        return request;
            if (Float.isFinite(requestsPerSecond)) {
        }
import org.opensearch.common.Nullable;
        return sourceRequest(getSourceRequest, HttpHead.METHOD_NAME);
            }
import org.opensearch.action.get.MultiGetRequest;
        }
        BytesRef source = indexRequest.source().toBytesRef();
    @Deprecated
        }
            }
            }
        request.addParameters(parameters.asMap());
        request.addParameters(params.asMap());
        params.withBatchedReduceSize(searchRequest.getBatchedReduceSize());
    static Request deleteScript(DeleteStoredScriptRequest deleteStoredScriptRequest) {
        String endpoint = new EndpointBuilder().addPathPart("_reindex").build();
            endpoint = endpoint(indexRequest.index(), indexRequest.id());
 * Licensed to Elasticsearch under one or more contributor
                }
            // the default in AbstractBulkByScrollRequest is Float.POSITIVE_INFINITY,
                ) {
            params.putParam("pre_filter_shard_size", Integer.toString(searchRequest.getPreFilterShardSize()));
        Params withIfSeqNo(long ifSeqNo) {
        } else {
        Params withRequireAlias(boolean requireAlias) {
            return this;
    static Request index(IndexRequest indexRequest) {
        String endpoint = new EndpointBuilder().addPathPart(firstPathPart)
 * compatible open source license.
    static Request deletePit(DeletePitRequest deletePitRequest) throws IOException {
            return this;
        byte[] source = MultiSearchRequest.writeMultiLineFormat(multiSearchRequest, xContent);
        }
                    + requestContentType
        ContentType contentType = createContentType(indexRequest.getContentType());
    static Request sourceExists(GetSourceRequest getSourceRequest) {
        /**
        }
        if (updateRequest.doc() != null) {
        MediaType bulkContentType = null;
        }
        return new Request(HttpGet.METHOD_NAME, "/");
            }
        parameters.withVersionType(updateRequest.versionType());
        return getStyleRequest(HttpHead.METHOD_NAME, getRequest);
        return request;
import java.net.URI;
        parameters.withVersionType(deleteRequest.versionType());
        }
        if (searchTemplateRequest.isSimulate()) {
        parameters.withRouting(bulkRequest.routing());
        if (index != null) {
                        + mediaType
        }
        parameters.withVersion(deleteRequest.version());
        }
            params.putParam("scroll", updateByQueryRequest.getScrollTime());
        }
        parameters.withIfPrimaryTerm(indexRequest.ifPrimaryTerm());
    }
            params.putParam("max_docs", Integer.toString(deleteByQueryRequest.getMaxDocs()));
        Params withRouting(String routing) {
     * a {@link Request} and adds the parameters to it directly.
import org.apache.lucene.util.BytesRef;
        return new ByteArrayEntity(source.bytes, source.offset, source.length, createContentType(mediaType));
import org.opensearch.action.index.IndexRequest;
        parameters.withPipeline(indexRequest.getPipeline());
        }
                // encode each part (e.g. index, type and id) separately before merging them into the path
        req.setEntity(createEntity(request, REQUEST_BODY_CONTENT_TYPE));
        parameters.withRouting(indexRequest.routing());
                }
            if (docAsUpsert) {
            throw new IllegalArgumentException(
            .withWaitForActiveShards(reindexRequest.getWaitForActiveShards())
        return prepareUpdateByQueryRequest(updateByQueryRequest, false);
        if (deleteByQueryRequest.getBatchSize() != AbstractBulkByScrollRequest.DEFAULT_SCROLL_SIZE) {
    private static Request prepareReindexRequest(ReindexRequest reindexRequest, boolean waitForCompletion) throws IOException {
        }
    }
            params.putParam("min_score", String.valueOf(countRequest.minScore()));
        if (requestContentType != REQUEST_BODY_CONTENT_TYPE && requestContentType != MediaTypeRegistry.fromFormat("smile")) {
 * this file be licensed under the Apache-2.0 license or a
                "Mismatching content-type found for request with content-type ["
        }
        request.setEntity(createEntity(updateRequest, mediaType));
            if (local) {
        }
                    }
            request.setEntity(createEntity(searchRequest.source(), REQUEST_BODY_CONTENT_TYPE));
import org.opensearch.action.search.SearchScrollRequest;
        }
            return this;
        return request;
                        if (updateRequest.retryOnConflict() > 0) {
        parameters.withTimeout(indexRequest.timeout());
        parameters.withRefreshPolicy(updateRequest.getRefreshPolicy());
/**
        parameters.withRefresh(getSourceRequest.refresh());
        }
            if (ifSeqNo != SequenceNumbers.UNASSIGNED_SEQ_NO) {
        request.addParameters(parameters.asMap());
        final ContentType requestContentType = createContentType(bulkContentType);
        return new EndpointBuilder().addCommaSeparatedPathParts(indices).addPathPartAsIs(endpoint).build();
    }
import java.nio.charset.Charset;
            if (indicesOptions != null) {
import org.opensearch.action.admin.cluster.storedscripts.GetStoredScriptRequest;
        String build() {
                        metadata.field("if_primary_term", action.ifPrimaryTerm());
    static Request submitReindex(ReindexRequest reindexRequest) throws IOException {
        Params params = new Params().withRouting(deleteByQueryRequest.getRouting())
    }
                            metadata.field("version_type", "external");
import org.opensearch.script.mustache.SearchTemplateRequest;
        params.withPreference(countRequest.preference());
                    if (indicesOptions.expandWildcardsClosed()) {
        Request request = new Request(HttpGet.METHOD_NAME, endpoint(rankEvalRequest.indices(), Strings.EMPTY_ARRAY, "_rank_eval"));
            .toBytesRef();
        // The Java API allows update requests with different content types
        byte[] source = MultiSearchTemplateRequest.writeMultiLineFormat(multiSearchTemplateRequest, xContent);
            }
        }
import org.opensearch.search.fetch.subphase.FetchSourceContext;
        if (updateRequest.upsertRequest() != null) {
            }
        }
        Params withRefresh(boolean refresh) {
     * @return the {@link IndexRequest}'s content type
        Params withWaitForNodes(String waitForNodes) {
        }
            return withWaitForActiveShards(activeShardCount, ActiveShardCount.DEFAULT);
        params.withIndicesOptions(countRequest.indicesOptions());
        String endpoint = new EndpointBuilder().addPathPartAsIs("_scripts").addPathPart(putStoredScriptRequest.id()).build();
        return request;
    }
        }
                }
    }
        parameters.withWaitForActiveShards(updateRequest.waitForActiveShards());
        Request request = new Request(HttpPost.METHOD_NAME, "/_search/scroll");
        if (fieldCapabilitiesRequest.indexFilter() != null) {
                // translate to "auto" value in rest request so the receiving end doesn't throw error
                return putParam("refresh", refreshPolicy.getValue());
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.common.unit.TimeValue;
        return request;
        }
    }
            if (human) {
        Params withIfPrimaryTerm(long ifPrimaryTerm) {
        Request request = new Request(HttpPost.METHOD_NAME, "/_msearch");
        parameters.withRequireAlias(indexRequest.isRequireAlias());
          Merging search responses as part of CCS flow to reduce roundtrips is not supported for point in time -
     */
        parameters.withRouting(getSourceRequest.routing());
        Request request = new Request(HttpPost.METHOD_NAME, "/_bulk");
    }
        Map<String, String> asMap() {
import org.opensearch.common.xcontent.XContentHelper;
                        mediaType
                        + " and upsert ["
        parameters.withRealtime(getSourceRequest.realtime());
        // only accepts update requests that have the same content types set
            params.putParam("conflicts", "proceed");
        Params withActions(List<String> actions) {
                        metadata.field("_id", action.id());
            try {
            }
    @Deprecated
import org.apache.hc.client5.http.classic.methods.HttpPut;
                if (indicesOptions.expandWildcardsOpen() == false && indicesOptions.expandWildcardsClosed() == false) {
     */
                if (fetchSourceContext.fetchSource() == false) {
                metadata.endObject();
            }
 * Modifications Copyright OpenSearch Contributors. See
            return putParam("request_cache", Boolean.toString(requestCache));
            if (versionType != VersionType.INTERNAL) {
            return this;
        return request;
        Params withWaitForCompletion(Boolean waitForCompletion) {
        request.setEntity(new ByteArrayEntity(source.bytes, source.offset, source.length, contentType));
import org.opensearch.action.search.MultiSearchRequest;
        if (searchRequest.source() != null) {
        }
        }
 * ownership. Elasticsearch licenses this file to you under
            if (actions != null && actions.size() > 0) {
        request.addParameters(params.asMap());
                        joiner.add("closed");
        for (int i = 0; i < bulkRequest.numberOfActions(); i++) {
import org.opensearch.client.core.TermVectorsRequest;
        Params putParam(String key, TimeValue value) {
                    }
                    + mediaType
            addPathPart(String.join(",", parts));
        params.withRouting(searchRequest.routing());
final class RequestConverters {
    }
            mediaType = updateRequest.doc().getContentType();
        XContent xContent = REQUEST_BODY_CONTENT_TYPE.xContent();
            return this;
        Params withPipeline(String pipeline) {
    }
 * software distributed under the License is distributed on an
                // paths that start with `-` or contain `:`
                return putParam("stored_fields", String.join(",", storedFields));
            if (refresh) {
            }
import org.opensearch.index.reindex.UpdateByQueryRequest;
        String endpoint = endpoint(updateByQueryRequest.indices(), "_update_by_query");
        Params withBatchedReduceSize(int batchedReduceSize) {
        parameters.withWaitForActiveShards(deleteRequest.waitForActiveShards());
                if (updateRequest.doc() != null) {
                putParam("expand_wildcards", expandWildcards);
            params.putParam("context", putStoredScriptRequest.context());
                return putParam("parent_task_id", parentTaskId.toString());
/*
        Params withActions(String[] actions) {
        if (deleteByQueryRequest.getScrollTime() != AbstractBulkByScrollRequest.DEFAULT_SCROLL_TIMEOUT) {
 * license agreements. See the NOTICE file distributed with
     * @param mediaType the {@link MediaType}
                            metadata.field("version_type", "external_gte");
        parameters.withRefreshPolicy(deleteRequest.getRefreshPolicy());
    }
        request.addParameters(parameters.asMap());
                // we prepend "/" to the path part to make this path absolute, otherwise there can be issues with
    }
        @Deprecated
        return request;
        Params params = new Params();
        return new EndpointBuilder().addCommaSeparatedPathParts(indices)
            } else if (opType == DocWriteRequest.OpType.UPDATE) {
                }
    static Request deleteAllPits() {
import org.opensearch.common.Priority;
        parameters.withRefresh(multiGetRequest.refresh());
        parameters.withRefreshPolicy(indexRequest.getRefreshPolicy());
        request.setEntity(createEntity(deletePitRequest, REQUEST_BODY_CONTENT_TYPE));
        parameters.withRouting(updateRequest.routing());
import org.opensearch.action.support.IndicesOptions;
        request.addParameters(params.asMap());
        return request;
            if (activeShardCount != null && activeShardCount != defaultActiveShardCount) {
        return request;
                try (
            return this;
        params.withPreference(tvrequest.getPreference());
        params.withClusterManagerTimeout(getStoredScriptRequest.clusterManagerNodeTimeout());
        return new EndpointBuilder().addCommaSeparatedPathParts(indices)
                        }
    static String endpoint(String index, String id) {
        parameters.withPreference(getSourceRequest.preference());
            }
            }
            }
                    + requestContentType
        Request request = new Request(HttpPost.METHOD_NAME, endpoint);
            if (requireAlias) {
                parameters.put(name, value);
        request.setEntity(new ByteArrayEntity(source, createContentType(xContent.mediaType())));
import org.opensearch.action.admin.cluster.storedscripts.DeleteStoredScriptRequest;
                .addPathPartAsIs("_termvectors")
        }
    }
            mediaType = REQUEST_BODY_CONTENT_TYPE;
import java.io.ByteArrayOutputStream;
        Params() {}
    }
        String index = request.index();
            if (waitNoRelocatingShards) {
        return new EndpointBuilder().addPathPart(index, MapperService.SINGLE_MAPPING_NAME, id).build();
                }
            request.addParameters(params.asMap());
        }
            .withTimeout(updateByQueryRequest.getTimeout())
            .withWaitForActiveShards(deleteByQueryRequest.getWaitForActiveShards())
    static String endpoint(String[] indices, String[] types, String endpoint) {
        }
import org.opensearch.action.get.GetRequest;
import java.util.List;
        Params params = new Params();
                    false
            return putParam("terminate_after", String.valueOf(terminateAfter));
    static Request prepareUpdateByQueryRequest(UpdateByQueryRequest updateByQueryRequest, boolean waitForCompletion) throws IOException {
            return putParam("wait_for_nodes", waitForNodes);
