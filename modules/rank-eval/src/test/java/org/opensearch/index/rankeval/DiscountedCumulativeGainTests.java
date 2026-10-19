          rank | relevance | 2^(relevance) - 1 | log_2(rank + 1) | (2^(relevance) - 1) / log_2(rank + 1)
     * 1 | 3 | 7.0 | 1.0 | 7.0 2 | 
        assertEquals(deserialized, original);
        DiscountedCumulativeGain deserialized = OpenSearchTestCase.copyWriteable(
            if (i < relevanceRatings.length) {
            case 1:
          6 | 0 | 0.0 | 2.807354922057604  | 0.0
        DiscountedCumulativeGain testItem = createTestItem();
import org.opensearch.core.xcontent.XContentParseException;
    public void testMetricDetails() {
        assertParsedCorrect("{ \"k\": 23 }", null, false, 23);
          4 | 1 | 1.0 | 2.321928094887362   | 0.43067655807339
     * test that metric returns 0.0 when there are no search results
     * 6 | n/a | n/a | n/a | n/a
            case 2:
                    + ",\"ideal_dcg\":"
        }
    public void testDCGAt() {
        }
          relevance in descending order
     * 2 | 3.0 | 1.5849625007211563 | 1.8927892607143721
          5 | n.a | n.a | n.a.  | n.a.
            hits[i].shard(new SearchShardTarget("testnode", new ShardId("index", "uuid", 0), null, OriginalIndices.NONE));
        DiscountedCumulativeGain testItem = createTestItem();
     * 4 | n/a | n/a | n/a | n/a
 * SPDX-License-Identifier: Apache-2.0
     */
import org.opensearch.search.SearchShardTarget;
     * 3 | 3 | 7.0 | 2.0 | 3.5
 * specific language governing permissions and limitations
        }
package org.opensearch.index.rankeval;
     * Assuming the docs are ranked in the following order:
     * 2 | 2 | 3.0 | 1.5849625007211563 | 1.8927892607143721
/*
            parser.nextToken();
        }
public class DiscountedCumulativeGainTests extends OpenSearchTestCase {
    static final double EXPECTED_DCG = 13.84826362927298;
        XContentBuilder shuffled = shuffleXContent(testItem.toXContent(builder, ToXContent.EMPTY_PARAMS));
        /*
     * <p>
/*
 * Modifications Copyright OpenSearch Contributors. See
                Strings.toString(MediaTypeRegistry.JSON, detail)
     * 6 | n/a | n/a | n/a | n/a
     * 5 | 1 | 1.0 | 2.584962500721156 | 0.38685280723454163
                "{\"dcg\":{\"dcg\":" + dcg + ",\"unrated_docs\":" + unratedDocs + "}}",
 * compatible open source license.
        result = dcg.evaluate("id", hits, ratedDocs);
 * The OpenSearch Contributors require contributions made to
        assertEquals(0, filterUnratedDocuments(result.getHitsAndRatings()).size());
         */
            parser.nextToken();
import org.opensearch.test.OpenSearchTestCase;
    private static DiscountedCumulativeGain mutateTestItem(DiscountedCumulativeGain original) {
        assertEquals(idcg, detail.getIDCG(), 0.0);
            assertEquals(testItem.hashCode(), parsedItem.hashCode());
     * 3 | 3 | 7.0 | 2.0 | 3.5
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.action.OriginalIndices;
        assertEquals(unratedDocs, detail.getUnratedDocs());
     * rating provided by the user.
        List<RatedDocument> rated = new ArrayList<>();
import org.opensearch.core.xcontent.ToXContent;
     * -----------------------------------------------------------------
    /**
    public void testDCGAtSixMissingRatings() {
         */
/*
        List<RatedDocument> ratedDocs = new ArrayList<>();
    }
 */
import org.opensearch.core.index.shard.ShardId;
import org.opensearch.core.common.bytes.BytesReference;
            new NamedWriteableRegistry(Collections.emptyList()),
            if (i < relevanceRatings.length) {
          ---------------------------------------------------------------------------------------
import static org.opensearch.test.EqualsHashCodeTestUtils.checkEqualsAndHashCode;
        boolean normalize = randomBoolean();
    private static final double DELTA = 10E-14;
        EvalQueryQuality result = dcg.evaluate("id", hits, ratedDocs);
            );
     * 1 | 3 | 7.0 | 1.0 | 7.0 | 7.0 | 
        assertEquals(0.0d, result.metricScore(), DELTA);
     * 3 | 3 | 7.0 | 2.0 | 3.5
                    randomValueOtherThan(original.getK(), () -> randomIntBetween(1, 10))
         */
          Check with normalization: to get the maximal possible dcg, sort documents by
          2 | 3 | 7.0 | 1.5849625007211563 | 4.416508275000202
          Check with normalization: to get the maximal possible dcg, sort documents by
import static org.hamcrest.CoreMatchers.containsString;
                    original.getNormalize(),
        int unratedDocs = randomIntBetween(0, 100);
        XContentBuilder builder = MediaTypeRegistry.contentBuilder(randomFrom(XContentType.values()));
     */
            }
 *
                    + expectedNdcg
          6 | n.a | n.a | n.a  | n.a
                }
                    + "}}",
import java.util.List;
        assertEquals(12.392789260714371 / 13.347184833073591, dcg.evaluate("id", hits, ratedDocs).metricScore(), DELTA);
            }
     * 1 | 3 | 7.0 | 1.0 | 7.0 2 | 
        assertEquals(dcg, detail.getDCG(), 0.0);
     * rank | relevance | 2^(relevance) - 1 | log_2(rank + 1) | (2^(relevance) - 1) / log_2(rank + 1)
        List<RatedDocument> ratedDocs = new ArrayList<>();
        dcg = new DiscountedCumulativeGain(true, null, 10);
        DiscountedCumulativeGain.Detail detail = new DiscountedCumulativeGain.Detail(dcg, idcg, unratedDocs);
                    + ",\"unrated_docs\":"
        dcg = new DiscountedCumulativeGain(true, null, 10);
import static org.opensearch.test.XContentTestUtils.insertRandomFields;
        for (int i = 0; i < 6; i++) {
    public void testEqualsAndHash() throws IOException {
 * GitHub history for details.
    private void assertParsedCorrect(String xContent, Integer expectedUnknownDocRating, boolean expectedNormalize, int expectedK)
     * <p>
import org.opensearch.search.SearchHit;
        }
 * KIND, either express or implied.  See the License for the
                    randomValueOtherThan(original.getUnknownDocRating(), () -> randomIntBetween(0, 10)),
          4 | 2 | 3.0 | 2.321928094887362 | 1.2920296742201793
                XContentParseException.class,
     * -------------------------------------------------------------------------------------------
    }
import org.opensearch.core.xcontent.XContentParser;
    }
            DiscountedCumulativeGain dcgAt = DiscountedCumulativeGain.fromXContent(parser);
        int[] relevanceRatings = new int[] { 3, 2, 3, 0, 1, 2 };
            assertEquals(expectedNormalize, dcgAt.getNormalize());
          6 | n.a | n.a | n.a  | n.a
                    + idcg
            hits[i].shard(new SearchShardTarget("testnode", new ShardId("index", "uuid", 0), null, OriginalIndices.NONE));
    static final double EXPECTED_IDCG = 14.595390756454922;
                    original.getK()
        assertParsedCorrect("{ \"normalize\": true }", null, true, 10);
     * <p>
            default:
            hits[i].shard(new SearchShardTarget("testnode", new ShardId("index", "uuid", 0), null, OriginalIndices.NONE));
            assertNotSame(testItem, parsedItem);
        Integer[] relevanceRatings = new Integer[] { 3, 2, 3, null, 1, null };
                    + unratedDocs
    }
 * not use this file except in compliance with the License.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
     * rank | relevance | 2^(relevance) - 1 | log_2(rank + 1) | (2^(relevance) - 1) / log_2(rank + 1)
          rank | relevance | 2^(relevance) - 1 | log_2(rank + 1) | (2^(relevance) - 1) / log_2(rank + 1)
    }
        DiscountedCumulativeGain dcg = new DiscountedCumulativeGain();
        }
                throw new IllegalArgumentException("mutation variant not allowed");
        }
        double dcg = randomDoubleBetween(0, 1, true);
import java.io.IOException;
        assertEquals(expectedNdcg, detail.getNDCG(), 0.0);
        DiscountedCumulativeGain dcg = new DiscountedCumulativeGain();
            assertEquals(
 */
        EvalQueryQuality result = dcg.evaluate("id", hits, ratedDocs);
 */
          ----------------------------------------------------------------------------------------
 * under the License.
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
                    ratedDocs.add(new RatedDocument("index", Integer.toString(i), relevanceRatings[i]));
                () -> DiscountedCumulativeGain.fromXContent(parser)
        /*
        try (XContentParser parser = createParser(xContentType.xContent(), withRandomFields)) {
        assertNotSame(deserialized, original);
                return new DiscountedCumulativeGain(
                if (relevanceRatings[i] != null) {
        double expectedNdcg = idcg != 0 ? dcg / idcg : 0.0;
          4 | 1 | 1.0 | 2.321928094887362   | 0.43067655807339
        assertEquals(12.779642067948913 / 13.347184833073591, dcg.evaluate("id", hits, rated).metricScore(), DELTA);
            hits[i] = new SearchHit(i, Integer.toString(i), Collections.emptyMap(), Collections.emptyMap());
            if (i < relevanceRatings.length) {
        assertParsedCorrect("{ \"normalize\": false, \"k\" : 15 }", null, false, 15);
        dcg = new DiscountedCumulativeGain(true, null, 10);
            assertThat(exception.getMessage(), containsString("[dcg] unknown field"));
        BytesReference originalBytes = toShuffledXContent(testItem, xContentType, ToXContent.EMPTY_PARAMS, randomBoolean());
          2 | 3 | 7.0 | 1.5849625007211563 | 4.416508275000202
        SearchHit[] hits = new SearchHit[0];
 * ownership. Elasticsearch licenses this file to you under
          relevance in descending order
                    + ",\"normalized_dcg\":"
    /**
        assertEquals(2, filterUnratedDocuments(result.getHitsAndRatings()).size());
            hits[i] = new SearchHit(i, Integer.toString(i), Collections.emptyMap(), Collections.emptyMap());
        for (int i = 0; i < 6; i++) {
    }
                    rated.add(new RatedDocument("index", Integer.toString(i), relevanceRatings[i]));
    }
    public static DiscountedCumulativeGain createTestItem() {
    /**
                Strings.toString(MediaTypeRegistry.JSON, detail)
     * 6 | 2 | 3.0 | 2.807354922057604 | 1.0686215613240666
                return new DiscountedCumulativeGain(!original.getNormalize(), original.getUnknownDocRating(), original.getK());
    public void testNoResults() throws Exception {
     * This tests that normalization works as expected when there are more rated
                );
                    original.getNormalize(),
        // only create four hits
     * dcg = 13.84826362927298 (sum of last column)
          5 | n.a | n.a | n.a.  | n.a.
        SearchHit[] hits = new SearchHit[4];
          idcg = 13.347184833073591 (sum of last column)
     * -------------------------------------------------------------------------------------------
 * license agreements. See the NOTICE file distributed with
        assertEquals(1, filterUnratedDocuments(result.getHitsAndRatings()).size());
import org.opensearch.core.xcontent.XContentBuilder;
     * 5 | 1 | 1.0 | 2.584962500721156 | 0.38685280723454163
            itemParser.nextToken();
        List<RatedDocument> rated = new ArrayList<>();
        switch (randomIntBetween(0, 2)) {
        }
        Integer[] relevanceRatings = new Integer[] { 3, 2, 3, null, 1, null };
        assertParsedCorrect("{ \"unknown_doc_rating\": 2 }", 2, false, 10);
 *    http://www.apache.org/licenses/LICENSE-2.0
                }
    public void testXContentParsingIsNotLenient() throws IOException {
        SearchHit[] hits = new SearchHit[6];
        } else {
        assertEquals(EXPECTED_NDCG, dcg.evaluate("id", hits, rated).metricScore(), DELTA);
            );
import org.opensearch.common.xcontent.json.JsonXContent;
    }
     * dcg = 12.779642067948913 (sum of last column)
import java.util.Collections;
        assertParsedCorrect("{ \"unknown_doc_rating\": 2, \"normalize\": true, \"k\" : 15 }", 2, true, 15);
        assertEquals(EXPECTED_DCG, dcg.evaluate("id", hits, rated).metricScore(), DELTA);
        return new DiscountedCumulativeGain(normalize, unknownDocRating, randomIntBetween(1, 10));
        for (int i = 0; i < 6; i++) {
                }
     * fourth position
     * <p>
    }
          ---------------------------------------------------------------------------------------
          rank | relevance | 2^(relevance) - 1 | log_2(rank + 1) | (2^(relevance) - 1) / log_2(rank + 1)
                );
    }
        assertParsedCorrect("{ \"unknown_doc_rating\": 2, \"normalize\": true }", 2, true, 10);
    public void testXContentRoundtrip() throws IOException {
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, xContent)) {
     * documents than search hits because we restrict DCG to be calculated at the
     */
     * 5 | 1 | 1.0 | 2.584962500721156 | 0.38685280723454163
    public void testDCGAtFourMoreRatings() {
            return new DiscountedCumulativeGain(original.getNormalize(), original.getUnknownDocRating(), original.getK());
          5 | 1 | 1.0 | 2.584962500721156  | 0.38685280723454163
          3 | 2 | 3.0 | 2.0  | 1.5
            XContentParseException exception = expectThrows(
    /**
     * 2 | 3.0 | 1.5849625007211563 | 1.8927892607143721
 *
        assertEquals(deserialized.hashCode(), original.hashCode());
        if (idcg != 0) {
 * software distributed under the License is distributed on an
                if (relevanceRatings[i] != null) {
          Check with normalization: to get the maximal possible dcg, sort documents by
import org.opensearch.common.xcontent.XContentType;
    public void testParseFromXContent() throws IOException {
        Integer unknownDocRating = frequently() ? Integer.valueOf(randomIntBetween(0, 1000)) : null;
          3 | 2 | 3.0 | 2.0  | 1.5
        double idcg = randomBoolean() ? 0.0 : randomDoubleBetween(0, 1, true);
        dcg = new DiscountedCumulativeGain(true, null, 10);
        throws IOException {
            assertEquals(expectedUnknownDocRating, dcgAt.getUnknownDocRating());
     */
        checkEqualsAndHashCode(createTestItem(), original -> {
            assertEquals(testItem, parsedItem);
     * dcg = 12.392789260714371 (sum of last column until position 4)
import org.opensearch.core.xcontent.MediaTypeRegistry;
 * Licensed to Elasticsearch under one or more contributor
        assertEquals(0, filterUnratedDocuments(result.getHitsAndRatings()).size());
import org.opensearch.core.common.Strings;
          idcg = 14.595390756454922 (sum of last column)
            DiscountedCumulativeGain::new
            assertEquals(expectedK, dcgAt.getK());
            rated.add(new RatedDocument("index", Integer.toString(i), relevanceRatings[i]));
                return new DiscountedCumulativeGain(
                    original.getUnknownDocRating(),
        assertEquals(12.779642067948913, result.metricScore(), DELTA);
    }
    public void testSerialization() throws IOException {
}
          1 | 3 | 7.0 | 1.0  | 7.0
        assertEquals(0.0d, result.metricScore(), DELTA);
    static final double EXPECTED_NDCG = EXPECTED_DCG / EXPECTED_IDCG;
        // also check normalized
                if (relevanceRatings[i] != null) {
        /*
        for (int i = 0; i < 4; i++) {
        SearchHit[] hits = new SearchHit[6];
                "{\"dcg\":{\"dcg\":"
            DiscountedCumulativeGain parsedItem = DiscountedCumulativeGain.fromXContent(itemParser);
 * You may obtain a copy of the License at
        assertParsedCorrect("{ \"unknown_doc_rating\": 2, \"k\" : 15 }", 2, false, 15);
        }, DiscountedCumulativeGainTests::mutateTestItem);
import java.util.ArrayList;
        DiscountedCumulativeGain dcg = new DiscountedCumulativeGain();
 * this work for additional information regarding copyright
     * 4 | n/a | n/a | n/a | n/a
     * This tests metric when some documents in the search result don't have a
            hits[i] = new SearchHit(i, Integer.toString(i), Collections.emptyMap(), Collections.emptyMap());
                    + dcg
        );
    }
 *
            assertEquals(
    }
 * the Apache License, Version 2.0 (the "License"); you may
        Integer[] relevanceRatings = new Integer[] { 3, 2, 3, null, 1 };
        for (int i = 0; i < 6; i++) {
          ---------------------------------------------------------------------------------------
            }
        }
            );
          relevance in descending order
import static org.opensearch.index.rankeval.EvaluationMetric.filterUnratedDocuments;
        }
            original,
        BytesReference withRandomFields = insertRandomFields(xContentType, originalBytes, null, random());
     * <p>
          idcg = 13.347184833073591 (sum of last column)
          3 | 2 | 3.0 | 2.0  | 1.5
        DiscountedCumulativeGain original = createTestItem();
            itemParser.nextToken();
          1 | 3 | 7.0 | 1.0  | 7.0
                    ratedDocs.add(new RatedDocument("index", Integer.toString(i), relevanceRatings[i]));
          2 | 3 | 7.0 | 1.5849625007211563 | 4.416508275000202
          1 | 3 | 7.0 | 1.0  | 7.0
     * 4 | 0 | 0.0 | 2.321928094887362 | 0.0
        XContentType xContentType = randomFrom(XContentType.values());
     * -------------------------------------------------------------------------------------------
        DiscountedCumulativeGain dcg = new DiscountedCumulativeGain();
        assertEquals(12.392789260714371, result.metricScore(), DELTA);
            case 0:
 * this file be licensed under the Apache-2.0 license or a
        EvalQueryQuality result = dcg.evaluate("id", hits, rated);
     * <p>
     * rank | relevance | 2^(relevance) - 1 | log_2(rank + 1) | (2^(relevance) - 1) / log_2(rank + 1)
        try (XContentParser itemParser = createParser(shuffled)) {
