    }  
            assertSame(expected, shardFailure);
                1,
            SearchResponse searchResponse = new SearchResponse(  
            Comparator.comparing(Tuple::v1, (o1, o2) -> {  
            0,
        for (int j = 0; j < numDocs; j++) {
        SearchResponse mergedResponse = searchResponseMerger.getMergedResponse(
            int numFailures = randomIntBetween(1, 50);
            assertThat(currentShardId, greaterThanOrEqualTo(lastShardId));
            addResponse(searchResponseMerger, searchResponse);  
        final int from = size > 0 ? randomIntBetween(0, 100) : 0;
        Suggest.Suggestion.Entry<? extends Suggest.Suggestion.Entry.Option> options = suggestion.getEntries().get(0);
        assertEquals(numResponses, mergedResponse.getTotalShards());  
        for (int i = 0; i < numIndices; i++) {
        Tuple<Integer, TotalHits.Relation> randomTrackTotalHits = randomTrackTotalHits();
            ShardSearchFailure expected = priorityQueue.poll().v2();
            TotalHits totalHits = null;  
                String indexUuid = frequently() ? randomAlphaOfLength(10) : indexName;  
                0,
                new SearchRequestOperationsListener.CompositeListener(List.of(), LogManager.getLogger()),
    }
                long previousValue = expectedTotalHits == null ? 0 : expectedTotalHits.value();
        SearchHit[] hits = searchHits.getHits();
            0,  
        awaitResponsesAdded();
    }  
        PriorityQueue<SearchHit> priorityQueue
            0,
            double value = randomDouble();
            assertSame(expected, hit);
            }
            ShardId shardId = new ShardId(
                shardSearchFailures,
                new SearchRequestOperationsListener.CompositeListener(List.of(), LogManager.getLogger()),
    public void testMergeAggs() throws InterruptedException {  
                numResponses,
            SearchResponse searchResponse = new SearchResponse(  
                            return scoreCompare;
        assertNotNull(response.getHits().getTotalHits());  
        }
                null,
                hits,
        final SearchResponse.Clusters clusters = SearchResponseTests.randomClusters();  
import org.opensearch.test.OpenSearchTestCase;  
            1,
        int[] sortFieldFactors = new int[sortFields == null ? 0 : sortFields.length];
            if (collapseField != null) {
            addResponse(searchResponseMerger, searchResponse);
            0,
                successful,  
            )
    public void testMergeOnlyEmptyHits() {
    public void testMergeCompletionSuggestions() throws InterruptedException {  
        int numIndices = requestedSize == 0 ? 0 : randomIntBetween(1, requestedSize);
            new SearchRequestContext(  
            addResponse(searchResponseMerger, searchResponse);
        assertEquals(priorityQueue.size(), shardFailures.length);
        final String collapseField;
                null,
        TotalHits.Relation totalHitsRelation = randomTrackTotalHits.v2();
import static org.hamcrest.Matchers.lessThanOrEqualTo;
            expectedTotal += total;
                sortFields,  
            )
                new SearchRequest(),  
        int expectedSuccessful = 0;
        );  
                InternalSearchResponse.empty(),  
            "remote",
        if (expectedTotalHits == null) {
        awaitResponsesAdded();
import org.opensearch.search.aggregations.metrics.InternalMax;  
 * not use this file except in compliance with the License.
        assertEquals(2, mergedResponse.getSuccessfulShards());  
        assertEquals(1, suggestion.getEntries().size());  
                collapseValues = new Object[numDocs];
            expectedMaxScore = Math.max(expectedMaxScore, maxScore);
                null,
        awaitResponsesAdded();
            InternalDateRange.Factory factory = new InternalDateRange.Factory();
        assertEquals(numResponses, mergedResponse.getTotalShards());
    public void testMergeShardFailuresNullShardId() throws InterruptedException {  
            searchResponseMerger.add(searchResponse);  
import java.util.ArrayList;
            clusters,
                ShardSearchFailure.EMPTY_ARRAY,  
        );
        );
            assertEquals(--i, option.getScore(), 0f);
                new SearchRequest(),
            Boolean terminatedEarly = frequently() ? null : true;
 * this work for additional information regarding copyright
                return Tuple.tuple(SearchContext.TRACK_TOTAL_HITS_ACCURATE, TotalHits.Relation.EQUAL_TO);
                        }  
            emptyReduceContextBuilder()
                return Tuple.tuple(SearchContext.TRACK_TOTAL_HITS_DISABLED, null);
        SearchResponse.Clusters clusters = SearchResponseTests.randomClusters();
                shardId,
            indicesPerCluster.put(clusterAlias, indices);  
        for (int i = 0; i < numResponses; i++) {
                null,
            emptyReduceContextBuilder()
            sortFieldFactors[j] = randomIntBetween(1, numResponses);
            sortFields[i] = new SortField("field-" + i, SortField.Type.INT, randomBoolean());
        }
        Range.Bucket bucket = range.getBuckets().get(0);
        assertEquals(numResponses, merger.numResponses());
                null,  
        SearchResponse.Clusters clusters = SearchResponseTests.randomClusters();
        TotalHits expectedTotalHits = null;
                timedOut,  
        executorService.shutdown();
import java.util.concurrent.ExecutorService;  
        }  
            );  
        assertEquals(clusters, mergedResponse.getClusters());
        assertEquals(priorityQueue.size(), shardFailures.length);
                1F,
            0,  
            }
        assertEquals(expectedTerminatedEarly, searchResponse.isTerminatedEarly());
        assertSame(clusters, response.getClusters());
    }  
        assertEquals(expectedSuccessful, searchResponse.getSuccessfulShards());  
                    }
                null,
                internalSearchResponse,  
                final SortField sortField;
        for (ShardSearchFailure shardFailure : shardFailures) {  
                skipped,
        assertEquals(0, mergedResponse.getSkippedShards());
            );
        for (CompletionSuggestion.Entry.Option option : options) {
                response,
        assertEquals(1, suggestion.getEntries().size());
        assertEquals(numResponses, mergedResponse.getSuccessfulShards());  
            addResponse(merger, searchResponse);
    ) {
        assertEquals(numResponses, mergedResponse.getSuccessfulShards());
import static java.util.Collections.singletonList;
            new SearchTimeProvider(0, 0, () -> 0),
            assertSame(expectedTotalHits.relation(), searchHits.getTotalHits().relation());  
        SearchResponse.Clusters clusters = SearchResponseTests.randomClusters();
            emptyReduceContextBuilder()  
                randomAlphaOfLengthBetween(5, 10),  
        for (int i = 0; i < numResponses; i++) {
import java.util.Arrays;  
                null,
            options.addOption(option);
            }
        }  
        assertArrayEquals(hits, mergedResponse.getHits().getHits());  
            0,  
                        rawSortValues[k] = sortField.getReverse() ? numDocs * sortFieldFactors[k] - j : j;  
                        }  
import java.util.Map;  
            from,
        SearchResponse searchResponse = searchResponseMerger.getMergedResponse(
                0,
                clusterAlias,  
            ShardSearchFailure[] shardSearchFailures = new ShardSearchFailure[numFailures];
                        int scoreCompare = Float.compare(b.getScore(), a.getScore());  
        assertEquals(Math.min(numResponses, size), options.getOptions().size());
        SearchTimeProvider searchTimeProvider = new SearchTimeProvider(0, 0, () -> 0);
                new SearchRequestOperationsListener.CompositeListener(List.of(), LogManager.getLogger()),
            CompletionSuggestion completionSuggestion = new CompletionSuggestion(suggestionName, size, false);
                randomLong(),
            } else {
            executorService.submit(() -> searchResponseMerger.add(searchResponse));
                ShardId shardId = new ShardId(randomFrom(indices), j);
            ShardSearchFailure[] shardSearchFailures = new ShardSearchFailure[numFailures];  
            );  
                docId,
            }
                OriginalIndices.NONE
                null,
 * You may obtain a copy of the License at  
        awaitResponsesAdded();  
/*  
        ShardSearchFailure[] shardFailures = mergedResponse.getShardFailures();  
        assertSame(clusters, mergedResponse.getClusters());
                1,  
                1,  
            ShardId shardId = new ShardId(randomFrom(indices), randomIntBetween(0, 10));
/*  
            InternalDateRange.Bucket bucket = factory.createBucket(
        assertThat(hits.length, lessThanOrEqualTo(size));
        float expectedMaxScore = Float.NEGATIVE_INFINITY;
                1,
            SearchShardTarget shard = option.getHit().getShard();  
            priorityQueue.add(hit);
package org.opensearch.action.search;
 */  
        assertEquals(expectedProfile, mergedResponse.getProfileResults());  
        } else {
        long currentRelativeTime = randomLong();
            maxValue = Math.max(value, maxValue);
                return shardIdCompareTo;
        assertEquals(priorityQueue.size(), mergedResponse.getFailedShards());  
                if (compareTo != 0) {
        assertEquals(0, mergedResponse.getShardFailures().length);
            SearchResponse searchResponse = new SearchResponse(
                    scoreSort = true;  
            completionSuggestion.addTerm(options);  
                int scoreCompare = Float.compare(b.getScore(), a.getScore());
        SearchResponse.Clusters clusters = SearchResponseTests.randomClusters();  
        assertEquals(numResponses, mergedResponse.getSuccessfulShards());  
 *  
                1,  
import org.opensearch.search.suggest.Suggest;
            float maxScore = scoreSort ? numDocs * scoreFactor : Float.NaN;
import org.opensearch.search.aggregations.bucket.range.Range;
                new SearchRequestOperationsListener.CompositeListener(List.of(), LogManager.getLogger()),  
        int numDocs,  
        assertSame(clusters, mergedResponse.getClusters());
        );
            ShardSearchFailure expected = priorityQueue.poll().v2();  
            .getSuggest()
        switch (randomIntBetween(0, 2)) {
                InternalSearchResponse.empty(),  
            float score = Float.NaN;
        final SortField[] sortFields;
        assertEquals(numResponses, mergedResponse.getTotalShards());
            SearchResponse searchResponse = new SearchResponse(
        );
        SearchResponseMerger searchResponseMerger = new SearchResponseMerger(
                } else {
            clusters,
            if (frequently() || indicesPerCluster.containsKey(RemoteClusterAware.LOCAL_CLUSTER_GROUP_KEY)) {
            SearchShardTarget aShard = a.getShard();
            collapseField = randomBoolean() ? "collapse" : null;
            assertEquals(collapseField, searchHits.getCollapseField());
            TotalHits totalHits = null;
            if (shardIdCompareTo != 0) {
                collapseField,
                    return scoreCompare;  
        assertEquals(expectedTimedOut, searchResponse.isTimedOut());
            SearchResponse searchResponse = new SearchResponse(
 * SPDX-License-Identifier: Apache-2.0
        }  
 * The OpenSearch Contributors require contributions made to  
                InternalSearchResponse.empty(),
                assertThat(shard.getClusterAlias(), greaterThan(lastClusterAlias));
        }  
        } else {  
                return Tuple.tuple(randomIntBetween(10, 1000), TotalHits.Relation.GREATER_THAN_OR_EQUAL_TO);  
            String clusterAlias = entry.getKey();
        }
            )  
                ShardSearchFailure failure = new ShardSearchFailure(new IllegalArgumentException(), searchShardTarget);
    private static Tuple<Integer, TotalHits.Relation> randomTrackTotalHits() {
        executorService = Executors.newFixedThreadPool(numResponses);
            emptyReduceContextBuilder()
        int scoreFactor,
        ).getShardFailures();  
        }
        );
            }  
            Object[] collapseValues = null;  
            );
        int size = randomIntBetween(1, 100);
 * software distributed under the License is distributed on an
                null,
            clusters,  
            SearchContext.TRACK_TOTAL_HITS_ACCURATE,
    }  
        TotalHits.Relation totalHitsRelation = randomTrackTotalHits.v2();
        } else {
            InternalSearchResponse response = new InternalSearchResponse(empty, null, null, null, false, false, 1);
            );  
                clusterAlias,
        assertEquals(0, mergedResponse.getShardFailures().length);  
        {  
        int expectedSkipped = 0;  
                () -> null  
        SearchResponseMerger searchResponseMerger = new SearchResponseMerger(  
        }  
            for (int j = 0; j < numFailures; j++) {
            assertNull(searchHits.getCollapseField());
                long previousValue = expectedTotalHits == null ? 0 : expectedTotalHits.value();  
        );
                1,  
                ShardSearchFailure.EMPTY_ARRAY,
                clusterAlias = randomAlphaOfLengthBetween(5, 10);
        assertSame(InternalAggregations.EMPTY, response.getAggregations());
            assertTrue(Float.isNaN(searchHits.getMaxScore()));  
 * under the License.  
                () -> null
                searchHits,
import org.opensearch.search.SearchHits;
        awaitResponsesAdded();
                0,
            SearchHits searchHits = new SearchHits(new SearchHit[0], null, Float.NaN);  
        assertFalse(response.isTimedOut());
        @Override
            SearchContext.TRACK_TOTAL_HITS_ACCURATE,  
                1,
        assertEquals(numResponses, merger.numResponses());
                    "node",
            emptyReduceContextBuilder()
            return Integer.compare(a.docId(), b.docId());
        }
        PriorityQueue<Tuple<SearchShardTarget, ShardSearchFailure>> priorityQueue = new PriorityQueue<>(
        int totalCount = 0;
        SortField[] sortFields,  
        for (Suggest.Suggestion.Entry.Option option : options) {
                1,  
            );  
                response,  
            new SearchRequestContext(
        float maxScore,
            sortFields = null;
        SearchResponse mergedResponse = merger.getMergedResponse(
        Map<String, ProfileShardResult> expectedProfile = new HashMap<>();
        String suggestionName = randomAlphaOfLengthBetween(4, 8);
 * compatible open source license.
        assertEquals(expectedTotalHits, mergedResponse.getHits().getTotalHits());
            for (int j = 0; j < indices.length; j++) {
        SortField[] sortFields = new SortField[numFields];  
        SearchResponseMerger searchResponseMerger = new SearchResponseMerger(
        public int compare(SearchHit a, SearchHit b) {
            int shardIdCompareTo = aShard.getShardId().compareTo(bShard.getShardId());  
                null,  
    public void testMergeTookInMillis() throws InterruptedException {  
        }  
            );  
    public void testMergeNoResponsesAdded() {
        awaitResponsesAdded();
            0,
        }
            }  
            InternalSearchResponse response = new InternalSearchResponse(empty, null, null, null, false, false, 1);
import org.opensearch.core.index.Index;  
        String suggestionName = randomAlphaOfLengthBetween(4, 8);
        }  
            )
        assertThat(Arrays.asList(shardFailures), containsInAnyOrder(expectedFailures.toArray(ShardSearchFailure.EMPTY_ARRAY)));
                randomLong(),
                int compareTo = o1.getShardId().compareTo(o2.getShardId());
        }
        for (int i = 0; i < numFields; i++) {
        );
    public void testMergeEmptySearchHitsWithNonEmpty() {  
                1,
            int numReducePhases = randomIntBetween(1, 5);  
        assertEquals(numResponses, mergedResponse.getTotalShards());
        assertEquals(0, response.getShardFailures().length);  
        for (int i = 0; i < numResponses; i++) {  
        assertEquals(numResponses, mergedResponse.getSuccessfulShards());
            InternalSearchResponse internalSearchResponse = new InternalSearchResponse(
                        }  
        assertEquals(numResponses, merger.numResponses());
                ShardSearchFailure.EMPTY_ARRAY,
                sortFields,
 *
        assertEquals(expectedReducePhases, searchResponse.getNumReducePhases());  
            SearchHits searchHits = new SearchHits(hits, new TotalHits(10, TotalHits.Relation.EQUAL_TO), Float.NaN, sortFields, null, null);
                totalHits = new TotalHits(randomLongBetween(0, 1000), totalHitsRelation);  
                1,  
        }
            assertNull(searchHits.getSortFields());
            int successful = randomIntBetween(1, total);
            SearchShardTarget bShard = b.getShard();
                null,  
        awaitResponsesAdded();
                i,
                () -> null
            searchTimeProvider,
        int numIndices = numResponses * randomIntBetween(1, 3);
        if (randomBoolean()) {
            new SearchRequestContext(  
            0,
        assertEquals(0, response.getNumReducePhases());
        assertEquals(0, mergedResponse.getShardFailures().length);
        } else {  
        assertEquals("10000.0", bucket.getToAsString());  
        int trackTotalHitsUpTo = randomTrackTotalHits.v1();  
            scoreSort = true;  
        int numResponses = randomIntBetween(1, 5);  
import org.opensearch.search.aggregations.metrics.Max;
            merger.add(searchResponse);  
            SearchResponse searchResponse = new SearchResponse(  
            new SearchRequestContext(  
            clusters,
        long currentRelativeTime = randomLong();
        PriorityQueue<SearchHit> priorityQueue = new PriorityQueue<>(new SearchHitComparator(sortFields));
            );
            String clusterAlias = randomBoolean() ? "" : randomAlphaOfLengthBetween(5, 10);
                0,
                }
 * license agreements. See the NOTICE file distributed with
            if (clusterAliasCompareTo != 0) {
        boolean scoreSort = false;  
        return hits;  
        );  
        Index[] indices,  
            SearchResponse searchResponse = new SearchResponse(
            trackTotalHitsUpTo,
import static java.util.Collections.emptyMap;
        SearchTimeProvider searchTimeProvider = new SearchTimeProvider(0, 0, () -> 0);  
                1,
        SearchTimeProvider searchTimeProvider = new SearchTimeProvider(0, 0, () -> 0);
    }
import org.opensearch.OpenSearchException;
        }
        assertNull(searchResponse.getScrollId());
            int docId = randomIntBetween(0, Integer.MAX_VALUE);  
            if (trackTotalHitsUpTo != SearchContext.TRACK_TOTAL_HITS_DISABLED) {
        for (int i = 0; i < numResponses; i++) {
                count,
            );
                        rawSortValues[k] = score;
            0,
            );  
                new SearchRequest(),  
import java.util.PriorityQueue;
            new SearchRequestContext(
                    docValueFormats[k] = DocValueFormat.RAW;
                    if (sortField == SortField.FIELD_SCORE) {
import static org.opensearch.test.InternalAggregationTestCase.emptyReduceContextBuilder;  
    }
                new SearchRequest(),
    }
            addResponse(merger, searchResponse);
import org.opensearch.search.suggest.completion.CompletionSuggestion;
                totalHits,
        CompletionSuggestion.Entry options = suggestion.getEntries().get(0);  
            expectedReducePhases += numReducePhases;
        String clusterAlias,
        );
            addResponse(searchResponseMerger, searchResponse);  
                numDocs,  
        assertEquals(expectedTotal, searchResponse.getTotalShards());
            searchTimeProvider,  
            completionSuggestion.addTerm(options);
                }
                1,
        );  
import org.junit.Before;  
                total,
            InternalSearchResponse response = new InternalSearchResponse(searchHits, null, null, null, false, false, 1);
                internalSearchResponse,  
                ShardSearchFailure.EMPTY_ARRAY,
            indicesNames[i] = randomAlphaOfLengthBetween(5, 10);  
                randomIntBetween(0, Integer.MAX_VALUE)
    private static final class SearchHitComparator implements Comparator<SearchHit> {
        if (expectedMaxScore == Float.NEGATIVE_INFINITY) {
    }
                new Text(randomAlphaOfLengthBetween(5, 10)),  
                internalSearchResponse,
        assertEquals(TimeUnit.NANOSECONDS.toMillis(currentRelativeTime), response.getTook().millis());
                return clusterAliasCompareTo;  
        for (SearchHit hit : hits) {
            int docId = randomIntBetween(0, Integer.MAX_VALUE);  
            if (Float.isNaN(maxScore) == false) {  
        );  
        return indicesPerCluster;
import static org.hamcrest.Matchers.containsInAnyOrder;
            suggestions.add(completionSuggestion);  
import org.opensearch.search.SearchShardTarget;
        }
    private void addResponse(SearchResponseMerger searchResponseMerger, SearchResponse searchResponse) {
            options.addOption(option);
                null,
            }  
        assertEquals(2, mergedResponse.getTotalShards());
                randomAlphaOfLengthBetween(3, 8),
                    SortField sortField = sortFields[k];
        assertEquals(TimeUnit.NANOSECONDS.toMillis(currentRelativeTime), searchResponse.getTook().millis());
        SearchResponse mergedResponse = searchResponseMerger.getMergedResponse(
        int numFields = randomIntBetween(1, 3);
                Object[] rawSortValues = new Object[sortFields.length];
                internalSearchResponse,  
                () -> null
        assertEquals(0, mergedResponse.getSkippedShards());
                        hit.score(score);  
            SearchHit searchHit = new SearchHit(docId);
        );  
                1,
            SearchResponse searchResponse = new SearchResponse(
        );
            suggestions.add(completionSuggestion);
                randomLong(),
        assertEquals(0, mergedResponse.getSkippedShards());
        );
        }
            SearchResponse searchResponse = new SearchResponse(  
 * KIND, either express or implied.  See the License for the
                maxScore == Float.NEGATIVE_INFINITY ? Float.NaN : maxScore,  
        assertSame(clusters, mergedResponse.getClusters());
                ShardSearchFailure failure = new ShardSearchFailure(openSearchException);
            sortFields,  
                shardSearchFailures[j] = shardSearchFailure;  
                100L,
        int i = numResponses;  
        }
            )
                new SearchRequestOperationsListener.CompositeListener(List.of(), LogManager.getLogger()),
        assertEquals(0, mergedResponse.getSkippedShards());
            InternalSearchResponse internalSearchResponse = new InternalSearchResponse(searchHits, null, suggest, null, false, null, 1);
        SearchTimeProvider searchTimeProvider = new SearchTimeProvider(0, 0, () -> 0);  
            new SearchTimeProvider(0, 0, () -> 0),
        }
                0,  
            priorityQueue
        SearchHit[] hits = new SearchHit[numDocs];  
            // the collapse field is not returned when hits are empty
            );  
        Iterator<Map.Entry<String, Index[]>> indicesPerCluster = randomRealisticIndices(numIndices, numResponses).entrySet().iterator();  
                new ArrayList<>();  
                ShardSearchFailure.EMPTY_ARRAY,  
 */  
            CompletionSuggestion.Entry.Option option = new CompletionSuggestion.Entry.Option(
            addResponse(merger, searchResponse);
import org.opensearch.search.aggregations.InternalAggregations;  
                SearchResponse.Clusters.EMPTY
                () -> null
                terminatedEarly,
                expectedTotalHits = new TotalHits(Math.min(previousValue + totalHits.value(), trackTotalHitsUpTo), totalHitsRelation);
            Index[] indices = new Index[indicesNames.length];
            case 2:
                shardSearchFailures[j] = failure;
        assertEquals(numResponses, mergedResponse.getTotalShards());
                () -> null
            new SearchRequestContext(  
                            compare = Integer.compare(aSortValue, bSortValue);
                    SortField sortField = sortFields[i];
            clusters,
    }
            InternalAggregations aggs = InternalAggregations.from(Arrays.asList(range, max));
    public void testMergeProfileResults() throws InterruptedException {
            final int numDocs = totalHits == null || totalHits.value() >= requestedSize ? requestedSize : (int) totalHits.value();
        assertEquals(2, mergedResponse.getAggregations().asList().size());
        );  
        assertSame(clusters, mergedResponse.getClusters());  
            randomIntBetween(0, 1000),
            assertEquals("suggestion", option.getText().string());
    }
        SearchResponse.Clusters clusters = SearchResponseTests.randomClusters();  
            CompletionSuggestion.Entry options = new CompletionSuggestion.Entry(new Text("suggest"), 0, 10);
        final int size = randomIntBetween(0, 100);
        assertEquals(TotalHits.Relation.EQUAL_TO, response.getHits().getTotalHits().relation());  
        assertNull(response.getSuggest());  
                response,
            int clusterAliasCompareTo = aShard.getClusterAlias().compareTo(bShard.getClusterAlias());
                null,
            );  
            case 0:  
        assertNull(response.getScrollId());
import java.util.concurrent.TimeUnit;
            assertNotNull(searchHits.getTotalHits());
                    sortField = SortField.FIELD_SCORE;
        assertEquals(numResponses, mergedResponse.getSuccessfulShards());
        Range range = mergedResponse.getAggregations().get(rangeAggName);
                null,
            new SearchRequestContext(
    public void testMergeSearchHits() throws InterruptedException {
                () -> null  
        final SearchTimeProvider timeProvider = new SearchTimeProvider(randomLong(), 0, () -> currentRelativeTime);
        String rangeAggName = randomAlphaOfLengthBetween(5, 8);  
                new SearchRequest(),
        Boolean expectedTerminatedEarly = null;  
        SearchResponse searchResponse = merger.getMergedResponse(  
import java.util.Collections;
                expectedTotalHits = new TotalHits(Math.min(previousValue + totalHits.value(), trackTotalHitsUpTo), totalHitsRelation);
        assertEquals(0, response.getSuccessfulShards());
                new SearchRequestOperationsListener.CompositeListener(List.of(), LogManager.getLogger()),
            assertEquals(hits.length, searchHits.getCollapseValues().length);  
        {  
            totalCount += count;  
            )
            InternalSearchResponse internalSearchResponse = new InternalSearchResponse(searchHits, null, suggest, null, false, null, 1);  
                randomLong(),
                0,
                SearchResponse.Clusters.EMPTY
                // is registered twice with different aliases and searched multiple times as part of the same search request.
            InternalSearchResponse internalSearchResponse = new InternalSearchResponse(searchHits, aggs, null, null, false, null, 1);
        for (int i = 0; i < numResponses; i++) {
                0,
                randomNonNegativeLong(),
        }
                        if (scoreCompare != 0) {
            hit.shard(new SearchShardTarget("node", shardId, clusterAlias, OriginalIndices.NONE));
        }
            for (int j = 0; j < numFailures; j++) {  
        assertTrue(executorService.awaitTermination(5, TimeUnit.SECONDS));  
            assertArrayEquals(sortFields, searchHits.getSortFields());
                SearchResponse.Clusters.EMPTY  
            SearchHits searchHits = new SearchHits(new SearchHit[0], null, Float.NaN);  
import static org.hamcrest.Matchers.greaterThan;
            0,  
                new SearchRequestOperationsListener.CompositeListener(List.of(), LogManager.getLogger()),
import org.opensearch.search.internal.SearchContext;  
        }
            emptyReduceContextBuilder()
                indices[j] = new Index(indexName, indexUuid);
                shardSearchFailures[j] = failure;  
            clusters,  
                1,  
        long currentRelativeTime = randomNonNegativeLong();
                1,
                SearchResponse.Clusters.EMPTY
            SearchProfileShardResults profile = SearchProfileShardResultsTests.createTestItem();  
                    return compareTo;  
                new SearchShardTarget(  
        SearchHits searchHits = searchResponse.getHits();
            assertSame(expected, shardFailure);
            0,
        for (int i = 0; i < numResponses; i++) {
import java.util.HashMap;  
                SearchResponseTests.randomClusters()
            searchTimeProvider,
            InternalDateRange range = factory.create(rangeAggName, singletonList(bucket), DocValueFormat.RAW, false, emptyMap());
            new SearchRequestContext(
    }  
import org.opensearch.search.aggregations.bucket.range.InternalDateRange;
 * Unless required by applicable law or agreed to in writing,
            CompletionSuggestion completionSuggestion = new CompletionSuggestion(suggestionName, size, false);
 * this file be licensed under the Apache-2.0 license or a
            int currentShardId = shard.getShardId().id();
            clusters,  
        );
            assertNull(searchHits.getTotalHits());
import org.opensearch.search.profile.SearchProfileShardResultsTests;  
        for (int i = 0; i < from; i++) {
        SearchResponse.Clusters clusters = SearchResponseTests.randomClusters();
                if (scoreCompare != 0) {
            Map.Entry<String, Index[]> entry = indicesIterator.next();  
            }
        Max max = mergedResponse.getAggregations().get(maxAggName);  
import org.opensearch.transport.RemoteClusterService;
                    } else {
            int numFailures = randomIntBetween(1, 10);
        assertEquals(1, range.getBuckets().size());  
            option.setHit(searchHit);
            0,  
            int numFields = randomIntBetween(1, 3);
                new SearchRequest(),
            hit.shard(shardTarget);
        }
        for (int j = 0; j < sortFieldFactors.length; j++) {  
            );
            SearchResponse searchResponse = new SearchResponse(
        private final SortField[] sortFields;
            addResponse(merger, searchResponse);  
    public void testMergeCompletionSuggestionsTieBreak() throws InterruptedException {  
                priorityQueue.add(Tuple.tuple(searchShardTarget, failure));  
                ShardSearchFailure shardSearchFailure = new ShardSearchFailure(new OpenSearchException(new IllegalArgumentException()));
            CompletionSuggestion.Entry.Option option = new CompletionSuggestion.Entry.Option(
        int trackTotalHitsUpTo = randomTrackTotalHits.v1();  
            size,  
import java.util.concurrent.Executors;
        assertEquals(0, mergedResponse.getFailedShards());
                100L,  
                1L,  
            SearchHit expected = priorityQueue.poll();  
import java.util.Iterator;
            )
                new SearchRequestOperationsListener.CompositeListener(List.of(), LogManager.getLogger()),
        assertEquals(0, response.getHits().getHits().length);
        assertEquals(0, mergedResponse.getFailedShards());
    public void testMergeShardFailuresNullShardTarget() throws InterruptedException {
        numResponses = randomIntBetween(1, 10);
            expectedTimedOut = expectedTimedOut || timedOut;  
                SearchResponse.Clusters.EMPTY
            int count = randomIntBetween(1, 1000);
            addResponse(merger, searchResponse);  
        assertEquals(0, mergedResponse.getFailedShards());
                for (int i = 0; i < sortFields.length; i++) {  
        SearchResponseMerger merger = new SearchResponseMerger(0, 10, Integer.MAX_VALUE, timeProvider, emptyReduceContextBuilder());
                expectedFailures.add(shardSearchFailure);
            expectedSkipped += skipped;
            SearchResponse searchResponse = new SearchResponse(
                0,  
        SearchHit[] hits = randomSearchHitArray(
    private static Map<String, Index[]> randomRealisticIndices(int numIndices, int numClusters) {  
            Suggest suggest = new Suggest(suggestions);
            default:  
            expectedProfile.putAll(profile.getShardResults());
        for (ShardSearchFailure shardFailure : shardFailures) {
        }
        SearchResponseMerger merger = new SearchResponseMerger(  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        final SearchTimeProvider timeProvider = new SearchTimeProvider(randomLong(), 0, () -> currentRelativeTime);  
                String index = "index-" + i;
        List<ShardSearchFailure> expectedFailures = new ArrayList<>();  
        assertEquals(expectedSkipped, searchResponse.getSkippedShards());
        for (int i = 0; i < numResponses; i++) {
        Iterator<Map.Entry<String, Index[]>> indicesIterator = randomRealisticIndices(numIndices, numResponses).entrySet().iterator();  
            merger.add(searchResponse);
                ShardId shardId = new ShardId(index, index + "-uuid", j);
        assertEquals(0, mergedResponse.getSkippedShards());  
            } else {
                    }
            )
        assertEquals(0, response.getFailedShards());  
        assertEquals(numResponses, searchResponseMerger.numResponses());  
                    collapseValues[j] = j + 1000 * i;
                    OriginalIndices.NONE
            int skipped = randomIntBetween(1, total);
                new SearchRequest(),  
                new Text("suggestion"),  
            0,
        CompletionSuggestion suggestion = mergedResponse.getSuggest().getSuggestion(suggestionName);
            searchHit.shard(
import java.util.List;
            0,
 * GitHub history for details.
            new SearchTimeProvider(0, 0, () -> 0),
        if (collapseField != null  
            String clusterAlias;  
        assertEquals(0, merger.numResponses());
        assertEquals(0, response.getTotalShards());  
                            compare = Integer.compare(bSortValue, aSortValue);  
        assertEquals(0, response.getSkippedShards());
            Suggest suggest = new Suggest(suggestions);
            Float.NaN,
                        Integer aSortValue = (Integer) a.getRawSortValues()[i];
    }
            boolean timedOut = rarely();
                InternalAggregations.EMPTY,  
                OpenSearchException openSearchException = new OpenSearchException(new IllegalArgumentException());  
                0,  
                scoreFactor,
        SearchResponse mergedResponse = merger.getMergedResponse(  
        for (int i = 0; i < numResponses; i++) {
            expectedTerminatedEarly = expectedTerminatedEarly == null ? terminatedEarly : expectedTerminatedEarly;
                new SearchRequest(),
            SearchHits searchHits = new SearchHits(new SearchHit[0], null, Float.NaN);
        SearchResponseMerger merger = new SearchResponseMerger(
            merger.add(searchResponse);
 *    http://www.apache.org/licenses/LICENSE-2.0
                clusterAlias = RemoteClusterAware.LOCAL_CLUSTER_GROUP_KEY;
                new SearchRequestOperationsListener.CompositeListener(List.of(), LogManager.getLogger()),
        SearchResponse.Clusters clusters = SearchResponseTests.randomClusters();
import org.opensearch.search.DocValueFormat;
                        } else {
 * specific language governing permissions and limitations
            }
                randomAlphaOfLength(10),
            );
    @Before
        PriorityQueue<SearchHit> priorityQueue = new PriorityQueue<>(new SearchHitComparator(sortFields));  
        if (randomBoolean()) {  
        // the sort fields and the collapse field are not returned when hits are empty
            new SearchRequestContext(
import static org.hamcrest.Matchers.greaterThanOrEqualTo;  
            Map.Entry<String, Index[]> entry = indicesPerCluster.next();
        SearchResponseMerger searchResponseMerger = new SearchResponseMerger(  
                    // set different collapse values for each cluster for simplicity
                lastShardId = currentShardId;  
    }
                ShardSearchFailure.EMPTY_ARRAY,
                docId,
        assertEquals(TimeUnit.NANOSECONDS.toMillis(currentRelativeTime), searchResponse.getTook().millis());
            );
            collapseField = null;
        assertEquals(numResponses, searchResponseMerger.numResponses());
            int scoreFactor = randomIntBetween(1, numResponses);  
            1,
            CompletionSuggestion.Entry options = new CompletionSuggestion.Entry(new Text("suggest"), 0, 10);
        );
        assertEquals(0, mergedResponse.getSkippedShards());
 */
        );  
            for (int i = 0; i < numFields; i++) {
                1,
        assertEquals(0, mergedResponse.getHits().getHits().length);
                () -> null
                new SearchRequest(),  
                String indexName = indicesNames[j];  
        double maxValue = Double.MIN_VALUE;
            )
        Map<String, Index[]> indicesPerCluster = new TreeMap<>();
            ShardSearchFailure[] shardSearchFailures = new ShardSearchFailure[numFailures];  
import org.opensearch.transport.RemoteClusterAware;
            );
    public void init() {  
                for (int k = 0; k < sortFields.length; k++) {  
        final SearchTimeProvider timeProvider = new SearchTimeProvider(randomLong(), 0, () -> currentRelativeTime);
        }
public class SearchResponseMergerTests extends OpenSearchTestCase {  
            new SearchRequestContext(
                () -> null  
import org.opensearch.action.OriginalIndices;
            SearchHits searchHits = new SearchHits(  
                openSearchException.setShard(shardId);
                if (randomBoolean()) {  
            new SearchRequestContext(
                1L,
        SearchHitComparator(SortField[] sortFields) {  
        String[] indicesNames = new String[numIndices];
            Index[] indices = entry.getValue();
        assertEquals(0, mergedResponse.getFailedShards());
            )
            } else {  
        assertEquals("0.0", bucket.getFromAsString());
        for (int i = 0; i < numClusters; i++) {  
            sortFields = new SortField[numFields];  
import java.util.Comparator;
        String maxAggName = randomAlphaOfLengthBetween(5, 8);
            }
        Suggest.Suggestion<? extends Suggest.Suggestion.Entry<? extends Suggest.Suggestion.Entry.Option>> suggestion = mergedResponse  
                ShardSearchFailure.EMPTY_ARRAY,  
            0,
            SearchResponse searchResponse = new SearchResponse(
                ShardSearchFailure.EMPTY_ARRAY,  
        int numResponses,
        SearchResponse mergedResponse = merger.getMergedResponse(
        assertEquals(2, merger.numResponses());  
            String clusterAlias = entry.getKey();  
            this.sortFields = sortFields;
                new SearchRequest(),  
            emptyReduceContextBuilder()  
        assertEquals(0, searchResponse.getShardFailures().length);
            case 1:
            .getSuggestion(suggestionName);
                1,  
                1,
        assertEquals(priorityQueue.size(), mergedResponse.getFailedShards());
            hasHits |= hits.length > 0;  
        assertEquals(maxValue, max.getValue(), 0d);
        int lastShardId = 0;
import org.opensearch.action.search.TransportSearchAction.SearchTimeProvider;  
                throw new UnsupportedOperationException();
import org.opensearch.search.profile.ProfileShardResult;
        );  
        PriorityQueue<Tuple<ShardId, ShardSearchFailure>> priorityQueue = new PriorityQueue<>(Comparator.comparing(Tuple::v1));
            assertNull(searchHits.getCollapseValues());
        assertNull(response.isTerminatedEarly());
                100L,
                new SearchRequest(),  
        awaitResponsesAdded();  
import org.apache.lucene.search.SortField;
                () -> null
                shardSearchFailures,
        assertEquals(10, mergedResponse.getHits().getTotalHits().value());  
        boolean hasHits = false;
 * Licensed to Elasticsearch under one or more contributor  
        }  
            if (sortFields != null) {  
            clusters,  
        SearchResponseMerger merger = new SearchResponseMerger(
            int total = randomIntBetween(1, 1000);  
                SearchResponse.Clusters.EMPTY  
                hit.score(score);
                SearchShardTarget searchShardTarget = new SearchShardTarget(randomAlphaOfLength(6), shardId, clusterAlias, null);  
                SearchResponse.Clusters.EMPTY
                }
                SearchResponse.Clusters.EMPTY
        SearchResponse mergedResponse = merger.getMergedResponse(
        TotalHits expectedTotalHits = null;  
                numReducePhases
import org.opensearch.core.index.shard.ShardId;
            timeProvider,
        }
            }
    }
            List<Suggest.Suggestion<? extends Suggest.Suggestion.Entry<? extends Suggest.Suggestion.Entry.Option>>> suggestions =
        SearchResponseMerger merger = new SearchResponseMerger(  
                SearchResponseTests.randomClusters()
        assertEquals(numResponses, merger.numResponses());  
            searchTimeProvider,
                )
        SearchResponse response = merger.getMergedResponse(
    }  
                        if (compare != 0) {
        assertSame(clusters, mergedResponse.getClusters());
                1,
        }  
            timeProvider,
        );  
            );
                    sortField = new SortField("field-" + i, SortField.Type.INT, randomBoolean());
                new SearchRequest(),
                    } else {
                0,
        SearchResponse.Clusters clusters = SearchResponseTests.randomClusters();  
        assertSame(clusters, searchResponse.getClusters());
 *
                1,  
                SearchResponse.Clusters.EMPTY
        assertEquals(0, mergedResponse.getSkippedShards());  
        SearchResponseMerger merger = new SearchResponseMerger(0, 10, trackTotalHitsUpTo, timeProvider, emptyReduceContextBuilder());
            }
        }  
        } else {
            clusters,  
                ShardSearchFailure.EMPTY_ARRAY,  
            0,  
                () -> null
                new SearchRequestOperationsListener.CompositeListener(List.of(), LogManager.getLogger()),
        assertEquals(0, mergedResponse.getShardFailures().length);  
        for (int i = 0; i < numResponses; i++) {  
        ShardSearchFailure[] shardFailures = mergedResponse.getShardFailures();
            SearchResponse.Clusters.EMPTY,  
        assertEquals(totalCount, bucket.getDocCount());
            );  
            SearchContext.TRACK_TOTAL_HITS_ACCURATE,
                    new ShardId("index", "uuid", randomIntBetween(0, Integer.MAX_VALUE)),
        SearchResponseMerger merger = new SearchResponseMerger(
                maxScore,
import java.util.TreeMap;
                            return compare;
                priorityQueue
            SearchHits empty = new SearchHits(new SearchHit[0], new TotalHits(0, TotalHits.Relation.EQUAL_TO), Float.NaN, null, null, null);
    private int numResponses;
                Collections.emptyMap()
        final int requestedSize = from + size;  
        if (hasHits) {  
        assertEquals(Math.min(numResponses, size), options.getOptions().size());
            emptyReduceContextBuilder()  
        SearchResponse mergedResponse = searchResponseMerger.getMergedResponse(
}
                priorityQueue.add(Tuple.tuple(shardId, failure));
                // Realistically clusters have the same indices with same names, but different uuid. Yet it can happen that the same cluster
                }  
    }
        assertArrayEquals(sortFields, mergedResponse.getHits().getSortFields());
        final long currentRelativeTime = randomNonNegativeLong();
        assertEquals(0, response.getProfileResults().size());
                collapseValues  
            SearchHits searchHits = new SearchHits(new SearchHit[0], new TotalHits(0, TotalHits.Relation.EQUAL_TO), Float.NaN);
            assertEquals(expectedMaxScore, searchHits.getMaxScore(), 0f);
            assertEquals(expectedTotalHits.value(), searchHits.getTotalHits().value());
            SearchHit hit = new SearchHit(docId);
            option.setHit(hit);  
    public void testMergeShardFailures() throws InterruptedException {
                Collections.emptyMap()
            );
        Tuple<Integer, TotalHits.Relation> randomTrackTotalHits = randomTrackTotalHits();
                0,
            hits[j] = hit;  
            SearchHits empty = new SearchHits(new SearchHit[0], totalHits, Float.NaN, null, null, null);  
            SearchHit hit = new SearchHit(randomIntBetween(0, Integer.MAX_VALUE));  
        awaitResponsesAdded();
                0,
            SearchShardTarget shardTarget = new SearchShardTarget(  
                InternalSearchResponse.empty(),
                totalHits = new TotalHits(randomLongBetween(0, 1000), totalHitsRelation);
            List<Suggest.Suggestion<? extends Suggest.Suggestion.Entry<? extends Suggest.Suggestion.Entry.Option>>> suggestions =
        SearchResponse.Clusters clusters = SearchResponseTests.randomClusters();
        }
    private ExecutorService executorService;  
import org.opensearch.search.SearchHit;  
                hit.sortValues(rawSortValues, docValueFormats);
        ShardSearchFailure[] shardFailures = merger.getMergedResponse(
            SearchContext.TRACK_TOTAL_HITS_ACCURATE,
        }
                DocValueFormat.RAW
            }  
                internalSearchResponse,
        SearchResponseMerger merger = new SearchResponseMerger(0, 10, Integer.MAX_VALUE, timeProvider, emptyReduceContextBuilder());  
            SearchHit[] hits = randomSearchHitArray(
        assertEquals(0, response.getHits().getTotalHits().value());
            }
                score = (maxScore - j) * scoreFactor;
                "bucket",
    }
        for (int i = 0; i < numResponses; i++) {
import org.apache.lucene.search.TotalHits;  
                DocValueFormat[] docValueFormats = new DocValueFormat[sortFields.length];
 * ownership. Elasticsearch licenses this file to you under  
        );
                1,
                    if (sortField == SortField.FIELD_SCORE) {
            SearchContext.TRACK_TOTAL_HITS_ACCURATE,  
            new Index[] { new Index("index", "uuid") },  
            0,
    }
        SearchResponse mergedResponse = merger.getMergedResponse(
/*
                sortFields[i] = sortField;  
            clusters,
            emptyReduceContextBuilder()  
                        if (sortField.getReverse()) {
        assertEquals(numResponses, mergedResponse.getSuccessfulShards());  
import org.apache.logging.log4j.LogManager;
                new SearchRequestOperationsListener.CompositeListener(List.of(), LogManager.getLogger()),
            );
                indices,  
import org.opensearch.search.profile.SearchProfileShardResults;
            InternalMax max = new InternalMax(maxAggName, value, DocValueFormat.RAW, Collections.emptyMap());  
        String lastClusterAlias = null;  
            expectedSuccessful += successful;  
            if (sortFields == null) {  
                false,
                SearchResponse.Clusters.EMPTY
                null,
        assertEquals(numResponses, searchResponseMerger.numResponses());
import org.opensearch.search.internal.InternalSearchResponse;
import org.opensearch.core.common.text.Text;
        int size = randomIntBetween(1, 100);
        assertSame(clusters, mergedResponse.getClusters());  
import org.opensearch.common.collect.Tuple;
            if (trackTotalHitsUpTo != SearchContext.TRACK_TOTAL_HITS_DISABLED) {
            priorityQueue.poll();  
            randomIntBetween(0, 10000),
        assertEquals(numResponses, mergedResponse.getTotalShards());
                    randomBoolean() ? RemoteClusterService.LOCAL_CLUSTER_GROUP_KEY : randomAlphaOfLengthBetween(5, 10),  
            if (currentShardId == lastShardId) {  
            }
            )  
                for (int j = 0; j < numDocs; j++) {  
            );  
                shardSearchFailures,  
            10,  
                1L,  
            })  
            && hasHits) {
 * the Apache License, Version 2.0 (the "License"); you may
        int expectedTotal = 0;
            for (int j = 0; j < numFailures; j++) {
                new SearchRequestOperationsListener.CompositeListener(List.of(), LogManager.getLogger()),  
        long currentRelativeTime = randomNonNegativeLong();  
                        final int compare;
                        Integer bSortValue = (Integer) b.getRawSortValues()[i];  
                }  
                }
                return o1.getClusterAlias().compareTo(o2.getClusterAlias());
        int expectedReducePhases = 1;
                10000,
                new ArrayList<>();  
            int numFailures = randomIntBetween(1, 10);
        boolean expectedTimedOut = false;
            lastClusterAlias = shard.getClusterAlias();
            new SearchRequestContext(
        } else {  
            )
        assertEquals(numResponses, searchResponseMerger.numResponses());  
        SearchTimeProvider timeProvider = new SearchTimeProvider(randomLong(), 0, () -> currentRelativeTime);
 * Modifications Copyright OpenSearch Contributors. See
        assertEquals(10, mergedResponse.getHits().getHits().length);
    private void awaitResponsesAdded() throws InterruptedException {
        final SearchTimeProvider timeProvider = new SearchTimeProvider(randomLong(), 0, () -> currentRelativeTime);  
                100L,  
            InternalSearchResponse internalSearchResponse = new InternalSearchResponse(searchHits, null, null, profile, false, null, 1);  
                1,
                () -> null  
            SearchResponse.Clusters.EMPTY,
    private static SearchHit[] randomSearchHitArray(
            Index[] indices = entry.getValue();
