        return this;
            xContentBuilder.field("index", request.indices());
            }  
            }
            assert res >= 0;  
        if (this == o) return true;
 */  
            BytesReference bytes = data.slice(from, nextMarker - from);
        ActionRequestValidationException validationException = null;
            }
        int size = in.readVInt();
    public ActionRequestValidationException validate() {
    public int hashCode() {
            if (ccsMinimizeRoundtrips != null) {
    public Task createTask(long id, String type, String action, TaskId parentTaskId, Map<String, String> headers) {
        return maxConcurrentSearchRequests == that.maxConcurrentSearchRequests
        for (SearchRequest request : requests) {
            if (ex != null) {
            @Override  
            }
/**
    }
            // move pointers
        if (from != data.length()) {  
        xContentBuilder.field("ccs_minimize_roundtrips", request.isCcsMinimizeRoundtrips());
    public MultiSearchRequest indicesOptions(IndicesOptions indicesOptions) {
        String routing,  
            xContentBuilder.field("allow_partial_search_results", request.allowPartialSearchResults());
        return new CancellableTask(id, type, action, "", parentTaskId, headers) {
     * Returns the amount of search requests specified in this multi search requests are allowed to be ran concurrently.
import org.opensearch.core.common.io.stream.StreamInput;
        }
                        } else if ("search_type".equals(entry.getKey()) || "searchType".equals(entry.getKey())) {  
 * this work for additional information regarding copyright
                    validationException = new ActionRequestValidationException();
            }
     * same order as the search requests.  
                            allowNoIndices = value;
     * Add a search request to execute. Note, the order is important, the search response will be returned in the
                            }  
        return indicesOptions;
            validationException = addValidationError("no requests added", validationException);
 *
import org.opensearch.core.xcontent.XContentBuilder;
            if (indicesOptions != null) {
    @Override  
                try (
                            searchRequest.setCcsMinimizeRoundtrips(nodeBooleanValue(value));  
                            searchRequest.allowPartialSearchResults(nodeBooleanValue(value, null));
                validationException.addValidationErrors(ex.validationErrors());  
            xContentBuilder.field("preference", request.preference());
import static org.opensearch.common.xcontent.support.XContentMapValues.nodeStringValue;
            nextMarker = findNextMarker(marker, from, data);
package org.opensearch.action.search;
 *
    public static final int MAX_CONCURRENT_SEARCH_REQUESTS_DEFAULT = 0;
        }
import org.opensearch.core.xcontent.XContentParser;  
                break;  
                XContentParser parser = xContent.createParser(registry, LoggingDeprecationHandler.INSTANCE, stream)
import org.opensearch.tasks.CancellableTask;
/*
            }
                searchRequest.indicesOptions(indicesOptions);  
import org.opensearch.action.support.IndicesOptions;
        super(in);
        if (o == null || getClass() != o.getClass()) return false;  
            request.writeTo(out);
                    xContentBuilder.startObject();  
                            if (!allowExplicitIndex) {
 * You may obtain a copy of the License at  
import org.opensearch.core.xcontent.NamedXContentRegistry;
            // now parse the action  
            && Objects.equals(indicesOptions, that.indicesOptions);
            int nextMarker = findNextMarker(marker, from, data);
    }
        }
import org.opensearch.common.xcontent.LoggingDeprecationHandler;  
            }
    public MultiSearchRequest(StreamInput in) throws IOException {
            @Override
            xContentBuilder.field("request_cache", request.requestCache());
            if (indices != null && indices.length > 0) {
                            searchRequest.requestCache(nodeBooleanValue(value, entry.getKey()));
        ByteArrayOutputStream output = new ByteArrayOutputStream();
import org.opensearch.core.xcontent.ToXContent;  
                    request.source().toXContent(xContentBuilder, ToXContent.EMPTY_PARAMS);
                        ignoreUnavailable,
                        } else if ("request_cache".equals(entry.getKey()) || "requestCache".equals(entry.getKey())) {
        int from = 0;
                } else {
            WildcardStates.toXContent(request.indicesOptions().getExpandWildcards(), xContentBuilder);
import static org.opensearch.action.ValidateActions.addValidationError;
                    );
    }
            }
            }
        if (requests.isEmpty()) {  
        }
        return -1;  
import static org.opensearch.common.xcontent.support.XContentMapValues.nodeBooleanValue;  
                            expandWildcards = value;
                        allowNoIndices,
 * SPDX-License-Identifier: Apache-2.0
            // support first line with \n
            + '}';  
                searchRequest.indices(indices);  
     * Add a search request to execute. Note, the order is important, the search response will be returned in the
    }
import org.opensearch.core.xcontent.XContent;
 *  
            throw new IllegalArgumentException("maxConcurrentSearchRequests must be positive");
                continue;
    private final List<SearchRequest> requests = new ArrayList<>();
                    "multi_search_empty_first_line",  
                        ignoreThrottled,  
            if (nextMarker == -1) {
        return "MultiSearchRequest{"
                    Map<String, Object> source = parser.map();  
        super.writeTo(out);
        BytesReference data,
                                searchRequest.setCancelAfterTimeInterval(nodeTimeValue(value, null));
                }
 * Unless required by applicable law or agreed to in writing,
        for (int i = 0; i < size; i++) {
        if (request.requestCache() != null) {  
        if (res != -1) {
        }  
    }
 * The OpenSearch Contributors require contributions made to  
        CheckedBiConsumer<SearchRequest, XContentParser, IOException> consumer,  
 * ownership. Elasticsearch licenses this file to you under  
                        } else if ("ignore_throttled".equals(entry.getKey()) || "ignoreThrottled".equals(entry.getKey())) {  
import java.util.Objects;
            }  
            public boolean shouldCancelChildrenOnCancellation() {  
    private int maxConcurrentSearchRequests = 0;  
import org.opensearch.action.ActionRequestValidationException;
        return output.toByteArray();
    @Override  
            from = nextMarker + 1;
 * GitHub history for details.
                                throw new IllegalArgumentException("explicit index in multi search is not allowed");  
                from = nextMarker + 1;
            if (searchRequest.source() != null && searchRequest.source().pipeline() != null) {
            if (nextMarker == -1) {
            output.write(xContent.streamSeparator());
                    Object ignoreUnavailable = null;
        String searchType,
public class MultiSearchRequest extends ActionRequest implements CompositeIndicesRequest {
                BytesReference.bytes(xContentBuilder).writeTo(output);  
        return this;
        out.writeVInt(maxConcurrentSearchRequests);
    public MultiSearchRequest add(SearchRequestBuilder request) {
                        } else if ("ignore_unavailable".equals(entry.getKey()) || "ignoreUnavailable".equals(entry.getKey())) {
        maxConcurrentSearchRequests = in.readVInt();  
            }
import java.util.Locale;  
                consumer.accept(searchRequest, parser);
        }
 * software distributed under the License is distributed on an
                        Object value = entry.getValue();  
    public static byte[] writeMultiLineFormat(MultiSearchRequest multiSearchRequest, XContent xContent) throws IOException {  
    public static void writeSearchRequestParams(SearchRequest request, XContentBuilder xContentBuilder) throws IOException {
 * under the License.  
                        defaultOptions
            searchRequest.indicesOptions(defaultOptions);
        if (request.searchType() != null) {
                                searchRequest.setPhaseTook(nodeBooleanValue(value));  
            if (routing != null) {
        xContentBuilder.endObject();  
 * KIND, either express or implied.  See the License for the
        if (request.preference() != null) {  
    /**
        if (maxConcurrentSearchRequests < 1) {  
            SearchRequest searchRequest = new SearchRequest();
 * Licensed to Elasticsearch under one or more contributor  
        boolean allowExplicitIndex,
            ) {  
                }  
            + indicesOptions
    @Override
 */  
        this.indicesOptions = indicesOptions;  
        final int res = data.indexOf(marker, from);
    }
 * this file be licensed under the Apache-2.0 license or a
    }
    @Override
            ActionRequestValidationException ex = requests.get(i).validate();
                writeSearchRequestParams(request, xContentBuilder);
    public static void readMultiLineFormat(  
import static org.opensearch.common.xcontent.support.XContentMapValues.nodeTimeValue;  
                        } else if ("expand_wildcards".equals(entry.getKey()) || "expandWildcards".equals(entry.getKey())) {  
                    }
import java.util.Map;
                deprecationLogger.deprecate(
                    "support for empty first line before any action metadata in msearch API is deprecated and "
                InputStream stream = bytes.streamInput();
            + requests  
        }
import java.io.InputStream;  
            try (XContentBuilder xContentBuilder = XContentBuilder.builder(xContent)) {
            output.write(xContent.streamSeparator());
    public String toString() {
     * Sets how many search requests specified in this multi search requests are allowed to be ran concurrently.  
                        expandWildcards,  
    private IndicesOptions indicesOptions = IndicesOptions.strictExpandOpenAndForbidClosedIgnoreThrottled();  
                        } else if ("cancel_after_time_interval".equals(entry.getKey())
                        if ("index".equals(entry.getKey()) || "indices".equals(entry.getKey())) {
                );  
    public MultiSearchRequest maxConcurrentSearchRequests(int maxConcurrentSearchRequests) {
            }
    }
@PublicApi(since = "1.0.0")
            IndicesOptions defaultOptions = searchRequest.indicesOptions();
import org.opensearch.action.support.IndicesOptions.WildcardStates;
    public int maxConcurrentSearchRequests() {
        }
        return this;
                searchRequest.pipeline(searchRequest.source().pipeline());
        }
import java.io.IOException;
    }
    private static int findNextMarker(byte marker, int from, BytesReference data) {  
                            searchRequest.routing(nodeStringValue(value, null));  
                            ignoreThrottled = value;
        for (SearchRequest request : multiSearchRequest.requests()) {
 * the Apache License, Version 2.0 (the "License"); you may
        if (request.getCancelAfterTimeInterval() != null) {  
import java.util.List;
                            } else if ("phase_took".equals(entry.getKey())) {
 */
                break;  
            if (nextMarker == 0) {  
    }  
        }
                            searchRequest.searchType(nodeStringValue(value, null));
import org.opensearch.common.CheckedBiConsumer;  
/*  
import org.opensearch.core.tasks.TaskId;
            + maxConcurrentSearchRequests
 * compatible open source license.
                            searchRequest.indices(nodeStringArrayValue(value));
 */  
        return Objects.hash(maxConcurrentSearchRequests, requests, indicesOptions);  
    @Override  
    public void writeTo(StreamOutput out) throws IOException {  
            + ", indicesOptions="
            }
 * Modifications Copyright OpenSearch Contributors. See
    }  
                BytesReference.bytes(xContentBuilder).writeTo(output);
     */
                    Object expandWildcards = null;
            from = nextMarker + 1;
                    XContentParser parser = xContent.createParser(registry, LoggingDeprecationHandler.INSTANCE, stream)
                        } else if ("preference".equals(entry.getKey())) {  
            && Objects.equals(requests, that.requests)  
        }  
import org.opensearch.core.common.io.stream.StreamOutput;  
    /**
            }
        xContentBuilder.startObject();
                searchRequest.routing(routing);  
    public IndicesOptions indicesOptions() {
        NamedXContentRegistry registry,  
 * @opensearch.api
                        } else if ("routing".equals(entry.getKey())) {
    public MultiSearchRequest add(SearchRequest request) {
        if (request.routing() != null) {  
        }
            xContentBuilder.field("allow_no_indices", request.indicesOptions().allowNoIndices());  
        IndicesOptions indicesOptions,
    }
    }
import java.io.ByteArrayOutputStream;
            public String getDescription() {
        }
        Boolean ccsMinimizeRoundtrips,
     */
                ) {
    }
        requests.add(request.request());  
    @Override  
                    defaultOptions = IndicesOptions.fromParameters(
}
                    Object allowNoIndices = null;
            try (  
                                throw new IllegalArgumentException("key [" + entry.getKey() + "] is not supported in the metadata section");
    /**
            xContentBuilder.field("routing", request.routing());
     * same order as the search requests.  
                if (request.source() != null) {  
        }
    /**
            throw new IllegalArgumentException("The msearch request must be terminated by a newline [\n]");
                    Object ignoreThrottled = null;  
    }
            if (searchType != null) {
import org.opensearch.tasks.Task;
                searchRequest.searchType(searchType);  
        return maxConcurrentSearchRequests;
     */
        return validationException;
        }
        }
            + ", requests="
import static org.opensearch.common.xcontent.support.XContentMapValues.nodeStringArrayValue;
                            ignoreUnavailable = value;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            return res;
                return true;
        if (request.indicesOptions() != null && request.indicesOptions() != SearchRequest.DEFAULT_INDICES_OPTIONS) {  
                        } else if ("ccs_minimize_roundtrips".equals(entry.getKey()) || "ccsMinimizeRoundtrips".equals(entry.getKey())) {
            if (nextMarker - from > 0) {
            + "maxConcurrentSearchRequests="  
        requests.add(request);  
import org.opensearch.core.common.bytes.BytesReference;
        };  
import java.util.stream.Collectors;  
        if (request.indices() != null) {  
                        + "will be removed in the next major version"
                        } else if ("allow_partial_search_results".equals(entry.getKey())) {
        DeprecationLogger deprecationLogger
    }  
                            } else {
    ) throws IOException {  
        XContent xContent,
            requests.add(request);
import org.opensearch.action.ActionRequest;
            xContentBuilder.field("ignore_unavailable", request.indicesOptions().ignoreUnavailable());
        String[] indices,
    public boolean equals(Object o) {
     */  
        while (true) {  
        this.maxConcurrentSearchRequests = maxConcurrentSearchRequests;
        out.writeVInt(requests.size());  
/*  
        if (request.allowPartialSearchResults() != null) {  
import java.util.ArrayList;
                    InputStream stream = data.slice(from, nextMarker - from).streamInput();  
    }  
import org.opensearch.action.CompositeIndicesRequest;  
 * not use this file except in compliance with the License.
            xContentBuilder.field("cancel_after_time_interval", request.getCancelAfterTimeInterval().getStringRep());
 *
        }  
            // now for the body  
        return this;
            // move pointers
                            || "cancelAfterTimeInterval".equals(entry.getKey())) {  
        byte marker = xContent.streamSeparator();
        for (int i = 0; i < requests.size(); i++) {  
                }
        return this.requests;  
            }  
        MultiSearchRequest that = (MultiSearchRequest) o;
    public MultiSearchRequest() {}
            SearchRequest request = new SearchRequest(in);  
        if (request.isPhaseTook() != null) {  
 * specific language governing permissions and limitations
                            }
                        } else if ("allow_no_indices".equals(entry.getKey()) || "allowNoIndices".equals(entry.getKey())) {
                searchRequest.setCcsMinimizeRoundtrips(ccsMinimizeRoundtrips);  
        }
            xContentBuilder.field("phase_took", request.isPhaseTook());
import org.opensearch.common.annotation.PublicApi;
 * A multi search API request.  
                if (validationException == null) {  
import org.opensearch.common.logging.DeprecationLogger;
 * license agreements. See the NOTICE file distributed with
            }
    public List<SearchRequest> requests() {
                            searchRequest.preference(nodeStringValue(value, null));
                    xContentBuilder.endObject();
    }
            xContentBuilder.field("search_type", request.searchType().name().toLowerCase(Locale.ROOT));  
 *     http://www.apache.org/licenses/LICENSE-2.0
                return requests.stream().map(SearchRequest::buildDescription).collect(Collectors.joining(action + "[", ",", "]"));
                    for (Map.Entry<String, Object> entry : source.entrySet()) {
            try (XContentBuilder xContentBuilder = XContentBuilder.builder(xContent)) {  
