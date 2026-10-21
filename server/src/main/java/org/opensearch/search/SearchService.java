    public void executeQueryPhase(
                    } else {
        }
                    freeReaderContext(readerContext.id());
    }
        }
                DEFAULT_KEEPALIVE_SETTING,
        "search.default_allow_partial_results",
                decreaseScrollContexts = openScrollContexts::decrementAndGet;
    public static final Setting<Integer> MAX_OPEN_SCROLL_CONTEXT = Setting.intSetting(
        this.threadPool = threadPool;
            }
                if (minMax.compareMax(searchAfterPrimary) < 0) {
        );
        Property.NodeScope
            return false;
    public static final Setting<Boolean> LOW_LEVEL_CANCELLATION_SETTING = Setting.boolSetting(
     * This value is dynamically calculated as:
            }
        boolean isStreamSearch,
        ClusterService clusterService,
                canMatchSearcher = readerContext.acquireSearcher(Engine.CAN_MATCH_SEARCH_SOURCE);
                    searchOperationListener.onFreePitContext(finalReaderContext);
                assert TransportActions.isShardNotAvailableException(e) == false : new AssertionError(e);
        final DefaultSearchContext context = createSearchContext(readerContext, request, defaultSearchTimeout, false, isStreamSearch);
import org.opensearch.wlm.WorkloadGroupService;
            context.explain(source.explain());
                case CONCURRENT_SEGMENT_SEARCH_PARTITION_STRATEGY_BALANCED:
     * if the execution of the search request can be early terminated without executing it. This is for instance not possible if
            }
        } catch (Exception e) {
                IOUtils.closeWhileHandlingException(searchContext);
 * Unless required by applicable law or agreed to in writing,
import java.util.concurrent.atomic.AtomicLong;
                throw new SearchException(shardTarget, "failed to create RescoreSearchContext", e);
                // we handle the failure in the failure listener below
        Setting.Property.NodeScope,
    }
    ) throws Exception {
        if (context.getStarTreeIndexEnabled() && StarTreeQueryHelper.isStarTreeSupported(context)) {
                    + "It must be less than ("
        if (source.seqNoAndPrimaryTerm() != null) {
    public static final class CanMatchResponse extends SearchPhaseResult {
                // We also pass the rescoreDocIds to the LegacyReaderContext in case the search state needs to stay in the data node.
                    freeReaderContext(readerContext.id());
    public DeletePitResponse freeReaderContextsIfFound(List<PitSearchContextIdForNode> contextIds) {
        }
            time = startTime;
                QueryStringQueryParser::setMaxQueryStringLengthMonitorMode
import static org.opensearch.common.unit.TimeValue.timeValueHours;
            }
            );
        private long afterQueryTime = -1;
            });
        ReaderContext context = activeReaders.get(id.getId());
        // nothing to parse...
            if (request.readerId() != null) {
        clusterService.getClusterSettings().addSettingsUpdateConsumer(INDICES_MAX_CLAUSE_COUNT_SETTING, IndexSearcher::setMaxClauseCount);
    /**
            }
                } else {
                readerContext = new ReaderContext(id, indexService, shard, reader, keepAlive, request.keepAlive() == null);
    public DefaultSearchContext createSearchContext(ShardSearchRequest request, TimeValue timeout, boolean validate) throws IOException {
    }
                // SCORE/DOC sorts have a null field name; compare null-safely so this is a SearchException, not an NPE
        }
    );
            }
        "search.derived_field.enabled",
        }
     * noticeably slow down searches.
                        return;
        Releasable updatePit = null;
        assert request.keepAlive() == null;
                boolean canMatch;
    public static final Setting<Boolean> SEARCH_MAX_QUERY_STRING_LENGTH_MONITOR_ONLY = Setting.boolSetting(
    /**
    }
                    }
        }
            searchContext = new DefaultSearchContext(
import org.opensearch.OpenSearchException;
        "search.query.max_query_nesting_depth",
                IndexShard indexShard = indexService.getShard(request.shardId().getId());
                processScroll(request, readerContext, searchContext);
    }
                searchContext.searcher().setAggregatedDfs(readerContext.getAggregatedDfs(request.getAggregatedDfs()));
                case CONCURRENT_SEGMENT_SEARCH_MODE_NONE:
            try {
        maxOpenScrollContext = MAX_OPEN_SCROLL_CONTEXT.get(settings);
        try {
    );
                            + "This limit can be set by changing the ["
        assert request.readerId() == null;
import org.opensearch.index.mapper.DerivedFieldResolverFactory;
        final String executorName;
    }
        MinAndMax<?> minMax,
        }
    }
        });
        QueryRewriterRegistry.INSTANCE.initialize(settings, clusterService.getClusterSettings());
import org.opensearch.index.engine.Engine;
                    }
        Setting.Property.NodeScope,
    final ReaderContext createOrGetReaderContext(ShardSearchRequest request, boolean keepStatesInContext) {
    private volatile int maxOpenScrollContext;
            if (readerContext.scrollContext() != null) {
                if (request.scroll() != null) {
                    : new OpenSearchException(exception.getCause());
import org.opensearch.search.internal.AliasFilter;
        }
            }
                    return false;
                Releasables.closeWhileHandlingException(decreasePitContexts);
    public void createPitReaderContext(ShardId shardId, TimeValue keepAlive, ActionListener<ShardSearchContextId> listener) {
        if (source.timeout() != null) {
        if (CollectionUtils.isEmpty(source.searchAfter()) == false) {
    }
    /**
import org.opensearch.search.aggregations.MultiBucketConsumerService;
                    // no hits, we can release the context since there will be no fetch phase
    }
            for (org.opensearch.search.builder.SearchSourceBuilder.ScriptField field : source.scriptFields()) {
    private void checkPitKeepAliveLimit(long keepAlive) {
        return context;
        }
        TaskResourceTrackingService taskResourceTrackingService,
    private void parseSource(DefaultSearchContext context, SearchSourceBuilder source, boolean includeAggregations) {
            listener.onResponse(canMatch(request));
     */
                context.highlight(highlightBuilder.build(queryShardContext));
import org.opensearch.search.internal.ReaderContext;
        // this is important to ensure store can be cleaned up, in particular if the search is a scroll with a long timeout.
        IndicesService indicesService,
                    + " > "
                taskResourceTrackingService.writeTaskResourceUsage(task, clusterService.localNode().getId());
    }
            }
            }
        Property.Deprecated
        true,
import org.opensearch.search.internal.ShardSearchContextId;
        if (source.fetchSource() != null) {
        final Suggest suggest = context.queryResult().suggest();
            .addSettingsUpdateConsumer(SEARCH_MAX_QUERY_NESTING_DEPTH, QueryStringQueryParser::setMaxQueryNestingDepth);
                            + "]. "
                    } catch (Exception exc) {
            freeReaderContext(readerContext.id());
        ShardSearchRequest request,
    }
    }
                freeReaderContext(reader.id());
                    + MAX_PIT_KEEPALIVE_SETTING.getKey()
        timeValueHours(24),
    }
        }
            reader.validate(request);
        return context instanceof LegacyReaderContext && context.singleSession() == false;
            context.minimumScore(source.minScore());
                    throw new SearchException(shardTarget, "failed to build inner_hits", e);
        String executorName
                    if (fetch) {
    public AliasFilter buildAliasFilter(ClusterState state, String index, Set<String> resolvedExpressions) {
                for (int i = context.from(); i < Math.min(totalSize, topDocs.scoreDocs.length); i++) {
            public void onResponse(T resp) {
            try (Releasable ignored2 = canMatchSearcher) {
        }
            searchContext.getQueryShardContext().setDerivedFieldResolver(derivedFieldResolver);
import org.opensearch.action.search.SearchShardTask;
            } else {
        Property.Dynamic,
    }
        if (source.query() != null) {
            );
        if (source == null || source.query() == null || source.query() instanceof MatchAllQueryBuilder || source.suggest() != null) {
                searcherSupplier = shard.acquireSearcherSupplier();
        }
import org.opensearch.common.lease.Releasable;
            .addSettingsUpdateConsumer(DEFAULT_KEEPALIVE_SETTING, MAX_KEEPALIVE_SETTING, this::setKeepAlives, this::validateKeepAlives);
                ListPitInfo pitInfo = new ListPitInfo(context.getPitId(), context.getCreationTime(), context.getKeepAlive());
            }
    ) {
        try (
                SearchContext searchContext = createContext(readerContext, shardSearchRequest, task, false);
                final RescoreDocIds rescoreDocIds = searchContext.rescoreDocIds();
        Property.NodeScope
        QueryStringQueryParser.setMaxQueryStringLength(SEARCH_MAX_QUERY_STRING_LENGTH.get(settings));
        QueryStringQueryParser.setMaxQueryNestingDepth(SEARCH_MAX_QUERY_NESTING_DEPTH.get(settings));
                return InternalAggregation.ReduceContext.forPartialReduction(
        if (context instanceof PitReaderContext pitReaderContext) {
    private void setLowLevelCancellation(Boolean lowLevelCancellation) {
                // we handle the failure in the failure listener below
    }
            }
    // Allow concurrent segment search for all requests
            // Apply query rewriting optimizations
            public void onResponse(ShardSearchRequest orig) {
        }
    private Executor getExecutor(String executor, IndexShard indexShard) {
import org.opensearch.core.index.shard.ShardId;
        return Math.max(1, Math.min(Runtime.getRuntime().availableProcessors() / 2, 4));
                    if (searchContext.getProfilers() != null) {
        runAsync(getExecutor(executorName, readerContext.indexShard()), () -> {
            && Objects.equals(trackTotalHitsUpto, TRACK_TOTAL_HITS_DISABLED)) {
import org.opensearch.core.common.util.CollectionUtils;
                    // null query means match_all
            listener.onFailure(e);
        } else if (request.keepAlive() != null) {
import org.opensearch.search.fetch.FetchPhase;
                            continue;
                }
                    + ") is too large. "
        SearchShardTask task,
import org.opensearch.index.mapper.DerivedFieldResolver;
        return new QueryFetchSearchResult(context.queryResult(), context.fetchResult());
                assert TransportActions.isShardNotAvailableException(e) == false : new AssertionError(e);
    );
        private final SearchContext context;
                    + TimeValue.timeValueMillis(keepAlive)
import org.opensearch.threadpool.Scheduler.Cancellable;
        Setting.Property.NodeScope,
                    scriptService,
        SearchShardTask task,
                    throw new SearchException(shardTarget, "[stored_fields] cannot be disabled when using the [fields] option");
                taskResourceTrackingService.writeTaskResourceUsage(task, clusterService.localNode().getId());
        this.scriptService = scriptService;
import org.opensearch.common.settings.Settings;
                        "Trying to create too many Point In Time contexts. Must be less than or equal to: ["
            return estimatedMinAndMax;
                deleteResults.add(deletePitInfo);
        }
        rewriteAndFetchShardRequest(shard, request, new ActionListener<ShardSearchRequest>() {
            if (primarySortField.order() == SortOrder.DESC) {
                listener.onResponse(request);
import org.opensearch.common.util.io.IOUtils;
        final Index index = context.indexShard().shardId().getIndex();
    /**
        // adding a lot of overhead
        return defaultAllowPartialSearchResults;
            // We need to release the reader context of the scroll when we hit any exception (here the keep_alive can be too large)
            if (request.scroll() != null) {
                if (context.isExpired()) {
import org.opensearch.script.FieldScript;
     */
                    DeletePitInfo deletePitInfo = new DeletePitInfo(true, contextId.getPitId());
                request.getClusterAlias(),
    private final AtomicInteger openPitContexts = new AtomicInteger();
        // once an index is removed due to deletion or closing, we can just clean up all the pending search context information
        return true;
import org.opensearch.index.shard.IndexEventListener;
        Property.NodeScope
    private void setKeepAlives(TimeValue defaultKeepAlive, TimeValue maxKeepAlive) {
     */
        if (getReaderContext(contextId) != null) {
    public void executeQueryPhase(
        QueryShardContext queryShardContext = context.getQueryShardContext();
            if (context.scrollContext() != null) {
    /**
                indexService = indicesService.indexServiceSafe(request.shardId().getIndex());
import org.opensearch.search.query.QuerySearchRequest;
                );
     *   <li>On larger machines, it caps the concurrency to a reasonable level (4 slices).</li>
        clusterService.getClusterSettings().addSettingsUpdateConsumer(MAX_OPEN_PIT_CONTEXT, this::setMaxOpenPitContext);
                        + "] index level setting."
        Setting.Property.NodeScope,
                    + DEFAULT_KEEPALIVE_SETTING.getKey()
                if (context.queryResult().hasSearchContext() == false && readerContext.singleSession()) {
        Property.NodeScope
        clusterService.getClusterSettings()
        for (ReaderContext ctx : activeReaders.values()) {
        }
    }
                        listener.onFailure(exc);
            TopDocs topDocs = context.queryResult().topDocs().topDocs;
        if (source.slice() != null) {
    private void processScroll(InternalScrollSearchRequest request, ReaderContext reader, SearchContext context) {
        throws IOException {
        boolean isStreamSearch
        this.maxPitKeepAlive = maxPitKeepAlive.millis();
import org.opensearch.common.lifecycle.AbstractLifecycleComponent;
        ReaderContext readerContext = createOrGetReaderContext(request, keepStatesInContext);
        ActionListener<SearchPhaseResult> listener,
            return finalReaderContext;
    public void canMatch(ShardSearchRequest request, ActionListener<CanMatchResponse> listener) {
    }
        final IndexShard shard = getShard(request);
            logger.trace("Query phase failed", exception);
            FetchDocValuesContext docValuesContext = FetchDocValuesContext.create(
                    throw new IllegalArgumentException("Setting value must be one of [all, none, auto]");
    private static final Logger logger = LogManager.getLogger(SearchService.class);
import java.util.Collections;
            context.searchAfter(fieldDoc);
                context.scriptFields().add(new ScriptField(field.fieldName(), searchScript, field.ignoreFailure()));
                if (sort.length != 1 || Objects.equals(sort[0].getField(), source.collapse().getField()) == false) {
                logger.trace("Fetch phase failed", e);
            }
            context.setTask(task);
 * @opensearch.internal
            final ShardSearchContextId id = new ShardSearchContextId(sessionId, idGenerator.incrementAndGet());
        }
        }
                    + "]"
    }
        if (source.storedFields() != null) {
            return request.readerId() == null ? defaultKeepAlive : -1;
        } else executorName = Objects.requireNonNullElse(executor, Names.SEARCH);
import java.util.concurrent.atomic.AtomicInteger;
import org.opensearch.common.util.concurrent.ConcurrentMapLong;
            } finally {
                DeletePitInfo deletePitInfo = new DeletePitInfo(true, contextId.getPitId());
        Property.Dynamic,
import org.opensearch.core.common.io.stream.StreamInput;
        context.scrollContext().scroll = request.scroll();
                reader.indexShard().shardId(),
        true,
                            DeletePitInfo deletePitInfo = new DeletePitInfo(true, contextId.getPitId());
                // we handle the failure in the failure listener below
     */
        Releasable decreaseScrollContexts = null;
    public static final int DEFAULT_BUCKET_SELECTION_STRATEGY_FACTOR = 5;
    );
    private void validatePitKeepAlives(TimeValue defaultKeepAlive, TimeValue maxPitKeepAlive) {
import java.util.ArrayList;
    private void freeAllContextForIndex(Index index) {
        }
        }
    }
            public ReduceContext forFinalReduction() {
                FieldScript.Factory factory = scriptService.compile(field.script(), FieldScript.CONTEXT);
            );
    public InternalAggregation.ReduceContextBuilder aggReduceContextBuilder(SearchSourceBuilder searchSourceBuilder) {
     */
            indicesService.loadIntoContext(request, context, queryPhase);
                listener.onResponse(finalReaderContext.id());
     */
        Property.Dynamic,
    }
                canMatchSearcher = indexShard.acquireSearcher(Engine.CAN_MATCH_SEARCH_SOURCE);
                readerContext = null;
            docIdsToLoad = new int[topDocs.scoreDocs.length + numSuggestDocs];
            settings,
        ReaderContext readerContext,
        if (source.explain() != null) {
                searchOperationListener.onNewReaderContext(readerContext);
    private final QueryPhase queryPhase;
        500_000,
import org.opensearch.index.shard.SearchOperationListener;
    public static final Setting<Long> TERMS_AGGREGATION_MAX_PRECOMPUTE_CARDINALITY = Setting.longSetting(
 * Licensed to Elasticsearch under one or more contributor
        public void close() {
            }
            if (fetch) {
            } catch (Exception e) {
                    + "). "
            return pitReaderContext;
     * to check if the query can match any documents. This method can have false positives while if it returns {@code false} the query
     * Returns true iff the given search source builder can be early terminated by rewriting to a match none query. Or in other words
                throw new SearchException(shardTarget, "failed to create SuggestionSearchContext", e);
    public boolean defaultAllowPartialSearchResults() {
        Property.NodeScope
                reader,
                context.suggest(source.suggest().build(queryShardContext));
        }
        ActionListener<FetchSearchResult> listener,
        DefaultSearchContext searchContext = null;
    public void executeQueryPhase(
    );
                case CONCURRENT_SEGMENT_SEARCH_PARTITION_STRATEGY_FORCE:
    }
        0,
     * This helper class ensures we only execute either the success or the failure path for {@link SearchOperationListener}.
                context.indexShard().failShard("search execution corruption failure", exc);
                SEARCH_MAX_QUERY_STRING_LENGTH_MONITOR_ONLY,
    }
import org.opensearch.index.query.MatchAllQueryBuilder;
    }
        100,
    public static final String CONCURRENT_SEGMENT_SEARCH_MODE_ALL = "all";
        }
        } else {
     */
    public static final Setting<Boolean> QUERY_REWRITING_ENABLED_SETTING = Setting.boolSetting(
    }
        return null;
import static org.opensearch.common.unit.TimeValue.timeValueMillis;
                }
import org.opensearch.action.search.PitSearchContextIdForNode;
        this.responseCollectorService = responseCollectorService;
                final ShardSearchContextId id = new ShardSearchContextId(sessionId, idGenerator.incrementAndGet());
            throw e;
        // Initialize QueryRewriterRegistry with cluster settings so TermsMergingRewriter
        if (!innerHitBuilders.isEmpty()) {
    @Override
    /**
import org.opensearch.common.util.BigArrays;
        "search.max_keep_alive",
        if (source.scriptFields() != null && source.size() != 0) {
        if (source.aggregations() != null && includeAggregations) {
        SearchShardTask task,
            }
            if (reader.singleSession()) {
    // we can have 5 minutes here, since we make sure to clean with search requests and when shard/index closes
    }
    public void updatePitIdAndKeepAlive(UpdatePitContextRequest request, ActionListener<UpdatePitContextResponse> listener) {
import org.opensearch.search.query.ScrollQuerySearchResult;
            if (isStreamSearch) {
            HighlightBuilder highlightBuilder = source.highlighter();
        final LegacyReaderContext readerContext = (LegacyReaderContext) findReaderContext(request.contextId(), request);
        Rewriteable.rewriteAndFetch(request.getRewriteable(), indicesService.getRewriteContext(request::nowInMillis), actionListener);
        ShardSearchRequest request,
                    + MAX_PIT_KEEPALIVE_SETTING.getKey()
            } else {
                    + "It must be less than ("
     * This setting defines the maximum number of active PIT reader contexts in the node , since each PIT context
        }
    /**
            readerContext.setAggregatedDfs(request.dfs());
                    + maxKeepAlive
        return indicesService;
        try {
        }
                throw e;
        rewriteAndFetchShardRequest(shard, request, new ActionListener<ShardSearchRequest>() {
                context.aggregations(new SearchContextAggregations(factories, multiBucketConsumerService.create()));
                    break;
            throw e;
import org.opensearch.common.UUIDs;
            }
        }
        return searchSourceBuilder.aggregations().buildPipelineTree();
    }
                    bigArrays,
            }
        SearchShardTarget shardTarget = context.shardTarget();
                    throw new OpenSearchRejectedExecutionException(
                }
        executeFetchPhase(request, task, listener, null);
            }
        try {
                        String pitId = pitReaderContext.getPitId();
    /**
        this.bigArrays = bigArrays;
        ScriptService scriptService,
        final ShardSearchContextId id = new ShardSearchContextId(sessionId, idGenerator.incrementAndGet());
    }
    public static final Setting<String> CLUSTER_CONCURRENT_SEGMENT_SEARCH_MODE = Setting.simpleString(
import org.opensearch.index.shard.IndexShard;
        return createSearchContext(request, timeout, true);
                SearchOperationListenerExecutor executor = new SearchOperationListenerExecutor(searchContext)
        "search.allow_expensive_queries",
                // Pass the rescoreDocIds to the queryResult to send them the coordinating node and receive them back in the fetch phase.
        } catch (Exception inner) {
        Collection<ConcurrentSearchRequestDecider.Factory> concurrentSearchDeciderFactories,
     * Controls the threshold for the number of term queries on the same field that triggers
    public DefaultSearchContext createSearchContext(ShardSearchRequest request, TimeValue timeout) throws IOException {
        "search.concurrent_segment_search.enabled",
            } catch (IOException e) {
        private final MinAndMax<?> estimatedMinAndMax;
                    }
                hasRefreshPending = indexShard.hasRefreshPending() && checkRefreshPending;
            final Object[] searchAfter = request.source().searchAfter();
        Property.Dynamic,
                SearchOperationListenerExecutor executor = new SearchOperationListenerExecutor(searchContext)
                    docIdsToLoad[docsOffset++] = topDocs.scoreDocs[i].doc;
        context.getQueryShardContext().freezeContext();
        }
                        searchContext.fetchResult().profileResults(shardResults);
        ActionListener<SearchPhaseResult> listener,
            throw new IllegalArgumentException(
    );
    // value 0 can disable dynamic pruning optimization in cardinality aggregation
        },
    }
    }
            Releasables.close(reader, readerContext, decreaseScrollContexts);
        0,
import java.util.function.Function;
            && primarySortField != null
                case CONCURRENT_SEGMENT_SEARCH_MODE_AUTO:
        Property.Dynamic,
import org.opensearch.indices.IndicesService;
            throw new IllegalArgumentException(
        assert previous == null;
import org.opensearch.index.IndexNotFoundException;
                SortField[] sort = context.sort().sort.getSort();
                    ? (Exception) exception.getCause()
     * parenting them lets per-request admission control tell a nested request from a fresh one.
    /**
                SearchOperationListenerExecutor executor = new SearchOperationListenerExecutor(searchContext)
import org.opensearch.search.aggregations.SearchContextAggregations;
            if (context.scrollContext() != null) {
                    readerContext.addOnClose(decreaseScrollContexts);
    private <T> ActionListener<T> wrapFailureListener(ActionListener<T> listener, ReaderContext context, Releasable releasable) {
 */
import org.opensearch.action.OriginalIndices;
                        + source.scriptFields().size()
        InternalScrollSearchRequest request,
        "search.max_open_scroll_context",
                    // In ASC order, if segment/shard maximum is lt search_after, the segment/shard won't be competitive
    );
            context.timeout(source.timeout());
     * a boolean clause, they will be merged into a single terms query for better performance.
            workloadGroupService
        IndexSearcher.setMaxClauseCount(INDICES_MAX_CLAUSE_COUNT_SETTING.get(settings));
     * @return the computed default slice count
    public PitReaderContext getPitReaderContext(ShardSearchContextId id) {
                    }
        ActionListener<SearchPhaseResult> listener
        if (source.sorts() != null) {
    // value == 0 means lucene slice computation will be used
            if (consolidated) {
                    + "], "
            if (getReaderContext(request.readerId()) instanceof PitReaderContext) {
        Property.Dynamic,
        private final SearchOperationListener listener;
            final Function<Query, Collection<Supplier<ProfileMetric>>> pluginProfileMetricsSupplier = (query) -> pluginProfilers.stream()
import org.apache.lucene.search.SortField;
            try (
    private SearchPhaseResult executeQueryPhase(
 * this file be licensed under the Apache-2.0 license or a
    ) throws IOException {
    }
    }
import static org.opensearch.common.unit.TimeValue.timeValueMinutes;
        long success() {
        setKeepAlives(DEFAULT_KEEPALIVE_SETTING.get(settings), MAX_KEEPALIVE_SETTING.get(settings));
        Property.NodeScope
                    request.getClusterAlias()
            assert keepStatesInContext == false;
                    fetchPhase.execute(searchContext);
     */
            freeAllContextForIndex(index);
        final Releasable markAsUsed;
    private DfsSearchResult executeDfsPhase(ShardSearchRequest request, SearchShardTask task, boolean keepStatesInContext)
    ) throws IOException {
    // settings to configure maximum slice created per search request using OS custom slice computation mechanism. Default lucene
        // is out of search_after range, it still should be printed and hence we should not skip segment/shard.
    );
            markAsUsed = readerContext.markAsUsed(getScrollKeepAlive(request.scroll()));
            context.sliceBuilder(source.slice());
            }
            if (context.size() == -1) {
        // it's fine to keep the contexts open if the index is still "alive"
        }
        Map<String, InnerHitContextBuilder> innerHitBuilders = new HashMap<>();
                afterQueryTime = executor.success();
import org.opensearch.threadpool.ThreadPool;
        Property.NodeScope
            && source.trackTotalHitsUpTo() != SearchContext.TRACK_TOTAL_HITS_ACCURATE
                final FieldDoc searchAfterFieldDoc = getSearchAfterFieldDoc(request, context);
        if (source.highlighter() != null) {
                    "Trying to retrieve too many script_fields. Must be less than or equal to: ["
                readerContext.setRescoreDocIds(searchContext.rescoreDocIds());
import org.opensearch.action.ActionRunnable;
            Releasable decreasePitContexts = openPitContexts::decrementAndGet;
            }
            final ShardSearchRequest shardSearchRequest = readerContext.getShardSearchRequest(null);
                        + maxAllowedScriptFields
/*
            int maxAllowedScriptFields = context.mapperService().getIndexSettings().getMaxScriptFields();
        final IndexService indexService = indicesService.indexServiceSafe(request.shardId().getIndex());
    public QueryRewriteContext getRewriteContext(LongSupplier nowInMillis, IndicesRequest searchRequest) {
     * Returns a new {@link QueryCoordinatorContext} with the given {@code now} provider and {@link IndicesRequest searchRequest}
        final Engine.SearcherSupplier reader = indexShard.acquireSearcherSupplier();
    /**
     * This ensures that:
                    + ") is too large. "
            }
            }
        ) {
        InternalScrollSearchRequest request,
                final long afterQueryTime = executor.success();
            context.setDerivedFieldResolver(derivedFieldResolver);
            // execution exception can happen while loading the cache, strip it
    // Partition strategy setting
    public static boolean canRewriteToMatchNone(SearchSourceBuilder source) {
            final Engine.Searcher canMatchSearcher;
                    } else {
        final List<CompletionSuggestion> completionSuggestions;
        Property.NodeScope
                context.getIndexSettings().isDerivedFieldAllowed() && allowDerivedField
                // constructor throws an exception since we would otherwise leak a searcher and this can have severe implications
        if (source == null) {
                context.scrollContext().scroll = request.scroll();
    }
        Property.Dynamic,
            success = true;
    }
            for (CompletionSuggestion.Entry.Option option : completionSuggestion.getOptions()) {
    /**
import org.opensearch.search.internal.SearchContext;
            return findReaderContext(request.readerId(), request).indexShard();
import org.opensearch.search.dfs.DfsPhase;
    private static final class SearchOperationListenerExecutor implements AutoCloseable {
import org.opensearch.search.query.QuerySearchResult;
                );
                AggregatorFactories factories = source.aggregations().build(queryShardContext, null);
import org.opensearch.search.fetch.subphase.highlight.HighlightBuilder;
            final long afterQueryTime;
     */
            DefaultSearchContext searchContext = createSearchContext(readerContext, request, timeout, validate);
import org.opensearch.cluster.ClusterState;
        boolean keepStatesInContext
                    + " should be smaller than max keep alive ["
        }
            throw e;
    private final List<SearchPlugin.ProfileMetricsProvider> pluginProfilers;
            Rewriteable.rewrite(request.getRewriteable(), context, true);
            }
            return context.dfsResult();
            } finally {
        Property.NodeScope,
            public void onFailure(Exception exc) {
            InnerHitContextBuilder.extractInnerHits(source.postFilter(), innerHitBuilders);
    );
            throw new SearchContextMissingException(id);
    @ExperimentalApi
        }, wrapFailureListener(listener, readerContext, markAsUsed));
    public static final Setting<Boolean> ALLOW_EXPENSIVE_QUERIES = Setting.boolSetting(
    private boolean isScrollContext(ReaderContext context) {
import org.opensearch.search.fetch.subphase.FetchFieldsContext;
            out.writeBoolean(canMatch);
        return activeReaders.remove(id);
        }
        }
                        PitReaderContext pitReaderContext = (PitReaderContext) context;
        this.maxOpenScrollContext = maxOpenScrollContext;
        if (defaultKeepAlive.millis() > maxKeepAlive.millis()) {
        public void writeTo(StreamOutput out) throws IOException {
            reader = null;
            && primarySortField.missing() == null
                queryShardContext.setStarTreeQueryContext(starTreeQueryContext);
            this.context = context;
        final SearchOperationListener searchOperationListener = shard.getSearchOperationListener();
            throw new IllegalArgumentException(
                clusterService.localNode().getId(),
     */
        Engine.SearcherSupplier reader = shard.acquireSearcherSupplier();
        Engine.SearcherSupplier reader,
            InnerHitContextBuilder.extractInnerHits(query, innerHitBuilders);
        if (source.minScore() != null) {
            for (int i = 0; i < topDocs.scoreDocs.length; i++) {
                }
    );
        }
        executeQueryPhase(request, keepStatesInContext, task, listener, executorName, false);
                        + "]. This limit can be set by changing the ["
                final RescoreDocIds rescoreDocIds = context.rescoreDocIds();
        if (keepAlive > maxPitKeepAlive) {
    ) {
        try {
        TimeValue keepAliveInterval = KEEPALIVE_INTERVAL_SETTING.get(settings);
        final ReaderContext readerContext = createOrGetReaderContext(request, keepStatesInContext);
                    assert orig.scroll() == null;
    public static final String CONCURRENT_SEGMENT_SEARCH_MAX_SLICE_COUNT_KEY = "search.concurrent.max_slice_count";
        doStop();
                "Default keep alive setting for request ["
    private final AtomicInteger openScrollContexts = new AtomicInteger();
    public static final Setting<String> CONCURRENT_SEGMENT_SEARCH_PARTITION_STRATEGY = Setting.simpleString(
                indexService = readerContext.indexService();
        2,  // minimum value
            context.fetchFieldsContext(fetchFieldsContext);
            completionSuggestions = Collections.emptyList();
    public CanMatchResponse canMatch(ShardSearchRequest request) throws IOException {
        clusterService.getClusterSettings()
import java.util.Set;
        this.indexSearcherExecutor = indexSearcherExecutor;
            }
import org.apache.logging.log4j.Logger;
    private final TaskResourceTrackingService taskResourceTrackingService;
            }
        Property.Dynamic,
            StarTreeQueryContext starTreeQueryContext = new StarTreeQueryContext(context, source.query());
            super.writeTo(out);
                throw new SearchException(shardTarget, "cannot use `collapse` in a scroll context");
    }
                logger.trace("Query phase failed", e);
                freeReaderContext(ctx.id());
            );
        final Releasable markAsUsed = readerContext.markAsUsed(getKeepAlive(shardSearchRequest));
        }
            );
     * Search phase result that can match a response
    public static final Setting<Boolean> KEYWORD_INDEX_OR_DOC_VALUES_ENABLED = Setting.boolSetting(
     */
        for (CompletionSuggestion completionSuggestion : completionSuggestions) {
            throw new SearchContextMissingException(id);
    private static FieldDoc getSearchAfterFieldDoc(ShardSearchRequest request, QueryShardContext context) throws IOException {
 * GitHub history for details.
                docIdsToLoad[docsOffset++] = option.getDoc().doc;
        if (keepAlive > maxKeepAlive) {
    @ExperimentalApi
                .toList();
                try (
            } catch (IOException e) {
    /**
                Optional.ofNullable(request.source()).map(SearchSourceBuilder::getDerivedFields).orElse(Collections.emptyList()),
        false,
        if (scroll != null && scroll.keepAlive() != null) {
import org.apache.lucene.search.TopDocs;
        Property.NodeScope
        Setting.Property.Dynamic
                }
        return activeReaders.get(id.getId());
     * Default keep alive search setting should be less than max PIT keep alive
        this.lowLevelCancellation = lowLevelCancellation;
            }
            public void onFailure(Exception exc) {
    private final Executor indexSearcherExecutor;
        } finally {
        return false;
                }
            if (request.scroll() != null) {
    }
     * a global aggregation is part of this request or if there is a suggest builder present.
        // can register its settings update consumer
        Integer.MAX_VALUE,
            );
                    throw new SearchException(
        }
    }
                    + " > "
    private CanMatchResponse canMatch(ShardSearchRequest request, boolean checkRefreshPending) throws IOException {
        "search.default_keep_alive",
     * has a resource cost attached to it. This setting is less than scroll since users are
            return request.keepAlive().getMillis();
    );
        assert index != null;
                readerContext.setRescoreDocIds(rescoreDocIds);
        }
            context.groupStats(source.stats());
                "Keep alive for request ("
    private final FetchPhase fetchPhase;
                searchContext.searcher().setAggregatedDfs(readerContext.getAggregatedDfs(null));
        }
            try (SearchOperationListenerExecutor executor = new SearchOperationListenerExecutor(context)) {
            context.parsedPostFilter(queryShardContext.toQuery(source.postFilter()));
import static org.opensearch.search.internal.SearchContext.TRACK_TOTAL_HITS_DISABLED;
        assert request.canReturnNullResponseIfMatchNoDocs() == false || request.numberOfShards() > 1
            if (readerContext != null) {
        Property.Dynamic,
        CONCURRENT_SEGMENT_SEARCH_MODE_AUTO,
                    canMatch = aliasFilterCanMatch && queryBuilder instanceof MatchNoneQueryBuilder == false;
                context.mapperService().getIndexSettings().getMaxDocvalueFields(),
            this.estimatedMinAndMax = estimatedMinAndMax;
        "search.concurrent_segment_search.partition_min_segment_size",
                taskResourceTrackingService.writeTaskResourceUsage(task, clusterService.localNode().getId());
     * </pre>
                    final CanMatchResponse canMatchResp;
            context.setProfilers(profilers);
            for (ReaderContext context : activeReaders.values()) {
        if (source.trackTotalHitsUpTo() != null
    public static final int DEFAULT_FROM = 0;
        }, listener::onFailure);
        Property.Dynamic
                    + TimeValue.timeValueMillis(keepAlive)
                final boolean aliasFilterCanMatch = request.getAliasFilter().getQueryBuilder() instanceof MatchNoneQueryBuilder == false;
import org.opensearch.search.searchafter.SearchAfterBuilder;
        }
                }
            if (index.equals(ctx.indexShard().shardId().getIndex())) {
    public static final Setting<Integer> AGGREGATION_REWRITE_FILTER_SEGMENT_THRESHOLD = Setting.intSetting(
import org.opensearch.search.sort.MinAndMax;
                numSuggestDocs += completionSuggestion.getOptions().size();
                            searchContext.getProfilers(),
                    throw new OpenSearchRejectedExecutionException(
                    + " should be smaller than max keep alive for PIT ["
            this(context, false, System.nanoTime());
            }
import org.opensearch.search.fetch.subphase.ScriptFieldsContext.ScriptField;
import org.apache.lucene.search.FieldDoc;
            executor.success();
                context.queryResult().setRescoreDocIds(rescoreDocIds);
            return getScrollKeepAlive(request.scroll());
                    decreaseScrollContexts = null;
                );
        "search.low_level_cancellation",
        SearchShardTask task,
                checkKeepAliveLimit(request.keepAlive().millis());
    // Make decision for concurrent search based on concurrent search deciders
        }
                    );
    }
        final ReaderContext previous = activeReaders.put(context.id().getId(), context);
                        + "] but was ["
    private final IndicesService indicesService;
        }
import java.util.HashMap;
        }
            throw exc;
            readerContext.addOnClose(() -> {
        } else {
    );
                    + TimeValue.timeValueMillis(maxPitKeepAlive)
        final IndexShard shard = getShard(request);
        ActionListener<ScrollQuerySearchResult> listener
     * check if request keep alive is greater than max keep alive
    ) throws IOException {
        Property.NodeScope
                clusterService,
 * under the License.
        }
            for (Map.Entry<String, InnerHitContextBuilder> entry : innerHitBuilders.entrySet()) {
            throw new SearchException(shardTarget, "disabling [track_total_hits] is not allowed in a scroll context");
                searchOperationListener.onNewScrollContext(finalReaderContext);
        Setting.Property.NodeScope,
            } catch (Exception e) {
                searchOperationListener.onNewPitContext(finalReaderContext);
                    }
                        listener.onFailedFetchPhase(context);
                            + "] setting."
            if (topDocs.scoreDocs.length < context.from()) {
        0,
import org.opensearch.search.fetch.ScrollQueryFetchSearchResult;
            } else {
    final SearchContext createContext(
    }
                runAsync(
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.search.profile.ProfileShardResult;
        }
        shard.awaitShardSearchActive(ignored -> {
    private final Collection<ConcurrentSearchRequestDecider.Factory> concurrentSearchDeciderFactories;
            ) {
        final IndexShard shard = indexService.getShard(shardId.id());
                        boolean success = context != null;
        500,
                return new ScrollQueryFetchSearchResult(fetchSearchResult, searchContext.shardTarget());
                            + maxOpenPitContext
        Property.NodeScope
        "search.concurrent_segment_search.partition_strategy",
            Engine.SearcherSupplier searcherSupplier = null;
                ) {
            if (request.numberOfShards() == 1) {
                return searchContext.fetchResult();
            } catch (SearchContextMissingException e) {
        return new ActionListener<T>() {
            if (context.from() > 0) {
                runAsync(getExecutor(executorName, shard), () -> executeDfsPhase(request, task, keepStatesInContext), listener);
            if (ctx instanceof PitReaderContext context) {
        },
                throw e;
        };
    private void setDefaultSearchTimeout(TimeValue defaultSearchTimeout) {
     *
        1,
        // we also do rewrite on the coordinating node (TransportSearchService) but we also need to do it here for BWC as well as
                final ReaderContext finalReaderContext = readerContext;
        ActionListener<Rewriteable> actionListener = ActionListener.wrap(r -> {
        boolean validate,
import org.opensearch.index.query.QueryRewriteContext;
                }
                SearchContext searchContext = createContext(readerContext, shardSearchRequest, task, false);
     * This method uses a lightweight searcher without wrapping (i.e., not open a full reader on frozen indices) to rewrite the query
 */
            try {
            return canMatch;
        public void run() {
        final IndexShard indexShard = indexService.getShard(request.shardId().getId());
            );
import org.opensearch.search.sort.FieldSortBuilder;
                QueryShardContext context = indexService.newQueryShardContext(
                    pipelineTree
            }
        }
        SearchShardTask task,
        Property.NodeScope
    public static final String CONCURRENT_SEGMENT_SEARCH_PARTITION_STRATEGY_FORCE = "force";
            freeReaderContext(readerContext.id());
                    request.shardId().id(),
            updatePit = readerContext.updatePitIdAndKeepAlive(request.getKeepAlive(), request.getPitId(), request.getCreationTime());
        if (source.postFilter() != null) {
        } finally {
                MinAndMax<?> minMax = sortBuilder != null ? FieldSortBuilder.getMinMaxOrNull(context, sortBuilder) : null;
            boolean consolidated = starTreeQueryContext.consolidateAllFilters(context);
        Property.NodeScope
            context.close();
                return context != null;
import org.opensearch.search.profile.SearchProfileShardResults;
import org.opensearch.search.startree.StarTreeQueryContext;
            .addSettingsUpdateConsumer(
            } catch (IOException e) {
                        listener.onFetchPhase(context, afterQueryTime - time);
            context.docValuesContext(docValuesContext);
                    if (finalReaderContext.scrollContext() != null) {
        clusterService.getClusterSettings().addSettingsUpdateConsumer(DEFAULT_SEARCH_TIMEOUT_SETTING, this::setDefaultSearchTimeout);
        }
        throws IOException {
    private volatile long defaultKeepAlive;
    );
import org.opensearch.common.annotation.ExperimentalApi;
        final ReaderContext readerContext = request.readerId() != null ? findReaderContext(request.readerId(), request) : null;
        ActionListener<SearchPhaseResult> listener,
            context.evaluateRequestShouldUseIntraSegmentSearch();
        executeQueryPhase(request, keepStatesInContext, task, listener, null);
    public static final String CONCURRENT_SEGMENT_SEARCH_MODE_AUTO = "auto";
                }
            if (updatePit != null) {
        }
                Optional.ofNullable(request.source()).map(SearchSourceBuilder::getDerivedFieldsObject).orElse(Collections.emptyMap()),
    }
                throw new AggregationInitializationException("Failed to create aggregators", e);
                );
            // We need to release the reader context of the scroll when we hit any exception (here the keep_alive can be too large)
            }
                } else {
                if (getReaderContext(contextId.getSearchContextIdForNode().getSearchContextId()) != null) {
                // Pass the rescoreDocIds to the queryResult to send them the coordinating node and receive them back in the fetch phase.
    );
    ) {
            checkKeepAliveLimit(scroll.keepAlive().millis());
                    + ")"
                    + "). "
                } catch (IOException e) {
                // fork the execution in the search thread pool
    );
                if (openScrollContexts.incrementAndGet() > maxOpenScrollContext) {
    }
import java.util.Optional;
            }
    public static final Setting<Boolean> DEFAULT_ALLOW_PARTIAL_SEARCH_RESULTS = Setting.boolSetting(
                freeReaderContext(readerContext.id());
    private final Cancellable keepAliveReaper;
 * not use this file except in compliance with the License.
            for (CompletionSuggestion completionSuggestion : completionSuggestions) {
            if (source.scriptFields().size() > maxAllowedScriptFields) {
        for (PitSearchContextIdForNode contextId : contextIds) {
                    searchOperationListener.onFreeReaderContext(finalReaderContext);
     */
            final Optional<SortAndFormats> sortOpt = SortBuilder.buildSort(sorts, context);
import org.opensearch.search.sort.SortOrder;
    private final ResponseCollectorService responseCollectorService;
                searcherSupplier = null; // transfer ownership to reader context
     */
            }
                default:
            // pre process
        WorkloadGroupService workloadGroupService
        this.fetchPhase = fetchPhase;
                    + "] cluster level setting."
                if (context.sourceRequested()) {
    private IndexShard getShard(ShardSearchRequest request) {
    ) {
                if (minMax.compareMin(searchAfterPrimary) > 0) {
     * Computes the default maximum number of slices for concurrent segment search.
        0,
            if (success == false) {
     * <ul>
                context.addSearchExt(searchExtBuilder);
            }
    }
        } finally {
        }
                // now we need to check if there is a pending refresh and register
        } finally {
import java.util.List;
    }
        assert indexShard != null;
        boolean keepStatesInContext,
    /**
            logger.warn("failed to process shard failure to (potentially) send back shard failure on corruption", inner);
     * Free reader contexts if found
        }
    }
                request,
        if (reason == IndexRemovalReason.DELETED || reason == IndexRemovalReason.CLOSED || reason == IndexRemovalReason.REOPENED) {
    );
    public IndicesService getIndicesService() {
     * This setting will help validate the max keep alive that can be set during creation or extension for a PIT reader context
    }
        this.defaultKeepAlive = defaultKeepAlive.millis();
    }
import org.opensearch.index.query.MatchNoneQueryBuilder;
                final Integer trackTotalHitsUpto = request.source() == null ? null : request.source().trackTotalHitsUpTo();
            readerContext = null;
    private long getScrollKeepAlive(Scroll scroll) {
                            + "This limit can be set by changing the ["
import org.apache.lucene.search.Query;
        // if we then close all the contexts we can get some search failures along the way which are not expected.
        return null;
    // value 0 means rewrite filters optimization in aggregations will be disabled
import java.util.Objects;
                Releasables.closeWhileHandlingException(searcherSupplier, readerContext);
/*
                queryPhase.execute(searchContext);
                context.from(DEFAULT_FROM);
    @Override
    }
            if (closed == false) {
            processFailure(readerContext, exception);
            throw e;
import org.opensearch.action.support.TransportActions;
import org.opensearch.search.lookup.SearchLookup;
    }
                    executor.success();
                throw new SearchException(shardTarget, "`search_after` cannot be used in a scroll context.");
            } else {
    public static final int DEFAULT_SIZE = 10;
                return new ScrollQuerySearchResult(searchContext.queryResult(), searchContext.shardTarget());
    public static final Setting<TimeValue> DEFAULT_KEEPALIVE_SETTING = Setting.positiveTimeSetting(
        IndexShard shard,
        final IndexService indexService = indicesService.indexServiceSafe(shardId.getIndex());
            }
    );
        NO_TIMEOUT,
                context.setStreamChannelListener((StreamSearchChannelListener<SearchPhaseResult, ShardSearchRequest>) listener);
                case CONCURRENT_SEGMENT_SEARCH_MODE_ALL:
            ) {
     * This method returns all active PIT reader contexts
        TimeValue timeout,
import java.util.concurrent.Executor;
                    + maxPitKeepAlive
        } catch (Exception e) {
        Integer trackTotalHitsUpto
        }
                            + maxOpenScrollContext
        }, wrapFailureListener(listener, readerContext, markAsUsed));
 * KIND, either express or implied.  See the License for the
        Property.NodeScope
     * Returns the number of active contexts in this
        this.multiBucketConsumerService = new MultiBucketConsumerService(
                }
        executeDfsPhase(request, keepStatesInContext, task, listener, null);
        try {
    }
 * ownership. Elasticsearch licenses this file to you under
            Profilers profilers = new Profilers(context.searcher(), context.shouldUseConcurrentSearch(), pluginProfileMetricsSupplier);
 *
            );
                readerContext.addOnClose(() -> {
            public void onFailure(Exception exc) {
        validateKeepAlives(defaultKeepAlive, maxKeepAlive);
        this.defaultSearchTimeout = defaultSearchTimeout;
        final ReaderContext reader = getReaderContext(id);
        // Skipping search on shard/segment entirely can cause mismatch on total_tracking_hits, hence skip only if
 * specific language governing permissions and limitations
    ) {
                        searchOperationListener.onFreeScrollContext(finalReaderContext);
        if (source.fetchFields() != null) {
            super(in);
        Property.Dynamic
import org.opensearch.search.aggregations.pipeline.PipelineAggregator.PipelineTree;
        SearchShardTask task,
        Property.Dynamic,
    public QueryRewriteContext getRewriteContext(LongSupplier nowInMillis, IndicesRequest searchRequest, TaskId parentTaskId) {
        Property.NodeScope
    }
import org.opensearch.core.concurrency.OpenSearchRejectedExecutionException;
        value -> {
import org.opensearch.common.lucene.Lucene;
            try {
                            + MAX_OPEN_PIT_CONTEXT.getKey()
            return;
            throw exception;
                listener.onPreQueryPhase(context);
import org.opensearch.search.fetch.subphase.FetchDocValuesContext;
            context.fetchSourceContext(source.fetchSource());
 * The main search service
        clusterService.getClusterSettings()
                    searchOperationListener.onFreeReaderContext(finalReaderContext);
import org.opensearch.index.IndexSettings;
                closed = true;
import org.opensearch.search.internal.InternalScrollSearchRequest;
/*
            }
            } catch (Exception exc) {
                assert listener instanceof StreamSearchChannelListener : "Stream search expects StreamSearchChannelListener";
        context.terminateAfter(source.terminateAfter());
    public static final Setting<Integer> MAX_OPEN_PIT_CONTEXT = Setting.intSetting(
import org.opensearch.action.IndicesRequest;
    public static final Setting<Integer> SEARCH_MAX_QUERY_STRING_LENGTH = Setting.intSetting(
import org.opensearch.search.aggregations.AggregatorFactories;
                    + "] cluster level setting."
                    + defaultKeepAlive
        ) {
            try {
            switch (value) {
        SearchOperationListenerExecutor(SearchContext context) {
        }
                    SearchOperationListenerExecutor executor = new SearchOperationListenerExecutor(searchContext, true, System.nanoTime())
        }
     *   <li>On small machines, it avoids over-threading.</li>
        SearchShardTask task,
        final ShardSearchRequest shardSearchRequest = readerContext.getShardSearchRequest(request.shardSearchRequest());
    public ResponseCollectorService getResponseCollectorService() {
                "Keep alive for request ("
import org.opensearch.action.search.SearchType;
            processFailure(readerContext, e);
        "search.default_search_timeout",
            }
import java.util.function.LongSupplier;
            && minMax != null
        try {
            return indicesService.indexServiceSafe(request.shardId().getIndex()).getShard(request.shardId().id());
                // we handle the case where `IndicesService#indexServiceSafe`or `IndexService#getShard`, or the DefaultSearchContext
        private final boolean canMatch;
                    + "]"
        context.evaluateRequestShouldUseConcurrentSearch();
            final ShardSearchRequest shardSearchRequest = readerContext.getShardSearchRequest(null);
        checkPitKeepAliveLimit(request.getKeepAlive());
import org.opensearch.index.query.QueryCoordinatorContext;
            } finally {
                    + "This limit can be set by changing the ["
        Settings settings = clusterService.getSettings();
        PitReaderContext readerContext = getPitReaderContext(request.getSearchContextId());
                ProfileShardResult shardResults = SearchProfileShardResults.buildShardResults(context.getProfilers(), context.request());
            }
                    request::nowInMillis,
    private void rewriteAndFetchShardRequest(IndexShard shard, ShardSearchRequest request, ActionListener<ShardSearchRequest> listener) {
        if (request.readerId() != null) {
        Integer.MAX_VALUE,
    );
        0L,
        boolean keepStatesInContext,
            Exception exception = e;
 *
                        shardTarget,
    private void setMaxOpenPitContext(int maxOpenPitContext) {
        }
            }
        defaultSearchTimeout = DEFAULT_SEARCH_TIMEOUT_SETTING.get(settings);
            public void onResponse(ShardSearchRequest rewritten) {
                );
    }
        if (canCache) {
                searchContext.queryResult().setRescoreDocIds(rescoreDocIds);
    public void executeFetchPhase(
        false,
        "search.query.max_query_string_length",
        if (context.singleSession() || isScrollContext(context)) {
        1,
import org.opensearch.core.indices.breaker.CircuitBreakerService;
                        listener.onQueryPhase(context, afterQueryTime - time);
import org.opensearch.node.ResponseCollectorService;
     * builder retains a reference to the provided {@link SearchSourceBuilder}.
            logger.trace("Dfs phase failed", e);
    private void shortcutDocIdsToLoad(SearchContext context) {
                this::validatePitKeepAlives
                SearchLookup lookup = context.getQueryShardContext().lookup();
    public static final TimeValue NO_TIMEOUT = timeValueMillis(-1);
    public SearchService(
            ) {
        if (readerContext == null) {
            Releasable ignored = readerContext.markAsUsed(getKeepAlive(request));
            }
        SearchShardTask task,
    protected void doClose() {
            try (ReaderContext context = removeReaderContext(contextId.getId())) {
/**
                        "collapse field and sort field must be the same when use `collapse` in conjunction with `search_after`"
        } finally {
            }
            @Override
        boolean keepStatesInContext,
import org.opensearch.search.deciders.ConcurrentSearchRequestDecider;
    public static final Setting<Boolean> CLUSTER_ALLOW_DERIVED_FIELD_SETTING = Setting.boolSetting(
        }
        }
import org.opensearch.action.search.DeletePitResponse;
import org.opensearch.search.query.QueryPhase;
    private static PipelineTree requestToPipelineTree(SearchSourceBuilder searchSourceBuilder) {
        if (suggest != null && suggest.hasScoreDocs()) {
            switch (value) {
     * encouraged to share the PIT details.
            final List<SortBuilder<?>> sorts = request.source().sorts();
    /**
                source.docValueFields()
            freeReaderContext(context.id());
            parseSource(context, request.source(), includeAggregations);
        } catch (Exception e) {
                        freeReaderContext(request.contextId());
        String executorName,
                        return;
                pitContextsInfo.add(pitInfo);
     * Returns a new {@link QueryCoordinatorContext} with the given {@code now} provider and {@link IndicesRequest searchRequest}
        if (defaultKeepAlive.millis() > maxPitKeepAlive.millis()) {
        int docsOffset = 0;
            }
            @Override
                    // For search context missing cases, mark the operation as succeeded
        lowLevelCancellation = LOW_LEVEL_CANCELLATION_SETTING.get(settings);
            .addSettingsUpdateConsumer(DEFAULT_ALLOW_PARTIAL_SEARCH_RESULTS, this::setDefaultAllowPartialSearchResults);
        }
import org.opensearch.common.lease.Releasables;
                    + TimeValue.timeValueMillis(maxKeepAlive)
                    + "], "
        "search.keep_alive_interval",
            this.listener = context.indexShard().getSearchOperationListener();
        ThreadPool threadPool,
        return new QueryCoordinatorContext(indicesService.getValidationRewriteContext(nowInMillis), searchRequest);
import org.opensearch.search.aggregations.InternalAggregation;
            context.parsedQuery(queryShardContext.toQuery(query));
 * this work for additional information regarding copyright
import org.opensearch.common.settings.Setting;
    private ReaderContext getReaderContext(ShardSearchContextId id) {
        ReaderContext readerContext,
                this::setPitKeepAlives,
        QueryPhase queryPhase,
    private DefaultSearchContext createSearchContext(
    public static final Setting<Integer> MAX_AGGREGATION_REWRITE_FILTERS = Setting.intSetting(
        // unfortunately we don't have a clear way to signal today why an index is closed.
        assert request.searchType() == SearchType.QUERY_THEN_FETCH : "unexpected search type: " + request.searchType();
        SearchShardTask task,
            SearchShardTarget shardTarget = new SearchShardTarget(
                }
package org.opensearch.search;
                searchContext.assignRescoreDocIds(readerContext.getRescoreDocIds(request.getRescoreDocIds()));
            QueryBuilder query = source.query();
import org.opensearch.search.query.QueryRewriterRegistry;
    /**
                }
     */
        if (source.trackTotalHitsUpTo() != null) {
            final CollapseContext collapseContext = source.collapse().build(queryShardContext);
import org.apache.logging.log4j.LogManager;
    }
        value -> {
        }
            this.fetch = fetch;
        if (request.readerId() != null) {
import java.util.Collection;
        boolean keepStatesInContext,
                listener.onFailure(exc);
        if (reader == null) {
                        ShardSearchRequest clone = new ShardSearchRequest(orig);
        public boolean canMatch() {
        Property.Dynamic,
        if (searchAfter != null
import org.opensearch.action.support.StreamSearchChannelListener;
            } catch (Exception e) {
    protected void putReaderContext(ReaderContext context) {
    }
        return createContext(readerContext, request, task, includeAggregations, false);
        boolean keepStatesInContext,
    public int getActiveContexts() {
        List<SearchPlugin.ProfileMetricsProvider> pluginProfilers,
            assert searchContext.getQueryShardContext().isCacheable();
            }
                    canMatchSearcher,
                searchContext.docIdsToLoad(request.docIds(), 0, request.docIdsSize());
    public static final String CONCURRENT_SEGMENT_SEARCH_MODE_NONE = "none";
        }
     */
            }
    // Partition strategy constants
    ) {
        Property.Dynamic,
                    + MAX_KEEPALIVE_SETTING.getKey()
        boolean isStreamSearch
                Releasables.close(releasable);
import org.opensearch.search.internal.PitReaderContext;
        return indicesService.buildAliasFilter(state, index, resolvedExpressions);
                    searchContext.scrollContext().lastEmittedDoc = request.lastEmittedDoc();
        }
            @Override
        try (ReaderContext readerContext = new ReaderContext(id, indexService, indexShard, reader, -1L, true)) {
import org.opensearch.plugins.SearchPlugin;
        "search.query_rewriting.terms_threshold",
import org.opensearch.search.sort.SortBuilder;
    }
            throw new SearchContextMissingException(request.getSearchContextId());
        this.allowDerivedField = allowDerivedField;
            dfsPhase.execute(context);
    public void executeQueryPhase(
        public CanMatchResponse(boolean canMatch, MinAndMax<?> estimatedMinAndMax) {
                    bigArrays,
                if (openPitContexts.incrementAndGet() > maxOpenPitContext) {
        final ReaderContext readerContext = findReaderContext(request.contextId(), request);
        private boolean closed = false;
                    logger.debug("freeing search context [{}]", context.id());
        0,
            freeReaderContext(context.id());
                MAX_PIT_KEEPALIVE_SETTING,
    private SearchContext createContext(
            final boolean hasRefreshPending;
    }
            @Override
            completionSuggestions = suggest.filter(CompletionSuggestion.class);
import org.opensearch.search.builder.SearchSourceBuilder;
                        );
    ) {
    }
        } catch (IOException e) {
        for (ReaderContext ctx : activeReaders.values()) {
            }
        allowDerivedField = CLUSTER_ALLOW_DERIVED_FIELD_SETTING.get(settings);
                    canMatch = aliasFilterCanMatch;
        if (context != null && request != null && request.source() != null && request.source().sorts() != null) {
                    throw new SearchException(shardTarget, "[stored_fields] cannot be disabled if [_source] is requested");
            }
        runAsync(getExecutor(null, readerContext.indexShard()), () -> {
                    QueryBuilder queryBuilder = request.source().query();
            searchOperationListener.onNewReaderContext(finalReaderContext);
                docIdsToLoad = new int[Math.min(topDocs.scoreDocs.length - context.from(), context.size()) + numSuggestDocs];
        context.from(source.from());
    );
        // AliasFilters that might need to be rewritten. These are edge-cases but we are every efficient doing the rewrite here so it's not
        ActionListener<SearchPhaseResult> listener
    public void executeFetchPhase(
    );
import org.opensearch.script.ScriptService;
                        DeletePitInfo deletePitInfo = new DeletePitInfo(success, pitId);
        clusterService.getClusterSettings().addSettingsUpdateConsumer(MAX_OPEN_SCROLL_CONTEXT, this::setMaxOpenScrollContext);
                return new CanMatchResponse(canMatch || hasRefreshPending, minMax);
    private volatile boolean defaultAllowPartialSearchResults;
        this.indicesService = indicesService;
                    if (readerContext.singleSession()) {
            final IndexService indexService;
     * Try to load the query results from the cache or execute the query phase directly if the cache cannot be used.
                if (orig.canReturnNullResponseIfMatchNoDocs()) {
     */
}
            context.trackTotalHitsUpTo(source.trackTotalHitsUpTo());
    public static final Setting<Integer> QUERY_REWRITING_TERMS_THRESHOLD_SETTING = Setting.intSetting(
            // we release the reader on failure if the request is a normal search or a scroll
import org.apache.lucene.search.IndexSearcher;
                try {
        boolean includeAggregations
import org.opensearch.common.util.concurrent.ConcurrentCollections;
                canMatch = canMatch && canMatchSearchAfter(searchAfterFieldDoc, minMax, sortBuilder, trackTotalHitsUpto);
    public static final Setting<Integer> CARDINALITY_AGGREGATION_PRUNING_THRESHOLD = Setting.intSetting(
            @Override
                lowLevelCancellation,
            SearchContext context = createContext(readerContext, request, task, true)
import org.opensearch.search.internal.ShardSearchRequest;
    }
                }
    public static final int CONCURRENT_SEGMENT_SEARCH_DEFAULT_SLICE_COUNT_VALUE = computeDefaultSliceCount();
import org.opensearch.threadpool.ThreadPool.Names;
 *
            );
                timeout,
 * The OpenSearch Contributors require contributions made to
            }
                context.queryResult().profileResults(shardResults);
    final ReaderContext createAndPutReaderContext(
            inner.addSuppressed(exc);
                            + "]. "
                PipelineTree pipelineTree = requestToPipelineTree(searchSourceBuilder);
            }
                Releasables.close(releasable);
     * Enables low-level, frequent search cancellation checks. Enabling low-level checks will make long running searches to react
import org.opensearch.search.startree.StarTreeQueryHelper;
import org.opensearch.common.unit.TimeValue;
                validate,
                    + "This limit can be set by changing the ["
        clusterService.getClusterSettings()
            }
            listener.onResponse(new UpdatePitContextResponse(request.getPitId(), request.getCreationTime(), request.getKeepAlive()));
    );
import org.opensearch.index.query.Rewriteable;
                    deleteResults.add(deletePitInfo);
            }
    private volatile TimeValue defaultSearchTimeout;
                throw e;
                throw new SearchException(shardTarget, "cannot use `collapse` in conjunction with `rescore`");
            fetchPhase.execute(context);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            if (context.getProfilers() != null) {
    /**
            public InternalAggregation.ReduceContext forPartialReduction() {
                } finally {
            for (SearchExtBuilder searchExtBuilder : source.ext()) {
        FieldDoc searchAfter,
    public void executeDfsPhase(
                throw e;
            if (finalReaderContext.scrollContext() != null) {
                queryPhase.execute(searchContext);
        runAsync(getExecutor(null, readerContext.indexShard()), () -> {
import org.opensearch.core.action.ActionListener;
        boolean isStreamSearch
    }
                return executeFetchPhase(readerContext, context, afterQueryTime);
        context.size(source.size());
     */
    /**
                hasRefreshPending = false;
                throw new SearchException(shardTarget, "failed to create SearchContextHighlighter", e);
            freeReaderContext(readerContext.id());
import org.opensearch.index.IndexService;
        "indices.query.bool.max_clause_count",
    }
                    + MAX_KEEPALIVE_SETTING.getKey()
                    break;
        this.queryPhase = queryPhase;
        this.defaultAllowPartialSearchResults = defaultAllowPartialSearchResults;
        }
    }
                    // valid setting
            context.collapse(collapseContext);
        }
    }
    private void validateKeepAlives(TimeValue defaultKeepAlive, TimeValue maxKeepAlive) {
     */
     * to the cancellation request faster. It will produce more cancellation checks but benchmarking has shown these did not
            QueryShardContext context = new QueryShardContext(searchContext.getQueryShardContext());
        this.maxKeepAlive = maxKeepAlive.millis();
            }
            final ReaderContext finalReaderContext = readerContext;
    }
        if (source.ext() != null) {
        Setting.Property.Dynamic
                // no more docs...
            FieldDoc fieldDoc = SearchAfterBuilder.buildFieldDoc(context.sort(), source.searchAfter());
        for (final ReaderContext context : activeReaders.values()) {
            // might end up with incorrect state since we are using now() or script services
            }
    private final AtomicLong idGenerator = new AtomicLong();
        }
import org.opensearch.search.fetch.FetchSearchResult;
 * the Apache License, Version 2.0 (the "License"); you may
        }
     * This default is used when the user does not explicitly set the
    /**
            }
                throw new SearchException(shardTarget, "`slice` cannot be used outside of a scroll context or PIT context");
        setPitKeepAlives(DEFAULT_KEEPALIVE_SETTING.get(settings), MAX_PIT_KEEPALIVE_SETTING.get(settings));
    public static final Setting<Integer> SEARCH_MAX_QUERY_NESTING_DEPTH = Setting.intSetting(
    public static final int CONCURRENT_SEGMENT_SEARCH_MIN_SLICE_COUNT_VALUE = 0;
import org.opensearch.search.sort.SortAndFormats;
    private volatile int maxOpenPitContext;
        Property.NodeScope
     * This is crucial for some implementations like {@link org.opensearch.index.search.stats.ShardSearchStats}.
        FetchPhase fetchPhase,
        runAsync(getExecutor(null, readerContext.indexShard()), () -> {
 * software distributed under the License is distributed on an
                loadOrExecuteQueryPhase(request, context);
import java.util.Map;
        final Releasable markAsUsed;
import org.opensearch.core.tasks.TaskId;
        ShardSearchRequest request,
                    );
        this.keepAliveReaper = threadPool.scheduleWithFixedDelay(new Reaper(), keepAliveInterval, Names.SAME);
        } else {
        context.docIdsToLoad(docIdsToLoad, 0, docIdsToLoad.length);
                indexSearcherExecutor,
        this.concurrentSearchDeciderFactories = concurrentSearchDeciderFactories;
        return new QueryCoordinatorContext(indicesService.getRewriteContext(nowInMillis, parentTaskId), searchRequest);
                });
        }
        if (source.collapse() != null) {
            if (source.storedFields().fetchFields() == false) {
            } else {
        }
    }
                readerContext = new LegacyReaderContext(id, indexService, shard, reader, request, keepAlive);
                        "Trying to create too many scroll contexts. Must be less than or equal to: ["
            : "empty responses require more than one shard";
    );
        16,
        }
    public static final Setting<TimeValue> KEEPALIVE_INTERVAL_SETTING = Setting.positiveTimeSetting(
            Releasable ignored = readerContext.markAsUsed(getKeepAlive(request));
    public void executeDfsPhase(
    }
        final ReaderContext readerContext = findReaderContext(request.contextId(), request.shardSearchRequest());
    public static final Setting<Integer> CONCURRENT_SEGMENT_SEARCH_TARGET_MAX_SLICE_COUNT_SETTING = Setting.intSetting(
            }
    /**
 * Modifications Copyright OpenSearch Contributors. See
            try (
                listener.onFailure(exc);
        Property.NodeScope,
    private final MultiBucketConsumerService multiBucketConsumerService;
                    }
                .flatMap(p -> p.getQueryProfileMetrics(context, query).stream())
            if (Lucene.isCorruptionException(exc)) {
        }, wrapFailureListener(listener, readerContext, markAsUsed));
            try {
            return scroll.keepAlive().getMillis();
    }
        SearchShardTask task,
                }
    private final ClusterService clusterService;
import org.opensearch.index.query.InnerHitContextBuilder;
            putReaderContext(finalReaderContext);
                fetchPhase,
                optionalSort.ifPresent(context::sort);
                searchContext.getQueryShardContext(),
        IndexShard shard = indexService.getShard(request.shardId().id());
     * <p>
            return searchContext;
     * @opensearch.internal
        clusterService.getClusterSettings().addSettingsUpdateConsumer(CLUSTER_ALLOW_DERIVED_FIELD_SETTING, this::setAllowDerivedField);
        try (
            }
        if (source.profile()) {
 */
        SearchOperationListenerExecutor(SearchContext context, boolean fetch, long startTime) {
                readerContext = new PitReaderContext(id, indexService, shard, searcherSupplier, keepAlive.millis(), false);
            } finally {
            return afterQueryTime = System.nanoTime();
            context.storedFieldsContext(source.storedFields());
        context.from(context.from() + context.size());
                context.size(DEFAULT_SIZE);
        try {
    public boolean freeReaderContext(ShardSearchContextId contextId) {
        CircuitBreakerService circuitBreakerService,
        if (searchSourceBuilder == null || searchSourceBuilder.aggregations() == null) {
    ) {
        });
        "search.aggregations.terms.max_precompute_cardinality",
            final long keepAlive = getKeepAlive(request);
            } catch (IOException e) {
    protected ReaderContext removeReaderContext(long id) {
import org.opensearch.action.search.UpdatePitContextRequest;
                        ProfileShardResult shardResults = SearchProfileShardResults.buildFetchOnlyShardResults(
import org.opensearch.action.search.UpdatePitContextResponse;
                searchContext.searcher().setAggregatedDfs(request.dfs());
        return createSearchContext(reader, request, timeout, validate, false);
                throw new SearchException(shardTarget, "`from` parameter must be set to 0 when `search_after` is used.");
        // to release memory and let references to the filesystem go etc.
        "search.aggregation_rewrite_filters.segment_threshold.docs_per_bucket",
    }
            }
                // (unable to obtain shard lock exceptions).
        ShardSearchRequest request,
            if (exception instanceof ExecutionException) {
                if (afterQueryTime != -1) {
            shortcutDocIdsToLoad(context);
                checkPitKeepAliveLimit(request.keepAlive().millis());
        }
        1,
        Property.Dynamic,
        return this.activeReaders.size();
                context.mapperService()::simpleMatchToFullName,
                docIdsToLoad = new int[numSuggestDocs];
     * {@code search.concurrent.max_slice_count} cluster setting.
                        listener.onResponse(QuerySearchResult.nullInstance());
        @Override
        "search.max_aggregation_rewrite_filters",
                try {
import org.opensearch.search.aggregations.InternalAggregation.ReduceContext;
            ReaderContext readerContext = null;
        } else {
    );
        30_000L,
import org.opensearch.index.query.QueryBuilder;
import org.opensearch.action.search.ListPitInfo;
            }
    private void processFailure(ReaderContext context, Exception exc) {
        Integer.MAX_VALUE,
        Property.Dynamic,
                    return false;
                clusterService.state().nodes().getMinNodeVersion(),
import org.opensearch.search.fetch.ShardFetchRequest;
    }
                if (context.fetchFieldsContext() != null) {
            this.estimatedMinAndMax = in.readOptionalWriteable(MinAndMax::new);
    }
            searchContext.addReleasable(readerContext.markAsUsed(0L));
    ) {
        }
                    getExecutor(executorName, shard),
                bigArrays,
    );
    // mechanism will not be used if this setting is set with value > 0
    public static final String CONCURRENT_SEGMENT_SEARCH_PARTITION_STRATEGY_BALANCED = "balanced";
        "search.aggregation.bucket_selection_strategy_factor",
        ReaderContext readerContext = null;
        try (SearchOperationListenerExecutor executor = new SearchOperationListenerExecutor(context, true, afterQueryTime)) {
     * Opens the reader context for given shardId. The newly opened reader context will be keep
                throw new SearchException(shardTarget, "failed to create sort elements", e);
                        deleteResults.add(deletePitInfo);
            if (context.from() == -1) {
    private volatile long maxPitKeepAlive;
                shard.awaitShardSearchActive(b -> listener.onResponse(request));
        "search.query_rewriting.enabled",
        return this.responseCollectorService;
            try (
            assert closed == false : "already closed - while technically ok double closing is a likely a bug in this case";
    /**
        List<DeletePitInfo> deleteResults = new ArrayList<>();
        ActionListener<SearchPhaseResult> listener
    @Override
        10,
                // For search context missing cases, mark the operation as succeeded
        "point_in_time.max_keep_alive",
    // Minimum segment size for balanced partitioning (only applies when partition_strategy = balanced)
        ShardFetchRequest request,
        }
        Property.Dynamic
        // ensure that if we race against afterIndexRemoved, we remove the context from the active list.
import org.opensearch.search.profile.ProfileMetric;
     * </ul>
            throw new IndexNotFoundException(index);
        boolean success = false;
        200,
    private void setMaxOpenScrollContext(int maxOpenScrollContext) {
        }
    private final ScriptService scriptService;
                return InternalAggregation.ReduceContext.forFinalReduction(
        }
            try {
                    + defaultKeepAlive
            taskResourceTrackingService.writeTaskResourceUsage(task, clusterService.localNode().getId());
            taskResourceTrackingService.writeTaskResourceUsage(task, clusterService.localNode().getId());
        ShardSearchRequest request,
        Property.NodeScope,
        this.pluginProfilers = pluginProfilers;
import org.opensearch.transport.TransportRequest;
     * Shortcut ids to load, we load only "from" and up to "size". The phase controller
        } catch (Exception e) {
        Property.Dynamic,
    ) {
        QueryStringQueryParser.setMaxQueryStringLengthMonitorMode(SEARCH_MAX_QUERY_STRING_LENGTH_MONITOR_ONLY.get(settings));
            if (sortOpt.isPresent() && !CollectionUtils.isEmpty(searchAfter)) {
            // if the from and size are still not set, default them
        clusterService.getClusterSettings().addSettingsUpdateConsumer(LOW_LEVEL_CANCELLATION_SETTING, this::setLowLevelCancellation);
        SearchShardTask task,
                this::aggReduceContextBuilder,
        Property.NodeScope
                        + IndexSettings.MAX_SCRIPT_FIELDS_SETTING.getKey()
 *    http://www.apache.org/licenses/LICENSE-2.0
        ShardSearchRequest request,
        if (indexShard.isSystem()) {
        CONCURRENT_SEGMENT_SEARCH_PARTITION_STRATEGY_BALANCED,
        clusterService.getClusterSettings()
        final List<ListPitInfo> pitContextsInfo = new ArrayList<>();
        300,
            final SearchOperationListener searchOperationListener = shard.getSearchOperationListener();
                }
            context.evaluateRequestShouldUseConcurrentSearch();
    private volatile boolean allowDerivedField;
                // we handle the failure in the failure listener below
                    () -> requestToPipelineTree(searchSourceBuilder)
        return createAndPutReaderContext(request, indexService, shard, reader, keepStatesInContext);
        Setting.Property.Dynamic
        clusterService.getClusterSettings()
            }
import org.opensearch.search.rescore.RescorerBuilder;
                updatePit.close();
    private void loadOrExecuteQueryPhase(final ShardSearchRequest request, final SearchContext context) throws Exception {
                if (searchContext.queryResult().hasSearchContext() == false && readerContext.singleSession()) {
        ShardSearchRequest request,
                queryPhase.execute(searchContext);
                case CONCURRENT_SEGMENT_SEARCH_PARTITION_STRATEGY_SEGMENT:
            context.setKeywordFieldIndexOrDocValuesEnabled(searchContext.keywordIndexOrDocValuesEnabled());
                    }
        timeValueMinutes(5),
        ShardSearchRequest request,
        int numSuggestDocs = 0;
     */
        @Override
        checkPitKeepAliveLimit(keepAlive.millis());
        Property.NodeScope,
            );
                default:
            out.writeOptionalWriteable(estimatedMinAndMax);
    public static final Setting<Boolean> CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING = Setting.boolSetting(
     * Returns a new {@link QueryCoordinatorContext} whose async rewrite actions issue their requests as children of
            this.canMatch = in.readBoolean();
        this.clusterService = clusterService;
    public static final String CONCURRENT_SEGMENT_SEARCH_PARTITION_STRATEGY_SEGMENT = "segment";
                threadPool::relativeTimeInMillis,
            }
import org.opensearch.tasks.TaskResourceTrackingService;
            // we clone the query shard context here just for rewriting otherwise we
                    entry.getValue().build(context, context.innerHits());
    public List<ListPitInfo> getAllPITReaderContexts() {
            if (context.rescore() != null && context.rescore().isEmpty() == false) {
        } catch (Exception e) {
    public static final Setting<TimeValue> MAX_KEEPALIVE_SETTING = Setting.positiveTimeSetting(
        String executorName
            } catch (Exception e) {
        public MinAndMax<?> estimatedMinAndMax() {
                shardTarget,
                // fork the execution in the search thread pool
    protected void doStop() {
        context.trackScores(source.trackScores());
        this.maxOpenPitContext = maxOpenPitContext;
    private void setPitKeepAlives(TimeValue defaultKeepAlive, TimeValue maxPitKeepAlive) {
        keepAliveReaper.cancel();
    }
            }
        FieldSortBuilder primarySortField,
                return context.queryResult();
        Property.Dynamic
                        canMatchResp = canMatch(clone, false);
    /**
                FieldScript.LeafFactory searchScript = factory.newFactory(field.script().getParams(), lookup);
                docIdsToLoad[docsOffset++] = topDocs.scoreDocs[i].doc;
    public void executeFetchPhase(ShardFetchRequest request, SearchShardTask task, ActionListener<FetchSearchResult> listener) {
        public CanMatchResponse(StreamInput in) throws IOException {
    }
                    + "was ("
    }
    private static int computeDefaultSliceCount() {
        private final boolean fetch;
                            + MAX_OPEN_SCROLL_CONTEXT.getKey()
                searchContext.searcher().setAggregatedDfs(readerContext.getAggregatedDfs(null));
                }
        }
    }
    }
        timeValueMinutes(1),
            if (context.scrollContext() == null && !(context.readerContext() instanceof PitReaderContext)) {
        ReaderContext reader,
                processScroll(request, readerContext, searchContext);
            }
        final LegacyReaderContext readerContext = (LegacyReaderContext) findReaderContext(request.contextId(), request);
                searchContext.assignRescoreDocIds(readerContext.getRescoreDocIds(null));
                    try {
            }
            if (keepStatesInContext || request.scroll() != null) {
            query = QueryRewriterRegistry.INSTANCE.rewrite(query, queryShardContext);
    private void setAllowDerivedField(boolean allowDerivedField) {
    );
import org.opensearch.search.collapse.CollapseContext;
                    context.addRescore(rescore.buildContext(queryShardContext));
                OriginalIndices.NONE
import org.opensearch.search.suggest.Suggest;
        // track_total_hits is false.
        if (source.docValueFields() != null) {
                }
                    // In Desc order, if segment/shard minimum is gt search_after, the segment/shard won't be competitive
            DerivedFieldResolver derivedFieldResolver = DerivedFieldResolverFactory.createResolver(
public class SearchService extends AbstractLifecycleComponent implements IndexEventListener {
        return searchContext;
    );
 */
                for (RescorerBuilder<?> rescore : source.rescores()) {
                    freeReaderContext(context.id());
            executorName = Names.SEARCH_THROTTLED;
        return reader;
                isStreamSearch
        } catch (Exception exc) {
 *
    public void freeAllScrollContexts() {
        BigArrays bigArrays,
        context.evaluateRequestShouldUseIntraSegmentSearch();
            if (context.searchAfter() != null) {
        false,
                putReaderContext(readerContext);
                Rewriteable.rewrite(request.getRewriteable(), context, false);
        timeValueHours(24),
            .addSettingsUpdateConsumer(
                listener.onResponse(resp);
        try (Releasable ignored = markAsUsed) {
        return aggregations == null || aggregations.mustVisitAllDocs() == false;
    private DefaultSearchContext createSearchContext(ReaderContext reader, ShardSearchRequest request, TimeValue timeout, boolean validate)
        String executorName
    private long getKeepAlive(ShardSearchRequest request) {
    );
import org.opensearch.indices.cluster.IndicesClusterStateService.AllocatedIndices.IndexRemovalReason;
        Property.Dynamic,
    ) {
    }
        if (source.version() != null) {
    );
            try {
    public DefaultSearchContext createValidationContext(ShardSearchRequest request, TimeValue timeout) throws IOException {
        final boolean canCache = indicesService.canCache(request, context);
                readerContext.addOnClose(decreasePitContexts);
            } catch (IOException e) {
            context.version(source.version());
        Executor indexSearcherExecutor,
        }, wrapFailureListener(listener, readerContext, markAsUsed));
        }
        return new QueryCoordinatorContext(indicesService.getRewriteContext(nowInMillis), searchRequest);
    private <T> void runAsync(Executor executor, CheckedSupplier<T, Exception> executable, ActionListener<T> listener) {
                    if (canMatchResp.canMatch == false) {
    }
        if (source.rescores() != null) {
        return threadPool.executor(executorName);
import org.opensearch.index.search.QueryStringQueryParser;
        3000,
        defaultAllowPartialSearchResults = DEFAULT_ALLOW_PARTIAL_SEARCH_RESULTS.get(settings);
 * license agreements. See the NOTICE file distributed with
                taskResourceTrackingService.writeTaskResourceUsage(task, clusterService.localNode().getId());
import org.opensearch.index.query.QueryShardContext;
    public static final Setting<Integer> CONCURRENT_SEGMENT_SEARCH_PARTITION_MIN_SEGMENT_SIZE = Setting.intSetting(
        Setting.Property.Dynamic
    public void executeQueryPhase(QuerySearchRequest request, SearchShardTask task, ActionListener<QuerySearchResult> listener) {
        private final long time;
    public void afterIndexRemoved(Index index, IndexSettings indexSettings, IndexRemovalReason reason) {
        validatePitKeepAlives(defaultKeepAlive, maxPitKeepAlive);
        }
                processFailure(context, exc);
        1000,
            }
        if (source.stats() != null) {
        CONCURRENT_SEGMENT_SEARCH_DEFAULT_SLICE_COUNT_VALUE,
        }
        } else {
        executor.execute(ActionRunnable.supply(listener, executable::get));
        Property.NodeScope
        }
                        }
        }
    public QueryRewriteContext getValidationRewriteContext(LongSupplier nowInMillis, IndicesRequest searchRequest) {
import org.opensearch.core.index.Index;
        final Releasable markAsUsed = readerContext != null ? readerContext.markAsUsed(getKeepAlive(request)) : () -> {};
        CONCURRENT_SEGMENT_SEARCH_MAX_SLICE_COUNT_KEY,
     * Returns a builder for {@link InternalAggregation.ReduceContext}. This
        return new InternalAggregation.ReduceContextBuilder() {
     * @return response with list of PIT IDs deleted and if operation is successful
            }
        Setting.Property.Dynamic
    private void setDefaultAllowPartialSearchResults(boolean defaultAllowPartialSearchResults) {
                throw new IllegalArgumentException(
import java.util.concurrent.ExecutionException;
import org.opensearch.action.search.DeletePitInfo;
    private final ThreadPool threadPool;
                } else {
                    try (ReaderContext context = removeReaderContext(contextId.getSearchContextIdForNode().getSearchContextId().getId())) {
            @Override
                    scriptService,
     */
        }
import org.opensearch.search.fetch.QueryFetchSearchResult;
    public static boolean canMatchSearchAfter(
            markAsUsed = readerContext.markAsUsed(getScrollKeepAlive(request.scroll()));
    private final ConcurrentMapLong<ReaderContext> activeReaders = ConcurrentCollections.newConcurrentMapLongWithAggressiveConcurrency();
        if (context.request().scroll() != null) {
    private void checkKeepAliveLimit(long keepAlive) {
                }
                    multiBucketConsumerService.create(),
    private ReaderContext findReaderContext(ShardSearchContextId id, TransportRequest request) throws SearchContextMissingException {
        maxOpenPitContext = MAX_OPEN_PIT_CONTEXT.get(settings);
            circuitBreakerService.getBreaker(CircuitBreaker.REQUEST),
        this.taskResourceTrackingService = taskResourceTrackingService;
            processFailure(reader, exc);
        "search.query.max_query_string_length_monitor_only",
                listener.onFailure(exc);
import org.opensearch.common.settings.Setting.Property;
            }
    private final DfsPhase dfsPhase = new DfsPhase();
        }
        true,
                            deleteResults.add(deletePitInfo);
                "Default keep alive setting for request ["
                // check if we can shortcut the query phase entirely.
                    + "was ("
            }
        @Override
     */
                FieldSortBuilder sortBuilder = FieldSortBuilder.getPrimaryFieldSortOrNull(request.source());
        ResponseCollectorService responseCollectorService,
                    );
        context.includeNamedQueriesScore(source.includeNamedQueriesScore());
        boolean includeAggregations,
        Property.Dynamic,
                    () -> executeQueryPhase(orig, task, keepStatesInContext, isStreamSearch, listener),
                    + ")"
            throw new IllegalArgumentException(
                return searchContext.queryResult();
 * You may obtain a copy of the License at
        return new DeletePitResponse(deleteResults);
     * {@code parentTaskId}. Query rewriting can issue real requests (a terms lookup with a subquery runs a search), and
            } else {
            removeReaderContext(context.id().getId());
        "search.concurrent_segment_search.mode",
     * SearchService
    }
        }
        return canMatch(request, true);
        DEFAULT_BUCKET_SELECTION_STRATEGY_FACTOR,
                    }
import org.opensearch.core.common.io.stream.StreamOutput;
            // during rewrite and normalized / evaluate templates etc.
        if (source.suggest() != null) {
        try {
    // only do optimization when there's enough docs per range at segment level and sub agg exists
     * won't match any documents on the current shard.
                exception = (exception.getCause() == null || exception.getCause() instanceof Exception)
    private final BigArrays bigArrays;
import org.opensearch.search.aggregations.AggregationInitializationException;
                    throw new IllegalArgumentException("Setting value must be one of [segment, balanced, force]");
        try {
import java.util.function.Supplier;
            FetchFieldsContext fetchFieldsContext = new FetchFieldsContext(source.fetchFields());
import org.opensearch.cluster.service.ClusterService;
    private QueryFetchSearchResult executeFetchPhase(ReaderContext reader, SearchContext context, long afterQueryTime) {
        } else if (indexShard.indexSettings().isSearchThrottled()) {
    /**
        };
        IndexService indexService,
import java.io.IOException;
        } catch (Exception e) {
import org.opensearch.core.common.breaker.CircuitBreaker;
     * if set to 16 (default), when 16 or more term queries target the same field within
        }
                }
                if (canRewriteToMatchNone(request.source())) {
                concurrentSearchDeciderFactories,
                    listener
        return createSearchContext(request, timeout, false);
            clusterService,
     * until the {@code keepAlive} elapsed unless it is manually released.
                return SearchAfterBuilder.buildFieldDoc(sortOpt.get(), searchAfter);
            @Override
                    + DEFAULT_KEEPALIVE_SETTING.getKey()
            return PipelineTree.EMPTY;
                            + "] setting."
    @Override
        0,
     * Update PIT reader with pit id, keep alive and created time etc
            && context.scrollContext() != null) {
        ShardSearchRequest request,
            try (SearchContext searchContext = createContext(readerContext, shardSearchRequest, task, false)) {
    }
        "search.max_open_pit_context",
            return findReaderContext(request.readerId(), request);
                logger.trace("Query phase failed", e);
        "search.dynamic_pruning.cardinality_aggregation.max_allowed_cardinality",
                listener.onPreFetchPhase(context);
        1000,
        AggregatorFactories.Builder aggregations = source.aggregations();
            SearchContext context = createContext(readerContext, request, task, true, isStreamSearch)
            queryPhase.execute(context);
        return pitContextsInfo;
        "search.keyword_index_or_doc_values_enabled",
            .addSettingsUpdateConsumer(SEARCH_MAX_QUERY_STRING_LENGTH, QueryStringQueryParser::setMaxQueryStringLength);
     *     min(availableProcessors / 2, 4)
                        if (context == null) {
                executor.success();
        });
    private volatile long maxKeepAlive;
                }
    }
            this.canMatch = canMatch;
        32_000,
     * handles this as well since the result is always size * shards for Q_T_F
        final int[] docIdsToLoad;
    private final String sessionId = UUIDs.randomBase64UUID();
    /**
                }
    public static final Setting<TimeValue> MAX_PIT_KEEPALIVE_SETTING = Setting.positiveTimeSetting(
                executor.success();
                    if (fetch) {
        1024,
    }
    }
        final Releasable markAsUsed = readerContext.markAsUsed(getKeepAlive(shardSearchRequest));
     *
import org.opensearch.search.profile.Profilers;
import org.opensearch.common.CheckedSupplier;
        // process scroll
    public static final Setting<Integer> INDICES_MAX_CLAUSE_COUNT_SETTING = Setting.intSetting(
            } else {
import org.opensearch.search.dfs.DfsSearchResult;
        if (indicesService.hasIndex(index) == false) {
                assert TransportActions.isShardNotAvailableException(e) == false : new AssertionError(e);
        Property.Dynamic,
     * the TermsMergingRewriter to combine them into a single terms query. For example,
            @Override
    protected void doStart() {}
        }
            context.seqNoAndPrimaryTerm(source.seqNoAndPrimaryTerm());
        Property.NodeScope,
        ActionListener<ScrollQueryFetchSearchResult> listener
    private volatile boolean lowLevelCancellation;
            }
        IndexService indexService = indicesService.indexServiceSafe(request.shardId().getIndex());
        false,
                if (request.lastEmittedDoc() != null) {
        CONCURRENT_SEGMENT_SEARCH_MIN_SLICE_COUNT_VALUE,
                        listener.onFailedQueryPhase(context);
        }
        // Check for sort.missing == null, since in case of missing values sort queries, if segment/shard's min/max
    }
            queryPhase.preProcess(context);
        return defaultKeepAlive;
        }
        if (sessionId.equals(id.getSessionId()) == false && id.getSessionId().isEmpty() == false) {
     * <pre>
            } else {
            }
import org.opensearch.search.suggest.completion.CompletionSuggestion;
import org.opensearch.search.internal.LegacyReaderContext;
     */
     * Returns pit reader context based on ID
        }
     */
    public static final Setting<Integer> BUCKET_SELECTION_STRATEGY_FACTOR_SETTING = Setting.intSetting(
                // We also pass the rescoreDocIds to the LegacyReaderContext in case the search state needs to stay in the data node.
        true,
            listener.onFailure(e);
        ShardSearchRequest request,
                Optional<SortAndFormats> optionalSort = SortBuilder.buildSort(source.sorts(), context.getQueryShardContext());
                readerContext.setRescoreDocIds(rescoreDocIds);
        for (ReaderContext readerContext : activeReaders.values()) {
    // Disallow concurrent search for all requests
                            searchContext.request()
                listener.onFailure(exc);
                QueryFetchSearchResult fetchSearchResult = executeFetchPhase(readerContext, searchContext, afterQueryTime);
            final Object searchAfterPrimary = searchAfter.fields[0];
        if (request.scroll() != null) {
                int totalSize = context.from() + context.size();
        boolean keepStatesInContext,
    }
    class Reaper implements Runnable {
                SearchContext searchContext = createContext(readerContext, shardSearchRequest, task, true);
    }
    }
 * compatible open source license.
    public static final Setting<TimeValue> DEFAULT_SEARCH_TIMEOUT_SETTING = Setting.timeSetting(
            TopDocs topDocs = context.queryResult().topDocs().topDocs;
            executorName = Names.SYSTEM_READ;
        final ShardSearchRequest shardSearchRequest = readerContext.getShardSearchRequest(request.getShardSearchRequest());
                // add the newly created pit reader context to active readers
