import org.opensearch.core.xcontent.XContentParser;  
        Map<String, Object> template = new HashMap<>();
                + "          }\n"
        must.add(match);  
        assertEquals(expectedQuery, newQuery);
        );
                + "  \"geo_distance\" : {\n"  
}
        XContentParser jsonParser = XContentType.JSON.xContent()
        TemplateQueryBuilder templateQueryBuilder = new TemplateQueryBuilder(template);
            + "        \"shape\": {\n"
        when(queryRewriteContext.getContextVariables()).thenReturn(null);
import org.opensearch.core.xcontent.XContentBuilder;
    /**
                + "            \"max_expansions\" : 50,\n"
        contextVariables.put("geoPoint", geoPoint);
        String jsonString = "{\n"
            IllegalArgumentException.class,  
     */
        message.put("value", "foo");
                + "      },\n"  
        Map<String, Object> match = new HashMap<>();
        contextVariables.put("keyword", "love");
        assertEquals(original, deserialized);
                + "            \"fuzzy_transpositions\" : true,\n"
        content.put("key", "value");  
            newQuery.toString()
        TemplateQueryBuilder templateQueryBuilder = new TemplateQueryBuilder(template);  
        when(queryRewriteContext.getContextVariables()).thenReturn(new HashMap<>());  
        range.put("age", age);  
                + "        }\n"
            }  
        termsList.add("bar");
                + "      {\n"  
     * Tests the doRewrite method with an invalid matchall query.
        expectedJson.put("template", template);
        IllegalArgumentException exception = expectThrows(
        template.put("malformed_json", "{ this is not valid JSON }");  
        );
        expectedContent.put("geo_shape", geoShape);
     */  
        List<Map<String, Object>> must = new ArrayList<>();  
        XContentBuilder builder = XContentFactory.jsonBuilder();  
        age.put("lte", "${maxAge}");
    }
        QueryCoordinatorContext queryRewriteContext = mockQueryRewriteContext();
        GeoDistanceQueryBuilder expectedQuery = new GeoDistanceQueryBuilder("pin.location");
        parser.nextToken();
        message.put("value", "foo");
        bool.put("minimum_should_match", 1);
        term.put("message", message);
            .should(new MatchQueryBuilder("text_entry", "life"))
        TemplateQueryBuilder templateQueryBuilder = TemplateQueryBuilder.fromXContent(contentParser);
    public void testConstructorAndGetters() {  
     * Tests the doRewrite method with a malformed variable substitution.
        TemplateQueryBuilder templateQueryBuilder = new TemplateQueryBuilder(template);
        QueryCoordinatorContext queryRewriteContext = mockQueryRewriteContext();
import static org.mockito.Mockito.when;  
     * Verifies that an IOException is thrown when an invalid matchall query is used.  
        assertTrue(parsed instanceof TemplateQueryBuilder);
    }
        Map<String, Object> template = new HashMap<>();
        location.put("relation", "intersects");  
        expectedQuery.point(geoPoint).distance("12km");  
        template.put("geo_shape", geoShape);
     * Verifies that the template is correctly rewritten for a geo_distance query.
                + "            \"zero_terms_query\" : \"NONE\",\n"
        QueryShardContext mockContext = mock(QueryShardContext.class);  
        assertNotNull(parsed);  
        TemplateQueryBuilder templateQueryBuilder = new TemplateQueryBuilder(template);
        );
     * Verifies that an IOException is thrown when the query JSON is malformed.
public class TemplateQueryBuilderTests extends OpenSearchTestCase {
 */  
     */  
                + "            \"boost\" : 1.0\n"
                + "            \"boost\" : 1.0\n"  
    /**
            () -> templateQueryBuilder.doRewrite(queryRewriteContext)
     */
        Map<String, Object> shouldTextEntry1 = new HashMap<>();
        Map<String, Object> template = new HashMap<>();
        Map<String, Object> contextVariables = new HashMap<>();  
        shouldTextEntry2.put("text_entry", "grace");  
        );
        );
        contextVariables.put("response", "foo");
        assertFalse(builder1.hashCode() == builder3.hashCode());  
     * Verifies that two builders with the same content are equal and have the same hash code,
        );
    /**
        XContentParser parser = XContentType.JSON.xContent()  
        Map<String, Object> content1 = new HashMap<>();  
     * Tests the constructor and getter methods of TemplateQueryBuilder.  
        assertEquals(expectedQuery, newQuery);  
     * Tests the doRewrite method of TemplateQueryBuilder with a nested map variable.  
            IllegalArgumentException.class,
        Map<String, Object> actualContent = new HashMap<>();  
        TemplateQueryBuilder templateQueryBuilder = new TemplateQueryBuilder(template);  
    }  
    }  
        QueryCoordinatorContext queryRewriteContext = mockQueryRewriteContext();
        TemplateQueryBuilder templateQueryBuilder = new TemplateQueryBuilder(template);  
            () -> templateQueryBuilder.doRewrite(queryRewriteContext)
        // Check if the content of the parsed query matches the expected content  
                    "value": "foo"
    /**
     * Verifies that the exception is thrown
        TemplateQueryBuilder deserializedQuery = new TemplateQueryBuilder(in);
        assertTrue(exception.getMessage().contains("Failed to rewrite template query"));  
        TemplateQueryBuilder templateQueryBuilder = new TemplateQueryBuilder(template);  
        assertEquals(
                + "            \"fuzzy_transpositions\" : true,\n"
                + "    \"filter\" : [\n"
                + "            \"prefix_length\" : 0,\n"  
        when(queryRewriteContext.getContextVariables()).thenReturn(contextVariables);
        // Check if the parsed query is an instance of TemplateQueryBuilder
        TermQueryBuilder termQueryBuilder = new TermQueryBuilder("message", "foo");
        when(queryRewriteContext.getContextVariables()).thenReturn(contextVariables);  
        contextVariables.put("response", "foo");
     */
        assertEquals(expectedQuery, newQuery);  
        assertTrue(exception.getMessage().contains("Unclosed variable in template"));  
        textEntry.put("text_entry", "${keyword}");
                + "    }\n"
        assertEquals(  
                + "      {\n"
            + "        },\n"
        Map<String, Object> terms = new HashMap<>();
            .filter(new TermQueryBuilder("play_name", "Romeo and Juliet"))
            () -> templateQueryBuilder.doRewrite(queryRewriteContext)  
        assertEquals(
import org.opensearch.core.xcontent.DeprecationHandler;
     */
     * Tests the doRewrite method of TemplateQueryBuilder with a string variable.  
import org.opensearch.common.geo.GeoPoint;
     * Tests the fromXContent method of TemplateQueryBuilder.
        Map<String, Object> contextVariables = new HashMap<>();  
        content.put("key", "value");
                + "  \"term\" : {\n"  
    }  
        Map<String, Object> template = new HashMap<>();
     */
        );
                + "    \"must\" : [\n"  
            () -> templateQueryBuilder.doRewrite(queryRewriteContext)
        TemplateQueryBuilder templateQueryBuilder = new TemplateQueryBuilder(template);  
        Map<String, Object> term = new HashMap<>();
            "{\n"
                + "      \"boost\" : 1.0\n"
        assertTrue(builder1.hashCode() == builder2.hashCode());
        Map<String, Object> template = new HashMap<>();
        doAnswer(invocation -> {
                + "            \"lenient\" : false,\n"  
        List<Map<String, Object>> should = new ArrayList<>();  
                + "      \"include_upper\" : true,\n"
        TemplateQueryBuilder templateQueryBuilder = new TemplateQueryBuilder(template);  
     * Verifies that an IOException is thrown when a malformed variable is used.
            newQuery.toString()
                + "    \"should\" : [\n"  
import org.opensearch.core.xcontent.NamedXContentRegistry;  
        TemplateQueryBuilder templateQueryBuilder = new TemplateQueryBuilder(template);  
        Map<String, Object> template = new HashMap<>();
    private QueryCoordinatorContext mockQueryRewriteContext() {
        when(queryRewriteContext.getContextVariables()).thenReturn(contextVariables);
                  "message": {
        Map<String, Object> contextVariables = new HashMap<>();
    }  
    }  
        TermQueryBuilder termQueryBuilder = new TermQueryBuilder("message", "foo");  
                + "}",  
        template.put("bool", bool);
            () -> templateQueryBuilder.doRewrite(queryRewriteContext)
        QueryBuilder newQuery = templateQueryBuilder.doRewrite(queryRewriteContext);
        when(queryRewriteContext.getXContentRegistry()).thenReturn(TEST_XCONTENT_REGISTRY_FOR_QUERY);  
        IllegalArgumentException exception = expectThrows(
    /**
    }
            newQuery.toString()  
        template.put("term", term);
import java.util.function.BiConsumer;  
     * Verifies that an IOException is thrown when an invalid query type is used.
    }
        assertEquals(
        filter.put("term", term);
    }  
     * Verifies that an IllegalArgumentException is thrown with the appropriate error message.
        RangeQueryBuilder expectedQuery = new RangeQueryBuilder("age");
        Map<String, Object> contextVariables = new HashMap<>();  
        content3.put("key", "different_value");  
        bool.put("should", should);
        should.add(shouldMatch1);
            newQuery.toString()  
        Map<String, Object> shouldMatch2 = new HashMap<>();
     * Tests the doRewrite method of TemplateQueryBuilder with a range query.
     * Verifies that the template is correctly rewritten to a TermQueryBuilder.  
                + "    ],\n"
        assertTrue(exception.getMessage().contains("Failed to rewrite template query"));
                + "    \"age\" : {\n"
     * Verifies that an IOException is thrown when a required field is missing.
        StreamInput in = out.bytes().streamInput();
        when(queryRewriteContext.getContextVariables()).thenReturn(contextVariables);
                + "}",  
        TemplateQueryBuilder templateQueryBuilder = new TemplateQueryBuilder(template);
     */  
                + "    ],\n"
                + "    \"distance\" : 12000.0,\n"
                + "    }\n"
        Map<String, Object> template = new HashMap<>();
     * Tests the doRewrite method with a variable not found.
        QueryCoordinatorContext queryRewriteContext = mock(QueryCoordinatorContext.class);
        IllegalArgumentException exception = expectThrows(
            + "        \"relation\": \"intersects\"\n"
        TermQueryBuilder newQuery = (TermQueryBuilder) templateQueryBuilder.doRewrite(queryRewriteContext);  
        when(queryRewriteContext.getContextVariables()).thenReturn(new HashMap<>());
     * Tests the doRewrite method of TemplateQueryBuilder with a geo_distance query.  
        Map<String, Object> message = new HashMap<>();
import java.io.IOException;  
 * SPDX-License-Identifier: Apache-2.0
                + "      }\n"  
                + "      \"include_lower\" : true,\n"
        );  
        return queryRewriteContext;  
        SearchSourceBuilder source = new SearchSourceBuilder().query(incomingQuery);
        TemplateQueryBuilder parsed = TemplateQueryBuilder.fromXContent(parser);  
        TemplateQueryBuilder builder = new TemplateQueryBuilder(content);
        termsList.add("foo");
            return null;
                + "  \"range\" : {\n"  
                + "            \"lenient\" : false,\n"  
import org.opensearch.test.OpenSearchTestCase;  
        when(queryRewriteContext.getXContentRegistry()).thenReturn(TEST_XCONTENT_REGISTRY_FOR_QUERY);
        shape.put("type", "Envelope");  
        Map<String, Object> geoDistance = new HashMap<>();
            .minimumShouldMatch(1);
        TermsQueryBuilder termsQueryBuilder = new TermsQueryBuilder("message", termsList);
import static org.mockito.ArgumentMatchers.any;  
                + "      \"from\" : 25,\n"
        QueryCoordinatorContext queryRewriteContext = mockQueryRewriteContext();
import static org.mockito.Mockito.doAnswer;
import java.util.ArrayList;
     * since a null variables map is treated as no replacement.  
        Map<String, Object> terms = new HashMap<>();
                + "            \"max_expansions\" : 50,\n"
    public void testDoRewriteWithNotFoundVariableSubstitution() throws IOException {
                + "    \"message\" : {\n"
     */
        when(queryRewriteContext.getContextVariables()).thenReturn(contextVariables);
        QueryCoordinatorContext queryRewriteContext = mockQueryRewriteContext();
        expectThrows(IllegalStateException.class, () -> builder.doToQuery(mockContext));
        assertEquals(NAME, builder.getWriteableName());  
import java.util.concurrent.CountDownLatch;
        assertTrue(exception.getMessage().contains("Failed to rewrite template query"));
        Map<String, Object> shape = new HashMap<>();
        );  
                + "            \"zero_terms_query\" : \"NONE\",\n"
                + "      \"value\" : \"foo\",\n"
        actualContent.put("template", expectedContent);
        original.writeTo(out);
                null,
        when(queryRewriteContext.getContextVariables()).thenReturn(contextVariables);
        Map<String, Object> contextVariables = new HashMap<>();
    public void testDoRewriteWithRangeQuery() throws IOException {
        Map<String, Object> template = new HashMap<>();
        shape.put("coordinates", "${modelPredictionOutcome}");
                + "            \"prefix_length\" : 0,\n"  
        Map<String, Object> range = new HashMap<>();
        contextVariables.put("maxAge", 35);
                + "  \"bool\" : {\n"
     * Verifies that the correct query source is generated from a TemplateQueryBuilder.
        expectedQuery.gte(25).lte(35);  
            .createParser(xContentRegistry(), DeprecationHandler.THROW_UNSUPPORTED_OPERATION, builder.toString());
                ActionListener.wrap(
        IllegalArgumentException exception = expectThrows(
                + "  \"terms\" : {\n"
                + "            \"boost\" : 1.0\n"  
    public void testDoRewriteWithMissingBracketVariable() throws IOException {  
                + "    \"message\" : {\n"  
        TemplateQueryBuilder templateQueryBuilder = new TemplateQueryBuilder(template);  
        assertEquals(template, templateQueryBuilder.getContent());
                + "    ],\n"  
                    response -> inProgressLatch.countDown(),  
                + "          \"play_name\" : {\n"
        shouldTextEntry1.put("text_entry", "life");  
                }
    }
        geoDistance.put("pin.location", "${geoPoint}");
        IllegalArgumentException exception = expectThrows(  
     */
import org.opensearch.search.builder.SearchSourceBuilder;
                + "      \"value\" : \"foo\",\n"
                )
    public void testDoRewriteWithList() throws IOException {
import org.opensearch.transport.client.Client;
        content1.put("key", "value");
    /**
        Map<String, Object> template = new HashMap<>();
        contextVariables.put("response1", "foo");
        term.put("message", message);  
        QueryCoordinatorContext queryRewriteContext = mockQueryRewriteContext();
     * Tests the doRewrite method with a malformed JSON query.
    }  
     * Verifies that the template is correctly rewritten with the list variable substituted.  
        Map<String, Object> expectedJson = new HashMap<>();
                + "      -70.0,\n"
            "{\n"
        /*  
            );  
        term.put("message", message);
        location.put("shape", shape);
import static org.opensearch.index.query.TemplateQueryBuilder.NAME;
                  }  
    public void testReplaceVariablesWithEmptyTemplate() {
        assertEquals(source.toString(), "{\"query\":{\"template\":{\"term\":{\"message\":{\"value\":\"foo\"}}}}}");
            new SearchModule(Settings.EMPTY, List.of()).getNamedXContents()
            + "          \"coordinates\": \"${modelPredictionOutcome}\"\n"  
    /**
        GeoPoint geoPoint = new GeoPoint(40, -70);
        QueryBuilder incomingQuery = new TemplateQueryBuilder(template);  
     */
import org.opensearch.common.io.stream.BytesStreamOutput;
                + "}",
import org.opensearch.core.common.io.stream.StreamInput;
            IllegalArgumentException.class,
        Map<String, Object> template = new HashMap<>();  
        term.put("message", message);  
            () -> templateQueryBuilder.doRewrite(queryRewriteContext)  
        TemplateQueryBuilder builder2 = new TemplateQueryBuilder(content2);  
        Map<String, Object> textEntry = new HashMap<>();
        assertTrue(exception.getMessage().contains("Variable not found"));
        content2.put("key", "value");
        Map<String, Object> content = new HashMap<>();
        Map<String, Object> age = new HashMap<>();
                + "        \"match\" : {\n"
     * Verifies that an IllegalArgumentException is thrown with the appropriate error message.
        shouldMatch1.put("match", shouldTextEntry1);
        BytesStreamOutput out = new BytesStreamOutput();
                + "  }\n"
        assertEquals(  
        Map<String, Object> template = new HashMap<>();
                + "          \"text_entry\" : {\n"  
        assertEquals(source.toString(), "{\"query\":{\"template\":{\"term\":{\"message\":{\"value\":\"foo\"}}}}}");
                + "    \"minimum_should_match\" : \"1\",\n"  
 * this file be licensed under the Apache-2.0 license or a
        QueryCoordinatorContext queryRewriteContext = mockQueryRewriteContext();
        assertEquals(newQuery, termQueryBuilder);
        QueryCoordinatorContext queryRewriteContext = mockQueryRewriteContext();  
 * compatible open source license.
/*  
                + "    \"boost\" : 1.0\n"
            IllegalArgumentException.class,  
        );
            IllegalArgumentException.class,
        should.add(shouldMatch2);
                + "      \"foo\",\n"
     */  
        term.put("message", message);  
     * Verifies that the template is correctly rewritten with the variable substituted.
                + "      \"value\" : \"foo\",\n"
        Map<String, Object> shouldMatch1 = new HashMap<>();
        QueryCoordinatorContext queryRewriteContext = mockQueryRewriteContext();  
     * Verifies that a builder can be written to a stream and read back correctly.  
            () -> templateQueryBuilder.doRewrite(queryRewriteContext)  
        template.put("term", term);
     * while builders with different content are not equal and have different hash codes.  
        Map<String, Object> template = new HashMap<>();  
        IllegalArgumentException exception = expectThrows(
                + "        }\n"
        );
     * Verifies that a TemplateQueryBuilder can be correctly created from XContent.  
                + "            \"query\" : \"love\",\n"
        parsed.doXContent(builder, ToXContent.EMPTY_PARAMS);
        */
        IllegalArgumentException exception = expectThrows(
     * Verifies that the method returns the original template unchanged,
        Map<String, Object> term = new HashMap<>();  
import org.opensearch.core.xcontent.ToXContent;
     */
        message.put("value", "${response}");
        BytesStreamOutput out = new BytesStreamOutput();
        );
    public void testDoRewriteWithInvalidMatchAllQuery() throws IOException {
        template.put("term", term);
                + "            \"prefix_length\" : 0,\n"  
    public void testEqualsAndHashCode() {
        ArrayList termsList = new ArrayList<>();  
                + "}",
        when(queryRewriteContext.getContextVariables()).thenReturn(contextVariables);  
        TermsQueryBuilder newQuery = (TermsQueryBuilder) templateQueryBuilder.doRewrite(queryRewriteContext);
            IllegalArgumentException.class,
        QueryCoordinatorContext queryRewriteContext = mockQueryRewriteContext();
            newQuery.toString()
        age.put("gte", "${minAge}");
    public void testDoRewrite() throws IOException {
    public void testDoToQuery() {
    }
                + "            \"value\" : \"Romeo and Juliet\",\n"  
            new SearchModule(Settings.EMPTY, List.of()).getNamedXContents()
        Map<String, Object> contextVariables = new HashMap<>();  
    }
        TemplateQueryBuilder builder = new TemplateQueryBuilder(content);  
        // Test that the query can be converted to XContent
        QueryCoordinatorContext queryRewriteContext = mockQueryRewriteContext();
            "{\n"
    /**  
    public void testStreamRoundTrip() throws IOException {
                + "}",  
                + "      \"boost\" : 1.0\n"
            IllegalArgumentException.class,  
     * Tests the serialization and deserialization of TemplateQueryBuilder.
                + "          }\n"
                + "            \"operator\" : \"OR\",\n"
        Map<String, Object> term = new HashMap<>();  
        template.put("matchall_1", new HashMap<>());
        when(queryRewriteContext.getContextVariables()).thenReturn(new HashMap<>());  
     * Tests the doRewrite method of TemplateQueryBuilder with a missing bracket variable.  
                + "  }\n"
                + "            \"auto_generate_synonyms_phrase_query\" : true,\n"
            newQuery.toString()  
     * Tests the replaceVariables method when the template is empty.  
     * Tests the replaceVariables method when the template is null.
    }
import static org.mockito.Mockito.mock;
        Map<String, Object> message = new HashMap<>();
     * Verifies that an IOException is thrown when a malformed variable is used.  
                + "      {\n"
        TermQueryBuilder newQuery = (TermQueryBuilder) templateQueryBuilder.doRewrite(queryRewriteContext);  
        TermQueryBuilder termQueryBuilder = new TermQueryBuilder("message", "foo");  
        contextVariables.put("response", "foo");
                + "      \"boost\" : 1.0\n"  
        assertEquals("Template string cannot be null. A valid template must be provided.", exception.getMessage());
     * Verifies that calling doToQuery throws an IllegalStateException.
    /**  
            () -> templateQueryBuilder.doRewrite(queryRewriteContext)  
                + "    \"validation_method\" : \"STRICT\",\n"
                + "            \"max_expansions\" : 50,\n"
                + "  }\n"
        Map<String, Object> contextVariables = new HashMap<>();  
     */
                + "            \"operator\" : \"OR\",\n"
        assertEquals(newQuery, termsQueryBuilder);
            IllegalArgumentException.class,  
        contextVariables.put("response", termsList);
     */
        builder.endObject();  
        message.put("value", "foo");  
        TemplateQueryBuilder templateQueryBuilder = new TemplateQueryBuilder(template);
                + "      \"bar\"\n"
              }
                + "    ],\n"
    /**  
     */
            + "      },\n"  
        when(queryRewriteContext.getContextVariables()).thenReturn(contextVariables);
     * Tests the doRewrite method of TemplateQueryBuilder with a simple term query.
        StreamInput in = out.bytes().streamInput();
        assertEquals("Template string cannot be empty. A valid template must be provided.", exception.getMessage());
        // Test that the query can be serialized and deserialized
    }  
    public void testDoRewriteWithMissingRequiredField() throws IOException {  
     */  
     * Tests the doRewrite method of TemplateQueryBuilder with a list variable.
     */
    public void testFromJson() throws IOException {  
        Map<String, Object> filter = new HashMap<>();
        Map<String, Object> contextVariables = new HashMap<>();  
        Map<String, Object> location = new HashMap<>();  
                + "            \"auto_generate_synonyms_phrase_query\" : true,\n"
    /**
        template.put("invalid_query_type", new HashMap<>());
            "{\n"
        QueryCoordinatorContext queryRewriteContext = mockQueryRewriteContext();
            + "      \"location\": {\n"  
                + "      40.0\n"  
        assertEquals(  
        assertEquals(expectedContent, parsed.getContent());
    public void testFromXContent() throws IOException {
        Map<String, Object> expectedContent = new HashMap<>();
            .should(new MatchQueryBuilder("text_entry", "grace"))  
        Map<String, Object> actualJson = jsonParser.map();  
                + "            \"fuzzy_transpositions\" : true,\n"
        XContentBuilder xContentBuilder = XContentFactory.jsonBuilder().map(template);
            BiConsumer<Client, ActionListener<?>> biConsumer = invocation.getArgument(0);
        contextVariables.put("minAge", 25);
        QueryBuilder newQuery = templateQueryBuilder.doRewrite(queryRewriteContext);
        assertFalse(builder1.equals(builder3));
        term.put("message", message);
        template.put("term", term);
    }
        Map<String, Object> contextVariables = new HashMap<>();  
    /**
                + "      }\n"  
                + "          }\n"
        assertEquals(parsed.getContent(), deserializedQuery.getContent());  
        Map<String, Object> term = new HashMap<>();
        when(queryRewriteContext.getContextVariables()).thenReturn(new HashMap<>());
        QueryBuilder newQuery = templateQueryBuilder.doRewrite(queryRewriteContext);
        Map<String, Object> term = new HashMap<>();  
            + "      \"boost\": 42.0\n"
                + "            \"auto_generate_synonyms_phrase_query\" : true,\n"
        bool.put("must", must);
                    err -> fail("Failed to set query tokens supplier: " + err.getMessage())
        );
        TemplateQueryBuilder templateQueryBuilder = new TemplateQueryBuilder(template);
            .createParser(xContentRegistry(), DeprecationHandler.THROW_UNSUPPORTED_OPERATION, jsonString);
import org.opensearch.common.xcontent.XContentType;
    public void testDoRewriteWithNestedMap() throws IOException {  
        message.put("value", "foo");  
    /**
        terms.put("message", "${response}");
     * Verifies that the content and writeable name are correctly set and retrieved.
        when(queryRewriteContext.getContextVariables()).thenReturn(contextVariables);  
        NamedXContentRegistry TEST_XCONTENT_REGISTRY_FOR_QUERY = new NamedXContentRegistry(  
        Map<String, Object> message = new HashMap<>();  
        template.put("term", term);
        content.put("key", "value");
        builder.startObject();
        Map<String, Object> term = new HashMap<>();
                + "      {\n"
        geoShape.put("ignore_unmapped", false);
    /**
    }
    /**
import java.util.Map;
    /**  
                + "        }\n"  
        Map<String, Object> content2 = new HashMap<>();
        NamedXContentRegistry TEST_XCONTENT_REGISTRY_FOR_QUERY = new NamedXContentRegistry(
        }).when(queryRewriteContext).registerAsyncAction(any());
        );
                + "          }\n"
     */
        TemplateQueryBuilder builder3 = new TemplateQueryBuilder(content3);
        TemplateQueryBuilder original = new TemplateQueryBuilder(content);
            () -> templateQueryBuilder.doRewrite(queryRewriteContext)
        geoDistance.put("distance", "12km");
        terms.put("message", "${response}");  
     */
     * Helper method to create a mock QueryCoordinatorContext for testing.
            newQuery.toString()
    }
        template.put("terms", terms);
     */
    /**  
                + "          \"text_entry\" : {\n"  
        TemplateQueryBuilder templateQueryBuilder = new TemplateQueryBuilder((Map<String, Object>) null);  
        Map<String, Object> template = new HashMap<>();  
                + "    \"pin.location\" : [\n"
                + "            \"boost\" : 1.0\n"  
        assertEquals(content, builder.getContent());
        template.put("terms", terms);
                + "      }\n"
        match.put("match", textEntry);
        template.put("term", term);
    public void testReplaceVariablesWithNullTemplate() {
                + "  }\n"
                + "    \"message\" : [\n"  
                + "  }\n"
                + "        \"match\" : {\n"
     * Tests parsing a TemplateQueryBuilder from a JSON string.  
        template.put("range", range);
        Map<String, Object> content = new HashMap<>();  
import java.util.List;  
                + "  }\n"
     */
        when(queryRewriteContext.getContextVariables()).thenReturn(contextVariables);  
        TemplateQueryBuilder templateQueryBuilder = new TemplateQueryBuilder(template);
        XContentParser contentParser = createParser(xContentBuilder);  
        contextVariables.put("response", "foo");  
     */
                + "    \"message\" : {\n"  
            + "          \"type\": \"Envelope\",\n"
                + "            \"zero_terms_query\" : \"NONE\",\n"
        when(queryRewriteContext.getContextVariables()).thenReturn(contextVariables);
    public void testReplaceVariablesWithNullVariables() throws IOException {
        QueryCoordinatorContext queryRewriteContext = mockQueryRewriteContext();
        SearchSourceBuilder source = new SearchSourceBuilder().query(templateQueryBuilder);
        Map<String, Object> contextVariables = new HashMap<>();
        assertTrue(builder1.equals(builder2));  
    /**
                + "        \"term\" : {\n"
     * Verifies that the template is correctly rewritten with the nested map variable substituted.
        TemplateQueryBuilder deserialized = new TemplateQueryBuilder(in);
import org.opensearch.common.xcontent.XContentFactory;
        Map<String, Object> template = new HashMap<>();
                + "  \"term\" : {\n"
        shouldMatch2.put("match", shouldTextEntry2);
import java.util.HashMap;
        parsed.writeTo(out);  
        assertTrue(exception.getMessage().contains("Failed to rewrite template query"));
        IllegalArgumentException exception = expectThrows(
        Map<String, Object> term = new HashMap<>();  
        final CountDownLatch inProgressLatch = new CountDownLatch(1);  
        Map<String, Object> content3 = new HashMap<>();
                + "    \"ignore_unmapped\" : false,\n"
        Map<String, Object> template = new HashMap<>();
    }
     * Tests the replaceVariables method when the variables map is null.
        Map<String, Object> term = new HashMap<>();
        Map<String, Object> template = new HashMap<>();
        message.put("value", "${response}");  
        Map<String, Object> message = new HashMap<>();  
     * Tests the query source generation of TemplateQueryBuilder.  
                + "    \"boost\" : 1.0\n"
                + "        \"match\" : {\n"
        QueryCoordinatorContext queryRewriteContext = mockQueryRewriteContext();
        Map<String, Object> template = new HashMap<>();  
                + "            \"lenient\" : false,\n"  
                "term": {  
                + "            \"query\" : \"grace\",\n"
        geoShape.put("boost", 42.0);  
        );
        Map<String, Object> contextVariables = new HashMap<>();
                + "  }\n"
            "{\n"
        Map<String, Object> message = new HashMap<>();
                + "    }\n"  
            + "    }\n"  
        bool.put("filter", filter);
    }  
 * The OpenSearch Contributors require contributions made to  
        assertEquals(NAME, templateQueryBuilder.getWriteableName());
    }
        Map<String, Object> message = new HashMap<>();
        );
 *
        assertEquals(  
            "{\n"
                + "  \"term\" : {\n"
package org.opensearch.index.query;
    /**  
        TermQueryBuilder newQuery = (TermQueryBuilder) templateQueryBuilder.doRewrite(queryRewriteContext);
    public void testQuerySource() {  
                + "    ],\n"
     * Verifies that the parsed query matches the expected structure and can be serialized and deserialized.
    /**
        Map<String, Object> shouldTextEntry2 = new HashMap<>();
import org.opensearch.search.SearchModule;
        template.put("term", term);
                + "}",
        );
                + "      \"to\" : 35,\n"  
        assertTrue(exception.getMessage().contains("Failed to rewrite template query"));  
    /**
                + "    \"boost\" : 1.0\n"  
                + "          \"text_entry\" : {\n"  
        contextVariables.put("response", "should be a list but this is a string");
     * Verifies that the template is correctly rewritten for a range query.  
                + "        }\n"
        Map<String, Object> content = new HashMap<>();
            biConsumer.accept(  
        IllegalArgumentException exception = expectThrows(
            "{\n"
        TemplateQueryBuilder builder1 = new TemplateQueryBuilder(content1);
import org.opensearch.core.action.ActionListener;  
        Map<String, Object> message = new HashMap<>();  
        assertEquals(newQuery, termQueryBuilder);
    /**
                + "    }\n"  
                + "}",  
    public void testDoRewriteWithGeoDistanceQuery() throws IOException {  
                + "            \"operator\" : \"OR\",\n"
        QueryCoordinatorContext queryRewriteContext = mockQueryRewriteContext();  
        BoolQueryBuilder expectedQuery = new BoolQueryBuilder().must(new MatchQueryBuilder("text_entry", "love"))
                + "    \"distance_type\" : \"arc\",\n"  
                + "    \"adjust_pure_negative\" : true,\n"
            IllegalArgumentException.class,
        geoShape.put("location", location);
     * Tests the doToQuery method of TemplateQueryBuilder.
              "template": {
    public void testDoRewriteWithInvalidQueryType() throws IOException {  
    /**
            + "    \"geo_shape\": {\n"
     */
    public void testDoRewriteWithMalformedJson() throws IOException {
     * Tests the doRewrite method with a missing required field in a query.  
        Map<String, Object> bool = new HashMap<>();
        Map<String, Object> geoShape = new HashMap<>();
    public void testDoRewriteWithMalformedVariableSubstitution() throws IOException {
        term.put("message", message);
    }
    public void testDoRewriteWithString() throws IOException {  
        assertEquals(newQuery, termQueryBuilder);  
                + "            \"query\" : \"life\",\n"
            + "}";
        contentParser.nextToken();
import org.opensearch.common.settings.Settings;  
     * Tests the equals and hashCode methods of TemplateQueryBuilder.
        template.put("geo_distance", geoDistance);  
                + "      \"boost\" : 1.0\n"  
        );
     * Tests the doRewrite method with an invalid query type.  
        assertEquals(expectedJson, actualJson);
            + "      \"ignore_unmapped\": false,\n"
        template.put("term", "value");// Missing the required field for term query
        message.put("value", "${response");  
        term.put("play_name", "Romeo and Juliet");  
            {
    /**
    }  
        Map<String, Object> template = new HashMap<>();
        QueryCoordinatorContext queryRewriteContext = mockQueryRewriteContext();
