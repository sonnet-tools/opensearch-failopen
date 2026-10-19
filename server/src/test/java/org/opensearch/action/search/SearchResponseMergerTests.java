        assertEquals(2, merger.numResponses());
            InternalAggregations aggs = InternalAggregations.from(Arrays.asList(range, max));
                1,
                1,
                sortFields,
                long previousValue = expectedTotalHits == null ? 0 : expectedTotalHits.value();
            timeProvider,
            clusters,
        assertEquals(numResponses, mergedResponse.getTotalShards());
                clusterAlias,
            return Integer.compare(a.docId(), b.docId());
        int totalCount = 0;
                        rawSortValues[k] = sortField.getReverse() ? numDocs * sortFieldFactors[k] - j : j;
                ShardSearchFailure.EMPTY_ARRAY,
                0,
            int numFailures = randomIntBetween(1, 10);
                }
            assertEquals(hits.length, searchHits.getCollapseValues().length);
        ).getShardFailures();
        final int requestedSize = from + size;
        assertSame(clusters, mergedResponse.getClusters());
        assertEquals(0, mergedResponse.getSkippedShards());
            hit.shard(shardTarget);
        assertEquals(1, range.getBuckets().size());
        );
 * The OpenSearch Contributors require contributions made to
            CompletionSuggestion.Entry options = new CompletionSuggestion.Entry(new Text("suggest"), 0, 10);
            InternalSearchResponse response = new InternalSearchResponse(empty, null, null, null, false, false, 1);
        float expectedMaxScore = Float.NEGATIVE_INFINITY;
    public void testMergeShardFailuresNullShardTarget() throws InterruptedException {
        PriorityQueue<SearchHit> priorityQueue = new PriorityQueue<>(new SearchHitComparator(sortFields));
        boolean hasHits = false;
            SearchResponse.Clusters.EMPTY,
import org.opensearch.search.suggest.Suggest;
            new SearchRequestContext(
            indicesNames[i] = randomAlphaOfLengthBetween(5, 10);
                new SearchRequestOperationsListener.CompositeListener(List.of(), LogManager.getLogger()),
            assertEquals(expectedMaxScore, searchHits.getMaxScore(), 0f);
    }
            }
            assertArrayEquals(sortFields, searchHits.getSortFields());
                        hit.score(score);
import org.apache.lucene.search.SortField;
                new SearchRequest(),
    }
        assertEquals(0, response.getHits().getHits().length);
            new SearchTimeProvider(0, 0, () -> 0),
            SearchShardTarget shardTarget = new SearchShardTarget(
                    // set different collapse values for each cluster for simplicity
        for (int j = 0; j < sortFieldFactors.length; j++) {
                ShardSearchFailure shardSearchFailure = new ShardSearchFailure(new OpenSearchException(new IllegalArgumentException()));
            SearchResponse searchResponse = new SearchResponse(
            );
                long previousValue = expectedTotalHits == null ? 0 : expectedTotalHits.value();
                return Tuple.tuple(randomIntBetween(10, 1000), TotalHits.Relation.GREATER_THAN_OR_EQUAL_TO);
            );
                String index = "index-" + i;
        assertEquals(numResponses, merger.numResponses());
        long currentRelativeTime = randomLong();
        for (int i = 0; i < numResponses; i++) {
                indices,
        Iterator<Map.Entry<String, Index[]>> indicesPerCluster = randomRealisticIndices(numIndices, numResponses).entrySet().iterator();
        PriorityQueue<SearchHit> priorityQueue
                randomAlphaOfLengthBetween(5, 10),
                            return scoreCompare;
            new SearchRequestContext(
        final String collapseField;
            float maxScore = scoreSort ? numDocs * scoreFactor : Float.NaN;
        );
            SearchHit[] hits = randomSearchHitArray(
import java.util.Iterator;
    @Before
        if (expectedTotalHits == null) {
        SearchResponse response = merger.getMergedResponse(
import org.opensearch.search.profile.ProfileShardResult;
            int docId = randomIntBetween(0, Integer.MAX_VALUE);
    }
            new SearchRequestContext(
            emptyReduceContextBuilder()
        int numIndices = numResponses * randomIntBetween(1, 3);
            0,
        int expectedSuccessful = 0;
            sortFields = new SortField[numFields];
            }
                    new ShardId("index", "uuid", randomIntBetween(0, Integer.MAX_VALUE)),
            for (int j = 0; j < numFailures; j++) {
        SearchResponseMerger searchResponseMerger = new SearchResponseMerger(
        if (randomBoolean()) {
        for (int i = 0; i < numResponses; i++) {
                shardSearchFailures[j] = failure;
                i,
 *
            SearchResponse searchResponse = new SearchResponse(
                skipped,
        switch (randomIntBetween(0, 2)) {
                DocValueFormat.RAW
                priorityQueue.add(Tuple.tuple(searchShardTarget, failure));
                SearchResponse.Clusters.EMPTY
            SearchResponse searchResponse = new SearchResponse(
public class SearchResponseMergerTests extends OpenSearchTestCase {
        assertEquals(0, response.getNumReducePhases());
            SearchContext.TRACK_TOTAL_HITS_ACCURATE,
            SearchResponse searchResponse = new SearchResponse(
    private static Tuple<Integer, TotalHits.Relation> randomTrackTotalHits() {
            }
 * under the License.
    }
        long currentRelativeTime = randomNonNegativeLong();
        CompletionSuggestion suggestion = mergedResponse.getSuggest().getSuggestion(suggestionName);
                () -> null
            CompletionSuggestion.Entry.Option option = new CompletionSuggestion.Entry.Option(
        SearchHitComparator(SortField[] sortFields) {
        assertEquals(10, mergedResponse.getHits().getHits().length);
        );
import org.opensearch.search.profile.SearchProfileShardResultsTests;
            assertEquals(collapseField, searchHits.getCollapseField());
        SearchResponse mergedResponse = merger.getMergedResponse(
            case 0:
            priorityQueue
                Object[] rawSortValues = new Object[sortFields.length];
            priorityQueue.poll();
                    return scoreCompare;
        }
import org.opensearch.core.common.text.Text;
import org.apache.logging.log4j.LogManager;
        );
        // the sort fields and the collapse field are not returned when hits are empty
                () -> null
 *    http://www.apache.org/licenses/LICENSE-2.0
            double value = randomDouble();
        }
        return hits;
            addResponse(merger, searchResponse);
        boolean expectedTimedOut = false;
        } else {
            hits[j] = hit;
        assertEquals(numResponses, searchResponseMerger.numResponses());
 * license agreements. See the NOTICE file distributed with
                ShardSearchFailure.EMPTY_ARRAY,
        assertEquals(expectedSuccessful, searchResponse.getSuccessfulShards());
        Suggest.Suggestion<? extends Suggest.Suggestion.Entry<? extends Suggest.Suggestion.Entry.Option>> suggestion = mergedResponse
        private final SortField[] sortFields;
        );
                expectedTotalHits = new TotalHits(Math.min(previousValue + totalHits.value(), trackTotalHitsUpTo), totalHitsRelation);
            emptyReduceContextBuilder()
        assertEquals(expectedProfile, mergedResponse.getProfileResults());
        assertEquals(numResponses, mergedResponse.getSuccessfulShards());
                new SearchRequest(),
        assertNull(response.getSuggest());
        assertEquals(numResponses, merger.numResponses());
                SearchResponse.Clusters.EMPTY
            })
                new SearchRequest(),
                InternalSearchResponse.empty(),
                null,
            assertEquals("suggestion", option.getText().string());
import org.opensearch.action.OriginalIndices;
            SearchHit hit = new SearchHit(docId);
            completionSuggestion.addTerm(options);
                InternalSearchResponse.empty(),
                0,
                Collections.emptyMap()
        );
        Max max = mergedResponse.getAggregations().get(maxAggName);
                0,
            expectedTerminatedEarly = expectedTerminatedEarly == null ? terminatedEarly : expectedTerminatedEarly;
                1,
            InternalSearchResponse internalSearchResponse = new InternalSearchResponse(searchHits, null, null, profile, false, null, 1);
        SearchResponse.Clusters clusters = SearchResponseTests.randomClusters();
 * specific language governing permissions and limitations
        assertEquals(priorityQueue.size(), shardFailures.length);
            lastClusterAlias = shard.getClusterAlias();
                totalHits,
            )
                100L,
                for (int k = 0; k < sortFields.length; k++) {
        SearchResponse searchResponse = searchResponseMerger.getMergedResponse(
        for (int i = 0; i < numResponses; i++) {
            0,
                shardId,
                1,
                totalHits = new TotalHits(randomLongBetween(0, 1000), totalHitsRelation);
        }
                clusterAlias = randomAlphaOfLengthBetween(5, 10);
    }
            InternalDateRange.Factory factory = new InternalDateRange.Factory();
        );
                return o1.getClusterAlias().compareTo(o2.getClusterAlias());
        assertEquals(expectedReducePhases, searchResponse.getNumReducePhases());
        float maxScore,
            InternalSearchResponse internalSearchResponse = new InternalSearchResponse(searchHits, aggs, null, null, false, null, 1);
        }
                clusterAlias,
                ShardSearchFailure failure = new ShardSearchFailure(openSearchException);
        int numDocs,
        for (Suggest.Suggestion.Entry.Option option : options) {
                () -> null
import org.opensearch.core.index.shard.ShardId;
                internalSearchResponse,
            from,
                1,
        );
                score = (maxScore - j) * scoreFactor;
        final SearchTimeProvider timeProvider = new SearchTimeProvider(randomLong(), 0, () -> currentRelativeTime);
            assertSame(expected, hit);
import org.opensearch.search.aggregations.InternalAggregations;
            )
            clusters,
            0,
        SearchResponse.Clusters clusters = SearchResponseTests.randomClusters();
            } else {
                priorityQueue.add(Tuple.tuple(shardId, failure));
import org.opensearch.search.aggregations.bucket.range.InternalDateRange;
            collapseField = null;
            )
            expectedProfile.putAll(profile.getShardResults());
            );
        SearchResponseMerger merger = new SearchResponseMerger(
                }
        assertEquals(numResponses, searchResponseMerger.numResponses());
            0,
        assertEquals(0, mergedResponse.getShardFailures().length);
            if (trackTotalHitsUpTo != SearchContext.TRACK_TOTAL_HITS_DISABLED) {
        }
import org.apache.lucene.search.TotalHits;
        int trackTotalHitsUpTo = randomTrackTotalHits.v1();
        } else {
            } else {
        assertSame(clusters, searchResponse.getClusters());
        TotalHits expectedTotalHits = null;
        assertEquals(0, mergedResponse.getSkippedShards());
        SearchResponseMerger searchResponseMerger = new SearchResponseMerger(
                ShardId shardId = new ShardId(randomFrom(indices), j);
            )
                numResponses,
                shardSearchFailures[j] = shardSearchFailure;
            )
        int expectedReducePhases = 1;
                clusterAlias = RemoteClusterAware.LOCAL_CLUSTER_GROUP_KEY;
        assertEquals(numResponses, mergedResponse.getSuccessfulShards());
            int shardIdCompareTo = aShard.getShardId().compareTo(bShard.getShardId());
            );
    }
        int expectedTotal = 0;
            assertEquals(expectedTotalHits.value(), searchHits.getTotalHits().value());
                0,
            trackTotalHitsUpTo,
        awaitResponsesAdded();
            Float.NaN,
            option.setHit(searchHit);
            expectedReducePhases += numReducePhases;
                SearchResponse.Clusters.EMPTY
        }
            InternalSearchResponse response = new InternalSearchResponse(empty, null, null, null, false, false, 1);
            )
            0,
        awaitResponsesAdded();
            clusters,
            );
    public void testMergeAggs() throws InterruptedException {
        assertEquals(0, response.getShardFailures().length);
            )
                1,
            SearchHit searchHit = new SearchHit(docId);
        numResponses = randomIntBetween(1, 10);
        SearchHit[] hits = searchHits.getHits();
                        if (sortField.getReverse()) {
                1,
/*
        String rangeAggName = randomAlphaOfLengthBetween(5, 8);
            clusters,
            for (int j = 0; j < numFailures; j++) {
                lastShardId = currentShardId;
            Object[] collapseValues = null;
                randomIntBetween(0, Integer.MAX_VALUE)
/*
        assertEquals(0, mergedResponse.getSkippedShards());
        executorService.shutdown();
        final SearchTimeProvider timeProvider = new SearchTimeProvider(randomLong(), 0, () -> currentRelativeTime);
            SearchHit hit = new SearchHit(randomIntBetween(0, Integer.MAX_VALUE));
            executorService.submit(() -> searchResponseMerger.add(searchResponse));
        );
            totalCount += count;
    public void testMergeProfileResults() throws InterruptedException {
        );
                }
            Boolean terminatedEarly = frequently() ? null : true;
        assertEquals(numResponses, mergedResponse.getTotalShards());
                new SearchRequestOperationsListener.CompositeListener(List.of(), LogManager.getLogger()),
            SearchContext.TRACK_TOTAL_HITS_ACCURATE,
            );
import java.util.Collections;
                new SearchRequest(),
    private void addResponse(SearchResponseMerger searchResponseMerger, SearchResponse searchResponse) {
                    randomBoolean() ? RemoteClusterService.LOCAL_CLUSTER_GROUP_KEY : randomAlphaOfLengthBetween(5, 10),
                new Text("suggestion"),
            Index[] indices = entry.getValue();
            List<Suggest.Suggestion<? extends Suggest.Suggestion.Entry<? extends Suggest.Suggestion.Entry.Option>>> suggestions =
                SearchResponse.Clusters.EMPTY
                total,
        SearchResponseMerger searchResponseMerger = new SearchResponseMerger(
                randomAlphaOfLength(10),
        SearchResponse mergedResponse = searchResponseMerger.getMergedResponse(
        String maxAggName = randomAlphaOfLengthBetween(5, 8);
        assertEquals(TotalHits.Relation.EQUAL_TO, response.getHits().getTotalHits().relation());
    public void testMergeShardFailuresNullShardId() throws InterruptedException {
            option.setHit(hit);
        assertEquals(0, response.getFailedShards());
            CompletionSuggestion completionSuggestion = new CompletionSuggestion(suggestionName, size, false);
            if (sortFields != null) {
        assertEquals(0, response.getProfileResults().size());
                collapseValues = new Object[numDocs];
                        if (scoreCompare != 0) {
        double maxValue = Double.MIN_VALUE;
                int compareTo = o1.getShardId().compareTo(o2.getShardId());
            0,
        long currentRelativeTime = randomLong();
                new SearchRequestOperationsListener.CompositeListener(List.of(), LogManager.getLogger()),
        TotalHits expectedTotalHits = null;
        assertNull(searchResponse.getScrollId());
            options.addOption(option);
                1,
        Range.Bucket bucket = range.getBuckets().get(0);
        SearchTimeProvider searchTimeProvider = new SearchTimeProvider(0, 0, () -> 0);
import org.opensearch.core.index.Index;
        SearchTimeProvider searchTimeProvider = new SearchTimeProvider(0, 0, () -> 0);
                new SearchShardTarget(
        }
                        rawSortValues[k] = score;
        SortField[] sortFields = new SortField[numFields];
                internalSearchResponse,
        awaitResponsesAdded();
        assertEquals(0, response.getSuccessfulShards());
                }
 * GitHub history for details.
        for (int i = 0; i < numResponses; i++) {
        SearchResponse mergedResponse = searchResponseMerger.getMergedResponse(
        awaitResponsesAdded();
            }
            SearchHits empty = new SearchHits(new SearchHit[0], totalHits, Float.NaN, null, null, null);
                new SearchRequestOperationsListener.CompositeListener(List.of(), LogManager.getLogger()),
            collapseField = randomBoolean() ? "collapse" : null;
            String clusterAlias;
                SearchShardTarget searchShardTarget = new SearchShardTarget(randomAlphaOfLength(6), shardId, clusterAlias, null);
        long currentRelativeTime = randomNonNegativeLong();
            priorityQueue.add(hit);
        }
        assertEquals(0, mergedResponse.getSkippedShards());
                        final int compare;
                    scoreSort = true;
    }
                internalSearchResponse,
        assertEquals(numResponses, mergedResponse.getTotalShards());
        if (expectedMaxScore == Float.NEGATIVE_INFINITY) {
        assertThat(Arrays.asList(shardFailures), containsInAnyOrder(expectedFailures.toArray(ShardSearchFailure.EMPTY_ARRAY)));
        }
            InternalSearchResponse internalSearchResponse = new InternalSearchResponse(searchHits, null, suggest, null, false, null, 1);
            size,
            SearchResponse searchResponse = new SearchResponse(
            int numReducePhases = randomIntBetween(1, 5);
                SearchResponse.Clusters.EMPTY
                1,
            )
import java.util.PriorityQueue;
                return shardIdCompareTo;
        ShardSearchFailure[] shardFailures = mergedResponse.getShardFailures();
        assertEquals(0, response.getTotalShards());
                SearchResponse.Clusters.EMPTY
            SearchHits searchHits = new SearchHits(
                InternalAggregations.EMPTY,
            emptyReduceContextBuilder()
                hit.score(score);
 * Unless required by applicable law or agreed to in writing,
        }
            InternalDateRange.Bucket bucket = factory.createBucket(
        public int compare(SearchHit a, SearchHit b) {
            suggestions.add(completionSuggestion);
import org.opensearch.search.aggregations.metrics.InternalMax;
            for (int j = 0; j < indices.length; j++) {
            }
        );
                shardSearchFailures,
            10,
                1,
    }
    public void testMergeEmptySearchHitsWithNonEmpty() {
                assertThat(shard.getClusterAlias(), greaterThan(lastClusterAlias));
        assertArrayEquals(hits, mergedResponse.getHits().getHits());
                DocValueFormat[] docValueFormats = new DocValueFormat[sortFields.length];
        );
import static org.opensearch.test.InternalAggregationTestCase.emptyReduceContextBuilder;
            1,
            }
                    if (sortField == SortField.FIELD_SCORE) {
                null,
                )
                1,
        assertEquals(priorityQueue.size(), shardFailures.length);
            SearchShardTarget bShard = b.getShard();
                terminatedEarly,
                new SearchRequest(),
        SearchResponse searchResponse = merger.getMergedResponse(
    private void awaitResponsesAdded() throws InterruptedException {
        assertEquals(0, mergedResponse.getFailedShards());
        SearchResponse mergedResponse = searchResponseMerger.getMergedResponse(
                    OriginalIndices.NONE
        assertEquals(0, merger.numResponses());
import static java.util.Collections.emptyMap;
                0,
                100L,
                new SearchRequestOperationsListener.CompositeListener(List.of(), LogManager.getLogger()),
                Collections.emptyMap()
            SearchContext.TRACK_TOTAL_HITS_ACCURATE,
                randomNonNegativeLong(),
                            compare = Integer.compare(bSortValue, aSortValue);
            addResponse(merger, searchResponse);
            emptyReduceContextBuilder()
        SearchResponse mergedResponse = merger.getMergedResponse(
            searchTimeProvider,
        PriorityQueue<SearchHit> priorityQueue = new PriorityQueue<>(new SearchHitComparator(sortFields));
            }
            ShardId shardId = new ShardId(randomFrom(indices), randomIntBetween(0, 10));
            }
            indicesPerCluster.put(clusterAlias, indices);
            int scoreFactor = randomIntBetween(1, numResponses);
            0,
            }
            for (int i = 0; i < numFields; i++) {
            )
        SearchResponse.Clusters clusters = SearchResponseTests.randomClusters();
            this.sortFields = sortFields;
        assertEquals(0, mergedResponse.getFailedShards());
            addResponse(searchResponseMerger, searchResponse);
        }
        );
            int numFields = randomIntBetween(1, 3);
            new SearchRequestContext(
import java.util.Comparator;
            );
        assertSame(clusters, mergedResponse.getClusters());
        );
            int total = randomIntBetween(1, 1000);
        ShardSearchFailure[] shardFailures = mergedResponse.getShardFailures();
        assertEquals(0, mergedResponse.getFailedShards());
        assertEquals("0.0", bucket.getFromAsString());
    private ExecutorService executorService;
            int docId = randomIntBetween(0, Integer.MAX_VALUE);
        awaitResponsesAdded();
            expectedTimedOut = expectedTimedOut || timedOut;
            addResponse(merger, searchResponse);
                1,
            }
                null,
            final int numDocs = totalHits == null || totalHits.value() >= requestedSize ? requestedSize : (int) totalHits.value();
            )
            Suggest suggest = new Suggest(suggestions);
        {
import java.util.concurrent.TimeUnit;
import org.opensearch.search.SearchShardTarget;
            ShardSearchFailure expected = priorityQueue.poll().v2();
        SearchResponse.Clusters clusters = SearchResponseTests.randomClusters();
            expectedSuccessful += successful;
        final int from = size > 0 ? randomIntBetween(0, 100) : 0;
                1,
        assertSame(clusters, mergedResponse.getClusters());
                shardSearchFailures[j] = failure;
            SearchHit expected = priorityQueue.poll();
                    }
                null,
        final SearchTimeProvider timeProvider = new SearchTimeProvider(randomLong(), 0, () -> currentRelativeTime);
                for (int i = 0; i < sortFields.length; i++) {
                if (compareTo != 0) {
                0,
            if (frequently() || indicesPerCluster.containsKey(RemoteClusterAware.LOCAL_CLUSTER_GROUP_KEY)) {
            if (shardIdCompareTo != 0) {
                new SearchRequestOperationsListener.CompositeListener(List.of(), LogManager.getLogger()),
                InternalSearchResponse.empty(),
        }
                1L,
        String clusterAlias,
        }
        for (int i = 0; i < numResponses; i++) {
            0,
        SearchHit[] hits = randomSearchHitArray(
                ShardSearchFailure.EMPTY_ARRAY,
                maxScore,
        Tuple<Integer, TotalHits.Relation> randomTrackTotalHits = randomTrackTotalHits();
 * the Apache License, Version 2.0 (the "License"); you may
        assertEquals(Math.min(numResponses, size), options.getOptions().size());
    }
 * Licensed to Elasticsearch under one or more contributor
        assertEquals(numResponses, searchResponseMerger.numResponses());
                ShardSearchFailure.EMPTY_ARRAY,
                totalHits = new TotalHits(randomLongBetween(0, 1000), totalHitsRelation);
            );
                10000,
        }
        assertEquals(expectedSkipped, searchResponse.getSkippedShards());
        );
            assertSame(expected, shardFailure);
        );
                new Text(randomAlphaOfLengthBetween(5, 10)),
            .getSuggest()
            }
        SearchResponse.Clusters clusters = SearchResponseTests.randomClusters();
                1,
    }
            searchHit.shard(
        assertEquals(totalCount, bucket.getDocCount());
        SearchResponse mergedResponse = merger.getMergedResponse(
                1,
 * not use this file except in compliance with the License.
                        Integer aSortValue = (Integer) a.getRawSortValues()[i];
import org.opensearch.search.internal.SearchContext;
                response,
            if (trackTotalHitsUpTo != SearchContext.TRACK_TOTAL_HITS_DISABLED) {
            sortFields[i] = new SortField("field-" + i, SortField.Type.INT, randomBoolean());
        );
                    SortField sortField = sortFields[i];
        assertEquals(0, searchResponse.getShardFailures().length);
            clusters,
        int[] sortFieldFactors = new int[sortFields == null ? 0 : sortFields.length];
        }
                return clusterAliasCompareTo;
            InternalSearchResponse response = new InternalSearchResponse(searchHits, null, null, null, false, false, 1);
            scoreSort = true;
                null,
        executorService = Executors.newFixedThreadPool(numResponses);
 * this work for additional information regarding copyright
        );
            TotalHits totalHits = null;
        for (int i = 0; i < numResponses; i++) {
import org.opensearch.test.OpenSearchTestCase;
            0,
            );
            if (collapseField != null) {
                SearchResponseTests.randomClusters()
        assertEquals(numResponses, mergedResponse.getSuccessfulShards());
            clusters,
        final int size = randomIntBetween(0, 100);
            assertNull(searchHits.getCollapseValues());
        assertEquals(1, suggestion.getEntries().size());
        SearchResponseMerger searchResponseMerger = new SearchResponseMerger(
        TotalHits.Relation totalHitsRelation = randomTrackTotalHits.v2();
                ShardSearchFailure failure = new ShardSearchFailure(new IllegalArgumentException(), searchShardTarget);
import org.opensearch.search.SearchHit;
        SearchResponseMerger merger = new SearchResponseMerger(
        assertTrue(executorService.awaitTermination(5, TimeUnit.SECONDS));
                () -> null
            );
            new SearchTimeProvider(0, 0, () -> 0),
                String indexUuid = frequently() ? randomAlphaOfLength(10) : indexName;
                            return compare;
                SearchResponse.Clusters.EMPTY
                new SearchRequestOperationsListener.CompositeListener(List.of(), LogManager.getLogger()),
        );
                numDocs,
                new SearchRequest(),
            assertTrue(Float.isNaN(searchHits.getMaxScore()));
                1,
            SearchResponse searchResponse = new SearchResponse(
            new Index[] { new Index("index", "uuid") },
        assertEquals(2, mergedResponse.getTotalShards());
            assertNull(searchHits.getCollapseField());
                sortFields,
                () -> null
                docId,
        }
                return Tuple.tuple(SearchContext.TRACK_TOTAL_HITS_ACCURATE, TotalHits.Relation.EQUAL_TO);
                null,
        assertEquals(0, mergedResponse.getSkippedShards());
        }
                numReducePhases
    public void testMergeCompletionSuggestions() throws InterruptedException {
            completionSuggestion.addTerm(options);
            );
        assertEquals(expectedTimedOut, searchResponse.isTimedOut());
        awaitResponsesAdded();
                } else {
        assertEquals(numResponses, mergedResponse.getSuccessfulShards());
        assertSame(clusters, mergedResponse.getClusters());
 * KIND, either express or implied.  See the License for the
        assertEquals(TimeUnit.NANOSECONDS.toMillis(currentRelativeTime), searchResponse.getTook().millis());
            emptyReduceContextBuilder()
        assertEquals(0, mergedResponse.getHits().getHits().length);
            );
    public void testMergeCompletionSuggestionsTieBreak() throws InterruptedException {
            ShardId shardId = new ShardId(
                    }
                randomLong(),
        assertEquals(expectedTotal, searchResponse.getTotalShards());
        for (int j = 0; j < numDocs; j++) {
        assertSame(clusters, mergedResponse.getClusters());
            emptyReduceContextBuilder()
            emptyReduceContextBuilder()
            maxValue = Math.max(value, maxValue);
                        }
                randomLong(),
        );
            if (Float.isNaN(maxScore) == false) {
 */
            int numFailures = randomIntBetween(1, 10);
                final SortField sortField;
            ShardSearchFailure[] shardSearchFailures = new ShardSearchFailure[numFailures];
    public void testMergeNoResponsesAdded() {
            CompletionSuggestion.Entry.Option option = new CompletionSuggestion.Entry.Option(
                null,
            "remote",
        final long currentRelativeTime = randomNonNegativeLong();
        SearchResponse.Clusters clusters = SearchResponseTests.randomClusters();
        for (int i = 0; i < numResponses; i++) {
                null,
        SearchResponseMerger merger = new SearchResponseMerger(
                new SearchRequestOperationsListener.CompositeListener(List.of(), LogManager.getLogger()),
        int numFields = randomIntBetween(1, 3);
        assertEquals(expectedTerminatedEarly, searchResponse.isTerminatedEarly());
        for (ShardSearchFailure shardFailure : shardFailures) {
        int scoreFactor,
            if (sortFields == null) {
            suggestions.add(completionSuggestion);
        assertEquals(numResponses, mergedResponse.getSuccessfulShards());
            SearchHits searchHits = new SearchHits(new SearchHit[0], null, Float.NaN);
                            compare = Integer.compare(aSortValue, bSortValue);
            addResponse(merger, searchResponse);
        } else {
import org.opensearch.transport.RemoteClusterAware;
                1F,
import java.util.HashMap;
            addResponse(searchResponseMerger, searchResponse);
            InternalMax max = new InternalMax(maxAggName, value, DocValueFormat.RAW, Collections.emptyMap());
            new SearchRequestContext(
            expectedTotal += total;
        assertSame(InternalAggregations.EMPTY, response.getAggregations());
                SearchResponse.Clusters.EMPTY
            for (int j = 0; j < numFailures; j++) {
            Comparator.comparing(Tuple::v1, (o1, o2) -> {
    private static final class SearchHitComparator implements Comparator<SearchHit> {
        Map<String, ProfileShardResult> expectedProfile = new HashMap<>();
                new SearchRequestOperationsListener.CompositeListener(List.of(), LogManager.getLogger()),
    }
                () -> null
        SearchResponseMerger merger = new SearchResponseMerger(0, 10, Integer.MAX_VALUE, timeProvider, emptyReduceContextBuilder());
    }
                0,
        SearchResponse mergedResponse = merger.getMergedResponse(
            ShardSearchFailure[] shardSearchFailures = new ShardSearchFailure[numFailures];
            SearchResponse searchResponse = new SearchResponse(
            )
            );
                () -> null
            new SearchTimeProvider(0, 0, () -> 0),
                1,
import org.opensearch.search.suggest.completion.CompletionSuggestion;
            SearchHits searchHits = new SearchHits(new SearchHit[0], new TotalHits(0, TotalHits.Relation.EQUAL_TO), Float.NaN);
        assertEquals(maxValue, max.getValue(), 0d);
        Index[] indices,
                searchHits,
            1,
                        }
            hit.shard(new SearchShardTarget("node", shardId, clusterAlias, OriginalIndices.NONE));
        assertSame(clusters, mergedResponse.getClusters());
                        if (compare != 0) {
        TotalHits.Relation totalHitsRelation = randomTrackTotalHits.v2();
            0,
import org.opensearch.OpenSearchException;
                successful,
                1L,
                () -> null
                priorityQueue
                        Integer bSortValue = (Integer) b.getRawSortValues()[i];
        for (SearchHit hit : hits) {
            new SearchRequestContext(
                        }
            // the collapse field is not returned when hits are empty
                false,
            );
            Suggest suggest = new Suggest(suggestions);
            new SearchRequestContext(
            );
        int expectedSkipped = 0;
        }
                SearchResponse.Clusters.EMPTY
        SortField[] sortFields,
                randomLong(),
        SearchHit[] hits = new SearchHit[numDocs];
 * this file be licensed under the Apache-2.0 license or a
                }
            );
            int successful = randomIntBetween(1, total);
                new SearchRequest(),
        if (hasHits) {
        assertEquals(expectedTotalHits, mergedResponse.getHits().getTotalHits());
    }
                SearchResponseTests.randomClusters()
                1,
            searchTimeProvider,
    public void testMergeOnlyEmptyHits() {
                SearchResponse.Clusters.EMPTY
        }
            sortFields = null;
        int lastShardId = 0;
        int numIndices = requestedSize == 0 ? 0 : randomIntBetween(1, requestedSize);
import java.util.concurrent.ExecutorService;
        assertEquals(numResponses, searchResponseMerger.numResponses());
                1,
 * ownership. Elasticsearch licenses this file to you under
        assertNull(response.getScrollId());
 * SPDX-License-Identifier: Apache-2.0
import java.util.concurrent.Executors;
        CompletionSuggestion.Entry options = suggestion.getEntries().get(0);
import static org.hamcrest.Matchers.containsInAnyOrder;
            assertEquals(--i, option.getScore(), 0f);
                sortFields[i] = sortField;
            List<Suggest.Suggestion<? extends Suggest.Suggestion.Entry<? extends Suggest.Suggestion.Entry.Option>>> suggestions =
                null,
import org.opensearch.transport.RemoteClusterService;
            timeProvider,
        assertEquals(numResponses, merger.numResponses());
        SearchTimeProvider searchTimeProvider = new SearchTimeProvider(0, 0, () -> 0);
import org.opensearch.search.aggregations.bucket.range.Range;
            float score = Float.NaN;
 *
                InternalSearchResponse.empty(),
                }
            0,
                if (randomBoolean()) {
            merger.add(searchResponse);
    }
                0,
        for (int i = 0; i < numFields; i++) {
        final SearchTimeProvider timeProvider = new SearchTimeProvider(randomLong(), 0, () -> currentRelativeTime);
                null,
        assertEquals(TimeUnit.NANOSECONDS.toMillis(currentRelativeTime), searchResponse.getTook().millis());
                response,
            SearchHits searchHits = new SearchHits(new SearchHit[0], null, Float.NaN);
 */
                ShardSearchFailure.EMPTY_ARRAY,
                1,
            emptyReduceContextBuilder()
        }
        SearchResponseMerger merger = new SearchResponseMerger(
                null,
                new SearchRequestOperationsListener.CompositeListener(List.of(), LogManager.getLogger()),
            );
            assertSame(expectedTotalHits.relation(), searchHits.getTotalHits().relation());
        assertEquals(numResponses, merger.numResponses());
                return Tuple.tuple(SearchContext.TRACK_TOTAL_HITS_DISABLED, null);
                collapseField,
    }
                        } else {
        Iterator<Map.Entry<String, Index[]>> indicesIterator = randomRealisticIndices(numIndices, numResponses).entrySet().iterator();
        @Override
        {
        } else {
                null,
                internalSearchResponse,
            clusters,
            randomIntBetween(0, 10000),
        assertEquals(numResponses, mergedResponse.getTotalShards());
                // Realistically clusters have the same indices with same names, but different uuid. Yet it can happen that the same cluster
            SearchProfileShardResults profile = SearchProfileShardResultsTests.createTestItem();
 * compatible open source license.
    public void testMergeSearchHits() throws InterruptedException {
        for (int i = 0; i < numResponses; i++) {
                null,
            assertNull(searchHits.getSortFields());
            merger.add(searchResponse);
        assertEquals(priorityQueue.size(), mergedResponse.getFailedShards());
                () -> null
            SearchHits searchHits = new SearchHits(new SearchHit[0], null, Float.NaN);
        }
        } else {
        Tuple<Integer, TotalHits.Relation> randomTrackTotalHits = randomTrackTotalHits();
        }
                1L,
                internalSearchResponse,
        assertFalse(response.isTimedOut());
                maxScore == Float.NEGATIVE_INFINITY ? Float.NaN : maxScore,
    private static SearchHit[] randomSearchHitArray(
            clusters,
            randomIntBetween(0, 1000),
                new SearchRequest(),
import org.opensearch.search.profile.SearchProfileShardResults;
        assertEquals(Math.min(numResponses, size), options.getOptions().size());
                () -> null
            SearchContext.TRACK_TOTAL_HITS_ACCURATE,
                ShardId shardId = new ShardId(index, index + "-uuid", j);
        String suggestionName = randomAlphaOfLengthBetween(4, 8);
        assertEquals(priorityQueue.size(), mergedResponse.getFailedShards());
            String clusterAlias = entry.getKey();
                new ArrayList<>();
            );
            new SearchRequestContext(
                    docValueFormats[k] = DocValueFormat.RAW;
        boolean scoreSort = false;
                OriginalIndices.NONE
                    "node",
        );
                int scoreCompare = Float.compare(b.getScore(), a.getScore());
        SearchResponseMerger merger = new SearchResponseMerger(0, 10, Integer.MAX_VALUE, timeProvider, emptyReduceContextBuilder());
            SearchResponse searchResponse = new SearchResponse(
import org.opensearch.search.aggregations.metrics.Max;
                    sortField = SortField.FIELD_SCORE;
            case 1:
            sortFieldFactors[j] = randomIntBetween(1, numResponses);
            hasHits |= hits.length > 0;
    }
        int numResponses,
                0,
                expectedTotalHits = new TotalHits(Math.min(previousValue + totalHits.value(), trackTotalHitsUpTo), totalHitsRelation);
                for (int j = 0; j < numDocs; j++) {
        SearchResponse.Clusters clusters = SearchResponseTests.randomClusters();
                        int scoreCompare = Float.compare(b.getScore(), a.getScore());
                String indexName = indicesNames[j];
            SearchResponse searchResponse = new SearchResponse(
            addResponse(searchResponseMerger, searchResponse);
            }
                count,
        List<ShardSearchFailure> expectedFailures = new ArrayList<>();
            SearchShardTarget shard = option.getHit().getShard();
            clusters,
            assertThat(currentShardId, greaterThanOrEqualTo(lastShardId));
                ShardSearchFailure.EMPTY_ARRAY,
                () -> null
/*
            new SearchRequestContext(
            int clusterAliasCompareTo = aShard.getClusterAlias().compareTo(bShard.getClusterAlias());
        PriorityQueue<Tuple<SearchShardTarget, ShardSearchFailure>> priorityQueue = new PriorityQueue<>(
            InternalSearchResponse internalSearchResponse = new InternalSearchResponse(searchHits, null, suggest, null, false, null, 1);
import java.util.Map;
                ShardSearchFailure.EMPTY_ARRAY,
        } else {
        awaitResponsesAdded();
            SearchHits searchHits = new SearchHits(hits, new TotalHits(10, TotalHits.Relation.EQUAL_TO), Float.NaN, sortFields, null, null);
        SearchTimeProvider timeProvider = new SearchTimeProvider(randomLong(), 0, () -> currentRelativeTime);
                null,
        if (randomBoolean()) {
    private static Map<String, Index[]> randomRealisticIndices(int numIndices, int numClusters) {
import static java.util.Collections.singletonList;
                    SortField sortField = sortFields[k];
    }
        assertEquals(numResponses, mergedResponse.getTotalShards());
            0,
        for (ShardSearchFailure shardFailure : shardFailures) {
        assertEquals(0, response.getSkippedShards());
                new SearchRequestOperationsListener.CompositeListener(List.of(), LogManager.getLogger()),
                    return compareTo;
        for (int i = 0; i < numResponses; i++) {
        assertEquals(numResponses, mergedResponse.getSuccessfulShards());
            TotalHits totalHits = null;
        assertEquals(2, mergedResponse.getAggregations().asList().size());
}
            SearchResponse searchResponse = new SearchResponse(
            SearchResponse.Clusters.EMPTY,
                expectedFailures.add(shardSearchFailure);
        assertEquals(0, mergedResponse.getFailedShards());
                shardSearchFailures,
        assertSame(clusters, response.getClusters());
                    collapseValues[j] = j + 1000 * i;
                randomLong(),
import java.util.Arrays;
        assertEquals(0, response.getHits().getTotalHits().value());
        }
        assertEquals(0, mergedResponse.getSkippedShards());
                new ArrayList<>();
            if (clusterAliasCompareTo != 0) {
                null,
        Range range = mergedResponse.getAggregations().get(rangeAggName);
                    if (sortField == SortField.FIELD_SCORE) {
        return indicesPerCluster;
            SearchContext.TRACK_TOTAL_HITS_ACCURATE,
            0,
            )
import java.util.List;
    ) {
            new SearchRequestContext(
            String clusterAlias = entry.getKey();
        }
            if (currentShardId == lastShardId) {
                scoreFactor,
                0,
            ShardSearchFailure[] shardSearchFailures = new ShardSearchFailure[numFailures];
        assertEquals(0, mergedResponse.getShardFailures().length);
            clusters,
            int currentShardId = shard.getShardId().id();
            Map.Entry<String, Index[]> entry = indicesPerCluster.next();
import org.opensearch.common.collect.Tuple;
            searchTimeProvider,
    public void testMergeShardFailures() throws InterruptedException {
            new SearchRequestContext(
                1,
            0,
                () -> null
            .getSuggestion(suggestionName);
        }
                0,
import org.opensearch.search.internal.InternalSearchResponse;
        awaitResponsesAdded();
                OpenSearchException openSearchException = new OpenSearchException(new IllegalArgumentException());
        String[] indicesNames = new String[numIndices];
            ShardSearchFailure expected = priorityQueue.poll().v2();
        final SortField[] sortFields;
import static org.hamcrest.Matchers.greaterThan;
                hit.sortValues(rawSortValues, docValueFormats);
        Boolean expectedTerminatedEarly = null;
            Index[] indices = entry.getValue();
            assertSame(expected, shardFailure);
        ShardSearchFailure[] shardFailures = merger.getMergedResponse(
            String clusterAlias = randomBoolean() ? "" : randomAlphaOfLengthBetween(5, 10);
                if (scoreCompare != 0) {
                    } else {
        assertEquals(0, mergedResponse.getShardFailures().length);
                indices[j] = new Index(indexName, indexUuid);
        }
        String lastClusterAlias = null;
            0,
            SearchResponse searchResponse = new SearchResponse(
        SearchResponse mergedResponse = merger.getMergedResponse(
        Suggest.Suggestion.Entry<? extends Suggest.Suggestion.Entry.Option> options = suggestion.getEntries().get(0);
            }
    }
            emptyReduceContextBuilder()
        );
            SearchShardTarget aShard = a.getShard();
            InternalSearchResponse internalSearchResponse = new InternalSearchResponse(
        Map<String, Index[]> indicesPerCluster = new TreeMap<>();
import static org.hamcrest.Matchers.lessThanOrEqualTo;
            Index[] indices = new Index[indicesNames.length];
        assertNotNull(response.getHits().getTotalHits());
        }
        int size = randomIntBetween(1, 100);
        SearchResponseMerger merger = new SearchResponseMerger(
        assertEquals("10000.0", bucket.getToAsString());
                new SearchRequest(),
            SearchResponse searchResponse = new SearchResponse(
        int size = randomIntBetween(1, 100);
 */
        assertArrayEquals(sortFields, mergedResponse.getHits().getSortFields());
        for (int i = 0; i < numResponses; i++) {
            expectedMaxScore = Math.max(expectedMaxScore, maxScore);
        awaitResponsesAdded();
import java.util.ArrayList;
            merger.add(searchResponse);
            options.addOption(option);
            searchResponseMerger.add(searchResponse);
import org.opensearch.search.SearchHits;
        assertNull(response.isTerminatedEarly());
            );
            }
                1,
                "bucket",
 * Modifications Copyright OpenSearch Contributors. See
                // is registered twice with different aliases and searched multiple times as part of the same search request.
        }
        assertThat(hits.length, lessThanOrEqualTo(size));
        SearchResponseMerger merger = new SearchResponseMerger(0, 10, trackTotalHitsUpTo, timeProvider, emptyReduceContextBuilder());
                collapseValues
        SearchResponse.Clusters clusters = SearchResponseTests.randomClusters();
        int numResponses = randomIntBetween(1, 5);
            0,
                new SearchRequest(),
                randomAlphaOfLengthBetween(3, 8),
            InternalDateRange range = factory.create(rangeAggName, singletonList(bucket), DocValueFormat.RAW, false, emptyMap());
        assertEquals(0, mergedResponse.getShardFailures().length);
            addResponse(searchResponseMerger, searchResponse);
    public void testMergeTookInMillis() throws InterruptedException {
    public void init() {
                throw new UnsupportedOperationException();
        }
    }
        assertEquals(0, mergedResponse.getSkippedShards());
        for (int i = 0; i < numIndices; i++) {
                response,
                shardSearchFailures,
import org.opensearch.search.DocValueFormat;
        int i = numResponses;
        assertEquals(clusters, mergedResponse.getClusters());
        if (collapseField != null
        for (int i = 0; i < numClusters; i++) {
package org.opensearch.action.search;
import org.junit.Before;
                new SearchRequest(),
            assertNotNull(searchHits.getTotalHits());
        }
            int count = randomIntBetween(1, 1000);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        SearchTimeProvider searchTimeProvider = new SearchTimeProvider(0, 0, () -> 0);
            );
    private int numResponses;
            && hasHits) {
                100L,
        SearchHits searchHits = searchResponse.getHits();
            expectedSkipped += skipped;
                new SearchRequest(),
import org.opensearch.action.search.TransportSearchAction.SearchTimeProvider;
            default:
            );
                100L,
        assertEquals(numResponses, mergedResponse.getTotalShards());
            searchTimeProvider,
        assertEquals(1, suggestion.getEntries().size());
 *
            0,
            CompletionSuggestion.Entry options = new CompletionSuggestion.Entry(new Text("suggest"), 0, 10);
                openSearchException.setShard(shardId);
 * You may obtain a copy of the License at
 * software distributed under the License is distributed on an
                    sortField = new SortField("field-" + i, SortField.Type.INT, randomBoolean());
                timedOut,
        PriorityQueue<Tuple<ShardId, ShardSearchFailure>> priorityQueue = new PriorityQueue<>(Comparator.comparing(Tuple::v1));
        int trackTotalHitsUpTo = randomTrackTotalHits.v1();
            assertNull(searchHits.getTotalHits());
            }
        }
            new SearchRequestContext(
            int numFailures = randomIntBetween(1, 50);
                new SearchRequestOperationsListener.CompositeListener(List.of(), LogManager.getLogger()),
        String suggestionName = randomAlphaOfLengthBetween(4, 8);
            Map.Entry<String, Index[]> entry = indicesIterator.next();
        assertEquals(10, mergedResponse.getHits().getTotalHits().value());
        assertEquals(TimeUnit.NANOSECONDS.toMillis(currentRelativeTime), response.getTook().millis());
        SearchResponse.Clusters clusters = SearchResponseTests.randomClusters();
        for (int i = 0; i < from; i++) {
        for (CompletionSuggestion.Entry.Option option : options) {
                docId,
import java.util.TreeMap;
                hits,
                ShardSearchFailure.EMPTY_ARRAY,
            CompletionSuggestion completionSuggestion = new CompletionSuggestion(suggestionName, size, false);
        final SearchResponse.Clusters clusters = SearchResponseTests.randomClusters();
                    } else {
        assertEquals(2, mergedResponse.getSuccessfulShards());
                0,
        }
            SearchHits empty = new SearchHits(new SearchHit[0], new TotalHits(0, TotalHits.Relation.EQUAL_TO), Float.NaN, null, null, null);
            } else {
            boolean timedOut = rarely();
            int skipped = randomIntBetween(1, total);
            case 2:
                ShardSearchFailure.EMPTY_ARRAY,
            addResponse(merger, searchResponse);
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
            sortFields,
