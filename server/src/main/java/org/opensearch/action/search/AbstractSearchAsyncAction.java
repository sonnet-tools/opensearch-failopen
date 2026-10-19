            getNumShards(),
        // it's number of active shards but use 1 as the default if no replica of a shard is active at this point.
import org.opensearch.cluster.routing.FailAwareWeightedRouting;  
                successfulOps.decrementAndGet(); // if this shard was successful before (initial phase) we have to adjust the counter
    @Override
    }
        if (currentPhaseHasLifecycle) {  
        return currentPhase;  
            searchRequestContext.setTotalHits(internalSearchResponse.hits().getTotalHits());
                    "[{}] Moving to next phase: [{}], based on results from: {} (cluster state version: {})",
                return true;  
        ActionListener<SearchResponse> listener,
        final String[] routings = indexRoutings.getOrDefault(indexName, Collections.emptySet()).toArray(new String[0]);  
        String scrollId,
    }  
                    InternalSearchResponse.empty(withTotalHits),  
            assert request.allowPartialSearchResults() != null : "SearchRequest missing setting for allowPartialSearchResults";
            .findNext(shardIt, clusterState, e, () -> totalOps.incrementAndGet());
                    throw new SearchPhaseExecutionException(getName(), msg, null, ShardSearchFailure.EMPTY_ARRAY);
import org.opensearch.cluster.ClusterState;
        List<ShardSearchFailure> entries = shardFailures.asList();
    @Override
            onRequestEnd(searchRequestContext);  
            onPhaseEnd(searchRequestContext);
            } else {
                    clusterState.version()
            }
import org.apache.logging.log4j.message.ParameterizedMessage;
         * at least one successful operation left and if so we move to the next phase. If not we immediately fail the
        this.tracer = tracer;  
         * same thread (because we never went async, or the same thread was selected from the thread pool) or a different thread. If we
    }
            if (currentPhaseHasLifecycle == false) {  
            }
                assert shardRoutings.skip() == false;  
                        phase,
                ),
    }  
        } else {
        if (shardsIt.skip()) {  
            skippedOps.get(),  
        return searchRequestContext;
        String indexName = shardIt.shardId().getIndex().getName();
    }
                // check if there are actual failures in the atomic array since
        final List<SearchShardIterator> toSkipIterators = new ArrayList<>();
        onRequestFailure(searchRequestContext);
        }
    private final Map<String, Float> concreteIndexBoosts;
        assert allowPartialResults != null : "SearchRequest missing setting for allowPartialSearchResults";
                r.run();  
         */
                         * It is possible to run into connection exceptions here because we are getting the connection early and might
            filter,  
        }  
        ShardSearchFailure[] failures = buildShardFailures();
        SearchShardTarget shard,
                )
                    // Status red - shard is missing all copies and would produce partial results for an index search  
            ((PipelinedRequest) request).transformSearchPhaseResults(results, this, this.getName(), nextPhase.getName());
        // in the #addShardFailure, because by definition, it will happen on *another* shardIndex  
        if (request instanceof PipelinedRequest && nextPhase != null) {
        }
                // we can not allow a stuffed queue to reject execution here
import org.opensearch.telemetry.tracing.Tracer;
            if (r != null) {
    @Override  
     * Override this method to provide custom listener implementations (e.g., streaming listeners).
        if (currentPhaseHasLifecycle) {  
        // of search phase that wraps SearchAsyncActionPhase as SearchPhase. The AbstractSearchAsyncAction manages own  
        return logger;
                            // It only happens when onPhaseDone() is called and executePhaseOnShard() fails hard with an exception.
    }
                searchContextId = SearchContextId.encode(queryResults.asList(), aliasFilter, minNodeVersion);
                }
    private final Map<String, PendingExecutions> pendingExecutionsPerNode = new ConcurrentHashMap<>();  
    }  
                    executePhaseOnShard(shardIt, shard, listener);  
        );
    @Override
        this.throttleConcurrentRequests = maxConcurrentRequestsPerNode < shardsIts.size();
            indexBoost,
    private SearchPhase currentPhase;
                        inner.addSuppressed(exception);
import java.util.concurrent.Executor;
    /**  
        for (final SearchShardIterator iterator : toSkipShardsIts) {
 *
    public void setPhaseResourceUsages() {  
                final Thread thread = Thread.currentThread();
    private final SearchRequest request;
    /**
        this.clusterState = clusterState;
            );
        GroupShardsIterator<SearchShardIterator> shardsIts,  
                    .map(result -> result.getSearchShardTarget().getShardId().getIndex())
import java.util.Collections;  
                if (TransportActions.isReadOverrideException(e)) {
                            successfulOps.get(),
        String name,
            onPhaseEnd(searchRequestContext);
    private final SearchResponse.Clusters clusters;  
         * continue on the same thread in the case that we never went async and this happens repeatedly we will end up recursing deeply and
                    onShardResult(result, shardIt);  
     * @param shardIndex the shard index
        this.clusters = clusters;
            }
    }  
            );
        SearchRequestContext searchRequestContext,
         * We capture the thread that this phase is starting on. When we are called back after executing the phase, we are either on the  
        String searchContextId
        if (getCurrentPhase() != null) {
                            skippedOps.get(),  
        }  
    ShardSearchFailure[] buildShardFailures() {  
        this.searchRequestContext.getSearchRequestOperationsListener().onRequestEnd(this, searchRequestContext);
        }  
    /**  
        Releasables.close(releasables);
    public final Transport.Connection getConnection(String clusterAlias, String nodeId) {
        });
                    }
    final int expectedTotalOps;  
                }
                permitsTaken++;
    public final SearchTask getTask() {  
        } else if (totalOps > expectedTotalOps) {
            assert allowPartialResults != null : "SearchRequest missing setting for allowPartialSearchResults";
                : request.source().trackTotalHitsUpTo();
    }
                    ShardSearchFailure.EMPTY_ARRAY,
    private final Map<String, Set<String>> indexRoutings;
     */  
        if (xTotalOps == expectedTotalOps) {  
            }
                ? pendingExecutionsPerNode.computeIfAbsent(shard.getNodeId(), n -> new PendingExecutions(maxConcurrentRequestsPerNode))
                            // In this case calling onShardFailure() would overflow the operations counter, so the best we could do  
        return timeProvider.buildTookInMillis();
            public void innerOnResponse(Result result) {
                    nextPhase.getName(),  
            @Override
     * @param e the failure reason
            tryRun(null);  
            }
            onShardGroupFailure(shardIndex, shard, e);
        this.nodeIdToConnection = nodeIdToConnection;
    }
    }
    @Override  
                pendingExecutions.tryRun(r);
        Span phaseSpan = tracer.startSpan(SpanCreationContext.server().name("[phase/" + phase.getName() + "]"));  
        final SearchPhase nextPhase = getNextPhase(results, this);  
        Map<String, Set<String>> indexRoutings,
                        shard,
            public void onFailure(Exception t) {  
         * could stack overflow. To prevent this, we fork if we are called back on the same thread that execution started on and otherwise  
            executePhase(nextPhase);  
        if (request.pointInTimeBuilder() == null) {
    }
        }  
        // onPhaseStart / onPhaseFailure / OnPhaseDone callbacks and the wrapping SearchPhase is being abandoned
     * This method will also notify the listener and sends back a failure to the user.
    AbstractSearchAsyncAction(
                    permitsTaken--;
     */
    ) {  
    }  
        this.maxConcurrentRequestsPerNode = maxConcurrentRequestsPerNode;  
 * KIND, either express or implied.  See the License for the
        this.executor = executor;  
     * @see #onShardResult(SearchPhaseResult, SearchShardIterator)  
                        logger.debug(
                            // here is to fail the phase and move on to the next one.
                if (shardSearchFailures.length > 0) {
            @Override
            if (permitsTaken < permits) {  
                    }  
                            if (totalOps.get() == expectedTotalOps) {
        }
        void tryRun(Runnable runnable) {  
        }  
            fork(() -> onShardFailure(shardIndex, null, shardIt, new NoShardAvailableActionException(shardIt.shardId())));
        final int shardIndex,
            if (iterator.skip()) {
    private final Object shardFailuresMutex = new Object();
    private void executePhase(SearchPhase phase) {
    }
            );
            }
import java.util.Map;
                    try {
                    final SearchPhase phase = this;  
                    executeNext(pendingExecutions, thread);
                }
        private ArrayDeque<Runnable> queue = new ArrayDeque<>();  
     **/
 */  
            } else if (runnable != null) {  
        } finally {
            Throwable cause = shardSearchFailures.length == 0  
        successfulShardExecution(shardIt);
    private boolean currentPhaseHasLifecycle;  
                        logger.trace("failed to release context", inner);
 *
    private final ActionListener<SearchResponse> listener;  
 * ownership. Elasticsearch licenses this file to you under  
    }
        hasShardResponse.set(true);
            if (throttleConcurrentRequests) {
    private void onPhaseStart(SearchPhase phase) {
        if (lastShard) {
        void finishAndRunNext() {
import org.opensearch.common.lease.Releasables;
            }  
    /**
        } else {
                        onPhaseFailure(phase, "The phase has failed", t);
     */
            Runnable toExecute = null;
        Tracer tracer
            return ShardSearchFailure.EMPTY_ARRAY;  
        }
            }
        // we always add the shard failure for a specific shard instance
    private void onPhaseEnd(SearchRequestContext searchRequestContext) {
        listener.onFailure(e);  
                "unexpected higher total ops [" + xTotalOps + "] compared to expected [" + expectedTotalOps + "]",
            final ShardOperationFailedException[] shardSearchFailures = ExceptionsHelper.groupBy(buildShardFailures());
    }
    protected abstract SearchPhase getNextPhase(SearchPhaseResults<Result> results, SearchPhaseContext context);
        SearchTask task,  
    private final AtomicInteger skippedOps = new AtomicInteger();
        return searchTransportService;
     * Executed once for every successful shard level request.  
                    return;  
                runnable.run();  
        SearchShardIterator shardIt,
    );
                                onShardFailure(shardIndex, shard, shardIt, e);
        // if we already received a search result we can inform the shard that it
                )
                    }
        searchRequestContext.recordPhaseResourceUsage(taskResourceUsage);
    ) {
    /**
            searchRequestContext.getPhaseTook(),
            // lazily create shard failures, so we can early build the empty shard failure list in most cases (no failures)  
        if (successfulOps.get() == 0) { // we have 0 successful results that means we shortcut stuff and return a failure
        this.setPhaseResourceUsages();
                    0,  
                        shardIt,
        successfulOps.incrementAndGet();  
                if (toExecute == null) {  
     * Used by subclasses to resolve node ids to DiscoveryNodes.  
    }
                        Throwable cause = OpenSearchException.guessRootCauses(shardSearchFailures[0].getCause())[0];
                    "{}: Failed to execute [{}] lastShard [{}]",  
    private void fork(final Runnable runnable) {  
        );  
            }
        this.timeProvider = timeProvider;  
        successfulOps.incrementAndGet();
        successfulShardExecution(iterator);
     *                   it's results  
    }
     */
        return nodeIdToConnection.apply(clusterAlias, nodeId);  
    }
     * @param listener the listener to notify on response
        return request;  
import java.util.concurrent.ConcurrentHashMap;
            logger.trace(
        setPhaseResourceUsages();
 *  
    void successfulShardExecution(SearchShardIterator shardsIt) {
import org.opensearch.OpenSearchException;
    private final BiFunction<String, String, Transport.Connection> nodeIdToConnection;
                    request,  
import java.util.concurrent.TimeUnit;  
     * @param shardIt the shard iterator  
        }
    protected final SearchPhaseResults<Result> results;
        } catch (Exception e) {
import org.opensearch.common.util.concurrent.AbstractRunnable;  
            if (results.hasResult(shardIndex)) {  
            }
     */
import org.opensearch.core.tasks.resourcetracker.TaskResourceInfo;
import org.opensearch.common.lease.Releasable;
 * Licensed to Elasticsearch under one or more contributor  
                    }
            if (buildPointInTimeFromSearchResults()) {
                    final SearchShardIterator shardRoutings = shardsIts.get(index);  
        // phase.  
     *                executed shard request
         * search phase as "all shards failed"*/  
            } catch (final Exception ex) {
                    searchRequestContext.getPhaseTook(),  
    }
            }
                        missingShards.append(shardRoutings.shardId());
            onRequestEnd(searchRequestContext);  
import org.opensearch.search.internal.ShardSearchRequest;
        }  
import org.opensearch.search.SearchPhaseResult;  
                }
    void executeNext(PendingExecutions pendingExecutions, Thread originalThread) {  
        // and when that happens, we break on total ops, so we must maintain them  
    /**  
                        shardFailures = new AtomicArray<>(getNumShards());
                        pendingExecutions,  
    @Override  
                onPhaseDone();
                } catch (Exception e) {
        return shardRequest;
        /*
import org.opensearch.core.index.shard.ShardId;
    @Override
                        int numShardFailures = shardSearchFailures.length;  
                onPhaseFailure(this, "The phase has failed", ex);  
    }  
            public boolean isForceExecution() {
                        Transport.Connection connection = getConnection(searchShardTarget.getClusterAlias(), searchShardTarget.getNodeId());
 * The OpenSearch Contributors require contributions made to  
        this.expectedTotalOps = shardsIts.totalSizeWith1ForEmpty();
import org.opensearch.search.pipeline.PipelinedRequest;  
            try {  
    long buildTookInMillis() {  
        results.consumeShardFailure(shardIndex);
                    .collect(Collectors.toSet())  
        final Thread thread  
            throw new AssertionError(
    public final SearchTransportService getSearchTransport() {
                } catch (final Exception e) {
    final AtomicInteger totalOps = new AtomicInteger();
        this.logger = logger;
     * @param shard the shard target
                    lastShard  
            int trackTotalHitsUpTo = request.source() == null ? SearchContext.DEFAULT_TRACK_TOTAL_HITS_UP_TO
    }
    public final Logger getLogger() {
                permitsTaken--;  
     * Builds how long it took to execute the search.
            } else {
        return new SearchActionListener<Result>(shard, shardIndex) {
    private final List<Releasable> releasables = new ArrayList<>();
            for (int index = 0; index < shardsIts.size(); index++) {
     *  
            searchContextId
                        onShardFailure(shardIndex, shard, shardIt, t);  
        }
                        sendReleaseSearchContext(entry.getContextId(), connection, searchShardTarget.getOriginalIndices());
        }
    ) {  
            logger.trace("got first-phase result from {}", result != null ? result.getSearchShardTarget() : null);  
            onPhaseFailure(phase, "", e);
        } else {
        setPhaseResourceUsages();
     * Pending Executions
                    logger.trace("Failed to consume the shard {} result: {}", shard.getShardId(), e);
        executor.execute(command);
import org.opensearch.telemetry.tracing.Span;
     * @see #onShardFailure(int, SearchShardTarget, Exception)
        SearchShardTarget nextShard = FailAwareWeightedRouting.getInstance()  
        private synchronized Runnable tryQueue(Runnable runnable) {
/*  
            }  
    }
            if (originalThread == Thread.currentThread()) {  
                    int discrepancy = getNumShards() - successfulOps.get();
            } else {  
                        /*  
        final int totalOps = this.totalOps.incrementAndGet();
                    );
        Boolean allowPartialResults = request.allowPartialSearchResults();  
                toExecute = runnable;
                new SearchPhaseExecutionException(getName(), "Shard failures", null, buildShardFailures())
                    executeNext(pendingExecutions, thread);  
            clusters,
     * @return the action listener to use for this shard
     * @param phase the current search phase
        if (getNumShards() == 0) {
            // no search shards to search on, bail with empty response  
                try {
                // the failure is already present, try and not override it with an exception that is less meaningless
                "unexpected higher total ops [" + totalOps + "] compared to expected [" + expectedTotalOps + "]",
        if (TransportActions.isShardNotAvailableException(e) == false) {
            assert permits > 0 : "not enough permits: " + permits;  
            shardIt.getSearchContextId(),
            }
        final SearchPhase phase,
        // clean a previous error on this shard group (note, this code will be serialized on the same shardIndex value level
                    if (totalOps.get() == expectedTotalOps) {  
 * GitHub history for details.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                    shard != null ? shard : shardIt.shardId(),
            assert runnable == null;  
        // TODO: Until we implement the retry mechanism for point in times (i.e., replace an unavailable shard with an equivalent copy),
            assert iterator.skip();  
            if (logger.isDebugEnabled()) {
    private final int maxConcurrentRequestsPerNode;
                : null;
                            currentPhase.getName()
    }
    }
            synchronized (this) {
                         */  
import org.opensearch.ExceptionsHelper;  
     * @param shardTarget the last shard target for this failure  
                    buildTookInMillis(),
        if (totalOps == expectedTotalOps) {
     */
            }
        currentPhaseHasLifecycle = ((phase instanceof WrappingSearchAsyncActionPhase) == false);
 * You may obtain a copy of the License at  
            scrollId,  
                if (request.source() != null && request.source().pointInTimeBuilder() != null) {
    }
        AliasFilter filter = aliasFilter.get(shardIt.shardId().getIndex().getUUID());
        results.consumeResult(result, () -> onShardResultConsumed(result, shardIt));  
            shardIt.getOriginalIndices(),
    private final SetOnce<AtomicArray<ShardSearchFailure>> shardFailures = new SetOnce<>();  
    }
        final List<SearchShardIterator> iterators = new ArrayList<>();  
    SearchActionListener<Result> createShardActionListener(  
                    request,
            this.searchRequestContext.getSearchRequestOperationsListener().onPhaseStart(this);
import java.util.Set;  
                        );  
        final int remainingOpsOnIterator;
            }
        for (final SearchShardIterator iterator : shardsIts) {
    protected void onShardResult(Result result, SearchShardIterator shardIt) {
                        return;
                toSkipIterators.add(iterator);  
                        logger.debug(  
        }
        // on a per shards level we use shardIt.remaining() to increment the totalOps pointer but add 1 for the current shard result  
                try {
            });
        // can return a null response if the request rewrites to match none rather  
    private final TransportSearchAction.SearchTimeProvider timeProvider;
        // than creating an empty response in the search thread pool.
            internalSearchResponse,
        }
    /**
        AtomicArray<ShardSearchFailure> shardFailures = this.shardFailures.get();
     * @param result the result returned form the shard
            listener.onResponse(buildSearchResponse(internalSearchResponse, failures, scrollId, searchContextId));
    }
import java.util.List;
                }
                runnable.run();  
                        shardIndex,  
        this.concreteIndexBoosts = concreteIndexBoosts;  
                            cause
                : request.source().trackTotalHitsUpTo() == null ? SearchContext.DEFAULT_TRACK_TOTAL_HITS_UP_TO  
            onPhaseStart(phase);
        int maxConcurrentRequestsPerNode,
            AtomicArray<ShardSearchFailure> shardFailures = this.shardFailures.get();
     * @param results the results of the initial search phase. Each non null element in the result array represent a successfully  
        assert iterator.skip();  
     * Sends the request to the actual shard.
                        }
    @Override  
            searchRequestContext.setSuccessfulSearchShardIndices(  
            remainingOpsOnIterator = shardsIt.remaining() + 1;  
                            }  
        Executor executor,  
            return;
        }
            // Log the message without an exception.  
                synchronized (shardFailuresMutex) {
            }  
    }
                final StringBuilder missingShards = new StringBuilder();  
            phase.recordAndRun();  
        // we need to add 1 for non active partition, since we count it in the total. This means for each shard in the iterator we sum up
         * we can continue (cf. InitialSearchPhase#maybeFork).
                    toExecute = queue.poll();
    }
            return toExecute;  
    /**
        Releasables.close(releasables);  
                shardFailures.set(shardIndex, new ShardSearchFailure(e, shardTarget));  
                fork(runnable);
    private final AtomicInteger successfulOps = new AtomicInteger();  
        SearchPhaseResults<Result> resultConsumer,
            try {
    }
        TaskResourceInfo taskResourceUsage = searchRequestContext.getTaskResourceUsageSupplier().get();
                    null,
        }
                final SearchShardIterator shardRoutings = shardsIts.get(index);
    private final Executor executor;
        if (shard == null) {  
                    } catch (Exception inner) {  
                }
 * not use this file except in compliance with the License.
    public final void onFailure(Exception e) {
        }
    public final void onPhaseFailure(SearchPhase phase, String msg, Throwable cause) {
                            () -> new ParameterizedMessage("{} shards failed for phase: [{}]", numShardFailures, getName()),
    public void addReleasable(Releasable releasable) {
     */  
     * Executed once for every {@link ShardId} that failed on all available shard routing.  
            shardIt.getClusterAlias(),  
import org.opensearch.action.NoShardAvailableActionException;  
    protected void onShardGroupFailure(int shardIndex, SearchShardTarget shardTarget, Exception exc) {}  
import org.opensearch.search.internal.SearchContext;
            Boolean allowPartialResults = request.allowPartialSearchResults();
        // so its ok concurrency wise to miss potentially the shard failures being created because of another failure
                if (toExecute == null) { // only poll if we don't have anything to execute  
    }
    }  
    protected final SearchResponse buildSearchResponse(
        SearchActionListener<Result> listener  
    public final ShardSearchRequest buildShardSearchRequest(SearchShardIterator shardIt) {
        if (allowPartialResults == false && failures.length > 0) {
/**  
import java.util.ArrayDeque;
                                onPhaseFailure(this, "The phase has failed", e);  
import org.opensearch.telemetry.tracing.SpanCreationContext;
                        if (missingShards.length() > 0) {
        SearchTransportService searchTransportService,
        private int permitsTaken = 0;
        if (throttleConcurrentRequests) {
        // The WrappingSearchAsyncActionPhase (see please CanMatchPreFilterSearchPhase as one example) is a special case
            skipShard(iterator);
                );  
        setCurrentPhase(phase);  
                    }  
            }
            final Version minNodeVersion = clusterState.nodes().getMinNodeVersion();
        final boolean lastShard = nextShard == null;  
 * The fan out and collect algorithm is traditionally used as the initial phase which can either be a query execution or collection of
        listener.onFailure(exception);  
        AtomicArray<ShardSearchFailure> shardFailures = this.shardFailures.get();
                ? TransportSearchHelper.buildScrollId(queryResults, request.indices(), minNodeVersion)
        return results.getNumShards();  
                r.run();
                    0,
    private final boolean throttleConcurrentRequests;
        }  
import org.opensearch.search.SearchShardTarget;
}  
        // we don't release persistent readers (point in time).
                    final String msg = "Search rejected due to missing shards ["
    public void sendSearchResponse(InternalSearchResponse internalSearchResponse, AtomicArray<SearchPhaseResult> queryResults) {
import java.util.function.BiFunction;  
     * @param thread the current thread for fork logic  
        try (final SpanScope scope = tracer.withSpanInScope(phaseSpan)) {
        super(name);
import org.opensearch.core.action.ShardOperationFailedException;  
            }
import org.opensearch.common.util.concurrent.AtomicArray;
                results.getSuccessfulResults()
    @Override
     */
        // in the case were we have less shards than maxConcurrentRequestsPerNode we don't need to throttle
/*
 * under the License.  
        // we can simply return the point in time of the search request.
        }
        this.task = task;
    }
 */
        if (logger.isTraceEnabled()) {
        } else {
     * This method should be called if a search phase failed to ensure all relevant reader contexts are released.
        /* This is the main search phase transition where we move to the next phase. At this point we check if there is
    private final SearchTransportService searchTransportService;
                            missingShards.append(", ");  
        Map<String, Float> concreteIndexBoosts,
        executePhase(this);  
import org.opensearch.search.internal.InternalSearchResponse;  
     * @param exc the last failure reason
     * @param exception the exception explaining or causing the phase failure
                }
    private void onShardResultConsumed(Result result, SearchShardIterator shardIt) {
     * @param shardIndex the internal index for this shard. Each shard has an index / ordinal assigned that is used to reference
        // Note that, we have to disable this shortcut for queries that create a context (scroll and search context).
    @Override
        this.results = resultConsumer;  
    public final void execute(Runnable command) {  
                performPhaseOnShard(shardIndex, shardIt, nextShard);  
                } finally {  
            if (lastShard == false) {
        // we don't aggregate shard failures on non active shards (but do keep the header counts right)  
                    if (!request.indicesOptions().ignoreUnavailable()) {
import java.util.ArrayList;
                    shard != null ? shard : shardIt.shardId(),
        assert result.getShardIndex() != -1 : "shard index is not set";
    boolean buildPointInTimeFromSearchResults() {  
                }
                    try {
                for (int index = 0; index < shardsIts.size(); index++) {
                        shardSearchFailures = ExceptionsHelper.groupBy(shardSearchFailures);
            this.searchRequestContext.getSearchRequestOperationsListener().onPhaseFailure(this, cause);
    @Override
            } else {
        }
                    }
        float indexBoost = concreteIndexBoosts.getOrDefault(shardIt.shardId().getIndex().getUUID(), DEFAULT_INDEX_BOOST);
        assert result.getSearchShardTarget() != null : "search shard target must not be null";  
            if (allowPartialResults == false && successfulOps.get() != getNumShards()) {  
        if (shardsIts.size() > 0) {  
 * and collect the results. If a shard request returns a failure this class handles the advance to the next replica of the shard until
                    SearchActionListener<Result> listener = createShardActionListener(
                    }
    protected final GroupShardsIterator<SearchShardIterator> shardsIts;
        for (int i = 0; i < failures.length; i++) {
            };  
        InternalSearchResponse internalSearchResponse,
                    } else {
                : null;
abstract class AbstractSearchAsyncAction<Result extends SearchPhaseResult> extends SearchPhase implements SearchPhaseContext {
 * this file be licensed under the Apache-2.0 license or a
            listener.onResponse(
            successfulOps.get(),
        }  
                phaseSpan.endSpan();
                logger.debug(new ParameterizedMessage("Failed to execute [{}] while moving to [{}] phase", request, phase.getName()), e);  
            onPhaseFailure(currentPhase, "all shards failed", cause);
        this.searchRequestContext = searchRequestContext;
        this.request = request;
            failures,  
    private final AtomicBoolean hasShardResponse = new AtomicBoolean(false);
    public final void start() {
        this.listener = ActionListener.runAfter(listener, this::releaseContext);  
                        + "]. Consider using `allow_partial_search_results` setting to bypass this error.";  
    public final void onShardFailure(final int shardIndex, @Nullable SearchShardTarget shardTarget, Exception e) {
        assert filter != null;  
import org.opensearch.transport.Transport;
        this.shardsIts = new GroupShardsIterator<>(iterators);  
    private final SearchTask task;  
            this.permits = permits;
            @Override
    @Override  
        this.aliasFilter = aliasFilter;
        SearchResponse.Clusters clusters,  
                    assert discrepancy > 0 : "discrepancy: " + discrepancy;  
        } else {
        // we do make sure to clean it on a successful response from a shard  
    }
    @Override  
            } else {  
                iterators.add(iterator);
    public final int getNumShards() {
                    currentPhase.getName(),
            final String scrollId = request.scroll() != null  
            boolean withTotalHits = trackTotalHitsUpTo != SearchContext.TRACK_TOTAL_HITS_DISABLED;  
    protected SearchRequestContext getSearchRequestContext() {  
                    if (shardRoutings.size() == 0) {
    @Override  
                onPhaseFailure(this, "The phase has failed", ex);
                    "{}: Failed to execute [{}] lastShard [{}]",
        ClusterState clusterState,
            if (currentPhaseHasLifecycle == false) {  
    void skipShard(SearchShardIterator iterator) {  
            searchRequestContext.updatePhaseTookMap(getCurrentPhase().getName(), TimeUnit.NANOSECONDS.toMillis(tookInNanos));
            results.getSuccessfulResults().forEach((entry) -> {  
     * @param shardIndex the shard index that failed
        }
                        SearchShardTarget searchShardTarget = entry.getSearchShardTarget();  
                try {
import org.opensearch.action.support.TransportActions;
    private void performPhaseOnShard(final int shardIndex, final SearchShardIterator shardIt, final SearchShardTarget shard) {
    public final void run() {
        TransportSearchAction.SearchTimeProvider timeProvider,
    /**  
                    clusters,
                phaseSpan.setError(e);
            }  
/*  
                         * run into nodes that are not connected. In this case, on shard failure will move us to the next shard copy.
        }
            if (failure == null) {
        };  
package org.opensearch.action.search;
     *
 * referred to as the {@code shardIndex}.
        raisePhaseFailure(new SearchPhaseExecutionException(phase.getName(), msg, cause, buildShardFailures()));  
     *  
        }
 *     http://www.apache.org/licenses/LICENSE-2.0
            // (it happens with search across _all with no indices around and consistent with broadcast operations)
import java.util.concurrent.atomic.AtomicInteger;
                    }
import org.opensearch.cluster.routing.GroupShardsIterator;
                } else {
 */  
     * @param shardTarget the shard target for this failure
                    if (logger.isDebugEnabled()) {
            searchRequestContext.setShardStats(results.getNumShards(), successfulOps.get(), skippedOps.get(), failures.length);
    private void setCurrentPhase(SearchPhase phase) {  
            );
                logger.trace(  
            final PendingExecutions pendingExecutions = throttleConcurrentRequests  
            );
        skippedOps.incrementAndGet();
        } else {
import java.util.stream.Collectors;
            }  
                assert permitsTaken >= 0 : "illegal taken permits: " + permitsTaken;
    }
                    null  
                } else {  
 * compatible open source license.
import org.opensearch.core.action.ActionListener;
            failures[i] = entries.get(i);
            timeProvider.getAbsoluteStartMillis(),
                        thread
        // cause the successor to read a wrong value from successfulOps if second phase is very fast ie. count etc.
        this.indexRoutings = indexRoutings;
        executor.execute(new AbstractRunnable() {
        ShardSearchRequest shardRequest = new ShardSearchRequest(
        shardRequest.canReturnNullResponseIfMatchNoDocs(hasShardResponse.get() && shardRequest.scroll() == null);  
            }
                } finally {
                    searchContextId = null;
    }
            } catch (final Exception ex) {  
     * Executed once for every failed shard level request. This method is invoked before the next replica is tried for the given  
            Runnable r = tryQueue(runnable);
                        onPhaseFailure(currentPhase, "Partial shards failure (" + discrepancy + " shards unavailable)", null);  
        return false;  
            routings,
        return failures;
    protected final GroupShardsIterator<SearchShardIterator> toSkipShardsIts;
        }
                }
        if (shardFailures != null) {
        }
    }
     * @param shard the shard routing to send the request for  
                // successful retries can reset the failures to null
     */  
            if (request.allowPartialSearchResults() == false) {
                    shardFailures = this.shardFailures.get(); // read again otherwise somebody else has created it?  
                onPhaseDone();
            }
 * the shards replica iterator is exhausted. Each shard is referenced by position in the {@link GroupShardsIterator} which is later  
import org.apache.logging.log4j.Logger;
     */
                final String resultsFrom = results.getSuccessfulResults()  
        if (shardFailures == null) {
    private static final float DEFAULT_INDEX_BOOST = 1.0f;
            }
            }  
                }  
import org.opensearch.telemetry.tracing.SpanScope;  
                    lastShard
 * This is an abstract base class that encapsulates the logic to fan out to all shards in provided {@link GroupShardsIterator}
                    shardFailures.set(shardIndex, new ShardSearchFailure(e, shardTarget));
        return task;
            if (shardFailures == null) { // this is double checked locking but it's fine since SetOnce uses a volatile read internally
            protected void doRun() {
        }  
        setCurrentPhase(null);  
                if (missingShards.length() > 0) {
        releasables.add(releasable);
                            discrepancy,
     * Returns the next phase based on the results of the initial search phase
                        executeNext(pendingExecutions, thread);  
                () -> new ParameterizedMessage(  
            this.searchRequestContext.getSearchRequestOperationsListener().onPhaseEnd(this, searchRequestContext);
            getNumShards(),
                        );  
                        fork(() -> {
    public final SearchRequest getRequest() {
        } else if (xTotalOps > expectedTotalOps) {  
            shardIt.getSearchContextKeepAlive()  
            ShardSearchFailure failure = shardFailures.get(shardIndex);
            buildTookInMillis(),
 *
        final SearchShardIterator shardIt,  
    void onShardFailure(final int shardIndex, @Nullable SearchShardTarget shard, final SearchShardIterator shardIt, Exception e) {
 * the Apache License, Version 2.0 (the "License"); you may
        final SearchShardTarget shard,
                    // It only happens when onPhaseDone() is called and executePhaseOnShard() fails hard with an exception.
     * @opensearch.internal
                    onPhaseFailure(currentPhase, "Partial shards failure", null);
                            getNumShards(),
            logger.debug(() -> new ParameterizedMessage("All shards failed for phase: [{}]", getName()), cause);  
            remainingOpsOnIterator = shardsIt.remaining();
        executeNextPhase(this, nextPhase);
                // for example, getting illegal shard state  
                }
                        });
                    if (logger.isDebugEnabled()) {
        return new SearchResponse(
    /**
     * Extension point to create the appropriate action listener for shard execution.
    public void releaseContext() {
                queue.add(runnable);
        } else {  
        this.searchRequestContext.getSearchRequestOperationsListener().onRequestFailure(this, searchRequestContext);
                new SearchResponse(
            if (logger.isTraceEnabled()) {
    }  
 * @opensearch.internal
    private final Logger logger;  
                    searchContextId = request.source().pointInTimeBuilder().getId();
                ? null
import org.opensearch.search.internal.AliasFilter;
        Logger logger,  
    /**
        // increment all the "future" shards to update the total ops since we some may work and some may not...
        onShardFailure(shardIndex, shard, e);
    }
     * shard target.
                new ParameterizedMessage(
        SearchRequest request,
        // we process hence we add one for the non active partition here.
        this.searchTransportService = searchTransportService;
            request,  
        executeNext(pendingExecutions == null ? null : pendingExecutions::finishAndRunNext, originalThread);
        if (logger.isTraceEnabled()) {
                new SearchPhaseExecutionException(getName(), "Shard failures", null, buildShardFailures())  
            shardFailures.set(result.getShardIndex(), null);  
 * software distributed under the License is distributed on an
import org.opensearch.Version;
 * Modifications Copyright OpenSearch Contributors. See
        // are fast we could concurrently update totalOps but then preempt one of the threads which can  
    private final SearchRequestContext searchRequestContext;
                if (entry.getContextId() != null) {
     *  
            );  
 * specific language governing permissions and limitations
 * Unless required by applicable law or agreed to in writing,
     * Executed once all shard results have been received and processed
        PendingExecutions(int permits) {
        final PendingExecutions pendingExecutions,
     * @param shardIt the shard iterator
     * This is the main entry point for a search. This method starts the search execution of the initial phase.
import org.opensearch.common.Nullable;
     * @param pendingExecutions pending executions for throttling
                }  
 * license agreements. See the NOTICE file distributed with
    private final Map<String, AliasFilter> aliasFilter;  
                    .collect(Collectors.joining(","));
        ShardSearchFailure[] failures,  
        // (fe, has no onPhaseEnd callbacks called ever). To fix that, we would not send any notifications for this
        // we need to increment successful ops first before we compare the exit condition otherwise if we
                        this.shardFailures.set(shardFailures);  
            throw new AssertionError(  
        this.toSkipShardsIts = new GroupShardsIterator<>(toSkipIterators);
                e  
import java.util.concurrent.atomic.AtomicBoolean;
            final String searchContextId;  
 */  
    void executeNext(Runnable runnable, Thread originalThread) {
    public SearchPhase getCurrentPhase() {
            Runnable r = () -> {  
    protected abstract void executePhaseOnShard(  
        currentPhase = phase;
            long tookInNanos = System.nanoTime() - getCurrentPhase().getStartTimeInNanos();  
            // total hits is null in the response if the tracking of total hits is disabled
                        + missingShards
    private void onRequestFailure(SearchRequestContext searchRequestContext) {
                    } finally {
     * @param shardIt the shards iterator
            public void onFailure(Exception e) {  
            @Override  
import org.opensearch.common.SetOnce;  
 * this work for additional information regarding copyright
    private final ClusterState clusterState;
    private void raisePhaseFailure(SearchPhaseExecutionException exception) {  
            raisePhaseFailure(new SearchPhaseExecutionException("", "Shard failures", null, failures));  
            logger.debug(
                            "Partial shards failure (unavailable: {}, successful: {}, skipped: {}, num-shards: {}, phase: {})",  
    private final Tracer tracer;  
 * SPDX-License-Identifier: Apache-2.0
    }  
                    .map(r -> r.getSearchShardTarget().toString())
        BiFunction<String, String, Transport.Connection> nodeIdToConnection,
    private void onRequestEnd(SearchRequestContext searchRequestContext) {  
    }
        Map<String, AliasFilter> aliasFilter,  
                            } else {
            shardIt.shardId(),
                    0,
     * @param context the search context for the next phase
    /**  
                performPhaseOnShard(index, shardRoutings, shardRoutings.nextOrNull());
        private final int permits;
            @Override  
    }
                    if (shardFailures == null) { // still null so we are the first and create a new instance
     */  
                // Fail-fast verification of all shards being available
        final int xTotalOps = totalOps.addAndGet(remainingOpsOnIterator);
        }
                    resultsFrom,
    final void onPhaseDone() {  // as a tribute to @kimchy aka. finishHim()
                assert failure == null : "shard failed before but shouldn't: " + failure;
    static final class PendingExecutions {  
                : OpenSearchException.guessRootCauses(shardSearchFailures[0].getCause())[0];
    @Override
            }
    }  
 * distributed frequencies  
                ShardOperationFailedException[] shardSearchFailures = buildShardFailures();  
        ShardSearchFailure[] failures = new ShardSearchFailure[entries.size()];  
        if (currentPhaseHasLifecycle) {
    public final void executeNextPhase(SearchPhase currentPhase, SearchPhase nextPhase) {  
