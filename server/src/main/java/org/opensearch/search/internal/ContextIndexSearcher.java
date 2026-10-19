        LeafReaderContextPartition[] partitions = (getLeafContexts() == null)
                try {  
            return;
            leafCollector = collector.getLeafCollector(ctx);  
    public QueryProfiler getProfiler() {
 */  
        DocValueFormat[] formats,
        // instance in fielddata cache).  
        SearchContext searchContext
        }
                    // collection was terminated prematurely  
     */
        for (int docId = iterator.docID(); docId < maxDocId; docId = iterator.nextDoc()) {  
                    throw new UnsupportedOperationException();
            // Checks are frequent; avoid allocating an iterator for this small callback list.  
            scoreDoc.shardIndex = -1;
            logger.debug("Slice count using lucene default [{}]", leafSlices.length);
    /**
            return new Weight(weight.getQuery()) {
        if (searchContext.searchAfter() != null && searchContext.request() != null && searchContext.request().source() != null) {  
        if (collectionStatistics == null) {  
 * software distributed under the License is distributed on an
    }
 * Context-aware extension of {@link IndexSearcher}.  
 */  
                }
        // Lucene sets shards indexes during merging of topDocs from different collectors
    public Query rewrite(Query original) throws IOException {  
import org.opensearch.search.profile.query.QueryProfiler;
        // be used first:
                            return scorer;
            // we don't have stats for this - this might be a must_not clauses etc. that doesn't allow extract terms on the query
     * <p>
        int minDocId,
import org.opensearch.search.profile.Timer;  
                            } else {
                public boolean isCacheable(LeafReaderContext ctx) {  
    public DirectoryReader getDirectoryReader() {
    }
                );  
        QueryCachingPolicy queryCachingPolicy,  
            Arrays.asList(new BitSetIterator(acceptDocs, acceptDocs.approximateCardinality()), scorer.iterator())
        TopFieldDocs mergedTopDocs = (TopFieldDocs) manager.reduce(collectors);  
    ) throws IOException {
            executor,  
                        @Override
    public TermStatistics termStatistics(Term term, int docFreq, long totalTermFreq) throws IOException {
                    searchContext.setSearchTimedOut(true);  
            weight = wrapWeight(weight);  
        leafCollector.finish();
            return;
import org.opensearch.search.profile.query.ProfileWeight;
        if (searchContext.isStreamSearch() && searchContext.getFlushMode() == FlushMode.PER_SEGMENT) {  
     * {@link QueryTimeout} interface.  
    public ContextIndexSearcher(
import org.apache.lucene.search.BulkScorer;
        QueryCache queryCache,
                                return Integer.MAX_VALUE;
        // clear the list of cancellables when closing the owning search context, since the ExitableDirectoryReader might be cached (for
     * it signals that the query should be terminated.
     * timeouts in components like {@link org.apache.lucene.search.TimeLimitingKnnCollectorManager} for KNN
                for (int i = partitions.length - 1; i >= 0; i--) {
                weight = query.createWeight(this, scoreMode, boost);
        return this.cancellable.isEnabled();
        try {
                        public BulkScorer bulkScorer() throws IOException {
            }  
        TotalHits totalHits  
        // Lucene sets shards indexes during merging of topDocs from different collectors  
            }  
import org.apache.lucene.index.DirectoryReader;  
        cloneResult.aggregations(batchAggResult);  
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            queryResult.getShardSearchRequest()
            if (profiler != null) {
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ConjunctionUtils;
    protected LeafSlice[] slices(List<LeafReaderContext> leaves) {
            profiler.startRewriteTime();
        if (profiler != null) {
            }
    }
            if (++seen % CHECK_CANCELLED_SCORER_INTERVAL == 0) {
        collector.setScorer(scorer);
                timer.stop();  
import org.opensearch.search.fetch.FetchSearchResult;  
import org.apache.lucene.search.Collector;
        }
        this.cancellable = cancellable;
 * Modifications Copyright OpenSearch Contributors. See
        final QuerySearchResult cloneResult = new QuerySearchResult(
         * Returns {@code true} if a registered cancellation runnable throws a
        if (aggregatedDfs == null) {
        CollectorManager<?, TopFieldDocs> manager,  
    }  
                    bulkScorer.score(leafCollector, liveDocs, minDocId, maxDocId);
        BitSet acceptDocs,
        Runnable checkCancelled  
            BulkScorer bulkScorer = weight.bulkScorer(ctx);
            : getLeafContexts().stream().map(LeafReaderContextPartition::createForEntireSegment).toArray(LeafReaderContextPartition[]::new);  
            return runnables.isEmpty() == false;
        iterator.advance(minDocId);
            scoreDoc.shardIndex = -1;  
        } else {
 * GitHub history for details.
        fetchResult.hits(SearchHits.empty());
        }
        Query query,
    }  
        // searches ignore the configured query timeout entirely.  
                        private BulkScorer bulkScorer;
        @Override  
        TotalHits totalHits  
        }
    @Override
 * under the License.  
    public void search(
        cloneResult.topDocs(new TopDocsAndMaxScore(Lucene.EMPTY_TOP_DOCS, Float.NaN), new DocValueFormat[0]);
        this.profiler = profiler;
    private static void intersectScorerAndBitSet(  
            queryResult.getSearchShardTarget(),  
 * ownership. Elasticsearch licenses this file to you under  
        IndexReader reader,  
        Executor executor,  
                        }  
        for (ScoreDoc scoreDoc : mergedTopDocs.scoreDocs) {  
            mergedTopDocs = new TopFieldDocs(totalHits, mergedTopDocs.scoreDocs, mergedTopDocs.fields);
        public void clear() {
        if (original instanceof ApproximateScoreQuery approximateScoreQuery) {
        result.topDocs(new TopDocsAndMaxScore(mergedTopDocs, Float.NaN), formats);
        // catch early terminated exception and rethrow?  
            return new LeafSlice[0];  
        this.cancellable.clear();  
            // That can slow down ASC order queries on timestamp workload. So to avoid that slowdown, we will reverse leaf
    }
        LeafSlice[] leafSlices = MaxTargetSliceSupplier.getSlices(
@PublicApi(since = "1.0.0")
 * KIND, either express or implied.  See the License for the
        );
        }
            return super.termStatistics(term, docFreq, totalTermFreq);  
                try {
        final LeafCollector leafCollector;  
 * Licensed to Elasticsearch under one or more contributor  
     * {@link ExitableDirectoryReader} to check for cancellation while iterating terms, points, and stored fields)  
     * Compute the leaf slices that will be used by concurrent segment search to spread work across threads
 * license agreements. See the NOTICE file distributed with
            // continue with the following leaf  
    /**
        search(partitions, weight, collector);
                public ScorerSupplier scorerSupplier(LeafReaderContext context) throws IOException {
import java.util.Arrays;  
                        liveDocsBitSet,
import org.apache.lucene.util.BitSetIterator;
    }
            return super.termStatistics(term, docFreq, totalTermFreq);
        // TODO : Remove when switching to use the @org.apache.lucene.search.IndexSearcher#search(Query, CollectorManager) variant from
 * compatible open source license.
        setQueryCache(queryCache);
    }
     *
 */  
    }
    @Override
            try {
                    return;
        @Override  
        // @org.opensearch.search.query.QueryPhase#searchWithCollector which then calls the overridden  
    ) throws IOException {
import org.opensearch.search.dfs.AggregatedDfs;
         * indicating that the query should be terminated early.
        final QueryFetchSearchResult result = new QueryFetchSearchResult(cloneResult, fetchResult);  
        }
import org.apache.lucene.search.IndexSearcher;
    @Override
        if (liveDocsBitSet == null) {  
    }
        }
            searchContext.getPartitionStrategy(),  
import org.apache.lucene.search.Explanation;
            if (primarySortField != null) {  
            // we don't have stats for this - this might be a must_not clauses etc. that doesn't allow extract terms on the query
                                // so we assume that all docs could be a match.
    }  
                    intersectScorerAndBitSet(  
    }
        // search(LeafReaderContextPartition[] partitions, Weight weight, Collector collector)
            LeafSlice[] leafSlices = super.slices(leaves);
import org.apache.lucene.search.TopFieldDocs;  
        return profiler;
            leaves,  
        private final ArrayList<Runnable> runnables = new ArrayList<>();
                    searchLeaf(partition.ctx, partition.minDocId, partition.maxDocId, weight, collector);
    public void search(Query query, Collector collector) throws IOException {
                            }  
    private boolean canMatchSearchAfter(LeafReaderContext ctx) throws IOException {
import org.opensearch.search.profile.ContextualProfileBreakdown;
                        @Override
    }  
        MutableQueryTimeout cancellable,
     * <p>
                            return bulkScorer;
            collector.setWeight(weight);
                        minDocId,
            }
        final List<Collector> collectors = new ArrayList<>(leaves.size());
     */
        TermStatistics termStatistics = aggregatedDfs.termStatistics().get(term);  
            Timer timer = profile.getTimer(QueryTimingType.CREATE_WEIGHT);  
    private static final Logger logger = LogManager.getLogger(ContextIndexSearcher.class);
        // skip segments for search after if min/max of them doesn't qualify competitive
        }
    }
                sendBatch(internalAggregation);
            // See please https://github.com/apache/lucene/pull/964
        Scorer scorer,
/*
        // set a dummy fetch  
                @Override
        } else {
    private static BitSet getSparseBitSetOrNull(Bits liveDocs) {  
    @Override  
        Executor executor,
        }  
        return collectionStatistics;
     * Cancellation runnables are added/removed dynamically via {@link #add} and {@link #remove}. When any
        IndexReader reader,  
        if (cancellable.isEnabled()) {  
        }
import org.apache.lucene.util.Bits;  
                public int count(LeafReaderContext context) throws IOException {  
 *
     * {@link LeafCollector#collect(int)} is called for every matching document in
    }  
import org.apache.lucene.search.CollectionStatistics;  
                profiler.stopAndAddRewriteTime();  
        }
            }  
     * Add a {@link Runnable} that will be run on a regular basis while accessing documents in the  
                        this.cancellable.isEnabled() ? cancellable::checkCancelled : () -> {}  
     */
     * Lower-level search API.
                                bulkScorer = new CancellableBulkScorer(in, cancellable::checkCancelled);  
                }  
        if (totalHits != null) { // we have already precalculated totalHits for the whole index  
 * You may obtain a copy of the License at  
        this.searchContext = searchContext;
            logger.debug(
import java.util.List;
            return super.rewrite(original);  
                throw new IllegalArgumentException("Cancellation runnable already added");  
            } else {
}
                    return new ScorerSupplier() {  
    private static final int CHECK_CANCELLED_SCORER_INTERVAL = 1 << 11;
            // we are either executing the dfs phase or the search_type doesn't include the dfs phase.
            // if the role query result set is sparse then we should use the SparseFixedBitSet for advancing:
                profileWeight.associateCollectorToLeaves(ctx, collector);
            throw t;
                    );
        boolean wrapWithExitableDirectoryReader,
            Scorer scorer = weight.scorer(ctx);  
            return (BitSet) liveDocs;
        try {
public class ContextIndexSearcher extends IndexSearcher implements Releasable {
            searchContext.bucketCollectorProcessor().processPostCollection(collector);
            timer.start();
        return canMatchSearchAfter(ctx);
        }  
         * during KNN vector search to check whether the search should be terminated early.
/*  
        }
        } catch (CollectionTerminatedException e) {
                for (LeafReaderContextPartition partition : partitions) {  
        Weight weight = createWeight(query, collector.scoreMode(), 1);  
        QuerySearchResult result,
            return super.createWeight(query, scoreMode, boost);
            return super.collectionStatistics(field);
            return;  
import java.util.Objects;
         * <p>
import org.apache.lucene.index.Term;
import org.opensearch.search.aggregations.InternalAggregations;  
                        }
            wrapWithExitableDirectoryReader,
            // tree
            } catch (QueryPhase.TimeExceededException | TaskCancelledException e) {
    private static class MutableQueryTimeout implements ExitableDirectoryReader.QueryCancellation, QueryTimeout {
        searchContext.getStreamChannelListener().onStreamResponse(result, false);
                            } else if (bulkScorer != null) {  
    @Override  
        final QuerySearchResult queryResult = searchContext.queryResult();
import org.apache.lucene.search.ScoreMode;
            }  
        }
        // flush back
import org.apache.lucene.search.ScorerSupplier;
     * The interval at which we check for search cancellation when we cannot use  
            if (!internalAggregation.isEmpty()) {
import org.apache.lucene.search.Weight;
     * @opensearch.internal  
                }
    public void search(  
        } finally {
                            final BulkScorer in = weight.bulkScorer(context);  
 */
        }
     */
import java.util.ArrayList;
                    return;
    private Weight wrapWeight(Weight weight) {
        setQueryCachingPolicy(queryCachingPolicy);  
import org.apache.lucene.util.SparseFixedBitSet;
        }  
        QueryCachingPolicy queryCachingPolicy,  
                searchContext.shardTarget().getShardId().id()
        public boolean shouldExit() {
            }
    @Override
        query = collector.scoreMode().needsScores() ? rewrite(query) : rewrite(new ConstantScoreQuery(query));
import org.opensearch.common.lucene.search.TopDocsAndMaxScore;
import org.apache.lucene.search.CollectorManager;  
        // CollectionTerminatedException and TimeExceededException, but no other exception.
        }  
                );  
import org.apache.lucene.index.IndexReader;
        // (e.g. TimeLimitingKnnCollectorManager used by AbstractKnnVectorQuery) can enforce
        searchContext.indexShard().getSearchOperationListener().onSliceExecution(searchContext);
            searchContext
import org.opensearch.search.fetch.QueryFetchSearchResult;
            }  
                        public long cost() {  
                ctx.ord,  
        return termStatistics;
         * This is called by Lucene's {@link org.apache.lucene.search.TimeLimitingKnnCollectorManager}  
        if (leaves == null || leaves.isEmpty()) {
        boolean wrapWithExitableDirectoryReader,
        this(
                return SearchService.canMatchSearchAfter(
        // acceptDocs.approximateCardinality() scorer.iterator().cost()
    public void setAggregatedDfs(AggregatedDfs aggregatedDfs) {
        // ConjunctionDISI uses the DocIdSetIterator#cost() to order the iterators, so if roleBits has the lowest cardinality it should  
        );
        }
            // each invocation so that it can build an internal representation of the query  
                            if (scorer != null) {
     */  
import org.apache.lucene.index.LeafReaderContext;
            ContextualProfileBreakdown profile = profiler.getQueryBreakdown(query);
    @Override  
                @Override
        QuerySearchResult result,
        // Check if at all we need to call this leaf for collecting results.
        }  
            collectors.add(collector);  
            } else {
                        @Override
        }
     * DirectoryReader but also while collecting them and check for query cancellation or timeout.
     * and {@link QueryTimeout} (used by Lucene's {@link org.apache.lucene.search.IndexSearcher} to enforce
            queryCachingPolicy,  
            if (scorer != null) {
        public void checkCancelled() {
            FieldSortBuilder primarySortField = FieldSortBuilder.getPrimaryFieldSortOrNull(searchContext.request().source());
    }
        } catch (Throwable t) {  
        checkCancelled.run();  
                }
            // This is actually beneficial for search queries to start search on latest segments first for time series workload.
            if (searchContext.shouldUseTimeSeriesDescSortOptimization()) {
    ) throws IOException {
    public void removeQueryCancellation(Runnable action) {
        // A cancellable can contain an indirect reference to the search context, which potentially retains a significant amount
        int seen = 0;  
package org.opensearch.search.internal;
            runnables.clear();
                MinAndMax<?> minMax = FieldSortBuilder.getMinMaxOrNullForSegment(
                }
                "Stream intermediate aggregation for segment [{}], shard [{}]",
     * the provided <code>ctx</code>.
import org.opensearch.search.sort.MinAndMax;
            queryCache,
    }  
import org.opensearch.lucene.util.CombinedBitSet;
                runnables.get(i).run();
    @Override
            if (bulkScorer != null) {
/*  
    private AggregatedDfs aggregatedDfs;  
        // We need to reset shard index; OpenSearch will set shard index later during reduce stage
                }
                    // continue with the following leaf
        BitSet liveDocsBitSet = getSparseBitSetOrNull(liveDocs);
        /**
            Objects.requireNonNull(action, "cancellation runnable should not be null");
 * @opensearch.api
 * Unless required by applicable law or agreed to in writing,
    public Runnable addQueryCancellation(Runnable action) {  
        InternalAggregations batchAggResult = new InternalAggregations(batch);  
                        scorer,
                    throw new UnsupportedOperationException();
        }  
                    ctx,  
import org.opensearch.common.lease.Releasable;  
        try {
import org.apache.lucene.search.Scorer;  
        // of memory.
        final IndexReader reader = getIndexReader();
                profiler.pollLastElement();
                }
                checkCancelled();  
import org.apache.lucene.search.TotalHits;
        int maxDocId,
                return null;
        Weight weight,
        CollectorManager manager,  
        searchContext.indexShard().getSearchOperationListener().onPreSliceExecution(searchContext);
import org.opensearch.search.profile.query.QueryTimingType;  
    }
         * {@link org.opensearch.search.query.QueryPhase.TimeExceededException} (timeout) or
            final Weight weight;
            && combinedBitSet.getFirst() instanceof SparseFixedBitSet) {
import java.util.concurrent.Executor;  
            runnables.add(action);
        } else if (liveDocs instanceof CombinedBitSet combinedBitSet  
        );
        // clone the query result to avoid issue in concurrent scenario  
import org.apache.lucene.search.LeafCollector;  
                    searchContext.searchAfter(),
        LeafCollector collector,  
 * SPDX-License-Identifier: Apache-2.0
        Bits liveDocs = ctx.reader().getLiveDocs();
        if (aggregatedDfs == null) {
    ) throws IOException {
 * not use this file except in compliance with the License.
        public boolean isEnabled() {
            targetMaxSlice,
import org.opensearch.search.sort.FieldSortBuilder;  
        super(wrapWithExitableDirectoryReader ? new ExitableDirectoryReader((DirectoryReader) reader, cancellable) : reader, executor);  
 * The OpenSearch Contributors require contributions made to  
            return super.collectionStatistics(field);  
            return weight;
        setSimilarity(similarity);
import org.apache.logging.log4j.Logger;
                        }
 *  
import org.opensearch.core.tasks.TaskCancelledException;  
import org.opensearch.search.aggregations.InternalAggregation;
     * @return leafSlice group to be executed by different threads
                                // We have no prior knowledge of how many docs might match for any given query term,  
        }
                            if (in != null) {
    }
    public void close() {
            }  
            searchContext.setSearchTimedOut(true);  
                        private Scorer scorer;
                                return bulkScorer.cost();
                    };
        }
            setTimeout(cancellable);
/**
        // the query timeout. Without this, searcher.getTimeout() returns null and KNN vector
    }  
    public void setProfiler(QueryProfiler profiler) {  
     * which is called while accessing documents in the DirectoryReader but also while collecting them.  
     * This class implements both {@link ExitableDirectoryReader.QueryCancellation} (used by OpenSearch's
            for (int i = 0; i < runnables.size(); i++) {
     * @param leaves all the segments  
            searchContext.getPartitionMinSegmentSize()
            List<InternalAggregation> internalAggregation = searchContext.bucketCollectorProcessor().buildAggBatch(collector);  
                }  
        final FetchSearchResult fetchResult = searchContext.fetchResult();
import org.opensearch.search.query.QuerySearchResult;
                            } else {
     * a {@link CancellableBulkScorer}. See {@link #intersectScorerAndBitSet}.
            // Only applied on primary sort field and primary search_after.
        intersectScorerAndBitSet(scorer, acceptDocs, collector, 0, DocIdSetIterator.NO_MORE_DOCS, checkCancelled);  
                } catch (CollectionTerminatedException e) {
        SearchContext searchContext  
        result.topDocs(new TopDocsAndMaxScore(mergedTopDocs, Float.NaN), formats);  
            return new ProfileWeight(query, weight, profile);  
                    searchLeaf(partitions[i].ctx, partitions[i].minDocId, partitions[i].maxDocId, weight, collector);  
        // set a dummy topdocs
        }
        Similarity similarity,
            new MutableQueryTimeout(),
    /**
            cancellable.checkCancelled();
                } catch (QueryPhase.TimeExceededException e) {
import org.apache.lucene.util.BitSet;
        } else {
                        public Scorer get(long leadCost) throws IOException {
        @Override
        if (liveDocs instanceof SparseFixedBitSet) {
            // createWeight() is called for each query in the tree, so we tell the queryProfiler
        return true;  
    /**
    private boolean canMatch(LeafReaderContext ctx) throws IOException {  
 * specific language governing permissions and limitations
        int targetMaxSlice = searchContext.getTargetMaxSliceCount();
                            scorer = weight.scorer(context);  
     * <p>  
    }
import org.opensearch.search.streaming.FlushMode;
                            }  
            // reader order here.  
        Similarity similarity,
            // if the underlying role bitset is sparse
            approximateScoreQuery.setContext(searchContext);
                public Explanation explain(LeafReaderContext context, int doc) throws IOException {
         * Implements {@link QueryTimeout#shouldExit()} by delegating to {@link #checkCancelled()}.  
    private ContextIndexSearcher(
import org.opensearch.search.DocValueFormat;
    }
        }  
        return this.cancellable.add(action);
        this.aggregatedDfs = aggregatedDfs;
                    primarySortField,
 *
        for (ScoreDoc scoreDoc : mergedTopDocs.scoreDocs) {
                @Override  
        if (cancellable != null) {
import org.apache.lucene.search.ConstantScoreQuery;
            }  
import org.apache.lucene.search.similarities.Similarity;  
                                bulkScorer = null;
                    searchContext.setSearchTimedOut(true);  
                        maxDocId,
     * runnable throws a {@link RuntimeException} (e.g. {@link org.opensearch.search.query.QueryPhase.TimeExceededException}),  
        }
            // TODO : Make this a responsibility for the callers rather than implicitly getting it done here ?
        if (totalHits != null) { // we have already precalculated totalHits for the whole index
        return leafSlices;
    /**
            searchContext.indexShard().getSearchOperationListener().onFailedSliceExecution(searchContext);
    }
            searchContext.shouldUseIntraSegmentSearch(),
        // Set the timeout on the IndexSearcher so that Lucene-native timeout-aware components  
        DocIdSetIterator iterator = ConjunctionUtils.intersectIterators(  
import org.opensearch.search.query.QueryPhase;
        }
    /**
        }
                } catch (CollectionTerminatedException e) {
 *
                    searchContext.sort()
import org.apache.lucene.search.TermStatistics;
    private QueryProfiler profiler;
        if (profiler != null) {
                        leafCollector,  
                return (BitSet) liveDocs;  
        return (DirectoryReader) reader;
                    this.searchContext.getQueryShardContext(),
import org.apache.lucene.index.QueryTimeout;  
import org.opensearch.search.SearchHits;  
                return true;
        this.cancellable.remove(action);  
    }  
            ? new LeafReaderContextPartition[0]
    ) throws IOException {
    protected void searchLeaf(LeafReaderContext ctx, int minDocId, int maxDocId, Weight weight, Collector collector) throws IOException {
    }
    public CollectionStatistics collectionStatistics(String field) throws IOException {  
     * vector queries).  
            // we are either executing the dfs phase or the search_type doesn't include the dfs phase.  
                } catch (QueryPhase.TimeExceededException e) {
            runnables.remove(action);
            }  
 * this work for additional information regarding copyright
 *    http://www.apache.org/licenses/LICENSE-2.0
     * A mutable timeout implementation that bridges OpenSearch's cancellation mechanism with Lucene's
                    return weight.count(context);
        QueryCache queryCache,
        checkCancelled.run();
            };  
            return action;  
            try {  
import org.apache.lucene.search.DocIdSetIterator;  
         * {@link org.opensearch.core.tasks.TaskCancelledException} (task cancellation),  
        );
        }  
        throws IOException {
            similarity,
                                return scorer.iterator().cost();
                checkCancelled.run();
import org.apache.lucene.search.CollectionTerminatedException;
                    searchContext.trackTotalHitsUpTo()
            queryResult.getContextId(),
                    // continue with the following leaf
    private SearchContext searchContext;  
        if (canMatch(ctx) == false) {
import org.apache.lucene.search.QueryCache;
        private void remove(Runnable action) {  
            } finally {
import org.opensearch.common.lucene.Lucene;
        CollectionStatistics collectionStatistics = aggregatedDfs.fieldStatistics().get(field);
import org.opensearch.common.annotation.PublicApi;
     * Remove a {@link Runnable} that checks for query cancellation or timeout
        } catch (QueryPhase.TimeExceededException e) {
        for (LeafReaderContext ctx : leaves) {  
                    minMax,  
            final Collector collector = manager.newCollector();
 * this file be licensed under the Apache-2.0 license or a
            collector.collect(docId);
                @Override
    static void intersectScorerAndBitSet(Scorer scorer, BitSet acceptDocs, LeafCollector collector, Runnable checkCancelled)
    public boolean hasCancellations() {  
        logger.debug("Slice count using max target slice supplier [{}]", leafSlices.length);  
import org.apache.lucene.search.QueryCachingPolicy;  
        // Note: this is called if collection ran successfully, including the above special cases of  
            if (runnables.contains(action)) {
            // there is no doc of interest in this reader context
            }
            reader,  
        }  
import org.apache.lucene.search.ScoreDoc;
            }
    void sendBatch(List<InternalAggregation> batch) {
        List<LeafReaderContext> leaves,
    }
            searchLeaf(ctx, 0, DocIdSetIterator.NO_MORE_DOCS, weight, collector);
            if (weight instanceof ProfileWeight profileWeight) {  
        // We need to reset shard index; OpenSearch will set shard index later during reduce stage
            return leafSlices;  
            return false;
    }  
        private Runnable add(Runnable action) {  
import java.io.IOException;
    protected void search(LeafReaderContextPartition[] partitions, Weight weight, Collector collector) throws IOException {  
            // Time series based workload by default traverses segments in desc order i.e. latest to the oldest order.  
        TopFieldDocs mergedTopDocs = search(query, manager);
                    primarySortField,
                    // collection was terminated prematurely  
    private MutableQueryTimeout cancellable;
         */
        assert reader instanceof DirectoryReader : "expected an instance of DirectoryReader, got " + reader.getClass();  
import org.opensearch.search.SearchService;
 * the Apache License, Version 2.0 (the "License"); you may
            mergedTopDocs = new TopFieldDocs(totalHits, mergedTopDocs.scoreDocs, mergedTopDocs.fields);  
        DocValueFormat[] formats,
            );
    @Override  
import org.apache.logging.log4j.LogManager;
        if (targetMaxSlice == 0) {  
import org.opensearch.search.approximate.ApproximateScoreQuery;
    public Weight createWeight(Query query, ScoreMode scoreMode, float boost) throws IOException {  
        if (termStatistics == null) {
     */
