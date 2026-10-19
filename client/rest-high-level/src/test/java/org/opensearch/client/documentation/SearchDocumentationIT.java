        }
            // end::clear-scroll-request
                    .field("company.keyword");
        // tag::explain-execute-async  
        assertSame(RestStatus.OK, bulkResponse.status());
                Terms companyAggregation = (Terms) aggregationMap.get("by_company");
    }  
            ActionListener<MultiSearchResponse> listener = new ActionListener<MultiSearchResponse>() {  
        }  
            TotalHits.Relation relation = totalHits.relation();
        {
                .endObject()
            CountRequest countRequest = new CountRequest(); // <1>
            // Replace the empty listener by a blocking listener in test  
    private void indexSearchTestData() throws IOException {
        };  
import org.opensearch.index.query.QueryBuilders;  
                // <1>
                    public void onFailure(Exception e) {
    @SuppressWarnings("unused")
            listener = new LatchedActionListener<>(listener, latch);  
            MultiSearchResponse response = client.msearch(request, RequestOptions.DEFAULT);
        assertTrue(latch.await(30L, TimeUnit.SECONDS));
            request.add(new IndexRequest("posts").id("1").source(MediaTypeRegistry.JSON, "company", "OpenSearch", "age", 20));  
import org.opensearch.search.aggregations.bucket.range.Range;
                .source(  
                        "title",  
import org.opensearch.search.fetch.subphase.FetchSourceContext;
            "}");
        SearchTemplateRequest request = new SearchTemplateRequest();
            @Override
            sourceBuilder.query(QueryBuilders.termQuery("user", "foobar")); // <2>
            int failedShards = countResponse.getFailedShards();
import java.util.concurrent.CountDownLatch;
 * You may obtain a copy of the License at  
                }  
import org.opensearch.action.support.IndicesOptions;  
 * under the License.  
        // tag::search-template-request-inline  
                // <1>
        );
import org.opensearch.index.rankeval.MetricDetail;  
        RestHighLevelClient client = highLevelClient();
        // tag::search-template-execute-async
            assertTrue(clearScrollLatch.await(30L, TimeUnit.SECONDS));
            HighlightBuilder highlightBuilder = new HighlightBuilder(); // <1>
import org.opensearch.script.mustache.MultiSearchTemplateRequest;  
        assertNotNull(explanation);  
            double evaluationResult = response.getMetricScore();   // <1>
            // end::search-hits-get
                public void onFailure(Exception e) {  
        };  
                assertEquals(3, elasticBucket.getDocCount());  
            }  
            for (QueryProfileShardResult queryProfileResult : queryProfileShardResults) { // <2>  
        }
                .startObject("id")
        FieldCapabilities textCapabilities = userResponse.get("keyword");  
                QueryBuilders.boolQuery().should(matchQuery("title", "OpenSearch")).should(matchQuery("user", "foobar"))  
            final CountDownLatch clearScrollLatch = new CountDownLatch(1);
                    )  
            SearchRequest searchRequest = new SearchRequest(); // <1>
            new IndexRequest("blog").id("3")
 */  
        bulkRequest.add(  
            // tag::multi-search-execute  
            // tag::multi-search-execute-async
            assertThat(aggsProfileResults.getProfileResults().size(), equalTo(1));
            ratedDocs.add(new RatedDocument("posts", "1", 1));            // <2>  
import org.apache.lucene.search.Explanation;
        for (Item item : multiResponse.getResponses()) { // <1>
            }
    public void testSearchTemplateWithInlineScript() throws Exception {
                        "In which order are my OpenSearch queries executed?",
import org.opensearch.index.rankeval.EvalQueryQuality;
                    "user",  
                .startObject()  
                // <1>
        // tag::search-template-request-stored
        assertEquals(RestStatus.OK.getStatus(), scriptResponse.getStatusLine().getStatusCode());
 * Modifications Copyright OpenSearch Contributors. See
        listener = new LatchedActionListener<>(listener, latch);
                public void onFailure(Exception e) {
            client.rankEvalAsync(request, RequestOptions.DEFAULT, listener); // <1>  
 * this work for additional information regarding copyright
                // failures should be handled here  
                assertEquals(1, termSuggestion.getEntries().size());
        {  
                Map<String, Aggregation> aggregationMap = aggregations.getAsMap();  
            request.add(  
            // tag::search-source-sorting
            "    \"lang\": \"mustache\"," +
                .field("type", "keyword")
            for (Map.Entry<String, ProfileShardResult> profilingResult : profilingResults.entrySet()) { // <2>  
        assertNotNull(getResult);
            "    \"source\": {" +  
            request.add(
                )
        assertTrue(searchResponse.getHits().getTotalHits().value() > 0);
                .count(countRequest, RequestOptions.DEFAULT);
        // end::multi-search-template-execute-listener
            request.setScriptType(ScriptType.STORED);  
                public void onFailure(Exception e) {  
            SearchHits hits = searchResponse.getHits();  
        assertTrue(searchResponse.getHits().getTotalHits().value() > 0);
        String[] nonAggregatableIndices = textCapabilities.nonAggregatableIndices();//<4>
            searchSourceBuilder.query(QueryBuilders.matchQuery("user", "foobar"));  
            BulkRequest request = new BulkRequest();
}  
                        "title",  
    public void testScroll() throws Exception {  
import org.opensearch.action.index.IndexRequest;
                @Override
        SearchTemplateResponse response = client.searchTemplate(request, RequestOptions.DEFAULT);  
                    @Override
                    Collections.singletonMap("key", "value")  
        assertSame(RestStatus.OK, bulkResponse.status());
                    Collections.singletonMap("key", "value")  
                    Collections.singletonMap("key", "value")
            matchQueryBuilder.fuzziness(Fuzziness.AUTO); // <1>  
import org.opensearch.client.indices.CreateIndexResponse;
        {
            scrollRequest.scroll("60s"); // <2>
            sourceBuilder.fetchSource(includeFields, excludeFields);
            searchRequest.scroll(TimeValue.timeValueMinutes(1L)); // <2>
                        "user",
            multiRequest.add(request);  // <3>
                    1,  
        Map<String, Object> scriptParams = new HashMap<>();
                Map<String, Object> innerObject =  
            // end::rank-eval-response  
            hits = searchScrollResponse.getHits(); // <3>  
                    Map<String, HighlightField> highlightFields = hit.getHighlightFields();
        boolean match = response.isMatch(); // <4>
        SearchTemplateRequest request = new SearchTemplateRequest();
            MatchQueryBuilder matchQueryBuilder = new MatchQueryBuilder("user", "foobar"); // <1>  
            public void onResponse(SearchTemplateResponse response) {
    }  
                    // <1>
        FieldCapabilitiesResponse response = client.fieldCaps(request, RequestOptions.DEFAULT);
        // end::explain-response  
            assertEquals(3, hits.getTotalHits().value());
        // tag::explain-execute  
        bulkRequest.add(  
            request.add(
import static org.hamcrest.Matchers.containsString;
            searchSourceBuilder.query(QueryBuilders.matchQuery("user", "quxx"));
            }  
            assertTrue(success);  
            }
import org.opensearch.script.ScriptType;
            @Override  
            new IndexRequest("posts").id("3")  
            request.add(
            searchSourceBuilder.query(QueryBuilders.matchAllQuery()); // <3>
            @Override  
                public void onFailure(Exception e) {
            // end::search-source-filtering-off  
            // tag::search-query-builder-options
import org.opensearch.action.search.MultiSearchResponse;
            ActionListener<ClearScrollResponse> listener =
        // tag::multi-search-template-request-sync
                )
        indexSearchTestData();
            // end::count-execute-async
            // tag::rank-eval-execute-listener
            SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();  
            SearchRequest firstSearchRequest = new SearchRequest();   // <2>
        for (String searchTerm : searchTerms) {
import org.opensearch.search.suggest.Suggest;
import java.util.ArrayList;
 * license agreements. See the NOTICE file distributed with
            for (ShardSearchFailure failure : searchResponse.getShardFailures()) {
            String metricName = metricDetails.getMetricName();
        String[] nonSearchableIndices = textCapabilities.nonSearchableIndices(); // <3>  
        // end::explain-request  
            assertEquals(3, detail.getRetrieved());
            "    }" +  
                }  
            "      \"size\" : \"{{size}}\"" +
/*
            int skippedShards = countResponse.getSkippedShards();
            public void onFailure(Exception e) {  
                long aggTimeInMillis = profileResult.getTime(); // <4>
            for (QueryProfileShardResult queryProfileResult : queryProfileShardResults) {  
                }
        assertTrue(searchResponse.getHits().getTotalHits().value() > 0);
        BulkResponse bulkResponse = highLevelClient().bulk(bulkRequest, RequestOptions.DEFAULT);
        request.setSimulate(true); // <1>  
 * ownership. Elasticsearch licenses this file to you under  
            ProfileShardResult profileShardResult = profilingResults.values().iterator().next();  
            // end::multi-search-execute-listener
                    fragments = highlight.fragments();
                @Override
import org.opensearch.search.suggest.SuggestBuilder;
            // end::search-request-basic  
                    Collections.singletonMap("key", "value")  
        bulkRequest.add(new IndexRequest("contributors").id("1").source(MediaTypeRegistry.JSON, "id", 1, "user", "quuz"));  
            // end::search-request-routing
        // end::register-script
                // <2>
                    List<ProfileResult> profiledChildren = profileResult.getProfiledChildren(); // <4>
            // end::rank-eval-execute
import org.opensearch.search.SearchHit;  
                    .field("age"));  
        MultiSearchTemplateResponse multiResponse = client.msearchTemplate(multiRequest, RequestOptions.DEFAULT);  
            // Replace the empty listener by a blocking listener in test
    public void testCount() throws Exception {  
                    long queryTimeInMillis = profileResult.getTime(); // <3>
 * KIND, either express or implied.  See the License for the
            for (ProfileResult profileResult : aggsProfileResults.getProfileResults()) { // <2>
    }
        // tag::explain-request  
            // end::search-request-profiling-get
            EvaluationMetric metric = new PrecisionAtK();                 // <1>
            SuggestionBuilder termSuggestionBuilder =
            // tag::search-request-highlighting  
                .startObject()
            // end::search-request-preference
        // Replace the empty listener by a blocking listener for tests.  
        CreateIndexResponse authorsResponse = highLevelClient().indices().create(authorsRequest, RequestOptions.DEFAULT);
            assertTrue(latch.await(30L, TimeUnit.SECONDS));
            request.addScrollId(scrollId);
            // tag::search-response-2
                    String queryName = profileResult.getQueryName(); // <2>  
                String id = hit.getId();
        // tag::search-template-request-options  
                        long numberOfDocs = elasticBucket.getDocCount();  
            request.setScript(
            assertEquals(0, searchResponse.getFailedShards());  
        // end::render-search-template-response  
    @SuppressWarnings({ "unused", "rawtypes" })
import org.opensearch.client.OpenSearchRestHighLevelClientTestCase;
            long count = countResponse.getCount();
            SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();  
            scrollRequest.scroll(TimeValue.timeValueSeconds(60L)); // <1>
            XContentFactory.jsonBuilder()
            // end::search-query-builder-options  
                // end::search-request-aggregations-iterator  
                List<CollectorResult> profiledChildren = collectorResult.getProfiledChildren(); // <4>
            assertSame(RestStatus.OK, bulkResponse.status());
            {
        {
            }  
        CreateIndexResponse authorsResponse = highLevelClient().indices().create(authorsRequest, RequestOptions.DEFAULT);
        CountDownLatch latch = new CountDownLatch(1);
            // end::count-response-2
                    assertThat(message, containsString("org.opensearch.search.aggregations.bucket.terms.ParsedStringTerms"));  
            SearchSourceBuilder sourceBuilder = new SearchSourceBuilder(); // <1>
import org.opensearch.search.profile.ProfileShardResult;  
        assertEquals(searchTerms.length, multiResponse.getResponses().length);
            // tag::search-request-indices  
            // tag::multi-search-request-basic
import org.opensearch.script.mustache.SearchTemplateRequest;  
                    "id",  
import org.opensearch.search.aggregations.AggregationBuilders;  
/**
        // tag::explain-request-source
    }  
        );
                .endObject()  
            searchSourceBuilder = new SearchSourceBuilder();
            assertEquals(3L, searchResponse.getHits().getTotalHits().value());
        SearchResponse searchResponse = multiResponse.getResponses()[0].getResponse().getResponse();  
            int failedShards = searchResponse.getFailedShards();
            SearchResponse searchResponse = client.search(searchRequest, RequestOptions.DEFAULT);  
                    new ActionListener<SearchResponse>() {
                    // <1>
            PrecisionAtK.Detail detail = (PrecisionAtK.Detail) metricDetails;  
            // end::search-query-setter  
                    "innerObject",
                @Override  
        ActionListener<ExplainResponse> listener = new ActionListener<ExplainResponse>() {
        BulkRequest bulkRequest = new BulkRequest();  
            searchRequest.preference("_local"); // <1>
            assertTrue(succeeded);
            // end::search-response-2
                        // <1>
/*  
            // end::search-hits-singleHit  
        {
            // tag::search-source-setter
            client.msearchAsync(request, RequestOptions.DEFAULT, listener); // <1>  
            // tag::multi-search-execute-listener
            // tag::search-response-1  
            int totalShards = countResponse.getTotalShards();
                }
    @SuppressWarnings("unused")
                    for (TermSuggestion.Entry.Option option : entry) { // <4>  
            request.add(new IndexRequest("posts").id("2").source(MediaTypeRegistry.JSON, "company", "OpenSearch", "age", 30));
                // <3>  
    @SuppressWarnings({ "unused", "unchecked" })
        );  
        CreateIndexRequest authorsRequest = new CreateIndexRequest("authors").mapping(
            searchSourceBuilder.query(QueryBuilders.termQuery("tags", "opensearch"));
import org.opensearch.client.indices.CreateIndexRequest;
import org.opensearch.client.core.CountResponse;  
                .startObject()
        }
            assertTrue(latch.await(30L, TimeUnit.SECONDS));  
        );
            for (SearchHit hit : searchHits) {  
import org.opensearch.index.rankeval.RankEvalRequest;
                scrollId = searchResponse.getScrollId();
                    assertThat(fragments[0].string(), containsString("<em>foobar</em>"));  
        {
        CountDownLatch latch = new CountDownLatch(1);
import org.opensearch.core.common.text.Text;  
import org.opensearch.client.Response;
                    }
            assertEquals(PrecisionAtK.NAME, metricName);                // <6>
            String scrollId = searchResponse.getScrollId();
        // end::explain-execute-listener
        }
import java.util.concurrent.TimeUnit;  
        RestHighLevelClient client = highLevelClient();  
            assertNotNull(client.count(countRequest, RequestOptions.DEFAULT));  
                // tag::search-request-profiling-queries-results
            searchRequest.source(searchSourceBuilder);  
                }  
                        "title",  
        {  
            Map<String, EvalQueryQuality> partialResults =
        }  
                String collectorName = collectorResult.getName();  // <2>
                public void onResponse(RankEvalResponse response) {
import org.opensearch.search.aggregations.metrics.Avg;  
        // end::search-template-execute
                        MediaTypeRegistry.JSON,
        indexSearchTestData();
            EvalQueryQuality evalQuality =  
            BulkResponse bulkResponse = client.bulk(request, RequestOptions.DEFAULT);
            secondSearchRequest.source(searchSourceBuilder);  
                    "user",  
            // tag::multi-search-response  
        indexSearchTestData();  
        indexSearchTestData();  
            );
                    "Current status and upcoming changes in OpenSearch",
        }  
        assertNotNull(multiResponse.getResponses()[0]);  
                new IndexRequest("posts").id("2")  
    }  
    @SuppressWarnings({ "unused", "unchecked" })
                .endObject()  
        RestHighLevelClient client = highLevelClient();
        SearchTemplateResponse response = client.searchTemplate(request, RequestOptions.DEFAULT);
            Aggregations aggregations = searchResponse.getAggregations();  
import org.opensearch.action.search.ClearScrollResponse;
            searchResponse = secondResponse.getResponse();
            // end::clear-scroll-response
            // tag::clear-scroll-execute-listener  
import org.opensearch.action.fieldcaps.FieldCapabilities;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                assertEquals(1, termSuggestion.getEntries().get(0).getOptions().size());  
            matchQueryBuilder.maxExpansions(10); // <3>
import static org.hamcrest.Matchers.greaterThan;  
            // end::search-request-profiling-queries  
        indexSearchTestData();  
                        String suggestText = option.getText().string();
                    profileShardResult.getQueryProfileResults(); // <1>
            // tag::clear-scroll-response
            "{" +  
                    .source(MediaTypeRegistry.JSON, "title", "Current status and upcoming changes in OpenSearch")
        // tag::explain-request-stored-field
                // end::search-request-aggregations-asMap
        RestHighLevelClient client = highLevelClient();  
                    response.getPartialResults();
                    "title",
            assertThat(queryProfileShardResults.size(), equalTo(1));
            // end::search-execute-listener  
import org.opensearch.index.rankeval.RankEvalResponse;  
            public void onResponse(MultiSearchTemplateResponse response) {
                    )  
import org.opensearch.action.search.SearchScrollRequest;
                }
            // tag::scroll-request-arguments  
        params.put("field", "title");  
        // tag::explain-execute-listener
        listener = new LatchedActionListener<>(listener, latch);
            .indices("posts", "authors", "contributors");
                searchResponse = client.scroll(scrollRequest, RequestOptions.DEFAULT);  
                    Collections.singletonMap("key", "value")  
            searchRequest.source(searchSourceBuilder);  
                        // <2>  
                // tag::search-request-profiling-queries-collectors  
                    "title",
                .endObject()
import org.opensearch.common.unit.Fuzziness;
import org.opensearch.search.profile.query.CollectorResult;
                        Collections.singletonMap("key", "value")
        // end::field-caps-execute-listener
                .field("type", "keyword")
            // end::search-hits-info  
        {
        boolean hasExplanation = response.hasExplanation(); // <5>  
            QueryBuilder matchQueryBuilder = QueryBuilders.matchQuery("user", "foobar")
    @SuppressWarnings({ "unused" })
 * this file be licensed under the Apache-2.0 license or a
        RestHighLevelClient client = highLevelClient();
        bulkRequest.add(
        // tag::multi-search-template-request-stored  
                    "On Net Neutrality",
            SearchTemplateRequest request = new SearchTemplateRequest();  // <2>  
        // end::search-template-execute-listener
            {
        request.routing("routing"); // <1>  
        assertNotNull(multiResponse);  
            request.setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE);  
        SearchResponse searchResponse = response.getResponse();  
            public void onFailure(Exception e) {  
                };
        // end::multi-search-template-request-stored
            // tag::search-execute-listener  
                @Override
        request.query(QueryBuilders.termQuery("user", "quuz"));
            }
            // tag::search-request-suggestion  
                CollectorResult collectorResult = queryProfileResult.getCollectorResult();  // <1>
 * software distributed under the License is distributed on an
            // tag::clear-scroll-request
            // tag::count-request-args  
import org.opensearch.search.profile.aggregation.AggregationProfileShardResult;
            // end::search-scroll-execute-sync
            {
        // tag::search-template-execute-listener
            request.setScriptParams(scriptParams);
        // tag::render-search-template-response  
                SearchHits hits = searchResponse.getHits();  
                    // end::search-request-aggregations-get-wrongCast  
                    MediaTypeRegistry.JSON,  
            scrollId = searchScrollResponse.getScrollId();  // <2>
        // end::explain-execute-async
            assertNull(hits.getHits()[0].getSourceAsMap().get("user"));  
        // tag::get-result  
            );
 * the Apache License, Version 2.0 (the "License"); you may
            int released = response.getNumFreed(); // <2>
    }
            boolean timedOut = searchResponse.isTimedOut();
import org.apache.lucene.search.TotalHits;
            assertEquals(1.0 / 3.0, evaluationResult, 0.0);  
import org.opensearch.search.suggest.term.TermSuggestion;
            SearchRequest searchRequest = new SearchRequest("posts"); // <1>
                }
                    new RatedRequest("foobar_query", ratedDocs, searchQuery);
            for (SearchHit hit : searchHits) {
                        Arrays.asList("foobar", "quxx"),  
                SearchResponse searchResponse = searchTemplateResponse.getResponse();  
                    MediaTypeRegistry.JSON,  
                    Arrays.asList("foobar", "quuz"),
            request.setScriptType(ScriptType.INLINE);  
            // tag::search-request-routing  
            .fields("user")
            // tag::count-source-setter
            searchRequest.scroll(scroll);
                    }
        // end::field-caps-execute-async  
            assertEquals(3, hits.getTotalHits().value());  
            public void onResponse(FieldCapabilitiesResponse response) {
            {
                hits = searchResponse.getHits();
            }  
            clearScrollRequest.addScrollId(scrollId);
            Map<String, Object> params = new HashMap<>();  
                @Override  
            assertNotNull(searchResponse);  
        Map<String, Object> source = getResult.getSource(); // <1>
                    "innerObject",
                        "user",
import org.opensearch.search.sort.SortOrder;  
            assertEquals("3", ratedSearchHit.getSearchHit().getId());   // <4>
        assertFalse(bulkResponse.hasFailures());
            // tag::search-scroll2
                    public void onResponse(CountResponse countResponse) {  
            multiRequest.add(request);
        }
            // tag::rank-eval-response
            int successfulShards = searchResponse.getSuccessfulShards();  
            }  
            SearchResponse searchScrollResponse = client.scroll(scrollRequest, RequestOptions.DEFAULT);
            client.countAsync(countRequest, RequestOptions.DEFAULT, listener); // <1>
                @Override
            // end::rank-eval-request-basic
                assertEquals(30, avg, 0.0);
                // do something with the SearchHit
                )
        assertTrue(latch.await(30L, TimeUnit.SECONDS));
        request.setScriptParams(scriptParams); // <3>  
 * Licensed to Elasticsearch under one or more contributor  
            }
            RestStatus status = searchResponse.status();
            }
            searchSourceBuilder.aggregation(aggregation);
            searchRequest.scroll("60s");
            IndexResponse indexResponse = client.index(request, RequestOptions.DEFAULT);
            request.setScrollIds(scrollIds);
import org.opensearch.index.rankeval.PrecisionAtK;
                    new RankEvalRequest(specification, new String[] { "posts" });  
                searchHits = searchResponse.getHits().getHits();
            "  \"size\" : \"{{size}}\"" +
            request.addScrollId(scrollId); // <2>  
        {
                searchResponse.getHits();
        assertArrayEquals(indices, new String[] { "authors", "contributors" });  
            // end::search-request-suggestion
            BulkRequest request = new BulkRequest();  
        // tag::field-caps-execute  
            }
            SuggestBuilder suggestBuilder = new SuggestBuilder();
        CountDownLatch latch = new CountDownLatch(1);
        listener = new LatchedActionListener<>(listener, latch);
            // end::search-request-indicesOptions
        assertTrue(latch.await(30L, TimeUnit.SECONDS));
            // tag::search-request-basic
            assertEquals(4, searchResponse.getHits().getTotalHits().value());
                    "innerObject",  
import org.opensearch.common.document.DocumentField;  
                // end::search-hits-singleHit-source
        request.storedFields(new String[]{"user"}); // <1>  
        // end::explain-request-routing
                // end::search-request-suggestion-get
            HighlightBuilder.Field highlightTitle =  
            Boolean terminatedEarly = countResponse.isTerminatedEarly();  
        assertArrayEquals(nonAggregatableIndices, new String[] { "authors" });
        {
        }
        boolean isAggregatable = textCapabilities.isAggregatable();  
                }  
        }
                @Override  
                @Override
            // end::search-execute-async
import org.opensearch.search.sort.FieldSortBuilder;
        ExplainResponse response = client.explain(request, RequestOptions.DEFAULT);
        // tag::multi-search-template-execute  
            SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder(); // <2>  
        {
import org.opensearch.action.explain.ExplainResponse;
            searchRequest.routing("routing"); // <1>
                    HighlightField highlight = highlightFields.get("title"); // <1>  
            SearchHit[] searchHits = searchResponse.getHits().getHits();  
        bulkRequest.setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE);  
            "{" +  
import org.opensearch.core.common.bytes.BytesReference;
                        Arrays.asList("foobar", "grault"),  
            // end::count-response-1
 * Code wrapped in {@code tag} and {@code end} tags is included in the docs.
    public void testMultiSearchTemplateWithStoredScript() throws Exception {
            // end::clear-scroll-add-scroll-id
                }
import org.opensearch.action.fieldcaps.FieldCapabilitiesResponse;
            params.put("field", "title");
                new IndexRequest("posts").id("2")  
                .source(
    }
            searchSourceBuilder.suggest(suggestBuilder);  
            // end::multi-search-execute
                        Arrays.asList("foobar", "quuz"),  
        assertEquals(  
        boolean isSearchable = textCapabilities.isSearchable();
/*  
import org.opensearch.action.search.SearchRequest;
        Map<String, DocumentField> fields = getResult.getFields(); // <2>
        // end::explain-request-stored-field
        indexSearchTestData();
            BulkResponse bulkResponse = client.bulk(request, RequestOptions.DEFAULT);  
            highlightBuilder.field(highlightTitle);  // <4>  
        String id = response.getId(); // <2>  
            new IndexRequest("posts").id("1")
import org.opensearch.client.RestClient;  
import java.util.Arrays;  
    }  
                    }
            searchRequest.source(searchSourceBuilder);
                    assertThat(fragments[0].string(), containsString("<em>OpenSearch</em>"));
            SearchResponse searchResponse = client.search(searchRequest, RequestOptions.DEFAULT);  
                new ActionListener<CountResponse>() {  
                    // <2>
        scriptParams.put("value", "opensearch");
                }  
            };
    }  
                // end::search-request-highlighting-get
                String aggName = profileResult.getQueryName(); // <3>  
import org.opensearch.common.unit.TimeValue;
            float maxScore = hits.getMaxScore();
            request.setScript("title_search");
            client.searchAsync(searchRequest, RequestOptions.DEFAULT, listener); // <1>
            request.setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE);  
                for (TermSuggestion.Entry entry : termSuggestion.getEntries()) { // <3>
            searchRequest.source(searchSourceBuilder); // <4>
        RestClient restClient = client();
        // end::field-caps-response
        );
                .field("type", "keyword")  
                }
            boolean success = response.isSucceeded(); // <1>  
        // tag::render-search-template-request
            scrollListener = new LatchedActionListener<>(scrollListener, latch);
import org.opensearch.search.SearchHits;
            final CountDownLatch latch = new CountDownLatch(1);
                .preference("_local"); // <4>
            SearchRequest searchRequest = new SearchRequest();
                    String type = agg.getType();  
        assertTrue(reviewersResponse.isAcknowledged());
            // tag::count-execute-async  
                public void onResponse(SearchResponse searchResponse) {
        // Replace the empty listener by a blocking listener for tests.  
            RankEvalRequest request =                                     // <6>
        MultiSearchTemplateRequest multiRequest = new MultiSearchTemplateRequest();
                ProfileShardResult profileShardResult = profilingResult.getValue(); // <4>
            }
                Avg averageAge = elasticBucket.getAggregations().get("average_age"); // <3>
                .endObject()
                }
            // end::search-scroll-execute-async  
            // end::search-request-indices
            SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder(); // <2>  
                    Map<String, HighlightField> highlightFields = hit.getHighlightFields();
            assertFalse(bulkResponse.hasFailures());  
                String documentTitle = (String) sourceAsMap.get("title");
            SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();  
        // tag::explain-request-routing
                    2,
            searchSourceBuilder.aggregation(AggregationBuilders.histogram("by_comments").field("comments").interval(100));
                )  
                }  
            RestStatus status = countResponse.status();
import org.opensearch.script.mustache.SearchTemplateResponse;
            // tag::search-scroll-execute-sync
            }
                    new HighlightBuilder.Field("title"); // <2>
import org.opensearch.action.fieldcaps.FieldCapabilitiesRequest;  
            searchSourceBuilder.highlighter(highlightBuilder);  
    public void testSearch() throws Exception {  
                .endObject()
            "}");  
                assertEquals("foobar", termSuggestion.getEntries().get(0).getOptions().get(0).getText().string());
            "  \"query\": { \"match\" : { \"{{field}}\" : \"{{value}}\" } }," +
            ClearScrollResponse clearScrollResponse = client.clearScroll(clearScrollRequest, RequestOptions.DEFAULT);
        assertThat(index, equalTo("contributors"));
                .indicesOptions(IndicesOptions.lenientExpandOpen()) // <3>  
                Long collectorTimeInMillis = collectorResult.getTime(); // <3>  
            // end::clear-scroll-add-scroll-ids
            };  
            // end::multi-search-request-basic
            new IndexRequest("blog").id("1")
                .endObject()
            SearchResponse searchResponse = client.search(searchRequest, RequestOptions.DEFAULT);  
            request.add(secondSearchRequest);
        indexSearchTestData();  
            listener = new LatchedActionListener<>(listener, latch);  
            SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
                @Override  
            // tag::search-query-builder-ctor
        Explanation explanation = response.getExplanation(); // <6>
        boolean exists = response.isExists(); // <3>
            // end::search-source-filtering-includes
            Map<String, Object> scriptParams = new HashMap<>();
            assertFalse(bulkResponse.hasFailures());
            request.add(new IndexRequest("posts").id("3").source(MediaTypeRegistry.JSON, "user", "quzz"));  
        assertTrue(searchResponse.getHits().getTotalHits().value() > 0);  
        assertTrue(authorsResponse.isAcknowledged());  
            // the total number of hits, must be interpreted in the context of totalHits.relation
            final CountDownLatch latch = new CountDownLatch(1);
        params.put("value", "opensearch");
            );
                    partialResults.get("foobar_query");                 // <2>
import org.opensearch.index.rankeval.RatedRequest;  
            // end::search-source-basics  
        // tag::explain-response
            assertEquals(1, searchResponse.getHits().getTotalHits().value());
        }
        assertTrue(isSearchable);  
    public void testExplain() throws Exception {
                    3,
            ClearScrollResponse clearScrollResponse = client.clearScroll(clearScrollRequest, RequestOptions.DEFAULT);
        listener = new LatchedActionListener<>(listener, latch);
            // Replace the empty listener by a blocking listener in test
            // tag::count-source-basics  
        FieldCapabilitiesRequest request = new FieldCapabilitiesRequest()  
            // tag::clear-scroll-add-scroll-ids  
        request.setScriptType(ScriptType.STORED);
            @Override
            HighlightBuilder.Field highlightUser = new HighlightBuilder.Field("user");
                )
import org.opensearch.action.explain.ExplainRequest;  
            SearchResponse searchResponse = client.scroll(scrollRequest, RequestOptions.DEFAULT);  
import org.opensearch.index.rankeval.EvaluationMetric;
            RankEvalResponse response = client.rankEval(request, RequestOptions.DEFAULT);
    protected void registerQueryScript(RestClient restClient) throws IOException {
            "  }" +
                // failures should be handled here  
                    // <1>
        CreateIndexResponse reviewersResponse = highLevelClient().indices().create(reviewersRequest, RequestOptions.DEFAULT);  
                .startObject("properties")
            @Override  
        {
            // tag::search-request-profiling-get  
        RestHighLevelClient client = highLevelClient();  
import static org.opensearch.index.query.QueryBuilders.matchQuery;
        // tag::field-caps-execute-listener
        Map<String, Object> params = new HashMap<>();
 * The OpenSearch Contributors require contributions made to  
            boolean succeeded = clearScrollResponse.isSucceeded();
            // tag::search-request-indicesOptions  
            assertEquals("foobar_query", evalQuality.getId());
                        Collections.singletonMap("key", "value")
                .field("store", "true")
import org.opensearch.core.xcontent.MediaTypeRegistry;
            SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
            countRequest.indices("blog", "author");
                    "title",  
                .source(
        RestHighLevelClient client = highLevelClient();
            listener = new LatchedActionListener<>(listener, latch);
        }
            @Override
            int totalShards = searchResponse.getTotalShards();
import org.opensearch.search.suggest.SuggestionBuilder;
                Suggest suggest = searchResponse.getSuggest(); // <1>  
                public void onFailure(Exception e) {
        // tag::multi-search-template-execute-listener
            assertThat(released, greaterThan(0));
            }
            {  
        assertTrue(hasExplanation);
import org.opensearch.action.search.SearchResponse;  
            // end::search-query-builder-ctor
            request.setScriptParams(params);
        ExplainRequest request = new ExplainRequest("contributors", "1");
 *  
            BulkResponse bulkResponse = client.bulk(request, RequestOptions.DEFAULT);  
        }
            // end::search-request-profiling-aggs
    }  
                    profileShardResult.getAggregationProfileResults(); // <1>
        }  
            );
            searchSourceBuilder.query(QueryBuilders.matchAllQuery());  
            // Replace the empty listener by a blocking listener in test
        assertFalse(bulkResponse.hasFailures());  
        indexCountTestData();
    public void testSearchRequestAggregations() throws IOException {
            matchQueryBuilder.prefixLength(3); // <2>
            // tag::count-response-1  
        RestHighLevelClient client = highLevelClient();
                        MediaTypeRegistry.JSON,
            List<QueryProfileShardResult> queryProfileShardResults =
            CountResponse countResponse = client  
                .source(
            };
            // tag::search-scroll-init
            // Replace the empty listener by a blocking listener in test  
            } else {
                .field("type", "keyword")  
                // tag::search-request-aggregations-asMap
import org.opensearch.action.bulk.BulkResponse;
        );  
                "}");
        String[] indices = textCapabilities.indices(); // <2>
        );
                    .source(
    public void testSearchRequestSuggestions() throws IOException {  
                    "innerObject",
                    assertEquals(1, fragments.length);
                    .source(
                    // <1>  
        Response scriptResponse = restClient.performRequest(scriptRequest);  
            MultiSearchResponse.Item firstResponse = response.getResponses()[0];   // <1>
    }
                        Collections.singletonMap("key", "value")
                // tag::search-hits-singleHit-source
            final CountDownLatch latch = new CountDownLatch(1);  
        // tag::multi-search-template-request-inline
        {
                for (Aggregation agg : aggregations) {
            List<RatedRequest> ratedRequests = Arrays.asList(ratedRequest);
            countRequest.source(searchSourceBuilder); // <4>
            searchRequest.indicesOptions(IndicesOptions.lenientExpandOpen()); // <1>
        );
import org.opensearch.search.profile.query.QueryProfileShardResult;  
import org.opensearch.index.rankeval.RatedSearchHit;
            // whether the number of hits is accurate (EQUAL_TO) or a lower bound of the total (GREATER_THAN_OR_EQUAL_TO)  
                public void onResponse(ClearScrollResponse clearScrollResponse) {
            // tag::search-request-profiling-queries  
            ClearScrollRequest clearScrollRequest = new ClearScrollRequest();  
                SearchTemplateResponse searchTemplateResponse = item.getResponse(); // <3>
        }
        SearchResponse searchResponse = multiResponse.getResponses()[0].getResponse().getResponse();
                .endObject()
    public void testSearchTemplateWithStoredScript() throws Exception {  
        // end::get-result  
            // tag::rank-eval-execute-async
            request.add(new IndexRequest("posts").id("4").source(MediaTypeRegistry.JSON, "user", "corge"));
                List<ProfileResult> profiledChildren = profileResult.getProfiledChildren(); // <5>
            public void onFailure(Exception e) {  
            searchRequest.indices("posts");
        }
import org.opensearch.search.aggregations.Aggregation;
            request.setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE);
        RestHighLevelClient client = highLevelClient();
                    // tag::search-request-aggregations-get-wrongCast
        for (String searchTerm : searchTerms) {
            SearchRequest searchRequest = new SearchRequest();  
                // end::search-request-aggregations-get
import org.opensearch.action.search.ClearScrollRequest;
                    highlight = highlightFields.get("user");  
                    // <2>  
    public void testMultiSearchTemplateWithInlineScript() throws Exception {  
        // Replace the empty listener by a blocking listener for tests.  
                                                            .fuzziness(Fuzziness.AUTO)
                .endObject()
                @Override
        assertNotNull(multiResponse.getResponses()[0]);
            final Scroll scroll = new Scroll(TimeValue.timeValueMinutes(1L));  
            // end::search-scroll-execute-listener
            assertTrue(clearScrollResponse.isSucceeded());  
import static org.hamcrest.Matchers.equalTo;
                float score = hit.getScore();
        // end::search-template-response  
                String error = item.getFailureMessage(); // <2>  
        RestHighLevelClient client = highLevelClient();  
            // end::clear-scroll-execute-async  
            sourceBuilder.fetchSource(true);  
            // end::clear-scroll-execute  
                        "Current status and upcoming changes in OpenSearch",
            SearchHits hits = searchResponse.getHits();  // <4>
        // tag::multi-search-template-execute-async
            // tag::search-request-profiling-aggs
            suggestBuilder.addSuggestion("suggest_user", termSuggestionBuilder); // <2>
            "      \"query\": { \"match\" : { \"{{field}}\" : \"{{value}}\" } }," +
        {
        assertThat(fields.get("user").getValue(), equalTo("quuz"));
            // tag::search-source-filtering-includes
                // end::search-request-profiling-queries-results
            assertFalse(bulkResponse.hasFailures());  
            searchSourceBuilder.query(matchQuery("title", "OpenSearch"));
import org.opensearch.client.Request;  
import org.opensearch.action.search.ShardSearchFailure;
        RestHighLevelClient client = highLevelClient();
 */  
            assertFalse(ratedSearchHit.getRating().isPresent());        // <5>
            assertNull(firstResponse.getFailure());                                // <2>
        // end::multi-search-template-request-sync
            }  
                SuggestBuilders.termSuggestion("user").text("fooarb"); // <1>  
            List<RatedDocument> ratedDocs = new ArrayList<>();
                // end::search-request-aggregations-asList
        {
            // tag::search-execute
            BulkRequest request = new BulkRequest();
                    new RankEvalSpec(ratedRequests, metric);              // <5>
                    "title",
            ClearScrollRequest clearScrollRequest = new ClearScrollRequest(); // <5>
            // tag::clear-scroll-execute
        {
 * compatible open source license.
        }  
            sourceBuilder.sort(new FieldSortBuilder("id").order(SortOrder.ASC));  // <2>
            // tag::search-query-setter
            // end::count-request-args
                }
        request.setScript("title_search");  
            // end::multi-search-response  
            SearchTemplateRequest request = new SearchTemplateRequest();  
                try {  
            // end::search-source-sorting
            Boolean terminatedEarly = searchResponse.isTerminatedEarly();  
            // end::clear-scroll-execute-listener
                    assertThat(message, containsString("org.opensearch.search.aggregations.bucket.range.Range"));
            int size = 1;  
        Map<String, FieldCapabilities> userResponse = response.getField("user");  // <1>
import org.opensearch.search.profile.ProfileResult;
            // end::count-execute-listener  
            BulkResponse bulkResponse = client.bulk(request, RequestOptions.DEFAULT);
                    Collections.singletonMap("key", "value")
            // end::search-execute
import org.opensearch.search.sort.ScoreSortBuilder;
 * Unless required by applicable law or agreed to in writing,
        };  
            ClearScrollRequest request = new ClearScrollRequest(); // <1>
        }  
import java.util.HashMap;
                .startObject("properties")  
        Request scriptRequest = new Request("POST", "/_scripts/title_search");
    }  
    }
        }  
import org.opensearch.index.query.MatchQueryBuilder;
                                                            .prefixLength(3)  
import java.util.Collections;
        }
            SearchResponse searchResponse = client.search(searchRequest, RequestOptions.DEFAULT);
                .startObject("user")
        BulkResponse bulkResponse = highLevelClient().bulk(bulkRequest, RequestOptions.DEFAULT);  
    }
            TotalHits totalHits = hits.getTotalHits();  
    public void testSearchRequestProfiling() throws IOException {
import org.opensearch.script.mustache.MultiSearchTemplateResponse;
                "{" +
        assertTrue(exists);  
            SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
            }  
            // tag::search-hits-singleHit
                // <1>
                .startObject("id")  
            SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
                }  
                new IndexRequest("posts").id("3").source(MediaTypeRegistry.JSON, "title", "The Future of Federated Search in OpenSearch")
import org.opensearch.search.fetch.subphase.highlight.HighlightBuilder;  
        CreateIndexRequest authorsRequest = new CreateIndexRequest("author").mapping(  
                    // <2>
            assertSame(RestStatus.OK, bulkResponse.status());
        {
            params.put("value", searchTerm);
        assertTrue(match);
            // tag::rank-eval-execute  
            request.add(
            );
                .field("doc_values", "false")  
            String scrollId = initialSearchResponse.getScrollId();
 * GitHub history for details.
        client.searchTemplateAsync(request, RequestOptions.DEFAULT, listener); // <1>
                Aggregations aggregations = searchResponse.getAggregations();
            ActionListener<SearchResponse> scrollListener =
            searchSourceBuilder.profile(true);
            // end::multi-search-execute-async
                    "id",
    @SuppressWarnings("unused")
        scriptParams.put("field", "title");  
            assertNotNull(client.search(searchRequest, RequestOptions.DEFAULT));  
            sourceBuilder.query(QueryBuilders.termQuery("user", "foobar")); // <2>
                    Arrays.asList("foobar", "matt"),
        String index = response.getIndex(); // <1>
            // end::count-execute
        // end::field-caps-request  
                    MediaTypeRegistry.JSON,
            scrollRequest.scroll(TimeValue.timeValueSeconds(30));  
        );  
import static org.hamcrest.Matchers.containsInAnyOrder;  
            assertEquals(TotalHits.Relation.EQUAL_TO, relation);
                    Text[] fragments = highlight.fragments();  // <2>
        registerQueryScript(restClient);
        // tag::search-template-response  
        }  
        params.put("size", 5);
            searchSourceBuilder.query(
 * Documentation for search APIs in the high level java client.  
        {
            assertNotNull(hits.getHits()[0].getSourceAsMap().get("innerObject"));
import java.io.IOException;
            final CountDownLatch latch = new CountDownLatch(1);  
        assertNull(nonSearchableIndices);
            // tag::search-source-filtering-off
            assertTrue(latch.await(30L, TimeUnit.SECONDS));
            MetricDetail metricDetails = evalQuality.getMetricDetails();  
                    MediaTypeRegistry.JSON,  
            }
                scrollRequest.scroll(scroll);
        bulkRequest.add(  
        request.setScript( // <2>
        // tag::register-script  
            // end::scroll-request-arguments  
                    if (type.equals(TermsAggregationBuilder.NAME)) {
            sourceBuilder.size(5); // <4>
        ActionListener<MultiSearchTemplateResponse> listener = new ActionListener<MultiSearchTemplateResponse>() {
 *    http://www.apache.org/licenses/LICENSE-2.0
            sourceBuilder.fetchSource(false);
                Terms byCompanyAggregation = aggregations.get("by_company"); // <1>  
        scriptRequest.setJsonEntity(
                    "title",
            sourceBuilder.from(0); // <3>  
                for (ProfileResult profileResult : queryProfileResult.getQueryResults()) { // <1>
            SearchRequest searchRequest = new SearchRequest("posts");
        assertThat(source, equalTo(Collections.singletonMap("user", "quuz")));
            // end::search-response-1
                // tag::search-hits-singleHit-properties
            searchRequest.source(sourceBuilder);
import org.opensearch.search.suggest.SuggestBuilders;  
            }  
        bulkRequest.add(  
                    String fragmentString = fragments[0].string();
            CountRequest countRequest = new CountRequest();  
            new IndexRequest("blog").id("2")
            // tag::search-scroll-example
        // end::explain-request-preference
            searchRequest.source(searchSourceBuilder);
            Map<String, ProfileShardResult> profilingResults =
            // end::search-query-builders
            highlightTitle.highlighterType("unified");  // <3>
    public void testMultiSearch() throws Exception {
                // <2>
            // end::rank-eval-execute-listener
        {  
            assertEquals(1, detail.getRelevantRetrieved());             // <7>
        assertFalse(isAggregatable);
        // tag::field-caps-request
                SearchScrollRequest scrollRequest = new SearchScrollRequest(scrollId); // <4>
                // tag::search-request-aggregations-iterator
                double avg = averageAge.getValue();  
            searchQuery.query(QueryBuilders.matchQuery("user", "foobar"));// <3>
        assertTrue(latch.await(30L, TimeUnit.SECONDS));
        // end::multi-search-template-execute-async  
            ClearScrollResponse response = client.clearScroll(request, RequestOptions.DEFAULT);
        }
                    // <2>
        }
                    Arrays.asList("foobar", "grault"),  
            ("{  \"size\" : \"5\",  \"query\": { \"match\" : { \"title\" : \"opensearch\" } }}").replaceAll("\\s+", ""),
        assertThat(id, equalTo("1"));
            SearchSourceBuilder sourceBuilder = new SearchSourceBuilder(); // <1>
        request.setRequest(new SearchRequest("posts")); // <1>
            ActionListener<RankEvalResponse> listener = new ActionListener<RankEvalResponse>() {  
        client.explainAsync(request, RequestOptions.DEFAULT, listener); // <1>
        request.setRequest(new SearchRequest("posts"));  
                // tag::search-request-aggregations-get
                    Range range = aggregations.get("by_company"); // <1>
        }
            String[] includeFields = new String[] {"title", "innerObject.*"};
 *
        SearchTemplateResponse renderResponse = client.searchTemplate(request, RequestOptions.DEFAULT);
        bulkRequest.setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE);
            // end::rank-eval-execute-async
        RestHighLevelClient client = highLevelClient();
            assertEquals(1, hits.getHits().length);
            CountRequest countRequest = new CountRequest("blog") // <1>
            aggregation.subAggregation(AggregationBuilders.avg("average_age")
            // tag::count-execute-listener
            };  
                .endObject()
    }
            RankEvalSpec specification =  
        {
                    "innerObject",
            // end::count-source-basics  
                .startObject("properties")
import org.opensearch.core.action.ActionListener;
            // end::search-source-setter  
            // tag::count-response-2  
            assertFalse(bulkResponse.hasFailures());
        assertEquals(searchTerms.length, multiResponse.getResponses().length);
                                                            .maxExpansions(10);
            // tag::search-request-aggregations
        MultiSearchTemplateResponse multiResponse = client.msearchTemplate(multiRequest, RequestOptions.DEFAULT);
            client.scrollAsync(scrollRequest, RequestOptions.DEFAULT, scrollListener); // <1>
            listener = new LatchedActionListener<>(listener, latch);
import org.opensearch.search.aggregations.bucket.terms.Terms.Bucket;
                    "title",
                    HighlightField highlight = highlightFields.get("title");
            public void onResponse(ExplainResponse explainResponse) {
        // end::multi-search-template-response
                // <2>
            // end::search-scroll2
                    "user",  
            // tag::search-request-preference  
            SearchRequest secondSearchRequest = new SearchRequest();  // <4>  
    public void testRankEval() throws Exception {
        request.setExplain(true);
            SearchRequest searchRequest = new SearchRequest();  
            assertEquals(3, numHits);
import org.opensearch.search.aggregations.bucket.terms.TermsAggregationBuilder;
        client.fieldCapsAsync(request, RequestOptions.DEFAULT, listener); // <1>
            request.setRequest(new SearchRequest("posts"));
    public void testBuildingSearchQueries() {
            scriptParams.put("field", "title");
            source.utf8ToString()
            // tag::search-scroll-execute-listener  
            assertNotNull(scrollId);
        bulkRequest.add(new IndexRequest("author").id("1").source(MediaTypeRegistry.JSON, "user", "foobar"));
        RestHighLevelClient client = highLevelClient();
        BulkRequest bulkRequest = new BulkRequest();
import org.opensearch.search.builder.SearchSourceBuilder;
        // end::explain-execute
        RestHighLevelClient client = highLevelClient();
                        Bucket elasticBucket = ((Terms) agg).getBucketByKey("OpenSearch");
            );
            @Override  
            listener = new LatchedActionListener<>(listener, clearScrollLatch);
        request.setScriptParams(params);  
        {
                    String message = ex.getMessage();
            final CountDownLatch latch = new CountDownLatch(1);
            // end::search-request-profiling  
import org.opensearch.index.query.QueryBuilder;
                        "innerObject",
            // tag::search-hits-info
                public void onResponse(SearchResponse searchResponse) {  
                    // <1>  
                    "XYZ Joins Forces with OpenSearch",
        MultiSearchTemplateRequest multiRequest = new MultiSearchTemplateRequest(); // <1>
                    "Doubling Down on Open?",
                .endObject()  
        String [] searchTerms = {"opensearch", "opensearch-dashboards"};
                .field("type", "keyword")
                    "In which order are my OpenSearch queries executed?",
            SearchResponse searchResponse = firstResponse.getResponse();           // <3>  
                    "The Future of Federated Search in OpenSearch",  
            SearchResponse initialSearchResponse = client.search(searchRequest, RequestOptions.DEFAULT);  
            String[] excludeFields = new String[] {"user"};  
            // tag::search-request-profiling  
                .field("doc_values", "false")
            for (ShardSearchFailure failure : countResponse.getShardFailures()) {
        {
            SearchRequest searchRequest = new SearchRequest("posts");
        // tag::field-caps-request-indicesOptions
import org.opensearch.action.LatchedActionListener;  
            SearchScrollRequest scrollRequest = new SearchScrollRequest(scrollId); // <1>
            assertEquals(4, countResponse.getCount());
            // tag::clear-scroll-execute-async
                // end::search-hits-singleHit-properties  
            searchSourceBuilder.size(size); // <1>
        // end::multi-search-template-request-inline  
    public void testFieldCaps() throws Exception {
            }
                // <2>
                    Arrays.asList("tyler", "foobar"),
import org.opensearch.search.aggregations.Aggregations;
        assertNotNull(searchResponse);
        assertNotNull(multiResponse);
            XContentFactory.jsonBuilder()
            searchSourceBuilder.query(matchQueryBuilder);
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.action.support.WriteRequest;
            searchSourceBuilder.query(matchQuery("title", "OpenSearch"));
            double qualityLevel = evalQuality.metricScore();        // <3>  
            SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
            TermsAggregationBuilder aggregation = AggregationBuilders.terms("by_company")  
        };  
import org.opensearch.client.core.CountRequest;
                )
            searchSourceBuilder.query(QueryBuilders.matchAllQuery()); // <3>
            if (item.isFailure()) {
                        "The Future of Federated Search in OpenSearch",
            assertSame(RestStatus.OK, bulkResponse.status());
            assertNotNull(hits.getHits()[0].getSourceAsString());  
            request.add(new IndexRequest("posts").id("1").source(MediaTypeRegistry.JSON, "user", "foobar"));
            new IndexRequest("posts").id("2")
            List<String> scrollIds = Collections.singletonList(scrollId);
            {  
            SearchResponse searchResponse = client.search(searchRequest, RequestOptions.DEFAULT); // <1>
            SearchRequest searchRequest = new SearchRequest();
            // tag::search-scroll-execute-async
                }
        GetResult getResult = response.getGetResult(); // <7>
            SearchRequest searchRequest = new SearchRequest();
        // tag::field-caps-execute-async
                    assertEquals(1, fragments.length);
            // end::search-scroll-init
            scriptParams.put("value", searchTerm);  
                // tag::search-request-suggestion-get
            TimeValue took = searchResponse.getTook();
                List<Aggregation> aggregationList = aggregations.asList();  
import org.opensearch.action.search.MultiSearchRequest;  
                "  \"query\": { \"match\" : { \"{{field}}\" : \"{{value}}\" } }," +  
        // end::search-template-execute-async  
            "  \"script\": {" +
            sourceBuilder.timeout(new TimeValue(60, TimeUnit.SECONDS)); // <5>
            // Replace the empty listener by a blocking listener in test
import org.opensearch.index.rankeval.RankEvalSpec;
        indexSearchTestData();
            searchRequest.source(searchSourceBuilder);
                    "id",
import org.opensearch.action.index.IndexResponse;  
        // end::render-search-template-request
import java.util.List;  
        // tag::field-caps-response
        CountDownLatch latch = new CountDownLatch(1);  
            ActionListener<SearchResponse> listener = new ActionListener<SearchResponse>() {
        request.preference("_local"); // <1>
                    Arrays.asList("foobar", "quxx"),
                        "innerObject",
            // end::search-request-aggregations
            BulkRequest request = new BulkRequest();  
                        "innerObject",
        request.setProfile(true);
            assertEquals(1.0 / 3.0, qualityLevel, 0.0);
                String key = profilingResult.getKey(); // <3>
            SearchResponse searchResponse = client.search(searchRequest, RequestOptions.DEFAULT);
            assertNotNull(profileShardResult);
        assertThat(userResponse.keySet(), containsInAnyOrder("keyword", "text"));
        assertNotNull(searchResponse);
                    "user",  
        // end::search-template-request-stored
        RestHighLevelClient client = highLevelClient();
        BytesReference source = renderResponse.getSource(); // <1>
        // tag::search-template-execute
 *
            // tag::count-execute
            assertNotNull(hits.getHits()[0].getSourceAsMap().get("title"));
                new IndexRequest("posts").id("3")  
        String [] searchTerms = {"opensearch", "dashboards"};  
                } catch (ClassCastException ex) {
                Bucket elasticBucket = byCompanyAggregation.getBucketByKey("OpenSearch"); // <2>
        ActionListener<SearchTemplateResponse> listener = new ActionListener<SearchTemplateResponse>() {
            RatedRequest ratedRequest =                                   // <4>  
        );
 */
import org.opensearch.index.rankeval.RatedDocument;
            long numHits = totalHits.value();
                    .source(
        scriptParams.put("size", 5);
            assertNull(secondResponse.getFailure());  
                new IndexRequest("posts").id("1")  
                List<Object> users = (List<Object>) sourceAsMap.get("user");
            client.clearScrollAsync(request, RequestOptions.DEFAULT, listener); // <1>
            highlightBuilder.field(highlightUser);
            );
            while (searchHits != null && searchHits.length > 0) { // <2>
public class SearchDocumentationIT extends OpenSearchRestHighLevelClientTestCase {  
                    )  
import org.opensearch.core.rest.RestStatus;
                .startObject("user")  
                    // <2>
            SearchResponse searchResponse = client.search(searchRequest, RequestOptions.DEFAULT);
                    "user",
                for (SearchHit hit : hits.getHits()) {  
                    Text[] fragments = highlight.fragments();  
            assertTrue(latch.await(30L, TimeUnit.SECONDS));
                "  \"size\" : \"{{size}}\"" +
            assertNotNull(scrollId);  
                    new ActionListener<ClearScrollResponse>() {
        bulkRequest.add(
import java.util.Map;
            firstSearchRequest.source(searchSourceBuilder);
        client.msearchTemplateAsync(multiRequest, RequestOptions.DEFAULT, listener);
        // tag::multi-search-template-response  
    public void testSearchRequestHighlighting() throws IOException {
            };
            // tag::clear-scroll-add-scroll-id  
            // tag::rank-eval-request-basic  
                for (SearchHit hit : hits.getHits()) {
            MultiSearchRequest request = new MultiSearchRequest();    // <1>  
        request.fetchSourceContext(new FetchSourceContext(true, new String[]{"user"}, null)); // <1>
        request.indicesOptions(IndicesOptions.lenientExpandOpen()); // <1>  
                .startObject("user")
            // end::count-source-setter  
            ActionListener<CountResponse> listener =
        ActionListener<FieldCapabilitiesResponse> listener = new ActionListener<FieldCapabilitiesResponse>() {
                        "user",
            SearchScrollRequest scrollRequest = new SearchScrollRequest();  
            assertNotNull(countResponse);  
import org.opensearch.action.bulk.BulkRequest;
    }
                String index = hit.getIndex();  
                    @Override
        // end::search-template-request-options  
            request.add(firstSearchRequest);                          // <3>
        // end::search-template-request-inline
                        MediaTypeRegistry.JSON,
        // end::field-caps-request-indicesOptions
            }
            // end::search-request-highlighting
            AggregationProfileShardResult aggsProfileResults =  
                        (Map<String, Object>) sourceAsMap.get("innerObject");
import org.opensearch.search.Scroll;
        assertNotNull(source);
            }  
            request.add(
            SearchSourceBuilder searchQuery = new SearchSourceBuilder();
            sourceBuilder.sort(new ScoreSortBuilder().order(SortOrder.DESC)); // <1>  
import org.opensearch.client.RequestOptions;
 * not use this file except in compliance with the License.
            @Override
                new IndexRequest("posts").id("1")
                String sourceAsString = hit.getSourceAsString();
                    Collections.singletonList("foobar"),
            String scrollId = searchResponse.getScrollId(); // <3>  
            assertSame(RestStatus.OK, bulkResponse.status());
import org.opensearch.script.mustache.MultiSearchTemplateResponse.Item;
            // tag::search-hits-get
            RatedSearchHit ratedSearchHit = hitsAndRatings.get(2);  
        assertTrue(authorsResponse.isAcknowledged());
                    MediaTypeRegistry.JSON,  
import org.opensearch.client.RestHighLevelClient;
                Map<String, Object> sourceAsMap = hit.getSourceAsMap();  
            params.put("size", 5);  
        SearchResponse searchResponse = response.getResponse();
            // tag::count-request-basic
                    searchResponse.getProfileResults(); // <1>
                    }
        // end::field-caps-execute
    }
            IndexRequest request = new IndexRequest("posts").id("1").source(MediaTypeRegistry.JSON, "tags", "opensearch", "comments", 123);
            // end::search-scroll-example  
            request.setRefreshPolicy(WriteRequest.RefreshPolicy.WAIT_UNTIL);  
        // end::explain-request-source  
                // tag::search-request-highlighting-get
            request.add(new IndexRequest("posts").id("2").source(MediaTypeRegistry.JSON, "user", "quxx"));
import org.opensearch.index.get.GetResult;  
import org.opensearch.search.fetch.subphase.highlight.HighlightField;
                // end::search-request-profiling-queries-collectors
package org.opensearch.client.documentation;
            MultiSearchResponse.Item secondResponse = response.getResponses()[1];  // <4>
        registerQueryScript(restClient);
            request.setRequest(new SearchRequest("posts"));
        indexSearchTestData();
            }
        RestHighLevelClient client = highLevelClient();  
            assertSame(RestStatus.CREATED, indexResponse.status());
                .source(
            request.setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE);
    private static void indexCountTestData() throws IOException {
                .source(
    @SuppressWarnings("unused")  
                TermSuggestion termSuggestion = suggest.getSuggestion("suggest_user"); // <2>
 * specific language governing permissions and limitations
            SearchRequest searchRequest = new SearchRequest();  
            XContentFactory.jsonBuilder()  
            request.add(new IndexRequest("posts").id("3").source(MediaTypeRegistry.JSON, "company", "OpenSearch", "age", 40));
            public void onFailure(Exception e) {  
 */
            assertEquals(1, hits.getHits().length);
            countRequest.source(sourceBuilder);
                    "user",
            int successfulShards = countResponse.getSuccessfulShards();  
                    "innerObject",
                    MediaTypeRegistry.JSON,
            }
            SearchHit[] searchHits = hits.getHits();
            scriptParams.put("size", 5);
        }
import org.opensearch.search.aggregations.bucket.terms.Terms;  
            clearScrollRequest.addScrollId(scrollId);  
            assertTrue(latch.await(30L, TimeUnit.SECONDS));  
        // tag::explain-request-preference  
            // end::count-request-basic  
            // tag::search-source-basics  
                // tag::search-request-aggregations-asList
    }  
            searchRequest.source(searchSourceBuilder);
        bulkRequest.add(new IndexRequest("authors").id("1").source(MediaTypeRegistry.JSON, "id", 1, "user", "foobar"));
            scrollRequest.scrollId(scrollId);
            }  
                    .source(MediaTypeRegistry.JSON, "title", "In which order are my OpenSearch queries executed?")  
            // tag::search-execute-async  
        RestClient restClient = client();  
        request.setScriptType(ScriptType.INLINE);
import org.opensearch.common.xcontent.XContentFactory;  
    }
                .routing("routing") // <2>
        CreateIndexRequest reviewersRequest = new CreateIndexRequest("contributors").mapping(
            // tag::search-query-builders  
        // end::multi-search-template-execute
            List<RatedSearchHit> hitsAndRatings = evalQuality.getHitsAndRatings();
                public void onResponse(MultiSearchResponse response) {
