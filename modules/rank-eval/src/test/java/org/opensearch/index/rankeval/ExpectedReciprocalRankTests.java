import org.opensearch.core.index.shard.ShardId;
public class ExpectedReciprocalRankTests extends OpenSearchTestCase {
        assertNotSame(deserialized, original);
        ExpectedReciprocalRank err = new ExpectedReciprocalRank(5);
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
            ExpectedReciprocalRank errAt = ExpectedReciprocalRank.fromXContent(parser);
 */
        assertEquals(0.0, err.probabilityOfRelevance(0), 0.0);
            case 1:
     *
 * Unless required by applicable law or agreed to in writing,
    public void testXContentParsingIsNotLenient() throws IOException {
 *    http://www.apache.org/licenses/LICENSE-2.0
    }
            hits[i].shard(new SearchShardTarget("testnode", new ShardId("index", "uuid", 0), null, OriginalIndices.NONE));
     *
            default:
}
        assertEquals(0.875 + 0.00390625, evaluation.metricScore(), DELTA);
    }
        // if we supply e.g. 2 as unknown docs rating, it should be the same as in the other test above
        assertEquals(15d / 32d, err.probabilityOfRelevance(4), 0.0);
            ExpectedReciprocalRank::new
    /**
    private static final double DELTA = 10E-14;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    public void testEqualsAndHash() throws IOException {
 * compatible open source license.
    }
        assertEquals(7d / 32d, err.probabilityOfRelevance(3), 0.0);
        switch (randomIntBetween(0, 2)) {
    public void testParseFromXContent() throws IOException {
                    original.getK()
import org.opensearch.common.xcontent.XContentType;
    private void assertParsedCorrect(String xContent, Integer expectedUnknownDocRating, int expectedMaxRelevance, int expectedK)
    }
        SearchHit[] hits = createSearchHits(rated, relevanceRatings);
            case 0:
     * <pre>{@code
 * specific language governing permissions and limitations
                return new ExpectedReciprocalRank(original.getMaxRelevance() + 1, original.getUnknownDocRating(), original.getK());
        assertEquals(31d / 32d, err.probabilityOfRelevance(5), 0.0);
 * under the License.
        );
        }
    private static ExpectedReciprocalRank mutateTestItem(ExpectedReciprocalRank original) {
import java.util.Collections;
     * err = sum of last column
            new NamedWriteableRegistry(Collections.emptyList()),
        XContentBuilder builder = MediaTypeRegistry.contentBuilder(randomFrom(XContentType.values()));
        ExpectedReciprocalRank testItem = createTestItem();
        ExpectedReciprocalRank err = new ExpectedReciprocalRank(3, null, 4);
        assertEquals(deserialized.hashCode(), original.hashCode());
    }
     */
        XContentType xContentType = randomFrom(XContentType.values());
                return new ExpectedReciprocalRank(
            return new ExpectedReciprocalRank(original.getMaxRelevance(), original.getUnknownDocRating(), original.getK());
     * rank | relevance | probR / r | p        | p * probR / r
import static org.opensearch.test.EqualsHashCodeTestUtils.checkEqualsAndHashCode;
    }
    /**
            itemParser.nextToken();
import java.io.IOException;
    }
                    randomValueOtherThan(original.getK(), () -> randomIntBetween(1, 10))
        SearchHit[] hits = new SearchHit[relevanceRatings.length];
                );
 * Modifications Copyright OpenSearch Contributors. See
        // take 4th rank into window
import org.opensearch.core.xcontent.XContentParser;
        ExpectedReciprocalRank err = new ExpectedReciprocalRank(5, 0, 10);
        err = new ExpectedReciprocalRank(3, 2, 4);
 *
        assertParsedCorrect("{ \"unknown_doc_rating\": 2, \"maximum_relevance\": 4 }", 2, 4, 10);
    /**
/*
     * rank | relevance | probR / r | p        | p * probR / r
            if (relevanceRatings[i] != null) {
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, xContent)) {
     * err = sum of last column
     * 4    | 1         | 0.03125   | 0.078125 | 0.00244140625 |
        assertEquals(1, ((ExpectedReciprocalRank.Detail) evaluation.getMetricDetails()).getUnratedDocs());
        try (XContentParser parser = createParser(xContentType.xContent(), withRandomFields)) {
     * 1    | 3         | 0.875     | 1        | 0.875       |
     * }</pre>
     * Assuming the result ranking is
                    original.getMaxRelevance(),
        List<RatedDocument> rated = new ArrayList<>();
        SearchHit[] hits = createSearchHits(rated, relevanceRatings);
                    randomValueOtherThan(original.getUnknownDocRating(), () -> randomIntBetween(0, 10)),
        Integer unknownDocRating = frequently() ? Integer.valueOf(randomIntBetween(0, 10)) : null;
        }
    public static ExpectedReciprocalRank createTestItem() {
 * not use this file except in compliance with the License.
import org.opensearch.common.xcontent.json.JsonXContent;
            ExpectedReciprocalRank parsedItem = ExpectedReciprocalRank.fromXContent(itemParser);
            assertEquals(testItem, parsedItem);
        }
        ExpectedReciprocalRank.Detail detail = new ExpectedReciprocalRank.Detail(unratedDocs);
        }, ExpectedReciprocalRankTests::mutateTestItem);
                rated.add(new RatedDocument("index", Integer.toString(i), relevanceRatings[i]));
            );
        assertEquals(3d / 32d, err.probabilityOfRelevance(2), 0.0);
import org.opensearch.search.SearchShardTarget;
import org.opensearch.core.xcontent.ToXContent;
        assertEquals(0.8984375 + 0.00244140625, err.evaluate("id", hits, rated).metricScore(), DELTA);
 * this work for additional information regarding copyright
 * The OpenSearch Contributors require contributions made to
import java.util.ArrayList;
     * 2    | 2         | 0.1875    | 0.125    | 0.0234375   |
                throw new IllegalArgumentException("mutation variant not allowed");
        checkEqualsAndHashCode(createTestItem(), original -> {
        BytesReference withRandomFields = insertRandomFields(xContentType, originalBytes, null, random());
     * 3    | 0         | 0         | 0.125    | 0           |
        Integer[] relevanceRatings = new Integer[] { 3, null, 0, 1 };
import org.opensearch.core.xcontent.MediaTypeRegistry;
            assertEquals(testItem.hashCode(), parsedItem.hashCode());
    public void testERRMissingRatings() {
     * Assuming the result ranking is
import static org.hamcrest.CoreMatchers.containsString;
     * -------------------------------------------------------
     *
            assertNotSame(testItem, parsedItem);
     *
     * 3    | 0         | 0         | 0.078125 | 0           |
            case 2:
 *
     */
 * this file be licensed under the Apache-2.0 license or a
    public void testMetricDetails() {
     * test that metric returns 0.0 when there are no search results
 */
            parser.nextToken();
        assertEquals(0.0, err.evaluate("id", new SearchHit[0], Collections.emptyList()).metricScore(), DELTA);
     * 2    | n/a       | n/a       | 0.125    | n/a   |
    public void testERRAt() {
                () -> DiscountedCumulativeGain.fromXContent(parser)
import static org.opensearch.test.XContentTestUtils.insertRandomFields;
            assertEquals(expectedK, errAt.getK());
            assertEquals(expectedUnknownDocRating, errAt.getUnknownDocRating());
        EvalQueryQuality evaluation = err.evaluate("id", hits, rated);
     * 4    | 1         | 0.03125   | 0.125    | 0.00390625 |
 * software distributed under the License is distributed on an
    }
            }
    private SearchHit[] createSearchHits(List<RatedDocument> rated, Integer[] relevanceRatings) {
                    original.getMaxRelevance(),
            parser.nextToken();
        ExpectedReciprocalRank err = new ExpectedReciprocalRank(3, 0, 3);
        ExpectedReciprocalRank testItem = createTestItem();
    public void testSerialization() throws IOException {
        assertEquals(deserialized, original);
import org.opensearch.test.OpenSearchTestCase;
        XContentBuilder shuffled = shuffleXContent(testItem.toXContent(builder, ToXContent.EMPTY_PARAMS));
        ExpectedReciprocalRank original = createTestItem();
                    original.getUnknownDocRating(),
        assertEquals(0.8984375, err.evaluate("id", hits, rated).metricScore(), DELTA);
import java.util.List;
     */
 */
        throws IOException {
        }
 * ownership. Elasticsearch licenses this file to you under
        int maxRelevance = randomIntBetween(1, 10);
            itemParser.nextToken();
        List<RatedDocument> rated = new ArrayList<>();
        ExpectedReciprocalRank deserialized = OpenSearchTestCase.copyWriteable(
        for (int i = 0; i < relevanceRatings.length; i++) {
        assertEquals(unratedDocs, detail.getUnratedDocs());
package org.opensearch.index.rankeval;
        try (XContentParser itemParser = createParser(shuffled)) {
        }
/*
            original,
    public void testProbabilityOfRelevance() {
 * KIND, either express or implied.  See the License for the
     * 1    | 3         | 0.875     | 1        | 0.875       |
/*
import org.opensearch.search.SearchHit;
 * GitHub history for details.
                );
                XContentParseException.class,
        int unratedDocs = randomIntBetween(0, 100);
        assertParsedCorrect("{ \"maximum_relevance\": 4, \"k\": 23 }", null, 4, 23);
 * SPDX-License-Identifier: Apache-2.0
        assertEquals(0.8984375 + 0.00244140625, err.evaluate("id", hits, rated).metricScore(), DELTA);
            assertThat(exception.getMessage(), containsString("[dcg] unknown field"));
            XContentParseException exception = expectThrows(
import org.opensearch.core.common.bytes.BytesReference;
import org.opensearch.action.OriginalIndices;
     * <pre>{@code
        assertEquals(1d / 32d, err.probabilityOfRelevance(1), 0.0);
 * Licensed to Elasticsearch under one or more contributor
    }
    }
 * the Apache License, Version 2.0 (the "License"); you may
        return hits;
        assertParsedCorrect("{ \"unknown_doc_rating\": 2, \"maximum_relevance\": 5, \"k\" : 15 }", 2, 5, 15);
 * license agreements. See the NOTICE file distributed with
                return new ExpectedReciprocalRank(
        Integer[] relevanceRatings = new Integer[] { 3, 2, 0, 1 };
        return new ExpectedReciprocalRank(maxRelevance, unknownDocRating, randomIntBetween(1, 10));
        BytesReference originalBytes = toShuffledXContent(testItem, xContentType, ToXContent.EMPTY_PARAMS, randomBoolean());
    }
import org.opensearch.core.xcontent.XContentBuilder;
     * }</pre>
    }
    }
import org.opensearch.core.xcontent.XContentParseException;
 * You may obtain a copy of the License at
     * -------------------------------------------------------
    public void testXContentRoundtrip() throws IOException {
    public void testNoResults() throws Exception {
    }
            hits[i] = new SearchHit(i, Integer.toString(i), Collections.emptyMap(), Collections.emptyMap());
        err = new ExpectedReciprocalRank(3, 0, 4);
            assertEquals(expectedMaxRelevance, errAt.getMaxRelevance());
 *
