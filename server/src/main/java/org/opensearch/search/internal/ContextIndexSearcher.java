        // (e.g. TimeLimitingKnnCollectorManager used by AbstractKnnVectorQuery) can enforce
import org.apache.lucene.index.Term;
                    };
            if (++seen % CHECK_CANCELLED_SCORER_INTERVAL == 0) {
            searchLeaf(ctx, 0, DocIdSetIterator.NO_MORE_DOCS, weight, collector);
            cancellable.checkCancelled();
    }
        int maxDocId,
     * DirectoryReader but also while collecting them and check for query cancellation or timeout.
                profiler.stopAndAddRewriteTime();
    @Override
            logger.debug("Slice count using lucene default [{}]", leafSlices.length);
        } else if (liveDocs instanceof CombinedBitSet combinedBitSet
            return new LeafSlice[0];
                            final BulkScorer in = weight.bulkScorer(context);
        if (totalHits != null) { // we have already precalculated totalHits for the whole index
        // instance in fielddata cache).
 *
                        public long cost() {
                            if (scorer != null) {
        MutableQueryTimeout cancellable,
    private AggregatedDfs aggregatedDfs;
import java.util.ArrayList;
                                bulkScorer = new CancellableBulkScorer(in, cancellable::checkCancelled);
        // Check if at all we need to call this leaf for collecting results.
            try {
                    this.searchContext.getQueryShardContext(),
 * license agreements. See the NOTICE file distributed with
        if (aggregatedDfs == null) {
        searchContext.indexShard().getSearchOperationListener().onPreSliceExecution(searchContext);
                checkCancelled.run();
        boolean wrapWithExitableDirectoryReader,
        QueryCache queryCache,
    /**
        this.searchContext = searchContext;
            approximateScoreQuery.setContext(searchContext);
        return termStatistics;
        // CollectionTerminatedException and TimeExceededException, but no other exception.
 * this file be licensed under the Apache-2.0 license or a
            }
                        maxDocId,
        // of memory.
            return action;
        final QuerySearchResult cloneResult = new QuerySearchResult(
                    searchLeaf(partitions[i].ctx, partitions[i].minDocId, partitions[i].maxDocId, weight, collector);
        }
                throw new IllegalArgumentException("Cancellation runnable already added");
            }
                        this.cancellable.isEnabled() ? cancellable::checkCancelled : () -> {}
        try {
            // reader order here.
 * KIND, either express or implied.  See the License for the
        try {
 * not use this file except in compliance with the License.
            return super.collectionStatistics(field);
            profiler.startRewriteTime();
    public void search(
                runnables.get(i).run();
        // the query timeout. Without this, searcher.getTimeout() returns null and KNN vector
            if (primarySortField != null) {
        return true;
import org.apache.lucene.search.similarities.Similarity;
                MinAndMax<?> minMax = FieldSortBuilder.getMinMaxOrNullForSegment(
 * under the License.
            } finally {
 * software distributed under the License is distributed on an
     * which is called while accessing documents in the DirectoryReader but also while collecting them.
        this.profiler = profiler;
     */
                        public BulkScorer bulkScorer() throws IOException {
import org.apache.lucene.search.Scorer;
 * compatible open source license.
            } catch (QueryPhase.TimeExceededException | TaskCancelledException e) {
                        private Scorer scorer;
import org.apache.lucene.search.QueryCache;
            Arrays.asList(new BitSetIterator(acceptDocs, acceptDocs.approximateCardinality()), scorer.iterator())
     * @param leaves all the segments
    }
    public Runnable addQueryCancellation(Runnable action) {
        int seen = 0;
import org.opensearch.search.SearchService;
        IndexReader reader,
            }
        // Set the timeout on the IndexSearcher so that Lucene-native timeout-aware components
        Executor executor,
        }
            // we are either executing the dfs phase or the search_type doesn't include the dfs phase.
            return;
                    // collection was terminated prematurely
    private static final int CHECK_CANCELLED_SCORER_INTERVAL = 1 << 11;
        DocValueFormat[] formats,
    @Override
        setQueryCache(queryCache);
                return null;
 * You may obtain a copy of the License at
            if (profiler != null) {
            mergedTopDocs = new TopFieldDocs(totalHits, mergedTopDocs.scoreDocs, mergedTopDocs.fields);
            setTimeout(cancellable);
        this.cancellable = cancellable;
                }
                ctx.ord,
    public void setProfiler(QueryProfiler profiler) {
 * SPDX-License-Identifier: Apache-2.0
        DocValueFormat[] formats,
    }
                    ctx,
                );
    ) throws IOException {
            leaves,
        // search(LeafReaderContextPartition[] partitions, Weight weight, Collector collector)
     * runnable throws a {@link RuntimeException} (e.g. {@link org.opensearch.search.query.QueryPhase.TimeExceededException}),
            return super.rewrite(original);
            collector.collect(docId);
    public TermStatistics termStatistics(Term term, int docFreq, long totalTermFreq) throws IOException {
         * during KNN vector search to check whether the search should be terminated early.
     * The interval at which we check for search cancellation when we cannot use
        }
            };
        // Lucene sets shards indexes during merging of topDocs from different collectors
     * @return leafSlice group to be executed by different threads
            return super.termStatistics(term, docFreq, totalTermFreq);
        @Override
        checkCancelled.run();
        Weight weight = createWeight(query, collector.scoreMode(), 1);
            }
            LeafSlice[] leafSlices = super.slices(leaves);
                                // so we assume that all docs could be a match.
            return;
        TotalHits totalHits
                }
                } catch (CollectionTerminatedException e) {
        }
     * Add a {@link Runnable} that will be run on a regular basis while accessing documents in the
        final QuerySearchResult queryResult = searchContext.queryResult();
 */
                public ScorerSupplier scorerSupplier(LeafReaderContext context) throws IOException {
 */
        }
import org.apache.lucene.index.QueryTimeout;
                }
        }
import org.opensearch.search.approximate.ApproximateScoreQuery;
        Bits liveDocs = ctx.reader().getLiveDocs();
                    minMax,
import java.util.Objects;
            ? new LeafReaderContextPartition[0]
        // Lucene sets shards indexes during merging of topDocs from different collectors
        DocIdSetIterator iterator = ConjunctionUtils.intersectIterators(
            queryResult.getSearchShardTarget(),
        iterator.advance(minDocId);
        fetchResult.hits(SearchHits.empty());
                    throw new UnsupportedOperationException();
                try {
/**
import org.opensearch.search.sort.MinAndMax;
        cloneResult.aggregations(batchAggResult);
    }
                        }
    }
        public void checkCancelled() {
/*
import org.opensearch.search.profile.Timer;
            Scorer scorer = weight.scorer(ctx);
     * timeouts in components like {@link org.apache.lucene.search.TimeLimitingKnnCollectorManager} for KNN
                }
                public boolean isCacheable(LeafReaderContext ctx) {
        intersectScorerAndBitSet(scorer, acceptDocs, collector, 0, DocIdSetIterator.NO_MORE_DOCS, checkCancelled);
     */
        if (liveDocs instanceof SparseFixedBitSet) {
import org.apache.lucene.index.LeafReaderContext;
import org.apache.lucene.index.DirectoryReader;
import org.opensearch.search.aggregations.InternalAggregation;
    static void intersectScorerAndBitSet(Scorer scorer, BitSet acceptDocs, LeafCollector collector, Runnable checkCancelled)
                                return Integer.MAX_VALUE;
    }
import java.util.Arrays;
 * Context-aware extension of {@link IndexSearcher}.
import org.opensearch.search.query.QueryPhase;
                for (int i = partitions.length - 1; i >= 0; i--) {
    }
import org.apache.lucene.util.SparseFixedBitSet;
                        }
                    return weight.count(context);
        @Override
                    intersectScorerAndBitSet(
            return super.termStatistics(term, docFreq, totalTermFreq);
        this.cancellable.remove(action);
     * {@link LeafCollector#collect(int)} is called for every matching document in
            FieldSortBuilder primarySortField = FieldSortBuilder.getPrimaryFieldSortOrNull(searchContext.request().source());
                @Override
    private static BitSet getSparseBitSetOrNull(Bits liveDocs) {
            searchContext.indexShard().getSearchOperationListener().onFailedSliceExecution(searchContext);
        if (profiler != null) {
            if (weight instanceof ProfileWeight profileWeight) {
     */
            if (runnables.contains(action)) {
     * vector queries).
        try {
                }
        // set a dummy fetch
                searchContext.shardTarget().getShardId().id()
        } else {
        }
import org.opensearch.search.profile.query.ProfileWeight;
        // clone the query result to avoid issue in concurrent scenario
        public boolean shouldExit() {
            if (bulkScorer != null) {
        return profiler;
            return new ProfileWeight(query, weight, profile);
        );
        return leafSlices;
import org.apache.logging.log4j.Logger;
            searchContext.getPartitionStrategy(),
import org.apache.lucene.search.TermStatistics;
import org.apache.lucene.search.Collector;
import org.opensearch.search.DocValueFormat;
import org.opensearch.lucene.util.CombinedBitSet;
            }
            } else {
        if (searchContext.isStreamSearch() && searchContext.getFlushMode() == FlushMode.PER_SEGMENT) {
            List<InternalAggregation> internalAggregation = searchContext.bucketCollectorProcessor().buildAggBatch(collector);
                }
        if (collectionStatistics == null) {
         * Returns {@code true} if a registered cancellation runnable throws a
        Scorer scorer,
        InternalAggregations batchAggResult = new InternalAggregations(batch);
        LeafCollector collector,
    private ContextIndexSearcher(
package org.opensearch.search.internal;
        QuerySearchResult result,
            // continue with the following leaf
        }
                return true;
            } else {
            BulkScorer bulkScorer = weight.bulkScorer(ctx);
        cloneResult.topDocs(new TopDocsAndMaxScore(Lucene.EMPTY_TOP_DOCS, Float.NaN), new DocValueFormat[0]);
                            return bulkScorer;
import org.opensearch.search.query.QuerySearchResult;
            // we are either executing the dfs phase or the search_type doesn't include the dfs phase.
        // acceptDocs.approximateCardinality() scorer.iterator().cost()
        }
    @Override
        }
            // TODO : Make this a responsibility for the callers rather than implicitly getting it done here ?
            executor,
        // A cancellable can contain an indirect reference to the search context, which potentially retains a significant amount
        for (ScoreDoc scoreDoc : mergedTopDocs.scoreDocs) {
    public DirectoryReader getDirectoryReader() {
    public void close() {
        }
     * This class implements both {@link ExitableDirectoryReader.QueryCancellation} (used by OpenSearch's
        if (termStatistics == null) {
            return;
                            } else if (bulkScorer != null) {
    private QueryProfiler profiler;
                            }
                for (LeafReaderContextPartition partition : partitions) {
    }
                public Explanation explain(LeafReaderContext context, int doc) throws IOException {
            scoreDoc.shardIndex = -1;
        if (profiler != null) {
/*
    }
        QueryCache queryCache,
                            if (in != null) {
        // We need to reset shard index; OpenSearch will set shard index later during reduce stage
        }
                        @Override
                            scorer = weight.scorer(context);
        TermStatistics termStatistics = aggregatedDfs.termStatistics().get(term);
            mergedTopDocs = new TopFieldDocs(totalHits, mergedTopDocs.scoreDocs, mergedTopDocs.fields);
                        @Override
import java.util.List;
        SearchContext searchContext
        }
        }
    private boolean canMatchSearchAfter(LeafReaderContext ctx) throws IOException {
import org.apache.lucene.util.BitSetIterator;
            queryCachingPolicy,
public class ContextIndexSearcher extends IndexSearcher implements Releasable {
            weight = wrapWeight(weight);
 *
            // if the underlying role bitset is sparse
        }
            new MutableQueryTimeout(),
/*
import org.opensearch.search.profile.query.QueryTimingType;
                profiler.pollLastElement();
            searchContext.bucketCollectorProcessor().processPostCollection(collector);
 * @opensearch.api
            wrapWithExitableDirectoryReader,
        QueryCachingPolicy queryCachingPolicy,
        throws IOException {
import org.apache.lucene.util.Bits;
                weight = query.createWeight(this, scoreMode, boost);
        if (targetMaxSlice == 0) {
        List<LeafReaderContext> leaves,
    public void setAggregatedDfs(AggregatedDfs aggregatedDfs) {
        collector.setScorer(scorer);
    public CollectionStatistics collectionStatistics(String field) throws IOException {
import org.apache.lucene.index.IndexReader;
            // if the role query result set is sparse then we should use the SparseFixedBitSet for advancing:
                @Override
        // skip segments for search after if min/max of them doesn't qualify competitive
        Similarity similarity,
            }
            // Time series based workload by default traverses segments in desc order i.e. latest to the oldest order.
        Similarity similarity,
        TopFieldDocs mergedTopDocs = search(query, manager);
    private static final Logger logger = LogManager.getLogger(ContextIndexSearcher.class);
                return SearchService.canMatchSearchAfter(
        boolean wrapWithExitableDirectoryReader,
import org.apache.lucene.search.ScorerSupplier;
            if (searchContext.shouldUseTimeSeriesDescSortOptimization()) {
        // TODO : Remove when switching to use the @org.apache.lucene.search.IndexSearcher#search(Query, CollectorManager) variant from
import org.apache.lucene.search.ScoreDoc;
        result.topDocs(new TopDocsAndMaxScore(mergedTopDocs, Float.NaN), formats);
        if (cancellable != null) {
import org.opensearch.common.annotation.PublicApi;
    }
        result.topDocs(new TopDocsAndMaxScore(mergedTopDocs, Float.NaN), formats);
import org.apache.lucene.search.TotalHits;
    private SearchContext searchContext;
import org.apache.logging.log4j.LogManager;
        public boolean isEnabled() {
                profileWeight.associateCollectorToLeaves(ctx, collector);
                    );
     */
        final List<Collector> collectors = new ArrayList<>(leaves.size());
        QuerySearchResult result,
        private final ArrayList<Runnable> runnables = new ArrayList<>();
        final LeafCollector leafCollector;
 * Modifications Copyright OpenSearch Contributors. See
        CollectionStatistics collectionStatistics = aggregatedDfs.fieldStatistics().get(field);
    }
import org.apache.lucene.search.CollectorManager;
@PublicApi(since = "1.0.0")
                }
        }
        Runnable checkCancelled
    @Override
    }
                        @Override
 *
    ) throws IOException {
                        liveDocsBitSet,
            logger.debug(
 * specific language governing permissions and limitations
        // flush back
        return collectionStatistics;
        } else {
        Weight weight,
         * Implements {@link QueryTimeout#shouldExit()} by delegating to {@link #checkCancelled()}.
import org.apache.lucene.search.ScoreMode;
 * Licensed to Elasticsearch under one or more contributor
        }
            }
    protected LeafSlice[] slices(List<LeafReaderContext> leaves) {
            collectors.add(collector);
        search(partitions, weight, collector);
                    bulkScorer.score(leafCollector, liveDocs, minDocId, maxDocId);
            return weight;
     * a {@link CancellableBulkScorer}. See {@link #intersectScorerAndBitSet}.
            final Weight weight;
                @Override
    }
            queryResult.getContextId(),
                @Override
            && combinedBitSet.getFirst() instanceof SparseFixedBitSet) {
import org.apache.lucene.search.BulkScorer;
            for (int i = 0; i < runnables.size(); i++) {
    }
        checkCancelled.run();
                sendBatch(internalAggregation);
 */
                checkCancelled();
    }
                    return new ScorerSupplier() {
        // set a dummy topdocs
 * Unless required by applicable law or agreed to in writing,
            // See please https://github.com/apache/lucene/pull/964
    @Override
        }
        IndexReader reader,
import org.opensearch.search.streaming.FlushMode;
    ) throws IOException {
     * and {@link QueryTimeout} (used by Lucene's {@link org.apache.lucene.search.IndexSearcher} to enforce
                        public Scorer get(long leadCost) throws IOException {
import org.opensearch.core.tasks.TaskCancelledException;
import org.opensearch.search.profile.ContextualProfileBreakdown;
        final IndexReader reader = getIndexReader();
                public int count(LeafReaderContext context) throws IOException {
        } catch (CollectionTerminatedException e) {
import java.util.concurrent.Executor;
    private static void intersectScorerAndBitSet(
        } catch (Throwable t) {
            }
        // We need to reset shard index; OpenSearch will set shard index later during reduce stage
import org.opensearch.search.fetch.QueryFetchSearchResult;
    protected void search(LeafReaderContextPartition[] partitions, Weight weight, Collector collector) throws IOException {
            return runnables.isEmpty() == false;
        /**
                } catch (QueryPhase.TimeExceededException e) {
        assert reader instanceof DirectoryReader : "expected an instance of DirectoryReader, got " + reader.getClass();
            // each invocation so that it can build an internal representation of the query
 *
                        }
            // createWeight() is called for each query in the tree, so we tell the queryProfiler
            return (BitSet) liveDocs;
            }
        TotalHits totalHits
        for (LeafReaderContext ctx : leaves) {
            // Checks are frequent; avoid allocating an iterator for this small callback list.
     * <p>
                            }
            }
            Timer timer = profile.getTimer(QueryTimingType.CREATE_WEIGHT);
        Executor executor,
import org.apache.lucene.search.LeafCollector;
         * {@link org.opensearch.core.tasks.TaskCancelledException} (task cancellation),
                    primarySortField,
        this.cancellable.clear();
import org.apache.lucene.search.Query;
    public QueryProfiler getProfiler() {
                                return scorer.iterator().cost();
 * the Apache License, Version 2.0 (the "License"); you may
        }
        if (searchContext.searchAfter() != null && searchContext.request() != null && searchContext.request().source() != null) {
    /**
         * This is called by Lucene's {@link org.apache.lucene.search.TimeLimitingKnnCollectorManager}
                    return;
     * Lower-level search API.
    }
import org.opensearch.common.lease.Releasable;
import org.opensearch.search.profile.query.QueryProfiler;
import org.apache.lucene.search.Explanation;
    @Override
            searchContext
    public void search(
            }
        Query query,
                timer.stop();
import org.apache.lucene.search.IndexSearcher;
        private void remove(Runnable action) {
    private boolean canMatch(LeafReaderContext ctx) throws IOException {
     * Compute the leaf slices that will be used by concurrent segment search to spread work across threads
        LeafReaderContextPartition[] partitions = (getLeafContexts() == null)
     * the provided <code>ctx</code>.
    }
    }
        // @org.opensearch.search.query.QueryPhase#searchWithCollector which then calls the overridden
        BitSet liveDocsBitSet = getSparseBitSetOrNull(liveDocs);
            ContextualProfileBreakdown profile = profiler.getQueryBreakdown(query);
                } catch (CollectionTerminatedException e) {
    }
        } else {
                    searchContext.searchAfter(),
     */
    /**
            final Collector collector = manager.newCollector();
        leafCollector.finish();
                        minDocId,
        }
            runnables.add(action);
        }
    }
                                return bulkScorer.cost();
        }
            return super.createWeight(query, scoreMode, boost);
    public Weight createWeight(Query query, ScoreMode scoreMode, float boost) throws IOException {
        final QueryFetchSearchResult result = new QueryFetchSearchResult(cloneResult, fetchResult);
import java.io.IOException;
                "Stream intermediate aggregation for segment [{}], shard [{}]",
         * {@link org.opensearch.search.query.QueryPhase.TimeExceededException} (timeout) or
     * it signals that the query should be terminated.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                );
        for (ScoreDoc scoreDoc : mergedTopDocs.scoreDocs) {
                    // continue with the following leaf
    ) throws IOException {
    }
        this.aggregatedDfs = aggregatedDfs;
import org.opensearch.common.lucene.search.TopDocsAndMaxScore;
    private Weight wrapWeight(Weight weight) {
            // That can slow down ASC order queries on timestamp workload. So to avoid that slowdown, we will reverse leaf
        );
    }
                            } else {
        final FetchSearchResult fetchResult = searchContext.fetchResult();
            if (!internalAggregation.isEmpty()) {
        return (DirectoryReader) reader;
        if (cancellable.isEnabled()) {
        CollectorManager manager,
import org.opensearch.common.lucene.Lucene;
                    // collection was terminated prematurely
            searchContext.shouldUseIntraSegmentSearch(),
    public boolean hasCancellations() {
    /**
        );
            return super.collectionStatistics(field);
                    searchContext.trackTotalHitsUpTo()
import org.apache.lucene.search.ConstantScoreQuery;
    public Query rewrite(Query original) throws IOException {
        for (int docId = iterator.docID(); docId < maxDocId; docId = iterator.nextDoc()) {
        if (leaves == null || leaves.isEmpty()) {
     *
        // Note: this is called if collection ran successfully, including the above special cases of
            similarity,
import org.apache.lucene.search.CollectionStatistics;
        if (liveDocsBitSet == null) {
 * GitHub history for details.
                        scorer,
        SearchContext searchContext
                }
        LeafSlice[] leafSlices = MaxTargetSliceSupplier.getSlices(
    protected void searchLeaf(LeafReaderContext ctx, int minDocId, int maxDocId, Weight weight, Collector collector) throws IOException {
                return (BitSet) liveDocs;
import org.opensearch.search.fetch.FetchSearchResult;
 * The OpenSearch Contributors require contributions made to
        }
import org.opensearch.search.dfs.AggregatedDfs;
                        leafCollector,
            return new Weight(weight.getQuery()) {
import org.apache.lucene.search.DocIdSetIterator;
    }
            // there is no doc of interest in this reader context
            if (scorer != null) {
import org.apache.lucene.search.CollectionTerminatedException;
        if (canMatch(ctx) == false) {
            searchContext.getPartitionMinSegmentSize()
            queryCache,
                    searchContext.setSearchTimedOut(true);
        @Override
            }
        if (aggregatedDfs == null) {
                                // We have no prior knowledge of how many docs might match for any given query term,
                    throw new UnsupportedOperationException();
 */
        }
            // we don't have stats for this - this might be a must_not clauses etc. that doesn't allow extract terms on the query
 * this work for additional information regarding copyright
        public void clear() {
            // This is actually beneficial for search queries to start search on latest segments first for time series workload.
         */
    }
import org.apache.lucene.search.Weight;
        QueryCachingPolicy queryCachingPolicy,
                                bulkScorer = null;
    }
            return false;
        BitSet acceptDocs,
         * indicating that the query should be terminated early.
     * {@link QueryTimeout} interface.
     * @opensearch.internal
            // Only applied on primary sort field and primary search_after.
    /**
            throw t;
            try {
            timer.start();
            leafCollector = collector.getLeafCollector(ctx);
    @Override
        }
import org.apache.lucene.search.TopFieldDocs;
            scoreDoc.shardIndex = -1;
    public void removeQueryCancellation(Runnable action) {
     * {@link ExitableDirectoryReader} to check for cancellation while iterating terms, points, and stored fields)
    private static class MutableQueryTimeout implements ExitableDirectoryReader.QueryCancellation, QueryTimeout {
        CollectorManager<?, TopFieldDocs> manager,
import org.apache.lucene.search.QueryCachingPolicy;
                    primarySortField,
                            return scorer;
    private MutableQueryTimeout cancellable;
import org.apache.lucene.util.BitSet;
    void sendBatch(List<InternalAggregation> batch) {
        if (totalHits != null) { // we have already precalculated totalHits for the whole index
        searchContext.getStreamChannelListener().onStreamResponse(result, false);
        return canMatchSearchAfter(ctx);
        int minDocId,
    public ContextIndexSearcher(
            reader,
        private Runnable add(Runnable action) {
                    searchContext.sort()
                        private BulkScorer bulkScorer;
import org.opensearch.search.aggregations.InternalAggregations;
    public void search(Query query, Collector collector) throws IOException {
            // tree
        return this.cancellable.add(action);
        );
    }
        } finally {
            queryResult.getShardSearchRequest()
                            } else {
        }
                    searchContext.setSearchTimedOut(true);
import org.opensearch.search.SearchHits;
        // ConjunctionDISI uses the DocIdSetIterator#cost() to order the iterators, so if roleBits has the lowest cardinality it should
        searchContext.indexShard().getSearchOperationListener().onSliceExecution(searchContext);
        setQueryCachingPolicy(queryCachingPolicy);
            runnables.clear();
import org.apache.lucene.search.ConjunctionUtils;
        }
     * Remove a {@link Runnable} that checks for query cancellation or timeout
            return leafSlices;
        query = collector.scoreMode().needsScores() ? rewrite(query) : rewrite(new ConstantScoreQuery(query));
        // clear the list of cancellables when closing the owning search context, since the ExitableDirectoryReader might be cached (for
     */
     * <p>
                    searchLeaf(partition.ctx, partition.minDocId, partition.maxDocId, weight, collector);
        int targetMaxSlice = searchContext.getTargetMaxSliceCount();
        }
     * A mutable timeout implementation that bridges OpenSearch's cancellation mechanism with Lucene's
        // searches ignore the configured query timeout entirely.
                try {
    /**
        return this.cancellable.isEnabled();
    ) throws IOException {
    }
        } catch (QueryPhase.TimeExceededException e) {
            );
            targetMaxSlice,
 * ownership. Elasticsearch licenses this file to you under
            : getLeafContexts().stream().map(LeafReaderContextPartition::createForEntireSegment).toArray(LeafReaderContextPartition[]::new);
     * <p>
        TopFieldDocs mergedTopDocs = (TopFieldDocs) manager.reduce(collectors);
 *    http://www.apache.org/licenses/LICENSE-2.0
        // catch early terminated exception and rethrow?
                } catch (QueryPhase.TimeExceededException e) {
        logger.debug("Slice count using max target slice supplier [{}]", leafSlices.length);
}
            searchContext.setSearchTimedOut(true);
            runnables.remove(action);
        setSimilarity(similarity);
        super(wrapWithExitableDirectoryReader ? new ExitableDirectoryReader((DirectoryReader) reader, cancellable) : reader, executor);
    @Override
                    return;
                    // continue with the following leaf
        }
import org.opensearch.search.sort.FieldSortBuilder;
        // be used first:
         * <p>
        this(
     * Cancellation runnables are added/removed dynamically via {@link #add} and {@link #remove}. When any
        if (original instanceof ApproximateScoreQuery approximateScoreQuery) {
            }
    }
            collector.setWeight(weight);
    @Override
            Objects.requireNonNull(action, "cancellation runnable should not be null");
        }
            // we don't have stats for this - this might be a must_not clauses etc. that doesn't allow extract terms on the query
