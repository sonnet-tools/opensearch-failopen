 * Unless required by applicable law or agreed to in writing,
                    + " shards, which is over the limit of "
                        concreteIndexBoosts,
    private void executeLocalSearch(
                    break;
    static Map<String, OriginalIndices> getIndicesFromSearchContexts(SearchContextId searchContext, IndicesOptions indicesOptions) {
                        listener,
                }
    ) {
                        response = createFinalResponse();
                SearchResponse.Clusters clusters = new SearchResponse.Clusters(
    static BiFunction<String, String, DiscoveryNode> getRemoteClusterNodeLookup(Map<String, ClusterSearchShardsResponse> searchShardsResp) {
        }
                            searchRequest,
                searchTransportService,
                        aliasFilter,
            // don't search on any local index (happens when only remote indices were specified)
        } else {
                );
                        ? null
            return absoluteStartMillis;
     * @opensearch.internal
            routingMap = routingMap == null ? Collections.emptyMap() : Collections.unmodifiableMap(routingMap);
        List<SearchShardIterator> remoteShardIterators
        return isThrottleCounted(taskManager.getTask(parentTaskId.getId()));
    private final SearchRequestOperationsCompositeListenerFactory searchRequestOperationsCompositeListenerFactory;
            concreteLocalIndices,
import java.util.function.LongSupplier;
                            final BiFunction<String, String, DiscoveryNode> clusterNodeLookup = getRemoteClusterNodeLookup(
                Exception exception = e;
    ) {
            GroupShardsIterator<ShardIterator> localShardRoutings = clusterService.operationRouting()
    abstract static class CCSActionListener<Response, FinalResponse> implements ActionListener<Response> {
            if (clusterAlias == null || requestClusterAlias != null) {
                    aliasFilter = indicesAndFilters.get(shardId.getIndexName());
            ) {
        this.searchTransportService = searchTransportService;
        BiFunction<String, DiscoveryNode, Transport.Connection> nodeToConnection
                                final AtomicArray<SearchPhaseResult> atomicArray = results.getAtomicArray();
        return GroupShardsIterator.sortAndCreate(shards);
            // At this point either the QUERY_GROUP_ID header will be present in ThreadContext either via ActionFilter
                    updatedListener.onFailure(e);
        return new TaskId(clusterService.localNode().getId(), task.getId());
                final AliasFilter aliasFilter;
            || source.collapse().getInnerHits().isEmpty();
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
                        tracer
                aggReduceContextBuilder
                requestOperationsListeners,
            }
                        originalIndices,
                );
        ClusterState clusterState,
    final Tracer tracer;
package org.opensearch.action.search;
                        shardIterators,
import org.opensearch.search.aggregations.InternalAggregations;
        }
                        searchPhaseController,
                        SearchShardTarget shard,
import org.opensearch.transport.RemoteTransportException;
            ActionListener<SearchRequest> requestTransformListener = ActionListener.wrap(sr -> {
            int totalClusters = remoteIndices.size() + (localIndices == null ? 0 : 1);
                circuitBreaker,
        );
            switch (searchRequest.searchType()) {
 * @opensearch.internal
    }
    }
    /**
                    searchAsyncAction = new SearchQueryThenFetchAsyncAction(
                remoteClusterClient.search(ccsSearchRequest, ccsListener);
                    skippedClusters,
        ClusterState clusterState,
        if (originalSearchRequest.isPhaseTook() == null) {
                    task,
    public static final String SEARCH_CANCEL_AFTER_TIME_INTERVAL_SETTING_KEY = "search.cancel_after_time_interval";
            connectionLookup,
            String clusterAlias = entry.getKey();
        final SearchContextId searchContext;
        }
                    );
    public static final Setting<Long> SHARD_COUNT_LIMIT_SETTING = Setting.longSetting(
import org.opensearch.core.common.io.stream.Writeable;
    ) {
import org.opensearch.tasks.TaskResourceTrackingService;
                        listener,
            // disable request cache if we have only suggest
                );
            }
            CountDown countDown,
 */
                updatedListener.onFailure(e);
            SearchShardTarget target,
                throw new IllegalArgumentException("unknown remote cluster: " + clusterAlias);
        ActionListener<SearchResponse> listener
                        keepAlive
        ClusterState clusterState,
                indices.indices(),
        if (parentTaskId == null || parentTaskId.isSet() == false) {
import org.opensearch.core.common.breaker.CircuitBreaker;
import org.opensearch.search.internal.SearchContext;
        "action.search.shard_count.limit",
            });
                    assert aliasFilter != null : "alias filter must not be null for index: " + shardId.getIndex();
import org.opensearch.common.settings.Setting;
        this.workloadGroupService = workloadGroupService;
            this.countDown = countDown;
    ) {
                        // Release before notifying: a completion listener (e.g. _msearch) may start new work in this bucket.
        OriginalIndices localIndices,
    );
    ) {
    implements
     * using a relative clock for reporting real time. Thus, we simply separate these two uses.
                remoteCluster = false;
import org.opensearch.cluster.node.DiscoveryNodes;
import org.opensearch.core.action.ActionListener;
    static final class SearchTimeProvider {
    static Map<String, AliasFilter> getRemoteAliasFilters(Map<String, ClusterSearchShardsResponse> searchShardsResp) {
                        concreteIndexBoosts,
                            int successfulClusters = searchShardsResponses.size() + localClusters;
     * @opensearch.internal
    }
                }
        }
        SearchRequest searchRequest,
        SearchRequestContext searchRequestContext
            if (writeBlock != null) {
                        remoteClusterIndices,
    ) {
            }
            clusterState,
                        remoteClusterService,
                } catch (OpenSearchRejectedExecutionException e) {
        SearchSourceBuilder source = searchRequest.source();
    private final SearchPipelineService searchPipelineService;
import org.opensearch.search.builder.SearchSourceBuilder;
        SearchRequest searchRequest,
                    executor,
            final DiscoveryNode discoveryNode;
                    searchResponseMerger.numResponses(),
        if (searchRequest.isSuggestOnly()) {
        }
import org.opensearch.action.support.IndicesOptions;
            AtomicReference<Exception> exceptions,
                    searchRequest.getMaxConcurrentShardRequests(),
                clusterAlias,
                logger,
                        searchPhaseController,
        SearchRequestContext searchRequestContext
                    clusterAlias,
        }
            Map<String, Set<String>> routingMap = indexNameExpressionResolver.resolveSearchRouting(
import java.util.stream.Collectors;
import java.util.Map;
            indexRoutings = routingMap;
            }
                    AtomicInteger skippedClusters = new AtomicInteger(0);
                );
    }
import java.util.function.BiConsumer;
                );
            searchTransportService::getConnection
                    clusterAlias,
        SearchTimeProvider timeProvider,
                    }
        SearchSourceBuilder source = searchRequest.source();
        BiFunction<String, String, DiscoveryNode> remoteNodes,
import java.util.function.BiFunction;
            // or HTTP header (HTTP header will be deprecated once ActionFilter is implemented)
         * @param relativeStartNanos the relative start time in nanoseconds
        // TODO: I think startTime() should become part of ActionRequest and that should be used both for index name
        final long relativeStartNanos = System.nanoTime();
        } else {
                boolean skipUnavailable = remoteClusterService.isSkipUnavailable(clusterAlias);
    }
            final AtomicReference<Exception> exceptions = new AtomicReference<>();
            }
import org.opensearch.search.internal.AliasFilter;
            || source.collapse() == null
                .local(true)
                            new SearchResponse.Clusters(1, 1, 0),
        SearchTask task,
                        searchRequest,
                final List<String> targetNodes = Collections.singletonList(perNode.getNode());
            skipUnavailable,
                        current.addSuppressed(previous);
            clusterAlias,
 * You may obtain a copy of the License at
        for (String index : indices) {
        }
        return indices.entrySet()
    private static RemoteTransportException wrapRemoteClusterFailure(String clusterAlias, Exception e) {
                SearchRequest searchRequest,
        OriginalIndices localIndices,
                    targetNodes,
import org.opensearch.transport.client.Client;
import org.opensearch.cluster.metadata.IndexMetadata;
                            final List<SearchShardIterator> remoteShardIterators;
                listener.onFailure(e);
            searchRequest,
        ) {
                                );
        for (Map.Entry<ShardId, SearchContextIdForNode> entry : searchContext.shards().entrySet()) {
                        searchResponse.isTerminatedEarly(),
            switch (searchRequest.searchType()) {
            ActionListener<SearchResponse> listener,
import org.opensearch.core.index.shard.ShardId;
                    listener.onResponse(
        SearchRequest request,
import java.util.Set;
        for (Map.Entry<ShardId, SearchContextIdForNode> entry : searchContext.shards().entrySet()) {
        SearchTimeProvider timeProvider,
                            if (searchContext != null) {
                discoveryNode = localNodes.apply(nodeId);
        AtomicReference<Exception> exceptions,
            }
     * local parent is inspected: the rewrite client is the only thing that parents a counted coordinator search, and it is
    ) {
                        timeProvider,
            listener,
                    totalClusters,
import org.opensearch.cluster.routing.GroupShardsIterator;
            if (remoteClusterIndices.isEmpty()) {
        }
            clusterService.getClusterSettings(),
        private final ActionListener<FinalResponse> originalListener;
                                clusterNodeLookup,
                            searchResponse.getTotalShards(),
                clusterToNode.computeIfAbsent(clusterAlias, k -> new HashMap<>()).put(remoteNode.getId(), remoteNode);
            requestOperationsListeners = searchRequestOperationsCompositeListenerFactory.buildCompositeListener(
                                searchRequest,
        if (clusterService.localNode().getId().equals(parentTaskId.getNodeId()) == false) {
        this.clusterService = clusterService;
                return searchResponseMerger.getMergedResponse(clusters, searchRequestContext);
 * specific language governing permissions and limitations
    }
                clusterState,
        return iterators;
    }
                    searchResponseMerger,
                    clusterAlias,
            ActionListener<FinalResponse> originalListener
        ActionListener<SearchResponse> originalListener,
import org.opensearch.search.SearchShardTarget;
        ActionListener<SearchResponse> listener,
                    SearchProfileShardResults profile = profileResults == null || profileResults.isEmpty()
                        searchResponse.getSuggest(),
    private ActionListener<SearchSourceBuilder> buildRewriteListener(
                if (RemoteClusterAware.LOCAL_CLUSTER_GROUP_KEY.equals(clusterAlias) == false) {
    public static final Setting<Boolean> SEARCH_PHASE_TOOK_ENABLED = Setting.boolSetting(
        TaskId taskId = searchRequest.getParentTask();
        SearchRequestContext searchRequestContext
                        indexRoutings,
        InternalAggregation.ReduceContextBuilder aggReduceContextBuilder
            preFilterSearchShards,
        };
                    Releasable throttlePermit = workloadGroupService.acquireThrottleOrReject(
 *
            return clusterNodes.get(nodeId);
import java.util.function.Function;
            } catch (Exception e) {
        ClusterState clusterState,
        1L,
                        task,
    }
                        clusters,
                );
import org.opensearch.core.index.Index;
            SearchRequest searchRequest,
                    slice
                    );
                        searchRequest,
        SearchAsyncActionProvider searchAsyncActionProvider,
import org.opensearch.cluster.ClusterState;
        }
                    searchRequestContext,
     */
import org.opensearch.core.tasks.TaskId;
    @Inject
            SearchRequestContext searchRequestContext = new SearchRequestContext(
                client,
                return new AbstractSearchAsyncAction<SearchPhaseResult>(
            indexRoutings,
    /** Whether {@code task}'s work is accounted for against a throttle bucket, so a nested search can inherit it. */
        ThreadPool threadPool,
            indices.computeIfAbsent(clusterAlias, k -> new HashSet<>()).add(entry.getKey().getIndexName());
            timeProvider,
        } else {
        super(SearchAction.NAME, transportService, actionFilters, (Writeable.Reader<SearchRequest>) SearchRequest::new);
        InternalAggregation.ReduceContextBuilder aggReduceContextBuilder,
            indexRoutings,
        Map<String, OriginalIndices> remoteClusterIndices
                TraceableSearchRequestOperationsListener.create(tracer, requestSpan)
            from = source.from() == -1 ? SearchService.DEFAULT_FROM : source.from();
                assert originalIndices != null : "original indices are null for clusterAlias: " + clusterAlias;
        SearchRequestContext searchRequestContext
    public static final Setting<TimeValue> SEARCH_CANCEL_AFTER_TIME_INTERVAL_SETTING = Setting.timeSetting(
        final int size;
        GroupShardsIterator<SearchShardIterator> shardIterators,
        IndexNameExpressionResolver indexNameExpressionResolver,
                        return new SearchPhase(getName()) {
            AtomicInteger skippedClusters,
                originalSearchRequest,
            searchContext = SearchContextId.decode(namedWriteableRegistry, searchRequest.pointInTimeBuilder().getId());
/**
            concreteIndexBoosts,
                case DFS_QUERY_THEN_FETCH:
     * (an {@code _msearch} task, a reindex task) never carry the flag, so their child searches are each charged, as
                clusterService.getClusterSettings().get(SEARCH_CANCEL_AFTER_TIME_INTERVAL_SETTING),
        List<SearchShardIterator> localShardIterators,
                            public void run() {
                );
            searchContext = null;
                        remoteClusterService,
            this.relativeCurrentNanosProvider = relativeCurrentNanosProvider;
        // optimize search type for cases where there is only one shard group to search on
        // date math expressions and $now in scripts. This way all apis will deal with now in the same way instead
            void innerOnResponse(SearchResponse searchResponse) {
        boolean preFilter,
                        SearchShardIterator shardIt,
        return new OriginalIndicesAndSearchContextId(localIndices, remoteClusterIndices, searchContext);
                    searchRequestContext
     * Whether this request's parent task is already counted against a node-level throttle bucket, so admission charges it
                    exceptions.accumulateAndGet(exception, (previous, current) -> {
            timeProvider,
            }
        return remoteShardIterators;
        }
        SearchRequest searchRequest,
                        task,
        }
        BiFunction<String, String, DiscoveryNode> remoteConnections,
            return TimeUnit.NANOSECONDS.toMillis(relativeCurrentNanosProvider.getAsLong() - relativeStartNanos);
        ResolvedIndices.Local.Concrete localConcreteIndices = resolveLocalIndices(
import org.opensearch.telemetry.tracing.SpanScope;
        searchStatusStatsUpdateListener = ActionListener.wrap((searchResponse) -> {
    }
            .setReason("Fatal failure during search: " + errorMsg);
            clusterState,
                    } catch (Exception e) {
            }
        if (transportService instanceof StreamTransportService) {
        WorkloadGroupService workloadGroupService
        }
            return Collections.emptyMap();
            clusterClient.admin()
        SearchTimeProvider timeProvider,
import org.opensearch.wlm.WorkloadGroupTask;
                        clusterState,
            }
        boolean preFilter,
            OriginalIndices localIndices = requestedIndices.localOriginalIndices;
        ActionListener<SearchResponse> listener,
            final String clusterAlias = entry.getKey();
        private final AtomicInteger skippedClusters;
                final OriginalIndices originalIndices = remoteIndicesByCluster.get(clusterAlias);
    }
                                remoteAliasFilters = getRemoteAliasFilters(searchShardsResponses);
                    clusterState,
     * Search operations need two clocks. One clock is to fulfill real clock needs (e.g., resolving
        }
                .searchShards(
                    }
    private Map<String, Float> resolveIndexBoosts(SearchRequest searchRequest, ClusterState clusterState) {
        }
        } else if (preFilterShardSize == null) {
                            }
import org.opensearch.search.slice.SliceBuilder;
        );
                searchRequest.getLocalClusterAlias(),
                    ) {
        Function<String, DiscoveryNode> localNodes,
 * the Apache License, Version 2.0 (the "License"); you may
            size = source.size() == -1 ? SearchService.DEFAULT_SIZE : source.size();
    private final WorkloadGroupService workloadGroupService;
                    if (skipUnavailable) {
        final Map<String, ClusterSearchShardsResponse> searchShardsResponses = new ConcurrentHashMap<>();
import org.opensearch.action.support.HandledTransportAction;
    interface SearchAsyncActionProvider {
                        phaseSearchAction.executeOnShardTarget(task, shard, connection, listener);
public class TransportSearchAction extends HandledTransportAction<SearchRequest, SearchResponse>
                    boolean buildPointInTimeFromSearchResults() {
    private final IndicesService indicesService;
                        shardId,
        );
        } else {
        SearchRequest searchRequest,
                            task,
                        (InternalAggregations) searchResponse.getAggregations(),
    static List<SearchShardIterator> getRemoteShardsIteratorFromPointInTime(
                                searchContext,
 *
            Index[] concreteIndices = indexNameExpressionResolver.concreteIndices(
            this.exceptions = exceptions;
    /** A {@link TaskId} addressing {@code task} on this node. */
    void executeRequest(
                                    searchContext,
            aliasFilterMap.put(index.getUUID(), aliasFilter);
        this.namedWriteableRegistry = namedWriteableRegistry;
        this.searchIndexPruningService = new SearchIndexPruningService(
                    @Override
        }
                    exceptions,
            Map<String, Set<String>> indexRoutings,
            preFilterShardSize = 1;
    }
            searchRequestContext
                        searchRequestContext,
            shardIterators,
            ActionListener<SearchResponse> updatedListener = TraceableActionListener.create(originalListener, requestSpan, tracer);
        SearchContextId searchContextId) {
                    searchRequestContext
        new OriginSettingClient(client, TASKS_ORIGIN).admin().cluster().cancelTasks(req, ActionListener.wrap(() -> {}));
    );
        ResolvedIndices.Local.Concrete concreteIndices,
        return searchRequest.searchType() == QUERY_THEN_FETCH // we can't do this for DFS it needs to fan out to all shards all the time
     * clock for measuring how long an operation took (they often lack precision, they are subject
import org.opensearch.transport.RemoteClusterService;
        BiFunction<String, String, Transport.Connection> connectionLookup = buildConnectionLookup(
        Setting.Property.Dynamic,
        }
            // if we only have one group, then we always want Q_T_F, no need for DFS, and no need to do THEN since we hit one shard
        final boolean preFilterSearchShards = shouldPreFilterSearchShards(
                        searchRequestContext,
    public interface SinglePhaseSearchAction {
                localIndices,
    }
                    exception = wrapRemoteClusterFailure(clusterAlias, e);
            Map.Entry<String, OriginalIndices> entry = remoteIndices.entrySet().iterator().next();
            } else {
        ActionListener<SearchResponse> listener,
                    )
                    }
    // precedence over the cluster setting value
                    searchRequestContext
                case QUERY_THEN_FETCH:
                searchResponseMerger.add(searchResponse);
            this.absoluteStartMillis = absoluteStartMillis;
            }
                        connectionLookup,
                    originalListener.onResponse(response);
 * Licensed to Elasticsearch under one or more contributor
        executeRequest(task, searchRequest, this::searchAsyncAction, searchStatusStatsUpdateListener);
                        new SearchResponse(
        SinglePhaseSearchAction phaseSearchAction,
        BiFunction<String, String, Transport.Connection> connectionLookup,
                String[] aliases = aliasFilter.getAliases();
                                timeProvider,
            // here we modify the original source so we can re-use it by setting it to each outgoing search request
            final OriginalIndicesAndSearchContextId requestedIndices = extractRequestedIndices(searchRequest, clusterState);
        ActionListener<Map<String, ClusterSearchShardsResponse>> listener
                        exceptions,
                    concreteLocalIndices,
            Map<String, AliasFilter> aliasFilter,
                        searchResponse.getNumReducePhases()
import org.opensearch.search.internal.InternalSearchResponse;
            } finally {
                    aliasFilter = AliasFilter.EMPTY;
        Map<String, AliasFilter> aliasFilterMap
        Executor executor,
                        aliasFilter,
    private final SearchService searchService;
                executor,
                ShardId shardId = clusterSearchShardsGroup.getShardId();
                        queryResultConsumer,
                            searchRequestContext.getPhaseTook(),
                            searchContext,
            return;
 * SPDX-License-Identifier: Apache-2.0
        abstract void innerOnResponse(Response response);
    ) {
            // No user preference defined in search request - apply cluster service default
                        @Override
                        : new SearchProfileShardResults(profileResults);
 *
                    searchService.getResponseCollectorService(),
            SearchRequestContext searchRequestContext
    private TaskId localTaskId(final Task task) {
                    });
 * GitHub history for details.
     */
        Map<String, Map<String, DiscoveryNode>> clusterToNode = new HashMap<>();
                            return searchShardsResponses;
            shardIterators,
        final Set<String> indicesAndAliases = indexNameExpressionResolver.resolveExpressions(clusterState, request.indices());
                    searchRequest.preference(),
                searchRequest.indices()
                                );
            searchRequestContext
                        clusters,
                            );
            try {
    ) {
        SearchService searchService,
                    }
                            );
                aliasFilterMap.put(shardId.getIndex().getUUID(), aliasFilter);
                        final Transport.Connection connection = getConnection(shard.getClusterAlias(), shard.getNodeId());
    private OriginalIndicesAndSearchContextId extractRequestedIndices(SearchRequest searchRequest, ClusterState clusterState) {
                    originalListener.onFailure(exceptions.get());
                            searchResponse.getShardFailures(),
                    + "] to a greater value if you really want to query that many shards at the same time."
                exc -> cancelTask(task, exc),
        SearchRequest searchRequest,
        SearchAsyncActionProvider searchAsyncActionProvider,
            );
    }
        }
        }
        int totalClusters,
                    listener,
                searchRequest.transformRequest(requestTransformListener);
            }
            .stream()
     * xcluster search listener
                    } else {
    }
            for (ClusterSearchShardsGroup group : entry.getValue().getGroups()) {
        Task task,
                searchRequest.indicesOptions(),
        final DiscoveryNodes nodes = clusterState.nodes();
        maybeApplySearchIndexPruning(searchRequest, shardIterators, clusterState, timeProvider);
        }
                searchRequest.indicesOptions(),
    }
                searchRequest = searchPipelineService.resolvePipeline(originalSearchRequest, parentTask, indexNameExpressionResolver);
                OperationRouting.getShards(clusterState, shardId);
            try {
        SearchRequest searchRequest,
                );
 * Perform search action
        ActionListener<SearchResponse> originalListener
        Map<String, AliasFilter> remoteAliasMap
import org.opensearch.cluster.metadata.ResolvedIndices;
    /**
            Transport.Connection connection,
                SearchRequest ccsSearchRequest = SearchRequest.subSearchRequest(
            return searchAsyncAction;
            SearchTimeProvider timeProvider,
    AbstractSearchAsyncAction<? extends SearchPhaseResult> searchAsyncAction(
                        profile,
        SearchAsyncActionProvider searchAsyncActionProvider,
        if (shardCount > shardCountLimit) {
import org.opensearch.common.settings.Setting.Property;
            originalListener
            aliasFilter = buildPerIndexAliasFilter(searchRequest, clusterState, indices, remoteAliasMap);
            this.clusterAlias = clusterAlias;
                    searchRequest,
                final List<String> targetNodes = Collections.singletonList(perNode.getNode());
                        threadPool,
            clusterState,
        final List<SearchShardIterator> iterators = new ArrayList<>(searchContext.shards().size());
import org.opensearch.action.OriginalIndices;
        TaskResourceTrackingService taskResourceTrackingService,
    }
        ClusterService clusterService,
import org.opensearch.ExceptionsHelper;
                                searchRequestContext
                        ),
    public TransportSearchAction(
            searchRequest,
                    skipUnavailable,
        if (localIndices == null && remoteIndices.size() == 1) {
import static org.opensearch.action.search.SearchType.QUERY_THEN_FETCH;
        TransportService transportService,
                    searchRequest,
        this.tracer = tracer;
                // here we have to map the filters to the UUID since from now on we use the uuid for the lookup
                        listener,
                final ShardId shardId = entry.getKey();
    }
import org.opensearch.transport.Transport;
        );
                indexRoutings,
            return Collections.emptyMap();
    }
            from = SearchService.DEFAULT_FROM;
        return aliasFilterMap;
    /**
            Executor executor,
        if (source.indexBoosts() == null) {
        final List<SearchShardIterator> localShardIterators;
import org.opensearch.common.util.concurrent.AtomicArray;
                final ShardId shardId = group.getShardId();
         * time.
                        }
        }
                            int totalClusters = remoteClusterIndices.size() + localClusters;
        final int from;
        this.client = client;
                    concreteIndexBoosts,
    }
 * compatible open source license.
import org.opensearch.tasks.CancellableTask;
        SearchPipelineService searchPipelineService,
        for (Map.Entry<String, OriginalIndices> entry : remoteIndicesByCluster.entrySet()) {
                        shardIterators,
import java.util.concurrent.TimeUnit;
                .preference(preference)
            asyncSearchExecutor,
            return false;
                    remoteClusterIndices.get(clusterAlias),
            }
            localShardIterators = StreamSupport.stream(localShardRoutings.spliterator(), false)
        // cancelAfterTimeInterval to NO_TIMEOUT and bypass this mechanism
                searchRequest,
     * nothing (see {@link WorkloadGroupService#acquireThrottleOrReject(WorkloadGroupTask, BooleanSupplier)}); a nested
import org.opensearch.indices.IndicesService;
    private Task extractParentTask(final SearchRequest searchRequest) {
        TransportIndicesResolvingAction<SearchRequest> {
            }
                clusters,
                (CancellableTask) task,
                    timeProvider.getAbsoluteStartMillis(),
                        () -> parentAlreadyCounted(task)
                                remoteAliasFilters,
            localShardIterators.size() + remoteShardIterators.size()
        SearchContextId searchContextId,
                String clusterAlias = entry.getKey();
        Task task,
        return remoteShardIterators;
                .collect(Collectors.toList());
            return false;
                // Same listener as the async failure path; it wraps updatedListener, so the permit is still released.
                    aliasFilter,
                iterators.add(
        AtomicInteger skippedClusters,
import org.opensearch.index.fielddomain.ClusterStateFieldDomainProvider;
    private final RemoteClusterService remoteClusterService;
     *
    }
                        sr.source(),
                boolean preFilter,
                    RemoteClusterAware.LOCAL_CLUSTER_GROUP_KEY,
            return false;
import org.opensearch.search.pipeline.PipelinedRequest;
                BiFunction<String, String, Transport.Connection> connectionLookup,
        this.indicesService = indicesService;
        }
                );
import org.opensearch.transport.client.OriginSettingClient;
                            internalSearchResponse,
        MetricsRegistry metricsRegistry,
                    task,
     * The single phase search action.
            PipelinedRequest searchRequest;
                    searchRequest,
import org.opensearch.cluster.block.ClusterBlockException;
                            searchResponse.pointInTimeId()
            clusterState,
                                    searchRequest.pointInTimeBuilder().getKeepAlive(),
                            executeSearch(
            connectionLookup,
        if (searchRequest.scroll() != null) {
            searchRequest.searchType(QUERY_THEN_FETCH);
                            timeProvider.buildTookInMillis(),
                concreteIndexBoosts.putIfAbsent(concreteIndex.getUUID(), ib.getBoost());
        for (Map.Entry<String, ClusterSearchShardsResponse> entry : searchShardsResponses.entrySet()) {
                    + "have a smaller number of larger shards. Update ["
                    sr,
 * ownership. Elasticsearch licenses this file to you under
                        clusterAlias,
                    searchShardsRequest,
        final Span requestSpan = tracer.startSpan(SpanBuilder.from(task, actionName));
                                    remoteClusterIndices
            System::nanoTime
                            clusterState,
                        @Override
        }
        if (localIndices == null) {
                idx -> indexNameExpressionResolver.hasIndexAbstraction(idx, clusterState)
        for (Map.Entry<String, ClusterSearchShardsResponse> entry : searchShardsResp.entrySet()) {
import org.opensearch.common.util.concurrent.CountDown;
                SearchTimeProvider timeProvider,
import org.opensearch.cluster.service.ClusterService;
        });
            );
            exceptions,
                : entry.getValue().getClusterAlias();
    private void executeSearch(
            searchContext,
        Map<String, AliasFilter> aliasFilter,
        );
                                remoteShardIterators = getRemoteShardsIteratorFromPointInTime(
            maybeFinish();
                if (indicesAndFilters == null) {
            clusterState.blocks().indexBlockedRaiseException(ClusterBlockLevel.READ, index.getName());
        if (pruningResult.pruned() == false) {
 * under the License.
                Exception exception = exceptions.get();
         * used for resolving index expressions that include dates. The relative start time is the
        }
import org.opensearch.action.support.TransportIndicesResolvingAction;
            Collections.unmodifiableMap(aliasFilter),
                try {
            searchRequest,
    }
        Setting.Property.NodeScope
        CountDown countDown,
                searchRequest,
import java.util.concurrent.ConcurrentHashMap;
                final SearchContextIdForNode perNode = searchContextId.shards().get(shardId);
                            @Override
        CancelTasksRequest req = new CancelTasksRequest().setTaskId(new TaskId(client.getLocalNodeId(), task.getId()))
        false,
            boolean skipUnavailable = remoteClusterService.isSkipUnavailable(clusterAlias);
            if (localIndices != null) {
        private final String clusterAlias;
            trackTotalHitsUpTo = source.trackTotalHitsUpTo() == null
                                    remoteAliasFilters
    public ResolvedIndices resolveIndices(SearchRequest searchRequest) {
                }
            executor,
        private final long absoluteStartMillis;
                        false,
        SEARCH_CANCEL_AFTER_TIME_INTERVAL_SETTING_KEY,
                throw new IllegalStateException("no node found for id: " + nodeId);
        private final AtomicReference<Exception> exceptions;
    );
            preFilterShardSize = SearchRequest.DEFAULT_PRE_FILTER_SHARD_SIZE;
                ThreadPool threadPool,
    public void executeRequest(
                    skippedClusters.get()
     */
import org.opensearch.core.concurrency.OpenSearchRejectedExecutionException;
                .cluster()
        ActionListener<SearchResponse> listener,
        public final void onFailure(Exception e) {
 */
     * @opensearch.internal
                        searchService.getRewriteContext(
                searchRequest.indices(),
                    searchAsyncActionProvider,
import java.util.Arrays;
        }
            Map<String, Long> nodeSearchCounts = searchTransportService.getPendingSearchRequests();
            countDown,
            }
        };
        }
        }
import java.util.concurrent.atomic.AtomicReference;
                ? RemoteClusterAware.LOCAL_CLUSTER_GROUP_KEY
                true
                        // Parent rewrite searches on this task only when it is counted, so a nested search isn't charged twice.
        }
                    + "job of the coordinating node very CPU and/or memory intensive. It is usually a better idea to "
            searchRequestContext.getSearchRequestOperationsListener().onRequestStart(searchRequestContext);
        if (searchRequest.source() == null) {
            for (ClusterSearchShardsGroup clusterSearchShardsGroup : entry.getValue().getGroups()) {
import java.util.HashMap;
            return false;
            final QueryPhaseResultConsumer queryResultConsumer = searchPhaseController.newSearchPhaseResults(
    private void maybeApplySearchIndexPruning(
        final int trackTotalHitsUpTo;
            listener,
            ActionListener<SearchPhaseResult> listener
            aliasFilter = searchContext.aliasFilter();
            clusterState,
import org.opensearch.action.support.ActionFilters;
                .routing(routing)
                );
                ActionListener<SearchResponse> ccsListener = createCCSListener(
                        };
                    clusterAlias,
                    searchAsyncAction = new SearchDfsQueryThenFetchAsyncAction(
                        return;
                SearchRequestContext searchRequestContext
            SearchResponse.Clusters clusters,
            final SearchContextIdForNode perNode = entry.getValue();
            }
            size = SearchService.DEFAULT_SIZE;
                        threadPool,
                clusterState,
        Map<String, Float> concreteIndexBoosts,
            try {
        SearchContextId searchContext,
    static BiFunction<String, String, Transport.Connection> buildConnectionLookup(
            ResolvedIndices.Local.Concrete indices = resolveLocalIndices(localIndices, clusterState, timeProvider);
            skippedClusters,
import java.util.Collections;
            && preFilterShardSize < numShards;
                // only set it if it changed - we don't allow null values to be set but it might be already null. this way we catch
            assert aliasFilter != null;
            threadPool,
            ClusterState clusterState,
                } else {
            );
                } else {
                searchRequestContext,
                    timeProvider.getAbsoluteStartMillis(),
        // also track the response status of the searchResponse.
            );
                );
        return new RemoteTransportException("error while communicating with remote cluster [" + clusterAlias + "]", e);
        List<SearchShardIterator> shards = new ArrayList<>(remoteShardIterators);
        SearchResponseMerger searchResponseMerger,
            final Map<String, OriginalIndices> remoteClusterIndices = requestedIndices.remoteClusterIndices;
        if (preFilterShardSize == null && (hasReadOnlyIndices(indices, clusterState) || hasPrimaryFieldSort(source))) {
                ),
        SearchTransportService searchTransportService,
    private boolean parentAlreadyCounted(final Task task) {
            }
        return source == null
        SearchTimeProvider timeProvider,
        SearchRequestOperationsCompositeListenerFactory searchRequestOperationsCompositeListenerFactory,
        return Collections.unmodifiableMap(concreteIndexBoosts);
                        logger,
import java.util.HashSet;
                        slice,
            SearchResponseMerger searchResponseMerger = createSearchResponseMerger(
                if (exception == null) {
import org.opensearch.common.unit.TimeValue;
                    SliceBuilder slice = searchRequest.source() == null ? null : searchRequest.source().slice();
            final String[] indices = entry.getValue().indices();
                listener,
        return (clusterAlias, nodeId) -> {
import java.util.List;
}
                        iter,
        SearchTask task,
        Map<String, Float> concreteIndexBoosts,
        TaskId parentTaskId = task.getParentTaskId();
        SearchRequest searchRequest,
                if (sr.source() == null) {
                SearchShardIterator shardIterator = new SearchShardIterator(
        // cancellation. There may be other top level requests like AsyncSearch which is using SearchRequest internally and has it's own
            source.size(from + size);
    }
    }
                            searchAsyncActionProvider,
                        ActionListener.wrap(searchShardsResponses -> {
            remoteClusterIndices = remoteClusterService.groupIndices(
            }
        );
                ((WorkloadGroupTask) task).setWorkloadGroupId(threadPool.getThreadContext());
                    clusterState,
        String actionName,
            threadPool,
        Integer preFilterShardSize = searchRequest.getPreFilterShardSize();
                    Rewriteable.rewriteAndFetch(
            searchRequest.allowPartialSearchResults(searchService.defaultAllowPartialSearchResults());
        }, listener::onFailure);
            && (SearchService.canRewriteToMatchNone(source) || hasPrimaryFieldSort(source))
                    );
        final CountDown responsesCountDown = new CountDown(remoteIndicesByCluster.size());
         * @param absoluteStartMillis the absolute start time in milliseconds since the epoch
        } else {
            Map<String, DiscoveryNode> clusterNodes = clusterToNode.get(clusterAlias);
                            searchResponse.getSkippedShards(),
    private TaskResourceTrackingService taskResourceTrackingService;
import org.opensearch.search.SearchPhaseResult;
                originalSearchRequest,
                    @Override
    }
                listener = searchRequest.transformResponseListener(updatedListener);
                    }
import org.opensearch.search.profile.ProfileShardResult;
                    InternalSearchResponse internalSearchResponse = new InternalSearchResponse(
import org.opensearch.core.indices.breaker.CircuitBreakerService;
            clusterState,
        } else {
        SearchSourceBuilder source = searchRequest.source();
                    listener,
                    shardsIts,
                ActionListener<SearchSourceBuilder> rewriteListener = buildRewriteListener(
                        tracer
    Executor asyncSearchExecutor(final String[] indices, final ClusterState clusterState) {
        );
        final AtomicReference<Exception> exceptions = new AtomicReference<>();
        SearchRequest originalSearchRequest,
        SEARCH_PHASE_TOOK_ENABLED_KEY,
         * operation took can be measured against the provided relative clock and the relative start
            relativeStartNanos,
    ) {
                    searchRequest,
                Executor executor,
        ClusterState clusterState = clusterService.state();
        if (source == null) {
                (iter) -> new WrappingSearchAsyncActionPhase(
            BiFunction<String, String, Transport.Connection> connectionLookup,
            GroupShardsIterator<SearchShardIterator> shardIterators,
    }
            boolean preFilter,
 * not use this file except in compliance with the License.
        SearchResponse.Clusters clusters,
            .collect(Collectors.toMap(Map.Entry::getKey, e -> new OriginalIndices(e.getValue().toArray(new String[0]), indicesOptions)));
    }
            searchRequest.requestCache(false);
        ThreadPool threadPool,
        SearchContextId searchContext,
import org.opensearch.action.search.pruning.SearchIndexPruningResult;
    static void collectSearchShards(
                            searchResponse.getSuccessfulShards(),
                                    remoteClusterIndices,
        }
            String clusterAlias = entry.getValue().getClusterAlias() == null
                concreteIndexBoosts,
        }
                    countDown,
            if (countDown.countDown()) {
            } else {
        try (final SpanScope spanScope = tracer.withSpanInScope(requestSpan)) {
        executeRequest(task, searchRequest, new SearchAsyncActionProvider() {
            } catch (Exception e) {
            ThreadPool threadPool,
    }
            for (Index concreteIndex : concreteIndices) {
    public static final String SEARCH_PHASE_TOOK_ENABLED_KEY = "search.phase_took_enabled";
 */
        RemoteClusterService remoteClusterService,
                                sendSearchResponse(InternalSearchResponse.empty(), atomicArray);
                            final Map<String, AliasFilter> remoteAliasFilters;
                searchRequest.source(),
                }
 * this work for additional information regarding copyright
        final List<SearchShardIterator> remoteShardIterators = new ArrayList<>();
 *     http://www.apache.org/licenses/LICENSE-2.0
        Task task,
        Task task,
        ThreadPool threadPool,
        NamedWriteableRegistry namedWriteableRegistry,
/*
    final SearchTransportService searchTransportService;
                localSearchConsumer.accept(ccsLocalSearchRequest, ccsListener);
            if (skipUnavailable) {
                    searchContext,
                e -> {}
                    totalClusters,
        clusterState.blocks().globalBlockedRaiseException(ClusterBlockLevel.READ);
                }
        }
                skippedClusters.incrementAndGet();
                }
                    RemoteClusterAware.LOCAL_CLUSTER_GROUP_KEY,
        ActionListener<SearchResponse> listener,
    ) {
                        indexRoutings,
         * @param relativeCurrentNanosProvider provides the current relative time
            searchRequestContext
    final ClusterService clusterService;
        ActionListener<SearchResponse> searchStatusStatsUpdateListener;
            @Override
                        listener.onFailure(wrapRemoteClusterFailure(clusterAlias, e));
            this.skipUnavailable = skipUnavailable;
     */
            if (source != searchRequest.source()) {
            this.originalListener = originalListener;
        shards.addAll(localShardIterators);
                        return current;
                                remoteAliasFilters = searchContext.aliasFilter();
                ? SearchContext.DEFAULT_TRACK_TOTAL_HITS_UP_TO
        this.circuitBreaker = circuitBreakerService.getBreaker(CircuitBreaker.REQUEST);
     *
                ShardId shardId = clusterSearchShardsGroup.getShardId();
            remoteConnections,
                String[] finalIndices = aliases.length == 0 ? new String[] { shardId.getIndexName() } : aliases;
import org.opensearch.action.admin.cluster.shards.ClusterSearchShardsResponse;
                Map<String, AliasFilter> aliasFilter,
            boolean skipUnavailable,
                        }
                    countDown,
        SearchTimeProvider timeProvider,
            );
import java.util.concurrent.Executor;
            task,
        SearchTimeProvider timeProvider,
                    searchResponseMerger,
                AliasFilter aliasFilter = aliasFilterMap.get(shardId.getIndex().getUUID());
        Map<String, OriginalIndices> remoteIndicesByCluster,
        }
                OriginalIndices indices = entry.getValue();
                        searchRequest,
            clusters,
        // force the origin to execute the cancellation as a system user
        /**
                SearchRequest ccsLocalSearchRequest = SearchRequest.subSearchRequest(
        for (int i = 0; i < pruningResult.originalShardGroups(); i++) {
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
                    routingMap,
            remoteClusterClient.search(ccsSearchRequest, new ActionListener<SearchResponse>() {
                    false
                default:
                        searchResponse.isTimedOut(),
                timeProvider.getAbsoluteStartMillis(),
        Map<String, AliasFilter> remoteAliasMap,
                return true;
        failIfOverShardCountLimit(clusterService, shardIterators.size());
        void executeOnShardTarget(
        if (taskId != null && taskId != TaskId.EMPTY_TASK_ID) {
    }
                            timeProvider,
    static GroupShardsIterator<SearchShardIterator> mergeShardsIterators(
            final CountDown countDown = new CountDown(totalClusters);
 * KIND, either express or implied.  See the License for the
            );
        Tracer tracer,
                    logger,
                    listener,
import org.opensearch.telemetry.metrics.MetricsRegistry;
            }
            innerOnResponse(response);
                aliasFilter,
        SearchTimeProvider timeProvider
                        remoteClusterIndices,
                    task,
                        indexRoutings,
        }
            clusters,
import org.opensearch.cluster.routing.OperationRouting;
        TimeValue searchContextKeepAlive,
            requestedIndices.localOriginalIndices,
                // situations when source is rewritten to null due to a bug
                    searchContextKeepAlive
            ClusterSearchShardsResponse searchShardsResponse = entry.getValue();
        ClusterState clusterState,
 */
                        listener.onResponse(SearchResponse.empty(timeProvider::buildTookInMillis, new SearchResponse.Clusters(1, 0, 1)));
        IndicesService indicesService,
    private static ActionListener<SearchResponse> createCCSListener(
                    );
                    new OriginalIndices(finalIndices, originalIndices.indicesOptions())
                                listener,
    private final ThreadPool threadPool;
                finalListner.onResponse(searchResponse);
        final GroupShardsIterator<SearchShardIterator> shardIterators = mergeShardsIterators(localShardIterators, remoteShardIterators);
        SearchTimeProvider timeProvider
     * coordinator search issued during rewrite would otherwise make the request compete with itself. Only the immediate,
            );
                        logger,
        return new CCSActionListener<SearchResponse, SearchResponse>(
 * this file be licensed under the Apache-2.0 license or a
                    );
            boolean skipUnavailable = remoteClusterService.isSkipUnavailable(clusterAlias);
        final SearchTimeProvider timeProvider = new SearchTimeProvider(
    ) {
            if (clusterNodes == null) {
        });
        @Override
    }
                task,
                    searchAsyncActionProvider,
                        executor,
                        listener,
                            r,
    @Override
        CircuitBreakerService circuitBreakerService,
import org.opensearch.transport.client.node.NodeClient;
import java.util.ArrayList;
    }
            String clusterAlias,
                        (r, l) -> executeLocalSearch(
        Map<String, OriginalIndices> remoteIndices,
        OriginalIndicesAndSearchContextId requestedIndices = extractRequestedIndices(searchRequest, clusterState);
            listener,
    static boolean shouldMinimizeRoundtrips(SearchRequest searchRequest) {
        if (searchRequest.allowPartialSearchResults() == null) {
import org.opensearch.cluster.node.DiscoveryNode;
        if (searchRequest.pointInTimeBuilder() != null) {
            (SearchTask) task,
                                remoteShardIterators,
            } else {
                Client remoteClusterClient = remoteClusterService.getRemoteClusterClient(threadPool, clusterAlias);
                    break;
                    actionName,
                };
            if (Strings.isEmpty(perNode.getClusterAlias())) {
            return indexMetadata != null && indexMetadata.isSystem();
        final Map<String, AliasFilter> aliasFilterMap = new HashMap<>();
                                new SearchResponse.Clusters(totalClusters, successfulClusters, skippedClusters.get()),
            searchAsyncActionProvider,
                : source.trackTotalHitsUpTo();
            remoteClusterIndices = getIndicesFromSearchContexts(searchContext, searchRequest.indicesOptions());
                    searchRequest.searchType(QUERY_THEN_FETCH);
                ClusterState clusterState,
        this.searchRequestOperationsCompositeListenerFactory = searchRequestOperationsCompositeListenerFactory;
        abstract FinalResponse createFinalResponse();
                    perNode.getSearchContextId(),
            final SearchContextId searchContext = requestedIndices.searchContextId;
                    timeProvider,
                    );
import org.opensearch.tasks.Task;
                        responsesCountDown,
        Map<String, Float> concreteIndexBoosts = resolveIndexBoosts(searchRequest, clusterState);
        OriginalIndices localIndices,
                timeProvider,
        return onlySystemIndices ? threadPool.executor(ThreadPool.Names.SYSTEM_READ) : threadPool.executor(ThreadPool.Names.SEARCH);
            searchRequest,
    record OriginalIndicesAndSearchContextId(OriginalIndices localOriginalIndices, Map<String, OriginalIndices> remoteClusterIndices,
         * start of the search operation according to a relative clock. The total time the search
    }
                String clusterAlias = entry.getKey();
            Map<String, Float> concreteIndexBoosts,
        ).start();
import org.opensearch.transport.StreamTransportService;
                ) {
import org.opensearch.cluster.routing.ShardIterator;
            // if we are searching against a single remote cluster, we simply forward the original search request to such cluster
                                    searchShardsResponses,
        OriginalIndices localIndices = remoteClusterIndices.remove(RemoteClusterAware.LOCAL_CLUSTER_GROUP_KEY);
                return;
        final boolean onlySystemIndices = Arrays.stream(indices).allMatch(index -> {
        // only if task is of type CancellableTask and support cancellation on timeout, treat this request eligible for timeout based
                        searchRequest.preference(),
        ClusterState clusterState,
import org.opensearch.transport.TransportService;
            originalSearchRequest.setPhaseTook(clusterService.getClusterSettings().get(SEARCH_PHASE_TOOK_ENABLED));
    }
            assert searchRequest.pointInTimeBuilder() != null;
                    ) {
    /**
            new ClusterStateFieldDomainProvider()
                taskResourceTrackingService::getTaskResourceUsageFromThreadContext
        this.remoteClusterService = searchTransportService.getRemoteClusterService();
            timeProvider,
                task::isCancelled
    ) {
                        connectionLookup,
                    listener,
                // this ends up in the hits returned with the search response
            source.from(0);
        }
                    return;
        this.indexNameExpressionResolver = indexNameExpressionResolver;
        }
        ) {
        String preference,
    protected void doExecute(Task task, SearchRequest searchRequest, ActionListener<SearchResponse> listener) {
            concreteLocalIndices = indices.namesOfConcreteIndicesAsArray();
    static List<SearchShardIterator> getLocalLocalShardsIteratorFromPointInTime(
        aliasFilterMap.putAll(remoteAliasMap);
            }
import org.opensearch.core.common.Strings;
            @Override
                    shardId,
import org.opensearch.threadpool.ThreadPool;
        public final void onResponse(Response response) {
        SearchTimeProvider(final long absoluteStartMillis, final long relativeStartNanos, final LongSupplier relativeCurrentNanosProvider) {
import java.util.concurrent.atomic.AtomicInteger;
            }
        Property.Dynamic,
                        return includeSearchContext;
        }, (e) -> {
                                    searchShardsResponses,
            AliasFilter aliasFilter = searchService.buildAliasFilter(clusterState, index.getName(), indicesAndAliases);
                    FinalResponse response;
                indicesService.getSearchResponseStatusStats().inc(searchResponse.status());
                            isThrottleCounted(task) ? localTaskId(task) : TaskId.EMPTY_TASK_ID
            try {
import org.opensearch.search.pipeline.SearchPipelineService;
        private final long relativeStartNanos;
                        searchRequestContext
                        rewriteListener
                timeProvider,
        Map<String, Set<String>> indexRoutings,
    void cancelTask(SearchTask task, Exception exc) {
                searchRequest.pointInTimeBuilder().getKeepAlive()
         *
        return indexNameExpressionResolver.concreteResolvedIndices(clusterState, localIndices, timeProvider.getAbsoluteStartMillis());
                remoteShardIterators.add(shardIterator);
                        timeProvider,
        searchAsyncActionProvider.asyncSearchAction(
                        concreteIndexBoosts,
            );
        executeSearch(
        SearchSourceBuilder source,
                                searchShardsResponses
                // add the cluster name to the remote index names for indices disambiguation
                @Override
                        searchRequest.routing(),
                        localIndices,
            nodes::get,
import java.util.stream.StreamSupport;
        return (clusterAlias, nodeId) -> {
                            }
                        void innerOnResponse(ClusterSearchShardsResponse clusterSearchShardsResponse) {
                if (shouldMinimizeRoundtrips(searchRequest)) {
        Executor executor,
                    new SearchShardIterator(
            indexRoutings = Collections.emptyMap();
            }
                        localClusterAlias,
                executor,
                ActionListener<SearchResponse> listener,
        boolean includeSearchContext,
                assert clusterAlias.equals(perNode.getClusterAlias()) : clusterAlias + " != " + perNode.getClusterAlias();
                }
import static org.opensearch.action.admin.cluster.node.tasks.get.GetTaskAction.TASKS_ORIGIN;
                        searchService.aggReduceContextBuilder(searchRequest.source()),
            localShardIterators = getLocalLocalShardsIteratorFromPointInTime(
        );
                remoteCluster = true;
        if (searchRequest.isCcsMinimizeRoundtrips() == false) {
            return taskManager.getTask(taskId.getId());
        SearchRequest searchRequest,
            maybeFinish();
        IndicesOptions indicesOptions,
                searchRequest.source(source);
                        searchRequest,
            public AbstractSearchAsyncAction<? extends SearchPhaseResult> asyncSearchAction(
        SearchResponse.Clusters clusters,
                .searchShards(
        final Map<String, Set<String>> indexRoutings;
                        searchTransportService,
        SearchAsyncActionProvider searchAsyncActionProvider,
                        targetNodes,
                searchRequest.routing(),
                    clusters,
                        clusterState,
                pruningResult.shardIterators().get(i).resetAndSkip();
            preFilter,
                SearchTask task,
        };
    /** The maximum number of shards for a single search request. */
                            localIndices,
        SliceBuilder slice,
                    throw new IllegalStateException("Unknown search type: [" + searchRequest.searchType() + "]");
        long getAbsoluteStartMillis() {
        String clusterAlias,
    final CircuitBreaker circuitBreaker;
    private ResolvedIndices.Local.Concrete resolveLocalIndices(
        CCSActionListener(
                    // convert to Q_T_F if we have only suggest
                        ),
     * wrapped only when that parent was counted, so a counted ancestor is always the immediate parent. Non-search parents
        return task instanceof WorkloadGroupTask && ((WorkloadGroupTask) task).isThrottleCounted();
    ) {
                ib.getIndex()
            return false;
                    @Override
                .map(it -> new SearchShardIterator(searchRequest.getLocalClusterAlias(), it.shardId(), it.getShardRoutings(), localIndices))
        }
                        (WorkloadGroupTask) task,
        if (searchRequest.searchType() == DFS_QUERY_THEN_FETCH) {
                executeLocalSearch(
        this.metricsRegistry = metricsRegistry;
 * license agreements. See the NOTICE file distributed with
                    false,
        RemoteClusterService remoteClusterService,
                    totalClusters,
                        updatedListener = WorkloadGroupService.releaseThrottlePermitBeforeCompletion(updatedListener, throttlePermit);
         */
        Map<String, Set<String>> indexRoutings,
            final Map<String, AliasFilter> indicesAndFilters = searchShardsResponse.getIndicesAndFilters();
                        Map<String, ClusterSearchShardsResponse> createFinalResponse() {
/*
                    exceptions,
                            timeProvider::getAbsoluteStartMillis,
    ) {
                        searchRequestContext
        SearchRequestContext searchRequestContext
                    searchTransportService,
    }
        GroupShardsIterator<SearchShardIterator> shardIterators,
                    tracer
        AbstractSearchAsyncAction<? extends SearchPhaseResult> asyncSearchAction(
            throw new IllegalArgumentException(
    final SearchPhaseController searchPhaseController;
                SearchResponse.Clusters clusters,
            Collections.emptyList(),
            concreteLocalIndices = localIndices == null ? new String[0] : localIndices.indices();
    @Override
        final Executor asyncSearchExecutor = asyncSearchExecutor(concreteLocalIndices, clusterState);
            return nodeToConnection.apply(remoteCluster ? clusterAlias : null, discoveryNode);
            ActionListener<SearchResponse> listener;
    private final SearchIndexPruningService searchIndexPruningService;
                    connectionLookup,
        }
                    Map<String, ProfileShardResult> profileResults = searchResponse.getProfileResults();
        SearchPhaseController searchPhaseController,
        final ActionListener<SearchResponse> finalListner = listener;
                "Trying to query "
                        clusterState,
            } finally {
import org.opensearch.search.aggregations.InternalAggregation;
                } else {
        final SearchIndexPruningResult pruningResult = searchIndexPruningService.prune(
                        }, listener::onFailure)
        SearchRequestContext searchRequestContext
     */
                SearchShardIterator shardIterator = new SearchShardIterator(
                        executor,
import org.opensearch.action.admin.cluster.shards.ClusterSearchShardsRequest;
    static boolean shouldPreFilterSearchShards(ClusterState clusterState, SearchRequest searchRequest, String[] indices, int numShards) {
                        connectionLookup,
        }
            localIndices,
        }
            }
                if (exceptions.compareAndSet(null, exception) == false) {
                        searchRequest.indicesOptions(),
        return createSearchAsyncAction(
        final Map<String, Set<String>> indices = new HashMap<>();
        }
        ClusterState clusterState,
                    + SHARD_COUNT_LIMIT_SETTING.getKey()
        // of just for the _search api
            searchRequest,
        final String[] concreteLocalIndices;
            searchRequest.getLocalClusterAlias(),
    // cluster level setting for timeout based search cancellation. If search request level parameter is present then that will take
                    skippedClusters,
        SearchResponse.Clusters clusters,
                assert requestClusterAlias == null || requestClusterAlias.equals(clusterAlias);
                }
        @Nullable SearchContextId searchContext,
            );
            }
    private AbstractSearchAsyncAction<? extends SearchPhaseResult> createSearchAsyncAction(
        );
    private final IndexNameExpressionResolver indexNameExpressionResolver;
        return ActionListener.wrap(source -> {
                        queryResultConsumer,
                    collectSearchShards(
        OriginalIndices originalIndices,
            if (pruningResult.isPrunedShardGroup(i)) {
            );
                    false
        if (task instanceof CancellableTask) {
            }
            concreteIndexBoosts,
        Map<String, AliasFilter> aliasFilter,
        if (searchRequest.pointInTimeBuilder() != null) {
            AtomicInteger skippedClusters = new AtomicInteger(0);
     * intended. Remote parents are skipped -- the throttle is per node, and {@code TaskManager#getTask} is node-local.
                                (SearchTask) task,
    private static void failIfOverShardCountLimit(ClusterService clusterService, int shardCount) {
        this.threadPool = threadPool;
        Map<String, OriginalIndices> remoteIndicesByCluster,
        AtomicInteger skippedClusters,
        ActionListener<SearchResponse> listener,
            ClusterSearchShardsRequest searchShardsRequest = new ClusterSearchShardsRequest(indices).indicesOptions(indicesOptions)
                        timeProvider,
        // searchStatusStatsUpdateListener will execute the logic within the original listener but
                indicesService.getSearchResponseStatusStats().inc(ExceptionsHelper.status(e));
        @Override
        TimeValue keepAlive
        Map<String, Float> concreteIndexBoosts = new HashMap<>();
                    nodeSearchCounts,
                            searchResponse.getScrollId(),
        String errorMsg = exc.getMessage() != null ? exc.getMessage() : "";
import org.opensearch.telemetry.tracing.listener.TraceableActionListener;
import static org.opensearch.action.search.SearchType.DFS_QUERY_THEN_FETCH;
            listener = TimeoutTaskCancellationUtility.wrapWithCancellationListener(
            SearchRequest ccsSearchRequest = SearchRequest.subSearchRequest(
import org.opensearch.telemetry.tracing.Span;
            final ClusterState clusterState = clusterService.state();
            this.skippedClusters = skippedClusters;
                task.getProgressListener(),
                        SearchActionListener<SearchPhaseResult> listener
    }
            }
                .slice(slice);
                shardIterators.size(),
            task,
        for (Map.Entry<String, ClusterSearchShardsResponse> entry : searchShardsResp.entrySet()) {
        SearchService.NO_TIMEOUT,
    }
        GroupShardsIterator<SearchShardIterator> shardIterators,
                    );
                    try {
                    indices.indices(),
                    ccsRemoteReduce(
                        skippedClusters,
        if (preFilter) {
                clusterState,
        }
                    new CCSActionListener<ClusterSearchShardsResponse, Map<String, ClusterSearchShardsResponse>>(
                    localIndices,
        return ResolvedIndices.of(localConcreteIndices).withRemoteIndices(requestedIndices.remoteClusterIndices);
                    searchRequestContext
        final Map<String, OriginalIndices> remoteClusterIndices;
            this.relativeStartNanos = relativeStartNanos;
        BiFunction<String, String, Transport.Connection> connectionLookup,
        String requestClusterAlias,
            );
import org.opensearch.common.lease.Releasable;
                case DFS_QUERY_THEN_FETCH:
            SearchRequestOperationsListener.CompositeListener requestOperationsListeners;
    static void ccsRemoteReduce(
    }
    ) {
            Client remoteClusterClient = remoteClusterService.getRemoteClusterClient(threadPool, clusterAlias);
        Setting.Property.NodeScope
import org.opensearch.common.Nullable;
        String localClusterAlias,
            @Override
                    + shardCount
import org.opensearch.cluster.block.ClusterBlockLevel;
        // cancellation mechanism. For such cases, the SearchRequest when created can override the createTask and set the
            return new CanMatchPreFilterSearchPhase(
            SearchTransportService.registerRequestHandler(transportService, searchService);
                            } else {
    }
                Map<String, Float> concreteIndexBoosts,
                            l,
        return false;
            OriginalIndices indices = entry.getValue();
            }
                        originalListener.onFailure(e);
        Property.NodeScope
        List<SearchShardIterator> remoteShardIterators,
        String routing,
            AbstractSearchAsyncAction<? extends SearchPhaseResult> searchAsyncAction;
    }
                remoteShardIterators.add(shardIterator);
        NodeClient client,
                shardIterators,
        BiConsumer<SearchRequest, ActionListener<SearchResponse>> localSearchConsumer,
            if (task instanceof WorkloadGroupTask) {
 * Modifications Copyright OpenSearch Contributors. See
                    );
                        searchTransportService,
                    + shardCountLimit
            for (Map.Entry<String, OriginalIndices> entry : remoteIndices.entrySet()) {
        long buildTookInMillis() {
import org.opensearch.transport.RemoteClusterAware;
                    }
                    }
                        skippedClusters,
                searchContext,
                    clusterState,
import org.opensearch.wlm.WorkloadGroupService;
                    Arrays.asList(clusterSearchShardsGroup.getShards()),
 *
    }
            String clusterAlias = entry.getKey();
            trackTotalHitsUpTo = SearchContext.DEFAULT_TRACK_TOTAL_HITS_UP_TO;
    }
        if (shardIterators.size() == 1) {
                }
        this.taskResourceTrackingService = taskResourceTrackingService;
            Collections.emptyMap(),
                        )
        boolean skipUnavailable,
                    if (throttlePermit != null) {
    }
            SearchTask task,
                connectionLookup,
import org.opensearch.common.inject.Inject;
    private final MetricsRegistry metricsRegistry;
                    new ArraySearchPhaseResults<>(shardsIts.size()),
        ClusterState clusterState,
                        clusters,
            new SearchTimeProvider(searchRequest.getOrCreateAbsoluteStartMillis(), System.nanoTime(), System::nanoTime)
            SearchResponse.Clusters.EMPTY,
        ThreadPool threadPool,
        final Map<String, AliasFilter> aliasFilterMap = new HashMap<>();
                clusterState,
                            searchShardsResponses.put(clusterAlias, clusterSearchShardsResponse);
        this.searchPhaseController = searchPhaseController;
        this.searchPipelineService = searchPipelineService;
            SearchResponse createFinalResponse() {
import static org.opensearch.search.sort.FieldSortBuilder.hasPrimaryFieldSort;
                        listener
            final boolean remoteCluster;
            // and we directly perform final reduction in the remote cluster
                final Task parentTask = extractParentTask(originalSearchRequest);
        for (SearchSourceBuilder.IndexBoost ib : source.indexBoosts()) {
                );
    ) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                        searchResponse.getHits(),
        SearchTimeProvider timeProvider,
                    localIndices.indices(),
    }
            Client clusterClient = remoteClusterService.getRemoteClusterClient(threadPool, clusterAlias);
                finalListner.onFailure(e);
import org.opensearch.action.search.pruning.FieldDomainEvaluationContext;
    private static boolean isThrottleCounted(final Task task) {
                        executor,
        ActionFilters actionFilters,
        OriginalIndices localIndices,
        return null;
     * Applies index pruning results to the request-local shard iterators.
                        threadPool,
                listener,
     * took. These two uses are at odds with each other. There are many issues with using a real
                logger,
        private final LongSupplier relativeCurrentNanosProvider;
     *
            return false;
import org.opensearch.telemetry.tracing.SpanBuilder;
                        task,
        Long.MAX_VALUE,
        Map<String, ClusterSearchShardsResponse> searchShardsResponses,
            }
            final IndexMetadata indexMetadata = clusterState.metadata().index(index);
import org.opensearch.index.query.Rewriteable;
                    protected SearchPhase getNextPhase(SearchPhaseResults<SearchPhaseResult> results, SearchPhaseContext context) {
            SliceBuilder slice = searchRequest.source() == null ? null : searchRequest.source().slice();
                    timeProvider,
                @Override
        final Map<String, AliasFilter> aliasFilter;
    final NodeClient client;
                    timeProvider,
                    )
                                clusterState,
        if (searchContext != null) {
    private static boolean hasReadOnlyIndices(String[] indices, ClusterState clusterState) {
            for (DiscoveryNode remoteNode : entry.getValue().getNodes()) {
 * software distributed under the License is distributed on an
import org.opensearch.action.support.TimeoutTaskCancellationUtility;
        Setting.Property.Dynamic,
        this.searchService = searchService;
                                searchAsyncActionProvider,
         * Instantiates a new search time provider. The absolute start time is the real clock time
                // Before onRequestStart, so a rejection doesn't leak the request gauges.
            ClusterBlockException writeBlock = clusterState.blocks().indexBlockedException(ClusterBlockLevel.WRITE, index);
import org.opensearch.search.SearchService;
        }
import org.opensearch.action.admin.cluster.shards.ClusterSearchShardsGroup;
            if (discoveryNode == null) {
        return new SearchResponseMerger(from, size, trackTotalHitsUpTo, timeProvider, aggReduceContextBuilder);
        }
                    break;
                } else {
        }
        SearchTask task,
                    protected void executePhaseOnShard(
import org.opensearch.telemetry.tracing.listener.TraceableSearchRequestOperationsListener;
                tracer
                    shardId,
                public void onFailure(Exception e) {
            new FieldDomainEvaluationContext(timeProvider::getAbsoluteStartMillis)
        return aliasFilterMap;
        Map<String, ClusterSearchShardsResponse> searchShardsResponses,
                    indexRoutings,
        private final CountDown countDown;
                        timeProvider,
            StreamSearchTransportService.registerStreamRequestHandler((StreamTransportService) transportService, searchService);
    ) {
     * "now" to an index name). Another clock is needed for measuring how long a search operation
                    listener,
                    + ". This limit exists because querying many shards at the same time can make the "
        SearchRequestContext searchRequestContext
                Map<String, Set<String>> indexRoutings,
        for (Index index : concreteIndices.concreteIndices()) {
import org.opensearch.search.profile.SearchProfileShardResults;
                GroupShardsIterator<SearchShardIterator> shardsIts,
    ) {
            || source.collapse().getInnerHits() == null
                                localIndices,
        ThreadPool threadPool,
            for (ClusterSearchShardsGroup clusterSearchShardsGroup : searchShardsResponse.getGroups()) {
                    createSearchAsyncAction(
                searchRequest,
                                remoteShardIterators = getRemoteShardsIterator(
            SearchTask searchTask,
        }, listener);
    ) {
                ActionListener<SearchResponse> ccsListener = createCCSListener(
        );
            );
/*
        final long shardCountLimit = clusterService.getClusterSettings().get(SHARD_COUNT_LIMIT_SETTING);
    }
     * to moving backwards due to NTP and other such complexities, etc.). There are also issues with
                        perNode.getSearchContextId(),
                    rewriteListener.onResponse(sr.source());
            originalSearchRequest.getOrCreateAbsoluteStartMillis(),
                final String clusterAlias = entry.getKey();
                            searchRequestContext
                        aliasFilter,
    static List<SearchShardIterator> getRemoteShardsIterator(
            return ResolvedIndices.Local.Concrete.empty();
    private Map<String, AliasFilter> buildPerIndexAliasFilter(
import org.opensearch.telemetry.tracing.Tracer;
        final List<SearchShardIterator> remoteShardIterators = new ArrayList<>();
        private final boolean skipUnavailable;
                        skipUnavailable,
    static SearchResponseMerger createSearchResponseMerger(
            (clusterName, nodeId) -> null,
            }, listener::onFailure);
 * The OpenSearch Contributors require contributions made to
            aliasFilter,
                discoveryNode = remoteNodes.apply(clusterAlias, nodeId);
    private final NamedWriteableRegistry namedWriteableRegistry;
                            int localClusters = localIndices == null ? 0 : 1;
    /**
        private void maybeFinish() {
            shardIterators,
                public void onResponse(SearchResponse searchResponse) {
import org.opensearch.action.admin.cluster.node.tasks.cancel.CancelTasksRequest;
        for (Map.Entry<String, ClusterSearchShardsResponse> entry : searchShardsResponses.entrySet()) {
