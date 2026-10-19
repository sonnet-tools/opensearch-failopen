            ratedDocs.add(RatedDocumentTests.createRatedDocument());
            assertNotNull(specification.getEvaluationRequest());
            IllegalArgumentException.class,  
        BytesReference withRandomFields = insertRandomFields(xContentType, originalBytes, null, random());
        RatedRequest ratedRequest;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                }
        );
    }
        assertEquals(deserialized.hashCode(), original.hashCode());
        params.put("key", "value");  
            + "}\n";
import java.util.Map;
                    evaluationRequest = new SearchSourceBuilder();
            for (int i = 0; i < randomSize; i++) {
import org.opensearch.index.query.MatchAllQueryBuilder;  
            IllegalArgumentException.class,
            + "                       {\"match\": {\"beverage\": \"coffee\"}},\n"
    private static RatedRequest copy(RatedRequest original) throws IOException {  
        query.highlighter(new HighlightBuilder().field("field"));
            ex.getMessage()
    }  
        if (params.size() == 0) {
            assertThat(exception.getMessage(), containsString("unknown field"));  
 * GitHub history for details.
 * You may obtain a copy of the License at  
    public static RatedRequest createTestItem(boolean forceRequest) {
        XContentBuilder shuffled = shuffleXContent(testItem.toXContent(builder, ToXContent.EMPTY_PARAMS));
                break;
    }  
            case 3:
        }  
 * compatible open source license.
    }
        String querySpecString = " {\n"
 * Modifications Copyright OpenSearch Contributors. See
 * SPDX-License-Identifier: Apache-2.0
import java.util.HashMap;  
import java.io.IOException;  
            assertNotSame(testItem, parsedItem);
        Map<String, Object> params = new HashMap<>();
        assertEquals(
        Map<String, Object> params = original.getParams();
            assertEquals(3, ratedDocs.size());
        SearchSourceBuilder query = new SearchSourceBuilder();
        SearchSourceBuilder testRequest = null;  
            + "           },\n"
                .collect(toList())  
                break;  
                .flatMap(Function.identity())
        }
            }  
                throw new IllegalStateException("Requested to modify more than available parameters.");
    }
    public void testEqualsAndHash() throws IOException {  
        IllegalArgumentException e = expectThrows(
            ratedRequest = new RatedRequest(id, ratedDocs, evaluationRequest);  
    /**  
        for (int i = 0; i < size; i++) {
import org.opensearch.core.xcontent.ToXContent;
            Throwable exception = expectThrows(XContentParseException.class, () -> RatedRequest.fromXContent(parser));
            RatedRequest specification = RatedRequest.fromXContent(parser);  
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> new RatedRequest("id", ratedDocs, query));  
                }  
import static org.opensearch.test.EqualsHashCodeTestUtils.checkEqualsAndHashCode;
        if (evaluationRequest == null) {  
        String id = original.getId();
        List<RatedDocument> ratedDocs = Arrays.asList(new RatedDocument("index1", "id1", 1), new RatedDocument("index1", "id1", 5));
        List<String> summaryFields = original.getSummaryFields();  
    public void testXContentParsingIsNotLenient() throws IOException {
        if (randomBoolean() || forceRequest) {
        XContentBuilder builder = MediaTypeRegistry.contentBuilder(randomFrom(XContentType.values()));
        }
    protected NamedXContentRegistry xContentRegistry() {
 * this file be licensed under the Apache-2.0 license or a
 */  
        List<RatedDocument> ratedDocs = Arrays.asList(new RatedDocument("index1", "id1", 1));
import static java.util.stream.Collectors.toList;
 * under the License.  
        String requestId = randomAlphaOfLength(50);  
            + "   \"ratings\": [\n"  
    public void testSettingTemplateIdNoParamsThrows() {
                params.put(randomAlphaOfLengthBetween(1, 10), randomAlphaOfLengthBetween(1, 10));
            + "                   \"must\": [\n"
import org.opensearch.core.xcontent.MediaTypeRegistry;  
import org.opensearch.core.xcontent.XContentBuilder;  
    }
        List<RatedDocument> ratedDocs = Arrays.asList(new RatedDocument("index1", "id1", 1));
 * The OpenSearch Contributors require contributions made to  
            itemParser.nextToken();
            testRequest = new SearchSourceBuilder();
            RatedRequest parsedItem = RatedRequest.fromXContent(itemParser);  
    }
        RatedRequest ratedRequest = null;  
        expectThrows(NullPointerException.class, () -> request.addSummaryFields(null));
        checkEqualsAndHashCode(createTestItem(randomBoolean()), RatedRequestsTests::copy, RatedRequestsTests::mutateTestItem);
import org.junit.AfterClass;  
    }
        List<RatedDocument> ratedDocs = new ArrayList<>();
        }
        XContentType xContentType = randomFrom(XContentType.values());  
}
        xContentRegistry = null;  
            ratedRequest = new RatedRequest(requestId, ratedDocs, testRequest);
            + "                                  {\"value\": \"ams\",\"boost\": 10}}}]}\n"
                } else {
            + "   \"summary_fields\" : [\"title\"],\n"
            }
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> new RatedRequest("id", ratedDocs, query));
            + "                       {\"term\": {\"time_of_day\": "
        expectThrows(IllegalArgumentException.class, () -> new RatedRequest("id", ratedDocs, null, null));
    public void testDuplicateRatedDocThrowsException() {
    @Override  
            case 0:
            testRequest.query(new MatchAllQueryBuilder());
                ratedDocs = Arrays.asList(randomValueOtherThanMany(ratedDocs::contains, () -> RatedDocumentTests.createRatedDocument()));
 *  
    @BeforeClass
    public void testSettingParamsWithoutTemplateIdThrows() {  
     */  
 * Unless required by applicable law or agreed to in writing,
 *
            }
            + "   \"request\": {\n"
        );
        expectThrows(IllegalArgumentException.class, () -> new RatedRequest("id", ratedDocs, params, null));
/*
    public void testHighlighterNotAllowed() {
            + "                                  {\"value\": \"morning\",\"boost\": 2}}},\n"
                        mutated.putAll(params);
    public void testAggsNotAllowed() {  
    }  
        List<RatedDocument> ratedDocs = Arrays.asList(new RatedDocument("index1", "id1", 1));  
    public void testSuggestionsNotAllowed() {
        query.suggest(new SuggestBuilder().addSuggestion("id", SuggestBuilders.completionSuggestion("fieldname")));
                    assertEquals(0, ratedDocs.get(i).getRating());  
        List<String> summaryFields = new ArrayList<>();  
        );
        SearchSourceBuilder query = new SearchSourceBuilder();  
     * matter for parsing xContent
        int numSummaryFields = randomIntBetween(0, 5);
            testRequest.size(randomIntBetween(0, Integer.MAX_VALUE));  
                        templateId = randomValueOtherThan(templateId, () -> randomAlphaOfLength(5));  
        assertEquals("Query in rated requests should not use explain.", e.getMessage());  
        List<RatedDocument> ratedDocs = Arrays.asList(new RatedDocument("index1", "id1", 1));
import static org.opensearch.test.XContentTestUtils.insertRandomFields;  
            Stream.of(new SearchModule(Settings.EMPTY, emptyList()).getNamedXContents().stream())
    public void testExplainNotAllowed() {  
 * license agreements. See the NOTICE file distributed with
                assertEquals("test", ratedDocs.get(i).getIndex());
        Map<String, Object> params = new HashMap<>();
    public void testSettingNeitherParamsNorRequestThrows() {  
        assertNotNull(request.getParams());
     * test that modifying the order of index/docId to make sure it doesn't
            int randomSize = randomIntBetween(1, 10);  
        namedWriteables.add(new NamedWriteableRegistry.Entry(QueryBuilder.class, MatchAllQueryBuilder.NAME, MatchAllQueryBuilder::new));
    }
 *    http://www.apache.org/licenses/LICENSE-2.0
                exception = exception.getCause();
        List<RatedDocument> ratedDocs = Arrays.asList(new RatedDocument("index1", "id1", 1));
            "Found duplicate rated document key [{\"_index\":\"index1\",\"_id\":\"id1\"}] in evaluation request [test_query]",  
    }
    }
 */
                        Map<String, Object> mutated = new HashMap<>();
            List<RatedDocument> ratedDocs = specification.getRatedDocs();  
import java.util.Arrays;
    }
            + "                       {\"term\": {\"browser\": {\"value\": \"safari\"}}},\n"  
        assertEquals(
        );
    }
/*  
                summaryFields = Arrays.asList(randomValueOtherThanMany(summaryFields::contains, () -> randomAlphaOfLength(10)));
                    evaluationRequest.size(size);  
                    int size = randomValueOtherThan(evaluationRequest.size(), () -> randomInt(Integer.MAX_VALUE));
            IllegalArgumentException.class,  
            ratedRequest = new RatedRequest(requestId, ratedDocs, params, randomAlphaOfLength(5));
            ratedRequest = new RatedRequest(id, ratedDocs, params, templateId);
    }
import org.opensearch.core.xcontent.XContentParser;
        expectThrows(IllegalArgumentException.class, () -> new RatedRequest("id", ratedDocs, null, "templateId"));  
        assertEquals("Query in rated requests should not contain aggregations.", e.getMessage());
        RatedRequest request = new RatedRequest("id", ratedDocs, new SearchSourceBuilder());
        assertEquals(deserialized, original);
        expectThrows(IllegalArgumentException.class, () -> new RatedRequest("id", ratedDocs, new HashMap<>(), "templateId"));  
            summaryFields.add(randomAlphaOfLength(5));  
            + "                       {\"term\": {\"ip_location\": "  
            ratedRequest.addSummaryFields(summaryFields);  
            "Found duplicate rated document key [{\"_index\":\"index1\",\"_id\":\"id1\"}] in evaluation request [test_query]",
        List<RatedDocument> ratedDocs = Arrays.asList(new RatedDocument("index1", "id1", 1));  
 * ownership. Elasticsearch licenses this file to you under  
            case 2:
                assertThat(exception.getMessage(), containsString("[request] failed to parse field"));  
public class RatedRequestsTests extends OpenSearchTestCase {  
 * not use this file except in compliance with the License.
        String templateId = original.getTemplateId();
                } else {
        try (XContentParser itemParser = createParser(shuffled)) {  
            + "   },\n"
    private static RatedRequest mutateTestItem(RatedRequest original) {
/*  
import static java.util.Collections.emptyList;  
            ex.getMessage()  
        return OpenSearchTestCase.copyWriteable(original, new NamedWriteableRegistry(namedWriteables), RatedRequest::new);  
                break;  
        }
        query.aggregation(AggregationBuilders.terms("fieldName"));  
        Map<String, Object> params = new HashMap<>();
        List<RatedDocument> ratedDocs = Arrays.asList(new RatedDocument("index1", "id1", 1));  
        ex = expectThrows(IllegalArgumentException.class, () -> new RatedRequest("test_query", ratedDocs, params, "templateId"));
        xContentRegistry = new NamedXContentRegistry(  
import java.util.stream.Stream;
        } else {
import static org.hamcrest.Matchers.containsString;
            assertEquals(testItem, parsedItem);
import org.opensearch.common.xcontent.XContentType;
import org.opensearch.common.xcontent.json.JsonXContent;  
        RatedRequest testItem = createTestItem(randomBoolean());
 * specific language governing permissions and limitations
 * KIND, either express or implied.  See the License for the
                    } else {
                        mutated.put("one_more_key", "one_more_value");  
    }
 * this work for additional information regarding copyright
import org.opensearch.search.builder.SearchSourceBuilder;
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
        RatedRequest request = new RatedRequest("id", ratedDocs, new SearchSourceBuilder());
import org.opensearch.search.SearchModule;
    @AfterClass
                assertEquals("" + (i + 1), ratedDocs.get(i).getDocID());  
            ratedRequest.addSummaryFields(summaryFields);  
    public void testSerialization() throws IOException {
        return xContentRegistry;
 * software distributed under the License is distributed on an
        }
import org.opensearch.search.suggest.SuggestBuilder;  
        ratedRequest.addSummaryFields(summaryFields);
import org.opensearch.search.suggest.SuggestBuilders;
        RatedRequest original = createTestItem(randomBoolean());
        BytesReference originalBytes = toShuffledXContent(testItem, xContentType, ToXContent.EMPTY_PARAMS, randomBoolean());
        } else {
        switch (mutate) {
            + "        {\"_id\": \"3\", \"_index\": \"test\", \"rating\" : 1} ]"  
                break;  
        SearchSourceBuilder evaluationRequest = original.getEvaluationRequest();  
    public static void init() {
    }  
        List<RatedDocument> ratedDocs = original.getRatedDocs();
    public void testXContentRoundtrip() throws IOException {
import java.util.function.Function;  
            () -> new RatedRequest("id", ratedDocs, new SearchSourceBuilder().explain(true))
        }
package org.opensearch.index.rankeval;
        int mutate = randomIntBetween(0, 3);  
    public void testNullParamsTreatment() {
        params.put("key", "value");  
        );  
        return ratedRequest;
import org.opensearch.search.fetch.subphase.highlight.HighlightBuilder;
            case 1:
            + "               \"bool\": {\n"  
import org.opensearch.core.common.bytes.BytesReference;
        }  
                id = randomValueOtherThan(id, () -> randomAlphaOfLength(10));  
        IllegalArgumentException e = expectThrows(
                if (i == 1) {
                    assertEquals(1, ratedDocs.get(i).getRating());
        for (int i = 0; i < numSummaryFields; i++) {
            if (exception.getCause() != null) {
        );
            () -> new RatedRequest("id", ratedDocs, new SearchSourceBuilder().profile(true))
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> new RatedRequest("id", ratedDocs, query));
            + "        {\"_index\": \"test\" , \"_id\": \"1\", \"rating\" : 1 },\n"
    }
    }  
        List<NamedWriteableRegistry.Entry> namedWriteables = new ArrayList<>();
            + "   \"id\": \"my_qa_query\",\n"  
    public void testNullSummaryFieldsTreatment() {
import org.opensearch.search.aggregations.AggregationBuilders;  
 * the Apache License, Version 2.0 (the "License"); you may
        return ratedRequest;
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, querySpecString)) {
            for (int i = 0; i < 3; i++) {
        int size = randomIntBetween(0, 2);  
            + "        {\"_index\": \"test\", \"rating\" : 0, \"_id\": \"2\"},\n"
        SearchSourceBuilder query = new SearchSourceBuilder();
        }
import org.opensearch.common.settings.Settings;
            + "           \"size\": 10\n"  
        } else {
        RatedRequest deserialized = copy(original);  
import org.junit.BeforeClass;
                        params = mutated;
    }
        RatedRequest testItem = createTestItem(randomBoolean());  
            () -> new RatedRequest("test_query", ratedDocs, new SearchSourceBuilder())
    public static void afterClass() throws Exception {
    }
        List<RatedDocument> ratedDocs = Arrays.asList(new RatedDocument("index1", "id1", 1));
    public void testParseFromXContent() throws IOException {
            + "           \"query\": {\n"
            assertEquals(testItem.hashCode(), parsedItem.hashCode());  
import java.util.List;
import java.util.ArrayList;
 *
                    }
import org.opensearch.core.xcontent.XContentParseException;
            default:
            assertEquals("my_qa_query", specification.getId());
    }  
        List<RatedDocument> ratedDocs = Arrays.asList(new RatedDocument("index1", "id1", 1));
 */  
        assertEquals("Query in rated requests should not contain a highlighter section.", e.getMessage());  
        try (XContentParser parser = createParser(xContentType.xContent(), withRandomFields)) {  
    private static NamedXContentRegistry xContentRegistry;
        assertEquals("Query in rated requests should not use profile.", e.getMessage());  
        IllegalArgumentException ex = expectThrows(  
 * Licensed to Elasticsearch under one or more contributor  
                    evaluationRequest.query(new MatchAllQueryBuilder());
        List<RatedDocument> ratedDocs = Arrays.asList(new RatedDocument("index1", "id1", 1));
    public void testProfileNotAllowed() {  
        assertEquals("Query in rated requests should not contain a suggest section.", e.getMessage());
import org.opensearch.test.OpenSearchTestCase;
        assertNotSame(deserialized, original);  
                if (evaluationRequest != null) {  
import org.opensearch.core.xcontent.NamedXContentRegistry;
import org.opensearch.index.query.QueryBuilder;
        assertEquals(0, request.getParams().size());  
                    if (randomBoolean()) {  
