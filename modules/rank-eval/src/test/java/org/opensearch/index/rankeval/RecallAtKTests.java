        for (int i = 0; i < k; i++) {
        rated.add(createRatedDoc("test", "3", RELEVANT_RATING));
    }
            assertEquals(testItem.hashCode(), parsedItem.hashCode());
    private static RatedDocument createRatedDoc(String index, String id, int rating) {
        assertEquals(0, ((RecallAtK.Detail) evaluated.getMetricDetails()).getRelevantRetrieved());
        EvalQueryQuality evaluated = (new RecallAtK()).evaluate("id", toSearchHits(rated, "test"), rated);
            RecallAtK::new
        assertEquals(2, ((RecallAtK.Detail) evaluated.getMetricDetails()).getRelevantRetrieved());
        assertEquals(1, ((RecallAtK.Detail) evaluated.getMetricDetails()).getRelevant());
            assertEquals(testItem, parsedItem);
     * 1. e.g. we set it to 2 here and expect docs 0-1 to be not relevant, docs 2-4
            assertNotSame(testItem, parsedItem);
        partialResults.add(new EvalQueryQuality("b", 0.2));
        SearchHit[] hits = new SearchHit[k];
 */
import org.opensearch.core.xcontent.XContentParseException;
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
                    randomValueOtherThan(original.getRelevantRatingThreshold(), () -> randomIntBetween(0, 10)),
import org.opensearch.search.SearchHit;
 * specific language governing permissions and limitations
        assertEquals(4, ((RecallAtK.Detail) evaluated.getMetricDetails()).getRelevant());
        assertEquals(0.3, metric.combine(partialResults), Double.MIN_VALUE);
    }
        switch (randomIntBetween(0, 1)) {
/*
    }
        }
        assertEquals(4, ((RecallAtK.Detail) evaluated.getMetricDetails()).getRelevantRetrieved());
        RecallAtK deserialized = OpenSearchTestCase.copyWriteable(
import org.opensearch.core.xcontent.XContentParser;
    public void testCalculation() {
    }
    public void testCombine() {
    public void testXContentParsingIsNotLenient() throws IOException {
        rated.add(createRatedDoc("test", "0", RELEVANT_RATING));
    public void testEqualsAndHash() throws IOException {
            original,
 * the Apache License, Version 2.0 (the "License"); you may
        rated.add(createRatedDoc("test", "2", RELEVANT_RATING));
/*
        // the following search hits contain only the last three documents
    public void testCorrectIndex() {
        }
    public void testParseFromXContent() throws IOException {
    }
    }
            hits[i] = new SearchHit(i, i + "", Collections.emptyMap(), Collections.emptyMap());
        assertEquals(0, ((RecallAtK.Detail) evaluated.getMetricDetails()).getRelevantRetrieved());
    public void testXContentRoundtrip() throws IOException {
            assertThat(exception.getMessage(), containsString("[recall] unknown field"));
        assertEquals(0, ((RecallAtK.Detail) evaluated.getMetricDetails()).getRelevant());
 * not use this file except in compliance with the License.
 * this file be licensed under the Apache-2.0 license or a
    private static final int RELEVANT_RATING = 1;
package org.opensearch.index.rankeval;
 * Modifications Copyright OpenSearch Contributors. See
    }
        List<RatedDocument> rated = new ArrayList<>();
    public void testNoRatedDocs() throws Exception {
        rated.add(createRatedDoc("test", "1", RELEVANT_RATING));
import org.opensearch.test.OpenSearchTestCase;
        XContentType xContentType = randomFrom(XContentType.values());
        checkEqualsAndHashCode(createTestItem(), RecallAtKTests::copy, RecallAtKTests::mutate);
            hits[i] = new SearchHit(i, i + "", Collections.emptyMap(), Collections.emptyMap());
            case 1:
        RecallAtK recallAtK;
            parser.nextToken();
        for (int i = 0; i < rated.size(); i++) {
    public static RecallAtK createTestItem() {
        RecallAtK original = createTestItem();
    }
        EvalQueryQuality evaluated = (new RecallAtK()).evaluate("id", toSearchHits(rated, "test"), rated);
        assertEquals(1, ((RecallAtK.Detail) evaluated.getMetricDetails()).getRelevantRetrieved());
import java.io.IOException;
        EvalQueryQuality evaluated = recallAtN.evaluate("id", toSearchHits(rated.subList(0, 3), "test"), rated);
 * license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright
    }
 *
        rated.add(createRatedDoc("test", "0", RELEVANT_RATING));
        List<RatedDocument> rated = new ArrayList<>();
                );
    }
 *
        assertEquals(1, ((RecallAtK.Detail) evaluated.getMetricDetails()).getRelevant());
        rated.add(createRatedDoc("test", "0", RELEVANT_RATING));
        EvalQueryQuality evaluated = (new RecallAtK()).evaluate("id", hits, Collections.emptyList());
            RecallAtK recallAtK = RecallAtK.fromXContent(parser);
/*
        rated.add(createRatedDoc("test", "4", 4)); // relevant
                    original.forcedSearchSize().getAsInt()
    }
            itemParser.nextToken();
        }
     * to be relevant, and only 0-3 are hits.
        assertEquals(4, ((RecallAtK.Detail) evaluated.getMetricDetails()).getRelevant());
        EvalQueryQuality evaluated = (new RecallAtK()).evaluate("id", new SearchHit[0], Collections.emptyList());
        List<RatedDocument> rated = new ArrayList<>();
import static org.opensearch.test.EqualsHashCodeTestUtils.checkEqualsAndHashCode;
 * Unless required by applicable law or agreed to in writing,
    public void testInvalidRelevantThreshold() {
    public void testRelevanceThreshold() {
        rated.add(createRatedDoc("test", "0", RELEVANT_RATING));
        rated.add(createRatedDoc("test", "3", 3)); // relevant
        partialResults.add(new EvalQueryQuality("c", 0.6));
            default:
        return new RecallAtK(original.getRelevantRatingThreshold(), original.forcedSearchSize().getAsInt());
        assertEquals(0.0d, evaluated.metricScore(), 0.00001);
                throw new IllegalStateException("The test should only allow two parameters mutated");
     */
        return hits;
 *    http://www.apache.org/licenses/LICENSE-2.0
                recallAtK = new RecallAtK(
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, xContent)) {
        rated.add(createRatedDoc("test", "4", IRRELEVANT_RATING));
        assertEquals(deserialized, original);
        int k = 5;
            itemParser.nextToken();
        rated.add(createRatedDoc("test", "0", 0)); // not relevant, hit
        rated.add(createRatedDoc("test", "1", 1)); // not relevant, hit
            case 0:
import org.opensearch.action.OriginalIndices;
        rated.add(createRatedDoc("test", "2", IRRELEVANT_RATING));
}
    }
        List<RatedDocument> rated = new ArrayList<>();
import org.opensearch.core.common.bytes.BytesReference;
 */
 */
    }
        assertNotSame(deserialized, original);
        assertEquals(0.0d, evaluated.metricScore(), 0.00001);
            hits[i].shard(new SearchShardTarget("testnode", new ShardId(index, "uuid", 0), null, OriginalIndices.NONE));
    }
 * GitHub history for details.
        List<RatedDocument> ratedSubList = rated.subList(2, 5);
            hits[i].shard(new SearchShardTarget("testnode", new ShardId("index", "uuid", 0), null, OriginalIndices.NONE));
import org.opensearch.common.xcontent.XContentType;
import org.opensearch.core.index.shard.ShardId;
        return new RecallAtK(randomIntBetween(0, 10), randomIntBetween(1, 50));
    }
        try (XContentParser parser = createParser(xContentType.xContent(), withRandomFields)) {
    }
        return recallAtK;
    private static RecallAtK copy(RecallAtK original) {
        assertEquals((double) 1 / 3, evaluated.metricScore(), 0.00001);
 *
        }
        RecallAtK metric = new RecallAtK();
            RecallAtK parsedItem = RecallAtK.fromXContent(itemParser);
        assertEquals(1, ((RecallAtK.Detail) evaluated.getMetricDetails()).getRelevantRetrieved());
 * Licensed to Elasticsearch under one or more contributor
    public void testSerialization() throws IOException {
            assertEquals(2, recallAtK.getRelevantRatingThreshold());
import org.opensearch.core.xcontent.MediaTypeRegistry;
        assertEquals(0.0d, evaluated.metricScore(), 0.00001);
        assertEquals((double) 4 / 4, evaluated.metricScore(), 0.00001);
        assertEquals((double) 2 / 4, evaluated.metricScore(), 0.00001);
        }
    }
import static org.hamcrest.CoreMatchers.containsString;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        assertEquals(0, ((RecallAtK.Detail) evaluated.getMetricDetails()).getRelevantRetrieved());
        RecallAtK testItem = createTestItem();
        assertEquals(3, ((RecallAtK.Detail) evaluated.getMetricDetails()).getRelevant());
    public void testInvalidK() {
 * software distributed under the License is distributed on an
import java.util.Collections;
        assertEquals(0, ((RecallAtK.Detail) evaluated.getMetricDetails()).getRelevant());
 * The OpenSearch Contributors require contributions made to
     * Test that the relevant rating threshold can be set to something larger than
import org.opensearch.core.xcontent.ToXContent;
        expectThrows(IllegalArgumentException.class, () -> new RecallAtK(-1, 10));
    public void testNoResults() throws Exception {
import org.opensearch.search.SearchShardTarget;
            XContentParseException exception = expectThrows(XContentParseException.class, () -> RecallAtK.fromXContent(parser));
 * ownership. Elasticsearch licenses this file to you under
        XContentBuilder builder = MediaTypeRegistry.contentBuilder(randomFrom(XContentType.values()));
import java.util.List;
    private static SearchHit[] toSearchHits(List<RatedDocument> rated, String index) {
    }
            new NamedWriteableRegistry(Collections.emptyList()),
        return new RatedDocument(index, id, rating);
    public void testIgnoreOneResult() {
    }
        EvalQueryQuality evaluated = (new RecallAtK(1, 5)).evaluate("id", toSearchHits(ratedSubList, "test"), rated);
        rated.add(createRatedDoc("test_other", "0", RELEVANT_RATING));
                break;
        partialResults.add(new EvalQueryQuality("a", 0.1));
        SearchHit[] hits = new SearchHit[rated.size()];
 * under the License.
import org.opensearch.common.xcontent.json.JsonXContent;
        }
        XContentBuilder shuffled = shuffleXContent(testItem.toXContent(builder, ToXContent.EMPTY_PARAMS));
        String xContent = " {\n" + "   \"relevant_rating_threshold\" : 2" + "}";
        try (XContentParser itemParser = createParser(shuffled)) {
import static org.opensearch.test.XContentTestUtils.insertRandomFields;
public class RecallAtKTests extends OpenSearchTestCase {
    }
                recallAtK = new RecallAtK(original.getRelevantRatingThreshold(), original.forcedSearchSize().getAsInt() + 1);
    /**
        List<EvalQueryQuality> partialResults = new ArrayList<>(3);
                break;
 * SPDX-License-Identifier: Apache-2.0
    private static final int IRRELEVANT_RATING = 0;
        EvalQueryQuality evaluated = (new RecallAtK()).evaluate("id", new SearchHit[0], rated);
        );
        RecallAtK testItem = createTestItem();
        assertEquals(deserialized.hashCode(), original.hashCode());
        BytesReference withRandomFields = insertRandomFields(xContentType, originalBytes, null, random());
    public void testNoResultsWithRatedDocs() throws Exception {
 * You may obtain a copy of the License at
        assertEquals(1, evaluated.metricScore(), 0.00001);
import org.opensearch.core.xcontent.XContentBuilder;
    private static RecallAtK mutate(RecallAtK original) {
        RecallAtK recallAtN = new RecallAtK(2, 5);
import java.util.ArrayList;
        rated.add(createRatedDoc("test_other", "1", RELEVANT_RATING));
        BytesReference originalBytes = toShuffledXContent(testItem, xContentType, ToXContent.EMPTY_PARAMS, randomBoolean());
        expectThrows(IllegalArgumentException.class, () -> new RecallAtK(1, -10));
        rated.add(createRatedDoc("test", "2", 2)); // relevant, hit
 * compatible open source license.
        List<RatedDocument> rated = new ArrayList<>();
 * KIND, either express or implied.  See the License for the
            parser.nextToken();
        rated.add(createRatedDoc("test", "1", RELEVANT_RATING));
