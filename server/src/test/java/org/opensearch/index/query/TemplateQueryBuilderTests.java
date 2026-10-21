        bool.put("must", must);
        assertEquals(
     */
import static org.mockito.ArgumentMatchers.any;
                + "  \"bool\" : {\n"
        assertFalse(builder1.hashCode() == builder3.hashCode());
        Map<String, Object> contextVariables = new HashMap<>();
        );
        contextVariables.put("minAge", 25);
        QueryCoordinatorContext queryRewriteContext = mockQueryRewriteContext();
    }
        Map<String, Object> content = new HashMap<>();
 */
    /**
     * Tests the doRewrite method of TemplateQueryBuilder with a simple term query.
        term.put("message", message);
        assertTrue(exception.getMessage().contains("Unclosed variable in template"));
                + "    \"pin.location\" : [\n"
        Map<String, Object> message = new HashMap<>();
    public void testDoRewriteWithMalformedVariableSubstitution() throws IOException {
    }
            () -> templateQueryBuilder.doRewrite(queryRewriteContext)
        template.put("malformed_json", "{ this is not valid JSON }");
            newQuery.toString()
                + "      \"bar\"\n"
                + "      \"include_upper\" : true,\n"
     * Verifies that the template is correctly rewritten to a TermQueryBuilder.
                + "          }\n"
                "term": {
        assertTrue(parsed instanceof TemplateQueryBuilder);
        GeoPoint geoPoint = new GeoPoint(40, -70);
    }
        TemplateQueryBuilder deserialized = new TemplateQueryBuilder(in);
        Map<String, Object> age = new HashMap<>();
     * Verifies that an IOException is thrown when the query JSON is malformed.
     */
     * Verifies that a builder can be written to a stream and read back correctly.
            + "        \"shape\": {\n"
                + "        \"match\" : {\n"
            IllegalArgumentException.class,
        contentParser.nextToken();
        Map<String, Object> geoDistance = new HashMap<>();
        assertTrue(exception.getMessage().contains("Variable not found"));
                + "      }\n"
                + "    \"boost\" : 1.0\n"
                + "  }\n"
        when(queryRewriteContext.getContextVariables()).thenReturn(contextVariables);
        assertEquals(newQuery, termQueryBuilder);
     */
        content2.put("key", "value");
        must.add(match);
            return null;
     * Tests the equals and hashCode methods of TemplateQueryBuilder.
    }
        message.put("value", "foo");
import org.opensearch.core.common.io.stream.StreamInput;
                + "            \"operator\" : \"OR\",\n"
import org.opensearch.common.xcontent.XContentFactory;
        doAnswer(invocation -> {
        Map<String, Object> textEntry = new HashMap<>();
        Map<String, Object> match = new HashMap<>();
                + "      -70.0,\n"
        shouldMatch1.put("match", shouldTextEntry1);
        template.put("invalid_query_type", new HashMap<>());
        parser.nextToken();
    public void testConstructorAndGetters() {
                + "            \"max_expansions\" : 50,\n"
                + "            \"fuzzy_transpositions\" : true,\n"
        Map<String, Object> term = new HashMap<>();
                + "        }\n"
                + "            \"query\" : \"love\",\n"
    public void testDoRewriteWithRangeQuery() throws IOException {
 *
        assertEquals(
                + "  }\n"
        when(queryRewriteContext.getXContentRegistry()).thenReturn(TEST_XCONTENT_REGISTRY_FOR_QUERY);
    }
        );
        assertEquals(NAME, templateQueryBuilder.getWriteableName());
                + "            \"max_expansions\" : 50,\n"
        TermQueryBuilder newQuery = (TermQueryBuilder) templateQueryBuilder.doRewrite(queryRewriteContext);
        TemplateQueryBuilder templateQueryBuilder = TemplateQueryBuilder.fromXContent(contentParser);
            () -> templateQueryBuilder.doRewrite(queryRewriteContext)
        assertEquals(newQuery, termQueryBuilder);
        assertEquals("Template string cannot be null. A valid template must be provided.", exception.getMessage());
        );
import org.opensearch.core.xcontent.DeprecationHandler;
        Map<String, Object> content = new HashMap<>();
     */
     */
        content.put("key", "value");
        Map<String, Object> message = new HashMap<>();
        Map<String, Object> shouldTextEntry2 = new HashMap<>();
                )
     */
     * Tests the constructor and getter methods of TemplateQueryBuilder.
                + "            \"boost\" : 1.0\n"
            .minimumShouldMatch(1);
 * The OpenSearch Contributors require contributions made to
    }
        Map<String, Object> terms = new HashMap<>();
                + "            \"zero_terms_query\" : \"NONE\",\n"
        assertEquals(
        StreamInput in = out.bytes().streamInput();
        geoDistance.put("distance", "12km");
                + "    \"age\" : {\n"
        Map<String, Object> geoShape = new HashMap<>();
        template.put("bool", bool);
    public void testReplaceVariablesWithEmptyTemplate() {
        assertEquals(parsed.getContent(), deserializedQuery.getContent());
            }
        Map<String, Object> template = new HashMap<>();
                + "  }\n"
        when(queryRewriteContext.getContextVariables()).thenReturn(contextVariables);
     */
                + "    \"should\" : [\n"
     */
        Map<String, Object> actualJson = jsonParser.map();
/*
import org.opensearch.core.xcontent.NamedXContentRegistry;
    /**
        assertTrue(builder1.hashCode() == builder2.hashCode());
                + "            \"auto_generate_synonyms_phrase_query\" : true,\n"
        expectedContent.put("geo_shape", geoShape);
        shouldMatch2.put("match", shouldTextEntry2);
        XContentBuilder xContentBuilder = XContentFactory.jsonBuilder().map(template);
            + "      \"boost\": 42.0\n"
        Map<String, Object> message = new HashMap<>();
    /**
            .createParser(xContentRegistry(), DeprecationHandler.THROW_UNSUPPORTED_OPERATION, jsonString);
                + "            \"value\" : \"Romeo and Juliet\",\n"
    /**
            IllegalArgumentException.class,
        assertEquals(expectedQuery, newQuery);
     * Tests the replaceVariables method when the variables map is null.
     * Tests parsing a TemplateQueryBuilder from a JSON string.
                + "            \"zero_terms_query\" : \"NONE\",\n"
        Map<String, Object> term = new HashMap<>();
        when(queryRewriteContext.getContextVariables()).thenReturn(contextVariables);
    public void testDoRewriteWithGeoDistanceQuery() throws IOException {
                + "    \"validation_method\" : \"STRICT\",\n"
        QueryCoordinatorContext queryRewriteContext = mockQueryRewriteContext();
                + "      {\n"
import org.opensearch.common.geo.GeoPoint;
                + "  }\n"
            + "      \"ignore_unmapped\": false,\n"
        when(queryRewriteContext.getContextVariables()).thenReturn(contextVariables);
        Map<String, Object> template = new HashMap<>();
        Map<String, Object> contextVariables = new HashMap<>();
        termsList.add("bar");
        BytesStreamOutput out = new BytesStreamOutput();
                + "        \"term\" : {\n"
        QueryCoordinatorContext queryRewriteContext = mockQueryRewriteContext();
        Map<String, Object> template = new HashMap<>();
     */
        Map<String, Object> term = new HashMap<>();
                + "    }\n"
        List<Map<String, Object>> must = new ArrayList<>();
    public void testQuerySource() {
     * Tests the doRewrite method with a malformed JSON query.
 * compatible open source license.
    public void testDoRewriteWithInvalidQueryType() throws IOException {
            IllegalArgumentException.class,
        QueryCoordinatorContext queryRewriteContext = mockQueryRewriteContext();
        Map<String, Object> term = new HashMap<>();
package org.opensearch.index.query;
        term.put("message", message);
        );
        QueryCoordinatorContext queryRewriteContext = mockQueryRewriteContext();
        QueryBuilder newQuery = templateQueryBuilder.doRewrite(queryRewriteContext);
        contextVariables.put("response", termsList);
     * Tests the doRewrite method with an invalid query type.
                + "  \"geo_distance\" : {\n"
        QueryCoordinatorContext queryRewriteContext = mockQueryRewriteContext();
        String jsonString = "{\n"
        );
        IllegalArgumentException exception = expectThrows(
        QueryCoordinatorContext queryRewriteContext = mockQueryRewriteContext();
        expectedQuery.gte(25).lte(35);
                + "  \"term\" : {\n"
        Map<String, Object> term = new HashMap<>();
                + "    \"distance\" : 12000.0,\n"
     * Verifies that the template is correctly rewritten with the variable substituted.
                + "  }\n"
                + "}",
        TemplateQueryBuilder templateQueryBuilder = new TemplateQueryBuilder(template);
    }
import java.util.Map;
        QueryCoordinatorContext queryRewriteContext = mockQueryRewriteContext();
    /**
            "{\n"
        when(queryRewriteContext.getContextVariables()).thenReturn(contextVariables);
                + "    ],\n"
        message.put("value", "${response");
        Map<String, Object> template = new HashMap<>();
import org.opensearch.common.io.stream.BytesStreamOutput;
        contextVariables.put("response", "foo");
                    "value": "foo"
import java.util.ArrayList;
        QueryBuilder newQuery = templateQueryBuilder.doRewrite(queryRewriteContext);
        QueryCoordinatorContext queryRewriteContext = mockQueryRewriteContext();
        StreamInput in = out.bytes().streamInput();
    /**
        match.put("match", textEntry);
                + "      \"boost\" : 1.0\n"
        message.put("value", "foo");
     * Verifies that calling doToQuery throws an IllegalStateException.
            "{\n"
     * Tests the doRewrite method with an invalid matchall query.
    }
        QueryBuilder newQuery = templateQueryBuilder.doRewrite(queryRewriteContext);
    public void testDoRewriteWithNotFoundVariableSubstitution() throws IOException {
                ActionListener.wrap(
                + "      \"to\" : 35,\n"
    public void testDoRewrite() throws IOException {
        assertEquals(original, deserialized);
    /**
        );
        SearchSourceBuilder source = new SearchSourceBuilder().query(templateQueryBuilder);
        geoShape.put("location", location);
                null,
            IllegalArgumentException.class,
        XContentParser contentParser = createParser(xContentBuilder);
    }
    private QueryCoordinatorContext mockQueryRewriteContext() {
            + "        \"relation\": \"intersects\"\n"
        Map<String, Object> message = new HashMap<>();
            + "    }\n"
    }
     * Tests the doToQuery method of TemplateQueryBuilder.
        SearchSourceBuilder source = new SearchSourceBuilder().query(incomingQuery);
        parsed.doXContent(builder, ToXContent.EMPTY_PARAMS);
        Map<String, Object> template = new HashMap<>();
        template.put("term", term);
                    err -> fail("Failed to set query tokens supplier: " + err.getMessage())
        TemplateQueryBuilder parsed = TemplateQueryBuilder.fromXContent(parser);
        Map<String, Object> contextVariables = new HashMap<>();
        TemplateQueryBuilder builder = new TemplateQueryBuilder(content);
}
        assertTrue(builder1.equals(builder2));
        );
        contextVariables.put("maxAge", 35);
        Map<String, Object> shouldMatch1 = new HashMap<>();
              }
     * Verifies that the correct query source is generated from a TemplateQueryBuilder.
        BytesStreamOutput out = new BytesStreamOutput();
        parsed.writeTo(out);
                + "            \"operator\" : \"OR\",\n"
                + "}",
                + "            \"boost\" : 1.0\n"
    }
        Map<String, Object> content2 = new HashMap<>();
     * Tests the fromXContent method of TemplateQueryBuilder.
        template.put("term", term);
        TemplateQueryBuilder templateQueryBuilder = new TemplateQueryBuilder(template);
        XContentParser jsonParser = XContentType.JSON.xContent()
        assertEquals(source.toString(), "{\"query\":{\"template\":{\"term\":{\"message\":{\"value\":\"foo\"}}}}}");
     * Verifies that a TemplateQueryBuilder can be correctly created from XContent.
        assertNotNull(parsed);
        */
    }
        expectedJson.put("template", template);
import java.util.HashMap;
        );
        should.add(shouldMatch1);
        contextVariables.put("keyword", "love");
     * Verifies that the template is correctly rewritten for a geo_distance query.
    /**
                + "          \"play_name\" : {\n"
        shape.put("type", "Envelope");
            new SearchModule(Settings.EMPTY, List.of()).getNamedXContents()
        when(queryRewriteContext.getContextVariables()).thenReturn(new HashMap<>());
    /**
            .filter(new TermQueryBuilder("play_name", "Romeo and Juliet"))
                + "            \"lenient\" : false,\n"
        Map<String, Object> contextVariables = new HashMap<>();
        assertEquals(
        geoDistance.put("pin.location", "${geoPoint}");
        contextVariables.put("response1", "foo");
     */
        TemplateQueryBuilder deserializedQuery = new TemplateQueryBuilder(in);
        terms.put("message", "${response}");
     * Verifies that the method returns the original template unchanged,
        Map<String, Object> message = new HashMap<>();
        assertEquals(expectedQuery, newQuery);
                + "      },\n"
                + "  \"term\" : {\n"
            "{\n"
        assertEquals("Template string cannot be empty. A valid template must be provided.", exception.getMessage());
     */
        Map<String, Object> template = new HashMap<>();
        Map<String, Object> shouldMatch2 = new HashMap<>();
                + "        }\n"
        when(queryRewriteContext.getContextVariables()).thenReturn(new HashMap<>());
        Map<String, Object> term = new HashMap<>();
        TermsQueryBuilder newQuery = (TermsQueryBuilder) templateQueryBuilder.doRewrite(queryRewriteContext);
        Map<String, Object> contextVariables = new HashMap<>();
        range.put("age", age);
        Map<String, Object> template = new HashMap<>();
     * Tests the doRewrite method of TemplateQueryBuilder with a range query.
        geoShape.put("ignore_unmapped", false);
        contextVariables.put("geoPoint", geoPoint);
        original.writeTo(out);
        NamedXContentRegistry TEST_XCONTENT_REGISTRY_FOR_QUERY = new NamedXContentRegistry(
            newQuery.toString()
        XContentParser parser = XContentType.JSON.xContent()
                + "    \"ignore_unmapped\" : false,\n"
                + "      {\n"
            IllegalArgumentException.class,
     * since a null variables map is treated as no replacement.
        return queryRewriteContext;
            () -> templateQueryBuilder.doRewrite(queryRewriteContext)
     * Verifies that the parsed query matches the expected structure and can be serialized and deserialized.
     * Verifies that an IOException is thrown when a malformed variable is used.
        assertEquals(NAME, builder.getWriteableName());
    /**
     */
                + "    }\n"
        Map<String, Object> range = new HashMap<>();
        Map<String, Object> content3 = new HashMap<>();
            biConsumer.accept(
            + "        },\n"
import org.opensearch.core.xcontent.ToXContent;
        TemplateQueryBuilder templateQueryBuilder = new TemplateQueryBuilder(template);
        NamedXContentRegistry TEST_XCONTENT_REGISTRY_FOR_QUERY = new NamedXContentRegistry(
import org.opensearch.search.SearchModule;
                + "      {\n"
     */
    }
        assertEquals(
                + "    \"message\" : {\n"
        Map<String, Object> template = new HashMap<>();
        );
    /**
            "{\n"
        template.put("geo_distance", geoDistance);
        content.put("key", "value");
        QueryCoordinatorContext queryRewriteContext = mockQueryRewriteContext();
        expectThrows(IllegalStateException.class, () -> builder.doToQuery(mockContext));
        TemplateQueryBuilder templateQueryBuilder = new TemplateQueryBuilder(template);
        Map<String, Object> expectedContent = new HashMap<>();
        Map<String, Object> shape = new HashMap<>();
                + "          }\n"
        assertEquals(
            () -> templateQueryBuilder.doRewrite(queryRewriteContext)
    /**
        );
                + "        }\n"
                + "            \"boost\" : 1.0\n"
                + "      \"include_lower\" : true,\n"
            {
        assertEquals(expectedJson, actualJson);
     * Verifies that an IOException is thrown when an invalid matchall query is used.
            "{\n"
                + "            \"query\" : \"grace\",\n"
    }
import org.opensearch.core.xcontent.XContentParser;
        TemplateQueryBuilder templateQueryBuilder = new TemplateQueryBuilder(template);
     */
    }
     * Verifies that the template is correctly rewritten with the list variable substituted.
        TermsQueryBuilder termsQueryBuilder = new TermsQueryBuilder("message", termsList);
        Map<String, Object> template = new HashMap<>();
        TemplateQueryBuilder templateQueryBuilder = new TemplateQueryBuilder(template);
        Map<String, Object> template = new HashMap<>();
        TemplateQueryBuilder templateQueryBuilder = new TemplateQueryBuilder(template);
        Map<String, Object> template = new HashMap<>();
        content1.put("key", "value");
        location.put("relation", "intersects");
        age.put("lte", "${maxAge}");
            .should(new MatchQueryBuilder("text_entry", "life"))
        IllegalArgumentException exception = expectThrows(
        when(queryRewriteContext.getContextVariables()).thenReturn(contextVariables);
            newQuery.toString()
                + "    \"minimum_should_match\" : \"1\",\n"
    public void testDoRewriteWithInvalidMatchAllQuery() throws IOException {
        when(queryRewriteContext.getContextVariables()).thenReturn(new HashMap<>());
                + "    }\n"
                + "  \"terms\" : {\n"
    }
                + "          \"text_entry\" : {\n"
     */
                  "message": {
        );
        Map<String, Object> contextVariables = new HashMap<>();
     * Tests the query source generation of TemplateQueryBuilder.
        term.put("play_name", "Romeo and Juliet");
                + "    \"message\" : {\n"
     * Tests the doRewrite method of TemplateQueryBuilder with a nested map variable.
        RangeQueryBuilder expectedQuery = new RangeQueryBuilder("age");
                + "            \"zero_terms_query\" : \"NONE\",\n"
        Map<String, Object> template = new HashMap<>();
        Map<String, Object> actualContent = new HashMap<>();
                + "  }\n"
                + "      \"from\" : 25,\n"
        Map<String, Object> template = new HashMap<>();
                + "        }\n"
                + "    ],\n"
     * Tests the doRewrite method of TemplateQueryBuilder with a list variable.
        when(queryRewriteContext.getContextVariables()).thenReturn(contextVariables);
     * Verifies that an IOException is thrown when an invalid query type is used.
import org.opensearch.transport.client.Client;
              "template": {
                + "  \"term\" : {\n"
                + "            \"boost\" : 1.0\n"
        content3.put("key", "different_value");
        Map<String, Object> template = new HashMap<>();
        shape.put("coordinates", "${modelPredictionOutcome}");
    public void testDoRewriteWithMissingBracketVariable() throws IOException {
     * Verifies that an IllegalArgumentException is thrown with the appropriate error message.
    public void testDoRewriteWithString() throws IOException {
        assertTrue(exception.getMessage().contains("Failed to rewrite template query"));
                + "    \"message\" : [\n"
                + "    }\n"
     * Tests the replaceVariables method when the template is empty.
                    response -> inProgressLatch.countDown(),
    /**
     */
        TermQueryBuilder termQueryBuilder = new TermQueryBuilder("message", "foo");
        when(queryRewriteContext.getContextVariables()).thenReturn(contextVariables);
        Map<String, Object> message = new HashMap<>();
        );
        /*
        TermQueryBuilder termQueryBuilder = new TermQueryBuilder("message", "foo");
        TermQueryBuilder newQuery = (TermQueryBuilder) templateQueryBuilder.doRewrite(queryRewriteContext);
        QueryCoordinatorContext queryRewriteContext = mockQueryRewriteContext();
    public void testFromXContent() throws IOException {
            IllegalArgumentException.class,
     * Tests the replaceVariables method when the template is null.
        QueryShardContext mockContext = mock(QueryShardContext.class);
        }).when(queryRewriteContext).registerAsyncAction(any());
        filter.put("term", term);
        message.put("value", "foo");
        template.put("range", range);
                + "      \"boost\" : 1.0\n"
                + "      {\n"
        shouldTextEntry1.put("text_entry", "life");
                + "      \"value\" : \"foo\",\n"
    public void testDoRewriteWithMissingRequiredField() throws IOException {
        Map<String, Object> content1 = new HashMap<>();
        );
                + "}",
            IllegalArgumentException.class,
                + "      \"foo\",\n"
        template.put("term", term);
    /**
                + "    ],\n"
    /**
        when(queryRewriteContext.getXContentRegistry()).thenReturn(TEST_XCONTENT_REGISTRY_FOR_QUERY);
        TemplateQueryBuilder builder3 = new TemplateQueryBuilder(content3);
        builder.startObject();
        // Check if the content of the parsed query matches the expected content
        assertEquals(newQuery, termQueryBuilder);
        template.put("matchall_1", new HashMap<>());
     * Verifies that the template is correctly rewritten with the nested map variable substituted.
        Map<String, Object> template = new HashMap<>();
        TemplateQueryBuilder templateQueryBuilder = new TemplateQueryBuilder(template);
     * Tests the doRewrite method of TemplateQueryBuilder with a geo_distance query.
                + "          }\n"
                + "            \"prefix_length\" : 0,\n"
            .createParser(xContentRegistry(), DeprecationHandler.THROW_UNSUPPORTED_OPERATION, builder.toString());
        QueryCoordinatorContext queryRewriteContext = mockQueryRewriteContext();
        QueryCoordinatorContext queryRewriteContext = mockQueryRewriteContext();
        assertTrue(exception.getMessage().contains("Failed to rewrite template query"));
        );
        template.put("geo_shape", geoShape);
                + "      }\n"
            + "      },\n"
    public void testReplaceVariablesWithNullVariables() throws IOException {
            );
            + "    \"geo_shape\": {\n"
        Map<String, Object> template = new HashMap<>();
        template.put("term", term);
        TemplateQueryBuilder templateQueryBuilder = new TemplateQueryBuilder(template);
                + "    \"must\" : [\n"
        bool.put("filter", filter);
                + "            \"fuzzy_transpositions\" : true,\n"
        QueryBuilder incomingQuery = new TemplateQueryBuilder(template);
        when(queryRewriteContext.getContextVariables()).thenReturn(contextVariables);
     */
            () -> templateQueryBuilder.doRewrite(queryRewriteContext)
                + "      \"boost\" : 1.0\n"
        should.add(shouldMatch2);
        term.put("message", message);
    }
        TemplateQueryBuilder original = new TemplateQueryBuilder(content);
                + "    \"adjust_pure_negative\" : true,\n"
                + "            \"lenient\" : false,\n"
        Map<String, Object> contextVariables = new HashMap<>();
        when(queryRewriteContext.getContextVariables()).thenReturn(contextVariables);
        Map<String, Object> template = new HashMap<>();
        IllegalArgumentException exception = expectThrows(
        term.put("message", message);
     */
    }
        template.put("term", "value");// Missing the required field for term query
     * Verifies that an IOException is thrown when a required field is missing.
        assertEquals(expectedContent, parsed.getContent());
        IllegalArgumentException exception = expectThrows(
        final CountDownLatch inProgressLatch = new CountDownLatch(1);
import java.util.function.BiConsumer;
        term.put("message", message);
    /**
    /**
        assertTrue(exception.getMessage().contains("Failed to rewrite template query"));
        IllegalArgumentException exception = expectThrows(
                + "    \"boost\" : 1.0\n"
        Map<String, Object> location = new HashMap<>();
                + "      \"value\" : \"foo\",\n"
     * Verifies that an IllegalArgumentException is thrown with the appropriate error message.
            "{\n"
        term.put("message", message);
     */
        assertEquals(content, builder.getContent());
     * Tests the doRewrite method with a variable not found.
            newQuery.toString()
        List<Map<String, Object>> should = new ArrayList<>();
                + "          }\n"
                + "}",
        TermQueryBuilder newQuery = (TermQueryBuilder) templateQueryBuilder.doRewrite(queryRewriteContext);
        contextVariables.put("response", "foo");
                + "      }\n"
        when(queryRewriteContext.getContextVariables()).thenReturn(new HashMap<>());
    public void testStreamRoundTrip() throws IOException {
        template.put("term", term);
        template.put("terms", terms);
        Map<String, Object> filter = new HashMap<>();
        actualContent.put("template", expectedContent);
                + "    ],\n"
        template.put("term", term);
                + "  }\n"
        shouldTextEntry2.put("text_entry", "grace");
            newQuery.toString()
        Map<String, Object> contextVariables = new HashMap<>();
                  }
     * Verifies that the template is correctly rewritten for a range query.
import static org.opensearch.index.query.TemplateQueryBuilder.NAME;
        message.put("value", "${response}");
     * Verifies that two builders with the same content are equal and have the same hash code,
    /**
        ArrayList termsList = new ArrayList<>();
import java.util.List;
            "{\n"
        QueryCoordinatorContext queryRewriteContext = mockQueryRewriteContext();
            () -> templateQueryBuilder.doRewrite(queryRewriteContext)
import org.opensearch.common.xcontent.XContentType;
    }
public class TemplateQueryBuilderTests extends OpenSearchTestCase {
        TemplateQueryBuilder templateQueryBuilder = new TemplateQueryBuilder(template);
        BoolQueryBuilder expectedQuery = new BoolQueryBuilder().must(new MatchQueryBuilder("text_entry", "love"))
        GeoDistanceQueryBuilder expectedQuery = new GeoDistanceQueryBuilder("pin.location");
        template.put("terms", terms);
    /**
        Map<String, Object> contextVariables = new HashMap<>();
        geoShape.put("boost", 42.0);
        TemplateQueryBuilder templateQueryBuilder = new TemplateQueryBuilder(template);
        Map<String, Object> bool = new HashMap<>();
                + "  \"range\" : {\n"
    public void testDoRewriteWithMalformedJson() throws IOException {
import org.opensearch.search.builder.SearchSourceBuilder;
                + "    \"filter\" : [\n"
        TemplateQueryBuilder builder = new TemplateQueryBuilder(content);
     * Verifies that the exception is thrown
        IllegalArgumentException exception = expectThrows(
        TermQueryBuilder termQueryBuilder = new TermQueryBuilder("message", "foo");
                + "            \"fuzzy_transpositions\" : true,\n"
                + "            \"query\" : \"life\",\n"
import org.opensearch.common.settings.Settings;
        contextVariables.put("response", "foo");
                + "      \"value\" : \"foo\",\n"
     */
        TemplateQueryBuilder builder2 = new TemplateQueryBuilder(content2);
import static org.mockito.Mockito.when;
    public void testFromJson() throws IOException {
        content.put("key", "value");
        assertTrue(exception.getMessage().contains("Failed to rewrite template query"));
     * Tests the doRewrite method of TemplateQueryBuilder with a string variable.
                + "        \"match\" : {\n"
        assertFalse(builder1.equals(builder3));
    /**
        QueryCoordinatorContext queryRewriteContext = mock(QueryCoordinatorContext.class);
                + "        \"match\" : {\n"
     * Verifies that the content and writeable name are correctly set and retrieved.
        Map<String, Object> terms = new HashMap<>();
        );
            () -> templateQueryBuilder.doRewrite(queryRewriteContext)
        assertEquals(newQuery, termsQueryBuilder);
        Map<String, Object> contextVariables = new HashMap<>();
    /**
                + "            \"prefix_length\" : 0,\n"
            IllegalArgumentException.class,
        assertEquals(
     */
            BiConsumer<Client, ActionListener<?>> biConsumer = invocation.getArgument(0);
        contextVariables.put("response", "should be a list but this is a string");
                + "}",
import org.opensearch.test.OpenSearchTestCase;
        // Test that the query can be converted to XContent
            .should(new MatchQueryBuilder("text_entry", "grace"))
import org.opensearch.core.action.ActionListener;
        age.put("gte", "${minAge}");
        QueryCoordinatorContext queryRewriteContext = mockQueryRewriteContext();
        Map<String, Object> contextVariables = new HashMap<>();
    }
                + "}",
        textEntry.put("text_entry", "${keyword}");
 * this file be licensed under the Apache-2.0 license or a
            newQuery.toString()
 * SPDX-License-Identifier: Apache-2.0
        message.put("value", "foo");
        Map<String, Object> term = new HashMap<>();
            + "      \"location\": {\n"
    }
     * Tests the doRewrite method with a missing required field in a query.
        // Test that the query can be serialized and deserialized
                + "    \"message\" : {\n"
                + "            \"prefix_length\" : 0,\n"
     */
        template.put("term", term);
        Map<String, Object> expectedJson = new HashMap<>();
        TemplateQueryBuilder templateQueryBuilder = new TemplateQueryBuilder(template);
            + "          \"coordinates\": \"${modelPredictionOutcome}\"\n"
            + "}";
     * Tests the doRewrite method of TemplateQueryBuilder with a missing bracket variable.
        assertTrue(exception.getMessage().contains("Failed to rewrite template query"));
        message.put("value", "${response}");
    }
        when(queryRewriteContext.getContextVariables()).thenReturn(contextVariables);
    public void testEqualsAndHashCode() {
        assertEquals(source.toString(), "{\"query\":{\"template\":{\"term\":{\"message\":{\"value\":\"foo\"}}}}}");
        TemplateQueryBuilder builder1 = new TemplateQueryBuilder(content1);
        location.put("shape", shape);
                + "    \"distance_type\" : \"arc\",\n"
        TemplateQueryBuilder templateQueryBuilder = new TemplateQueryBuilder(template);
                + "          \"text_entry\" : {\n"
     * Verifies that an IOException is thrown when a malformed variable is used.
        Map<String, Object> content = new HashMap<>();
        when(queryRewriteContext.getContextVariables()).thenReturn(null);
        assertEquals(template, templateQueryBuilder.getContent());
        );
    public void testDoRewriteWithNestedMap() throws IOException {
     * Helper method to create a mock QueryCoordinatorContext for testing.
        TemplateQueryBuilder templateQueryBuilder = new TemplateQueryBuilder((Map<String, Object>) null);
        );
        Map<String, Object> template = new HashMap<>();
     * while builders with different content are not equal and have different hash codes.
                + "      40.0\n"
        IllegalArgumentException exception = expectThrows(
import static org.mockito.Mockito.mock;
        TemplateQueryBuilder templateQueryBuilder = new TemplateQueryBuilder(template);
import org.opensearch.core.xcontent.XContentBuilder;
            newQuery.toString()
                + "            \"auto_generate_synonyms_phrase_query\" : true,\n"
    public void testDoRewriteWithList() throws IOException {
                + "    \"boost\" : 1.0\n"
    }
                + "}",
        contextVariables.put("response", "foo");
        TemplateQueryBuilder templateQueryBuilder = new TemplateQueryBuilder(template);
                + "          \"text_entry\" : {\n"
import static org.mockito.Mockito.doAnswer;
            () -> templateQueryBuilder.doRewrite(queryRewriteContext)
        bool.put("should", should);
    }
     * Tests the serialization and deserialization of TemplateQueryBuilder.
                + "            \"lenient\" : false,\n"
                + "    ],\n"
    /**
        terms.put("message", "${response}");
            IllegalArgumentException.class,
        assertEquals(expectedQuery, newQuery);
                + "      \"boost\" : 1.0\n"
        // Check if the parsed query is an instance of TemplateQueryBuilder
        Map<String, Object> term = new HashMap<>();
        IllegalArgumentException exception = expectThrows(
            + "          \"type\": \"Envelope\",\n"
    /**
        XContentBuilder builder = XContentFactory.jsonBuilder();
     */
        IllegalArgumentException exception = expectThrows(
            new SearchModule(Settings.EMPTY, List.of()).getNamedXContents()
        expectedQuery.point(geoPoint).distance("12km");
        Map<String, Object> shouldTextEntry1 = new HashMap<>();
        builder.endObject();
                + "            \"operator\" : \"OR\",\n"
                + "            \"max_expansions\" : 50,\n"
                }
     */
            () -> templateQueryBuilder.doRewrite(queryRewriteContext)
    public void testDoToQuery() {
    public void testReplaceVariablesWithNullTemplate() {
        QueryCoordinatorContext queryRewriteContext = mockQueryRewriteContext();
        Map<String, Object> message = new HashMap<>();
        );
        termsList.add("foo");
                + "            \"auto_generate_synonyms_phrase_query\" : true,\n"
import java.io.IOException;
        term.put("message", message);
     * Tests the doRewrite method with a malformed variable substitution.
import java.util.concurrent.CountDownLatch;
    /**
        bool.put("minimum_should_match", 1);
