    public void testProbabilityOfRelevance() {
     * <pre>{@code  
import org.opensearch.common.xcontent.XContentType;
 * Licensed to Elasticsearch under one or more contributor  
     * 2    | 2         | 0.1875    | 0.125    | 0.0234375   |
/*  
     * rank | relevance | probR / r | p        | p * probR / r
import org.opensearch.core.xcontent.XContentBuilder;  
 * Modifications Copyright OpenSearch Contributors. See
        XContentBuilder builder = MediaTypeRegistry.contentBuilder(randomFrom(XContentType.values()));  
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
            hits[i].shard(new SearchShardTarget("testnode", new ShardId("index", "uuid", 0), null, OriginalIndices.NONE));
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.common.xcontent.json.JsonXContent;  
import static org.opensearch.test.EqualsHashCodeTestUtils.checkEqualsAndHashCode;  
import org.opensearch.search.SearchShardTarget;
    public void testSerialization() throws IOException {
 * this file be licensed under the Apache-2.0 license or a
        // take 4th rank into window
        return new ExpectedReciprocalRank(maxRelevance, unknownDocRating, randomIntBetween(1, 10));
 */  
                rated.add(new RatedDocument("index", Integer.toString(i), relevanceRatings[i]));
        assertParsedCorrect("{ \"unknown_doc_rating\": 2, \"maximum_relevance\": 5, \"k\" : 15 }", 2, 5, 15);
        );
        assertParsedCorrect("{ \"maximum_relevance\": 4, \"k\": 23 }", null, 4, 23);  
        assertEquals(15d / 32d, err.probabilityOfRelevance(4), 0.0);
            );
        assertEquals(deserialized, original);
 * the Apache License, Version 2.0 (the "License"); you may
        SearchHit[] hits = createSearchHits(rated, relevanceRatings);  
            default:
        }  
     * }</pre>
public class ExpectedReciprocalRankTests extends OpenSearchTestCase {
    /**
     */
        assertEquals(0.875 + 0.00390625, evaluation.metricScore(), DELTA);  
            case 1:
     *  
     * 1    | 3         | 0.875     | 1        | 0.875       |
                XContentParseException.class,  
 * software distributed under the License is distributed on an
     * Assuming the result ranking is
 *  
            return new ExpectedReciprocalRank(original.getMaxRelevance(), original.getUnknownDocRating(), original.getK());  
    /**  
            case 2:
    public void testERRAt() {
import org.opensearch.action.OriginalIndices;
    }
    public static ExpectedReciprocalRank createTestItem() {
/*
 * ownership. Elasticsearch licenses this file to you under  
        Integer[] relevanceRatings = new Integer[] { 3, null, 0, 1 };
        ExpectedReciprocalRank err = new ExpectedReciprocalRank(5);  
    }
     * err = sum of last column
    public void testMetricDetails() {
        }  
        ExpectedReciprocalRank err = new ExpectedReciprocalRank(5, 0, 10);
                    original.getK()  
        for (int i = 0; i < relevanceRatings.length; i++) {  
     * 1    | 3         | 0.875     | 1        | 0.875       |  
    }
        err = new ExpectedReciprocalRank(3, 2, 4);  
        throws IOException {
import static org.opensearch.test.XContentTestUtils.insertRandomFields;
            itemParser.nextToken();  
            assertThat(exception.getMessage(), containsString("[dcg] unknown field"));  
        ExpectedReciprocalRank err = new ExpectedReciprocalRank(3, 0, 3);  
import org.opensearch.core.xcontent.XContentParser;
    }
 * license agreements. See the NOTICE file distributed with
import org.opensearch.core.xcontent.XContentParseException;
     * 3    | 0         | 0         | 0.125    | 0           |  
                () -> DiscountedCumulativeGain.fromXContent(parser)
        assertParsedCorrect("{ \"unknown_doc_rating\": 2, \"maximum_relevance\": 4 }", 2, 4, 10);
    }
    public void testERRMissingRatings() {  
     * -------------------------------------------------------
        BytesReference originalBytes = toShuffledXContent(testItem, xContentType, ToXContent.EMPTY_PARAMS, randomBoolean());  
            assertEquals(expectedMaxRelevance, errAt.getMaxRelevance());  
 * specific language governing permissions and limitations
        EvalQueryQuality evaluation = err.evaluate("id", hits, rated);
import java.util.List;
    public void testEqualsAndHash() throws IOException {
     *  
                    randomValueOtherThan(original.getK(), () -> randomIntBetween(1, 10))  
                );
                return new ExpectedReciprocalRank(  
import org.opensearch.core.xcontent.MediaTypeRegistry;
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, xContent)) {
     * 4    | 1         | 0.03125   | 0.078125 | 0.00244140625 |  
     * Assuming the result ranking is
                );
/*  
        Integer unknownDocRating = frequently() ? Integer.valueOf(randomIntBetween(0, 10)) : null;
        assertEquals(7d / 32d, err.probabilityOfRelevance(3), 0.0);
            case 0:  
import org.opensearch.core.index.shard.ShardId;  
    }
        XContentBuilder shuffled = shuffleXContent(testItem.toXContent(builder, ToXContent.EMPTY_PARAMS));
     * 3    | 0         | 0         | 0.078125 | 0           |
        try (XContentParser parser = createParser(xContentType.xContent(), withRandomFields)) {
 * You may obtain a copy of the License at  
            assertEquals(testItem, parsedItem);
    private SearchHit[] createSearchHits(List<RatedDocument> rated, Integer[] relevanceRatings) {
        BytesReference withRandomFields = insertRandomFields(xContentType, originalBytes, null, random());
 *
 * GitHub history for details.
        ExpectedReciprocalRank deserialized = OpenSearchTestCase.copyWriteable(  
            original,
}  
    }
            new NamedWriteableRegistry(Collections.emptyList()),
        }, ExpectedReciprocalRankTests::mutateTestItem);
        assertEquals(1d / 32d, err.probabilityOfRelevance(1), 0.0);
     * test that metric returns 0.0 when there are no search results
        assertEquals(1, ((ExpectedReciprocalRank.Detail) evaluation.getMetricDetails()).getUnratedDocs());
    private void assertParsedCorrect(String xContent, Integer expectedUnknownDocRating, int expectedMaxRelevance, int expectedK)  
        assertEquals(0.8984375 + 0.00244140625, err.evaluate("id", hits, rated).metricScore(), DELTA);
import java.io.IOException;
     */
     *
     * }</pre>
            ExpectedReciprocalRank parsedItem = ExpectedReciprocalRank.fromXContent(itemParser);
     * -------------------------------------------------------  
 */
        List<RatedDocument> rated = new ArrayList<>();
                    randomValueOtherThan(original.getUnknownDocRating(), () -> randomIntBetween(0, 10)),
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *    http://www.apache.org/licenses/LICENSE-2.0
import static org.hamcrest.CoreMatchers.containsString;
    }
        ExpectedReciprocalRank testItem = createTestItem();
        assertEquals(3d / 32d, err.probabilityOfRelevance(2), 0.0);  
        assertEquals(0.0, err.evaluate("id", new SearchHit[0], Collections.emptyList()).metricScore(), DELTA);  
        return hits;
            assertEquals(testItem.hashCode(), parsedItem.hashCode());
    public void testParseFromXContent() throws IOException {  
        }
        }
 * compatible open source license.
 *
        checkEqualsAndHashCode(createTestItem(), original -> {
        List<RatedDocument> rated = new ArrayList<>();  
            assertEquals(expectedK, errAt.getK());
 */  
import org.opensearch.search.SearchHit;  
    public void testNoResults() throws Exception {
 * Unless required by applicable law or agreed to in writing,
    private static ExpectedReciprocalRank mutateTestItem(ExpectedReciprocalRank original) {
            if (relevanceRatings[i] != null) {
     * 4    | 1         | 0.03125   | 0.125    | 0.00390625 |
 * The OpenSearch Contributors require contributions made to  
        err = new ExpectedReciprocalRank(3, 0, 4);  
        int maxRelevance = randomIntBetween(1, 10);  
import java.util.ArrayList;
        }
    private static final double DELTA = 10E-14;  
    public void testXContentParsingIsNotLenient() throws IOException {  
        ExpectedReciprocalRank original = createTestItem();
import org.opensearch.core.xcontent.ToXContent;
        assertEquals(31d / 32d, err.probabilityOfRelevance(5), 0.0);  
                return new ExpectedReciprocalRank(  
            assertNotSame(testItem, parsedItem);  
        // if we supply e.g. 2 as unknown docs rating, it should be the same as in the other test above
        Integer[] relevanceRatings = new Integer[] { 3, 2, 0, 1 };
        assertEquals(unratedDocs, detail.getUnratedDocs());
        switch (randomIntBetween(0, 2)) {
import org.opensearch.core.common.bytes.BytesReference;
        try (XContentParser itemParser = createParser(shuffled)) {
        ExpectedReciprocalRank.Detail detail = new ExpectedReciprocalRank.Detail(unratedDocs);  
            ExpectedReciprocalRank::new  
        assertEquals(0.8984375, err.evaluate("id", hits, rated).metricScore(), DELTA);
        assertEquals(deserialized.hashCode(), original.hashCode());  
    }
            assertEquals(expectedUnknownDocRating, errAt.getUnknownDocRating());
            ExpectedReciprocalRank errAt = ExpectedReciprocalRank.fromXContent(parser);  
    }
            parser.nextToken();
            XContentParseException exception = expectThrows(
 * this work for additional information regarding copyright
package org.opensearch.index.rankeval;
    /**
     * 2    | n/a       | n/a       | 0.125    | n/a   |
                    original.getMaxRelevance(),
        int unratedDocs = randomIntBetween(0, 100);
     *
    }
        assertEquals(0.0, err.probabilityOfRelevance(0), 0.0);
            parser.nextToken();  
 * KIND, either express or implied.  See the License for the
import org.opensearch.test.OpenSearchTestCase;
     * err = sum of last column  
                throw new IllegalArgumentException("mutation variant not allowed");  
    }
     */  
            }  
                    original.getMaxRelevance(),
        SearchHit[] hits = createSearchHits(rated, relevanceRatings);
import java.util.Collections;  
    }
        ExpectedReciprocalRank err = new ExpectedReciprocalRank(3, null, 4);
    }
 * under the License.  
    public void testXContentRoundtrip() throws IOException {
     * rank | relevance | probR / r | p        | p * probR / r
            itemParser.nextToken();
        SearchHit[] hits = new SearchHit[relevanceRatings.length];
 * not use this file except in compliance with the License.
                    original.getUnknownDocRating(),
        XContentType xContentType = randomFrom(XContentType.values());
            hits[i] = new SearchHit(i, Integer.toString(i), Collections.emptyMap(), Collections.emptyMap());
        assertNotSame(deserialized, original);
        assertEquals(0.8984375 + 0.00244140625, err.evaluate("id", hits, rated).metricScore(), DELTA);
        ExpectedReciprocalRank testItem = createTestItem();
     * <pre>{@code
                return new ExpectedReciprocalRank(original.getMaxRelevance() + 1, original.getUnknownDocRating(), original.getK());
