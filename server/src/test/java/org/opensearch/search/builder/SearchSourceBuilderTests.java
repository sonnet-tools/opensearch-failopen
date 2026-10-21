                        "must": {
                        }
                try (StreamInput in = new NamedWriteableAwareStreamInput(output.bytes().streamInput(), namedWriteableRegistry)) {
    }
            try (XContentParser parser = createParser(JsonXContent.jsonXContent, restContent)) {
    }
                  }
            }
            }
                    "aggs": {
                assertEquals(1, searchSourceBuilder.rescores().size());
        return Rewriteable.rewrite(
                        { "foo" : 1.0 },
                      "script": "emit(doc['message'])"
        }
                        "percentiles" : {
 *    http://www.apache.org/licenses/LICENSE-2.0
    public void testDerivedFieldsParsingAndSerialization() throws IOException {
            }
    }
                    "duration": {
                            "field": "duration"
                        "user",
            {
                    searchSourceBuilder.rescores().get(0)
                try (BytesStreamOutput output = new BytesStreamOutput()) {
        assertEquals("id", pit.get("id"));
            assertEquals("1h", pit.get("keep_alive"));
                assertEquals(new SearchSourceBuilder.IndexBoost("foo", 1.0f), searchSourceBuilder.indexBoosts().get(0));
            BytesReference source = BytesReference.bytes(builder);
                    "rescore": {
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, restContent)) {
import org.opensearch.index.query.Rewriteable;
        XContentBuilder builder = MediaTypeRegistry.contentBuilder(xContentType);
        }
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, restContent)) {
import org.opensearch.core.common.bytes.BytesReference;
    }
                    "object",
                "query": {
        restContent = " { \"from\": \"" + validFrom + "\"}";
                         "sub_field": "text"
    public void testNegativeSizeErrors() {
        }
               "filters": {
                    ]}"""; // invalid format
            String restContent = """
        }
                assertEquals(deserializedBuilder.hashCode(), testBuilder.hashCode());
                { "indices_boost": {"foo": 1.0, "bar": 2.0}}""";
        testSearchSourceBuilder.toXContent(builder, ToXContent.EMPTY_PARAMS);
    }
                        {}
import org.opensearch.index.query.QueryBuilders;
                      "type": "long",
                "{\"query\":{\"match\":{\"content\":{\"query\":\"foo bar\",\"operator\":\"OR\",\"prefix_length\":0,\"max_expansions\":50,\"fuzzy_transpositions\":true,\"lenient\":false,\"zero_terms_query\":\"NONE\",\"auto_generate_synonyms_phrase_query\":true,\"boost\":1.0}}},\"derived\":{\"duration\":{\"type\":\"long\",\"script\":\"emit(doc['test'])\"},\"ip_from_message\":{\"type\":\"keyword\",\"script\":\"emit(doc['message'])\"},\"object\":{\"format\":\"dd-MM-yyyy\",\"prefilter_field\":\"test\",\"ignore_malformed\":true,\"type\":\"object\",\"script\":\"emit(doc['test'])\",\"properties\":{\"sub_field\":\"text\"}},\"derived_field\":{\"type\":\"object\",\"script\":{\"source\":\"emit(doc['message']\",\"lang\":\"painless\"},\"properties\":{\"sub_field_2\":\"keyword\"},\"prefilter_field\":\"message\",\"format\":\"dd-MM-yyyy\",\"ignore_malformed\":true}}}";
                        SearchSourceBuilder deserializedBuilder = new SearchSourceBuilder(in);
    // we use the streaming infra to create a copy of the builder provided as argument
    }
            assertEquals("query", sourceAsMap.keySet().iterator().next());
 */
        {
        {
        int negativeSize = randomIntBetween(-100, -1);
import org.opensearch.core.common.io.stream.NamedWriteableAwareStreamInput;
                    "aggregations": {
        }
                    "query" : {
        expected = expectThrows(IllegalArgumentException.class, () -> new SearchSourceBuilder().size(-1));
            assertThat(searchSourceBuilder.query(), instanceOf(MatchNoneQueryBuilder.class));
        }
        {
                searchSourceBuilder = rewrite(searchSourceBuilder);
                {
    public void testTimeoutWithoutUnits() throws IOException {
              }
                          "match_none": {}
            assertParseSearchSource(testSearchSourceBuilder, xParser);
        }
                    ]}"""; // invalid format
              "query": {
            assertEquals(original, copy);
        assertEquals("[from] parameter cannot be negative, found [-2]", expected.getMessage());
import static org.hamcrest.CoreMatchers.containsString;
        }
                    "query" : {
                searchSourceBuilder = rewrite(searchSourceBuilder);
                   "status": [ 3 ]
                 "fields": ["title^5", "plain_body"]
    public void testFromXContent() throws IOException {
                     },
    public void testVerbosePipeline() throws IOException {
 * software distributed under the License is distributed on an
                        "_score"
            String restContent = """
                    }
                    }
        {
 * not use this file except in compliance with the License.
                                "match": { "content": { "query": "baz" } }
import org.opensearch.core.xcontent.MediaTypeRegistry;
                }
                    "match_none": {}
            new BaseQueryRewriteContext(xContentRegistry(), writableRegistry(), null, Long.valueOf(1)::longValue)
            IllegalArgumentException expected = expectThrows(
                    assertEquals(expectedContent, actualContent);
import org.opensearch.search.sort.FieldSortBuilder;
        {
            try (XContentParser parser = createParser(JsonXContent.jsonXContent, restContent)) {
        }
                      "bool": {
                      "script": "emit(doc['test'])"
        TimeValue keepAlive = randomBoolean() ? TimeValue.timeValueHours(1) : null;
                        SearchSourceBuilder deserializedBuilder = new SearchSourceBuilder(in);
            SearchSourceBuilder searchSourceBuilder = SearchSourceBuilder.fromXContent(parser);
                );
package org.opensearch.search.builder;
            assertThat(exc.getMessage(), containsString("Unexpected close marker"));
                    "fragment_size": 150,
    }
                {
    }
                assertEquals(1, searchSourceBuilder.aggregations().count());
    public void testShallowCopy() {
            assertNull(pit.get("keep_alive"));
        if (randomBoolean()) {
            assertEquals(searchSourceBuilder.highlighter().fields().get(0).numOfFragments().intValue(), 3);
            try (XContentParser parser = createParser(JsonXContent.jsonXContent, restContent)) {
                      "ignore_malformed": true,
                    new QueryRescorerBuilder(QueryBuilders.matchQuery("content", "baz")).windowSize(50),
            try (XContentParser parser = createParser(JsonXContent.jsonXContent, restContent)) {
                    }
            searchSourceBuilder,
import java.util.Map;
            }
        searchSourceBuilder.toXContent(builder, ToXContent.EMPTY_PARAMS);
        }
    }
                assertEquals(new FieldSortBuilder("foo"), searchSourceBuilder.sorts().get(0));
    }
            builder = builder.prettyPrint();
                SearchSourceBuilder searchSourceBuilder = SearchSourceBuilder.fromXContent(parser);
                    searchSourceBuilder.rescores().get(0)
                    "highlight_query": {
        SearchSourceBuilder newBuilder = SearchSourceBuilder.fromXContent(parser);
            "{\"aggregations\":{\"percentiles_duration\":{\"percentiles\":{\"field\":\"duration\",\"percents\":[1.0,5.0,25.0,50.0,75.0,95.0,99.0],\"keyed\":true,\"tdigest\":{\"compression\":100.0}}}}}";
                    }
    public void testMultipleQueryObjectsAreRejected() throws Exception {
                  "derived": {
                SearchSourceBuilder searchSourceBuilder = SearchSourceBuilder.fromXContent(parser);
            String restContent = """
                {
 * under the License.
        }
                );
        }
                    new Script("emit(doc['message']"),
            );
                {
                searchSourceBuilder = rewrite(searchSourceBuilder);
            Map<String, Object> sourceAsMap = XContentHelper.convertToMap(source, false, xContentType).v2();
 *
                """;
                assertFalse(searchSourceBuilder.verbosePipeline());
import org.opensearch.common.xcontent.XContentType;
    public void testSerialization() throws IOException {
        {
                "aggregations": {
                        }
        }
                assertArrayEquals(new String[] {}, searchSourceBuilder.fetchSource().includes());
                assertEquals(2, searchSourceBuilder.indexBoosts().size());
    private SearchSourceBuilder rewrite(SearchSourceBuilder searchSourceBuilder) throws IOException {
            assertIndicesBoostParseErrorMessage(restContent, "Expected [VALUE_NUMBER] in [indices_boost] but found [START_OBJECT]");
    public void testNegativeFromErrors() {
            try (XContentParser parser = createParser(JsonXContent.jsonXContent, restContent)) {
                        "test_agg": {
            ParsingException exc = expectThrows(ParsingException.class, () -> SearchSourceBuilder.fromXContent(parser));
                assertWarnings("Object format in indices_boost is deprecated, please use array format instead");
                    String actualContent = deserializedBuilder.toString();
            SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        // TODO add test checking that changing any member of this class produces an object that is not equal to the original
            assertEquals(2, pit.size());
import org.opensearch.index.query.RandomQueryBuilder;
import static org.hamcrest.Matchers.equalTo;
            }
                { "verbose_pipeline": false }""";
                    "object": {
                    + "\"duration\":{\"type\":\"long\",\"script\":\"emit(doc['test'])\"},\"ip_from_message\":{\"type\":\"keyword\",\"script\":\"emit(doc['message'])\"},\"derived_field\":{\"type\":\"keyword\",\"script\":{\"source\":\"emit(doc['message']\",\"lang\":\"painless\"}}}}";
                    "indices_boost" : [
                searchSourceBuilder = rewrite(searchSourceBuilder);
                SearchSourceBuilder searchSourceBuilder = SearchSourceBuilder.fromXContent(parser);
                        }
                    "duration": {
        String restContent = """
        SearchSourceBuilder testSearchSourceBuilder = createSearchSourceBuilder();
                () -> SearchSourceBuilder.fromXContent(parser)
                assertEquals(1, searchSourceBuilder.rescores().size());
                      }
                "{\"query\":{\"match\":{\"content\":{\"query\":\"foo bar\",\"operator\":\"OR\",\"prefix_length\":0,\"max_expansions\":50,\"fuzzy_transpositions\":true,\"lenient\":false,\"zero_terms_query\":\"NONE\",\"auto_generate_synonyms_phrase_query\":true,\"boost\":1.0}}},"
                assertArrayEquals(new String[] { "include" }, searchSourceBuilder.fetchSource().includes());
            searchSourceBuilder = rewrite(searchSourceBuilder);
    public void testDerivedFieldsParsingAndSerializationObjectType() throws IOException {
                      "script": "emit(doc['test'])",
                }
              },
                SearchSourceBuilder searchSourceBuilder = SearchSourceBuilder.fromXContent(parser);
            assertEquals("[from] parameter cannot be negative, found [" + negativeFrom + "]", expected.getMessage());
                    "indices_boost" : [
                assertEquals(new FieldSortBuilder("user"), searchSourceBuilder.sorts().get(1));
                {
                        }
                  "rescore_query": {
            }
                    "indices_boost" : [
            XContentBuilder builder = MediaTypeRegistry.contentBuilder(xContentType);
                assertEquals(
    public void testAggsParsing() throws IOException {
            final SearchSourceBuilder builder = SearchSourceBuilder.fromXContent(parser);
        assertEquals(testBuilder, newBuilder);
    }
    }
                    assertNotSame(searchSourceBuilder, deserializedBuilder);
import org.opensearch.index.query.BaseQueryRewriteContext;
            String restContent = """
    private static void assertParseSearchSource(SearchSourceBuilder testBuilder, XContentParser parser) throws IOException {
                assertEquals(3, searchSourceBuilder.indexBoosts().size());
    }
            searchSourceBuilder = rewrite(searchSourceBuilder);
            assertEquals(1, sourceAsMap.size());
                    "ip_from_message": {
            SearchSourceBuilder searchSourceBuilder = SearchSourceBuilder.fromXContent(parser);
    }
        final String query = "{ \"query\": { \"match_all\": {}}, \"timeout\": \"" + timeout + "\"}";
    }
        try (BytesStreamOutput output = new BytesStreamOutput()) {
            String expectedContent =
                    true
                SearchSourceBuilder searchSourceBuilder = SearchSourceBuilder.fromXContent(parser);
                        { "name" : "desc" },
                    "message",
                { "_source": false}""";
                }
                }""";
import org.opensearch.tools.jackson.core.JsonParseException;
            }
                        { "bar" : 2.0 },
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, restContent)) {
import org.opensearch.index.query.BoolQueryBuilder;
                assertTrue(searchSourceBuilder.getDerivedFields().get(0).getIgnoreMalformed());
            }
/*
    public void testParseRescore() throws IOException {
                    SearchSourceBuilder deserializedBuilder = new SearchSourceBuilder(in);
            assertEquals("[size] parameter cannot be negative, found [" + negativeSize + "]", expected.getMessage());
                    "rescore": [ {
        final int timeout = randomIntBetween(1, 1024);
            assertThat(builder.timeout(), equalTo(TimeValue.parseTimeValue(timeout, null, "timeout")));
                      "type": "long",
                assertTrue(searchSourceBuilder.verbosePipeline());
                { "_source": { "includes": "include", "excludes": "*.field2"}}""";
            try (BytesStreamOutput output = new BytesStreamOutput()) {
            String restContent = """
                    try (StreamInput in = new NamedWriteableAwareStreamInput(output.bytes().streamInput(), namedWriteableRegistry)) {
            final IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> SearchSourceBuilder.fromXContent(parser));
        restContent = " { \"size\": \"" + validSize + "\"}";
            parser.nextToken(); // sometimes we move it on the START_OBJECT to
    }
                        "window_size": 50,
                  "must": {
        {
                searchSourceBuilder.writeTo(output);
                    "number_of_fragments": 3,
            assertThat(searchSourceBuilder.highlighter().fields().get(0).highlightQuery(), instanceOf(MatchNoneQueryBuilder.class));
    }
                    },
              "rescore": {
        }
                    searchSourceBuilder.writeTo(output);
                "bool": {
                { "verbose_pipeline": true }""";
                    }
                        assertEquals(expectedContent, actualContent);
            { "query": { "match_all": {} }, "from": 0, "size": 10, "search_pipeline": "my_pipeline" }""";
            assertThat(searchSourceBuilder.query(), instanceOf(BoolQueryBuilder.class));
                assertEquals(2, searchSourceBuilder.getDerivedFieldsObject().size());
            IllegalArgumentException expected = expectThrows(
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, restContent)) {
                                // test the embedded case
 * SPDX-License-Identifier: Apache-2.0
                {
                assertEquals(1, searchSourceBuilder.aggregations().count());
            String restContent = """
                            }
     */
 * ownership. Elasticsearch licenses this file to you under
        String restContent = """
 * GitHub history for details.
        int validFrom = randomIntBetween(0, 100);
                assertEquals(1, searchSourceBuilder.getDerivedFields().size());
                    } ]
                ((QueryRescorerBuilder) searchSourceBuilder.rescores().get(0)).getRescoreQuery(),
                    "indices_boost" : [
                assertEquals(deserializedBuilder, testBuilder);
        XContentType xContentType = randomFrom(XContentType.values());
                    Map.of("sub_field_2", "keyword"),
        int negativeFrom = randomIntBetween(-100, -1);
            try (XContentParser parser = createParser(JsonXContent.jsonXContent, restContent)) {
/*
    }
            }
            Map<String, Object> sourceAsMap = XContentHelper.convertToMap(source, false, xContentType).v2();
import org.opensearch.core.common.io.stream.StreamInput;
                        "window_size": 50,
    public void testParseIndicesBoost() throws IOException {
                    ]}""";
        }
            searchSourceBuilder.toXContent(builder, ToXContent.EMPTY_PARAMS);
            SearchSourceBuilder searchSourceBuilder = SearchSourceBuilder.fromXContent(parser);
        // verify that only what is set gets printed out through toXContent
                            "rescore_query" : {
            String restContent = """
                searchSourceBuilder = rewrite(searchSourceBuilder);
                assertEquals(1, searchSourceBuilder.getDerivedFields().get(0).getProperties().size());
                () -> SearchSourceBuilder.fromXContent(parser)
                ((QueryRescorerBuilder) searchSourceBuilder.rescores().get(0)).getRescoreQuery(),
             } }""";
                {
            try (XContentParser parser = createParser(JsonXContent.jsonXContent, restContent)) {
            """;
                assertNotSame(deserializedBuilder, testBuilder);
        final String timeout = randomTimeValue();
import static org.hamcrest.CoreMatchers.instanceOf;
        {
            try (XContentParser parser = createParser(JsonXContent.jsonXContent, restContent)) {
            );
        }
                  }
            try (XContentParser parser = createParser(JsonXContent.jsonXContent, restContent)) {
        if (randomBoolean()) {
        String expectedContent = "{\"from\":0,\"size\":10,\"query\":{\"match_all\":{\"boost\":1.0}},\"search_pipeline\":\"my_pipeline\"}";
            assertEquals(1, pit.size());
        }
                        }
 * specific language governing permissions and limitations
        String expectedContent =
            SearchSourceBuilder original = createSearchSourceBuilder();
                }
                    }
                  },
                        { "foo" : 1.0, "bar": 2.0}
              "highlight": {
import org.opensearch.common.xcontent.json.JsonXContent;
                    assertEquals(searchSourceBuilder.hashCode(), deserializedBuilder.hashCode());
        {
                            }
        }
        Map<String, Object> pit = (Map<String, Object>) sourceAsMap.get("pit");
            ParsingException e = expectThrows(ParsingException.class, () -> SearchSourceBuilder.fromXContent(parser));
    private SearchSourceBuilder copyBuilder(SearchSourceBuilder original) throws IOException {
        }
        {
            }
                {
            String restContent = """
                try (BytesStreamOutput output = new BytesStreamOutput()) {
 * Licensed to Elasticsearch under one or more contributor
import org.opensearch.test.EqualsHashCodeTestUtils;
        assertEquals("[size] parameter cannot be negative, found [-1]", expected.getMessage());
                        "query": {
        try (XContentParser xParser = createParser(builder)) {
                SearchSourceBuilder searchSourceBuilder = SearchSourceBuilder.fromXContent(parser);
     * test that we can parse the `rescore` element either as single object or as array
            testBuilder.writeTo(output);
                assertFalse(searchSourceBuilder.verbosePipeline());
 * The OpenSearch Contributors require contributions made to
                    }
    public void testToXContentWithPointInTime() throws IOException {
            assertThat(exc.getDetailedMessage(), containsString("found after the main object"));
    public void testParseFromAndSize() throws IOException {
                "fields": {
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, restContent)) {
                try (StreamInput in = new NamedWriteableAwareStreamInput(output.bytes().streamInput(), namedWriteableRegistry)) {
                }
        {
                        String actualContent = deserializedBuilder.toString();
            searchSourceBuilder.toXContent(builder, ToXContent.EMPTY_PARAMS);
                    ]}"""; // invalid format
    public void testEqualsAndHashcode() throws IOException {
 * KIND, either express or implied.  See the License for the
        EqualsHashCodeTestUtils.checkEqualsAndHashCode(createSearchSourceBuilder(), this::copyBuilder);
                  "derived": {
        {
}
 * Unless required by applicable law or agreed to in writing,
    }
                      "type": "object",
    }
                "order": "score",
                                "match": { "content": { "query": "baz" } }
                assertEquals("message", searchSourceBuilder.getDerivedFields().get(0).getPrefilterField());
                        String actualContent = deserializedBuilder.toString();
        restContent = " { \"size\": \"" + negativeSize + "\"}";
                assertEquals(5, searchSourceBuilder.sorts().size());
                     },
        {
                { "sort": "foo"}""";
        }
            assertEquals(expectedErrorMessage, e.getMessage());
            assertThat(searchSourceBuilder.rescores().get(0), instanceOf(QueryRescorerBuilder.class));
            assertIndicesBoostParseErrorMessage(restContent, "Expected [VALUE_NUMBER] in [indices_boost] but found [VALUE_STRING]");
                }
                    + "\"derived\":{"
            String restContent = """
import org.opensearch.core.common.ParsingException;
                        "match": { "content": { "query": "foo bar" }}
            assertEquals(validFrom, searchSourceBuilder.from());
            }
                      "properties": {
                                "field": "foo"
 * license agreements. See the NOTICE file distributed with
                 }
        String restContent = " { \"from\": \"" + negativeFrom + "\"}";
                searchSourceBuilder = rewrite(searchSourceBuilder);
import org.opensearch.core.xcontent.ToXContent;
                    "percentiles_duration": {
    }
            );
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, query)) {
        final String query = "{ \"query\": { \"match_all\": {}}, \"timeout\": \"" + timeout + "\"}";
    /**
        }
            }
                    SearchSourceBuilder deserializedBuilder = new SearchSourceBuilder(in);
import org.opensearch.core.xcontent.XContentBuilder;
            assertThat(searchSourceBuilder.highlighter().fields().get(0).highlightQuery(), instanceOf(BoolQueryBuilder.class));
        );
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, restContent)) {
                        { "baz" : 3.0 }
        }
            try (XContentParser parser = createParser(JsonXContent.jsonXContent, restContent)) {
                assertEquals(new SearchSourceBuilder.IndexBoost("foo", 1.0f), searchSourceBuilder.indexBoosts().get(0));
                        "match": { "content": { "query": "foo bar" }}
                """;
            SearchSourceBuilder searchSourceBuilder = SearchSourceBuilder.fromXContent(parser);
                searchSourceBuilder.writeTo(output);
    public void testFromXContentInvalid() throws IOException {
        assertEquals(1, sourceAsMap.size());
                       }
                SearchSourceBuilder searchSourceBuilder = SearchSourceBuilder.fromXContent(parser);
                    "bool": {
        }
        }
        {
            String restContent = """
                IllegalArgumentException.class,
        String restContent = """
                    },
                SearchSourceBuilder searchSourceBuilder = SearchSourceBuilder.fromXContent(parser);
                        assertEquals(searchSourceBuilder.hashCode(), deserializedBuilder.hashCode());
                {
    }
                            "rescore_query" : {
        SearchSourceBuilder testBuilder = createSearchSourceBuilder();
            }
import org.opensearch.core.xcontent.XContentParser;
                        assertNotSame(searchSourceBuilder, deserializedBuilder);
        }
                    }
            String restContent = """
                            }
              },
        assertEquals(testBuilder.hashCode(), newBuilder.hashCode());
                  "rescore_query_weight": 10
                        { "foo" : {"bar": 1}}
/*
                assertEquals(1, searchSourceBuilder.sorts().size());
        assertNull(parser.nextToken());
                    ]}""";
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, restContent)) {
                }
                        { "age" : "desc" },
            assertThat(
            searchSourceBuilder.query(RandomQueryBuilder.createQuery(random()));
        {
import org.opensearch.common.unit.TimeValue;
    public void testTimeoutWithUnits() throws IOException {
 *
import org.opensearch.search.AbstractSearchTestCase;
                SearchSourceBuilder deserializedBuilder = new SearchSourceBuilder(in);
                            "terms" : {
        }
            assertThat(e, hasToString(containsString("unit is missing or unrecognized")));
        int validSize = randomIntBetween(0, 100);
            assertEquals(0, sourceAsMap.size());
        }
                assertEquals(
            {
            String restContent = """
                """;
            assertEquals(searchSourceBuilder.highlighter().fields().get(0).fragmentSize().intValue(), 150);
            );
 * this work for additional information regarding copyright
            try (XContentParser parser = createParser(JsonXContent.jsonXContent, restContent)) {
    }
                }
                        }
        {
import org.opensearch.test.OpenSearchTestCase;
                """;
                SearchSourceBuilder searchSourceBuilder = SearchSourceBuilder.fromXContent(parser);
            try (XContentParser parser = createParser(JsonXContent.jsonXContent, restContent)) {
 */
        }
                searchSourceBuilder = rewrite(searchSourceBuilder);
            BytesReference source = BytesReference.bytes(builder);
        IllegalArgumentException expected = expectThrows(IllegalArgumentException.class, () -> new SearchSourceBuilder().size(randomSize));
        int randomSize = randomIntBetween(-100000, -2);
                {
                IllegalArgumentException.class,
        }
                searchSourceBuilder.derivedField("derived_field", "keyword", new Script("emit(doc['message']"));
            String restContent = """
                    ]}"""; // invalid format
                  },
 * the Apache License, Version 2.0 (the "License"); you may
            SearchSourceBuilder searchSourceBuilder = SearchSourceBuilder.fromXContent(parser);
            SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
    }
 */
                searchSourceBuilder = rewrite(searchSourceBuilder);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                assertEquals(new FieldSortBuilder("name").order(SortOrder.DESC), searchSourceBuilder.sorts().get(2));
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, restContent)) {
 * Modifications Copyright OpenSearch Contributors. See
                }
                }""";
                assertEquals("dd-MM-yyyy", searchSourceBuilder.getDerivedFields().get(0).getFormat());
    private void assertIndicesBoostParseErrorMessage(String restContent, String expectedErrorMessage) throws IOException {
import org.opensearch.common.xcontent.XContentHelper;
    public void testSearchPipelineParsingAndSerialization() throws IOException {
                assertEquals(new SearchSourceBuilder.IndexBoost("bar", 2.0f), searchSourceBuilder.indexBoosts().get(1));
                        "test_agg": {
            assertIndicesBoostParseErrorMessage(restContent, "Expected [END_OBJECT] in [indices_boost] but found [FIELD_NAME]");
                      "prefilter_field": "test",
        }
        BytesReference bytes = BytesReference.bytes(builder);
public class SearchSourceBuilderTests extends AbstractSearchTestCase {
                assertArrayEquals(new String[] {}, searchSourceBuilder.fetchSource().excludes());
               "multi_match": {
                            }
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
 * compatible open source license.
        XContentBuilder builder = MediaTypeRegistry.contentBuilder(randomFrom(XContentType.values()));
                    "query" : {
        {
                }
    public void testParseSort() throws IOException {
        Map<String, Object> sourceAsMap = XContentHelper.convertToMap(bytes, false, xContentType).v2();
                            "terms" : {
            assertThat(
            try (StreamInput in = new NamedWriteableAwareStreamInput(output.bytes().streamInput(), namedWriteableRegistry)) {
                        { "post_date" : {"order" : "asc"}},
                SearchSourceBuilder searchSourceBuilder = SearchSourceBuilder.fromXContent(parser);
                assertEquals(new SearchSourceBuilder.IndexBoost("baz", 3.0f), searchSourceBuilder.indexBoosts().get(2));
import org.opensearch.search.sort.ScoreSortBuilder;
            assertIndicesBoostParseErrorMessage(restContent, "Expected [FIELD_NAME] in [indices_boost] but found [END_OBJECT]");
                assertArrayEquals(new String[] { "*.field2" }, searchSourceBuilder.fetchSource().excludes());
        return OpenSearchTestCase.copyWriteable(original, namedWriteableRegistry, SearchSourceBuilder::new);
            }
                      }
            String restContent = """
            String restContent = """
                      "type": "keyword",
                assertEquals(new SearchSourceBuilder.IndexBoost("bar", 2.0f), searchSourceBuilder.indexBoosts().get(1));
                        "match": { "content": { "query": "foo bar" }}
            String restContent = """
                    "derived_field",
                {
import org.opensearch.script.Script;
                    assertEquals(searchSourceBuilder.hashCode(), deserializedBuilder.hashCode());
        {
                SearchSourceBuilder searchSourceBuilder = SearchSourceBuilder.fromXContent(parser);
                        { "foo" : "bar"}
        String restContent = """
                assertEquals(new FieldSortBuilder("post_date"), searchSourceBuilder.sorts().get(0));
    public void testParseIncludeExclude() throws IOException {
        }
import java.io.IOException;
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, "{}}")) {
                  "content": {
import org.opensearch.common.io.stream.BytesStreamOutput;
 *
    }
            assertThat(searchSourceBuilder.rescores().get(0), instanceOf(QueryRescorerBuilder.class));
                instanceOf(MatchNoneQueryBuilder.class)
    public void testParseAndRewrite() throws IOException {
    public void testSerializationWithPercentilesQueryObject() throws IOException {
               }
            XContentBuilder builder = MediaTypeRegistry.contentBuilder(xContentType);
                assertEquals(new ScoreSortBuilder(), searchSourceBuilder.sorts().get(4));
        }
            String expectedContent =
                        "match": { "content": { "query": "foo bar" }}
        for (int i = 0; i < 10; i++) {
                }
                {"sort" : [
        {
                    "dd-MM-yyyy",
        IllegalArgumentException expected = expectThrows(IllegalArgumentException.class, () -> new SearchSourceBuilder().from(-2));
                    "indices_boost" : [
                    assertEquals(expectedContent, actualContent);
                      "type": "keyword",
                    assertNotSame(searchSourceBuilder, deserializedBuilder);
            try (XContentParser parser = createParser(JsonXContent.jsonXContent, restContent)) {
        }
import org.opensearch.search.sort.SortOrder;
        }
               },
        }
        }
        }
                        assertEquals(expectedContent, actualContent);
            }
    }
            try (XContentParser parser = createParser(JsonXContent.jsonXContent, restContent)) {
import org.opensearch.index.query.MatchNoneQueryBuilder;
            assertEquals(validSize, searchSourceBuilder.size());
                SearchSourceBuilder searchSourceBuilder = SearchSourceBuilder.fromXContent(parser);
                { "query": { "match_all": {} } }""";
                assertEquals(3, searchSourceBuilder.getDerivedFieldsObject().size());
                    searchSourceBuilder.writeTo(output);
            { "query": {
                        "match_none": {}
            }
            assertEquals("[multi_match] malformed query, expected [END_OBJECT] but found [FIELD_NAME]", e.getMessage());
    }
                        assertEquals(searchSourceBuilder.hashCode(), deserializedBuilder.hashCode());
                    }
        {
                    "query" : {
                SearchSourceBuilder searchSourceBuilder = SearchSourceBuilder.fromXContent(parser);
 * this file be licensed under the Apache-2.0 license or a
        XContentType xContentType = randomFrom(XContentType.values());
                        "query": {
        }
            try (XContentParser parser = createParser(JsonXContent.jsonXContent, restContent)) {
        @SuppressWarnings("unchecked")
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, restContent)) {
                  },
                assertEquals(new FieldSortBuilder("age").order(SortOrder.DESC), searchSourceBuilder.sorts().get(3));
                      "script": "emit(doc['test'])"
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, "{}{}")) {
 * You may obtain a copy of the License at
            JsonParseException exc = expectThrows(JsonParseException.class, () -> SearchSourceBuilder.fromXContent(parser));
        }
            SearchSourceBuilder copy = original.shallowCopy();
                                "field": "foo"
            }""";
import org.opensearch.search.rescore.QueryRescorerBuilder;
                 "terms": {
                assertFalse(searchSourceBuilder.fetchSource().fetchSource());
                     }
                }
import static org.hamcrest.Matchers.hasToString;
    public void testToXContent() throws IOException {
            }
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, query)) {
                        assertNotSame(searchSourceBuilder, deserializedBuilder);
        } else {
                    try (StreamInput in = new NamedWriteableAwareStreamInput(output.bytes().streamInput(), namedWriteableRegistry)) {
            try (BytesStreamOutput output = new BytesStreamOutput()) {
                );
                SearchSourceBuilder searchSourceBuilder = SearchSourceBuilder.fromXContent(parser);
            String restContent = """
                      "must": {
        }
        {
            String restContent = """
        if (keepAlive != null) {
                "window_size": 50,
        searchSourceBuilder.pointInTimeBuilder(new PointInTimeBuilder("id").setKeepAlive(keepAlive));
                instanceOf(BoolQueryBuilder.class)
                    new QueryRescorerBuilder(QueryBuilders.matchQuery("content", "baz")).windowSize(50),
            }
                    }
                assertEquals(1, searchSourceBuilder.getDerivedFields().size());
        assertEquals("[size] parameter cannot be negative, found [" + randomSize + "]", expected.getMessage());
                    },
                 "query": "workd",
                searchSourceBuilder.derivedField(
            }
                SearchSourceBuilder searchSourceBuilder = SearchSourceBuilder.fromXContent(parser);
                    String actualContent = deserializedBuilder.toString();
    }
                      "format": "dd-MM-yyyy",
            String restContent = """
            ParsingException e = expectThrows(ParsingException.class, () -> SearchSourceBuilder.fromXContent(parser));
                      "script": "emit(doc['message'])"
                    "ip_from_message": {
                     }
