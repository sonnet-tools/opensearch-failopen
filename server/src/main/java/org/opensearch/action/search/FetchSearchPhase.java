 * KIND, either express or implied.  See the License for the
            searchPhaseController,
 * This search phase merges the query results from the previous phase together and calculates the topN hits for this search.
            try {
            @Override
        context.getSearchTransport()
        if (queryResult.hasSearchContext() && context.getRequest().scroll() == null && context.getRequest().pointInTimeBuilder() == null) {
}
                            releaseIrrelevantSearchContext(queryResult.queryResult());
/**
                    : null;
    private final SearchPhaseResults<SearchPhaseResult> resultConsumer;
                            context.setPhaseResourceUsages();
    private final Logger logger;
                            context.onPhaseFailure(FetchSearchPhase.this, "", e);
                        );
                phaseResults.stream().map(SearchPhaseResult::queryResult).forEach(this::releaseIrrelevantSearchContext);
import org.opensearch.search.query.QuerySearchResult;
                // we do the heavy lifting in this inner run method where we reduce aggs etc. that's why we fork this phase
/*
            queryResults,
 */
            entry,
                            entry,
import org.opensearch.search.fetch.FetchSearchResult;
    private void moveToNextPhase(
    private void innerRun() throws Exception {
            .sendExecuteFetch(
            lastEmittedDoc,
                            searchShardTarget.getOriginalIndices(),
        BiFunction<InternalSearchResponse, AtomicArray<SearchPhaseResult>, SearchPhase> nextPhaseFactory
        SearchPhaseController.ReducedQueryPhase reducedQueryPhase,
                            progressListener.notifyFetchResult(shardIndex);
        final Runnable finishPhase = () -> moveToNextPhase(
import org.opensearch.search.dfs.AggregatedDfs;
                final CountedCollector<FetchSearchResult> counter = new CountedCollector<>(
 *
 * ownership. Elasticsearch licenses this file to you under
            }
    private final SearchPhaseController searchPhaseController;
import java.util.List;
        SearchPhaseResults<SearchPhaseResult> resultConsumer,
            fetchResultsArr.asList(),
            assert phaseResults.isEmpty() || phaseResults.get(0).fetchResult() != null : "phaseResults empty ["
                context.sendReleaseSearchContext(queryResult.getContextId(), connection, searchShardTarget.getOriginalIndices());
 * license agreements. See the NOTICE file distributed with
            contextId,
            ScoreDoc[] scoreDocs = reducedQueryPhase.sortedTopDocs.scoreDocs;
        SearchPhaseContext context
        final QuerySearchResult querySearchResult,
                    } else {
                }
                + "], single result: "
                    + "!="
            if (scoreDocs.length == 0) {
            fetchResultsArr::get
    private final AggregatedDfs aggregatedDfs;
                            counter.onFailure(shardIndex, shardTarget, e);
            protected void doRun() throws Exception {
                            searchShardTarget.getNodeId()
                // to merge together the fetched results which is a linear operation.
                        }
 * this file be licensed under the Apache-2.0 license or a
                    }
 * compatible open source license.
 * specific language governing permissions and limitations
            aggregatedDfs
import org.opensearch.action.OriginalIndices;
            );
            // query AND fetch optimization
        final int numShards = context.getNumShards();
                        );
                    ? searchPhaseController.getLastEmittedDocPerShard(reducedQueryPhase, numShards)
    }
        this(
        ShardSearchRequest shardSearchRequest,
    private void releaseIrrelevantSearchContext(QuerySearchResult queryResult) {
        this.fetchResults = new ArraySearchPhaseResults<>(resultConsumer.getNumShards());
    private final SearchProgressListener progressListener;
import org.opensearch.common.util.concurrent.AtomicArray;
                            queryResult.getRescoreDocIds()
        final List<SearchPhaseResult> phaseResults = queryResults.asList();
                            // if we got some hits from this shard we have to release the context there
 *     http://www.apache.org/licenses/LICENSE-2.0
 * Then it reaches out to all relevant shards to fetch the topN hits.
        AtomicArray<SearchPhaseResult> queryPhaseResults,
                            progressListener.notifyFetchFailure(shardIndex, shardTarget, e);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            finishPhase.run();
import org.apache.logging.log4j.message.ParameterizedMessage;
        // or using a PIT and if it has at least one hit that didn't make it to the global topDocs
            // no docs to fetch -- sidestep everything and return
    FetchSearchPhase(
     * Releases shard targets that are not used in the docsIdsToLoad.
                            progressListener.notifyFetchResult(i);
 * Unless required by applicable law or agreed to in writing,
 * You may obtain a copy of the License at
 */
    ) {
            } else {
                            );
                final ScoreDoc[] lastEmittedDocPerShard = isScrollSearch
                        SearchShardTarget searchShardTarget = queryResult.getSearchShardTarget();
                + phaseResults.isEmpty()
    private final SearchPhaseContext context;
                            // the search context might not be cleared on the node where the fetch was executed for example
                        executeFetch(i, searchShardTarget, counter, fetchSearchRequest, queryResult.queryResult(), connection);
        AtomicArray<? extends SearchPhaseResult> fetchResultsArr
                    if (entry == null) { // no results for this shard ID
                        Transport.Connection connection = context.getConnection(
        SearchPhaseResults<SearchPhaseResult> resultConsumer,
import org.apache.lucene.search.ScoreDoc;
    private final AtomicArray<SearchPhaseResult> queryResults;
        if (queryAndFetchOptimization) {
 *
        );
                    fetchResults,
                        }
    }
    ) {
 *
                            i,
        );
                        // in any case we count down this result since we don't talk to this shard anymore
package org.opensearch.action.search;
    FetchSearchPhase(
 * not use this file except in compliance with the License.
            rescoreDocIds,
    /**
    }
                        } catch (Exception e) {
        OriginalIndices originalIndices,
                    docIdsToLoad.length, // we count down every shard in the result no matter if we got any results or not
                            lastEmittedDocPerShard,
import org.opensearch.search.fetch.ShardFetchSearchRequest;
                    }
                            queryResult.queryResult().getContextId(),
                    + resultConsumer.getNumShards()
                + phaseResults.get(0).fetchResult();
    }
        super(SearchPhaseName.FETCH.getName());
                            searchShardTarget.getClusterAlias(),
        int index,
        this.logger = context.getLogger();
        AggregatedDfs aggregatedDfs,
            );
     */
                            releaseIrrelevantSearchContext(querySearchResult);
        context.executeNextPhase(this, nextPhaseFactory.apply(internalResponse, queryPhaseResults));
                                e
                        counter.countDown();
            context,
        final SearchPhaseController.ReducedQueryPhase reducedQueryPhase = resultConsumer.reduce();
        AggregatedDfs aggregatedDfs,
 * @opensearch.internal
                        if (queryResult != null) {
                        } finally {
        this.searchPhaseController = searchPhaseController;
            }
 * SPDX-License-Identifier: Apache-2.0
import org.apache.logging.log4j.Logger;
import java.util.function.BiFunction;
                }
import org.opensearch.search.SearchPhaseResult;
        );
                            // we do this as we go since it will free up resources and passing on the request on the
 * GitHub history for details.
 * The OpenSearch Contributors require contributions made to
            public void onFailure(Exception e) {
                        }
                    SearchPhaseResult queryResult = queryResults.get(i);
 * under the License.
                    List<Integer> entry = docIdsToLoad[i];
                        try {
 *
                    public void onFailure(Exception e) {
 */
                    }
        this.context = context;
            searchPhaseController,
        if (context.getNumShards() != resultConsumer.getNumShards()) {
            originalIndices,
                            context.setPhaseResourceUsages();
        this.resultConsumer = resultConsumer;
            (response, queryPhaseResults) -> new ExpandSearchPhase(context, response, queryPhaseResults)
    }
        this.progressListener = context.getTask().getProgressListener();
                for (int i = 0; i < docIdsToLoad.length; i++) {
            resultConsumer,
import org.opensearch.search.internal.ShardSearchContextId;
    private final BiFunction<InternalSearchResponse, AtomicArray<SearchPhaseResult>, SearchPhase> nextPhaseFactory;
        final Transport.Connection connection
        final SearchShardTarget shardTarget,
final class FetchSearchPhase extends SearchPhase {
                context.onPhaseFailure(FetchSearchPhase.this, "", e);
        List<Integer> entry,
                SearchShardTarget searchShardTarget = queryResult.getSearchShardTarget();
        return new ShardFetchSearchRequest(
            throw new IllegalStateException(
                    @Override
        final CountedCollector<FetchSearchResult> counter,
                context.getTask(),
        }
        });
import org.opensearch.transport.Transport;
                connection,
import org.opensearch.search.SearchShardTarget;
                        try {
    @Override
    ) {
        context.execute(new AbstractRunnable() {
    protected ShardFetchSearchRequest createFetchRequest(
    private void executeFetch(
        ScoreDoc[] lastEmittedDocPerShard,
                            counter.onResult(result);
 */
 * Licensed to Elasticsearch under one or more contributor
        final ScoreDoc lastEmittedDoc = (lastEmittedDocPerShard != null) ? lastEmittedDocPerShard[index] : null;
        this.aggregatedDfs = aggregatedDfs;
            @Override
        SearchPhaseController searchPhaseController,
                            // transport layer is cheap.
            context.getRequest().scroll() != null,
            aggregatedDfs,
                new SearchActionListener<FetchSearchResult>(shardTarget, shardIndex) {
            reducedQueryPhase,
        SearchPhaseController searchPhaseController,
            shardSearchRequest,
            }
        this.nextPhaseFactory = nextPhaseFactory;
        SearchPhaseContext context,
            } catch (Exception e) {
import org.opensearch.common.util.concurrent.AbstractRunnable;
        final boolean isScrollSearch = context.getRequest().scroll() != null;
    }
    ) {
        SearchPhaseController searchPhaseController,
        final int shardIndex,
                    finishPhase,
                                () -> new ParameterizedMessage("[{}] Failed to execute fetch phase", fetchSearchRequest.contextId()),
        } else {
        final InternalSearchResponse internalResponse = searchPhaseController.merge(
    private final ArraySearchPhaseResults<FetchSearchResult> fetchResults;
 * Modifications Copyright OpenSearch Contributors. See
        RescoreDocIds rescoreDocIds
    ) {
    }
                "number of shards must match the length of the query results but doesn't:"
        final ShardFetchSearchRequest fetchSearchRequest,
import org.opensearch.search.internal.InternalSearchResponse;
            reducedQueryPhase,
/*
/*
        );
            final List<Integer>[] docIdsToLoad = searchPhaseController.fillDocIdsToLoad(numShards, scoreDocs);
                            queryResult.getShardSearchRequest(),
                context.getLogger().trace("failed to release context", e);
import org.opensearch.search.RescoreDocIds;
 * the Apache License, Version 2.0 (the "License"); you may
                            // request to clear the search context.
                finishPhase.run();
                Transport.Connection connection = context.getConnection(searchShardTarget.getClusterAlias(), searchShardTarget.getNodeId());
 * software distributed under the License is distributed on an
        final boolean queryAndFetchOptimization = queryResults.length() == 1;
                fetchSearchRequest,
                    @Override
                        ShardFetchSearchRequest fetchSearchRequest = createFetchRequest(
        }
                            logger.debug(
                // we have to release contexts here to free up resources
import org.opensearch.search.internal.ShardSearchRequest;
    }
        }
                // off immediately instead of forking when we send back the response to the user since there we only need
                innerRun();
        // we only release search context that we did not fetch from, if we are not scrolling
                    context
                    public void innerOnResponse(FetchSearchResult result) {
    public void run() {
                );
        ShardSearchContextId contextId,
        this.queryResults = resultConsumer.getAtomicArray();
            }
                            // because the action was rejected by the thread pool. in this case we need to send a dedicated
 * this work for additional information regarding copyright
            queryAndFetchOptimization ? queryResults : fetchResults.getAtomicArray()
                    + context.getNumShards()
