                    }
                      "type": "long",
                    ]}""";  
        EqualsHashCodeTestUtils.checkEqualsAndHashCode(createSearchSourceBuilder(), this::copyBuilder);
import org.opensearch.index.query.MatchNoneQueryBuilder;
                assertEquals(5, searchSourceBuilder.sorts().size());
        }  
                    "rescore": [ {
                assertEquals(1, searchSourceBuilder.getDerivedFields().size());
        String expectedContent = "{\"from\":0,\"size\":10,\"query\":{\"match_all\":{\"boost\":1.0}},\"search_pipeline\":\"my_pipeline\"}";
                    }  
        }
            SearchSourceBuilder copy = original.shallowCopy();  
        }  
            searchSourceBuilder,
                    "object": {
                () -> SearchSourceBuilder.fromXContent(parser)
            assertIndicesBoostParseErrorMessage(restContent, "Expected [FIELD_NAME] in [indices_boost] but found [END_OBJECT]");
                searchSourceBuilder = rewrite(searchSourceBuilder);  
/*  
                }
                SearchSourceBuilder searchSourceBuilder = SearchSourceBuilder.fromXContent(parser);
                    assertEquals(searchSourceBuilder.hashCode(), deserializedBuilder.hashCode());
import org.opensearch.index.query.Rewriteable;
            builder = builder.prettyPrint();
                assertEquals(1, searchSourceBuilder.aggregations().count());
        {
            try (XContentParser parser = createParser(JsonXContent.jsonXContent, restContent)) {
 */  
        XContentBuilder builder = MediaTypeRegistry.contentBuilder(randomFrom(XContentType.values()));  
                assertTrue(searchSourceBuilder.verbosePipeline());
        }  
import java.util.Map;
import org.opensearch.core.common.io.stream.NamedWriteableAwareStreamInput;
        if (keepAlive != null) {
                      "bool": {
import org.opensearch.index.query.QueryBuilders;
            String restContent = """
                    assertEquals(expectedContent, actualContent);
            try (XContentParser parser = createParser(JsonXContent.jsonXContent, restContent)) {
            """;  
            }
                try (StreamInput in = new NamedWriteableAwareStreamInput(output.bytes().streamInput(), namedWriteableRegistry)) {
import org.opensearch.search.sort.ScoreSortBuilder;  
            assertThat(searchSourceBuilder.rescores().get(0), instanceOf(QueryRescorerBuilder.class));  
            assertThat(
/*  
        int validFrom = randomIntBetween(0, 100);
    public void testEqualsAndHashcode() throws IOException {
    public void testParseFromAndSize() throws IOException {
        {  
                        { "foo" : 1.0 },
                      "type": "object",
                assertEquals(deserializedBuilder, testBuilder);  
        {
                    "indices_boost" : [
            String restContent = """
                 "terms": {  
                { "_source": { "includes": "include", "excludes": "*.field2"}}""";  
 * Licensed to Elasticsearch under one or more contributor  
                SearchSourceBuilder searchSourceBuilder = SearchSourceBuilder.fromXContent(parser);  
                      "script": "emit(doc['message'])"
    public void testTimeoutWithoutUnits() throws IOException {
        {
                );  
 * You may obtain a copy of the License at  
        String restContent = """
        }
            String restContent = """
 * The OpenSearch Contributors require contributions made to  
    public void testTimeoutWithUnits() throws IOException {
                assertFalse(searchSourceBuilder.verbosePipeline());  
                assertEquals(  
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, restContent)) {
        }
                  "derived": {
                searchSourceBuilder.writeTo(output);  
            }
                    }
            IllegalArgumentException expected = expectThrows(
                  "must": {
                assertEquals(  
        {
                        "match_none": {}  
                                "match": { "content": { "query": "baz" } }
 * KIND, either express or implied.  See the License for the
            new BaseQueryRewriteContext(xContentRegistry(), writableRegistry(), null, Long.valueOf(1)::longValue)  
        }
import org.opensearch.core.xcontent.XContentParser;
import org.opensearch.index.query.BoolQueryBuilder;  
                    "rescore": {
    public void testParseIndicesBoost() throws IOException {
                                "field": "foo"
                { "verbose_pipeline": true }""";
        }
    }
                     }  
                      "script": "emit(doc['test'])"  
import static org.hamcrest.Matchers.equalTo;
import org.opensearch.core.common.ParsingException;  
              }
                        "test_agg": {
            }  
                        SearchSourceBuilder deserializedBuilder = new SearchSourceBuilder(in);  
    public void testToXContentWithPointInTime() throws IOException {
                                "match": { "content": { "query": "baz" } }
        }  
        XContentType xContentType = randomFrom(XContentType.values());
            assertEquals(1, sourceAsMap.size());
                    String actualContent = deserializedBuilder.toString();  
        }
            assertIndicesBoostParseErrorMessage(restContent, "Expected [VALUE_NUMBER] in [indices_boost] but found [START_OBJECT]");  
        return Rewriteable.rewrite(
    // we use the streaming infra to create a copy of the builder provided as argument
                    "match_none": {}
        }
            SearchSourceBuilder searchSourceBuilder = SearchSourceBuilder.fromXContent(parser);  
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();  
 *
        }
                SearchSourceBuilder searchSourceBuilder = SearchSourceBuilder.fromXContent(parser);
                assertArrayEquals(new String[] { "include" }, searchSourceBuilder.fetchSource().includes());
            IllegalArgumentException expected = expectThrows(  
                    "message",  
    }
                try (StreamInput in = new NamedWriteableAwareStreamInput(output.bytes().streamInput(), namedWriteableRegistry)) {  
                        "user",
        }
                """;
                """;  
    }  
            assertThat(searchSourceBuilder.highlighter().fields().get(0).highlightQuery(), instanceOf(MatchNoneQueryBuilder.class));
              },
            try (XContentParser parser = createParser(JsonXContent.jsonXContent, restContent)) {
                searchSourceBuilder.derivedField("derived_field", "keyword", new Script("emit(doc['message']"));
        }
                    + "\"duration\":{\"type\":\"long\",\"script\":\"emit(doc['test'])\"},\"ip_from_message\":{\"type\":\"keyword\",\"script\":\"emit(doc['message'])\"},\"derived_field\":{\"type\":\"keyword\",\"script\":{\"source\":\"emit(doc['message']\",\"lang\":\"painless\"}}}}";  
                { "_source": false}""";  
                      "script": "emit(doc['message'])"
import org.opensearch.index.query.RandomQueryBuilder;  
                    "ip_from_message": {  
                    "duration": {
        {
        {
        TimeValue keepAlive = randomBoolean() ? TimeValue.timeValueHours(1) : null;
        searchSourceBuilder.toXContent(builder, ToXContent.EMPTY_PARAMS);
        expected = expectThrows(IllegalArgumentException.class, () -> new SearchSourceBuilder().size(-1));
                     },  
            String restContent = """  
                  },
    }
            }  
    }
import org.opensearch.common.unit.TimeValue;
                searchSourceBuilder.derivedField(
        {
            String restContent = """
        }
            }
                            "field": "duration"
        int randomSize = randomIntBetween(-100000, -2);
        assertNull(parser.nextToken());
            try (XContentParser parser = createParser(JsonXContent.jsonXContent, restContent)) {
                    "fragment_size": 150,
                assertEquals(1, searchSourceBuilder.getDerivedFields().size());  
 *  
    public void testVerbosePipeline() throws IOException {
        restContent = " { \"from\": \"" + validFrom + "\"}";
        }
        String restContent = """  
                assertTrue(searchSourceBuilder.getDerivedFields().get(0).getIgnoreMalformed());
    public void testParseSort() throws IOException {
                { "indices_boost": {"foo": 1.0, "bar": 2.0}}""";
              "rescore": {  
                IllegalArgumentException.class,  
                    "highlight_query": {
/*
            parser.nextToken(); // sometimes we move it on the START_OBJECT to  
                        { "baz" : 3.0 }  
            }
                    searchSourceBuilder.rescores().get(0)
                    try (StreamInput in = new NamedWriteableAwareStreamInput(output.bytes().streamInput(), namedWriteableRegistry)) {
    public void testAggsParsing() throws IOException {  
        {  
    }
            }
                {  
    }
            String restContent = """  
            String restContent = """
import org.opensearch.core.common.io.stream.StreamInput;  
                        { "bar" : 2.0 },
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, restContent)) {
                SearchSourceBuilder deserializedBuilder = new SearchSourceBuilder(in);
            BytesReference source = BytesReference.bytes(builder);  
    public void testNegativeSizeErrors() {  
            try (XContentParser parser = createParser(JsonXContent.jsonXContent, restContent)) {
    public void testToXContent() throws IOException {
                assertEquals(new FieldSortBuilder("post_date"), searchSourceBuilder.sorts().get(0));
                        }  
                    }
import java.io.IOException;  
 *    http://www.apache.org/licenses/LICENSE-2.0
                     }
                      }  
        }  
                    }
            SearchSourceBuilder searchSourceBuilder = SearchSourceBuilder.fromXContent(parser);
                      "script": "emit(doc['test'])",  
                    searchSourceBuilder.writeTo(output);
    public void testDerivedFieldsParsingAndSerializationObjectType() throws IOException {  
                    SearchSourceBuilder deserializedBuilder = new SearchSourceBuilder(in);
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, restContent)) {
                "order": "score",
    }
                {
                }
    }  
                  }  
                searchSourceBuilder = rewrite(searchSourceBuilder);
                assertEquals(3, searchSourceBuilder.getDerivedFieldsObject().size());
                "{\"query\":{\"match\":{\"content\":{\"query\":\"foo bar\",\"operator\":\"OR\",\"prefix_length\":0,\"max_expansions\":50,\"fuzzy_transpositions\":true,\"lenient\":false,\"zero_terms_query\":\"NONE\",\"auto_generate_synonyms_phrase_query\":true,\"boost\":1.0}}},\"derived\":{\"duration\":{\"type\":\"long\",\"script\":\"emit(doc['test'])\"},\"ip_from_message\":{\"type\":\"keyword\",\"script\":\"emit(doc['message'])\"},\"object\":{\"format\":\"dd-MM-yyyy\",\"prefilter_field\":\"test\",\"ignore_malformed\":true,\"type\":\"object\",\"script\":\"emit(doc['test'])\",\"properties\":{\"sub_field\":\"text\"}},\"derived_field\":{\"type\":\"object\",\"script\":{\"source\":\"emit(doc['message']\",\"lang\":\"painless\"},\"properties\":{\"sub_field_2\":\"keyword\"},\"prefilter_field\":\"message\",\"format\":\"dd-MM-yyyy\",\"ignore_malformed\":true}}}";  
        SearchSourceBuilder newBuilder = SearchSourceBuilder.fromXContent(parser);  
        String restContent = """
            assertThat(e, hasToString(containsString("unit is missing or unrecognized")));
    }  
                { "sort": "foo"}""";
                {  
                        "match": { "content": { "query": "foo bar" }}
                );  
        assertEquals("[size] parameter cannot be negative, found [-1]", expected.getMessage());
                    SearchSourceBuilder deserializedBuilder = new SearchSourceBuilder(in);
            try (XContentParser parser = createParser(JsonXContent.jsonXContent, restContent)) {
                    "duration": {
                }  
    public void testMultipleQueryObjectsAreRejected() throws Exception {
                        assertNotSame(searchSourceBuilder, deserializedBuilder);
    }
        }
        {  
                        assertEquals(expectedContent, actualContent);
                { "query": { "match_all": {} } }""";  
                        assertEquals(searchSourceBuilder.hashCode(), deserializedBuilder.hashCode());  
                      "format": "dd-MM-yyyy",
                    ]}"""; // invalid format
            SearchSourceBuilder searchSourceBuilder = SearchSourceBuilder.fromXContent(parser);
            String restContent = """
                    },  
                SearchSourceBuilder searchSourceBuilder = SearchSourceBuilder.fromXContent(parser);  
        {
               "filters": {
    }
    public void testNegativeFromErrors() {
                        "match": { "content": { "query": "foo bar" }}
        assertEquals("[from] parameter cannot be negative, found [-2]", expected.getMessage());  
 * GitHub history for details.
                  },  
        @SuppressWarnings("unchecked")
            assertEquals(2, pit.size());
            }
                assertFalse(searchSourceBuilder.verbosePipeline());
                    ]}"""; // invalid format
                      "type": "long",  
                assertEquals(1, searchSourceBuilder.sorts().size());
                assertEquals(new FieldSortBuilder("age").order(SortOrder.DESC), searchSourceBuilder.sorts().get(3));
import org.opensearch.common.io.stream.BytesStreamOutput;
                SearchSourceBuilder searchSourceBuilder = SearchSourceBuilder.fromXContent(parser);
        {
        final int timeout = randomIntBetween(1, 1024);  
                          "match_none": {}
            {
                        { "age" : "desc" },
                }
                      "must": {
            String restContent = """
                instanceOf(MatchNoneQueryBuilder.class)  
                        SearchSourceBuilder deserializedBuilder = new SearchSourceBuilder(in);  
        {
            assertIndicesBoostParseErrorMessage(restContent, "Expected [END_OBJECT] in [indices_boost] but found [FIELD_NAME]");  
        {
                SearchSourceBuilder searchSourceBuilder = SearchSourceBuilder.fromXContent(parser);
                      "prefilter_field": "test",
        String restContent = " { \"from\": \"" + negativeFrom + "\"}";
                assertEquals(1, searchSourceBuilder.getDerivedFields().get(0).getProperties().size());
import org.opensearch.test.OpenSearchTestCase;  
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, query)) {
                        }
                assertEquals("dd-MM-yyyy", searchSourceBuilder.getDerivedFields().get(0).getFormat());  
                    }
            final IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> SearchSourceBuilder.fromXContent(parser));  
            XContentBuilder builder = MediaTypeRegistry.contentBuilder(xContentType);
                    "number_of_fragments": 3,  
import org.opensearch.common.xcontent.json.JsonXContent;
            SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();  
                     },  
        assertEquals(1, sourceAsMap.size());
        }  
            }
            try (XContentParser parser = createParser(JsonXContent.jsonXContent, restContent)) {
import org.opensearch.search.AbstractSearchTestCase;  
              },  
                    "percentiles_duration": {
                {
                    "dd-MM-yyyy",
        SearchSourceBuilder testSearchSourceBuilder = createSearchSourceBuilder();
                    "query" : {
                  "rescore_query_weight": 10
                assertEquals(new FieldSortBuilder("user"), searchSourceBuilder.sorts().get(1));  
            { "query": { "match_all": {} }, "from": 0, "size": 10, "search_pipeline": "my_pipeline" }""";
            String restContent = """
            ParsingException exc = expectThrows(ParsingException.class, () -> SearchSourceBuilder.fromXContent(parser));
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, restContent)) {  
            }
        testSearchSourceBuilder.toXContent(builder, ToXContent.EMPTY_PARAMS);
        Map<String, Object> sourceAsMap = XContentHelper.convertToMap(bytes, false, xContentType).v2();  
                        }  
            String restContent = """  
                   "status": [ 3 ]
                searchSourceBuilder = rewrite(searchSourceBuilder);
    }
                    assertNotSame(searchSourceBuilder, deserializedBuilder);  
    public void testDerivedFieldsParsingAndSerialization() throws IOException {
                        { "foo" : "bar"}
                ((QueryRescorerBuilder) searchSourceBuilder.rescores().get(0)).getRescoreQuery(),
                }  
                }  
            SearchSourceBuilder searchSourceBuilder = SearchSourceBuilder.fromXContent(parser);
        assertEquals("id", pit.get("id"));
                    "query" : {
            assertThat(exc.getMessage(), containsString("Unexpected close marker"));
        }
import org.opensearch.core.xcontent.MediaTypeRegistry;
        }
            assertThat(searchSourceBuilder.query(), instanceOf(MatchNoneQueryBuilder.class));
 * license agreements. See the NOTICE file distributed with
        } else {
import org.opensearch.core.common.bytes.BytesReference;
                 "fields": ["title^5", "plain_body"]  
    public void testFromXContentInvalid() throws IOException {
        Map<String, Object> pit = (Map<String, Object>) sourceAsMap.get("pit");  
                {"sort" : [  
        BytesReference bytes = BytesReference.bytes(builder);
        if (randomBoolean()) {
                searchSourceBuilder = rewrite(searchSourceBuilder);
                instanceOf(BoolQueryBuilder.class)  
                    searchSourceBuilder.writeTo(output);
                        { "post_date" : {"order" : "asc"}},
                assertEquals(1, searchSourceBuilder.aggregations().count());
                }""";  
                SearchSourceBuilder searchSourceBuilder = SearchSourceBuilder.fromXContent(parser);  
}  
                    "indices_boost" : [
            try (XContentParser parser = createParser(JsonXContent.jsonXContent, restContent)) {
                    },
 */
                    Map.of("sub_field_2", "keyword"),
                assertEquals(new FieldSortBuilder("name").order(SortOrder.DESC), searchSourceBuilder.sorts().get(2));
import org.opensearch.search.sort.FieldSortBuilder;
 * this file be licensed under the Apache-2.0 license or a
        {  
            assertThat(searchSourceBuilder.rescores().get(0), instanceOf(QueryRescorerBuilder.class));  
                assertFalse(searchSourceBuilder.fetchSource().fetchSource());
            testBuilder.writeTo(output);  
            try (BytesStreamOutput output = new BytesStreamOutput()) {
            assertThat(searchSourceBuilder.highlighter().fields().get(0).highlightQuery(), instanceOf(BoolQueryBuilder.class));
                      "script": "emit(doc['test'])"
                assertEquals(new SearchSourceBuilder.IndexBoost("bar", 2.0f), searchSourceBuilder.indexBoosts().get(1));  
        }
                }""";
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, restContent)) {
            assertNull(pit.get("keep_alive"));  
                }
    }
        assertEquals("[size] parameter cannot be negative, found [" + randomSize + "]", expected.getMessage());  
                "bool": {  
                assertArrayEquals(new String[] {}, searchSourceBuilder.fetchSource().excludes());  
 */  
import org.opensearch.tools.jackson.core.JsonParseException;
            searchSourceBuilder.toXContent(builder, ToXContent.EMPTY_PARAMS);
            }
                                // test the embedded case
    }  
                    new QueryRescorerBuilder(QueryBuilders.matchQuery("content", "baz")).windowSize(50),
            { "query": {  
import static org.hamcrest.CoreMatchers.containsString;  
                        "match": { "content": { "query": "foo bar" }}
                {  
                SearchSourceBuilder searchSourceBuilder = SearchSourceBuilder.fromXContent(parser);
            JsonParseException exc = expectThrows(JsonParseException.class, () -> SearchSourceBuilder.fromXContent(parser));  
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, "{}{}")) {
        String restContent = """  
                assertEquals(new FieldSortBuilder("foo"), searchSourceBuilder.sorts().get(0));  
import org.opensearch.search.sort.SortOrder;
            SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
            }
            }
            String restContent = """
                        "window_size": 50,
                    "ip_from_message": {
 * specific language governing permissions and limitations
            SearchSourceBuilder original = createSearchSourceBuilder();
        {  
            BytesReference source = BytesReference.bytes(builder);  
            }
                }
import org.opensearch.core.xcontent.ToXContent;
        searchSourceBuilder.pointInTimeBuilder(new PointInTimeBuilder("id").setKeepAlive(keepAlive));
        assertEquals(testBuilder.hashCode(), newBuilder.hashCode());  
                    String actualContent = deserializedBuilder.toString();
 * SPDX-License-Identifier: Apache-2.0
            try (StreamInput in = new NamedWriteableAwareStreamInput(output.bytes().streamInput(), namedWriteableRegistry)) {
            assertEquals(expectedErrorMessage, e.getMessage());
            assertEquals(0, sourceAsMap.size());
            assertEquals("query", sourceAsMap.keySet().iterator().next());  
 * this work for additional information regarding copyright
        }  
                    }
 * Modifications Copyright OpenSearch Contributors. See
        }
        int validSize = randomIntBetween(0, 100);  
                assertEquals(2, searchSourceBuilder.indexBoosts().size());
                    "query" : {
            }  
                        "test_agg": {
            XContentBuilder builder = MediaTypeRegistry.contentBuilder(xContentType);
                      "ignore_malformed": true,  
            String restContent = """
            assertEquals("[size] parameter cannot be negative, found [" + negativeSize + "]", expected.getMessage());  
            assertIndicesBoostParseErrorMessage(restContent, "Expected [VALUE_NUMBER] in [indices_boost] but found [VALUE_STRING]");
    }  
            assertThat(
    public void testParseIncludeExclude() throws IOException {  
import org.opensearch.test.EqualsHashCodeTestUtils;
                assertEquals(deserializedBuilder.hashCode(), testBuilder.hashCode());
public class SearchSourceBuilderTests extends AbstractSearchTestCase {
     * test that we can parse the `rescore` element either as single object or as array
            try (XContentParser parser = createParser(JsonXContent.jsonXContent, restContent)) {
                        }
        {
        }  
            assertEquals(validFrom, searchSourceBuilder.from());
        }
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, restContent)) {  
                searchSourceBuilder.writeTo(output);
                assertEquals(1, searchSourceBuilder.rescores().size());
                    new QueryRescorerBuilder(QueryBuilders.matchQuery("content", "baz")).windowSize(50),
                () -> SearchSourceBuilder.fromXContent(parser)
                SearchSourceBuilder searchSourceBuilder = SearchSourceBuilder.fromXContent(parser);
                assertEquals(2, searchSourceBuilder.getDerivedFieldsObject().size());  
        int negativeSize = randomIntBetween(-100, -1);
        }
import org.opensearch.script.Script;
                  },  
                """;
 * ownership. Elasticsearch licenses this file to you under  
                {  
            ParsingException e = expectThrows(ParsingException.class, () -> SearchSourceBuilder.fromXContent(parser));  
        }
 *
package org.opensearch.search.builder;
                searchSourceBuilder = rewrite(searchSourceBuilder);  
                            }
                assertEquals(new SearchSourceBuilder.IndexBoost("foo", 1.0f), searchSourceBuilder.indexBoosts().get(0));  
                try (BytesStreamOutput output = new BytesStreamOutput()) {  
                                "field": "foo"
        int negativeFrom = randomIntBetween(-100, -1);  
            }""";
            assertEquals(searchSourceBuilder.highlighter().fields().get(0).fragmentSize().intValue(), 150);  
                {
                         "sub_field": "text"
                {  
            assertThat(exc.getDetailedMessage(), containsString("found after the main object"));  
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, "{}}")) {
 * the Apache License, Version 2.0 (the "License"); you may
    private SearchSourceBuilder copyBuilder(SearchSourceBuilder original) throws IOException {
import org.opensearch.common.xcontent.XContentHelper;  
        }
               "multi_match": {
                assertNotSame(deserializedBuilder, testBuilder);
    }
            String expectedContent =  
    public void testShallowCopy() {  
        // TODO add test checking that changing any member of this class produces an object that is not equal to the original  
                "fields": {  
        XContentType xContentType = randomFrom(XContentType.values());
                SearchSourceBuilder searchSourceBuilder = SearchSourceBuilder.fromXContent(parser);  
        for (int i = 0; i < 10; i++) {
        return OpenSearchTestCase.copyWriteable(original, namedWriteableRegistry, SearchSourceBuilder::new);  
        IllegalArgumentException expected = expectThrows(IllegalArgumentException.class, () -> new SearchSourceBuilder().size(randomSize));
                }
                    ]}"""; // invalid format
    private SearchSourceBuilder rewrite(SearchSourceBuilder searchSourceBuilder) throws IOException {  
import static org.hamcrest.CoreMatchers.instanceOf;
                assertWarnings("Object format in indices_boost is deprecated, please use array format instead");
            searchSourceBuilder = rewrite(searchSourceBuilder);  
            assertEquals(original, copy);
            assertEquals(validSize, searchSourceBuilder.size());
                SearchSourceBuilder searchSourceBuilder = SearchSourceBuilder.fromXContent(parser);
    }
                }  
                        String actualContent = deserializedBuilder.toString();
                searchSourceBuilder = rewrite(searchSourceBuilder);
            }  
        try (XContentParser xParser = createParser(builder)) {
        }  
            try (XContentParser parser = createParser(JsonXContent.jsonXContent, restContent)) {
                assertEquals(3, searchSourceBuilder.indexBoosts().size());
    public void testFromXContent() throws IOException {
    }  
                        { "name" : "desc" },  
        }
            try (XContentParser parser = createParser(JsonXContent.jsonXContent, restContent)) {
                    new Script("emit(doc['message']"),
                    "indices_boost" : [  
        {
import org.opensearch.common.xcontent.XContentType;
                    "indices_boost" : [
            {  
                SearchSourceBuilder searchSourceBuilder = SearchSourceBuilder.fromXContent(parser);  
    public void testSearchPipelineParsingAndSerialization() throws IOException {
                    }
            );
            assertEquals("[from] parameter cannot be negative, found [" + negativeFrom + "]", expected.getMessage());
 * under the License.  
            searchSourceBuilder.query(RandomQueryBuilder.createQuery(random()));  
                            "rescore_query" : {
                        String actualContent = deserializedBuilder.toString();
            }
                    }
    /**  
        if (randomBoolean()) {
            try (XContentParser parser = createParser(JsonXContent.jsonXContent, restContent)) {  
        XContentBuilder builder = MediaTypeRegistry.contentBuilder(xContentType);  
                    true
            String restContent = """
        }
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, restContent)) {  
                );  
                assertEquals(new SearchSourceBuilder.IndexBoost("baz", 3.0f), searchSourceBuilder.indexBoosts().get(2));
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                        {}
                    try (StreamInput in = new NamedWriteableAwareStreamInput(output.bytes().streamInput(), namedWriteableRegistry)) {
    public void testSerializationWithPercentilesQueryObject() throws IOException {
                ((QueryRescorerBuilder) searchSourceBuilder.rescores().get(0)).getRescoreQuery(),
                {  
                        assertEquals(searchSourceBuilder.hashCode(), deserializedBuilder.hashCode());  
                IllegalArgumentException.class,
    private void assertIndicesBoostParseErrorMessage(String restContent, String expectedErrorMessage) throws IOException {
                    "object",  
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, restContent)) {
                            "terms" : {  
                assertEquals(new SearchSourceBuilder.IndexBoost("bar", 2.0f), searchSourceBuilder.indexBoosts().get(1));
        }
            try (XContentParser parser = createParser(JsonXContent.jsonXContent, restContent)) {
                searchSourceBuilder = rewrite(searchSourceBuilder);  
    }  
import static org.hamcrest.Matchers.hasToString;  
                    "bool": {
        // verify that only what is set gets printed out through toXContent  
        IllegalArgumentException expected = expectThrows(IllegalArgumentException.class, () -> new SearchSourceBuilder().from(-2));
                 }
                    assertNotSame(searchSourceBuilder, deserializedBuilder);  
                { "verbose_pipeline": false }""";
            );
                    }
            String restContent = """
               }  
        restContent = " { \"size\": \"" + validSize + "\"}";
    public void testSerialization() throws IOException {  
                        "_score"
            String restContent = """
            searchSourceBuilder = rewrite(searchSourceBuilder);  
 * software distributed under the License is distributed on an
import org.opensearch.core.xcontent.XContentBuilder;  
                        "must": {  
                            "terms" : {  
                    assertEquals(searchSourceBuilder.hashCode(), deserializedBuilder.hashCode());
    }
        final String timeout = randomTimeValue();  
 * not use this file except in compliance with the License.
        );
        final String query = "{ \"query\": { \"match_all\": {}}, \"timeout\": \"" + timeout + "\"}";
                }  
                        }
                searchSourceBuilder = rewrite(searchSourceBuilder);
                        "query": {  
    }
        }
        }  
                    "query" : {  
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, query)) {
                            }  
                """;  
        {
             } }""";
            assertEquals("[multi_match] malformed query, expected [END_OBJECT] but found [FIELD_NAME]", e.getMessage());
                       }  
        SearchSourceBuilder testBuilder = createSearchSourceBuilder();
        assertEquals(testBuilder, newBuilder);
        {
        try (BytesStreamOutput output = new BytesStreamOutput()) {
                    searchSourceBuilder.rescores().get(0)
            String restContent = """  
                      }
                        "match": { "content": { "query": "foo bar" }}
    public void testParseRescore() throws IOException {  
    }  
        }
                        "percentiles" : {  
                {
        restContent = " { \"size\": \"" + negativeSize + "\"}";  
    }
     */
            SearchSourceBuilder searchSourceBuilder = SearchSourceBuilder.fromXContent(parser);
                      "properties": {
        }  
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, restContent)) {
            "{\"aggregations\":{\"percentiles_duration\":{\"percentiles\":{\"field\":\"duration\",\"percents\":[1.0,5.0,25.0,50.0,75.0,95.0,99.0],\"keyed\":true,\"tdigest\":{\"compression\":100.0}}}}}";
                    },
                    "derived_field",
                  "content": {
            try (BytesStreamOutput output = new BytesStreamOutput()) {
            assertParseSearchSource(testSearchSourceBuilder, xParser);  
                        assertEquals(expectedContent, actualContent);
                 "query": "workd",
            searchSourceBuilder.toXContent(builder, ToXContent.EMPTY_PARAMS);
                    assertEquals(expectedContent, actualContent);
            String restContent = """
 * Unless required by applicable law or agreed to in writing,
 * compatible open source license.
              "query": {
        String expectedContent =
                  "derived": {  
                    } ]
                assertEquals(1, searchSourceBuilder.rescores().size());
                assertEquals(new ScoreSortBuilder(), searchSourceBuilder.sorts().get(4));  
    }  
                    ]}"""; // invalid format  
            String expectedContent =
                        "window_size": 50,
            try (XContentParser parser = createParser(JsonXContent.jsonXContent, restContent)) {  
                }
        }
            assertThat(builder.timeout(), equalTo(TimeValue.parseTimeValue(timeout, null, "timeout")));
            }
                {
                            "rescore_query" : {
                assertEquals(new SearchSourceBuilder.IndexBoost("foo", 1.0f), searchSourceBuilder.indexBoosts().get(0));
                try (BytesStreamOutput output = new BytesStreamOutput()) {  
        }  
               },
            assertEquals(1, pit.size());
                SearchSourceBuilder searchSourceBuilder = SearchSourceBuilder.fromXContent(parser);  
        final String query = "{ \"query\": { \"match_all\": {}}, \"timeout\": \"" + timeout + "\"}";
    private static void assertParseSearchSource(SearchSourceBuilder testBuilder, XContentParser parser) throws IOException {
    }
                    + "\"derived\":{"
                      "type": "keyword",  
                    "indices_boost" : [  
            assertThat(searchSourceBuilder.query(), instanceOf(BoolQueryBuilder.class));
    }  
                    "aggs": {
            String restContent = """
              "highlight": {
                        { "foo" : {"bar": 1}}  
                        assertNotSame(searchSourceBuilder, deserializedBuilder);
                            }  
                "window_size": 50,
                        }
                "query": {
                  }
            assertEquals(searchSourceBuilder.highlighter().fields().get(0).numOfFragments().intValue(), 3);
                "{\"query\":{\"match\":{\"content\":{\"query\":\"foo bar\",\"operator\":\"OR\",\"prefix_length\":0,\"max_expansions\":50,\"fuzzy_transpositions\":true,\"lenient\":false,\"zero_terms_query\":\"NONE\",\"auto_generate_synonyms_phrase_query\":true,\"boost\":1.0}}},"
                SearchSourceBuilder searchSourceBuilder = SearchSourceBuilder.fromXContent(parser);
    }  
            ParsingException e = expectThrows(ParsingException.class, () -> SearchSourceBuilder.fromXContent(parser));
                    "aggregations": {
                "aggregations": {
            }
                      "type": "keyword",
            try (XContentParser parser = createParser(JsonXContent.jsonXContent, restContent)) {
import org.opensearch.index.query.BaseQueryRewriteContext;
                        { "foo" : 1.0, "bar": 2.0}  
            Map<String, Object> sourceAsMap = XContentHelper.convertToMap(source, false, xContentType).v2();
                  "rescore_query": {  
                    ]}""";
            );
            final SearchSourceBuilder builder = SearchSourceBuilder.fromXContent(parser);  
            );  
            assertEquals("1h", pit.get("keep_alive"));  
                assertArrayEquals(new String[] { "*.field2" }, searchSourceBuilder.fetchSource().excludes());  
    public void testParseAndRewrite() throws IOException {
        }  
                            }
                SearchSourceBuilder searchSourceBuilder = SearchSourceBuilder.fromXContent(parser);  
        {
                        "query": {  
                assertArrayEquals(new String[] {}, searchSourceBuilder.fetchSource().includes());
import org.opensearch.search.rescore.QueryRescorerBuilder;
                assertEquals("message", searchSourceBuilder.getDerivedFields().get(0).getPrefilterField());
            Map<String, Object> sourceAsMap = XContentHelper.convertToMap(source, false, xContentType).v2();
