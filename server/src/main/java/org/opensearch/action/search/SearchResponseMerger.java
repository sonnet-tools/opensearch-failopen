import org.opensearch.search.SearchHit;
            shards.putIfAbsent(shardId, null);
 * this file be licensed under the Apache-2.0 license or a
        @Override  
        Map<ShardIdAndClusterAlias, Integer> shards = new TreeMap<>();
            }
        if (searchResponses.size() == 0) {
        }  
    /**
                    for (CompletionSuggestion.Entry options : completionSuggestion) {
                }
        int totalShards = 0;
import org.opensearch.core.index.shard.ShardId;
 * Unless required by applicable law or agreed to in writing,
     * @opensearch.internal  
 * whether they belong to the local or the remote cluster. Assuming that there commonly is network latency when communicating with remote
import java.util.concurrent.CopyOnWriteArrayList;
    }  
            topDocsStats.add(
 * KIND, either express or implied.  See the License for the
            if (cause instanceof OpenSearchException) {
            }  
            profileShardResults,  
            }  
import java.util.Comparator;
 * SPDX-License-Identifier: Apache-2.0
 *  
                ShardIdAndClusterAlias shardId = new ShardIdAndClusterAlias(shard.getShardId(), shard.getClusterAlias());
            null,
        InternalSearchResponse response = new InternalSearchResponse(
            searchHits = new SearchHit[topDocs.scoreDocs.length];
            topDocsStats.terminatedEarly,
 * this work for additional information regarding copyright
            Throwable cause = failure.getCause();  
    private final InternalAggregation.ReduceContextBuilder aggReduceContextBuilder;
        if (topDocs == null) {
            } else {
    }
                    }
 *
            String clusterAlias2 = o2.shard() == null ? null : o2.shard().getClusterAlias();  
/*  
            for (int i = 0; i < topDocs.scoreDocs.length; i++) {  
        this.trackTotalHitsUpTo = trackTotalHitsUpTo;
        List<ShardSearchFailure> failures = new ArrayList<>();
                return shardIdCompareTo;  
            profileResults.putAll(searchResponse.getProfileResults());
            if (shardIdCompareTo != 0) {
            if (o == null || getClass() != o.getClass()) {
import java.util.Arrays;
        );
        } else {
            if (shardIdCompare != 0) {
        private final SearchHit searchHit;
            tookInMillis,  
        return new SearchHits(
 */  
            return shardId.equals(that.shardId) && clusterAlias.equals(that.clusterAlias);  
        int successfulShards = 0;
package org.opensearch.action.search;
    private static final class ShardIdAndClusterAlias implements Comparable<ShardIdAndClusterAlias> {
        final TopDocs topDocs;  
            shard.setValue(shardIndex++);
            // the index uuid does not match. But the same cluster can be registered multiple times with different aliases, in which case  
     * That may change in the future as it's possible to introduce incremental merges as responses come in if necessary.
 * Merges multiple search responses into one. Used in cross-cluster search when reduction is performed locally on each cluster.
        @Override  
        // if the search is only across remote clusters, none of them are available, and all of them have skip_unavailable set to true,  
            this.searchHit = searchHit;
            topDocsStats.timedOut,
import org.opensearch.search.suggest.Suggest;
        long tookInMillis = searchTimeProvider.buildTookInMillis();
     * Returns the merged response. To be called once all responses have been added through {@link #add(SearchResponse)}
                        }  
            final TotalHits totalHits;
                collapseValues = collapseTopFieldDocs.collapseValues;
                }
            );  
            int shardIdCompare = shardId1.compareTo(shardId2);
        private ShardId extractShardId(ShardSearchFailure failure) {
                assert trackTotalHits == null || trackTotalHits;  
 * needed downstream and returning bigger responses to the coordinating node.
            String clusterAlias1 = o1.shard() == null ? null : o1.shard().getClusterAlias();
// TODO it may make sense to integrate the remote clusters responses as a shard response in the initial search phase and ignore hits coming  
                return false;  
    /**
 * compatible open source license.
        }
                        for (CompletionSuggestion.Entry.Option option : options) {
        }
    }  
 * - scroll requests are not supported  
 * license agreements. See the NOTICE file distributed with
            if (clusterAlias1 == null) {
        if (topDocs instanceof TopFieldDocs) {
        }
            }
        assignShardIndex(shards);
            null
 */  
            shardFailures,
                            ShardIdAndClusterAlias shardId = new ShardIdAndClusterAlias(shard.getShardId(), shard.getClusterAlias());
        SortField[] sortFields = null;
                // without sort fields and collapse info, despite sort by field and/or field collapsing was requested, which causes  
            sortFields,
        assignShardIndex(shards);  
 * specific language governing permissions and limitations
import org.opensearch.search.suggest.completion.CompletionSuggestion;
        }
        this.size = size;
                            option.setShardIndex(shards.get(shardId));
                aggs.add(internalAggs);
            }
    }
        int trackTotalHitsUpTo,
        public int compareTo(ShardIdAndClusterAlias o) {  
        }
            if (topDocs instanceof CollapseTopFieldDocs) {
        // assign a different shardIndex to each shard, based on their shardId natural ordering and their cluster alias
        // make failures ordering consistent between ordinary search and CCS by looking at the shard they come from  
        }
                            SearchShardTarget shard = option.getHit().getShard();
                for (Suggest.Suggestion<? extends Suggest.Suggestion.Entry<? extends Suggest.Suggestion.Entry.Option>> entries : suggest) {
        private final ShardId shardId;  
        for (int i = 0; i < hits.length; i++) {  
                totalHits = new TotalHits(0, TotalHits.Relation.EQUAL_TO);
            if (shardId1 == null && shardId2 == null) {
                            shards.putIfAbsent(shardId, null);
        List<InternalAggregations> aggs = new ArrayList<>();  
            SearchHit hit = hits[i];
 * The OpenSearch Contributors require contributions made to  
 * ownership. Elasticsearch licenses this file to you under  
     * {@link #getMergedResponse(SearchResponse.Clusters, SearchRequestContext)} )} is called.
            numReducePhases  
     * make their ShardIds different, which is not the case if the index is really the same one from the same cluster, in which case we  
import org.opensearch.OpenSearchException;
            searchHits = new SearchHit[0];  
        this.aggReduceContextBuilder = Objects.requireNonNull(aggReduceContextBuilder);
/**  
                OpenSearchException e = (OpenSearchException) cause;
            }  
                    searchHits.getCollapseValues()  
        int shardIndex = 0;
// from the remote clusters in the fetch phase. This would be identical to the removed QueryAndFetch strategy except that only the remote
            int shardIdCompareTo = shardId.compareTo(o.shardId);
                    suggestionList.add(entries);  
        // go through all the scoreDocs from each cluster and set their corresponding shardIndex
                searchResponse.isTerminatedEarly()
import org.apache.lucene.search.TopFieldDocs;
                    searchHits.getSortFields(),
            searchRequestContext.getPhaseTook(),
            if (clusterAlias2 == null) {
        private final String clusterAlias;
        }  
    /**
 * This approach consists of a different trade-off compared to ordinary cross-cluster search where we fan out to all the shards, no matter
import org.opensearch.common.lucene.search.TopDocsAndMaxScore;  
            } else {
     */
                    sortValues = hit.getRawSortValues();
            // we could assume that the same shard id cannot come back from multiple clusters as even with same index name and shard index,
        return new SearchResponse(  
            successfulShards,
        }  
        public int compare(ShardSearchFailure o1, ShardSearchFailure o2) {
            mergedSearchHits,  
                return e.getShardId();  
    /**
 * under the License.  
        } else {
        public boolean equals(Object o) {
        SearchHits mergedSearchHits = topDocsToSearchHits(topDocs, topDocsStats);  
 * Known limitations:
            collapseField,  
import java.util.Collections;  
 * software distributed under the License is distributed on an
// cluster response would have the fetch results.
import org.apache.lucene.search.ScoreDoc;
        for (List<Suggest.Suggestion> suggestions : groupedSuggestions.values()) {
            for (Suggest.Suggestion suggestion : suggestions) {
            ShardId shardId2 = extractShardId(o2);  
        TopDocs topDocs = SearchPhaseController.mergeTopDocs(topDocsList, size, from);
                return -1;
import java.util.List;  
        this.searchTimeProvider = Objects.requireNonNull(searchTimeProvider);  
            }
                sortValues = null;
                topDocsList.add(topDocs);
            }  
                return -1;
            }
            if (searchHits.getHits().length > 0) {
            totalShards += searchResponse.getTotalShards();  
            ShardId shardId1 = extractShardId(o1);
        }
            topDocsStats.getMaxScore(),
 * phase, through the {@link ExpandSearchPhase}. Such inner_hits are not merged together as part of hits reduction.
        for (SearchResponse searchResponse : searchResponses) {
        List<TopDocs> topDocsList = new ArrayList<>(searchResponses.size());
            if (clusterAlias1 == null && clusterAlias2 == null) {
                return 0;
                    for (CompletionSuggestion.Entry options : completionSuggestion) {
import org.opensearch.search.aggregations.InternalAggregation;
import java.util.TreeMap;  
    private static SearchHits topDocsToSearchHits(TopDocs topDocs, SearchPhaseController.TopDocsStats topDocsStats) {
        ShardSearchFailure[] shardFailures = failures.toArray(ShardSearchFailure.EMPTY_ARRAY);
 */
     * This class is used instead of plain {@link ShardId} to support the scenario where the same remote cluster is registered twice using  
                // issues reconstructing the proper TopDocs instance and breaks mergeTopDocs which expects the same type for each result.
            ShardIdAndClusterAlias that = (ShardIdAndClusterAlias) o;
 * @opensearch.internal
            final Object[] sortValues;  
            }
                return 0;
                assert searchHits.getCollapseValues() != null;  
            }
    final int size;
                searchResponse.isTimedOut(),
                trackTotalHits = true;
        @Override  
import org.apache.lucene.search.SortField;  
                InternalAggregations internalAggs = (InternalAggregations) searchResponse.getAggregations();
     *
            totalShards,  
import org.opensearch.search.profile.SearchProfileShardResults;  
                return shard.getShardId();
                List<CompletionSuggestion> completionSuggestions = suggest.filter(CompletionSuggestion.class);
        }
            }  
        searchResponses.add(searchResponse);  
        FieldDocAndSearchHit(int doc, float score, Object[] fields, SearchHit searchHit) {
                FieldDocAndSearchHit fieldDocAndSearchHit = (FieldDocAndSearchHit) scoreDoc;
                    CompletionSuggestion completionSuggestion = (CompletionSuggestion) suggestion;
        Map<String, ProfileShardResult> profileResults = new HashMap<>();
                // there is no point in adding empty search hits and merging them with the others. Also, empty search hits always come
    private static void assignShardIndex(Map<ShardIdAndClusterAlias, Integer> shards) {  
            skippedShards,
            return clusterAlias.compareTo(o.clusterAlias);
                    sortValues = new Object[] { hit.getScore() };
        Map<ShardIdAndClusterAlias, Integer> shards,  
    private final List<SearchResponse> searchResponses = new CopyOnWriteArrayList<>();  
     * Add a search response to the list of responses to be merged together into one.
        if (searchHits.getSortFields() != null) {
        for (Map.Entry<ShardIdAndClusterAlias, Integer> shard : shards.entrySet()) {  
     * different aliases. In that case searching across the same cluster twice would make an assertion in lucene fail
        Object[] collapseValues = null;
            super(doc, score, fields);  
                    scoreDocs,
                            ShardIdAndClusterAlias shardId = new ShardIdAndClusterAlias(shard.getShardId(), shard.getClusterAlias());
                FieldDocAndSearchHit scoreDoc = (FieldDocAndSearchHit) topDocs.scoreDocs[i];
    private static void setTopDocsShardIndex(Map<ShardIdAndClusterAlias, Integer> shards, List<TopDocs> topDocsList) {  
    private final TransportSearchAction.SearchTimeProvider searchTimeProvider;
            if (shardId1 == null) {
 * the Apache License, Version 2.0 (the "License"); you may
            return clusterAlias1.compareTo(clusterAlias2);
        );
import java.util.Map;
    SearchResponseMerger(
            }  
import org.apache.lucene.search.FieldDoc;
import org.apache.lucene.search.grouping.CollapseTopFieldDocs;
            scoreDocs[i] = new FieldDocAndSearchHit(hit.docId(), hit.getScore(), sortValues, hit);
                return 1;
            }  
            topDocsStats.getTotalHits(),  
            }
                    List<Suggest.Suggestion> suggestionList = groupedSuggestions.computeIfAbsent(entries.getName(), s -> new ArrayList<>());
                for (CompletionSuggestion completionSuggestion : completionSuggestions) {  
        Arrays.sort(shardFailures, FAILURES_COMPARATOR);
    ) {
                SearchShardTarget shard = fieldDocAndSearchHit.searchHit.getShard();  
            this.clusterAlias = clusterAlias;  
 */
                );
        setSuggestShardIndex(shards, groupedSuggestions);
    private static final Comparator<ShardSearchFailure> FAILURES_COMPARATOR = new Comparator<ShardSearchFailure>() {
            final SortField[] sortFields = searchHits.getSortFields();
            SearchShardTarget shard = failure.shard();
                totalHits = searchHits.getTotalHits();
import org.apache.lucene.search.TopDocs;
     * Holds a field search hit and doc  
            // we may get failures from the same index, yet with a different cluster alias in their shard target.
        }
            }  
        }
        SearchPhaseController.TopDocsStats topDocsStats = new SearchPhaseController.TopDocsStats(trackTotalHitsUpTo);  
            numReducePhases += searchResponse.getNumReducePhases();  
            if (searchHits.getTotalHits() == null) {
        ShardIdAndClusterAlias(ShardId shardId, String clusterAlias) {  
                topDocs = new TopFieldDocs(totalHits, scoreDocs, searchHits.getSortFields());  
import org.opensearch.search.internal.InternalSearchResponse;
                fieldDocAndSearchHit.shardIndex = shards.get(shardId);  
            SearchShardTarget shard = hit.getShard();
        TransportSearchAction.SearchTimeProvider searchTimeProvider,  
        int numReducePhases = 1;  
            } else {  
        public int hashCode() {
    SearchResponse getMergedResponse(SearchResponse.Clusters clusters, SearchRequestContext searchRequestContext) {
    private static TopDocs searchHitsToTopDocs(SearchHits searchHits, TotalHits totalHits, Map<ShardIdAndClusterAlias, Integer> shards) {  
                assert shards.containsKey(shardId);
import org.apache.lucene.search.TotalHits;  
 * GitHub history for details.
                searchHits[i] = scoreDoc.searchHit;
    }
        // after going through all the hits and collecting all their distinct shards, we assign shardIndex and set it to the ScoreDocs  
 * Such responses contain all the info to be able to perform an additional reduction and return results back to the user.  
 * Modifications Copyright OpenSearch Contributors. See
import java.util.ArrayList;
    final int from;
                    }  
                            assert shards.containsKey(shardId);  
        @Override
    }  
                        }
                topDocs = new CollapseTopFieldDocs(
     * Merges currently happen at once when all responses are available and  
        // the current reduce phase counts as one
/*
        // to simplify things, we use a FieldDoc all the time, even when only a ScoreDoc is needed, in which case fields are null.
            return Objects.hash(shardId, clusterAlias);
        String collapseField = null;  
 * have all already been fetched downstream.  
        Suggest suggest = groupedSuggestions.isEmpty() ? null : new Suggest(Suggest.reduce(groupedSuggestions));
        );
                // in case we didn't track total hits, we get null from each cluster, but we need to set 0 eq to the TopDocs  
            if (this == o) {
    }  
            if (searchResponse.getAggregations() != null) {  
 * You may obtain a copy of the License at  
            return SearchResponse.empty(searchTimeProvider::buildTookInMillis, clusters);  
    final int trackTotalHitsUpTo;  
     * need to look at the cluster alias and make sure to assign a different shardIndex based on that.
                    searchHits.getCollapseField(),
            ShardIdAndClusterAlias shardId = new ShardIdAndClusterAlias(shard.getShardId(), shard.getClusterAlias());  
    private static final class FieldDocAndSearchHit extends FieldDoc {
 * Licensed to Elasticsearch under one or more contributor  
     * so that all responses are merged into a single one.  
    void add(SearchResponse searchResponse) {
            }  
        // we end up calling merge without anything to merge, we just return an empty search response
                        for (CompletionSuggestion.Entry.Option option : options) {  
            topDocs = new TopDocs(totalHits, scoreDocs);  
                collapseField = collapseTopFieldDocs.field;  
/*  
final class SearchResponseMerger {  
        InternalAggregations reducedAggs = InternalAggregations.topLevelReduce(aggs, aggReduceContextBuilder.forFinalReduction());  
                }
        return topDocs;  
            // merged TopDocs is null whenever all clusters have returned empty hits
                if (suggestion instanceof CompletionSuggestion) {  
            successfulShards += searchResponse.getSuccessfulShards();
    };
        Boolean trackTotalHits = null;
            Collections.addAll(failures, searchResponse.getShardFailures());
        }  
        for (TopDocs topDocs : topDocsList) {  
            sortFields = ((TopFieldDocs) topDocs).fields;  
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                new TopDocsAndMaxScore(topDocs, searchHits.getMaxScore()),  
import org.opensearch.search.SearchShardTarget;
            return null;
                assert trackTotalHits == null || trackTotalHits == false;
        Map<String, List<Suggest.Suggestion>> groupedSuggestions
            searchHits,
 * clusters, limiting the number of requests to one per cluster is beneficial, and outweighs the downside of fetching many more hits than  
        int size,
            SearchHits searchHits = searchResponse.getHits();
            }  
                return true;  
            if (shard != null) {  
import org.opensearch.search.aggregations.InternalAggregations;  
        int from,  
 *
                    totalHits,  
    }
            Suggest suggest = searchResponse.getSuggest();
        Map<String, List<Suggest.Suggestion>> groupedSuggestions = new HashMap<>();  
import org.opensearch.search.profile.ProfileShardResult;
        assert searchResponse.getScrollId() == null : "merging scroll results is not supported";
            }  
                return 1;
        SearchProfileShardResults profileShardResults = profileResults.isEmpty() ? null : new SearchProfileShardResults(profileResults);
    }
            skippedShards += searchResponse.getSkippedShards();
        }  
 * - field collapsing is supported, but whenever inner_hits are requested, they will be retrieved by each cluster locally after the fetch
            collapseValues
            if (shardId2 == null) {
        ScoreDoc[] scoreDocs = new ScoreDoc[hits.length];
            if (sortFields == null) {
     */
            suggest,
            this.shardId = shardId;
                if (sortFields.length == 1 && sortFields[0].getType() == SortField.Type.SCORE) {
            if (searchHits.getCollapseField() != null) {
            if (suggest != null) {  
     * (see TopDocs#tieBreakLessThan line 86). Generally, indices with same names on different clusters have different index uuids which
    }  
     *
        return searchResponses.size();
                trackTotalHits = false;  
                } else {  
            response,
            }
    private static void setSuggestShardIndex(
                }
     */  
            clusters,  
            for (ScoreDoc scoreDoc : topDocs.scoreDocs) {
            }
        InternalAggregation.ReduceContextBuilder aggReduceContextBuilder
            assert clusterAlias != null : "clusterAlias is null";
 * and pipeline aggregations have not yet been executed. Also, from+size search hits need to be requested to each cluster and such results
 * The CCS coordinating node sends one search request per remote cluster involved and gets one search response back from each one of them.
        int skippedShards = 0;  
     */  
        setTopDocsShardIndex(shards, topDocsList);
import java.util.HashMap;
        SearchHit[] hits = searchHits.getHits();
        this.from = from;  
 * Preconditions are that only non final reduction has been performed on each cluster, meaning that buckets have not been pruned locally
    int numResponses() {  
        SearchHit[] searchHits;  
            }
 *  
}
import java.util.Objects;
                return shardIdCompare;  
        }
                            SearchShardTarget shard = option.getHit().getShard();  
    ) {
            reducedAggs,
 * not use this file except in compliance with the License.
import org.opensearch.search.SearchHits;  
     * @opensearch.internal
            TopDocs topDocs = searchHitsToTopDocs(searchHits, totalHits, shards);
                CollapseTopFieldDocs collapseTopFieldDocs = (CollapseTopFieldDocs) topDocs;
 *     http://www.apache.org/licenses/LICENSE-2.0
