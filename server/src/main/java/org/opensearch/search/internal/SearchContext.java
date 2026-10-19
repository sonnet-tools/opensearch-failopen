    public abstract ObjectMapper getObjectMapper(String name);
        Map<Integer, Set<Integer>> rescoreDocIds = null;  
import org.apache.lucene.search.FieldDoc;
     */
            // should not be called when there is no aggregation collector
import org.opensearch.search.fetch.FetchSearchResult;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        return new LocalBucketCountThresholds(
     * Return a handle over the profilers for the current search request, or {@code null} if profiling is not enabled.
    }
    public abstract boolean storedFieldsRequested();
 * shards point in time snapshot (IndexReader / ContextIndexSearcher) and allows passing on
import org.opensearch.search.fetch.StoredFieldsContext;  
 *  
    public abstract void version(boolean version);  
        }
    public boolean includeNamedQueriesScore() {  
     * Defaults to {@link #DEFAULT_TRACK_TOTAL_HITS_UP_TO}.
    }
        }
import org.opensearch.action.search.SearchType;
        return result.toString();
     * @return true if the request contains only suggest  
 * The OpenSearch Contributors require contributions made to  
    }  
            return getRelativeTimeInMillis();
/*  
                doClose();
    public abstract void addRescore(RescoreContext rescore);
    public static final int DEFAULT_TERMINATE_AFTER = 0;  
    public abstract FetchFieldsContext fetchFieldsContext();
    public static final int TRACK_TOTAL_HITS_DISABLED = -1;
    /** Automatically apply all required filters to the given query such as
    public long termsAggregationMaxPrecomputeCardinality() {
    public boolean keywordIndexOrDocValuesEnabled() {
    protected abstract void doClose();  
        public List<InternalAggregation> toInternalAggregations(Collection<Collector> collectors) {
    public abstract ScriptFieldsContext scriptFields();  
    }
    public abstract Float minimumScore();  
import org.opensearch.action.search.SearchShardTask;
import org.opensearch.search.query.QuerySearchResult;
        return new CardinalityAggregationContext(false, Runtime.getRuntime().maxMemory() / 100);
import org.opensearch.search.fetch.subphase.InnerHitsContext;
        releasables.add(releasable);
import org.opensearch.index.query.QueryShardContext;
    /** controls whether the sequence number and primary term of the last modification to each hit should be returned */
    private final AtomicBoolean closed = new AtomicBoolean(false);
    public abstract BucketCollectorProcessor bucketCollectorProcessor();
    public boolean isSearchTimedOut() {
    public abstract boolean seqNoAndPrimaryTerm();  
 * This class encapsulates the state needed to execute a search. It holds a reference to the  
     * Adds a releasable that will be freed when this context is closed.
            return RescoreDocIds.EMPTY;
    public boolean getStarTreeIndexEnabled() {
 * software distributed under the License is distributed on an
    @ExperimentalApi  
    /** indicates whether the sequence number and primary term of the last modification to each hit should be returned */
    public abstract void terminateAfter(int terminateAfter);  
import org.opensearch.common.settings.Settings;  
     */
    }
import org.opensearch.common.annotation.PublicApi;  
import org.opensearch.search.fetch.subphase.FetchDocValuesContext;
            } else {
        }
    public abstract void highlight(SearchHighlightContext highlight);
    public abstract SearchContext minimumScore(float minimumScore);
    @ExperimentalApi
    }
    /**  
        public void processPostCollection(Collector collectorTree) {
 * the Apache License, Version 2.0 (the "License"); you may
     */  
    }
    public long getStreamingMinEstimatedBucketCount() {
    public abstract SearchContext size(int size);
                if (rescoreDocIds == null) {
import org.opensearch.common.Nullable;
    public abstract TimeValue timeout();  
/**
     * Indicates the total number of hits to count accurately.  
    public abstract QueryShardContext getQueryShardContext();  
    @ExperimentalApi
    public LocalBucketCountThresholds asLocalBucketCountThresholds(TermsAggregator.BucketCountThresholds bucketCountThresholds) {  
    }
    private volatile boolean searchTimedOut;
        return 0.01;
        result.append(" query=[").append(query()).append("]");  
    public abstract void addSearchExt(SearchExtBuilder searchExtBuilder);
    public abstract IndexShard indexShard();
import org.opensearch.index.cache.bitset.BitsetFilterCache;  
 * under the License.  
        }
import org.opensearch.search.aggregations.bucket.terms.TermsAggregator;  
    }
 * specific language governing permissions and limitations
    public boolean isStreamSearch() {
        public List<Aggregator> toAggregators(Collection<Collector> collectors) {
import org.opensearch.search.collapse.CollapseContext;
 * not use this file except in compliance with the License.
        this.searchTimedOut = searchTimedOut;
    public abstract DfsSearchResult dfsResult();
import org.opensearch.search.aggregations.bucket.LocalBucketCountThresholds;
    public void addReleasable(Releasable releasable) {
        // Implementations of SearchContext should override this method to actually store the value.  
    /**  
    public abstract int docIdsToLoadSize();  
    public SearchContext includeNamedQueriesScore(boolean includeNamedQueriesScore) {
                }
/*
    public int bucketSelectionStrategyFactor() {
     * A shortcut function to see whether there is a storedFieldsContext and it says the fields are requested.
 * KIND, either express or implied.  See the License for the
     */
     */
    public String getPartitionStrategy() {
        @Override
    @ExperimentalApi
        return innerHitsContext;
     * wrapper of {@link System#nanoTime()} converted to milliseconds.
        return null;
        if (rescore != null) {  
     */
                rescoreDocIds.put(i, docIds);
    public void setStreamChannelListener(StreamSearchChannelListener<SearchPhaseResult, ShardSearchRequest> listener) {
    @Override
    }  
    public abstract SearchContext fetchFieldsContext(FetchFieldsContext fetchFieldsContext);
    }
    public abstract SearchContext trackTotalHitsUpTo(int trackTotalHits);  
    public abstract int from();
    public abstract SearchExtBuilder getSearchExt(String name);
import java.util.List;
    public abstract boolean version();
                final Set<Integer> docIds = rescoreDocIds.getId(i);
    }  
     * since it will produce more cancellation checks it might slow the search performance down.  
@PublicApi(since = "1.0.0")  
    /**
     * The query to execute, might be rewritten.  
        if (searchType() != SearchType.DEFAULT) {
import org.apache.lucene.search.CollectorManager;
import org.opensearch.search.fetch.subphase.FetchFieldsContext;
     * Enabling low-level checks will make long running searches to react to the cancellation request faster. However,
    /**
import org.opensearch.search.streaming.FlushMode;  
        }  
            throw new IllegalStateException("Unexpected toInternalAggregations call on NO_OP_BUCKET_COLLECTOR_PROCESSOR");  
     * @return Returns time in milliseconds that can be used for relative time calculations.  
import java.util.HashMap;
    public abstract SearchType searchType();  
import org.opensearch.search.SearchPhaseResult;
    public String toString() {  
 *
    }
 * Modifications Copyright OpenSearch Contributors. See  
    /**
     */
        final List<RescoreContext> rescore = rescore();
    public abstract Query buildFilteredQuery(Query query);
            result.append("searchType=[").append(searchType()).append("]");  
    }
        }
import org.apache.lucene.search.Query;  
    public abstract int getTargetMaxSliceCount();
     */
     * Should be called before executing the main query and after all other parameters have been set.  
    public abstract StoredFieldsContext storedFieldsContext();  
     * Gets the resolved flush mode for this search context.
    /**  
                    rescore.get(i).setRescoredDocs(docIds);
import org.opensearch.search.SearchExtBuilder;  
    public abstract SearchContext docIdsToLoad(int[] docIdsToLoad, int docsIdsToLoadFrom, int docsIdsToLoadSize);
import org.opensearch.search.fetch.subphase.FetchSourceContext;  
    public abstract int trackTotalHitsUpTo();  
    /**
import java.util.Collection;  
                }  
    public abstract int[] docIdsToLoad();
     * The context related to retrieving fields.  
import org.opensearch.search.aggregations.SearchContextAggregations;
    @ExperimentalApi
    public abstract SortAndFormats sort();
    }
 * GitHub history for details.
    public abstract SearchContext collapse(CollapseContext collapse);  
    public abstract SearchContext searchAfter(FieldDoc searchAfter);
            try {
    /**
    public abstract List<RescoreContext> rescore();  
        return CONCURRENT_SEGMENT_SEARCH_PARTITION_STRATEGY.getDefault(Settings.EMPTY);
     * @param useCache to allow using cached time if true or forcing calling {@link System#nanoTime()} if false
    /**  
    }
    public abstract SearchContext sort(SortAndFormats sort);
            }  
        for (int i = 0; i < rescore.size(); i++) {
    }
        throw new IllegalStateException("Get search channel listener should be implemented for stream search");
import org.opensearch.common.util.BigArrays;
 */
    public abstract boolean lowLevelCancellation();
    public abstract SearchContext aggregations(SearchContextAggregations aggregations);  
    public abstract ScrollContext scrollContext();
    public final RescoreDocIds rescoreDocIds() {
    @ExperimentalApi
    public abstract int numberOfShards();
     * WARN: This is not the epoch time and can be a cached time.  
import org.opensearch.search.SearchService;
import org.opensearch.index.mapper.MappedFieldType;
import org.opensearch.search.fetch.subphase.highlight.SearchHighlightContext;  
            final Set<Integer> docIds = rescore.get(i).getRescoredDocs();
     *  
    /**
        return false;  
    public static final int DEFAULT_TRACK_TOTAL_HITS_UP_TO = 10000;  
        return this.searchTimedOut;  
            shouldUseConcurrentSearch() ? 0 : bucketCountThresholds.getShardMinDocCount(),
 */
    public abstract int docIdsToLoadFrom();
    public StreamSearchChannelListener<SearchPhaseResult, ShardSearchRequest> getStreamChannelListener() {  
import org.opensearch.search.query.ReduceableSearchResult;  
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.common.annotation.ExperimentalApi;
     * Determines whether named queries' scores should be included in the search results.
    /**  
     */
    /**
    public abstract SearchContext docValuesContext(FetchDocValuesContext docValuesContext);  
    public abstract SearchShardTarget shardTarget();
     */  
    public abstract void explain(boolean explain);  
    }  
    public int getPartitionMinSegmentSize() {
     * Returns concurrent segment search status for the search context  
 * You may obtain a copy of the License at  
import org.apache.lucene.search.Collector;  
import org.opensearch.search.aggregations.BucketCollectorProcessor;
 * Licensed to Elasticsearch under one or more contributor  
    public long getStreamingMaxEstimatedBucketCount() {
import org.opensearch.common.lease.Releasable;
    public abstract boolean explain();
    @ExperimentalApi  
     */
    public abstract ParsedQuery parsedPostFilter();  
            throw new IllegalStateException("Unexpected toAggregators call on NO_OP_BUCKET_COLLECTOR_PROCESSOR");  
    public abstract Query query();
    public abstract FetchSourceContext fetchSourceContext();  
    public long getRelativeTimeInMillis(boolean useCache) {
        }
    }
        return CONCURRENT_SEGMENT_SEARCH_PARTITION_MIN_SEGMENT_SIZE.getDefault(Settings.EMPTY);  
    public double getStreamingMinCardinalityRatio() {  
 * state from one query / fetch phase to another.
    // no-op bucket collector processor
    public abstract boolean hasFetchSourceContext();
        return 0;  
    public int maxAggRewriteFilters() {  
                if (docIds != null) {  
                    rescoreDocIds = new HashMap<>();
    public InnerHitsContext innerHits() {
    public abstract FetchDocValuesContext docValuesContext();
     */
    public abstract ShardSearchRequest request();
    @Override
    public abstract float queryBoost();  
    public abstract void suggest(SuggestionSearchContext suggest);
import org.opensearch.common.lease.Releasables;
    public abstract FetchPhase fetchPhase();
 * ownership. Elasticsearch licenses this file to you under  
        }
        if (innerHitsContext == null) {
    /**
        }
            } finally {  
    public abstract ContextIndexSearcher searcher();  
    public abstract SimilarityService similarityService();  
    public CardinalityAggregationContext cardinalityAggregationContext() {  
    public static final int TRACK_TOTAL_HITS_ACCURATE = Integer.MAX_VALUE;
import org.opensearch.index.shard.IndexShard;  
    }  
     * Given the full name of a field, returns its {@link MappedFieldType}.
    public abstract boolean isCancelled();  
 *    http://www.apache.org/licenses/LICENSE-2.0
     */
     * Returns local bucket count thresholds based on concurrent segment search status
        throw new IllegalStateException("Set search channel listener should be implemented for stream search");
    public abstract ParsedQuery parsedQuery();  
    public abstract SearchContext from(int from);  
        return false;  
    }
                Releasables.close(releasables);
    public abstract void setTask(SearchShardTask task);
    public abstract void preProcess(boolean rewrite);  
     */  
        if (closed.compareAndSet(false, true)) {  
    public abstract int terminateAfter();
        return false;  
            }
    public boolean setFlushModeIfAbsent(FlushMode flushMode) {  
     * @param includeNamedQueriesScore true to include scores from named queries, false otherwise.
            bucketCountThresholds.getShardSize()  
     * Atomically sets the flush mode if not already set. Returns true if successful.  
    /**
            }
        return TimeValue.nsecToMSec(System.nanoTime());  
    private final List<Releasable> releasables = new CopyOnWriteArrayList<>();
    public abstract Query aliasFilter();
    }
    }
import org.opensearch.search.SearchShardTarget;  
import org.opensearch.search.rescore.RescoreContext;
 * compatible open source license.
     */
     */
            for (int i = 0; i < rescore.size(); i++) {
        }
    public abstract boolean hasStoredFieldsContext();
import org.opensearch.common.unit.TimeValue;
            }
     * Returns time in milliseconds that can be used for relative time calculations.
    public abstract SearchHighlightContext highlight();  
        return SearchService.DEFAULT_BUCKET_SELECTION_STRATEGY_FACTOR;
     * @return true if scores from named queries are included, false otherwise.
    public final boolean hasOnlySuggest() {
    }
     * Evaluates whether this request should use intra-segment search based on query and aggregation analysis.
        }  
    /**
import org.opensearch.index.similarity.SimilarityService;
    }
    public abstract ReaderContext readerContext();
        if (useCache) {  
import org.opensearch.index.mapper.ObjectMapper;  
     */
    public boolean shouldUseConcurrentSearch() {
    public abstract void timeout(TimeValue timeout);
    }
import org.opensearch.search.profile.Profilers;
    public abstract FetchSearchResult fetchResult();
    // processor used for bucket collectors
     * Returns time in milliseconds that can be used for relative time calculations. this method will fall back to
    /**
 * @opensearch.api
     * Sets the context related to retrieving fields.
     *  alias filters, types filters, etc. */  
    public abstract boolean shouldUseTimeSeriesDescSortOptimization();  
        // Implementations of SearchContext should override this method to return the actual value.
public abstract class SearchContext implements Releasable {
    public abstract SearchContext parsedPostFilter(ParsedQuery postFilter);
 * this file be licensed under the Apache-2.0 license or a
import static org.opensearch.search.SearchService.CONCURRENT_SEGMENT_SEARCH_PARTITION_STRATEGY;  
     */
    public int filterRewriteSegmentThreshold() {
    /**
    public abstract QuerySearchResult queryResult();  
import org.opensearch.index.query.ParsedQuery;
    /** Return a view of the additional query collector managers that should be run for this context. */  
    /**
    }
    };
    public abstract SuggestionSearchContext suggest();
    public abstract String source();
    /**  
    public abstract CollapseContext collapse();
import org.opensearch.index.mapper.MapperService;
        return 1000L;  
        return request().source() != null && request().source().isSuggestOnly();  
    public FlushMode getFlushMode() {
import java.util.Set;
     * <p>
    public abstract FieldDoc searchAfter();
}  
    public abstract BitsetFilterCache bitsetFilterCache();
     * {@link SearchContext#getRelativeTimeInMillis()} (which might be a cached time) if useCache was set to true else it will be just be a  
    public abstract boolean sourceRequested();
import org.opensearch.search.aggregations.InternalAggregation;  
        return rescoreDocIds == null ? RescoreDocIds.EMPTY : new RescoreDocIds(rescoreDocIds);
    public abstract Profilers getProfilers();  
        return false;  
    public abstract InternalAggregation.ReduceContext partialOnShard();  
import org.opensearch.search.suggest.SuggestionSearchContext;
    }
    public abstract long getRelativeTimeInMillis();
 *  
     *
     * Checks if scores from named queries are included in the search results.
        StringBuilder result = new StringBuilder().append(shardTarget());
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.search.sort.SortAndFormats;
 */  
    public abstract MapperService mapperService();
import org.opensearch.search.fetch.FetchPhase;
    }  
    public abstract SearchContext storedFieldsContext(StoredFieldsContext storedFieldsContext);
        @Override  
     * By default, this is set to return false, indicating that scores from named queries are not included.  
        return false;
import java.util.Map;  
        return 0;
    }
 * license agreements. See the NOTICE file distributed with
    @ExperimentalApi  
    /**
        // Default implementation returns false.
    @Nullable
    }  
            if (docIds != null && docIds.isEmpty() == false) {  
            // do nothing as there is no aggregation collector  
    public abstract SearchShardTask getTask();
            // should not be called when there is no aggregation collector
/*
        if (scrollContext() != null) {
    public abstract SearchContext fetchSourceContext(FetchSourceContext fetchSourceContext);
    public abstract SearchContext trackScores(boolean trackScores);  
import org.opensearch.search.dfs.DfsSearchResult;  
        return false;
                result.append("scroll=[null]");  
    public abstract Map<Class<?>, CollectorManager<? extends Collector, ReduceableSearchResult>> queryCollectorManagers();
        return 100_000L;
    public abstract void seqNoAndPrimaryTerm(boolean seqNoAndPrimaryTerm);  
import org.opensearch.search.aggregations.metrics.CardinalityAggregationContext;
    public final void assignRescoreDocIds(RescoreDocIds rescoreDocIds) {
    public abstract SearchContext parsedQuery(ParsedQuery query);
        if (rescore == null) {  
    }
     * A shortcut function to see whether there is a fetchSourceContext and it says the source is requested.  
    public abstract SearchContextAggregations aggregations();
    public abstract int size();
        return 30_000L;  
        );
        return 0;
 * this work for additional information regarding copyright
        return false;  
    public abstract ShardSearchContextId id();  
 */
    public abstract void groupStats(List<String> groupStats);
    public boolean shouldUseIntraSegmentSearch() {  
    public abstract boolean hasStoredFields();  
            if (scrollContext().scroll != null) {  
    public static final BucketCollectorProcessor NO_OP_BUCKET_COLLECTOR_PROCESSOR = new BucketCollectorProcessor() {  
    public abstract void setBucketCollectorProcessor(BucketCollectorProcessor bucketCollectorProcessor);  
    public void setSearchTimedOut(boolean searchTimedOut) {  
    public abstract boolean hasScriptFields();
    public int cardinalityAggregationPruningThreshold() {  
import org.opensearch.action.support.StreamSearchChannelListener;  
    public abstract List<String> groupStats();  
     * @return list of all rescore contexts.  empty if there aren't any.
package org.opensearch.search.internal;
 *
    /**
    public abstract MappedFieldType fieldType(String name);  
import org.opensearch.search.aggregations.Aggregator;
    }
    public final void close() {
import static org.opensearch.search.SearchService.CONCURRENT_SEGMENT_SEARCH_PARTITION_MIN_SEGMENT_SIZE;
    @ExperimentalApi
        // Default implementation does nothing and returns this for chaining.
            innerHitsContext = new InnerHitsContext();  
                result.append("scroll=[").append(scrollContext().scroll.keepAlive()).append("]");
import java.util.concurrent.atomic.AtomicBoolean;  
     */
     * @param rewrite if the set query should be rewritten against the searcher returned from {@link #searcher()}
     */  
import org.opensearch.search.fetch.subphase.ScriptFieldsContext;
     */
     */
        @Override  
import org.opensearch.search.RescoreDocIds;
    protected SearchContext() {}  
        final List<RescoreContext> rescore = rescore();
    public abstract BigArrays bigArrays();
    @ExperimentalApi
     * Indicates if the current index should perform frequent low level search cancellation check.  
    public abstract boolean trackScores();
import java.util.concurrent.CopyOnWriteArrayList;
    private InnerHitsContext innerHitsContext;  
    /**
        return this;
