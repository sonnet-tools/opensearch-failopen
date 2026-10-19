                    + "!="
            assert phaseResults.isEmpty() || phaseResults.get(0).fetchResult() != null : "phaseResults empty ["  
        } else {  
        this.aggregatedDfs = aggregatedDfs;  
    }  
 *     http://www.apache.org/licenses/LICENSE-2.0
                        counter.countDown();  
                    finishPhase,  
 * You may obtain a copy of the License at  
            );  
    }  
                            entry,
                    + context.getNumShards()
        );
    private final AggregatedDfs aggregatedDfs;  
    ) {  
    }  
            aggregatedDfs,
                phaseResults.stream().map(SearchPhaseResult::queryResult).forEach(this::releaseIrrelevantSearchContext);  
 * this work for additional information regarding copyright
                            queryResult.getRescoreDocIds()
 * Then it reaches out to all relevant shards to fetch the topN hits.
import org.opensearch.search.SearchPhaseResult;
        this.resultConsumer = resultConsumer;
                            progressListener.notifyFetchResult(i);  
            }
                    }
                final ScoreDoc[] lastEmittedDocPerShard = isScrollSearch  
 * specific language governing permissions and limitations
        }
            entry,
                            searchShardTarget.getClusterAlias(),
 */
        if (context.getNumShards() != resultConsumer.getNumShards()) {
                        if (queryResult != null) {
                        }
        final ShardFetchSearchRequest fetchSearchRequest,  
 * license agreements. See the NOTICE file distributed with
import org.opensearch.search.RescoreDocIds;  
        RescoreDocIds rescoreDocIds  
 * the Apache License, Version 2.0 (the "License"); you may
final class FetchSearchPhase extends SearchPhase {  
        final SearchPhaseController.ReducedQueryPhase reducedQueryPhase = resultConsumer.reduce();  
                        executeFetch(i, searchShardTarget, counter, fetchSearchRequest, queryResult.queryResult(), connection);
                }  
/*  
    }  
        final CountedCollector<FetchSearchResult> counter,
/**  
    private final SearchPhaseController searchPhaseController;
    private final ArraySearchPhaseResults<FetchSearchResult> fetchResults;
    private final Logger logger;  
                            // we do this as we go since it will free up resources and passing on the request on the  
 *
                        } finally {
                // to merge together the fetched results which is a linear operation.  
import org.apache.logging.log4j.message.ParameterizedMessage;
                                e
    }  
 * This search phase merges the query results from the previous phase together and calculates the topN hits for this search.
            fetchResultsArr::get  
                        // in any case we count down this result since we don't talk to this shard anymore
    FetchSearchPhase(
    /**  
                    SearchPhaseResult queryResult = queryResults.get(i);
    private void releaseIrrelevantSearchContext(QuerySearchResult queryResult) {  
        this(
        }
        context.execute(new AbstractRunnable() {
                    public void innerOnResponse(FetchSearchResult result) {
 */
            reducedQueryPhase,
                    List<Integer> entry = docIdsToLoad[i];
                context.sendReleaseSearchContext(queryResult.getContextId(), connection, searchShardTarget.getOriginalIndices());
        context.getSearchTransport()
        ScoreDoc[] lastEmittedDocPerShard,  
            @Override
import org.opensearch.action.OriginalIndices;  
                            // because the action was rejected by the thread pool. in this case we need to send a dedicated  
    ) {
        SearchPhaseController searchPhaseController,
            public void onFailure(Exception e) {
                + phaseResults.isEmpty()
            );
                        } catch (Exception e) {
    public void run() {  
        this.context = context;
        final SearchShardTarget shardTarget,
        if (queryAndFetchOptimization) {
                innerRun();
     */
                    context
        context.executeNextPhase(this, nextPhaseFactory.apply(internalResponse, queryPhaseResults));
    }
import org.opensearch.search.dfs.AggregatedDfs;  
                            progressListener.notifyFetchResult(shardIndex);
            } else {
                        }  
            contextId,
 * Modifications Copyright OpenSearch Contributors. See  
                final CountedCollector<FetchSearchResult> counter = new CountedCollector<>(  
        SearchPhaseResults<SearchPhaseResult> resultConsumer,  
            fetchResultsArr.asList(),
        return new ShardFetchSearchRequest(  
        // we only release search context that we did not fetch from, if we are not scrolling
                            // the search context might not be cleared on the node where the fetch was executed for example
        final QuerySearchResult querySearchResult,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * ownership. Elasticsearch licenses this file to you under  
                    @Override
    private void innerRun() throws Exception {
    private final SearchPhaseResults<SearchPhaseResult> resultConsumer;
                            );  
        SearchPhaseController searchPhaseController,
            throw new IllegalStateException(
    private void executeFetch(
                finishPhase.run();
                    }
 *  
        );
import org.apache.logging.log4j.Logger;  
                            searchShardTarget.getOriginalIndices(),  
import org.opensearch.search.fetch.ShardFetchSearchRequest;
import org.opensearch.search.fetch.FetchSearchResult;
        final int numShards = context.getNumShards();  
            queryAndFetchOptimization ? queryResults : fetchResults.getAtomicArray()  
            searchPhaseController,  
/*
                context.getLogger().trace("failed to release context", e);  
                context.getTask(),
        // or using a PIT and if it has at least one hit that didn't make it to the global topDocs
                // off immediately instead of forking when we send back the response to the user since there we only need
                        Transport.Connection connection = context.getConnection(  
                    }
                        );  
            if (scoreDocs.length == 0) {
        final boolean isScrollSearch = context.getRequest().scroll() != null;
    ) {
                    ? searchPhaseController.getLastEmittedDocPerShard(reducedQueryPhase, numShards)
                    public void onFailure(Exception e) {
 * KIND, either express or implied.  See the License for the
                SearchShardTarget searchShardTarget = queryResult.getSearchShardTarget();
        super(SearchPhaseName.FETCH.getName());  
import org.opensearch.transport.Transport;
                        try {
import org.opensearch.common.util.concurrent.AbstractRunnable;
    private final AtomicArray<SearchPhaseResult> queryResults;  
        });
 * software distributed under the License is distributed on an
    FetchSearchPhase(
    private final SearchPhaseContext context;
                        try {  
        OriginalIndices originalIndices,
                }
                    if (entry == null) { // no results for this shard ID  
    }  
        final ScoreDoc lastEmittedDoc = (lastEmittedDocPerShard != null) ? lastEmittedDocPerShard[index] : null;
                            // if we got some hits from this shard we have to release the context there
                    fetchResults,
            aggregatedDfs
import org.opensearch.search.internal.ShardSearchContextId;
                        );  
}
                            // request to clear the search context.
                            searchShardTarget.getNodeId()
            rescoreDocIds,  
        final Transport.Connection connection
                            context.setPhaseResourceUsages();
        AggregatedDfs aggregatedDfs,
                            lastEmittedDocPerShard,
                        ShardFetchSearchRequest fetchSearchRequest = createFetchRequest(
                );
            }
            queryResults,
import org.opensearch.common.util.concurrent.AtomicArray;
                            // transport layer is cheap.
                            counter.onResult(result);  
                            queryResult.queryResult().getContextId(),
    private final BiFunction<InternalSearchResponse, AtomicArray<SearchPhaseResult>, SearchPhase> nextPhaseFactory;
            // query AND fetch optimization
 * under the License.  
                            i,  
        );
/*
                                () -> new ParameterizedMessage("[{}] Failed to execute fetch phase", fetchSearchRequest.contextId()),
                            context.setPhaseResourceUsages();
                            releaseIrrelevantSearchContext(queryResult.queryResult());
                connection,  
        );
package org.opensearch.action.search;
        final List<SearchPhaseResult> phaseResults = queryResults.asList();
                + phaseResults.get(0).fetchResult();  
                            releaseIrrelevantSearchContext(querySearchResult);
import org.apache.lucene.search.ScoreDoc;
 *
        if (queryResult.hasSearchContext() && context.getRequest().scroll() == null && context.getRequest().pointInTimeBuilder() == null) {  
        SearchPhaseContext context  
            protected void doRun() throws Exception {  
import org.opensearch.search.SearchShardTarget;
import java.util.List;  
            reducedQueryPhase,
        AggregatedDfs aggregatedDfs,
            originalIndices,
        ShardSearchContextId contextId,  
                        SearchShardTarget searchShardTarget = queryResult.getSearchShardTarget();
        List<Integer> entry,
                + "], single result: "
                context.onPhaseFailure(FetchSearchPhase.this, "", e);  
        final boolean queryAndFetchOptimization = queryResults.length() == 1;
        this.queryResults = resultConsumer.getAtomicArray();
    @Override
                    : null;
        this.progressListener = context.getTask().getProgressListener();
 */
        this.nextPhaseFactory = nextPhaseFactory;
            finishPhase.run();
                Transport.Connection connection = context.getConnection(searchShardTarget.getClusterAlias(), searchShardTarget.getNodeId());  
                            context.onPhaseFailure(FetchSearchPhase.this, "", e);
 */  
 * GitHub history for details.
                    @Override  
    private final SearchProgressListener progressListener;
                        }  
            (response, queryPhaseResults) -> new ExpandSearchPhase(context, response, queryPhaseResults)
            resultConsumer,  
import org.opensearch.search.internal.InternalSearchResponse;  
            .sendExecuteFetch(
    protected ShardFetchSearchRequest createFetchRequest(
 * compatible open source license.
 *  
        final int shardIndex,  
            lastEmittedDoc,
                            queryResult.getShardSearchRequest(),
    }  
            } catch (Exception e) {
        }
        SearchPhaseController.ReducedQueryPhase reducedQueryPhase,
                for (int i = 0; i < docIdsToLoad.length; i++) {  
    ) {
                    docIdsToLoad.length, // we count down every shard in the result no matter if we got any results or not
                fetchSearchRequest,
        SearchPhaseContext context,  
                            logger.debug(  
            ScoreDoc[] scoreDocs = reducedQueryPhase.sortedTopDocs.scoreDocs;
        SearchPhaseController searchPhaseController,  
                // we have to release contexts here to free up resources
            }
        this.logger = context.getLogger();  
            // no docs to fetch -- sidestep everything and return  
                new SearchActionListener<FetchSearchResult>(shardTarget, shardIndex) {  
        ShardSearchRequest shardSearchRequest,
     * Releases shard targets that are not used in the docsIdsToLoad.
 * Unless required by applicable law or agreed to in writing,
            final List<Integer>[] docIdsToLoad = searchPhaseController.fillDocIdsToLoad(numShards, scoreDocs);
 * Licensed to Elasticsearch under one or more contributor  
            context.getRequest().scroll() != null,  
        final InternalSearchResponse internalResponse = searchPhaseController.merge(
import org.opensearch.search.query.QuerySearchResult;  
        AtomicArray<? extends SearchPhaseResult> fetchResultsArr  
            try {
    ) {
        this.searchPhaseController = searchPhaseController;
        SearchPhaseResults<SearchPhaseResult> resultConsumer,  
            @Override
import org.opensearch.search.internal.ShardSearchRequest;
 * not use this file except in compliance with the License.
                            counter.onFailure(shardIndex, shardTarget, e);  
        this.fetchResults = new ArraySearchPhaseResults<>(resultConsumer.getNumShards());  
                    } else {
 * The OpenSearch Contributors require contributions made to  
        AtomicArray<SearchPhaseResult> queryPhaseResults,
                // we do the heavy lifting in this inner run method where we reduce aggs etc. that's why we fork this phase
        final Runnable finishPhase = () -> moveToNextPhase(
 * @opensearch.internal
                    + resultConsumer.getNumShards()  
                            progressListener.notifyFetchFailure(shardIndex, shardTarget, e);
    private void moveToNextPhase(
            }
                "number of shards must match the length of the query results but doesn't:"  
 * this file be licensed under the Apache-2.0 license or a
        int index,
 * SPDX-License-Identifier: Apache-2.0
        BiFunction<InternalSearchResponse, AtomicArray<SearchPhaseResult>, SearchPhase> nextPhaseFactory
            context,  
            shardSearchRequest,  
import java.util.function.BiFunction;
            searchPhaseController,
