        MeanReciprocalRank testItem = createTestItem();  
            assertEquals(15, mrr.getK());
        XContentBuilder builder = MediaTypeRegistry.contentBuilder(randomFrom(XContentType.values()));
        MeanReciprocalRank reciprocalRank = new MeanReciprocalRank();
        rated.add(new RatedDocument("test", "2", 2));
        assertEquals(relevantAt + 1, ((MeanReciprocalRank.Detail) evaluation.getMetricDetails()).getFirstRelevantRank());
        SearchHit[] hits = createSearchHits(0, 9, "test");
        rated.add(new RatedDocument("test", "1", 1));  
        int relevantAt = randomIntBetween(0, searchHits);  
        expectThrows(IllegalArgumentException.class, () -> new MeanReciprocalRank(1, -1));
 * Modifications Copyright OpenSearch Contributors. See
    }
/*  
    }
            }  
            MeanReciprocalRank mrr = MeanReciprocalRank.fromXContent(parser);  
        partialResults.add(new EvalQueryQuality("id1", 0.5));  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            original,
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, xContent)) {
            } else {  
            hits[i] = new SearchHit(i, i + "", Collections.emptyMap(), Collections.emptyMap());
            parser.nextToken();
            itemParser.nextToken();  
    }
            assertEquals(10, mrr.getK());  
        }  
        MeanReciprocalRank reciprocalRank = new MeanReciprocalRank();
import java.util.List;
            assertEquals(15, mrr.getK());  
import org.opensearch.common.xcontent.XContentType;
        }  
        checkEqualsAndHashCode(createTestItem(), MeanReciprocalRankTests::copy, MeanReciprocalRankTests::mutate);  
                ratedDocs.add(new RatedDocument("test", Integer.toString(i), RELEVANT_RATING_1));  
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, xContent)) {  
/*
        partialResults.add(new EvalQueryQuality("id2", 1.0));
        );
        List<RatedDocument> ratedDocs = new ArrayList<>();  
 * not use this file except in compliance with the License.
        try (XContentParser parser = createParser(xContentType.xContent(), withRandomFields)) {
 * Unless required by applicable law or agreed to in writing,
        SearchHit[] hits = createSearchHits(0, searchHits, "test");
            assertEquals(testItem, parsedItem);  
    public void testNoResults() throws Exception {
        } else {
 * this work for additional information regarding copyright
    public void testEqualsAndHash() throws IOException {
        assertEquals(deserialized, original);  
        SearchHit[] hits = createSearchHits(0, 9, "test");
        assertEquals(3, ((MeanReciprocalRank.Detail) evaluation.getMetricDetails()).getFirstRelevantRank());  
import org.opensearch.test.OpenSearchTestCase;
        assertEquals((double) 1 / 3, evaluation.metricScore(), 0.00001);
package org.opensearch.index.rankeval;
    public void testMaxAcceptableRank() {
            assertEquals(10, mrr.getK());
        MeanReciprocalRank original = createTestItem();  
    }  
    private static MeanReciprocalRank copy(MeanReciprocalRank testItem) {  
            assertEquals(1, mrr.getRelevantRatingThreshold());
import org.opensearch.common.xcontent.json.JsonXContent;  
 *
        XContentBuilder shuffled = shuffleXContent(testItem.toXContent(builder, ToXContent.EMPTY_PARAMS));  
            assertEquals(2, mrr.getRelevantRatingThreshold());
import java.util.Collections;
    }
        }
        assertEquals(0.0d, evaluated.metricScore(), 0.00001);
        evaluation = reciprocalRank.evaluate("id", Arrays.copyOfRange(hits, 0, relevantAt), ratedDocs);
        }
        // check that if we have fewer search hits than relevant doc position,
            if (i == relevantAt) {
import org.opensearch.search.SearchHit;  
                ratedDocs.add(new RatedDocument("test", Integer.toString(i), IRRELEVANT_RATING_0));
        List<RatedDocument> rated = new ArrayList<>();
        }
            MeanReciprocalRank parsedItem = MeanReciprocalRank.fromXContent(itemParser);
    }  
import org.opensearch.core.xcontent.MediaTypeRegistry;
        }
            return new MeanReciprocalRank(testItem.getRelevantRatingThreshold(), testItem.getK() + 1);
        if (randomBoolean()) {
import java.util.Arrays;  
            XContentParseException exception = expectThrows(XContentParseException.class, () -> MeanReciprocalRank.fromXContent(parser));
    public void testEvaluationNoRelevantInResults() {  
        xContent = "{ \"relevant_rating_threshold\": 2 }";  
        MeanReciprocalRank reciprocalRank = new MeanReciprocalRank(2, 10);  
        MeanReciprocalRank deserialized = OpenSearchTestCase.copyWriteable(
            assertThat(exception.getMessage(), containsString("[reciprocal_rank] unknown field"));
        EvalQueryQuality evaluation = reciprocalRank.evaluate("id", hits, ratedDocs);
            itemParser.nextToken();
    }  
        SearchHit[] hits = new SearchHit[to + 1 - from];
        EvalQueryQuality evaluation = reciprocalRank.evaluate("id", hits, rated);
        assertEquals(0.0, evaluation.metricScore(), Double.MIN_VALUE);
 * license agreements. See the NOTICE file distributed with
        int searchHits = randomIntBetween(1, 50);  
        reciprocalRank = new MeanReciprocalRank();
 * You may obtain a copy of the License at  
        BytesReference withRandomFields = insertRandomFields(xContentType, originalBytes, null, random());  
        }  
        rated.add(new RatedDocument("test", "4", 4));  
        int rankAtFirstRelevant = relevantAt + 1;  
            parser.nextToken();  
            if (i == relevantAt) {
        int relevantAt = randomIntBetween(0, 9);
        SearchHit[] hits = createSearchHits(0, 5, "test");
        xContent = "{ \"k\" : 15 }";
        MeanReciprocalRank reciprocalRank = new MeanReciprocalRank();
            MeanReciprocalRank mrr = MeanReciprocalRank.fromXContent(parser);
        assertEquals(-1, ((MeanReciprocalRank.Detail) evaluated.getMetricDetails()).getFirstRelevantRank());  
    }
            assertEquals(2, mrr.getRelevantRatingThreshold());  
        rated.add(new RatedDocument("test", "3", 3));
import static org.hamcrest.CoreMatchers.containsString;  
import org.opensearch.core.xcontent.XContentBuilder;  
    public void testInvalidK() {
    public void testInvalidRelevantThreshold() {  
        MeanReciprocalRank reciprocalRank = new MeanReciprocalRank();
import org.opensearch.core.common.bytes.BytesReference;
import org.opensearch.core.xcontent.ToXContent;
public class MeanReciprocalRankTests extends OpenSearchTestCase {
        }  
     */
     */  
    private static SearchHit[] createSearchHits(int from, int to, String index) {
import org.opensearch.action.OriginalIndices;
        return new MeanReciprocalRank(testItem.getRelevantRatingThreshold(), testItem.getK());
    public void testParseFromXContent() throws IOException {
 * the Apache License, Version 2.0 (the "License"); you may
import static org.opensearch.test.XContentTestUtils.insertRandomFields;
    }
    }
 * under the License.  
 * this file be licensed under the Apache-2.0 license or a
 * SPDX-License-Identifier: Apache-2.0
        return new MeanReciprocalRank(randomIntBetween(0, 20), randomIntBetween(1, 20));
import org.opensearch.search.SearchShardTarget;
        assertEquals(1.0 / rankAtFirstRelevant, evaluation.metricScore(), Double.MIN_VALUE);
    public void testXContentParsingIsNotLenient() throws IOException {
        EvalQueryQuality evaluated = (new MeanReciprocalRank()).evaluate("id", hits, Collections.emptyList());
            assertEquals(1, mrr.getRelevantRatingThreshold());
        SearchHit[] hits = new SearchHit[0];  
        assertEquals(0.0, evaluation.metricScore(), Double.MIN_VALUE);  
                ratedDocs.add(new RatedDocument("test", Integer.toString(i), RELEVANT_RATING_1));
 *
            hits[i].shard(new SearchShardTarget("testnode", new ShardId(index, "uuid", 0), null, OriginalIndices.NONE));
            new NamedWriteableRegistry(Collections.emptyList()),  
    }  
import org.opensearch.core.xcontent.XContentParseException;
        }
            assertEquals(testItem.hashCode(), parsedItem.hashCode());
        partialResults.add(new EvalQueryQuality("id3", 0.75));
 * specific language governing permissions and limitations
    private static final int IRRELEVANT_RATING_0 = 0;
     * relevant doc has third ranking position, so RR should be 1/3
        try (XContentParser itemParser = createParser(shuffled)) {
import java.util.ArrayList;
            }
        return hits;
        assertEquals(0.75, reciprocalRank.combine(partialResults), Double.MIN_VALUE);  
        assertNotSame(deserialized, original);
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
        assertEquals(1.0 / (relevantAt + 1), evaluation.metricScore(), Double.MIN_VALUE);  
            } else {
 * GitHub history for details.
        assertEquals(deserialized.hashCode(), original.hashCode());
        rated.add(new RatedDocument("test", "0", 0));
            MeanReciprocalRank mrr = MeanReciprocalRank.fromXContent(parser);
 * The OpenSearch Contributors require contributions made to  
    public void testXContentRoundtrip() throws IOException {  
/*  
import org.opensearch.core.index.shard.ShardId;  
    static MeanReciprocalRank createTestItem() {
        xContent = "{ \"relevant_rating_threshold\": 2, \"k\" : 15 }";
import static org.opensearch.test.EqualsHashCodeTestUtils.checkEqualsAndHashCode;
        for (int i = 0; i <= 20; i++) {  
    public void testPrecisionAtFiveRelevanceThreshold() {  
     * Create SearchHits for testing, starting from dociId 'from' up to docId 'to'.
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, xContent)) {  
        }  
 */  
import java.io.IOException;
    public void testSerialization() throws IOException {
        expectThrows(IllegalArgumentException.class, () -> new MeanReciprocalRank(-1, 1));
    /**  
    /**
 * compatible open source license.
        List<EvalQueryQuality> partialResults = new ArrayList<>(3);
        EvalQueryQuality evaluation = reciprocalRank.evaluate("id", hits, ratedDocs);
    private static final int RELEVANT_RATING_1 = 1;
        XContentType xContentType = randomFrom(XContentType.values());
}
        // we don't find any result and get 0.0 score  
    }  
 *    http://www.apache.org/licenses/LICENSE-2.0
            assertNotSame(testItem, parsedItem);
            return new MeanReciprocalRank(testItem.getRelevantRatingThreshold() + 1, testItem.getK());  
    }
        // mark one of the ten docs relevant
 */  
            MeanReciprocalRank mrr = MeanReciprocalRank.fromXContent(parser);
    }
import org.opensearch.core.xcontent.XContentParser;
 * KIND, either express or implied.  See the License for the
            MeanReciprocalRank::new
 */
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, xContent)) {
     * The search hits index also need to be provided
        BytesReference originalBytes = toShuffledXContent(testItem, xContentType, ToXContent.EMPTY_PARAMS, randomBoolean());
 * ownership. Elasticsearch licenses this file to you under  
 * software distributed under the License is distributed on an
        assertEquals(rankAtFirstRelevant, ((MeanReciprocalRank.Detail) evaluation.getMetricDetails()).getFirstRelevantRank());  
    }
    public void testCombine() {  
    }
     * 1. e.g. we set it to 2 here and expect dics 0-2 to be not relevant, so first  
        List<RatedDocument> ratedDocs = new ArrayList<>();  
        String xContent = "{ }";
        List<RatedDocument> ratedDocs = new ArrayList<>();
        for (int i = from; i <= to; i++) {  
    public void testEvaluationOneRelevantInResults() {  
 * Licensed to Elasticsearch under one or more contributor  
 *  
        EvalQueryQuality evaluation = reciprocalRank.evaluate("id", hits, ratedDocs);
        MeanReciprocalRank testItem = createTestItem();
    private static MeanReciprocalRank mutate(MeanReciprocalRank testItem) {
     * test that the relevant rating threshold can be set to something larger than
    }
                ratedDocs.add(new RatedDocument("test", Integer.toString(i), IRRELEVANT_RATING_0));
        for (int i = 0; i <= searchHits; i++) {
