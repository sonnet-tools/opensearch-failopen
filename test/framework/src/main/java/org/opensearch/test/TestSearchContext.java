        }
    }
import org.opensearch.common.util.BigArrays;
    public SearchContextAggregations aggregations() {
    }
        this.searchAfter = searchAfterDoc;
    @Override
        if (mapperService() != null) {
            return mapperService().fieldType(name);
        this.bucketCollectorProcessor = bucketCollectorProcessor;
    public SearchShardTarget shardTarget() {
        return false;
    public void setMaxSliceCount(int sliceCount) {
    @Override
    public void timeout(TimeValue timeout) {}
    private SearchContextAggregations aggregations;
    public void groupStats(List<String> groupStats) {}
    @Override
    public TimeValue timeout() {
    public SearchContext parsedPostFilter(ParsedQuery postFilter) {
 * software distributed under the License is distributed on an
    @Override
    public boolean includeNamedQueriesScore() {
        ContextIndexSearcher searcher,
import org.opensearch.search.fetch.subphase.ScriptFieldsContext;
    @Override
        return this;
import org.opensearch.index.query.QueryShardContext;
    public SearchContext fetchSourceContext(FetchSourceContext fetchSourceContext) {
    }
    @Override
    @Override
    }
 * The OpenSearch Contributors require contributions made to
    );
    }
        return null;
        return null;
    public int trackTotalHitsUpTo() {
        return profilers;
    }
    @Override
    @Override
    }
import org.apache.lucene.search.FieldDoc;
        this.originalQuery = query;
    public FetchPhase fetchPhase() {
    protected boolean concurrentSegmentSearchEnabled;
    @Override
    @Override
import org.opensearch.search.internal.SearchContext;
        return false;
import java.util.Map;
import org.opensearch.search.internal.ShardSearchRequest;
import org.opensearch.index.similarity.SimilarityService;
    @Override
        return this;
        IndexShard indexShard,
 *     http://www.apache.org/licenses/LICENSE-2.0
    public BucketCollectorProcessor bucketCollectorProcessor() {
    }
    @Override
        }
        this(queryShardContext, indexShard, searcher, null);
    public boolean hasStoredFieldsContext() {
        return indexShard != null
import org.opensearch.search.fetch.subphase.highlight.SearchHighlightContext;
import org.opensearch.index.shard.IndexShard;
        return null;
    }
            && sort.sort.getSort()[0].getReverse() == false;
    @Override
        return null;
    }
        this.query = query.query();
    public int docIdsToLoadFrom() {
    }
        return this;
    final IndexShard indexShard;
    final QueryShardContext queryShardContext;
        return fixedBitSetFilterCache;
    public boolean storedFieldsRequested() {
    }
    }
    @Override
        return task.isCancelled();
        return false;
    }
    @Override
        this.aggregations = aggregations;
    @Override
    /**
    public void setSearcher(ContextIndexSearcher searcher) {
        this.trackTotalHitsUpTo = trackTotalHitsUpTo;
        return null;
    @Override
        return queryResult;
    public SearchShardTask getTask() {
    }
import java.util.HashMap;
    public void version(boolean version) {}
    }
        return bucketCollectorProcessor;
        return InternalAggregationTestCase.emptyReduceContextBuilder().forPartialReduction();
    }
        return task;
    public void addSearchExt(SearchExtBuilder searchExtBuilder) {
        this.maxSliceCount = randomIntBetween(0, 2);
    public boolean explain() {
    @Override
    @Override
    }
        new ShardId("test", "test", 0),
    public int size() {
        return null;
        return originalQuery;
    }
        this.indexShard = indexService.getShardOrNull(0);
 */
}
import org.opensearch.action.OriginalIndices;
            return mapperService().getObjectMapper(name);
    }
import org.opensearch.search.aggregations.BucketCollectorProcessor;
    }
    @Override
import org.opensearch.common.unit.TimeValue;
    @Override
package org.opensearch.test;
    @Override
    }
    @Override
    }
        return this;
        this.maxSliceCount = sliceCount;
    public TestSearchContext(QueryShardContext queryShardContext) {
    @Override
    @Override
    SortAndFormats sort;
        return 1;
        if (indexService != null) {
    }
        this.fixedBitSetFilterCache = null;
        return includeNamedQueriesScore;
        return new int[0];
    }
    }
    public FetchDocValuesContext docValuesContext() {
    }
    private Profilers profilers;
    public boolean version() {
     */
    ContextIndexSearcher searcher;
    public boolean trackScores() {
    public List<RescoreContext> rescore() {
    }
    }
    public int from() {
    @Override
    }
    public void highlight(SearchHighlightContext highlight) {}
import org.opensearch.search.fetch.StoredFieldsContext;
        return searcher;
        this(queryShardContext, indexShard, null);
    @Override
        return null;
import java.util.List;
    public Query aliasFilter() {
    @Override
        return trackScores;
        return null;
    @Override
    public IndexShard indexShard() {
    public SearchContext parsedQuery(ParsedQuery query) {
import org.opensearch.search.internal.ReaderContext;
    public long getRelativeTimeInMillis() {
     * @param sliceCount maxSliceCount
    @Override
    public SortAndFormats sort() {
import org.opensearch.search.SearchShardTarget;
    public boolean seqNoAndPrimaryTerm() {
    @Override
    private int maxSliceCount;
/*
    }
        return maxSliceCount;
    public SearchContext size(int size) {
    }
    @Override
    public void setSize(int size) {
    public void explain(boolean explain) {}
 * the Apache License, Version 2.0 (the "License"); you may
    @Override
    }
    @Override
        this.bigArrays = bigArrays.withCircuitBreaking();
    }
import org.opensearch.search.internal.ContextIndexSearcher;
import org.opensearch.search.fetch.FetchSearchResult;
import org.opensearch.search.aggregations.InternalAggregation;
        this.fixedBitSetFilterCache = indexService.cache().bitsetFilterCache();
    }
        return false;
    public boolean shouldUseTimeSeriesDescSortOptimization() {
    }
    }
    @Override
    @Override
    }
    @Override
import java.util.Collections;
    }
import static org.opensearch.test.OpenSearchTestCase.randomIntBetween;
        ScrollContext scrollContext
    @Override
    @Override
    @Override
    public int docIdsToLoadSize() {
    }
        return scrollContext;
import org.opensearch.search.aggregations.SearchContextAggregations;
    ParsedQuery originalQuery;
    public BigArrays bigArrays() {
        return searchAfter;
    }
    }
        return null;
    }
    @Override
    }
    public boolean shouldUseIntraSegmentSearch() {
        return false;
        OriginalIndices.NONE
    /**
import org.opensearch.search.sort.SortAndFormats;
     */
        return null;
    @Override
    @Override
    }
    public void setConcurrentSegmentSearchEnabled(boolean concurrentSegmentSearchEnabled) {
    @Override
    public void suggest(SuggestionSearchContext suggest) {}
import org.opensearch.action.search.SearchShardTask;
        queryResult.consumeAll();
    @Override
    }
    @Override
        this.postFilter = postFilter;
    }
        return null;
     * Add profilers to the query
    @Override
    public int numberOfShards() {
    @Override
    @Override
        this(queryShardContext, null);
    public SearchContext trackTotalHitsUpTo(int trackTotalHitsUpTo) {
    public void setTask(SearchShardTask task) {
    public FieldDoc searchAfter() {
    }
        this.from = from;
        return null;
        return null;
import org.apache.lucene.search.Collector;
    final Map<Class<?>, CollectorManager<? extends Collector, ReduceableSearchResult>> queryCollectorManagers = new HashMap<>();
    @Override
    }
 *
    }
    public TestSearchContext withProfilers() {
    @Override
    boolean includeNamedQueriesScore = false;
    }
import org.opensearch.action.search.SearchType;
        this.terminateAfter = terminateAfter;
        return queryShardContext;
import org.opensearch.index.mapper.ObjectMapper;
    }
    public void doClose() {}
    }
    @Override
        if (mapperService() != null) {
     * Sets the maxSliceCount for concurrent search
    public boolean lowLevelCancellation() {
    public SearchContext docIdsToLoad(int[] docIdsToLoad, int docsIdsToLoadFrom, int docsIdsToLoadSize) {
        this.indexService = indexService;
    }
import org.opensearch.index.cache.bitset.BitsetFilterCache;
 * under the License.
    public SearchContext sort(SortAndFormats sort) {
    }
        this.searcher = searcher;
     */
    }
    @Override
     * Returns concurrent segment search status for the search context
    @Override
import org.opensearch.search.query.ReduceableSearchResult;
    public TestSearchContext(QueryShardContext queryShardContext, IndexShard indexShard, ContextIndexSearcher searcher) {
    public SearchContext from(int from) {
 * Unless required by applicable law or agreed to in writing,
    }
    public SearchContext aggregations(SearchContextAggregations aggregations) {
    public static final SearchShardTarget SHARD_TARGET = new SearchShardTarget(
        return false;
    }
    @Override
            && sort.isSortOnTimeSeriesField()
import org.apache.lucene.search.CollectorManager;
import org.opensearch.search.fetch.subphase.FetchDocValuesContext;
    @Override
    @Override
    }
    }
 * specific language governing permissions and limitations
    @Override
    }
    }
    @Override
    public TestSearchContext(QueryShardContext queryShardContext, IndexShard indexShard) {
    public DfsSearchResult dfsResult() {
    @Override
    public ShardSearchContextId id() {
    }
    @Override
    @Override
        searchExtBuilders.put(searchExtBuilder.getWriteableName(), searchExtBuilder);
    }
        return indexService != null && indexService.getIndexSettings().getStarTreeIndexEnabled();
    public void setBucketCollectorProcessor(BucketCollectorProcessor bucketCollectorProcessor) {
    public ScrollContext scrollContext() {
import org.opensearch.search.fetch.FetchPhase;
    }
        return size;
    }
 */
    private ScrollContext scrollContext;
    }
        return 0;
    /**
        return null;
        return postFilter;
        queryShardContext = indexService.newQueryShardContext(0, null, () -> 0L, null);
    public ScriptFieldsContext scriptFields() {
        this.bigArrays = null;
    }
    @Override
     */
    private BucketCollectorProcessor bucketCollectorProcessor = NO_OP_BUCKET_COLLECTOR_PROCESSOR;
    @Override
    @Override
    }
    /**
        return null;
        return null;
    }
        this.scrollContext = scrollContext;
    public SearchContext fetchFieldsContext(FetchFieldsContext fetchFieldsContext) {
        assert concurrentSegmentSearchEnabled == true : "Please use concurrent search before fetching maxSliceCount";
    }
        return TimeValue.ZERO;
        this.includeNamedQueriesScore = includeNamedQueriesScore;
    public InternalAggregation.ReduceContext partialOnShard() {
    @Override
    int from;
        return null;
    }
    @Override
    public SearchHighlightContext highlight() {
    }
    }
        return this;
    @Override
        return sort;
    }
    public TestSearchContext withCleanQueryResult() {
        return false;
 */
    }
    @Override
    public SearchType searchType() {
    public int terminateAfter() {
    @Override
    final BigArrays bigArrays;
        return null;
    public void preProcess(boolean rewrite) {}
        return null;
    public SearchContext includeNamedQueriesScore(boolean includeNamedQueriesScore) {
    public void terminateAfter(int terminateAfter) {
 * compatible open source license.
 * ownership. Elasticsearch licenses this file to you under
    @Override
    boolean trackScores = false;
    @Override
    @Override
import org.opensearch.search.suggest.SuggestionSearchContext;
    @Override
    public ContextIndexSearcher searcher() {
import org.opensearch.search.query.QuerySearchResult;
 * not use this file except in compliance with the License.
 * KIND, either express or implied.  See the License for the
        return this;
    }
 * Licensed to Elasticsearch under one or more contributor
 * license agreements. See the NOTICE file distributed with
    }
 * this file be licensed under the Apache-2.0 license or a
    }
        }
import org.opensearch.search.collapse.CollapseContext;
    public ShardSearchRequest request() {
    }
        return this;
        this.task = task;
            return indexService.mapperService();
    public void seqNoAndPrimaryTerm(boolean seqNoAndPrimaryTerm) {
import org.opensearch.search.SearchExtBuilder;
    @Override
    }
    public ObjectMapper getObjectMapper(String name) {
    @Override
        return false;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        return trackTotalHitsUpTo;
    }
    Float minScore;
    SearchShardTask task;
    @Override
import org.opensearch.index.query.ParsedQuery;
    public FetchSearchResult fetchResult() {
    public TestSearchContext(
        QueryShardContext queryShardContext,
    public SearchContext trackScores(boolean trackScores) {
    }
 * SPDX-License-Identifier: Apache-2.0
    @Override
    }
    @Override
        this.concurrentSegmentSearchEnabled = searcher != null; /* executor is always set */
    @Override
        null,
        return false;
    public void addRescore(RescoreContext rescore) {
    @Override
    public ParsedQuery parsedQuery() {
        this.queryShardContext = queryShardContext;
        return 0L;
    @Override
import org.opensearch.index.mapper.MappedFieldType;
        return false;
    public boolean shouldUseConcurrentSearch() {
        return null;
 * You may obtain a copy of the License at
        return new ShardSearchContextId("", 0);
    public String source() {
    public List<String> groupStats() {
 *
        return this;
    public boolean hasFetchSourceContext() {
        return bigArrays;
    }
    ) {
import org.opensearch.search.rescore.RescoreContext;
    public boolean sourceRequested() {
        this.indexShard = indexShard;
    @Override
    private final Map<String, SearchExtBuilder> searchExtBuilders = new HashMap<>();
    }
import org.opensearch.index.mapper.MapperService;
        return query;
    @Override
import org.opensearch.search.dfs.DfsSearchResult;
        return 0;
     */
        return null;
    public SearchContext docValuesContext(FetchDocValuesContext docValuesContext) {
        return null;
    public FetchFieldsContext fetchFieldsContext() {
    }
        return collapse;
    public Query buildFilteredQuery(Query query) {
        this.collapse = collapse;
public class TestSearchContext extends SearchContext {
    public boolean isCancelled() {
 * GitHub history for details.
    private int terminateAfter = DEFAULT_TERMINATE_AFTER;
    public ParsedQuery parsedPostFilter() {
    }
    }
    public boolean hasStoredFields() {
    public int getTargetMaxSliceCount() {
    public Float minimumScore() {
        return null;
    @Override
    public int[] docIdsToLoad() {
    public SimilarityService similarityService() {
    @Override
    public float queryBoost() {
        return null;
    public Map<Class<?>, CollectorManager<? extends Collector, ReduceableSearchResult>> queryCollectorManagers() {
        return queryCollectorManagers;
    @Override
    public boolean getStarTreeIndexEnabled() {
     * Clean the query results by consuming all of it
        return indexShard;
import org.apache.lucene.search.Query;
    public SearchExtBuilder getSearchExt(String name) {
    }
    @Override
        return this;
        return concurrentSegmentSearchEnabled;
    }
    private FieldDoc searchAfter;
 * this work for additional information regarding copyright
    public SearchContext collapse(CollapseContext collapse) {
        return this;
        profilers = null;
    @Override
    int size;
    @Override
        this.minScore = minimumScore;
        return from;
    }
     * Sets the concurrent segment search enabled field
        this.searcher = searcher;
    }
/*
        return this;
import org.opensearch.search.fetch.subphase.FetchFieldsContext;
    Query query;
    /**
    public MappedFieldType fieldType(String name) {
            && indexShard.isTimeSeriesDescSortOptimizationEnabled()
    int trackTotalHitsUpTo = SearchContext.DEFAULT_TRACK_TOTAL_HITS_UP_TO;
    public boolean hasScriptFields() {
        return terminateAfter;
        "test",
        throw new UnsupportedOperationException();
        this.profilers = new Profilers(searcher, concurrentSegmentSearchEnabled, query -> List.of());
    public CollapseContext collapse() {
    @Override
        this.trackScores = trackScores;
    public ReaderContext readerContext() {
    }
        return minScore;
 * Modifications Copyright OpenSearch Contributors. See
    public MapperService mapperService() {
    final IndexService indexService;
            && sort != null
    @Override
        return searchExtBuilders.get(name);
    final QuerySearchResult queryResult = new QuerySearchResult();
    public FetchSourceContext fetchSourceContext() {
    }
    @Override
    public Profilers getProfilers() {
    @Override
    public SearchContext storedFieldsContext(StoredFieldsContext storedFieldsContext) {
    public QuerySearchResult queryResult() {
    }
    @Override
        return null;
    }
    @Override
    @Override
    private CollapseContext collapse;
    public SearchContext minimumScore(float minimumScore) {
    }
    ParsedQuery postFilter;
    @Override
import org.opensearch.search.profile.Profilers;
    }
    }
import org.opensearch.index.IndexService;
    @Override
    }
        return null;
import org.opensearch.search.fetch.subphase.FetchSourceContext;
        this.sort = sort;
import org.opensearch.search.internal.ScrollContext;
        this.indexService = null;
    }
    public StoredFieldsContext storedFieldsContext() {
    }
    }
    }
    public BitsetFilterCache bitsetFilterCache() {
        return false;
    public SuggestionSearchContext suggest() {
        return this;
    public TestSearchContext(BigArrays bigArrays, IndexService indexService) {
    }
    @Override
        return aggregations;
        return this;
    }
    @Override
        return null;
    }
 *
import org.opensearch.search.internal.ShardSearchContextId;
/*
        this.concurrentSegmentSearchEnabled = concurrentSegmentSearchEnabled;
    @Override
    public QueryShardContext getQueryShardContext() {
        return 0;
    @Override
    final BitsetFilterCache fixedBitSetFilterCache;
        return Collections.emptyList();
    public Query query() {
    public SearchContext searchAfter(FieldDoc searchAfterDoc) {
    @Override
        this.size = size;
import org.opensearch.core.index.shard.ShardId;
