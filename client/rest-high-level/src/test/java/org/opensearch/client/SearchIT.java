        assertThat(countResponse.getTotalShards(), greaterThan(0));
        searchRequest.source(searchSourceBuilder);
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        assertEquals(0, terms.getDocCountError());
        Terms.Bucket bucket1 = termsAgg.getBucketByKey("bob|18446744073709551615");
        );
            assertThat(searchResponse.getHits().getHits().length, equalTo(35));
        assertThat(multiSearchResponse.getResponses()[2].getFailure(), Matchers.nullValue());
        assertThat(multiSearchResponse.getResponses()[2].getResponse().getHits().getAt(0).getId(), Matchers.equalTo("5"));
 * ownership. Elasticsearch licenses this file to you under
        SearchRequest searchRequest1 = new SearchRequest("index1");
import org.opensearch.search.aggregations.metrics.WeightedAvgAggregationBuilder;
        assertThat(multiSearchResponse.getResponses()[1].getResponse().getHits().getAt(0).getId(), Matchers.equalTo("4"));
import org.opensearch.search.aggregations.bucket.terms.Terms;
import org.opensearch.search.aggregations.bucket.range.RangeAggregationBuilder;
        multiSearchRequest.add(searchRequest3);
            .size(10)
                    .query(new RangeQueryBuilder("result").from(date1.toString()).to(date2.toString()))
 *
        SearchTemplateResponse searchTemplateResponse = execute(
        SearchRequest searchRequest = new SearchRequest("test").scroll(TimeValue.timeValueMinutes(2)).source(searchSourceBuilder);
            assertEquals("value", values.get(0));
        // Check the capabilities for the 'rating' field.
            WeightedAvg weightedAvg = type1.getAggregations().get("subagg");
        assertEquals(0, searchResponse.getHits().getHits().length);
        searchSourceBuilder.aggregation(yearAgg).aggregation(rangeAgg);
            assertEquals(1, values.size());
        Range rangeAggregation = searchResponse.getAggregations().get("number_events");
            assertThat(explainResponse.getGetResult().getFields().get("field2").getValue().toString(), equalTo("value2"));
        assertEquals("sugg1", sugg.getName());
        assertEquals(Collections.emptyMap(), searchResponse.getProfileResults());
            client().performRequest(doc3);
        searchTemplateRequest.setScriptParams(scriptParams);
            assertEquals(20.0, ((HashMap) values.get(1)).get("lat"));
        badRequest.setScriptType(ScriptType.INLINE);
        }
        } finally {
                    .query(new TermsQueryBuilder("result", "value"))
            SearchRequest searchRequest = new SearchRequest("test").source(
        SearchTemplateRequest searchTemplateRequest = new SearchTemplateRequest();
        searchSourceBuilder.aggregation(
                SearchSourceBuilder.searchSource()
        searchRequest1.source().sort("id", SortOrder.ASC);
        assertThat(searchResponse.getHits().getAt(2).getSortValues()[0], equalTo(new BigInteger("18446744073709551615")));
            assertTrue(explainResponse.getGetResult().isExists());
            searchResponse = execute(
            assertTrue(explainResponse.hasExplanation());
            );
            searchResponse = execute(
            SearchRequest searchRequest = new SearchRequest("test").source(
        assertEquals("1", searchHit.getId());
            assertEquals("10.0.0.1", values.get(0));
            ExplainResponse explainResponse = execute(explainRequest, highLevelClient()::explain, highLevelClient()::explainAsync);
        assertThat(multiSearchResponse.getResponses()[1].getResponse().getHits().getHits().length, Matchers.equalTo(0));
        scriptParams.put("number", "BAD NUMBER");
    }
        }
        {
    }
import org.opensearch.index.query.QueryBuilders;
            for (SearchHit hit : searchResponse.getHits()) {
        assertEquals(2, rangeAggregation.getBuckets().size());
import org.opensearch.search.aggregations.bucket.range.Range;
        assertThat(multiSearchResponse.getResponses()[1].getFailure(), Matchers.nullValue());
                    + "      }"
        FieldCapabilitiesResponse response = execute(request, highLevelClient()::fieldCaps, highLevelClient()::fieldCapsAsync);
            assertThat(explainResponse.getExplanation().getValue(), equalTo(1.0f));
        assertThat(multiSearchResponse.getResponses()[0].isFailure(), Matchers.is(true));
        SearchRequest searchRequest = new SearchRequest();
        assertEquals(2, type2.getDocCount());
            ExplainRequest explainRequest = new ExplainRequest("index4", "1");
        assertEquals(2, termsAgg.getBuckets().size());
        assertEquals(0, searchResponse.getHits().getHits().length);
                + "                \"relations\" : { \"question\" : \"answer\" }\n"
        assertThat(multiSearchResponse.getResponses()[2].isFailure(), Matchers.is(false));
                    + "      \"rating\": {"
        assertThat(searchResponse.getHits().getTotalHits().value(), Matchers.equalTo(3L));
            Range rangeAgg = type2.getAggregations().get("subagg");
        }
            assertThat(values.get(0), instanceOf(Map.class));
        }
            assertTrue(explainResponse.hasExplanation());
            assertNotNull(values);
    }
            );
                    .query(qb)
        assertThat(multiSearchResponse.getResponses()[1].getFailure(), Matchers.nullValue());
                    .query(new RangeQueryBuilder("result").from(Long.MIN_VALUE).to(Long.MIN_VALUE + 1))
        );
        {
        multiSearchRequest.add(searchRequest2);
        SearchTemplateRequest goodRequest = new SearchTemplateRequest();
                    + "        \"store\":  true"
            assertEquals(RestStatus.NOT_FOUND, exception.status());
        goodRequest.setScriptType(ScriptType.INLINE);
 * Modifications Copyright OpenSearch Contributors. See
        client().performRequest(questionDoc);
import java.util.Arrays;
            client().performRequest(doc1);
        client().performRequest(createIndex);
            client().performRequest(doc3);
            assertTrue(clearScrollResponse.isSucceeded());
        SearchIT.assertSearchHeader(multiSearchResponse.getResponses()[2].getResponse());
            OpenSearchStatusException.class,
        searchSourceBuilder.size(0);
            assertEquals(true, values.get(0));
        }
            // multi-valued
                deletePitRequest,
                new SearchScrollRequest(searchResponse.getScrollId()).scroll(TimeValue.timeValueMinutes(2)),
            doc1.setJsonEntity("{\"id\":1, \"field1\":\"value1\", \"field2\":\"value2\"}");
                "{"
            pitIds.add(pitResponse.getId());
            List<Object> values = searchHit.getFields().get("result").getValues();
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder().size(35)
                + "        \"parent\" : \"1\"\n"
        assertEquals(3, type1.getDocCount());
                assertThat(((Number) hit.getSortValues()[0]).longValue(), equalTo(counter++));
import java.util.List;
import org.opensearch.search.aggregations.bucket.terms.RareTerms;
        }
            countRequest.source(new SearchSourceBuilder().query(new MatchQueryBuilder("field", "value1")));
            );
            assertThat(searchResponse.getHits().getHits().length, equalTo(30));
        assertThat(response.getIndices(), arrayContaining("index1", "index2"));
        {
        assertThat(multiSearchResponse.getResponses()[0].getFailure(), Matchers.nullValue());
        MultiSearchResponse multiSearchResponse = execute(multiSearchRequest, highLevelClient()::msearch, highLevelClient()::msearchAsync);
            assertEquals(2, options.getOptions().size());
                + "        \"name\" : \"answer\",\n"
        assertThat(multiSearchResponse.getResponses()[0].getResponse().getHits().getTotalHits().value(), Matchers.equalTo(1L));
            );
                    + "        \"type\":  \"date\""
import org.opensearch.search.fetch.subphase.FetchSourceContext;
                exception.getDetailedMessage(),
            new RangeAggregationBuilder("agg1").field("num").addRange("first", 0, 30).addRange("second", 31, 200)
    public void testNonExistentSearchTemplate() {
            assertEquals(2, explainResponse.getGetResult().getSource().size());
        MultiSearchTemplateResponse multiSearchTemplateResponse = execute(
                    .fetchField("result")
        assertEquals(countResponse.getTotalShards(), countResponse.getSuccessfulShards());
        SearchTemplateRequest badRequest2 = new SearchTemplateRequest();
                containsString("OpenSearch exception [type=index_not_found_exception, reason=no such index [non_existent_index]]")
        SearchRequest searchRequest3 = new SearchRequest("index3");
        assertEquals(Float.NaN, searchResponse.getHits().getMaxScore(), 0f);
        assertThat(multiSearchResponse.getResponses().length, Matchers.equalTo(2));
            multiSearchResponse.getResponses()[2].getResponse().getHits().getAt(0).getHighlightFields().get("field").fragments()[0]
            assertTrue(explainResponse.isExists());
        assertEquals("agg1", termsAgg.getName());
            .field("owner.display_name.keyword")
        assertThat(searchResponse.getHits().getMaxScore(), greaterThan(0f));
 * SPDX-License-Identifier: Apache-2.0
            client().performRequest(doc6);
        }
        goodRequest.setScript("{ \"query\": { \"match\": { \"num\": {{number}} } } }");
        searchSourceBuilder.aggregation(agg);
                    .query(new RangeQueryBuilder("result").from(Double.MIN_VALUE).to(Double.MIN_VALUE + 1))
    public void testFieldCapsWithNonExistentIndices() {
    }
        SearchRequest searchRequest2 = new SearchRequest("index2");
        // Keyword field
        answerDoc1.setJsonEntity(
        assertThat(multiSearchResponse.getResponses()[2].getResponse().getHits().getTotalHits().value(), Matchers.equalTo(1L));
        assertThat(multiSearchResponse.getResponses()[0].isFailure(), Matchers.is(false));
        }
        searchSourceBuilder.size(0);
            for (SearchHit hit : searchResponse.getHits()) {
        assertThat(multiSearchResponse.getResponses()[1].isFailure(), Matchers.is(false));
                .field("num", 10)
        assertEquals(2, termsAgg.getBuckets().size());
            assertNotNull(values);
        SearchIT.assertSearchHeader(multiSearchResponse.getResponses()[2].getResponse());
        Request createIndex = new Request(HttpPut.METHOD_NAME, "/" + indexName);
            .field("tags.keyword")
                SearchSourceBuilder.searchSource().scriptField("result", new Script("new String[]{}"))
            "{\n"
        assertEquals(3, terms.getBuckets().size());
        assertThat(searchResponse.getHits().getAt(1).getId(), Matchers.equalTo("1"));
        multiSearchRequest.add(searchRequest1);
        SearchRequest searchRequest = new SearchRequest();
        scriptParams.put("number", 10);
        assertSearchHeader(searchResponse);
            countRequest.query(new MatchQueryBuilder("field", "value1"));
        searchRequest1.source().highlighter(new HighlightBuilder().field("field"));
 * specific language governing permissions and limitations
            List<Object> values = searchHit.getFields().get("result").getValues();
        badRequest1.setRequest(new SearchRequest("index"));
            assertThat(explainResponse.getIndex(), equalTo("index1"));
            explainRequest.query(QueryBuilders.termQuery("field", "value1"));
    public void testSearchWithTermsAndRangeAgg() throws IOException {
        assertNull(searchResponse.getSuggest());
        assertThat(multiSearchResponse.getResponses()[2].getFailure(), Matchers.nullValue());
            doc1.setJsonEntity("{\"date_created\":\"2024\", \"distribution\":{\"number_events\": 1000000}}");
    public void testSearchWithRareTermsAgg() throws IOException {
            )
                    + "            \"type\":  \"unsigned_long\""
        RangeAggregationBuilder rangeAgg = new RangeAggregationBuilder("number_events").field("distribution.number_events")
                SearchSourceBuilder.searchSource()
    }
                SearchSourceBuilder.searchSource()
                highLevelClient()::scroll,
        searchSourceBuilder.size(0);
        SearchResponse searchResponse = execute(searchRequest, highLevelClient()::search, highLevelClient()::searchAsync);
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
                    .derivedField("result", "double", new Script("emit(Double.MAX_VALUE)"))
                    + "        \"type\":  \"keyword\","
        Item[] responses = multiSearchTemplateResponse.getResponses();
        }
                    .derivedField("result", "double", new Script("emit(Double.MAX_VALUE); emit(Double.MIN_VALUE);"))
}
                )
            assertEquals(2, values.size());
        badRequest1.setScript("{ \"query\": { \"match\": { \"num\": {{number}} } } }");
 * The OpenSearch Contributors require contributions made to
        assertEquals("index", searchHit.getIndex());
        searchTemplateRequest.setScriptType(ScriptType.STORED);
 * the Apache License, Version 2.0 (the "License"); you may
    public void testSearchWithRangeAgg() throws IOException {
        }
            SearchResponse searchResponse = execute(searchRequest, highLevelClient()::search, highLevelClient()::searchAsync);
            assertThat(explainResponse.getExplanation().getValue(), equalTo(1.0f));
            assertNotNull(values);
            assertEquals(1.0f, searchHit.getScore(), 0);
        assertEquals(expectedTextCapabilities, fieldResponse.get("text"));
/*
            Request doc3 = new Request(HttpPut.METHOD_NAME, "/index/_doc/3");
        assertThat(searchResponse.getHits().getAt(0).getId(), Matchers.equalTo("2"));
            searchRequest = new SearchRequest("test").source(
import org.opensearch.common.unit.TimeValue;
        }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                .string(),
            assertThat(Integer.valueOf(explainResponse.getId()), equalTo(1));
        );
        assertThat(terms.getBuckets().size(), Matchers.equalTo(2));
            );
            assertNotNull(values);
        assertEqualsOnDouble(1.2741646510794589, matrixStats.getKurtosis("num"));
            SearchHit searchHit = searchResponse.getHits().getAt(0);
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
            }
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        CompositeAggregation.Bucket bucket1 = compositeAgg.getBuckets().get(0);
            searchResponse = execute(searchRequest, highLevelClient()::search, highLevelClient()::searchAsync);
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder().size(35).sort("field", SortOrder.ASC);
            Children children = bucket.getAggregations().get("to-answers");
            assertThat(explainResponse.getExplanation().getDetails().length, equalTo(2));
            assertEquals(30.0, ((HashMap) values.get(1)).get("lon"));
        MultiSearchResponse multiSearchResponse = execute(multiSearchRequest, highLevelClient()::msearch, highLevelClient()::msearchAsync);
            List<?> list = (List<?>) values.get(0);
        {
        {
        assertSearchHeader(searchResponse);
            assertThat(Integer.valueOf(explainResponse.getId()), equalTo(1));
            assertEquals(100, weightedAvg.getValue(), 0f);
        assertThat(multiSearchResponse.getResponses().length, Matchers.equalTo(3));
        assertEquals(1, searchResponse.getAggregations().asList().size());
                "{"
            SearchResponse searchResponse = execute(searchRequest, highLevelClient()::search, highLevelClient()::searchAsync);
                highLevelClient()::scroll,
            assertTrue(explainResponse.isExists());
        assertThat(multiSearchResponse.getResponses()[2].getFailure(), Matchers.nullValue());
        assertNull(searchResponse.getAggregations());
    }
            null,
import org.opensearch.search.suggest.Suggest;
import org.joda.time.DateTime;
                + "                \"type\" : \"keyword\"\n"
        {
            .size(0)
        SearchHit searchHit = searchResponse.getHits().getHits()[0];
            );
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
    public void testExplainNonExistent() throws IOException {
        assertThat(exception.getMessage(), containsString("no requests added"));
            assertNull(explainResponse.getGetResult());
 * software distributed under the License is distributed on an
import org.opensearch.search.aggregations.support.MultiTermsValuesSourceConfig;
            assertEquals(3, bucket.getDocCount());
            assertTrue(deletePitResponse.getDeletePitResults().get(0).isSuccessful());
        assertEquals(2, termsAgg.getBuckets().size());
    private static void assertCountHeader(CountResponse countResponse) {
        SearchTemplateRequest badRequest1 = new SearchTemplateRequest();
            searchResponse = execute(searchRequest, highLevelClient()::search, highLevelClient()::searchAsync);
 *    http://www.apache.org/licenses/LICENSE-2.0
        SearchResponse searchResponse = execute(searchRequest, highLevelClient()::search, highLevelClient()::searchAsync);
        );
        // Setting simulate true causes the template to only be rendered.
        client().performRequest(new Request(HttpPost.METHOD_NAME, "/search_sort/_refresh"));
            assertThat(explainResponse.getGetResult().getFields().get("field1").getValue().toString(), equalTo("value1"));
    }
            "{\n"
                    new MultiTermsValuesSourceConfig.Builder().setFieldName("username").build(),
            .subAggregation(childrenAgg);
        scriptParams.put("number", 10);
        searchRequest1.source().query(new TermsQueryBuilder("field", "value2"));
            client().performRequest(doc1);
        badRequest1.setScriptParams(scriptParams);
                Range.Bucket bucket = rangeAgg.getBuckets().get(0);
            SearchRequest searchRequest = new SearchRequest("test").source(
        assertEquals(0, searchResponse.getHits().getHits().length);
                + "    \"owner\": {\n"
        assertEquals(0, bucket2.getAggregations().asList().size());
            );
        assertThat(multiSearchResponse.getResponses()[1].getResponse().getHits().getAt(1).getId(), Matchers.equalTo("4"));
            searchHit = searchResponse.getHits().getAt(0);
    }
            Request doc1 = new Request(HttpPut.METHOD_NAME, "/index4/_doc/1");
                    + "  }"
        } else {
                new SearchScrollRequest(searchResponse.getScrollId()).scroll(TimeValue.timeValueMinutes(2)),
import java.io.IOException;
            explainRequest.query(
        assertEquals(0, type2.getAggregations().asList().size());
                    + "      },"
        searchTemplateRequest.setScriptParams(scriptParams);
        assertThat(multiSearchResponse.getTook().millis(), Matchers.greaterThanOrEqualTo(0L));
        assertSearchHeader(searchResponse);
    public void testCountAllIndicesMatchQuery() throws IOException {
            highLevelClient()::searchTemplate,
        countRequest.source(new SearchSourceBuilder().query(new MatchQueryBuilder("num", 10)));
            assertThat(explainResponse.getExplanation().getValue().floatValue(), greaterThan(0.0f));
        SearchRequest searchRequest = new SearchRequest(indexName);
            assertEquals(2, values.size());
            assertFalse(explainResponse.isMatch());
            assertThat(explainResponse.getIndex(), equalTo("index1"));
        searchSourceBuilder.aggregation(AggregationBuilders.composite("composite", sources));
        }
import static org.hamcrest.Matchers.equalTo;
            assertTrue(explainResponse.hasExplanation());
        assertEquals(expectedLongCapabilities, ratingResponse.get("long"));
            assertEquals(2, rangeAgg.getBuckets().size());
import org.opensearch.search.aggregations.support.MultiValuesSourceFieldConfig;
            assertEquals(0, options.getOffset());
        );
            );
        assertThat(multiSearchResponse.getResponses()[2].getResponse().getHits().getTotalHits().value(), Matchers.equalTo(2L));
        assertThat(multiSearchResponse.getResponses()[1].getResponse(), nullValue());
                highLevelClient()::clearScrollAsync
            client().performRequest(doc5);
            assertEquals(2, rangeAgg.getBuckets().size());
                () -> execute(explainRequest, highLevelClient()::explain, highLevelClient()::explainAsync)
                    .derivedField("result", "long", new Script("emit(Long.MAX_VALUE)"))
import org.apache.hc.client5.http.classic.methods.HttpPut;
                    + "      \"date_created\": {"
            client().performRequest(doc2);
                    + "}"
import java.util.Collections;
            );
        questionDoc.setJsonEntity(
                    + "  \"mappings\": {"
            assertNull(explainResponse.getGetResult());
        {
            assertThat(
        goodRequest.setExplain(true);
import org.opensearch.action.fieldcaps.FieldCapabilitiesRequest;
        assertEquals(1, searchResponse.getHits().getTotalHits().value());
        assertEquals(Float.NaN, searchResponse.getHits().getMaxScore(), 0f);
        assertSearchHeader(searchResponse);
                assertThat(option.getText().string(), either(equalTo("type1")).or(equalTo("type2")));
        CountRequest countRequest = new CountRequest();
        assertEquals(Float.NaN, searchResponse.getHits().getMaxScore(), 0f);
import org.opensearch.search.aggregations.bucket.terms.MultiTermsAggregationBuilder;
        assertEquals(0, searchResponse.getHits().getHits().length);
                    + "      \"field1\": {"
        assertEquals(5, matrixStats.getFieldCount("num2"));
        terms = multiSearchResponse.getResponses()[1].getResponse().getAggregations().get("name");
import org.opensearch.action.search.SearchRequest;
                    .fetchField("result")
        );
 *
        {
            );
        SearchResponse searchResponse = execute(searchRequest, highLevelClient()::search, highLevelClient()::searchAsync);
            {
        assertThat(multiSearchResponse.getResponses()[0].isFailure(), Matchers.is(false));
import org.apache.hc.client5.http.classic.methods.HttpPost;
            assertNotNull(values);
            assertEquals(Double.MAX_VALUE, values.get(0));
                    + "    }"
            explainRequest.query(QueryBuilders.termQuery("field", "value2"));
        );
            client().performRequest(doc4);
                + "    \"title\": \"Whats the best way to file transfer my site from server to a newer one?\",\n"
    }
            assertEquals(RestStatus.BAD_REQUEST, exception.status());
        CountRequest countRequest;
            assertFalse(explainResponse.isMatch());
                + "        }\n"
            assertNotNull(values);
import org.hamcrest.Matchers;
        assertEqualsOnDouble(1.3517561983471071, matrixStats.getKurtosis("num2"));
        {
            assertEquals(date2.toString(), values.get(1));
        assertThat(terms.getBuckets().size(), Matchers.equalTo(2));
    }
        searchSourceBuilder.size(0);
            explainRequest.query(QueryBuilders.matchAllQuery());
            highLevelClient()::searchTemplate,
            assertThat(
        badRequest.setScriptParams(scriptParams);
            searchSourceBuilder.size(0);
        SearchRequest searchRequest = new SearchRequest("index");
        Request answerDoc1 = new Request(HttpPut.METHOD_NAME, "/" + indexName + "/_doc/2");
            Range rangeAgg = type1.getAggregations().get("subagg");
    public void testSearchWithMultiTermsAgg() throws IOException {
    public void testMultiSearch_withAgg() throws Exception {
        );
import org.opensearch.search.aggregations.bucket.terms.TermsAggregationBuilder;
        {
        badRequest2.setScriptType(ScriptType.INLINE);
        assertThat(multiSearchResponse.getTook().millis(), Matchers.greaterThanOrEqualTo(0L));
    public void testExplainWithAliasFilter() throws IOException {
                OpenSearchException.class,
        Terms terms = multiSearchResponse.getResponses()[0].getResponse().getAggregations().get("name");
                assertEquals(counter++, ((Number) hit.getSortValues()[0]).longValue());
        assertEquals(0, bucket1.getAggregations().asList().size());
        SearchIT.assertSearchHeader(multiSearchResponse.getResponses()[0].getResponse());
                new TermsAggregationBuilder("name").userValueTypeHint(ValueType.STRING).field("field.keyword").order(BucketOrder.key(true))
        CountRequest countRequest = new CountRequest("index");
        assertThat(searchResponse.getHits().getAt(0).getSortValues()[0], equalTo(new BigInteger("10223372036854775807")));
            assertTrue(explainResponse.isExists());
            // multi-valued
    public void testSearchMatchQuery() throws IOException {
        assertThat(multiSearchResponse.getResponses().length, Matchers.equalTo(3));
        }
            Request doc1 = new Request(HttpPut.METHOD_NAME, "/" + indexName + "/_doc/1");
        Terms.Bucket bucket2 = termsAgg.getBucketByKey("tom|10223372036854775807");
import org.opensearch.search.aggregations.bucket.composite.CompositeAggregation;
                SearchSourceBuilder.searchSource()
            assertEquals(1, values.size());
            assertNull(explainResponse.getGetResult());
        assertThat(terms.getBuckets().get(1).getKeyAsString(), Matchers.equalTo("value2"));
            ExplainRequest explainRequest = new ExplainRequest("index4", "1");
        assertCountHeader(countResponse);
            Request doc1 = new Request(HttpPut.METHOD_NAME, "/index1/_doc/1");
            doc1.setJsonEntity("{\"id\":1, \"field\":\"value1\", \"rating\": 7}");
        assertEquals("{terms=type1}", bucket1.getKeyAsString());
        }
            SearchResponse searchResponse = execute(searchRequest, highLevelClient()::search, highLevelClient()::searchAsync);
        Range rangeAgg = searchResponse.getAggregations().get("agg1");
                    .derivedField("result", "geo_point", new Script("emit(10.0, 20.0); emit(20.0, 30.0);"))
import org.opensearch.search.aggregations.metrics.WeightedAvg;
        // Geo field
            assertTrue(explainResponse.isMatch());
        assertEquals(3, countResponse.getCount());
        // Date field
    public void testCountMultipleIndicesMatchQueryUsingConstructor() throws IOException {
import org.opensearch.index.query.TermsQueryBuilder;
            SearchSourceBuilder sourceBuilder = new SearchSourceBuilder().query(new MatchQueryBuilder("field", "value1"));
                + "            },\n"
        Map<String, FieldCapabilities> fieldResponse = response.getField("field");
import org.opensearch.search.builder.PointInTimeBuilder;
            "{\n"
                + "        \"windows-server-2003\",\n"
            assertFalse(explainResponse.isMatch());
        assertEquals(Collections.emptyMap(), searchResponse.getProfileResults());
            null,
        }
                assertThat(option.getScore(), greaterThan(0f));
        assertEquals(7, countResponse.getCount());
            assertEquals(date1.toString(), values.get(0));
            values = searchHit.getFields().get("result").getValues();
        assertEquals(1, searchResponse.getSuggest().size());
            assertEquals(0, bucket.getDocCount());
    public void testCountOneIndexNoQuery() throws IOException {
        scriptParams = new HashMap<>();
        assertEquals(Float.NaN, searchResponse.getHits().getMaxScore(), 0f);
        assertEquals(0, searchResponse.getHits().getHits().length);
            new TermsValuesSourceBuilder("terms").field("type.keyword").missingBucket(true).order("asc")
            null,
            assertTrue(explainResponse.isMatch());
import org.opensearch.script.ScriptType;
                    + "}"
        // Check the capabilities for the 'field' field.
 * You may obtain a copy of the License at
                .startObject("query")
        badRequest1.setScriptType(ScriptType.INLINE);
        assertEquals(0, bucket1.getAggregations().asList().size());
        TermsAggregationBuilder agg = new TermsAggregationBuilder("agg1").userValueTypeHint(ValueType.STRING).field("type.keyword");
            assertTrue(explainResponse.isExists());
        searchTemplateRequest.setScript("{ \"query\": { \"match\": { \"num\": {{number}} } } }");
        assertThat(terms.getBuckets().get(0).getKeyAsString(), Matchers.equalTo("value1"));
            assertThat(explainResponse.getId(), equalTo("999"));
import org.opensearch.search.aggregations.matrix.stats.MatrixStatsAggregationBuilder;
    public void testSearchWithDerivedFields() throws Exception {
import static org.hamcrest.Matchers.containsString;
            assertTrue(explainResponse.hasExplanation());
import java.util.Map;
    public void indexDocuments() throws IOException {
                    .query(new RangeQueryBuilder("result").from(Double.MAX_VALUE - 1).to(Double.MAX_VALUE))
        assertThat(multiSearchResponse.getResponses()[1].getResponse().getHits().getTotalHits().value(), Matchers.equalTo(2L));
            searchHit = searchResponse.getHits().getAt(0);
        searchRequest.source(searchSourceBuilder);
 */
            client().performRequest(create);
        goodRequest.setScriptParams(scriptParams);
import org.opensearch.OpenSearchStatusException;
            List<String> pitIds = new ArrayList<>();
        assertEquals(Collections.emptyMap(), searchResponse.getProfileResults());
        // Long field
            assertThat(searchResponse.getHits().getHits().length, equalTo(35));
        assertThat(terms.getBuckets().size(), Matchers.equalTo(2));
        assertEquals(1, fieldResponse.size());
        assertThat(multiSearchResponse.getResponses().length, Matchers.equalTo(3));
            assertEquals(date1.toString(), values.get(0));
                    + "        \"alias\" : \"alias4\","
            multiSearchTemplateRequest,
            assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(100L));
                + "        \"id\": 48\n"
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
            GeoShapeQueryBuilder qb = geoShapeQuery("result", new Rectangle(-35, 35, 35, -35));
        assertThat(multiSearchResponse.getResponses()[2].isFailure(), Matchers.is(false));
    public void testSearchWithDateAndRangeAgg() throws IOException {
        badRequest2.setRequest(new SearchRequest("index"));
            );
        Request createIndex = new Request(HttpPut.METHOD_NAME, "/" + indexName);
        searchTemplateRequest.setRequest(new SearchRequest("index"));
            Collections.emptyMap()
            assertEquals(Long.MAX_VALUE, values.get(0));
            ExplainResponse explainResponse = execute(explainRequest, highLevelClient()::explain, highLevelClient()::explainAsync);
    }
        assertNull(responses[0].getResponse().getSource());
            Request doc1 = new Request(HttpPut.METHOD_NAME, "/index5/_doc/1");
                + "    }"
                + "    \"qa_join_field\" : {\n"
            );
import org.opensearch.action.search.MultiSearchRequest;
                    + "        \"index\" : \"index4\","
            List<Object> values = searchHit.getFields().get("result").getValues();
            client().performRequest(doc5);
        searchSourceBuilder.aggregation(new MatrixStatsAggregationBuilder("agg1").fields(Arrays.asList("num", "num2")));
                + "        \"properties\" : {\n"
        assertEquals(2, responses.length);
            SearchRequest searchRequest = new SearchRequest("test").source(
        FieldCapabilitiesResponse response = execute(request, highLevelClient()::fieldCaps, highLevelClient()::fieldCapsAsync);
        SearchResponse searchResponse = execute(searchRequest, highLevelClient()::search, highLevelClient()::searchAsync);
import org.opensearch.core.common.bytes.BytesReference;
        assertThat(searchResponse.getTook().millis(), Matchers.greaterThanOrEqualTo(0L));
        assertThat(searchHit.getScore(), greaterThan(0f));
        final String indexName = "child_example";
            true,
        }
        assertEquals(Float.NaN, searchResponse.getHits().getMaxScore(), 0f);
        assertNull(searchResponse.getSuggest());
        assertEquals(0, terms.getSumOfOtherDocCounts());
            SearchHit searchHit = searchResponse.getHits().getAt(0);
        multiSearchRequest.add(searchRequest2);
                    .derivedField("result", "long", new Script("emit(Long.MAX_VALUE); emit(Long.MIN_VALUE);"))
        assertEquals(Collections.emptyMap(), searchResponse.getProfileResults());
            assertThat(clearScrollResponse.getNumFreed(), greaterThan(0));
            assertTrue(explainResponse.hasExplanation());
        assertEquals(0, type1.getAggregations().asList().size());
        assertEquals(-1L, searchHit.getVersion());
        assertEquals(SearchResponse.Clusters.EMPTY, searchResponse.getClusters());
            create.setJsonEntity(
            "{\n"
        assertThat(multiSearchResponse.getResponses()[2].getResponse().getHits().getTotalHits().value(), Matchers.equalTo(1L));
        MultiSearchResponse multiSearchResponse = execute(multiSearchRequest, highLevelClient()::msearch, highLevelClient()::msearchAsync);
        scriptParams = new HashMap<>();
import org.opensearch.action.explain.ExplainResponse;
            assertEquals(2, values.size());
            doc2.setJsonEntity("{\"id\":2, \"field\":\"value2\"}");
                    .fetchField("result")
import org.opensearch.join.aggregations.Children;
                    + "    \"properties\": {"
    }
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        assertCountHeader(countResponse);
        answerDoc2.setJsonEntity(
import org.opensearch.search.suggest.SuggestBuilder;
            client().performRequest(createFilteredAlias);
        assertEquals(5, searchResponse.getHits().getTotalHits().value());
        searchSourceBuilder.aggregation(new TermsAggregationBuilder("agg1").userValueTypeHint(ValueType.STRING).field("type.keyword"));
                + "    \"body\": \"<p>Use Linux...\",\n"
                SearchSourceBuilder.searchSource()
        {
        assertTrue(response.get().containsKey("field"));
        SearchIT.assertSearchHeader(multiSearchResponse.getResponses()[0].getResponse());
import org.opensearch.action.explain.ExplainRequest;
        Terms.Bucket type2 = termsAgg.getBucketByKey("type2");
            highLevelClient()::searchTemplateAsync
            assertEquals(1, bucket.getAggregations().asList().size());
                    .fetchField("result")
                .startObject()
        multiSearchRequest.add(searchRequest3);
        CountResponse countResponse = execute(countRequest, highLevelClient()::count, highLevelClient()::countAsync);
                assertEquals(2, bucket.getDocCount());
                    + "      \"add\" : {"
        searchRequest3.source().sort("id", SortOrder.ASC);
 * compatible open source license.
        // Just testing DerivedField definition from SearchSourceBuilder derivedField()
        Request createIndex = new Request(HttpPut.METHOD_NAME, "/" + indexName);
    }
        searchRequest.source(new SearchSourceBuilder().query(new MatchQueryBuilder("num", 10)));
import org.opensearch.script.Script;
                    .query(new RangeQueryBuilder("result").from(date1.toString()).to(date2.toString()))
            for (SearchHit hit : searchResponse.getHits()) {
        );
            ExplainResponse explainResponse = execute(explainRequest, highLevelClient()::explain, highLevelClient()::explainAsync);
        assertNull(searchTemplateResponse.getSource());
            SearchRequest searchRequest = new SearchRequest("test").source(
        assertEqualsOnDouble(0.09340198804973039, matrixStats.getSkewness("num"));
            assertThat(Integer.valueOf(explainResponse.getId()), equalTo(1));
            searchRequest = new SearchRequest("test").source(
        FieldCapabilitiesRequest request = new FieldCapabilitiesRequest().indices("index1", "index2").fields("rating", "field");
            ExplainRequest explainRequest = new ExplainRequest("index1", "1");
                + "        \"id\": 49\n"
            .aggregation(
            Request create = new Request(HttpPut.METHOD_NAME, "/index5");
            doc3.setJsonEntity("{\"username\":\"john\"}");
                    .derivedField("result", "date", new Script("emit(" + date1.getMillis() + "L); " + "emit(" + date2.getMillis() + "L)"))
import org.opensearch.search.sort.SortOrder;
                    .fetchField("result")
        CompositeAggregation compositeAgg = searchResponse.getAggregations().get("composite");
                + "        }\n"
        assertNotNull(hit.getExplanation());
        searchTemplateRequest.setProfile(true);
            "field",
            .aggregation(
        client().performRequest(new Request(HttpPost.METHOD_NAME, "/_refresh"));
        Map<String, Object> scriptParams = new HashMap<>();
            assertEquals(2, values.size());
        assertThat(terms.getBuckets().get(1).getKeyAsString(), Matchers.equalTo("value2"));
            client().performRequest(create);
                    + "          \"number_events\": {"
        assertEquals(5, searchResponse.getHits().getTotalHits().value());
            searchRequest = new SearchRequest("test").source(
                assertEquals("first", bucket.getKeyAsString());
        assertEquals("agg1", termsAgg.getName());
        SearchRequest searchRequest2 = new SearchRequest("index2");
import org.opensearch.search.aggregations.matrix.stats.MatrixStats;
import static org.opensearch.index.query.QueryBuilders.geoShapeQuery;
                    .fetchField("result")
        SearchResponse searchResponse = execute(searchRequest, highLevelClient()::search, highLevelClient()::searchAsync);
            ExplainResponse explainResponse = execute(explainRequest, highLevelClient()::explain, highLevelClient()::explainAsync);
                    + "      }"
            create.setJsonEntity(
        assertFalse(searchResponse.getProfileResults().isEmpty());
        assertThat(multiSearchResponse.getResponses()[2].getResponse().getHits().getAt(0).getId(), Matchers.equalTo("6"));
 * KIND, either express or implied.  See the License for the
            multiSearchResponse.getResponses()[1].getResponse().getHits().getAt(0).getHighlightFields().get("field").fragments()[0]
                highLevelClient()::scrollAsync
            .calendarInterval(DateHistogramInterval.YEAR)
    public void testSearchWithTermsAgg() throws IOException {
        goodRequest.setProfile(true);
                SearchSourceBuilder.searchSource()
        }
                    .fetchField("result")
            assertThat(Integer.valueOf(searchHit.getId()), both(greaterThan(0)).and(lessThan(6)));
            SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
            .sort("field", SortOrder.ASC)
        assertTrue(explainResponse.isExists());
                    .query(new RangeQueryBuilder("result").from(Long.MAX_VALUE - 1).to(Long.MAX_VALUE))
            // multi-valued
        searchRequest2.source().query(new TermsQueryBuilder("field", "value2"));
        SearchRequest searchRequest2 = new SearchRequest("index2");
            Matchers.equalTo("<em>value2</em>")
            assertEquals(1, values.size());
        for (SearchHit searchHit : searchResponse.getHits().getHits()) {
 * Licensed to Elasticsearch under one or more contributor
            assertEquals(1, values.size());
        assertThat(multiSearchResponse.getResponses()[0].getResponse().getHits().getTotalHits().value(), Matchers.equalTo(1L));
        );
import org.opensearch.search.aggregations.bucket.histogram.ParsedDateHistogram;
        MatrixStats matrixStats = searchResponse.getAggregations().get("agg1");
    public void testMultiSearchTemplateAllBad() throws Exception {
                Range.Bucket bucket = rangeAgg.getBuckets().get(1);
 * this file be licensed under the Apache-2.0 license or a
    public void testMultiSearch_failure() throws Exception {
        Map<String, Object> scriptParams = new HashMap<>();
            assertFalse(explainResponse.isExists());
        assertThat(multiSearchResponse.getResponses()[0].getResponse().getHits().getAt(0).getId(), Matchers.equalTo("2"));
        }
                + "    \"tags\": [\n"
            searchHit = searchResponse.getHits().getAt(0);
    private static void assertSearchHeader(SearchResponse searchResponse) {
    }
            assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(100L));
            long counter = 0;
    }
        assertSearchHeader(searchResponse);
        assertNull(searchResponse.getSuggest());
            assertTrue(explainResponse.isExists());
            QueryBuilder query = new MatchQueryBuilder("field", "value1");
        goodRequest.setRequest(new SearchRequest("index"));
        assertEquals(Collections.emptyMap(), searchResponse.getProfileResults());
import org.opensearch.search.aggregations.AggregationBuilders;
        assertEquals(1, goodResponse.getHits().getTotalHits().value());
                OpenSearchStatusException.class,
        assertTrue(response.get().isEmpty());
            SearchHit searchHit = searchResponse.getHits().getAt(0);
        SearchRequest searchRequest = new SearchRequest("index");
        assertThat(multiSearchResponse.getResponses()[0].getResponse().getHits().getAt(1).getId(), Matchers.equalTo("2"));
        SearchIT.assertSearchHeader(multiSearchResponse.getResponses()[1].getResponse());
        if (randomBoolean()) {
        assertEquals(Float.NaN, searchResponse.getHits().getMaxScore(), 0f);
        searchSourceBuilder.size(0);
            assertTrue(explainResponse.isMatch());
            assertNotNull(values);
        assertNull(searchResponse.getSuggest());
        assertEqualsOnDouble(330d, matrixStats.getVariance("num2"));
            SearchHit searchHit = searchResponse.getHits().getAt(0);
                + "}"
        badRequest.setScript("{ NOT VALID JSON {{number}} }");
import org.opensearch.action.search.DeletePitRequest;
import org.joda.time.DateTimeZone;
            SearchResponse searchResponse = execute(searchRequest, highLevelClient()::search, highLevelClient()::searchAsync);
        assertCountHeader(countResponse);
        ChildrenAggregationBuilder childrenAgg = new ChildrenAggregationBuilder("to-answers", "answer").subAggregation(leafTermAgg);
        FieldCapabilities expectedKeywordCapabilities = new FieldCapabilities(
        assertThat(multiSearchResponse.getResponses()[0].getFailure().getMessage(), containsString("search_phase_execution_exception"));
            long counter = 0;
        assertEquals(Collections.emptyMap(), searchResponse.getProfileResults());
        assertEquals(0, countResponse.getFailedShards());
            assertThat(rootCause.getMessage(), containsString("No search context found for"));
        SearchResponse searchResponse = execute(searchRequest, highLevelClient()::search, highLevelClient()::searchAsync);
    public void testCountAllIndicesNoQuery() throws IOException {
        assertEquals(1, bucket2.getDocCount());
    @Before
            null,
import org.opensearch.index.query.GeoShapeQueryBuilder;
        SearchHit hit = searchResponse.getHits().getHits()[0];
        {
        searchTemplateRequest.setScript("non-existent");
        answerDoc2.addParameter("routing", "1");
            ExplainRequest explainRequest = new ExplainRequest("index1", "1");
            assertThat(exception.getIndex().getName(), equalTo("non_existent_index"));
                assertEquals("first", bucket.getKeyAsString());
            values = searchHit.getFields().get("result").getValues();
            assertEquals("first", bucket.getKeyAsString());
        SearchRequest searchRequest1 = new SearchRequest("index1");
        client().performRequest(createIndex);
        }
                    + "      },"
        assertEquals("2024", yearHistogram.getBuckets().get(0).getKeyAsString());
            highLevelClient()::searchTemplateAsync
                + "}"
        assertThat(multiSearchResponse.getResponses()[0].getResponse().getHits().getHits().length, Matchers.equalTo(0));
            XContentFactory.jsonBuilder()
        assertCountHeader(countResponse);
        );
        CountResponse countResponse = execute(countRequest, highLevelClient()::count, highLevelClient()::countAsync);
        assertEquals(3, bucket1.getDocCount());
        multiSearchTemplateRequest.add(badRequest);
        CountResponse countResponse = execute(countRequest, highLevelClient()::count, highLevelClient()::countAsync);
import org.opensearch.geometry.Rectangle;
            assertEquals(2, values.size());
    public void testCountMultipleIndicesMatchQuery() throws IOException {
            Range.Bucket bucket = rangeAggregation.getBuckets().get(0);
            assertTrue(explainResponse.hasExplanation());
        }
            );
        assertEquals(1, termsAgg.getBuckets().size());
            List<Object> values = searchHit.getFields().get("result").getValues();
                + "    },\n"
        assertThat(multiSearchResponse.getResponses()[2].getFailure(), Matchers.nullValue());
            assertTrue(explainResponse.hasExplanation());
        searchRequest2.source().highlighter(new HighlightBuilder().field("field"));
import java.util.ArrayList;
        assertEquals(0, type2.getAggregations().asList().size());
        SearchRequest searchRequest = new SearchRequest().source(searchSourceBuilder);
            Terms.Bucket sam = leafTerms.getBucketByKey("Sam");
            explainRequest.query(QueryBuilders.matchQuery("field", "value"));
import org.opensearch.index.query.ScriptQueryBuilder;
        assertSearchHeader(searchResponse);
        assertEquals("{terms=type2}", bucket2.getKeyAsString());
            client().performRequest(doc1);
            );
            assertEquals(10.0, ((HashMap) values.get(0)).get("lat"));
        assertThat(multiSearchResponse.getResponses()[0].getResponse().getHits().getTotalHits().value(), Matchers.equalTo(2L));
            assertTrue(explainResponse.getGetResult().isExists());
            Request doc2 = new Request(HttpPut.METHOD_NAME, "/" + indexName + "/_doc/2");
            assertEquals(2, leafTerms.getBuckets().size());
        assertNull(searchResponse.getSuggest());
                SearchSourceBuilder.searchSource()
        Terms termsAgg = searchResponse.getAggregations().get("agg1");
        assertEquals(1, type2.getAggregations().asList().size());
        assertThat(multiSearchResponse.getResponses()[1].getResponse().getHits().getTotalHits().value(), Matchers.equalTo(1L));
                    .derivedField("result", "geo_point", new Script("emit(10.0, 20.0)"))
            client().performRequest(create);
        searchRequest3.source().highlighter(new HighlightBuilder().field("field"));
        assertEquals("composite", compositeAgg.getName());
        // Concurrent search could have small difference in floating-point results when merging from different way of slicing shard.
            {
        SearchResponse searchResponse = execute(searchRequest, highLevelClient()::search, highLevelClient()::searchAsync);
        explainRequest.query(QueryBuilders.matchAllQuery());
        assertEquals(1, searchResponse.getHits().getHits().length);
        }
 * Unless required by applicable law or agreed to in writing,
                + "                \"type\" : \"unsigned_long\"\n"
        }
            OpenSearchStatusException.class,
            for (Suggest.Suggestion.Entry.Option option : options) {
            SearchHit searchHit = searchResponse.getHits().getAt(0);
        SearchTemplateRequest searchTemplateRequest = new SearchTemplateRequest();
    public void testSearchScroll() throws Exception {
            }
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        FieldCapabilities expectedTextCapabilities = new FieldCapabilities(
        }
                + "    }"
import org.opensearch.OpenSearchException;
            DateTime date1 = new DateTime(1990, 12, 29, 0, 0, DateTimeZone.UTC);
        assertNull(responses[0].getResponse().getSource());
        );
            () -> execute(request, highLevelClient()::fieldCaps, highLevelClient()::fieldCapsAsync)
        SearchIT.assertSearchHeader(multiSearchResponse.getResponses()[1].getResponse());
        assertThat(multiSearchResponse.getResponses()[0].getResponse().getHits().getTotalHits().value(), Matchers.equalTo(2L));
        assertThat(searchResponse.getHits().getAt(1).getSortValues()[0], equalTo(new BigInteger("18446744073709551610")));
            .aggregation(
        Map<String, FieldCapabilities> ratingResponse = response.getField("rating");
                + "    \"mappings\": {\n"
                    + "    }"
        assertEquals(0, searchResponse.getHits().getTotalHits().value());
        assertEquals(0, searchResponse.getHits().getHits().length);
            assertSearchHeader(searchResponse);
            SearchResponse searchResponse = execute(searchRequest, highLevelClient()::search, highLevelClient()::searchAsync);
            SearchRequest searchRequest = new SearchRequest("test").source(
        CountRequest countRequest = new CountRequest("index", "index1");
        SearchRequest searchRequest3 = new SearchRequest("index3");
        SearchIT.assertSearchHeader(multiSearchResponse.getResponses()[0].getResponse());
            ClearScrollResponse clearScrollResponse = execute(
        }
            assertEquals(1, values.size());
        CountResponse countResponse = execute(countRequest, highLevelClient()::count, highLevelClient()::countAsync);
                + "    },\n"
import org.opensearch.action.search.CreatePitRequest;
        assertEquals(0, searchResponse.getHits().getHits().length);
                    + "  \"actions\" : ["
/*
        doc.setJsonEntity("{\"field\":\"value\"}");
            "{\n"
        assertSearchHeader(searchResponse);
            for (SearchHit hit : searchResponse.getHits()) {
            assertTrue(deletePitResponse.getDeletePitResults().get(0).getPitId().equals(pitResponse.getId()));
            assertNotNull(values);
        }
    public void testMultiSearch() throws Exception {
            );
        assertNotNull(searchResponse);
            assertThat(values.get(0), instanceOf(List.class));
                + "        }\n"
        assertThat(
                    + "  ]"
            true,
        }
        FieldCapabilitiesRequest request = new FieldCapabilitiesRequest().indices("index2").fields("nonexistent");
            Request doc4 = new Request(HttpPut.METHOD_NAME, "/index/_doc/4");
        Map<String, Object> scriptParams = new HashMap<>();
            searchResponse = execute(searchRequest, highLevelClient()::search, highLevelClient()::searchAsync);
            );
    public void testSearchNoQuery() throws IOException {
            ExplainRequest explainRequest = new ExplainRequest("non_existent_index", "1");
        assertThat(multiSearchResponse.getTook().millis(), Matchers.greaterThanOrEqualTo(0L));
                + "    \"creation_date\": \"2009-05-04T13:45:37.030\"\n"
                + "        \"location\": \"Norfolk, United Kingdom\",\n"
            Request doc = new Request(HttpPut.METHOD_NAME, "/test/_doc/" + Integer.toString(i));
        client().performRequest(answerDoc2);
            );
                bucket.getKeyAsString(),
        }
            Range.Bucket bucket = rangeAgg.getBuckets().get(0);
                .startObject("match")
            }
            ExplainRequest explainRequest = new ExplainRequest("index1", "1");
            searchHit = searchResponse.getHits().getAt(0);
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
            XContentBuilder builder = jsonBuilder().startObject().field("field", i).endObject();
                .string(),
            assertThat(explainResponse.getExplanation().getValue(), equalTo(1.0f));
            XContentBuilder builder = jsonBuilder().startObject().field("field", i).endObject();
        assertNull(searchResponse.getSuggest());
        assertEquals(0, countResponse.getSkippedShards());
            doc2.setJsonEntity("{\"username\":\"tom\", \"rating\": 10223372036854775807}");
        MultiSearchTemplateRequest multiSearchTemplateRequest = new MultiSearchTemplateRequest();
                assertThat(((Number) hit.getSortValues()[0]).longValue(), equalTo(counter++));
            assertNotNull(values);
            assertEquals(4, options.getLength());
        );
        assertThat(multiSearchResponse.getResponses()[1].isFailure(), Matchers.is(true));
import static org.hamcrest.Matchers.arrayContaining;
        assertThat(terms.getBuckets().get(1).getKeyAsString(), Matchers.equalTo("value2"));
        CountRequest countRequest = new CountRequest();
        assertThat(
            ExplainRequest explainRequest = new ExplainRequest("index4", "1");
            Range.Bucket bucket = rangeAggregation.getBuckets().get(1);
        scriptParams.put("number", 10);
            .pointInTimeBuilder(new PointInTimeBuilder(pitResponse.getId()));
        assertThat(terms.getBuckets().get(0).getKeyAsString(), Matchers.equalTo("value1"));
        {
        }
import java.util.HashMap;
            Request doc = new Request(HttpPut.METHOD_NAME, "/test/_doc/" + Integer.toString(i));
        assertEquals(4, searchHit.getSourceAsMap().size());
            assertNotNull(values);
        searchRequest.source(searchSourceBuilder);
        assertSearchHeader(searchResponse);
        assertEqualsOnDouble(56d, matrixStats.getMean("num"));
import org.opensearch.common.xcontent.XContentFactory;
                    .query(qb)
        assertThat(searchResponse.getHits().getMaxScore(), greaterThan(0f));
            Request doc3 = new Request(HttpPut.METHOD_NAME, "/" + indexName + "/_doc/3");
                clearScrollRequest,
        SearchResponse searchResponse = execute(searchRequest, highLevelClient()::search, highLevelClient()::searchAsync);
            Request doc4 = new Request(HttpPut.METHOD_NAME, "/index2/_doc/4");
        assertThat(multiSearchResponse.getResponses()[1].isFailure(), Matchers.is(false));
        TermsAggregationBuilder leafTermAgg = new TermsAggregationBuilder("top-names").userValueTypeHint(ValueType.STRING)
        );
            explainRequest.storedFields(new String[] { "field1", "field2" });
        {
        agg.subAggregation(
            client().performRequest(doc2);
            doc6.setJsonEntity("{\"id\":6, \"field\":\"value2\"}");
        searchRequest.source(searchSourceBuilder);
    public void testSearchWithWeirdScriptFields() throws Exception {
                    + "        \"type\":  \"keyword\","
        Terms termsAgg = searchResponse.getAggregations().get("agg1");
    public void testExplainWithFetchSource() throws IOException {
import org.opensearch.search.aggregations.bucket.histogram.DateHistogramInterval;
                () -> execute(searchRequest, highLevelClient()::search, highLevelClient()::searchAsync)
            assertTrue(searchHit.getSourceAsMap().containsKey("num"));
        searchSourceBuilder.size(0);
            searchResponse = execute(searchRequest, highLevelClient()::search, highLevelClient()::searchAsync);
                    .fetchField("result")
                QueryBuilders.boolQuery().must(QueryBuilders.termQuery("field", "value1")).must(QueryBuilders.termQuery("field", "value2"))
import org.opensearch.client.core.CountRequest;
                + "    \"mappings\": {\n"
            searchTemplateRequest,
            client().performRequest(doc4);
                    + "        \"properties\": {"
    public void testSearchWithPit() throws Exception {
        assertEquals(1, searchResponse.getAggregations().asList().size());
import org.opensearch.search.aggregations.bucket.composite.CompositeValuesSourceBuilder;
            .size(0)
        badRequest.setRequest(new SearchRequest("index"));
        Terms.Bucket type1 = termsAgg.getBucketByKey("type1");
            assertTrue(explainResponse.isMatch());
        multiSearchTemplateRequest.add(badRequest1);
        );
        CreatePitResponse pitResponse = execute(pitRequest, highLevelClient()::createPit, highLevelClient()::createPitAsync);
            assertEquals(1, bucket.getDocCount());
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchTemplateRequest.setExplain(true);
import org.opensearch.index.query.MatchQueryBuilder;
            searchSourceBuilder.aggregation(new RangeAggregationBuilder("agg1").field("num"));
        SearchResponse searchResponse = execute(searchRequest, highLevelClient()::search, highLevelClient()::searchAsync);
        assertEqualsOnDouble(1830.0000000000002, matrixStats.getVariance("num"));
    }
                SearchSourceBuilder.searchSource().derivedField("result", "ip", new Script("emit(\"10.0.0.1\")")).fetchField("result")
        {
        }
                highLevelClient()::clearScroll,
                    + "    \"properties\": {"
import org.opensearch.index.query.RangeQueryBuilder;
            );
        assertEquals(5, countResponse.getCount());
            .addRange("999--", 1000.0, 10_000_000_000_00L);
        SearchRequest searchRequest = new SearchRequest("index");
            SearchRequest searchRequest = new SearchRequest("test").source(
            // multi-valued
import org.opensearch.action.search.ClearScrollResponse;
            Request doc2 = new Request(HttpPut.METHOD_NAME, "/" + indexName + "/_doc/2");
        searchTemplateRequest.setRequest(new SearchRequest("index"));
                    .fetchField("result")
                + "            }\n"
        // The whole HTTP request should fail if no nested search requests are valid
import org.opensearch.search.builder.SearchSourceBuilder;
        {
            assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(100L));
                SearchSourceBuilder.searchSource()
                + "    },\n"
    }
public class SearchIT extends OpenSearchRestHighLevelClientTestCase {
        SearchResponse searchResponse = execute(searchRequest, highLevelClient()::search, highLevelClient()::searchAsync);
        TermsAggregationBuilder agg = new TermsAggregationBuilder("agg1").userValueTypeHint(ValueType.STRING).field("type.keyword");
            Request create = new Request(HttpPut.METHOD_NAME, "/index4");
import org.opensearch.script.mustache.MultiSearchTemplateRequest;
            .size(0)
                + "            \"qa_join_field\" : {\n"
        assertFalse(explainResponse.isMatch());
            qb.relation(ShapeRelation.INTERSECTS);
        assertEquals(Collections.emptyMap(), searchResponse.getProfileResults());
            Collections.emptyMap()
        assertEquals("agg1", termsAgg.getName());
            );
            Collections.emptyMap()
    }
        searchSourceBuilder.aggregation(agg);
    }
import org.opensearch.search.aggregations.BucketOrder;
        assertThat(searchResponse.getTotalShards(), greaterThan(0));
            assertThat(explainResponse.getGetResult().getSource(), equalTo(Collections.singletonMap("field1", "value1")));
 * GitHub history for details.
        {
    }
        FieldCapabilitiesRequest request = new FieldCapabilitiesRequest().indices("non-existent").fields("rating");
            assertEquals(0, leafTerms.getDocCountError());
        assertThat(responses[1].isFailure(), Matchers.is(true));
        assertThat(multiSearchResponse.getResponses()[0].getFailure(), Matchers.nullValue());
                    )
        SearchResponse searchResponse = execute(searchRequest, highLevelClient()::search, highLevelClient()::searchAsync);
            List<Object> values = searchHit.getFields().get("result").getValues();
            .next();
        }
        RareTerms.Bucket type2 = termsAgg.getBucketByKey("type2");
            explainRequest.query(QueryBuilders.matchAllQuery());
            assertEquals(1, values.size());
            OpenSearchStatusException exception = expectThrows(
                .endObject()
                + "        \"name\" : \"answer\",\n"
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertToXContentEquivalent;
            Request doc3 = new Request(HttpPut.METHOD_NAME, "/" + indexName + "/_doc/3");
        assertEquals(1, searchResponse.getHits().getHits().length);
        assertThat(multiSearchResponse.getResponses()[1].isFailure(), Matchers.is(false));
 * under the License.
                + "    \"body\": \"<p>Unfortunately you're pretty much limited to FTP...\",\n"
        {
        assertEquals(2, compositeAgg.getBuckets().size());
                    + "  }"
            assertEquals(2, children.getDocCount());
        searchRequest1.source().query(new ScriptQueryBuilder(new Script(ScriptType.INLINE, "invalid", "code", Collections.emptyMap())));
            assertEquals(20.0, ((HashMap) values.get(0)).get("lon"));
import org.opensearch.script.mustache.SearchTemplateRequest;
        );
        assertThat(multiSearchResponse.getResponses()[0].getResponse(), nullValue());
        // IP field
            () -> execute(multiSearchTemplateRequest, highLevelClient()::msearchTemplate, highLevelClient()::msearchTemplateAsync)
        }
        DateHistogramAggregationBuilder yearAgg = new DateHistogramAggregationBuilder("year").field("date_created")
            Terms.Bucket troll = leafTerms.getBucketByKey("Troll");
        searchSourceBuilder.size(0);
        assertEquals(RestStatus.BAD_REQUEST, exception.status());
import static org.hamcrest.Matchers.greaterThan;
        );
                + "    \"owner\": {\n"
        Terms.Bucket type2 = termsAgg.getBucketByKey("type2");
        SearchIT.assertSearchHeader(multiSearchResponse.getResponses()[0].getResponse());
                + "    \"qa_join_field\" : \"question\"\n"
            assertEquals("second", bucket.getKeyAsString());
            assertThat(explainResponse.getGetResult().getFields().get("field1").getValue().toString(), equalTo("value1"));
        assertNotNull(goodResponse);
            "text",
        CountRequest countRequest = new CountRequest("index1", "index2", "index3");
        Terms.Bucket type2 = termsAgg.getBucketByKey("type2");
        );
        searchSourceBuilder.size(0);
        badRequest2.setScript("BAD QUERY TEMPLATE");
        multiSearchResponse = execute(multiSearchRequest, highLevelClient()::msearch, highLevelClient()::msearchAsync);
                        "keyword",
    }
import org.opensearch.join.aggregations.ChildrenAggregationBuilder;
                SearchSourceBuilder.searchSource().scriptField("result", new Script("new HashMap()"))
            }
            client().performRequest(doc);
        searchRequest.source(searchSourceBuilder);
        assertThat(multiSearchResponse.getTook().millis(), Matchers.greaterThanOrEqualTo(0L));
    }
        }
        assertEquals(0, searchResponse.getHits().getHits().length);
        } else {
        {
        searchRequest.source(searchSourceBuilder);
                + "        \"properties\" : {\n"
            Request doc5 = new Request(HttpPut.METHOD_NAME, "/index/_doc/5");
        CreatePitRequest pitRequest = new CreatePitRequest(new TimeValue(1, TimeUnit.DAYS), true, "test");
import org.opensearch.script.mustache.MultiSearchTemplateResponse.Item;
        assertEquals("agg1", termsAgg.getName());
    }
import org.opensearch.action.search.MultiSearchResponse;
        assertEquals(expectedKeywordCapabilities, ratingResponse.get("keyword"));
    }
        client().performRequest(doc);
        SearchIT.assertSearchHeader(multiSearchResponse.getResponses()[0].getResponse());
            ExplainResponse explainResponse = execute(explainRequest, highLevelClient()::explain, highLevelClient()::explainAsync);
            );
            assertEquals(Long.MIN_VALUE, values.get(1));
            ExplainResponse explainResponse = execute(explainRequest, highLevelClient()::explain, highLevelClient()::explainAsync);
        for (Suggest.Suggestion.Entry<? extends Suggest.Suggestion.Entry.Option> options : sugg) {
            new String[] { "index1" },
            assertEquals(1, bucket.getDocCount());
            client().performRequest(doc3);
import org.opensearch.core.rest.RestStatus;
        searchTemplateRequest.setScriptParams(Collections.emptyMap());
        client().performRequest(new Request(HttpPost.METHOD_NAME, "/_refresh"));
            values = searchHit.getFields().get("result").getValues();
        // We are not testing the full functionality here
            explainRequest.query(QueryBuilders.matchAllQuery());
        {
        client().performRequest(new Request("POST", "/test/_refresh"));
            explainRequest.query(QueryBuilders.matchAllQuery());
            SearchHit searchHit = searchResponse.getHits().getAt(0);
            ExplainResponse explainResponse = execute(explainRequest, highLevelClient()::explain, highLevelClient()::explainAsync);
            client().performRequest(doc2);
                    + "      \"distribution\": {"
            doc.setJsonEntity(builder.toString());
 * this work for additional information regarding copyright
        doc.setJsonEntity("{\"field\":\"value\"}");
                    + "  \"mappings\": {"
            }
            client().performRequest(doc2);
    }
        // Boolean field
            SearchRequest searchRequest = new SearchRequest("test").source(
        {
        BytesReference actualSource = searchTemplateResponse.getSource();
        {
import org.opensearch.action.search.ClearScrollRequest;
            SearchRequest searchRequest = new SearchRequest();
        assertEquals(Collections.emptyMap(), searchResponse.getProfileResults());
import org.opensearch.action.search.CreatePitResponse;
    }
                    .fetchField("result")
            assertEquals("999--", bucket.getKeyAsString());
        }
                    .query(new TermsQueryBuilder("result", "value_2"))
                    .query(new TermsQueryBuilder("result", "true"))
            doc4.setJsonEntity("{\"id\":4, \"field\":\"value2\"}");
            doc2.setJsonEntity("{\"type\":\"type1\", \"id\":2, \"num\":20, \"num2\":40}");
        assertThat(multiSearchResponse.getResponses()[2].getResponse().getHits().getTotalHits().value(), Matchers.equalTo(2L));
        assertNotNull(actualSource);
        assertNull(searchResponse.getSuggest());
        createIndex.setJsonEntity(
            multiSearchResponse.getResponses()[0].getResponse().getHits().getAt(0).getHighlightFields().get("field").fragments()[0]
            explainRequest.storedFields(new String[] { "field1" });
        scriptParams.put("number", 10);
                    + "    \"properties\": {"
        SearchHit hit = goodResponse.getHits().getHits()[0];
    public void testSearchWithCompositeAgg() throws IOException {
            DeletePitResponse deletePitResponse = execute(
        MultiSearchRequest multiSearchRequest = new MultiSearchRequest();
        assertEquals("type1", searchHit.getSourceAsMap().get("type"));
                + "            \"username\" : {\n"
            .addRange("0--999", 0.0, 1000.0)
package org.opensearch.client;
            );
    }
    }
                    .fetchField("result")
            List<Object> values = searchHit.getFields().get("result").getValues();
                new TermsAggregationBuilder("name").userValueTypeHint(ValueType.STRING).field("field.keyword").order(BucketOrder.key(true))
                        new Script("emit(params._source[\"field\"]);emit(params._source[\"field\"] + \"_2\")")
import org.opensearch.search.suggest.phrase.PhraseSuggestionBuilder;
        assertCountHeader(countResponse);
    }
            Request doc5 = new Request(HttpPut.METHOD_NAME, "/index3/_doc/5");
            );
        assertEquals(2, type2.getDocCount());
        assertEquals(Float.NaN, searchResponse.getHits().getMaxScore(), 0f);
        List<CompositeValuesSourceBuilder<?>> sources = Collections.singletonList(
            client().performRequest(doc1);
            Request create = new Request("PUT", "/index2");
            highLevelClient()::msearchTemplate,
            doc4.setJsonEntity("{\"type\":\"type2\", \"id\":4, \"num\":100, \"num2\":10}");
        }
            );
        SearchRequest searchRequest = new SearchRequest("index");
        {
import org.junit.Before;
            doc5.setJsonEntity("{\"type\":\"type2\", \"id\":5, \"num\":100, \"num2\":10}");
        searchRequest3.source()
            OpenSearchStatusException exception = expectThrows(
        assertCountHeader(countResponse);
            () -> execute(searchTemplateRequest, highLevelClient()::searchTemplate, highLevelClient()::searchTemplateAsync)
        searchTemplateRequest.setScript("{ \"query\": { \"match\": { \"num\": {{number}} } } }");
    }
        searchTemplateRequest.setScriptType(ScriptType.INLINE);
            );
        MultiSearchRequest multiSearchRequest = new MultiSearchRequest();
            );
        searchSourceBuilder.aggregation(
                SearchSourceBuilder.searchSource()
            // multi valued
            assertTrue(explainResponse.isExists());
        assertEquals(Collections.emptyMap(), searchResponse.getProfileResults());
            doc1.setJsonEntity("{\"type\":\"type1\", \"id\":1, \"num\":10, \"num2\":50}");
        assertEquals(0, searchResponse.getFailedShards());
        ParsedDateHistogram yearHistogram = searchResponse.getAggregations().get("year");
            ExplainResponse explainResponse = execute(explainRequest, highLevelClient()::explain, highLevelClient()::explainAsync);
        assertEqualsOnDouble(29d, matrixStats.getMean("num2"));
            SearchResponse searchResponse = execute(searchRequest, highLevelClient()::search, highLevelClient()::searchAsync);
        }
        SearchResponse searchResponse = execute(searchRequest, highLevelClient()::search, highLevelClient()::searchAsync);
        searchRequest.source(searchSourceBuilder);
        client().performRequest(new Request("POST", "/test/_refresh"));
            OpenSearchException exception = expectThrows(
            searchTemplateRequest,
            assertThat(explainResponse.getGetResult().getFields().keySet().size(), equalTo(2));
        assertEquals(2, bucket2.getDocCount());
            values = searchHit.getFields().get("result").getValues();
        assertEquals(2, type2.getDocCount());
                + "        \"display_name\": \"Troll\",\n"
        searchSourceBuilder.aggregation(
            assertThat(explainResponse.getExplanation().getValue(), equalTo(1.0f));
    }
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
        } finally {
        for (int i = 0; i < 100; i++) {
        searchRequest1.source()
        SearchResponse searchResponse = execute(searchRequest, highLevelClient()::search, highLevelClient()::searchAsync);
        );
            Matchers.equalTo("<em>value2</em>")
            "rating",
            );
            assertEquals(2, leafTerms.getBuckets().size());
import org.opensearch.action.search.SearchResponse;
            null,
                + "    \"body\": \"<p>I have Windows 2003 server and i bought a new Windows 2008 server...\",\n"
            Matchers.equalTo("<em>value2</em>")
 * not use this file except in compliance with the License.
            assertEquals(1, children.getAggregations().asList().size());
        OpenSearchException exception = expectThrows(
    }
        SearchTemplateRequest badRequest = new SearchTemplateRequest();
        for (Terms.Bucket bucket : terms.getBuckets()) {
        client().performRequest(createIndex);
        assertEquals(RestStatus.NOT_FOUND, exception.status());
            doc1.setJsonEntity("{\"username\":\"bob\", \"rating\": 18446744073709551615}");
        multiSearchRequest.add(searchRequest1);
            searchHit = searchResponse.getHits().getAt(0);
            assertThat(explainResponse.getGetResult().getFields().keySet(), equalTo(Collections.singleton("field1")));
            "rating",
        TermsAggregationBuilder termsAgg = new TermsAggregationBuilder("top-tags").userValueTypeHint(ValueType.STRING)
        SearchRequest searchRequest = new SearchRequest();
            assertThat(explainResponse.getIndex(), equalTo("index1"));
            SearchResponse searchResponse = execute(searchRequest, highLevelClient()::search, highLevelClient()::searchAsync);
        SearchRequest searchRequest = new SearchRequest("search_sort");
                    new MultiTermsValuesSourceConfig.Builder().setFieldName("rating").build()
            Request doc3 = new Request(HttpPut.METHOD_NAME, "/index2/_doc/3");
        MultiSearchRequest multiSearchRequest = new MultiSearchRequest();
import org.opensearch.action.fieldcaps.FieldCapabilitiesResponse;
        terms = multiSearchResponse.getResponses()[2].getResponse().getAggregations().get("name");
                + "            \"rating\" : {\n"
            assertEquals(0, list.size());
        searchTemplateRequest.setSimulate(true);
        }
        SearchRequest searchRequest2 = new SearchRequest("index2");
                Arrays.asList(
        assertEquals(Float.NaN, searchResponse.getHits().getMaxScore(), 0f);
        assertToXContentEquivalent(expectedSource, actualSource, MediaTypeRegistry.JSON);
        // Double field
            .size(10);
        searchRequest2.source()
        SearchIT.assertSearchHeader(multiSearchResponse.getResponses()[2].getResponse());
            SearchHit searchHit = searchResponse.getHits().getAt(0);
import org.opensearch.index.query.QueryBuilder;
            doc.setJsonEntity(builder.toString());
            SearchScrollRequest scrollRequest = new SearchScrollRequest(searchResponse.getScrollId()).scroll(TimeValue.timeValueMinutes(2));
            {
            assertTrue(explainResponse.getGetResult().isExists());
        assertThat(searchResponse.getHits().getAt(1).getSortValues().length, equalTo(1));
            SearchResponse searchResponse = execute(searchRequest, highLevelClient()::search, highLevelClient()::searchAsync);
    }
        assertFalse(goodResponse.getProfileResults().isEmpty());
            client().performRequest(doc1);
                SearchSourceBuilder.searchSource().scriptField("result", new Script("null"))
        );
            assertEquals(Double.MAX_VALUE, values.get(0));
        assertNull(searchResponse.getSuggest());
            List<Object> values = searchHit.getFields().get("result").getValues();
    public void testRenderSearchTemplate() throws IOException {
            assertEquals(1, values.size());
        assertEqualsOnDouble(-0.9876336291667923, matrixStats.getCorrelation("num", "num2"));
        FieldCapabilities expectedLongCapabilities = new FieldCapabilities(
    private void assertEqualsOnDouble(double expected, double actual) {
        assertEquals(0, searchResponse.getHits().getHits().length);
        assertNull(searchResponse.getSuggest());
                    + "        }"
        }
        Request doc = new Request("PUT", "/test/_doc/1");
            false,
        {
        assertEquals(1, searchResponse.getHits().getTotalHits().value());
    public void testExplain() throws IOException {
                + "            \"username\" : {\n"
            assertThat(explainResponse.getGetResult().getSource().get("field1"), equalTo("value1"));
    }
        assertEquals(1, countResponse.getCount());
        Terms.Bucket type1 = termsAgg.getBucketByKey("type1");
            );
        {
                    + "  }"
            assertThat(explainResponse.getIndex(), equalTo("index1"));
    public void testCountOneIndexMatchQuery() throws IOException {
    public void testFieldCapsWithNonExistentFields() throws IOException {
            clearScrollRequest.addScrollId(searchResponse.getScrollId());
        );
        assertThat(multiSearchResponse.getResponses()[1].getFailure(), Matchers.nullValue());
            assertEquals("value_2", values.get(1));
                + "        \"properties\" : {\n"
            "{\n"
        multiSearchTemplateRequest.add(goodRequest);
            values = searchHit.getFields().get("result").getValues();
        Request answerDoc2 = new Request(HttpPut.METHOD_NAME, "/" + indexName + "/_doc/3");
                + "            \"rating\" : {\n"
        MultiSearchRequest multiSearchRequest = new MultiSearchRequest();
import static org.hamcrest.Matchers.nullValue;
            ClearScrollRequest clearScrollRequest = new ClearScrollRequest();
        multiSearchRequest.add(searchRequest1);
            doc2.setJsonEntity("{\"username\":\"tom\", \"rating\": 10223372036854775807}");
        searchSourceBuilder.size(0).aggregation(termsAgg);
            client().performRequest(doc);
        assertEquals(1, type1.getAggregations().asList().size());
        OpenSearchStatusException exception = expectThrows(
        assertEquals(searchResponse.getTotalShards(), searchResponse.getSuccessfulShards());
                + "    },\n"
            searchResponse = execute(searchRequest, highLevelClient()::search, highLevelClient()::searchAsync);
                .endObject()
        SearchRequest searchRequest = new SearchRequest("index");
            doc3.setJsonEntity("{\"username\":\"john\"}");
        MultiSearchTemplateRequest multiSearchTemplateRequest = new MultiSearchTemplateRequest();
        SearchTemplateResponse searchTemplateResponse = execute(
    public void testSearchWithTermsAndWeightedAvg() throws IOException {
        OpenSearchStatusException exception = expectThrows(
            assertEquals("0--999", bucket.getKeyAsString());
        multiSearchRequest.add(searchRequest2);
        Terms.Bucket type1 = termsAgg.getBucketByKey("type1");
            doc3.setJsonEntity("{\"id\":3, \"field\":\"value1\", \"rating\": \"good\"}");
            true,
        assertEquals(Collections.emptyMap(), searchResponse.getProfileResults());
        CountResponse countResponse = execute(countRequest, highLevelClient()::count, highLevelClient()::countAsync);
            assertEquals("type", options.getText().string());
    public void testSearchWithParentJoin() throws IOException {
        {
import org.opensearch.search.aggregations.bucket.composite.TermsValuesSourceBuilder;
            explainRequest.query(QueryBuilders.matchQuery("field", "value1"));
        assertEquals(2, ratingResponse.size());
    }
                + "    \"mappings\": {\n"
        assertEquals(Float.NaN, searchResponse.getHits().getMaxScore(), 0f);
            }
 */
                assertEquals(2, bucket.getDocCount());
        {
                    .derivedField("result", "keyword", new Script("emit(params._source[\"field\"])"))
        assertThat(multiSearchResponse.getResponses()[1].isFailure(), Matchers.is(false));
        answerDoc1.addParameter("routing", "1");
import org.opensearch.script.mustache.SearchTemplateResponse;
            assertTrue(explainResponse.getGetResult().isSourceEmpty());
            countRequest = new CountRequest(new String[] { "index1", "index2", "index3" }, query);
                + "            }\n"
                    + "        \"type\":  \"keyword\""
        assertEquals(Collections.emptyMap(), searchResponse.getProfileResults());
            highLevelClient()::msearchTemplateAsync
        assertTrue(response.get().containsKey("rating"));
        assertSearchHeader(searchResponse);
        }
            new String[] { "index2" },
                .weight(new MultiValuesSourceFieldConfig.Builder().setFieldName("num2").build())
                SearchSourceBuilder.searchSource()
    }
            searchRequest.source(searchSourceBuilder);
            assertTrue(explainResponse.isMatch());
                + "        \"display_name\": \"Sam\",\n"
            assertNotNull(values);
        assertThat(multiSearchResponse.getResponses()[2].getResponse().getHits().getAt(0).getId(), Matchers.equalTo("6"));
                assertEquals(1, bucket.getDocCount());
            null,
            OpenSearchException.class,
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        assertThat(multiSearchResponse.getResponses()[2].getResponse().getHits().getAt(1).getId(), Matchers.equalTo("6"));
        assertEquals(5, searchResponse.getHits().getTotalHits().value());
                + "        \"file-transfer\"\n"
                    + "    }"
        SearchResponse goodResponse = responses[0].getResponse().getResponse();
                () -> execute(scrollRequest, highLevelClient()::scroll, highLevelClient()::scrollAsync)
 */
        }
            ExplainResponse explainResponse = execute(explainRequest, highLevelClient()::explain, highLevelClient()::explainAsync);
        );
        final String indexName = "search_sort";
        for (int i = 0; i < 100; i++) {
                Range.Bucket bucket = rangeAgg.getBuckets().get(1);
        searchSourceBuilder.size(0);
            assertEquals(4, searchHit.getSourceAsMap().size());
            );
        SearchResponse searchResponse = execute(searchRequest, highLevelClient()::search, highLevelClient()::searchAsync);
            Request doc2 = new Request(HttpPut.METHOD_NAME, "/index/_doc/2");
            assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(100L));
        SearchRequest searchRequest3 = new SearchRequest("index3");
        SearchIT.assertSearchHeader(multiSearchResponse.getResponses()[0].getResponse());
        Terms termsAgg = searchResponse.getAggregations().get("agg1");
    }
            assertThat(Integer.valueOf(explainResponse.getId()), equalTo(1));
    }
        assertThat(multiSearchResponse.getResponses()[1].getResponse().getHits().getTotalHits().value(), Matchers.equalTo(2L));
        assertEquals(0, countResponse.getShardFailures().length);
                OpenSearchStatusException.class,
        searchSourceBuilder.size(0);
        assertThat(multiSearchResponse.getResponses()[0].isFailure(), Matchers.is(false));
        assertEquals(13, countResponse.getCount());
            assertNull(explainResponse.getGetResult());
        SearchRequest searchRequest = new SearchRequest("index");
            List<Object> values = searchHit.getFields().get("result").getValues();
            Request doc1 = new Request(HttpPut.METHOD_NAME, "/index/_doc/1");
                highLevelClient()::scrollAsync
            assertTrue(explainResponse.isExists());
            OpenSearchException rootCause = (OpenSearchException) exception.getRootCause();
        }
        Suggest.Suggestion<? extends Suggest.Suggestion.Entry<? extends Suggest.Suggestion.Entry.Option>> sugg = searchResponse.getSuggest()
        assertThat(multiSearchResponse.getResponses()[0].getResponse().getHits().getAt(0).getId(), Matchers.equalTo("1"));
                    + "        \"store\":  true"
        assertNull(searchResponse.getSuggest());
    }
        SearchRequest searchRequest = new SearchRequest("index5");
                    + "      }"
        assertEquals(2, type2.getDocCount());
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
    public void testMultiSearch_withQuery() throws Exception {
            }
        searchRequest2.source().sort("id", SortOrder.ASC);
        SearchIT.assertSearchHeader(multiSearchResponse.getResponses()[1].getResponse());
            Request createFilteredAlias = new Request(HttpPost.METHOD_NAME, "/_aliases");
        assertEquals(3, countResponse.getCount());
import static org.hamcrest.Matchers.either;
        }
        {
        assertSearchHeader(searchResponse);
            true,
        client().performRequest(doc);
        assertThat(responses[0].isFailure(), Matchers.is(false));
            searchRequest = new SearchRequest("test").source(
            assertTrue(explainResponse.hasExplanation());
            assertThat(exception.status(), equalTo(RestStatus.NOT_FOUND));
        searchRequest.source(searchSourceBuilder);
            );
        RareTerms termsAgg = searchResponse.getAggregations().get("agg1");
                .endObject()
        client().performRequest(new Request(HttpPost.METHOD_NAME, "/_refresh"));
            explainRequest.fetchSourceContext(new FetchSourceContext(true, null, new String[] { "field2" }));
        {
        try {
            {
        agg.subAggregation(new RangeAggregationBuilder("subagg").field("num").addRange("first", 0, 30).addRange("second", 31, 200));
        assertEqualsOnDouble(-0.13568039346585542, matrixStats.getSkewness("num2"));
        createIndex.setJsonEntity(
        SearchRequest searchRequest1 = new SearchRequest("index1");
                    .derivedField("result", "date", new Script("emit(" + date1.getMillis() + "L)"))
        CountResponse countResponse = execute(countRequest, highLevelClient()::count, highLevelClient()::countAsync);
                + "    \"creation_date\": \"2009-05-05T13:45:37.030\"\n"
        assertNull(searchResponse.getAggregations());
            doc3.setJsonEntity("{\"type\":\"type1\", \"id\":3, \"num\":50, \"num2\":35}");
            SearchResponse searchResponse = execute(searchRequest, highLevelClient()::search, highLevelClient()::searchAsync);
        assertEquals(Collections.emptyMap(), searchResponse.getProfileResults());
        {
import static org.hamcrest.Matchers.lessThan;
            true,
            assertTrue(explainResponse.isMatch());
                + "}"
            assertEquals(10.0, ((HashMap) values.get(0)).get("lat"));
        {
    public void testFieldCaps() throws IOException {
            DeletePitRequest deletePitRequest = new DeletePitRequest(pitIds);
import org.opensearch.script.mustache.MultiSearchTemplateResponse;
 *
        assertEquals(0, searchResponse.getHits().getHits().length);
            );
        scriptParams.put("number", "BAD NUMBER");
            assertNotNull(values);
        }
        multiSearchTemplateRequest.add(badRequest2);
        assertNull(searchResponse.getAggregations());
            assertEquals(0, map.size());
            );
                either(equalTo("file-transfer")).or(equalTo("windows-server-2003")).or(equalTo("windows-server-2008"))
                + "}"
            SearchHit searchHit = searchResponse.getHits().getAt(0);
            SearchHit searchHit = searchResponse.getHits().getAt(0);
            // multi-valued
import java.util.concurrent.TimeUnit;
            List<Object> values = searchHit.getFields().get("result").getValues();
        assertNotNull(searchHit.getSourceAsMap());
import org.opensearch.search.aggregations.bucket.histogram.DateHistogramAggregationBuilder;
        assertEquals(0, searchResponse.getShardFailures().length);
    public void testSearchWithMatrixStats() throws IOException {
        SearchResponse searchResponse = execute(searchRequest, highLevelClient()::search, highLevelClient()::searchAsync);
        SearchRequest searchRequest = new SearchRequest("index");
            }
            SearchRequest searchRequest = new SearchRequest("test").source(
            values = searchHit.getFields().get("result").getValues();
            assertNotNull(searchHit.getSourceAsMap());
                assertEquals("second", bucket.getKeyAsString());
import java.math.BigInteger;
            Request doc1 = new Request(HttpPut.METHOD_NAME, "/" + indexName + "/_doc/1");
        assertEquals(5, searchResponse.getHits().getHits().length);
        assertThat(searchResponse.getTook().nanos(), greaterThanOrEqualTo(0L));
import static org.hamcrest.Matchers.instanceOf;
            assertEquals(1, values.size());
                + "                \"type\" : \"join\",\n"
        assertEquals(0, bucket2.getAggregations().asList().size());
import org.opensearch.search.SearchHit;
            searchResponse = execute(searchRequest, highLevelClient()::search, highLevelClient()::searchAsync);
        assertThat(searchResponse.getHits().getAt(2).getSortValues().length, equalTo(1));
    public void testCountMultipleIndicesNoQuery() throws IOException {
        assertNotNull(hit.getExplanation());
        assertEquals(2, rangeAgg.getBuckets().size());
            assertTrue(searchHit.getSourceAsMap().containsKey("num2"));
        }
            SearchHit searchHit = searchResponse.getHits().getAt(0);
            client().performRequest(doc1);
        SearchResponse searchResponse = execute(searchRequest, highLevelClient()::search, highLevelClient()::searchAsync);
            assertSearchHeader(searchResponse);
        ExplainResponse explainResponse = execute(explainRequest, highLevelClient()::explain, highLevelClient()::explainAsync);
    public void testExplainWithStoredFields() throws IOException {
        searchRequest3.source().query(new TermsQueryBuilder("field", "value2"));
            doc1.setJsonEntity("{\"username\":\"bob\", \"rating\": 18446744073709551610}");
        SearchRequest searchRequest1 = new SearchRequest("index1");
        }
                assertEquals("second", bucket.getKeyAsString());
import org.opensearch.search.fetch.subphase.highlight.HighlightBuilder;
        MultiSearchResponse multiSearchResponse = execute(multiSearchRequest, highLevelClient()::msearch, highLevelClient()::msearchAsync);
                    .derivedField("result", "boolean", new Script("emit(((String)params._source[\"field\"]).equals(\"value\"))"))
            new RareTermsAggregationBuilder("agg1").userValueTypeHint(ValueType.STRING).field("type.keyword").maxDocCount(2)
            assertThat(searchResponse.getHits().getHits().length, equalTo(35));
            assertTrue(explainResponse.getGetResult().isSourceEmpty());
        Request doc = new Request("PUT", "/test/_doc/1");
                + "                \"type\" : \"keyword\"\n"
        assertNull(searchTemplateResponse.getResponse());
        SearchTemplateRequest searchTemplateRequest = new SearchTemplateRequest();
            assertThat(explainResponse.getIndex(), equalTo("index1"));
            assertEquals(24.4, weightedAvg.getValue(), 0f);
        assertThat(multiSearchResponse.getResponses()[2].getResponse().getHits().getHits().length, Matchers.equalTo(0));
            Map<?, ?> map = (Map<?, ?>) values.get(0);
            assertEquals(1, sam.getDocCount());
        assertEquals(5, matrixStats.getFieldCount("num"));
            }
        multiSearchRequest.add(searchRequest3);
        SearchRequest searchRequest = new SearchRequest().indices(indexName);
        assertEquals(2, termsAgg.getBuckets().size());
                    .derivedField("result", "ip", new Script("emit(\"10.0.0.1\"); emit(\"10.0.0.2\");"))
import org.opensearch.client.core.CountResponse;
        Terms termsAgg = searchResponse.getAggregations().get("agg1");
            Terms leafTerms = children.getAggregations().get("top-names");
        final String indexName = "multi_aggs";
            assertEquals("index", searchHit.getIndex());
            assertNotNull(values);
            assertTrue(explainResponse.isExists());
        client().performRequest(new Request(HttpPost.METHOD_NAME, "/test/_refresh"));
            assertNotNull(values);
            ExplainRequest explainRequest = new ExplainRequest("index4", "1");
    }
            SearchResponse searchResponse = execute(searchRequest, highLevelClient()::search, highLevelClient()::searchAsync);
            assertEquals("value", values.get(0));
            "keyword",
import org.opensearch.core.xcontent.MediaTypeRegistry;
        searchRequest2.source().query(new ScriptQueryBuilder(new Script(ScriptType.INLINE, "invalid", "code", Collections.emptyMap())));
        }
            Request doc2 = new Request(HttpPut.METHOD_NAME, "/index1/_doc/2");
                    + "      \"field2\": {"
            Request doc6 = new Request(HttpPut.METHOD_NAME, "/index3/_doc/6");
            assertNull(values.get(0));
            assertEquals(1, values.size());
            assertNotNull(values);
import org.opensearch.search.aggregations.bucket.terms.RareTermsAggregationBuilder;
        searchRequest.source().sort("rating", SortOrder.ASC);
                new TermsAggregationBuilder("name").userValueTypeHint(ValueType.STRING).field("field.keyword").order(BucketOrder.key(true))
        assertEquals(1, type1.getAggregations().asList().size());
        if (randomBoolean()) {
                + "    ],\n"
        assertThat(multiSearchResponse.getResponses().length, Matchers.equalTo(3));
            new MultiTermsAggregationBuilder("agg1").terms(
                "{"
                + "}"
            new WeightedAvgAggregationBuilder("subagg").value(new MultiValuesSourceFieldConfig.Builder().setFieldName("num").build())
import org.opensearch.action.fieldcaps.FieldCapabilities;
        assertThat(multiSearchResponse.getTook().millis(), Matchers.greaterThanOrEqualTo(0L));
        assertThat(multiSearchResponse.getResponses()[1].getResponse().getHits().getAt(0).getId(), Matchers.equalTo("4"));
        multiSearchRequest.add(searchRequest1);
        try {
        assertThat(multiSearchResponse.getResponses()[1].getResponse().getHits().getAt(0).getId(), Matchers.equalTo("3"));
        searchRequest.source(searchSourceBuilder);
            assertEquals(20.0, ((HashMap) values.get(0)).get("lon"));
        multiSearchRequest.add(searchRequest2);
    }
    public void testSearchWithSuggest() throws IOException {
        assertThat(multiSearchResponse.getResponses()[2].isFailure(), Matchers.is(false));
import org.opensearch.action.search.DeletePitResponse;
            create.setJsonEntity(
        assertThat(multiSearchResponse.getResponses()[1].getFailure(), Matchers.nullValue());
        assertSearchHeader(searchResponse);
        assertThat(multiSearchResponse.getResponses()[1].getResponse().getHits().getTotalHits().value(), Matchers.equalTo(1L));
        {
            assertFalse(explainResponse.hasExplanation());
        BytesReference expectedSource = BytesReference.bytes(
        assertSearchHeader(searchResponse);
            ExplainRequest explainRequest = new ExplainRequest("index1", "1");
        assertEquals(3, type1.getDocCount());
        assertThat(
        assertEquals(1, bucket1.getDocCount());
        assertThat(terms.getBuckets().get(0).getKeyAsString(), Matchers.equalTo("value1"));
    }
        Request questionDoc = new Request(HttpPut.METHOD_NAME, "/" + indexName + "/_doc/1");
                + "        \"location\": \"Norfolk, United Kingdom\",\n"
    public void testSearchWithSort() throws Exception {
                    + "    }"
                + "    }"
                highLevelClient()::deletePit,
        CountRequest countRequest = new CountRequest("index");
                    + "      }"
            searchRequest = new SearchRequest("test").source(
            searchHit = searchResponse.getHits().getAt(0);
                    + "        \"filter\" : { \"term\" : { \"field2\" : \"value1\" } }"
        assertThat(multiSearchResponse.getResponses()[0].isFailure(), Matchers.is(false));
        searchRequest.source(searchSourceBuilder);
            explainRequest.query(QueryBuilders.matchAllQuery());
        {
        assertCountHeader(countResponse);
        {
                    + "          }"
                    + "  \"mappings\": {"
                        "result",
            assertEquals(1, troll.getDocCount());
                assertEquals(0, bucket.getDocCount());
            assertEquals(Long.MAX_VALUE, values.get(0));
        countRequest.source(new SearchSourceBuilder().query(new MatchQueryBuilder("field", "value1")));
            "long",
            assertNull(explainResponse.getGetResult());
                + "            }\n"
        assertEquals(1, type2.getAggregations().asList().size());
        badRequest2.setScriptParams(scriptParams);
            assertEquals(Double.MIN_VALUE, values.get(1));
                highLevelClient()::deletePitAsync
            assertEquals(2, bucket.getDocCount());
        assertThat(multiSearchResponse.getResponses()[0].getFailure(), Matchers.nullValue());
        client().performRequest(new Request(HttpPost.METHOD_NAME, "/test/_refresh"));
import static org.hamcrest.Matchers.both;
        assertSearchHeader(searchResponse);
        assertThat(goodResponse.getHits().getMaxScore(), greaterThan(0f));
            null,
        assertThat(multiSearchResponse.getResponses()[2].isFailure(), Matchers.is(false));
    }
        assertNull(searchResponse.getSuggest());
            Range.Bucket bucket = rangeAgg.getBuckets().get(1);
                    + "    {"
        assertEquals(3, countResponse.getCount());
            .iterator()
        searchTemplateRequest.setScriptType(ScriptType.INLINE);
        Map<String, Object> scriptParams = new HashMap<>();
            assertThat(exception.getRootCause(), instanceOf(OpenSearchException.class));
                + "    \"qa_join_field\" : {\n"
            searchRequest = new SearchRequest("test").source(
        assertThat(responses[1].getFailureMessage(), containsString("json_parse_exception"));
            ExplainRequest explainRequest = new ExplainRequest("index1", "999");
        assertEquals(3, type1.getDocCount());
        assertEquals(1, yearHistogram.getBuckets().size());
        }
            client().performRequest(doc3);
                SearchSourceBuilder.searchSource()
        ExplainRequest explainRequest = new ExplainRequest("alias4", "1");
                + "}"
            createFilteredAlias.setJsonEntity(
                    + "}"
        {
                "{"
                    .fetchField("result")
        assertThat(searchResponse.getHits().getAt(0).getSortValues().length, equalTo(1));
        searchSourceBuilder.suggest(new SuggestBuilder().addSuggestion("sugg1", new PhraseSuggestionBuilder("type")).setGlobalText("type"));
        createIndex.setJsonEntity(
                assertEquals(counter++, ((Number) hit.getSortValues()[0]).longValue());
        searchRequest.indices("index");
        );
    }
            assertEquals(0, leafTerms.getSumOfOtherDocCounts());
/*
            .format("yyyy");
import org.opensearch.action.search.SearchScrollRequest;
            assertThat(explainResponse.getExplanation().getValue(), equalTo(1.0f));
            );
                + "                \"type\" : \"unsigned_long\"\n"
        assertEquals(3, searchResponse.getHits().getTotalHits().value());
                    .derivedField(
 * license agreements. See the NOTICE file distributed with
            );
        assertEquals(1, goodResponse.getHits().getHits().length);
                + "        \"parent\" : \"1\"\n"
    }
            assertEquals(-1L, searchHit.getVersion());
                .string(),
        );
                + "        \"windows-server-2008\",\n"
    public void testSearchTemplate() throws IOException {
        assertEquals(RestStatus.NOT_FOUND, exception.status());
            assertEquals(2, values.size());
                    + "}"
        {
            assertEquals("10.0.0.2", values.get(1));
        assertEquals(50, searchHit.getSourceAsMap().get("num2"));
        assertNotNull(responses[1].getFailureMessage());
                + "            },\n"
                SearchSourceBuilder.searchSource()
            assertEquals("10.0.0.1", values.get(0));
        CompositeAggregation.Bucket bucket2 = compositeAgg.getBuckets().get(1);
        assertEquals(expected, actual, 1.0e-12);
            List<Object> values = searchHit.getFields().get("result").getValues();
        CountResponse countResponse = execute(countRequest, highLevelClient()::count, highLevelClient()::countAsync);
        {
        assertThat(multiSearchResponse.getResponses()[1].getFailure().getMessage(), containsString("search_phase_execution_exception"));
            DateTime date2 = new DateTime(1990, 12, 30, 0, 0, DateTimeZone.UTC);
        Terms terms = searchResponse.getAggregations().get("top-tags");
import org.opensearch.common.geo.ShapeRelation;
import org.opensearch.search.aggregations.support.ValueType;
                Range.Bucket bucket = rangeAgg.getBuckets().get(0);
            doc5.setJsonEntity("{\"id\":5, \"field\":\"value1\"}");
        assertThat(multiSearchResponse.getResponses()[0].getFailure(), Matchers.nullValue());
            explainRequest.fetchSourceContext(new FetchSourceContext(true, new String[] { "field1" }, null));
            assertNotNull(values);
            WeightedAvg weightedAvg = type2.getAggregations().get("subagg");
    public void testMultiSearchTemplate() throws Exception {
        searchRequest.source(searchSourceBuilder);
        assertEqualsOnDouble(-767.5, matrixStats.getCovariance("num", "num2"));
    }
import org.opensearch.core.xcontent.XContentBuilder;
            countRequest = new CountRequest(new String[] { "index1", "index2", "index3" }, sourceBuilder);
        assertEquals("agg1", rangeAgg.getName());
            assertEquals(1, values.size());
        client().performRequest(answerDoc1);
            assertTrue(explainResponse.getGetResult().isExists());
        assertThat(searchResponse.getHits().getAt(2).getId(), Matchers.equalTo("3"));
        SearchResponse searchResponse = searchTemplateResponse.getResponse();
            SearchRequest searchRequest = new SearchRequest("test").source(
        assertEquals("agg1", termsAgg.getName());
