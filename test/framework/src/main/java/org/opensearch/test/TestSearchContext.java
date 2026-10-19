    public InternalAggregation.ReduceContext partialOnShard() {
        return false;
    @Override
        }
    public SearchContext includeNamedQueriesScore(boolean includeNamedQueriesScore) {
    }
    }
/*
        this.indexShard = indexService.getShardOrNull(0);
            return indexService.mapperService();  
    private FieldDoc searchAfter;
        this.originalQuery = query;  
    public void highlight(SearchHighlightContext highlight) {}  
        throw new UnsupportedOperationException();
    @Override  
 * this file be licensed under the Apache-2.0 license or a
    }
import org.opensearch.search.fetch.FetchSearchResult;  
        return bigArrays;  
    }
    }
        return Collections.emptyList();  
    }
    }
    final QuerySearchResult queryResult = new QuerySearchResult();
    public Query buildFilteredQuery(Query query) {
        return null;
    private final Map<String, SearchExtBuilder> searchExtBuilders = new HashMap<>();
        return concurrentSegmentSearchEnabled;
        return null;
import org.opensearch.index.query.ParsedQuery;  
            && sort.isSortOnTimeSeriesField()  
import org.opensearch.index.mapper.MapperService;
public class TestSearchContext extends SearchContext {  
     * Clean the query results by consuming all of it  
    }
    @Override
    );  
    public int from() {
    }
    public TestSearchContext(  
    public SearchContext trackTotalHitsUpTo(int trackTotalHitsUpTo) {
    public void groupStats(List<String> groupStats) {}
    }
        return this;
    public FetchSearchResult fetchResult() {
    @Override  
    public boolean explain() {  
        new ShardId("test", "test", 0),  
        this.bucketCollectorProcessor = bucketCollectorProcessor;
    }
        this.minScore = minimumScore;  
import org.apache.lucene.search.Query;  
        return includeNamedQueriesScore;  
import org.opensearch.action.search.SearchType;  
    }
    }
     */
    public TestSearchContext(QueryShardContext queryShardContext, IndexShard indexShard, ContextIndexSearcher searcher) {
    public SearchShardTarget shardTarget() {
    }
        return false;
import org.opensearch.search.fetch.subphase.ScriptFieldsContext;
        this.concurrentSegmentSearchEnabled = concurrentSegmentSearchEnabled;  
    public ScrollContext scrollContext() {
 */
    /**  
    @Override  
import org.opensearch.action.search.SearchShardTask;
        assert concurrentSegmentSearchEnabled == true : "Please use concurrent search before fetching maxSliceCount";  
    }
import org.opensearch.core.index.shard.ShardId;  
    }
    }  
            && sort != null
        return null;
    }
    @Override  
 * The OpenSearch Contributors require contributions made to  
import java.util.Collections;
 * this work for additional information regarding copyright
        return null;
import org.opensearch.search.fetch.subphase.FetchFieldsContext;  
import org.opensearch.search.sort.SortAndFormats;
        return false;
 *
import org.opensearch.search.fetch.subphase.highlight.SearchHighlightContext;  
 * KIND, either express or implied.  See the License for the
        return TimeValue.ZERO;
    public int trackTotalHitsUpTo() {
        return false;
    @Override
    }
    public SearchContext minimumScore(float minimumScore) {
        return false;  
    public Query query() {
    @Override  
    public ShardSearchRequest request() {
import org.opensearch.action.OriginalIndices;
    public void version(boolean version) {}  
        return this;  
    }
    }  
    @Override
    public List<String> groupStats() {
    public int[] docIdsToLoad() {
    }  
    public DfsSearchResult dfsResult() {  
    }  
import org.apache.lucene.search.CollectorManager;
    @Override
    @Override
        this(queryShardContext, indexShard, searcher, null);  
        "test",
    @Override
    @Override  
        return null;  
     * Sets the concurrent segment search enabled field  
    public boolean getStarTreeIndexEnabled() {
    private BucketCollectorProcessor bucketCollectorProcessor = NO_OP_BUCKET_COLLECTOR_PROCESSOR;
    public SearchHighlightContext highlight() {
        queryShardContext = indexService.newQueryShardContext(0, null, () -> 0L, null);  
    public SearchContext docIdsToLoad(int[] docIdsToLoad, int docsIdsToLoadFrom, int docsIdsToLoadSize) {
        this.from = from;
    }
    final IndexShard indexShard;  
    public boolean trackScores() {  
        this.indexService = indexService;  
import org.opensearch.search.query.ReduceableSearchResult;  
    /**
        if (indexService != null) {
    /**  
        IndexShard indexShard,
        return queryResult;  
        }
import org.opensearch.index.mapper.MappedFieldType;  
    @Override
    public void addSearchExt(SearchExtBuilder searchExtBuilder) {  
        return aggregations;
        return false;
    }
    @Override
    @Override
    public int terminateAfter() {
    public BucketCollectorProcessor bucketCollectorProcessor() {  
        return new ShardSearchContextId("", 0);
    public TestSearchContext withCleanQueryResult() {
    public int getTargetMaxSliceCount() {
    }
    public FetchSourceContext fetchSourceContext() {  
import org.opensearch.search.collapse.CollapseContext;  
        return originalQuery;
        this.collapse = collapse;  
    @Override
    @Override
    @Override
    }  
        return searchExtBuilders.get(name);  
    public BitsetFilterCache bitsetFilterCache() {
    public void timeout(TimeValue timeout) {}
    final QueryShardContext queryShardContext;
    public boolean shouldUseIntraSegmentSearch() {
            && sort.sort.getSort()[0].getReverse() == false;
        this.fixedBitSetFilterCache = indexService.cache().bitsetFilterCache();
        this.searcher = searcher;  
    }
    @Override
    }
        OriginalIndices.NONE
import org.opensearch.index.IndexService;
    @Override  
    }  
    protected boolean concurrentSegmentSearchEnabled;
        return false;  
    @Override  
    }  
    public SearchShardTask getTask() {  
    }  
import org.opensearch.index.query.QueryShardContext;
    @Override  
import org.opensearch.index.mapper.ObjectMapper;
        return indexShard;  
        return null;  
        return postFilter;
            && indexShard.isTimeSeriesDescSortOptimizationEnabled()
    public void seqNoAndPrimaryTerm(boolean seqNoAndPrimaryTerm) {
    }
    @Override
    public ParsedQuery parsedQuery() {  
import org.opensearch.search.suggest.SuggestionSearchContext;  
     */
    }
        searchExtBuilders.put(searchExtBuilder.getWriteableName(), searchExtBuilder);
    @Override
    @Override
    }
        this(queryShardContext, indexShard, null);
    public boolean storedFieldsRequested() {  
    public TestSearchContext withProfilers() {
    @Override
        return trackTotalHitsUpTo;
    public FieldDoc searchAfter() {  
    ParsedQuery postFilter;
    @Override
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }  
    @Override
        return indexShard != null  
    public SearchContext parsedPostFilter(ParsedQuery postFilter) {
    }
    private Profilers profilers;
    public String source() {
    }  
    @Override
    public boolean sourceRequested() {
    public void addRescore(RescoreContext rescore) {
    public Map<Class<?>, CollectorManager<? extends Collector, ReduceableSearchResult>> queryCollectorManagers() {  
    public long getRelativeTimeInMillis() {  
    @Override
    }
    }
        return null;
    @Override
    @Override
        return null;
     */  
        return searcher;
    public static final SearchShardTarget SHARD_TARGET = new SearchShardTarget(
        return 0;
    }
    @Override
        null,
        return task.isCancelled();  
    }
    public boolean lowLevelCancellation() {  
    }
        return this;
    @Override
    }  
    }
        profilers = null;
        return this;
    final BigArrays bigArrays;
    Float minScore;  
    }
    @Override
    private SearchContextAggregations aggregations;
    public boolean hasStoredFields() {
    @Override
    @Override  
        return this;
        return collapse;  
    }
    }
        return new int[0];
    public boolean shouldUseTimeSeriesDescSortOptimization() {
        return this;  
    }
        this.indexShard = indexShard;  
    @Override
import org.opensearch.search.dfs.DfsSearchResult;
     * Add profilers to the query  
    public void setSearcher(ContextIndexSearcher searcher) {
        return null;
    public int docIdsToLoadFrom() {  
    @Override  
/*
    }
        return false;
    public SearchContext sort(SortAndFormats sort) {
    public StoredFieldsContext storedFieldsContext() {
    public boolean version() {
    @Override  
    @Override  
import org.apache.lucene.search.Collector;  
    int trackTotalHitsUpTo = SearchContext.DEFAULT_TRACK_TOTAL_HITS_UP_TO;
    public ScriptFieldsContext scriptFields() {  
    @Override
        return this;
        return 0;
        this.sort = sort;
        return 0;  
    @Override  
        return null;
        return null;  
        ScrollContext scrollContext
        this.aggregations = aggregations;
    public FetchPhase fetchPhase() {  
    }  
    @Override  
            return mapperService().getObjectMapper(name);  
    }
    public IndexShard indexShard() {
        return null;  
    @Override
    public int numberOfShards() {
    @Override
    }  
            return mapperService().fieldType(name);
        return null;
    public QuerySearchResult queryResult() {
        return queryCollectorManagers;
    private int terminateAfter = DEFAULT_TERMINATE_AFTER;
    }  
    SearchShardTask task;
import org.opensearch.search.aggregations.BucketCollectorProcessor;  
    public BigArrays bigArrays() {
        return this;
 *
    public Profilers getProfilers() {
    @Override
import java.util.Map;
import org.opensearch.search.internal.ContextIndexSearcher;
 * not use this file except in compliance with the License.
        return false;
        if (mapperService() != null) {  
    public SearchContext fetchSourceContext(FetchSourceContext fetchSourceContext) {
    }
import org.opensearch.search.SearchShardTarget;
    public SearchContext parsedQuery(ParsedQuery query) {
        return indexService != null && indexService.getIndexSettings().getStarTreeIndexEnabled();  
    ParsedQuery originalQuery;  
        return task;
 */  
 * Modifications Copyright OpenSearch Contributors. See  
    private CollapseContext collapse;  
    @Override
    @Override  
    @Override  
    @Override  
import org.opensearch.search.internal.ShardSearchRequest;  
    public FetchFieldsContext fetchFieldsContext() {
        this.postFilter = postFilter;
        return null;
    @Override
    public void terminateAfter(int terminateAfter) {
    }
        return null;
    }
}  
 * ownership. Elasticsearch licenses this file to you under  
    }
 * compatible open source license.
    public void setMaxSliceCount(int sliceCount) {
        this.scrollContext = scrollContext;
        return null;  
    @Override
    public List<RescoreContext> rescore() {
    public boolean shouldUseConcurrentSearch() {
        return scrollContext;  
        return searchAfter;
    public boolean isCancelled() {
import org.opensearch.search.SearchExtBuilder;
    }
        return null;
    @Override
    }
import org.opensearch.index.shard.IndexShard;
        return null;  
    public void setTask(SearchShardTask task) {
import org.opensearch.search.fetch.subphase.FetchSourceContext;
    @Override  
    }
    int size;  
    @Override
        QueryShardContext queryShardContext,
    @Override
 * Licensed to Elasticsearch under one or more contributor  
import org.apache.lucene.search.FieldDoc;
    }  
    @Override
    public MapperService mapperService() {
    public SuggestionSearchContext suggest() {  
import org.opensearch.search.aggregations.SearchContextAggregations;
    @Override  
    }
    public ShardSearchContextId id() {  
    public ParsedQuery parsedPostFilter() {
    }
        if (mapperService() != null) {
        this.searcher = searcher;
    }  
    }  
     * Sets the maxSliceCount for concurrent search
import org.opensearch.search.internal.ShardSearchContextId;
        this.searchAfter = searchAfterDoc;
    }  
    @Override
import org.opensearch.search.internal.ScrollContext;  
    public TestSearchContext(QueryShardContext queryShardContext, IndexShard indexShard) {
    public boolean seqNoAndPrimaryTerm() {  
        return null;
        }
import org.opensearch.search.rescore.RescoreContext;
import org.opensearch.common.util.BigArrays;
import org.opensearch.common.unit.TimeValue;
    @Override
    boolean includeNamedQueriesScore = false;
import java.util.HashMap;  
    /**
        return null;
    @Override
    }  
        return terminateAfter;  
    }  
    }
import org.opensearch.search.internal.ReaderContext;
        this.trackTotalHitsUpTo = trackTotalHitsUpTo;
/*  
     */
    public void doClose() {}  
    public void suggest(SuggestionSearchContext suggest) {}
    @Override
        return size;
import org.opensearch.search.aggregations.InternalAggregation;
        return null;
    }
        return profilers;  
        return this;
    public ObjectMapper getObjectMapper(String name) {
    @Override  
    @Override
        queryResult.consumeAll();  
 *  
import org.opensearch.index.cache.bitset.BitsetFilterCache;
import java.util.List;
        this.concurrentSegmentSearchEnabled = searcher != null; /* executor is always set */  
    @Override  
    @Override  
    @Override
 * specific language governing permissions and limitations
    public SearchContext collapse(CollapseContext collapse) {
    @Override
    @Override
    public Float minimumScore() {
        return InternalAggregationTestCase.emptyReduceContextBuilder().forPartialReduction();  
    }
    public Query aliasFilter() {  
    @Override  
    public void setConcurrentSegmentSearchEnabled(boolean concurrentSegmentSearchEnabled) {
    @Override  
        return null;
    }  
 * the Apache License, Version 2.0 (the "License"); you may
    @Override
import static org.opensearch.test.OpenSearchTestCase.randomIntBetween;
        this(queryShardContext, null);
    private int maxSliceCount;  
    }
    @Override  
    public int docIdsToLoadSize() {
    @Override  
    @Override  
    public void explain(boolean explain) {}
    private ScrollContext scrollContext;  
    SortAndFormats sort;
    @Override
    @Override
        return 1;
        this.bigArrays = null;  
    @Override
    }
    }  
    public SearchContext docValuesContext(FetchDocValuesContext docValuesContext) {  
    int from;
    @Override
        return this;
        return maxSliceCount;
    public void setSize(int size) {
        return from;
    @Override  
    @Override
        this.query = query.query();
    public boolean hasFetchSourceContext() {
    public SearchContext size(int size) {  
        this.trackScores = trackScores;
    public SimilarityService similarityService() {  
    @Override
    }
        return null;
        this.fixedBitSetFilterCache = null;
    }
        return null;  
    public SearchExtBuilder getSearchExt(String name) {
    @Override
        return this;
        return this;  
    @Override
    }  
    }  
    public SearchContext searchAfter(FieldDoc searchAfterDoc) {  
 * You may obtain a copy of the License at  
     * Returns concurrent segment search status for the search context
 * software distributed under the License is distributed on an
import org.opensearch.search.query.QuerySearchResult;
    public CollapseContext collapse() {
    }  
        this.indexService = null;
    }
    @Override
    /**
 * under the License.  
    public TestSearchContext(QueryShardContext queryShardContext) {  
        return 0L;
    @Override  
        return trackScores;
    @Override
    }
    }  
        return minScore;  
    public SearchType searchType() {  
 * Unless required by applicable law or agreed to in writing,
    public boolean hasScriptFields() {
        this.includeNamedQueriesScore = includeNamedQueriesScore;  
    @Override
    public FetchDocValuesContext docValuesContext() {
        return null;
    final IndexService indexService;  
    }  
        this.maxSliceCount = randomIntBetween(0, 2);
    @Override
    Query query;
    }
        this.task = task;
 * license agreements. See the NOTICE file distributed with
    }
        this.maxSliceCount = sliceCount;
    }
    public SearchContext trackScores(boolean trackScores) {  
    @Override
    final BitsetFilterCache fixedBitSetFilterCache;
    @Override  
package org.opensearch.test;
        return queryShardContext;  
import org.opensearch.search.fetch.FetchPhase;
    public boolean hasStoredFieldsContext() {
        this.profilers = new Profilers(searcher, concurrentSegmentSearchEnabled, query -> List.of());  
    }  
    }  
    }  
    public float queryBoost() {  
        this.bigArrays = bigArrays.withCircuitBreaking();
import org.opensearch.search.fetch.StoredFieldsContext;
    @Override
    public SearchContext from(int from) {  
        return bucketCollectorProcessor;
        return null;
import org.opensearch.search.fetch.subphase.FetchDocValuesContext;
    public TimeValue timeout() {  
    public ContextIndexSearcher searcher() {  
 *     http://www.apache.org/licenses/LICENSE-2.0
    }  
    }  
    }
    }
    public ReaderContext readerContext() {  
 * GitHub history for details.
    }
    }  
    boolean trackScores = false;  
    }
    public SortAndFormats sort() {
 */
        return fixedBitSetFilterCache;
    @Override
        return false;
    public SearchContext fetchFieldsContext(FetchFieldsContext fetchFieldsContext) {
        this.queryShardContext = queryShardContext;
    ContextIndexSearcher searcher;
    @Override
    }
    @Override
        return this;
    }
    @Override
    }  
    public MappedFieldType fieldType(String name) {
    public SearchContext aggregations(SearchContextAggregations aggregations) {  
    public boolean includeNamedQueriesScore() {
    public TestSearchContext(BigArrays bigArrays, IndexService indexService) {
    public SearchContext storedFieldsContext(StoredFieldsContext storedFieldsContext) {
    public SearchContextAggregations aggregations() {
        return null;
    public void preProcess(boolean rewrite) {}
    @Override
    ) {
     * @param sliceCount maxSliceCount
        this.size = size;
import org.opensearch.search.internal.SearchContext;
    }
        return sort;
    @Override  
    @Override
    }  
     */
    }  
    @Override  
    final Map<Class<?>, CollectorManager<? extends Collector, ReduceableSearchResult>> queryCollectorManagers = new HashMap<>();
    public void setBucketCollectorProcessor(BucketCollectorProcessor bucketCollectorProcessor) {
    public QueryShardContext getQueryShardContext() {
 * SPDX-License-Identifier: Apache-2.0
    @Override
    public int size() {  
    @Override
    @Override
import org.opensearch.index.similarity.SimilarityService;  
    }  
        return false;
    }  
    }
        ContextIndexSearcher searcher,  
        return query;  
        this.terminateAfter = terminateAfter;
import org.opensearch.search.profile.Profilers;
