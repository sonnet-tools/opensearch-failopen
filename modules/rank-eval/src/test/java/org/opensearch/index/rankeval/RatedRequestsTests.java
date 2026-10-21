            IllegalArgumentException.class,
        return ratedRequest;
                    } else {
            + "                       {\"term\": {\"ip_location\": "
    public void testDuplicateRatedDocThrowsException() {
                    evaluationRequest = new SearchSourceBuilder();
        }
    @BeforeClass
import org.opensearch.common.settings.Settings;
                    }
/*
            + "        {\"_index\": \"test\" , \"_id\": \"1\", \"rating\" : 1 },\n"
 * under the License.
 * the Apache License, Version 2.0 (the "License"); you may
        return OpenSearchTestCase.copyWriteable(original, new NamedWriteableRegistry(namedWriteables), RatedRequest::new);
            + "           },\n"
import org.opensearch.core.common.bytes.BytesReference;
            ratedRequest.addSummaryFields(summaryFields);
    /**
import org.opensearch.search.fetch.subphase.highlight.HighlightBuilder;
public class RatedRequestsTests extends OpenSearchTestCase {
import org.opensearch.test.OpenSearchTestCase;
        assertEquals("Query in rated requests should not contain a highlighter section.", e.getMessage());
    }
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> new RatedRequest("id", ratedDocs, query));
            + "                                  {\"value\": \"morning\",\"boost\": 2}}},\n"
            assertThat(exception.getMessage(), containsString("unknown field"));
            + "           \"size\": 10\n"
        params.put("key", "value");
        XContentBuilder builder = MediaTypeRegistry.contentBuilder(randomFrom(XContentType.values()));
        assertEquals("Query in rated requests should not use explain.", e.getMessage());
            "Found duplicate rated document key [{\"_index\":\"index1\",\"_id\":\"id1\"}] in evaluation request [test_query]",
 * compatible open source license.
        } else {
        List<RatedDocument> ratedDocs = Arrays.asList(new RatedDocument("index1", "id1", 1));
    }
        List<RatedDocument> ratedDocs = Arrays.asList(new RatedDocument("index1", "id1", 1));
    }
            + "               \"bool\": {\n"
            + "           \"query\": {\n"
    }
        List<RatedDocument> ratedDocs = original.getRatedDocs();
        assertNotSame(deserialized, original);
        xContentRegistry = new NamedXContentRegistry(
 */
        expectThrows(IllegalArgumentException.class, () -> new RatedRequest("id", ratedDocs, null, "templateId"));
        }
    }
        RatedRequest original = createTestItem(randomBoolean());
        assertNotNull(request.getParams());
    private static NamedXContentRegistry xContentRegistry;
            assertEquals(testItem.hashCode(), parsedItem.hashCode());
 * SPDX-License-Identifier: Apache-2.0
 * GitHub history for details.
            itemParser.nextToken();
        checkEqualsAndHashCode(createTestItem(randomBoolean()), RatedRequestsTests::copy, RatedRequestsTests::mutateTestItem);
        Map<String, Object> params = new HashMap<>();
                assertEquals("" + (i + 1), ratedDocs.get(i).getDocID());
            ratedRequest = new RatedRequest(id, ratedDocs, evaluationRequest);
        expectThrows(IllegalArgumentException.class, () -> new RatedRequest("id", ratedDocs, null, null));
import org.opensearch.search.suggest.SuggestBuilders;
        try (XContentParser itemParser = createParser(shuffled)) {
            testRequest.query(new MatchAllQueryBuilder());
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
/*
            Stream.of(new SearchModule(Settings.EMPTY, emptyList()).getNamedXContents().stream())
    }
            assertEquals("my_qa_query", specification.getId());
        IllegalArgumentException e = expectThrows(
        if (params.size() == 0) {
        );
        XContentBuilder shuffled = shuffleXContent(testItem.toXContent(builder, ToXContent.EMPTY_PARAMS));
        SearchSourceBuilder testRequest = null;
import org.opensearch.common.xcontent.json.JsonXContent;
            ex.getMessage()
            RatedRequest specification = RatedRequest.fromXContent(parser);
            + "                   \"must\": [\n"
    @Override
            }
                } else {
            testRequest.size(randomIntBetween(0, Integer.MAX_VALUE));
        int size = randomIntBetween(0, 2);
    }
        List<RatedDocument> ratedDocs = Arrays.asList(new RatedDocument("index1", "id1", 1));
        );
        );
import org.opensearch.search.SearchModule;
        String requestId = randomAlphaOfLength(50);
        expectThrows(IllegalArgumentException.class, () -> new RatedRequest("id", ratedDocs, params, null));
    }
 * not use this file except in compliance with the License.
                assertEquals("test", ratedDocs.get(i).getIndex());
import java.util.ArrayList;
    }
            case 3:
        );
        namedWriteables.add(new NamedWriteableRegistry.Entry(QueryBuilder.class, MatchAllQueryBuilder.NAME, MatchAllQueryBuilder::new));
        params.put("key", "value");
            if (exception.getCause() != null) {
            ratedRequest = new RatedRequest(requestId, ratedDocs, testRequest);
package org.opensearch.index.rankeval;
 *
                } else {
        String id = original.getId();
import java.util.HashMap;
    public void testSettingTemplateIdNoParamsThrows() {
        List<RatedDocument> ratedDocs = Arrays.asList(new RatedDocument("index1", "id1", 1));
        assertEquals(
 * You may obtain a copy of the License at
                .collect(toList())
            + "   \"request\": {\n"
 */
    }
        SearchSourceBuilder query = new SearchSourceBuilder();
            "Found duplicate rated document key [{\"_index\":\"index1\",\"_id\":\"id1\"}] in evaluation request [test_query]",
            ratedRequest = new RatedRequest(requestId, ratedDocs, params, randomAlphaOfLength(5));
 * Licensed to Elasticsearch under one or more contributor
        int numSummaryFields = randomIntBetween(0, 5);
import org.opensearch.core.xcontent.XContentBuilder;
    public void testXContentRoundtrip() throws IOException {
    public void testSerialization() throws IOException {
            summaryFields.add(randomAlphaOfLength(5));
        }
    public void testNullSummaryFieldsTreatment() {
        }
        return ratedRequest;
                break;
import java.util.Map;
        String querySpecString = " {\n"
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, querySpecString)) {
                        mutated.put("one_more_key", "one_more_value");
                if (i == 1) {
        query.suggest(new SuggestBuilder().addSuggestion("id", SuggestBuilders.completionSuggestion("fieldname")));
    }
 * this file be licensed under the Apache-2.0 license or a
import static java.util.Collections.emptyList;
import org.opensearch.core.xcontent.ToXContent;
        BytesReference originalBytes = toShuffledXContent(testItem, xContentType, ToXContent.EMPTY_PARAMS, randomBoolean());
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> new RatedRequest("id", ratedDocs, query));
    public void testProfileNotAllowed() {
 *
            ex.getMessage()
        List<RatedDocument> ratedDocs = Arrays.asList(new RatedDocument("index1", "id1", 1));
}
import static org.opensearch.test.XContentTestUtils.insertRandomFields;
                        Map<String, Object> mutated = new HashMap<>();
        xContentRegistry = null;
        try (XContentParser parser = createParser(xContentType.xContent(), withRandomFields)) {
        );
        Map<String, Object> params = original.getParams();
 * software distributed under the License is distributed on an
        assertEquals("Query in rated requests should not use profile.", e.getMessage());
            testRequest = new SearchSourceBuilder();
        XContentType xContentType = randomFrom(XContentType.values());
        RatedRequest ratedRequest = null;
            + "                       {\"term\": {\"time_of_day\": "
                }
            int randomSize = randomIntBetween(1, 10);
        query.aggregation(AggregationBuilders.terms("fieldName"));
    public void testEqualsAndHash() throws IOException {
            + "                                  {\"value\": \"ams\",\"boost\": 10}}}]}\n"
    private static RatedRequest copy(RatedRequest original) throws IOException {
 *    http://www.apache.org/licenses/LICENSE-2.0
            assertEquals(3, ratedDocs.size());
        ratedRequest.addSummaryFields(summaryFields);
import java.io.IOException;
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
        String templateId = original.getTemplateId();
        List<RatedDocument> ratedDocs = Arrays.asList(new RatedDocument("index1", "id1", 1));
                    evaluationRequest.query(new MatchAllQueryBuilder());
        SearchSourceBuilder query = new SearchSourceBuilder();
import org.junit.AfterClass;
        int mutate = randomIntBetween(0, 3);
import org.opensearch.core.xcontent.XContentParseException;
                params.put(randomAlphaOfLengthBetween(1, 10), randomAlphaOfLengthBetween(1, 10));
            () -> new RatedRequest("id", ratedDocs, new SearchSourceBuilder().explain(true))
        } else {
import static org.hamcrest.Matchers.containsString;
    public static void afterClass() throws Exception {
    public void testSuggestionsNotAllowed() {
    protected NamedXContentRegistry xContentRegistry() {
        RatedRequest testItem = createTestItem(randomBoolean());
            case 2:
import org.opensearch.index.query.QueryBuilder;
                ratedDocs = Arrays.asList(randomValueOtherThanMany(ratedDocs::contains, () -> RatedDocumentTests.createRatedDocument()));
    public void testSettingNeitherParamsNorRequestThrows() {
    }
        );
/*
    public void testNullParamsTreatment() {
            + "   },\n"
import java.util.List;
        List<NamedWriteableRegistry.Entry> namedWriteables = new ArrayList<>();
            assertNotSame(testItem, parsedItem);
    }
        RatedRequest request = new RatedRequest("id", ratedDocs, new SearchSourceBuilder());
        assertEquals(deserialized.hashCode(), original.hashCode());
        return xContentRegistry;
        for (int i = 0; i < size; i++) {
        List<RatedDocument> ratedDocs = Arrays.asList(new RatedDocument("index1", "id1", 1));
            + "   \"summary_fields\" : [\"title\"],\n"
                assertThat(exception.getMessage(), containsString("[request] failed to parse field"));
                break;
import org.opensearch.search.aggregations.AggregationBuilders;
                    assertEquals(1, ratedDocs.get(i).getRating());
import org.opensearch.core.xcontent.XContentParser;
import static org.opensearch.test.EqualsHashCodeTestUtils.checkEqualsAndHashCode;
            assertNotNull(specification.getEvaluationRequest());
                        params = mutated;
            + "        {\"_index\": \"test\", \"rating\" : 0, \"_id\": \"2\"},\n"
    }
    public void testExplainNotAllowed() {
            ratedDocs.add(RatedDocumentTests.createRatedDocument());
        expectThrows(IllegalArgumentException.class, () -> new RatedRequest("id", ratedDocs, new HashMap<>(), "templateId"));
        Map<String, Object> params = new HashMap<>();
            case 1:
import org.junit.BeforeClass;
        }
        RatedRequest ratedRequest;
        assertEquals(0, request.getParams().size());
                        templateId = randomValueOtherThan(templateId, () -> randomAlphaOfLength(5));
 *
import org.opensearch.search.suggest.SuggestBuilder;
    public void testXContentParsingIsNotLenient() throws IOException {
     */
        }
 * this work for additional information regarding copyright
            + "   \"ratings\": [\n"
        assertEquals(
 * Unless required by applicable law or agreed to in writing,
    public void testParseFromXContent() throws IOException {
        expectThrows(NullPointerException.class, () -> request.addSummaryFields(null));
import java.util.function.Function;
            RatedRequest parsedItem = RatedRequest.fromXContent(itemParser);
 * license agreements. See the NOTICE file distributed with
                .flatMap(Function.identity())
                    assertEquals(0, ratedDocs.get(i).getRating());
        SearchSourceBuilder evaluationRequest = original.getEvaluationRequest();
    }
        }
        if (randomBoolean() || forceRequest) {
    private static RatedRequest mutateTestItem(RatedRequest original) {
                break;
                if (evaluationRequest != null) {
            for (int i = 0; i < 3; i++) {
            default:
                    if (randomBoolean()) {
        BytesReference withRandomFields = insertRandomFields(xContentType, originalBytes, null, random());
            ratedRequest.addSummaryFields(summaryFields);
        List<RatedDocument> ratedDocs = Arrays.asList(new RatedDocument("index1", "id1", 1));
 * ownership. Elasticsearch licenses this file to you under
                summaryFields = Arrays.asList(randomValueOtherThanMany(summaryFields::contains, () -> randomAlphaOfLength(10)));
            IllegalArgumentException.class,
    }
            List<RatedDocument> ratedDocs = specification.getRatedDocs();
        query.highlighter(new HighlightBuilder().field("field"));
    public void testSettingParamsWithoutTemplateIdThrows() {
        }
        List<RatedDocument> ratedDocs = new ArrayList<>();
        ex = expectThrows(IllegalArgumentException.class, () -> new RatedRequest("test_query", ratedDocs, params, "templateId"));
    public void testHighlighterNotAllowed() {
 * specific language governing permissions and limitations
import org.opensearch.index.query.MatchAllQueryBuilder;
import static java.util.stream.Collectors.toList;
import java.util.stream.Stream;
            Throwable exception = expectThrows(XContentParseException.class, () -> RatedRequest.fromXContent(parser));
import java.util.Arrays;
            + "                       {\"term\": {\"browser\": {\"value\": \"safari\"}}},\n"
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> new RatedRequest("id", ratedDocs, query));
            () -> new RatedRequest("test_query", ratedDocs, new SearchSourceBuilder())
                    evaluationRequest.size(size);
import org.opensearch.core.xcontent.MediaTypeRegistry;
        List<String> summaryFields = new ArrayList<>();
                }
    public static void init() {
        }
            + "}\n";
        IllegalArgumentException e = expectThrows(
 */
        RatedRequest testItem = createTestItem(randomBoolean());
            ratedRequest = new RatedRequest(id, ratedDocs, params, templateId);
                exception = exception.getCause();
                throw new IllegalStateException("Requested to modify more than available parameters.");
    public void testAggsNotAllowed() {
 * KIND, either express or implied.  See the License for the
    }
            + "   \"id\": \"my_qa_query\",\n"
        SearchSourceBuilder query = new SearchSourceBuilder();
import org.opensearch.core.xcontent.NamedXContentRegistry;
            for (int i = 0; i < randomSize; i++) {
        assertEquals("Query in rated requests should not contain a suggest section.", e.getMessage());
    @AfterClass
        List<String> summaryFields = original.getSummaryFields();
    public static RatedRequest createTestItem(boolean forceRequest) {
            case 0:
 * Modifications Copyright OpenSearch Contributors. See
    }
 * The OpenSearch Contributors require contributions made to
            IllegalArgumentException.class,
    }
    }
        switch (mutate) {
            + "        {\"_id\": \"3\", \"_index\": \"test\", \"rating\" : 1} ]"
        } else {
        RatedRequest request = new RatedRequest("id", ratedDocs, new SearchSourceBuilder());
     * matter for parsing xContent
        List<RatedDocument> ratedDocs = Arrays.asList(new RatedDocument("index1", "id1", 1));
            () -> new RatedRequest("id", ratedDocs, new SearchSourceBuilder().profile(true))
        if (evaluationRequest == null) {
        List<RatedDocument> ratedDocs = Arrays.asList(new RatedDocument("index1", "id1", 1));
    }
            + "                       {\"match\": {\"beverage\": \"coffee\"}},\n"
                id = randomValueOtherThan(id, () -> randomAlphaOfLength(10));
                break;
        List<RatedDocument> ratedDocs = Arrays.asList(new RatedDocument("index1", "id1", 1), new RatedDocument("index1", "id1", 5));
            }
        Map<String, Object> params = new HashMap<>();
        assertEquals(deserialized, original);
        RatedRequest deserialized = copy(original);
        IllegalArgumentException ex = expectThrows(
            }
import org.opensearch.search.builder.SearchSourceBuilder;
                    int size = randomValueOtherThan(evaluationRequest.size(), () -> randomInt(Integer.MAX_VALUE));
        assertEquals("Query in rated requests should not contain aggregations.", e.getMessage());
        for (int i = 0; i < numSummaryFields; i++) {
     * test that modifying the order of index/docId to make sure it doesn't
                        mutated.putAll(params);
import org.opensearch.common.xcontent.XContentType;
            assertEquals(testItem, parsedItem);
    }
