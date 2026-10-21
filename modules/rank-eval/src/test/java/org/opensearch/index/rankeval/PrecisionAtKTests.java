import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
import org.opensearch.search.SearchHit;
            PrecisionAtK::new
    }
 * The OpenSearch Contributors require contributions made to
    }
        EvalQueryQuality evaluated = (new PrecisionAtK()).evaluate("id", toSearchHits(rated, "test"), rated);
public class PrecisionAtKTests extends OpenSearchTestCase {
        assertEquals((double) 3 / 5, evaluated.metricScore(), 0.00001);
        rated.add(createRatedDoc("test_other", "0", RELEVANT_RATING));
        for (int i = 0; i < 5; i++) {
        assertEquals(0, ((PrecisionAtK.Detail) evaluated.getMetricDetails()).getRelevantRetrieved());
import static org.opensearch.test.XContentTestUtils.insertRandomFields;
    private static final int IRRELEVANT_RATING = 0;
            parser.nextToken();
                );
        assertEquals(5, ((PrecisionAtK.Detail) evaluated.getMetricDetails()).getRetrieved());
    public void testIgnoreOneResult() {
    }
                break;
        assertEquals(5, ((PrecisionAtK.Detail) evaluated.getMetricDetails()).getRetrieved());
                    randomValueOtherThan(original.getRelevantRatingThreshold(), () -> randomIntBetween(0, 10)),
        assertEquals(deserialized, original);
package org.opensearch.index.rankeval;
    }
    public void testRelevanceThreshold() {
    private static final int RELEVANT_RATING = 1;
    }
    private static RatedDocument createRatedDoc(String index, String id, int rating) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        assertEquals(1, ((PrecisionAtK.Detail) evaluated.getMetricDetails()).getRelevantRetrieved());
        assertEquals(0.0d, evaluated.metricScore(), 0.00001);
import static org.opensearch.test.EqualsHashCodeTestUtils.checkEqualsAndHashCode;
                pAtK = new PrecisionAtK(
        XContentType xContentType = randomFrom(XContentType.values());
        assertEquals(3, ((PrecisionAtK.Detail) evaluated.getMetricDetails()).getRelevantRetrieved());
        rated.add(createRatedDoc("test", "4", IRRELEVANT_RATING));
        SearchHit[] searchHits = Arrays.copyOf(toSearchHits(rated, "test"), 3);
        EvalQueryQuality evaluated = precisionAtN.evaluate("id", toSearchHits(rated, "test"), rated);
 */
                    original.getIgnoreUnlabeled(),
        List<RatedDocument> ratedSubList = rated.subList(2, 5);
        }
import org.opensearch.core.xcontent.MediaTypeRegistry;
            parser.nextToken();
    public void testEqualsAndHash() throws IOException {
 * compatible open source license.
        assertEquals((double) 2 / 2, evaluated.metricScore(), 0.00001);
        assertEquals(2, ((PrecisionAtK.Detail) evaluated.getMetricDetails()).getRetrieved());
 * specific language governing permissions and limitations
import org.opensearch.core.xcontent.XContentParser;
        EvalQueryQuality evaluated = (new PrecisionAtK()).evaluate("id", hits, Collections.emptyList());
        rated.add(createRatedDoc("test", "0", RELEVANT_RATING));
        EvalQueryQuality evaluated = (precisionAtK).evaluate("id", toSearchHits(ratedSubList, "test"), rated);
        return pAtK;
        PrecisionAtK testItem = createTestItem();
                );
 * You may obtain a copy of the License at
    }
        PrecisionAtK precisionAtK = new PrecisionAtK(1, false, 5);
        searchHits[2] = new SearchHit(2, "2", Collections.emptyMap(), Collections.emptyMap());
    }
        return new PrecisionAtK(randomIntBetween(0, 10), randomBoolean(), randomIntBetween(1, 50));
    }
            hits[i] = new SearchHit(i, i + "", Collections.emptyMap(), Collections.emptyMap());
        rated.add(createRatedDoc("test", "3", RELEVANT_RATING));
        );
 */
        // the following search hits contain only the last three documents
/*
import org.opensearch.action.OriginalIndices;
            original,
            assertEquals(testItem, parsedItem);
        }
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, xContent)) {
                    original.forcedSearchSize().getAsInt() + 1
import java.util.Collections;
        List<RatedDocument> rated = new ArrayList<>();
    private static SearchHit[] toSearchHits(List<RatedDocument> rated, String index) {
        assertEquals(2, ((PrecisionAtK.Detail) evaluated.getMetricDetails()).getRelevantRetrieved());
        rated.add(createRatedDoc("test", "2", IRRELEVANT_RATING));
import java.util.Arrays;
            PrecisionAtK precicionAt = PrecisionAtK.fromXContent(parser);
        assertEquals(0.0d, evaluated.metricScore(), 0.00001);
 * the Apache License, Version 2.0 (the "License"); you may
}
        // also try with setting `ignore_unlabeled`
        }
        switch (randomIntBetween(0, 2)) {
        assertEquals(3, ((PrecisionAtK.Detail) evaluated.getMetricDetails()).getRetrieved());
        partialResults.add(new EvalQueryQuality("c", 0.6));
                    !original.getIgnoreUnlabeled(),
                throw new IllegalStateException("The test should only allow three parameters mutated");
import org.opensearch.search.SearchShardTarget;
    public void testCombine() {
        rated.add(createRatedDoc("test", "1", RELEVANT_RATING));
    public void testXContentParsingIsNotLenient() throws IOException {
        try (XContentParser itemParser = createParser(shuffled)) {
        List<RatedDocument> rated = new ArrayList<>();
            original.forcedSearchSize().getAsInt()
                break;
    }
        SearchHit[] hits = new SearchHit[rated.size()];
        expectThrows(IllegalArgumentException.class, () -> new PrecisionAtK(-1, false, 10));
        EvalQueryQuality evaluated = (new PrecisionAtK()).evaluate("id", hits, Collections.emptyList());
        List<RatedDocument> rated = new ArrayList<>();
        List<EvalQueryQuality> partialResults = new ArrayList<>(3);
        assertEquals((double) 2 / 3, evaluated.metricScore(), 0.00001);
import java.io.IOException;
 * KIND, either express or implied.  See the License for the
 */
        return new RatedDocument(index, id, rating);
    }
        assertEquals(0.0d, evaluated.metricScore(), 0.00001);
        rated.add(createRatedDoc("test", "4", 4));
        rated.add(createRatedDoc("test", "2", RELEVANT_RATING));
                    original.forcedSearchSize().getAsInt()
 * not use this file except in compliance with the License.
        rated.add(createRatedDoc("test", "0", RELEVANT_RATING));
        PrecisionAtK prec = new PrecisionAtK(true);
            case 0:
import org.opensearch.core.common.bytes.BytesReference;
        PrecisionAtK precisionAtN = new PrecisionAtK(2, false, 5);
            case 2:
            PrecisionAtK parsedItem = PrecisionAtK.fromXContent(itemParser);
 *
        partialResults.add(new EvalQueryQuality("a", 0.1));
import org.opensearch.test.OpenSearchTestCase;
        rated.add(createRatedDoc("test", "1", 1));
        try (XContentParser parser = createParser(xContentType.xContent(), withRandomFields)) {
 * this work for additional information regarding copyright
            new NamedWriteableRegistry(Collections.emptyList()),
        BytesReference originalBytes = toShuffledXContent(testItem, xContentType, ToXContent.EMPTY_PARAMS, randomBoolean());
 *
    }
    }
 * SPDX-License-Identifier: Apache-2.0
        expectThrows(IllegalArgumentException.class, () -> new PrecisionAtK(1, false, -10));
        assertEquals(2, ((PrecisionAtK.Detail) evaluated.getMetricDetails()).getRelevantRetrieved());
        rated.add(createRatedDoc("test", "0", RELEVANT_RATING));
        );
        rated.add(createRatedDoc("test", "3", 3));
                    original.getRelevantRatingThreshold(),
import static org.hamcrest.CoreMatchers.containsString;
/*
        evaluated = prec.evaluate("id", hits, Collections.emptyList());
                    original.getRelevantRatingThreshold(),
                break;
 * GitHub history for details.
import java.util.ArrayList;
    }
        assertEquals((double) 4 / 5, evaluated.metricScore(), 0.00001);
    public void testNoResults() throws Exception {
            assertThat(exception.getMessage(), containsString("[precision] unknown field"));
        PrecisionAtK original = createTestItem();
        assertEquals(0, ((PrecisionAtK.Detail) evaluated.getMetricDetails()).getRetrieved());
     * to be relevant
import org.opensearch.core.xcontent.XContentBuilder;
            itemParser.nextToken();
 * Modifications Copyright OpenSearch Contributors. See
        partialResults.add(new EvalQueryQuality("b", 0.2));
            itemParser.nextToken();
    private static PrecisionAtK mutate(PrecisionAtK original) {
        SearchHit[] hits = new SearchHit[0];
        SearchHit[] hits = new SearchHit[5];
        assertEquals(0, ((PrecisionAtK.Detail) evaluated.getMetricDetails()).getRetrieved());
    }
        EvalQueryQuality evaluated = (new PrecisionAtK()).evaluate("id", searchHits, rated);
                pAtK = new PrecisionAtK(
import org.opensearch.core.xcontent.ToXContent;
import org.opensearch.common.xcontent.json.JsonXContent;
        // add an unlabeled search hit
            case 1:
        assertEquals(5, ((PrecisionAtK.Detail) evaluated.getMetricDetails()).getRetrieved());
 * Licensed to Elasticsearch under one or more contributor
            original.getRelevantRatingThreshold(),
            assertEquals(testItem.hashCode(), parsedItem.hashCode());
        assertEquals((double) 2 / 3, evaluated.metricScore(), 0.00001);
        }
            original.getIgnoreUnlabeled(),
import org.opensearch.core.xcontent.XContentParseException;
        assertEquals(0.3, metric.combine(partialResults), Double.MIN_VALUE);
            default:
        return hits;
    public void testParseFromXContent() throws IOException {
        assertEquals(0, ((PrecisionAtK.Detail) evaluated.getMetricDetails()).getRelevantRetrieved());
        assertNotSame(deserialized, original);
import org.opensearch.core.index.shard.ShardId;
    }
            hits[i].shard(new SearchShardTarget("testnode", new ShardId(index, "uuid", 0), null, OriginalIndices.NONE));
     */
 * license agreements. See the NOTICE file distributed with
        PrecisionAtK prec = new PrecisionAtK(true);
 * Unless required by applicable law or agreed to in writing,
        PrecisionAtK pAtK;
            XContentParseException exception = expectThrows(XContentParseException.class, () -> PrecisionAtK.fromXContent(parser));
        String xContent = " {\n" + "   \"relevant_rating_threshold\" : 2" + "}";
        List<RatedDocument> rated = new ArrayList<>();
    }
        List<RatedDocument> rated = new ArrayList<>();
    public void testPrecisionAtFiveCorrectIndex() {
        BytesReference withRandomFields = insertRandomFields(xContentType, originalBytes, null, random());
/*
    public void testIgnoreUnlabeled() {
        rated.add(createRatedDoc("test", "0", RELEVANT_RATING));
        assertEquals(deserialized.hashCode(), original.hashCode());
    public void testNoRatedDocs() throws Exception {
import java.util.List;
        XContentBuilder builder = MediaTypeRegistry.contentBuilder(randomFrom(XContentType.values()));
        XContentBuilder shuffled = shuffleXContent(testItem.toXContent(builder, ToXContent.EMPTY_PARAMS));
    /**
     * test that the relevant rating threshold can be set to something larger than
    public void testXContentRoundtrip() throws IOException {
        // also try with setting `ignore_unlabeled`
        searchHits[2].shard(new SearchShardTarget("testnode", new ShardId("index", "uuid", 0), null, OriginalIndices.NONE));
        assertEquals(2, ((PrecisionAtK.Detail) evaluated.getMetricDetails()).getRelevantRetrieved());
 *    http://www.apache.org/licenses/LICENSE-2.0
                    original.getIgnoreUnlabeled(),
            hits[i].shard(new SearchShardTarget("testnode", new ShardId("index", "uuid", 0), null, OriginalIndices.NONE));
    }
    public void testSerialization() throws IOException {
     * 1. e.g. we set it to 2 here and expect docs 0-1 to be not relevant, docs 2-4
        rated.add(createRatedDoc("test_other", "1", RELEVANT_RATING));
    private static PrecisionAtK copy(PrecisionAtK original) {
    public void testCalculation() {
        checkEqualsAndHashCode(createTestItem(), PrecisionAtKTests::copy, PrecisionAtKTests::mutate);
 * ownership. Elasticsearch licenses this file to you under
 * software distributed under the License is distributed on an
 *
            assertEquals(2, precicionAt.getRelevantRatingThreshold());
    public static PrecisionAtK createTestItem() {
    public void testInvalidK() {
        evaluated = prec.evaluate("id", searchHits, rated);
                );
        return new PrecisionAtK(
        rated.add(createRatedDoc("test", "2", 2));
    }
                pAtK = new PrecisionAtK(
 * under the License.
import org.opensearch.common.xcontent.XContentType;
        rated.add(createRatedDoc("test", "1", RELEVANT_RATING));
        PrecisionAtK metric = new PrecisionAtK();
                    original.forcedSearchSize().getAsInt()
        }
 * this file be licensed under the Apache-2.0 license or a
    }
        EvalQueryQuality evaluated = (new PrecisionAtK()).evaluate("id", toSearchHits(rated, "test"), rated);
        rated.add(createRatedDoc("test", "1", RELEVANT_RATING));
        assertEquals(0, ((PrecisionAtK.Detail) evaluated.getMetricDetails()).getRelevantRetrieved());
        assertEquals(1, evaluated.metricScore(), 0.00001);
        assertEquals(1, ((PrecisionAtK.Detail) evaluated.getMetricDetails()).getRetrieved());
        rated.add(createRatedDoc("test", "0", 0));
        PrecisionAtK testItem = createTestItem();
        PrecisionAtK deserialized = OpenSearchTestCase.copyWriteable(
    public void testInvalidRelevantThreshold() {
            hits[i] = new SearchHit(i, i + "", Collections.emptyMap(), Collections.emptyMap());
    }
        assertEquals(3, ((PrecisionAtK.Detail) evaluated.getMetricDetails()).getRetrieved());
        for (int i = 0; i < rated.size(); i++) {
            assertNotSame(testItem, parsedItem);
        }
        assertEquals(4, ((PrecisionAtK.Detail) evaluated.getMetricDetails()).getRelevantRetrieved());
