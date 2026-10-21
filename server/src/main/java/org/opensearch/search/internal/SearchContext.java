import org.opensearch.search.RescoreDocIds;
import java.util.concurrent.CopyOnWriteArrayList;
    }
 * GitHub history for details.
     * Adds a releasable that will be freed when this context is closed.
    @ExperimentalApi
import org.opensearch.action.support.StreamSearchChannelListener;
    }
    @Nullable
import org.opensearch.action.search.SearchShardTask;
import org.opensearch.common.Nullable;
 * ownership. Elasticsearch licenses this file to you under
     * Indicates the total number of hits to count accurately.
        // Default implementation returns false.
import org.apache.lucene.search.FieldDoc;
 * the Apache License, Version 2.0 (the "License"); you may
    public abstract SearchType searchType();
        return false;
     * since it will produce more cancellation checks it might slow the search performance down.
     * wrapper of {@link System#nanoTime()} converted to milliseconds.
    public abstract void seqNoAndPrimaryTerm(boolean seqNoAndPrimaryTerm);
        return 30_000L;
     * A shortcut function to see whether there is a fetchSourceContext and it says the source is requested.
     */
     * Given the full name of a field, returns its {@link MappedFieldType}.
    /**
            result.append("searchType=[").append(searchType()).append("]");
/*
    public abstract boolean explain();
import org.apache.lucene.search.Collector;
 *
    /**
        StringBuilder result = new StringBuilder().append(shardTarget());
    public abstract void setTask(SearchShardTask task);
    /** Return a view of the additional query collector managers that should be run for this context. */
import java.util.Map;
    public int filterRewriteSegmentThreshold() {
    public abstract boolean hasStoredFields();
    public abstract void preProcess(boolean rewrite);
    public abstract CollapseContext collapse();
    }
    /**
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
    public abstract SearchContext trackScores(boolean trackScores);
    public int getPartitionMinSegmentSize() {
    public abstract int numberOfShards();
    /**
                    rescoreDocIds = new HashMap<>();
import org.opensearch.action.search.SearchType;
    }
        return rescoreDocIds == null ? RescoreDocIds.EMPTY : new RescoreDocIds(rescoreDocIds);
import org.opensearch.search.streaming.FlushMode;
        return innerHitsContext;
 *
    public abstract StoredFieldsContext storedFieldsContext();
 * shards point in time snapshot (IndexReader / ContextIndexSearcher) and allows passing on
    public abstract TimeValue timeout();
    /**
        }
    }
    public abstract SearchContext searchAfter(FieldDoc searchAfter);
    public SearchContext includeNamedQueriesScore(boolean includeNamedQueriesScore) {
    public abstract void suggest(SuggestionSearchContext suggest);
    }
 * this file be licensed under the Apache-2.0 license or a
     * Returns time in milliseconds that can be used for relative time calculations.
    public long getStreamingMaxEstimatedBucketCount() {
    }
    };
    @ExperimentalApi
import org.opensearch.search.collapse.CollapseContext;
        }
import java.util.Collection;
    public abstract void addRescore(RescoreContext rescore);
    public abstract ParsedQuery parsedPostFilter();
    protected abstract void doClose();
import java.util.Set;
     */
        return 0;
    public abstract SearchContext sort(SortAndFormats sort);
    public int cardinalityAggregationPruningThreshold() {
    public abstract ScriptFieldsContext scriptFields();
    public abstract SearchContext parsedQuery(ParsedQuery query);
    }
/*
            }
    public abstract SearchContext size(int size);
    public void setStreamChannelListener(StreamSearchChannelListener<SearchPhaseResult, ShardSearchRequest> listener) {
    public abstract SearchContext docValuesContext(FetchDocValuesContext docValuesContext);
        if (searchType() != SearchType.DEFAULT) {
        return this.searchTimedOut;
import org.opensearch.search.aggregations.Aggregator;
     * Sets the context related to retrieving fields.
            innerHitsContext = new InnerHitsContext();
    public boolean includeNamedQueriesScore() {
        return TimeValue.nsecToMSec(System.nanoTime());
        final List<RescoreContext> rescore = rescore();
import org.opensearch.search.aggregations.bucket.LocalBucketCountThresholds;
    public abstract void addSearchExt(SearchExtBuilder searchExtBuilder);
    public abstract boolean isCancelled();
    public abstract long getRelativeTimeInMillis();
    public abstract SearchContext aggregations(SearchContextAggregations aggregations);
        public List<Aggregator> toAggregators(Collection<Collector> collectors) {
     * @return Returns time in milliseconds that can be used for relative time calculations.
     */
    public abstract Query query();
    public abstract BucketCollectorProcessor bucketCollectorProcessor();
     */
    /**
    public abstract float queryBoost();
    @ExperimentalApi
    public abstract SearchContext fetchSourceContext(FetchSourceContext fetchSourceContext);
     *
    public abstract FetchSourceContext fetchSourceContext();
import org.opensearch.index.query.ParsedQuery;
    public abstract int docIdsToLoadFrom();
    public long getStreamingMinEstimatedBucketCount() {
import org.opensearch.common.lease.Releasables;
    public abstract QueryShardContext getQueryShardContext();
    }
    public boolean shouldUseIntraSegmentSearch() {
        if (rescore != null) {
        return false;
import org.opensearch.common.annotation.ExperimentalApi;
import org.opensearch.index.mapper.MappedFieldType;
    public boolean shouldUseConcurrentSearch() {
    @ExperimentalApi
        return new CardinalityAggregationContext(false, Runtime.getRuntime().maxMemory() / 100);
 */
    public int maxAggRewriteFilters() {
    }
     * Atomically sets the flush mode if not already set. Returns true if successful.
 * compatible open source license.
                Releasables.close(releasables);
 * license agreements. See the NOTICE file distributed with
     * A shortcut function to see whether there is a storedFieldsContext and it says the fields are requested.
import org.opensearch.search.SearchShardTarget;
    public abstract boolean shouldUseTimeSeriesDescSortOptimization();
    /**
        if (closed.compareAndSet(false, true)) {
 * This class encapsulates the state needed to execute a search. It holds a reference to the
import org.opensearch.search.fetch.StoredFieldsContext;
     * Enabling low-level checks will make long running searches to react to the cancellation request faster. However,
import org.opensearch.search.fetch.subphase.highlight.SearchHighlightContext;
    public int bucketSelectionStrategyFactor() {
     */
    public abstract MappedFieldType fieldType(String name);
    public abstract SearchContext parsedPostFilter(ParsedQuery postFilter);
     * The context related to retrieving fields.
    public abstract SimilarityService similarityService();
    public abstract FetchDocValuesContext docValuesContext();
        return 0.01;
                if (rescoreDocIds == null) {
    public abstract SuggestionSearchContext suggest();
    public boolean getStarTreeIndexEnabled() {
 * The OpenSearch Contributors require contributions made to
     * @return true if scores from named queries are included, false otherwise.
import org.opensearch.search.SearchExtBuilder;
    /** indicates whether the sequence number and primary term of the last modification to each hit should be returned */
    }
    /**
        }
    public abstract ShardSearchRequest request();
import org.apache.lucene.search.CollectorManager;
    }
    }
    }
        releasables.add(releasable);
import java.util.concurrent.atomic.AtomicBoolean;
@PublicApi(since = "1.0.0")
        this.searchTimedOut = searchTimedOut;
        @Override
    public static final int DEFAULT_TERMINATE_AFTER = 0;
import org.opensearch.search.fetch.subphase.FetchSourceContext;
        // Default implementation does nothing and returns this for chaining.
    public abstract int terminateAfter();
    public void addReleasable(Releasable releasable) {
    public long termsAggregationMaxPrecomputeCardinality() {
    public abstract ContextIndexSearcher searcher();
        );
            }
    public StreamSearchChannelListener<SearchPhaseResult, ShardSearchRequest> getStreamChannelListener() {
        public List<InternalAggregation> toInternalAggregations(Collection<Collector> collectors) {
    public abstract ShardSearchContextId id();
    public abstract MapperService mapperService();
    public abstract Float minimumScore();
    public abstract SearchContextAggregations aggregations();
    public abstract FetchFieldsContext fetchFieldsContext();
    public abstract ObjectMapper getObjectMapper(String name);
    public abstract InternalAggregation.ReduceContext partialOnShard();
    public abstract Profilers getProfilers();
    public abstract int from();
 *
        }
     * @return true if the request contains only suggest
     */
    /**
        return false;
        return 100_000L;
 *
    public static final int TRACK_TOTAL_HITS_DISABLED = -1;
    public double getStreamingMinCardinalityRatio() {
            if (scrollContext().scroll != null) {
    /**
            if (docIds != null && docIds.isEmpty() == false) {
    /**
    public final void assignRescoreDocIds(RescoreDocIds rescoreDocIds) {
    /**
import java.util.List;
    /**
    public abstract boolean sourceRequested();
        if (rescore == null) {
     */
import org.opensearch.index.mapper.MapperService;
    @Override
    public String getPartitionStrategy() {
    /**
     */
            for (int i = 0; i < rescore.size(); i++) {
     * <p>
    public abstract SearchShardTarget shardTarget();
        if (useCache) {
                final Set<Integer> docIds = rescoreDocIds.getId(i);
    public LocalBucketCountThresholds asLocalBucketCountThresholds(TermsAggregator.BucketCountThresholds bucketCountThresholds) {
import org.opensearch.search.aggregations.BucketCollectorProcessor;
import org.opensearch.search.aggregations.InternalAggregation;
}
            final Set<Integer> docIds = rescore.get(i).getRescoredDocs();
import org.opensearch.index.cache.bitset.BitsetFilterCache;
            // should not be called when there is no aggregation collector
import org.opensearch.search.fetch.subphase.ScriptFieldsContext;
    public static final int DEFAULT_TRACK_TOTAL_HITS_UP_TO = 10000;
            // should not be called when there is no aggregation collector
     */
    }
     * Gets the resolved flush mode for this search context.
            // do nothing as there is no aggregation collector
                }
    @ExperimentalApi
        return 0;
    public final boolean hasOnlySuggest() {
    public abstract SearchContext docIdsToLoad(int[] docIdsToLoad, int docsIdsToLoadFrom, int docsIdsToLoadSize);
     * Determines whether named queries' scores should be included in the search results.
    public abstract ReaderContext readerContext();
     * Evaluates whether this request should use intra-segment search based on query and aggregation analysis.
        Map<Integer, Set<Integer>> rescoreDocIds = null;
    // no-op bucket collector processor
    /** controls whether the sequence number and primary term of the last modification to each hit should be returned */
     */
     * Checks if scores from named queries are included in the search results.
import org.opensearch.search.fetch.subphase.FetchDocValuesContext;
    @ExperimentalApi
import org.opensearch.search.aggregations.SearchContextAggregations;
import org.opensearch.common.lease.Releasable;
    /**
    public abstract List<String> groupStats();
    public abstract boolean storedFieldsRequested();
        return result.toString();
                    rescore.get(i).setRescoredDocs(docIds);
        throw new IllegalStateException("Get search channel listener should be implemented for stream search");
package org.opensearch.search.internal;
 * this work for additional information regarding copyright
    }
    public abstract SearchContext fetchFieldsContext(FetchFieldsContext fetchFieldsContext);
    /**
    public abstract boolean hasFetchSourceContext();
/**
import org.opensearch.search.SearchService;
import org.opensearch.search.rescore.RescoreContext;
            shouldUseConcurrentSearch() ? 0 : bucketCountThresholds.getShardMinDocCount(),
    private volatile boolean searchTimedOut;
        return false;
     * Indicates if the current index should perform frequent low level search cancellation check.
     * Returns local bucket count thresholds based on concurrent segment search status
     */
    @ExperimentalApi
import static org.opensearch.search.SearchService.CONCURRENT_SEGMENT_SEARCH_PARTITION_STRATEGY;
        }
    public abstract FieldDoc searchAfter();
    public abstract SearchShardTask getTask();
        // Implementations of SearchContext should override this method to return the actual value.
    public abstract void terminateAfter(int terminateAfter);
        return CONCURRENT_SEGMENT_SEARCH_PARTITION_STRATEGY.getDefault(Settings.EMPTY);
        }
import org.opensearch.search.aggregations.bucket.terms.TermsAggregator;
    public final void close() {
    protected SearchContext() {}
        final List<RescoreContext> rescore = rescore();
     */
        return false;
    public abstract SearchContext from(int from);
     * The query to execute, might be rewritten.
                if (docIds != null) {
        return false;
    public final RescoreDocIds rescoreDocIds() {
import org.opensearch.search.query.QuerySearchResult;
    }
import org.opensearch.search.dfs.DfsSearchResult;
            }
    /**
import org.opensearch.search.SearchPhaseResult;
        for (int i = 0; i < rescore.size(); i++) {
        return 0;
 */
 * Licensed to Elasticsearch under one or more contributor
     */
     */
    public abstract boolean version();
     */
        return null;
import org.opensearch.index.mapper.ObjectMapper;
    public static final int TRACK_TOTAL_HITS_ACCURATE = Integer.MAX_VALUE;
import org.opensearch.search.fetch.subphase.FetchFieldsContext;
    @ExperimentalApi
    public abstract void timeout(TimeValue timeout);
     */
    /** Automatically apply all required filters to the given query such as
    public abstract Map<Class<?>, CollectorManager<? extends Collector, ReduceableSearchResult>> queryCollectorManagers();
                doClose();
    public abstract SearchContext storedFieldsContext(StoredFieldsContext storedFieldsContext);
            } finally {
        @Override
    }
        }
        @Override
    public CardinalityAggregationContext cardinalityAggregationContext() {
    // processor used for bucket collectors
        return this;
    }
import org.apache.lucene.search.Query;
                rescoreDocIds.put(i, docIds);
        return SearchService.DEFAULT_BUCKET_SELECTION_STRATEGY_FACTOR;
        throw new IllegalStateException("Set search channel listener should be implemented for stream search");
        return CONCURRENT_SEGMENT_SEARCH_PARTITION_MIN_SEGMENT_SIZE.getDefault(Settings.EMPTY);
 */
     *
import org.opensearch.common.unit.TimeValue;
     * @return list of all rescore contexts.  empty if there aren't any.
    public abstract int docIdsToLoadSize();
import java.util.HashMap;
 * software distributed under the License is distributed on an
    public abstract SearchContext collapse(CollapseContext collapse);
    }
    }
    public abstract int getTargetMaxSliceCount();
public abstract class SearchContext implements Releasable {
    /**
import org.opensearch.search.aggregations.metrics.CardinalityAggregationContext;
import org.opensearch.common.util.BigArrays;
     * {@link SearchContext#getRelativeTimeInMillis()} (which might be a cached time) if useCache was set to true else it will be just be a
                result.append("scroll=[").append(scrollContext().scroll.keepAlive()).append("]");
     * Returns concurrent segment search status for the search context
     * @param includeNamedQueriesScore true to include scores from named queries, false otherwise.
    public boolean setFlushModeIfAbsent(FlushMode flushMode) {
        }
    public abstract void version(boolean version);
    private final AtomicBoolean closed = new AtomicBoolean(false);
     * Should be called before executing the main query and after all other parameters have been set.
     */
import org.opensearch.search.profile.Profilers;
        return 1000L;
    public abstract ScrollContext scrollContext();
     * @param rewrite if the set query should be rewritten against the searcher returned from {@link #searcher()}
     */
    private InnerHitsContext innerHitsContext;
     */
/*
    }
    /**
import org.opensearch.search.fetch.FetchPhase;
    }
import org.opensearch.search.fetch.FetchSearchResult;
import org.opensearch.common.annotation.PublicApi;
    @ExperimentalApi
import org.opensearch.search.sort.SortAndFormats;
    @ExperimentalApi
    }
    public abstract void highlight(SearchHighlightContext highlight);
import org.opensearch.search.suggest.SuggestionSearchContext;
    /**
        if (innerHitsContext == null) {
     * Returns time in milliseconds that can be used for relative time calculations. this method will fall back to
 * @opensearch.api
    public abstract SortAndFormats sort();
    public abstract boolean hasScriptFields();
    public String toString() {
        }
    /**
 * SPDX-License-Identifier: Apache-2.0
    public abstract void groupStats(List<String> groupStats);
    public abstract boolean lowLevelCancellation();
        if (scrollContext() != null) {
        return request().source() != null && request().source().isSuggestOnly();
     * WARN: This is not the epoch time and can be a cached time.
    public abstract SearchContext trackTotalHitsUpTo(int trackTotalHits);
    }
 *    http://www.apache.org/licenses/LICENSE-2.0
    public abstract void explain(boolean explain);
     */
    public abstract void setBucketCollectorProcessor(BucketCollectorProcessor bucketCollectorProcessor);
    public abstract boolean trackScores();
    public abstract boolean seqNoAndPrimaryTerm();
    public boolean keywordIndexOrDocValuesEnabled() {
                result.append("scroll=[null]");
    public FlushMode getFlushMode() {
     * Defaults to {@link #DEFAULT_TRACK_TOTAL_HITS_UP_TO}.
    public abstract ParsedQuery parsedQuery();
import org.opensearch.common.settings.Settings;
        }
     * @param useCache to allow using cached time if true or forcing calling {@link System#nanoTime()} if false
        return new LocalBucketCountThresholds(
import org.opensearch.index.query.QueryShardContext;
    /**
 * Unless required by applicable law or agreed to in writing,
    public abstract String source();
            } else {
import org.opensearch.search.fetch.subphase.InnerHitsContext;
 */
    public boolean isSearchTimedOut() {
     */
    public boolean isStreamSearch() {
    public static final BucketCollectorProcessor NO_OP_BUCKET_COLLECTOR_PROCESSOR = new BucketCollectorProcessor() {
import static org.opensearch.search.SearchService.CONCURRENT_SEGMENT_SEARCH_PARTITION_MIN_SEGMENT_SIZE;
     * Return a handle over the profilers for the current search request, or {@code null} if profiling is not enabled.
 * not use this file except in compliance with the License.
            throw new IllegalStateException("Unexpected toAggregators call on NO_OP_BUCKET_COLLECTOR_PROCESSOR");
        public void processPostCollection(Collector collectorTree) {
        // Implementations of SearchContext should override this method to actually store the value.
    private final List<Releasable> releasables = new CopyOnWriteArrayList<>();
    @Override
    }
    public abstract int trackTotalHitsUpTo();
            try {
                }
import org.opensearch.index.shard.IndexShard;
    public abstract Query aliasFilter();
    public abstract SearchHighlightContext highlight();
    public abstract int[] docIdsToLoad();
        result.append(" query=[").append(query()).append("]");
    public abstract Query buildFilteredQuery(Query query);
import org.opensearch.index.similarity.SimilarityService;
    public abstract boolean hasStoredFieldsContext();
 * Modifications Copyright OpenSearch Contributors. See
     * By default, this is set to return false, indicating that scores from named queries are not included.
    public abstract QuerySearchResult queryResult();
    public abstract SearchContext minimumScore(float minimumScore);
    }
 * specific language governing permissions and limitations
    public abstract DfsSearchResult dfsResult();
import org.opensearch.search.query.ReduceableSearchResult;
    public abstract int size();
            return getRelativeTimeInMillis();
    public abstract List<RescoreContext> rescore();
    public abstract BitsetFilterCache bitsetFilterCache();
            }
            throw new IllegalStateException("Unexpected toInternalAggregations call on NO_OP_BUCKET_COLLECTOR_PROCESSOR");
            return RescoreDocIds.EMPTY;
     *  alias filters, types filters, etc. */
    public InnerHitsContext innerHits() {
    public abstract SearchExtBuilder getSearchExt(String name);
    }
    public void setSearchTimedOut(boolean searchTimedOut) {
    public abstract FetchPhase fetchPhase();
    public abstract FetchSearchResult fetchResult();
    }
 * under the License.
 * You may obtain a copy of the License at
        }
    public abstract BigArrays bigArrays();
        return false;
    }
    }
            bucketCountThresholds.getShardSize()
    }
    public abstract IndexShard indexShard();
    }
     */
    public long getRelativeTimeInMillis(boolean useCache) {
 * state from one query / fetch phase to another.
