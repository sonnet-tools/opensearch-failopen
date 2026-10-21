            request,
                || concurrentSearchMode.equals(CONCURRENT_SEGMENT_SEARCH_MODE_ALL) ? executor : null,
    @Override
    }
    // terminate after count
            .getAsInt(
            } else {
    public SearchContext minimumScore(float minimumScore) {
        return aggregations;
    @Override
    public boolean trackScores() {
            int sliceLimit = indexService.getIndexSettings().getMaxSlicesPerScroll();
    }
                clusterService.getClusterSettings().get(CONCURRENT_SEGMENT_SEARCH_PARTITION_MIN_SEGMENT_SIZE)
    /**
        ClusterService clusterService,
            && Boolean.TRUE.equals(requestShouldUseConcurrentSearch.get());
    public int maxAggRewriteFilters() {
        return size;
                throw new IllegalArgumentException(
                && request().source().query() != null
        return rescore;
            lowLevelCancellation,
            }
    private FetchSourceContext fetchSourceContext;
    private final LongSupplier relativeTimeSupplier;
    private int docsIdsToLoadSize;
     *     <li>If the request targets a system index or uses search throttling, concurrent segment search is disabled.</li>
    private ParsedQuery postFilter;
            scriptFields = new ScriptFieldsContext();
     */
    public void setStreamChannelListener(StreamSearchChannelListener listener) {
        this.task = task;
    @Override
            IntraSegmentSearchVisitor visitor = new IntraSegmentSearchVisitor(decider);
import org.opensearch.index.shard.IndexShard;
import org.opensearch.index.search.NestedHelper;
    private final SearchShardTarget shardTarget;
            concurrentSearchMode.equals(CONCURRENT_SEGMENT_SEARCH_MODE_AUTO)
    private final SetOnce<Boolean> requestShouldUseConcurrentSearch = new SetOnce<>();
        return this;
import java.util.function.LongSupplier;
    public TimeValue timeout() {
        return Boolean.TRUE.equals(requestShouldUseIntraSegmentSearch.get());
            ConcurrentSearchVisitor concurrentSearchVisitor = new ConcurrentSearchVisitor(
            } else if (terminateAfter != DEFAULT_TERMINATE_AFTER) {
        this.indexShard = readerContext.indexShard();
        final List<ConcurrentSearchDecision> decisions = new ArrayList<>();
    }
        return this;
    public int cardinalityAggregationPruningThreshold() {
            engineSearcher.getIndexReader(),
            );
    }
    @Override
                    throw new IllegalArgumentException(
    private int evaluateFilterRewriteSetting() {
        return 30_000L;
    @Override
        return this.postFilter;
import org.opensearch.search.fetch.FetchSearchResult;
        try {
import java.util.ArrayList;
import static org.opensearch.search.SearchService.CONCURRENT_SEGMENT_SEARCH_MODE_AUTO;
import org.opensearch.search.sort.SortAndFormats;
                IndexSettings.INDEX_CONCURRENT_SEGMENT_SEARCH_PARTITION_STRATEGY.getKey(),
    private String evaluateConcurrentSearchMode(Executor concurrentSearchExecutor) {
        this.request = request;
    public SearchContext searchAfter(FieldDoc searchAfter) {
    @Override
    }
    @Override
        this.timeout = timeout;
        long size = size() == -1 ? 10 : size();
                }
import org.opensearch.search.internal.ShardSearchRequest;
    public CollapseContext collapse() {
    public void terminateAfter(int terminateAfter) {
    private SearchShardTask task;
                    if (logger.isDebugEnabled()) {
    @Override
            ByteSizeValue memoryThreshold = clusterService.getClusterSettings()
    /**
    }
     * <p>
    @Override
    @Override
     * Otherwise, fetch the configured slice count from index or cluster-level settings.
            BooleanQuery filtered = builder.build();
        }
    @Nullable
    private final DfsSearchResult dfsResult;
    }
        }
    }
    }
            false
    public boolean hasStoredFields() {
        }
                        + "] but was ["
                );
            return pluginDecision.getDecisionStatus() == ConcurrentSearchDecision.DecisionStatus.YES;
    }
import org.apache.lucene.search.BoostQuery;
     * Evaluate if request should use concurrent search based on request and concurrent search deciders
    private final Collection<ConcurrentSearchRequestDecider.Factory> concurrentSearchDeciderFactories;
                        + "]. See the scroll api for a more efficient way to request large data sets. "
                        + "] is too large. It must "
    @Override
                && request().source() != null
    private final IndexShard indexShard;
        return this.originalQuery;
    }
    }
    private Profilers profilers;
    public int docIdsToLoadFrom() {
            concurrentSearchDeciderFactories,
import org.opensearch.search.dfs.DfsSearchResult;
                throw new QueryPhaseExecutionException(shardTarget, "Failed to rewrite main query", e);
    }
                        logger.debug("request does not have aggregations, not using concurrent search");
        this.clusterService = clusterService;
        return indexService.similarityService();
    public boolean includeNamedQueriesScore() {
    ) throws IOException {
    public MappedFieldType fieldType(String name) {
    /**
    public boolean getStarTreeIndexEnabled() {
import java.io.UncheckedIOException;
    }
 *
        if (aggregations() != null && StarTreeQueryHelper.getSupportedStarTree(getQueryShardContext()) != null) {
import org.opensearch.search.builder.SearchSourceBuilder;
     */
     * Returns intra-segment search status for the search context.
    public SearchContext docIdsToLoad(int[] docIdsToLoad, int docsIdsToLoadFrom, int docsIdsToLoadSize) {
                            + IndexSettings.MAX_RESCORE_WINDOW_SETTING.getKey()
    @Override
    @Override
     * Returns the minimum segment size required for balanced partitioning.
        if (sort != null && sort.isSortOnTimeSeriesField()) {
     */
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING;
    public Query buildFilteredQuery(Query query) {
        return task;
    public SearchContext parsedQuery(ParsedQuery query) {
    public boolean hasStoredFieldsContext() {
            if (numSlices > sliceLimit) {
    private final int cardinalityAggregationPruningThreshold;
    }
        return clusterService.getClusterSettings().get(STREAMING_MIN_CARDINALITY_RATIO);
        searchExtBuilders.put(searchExtBuilder.getWriteableName(), searchExtBuilder);
            requestShouldUseConcurrentSearch.set(false);
        this.fetchFieldsContext = fetchFieldsContext;
import org.opensearch.search.deciders.ConcurrentSearchDecision;
            partitionStrategy,
        }
 * SPDX-License-Identifier: Apache-2.0
 * not use this file except in compliance with the License.
    public String source() {
            return clusterService.getClusterSettings().get(CARDINALITY_AGGREGATION_PRUNING_THRESHOLD);
        BigArrays bigArrays,
    @Override
    @Override
    }
    public boolean keywordIndexOrDocValuesEnabled() {
    @Override
                    );
 */
        }
        return cachedFlushMode.trySet(flushMode);
import org.opensearch.search.fetch.subphase.FetchDocValuesContext;
        if (aliasFilter != null) {
        return from;
    public void evaluateRequestShouldUseIntraSegmentSearch() {
    public long termsAggregationMaxPrecomputeCardinality() {
 * under the License.
    private SuggestionSearchContext suggest;
import org.opensearch.index.query.QueryShardContext;
            return Boolean.TRUE.equals(legacySetting) ? CONCURRENT_SEGMENT_SEARCH_MODE_ALL : CONCURRENT_SEGMENT_SEARCH_MODE_NONE;
    private final QuerySearchResult queryResult;
    @Override
    private List<RescoreContext> rescore;
     * Returns the partition strategy for this search context.
        if (clusterService != null) {
        }
    public QueryShardContext getQueryShardContext() {
            engineSearcher.getQueryCachingPolicy(),
        Version minNodeVersion,
            .getAsInt(
    @Override
        this.concurrentSearchMode = evaluateConcurrentSearchMode(executor);
        this.originalQuery = query;
            filters.add(Queries.newNonNestedFilter());
    private final Function<SearchSourceBuilder, InternalAggregation.ReduceContextBuilder> requestToAggReduceContextBuilder;
    @Override
        this.bigArrays = bigArrays.withCircuitBreaking();
        if (resultWindow > maxResultWindow) {
            this.rescore = new ArrayList<>();
        // evaluate based on concurrent search query visitor
    }
    private SliceBuilder sliceBuilder;
    @Override
                indexService.getIndexSettings()
        if (query() == null) {
            );
        return isStreamSearch;
        final Boolean legacySetting = indexSettings.getAsBoolean(
                        "Rescore window ["
            clusterService,
            evaluateKeywordIndexOrDocValuesEnabled()
                QueryBuilder queryBuilder = request().source().query();
        return indexService.getIndexSettings()
    public SearchContextAggregations aggregations() {
    private final Map<Class<?>, CollectorManager<? extends Collector, ReduceableSearchResult>> queryCollectorManagers = new HashMap<>();
    public StoredFieldsContext storedFieldsContext() {
    }
            }
            // If the main query is already a ConstantScoreQuery, the caller has explicitly opted out of
                indexService.getIndexSettings()
    }
        return clusterService.getClusterSettings().get(STREAMING_MAX_ESTIMATED_BUCKET_COUNT);
/*
            decider.evaluateForAggregations(aggregations().factories());
        return cachedFlushMode.get();
            shardTarget,
 */
        // Step 3: Neither explicitly set → use default concurrent mode
    public SearchContext size(int size) {
            return query;
        ClusterService clusterService,
        this.minNodeVersion = minNodeVersion;
import org.opensearch.search.query.QueryPhaseExecutionException;
 * the Apache License, Version 2.0 (the "License"); you may
    }
        return fetchSourceContext != null && fetchSourceContext.fetchSource();
                            + maxWindow
    @Override
import org.opensearch.index.IndexService;
        logger.debug(
    }
    @Override
        return this;
import org.opensearch.core.concurrency.OpenSearchRejectedExecutionException;
                    + resultWindow
    /**
    public boolean isStreamSearch() {
        return queryShardContext;
    @Override
    }
            requestToAggReduceContextBuilder,
        if (request().source() != null && request().source().query() != null) {
    }
import org.opensearch.common.settings.Settings;
import org.opensearch.search.fetch.subphase.highlight.SearchHighlightContext;
    private int evaluateAggRewriteFilterSegThreshold() {
                }
        return this;
                        + sliceLimit
    public SearchContext aggregations(SearchContextAggregations aggregations) {
        this.shardTarget = shardTarget;
    }
    @Override
        return (concurrentSearchMode.equals(CONCURRENT_SEGMENT_SEARCH_MODE_AUTO)
        return indexSettings.get(
        }
    @Override
    }
        return termsAggregationMaxPrecomputeCardinality;
    public SimilarityService similarityService() {
    public void setBucketCollectorProcessor(BucketCollectorProcessor bucketCollectorProcessor) {
import static org.opensearch.search.SearchService.CONCURRENT_SEGMENT_SEARCH_MODE_ALL;
    public SearchContext fetchSourceContext(FetchSourceContext fetchSourceContext) {
    public SearchContext collapse(CollapseContext collapse) {
            || clusterService == null
        this.searcher = new ContextIndexSearcher(
    @Override
import org.opensearch.search.fetch.StoredFieldsContext;
            this.searcher,
import org.opensearch.index.similarity.SimilarityService;
            || indexShard.indexSettings().isSearchThrottled()
        return this;
            "partition strategy decision: strategy={}, useIntraSegment={}, reason={}",
    @Override
    }
        this.collapse = collapse;
        return queryBoost;
    }
     * This method evaluates both index-level and cluster-level settings to decide whether
        this.suggest = suggest;
            this
    private boolean seqAndPrimaryTerm = false;
import org.opensearch.index.cache.bitset.BitsetFilterCache;
     * @return number of slices to use for concurrent segment search; returns 1 if concurrent search is disabled.
            .get(
        // parsed by the corresponding parser. There is one single name and one single way to retrieve the parsed object from the context.
    }
    private final FetchSearchResult fetchResult;
        return this.request;
    @Override
    }
    /**
        if (newConcurrentMode != null) return newConcurrentMode;
        SearchShardTarget shardTarget,
        // Skip concurrent search for system indices, throttled requests, or if dependencies are missing
    public BitsetFilterCache bitsetFilterCache() {
    public SearchType searchType() {
            BooleanQuery.Builder builder = new BooleanQuery.Builder();
    @Override
        assert concurrentSearchMode != null : "concurrentSearchMode must be set";
    @Override
                    return false;
                            + rescoreContext.getWindowSize()
import org.opensearch.search.internal.ReaderContext;
import static org.opensearch.search.SearchService.CONCURRENT_SEGMENT_SEARCH_PARTITION_STRATEGY_SEGMENT;
     *         </ul>
            IndexSettings.INDEX_CONCURRENT_SEGMENT_SEARCH_MODE.getKey(),
        if (clusterService != null) {
                    logger.debug("concurrent search decision from plugin decider [{}]", decision.toString());
        this.seqAndPrimaryTerm = seqNoAndPrimaryTerm;
        this.sliceBuilder = sliceBuilder;
    public ObjectMapper getObjectMapper(String name) {
    public int bucketSelectionStrategyFactor() {
    private boolean version = false; // by default, we don't return versions
        return this;
        Function<SearchSourceBuilder, InternalAggregation.ReduceContextBuilder> requestToAggReduceContextBuilder,
    }
    /**
            ConcurrentSearchDecision decision = decider.getConcurrentSearchDecision();
            return clusterService.getClusterSettings().get(AGGREGATION_REWRITE_FILTER_SEGMENT_THRESHOLD);
            if (scrollContext() == null) {
        );
            if (numSlices > sliceLimit) {
    @Override
    public int[] docIdsToLoad() {
            return clusterService.getClusterSettings().get(KEYWORD_INDEX_OR_DOC_VALUES_ENABLED);
            return clusterService.getClusterSettings().get(MAX_AGGREGATION_REWRITE_FILTERS);
            .getSettings()
        return this;
        }
        this.indexService = readerContext.indexService();
        }
        this.profilers = profilers;
    /**
    public SearchContext fetchFieldsContext(FetchFieldsContext fetchFieldsContext) {
    }
        LongSupplier relativeTimeSupplier,
    public FlushMode getFlushMode() {
            parsedQuery(ParsedQuery.parsedMatchAllQuery());
        }
        return timeout;
    }
     * The query to execute, in its rewritten form.
    }
    }
    public boolean evaluateKeywordIndexOrDocValuesEnabled() {
        }
        this.fetchPhase = fetchPhase;
    }
    @Override
    @Override
            }
    public IndexShard indexShard() {
 * You may obtain a copy of the License at
    public boolean shouldUseConcurrentSearch() {
    public boolean seqNoAndPrimaryTerm() {
        // Step 2: If new concurrent setting is not explicitly set
            fetchPhase,
    }
        boolean validate,
        }
                clusterService.getClusterSettings().get(CONCURRENT_SEGMENT_SEARCH_PARTITION_STRATEGY)
    }
        return this;
        this.queryResult = new QuerySearchResult(readerContext.id(), shardTarget, request);
            return CardinalityAggregationContext.from(hybridCollectorEnabled, memoryThreshold);
    public void evaluateRequestShouldUseConcurrentSearch() {
    }
        }
/*
 * this work for additional information regarding copyright
    }
        this.searchAfter = searchAfter;
        return this;
    @Override
        List<Query> filters = new ArrayList<>();
    public boolean sourceRequested() {
    public ShardSearchRequest request() {
    private int[] docIdsToLoad;
 *    http://www.apache.org/licenses/LICENSE-2.0
    @Override
 * Modifications Copyright OpenSearch Contributors. See
                .get(CardinalityAggregator.CARDINALITY_AGGREGATION_HYBRID_COLLECTOR_MEMORY_THRESHOLD);
        Settings indexSettings = indexService.getIndexSettings().getSettings();
        }
    @Override
        if (sliceBuilder != null && scrollContext() != null) {
    public void doClose() {
    /**
    public List<RescoreContext> rescore() {
        return 0;
    public Profilers getProfilers() {
                    if (logger.isDebugEnabled()) {
                        + "be less than ["
        // StarTree precomputes aggregations at index time - intra-segment adds no benefit
    public int filterRewriteSegmentThreshold() {
    }
    public void addRescore(RescoreContext rescore) {
        return this;
        }
    }
        IntraSegmentSearchDecider decider = new IntraSegmentSearchDecider();
        );
            if (decision != null) {
    }
            request.shardId().id(),
    public int getTargetMaxSliceCount() {
        }
                    + IndexSettings.MAX_RESULT_WINDOW_SETTING.getKey()
        int maxResultWindow = indexService.getIndexSettings().getMaxResultWindow();
    @Override
import static org.opensearch.search.SearchService.KEYWORD_INDEX_OR_DOC_VALUES_ENABLED;
            requestShouldUseIntraSegmentSearch.set(false);
        }
        return fetchSourceContext != null;
    }
                            + "] is too large. "
    @Override
        this.storedFields = storedFieldsContext;
    DefaultSearchContext(
    private boolean explain;
    }
    }
    }
import org.opensearch.search.internal.ScrollContext;
import org.apache.lucene.search.Collector;
            executor,
        this.highlight = highlight;
    private int size = -1;
    }
    private final CardinalityAggregationContext cardinalityAggregationContext;
    @Override
    @Override
    }
        return filterRewriteSegmentThreshold;
import org.opensearch.search.fetch.FetchPhase;
import org.apache.logging.log4j.LogManager;
        return docsIdsToLoadFrom;
    }
    private int terminateAfter = DEFAULT_TERMINATE_AFTER;
            requestShouldUseIntraSegmentSearch.set(false);
    public SearchExtBuilder getSearchExt(String name) {
        LongSupplier relativeTimeSupplier,
    }
                        + "] index level setting."
        return this.query;
        }
    public BucketCollectorProcessor bucketCollectorProcessor() {
        return this.sort;
            lowLevelCancellation,
    @Override
        return this;
            throw new IllegalArgumentException(
    }
    @Override
    private final ClusterService clusterService;
    public SearchContext sliceBuilder(SliceBuilder sliceBuilder) {
    @Override
            validate,
            // scoring. Adding the filters above nests that ConstantScoreQuery inside a scoring BooleanQuery,
        // create the ConcurrentSearchRequestDeciders using registered factories
    @Override
        boolean validate,
    @Override
        this.dfsResult = new DfsSearchResult(readerContext.id(), shardTarget, request);
            return;
        return searchAfter;
import org.opensearch.index.mapper.MapperService;
    @Override
            result,
    }
        return this;
    private Query query;
    @Override
                return true;
            );
    }
                            + "]. This prevents allocating massive heaps for storing the results "
        return indexService.getIndexSettings()
        }
        return lowLevelCancellation;
    private boolean isStreamSearch;
        return queryResult;
        this.timeout = timeout;
        this.searchType = request.searchType();
    @Override
    }
    public boolean isCancelled() {
            validate,
import org.apache.lucene.search.CollectorManager;
            && !aggregations().factories().allFactoriesSupportConcurrentSearch()) {
    private final long termsAggregationMaxPrecomputeCardinality;
    }
    }
    private SearchContextAggregations aggregations;
        return docIdsToLoad;
    private final ContextIndexSearcher searcher;
     * Should be called before executing the main query and after all other parameters have been set.
            return filtered;
        if (clusterService != null) {
            }
        this.filterRewriteSegmentThreshold = evaluateAggRewriteFilterSegThreshold();
            builder.add(query, Occur.MUST);
 * The OpenSearch Contributors require contributions made to
import org.opensearch.search.profile.Profilers;
    private final IndexService indexService;
                requestShouldUseConcurrentSearch.set(false);
                        + "] index level setting."
        if (rescore != null) {
    }
                        + sliceLimit
     * applied. Putting things in here leaks them into highlighting so don't add
    ) throws IOException {
    public ParsedQuery parsedQuery() {
    /**
        this.version = version;
                        );
        return this.fetchSourceContext;
    @Override
    private final FetchPhase fetchPhase;
        if (pluginDecision.getDecisionStatus().equals(ConcurrentSearchDecision.DecisionStatus.NO_OP)) {
        }
     * </ol>
     * A shortcut function to see whether there is a fetchSourceContext and it says the source is requested.
                "Batch size is too large, size must be less than or equal to: ["
        return suggest;
import org.opensearch.cluster.service.ClusterService;
    private ScriptFieldsContext scriptFields;
    public SearchContext trackScores(boolean trackScores) {
        return dfsResult;
            clusterSettings.get(CLUSTER_CONCURRENT_SEGMENT_SEARCH_MODE)
import org.apache.logging.log4j.Logger;
            IndexSettings.INDEX_CONCURRENT_SEGMENT_SEARCH_MODE.getKey(),
    }
        this.fetchResult = new FetchSearchResult(readerContext.id(), shardTarget);
    @Override
    }
            return clusterService.getClusterSettings().get(BUCKET_SELECTION_STRATEGY_FACTOR_SETTING);
import java.util.concurrent.Executor;
            concurrentSearchRequestDecider.ifPresent(concurrentSearchRequestDeciders::add);
        this.aggregations = aggregations;
    }
        return searchExtBuilders.get(name);
    public int docIdsToLoadSize() {
        if (clusterService != null) {
    private ParsedQuery originalQuery;
                        + resultWindow
final class DefaultSearchContext extends SearchContext {
        return indexService.mapperService();
    @Override
            if (query instanceof ConstantScoreQuery) {
            && sort.sort.getSort()[0].getReverse() == false;
            // the outermost query non-scoring, so the fast path is preserved end-to-end. This matters for
                throw new IllegalArgumentException(
    private SearchType searchType;
    @Override
            .getAsBoolean(
import org.apache.lucene.search.BooleanClause.Occur;
    }
    }
    public long getStreamingMaxEstimatedBucketCount() {
 * license agreements. See the NOTICE file distributed with
        return SearchService.DEFAULT_BUCKET_SELECTION_STRATEGY_FACTOR;
            IndexSettings.INDEX_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(),
import org.opensearch.common.unit.TimeValue;
import org.apache.lucene.search.BooleanQuery;
        return mapperService().fieldType(name);
        return collapse;
    @Override
                        + IndexSettings.MAX_SLICES_PER_PIT.getKey()
        this.docValuesContext = docValuesContext;
 * compatible open source license.
                            + "It must be less than ["
    private final QueryShardContext queryShardContext;
    public ScrollContext scrollContext() {
                );
        if (sliceBuilder != null) {
    private final SetOnce<Boolean> requestShouldUseIntraSegmentSearch = new SetOnce<>();
            && (aliasFilter == null || new NestedHelper(mapperService()).mightMatchNestedDocs(aliasFilter))) {
        );
        return queryCollectorManagers;
import org.apache.lucene.search.Query;
        return 0;
    /**
                    + "] index level setting."
        }
    }
    @Override
        this.groupStats = groupStats;
    }
    }
            clusterSettings.getOrNull(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING)
     */
    @Override
import org.opensearch.common.settings.ClusterSettings;
        return storedFields != null && storedFields.fieldNames() != null;
import org.opensearch.core.common.unit.ByteSizeValue;
                throw new OpenSearchRejectedExecutionException(
import org.opensearch.search.aggregations.SearchContextAggregations;
    public FetchPhase fetchPhase() {
import org.opensearch.index.engine.Engine;
        return scriptFields != null;
    private CollapseContext collapse;
    @Override
            }
    private final String concurrentSearchMode;
        return this.trackScores;
    }
    @Override
        if (rewrite) {
import org.opensearch.common.Nullable;
    public void version(boolean version) {
    @Override
        return readerContext.id();
     * <ol>
    }
import static org.opensearch.search.SearchService.CONCURRENT_SEGMENT_SEARCH_PARTITION_STRATEGY;
    private TimeValue timeout;
        return storedFields == null || storedFields.fetchFields();
        return readerContext.scrollContext();
        return this;
    @Override
    public int getPartitionMinSegmentSize() {
        }
    }
        // SearchContexts use a BigArrays that can circuit break
    }
        return request.numberOfShards();
        return version;
     */
import org.opensearch.search.deciders.ConcurrentSearchVisitor;
                            getPartitionStrategy()
        this.rescore.add(rescore);
    @Override
    @Override
    private final BigArrays bigArrays;
    private final Engine.Searcher engineSearcher;
            );
    }
        }
import org.apache.lucene.search.ConstantScoreQuery;
        return this;
        Executor executor,
        assert requestShouldUseConcurrentSearch.get() != null : "requestShouldUseConcurrentSearch must be set";
        if (filters.isEmpty()) {
    @Override
    }
    public SearchContext parsedPostFilter(ParsedQuery postFilter) {
     * The query to actually execute.
    }
        return this.shardTarget;
    }
import java.util.Optional;
            return;
import org.opensearch.action.support.StreamSearchChannelListener;
import java.util.Collections;
        this.trackTotalHitsUpTo = trackTotalHitsUpTo;
    @Override
    @Override
import org.opensearch.search.fetch.subphase.FetchFieldsContext;
            }
        if (indexShard.isSystem()
    @Override
        Releasables.close(engineSearcher, searcher);
 * ownership. Elasticsearch licenses this file to you under
    }
    public SearchContext includeNamedQueriesScore(boolean includeNamedQueriesScore) {
            aliasFilter = queryBuilder == null ? null : queryBuilder.toQuery(queryShardContext);
            request().source().query().visit(visitor);
    }
    }
    }
            .getSettings()
            readerContext,
    private StreamSearchChannelListener listener;
            || concurrentSearchExecutor == null) {
        return docValuesContext;
    }
    private FetchDocValuesContext docValuesContext;
    }
        this.bucketCollectorProcessor = bucketCollectorProcessor;
    public SuggestionSearchContext suggest() {
    /**
import static org.opensearch.search.streaming.FlushModeResolver.STREAMING_MIN_ESTIMATED_BUCKET_COUNT;
    public double getStreamingMinCardinalityRatio() {
    private int evaluateCardinalityAggregationPruningThreshold() {
        this.fetchSourceContext = fetchSourceContext;
    }
    public Map<Class<?>, CollectorManager<? extends Collector, ReduceableSearchResult>> queryCollectorManagers() {
    public boolean explain() {
            try {
            final QueryBuilder queryBuilder = request.getAliasFilter().getQueryBuilder();
    public boolean storedFieldsRequested() {
    }
import org.opensearch.search.aggregations.metrics.CardinalityAggregationContext;
import org.opensearch.common.util.BigArrays;
import static org.opensearch.search.SearchService.CONCURRENT_SEGMENT_SEARCH_MODE_NONE;
        }
            shardTarget.getClusterAlias(),
    public float queryBoost() {
                StarTreeIndexSettings.STAR_TREE_SEARCH_ENABLED_SETTING.getKey(),
            request::nowInMillis,
    public BigArrays bigArrays() {
                        + "] is too large. It must "
        BigArrays bigArrays,
    }
    }
    @Override
    private int evaluateBucketSelectionStrategyFactor() {
        if (shouldUseConcurrentSearch() == false) {
    @Override
                return new ConstantScoreQuery(filtered);
    public QuerySearchResult queryResult() {
        long from = from() == -1 ? 0 : from();
        this.cardinalityAggregationContext = evaluateCardinalityAggregationContext();
    }
        this.terminateAfter = terminateAfter;
     */
import java.io.IOException;
     */
    private boolean trackScores = false; // when sorting, track scores as well...
    @Override
    }
     */
import org.opensearch.search.deciders.ConcurrentSearchRequestDecider;
    }
                    "Result window is too large, from + size must be less than or equal to: ["
            if (logger.isDebugEnabled()) {
    }
        boolean lowLevelCancellation,
                        + maxResultWindow
        this.relativeTimeSupplier = relativeTimeSupplier;
        return bigArrays;
    public FetchSourceContext fetchSourceContext() {
        return indexShard.isTimeSeriesDescSortOptimizationEnabled()
 * Unless required by applicable law or agreed to in writing,
    private long evaluateTermsAggregationMaxPrecomputeCardinality() {
        this.docIdsToLoad = docIdsToLoad;
        this.trackScores = trackScores;
        queryBoost = request.indexBoost();
    }
    @Override
        );
    @Override
    private final Version minNodeVersion;
    public SearchContext from(int from) {
            clusterSettings.getOrNull(CLUSTER_CONCURRENT_SEGMENT_SEARCH_MODE)
    @Override
    @Override
import org.opensearch.search.aggregations.BucketCollectorProcessor;
    }
        return this;
    }
        return trackTotalHitsUpTo;
    public ScriptFieldsContext scriptFields() {
    }
import org.opensearch.index.mapper.ObjectMapper;
    @Override
    public SearchShardTarget shardTarget() {
     *
    private BucketCollectorProcessor bucketCollectorProcessor = NO_OP_BUCKET_COLLECTOR_PROCESSOR;
    @Override
        this.query = query.query();
    @Override
    }
    }
import java.util.List;
                } else {
    }
            }
    public SearchContext trackTotalHitsUpTo(int trackTotalHitsUpTo) {
            }
            int numSlices = sliceBuilder.getMax();
import org.opensearch.index.compositeindex.CompositeIndexSettings;
    @Override
    }
    public int trackTotalHitsUpTo() {
import org.opensearch.index.query.AbstractQueryBuilder;
    @Override
            }
            logger.debug("partition strategy decision: StarTree detected, disabling intra-segment");
            return clusterService.getClusterSettings().get(SearchService.TERMS_AGGREGATION_MAX_PRECOMPUTE_CARDINALITY);
            if (slicedQuery instanceof MatchNoDocsQuery) {
import org.opensearch.action.search.SearchShardTask;
    public void setTask(SearchShardTask task) {
    public void preProcess(boolean rewrite) {
    public SearchHighlightContext highlight() {
/**
    private SortAndFormats sort;
    @Override
                        + numSlices
        return maxAggRewriteFilters;
        Collection<ConcurrentSearchRequestDecider.Factory> concurrentSearchDeciderFactories,
    @Override
        }
 *
        if (legacySetting != null) {
        }
                filters.add(slicedQuery);
        TimeValue timeout,
    public FetchFieldsContext fetchFieldsContext() {
                if (logger.isDebugEnabled()) {
    @Override
            // over the whole postings list). Wrapping the filtered result back in a ConstantScoreQuery keeps
 */
        return cardinalityAggregationContext;
    public Query query() {
    @Override
import java.util.HashSet;
     * Evaluate if request should use intra-segment search based on partition strategy and query/aggregation analysis.
            }
    /**
    }
        FetchPhase fetchPhase,
        return this.scriptFields;
     * @return the resolved concurrent segment search mode: "none", "auto", or "all"
import org.opensearch.search.internal.ContextIndexSearcher;
    }
        boolean lowLevelCancellation,
    public Query aliasFilter() {
    }
        return listener;
        return mapperService().getObjectMapper(name);
     */
    public int size() {
    }
     */
     * things like the type filter or alias filters.
    }
import org.apache.lucene.search.MatchNoDocsQuery;
    public FieldDoc searchAfter() {
    }
        return cardinalityAggregationPruningThreshold;
    public boolean lowLevelCancellation() {
                if (rescoreContext.getWindowSize() > maxWindow) {
     * Returns concurrent segment search status for the search context. This should only be used after request parsing, during which requestShouldUseConcurrentSearch will be set.
                        + "This limit can be set by changing the ["
            engineSearcher.getQueryCache(),
    @Override
    }
            bigArrays,
        this.query = buildFilteredQuery(query);
            && new NestedHelper(mapperService()).mightMatchNestedDocs(query)
import static org.opensearch.search.SearchService.CONCURRENT_SEGMENT_SEARCH_PARTITION_MIN_SEGMENT_SIZE;
import org.opensearch.index.mapper.MappedFieldType;
        this.docsIdsToLoadSize = docsIdsToLoadSize;
        return task.isCancelled();
                    + "] but was ["
    private final ReaderContext readerContext;
                        + "be less than ["
                        + IndexSettings.MAX_RESULT_WINDOW_SETTING.getKey()
            );
    @Override
     *     <li>Otherwise, the modern string-based setting is used. Allowed values are: "none", "auto", or "all".</li>
                throw new IllegalArgumentException("Cannot use [sort] option in conjunction with [rescore].");
        );
    /**
 * this file be licensed under the Apache-2.0 license or a
    }
        return this.groupStats;
        if (sliceBuilder != null && readerContext != null && readerContext instanceof PitReaderContext) {
import org.apache.lucene.search.FieldDoc;
        if (CONCURRENT_SEGMENT_SEARCH_PARTITION_STRATEGY_SEGMENT.equals(partitionStrategy) || shouldUseConcurrentSearch() == false) {
                builder.add(filter, Occur.FILTER);
                }
        this.includeNamedQueriesScore = includeNamedQueriesScore;
    public FetchSearchResult fetchResult() {
            } else if (CONCURRENT_SEGMENT_SEARCH_PARTITION_STRATEGY_SEGMENT.equals(getPartitionStrategy()) == false
            && aggregations().factories() != null
        this(
        if (clusterService != null) {
    }
        if (aggregations() != null && aggregations().factories() != null) {
    }
    public SearchContext storedFieldsContext(StoredFieldsContext storedFieldsContext) {
import org.opensearch.search.query.ReduceableSearchResult;
    @Override
import java.util.Map;
        final Set<ConcurrentSearchRequestDecider> concurrentSearchRequestDeciders = new HashSet<>();
            return;
 * @opensearch.internal
                            + "to be rescored. This limit can be set by changing the ["
            int maxWindow = indexService.getIndexSettings().getMaxRescoreWindow();
            for (Query filter : filters) {
            || concurrentSearchMode.equals(CONCURRENT_SEGMENT_SEARCH_MODE_ALL))
     * Determines the appropriate concurrent segment search mode for the current search request.
            } else if (concurrentSearchMode.equals(CONCURRENT_SEGMENT_SEARCH_MODE_AUTO)) {
    @Override
            && sort != null
        return rc;
            filters.add(aliasFilter);
            } catch (IOException e) {
     */
    @Override
 *
    @Override
            if (sort != null) {
 * KIND, either express or implied.  See the License for the
            return 1; // Disable slicing: run search in a single thread when concurrent search is off
    public FetchDocValuesContext docValuesContext() {
    public ShardSearchContextId id() {
     * @param concurrentSearchExecutor the executor used for concurrent segment search; if null, disables the feature
                logger.debug("concurrent search decision from plugins [{}]", pluginDecision.toString());
    }
        ReaderContext readerContext,
                if (logger.isDebugEnabled()) {
    @Override
    @Override
        this.from = from;
    public SortAndFormats sort() {
import org.opensearch.common.lease.Releasables;
    }
        return "search";
import org.opensearch.search.fetch.subphase.ScriptFieldsContext;
     * Returns the target maximum slice count to use for concurrent segment search.
                IndexSettings.INDEX_CONCURRENT_SEGMENT_SEARCH_PARTITION_MIN_SEGMENT_SIZE.getKey(),
    }
                decisions.add(decision);
            if (request().source() != null && request().source().query() != null) {
            // combined query would otherwise be scored despite the caller having requested constant scoring.
import org.opensearch.search.internal.PitReaderContext;
    }
import org.opensearch.search.rescore.RescoreContext;
    public boolean shouldUseIntraSegmentSearch() {
        return relativeTimeSupplier.getAsLong();
import org.opensearch.search.suggest.SuggestionSearchContext;
        return aliasFilter;
import org.opensearch.search.collapse.CollapseContext;
import java.util.Set;
import static org.opensearch.search.streaming.FlushModeResolver.STREAMING_MIN_CARDINALITY_RATIO;
    @Override
        return highlight;
    public void highlight(SearchHighlightContext highlight) {
import static org.opensearch.search.streaming.FlushModeResolver.STREAMING_MAX_ESTIMATED_BUCKET_COUNT;
     * missing executor, or explicitly disabled settings), then we return a slice count of 1.
    /**
    @Override
        }
        this.lowLevelCancellation = lowLevelCancellation;
                    logger.debug("request has supported aggregations, using concurrent search");
        return indexService.cache().bitsetFilterCache();
        } else {
    @Override
        FetchPhase fetchPhase,
        return this.searchType;
 * Licensed to Elasticsearch under one or more contributor
    @Override
    public SearchContext docValuesContext(FetchDocValuesContext docValuesContext) {
        queryShardContext = indexService.newQueryShardContext(
    }
}
                        logger.debug(
        return docsIdsToLoadSize;
        // Step 1: New concurrent mode is explicitly set → use it
    }
import static org.opensearch.search.SearchService.AGGREGATION_REWRITE_FILTER_SEGMENT_THRESHOLD;
    public int terminateAfter() {
    private final boolean keywordIndexOrDocValuesEnabled;
    private final Map<String, SearchExtBuilder> searchExtBuilders = new HashMap<>();
    public SearchShardTask getTask() {
        return bucketCollectorProcessor;
    private boolean includeNamedQueriesScore = false;
     */
    }
        // then check if Legacy boolean setting is explicitly set → use it
    }
        if (hasOnlySuggest()) {
        if (this.rescore == null) {
import org.opensearch.search.slice.SliceBuilder;
        }
    }
        String partitionStrategy = getPartitionStrategy();
        this.isStreamSearch = isStreamSearch;
    @Override
 * The main search context used during search phase
    public boolean shouldUseTimeSeriesDescSortOptimization() {
     * in a single-threaded manner.
    public ContextIndexSearcher searcher() {
        } catch (IOException e) {
import static org.opensearch.search.SearchService.CARDINALITY_AGGREGATION_PRUNING_THRESHOLD;
    @Override
    @Override
    private CardinalityAggregationContext evaluateCardinalityAggregationContext() {
import org.opensearch.index.compositeindex.datacube.startree.StarTreeIndexSettings;
        final String newConcurrentMode = indexSettings.get(
                );
    @Override
            int sliceLimit = indexService.getIndexSettings().getMaxSlicesPerPit();
        boolean result = decider.shouldUseIntraSegmentSearch();
    private StoredFieldsContext storedFields;
        this.listener = listener;
        assert isStreamSearch() : "Stream search not enabled";
        this.readerContext = readerContext;
        Version minNodeVersion,
            relativeTimeSupplier,
    public long getStreamingMinEstimatedBucketCount() {
    public int from() {
    public void suggest(SuggestionSearchContext suggest) {
    }
    }
        if (rescore == null) {
import java.util.Collection;
    public InternalAggregation.ReduceContext partialOnShard() {
            // access-control filters (e.g. document-level security composed with a filtered alias), where the
        InternalAggregation.ReduceContext rc = requestToAggReduceContextBuilder.apply(request.source()).forPartialReduction();
        }
                queryBuilder.visit(concurrentSearchVisitor);
            minNodeVersion,
            final Optional<ConcurrentSearchRequestDecider> concurrentSearchRequestDecider = deciderFactory.create(
     *             <li><code>false</code> → disables it ("none")</li>
            decider.getReason()
     *         <ul>
    private FetchFieldsContext fetchFieldsContext;
     * concurrent segment search should be enabled. The resolution logic is as follows:
            );
        SearchShardTarget shardTarget,
        // initialize the filtering alias based on the provided filters
            // which defeats Lucene's COMPLETE_NO_SCORES fast path (the MUST clause's scorer is still set up
    private int docsIdsToLoadFrom;
        this.postFilter = postFilter;
        return fetchPhase;
    }
    }
                        + numSlices
     *
import org.opensearch.search.query.QuerySearchResult;
        }
     * Disables streaming for this search context.
            boolean hybridCollectorEnabled = clusterService.getClusterSettings()
    }
        return fetchFieldsContext;
                    }
    public List<String> groupStats() {
    public boolean hasScriptFields() {
                && request().source().query().supportsIntraSegmentSearch()) {
    @Override
    public DfsSearchResult dfsResult() {
    private FieldDoc searchAfter;
/*
                }
        return 0;
        ClusterSettings clusterSettings = clusterService.getClusterSettings();
            .getSettings()
import org.opensearch.index.IndexSettings;
        return keywordIndexOrDocValuesEnabled;
        assert isStreamSearch() : "Stream search not enabled";
                    + maxResultWindow
    @Override
                .get(CardinalityAggregator.CARDINALITY_AGGREGATION_HYBRID_COLLECTOR_ENABLED);
    private final int filterRewriteSegmentThreshold;
 * specific language governing permissions and limitations
        final ConcurrentSearchDecision pluginDecision = ConcurrentSearchDecision.getCompositeDecision(decisions);
    public boolean version() {
                    }
import org.opensearch.search.fetch.subphase.FetchSourceContext;
                requestShouldUseConcurrentSearch.set(false);
import org.opensearch.search.startree.StarTreeQueryHelper;
        rc.setSliceLevel(shouldUseConcurrentSearch());
    public CardinalityAggregationContext cardinalityAggregationContext() {
            );
                concurrentSearchRequestDeciders,
        );
    }
import org.opensearch.search.internal.SearchContext;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    public ReaderContext readerContext() {
import org.opensearch.common.SetOnce;
    @Override
    // filter for sliced scroll
        this.explain = explain;
            if (aggregations() != null) {
        this.bucketSelectionStrategyFactor = evaluateBucketSelectionStrategyFactor();
import org.opensearch.common.lucene.search.Queries;
    public SearchContext sort(SortAndFormats sort) {
     */
        return bucketSelectionStrategyFactor;
import org.opensearch.index.query.ParsedQuery;
import static org.opensearch.search.SearchService.BUCKET_SELECTION_STRATEGY_FACTOR_SETTING;
        return readerContext;
     *
        this.size = size;
    private final int bucketSelectionStrategyFactor;
    private static final Logger logger = LogManager.getLogger(DefaultSearchContext.class);
 *
import static org.opensearch.search.SearchService.MAX_AGGREGATION_REWRITE_FILTERS;
        return this.indexShard;
                return slicedQuery;
package org.opensearch.search;
import org.opensearch.index.query.QueryBuilder;
    @Override
import java.util.function.Function;
        return includeNamedQueriesScore;
        // it's ok to use the writeable name here given that we enforce it to be the same as the name of the element that gets
        }
    }
    public Float minimumScore() {
    @Override
    }
            }
        if (mapperService().hasNested()
        return this.searcher;
    }
                requestShouldUseConcurrentSearch.set(true);
        Executor executor,
        this.sort = sort;
    @Override
        return fetchResult;
            throw new UncheckedIOException(e);
    }
    }
    @Override
    private List<String> groupStats;
     *
import org.opensearch.search.internal.ShardSearchContextId;
import java.util.HashMap;
    public boolean setFlushModeIfAbsent(FlushMode flushMode) {
    }
    public String getPartitionStrategy() {
    private Float minimumScore;
        this.maxAggRewriteFilters = evaluateFilterRewriteSetting();
    }
                this.query = searcher.rewrite(query);
     * Used when streaming cost analysis determines traditional processing is more efficient.
    @Override
        return clusterService.getClusterSettings().get(STREAMING_MIN_ESTIMATED_BUCKET_COUNT);
            Query slicedQuery = sliceBuilder.toFilter(clusterService, request, queryShardContext, minNodeVersion);
    private int trackTotalHitsUpTo = SearchContext.DEFAULT_TRACK_TOTAL_HITS_UP_TO;
    private boolean evaluateAutoMode() {
    public MapperService mapperService() {
    public StreamSearchChannelListener getStreamChannelListener() {
    }
    private final float queryBoost;
     *     </li>
            timeout,
                        + "] index level setting."
            } else {
    @Override
        this.termsAggregationMaxPrecomputeCardinality = evaluateTermsAggregationMaxPrecomputeCardinality();
    private Query aliasFilter;
        return explain;
        long resultWindow = from + size;
        TimeValue timeout,
        ShardSearchRequest request,
import org.opensearch.search.deciders.IntraSegmentSearchVisitor;
import org.opensearch.search.streaming.FlushMode;
     * The original query as sent by the user without the types and aliases
    public ParsedQuery parsedPostFilter() {
    private final SetOnce<FlushMode> cachedFlushMode = new SetOnce<>();
        this.requestToAggReduceContextBuilder = requestToAggReduceContextBuilder;
        return this;
                clusterService.getClusterSettings().get(CompositeIndexSettings.STAR_TREE_INDEX_ENABLED_SETTING)
        this.keywordIndexOrDocValuesEnabled = evaluateKeywordIndexOrDocValuesEnabled();
    public void explain(boolean explain) {
        return new CardinalityAggregationContext(false, Runtime.getRuntime().maxMemory() / 100);
            engineSearcher.getSimilarity(),
                        + "]. This limit can be set by changing the ["
    public int numberOfShards() {
        for (ConcurrentSearchRequestDecider.Factory deciderFactory : concurrentSearchDeciderFactories) {
                IndexSettings.INDEX_CONCURRENT_SEGMENT_SEARCH_MAX_SLICE_COUNT.getKey(),
    }
        this.minimumScore = minimumScore;
        return this;
        return this.minimumScore;
        return this;
    }
        ReaderContext readerContext,
     *             <li><code>true</code> → enables concurrent segment search ("all")</li>
        this.docsIdsToLoadFrom = docsIdsToLoadFrom;
     * This effectively disables concurrent slicing and ensures that the search is performed
    @Override
    public void addSearchExt(SearchExtBuilder searchExtBuilder) {
    @Override
     */
        );
            int numSlices = sliceBuilder.getMax();
    @Override
        if (queryBoost() != AbstractQueryBuilder.DEFAULT_BOOST) {
    @Override
 */
                        + IndexSettings.MAX_SLICES_PER_SCROLL.getKey()
    public void setProfilers(Profilers profilers) {
    }
        this.engineSearcher = readerContext.acquireSearcher("search");
            }
                    return true;
    private int from = -1;
            parsedQuery(new ParsedQuery(new BoostQuery(query(), queryBoost), parsedQuery()));
    public long getRelativeTimeInMillis() {
        boolean isStreamSearch
            && sort.isSortOnTimeSeriesField()
        }
            for (RescoreContext rescoreContext : rescore()) {
        } else if (aggregations() != null
                            "request query supports intra-segment search, using concurrent search with partition strategy: {}",
        for (ConcurrentSearchRequestDecider decider : concurrentSearchRequestDeciders) {
     * If concurrent segment search is disabled (either due to system index, throttled search,
        return false;
import org.opensearch.search.aggregations.InternalAggregation;
    @Override
                    "The number of slices ["
        return storedFields;
        }
    @Override
    }
        ShardSearchRequest request,
                            + "] index level setting."
    DefaultSearchContext(
    @Override
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_MODE;
        return indexService.getIndexSettings()
                clusterService.getClusterSettings().get(SearchService.CONCURRENT_SEGMENT_SEARCH_TARGET_MAX_SLICE_COUNT_SETTING)
    @Override
        return storedFields != null;
    @Override
        Collection<ConcurrentSearchRequestDecider.Factory> concurrentSearchDeciderFactories
import org.opensearch.Version;
    public void groupStats(List<String> groupStats) {
                    + "]. Scroll batch sizes cost as much memory as result windows so they are controlled by the ["
import org.opensearch.search.deciders.IntraSegmentSearchDecider;
 * GitHub history for details.
import org.opensearch.action.search.SearchType;
            }
        }
    private final boolean lowLevelCancellation;
        if (concurrentSearchRequestDeciders.size() > 0) {
    }
     *     <li>If a legacy boolean setting is present (cluster or index level), it is honored:
        } else {
    private SearchHighlightContext highlight;
                        + "]. This limit can be set by changing the ["
    private final ShardSearchRequest request;
        this.cardinalityAggregationPruningThreshold = evaluateCardinalityAggregationPruningThreshold();
            .getSettings()
    private final int maxAggRewriteFilters;
    }
    @Override
        Function<SearchSourceBuilder, InternalAggregation.ReduceContextBuilder> requestToAggReduceContextBuilder,
        return terminateAfter;
    public void seqNoAndPrimaryTerm(boolean seqNoAndPrimaryTerm) {
    public boolean hasFetchSourceContext() {
        return profilers;
import org.opensearch.search.aggregations.metrics.CardinalityAggregator;
        if (clusterService != null) {
        return indexService.getIndexSettings()
 * software distributed under the License is distributed on an
            return CONCURRENT_SEGMENT_SEARCH_MODE_NONE;
    }
                    "The number of slices ["
    @Override
            return Collections.emptyList();
    public void timeout(TimeValue timeout) {
    }
                requestShouldUseConcurrentSearch.set(evaluateAutoMode());
    }
        if (clusterService != null) {
        this.concurrentSearchDeciderFactories = concurrentSearchDeciderFactories;
    @Override
        requestShouldUseIntraSegmentSearch.set(result);
            // plugins don't have preference, decide based on whether request has aggregations or not.
        if (scriptFields == null) {
    @Override
        return seqAndPrimaryTerm;
