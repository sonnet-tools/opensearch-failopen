                protected void doRun() {
}
     * Immutable container holding the outcome of a partial reduce operation
import org.opensearch.search.query.QuerySearchResult;
                topDocsList.add(reduceResult.reducedTopDocs);
            return circuitBreakerBytes;
                return Collections.emptyList();
            }
        SearchPhaseController.ReducedQueryPhase reducePhase = controller.reducedQueryPhase(
        }
                QuerySearchResult[] clone = buffer.toArray(QuerySearchResult[]::new);
     * @opensearch.internal
            newTopDocs = null;
        SearchPhaseController controller,
        final InternalAggregations newAggs;
            if (hasAggs == false) {
            return topDocsList;
        }
            topDocsList,
 * in the {@link CircuitBreaker#REQUEST} circuit breaker. Before any partial or final reduce, the memory
            pendingReduces.numReducePhases,
        }
            for (ReduceTask toCancel : toCancels) {
        this.hasTopDocs = source == null || source.size() != 0;
                        // Update the circuit breaker to remove the size of the source aggregations
        return pendingReduces.numReducePhases;
                return;
            newAggs = null;
        this.progressListener = progressListener;
                        // and replace the estimation with the serialized size of the newly reduced result.
            }
 * Unless required by applicable law or agreed to in writing,
        checkCancellation();
                callback.run();
    /**
                aggsList.add(lastReduceResult.reducedAggs);
    int getBatchReduceSize(int requestBatchedReduceSize, int minBatchReduceSize) {
        if (isTaskCancelled.getAsBoolean()) {
        if (hasAggs && reducePhase.aggregations != null) {
 * exceeds the maximum memory allowed in this breaker.
            );
        private synchronized List<InternalAggregations> consumeAggs() {
        NamedWriteableRegistry namedWriteableRegistry,
        final List<TopDocs> topDocsList = pendingReduces.consumeTopDocs();
                SearchShardTarget target = result.getSearchShardTarget();
        private QuerySearchResult[] buffer;
import org.opensearch.common.lease.Releasables;
            return topDocsStats;
                    }
     * <li>Provides thread-safe failure handling with cleanup</li>
 * Modifications Copyright OpenSearch Contributors. See
         * Returns the size of the serialized aggregation that is contained in the
            pendingReduces.onFailure(new TaskCancelledException("request has been terminated"));
            reduceResult = null;
        private final List<SearchShard> emptyResults = new ArrayList<>();
                return;
            consumeListener();
        this.executor = executor;
            this.emptyResults = emptyResults;
            final ReduceTask task;
        NamedWriteableRegistry namedWriteableRegistry,
import java.util.Arrays;
        Arrays.sort(toConsume, Comparator.comparingInt(QuerySearchResult::getShardIndex));
    }
        final TopDocs newTopDocs;
            if (newResult != null) {
import org.opensearch.common.util.concurrent.AbstractRunnable;
            List<InternalAggregations> aggsList = new ArrayList<>();
        return (hasAggs || hasTopDocs) ? Math.min(requestBatchedReduceSize, minBatchReduceSize) : minBatchReduceSize;
import java.util.List;
        } else {
 * GitHub history for details.
 * This implementation adds the memory that it used to save and reduce the results of shard aggregations
            );
                        final QuerySearchResult[] toConsume = task.consumeBuffer();
        }
            List<TopDocs> topDocsList = new ArrayList<>();
        private volatile long maxAggsCurrentBufferSize = 0;
                try {
     * <li>Coordinates reduce task execution to be one at a time</li>
                    if (hasFailure()) {
        public synchronized void cancel() {
     */
     */
        SearchPhaseController.TopDocsStats topDocsStats,
     * <li>Handles circuit breaker memory accounting</li>
        super(expectedResultSize);
        SearchProgressListener progressListener,
        }
import java.util.ArrayDeque;
    @Override
        }
            aggsList,
                return false; // callback will be run by reduce task
import org.opensearch.common.lease.Releasable;
package org.opensearch.action.search;
    private final BooleanSupplier isTaskCancelled;
            }
        pendingReduces.consume(querySearchResult, next);
        this.isTaskCancelled = isTaskCancelled;
    }
    }
                        return;
                }
            newAggs = InternalAggregations.topLevelReduce(aggsList, aggReduceContextBuilder.forPartialReduction());
                    onFailure(e);
        }
                }
        int expectedResultSize,
    ) {
            }
     * ReduceTask is created to reduce buffered query results when buffer size hits threshold
            queue.clear();
        private void sortBuffer() {
            performFinalReduce
            }
                TopDocsAndMaxScore topDocs = result.consumeTopDocs();
            return aggsList;
        }
            circuitBreakerBytes = 0;
        int expectedResultSize,
                        if (toConsume == null) {
        private final ArrayDeque<ReduceTask> queue = new ArrayDeque<>();
        }
            topDocsStats,
                    runningTask.compareAndSet(task, null);
        this(
 * A {@link ArraySearchPhaseResults} implementation that incrementally reduces aggregation results
import org.opensearch.core.tasks.TaskCancelledException;
                    aggsCurrentBufferSize += aggsSize;
import org.apache.logging.log4j.Logger;
                return circuitBreakerBytes;
            if (hasFailure()) {
        PendingReduces(int batchReduceSize, int trackTotalHitsUpTo) {
        SearchRequest request,
        this.topNSize = SearchPhaseController.getTopDocsSize(request);
        }
        progressListener.notifyQueryResult(querySearchResult.getShardIndex());
            return failure.get() != null;
        private final int batchReduceSize;
            }
        private long ramBytesUsedQueryResult(QuerySearchResult result) {
        if (pendingReduces.hasFailure()) {
    }
            this.buffer = buffer;
import org.opensearch.search.SearchShardTarget;
        private synchronized List<TopDocs> consumeTopDocs() {
    public void close() {
import org.opensearch.search.builder.SearchSourceBuilder;
 * specific language governing permissions and limitations
            assert circuitBreakerBytes >= 0;
 *
    private void checkCancellation() {
 *
            controller,
        if (hasTopDocs) {
            results.asList(),
    private final NamedWriteableRegistry namedWriteableRegistry;
                            "aggs partial reduction [{}->{}] max [{}]",
            maxAggsCurrentBufferSize = Math.max(maxAggsCurrentBufferSize, circuitBreakerBytes);
    @Override
            processedShards.addAll(lastReduceResult.processedShards);
            // Check circuit breaker before consuming
                            reduceResult.estimatedSize,
            logger.trace(
     */
        private final List<SearchShard> emptyResults;
        if (pendingReduces.hasFailure()) {
        }
                runningTask.compareAndSet(null, task);
                topDocsList.add(topDocs.topDocs);
                Collections.sort(buffer, Comparator.comparingInt(QuerySearchResult::getShardIndex));
        final List<InternalAggregations> aggsList = pendingReduces.consumeAggs();
        private final long aggsBufferSize;
     * @opensearch.internal
    /**
            List<ReduceTask> toCancels = new ArrayList<>();
    /**
            for (QuerySearchResult result : toConsume) {
        for (QuerySearchResult result : toConsume) {
                return circuitBreakerBytes;
        }
                topDocsList,
                SearchPhaseController.setShardIndex(topDocs.topDocs, result.getShardIndex());
                        );
        }
            if (reduceResult != null) {
         * Returns an estimation of the size that a reduce of the provided size
            request,
                pendingReduces.maxAggsCurrentBufferSize
        private volatile boolean hasPartialReduce;
        private final SearchPhaseController.TopDocsStats topDocsStats;
                if (queue.isEmpty() || runningTask.get() != null) {
 * license agreements. See the NOTICE file distributed with
        private volatile int numReducePhases;
        }
                synchronized (this) {
            runningTask.compareAndSet(task, null);
            if (hasAggs == false) {
                TopDocsAndMaxScore topDocs = result.consumeTopDocs();
            reducePhase.totalHits,
    public QueryPhaseResultConsumer(
                            estimatedSize,
        }
        // the memory that is currently used in the buffer
        this.pendingReduces = new PendingReduces(batchReduceSize, request.resolveTrackTotalHitsUpTo());
            // Process non-empty results
    private record ReduceResult(List<SearchShard> processedShards, TopDocs reducedTopDocs, InternalAggregations reducedAggs,
                    long estimatedTotalSize = (thisReduceResult != null ? thisReduceResult.estimatedSize : 0) + task.aggsBufferSize;
        List<SearchShard> emptyResults,
                topDocsList.add(topDocs.topDocs);
        SearchProgressListener progressListener,
         * would take on memory.
                "aggs final reduction [{}] max [{}]",
import java.util.Collections;
            return circuitBreakerBytes;
        // ensure consistent ordering
                    try {
        progressListener.notifyFinalReduce(
import org.opensearch.search.SearchPhaseResult;
            if (lastReduceResult != null) {
                // the callback must wait for the new reduce task to complete to maintain proper result processing order
                tryExecuteNext();
            namedWriteableRegistry,
import org.opensearch.core.common.breaker.CircuitBreaker;
                public void onFailure(Exception exc) {
            }
    private ReduceResult partialReduce(
        final SearchPhaseController.TopDocsStats topDocsStats = pendingReduces.consumeTopDocsStats();
                        estimatedTotalSize += estimateRamBytesUsedForReduce;
            buffer.add(result);
                            maxAggsCurrentBufferSize
                0
            if (hasFailure()) {
                assert circuitBreakerBytes == 0;
            toCancels.addAll(queue);
                aggsList.add(result.consumeAggs().expand());
     * Manages incremental query result reduction by buffering incoming results and
                    return;
                ReduceTask task = new ReduceTask(clone, aggsCurrentBufferSize, new ArrayList<>(emptyResults), callback);
        if (hasAggs) {
            return true;
            if (circuitBreakerBytes > 0) {
        }
                hasPartialReduce = true;
 * SPDX-License-Identifier: Apache-2.0
        @Override
            cancelTaskOnFailure,
            circuitBreaker.addEstimateBytesAndMaybeBreak(estimatedSize, "<reduce_aggs>");
        // Idempotent and thread-safe failure handling
        }
        for (QuerySearchResult result : toConsume) {
import org.apache.lucene.search.TopDocs;
                    if (hasAggs) {
/**
        }
    private final SearchPhaseController controller;
        }
 *
            throw new AssertionError("partial reduce in-flight");
                aggsList.add(reduceResult.reducedAggs);
                emptyResults.clear();
                topNSize,
            for (QuerySearchResult result : buffer) {
        private void tryExecuteNext() {
        SearchRequest request,
        private final AtomicReference<ReduceTask> runningTask = new AtomicReference<>(); // ensure only one task is running
            }
                result.consumeAll(); // release memory
            maxAggsCurrentBufferSize = Math.max(maxAggsCurrentBufferSize, circuitBreakerBytes);
            executor.execute(new AbstractRunnable() {
                topDocsStats.add(result.topDocs(), result.searchTimedOut(), result.terminatedEarly());
        this.aggReduceContextBuilder = controller.getReduceContext(request);
                }
        );
                queue.add(task);
        long estimatedSize) {
        int numReducePhases
        Executor executor,
                buffer.clear();
                long aggsSize = ramBytesUsedQueryResult(result);
                        addEstimateAndMaybeBreak(estimateRamBytesUsedForReduce);
        this.hasAggs = source != null && source.aggregations() != null;
 * @opensearch.internal
         */
                    }
            }
import java.util.concurrent.Executor;
     * @opensearch.internal
    public SearchPhaseController.ReducedQueryPhase reduce() throws Exception {
        private boolean hasFailure() {
     * triggering partial reduce operations when the threshold is reached.
        private final List<QuerySearchResult> buffer = new ArrayList<>();
            }
        }
        }
 * this work for additional information regarding copyright
            SearchProgressListener.buildSearchShards(results.asList()),
            if (next != null) {
        checkCancellation();
        private long estimateRamBytesUsedForReduce(long size) {
        this.namedWriteableRegistry = namedWriteableRegistry;
                    addEstimateAndMaybeBreak(aggsSize);
            circuitBreakerBytes += size;
                return 0;
            return queue.isEmpty() == false || runningTask.get() != null;
import java.util.function.Consumer;
            if (result.isNull()) {
                return true;
                        PendingReduces.this.onFailure(t);
    }
        /**
        super.consumeResult(result, () -> {});
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            circuitBreakerBytes += estimatedSize;
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
            }
                    return true;
import org.opensearch.search.aggregations.InternalAggregations;
    private final boolean hasAggs;
        void consume(QuerySearchResult result, Runnable callback) {
                pendingReduces.aggsCurrentBufferSize,
         * aggregations that need to be reduced. This estimation can be completely
    }
        private synchronized void resetCircuitBreaker() {
        // ensure consistent ordering
                toCancel.cancel();
        }
            if (hasTopDocs == false) {
    private final Executor executor;
                        ++numReducePhases;
            assert circuitBreakerBytes >= 0;
                circuitBreaker.addWithoutBreaking(-circuitBreakerBytes);
 * under the License.
import java.util.Comparator;
                @Override
            this.topDocsStats = new SearchPhaseController.TopDocsStats(trackTotalHitsUpTo);
        private void onAfterReduce(ReduceTask task, ReduceResult newResult, long estimatedSize) {
     * </ul>
     * <ul>
    private final ReduceContextBuilder aggReduceContextBuilder;
                        return;
    ) {
            this.batchReduceSize = batchReduceSize;
    }
            }
            // Add an estimate of the final reduce size
        pendingReduces.sortBuffer();
        private volatile long aggsCurrentBufferSize;
                        long newSize = reduceResult.estimatedSize - estimatedSize;
 * the Apache License, Version 2.0 (the "License"); you may
        }
                        addWithoutBreaking(newSize);
        if (lastReduceResult != null) {
    private static final Logger logger = LogManager.getLogger(QueryPhaseResultConsumer.class);
        ReduceResult lastReduceResult,
            }
 * needed to reduce the aggregations is estimated and a {@link CircuitBreakingException} is handled if it
            }
/*
    }
 */
            }
                task = queue.poll();
    public QueryPhaseResultConsumer(
                    return;
                    }
            aggReduceContextBuilder,
        private Runnable next;
        private synchronized long addEstimateAndMaybeBreak(long estimatedSize) {
                buffer.add(result);
                }
    private final CircuitBreaker circuitBreaker;
/*
                SearchPhaseController.setShardIndex(topDocs.topDocs, result.getShardIndex());
    public int getNumReducePhases() {
                            return;
        }
        // we leave the results un-serialized because serializing is slow but we compute the serialized
                    final ReduceResult newReduceResult;
                }
            circuitBreaker.addWithoutBreaking(-circuitBreakerBytes);
            this.next = next;
            if (consumeResult(result, callback)) {
            buffer = null;
            throw pendingReduces.failure.get();
        }
 * as shard results are consumed.
                        }
 *
            for (QuerySearchResult result : toConsume) {
        if (pendingReduces.hasPendingReduceTask()) {
                toCancels.add(task);
 * You may obtain a copy of the License at
            if (hasFailure()) {
            }
                    reduceResult = newResult;
 */
        private volatile ReduceResult reduceResult;
        int batchReduceSize = getBatchReduceSize(request.getBatchedReduceSize(), expectedResultSize);
            circuitBreaker.addWithoutBreaking(size);
            }
            SearchShardTarget target = result.getSearchShardTarget();
        public synchronized void close() {
    private static class ReduceTask {
            expectedResultSize,
public class QueryPhaseResultConsumer extends ArraySearchPhaseResults<SearchPhaseResult> implements Releasable {
         */
import org.opensearch.core.common.breaker.CircuitBreakingException;
    private final boolean hasTopDocs;
    /**
        this.circuitBreaker = circuitBreaker;
    }
            task.consumeListener();
                next = null;
            if (lastReduceResult != null) {
    }
                return true;
        this.controller = controller;
         * the reduce completes.
        private ReduceTask(QuerySearchResult[] buffer, long aggsBufferSize, List<SearchShard> emptyResults, Runnable next) {
                @Override
            }
                next.run();
            if (hasAggs) {
        // the memory that is accounted in the circuit breaker for this consumer
 * KIND, either express or implied.  See the License for the
 */
import java.util.ArrayList;
    private final SearchProgressListener progressListener;
            return toRet;
        }
            QuerySearchResult[] toRet = buffer;
            false,
     * as shard results are consumed.
            pendingReduces.addWithoutBreaking(finalSize);
            if (task != null) {
            return result.aggregations().asSerialized(InternalAggregations::readFrom, namedWriteableRegistry).ramBytesUsed();
     */
                    final ReduceResult thisReduceResult = reduceResult;
            List<InternalAggregations> aggsList = new ArrayList<>();
 * Licensed to Elasticsearch under one or more contributor
            this.aggsBufferSize = aggsBufferSize;
 * The OpenSearch Contributors require contributions made to
                } catch (CircuitBreakingException e) {
        }
            // Update the circuit breaker to replace the estimation with the serialized size of the newly reduced result
import java.util.function.BooleanSupplier;
                // we have to merge here in the same way we collect on a shard
            if (hasFailure()) {
        QuerySearchResult[] toConsume,
        CircuitBreaker circuitBreaker,
/*
            reducePhase.aggregations,
    private final boolean performFinalReduce;
        long serializedSize = hasAggs ? newAggs.getSerializedSize() : 0;
        }
            return Math.round(0.5d * size);
            topDocsStats.add(result.topDocs(), result.searchTimedOut(), result.terminatedEarly());
            }
            }
    }
     * Creates a {@link QueryPhaseResultConsumer} that incrementally reduces aggregation results
 *     http://www.apache.org/licenses/LICENSE-2.0
 * compatible open source license.
            if (reduceResult != null) {
            progressListener,
        if (hasAggs) {
            clearReduceTaskQueue();
    private final int topNSize;
        }
        SearchSourceBuilder source = request.source();
            for (QuerySearchResult result : buffer) {
         * off for some aggregations but it is corrected with the real size after
            failure.compareAndSet(null, exc);
                            onAfterReduce(task, null, 0);
        private synchronized SearchPhaseController.TopDocsStats consumeTopDocsStats() {
                        newReduceResult = partialReduce(toConsume, task.emptyResults, topDocsStats, thisReduceResult, numReducePhases);
                return Collections.emptyList();
        this.performFinalReduce = request.isFinalReduce();
        public void consumeListener() {
        /**
        return new ReduceResult(processedShards, newTopDocs, newAggs, hasAggs ? serializedSize : 0);
            if (size >= batchReduceSize) {
            }
                    PendingReduces.this.onFailure(exc);
            }
    private final Consumer<Exception> cancelTaskOnFailure;
        private synchronized boolean consumeResult(QuerySearchResult result, Runnable callback) {
        private volatile long circuitBreakerBytes;
import org.opensearch.search.aggregations.InternalAggregation.ReduceContextBuilder;
            reducePhase.numReducePhases
            checkCancellation();
            consumeBuffer();
            () -> false
        long breakerSize = pendingReduces.circuitBreakerBytes;
        );
    public void consumeResult(SearchPhaseResult result, Runnable next) {
        Releasables.close(pendingReduces);
        }
         * provided {@link QuerySearchResult}.
            cancelTaskOnFailure.accept(exc);
    @Override
        this.cancelTaskOnFailure = cancelTaskOnFailure;
 * ownership. Elasticsearch licenses this file to you under
        BooleanSupplier isTaskCancelled
        // size as an estimate of the memory used by the newly reduced aggregations.
                    } catch (Exception t) {
        }
 * this file be licensed under the Apache-2.0 license or a
        SearchPhaseController controller,
            resetCircuitBreaker();
     *
 * not use this file except in compliance with the License.
            int size = buffer.size() + (hasPartialReduce ? 1 : 0);
        private synchronized void onFailure(Exception exc) {
import org.apache.logging.log4j.LogManager;
        );
            newTopDocs = SearchPhaseController.mergeTopDocs(
        progressListener.notifyPartialReduce(processedShards, topDocsStats.getTotalHits(), newAggs, numReducePhases);
                }
        CircuitBreaker circuitBreaker,
            }
            breakerSize = pendingReduces.addEstimateAndMaybeBreak(pendingReduces.estimateRamBytesUsedForReduce(breakerSize));
    ) {
            }
         * This size is estimated as roughly 1.5 times the size of the serialized
            synchronized (this) {
        public synchronized QuerySearchResult[] consumeBuffer() {
            }
        Consumer<Exception> cancelTaskOnFailure,
    }
        List<SearchShard> processedShards = new ArrayList<>(emptyResults);
     *
            List<TopDocs> topDocsList = new ArrayList<>();
            circuitBreaker,
        }
            executor,
                    onAfterReduce(task, newReduceResult, estimatedTotalSize);
            }
     *
        private synchronized void clearReduceTaskQueue() {
                aggsList.add(result.consumeAggs().expand());
                        logger.trace(
                if (hasFailure()) {
        }
    class PendingReduces implements Releasable {
            });
            if (hasFailure()) {
import java.util.concurrent.atomic.AtomicReference;
            return lastReduceResult;
                emptyResults.add(new SearchShard(target.getClusterAlias(), target.getShardId()));
        Consumer<Exception> cancelTaskOnFailure
            for (QuerySearchResult result : buffer) {
        return reducePhase;
                        long estimateRamBytesUsedForReduce = estimateRamBytesUsedForReduce(estimatedTotalSize);
        Executor executor,
            }
            if (buffer.size() > 0) {
 * software distributed under the License is distributed on an
        QuerySearchResult querySearchResult = result.queryResult();
                circuitBreakerBytes = 0;
            processedShards.add(new SearchShard(target.getClusterAlias(), target.getShardId()));
                assert circuitBreakerBytes == 0;
            executor.execute(this::tryExecuteNext);
        private boolean hasPendingReduceTask() {
            long finalSize = reducePhase.aggregations.getSerializedSize() - breakerSize;
 */
                topDocsList.add(lastReduceResult.reducedTopDocs);
        }
        private synchronized long addWithoutBreaking(long size) {
            assert hasPendingReduceTask() == false : "cannot close with partial reduce in-flight";
            }
    final PendingReduces pendingReduces;
import org.opensearch.common.lucene.search.TopDocsAndMaxScore;
                aggsCurrentBufferSize = 0;
            ReduceTask task = runningTask.get();
        private final AtomicReference<Exception> failure = new AtomicReference<>();
        } else {
