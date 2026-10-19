                dfs  
        for (final DfsSearchResult dfsResult : searchResults) {
    }
                                // the query might not have been executed at all (for example because thread pool rejected  
 * specific language governing permissions and limitations
                                .debug(
    ) {
            searchResults.size(),
                    protected void innerOnResponse(QuerySearchResult response) {
 * operation.
                        } finally {
        this.nextPhaseFactory = nextPhaseFactory;
    private final List<DfsSearchResult> searchResults;  
 * Unless required by applicable law or agreed to in writing,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *     http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.transport.Transport;
                                    exception  
            context  
            searchTransportService.sendExecuteQuery(  
                    @Override  
        this.searchResults = searchResults;
        this.progressListener = context.getTask().getProgressListener();  
                        try {
            QuerySearchRequest querySearchRequest = new QuerySearchRequest(
                                    connection,
        super(SearchPhaseName.DFS_QUERY.getName());
        context.addReleasable(queryResult);
    private final SearchPhaseContext context;  
                            context.onPhaseFailure(DfsQueryPhase.this, "", e);
 */  
 *
import java.util.function.Function;
                                    searchShardTarget.getOriginalIndices()  
                                // execution) and the search context that was created in dfs phase might not be released.
        // to free up memory early
 * the Apache License, Version 2.0 (the "License"); you may
        // at the end of the search  
                                );
 * search terms used in the actual search query. This phase is very similar to a the default query-then-fetch search phase but it doesn't  
    private final Function<ArraySearchPhaseResults<SearchPhaseResult>, SearchPhase> nextPhaseFactory;
 *  
        QueryPhaseResultConsumer queryResult,
                    }
                querySearchRequest,
        Function<ArraySearchPhaseResults<SearchPhaseResult>, SearchPhase> nextPhaseFactory,
import java.io.IOException;  
        final CountedCollector<SearchPhaseResult> counter = new CountedCollector<>(
                context.getTask(),  
 * This search phase fans out to every shards to execute a distributed search with a pre-collected distributed frequencies for all
    }
        AggregatedDfs dfs,  
                            }
        List<DfsSearchResult> searchResults,
                                    () -> new ParameterizedMessage("[{}] Failed to execute query phase", querySearchRequest.contextId()),
                            counter.onFailure(shardIndex, searchShardTarget, exception);  
 * ownership. Elasticsearch licenses this file to you under  
package org.opensearch.action.search;
import org.opensearch.search.dfs.DfsSearchResult;
    @Override
                                // release it again to be in the safe side
 *
                dfsResult.getShardSearchRequest(),
 * Modifications Copyright OpenSearch Contributors. See  
 * compatible open source license.
/*
                        } catch (Exception e) {
                        }  
        this.searchTransportService = context.getSearchTransport();  
import org.opensearch.search.dfs.AggregatedDfs;  
 * this file be licensed under the Apache-2.0 license or a
                            if (context.getRequest().pointInTimeBuilder() == null) {
}  
                                    querySearchRequest.contextId(),
 * @opensearch.internal
        // TODO we can potentially also consume the actual per shard results from the initial phase here in the aggregateDfs  
 */
            () -> context.executeNextPhase(this, nextPhaseFactory.apply(queryResult)),
    private final SearchTransportService searchTransportService;
    public void run() throws IOException {
                            progressListener.notifyQueryFailure(shardIndex, searchShardTarget, exception);
 * this work for additional information regarding copyright
    DfsQueryPhase(
        this.queryResult = queryResult;
 * retry on another shard if any of the shards are failing. Failures are treated as shard failures and are counted as a non-successful
 * under the License.  
 * not use this file except in compliance with the License.
                        }  
 * GitHub history for details.
/**
            );  
                    @Override  
 * The OpenSearch Contributors require contributions made to  
        // register the release of the query consumer to free up the circuit breaker memory
import org.apache.logging.log4j.message.ParameterizedMessage;  
 * You may obtain a copy of the License at  
 */  
                new SearchActionListener<QuerySearchResult>(searchShardTarget, shardIndex) {
        }
 */
                dfsResult.getContextId(),
 * license agreements. See the NOTICE file distributed with
import org.opensearch.search.SearchPhaseResult;
import java.util.List;
final class DfsQueryPhase extends SearchPhase {
                    public void onFailure(Exception exception) {
import org.opensearch.search.SearchShardTarget;
 * @see CountedCollector#onFailure(int, SearchShardTarget, Exception)  
            final SearchShardTarget searchShardTarget = dfsResult.getSearchShardTarget();  
        SearchPhaseContext context  
import org.opensearch.search.query.QuerySearchResult;  
 *
import org.opensearch.search.query.QuerySearchRequest;
                connection,
/*
 * Licensed to Elasticsearch under one or more contributor  
 * software distributed under the License is distributed on an
        this.dfs = dfs;  
            final int shardIndex = dfsResult.getShardIndex();
                                );
    private final ArraySearchPhaseResults<SearchPhaseResult> queryResult;
                                context.sendReleaseSearchContext(  
            Transport.Connection connection = context.getConnection(searchShardTarget.getClusterAlias(), searchShardTarget.getNodeId());
                            counter.onResult(response);  
    private final SearchProgressListener progressListener;
                }
                        try {
        );
    private final AggregatedDfs dfs;
        this.context = context;
 * SPDX-License-Identifier: Apache-2.0
 * KIND, either express or implied.  See the License for the
            );
            queryResult,  
                searchShardTarget.getOriginalIndices(),  
/*  
                            context.getLogger()  
                    }
