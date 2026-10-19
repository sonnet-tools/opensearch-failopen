        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
                + "    \"creation_date\": \"2009-05-04T13:45:37.030\"\n"
        );
        assertEquals(0, searchResponse.getHits().getHits().length);
        assertEquals(3, bucket1.getDocCount());
            SearchRequest searchRequest = new SearchRequest("test").source(  
        assertEquals(0, searchResponse.getHits().getHits().length);
            );  
            multiSearchResponse.getResponses()[2].getResponse().getHits().getAt(0).getHighlightFields().get("field").fragments()[0]
                    .query(new RangeQueryBuilder("result").from(date1.toString()).to(date2.toString()))
        searchTemplateRequest.setScriptType(ScriptType.STORED);
        );
    public void testCountAllIndicesMatchQuery() throws IOException {  
        assertNull(searchResponse.getSuggest());
        // Double field  
            assertNotNull(values);  
    public void testExplainWithFetchSource() throws IOException {
                new TermsAggregationBuilder("name").userValueTypeHint(ValueType.STRING).field("field.keyword").order(BucketOrder.key(true))
            highLevelClient()::msearchTemplateAsync  
    public void testCountMultipleIndicesMatchQuery() throws IOException {  
            assertSearchHeader(searchResponse);
                )
            Matchers.equalTo("<em>value2</em>")
    }
            assertEquals(1, sam.getDocCount());  
            );  
            assertFalse(explainResponse.isMatch());
        searchTemplateRequest.setScriptType(ScriptType.INLINE);
        assertEqualsOnDouble(0.09340198804973039, matrixStats.getSkewness("num"));
            Request doc3 = new Request(HttpPut.METHOD_NAME, "/" + indexName + "/_doc/3");  
        searchSourceBuilder.aggregation(
            DeletePitResponse deletePitResponse = execute(
        List<CompositeValuesSourceBuilder<?>> sources = Collections.singletonList(
                    + "  }"
            assertThat(Integer.valueOf(explainResponse.getId()), equalTo(1));
        SearchRequest searchRequest1 = new SearchRequest("index1");  
        MultiSearchTemplateResponse multiSearchTemplateResponse = execute(  
        assertThat(searchResponse.getHits().getAt(0).getSortValues()[0], equalTo(new BigInteger("10223372036854775807")));
            assertTrue(explainResponse.isExists());
                    .derivedField(  
                SearchSourceBuilder.searchSource().scriptField("result", new Script("new String[]{}"))
 * under the License.  
import static org.hamcrest.Matchers.nullValue;  
        scriptParams = new HashMap<>();
            );  
                SearchSourceBuilder.searchSource()
        assertThat(multiSearchResponse.getResponses()[2].getResponse().getHits().getAt(0).getId(), Matchers.equalTo("5"));  
                containsString("OpenSearch exception [type=index_not_found_exception, reason=no such index [non_existent_index]]")
            assertTrue(explainResponse.isMatch());
        assertThat(multiSearchResponse.getResponses().length, Matchers.equalTo(3));
            assertEquals(20.0, ((HashMap) values.get(0)).get("lon"));
            .aggregation(
        assertNull(searchResponse.getAggregations());  
        assertEquals(1, goodResponse.getHits().getHits().length);  
            .size(10);  
        {
        searchTemplateRequest.setRequest(new SearchRequest("index"));  
        assertNull(responses[0].getResponse().getSource());
        assertEquals(1, searchResponse.getHits().getTotalHits().value());  
            Range.Bucket bucket = rangeAggregation.getBuckets().get(0);
        assertEquals(Float.NaN, searchResponse.getHits().getMaxScore(), 0f);
        assertNotNull(hit.getExplanation());  
        assertNull(searchTemplateResponse.getSource());
            "{\n"
            assertEquals(date1.toString(), values.get(0));
import org.opensearch.script.mustache.MultiSearchTemplateResponse.Item;
            searchHit = searchResponse.getHits().getAt(0);  
        searchSourceBuilder.size(0);
        assertThat(multiSearchResponse.getResponses()[1].getFailure(), Matchers.nullValue());
                highLevelClient()::deletePit,  
                assertEquals(2, bucket.getDocCount());
                SearchSourceBuilder.searchSource()
            assertEquals(1, values.size());  
            client().performRequest(doc2);  
        searchRequest.source(searchSourceBuilder);
/*  
                    .fetchField("result")
            assertEquals(1.0f, searchHit.getScore(), 0);
        scriptParams.put("number", "BAD NUMBER");
            assertTrue(explainResponse.isMatch());
            explainRequest.query(QueryBuilders.matchQuery("field", "value"));
            assertTrue(explainResponse.hasExplanation());  
                + "        \"windows-server-2003\",\n"  
        assertThat(
import org.joda.time.DateTime;  
        Terms.Bucket type1 = termsAgg.getBucketByKey("type1");  
        assertEquals("{terms=type2}", bucket2.getKeyAsString());  
            doc3.setJsonEntity("{\"type\":\"type1\", \"id\":3, \"num\":50, \"num2\":35}");
            Range rangeAgg = type2.getAggregations().get("subagg");
                + "    \"body\": \"<p>I have Windows 2003 server and i bought a new Windows 2008 server...\",\n"  
        assertEquals(RestStatus.NOT_FOUND, exception.status());
            {
        assertEquals(2, termsAgg.getBuckets().size());
            ExplainRequest explainRequest = new ExplainRequest("index4", "1");
                    .derivedField("result", "geo_point", new Script("emit(10.0, 20.0); emit(20.0, 30.0);"))  
            explainRequest.fetchSourceContext(new FetchSourceContext(true, null, new String[] { "field2" }));
            Matchers.equalTo("<em>value2</em>")
        SearchRequest searchRequest = new SearchRequest("index");
        searchRequest.source(searchSourceBuilder);
        assertThat(multiSearchResponse.getResponses()[0].getResponse().getHits().getHits().length, Matchers.equalTo(0));
        countRequest.source(new SearchSourceBuilder().query(new MatchQueryBuilder("field", "value1")));
 * ownership. Elasticsearch licenses this file to you under  
            values = searchHit.getFields().get("result").getValues();
                    .fetchField("result")  
    }  
            {  
    }
        searchRequest2.source().query(new TermsQueryBuilder("field", "value2"));
        }  
        {
        assertEquals(RestStatus.NOT_FOUND, exception.status());
 *
            client().performRequest(create);
        assertSearchHeader(searchResponse);  
        assertEquals(1, searchResponse.getAggregations().asList().size());
        ChildrenAggregationBuilder childrenAgg = new ChildrenAggregationBuilder("to-answers", "answer").subAggregation(leafTermAgg);
    }
        badRequest.setScriptType(ScriptType.INLINE);
                + "    \"qa_join_field\" : {\n"  
        searchSourceBuilder.aggregation(new TermsAggregationBuilder("agg1").userValueTypeHint(ValueType.STRING).field("type.keyword"));
        assertThat(multiSearchResponse.getResponses()[2].getResponse().getHits().getAt(1).getId(), Matchers.equalTo("6"));
            assertEquals(-1L, searchHit.getVersion());
import org.junit.Before;  
    public void testNonExistentSearchTemplate() {
            assertEquals("10.0.0.1", values.get(0));
                    .fetchField("result")
                    )
            assertEquals(2, values.size());
                + "            },\n"
        assertEquals(3, terms.getBuckets().size());
    }  
        searchRequest3.source().highlighter(new HighlightBuilder().field("field"));
            new TermsValuesSourceBuilder("terms").field("type.keyword").missingBucket(true).order("asc")  
    public void testMultiSearch() throws Exception {
        client().performRequest(new Request(HttpPost.METHOD_NAME, "/search_sort/_refresh"));
            );
import org.opensearch.script.mustache.SearchTemplateRequest;  
            client().performRequest(createFilteredAlias);
        assertThat(multiSearchResponse.getResponses()[1].isFailure(), Matchers.is(true));  
    public void testMultiSearch_failure() throws Exception {
        explainRequest.query(QueryBuilders.matchAllQuery());  
            assertEquals(0, leafTerms.getSumOfOtherDocCounts());
            );
        goodRequest.setScriptType(ScriptType.INLINE);
        }  
                + "    ],\n"  
        badRequest.setRequest(new SearchRequest("index"));  
        CountResponse countResponse = execute(countRequest, highLevelClient()::count, highLevelClient()::countAsync);
import org.opensearch.core.xcontent.MediaTypeRegistry;
    public void testFieldCapsWithNonExistentIndices() {  
        assertEquals(Collections.emptyMap(), searchResponse.getProfileResults());
                    + "        \"store\":  true"
        assertThat(multiSearchResponse.getTook().millis(), Matchers.greaterThanOrEqualTo(0L));
        assertThat(searchResponse.getHits().getMaxScore(), greaterThan(0f));
        SearchResponse searchResponse = execute(searchRequest, highLevelClient()::search, highLevelClient()::searchAsync);
            assertTrue(explainResponse.getGetResult().isSourceEmpty());
        SearchRequest searchRequest2 = new SearchRequest("index2");  
 * software distributed under the License is distributed on an
        Map<String, FieldCapabilities> fieldResponse = response.getField("field");
        SearchRequest searchRequest3 = new SearchRequest("index3");
            assertNotNull(values);  
        searchTemplateRequest.setSimulate(true);
        badRequest1.setScript("{ \"query\": { \"match\": { \"num\": {{number}} } } }");  
    }
        {
                    .derivedField("result", "long", new Script("emit(Long.MAX_VALUE); emit(Long.MIN_VALUE);"))
                    + "    {"
            doc2.setJsonEntity("{\"id\":2, \"field\":\"value2\"}");
        assertThat(multiSearchResponse.getResponses()[2].getResponse().getHits().getTotalHits().value(), Matchers.equalTo(1L));  
import org.opensearch.join.aggregations.Children;
        assertThat(multiSearchResponse.getTook().millis(), Matchers.greaterThanOrEqualTo(0L));  
            List<Object> values = searchHit.getFields().get("result").getValues();
        assertEquals(Collections.emptyMap(), searchResponse.getProfileResults());  
            SearchResponse searchResponse = execute(searchRequest, highLevelClient()::search, highLevelClient()::searchAsync);  
            SearchRequest searchRequest = new SearchRequest("test").source(
        assertThat(terms.getBuckets().get(1).getKeyAsString(), Matchers.equalTo("value2"));
        }
        {
        FieldCapabilitiesResponse response = execute(request, highLevelClient()::fieldCaps, highLevelClient()::fieldCapsAsync);
import org.opensearch.search.aggregations.bucket.histogram.ParsedDateHistogram;
            Request doc = new Request(HttpPut.METHOD_NAME, "/test/_doc/" + Integer.toString(i));
                .string(),
            client().performRequest(create);
            create.setJsonEntity(
 * Unless required by applicable law or agreed to in writing,
            OpenSearchStatusException.class,
            Request create = new Request("PUT", "/index2");
            SearchHit searchHit = searchResponse.getHits().getAt(0);
        SearchResponse searchResponse = execute(searchRequest, highLevelClient()::search, highLevelClient()::searchAsync);
        );  
                + "        \"name\" : \"answer\",\n"
            searchRequest = new SearchRequest("test").source(  
        Map<String, FieldCapabilities> ratingResponse = response.getField("rating");
                assertEquals(0, bucket.getDocCount());
            }
        CountRequest countRequest = new CountRequest("index", "index1");  
        badRequest2.setScriptParams(scriptParams);  
        assertEquals(3, countResponse.getCount());
            XContentFactory.jsonBuilder()
        assertNull(searchResponse.getSuggest());
            SearchRequest searchRequest = new SearchRequest();  
                new SearchScrollRequest(searchResponse.getScrollId()).scroll(TimeValue.timeValueMinutes(2)),
            );  
        searchRequest.source(searchSourceBuilder);  
            );
            searchResponse = execute(searchRequest, highLevelClient()::search, highLevelClient()::searchAsync);
}  
            List<Object> values = searchHit.getFields().get("result").getValues();
            assertEquals(0, list.size());
            assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(100L));  
                + "    },\n"
            assertEquals(RestStatus.NOT_FOUND, exception.status());  
            assertEquals(1, bucket.getDocCount());
        badRequest.setScript("{ NOT VALID JSON {{number}} }");
        Map<String, Object> scriptParams = new HashMap<>();
                    .fetchField("result")
                + "    },\n"
                + "    \"creation_date\": \"2009-05-05T13:45:37.030\"\n"
        assertEquals(0, terms.getDocCountError());
            {
                assertEquals("second", bucket.getKeyAsString());  
            assertTrue(explainResponse.isExists());  
            doc3.setJsonEntity("{\"username\":\"john\"}");
        MultiSearchTemplateRequest multiSearchTemplateRequest = new MultiSearchTemplateRequest();
        if (randomBoolean()) {
                    + "    \"properties\": {"  
import org.opensearch.search.aggregations.BucketOrder;
            Request doc2 = new Request(HttpPut.METHOD_NAME, "/" + indexName + "/_doc/2");  
            ClearScrollRequest clearScrollRequest = new ClearScrollRequest();  
    public void testSearchWithSort() throws Exception {
        assertEquals(2, rangeAgg.getBuckets().size());
import org.opensearch.action.explain.ExplainResponse;  
            assertThat(explainResponse.getExplanation().getValue(), equalTo(1.0f));
            countRequest = new CountRequest(new String[] { "index1", "index2", "index3" }, sourceBuilder);
            client().performRequest(doc1);
            assertTrue(deletePitResponse.getDeletePitResults().get(0).isSuccessful());  
        assertEquals(3, countResponse.getCount());
                + "            }\n"  
                SearchSourceBuilder.searchSource()
        Terms.Bucket type2 = termsAgg.getBucketByKey("type2");
            assertNotNull(values);
 *
            Request doc1 = new Request(HttpPut.METHOD_NAME, "/index/_doc/1");
            assertThat(exception.getRootCause(), instanceOf(OpenSearchException.class));
        assertSearchHeader(searchResponse);
        SearchTemplateResponse searchTemplateResponse = execute(
        goodRequest.setExplain(true);
            searchResponse = execute(searchRequest, highLevelClient()::search, highLevelClient()::searchAsync);
    public void testSearchWithTermsAndWeightedAvg() throws IOException {
        searchTemplateRequest.setScript("{ \"query\": { \"match\": { \"num\": {{number}} } } }");
        badRequest2.setRequest(new SearchRequest("index"));
            .field("tags.keyword")  
                .string(),  
            assertThat(explainResponse.getId(), equalTo("999"));  
 * this work for additional information regarding copyright
            multiSearchResponse.getResponses()[1].getResponse().getHits().getAt(0).getHighlightFields().get("field").fragments()[0]
import org.opensearch.script.ScriptType;
                        "result",
            assertEquals(Long.MIN_VALUE, values.get(1));
        badRequest1.setScriptType(ScriptType.INLINE);
        answerDoc2.setJsonEntity(
        badRequest.setScriptParams(scriptParams);
                SearchSourceBuilder.searchSource()  
        {
        assertNotNull(searchResponse);
        assertThat(responses[0].isFailure(), Matchers.is(false));
            client().performRequest(doc1);  
                + "}"
            SearchResponse searchResponse = execute(searchRequest, highLevelClient()::search, highLevelClient()::searchAsync);  
        SearchIT.assertSearchHeader(multiSearchResponse.getResponses()[0].getResponse());
                Range.Bucket bucket = rangeAgg.getBuckets().get(0);
            assertNotNull(values);
        Terms termsAgg = searchResponse.getAggregations().get("agg1");  
                    .query(qb)
        assertEquals(0, type1.getAggregations().asList().size());
            searchTemplateRequest,
            Terms.Bucket sam = leafTerms.getBucketByKey("Sam");
import java.util.ArrayList;
    public void testSearchWithRangeAgg() throws IOException {
            List<String> pitIds = new ArrayList<>();
            );
                    .fetchField("result")  
                + "        \"id\": 49\n"  
            assertNotNull(values);
import org.opensearch.index.query.QueryBuilder;  
        ExplainResponse explainResponse = execute(explainRequest, highLevelClient()::explain, highLevelClient()::explainAsync);
            doc2.setJsonEntity("{\"type\":\"type1\", \"id\":2, \"num\":20, \"num2\":40}");
        Request doc = new Request("PUT", "/test/_doc/1");  
        multiSearchRequest.add(searchRequest3);  
    }  
                    + "  }"
            null,
 */  
            assertNotNull(values);
            DateTime date2 = new DateTime(1990, 12, 30, 0, 0, DateTimeZone.UTC);
        multiSearchTemplateRequest.add(badRequest2);
                    + "  \"actions\" : ["  
            // multi-valued  
            searchSourceBuilder.size(0);  
                + "                \"type\" : \"unsigned_long\"\n"  
        {
        }
        TermsAggregationBuilder agg = new TermsAggregationBuilder("agg1").userValueTypeHint(ValueType.STRING).field("type.keyword");  
        assertThat(multiSearchResponse.getResponses()[2].isFailure(), Matchers.is(false));
            Collections.emptyMap()  
            searchHit = searchResponse.getHits().getAt(0);  
        );  
import org.opensearch.action.search.CreatePitResponse;
            assertTrue(explainResponse.isExists());
        assertFalse(searchResponse.getProfileResults().isEmpty());
        // The whole HTTP request should fail if no nested search requests are valid
                highLevelClient()::scroll,
                    + "      \"field2\": {"
            searchRequest = new SearchRequest("test").source(
        {
            Range.Bucket bucket = rangeAgg.getBuckets().get(0);
        Terms.Bucket type1 = termsAgg.getBucketByKey("type1");
        }  
            highLevelClient()::msearchTemplate,
            "long",
                    + "      },"
                + "        \"properties\" : {\n"
        Request answerDoc2 = new Request(HttpPut.METHOD_NAME, "/" + indexName + "/_doc/3");
            .sort("field", SortOrder.ASC)
                + "                \"type\" : \"join\",\n"
                + "    \"qa_join_field\" : {\n"  
            SearchResponse searchResponse = execute(searchRequest, highLevelClient()::search, highLevelClient()::searchAsync);
            ClearScrollResponse clearScrollResponse = execute(
                    .derivedField("result", "geo_point", new Script("emit(10.0, 20.0)"))
import org.opensearch.script.mustache.MultiSearchTemplateRequest;  
            countRequest = new CountRequest(new String[] { "index1", "index2", "index3" }, query);
            assertThat(explainResponse.getGetResult().getSource(), equalTo(Collections.singletonMap("field1", "value1")));  
            assertNull(explainResponse.getGetResult());
        }
        assertThat(multiSearchResponse.getResponses().length, Matchers.equalTo(2));  
            client().performRequest(doc3);  
            assertTrue(explainResponse.isMatch());  
                + "        \"name\" : \"answer\",\n"
        }  
        assertSearchHeader(searchResponse);  
 * the Apache License, Version 2.0 (the "License"); you may
            List<Object> values = searchHit.getFields().get("result").getValues();
        assertEquals(Float.NaN, searchResponse.getHits().getMaxScore(), 0f);
        assertCountHeader(countResponse);
import java.util.Map;  
            assertThat(explainResponse.getExplanation().getValue(), equalTo(1.0f));
                + "            \"username\" : {\n"
        }
        }
            client().performRequest(doc5);
        assertThat(multiSearchResponse.getResponses()[1].getFailure(), Matchers.nullValue());
        );
import org.opensearch.script.Script;
            assertEquals(100, weightedAvg.getValue(), 0f);  
        ParsedDateHistogram yearHistogram = searchResponse.getAggregations().get("year");
                    new MultiTermsValuesSourceConfig.Builder().setFieldName("rating").build()  
import org.opensearch.search.aggregations.bucket.terms.Terms;
        badRequest2.setScript("BAD QUERY TEMPLATE");  
                either(equalTo("file-transfer")).or(equalTo("windows-server-2003")).or(equalTo("windows-server-2008"))
            null,  
                + "    \"body\": \"<p>Use Linux...\",\n"
                highLevelClient()::scroll,
        }
        multiSearchResponse = execute(multiSearchRequest, highLevelClient()::msearch, highLevelClient()::msearchAsync);  
            assertEquals(1, troll.getDocCount());
import org.opensearch.search.builder.PointInTimeBuilder;
        SearchRequest searchRequest = new SearchRequest("index");
        assertThat(multiSearchResponse.getResponses()[1].getResponse().getHits().getAt(1).getId(), Matchers.equalTo("4"));  
    public void testRenderSearchTemplate() throws IOException {
            assertEquals(1, values.size());
    public void testSearchWithDateAndRangeAgg() throws IOException {
    public void testSearchWithSuggest() throws IOException {  
        assertThat(multiSearchResponse.getResponses()[0].getResponse().getHits().getAt(0).getId(), Matchers.equalTo("1"));
        SearchRequest searchRequest = new SearchRequest();  
            assertFalse(explainResponse.hasExplanation());  
        Request answerDoc1 = new Request(HttpPut.METHOD_NAME, "/" + indexName + "/_doc/2");
import org.opensearch.search.aggregations.bucket.histogram.DateHistogramInterval;  
        }
            assertTrue(explainResponse.isExists());  
        {  
                    + "    }"  
        } else {
        } else {
            Terms leafTerms = children.getAggregations().get("top-names");  
                assertEquals("second", bucket.getKeyAsString());
        SearchRequest searchRequest = new SearchRequest(indexName);
                Arrays.asList(
            new RareTermsAggregationBuilder("agg1").userValueTypeHint(ValueType.STRING).field("type.keyword").maxDocCount(2)  
        OpenSearchException exception = expectThrows(  
            assertThat(explainResponse.getIndex(), equalTo("index1"));  
        CountRequest countRequest = new CountRequest();
    }  
            SearchRequest searchRequest = new SearchRequest("test").source(
        assertThat(multiSearchResponse.getResponses()[2].isFailure(), Matchers.is(false));
            Request doc1 = new Request(HttpPut.METHOD_NAME, "/index5/_doc/1");
            // multi-valued
        assertEquals(5, searchResponse.getHits().getHits().length);  
    }
            SearchSourceBuilder sourceBuilder = new SearchSourceBuilder().query(new MatchQueryBuilder("field", "value1"));  
        client().performRequest(questionDoc);
        }
import static org.hamcrest.Matchers.lessThan;
import org.opensearch.action.search.MultiSearchRequest;
            explainRequest.query(QueryBuilders.matchAllQuery());  
                SearchSourceBuilder.searchSource()  
import org.opensearch.core.common.bytes.BytesReference;
        SearchRequest searchRequest = new SearchRequest("index");
import static org.hamcrest.Matchers.containsString;
                    + "        \"index\" : \"index4\","  
            null,
            SearchHit searchHit = searchResponse.getHits().getAt(0);
        assertEquals(1, bucket2.getDocCount());
        SearchTemplateRequest searchTemplateRequest = new SearchTemplateRequest();
    public void testSearchNoQuery() throws IOException {
        assertThat(multiSearchResponse.getResponses()[1].isFailure(), Matchers.is(false));
        multiSearchTemplateRequest.add(badRequest);
        assertThat(multiSearchResponse.getResponses()[1].getResponse(), nullValue());
        );
                    + "      }"
        SearchRequest searchRequest2 = new SearchRequest("index2");  
            assertEquals(2, values.size());  
        assertEquals(3, type1.getDocCount());  
                    .query(new TermsQueryBuilder("result", "true"))  
        assertEquals(1, type1.getAggregations().asList().size());
        doc.setJsonEntity("{\"field\":\"value\"}");  
                + "        \"parent\" : \"1\"\n"
        OpenSearchStatusException exception = expectThrows(
            searchResponse = execute(  
        assertThat(searchResponse.getHits().getAt(0).getSortValues().length, equalTo(1));
        {  
        assertEquals(0, bucket1.getAggregations().asList().size());
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            );
        Terms termsAgg = searchResponse.getAggregations().get("agg1");  
import org.opensearch.action.search.SearchResponse;
import static org.hamcrest.Matchers.arrayContaining;  
        searchRequest.source().sort("rating", SortOrder.ASC);
        answerDoc2.addParameter("routing", "1");  
            assertThat(exception.status(), equalTo(RestStatus.NOT_FOUND));
        assertEquals(Collections.emptyMap(), searchResponse.getProfileResults());
            Request create = new Request(HttpPut.METHOD_NAME, "/index4");
        assertEquals(Float.NaN, searchResponse.getHits().getMaxScore(), 0f);
            SearchHit searchHit = searchResponse.getHits().getAt(0);  
        searchRequest3.source().sort("id", SortOrder.ASC);
            Request doc4 = new Request(HttpPut.METHOD_NAME, "/index/_doc/4");
            assertEquals(2, values.size());  
            assertNotNull(values);
        {
            assertEquals(1, values.size());
        assertNull(responses[0].getResponse().getSource());  
        SearchResponse searchResponse = execute(searchRequest, highLevelClient()::search, highLevelClient()::searchAsync);  
import org.opensearch.search.aggregations.AggregationBuilders;  
                + "            \"username\" : {\n"
            .iterator()
        multiSearchRequest.add(searchRequest2);
 *    http://www.apache.org/licenses/LICENSE-2.0
                    .fetchField("result")  
                .string(),
        assertThat(multiSearchResponse.getResponses()[0].getResponse(), nullValue());
        SearchResponse searchResponse = execute(searchRequest, highLevelClient()::search, highLevelClient()::searchAsync);
import org.hamcrest.Matchers;
        assertNotNull(searchHit.getSourceAsMap());
            assertTrue(explainResponse.hasExplanation());
            ExplainRequest explainRequest = new ExplainRequest("index1", "1");
                    + "    \"properties\": {"
        CompositeAggregation.Bucket bucket1 = compositeAgg.getBuckets().get(0);  
        }  
                        "keyword",
    }  
        assertEquals("sugg1", sugg.getName());
        // Keyword field  
        searchSourceBuilder.aggregation(agg);
        assertEquals(0, searchResponse.getHits().getHits().length);
        // Concurrent search could have small difference in floating-point results when merging from different way of slicing shard.
        searchSourceBuilder.size(0);
            );
        SearchHit hit = goodResponse.getHits().getHits()[0];
        SearchRequest searchRequest = new SearchRequest();  
                    new MultiTermsValuesSourceConfig.Builder().setFieldName("username").build(),
            "rating",  
import static org.hamcrest.Matchers.greaterThanOrEqualTo;  
                    .derivedField("result", "ip", new Script("emit(\"10.0.0.1\"); emit(\"10.0.0.2\");"))
        SearchIT.assertSearchHeader(multiSearchResponse.getResponses()[0].getResponse());  
        MultiSearchResponse multiSearchResponse = execute(multiSearchRequest, highLevelClient()::msearch, highLevelClient()::msearchAsync);  
        assertNotNull(actualSource);
            assertThat(values.get(0), instanceOf(List.class));
        if (randomBoolean()) {
            values = searchHit.getFields().get("result").getValues();  
                    + "        \"alias\" : \"alias4\","
            assertThat(explainResponse.getGetResult().getFields().get("field1").getValue().toString(), equalTo("value1"));
import org.opensearch.search.aggregations.metrics.WeightedAvg;
        }
            client().performRequest(doc);  
            assertThat(exception.getIndex().getName(), equalTo("non_existent_index"));
        assertEquals(2, type2.getDocCount());
            Map<?, ?> map = (Map<?, ?>) values.get(0);
        searchSourceBuilder.size(0).aggregation(termsAgg);
import org.opensearch.search.aggregations.metrics.WeightedAvgAggregationBuilder;  
        SearchRequest searchRequest = new SearchRequest("index");
        {
                    + "      \"date_created\": {"
    }
import org.opensearch.index.query.QueryBuilders;
            .subAggregation(childrenAgg);
            Terms.Bucket troll = leafTerms.getBucketByKey("Troll");
            assertThat(explainResponse.getIndex(), equalTo("index1"));
    }
        ExplainRequest explainRequest = new ExplainRequest("alias4", "1");
        assertThat(exception.getMessage(), containsString("no requests added"));
    }
                highLevelClient()::clearScroll,
            assertEquals(1, values.size());
            assertTrue(explainResponse.isExists());  
        );  
            assertEquals("first", bucket.getKeyAsString());
            multiSearchTemplateRequest,
        }  
            SearchHit searchHit = searchResponse.getHits().getAt(0);
        CountResponse countResponse = execute(countRequest, highLevelClient()::count, highLevelClient()::countAsync);  
        SearchRequest searchRequest = new SearchRequest("test").scroll(TimeValue.timeValueMinutes(2)).source(searchSourceBuilder);  
                + "    }"
        assertEqualsOnDouble(1.2741646510794589, matrixStats.getKurtosis("num"));
        assertEquals(2, termsAgg.getBuckets().size());
        assertEquals(0, searchResponse.getHits().getHits().length);  
        assertThat(multiSearchResponse.getResponses()[0].getResponse().getHits().getTotalHits().value(), Matchers.equalTo(2L));  
            assertThat(explainResponse.getExplanation().getValue(), equalTo(1.0f));
        assertEquals(1, fieldResponse.size());
        DateHistogramAggregationBuilder yearAgg = new DateHistogramAggregationBuilder("year").field("date_created")
import org.opensearch.search.suggest.Suggest;  
            ExplainRequest explainRequest = new ExplainRequest("non_existent_index", "1");
                "{"
        assertEquals(0, searchResponse.getShardFailures().length);  
                + "        \"display_name\": \"Troll\",\n"
        {
        assertEquals(2, termsAgg.getBuckets().size());
        assertEquals("1", searchHit.getId());
            assertEquals(0, leafTerms.getDocCountError());
        for (Suggest.Suggestion.Entry<? extends Suggest.Suggestion.Entry.Option> options : sugg) {
                Range.Bucket bucket = rangeAgg.getBuckets().get(1);
                + "            \"rating\" : {\n"
            QueryBuilder query = new MatchQueryBuilder("field", "value1");  
        CreatePitResponse pitResponse = execute(pitRequest, highLevelClient()::createPit, highLevelClient()::createPitAsync);
        CountResponse countResponse = execute(countRequest, highLevelClient()::count, highLevelClient()::countAsync);
import java.util.Arrays;
                        new Script("emit(params._source[\"field\"]);emit(params._source[\"field\"] + \"_2\")")  
        assertEquals(Collections.emptyMap(), searchResponse.getProfileResults());
        assertSearchHeader(searchResponse);  
        scriptParams.put("number", 10);
        SearchResponse searchResponse = execute(searchRequest, highLevelClient()::search, highLevelClient()::searchAsync);
            assertTrue(explainResponse.hasExplanation());  
        SearchRequest searchRequest = new SearchRequest("index");
        SearchRequest searchRequest = new SearchRequest().source(searchSourceBuilder);
            );
    }
            assertEquals("type", options.getText().string());  
            assertEquals("value", values.get(0));
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
            List<Object> values = searchHit.getFields().get("result").getValues();
import java.util.HashMap;
        {
        );
        assertSearchHeader(searchResponse);  
        searchSourceBuilder.aggregation(AggregationBuilders.composite("composite", sources));
        searchRequest2.source().query(new ScriptQueryBuilder(new Script(ScriptType.INLINE, "invalid", "code", Collections.emptyMap())));
        TermsAggregationBuilder agg = new TermsAggregationBuilder("agg1").userValueTypeHint(ValueType.STRING).field("type.keyword");
                .startObject("match")
import org.opensearch.action.search.SearchRequest;  
                + "        }\n"
        // Date field
import org.opensearch.script.mustache.SearchTemplateResponse;
import static org.hamcrest.Matchers.greaterThan;
                    + "      \"field1\": {"
            assertEquals(RestStatus.BAD_REQUEST, exception.status());
        assertEqualsOnDouble(-767.5, matrixStats.getCovariance("num", "num2"));
            explainRequest.query(QueryBuilders.termQuery("field", "value2"));  
            assertNotNull(values);  
/*
        assertEquals(Collections.emptyMap(), searchResponse.getProfileResults());
        client().performRequest(new Request(HttpPost.METHOD_NAME, "/_refresh"));
        searchSourceBuilder.aggregation(  
            for (SearchHit hit : searchResponse.getHits()) {
                + "                \"type\" : \"keyword\"\n"  
import org.opensearch.search.aggregations.bucket.composite.CompositeAggregation;
            Request doc5 = new Request(HttpPut.METHOD_NAME, "/index/_doc/5");
        assertThat(multiSearchResponse.getResponses()[1].getFailure().getMessage(), containsString("search_phase_execution_exception"));
            Request createFilteredAlias = new Request(HttpPost.METHOD_NAME, "/_aliases");  
        assertEquals(RestStatus.BAD_REQUEST, exception.status());
        assertThat(multiSearchResponse.getResponses()[2].getResponse().getHits().getAt(0).getId(), Matchers.equalTo("6"));
        assertEquals(1, type1.getAggregations().asList().size());
        final String indexName = "multi_aggs";
            new WeightedAvgAggregationBuilder("subagg").value(new MultiValuesSourceFieldConfig.Builder().setFieldName("num").build())  
            searchRequest = new SearchRequest("test").source(
        assertThat(multiSearchResponse.getTook().millis(), Matchers.greaterThanOrEqualTo(0L));
            .size(0)  
        assertThat(terms.getBuckets().get(1).getKeyAsString(), Matchers.equalTo("value2"));
import org.opensearch.action.search.DeletePitResponse;  
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder().size(35).sort("field", SortOrder.ASC);
            explainRequest.query(QueryBuilders.matchAllQuery());
            searchRequest = new SearchRequest("test").source(
        SearchHit hit = searchResponse.getHits().getHits()[0];
                    + "      },"
                    + "}"
                + "            \"rating\" : {\n"
        assertThat(searchResponse.getHits().getAt(2).getId(), Matchers.equalTo("3"));
        Item[] responses = multiSearchTemplateResponse.getResponses();  
        searchRequest3.source()
        }
            ExplainResponse explainResponse = execute(explainRequest, highLevelClient()::explain, highLevelClient()::explainAsync);
            SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
            assertEquals(Double.MAX_VALUE, values.get(0));
                + "    \"owner\": {\n"  
        }
            create.setJsonEntity(  
                    + "        \"filter\" : { \"term\" : { \"field2\" : \"value1\" } }"
    public void testSearchMatchQuery() throws IOException {
        CountRequest countRequest = new CountRequest("index1", "index2", "index3");
    public void testExplainNonExistent() throws IOException {
        assertCountHeader(countResponse);
 *  
        searchRequest1.source().query(new ScriptQueryBuilder(new Script(ScriptType.INLINE, "invalid", "code", Collections.emptyMap())));
            explainRequest.fetchSourceContext(new FetchSourceContext(true, new String[] { "field1" }, null));  
            .next();  
        searchRequest2.source().sort("id", SortOrder.ASC);
        assertThat(multiSearchResponse.getResponses()[2].isFailure(), Matchers.is(false));  
        assertCountHeader(countResponse);
        assertEquals(1, searchResponse.getHits().getHits().length);
 * Licensed to Elasticsearch under one or more contributor  
        }
                    + "      }"
        assertThat(searchResponse.getHits().getAt(2).getSortValues().length, equalTo(1));
        assertEquals(Collections.emptyMap(), searchResponse.getProfileResults());
import org.opensearch.geometry.Rectangle;  
            assertThat(searchResponse.getHits().getHits().length, equalTo(35));
        SearchIT.assertSearchHeader(multiSearchResponse.getResponses()[0].getResponse());
                highLevelClient()::scrollAsync  
        }
        searchSourceBuilder.suggest(new SuggestBuilder().addSuggestion("sugg1", new PhraseSuggestionBuilder("type")).setGlobalText("type"));  
        assertThat(terms.getBuckets().get(1).getKeyAsString(), Matchers.equalTo("value2"));  
        doc.setJsonEntity("{\"field\":\"value\"}");
                + "        \"properties\" : {\n"
                new SearchScrollRequest(searchResponse.getScrollId()).scroll(TimeValue.timeValueMinutes(2)),
    private void assertEqualsOnDouble(double expected, double actual) {  
            client().performRequest(doc);
        }
            assertTrue(explainResponse.isExists());
        searchRequest.source(searchSourceBuilder);
        assertEqualsOnDouble(56d, matrixStats.getMean("num"));
        assertThat(multiSearchResponse.getResponses()[0].getResponse().getHits().getTotalHits().value(), Matchers.equalTo(1L));  
        SearchRequest searchRequest2 = new SearchRequest("index2");
    public void testCountOneIndexMatchQuery() throws IOException {
        assertNull(searchResponse.getAggregations());  
        assertEqualsOnDouble(29d, matrixStats.getMean("num2"));
import org.opensearch.index.query.MatchQueryBuilder;
                clearScrollRequest,  
                + "            },\n"
        goodRequest.setProfile(true);
package org.opensearch.client;
        MultiSearchResponse multiSearchResponse = execute(multiSearchRequest, highLevelClient()::msearch, highLevelClient()::msearchAsync);
            doc6.setJsonEntity("{\"id\":6, \"field\":\"value2\"}");  
        searchRequest1.source().highlighter(new HighlightBuilder().field("field"));  
        client().performRequest(new Request(HttpPost.METHOD_NAME, "/test/_refresh"));  
        assertEquals(2, bucket2.getDocCount());
        assertEquals(1, countResponse.getCount());  
            for (SearchHit hit : searchResponse.getHits()) {
            client().performRequest(doc1);
import org.opensearch.search.fetch.subphase.highlight.HighlightBuilder;
                SearchSourceBuilder.searchSource()  
                SearchSourceBuilder.searchSource()
        createIndex.setJsonEntity(
            assertThat(explainResponse.getExplanation().getValue(), equalTo(1.0f));  
                + "    \"mappings\": {\n"  
    }
            Range.Bucket bucket = rangeAggregation.getBuckets().get(1);
import java.math.BigInteger;  
            assertEquals(2, rangeAgg.getBuckets().size());  
import static org.hamcrest.Matchers.equalTo;
        assertThat(multiSearchResponse.getResponses().length, Matchers.equalTo(3));
        MultiSearchResponse multiSearchResponse = execute(multiSearchRequest, highLevelClient()::msearch, highLevelClient()::msearchAsync);
        assertEquals(5, searchResponse.getHits().getTotalHits().value());
            searchResponse = execute(searchRequest, highLevelClient()::search, highLevelClient()::searchAsync);
        client().performRequest(answerDoc2);
        assertThat(multiSearchResponse.getResponses()[2].getResponse().getHits().getTotalHits().value(), Matchers.equalTo(1L));
        searchRequest1.source().query(new TermsQueryBuilder("field", "value2"));
            assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(100L));
    }  
        }
        SearchIT.assertSearchHeader(multiSearchResponse.getResponses()[0].getResponse());
            assertEquals(2, children.getDocCount());
    public void testSearchWithMatrixStats() throws IOException {
        searchRequest1.source()  
        SearchIT.assertSearchHeader(multiSearchResponse.getResponses()[1].getResponse());
            .addRange("0--999", 0.0, 1000.0)
            );  
    public void testExplain() throws IOException {
        assertEquals(13, countResponse.getCount());
                    + "      \"add\" : {"
    public void testSearchTemplate() throws IOException {
            }
        assertThat(multiSearchResponse.getResponses()[0].isFailure(), Matchers.is(true));
            );
            countRequest.query(new MatchQueryBuilder("field", "value1"));
 * GitHub history for details.
            ExplainResponse explainResponse = execute(explainRequest, highLevelClient()::explain, highLevelClient()::explainAsync);
            assertThat(explainResponse.getGetResult().getFields().get("field1").getValue().toString(), equalTo("value1"));
        searchRequest.source(searchSourceBuilder);
        TermsAggregationBuilder leafTermAgg = new TermsAggregationBuilder("top-names").userValueTypeHint(ValueType.STRING)
            assertEquals(2, explainResponse.getGetResult().getSource().size());
            }
            "{\n"
    }  
        {
        client().performRequest(new Request("POST", "/test/_refresh"));  
        assertNull(searchResponse.getSuggest());  
        searchTemplateRequest.setScriptType(ScriptType.INLINE);  
        assertThat(multiSearchResponse.getResponses()[1].getResponse().getHits().getHits().length, Matchers.equalTo(0));  
                assertThat(option.getScore(), greaterThan(0f));
import org.opensearch.search.suggest.SuggestBuilder;
            SearchHit searchHit = searchResponse.getHits().getAt(0);  
        assertThat(countResponse.getTotalShards(), greaterThan(0));
        }
        assertEqualsOnDouble(1.3517561983471071, matrixStats.getKurtosis("num2"));
                .field("num", 10)  
        client().performRequest(doc);
                    + "        \"type\":  \"date\""  
            SearchHit searchHit = searchResponse.getHits().getAt(0);  
        {
        searchTemplateRequest.setScriptParams(Collections.emptyMap());
        assertEquals(Float.NaN, searchResponse.getHits().getMaxScore(), 0f);  
import static org.hamcrest.Matchers.both;
                .weight(new MultiValuesSourceFieldConfig.Builder().setFieldName("num2").build())
        countRequest.source(new SearchSourceBuilder().query(new MatchQueryBuilder("num", 10)));  
            assertNotNull(values);
        scriptParams.put("number", 10);  
        }  
        assertThat(multiSearchResponse.getResponses()[2].isFailure(), Matchers.is(false));
        assertThat(multiSearchResponse.getResponses()[1].getResponse().getHits().getTotalHits().value(), Matchers.equalTo(1L));
            assertThat(explainResponse.getIndex(), equalTo("index1"));
            SearchRequest searchRequest = new SearchRequest("test").source(  
import org.joda.time.DateTimeZone;
        assertEquals(Float.NaN, searchResponse.getHits().getMaxScore(), 0f);
            client().performRequest(doc3);
        assertThat(searchResponse.getHits().getAt(1).getSortValues()[0], equalTo(new BigInteger("18446744073709551610")));
    public void testSearchWithParentJoin() throws IOException {
            assertEquals(10.0, ((HashMap) values.get(0)).get("lat"));  
        Terms.Bucket bucket2 = termsAgg.getBucketByKey("tom|10223372036854775807");  
        RangeAggregationBuilder rangeAgg = new RangeAggregationBuilder("number_events").field("distribution.number_events")  
    }  
        );  
                OpenSearchStatusException.class,
                () -> execute(scrollRequest, highLevelClient()::scroll, highLevelClient()::scrollAsync)
        assertEquals(2, termsAgg.getBuckets().size());
        SearchRequest searchRequest = new SearchRequest().indices(indexName);  
 */
            new RangeAggregationBuilder("agg1").field("num").addRange("first", 0, 30).addRange("second", 31, 200)
    }  
 * this file be licensed under the Apache-2.0 license or a
            OpenSearchException rootCause = (OpenSearchException) exception.getRootCause();
        SearchIT.assertSearchHeader(multiSearchResponse.getResponses()[0].getResponse());  
            OpenSearchException.class,
        assertThat(terms.getBuckets().get(0).getKeyAsString(), Matchers.equalTo("value1"));  
                    .fetchField("result")
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder().size(35)
            assertEquals(2, leafTerms.getBuckets().size());  
import org.opensearch.search.fetch.subphase.FetchSourceContext;  
            client().performRequest(doc1);
        CountRequest countRequest = new CountRequest();
            assertNotNull(searchHit.getSourceAsMap());  
                    + "        \"store\":  true"  
                    + "    }"  
                Range.Bucket bucket = rangeAgg.getBuckets().get(0);  
            doc1.setJsonEntity("{\"id\":1, \"field\":\"value1\", \"rating\": 7}");
        multiSearchRequest.add(searchRequest2);  
        searchSourceBuilder.size(0);  
            assertTrue(explainResponse.hasExplanation());  
import org.opensearch.index.query.GeoShapeQueryBuilder;
            doc1.setJsonEntity("{\"id\":1, \"field1\":\"value1\", \"field2\":\"value2\"}");  
            assertThat(values.get(0), instanceOf(Map.class));
        Terms terms = searchResponse.getAggregations().get("top-tags");
                    .derivedField("result", "double", new Script("emit(Double.MAX_VALUE)"))
        assertThat(multiSearchResponse.getResponses()[1].getResponse().getHits().getAt(0).getId(), Matchers.equalTo("4"));
import org.opensearch.action.search.ClearScrollRequest;
import org.opensearch.index.query.TermsQueryBuilder;
        Request createIndex = new Request(HttpPut.METHOD_NAME, "/" + indexName);
            );  
            pitIds.add(pitResponse.getId());
import org.opensearch.common.geo.ShapeRelation;
        CountRequest countRequest = new CountRequest("index");
            true,
    }  
            client().performRequest(doc1);
    }
        assertThat(multiSearchResponse.getResponses()[1].getResponse().getHits().getAt(0).getId(), Matchers.equalTo("3"));
                + "    \"body\": \"<p>Unfortunately you're pretty much limited to FTP...\",\n"
        SearchRequest searchRequest = new SearchRequest("index");
            assertThat(explainResponse.getGetResult().getFields().keySet(), equalTo(Collections.singleton("field1")));  
        try {  
            assertNull(explainResponse.getGetResult());  
public class SearchIT extends OpenSearchRestHighLevelClientTestCase {
        // IP field  
        assertEqualsOnDouble(-0.9876336291667923, matrixStats.getCorrelation("num", "num2"));  
                + "                \"type\" : \"keyword\"\n"  
        assertThat(multiSearchResponse.getResponses()[2].getResponse().getHits().getTotalHits().value(), Matchers.equalTo(2L));  
        assertEqualsOnDouble(-0.13568039346585542, matrixStats.getSkewness("num2"));  
        assertEqualsOnDouble(330d, matrixStats.getVariance("num2"));
            null,  
import static org.hamcrest.Matchers.instanceOf;
        {  
        assertNull(searchResponse.getSuggest());
                + "        \"windows-server-2008\",\n"
        SearchTemplateResponse searchTemplateResponse = execute(  
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
                SearchSourceBuilder.searchSource().scriptField("result", new Script("null"))
        // We are not testing the full functionality here
        OpenSearchStatusException exception = expectThrows(  
        for (SearchHit searchHit : searchResponse.getHits().getHits()) {
        }
                + "}"  
        assertThat(  
            doc1.setJsonEntity("{\"date_created\":\"2024\", \"distribution\":{\"number_events\": 1000000}}");  
                    + "  \"mappings\": {"
                + "}"
        }
import org.opensearch.search.aggregations.support.MultiValuesSourceFieldConfig;
            client().performRequest(create);
import org.opensearch.search.aggregations.bucket.composite.CompositeValuesSourceBuilder;  
                exception.getDetailedMessage(),
        assertEquals(3, searchResponse.getHits().getTotalHits().value());  
                Range.Bucket bucket = rangeAgg.getBuckets().get(1);
        {  
            client().performRequest(doc3);
        assertThat(multiSearchResponse.getResponses()[0].getFailure(), Matchers.nullValue());  
                "{"
        scriptParams.put("number", 10);
import org.opensearch.search.aggregations.matrix.stats.MatrixStats;  
                .startObject("query")
            ExplainRequest explainRequest = new ExplainRequest("index1", "999");  
    public void testCountMultipleIndicesNoQuery() throws IOException {
        assertEquals(1, goodResponse.getHits().getTotalHits().value());
            values = searchHit.getFields().get("result").getValues();
                    .fetchField("result")
        assertEquals(4, searchHit.getSourceAsMap().size());  
            searchSourceBuilder.aggregation(new RangeAggregationBuilder("agg1").field("num"));
                    + "      \"rating\": {"  
    }  
        }  
        assertEquals(1, termsAgg.getBuckets().size());
            SearchRequest searchRequest = new SearchRequest("test").source(  
                    .fetchField("result")
            SearchRequest searchRequest = new SearchRequest("test").source(
        assertEquals(2, responses.length);
                    + "  \"mappings\": {"
            assertEquals(0, bucket.getDocCount());
import org.apache.hc.client5.http.classic.methods.HttpPost;
        badRequest2.setScriptType(ScriptType.INLINE);
import org.opensearch.search.SearchHit;
    }
    public void testFieldCapsWithNonExistentFields() throws IOException {
        }  
            client().performRequest(doc1);  
                SearchSourceBuilder.searchSource()
        SearchResponse searchResponse = execute(searchRequest, highLevelClient()::search, highLevelClient()::searchAsync);  
        assertEquals("agg1", termsAgg.getName());  
        SearchResponse searchResponse = execute(searchRequest, highLevelClient()::search, highLevelClient()::searchAsync);  
import org.opensearch.core.xcontent.XContentBuilder;
        );
            ExplainResponse explainResponse = execute(explainRequest, highLevelClient()::explain, highLevelClient()::explainAsync);  
    }  
            for (SearchHit hit : searchResponse.getHits()) {  
        scriptParams.put("number", 10);
            searchHit = searchResponse.getHits().getAt(0);
            assertNull(explainResponse.getGetResult());  
        assertThat(multiSearchResponse.getResponses()[0].isFailure(), Matchers.is(false));
            ExplainResponse explainResponse = execute(explainRequest, highLevelClient()::explain, highLevelClient()::explainAsync);
                .startObject()  
            SearchHit searchHit = searchResponse.getHits().getAt(0);
import org.opensearch.action.search.CreatePitRequest;  
import org.opensearch.action.explain.ExplainRequest;
            null,
        assertEquals(-1L, searchHit.getVersion());
            assertEquals(1, values.size());  
            assertEquals("10.0.0.1", values.get(0));
            assertNotNull(values);
                + "            }\n"
            }  
        assertThat(response.getIndices(), arrayContaining("index1", "index2"));
            qb.relation(ShapeRelation.INTERSECTS);
        {  
        );
        try {
    }
            .aggregation(
            client().performRequest(doc3);
        searchRequest.source(searchSourceBuilder);
            assertTrue(explainResponse.isMatch());
    public void testSearchWithTermsAndRangeAgg() throws IOException {  
import org.opensearch.index.query.RangeQueryBuilder;
            // multi-valued
            );  
        searchSourceBuilder.size(0);
            );
        searchSourceBuilder.size(0);  
        );  
        assertThat(responses[1].getFailureMessage(), containsString("json_parse_exception"));  
        assertEquals(2, type2.getDocCount());
            assertTrue(explainResponse.hasExplanation());
                    .derivedField("result", "date", new Script("emit(" + date1.getMillis() + "L)"))
            ExplainRequest explainRequest = new ExplainRequest("index4", "1");
            explainRequest.query(QueryBuilders.matchAllQuery());
        assertEquals(5, countResponse.getCount());
        client().performRequest(createIndex);  
                    + "  ]"
            assertEquals(Long.MAX_VALUE, values.get(0));  
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();  
        assertEquals("agg1", rangeAgg.getName());
        assertThat(multiSearchResponse.getResponses().length, Matchers.equalTo(3));
            assertEquals(1, bucket.getAggregations().asList().size());
            client().performRequest(doc2);
        // Just testing DerivedField definition from SearchSourceBuilder derivedField()  
        searchTemplateRequest.setRequest(new SearchRequest("index"));
            );
                + "    \"mappings\": {\n"  
            assertThat(explainResponse.getGetResult().getSource().get("field1"), equalTo("value1"));  
        assertEquals(7, countResponse.getCount());  
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();  
            new String[] { "index2" },
        assertThat(searchResponse.getHits().getAt(1).getId(), Matchers.equalTo("1"));
            "field",
                assertEquals("first", bucket.getKeyAsString());
        }
        assertThat(searchResponse.getHits().getAt(1).getSortValues().length, equalTo(1));  
        SearchTemplateRequest badRequest2 = new SearchTemplateRequest();  
            assertTrue(clearScrollResponse.isSucceeded());
            ExplainRequest explainRequest = new ExplainRequest("index4", "1");  
            .aggregation(  
            long counter = 0;
                + "    },\n"  
        searchSourceBuilder.aggregation(
        );
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertToXContentEquivalent;
            Request doc1 = new Request(HttpPut.METHOD_NAME, "/" + indexName + "/_doc/1");  
            assertFalse(explainResponse.isMatch());
        FieldCapabilitiesRequest request = new FieldCapabilitiesRequest().indices("non-existent").fields("rating");
            assertEquals(1, values.size());
        SearchTemplateRequest badRequest = new SearchTemplateRequest();
            assertEquals(date2.toString(), values.get(1));  
        }  
                SearchSourceBuilder.searchSource().scriptField("result", new Script("new HashMap()"))  
                + "    \"title\": \"Whats the best way to file transfer my site from server to a newer one?\",\n"
        assertThat(terms.getBuckets().size(), Matchers.equalTo(2));
        assertEquals(0, type2.getAggregations().asList().size());
                    + "}"
                    .query(new RangeQueryBuilder("result").from(Double.MIN_VALUE).to(Double.MIN_VALUE + 1))
            true,  
                deletePitRequest,
        assertEquals("agg1", termsAgg.getName());  
        assertThat(multiSearchResponse.getResponses()[1].getResponse().getHits().getTotalHits().value(), Matchers.equalTo(2L));
        assertThat(multiSearchResponse.getResponses()[0].getResponse().getHits().getAt(0).getId(), Matchers.equalTo("2"));
        MultiSearchRequest multiSearchRequest = new MultiSearchRequest();  
                .endObject()  
                + "        \"properties\" : {\n"
import org.opensearch.search.sort.SortOrder;
            .pointInTimeBuilder(new PointInTimeBuilder(pitResponse.getId()));  
        assertEquals(1, searchResponse.getAggregations().asList().size());  
                    + "  }"
        {  
            Request doc2 = new Request(HttpPut.METHOD_NAME, "/index1/_doc/2");
                    .fetchField("result")
            assertTrue(explainResponse.getGetResult().isExists());
                + "        }\n"
                    .query(new RangeQueryBuilder("result").from(Long.MIN_VALUE).to(Long.MIN_VALUE + 1))  
            List<Object> values = searchHit.getFields().get("result").getValues();  
            Matchers.equalTo("<em>value2</em>")  
        SearchResponse searchResponse = execute(searchRequest, highLevelClient()::search, highLevelClient()::searchAsync);  
            new String[] { "index1" },
        assertEquals(1, type2.getAggregations().asList().size());  
        FieldCapabilitiesRequest request = new FieldCapabilitiesRequest().indices("index2").fields("nonexistent");  
        }
        assertThat(
        assertThat(multiSearchResponse.getResponses()[2].getFailure(), Matchers.nullValue());
        } finally {
import org.opensearch.search.aggregations.bucket.terms.MultiTermsAggregationBuilder;
                highLevelClient()::deletePitAsync
            assertTrue(searchHit.getSourceAsMap().containsKey("num"));
import java.util.concurrent.TimeUnit;
        SearchResponse goodResponse = responses[0].getResponse().getResponse();
 * specific language governing permissions and limitations
            Request doc3 = new Request(HttpPut.METHOD_NAME, "/index2/_doc/3");
            ExplainResponse explainResponse = execute(explainRequest, highLevelClient()::explain, highLevelClient()::explainAsync);  
            ExplainResponse explainResponse = execute(explainRequest, highLevelClient()::explain, highLevelClient()::explainAsync);
            ExplainRequest explainRequest = new ExplainRequest("index1", "1");  
                () -> execute(explainRequest, highLevelClient()::explain, highLevelClient()::explainAsync)
                .endObject()
                    .query(new TermsQueryBuilder("result", "value"))  
            assertTrue(deletePitResponse.getDeletePitResults().get(0).getPitId().equals(pitResponse.getId()));
        FieldCapabilities expectedKeywordCapabilities = new FieldCapabilities(
        final String indexName = "child_example";  
        searchTemplateRequest.setScript("{ \"query\": { \"match\": { \"num\": {{number}} } } }");  
        Terms terms = multiSearchResponse.getResponses()[0].getResponse().getAggregations().get("name");  
                + "        \"location\": \"Norfolk, United Kingdom\",\n"
        assertEquals(0, type2.getAggregations().asList().size());
        );
            client().performRequest(doc4);
        for (int i = 0; i < 100; i++) {
            assertNull(explainResponse.getGetResult());
        badRequest1.setScriptParams(scriptParams);  
            assertTrue(explainResponse.getGetResult().isSourceEmpty());
        assertEquals(Collections.emptyMap(), searchResponse.getProfileResults());
            doc5.setJsonEntity("{\"id\":5, \"field\":\"value1\"}");  
            "{\n"
        assertThat(searchResponse.getHits().getAt(0).getId(), Matchers.equalTo("2"));  
        assertEquals(0, bucket1.getAggregations().asList().size());  
                + "}"
            long counter = 0;
            SearchResponse searchResponse = execute(searchRequest, highLevelClient()::search, highLevelClient()::searchAsync);  
        assertEquals(0, searchResponse.getHits().getHits().length);
            XContentBuilder builder = jsonBuilder().startObject().field("field", i).endObject();  
            }
            doc3.setJsonEntity("{\"username\":\"john\"}");
        assertEquals(0, searchResponse.getFailedShards());  
        SearchResponse searchResponse = execute(searchRequest, highLevelClient()::search, highLevelClient()::searchAsync);
import org.apache.hc.client5.http.classic.methods.HttpPut;
    public void testSearchWithTermsAgg() throws IOException {
        TermsAggregationBuilder termsAgg = new TermsAggregationBuilder("top-tags").userValueTypeHint(ValueType.STRING)
        assertEquals(expectedLongCapabilities, ratingResponse.get("long"));  
            assertThat(Integer.valueOf(explainResponse.getId()), equalTo(1));
        SearchRequest searchRequest1 = new SearchRequest("index1");
        assertEquals(expected, actual, 1.0e-12);
        searchSourceBuilder.aggregation(new MatrixStatsAggregationBuilder("agg1").fields(Arrays.asList("num", "num2")));
            Request doc5 = new Request(HttpPut.METHOD_NAME, "/index3/_doc/5");
            client().performRequest(doc6);
        FieldCapabilities expectedLongCapabilities = new FieldCapabilities(
            new MultiTermsAggregationBuilder("agg1").terms(  
            searchResponse = execute(searchRequest, highLevelClient()::search, highLevelClient()::searchAsync);
        assertThat(multiSearchResponse.getResponses()[0].getFailure(), Matchers.nullValue());  
        assertThat(multiSearchResponse.getTook().millis(), Matchers.greaterThanOrEqualTo(0L));
import org.opensearch.action.search.DeletePitRequest;
        searchRequest2.source()
        searchRequest3.source().query(new TermsQueryBuilder("field", "value2"));
        goodRequest.setScript("{ \"query\": { \"match\": { \"num\": {{number}} } } }");  
            "{\n"  
        client().performRequest(doc);
        );
        );
        searchSourceBuilder.size(0);
        CountResponse countResponse = execute(countRequest, highLevelClient()::count, highLevelClient()::countAsync);  
            SearchResponse searchResponse = execute(searchRequest, highLevelClient()::search, highLevelClient()::searchAsync);  
        }
        assertEquals(0, searchResponse.getHits().getHits().length);
            assertEquals(1, values.size());  
            assertThat(Integer.valueOf(explainResponse.getId()), equalTo(1));
                    + "      }"
        }
            );
            .size(0)
            assertEquals(1, values.size());
                    .derivedField("result", "date", new Script("emit(" + date1.getMillis() + "L); " + "emit(" + date2.getMillis() + "L)"))
        SearchRequest searchRequest = new SearchRequest();  
        assertTrue(explainResponse.isExists());
        questionDoc.setJsonEntity(
            }
            searchTemplateRequest,
import org.opensearch.action.fieldcaps.FieldCapabilitiesRequest;
        assertNotNull(hit.getExplanation());
            );  
        assertThat(multiSearchResponse.getResponses()[0].getFailure(), Matchers.nullValue());
            assertEquals(2, values.size());  
        assertEquals("agg1", termsAgg.getName());
    public void testSearchWithWeirdScriptFields() throws Exception {
        assertSearchHeader(searchResponse);
    }
                + "        \"location\": \"Norfolk, United Kingdom\",\n"
        createIndex.setJsonEntity(
                    .query(new RangeQueryBuilder("result").from(Double.MAX_VALUE - 1).to(Double.MAX_VALUE))
        {  
            assertNull(values.get(0));
        client().performRequest(new Request(HttpPost.METHOD_NAME, "/test/_refresh"));
            assertEquals(2, rangeAgg.getBuckets().size());
        MultiSearchRequest multiSearchRequest = new MultiSearchRequest();
        assertNull(searchResponse.getSuggest());
            assertFalse(explainResponse.isExists());
                + "        }\n"
                new TermsAggregationBuilder("name").userValueTypeHint(ValueType.STRING).field("field.keyword").order(BucketOrder.key(true))
        assertThat(multiSearchResponse.getResponses()[1].isFailure(), Matchers.is(false));  
        assertEquals(0, searchResponse.getHits().getHits().length);  
import org.opensearch.join.aggregations.ChildrenAggregationBuilder;  
            );
    public void testExplainWithStoredFields() throws IOException {
        SearchRequest searchRequest = new SearchRequest("search_sort");  
            List<Object> values = searchHit.getFields().get("result").getValues();
            );
                SearchSourceBuilder.searchSource()  
                    + "    \"properties\": {"
        searchSourceBuilder.size(0);
        }
import org.opensearch.action.search.MultiSearchResponse;
        assertThat(multiSearchResponse.getResponses()[1].isFailure(), Matchers.is(false));
            () -> execute(searchTemplateRequest, highLevelClient()::searchTemplate, highLevelClient()::searchTemplateAsync)
        assertThat(terms.getBuckets().get(0).getKeyAsString(), Matchers.equalTo("value1"));
            searchHit = searchResponse.getHits().getAt(0);  
            client().performRequest(doc2);
                OpenSearchException.class,
    }
        assertEquals(Collections.emptyMap(), searchResponse.getProfileResults());
                + "        \"display_name\": \"Sam\",\n"
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
                + "            }\n"
                SearchSourceBuilder.searchSource()
    }  
                + "    \"mappings\": {\n"
        assertEquals(Float.NaN, searchResponse.getHits().getMaxScore(), 0f);
            assertTrue(explainResponse.isExists());
            assertThat(clearScrollResponse.getNumFreed(), greaterThan(0));
            assertThat(explainResponse.getIndex(), equalTo("index1"));
        searchSourceBuilder.aggregation(yearAgg).aggregation(rangeAgg);  
        assertEquals(5, searchResponse.getHits().getTotalHits().value());
            SearchRequest searchRequest = new SearchRequest("test").source(
            assertEquals(1, bucket.getDocCount());  
        Suggest.Suggestion<? extends Suggest.Suggestion.Entry<? extends Suggest.Suggestion.Entry.Option>> sugg = searchResponse.getSuggest()
                assertEquals("first", bucket.getKeyAsString());  
        searchSourceBuilder.size(0);  
            assertThat(  
            OpenSearchStatusException exception = expectThrows(  
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
 * Modifications Copyright OpenSearch Contributors. See
        assertEquals(1, bucket1.getDocCount());
    public void testSearchWithPit() throws Exception {
            SearchResponse searchResponse = execute(searchRequest, highLevelClient()::search, highLevelClient()::searchAsync);
        assertNull(searchResponse.getSuggest());  
            doc4.setJsonEntity("{\"type\":\"type2\", \"id\":4, \"num\":100, \"num2\":10}");
import org.opensearch.client.core.CountResponse;
        assertSearchHeader(searchResponse);
        goodRequest.setScriptParams(scriptParams);  
            multiSearchResponse.getResponses()[0].getResponse().getHits().getAt(0).getHighlightFields().get("field").fragments()[0]  
import java.util.Collections;  
        MultiSearchResponse multiSearchResponse = execute(multiSearchRequest, highLevelClient()::msearch, highLevelClient()::msearchAsync);
            highLevelClient()::searchTemplateAsync
        }
        assertThat(multiSearchResponse.getResponses()[0].isFailure(), Matchers.is(false));
                SearchSourceBuilder.searchSource()  
            assertTrue(explainResponse.isMatch());
        assertEquals("{terms=type1}", bucket1.getKeyAsString());
                    .fetchField("result")  
        }
        searchSourceBuilder.size(0);
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
            doc2.setJsonEntity("{\"username\":\"tom\", \"rating\": 10223372036854775807}");
                    + "        \"properties\": {"  
        assertEquals(Float.NaN, searchResponse.getHits().getMaxScore(), 0f);
                + "}"
            ExplainRequest explainRequest = new ExplainRequest("index1", "1");  
        multiSearchRequest.add(searchRequest2);  
        assertEquals(Float.NaN, searchResponse.getHits().getMaxScore(), 0f);
        MatrixStats matrixStats = searchResponse.getAggregations().get("agg1");  
        assertEquals(expectedTextCapabilities, fieldResponse.get("text"));
        } finally {  
            )
        agg.subAggregation(
        assertNull(searchResponse.getSuggest());
            "{\n"
            Request doc1 = new Request(HttpPut.METHOD_NAME, "/index4/_doc/1");
            countRequest.source(new SearchSourceBuilder().query(new MatchQueryBuilder("field", "value1")));  
            doc5.setJsonEntity("{\"type\":\"type2\", \"id\":5, \"num\":100, \"num2\":10}");
        assertEquals(1, searchResponse.getHits().getHits().length);
        searchRequest.source(searchSourceBuilder);  
        SearchResponse searchResponse = execute(searchRequest, highLevelClient()::search, highLevelClient()::searchAsync);
            }
        assertEquals(2, ratingResponse.size());  
    public void testSearchWithRareTermsAgg() throws IOException {
        );
 * SPDX-License-Identifier: Apache-2.0
    private static void assertCountHeader(CountResponse countResponse) {
            searchHit = searchResponse.getHits().getAt(0);
            highLevelClient()::searchTemplateAsync  
        assertEquals(0, countResponse.getSkippedShards());  
        {  
                    + "      }"  
        CountResponse countResponse = execute(countRequest, highLevelClient()::count, highLevelClient()::countAsync);  
            Request doc6 = new Request(HttpPut.METHOD_NAME, "/index3/_doc/6");
        assertEquals(2, compositeAgg.getBuckets().size());
        }  
    }
            assertTrue(explainResponse.getGetResult().isExists());
            Request create = new Request(HttpPut.METHOD_NAME, "/index5");  
        assertEquals(SearchResponse.Clusters.EMPTY, searchResponse.getClusters());
            assertEquals(2, leafTerms.getBuckets().size());
        assertThat(multiSearchResponse.getResponses()[2].getResponse().getHits().getTotalHits().value(), Matchers.equalTo(2L));
    public void testCountOneIndexNoQuery() throws IOException {
        assertThat(multiSearchResponse.getResponses()[0].isFailure(), Matchers.is(false));
            List<Object> values = searchHit.getFields().get("result").getValues();
            DeletePitRequest deletePitRequest = new DeletePitRequest(pitIds);  
            OpenSearchStatusException exception = expectThrows(
                SearchSourceBuilder.searchSource().derivedField("result", "ip", new Script("emit(\"10.0.0.1\")")).fetchField("result")  
        scriptParams.put("number", "BAD NUMBER");
            WeightedAvg weightedAvg = type2.getAggregations().get("subagg");
            );
                + "    }"  
            SearchResponse searchResponse = execute(searchRequest, highLevelClient()::search, highLevelClient()::searchAsync);
        Request questionDoc = new Request(HttpPut.METHOD_NAME, "/" + indexName + "/_doc/1");  
            WeightedAvg weightedAvg = type1.getAggregations().get("subagg");
import org.opensearch.search.aggregations.bucket.range.Range;
            true,  
            clearScrollRequest.addScrollId(searchResponse.getScrollId());
        assertThat(goodResponse.getHits().getMaxScore(), greaterThan(0f));
        assertCountHeader(countResponse);  
        SearchIT.assertSearchHeader(multiSearchResponse.getResponses()[1].getResponse());
    public void testSearchScroll() throws Exception {
    }  
                    + "    }"  
        assertEquals(1, searchResponse.getHits().getTotalHits().value());  
        assertEquals(Collections.emptyMap(), searchResponse.getProfileResults());
                    + "}"
            Request doc4 = new Request(HttpPut.METHOD_NAME, "/index2/_doc/4");
        {
            () -> execute(request, highLevelClient()::fieldCaps, highLevelClient()::fieldCapsAsync)
        assertThat(multiSearchResponse.getResponses()[2].getFailure(), Matchers.nullValue());  
            assertThat(searchResponse.getHits().getHits().length, equalTo(30));
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;  
                    .query(new RangeQueryBuilder("result").from(Long.MAX_VALUE - 1).to(Long.MAX_VALUE))  
        }
            "{\n"
            assertEquals(20.0, ((HashMap) values.get(1)).get("lat"));  
            ExplainResponse explainResponse = execute(explainRequest, highLevelClient()::explain, highLevelClient()::explainAsync);
            "keyword",
            .format("yyyy");
        assertThat(searchResponse.getHits().getAt(2).getSortValues()[0], equalTo(new BigInteger("18446744073709551615")));  
    public void testMultiSearchTemplateAllBad() throws Exception {  
        assertEquals(2, type2.getDocCount());
            Request doc2 = new Request(HttpPut.METHOD_NAME, "/index/_doc/2");
            .size(0)
            assertEquals(2, values.size());  
        multiSearchRequest.add(searchRequest2);  
        searchRequest.source(new SearchSourceBuilder().query(new MatchQueryBuilder("num", 10)));  
        CountRequest countRequest;
import org.opensearch.action.search.ClearScrollResponse;
        client().performRequest(answerDoc1);
        Terms termsAgg = searchResponse.getAggregations().get("agg1");
        {
            );
                    .query(new RangeQueryBuilder("result").from(date1.toString()).to(date2.toString()))
        assertSearchHeader(searchResponse);
        assertEquals(5, searchResponse.getHits().getTotalHits().value());  
        {
        assertEquals(Collections.emptyMap(), searchResponse.getProfileResults());  
            );
                    + "}"  
            assertTrue(explainResponse.isMatch());  
                assertThat(((Number) hit.getSortValues()[0]).longValue(), equalTo(counter++));
/*  
        }  
        SearchRequest searchRequest1 = new SearchRequest("index1");
            assertTrue(explainResponse.isExists());
        assertTrue(response.get().containsKey("field"));  
            client().performRequest(doc5);  
        searchRequest.source(searchSourceBuilder);
            DateTime date1 = new DateTime(1990, 12, 29, 0, 0, DateTimeZone.UTC);  
                () -> execute(searchRequest, highLevelClient()::search, highLevelClient()::searchAsync)
        client().performRequest(new Request("POST", "/test/_refresh"));
                    + "        \"type\":  \"keyword\""
                bucket.getKeyAsString(),
        assertEquals(1, searchResponse.getSuggest().size());
            for (Suggest.Suggestion.Entry.Option option : options) {
        multiSearchRequest.add(searchRequest1);  
 * compatible open source license.
        );
        {
        searchSourceBuilder.size(0);  
        assertSearchHeader(searchResponse);
                "{"
        {
        );
                highLevelClient()::clearScrollAsync
import org.opensearch.search.aggregations.bucket.terms.RareTerms;
        Map<String, Object> scriptParams = new HashMap<>();
import org.opensearch.search.aggregations.matrix.stats.MatrixStatsAggregationBuilder;
        Terms termsAgg = searchResponse.getAggregations().get("agg1");
        MultiSearchRequest multiSearchRequest = new MultiSearchRequest();  
            );  
        assertEquals("2024", yearHistogram.getBuckets().get(0).getKeyAsString());
                highLevelClient()::scrollAsync  
            assertEquals(20.0, ((HashMap) values.get(0)).get("lon"));
                .endObject()
        assertNull(searchResponse.getAggregations());
        client().performRequest(new Request(HttpPost.METHOD_NAME, "/_refresh"));
        assertEquals(2, type2.getDocCount());  
        SearchResponse searchResponse = execute(searchRequest, highLevelClient()::search, highLevelClient()::searchAsync);
        BytesReference actualSource = searchTemplateResponse.getSource();  
        CountResponse countResponse = execute(countRequest, highLevelClient()::count, highLevelClient()::countAsync);
        // Boolean field
            SearchHit searchHit = searchResponse.getHits().getAt(0);
            assertEquals("second", bucket.getKeyAsString());
import org.opensearch.action.search.SearchScrollRequest;
        for (int i = 0; i < 100; i++) {  
        assertThat(multiSearchResponse.getResponses()[1].getResponse().getHits().getTotalHits().value(), Matchers.equalTo(2L));
            .addRange("999--", 1000.0, 10_000_000_000_00L);
            assertEquals(1, values.size());
        searchRequest.source(searchSourceBuilder);
        searchRequest.source(searchSourceBuilder);  
        MultiSearchRequest multiSearchRequest = new MultiSearchRequest();
        );
        assertThat(multiSearchResponse.getResponses()[1].isFailure(), Matchers.is(false));  
            assertThat(rootCause.getMessage(), containsString("No search context found for"));  
            XContentBuilder builder = jsonBuilder().startObject().field("field", i).endObject();
        assertThat(terms.getBuckets().size(), Matchers.equalTo(2));
        assertEquals(2, rangeAggregation.getBuckets().size());  
        assertEquals("agg1", termsAgg.getName());
                + "        \"id\": 48\n"  
        SearchIT.assertSearchHeader(multiSearchResponse.getResponses()[2].getResponse());
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
    public void testExplainWithAliasFilter() throws IOException {
        Map<String, Object> scriptParams = new HashMap<>();
            ExplainRequest explainRequest = new ExplainRequest("index4", "1");
            assertNotNull(values);  
                    .fetchField("result")
        assertThat(multiSearchResponse.getResponses()[0].isFailure(), Matchers.is(false));
        // Long field
            List<Object> values = searchHit.getFields().get("result").getValues();  
        assertEquals(searchResponse.getTotalShards(), searchResponse.getSuccessfulShards());
                    .derivedField("result", "long", new Script("emit(Long.MAX_VALUE)"))
        SearchRequest searchRequest3 = new SearchRequest("index3");
        CompositeAggregation compositeAgg = searchResponse.getAggregations().get("composite");  
            assertNull(explainResponse.getGetResult());
            Collections.emptyMap()
        answerDoc1.setJsonEntity(
            assertThat(explainResponse.getExplanation().getDetails().length, equalTo(2));  
        assertEquals(0, searchResponse.getHits().getHits().length);
        );
import java.util.List;
        assertFalse(explainResponse.isMatch());
            assertEquals("value", values.get(0));
        assertTrue(response.get().containsKey("rating"));
        Terms.Bucket type2 = termsAgg.getBucketByKey("type2");
            assertThat(Integer.valueOf(searchHit.getId()), both(greaterThan(0)).and(lessThan(6)));  
            assertEquals(1, children.getAggregations().asList().size());
        assertThat(multiSearchResponse.getResponses()[1].getResponse().getHits().getTotalHits().value(), Matchers.equalTo(1L));  
            );
        assertThat(multiSearchResponse.getResponses()[2].getFailure(), Matchers.nullValue());
    public void testMultiSearchTemplate() throws Exception {  
        }
import org.opensearch.common.unit.TimeValue;  
        final String indexName = "search_sort";
        {
                + "    \"qa_join_field\" : \"question\"\n"
            SearchResponse searchResponse = execute(searchRequest, highLevelClient()::search, highLevelClient()::searchAsync);
        Request createIndex = new Request(HttpPut.METHOD_NAME, "/" + indexName);  
            assertEquals(Double.MIN_VALUE, values.get(1));
    @Before
        searchTemplateRequest.setScript("non-existent");  
        answerDoc1.addParameter("routing", "1");  
        // Setting simulate true causes the template to only be rendered.  
    }
        multiSearchTemplateRequest.add(badRequest1);
    }  
            assertEquals(Double.MAX_VALUE, values.get(0));
import org.opensearch.action.fieldcaps.FieldCapabilities;
        assertThat(multiSearchResponse.getResponses()[0].getFailure().getMessage(), containsString("search_phase_execution_exception"));  
                    + "        }"
            assertTrue(explainResponse.hasExplanation());
            null,
            );  
        SearchRequest searchRequest2 = new SearchRequest("index2");
        {  
            assertEquals("0--999", bucket.getKeyAsString());  
    public void testMultiSearch_withQuery() throws Exception {
            assertThat(explainResponse.getIndex(), equalTo("index1"));
    }
            doc3.setJsonEntity("{\"id\":3, \"field\":\"value1\", \"rating\": \"good\"}");  
import org.opensearch.OpenSearchStatusException;
                    .derivedField("result", "boolean", new Script("emit(((String)params._source[\"field\"]).equals(\"value\"))"))
            GeoShapeQueryBuilder qb = geoShapeQuery("result", new Rectangle(-35, 35, 35, -35));
        {
            assertEquals(date1.toString(), values.get(0));
            .calendarInterval(DateHistogramInterval.YEAR)  
                assertThat(option.getText().string(), either(equalTo("type1")).or(equalTo("type2")));  
        assertCountHeader(countResponse);
            searchRequest = new SearchRequest("test").source(
        assertEquals(Collections.emptyMap(), searchResponse.getProfileResults());
            ExplainResponse explainResponse = execute(explainRequest, highLevelClient()::explain, highLevelClient()::explainAsync);
            values = searchHit.getFields().get("result").getValues();
        }
            values = searchHit.getFields().get("result").getValues();
        {
                + "                \"type\" : \"unsigned_long\"\n"  
            // multi-valued  
            Request doc = new Request(HttpPut.METHOD_NAME, "/test/_doc/" + Integer.toString(i));
        SearchResponse searchResponse = searchTemplateResponse.getResponse();  
        RareTerms.Bucket type2 = termsAgg.getBucketByKey("type2");  
import java.io.IOException;
        goodRequest.setRequest(new SearchRequest("index"));
        assertEquals(5, matrixStats.getFieldCount("num"));
            assertEquals(true, values.get(0));
        client().performRequest(createIndex);
        CompositeAggregation.Bucket bucket2 = compositeAgg.getBuckets().get(1);
            Range rangeAgg = type1.getAggregations().get("subagg");  
 * KIND, either express or implied.  See the License for the
        SearchRequest searchRequest1 = new SearchRequest("index1");
        }
            create.setJsonEntity(
            );
        );  
            assertThat(explainResponse.getExplanation().getValue().floatValue(), greaterThan(0.0f));
    public void indexDocuments() throws IOException {
        assertEquals(0, searchResponse.getHits().getTotalHits().value());
import org.opensearch.action.fieldcaps.FieldCapabilitiesResponse;  
    public void testSearchWithCompositeAgg() throws IOException {
        assertThat(searchHit.getScore(), greaterThan(0f));  
        assertEquals(Float.NaN, searchResponse.getHits().getMaxScore(), 0f);
            );  
        BytesReference expectedSource = BytesReference.bytes(
        terms = multiSearchResponse.getResponses()[2].getResponse().getAggregations().get("name");
        assertNull(searchResponse.getSuggest());
    public void testCountMultipleIndicesMatchQueryUsingConstructor() throws IOException {  
    }
        assertThat(terms.getBuckets().get(0).getKeyAsString(), Matchers.equalTo("value1"));
        assertEquals(3, countResponse.getCount());  
        assertEquals(Collections.emptyMap(), searchResponse.getProfileResults());  
        CountResponse countResponse = execute(countRequest, highLevelClient()::count, highLevelClient()::countAsync);
        SearchHit searchHit = searchResponse.getHits().getHits()[0];  
import org.opensearch.search.builder.SearchSourceBuilder;
            null,  
import static org.opensearch.index.query.QueryBuilders.geoShapeQuery;
            explainRequest.query(QueryBuilders.matchAllQuery());
            highLevelClient()::searchTemplate,
            assertEquals(4, options.getLength());
        searchTemplateRequest.setScriptParams(scriptParams);
            "rating",  
        assertEquals("type1", searchHit.getSourceAsMap().get("type"));
        FieldCapabilities expectedTextCapabilities = new FieldCapabilities(
        assertThat(multiSearchResponse.getResponses()[2].getFailure(), Matchers.nullValue());  
            assertEquals(2, values.size());
        }
        assertTrue(response.get().isEmpty());  
        SearchIT.assertSearchHeader(multiSearchResponse.getResponses()[1].getResponse());  
        badRequest1.setRequest(new SearchRequest("index"));
            {
        assertThat(multiSearchResponse.getResponses()[0].getFailure(), Matchers.nullValue());
            assertNotNull(values);  
        assertNotNull(responses[1].getFailureMessage());
import org.opensearch.index.query.ScriptQueryBuilder;  
        assertEqualsOnDouble(1830.0000000000002, matrixStats.getVariance("num"));  
            List<Object> values = searchHit.getFields().get("result").getValues();
        FieldCapabilitiesResponse response = execute(request, highLevelClient()::fieldCaps, highLevelClient()::fieldCapsAsync);
        assertThat(searchResponse.getTook().nanos(), greaterThanOrEqualTo(0L));
        {  
        MultiSearchTemplateRequest multiSearchTemplateRequest = new MultiSearchTemplateRequest();
            SearchHit searchHit = searchResponse.getHits().getAt(0);
        createIndex.setJsonEntity(
        assertSearchHeader(searchResponse);
        multiSearchRequest.add(searchRequest1);
        assertEquals(0, countResponse.getFailedShards());
                    + "  \"mappings\": {"  
            assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(100L));  
        for (Terms.Bucket bucket : terms.getBuckets()) {
            SearchRequest searchRequest = new SearchRequest("test").source(  
        searchTemplateRequest.setExplain(true);
        assertThat(multiSearchResponse.getResponses()[1].getFailure(), Matchers.nullValue());
            );
        assertThat(terms.getBuckets().size(), Matchers.equalTo(2));  
            true,
            assertEquals(0, map.size());  
        assertThat(searchResponse.getTook().millis(), Matchers.greaterThanOrEqualTo(0L));
        assertNull(searchTemplateResponse.getResponse());
        assertEquals(countResponse.getTotalShards(), countResponse.getSuccessfulShards());  
        searchSourceBuilder.aggregation(agg);  
            for (SearchHit hit : searchResponse.getHits()) {
            .field("owner.display_name.keyword")
        assertThat(multiSearchResponse.getResponses()[2].getResponse().getHits().getHits().length, Matchers.equalTo(0));
                + "                \"relations\" : { \"question\" : \"answer\" }\n"
        );  
        multiSearchRequest.add(searchRequest3);
            assertEquals(4, searchHit.getSourceAsMap().size());
        {
            assertTrue(explainResponse.hasExplanation());
        assertToXContentEquivalent(expectedSource, actualSource, MediaTypeRegistry.JSON);  
    }
        CreatePitRequest pitRequest = new CreatePitRequest(new TimeValue(1, TimeUnit.DAYS), true, "test");
            // multi-valued
            assertThat(  
        assertNull(searchResponse.getSuggest());  
        SearchResponse searchResponse = execute(searchRequest, highLevelClient()::search, highLevelClient()::searchAsync);
        assertNull(searchResponse.getSuggest());
        assertThat(searchResponse.getHits().getMaxScore(), greaterThan(0f));
        assertCountHeader(countResponse);
        );
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
            // multi valued  
            assertEquals("value_2", values.get(1));
        multiSearchTemplateRequest.add(goodRequest);  
        assertEquals(50, searchHit.getSourceAsMap().get("num2"));
        SearchResponse searchResponse = execute(searchRequest, highLevelClient()::search, highLevelClient()::searchAsync);
            searchRequest = new SearchRequest("test").source(
            doc.setJsonEntity(builder.toString());
            "text",  
        assertThat(multiSearchResponse.getResponses()[0].getResponse().getHits().getTotalHits().value(), Matchers.equalTo(1L));
            assertEquals("999--", bucket.getKeyAsString());
    public void testMultiSearch_withAgg() throws Exception {  
            assertEquals(3, bucket.getDocCount());
    }  
                assertEquals(1, bucket.getDocCount());
        SearchTemplateRequest searchTemplateRequest = new SearchTemplateRequest();  
        SearchIT.assertSearchHeader(multiSearchResponse.getResponses()[0].getResponse());
            searchRequest.source(searchSourceBuilder);
                + "        \"file-transfer\"\n"
    }
                    + "            \"type\":  \"unsigned_long\""
            List<Object> values = searchHit.getFields().get("result").getValues();
        SearchIT.assertSearchHeader(multiSearchResponse.getResponses()[2].getResponse());
        assertEquals(0, bucket2.getAggregations().asList().size());
        assertThat(multiSearchResponse.getResponses().length, Matchers.equalTo(3));
import static org.hamcrest.Matchers.either;  
            highLevelClient()::searchTemplate,  
    public void testSearchWithMultiTermsAgg() throws IOException {
            explainRequest.query(QueryBuilders.matchAllQuery());
        assertThat(searchResponse.getHits().getTotalHits().value(), Matchers.equalTo(3L));
            ExplainResponse explainResponse = execute(explainRequest, highLevelClient()::explain, highLevelClient()::explainAsync);  
    }
        assertThat(responses[1].isFailure(), Matchers.is(true));
        assertThat(multiSearchResponse.getResponses()[0].getResponse().getHits().getTotalHits().value(), Matchers.equalTo(2L));
            doc1.setJsonEntity("{\"username\":\"bob\", \"rating\": 18446744073709551615}");
                assertEquals(2, bucket.getDocCount());  
                "{"  
            assertNotNull(values);  
            SearchScrollRequest scrollRequest = new SearchScrollRequest(searchResponse.getScrollId()).scroll(TimeValue.timeValueMinutes(2));
    }
        assertSearchHeader(searchResponse);
import org.opensearch.common.xcontent.XContentFactory;
                    + "      \"distribution\": {"
            assertTrue(explainResponse.getGetResult().isExists());  
import org.opensearch.search.aggregations.support.ValueType;  
            Range.Bucket bucket = rangeAgg.getBuckets().get(1);  
        Terms.Bucket type2 = termsAgg.getBucketByKey("type2");
        assertEquals(0, bucket2.getAggregations().asList().size());
            SearchRequest searchRequest = new SearchRequest("test").source(
        assertEquals(3, type1.getDocCount());  
                    .query(qb)  
            explainRequest.query(QueryBuilders.matchQuery("field", "value1"));
                SearchSourceBuilder.searchSource()
            assertEquals(30.0, ((HashMap) values.get(1)).get("lon"));
            SearchResponse searchResponse = execute(searchRequest, highLevelClient()::search, highLevelClient()::searchAsync);
            assertTrue(explainResponse.getGetResult().isExists());
        assertSearchHeader(searchResponse);
        SearchRequest searchRequest3 = new SearchRequest("index3");
        SearchResponse searchResponse = execute(searchRequest, highLevelClient()::search, highLevelClient()::searchAsync);  
 * license agreements. See the NOTICE file distributed with
    }  
        {  
                + "    \"tags\": [\n"
            Request doc1 = new Request(HttpPut.METHOD_NAME, "/index1/_doc/1");
                assertEquals(counter++, ((Number) hit.getSortValues()[0]).longValue());  
import org.opensearch.client.core.CountRequest;  
            .size(10)
 * You may obtain a copy of the License at  
                    .derivedField("result", "keyword", new Script("emit(params._source[\"field\"])"))
        SearchResponse searchResponse = execute(searchRequest, highLevelClient()::search, highLevelClient()::searchAsync);
    private static void assertSearchHeader(SearchResponse searchResponse) {
                    + "          }"  
        }  
            OpenSearchStatusException.class,  
            List<?> list = (List<?>) values.get(0);  
        searchRequest.source(searchSourceBuilder);
            OpenSearchException exception = expectThrows(  
            SearchHit searchHit = searchResponse.getHits().getAt(0);
                QueryBuilders.boolQuery().must(QueryBuilders.termQuery("field", "value1")).must(QueryBuilders.termQuery("field", "value2"))
            doc4.setJsonEntity("{\"id\":4, \"field\":\"value2\"}");  
            assertEquals(2, options.getOptions().size());  
            Request doc2 = new Request(HttpPut.METHOD_NAME, "/" + indexName + "/_doc/2");  
            explainRequest.storedFields(new String[] { "field1" });  
import org.opensearch.search.aggregations.bucket.composite.TermsValuesSourceBuilder;
                    + "        \"type\":  \"keyword\","
        SearchResponse searchResponse = execute(searchRequest, highLevelClient()::search, highLevelClient()::searchAsync);
        FieldCapabilitiesRequest request = new FieldCapabilitiesRequest().indices("index1", "index2").fields("rating", "field");  
        assertEquals("composite", compositeAgg.getName());
                    + "    }"
            assertThat(searchResponse.getHits().getHits().length, equalTo(35));
            doc2.setJsonEntity("{\"username\":\"tom\", \"rating\": 10223372036854775807}");
            client().performRequest(doc2);  
    public void testFieldCaps() throws IOException {
            assertEquals(2, bucket.getDocCount());  
            assertFalse(explainResponse.isMatch());
            assertEquals(Long.MAX_VALUE, values.get(0));  
            assertNotNull(values);
            assertEquals("index", searchHit.getIndex());
        Request createIndex = new Request(HttpPut.METHOD_NAME, "/" + indexName);  
        searchTemplateRequest.setProfile(true);
            assertThat(explainResponse.getExplanation().getValue(), equalTo(1.0f));
            assertEquals(24.4, weightedAvg.getValue(), 0f);
            assertEquals("10.0.0.2", values.get(1));
        // Check the capabilities for the 'rating' field.  
            );  
            assertEquals(0, options.getOffset());
    }
            Request doc1 = new Request(HttpPut.METHOD_NAME, "/" + indexName + "/_doc/1");  
        }
        RareTerms termsAgg = searchResponse.getAggregations().get("agg1");  
        assertNotNull(goodResponse);  
import org.opensearch.search.aggregations.support.MultiTermsValuesSourceConfig;
        multiSearchRequest.add(searchRequest1);
        Map<String, Object> scriptParams = new HashMap<>();  
        assertCountHeader(countResponse);
            SearchResponse searchResponse = execute(searchRequest, highLevelClient()::search, highLevelClient()::searchAsync);  
                + "}"
 * The OpenSearch Contributors require contributions made to  
        Terms.Bucket bucket1 = termsAgg.getBucketByKey("bob|18446744073709551615");  
        assertEquals(5, matrixStats.getFieldCount("num2"));  
        assertThat(multiSearchResponse.getResponses()[2].getResponse().getHits().getAt(0).getId(), Matchers.equalTo("6"));
            assertThat(searchResponse.getHits().getHits().length, equalTo(35));
        assertEquals(0, searchResponse.getHits().getHits().length);
    }  
            searchHit = searchResponse.getHits().getAt(0);  
import org.opensearch.search.aggregations.bucket.terms.RareTermsAggregationBuilder;  
            assertThat(Integer.valueOf(explainResponse.getId()), equalTo(1));  
            doc1.setJsonEntity("{\"username\":\"bob\", \"rating\": 18446744073709551610}");
        client().performRequest(createIndex);  
        assertEquals(0, searchResponse.getHits().getHits().length);  
        terms = multiSearchResponse.getResponses()[1].getResponse().getAggregations().get("name");
            assertThat(explainResponse.getGetResult().getFields().get("field2").getValue().toString(), equalTo("value2"));  
                + "    },\n"  
    }  
import org.opensearch.search.aggregations.bucket.range.RangeAggregationBuilder;  
    public void testSearchWithDerivedFields() throws Exception {
                assertEquals(counter++, ((Number) hit.getSortValues()[0]).longValue());  
            assertEquals(1, values.size());
        searchRequest1.source().sort("id", SortOrder.ASC);
        assertNull(searchResponse.getSuggest());
        Request doc = new Request("PUT", "/test/_doc/1");
import org.opensearch.script.mustache.MultiSearchTemplateResponse;
        searchRequest.indices("index");
        {
        assertEquals("agg1", termsAgg.getName());
                + "        \"parent\" : \"1\"\n"
            }
            SearchRequest searchRequest = new SearchRequest("test").source(  
        SearchTemplateRequest badRequest1 = new SearchTemplateRequest();  
        SearchRequest searchRequest = new SearchRequest("index5");  
        Terms.Bucket type1 = termsAgg.getBucketByKey("type1");
        {
import org.opensearch.search.aggregations.bucket.histogram.DateHistogramAggregationBuilder;
        assertEquals(0, terms.getSumOfOtherDocCounts());  
    }
 */  
            assertNotNull(values);
            client().performRequest(doc4);  
                OpenSearchStatusException.class,  
            searchResponse = execute(searchRequest, highLevelClient()::search, highLevelClient()::searchAsync);  
    }  
        client().performRequest(new Request(HttpPost.METHOD_NAME, "/_refresh"));
                    .derivedField("result", "double", new Script("emit(Double.MAX_VALUE); emit(Double.MIN_VALUE);"))  
            values = searchHit.getFields().get("result").getValues();
        searchRequest2.source().highlighter(new HighlightBuilder().field("field"));
            Children children = bucket.getAggregations().get("to-answers");  
        {
            explainRequest.query(QueryBuilders.termQuery("field", "value1"));
        multiSearchRequest.add(searchRequest3);  
        assertThat(searchResponse.getTotalShards(), greaterThan(0));
            );  
                    + "          \"number_events\": {"
        SearchRequest searchRequest = new SearchRequest("index");
                    + "        \"type\":  \"keyword\","  
            Request doc3 = new Request(HttpPut.METHOD_NAME, "/" + indexName + "/_doc/3");  
        assertThat(multiSearchResponse.getResponses()[1].getResponse().getHits().getAt(0).getId(), Matchers.equalTo("4"));  
            searchResponse = execute(searchRequest, highLevelClient()::search, highLevelClient()::searchAsync);
        // Geo field
        assertThat(multiSearchResponse.getResponses()[0].getResponse().getHits().getAt(1).getId(), Matchers.equalTo("2"));
import org.opensearch.core.rest.RestStatus;  
        }  
        assertThat(multiSearchResponse.getResponses()[1].getFailure(), Matchers.nullValue());  
        searchTemplateRequest.setScriptParams(scriptParams);
            assertSearchHeader(searchResponse);  
        assertEquals(0, countResponse.getShardFailures().length);
                new TermsAggregationBuilder("name").userValueTypeHint(ValueType.STRING).field("field.keyword").order(BucketOrder.key(true))  
        assertEquals(1, type2.getAggregations().asList().size());  
        scriptParams = new HashMap<>();  
            assertTrue(explainResponse.hasExplanation());
            assertEquals(10.0, ((HashMap) values.get(0)).get("lat"));
            assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(100L));  
            doc1.setJsonEntity("{\"type\":\"type1\", \"id\":1, \"num\":10, \"num2\":50}");
        multiSearchRequest.add(searchRequest1);  
            searchResponse = execute(  
    public void testCountAllIndicesNoQuery() throws IOException {  
        Range rangeAgg = searchResponse.getAggregations().get("agg1");  
                    .query(new TermsQueryBuilder("result", "value_2"))
 * not use this file except in compliance with the License.
                assertThat(((Number) hit.getSortValues()[0]).longValue(), equalTo(counter++));  
        Range rangeAggregation = searchResponse.getAggregations().get("number_events");
                + "    }"  
            explainRequest.query(
        assertThat(multiSearchResponse.getTook().millis(), Matchers.greaterThanOrEqualTo(0L));  
import org.opensearch.search.aggregations.bucket.terms.TermsAggregationBuilder;
            doc.setJsonEntity(builder.toString());  
            assertTrue(searchHit.getSourceAsMap().containsKey("num2"));  
            }
        }
        CountRequest countRequest = new CountRequest("index");
        {
        assertEquals(expectedKeywordCapabilities, ratingResponse.get("keyword"));  
            Collections.emptyMap()
            createFilteredAlias.setJsonEntity(
            Request doc3 = new Request(HttpPut.METHOD_NAME, "/index/_doc/3");
        SearchIT.assertSearchHeader(multiSearchResponse.getResponses()[2].getResponse());  
                + "    \"owner\": {\n"  
        assertEquals("index", searchHit.getIndex());
        assertEquals(3, type1.getDocCount());
            ExplainRequest explainRequest = new ExplainRequest("index1", "1");
            assertNotNull(values);
            explainRequest.storedFields(new String[] { "field1", "field2" });
            assertThat(explainResponse.getGetResult().getFields().keySet().size(), equalTo(2));
            );
import org.opensearch.OpenSearchException;  
        assertFalse(goodResponse.getProfileResults().isEmpty());
    }
import org.opensearch.search.suggest.phrase.PhraseSuggestionBuilder;
                + "            \"qa_join_field\" : {\n"  
        // Check the capabilities for the 'field' field.
            false,
        SearchTemplateRequest searchTemplateRequest = new SearchTemplateRequest();  
            true,
            () -> execute(multiSearchTemplateRequest, highLevelClient()::msearchTemplate, highLevelClient()::msearchTemplateAsync)
        assertEquals(1, yearHistogram.getBuckets().size());  
        agg.subAggregation(new RangeAggregationBuilder("subagg").field("num").addRange("first", 0, 30).addRange("second", 31, 200));
        assertSearchHeader(searchResponse);
        SearchTemplateRequest goodRequest = new SearchTemplateRequest();  
