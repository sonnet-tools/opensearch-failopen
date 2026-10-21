     * same order as the search requests.
import org.opensearch.tasks.Task;
    public ActionRequestValidationException validate() {
        return validationException;
import java.util.Map;
        maxConcurrentSearchRequests = in.readVInt();
            if (nextMarker - from > 0) {
            }
                consumer.accept(searchRequest, parser);
    }
    @Override
    }
    public void writeTo(StreamOutput out) throws IOException {
    }
        }
                try (
@PublicApi(since = "1.0.0")
            }
    }
        out.writeVInt(requests.size());
                            } else if ("phase_took".equals(entry.getKey())) {
            validationException = addValidationError("no requests added", validationException);
    public MultiSearchRequest indicesOptions(IndicesOptions indicesOptions) {
        }
import org.opensearch.core.common.io.stream.StreamOutput;
import org.opensearch.core.common.io.stream.StreamInput;
                ) {
            ActionRequestValidationException ex = requests.get(i).validate();
            xContentBuilder.field("phase_took", request.isPhaseTook());
import static org.opensearch.common.xcontent.support.XContentMapValues.nodeStringArrayValue;
                                searchRequest.setCancelAfterTimeInterval(nodeTimeValue(value, null));
            if (indicesOptions != null) {
import org.opensearch.core.xcontent.NamedXContentRegistry;
import java.io.InputStream;
            }
                            searchRequest.routing(nodeStringValue(value, null));
                    xContentBuilder.endObject();
        for (int i = 0; i < requests.size(); i++) {
            }
                searchRequest.indices(indices);
            IndicesOptions defaultOptions = searchRequest.indicesOptions();
            xContentBuilder.field("allow_partial_search_results", request.allowPartialSearchResults());
    public int hashCode() {
import java.util.Locale;
                        } else if ("request_cache".equals(entry.getKey()) || "requestCache".equals(entry.getKey())) {
    /**
            WildcardStates.toXContent(request.indicesOptions().getExpandWildcards(), xContentBuilder);
        if (res != -1) {
            if (ccsMinimizeRoundtrips != null) {
            }
import org.opensearch.tasks.CancellableTask;
    /**
        if (request.routing() != null) {
            }
 * this file be licensed under the Apache-2.0 license or a
/*
            request.writeTo(out);
    }
 * specific language governing permissions and limitations
            + indicesOptions
            // move pointers
import org.opensearch.core.xcontent.XContent;
 * this work for additional information regarding copyright
                    xContentBuilder.startObject();
import static org.opensearch.action.ValidateActions.addValidationError;
     */
import org.opensearch.core.xcontent.XContentParser;
 * ownership. Elasticsearch licenses this file to you under
                    "multi_search_empty_first_line",
            // now parse the action
     */
    }
                continue;
 * Licensed to Elasticsearch under one or more contributor
        if (request.indicesOptions() != null && request.indicesOptions() != SearchRequest.DEFAULT_INDICES_OPTIONS) {
/*
            throw new IllegalArgumentException("maxConcurrentSearchRequests must be positive");
 * Modifications Copyright OpenSearch Contributors. See
    @Override
                break;
            output.write(xContent.streamSeparator());
            xContentBuilder.field("search_type", request.searchType().name().toLowerCase(Locale.ROOT));
        }
                }
                    for (Map.Entry<String, Object> entry : source.entrySet()) {
                );
                        } else if ("ccs_minimize_roundtrips".equals(entry.getKey()) || "ccsMinimizeRoundtrips".equals(entry.getKey())) {
        }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
import org.opensearch.action.support.IndicesOptions;
        int from = 0;
        for (SearchRequest request : requests) {
                searchRequest.routing(routing);
    }
            + ", indicesOptions="
        if (maxConcurrentSearchRequests < 1) {
                            searchRequest.searchType(nodeStringValue(value, null));
            }
                        } else if ("ignore_throttled".equals(entry.getKey()) || "ignoreThrottled".equals(entry.getKey())) {
                            if (!allowExplicitIndex) {
        CheckedBiConsumer<SearchRequest, XContentParser, IOException> consumer,
        requests.add(request.request());
            public boolean shouldCancelChildrenOnCancellation() {
 * KIND, either express or implied.  See the License for the
                InputStream stream = bytes.streamInput();
                BytesReference.bytes(xContentBuilder).writeTo(output);
    private static int findNextMarker(byte marker, int from, BytesReference data) {
                            searchRequest.setCcsMinimizeRoundtrips(nodeBooleanValue(value));
        return "MultiSearchRequest{"
 * You may obtain a copy of the License at
     * Sets how many search requests specified in this multi search requests are allowed to be ran concurrently.
            }
                    );
 * Unless required by applicable law or agreed to in writing,
 * The OpenSearch Contributors require contributions made to
    @Override
        }
                if (validationException == null) {
        if (requests.isEmpty()) {
                            ignoreUnavailable = value;
        for (SearchRequest request : multiSearchRequest.requests()) {
                writeSearchRequestParams(request, xContentBuilder);
                            }
import java.util.List;
import org.opensearch.core.xcontent.ToXContent;
                            || "cancelAfterTimeInterval".equals(entry.getKey())) {
                        } else if ("routing".equals(entry.getKey())) {
                    request.source().toXContent(xContentBuilder, ToXContent.EMPTY_PARAMS);
                        ignoreThrottled,
                            searchRequest.preference(nodeStringValue(value, null));
        }
    }
                    InputStream stream = data.slice(from, nextMarker - from).streamInput();
                if (request.source() != null) {
                }
        xContentBuilder.endObject();
            }
 * SPDX-License-Identifier: Apache-2.0
        Boolean ccsMinimizeRoundtrips,
    public static byte[] writeMultiLineFormat(MultiSearchRequest multiSearchRequest, XContent xContent) throws IOException {
 * A multi search API request.
                return true;
        if (o == null || getClass() != o.getClass()) return false;
        String[] indices,
    ) throws IOException {
        return this;
                    Object ignoreThrottled = null;
        IndicesOptions indicesOptions,
import org.opensearch.action.CompositeIndicesRequest;
/*
        if (request.isPhaseTook() != null) {
            return res;
    private final List<SearchRequest> requests = new ArrayList<>();
            xContentBuilder.field("routing", request.routing());
        return indicesOptions;
            }
        }
            if (nextMarker == 0) {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
    private int maxConcurrentSearchRequests = 0;
            ) {
        return this;
                        defaultOptions
        return this;
        };
                        } else if ("preference".equals(entry.getKey())) {
                    Object ignoreUnavailable = null;
 *
                    XContentParser parser = xContent.createParser(registry, LoggingDeprecationHandler.INSTANCE, stream)
        return new CancellableTask(id, type, action, "", parentTaskId, headers) {
                        } else if ("expand_wildcards".equals(entry.getKey()) || "expandWildcards".equals(entry.getKey())) {
                BytesReference.bytes(xContentBuilder).writeTo(output);
        while (true) {
            try (XContentBuilder xContentBuilder = XContentBuilder.builder(xContent)) {
     * Returns the amount of search requests specified in this multi search requests are allowed to be ran concurrently.
                        ignoreUnavailable,
        String routing,
        if (request.allowPartialSearchResults() != null) {
import static org.opensearch.common.xcontent.support.XContentMapValues.nodeStringValue;
    }
            + ", requests="
            requests.add(request);
                from = nextMarker + 1;
            int nextMarker = findNextMarker(marker, from, data);
                searchRequest.pipeline(searchRequest.source().pipeline());
import org.opensearch.common.xcontent.LoggingDeprecationHandler;
import static org.opensearch.common.xcontent.support.XContentMapValues.nodeTimeValue;
                        if ("index".equals(entry.getKey()) || "indices".equals(entry.getKey())) {
        super.writeTo(out);
    }
            throw new IllegalArgumentException("The msearch request must be terminated by a newline [\n]");
        }
        return this;
            @Override
                searchRequest.searchType(searchType);
import org.opensearch.core.tasks.TaskId;
import org.opensearch.core.xcontent.XContentBuilder;
        return Objects.hash(maxConcurrentSearchRequests, requests, indicesOptions);
                searchRequest.setCcsMinimizeRoundtrips(ccsMinimizeRoundtrips);
                            searchRequest.indices(nodeStringArrayValue(value));
                searchRequest.indicesOptions(indicesOptions);
    public static void writeSearchRequestParams(SearchRequest request, XContentBuilder xContentBuilder) throws IOException {
        if (from != data.length()) {
package org.opensearch.action.search;
        MultiSearchRequest that = (MultiSearchRequest) o;
                        expandWildcards,
            && Objects.equals(indicesOptions, that.indicesOptions);
                    "support for empty first line before any action metadata in msearch API is deprecated and "
            xContentBuilder.field("preference", request.preference());
            // support first line with \n
            }
        }
                            } else {
                            ignoreThrottled = value;
            if (indices != null && indices.length > 0) {
        this.indicesOptions = indicesOptions;
            from = nextMarker + 1;
            try (
            + maxConcurrentSearchRequests
        if (request.getCancelAfterTimeInterval() != null) {
    public static final int MAX_CONCURRENT_SEARCH_REQUESTS_DEFAULT = 0;
 *
        for (int i = 0; i < size; i++) {
            assert res >= 0;
                        } else if ("allow_no_indices".equals(entry.getKey()) || "allowNoIndices".equals(entry.getKey())) {
    public int maxConcurrentSearchRequests() {
            SearchRequest request = new SearchRequest(in);
                        Object value = entry.getValue();
            BytesReference bytes = data.slice(from, nextMarker - from);
            from = nextMarker + 1;
    public MultiSearchRequest maxConcurrentSearchRequests(int maxConcurrentSearchRequests) {
        return maxConcurrentSearchRequests == that.maxConcurrentSearchRequests
/**
                    }
        return maxConcurrentSearchRequests;
        return this.requests;
                    Object allowNoIndices = null;
        return output.toByteArray();
                } else {
            }
        requests.add(request);
    public static void readMultiLineFormat(
            xContentBuilder.field("cancel_after_time_interval", request.getCancelAfterTimeInterval().getStringRep());
            // now for the body
                        } else if ("allow_partial_search_results".equals(entry.getKey())) {
            + requests
                        allowNoIndices,
    /**
    }
            SearchRequest searchRequest = new SearchRequest();
        int size = in.readVInt();
import java.util.stream.Collectors;
        if (request.searchType() != null) {
        final int res = data.indexOf(marker, from);
            xContentBuilder.field("request_cache", request.requestCache());
    }
    public MultiSearchRequest add(SearchRequest request) {
        }
    }
        }
        }
     */
            if (searchRequest.source() != null && searchRequest.source().pipeline() != null) {
                            searchRequest.requestCache(nodeBooleanValue(value, entry.getKey()));
            if (searchType != null) {
            if (ex != null) {
import org.opensearch.common.CheckedBiConsumer;
            @Override
            output.write(xContent.streamSeparator());
 * the Apache License, Version 2.0 (the "License"); you may
    public IndicesOptions indicesOptions() {
            && Objects.equals(requests, that.requests)
 */
    @Override
                return requests.stream().map(SearchRequest::buildDescription).collect(Collectors.joining(action + "[", ",", "]"));
                            searchRequest.allowPartialSearchResults(nodeBooleanValue(value, null));
 * @opensearch.api
                        } else if ("search_type".equals(entry.getKey()) || "searchType".equals(entry.getKey())) {
        DeprecationLogger deprecationLogger
        ActionRequestValidationException validationException = null;
                        } else if ("ignore_unavailable".equals(entry.getKey()) || "ignoreUnavailable".equals(entry.getKey())) {
        out.writeVInt(maxConcurrentSearchRequests);
                    defaultOptions = IndicesOptions.fromParameters(
            if (routing != null) {
        NamedXContentRegistry registry,
        super(in);
            if (nextMarker == -1) {
            nextMarker = findNextMarker(marker, from, data);
        }
                break;
import java.util.Objects;
            + '}';
import org.opensearch.action.ActionRequest;
            + "maxConcurrentSearchRequests="
                                throw new IllegalArgumentException("key [" + entry.getKey() + "] is not supported in the metadata section");
    }
            }
        }
 * GitHub history for details.
        this.maxConcurrentSearchRequests = maxConcurrentSearchRequests;
                }
        }
    }
import org.opensearch.action.support.IndicesOptions.WildcardStates;
            public String getDescription() {
                            allowNoIndices = value;
        XContent xContent,
        String searchType,
    public List<SearchRequest> requests() {
     * Add a search request to execute. Note, the order is important, the search response will be returned in the
            if (nextMarker == -1) {
        }
    public String toString() {
import org.opensearch.common.annotation.PublicApi;
 *
import java.io.ByteArrayOutputStream;
    @Override
        xContentBuilder.field("ccs_minimize_roundtrips", request.isCcsMinimizeRoundtrips());
public class MultiSearchRequest extends ActionRequest implements CompositeIndicesRequest {
                XContentParser parser = xContent.createParser(registry, LoggingDeprecationHandler.INSTANCE, stream)
        return -1;
    @Override
 * under the License.
 */
import org.opensearch.common.logging.DeprecationLogger;
            xContentBuilder.field("ignore_unavailable", request.indicesOptions().ignoreUnavailable());
            }
            xContentBuilder.field("allow_no_indices", request.indicesOptions().allowNoIndices());
                                throw new IllegalArgumentException("explicit index in multi search is not allowed");
import java.util.ArrayList;
import org.opensearch.action.ActionRequestValidationException;
        if (this == o) return true;
                            expandWildcards = value;
 * license agreements. See the NOTICE file distributed with
 * not use this file except in compliance with the License.
}
 * software distributed under the License is distributed on an
    }
        if (request.indices() != null) {
     * Add a search request to execute. Note, the order is important, the search response will be returned in the
        }
        BytesReference data,
    }
import org.opensearch.core.common.bytes.BytesReference;
import static org.opensearch.common.xcontent.support.XContentMapValues.nodeBooleanValue;
     * same order as the search requests.
                        + "will be removed in the next major version"
            }
    public boolean equals(Object o) {
import java.io.IOException;
        if (request.requestCache() != null) {
        xContentBuilder.startObject();
                                searchRequest.setPhaseTook(nodeBooleanValue(value));
 */
                deprecationLogger.deprecate(
                            }
        byte marker = xContent.streamSeparator();
 * compatible open source license.
            xContentBuilder.field("index", request.indices());
                    Map<String, Object> source = parser.map();
                validationException.addValidationErrors(ex.validationErrors());
            }
    public MultiSearchRequest add(SearchRequestBuilder request) {
 */
        boolean allowExplicitIndex,
    }
    public MultiSearchRequest() {}
    public MultiSearchRequest(StreamInput in) throws IOException {
                        } else if ("cancel_after_time_interval".equals(entry.getKey())
                    validationException = new ActionRequestValidationException();
            searchRequest.indicesOptions(defaultOptions);
                    Object expandWildcards = null;
    public Task createTask(long id, String type, String action, TaskId parentTaskId, Map<String, String> headers) {
            // move pointers
     */
    /**
        if (request.preference() != null) {
    private IndicesOptions indicesOptions = IndicesOptions.strictExpandOpenAndForbidClosedIgnoreThrottled();
 *
            try (XContentBuilder xContentBuilder = XContentBuilder.builder(xContent)) {
        }
 *     http://www.apache.org/licenses/LICENSE-2.0
