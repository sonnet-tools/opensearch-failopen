            }
        out.writeOptionalString(localClusterAlias);
            + ", routing='"
    }
                }  
            + ", requestCache="
    }
    public SearchRequest routing(String... routings) {
                        validationException
     * Returns the provided <code>absoluteStartMillis</code> when created through {@link #subSearchRequest} and
        );  
            throw new IllegalArgumentException("maxConcurrentShardRequests must be >= 1");
        source = in.readOptionalWriteable(SearchSourceBuilder::new);
    @Override
        if (source != null && source.sorts() != null && !source.sorts().isEmpty()) {  
     * When unspecified, the pre-filter phase is executed if any of these conditions is met:
    /**
    /**
    private boolean ccsMinimizeRoundtrips = true;
    /**  
        }
        out.writeVInt(batchedReduceSize);  
     * <p>
        ccsMinimizeRoundtrips = in.readBoolean();
            return true;  
     * Returns value of user-provided phase_took query parameter for this search request.
 * ownership. Elasticsearch licenses this file to you under  
                validationException = source.aggregations().validate(validationException);
     */
            Objects.requireNonNull(index, "index must not be null");
        this.routing = routing;
    }  
     */
            + ", allowPartialSearchResults="
        return batchedReduceSize;
            ccsMinimizeRoundtrips,
    public SearchRequest allowPartialSearchResults(boolean allowPartialSearchResults) {  
     */
    public int getMaxConcurrentShardRequestsRaw() {  
    private Boolean requestCache;
     */
            + ", ccsMinimizeRoundtrips="
    private final String localClusterAlias;
     */  
                if (source.size() == 0) {
 * {@link Requests#searchRequest(String...)}.
            + source
    public SearchRequest source(SearchSourceBuilder sourceBuilder) {  
        this.cancelAfterTimeInterval = cancelAfterTimeInterval;
        this.source = searchRequest.source;
            && Objects.equals(cancelAfterTimeInterval, that.cancelAfterTimeInterval)  
        sb.append("], ");
                    validationException = addValidationError(
    }  
    private String[] indices = Strings.EMPTY_ARRAY;
        this.indices = indices;
    }
    }  
        this.phaseTook = searchRequest.phaseTook;
            + ccsMinimizeRoundtrips  
            + "searchType="
    }
     * Constructs a new search request against the indices. No indices provided here means that search
    private IndicesOptions indicesOptions = DEFAULT_INDICES_OPTIONS;  
    public SearchSourceBuilder source() {
    /**
    public SearchRequest scroll(TimeValue keepAlive) {
        SearchRequest searchRequest,
    private Boolean allowPartialSearchResults;
     */
            + ", getOrCreateAbsoluteStartMillis="  
 * The OpenSearch Contributors require contributions made to  
    /**  
    public boolean includeDataStreams() {
        if (localClusterAlias != null) {
    public final String buildDescription() {
     * If set, will enable scrolling of the search request for the specified timeout.
 *
        out.writeOptionalBoolean(allowPartialSearchResults);  
     * </ul>
        SearchRequest originalSearchRequest,
 * specific language governing permissions and limitations
            // types no longer relevant so ignore
        }
    }
        if (o == null || getClass() != o.getClass()) {
        if (scroll != null) {  
            if (shardDocCount > 0 && !hasPit) {
     */  
     * <li>The primary sort of the query targets an indexed field</li>
        return this;  
 * license agreements. See the NOTICE file distributed with
    public int getBatchedReduceSize() {  
            + ", indices="  
        SearchRequest that = (SearchRequest) o;
            if (shardDocCount > 0 && scroll) {
    }
        maxConcurrentShardRequests = in.readVInt();  
    }  
        return phaseTook;
/*  
     * or a custom value, which guarantees that the same order
        if (scroll != null) {
            + '\''  
     */
        }
     * Returns a threshold that enforces a pre-filter roundtrip to pre-filter search shards based on query rewriting if the number of shards  
    public static int resolveTrackTotalHitsUpTo(Scroll scroll, SearchSourceBuilder source) {
        return null;
            return source.pointInTimeBuilder();
        return this;
            batchedReduceSize,
     */
        super(in);
        routing = in.readOptionalString();
    public SearchRequest searchType(SearchType searchType) {
        long absoluteStartMillis,
            + phaseTook
    }
     */
    }
        } else {
     * Deep clone a SearchRequest  
                }  
        out.writeOptionalTimeValue(cancelAfterTimeInterval);
 * Note, the search {@link #source(org.opensearch.search.builder.SearchSourceBuilder)}  
 * KIND, either express or implied.  See the License for the
        this.requestCache = requestCache;  
    }  
        this.finalReduce = true;
    /**
import org.opensearch.core.common.io.stream.StreamOutput;
            + routing
        for (String index : indices) {  
    private static final long DEFAULT_ABSOLUTE_START_MILLIS = -1;  
        this.batchedReduceSize = batchedReduceSize;
     */  
    }  
    public SearchRequest(SearchRequest searchRequest) {
    }
/*
    @Override
            && Objects.equals(pipeline, that.pipeline)
        }  
        if (out.getVersion().onOrAfter(Version.V_2_12_0)) {
import org.opensearch.common.annotation.ExperimentalApi;
        this.absoluteStartMillis = DEFAULT_ABSOLUTE_START_MILLIS;
     */  
     * @param absoluteStartMillis the absolute start time to be used on the remote clusters to ensure that the same value is used  
            + ", preference='"
     */  
     * Constructs a new search request from the provided search request  
        this.writeTo(out);  
            + indicesOptions  
        this.searchType = Objects.requireNonNull(searchType, "searchType must not be null");
        if (pointInTimeBuilder() != null) {
    public String pipeline() {
     * <ul>
        this.pipeline = pipeline;  
     * A comma separated list of routing values to control the shards the search will be executed on.
        return this;  
                sb.append("<error: ").append(ex.getMessage()).append(">");  
            && Objects.equals(indicesOptions, that.indicesOptions)
    }
    @ExperimentalApi
    }
            + preference
     * protection mechanism to reduce the memory overhead per search request if the potential number of shards in the request can be large.
        this();  
        this.searchType = searchRequest.searchType;
        String localClusterAlias,
     * Sets if this request should use the request cache or not, assuming that it can (for
}
    }
     * -1 otherwise.  
import org.opensearch.search.Scroll;
            sb.append("scroll[").append(scroll.keepAlive()).append("], ");
    public String preference() {  
     * <ul>
     * @param finalReduce whether the reduction should be final or not
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.common.io.stream.BytesStreamOutput;
                    validationException
        StreamInput in = out.bytes().streamInput();
        this(indices, new SearchSourceBuilder());
    public boolean equals(Object o) {
    /**
     */
        Objects.requireNonNull(originalSearchRequest, "search request must not be null");
        );
        return false;
        return "SearchRequest{"  
    }  
            maxConcurrentShardRequests,
import org.opensearch.action.support.IndicesOptions;  
            int shardDocCount = 0;
        if (source == null) {
        ActionRequestValidationException validationException = null;  
        return scroll(new Scroll(keepAlive));
    private String preference;
        }
     * If set, will enable scrolling of the search request for the specified timeout.  
            && Objects.equals(batchedReduceSize, that.batchedReduceSize)
        return this.routing;  
     * mechanism to reduce the memory overhead per search request if the potential number of shards in the request can be large.
            requestCache,
    /**
        this.scroll = searchRequest.scroll;  
        out.writeOptionalWriteable(source);
     * The search type to execute, defaults to {@link SearchType#DEFAULT}.
            + pipeline  
    public SearchRequest(String... indices) {
    public SearchRequest searchType(String searchType) {
            absoluteStartMillis = DEFAULT_ABSOLUTE_START_MILLIS;
        return this;
            }  
    /**
 * not use this file except in compliance with the License.
            pipeline = in.readOptionalString();
 * @see SearchResponse  
            preference,
 * software distributed under the License is distributed on an
            + ", phaseTook="
        this.absoluteStartMillis = absoluteStartMillis;
        indicesOptions = IndicesOptions.readIndicesOptions(in);  
            && Objects.equals(preference, that.preference)  
            throw new IllegalArgumentException("preFilterShardSize must be >= 1");
     * This filter roundtrip can limit the number of shards significantly if for
        return validationException;
                validationException = addValidationError("using [point in time] is not allowed in a scroll context", validationException);
            : source.trackTotalHitsUpTo() == null ? SearchContext.DEFAULT_TRACK_TOTAL_HITS_UP_TO
        super.writeTo(out);
                if (source.from() > 0) {
            localClusterAlias,
        out.writeOptionalString(preference);  
    /**
            && ccsMinimizeRoundtrips == that.ccsMinimizeRoundtrips
        if (this == o) {
        return true;
 * A request to execute search against one or more indices (or all). Best created using  
            out.writeBoolean(finalReduce);
     */  
        return this.requestCache;
    /**
    }  
    }
    public Scroll scroll() {
    boolean isFinalReduce() {
    /**
    }
        }
        batchedReduceSize = in.readVInt();
     * Sets if this request should allow partial results. (If method is not called,  
     * If set, will enable scrolling of the search request.
 * compatible open source license.
    private Integer preFilterShardSize;  
    @Override  
    static SearchRequest subSearchRequest(  
        return this.preference;
    public int hashCode() {  
            allowPartialSearchResults,
    /**
    /**
        validateIndices(indices);
        String[] indices,
            routing,
            searchType,
 * is required. The search source is the different search options, including aggregations and such.
    private SearchRequest(
        if (source != null) {
import org.opensearch.action.IndicesRequest;
     * A value of {@code 0} means the user has not explicitly set this parameter.  
            && absoluteStartMillis == that.absoluteStartMillis
            + searchType
     * will default to the cluster level setting).
    }  
import java.util.Objects;
    public SearchRequest scroll(String keepAlive) {
    public Integer getPreFilterShardSize() {
import java.io.IOException;  
    public static final int DEFAULT_BATCHED_REDUCE_SIZE = 512;
import org.opensearch.core.xcontent.ToXContent;
     * <li>The primary sort of the query targets an indexed field</li>
            + allowPartialSearchResults  
    private static boolean isShardDocSort(SortBuilder<?> sb) {
        indices = in.readStringArray();
     */
            out.writeStringArray(Strings.EMPTY_ARRAY);
     */
 * @see Client#search(SearchRequest)
            source,  
     * @param indices the indices to search against
/**
            out.writeOptionalBoolean(phaseTook);  
            }
                    "_shard_doc is only supported with point-in-time (PIT). Add a PIT or remove _shard_doc.",  
     * Constructs a new search request against the provided indices with the given search source.  
    }  
            throw new IllegalArgumentException("batchedReduceSize must be >= 2");  
        if (out.getVersion().onOrAfter(Version.V_2_7_0)) {
    }
        out.writeStringArray(indices);
        return this;
    private int maxConcurrentShardRequests = 0;
    private SearchSourceBuilder source;  
     * @param clusterAlias the alias to prefix index names with in the returned search results
    }
    public SearchType searchType() {
        boolean scroll = scroll() != null;
            : source.trackTotalHitsUpTo();  
        scroll = in.readOptionalWriteable(Scroll::new);
        return source != null && source.isSuggestOnly();
            && Objects.equals(scroll, that.scroll)  
        return absoluteStartMillis;  
    }
 * GitHub history for details.
            preFilterShardSize,  
        return new SearchRequest(originalSearchRequest, indices, clusterAlias, absoluteStartMillis, finalReduce);
    public void setCancelAfterTimeInterval(TimeValue cancelAfterTimeInterval) {  
                validationException = addValidationError(
    public void setBatchedReduceSize(int batchedReduceSize) {
        if (maxConcurrentShardRequests < 1) {
            if (source != null) {  
    public String[] indices() {  
 */  
        return this;
    }  
        this.scroll = scroll;  
    private SearchType searchType = SearchType.DEFAULT;  
            + ", indicesOptions="
        StringBuilder sb = new StringBuilder();
            && Objects.equals(phaseTook, that.phaseTook);
import org.opensearch.core.tasks.TaskId;  
        preference = in.readOptionalString();  
     *
 *
    }
            + ", batchedReduceSize="
        }  
        this.requestCache = searchRequest.requestCache;
                    validationException
    public void writeTo(StreamOutput out) throws IOException {
        this.maxConcurrentShardRequests = maxConcurrentShardRequests;
    /**
        long absoluteStartMillis,
        localClusterAlias = in.readOptionalString();  
    public SearchRequest(StreamInput in) throws IOException {
    public static final ToXContent.Params FORMAT_PARAMS = new ToXContent.MapParams(Collections.singletonMap("pretty", "false"));
        return searchType(SearchType.fromString(searchType));  
            if (shardDocCount > 1) {
        BytesStreamOutput out = new BytesStreamOutput();
    }
        return absoluteStartMillis == DEFAULT_ABSOLUTE_START_MILLIS ? System.currentTimeMillis() : absoluteStartMillis;
import org.opensearch.common.Nullable;
     * If set, will enable scrolling of the search request.  
        out.writeOptionalVInt(preFilterShardSize);
     * Sets the indices the search will be executed on.
    }
                }  
     *  
    /**  
        }  
    }
            } catch (final OpenSearchException ex) {
        this.phaseTook = phaseTook;
    /**
import org.opensearch.OpenSearchException;
    }
        out.writeOptionalBoolean(requestCache);
    }  
    public ActionRequestValidationException validate() {
        this.indices = indices;  
import java.util.Arrays;
        return searchType;
     */
        String clusterAlias,  
    /**  
        this.cancelAfterTimeInterval = searchRequest.cancelAfterTimeInterval;  
     * performing reduction on each cluster in order to minimize network round-trips between the coordinating node and the remote clusters.
     * one of "dfs_query_then_fetch"/"dfsQueryThenFetch", "dfs_query_and_fetch"/"dfsQueryAndFetch",
    @Override
     * will be used across different requests.
                    validationException = addValidationError("[size] cannot be [0] in a scroll context", validationException);
    public SearchRequest deepCopy() throws IOException {
        }
     * Returns the number of shard results that should be reduced at once on the coordinating node. This value should be used as a  
            + ", localClusterAlias="
    @Override  
            if (types.length > 0) {  
            + cancelAfterTimeInterval
     */
    /**
    }
        Objects.requireNonNull(clusterAlias, "cluster alias must not be null");  
        }  
        this.allowPartialSearchResults = searchRequest.allowPartialSearchResults;
            if (source.aggregations() != null) {
            throw new IllegalArgumentException("absoluteStartMillis must not be negative but was [" + absoluteStartMillis + "]");
            + "}";  
import org.opensearch.search.sort.ShardDocSortBuilder;
import org.opensearch.common.annotation.PublicApi;  
     */
        this.source = Objects.requireNonNull(sourceBuilder, "source must not be null");
            }
    }  
        this.maxConcurrentShardRequests = searchRequest.maxConcurrentShardRequests;
                throw new IllegalStateException(
     * returned as part of search hits with the alias of the cluster they came from.
        this.preFilterShardSize = preFilterShardSize;  
    private final boolean finalReduce;
                );
                validationException = addValidationError(
        if (out.getVersion().before(Version.V_2_0_0)) {  
        preFilterShardSize = in.readOptionalVInt();
    ) {  
            + ", source="
        this.preference = preference;
        if (source != null) {
        return maxConcurrentShardRequests;
import java.util.Map;  
            }
import org.opensearch.search.sort.SortBuilder;
        }
    public boolean isCcsMinimizeRoundtrips() {  
                if (source.trackTotalHitsUpTo() != null && source.trackTotalHitsUpTo() != SearchContext.TRACK_TOTAL_HITS_ACCURATE) {
     * <li>The request targets one or more read-only index</li>
     */
    /**
    /**  
     * </ul>  
     */  
     */
     * The indices  
        return this;  
        if (in.getVersion().onOrAfter(Version.V_2_12_0)) {
    @Override  
     * is being executed as part of a locally reduced cross-cluster search request. The cluster alias is used to prefix index names  
                        "disabling [track_total_hits] is not allowed in a scroll context",  
        return scroll(new Scroll(TimeValue.parseTimeValue(keepAlive, null, getClass().getSimpleName() + ".Scroll.keepAlive")));  
        indicesOptions.writeIndicesOptions(out);
    /**
    public long getOrCreateAbsoluteStartMillis() {  
        out.writeOptionalWriteable(scroll);
    /**  
     * ensure that the same value, determined by the coordinating node, is used on all nodes involved in the execution of the search
/*  
            + batchedReduceSize
            }  
 *     http://www.apache.org/licenses/LICENSE-2.0
 * @see Requests#searchRequest(String...)
    }
            sb.append("source[]");
    public SearchRequest(String[] indices, SearchSourceBuilder source) {
    public SearchRequest requestCache(Boolean requestCache) {
 * the Apache License, Version 2.0 (the "License"); you may
     * Sets the preference to execute the search. Defaults to randomize across shards. Can be set to
    public TimeValue getCancelAfterTimeInterval() {
 */
     * The search source to execute.  
    @Nullable  
 * this work for additional information regarding copyright
            + preFilterShardSize
 *
     * the search request expands to exceeds the threshold, or <code>null</code> if the threshold is unspecified.
        return resolveTrackTotalHitsUpTo(scroll, source);
import static org.opensearch.action.ValidateActions.addValidationError;  
    public SearchRequest preference(String preference) {
     * Returns the alias of the cluster that this search request is being executed on. A non-null value indicates that this search request
        this(  
        if (scroll) {
        this.indicesOptions = searchRequest.indicesOptions;  
     * instance a shard can not match any documents based on its rewrite method ie. if date filters are mandatory to match but the shard  
            scroll,
            String[] types = in.readStringArray();
    }
 *  
    /**  
            && Objects.equals(localClusterAlias, that.localClusterAlias)  
     * Sets the number of shard requests that should be executed concurrently on a single node. This value should be used as a
        return Objects.hash(
@PublicApi(since = "1.0.0")
            throw new IllegalArgumentException("source must not be null");
     * example, if "now" is used, it will never be cached). By default (not set, or null,
            + scroll
import org.opensearch.core.common.io.stream.StreamInput;
     */
     * <li>The request targets more than 128 shards</li>  
            if (requestCache != null && requestCache) {
            Arrays.hashCode(indices),  
    /**
        this.localClusterAlias = localClusterAlias;  
        if (in.getVersion().onOrAfter(Version.V_2_7_0)) {
    public IndicesOptions indicesOptions() {  
            + maxConcurrentShardRequests  
     * Sets the number of shard results that should be reduced at once on the coordinating node. This value should be used as a protection
     */
        return searchType == that.searchType  
    }  
     * protection mechanism to reduce the number of shard requests fired per high level search request. Searches that hit the entire  
     * @return true if the request only has suggest
    public int getMaxConcurrentShardRequests() {  
        return maxConcurrentShardRequests == 0 ? 5 : maxConcurrentShardRequests;
     * {@code _local} to prefer local shards, {@code _primary} to execute only on primary shards,  
    }
     * the provided current time, otherwise it will return {@link System#currentTimeMillis()}.
        return ccsMinimizeRoundtrips;
        return this;
            try {  
     */  
        this.finalReduce = finalReduce;
     */
            + Arrays.toString(indices)
     * bounds and the query are disjoint.
    private final long absoluteStartMillis;  
            }  
        sb.append("search_type[").append(searchType).append("], ");  
    /**
    }
        this.ccsMinimizeRoundtrips = ccsMinimizeRoundtrips;
        }
    }
    /**
     * Returns the number of shard requests that should be executed concurrently on a single node. This value should be used as a
import org.opensearch.Version;
    private String routing;
            phaseTook  
        }
 * Licensed to Elasticsearch under one or more contributor  
                );
        }  
            return ShardDocSortBuilder.NAME.equals(((FieldSortBuilder) sb).getFieldName());
        cancelAfterTimeInterval = in.readOptionalTimeValue();  
        validateIndices(indices);
            + '\''  
    }
            if (scroll) {  
     * Returns whether the reduction phase that will be performed needs to be final or not.  
        }  
    private String pipeline;
    private TimeValue cancelAfterTimeInterval;
     * Such requests will not be finally reduced, so that their results can be merged together in one response at completion.
        requestCache = in.readOptionalBoolean();
     * Constructs a new search request from reading the specified stream.
 */  
            finalReduce = in.readBoolean();  
        }
    public static final int DEFAULT_PRE_FILTER_SHARD_SIZE = 128;  
            for (SortBuilder<?> sb : source.sorts()) {
import org.opensearch.search.sort.FieldSortBuilder;  
    public SearchTask createTask(long id, String type, String action, TaskId parentTaskId, Map<String, String> headers) {  
public class SearchRequest extends ActionRequest implements IndicesRequest.Replaceable {
    /**
    }  
 * You may obtain a copy of the License at  
    public String toString() {
import org.opensearch.transport.client.Requests;
            cancelAfterTimeInterval,
    }
    }  
     * cluster can be throttled with this number to reduce the cluster load. The default is {@code 5}
     * Sets value of phase_took query param if provided by user. Defaults to <code>null</code>.
        Strings.arrayToDelimitedString(indices, ",", sb);
                }  
     */
            searchRequest.absoluteStartMillis,
        out.writeVInt(maxConcurrentShardRequests);
        }
    }
                    validationException
 * </p>
        indices(indices);
     * Sets whether network round-trips should be minimized when executing cross-cluster search requests. Defaults to <code>true</code>.
            sb.append("source[");
    /**
    private static void validateIndices(String... indices) {
        return this;
    public PointInTimeBuilder pointInTimeBuilder() {  
        }  
        return scroll;
        this.ccsMinimizeRoundtrips = searchRequest.ccsMinimizeRoundtrips;
            && Objects.equals(maxConcurrentShardRequests, that.maxConcurrentShardRequests)
     * The type of search to execute.
    }  
            out.writeOptionalString(pipeline);  
 * SPDX-License-Identifier: Apache-2.0
     * @throws IOException if there is an issue reading the stream
     * instance a shard can not match any documents based on its rewrite method ie. if date filters are mandatory to match but the shard
    public SearchRequest pipeline(String pipeline) {
        if (source != null) {  
        out.writeBoolean(ccsMinimizeRoundtrips);  
        return pipeline;
     * Used when a {@link SearchRequest} is created and executed as part of a cross-cluster search request  
    /**  
        boolean finalReduce  
import org.opensearch.search.internal.SearchContext;
            + ", cancelAfterTimeInterval="  
    /**  
        return new SearchRequest(in);
            searchRequest.indices,
        return sb.toString();  
        }
    @Nullable
                if (isShardDocSort(sb)) shardDocCount++;  
     * The source of the search request.
    /**  
        out.writeOptionalString(routing);
        boolean finalReduce
     */  
    ) {
     * will default to the index level setting if request cache is enabled or not).  
        return this;
    public SearchRequest scroll(Scroll scroll) {
        if (preFilterShardSize < 1) {  
    public static final IndicesOptions DEFAULT_INDICES_OPTIONS = IndicesOptions.strictExpandOpenAndForbidClosedIgnoreThrottled();
    /**
    public void setCcsMinimizeRoundtrips(boolean ccsMinimizeRoundtrips) {
     */
     * When unspecified, the pre-filter phase is executed if any of these conditions is met:  
     * the search request expands to exceeds the threshold. This filter roundtrip can limit the number of shards significantly if for  
        }
 * this file be licensed under the Apache-2.0 license or a
        this.batchedReduceSize = searchRequest.batchedReduceSize;  
        this.source = source;
    private Boolean phaseTook = null;  
            && Objects.equals(source, that.source)
    }
                    "duplicate _shard_doc sort detected. Specify it at most once.",  
import org.opensearch.transport.client.Client;  
 * <p>
            + ", maxConcurrentShardRequests="
                    validationException = addValidationError("using [from] is not allowed in a scroll context", validationException);
        }  
    public void setPreFilterShardSize(int preFilterShardSize) {
            + localClusterAlias
            finalReduce = true;  
    public boolean isSuggestOnly() {  
     */  
    public Boolean isPhaseTook() {  
     * protection mechanism to reduce the number of shard requests fired per high level search request. Searches that hit the entire  
            return false;  
     * <li>The request targets more than 128 shards</li>
     * Returns the raw value of maxConcurrentShardRequests without applying the default.
     * @param in The stream the request is read from
    }
            && Objects.equals(requestCache, that.requestCache)
     * request. When created through {@link #subSearchRequest(SearchRequest, String[], String, long, boolean)}, this method returns  
            && Objects.equals(allowPartialSearchResults, that.allowPartialSearchResults)
    }  
import org.opensearch.core.common.Strings;  
            sb.append("]");
     * Returns the current time in milliseconds from the time epoch, to be used for the execution of this search request. Used to
            + ", scroll="  
                validationException = addValidationError(
            && Objects.equals(routing, that.routing)
        return new SearchTask(id, type, action, this::buildDescription, parentTaskId, headers, cancelAfterTimeInterval);
    public SearchRequest indices(String... indices) {
    /**
     */  
     */
        this.preFilterShardSize = searchRequest.preFilterShardSize;  
     */  
        this.localClusterAlias = null;  
     * will run against all indices.
                if (source.rescores() != null && source.rescores().isEmpty() == false) {
        out.writeByte(searchType.id());  
            + absoluteStartMillis
        if (batchedReduceSize <= 1) {
        if (in.getVersion().before(Version.V_2_0_0)) {  
    private Scroll scroll;  
    public int resolveTrackTotalHitsUpTo() {
     * The routing values to control the shards that the search will be executed on.  
            absoluteStartMillis,  
    public SearchRequest indicesOptions(IndicesOptions indicesOptions) {
     *
        return finalReduce;  
            searchRequest.finalReduce
     * <li>The request targets one or more read-only index</li>  
     * A comma separated list of routing values to control the shards the search will be executed on.  
        return source;  
        String[] indices,  
     * bounds and the query are disjoint.
        }  
                    validationException = addValidationError("using [rescore] is not allowed in a scroll context", validationException);
    }
        if (localClusterAlias != null) {
    }
    }
                sb.append(source.toString(FORMAT_PARAMS));
     */
    public String routing() {
            }
    @Override
        this.routing = searchRequest.routing;
        return indicesOptions;
 * @opensearch.api
        return this.allowPartialSearchResults;  
     */
    public void setMaxConcurrentShardRequests(int maxConcurrentShardRequests) {  
            }
        return this;
        return indices;
                );
                );  
 * under the License.  
        this.preference = searchRequest.preference;
 *  
            + ", pipeline="
    @Nullable
            final boolean hasPit = pointInTimeBuilder() != null;
    public void setPhaseTook(Boolean phaseTook) {
    private int batchedReduceSize = DEFAULT_BATCHED_REDUCE_SIZE;
            // no matter what the value of track_total_hits is
     */
    public SearchRequest() {
    /**
        if (sb instanceof FieldSortBuilder) {
    /**
import org.opensearch.common.unit.TimeValue;
    /**
            }  
            indicesOptions,  
    }
        // _shard_doc validation
package org.opensearch.action.search;
    }
import org.opensearch.action.ActionRequest;  
        if (sb instanceof ShardDocSortBuilder) return true;  
            searchRequest.localClusterAlias,  
    }  
        } else {  
            + ", preFilterShardSize="  
import org.opensearch.search.builder.SearchSourceBuilder;
        this.routing = Strings.arrayToCommaDelimitedString(routings);  
    }  
        return source == null ? SearchContext.DEFAULT_TRACK_TOTAL_HITS_UP_TO
            out.writeVLong(absoluteStartMillis);  
import org.opensearch.action.ActionRequestValidationException;
     * @param originalSearchRequest the original search request  
    /**
     * "query_then_fetch"/"queryThenFetch", and "query_and_fetch"/"queryAndFetch".  
        }  
    public Boolean allowPartialSearchResults() {
     * @return a copy of the current SearchRequest
 */  
import org.opensearch.search.builder.PointInTimeBuilder;  
 * Unless required by applicable law or agreed to in writing,
     * Creates a new sub-search request starting from the original search request that is provided.  
        allowPartialSearchResults = in.readOptionalBoolean();
    String getLocalClusterAlias() {
     * Defaults to <code>true</code>.
    @Nullable  
                    "types are no longer supported in search requests but found [" + Arrays.toString(types) + "]"
        this.allowPartialSearchResults = allowPartialSearchResults;
    long getAbsoluteStartMillis() {
     */
    }  
     */
    @Override  
        return localClusterAlias;
     * <p>  
     * For internal use only, allows to fork a search request into multiple search requests that will be executed independently.
    public Boolean requestCache() {
    @Override
        Objects.requireNonNull(indices, "indices must not be null");
    /**
    }
                    );
import java.util.Collections;
        this.indicesOptions = Objects.requireNonNull(indicesOptions, "indicesOptions must not be null");
                validationException = addValidationError("[request_cache] cannot be used in a scroll context", validationException);  
    public SearchRequest routing(String routing) {  
    @Override
    }
        searchType = SearchType.fromId(in.readByte());  
     * Sets a threshold that enforces a pre-filter roundtrip to pre-filter search shards based on query rewriting if the number of shards
            && Objects.equals(preFilterShardSize, that.preFilterShardSize)  
            // types not supported so send an empty array to previous versions
            searchRequest,
        return preFilterShardSize;  
     * Returns whether network round-trips should be minimized when executing cross-cluster search requests.  
    }
            return SearchContext.TRACK_TOTAL_HITS_ACCURATE;
        }
            && Arrays.equals(indices, that.indices)
            phaseTook = in.readOptionalBoolean();
        if (absoluteStartMillis < 0) {
                    "_shard_doc cannot be used with scroll. Use PIT + search_after instead.",  
        }  
            absoluteStartMillis = in.readVLong();
        return cancelAfterTimeInterval;
        sb.append("indices[");  
    }  
 * Modifications Copyright OpenSearch Contributors. See
     * cluster can be throttled with this number to reduce the cluster load. The default is {@code 5}
     * The a string representation search type to execute, defaults to {@link SearchType#DEFAULT}. Can be
            + requestCache
