import org.opensearch.cluster.ClusterState;
                    onPhaseDone();
                    executeNext(pendingExecutions, thread);
            protected void innerOnCompleteResponse(SearchPhaseResult result) {
                    getLogger().debug("Stream results consumption has called back, let shard consumption callback trigger onPhaseDone");  
import java.util.function.BiFunction;
     * Override the extension point to create streaming listeners instead of regular listeners
        assert result.getSearchShardTarget() != null : "search shard target must not be null";  
        Executor executor,
    private final AtomicBoolean shardResultsConsumed = new AtomicBoolean(false);
            searchRequestContext,
import java.util.concurrent.atomic.AtomicInteger;  
        );  
                    getLogger().debug("Stream consumption trigger onPhaseDone");  
            }  
                shardResultsConsumed.set(true);
 * SPDX-License-Identifier: Apache-2.0
            }
                } finally {  
import org.opensearch.search.SearchShardTarget;  
            searchTransportService,
 */
        }  
                    onShardResult(result, shardIt);  
                    getSearchRequestContext().setStreamingRequest(true);
        final SearchPhase phase,
            public void onFailure(Exception t) {
        SearchRequest request,
        super(
                    // It only happens when onPhaseDone() is called and executePhaseOnShard() fails hard with an exception.  
                    );  
import org.opensearch.transport.Transport;  
            logger,  
        assert result.getShardIndex() != -1 : "shard index is not set";
import org.opensearch.core.action.ActionListener;
import org.opensearch.search.SearchPhaseResult;
                    getLogger().debug(
            if (streamResultsReceived.get() == streamResultsConsumeCallback.incrementAndGet()) {  
        final int xTotalOps = totalOps.addAndGet(remainingOpsOnIterator);
        final Thread thread
     * Handle successful stream execution callback
                    assert streamResultsReceived.get() > streamResultsConsumeCallback.get();  
 */  
            indexRoutings,
import java.util.Map;
    }  
        QueryPhaseResultConsumer resultConsumer,  
                try {
    @Override
import org.opensearch.search.internal.AliasFilter;
            }
        Logger logger,
            concreteIndexBoosts,
 * Stream search async action for query then fetch mode
                    executeNext(pendingExecutions, thread);
                }  
            @Override  
        return new StreamSearchActionListener<SearchPhaseResult>(shard, shardIndex) {  
 * compatible open source license.
        this.setPhaseResourceUsages();
                try {
            resultConsumer,
        }
        try {
        ActionListener<SearchResponse> listener,
        SearchRequestContext searchRequestContext,
            remainingOpsOnIterator = shardsIt.remaining();  
                    }
    }
        SearchTask task,  
        } else {
            try {  
            @Override
    /**
import org.apache.logging.log4j.Logger;
                if (streamResultsReceived.get() == streamResultsConsumeCallback.get()) {
                    } else {  
            timeProvider,  
                onPhaseFailure(this, "The phase has failed", ex);  
        final SearchShardTarget shard,
    /**
        }  
                try {
    }
/**  
        if (getLogger().isTraceEnabled()) {
import java.util.concurrent.Executor;
public class StreamSearchQueryThenFetchAsyncAction extends SearchQueryThenFetchAsyncAction {  
        Map<String, Set<String>> indexRoutings,  
        Tracer tracer  
                    onStreamResult(result, shardIt, () -> successfulStreamExecution());  
                    streamResultsReceived.incrementAndGet();
import org.opensearch.cluster.routing.GroupShardsIterator;  
    ) {
        GroupShardsIterator<SearchShardIterator> shardsIts,  
            throw new AssertionError(  
                        "Shard results consumption finishes before stream results, let stream consumption callback trigger onPhaseDone"
            executor,
                    if (totalOps.get() == expectedTotalOps) {
    void successfulShardExecution(SearchShardIterator shardsIt) {  
                }
            task,
        SearchPhaseController searchPhaseController,
            protected void innerOnStreamResponse(SearchPhaseResult result) {  
            listener,
        SearchTransportService searchTransportService,
            }  
                } else {
            shardsIts,
        final PendingExecutions pendingExecutions,  
                    if (streamResultsReceived.get() > 0) {  
                        onPhaseFailure(phase, "The phase has failed", t);
        };
    }
            request,  
}
                "unexpected higher total ops [" + xTotalOps + "] compared to expected [" + expectedTotalOps + "]",
    ) {
            getLogger().trace("got streaming result from {}", result != null ? result.getSearchShardTarget() : null);
/*  
                } finally {
     * Override successful shard execution to handle stream result synchronization  
            searchPhaseController,  
 * The OpenSearch Contributors require contributions made to  
            clusters,  
        final int shardIndex,  
     * Handle streaming results from shards
                if (shardResultsConsumed.get()) {
import java.util.Set;  
    private final AtomicInteger streamResultsConsumeCallback = new AtomicInteger(0);  
        } else if (xTotalOps > expectedTotalOps) {
        } catch (final Exception ex) {
     */  
     */
 *
    }
     */  
 * this file be licensed under the Apache-2.0 license or a
        Map<String, Float> concreteIndexBoosts,
            } catch (final Exception ex) {
        BiFunction<String, String, Transport.Connection> nodeIdToConnection,  
        TransportSearchAction.SearchTimeProvider timeProvider,
            );  
            nodeIdToConnection,
                } finally {
package org.opensearch.action.search;
            aliasFilter,  
import java.util.concurrent.atomic.AtomicBoolean;
                    executeNext(pendingExecutions, thread);
                }  
    SearchActionListener<SearchPhaseResult> createShardActionListener(
    private final AtomicInteger streamResultsReceived = new AtomicInteger(0);
        SearchResponse.Clusters clusters,
                }
            @Override  
     */
    @Override  
        if (xTotalOps == expectedTotalOps) {
    private void successfulStreamExecution() {
        ClusterState clusterState,
        ((StreamQueryPhaseResultConsumer) results).consumeStreamResult(result, next);
        }  
                }
            remainingOpsOnIterator = shardsIt.remaining() + 1;
            tracer
    /**
    StreamSearchQueryThenFetchAsyncAction(  
        final int remainingOpsOnIterator;
    /**  
                new SearchPhaseExecutionException(getName(), "Shard failures", null, buildShardFailures())
                    }
            clusterState,
                        onShardFailure(shardIndex, shard, shardIt, t);
    protected void onStreamResult(SearchPhaseResult result, SearchShardIterator shardIt, Runnable next) {
        final SearchShardIterator shardIt,
                    onPhaseDone();
                        getSearchRequestContext().setStreamingRequest(true);
import org.opensearch.telemetry.tracing.Tracer;
            onPhaseFailure(this, "The phase has failed", ex);
        Map<String, AliasFilter> aliasFilter,
            }
        if (shardsIt.skip()) {
