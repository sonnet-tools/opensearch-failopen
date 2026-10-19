        );
            if (!fetchResults.isEmpty()) {
    public static final class ReducedQueryPhase {  
        float getMaxScore() {
            float maxScore,  
            TotalHits totalHits,
import org.apache.lucene.search.Sort;
    /**  
            } else {  
            if (shardDocIdsToLoad == null) {
        final Map<String, CollectionStatistics> fieldStatistics = new HashMap<>();
                    this.terminatedEarly = terminatedEarly;  
     *
     */
            boolean isFloat = firstType == SortField.Type.FLOAT || firstType == SortField.Type.DOUBLE;
            shardDocIdsToLoad.add(shardDoc.doc);
            public ReduceContext forFinalReduction() {
    /**
                        ScoreDoc shardDoc = sortedDocs[scoreDocIndex];  
                        existingProfile.getAggregationProfileResults(),  
            executor,
    ) {
        } else {
            }
package org.opensearch.action.search;
     * Sort queries on a field that has long type in one index, and unsigned_long in another index
        }
            numReducePhases,  
            final TermStatistics[] stats = lEntry.termStatistics();  
        }
     *  
    /**
            if (trackTotalHitsUpTo != SearchContext.TRACK_TOTAL_HITS_DISABLED) {  
                    );  
                    if (ulFormats[i] ^ (formats[i] == DocValueFormat.UNSIGNED_LONG_SHIFTED || formats[i] == DocValueFormat.UNSIGNED_LONG)) {
        if (reducedQueryPhase.isEmptyResult == false) {
 * Controller for the search phase.  
        for (ScoreDoc shardDoc : shardDocs) {
            for (int i = 0; i < sortFields.length; i++) {
            }
            size = Math.min(sortedScoreDocs.length, size);  
    }  
        IntFunction<SearchPhaseResult> resultsLookup
        ) {
 */
            }  
        final List<CompletionSuggestion> reducedCompletionSuggestions;
            reducedCompletionSuggestions = Collections.emptyList();
        SearchHits hits = getHits(reducedQueryPhase, ignoreFrom, fetchResults, resultsLookup);
import org.opensearch.search.profile.SearchProfileShardResults;  
            }
                if (existingProfile != null) {
        SearchProgressListener listener,  
            }  
        final SearchProfileShardResults shardResults;
                    // result from fetch.  
import org.opensearch.search.SearchHits;
        int sortScoreIndex = -1;
/**
                assert result.hasConsumedTopDocs() : "firstResult has no aggs but we got non null buffered aggs?";
            @Override  
            List<Integer> shardDocIdsToLoad = docIdsToLoad[shardDoc.shardIndex];  
        return new AggregatedDfs(termStatistics, fieldStatistics, aggMaxDoc);  
            mergedTopDocs = TopDocs.merge(sort, from, topN, shardTopDocs);
        private float maxScore = Float.NEGATIVE_INFINITY;  
     * Checks that query results from all shards have consistent unsigned_long format.  
            for (var entry : lEntry.fieldStatistics().entrySet()) {
        // the reduced profile results  
                        completionSuggestion.setShardIndex(result.getShardIndex());
        IntFunction<SearchPhaseResult> resultsLookup
            }
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
        assert topDocs.scoreDocs.length == 0 || topDocs.scoreDocs[0].shardIndex == -1 : "shardIndex is already set";
     * @return merged profile results containing both query and fetch phase data
        }
        } else if (topDocs instanceof TopFieldDocs) {
         * @see #merge(boolean, ReducedQueryPhase, Collection, IntFunction)
        } else {
}
                        existing.maxDoc() + value.maxDoc(),  
     * the result. In oder to obtain stable results the shard index (index of the result in the result array) must be the same.  
        final SearchProfileShardResults shardResults = profileResults.isEmpty() ? null : new SearchProfileShardResults(profileResults);
            if (requireWiden) {  
        final Suggest reducedSuggest;  
                        suggestOption.setHit(hit);
     * @param bufferedTopDocs a list of pre-collected top docs.
        boolean ignoreFrom,  
    }
        TopDocsStats(int trackTotalHitsUpTo) {
import org.opensearch.search.SearchService;
import org.opensearch.search.suggest.Suggest.Suggestion;
    }
    ReducedQueryPhase reducedQueryPhase(  
        // the reduced suggest results
                        existing.sumDocFreq() + value.sumDocFreq()  
                }  
     * Creates Sort object from topFieldsDocs fields.
                if (sortFields[i].getType() == SortField.Type.SCORE) {
        SearchProgressListener listener,
            this.scoreDocs = scoreDocs;
            reducedSuggest = new Suggest(Suggest.reduce(groupedSuggestions));  
     * <p>  
        return lastEmittedDocPerShard;  
    static TopDocs mergeTopDocs(Collection<TopDocs> results, int topN, int from) {
     * in case of mapping field change for newly indexed data.
import org.opensearch.core.common.breaker.CircuitBreaker;  
    static SortedTopDocs sortDocs(
        final QuerySearchResult firstResult = queryResults.stream().findFirst().get().queryResult();  
            ? null
        }  
import org.apache.lucene.search.TopFieldDocs;
                isSortedByField = (fieldDocs.fields.length == 1 && fieldDocs.fields[0].getType() == SortField.Type.SCORE) == false;
            topDocsStats.getMaxScore(),
                    // if the format is unsigned_long in one shard, and something different in another shard  
        Collection<? extends SearchPhaseResult> fetchResults,  
            aggregations,
        if (!fetchResults.isEmpty()) {
                        new TermStatistics(  
        };
                if (existing != null) {  
            }
                ? controller.mergeFetchProfiles(shardResults, fetchResults)  
import java.util.List;
            Suggest suggest,  
    /**
     * @param queryResults a list of non-null query shard results
            executor,
                    }
            return Float.isInfinite(maxScore) ? Float.NaN : maxScore;
     * Returns a score doc array of top N search docs across all shards, followed by top suggest docs for each
            DocValueFormat[] formats = entry.queryResult().sortValueFormats();  
         * @param fetchResults the fetch results to merge profiles from
import org.opensearch.search.aggregations.InternalAggregation.ReduceContext;  
            for (int sortedDocsIndex = 0; sortedDocsIndex < size; sortedDocsIndex++) {
            SearchProfileShardResults mergedProfileResults = shardResults != null
            SortedTopDocs sortedTopDocs,  
        }
                for (CompletionSuggestion suggestion : reducedQueryPhase.suggest.filter(CompletionSuggestion.class)) {  
                CollapseTopFieldDocs collapseTopFieldDocs = (CollapseTopFieldDocs) fieldDocs;  
            namedWriteableRegistry,
     */
            totalHits,
            if (trackTotalHitsUpTo == SearchContext.TRACK_TOTAL_HITS_DISABLED) {  
                    + fetchResult.hits().getHits().length;  
                    }  
        Collection<? extends SearchPhaseResult> queryResults,
        int numShards,
    /**  
        boolean[] ulFormats = null;  
        public InternalSearchResponse buildResponse(  
 * The OpenSearch Contributors require contributions made to  
            } else {
        }
                ProfileShardResult existingProfile = mergedResults.get(shardId);
                    termStatistics.put(terms[i], stats[i]);
                        )
     * @param bufferedAggs a list of pre-collected aggregations.  
                }
            if (bufferedTopDocs.isEmpty() == false) {  
        // the offset into the merged top hits
        final int from;
                    CollectionStatistics merged = new CollectionStatistics(
                        hit.shard(fetchResult.getSearchShardTarget());  
                totalHits,  
                        CompletionSuggestion completionSuggestion = (CompletionSuggestion) suggestion;
            this.from = from;  
        // clean the fetch counter
        final Map<String, List<Suggestion>> groupedSuggestions = hasSuggest ? new HashMap<>() : Collections.emptyMap();
                }
                lastEmittedDocPerShard[scoreDoc.shardIndex] = scoreDoc;  
    ) {
            doc.shardIndex = shardIndex;
            this,  
     */  
        }  
            isTaskCancelled
            public ReduceContext forPartialReduction() {
                collapseValues = collapseTopFieldDocs.collapseValues;
        }  
import java.util.Collections;  
                    );
                        existing.docCount() + value.docCount(),
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            firstResult.sortValueFormats(),
        return toReduce.isEmpty()  
        private TotalHits.Relation totalHitsRelation;
        final Boolean terminatedEarly;
        Consumer<Exception> onPartialMergeFailure  
        }
                final int index = fetchResult.counterGetAndIncrement();
        int size,  
        final InternalAggregations aggregations;
    static int getTopDocsSize(SearchRequest request) {  
        // count the total (we use the query result provider here, since we might not get any hits (we scrolled past them))
     * Returns a new {@link QueryPhaseResultConsumer} instance that reduces search responses incrementally.
            Object[] collapseValues
     */
                ? ((SortedNumericSortField) sortField).getNumericType()
            for (CompletionSuggestion completionSuggestion : reducedCompletionSuggestions) {  
                     * so we return this lower bound when the total hits is greater than this value.
        SortField[] sortFields = null;
        long totalHits;  
import org.opensearch.search.builder.SearchSourceBuilder;
    }
                CollectionStatistics existing = fieldStatistics.get(key);
        }
    private static final ScoreDoc[] EMPTY_DOCS = new ScoreDoc[0];
                String key = result.getSearchShardTarget().toString();
            ? new HashMap<>(queryResults.size())
                }
     * Returns the size of the requested top documents (from + size)
        } else if (topDocs instanceof CollapseTopFieldDocs) {
            }
            this.totalHitsRelation = Relation.EQUAL_TO;
            hits.toArray(new SearchHit[0]),
        final SortField[] sortFields;
        SearchRequest request,
            return new InternalSearchResponse(
                    totalHitsRelation = TotalHits.Relation.GREATER_THAN_OR_EQUAL_TO;  
            aggMaxDoc += lEntry.maxDoc();
            boolean requireWiden = false;  
import org.apache.lucene.search.TotalHits;
                            existing.totalTermFreq() + stats[i].totalTermFreq()  
/*
        BooleanSupplier isTaskCancelled  
            sortedTopDocs.sortFields,
     */
        if (groupedSuggestions.isEmpty()) {
            // from is always zero as when we use scroll, we ignore from  
            sortedTopDocs,
            boolean isSortedByField,
            request,  
            assert !lEntry.fieldStatistics().containsKey(null);  
                     * This can happen when multiple shards are merged since the limit to track total hits  
     * @param topDocs the buffered top docs
            listener,
        final boolean isEmptyResult;  
    }  
            from,
import org.opensearch.search.suggest.completion.CompletionSuggestion;
                            // result from fetch.
        boolean ignoreFrom,
        // with collapsing we can have more fetch hits than sorted docs
            onPartialMergeFailure,
                SortField.Type sortType = getSortType(sortField);
    public List<Integer>[] fillDocIdsToLoad(int numShards, ScoreDoc[] shardDocs) {  
                    assert terms[i].bytes().equals(existing.term());  
            }
 * You may obtain a copy of the License at  
import org.opensearch.search.fetch.FetchSearchResult;
        boolean isScrollRequest,  
        final List<Integer>[] docIdsToLoad = (List<Integer>[]) new ArrayList<?>[numShards];
        final InternalAggregations aggregations = reduceAggs(aggReduceContextBuilder, performFinalReduce, bufferedAggs);  
        // the reduced internal aggregations
        /**
            this.fetchHits = fetchHits;
        static final SortedTopDocs EMPTY = new SortedTopDocs(EMPTY_DOCS, false, null, null, null);
 * compatible open source license.
                shardDocIdsToLoad = docIdsToLoad[shardDoc.shardIndex] = new ArrayList<>();
     * Returns a new {@link QueryPhaseResultConsumer} instance that reduces search responses incrementally.  
            circuitBreaker,
import org.opensearch.search.sort.SortedWiderNumericSortField;
            this.numReducePhases = numReducePhases;  
     * @param fetchResults the fetch phase results to merge profiles from
            SearchPhaseController controller  
            listener,
                        searchHit.score(((Number) fieldDoc.fields[sortScoreIndex]).floatValue());
        Executor executor,
    }
     * support sort optimization, we removed type widening there and taking care here during merging.
        final float maxScore;  
            }  
            }  
     * <p>
import org.opensearch.search.SearchHit;
                SearchHit searchHit = fetchResult.hits().getHits()[index];
            fetchHits += topDocs.topDocs.scoreDocs.length;  
            reducedQueryPhase.totalHits,
                }
import org.opensearch.search.dfs.AggregatedDfs;  
                    List<Suggestion> suggestionList = groupedSuggestions.computeIfAbsent(suggestion.getName(), s -> new ArrayList<>());
    StreamQueryPhaseResultConsumer newStreamSearchPhaseResults(  
        SearchRequest request,  
        if (numShards == 1 && from == 0) { // only one shard and no pagination we can just return the topDocs as we got them.
                toReduce,  
            final Term[] terms = lEntry.terms();
        if (sortField.getComparatorSource() instanceof IndexFieldData.XFieldComparatorSource) {  
     *                   Enabled only for scroll search, because that only retrieves hits of length 'size' in the query phase.  
        SortedTopDocs(  
        TotalHits getTotalHits() {
            ScoreDoc[] scoreDocs,
    }
                totalHits += topDocs.topDocs.totalHits.value();
/*  
    }  
                ProfileShardResult fetchProfile = fetchResult.fetchResult().getProfileResults();
    }
            }
            if (firstResult) {
 * GitHub history for details.
                    // in this case we referenced the shard result via the ScoreDoc but never got a
     * request, the suggest docs for a named suggestion are ordered by the suggestion name.  
            int size,  
     * Returns a new {@link StreamQueryPhaseResultConsumer} instance that reduces search responses incrementally.
            for (CompletionSuggestion completionSuggestion : reducedCompletionSuggestions) {
            }
            }
                    termStatistics.put(
        return requestToAggReduceContextBuilder.apply(request.source());  
                }
        // the searches merged top docs  
        // the max score across all reduces hits or {@link Float#NaN} if no hits returned
        final TotalHits totalHits = topDocsStats.getTotalHits();  
        return reducedQueryPhase(queryResults, Collections.emptyList(), topDocs, topDocsStats, 0, true, aggReduceContextBuilder, true);  
                return null;
                    // this can happen if we are hitting a shard failure during the fetch phase
    QueryPhaseResultConsumer newSearchPhaseResults(
    static final class TopDocsStats {
            SortField[] sortFields = sortedTopDocs.sortFields;  
        int numReducePhases,
import org.apache.lucene.search.TotalHits.Relation;  
import org.apache.lucene.search.CollectionStatistics;
                String key = entry.getKey();
                throw new IllegalArgumentException("at least one reduce phase must have been applied but was: " + numReducePhases);
        List<InternalAggregations> bufferedAggs,
    ) {
                }
        this.namedWriteableRegistry = namedWriteableRegistry;
                    ulFormats[i] = (formats[i] == DocValueFormat.UNSIGNED_LONG_SHIFTED || formats[i] == DocValueFormat.UNSIGNED_LONG)  
                            // in this case we referenced the shard result via the ScoreDoc but never got a
    /**
     * Merges fetch phase profile results with query phase profile results.
 * Unless required by applicable law or agreed to in writing,
                            + index  
                timedOut,
        boolean isSortedByField = false;  
                        terms[i],
                    firstTopDocFields[fieldIndex].getReverse()
            assert terms.length == stats.length;
 * Licensed to Elasticsearch under one or more contributor  
        final List<TopDocs> topDocs = new ArrayList<>();  
        final TopDocs topDocs = results.stream().findFirst().get();
            this.sortFields = sortFields;  
        }
 * license agreements. See the NOTICE file distributed with
                            // this can happen if we are hitting a shard failure during the fetch phase  
 * KIND, either express or implied.  See the License for the
        final ScoreDoc[] scoreDocs;
                assert terms[i] != null;  
        return new Sort(newFields);
            return sortField instanceof SortedNumericSortField  
                ScoreDoc shardDoc = sortedTopDocs.scoreDocs[i];
                    continue;
    }
        final boolean isSortedByField;  
        // merge hits  
                null,  
        return new ReducedQueryPhase(
    ) {  
            sortFields = fieldDocs.fields;  
import org.apache.lucene.search.ScoreDoc;
            } else if (trackTotalHitsUpTo == SearchContext.TRACK_TOTAL_HITS_ACCURATE) {
        }  
    ) {
                if (existing != null) {
                     * is applied per shard.
                        SearchPhaseResult searchResultProvider = resultsLookup.apply(shardDoc.shardIndex);
        Consumer<Exception> onPartialMergeFailure,
                false,  
                isSortedByField = true;
                    fieldStatistics.put(key, value);
            Boolean terminatedEarly,
    private static InternalAggregations reduceAggs(
            ? SearchService.DEFAULT_FROM  
        }  
            sortedTopDocs.collapseValues  
                } else if (terminatedEarly) {
     * @param numReducePhases the number of non-final reduce phases applied to the query results.
        }  
                topDocsStats.fetchHits,
        final long fetchHits;
                    }
                    return new TotalHits(totalHits, totalHitsRelation);
        long aggMaxDoc = 0;  
            }  
                    }  
    }
        void add(TopDocsAndMaxScore topDocs, boolean timedOut, Boolean terminatedEarly) {
                    continue;
                this.timedOut = true;
     * It is necessary to widen the SortField.Type to maximum byte size for merging sorted docs.
import java.util.function.Consumer;  
        List<InternalAggregations> toReduce
                if (topDocs.topDocs.totalHits.relation() == Relation.GREATER_THAN_OR_EQUAL_TO) {
    private final Function<SearchSourceBuilder, InternalAggregation.ReduceContextBuilder> requestToAggReduceContextBuilder;
    static void setShardIndex(TopDocs topDocs, int shardIndex) {
    }
                        }
            }  
                        existingProfile.getQueryProfileResults(),
            int from,
            topDocsStats.terminatedEarly,  
        final TopDocsStats topDocsStats = new TopDocsStats(SearchContext.TRACK_TOTAL_HITS_ACCURATE);
import org.apache.lucene.index.Term;
            final CollapseTopFieldDocs[] shardTopDocs = results.toArray(new CollapseTopFieldDocs[numShards]);
    ) {
                            + "] length: "
            if (td.topDocs.scoreDocs.length > 0) {
            }
        return (source.size() == -1 ? SearchService.DEFAULT_SIZE : source.size()) + (source.from() == -1
            for (int i = 0; i < numSearchHits; i++) {  
                assert currentOffset == sortedDocs.length : "expected no more score doc slices";
                profileResults.put(key, result.consumeProfileResult());
                isFloat = isFloat || sortType == SortField.Type.FLOAT || sortType == SortField.Type.DOUBLE;  
        // the number of returned hits (doc IDs) across all reduces shards  
        ReducedQueryPhase reducedQueryPhase,  
            SearchHits hits,
            );
        final Suggest suggest;  
 *  
        }
        ) {  
    ) {
        }
/*  
    InternalAggregation.ReduceContextBuilder getReduceContext(SearchRequest request) {
                }  
            sortedTopDocs.collapseField,
 * not use this file except in compliance with the License.
            return SortedTopDocs.EMPTY;
                    // Merge fetch profile data into existing query profile  
            if (!Float.isNaN(topDocs.maxScore)) {
                continue;  
            onPartialMergeFailure
                if (stats[i] == null) {
import java.util.function.IntFunction;
import org.opensearch.search.internal.InternalSearchResponse;  
     * @param queryResults a list of non-null query shard results  
     * merges suggestions, aggregations and profile results
                for (int i = 0; i < formats.length; i++) {
        if (reducedQueryPhase.suggest != null) {  
     * Enriches search hits and completion suggestion hits from <code>sortedDocs</code> using <code>fetchResultsArr</code>,
            // make sure we set the shard index before we add it - the consumer didn't do that yet  
            topDocsStats.add(td, queryResult.searchTimedOut(), queryResult.terminatedEarly());
            int offset = mergedScoreDocs.length;
        String collapseField = null;
        boolean ignoreFrom,
                }
        if (topDocs.isEmpty() && reducedCompletionSuggestions.isEmpty()) {  
            size,
        final boolean timedOut;
    public AggregatedDfs aggregateDfs(Collection<DfsSearchResult> results) {  
        for (SearchPhaseResult entry : fetchResults) {
            }
            if (fetchResult.fetchResult() != null && fetchResult.fetchResult().getProfileResults() != null) {  
            @Override
        int size = 0;
                0,  
import org.opensearch.index.fielddata.IndexFieldData;
            for (int i = 0; i < terms.length; i++) {
        return reducedQueryPhase.buildResponse(hits, fetchResults, this);  
     */
     * The reduced query phase
                    currentOffset += suggestionOptions.size();  
        boolean firstResult = true;
        }
                            continue;
        final SortField[] newFields = new SortField[firstTopDocFields.length];
                ulFormats = new boolean[formats.length];
                        if (searchResultProvider == null) {
    /**
                assert totalHitsRelation == Relation.EQUAL_TO;  
            }
        SearchProgressListener listener,  
        }  
         * Creates a new search response from the given merged hits with fetch profile merging.  
    // TODO: should we check the compatibility between types
        // non null and true if at least one reduced result was terminated early  
        if (queryResults.isEmpty()) {
import org.apache.lucene.search.TopDocs;  
        }
            final Sort sort = createSort(shardTopDocs);  
                            existing.docFreq() + stats[i].docFreq(),
        // the number of reduces phases
            Collection<? extends SearchPhaseResult> fetchResults,
        validateMergeSortValueFormats(queryResults);
        for (SearchPhaseResult entry : queryResults) {
                        CompletionSuggestion.Entry.Option suggestOption = suggestionOptions.get(scoreDocIndex - currentOffset);
        final int trackTotalHitsUpTo;
            circuitBreaker,
        boolean performFinalReduce,  
            int numReducePhases,
        // <code>true</code> if at least one reduced result timed out
     * @see QuerySearchResult#consumeProfileResult()
    /**
         * @param hits the merged search hits
        return new SearchHits(  
                    + index
        CircuitBreaker circuitBreaker,
     * The top docs statistics  
            } else {
        return mergedTopDocs;
        boolean performFinalReduce
        }  
        final Map<String, ProfileShardResult> profileResults = hasProfileResults  
                            existing.term(),
            namedWriteableRegistry,
        final TopDocs mergedTopDocs = mergeTopDocs(topDocs, size, ignoreFrom ? 0 : from);  
                terminatedEarly,
            return SearchService.DEFAULT_SIZE;
        numSearchHits = Math.min(sortedTopDocs.scoreDocs.length, numSearchHits);
    private static Sort createSort(TopFieldDocs[] topFieldDocs) {
     */
                        existing.sumTotalTermFreq() + value.sumTotalTermFreq(),
        InternalAggregation.ReduceContextBuilder aggReduceContextBuilder,
        final boolean hasProfileResults = firstResult.hasProfileResults();
            this.maxScore = maxScore;  
            this.terminatedEarly = terminatedEarly;
                assert result.suggest() != null;
        final int size;
        Map<String, ProfileShardResult> mergedResults = new HashMap<>(queryProfiles.getShardResults());
            assert td != null;
            request,  
                assert index < fetchResult.hits().getHits().length : "not enough hits fetched. index ["  
        numReducePhases++; // increment for this phase
            int numSuggestDocs = 0;
 * software distributed under the License is distributed on an
            numShards,  
                    );
                        SearchHit hit = fetchResult.hits().getHits()[index];  
import org.opensearch.search.suggest.Suggest;  
                    return new TotalHits(trackTotalHitsUpTo, Relation.GREATER_THAN_OR_EQUAL_TO);  
                if (value == null) {
        // <code>true</code> iff the result score docs is sorted by a field (not score), this implies that <code>sortField</code> is set.
     */  
public final class SearchPhaseController {
                    requireWiden = false;
        boolean timedOut;
                assert key != null;
            this.isSortedByField = isSortedByField;
            return null;  
            throw new IllegalStateException(errorMsg);  
        }
                firstResult = false;  
            : source.from());
     * Note: The order of the sorted score docs depends on the shard index in the result array if the merge process needs to disambiguate
                CollectionStatistics value = entry.getValue();  
     *
            if (timedOut) {
            boolean timedOut,
        InternalAggregation.ReduceContextBuilder aggReduceContextBuilder = new InternalAggregation.ReduceContextBuilder() {  
                }  
                }  
import java.util.Map;  
        for (ScoreDoc doc : topDocs.scoreDocs) {  
            mergedTopDocs = TopDocs.merge(from, topN, shardTopDocs);
    private SearchHits getHits(  
import java.util.stream.Collectors;  
            final Sort sort = createSort(shardTopDocs);
     * @opensearch.internal
        final DocValueFormat[] sortValueFormats;
                    for (int scoreDocIndex = currentOffset; scoreDocIndex < currentOffset + suggestionOptions.size(); scoreDocIndex++) {
                String shardId = fetchResult.getSearchShardTarget().toString();
                setShardIndex(td.topDocs, queryResult.getShardIndex());
     * @opensearch.internal
import org.apache.lucene.search.TermStatistics;
                ScoreDoc scoreDoc = sortedScoreDocs[sortedDocsIndex];
        }
import org.opensearch.search.query.QuerySearchResult;
        SortedTopDocs sortedTopDocs = reducedQueryPhase.sortedTopDocs;  
            SearchProfileShardResults shardResults,
 * under the License.  
        // the sum of all hits across all reduces shards
    /**  
                : null;
        long fetchHits;
        final SortedTopDocs sortedTopDocs = sortDocs(isScrollRequest, bufferedTopDocs, from, size, reducedCompletionSuggestions);
                    searchHit.score(shardDoc.score);
    /**  
    public ScoreDoc[] getLastEmittedDocPerShard(ReducedQueryPhase reducedQueryPhase, int numShards) {
            InternalAggregations aggregations,
        if (results.isEmpty()) {
        return new SearchProfileShardResults(mergedResults);  
            if (terminatedEarly != null) {
                    ProfileShardResult merged = new ProfileShardResult(
            this.totalHits = 0;  
            this.totalHits = totalHits;
            // sorted queries can set the size to 0 if they have enough competitive hits.
        // reduce suggest
        queryResults = queryResults.stream().filter(res -> res.queryResult().isNull() == false).collect(Collectors.toList());
            );
    /**  
                SearchPhaseResult fetchResultProvider = resultsLookup.apply(shardDoc.shardIndex);
            reducedSuggest,
            this.sortValueFormats = sortValueFormats;
                } else {
                maxScore = Math.max(maxScore, topDocs.maxScore);
     * Expects sortedDocs to have top search docs across all shards, optionally followed by top suggest docs for each named
     */  
    public SearchPhaseController(
 *
                        assert index < fetchResult.hits().getHits().length : "not enough hits fetched. index ["
                searchHit.shard(fetchResult.getSearchShardTarget());
     * @opensearch.internal
            reducedSuggest = null;  
                    if (sortScoreIndex != -1) {  
            if (formats == null) return;
        int from = 0;  
        // sort value formats used to sort / format the result  
        ReducedQueryPhase(  
import java.util.function.Function;
     * //TODO: instead of throwing error, find a way to sort long and unsigned_long together  
                for (Suggestion<? extends Suggestion.Entry<? extends Suggestion.Entry.Option>> suggestion : result.suggest()) {  
                    isFloat ? SortField.Type.DOUBLE : SortField.Type.LONG,  
        // <code>true</code> iff the query phase had no results. Otherwise <code>false</code>
        final Collection<TopDocs> topDocs,
                    if (suggestion instanceof CompletionSuggestion) {  
                mergedProfileResults,  
                        throw new IllegalArgumentException(
            System.arraycopy(mergedScoreDocs, 0, scoreDocs, 0, mergedScoreDocs.length);
        return newSearchPhaseResults(executor, circuitBreaker, listener, request, numShards, onPartialMergeFailure, () -> false);
        return docIdsToLoad;  
                numSuggestDocs += completionSuggestion.getOptions().size();
    }
    }  
        int total = queryResults.size();
                : sortField.getType();
import org.apache.lucene.search.SortField;  
        ReducedQueryPhase reducedQueryPhase,
                FetchSearchResult fetchResult = fetchResultProvider.fetchResult();
     * This will support Int to Long and Float to Double.
        final boolean hasSuggest = firstResult.suggest() != null;
        final int numShards = results.size();
            DocValueFormat[] sortValueFormats,
import java.util.HashMap;
                topDocs.add(td.topDocs);  
        NamedWriteableRegistry namedWriteableRegistry,
            return new ReducedQueryPhase(
            if (numReducePhases <= 0) {
    }
                    + "] length: "
        );
        }
                null,
import java.util.concurrent.Executor;
                null,
                suggest,
        SearchSourceBuilder source = request.source();
     * @param from the offset into the search results top docs
        final ScoreDoc[] mergedScoreDocs = mergedTopDocs == null ? EMPTY_DOCS : mergedTopDocs.scoreDocs;
     * Reduces the given query results and consumes all aggregations and profile results.
                }
            return ((IndexFieldData.XFieldComparatorSource) sortField.getComparatorSource()).reducedType();
     * Top docs that have been sorted  
        }
        for (SearchPhaseResult sortedResult : queryResults) {
         */
            this.shardResults = shardResults;
 * the Apache License, Version 2.0 (the "License"); you may
                        hit.score(shardDoc.score);
    /**  
    /**  
            QuerySearchResult result = entry.queryResult();  
 */  
            return topDocs;  
        List<TopDocs> bufferedTopDocs,  
            entry.fetchResult().initCounter();  
                hits,  
                     * The user requested to count the total hits up to <code>trackTotalHitsUpTo</code>
                }
                topDocsStats.getMaxScore(),
     * Earlier widening of type was taken care in IndexNumericFieldData, but since we now want to  
            SortField.Type firstType = getSortType(firstTopDocFields[fieldIndex]);  
    public InternalSearchResponse merge(
     * @param queryProfiles the query phase profile results (must not be null)  
                    break;  
                    // throw exception if sortType is not CUSTOM?  
     * named completion suggestion across all shards. If more than one named completion suggestion is specified in the
            this.trackTotalHitsUpTo = trackTotalHitsUpTo;
                            // TODO it would be nice to assert this in the future  
            from = result.from();
        return new StreamQueryPhaseResultConsumer(
import java.util.ArrayList;
                                + "in one index, and different type in another index!"
     * @param ignoreFrom Whether to ignore the from and sort all hits in each shard result.
        Function<SearchSourceBuilder, InternalAggregation.ReduceContextBuilder> requestToAggReduceContextBuilder  
            : Collections.emptyMap();
                if (fetchResultProvider == null) {  
 */  
 */  
        int from = ignoreFrom ? 0 : reducedQueryPhase.from;
            scoreDocs = new ScoreDoc[mergedScoreDocs.length + numSuggestDocs];  
            if (fieldDocs instanceof CollapseTopFieldDocs) {
     * More details here https://github.com/opensearch-project/OpenSearch/issues/6326
            topDocsStats.fetchHits,  
    }
                assert completionSuggestion != null;  
                } else {  
                return new TotalHits(totalHits, totalHitsRelation);
        return new QueryPhaseResultConsumer(
            final TopDocs[] shardTopDocs = results.toArray(new TopDocs[numShards]);
            numShards,  
                            "Can't do sort across indices, as a field has [unsigned_long] type "  
            boolean isEmptyResult
                newFields[fieldIndex] = new SortedWiderNumericSortField(
        for (SearchPhaseResult entry : queryResults) {
        int numSearchHits = (int) Math.min(reducedQueryPhase.fetchHits - from, reducedQueryPhase.size);  
import java.util.function.BooleanSupplier;
                numReducePhases,
            }  
            );
            this.size = size;
     */
     */
            false  
                int currentOffset = hits.getHits().length;
                        );
        }
                throw new UnsupportedOperationException("Scroll requests don't have aggs");  
        final String collapseField;  
                    continue;
import java.util.Collection;
                for (int i = 0; i < formats.length; i++) {
                true
        if (mergedTopDocs instanceof TopFieldDocs) {
        if (request.source() == null) {
            TopFieldDocs fieldDocs = (TopFieldDocs) mergedTopDocs;
                if (SortedWiderNumericSortField.isTypeSupported(sortType) == false) {
    }  
            final TopFieldDocs[] shardTopDocs = results.toArray(new TopFieldDocs[numShards]);  
            // with collapsing we can have more hits than sorted docs
            if (hasSuggest) {
        ) {  
    static final class SortedTopDocs {
                    scoreDocs[offset++] = option.getDoc();
     * @see QuerySearchResult#consumeAggs()  
 * this work for additional information regarding copyright
 * specific language governing permissions and limitations
            final ScoreDoc[] sortedScoreDocs = reducedQueryPhase.sortedTopDocs.scoreDocs;
                null,  
        return new SortedTopDocs(scoreDocs, isSortedByField, sortFields, collapseField, collapseValues);
                aggregations,
                throw new UnsupportedOperationException("Scroll requests don't have aggs");
 * Modifications Copyright OpenSearch Contributors. See
        Executor executor,
    }
import org.apache.lucene.search.grouping.CollapseTopFieldDocs;
                        existingProfile.getNetworkTime()
     */  
                        final int index = fetchResult.counterGetAndIncrement();
        int numShards,
        SearchProfileShardResults queryProfiles,
            }
     *
                collapseField = collapseTopFieldDocs.field;
                            + fetchResult.hits().getHits().length;
                        ? true
            this.sortedTopDocs = sortedTopDocs;
                     */
        CircuitBreaker circuitBreaker,
                if (totalHits <= trackTotalHitsUpTo) {  
            if (SortedWiderNumericSortField.isTypeSupported(firstType) == false) {
            topDocsStats.timedOut,
import org.opensearch.search.internal.SearchContext;
                    fieldStatistics.put(key, merged);
            if (hasProfileResults) {  
import org.opensearch.search.dfs.DfsSearchResult;
            this.timedOut = timedOut;
            }
         * @param controller the SearchPhaseController instance to access mergeFetchProfiles method  
import org.opensearch.search.profile.ProfileShardResult;
        int from,
        TopDocsStats topDocsStats,
            this.collapseField = collapseField;
            }
    ) {
        Consumer<Exception> onPartialMergeFailure  
                TermStatistics existing = termStatistics.get(terms[i]);
                if (this.terminatedEarly == null) {
            size = Math.max(result.size(), size);  
 *     http://www.apache.org/licenses/LICENSE-2.0
                if (sortedTopDocs.isSortedByField) {  
                    this.terminatedEarly = true;
                requireWiden = requireWiden || sortType != firstType;
     * don't work correctly. Throw an error if this kind of sorting is detected.
import org.opensearch.search.aggregations.InternalAggregations;
        }
            mergedTopDocs = CollapseTopFieldDocs.merge(sort, from, topN, shardTopDocs);
        assert queryResults.isEmpty() == false : errorMsg;
            final TopDocsAndMaxScore td = queryResult.consumeTopDocs();  
        Boolean terminatedEarly;
    private final NamedWriteableRegistry namedWriteableRegistry;
        assert numReducePhases >= 0 : "num reduce phases must be >= 0 but was: " + numReducePhases;
     */
    QueryPhaseResultConsumer newSearchPhaseResults(  
        final SortedTopDocs sortedTopDocs;
        final ScoreDoc[] lastEmittedDocPerShard = new ScoreDoc[numShards];  
        } else {  
        if (reducedQueryPhase.isEmptyResult) {
        final Object[] collapseValues;
            newFields[fieldIndex] = firstTopDocFields[fieldIndex];
                numReducePhases  
    ) {
        Object[] collapseValues = null;  
 * @opensearch.internal
        // encloses info about the merged top docs, the sort fields used to sort the score docs etc.
            shardResults,  
        final TopDocs mergedTopDocs;  
        Executor executor,  
import org.apache.lucene.search.FieldDoc;  
import org.apache.lucene.search.SortedNumericSortField;
                );
        ScoreDoc[] sortedDocs = reducedQueryPhase.sortedTopDocs.scoreDocs;
                    final List<CompletionSuggestion.Entry.Option> suggestionOptions = suggestion.getOptions();
                    // TODO it would be nice to assert this in the future
            }  
 *
     * completion suggestion ordered by suggestion name
        );
import org.opensearch.search.DocValueFormat;  
    }
                        FetchSearchResult fetchResult = searchResultProvider.fetchResult();  
            final TotalHits totalHits = topDocsStats.getTotalHits();
     * Reduces the given query results and consumes all aggregations and profile results.
        for (int fieldIndex = 0; fieldIndex < firstTopDocFields.length; fieldIndex++) {
        );  
        // the size of the top hits to return  
                for (CompletionSuggestion.Entry.Option option : completionSuggestion.getOptions()) {
    ReducedQueryPhase reducedScrollQueryPhase(Collection<? extends SearchPhaseResult> queryResults) {
    private static SortField.Type getSortType(SortField sortField) {
    /**  
                hits.add(searchHit);  
            this.isEmptyResult = isEmptyResult;
 * this file be licensed under the Apache-2.0 license or a
        if (queryResults.isEmpty()) { // early terminate we have nothing to reduce  
                        fetchProfile.getFetchProfileResult(), // Use fetch profile data
    public SearchProfileShardResults mergeFetchProfiles(
        final SortField[] firstTopDocFields = topFieldDocs[0].fields;  
        List<SearchHit> hits = new ArrayList<>();
        List<CompletionSuggestion> reducedCompletionSuggestions
    ) {  
 * SPDX-License-Identifier: Apache-2.0
            return InternalSearchResponse.empty();
        if (sortedTopDocs.isSortedByField) {
        int numShards,
                    searchHit.sortValues(fieldDoc.fields, reducedQueryPhase.sortValueFormats);
                SortedTopDocs.EMPTY,
     */
        InternalAggregation.ReduceContextBuilder aggReduceContextBuilder,
    }
     * @param size the number of hits to return from the merged top docs  
        // the top docs sort fields used to sort the score docs, <code>null</code> if the results are not sorted
    private static void validateMergeSortValueFormats(Collection<? extends SearchPhaseResult> queryResults) {
        Collection<? extends SearchPhaseResult> fetchResults  
        if (reducedCompletionSuggestions.isEmpty() == false) {  
            this.suggest = suggest;  
                0,
            this,  
            long size = Math.min(reducedQueryPhase.fetchHits, reducedQueryPhase.size);
                }
        CircuitBreaker circuitBreaker,
 *
        }  
            for (int shardIndex = 1; shardIndex < topFieldDocs.length; shardIndex++) {
                    FieldDoc fieldDoc = (FieldDoc) shardDoc;
                null,
        this.requestToAggReduceContextBuilder = requestToAggReduceContextBuilder;  
            reducedCompletionSuggestions = reducedSuggest.filter(CompletionSuggestion.class);
        }
            String collapseField,
        final int numReducePhases;  
    }  
        ScoreDoc[] scoreDocs = mergedScoreDocs;
        final Map<Term, TermStatistics> termStatistics = new HashMap<>();
     * Different indices might have different types. This will avoid user to do re-index of data  
        }  
                    // skip this shard or do not widen?
            }
    }
            reducedQueryPhase.maxScore,  
        for (SearchPhaseResult fetchResult : fetchResults) {
        }  
        for (DfsSearchResult lEntry : results) {
import org.opensearch.search.SearchPhaseResult;  
                    /*  
                } else {  
                }  
            this.aggregations = aggregations;
            this.collapseValues = collapseValues;
                }  
                    mergedResults.put(shardId, merged);
            QuerySearchResult queryResult = sortedResult.queryResult();
                    sortScoreIndex = i;  
                    suggestionList.add(suggestion);
    /*  
        SearchRequest request,
import org.opensearch.search.aggregations.InternalAggregation;
     *
 * ownership. Elasticsearch licenses this file to you under  
                    firstTopDocFields[fieldIndex].getField(),
            long fetchHits,
import org.opensearch.common.lucene.search.TopDocsAndMaxScore;
                        : false;
            SortField[] sortFields,  
            }  
    }
        }  
        Collection<? extends SearchPhaseResult> fetchResults,
                        key,
                } else {  
     * Builds an array, with potential null elements, with docs to load.
            }  
    }  
        final TotalHits totalHits;
                }
                final SortField sortField = topFieldDocs[shardIndex].fields[fieldIndex];  
        // Merge fetch profiles into existing query profiles
                performFinalReduce ? aggReduceContextBuilder.forFinalReduction() : aggReduceContextBuilder.forPartialReduction()
        String errorMsg = "must have at least one non-empty search result, got 0 out of " + total;  
     */  
            : InternalAggregations.topLevelReduce(
