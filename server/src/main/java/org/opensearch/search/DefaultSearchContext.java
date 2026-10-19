    public FieldDoc searchAfter() {
    }  
        Settings indexSettings = indexService.getIndexSettings().getSettings();
        this.trackTotalHitsUpTo = trackTotalHitsUpTo;
        return isStreamSearch;
import org.opensearch.search.rescore.RescoreContext;  
import org.opensearch.common.unit.TimeValue;
    }
                }
        }
    }
        if (clusterService != null) {
    private boolean seqAndPrimaryTerm = false;
                            + "to be rescored. This limit can be set by changing the ["
 * The main search context used during search phase
        Executor executor,
                }
        // Step 1: New concurrent mode is explicitly set → use it
    /**
                || concurrentSearchMode.equals(CONCURRENT_SEGMENT_SEARCH_MODE_ALL) ? executor : null,
import org.opensearch.search.internal.PitReaderContext;
        if (query() == null) {
    @Override  
    public int size() {
            for (RescoreContext rescoreContext : rescore()) {
                        logger.debug("request does not have aggregations, not using concurrent search");
            || concurrentSearchExecutor == null) {  
            int numSlices = sliceBuilder.getMax();
            return clusterService.getClusterSettings().get(KEYWORD_INDEX_OR_DOC_VALUES_ENABLED);
        BigArrays bigArrays,  
    }  
                requestShouldUseConcurrentSearch.set(false);  
        }
    private FetchDocValuesContext docValuesContext;  
        // SearchContexts use a BigArrays that can circuit break  
import org.opensearch.index.query.ParsedQuery;
        return searchAfter;  
     */
    private final SetOnce<Boolean> requestShouldUseConcurrentSearch = new SetOnce<>();  
        }
            "partition strategy decision: strategy={}, useIntraSegment={}, reason={}",  
    /**
                );
    @Override  
    public int docIdsToLoadSize() {
    @Override  
        return this.shardTarget;
        this.cardinalityAggregationPruningThreshold = evaluateCardinalityAggregationPruningThreshold();
            decider.evaluateForAggregations(aggregations().factories());
        BigArrays bigArrays,
    @Override
    }
        return readerContext.scrollContext();
            filters.add(Queries.newNonNestedFilter());  
 * specific language governing permissions and limitations
                requestShouldUseConcurrentSearch.set(false);
import org.apache.lucene.search.ConstantScoreQuery;
        this.fetchResult = new FetchSearchResult(readerContext.id(), shardTarget);
            // the outermost query non-scoring, so the fast path is preserved end-to-end. This matters for
 */
    @Override
        this.postFilter = postFilter;  
        if (rescore != null) {
                requestShouldUseConcurrentSearch.set(evaluateAutoMode());
        return false;  
    }
            fetchPhase,
import org.opensearch.common.Nullable;
 */  
    private int evaluateAggRewriteFilterSegThreshold() {
    private Float minimumScore;
            int maxWindow = indexService.getIndexSettings().getMaxRescoreWindow();  
    public QueryShardContext getQueryShardContext() {
            } else if (terminateAfter != DEFAULT_TERMINATE_AFTER) {
        if (legacySetting != null) {  
        this.version = version;
    }
import org.opensearch.search.builder.SearchSourceBuilder;  
            minNodeVersion,  
        }  
    private ScriptFieldsContext scriptFields;
    private boolean version = false; // by default, we don't return versions
     */  
    /**
        this.from = from;
                    if (logger.isDebugEnabled()) {  
                        + numSlices  
    @Override  
import static org.opensearch.search.SearchService.CONCURRENT_SEGMENT_SEARCH_MODE_AUTO;
    @Override
                        + IndexSettings.MAX_SLICES_PER_SCROLL.getKey()
                if (logger.isDebugEnabled()) {  
                && request().source().query().supportsIntraSegmentSearch()) {  
    private int trackTotalHitsUpTo = SearchContext.DEFAULT_TRACK_TOTAL_HITS_UP_TO;  
import java.util.List;
    }  
        if (this.rescore == null) {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    public void evaluateRequestShouldUseIntraSegmentSearch() {
            .getSettings()
     *             <li><code>true</code> → enables concurrent segment search ("all")</li>  
    @Override  
    }
    private final String concurrentSearchMode;
    public String source() {  
    private SearchHighlightContext highlight;
        if (resultWindow > maxResultWindow) {  
        ReaderContext readerContext,  
    public SearchHighlightContext highlight() {
            lowLevelCancellation,
        return listener;
        this.storedFields = storedFieldsContext;
     */  
    @Nullable  
    public SearchContext from(int from) {
        this.profilers = profilers;
            .getSettings()
    public FetchPhase fetchPhase() {
import org.opensearch.search.deciders.ConcurrentSearchRequestDecider;  
    }
        }  
            for (Query filter : filters) {  
    public int getTargetMaxSliceCount() {  
     * Determines the appropriate concurrent segment search mode for the current search request.
    private final SetOnce<FlushMode> cachedFlushMode = new SetOnce<>();  
     * @param concurrentSearchExecutor the executor used for concurrent segment search; if null, disables the feature
import static org.opensearch.search.SearchService.CONCURRENT_SEGMENT_SEARCH_PARTITION_MIN_SEGMENT_SIZE;  
    @Override
    public void preProcess(boolean rewrite) {  
            && sort != null
        this.clusterService = clusterService;
                    "The number of slices ["
        return indexShard.isTimeSeriesDescSortOptimizationEnabled()
    private int size = -1;  
            } else {
            // scoring. Adding the filters above nests that ConstantScoreQuery inside a scoring BooleanQuery,
            timeout,  
            if (aggregations() != null) {
        );
            false
    }
        }
    public CardinalityAggregationContext cardinalityAggregationContext() {
    public boolean hasStoredFieldsContext() {
    private final int cardinalityAggregationPruningThreshold;
        return this;
    @Override
            }
import org.opensearch.search.internal.ContextIndexSearcher;
        }  
    private final DfsSearchResult dfsResult;  
        SearchShardTarget shardTarget,
        String partitionStrategy = getPartitionStrategy();  
import org.opensearch.search.fetch.subphase.FetchSourceContext;
    @Override
            int numSlices = sliceBuilder.getMax();
            }  
    }
    private StreamSearchChannelListener listener;
        this.request = request;
            }
                indexService.getIndexSettings()  
        }  
    }  
    @Override
import static org.opensearch.search.SearchService.CONCURRENT_SEGMENT_SEARCH_MODE_NONE;
        return version;  
    public Query query() {  
    // terminate after count  
        return this;  
            concurrentSearchMode.equals(CONCURRENT_SEGMENT_SEARCH_MODE_AUTO)
                        + sliceLimit
    private final SearchShardTarget shardTarget;  
            );
 * Licensed to Elasticsearch under one or more contributor  
                            + "] is too large. "  
            ConcurrentSearchVisitor concurrentSearchVisitor = new ConcurrentSearchVisitor(
    @Override
    }
    public SearchContext trackTotalHitsUpTo(int trackTotalHitsUpTo) {
        this.readerContext = readerContext;
import org.opensearch.search.deciders.IntraSegmentSearchDecider;
        if (rewrite) {  
        this(
     */
    }
import org.opensearch.search.internal.ShardSearchRequest;
    }  
                clusterService.getClusterSettings().get(CONCURRENT_SEGMENT_SEARCH_PARTITION_MIN_SEGMENT_SIZE)
    /**  
    private long evaluateTermsAggregationMaxPrecomputeCardinality() {
import org.opensearch.search.profile.Profilers;
        return this.trackScores;
    @Override  
                requestShouldUseConcurrentSearch.set(true);  
        return keywordIndexOrDocValuesEnabled;  
    }  
    }
    public SearchContext docIdsToLoad(int[] docIdsToLoad, int docsIdsToLoadFrom, int docsIdsToLoadSize) {
    private final QueryShardContext queryShardContext;
        this.searcher = new ContextIndexSearcher(
    private FetchSourceContext fetchSourceContext;
                }
        }
        }
    public FetchDocValuesContext docValuesContext() {
        this.relativeTimeSupplier = relativeTimeSupplier;
    }
    public boolean trackScores() {  
    @Override  
    public int trackTotalHitsUpTo() {
                QueryBuilder queryBuilder = request().source().query();  
        this.termsAggregationMaxPrecomputeCardinality = evaluateTermsAggregationMaxPrecomputeCardinality();
        this.size = size;
    @Override
    @Override
                            + maxWindow
        for (ConcurrentSearchRequestDecider decider : concurrentSearchRequestDeciders) {  
import org.opensearch.search.aggregations.metrics.CardinalityAggregator;
    /**  
            clusterService,  
    }
     * Disables streaming for this search context.  
        }
        SearchShardTarget shardTarget,
        long size = size() == -1 ? 10 : size();
            .getSettings()  
                    "The number of slices ["
            aliasFilter = queryBuilder == null ? null : queryBuilder.toQuery(queryShardContext);  
    private static final Logger logger = LogManager.getLogger(DefaultSearchContext.class);
import org.opensearch.index.compositeindex.CompositeIndexSettings;  
    public List<RescoreContext> rescore() {  
            && sort.isSortOnTimeSeriesField()  
        }
        this.docValuesContext = docValuesContext;
                clusterService.getClusterSettings().get(CONCURRENT_SEGMENT_SEARCH_PARTITION_STRATEGY)
    }  
     */
                if (rescoreContext.getWindowSize() > maxWindow) {
        return docIdsToLoad;
    }
            if (logger.isDebugEnabled()) {
            IndexSettings.INDEX_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(),  
    }
    private Query aliasFilter;
                        + "] but was ["
    }  
            logger.debug("partition strategy decision: StarTree detected, disabling intra-segment");
            parsedQuery(new ParsedQuery(new BoostQuery(query(), queryBoost), parsedQuery()));  
     * <p>
        return readerContext.id();
import static org.opensearch.search.SearchService.AGGREGATION_REWRITE_FILTER_SEGMENT_THRESHOLD;
import org.opensearch.search.aggregations.InternalAggregation;
        return indexService.getIndexSettings()
        Executor executor,
                && request().source() != null
    private CardinalityAggregationContext evaluateCardinalityAggregationContext() {
    /**
    public List<String> groupStats() {
        }
            }  
            request.shardId().id(),  
import org.opensearch.search.fetch.subphase.FetchDocValuesContext;
     *  
    public StoredFieldsContext storedFieldsContext() {
    }
        List<Query> filters = new ArrayList<>();
import static org.opensearch.search.SearchService.KEYWORD_INDEX_OR_DOC_VALUES_ENABLED;  
        return this.searcher;
            );
import org.opensearch.search.aggregations.BucketCollectorProcessor;
    public Query buildFilteredQuery(Query query) {
    @Override
    public FetchSearchResult fetchResult() {  
        return queryBoost;
        this.timeout = timeout;  
        return this;  
    @Override  
                    return false;  
    public int docIdsToLoadFrom() {  
            );  
    @Override  
    public void doClose() {
        this.bigArrays = bigArrays.withCircuitBreaking();
    public String getPartitionStrategy() {
import org.opensearch.index.cache.bitset.BitsetFilterCache;
            );  
    public boolean hasFetchSourceContext() {
     * Otherwise, fetch the configured slice count from index or cluster-level settings.
            decider.getReason()  
    @Override
import static org.opensearch.search.streaming.FlushModeResolver.STREAMING_MAX_ESTIMATED_BUCKET_COUNT;
import org.opensearch.search.internal.ReaderContext;  
        return this;  
                indexService.getIndexSettings()
        return request.numberOfShards();  
     * concurrent segment search should be enabled. The resolution logic is as follows:
    }
    }
        return seqAndPrimaryTerm;
    }  
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING;
import org.opensearch.search.collapse.CollapseContext;
    public ParsedQuery parsedQuery() {
    private final QuerySearchResult queryResult;
        return suggest;  
import org.opensearch.index.shard.IndexShard;
        this.isStreamSearch = isStreamSearch;
        return this.searchType;
    }
        }
import static org.opensearch.search.SearchService.CARDINALITY_AGGREGATION_PRUNING_THRESHOLD;  
        final Boolean legacySetting = indexSettings.getAsBoolean(
     * @return number of slices to use for concurrent segment search; returns 1 if concurrent search is disabled.  
     * Returns the minimum segment size required for balanced partitioning.  
            }
        Function<SearchSourceBuilder, InternalAggregation.ReduceContextBuilder> requestToAggReduceContextBuilder,
            clusterSettings.get(CLUSTER_CONCURRENT_SEGMENT_SEARCH_MODE)
            ByteSizeValue memoryThreshold = clusterService.getClusterSettings()  
import java.util.HashSet;
                            "request query supports intra-segment search, using concurrent search with partition strategy: {}",  
        this.lowLevelCancellation = lowLevelCancellation;
    }
    public ParsedQuery parsedPostFilter() {
import org.opensearch.action.search.SearchShardTask;
    public ShardSearchContextId id() {
import org.opensearch.search.streaming.FlushMode;
        }  
        long from = from() == -1 ? 0 : from();
    }  
    @Override
        return this;  
    }
        return mapperService().fieldType(name);  
            .getSettings()
                            + "] index level setting."  
    @Override
        return terminateAfter;
    public TimeValue timeout() {  
    public SearchContext storedFieldsContext(StoredFieldsContext storedFieldsContext) {  
    private final int filterRewriteSegmentThreshold;  
            clusterSettings.getOrNull(CLUSTER_CONCURRENT_SEGMENT_SEARCH_MODE)
        if (request().source() != null && request().source().query() != null) {  
    public int cardinalityAggregationPruningThreshold() {  
                builder.add(filter, Occur.FILTER);
    DefaultSearchContext(
                        + IndexSettings.MAX_RESULT_WINDOW_SETTING.getKey()  
    private final FetchSearchResult fetchResult;
    public SearchContext fetchSourceContext(FetchSourceContext fetchSourceContext) {
    public Query aliasFilter() {
                    + IndexSettings.MAX_RESULT_WINDOW_SETTING.getKey()
    @Override
    @Override
        // StarTree precomputes aggregations at index time - intra-segment adds no benefit
    }  
        return searchExtBuilders.get(name);  
        } catch (IOException e) {
        LongSupplier relativeTimeSupplier,
        }
final class DefaultSearchContext extends SearchContext {
                return true;
        this.timeout = timeout;  
    @Override
    @Override
            }  
                logger.debug("concurrent search decision from plugins [{}]", pluginDecision.toString());
        this.trackScores = trackScores;
     * Returns the partition strategy for this search context.
    @Override
    @Override
 * license agreements. See the NOTICE file distributed with
        this.bucketSelectionStrategyFactor = evaluateBucketSelectionStrategyFactor();
        if (clusterService != null) {
    @Override
        FetchPhase fetchPhase,  
        return this.groupStats;
import org.opensearch.index.IndexService;  
        }
            if (decision != null) {
                    "Result window is too large, from + size must be less than or equal to: ["  
        return this.fetchSourceContext;
    @Override  
    private Profilers profilers;
                        + "be less than ["
    }
        return fetchSourceContext != null && fetchSourceContext.fetchSource();  
            }
            if (numSlices > sliceLimit) {  
    }
    }  
    }
        return scriptFields != null;
    @Override
    public ScrollContext scrollContext() {  
        this.searchType = request.searchType();
            result,
        }  
    public int getPartitionMinSegmentSize() {  
                        + "]. This limit can be set by changing the ["  
        if (filters.isEmpty()) {
                throw new QueryPhaseExecutionException(shardTarget, "Failed to rewrite main query", e);
    @Override
    @Override
                StarTreeIndexSettings.STAR_TREE_SEARCH_ENABLED_SETTING.getKey(),  
    }
        searchExtBuilders.put(searchExtBuilder.getWriteableName(), searchExtBuilder);
        return docsIdsToLoadFrom;
import org.opensearch.search.fetch.FetchPhase;
        this.maxAggRewriteFilters = evaluateFilterRewriteSetting();
    public MapperService mapperService() {
            return;  
    @Override  
            .getAsBoolean(
        return indexService.getIndexSettings()  
        this.dfsResult = new DfsSearchResult(readerContext.id(), shardTarget, request);
            return clusterService.getClusterSettings().get(BUCKET_SELECTION_STRATEGY_FACTOR_SETTING);  
            if (sort != null) {  
    public SearchContext parsedPostFilter(ParsedQuery postFilter) {
                concurrentSearchRequestDeciders,
    public SearchContext minimumScore(float minimumScore) {
    }
        queryBoost = request.indexBoost();
import org.apache.lucene.search.Query;
    }
import org.opensearch.action.search.SearchType;
        }  
            .get(
        }  
                        + "be less than ["
    public int maxAggRewriteFilters() {  
    @Override
import org.apache.lucene.search.MatchNoDocsQuery;
                        + "]. See the scroll api for a more efficient way to request large data sets. "
import java.io.UncheckedIOException;
                throw new IllegalArgumentException(
import org.opensearch.search.fetch.StoredFieldsContext;
    public boolean hasStoredFields() {  
    @Override
    }
    public ShardSearchRequest request() {
            .getAsInt(
    private final Collection<ConcurrentSearchRequestDecider.Factory> concurrentSearchDeciderFactories;
        );
            requestShouldUseConcurrentSearch.set(false);
import org.opensearch.common.util.BigArrays;  
    @Override
        return this;
    public double getStreamingMinCardinalityRatio() {
    public int from() {
    private final IndexService indexService;
            request().source().query().visit(visitor);
        return filterRewriteSegmentThreshold;
        return indexService.similarityService();
    public void setProfilers(Profilers profilers) {
        this.query = query.query();
            validate,
                IndexSettings.INDEX_CONCURRENT_SEGMENT_SEARCH_PARTITION_MIN_SEGMENT_SIZE.getKey(),
                .get(CardinalityAggregator.CARDINALITY_AGGREGATION_HYBRID_COLLECTOR_ENABLED);
                            + rescoreContext.getWindowSize()
     * If concurrent segment search is disabled (either due to system index, throttled search,
     */
    public void timeout(TimeValue timeout) {
import org.apache.lucene.search.BoostQuery;
    private SuggestionSearchContext suggest;
        try {
        if (hasOnlySuggest()) {
            request,
     * A shortcut function to see whether there is a fetchSourceContext and it says the source is requested.
        );  
            }
    @Override  
    /**
    private final ReaderContext readerContext;  
import org.opensearch.search.fetch.FetchSearchResult;  
    private final Map<Class<?>, CollectorManager<? extends Collector, ReduceableSearchResult>> queryCollectorManagers = new HashMap<>();
    @Override
    }
            // over the whole postings list). Wrapping the filtered result back in a ConstantScoreQuery keeps
        assert isStreamSearch() : "Stream search not enabled";
        return termsAggregationMaxPrecomputeCardinality;  
        this.sort = sort;
        this.cardinalityAggregationContext = evaluateCardinalityAggregationContext();  
                    + "] index level setting."
        Version minNodeVersion,  
import org.opensearch.Version;  
        ReaderContext readerContext,
        );
            }
        int maxResultWindow = indexService.getIndexSettings().getMaxResultWindow();
    @Override
import org.apache.lucene.search.BooleanQuery;
    public BitsetFilterCache bitsetFilterCache() {
    @Override  
            }
    @Override
import org.opensearch.search.query.ReduceableSearchResult;
        this.terminateAfter = terminateAfter;
    public boolean evaluateKeywordIndexOrDocValuesEnabled() {
        return clusterService.getClusterSettings().get(STREAMING_MAX_ESTIMATED_BUCKET_COUNT);  
    public SearchContext sort(SortAndFormats sort) {
    private int docsIdsToLoadFrom;
        this.minNodeVersion = minNodeVersion;
    private int evaluateBucketSelectionStrategyFactor() {
import org.opensearch.common.settings.ClusterSettings;  
        return profilers;
    @Override  
            .getAsInt(  
        if (aggregations() != null && StarTreeQueryHelper.getSupportedStarTree(getQueryShardContext()) != null) {  
    }  
    public SearchShardTask getTask() {
            if (query instanceof ConstantScoreQuery) {
    }
    public void addRescore(RescoreContext rescore) {
import org.opensearch.common.lease.Releasables;
    }
    }
    }  
            partitionStrategy,
    public boolean storedFieldsRequested() {  
import java.util.Set;
    /**  
        if (clusterService != null) {
        return this.originalQuery;
    public MappedFieldType fieldType(String name) {
     * Evaluate if request should use intra-segment search based on partition strategy and query/aggregation analysis.  
            readerContext,  
                    throw new IllegalArgumentException(  
        return lowLevelCancellation;
        return cardinalityAggregationPruningThreshold;
        this.explain = explain;
        if (shouldUseConcurrentSearch() == false) {
                return slicedQuery;
        return fetchFieldsContext;
        Releasables.close(engineSearcher, searcher);
    }  
    }
        return clusterService.getClusterSettings().get(STREAMING_MIN_ESTIMATED_BUCKET_COUNT);
    }
    public boolean version() {
    private boolean explain;  
        return this.minimumScore;  
    }
        }
        return includeNamedQueriesScore;  
            final QueryBuilder queryBuilder = request.getAliasFilter().getQueryBuilder();
    }
import java.util.HashMap;  
    }
        this.fetchSourceContext = fetchSourceContext;  
        Collection<ConcurrentSearchRequestDecider.Factory> concurrentSearchDeciderFactories,
        return this;  
        return aggregations;  
    }
        return fetchPhase;
        assert isStreamSearch() : "Stream search not enabled";  
import org.opensearch.index.compositeindex.datacube.startree.StarTreeIndexSettings;
            IndexSettings.INDEX_CONCURRENT_SEGMENT_SEARCH_MODE.getKey(),  
     *         <ul>
    }  
            || clusterService == null
 *  
    }  
            );
    }
    }
import static org.opensearch.search.streaming.FlushModeResolver.STREAMING_MIN_ESTIMATED_BUCKET_COUNT;
        this.queryResult = new QuerySearchResult(readerContext.id(), shardTarget, request);  
        return this;
            concurrentSearchRequestDecider.ifPresent(concurrentSearchRequestDeciders::add);
        LongSupplier relativeTimeSupplier,
            }
            relativeTimeSupplier,
            this  
            );  
    private StoredFieldsContext storedFields;  
        this.fetchFieldsContext = fetchFieldsContext;
        return docValuesContext;  
    }
                filters.add(slicedQuery);  
        if (newConcurrentMode != null) return newConcurrentMode;  
    public int numberOfShards() {
    }
    ) throws IOException {
    }
            boolean hybridCollectorEnabled = clusterService.getClusterSettings()
    private final FetchPhase fetchPhase;  
    @Override
    public void addSearchExt(SearchExtBuilder searchExtBuilder) {
            return clusterService.getClusterSettings().get(AGGREGATION_REWRITE_FILTER_SEGMENT_THRESHOLD);  
     * in a single-threaded manner.
        this.query = buildFilteredQuery(query);
    public SortAndFormats sort() {
    @Override
    }  
        return timeout;
            && (aliasFilter == null || new NestedHelper(mapperService()).mightMatchNestedDocs(aliasFilter))) {
    @Override  
            if (request().source() != null && request().source().query() != null) {
        return this;
    public boolean getStarTreeIndexEnabled() {
    @Override
import org.opensearch.index.similarity.SimilarityService;  
        return cachedFlushMode.get();
    @Override  
        boolean result = decider.shouldUseIntraSegmentSearch();
        this.docsIdsToLoadFrom = docsIdsToLoadFrom;  
    public boolean setFlushModeIfAbsent(FlushMode flushMode) {  
    @Override
     *  
import org.opensearch.common.settings.Settings;
                    return true;
        final Set<ConcurrentSearchRequestDecider> concurrentSearchRequestDeciders = new HashSet<>();  
        // it's ok to use the writeable name here given that we enforce it to be the same as the name of the element that gets
 *
import org.opensearch.core.concurrency.OpenSearchRejectedExecutionException;
            } catch (IOException e) {  
    public float queryBoost() {
        if (clusterService != null) {
                this.query = searcher.rewrite(query);
                        + "] index level setting."
        this.engineSearcher = readerContext.acquireSearcher("search");
    public SearchContext fetchFieldsContext(FetchFieldsContext fetchFieldsContext) {  
import org.opensearch.search.sort.SortAndFormats;
        Collection<ConcurrentSearchRequestDecider.Factory> concurrentSearchDeciderFactories  
    public Profilers getProfilers() {  
    public boolean keywordIndexOrDocValuesEnabled() {
    private final BigArrays bigArrays;
    @Override
    @Override
            }
        return indexSettings.get(
                clusterService.getClusterSettings().get(SearchService.CONCURRENT_SEGMENT_SEARCH_TARGET_MAX_SLICE_COUNT_SETTING)  
                if (logger.isDebugEnabled()) {
 * KIND, either express or implied.  See the License for the
            validate,
        boolean isStreamSearch
    public boolean seqNoAndPrimaryTerm() {  
    public Map<Class<?>, CollectorManager<? extends Collector, ReduceableSearchResult>> queryCollectorManagers() {
                    );
                        "Rescore window ["
            requestToAggReduceContextBuilder,  
/*  
    @Override  
        return cachedFlushMode.trySet(flushMode);
    @Override
            request::nowInMillis,
    public boolean sourceRequested() {
    /**  
            Query slicedQuery = sliceBuilder.toFilter(clusterService, request, queryShardContext, minNodeVersion);
/**  
    }
    }  
    // filter for sliced scroll  
    @Override
    }
    @Override
        return rc;
        );
}
    public SearchShardTarget shardTarget() {  
    public CollapseContext collapse() {
            return query;
    /**
    }  
import org.opensearch.search.aggregations.SearchContextAggregations;  
    }
import org.apache.logging.log4j.LogManager;
    }  
        return (concurrentSearchMode.equals(CONCURRENT_SEGMENT_SEARCH_MODE_AUTO)
    }
                IndexSettings.INDEX_CONCURRENT_SEGMENT_SEARCH_PARTITION_STRATEGY.getKey(),  
    public void evaluateRequestShouldUseConcurrentSearch() {  
    @Override
     */
    private final ShardSearchRequest request;
        this.listener = listener;
        assert requestShouldUseConcurrentSearch.get() != null : "requestShouldUseConcurrentSearch must be set";  
    public FlushMode getFlushMode() {
                        + resultWindow  
     * Evaluate if request should use concurrent search based on request and concurrent search deciders
        this.concurrentSearchDeciderFactories = concurrentSearchDeciderFactories;
                "Batch size is too large, size must be less than or equal to: ["
import org.opensearch.search.query.QuerySearchResult;
        }  
import org.opensearch.search.aggregations.metrics.CardinalityAggregationContext;
    private String evaluateConcurrentSearchMode(Executor concurrentSearchExecutor) {
import org.opensearch.index.query.AbstractQueryBuilder;  
        return this;
        // initialize the filtering alias based on the provided filters  
    @Override  
        if (sliceBuilder != null && readerContext != null && readerContext instanceof PitReaderContext) {
    @Override
import java.util.function.Function;
                        );
    public SearchContext includeNamedQueriesScore(boolean includeNamedQueriesScore) {
        return bigArrays;  
    /**
    }  
            return;  
        this.shardTarget = shardTarget;
                        + "]. This limit can be set by changing the ["
        if (rescore == null) {
    @Override
        this.docIdsToLoad = docIdsToLoad;
    private final ClusterService clusterService;  
            executor,
        return explain;  
    private final LongSupplier relativeTimeSupplier;
            // plugins don't have preference, decide based on whether request has aggregations or not.  
     * The original query as sent by the user without the types and aliases  
import java.util.Collection;
    }
    public SearchContext searchAfter(FieldDoc searchAfter) {  
    }
        if (clusterService != null) {  
                            + "It must be less than ["
        return from;  
        final ConcurrentSearchDecision pluginDecision = ConcurrentSearchDecision.getCompositeDecision(decisions);
        return this;
    private final Version minNodeVersion;  
                        + IndexSettings.MAX_SLICES_PER_PIT.getKey()
        this.suggest = suggest;
            return clusterService.getClusterSettings().get(SearchService.TERMS_AGGREGATION_MAX_PRECOMPUTE_CARDINALITY);  
        if (aliasFilter != null) {  
    @Override
    @Override  
    @Override
    }
    }  
    }
        ClusterService clusterService,  
        this.minimumScore = minimumScore;  
    }  
import org.opensearch.search.startree.StarTreeQueryHelper;  
import java.util.function.LongSupplier;
                clusterService.getClusterSettings().get(CompositeIndexSettings.STAR_TREE_INDEX_ENABLED_SETTING)
    }
            throw new IllegalArgumentException(
    @Override
    public SearchExtBuilder getSearchExt(String name) {
    public void highlight(SearchHighlightContext highlight) {  
     *
    private final float queryBoost;  
 * ownership. Elasticsearch licenses this file to you under  
    private final Engine.Searcher engineSearcher;
    @Override
import org.opensearch.search.fetch.subphase.FetchFieldsContext;  
    public boolean isCancelled() {
    public boolean explain() {
    public SearchContext sliceBuilder(SliceBuilder sliceBuilder) {
 * The OpenSearch Contributors require contributions made to  
    @Override
    private final SetOnce<Boolean> requestShouldUseIntraSegmentSearch = new SetOnce<>();
    }
    public void setTask(SearchShardTask task) {  
        return maxAggRewriteFilters;
        }  
    @Override
            requestShouldUseIntraSegmentSearch.set(false);
        return this;
 * the Apache License, Version 2.0 (the "License"); you may
    @Override  
        return rescore;
            && new NestedHelper(mapperService()).mightMatchNestedDocs(query)
    public ReaderContext readerContext() {  
    @Override  
import org.opensearch.index.mapper.ObjectMapper;
        );  
     * The query to execute, in its rewritten form.  
    }  
    }
    }  
    @Override
    }  
    @Override
    @Override
    }  
        return new CardinalityAggregationContext(false, Runtime.getRuntime().maxMemory() / 100);
        boolean validate,
        return mapperService().getObjectMapper(name);
            engineSearcher.getQueryCachingPolicy(),
        requestShouldUseIntraSegmentSearch.set(result);
        return 0;
    public BigArrays bigArrays() {
    }
    }  
            return Collections.emptyList();
        TimeValue timeout,
    private boolean isStreamSearch;
                throw new IllegalArgumentException(
import org.apache.lucene.search.Collector;  
    }
        this.originalQuery = query;
        this.groupStats = groupStats;
    public StreamSearchChannelListener getStreamChannelListener() {
import org.opensearch.search.dfs.DfsSearchResult;
     */
        } else if (aggregations() != null  
            requestShouldUseIntraSegmentSearch.set(false);
    public FetchSourceContext fetchSourceContext() {  
 * this work for additional information regarding copyright
        return highlight;
import org.opensearch.search.internal.SearchContext;
    }
                    + "] but was ["
    }  
    public ObjectMapper getObjectMapper(String name) {
        boolean validate,  
        ClusterService clusterService,
        return queryCollectorManagers;  
    public DfsSearchResult dfsResult() {  
            return CardinalityAggregationContext.from(hybridCollectorEnabled, memoryThreshold);
    private ParsedQuery originalQuery;
        return this;  
            concurrentSearchDeciderFactories,
    public boolean shouldUseConcurrentSearch() {
     *
    @Override
        return indexService.cache().bitsetFilterCache();
     * Returns intra-segment search status for the search context.
        }  
import java.util.Map;  
    @Override
import static org.opensearch.search.SearchService.CONCURRENT_SEGMENT_SEARCH_PARTITION_STRATEGY;
    }
     */
        return cardinalityAggregationContext;
        }
                        + "] index level setting."  
    private SearchContextAggregations aggregations;  
    /**
        return collapse;
    public Float minimumScore() {
            return clusterService.getClusterSettings().get(MAX_AGGREGATION_REWRITE_FILTERS);  
        // Step 2: If new concurrent setting is not explicitly set
            } else if (concurrentSearchMode.equals(CONCURRENT_SEGMENT_SEARCH_MODE_AUTO)) {  
            builder.add(query, Occur.MUST);
     */
    @Override
        if (pluginDecision.getDecisionStatus().equals(ConcurrentSearchDecision.DecisionStatus.NO_OP)) {
 */
import org.opensearch.index.mapper.MapperService;
                        + sliceLimit  
        return relativeTimeSupplier.getAsLong();
     * missing executor, or explicitly disabled settings), then we return a slice count of 1.  
    /**
    }
        this.collapse = collapse;
        return docsIdsToLoadSize;  
    private SearchType searchType;  
    public long termsAggregationMaxPrecomputeCardinality() {
    }
    private List<RescoreContext> rescore;  
                throw new OpenSearchRejectedExecutionException(  
    ) throws IOException {  
import java.util.Optional;
            }
    private int from = -1;
    }  
import org.opensearch.common.SetOnce;  
    }  
            engineSearcher.getIndexReader(),
        return queryShardContext;
                            + "]. This prevents allocating massive heaps for storing the results "  
    }
    @Override  
    @Override  
    @Override  
                        logger.debug(
            ConcurrentSearchDecision decision = decider.getConcurrentSearchDecision();
    }
        }
        return Boolean.TRUE.equals(requestShouldUseIntraSegmentSearch.get());
    @Override  
        return task.isCancelled();
import org.opensearch.index.mapper.MappedFieldType;  
package org.opensearch.search;
    }  
                    + resultWindow
    private int docsIdsToLoadSize;
                    + "]. Scroll batch sizes cost as much memory as result windows so they are controlled by the ["  
                    logger.debug("request has supported aggregations, using concurrent search");  
    @Override
import static org.opensearch.search.SearchService.BUCKET_SELECTION_STRATEGY_FACTOR_SETTING;
    @Override  
    @Override
     */  
            engineSearcher.getSimilarity(),  
import org.opensearch.common.lucene.search.Queries;
    public boolean shouldUseIntraSegmentSearch() {
import org.opensearch.search.fetch.subphase.highlight.SearchHighlightContext;  
            || concurrentSearchMode.equals(CONCURRENT_SEGMENT_SEARCH_MODE_ALL))  
    DefaultSearchContext(
        return this;
    public ScriptFieldsContext scriptFields() {  
        return this.indexShard;  
    }  
    }
import org.opensearch.index.query.QueryBuilder;
    @Override
import org.opensearch.index.engine.Engine;
import static org.opensearch.search.streaming.FlushModeResolver.STREAMING_MIN_CARDINALITY_RATIO;  
    public SearchContext trackScores(boolean trackScores) {  
        this.filterRewriteSegmentThreshold = evaluateAggRewriteFilterSegThreshold();  
        return bucketCollectorProcessor;  
    public SearchContextAggregations aggregations() {
        IntraSegmentSearchDecider decider = new IntraSegmentSearchDecider();
                decisions.add(decision);  
        this.includeNamedQueriesScore = includeNamedQueriesScore;  
        if (concurrentSearchRequestDeciders.size() > 0) {  
        this.fetchPhase = fetchPhase;  
import org.apache.lucene.search.FieldDoc;  
        }
        return this.query;
 * SPDX-License-Identifier: Apache-2.0
        this.rescore.add(rescore);  
    private int[] docIdsToLoad;  
                .get(CardinalityAggregator.CARDINALITY_AGGREGATION_HYBRID_COLLECTOR_MEMORY_THRESHOLD);
    public ContextIndexSearcher searcher() {  
import static org.opensearch.search.SearchService.MAX_AGGREGATION_REWRITE_FILTERS;
     * Should be called before executing the main query and after all other parameters have been set.  
        return this.request;  
            BooleanQuery filtered = builder.build();  
            );
        queryShardContext = indexService.newQueryShardContext(
    public long getRelativeTimeInMillis() {  
    @Override
        return aliasFilter;
     * Returns concurrent segment search status for the search context. This should only be used after request parsing, during which requestShouldUseConcurrentSearch will be set.
    @Override
import org.apache.lucene.search.CollectorManager;
    public void version(boolean version) {
            parsedQuery(ParsedQuery.parsedMatchAllQuery());  
    }
        final String newConcurrentMode = indexSettings.get(  
    public SearchContext parsedQuery(ParsedQuery query) {  
 *
    }  
    @Override
        return this;
    @Override
    }
            && sort.sort.getSort()[0].getReverse() == false;
            // which defeats Lucene's COMPLETE_NO_SCORES fast path (the MUST clause's scorer is still set up  
import static org.opensearch.search.SearchService.CONCURRENT_SEGMENT_SEARCH_MODE_ALL;  
    public int terminateAfter() {
        if (sort != null && sort.isSortOnTimeSeriesField()) {
 *
        return readerContext;
import java.util.Collections;
import static org.opensearch.search.SearchService.CONCURRENT_SEGMENT_SEARCH_PARTITION_STRATEGY_SEGMENT;
        return storedFields != null;  
            // combined query would otherwise be scored despite the caller having requested constant scoring.
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.index.search.NestedHelper;
    public void suggest(SuggestionSearchContext suggest) {
import org.opensearch.search.fetch.subphase.ScriptFieldsContext;
                    logger.debug("concurrent search decision from plugin decider [{}]", decision.toString());
    public void terminateAfter(int terminateAfter) {  
    }  
        return task;  
 * GitHub history for details.
    private final CardinalityAggregationContext cardinalityAggregationContext;  
        return SearchService.DEFAULT_BUCKET_SELECTION_STRATEGY_FACTOR;
     */  
    private int evaluateFilterRewriteSetting() {
 * Modifications Copyright OpenSearch Contributors. See
        return fetchSourceContext != null;
            throw new UncheckedIOException(e);
    public void setBucketCollectorProcessor(BucketCollectorProcessor bucketCollectorProcessor) {  
     */
            bigArrays,
        boolean lowLevelCancellation,
    public InternalAggregation.ReduceContext partialOnShard() {
     * Returns the target maximum slice count to use for concurrent segment search.  
            } else {
     * This effectively disables concurrent slicing and ensures that the search is performed
    public boolean shouldUseTimeSeriesDescSortOptimization() {  
                        + "This limit can be set by changing the ["
        this.searchAfter = searchAfter;
            int sliceLimit = indexService.getIndexSettings().getMaxSlicesPerScroll();
    @Override  
        ShardSearchRequest request,  
    @Override  
        } else {  
    public void explain(boolean explain) {
     * </ol>
    private CollapseContext collapse;
     * Used when streaming cost analysis determines traditional processing is more efficient.
    private int evaluateCardinalityAggregationPruningThreshold() {  
        // then check if Legacy boolean setting is explicitly set → use it
        return 30_000L;
            return;
    private final IndexShard indexShard;
        }  
        FetchPhase fetchPhase,
    @Override  
     *     <li>If the request targets a system index or uses search throttling, concurrent segment search is disabled.</li>  
 * @opensearch.internal  
    }
     * things like the type filter or alias filters.
/*
    public SimilarityService similarityService() {  
    @Override
    @Override  
        // Skip concurrent search for system indices, throttled requests, or if dependencies are missing
    }
        if (scriptFields == null) {
        // Step 3: Neither explicitly set → use default concurrent mode
    }
    private final Map<String, SearchExtBuilder> searchExtBuilders = new HashMap<>();  
    public void groupStats(List<String> groupStats) {  
import org.opensearch.search.slice.SliceBuilder;
    public void seqNoAndPrimaryTerm(boolean seqNoAndPrimaryTerm) {
    }
    }
                queryBuilder.visit(concurrentSearchVisitor);
    }  
        this.indexShard = readerContext.indexShard();  
    @Override  
            return 1; // Disable slicing: run search in a single thread when concurrent search is off
    private final long termsAggregationMaxPrecomputeCardinality;
    }
import java.util.concurrent.Executor;  
        return storedFields;
                    }  
                    }
                );  
 *    http://www.apache.org/licenses/LICENSE-2.0
    private SortAndFormats sort;
        this.bucketCollectorProcessor = bucketCollectorProcessor;
                            getPartitionStrategy()
        this.aggregations = aggregations;
    @Override
    }  
import org.opensearch.index.IndexSettings;
            this.rescore = new ArrayList<>();
import org.opensearch.index.query.QueryShardContext;  
    private final boolean keywordIndexOrDocValuesEnabled;
     *             <li><code>false</code> → disables it ("none")</li>
    }
            this.searcher,
    @Override
    @Override
/*  
            if (slicedQuery instanceof MatchNoDocsQuery) {  
    @Override  
     * The query to actually execute.
    public QuerySearchResult queryResult() {
    }
 * not use this file except in compliance with the License.
                        + "] is too large. It must "  
    public int[] docIdsToLoad() {
 * You may obtain a copy of the License at  
                throw new IllegalArgumentException("Cannot use [sort] option in conjunction with [rescore].");
     *     <li>Otherwise, the modern string-based setting is used. Allowed values are: "none", "auto", or "all".</li>
import org.opensearch.action.support.StreamSearchChannelListener;  
    }
    }  
        }  
    }
    @Override
            if (scrollContext() == null) {
import org.opensearch.search.deciders.ConcurrentSearchVisitor;
     */  
        return this.postFilter;  
    /**
    }
    @Override
    }  
        final List<ConcurrentSearchDecision> decisions = new ArrayList<>();
                    + maxResultWindow  
            IntraSegmentSearchVisitor visitor = new IntraSegmentSearchVisitor(decider);
        ClusterSettings clusterSettings = clusterService.getClusterSettings();
     * applied. Putting things in here leaks them into highlighting so don't add
        boolean lowLevelCancellation,
        return this;
    private Query query;  
        this.seqAndPrimaryTerm = seqNoAndPrimaryTerm;  
    public boolean lowLevelCancellation() {  
    @Override  
    public SearchContext docValuesContext(FetchDocValuesContext docValuesContext) {
    private List<String> groupStats;
        return trackTotalHitsUpTo;
    private SearchShardTask task;
import java.io.IOException;
        return this.scriptFields;
    }  
    @Override
        if (queryBoost() != AbstractQueryBuilder.DEFAULT_BOOST) {
import org.opensearch.search.deciders.IntraSegmentSearchVisitor;  
     * @return the resolved concurrent segment search mode: "none", "auto", or "all"
        // parsed by the corresponding parser. There is one single name and one single way to retrieve the parsed object from the context.  
import java.util.ArrayList;  
            engineSearcher.getQueryCache(),
import org.opensearch.search.suggest.SuggestionSearchContext;
 * under the License.  
    }
                        + maxResultWindow
                            + IndexSettings.MAX_RESCORE_WINDOW_SETTING.getKey()
    }  
        return indexService.getIndexSettings()
            // access-control filters (e.g. document-level security composed with a filtered alias), where the  
            shardTarget.getClusterAlias(),  
    public SearchContext aggregations(SearchContextAggregations aggregations) {
    public long getStreamingMaxEstimatedBucketCount() {
    }  
                        + "] is too large. It must "
        rc.setSliceLevel(shouldUseConcurrentSearch());
            scriptFields = new ScriptFieldsContext();
    public BucketCollectorProcessor bucketCollectorProcessor() {
        }
            return pluginDecision.getDecisionStatus() == ConcurrentSearchDecision.DecisionStatus.YES;
                    if (logger.isDebugEnabled()) {
    @Override  
    public long getStreamingMinEstimatedBucketCount() {  
        this.indexService = readerContext.indexService();
        return 0;
    @Override
    public void setStreamChannelListener(StreamSearchChannelListener listener) {  
                );
        ShardSearchRequest request,
        Function<SearchSourceBuilder, InternalAggregation.ReduceContextBuilder> requestToAggReduceContextBuilder,  
            } else if (CONCURRENT_SEGMENT_SEARCH_PARTITION_STRATEGY_SEGMENT.equals(getPartitionStrategy()) == false  
                } else {
            if (numSlices > sliceLimit) {
     * <ol>
            evaluateKeywordIndexOrDocValuesEnabled()
    private final int maxAggRewriteFilters;
        if (indexShard.isSystem()  
    private BucketCollectorProcessor bucketCollectorProcessor = NO_OP_BUCKET_COLLECTOR_PROCESSOR;
    public boolean hasScriptFields() {
    private final Function<SearchSourceBuilder, InternalAggregation.ReduceContextBuilder> requestToAggReduceContextBuilder;
 * this file be licensed under the Apache-2.0 license or a
        if (aggregations() != null && aggregations().factories() != null) {
            && Boolean.TRUE.equals(requestShouldUseConcurrentSearch.get());
        return indexService.getIndexSettings()  
        return "search";
    @Override
    }  
                        + numSlices
    @Override  
    }
    }  
    private ParsedQuery postFilter;
        if (sliceBuilder != null) {
     *     </li>  
import org.opensearch.core.common.unit.ByteSizeValue;
    }
        return size;
        return fetchResult;
 * compatible open source license.
        return this.sort;
    @Override  
        return bucketSelectionStrategyFactor;
        // evaluate based on concurrent search query visitor
import org.opensearch.search.query.QueryPhaseExecutionException;  
        this.keywordIndexOrDocValuesEnabled = evaluateKeywordIndexOrDocValuesEnabled();  
     *     <li>If a legacy boolean setting is present (cluster or index level), it is honored:
 * software distributed under the License is distributed on an
    }
            && aggregations().factories() != null
    }
        }
    private boolean trackScores = false; // when sorting, track scores as well...  
    }  
        return dfsResult;
        InternalAggregation.ReduceContext rc = requestToAggReduceContextBuilder.apply(request.source()).forPartialReduction();  
    private boolean includeNamedQueriesScore = false;
            try {
        if (clusterService != null) {  
    @Override
            final Optional<ConcurrentSearchRequestDecider> concurrentSearchRequestDecider = deciderFactory.create(
        return storedFields != null && storedFields.fieldNames() != null;
            // If the main query is already a ConstantScoreQuery, the caller has explicitly opted out of
        } else {  
    }  
        // create the ConcurrentSearchRequestDeciders using registered factories
    @Override
            BooleanQuery.Builder builder = new BooleanQuery.Builder();
import org.opensearch.search.internal.ScrollContext;
    @Override
        this.docsIdsToLoadSize = docsIdsToLoadSize;
        return storedFields == null || storedFields.fetchFields();
    private boolean evaluateAutoMode() {
    public boolean includeNamedQueriesScore() {
        long resultWindow = from + size;  
    }  
        }  
        return queryResult;  
        if (sliceBuilder != null && scrollContext() != null) {  
            IndexSettings.INDEX_CONCURRENT_SEGMENT_SEARCH_MODE.getKey(),
    }
    @Override  
        this.highlight = highlight;
    private final ContextIndexSearcher searcher;
            shardTarget,
            return CONCURRENT_SEGMENT_SEARCH_MODE_NONE;
        this.sliceBuilder = sliceBuilder;  
    public int bucketSelectionStrategyFactor() {  
            return filtered;
        Version minNodeVersion,
    private final boolean lowLevelCancellation;
 */  
    @Override
    private FetchFieldsContext fetchFieldsContext;
    private TimeValue timeout;
        TimeValue timeout,  
import org.apache.lucene.search.BooleanClause.Occur;  
        );  
        this.requestToAggReduceContextBuilder = requestToAggReduceContextBuilder;  
     * This method evaluates both index-level and cluster-level settings to decide whether  
        for (ConcurrentSearchRequestDecider.Factory deciderFactory : concurrentSearchDeciderFactories) {  
            && !aggregations().factories().allFactoriesSupportConcurrentSearch()) {
            filters.add(aliasFilter);
import org.opensearch.cluster.service.ClusterService;
    }
        }
import org.opensearch.search.deciders.ConcurrentSearchDecision;
        this.concurrentSearchMode = evaluateConcurrentSearchMode(executor);  
    @Override
    @Override
                return new ConstantScoreQuery(filtered);  
        return clusterService.getClusterSettings().get(STREAMING_MIN_CARDINALITY_RATIO);
                IndexSettings.INDEX_CONCURRENT_SEGMENT_SEARCH_MAX_SLICE_COUNT.getKey(),
                        + "] index level setting."
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_MODE;
import org.apache.logging.log4j.Logger;
            return Boolean.TRUE.equals(legacySetting) ? CONCURRENT_SEGMENT_SEARCH_MODE_ALL : CONCURRENT_SEGMENT_SEARCH_MODE_NONE;
        return 0;
        logger.debug(
            return clusterService.getClusterSettings().get(CARDINALITY_AGGREGATION_PRUNING_THRESHOLD);
    public SearchContext size(int size) {  
    @Override
    }  
        }
        return indexService.mapperService();
        return this;  
    public FetchFieldsContext fetchFieldsContext() {
    public SearchType searchType() {
    public IndexShard indexShard() {
            int sliceLimit = indexService.getIndexSettings().getMaxSlicesPerPit();  
    @Override  
                }
    private int terminateAfter = DEFAULT_TERMINATE_AFTER;
    @Override  
     *         </ul>
    private SliceBuilder sliceBuilder;
            lowLevelCancellation,  
        return this;
    public SuggestionSearchContext suggest() {
                && request().source().query() != null
    }
    @Override
    public SearchContext collapse(CollapseContext collapse) {
            clusterSettings.getOrNull(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING)
    @Override
    public boolean isStreamSearch() {
    public int filterRewriteSegmentThreshold() {  
    }
        if (mapperService().hasNested()  
    private FieldDoc searchAfter;
            || indexShard.indexSettings().isSearchThrottled()
        assert concurrentSearchMode != null : "concurrentSearchMode must be set";
    }  
        if (CONCURRENT_SEGMENT_SEARCH_PARTITION_STRATEGY_SEGMENT.equals(partitionStrategy) || shouldUseConcurrentSearch() == false) {
    private final int bucketSelectionStrategyFactor;
        if (clusterService != null) {
import org.opensearch.search.internal.ShardSearchContextId;  
        this.task = task;
    @Override
    }
