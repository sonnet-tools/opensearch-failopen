    }
 * Modifications Copyright OpenSearch Contributors. See
    public void explain(boolean explain) {
    }
    @Override
    @Override
    }
    }
        return in.rescore();
    }
    }
    @Override
        return in.parsedPostFilter();
    @Override
        return in.searchAfter();
    @Override
    @Override
    public SearchContext collapse(CollapseContext collapse) {
        return in.hasStoredFieldsContext();
    public ShardSearchContextId id() {
        return in.searcher();
import org.opensearch.search.fetch.subphase.FetchSourceContext;
    }
        return in.hasScriptFields();
import org.opensearch.search.fetch.FetchPhase;
        return in.docIdsToLoadSize();
    public InnerHitsContext innerHits() {
    @Override
    public SearchContext parsedPostFilter(ParsedQuery postFilter) {
    }
    public ContextIndexSearcher searcher() {
        return in.trackScores();
        return in.trackScores(trackScores);
    }
    }
    public MapperService mapperService() {
    public int getPartitionMinSegmentSize() {
    }
package org.opensearch.search.internal;
    public ScriptFieldsContext scriptFields() {
    public void seqNoAndPrimaryTerm(boolean seqNoAndPrimaryTerm) {
    @Override
        return in.minimumScore();
    @Override
    }
        return in.sort();
    public SortAndFormats sort() {
import org.opensearch.action.search.SearchType;
    @Override
import org.opensearch.search.aggregations.SearchContextAggregations;
    public SearchContext parsedQuery(ParsedQuery query) {
        return in.bitsetFilterCache();
    private final SearchContext in;
    }
    }
import org.opensearch.search.SearchExtBuilder;
    public BucketCollectorProcessor bucketCollectorProcessor() {
        in.groupStats(groupStats);
    public boolean sourceRequested() {
    }
        return in.fetchPhase();
        return in.from();
    public void suggest(SuggestionSearchContext suggest) {
import org.opensearch.index.cache.bitset.BitsetFilterCache;
    @Override
    }
import org.opensearch.index.query.ParsedQuery;
 * The OpenSearch Contributors require contributions made to
    @Override
    }
    @Override
        in.addSearchExt(searchExtBuilder);
    public void setTask(SearchShardTask task) {
    @Override
    @Override
    }
    }
    @Override
 * ownership. Elasticsearch licenses this file to you under
    @Override
import org.opensearch.index.query.QueryShardContext;
    @Override
    public boolean shouldUseTimeSeriesDescSortOptimization() {
    }
    }
    public int getTargetMaxSliceCount() {
    }
    public FetchSearchResult fetchResult() {
    @Override
    @Override
    @Override
        return in.getSearchExt(name);
 * SPDX-License-Identifier: Apache-2.0
    public ScrollContext scrollContext() {
    }
    public String source() {
        return in.trackTotalHitsUpTo(trackTotalHitsUpTo);
    public FetchPhase fetchPhase() {
    }
        return in.aggregations(aggregations);
    public List<String> groupStats() {
    }
        return in.groupStats();
    public SearchContext storedFieldsContext(StoredFieldsContext storedFieldsContext) {
    public FieldDoc searchAfter() {
    public Float minimumScore() {
    public long getRelativeTimeInMillis() {
 */
    public boolean hasStoredFieldsContext() {
 * KIND, either express or implied.  See the License for the
    }
    public SearchContext fetchSourceContext(FetchSourceContext fetchSourceContext) {
    public int docIdsToLoadFrom() {
    }
    }
    public int terminateAfter() {
    public int[] docIdsToLoad() {
    public StoredFieldsContext storedFieldsContext() {
 */
        in.suggest(suggest);
    @Override
    public ParsedQuery parsedPostFilter() {
import org.apache.lucene.search.CollectorManager;
    }
        return in.docIdsToLoad(docIdsToLoad, docsIdsToLoadFrom, docsIdsToLoadSize);
        return in.explain();
    public void version(boolean version) {
    }
/*
    @Override
        return in.aliasFilter();
        return in.getQueryShardContext();
    }
    public SearchShardTask getTask() {
        return in.searchAfter(searchAfter);
    }
        return in.hasStoredFields();
    }
        return in.includeNamedQueriesScore();
import org.opensearch.search.aggregations.InternalAggregation;
    public List<RescoreContext> rescore() {
    }
    public boolean includeNamedQueriesScore() {
        return in.parsedPostFilter(postFilter);
    }
    @Override
    }
    @Override
    }
    @Override
        return in.parsedQuery(query);
    }
        return in.seqNoAndPrimaryTerm();
import org.apache.lucene.search.Collector;
    public QuerySearchResult queryResult() {
 * software distributed under the License is distributed on an
    }
        return in.getRelativeTimeInMillis();
        return in.size();
    }
    }
 *
public abstract class FilteredSearchContext extends SearchContext {
        return in.getProfilers();
    public void timeout(TimeValue timeout) {
    public SearchShardTarget shardTarget() {
 *
    }
        return in.similarityService();
    }
        return in.suggest();
    }
    }
        return in.scrollContext();
    protected void doClose() {
 *
    }
        return in.getObjectMapper(name);
    public InternalAggregation.ReduceContext partialOnShard() {
    public boolean hasFetchSourceContext() {
    }
    }
    public SearchContext searchAfter(FieldDoc searchAfter) {
import org.opensearch.search.dfs.DfsSearchResult;
import org.opensearch.search.fetch.StoredFieldsContext;
        return in.docIdsToLoad();
        in.terminateAfter(terminateAfter);
    @Override
    public ReaderContext readerContext() {
import org.opensearch.index.similarity.SimilarityService;
    public boolean hasStoredFields() {
import org.opensearch.search.fetch.subphase.ScriptFieldsContext;
    }
    }
    public String getPartitionStrategy() {
    public MappedFieldType fieldType(String name) {
    public boolean seqNoAndPrimaryTerm() {
    }
    }
    @Override
    }
    public Query aliasFilter() {
 */
    }
/**
        return in.bucketCollectorProcessor();
    @Override
        return in.version();
import org.opensearch.search.SearchShardTarget;
import org.opensearch.search.suggest.SuggestionSearchContext;
        in.version(version);
    @Override
        return in.storedFieldsContext(storedFieldsContext);
    public Profilers getProfilers() {
    }
import org.opensearch.index.mapper.ObjectMapper;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    public int size() {
    @Override
        return in.shardTarget();
        return in.innerHits();
        return in.storedFieldsRequested();
    @Override
    @Override
    }
import org.opensearch.common.util.BigArrays;
        return in.queryCollectorManagers();
    @Override
        return in.parsedQuery();
    public FilteredSearchContext(SearchContext in) {
    @Override
    }
    @Override
    @Override
 * license agreements. See the NOTICE file distributed with
        return in.id();
    public float queryBoost() {
        in.seqNoAndPrimaryTerm(seqNoAndPrimaryTerm);
    @Override
    }
        return in.scriptFields();
    @Override
    }
    @Override
    @Override
import org.opensearch.search.profile.Profilers;
    public FetchSourceContext fetchSourceContext() {
    }
    public SearchContext size(int size) {
        return in.fetchResult();
import org.opensearch.search.fetch.FetchSearchResult;
    @Override
    }
        return in.indexShard();
    public SearchContext minimumScore(float minimumScore) {
    public BigArrays bigArrays() {
        return in.shouldUseIntraSegmentSearch();
 */
    @Override
    public CollapseContext collapse() {
    @Override
    }
        return in.numberOfShards();
        return in.query();
    @Override
    @Override
    public boolean lowLevelCancellation() {
 * not use this file except in compliance with the License.
        return in.buildFilteredQuery(query);
        return in.size(size);
        return in.fetchSourceContext(fetchSourceContext);
import org.opensearch.index.mapper.MapperService;
    @Override
    }
    public SearchContext aggregations(SearchContextAggregations aggregations) {
    @Override
 * Unless required by applicable law or agreed to in writing,
    @Override
        in.setBucketCollectorProcessor(bucketCollectorProcessor);
    }
    public boolean shouldUseConcurrentSearch() {
    public ParsedQuery parsedQuery() {
    }
        return in.fetchSourceContext();
    @Override
    }
    @Override
import org.apache.lucene.search.Query;
 * compatible open source license.
        return in.from(from);
    @Override
    }
    @Override
    public SearchContextAggregations aggregations() {
    }
    }
import org.opensearch.common.unit.TimeValue;
    public SearchContext trackTotalHitsUpTo(int trackTotalHitsUpTo) {
        in.preProcess(rewrite);
    public IndexShard indexShard() {
    }
    @Override
        in.addRescore(rescore);
        return in.queryBoost();
    }
 * Context used during a filtered search
        return in.bigArrays();
    @Override
    public SearchExtBuilder getSearchExt(String name) {
    }
    }
    @Override
 * under the License.
    public boolean storedFieldsRequested() {
    @Override
    public SuggestionSearchContext suggest() {
    }
    @Override
        return in.includeNamedQueriesScore(includeNamedQueriesScore);
        in.doClose();
import org.opensearch.action.search.SearchShardTask;
    @Override
        return in.request();
 * specific language governing permissions and limitations
        return in.getPartitionStrategy();
        return in.collapse(collapse);
    @Override
    }
        return in.getPartitionMinSegmentSize();
    }
    }
    @Override
    @Override
    public boolean getStarTreeIndexEnabled() {
    @Override
    public boolean hasScriptFields() {
    }
        return in.storedFieldsContext();
    public void preProcess(boolean rewrite) {
    @Override
    @Override
        return in.timeout();
import org.opensearch.search.query.QuerySearchResult;
    @Override
    @Override
        return in.getStarTreeIndexEnabled();
        return in.readerContext();
    public DfsSearchResult dfsResult() {
    @Override
    }
 * this file be licensed under the Apache-2.0 license or a
    }
        return in.docIdsToLoadFrom();
    public int from() {
import org.opensearch.index.shard.IndexShard;
    @Override
        this.in = in;
    public SearchHighlightContext highlight() {
        return in.terminateAfter();
    @Override
    }
    }
        return in.trackTotalHitsUpTo();
    public boolean isCancelled() {
    }
    public SearchContext docIdsToLoad(int[] docIdsToLoad, int docsIdsToLoadFrom, int docsIdsToLoadSize) {
    @Override
    public void terminateAfter(int terminateAfter) {
    public void addSearchExt(SearchExtBuilder searchExtBuilder) {
        return in.source();
    @Override
        in.explain(explain);
    @Override
    public SearchContext sort(SortAndFormats sort) {
    }
    @Override
    }
    public BitsetFilterCache bitsetFilterCache() {
    @Override
    public SearchContext from(int from) {
}
        return in.partialOnShard();
    @Override
    public int numberOfShards() {
    public SearchContext trackScores(boolean trackScores) {
    @Override
    public int docIdsToLoadSize() {
    @Override
    public void groupStats(List<String> groupStats) {
 * the Apache License, Version 2.0 (the "License"); you may
    }
    }
    public Query buildFilteredQuery(Query query) {
    @Override
 * GitHub history for details.
    public boolean version() {
    public ShardSearchRequest request() {
    @Override
    }
    @Override
        return in.hasFetchSourceContext();
import org.opensearch.search.collapse.CollapseContext;
import org.apache.lucene.search.FieldDoc;
    @Override
    }
    @Override
    }
import org.opensearch.search.sort.SortAndFormats;
    public boolean explain() {
    public void highlight(SearchHighlightContext highlight) {
 * You may obtain a copy of the License at
    public int trackTotalHitsUpTo() {
 * @opensearch.internal
        return in.queryResult();
        return in.collapse();
    @Override
    }
/*
    @Override
import org.opensearch.search.rescore.RescoreContext;
 * this work for additional information regarding copyright
    public SimilarityService similarityService() {
    }
    public SearchType searchType() {
        return in.aggregations();
 * Licensed to Elasticsearch under one or more contributor
        in.highlight(highlight);
    @Override
        return in.sort(sort);
    }
        return in.highlight();
    public QueryShardContext getQueryShardContext() {
    public Map<Class<?>, CollectorManager<? extends Collector, ReduceableSearchResult>> queryCollectorManagers() {
        return in.searchType();
    @Override
import org.opensearch.search.query.ReduceableSearchResult;
    @Override
import java.util.Map;
import org.opensearch.search.fetch.subphase.InnerHitsContext;
import org.opensearch.search.fetch.subphase.highlight.SearchHighlightContext;
        return in.shouldUseTimeSeriesDescSortOptimization();
        return in.isCancelled();
    @Override
    public SearchContext includeNamedQueriesScore(boolean includeNamedQueriesScore) {
    public void setBucketCollectorProcessor(BucketCollectorProcessor bucketCollectorProcessor) {
/*
    }
    @Override
    public boolean shouldUseIntraSegmentSearch() {
        return in.getTargetMaxSliceCount();
    @Override
    public ObjectMapper getObjectMapper(String name) {
    @Override
        return in.sourceRequested();
import java.util.List;
import org.opensearch.index.mapper.MappedFieldType;
        return in.getTask();
        in.setTask(task);
import org.opensearch.search.aggregations.BucketCollectorProcessor;
    }
    @Override
        return in.mapperService();
 *
    @Override
    }
    @Override
        return in.minimumScore(minimumScore);
    }
        return in.shouldUseConcurrentSearch();
    }
    }
    public void addRescore(RescoreContext rescore) {
    }
        return in.lowLevelCancellation();
    @Override
    }
    }
    public TimeValue timeout() {
    }
    }
    public boolean trackScores() {
        return in.fieldType(name);
    public Query query() {
    @Override
    @Override
    }
        in.timeout(timeout);
        return in.dfsResult();
    @Override
    @Override
 *    http://www.apache.org/licenses/LICENSE-2.0
    @Override
    @Override
