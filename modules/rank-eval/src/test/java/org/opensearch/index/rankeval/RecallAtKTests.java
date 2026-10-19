            default:
    }
        XContentBuilder shuffled = shuffleXContent(testItem.toXContent(builder, ToXContent.EMPTY_PARAMS));
        }  
        List<RatedDocument> ratedSubList = rated.subList(2, 5);  
        );
        XContentBuilder builder = MediaTypeRegistry.contentBuilder(randomFrom(XContentType.values()));
        assertEquals(1, ((RecallAtK.Detail) evaluated.getMetricDetails()).getRelevant());
 *    http://www.apache.org/licenses/LICENSE-2.0
        }
    public void testRelevanceThreshold() {
        assertEquals(1, ((RecallAtK.Detail) evaluated.getMetricDetails()).getRelevant());  
            case 1:
    /**  
 * Unless required by applicable law or agreed to in writing,
        expectThrows(IllegalArgumentException.class, () -> new RecallAtK(1, -10));
package org.opensearch.index.rankeval;
    }
    public void testNoRatedDocs() throws Exception {
import static org.hamcrest.CoreMatchers.containsString;
        rated.add(createRatedDoc("test", "0", RELEVANT_RATING));
            assertEquals(testItem.hashCode(), parsedItem.hashCode());  
        assertEquals(1, evaluated.metricScore(), 0.00001);
    }
    public void testNoResults() throws Exception {
        RecallAtK metric = new RecallAtK();  
 * specific language governing permissions and limitations
        assertEquals(1, ((RecallAtK.Detail) evaluated.getMetricDetails()).getRelevantRetrieved());  
    }
    private static final int IRRELEVANT_RATING = 0;  
        EvalQueryQuality evaluated = (new RecallAtK()).evaluate("id", toSearchHits(rated, "test"), rated);
import java.util.List;
        rated.add(createRatedDoc("test", "1", 1)); // not relevant, hit
        BytesReference withRandomFields = insertRandomFields(xContentType, originalBytes, null, random());
                recallAtK = new RecallAtK(
    }
 *
        rated.add(createRatedDoc("test", "2", IRRELEVANT_RATING));  
        rated.add(createRatedDoc("test", "0", RELEVANT_RATING));  
    }  
}
 * SPDX-License-Identifier: Apache-2.0
        RecallAtK testItem = createTestItem();  
        assertNotSame(deserialized, original);
import org.opensearch.common.xcontent.XContentType;
import static org.opensearch.test.EqualsHashCodeTestUtils.checkEqualsAndHashCode;  
                    randomValueOtherThan(original.getRelevantRatingThreshold(), () -> randomIntBetween(0, 10)),  
 *
        List<RatedDocument> rated = new ArrayList<>();
 * license agreements. See the NOTICE file distributed with
            RecallAtK recallAtK = RecallAtK.fromXContent(parser);  
            hits[i].shard(new SearchShardTarget("testnode", new ShardId(index, "uuid", 0), null, OriginalIndices.NONE));
        for (int i = 0; i < k; i++) {
/*  
        rated.add(createRatedDoc("test_other", "0", RELEVANT_RATING));
import org.opensearch.test.OpenSearchTestCase;
import org.opensearch.core.index.shard.ShardId;  
            assertNotSame(testItem, parsedItem);
    public void testEqualsAndHash() throws IOException {
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, xContent)) {
        rated.add(createRatedDoc("test", "4", IRRELEVANT_RATING));
        EvalQueryQuality evaluated = (new RecallAtK()).evaluate("id", new SearchHit[0], rated);  
        assertEquals(3, ((RecallAtK.Detail) evaluated.getMetricDetails()).getRelevant());  
import java.util.Collections;  
        assertEquals((double) 1 / 3, evaluated.metricScore(), 0.00001);
        rated.add(createRatedDoc("test", "1", RELEVANT_RATING));
        for (int i = 0; i < rated.size(); i++) {  
    }
            new NamedWriteableRegistry(Collections.emptyList()),  
                    original.forcedSearchSize().getAsInt()
        RecallAtK recallAtN = new RecallAtK(2, 5);
        SearchHit[] hits = new SearchHit[rated.size()];
            assertEquals(2, recallAtK.getRelevantRatingThreshold());
import org.opensearch.search.SearchHit;  
            hits[i] = new SearchHit(i, i + "", Collections.emptyMap(), Collections.emptyMap());  
        rated.add(createRatedDoc("test", "0", RELEVANT_RATING));
import org.opensearch.core.xcontent.ToXContent;
    }  
 * Modifications Copyright OpenSearch Contributors. See
        // the following search hits contain only the last three documents
            hits[i] = new SearchHit(i, i + "", Collections.emptyMap(), Collections.emptyMap());
        assertEquals(0, ((RecallAtK.Detail) evaluated.getMetricDetails()).getRelevantRetrieved());  
/*  
        rated.add(createRatedDoc("test", "2", 2)); // relevant, hit  
        EvalQueryQuality evaluated = (new RecallAtK()).evaluate("id", hits, Collections.emptyList());
        rated.add(createRatedDoc("test", "3", 3)); // relevant
     * to be relevant, and only 0-3 are hits.  
    }
    public void testNoResultsWithRatedDocs() throws Exception {
import org.opensearch.search.SearchShardTarget;
        switch (randomIntBetween(0, 1)) {  
        }
/*
                break;  
        BytesReference originalBytes = toShuffledXContent(testItem, xContentType, ToXContent.EMPTY_PARAMS, randomBoolean());
    }
    public void testInvalidRelevantThreshold() {
 */
 * not use this file except in compliance with the License.
        rated.add(createRatedDoc("test", "3", RELEVANT_RATING));  
public class RecallAtKTests extends OpenSearchTestCase {
        return hits;
        return new RatedDocument(index, id, rating);
    public static RecallAtK createTestItem() {
        assertEquals(deserialized.hashCode(), original.hashCode());
 */  
        assertEquals(0.0d, evaluated.metricScore(), 0.00001);
 * The OpenSearch Contributors require contributions made to  
 * the Apache License, Version 2.0 (the "License"); you may
 * under the License.  
    }
        EvalQueryQuality evaluated = (new RecallAtK(1, 5)).evaluate("id", toSearchHits(ratedSubList, "test"), rated);
    private static RecallAtK copy(RecallAtK original) {  
        int k = 5;  
    }  
        assertEquals(0.3, metric.combine(partialResults), Double.MIN_VALUE);
        rated.add(createRatedDoc("test_other", "1", RELEVANT_RATING));  
    public void testXContentParsingIsNotLenient() throws IOException {
     * Test that the relevant rating threshold can be set to something larger than
        assertEquals((double) 2 / 4, evaluated.metricScore(), 0.00001);  
    }
    }  
     * 1. e.g. we set it to 2 here and expect docs 0-1 to be not relevant, docs 2-4
        RecallAtK original = createTestItem();  
        return recallAtK;
        }  
    public void testCorrectIndex() {  
    }  
                );
    }  
        EvalQueryQuality evaluated = (new RecallAtK()).evaluate("id", toSearchHits(rated, "test"), rated);  
        return new RecallAtK(randomIntBetween(0, 10), randomIntBetween(1, 50));
import static org.opensearch.test.XContentTestUtils.insertRandomFields;
import java.util.ArrayList;
        partialResults.add(new EvalQueryQuality("c", 0.6));
import org.opensearch.action.OriginalIndices;
        EvalQueryQuality evaluated = (new RecallAtK()).evaluate("id", new SearchHit[0], Collections.emptyList());
 * You may obtain a copy of the License at  
import org.opensearch.common.xcontent.json.JsonXContent;  
 * KIND, either express or implied.  See the License for the
import org.opensearch.core.xcontent.XContentParser;
        try (XContentParser itemParser = createParser(shuffled)) {  
    }
        rated.add(createRatedDoc("test", "4", 4)); // relevant
import org.opensearch.core.xcontent.XContentBuilder;  
        rated.add(createRatedDoc("test", "0", 0)); // not relevant, hit
    private static RatedDocument createRatedDoc(String index, String id, int rating) {
        partialResults.add(new EvalQueryQuality("a", 0.1));
        List<RatedDocument> rated = new ArrayList<>();  
        assertEquals(deserialized, original);  
    public void testCombine() {
import org.opensearch.core.xcontent.XContentParseException;
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
        expectThrows(IllegalArgumentException.class, () -> new RecallAtK(-1, 10));  
        assertEquals(0, ((RecallAtK.Detail) evaluated.getMetricDetails()).getRelevantRetrieved());
    public void testInvalidK() {  
        assertEquals(4, ((RecallAtK.Detail) evaluated.getMetricDetails()).getRelevantRetrieved());
    public void testXContentRoundtrip() throws IOException {
        rated.add(createRatedDoc("test", "1", RELEVANT_RATING));
    private static final int RELEVANT_RATING = 1;
                throw new IllegalStateException("The test should only allow two parameters mutated");
            parser.nextToken();
        List<RatedDocument> rated = new ArrayList<>();
                recallAtK = new RecallAtK(original.getRelevantRatingThreshold(), original.forcedSearchSize().getAsInt() + 1);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            assertThat(exception.getMessage(), containsString("[recall] unknown field"));
    public void testParseFromXContent() throws IOException {  
 * this work for additional information regarding copyright
        rated.add(createRatedDoc("test", "0", RELEVANT_RATING));
     */
        }
            XContentParseException exception = expectThrows(XContentParseException.class, () -> RecallAtK.fromXContent(parser));  
            case 0:
        SearchHit[] hits = new SearchHit[k];
            original,
            RecallAtK parsedItem = RecallAtK.fromXContent(itemParser);  
    }  
        assertEquals(0, ((RecallAtK.Detail) evaluated.getMetricDetails()).getRelevant());
import org.opensearch.core.xcontent.MediaTypeRegistry;
    public void testCalculation() {  
        try (XContentParser parser = createParser(xContentType.xContent(), withRandomFields)) {  
    }
        assertEquals(4, ((RecallAtK.Detail) evaluated.getMetricDetails()).getRelevant());
        RecallAtK recallAtK;
        List<EvalQueryQuality> partialResults = new ArrayList<>(3);
 *  
            RecallAtK::new
        checkEqualsAndHashCode(createTestItem(), RecallAtKTests::copy, RecallAtKTests::mutate);  
            assertEquals(testItem, parsedItem);
                break;  
 * compatible open source license.
            parser.nextToken();
    }  
        XContentType xContentType = randomFrom(XContentType.values());  
        String xContent = " {\n" + "   \"relevant_rating_threshold\" : 2" + "}";
        partialResults.add(new EvalQueryQuality("b", 0.2));  
        assertEquals(0.0d, evaluated.metricScore(), 0.00001);
        assertEquals((double) 4 / 4, evaluated.metricScore(), 0.00001);
    private static RecallAtK mutate(RecallAtK original) {
import org.opensearch.core.common.bytes.BytesReference;
        assertEquals(0, ((RecallAtK.Detail) evaluated.getMetricDetails()).getRelevant());
        rated.add(createRatedDoc("test", "2", RELEVANT_RATING));
 * this file be licensed under the Apache-2.0 license or a
    private static SearchHit[] toSearchHits(List<RatedDocument> rated, String index) {
 * ownership. Elasticsearch licenses this file to you under  
            itemParser.nextToken();
        return new RecallAtK(original.getRelevantRatingThreshold(), original.forcedSearchSize().getAsInt());
        assertEquals(2, ((RecallAtK.Detail) evaluated.getMetricDetails()).getRelevantRetrieved());
 * software distributed under the License is distributed on an
            itemParser.nextToken();
        assertEquals(4, ((RecallAtK.Detail) evaluated.getMetricDetails()).getRelevant());  
            hits[i].shard(new SearchShardTarget("testnode", new ShardId("index", "uuid", 0), null, OriginalIndices.NONE));
 */  
        assertEquals(0, ((RecallAtK.Detail) evaluated.getMetricDetails()).getRelevantRetrieved());
        assertEquals(0.0d, evaluated.metricScore(), 0.00001);  
        List<RatedDocument> rated = new ArrayList<>();  
 * GitHub history for details.
    public void testIgnoreOneResult() {
        assertEquals(1, ((RecallAtK.Detail) evaluated.getMetricDetails()).getRelevantRetrieved());
    public void testSerialization() throws IOException {
        RecallAtK testItem = createTestItem();
        RecallAtK deserialized = OpenSearchTestCase.copyWriteable(
 * Licensed to Elasticsearch under one or more contributor  
import java.io.IOException;
        List<RatedDocument> rated = new ArrayList<>();
        }
        EvalQueryQuality evaluated = recallAtN.evaluate("id", toSearchHits(rated.subList(0, 3), "test"), rated);  
