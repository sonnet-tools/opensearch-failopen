                collectors.add(createMinScoreCollectorContext(searchContext.minimumScore()));
            searchContext.queryResult().profileResults(shardResults);  
            });  
                });
        this.rescoreProcessor = new RescoreProcessor();  
            SearchContext searchContext,
            SearchContext searchContext,  
            final long time = searchContext.getRelativeTimeInMillis();
    private static final Logger LOGGER = LogManager.getLogger(QueryPhase.class);  
            Query query,  
    /**
import org.opensearch.common.util.concurrent.EWMATrackingThreadPoolExecutor;
/*  
        }
 */
import org.opensearch.search.aggregations.DefaultAggregationProcessor;  
        protected DefaultQueryPhaseSearcher() {
            LinkedList<QueryCollectorContext> collectors,
    }
        SearchContext searchContext,  
        QuerySearchResult queryResult = searchContext.queryResult();
                hasFilterCollector = true;  
import org.opensearch.common.lucene.search.TopDocsAndMaxScore;
                ExecutorService executor = searchContext.indexShard().getThreadPool().executor(ThreadPool.Names.SEARCH);  
                    new TopDocsAndMaxScore(new TopDocs(new TotalHits(0, TotalHits.Relation.EQUAL_TO), Lucene.EMPTY_SCORE_DOCS), Float.NaN),
                query,
        queryResult.searchTimedOut(false);  
        /* for startTime, relative non-cached precise time must be used to prevent false positive timeouts.
                && searchContext.timeout() != null
 *  
        }
            return searchWithCollector(searchContext, searcher, query, collectors, queryCollectorContext, hasFilterCollector, hasTimeout);
                    }
     */  
        /**
            * cache life span which is acceptable */  
 * software distributed under the License is distributed on an
        };
                .queryCollectorManagers()
import org.apache.lucene.search.Sort;  
        protected boolean searchWithCollector(
 */  
        protected boolean searchWithCollector(
 * under the License.  
 *
            if (searchContext.parsedPostFilter() != null) {  
        for (QueryCollectorContext ctx : collectors) {
     */
            boolean timeoutSet = scrollContext == null  
        * next time cache slot(s) AND time caching lifespan > passed timeout */
/*  
            queryCollector = QueryCollectorContext.createQueryCollector(collectors);
            boolean hasFilterCollector,
     * @opensearch.internal
            queryResult.from(searchContext.from());
/**
package org.opensearch.search.query;
        } finally {
            final Optional<QueryCollectorContext> queryCollectorContextOpt = QueryCollectorContextSpecRegistry.getQueryCollectorContextSpec(
    private static boolean canEarlyTerminate(IndexReader reader, SortAndFormats sortAndFormats) {  
    /**  
            );
        @Override
/*
        for (LeafReaderContext ctx : reader.leaves()) {
import org.opensearch.common.Booleans;
        }  
    }
        boolean timeoutSet  
import org.opensearch.common.annotation.PublicApi;
import org.opensearch.search.profile.ProfileShardResult;
                queryCollectorContext,
            return searchWithCollector(searchContext, searcher, query, collectors, hasFilterCollector, hasTimeout);
        if (searchContext.getProfilers() != null) {
                CollectorManager<?, ReduceableSearchResult> createManager(CollectorManager<?, ReduceableSearchResult> in)  
                if (timeoutRunnable != null) {
            }
import java.util.List;  
import org.opensearch.lucene.queries.SearchAfterSortedDocQuery;
    public QueryPhase(QueryPhaseSearcher queryPhaseSearcher) {  
import org.apache.lucene.search.Query;
    static Runnable createQueryTimeoutChecker(final SearchContext searchContext) {
    // TODO: remove this property
            aggregationProcessor = new DefaultAggregationProcessor();
     */  
                    throws IOException {
import java.util.concurrent.ExecutorService;
                    searcher,
        suggestProcessor.process(searchContext);
    public static final boolean SYS_PROP_REWRITE_SORT = Booleans.parseBoolean(System.getProperty("opensearch.search.rewrite_sort", "true"));
import static org.opensearch.search.query.QueryCollectorContext.createMinScoreCollectorContext;  
                void postProcess(QuerySearchResult result) throws IOException {  
            }  
        }
        try {  
                            query = new BooleanQuery.Builder().add(query, BooleanClause.Occur.MUST)  
                searchContext.request()
            if (searchContext.terminateAfter() != SearchContext.DEFAULT_TERMINATE_AFTER) {
                // it will only be applied to top hits
                query,  
            boolean hasFilterCollector = false;
            queryResult.size(searchContext.size());  
        }
            if (searchContext.minimumScore() != null) {
                );
}
                                .add(new SearchAfterSortedDocQuery(searchContext.sort().sort, (FieldDoc) after), BooleanClause.Occur.FILTER)
                        }  
            // whether the chain contains a collector that filters documents  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                collectors.add(createFilteredCollectorContext(searcher, searchContext.parsedPostFilter().query()));  
            boolean hasFilterCollector,
                    return queryCollectorContextSpec.createManager(in);
        return true;
    }  
            boolean hasFilterCollector,  
        return executeInternal(searchContext, QueryPhase.DEFAULT_QUERY_PHASE_SEARCHER);  
    }
 * (document ids and score or sort criteria) so that matches can be reduced on the coordinating node  
        final ContextIndexSearcher searcher = searchContext.searcher();  
     *
                hasFilterCollector,
            // EarlyTerminationException is not caught in ContextIndexSearcher to allow force termination of collection. Postcollection
            boolean hasTimeout
        } catch (Exception e) {
import org.apache.lucene.index.LeafReaderContext;
        }  
            LOGGER.trace("{}", new SearchContextSourcePrinter(searchContext));  
                return createTopDocsCollectorContext(searchContext, hasFilterCollector);
        @Override
    /**
            InternalProfileCollector profileCollector = QueryCollectorContext.createQueryCollectorWithProfiler(collectors);
                @Override  
 */  
        Query query,
                // this collector can filter documents during the collection
    private final SuggestProcessor suggestProcessor;
        ) throws IOException {
    // making public for testing
            } else {  
        }
                @Override
            if (managersExceptGlobalAgg.isEmpty() == false) {
        } catch (EarlyTerminatingCollector.EarlyTerminationException e) {
            final LinkedList<QueryCollectorContext> collectors = new LinkedList<>();
                    queryResult.serviceTimeEWMA((long) rExecutor.getTaskExecutionEWMA());  
 * Unless required by applicable law or agreed to in writing,
    public static class TimeExceededException extends RuntimeException {
 *
import org.apache.lucene.search.Collector;
import org.opensearch.search.rescore.RescoreProcessor;
                timeoutRunnable = null;
            LinkedList<QueryCollectorContext> collectors,  
            queryResult.searchTimedOut(true);  
        final long maxTime = startTime + searchContext.timeout().millis();  
import java.util.stream.Collectors;
        QueryCollectorContext queryCollectorContext,
        final Sort sort = sortAndFormats.sort;
            }
                    searcher.removeQueryCancellation(timeoutRunnable);
        }
                timeoutRunnable = searcher.addQueryCancellation(createQueryTimeoutChecker(searchContext));  
    static boolean executeInternal(SearchContext searchContext) throws QueryPhaseExecutionException {
                    }
                Collector create(Collector in) throws IOException {
                .entrySet()
        }
public class QueryPhase {
        boolean hasFilterCollector,
            QueryCollectorContext queryCollectorContext,
                && searchContext.timeout().equals(SearchService.NO_TIMEOUT) == false;
import java.util.LinkedList;
 * license agreements. See the NOTICE file distributed with
        // add passed collector, the first collector context in the chain
                return false;
import org.apache.lucene.search.TopDocs;
 * the Apache License, Version 2.0 (the "License"); you may
     * Returns whether collection within the provided <code>reader</code> can be early-terminated if it sorts  
 * You may obtain a copy of the License at  
            cancellation = null;
     */
            searchContext.getProfilers().getCurrentQueryProfiler().setCollector(profileCollector);
                    // documents in order to get the total number of hits
                // apply the minimum score after multi collector so we filter aggs as well  
                if (executor instanceof EWMATrackingThreadPoolExecutor rExecutor) {
                if (scrollContext.totalHits == null) {  
            } else {
            } finally {
                    if (canEarlyTerminate(reader, searchContext.sort())) {
import org.apache.logging.log4j.Logger;
            if (time > maxTime) {
            Query query,
     **/
                    new DocValueFormat[0]  
                context.searcher().removeQueryCancellation(cancellation);
        if (LOGGER.isTraceEnabled()) {
            boolean hasTimeout  
            if (timeoutSet) {
        private static final long serialVersionUID = 1L;
    }  
                    queryResult.nodeQueueSize(rExecutor.getCurrentQueueSize());
            searcher.search(query, queryCollector);  
        if (searchContext.isSearchTimedOut()) {
        return () -> {
                searcher.addQueryCancellation(() -> {  
                    collectors,
    public static final QueryPhaseSearcher DEFAULT_QUERY_PHASE_SEARCHER = new DefaultQueryPhaseSearcher();  
                    // first round
            assert timeoutSet : "TimeExceededException thrown even though timeout wasn't set";
 *    http://www.apache.org/licenses/LICENSE-2.0
                    assert scrollContext.lastEmittedDoc == null;
    static boolean executeInternal(SearchContext searchContext, QueryPhaseSearcher queryPhaseSearcher) throws QueryPhaseExecutionException {
                    hasFilterCollector,
        try {
         * Please use {@link QueryPhase#DEFAULT_QUERY_PHASE_SEARCHER}
        final long startTime = searchContext.getRelativeTimeInMillis(false);
    /**
                .topDocs(
import static org.opensearch.search.query.QueryCollectorContext.createMultiCollectorContext;
        if (queryCollectorContext instanceof RescoringQueryCollectorContext rescoringContext) {
                    searchContext,
    }  
        this.queryPhaseSearcher = Objects.requireNonNull(queryPhaseSearcher, "QueryPhaseSearcher is required");
            if (scrollContext != null) {
        }  
            return rescoringContext.shouldRescore();  
                }
        // here to make sure it happens during the QUERY phase  
import org.opensearch.search.sort.SortAndFormats;  
 * SPDX-License-Identifier: Apache-2.0
import static org.opensearch.search.query.QueryCollectorContext.createFilteredCollectorContext;
                        // skip to the desired doc
        }
import org.opensearch.search.SearchContextSourcePrinter;  
                    queryCollectorContextSpec.postProcess(result);
    private final QueryPhaseSearcher queryPhaseSearcher;
            queryResult.terminatedEarly(false);  
import org.opensearch.action.search.SearchShardTask;  
 * ownership. Elasticsearch licenses this file to you under  
                // this collector can filter documents during the collection  
            final Runnable timeoutRunnable;
                // it will only be applied on documents accepted by these filter collectors
            queryCollector = profileCollector;  
import org.opensearch.search.internal.ContextIndexSearcher;
            ProfileShardResult shardResults = SearchProfileShardResults.buildShardResults(
        * Using cached time for startTime will fail and produce false positive timeouts when maxTime = (startTime + timeout) falls in  
            LinkedList<QueryCollectorContext> collectors,
                // otherwise aggregation phase might get cancelled.  
                // add terminate_after before the filter collectors  
                searchContext,
 * GitHub history for details.
     * @param searchContext to extract timeout from and to get relative time from
            // create the top docs collector last when the other collectors are known  
        final Runnable cancellation;
                hasTimeout  
import org.opensearch.search.profile.SearchProfileShardResults;  
import org.apache.lucene.search.BooleanQuery;  
                        // now this gets interesting: since the search sort is a prefix of the index sort, we can directly  
        }
            }  
import org.opensearch.search.aggregations.GlobalAggCollectorManager;
            );
    }
                .collect(Collectors.toList());  
                if (task != null && task.isCancelled()) {
                }  
        aggregationProcessor.postProcess(searchContext);
     * In a package-private method so that it can be tested without having to
            QueryCollectorContext queryCollectorContext = getQueryCollectorContext(searchContext, query, hasFilterCollector);  
            if (indexSort == null || Lucene.canEarlyTerminate(sort, indexSort) == false) {
    public static class DefaultQueryPhaseSearcher implements QueryPhaseSearcher {
            }  
                throw new TimeExceededException();  
        if (searchContext.getProfilers() != null) {  
                    final ScoreDoc after = scrollContext.lastEmittedDoc;
     * In a package-private method so that it can be tested without having to
        }  
                collectors.add(createMultiCollectorContext(managersExceptGlobalAgg));
                }
     * @return the created runnable
                // Search phase has finished, no longer need to check for timeout
        }  
            /* As long as startTime is non cached time, using cached time here might only produce false negative timeouts within the time
            ContextIndexSearcher searcher,  
 * @opensearch.api
import org.apache.lucene.search.ScoreDoc;
        return queryPhaseSearcher;  
                }
            context.preProcess(true);
import org.apache.lucene.index.IndexReader;  
            // still needs to be processed for Aggregations when early termination takes place.  
         */  
                new QueryCollectorArguments.Builder().hasFilterCollector(hasFilterCollector).build()
        }
            searchContext.queryResult()  
import org.apache.logging.log4j.LogManager;
            }
        ) throws IOException {
        } else {  
            SearchContext searchContext,
                .filter(entry -> !(entry.getKey().equals(GlobalAggCollectorManager.class)))
            }  
            final List<CollectorManager<? extends Collector, ReduceableSearchResult>> managersExceptGlobalAgg = searchContext  
        if (rescore) { // only if we do a regular search
            ContextIndexSearcher searcher,
        } else {
                searchContext.getProfilers(),  
        }  
 * The OpenSearch Contributors require contributions made to  
    public QueryPhaseSearcher getQueryPhaseSearcher() {
 * Licensed to Elasticsearch under one or more contributor  
    /**
            Sort indexSort = ctx.reader().getMetaData().sort();  
        public boolean searchWith(  
                    throw new TaskCancelledException("cancelled task with reason: " + task.getReasonCancelled());  
    }  
        private QueryCollectorContext getQueryCollectorContext(SearchContext searchContext, Query query, boolean hasFilterCollector)
            }
     * @opensearch.internal
                    timeoutSet  
        ) throws IOException {
            cancellation = context.searcher().addQueryCancellation(() -> {  
 * not use this file except in compliance with the License.
            ctx.postProcess(queryResult);  
        if (sortAndFormats == null || sortAndFormats.sort == null) {
        LinkedList<QueryCollectorContext> collectors,  
                }  
            if (queryCollectorContextOpt.isPresent()) {
        if (searchContext.terminateAfter() != SearchContext.DEFAULT_TERMINATE_AFTER && queryResult.terminatedEarly() == null) {
            searchContext.bucketCollectorProcessor().processPostCollection(queryCollector);
import org.opensearch.search.aggregations.AggregationProcessor;
                collectors.add(createEarlyTerminationCollectorContext(searchContext.terminateAfter()));
    }
        collectors.addFirst(Objects.requireNonNull(queryCollectorContext));  
 * this file be licensed under the Apache-2.0 license or a
            try {
import org.apache.lucene.search.CollectorManager;
        return false;
import org.apache.lucene.search.TotalHits;
@PublicApi(since = "1.0.0")
                                .build();
        // Pre-process aggregations as late as possible. In the case of a DFS_Q_T_F
        }  
                hasFilterCollector = true;
        final Collector queryCollector;
            if (searchContext.request().allowPartialSearchResults() == false) {  
            }
     * wire everything (mapperService, etc.)
 * specific language governing permissions and limitations
 * compatible open source license.
            assert query == searcher.rewrite(query); // already rewritten
import org.opensearch.search.suggest.SuggestProcessor;
        }  
            ).map(queryCollectorContextSpec -> new QueryCollectorContext(queryCollectorContextSpec.getContextName()) {
                return shouldRescore;  
    private final RescoreProcessor rescoreProcessor;  
                // add post filters before aggregations
                collectors,  
import static org.opensearch.search.query.TopDocsCollectorContext.createTopDocsCollectorContext;
     * @return whether the rescoring phase should be executed  
            Query query = searchContext.query();
    public QueryPhase() {
                hasFilterCollector = true;
import java.util.Objects;
import org.opensearch.search.DocValueFormat;
        boolean rescore = executeInternal(searchContext, queryPhaseSearcher);
            queryResult.terminatedEarly(true);
 *
 */  
        // request, preProcess is called on the DFS phase phase, this is why we pre-process them
                @Override
                    if (task != null && task.isCancelled()) {
                    query,  
import org.opensearch.search.profile.query.InternalProfileCollector;
            return aggregationProcessor;
            boolean hasTimeout  
            return QueryPhase.searchWithCollector(
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.search.SearchService;
 * KIND, either express or implied.  See the License for the
import org.apache.lucene.search.BooleanClause;
    private static boolean searchWithCollector(
        }
                return queryCollectorContextOpt.get();
        this(DEFAULT_QUERY_PHASE_SEARCHER);  
    }  
     * with <code>sortAndFormats</code>.
                searcher,
                .stream()  
     * The exception being raised when search timeout is reached.  
        if (context.lowLevelCancellation()) {
import java.io.IOException;
    /**  
            throws IOException {
     * Create runnable which throws {@link TimeExceededException} when the runnable is called after timeout + runnable creation time
        final AggregationProcessor aggregationProcessor = queryPhaseSearcher.aggregationProcessor(searchContext);  
                        throw new TaskCancelledException("cancelled task with reason: " + task.getReasonCancelled());  
            return false;
     * @return whether the rescoring phase should be executed  
                .map(Map.Entry::getValue)
            if (searchContext.lowLevelCancellation()) {
                    // there is not much that we can optimize here since we want to collect all  
import org.opensearch.search.internal.ScrollContext;  
    public void preProcess(SearchContext context) {  
    }
     *
            throw new QueryPhaseExecutionException(searchContext.shardTarget(), "Failed to execute main query", e);  
                // this collector can filter documents during the collection
import org.opensearch.threadpool.ThreadPool;
        }  
            }  
            ContextIndexSearcher searcher,
                    return queryCollectorContextSpec.create(in);
            final ScrollContext scrollContext = searchContext.scrollContext();
        }
                SearchShardTask task = context.getTask();
        try {
        aggregationProcessor.preProcess(searchContext);
        ContextIndexSearcher searcher,
                } else {  
    public void execute(SearchContext searchContext) throws QueryPhaseExecutionException {  
                }  
                }
            // plug in additional collectors, like aggregations except global aggregations
                searchContext,  
import org.opensearch.common.lucene.Lucene;  
import java.util.Optional;  
 * Query phase of a search request, used to run the query and get back from each shard information about the matching documents
    }
            }
        private final AggregationProcessor aggregationProcessor;
                boolean shouldRescore = queryPhaseSearcher.searchWith(  
            });
import org.opensearch.search.internal.SearchContext;
            rescoreProcessor.process(searchContext);
            }
        final IndexReader reader = searcher.getIndexReader();
     * wire everything (mapperService, etc.)
        this.suggestProcessor = new SuggestProcessor();
     * Default {@link QueryPhaseSearcher} implementation which delegates to the {@link QueryPhase}.  
            Query query,
            suggestProcessor.process(searchContext);
import org.opensearch.core.tasks.TaskCancelledException;  
import static org.opensearch.search.query.QueryCollectorContext.createEarlyTerminationCollectorContext;
            if (cancellation != null) {  
                    SearchShardTask task = searchContext.getTask();
        public AggregationProcessor aggregationProcessor(SearchContext searchContext) {  
import org.apache.lucene.search.FieldDoc;  
     * exceeds currentTime  
     */  
                throw new QueryPhaseExecutionException(searchContext.shardTarget(), "Time exceeded");
                );
        QuerySearchResult queryResult = searchContext.queryResult();
 * this work for additional information regarding copyright
                        if (after != null) {
import java.util.Map;
    ) throws IOException {
        if (searchContext.hasOnlySuggest()) {
            return;
            }  
