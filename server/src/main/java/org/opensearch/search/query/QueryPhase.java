 * this work for additional information regarding copyright
                });
            }
                }
                searchContext.getProfilers(),
                    searchContext,
        }
            ProfileShardResult shardResults = SearchProfileShardResults.buildShardResults(
    }
import org.opensearch.common.annotation.PublicApi;
                    final ScoreDoc after = scrollContext.lastEmittedDoc;
                hasFilterCollector = true;
                    new DocValueFormat[0]
        final Collector queryCollector;
            }
            );
        aggregationProcessor.preProcess(searchContext);
        QuerySearchResult queryResult = searchContext.queryResult();
            boolean hasTimeout
            Sort indexSort = ctx.reader().getMetaData().sort();
            final Runnable timeoutRunnable;
                // add terminate_after before the filter collectors
    public static final QueryPhaseSearcher DEFAULT_QUERY_PHASE_SEARCHER = new DefaultQueryPhaseSearcher();
            /* As long as startTime is non cached time, using cached time here might only produce false negative timeouts within the time
import java.util.concurrent.ExecutorService;
            searchContext.bucketCollectorProcessor().processPostCollection(queryCollector);
                .topDocs(
                    queryCollectorContextSpec.postProcess(result);
        if (queryCollectorContext instanceof RescoringQueryCollectorContext rescoringContext) {
import org.apache.lucene.search.FieldDoc;
            ).map(queryCollectorContextSpec -> new QueryCollectorContext(queryCollectorContextSpec.getContextName()) {
    /**
package org.opensearch.search.query;
 * GitHub history for details.
    public static class DefaultQueryPhaseSearcher implements QueryPhaseSearcher {
        @Override
import org.apache.lucene.search.BooleanQuery;
            }
            context.preProcess(true);
        }
    /**
            });
        LinkedList<QueryCollectorContext> collectors,
    public static final boolean SYS_PROP_REWRITE_SORT = Booleans.parseBoolean(System.getProperty("opensearch.search.rewrite_sort", "true"));
        }
            rescoreProcessor.process(searchContext);
 *
            return;
            aggregationProcessor = new DefaultAggregationProcessor();
        ) throws IOException {
        } catch (EarlyTerminatingCollector.EarlyTerminationException e) {
            // create the top docs collector last when the other collectors are known
import org.opensearch.search.internal.ScrollContext;
        private final AggregationProcessor aggregationProcessor;
                    if (canEarlyTerminate(reader, searchContext.sort())) {
            final List<CollectorManager<? extends Collector, ReduceableSearchResult>> managersExceptGlobalAgg = searchContext
            SearchContext searchContext,
                    }
                .filter(entry -> !(entry.getKey().equals(GlobalAggCollectorManager.class)))
        }
     * Create runnable which throws {@link TimeExceededException} when the runnable is called after timeout + runnable creation time
import org.apache.lucene.search.Query;
                void postProcess(QuerySearchResult result) throws IOException {
            throw new QueryPhaseExecutionException(searchContext.shardTarget(), "Failed to execute main query", e);
            LinkedList<QueryCollectorContext> collectors,
            if (managersExceptGlobalAgg.isEmpty() == false) {
            LinkedList<QueryCollectorContext> collectors,
        if (searchContext.hasOnlySuggest()) {
                Collector create(Collector in) throws IOException {
        /**
                context.searcher().removeQueryCancellation(cancellation);
import org.opensearch.lucene.queries.SearchAfterSortedDocQuery;
                searchContext.request()
                @Override
            }
        try {
                    query,
                if (task != null && task.isCancelled()) {
        boolean timeoutSet
    public static class TimeExceededException extends RuntimeException {
            if (scrollContext != null) {
            * cache life span which is acceptable */
    /**
        * Using cached time for startTime will fail and produce false positive timeouts when maxTime = (startTime + timeout) falls in
                // otherwise aggregation phase might get cancelled.
                }
        this.rescoreProcessor = new RescoreProcessor();
 * You may obtain a copy of the License at
            }
        QueryCollectorContext queryCollectorContext,
                CollectorManager<?, ReduceableSearchResult> createManager(CollectorManager<?, ReduceableSearchResult> in)
    }
        suggestProcessor.process(searchContext);
        // request, preProcess is called on the DFS phase phase, this is why we pre-process them
        protected boolean searchWithCollector(
            queryCollector = profileCollector;
     * wire everything (mapperService, etc.)
                if (scrollContext.totalHits == null) {
     * @return the created runnable
     *
        return false;
                searcher.addQueryCancellation(() -> {
        if (sortAndFormats == null || sortAndFormats.sort == null) {
                hasFilterCollector = true;
 * Licensed to Elasticsearch under one or more contributor
public class QueryPhase {
            return rescoringContext.shouldRescore();
import org.apache.lucene.search.ScoreDoc;
                boolean shouldRescore = queryPhaseSearcher.searchWith(
     * @opensearch.internal
        if (searchContext.terminateAfter() != SearchContext.DEFAULT_TERMINATE_AFTER && queryResult.terminatedEarly() == null) {
    public QueryPhase(QueryPhaseSearcher queryPhaseSearcher) {
     * @param searchContext to extract timeout from and to get relative time from
            searchContext.getProfilers().getCurrentQueryProfiler().setCollector(profileCollector);
import java.util.stream.Collectors;
     */
                if (timeoutRunnable != null) {
            ContextIndexSearcher searcher,
import org.apache.lucene.search.BooleanClause;
                    // there is not much that we can optimize here since we want to collect all
                        }
            if (searchContext.minimumScore() != null) {
                        // skip to the desired doc
            LinkedList<QueryCollectorContext> collectors,
            searchContext.queryResult()
@PublicApi(since = "1.0.0")
        queryResult.searchTimedOut(false);
                // it will only be applied to top hits
            if (timeoutSet) {
 *    http://www.apache.org/licenses/LICENSE-2.0
                return false;
        } else {
                return shouldRescore;
            if (cancellation != null) {
        final AggregationProcessor aggregationProcessor = queryPhaseSearcher.aggregationProcessor(searchContext);
import org.opensearch.search.internal.ContextIndexSearcher;
     * In a package-private method so that it can be tested without having to
/*
    static Runnable createQueryTimeoutChecker(final SearchContext searchContext) {
        final Sort sort = sortAndFormats.sort;
            }
            final ScrollContext scrollContext = searchContext.scrollContext();
            if (searchContext.parsedPostFilter() != null) {
    }
    /**
 * The OpenSearch Contributors require contributions made to
        }
        } finally {
            }
        boolean hasFilterCollector,
 * ownership. Elasticsearch licenses this file to you under
                query,
import org.opensearch.action.search.SearchShardTask;
            InternalProfileCollector profileCollector = QueryCollectorContext.createQueryCollectorWithProfiler(collectors);
     * Returns whether collection within the provided <code>reader</code> can be early-terminated if it sorts
import org.opensearch.common.Booleans;
            Query query = searchContext.query();
        public boolean searchWith(
                // it will only be applied on documents accepted by these filter collectors
                        throw new TaskCancelledException("cancelled task with reason: " + task.getReasonCancelled());
                    queryResult.nodeQueueSize(rExecutor.getCurrentQueueSize());
 */
                timeoutRunnable = null;
        }
 *
        private static final long serialVersionUID = 1L;
                @Override
                collectors.add(createMultiCollectorContext(managersExceptGlobalAgg));
                    // first round
     * @opensearch.internal
        /* for startTime, relative non-cached precise time must be used to prevent false positive timeouts.
import org.opensearch.search.rescore.RescoreProcessor;
    public QueryPhase() {
            searchContext.queryResult().profileResults(shardResults);
                .queryCollectorManagers()
                    throw new TaskCancelledException("cancelled task with reason: " + task.getReasonCancelled());
        }
            boolean hasFilterCollector,
        collectors.addFirst(Objects.requireNonNull(queryCollectorContext));
        // Pre-process aggregations as late as possible. In the case of a DFS_Q_T_F
    }
import org.apache.lucene.index.IndexReader;
            final LinkedList<QueryCollectorContext> collectors = new LinkedList<>();
     **/
/**
            return false;
                }
        if (searchContext.getProfilers() != null) {
                hasTimeout
 */
            try {
        // add passed collector, the first collector context in the chain
        if (rescore) { // only if we do a regular search
            QueryCollectorContext queryCollectorContext,
            } else {
        boolean rescore = executeInternal(searchContext, queryPhaseSearcher);
 * KIND, either express or implied.  See the License for the
            queryResult.size(searchContext.size());
            cancellation = null;
        protected boolean searchWithCollector(
            return searchWithCollector(searchContext, searcher, query, collectors, queryCollectorContext, hasFilterCollector, hasTimeout);
        }
                SearchShardTask task = context.getTask();
import static org.opensearch.search.query.QueryCollectorContext.createMultiCollectorContext;
            boolean hasTimeout
                // add post filters before aggregations
            Query query,
        for (LeafReaderContext ctx : reader.leaves()) {
    // making public for testing
                @Override
        ) throws IOException {
    public QueryPhaseSearcher getQueryPhaseSearcher() {
        return queryPhaseSearcher;
                    return queryCollectorContextSpec.create(in);
                && searchContext.timeout().equals(SearchService.NO_TIMEOUT) == false;
import org.opensearch.search.aggregations.DefaultAggregationProcessor;
                searchContext,
        // here to make sure it happens during the QUERY phase
            queryResult.terminatedEarly(true);
        public AggregationProcessor aggregationProcessor(SearchContext searchContext) {
        }
        final long startTime = searchContext.getRelativeTimeInMillis(false);
                    return queryCollectorContextSpec.createManager(in);
    private static boolean canEarlyTerminate(IndexReader reader, SortAndFormats sortAndFormats) {
        if (searchContext.isSearchTimedOut()) {
            if (indexSort == null || Lucene.canEarlyTerminate(sort, indexSort) == false) {
 * @opensearch.api
     * wire everything (mapperService, etc.)
import org.opensearch.search.profile.ProfileShardResult;
                    throws IOException {
        @Override
import org.opensearch.threadpool.ThreadPool;
            suggestProcessor.process(searchContext);
                throw new QueryPhaseExecutionException(searchContext.shardTarget(), "Time exceeded");
 *
                // this collector can filter documents during the collection
                return queryCollectorContextOpt.get();
import org.apache.lucene.search.TotalHits;
        * next time cache slot(s) AND time caching lifespan > passed timeout */
 */
                // this collector can filter documents during the collection
import java.io.IOException;
        QuerySearchResult queryResult = searchContext.queryResult();
        this.queryPhaseSearcher = Objects.requireNonNull(queryPhaseSearcher, "QueryPhaseSearcher is required");
import org.opensearch.search.SearchService;
                            query = new BooleanQuery.Builder().add(query, BooleanClause.Occur.MUST)
 * SPDX-License-Identifier: Apache-2.0
            // plug in additional collectors, like aggregations except global aggregations
                // Search phase has finished, no longer need to check for timeout
        final Runnable cancellation;
        }
}
        return () -> {
                .stream()
     * Default {@link QueryPhaseSearcher} implementation which delegates to the {@link QueryPhase}.
    // TODO: remove this property
            assert timeoutSet : "TimeExceededException thrown even though timeout wasn't set";
            }
import static org.opensearch.search.query.QueryCollectorContext.createFilteredCollectorContext;
import org.apache.lucene.search.TopDocs;
                .map(Map.Entry::getValue)
import org.opensearch.search.sort.SortAndFormats;
import java.util.Objects;
        SearchContext searchContext,
            boolean hasFilterCollector,
    static boolean executeInternal(SearchContext searchContext, QueryPhaseSearcher queryPhaseSearcher) throws QueryPhaseExecutionException {
        }
 * license agreements. See the NOTICE file distributed with
import org.opensearch.common.lucene.search.TopDocsAndMaxScore;
            boolean hasFilterCollector,
            });
        return true;
            if (searchContext.lowLevelCancellation()) {
 * the Apache License, Version 2.0 (the "License"); you may
                        // now this gets interesting: since the search sort is a prefix of the index sort, we can directly
                    SearchShardTask task = searchContext.getTask();
            cancellation = context.searcher().addQueryCancellation(() -> {
            assert query == searcher.rewrite(query); // already rewritten
                    hasFilterCollector,
 * Modifications Copyright OpenSearch Contributors. See
                return createTopDocsCollectorContext(searchContext, hasFilterCollector);
    /**
    /**
        ContextIndexSearcher searcher,
                    timeoutSet
            LOGGER.trace("{}", new SearchContextSourcePrinter(searchContext));
            searcher.search(query, queryCollector);
                .collect(Collectors.toList());
            queryCollector = QueryCollectorContext.createQueryCollector(collectors);
            }
import org.apache.logging.log4j.LogManager;
import java.util.Map;
    private static final Logger LOGGER = LogManager.getLogger(QueryPhase.class);
                    if (task != null && task.isCancelled()) {
            if (searchContext.terminateAfter() != SearchContext.DEFAULT_TERMINATE_AFTER) {
                searchContext,
            }
                    searcher,
     * with <code>sortAndFormats</code>.
        return executeInternal(searchContext, QueryPhase.DEFAULT_QUERY_PHASE_SEARCHER);
                collectors,
import org.opensearch.search.profile.query.InternalProfileCollector;
        }
                // this collector can filter documents during the collection
 * software distributed under the License is distributed on an
    }
            QueryCollectorContext queryCollectorContext = getQueryCollectorContext(searchContext, query, hasFilterCollector);
                    // documents in order to get the total number of hits
import org.opensearch.search.suggest.SuggestProcessor;
        }
        }
import org.apache.lucene.index.LeafReaderContext;
        }
                throw new TimeExceededException();
import static org.opensearch.search.query.TopDocsCollectorContext.createTopDocsCollectorContext;
            } else {
import org.opensearch.common.lucene.Lucene;
    }
    private static boolean searchWithCollector(
            if (queryCollectorContextOpt.isPresent()) {
        }
        }
            } finally {
                                .build();
            // whether the chain contains a collector that filters documents
                .entrySet()
 * Unless required by applicable law or agreed to in writing,
        final IndexReader reader = searcher.getIndexReader();
        for (QueryCollectorContext ctx : collectors) {
                                .add(new SearchAfterSortedDocQuery(searchContext.sort().sort, (FieldDoc) after), BooleanClause.Occur.FILTER)
            }
                    new TopDocsAndMaxScore(new TopDocs(new TotalHits(0, TotalHits.Relation.EQUAL_TO), Lucene.EMPTY_SCORE_DOCS), Float.NaN),
     */
        this(DEFAULT_QUERY_PHASE_SEARCHER);
            Query query,
                }
    }
            }
 * (document ids and score or sort criteria) so that matches can be reduced on the coordinating node
        protected DefaultQueryPhaseSearcher() {
        final long maxTime = startTime + searchContext.timeout().millis();
    }
            queryResult.from(searchContext.from());
 * under the License.
        Query query,
    private final QueryPhaseSearcher queryPhaseSearcher;
     * In a package-private method so that it can be tested without having to
 * specific language governing permissions and limitations
            return QueryPhase.searchWithCollector(
    }
            final long time = searchContext.getRelativeTimeInMillis();
 * compatible open source license.
            queryResult.searchTimedOut(true);
 * Query phase of a search request, used to run the query and get back from each shard information about the matching documents
            // EarlyTerminationException is not caught in ContextIndexSearcher to allow force termination of collection. Postcollection
import org.opensearch.search.aggregations.GlobalAggCollectorManager;
            );
            SearchContext searchContext,
        aggregationProcessor.postProcess(searchContext);
     */
     * The exception being raised when search timeout is reached.
                timeoutRunnable = searcher.addQueryCancellation(createQueryTimeoutChecker(searchContext));
     * exceeds currentTime
                );
    }
import org.apache.logging.log4j.Logger;
        final ContextIndexSearcher searcher = searchContext.searcher();
                new QueryCollectorArguments.Builder().hasFilterCollector(hasFilterCollector).build()
            queryResult.terminatedEarly(false);
import org.opensearch.search.aggregations.AggregationProcessor;
                collectors.add(createEarlyTerminationCollectorContext(searchContext.terminateAfter()));
/*
        if (LOGGER.isTraceEnabled()) {
import java.util.List;
        try {
            if (time > maxTime) {
        private QueryCollectorContext getQueryCollectorContext(SearchContext searchContext, Query query, boolean hasFilterCollector)
                queryCollectorContext,
import org.opensearch.search.SearchContextSourcePrinter;
         * Please use {@link QueryPhase#DEFAULT_QUERY_PHASE_SEARCHER}
     *
        if (searchContext.getProfilers() != null) {
        this.suggestProcessor = new SuggestProcessor();
            return searchWithCollector(searchContext, searcher, query, collectors, hasFilterCollector, hasTimeout);
            ContextIndexSearcher searcher,
            // still needs to be processed for Aggregations when early termination takes place.
            return aggregationProcessor;
            boolean hasFilterCollector = false;
     * @return whether the rescoring phase should be executed
            ctx.postProcess(queryResult);
        }
            boolean timeoutSet = scrollContext == null
                        if (after != null) {
import org.apache.lucene.search.Sort;
                } else {
     */
import org.opensearch.search.DocValueFormat;
                // apply the minimum score after multi collector so we filter aggs as well
    public void execute(SearchContext searchContext) throws QueryPhaseExecutionException {
import org.opensearch.core.tasks.TaskCancelledException;
                );
                ExecutorService executor = searchContext.indexShard().getThreadPool().executor(ThreadPool.Names.SEARCH);
                    collectors,
                collectors.add(createFilteredCollectorContext(searcher, searchContext.parsedPostFilter().query()));
     */
                    queryResult.serviceTimeEWMA((long) rExecutor.getTaskExecutionEWMA());
import java.util.LinkedList;
                collectors.add(createMinScoreCollectorContext(searchContext.minimumScore()));
    private final SuggestProcessor suggestProcessor;
                if (executor instanceof EWMATrackingThreadPoolExecutor rExecutor) {
        try {
         */
    public void preProcess(SearchContext context) {
import org.opensearch.search.internal.SearchContext;
        } else {
import java.util.Optional;
        } catch (Exception e) {
 *
                }
            if (searchContext.request().allowPartialSearchResults() == false) {
            Query query,
import static org.opensearch.search.query.QueryCollectorContext.createEarlyTerminationCollectorContext;
                hasFilterCollector,
            }
        if (context.lowLevelCancellation()) {
        }
                searcher,
            final Optional<QueryCollectorContext> queryCollectorContextOpt = QueryCollectorContextSpecRegistry.getQueryCollectorContextSpec(
    ) throws IOException {
 * not use this file except in compliance with the License.
 * this file be licensed under the Apache-2.0 license or a
     * @return whether the rescoring phase should be executed
            SearchContext searchContext,
    }
        }
                }
import org.apache.lucene.search.CollectorManager;
                query,
                    }
            throws IOException {
import org.opensearch.common.util.concurrent.EWMATrackingThreadPoolExecutor;
                hasFilterCollector = true;
        ) throws IOException {
 */
                    searcher.removeQueryCancellation(timeoutRunnable);
                    assert scrollContext.lastEmittedDoc == null;
/*
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            boolean hasTimeout
    }
        }
    private final RescoreProcessor rescoreProcessor;
        };
    static boolean executeInternal(SearchContext searchContext) throws QueryPhaseExecutionException {
                && searchContext.timeout() != null
import org.apache.lucene.search.Collector;
import static org.opensearch.search.query.QueryCollectorContext.createMinScoreCollectorContext;
                }
            ContextIndexSearcher searcher,
import org.opensearch.search.profile.SearchProfileShardResults;
