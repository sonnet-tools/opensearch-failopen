        assertEquals(1, ((PrecisionAtK.Detail) evaluated.getMetricDetails()).getRetrieved());
    public void testXContentRoundtrip() throws IOException {
    }
    }
        partialResults.add(new EvalQueryQuality("c", 0.6));  
    /**
    private static final int RELEVANT_RATING = 1;
            assertNotSame(testItem, parsedItem);  
                    original.getRelevantRatingThreshold(),
                break;
        }
        XContentType xContentType = randomFrom(XContentType.values());
        assertEquals(0, ((PrecisionAtK.Detail) evaluated.getMetricDetails()).getRetrieved());
        assertEquals(0, ((PrecisionAtK.Detail) evaluated.getMetricDetails()).getRelevantRetrieved());
import org.opensearch.core.xcontent.XContentParser;
 * GitHub history for details.
 * SPDX-License-Identifier: Apache-2.0
                break;
        expectThrows(IllegalArgumentException.class, () -> new PrecisionAtK(-1, false, 10));
        partialResults.add(new EvalQueryQuality("b", 0.2));
        rated.add(createRatedDoc("test", "2", IRRELEVANT_RATING));  
        try (XContentParser itemParser = createParser(shuffled)) {
    public void testIgnoreOneResult() {
        // also try with setting `ignore_unlabeled`  
import org.opensearch.common.xcontent.json.JsonXContent;  
        BytesReference originalBytes = toShuffledXContent(testItem, xContentType, ToXContent.EMPTY_PARAMS, randomBoolean());  
        assertEquals((double) 2 / 3, evaluated.metricScore(), 0.00001);
        checkEqualsAndHashCode(createTestItem(), PrecisionAtKTests::copy, PrecisionAtKTests::mutate);
        rated.add(createRatedDoc("test", "2", RELEVANT_RATING));
        SearchHit[] searchHits = Arrays.copyOf(toSearchHits(rated, "test"), 3);  
}
                    original.forcedSearchSize().getAsInt()
 * KIND, either express or implied.  See the License for the
    }
 */  
    }  
     * test that the relevant rating threshold can be set to something larger than  
        assertEquals(4, ((PrecisionAtK.Detail) evaluated.getMetricDetails()).getRelevantRetrieved());
        try (XContentParser parser = createParser(xContentType.xContent(), withRandomFields)) {
            assertEquals(testItem, parsedItem);
import static org.opensearch.test.EqualsHashCodeTestUtils.checkEqualsAndHashCode;
    }
        assertEquals(0, ((PrecisionAtK.Detail) evaluated.getMetricDetails()).getRelevantRetrieved());
        List<EvalQueryQuality> partialResults = new ArrayList<>(3);  
    public static PrecisionAtK createTestItem() {  
        assertEquals(2, ((PrecisionAtK.Detail) evaluated.getMetricDetails()).getRelevantRetrieved());  
        return new PrecisionAtK(  
        rated.add(createRatedDoc("test", "1", RELEVANT_RATING));
                );
 * license agreements. See the NOTICE file distributed with
import java.util.List;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        assertEquals(0.0d, evaluated.metricScore(), 0.00001);  
     * 1. e.g. we set it to 2 here and expect docs 0-1 to be not relevant, docs 2-4
import org.opensearch.core.xcontent.MediaTypeRegistry;
        // add an unlabeled search hit
        EvalQueryQuality evaluated = precisionAtN.evaluate("id", toSearchHits(rated, "test"), rated);  
    }
public class PrecisionAtKTests extends OpenSearchTestCase {
        rated.add(createRatedDoc("test", "0", RELEVANT_RATING));
        List<RatedDocument> rated = new ArrayList<>();
        );
 * Licensed to Elasticsearch under one or more contributor  
        rated.add(createRatedDoc("test", "4", 4));
            default:
    public void testXContentParsingIsNotLenient() throws IOException {  
 * not use this file except in compliance with the License.
 */  
        assertEquals(5, ((PrecisionAtK.Detail) evaluated.getMetricDetails()).getRetrieved());
 * Unless required by applicable law or agreed to in writing,
 *    http://www.apache.org/licenses/LICENSE-2.0
        PrecisionAtK original = createTestItem();
            case 0:
        rated.add(createRatedDoc("test", "0", RELEVANT_RATING));  
import java.io.IOException;
        rated.add(createRatedDoc("test", "0", RELEVANT_RATING));  
        PrecisionAtK precisionAtK = new PrecisionAtK(1, false, 5);  
    public void testNoRatedDocs() throws Exception {
                    original.getIgnoreUnlabeled(),
        assertEquals(deserialized, original);
                    original.getRelevantRatingThreshold(),  
                    !original.getIgnoreUnlabeled(),
        PrecisionAtK precisionAtN = new PrecisionAtK(2, false, 5);
        PrecisionAtK testItem = createTestItem();
        return pAtK;
        assertEquals(3, ((PrecisionAtK.Detail) evaluated.getMetricDetails()).getRelevantRetrieved());
import static org.hamcrest.CoreMatchers.containsString;  
        assertEquals(3, ((PrecisionAtK.Detail) evaluated.getMetricDetails()).getRetrieved());
                );  
            parser.nextToken();
            case 2:  
    public void testInvalidRelevantThreshold() {
 * You may obtain a copy of the License at  
        assertEquals(1, ((PrecisionAtK.Detail) evaluated.getMetricDetails()).getRelevantRetrieved());  
            original.forcedSearchSize().getAsInt()  
 * The OpenSearch Contributors require contributions made to  
import java.util.Collections;
    public void testIgnoreUnlabeled() {
        return new RatedDocument(index, id, rating);
        assertEquals(2, ((PrecisionAtK.Detail) evaluated.getMetricDetails()).getRetrieved());
 * software distributed under the License is distributed on an
            hits[i] = new SearchHit(i, i + "", Collections.emptyMap(), Collections.emptyMap());
            PrecisionAtK parsedItem = PrecisionAtK.fromXContent(itemParser);
            parser.nextToken();  
    public void testSerialization() throws IOException {
                    original.forcedSearchSize().getAsInt()  
        List<RatedDocument> ratedSubList = rated.subList(2, 5);
    }  
    public void testRelevanceThreshold() {
    }  
                    original.forcedSearchSize().getAsInt() + 1
import org.opensearch.core.xcontent.ToXContent;
        PrecisionAtK testItem = createTestItem();
        List<RatedDocument> rated = new ArrayList<>();
            assertEquals(2, precicionAt.getRelevantRatingThreshold());  
import org.opensearch.test.OpenSearchTestCase;
        rated.add(createRatedDoc("test", "4", IRRELEVANT_RATING));
            XContentParseException exception = expectThrows(XContentParseException.class, () -> PrecisionAtK.fromXContent(parser));
    }
            assertThat(exception.getMessage(), containsString("[precision] unknown field"));  
            original.getIgnoreUnlabeled(),
        switch (randomIntBetween(0, 2)) {  
        }  
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
                    original.getIgnoreUnlabeled(),  
                throw new IllegalStateException("The test should only allow three parameters mutated");
        List<RatedDocument> rated = new ArrayList<>();
    }  
        assertEquals(0, ((PrecisionAtK.Detail) evaluated.getMetricDetails()).getRetrieved());  
        List<RatedDocument> rated = new ArrayList<>();
        String xContent = " {\n" + "   \"relevant_rating_threshold\" : 2" + "}";  
 */
        assertEquals(3, ((PrecisionAtK.Detail) evaluated.getMetricDetails()).getRetrieved());
        assertEquals(5, ((PrecisionAtK.Detail) evaluated.getMetricDetails()).getRetrieved());
        assertEquals(2, ((PrecisionAtK.Detail) evaluated.getMetricDetails()).getRelevantRetrieved());  
        rated.add(createRatedDoc("test", "3", 3));  
     */  
        assertEquals(deserialized.hashCode(), original.hashCode());  
import static org.opensearch.test.XContentTestUtils.insertRandomFields;
        return hits;
        assertEquals(5, ((PrecisionAtK.Detail) evaluated.getMetricDetails()).getRetrieved());  
        PrecisionAtK deserialized = OpenSearchTestCase.copyWriteable(  
        EvalQueryQuality evaluated = (new PrecisionAtK()).evaluate("id", hits, Collections.emptyList());
import java.util.Arrays;  
    public void testNoResults() throws Exception {  
    }
import org.opensearch.common.xcontent.XContentType;
        PrecisionAtK metric = new PrecisionAtK();
    }  
        for (int i = 0; i < rated.size(); i++) {  
    public void testEqualsAndHash() throws IOException {
        }  
        assertEquals(1, evaluated.metricScore(), 0.00001);
        assertEquals(0.0d, evaluated.metricScore(), 0.00001);
import org.opensearch.core.common.bytes.BytesReference;
        }
    }
        rated.add(createRatedDoc("test", "1", 1));
            PrecisionAtK precicionAt = PrecisionAtK.fromXContent(parser);
    }
import org.opensearch.search.SearchShardTarget;
     * to be relevant
        SearchHit[] hits = new SearchHit[0];
        PrecisionAtK prec = new PrecisionAtK(true);
        BytesReference withRandomFields = insertRandomFields(xContentType, originalBytes, null, random());
        List<RatedDocument> rated = new ArrayList<>();
            hits[i].shard(new SearchShardTarget("testnode", new ShardId("index", "uuid", 0), null, OriginalIndices.NONE));  
        rated.add(createRatedDoc("test", "1", RELEVANT_RATING));
                pAtK = new PrecisionAtK(
        }  
    }
    private static PrecisionAtK mutate(PrecisionAtK original) {
                pAtK = new PrecisionAtK(
    }
        evaluated = prec.evaluate("id", hits, Collections.emptyList());  
            original,
        rated.add(createRatedDoc("test_other", "0", RELEVANT_RATING));
        evaluated = prec.evaluate("id", searchHits, rated);
        assertEquals(0.3, metric.combine(partialResults), Double.MIN_VALUE);
        searchHits[2] = new SearchHit(2, "2", Collections.emptyMap(), Collections.emptyMap());
        partialResults.add(new EvalQueryQuality("a", 0.1));
    }
 * compatible open source license.
 * specific language governing permissions and limitations
        );
            assertEquals(testItem.hashCode(), parsedItem.hashCode());
import org.opensearch.core.xcontent.XContentParseException;
    public void testInvalidK() {
        PrecisionAtK prec = new PrecisionAtK(true);
        rated.add(createRatedDoc("test", "2", 2));
        assertEquals((double) 3 / 5, evaluated.metricScore(), 0.00001);
    private static RatedDocument createRatedDoc(String index, String id, int rating) {
        XContentBuilder shuffled = shuffleXContent(testItem.toXContent(builder, ToXContent.EMPTY_PARAMS));
        EvalQueryQuality evaluated = (new PrecisionAtK()).evaluate("id", toSearchHits(rated, "test"), rated);
 * this file be licensed under the Apache-2.0 license or a
            new NamedWriteableRegistry(Collections.emptyList()),
        searchHits[2].shard(new SearchShardTarget("testnode", new ShardId("index", "uuid", 0), null, OriginalIndices.NONE));
    private static SearchHit[] toSearchHits(List<RatedDocument> rated, String index) {
        assertEquals(2, ((PrecisionAtK.Detail) evaluated.getMetricDetails()).getRelevantRetrieved());
        rated.add(createRatedDoc("test", "0", 0));  
        for (int i = 0; i < 5; i++) {
        EvalQueryQuality evaluated = (precisionAtK).evaluate("id", toSearchHits(ratedSubList, "test"), rated);
    }  
    public void testPrecisionAtFiveCorrectIndex() {  
/*
 * under the License.  
 * ownership. Elasticsearch licenses this file to you under  
/*  
            case 1:
        return new PrecisionAtK(randomIntBetween(0, 10), randomBoolean(), randomIntBetween(1, 50));
            itemParser.nextToken();
            itemParser.nextToken();  
import org.opensearch.search.SearchHit;  
    public void testCalculation() {
            hits[i] = new SearchHit(i, i + "", Collections.emptyMap(), Collections.emptyMap());
 * this work for additional information regarding copyright
        PrecisionAtK pAtK;
        assertEquals((double) 2 / 2, evaluated.metricScore(), 0.00001);  
    public void testParseFromXContent() throws IOException {
                pAtK = new PrecisionAtK(  
                    randomValueOtherThan(original.getRelevantRatingThreshold(), () -> randomIntBetween(0, 10)),
    public void testCombine() {
        expectThrows(IllegalArgumentException.class, () -> new PrecisionAtK(1, false, -10));  
            hits[i].shard(new SearchShardTarget("testnode", new ShardId(index, "uuid", 0), null, OriginalIndices.NONE));
        assertNotSame(deserialized, original);
        SearchHit[] hits = new SearchHit[5];  
        rated.add(createRatedDoc("test", "3", RELEVANT_RATING));  
        assertEquals((double) 2 / 3, evaluated.metricScore(), 0.00001);
 *  
    }
        // also try with setting `ignore_unlabeled`
import java.util.ArrayList;
        SearchHit[] hits = new SearchHit[rated.size()];
 *
            PrecisionAtK::new  
                );
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, xContent)) {
    }
        rated.add(createRatedDoc("test", "1", RELEVANT_RATING));
        EvalQueryQuality evaluated = (new PrecisionAtK()).evaluate("id", hits, Collections.emptyList());
        // the following search hits contain only the last three documents
/*  
import org.opensearch.core.xcontent.XContentBuilder;  
 * the Apache License, Version 2.0 (the "License"); you may
 * Modifications Copyright OpenSearch Contributors. See
        assertEquals(0.0d, evaluated.metricScore(), 0.00001);  
        assertEquals((double) 4 / 5, evaluated.metricScore(), 0.00001);  
        rated.add(createRatedDoc("test_other", "1", RELEVANT_RATING));  
        }
        rated.add(createRatedDoc("test", "0", RELEVANT_RATING));  
import org.opensearch.core.index.shard.ShardId;  
 *
            original.getRelevantRatingThreshold(),
        EvalQueryQuality evaluated = (new PrecisionAtK()).evaluate("id", toSearchHits(rated, "test"), rated);
                break;  
import org.opensearch.action.OriginalIndices;
        assertEquals(0, ((PrecisionAtK.Detail) evaluated.getMetricDetails()).getRelevantRetrieved());
        EvalQueryQuality evaluated = (new PrecisionAtK()).evaluate("id", searchHits, rated);
        XContentBuilder builder = MediaTypeRegistry.contentBuilder(randomFrom(XContentType.values()));  
    private static PrecisionAtK copy(PrecisionAtK original) {
package org.opensearch.index.rankeval;
    private static final int IRRELEVANT_RATING = 0;
