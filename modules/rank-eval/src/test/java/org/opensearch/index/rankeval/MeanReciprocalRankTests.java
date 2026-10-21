        EvalQueryQuality evaluation = reciprocalRank.evaluate("id", hits, ratedDocs);
        assertEquals((double) 1 / 3, evaluation.metricScore(), 0.00001);
            itemParser.nextToken();
        rated.add(new RatedDocument("test", "0", 0));
        MeanReciprocalRank reciprocalRank = new MeanReciprocalRank(2, 10);
 * compatible open source license.
        EvalQueryQuality evaluation = reciprocalRank.evaluate("id", hits, ratedDocs);
 * Modifications Copyright OpenSearch Contributors. See
    }
    public void testXContentParsingIsNotLenient() throws IOException {
        }
            if (i == relevantAt) {
        int rankAtFirstRelevant = relevantAt + 1;
        }
        xContent = "{ \"relevant_rating_threshold\": 2, \"k\" : 15 }";
    }
    public void testEvaluationNoRelevantInResults() {
        EvalQueryQuality evaluation = reciprocalRank.evaluate("id", hits, ratedDocs);
     * test that the relevant rating threshold can be set to something larger than
    public void testInvalidK() {
import org.opensearch.core.xcontent.XContentParser;
import java.util.Arrays;
        }
        // check that if we have fewer search hits than relevant doc position,
        MeanReciprocalRank deserialized = OpenSearchTestCase.copyWriteable(
     */
 * not use this file except in compliance with the License.
/*
        // we don't find any result and get 0.0 score
    }
        try (XContentParser parser = createParser(xContentType.xContent(), withRandomFields)) {
    public void testNoResults() throws Exception {
        EvalQueryQuality evaluation = reciprocalRank.evaluate("id", hits, rated);
            XContentParseException exception = expectThrows(XContentParseException.class, () -> MeanReciprocalRank.fromXContent(parser));
        xContent = "{ \"relevant_rating_threshold\": 2 }";
            hits[i].shard(new SearchShardTarget("testnode", new ShardId(index, "uuid", 0), null, OriginalIndices.NONE));
            assertNotSame(testItem, parsedItem);
        List<RatedDocument> rated = new ArrayList<>();
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
     * Create SearchHits for testing, starting from dociId 'from' up to docId 'to'.
 *
            itemParser.nextToken();
            assertEquals(1, mrr.getRelevantRatingThreshold());
    }
            assertEquals(2, mrr.getRelevantRatingThreshold());
 */
        // mark one of the ten docs relevant
        for (int i = from; i <= to; i++) {
import org.opensearch.search.SearchShardTarget;
        rated.add(new RatedDocument("test", "1", 1));
     */
        partialResults.add(new EvalQueryQuality("id3", 0.75));
        List<RatedDocument> ratedDocs = new ArrayList<>();
import java.util.Collections;
            if (i == relevantAt) {
 * software distributed under the License is distributed on an
        return new MeanReciprocalRank(testItem.getRelevantRatingThreshold(), testItem.getK());
    public void testPrecisionAtFiveRelevanceThreshold() {
    private static final int IRRELEVANT_RATING_0 = 0;
 *
        XContentBuilder shuffled = shuffleXContent(testItem.toXContent(builder, ToXContent.EMPTY_PARAMS));
        }
            MeanReciprocalRank mrr = MeanReciprocalRank.fromXContent(parser);
    public void testSerialization() throws IOException {
import org.opensearch.search.SearchHit;
        MeanReciprocalRank testItem = createTestItem();
            assertEquals(10, mrr.getK());
    public void testParseFromXContent() throws IOException {
    /**
            assertEquals(testItem.hashCode(), parsedItem.hashCode());
import java.io.IOException;
import org.opensearch.core.index.shard.ShardId;
            assertEquals(1, mrr.getRelevantRatingThreshold());
import static org.hamcrest.CoreMatchers.containsString;
    public void testEvaluationOneRelevantInResults() {
    /**
        MeanReciprocalRank reciprocalRank = new MeanReciprocalRank();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            parser.nextToken();
    }
 */
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, xContent)) {
    }
            assertThat(exception.getMessage(), containsString("[reciprocal_rank] unknown field"));
        int relevantAt = randomIntBetween(0, 9);
 * license agreements. See the NOTICE file distributed with
        String xContent = "{ }";
                ratedDocs.add(new RatedDocument("test", Integer.toString(i), RELEVANT_RATING_1));
        SearchHit[] hits = createSearchHits(0, 9, "test");
            new NamedWriteableRegistry(Collections.emptyList()),
        assertEquals(1.0 / rankAtFirstRelevant, evaluation.metricScore(), Double.MIN_VALUE);
        MeanReciprocalRank reciprocalRank = new MeanReciprocalRank();
    }
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, xContent)) {
        try (XContentParser itemParser = createParser(shuffled)) {
        assertEquals(3, ((MeanReciprocalRank.Detail) evaluation.getMetricDetails()).getFirstRelevantRank());
 * the Apache License, Version 2.0 (the "License"); you may
        );
    public void testEqualsAndHash() throws IOException {
/*
 * The OpenSearch Contributors require contributions made to
            MeanReciprocalRank parsedItem = MeanReciprocalRank.fromXContent(itemParser);
 * Unless required by applicable law or agreed to in writing,
    }
    }
        List<EvalQueryQuality> partialResults = new ArrayList<>(3);
    }
    }
            return new MeanReciprocalRank(testItem.getRelevantRatingThreshold() + 1, testItem.getK());
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, xContent)) {
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.action.OriginalIndices;
     * 1. e.g. we set it to 2 here and expect dics 0-2 to be not relevant, so first
        xContent = "{ \"k\" : 15 }";
            assertEquals(testItem, parsedItem);
        rated.add(new RatedDocument("test", "4", 4));
}
        assertEquals(relevantAt + 1, ((MeanReciprocalRank.Detail) evaluation.getMetricDetails()).getFirstRelevantRank());
        reciprocalRank = new MeanReciprocalRank();
        }
 * this file be licensed under the Apache-2.0 license or a
            assertEquals(15, mrr.getK());
        if (randomBoolean()) {
 * this work for additional information regarding copyright
        }
        SearchHit[] hits = new SearchHit[to + 1 - from];
        int searchHits = randomIntBetween(1, 50);
        SearchHit[] hits = createSearchHits(0, 9, "test");
    public void testMaxAcceptableRank() {
        List<RatedDocument> ratedDocs = new ArrayList<>();
import org.opensearch.common.xcontent.json.JsonXContent;
            return new MeanReciprocalRank(testItem.getRelevantRatingThreshold(), testItem.getK() + 1);
            original,
    }
import java.util.List;
public class MeanReciprocalRankTests extends OpenSearchTestCase {
        MeanReciprocalRank reciprocalRank = new MeanReciprocalRank();
    }
            }
        for (int i = 0; i <= 20; i++) {
 * Licensed to Elasticsearch under one or more contributor
 */
        XContentType xContentType = randomFrom(XContentType.values());
        EvalQueryQuality evaluated = (new MeanReciprocalRank()).evaluate("id", hits, Collections.emptyList());
        assertEquals(deserialized.hashCode(), original.hashCode());
import static org.opensearch.test.XContentTestUtils.insertRandomFields;
 *    http://www.apache.org/licenses/LICENSE-2.0
        assertNotSame(deserialized, original);
 * specific language governing permissions and limitations
            assertEquals(10, mrr.getK());
        }
        assertEquals(deserialized, original);
        assertEquals(0.0d, evaluated.metricScore(), 0.00001);
        return hits;
            hits[i] = new SearchHit(i, i + "", Collections.emptyMap(), Collections.emptyMap());
    }
    private static MeanReciprocalRank mutate(MeanReciprocalRank testItem) {
    public void testXContentRoundtrip() throws IOException {
    }
import java.util.ArrayList;
        SearchHit[] hits = createSearchHits(0, 5, "test");
            MeanReciprocalRank mrr = MeanReciprocalRank.fromXContent(parser);
        assertEquals(-1, ((MeanReciprocalRank.Detail) evaluated.getMetricDetails()).getFirstRelevantRank());
        XContentBuilder builder = MediaTypeRegistry.contentBuilder(randomFrom(XContentType.values()));
                ratedDocs.add(new RatedDocument("test", Integer.toString(i), IRRELEVANT_RATING_0));
        assertEquals(0.0, evaluation.metricScore(), Double.MIN_VALUE);
 * GitHub history for details.
        assertEquals(rankAtFirstRelevant, ((MeanReciprocalRank.Detail) evaluation.getMetricDetails()).getFirstRelevantRank());
    private static final int RELEVANT_RATING_1 = 1;
        partialResults.add(new EvalQueryQuality("id2", 1.0));
        assertEquals(0.0, evaluation.metricScore(), Double.MIN_VALUE);
            MeanReciprocalRank mrr = MeanReciprocalRank.fromXContent(parser);
        assertEquals(0.75, reciprocalRank.combine(partialResults), Double.MIN_VALUE);
import org.opensearch.core.xcontent.XContentBuilder;
     * The search hits index also need to be provided
        rated.add(new RatedDocument("test", "2", 2));
        partialResults.add(new EvalQueryQuality("id1", 0.5));
        BytesReference originalBytes = toShuffledXContent(testItem, xContentType, ToXContent.EMPTY_PARAMS, randomBoolean());
import org.opensearch.core.xcontent.MediaTypeRegistry;
import static org.opensearch.test.EqualsHashCodeTestUtils.checkEqualsAndHashCode;
        return new MeanReciprocalRank(randomIntBetween(0, 20), randomIntBetween(1, 20));
        } else {
        MeanReciprocalRank testItem = createTestItem();
import org.opensearch.common.xcontent.XContentType;
    private static SearchHit[] createSearchHits(int from, int to, String index) {
        expectThrows(IllegalArgumentException.class, () -> new MeanReciprocalRank(1, -1));
import org.opensearch.core.xcontent.ToXContent;
        for (int i = 0; i <= searchHits; i++) {
        assertEquals(1.0 / (relevantAt + 1), evaluation.metricScore(), Double.MIN_VALUE);
        SearchHit[] hits = new SearchHit[0];
        }
        expectThrows(IllegalArgumentException.class, () -> new MeanReciprocalRank(-1, 1));
            }
    }
package org.opensearch.index.rankeval;
    private static MeanReciprocalRank copy(MeanReciprocalRank testItem) {
            assertEquals(2, mrr.getRelevantRatingThreshold());
        MeanReciprocalRank original = createTestItem();
            } else {
 * KIND, either express or implied.  See the License for the
import org.opensearch.test.OpenSearchTestCase;
            assertEquals(15, mrr.getK());
            MeanReciprocalRank mrr = MeanReciprocalRank.fromXContent(parser);
        }
                ratedDocs.add(new RatedDocument("test", Integer.toString(i), IRRELEVANT_RATING_0));
        List<RatedDocument> ratedDocs = new ArrayList<>();
            } else {
    }
 * ownership. Elasticsearch licenses this file to you under
        BytesReference withRandomFields = insertRandomFields(xContentType, originalBytes, null, random());
    static MeanReciprocalRank createTestItem() {
import org.opensearch.core.xcontent.XContentParseException;
        checkEqualsAndHashCode(createTestItem(), MeanReciprocalRankTests::copy, MeanReciprocalRankTests::mutate);
 * under the License.
        MeanReciprocalRank reciprocalRank = new MeanReciprocalRank();
                ratedDocs.add(new RatedDocument("test", Integer.toString(i), RELEVANT_RATING_1));
        SearchHit[] hits = createSearchHits(0, searchHits, "test");
/*
        evaluation = reciprocalRank.evaluate("id", Arrays.copyOfRange(hits, 0, relevantAt), ratedDocs);
        int relevantAt = randomIntBetween(0, searchHits);
 * You may obtain a copy of the License at
            parser.nextToken();
        rated.add(new RatedDocument("test", "3", 3));
import org.opensearch.core.common.bytes.BytesReference;
        }
    public void testInvalidRelevantThreshold() {
    public void testCombine() {
            MeanReciprocalRank::new
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, xContent)) {
 *
     * relevant doc has third ranking position, so RR should be 1/3
