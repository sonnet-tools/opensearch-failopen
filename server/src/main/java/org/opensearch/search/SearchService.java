    public static boolean canMatchSearchAfter(
            if (isStreamSearch) {
                Releasables.closeWhileHandlingException(decreasePitContexts);  
            ) {
        Property.NodeScope
    @ExperimentalApi
    ) {  
        return new QueryFetchSearchResult(context.queryResult(), context.fetchResult());
}
            FetchFieldsContext fetchFieldsContext = new FetchFieldsContext(source.fetchFields());
import org.opensearch.search.suggest.completion.CompletionSuggestion;
    ) {
    public static final String CONCURRENT_SEGMENT_SEARCH_MODE_AUTO = "auto";
            }  
                return new CanMatchResponse(canMatch || hasRefreshPending, minMax);  
        defaultSearchTimeout = DEFAULT_SEARCH_TIMEOUT_SETTING.get(settings);
            context.storedFieldsContext(source.storedFields());  
    private final ResponseCollectorService responseCollectorService;
            if (source.storedFields().fetchFields() == false) {
    }  
    private DefaultSearchContext createSearchContext(ReaderContext reader, ShardSearchRequest request, TimeValue timeout, boolean validate)  
        SearchShardTask task,  
            Releasable ignored = readerContext.markAsUsed(getKeepAlive(request));
            @Override  
        }
                }
    public void executeQueryPhase(
        Property.Dynamic,  
        Property.NodeScope,
        assert request.keepAlive() == null;
                decreaseScrollContexts = openScrollContexts::decrementAndGet;  
                    freeReaderContext(readerContext.id());  
            @Override
        }
            taskResourceTrackingService.writeTaskResourceUsage(task, clusterService.localNode().getId());
        }
    // value == 0 means lucene slice computation will be used
import org.opensearch.search.aggregations.MultiBucketConsumerService;
        if (source == null) {  
        ReaderContext context = activeReaders.get(id.getId());
     * to check if the query can match any documents. This method can have false positives while if it returns {@code false} the query
            }
    }
        CONCURRENT_SEGMENT_SEARCH_MODE_AUTO,  
 * Licensed to Elasticsearch under one or more contributor  
                if (openPitContexts.incrementAndGet() > maxOpenPitContext) {
import org.opensearch.threadpool.ThreadPool;
import org.opensearch.core.action.ActionListener;  
                    searchOperationListener.onFreeReaderContext(finalReaderContext);  
        WorkloadGroupService workloadGroupService  
        final ReaderContext readerContext = createOrGetReaderContext(request, keepStatesInContext);
                "Keep alive for request ("
            for (ReaderContext context : activeReaders.values()) {  
    );  
            this(context, false, System.nanoTime());
    );
            }
    private ReaderContext findReaderContext(ShardSearchContextId id, TransportRequest request) throws SearchContextMissingException {
import org.opensearch.action.IndicesRequest;
    private void setAllowDerivedField(boolean allowDerivedField) {
            return finalReaderContext;
                } else {
            context.fetchFieldsContext(fetchFieldsContext);
        } catch (Exception e) {
                .toList();
                            + "This limit can be set by changing the ["  
    );  
            context.minimumScore(source.minScore());
import org.opensearch.common.lease.Releasable;  
        if (source.sorts() != null) {  
        }, wrapFailureListener(listener, readerContext, markAsUsed));
        this.indicesService = indicesService;
    private final AtomicLong idGenerator = new AtomicLong();
            if (request.numberOfShards() == 1) {
        Property.Dynamic,
            // We need to release the reader context of the scroll when we hit any exception (here the keep_alive can be too large)
        boolean success = false;  
            Releasable ignored = readerContext.markAsUsed(getKeepAlive(request));  
    }
            logger.trace("Query phase failed", exception);
        // we also do rewrite on the coordinating node (TransportSearchService) but we also need to do it here for BWC as well as
        try {
        Property.NodeScope
            if (source.scriptFields().size() > maxAllowedScriptFields) {
            }
                }  
            if (context.from() == -1) {
import org.opensearch.cluster.ClusterState;
                processScroll(request, readerContext, searchContext);
            final IndexService indexService;
            for (int i = 0; i < topDocs.scoreDocs.length; i++) {  
    }
        "search.derived_field.enabled",
                if (afterQueryTime != -1) {
    }
            try {
            }  
        if (CollectionUtils.isEmpty(source.searchAfter()) == false) {  
    public boolean freeReaderContext(ShardSearchContextId contextId) {
                return SearchAfterBuilder.buildFieldDoc(sortOpt.get(), searchAfter);  
        32_000,
        this.taskResourceTrackingService = taskResourceTrackingService;  
    private <T> void runAsync(Executor executor, CheckedSupplier<T, Exception> executable, ActionListener<T> listener) {  
        },
        boolean isStreamSearch
    public static final String CONCURRENT_SEGMENT_SEARCH_PARTITION_STRATEGY_BALANCED = "balanced";  
            try {  
        return new DeletePitResponse(deleteResults);  
     */
     * Shortcut ids to load, we load only "from" and up to "size". The phase controller
    private IndexShard getShard(ShardSearchRequest request) {
        Settings settings = clusterService.getSettings();
                    context.addRescore(rescore.buildContext(queryShardContext));
        false,
    private void setLowLevelCancellation(Boolean lowLevelCancellation) {
        value -> {
            }
            super.writeTo(out);
                    + TimeValue.timeValueMillis(keepAlive)  
            for (CompletionSuggestion.Entry.Option option : completionSuggestion.getOptions()) {
import org.opensearch.core.index.shard.ShardId;
                    decreaseScrollContexts = null;  
                QueryShardContext context = indexService.newQueryShardContext(
                taskResourceTrackingService.writeTaskResourceUsage(task, clusterService.localNode().getId());  
    private void freeAllContextForIndex(Index index) {
            query = QueryRewriterRegistry.INSTANCE.rewrite(query, queryShardContext);  
            time = startTime;
            && context.scrollContext() != null) {  
     * {@code parentTaskId}. Query rewriting can issue real requests (a terms lookup with a subquery runs a search), and
        validatePitKeepAlives(defaultKeepAlive, maxPitKeepAlive);  
                    + " > "
            }  
        return context;
        private final boolean canMatch;  
                assert listener instanceof StreamSearchChannelListener : "Stream search expects StreamSearchChannelListener";
        return this.responseCollectorService;  
        if (source.storedFields() != null) {  
        return new QueryCoordinatorContext(indicesService.getRewriteContext(nowInMillis), searchRequest);
     */  
import org.opensearch.search.dfs.DfsSearchResult;  
            for (Map.Entry<String, InnerHitContextBuilder> entry : innerHitBuilders.entrySet()) {
    public static final Setting<TimeValue> DEFAULT_KEEPALIVE_SETTING = Setting.positiveTimeSetting(  
 * The main search service
    // Make decision for concurrent search based on concurrent search deciders
        MinAndMax<?> minMax,
import java.util.List;  
    private final IndicesService indicesService;  
    }
                        listener.onFailure(exc);
                searchContext.searcher().setAggregatedDfs(readerContext.getAggregatedDfs(request.getAggregatedDfs()));
                throw e;
                        deleteResults.add(deletePitInfo);
        try (Releasable ignored = markAsUsed) {
            return request.readerId() == null ? defaultKeepAlive : -1;
                this::validatePitKeepAlives  
        this.allowDerivedField = allowDerivedField;  
    }
                        if (context == null) {  
    private final BigArrays bigArrays;  
                    deleteResults.add(deletePitInfo);
                context.mapperService().getIndexSettings().getMaxDocvalueFields(),
            logger.warn("failed to process shard failure to (potentially) send back shard failure on corruption", inner);  
import java.util.Collections;
            // we release the reader on failure if the request is a normal search or a scroll  
        this.scriptService = scriptService;  
        }
                // For search context missing cases, mark the operation as succeeded
        }  
        this.clusterService = clusterService;
                    );
        }
    }  
        Releasable decreaseScrollContexts = null;  
import org.opensearch.search.fetch.subphase.FetchFieldsContext;
        }  
        try {
    ) throws IOException {  
            // we clone the query shard context here just for rewriting otherwise we
        final LegacyReaderContext readerContext = (LegacyReaderContext) findReaderContext(request.contextId(), request);  
        "search.dynamic_pruning.cardinality_aggregation.max_allowed_cardinality",  
        1,
    @Override  
                            + MAX_OPEN_SCROLL_CONTEXT.getKey()
        if (canCache) {
                freeReaderContext(reader.id());  
        }
            for (org.opensearch.search.builder.SearchSourceBuilder.ScriptField field : source.scriptFields()) {
        Property.NodeScope  
            final Object searchAfterPrimary = searchAfter.fields[0];
        }
    public void executeQueryPhase(  
        if (source.postFilter() != null) {
                    multiBucketConsumerService.create(),
                        listener.onQueryPhase(context, afterQueryTime - time);
            SearchContext context = createContext(readerContext, request, task, true)
    }  
            } catch (SearchContextMissingException e) {  
     * Search phase result that can match a response
        setKeepAlives(DEFAULT_KEEPALIVE_SETTING.get(settings), MAX_KEEPALIVE_SETTING.get(settings));
    );  
    }
        }  
     *
                default:
        if (source.trackTotalHitsUpTo() != null
            throw new IllegalArgumentException(
            return context.dfsResult();
            try {
            completionSuggestions = Collections.emptyList();
                    if (fetch) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        int docsOffset = 0;  
            // We need to release the reader context of the scroll when we hit any exception (here the keep_alive can be too large)
    private long getKeepAlive(ShardSearchRequest request) {  
     */
import org.opensearch.common.lucene.Lucene;  
                if (minMax.compareMax(searchAfterPrimary) < 0) {  
            return getScrollKeepAlive(request.scroll());
    }
                return searchContext.fetchResult();
        Property.Dynamic
    private final ThreadPool threadPool;
            final long keepAlive = getKeepAlive(request);  
        this.maxOpenPitContext = maxOpenPitContext;
        CONCURRENT_SEGMENT_SEARCH_MIN_SLICE_COUNT_VALUE,
                if (context.queryResult().hasSearchContext() == false && readerContext.singleSession()) {
        } else if (indexShard.indexSettings().isSearchThrottled()) {
        ActionListener<SearchPhaseResult> listener,
    private SearchPhaseResult executeQueryPhase(
        this.lowLevelCancellation = lowLevelCancellation;
        clusterService.getClusterSettings().addSettingsUpdateConsumer(LOW_LEVEL_CANCELLATION_SETTING, this::setLowLevelCancellation);
        }
                throw new IllegalArgumentException(  
     * the TermsMergingRewriter to combine them into a single terms query. For example,
            );  
     * Returns a builder for {@link InternalAggregation.ReduceContext}. This
    private final FetchPhase fetchPhase;  
                } finally {
        public CanMatchResponse(StreamInput in) throws IOException {  
                threadPool::relativeTimeInMillis,  
        try (
                // Pass the rescoreDocIds to the queryResult to send them the coordinating node and receive them back in the fetch phase.  
        true,
    public static final Setting<Integer> SEARCH_MAX_QUERY_NESTING_DEPTH = Setting.intSetting(  
            if (context.scrollContext() != null) {
        Setting.Property.NodeScope,
     * has a resource cost attached to it. This setting is less than scroll since users are  
    }
        "search.concurrent_segment_search.partition_strategy",
        if (source.highlighter() != null) {
                    request.getClusterAlias()  
        } else {
        if (source.seqNoAndPrimaryTerm() != null) {
            throw e;
        Collection<ConcurrentSearchRequestDecider.Factory> concurrentSearchDeciderFactories,
 *  
            final ShardSearchRequest shardSearchRequest = readerContext.getShardSearchRequest(null);
                    + "], "
        checkPitKeepAliveLimit(request.getKeepAlive());
                logger.trace("Query phase failed", e);
        } catch (Exception inner) {
    }
                    try (ReaderContext context = removeReaderContext(contextId.getSearchContextIdForNode().getSearchContextId().getId())) {
        Property.Dynamic,
    );
import org.opensearch.node.ResponseCollectorService;  
        DefaultSearchContext searchContext = null;
        Engine.SearcherSupplier reader,  
            updatePit = readerContext.updatePitIdAndKeepAlive(request.getKeepAlive(), request.getPitId(), request.getCreationTime());  
                context.queryResult().profileResults(shardResults);  
        SearchOperationListenerExecutor(SearchContext context) {  
            }  
            }
                    canMatch = aliasFilterCanMatch;  
            throw e;
     * </pre>  
                docIdsToLoad = new int[Math.min(topDocs.scoreDocs.length - context.from(), context.size()) + numSuggestDocs];
                    + TimeValue.timeValueMillis(maxKeepAlive)  
    }
    }
     */  
                final Integer trackTotalHitsUpto = request.source() == null ? null : request.source().trackTotalHitsUpTo();  
                "Default keep alive setting for request ["
        Property.NodeScope
        List<SearchPlugin.ProfileMetricsProvider> pluginProfilers,
        // ensure that if we race against afterIndexRemoved, we remove the context from the active list.
import org.opensearch.search.internal.ShardSearchContextId;
                    () -> requestToPipelineTree(searchSourceBuilder)  
            success = true;
    }
            // execution exception can happen while loading the cache, strip it  
    public static final Setting<Integer> MAX_OPEN_PIT_CONTEXT = Setting.intSetting(  
    public PitReaderContext getPitReaderContext(ShardSearchContextId id) {  
        };
        if (context.getStarTreeIndexEnabled() && StarTreeQueryHelper.isStarTreeSupported(context)) {  
        value -> {
            } else {
        TimeValue timeout,
            } finally {
import org.opensearch.cluster.service.ClusterService;
            public void onFailure(Exception exc) {
    }  
                            + MAX_OPEN_PIT_CONTEXT.getKey()
        if (keepAlive > maxKeepAlive) {  
                        );
            } else {
        }  
        return new QueryCoordinatorContext(indicesService.getValidationRewriteContext(nowInMillis), searchRequest);  
                MinAndMax<?> minMax = sortBuilder != null ? FieldSortBuilder.getMinMaxOrNull(context, sortBuilder) : null;
            }
        "search.low_level_cancellation",  
    }  
                return executeFetchPhase(readerContext, context, afterQueryTime);
        SearchShardTask task,  
        if (getReaderContext(contextId) != null) {  
     * check if request keep alive is greater than max keep alive
        context.evaluateRequestShouldUseConcurrentSearch();
        }
                return new ScrollQueryFetchSearchResult(fetchSearchResult, searchContext.shardTarget());  
import java.util.ArrayList;
                    + ") is too large. "
    @ExperimentalApi
                        listener.onFailedQueryPhase(context);
        }
    private DefaultSearchContext createSearchContext(
    /**
import org.opensearch.script.FieldScript;
                    request.shardId().id(),  
        @Override
        final List<CompletionSuggestion> completionSuggestions;  
                searchContext.queryResult().setRescoreDocIds(rescoreDocIds);  
                }  
                context.scrollContext().scroll = request.scroll();
                    );  
    ) {
                }
            && primarySortField.missing() == null  
    ) {
     * a global aggregation is part of this request or if there is a suggest builder present.  
                    + "], "
            }
        ReaderContext readerContext,
        }
        ActionListener<SearchPhaseResult> listener
        boolean isStreamSearch,
        clusterService.getClusterSettings()  
                } else {
        boolean keepStatesInContext,  
import org.opensearch.index.mapper.DerivedFieldResolverFactory;  
        }  
    private void rewriteAndFetchShardRequest(IndexShard shard, ShardSearchRequest request, ActionListener<ShardSearchRequest> listener) {
        }
    public static final Setting<TimeValue> DEFAULT_SEARCH_TIMEOUT_SETTING = Setting.timeSetting(
        } finally {  
                context.size(DEFAULT_SIZE);
            inner.addSuppressed(exc);
        final IndexShard shard = indexService.getShard(shardId.id());  
    }  
        "search.default_allow_partial_results",
        try {
        }  
        } catch (Exception e) {
/*  
            context.sliceBuilder(source.slice());  
import org.opensearch.search.lookup.SearchLookup;  
     * a boolean clause, they will be merged into a single terms query for better performance.  
                processFailure(context, exc);
        if (source.stats() != null) {  
        if (suggest != null && suggest.hasScoreDocs()) {
        "search.query.max_query_string_length",  
        } else {
        String executorName  
        } else {  
                }
            }
    }  
    public void executeQueryPhase(  
    public SearchService(
            docIdsToLoad = new int[topDocs.scoreDocs.length + numSuggestDocs];
            this.context = context;  
        // nothing to parse...
    }  
                if (request.scroll() != null) {
        ) {  
                checkPitKeepAliveLimit(request.keepAlive().millis());
        timeValueHours(24),
            );
                        "Trying to create too many scroll contexts. Must be less than or equal to: ["  
                    bigArrays,
                listener.onResponse(resp);  
                try {
     * if set to 16 (default), when 16 or more term queries target the same field within
                final boolean aliasFilterCanMatch = request.getAliasFilter().getQueryBuilder() instanceof MatchNoneQueryBuilder == false;  
        16,
                searchOperationListener.onNewScrollContext(finalReaderContext);
    public static final Setting<Boolean> CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING = Setting.boolSetting(
                SearchContext searchContext = createContext(readerContext, shardSearchRequest, task, false);  
        Property.Dynamic,  
        }
                ProfileShardResult shardResults = SearchProfileShardResults.buildShardResults(context.getProfilers(), context.request());
    private void checkKeepAliveLimit(long keepAlive) {
    }
            public void onResponse(T resp) {
        ShardSearchRequest request,
                            searchContext.request()
                        PitReaderContext pitReaderContext = (PitReaderContext) context;
        final Index index = context.indexShard().shardId().getIndex();
        final IndexService indexService = indicesService.indexServiceSafe(shardId.getIndex());
            searchContext.getQueryShardContext().setDerivedFieldResolver(derivedFieldResolver);
            return request.keepAlive().getMillis();  
    private void setMaxOpenPitContext(int maxOpenPitContext) {  
    public static final Setting<Boolean> SEARCH_MAX_QUERY_STRING_LENGTH_MONITOR_ONLY = Setting.boolSetting(
        }
        CONCURRENT_SEGMENT_SEARCH_MAX_SLICE_COUNT_KEY,  
        Setting.Property.Dynamic
                    if (readerContext.singleSession()) {
        clusterService.getClusterSettings().addSettingsUpdateConsumer(MAX_OPEN_SCROLL_CONTEXT, this::setMaxOpenScrollContext);
            listener.onResponse(canMatch(request));  
    /**
    private void setDefaultAllowPartialSearchResults(boolean defaultAllowPartialSearchResults) {
                    getExecutor(executorName, shard),  
        final IndexShard shard = getShard(request);
        clusterService.getClusterSettings()  
                    ? (Exception) exception.getCause()
        assert index != null;  
                case CONCURRENT_SEGMENT_SEARCH_MODE_ALL:  
                context.from(DEFAULT_FROM);
 * software distributed under the License is distributed on an
            @Override
    public static final int CONCURRENT_SEGMENT_SEARCH_MIN_SLICE_COUNT_VALUE = 0;
            freeReaderContext(context.id());
            out.writeOptionalWriteable(estimatedMinAndMax);  
import org.opensearch.action.search.DeletePitResponse;
     * parenting them lets per-request admission control tell a nested request from a fresh one.
    }
     * This helper class ensures we only execute either the success or the failure path for {@link SearchOperationListener}.
        }  
        final int[] docIdsToLoad;
            } finally {
                throw new SearchException(shardTarget, "cannot use `collapse` in a scroll context");
                        + maxAllowedScriptFields
        final ShardSearchRequest shardSearchRequest = readerContext.getShardSearchRequest(request.getShardSearchRequest());
        final ReaderContext readerContext = request.readerId() != null ? findReaderContext(request.readerId(), request) : null;
                            deleteResults.add(deletePitInfo);
                if (openScrollContexts.incrementAndGet() > maxOpenScrollContext) {
    );  
        }
    private <T> ActionListener<T> wrapFailureListener(ActionListener<T> listener, ReaderContext context, Releasable releasable) {
            public void onFailure(Exception exc) {
                throw new SearchException(shardTarget, "failed to create RescoreSearchContext", e);
            processFailure(readerContext, exception);
        try {
        Executor indexSearcherExecutor,
    public static final Setting<Long> TERMS_AGGREGATION_MAX_PRECOMPUTE_CARDINALITY = Setting.longSetting(
                }  
                throw e;  
    );
import org.opensearch.index.shard.SearchOperationListener;  
            } else {  
    private void setDefaultSearchTimeout(TimeValue defaultSearchTimeout) {
                int totalSize = context.from() + context.size();  
                    + MAX_KEEPALIVE_SETTING.getKey()  
    // value 0 can disable dynamic pruning optimization in cardinality aggregation
    public static final Setting<Boolean> KEYWORD_INDEX_OR_DOC_VALUES_ENABLED = Setting.boolSetting(
                reader.indexShard().shardId(),
        for (ReaderContext ctx : activeReaders.values()) {
                    + "). "
import static org.opensearch.common.unit.TimeValue.timeValueMinutes;  
        // if we then close all the contexts we can get some search failures along the way which are not expected.
                readerContext = new ReaderContext(id, indexService, shard, reader, keepAlive, request.keepAlive() == null);  
        context.scrollContext().scroll = request.scroll();  
 * compatible open source license.
        ActionListener<SearchPhaseResult> listener  
                }
                optionalSort.ifPresent(context::sort);  
                canMatchSearcher = indexShard.acquireSearcher(Engine.CAN_MATCH_SEARCH_SOURCE);
            }  
import org.opensearch.search.fetch.subphase.FetchDocValuesContext;  
                searcherSupplier = null; // transfer ownership to reader context  
                        "Trying to create too many Point In Time contexts. Must be less than or equal to: ["  
            @Override  
                context.mapperService()::simpleMatchToFullName,  
 *    http://www.apache.org/licenses/LICENSE-2.0
                context.aggregations(new SearchContextAggregations(factories, multiBucketConsumerService.create()));
import org.opensearch.search.aggregations.InternalAggregation.ReduceContext;
            context.searchAfter(fieldDoc);
    private void loadOrExecuteQueryPhase(final ShardSearchRequest request, final SearchContext context) throws Exception {
        checkPitKeepAliveLimit(keepAlive.millis());
        final Releasable markAsUsed;
        IndexShard shard,
                    docIdsToLoad[docsOffset++] = topDocs.scoreDocs[i].doc;  
import java.util.concurrent.atomic.AtomicLong;
        }
        final LegacyReaderContext readerContext = (LegacyReaderContext) findReaderContext(request.contextId(), request);  
        context.docIdsToLoad(docIdsToLoad, 0, docIdsToLoad.length);  
        }
import org.opensearch.script.ScriptService;  
                queryPhase.execute(searchContext);  
        ClusterService clusterService,
    }
            if (context.scrollContext() == null && !(context.readerContext() instanceof PitReaderContext)) {  
        Property.NodeScope,  
                FieldSortBuilder sortBuilder = FieldSortBuilder.getPrimaryFieldSortOrNull(request.source());
        timeValueMinutes(1),
                QueryStringQueryParser::setMaxQueryStringLengthMonitorMode
            }
    }
            DefaultSearchContext searchContext = createSearchContext(readerContext, request, timeout, validate);
            context.setProfilers(profilers);  
        } catch (Exception e) {
                "Default keep alive setting for request ["
import org.opensearch.index.mapper.DerivedFieldResolver;
                ) {
            if (topDocs.scoreDocs.length < context.from()) {
        if (keepAlive > maxPitKeepAlive) {
        boolean keepStatesInContext,  
                }
     * Controls the threshold for the number of term queries on the same field that triggers  
    private final Executor indexSearcherExecutor;
     * Returns true iff the given search source builder can be early terminated by rewriting to a match none query. Or in other words
                // we handle the failure in the failure listener below
        TimeValue keepAliveInterval = KEEPALIVE_INTERVAL_SETTING.get(settings);
        } finally {  
        try (  
                // now we need to check if there is a pending refresh and register  
    private final AtomicInteger openPitContexts = new AtomicInteger();  
                    }
            } else {  
    public static final Setting<Boolean> DEFAULT_ALLOW_PARTIAL_SEARCH_RESULTS = Setting.boolSetting(
                readerContext.setRescoreDocIds(rescoreDocIds);
        final Suggest suggest = context.queryResult().suggest();
        500_000,  
        1000,
    protected void doClose() {
                    freeReaderContext(context.id());  
                            continue;  
        return canMatch(request, true);  
            }
                            + "] setting."
                        canMatchResp = canMatch(clone, false);  
            executor.success();
                    } else {
        Property.Dynamic,  
                hasRefreshPending = indexShard.hasRefreshPending() && checkRefreshPending;  
    }  
    }  
        SearchShardTask task,
                return new ScrollQuerySearchResult(searchContext.queryResult(), searchContext.shardTarget());
                    "Trying to retrieve too many script_fields. Must be less than or equal to: ["
    }
                        ShardSearchRequest clone = new ShardSearchRequest(orig);
    public static final String CONCURRENT_SEGMENT_SEARCH_MODE_ALL = "all";
            settings,
    ) {
                listener.onFailure(exc);  
            listener.onFailure(e);
 * Modifications Copyright OpenSearch Contributors. See
            context.setDerivedFieldResolver(derivedFieldResolver);  
            }  
            context.trackTotalHitsUpTo(source.trackTotalHitsUpTo());
        InternalScrollSearchRequest request,
 * Unless required by applicable law or agreed to in writing,
    private final Cancellable keepAliveReaper;  
                    + defaultKeepAlive  
        SearchShardTarget shardTarget = context.shardTarget();  
        if (context instanceof PitReaderContext pitReaderContext) {
            putReaderContext(finalReaderContext);  
import org.apache.logging.log4j.Logger;
    }
            if (request.scroll() != null) {
                throw new SearchException(shardTarget, "failed to create sort elements", e);
    }  
                logger.trace("Query phase failed", e);
        return indicesService;
/*  
            ) {
import org.opensearch.common.settings.Settings;  
                }  
            this.listener = context.indexShard().getSearchOperationListener();
/*
        }  
import java.util.Objects;
                        + source.scriptFields().size()
                        searchContext.fetchResult().profileResults(shardResults);  
                }
     * SearchService
                }
            .addSettingsUpdateConsumer(SEARCH_MAX_QUERY_NESTING_DEPTH, QueryStringQueryParser::setMaxQueryNestingDepth);  
import org.opensearch.transport.TransportRequest;
    ) {
                    request::nowInMillis,
    // Allow concurrent segment search for all requests
    private final MultiBucketConsumerService multiBucketConsumerService;  
            && source.trackTotalHitsUpTo() != SearchContext.TRACK_TOTAL_HITS_ACCURATE
import static org.opensearch.common.unit.TimeValue.timeValueHours;
        Property.Dynamic  
    // mechanism will not be used if this setting is set with value > 0
                context.setStreamChannelListener((StreamSearchChannelListener<SearchPhaseResult, ShardSearchRequest>) listener);  
        SearchShardTask task,
import org.opensearch.search.profile.ProfileShardResult;
                runAsync(
                    }  
                // we handle the case where `IndicesService#indexServiceSafe`or `IndexService#getShard`, or the DefaultSearchContext
            executorName = Names.SYSTEM_READ;  
    private final ScriptService scriptService;
            } catch (Exception e) {  
                    throw new SearchException(shardTarget, "[stored_fields] cannot be disabled when using the [fields] option");  
    public static final Setting<Integer> AGGREGATION_REWRITE_FILTER_SEGMENT_THRESHOLD = Setting.intSetting(  
                );
        );
    }
        }
            final ShardSearchContextId id = new ShardSearchContextId(sessionId, idGenerator.incrementAndGet());
        Setting.Property.NodeScope,
    }  
                SearchOperationListenerExecutor executor = new SearchOperationListenerExecutor(searchContext)  
import org.opensearch.common.UUIDs;
        ResponseCollectorService responseCollectorService,  
            reader = null;
import static org.opensearch.search.internal.SearchContext.TRACK_TOTAL_HITS_DISABLED;
                    bigArrays,
            context.setTask(task);
        if (source.fetchFields() != null) {  
    private volatile boolean lowLevelCancellation;
        "search.aggregation_rewrite_filters.segment_threshold.docs_per_bucket",
    public static final class CanMatchResponse extends SearchPhaseResult {
    // we can have 5 minutes here, since we make sure to clean with search requests and when shard/index closes
        SearchShardTask task,
            }  
                if (minMax.compareMin(searchAfterPrimary) > 0) {
            }  
            }
                    canMatchSearcher,
                    }
     * This default is used when the user does not explicitly set the  
    /**
        boolean isStreamSearch
    private boolean isScrollContext(ReaderContext context) {  
        "search.keyword_index_or_doc_values_enabled",
            try {
            executorName = Names.SEARCH_THROTTLED;
            if (request.readerId() != null) {  
                    fetchPhase.execute(searchContext);  
        try (ReaderContext readerContext = new ReaderContext(id, indexService, indexShard, reader, -1L, true)) {  
            if (context.scrollContext() != null) {
                ListPitInfo pitInfo = new ListPitInfo(context.getPitId(), context.getCreationTime(), context.getKeepAlive());  
        for (CompletionSuggestion completionSuggestion : completionSuggestions) {
                    readerContext.addOnClose(decreaseScrollContexts);
    private void shortcutDocIdsToLoad(SearchContext context) {
        TaskResourceTrackingService taskResourceTrackingService,  
                freeReaderContext(readerContext.id());
import org.opensearch.index.query.QueryRewriteContext;  
        clusterService.getClusterSettings()
                    : new OpenSearchException(exception.getCause());
    }
        SearchShardTask task,
        String executorName
                    freeReaderContext(readerContext.id());  
                    scriptService,  
            context.timeout(source.timeout());
        boolean keepStatesInContext
    // value 0 means rewrite filters optimization in aggregations will be disabled  
    final ReaderContext createOrGetReaderContext(ShardSearchRequest request, boolean keepStatesInContext) {  
            throw exception;  
            switch (value) {
        }, wrapFailureListener(listener, readerContext, markAsUsed));
    /**  
                searchOperationListener.onNewPitContext(finalReaderContext);  
            }
            if (success == false) {
    private final TaskResourceTrackingService taskResourceTrackingService;  
        false,
        }  
            } else {  
    protected void doStart() {}
        return createContext(readerContext, request, task, includeAggregations, false);
            // if the from and size are still not set, default them  
        return createAndPutReaderContext(request, indexService, shard, reader, keepStatesInContext);
            try {
        30_000L,
        ShardSearchRequest request,  
                case CONCURRENT_SEGMENT_SEARCH_MODE_NONE:
            context.collapse(collapseContext);  
        }
                shardTarget,  
        } catch (Exception e) {
        Rewriteable.rewriteAndFetch(request.getRewriteable(), indicesService.getRewriteContext(request::nowInMillis), actionListener);
                } catch (IOException e) {
    public QueryRewriteContext getValidationRewriteContext(LongSupplier nowInMillis, IndicesRequest searchRequest) {
                    throw new SearchException(shardTarget, "[stored_fields] cannot be disabled if [_source] is requested");  
        return createSearchContext(reader, request, timeout, validate, false);
                // We also pass the rescoreDocIds to the LegacyReaderContext in case the search state needs to stay in the data node.
                    + "was ("
                .flatMap(p -> p.getQueryProfileMetrics(context, query).stream())  
import org.opensearch.core.tasks.TaskId;  
            if (reader.singleSession()) {
            @Override
import org.opensearch.common.CheckedSupplier;  
        } else {  
            } catch (IOException e) {
     * Try to load the query results from the cache or execute the query phase directly if the cache cannot be used.  
            }
                    // In Desc order, if segment/shard minimum is gt search_after, the segment/shard won't be competitive
    private final String sessionId = UUIDs.randomBase64UUID();
                    }  
        final ShardSearchContextId id = new ShardSearchContextId(sessionId, idGenerator.incrementAndGet());
    private long getScrollKeepAlive(Scroll scroll) {  
import org.opensearch.search.startree.StarTreeQueryHelper;  
        Map<String, InnerHitContextBuilder> innerHitBuilders = new HashMap<>();
        "search.max_keep_alive",
        public MinAndMax<?> estimatedMinAndMax() {
        Property.NodeScope,  
                final RescoreDocIds rescoreDocIds = searchContext.rescoreDocIds();
    }
        }, listener::onFailure);  
        if (source == null || source.query() == null || source.query() instanceof MatchAllQueryBuilder || source.suggest() != null) {  
        } catch (Exception e) {
            }
        if (searchSourceBuilder == null || searchSourceBuilder.aggregations() == null) {  
        }  
            context.explain(source.explain());
        if (source.fetchSource() != null) {
import org.opensearch.search.fetch.subphase.highlight.HighlightBuilder;  
                    break;
        }  
            if (context.getProfilers() != null) {
            }  
    );
            fetchPhase.execute(context);  
                    + "). "
                checkKeepAliveLimit(request.keepAlive().millis());
        }
        Property.NodeScope
                            + maxOpenPitContext
                }
    public InternalAggregation.ReduceContextBuilder aggReduceContextBuilder(SearchSourceBuilder searchSourceBuilder) {
import org.opensearch.search.fetch.ShardFetchRequest;
public class SearchService extends AbstractLifecycleComponent implements IndexEventListener {
        clusterService.getClusterSettings()
        Integer.MAX_VALUE,  
        if (source.scriptFields() != null && source.size() != 0) {  
    /**
    protected void putReaderContext(ReaderContext context) {
import java.util.Optional;  
            .addSettingsUpdateConsumer(DEFAULT_ALLOW_PARTIAL_SEARCH_RESULTS, this::setDefaultAllowPartialSearchResults);
    public static final String CONCURRENT_SEGMENT_SEARCH_MAX_SLICE_COUNT_KEY = "search.concurrent.max_slice_count";  
                );
        }
                        searchOperationListener.onFreeScrollContext(finalReaderContext);  
                final long afterQueryTime = executor.success();
            freeReaderContext(readerContext.id());  
     *
        }
                final ReaderContext finalReaderContext = readerContext;
import org.opensearch.search.sort.FieldSortBuilder;  
                context.addSearchExt(searchExtBuilder);
        "point_in_time.max_keep_alive",
        0,  
        AggregatorFactories.Builder aggregations = source.aggregations();  
        // unfortunately we don't have a clear way to signal today why an index is closed.
package org.opensearch.search;
            this.canMatch = canMatch;
     * <ul>
import org.opensearch.search.startree.StarTreeQueryContext;
                );
 * You may obtain a copy of the License at  
    private QueryFetchSearchResult executeFetchPhase(ReaderContext reader, SearchContext context, long afterQueryTime) {  
import org.apache.lucene.search.SortField;  
            indicesService.loadIntoContext(request, context, queryPhase);  
            if (closed == false) {
            .addSettingsUpdateConsumer(
            if (fetch) {  
import org.opensearch.index.shard.IndexShard;
    public void afterIndexRemoved(Index index, IndexSettings indexSettings, IndexRemovalReason reason) {  
            removeReaderContext(context.id().getId());  
                readerContext = new PitReaderContext(id, indexService, shard, searcherSupplier, keepAlive.millis(), false);
            checkKeepAliveLimit(scroll.keepAlive().millis());
        QueryStringQueryParser.setMaxQueryNestingDepth(SEARCH_MAX_QUERY_NESTING_DEPTH.get(settings));
        Property.NodeScope
import java.io.IOException;
                throw e;
                    assert orig.scroll() == null;
     */
        SearchOperationListenerExecutor(SearchContext context, boolean fetch, long startTime) {
    public void executeQueryPhase(QuerySearchRequest request, SearchShardTask task, ActionListener<QuerySearchResult> listener) {
import org.opensearch.common.util.concurrent.ConcurrentCollections;  
import org.opensearch.common.settings.Setting;
            }
        });
                context.highlight(highlightBuilder.build(queryShardContext));
        if (source.profile()) {
                    // valid setting  
    private void validatePitKeepAlives(TimeValue defaultKeepAlive, TimeValue maxPitKeepAlive) {
                FieldScript.LeafFactory searchScript = factory.newFactory(field.script().getParams(), lookup);
                queryPhase.execute(searchContext);  
import org.opensearch.search.dfs.DfsPhase;
            this.fetch = fetch;
        clusterService.getClusterSettings().addSettingsUpdateConsumer(INDICES_MAX_CLAUSE_COUNT_SETTING, IndexSearcher::setMaxClauseCount);
    public void canMatch(ShardSearchRequest request, ActionListener<CanMatchResponse> listener) {
import org.opensearch.action.search.UpdatePitContextRequest;  
                    entry.getValue().build(context, context.innerHits());  
                exception = (exception.getCause() == null || exception.getCause() instanceof Exception)  
        Property.NodeScope
     * Returns the number of active contexts in this
    /**  
        }  
        timeValueHours(24),
import org.opensearch.index.shard.IndexEventListener;
                        + "] but was ["  
 * ownership. Elasticsearch licenses this file to you under  
     */  
        boolean keepStatesInContext,
        return reader;  
            SearchContext context = createContext(readerContext, request, task, true, isStreamSearch)
import org.opensearch.index.engine.Engine;
        }
                    // null query means match_all
import org.opensearch.tasks.TaskResourceTrackingService;  
        // to release memory and let references to the filesystem go etc.
    private volatile int maxOpenScrollContext;  
            try (
                });
    ) {  
            throw new SearchContextMissingException(request.getSearchContextId());
            } else {
        }
    );  
    // Minimum segment size for balanced partitioning (only applies when partition_strategy = balanced)  
        if (source.trackTotalHitsUpTo() != null) {  
    /**  
                searchContext.searcher().setAggregatedDfs(readerContext.getAggregatedDfs(null));
        return defaultAllowPartialSearchResults;
        allowDerivedField = CLUSTER_ALLOW_DERIVED_FIELD_SETTING.get(settings);
import org.opensearch.common.settings.Setting.Property;
    private final ConcurrentMapLong<ReaderContext> activeReaders = ConcurrentCollections.newConcurrentMapLongWithAggressiveConcurrency();
        Integer.MAX_VALUE,  
            assert keepStatesInContext == false;
import org.opensearch.index.IndexNotFoundException;
        assert request.searchType() == SearchType.QUERY_THEN_FETCH : "unexpected search type: " + request.searchType();
        }
        return searchSourceBuilder.aggregations().buildPipelineTree();  
        ReaderContext readerContext = null;
                readerContext.setRescoreDocIds(searchContext.rescoreDocIds());
        try {  
                }
import org.opensearch.search.aggregations.AggregatorFactories;
                // add the newly created pit reader context to active readers
import org.opensearch.action.search.DeletePitInfo;  
        if (defaultKeepAlive.millis() > maxPitKeepAlive.millis()) {  
                    + "] cluster level setting."
        return true;  
        ShardSearchRequest request,
        runAsync(getExecutor(null, readerContext.indexShard()), () -> {  
        ReaderContext readerContext,
                // We also pass the rescoreDocIds to the LegacyReaderContext in case the search state needs to stay in the data node.
                context.suggest(source.suggest().build(queryShardContext));
        false,  
    }
        Property.NodeScope
        "search.concurrent_segment_search.partition_min_segment_size",
        clusterService.getClusterSettings()
     */  
import org.opensearch.indices.cluster.IndicesClusterStateService.AllocatedIndices.IndexRemovalReason;
            // pre process  
                queryShardContext.setStarTreeQueryContext(starTreeQueryContext);
                throw new AggregationInitializationException("Failed to create aggregators", e);  
            }  
            throw new IllegalArgumentException(
        this.maxOpenScrollContext = maxOpenScrollContext;
import org.opensearch.search.suggest.Suggest;
     * if the execution of the search request can be early terminated without executing it. This is for instance not possible if
        }  
        executeDfsPhase(request, keepStatesInContext, task, listener, null);
    private volatile boolean defaultAllowPartialSearchResults;
            }
    }
import org.opensearch.search.profile.Profilers;  
     */
    }
 * this file be licensed under the Apache-2.0 license or a
                    final CanMatchResponse canMatchResp;  
        }
                SearchLookup lookup = context.getQueryShardContext().lookup();  
        private boolean closed = false;
        Property.Dynamic,
        1024,
                }
import org.opensearch.search.sort.MinAndMax;
import org.opensearch.search.aggregations.InternalAggregation;  
    );  
    public static final Setting<Boolean> QUERY_REWRITING_ENABLED_SETTING = Setting.boolSetting(
                searcherSupplier = shard.acquireSearcherSupplier();
     * handles this as well since the result is always size * shards for Q_T_F
            } catch (Exception e) {
        false,  
            if (readerContext != null) {
    }
        boolean keepStatesInContext,
        Property.NodeScope
        context.from(source.from());
                loadOrExecuteQueryPhase(request, context);
            }
    /**  
     */
        ActionListener<SearchPhaseResult> listener,
import org.opensearch.index.IndexService;
        if (source.slice() != null) {
     * This setting defines the maximum number of active PIT reader contexts in the node , since each PIT context
     * @return response with list of PIT IDs deleted and if operation is successful  
            } else {
                case CONCURRENT_SEGMENT_SEARCH_MODE_AUTO:
    // Partition strategy constants
        IndexSearcher.setMaxClauseCount(INDICES_MAX_CLAUSE_COUNT_SETTING.get(settings));  
            }
    protected void doStop() {
        final IndexShard indexShard = indexService.getShard(request.shardId().getId());  
                DeletePitInfo deletePitInfo = new DeletePitInfo(true, contextId.getPitId());
        "search.query.max_query_nesting_depth",
    ) {  
    private CanMatchResponse canMatch(ShardSearchRequest request, boolean checkRefreshPending) throws IOException {  
                try (  
    private void setMaxOpenScrollContext(int maxOpenScrollContext) {
    private void parseSource(DefaultSearchContext context, SearchSourceBuilder source, boolean includeAggregations) {
        }
                    throw new SearchException(shardTarget, "failed to build inner_hits", e);
            final Object[] searchAfter = request.source().searchAfter();  
        if (source.rescores() != null) {
                taskResourceTrackingService.writeTaskResourceUsage(task, clusterService.localNode().getId());
                final FieldDoc searchAfterFieldDoc = getSearchAfterFieldDoc(request, context);
/**  
     */
        final ReaderContext readerContext = findReaderContext(request.contextId(), request);
        ReaderContext reader,  
 *
                return context.queryResult();  
    public List<ListPitInfo> getAllPITReaderContexts() {
        100,
        } finally {  
            }
    public static final Setting<Integer> MAX_AGGREGATION_REWRITE_FILTERS = Setting.intSetting(
                        freeReaderContext(request.contextId());  
    /**
            processFailure(readerContext, e);
                    + TimeValue.timeValueMillis(maxPitKeepAlive)
                    if (searchContext.getProfilers() != null) {
                validate,
    }  
                searchContext.getQueryShardContext(),
    }  
                freeReaderContext(ctx.id());  
    public void createPitReaderContext(ShardId shardId, TimeValue keepAlive, ActionListener<ShardSearchContextId> listener) {  
        }  
        } finally {
    ) throws Exception {
        3000,
            for (SearchExtBuilder searchExtBuilder : source.ext()) {  
            }
            } catch (IOException e) {  
    private volatile TimeValue defaultSearchTimeout;  
import org.opensearch.action.search.SearchShardTask;
            && minMax != null
    );  
            final ReaderContext finalReaderContext = readerContext;  
        clusterService.getClusterSettings().addSettingsUpdateConsumer(CLUSTER_ALLOW_DERIVED_FIELD_SETTING, this::setAllowDerivedField);  
                lowLevelCancellation,  
        return new QueryCoordinatorContext(indicesService.getRewriteContext(nowInMillis, parentTaskId), searchRequest);
                listener.onFailure(exc);
        context.from(context.from() + context.size());
     *     min(availableProcessors / 2, 4)
        }
    public AliasFilter buildAliasFilter(ClusterState state, String index, Set<String> resolvedExpressions) {  
    }
            Releasable decreasePitContexts = openPitContexts::decrementAndGet;
    }
        for (ReaderContext ctx : activeReaders.values()) {
        FetchPhase fetchPhase,
                throw new SearchException(shardTarget, "`from` parameter must be set to 0 when `search_after` is used.");
import org.opensearch.search.sort.SortBuilder;  
    }
            public InternalAggregation.ReduceContext forPartialReduction() {
    protected ReaderContext removeReaderContext(long id) {
        "search.default_keep_alive",
        return new InternalAggregation.ReduceContextBuilder() {  
    public IndicesService getIndicesService() {  
                closed = true;  
                    // no hits, we can release the context since there will be no fetch phase
import java.util.function.LongSupplier;
        0,
            completionSuggestions = suggest.filter(CompletionSuggestion.class);
        SearchShardTask task,  
            final List<SortBuilder<?>> sorts = request.source().sorts();
                searchContext.searcher().setAggregatedDfs(request.dfs());
        if (source.version() != null) {
    public void executeQueryPhase(
    }
            }  
     * noticeably slow down searches.  
                Optional<SortAndFormats> optionalSort = SortBuilder.buildSort(source.sorts(), context.getQueryShardContext());
        "search.keep_alive_interval",
                    // For search context missing cases, mark the operation as succeeded
        }
        ShardSearchRequest request,
    /**
        boolean includeAggregations
            }
            );
import org.opensearch.common.util.io.IOUtils;
        } catch (IOException e) {
    private ReaderContext getReaderContext(ShardSearchContextId id) {  
    public DeletePitResponse freeReaderContextsIfFound(List<PitSearchContextIdForNode> contextIds) {
            markAsUsed = readerContext.markAsUsed(getScrollKeepAlive(request.scroll()));  
        assert indexShard != null;  
                readerContext = null;  
    );
        ShardSearchRequest request,
        }
                concurrentSearchDeciderFactories,
        }
        boolean keepStatesInContext,  
     * This method returns all active PIT reader contexts  
        if (!innerHitBuilders.isEmpty()) {  
                bigArrays,
                    throw new OpenSearchRejectedExecutionException(
                // fork the execution in the search thread pool
            }  
            });
        } else executorName = Objects.requireNonNullElse(executor, Names.SEARCH);  
            this.estimatedMinAndMax = estimatedMinAndMax;
                    + maxKeepAlive
        throws IOException {  
    // settings to configure maximum slice created per search request using OS custom slice computation mechanism. Default lucene
     * builder retains a reference to the provided {@link SearchSourceBuilder}.  
            return searchContext;  
    }
            ) {
        boolean includeAggregations,
            boolean consolidated = starTreeQueryContext.consolidateAllFilters(context);
            } finally {  
                        listener.onFailedFetchPhase(context);  
                canMatch = canMatch && canMatchSearchAfter(searchAfterFieldDoc, minMax, sortBuilder, trackTotalHitsUpto);
            return pitReaderContext;  
            int maxAllowedScriptFields = context.mapperService().getIndexSettings().getMaxScriptFields();
    }  
        executeQueryPhase(request, keepStatesInContext, task, listener, executorName, false);
     */
        private final long time;
            }
    public void updatePitIdAndKeepAlive(UpdatePitContextRequest request, ActionListener<UpdatePitContextResponse> listener) {
    public static final Setting<Integer> CONCURRENT_SEGMENT_SEARCH_TARGET_MAX_SLICE_COUNT_SETTING = Setting.intSetting(
            if (context.size() == -1) {
    private final Collection<ConcurrentSearchRequestDecider.Factory> concurrentSearchDeciderFactories;
        } catch (Exception e) {
        ShardSearchRequest request,
                deleteResults.add(deletePitInfo);  
            if (getReaderContext(request.readerId()) instanceof PitReaderContext) {
                readerContext.addOnClose(() -> {
        }
import org.opensearch.search.fetch.FetchPhase;
        rewriteAndFetchShardRequest(shard, request, new ActionListener<ShardSearchRequest>() {  
                }
            ReaderContext readerContext = null;
    public void executeFetchPhase(
                listener.onFailure(exc);
        IndicesService indicesService,  
        public void close() {  
                Releasables.close(releasable);
     */
        }  
        }
    public static final Setting<Boolean> LOW_LEVEL_CANCELLATION_SETTING = Setting.boolSetting(
        }
            } catch (IOException e) {  
        Property.Dynamic,
        final String executorName;
            );
    public static final TimeValue NO_TIMEOUT = timeValueMillis(-1);  
            if (Lucene.isCorruptionException(exc)) {
        if (source.collapse() != null) {  
                executor.success();
                        return;
        this.indexSearcherExecutor = indexSearcherExecutor;
     * <p>
            if (request.scroll() != null) {
                case CONCURRENT_SEGMENT_SEARCH_PARTITION_STRATEGY_SEGMENT:  
        // is out of search_after range, it still should be printed and hence we should not skip segment/shard.  
                request.getClusterAlias(),  
                taskResourceTrackingService.writeTaskResourceUsage(task, clusterService.localNode().getId());
     */
        if (source.minScore() != null) {  
                throw new SearchException(shardTarget, "`slice` cannot be used outside of a scroll context or PIT context");
        ActionListener<SearchPhaseResult> listener
                        + "] index level setting."
import org.opensearch.action.search.ListPitInfo;
                    + ")"  
        return this.activeReaders.size();
    }
            queryPhase.execute(context);
                // constructor throws an exception since we would otherwise leak a searcher and this can have severe implications  
        QueryRewriterRegistry.INSTANCE.initialize(settings, clusterService.getClusterSettings());
            queryPhase.preProcess(context);
            return false;
                            + "]. "
            } catch (IOException e) {
            return PipelineTree.EMPTY;
        context.trackScores(source.trackScores());
import org.opensearch.plugins.SearchPlugin;
        try {
    ) {
import org.opensearch.index.query.QueryCoordinatorContext;
     */
    }
    private final List<SearchPlugin.ProfileMetricsProvider> pluginProfilers;
                this::aggReduceContextBuilder,
    }
    );
    public int getActiveContexts() {
        Setting.Property.NodeScope,
        private final MinAndMax<?> estimatedMinAndMax;
            throw new SearchContextMissingException(id);
        ScriptService scriptService,
import org.opensearch.action.support.TransportActions;  
                AggregatorFactories factories = source.aggregations().build(queryShardContext, null);  
                    + "It must be less than ("  
            clusterService,  
            }
                source.docValueFields()
            if (keepStatesInContext || request.scroll() != null) {
        context.getQueryShardContext().freezeContext();
        long success() {
        if (source.suggest() != null) {  
     * won't match any documents on the current shard.  
     * {@code search.concurrent.max_slice_count} cluster setting.
            if (finalReaderContext.scrollContext() != null) {  
            super(in);
        executeFetchPhase(request, task, listener, null);
import org.opensearch.search.deciders.ConcurrentSearchRequestDecider;
        "search.max_open_scroll_context",  
            this.canMatch = in.readBoolean();
        10,  
            }
                    if (canMatchResp.canMatch == false) {
        CONCURRENT_SEGMENT_SEARCH_DEFAULT_SLICE_COUNT_VALUE,
                reader,
        if (searchAfter != null  
                );  
import org.opensearch.index.query.QueryShardContext;
        ActionListener<ScrollQueryFetchSearchResult> listener
            Profilers profilers = new Profilers(context.searcher(), context.shouldUseConcurrentSearch(), pluginProfileMetricsSupplier);
    final ReaderContext createAndPutReaderContext(
    /**
    ) throws IOException {
import org.opensearch.search.query.QueryPhase;
    }
     * Returns pit reader context based on ID
        return defaultKeepAlive;
            .addSettingsUpdateConsumer(
                case CONCURRENT_SEGMENT_SEARCH_PARTITION_STRATEGY_FORCE:
import org.opensearch.core.common.io.stream.StreamInput;
 */  
            FieldDoc fieldDoc = SearchAfterBuilder.buildFieldDoc(context.sort(), source.searchAfter());
                        DeletePitInfo deletePitInfo = new DeletePitInfo(success, pitId);
                executor.success();  
        this.defaultSearchTimeout = defaultSearchTimeout;
            }  
            Releasables.close(reader, readerContext, decreaseScrollContexts);
        0,  
import org.opensearch.common.lifecycle.AbstractLifecycleComponent;
            }
            assert searchContext.getQueryShardContext().isCacheable();
            readerContext.addOnClose(() -> {  
import org.opensearch.index.query.QueryBuilder;
                    listener
    }
    /**  
import org.opensearch.search.query.QuerySearchRequest;
    public static final Setting<TimeValue> KEEPALIVE_INTERVAL_SETTING = Setting.positiveTimeSetting(  
        }
    }
        keepAliveReaper.cancel();
        try {
 * KIND, either express or implied.  See the License for the
import java.util.concurrent.atomic.AtomicInteger;
        } finally {
            QueryBuilder query = source.query();  
import org.opensearch.search.internal.PitReaderContext;
                    + "]"
import java.util.function.Function;  
            final Optional<SortAndFormats> sortOpt = SortBuilder.buildSort(sorts, context);
 * specific language governing permissions and limitations
        QueryShardContext queryShardContext = context.getQueryShardContext();
import org.opensearch.index.query.Rewriteable;
                    searchOperationListener.onFreeReaderContext(finalReaderContext);  
                // fork the execution in the search thread pool  
                }
        return pitContextsInfo;
import org.opensearch.search.profile.ProfileMetric;
import org.opensearch.action.support.StreamSearchChannelListener;
            } else {
            readerContext.setAggregatedDfs(request.dfs());  
        Property.Dynamic,  
        boolean validate,  
 * license agreements. See the NOTICE file distributed with
        this.maxPitKeepAlive = maxPitKeepAlive.millis();
        assert request.canReturnNullResponseIfMatchNoDocs() == false || request.numberOfShards() > 1  
            );
        public void writeTo(StreamOutput out) throws IOException {  
                return searchContext.queryResult();
            try (ReaderContext context = removeReaderContext(contextId.getId())) {
    );
    public static final int DEFAULT_FROM = 0;  
                searchContext.assignRescoreDocIds(readerContext.getRescoreDocIds(request.getRescoreDocIds()));  
    private final ClusterService clusterService;
        Setting.Property.NodeScope,
        Property.NodeScope
    public void executeFetchPhase(
            out.writeBoolean(canMatch);
            freeAllContextForIndex(index);
        }  
    );
        ) {
import org.apache.lucene.search.TopDocs;
    /**  
        this.keepAliveReaper = threadPool.scheduleWithFixedDelay(new Reaper(), keepAliveInterval, Names.SAME);  
            Rewriteable.rewrite(request.getRewriteable(), context, true);  
     */
     *   <li>On small machines, it avoids over-threading.</li>  
                    + "] cluster level setting."
    }
                    + TimeValue.timeValueMillis(keepAlive)
        runAsync(getExecutor(null, readerContext.indexShard()), () -> {  
            }
        if (context.singleSession() || isScrollContext(context)) {
    private void checkPitKeepAliveLimit(long keepAlive) {  
                    throw new IllegalArgumentException("Setting value must be one of [segment, balanced, force]");
        clusterService.getClusterSettings().addSettingsUpdateConsumer(MAX_OPEN_PIT_CONTEXT, this::setMaxOpenPitContext);
        final SearchOperationListener searchOperationListener = shard.getSearchOperationListener();
        0,
                // we handle the failure in the failure listener below  
            SearchShardTarget shardTarget = new SearchShardTarget(  
    }  
                    executor.success();
        // can register its settings update consumer
                listener.onPreQueryPhase(context);  
    }
                docIdsToLoad = new int[numSuggestDocs];
    public static boolean canRewriteToMatchNone(SearchSourceBuilder source) {
            throw exc;
import org.opensearch.search.fetch.FetchSearchResult;
    );
 * the Apache License, Version 2.0 (the "License"); you may
        setPitKeepAlives(DEFAULT_KEEPALIVE_SETTING.get(settings), MAX_PIT_KEEPALIVE_SETTING.get(settings));  
        "search.concurrent_segment_search.mode",
            public ReduceContext forFinalReduction() {
            reader.validate(request);
        SearchShardTask task,  
                // (unable to obtain shard lock exceptions).
                } else {
                    + defaultKeepAlive  
        defaultAllowPartialSearchResults = DEFAULT_ALLOW_PARTIAL_SEARCH_RESULTS.get(settings);
        }  
            if (readerContext.scrollContext() != null) {
        Property.Dynamic
                case CONCURRENT_SEGMENT_SEARCH_PARTITION_STRATEGY_BALANCED:
            context.setKeywordFieldIndexOrDocValuesEnabled(searchContext.keywordIndexOrDocValuesEnabled());
    public static final Setting<Integer> CONCURRENT_SEGMENT_SEARCH_PARTITION_MIN_SEGMENT_SIZE = Setting.intSetting(
    }
    }
            );
    /**
                    + "This limit can be set by changing the ["  
    }  
        final ReaderContext readerContext = findReaderContext(request.contextId(), request.shardSearchRequest());
     * @return the computed default slice count  
        this.responseCollectorService = responseCollectorService;
            final SearchOperationListener searchOperationListener = shard.getSearchOperationListener();
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.OpenSearchException;
        ShardSearchRequest request,
import org.opensearch.search.fetch.ScrollQueryFetchSearchResult;
    );
 * GitHub history for details.
                final ShardSearchContextId id = new ShardSearchContextId(sessionId, idGenerator.incrementAndGet());  
            context.parsedQuery(queryShardContext.toQuery(query));  
        public CanMatchResponse(boolean canMatch, MinAndMax<?> estimatedMinAndMax) {  
import org.opensearch.search.sort.SortOrder;
                readerContext = new LegacyReaderContext(id, indexService, shard, reader, request, keepAlive);  
        DEFAULT_BUCKET_SELECTION_STRATEGY_FACTOR,
    );  
            return;  
        context.evaluateRequestShouldUseIntraSegmentSearch();  
        Engine.SearcherSupplier reader = shard.acquireSearcherSupplier();
            }
        this.concurrentSearchDeciderFactories = concurrentSearchDeciderFactories;
 */  
                indexService = readerContext.indexService();  
    );
    }
    // Partition strategy setting  
        // Check for sort.missing == null, since in case of missing values sort queries, if segment/shard's min/max
            if (primarySortField.order() == SortOrder.DESC) {  
            shortcutDocIdsToLoad(context);
                    } else {
        Setting.Property.Dynamic
        200,
            if (updatePit != null) {  
import org.opensearch.search.rescore.RescorerBuilder;
            } finally {  
                Optional.ofNullable(request.source()).map(SearchSourceBuilder::getDerivedFields).orElse(Collections.emptyList()),  
                SEARCH_MAX_QUERY_STRING_LENGTH_MONITOR_ONLY,  
                return context != null;
            freeReaderContext(context.id());  
            final ShardSearchRequest shardSearchRequest = readerContext.getShardSearchRequest(null);
import org.apache.lucene.search.FieldDoc;  
                indexSearcherExecutor,  
            throw e;
        int numSuggestDocs = 0;
        PitReaderContext readerContext = getPitReaderContext(request.getSearchContextId());  
import java.util.Collection;  
        clusterService.getClusterSettings()
import org.opensearch.action.search.UpdatePitContextResponse;
            taskResourceTrackingService.writeTaskResourceUsage(task, clusterService.localNode().getId());
        this.threadPool = threadPool;  
import org.opensearch.search.aggregations.SearchContextAggregations;  
        }  
     * Returns a new {@link QueryCoordinatorContext} whose async rewrite actions issue their requests as children of  
        Setting.Property.NodeScope,
        if (sessionId.equals(id.getSessionId()) == false && id.getSessionId().isEmpty() == false) {
    }
                searchContext.assignRescoreDocIds(readerContext.getRescoreDocIds(null));  
        ShardSearchRequest request,  
    public boolean defaultAllowPartialSearchResults() {  
import org.opensearch.action.search.PitSearchContextIdForNode;  
            freeReaderContext(readerContext.id());  
    );
                        listener.onFetchPhase(context, afterQueryTime - time);  
                taskResourceTrackingService.writeTaskResourceUsage(task, clusterService.localNode().getId());
 * not use this file except in compliance with the License.
import org.opensearch.search.query.QuerySearchResult;
                docIdsToLoad[docsOffset++] = option.getDoc().doc;  
                listener.onResponse(request);
    }  
import org.opensearch.action.OriginalIndices;
import org.opensearch.action.search.SearchType;
 * this work for additional information regarding copyright
import org.opensearch.common.util.BigArrays;
    }
        Property.Dynamic,
                this::setPitKeepAlives,
                    + " should be smaller than max keep alive ["
import org.apache.logging.log4j.LogManager;
        final Releasable markAsUsed;
                    pipelineTree
        try (SearchOperationListenerExecutor executor = new SearchOperationListenerExecutor(context, true, afterQueryTime)) {
                if (request.lastEmittedDoc() != null) {  
                            + "This limit can be set by changing the ["  
            public void onResponse(ShardSearchRequest orig) {
        final boolean canCache = indicesService.canCache(request, context);  
        }
            throw new IllegalArgumentException(
            circuitBreakerService.getBreaker(CircuitBreaker.REQUEST),
        Property.Dynamic,  
                putReaderContext(readerContext);
        Property.NodeScope,  
    private volatile long maxKeepAlive;
        if (request.scroll() != null) {
                    + "was ("
        NO_TIMEOUT,  
                // no more docs...  
                listener.onResponse(finalReaderContext.id());
            }
import org.opensearch.search.builder.SearchSourceBuilder;
        }
        private final SearchOperationListener listener;
        "search.aggregations.terms.max_precompute_cardinality",  
                queryPhase.execute(searchContext);
    public static final String CONCURRENT_SEGMENT_SEARCH_PARTITION_STRATEGY_FORCE = "force";
    }
            // might end up with incorrect state since we are using now() or script services  
            return findReaderContext(request.readerId(), request);  
        Property.Deprecated
                }
            }  
    ) {
            searchContext.addReleasable(readerContext.markAsUsed(0L));
        if (context.request().scroll() != null) {  
                timeout,
            InnerHitContextBuilder.extractInnerHits(source.postFilter(), innerHitBuilders);  
     */
            final Function<Query, Collection<Supplier<ProfileMetric>>> pluginProfileMetricsSupplier = (query) -> pluginProfilers.stream()
        }  
            } catch (Exception exc) {
        IndexService indexService = indicesService.indexServiceSafe(request.shardId().getIndex());
            }
        this.defaultKeepAlive = defaultKeepAlive.millis();
    private void processFailure(ReaderContext context, Exception exc) {
    /**  
            try (
import org.opensearch.search.query.ScrollQuerySearchResult;  
     * Computes the default maximum number of slices for concurrent segment search.
    }
        "indices.query.bool.max_clause_count",  
    private static int computeDefaultSliceCount() {
            public void onFailure(Exception exc) {
import org.opensearch.search.internal.LegacyReaderContext;  
        "search.concurrent_segment_search.enabled",  
        this.bigArrays = bigArrays;
            if (sortOpt.isPresent() && !CollectionUtils.isEmpty(searchAfter)) {
                        return;  
                    }
        runAsync(getExecutor(null, readerContext.indexShard()), () -> {
                    throw new IllegalArgumentException("Setting value must be one of [all, none, auto]");  
        }  
                    break;  
                logger.trace("Fetch phase failed", e);  
     * Returns a new {@link QueryCoordinatorContext} with the given {@code now} provider and {@link IndicesRequest searchRequest}  
        InternalScrollSearchRequest request,
        }, wrapFailureListener(listener, readerContext, markAsUsed));  
    public static final Setting<Integer> QUERY_REWRITING_TERMS_THRESHOLD_SETTING = Setting.intSetting(
                IndexShard indexShard = indexService.getShard(request.shardId().getId());
            }
            context.groupStats(source.stats());
import org.opensearch.search.sort.SortAndFormats;
            }
        rewriteAndFetchShardRequest(shard, request, new ActionListener<ShardSearchRequest>() {  
            Engine.SearcherSupplier searcherSupplier = null;  
            // during rewrite and normalized / evaluate templates etc.
            final long afterQueryTime;
                for (RescorerBuilder<?> rescore : source.rescores()) {  
    /**  
        final Releasable markAsUsed = readerContext.markAsUsed(getKeepAlive(shardSearchRequest));
     * This is crucial for some implementations like {@link org.opensearch.index.search.stats.ShardSearchStats}.
            if (context.from() > 0) {
                isStreamSearch  
    }
            && primarySortField != null
                }
                context.getIndexSettings().isDerivedFieldAllowed() && allowDerivedField
                clusterService.state().nodes().getMinNodeVersion(),
import java.util.Set;
                            searchContext.getProfilers(),  
        });
    public static final int DEFAULT_SIZE = 10;
     * This method uses a lightweight searcher without wrapping (i.e., not open a full reader on frozen indices) to rewrite the query
                    () -> executeQueryPhase(orig, task, keepStatesInContext, isStreamSearch, listener),
        // it's fine to keep the contexts open if the index is still "alive"  
            }
                context.indexShard().failShard("search execution corruption failure", exc);
                throw new SearchException(shardTarget, "cannot use `collapse` in conjunction with `rescore`");  
    }  
        }
                searchContext.searcher().setAggregatedDfs(readerContext.getAggregatedDfs(null));  
                SearchContext searchContext = createContext(readerContext, shardSearchRequest, task, false);  
import org.opensearch.threadpool.ThreadPool.Names;  
    );
                    + " should be smaller than max keep alive for PIT ["
    public DefaultSearchContext createValidationContext(ShardSearchRequest request, TimeValue timeout) throws IOException {
                QueryFetchSearchResult fetchSearchResult = executeFetchPhase(readerContext, searchContext, afterQueryTime);
    public static final String CONCURRENT_SEGMENT_SEARCH_PARTITION_STRATEGY_SEGMENT = "segment";
                    + DEFAULT_KEEPALIVE_SETTING.getKey()  
                if (context.fetchFieldsContext() != null) {
     * Default keep alive search setting should be less than max PIT keep alive  
                Releasables.close(releasable);  
                throw new SearchException(shardTarget, "failed to create SuggestionSearchContext", e);
        300,
        this.defaultAllowPartialSearchResults = defaultAllowPartialSearchResults;  
    private void setPitKeepAlives(TimeValue defaultKeepAlive, TimeValue maxPitKeepAlive) {
        ActionListener<SearchPhaseResult> listener,
            throw new SearchContextMissingException(id);
            final Engine.Searcher canMatchSearcher;  
import org.opensearch.core.common.breaker.CircuitBreaker;
                SortField[] sort = context.sort().sort.getSort();
                request,
import org.opensearch.action.ActionRunnable;  
    public void executeDfsPhase(
        final Releasable markAsUsed = readerContext.markAsUsed(getKeepAlive(shardSearchRequest));  
        1,
    public static final Setting<String> CLUSTER_CONCURRENT_SEGMENT_SEARCH_MODE = Setting.simpleString(
     * This value is dynamically calculated as:  
        maxOpenPitContext = MAX_OPEN_PIT_CONTEXT.get(settings);  
    }  
                        }
    final SearchContext createContext(
        Property.NodeScope
            processFailure(reader, exc);  
        final ReaderContext previous = activeReaders.put(context.id().getId(), context);  
        // Initialize QueryRewriterRegistry with cluster settings so TermsMergingRewriter  
            logger.trace("Dfs phase failed", e);  
    public void executeFetchPhase(ShardFetchRequest request, SearchShardTask task, ActionListener<FetchSearchResult> listener) {  
        CONCURRENT_SEGMENT_SEARCH_PARTITION_STRATEGY_BALANCED,  
            context.close();  
            try (
    public static final Setting<TimeValue> MAX_PIT_KEEPALIVE_SETTING = Setting.positiveTimeSetting(  
     */
    }
                    SearchOperationListenerExecutor executor = new SearchOperationListenerExecutor(searchContext, true, System.nanoTime())
                if (getReaderContext(contextId.getSearchContextIdForNode().getSearchContextId()) != null) {  
    public static final Setting<Boolean> ALLOW_EXPENSIVE_QUERIES = Setting.boolSetting(
            markAsUsed = readerContext.markAsUsed(getScrollKeepAlive(request.scroll()));  
                        boolean success = context != null;  
    ) {
            context.evaluateRequestShouldUseConcurrentSearch();
        QueryStringQueryParser.setMaxQueryStringLength(SEARCH_MAX_QUERY_STRING_LENGTH.get(settings));  
     * to the cancellation request faster. It will produce more cancellation checks but benchmarking has shown these did not
                    }
                        ProfileShardResult shardResults = SearchProfileShardResults.buildFetchOnlyShardResults(
    // only do optimization when there's enough docs per range at segment level and sub agg exists
                listener.onFailure(exc);
            );
        private long afterQueryTime = -1;  
import java.util.function.Supplier;
    private volatile long maxPitKeepAlive;
            );
                fetchPhase,
            }  
import org.opensearch.common.lease.Releasables;
     *   <li>On larger machines, it caps the concurrency to a reasonable level (4 slices).</li>
            QueryShardContext context = new QueryShardContext(searchContext.getQueryShardContext());
                    + "]"
                DEFAULT_KEEPALIVE_SETTING,  
            try (SearchContext searchContext = createContext(readerContext, shardSearchRequest, task, false)) {
                            DeletePitInfo deletePitInfo = new DeletePitInfo(true, contextId.getPitId());
    private void setKeepAlives(TimeValue defaultKeepAlive, TimeValue maxKeepAlive) {
import org.opensearch.common.util.concurrent.ConcurrentMapLong;
            this.estimatedMinAndMax = in.readOptionalWriteable(MinAndMax::new);  
    private final AtomicInteger openScrollContexts = new AtomicInteger();
    @Override  
        QueryStringQueryParser.setMaxQueryStringLengthMonitorMode(SEARCH_MAX_QUERY_STRING_LENGTH_MONITOR_ONLY.get(settings));  
            @Override
     * Enables low-level, frequent search cancellation checks. Enabling low-level checks will make long running searches to react
     */
            } catch (Exception e) {  
                Rewriteable.rewrite(request.getRewriteable(), context, false);
        executor.execute(ActionRunnable.supply(listener, executable::get));
        final Engine.SearcherSupplier reader = indexShard.acquireSearcherSupplier();
            try {  
                OriginalIndices.NONE
            }  
        500,
            throw e;
            try {
                default:
import org.opensearch.index.query.MatchNoneQueryBuilder;  
            if (context.rescore() != null && context.rescore().isEmpty() == false) {
            HighlightBuilder highlightBuilder = source.highlighter();
            return estimatedMinAndMax;
        FieldSortBuilder primarySortField,
            }  
        return new ActionListener<T>() {
import org.opensearch.index.IndexSettings;  
        // AliasFilters that might need to be rewritten. These are edge-cases but we are every efficient doing the rewrite here so it's not
                searchOperationListener.onNewReaderContext(readerContext);
        }
     */  
                // SCORE/DOC sorts have a null field name; compare null-safely so this is a SearchException, not an NPE  
            @Override
        final List<ListPitInfo> pitContextsInfo = new ArrayList<>();  
                numSuggestDocs += completionSuggestion.getOptions().size();
        // adding a lot of overhead  
        ActionListener<FetchSearchResult> listener,
import org.opensearch.search.fetch.QueryFetchSearchResult;  
    public DefaultSearchContext createSearchContext(ShardSearchRequest request, TimeValue timeout) throws IOException {
        validateKeepAlives(defaultKeepAlive, maxKeepAlive);  
            workloadGroupService  
                    }
 *
                final RescoreDocIds rescoreDocIds = context.rescoreDocIds();  
        if (scroll != null && scroll.keepAlive() != null) {
    }
    }
                readerContext.setRescoreDocIds(rescoreDocIds);
        for (ReaderContext readerContext : activeReaders.values()) {  
import org.opensearch.common.unit.TimeValue;
    private DfsSearchResult executeDfsPhase(ShardSearchRequest request, SearchShardTask task, boolean keepStatesInContext)
    }  
        @Override
import org.opensearch.core.index.Index;  
                Releasables.closeWhileHandlingException(searcherSupplier, readerContext);
        context.size(source.size());  
        doStop();  
                    throw new SearchException(
        // once an index is removed due to deletion or closing, we can just clean up all the pending search context information
import java.util.concurrent.ExecutionException;
    public static final Setting<Integer> CARDINALITY_AGGREGATION_PRUNING_THRESHOLD = Setting.intSetting(
        },
    /**  
                runAsync(getExecutor(executorName, shard), () -> executeDfsPhase(request, task, keepStatesInContext), listener);
    private volatile long defaultKeepAlive;  
                    + ") is too large. "
        1,  
    }
                    + DEFAULT_KEEPALIVE_SETTING.getKey()  
            }
        assert request.readerId() == null;  
                FieldScript.Factory factory = scriptService.compile(field.script(), FieldScript.CONTEXT);
            }
                SearchOperationListenerExecutor executor = new SearchOperationListenerExecutor(searchContext)
        @Override
            // Apply query rewriting optimizations
    );
import org.opensearch.search.aggregations.pipeline.PipelineAggregator.PipelineTree;
                context.scriptFields().add(new ScriptField(field.fieldName(), searchScript, field.ignoreFailure()));
            if (consolidated) {  
            && Objects.equals(trackTotalHitsUpto, TRACK_TOTAL_HITS_DISABLED)) {
import org.opensearch.wlm.WorkloadGroupService;
        IndexService indexService,
        // Skipping search on shard/segment entirely can cause mismatch on total_tracking_hits, hence skip only if
                boolean canMatch;  
    );
            : "empty responses require more than one shard";
        return false;
                MAX_PIT_KEEPALIVE_SETTING,
                    + MAX_PIT_KEEPALIVE_SETTING.getKey()
                            + "]. "
import org.opensearch.search.fetch.subphase.ScriptFieldsContext.ScriptField;
        Property.Dynamic,
                    }  
        String executorName,  
        assert previous == null;
import java.util.Map;
import static org.opensearch.common.unit.TimeValue.timeValueMillis;
        Property.NodeScope  
        try {  
        "search.default_search_timeout",
        private final boolean fetch;
            context.docValuesContext(docValuesContext);
            listener.onResponse(new UpdatePitContextResponse(request.getPitId(), request.getCreationTime(), request.getKeepAlive()));
            );
        Property.NodeScope
    }  
        try {  
    public static final Setting<String> CONCURRENT_SEGMENT_SEARCH_PARTITION_STRATEGY = Setting.simpleString(
import java.util.HashMap;
        2,  // minimum value
    public void executeDfsPhase(
    public static final String CONCURRENT_SEGMENT_SEARCH_MODE_NONE = "none";
    public static final int DEFAULT_BUCKET_SELECTION_STRATEGY_FACTOR = 5;
                SearchOperationListenerExecutor executor = new SearchOperationListenerExecutor(searchContext)
    private static PipelineTree requestToPipelineTree(SearchSourceBuilder searchSourceBuilder) {
        ActionListener<Rewriteable> actionListener = ActionListener.wrap(r -> {
                    + maxPitKeepAlive
     */
                    return false;  
        true,  
                Optional.ofNullable(request.source()).map(SearchSourceBuilder::getDerivedFieldsObject).orElse(Collections.emptyMap()),
                        "collapse field and sort field must be the same when use `collapse` in conjunction with `search_after`"
                context.queryResult().setRescoreDocIds(rescoreDocIds);
        return indicesService.buildAliasFilter(state, index, resolvedExpressions);
        if (request.readerId() != null) {
                docIdsToLoad[docsOffset++] = topDocs.scoreDocs[i].doc;
        Property.Dynamic,
import org.opensearch.indices.IndicesService;
        boolean isStreamSearch  
        Property.Dynamic,  
        return null;  
        "search.max_open_pit_context",
    }
        final DefaultSearchContext context = createSearchContext(readerContext, request, defaultSearchTimeout, false, isStreamSearch);
                updatePit.close();
            if (ctx instanceof PitReaderContext context) {
    }
            switch (value) {
        FieldDoc searchAfter,  
        if (source.timeout() != null) {  
                if (context.isExpired()) {
                    throw new OpenSearchRejectedExecutionException(
import org.opensearch.core.common.io.stream.StreamOutput;  
        return activeReaders.remove(id);  
                try {
        return searchContext;
        if (source.docValueFields() != null) {
        }
     * Opens the reader context for given shardId. The newly opened reader context will be keep  
        }  
    }  
import org.opensearch.search.internal.ShardSearchRequest;
        if (source.query() != null) {
            }  
import org.opensearch.search.internal.ReaderContext;
                IOUtils.closeWhileHandlingException(searchContext);
        }  
            .addSettingsUpdateConsumer(SEARCH_MAX_QUERY_STRING_LENGTH, QueryStringQueryParser::setMaxQueryStringLength);
                if (searchContext.queryResult().hasSearchContext() == false && readerContext.singleSession()) {
        }
        return context instanceof LegacyReaderContext && context.singleSession() == false;
     * @opensearch.internal  
                pitContextsInfo.add(pitInfo);
    /**
        "search.query_rewriting.enabled",
        Property.Dynamic,
                    if (finalReaderContext.scrollContext() != null) {
                        + IndexSettings.MAX_SCRIPT_FIELDS_SETTING.getKey()  
                    return false;
        if (request.readerId() != null) {
            if (context.searchAfter() != null) {
        this.fetchPhase = fetchPhase;
    public CanMatchResponse canMatch(ShardSearchRequest request) throws IOException {
                }  
        } else if (request.keepAlive() != null) {  
        executeQueryPhase(request, keepStatesInContext, task, listener, null);  
                    + MAX_KEEPALIVE_SETTING.getKey()  
            context.version(source.version());
        shard.awaitShardSearchActive(ignored -> {
        ShardSearchRequest request,
     * </ul>
                    DeletePitInfo deletePitInfo = new DeletePitInfo(true, contextId.getPitId());  
                }
    /**
    public QueryRewriteContext getRewriteContext(LongSupplier nowInMillis, IndicesRequest searchRequest, TaskId parentTaskId) {
            searchOperationListener.onNewReaderContext(finalReaderContext);
        return Math.max(1, Math.min(Runtime.getRuntime().availableProcessors() / 2, 4));  
    public static final Setting<Integer> SEARCH_MAX_QUERY_STRING_LENGTH = Setting.intSetting(
        Property.Dynamic
            }
    @Override
            freeReaderContext(readerContext.id());  
            return scroll.keepAlive().getMillis();  
                assert TransportActions.isShardNotAvailableException(e) == false : new AssertionError(e);
        SearchShardTask task,
                            + "] setting."
     * Returns a new {@link QueryCoordinatorContext} with the given {@code now} provider and {@link IndicesRequest searchRequest}
                    scriptService,
                // we handle the failure in the failure listener below
    private volatile int maxOpenPitContext;
            return findReaderContext(request.readerId(), request).indexShard();  
import org.opensearch.search.internal.InternalScrollSearchRequest;
            }
            }
        // process scroll
    );
            for (CompletionSuggestion completionSuggestion : completionSuggestions) {  
        context.includeNamedQueriesScore(source.includeNamedQueriesScore());  
        timeValueMinutes(5),
    public DefaultSearchContext createSearchContext(ShardSearchRequest request, TimeValue timeout, boolean validate) throws IOException {
    public static final int CONCURRENT_SEGMENT_SEARCH_DEFAULT_SLICE_COUNT_VALUE = computeDefaultSliceCount();
        true,
    private volatile boolean allowDerivedField;
        }
        }
            dfsPhase.execute(context);  
        if (defaultKeepAlive.millis() > maxKeepAlive.millis()) {  
import org.opensearch.search.collapse.CollapseContext;  
        }  
            context.fetchSourceContext(source.fetchSource());
                processScroll(request, readerContext, searchContext);
import org.opensearch.index.search.QueryStringQueryParser;  
            @Override  
    public void freeAllScrollContexts() {
        clusterService.getClusterSettings().addSettingsUpdateConsumer(DEFAULT_SEARCH_TIMEOUT_SETTING, this::setDefaultSearchTimeout);  
    }
                "Keep alive for request ("  
        Property.NodeScope
import org.opensearch.core.concurrency.OpenSearchRejectedExecutionException;
                if (sort.length != 1 || Objects.equals(sort[0].getField(), source.collapse().getField()) == false) {
                    + "This limit can be set by changing the ["
import org.opensearch.search.aggregations.AggregationInitializationException;
                listener.onPreFetchPhase(context);
    );
        Property.NodeScope,  
                        listener.onResponse(QuerySearchResult.nullInstance());  
        true,
import org.opensearch.core.indices.breaker.CircuitBreakerService;
                PipelineTree pipelineTree = requestToPipelineTree(searchSourceBuilder);  
                clusterService.localNode().getId(),
        ActionListener<ScrollQuerySearchResult> listener
                SearchContext searchContext = createContext(readerContext, shardSearchRequest, task, true);
            } catch (Exception e) {
    public static final Setting<Integer> BUCKET_SELECTION_STRATEGY_FACTOR_SETTING = Setting.intSetting(
    class Reaper implements Runnable {  
            }
            DerivedFieldResolver derivedFieldResolver = DerivedFieldResolverFactory.createResolver(  
 * The OpenSearch Contributors require contributions made to  
        for (PitSearchContextIdForNode contextId : contextIds) {
                    + ")"  
            context.evaluateRequestShouldUseIntraSegmentSearch();
        if (reason == IndexRemovalReason.DELETED || reason == IndexRemovalReason.CLOSED || reason == IndexRemovalReason.REOPENED) {  
import java.util.concurrent.Executor;  
     * Update PIT reader with pit id, keep alive and created time etc
                // we handle the failure in the failure listener below
            }  
    @Override
        Property.Dynamic,
        final IndexShard shard = getShard(request);
        }
        String executorName
        List<DeletePitInfo> deleteResults = new ArrayList<>();  
        ShardSearchRequest request,  
        0,
                if (context.sourceRequested()) {
        public void run() {
import org.opensearch.search.searchafter.SearchAfterBuilder;
            context.seqNoAndPrimaryTerm(source.seqNoAndPrimaryTerm());  
        }
import org.apache.lucene.search.Query;
        Property.Dynamic,  
        }  
                throw e;
                searchContext.docIdsToLoad(request.docIds(), 0, request.docIdsSize());
     * <pre>
            TopDocs topDocs = context.queryResult().topDocs().topDocs;
import org.opensearch.search.internal.SearchContext;  
import org.opensearch.search.query.QueryRewriterRegistry;  
    /**  
        "search.query_rewriting.terms_threshold",  
                    } catch (Exception exc) {
        return createSearchContext(request, timeout, true);
            context.parsedPostFilter(queryShardContext.toQuery(source.postFilter()));
            throw new IndexNotFoundException(index);
                indexService = indicesService.indexServiceSafe(request.shardId().getIndex());
                // check if we can shortcut the query phase entirely.  
        lowLevelCancellation = LOW_LEVEL_CANCELLATION_SETTING.get(settings);  
        QueryPhase queryPhase,
            InnerHitContextBuilder.extractInnerHits(query, innerHitBuilders);
        private final SearchContext context;  
        }
                hasRefreshPending = false;
        this.pluginProfilers = pluginProfilers;
        Setting.Property.Dynamic  
        public boolean canMatch() {  
            parseSource(context, request.source(), includeAggregations);
                for (int i = context.from(); i < Math.min(totalSize, topDocs.scoreDocs.length); i++) {
        final ReaderContext reader = getReaderContext(id);
            readerContext = null;
                            + maxOpenScrollContext
        // track_total_hits is false.
        throws IOException {
import org.opensearch.index.query.InnerHitContextBuilder;
        final IndexService indexService = indicesService.indexServiceSafe(request.shardId().getIndex());
        Property.NodeScope  
        Property.NodeScope  
                    + " > "
    private static final Logger logger = LogManager.getLogger(SearchService.class);  
        return null;
    private SearchContext createContext(
        Integer trackTotalHitsUpto  
                throw new SearchException(shardTarget, "`search_after` cannot be used in a scroll context.");
            if (index.equals(ctx.indexShard().shardId().getIndex())) {
    }  
        for (final ReaderContext context : activeReaders.values()) {
            }
                        + "]. This limit can be set by changing the ["
        Property.Dynamic,  
            }
            }
        Setting.Property.Dynamic  
        });
    public QueryRewriteContext getRewriteContext(LongSupplier nowInMillis, IndicesRequest searchRequest) {
                    try {
        if (source.ext() != null) {
     * Free reader contexts if found
            FetchDocValuesContext docValuesContext = FetchDocValuesContext.create(
            throw new IllegalArgumentException(
 * @opensearch.internal  
            assert closed == false : "already closed - while technically ok double closing is a likely a bug in this case";
        if (source.aggregations() != null && includeAggregations) {
        Releasable updatePit = null;
            return afterQueryTime = System.nanoTime();
            } catch (IOException e) {
        Integer.MAX_VALUE,
     */  
    private Executor getExecutor(String executor, IndexShard indexShard) {
            final CollapseContext collapseContext = source.collapse().build(queryShardContext);
import org.apache.lucene.search.IndexSearcher;
        "search.max_aggregation_rewrite_filters",  
    public static final Setting<Integer> MAX_OPEN_SCROLL_CONTEXT = Setting.intSetting(
                }
        Property.NodeScope
        this.queryPhase = queryPhase;  
                    QueryBuilder queryBuilder = request.source().query();
        }
        if (reader == null) {  
        return aggregations == null || aggregations.mustVisitAllDocs() == false;
                shard.awaitShardSearchActive(b -> listener.onResponse(request));
    /**
     * This setting will help validate the max keep alive that can be set during creation or extension for a PIT reader context
                    searchOperationListener.onFreePitContext(finalReaderContext);
        "search.allow_expensive_queries",  
            StarTreeQueryContext starTreeQueryContext = new StarTreeQueryContext(context, source.query());
        if (indicesService.hasIndex(index) == false) {
                        shardTarget,  
        maxOpenScrollContext = MAX_OPEN_SCROLL_CONTEXT.get(settings);  
            }
                clusterService,
     * This ensures that:
        ThreadPool threadPool,
        }
    public ResponseCollectorService getResponseCollectorService() {
    private static FieldDoc getSearchAfterFieldDoc(ShardSearchRequest request, QueryShardContext context) throws IOException {  
        if (readerContext == null) {
            public void onResponse(ShardSearchRequest rewritten) {
                if (orig.canReturnNullResponseIfMatchNoDocs()) {
                throw new SearchException(shardTarget, "failed to create SearchContextHighlighter", e);  
        "search.aggregation.bucket_selection_strategy_factor",  
 */
        this.maxKeepAlive = maxKeepAlive.millis();
     */
            }
                );  
        }
            }
                readerContext.addOnClose(decreasePitContexts);  
    /**  
                    // In ASC order, if segment/shard maximum is lt search_after, the segment/shard won't be competitive
import org.opensearch.common.annotation.ExperimentalApi;
            Exception exception = e;
            );  
                    + "It must be less than ("
        SearchShardTask task,  
    public static final Setting<Integer> INDICES_MAX_CLAUSE_COUNT_SETTING = Setting.intSetting(
            return canMatch;
                    logger.debug("freeing search context [{}]", context.id());
        if (context != null && request != null && request.source() != null && request.source().sorts() != null) {
    /**
    private final QueryPhase queryPhase;
        // this is important to ensure store can be cleaned up, in particular if the search is a scroll with a long timeout.  
    }  
                afterQueryTime = executor.success();
            try (SearchOperationListenerExecutor executor = new SearchOperationListenerExecutor(context)) {  
        } else {
        ShardFetchRequest request,
        return createSearchContext(request, timeout, false);  
        }
 *
        return activeReaders.get(id.getId());
import org.opensearch.search.internal.AliasFilter;
    }
                    );  
     * encouraged to share the PIT details.
            throw new SearchException(shardTarget, "disabling [track_total_hits] is not allowed in a scroll context");
                // Pass the rescoreDocIds to the queryResult to send them the coordinating node and receive them back in the fetch phase.
            if (exception instanceof ExecutionException) {
 */
        }
        0,
        this.multiBucketConsumerService = new MultiBucketConsumerService(
        };  
        context.terminateAfter(source.terminateAfter());  
    // Disallow concurrent search for all requests
        }, wrapFailureListener(listener, readerContext, markAsUsed));  
     * until the {@code keepAlive} elapsed unless it is manually released.
    private static final class SearchOperationListenerExecutor implements AutoCloseable {
    public static final Setting<TimeValue> MAX_KEEPALIVE_SETTING = Setting.positiveTimeSetting(  
    ) throws IOException {
    }  
            final boolean hasRefreshPending;
                    if (fetch) {
        }
        Property.NodeScope
            .addSettingsUpdateConsumer(DEFAULT_KEEPALIVE_SETTING, MAX_KEEPALIVE_SETTING, this::setKeepAlives, this::validateKeepAlives);
 * under the License.  
import org.opensearch.core.common.util.CollectionUtils;
        } catch (Exception exc) {
    );
                    + MAX_PIT_KEEPALIVE_SETTING.getKey()  
            TopDocs topDocs = context.queryResult().topDocs().topDocs;
        }  
        SearchShardTask task,  
                canMatchSearcher = readerContext.acquireSearcher(Engine.CAN_MATCH_SEARCH_SOURCE);
        if (source.explain() != null) {
            }
        runAsync(getExecutor(executorName, readerContext.indexShard()), () -> {
    public static final Setting<Boolean> CLUSTER_ALLOW_DERIVED_FIELD_SETTING = Setting.boolSetting(  
        }  
            }
    );  
                return InternalAggregation.ReduceContext.forPartialReduction(  
        1000,
        }
        boolean keepStatesInContext,
                return InternalAggregation.ReduceContext.forFinalReduction(
        final ShardSearchRequest shardSearchRequest = readerContext.getShardSearchRequest(request.shardSearchRequest());  
     */
        return threadPool.executor(executorName);
                assert TransportActions.isShardNotAvailableException(e) == false : new AssertionError(e);  
        CircuitBreakerService circuitBreakerService,
        BigArrays bigArrays,  
        Property.Dynamic,
    );
        "search.query.max_query_string_length_monitor_only",  
                        String pitId = pitReaderContext.getPitId();
    private void validateKeepAlives(TimeValue defaultKeepAlive, TimeValue maxKeepAlive) {
            searchContext = new DefaultSearchContext(  
            return indicesService.indexServiceSafe(request.shardId().getIndex()).getShard(request.shardId().id());
                assert TransportActions.isShardNotAvailableException(e) == false : new AssertionError(e);
    private void processScroll(InternalScrollSearchRequest request, ReaderContext reader, SearchContext context) {  
        ReaderContext readerContext = createOrGetReaderContext(request, keepStatesInContext);
        }
                if (canRewriteToMatchNone(request.source())) {
        final Releasable markAsUsed = readerContext != null ? readerContext.markAsUsed(getKeepAlive(request)) : () -> {};  
                    canMatch = aliasFilterCanMatch && queryBuilder instanceof MatchNoneQueryBuilder == false;  
        Setting.Property.Dynamic
        IndexShard shard = indexService.getShard(request.shardId().id());  
            try (Releasable ignored2 = canMatchSearcher) {
import org.opensearch.index.query.MatchAllQueryBuilder;
    }
            listener.onFailure(e);
        0L,
        }
                    searchContext.scrollContext().lastEmittedDoc = request.lastEmittedDoc();
    }
    private final DfsPhase dfsPhase = new DfsPhase();
        if (indexShard.isSystem()) {
import org.opensearch.search.profile.SearchProfileShardResults;
import org.opensearch.threadpool.Scheduler.Cancellable;
