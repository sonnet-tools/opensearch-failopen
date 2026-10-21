        }
 * software distributed under the License is distributed on an
     * Returns a score doc array of top N search docs across all shards, followed by top suggest docs for each
            numShards,
        final Suggest reducedSuggest;
            final TopFieldDocs[] shardTopDocs = results.toArray(new TopFieldDocs[numShards]);
import org.opensearch.search.suggest.Suggest;
import java.util.function.IntFunction;
        final boolean timedOut;
            namedWriteableRegistry,
import java.util.Collections;
                totalHits,
    private SearchHits getHits(
        final SortField[] newFields = new SortField[firstTopDocFields.length];
    private static final ScoreDoc[] EMPTY_DOCS = new ScoreDoc[0];
        // the sum of all hits across all reduces shards
    }
/**
        assert queryResults.isEmpty() == false : errorMsg;
            if (hasSuggest) {
        TopDocsStats(int trackTotalHitsUpTo) {
            return new InternalSearchResponse(
        int size,
            float maxScore,
                }
        final SortField[] sortFields;
                if (existing != null) {
        public InternalSearchResponse buildResponse(
                        existing.sumTotalTermFreq() + value.sumTotalTermFreq(),
        Collection<? extends SearchPhaseResult> fetchResults,
                        existing.maxDoc() + value.maxDoc(),
     * named completion suggestion across all shards. If more than one named completion suggestion is specified in the
                SortedTopDocs.EMPTY,
package org.opensearch.action.search;
        List<CompletionSuggestion> reducedCompletionSuggestions
            size = Math.max(result.size(), size);
import org.apache.lucene.search.TotalHits;
            shardResults,
        if (numShards == 1 && from == 0) { // only one shard and no pagination we can just return the topDocs as we got them.
            SortField[] sortFields = sortedTopDocs.sortFields;
    StreamQueryPhaseResultConsumer newStreamSearchPhaseResults(
                assert result.suggest() != null;
import org.opensearch.search.dfs.AggregatedDfs;
     * @param bufferedTopDocs a list of pre-collected top docs.
        boolean timedOut;
                if (sortedTopDocs.isSortedByField) {
        this.requestToAggReduceContextBuilder = requestToAggReduceContextBuilder;
    ) {
            : InternalAggregations.topLevelReduce(
                }
    }
        ) {
            }
                    fieldStatistics.put(key, value);
            sortFields = fieldDocs.fields;
        }
                        existingProfile.getQueryProfileResults(),
import org.opensearch.search.aggregations.InternalAggregation;
                CollectionStatistics value = entry.getValue();
        // the offset into the merged top hits
            long size = Math.min(reducedQueryPhase.fetchHits, reducedQueryPhase.size);
                    suggestionList.add(suggestion);
            sortedTopDocs.sortFields,
import java.util.function.Consumer;
        int numShards,
import org.opensearch.search.profile.SearchProfileShardResults;
            if (requireWiden) {
    ReducedQueryPhase reducedQueryPhase(
                }
            // with collapsing we can have more hits than sorted docs
     * request, the suggest docs for a named suggestion are ordered by the suggestion name.
        queryResults = queryResults.stream().filter(res -> res.queryResult().isNull() == false).collect(Collectors.toList());
            boolean timedOut,
            this,
                for (CompletionSuggestion.Entry.Option option : completionSuggestion.getOptions()) {
     * Returns a new {@link QueryPhaseResultConsumer} instance that reduces search responses incrementally.
        final DocValueFormat[] sortValueFormats;
    /**
                } else {
    /**
            reducedSuggest,
 * this work for additional information regarding copyright
                            + "] length: "
        boolean[] ulFormats = null;
                    fieldStatistics.put(key, merged);
            final TermStatistics[] stats = lEntry.termStatistics();
            boolean requireWiden = false;
        // <code>true</code> iff the result score docs is sorted by a field (not score), this implies that <code>sortField</code> is set.
            if (trackTotalHitsUpTo != SearchContext.TRACK_TOTAL_HITS_DISABLED) {
        for (int fieldIndex = 0; fieldIndex < firstTopDocFields.length; fieldIndex++) {
        if (!fetchResults.isEmpty()) {
                SortField.Type sortType = getSortType(sortField);
                        SearchHit hit = fetchResult.hits().getHits()[index];
        Map<String, ProfileShardResult> mergedResults = new HashMap<>(queryProfiles.getShardResults());
     * @opensearch.internal
    }
                isSortedByField = (fieldDocs.fields.length == 1 && fieldDocs.fields[0].getType() == SortField.Type.SCORE) == false;
            for (int i = 0; i < sortFields.length; i++) {
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
            String collapseField,
            for (CompletionSuggestion completionSuggestion : reducedCompletionSuggestions) {
                }
        // the number of returned hits (doc IDs) across all reduces shards
            int numReducePhases,
        int numShards,
        private TotalHits.Relation totalHitsRelation;
        for (SearchPhaseResult fetchResult : fetchResults) {
                    // skip this shard or do not widen?
                terminatedEarly,
    /**
            size = Math.min(sortedScoreDocs.length, size);
        final SortField[] firstTopDocFields = topFieldDocs[0].fields;
        if (reducedQueryPhase.isEmptyResult) {
            this.fetchHits = fetchHits;
                totalHits += topDocs.topDocs.totalHits.value();
        }
 * the Apache License, Version 2.0 (the "License"); you may
            sortedTopDocs,
 * Unless required by applicable law or agreed to in writing,
                final SortField sortField = topFieldDocs[shardIndex].fields[fieldIndex];
                                + "in one index, and different type in another index!"
                if (fetchResultProvider == null) {
    }
        return lastEmittedDocPerShard;
    }
            }
        Executor executor,
    /**
            SortedTopDocs sortedTopDocs,
                SearchHit searchHit = fetchResult.hits().getHits()[index];
    private static SortField.Type getSortType(SortField sortField) {
            this.collapseField = collapseField;
 * license agreements. See the NOTICE file distributed with
                        existingProfile.getNetworkTime()
     * Builds an array, with potential null elements, with docs to load.
        final Map<String, List<Suggestion>> groupedSuggestions = hasSuggest ? new HashMap<>() : Collections.emptyMap();
            topDocsStats.getMaxScore(),
        ReducedQueryPhase reducedQueryPhase,
import java.util.stream.Collectors;
        }
    ) {
     * Reduces the given query results and consumes all aggregations and profile results.
     * More details here https://github.com/opensearch-project/OpenSearch/issues/6326
                    return new TotalHits(trackTotalHitsUpTo, Relation.GREATER_THAN_OR_EQUAL_TO);
                assert currentOffset == sortedDocs.length : "expected no more score doc slices";
                assert result.hasConsumedTopDocs() : "firstResult has no aggs but we got non null buffered aggs?";
            } else {
        }
        }
        if (queryResults.isEmpty()) { // early terminate we have nothing to reduce
        for (SearchPhaseResult entry : queryResults) {
            this.suggest = suggest;
        assert numReducePhases >= 0 : "num reduce phases must be >= 0 but was: " + numReducePhases;
            return null;
    /**
     * completion suggestion ordered by suggestion name
                firstResult = false;
            if (timedOut) {
            this.size = size;
            reducedSuggest = new Suggest(Suggest.reduce(groupedSuggestions));
        return new AggregatedDfs(termStatistics, fieldStatistics, aggMaxDoc);
    public List<Integer>[] fillDocIdsToLoad(int numShards, ScoreDoc[] shardDocs) {
    }
                    // throw exception if sortType is not CUSTOM?
            this.numReducePhases = numReducePhases;
import java.util.function.BooleanSupplier;
                assert completionSuggestion != null;
            InternalAggregations aggregations,
                    searchHit.score(shardDoc.score);
            mergedTopDocs = CollapseTopFieldDocs.merge(sort, from, topN, shardTopDocs);
            int size,
    private static Sort createSort(TopFieldDocs[] topFieldDocs) {
                     * The user requested to count the total hits up to <code>trackTotalHitsUpTo</code>
        /**
            numReducePhases,
        int total = queryResults.size();
     * Top docs that have been sorted
        }
            }
            boolean isEmptyResult
            for (int i = 0; i < numSearchHits; i++) {
                newFields[fieldIndex] = new SortedWiderNumericSortField(
    public static final class ReducedQueryPhase {
        CircuitBreaker circuitBreaker,
    public SearchPhaseController(
     * Note: The order of the sorted score docs depends on the shard index in the result array if the merge process needs to disambiguate
            this.shardResults = shardResults;
     * @opensearch.internal
     *                   Enabled only for scroll search, because that only retrieves hits of length 'size' in the query phase.
import org.opensearch.search.profile.ProfileShardResult;
            public ReduceContext forFinalReduction() {
            sortedTopDocs.collapseField,
            System.arraycopy(mergedScoreDocs, 0, scoreDocs, 0, mergedScoreDocs.length);
            if (fieldDocs instanceof CollapseTopFieldDocs) {
            } else if (trackTotalHitsUpTo == SearchContext.TRACK_TOTAL_HITS_ACCURATE) {
                }
        final Map<Term, TermStatistics> termStatistics = new HashMap<>();
                setShardIndex(td.topDocs, queryResult.getShardIndex());
     * support sort optimization, we removed type widening there and taking care here during merging.
            }
                } else {
            hits.toArray(new SearchHit[0]),
     */
            );
                searchHit.shard(fetchResult.getSearchShardTarget());
        Collection<? extends SearchPhaseResult> fetchResults
                    }
            this.totalHitsRelation = Relation.EQUAL_TO;
        final List<TopDocs> topDocs = new ArrayList<>();
                timedOut,
        assert topDocs.scoreDocs.length == 0 || topDocs.scoreDocs[0].shardIndex == -1 : "shardIndex is already set";
        }
 */
                    totalHitsRelation = TotalHits.Relation.GREATER_THAN_OR_EQUAL_TO;
            isTaskCancelled
        } else if (topDocs instanceof TopFieldDocs) {
                }
                    FieldDoc fieldDoc = (FieldDoc) shardDoc;
                isFloat = isFloat || sortType == SortField.Type.FLOAT || sortType == SortField.Type.DOUBLE;
        final InternalAggregations aggregations = reduceAggs(aggReduceContextBuilder, performFinalReduce, bufferedAggs);
                continue;
                if (stats[i] == null) {
    }
    /*
                    );
                if (existing != null) {
    static TopDocs mergeTopDocs(Collection<TopDocs> results, int topN, int from) {
                String key = result.getSearchShardTarget().toString();
        numReducePhases++; // increment for this phase
import org.apache.lucene.search.CollectionStatistics;
    }
            }
import org.apache.lucene.search.ScoreDoc;
     * Different indices might have different types. This will avoid user to do re-index of data
                ProfileShardResult existingProfile = mergedResults.get(shardId);
        // reduce suggest
            executor,
        CircuitBreaker circuitBreaker,
            this,
            return SearchService.DEFAULT_SIZE;
        if (reducedQueryPhase.isEmptyResult == false) {
        final Object[] collapseValues;
                } else {
        } else {
                if (value == null) {
     * Checks that query results from all shards have consistent unsigned_long format.
        final int from;
    }
                    // in this case we referenced the shard result via the ScoreDoc but never got a
                        FetchSearchResult fetchResult = searchResultProvider.fetchResult();
    /**
            } else {
        final int numShards = results.size();
     * The top docs statistics
                CollapseTopFieldDocs collapseTopFieldDocs = (CollapseTopFieldDocs) fieldDocs;
            @Override
            this.from = from;
import org.opensearch.search.sort.SortedWiderNumericSortField;
            listener,
     *
        if (topDocs.isEmpty() && reducedCompletionSuggestions.isEmpty()) {
        Consumer<Exception> onPartialMergeFailure,
        return new Sort(newFields);
        ScoreDoc[] scoreDocs = mergedScoreDocs;
        static final SortedTopDocs EMPTY = new SortedTopDocs(EMPTY_DOCS, false, null, null, null);
 * under the License.
                            // result from fetch.
        int from = 0;
        }
            for (int shardIndex = 1; shardIndex < topFieldDocs.length; shardIndex++) {
                profileResults.put(key, result.consumeProfileResult());
            }
        }
     * Reduces the given query results and consumes all aggregations and profile results.
            DocValueFormat[] formats = entry.queryResult().sortValueFormats();
                int currentOffset = hits.getHits().length;
            }
        final boolean hasSuggest = firstResult.suggest() != null;
                    );
    }
import java.util.concurrent.Executor;
        InternalAggregation.ReduceContextBuilder aggReduceContextBuilder,
                shardDocIdsToLoad = docIdsToLoad[shardDoc.shardIndex] = new ArrayList<>();
        }
        } else if (topDocs instanceof CollapseTopFieldDocs) {
        SearchProgressListener listener,
                mergedProfileResults,
        boolean isScrollRequest,
        int numReducePhases,
            this.totalHits = 0;
     * Merges fetch phase profile results with query phase profile results.
        Object[] collapseValues = null;
            final TopDocs[] shardTopDocs = results.toArray(new TopDocs[numShards]);
        int size = 0;
    private static void validateMergeSortValueFormats(Collection<? extends SearchPhaseResult> queryResults) {
                        existingProfile.getAggregationProfileResults(),
                        key,
                        final int index = fetchResult.counterGetAndIncrement();
            assert td != null;
        if (queryResults.isEmpty()) {
        final Map<String, ProfileShardResult> profileResults = hasProfileResults
 * not use this file except in compliance with the License.
            ScoreDoc[] scoreDocs,
        IntFunction<SearchPhaseResult> resultsLookup
            numShards,
     * @param queryProfiles the query phase profile results (must not be null)
                for (Suggestion<? extends Suggestion.Entry<? extends Suggestion.Entry.Option>> suggestion : result.suggest()) {
import org.opensearch.common.lucene.search.TopDocsAndMaxScore;
                            existing.term(),
                for (int i = 0; i < formats.length; i++) {
        final SearchProfileShardResults shardResults = profileResults.isEmpty() ? null : new SearchProfileShardResults(profileResults);
    static final class TopDocsStats {
        }
        final String collapseField;
        SearchProfileShardResults queryProfiles,
        // non null and true if at least one reduced result was terminated early
                    this.terminatedEarly = terminatedEarly;
/*
        final Map<String, CollectionStatistics> fieldStatistics = new HashMap<>();
                    continue;
import org.apache.lucene.search.FieldDoc;
                if (this.terminatedEarly == null) {
    }
                    return new TotalHits(totalHits, totalHitsRelation);
import org.apache.lucene.search.grouping.CollapseTopFieldDocs;
        ReducedQueryPhase reducedQueryPhase,
            this.timedOut = timedOut;
            }
            size,
        void add(TopDocsAndMaxScore topDocs, boolean timedOut, Boolean terminatedEarly) {
        }
            sortedTopDocs.collapseValues
 *
     */
                hits,
         * @param controller the SearchPhaseController instance to access mergeFetchProfiles method
        SortField[] sortFields = null;
        final ScoreDoc[] scoreDocs;
    ) {
            public ReduceContext forPartialReduction() {
import org.apache.lucene.search.SortField;
     * @see QuerySearchResult#consumeAggs()
                } else if (terminatedEarly) {
        int from,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * compatible open source license.
     * the result. In oder to obtain stable results the shard index (index of the result in the result array) must be the same.
 */
import org.apache.lucene.search.TotalHits.Relation;
            onPartialMergeFailure,
        ReducedQueryPhase(
import org.opensearch.search.SearchPhaseResult;
            // make sure we set the shard index before we add it - the consumer didn't do that yet
            }
        final int trackTotalHitsUpTo;
            shardDocIdsToLoad.add(shardDoc.doc);
     * @param from the offset into the search results top docs
        }
import org.opensearch.search.SearchService;
        final ScoreDoc[] mergedScoreDocs = mergedTopDocs == null ? EMPTY_DOCS : mergedTopDocs.scoreDocs;
        ) {
                true
            if (shardDocIdsToLoad == null) {
    }
    public AggregatedDfs aggregateDfs(Collection<DfsSearchResult> results) {
        if (groupedSuggestions.isEmpty()) {
        // encloses info about the merged top docs, the sort fields used to sort the score docs etc.
    InternalAggregation.ReduceContextBuilder getReduceContext(SearchRequest request) {
                this.timedOut = true;
            if (hasProfileResults) {
                lastEmittedDocPerShard[scoreDoc.shardIndex] = scoreDoc;
            TopFieldDocs fieldDocs = (TopFieldDocs) mergedTopDocs;
            }
                            existing.totalTermFreq() + stats[i].totalTermFreq()
    }
            QuerySearchResult queryResult = sortedResult.queryResult();
                throw new UnsupportedOperationException("Scroll requests don't have aggs");
                suggest,
     * This will support Int to Long and Float to Double.
            List<Integer> shardDocIdsToLoad = docIdsToLoad[shardDoc.shardIndex];
        Consumer<Exception> onPartialMergeFailure
            int offset = mergedScoreDocs.length;
        final Boolean terminatedEarly;
            SearchHits hits,
     */
import org.opensearch.search.builder.SearchSourceBuilder;
                ulFormats = new boolean[formats.length];
        return requestToAggReduceContextBuilder.apply(request.source());
            // from is always zero as when we use scroll, we ignore from
                FetchSearchResult fetchResult = fetchResultProvider.fetchResult();
                null,
            QuerySearchResult result = entry.queryResult();
                            continue;
                    }
     * @param numReducePhases the number of non-final reduce phases applied to the query results.
            entry.fetchResult().initCounter();
            if (terminatedEarly != null) {
    }
            executor,
import org.apache.lucene.search.Sort;
                toReduce,
        if (reducedCompletionSuggestions.isEmpty() == false) {
                    searchHit.sortValues(fieldDoc.fields, reducedQueryPhase.sortValueFormats);
         * @see #merge(boolean, ReducedQueryPhase, Collection, IntFunction)
     * @return merged profile results containing both query and fetch phase data
        }
                        );
     */
                    List<Suggestion> suggestionList = groupedSuggestions.computeIfAbsent(suggestion.getName(), s -> new ArrayList<>());
        ) {
        }
                if (existingProfile != null) {
        this.namedWriteableRegistry = namedWriteableRegistry;
                numReducePhases
        }
        );
            }
import org.opensearch.search.suggest.Suggest.Suggestion;
                }
            this.sortFields = sortFields;
        for (ScoreDoc doc : topDocs.scoreDocs) {
        final long fetchHits;
            if (trackTotalHitsUpTo == SearchContext.TRACK_TOTAL_HITS_DISABLED) {
import org.opensearch.index.fielddata.IndexFieldData;
                        if (searchResultProvider == null) {
        }
                    continue;
                    firstTopDocFields[fieldIndex].getReverse()
     * in case of mapping field change for newly indexed data.
                    + fetchResult.hits().getHits().length;
    }
            from,
                        new TermStatistics(
        if (sortedTopDocs.isSortedByField) {
 * GitHub history for details.
            final CollapseTopFieldDocs[] shardTopDocs = results.toArray(new CollapseTopFieldDocs[numShards]);
        }
                ProfileShardResult fetchProfile = fetchResult.fetchResult().getProfileResults();
            boolean isFloat = firstType == SortField.Type.FLOAT || firstType == SortField.Type.DOUBLE;
        final List<Integer>[] docIdsToLoad = (List<Integer>[]) new ArrayList<?>[numShards];
                String key = entry.getKey();
import org.apache.lucene.search.TopDocs;
        validateMergeSortValueFormats(queryResults);
            mergedTopDocs = TopDocs.merge(from, topN, shardTopDocs);
     *
                    );
 * ownership. Elasticsearch licenses this file to you under
    ) {
                ScoreDoc scoreDoc = sortedScoreDocs[sortedDocsIndex];
        if (request.source() == null) {
    /**
            scoreDocs = new ScoreDoc[mergedScoreDocs.length + numSuggestDocs];
        return new SearchProfileShardResults(mergedResults);
            );
        };
                throw new UnsupportedOperationException("Scroll requests don't have aggs");
                            + index
            Object[] collapseValues
     */
                : sortField.getType();
 * KIND, either express or implied.  See the License for the
                final int index = fetchResult.counterGetAndIncrement();
                    // TODO it would be nice to assert this in the future
 * @opensearch.internal
                    + "] length: "
        String errorMsg = "must have at least one non-empty search result, got 0 out of " + total;
        TopDocsStats topDocsStats,
            final ScoreDoc[] sortedScoreDocs = reducedQueryPhase.sortedTopDocs.scoreDocs;
            }
        boolean ignoreFrom,
            SortField.Type firstType = getSortType(firstTopDocFields[fieldIndex]);
            }
     */
            assert terms.length == stats.length;
    }
     * Returns the size of the requested top documents (from + size)
                    // this can happen if we are hitting a shard failure during the fetch phase
        CircuitBreaker circuitBreaker,
        } else {
        return new QueryPhaseResultConsumer(
        Consumer<Exception> onPartialMergeFailure
            : source.from());
        }
            for (var entry : lEntry.fieldStatistics().entrySet()) {
     * @param size the number of hits to return from the merged top docs
        SearchSourceBuilder source = request.source();
    static SortedTopDocs sortDocs(
            for (int i = 0; i < terms.length; i++) {
                }
            topDocsStats.terminatedEarly,
        List<InternalAggregations> toReduce
        final TotalHits totalHits;
        }
                collapseField = collapseTopFieldDocs.field;
            circuitBreaker,
            }
            int from,
    public SearchProfileShardResults mergeFetchProfiles(
            this.scoreDocs = scoreDocs;
     * @param bufferedAggs a list of pre-collected aggregations.
        final float maxScore;
                ? ((SortedNumericSortField) sortField).getNumericType()
            }
            }
        return toReduce.isEmpty()
        for (SearchPhaseResult sortedResult : queryResults) {
        }
            this.maxScore = maxScore;
        SortedTopDocs sortedTopDocs = reducedQueryPhase.sortedTopDocs;
            reducedSuggest = null;
            return SortedTopDocs.EMPTY;
                null,
     * //TODO: instead of throwing error, find a way to sort long and unsigned_long together
 *
            SearchProfileShardResults mergedProfileResults = shardResults != null
     * Sort queries on a field that has long type in one index, and unsigned_long in another index
                    // Merge fetch profile data into existing query profile
        for (DfsSearchResult lEntry : results) {
import java.util.List;
                    this.terminatedEarly = true;
                }
        }
            }
 * Controller for the search phase.
     */
            return ((IndexFieldData.XFieldComparatorSource) sortField.getComparatorSource()).reducedType();
                return new TotalHits(totalHits, totalHitsRelation);
                        fetchProfile.getFetchProfileResult(), // Use fetch profile data
            }
        return reducedQueryPhase(queryResults, Collections.emptyList(), topDocs, topDocsStats, 0, true, aggReduceContextBuilder, true);
            doc.shardIndex = shardIndex;
            if (bufferedTopDocs.isEmpty() == false) {
        SearchHits hits = getHits(reducedQueryPhase, ignoreFrom, fetchResults, resultsLookup);
import org.opensearch.core.common.breaker.CircuitBreaker;
                ? controller.mergeFetchProfiles(shardResults, fetchResults)
        final SortedTopDocs sortedTopDocs;
 * specific language governing permissions and limitations
        long aggMaxDoc = 0;
        for (ScoreDoc shardDoc : shardDocs) {
            this.isEmptyResult = isEmptyResult;
            topDocsStats.add(td, queryResult.searchTimedOut(), queryResult.terminatedEarly());
        Collection<? extends SearchPhaseResult> queryResults,
        );
                collapseValues = collapseTopFieldDocs.collapseValues;
            DocValueFormat[] sortValueFormats,
            reducedQueryPhase.totalHits,
                numReducePhases,
            final Sort sort = createSort(shardTopDocs);
        final InternalAggregations aggregations;
                null,
            return sortField instanceof SortedNumericSortField
     * @param queryResults a list of non-null query shard results
    private final Function<SearchSourceBuilder, InternalAggregation.ReduceContextBuilder> requestToAggReduceContextBuilder;
            return topDocs;
            if (!Float.isNaN(topDocs.maxScore)) {
            request,
            this.terminatedEarly = terminatedEarly;
                numSuggestDocs += completionSuggestion.getOptions().size();
        if (reducedQueryPhase.suggest != null) {
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
                performFinalReduce ? aggReduceContextBuilder.forFinalReduction() : aggReduceContextBuilder.forPartialReduction()
                ScoreDoc shardDoc = sortedTopDocs.scoreDocs[i];
     */
    }
            this.sortedTopDocs = sortedTopDocs;
                     * so we return this lower bound when the total hits is greater than this value.
                        existing.docCount() + value.docCount(),
                SearchPhaseResult fetchResultProvider = resultsLookup.apply(shardDoc.shardIndex);
        int numSearchHits = (int) Math.min(reducedQueryPhase.fetchHits - from, reducedQueryPhase.size);
                        }
            totalHits,
import org.opensearch.search.fetch.FetchSearchResult;
        // the size of the top hits to return
                    firstTopDocFields[fieldIndex].getField(),
        final int size;
                    }
 * You may obtain a copy of the License at
                    + index
            for (CompletionSuggestion completionSuggestion : reducedCompletionSuggestions) {
     */
        final boolean isEmptyResult;
        Function<SearchSourceBuilder, InternalAggregation.ReduceContextBuilder> requestToAggReduceContextBuilder
import org.opensearch.search.aggregations.InternalAggregation.ReduceContext;
        }
                topDocsStats.getMaxScore(),
        return mergedTopDocs;
        int from = ignoreFrom ? 0 : reducedQueryPhase.from;
                        terms[i],
        final Suggest suggest;
     * @param queryResults a list of non-null query shard results
            topDocsStats.fetchHits,
        NamedWriteableRegistry namedWriteableRegistry,
    }
 */
     * @param topDocs the buffered top docs
import java.util.HashMap;
        numSearchHits = Math.min(sortedTopDocs.scoreDocs.length, numSearchHits);
            if (SortedWiderNumericSortField.isTypeSupported(firstType) == false) {
            final Sort sort = createSort(shardTopDocs);
         * @param fetchResults the fetch results to merge profiles from
import org.apache.lucene.search.SortedNumericSortField;
        SearchRequest request,
        Executor executor,
            if (!fetchResults.isEmpty()) {
import org.opensearch.search.dfs.DfsSearchResult;
        return new SearchHits(
            assert !lEntry.fieldStatistics().containsKey(null);
        boolean firstResult = true;
        }
            : Collections.emptyMap();
        SearchRequest request,
                }
                throw new IllegalArgumentException("at least one reduce phase must have been applied but was: " + numReducePhases);
import java.util.Collection;
    }
        List<TopDocs> bufferedTopDocs,
        // clean the fetch counter
        }
import org.apache.lucene.search.TopFieldDocs;
        long fetchHits;
        SearchProgressListener listener,
            topDocsStats.timedOut,
        InternalAggregation.ReduceContextBuilder aggReduceContextBuilder = new InternalAggregation.ReduceContextBuilder() {
                        hit.score(shardDoc.score);
        final List<CompletionSuggestion> reducedCompletionSuggestions;
        // the top docs sort fields used to sort the score docs, <code>null</code> if the results are not sorted
    private static InternalAggregations reduceAggs(
                requireWiden = requireWiden || sortType != firstType;
 * SPDX-License-Identifier: Apache-2.0
            );
import org.opensearch.search.internal.SearchContext;
            this.totalHits = totalHits;
            this.sortValueFormats = sortValueFormats;
                }
 * The OpenSearch Contributors require contributions made to
        String collapseField = null;
        return new StreamQueryPhaseResultConsumer(
                    if (suggestion instanceof CompletionSuggestion) {
 */
                false,
                for (CompletionSuggestion suggestion : reducedQueryPhase.suggest.filter(CompletionSuggestion.class)) {
                }
 * Modifications Copyright OpenSearch Contributors. See
        List<SearchHit> hits = new ArrayList<>();
    static final class SortedTopDocs {
import java.util.ArrayList;
        // the reduced profile results
        if (results.isEmpty()) {
        }
                : null;
     */
            from = result.from();
            if (fetchResult.fetchResult() != null && fetchResult.fetchResult().getProfileResults() != null) {
        // count the total (we use the query result provider here, since we might not get any hits (we scrolled past them))
        );
        final TopDocsStats topDocsStats = new TopDocsStats(SearchContext.TRACK_TOTAL_HITS_ACCURATE);
    public InternalSearchResponse merge(
                        searchHit.score(((Number) fieldDoc.fields[sortScoreIndex]).floatValue());
            this.aggregations = aggregations;
    /**
                assert terms[i] != null;
        boolean ignoreFrom,
        IntFunction<SearchPhaseResult> resultsLookup
import org.opensearch.search.SearchHit;
     * @opensearch.internal
                    for (int scoreDocIndex = currentOffset; scoreDocIndex < currentOffset + suggestionOptions.size(); scoreDocIndex++) {
    ) {
            SearchPhaseController controller
     */
    ) {
        Collection<? extends SearchPhaseResult> fetchResults,
                            + fetchResult.hits().getHits().length;
    /**
                        )
                aggregations,
                    termStatistics.put(terms[i], stats[i]);
                    scoreDocs[offset++] = option.getDoc();
        // sort value formats used to sort / format the result
        // with collapsing we can have more fetch hits than sorted docs
                        hit.shard(fetchResult.getSearchShardTarget());
        // the max score across all reduces hits or {@link Float#NaN} if no hits returned
    QueryPhaseResultConsumer newSearchPhaseResults(
     *
        if (sortField.getComparatorSource() instanceof IndexFieldData.XFieldComparatorSource) {
                        : false;
                     */
                0,
                        CompletionSuggestion completionSuggestion = (CompletionSuggestion) suggestion;
        SearchRequest request,
            }
                }
            reducedCompletionSuggestions = reducedSuggest.filter(CompletionSuggestion.class);
                assert index < fetchResult.hits().getHits().length : "not enough hits fetched. index ["
                    ProfileShardResult merged = new ProfileShardResult(
            }
                assert key != null;
    ) {
    }
        final SortedTopDocs sortedTopDocs = sortDocs(isScrollRequest, bufferedTopDocs, from, size, reducedCompletionSuggestions);
                return null;
            throw new IllegalStateException(errorMsg);
    }
         * Creates a new search response from the given merged hits with fetch profile merging.
                            existing.docFreq() + stats[i].docFreq(),
     * @param ignoreFrom Whether to ignore the from and sort all hits in each shard result.
            // sorted queries can set the size to 0 if they have enough competitive hits.
                String shardId = fetchResult.getSearchShardTarget().toString();
     * Returns a new {@link StreamQueryPhaseResultConsumer} instance that reduces search responses incrementally.
import org.apache.lucene.search.TermStatistics;
                    CollectionStatistics merged = new CollectionStatistics(
            this.isSortedByField = isSortedByField;
        // the number of reduces phases
        return newSearchPhaseResults(executor, circuitBreaker, listener, request, numShards, onPartialMergeFailure, () -> false);
            onPartialMergeFailure
import org.apache.lucene.index.Term;
     * Creates Sort object from topFieldsDocs fields.
                isSortedByField = true;
            if (td.topDocs.scoreDocs.length > 0) {
        for (SearchPhaseResult entry : queryResults) {
            }
    QueryPhaseResultConsumer newSearchPhaseResults(
import org.opensearch.search.suggest.completion.CompletionSuggestion;
     * Expects sortedDocs to have top search docs across all shards, optionally followed by top suggest docs for each named
    /**
     * The reduced query phase
    ) {
                        assert index < fetchResult.hits().getHits().length : "not enough hits fetched. index ["
     *
        InternalAggregation.ReduceContextBuilder aggReduceContextBuilder,
            int numSuggestDocs = 0;
                        throw new IllegalArgumentException(
                if (SortedWiderNumericSortField.isTypeSupported(sortType) == false) {
        float getMaxScore() {
    ReducedQueryPhase reducedScrollQueryPhase(Collection<? extends SearchPhaseResult> queryResults) {
                        suggestOption.setHit(hit);
                    termStatistics.put(
            SearchProfileShardResults shardResults,
            Boolean terminatedEarly,
                if (topDocs.topDocs.totalHits.relation() == Relation.GREATER_THAN_OR_EQUAL_TO) {
    ) {
import org.opensearch.search.internal.InternalSearchResponse;
                    requireWiden = false;
        );
            mergedTopDocs = TopDocs.merge(sort, from, topN, shardTopDocs);
            aggregations,
        SearchProgressListener listener,
                topDocs.add(td.topDocs);
            long fetchHits,
            return new ReducedQueryPhase(
     * It is necessary to widen the SortField.Type to maximum byte size for merging sorted docs.
public final class SearchPhaseController {
        // Merge fetch profiles into existing query profiles
                );
            final Term[] terms = lEntry.terms();
            ? null
}
        final boolean hasProfileResults = firstResult.hasProfileResults();
    static void setShardIndex(TopDocs topDocs, int shardIndex) {
            Suggest suggest,
                    if (ulFormats[i] ^ (formats[i] == DocValueFormat.UNSIGNED_LONG_SHIFTED || formats[i] == DocValueFormat.UNSIGNED_LONG)) {
        // the reduced internal aggregations
            circuitBreaker,
    }
                }
 * this file be licensed under the Apache-2.0 license or a
                    // if the format is unsigned_long in one shard, and something different in another shard
                    mergedResults.put(shardId, merged);
     */
                    isFloat ? SortField.Type.DOUBLE : SortField.Type.LONG,
/*
                    final List<CompletionSuggestion.Entry.Option> suggestionOptions = suggestion.getOptions();
        long totalHits;
        final TopDocs topDocs = results.stream().findFirst().get();
        int sortScoreIndex = -1;
        return reducedQueryPhase.buildResponse(hits, fetchResults, this);
                    currentOffset += suggestionOptions.size();
     * @param fetchResults the fetch phase results to merge profiles from
        TotalHits getTotalHits() {
import java.util.function.Function;
    public ScoreDoc[] getLastEmittedDocPerShard(ReducedQueryPhase reducedQueryPhase, int numShards) {
            reducedQueryPhase.maxScore,
    /**
     * Enriches search hits and completion suggestion hits from <code>sortedDocs</code> using <code>fetchResultsArr</code>,
     * <p>
            this.trackTotalHitsUpTo = trackTotalHitsUpTo;
        List<InternalAggregations> bufferedAggs,
    }
            }
                            // this can happen if we are hitting a shard failure during the fetch phase
        int numShards,
                for (int i = 0; i < formats.length; i++) {
            SortField[] sortFields,
            if (formats == null) return;
            ? new HashMap<>(queryResults.size())
                    continue;
            reducedCompletionSuggestions = Collections.emptyList();
        // <code>true</code> if at least one reduced result timed out
                0,
                    // result from fetch.
        boolean ignoreFrom,
    /**
        }
        return new ReducedQueryPhase(
                     * is applied per shard.
            false
        final boolean isSortedByField;
        return new SortedTopDocs(scoreDocs, isSortedByField, sortFields, collapseField, collapseValues);
        final QuerySearchResult firstResult = queryResults.stream().findFirst().get().queryResult();
                maxScore = Math.max(maxScore, topDocs.maxScore);
            if (numReducePhases <= 0) {
        ScoreDoc[] sortedDocs = reducedQueryPhase.sortedTopDocs.scoreDocs;
    private final NamedWriteableRegistry namedWriteableRegistry;
                        SearchPhaseResult searchResultProvider = resultsLookup.apply(shardDoc.shardIndex);
            final TotalHits totalHits = topDocsStats.getTotalHits();
        return docIdsToLoad;
        final int numReducePhases;
            }
                        ScoreDoc shardDoc = sortedDocs[scoreDocIndex];
 *
import org.opensearch.search.aggregations.InternalAggregations;
        SortedTopDocs(
        }
                }
        Boolean terminatedEarly;
     * merges suggestions, aggregations and profile results
        // the searches merged top docs
        final SearchProfileShardResults shardResults;
        // merge hits
    /**
                null,
        final TopDocs mergedTopDocs;
                TermStatistics existing = termStatistics.get(terms[i]);
                if (totalHits <= trackTotalHitsUpTo) {
import java.util.Map;
        }
                null,
                            // in this case we referenced the shard result via the ScoreDoc but never got a
            for (int sortedDocsIndex = 0; sortedDocsIndex < size; sortedDocsIndex++) {
import org.opensearch.search.query.QuerySearchResult;
        if (mergedTopDocs instanceof TopFieldDocs) {
    }
        } else {
            this.collapseValues = collapseValues;
            return Float.isInfinite(maxScore) ? Float.NaN : maxScore;
                    }
            request,
    static int getTopDocsSize(SearchRequest request) {
        }
/*
                            "Can't do sort across indices, as a field has [unsigned_long] type "
                }
                    break;
                hits.add(searchHit);
                }
        boolean isSortedByField = false;
     */
        return (source.size() == -1 ? SearchService.DEFAULT_SIZE : source.size()) + (source.from() == -1
                    if (sortScoreIndex != -1) {
            TotalHits totalHits,
            Collection<? extends SearchPhaseResult> fetchResults,
            listener,
     * <p>
                } else {
        final TopDocs mergedTopDocs = mergeTopDocs(topDocs, size, ignoreFrom ? 0 : from);
     * don't work correctly. Throw an error if this kind of sorting is detected.
            ? SearchService.DEFAULT_FROM
                if (sortFields[i].getType() == SortField.Type.SCORE) {
                        ? true
            }
        for (SearchPhaseResult entry : fetchResults) {
            fetchHits += topDocs.topDocs.scoreDocs.length;
         * @param hits the merged search hits
     *
    /**
        Executor executor,
            firstResult.sortValueFormats(),
                        completionSuggestion.setShardIndex(result.getShardIndex());
        BooleanSupplier isTaskCancelled
                    sortScoreIndex = i;
            @Override
            }
                    ulFormats[i] = (formats[i] == DocValueFormat.UNSIGNED_LONG_SHIFTED || formats[i] == DocValueFormat.UNSIGNED_LONG)
                        existing.sumDocFreq() + value.sumDocFreq()
        final TotalHits totalHits = topDocsStats.getTotalHits();
                CollectionStatistics existing = fieldStatistics.get(key);
            return InternalSearchResponse.empty();
                    /*
            } else {
                        CompletionSuggestion.Entry.Option suggestOption = suggestionOptions.get(scoreDocIndex - currentOffset);
        boolean performFinalReduce,
import org.opensearch.search.DocValueFormat;
        final Collection<TopDocs> topDocs,
     */
    // TODO: should we check the compatibility between types
    ) {
            namedWriteableRegistry,
            }
        private float maxScore = Float.NEGATIVE_INFINITY;
            aggMaxDoc += lEntry.maxDoc();
            }
        boolean performFinalReduce
        // the reduced suggest results
                    assert terms[i].bytes().equals(existing.term());
                topDocsStats.fetchHits,
         */
 * Licensed to Elasticsearch under one or more contributor
            final TopDocsAndMaxScore td = queryResult.consumeTopDocs();
     * Returns a new {@link QueryPhaseResultConsumer} instance that reduces search responses incrementally.
            if (firstResult) {
        // <code>true</code> iff the query phase had no results. Otherwise <code>false</code>
                            // TODO it would be nice to assert this in the future
                     * This can happen when multiple shards are merged since the limit to track total hits
     */
        final ScoreDoc[] lastEmittedDocPerShard = new ScoreDoc[numShards];
     * @see QuerySearchResult#consumeProfileResult()
     * Earlier widening of type was taken care in IndexNumericFieldData, but since we now want to
                assert totalHitsRelation == Relation.EQUAL_TO;
            newFields[fieldIndex] = firstTopDocFields[fieldIndex];
import org.opensearch.search.SearchHits;
            boolean isSortedByField,
