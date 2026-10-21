            tookInMillis,
                searchResponse.isTerminatedEarly()
            if (clusterAlias2 == null) {
 * not use this file except in compliance with the License.
        ShardSearchFailure[] shardFailures = failures.toArray(ShardSearchFailure.EMPTY_ARRAY);
// from the remote clusters in the fetch phase. This would be identical to the removed QueryAndFetch strategy except that only the remote
                        for (CompletionSuggestion.Entry.Option option : options) {
            } else {
                    for (CompletionSuggestion.Entry options : completionSuggestion) {
            super(doc, score, fields);
        for (Map.Entry<ShardIdAndClusterAlias, Integer> shard : shards.entrySet()) {
import org.apache.lucene.search.TotalHits;
        }
     * need to look at the cluster alias and make sure to assign a different shardIndex based on that.
/*
    }
            Suggest suggest = searchResponse.getSuggest();
            if (shard != null) {
            if (searchResponse.getAggregations() != null) {
import java.util.Collections;
        ShardIdAndClusterAlias(ShardId shardId, String clusterAlias) {
 *
        }
            }
            sortFields,
                }
    SearchResponse getMergedResponse(SearchResponse.Clusters clusters, SearchRequestContext searchRequestContext) {
            searchRequestContext.getPhaseTook(),
        }
            for (int i = 0; i < topDocs.scoreDocs.length; i++) {
            null
    ) {
    /**
        Suggest suggest = groupedSuggestions.isEmpty() ? null : new Suggest(Suggest.reduce(groupedSuggestions));
                trackTotalHits = true;
import org.opensearch.common.lucene.search.TopDocsAndMaxScore;
            }
            numReducePhases
            }
                } else {
        }
            }
            int shardIdCompare = shardId1.compareTo(shardId2);
        }
                return -1;
 * have all already been fetched downstream.
            topDocsStats.add(
            shards.putIfAbsent(shardId, null);
        InternalAggregation.ReduceContextBuilder aggReduceContextBuilder
    int numResponses() {
            if (clusterAlias1 == null && clusterAlias2 == null) {
            SearchShardTarget shard = hit.getShard();
                            shards.putIfAbsent(shardId, null);
            topDocsStats.terminatedEarly,
        public int compareTo(ShardIdAndClusterAlias o) {
        }
        Map<String, List<Suggest.Suggestion>> groupedSuggestions = new HashMap<>();
            return shardId.equals(that.shardId) && clusterAlias.equals(that.clusterAlias);
import org.opensearch.search.aggregations.InternalAggregation;
            }
                assert trackTotalHits == null || trackTotalHits == false;
        }
        // assign a different shardIndex to each shard, based on their shardId natural ordering and their cluster alias
        TopDocs topDocs = SearchPhaseController.mergeTopDocs(topDocsList, size, from);
                assert shards.containsKey(shardId);
            } else {
            String clusterAlias1 = o1.shard() == null ? null : o1.shard().getClusterAlias();
    private final List<SearchResponse> searchResponses = new CopyOnWriteArrayList<>();
/**
            Collections.addAll(failures, searchResponse.getShardFailures());
        int size,
        TransportSearchAction.SearchTimeProvider searchTimeProvider,
     */
            int shardIdCompareTo = shardId.compareTo(o.shardId);
 * You may obtain a copy of the License at
                    searchHits.getSortFields(),
        }
            topDocsStats.getMaxScore(),
import java.util.List;
 * Known limitations:
/*
    }
        // make failures ordering consistent between ordinary search and CCS by looking at the shard they come from
                    searchHits.getCollapseField(),
            successfulShards,
     * make their ShardIds different, which is not the case if the index is really the same one from the same cluster, in which case we
import org.apache.lucene.search.grouping.CollapseTopFieldDocs;
        Map<String, List<Suggest.Suggestion>> groupedSuggestions
    private final InternalAggregation.ReduceContextBuilder aggReduceContextBuilder;
                    totalHits,
                topDocsList.add(topDocs);
            topDocsStats.timedOut,
import org.opensearch.search.profile.ProfileShardResult;
 * Unless required by applicable law or agreed to in writing,
            if (searchHits.getTotalHits() == null) {
        return topDocs;
        assert searchResponse.getScrollId() == null : "merging scroll results is not supported";
     */
import org.opensearch.search.aggregations.InternalAggregations;
        @Override
                }
        this.trackTotalHitsUpTo = trackTotalHitsUpTo;
     * (see TopDocs#tieBreakLessThan line 86). Generally, indices with same names on different clusters have different index uuids which
                    }
import org.opensearch.search.profile.SearchProfileShardResults;
                totalHits = searchHits.getTotalHits();
 * this file be licensed under the Apache-2.0 license or a
        InternalSearchResponse response = new InternalSearchResponse(
            // merged TopDocs is null whenever all clusters have returned empty hits
        setSuggestShardIndex(shards, groupedSuggestions);
            if (sortFields == null) {
            final SortField[] sortFields = searchHits.getSortFields();
            topDocsStats.getTotalHits(),
    }
        int shardIndex = 0;
 * Merges multiple search responses into one. Used in cross-cluster search when reduction is performed locally on each cluster.
}
 * phase, through the {@link ExpandSearchPhase}. Such inner_hits are not merged together as part of hits reduction.
    }
 *
        }
        // if the search is only across remote clusters, none of them are available, and all of them have skip_unavailable set to true,
            final Object[] sortValues;
                InternalAggregations internalAggs = (InternalAggregations) searchResponse.getAggregations();
            SearchHits searchHits = searchResponse.getHits();
        }
            skippedShards += searchResponse.getSkippedShards();
                if (suggestion instanceof CompletionSuggestion) {
        private final SearchHit searchHit;
        for (int i = 0; i < hits.length; i++) {
import org.apache.lucene.search.SortField;
        Object[] collapseValues = null;
                return true;
    private static void assignShardIndex(Map<ShardIdAndClusterAlias, Integer> shards) {
 * GitHub history for details.
            );
        } else {
    final int from;
                aggs.add(internalAggs);
import java.util.ArrayList;
            searchHits = new SearchHit[topDocs.scoreDocs.length];
import org.opensearch.search.suggest.Suggest;
                return 1;
 * specific language governing permissions and limitations
                SearchShardTarget shard = fieldDocAndSearchHit.searchHit.getShard();
        List<TopDocs> topDocsList = new ArrayList<>(searchResponses.size());
 * Licensed to Elasticsearch under one or more contributor
        );
                totalHits = new TotalHits(0, TotalHits.Relation.EQUAL_TO);
        int totalShards = 0;
 * ownership. Elasticsearch licenses this file to you under
import org.opensearch.search.SearchShardTarget;
        searchResponses.add(searchResponse);
 */
        // to simplify things, we use a FieldDoc all the time, even when only a ScoreDoc is needed, in which case fields are null.
import org.opensearch.search.internal.InternalSearchResponse;
            profileShardResults,
            shard.setValue(shardIndex++);
                new TopDocsAndMaxScore(topDocs, searchHits.getMaxScore()),
 * under the License.
                List<CompletionSuggestion> completionSuggestions = suggest.filter(CompletionSuggestion.class);
            this.shardId = shardId;
            this.clusterAlias = clusterAlias;
     * That may change in the future as it's possible to introduce incremental merges as responses come in if necessary.
            return Objects.hash(shardId, clusterAlias);
                return shardIdCompare;
        Arrays.sort(shardFailures, FAILURES_COMPARATOR);
            }
            ShardIdAndClusterAlias that = (ShardIdAndClusterAlias) o;
 * clusters, limiting the number of requests to one per cluster is beneficial, and outweighs the downside of fetching many more hits than
        long tookInMillis = searchTimeProvider.buildTookInMillis();
        @Override
     * This class is used instead of plain {@link ShardId} to support the scenario where the same remote cluster is registered twice using
import org.opensearch.OpenSearchException;
            topDocs = new TopDocs(totalHits, scoreDocs);
            }
 * @opensearch.internal
// TODO it may make sense to integrate the remote clusters responses as a shard response in the initial search phase and ignore hits coming
                OpenSearchException e = (OpenSearchException) cause;
                CollapseTopFieldDocs collapseTopFieldDocs = (CollapseTopFieldDocs) topDocs;
        Map<ShardIdAndClusterAlias, Integer> shards = new TreeMap<>();
 * - field collapsing is supported, but whenever inner_hits are requested, they will be retrieved by each cluster locally after the fetch
            numReducePhases += searchResponse.getNumReducePhases();
        int skippedShards = 0;
/*
    void add(SearchResponse searchResponse) {
     * Add a search response to the list of responses to be merged together into one.
    }
            collapseValues
            if (searchHits.getHits().length > 0) {
            }
            mergedSearchHits,
        // we end up calling merge without anything to merge, we just return an empty search response
 */
        for (TopDocs topDocs : topDocsList) {
                    searchHits.getCollapseValues()
            return SearchResponse.empty(searchTimeProvider::buildTookInMillis, clusters);
            totalShards,
            }
import java.util.Arrays;
            ShardId shardId1 = extractShardId(o1);
        return new SearchResponse(
            if (shardId2 == null) {
                searchResponse.isTimedOut(),
 *
        SearchHits mergedSearchHits = topDocsToSearchHits(topDocs, topDocsStats);
                // without sort fields and collapse info, despite sort by field and/or field collapsing was requested, which causes
 * license agreements. See the NOTICE file distributed with
                return 0;
     * Holds a field search hit and doc
        List<InternalAggregations> aggs = new ArrayList<>();
        // go through all the scoreDocs from each cluster and set their corresponding shardIndex
 * whether they belong to the local or the remote cluster. Assuming that there commonly is network latency when communicating with remote
                            assert shards.containsKey(shardId);
            return clusterAlias1.compareTo(clusterAlias2);
        this.searchTimeProvider = Objects.requireNonNull(searchTimeProvider);
            for (Suggest.Suggestion suggestion : suggestions) {
                return false;
        assignShardIndex(shards);
            collapseField,
    }
            searchHits = new SearchHit[0];
                assert searchHits.getCollapseValues() != null;
        SearchPhaseController.TopDocsStats topDocsStats = new SearchPhaseController.TopDocsStats(trackTotalHitsUpTo);
            }
        private ShardId extractShardId(ShardSearchFailure failure) {
     * @opensearch.internal
     * different aliases. In that case searching across the same cluster twice would make an assertion in lucene fail
            shardFailures,
        assignShardIndex(shards);
 * the Apache License, Version 2.0 (the "License"); you may
                            ShardIdAndClusterAlias shardId = new ShardIdAndClusterAlias(shard.getShardId(), shard.getClusterAlias());
import java.util.HashMap;
            if (shardIdCompare != 0) {
            clusters,
        this.aggReduceContextBuilder = Objects.requireNonNull(aggReduceContextBuilder);
        }
        Boolean trackTotalHits = null;
            // we may get failures from the same index, yet with a different cluster alias in their shard target.
    private static final class FieldDocAndSearchHit extends FieldDoc {
            response,
        for (SearchResponse searchResponse : searchResponses) {
            if (shardIdCompareTo != 0) {
            scoreDocs[i] = new FieldDocAndSearchHit(hit.docId(), hit.getScore(), sortValues, hit);
                for (Suggest.Suggestion<? extends Suggest.Suggestion.Entry<? extends Suggest.Suggestion.Entry.Option>> entries : suggest) {
 * compatible open source license.
    }
            this.searchHit = searchHit;
            }
        FieldDocAndSearchHit(int doc, float score, Object[] fields, SearchHit searchHit) {
        ScoreDoc[] scoreDocs = new ScoreDoc[hits.length];
 *
     * @opensearch.internal
                            ShardIdAndClusterAlias shardId = new ShardIdAndClusterAlias(shard.getShardId(), shard.getClusterAlias());
                collapseField = collapseTopFieldDocs.field;
        int from,
            // the index uuid does not match. But the same cluster can be registered multiple times with different aliases, in which case
     * Returns the merged response. To be called once all responses have been added through {@link #add(SearchResponse)}
                if (sortFields.length == 1 && sortFields[0].getType() == SortField.Type.SCORE) {
package org.opensearch.action.search;
            }
 * This approach consists of a different trade-off compared to ordinary cross-cluster search where we fan out to all the shards, no matter
                topDocs = new TopFieldDocs(totalHits, scoreDocs, searchHits.getSortFields());
 * Modifications Copyright OpenSearch Contributors. See
     */
        String collapseField = null;
        public int hashCode() {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        int successfulShards = 0;
                    }
                return -1;
     */
        int numReducePhases = 1;
                return 1;
        this.size = size;
        if (topDocs == null) {
            // we could assume that the same shard id cannot come back from multiple clusters as even with same index name and shard index,
            Throwable cause = failure.getCause();
    private static final class ShardIdAndClusterAlias implements Comparable<ShardIdAndClusterAlias> {
 * The OpenSearch Contributors require contributions made to
                assert trackTotalHits == null || trackTotalHits;
import org.opensearch.search.suggest.completion.CompletionSuggestion;
            assert clusterAlias != null : "clusterAlias is null";
            skippedShards,
                        for (CompletionSuggestion.Entry.Option option : options) {
            if (this == o) {
import java.util.concurrent.CopyOnWriteArrayList;
        int trackTotalHitsUpTo,
                    scoreDocs,
            if (shardId1 == null && shardId2 == null) {
    SearchResponseMerger(
                return shardIdCompareTo;
import java.util.Comparator;
            TopDocs topDocs = searchHitsToTopDocs(searchHits, totalHits, shards);
        setTopDocsShardIndex(shards, topDocsList);
     * so that all responses are merged into a single one.
                fieldDocAndSearchHit.shardIndex = shards.get(shardId);
            String clusterAlias2 = o2.shard() == null ? null : o2.shard().getClusterAlias();
        return new SearchHits(
        public int compare(ShardSearchFailure o1, ShardSearchFailure o2) {
import org.opensearch.search.SearchHits;
            if (clusterAlias1 == null) {
 */
        for (List<Suggest.Suggestion> suggestions : groupedSuggestions.values()) {
        final TopDocs topDocs;
                for (CompletionSuggestion completionSuggestion : completionSuggestions) {
 *     http://www.apache.org/licenses/LICENSE-2.0
    /**
        InternalAggregations reducedAggs = InternalAggregations.topLevelReduce(aggs, aggReduceContextBuilder.forFinalReduction());
        );
    }
        }
import org.opensearch.search.SearchHit;
import org.opensearch.core.index.shard.ShardId;
            if (cause instanceof OpenSearchException) {
        private final ShardId shardId;
                collapseValues = collapseTopFieldDocs.collapseValues;
import java.util.Objects;
                FieldDocAndSearchHit fieldDocAndSearchHit = (FieldDocAndSearchHit) scoreDoc;
     * Merges currently happen at once when all responses are available and
            if (searchHits.getCollapseField() != null) {
        // the current reduce phase counts as one
            ShardIdAndClusterAlias shardId = new ShardIdAndClusterAlias(shard.getShardId(), shard.getClusterAlias());
                );
                trackTotalHits = false;
                FieldDocAndSearchHit scoreDoc = (FieldDocAndSearchHit) topDocs.scoreDocs[i];
                    sortValues = hit.getRawSortValues();
        private final String clusterAlias;
     *
    private final TransportSearchAction.SearchTimeProvider searchTimeProvider;
        // after going through all the hits and collecting all their distinct shards, we assign shardIndex and set it to the ScoreDocs
            ShardId shardId2 = extractShardId(o2);
    }
            }
            if (topDocs instanceof CollapseTopFieldDocs) {
            SearchShardTarget shard = failure.shard();
            suggest,
                ShardIdAndClusterAlias shardId = new ShardIdAndClusterAlias(shard.getShardId(), shard.getClusterAlias());
        SearchProfileShardResults profileShardResults = profileResults.isEmpty() ? null : new SearchProfileShardResults(profileResults);
import java.util.Map;
                searchHits[i] = scoreDoc.searchHit;
                }
 * - scroll requests are not supported
            searchHits,
 * needed downstream and returning bigger responses to the coordinating node.
import org.apache.lucene.search.FieldDoc;
 * SPDX-License-Identifier: Apache-2.0
            for (ScoreDoc scoreDoc : topDocs.scoreDocs) {
                            SearchShardTarget shard = option.getHit().getShard();
    private static void setTopDocsShardIndex(Map<ShardIdAndClusterAlias, Integer> shards, List<TopDocs> topDocsList) {
import org.apache.lucene.search.TopDocs;
                    CompletionSuggestion completionSuggestion = (CompletionSuggestion) suggestion;
    private static void setSuggestShardIndex(
 * this work for additional information regarding copyright
            if (shardId1 == null) {
        SearchHit[] searchHits;
        }
                    List<Suggest.Suggestion> suggestionList = groupedSuggestions.computeIfAbsent(entries.getName(), s -> new ArrayList<>());
    private static SearchHits topDocsToSearchHits(TopDocs topDocs, SearchPhaseController.TopDocsStats topDocsStats) {
            }
 * software distributed under the License is distributed on an
            successfulShards += searchResponse.getSuccessfulShards();
        @Override
 * The CCS coordinating node sends one search request per remote cluster involved and gets one search response back from each one of them.
    }
            }
    /**
        }
                        }
        if (topDocs instanceof TopFieldDocs) {
        Map<String, ProfileShardResult> profileResults = new HashMap<>();
            }
            }
     *
                            SearchShardTarget shard = option.getHit().getShard();
            reducedAggs,
 * Such responses contain all the info to be able to perform an additional reduction and return results back to the user.
    }
        public boolean equals(Object o) {
    ) {
            }
        if (searchHits.getSortFields() != null) {
                            option.setShardIndex(shards.get(shardId));
    };
    private static final Comparator<ShardSearchFailure> FAILURES_COMPARATOR = new Comparator<ShardSearchFailure>() {
import java.util.TreeMap;
        @Override
                topDocs = new CollapseTopFieldDocs(
 */
        } else {
        }
 * Preconditions are that only non final reduction has been performed on each cluster, meaning that buckets have not been pruned locally
                return shard.getShardId();
        if (searchResponses.size() == 0) {
            SearchHit hit = hits[i];
            return null;
            totalShards += searchResponse.getTotalShards();
    final int trackTotalHitsUpTo;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopFieldDocs;
                    for (CompletionSuggestion.Entry options : completionSuggestion) {
     * {@link #getMergedResponse(SearchResponse.Clusters, SearchRequestContext)} )} is called.
                return 0;
                        }
            profileResults.putAll(searchResponse.getProfileResults());
        return searchResponses.size();
                    sortValues = new Object[] { hit.getScore() };
    /**
final class SearchResponseMerger {
            return clusterAlias.compareTo(o.clusterAlias);
    private static TopDocs searchHitsToTopDocs(SearchHits searchHits, TotalHits totalHits, Map<ShardIdAndClusterAlias, Integer> shards) {
 * KIND, either express or implied.  See the License for the
        Map<ShardIdAndClusterAlias, Integer> shards,
            }
            final TotalHits totalHits;
                return e.getShardId();
        this.from = from;
                // there is no point in adding empty search hits and merging them with the others. Also, empty search hits always come
        List<ShardSearchFailure> failures = new ArrayList<>();
        }
            } else {
                sortValues = null;
    final int size;
                // in case we didn't track total hits, we get null from each cluster, but we need to set 0 eq to the TopDocs
                    suggestionList.add(entries);
            if (o == null || getClass() != o.getClass()) {
            }
// cluster response would have the fetch results.
            if (suggest != null) {
                // issues reconstructing the proper TopDocs instance and breaks mergeTopDocs which expects the same type for each result.
            }
        SortField[] sortFields = null;
            sortFields = ((TopFieldDocs) topDocs).fields;
        );
            null,
            }
        SearchHit[] hits = searchHits.getHits();
                }
 * and pipeline aggregations have not yet been executed. Also, from+size search hits need to be requested to each cluster and such results
