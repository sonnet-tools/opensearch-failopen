         */  
    public void testDCGAt() {  
            );
    public void testDCGAtSixMissingRatings() {
        }
    }  
            case 2:  
        assertEquals(2, filterUnratedDocuments(result.getHitsAndRatings()).size());
 * this file be licensed under the Apache-2.0 license or a
            assertNotSame(testItem, parsedItem);  
import org.opensearch.core.common.Strings;
                    ratedDocs.add(new RatedDocument("index", Integer.toString(i), relevanceRatings[i]));  
    }  
     * This tests metric when some documents in the search result don't have a
    }
            assertEquals(testItem, parsedItem);
/*  
        List<RatedDocument> ratedDocs = new ArrayList<>();
        // also check normalized
        assertParsedCorrect("{ \"unknown_doc_rating\": 2, \"k\" : 15 }", 2, false, 15);
        double dcg = randomDoubleBetween(0, 1, true);
 * KIND, either express or implied.  See the License for the
        double idcg = randomBoolean() ? 0.0 : randomDoubleBetween(0, 1, true);  
            assertEquals(
    static final double EXPECTED_DCG = 13.84826362927298;
        }
     */  
        for (int i = 0; i < 6; i++) {
            }
     * 5 | 1 | 1.0 | 2.584962500721156 | 0.38685280723454163
        DiscountedCumulativeGain deserialized = OpenSearchTestCase.copyWriteable(
import org.opensearch.search.SearchShardTarget;
          6 | n.a | n.a | n.a  | n.a
                );
        try (XContentParser itemParser = createParser(shuffled)) {
import static org.hamcrest.CoreMatchers.containsString;
        // only create four hits
                throw new IllegalArgumentException("mutation variant not allowed");
     * 3 | 3 | 7.0 | 2.0 | 3.5
        assertEquals(EXPECTED_NDCG, dcg.evaluate("id", hits, rated).metricScore(), DELTA);
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;  
import org.opensearch.core.index.shard.ShardId;
          1 | 3 | 7.0 | 1.0  | 7.0
     * dcg = 13.84826362927298 (sum of last column)
    public void testMetricDetails() {
                if (relevanceRatings[i] != null) {
 * Modifications Copyright OpenSearch Contributors. See
            DiscountedCumulativeGain dcgAt = DiscountedCumulativeGain.fromXContent(parser);  
                () -> DiscountedCumulativeGain.fromXContent(parser)
                if (relevanceRatings[i] != null) {  
        dcg = new DiscountedCumulativeGain(true, null, 10);
            rated.add(new RatedDocument("index", Integer.toString(i), relevanceRatings[i]));
import org.opensearch.core.common.bytes.BytesReference;
            assertEquals(testItem.hashCode(), parsedItem.hashCode());
        assertParsedCorrect("{ \"normalize\": true }", null, true, 10);
        for (int i = 0; i < 6; i++) {
          3 | 2 | 3.0 | 2.0  | 1.5  
        SearchHit[] hits = new SearchHit[6];  
    }
import static org.opensearch.test.XContentTestUtils.insertRandomFields;  
    }
          rank | relevance | 2^(relevance) - 1 | log_2(rank + 1) | (2^(relevance) - 1) / log_2(rank + 1)
    }
    /**
 * The OpenSearch Contributors require contributions made to  
        Integer[] relevanceRatings = new Integer[] { 3, 2, 3, null, 1, null };
    public void testEqualsAndHash() throws IOException {
import static org.opensearch.index.rankeval.EvaluationMetric.filterUnratedDocuments;
            assertEquals(  
          2 | 3 | 7.0 | 1.5849625007211563 | 4.416508275000202
          relevance in descending order
                    + idcg
    public void testParseFromXContent() throws IOException {
        assertEquals(deserialized, original);  
     * rank | relevance | 2^(relevance) - 1 | log_2(rank + 1) | (2^(relevance) - 1) / log_2(rank + 1)
        assertEquals(idcg, detail.getIDCG(), 0.0);
            hits[i].shard(new SearchShardTarget("testnode", new ShardId("index", "uuid", 0), null, OriginalIndices.NONE));  
            hits[i] = new SearchHit(i, Integer.toString(i), Collections.emptyMap(), Collections.emptyMap());
 * Licensed to Elasticsearch under one or more contributor  
    }  
            itemParser.nextToken();  
          Check with normalization: to get the maximal possible dcg, sort documents by
        BytesReference originalBytes = toShuffledXContent(testItem, xContentType, ToXContent.EMPTY_PARAMS, randomBoolean());  
         */
     * 1 | 3 | 7.0 | 1.0 | 7.0 | 7.0 |  
        assertEquals(expectedNdcg, detail.getNDCG(), 0.0);  
            }
import java.util.List;
        DiscountedCumulativeGain dcg = new DiscountedCumulativeGain();  
          rank | relevance | 2^(relevance) - 1 | log_2(rank + 1) | (2^(relevance) - 1) / log_2(rank + 1)
                    + unratedDocs
          6 | n.a | n.a | n.a  | n.a  
        DiscountedCumulativeGain.Detail detail = new DiscountedCumulativeGain.Detail(dcg, idcg, unratedDocs);  
        XContentBuilder shuffled = shuffleXContent(testItem.toXContent(builder, ToXContent.EMPTY_PARAMS));
        assertEquals(12.392789260714371, result.metricScore(), DELTA);
    static final double EXPECTED_NDCG = EXPECTED_DCG / EXPECTED_IDCG;
     * 2 | 2 | 3.0 | 1.5849625007211563 | 1.8927892607143721
                    + ",\"normalized_dcg\":"
                }
import static org.opensearch.test.EqualsHashCodeTestUtils.checkEqualsAndHashCode;
        }
        DiscountedCumulativeGain original = createTestItem();  
          idcg = 14.595390756454922 (sum of last column)
            if (i < relevanceRatings.length) {
                }
        EvalQueryQuality result = dcg.evaluate("id", hits, rated);  
        }
        }
                    + expectedNdcg  
        assertParsedCorrect("{ \"normalize\": false, \"k\" : 15 }", null, false, 15);
                return new DiscountedCumulativeGain(
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.common.xcontent.XContentType;
        }, DiscountedCumulativeGainTests::mutateTestItem);
    }  
        assertEquals(dcg, detail.getDCG(), 0.0);
                    + ",\"unrated_docs\":"
     * 5 | 1 | 1.0 | 2.584962500721156 | 0.38685280723454163
     * test that metric returns 0.0 when there are no search results
     * 1 | 3 | 7.0 | 1.0 | 7.0 2 | 
        SearchHit[] hits = new SearchHit[4];  
 * license agreements. See the NOTICE file distributed with
    public void testXContentRoundtrip() throws IOException {
 *    http://www.apache.org/licenses/LICENSE-2.0
                Strings.toString(MediaTypeRegistry.JSON, detail)
        assertEquals(deserialized.hashCode(), original.hashCode());
     * dcg = 12.392789260714371 (sum of last column until position 4)
import org.opensearch.core.xcontent.XContentBuilder;
    private void assertParsedCorrect(String xContent, Integer expectedUnknownDocRating, boolean expectedNormalize, int expectedK)  
        assertNotSame(deserialized, original);
            assertEquals(expectedUnknownDocRating, dcgAt.getUnknownDocRating());
     * 2 | 3.0 | 1.5849625007211563 | 1.8927892607143721
            return new DiscountedCumulativeGain(original.getNormalize(), original.getUnknownDocRating(), original.getK());
    }  
     * 4 | n/a | n/a | n/a | n/a  
          rank | relevance | 2^(relevance) - 1 | log_2(rank + 1) | (2^(relevance) - 1) / log_2(rank + 1)
        result = dcg.evaluate("id", hits, ratedDocs);  
            );
        EvalQueryQuality result = dcg.evaluate("id", hits, ratedDocs);  
            assertEquals(expectedNormalize, dcgAt.getNormalize());
        checkEqualsAndHashCode(createTestItem(), original -> {  
     * <p>  
 *
                    ratedDocs.add(new RatedDocument("index", Integer.toString(i), relevanceRatings[i]));
        if (idcg != 0) {
                    rated.add(new RatedDocument("index", Integer.toString(i), relevanceRatings[i]));
 * specific language governing permissions and limitations
     * rank | relevance | 2^(relevance) - 1 | log_2(rank + 1) | (2^(relevance) - 1) / log_2(rank + 1)
 * Unless required by applicable law or agreed to in writing,
/*
     * 6 | n/a | n/a | n/a | n/a  
            XContentParseException exception = expectThrows(
import org.opensearch.test.OpenSearchTestCase;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
     * 2 | 3.0 | 1.5849625007211563 | 1.8927892607143721
     * Assuming the docs are ranked in the following order:
         */
    public void testSerialization() throws IOException {
    /**  
          Check with normalization: to get the maximal possible dcg, sort documents by
        try (XContentParser parser = createParser(xContentType.xContent(), withRandomFields)) {
package org.opensearch.index.rankeval;
 */  
 * SPDX-License-Identifier: Apache-2.0
            hits[i] = new SearchHit(i, Integer.toString(i), Collections.emptyMap(), Collections.emptyMap());
     * 4 | n/a | n/a | n/a | n/a
        assertEquals(12.392789260714371 / 13.347184833073591, dcg.evaluate("id", hits, ratedDocs).metricScore(), DELTA);  
                    randomValueOtherThan(original.getK(), () -> randomIntBetween(1, 10))
                    randomValueOtherThan(original.getUnknownDocRating(), () -> randomIntBetween(0, 10)),  
            assertEquals(expectedK, dcgAt.getK());  
                }  
          idcg = 13.347184833073591 (sum of last column)
        boolean normalize = randomBoolean();
        SearchHit[] hits = new SearchHit[0];
                if (relevanceRatings[i] != null) {
 */  
        }  
          ---------------------------------------------------------------------------------------  
import org.opensearch.core.xcontent.ToXContent;  
                    original.getUnknownDocRating(),  
                    original.getNormalize(),
public class DiscountedCumulativeGainTests extends OpenSearchTestCase {  
     * -------------------------------------------------------------------------------------------
    static final double EXPECTED_IDCG = 14.595390756454922;  
        return new DiscountedCumulativeGain(normalize, unknownDocRating, randomIntBetween(1, 10));
                    + ",\"ideal_dcg\":"  
        assertEquals(12.779642067948913, result.metricScore(), DELTA);
     * 3 | 3 | 7.0 | 2.0 | 3.5
                return new DiscountedCumulativeGain(!original.getNormalize(), original.getUnknownDocRating(), original.getK());
          4 | 2 | 3.0 | 2.321928094887362 | 1.2920296742201793  
     * 6 | n/a | n/a | n/a | n/a  
                    + "}}",  
        List<RatedDocument> rated = new ArrayList<>();
        assertParsedCorrect("{ \"k\": 23 }", null, false, 23);
import java.util.Collections;
import java.util.ArrayList;  
            hits[i].shard(new SearchShardTarget("testnode", new ShardId("index", "uuid", 0), null, OriginalIndices.NONE));
    public void testNoResults() throws Exception {  
            if (i < relevanceRatings.length) {  
            if (i < relevanceRatings.length) {
        double expectedNdcg = idcg != 0 ? dcg / idcg : 0.0;
          4 | 1 | 1.0 | 2.321928094887362   | 0.43067655807339
          ---------------------------------------------------------------------------------------
            parser.nextToken();
    private static DiscountedCumulativeGain mutateTestItem(DiscountedCumulativeGain original) {
            }  
          5 | n.a | n.a | n.a.  | n.a.
        XContentType xContentType = randomFrom(XContentType.values());
        assertParsedCorrect("{ \"unknown_doc_rating\": 2 }", 2, false, 10);  
        dcg = new DiscountedCumulativeGain(true, null, 10);
     * rating provided by the user.  
    public void testDCGAtFourMoreRatings() {
     * This tests that normalization works as expected when there are more rated  
          relevance in descending order  
import org.opensearch.search.SearchHit;
import org.opensearch.common.xcontent.json.JsonXContent;  
            DiscountedCumulativeGain parsedItem = DiscountedCumulativeGain.fromXContent(itemParser);
        switch (randomIntBetween(0, 2)) {  
        List<RatedDocument> rated = new ArrayList<>();
        assertEquals(EXPECTED_DCG, dcg.evaluate("id", hits, rated).metricScore(), DELTA);
     * 3 | 3 | 7.0 | 2.0 | 3.5  
    public static DiscountedCumulativeGain createTestItem() {
          1 | 3 | 7.0 | 1.0  | 7.0
                    original.getK()
 * software distributed under the License is distributed on an
import org.opensearch.core.xcontent.XContentParser;  
        DiscountedCumulativeGain dcg = new DiscountedCumulativeGain();
            hits[i].shard(new SearchShardTarget("testnode", new ShardId("index", "uuid", 0), null, OriginalIndices.NONE));  
          ----------------------------------------------------------------------------------------  
          2 | 3 | 7.0 | 1.5849625007211563 | 4.416508275000202
        BytesReference withRandomFields = insertRandomFields(xContentType, originalBytes, null, random());
        for (int i = 0; i < 6; i++) {
        for (int i = 0; i < 4; i++) {
     */
            itemParser.nextToken();
 * GitHub history for details.
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, xContent)) {
     * -------------------------------------------------------------------------------------------  
        }
        Integer[] relevanceRatings = new Integer[] { 3, 2, 3, null, 1, null };
                    + dcg
        dcg = new DiscountedCumulativeGain(true, null, 10);
          4 | 1 | 1.0 | 2.321928094887362   | 0.43067655807339
            original,
            default:  
     */
        /*
        assertEquals(1, filterUnratedDocuments(result.getHitsAndRatings()).size());
    public void testXContentParsingIsNotLenient() throws IOException {  
        assertEquals(0, filterUnratedDocuments(result.getHitsAndRatings()).size());
     * <p>
 * this work for additional information regarding copyright
            case 1:  
    /**
        assertEquals(unratedDocs, detail.getUnratedDocs());
        DiscountedCumulativeGain dcg = new DiscountedCumulativeGain();
     * <p>
        int unratedDocs = randomIntBetween(0, 100);
          idcg = 13.347184833073591 (sum of last column)  
          Check with normalization: to get the maximal possible dcg, sort documents by
/*  
            DiscountedCumulativeGain::new
     * <p>
          3 | 2 | 3.0 | 2.0  | 1.5  
 *
     * <p>  
          5 | n.a | n.a | n.a.  | n.a.  
 * You may obtain a copy of the License at  
        }
    }  
        DiscountedCumulativeGain testItem = createTestItem();
     * 6 | 2 | 3.0 | 2.807354922057604 | 1.0686215613240666
        assertEquals(0.0d, result.metricScore(), DELTA);
                "{\"dcg\":{\"dcg\":"
 * not use this file except in compliance with the License.
        } else {  
        }
        DiscountedCumulativeGain dcg = new DiscountedCumulativeGain();
}
     */  
        SearchHit[] hits = new SearchHit[6];
        );
        /*  
        XContentBuilder builder = MediaTypeRegistry.contentBuilder(randomFrom(XContentType.values()));  
    /**
        assertParsedCorrect("{ \"unknown_doc_rating\": 2, \"normalize\": true, \"k\" : 15 }", 2, true, 15);  
import org.opensearch.action.OriginalIndices;
     * 1 | 3 | 7.0 | 1.0 | 7.0 2 |  
    }
          1 | 3 | 7.0 | 1.0  | 7.0  
     * fourth position
          5 | 1 | 1.0 | 2.584962500721156  | 0.38685280723454163
        for (int i = 0; i < 6; i++) {  
import java.io.IOException;
          ---------------------------------------------------------------------------------------
     * rank | relevance | 2^(relevance) - 1 | log_2(rank + 1) | (2^(relevance) - 1) / log_2(rank + 1)
import org.opensearch.core.xcontent.MediaTypeRegistry;
        assertEquals(0.0d, result.metricScore(), DELTA);
            assertThat(exception.getMessage(), containsString("[dcg] unknown field"));  
     * 4 | 0 | 0.0 | 2.321928094887362 | 0.0  
 * the Apache License, Version 2.0 (the "License"); you may
                "{\"dcg\":{\"dcg\":" + dcg + ",\"unrated_docs\":" + unratedDocs + "}}",
        assertEquals(0, filterUnratedDocuments(result.getHitsAndRatings()).size());
        /*
        Integer unknownDocRating = frequently() ? Integer.valueOf(randomIntBetween(0, 1000)) : null;  
 */
          2 | 3 | 7.0 | 1.5849625007211563 | 4.416508275000202
        EvalQueryQuality result = dcg.evaluate("id", hits, ratedDocs);  
    }
            hits[i] = new SearchHit(i, Integer.toString(i), Collections.emptyMap(), Collections.emptyMap());  
     * -------------------------------------------------------------------------------------------
     * <p>  
                Strings.toString(MediaTypeRegistry.JSON, detail)  
     * 5 | 1 | 1.0 | 2.584962500721156 | 0.38685280723454163
        List<RatedDocument> ratedDocs = new ArrayList<>();  
          relevance in descending order  
import org.opensearch.core.xcontent.XContentParseException;
            case 0:
        dcg = new DiscountedCumulativeGain(true, null, 10);  
 * compatible open source license.
            new NamedWriteableRegistry(Collections.emptyList()),  
        assertParsedCorrect("{ \"unknown_doc_rating\": 2, \"normalize\": true }", 2, true, 10);  
 * under the License.  
          6 | 0 | 0.0 | 2.807354922057604  | 0.0
            );
                XContentParseException.class,  
     * -----------------------------------------------------------------
        int[] relevanceRatings = new int[] { 3, 2, 3, 0, 1, 2 };
        assertEquals(12.779642067948913 / 13.347184833073591, dcg.evaluate("id", hits, rated).metricScore(), DELTA);
     * dcg = 12.779642067948913 (sum of last column)
        }  
        DiscountedCumulativeGain testItem = createTestItem();
     * documents than search hits because we restrict DCG to be calculated at the
    private static final double DELTA = 10E-14;
                );
                    original.getNormalize(),
                return new DiscountedCumulativeGain(
        throws IOException {
          3 | 2 | 3.0 | 2.0  | 1.5
        Integer[] relevanceRatings = new Integer[] { 3, 2, 3, null, 1 };  
 *  
            parser.nextToken();  
    }
