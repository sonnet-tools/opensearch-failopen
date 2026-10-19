            this.batchReduceSize = batchReduceSize;
 */  
     *
     * <li>Coordinates reduce task execution to be one at a time</li>  
    private static class ReduceTask {
            }  
     */  
            cancelTaskOnFailure.accept(exc);  
        public synchronized void close() {
            newTopDocs = null;
            return failure.get() != null;
        SearchPhaseController controller,  
            return topDocsStats;
        private final long aggsBufferSize;
        PendingReduces(int batchReduceSize, int trackTotalHitsUpTo) {
 */
                return Collections.emptyList();
                    final ReduceResult thisReduceResult = reduceResult;
import org.opensearch.core.common.breaker.CircuitBreakingException;  
            circuitBreaker,  
        private synchronized void resetCircuitBreaker() {
        final TopDocs newTopDocs;
            false,  
            if (hasFailure()) {
 *
        }  
/*
         * aggregations that need to be reduced. This estimation can be completely
                task = queue.poll();
        final List<TopDocs> topDocsList = pendingReduces.consumeTopDocs();
    private final ReduceContextBuilder aggReduceContextBuilder;
     */
import java.util.concurrent.atomic.AtomicReference;
 * needed to reduce the aggregations is estimated and a {@link CircuitBreakingException} is handled if it
            }
        } else {  
            if (hasAggs == false) {
    public void close() {
 *     http://www.apache.org/licenses/LICENSE-2.0
        this.topNSize = SearchPhaseController.getTopDocsSize(request);
            processedShards.add(new SearchShard(target.getClusterAlias(), target.getShardId()));  
        if (hasAggs) {  
                TopDocsAndMaxScore topDocs = result.consumeTopDocs();
public class QueryPhaseResultConsumer extends ArraySearchPhaseResults<SearchPhaseResult> implements Releasable {
     * triggering partial reduce operations when the threshold is reached.  
        // size as an estimate of the memory used by the newly reduced aggregations.
/**  
            circuitBreaker.addEstimateBytesAndMaybeBreak(estimatedSize, "<reduce_aggs>");
        private volatile int numReducePhases;
                return 0;
    private final boolean hasTopDocs;  
 * Licensed to Elasticsearch under one or more contributor  
        List<SearchShard> processedShards = new ArrayList<>(emptyResults);  
                return true;  
        }
                emptyResults.clear();  
        progressListener.notifyFinalReduce(
            logger.trace(
    class PendingReduces implements Releasable {  
        this.controller = controller;
                return circuitBreakerBytes;
        SearchProgressListener progressListener,
 * You may obtain a copy of the License at  
 * Modifications Copyright OpenSearch Contributors. See
            if (size >= batchReduceSize) {
        }  
                }
    private record ReduceResult(List<SearchShard> processedShards, TopDocs reducedTopDocs, InternalAggregations reducedAggs,
                next.run();
     * as shard results are consumed.  
        Executor executor,
                long aggsSize = ramBytesUsedQueryResult(result);  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        this.hasAggs = source != null && source.aggregations() != null;
            final ReduceTask task;
        }
    ) {
            maxAggsCurrentBufferSize = Math.max(maxAggsCurrentBufferSize, circuitBreakerBytes);  
        } else {
        Arrays.sort(toConsume, Comparator.comparingInt(QuerySearchResult::getShardIndex));
        return new ReduceResult(processedShards, newTopDocs, newAggs, hasAggs ? serializedSize : 0);  
                        PendingReduces.this.onFailure(t);
                SearchPhaseController.setShardIndex(topDocs.topDocs, result.getShardIndex());
            }
                queue.add(task);
                        long newSize = reduceResult.estimatedSize - estimatedSize;
    private static final Logger logger = LogManager.getLogger(QueryPhaseResultConsumer.class);
    private void checkCancellation() {  
            aggReduceContextBuilder,
        SearchPhaseController.TopDocsStats topDocsStats,
        ReduceResult lastReduceResult,  
                    } catch (Exception t) {
                aggsList.add(result.consumeAggs().expand());  
            List<InternalAggregations> aggsList = new ArrayList<>();
                return true;
        int numReducePhases
            return topDocsList;
                        // Update the circuit breaker to remove the size of the source aggregations  
 * ownership. Elasticsearch licenses this file to you under  
    /**
        public synchronized QuerySearchResult[] consumeBuffer() {
            }  
         * would take on memory.  
        SearchRequest request,  
     */
        }  
 * exceeds the maximum memory allowed in this breaker.  
        Releasables.close(pendingReduces);
 *
        SearchPhaseController.ReducedQueryPhase reducePhase = controller.reducedQueryPhase(  
                return circuitBreakerBytes;
        pendingReduces.consume(querySearchResult, next);
import java.util.Collections;
            SearchProgressListener.buildSearchShards(results.asList()),  
            List<ReduceTask> toCancels = new ArrayList<>();  
            }
     *
                    }
        }
                topDocsList.add(topDocs.topDocs);
                }
     * @opensearch.internal
        }  
                }  
        private synchronized boolean consumeResult(QuerySearchResult result, Runnable callback) {  
        }
            circuitBreakerBytes = 0;  
        void consume(QuerySearchResult result, Runnable callback) {
        private boolean hasFailure() {  
        for (QuerySearchResult result : toConsume) {
package org.opensearch.action.search;
            return true;
        }
         * Returns the size of the serialized aggregation that is contained in the  
        this.cancelTaskOnFailure = cancelTaskOnFailure;
/*  
            circuitBreakerBytes += estimatedSize;
    private final NamedWriteableRegistry namedWriteableRegistry;  
        super(expectedResultSize);
                        long estimateRamBytesUsedForReduce = estimateRamBytesUsedForReduce(estimatedTotalSize);
            newAggs = null;
            return lastReduceResult;
            buffer.add(result);  
            }  
                    long estimatedTotalSize = (thisReduceResult != null ? thisReduceResult.estimatedSize : 0) + task.aggsBufferSize;  
            runningTask.compareAndSet(task, null);
        // the memory that is accounted in the circuit breaker for this consumer
        private final List<SearchShard> emptyResults = new ArrayList<>();  
        if (pendingReduces.hasFailure()) {
import org.apache.logging.log4j.LogManager;
                        if (toConsume == null) {
}
        // Idempotent and thread-safe failure handling
            for (QuerySearchResult result : buffer) {
import org.opensearch.common.util.concurrent.AbstractRunnable;
                        addEstimateAndMaybeBreak(estimateRamBytesUsedForReduce);  
                aggsCurrentBufferSize = 0;
                            return;  
 * as shard results are consumed.
        this.isTaskCancelled = isTaskCancelled;
        private synchronized void clearReduceTaskQueue() {  
import org.opensearch.common.lease.Releasables;
            }
                        final QuerySearchResult[] toConsume = task.consumeBuffer();  
            reducePhase.numReducePhases  
                            maxAggsCurrentBufferSize
        }  
         * Returns an estimation of the size that a reduce of the provided size
            processedShards.addAll(lastReduceResult.processedShards);
        private long ramBytesUsedQueryResult(QuerySearchResult result) {  
                            onAfterReduce(task, null, 0);
import org.apache.logging.log4j.Logger;
                return false; // callback will be run by reduce task
 */  
                try {
        // ensure consistent ordering
        pendingReduces.sortBuffer();  
            cancelTaskOnFailure,
            request,
import java.util.function.Consumer;
                }
                toCancel.cancel();
                    return true;  
            if (hasTopDocs == false) {
            pendingReduces.onFailure(new TaskCancelledException("request has been terminated"));
        int expectedResultSize,  
     * Manages incremental query result reduction by buffering incoming results and
            if (buffer.size() > 0) {  
        }
            for (QuerySearchResult result : toConsume) {
            if (newResult != null) {
 * KIND, either express or implied.  See the License for the
            executor,
                    onAfterReduce(task, newReduceResult, estimatedTotalSize);
            }  
                topDocsList.add(lastReduceResult.reducedTopDocs);  
        NamedWriteableRegistry namedWriteableRegistry,
            );  
        }
        }
    /**
        private final List<QuerySearchResult> buffer = new ArrayList<>();
            if (lastReduceResult != null) {
                        newReduceResult = partialReduce(toConsume, task.emptyResults, topDocsStats, thisReduceResult, numReducePhases);  
            long finalSize = reducePhase.aggregations.getSerializedSize() - breakerSize;  
        Executor executor,
import java.util.Comparator;
        private volatile ReduceResult reduceResult;  
    public QueryPhaseResultConsumer(
        this.pendingReduces = new PendingReduces(batchReduceSize, request.resolveTrackTotalHitsUpTo());
            }
            circuitBreaker.addWithoutBreaking(size);  
        if (pendingReduces.hasPendingReduceTask()) {  
                pendingReduces.maxAggsCurrentBufferSize
        private void tryExecuteNext() {
    private ReduceResult partialReduce(
            this.aggsBufferSize = aggsBufferSize;  
            if (circuitBreakerBytes > 0) {
            }  
                    addEstimateAndMaybeBreak(aggsSize);
            () -> false  
 *
        private volatile long aggsCurrentBufferSize;
        private final AtomicReference<Exception> failure = new AtomicReference<>();  
     *  
        long breakerSize = pendingReduces.circuitBreakerBytes;
        SearchProgressListener progressListener,
            return circuitBreakerBytes;
        this.executor = executor;
                    if (hasFailure()) {  
        private synchronized List<InternalAggregations> consumeAggs() {
import org.opensearch.search.SearchShardTarget;
                result.consumeAll(); // release memory
            // Update the circuit breaker to replace the estimation with the serialized size of the newly reduced result
            aggsList,
 * under the License.  
import org.opensearch.search.query.QuerySearchResult;
                            "aggs partial reduction [{}->{}] max [{}]",
            results.asList(),
        );  
        QuerySearchResult[] toConsume,  
        public void consumeListener() {
/*  
            for (QuerySearchResult result : toConsume) {
            executor.execute(this::tryExecuteNext);
        /**
                    reduceResult = newResult;
        final SearchPhaseController.TopDocsStats topDocsStats = pendingReduces.consumeTopDocsStats();
            }  
        }
        }
                hasPartialReduce = true;  
            reducePhase.aggregations,
        private ReduceTask(QuerySearchResult[] buffer, long aggsBufferSize, List<SearchShard> emptyResults, Runnable next) {
            if (hasFailure()) {  
                topNSize,
            circuitBreaker.addWithoutBreaking(-circuitBreakerBytes);
        private final int batchReduceSize;
        super.consumeResult(result, () -> {});
    /**
        // we leave the results un-serialized because serializing is slow but we compute the serialized  
     * <ul>
            }  
        }  
            return circuitBreakerBytes;  
            consumeListener();
import org.opensearch.search.aggregations.InternalAggregation.ReduceContextBuilder;
    @Override
                topDocsList,
 * specific language governing permissions and limitations
    private final CircuitBreaker circuitBreaker;
            }  
            newAggs = InternalAggregations.topLevelReduce(aggsList, aggReduceContextBuilder.forPartialReduction());
    @Override  
    }
        }
        }  
        NamedWriteableRegistry namedWriteableRegistry,
    final PendingReduces pendingReduces;
        }  
            task.consumeListener();
                    final ReduceResult newReduceResult;
    }
            this.emptyResults = emptyResults;
        // ensure consistent ordering
            return result.aggregations().asSerialized(InternalAggregations::readFrom, namedWriteableRegistry).ramBytesUsed();
        Consumer<Exception> cancelTaskOnFailure,
        if (hasAggs) {
    public SearchPhaseController.ReducedQueryPhase reduce() throws Exception {
            this.next = next;
    private final boolean performFinalReduce;
    ) {
                pendingReduces.aggsCurrentBufferSize,
        SearchSourceBuilder source = request.source();  
            newTopDocs = SearchPhaseController.mergeTopDocs(
            topDocsStats,
                if (queue.isEmpty() || runningTask.get() != null) {
        }
import java.util.List;  
        this(  
        private long estimateRamBytesUsedForReduce(long size) {  
     * @opensearch.internal
import org.opensearch.common.lease.Releasable;
        this.aggReduceContextBuilder = controller.getReduceContext(request);  
 * not use this file except in compliance with the License.
        this.circuitBreaker = circuitBreaker;  
            List<TopDocs> topDocsList = new ArrayList<>();
        }  
         * the reduce completes.
        checkCancellation();  
    public QueryPhaseResultConsumer(
            }  
import java.util.ArrayDeque;
        progressListener.notifyQueryResult(querySearchResult.getShardIndex());  
            pendingReduces.addWithoutBreaking(finalSize);
            List<TopDocs> topDocsList = new ArrayList<>();
            return toRet;
    /**
            return aggsList;
 * Unless required by applicable law or agreed to in writing,
                topDocsList.add(topDocs.topDocs);  
                    }
            }
                            estimatedSize,  
        this.hasTopDocs = source == null || source.size() != 0;
 *  
            }  
            executor.execute(new AbstractRunnable() {
                    try {
            }
    public int getNumReducePhases() {  
            expectedResultSize,
                        );  
import java.util.concurrent.Executor;
                runningTask.compareAndSet(null, task);
         * This size is estimated as roughly 1.5 times the size of the serialized
         * off for some aggregations but it is corrected with the real size after  
        this.progressListener = progressListener;
         */
            }
            }
        }
    }
            }  
            return queue.isEmpty() == false || runningTask.get() != null;
                circuitBreakerBytes = 0;
                buffer.add(result);  
    }  
            }
            }  
            controller,
            clearReduceTaskQueue();
                aggsList.add(reduceResult.reducedAggs);
        private synchronized void onFailure(Exception exc) {  
     * <li>Provides thread-safe failure handling with cleanup</li>
                synchronized (this) {
        SearchRequest request,  
import java.util.ArrayList;
                // the callback must wait for the new reduce task to complete to maintain proper result processing order
                        logger.trace(
            buffer = null;
 * A {@link ArraySearchPhaseResults} implementation that incrementally reduces aggregation results
                        addWithoutBreaking(newSize);  
    private final boolean hasAggs;
            if (hasFailure()) {
            consumeBuffer();
 * GitHub history for details.
        }
        private Runnable next;
        }  
                "aggs final reduction [{}] max [{}]",  
    private final int topNSize;
                callback.run();
                }  
                    runningTask.compareAndSet(task, null);  
            int size = buffer.size() + (hasPartialReduce ? 1 : 0);
import org.opensearch.search.builder.SearchSourceBuilder;
                return Collections.emptyList();  
                    onFailure(e);
            throw new AssertionError("partial reduce in-flight");
            if (hasAggs) {
            synchronized (this) {  
                next = null;
        }
            toCancels.addAll(queue);
            assert hasPendingReduceTask() == false : "cannot close with partial reduce in-flight";
                0
        }  
                return;  
import java.util.Arrays;  
        private final SearchPhaseController.TopDocsStats topDocsStats;
                SearchShardTarget target = result.getSearchShardTarget();  
                buffer.clear();
            if (hasFailure()) {
        }
    ) {  
         * provided {@link QuerySearchResult}.
        private final ArrayDeque<ReduceTask> queue = new ArrayDeque<>();
        private void onAfterReduce(ReduceTask task, ReduceResult newResult, long estimatedSize) {  
 * SPDX-License-Identifier: Apache-2.0
        if (isTaskCancelled.getAsBoolean()) {
            reducePhase.totalHits,
     * Creates a {@link QueryPhaseResultConsumer} that incrementally reduces aggregation results
            if (reduceResult != null) {  
        this.namedWriteableRegistry = namedWriteableRegistry;
            QuerySearchResult[] toRet = buffer;  
                return;
import org.opensearch.core.common.breaker.CircuitBreaker;
        /**
import org.opensearch.search.aggregations.InternalAggregations;  
                // we have to merge here in the same way we collect on a shard  
 * in the {@link CircuitBreaker#REQUEST} circuit breaker. Before any partial or final reduce, the memory
        private void sortBuffer() {
                        return;
        progressListener.notifyPartialReduce(processedShards, topDocsStats.getTotalHits(), newAggs, numReducePhases);
import java.util.function.BooleanSupplier;  
        @Override  
                } catch (CircuitBreakingException e) {
                circuitBreaker.addWithoutBreaking(-circuitBreakerBytes);  
            );  
                @Override
            queue.clear();
        SearchPhaseController controller,  
        private synchronized List<TopDocs> consumeTopDocs() {
            if (reduceResult != null) {
            // Process non-empty results  
        long serializedSize = hasAggs ? newAggs.getSerializedSize() : 0;
            assert circuitBreakerBytes >= 0;
     * ReduceTask is created to reduce buffered query results when buffer size hits threshold  
     * @opensearch.internal
                    aggsCurrentBufferSize += aggsSize;  
        }
 * @opensearch.internal
                aggsList.add(result.consumeAggs().expand());
            circuitBreakerBytes += size;
            performFinalReduce
        }  
                aggsList.add(lastReduceResult.reducedAggs);  
    private final BooleanSupplier isTaskCancelled;  
        private synchronized SearchPhaseController.TopDocsStats consumeTopDocsStats() {  
    }
            }  
 * the Apache License, Version 2.0 (the "License"); you may
            if (hasFailure()) {  
        private boolean hasPendingReduceTask() {
import org.opensearch.search.SearchPhaseResult;  
            }  
     */  
    private final Consumer<Exception> cancelTaskOnFailure;
            // Check circuit breaker before consuming
                topDocsList.add(reduceResult.reducedTopDocs);
        private synchronized long addEstimateAndMaybeBreak(long estimatedSize) {  
            throw pendingReduces.failure.get();
            pendingReduces.numReducePhases,
    }
            if (result.isNull()) {
 * This implementation adds the memory that it used to save and reduce the results of shard aggregations  
            assert circuitBreakerBytes >= 0;
        if (pendingReduces.hasFailure()) {
        );
                if (hasFailure()) {
     * <li>Handles circuit breaker memory accounting</li>
    }  
                        // and replace the estimation with the serialized size of the newly reduced result.
 */  
        return (hasAggs || hasTopDocs) ? Math.min(requestBatchedReduceSize, minBatchReduceSize) : minBatchReduceSize;  
            this.buffer = buffer;
                Collections.sort(buffer, Comparator.comparingInt(QuerySearchResult::getShardIndex));
                tryExecuteNext();
            }
        this.performFinalReduce = request.isFinalReduce();  
        public synchronized void cancel() {  
            SearchShardTarget target = result.getSearchShardTarget();
            if (hasAggs == false) {  
        private volatile long maxAggsCurrentBufferSize = 0;
                    return;
        private QuerySearchResult[] buffer;  
 * this file be licensed under the Apache-2.0 license or a
            for (QuerySearchResult result : buffer) {  
 * software distributed under the License is distributed on an
            }
                @Override  
        int expectedResultSize,  
                }  
        CircuitBreaker circuitBreaker,
        long estimatedSize) {
            if (lastReduceResult != null) {
            failure.compareAndSet(null, exc);
                        ++numReducePhases;
        private volatile long circuitBreakerBytes;
            if (consumeResult(result, callback)) {
        // the memory that is currently used in the buffer  
            if (task != null) {
        if (lastReduceResult != null) {
        if (hasAggs && reducePhase.aggregations != null) {
 * this work for additional information regarding copyright
            progressListener,
import org.opensearch.common.lucene.search.TopDocsAndMaxScore;  
    private final Executor executor;
        return reducePhase;
        CircuitBreaker circuitBreaker,
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
                emptyResults.add(new SearchShard(target.getClusterAlias(), target.getShardId()));
                        }
        List<SearchShard> emptyResults,
            return Math.round(0.5d * size);
            });  
                ReduceTask task = new ReduceTask(clone, aggsCurrentBufferSize, new ArrayList<>(emptyResults), callback);  
            }
    }  
                TopDocsAndMaxScore topDocs = result.consumeTopDocs();  
            for (QuerySearchResult result : buffer) {
    int getBatchReduceSize(int requestBatchedReduceSize, int minBatchReduceSize) {
    public void consumeResult(SearchPhaseResult result, Runnable next) {  
 * The OpenSearch Contributors require contributions made to  
        );
                toCancels.add(task);
            checkCancellation();
 * license agreements. See the NOTICE file distributed with
            breakerSize = pendingReduces.addEstimateAndMaybeBreak(pendingReduces.estimateRamBytesUsedForReduce(breakerSize));
    }  
    private final SearchProgressListener progressListener;
                    return;
        private final List<SearchShard> emptyResults;
                    if (hasAggs) {
import org.opensearch.core.tasks.TaskCancelledException;
        for (QuerySearchResult result : toConsume) {
                public void onFailure(Exception exc) {  
                protected void doRun() {
                        estimatedTotalSize += estimateRamBytesUsedForReduce;
        if (hasTopDocs) {  
        QuerySearchResult querySearchResult = result.queryResult();
        int batchReduceSize = getBatchReduceSize(request.getBatchedReduceSize(), expectedResultSize);  
                    PendingReduces.this.onFailure(exc);
        }  
        private synchronized long addWithoutBreaking(long size) {
    }
            resetCircuitBreaker();  
     * Immutable container holding the outcome of a partial reduce operation  
     * </ul>
        checkCancellation();  
            this.topDocsStats = new SearchPhaseController.TopDocsStats(trackTotalHitsUpTo);  
        BooleanSupplier isTaskCancelled
        }
                    }
        final InternalAggregations newAggs;
import org.apache.lucene.search.TopDocs;  
            List<InternalAggregations> aggsList = new ArrayList<>();  
            ReduceTask task = runningTask.get();
            topDocsStats.add(result.topDocs(), result.searchTimedOut(), result.terminatedEarly());
    private final SearchPhaseController controller;  
        }
        Consumer<Exception> cancelTaskOnFailure
            if (next != null) {  
        }  
                            reduceResult.estimatedSize,
                assert circuitBreakerBytes == 0;
                topDocsStats.add(result.topDocs(), result.searchTimedOut(), result.terminatedEarly());
         */
            maxAggsCurrentBufferSize = Math.max(maxAggsCurrentBufferSize, circuitBreakerBytes);
            // Add an estimate of the final reduce size  
        final List<InternalAggregations> aggsList = pendingReduces.consumeAggs();  
            for (ReduceTask toCancel : toCancels) {
                assert circuitBreakerBytes == 0;
            }
                        return;  
        private final AtomicReference<ReduceTask> runningTask = new AtomicReference<>(); // ensure only one task is running
        }
    }  
            topDocsList,  
            reduceResult = null;  
                SearchPhaseController.setShardIndex(topDocs.topDocs, result.getShardIndex());
            namedWriteableRegistry,  
        private volatile boolean hasPartialReduce;
                QuerySearchResult[] clone = buffer.toArray(QuerySearchResult[]::new);
 * compatible open source license.
        return pendingReduces.numReducePhases;
    @Override
    }
