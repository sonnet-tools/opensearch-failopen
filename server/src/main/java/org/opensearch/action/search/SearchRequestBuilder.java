    /**
     * Delegates to {@link SearchSourceBuilder#suggest(SuggestBuilder)}
    public SearchRequestBuilder addRescorer(RescorerBuilder<?> rescorer) {
    public SearchRequestBuilder addAggregation(PipelineAggregationBuilder aggregation) {
        return this;
     * Adds stored fields to load and return (note, it must be stored) as part of the search request.
    /**
    /**
        request.searchType(searchType);
     * For example indices that don't exist.
    /**
     */
     * one of "dfs_query_then_fetch"/"dfsQueryThenFetch", "dfs_query_and_fetch"/"dfsQueryAndFetch",
    }
    public SearchRequestBuilder setSearchType(SearchType searchType) {
    }
    /**
     * Clears all rescorers from the builder.
    /**
 * Unless required by applicable law or agreed to in writing,
     */
    }
    public SearchRequestBuilder addDocValueField(String name, String format) {
        request.scroll(keepAlive);
     * Defaults to {@code false}.
    /**
    }
     */
     */
        return this;
    }
     * @param order The sort ordering
     * query on them.
     * Adds a generic sort builder.
package org.opensearch.action.search;
    /**
    }
        sourceBuilder().fetchField(name, format);
     *
import org.opensearch.search.aggregations.PipelineAggregationBuilder;
     * Adds a sort against the given field name and the sort ordering.
        return this;
     * @param field The name of the field
     * example, if "now" is used, it will never be cached). By default (not set, or null,
        request.scroll(scroll);
     */
        sourceBuilder().slice(builder);
     * Should each {@link org.opensearch.search.SearchHit} be returned with the
    public SearchRequestBuilder setPreference(String preference) {
    public SearchRequestBuilder setMaxConcurrentShardRequests(int maxConcurrentShardRequests) {
     *
     */
     */
    }
     */
     */
    public SearchRequestBuilder setTrackScores(boolean trackScores) {
     */
import java.util.Arrays;
     * When unspecified, the pre-filter phase is executed if any of these conditions is met:
import org.opensearch.search.aggregations.AggregationBuilder;
    /**
        return this;
            return request.source().toString();
     * Sets if this request should use the request cache or not, assuming that it can (for
    }
     * elements.
        return this;
 * this file be licensed under the Apache-2.0 license or a
        return this;
    /**
    }
     */
     * @return this for chaining
        sourceBuilder().size(size);
        return this;
    /**
        return this;
    /**
    public SearchRequestBuilder setPostFilter(QueryBuilder postFilter) {
        return this;
     * <li>The request targets more than 128 shards</li>
    public SearchRequestBuilder setIncludeNamedQueriesScore(boolean includeNamedQueriesScore) {
     * An optional timeout to control how long search is allowed to take.
        sourceBuilder().seqNoAndPrimaryTerm(seqNoAndPrimaryTerm);
     * @param rescorer rescorer configuration
    /**
     * protection mechanism to reduce the number of shard requests fired per high level search request. Searches that hit the entire
    public SearchRequestBuilder setFetchSource(boolean fetch) {
     */
 * @opensearch.api
     * or a custom value, which guarantees that the same order
     * Indicate that _source should be returned with every hit, with an "include" and/or "exclude" set which can include simple wildcard
    }
     */
    public SearchRequestBuilder setVersion(boolean version) {
        this.request.setPreFilterShardSize(preFilterShardSize);
     * mechanism to reduce the memory overhead per search request if the potential number of shards in the request can be large.
 * SPDX-License-Identifier: Apache-2.0
     * If set, will enable scrolling of the search request for the specified timeout.
     * but its recommended to use non analyzed or numeric fields.
 * Modifications Copyright OpenSearch Contributors. See
 * not use this file except in compliance with the License.
import org.opensearch.common.unit.TimeValue;
        return this;
/*
 * specific language governing permissions and limitations
    /**
     * @see org.opensearch.search.sort.SortBuilders
     *
    public SearchRequestBuilder setProfile(boolean profile) {
    /**
     * Clears all rescorers on the builder and sets the first one.  To use multiple rescore windows use
    }
     * @param excludes An optional list of exclude (optionally wildcarded) pattern to filter the returned _source
 */
     */
    }
    /**
import org.opensearch.action.ActionRequestBuilder;
        sourceBuilder().clearRescorers();
    }
    public SearchRequestBuilder setFetchSource(@Nullable String include, @Nullable String exclude) {
 * You may obtain a copy of the License at
        return addRescorer(rescorer.windowSize(window));
     *
        sourceBuilder().searchAfter(values);
    }
    }
     * Adds a new rescorer.
    }
        this.request.setBatchedReduceSize(batchedReduceSize);
     */
     */
     * query will early terminate
     * {@link #addRescorer(org.opensearch.search.rescore.RescorerBuilder, int)}.
        sourceBuilder().addRescorer(rescorer.windowSize(window));
        return this;
     * explanation of the hit (ranking).
/**
     * Set the sort values that indicates which docs this request should "search after".
     * An optional document count, upon collecting which the search
        return this;
     */
 * A search action request builder.
        return this;
    }
     * Adds an aggregation to the search operation.
    }
/*
    public SearchRequestBuilder setIndicesOptions(IndicesOptions indicesOptions) {
     */
     * @param index      The index to apply the boost against
    public SearchRequestBuilder setRescorer(RescorerBuilder rescorer, int window) {
    }
    }
    }
     */
    /**
     * @param name The field to get from the docvalue
     * <ul>
    public SearchRequestBuilder setTimeout(TimeValue timeout) {
import org.opensearch.search.Scroll;
     */
    /**
        sourceBuilder().pointInTimeBuilder(pointInTimeBuilder);
        return this;
     * The routing values to control the shards that the search will be executed on.
        sourceBuilder().includeNamedQueriesScores(includeNamedQueriesScore);
    }
        request.requestCache(requestCache);
     * @param type   The type of derived field. All values emitted by script must be of this type
    }
    public SearchRequestBuilder setRequestCache(Boolean requestCache) {
    public SearchRequestBuilder setSearchType(String searchType) {
 * GitHub history for details.
     * Indicate that _source should be returned with every hit, with an "include" and/or "exclude" set which can include simple wildcard
     * @param rescorer rescorer configuration
     * @return this for chaining
        return this;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
        sourceBuilder().collapse(collapse);
    /**
    /**
 * license agreements. See the NOTICE file distributed with
 * under the License.
        request.preference(preference);
import org.opensearch.script.Script;
        sourceBuilder().addRescorer(rescorer);
        sourceBuilder().postFilter(postFilter);
 *
    }
    /**
    /**
    public SearchRequestBuilder addSort(String field, SortOrder order) {
     * cluster can be throttled with this number to reduce the cluster load. The default is {@code 5}.
    @Override
        sourceBuilder().storedFields(Arrays.asList(fields));
        return this;
     * @see org.opensearch.index.query.QueryBuilders
     * The a string representation search type to execute, defaults to {@link SearchType#DEFAULT}. Can be
        sourceBuilder().from(from);
     * <p>
     * Constructs a new search source builder with a search query.
        return this;
     * Sets the indices the search will be executed on.
     */
        return this;
        return this;
    public SearchRequestBuilder setMinScore(float minScore) {
     * Request level time interval to control how long search is allowed to execute after which it is cancelled.
        return this;
/*
    }
    public SearchRequestBuilder clearRescorers() {
        super(client, action, new SearchRequest());
    public SearchRequestBuilder storedFields(String... fields) {
    }
        return this;
        return addRescorer(rescorer);
    }
     *
 * ownership. Elasticsearch licenses this file to you under
        sourceBuilder().fetchSource(includes, excludes);
    }
    /**
    /**
    public SearchRequestBuilder(OpenSearchClient client, StreamSearchAction action) {
     * Adds a new rescorer.
 */
        return this;
     *
    /**
     */
        request.source(source);
    public SearchRequestBuilder addFetchField(String name) {
        if (request.source() == null) {
        return this;
    public SearchRequestBuilder setScroll(TimeValue keepAlive) {
     */
    }
        return this;
        sourceBuilder().clearRescorers();
     * but its recommended to use non analyzed or numeric fields.
    }
        sourceBuilder().trackTotalHits(trackTotalHits);
        return this;
    }
     */
    /**
    /**
     */
    /**
import org.opensearch.search.suggest.SuggestBuilder;
import org.opensearch.search.fetch.subphase.highlight.HighlightBuilder;
        return this;
    /**
     *
        return this;
        return this;
     * The stats groups this request will be aggregated under.
     * @param window   rescore window
        sourceBuilder().highlighter(highlightBuilder);
    public SearchRequestBuilder setStats(String... statsGroups) {
    }
     * bounds and the query are disjoint.
import org.opensearch.search.builder.SearchSourceBuilder;
        return this;
    public SearchRequestBuilder setPreFilterShardSize(int preFilterShardSize) {
    /**
    }
     *
     * elements.
    }
     * instance a shard can not match any documents based on its rewrite method ie. if date filters are mandatory to match but the shard
     * will be used across different requests.
    public SearchRequestBuilder setBatchedReduceSize(int batchedReduceSize) {
     * Sets a threshold that enforces a pre-filter roundtrip to pre-filter search shards based on query rewriting if the number of shards
 * this work for additional information regarding copyright
     *
    }
        return this;
    public String toString() {
        return this;
        return this;
     * Sets the boost a specific index will receive when the query is executed against it.
     * count accurately.
     */
    public SearchRequestBuilder addDocValueField(String name) {
    }
     */
        return this;
        return this;
        sourceBuilder().storedField(field);
    /**
     * The stats groups this request will be aggregated under.
     * <li>The request targets one or more read-only index</li>
     * Adds a docvalue based field to load and return. The field does not have to be stored,
     */
    public SearchRequestBuilder setRescorer(RescorerBuilder<?> rescorer) {
    /**
     *
    }
    }
        return this;
        sourceBuilder().trackTotalHitsUpTo(trackTotalHitsUpTo);
     * @param name The field to load
    public SearchRequestBuilder setTrackTotalHits(boolean trackTotalHits) {
 * compatible open source license.
     * Should each {@link org.opensearch.search.SearchHit} be returned with its
        request.scroll(keepAlive);
import org.opensearch.common.annotation.PublicApi;
        sourceBuilder().sort(field, order);
        this.request.setMaxConcurrentShardRequests(maxConcurrentShardRequests);
import org.opensearch.transport.client.OpenSearchClient;
        sourceBuilder().derivedField(name, type, script);
     *
     */
import org.opensearch.search.collapse.CollapseBuilder;
        sourceBuilder().scriptField(name, script);
        return addDocValueField(name, null);
     * Adds a derived field of a given type. The script provided will be used to derive the value
     * up to 10,000 by default, see {@link #setTrackTotalHitsUpTo(int)} to change this value or set to true/false to always/never
     */
    }
    public SearchRequestBuilder setTrackTotalHitsUpTo(int trackTotalHitsUpTo) {
    /**
     * Sets if this request should allow partial results.  (If method is not called,
        sourceBuilder().fetchField(name, null);
    /**
        request.searchType(searchType);
        return this;
        request().indicesOptions(indicesOptions);
     * sequence number and primary term of the last modification of the document.
     * The search type to execute, defaults to {@link SearchType#DEFAULT}.
        return this;
    /**
    }
    /**
    }
        return this;
        sourceBuilder().aggregation(aggregation);
     * @param name   The name that will represent this value in the return hit
     */
     * @return this for chaining
    public SearchRequestBuilder highlighter(HighlightBuilder highlightBuilder) {
     * Indicates the total hit count that should be tracked accurately or null if the value is unset. Defaults to 10,000.
     * Adds a stored field to load and return (note, it must be stored) as part of the search request.
    }
     */
 *     http://www.apache.org/licenses/LICENSE-2.0
     */
     * Sets the source of the request as a SearchSourceBuilder.
     */
     */
    /**
import org.opensearch.search.builder.PointInTimeBuilder;
    public SearchRequestBuilder setExplain(boolean explain) {
    }
        sourceBuilder().profile(profile);
     * <p>
    /**
     */
     * <li>The primary sort of the query targets an indexed field</li>
     * The number of search hits to return. Defaults to {@code 10}.
     * Sets the minimum score below which docs will be filtered out.
        this.request.setCancelAfterTimeInterval(cancelAfterTimeInterval);
     * @param name The field to get from the docvalue
        super(client, action, new SearchRequest());
        sourceBuilder().stats(Arrays.asList(statsGroups));
     * @param name The field to load
     * @param exclude An optional exclude (optionally wildcarded) pattern to filter the returned _source
     * To disable the stored fields entirely (source and metadata fields) use {@code storedField("_none_")}.
 *
     *               the field value in the return hit.
    public SearchRequestBuilder suggest(SuggestBuilder suggestBuilder) {
     *
     * Specifies what type of requested indices to ignore and wildcard indices expressions.
     * Sets the number of shard results that should be reduced at once on the coordinating node. This value should be used as a protection
    /**
     * Adds a docvalue based field to load and return. The field does not have to be stored,
     */
     * A comma separated list of routing values to control the shards the search will be executed on.
    public SearchRequestBuilder setTerminateAfter(int terminateAfter) {
@PublicApi(since = "1.0.0")
    }
    }
    public SearchRequestBuilder setSource(SearchSourceBuilder source) {
     */
        sourceBuilder().fetchSource(fetch);
    public SearchRequestBuilder addAggregation(AggregationBuilder aggregation) {
        return this;
        return this;
        return this;
     * @return this for chaining
 */
     */
     */
    }
    public SearchRequestBuilder setRouting(String routing) {
     * but its recommended to use non analyzed or numeric fields.
    /**
     * @param name   The name of the field to be used in various parts of the query. The name will also represent
    public SearchRequestBuilder setAllowPartialSearchResults(boolean allowPartialSearchResults) {
        return this;
     * {@link #addRescorer(org.opensearch.search.rescore.RescorerBuilder, int)}.
     */
     * @param script The script to use
}
     * @param includes An optional list of include (optionally wildcarded) pattern to filter the returned _source
     */
        return this;
        return new SearchSourceBuilder().toString();
    }
public class SearchRequestBuilder extends ActionRequestBuilder<SearchRequest, SearchResponse> {
        return this;
     * Indicates whether the response should contain the stored _source for every hit
    }
        sourceBuilder().query(queryBuilder);
     */
    public SearchRequestBuilder setFrom(int from) {
        sourceBuilder().explain(explain);
     * If specified, OpenSearch will execute this search request using reader contexts from that point in time.
     *
     */
     */
import java.util.List;
     */
    }
        request.indices(indices);
        }
import org.opensearch.search.sort.SortOrder;
     * If set, will enable scrolling of the search request for the specified timeout.
    public SearchRequestBuilder setPointInTime(PointInTimeBuilder pointInTimeBuilder) {
     */
    }
    }
        sourceBuilder().trackScores(trackScores);
     */
        return this;
     * @param format an optional format string used when formatting values, for example a date format.
     * Should each {@link org.opensearch.search.SearchHit} be returned with an
     *
        return this;
     * "query_then_fetch"/"queryThenFetch", and "query_and_fetch"/"queryAndFetch".
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.search.rescore.RescorerBuilder;
     */
    public SearchRequestBuilder addIndexBoost(String index, float indexBoost) {
        return this;
 */
     */
     * @param rescorer rescorer configuration
        return this;
    public SearchRequestBuilder setCollapse(CollapseBuilder collapse) {
    }
        sourceBuilder().docValueField(name, format);
     * Sets the preference to execute the search. Defaults to randomize across shards. Can be set to
     */
     * the search request expands to exceeds the threshold. This filter roundtrip can limit the number of shards significantly if for
    public SearchRequestBuilder addSort(SortBuilder<?> sort) {
            request.source(new SearchSourceBuilder());
        sourceBuilder().terminateAfter(terminateAfter);
    /**
    /**
        return this;
    }
    /**
        return this;
     *
    /**
        return this;
     * (not aggregations). This filter is always executed as last filtering mechanism.
        sourceBuilder().sort(sort);
    }
    /**
    public SearchRequestBuilder setScroll(String keepAlive) {
    /**
    }
    public SearchRequestBuilder seqNoAndPrimaryTerm(boolean seqNoAndPrimaryTerm) {
        request.routing(routing);
    /**
    /**
     * Adds a field to load and return. The field must be present in the document _source.
     * @return this for chaining
     */
    public SearchRequestBuilder addRescorer(RescorerBuilder<?> rescorer, int window) {
    public SearchRequestBuilder setStats(List<String> statsGroups) {
    }
     * Sets a filter that will be executed after the query has been executed and only has affect on the search hits
    /**
    public SearchRequestBuilder searchAfter(Object[] values) {
        sourceBuilder().aggregation(aggregation);
        sourceBuilder().indexBoost(index, indexBoost);
    public SearchRequestBuilder addStoredField(String field) {
    /**
     *
     * @param script The script to use
    public SearchRequestBuilder(OpenSearchClient client, SearchAction action) {
        sourceBuilder().version(version);
     * If set, will enable scrolling of the search request.
    /**
     * Sets the number of shard requests that should be executed concurrently on a single node. This value should be used as a
    }
     * @param include An optional include (optionally wildcarded) pattern to filter the returned _source
        sourceBuilder().stats(statsGroups);
    }
    /**
        return this;
 *
     * From index to start the search from. Defaults to {@code 0}.
    /**
    /**
    }
        sourceBuilder().fetchSource(include, exclude);
 * Licensed to Elasticsearch under one or more contributor
     */
     * Applies when sorting, and controls if scores will be tracked as well. Defaults to {@code false}.
     * will default to the cluster level setting).
import org.opensearch.index.query.QueryBuilder;
    }
    public SearchRequestBuilder setIndices(String... indices) {
     *
     */
    /**
    }
     */
     */
     * </ul>
     *
    public SearchRequestBuilder addScriptField(String name, Script script) {
 *
        sourceBuilder().suggest(suggestBuilder);
    }
    public SearchRequestBuilder setScroll(Scroll scroll) {
        sourceBuilder().minScore(minScore);
     * Should the query be profiled. Defaults to <code>false</code>
     * version.
import org.opensearch.common.Nullable;
    public SearchRequestBuilder addDerivedField(String name, String type, Script script) {
    public SearchRequestBuilder setCancelAfterTimeInterval(TimeValue cancelAfterTimeInterval) {
    }
    }
     * Applies when fetching scores with named queries, and controls if scores will be tracked as well.
        }
    /**
    /**
     * will default to the index level setting if request cache is enabled or not).
     * Adds a field to load and return. The field must be present in the document _source.
    public SearchRequestBuilder setQuery(QueryBuilder queryBuilder) {
     * Clears all rescorers on the builder and sets the first one.  To use multiple rescore windows use
        return this;
     * @param rescorer rescorer configuration
     * @param indexBoost The boost to apply to the index
     * {@code _local} to prefer local shards, {@code _primary} to execute only on primary shards,
        request.allowPartialSearchResults(allowPartialSearchResults);
    public SearchRequestBuilder slice(SliceBuilder builder) {
import org.opensearch.search.sort.SortBuilder;
        if (request.source() != null) {
        return request.source();
    public SearchRequestBuilder setSize(int size) {
        return this;
    private SearchSourceBuilder sourceBuilder() {
import org.opensearch.search.slice.SliceBuilder;
     * @param window   rescore window
    public SearchRequestBuilder setRouting(String... routing) {
    public SearchRequestBuilder setFetchSource(@Nullable String[] includes, @Nullable String[] excludes) {
     * of a given type. Thereafter, it can be treated as regular field of a given type to perform
 * The OpenSearch Contributors require contributions made to
import org.opensearch.action.support.IndicesOptions;
        return this;
        return this;
        sourceBuilder().clearRescorers();
     * Adds an aggregation to the search operation.
     */
 * software distributed under the License is distributed on an
        return this;
        sourceBuilder().timeout(timeout);
    public SearchRequestBuilder addFetchField(String name, String format) {
     * Adds a script based field to load and return. The field does not have to be stored,
        return this;
     * Indicates if the total hit count for the query should be tracked. Requests will count total hit count accurately
    /**
    }
     */
        request.routing(routing);
