            if (source != null) {
            cancelAfterTimeInterval,
    /**
                }
    /**
 *
    /**
    private static final long DEFAULT_ABSOLUTE_START_MILLIS = -1;
    /**
/*
     * Such requests will not be finally reduced, so that their results can be merged together in one response at completion.
    }
        }
 * under the License.
    @Override
     * If set, will enable scrolling of the search request.
        return searchType(SearchType.fromString(searchType));
            && Objects.equals(source, that.source)
    private Boolean phaseTook = null;
 * software distributed under the License is distributed on an
                    );
                validationException = addValidationError(
            && Objects.equals(routing, that.routing)
        allowPartialSearchResults = in.readOptionalBoolean();
    }
     * @param absoluteStartMillis the absolute start time to be used on the remote clusters to ensure that the same value is used
     * Returns whether the reduction phase that will be performed needs to be final or not.
     * A value of {@code 0} means the user has not explicitly set this parameter.
 * ownership. Elasticsearch licenses this file to you under
    @Override
            : source.trackTotalHitsUpTo() == null ? SearchContext.DEFAULT_TRACK_TOTAL_HITS_UP_TO
    /**
     */
    @Override
    @ExperimentalApi
    }
                }
     */
    }
    public static int resolveTrackTotalHitsUpTo(Scroll scroll, SearchSourceBuilder source) {
     * will default to the cluster level setting).
    public SearchRequest(SearchRequest searchRequest) {
            }
     * cluster can be throttled with this number to reduce the cluster load. The default is {@code 5}
    }
     * Deep clone a SearchRequest
            phaseTook = in.readOptionalBoolean();
            sb.append("source[]");
        return maxConcurrentShardRequests == 0 ? 5 : maxConcurrentShardRequests;
     * @return true if the request only has suggest
        return scroll(new Scroll(TimeValue.parseTimeValue(keepAlive, null, getClass().getSimpleName() + ".Scroll.keepAlive")));
            out.writeOptionalBoolean(phaseTook);
    @Nullable
            + "}";
    public int getBatchedReduceSize() {
                    validationException = addValidationError("using [rescore] is not allowed in a scroll context", validationException);
            + preFilterShardSize
        }
            && Objects.equals(pipeline, that.pipeline)
        validateIndices(indices);
    public String[] indices() {
    private SearchType searchType = SearchType.DEFAULT;
            throw new IllegalArgumentException("batchedReduceSize must be >= 2");
    public void setCcsMinimizeRoundtrips(boolean ccsMinimizeRoundtrips) {
     */
    }
    }
            + '\''
     * the search request expands to exceeds the threshold. This filter roundtrip can limit the number of shards significantly if for
     */
            }
                    "duplicate _shard_doc sort detected. Specify it at most once.",
            finalReduce = true;
        }
            }
    }
 * </p>
    ) {
        SearchRequest searchRequest,
        sb.append("], ");
        this.phaseTook = searchRequest.phaseTook;
    @Override
            + ", indicesOptions="
     * Returns the raw value of maxConcurrentShardRequests without applying the default.
            // no matter what the value of track_total_hits is
    public final String buildDescription() {
 * this work for additional information regarding copyright
        requestCache = in.readOptionalBoolean();
        this.preference = preference;
 * Note, the search {@link #source(org.opensearch.search.builder.SearchSourceBuilder)}
     */
        return this;
        this.source = source;
            return SearchContext.TRACK_TOTAL_HITS_ACCURATE;
     * <li>The request targets one or more read-only index</li>
    /**
    public static final IndicesOptions DEFAULT_INDICES_OPTIONS = IndicesOptions.strictExpandOpenAndForbidClosedIgnoreThrottled();
        this.finalReduce = true;
     * Returns a threshold that enforces a pre-filter roundtrip to pre-filter search shards based on query rewriting if the number of shards
            localClusterAlias,
                    "_shard_doc is only supported with point-in-time (PIT). Add a PIT or remove _shard_doc.",
            out.writeVLong(absoluteStartMillis);
        }
     * protection mechanism to reduce the memory overhead per search request if the potential number of shards in the request can be large.
        this.pipeline = pipeline;
     */
        return false;
    ) {
import org.opensearch.common.annotation.PublicApi;
    }
    public boolean isCcsMinimizeRoundtrips() {
            && Objects.equals(localClusterAlias, that.localClusterAlias)
                validationException = addValidationError(
        if (scroll != null) {
        if (o == null || getClass() != o.getClass()) {
    }
 * @opensearch.api
        if (preFilterShardSize < 1) {
                if (source.size() == 0) {
import org.opensearch.Version;
     * cluster can be throttled with this number to reduce the cluster load. The default is {@code 5}
        } else {
     * Defaults to <code>true</code>.
import java.util.Collections;
     * <p>
                sb.append("<error: ").append(ex.getMessage()).append(">");
    public IndicesOptions indicesOptions() {
        return finalReduce;
            + ", getOrCreateAbsoluteStartMillis="
            final boolean hasPit = pointInTimeBuilder() != null;
        this.preference = searchRequest.preference;
    }
            if (shardDocCount > 0 && !hasPit) {
        this.ccsMinimizeRoundtrips = ccsMinimizeRoundtrips;
        if (maxConcurrentShardRequests < 1) {
        }
            phaseTook
            sb.append("source[");
import org.opensearch.common.unit.TimeValue;
     * will be used across different requests.
    public static final int DEFAULT_BATCHED_REDUCE_SIZE = 512;
            out.writeStringArray(Strings.EMPTY_ARRAY);
    /**
    }
@PublicApi(since = "1.0.0")
     * The a string representation search type to execute, defaults to {@link SearchType#DEFAULT}. Can be
     * "query_then_fetch"/"queryThenFetch", and "query_and_fetch"/"queryAndFetch".
     * This filter roundtrip can limit the number of shards significantly if for
        this.requestCache = searchRequest.requestCache;
import java.util.Objects;
}
    public SearchRequest searchType(SearchType searchType) {
    /**
                if (source.from() > 0) {
        out.writeVInt(batchedReduceSize);
        if (scroll) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            && Objects.equals(cancelAfterTimeInterval, that.cancelAfterTimeInterval)
     * If set, will enable scrolling of the search request.
     * @param originalSearchRequest the original search request
        this.requestCache = requestCache;
        this.allowPartialSearchResults = searchRequest.allowPartialSearchResults;
        boolean scroll = scroll() != null;
    @Override
import org.opensearch.action.ActionRequest;
        if (sb instanceof FieldSortBuilder) {
    }
        }
    private IndicesOptions indicesOptions = DEFAULT_INDICES_OPTIONS;
        return localClusterAlias;
     * Constructs a new search request against the provided indices with the given search source.
                sb.append(source.toString(FORMAT_PARAMS));
        this.finalReduce = finalReduce;
        String[] indices,
 *
            + ", preFilterShardSize="
            + ", pipeline="
    public SearchType searchType() {
            out.writeOptionalString(pipeline);
            && ccsMinimizeRoundtrips == that.ccsMinimizeRoundtrips
            maxConcurrentShardRequests,
    private TimeValue cancelAfterTimeInterval;
        sb.append("search_type[").append(searchType).append("], ");
            allowPartialSearchResults,
            // types not supported so send an empty array to previous versions
     */
        this.indices = indices;
        out.writeVInt(maxConcurrentShardRequests);
        return new SearchRequest(originalSearchRequest, indices, clusterAlias, absoluteStartMillis, finalReduce);
    /**
     */
     * mechanism to reduce the memory overhead per search request if the potential number of shards in the request can be large.
            + batchedReduceSize
    }
            throw new IllegalArgumentException("preFilterShardSize must be >= 1");
    public SearchRequest scroll(TimeValue keepAlive) {
        return sb.toString();
    }
            && Objects.equals(indicesOptions, that.indicesOptions)
        String clusterAlias,
 * A request to execute search against one or more indices (or all). Best created using
/*
    @Override
        return this;
     * Sets value of phase_took query param if provided by user. Defaults to <code>null</code>.
                    validationException = addValidationError("using [from] is not allowed in a scroll context", validationException);
            throw new IllegalArgumentException("source must not be null");
        this.indicesOptions = searchRequest.indicesOptions;
     * <li>The primary sort of the query targets an indexed field</li>
        this.maxConcurrentShardRequests = maxConcurrentShardRequests;
            return ShardDocSortBuilder.NAME.equals(((FieldSortBuilder) sb).getFieldName());
        long absoluteStartMillis,
            Arrays.hashCode(indices),
        return "SearchRequest{"
            searchRequest.finalReduce
        }
        this.searchType = searchRequest.searchType;
    }
import org.opensearch.core.tasks.TaskId;
    /**
            + ccsMinimizeRoundtrips
        this.routing = routing;
        this.cancelAfterTimeInterval = searchRequest.cancelAfterTimeInterval;
            + ", localClusterAlias="
     * Returns the number of shard results that should be reduced at once on the coordinating node. This value should be used as a
     */
            sb.append("]");
    }
        return absoluteStartMillis == DEFAULT_ABSOLUTE_START_MILLIS ? System.currentTimeMillis() : absoluteStartMillis;
     * <ul>
    }
            // types no longer relevant so ignore
        return this;
 *     http://www.apache.org/licenses/LICENSE-2.0
        out.writeBoolean(ccsMinimizeRoundtrips);
import org.opensearch.common.Nullable;
    }
                validationException = addValidationError("using [point in time] is not allowed in a scroll context", validationException);
    }
    public Boolean allowPartialSearchResults() {
        out.writeOptionalTimeValue(cancelAfterTimeInterval);
    public String preference() {
    public PointInTimeBuilder pointInTimeBuilder() {
            + ", requestCache="
     * example, if "now" is used, it will never be cached). By default (not set, or null,
            if (requestCache != null && requestCache) {
        if (absoluteStartMillis < 0) {
            preFilterShardSize,
        }
     * Creates a new sub-search request starting from the original search request that is provided.
    }
    /**
 * specific language governing permissions and limitations
    /**
     * bounds and the query are disjoint.
    public static final int DEFAULT_PRE_FILTER_SHARD_SIZE = 128;
        for (String index : indices) {
        return absoluteStartMillis;
            String[] types = in.readStringArray();
     * </ul>
        Objects.requireNonNull(indices, "indices must not be null");
import org.opensearch.search.sort.ShardDocSortBuilder;
            + ", preference='"
    private String[] indices = Strings.EMPTY_ARRAY;
    private Integer preFilterShardSize;
     * Constructs a new search request from the provided search request
 *
    /**
import java.util.Arrays;
        indices(indices);
            + ", indices="
    private String preference;
 * SPDX-License-Identifier: Apache-2.0
    }
    /**
    public void setPhaseTook(Boolean phaseTook) {
        this.writeTo(out);
    public SearchRequest deepCopy() throws IOException {
 * @see Requests#searchRequest(String...)
     */
            + preference
 * not use this file except in compliance with the License.
            && Objects.equals(scroll, that.scroll)
    public void setCancelAfterTimeInterval(TimeValue cancelAfterTimeInterval) {
import org.opensearch.search.sort.FieldSortBuilder;
     */
    }
    @Override
    }
        Objects.requireNonNull(clusterAlias, "cluster alias must not be null");
    /**
    }
        if (batchedReduceSize <= 1) {
        out.writeOptionalString(preference);
     * A comma separated list of routing values to control the shards the search will be executed on.
     */
 * <p>
            searchRequest.absoluteStartMillis,
        if (localClusterAlias != null) {
            return true;
            && Objects.equals(batchedReduceSize, that.batchedReduceSize)
        preFilterShardSize = in.readOptionalVInt();
            + allowPartialSearchResults
     * If set, will enable scrolling of the search request for the specified timeout.
    public int hashCode() {
     * will default to the index level setting if request cache is enabled or not).
    /**
        this.source = searchRequest.source;
            + ", source="
     */
     */
        if (source != null) {
        return indicesOptions;
            finalReduce = in.readBoolean();
    public void setPreFilterShardSize(int preFilterShardSize) {
    public TimeValue getCancelAfterTimeInterval() {
                    validationException
        this(indices, new SearchSourceBuilder());
        this.indicesOptions = Objects.requireNonNull(indicesOptions, "indicesOptions must not be null");
     * Returns value of user-provided phase_took query parameter for this search request.
        return batchedReduceSize;
     */
        ccsMinimizeRoundtrips = in.readBoolean();
     * the provided current time, otherwise it will return {@link System#currentTimeMillis()}.
                );
    }
     * If set, will enable scrolling of the search request for the specified timeout.
import org.opensearch.action.ActionRequestValidationException;
            && Arrays.equals(indices, that.indices)
    public SearchRequest indices(String... indices) {
import org.opensearch.core.xcontent.ToXContent;
            }
            + "searchType="
        this.ccsMinimizeRoundtrips = searchRequest.ccsMinimizeRoundtrips;
        out.writeStringArray(indices);
    }
    /**
     * <p>
        return this;
            + searchType
        StringBuilder sb = new StringBuilder();
        }
        out.writeOptionalString(routing);
    public void writeTo(StreamOutput out) throws IOException {
    }
    }
                }
    public SearchRequest(String... indices) {
    }
     */
    public SearchRequest() {
     * Sets if this request should use the request cache or not, assuming that it can (for
        this.allowPartialSearchResults = allowPartialSearchResults;
        Objects.requireNonNull(originalSearchRequest, "search request must not be null");
            absoluteStartMillis = in.readVLong();
        }
        scroll = in.readOptionalWriteable(Scroll::new);
     * Returns the number of shard requests that should be executed concurrently on a single node. This value should be used as a
                }
        }
        preference = in.readOptionalString();
    boolean isFinalReduce() {
        return indices;
    public SearchTask createTask(long id, String type, String action, TaskId parentTaskId, Map<String, String> headers) {
     */
            indicesOptions,
        validateIndices(indices);
 * Modifications Copyright OpenSearch Contributors. See
        }
        if (source != null) {
            + absoluteStartMillis
        if (in.getVersion().onOrAfter(Version.V_2_12_0)) {
     * bounds and the query are disjoint.
import org.opensearch.core.common.io.stream.StreamOutput;
            + '\''
    public SearchRequest source(SearchSourceBuilder sourceBuilder) {
 */
    private final String localClusterAlias;
                if (isShardDocSort(sb)) shardDocCount++;
    public SearchRequest routing(String routing) {
            Objects.requireNonNull(index, "index must not be null");
 * @see SearchResponse
     */
            searchRequest.localClusterAlias,
        return this.routing;
     * When unspecified, the pre-filter phase is executed if any of these conditions is met:
    private final boolean finalReduce;
     */
        return this;
        this.source = Objects.requireNonNull(sourceBuilder, "source must not be null");
        if (source != null) {
            && Objects.equals(maxConcurrentShardRequests, that.maxConcurrentShardRequests)
     * Returns whether network round-trips should be minimized when executing cross-cluster search requests.
     */
    /**
     * protection mechanism to reduce the number of shard requests fired per high level search request. Searches that hit the entire
    }
            + routing
        ActionRequestValidationException validationException = null;
    /**
 *
        }
    }
        this.routing = searchRequest.routing;
     *
     * The search source to execute.
            sb.append("scroll[").append(scroll.keepAlive()).append("], ");
        long absoluteStartMillis,
        out.writeOptionalBoolean(requestCache);
            absoluteStartMillis,
    public int getMaxConcurrentShardRequests() {
        BytesStreamOutput out = new BytesStreamOutput();
     * {@code _local} to prefer local shards, {@code _primary} to execute only on primary shards,
            int shardDocCount = 0;
    }
    public Integer getPreFilterShardSize() {
    }
    /**
    private boolean ccsMinimizeRoundtrips = true;
        indicesOptions = IndicesOptions.readIndicesOptions(in);
     */
 * the Apache License, Version 2.0 (the "License"); you may
        this.absoluteStartMillis = absoluteStartMillis;
        StreamInput in = out.bytes().streamInput();
     * @param indices the indices to search against
    /**
        return scroll(new Scroll(keepAlive));
        Strings.arrayToDelimitedString(indices, ",", sb);
        return this.allowPartialSearchResults;
    private int maxConcurrentShardRequests = 0;
    @Override
        routing = in.readOptionalString();
     * performing reduction on each cluster in order to minimize network round-trips between the coordinating node and the remote clusters.
        );
            }
                        validationException
                validationException = addValidationError(
     * A comma separated list of routing values to control the shards the search will be executed on.
        this.routing = Strings.arrayToCommaDelimitedString(routings);
        return Objects.hash(
    public SearchRequest searchType(String searchType) {
        if (out.getVersion().onOrAfter(Version.V_2_12_0)) {
/**
    private final long absoluteStartMillis;
     */
     * or a custom value, which guarantees that the same order
     * Sets a threshold that enforces a pre-filter roundtrip to pre-filter search shards based on query rewriting if the number of shards
        sb.append("indices[");
            + phaseTook
 */
 * Unless required by applicable law or agreed to in writing,
            searchRequest,
        this.maxConcurrentShardRequests = searchRequest.maxConcurrentShardRequests;
    /**
            + ", batchedReduceSize="
            && Objects.equals(preFilterShardSize, that.preFilterShardSize)
    public void setBatchedReduceSize(int batchedReduceSize) {
    /**
            + ", routing='"
        }
            routing,
    public SearchRequest scroll(Scroll scroll) {
    private static boolean isShardDocSort(SortBuilder<?> sb) {
     */
     */
    /**
     */
                if (source.trackTotalHitsUpTo() != null && source.trackTotalHitsUpTo() != SearchContext.TRACK_TOTAL_HITS_ACCURATE) {
 * You may obtain a copy of the License at
     * The indices
    public boolean isSuggestOnly() {
            return source.pointInTimeBuilder();
            absoluteStartMillis = DEFAULT_ABSOLUTE_START_MILLIS;
 * The OpenSearch Contributors require contributions made to
     * <li>The request targets more than 128 shards</li>
    }
 * Licensed to Elasticsearch under one or more contributor
    @Nullable
        this.searchType = Objects.requireNonNull(searchType, "searchType must not be null");
     * one of "dfs_query_then_fetch"/"dfsQueryThenFetch", "dfs_query_and_fetch"/"dfsQueryAndFetch",
    private String routing;
        maxConcurrentShardRequests = in.readVInt();
            batchedReduceSize,
     * The source of the search request.
            throw new IllegalArgumentException("absoluteStartMillis must not be negative but was [" + absoluteStartMillis + "]");
     * Sets the indices the search will be executed on.
    /**
        indicesOptions.writeIndicesOptions(out);
                    "types are no longer supported in search requests but found [" + Arrays.toString(types) + "]"
     * instance a shard can not match any documents based on its rewrite method ie. if date filters are mandatory to match but the shard
    }
     * -1 otherwise.
        boolean finalReduce
     * Returns the current time in milliseconds from the time epoch, to be used for the execution of this search request. Used to
    }
            if (source.aggregations() != null) {
            preference,
     * Sets whether network round-trips should be minimized when executing cross-cluster search requests. Defaults to <code>true</code>.
            : source.trackTotalHitsUpTo();
    public SearchRequest preference(String preference) {
            + ", ccsMinimizeRoundtrips="
     * The routing values to control the shards that the search will be executed on.
        if (scroll != null) {
                    validationException
import org.opensearch.search.builder.SearchSourceBuilder;
package org.opensearch.action.search;
    public SearchRequest routing(String... routings) {
            + ", scroll="
     * Constructs a new search request from reading the specified stream.
        return phaseTook;
        super.writeTo(out);
        return preFilterShardSize;
        this.preFilterShardSize = preFilterShardSize;
    public SearchRequest scroll(String keepAlive) {
     */
    }
     * protection mechanism to reduce the number of shard requests fired per high level search request. Searches that hit the entire
     * Returns the provided <code>absoluteStartMillis</code> when created through {@link #subSearchRequest} and
            }
    /**
     * Sets if this request should allow partial results. (If method is not called,
        if (out.getVersion().onOrAfter(Version.V_2_7_0)) {
    public static final ToXContent.Params FORMAT_PARAMS = new ToXContent.MapParams(Collections.singletonMap("pretty", "false"));
        }
    @Nullable
        out.writeByte(searchType.id());
    private static void validateIndices(String... indices) {
                validationException = source.aggregations().validate(validationException);
     */
    public long getOrCreateAbsoluteStartMillis() {
        return this.requestCache;
    /**
        }
/*
 * GitHub history for details.
        this.batchedReduceSize = batchedReduceSize;
        return searchType == that.searchType
        return source;
        }
     * Returns the alias of the cluster that this search request is being executed on. A non-null value indicates that this search request
    public boolean includeDataStreams() {
            + cancelAfterTimeInterval
    public Scroll scroll() {
     * @param clusterAlias the alias to prefix index names with in the returned search results
     *
import org.opensearch.search.Scroll;
        out.writeOptionalString(localClusterAlias);
    public String pipeline() {
            for (SortBuilder<?> sb : source.sorts()) {
    }
        return this;
    String getLocalClusterAlias() {
     * the search request expands to exceeds the threshold, or <code>null</code> if the threshold is unspecified.
     *
        }
        out.writeOptionalVInt(preFilterShardSize);
        searchType = SearchType.fromId(in.readByte());
                if (source.rescores() != null && source.rescores().isEmpty() == false) {
     * @param in The stream the request is read from
     * <li>The primary sort of the query targets an indexed field</li>
import org.opensearch.common.annotation.ExperimentalApi;
        }
    public int getMaxConcurrentShardRequestsRaw() {
     * <li>The request targets one or more read-only index</li>
            pipeline = in.readOptionalString();
            + ", phaseTook="
            searchRequest.indices,
     * ensure that the same value, determined by the coordinating node, is used on all nodes involved in the execution of the search
     * For internal use only, allows to fork a search request into multiple search requests that will be executed independently.
import java.util.Map;
    private Boolean allowPartialSearchResults;
        if (pointInTimeBuilder() != null) {
     */
                        "disabling [track_total_hits] is not allowed in a scroll context",
        this.scroll = searchRequest.scroll;
        } else {
        this.batchedReduceSize = searchRequest.batchedReduceSize;
        );
    }
        return resolveTrackTotalHitsUpTo(scroll, source);
                );
import org.opensearch.action.support.IndicesOptions;
                    validationException = addValidationError("[size] cannot be [0] in a scroll context", validationException);
                    validationException
        if (localClusterAlias != null) {
        SearchRequest originalSearchRequest,
     */
        batchedReduceSize = in.readVInt();
    /**
            && Objects.equals(preference, that.preference)
    public String toString() {
     */
    }
        if (in.getVersion().before(Version.V_2_0_0)) {
    public SearchRequest(StreamInput in) throws IOException {
            requestCache,
        boolean finalReduce
    private int batchedReduceSize = DEFAULT_BATCHED_REDUCE_SIZE;
     */
import org.opensearch.action.IndicesRequest;
                );
    static SearchRequest subSearchRequest(
        if (sb instanceof ShardDocSortBuilder) return true;
    }
     * returned as part of search hits with the alias of the cluster they came from.
        }
            try {
            + ", allowPartialSearchResults="
        return new SearchRequest(in);
 */
     */
            && Objects.equals(allowPartialSearchResults, that.allowPartialSearchResults)
    /**
 * license agreements. See the NOTICE file distributed with
 * compatible open source license.
            + requestCache
        return new SearchTask(id, type, action, this::buildDescription, parentTaskId, headers, cancelAfterTimeInterval);
     * Sets the preference to execute the search. Defaults to randomize across shards. Can be set to
    /**
        // _shard_doc validation
            ccsMinimizeRoundtrips,
        return this;
     * Used when a {@link SearchRequest} is created and executed as part of a cross-cluster search request
            source,
    }
        return this;
     * The search type to execute, defaults to {@link SearchType#DEFAULT}.
    }
    /**
    }
        cancelAfterTimeInterval = in.readOptionalTimeValue();
        return ccsMinimizeRoundtrips;
        }
        out.writeOptionalWriteable(scroll);
        SearchRequest that = (SearchRequest) o;
    private Boolean requestCache;
 */
        String[] indices,
    public SearchRequest allowPartialSearchResults(boolean allowPartialSearchResults) {
     * is being executed as part of a locally reduced cross-cluster search request. The cluster alias is used to prefix index names
    /**
    /**
        }
        return pipeline;
import org.opensearch.OpenSearchException;
            if (shardDocCount > 1) {
    }
        localClusterAlias = in.readOptionalString();
        out.writeOptionalWriteable(source);
            && Objects.equals(requestCache, that.requestCache)
        }
 *
    }
        return this.preference;
    /**
import org.opensearch.transport.client.Client;
    public int resolveTrackTotalHitsUpTo() {
        }
import org.opensearch.search.internal.SearchContext;
import org.opensearch.core.common.io.stream.StreamInput;
            }
        this.cancelAfterTimeInterval = cancelAfterTimeInterval;
        return true;
    }
    }
     * <ul>
    public SearchSourceBuilder source() {
            out.writeBoolean(finalReduce);
     */
     */
            searchType,
    public SearchRequest(String[] indices, SearchSourceBuilder source) {
     */
    public String routing() {
                );
        return this;
    }
    }
     * @throws IOException if there is an issue reading the stream
    /**
    /**
     * Constructs a new search request against the indices. No indices provided here means that search
    public Boolean requestCache() {
            } catch (final OpenSearchException ex) {
import org.opensearch.search.sort.SortBuilder;
            + maxConcurrentShardRequests
        this.phaseTook = phaseTook;
     * will run against all indices.
    }
    public Boolean isPhaseTook() {
        return null;
    }
        if (source == null) {
                validationException = addValidationError("[request_cache] cannot be used in a scroll context", validationException);
            + pipeline
    public SearchRequest pipeline(String pipeline) {
        this(
    }
import java.io.IOException;
        this.absoluteStartMillis = DEFAULT_ABSOLUTE_START_MILLIS;
    private SearchSourceBuilder source;
     * @return a copy of the current SearchRequest
            if (shardDocCount > 0 && scroll) {
            }
import static org.opensearch.action.ValidateActions.addValidationError;
        source = in.readOptionalWriteable(SearchSourceBuilder::new);
            + source
        if (out.getVersion().before(Version.V_2_0_0)) {
    }
import org.opensearch.transport.client.Requests;
            return false;
    public SearchRequest requestCache(Boolean requestCache) {
    }
public class SearchRequest extends ActionRequest implements IndicesRequest.Replaceable {
        return source != null && source.isSuggestOnly();
    }
        String localClusterAlias,
    }
            }
        return searchType;
     * When unspecified, the pre-filter phase is executed if any of these conditions is met:
        this.preFilterShardSize = searchRequest.preFilterShardSize;
     * @param finalReduce whether the reduction should be final or not
            && Objects.equals(phaseTook, that.phaseTook);
     * Sets the number of shard results that should be reduced at once on the coordinating node. This value should be used as a protection
        indices = in.readStringArray();
import org.opensearch.common.io.stream.BytesStreamOutput;
        return this;
        this.localClusterAlias = localClusterAlias;
    /**
            + ", maxConcurrentShardRequests="
    }
        super(in);
    public SearchRequest indicesOptions(IndicesOptions indicesOptions) {
 * this file be licensed under the Apache-2.0 license or a
    private Scroll scroll;
        return validationException;
    private String pipeline;
        return this;
     * instance a shard can not match any documents based on its rewrite method ie. if date filters are mandatory to match but the shard
    }
    /**
    }
     * </ul>
            && absoluteStartMillis == that.absoluteStartMillis
     */
        this.scroll = scroll;
     */
                    validationException = addValidationError(
     * <li>The request targets more than 128 shards</li>
import org.opensearch.core.common.Strings;
        return cancelAfterTimeInterval;
                throw new IllegalStateException(
        this();
    public void setMaxConcurrentShardRequests(int maxConcurrentShardRequests) {
     */
        this.indices = indices;
 * is required. The search source is the different search options, including aggregations and such.
        }
            + scroll
            + localClusterAlias
     * The type of search to execute.
                    "_shard_doc cannot be used with scroll. Use PIT + search_after instead.",
        this.localClusterAlias = null;
     */
     * Sets the number of shard requests that should be executed concurrently on a single node. This value should be used as a
        if (this == o) {
    public ActionRequestValidationException validate() {
        return scroll;
    long getAbsoluteStartMillis() {
            + indicesOptions
            + Arrays.toString(indices)
            throw new IllegalArgumentException("maxConcurrentShardRequests must be >= 1");
    }
            }
        if (in.getVersion().onOrAfter(Version.V_2_7_0)) {
    @Nullable
            + ", cancelAfterTimeInterval="
        return maxConcurrentShardRequests;
 * @see Client#search(SearchRequest)
    }
    /**
     * request. When created through {@link #subSearchRequest(SearchRequest, String[], String, long, boolean)}, this method returns
    private SearchRequest(
    @Override
            if (scroll) {
        out.writeOptionalBoolean(allowPartialSearchResults);
    @Override
        return source == null ? SearchContext.DEFAULT_TRACK_TOTAL_HITS_UP_TO
 * {@link Requests#searchRequest(String...)}.
            if (types.length > 0) {
    public boolean equals(Object o) {
        if (source != null && source.sorts() != null && !source.sorts().isEmpty()) {
import org.opensearch.search.builder.PointInTimeBuilder;
 * KIND, either express or implied.  See the License for the
            scroll,
