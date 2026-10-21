            task,
        Executor executor,
                    streamResultsReceived.incrementAndGet();
        SearchTransportService searchTransportService,
 * SPDX-License-Identifier: Apache-2.0
            try {
     * Handle successful stream execution callback
        final SearchPhase phase,
        return new StreamSearchActionListener<SearchPhaseResult>(shard, shardIndex) {
                    getLogger().debug(
            searchTransportService,
                    );
 * compatible open source license.
        BiFunction<String, String, Transport.Connection> nodeIdToConnection,
                    } else {
        final SearchShardTarget shard,
            onPhaseFailure(this, "The phase has failed", ex);
 */
     * Handle streaming results from shards
                }
        super(
    private final AtomicInteger streamResultsReceived = new AtomicInteger(0);
    private void successfulStreamExecution() {
                if (shardResultsConsumed.get()) {
            executor,
            nodeIdToConnection,
        Map<String, AliasFilter> aliasFilter,
                    getLogger().debug("Stream consumption trigger onPhaseDone");
        SearchTask task,
        }
                }
        final int xTotalOps = totalOps.addAndGet(remainingOpsOnIterator);
                    if (streamResultsReceived.get() > 0) {
 */
            request,
public class StreamSearchQueryThenFetchAsyncAction extends SearchQueryThenFetchAsyncAction {
        }
                onPhaseFailure(this, "The phase has failed", ex);
                        onShardFailure(shardIndex, shard, shardIt, t);
 * this file be licensed under the Apache-2.0 license or a
                    getSearchRequestContext().setStreamingRequest(true);
            if (streamResultsReceived.get() == streamResultsConsumeCallback.incrementAndGet()) {
                        getSearchRequestContext().setStreamingRequest(true);
                }
import org.opensearch.cluster.ClusterState;
        }
                new SearchPhaseExecutionException(getName(), "Shard failures", null, buildShardFailures())
 * Stream search async action for query then fetch mode
import org.opensearch.search.SearchShardTarget;
                        onPhaseFailure(phase, "The phase has failed", t);
import java.util.concurrent.atomic.AtomicInteger;
            indexRoutings,
        Logger logger,
    protected void onStreamResult(SearchPhaseResult result, SearchShardIterator shardIt, Runnable next) {
                    onStreamResult(result, shardIt, () -> successfulStreamExecution());
                try {
import org.opensearch.cluster.routing.GroupShardsIterator;
 *
        try {
    /**
        SearchPhaseController searchPhaseController,
        TransportSearchAction.SearchTimeProvider timeProvider,
                    // It only happens when onPhaseDone() is called and executePhaseOnShard() fails hard with an exception.
    }
            searchRequestContext,
            timeProvider,
import java.util.concurrent.Executor;
            protected void innerOnStreamResponse(SearchPhaseResult result) {
    /**
        SearchRequestContext searchRequestContext,
            throw new AssertionError(
        } else if (xTotalOps > expectedTotalOps) {
            searchPhaseController,
            aliasFilter,
            logger,
/**
import org.opensearch.transport.Transport;
    }
        SearchResponse.Clusters clusters,
                } else {
            clusters,
        );
/*
            protected void innerOnCompleteResponse(SearchPhaseResult result) {
            remainingOpsOnIterator = shardsIt.remaining() + 1;
     * Override the extension point to create streaming listeners instead of regular listeners
                    assert streamResultsReceived.get() > streamResultsConsumeCallback.get();
    private final AtomicInteger streamResultsConsumeCallback = new AtomicInteger(0);
        final PendingExecutions pendingExecutions,
import org.apache.logging.log4j.Logger;
            }
import java.util.concurrent.atomic.AtomicBoolean;
                try {
import org.opensearch.core.action.ActionListener;
import org.opensearch.telemetry.tracing.Tracer;
    /**
                }
            @Override
                } finally {
                    getLogger().debug("Stream results consumption has called back, let shard consumption callback trigger onPhaseDone");
                    }
            tracer
import java.util.Set;
                    executeNext(pendingExecutions, thread);
import java.util.function.BiFunction;
                    onPhaseDone();
        GroupShardsIterator<SearchShardIterator> shardsIts,
        final SearchShardIterator shardIt,
            concreteIndexBoosts,
                    executeNext(pendingExecutions, thread);
        ((StreamQueryPhaseResultConsumer) results).consumeStreamResult(result, next);
package org.opensearch.action.search;
                    if (totalOps.get() == expectedTotalOps) {
import java.util.Map;
        };
    ) {
            public void onFailure(Exception t) {
            } catch (final Exception ex) {
        SearchRequest request,
            getLogger().trace("got streaming result from {}", result != null ? result.getSearchShardTarget() : null);
        QueryPhaseResultConsumer resultConsumer,
    }
    /**
     */
 * The OpenSearch Contributors require contributions made to
import org.opensearch.search.SearchPhaseResult;
                    onShardResult(result, shardIt);
                try {
     */
                shardResultsConsumed.set(true);
    void successfulShardExecution(SearchShardIterator shardsIt) {
                } finally {
            resultConsumer,
        if (getLogger().isTraceEnabled()) {
        Tracer tracer
            }
    }
            shardsIts,
    }
        if (xTotalOps == expectedTotalOps) {
        Map<String, Set<String>> indexRoutings,
     */
                }
            @Override
        ClusterState clusterState,
        } else {
            remainingOpsOnIterator = shardsIt.remaining();
                "unexpected higher total ops [" + xTotalOps + "] compared to expected [" + expectedTotalOps + "]",
     */
    @Override
            clusterState,
            listener,
    SearchActionListener<SearchPhaseResult> createShardActionListener(
                    onPhaseDone();
        assert result.getShardIndex() != -1 : "shard index is not set";
            }
                    }
}
                        "Shard results consumption finishes before stream results, let stream consumption callback trigger onPhaseDone"
            );
    StreamSearchQueryThenFetchAsyncAction(
            }
        } catch (final Exception ex) {
                } finally {
        final int shardIndex,
    ) {
            @Override
        assert result.getSearchShardTarget() != null : "search shard target must not be null";
        ActionListener<SearchResponse> listener,
import org.opensearch.search.internal.AliasFilter;
            }
        }
        final Thread thread
     * Override successful shard execution to handle stream result synchronization
                    executeNext(pendingExecutions, thread);
    private final AtomicBoolean shardResultsConsumed = new AtomicBoolean(false);
        final int remainingOpsOnIterator;
        if (shardsIt.skip()) {
        this.setPhaseResourceUsages();
        Map<String, Float> concreteIndexBoosts,
                if (streamResultsReceived.get() == streamResultsConsumeCallback.get()) {
    @Override
