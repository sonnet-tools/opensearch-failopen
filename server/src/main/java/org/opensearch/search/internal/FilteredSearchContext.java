    @Override
    @Override
    @Override  
 * Unless required by applicable law or agreed to in writing,
    }  
    @Override  
    }  
        return in.getObjectMapper(name);
    public void timeout(TimeValue timeout) {  
    @Override  
    @Override
    }
    @Override
    public ReaderContext readerContext() {
 * software distributed under the License is distributed on an
    @Override
    @Override
        return in.trackTotalHitsUpTo();
 *
    }  
import org.apache.lucene.search.FieldDoc;  
    }  
        return in.queryResult();
    public boolean hasScriptFields() {
        return in.queryBoost();  
        return in.from(from);  
    }
 * KIND, either express or implied.  See the License for the
    @Override
        return in.bitsetFilterCache();  
    }
        return in.hasFetchSourceContext();
        return in.timeout();
    }  
    @Override
    public FieldDoc searchAfter() {
    }  
    @Override  
        return in.fetchSourceContext();
    public int docIdsToLoadFrom() {
 * compatible open source license.
public abstract class FilteredSearchContext extends SearchContext {
import org.opensearch.search.query.QuerySearchResult;
    }
        return in.getStarTreeIndexEnabled();
    }
        return in.getPartitionMinSegmentSize();  
        in.seqNoAndPrimaryTerm(seqNoAndPrimaryTerm);
 *
    public void terminateAfter(int terminateAfter) {
    }
    @Override  
    }
    }
    @Override
    }  
        in.explain(explain);
        return in.scriptFields();
        return in.fetchResult();
import org.opensearch.search.query.ReduceableSearchResult;  
        return in.docIdsToLoad(docIdsToLoad, docsIdsToLoadFrom, docsIdsToLoadSize);
 *
    }
    public Float minimumScore() {
    }
    @Override
    public SearchContext fetchSourceContext(FetchSourceContext fetchSourceContext) {
        return in.shouldUseIntraSegmentSearch();
    }  
    }
    public boolean lowLevelCancellation() {  
        return in.getSearchExt(name);
        in.doClose();  
        return in.sort(sort);
    public SearchContext parsedPostFilter(ParsedQuery postFilter) {  
    public void setBucketCollectorProcessor(BucketCollectorProcessor bucketCollectorProcessor) {  
        return in.getTask();
        in.terminateAfter(terminateAfter);
    @Override
    public boolean hasFetchSourceContext() {
    }  
    }
    @Override
package org.opensearch.search.internal;
 * the Apache License, Version 2.0 (the "License"); you may
    public SearchContext aggregations(SearchContextAggregations aggregations) {
    public QuerySearchResult queryResult() {
        return in.aggregations(aggregations);  
        in.version(version);
import org.opensearch.index.query.QueryShardContext;
    @Override
    @Override
    }
    @Override
        return in.seqNoAndPrimaryTerm();  
    }
    }
    public ScrollContext scrollContext() {
    }  
        return in.size();
    }
    @Override
    }
    public TimeValue timeout() {
    public MapperService mapperService() {
import org.opensearch.search.aggregations.SearchContextAggregations;  
 * license agreements. See the NOTICE file distributed with
    public Query query() {
    @Override  
    public SearchContextAggregations aggregations() {  
    public SearchExtBuilder getSearchExt(String name) {  
    }
    public SearchContext from(int from) {
    }  
 * Context used during a filtered search  
    public boolean trackScores() {  
    }  
import org.opensearch.search.suggest.SuggestionSearchContext;  
import org.opensearch.search.fetch.subphase.InnerHitsContext;
import org.opensearch.search.SearchExtBuilder;
    @Override
    @Override  
    @Override  
    public CollapseContext collapse() {
    }
    @Override  
    }
    public ShardSearchContextId id() {
 */  
    }
        return in.shouldUseTimeSeriesDescSortOptimization();  
    @Override
        in.highlight(highlight);
        return in.searcher();
        return in.rescore();  
        return in.fetchSourceContext(fetchSourceContext);  
    public SortAndFormats sort() {
import org.opensearch.search.collapse.CollapseContext;
    }  
    public SearchContext trackTotalHitsUpTo(int trackTotalHitsUpTo) {
    }
    @Override  
    }
        return in.similarityService();
    }
        return in.dfsResult();  
        in.setTask(task);  
        return in.getPartitionStrategy();
    public boolean seqNoAndPrimaryTerm() {
        return in.lowLevelCancellation();
    }  
    @Override  
import org.apache.lucene.search.Collector;
import org.apache.lucene.search.CollectorManager;
    }
    @Override
 *    http://www.apache.org/licenses/LICENSE-2.0
    @Override
        return in.includeNamedQueriesScore(includeNamedQueriesScore);
import org.opensearch.common.util.BigArrays;
/*  
    @Override  
    public int size() {
    }  
        return in.storedFieldsContext(storedFieldsContext);
    public ScriptFieldsContext scriptFields() {  
/*  
    public SearchContext sort(SortAndFormats sort) {  
    }
    public boolean shouldUseTimeSeriesDescSortOptimization() {
    public boolean explain() {
    public SearchContext minimumScore(float minimumScore) {
        in.groupStats(groupStats);  
    public boolean isCancelled() {  
    @Override
        return in.shouldUseConcurrentSearch();
    @Override
        return in.minimumScore(minimumScore);  
        this.in = in;  
    public long getRelativeTimeInMillis() {
    @Override
        return in.docIdsToLoad();
        return in.bucketCollectorProcessor();  
        return in.readerContext();  
    }
    @Override
        return in.collapse();
import org.opensearch.search.aggregations.BucketCollectorProcessor;
    }  
    public ParsedQuery parsedQuery() {
    public StoredFieldsContext storedFieldsContext() {
    @Override  
    public Map<Class<?>, CollectorManager<? extends Collector, ReduceableSearchResult>> queryCollectorManagers() {
    public List<RescoreContext> rescore() {
    public void version(boolean version) {  
 * @opensearch.internal
    }
    @Override
        return in.size(size);
    @Override  
    }
        return in.suggest();
    @Override  
 * ownership. Elasticsearch licenses this file to you under  
    }
import java.util.Map;  
    }
        return in.getProfilers();  
    @Override
    }
    public boolean includeNamedQueriesScore() {
    @Override
        return in.hasScriptFields();
        return in.getQueryShardContext();
/**
        return in.mapperService();  
 * this work for additional information regarding copyright
        return in.searchAfter();  
 * Modifications Copyright OpenSearch Contributors. See
    @Override
    }
    public ObjectMapper getObjectMapper(String name) {  
import org.opensearch.search.profile.Profilers;
    @Override
    @Override  
    public Profilers getProfilers() {
    }
    }
    }
    }
    public MappedFieldType fieldType(String name) {
    @Override
    @Override  
    @Override
    }
        return in.numberOfShards();
    @Override
        return in.sort();  
    public IndexShard indexShard() {  
    public boolean sourceRequested() {
    }
import org.opensearch.index.mapper.MappedFieldType;
    public SearchContext searchAfter(FieldDoc searchAfter) {  
 */  
    @Override  
    @Override
    public SearchContext parsedQuery(ParsedQuery query) {  
        return in.request();
    @Override
import org.opensearch.action.search.SearchType;  
    @Override  
    public float queryBoost() {
import org.opensearch.index.cache.bitset.BitsetFilterCache;  
        return in.collapse(collapse);  
import org.opensearch.common.unit.TimeValue;
 * not use this file except in compliance with the License.
        return in.trackTotalHitsUpTo(trackTotalHitsUpTo);  
        return in.includeNamedQueriesScore();
    public InnerHitsContext innerHits() {
    public ShardSearchRequest request() {  
    }  
    @Override
    @Override  
        return in.getTargetMaxSliceCount();
    public void suggest(SuggestionSearchContext suggest) {  
    @Override
    @Override
    public void explain(boolean explain) {
}
        return in.fetchPhase();  
    public int numberOfShards() {  
        return in.aliasFilter();
import org.opensearch.search.fetch.subphase.highlight.SearchHighlightContext;  
        return in.groupStats();
    }
    }  
    public void addSearchExt(SearchExtBuilder searchExtBuilder) {
        return in.innerHits();  
    @Override
import org.opensearch.search.dfs.DfsSearchResult;
    }
    public BitsetFilterCache bitsetFilterCache() {
        return in.query();
        in.addSearchExt(searchExtBuilder);
    public boolean shouldUseConcurrentSearch() {
    public FetchSearchResult fetchResult() {  
import org.opensearch.action.search.SearchShardTask;
    public int terminateAfter() {
    @Override
    }
        return in.isCancelled();
    @Override  
    public QueryShardContext getQueryShardContext() {  
    @Override
    }
    }
        return in.source();
    }  
    @Override
    public String getPartitionStrategy() {  
    public int[] docIdsToLoad() {  
 */  
        in.timeout(timeout);
    }  
        return in.bigArrays();
import org.opensearch.index.similarity.SimilarityService;
import org.apache.lucene.search.Query;
    @Override  
    public int from() {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    @Override
 * specific language governing permissions and limitations
    public void setTask(SearchShardTask task) {
    protected void doClose() {
    }
    }
    public FilteredSearchContext(SearchContext in) {
    @Override
    private final SearchContext in;  
    @Override  
    public Query aliasFilter() {
        return in.parsedPostFilter();  
    public boolean shouldUseIntraSegmentSearch() {
 * Licensed to Elasticsearch under one or more contributor  
    }
    @Override
    }  
    }
    @Override  
    }
    }
    }  
    }
    }  
import org.opensearch.search.fetch.subphase.ScriptFieldsContext;
 *  
    }  
        return in.getRelativeTimeInMillis();  
 * SPDX-License-Identifier: Apache-2.0
    @Override
    @Override
    }  
    public void addRescore(RescoreContext rescore) {  
    @Override
    public boolean version() {
    public SuggestionSearchContext suggest() {
    public int trackTotalHitsUpTo() {
    public Query buildFilteredQuery(Query query) {  
    public SearchContext includeNamedQueriesScore(boolean includeNamedQueriesScore) {  
    }
    @Override  
        return in.shardTarget();
 * You may obtain a copy of the License at  
    @Override  
    public SearchContext docIdsToLoad(int[] docIdsToLoad, int docsIdsToLoadFrom, int docsIdsToLoadSize) {  
        in.setBucketCollectorProcessor(bucketCollectorProcessor);
    public int getTargetMaxSliceCount() {  
    }  
 * GitHub history for details.
    public SearchShardTarget shardTarget() {
    public SearchContext collapse(CollapseContext collapse) {
        return in.terminateAfter();  
import org.opensearch.search.fetch.FetchSearchResult;
        return in.sourceRequested();  
        return in.storedFieldsContext();
        return in.trackScores();
 * The OpenSearch Contributors require contributions made to  
 * this file be licensed under the Apache-2.0 license or a
        return in.buildFilteredQuery(query);
    }
    }
    public SearchContext trackScores(boolean trackScores) {
    }
    @Override
        return in.from();
        return in.parsedQuery(query);
    @Override
    @Override
    public int getPartitionMinSegmentSize() {
import org.opensearch.search.fetch.subphase.FetchSourceContext;  
        return in.partialOnShard();
    }
import org.opensearch.index.query.ParsedQuery;
    @Override
import org.opensearch.index.shard.IndexShard;  
    @Override
        return in.version();
    public SearchContext size(int size) {  
    @Override
    public int docIdsToLoadSize() {
    @Override
    }  
import java.util.List;
    @Override
        return in.explain();  
    public BigArrays bigArrays() {  
    public SimilarityService similarityService() {
        return in.trackScores(trackScores);
import org.opensearch.search.SearchShardTarget;  
    }  
    }
    }
        in.suggest(suggest);
    }
    }
        return in.hasStoredFieldsContext();
    public void seqNoAndPrimaryTerm(boolean seqNoAndPrimaryTerm) {
    @Override
    public boolean getStarTreeIndexEnabled() {
    public void preProcess(boolean rewrite) {
    @Override  
        return in.indexShard();
    }  
    public SearchHighlightContext highlight() {
        return in.storedFieldsRequested();  
    public SearchType searchType() {
        return in.aggregations();
    }
        return in.highlight();
    @Override
    public SearchContext storedFieldsContext(StoredFieldsContext storedFieldsContext) {  
    public InternalAggregation.ReduceContext partialOnShard() {
        return in.searchType();  
    }  
import org.opensearch.index.mapper.ObjectMapper;  
    @Override
        return in.scrollContext();
    public DfsSearchResult dfsResult() {
    }  
import org.opensearch.index.mapper.MapperService;
    public void groupStats(List<String> groupStats) {
    @Override  
import org.opensearch.search.fetch.FetchPhase;  
import org.opensearch.search.fetch.StoredFieldsContext;
    @Override
import org.opensearch.search.aggregations.InternalAggregation;
        return in.minimumScore();
    }
    }
    @Override
    public SearchShardTask getTask() {
        return in.queryCollectorManagers();
    public List<String> groupStats() {  
    @Override  
    @Override
    public FetchSourceContext fetchSourceContext() {  
    @Override
    @Override
        return in.id();  
    public ContextIndexSearcher searcher() {
 * under the License.  
import org.opensearch.search.rescore.RescoreContext;
    public boolean hasStoredFields() {
        return in.parsedPostFilter(postFilter);
    }  
    public boolean hasStoredFieldsContext() {  
import org.opensearch.search.sort.SortAndFormats;
    public BucketCollectorProcessor bucketCollectorProcessor() {
    }
    }
    }
    @Override
    }
    }  
    @Override  
 */
    @Override
    @Override  
    @Override
        in.preProcess(rewrite);
    @Override  
    }
        return in.fieldType(name);
        return in.docIdsToLoadFrom();  
        in.addRescore(rescore);
    public boolean storedFieldsRequested() {
        return in.hasStoredFields();
    public FetchPhase fetchPhase() {
        return in.searchAfter(searchAfter);
        return in.parsedQuery();  
    }  
    public String source() {
    public ParsedQuery parsedPostFilter() {
    @Override  
/*
    }
    @Override
        return in.docIdsToLoadSize();
    }
    @Override  
    @Override
    }  
    public void highlight(SearchHighlightContext highlight) {  
