            }
            }
        }
            );
    }
    /**
 * not use this file except in compliance with the License.
            }
        return logger;
     */
    ) {
            public void innerOnResponse(Result result) {
import org.opensearch.core.action.ShardOperationFailedException;
                        Throwable cause = OpenSearchException.guessRootCauses(shardSearchFailures[0].getCause())[0];
     */
                synchronized (shardFailuresMutex) {
        if (logger.isTraceEnabled()) {
        listener.onFailure(e);
     */
            return toExecute;
            Boolean allowPartialResults = request.allowPartialSearchResults();
                    shardFailures = this.shardFailures.get(); // read again otherwise somebody else has created it?
import org.apache.logging.log4j.Logger;
                if (entry.getContextId() != null) {
            executePhase(nextPhase);
import org.opensearch.ExceptionsHelper;
                            "Partial shards failure (unavailable: {}, successful: {}, skipped: {}, num-shards: {}, phase: {})",
     */
     * @param shardTarget the last shard target for this failure
        }
    private void executePhase(SearchPhase phase) {
        raisePhaseFailure(new SearchPhaseExecutionException(phase.getName(), msg, cause, buildShardFailures()));
    }
            logger.debug(() -> new ParameterizedMessage("All shards failed for phase: [{}]", getName()), cause);
         * we can continue (cf. InitialSearchPhase#maybeFork).
            results.getSuccessfulResults().forEach((entry) -> {
            public void onFailure(Exception t) {
     */
     * @param shardIndex the shard index that failed
        this.clusterState = clusterState;
        final boolean lastShard = nextShard == null;
                // Fail-fast verification of all shards being available
    @Override
        for (final SearchShardIterator iterator : shardsIts) {
    }
     */
                            () -> new ParameterizedMessage("{} shards failed for phase: [{}]", numShardFailures, getName()),
                r.run();
     * @param exception the exception explaining or causing the phase failure
    @Override
        }
    protected abstract void executePhaseOnShard(
                    if (logger.isDebugEnabled()) {
                    if (shardRoutings.size() == 0) {
    private final SearchResponse.Clusters clusters;
        return currentPhase;
        }
                    final SearchShardIterator shardRoutings = shardsIts.get(index);
     * Executed once all shard results have been received and processed
            }
            @Override
                    "{}: Failed to execute [{}] lastShard [{}]",
                onPhaseDone();
    private final AtomicInteger successfulOps = new AtomicInteger();
    }
        // of search phase that wraps SearchAsyncActionPhase as SearchPhase. The AbstractSearchAsyncAction manages own
                    } finally {
        // in the #addShardFailure, because by definition, it will happen on *another* shardIndex
import org.opensearch.search.internal.ShardSearchRequest;
        // than creating an empty response in the search thread pool.
                    executeNext(pendingExecutions, thread);
                    final String msg = "Search rejected due to missing shards ["
            } else {
 * You may obtain a copy of the License at
        releasables.add(releasable);
        } finally {
            successfulOps.get(),
     */
    private final TransportSearchAction.SearchTimeProvider timeProvider;
            shardIt.getOriginalIndices(),
        /* This is the main search phase transition where we move to the next phase. At this point we check if there is
            failures[i] = entries.get(i);
                ShardOperationFailedException[] shardSearchFailures = buildShardFailures();
        }
    private void raisePhaseFailure(SearchPhaseExecutionException exception) {
                if (request.source() != null && request.source().pointInTimeBuilder() != null) {
                         * run into nodes that are not connected. In this case, on shard failure will move us to the next shard copy.
    }
            @Override
                        return;
    void onShardFailure(final int shardIndex, @Nullable SearchShardTarget shard, final SearchShardIterator shardIt, Exception e) {
            if (logger.isTraceEnabled()) {
                        SearchShardTarget searchShardTarget = entry.getSearchShardTarget();
    /**
        }
import org.opensearch.core.index.shard.ShardId;
                logger.trace(
                assert shardRoutings.skip() == false;
            skipShard(iterator);
                            skippedOps.get(),
        this.throttleConcurrentRequests = maxConcurrentRequestsPerNode < shardsIts.size();
                    SearchActionListener<Result> listener = createShardActionListener(
                }
 * distributed frequencies
    SearchActionListener<Result> createShardActionListener(
    protected final SearchResponse buildSearchResponse(
        final SearchPhase nextPhase = getNextPhase(results, this);
                            successfulOps.get(),
        executor.execute(command);
            }
                    shard != null ? shard : shardIt.shardId(),
                fork(runnable);
        }
    public void releaseContext() {
            }
    private final List<Releasable> releasables = new ArrayList<>();
        this.setPhaseResourceUsages();
    AbstractSearchAsyncAction(
    /**
            if (failure == null) {
 * Licensed to Elasticsearch under one or more contributor
    @Override
     *
                    currentPhase.getName(),
/*
                        + "]. Consider using `allow_partial_search_results` setting to bypass this error.";
                }
            this.searchRequestContext.getSearchRequestOperationsListener().onPhaseEnd(this, searchRequestContext);
        if (xTotalOps == expectedTotalOps) {
         * could stack overflow. To prevent this, we fork if we are called back on the same thread that execution started on and otherwise
            try {
    @Override
                    clusters,
     */
        if (TransportActions.isShardNotAvailableException(e) == false) {
            .findNext(shardIt, clusterState, e, () -> totalOps.incrementAndGet());
import org.opensearch.search.SearchPhaseResult;
        /*
                ? null
    public void addReleasable(Releasable releasable) {
    }
        final int remainingOpsOnIterator;
                iterators.add(iterator);
            }
        final int xTotalOps = totalOps.addAndGet(remainingOpsOnIterator);
        // we always add the shard failure for a specific shard instance
                    }
    protected SearchRequestContext getSearchRequestContext() {
import org.opensearch.search.pipeline.PipelinedRequest;
            timeProvider.getAbsoluteStartMillis(),
                    null,
    /**
        if (shardFailures != null) {
        executeNext(pendingExecutions == null ? null : pendingExecutions::finishAndRunNext, originalThread);
                    } catch (Exception inner) {
                // check if there are actual failures in the atomic array since
     *
                        onShardFailure(shardIndex, shard, shardIt, t);
     * This method will also notify the listener and sends back a failure to the user.
import org.opensearch.search.internal.AliasFilter;
        Executor executor,
    }
     * @param shardIt the shard iterator
    @Override
        }
        if (request.pointInTimeBuilder() == null) {
    }
    private void onPhaseStart(SearchPhase phase) {
    protected void onShardResult(Result result, SearchShardIterator shardIt) {
import org.opensearch.search.internal.InternalSearchResponse;
            }
                        });
                    }
    private final Tracer tracer;
    private final Map<String, AliasFilter> aliasFilter;
     * @param listener the listener to notify on response
import org.opensearch.core.action.ActionListener;
        hasShardResponse.set(true);
    private final boolean throttleConcurrentRequests;
    public final void start() {
    private final ClusterState clusterState;
        SearchShardTarget shard,
    }
            }
        return results.getNumShards();
    static final class PendingExecutions {
import org.opensearch.cluster.routing.FailAwareWeightedRouting;
    private void setCurrentPhase(SearchPhase phase) {
            for (int index = 0; index < shardsIts.size(); index++) {
 * under the License.
        return timeProvider.buildTookInMillis();
            this.searchRequestContext.getSearchRequestOperationsListener().onPhaseFailure(this, cause);
     * @param shard the shard routing to send the request for
                        fork(() -> {
                final Thread thread = Thread.currentThread();
    private final Map<String, PendingExecutions> pendingExecutionsPerNode = new ConcurrentHashMap<>();
            onPhaseStart(phase);
            internalSearchResponse,
        } else {
    @Override
                new SearchPhaseExecutionException(getName(), "Shard failures", null, buildShardFailures())
import org.opensearch.common.SetOnce;
import java.util.ArrayList;
                searchContextId = SearchContextId.encode(queryResults.asList(), aliasFilter, minNodeVersion);
    }
        BiFunction<String, String, Transport.Connection> nodeIdToConnection,
            ShardSearchFailure failure = shardFailures.get(shardIndex);
import java.util.function.BiFunction;
                    request,
import org.opensearch.action.NoShardAvailableActionException;
    private final SetOnce<AtomicArray<ShardSearchFailure>> shardFailures = new SetOnce<>();
    private final SearchRequestContext searchRequestContext;
            @Override
import org.opensearch.OpenSearchException;
    public final int getNumShards() {
            boolean withTotalHits = trackTotalHitsUpTo != SearchContext.TRACK_TOTAL_HITS_DISABLED;
            );
    void executeNext(PendingExecutions pendingExecutions, Thread originalThread) {
 * this work for additional information regarding copyright
         */
            // total hits is null in the response if the tracking of total hits is disabled
        return request;
import org.opensearch.telemetry.tracing.Span;
            skippedOps.get(),
 */
    );
        setPhaseResourceUsages();
                    permitsTaken--;
 * and collect the results. If a shard request returns a failure this class handles the advance to the next replica of the shard until
    }
                            missingShards.append(", ");
                    lastShard
        // if we already received a search result we can inform the shard that it
        }
            }
 * SPDX-License-Identifier: Apache-2.0
                successfulOps.decrementAndGet(); // if this shard was successful before (initial phase) we have to adjust the counter
                );
 * the shards replica iterator is exhausted. Each shard is referenced by position in the {@link GroupShardsIterator} which is later
    protected abstract SearchPhase getNextPhase(SearchPhaseResults<Result> results, SearchPhaseContext context);
                : request.source().trackTotalHitsUpTo();
                    nextPhase.getName(),
    protected void onShardGroupFailure(int shardIndex, SearchShardTarget shardTarget, Exception exc) {}
                if (toExecute == null) { // only poll if we don't have anything to execute
    private final SearchTask task;
        this.maxConcurrentRequestsPerNode = maxConcurrentRequestsPerNode;
        skippedOps.incrementAndGet();
    private void onRequestFailure(SearchRequestContext searchRequestContext) {
                    int discrepancy = getNumShards() - successfulOps.get();
     * Builds how long it took to execute the search.
        Releasables.close(releasables);
            indexBoost,
        // we don't aggregate shard failures on non active shards (but do keep the header counts right)
            buildTookInMillis(),
    private void onPhaseEnd(SearchRequestContext searchRequestContext) {
                    assert discrepancy > 0 : "discrepancy: " + discrepancy;
    void successfulShardExecution(SearchShardIterator shardsIt) {
                return true;
    /**
        return new SearchResponse(
                    searchRequestContext.getPhaseTook(),
            assert runnable == null;
    boolean buildPointInTimeFromSearchResults() {
     * Used by subclasses to resolve node ids to DiscoveryNodes.
     *
            }
            @Override
        Map<String, Float> concreteIndexBoosts,
                    .map(r -> r.getSearchShardTarget().toString())
            shardIt.getSearchContextId(),
    }
        this.searchRequestContext.getSearchRequestOperationsListener().onRequestFailure(this, searchRequestContext);
 */
 *     http://www.apache.org/licenses/LICENSE-2.0
                // we can not allow a stuffed queue to reject execution here
import java.util.ArrayDeque;
     * @param result the result returned form the shard
                onPhaseFailure(this, "The phase has failed", ex);
            }
        } else {
        return false;
                        thread
        // on a per shards level we use shardIt.remaining() to increment the totalOps pointer but add 1 for the current shard result
     * @param shard the shard target
import org.opensearch.search.internal.SearchContext;
                        logger.trace("failed to release context", inner);
    private final AtomicBoolean hasShardResponse = new AtomicBoolean(false);
            if (currentPhaseHasLifecycle == false) {
        };
                    executeNext(pendingExecutions, thread);
            Throwable cause = shardSearchFailures.length == 0
        if (shard == null) {
    }
 *
        if (shardsIts.size() > 0) {
            final String searchContextId;
            clusters,
        }
import org.opensearch.transport.Transport;
                queue.add(runnable);
        );
    }
                toExecute = runnable;
                    .map(result -> result.getSearchShardTarget().getShardId().getIndex())
    private SearchPhase currentPhase;
                    if (logger.isDebugEnabled()) {
            }
        Map<String, AliasFilter> aliasFilter,
        super(name);
                if (missingShards.length() > 0) {
     **/
            long tookInNanos = System.nanoTime() - getCurrentPhase().getStartTimeInNanos();
    }
                            if (totalOps.get() == expectedTotalOps) {
        executePhase(this);
     * @param shardIndex the internal index for this shard. Each shard has an index / ordinal assigned that is used to reference
        } else if (xTotalOps > expectedTotalOps) {
                        logger.debug(
                onPhaseFailure(this, "The phase has failed", ex);
     * @opensearch.internal
     * Pending Executions
                    if (!request.indicesOptions().ignoreUnavailable()) {
                    }
    public final ShardSearchRequest buildShardSearchRequest(SearchShardIterator shardIt) {
         * search phase as "all shards failed"*/
                performPhaseOnShard(index, shardRoutings, shardRoutings.nextOrNull());
    }
    }
         * same thread (because we never went async, or the same thread was selected from the thread pool) or a different thread. If we
        Map<String, Set<String>> indexRoutings,
                    searchContextId = request.source().pointInTimeBuilder().getId();
    }
    private final ActionListener<SearchResponse> listener;
        if (currentPhaseHasLifecycle) {
        onRequestFailure(searchRequestContext);
        final PendingExecutions pendingExecutions,
            failures,
import org.opensearch.common.util.concurrent.AtomicArray;
                        this.shardFailures.set(shardFailures);
        final Thread thread
        private ArrayDeque<Runnable> queue = new ArrayDeque<>();
                }
 * this file be licensed under the Apache-2.0 license or a
    void executeNext(Runnable runnable, Thread originalThread) {
        SearchTask task,
        Boolean allowPartialResults = request.allowPartialSearchResults();
        // increment all the "future" shards to update the total ops since we some may work and some may not...
            // (it happens with search across _all with no indices around and consistent with broadcast operations)
    public SearchPhase getCurrentPhase() {
            logger.trace("got first-phase result from {}", result != null ? result.getSearchShardTarget() : null);
 * ownership. Elasticsearch licenses this file to you under
        private int permitsTaken = 0;
        this.nodeIdToConnection = nodeIdToConnection;
                phaseSpan.setError(e);
        // cause the successor to read a wrong value from successfulOps if second phase is very fast ie. count etc.
        AtomicArray<ShardSearchFailure> shardFailures = this.shardFailures.get();
        if (getNumShards() == 0) {
 */
                final String resultsFrom = results.getSuccessfulResults()
        // (fe, has no onPhaseEnd callbacks called ever). To fix that, we would not send any notifications for this
     * @param phase the current search phase
        String indexName = shardIt.shardId().getIndex().getName();
        setCurrentPhase(phase);
                            // In this case calling onShardFailure() would overflow the operations counter, so the best we could do
            throw new AssertionError(
     * @param shardIndex the shard index
        final SearchShardTarget shard,
                            }
        Span phaseSpan = tracer.startSpan(SpanCreationContext.server().name("[phase/" + phase.getName() + "]"));
    private final Object shardFailuresMutex = new Object();
import java.util.concurrent.Executor;
    private void fork(final Runnable runnable) {
            assert iterator.skip();
            if (request.allowPartialSearchResults() == false) {
        }
            assert allowPartialResults != null : "SearchRequest missing setting for allowPartialSearchResults";
                         * It is possible to run into connection exceptions here because we are getting the connection early and might
     */
        ClusterState clusterState,
     * Executed once for every {@link ShardId} that failed on all available shard routing.
    private boolean currentPhaseHasLifecycle;
import java.util.concurrent.atomic.AtomicInteger;
        int maxConcurrentRequestsPerNode,
        SearchActionListener<Result> listener
        currentPhaseHasLifecycle = ((phase instanceof WrappingSearchAsyncActionPhase) == false);
    @Override
                        phase,
            AtomicArray<ShardSearchFailure> shardFailures = this.shardFailures.get();
        this.toSkipShardsIts = new GroupShardsIterator<>(toSkipIterators);
    @Override
            shardIt.shardId(),
        InternalSearchResponse internalSearchResponse,
                    }
                    .collect(Collectors.toSet())
                    searchContextId = null;
            routings,
                } catch (final Exception e) {
                            // It only happens when onPhaseDone() is called and executePhaseOnShard() fails hard with an exception.
import java.util.Collections;
import org.opensearch.common.util.concurrent.AbstractRunnable;
        }
        ActionListener<SearchResponse> listener,
        });
import org.opensearch.core.tasks.resourcetracker.TaskResourceInfo;
            getNumShards(),
        this.clusters = clusters;
            });
                )
                : null;
            if (r != null) {
            );
        successfulOps.incrementAndGet();
        AliasFilter filter = aliasFilter.get(shardIt.shardId().getIndex().getUUID());
            } else {
                try {
            }
                    "{}: Failed to execute [{}] lastShard [{}]",
                }
        this.searchRequestContext.getSearchRequestOperationsListener().onRequestEnd(this, searchRequestContext);
                shardFailures.set(shardIndex, new ShardSearchFailure(e, shardTarget));
            remainingOpsOnIterator = shardsIt.remaining();
            if (logger.isDebugEnabled()) {
            return ShardSearchFailure.EMPTY_ARRAY;
    /**
        this.expectedTotalOps = shardsIts.totalSizeWith1ForEmpty();
            shardIt.getSearchContextKeepAlive()
            phase.recordAndRun();
            public boolean isForceExecution() {
            shardIt.getClusterAlias(),
 * Modifications Copyright OpenSearch Contributors. See
abstract class AbstractSearchAsyncAction<Result extends SearchPhaseResult> extends SearchPhase implements SearchPhaseContext {
                    throw new SearchPhaseExecutionException(getName(), msg, null, ShardSearchFailure.EMPTY_ARRAY);
        }
                    ShardSearchFailure.EMPTY_ARRAY,
                for (int index = 0; index < shardsIts.size(); index++) {
        ShardSearchFailure[] failures,
            }
     * @param exc the last failure reason
        this.searchRequestContext = searchRequestContext;
 *
        }
import org.opensearch.action.support.TransportActions;
                } else {
         * We capture the thread that this phase is starting on. When we are called back after executing the phase, we are either on the
        // in the case were we have less shards than maxConcurrentRequestsPerNode we don't need to throttle
            protected void doRun() {
    /**
        currentPhase = phase;
        if (request instanceof PipelinedRequest && nextPhase != null) {
            if (allowPartialResults == false && successfulOps.get() != getNumShards()) {
    }
                e
        assert allowPartialResults != null : "SearchRequest missing setting for allowPartialSearchResults";
            filter,
    /**
                                onPhaseFailure(this, "The phase has failed", e);
                        shardFailures = new AtomicArray<>(getNumShards());
            } else {
import java.util.concurrent.atomic.AtomicBoolean;
        PendingExecutions(int permits) {
    @Override
            this.permits = permits;
     * @param pendingExecutions pending executions for throttling
     */
        this.task = task;
        }
        this.concreteIndexBoosts = concreteIndexBoosts;
    public final SearchTransportService getSearchTransport() {
            final Version minNodeVersion = clusterState.nodes().getMinNodeVersion();
        setCurrentPhase(null);
        final String[] routings = indexRoutings.getOrDefault(indexName, Collections.emptySet()).toArray(new String[0]);
        SearchPhaseResults<Result> resultConsumer,
            if (originalThread == Thread.currentThread()) {
        if (getCurrentPhase() != null) {
        if (allowPartialResults == false && failures.length > 0) {
                    onPhaseFailure(currentPhase, "Partial shards failure", null);
 * license agreements. See the NOTICE file distributed with
        // phase.
    }
            }
        assert result.getSearchShardTarget() != null : "search shard target must not be null";
            Runnable toExecute = null;
    /**
            searchRequestContext.updatePhaseTookMap(getCurrentPhase().getName(), TimeUnit.NANOSECONDS.toMillis(tookInNanos));
     * @return the action listener to use for this shard
                pendingExecutions.tryRun(r);
                () -> new ParameterizedMessage(
    private void onShardResultConsumed(Result result, SearchShardIterator shardIt) {
        final List<SearchShardIterator> iterators = new ArrayList<>();
        this.executor = executor;
                } catch (Exception e) {
                : request.source().trackTotalHitsUpTo() == null ? SearchContext.DEFAULT_TRACK_TOTAL_HITS_UP_TO
                        + missingShards
                ? TransportSearchHelper.buildScrollId(queryResults, request.indices(), minNodeVersion)
            if (lastShard == false) {
    }
        }
        SearchRequestContext searchRequestContext,
    public final void executeNextPhase(SearchPhase currentPhase, SearchPhase nextPhase) {
        } else {
        this.timeProvider = timeProvider;
                permitsTaken++;
    }
     * @param results the results of the initial search phase. Each non null element in the result array represent a successfully
    }
import org.opensearch.telemetry.tracing.SpanScope;
 * KIND, either express or implied.  See the License for the
                        pendingExecutions,
        // we need to add 1 for non active partition, since we count it in the total. This means for each shard in the iterator we sum up
    }
        AtomicArray<ShardSearchFailure> shardFailures = this.shardFailures.get();
            // no search shards to search on, bail with empty response
        void finishAndRunNext() {
            onPhaseEnd(searchRequestContext);
                    return;
     * @see #onShardResult(SearchPhaseResult, SearchShardIterator)
     * This method should be called if a search phase failed to ensure all relevant reader contexts are released.
                        int numShardFailures = shardSearchFailures.length;
        SearchShardTarget nextShard = FailAwareWeightedRouting.getInstance()
    }
        );
                    try {
            getNumShards(),
    public final void run() {
                runnable.run();
import org.opensearch.cluster.routing.GroupShardsIterator;
    long buildTookInMillis() {
    private void onRequestEnd(SearchRequestContext searchRequestContext) {
        // we can simply return the point in time of the search request.
        if (currentPhaseHasLifecycle) {
                    shardFailures.set(shardIndex, new ShardSearchFailure(e, shardTarget));
                                onShardFailure(shardIndex, shard, shardIt, e);
        } else {
                        /*
import java.util.stream.Collectors;
        }
            Runnable r = () -> {
    public final void onPhaseFailure(SearchPhase phase, String msg, Throwable cause) {
     * @param context the search context for the next phase
                ),
                        sendReleaseSearchContext(entry.getContextId(), connection, searchShardTarget.getOriginalIndices());
    public final void onFailure(Exception e) {
        this.request = request;
    }
    private final SearchTransportService searchTransportService;
    public void setPhaseResourceUsages() {
        successfulShardExecution(iterator);
    /**
            @Override
                        shardIndex,
        results.consumeResult(result, () -> onShardResultConsumed(result, shardIt));
    private final Executor executor;
                final StringBuilder missingShards = new StringBuilder();
            }
                        onPhaseFailure(currentPhase, "Partial shards failure (" + discrepancy + " shards unavailable)", null);
     */
                    logger.trace("Failed to consume the shard {} result: {}", shard.getShardId(), e);
        GroupShardsIterator<SearchShardIterator> shardsIts,
            if (throttleConcurrentRequests) {
                permitsTaken--;
            }
import org.opensearch.telemetry.tracing.Tracer;
        this.indexRoutings = indexRoutings;
    @Override
import java.util.List;
    private final Map<String, Set<String>> indexRoutings;
        onShardFailure(shardIndex, shard, e);
                new SearchPhaseExecutionException(getName(), "Shard failures", null, buildShardFailures())
        }
            throw new AssertionError(
        } else if (totalOps > expectedTotalOps) {
                } finally {
            logger.trace(
        } else {
        if (currentPhaseHasLifecycle) {
            searchRequestContext.getPhaseTook(),
            if (currentPhaseHasLifecycle == false) {
                }
    void skipShard(SearchShardIterator iterator) {
     *                   it's results
        ShardSearchRequest shardRequest = new ShardSearchRequest(
        // The WrappingSearchAsyncActionPhase (see please CanMatchPreFilterSearchPhase as one example) is a special case
            listener.onResponse(
                }
            onRequestEnd(searchRequestContext);
    ShardSearchFailure[] buildShardFailures() {
            raisePhaseFailure(new SearchPhaseExecutionException("", "Shard failures", null, failures));
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        } else {
    private static final float DEFAULT_INDEX_BOOST = 1.0f;
    public final SearchRequest getRequest() {
            scrollId,
            onPhaseEnd(searchRequestContext);
    }
        Tracer tracer
            tryRun(null);
    }
    @Override
        TaskResourceInfo taskResourceUsage = searchRequestContext.getTaskResourceUsageSupplier().get();
 * The OpenSearch Contributors require contributions made to
            }
                onPhaseDone();
    }
            searchRequestContext.setTotalHits(internalSearchResponse.hits().getTotalHits());
            assert permits > 0 : "not enough permits: " + permits;
                assert permitsTaken >= 0 : "illegal taken permits: " + permitsTaken;
            );
import org.opensearch.common.Nullable;
        // we don't release persistent readers (point in time).
                ? pendingExecutionsPerNode.computeIfAbsent(shard.getNodeId(), n -> new PendingExecutions(maxConcurrentRequestsPerNode))
    final void onPhaseDone() {  // as a tribute to @kimchy aka. finishHim()
                        shard,
     * Executed once for every successful shard level request.
    @Override
    }
            searchRequestContext.setSuccessfulSearchShardIndices(
    }
        assert filter != null;
                    try {
package org.opensearch.action.search;
                performPhaseOnShard(shardIndex, shardIt, nextShard);
        this.shardsIts = new GroupShardsIterator<>(iterators);
                new SearchResponse(
        } else {
    public final SearchTask getTask() {
        }
        if (logger.isTraceEnabled()) {
        TransportSearchAction.SearchTimeProvider timeProvider,
        final List<SearchShardIterator> toSkipIterators = new ArrayList<>();
                "unexpected higher total ops [" + totalOps + "] compared to expected [" + expectedTotalOps + "]",
     * This is the main entry point for a search. This method starts the search execution of the initial phase.
            );
        assert iterator.skip();
            }
                    0,
     * @see #onShardFailure(int, SearchShardTarget, Exception)
                    }
            if (shardFailures == null) { // this is double checked locking but it's fine since SetOnce uses a volatile read internally
                    final SearchPhase phase = this;
        executor.execute(new AbstractRunnable() {
                if (toExecute == null) {
            try {
        }
                } else {
            }
            assert request.allowPartialSearchResults() != null : "SearchRequest missing setting for allowPartialSearchResults";
                    );
        SearchResponse.Clusters clusters,
 *
            if (iterator.skip()) {
                        shardIt,
                toSkipIterators.add(iterator);
        private final int permits;
            return;
import org.apache.logging.log4j.message.ParameterizedMessage;
        // and when that happens, we break on total ops, so we must maintain them
     * @param e the failure reason
    private final Map<String, Float> concreteIndexBoosts;
            searchRequestContext.setShardStats(results.getNumShards(), successfulOps.get(), skippedOps.get(), failures.length);
 * This is an abstract base class that encapsulates the logic to fan out to all shards in provided {@link GroupShardsIterator}
    private final BiFunction<String, String, Transport.Connection> nodeIdToConnection;
        if (successfulOps.get() == 0) { // we have 0 successful results that means we shortcut stuff and return a failure
                    if (shardFailures == null) { // still null so we are the first and create a new instance
        this.aliasFilter = aliasFilter;
            final String scrollId = request.scroll() != null
        // TODO: Until we implement the retry mechanism for point in times (i.e., replace an unavailable shard with an equivalent copy),
                    0,
                "unexpected higher total ops [" + xTotalOps + "] compared to expected [" + expectedTotalOps + "]",
 * Unless required by applicable law or agreed to in writing,
        return shardRequest;
        this.results = resultConsumer;
    private void performPhaseOnShard(final int shardIndex, final SearchShardIterator shardIt, final SearchShardTarget shard) {
        List<ShardSearchFailure> entries = shardFailures.asList();
    }
                         */
    private final Logger logger;
                            currentPhase.getName()
                        logger.debug(
            fork(() -> onShardFailure(shardIndex, null, shardIt, new NoShardAvailableActionException(shardIt.shardId())));
import org.opensearch.cluster.ClusterState;
}
                new ParameterizedMessage(
                    .collect(Collectors.joining(","));
                runnable.run();
                    // Status red - shard is missing all copies and would produce partial results for an index search
                // for example, getting illegal shard state
     *                executed shard request
        }
import java.util.Map;
        }
            Runnable r = tryQueue(runnable);
    protected final GroupShardsIterator<SearchShardIterator> shardsIts;
            // Log the message without an exception.
        }
        // so its ok concurrency wise to miss potentially the shard failures being created because of another failure
    protected final GroupShardsIterator<SearchShardIterator> toSkipShardsIts;
/*
import org.opensearch.common.lease.Releasable;
    final AtomicInteger totalOps = new AtomicInteger();
                    0,
        // onPhaseStart / onPhaseFailure / OnPhaseDone callbacks and the wrapping SearchPhase is being abandoned
    public void sendSearchResponse(InternalSearchResponse internalSearchResponse, AtomicArray<SearchPhaseResult> queryResults) {
        assert result.getShardIndex() != -1 : "shard index is not set";
     * Override this method to provide custom listener implementations (e.g., streaming listeners).
            // lazily create shard failures, so we can early build the empty shard failure list in most cases (no failures)
                            discrepancy,
        successfulOps.incrementAndGet();
                        );
        shardRequest.canReturnNullResponseIfMatchNoDocs(hasShardResponse.get() && shardRequest.scroll() == null);
        if (shardsIt.skip()) {
                            getNumShards(),
            public void onFailure(Exception e) {
        listener.onFailure(exception);
                    lastShard
 * specific language governing permissions and limitations
                    null
 */
            shardFailures.set(result.getShardIndex(), null);
    }
                // the failure is already present, try and not override it with an exception that is less meaningless
                    }
        // it's number of active shards but use 1 as the default if no replica of a shard is active at this point.
                assert failure == null : "shard failed before but shouldn't: " + failure;
     * Returns the next phase based on the results of the initial search phase
                }
                if (TransportActions.isReadOverrideException(e)) {
                : null;
                    resultsFrom,
                    executePhaseOnShard(shardIt, shard, listener);
        }
        if (shardFailures == null) {
        return task;
        }
        if (throttleConcurrentRequests) {
                    }
    ) {
    ) {
        return searchTransportService;
    }
         * continue on the same thread in the case that we never went async and this happens repeatedly we will end up recursing deeply and
                }
            } catch (final Exception ex) {
            final ShardOperationFailedException[] shardSearchFailures = ExceptionsHelper.groupBy(buildShardFailures());
                        shardSearchFailures = ExceptionsHelper.groupBy(shardSearchFailures);
/**
        searchRequestContext.recordPhaseResourceUsage(taskResourceUsage);
        successfulShardExecution(shardIt);
            this.searchRequestContext.getSearchRequestOperationsListener().onPhaseStart(this);
                final SearchShardIterator shardRoutings = shardsIts.get(index);
                r.run();
        void tryRun(Runnable runnable) {
        String scrollId,
        Logger logger,
    }
 * the Apache License, Version 2.0 (the "License"); you may
     * @param thread the current thread for fork logic
            if (permitsTaken < permits) {
                        );
    }
        ShardSearchFailure[] failures = new ShardSearchFailure[entries.size()];
            int trackTotalHitsUpTo = request.source() == null ? SearchContext.DEFAULT_TRACK_TOTAL_HITS_UP_TO
        for (final SearchShardIterator iterator : toSkipShardsIts) {
import java.util.concurrent.TimeUnit;
        String searchContextId
        final SearchPhase phase,
        String name,
                        if (missingShards.length() > 0) {
            onRequestEnd(searchRequestContext);
        }
        return searchRequestContext;
        }
    @Override
        setPhaseResourceUsages();
            if (results.hasResult(shardIndex)) {
 * @opensearch.internal
    private final SearchRequest request;
                phaseSpan.endSpan();
                : OpenSearchException.guessRootCauses(shardSearchFailures[0].getCause())[0];
    public final void execute(Runnable command) {
        // are fast we could concurrently update totalOps but then preempt one of the threads which can
        ShardSearchFailure[] failures = buildShardFailures();
                        }
                    toExecute = queue.poll();
        this.tracer = tracer;
            } catch (final Exception ex) {
        Releasables.close(releasables);
            ((PipelinedRequest) request).transformSearchPhaseResults(results, this, this.getName(), nextPhase.getName());
        // can return a null response if the request rewrites to match none rather
 * The fan out and collect algorithm is traditionally used as the initial phase which can either be a query execution or collection of
            }
        float indexBoost = concreteIndexBoosts.getOrDefault(shardIt.shardId().getIndex().getUUID(), DEFAULT_INDEX_BOOST);
     * @param shardIt the shards iterator
            };
     * Sends the request to the actual shard.
    @Override
        return failures;
        final int shardIndex,
                            } else {
            remainingOpsOnIterator = shardsIt.remaining() + 1;
    }
 * referred to as the {@code shardIndex}.
                }
 * GitHub history for details.
        final SearchShardIterator shardIt,
    /**
                    request,
    public final void onShardFailure(final int shardIndex, @Nullable SearchShardTarget shardTarget, Exception e) {
    private final int maxConcurrentRequestsPerNode;
    public final Transport.Connection getConnection(String clusterAlias, String nodeId) {
                if (shardSearchFailures.length > 0) {
                }
    public final Logger getLogger() {
        SearchRequest request,
     * Executed once for every failed shard level request. This method is invoked before the next replica is tried for the given
                try {
                    "[{}] Moving to next phase: [{}], based on results from: {} (cluster state version: {})",
        // we do make sure to clean it on a successful response from a shard
        SearchTransportService searchTransportService,
                try {
                    // It only happens when onPhaseDone() is called and executePhaseOnShard() fails hard with an exception.
    }
        results.consumeShardFailure(shardIndex);
            logger.debug(
                    buildTookInMillis(),
 * compatible open source license.
 *
                        executeNext(pendingExecutions, thread);
        // we need to increment successful ops first before we compare the exit condition otherwise if we
                            // here is to fail the phase and move on to the next one.
                    shard != null ? shard : shardIt.shardId(),
    }
        this.searchTransportService = searchTransportService;
import org.opensearch.search.SearchShardTarget;
        return new SearchActionListener<Result>(shard, shardIndex) {
            );
            if (buildPointInTimeFromSearchResults()) {
         * at least one successful operation left and if so we move to the next phase. If not we immediately fail the
            searchContextId
        SearchShardIterator shardIt,
        if (lastShard) {
            final PendingExecutions pendingExecutions = throttleConcurrentRequests
    }
        }
        executeNextPhase(this, nextPhase);
            request,
import java.util.concurrent.ConcurrentHashMap;
    private final AtomicInteger skippedOps = new AtomicInteger();
/*
    protected final SearchPhaseResults<Result> results;
     * shard target.
                        onPhaseFailure(phase, "The phase has failed", t);
            onPhaseFailure(phase, "", e);
     * @param shardTarget the shard target for this failure
                        missingShards.append(shardRoutings.shardId());
import org.opensearch.telemetry.tracing.SpanCreationContext;
        private synchronized Runnable tryQueue(Runnable runnable) {
        }
        // Note that, we have to disable this shortcut for queries that create a context (scroll and search context).
        // we process hence we add one for the non active partition here.
            listener.onResponse(buildSearchResponse(internalSearchResponse, failures, scrollId, searchContextId));
import java.util.Set;
            }
                // successful retries can reset the failures to null
            } else {
        final int totalOps = this.totalOps.incrementAndGet();
        // clean a previous error on this shard group (note, this code will be serialized on the same shardIndex value level
    }
        } catch (Exception e) {
import org.opensearch.common.lease.Releasables;
                    clusterState.version()
                }
    final int expectedTotalOps;
    }
            onShardGroupFailure(shardIndex, shard, e);
    @Override
                        inner.addSuppressed(exception);
                    if (totalOps.get() == expectedTotalOps) {
                logger.debug(new ParameterizedMessage("Failed to execute [{}] while moving to [{}] phase", request, phase.getName()), e);
            }
                    onShardResult(result, shardIt);
     * Extension point to create the appropriate action listener for shard execution.
                }
                    InternalSearchResponse.empty(withTotalHits),
        this.listener = ActionListener.runAfter(listener, this::releaseContext);
import org.opensearch.Version;
                )
                    } else {
        try (final SpanScope scope = tracer.withSpanInScope(phaseSpan)) {
                results.getSuccessfulResults()
                            cause
            } else if (runnable != null) {
        for (int i = 0; i < failures.length; i++) {
            } else {
     *
        if (totalOps == expectedTotalOps) {
    /**
                } finally {
                        Transport.Connection connection = getConnection(searchShardTarget.getClusterAlias(), searchShardTarget.getNodeId());
            synchronized (this) {
    }
        return nodeIdToConnection.apply(clusterAlias, nodeId);
    }
     * @param shardIt the shard iterator
        this.logger = logger;
 * software distributed under the License is distributed on an
            onPhaseFailure(currentPhase, "all shards failed", cause);
            }
                    }
