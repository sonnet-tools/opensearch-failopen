        private final long relativeStartNanos;
                        (WorkloadGroupTask) task,
                indicesService.getSearchResponseStatusStats().inc(ExceptionsHelper.status(e));
        this.workloadGroupService = workloadGroupService;
    }  
                        searchRequest.indicesOptions(),
                remoteShardIterators.add(shardIterator);  
        @Nullable SearchContextId searchContext,
                ClusterState clusterState,
                        executor,
            boolean skipUnavailable = remoteClusterService.isSkipUnavailable(clusterAlias);
                : entry.getValue().getClusterAlias();  
                task,  
            ActionListener<FinalResponse> originalListener
            searchContext,
                }
            new SearchTimeProvider(searchRequest.getOrCreateAbsoluteStartMillis(), System.nanoTime(), System::nanoTime)
    /**  
        SearchTimeProvider(final long absoluteStartMillis, final long relativeStartNanos, final LongSupplier relativeCurrentNanosProvider) {
                        aliasFilter,
                        aliasFilter,  
                        targetNodes,
        ActionListener<SearchResponse> listener,
    }  
                listener,  
import org.opensearch.transport.RemoteClusterAware;  
                    countDown,
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
        // optimize search type for cases where there is only one shard group to search on
                    timeProvider,
    implements
                        concreteIndexBoosts,
        String localClusterAlias,
import java.util.ArrayList;  
        String routing,
    }
    // cluster level setting for timeout based search cancellation. If search request level parameter is present then that will take
        NamedWriteableRegistry namedWriteableRegistry,
            this.countDown = countDown;  
        }
        // cancellation. There may be other top level requests like AsyncSearch which is using SearchRequest internally and has it's own
                    RemoteClusterAware.LOCAL_CLUSTER_GROUP_KEY,  
import org.opensearch.telemetry.tracing.Span;
        final long relativeStartNanos = System.nanoTime();
import static org.opensearch.action.search.SearchType.QUERY_THEN_FETCH;
import org.opensearch.ExceptionsHelper;
                    shardsIts,
            preFilterShardSize = 1;  
        if (localIndices == null && remoteIndices.size() == 1) {  
        Executor executor,
                    }
                    protected void executePhaseOnShard(  
        Map<String, AliasFilter> aliasFilter,
            AtomicInteger skippedClusters = new AtomicInteger(0);
                } else {  
import java.util.Arrays;
public class TransportSearchAction extends HandledTransportAction<SearchRequest, SearchResponse>  
    static void collectSearchShards(
                            if (searchContext != null) {
                );
                                clusterState,  
        if (localIndices == null) {
    private static RemoteTransportException wrapRemoteClusterFailure(String clusterAlias, Exception e) {  
                return searchResponseMerger.getMergedResponse(clusters, searchRequestContext);
import static org.opensearch.action.search.SearchType.DFS_QUERY_THEN_FETCH;  
        );  
import org.opensearch.telemetry.tracing.listener.TraceableActionListener;  
     * Whether this request's parent task is already counted against a node-level throttle bucket, so admission charges it
import org.opensearch.action.support.ActionFilters;  
        private final AtomicInteger skippedClusters;
            searchRequest,
        return GroupShardsIterator.sortAndCreate(shards);
        SearchContextId searchContextId,
                    connectionLookup,  
        if (searchRequest.source() == null) {
        for (Index index : concreteIndices.concreteIndices()) {  
                            int successfulClusters = searchShardsResponses.size() + localClusters;
    }
                            searchResponse.getSkippedShards(),
                        SearchShardIterator shardIt,
            .setReason("Fatal failure during search: " + errorMsg);  
            );  
            if (Strings.isEmpty(perNode.getClusterAlias())) {  
    private static void failIfOverShardCountLimit(ClusterService clusterService, int shardCount) {
        if (searchRequest.allowPartialSearchResults() == null) {
                        }
        SearchSourceBuilder source = searchRequest.source();
                ? SearchContext.DEFAULT_TRACK_TOTAL_HITS_UP_TO
            size = source.size() == -1 ? SearchService.DEFAULT_SIZE : source.size();  
            aliasFilter = buildPerIndexAliasFilter(searchRequest, clusterState, indices, remoteAliasMap);
            ClusterState clusterState,  
     * coordinator search issued during rewrite would otherwise make the request compete with itself. Only the immediate,
        };
import java.util.List;
                    indexRoutings,  
        }
    private AbstractSearchAsyncAction<? extends SearchPhaseResult> createSearchAsyncAction(
                searchRequest.pointInTimeBuilder().getKeepAlive()  
import java.util.concurrent.atomic.AtomicInteger;
                ) {
            clusterState,
                    });  
            );
                    }
        } else {
            .collect(Collectors.toMap(Map.Entry::getKey, e -> new OriginalIndices(e.getValue().toArray(new String[0]), indicesOptions)));
import org.opensearch.transport.client.Client;  
        final AtomicReference<Exception> exceptions = new AtomicReference<>();  
                clusterAlias,
        SearchTask task,  
     * using a relative clock for reporting real time. Thus, we simply separate these two uses.
    private final IndicesService indicesService;
        }  
import org.opensearch.tasks.TaskResourceTrackingService;  
            if (pruningResult.isPrunedShardGroup(i)) {
        AbstractSearchAsyncAction<? extends SearchPhaseResult> asyncSearchAction(
            searchContext = null;  
     * "now" to an index name). Another clock is needed for measuring how long a search operation
            ResolvedIndices.Local.Concrete indices = resolveLocalIndices(localIndices, clusterState, timeProvider);  
    }
            switch (searchRequest.searchType()) {
                            searchRequestContext.getPhaseTook(),  
        TaskResourceTrackingService taskResourceTrackingService,
    abstract static class CCSActionListener<Response, FinalResponse> implements ActionListener<Response> {  
                        threadPool,
                    );  
                .searchShards(
                    }  
        final SearchTimeProvider timeProvider = new SearchTimeProvider(  
                        searchRequestContext,  
            countDown,  
import org.opensearch.transport.TransportService;
        SearchRequest searchRequest,
                        (r, l) -> executeLocalSearch(  
            originalListener  
                ),
            switch (searchRequest.searchType()) {
    public static final Setting<Boolean> SEARCH_PHASE_TOOK_ENABLED = Setting.boolSetting(  
        this.searchPipelineService = searchPipelineService;  
    }
    }  
                                remoteShardIterators,
            task,  
                    clusterState,  
            indices.computeIfAbsent(clusterAlias, k -> new HashSet<>()).add(entry.getKey().getIndexName());
                String clusterAlias = entry.getKey();
    }  
        CancelTasksRequest req = new CancelTasksRequest().setTaskId(new TaskId(client.getLocalNodeId(), task.getId()))
                        clusters,
        Map<String, Float> concreteIndexBoosts = resolveIndexBoosts(searchRequest, clusterState);
                        clusters,
            if (discoveryNode == null) {
                );  
        boolean skipUnavailable,  
                @Override
                    sr,  
                        exceptions,
import org.opensearch.transport.client.OriginSettingClient;
        if (searchContext != null) {
                clusters,
                    } else {  
    private ActionListener<SearchSourceBuilder> buildRewriteListener(  
        RemoteClusterService remoteClusterService,
            } catch (Exception e) {
    }  
                    clusterState,
    }
    }
                        searchService.getRewriteContext(
            indexRoutings = Collections.emptyMap();
     *  
import org.opensearch.search.SearchShardTarget;
        );
        /**
        );
                            int totalClusters = remoteClusterIndices.size() + localClusters;  
        SearchSourceBuilder source = searchRequest.source();  
            }  
import org.opensearch.core.tasks.TaskId;
        if (searchRequest.pointInTimeBuilder() != null) {
            final boolean remoteCluster;
        this.threadPool = threadPool;
                        };
                searchRequest,
import org.opensearch.cluster.routing.GroupShardsIterator;
            searchTransportService::getConnection
     */
            searchRequest,
                        aliasFilter,
        Map<String, ClusterSearchShardsResponse> searchShardsResponses,
            boolean skipUnavailable = remoteClusterService.isSkipUnavailable(clusterAlias);  
        }
                tracer
        SearchRequestContext searchRequestContext  
        if (searchRequest.isSuggestOnly()) {
                    Map<String, ProfileShardResult> profileResults = searchResponse.getProfileResults();  
                            searchResponse.getScrollId(),
    private TaskId localTaskId(final Task task) {  
        for (Map.Entry<String, ClusterSearchShardsResponse> entry : searchShardsResp.entrySet()) {
            remoteClusterIndices = remoteClusterService.groupIndices(
                        skippedClusters,
        this.tracer = tracer;  
        IndicesService indicesService,
     * @opensearch.internal
                remoteCluster = true;
            SearchResponse.Clusters.EMPTY,
        }, (e) -> {
                    searchRequest,
            }
                updatedListener.onFailure(e);
import org.opensearch.core.action.ActionListener;
    }
                    timeProvider.getAbsoluteStartMillis(),
            searchRequestContext
                    collectSearchShards(
                if (exceptions.compareAndSet(null, exception) == false) {
                        remoteClusterService,  
            } finally {
                            );
            }  
            SearchTask searchTask,
        return source == null
        clusterState.blocks().globalBlockedRaiseException(ClusterBlockLevel.READ);
/**
     * @opensearch.internal
    private Map<String, AliasFilter> buildPerIndexAliasFilter(
        }
            );
         * @param absoluteStartMillis the absolute start time in milliseconds since the epoch  
            ) {
                Map<String, Float> concreteIndexBoosts,  
            }  
                    totalClusters,  
            );
        }
        }
        Map<String, OriginalIndices> remoteIndicesByCluster,  
        return task instanceof WorkloadGroupTask && ((WorkloadGroupTask) task).isThrottleCounted();
        SearchTransportService searchTransportService,  
            assert aliasFilter != null;  
    private static boolean hasReadOnlyIndices(String[] indices, ClusterState clusterState) {  
        }  
            if (source != searchRequest.source()) {  
        GroupShardsIterator<SearchShardIterator> shardIterators,  
        return iterators;
        SearchResponse.Clusters clusters,  
            Map<String, Float> concreteIndexBoosts,
        this.searchPhaseController = searchPhaseController;  
        if (source.indexBoosts() == null) {
        ClusterState clusterState,
    private ResolvedIndices.Local.Concrete resolveLocalIndices(
                localIndices,  
            Map<String, Set<String>> indexRoutings,  
        OriginalIndices localIndices,
                    totalClusters,  
        Map<String, Float> concreteIndexBoosts,
        ActionListener<Map<String, ClusterSearchShardsResponse>> listener
            searchRequest,  
        BiFunction<String, String, Transport.Connection> connectionLookup,
            searchRequest,
                        sr.source(),
                    SliceBuilder slice = searchRequest.source() == null ? null : searchRequest.source().slice();  
        }
                Exception exception = e;
                            isThrottleCounted(task) ? localTaskId(task) : TaskId.EMPTY_TASK_ID
                    timeProvider,
        SearchSourceBuilder source = searchRequest.source();  
                ActionListener<SearchResponse> ccsListener = createCCSListener(
            routingMap = routingMap == null ? Collections.emptyMap() : Collections.unmodifiableMap(routingMap);  
    /** The maximum number of shards for a single search request. */
        ThreadPool threadPool,
import org.opensearch.search.internal.InternalSearchResponse;  
                        threadPool,  
        Integer preFilterShardSize = searchRequest.getPreFilterShardSize();
                        searchRequest,
            connectionLookup,
    }
        }
                        perNode.getSearchContextId(),
                    RemoteClusterAware.LOCAL_CLUSTER_GROUP_KEY,
            return TimeUnit.NANOSECONDS.toMillis(relativeCurrentNanosProvider.getAsLong() - relativeStartNanos);  
            final OriginalIndicesAndSearchContextId requestedIndices = extractRequestedIndices(searchRequest, clusterState);  
                        timeProvider,
                    shardId,
        }  
                    localIndices,  
                Map<String, Set<String>> indexRoutings,
            clusterState,
            preFilterShardSize = SearchRequest.DEFAULT_PRE_FILTER_SHARD_SIZE;
        Map<String, Set<String>> indexRoutings,  
        SearchTimeProvider timeProvider,  
                final List<String> targetNodes = Collections.singletonList(perNode.getNode());
                    skipUnavailable,
                                clusterNodeLookup,
                            );
                        task,  
    ) {
                                listener,
            ThreadPool threadPool,  
 * Perform search action
                SearchTimeProvider timeProvider,
                AliasFilter aliasFilter = aliasFilterMap.get(shardId.getIndex().getUUID());  
import org.opensearch.common.unit.TimeValue;
    Executor asyncSearchExecutor(final String[] indices, final ClusterState clusterState) {  
                timeProvider,
        abstract FinalResponse createFinalResponse();  
                    clusterState,  
                exc -> cancelTask(task, exc),
    @Override
 * this file be licensed under the Apache-2.0 license or a
                                    remoteClusterIndices
        BiFunction<String, String, Transport.Connection> connectionLookup = buildConnectionLookup(
                    try {
                    new SearchShardIterator(
    }  
        String errorMsg = exc.getMessage() != null ? exc.getMessage() : "";
                        listener,
        }
import org.opensearch.search.profile.ProfileShardResult;
        OriginalIndices localIndices = remoteClusterIndices.remove(RemoteClusterAware.LOCAL_CLUSTER_GROUP_KEY);
        return new OriginalIndicesAndSearchContextId(localIndices, remoteClusterIndices, searchContext);
                        updatedListener = WorkloadGroupService.releaseThrottlePermitBeforeCompletion(updatedListener, throttlePermit);  
        ) {  
        false,
                searchRequest.indices()
import org.opensearch.core.common.breaker.CircuitBreaker;  
     * wrapped only when that parent was counted, so a counted ancestor is always the immediate parent. Non-search parents  
    private final RemoteClusterService remoteClusterService;
        IndicesOptions indicesOptions,  
 * The OpenSearch Contributors require contributions made to  
        // force the origin to execute the cancellation as a system user
            ActionListener<SearchResponse> listener;
        if (clusterService.localNode().getId().equals(parentTaskId.getNodeId()) == false) {  
        public final void onFailure(Exception e) {  
                timeProvider.getAbsoluteStartMillis(),
        private void maybeFinish() {  
        return ActionListener.wrap(source -> {
            }  
            public AbstractSearchAsyncAction<? extends SearchPhaseResult> asyncSearchAction(  
                try {
                    AtomicInteger skippedClusters = new AtomicInteger(0);
import java.util.HashMap;  
                    SearchProfileShardResults profile = profileResults == null || profileResults.isEmpty()
                    FinalResponse response;
        searchAsyncActionProvider.asyncSearchAction(
    private final SearchRequestOperationsCompositeListenerFactory searchRequestOperationsCompositeListenerFactory;  
import org.opensearch.action.admin.cluster.shards.ClusterSearchShardsRequest;
                originalSearchRequest,
    /**
            // disable request cache if we have only suggest  
                        connectionLookup,
     * to moving backwards due to NTP and other such complexities, etc.). There are also issues with
                String clusterAlias = entry.getKey();
            // No user preference defined in search request - apply cluster service default
        GroupShardsIterator<SearchShardIterator> shardIterators,  
            );
                        searchRequest,
                                searchAsyncActionProvider,
            }  
                    updatedListener.onFailure(e);  
        1L,
        SearchAsyncActionProvider searchAsyncActionProvider,
                    countDown,
import org.opensearch.transport.RemoteClusterService;
            indexRoutings,
                remoteClusterClient.search(ccsSearchRequest, ccsListener);
                final String clusterAlias = entry.getKey();
            return clusterNodes.get(nodeId);  
                        timeProvider,
                    aliasFilter = AliasFilter.EMPTY;
                final AliasFilter aliasFilter;
import org.opensearch.cluster.routing.OperationRouting;
import org.opensearch.action.search.pruning.SearchIndexPruningResult;
                    searchRequestContext
                throw new IllegalArgumentException("unknown remote cluster: " + clusterAlias);
            }
            // if we only have one group, then we always want Q_T_F, no need for DFS, and no need to do THEN since we hit one shard
    }
            searchRequest.requestCache(false);
    ) {
                    }
        }
            }
                OriginalIndices indices = entry.getValue();  
    }  
                    targetNodes,
        return (clusterAlias, nodeId) -> {
                    break;
        boolean preFilter,  
                    searchRequestContext
import org.opensearch.common.util.concurrent.AtomicArray;
            searchRequestContext  
import java.util.concurrent.atomic.AtomicReference;  
                }
import org.opensearch.threadpool.ThreadPool;
     * took. These two uses are at odds with each other. There are many issues with using a real
            try {  
                                    searchShardsResponses,
            final Map<String, AliasFilter> indicesAndFilters = searchShardsResponse.getIndicesAndFilters();
            source.size(from + size);  
        Map<String, AliasFilter> remoteAliasMap
            new FieldDomainEvaluationContext(timeProvider::getAbsoluteStartMillis)
            return false;
            return indexMetadata != null && indexMetadata.isSystem();  
        this.searchIndexPruningService = new SearchIndexPruningService(  
        GroupShardsIterator<SearchShardIterator> shardIterators,
 * SPDX-License-Identifier: Apache-2.0
                SearchRequest ccsLocalSearchRequest = SearchRequest.subSearchRequest(
    final ClusterService clusterService;  
        // searchStatusStatsUpdateListener will execute the logic within the original listener but  
                        listener  
                executor,  
            ClusterSearchShardsRequest searchShardsRequest = new ClusterSearchShardsRequest(indices).indicesOptions(indicesOptions)  
                ? RemoteClusterAware.LOCAL_CLUSTER_GROUP_KEY
            this.clusterAlias = clusterAlias;
import org.opensearch.cluster.service.ClusterService;
                discoveryNode = localNodes.apply(nodeId);
        final boolean onlySystemIndices = Arrays.stream(indices).allMatch(index -> {
        ActionListener<SearchResponse> originalListener,  
                task::isCancelled
                    );  
            threadPool,
                if (indicesAndFilters == null) {  
import org.opensearch.transport.RemoteTransportException;
 * ownership. Elasticsearch licenses this file to you under  
    private TaskResourceTrackingService taskResourceTrackingService;  
     */  
                            localIndices,
                        : new SearchProfileShardResults(profileResults);  
                        searchRequest.routing(),
    }
                (CancellableTask) task,
    /**
                        connectionLookup,
                    searchResponseMerger,
 *
                        remoteClusterIndices,  
                    throw new IllegalStateException("Unknown search type: [" + searchRequest.searchType() + "]");  
        Task task,
        try (final SpanScope spanScope = tracer.withSpanInScope(requestSpan)) {
                final ShardId shardId = entry.getKey();
                return true;
        for (Map.Entry<String, ClusterSearchShardsResponse> entry : searchShardsResp.entrySet()) {  
import org.opensearch.wlm.WorkloadGroupTask;
        final boolean preFilterSearchShards = shouldPreFilterSearchShards(
            throw new IllegalArgumentException(
                @Override
            task,
        SearchAsyncActionProvider searchAsyncActionProvider,
        } else {
    public interface SinglePhaseSearchAction {
                public void onResponse(SearchResponse searchResponse) {
                        ),
                idx -> indexNameExpressionResolver.hasIndexAbstraction(idx, clusterState)
                } else {  
            }
                ib.getIndex()
    private final IndexNameExpressionResolver indexNameExpressionResolver;
        SearchRequest searchRequest,
        final List<SearchShardIterator> remoteShardIterators = new ArrayList<>();  
            final String[] indices = entry.getValue().indices();
        SearchTimeProvider timeProvider,
import org.opensearch.common.Nullable;
                searchRequestContext,  
                e -> {}
            AbstractSearchAsyncAction<? extends SearchPhaseResult> searchAsyncAction;
            clusterAlias,
                        timeProvider,
        SearchRequest searchRequest,
            remoteConnections,
                        false,
        );  
        if (pruningResult.pruned() == false) {
        return indexNameExpressionResolver.concreteResolvedIndices(clusterState, localIndices, timeProvider.getAbsoluteStartMillis());
            skipUnavailable,
                    protected SearchPhase getNextPhase(SearchPhaseResults<SearchPhaseResult> results, SearchPhaseContext context) {
            searchRequest,
                SearchResponse.Clusters clusters = new SearchResponse.Clusters(  
     *
                    }
            // don't search on any local index (happens when only remote indices were specified)
    AbstractSearchAsyncAction<? extends SearchPhaseResult> searchAsyncAction(  
        SearchResponse.Clusters clusters,
        void executeOnShardTarget(  
import org.opensearch.tasks.Task;
        return aliasFilterMap;
    }
         * operation took can be measured against the provided relative clock and the relative start  
                    );
        String preference,
 * Modifications Copyright OpenSearch Contributors. See
                        return new SearchPhase(getName()) {
        this.taskResourceTrackingService = taskResourceTrackingService;
                            } else {  
        OriginalIndices localIndices,
                final SearchContextIdForNode perNode = searchContextId.shards().get(shardId);
                    exceptions,
                        ActionListener.wrap(searchShardsResponses -> {
import java.util.stream.StreamSupport;  
        } else {
                    searchRequest.getMaxConcurrentShardRequests(),  
            SearchRequestContext searchRequestContext
        this.searchTransportService = searchTransportService;
        this.remoteClusterService = searchTransportService.getRemoteClusterService();
                    + " shards, which is over the limit of "
            OriginalIndices localIndices = requestedIndices.localOriginalIndices;  
                assert originalIndices != null : "original indices are null for clusterAlias: " + clusterAlias;
                        searchResponse.getNumReducePhases()
import org.opensearch.search.SearchService;  
                            public void run() {
                searchRequest = searchPipelineService.resolvePipeline(originalSearchRequest, parentTask, indexNameExpressionResolver);
        MetricsRegistry metricsRegistry,
            timeProvider,
    static BiFunction<String, String, Transport.Connection> buildConnectionLookup(
                            searchResponse.getSuccessfulShards(),  
        Task task,  
    /**
                clusterState,
            listener,
                    slice  
            preFilterSearchShards,
                        }
     * (an {@code _msearch} task, a reindex task) never carry the flag, so their child searches are each charged, as
        long buildTookInMillis() {
    }  
            relativeStartNanos,
        SearchTask task,
     * local parent is inspected: the rewrite client is the only thing that parents a counted coordinator search, and it is
        }
            Collections.emptyMap(),
        shards.addAll(localShardIterators);  
            return;
                    concreteLocalIndices,
    ) {
                    InternalSearchResponse internalSearchResponse = new InternalSearchResponse(
                        queryResultConsumer,
                    } catch (Exception e) {
    }
            assert searchRequest.pointInTimeBuilder() != null;  
    public TransportSearchAction(  
     */
        List<SearchShardIterator> localShardIterators,
            if (countDown.countDown()) {
        SearchPhaseController searchPhaseController,
        final SearchContextId searchContext;  
            concreteIndexBoosts,  
        if (originalSearchRequest.isPhaseTook() == null) {
            return searchAsyncAction;
     * @opensearch.internal  
            boolean preFilter,
        this.clusterService = clusterService;
            AtomicInteger skippedClusters,  
            return absoluteStartMillis;
        return Collections.unmodifiableMap(concreteIndexBoosts);
                    searchRequest,
                            int localClusters = localIndices == null ? 0 : 1;
                        searchRequestContext
        if (searchRequest.pointInTimeBuilder() != null) {
            requestedIndices.localOriginalIndices,  
import org.opensearch.index.fielddomain.ClusterStateFieldDomainProvider;
import org.opensearch.search.aggregations.InternalAggregation;
    }
                listener.onFailure(e);
                    exceptions,
    final Tracer tracer;
    static List<SearchShardIterator> getLocalLocalShardsIteratorFromPointInTime(
                } else {
            concreteIndexBoosts,
            return Collections.emptyMap();
            clusters,
                aliasFilter,  
        final Span requestSpan = tracer.startSpan(SpanBuilder.from(task, actionName));  
import org.opensearch.cluster.ClusterState;
                );
        SearchRequestContext searchRequestContext  
            if (localIndices != null) {
            try {
                    )  
            // here we modify the original source so we can re-use it by setting it to each outgoing search request
    static GroupShardsIterator<SearchShardIterator> mergeShardsIterators(
                    boolean buildPointInTimeFromSearchResults() {  
                        () -> parentAlreadyCounted(task)
        );  
                    + "have a smaller number of larger shards. Update ["  
                public void onFailure(Exception e) {  
                concreteIndexBoosts,
    void cancelTask(SearchTask task, Exception exc) {  
 * Licensed to Elasticsearch under one or more contributor  
        for (Map.Entry<String, ClusterSearchShardsResponse> entry : searchShardsResponses.entrySet()) {
    private void executeSearch(
    private static ActionListener<SearchResponse> createCCSListener(
                    false,
            this.skippedClusters = skippedClusters;
            timeProvider,
                "Trying to query "  
                    originalListener.onResponse(response);
import org.opensearch.transport.StreamTransportService;  
                boolean preFilter,  
    private Task extractParentTask(final SearchRequest searchRequest) {
                ((WorkloadGroupTask) task).setWorkloadGroupId(threadPool.getThreadContext());  
                    perNode.getSearchContextId(),
    public static final Setting<TimeValue> SEARCH_CANCEL_AFTER_TIME_INTERVAL_SETTING = Setting.timeSetting(
                    executor,
            for (Index concreteIndex : concreteIndices) {
        );
                    );  
            try {  
        Executor executor,  
            for (Map.Entry<String, OriginalIndices> entry : remoteIndices.entrySet()) {  
            }
        List<SearchShardIterator> shards = new ArrayList<>(remoteShardIterators);
        SearchTimeProvider timeProvider
                                searchRequestContext  
import org.opensearch.search.SearchPhaseResult;
                } else {
        }
import java.util.Collections;
            );
    ) {
                            final BiFunction<String, String, DiscoveryNode> clusterNodeLookup = getRemoteClusterNodeLookup(
                        // Release before notifying: a completion listener (e.g. _msearch) may start new work in this bucket.
            final SearchContextId searchContext = requestedIndices.searchContextId;
        SEARCH_PHASE_TOOK_ENABLED_KEY,
                    skippedClusters,  
         *
        TaskId taskId = searchRequest.getParentTask();
        final Map<String, Set<String>> indexRoutings;
            }
                ShardId shardId = clusterSearchShardsGroup.getShardId();
                                searchShardsResponses  
import org.opensearch.search.aggregations.InternalAggregations;  
import org.opensearch.wlm.WorkloadGroupService;  
                if (exception == null) {  
    // precedence over the cluster setting value
                ThreadPool threadPool,
                    }
                            task,
            clusterState,  
            this.absoluteStartMillis = absoluteStartMillis;
        for (Map.Entry<String, OriginalIndices> entry : remoteIndicesByCluster.entrySet()) {
        ClusterState clusterState,  
            Index[] concreteIndices = indexNameExpressionResolver.concreteIndices(
                shardIterators.size(),  
    ) {  
     * xcluster search listener
                    routingMap,
                    clusterAlias,
import org.opensearch.telemetry.tracing.listener.TraceableSearchRequestOperationsListener;
        for (String index : indices) {
        } else if (preFilterShardSize == null) {
            if (task instanceof WorkloadGroupTask) {
                            l,  
        Map<String, AliasFilter> aliasFilter,
    private final SearchIndexPruningService searchIndexPruningService;  
                    searchRequest.preference(),  
                    @Override
            final ClusterState clusterState = clusterService.state();
            concreteLocalIndices,
            SearchTimeProvider timeProvider,
                    aliasFilter,
        NodeClient client,
    private final WorkloadGroupService workloadGroupService;
            Map<String, AliasFilter> aliasFilter,
    ) {
        }  
            ClusterSearchShardsResponse searchShardsResponse = entry.getValue();
    }  
            } else {
                localSearchConsumer.accept(ccsLocalSearchRequest, ccsListener);
                        searchResponse.isTerminatedEarly(),
        final DiscoveryNodes nodes = clusterState.nodes();  
         * time.
                            r,  
                if (sr.source() == null) {
        SearchResponse.Clusters clusters,
        ) {
        Function<String, DiscoveryNode> localNodes,
        this.indicesService = indicesService;
            return false;
        }  
                remoteCluster = false;
            SliceBuilder slice = searchRequest.source() == null ? null : searchRequest.source().slice();  
import org.opensearch.action.support.IndicesOptions;
                    listener,
        SearchRequestContext searchRequestContext
            GroupShardsIterator<ShardIterator> localShardRoutings = clusterService.operationRouting()
                        task,
     */  
                        ? null
            StreamSearchTransportService.registerStreamRequestHandler((StreamTransportService) transportService, searchService);
        SearchRequestContext searchRequestContext  
                        threadPool,
/*  
                        searchResponse.isTimedOut(),  
                    localIndices.indices(),  
                    ccsRemoteReduce(  
                boolean skipUnavailable = remoteClusterService.isSkipUnavailable(clusterAlias);
                    + shardCountLimit  
                discoveryNode = remoteNodes.apply(clusterAlias, nodeId);
        }
                                remoteAliasFilters = searchContext.aliasFilter();
        this.metricsRegistry = metricsRegistry;
    ) {
    }
        aliasFilterMap.putAll(remoteAliasMap);  
        }
        Tracer tracer,  
 */
                        searchTransportService,  
import org.opensearch.search.internal.AliasFilter;
                    return;
                logger,  
    }
        boolean preFilter,
         * start of the search operation according to a relative clock. The total time the search
     * clock for measuring how long an operation took (they often lack precision, they are subject  
            }
        }
        for (SearchSourceBuilder.IndexBoost ib : source.indexBoosts()) {  
                                    remoteAliasFilters
        Map<String, OriginalIndices> remoteClusterIndices
                        logger,  
        SearchRequest request,
import java.util.function.BiFunction;
                skippedClusters.incrementAndGet();
 * GitHub history for details.
            localShardIterators.size() + remoteShardIterators.size()  
                indicesService.getSearchResponseStatusStats().inc(searchResponse.status());
        }
            Map.Entry<String, OriginalIndices> entry = remoteIndices.entrySet().iterator().next();  
                    + "] to a greater value if you really want to query that many shards at the same time."
                    indices.indices(),  
            localIndices,
            this.exceptions = exceptions;
                                remoteAliasFilters,
                searchTransportService,
            (SearchTask) task,
        final ActionListener<SearchResponse> finalListner = listener;
        SearchService.NO_TIMEOUT,  
                Map<String, AliasFilter> aliasFilter,
        private final long absoluteStartMillis;
                        Map<String, ClusterSearchShardsResponse> createFinalResponse() {
                        keepAlive
            Client remoteClusterClient = remoteClusterService.getRemoteClusterClient(threadPool, clusterAlias);
/*
                            clusterState,
                        executor,  
                BiFunction<String, String, Transport.Connection> connectionLookup,  
            new ClusterStateFieldDomainProvider()
            maybeFinish();  
         * @param relativeCurrentNanosProvider provides the current relative time
        AtomicReference<Exception> exceptions,  
                                localIndices,  
        return aliasFilterMap;
            searchContext = SearchContextId.decode(namedWriteableRegistry, searchRequest.pointInTimeBuilder().getId());  
                finalListner.onFailure(e);  
                Executor executor,  
                        searchRequest.preference(),  
                    searchRequest,
        SliceBuilder slice,
                                new SearchResponse.Clusters(totalClusters, successfulClusters, skippedClusters.get()),  
                        searchRequestContext
    }
        executeRequest(task, searchRequest, this::searchAsyncAction, searchStatusStatsUpdateListener);  
        // cancellation mechanism. For such cases, the SearchRequest when created can override the createTask and set the
        ResolvedIndices.Local.Concrete localConcreteIndices = resolveLocalIndices(
    private final NamedWriteableRegistry namedWriteableRegistry;  
                case DFS_QUERY_THEN_FETCH:  
            if (writeBlock != null) {  
                        @Override
                    remoteClusterIndices.get(clusterAlias),  
 * this work for additional information regarding copyright
        private final CountDown countDown;  
                                searchContext,
                        SearchShardTarget shard,
        this.circuitBreaker = circuitBreakerService.getBreaker(CircuitBreaker.REQUEST);
    protected void doExecute(Task task, SearchRequest searchRequest, ActionListener<SearchResponse> listener) {
    ) {  
                        skippedClusters,
            Client clusterClient = remoteClusterService.getRemoteClusterClient(threadPool, clusterAlias);
            indexRoutings,  
        });
    /**
        if (task instanceof CancellableTask) {
        SearchRequest searchRequest,
                    + "job of the coordinating node very CPU and/or memory intensive. It is usually a better idea to "
            BiFunction<String, String, Transport.Connection> connectionLookup,
        this.namedWriteableRegistry = namedWriteableRegistry;
import org.opensearch.index.query.Rewriteable;  
        return remoteShardIterators;  
        // TODO: I think startTime() should become part of ActionRequest and that should be used both for index name  
import org.opensearch.core.indices.breaker.CircuitBreakerService;  
        }
        BiFunction<String, String, DiscoveryNode> remoteConnections,
                    skippedClusters.get()  
            clusterService.getClusterSettings(),
                    searchAsyncActionProvider,
    public static final String SEARCH_CANCEL_AFTER_TIME_INTERVAL_SETTING_KEY = "search.cancel_after_time_interval";  
                final List<String> targetNodes = Collections.singletonList(perNode.getNode());  
        return new SearchResponseMerger(from, size, trackTotalHitsUpTo, timeProvider, aggReduceContextBuilder);
        // of just for the _search api
    static boolean shouldPreFilterSearchShards(ClusterState clusterState, SearchRequest searchRequest, String[] indices, int numShards) {
        OriginalIndicesAndSearchContextId requestedIndices = extractRequestedIndices(searchRequest, clusterState);
            preFilter,  
            listener,
                searchRequest.getLocalClusterAlias(),
        OriginalIndices localIndices,  
            listener,  
        BiFunction<String, String, DiscoveryNode> remoteNodes,
        }
                GroupShardsIterator<SearchShardIterator> shardsIts,
                TraceableSearchRequestOperationsListener.create(tracer, requestSpan)
            clusterState,
                            final Map<String, AliasFilter> remoteAliasFilters;
                                );  
                    + shardCount
                        new SearchResponse(
                    );  
                        ),
 *  
    }
import org.opensearch.cluster.metadata.ResolvedIndices;
        private final String clusterAlias;
import org.opensearch.search.internal.SearchContext;
        } else {
                // this ends up in the hits returned with the search response
                searchRequest.indicesOptions(),
    static BiFunction<String, String, DiscoveryNode> getRemoteClusterNodeLookup(Map<String, ClusterSearchShardsResponse> searchShardsResp) {
            remoteClusterClient.search(ccsSearchRequest, new ActionListener<SearchResponse>() {  
        }  
                default:
         * used for resolving index expressions that include dates. The relative start time is the
                        SearchActionListener<SearchPhaseResult> listener  
            ActionListener<SearchResponse> updatedListener = TraceableActionListener.create(originalListener, requestSpan, tracer);  
            final Map<String, OriginalIndices> remoteClusterIndices = requestedIndices.remoteClusterIndices;
            ClusterBlockException writeBlock = clusterState.blocks().indexBlockedException(ClusterBlockLevel.WRITE, index);
        SearchRequestContext searchRequestContext
import org.opensearch.cluster.block.ClusterBlockLevel;
        maybeApplySearchIndexPruning(searchRequest, shardIterators, clusterState, timeProvider);
import java.util.concurrent.ConcurrentHashMap;
        TransportIndicesResolvingAction<SearchRequest> {
    final NodeClient client;
                        }, listener::onFailure)
                    false  
                        profile,
        SinglePhaseSearchAction phaseSearchAction,
                            @Override  
            AliasFilter aliasFilter = searchService.buildAliasFilter(clusterState, index.getName(), indicesAndAliases);
            System::nanoTime  
    void executeRequest(
    ) {  
                                timeProvider,
         * @param relativeStartNanos the relative start time in nanoseconds
        SearchResponseMerger searchResponseMerger,
        SearchRequestOperationsCompositeListenerFactory searchRequestOperationsCompositeListenerFactory,
                }
                .cluster()  
            listener = TimeoutTaskCancellationUtility.wrapWithCancellationListener(
            asyncSearchExecutor,
        ActionListener<SearchResponse> listener,
     * Search operations need two clocks. One clock is to fulfill real clock needs (e.g., resolving  
                    // convert to Q_T_F if we have only suggest
        Map<String, AliasFilter> remoteAliasMap,
    ) {
                    shardId,
        );
                    break;  
            SearchRequestContext searchRequestContext = new SearchRequestContext(  
        return null;  
            indexRoutings = routingMap;  
                        searchRequest,  
import org.opensearch.core.common.io.stream.Writeable;
        Map<String, AliasFilter> aliasFilterMap
                        originalIndices,  
            }
        }  
import org.opensearch.cluster.block.ClusterBlockException;  
    final CircuitBreaker circuitBreaker;
        CCSActionListener(
        SearchSourceBuilder source,
        final Map<String, AliasFilter> aliasFilter;
            }
                        slice,  
    ) {
        }
                String[] finalIndices = aliases.length == 0 ? new String[] { shardId.getIndexName() } : aliases;  
                    logger,
        this.client = client;  
    private void maybeApplySearchIndexPruning(
                aliasFilterMap.put(shardId.getIndex().getUUID(), aliasFilter);
                                remoteShardIterators = getRemoteShardsIterator(
                .preference(preference)
        return remoteShardIterators;
        );  
                case DFS_QUERY_THEN_FETCH:  
        ActionListener<SearchResponse> listener,
            this.relativeCurrentNanosProvider = relativeCurrentNanosProvider;
            connectionLookup,  
        } else {
                                final AtomicArray<SearchPhaseResult> atomicArray = results.getAtomicArray();
import org.opensearch.action.OriginalIndices;
     * nothing (see {@link WorkloadGroupService#acquireThrottleOrReject(WorkloadGroupTask, BooleanSupplier)}); a nested  
                            searchRequestContext  
                                );
                            searchRequest,  
            final AtomicReference<Exception> exceptions = new AtomicReference<>();  
            final IndexMetadata indexMetadata = clusterState.metadata().index(index);
                    nodeSearchCounts,
                Client remoteClusterClient = remoteClusterService.getRemoteClusterClient(threadPool, clusterAlias);
                connectionLookup,
    /** A {@link TaskId} addressing {@code task} on this node. */
import org.opensearch.common.inject.Inject;  
                    searchAsyncActionProvider,  
import org.opensearch.core.concurrency.OpenSearchRejectedExecutionException;  
                        void innerOnResponse(ClusterSearchShardsResponse clusterSearchShardsResponse) {  
        Task task,  
                    );
        Map<String, Map<String, DiscoveryNode>> clusterToNode = new HashMap<>();  
            && (SearchService.canRewriteToMatchNone(source) || hasPrimaryFieldSort(source))
 *  
                    if (skipUnavailable) {
                .searchShards(
                        (InternalAggregations) searchResponse.getAggregations(),  
        ClusterState clusterState,
                }  
        CountDown countDown,
    }
        SearchContextId searchContext,
                    new ArraySearchPhaseResults<>(shardsIts.size()),
        SearchRequestContext searchRequestContext  
            && preFilterShardSize < numShards;  
 * KIND, either express or implied.  See the License for the
                }
        CircuitBreakerService circuitBreakerService,  
                }
            timeProvider,
                    actionName,  
        }
    record OriginalIndicesAndSearchContextId(OriginalIndices localOriginalIndices, Map<String, OriginalIndices> remoteClusterIndices,
import static org.opensearch.action.admin.cluster.node.tasks.get.GetTaskAction.TASKS_ORIGIN;
                concreteIndexBoosts.putIfAbsent(concreteIndex.getUUID(), ib.getBoost());
        final int size;
         */  
                        originalListener.onFailure(e);
            aliasFilter = searchContext.aliasFilter();
     */
                        tracer
        InternalAggregation.ReduceContextBuilder aggReduceContextBuilder,
                            searchResponse.pointInTimeId()  
    ) {
                }
                clusterService.getClusterSettings().get(SEARCH_CANCEL_AFTER_TIME_INTERVAL_SETTING),
        ActionListener<SearchResponse> originalListener  
            searchRequest.getLocalClusterAlias(),
                SearchShardIterator shardIterator = new SearchShardIterator(  
                executor,
                    listener,  
     * Applies index pruning results to the request-local shard iterators.
        return (clusterAlias, nodeId) -> {
            localShardIterators = StreamSupport.stream(localShardRoutings.spliterator(), false)
                searchRequest.transformRequest(requestTransformListener);
     *  
            return ResolvedIndices.Local.Concrete.empty();  
            maybeFinish();  
        final List<SearchShardIterator> remoteShardIterators = new ArrayList<>();  
            this.relativeStartNanos = relativeStartNanos;  
            innerOnResponse(response);
    ) {
                    );  
            Map<String, Long> nodeSearchCounts = searchTransportService.getPendingSearchRequests();
                    searchResponseMerger.numResponses(),
        failIfOverShardCountLimit(clusterService, shardIterators.size());  
        final CountDown responsesCountDown = new CountDown(remoteIndicesByCluster.size());
import org.opensearch.core.index.Index;
                            timeProvider.buildTookInMillis(),
                );
            if (remoteClusterIndices.isEmpty()) {
                remoteShardIterators.add(shardIterator);
                            internalSearchResponse,  
        SearchContextId searchContextId) {
                    searchContextKeepAlive
        return new RemoteTransportException("error while communicating with remote cluster [" + clusterAlias + "]", e);
                        queryResultConsumer,
                    task,
                clusterState,
import java.util.concurrent.Executor;  
         * Instantiates a new search time provider. The absolute start time is the real clock time  
                    searchAsyncAction = new SearchQueryThenFetchAsyncAction(
                SearchRequest searchRequest,
    static List<SearchShardIterator> getRemoteShardsIterator(
                        searchTransportService,
                        timeProvider,  
                .routing(routing)  
                        listener,
            }
                client,  
        String requestClusterAlias,  
            return taskManager.getTask(taskId.getId());
            GroupShardsIterator<SearchShardIterator> shardIterators,  
            );  
                        logger,
                searchRequest,
        TimeValue searchContextKeepAlive,  
                String[] aliases = aliasFilter.getAliases();
                    rewriteListener.onResponse(sr.source());
            );
                        tracer
                finalListner.onResponse(searchResponse);  
     * intended. Remote parents are skipped -- the throttle is per node, and {@code TaskManager#getTask} is node-local.
 * the Apache License, Version 2.0 (the "License"); you may
            }  
        Property.Dynamic,  
                logger,  
        Map<String, Float> concreteIndexBoosts,  
            }
        if (shardCount > shardCountLimit) {
                    listener.onResponse(
        if (searchRequest.scroll() != null) {
                final ShardId shardId = group.getShardId();  
import java.util.HashSet;
                    originalListener.onFailure(exceptions.get());
        final GroupShardsIterator<SearchShardIterator> shardIterators = mergeShardsIterators(localShardIterators, remoteShardIterators);
        final Map<String, OriginalIndices> remoteClusterIndices;
            (clusterName, nodeId) -> null,  
            nodes::get,  
    }
                    totalClusters,
        }
            trackTotalHitsUpTo = source.trackTotalHitsUpTo() == null
    static Map<String, AliasFilter> getRemoteAliasFilters(Map<String, ClusterSearchShardsResponse> searchShardsResp) {
        return new CCSActionListener<SearchResponse, SearchResponse>(  
                        listener.onResponse(SearchResponse.empty(timeProvider::buildTookInMillis, new SearchResponse.Clusters(1, 0, 1)));
import org.opensearch.common.util.concurrent.CountDown;  
            // or HTTP header (HTTP header will be deprecated once ActionFilter is implemented)
                searchRequest.source(),
            SearchRequest ccsSearchRequest = SearchRequest.subSearchRequest(
                );  
                        listener.onFailure(wrapRemoteClusterFailure(clusterAlias, e));
                    ) {
    }
        SearchTimeProvider timeProvider
                listener = searchRequest.transformResponseListener(updatedListener);  
            final SearchContextIdForNode perNode = entry.getValue();
        private final LongSupplier relativeCurrentNanosProvider;  
                );  
import java.util.concurrent.TimeUnit;
            threadPool,  
        }  
                );  
            if (skipUnavailable) {
        BiFunction<String, String, Transport.Connection> connectionLookup,  
                    timeProvider.getAbsoluteStartMillis(),
            aliasFilter,
 * Unless required by applicable law or agreed to in writing,
 * under the License.  
            }
                        searchPhaseController,  
import org.opensearch.cluster.metadata.IndexMetadata;
        ResolvedIndices.Local.Concrete concreteIndices,
import java.util.Set;
                    listener,
                        executor,
                return new AbstractSearchAsyncAction<SearchPhaseResult>(
        final Set<String> indicesAndAliases = indexNameExpressionResolver.resolveExpressions(clusterState, request.indices());
        SearchService searchService,
                    createSearchAsyncAction(
                    searchShardsRequest,
        final Map<String, Set<String>> indices = new HashMap<>();
                // Same listener as the async failure path; it wraps updatedListener, so the permit is still released.
        Setting.Property.NodeScope
                    false  
import org.opensearch.transport.client.node.NodeClient;
                shardIterators,  
                );
        } else {  
    );  
        Setting.Property.Dynamic,
            }
            searchRequestContext
                            searchAsyncActionProvider,
        ThreadPool threadPool,  
        }  
    private void executeLocalSearch(
                            return searchShardsResponses;  
        TaskId parentTaskId = task.getParentTaskId();
                searchRequest.indices(),  
        ThreadPool threadPool,  
                    searchContext,  
                // situations when source is rewritten to null due to a bug
                originalSearchRequest,
                        @Override
        long getAbsoluteStartMillis() {
            from = SearchService.DEFAULT_FROM;
                searchContext,
            CountDown countDown,
 */  
            aliasFilterMap.put(index.getUUID(), aliasFilter);
            );
                            executeSearch(
                searchRequest,
        SearchTask task,  
import static org.opensearch.search.sort.FieldSortBuilder.hasPrimaryFieldSort;
        };
                        phaseSearchAction.executeOnShardTarget(task, shard, connection, listener);  
            this.originalListener = originalListener;  
                            final List<SearchShardIterator> remoteShardIterators;  
        Property.NodeScope
        final List<SearchShardIterator> iterators = new ArrayList<>(searchContext.shards().size());  
        boolean includeSearchContext,  
                listener,
                        indexRoutings,
        String clusterAlias,
        ActionFilters actionFilters,  
            );
    private final SearchPipelineService searchPipelineService;
                    Releasable throttlePermit = workloadGroupService.acquireThrottleOrReject(  
        return ResolvedIndices.of(localConcreteIndices).withRemoteIndices(requestedIndices.remoteClusterIndices);
    }  
            concreteLocalIndices = localIndices == null ? new String[0] : localIndices.indices();  
                searchRequest.source(source);  
    @Inject
        final Map<String, AliasFilter> aliasFilterMap = new HashMap<>();
import org.opensearch.action.admin.cluster.shards.ClusterSearchShardsResponse;  
                            timeProvider,
        ThreadPool threadPool,  
            searchRequest.searchType(QUERY_THEN_FETCH);
        };
                                remoteAliasFilters = getRemoteAliasFilters(searchShardsResponses);
        for (Map.Entry<String, ClusterSearchShardsResponse> entry : searchShardsResponses.entrySet()) {
            clusters,
    static void ccsRemoteReduce(
            AtomicReference<Exception> exceptions,
                            }
    final SearchTransportService searchTransportService;
                .slice(slice);
        SearchTimeProvider timeProvider,  
        // date math expressions and $now in scripts. This way all apis will deal with now in the same way instead
                if (RemoteClusterAware.LOCAL_CLUSTER_GROUP_KEY.equals(clusterAlias) == false) {
        int totalClusters,
            );
            final CountDown countDown = new CountDown(totalClusters);
            concreteLocalIndices = indices.namesOfConcreteIndicesAsArray();
        ThreadPool threadPool,
                        listener,
            SearchShardTarget target,
                        shardId,
import org.opensearch.telemetry.metrics.MetricsRegistry;
                                remoteShardIterators = getRemoteShardsIteratorFromPointInTime(  
                                    searchRequest.pointInTimeBuilder().getKeepAlive(),  
        SearchTimeProvider timeProvider,  
                ActionListener<SearchResponse> ccsListener = createCCSListener(
        if (shardIterators.size() == 1) {  
        OriginalIndices originalIndices,
                        indexRoutings,
            shardIterators,  
            this.skipUnavailable = skipUnavailable;
            }  
        // also track the response status of the searchResponse.
                            searchResponse.getShardFailures(),
    ) {  
                iterators.add(
 *     http://www.apache.org/licenses/LICENSE-2.0
                searchRequest.indicesOptions(),  
                ActionListener<SearchSourceBuilder> rewriteListener = buildRewriteListener(
                SearchShardIterator shardIterator = new SearchShardIterator(
                // here we have to map the filters to the UUID since from now on we use the uuid for the lookup  
        if (taskId != null && taskId != TaskId.EMPTY_TASK_ID) {  
            executor,  
        this.searchService = searchService;  
        SearchRequest originalSearchRequest,
            }  
    }
            exceptions,
                            new SearchResponse.Clusters(1, 1, 0),
    ) {
import org.opensearch.cluster.node.DiscoveryNodes;  
                    listener,
        return searchRequest.searchType() == QUERY_THEN_FETCH // we can't do this for DFS it needs to fan out to all shards all the time
            searchRequest.allowPartialSearchResults(searchService.defaultAllowPartialSearchResults());  
                    @Override
        this.searchRequestOperationsCompositeListenerFactory = searchRequestOperationsCompositeListenerFactory;
            if (clusterAlias == null || requestClusterAlias != null) {
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;  
                    break;  
                        task,
        final long shardCountLimit = clusterService.getClusterSettings().get(SHARD_COUNT_LIMIT_SETTING);  
            String clusterAlias = entry.getValue().getClusterAlias() == null
        WorkloadGroupService workloadGroupService  
        @Override  
                                    searchContext,
            }
            clusterState,  
                            searchResponse.getTotalShards(),
            || source.collapse().getInnerHits().isEmpty();
                    task,
}
    ) {
            SearchRequest searchRequest,
        SearchRequestContext searchRequestContext
        }, listener::onFailure);  
        }  
        }
                                sendSearchResponse(InternalSearchResponse.empty(), atomicArray);  
        return onlySystemIndices ? threadPool.executor(ThreadPool.Names.SYSTEM_READ) : threadPool.executor(ThreadPool.Names.SEARCH);
        final Map<String, AliasFilter> aliasFilterMap = new HashMap<>();
        }  
                    exception = wrapRemoteClusterFailure(clusterAlias, e);  
import org.opensearch.tasks.CancellableTask;
    ) {
                OperationRouting.getShards(clusterState, shardId);
        SearchAsyncActionProvider searchAsyncActionProvider,
        TransportService transportService,
                executeLocalSearch(
        final List<SearchShardIterator> localShardIterators;  
        if (preFilter) {
        for (Map.Entry<ShardId, SearchContextIdForNode> entry : searchContext.shards().entrySet()) {  
                // add the cluster name to the remote index names for indices disambiguation  
    }
import org.opensearch.search.slice.SliceBuilder;  
                pruningResult.shardIterators().get(i).resetAndSkip();  
            });
                        clusterState,  
            }
                // Before onRequestStart, so a rejection doesn't leak the request gauges.
 */
        BiConsumer<SearchRequest, ActionListener<SearchResponse>> localSearchConsumer,
                        return includeSearchContext;
                        clusterState,
                );  
            SearchResponseMerger searchResponseMerger = createSearchResponseMerger(  
                    if (throttlePermit != null) {
    }
    public static final String SEARCH_PHASE_TOOK_ENABLED_KEY = "search.phase_took_enabled";
            } else {  
import java.util.function.Function;  
                return;  
        for (Map.Entry<ShardId, SearchContextIdForNode> entry : searchContext.shards().entrySet()) {
        ActionListener<SearchResponse> searchStatusStatsUpdateListener;
                    Arrays.asList(clusterSearchShardsGroup.getShards()),  
            } finally {
        Map<String, OriginalIndices> remoteIndices,
        ActionListener<SearchResponse> listener
import org.opensearch.indices.IndicesService;
/*  
    }
            ActionListener<SearchResponse> listener,
                            searchContext,
        final SearchIndexPruningResult pruningResult = searchIndexPruningService.prune(
            clusterState,
            @Override
import org.opensearch.action.search.pruning.FieldDomainEvaluationContext;
import org.opensearch.search.builder.SearchSourceBuilder;
                        clusters,  
            || source.collapse().getInnerHits() == null
                    searchRequestContext
                searchResponseMerger.add(searchResponse);
                                    remoteClusterIndices,
                        listener,  
            return new CanMatchPreFilterSearchPhase(
            return false;
        TimeValue keepAlive
            final DiscoveryNode discoveryNode;  
        });
                    clusterAlias,  
            shardIterators,  
                    skippedClusters,  
        Map<String, Set<String>> indexRoutings,
                assert requestClusterAlias == null || requestClusterAlias.equals(clusterAlias);  
                requestOperationsListeners,
                        concreteIndexBoosts,  
            from = source.from() == -1 ? SearchService.DEFAULT_FROM : source.from();
        }  
 * license agreements. See the NOTICE file distributed with
                    )  
            SearchResponse.Clusters clusters,
                    concreteIndexBoosts,
                    searchService.getResponseCollectorService(),
        SearchRequest searchRequest,
        // only if task is of type CancellableTask and support cancellation on timeout, treat this request eligible for timeout based  
            return false;
                    + SHARD_COUNT_LIMIT_SETTING.getKey()
            for (ClusterSearchShardsGroup group : entry.getValue().getGroups()) {
        SearchTimeProvider timeProvider,
                        localClusterAlias,  
 * not use this file except in compliance with the License.
                        clusterAlias,
 * software distributed under the License is distributed on an
                        return;  
                    @Override  
        List<SearchShardIterator> remoteShardIterators,
        Long.MAX_VALUE,
        executeSearch(  
                .collect(Collectors.toList());
    private final MetricsRegistry metricsRegistry;
                } catch (OpenSearchRejectedExecutionException e) {
        "action.search.shard_count.limit",  
        return new TaskId(clusterService.localNode().getId(), task.getId());
        }  
            if (clusterNodes == null) {  
    public ResolvedIndices resolveIndices(SearchRequest searchRequest) {
import java.util.stream.Collectors;
                : source.trackTotalHitsUpTo();  
        String actionName,
import org.opensearch.action.support.TimeoutTaskCancellationUtility;  
                    tracer  
import org.opensearch.search.pipeline.SearchPipelineService;  
    static final class SearchTimeProvider {  
            int totalClusters = remoteIndices.size() + (localIndices == null ? 0 : 1);
            }
                    searchResponseMerger,
                    task,  
            originalSearchRequest.setPhaseTook(clusterService.getClusterSettings().get(SEARCH_PHASE_TOOK_ENABLED));  
        SearchTimeProvider timeProvider,  
            remoteClusterIndices = getIndicesFromSearchContexts(searchContext, searchRequest.indicesOptions());
                    );
import java.util.function.BiConsumer;
        if (searchRequest.isCcsMinimizeRoundtrips() == false) {
 * specific language governing permissions and limitations
                    exceptions.accumulateAndGet(exception, (previous, current) -> {  
                    listener,
        SearchRequest searchRequest,
            OriginalIndices indices = entry.getValue();  
        ClusterState clusterState = clusterService.state();  
        @Override
                        shardIterators,
                );
        final int from;  
                    }
            );
                        remoteClusterIndices,  
    final SearchPhaseController searchPhaseController;  
        return indices.entrySet()  
        );
            } catch (Exception e) {  
        ).start();  
                    searchAsyncAction = new SearchDfsQueryThenFetchAsyncAction(
            boolean skipUnavailable,
            ActionListener<SearchRequest> requestTransformListener = ActionListener.wrap(sr -> {  
        // cancelAfterTimeInterval to NO_TIMEOUT and bypass this mechanism  
        ClusterState clusterState,
        SEARCH_CANCEL_AFTER_TIME_INTERVAL_SETTING_KEY,
        SearchTimeProvider timeProvider,
import org.opensearch.action.support.TransportIndicesResolvingAction;
        if (searchRequest.searchType() == DFS_QUERY_THEN_FETCH) {
        ActionListener<SearchResponse> listener,
        SearchPipelineService searchPipelineService,  
        Map<String, OriginalIndices> remoteIndicesByCluster,
        final Executor asyncSearchExecutor = asyncSearchExecutor(concreteLocalIndices, clusterState);
        OriginalIndices localIndices,  
            skippedClusters,
                timeProvider,
    private Map<String, Float> resolveIndexBoosts(SearchRequest searchRequest, ClusterState clusterState) {
            String clusterAlias = entry.getKey();
        }  
                    + ". This limit exists because querying many shards at the same time can make the "
                };  
                        concreteIndexBoosts,
import org.opensearch.cluster.routing.ShardIterator;  
        BiFunction<String, DiscoveryNode, Transport.Connection> nodeToConnection  
                    new OriginalIndices(finalIndices, originalIndices.indicesOptions())
package org.opensearch.action.search;
 * @opensearch.internal
import org.opensearch.common.lease.Releasable;
            } else {  
                SearchResponse.Clusters clusters,
        final Map<String, ClusterSearchShardsResponse> searchShardsResponses = new ConcurrentHashMap<>();
                    ) {
            Executor executor,
import org.opensearch.action.support.HandledTransportAction;
            void innerOnResponse(SearchResponse searchResponse) {  
                                    searchShardsResponses,  
        SearchAsyncActionProvider searchAsyncActionProvider,  
                ShardId shardId = clusterSearchShardsGroup.getShardId();
                    new CCSActionListener<ClusterSearchShardsResponse, Map<String, ClusterSearchShardsResponse>>(  
    ) {  
            Collections.emptyList(),
            .stream()
        final String[] concreteLocalIndices;
            }  
                final OriginalIndices originalIndices = remoteIndicesByCluster.get(clusterAlias);
        ActionListener<SearchResponse> listener,
            || source.collapse() == null  
    }
        }  
                );  
                throw new IllegalStateException("no node found for id: " + nodeId);
    public void executeRequest(
                .map(it -> new SearchShardIterator(searchRequest.getLocalClusterAlias(), it.shardId(), it.getShardRoutings(), localIndices))  
        return createSearchAsyncAction(  
        Setting.Property.NodeScope
            shardIterators,
                        iter,  
 * compatible open source license.
        );  
                case QUERY_THEN_FETCH:
 * You may obtain a copy of the License at  
                        searchPhaseController,
        SearchRequest searchRequest,
        Map<String, Float> concreteIndexBoosts = new HashMap<>();
        }
import org.opensearch.action.admin.cluster.node.tasks.cancel.CancelTasksRequest;  
                SearchTask task,
        IndexNameExpressionResolver indexNameExpressionResolver,
            return Collections.emptyMap();  
        ClusterState clusterState,  
                SearchRequestContext searchRequestContext  
        final int trackTotalHitsUpTo;
    private final SearchService searchService;
    }  
                true  
        searchStatusStatsUpdateListener = ActionListener.wrap((searchResponse) -> {
            return nodeToConnection.apply(remoteCluster ? clusterAlias : null, discoveryNode);
            localShardIterators = getLocalLocalShardsIteratorFromPointInTime(
            Map<String, DiscoveryNode> clusterNodes = clusterToNode.get(clusterAlias);
    static SearchResponseMerger createSearchResponseMerger(
import org.opensearch.action.admin.cluster.shards.ClusterSearchShardsGroup;
                aggReduceContextBuilder  
            SearchRequestOperationsListener.CompositeListener requestOperationsListeners;
                        )
                    clusters,
        for (int i = 0; i < pruningResult.originalShardGroups(); i++) {
            for (DiscoveryNode remoteNode : entry.getValue().getNodes()) {  
                circuitBreaker,  
import java.util.Map;  
                searchRequest.routing(),  
                        response = createFinalResponse();  
                SearchRequest ccsSearchRequest = SearchRequest.subSearchRequest(
                clusterToNode.computeIfAbsent(clusterAlias, k -> new HashMap<>()).put(remoteNode.getId(), remoteNode);
            return false;
                        return current;
        InternalAggregation.ReduceContextBuilder aggReduceContextBuilder
                        rewriteListener  
        abstract void innerOnResponse(Response response);  
                                searchRequest,
import org.opensearch.core.index.shard.ShardId;
import java.util.function.LongSupplier;
        new OriginSettingClient(client, TASKS_ORIGIN).admin().cluster().cancelTasks(req, ActionListener.wrap(() -> {}));
import org.opensearch.cluster.node.DiscoveryNode;
                    aliasFilter = indicesAndFilters.get(shardId.getIndexName());  
            String clusterAlias,  
    private final ThreadPool threadPool;
        }
                    searchRequest.searchType(QUERY_THEN_FETCH);
                        localIndices,
            final QueryPhaseResultConsumer queryResultConsumer = searchPhaseController.newSearchPhaseResults(
                        searchRequest,
                );
            // At this point either the QUERY_GROUP_ID header will be present in ThreadContext either via ActionFilter  
                    searchRequestContext
import org.opensearch.search.pipeline.PipelinedRequest;
        }  
import org.opensearch.core.common.Strings;
                        searchResponse.getSuggest(),
            Map<String, Set<String>> routingMap = indexNameExpressionResolver.resolveSearchRouting(
                .local(true)
    );
import org.opensearch.common.settings.Setting.Property;  
        this.indexNameExpressionResolver = indexNameExpressionResolver;
        SearchRequest searchRequest,  
    }  
                        final Transport.Connection connection = getConnection(shard.getClusterAlias(), shard.getNodeId());
        ClusterState clusterState,  
import org.opensearch.search.profile.SearchProfileShardResults;
                        skipUnavailable,
                        connectionLookup,
    private OriginalIndicesAndSearchContextId extractRequestedIndices(SearchRequest searchRequest, ClusterState clusterState) {
            // and we directly perform final reduction in the remote cluster
        }  
            clusterState.blocks().indexBlockedRaiseException(ClusterBlockLevel.READ, index.getName());
            SearchTransportService.registerRequestHandler(transportService, searchService);  
        Map<String, ClusterSearchShardsResponse> searchShardsResponses,
        if (transportService instanceof StreamTransportService) {  
import org.opensearch.common.settings.Setting;
            Collections.unmodifiableMap(aliasFilter),
        ActionListener<SearchResponse> listener,
            // if we are searching against a single remote cluster, we simply forward the original search request to such cluster
import org.opensearch.telemetry.tracing.Tracer;
        }
        ClusterState clusterState,  
            return false;
                        searchResponse.getHits(),
                ActionListener<SearchResponse> listener,
                            searchShardsResponses.put(clusterAlias, clusterSearchShardsResponse);
        Task task,
        return isThrottleCounted(taskManager.getTask(parentTaskId.getId()));  
            @Override
        if (parentTaskId == null || parentTaskId.isSet() == false) {  
    );
        public final void onResponse(Response response) {
            }
                        indexRoutings,  
                task.getProgressListener(),
    private boolean parentAlreadyCounted(final Task task) {
        ClusterService clusterService,
    ) {  
        }
        executeRequest(task, searchRequest, new SearchAsyncActionProvider() {
                }
        List<SearchShardIterator> remoteShardIterators  
            try {  
    /** Whether {@code task}'s work is accounted for against a throttle bucket, so a nested search can inherit it. */  
                    searchRequest,
    interface SearchAsyncActionProvider {
                if (shouldMinimizeRoundtrips(searchRequest)) {
    }
            final String clusterAlias = entry.getKey();
            clusterClient.admin()
            SearchResponse createFinalResponse() {
        if (preFilterShardSize == null && (hasReadOnlyIndices(indices, clusterState) || hasPrimaryFieldSort(source))) {
    @Override
            PipelinedRequest searchRequest;
            ActionListener<SearchPhaseResult> listener
                indexRoutings,
            searchAsyncActionProvider,  
 *
                        searchService.aggReduceContextBuilder(searchRequest.source()),
                        shardIterators,
                (iter) -> new WrappingSearchAsyncActionPhase(
            size = SearchService.DEFAULT_SIZE;
                        remoteClusterService,
                            timeProvider::getAbsoluteStartMillis,
                        current.addSuppressed(previous);
            }, listener::onFailure);  
    }
        private final boolean skipUnavailable;
import org.opensearch.transport.Transport;
                        clusterState,  
                final Task parentTask = extractParentTask(originalSearchRequest);
        }, listener);
                    clusterAlias,  
                    searchRequestContext,
                        // Parent rewrite searches on this task only when it is counted, so a nested search isn't charged twice.  
    }  
        Setting.Property.Dynamic,  
                    searchTransportService,
            for (ClusterSearchShardsGroup clusterSearchShardsGroup : searchShardsResponse.getGroups()) {  
                assert clusterAlias.equals(perNode.getClusterAlias()) : clusterAlias + " != " + perNode.getClusterAlias();  
                clusterState,
                        responsesCountDown,  
        private final ActionListener<FinalResponse> originalListener;  
                taskResourceTrackingService::getTaskResourceUsageFromThreadContext  
        super(SearchAction.NAME, transportService, actionFilters, (Writeable.Reader<SearchRequest>) SearchRequest::new);
        RemoteClusterService remoteClusterService,
    static List<SearchShardIterator> getRemoteShardsIteratorFromPointInTime(  
                // only set it if it changed - we don't allow null values to be set but it might be already null. this way we catch
                }  
        if (source == null) {  
    }  
            SearchTask task,  
                        searchRequestContext,
    private static boolean isThrottleCounted(final Task task) {
            requestOperationsListeners = searchRequestOperationsCompositeListenerFactory.buildCompositeListener(
    ) {
    static Map<String, OriginalIndices> getIndicesFromSearchContexts(SearchContextId searchContext, IndicesOptions indicesOptions) {
                    clusterAlias,
import org.opensearch.telemetry.tracing.SpanScope;
    }  
            }
        AtomicInteger skippedClusters,
                            }
        SearchContextId searchContext,  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            String clusterAlias = entry.getKey();
            Transport.Connection connection,  
            for (ClusterSearchShardsGroup clusterSearchShardsGroup : entry.getValue().getGroups()) {
            originalSearchRequest.getOrCreateAbsoluteStartMillis(),
                                (SearchTask) task,  
    }
import org.opensearch.telemetry.tracing.SpanBuilder;  
                    timeProvider,
                indices.indices(),  
                clusterState,
        private final AtomicReference<Exception> exceptions;
            @Override
    static boolean shouldMinimizeRoundtrips(SearchRequest searchRequest) {  
        ClusterState clusterState,  
    public static final Setting<Long> SHARD_COUNT_LIMIT_SETTING = Setting.longSetting(
        return false;
 */  
                    Rewriteable.rewriteAndFetch(
            source.from(0);
                Exception exception = exceptions.get();
            searchRequestContext.getSearchRequestOperationsListener().onRequestStart(searchRequestContext);
        AtomicInteger skippedClusters,  
            trackTotalHitsUpTo = SearchContext.DEFAULT_TRACK_TOTAL_HITS_UP_TO;  
     * The single phase search action.
                    assert aliasFilter != null : "alias filter must not be null for index: " + shardId.getIndex();
