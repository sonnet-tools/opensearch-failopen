    }  
        request.searchType(searchType);  
        return this;  
    public SearchRequestBuilder searchAfter(Object[] values) {
        return addRescorer(rescorer.windowSize(window));
/**
    public SearchRequestBuilder setRouting(String... routing) {
 * this work for additional information regarding copyright
     */
     * The a string representation search type to execute, defaults to {@link SearchType#DEFAULT}. Can be
        return this;
     * @param name   The name of the field to be used in various parts of the query. The name will also represent
    public SearchRequestBuilder addFetchField(String name) {  
    public SearchRequestBuilder setPreFilterShardSize(int preFilterShardSize) {  
     */  
     * @param window   rescore window
    }
     */
     * Adds a new rescorer.
     * mechanism to reduce the memory overhead per search request if the potential number of shards in the request can be large.  
    /**  
        return this;  
    }  
     */
    public SearchRequestBuilder setMinScore(float minScore) {
     * If set, will enable scrolling of the search request for the specified timeout.  
     */  
        return this;  
     * An optional document count, upon collecting which the search
    /**
 * SPDX-License-Identifier: Apache-2.0
        sourceBuilder().includeNamedQueriesScores(includeNamedQueriesScore);  
    }
        return this;
    /**
     * Sets the minimum score below which docs will be filtered out.  
     * Indicates whether the response should contain the stored _source for every hit  
 *  
    }
 * Licensed to Elasticsearch under one or more contributor  
     * @param name The field to get from the docvalue
     * @param rescorer rescorer configuration
     * @param includes An optional list of include (optionally wildcarded) pattern to filter the returned _source
     * @param rescorer rescorer configuration  
    public SearchRequestBuilder addDocValueField(String name, String format) {
    }
        return this;
    /**
        sourceBuilder().minScore(minScore);  
     * elements.  
     *
     * Request level time interval to control how long search is allowed to execute after which it is cancelled.  
    }
    public SearchRequestBuilder setSize(int size) {  
     * </ul>
        sourceBuilder().fetchSource(includes, excludes);  
        return this;
     * Adds a stored field to load and return (note, it must be stored) as part of the search request.
     */
        sourceBuilder().size(size);
        sourceBuilder().indexBoost(index, indexBoost);  
    public String toString() {
    }  
     * sequence number and primary term of the last modification of the document.
import org.opensearch.common.unit.TimeValue;
     */
    public SearchRequestBuilder setScroll(TimeValue keepAlive) {  
     */
     * or a custom value, which guarantees that the same order
    public SearchRequestBuilder setAllowPartialSearchResults(boolean allowPartialSearchResults) {
        sourceBuilder().searchAfter(values);
    public SearchRequestBuilder(OpenSearchClient client, StreamSearchAction action) {
    public SearchRequestBuilder setVersion(boolean version) {  
     */
    /**  
        sourceBuilder().collapse(collapse);
    /**
     * one of "dfs_query_then_fetch"/"dfsQueryThenFetch", "dfs_query_and_fetch"/"dfsQueryAndFetch",
     * Should each {@link org.opensearch.search.SearchHit} be returned with an  
     */
    public SearchRequestBuilder setTrackTotalHits(boolean trackTotalHits) {  
     */
     * The routing values to control the shards that the search will be executed on.  
    /**
        sourceBuilder().clearRescorers();  
 * ownership. Elasticsearch licenses this file to you under  
    }
     * @param name The field to load
     */  
        return this;
        return this;  
     * @param include An optional include (optionally wildcarded) pattern to filter the returned _source
    /**
    /**  
    /**
        super(client, action, new SearchRequest());
 * this file be licensed under the Apache-2.0 license or a
     *               the field value in the return hit.  
    /**
     * The number of search hits to return. Defaults to {@code 10}.
     * Clears all rescorers on the builder and sets the first one.  To use multiple rescore windows use
     * Adds an aggregation to the search operation.
    private SearchSourceBuilder sourceBuilder() {  
    public SearchRequestBuilder setIndicesOptions(IndicesOptions indicesOptions) {
        return this;
        return this;
import org.opensearch.script.Script;
    /**
    /**
    }
import org.opensearch.search.fetch.subphase.highlight.HighlightBuilder;
public class SearchRequestBuilder extends ActionRequestBuilder<SearchRequest, SearchResponse> {
     * @param excludes An optional list of exclude (optionally wildcarded) pattern to filter the returned _source  
     * Applies when sorting, and controls if scores will be tracked as well. Defaults to {@code false}.  
    /**
    }  
    }
    public SearchRequestBuilder setScroll(String keepAlive) {
    public SearchRequestBuilder setRouting(String routing) {  
     * Indicate that _source should be returned with every hit, with an "include" and/or "exclude" set which can include simple wildcard
        sourceBuilder().clearRescorers();  
        return this;  
     * Indicates if the total hit count for the query should be tracked. Requests will count total hit count accurately
    /**
    public SearchRequestBuilder setCancelAfterTimeInterval(TimeValue cancelAfterTimeInterval) {
        return this;  
import org.opensearch.action.support.IndicesOptions;
    /**
    public SearchRequestBuilder setQuery(QueryBuilder queryBuilder) {  
    }
    }
    public SearchRequestBuilder addRescorer(RescorerBuilder<?> rescorer) {
    /**
    /**
    /**
     * @param name The field to load
    public SearchRequestBuilder setFetchSource(@Nullable String[] includes, @Nullable String[] excludes) {
 * compatible open source license.
     */  
     * Sets the indices the search will be executed on.  
     * Should each {@link org.opensearch.search.SearchHit} be returned with the  
     * Sets a filter that will be executed after the query has been executed and only has affect on the search hits  
     * Specifies what type of requested indices to ignore and wildcard indices expressions.
    public SearchRequestBuilder setProfile(boolean profile) {
    }
 * license agreements. See the NOTICE file distributed with
    }
    public SearchRequestBuilder highlighter(HighlightBuilder highlightBuilder) {
    public SearchRequestBuilder setBatchedReduceSize(int batchedReduceSize) {
     * <li>The request targets more than 128 shards</li>
        sourceBuilder().from(from);
     */  
    public SearchRequestBuilder setFetchSource(@Nullable String include, @Nullable String exclude) {
     */
     * Defaults to {@code false}.  
import org.opensearch.common.Nullable;  
import org.opensearch.search.sort.SortOrder;  
        sourceBuilder().fetchField(name, null);
    }
 * You may obtain a copy of the License at  
    }
     */
        return this;
    }
     * @param field The name of the field  
    /**  
    }
    public SearchRequestBuilder setTimeout(TimeValue timeout) {
     * Sets the boost a specific index will receive when the query is executed against it.  
    }  
     *  
     *
     */
        sourceBuilder().terminateAfter(terminateAfter);
    /**  
     * @param index      The index to apply the boost against
     * Indicate that _source should be returned with every hit, with an "include" and/or "exclude" set which can include simple wildcard
    public SearchRequestBuilder setSource(SearchSourceBuilder source) {
     */
    }
    }
        request.source(source);
     * Set the sort values that indicates which docs this request should "search after".
        sourceBuilder().seqNoAndPrimaryTerm(seqNoAndPrimaryTerm);
     *
     * To disable the stored fields entirely (source and metadata fields) use {@code storedField("_none_")}.  
     * If set, will enable scrolling of the search request.
     */  
        return request.source();
        super(client, action, new SearchRequest());
    public SearchRequestBuilder setExplain(boolean explain) {  
        request.scroll(scroll);
 * the Apache License, Version 2.0 (the "License"); you may
     * (not aggregations). This filter is always executed as last filtering mechanism.
/*
     * @param name   The name that will represent this value in the return hit
    public SearchRequestBuilder setIncludeNamedQueriesScore(boolean includeNamedQueriesScore) {
     * Constructs a new search source builder with a search query.
     */
    public SearchRequestBuilder addStoredField(String field) {
import org.opensearch.search.sort.SortBuilder;
     * Adds an aggregation to the search operation.
     */  
        sourceBuilder().derivedField(name, type, script);
     */
     * Adds a script based field to load and return. The field does not have to be stored,
import org.opensearch.search.slice.SliceBuilder;
    }  
     * Adds a field to load and return. The field must be present in the document _source.  
 * The OpenSearch Contributors require contributions made to  
     * <p>
    public SearchRequestBuilder setStats(String... statsGroups) {
    public SearchRequestBuilder setTerminateAfter(int terminateAfter) {
 */  
     *
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }
        sourceBuilder().postFilter(postFilter);
     * explanation of the hit (ranking).
    /**  
    public SearchRequestBuilder addAggregation(PipelineAggregationBuilder aggregation) {  
    /**
        return this;
        sourceBuilder().storedFields(Arrays.asList(fields));  
import org.opensearch.search.Scroll;
     * @see org.opensearch.search.sort.SortBuilders
     */  
 * GitHub history for details.
        return this;
import org.opensearch.search.aggregations.PipelineAggregationBuilder;
        return this;
            return request.source().toString();
        if (request.source() != null) {  
     * <p>
        return this;
    public SearchRequestBuilder addIndexBoost(String index, float indexBoost) {
        sourceBuilder().trackScores(trackScores);  
        return this;  
        sourceBuilder().stats(statsGroups);
        request.routing(routing);
    }
        return this;
     * @return this for chaining
        return this;
    public SearchRequestBuilder addSort(String field, SortOrder order) {  
    public SearchRequestBuilder setFetchSource(boolean fetch) {
        return addRescorer(rescorer);  
import org.opensearch.search.suggest.SuggestBuilder;
    /**
    /**
    /**  
     */
    public SearchRequestBuilder slice(SliceBuilder builder) {  
import org.opensearch.search.rescore.RescorerBuilder;  
        return this;
        request().indicesOptions(indicesOptions);  
        sourceBuilder().trackTotalHits(trackTotalHits);
        return this;
    }
        sourceBuilder().timeout(timeout);
        sourceBuilder().addRescorer(rescorer.windowSize(window));
    /**
    /**
        return this;
    }  
     */
     *  
    public SearchRequestBuilder storedFields(String... fields) {
 *
    /**
    public SearchRequestBuilder clearRescorers() {
     * Clears all rescorers from the builder.
     * will default to the index level setting if request cache is enabled or not).  
     */  
     */
            request.source(new SearchSourceBuilder());
     * query on them.  
 *     http://www.apache.org/licenses/LICENSE-2.0
        return this;
     *
    public SearchRequestBuilder setMaxConcurrentShardRequests(int maxConcurrentShardRequests) {  
    }
     * @param exclude An optional exclude (optionally wildcarded) pattern to filter the returned _source  
     * cluster can be throttled with this number to reduce the cluster load. The default is {@code 5}.
        sourceBuilder().fetchField(name, format);  
 * KIND, either express or implied.  See the License for the
 *
        return this;  
import org.opensearch.index.query.QueryBuilder;  
     * The stats groups this request will be aggregated under.
    }
     * From index to start the search from. Defaults to {@code 0}.
     */
     */  
    }
     * If specified, OpenSearch will execute this search request using reader contexts from that point in time.  
        request.routing(routing);  
    public SearchRequestBuilder addDerivedField(String name, String type, Script script) {
        return this;  
     */
     *  
     * example, if "now" is used, it will never be cached). By default (not set, or null,
     */  
    }  
        return addDocValueField(name, null);
import java.util.Arrays;
        sourceBuilder().fetchSource(fetch);  
     */
     * {@code _local} to prefer local shards, {@code _primary} to execute only on primary shards,  
        return this;
     * bounds and the query are disjoint.  
     * Sets the number of shard requests that should be executed concurrently on a single node. This value should be used as a
    /**
     *  
    public SearchRequestBuilder setCollapse(CollapseBuilder collapse) {  
        return new SearchSourceBuilder().toString();  
        }
     * Adds a field to load and return. The field must be present in the document _source.
     * Should the query be profiled. Defaults to <code>false</code>
        return this;
        sourceBuilder().profile(profile);
 */  
     */
    public SearchRequestBuilder(OpenSearchClient client, SearchAction action) {  
        return this;
     */
/*  
     */
     * @param indexBoost The boost to apply to the index  
    public SearchRequestBuilder suggest(SuggestBuilder suggestBuilder) {
    }
     * protection mechanism to reduce the number of shard requests fired per high level search request. Searches that hit the entire  
    }  
     */
        sourceBuilder().aggregation(aggregation);
     */
    }
        if (request.source() == null) {
     * @see org.opensearch.index.query.QueryBuilders
    public SearchRequestBuilder addDocValueField(String name) {  
    /**  
    }
    public SearchRequestBuilder setFrom(int from) {
    /**
     * query will early terminate
    /**  
import java.util.List;
    /**
        sourceBuilder().stats(Arrays.asList(statsGroups));
     * "query_then_fetch"/"queryThenFetch", and "query_and_fetch"/"queryAndFetch".  
import org.opensearch.common.annotation.PublicApi;
    public SearchRequestBuilder setRescorer(RescorerBuilder<?> rescorer) {
    /**
        sourceBuilder().sort(sort);
     */  
     * @return this for chaining  
     *
        return this;  
     *
        sourceBuilder().version(version);
     * Adds a generic sort builder.  
        return this;
     */  
     * Sets a threshold that enforces a pre-filter roundtrip to pre-filter search shards based on query rewriting if the number of shards  
    /**  
     * elements.  
     */
@PublicApi(since = "1.0.0")  
     */  
        return this;  
     */
 *  
    public SearchRequestBuilder setPostFilter(QueryBuilder postFilter) {  
        return this;  
    }  
     * @param script The script to use
    /**
        }  
        sourceBuilder().explain(explain);
     * version.
    public SearchRequestBuilder setStats(List<String> statsGroups) {  
        return this;
     *  
/*  
     * Should each {@link org.opensearch.search.SearchHit} be returned with its  
    }
     * Sets if this request should allow partial results.  (If method is not called,
import org.opensearch.search.aggregations.AggregationBuilder;  
     */
        request.scroll(keepAlive);  
    public SearchRequestBuilder seqNoAndPrimaryTerm(boolean seqNoAndPrimaryTerm) {  
        sourceBuilder().pointInTimeBuilder(pointInTimeBuilder);  
     * The stats groups this request will be aggregated under.
 */
    /**
    /**  
        return this;
    }
     * @param rescorer rescorer configuration
     */  
     * {@link #addRescorer(org.opensearch.search.rescore.RescorerBuilder, int)}.
     * Sets the source of the request as a SearchSourceBuilder.
     * Indicates the total hit count that should be tracked accurately or null if the value is unset. Defaults to 10,000.  
     * of a given type. Thereafter, it can be treated as regular field of a given type to perform
     * @param window   rescore window
    public SearchRequestBuilder setIndices(String... indices) {
    }  
    public SearchRequestBuilder setPreference(String preference) {
     * Adds a new rescorer.
    /**
     * @return this for chaining
    }
        return this;
    }  
        return this;
        return this;
     * {@link #addRescorer(org.opensearch.search.rescore.RescorerBuilder, int)}.
     * up to 10,000 by default, see {@link #setTrackTotalHitsUpTo(int)} to change this value or set to true/false to always/never  
     * @param name The field to get from the docvalue
        request.requestCache(requestCache);  
        return this;
    /**
     */  
    }
    /**
    }
     */  
     * count accurately.
    }
     * but its recommended to use non analyzed or numeric fields.
    }  
    /**  
    }
        return this;
     * Adds a sort against the given field name and the sort ordering.
        request.allowPartialSearchResults(allowPartialSearchResults);  
    public SearchRequestBuilder addAggregation(AggregationBuilder aggregation) {
    }
     */
     * @param type   The type of derived field. All values emitted by script must be of this type
        return this;
    }
 */
        return this;
package org.opensearch.action.search;
     */
    public SearchRequestBuilder setTrackScores(boolean trackScores) {
     *
     * The search type to execute, defaults to {@link SearchType#DEFAULT}.
     * Sets if this request should use the request cache or not, assuming that it can (for
        return this;
        request.scroll(keepAlive);
     * Adds a docvalue based field to load and return. The field does not have to be stored,
 * software distributed under the License is distributed on an
        return this;  
    /**  
        request.searchType(searchType);
    public SearchRequestBuilder addFetchField(String name, String format) {
        this.request.setCancelAfterTimeInterval(cancelAfterTimeInterval);  
    }
    /**  
     */
    public SearchRequestBuilder setScroll(Scroll scroll) {
    /**  
        request.indices(indices);  
     * For example indices that don't exist.  
 * Unless required by applicable law or agreed to in writing,
    }
        return this;
    /**
     *
     * An optional timeout to control how long search is allowed to take.
 * Modifications Copyright OpenSearch Contributors. See
    /**
        this.request.setPreFilterShardSize(preFilterShardSize);
        sourceBuilder().scriptField(name, script);
    /**
        this.request.setBatchedReduceSize(batchedReduceSize);  
        return this;  
     * <li>The request targets one or more read-only index</li>
     * Adds a derived field of a given type. The script provided will be used to derive the value
        sourceBuilder().aggregation(aggregation);
        sourceBuilder().fetchSource(include, exclude);  
    }
    }  
     * instance a shard can not match any documents based on its rewrite method ie. if date filters are mandatory to match but the shard
    public SearchRequestBuilder setRescorer(RescorerBuilder rescorer, int window) {
        sourceBuilder().docValueField(name, format);
     * @return this for chaining  
     * @param rescorer rescorer configuration
 * @opensearch.api
     * @param format an optional format string used when formatting values, for example a date format.  
    /**
     * Sets the preference to execute the search. Defaults to randomize across shards. Can be set to
     * Delegates to {@link SearchSourceBuilder#suggest(SuggestBuilder)}
    }
    }
    }  
     * <ul>  
        return this;  
    /**  
        sourceBuilder().clearRescorers();
     * will default to the cluster level setting).  
    }  
    public SearchRequestBuilder addSort(SortBuilder<?> sort) {
        return this;
        return this;
        request.preference(preference);
    /**
    @Override
import org.opensearch.search.builder.PointInTimeBuilder;
    /**
    public SearchRequestBuilder addScriptField(String name, Script script) {
 * specific language governing permissions and limitations
    public SearchRequestBuilder addRescorer(RescorerBuilder<?> rescorer, int window) {
    }
     */
 * under the License.  
    }
     * @param script The script to use
     * Adds stored fields to load and return (note, it must be stored) as part of the search request.
 * A search action request builder.
     * If set, will enable scrolling of the search request for the specified timeout.
     *  
     */
    /**
    public SearchRequestBuilder setSearchType(SearchType searchType) {
    }
}  
        return this;  
    }
     * but its recommended to use non analyzed or numeric fields.
        return this;
import org.opensearch.search.collapse.CollapseBuilder;
        sourceBuilder().query(queryBuilder);
    }  
     * Clears all rescorers on the builder and sets the first one.  To use multiple rescore windows use
        this.request.setMaxConcurrentShardRequests(maxConcurrentShardRequests);
 * not use this file except in compliance with the License.
     */
        sourceBuilder().addRescorer(rescorer);
    }
        sourceBuilder().trackTotalHitsUpTo(trackTotalHitsUpTo);  
     * will be used across different requests.
        sourceBuilder().slice(builder);
import org.opensearch.search.builder.SearchSourceBuilder;  
        sourceBuilder().sort(field, order);
     */  
        return this;
     * but its recommended to use non analyzed or numeric fields.  
        sourceBuilder().suggest(suggestBuilder);
     *
     * <li>The primary sort of the query targets an indexed field</li>  
    /**  
    public SearchRequestBuilder setPointInTime(PointInTimeBuilder pointInTimeBuilder) {
        return this;  
        return this;
import org.opensearch.action.ActionRequestBuilder;
     * A comma separated list of routing values to control the shards the search will be executed on.
     * When unspecified, the pre-filter phase is executed if any of these conditions is met:
        sourceBuilder().storedField(field);
    public SearchRequestBuilder setSearchType(String searchType) {
     *
    }  
     */  
        return this;  
    /**
        return this;
    /**
    public SearchRequestBuilder setTrackTotalHitsUpTo(int trackTotalHitsUpTo) {
    /**  
     * Applies when fetching scores with named queries, and controls if scores will be tracked as well.
import org.opensearch.transport.client.OpenSearchClient;
     */
     * @param order The sort ordering
     */
     * the search request expands to exceeds the threshold. This filter roundtrip can limit the number of shards significantly if for
    }
     * @return this for chaining
     * Adds a docvalue based field to load and return. The field does not have to be stored,
     *  
        sourceBuilder().highlighter(highlightBuilder);  
     */
        return this;  
     * Sets the number of shard results that should be reduced at once on the coordinating node. This value should be used as a protection
     */  
    public SearchRequestBuilder setRequestCache(Boolean requestCache) {
