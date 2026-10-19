            for (ProfileResult profileResult : aggsProfileResults.getProfileResults()) { // <2>
                "  \"query\": { \"match\" : { \"{{field}}\" : \"{{value}}\" } }," +
            request.setRefreshPolicy(WriteRequest.RefreshPolicy.WAIT_UNTIL);
import org.opensearch.search.fetch.subphase.highlight.HighlightField;
                    assertThat(message, containsString("org.opensearch.search.aggregations.bucket.range.Range"));
                // tag::search-request-aggregations-asMap
            new IndexRequest("posts").id("2")
            source.utf8ToString()
        boolean exists = response.isExists(); // <3>
        SearchResponse searchResponse = multiResponse.getResponses()[0].getResponse().getResponse();
            assertEquals(3, hits.getTotalHits().value());
                // end::search-request-profiling-queries-collectors
        }
                }
                    Arrays.asList("foobar", "matt"),
import java.util.concurrent.CountDownLatch;
            MultiSearchResponse.Item firstResponse = response.getResponses()[0];   // <1>
                ProfileShardResult profileShardResult = profilingResult.getValue(); // <4>
    public void testMultiSearchTemplateWithInlineScript() throws Exception {
        {
        }
import org.opensearch.search.aggregations.Aggregations;
            } else {
                // failures should be handled here
            // the total number of hits, must be interpreted in the context of totalHits.relation
            // tag::search-request-indices
    }
            searchSourceBuilder.query(QueryBuilders.matchAllQuery()); // <3>
import static org.opensearch.index.query.QueryBuilders.matchQuery;
            long count = countResponse.getCount();
import java.util.Arrays;
            sourceBuilder.query(QueryBuilders.termQuery("user", "foobar")); // <2>
            highlightTitle.highlighterType("unified");  // <3>
                for (ProfileResult profileResult : queryProfileResult.getQueryResults()) { // <1>
                    // <1>
            // tag::search-execute-async
            // tag::search-source-filtering-off
        CountDownLatch latch = new CountDownLatch(1);
        {
            List<String> scrollIds = Collections.singletonList(scrollId);
                .startObject()
            assertEquals(3, hits.getTotalHits().value());
        indexSearchTestData();
            };
                // <2>
        assertEquals(RestStatus.OK.getStatus(), scriptResponse.getStatusLine().getStatusCode());
            );
                // end::search-request-aggregations-iterator
            // end::search-scroll-execute-sync
                .endObject()
public class SearchDocumentationIT extends OpenSearchRestHighLevelClientTestCase {
            SearchSourceBuilder sourceBuilder = new SearchSourceBuilder(); // <1>
                public void onResponse(SearchResponse searchResponse) {
            public void onFailure(Exception e) {
            assertNotNull(scrollId);
                @Override
        request.query(QueryBuilders.termQuery("user", "quuz"));
                .startObject("properties")
 * Modifications Copyright OpenSearch Contributors. See
    private static void indexCountTestData() throws IOException {
                }
        // tag::explain-request
            // end::clear-scroll-request
        assertTrue(reviewersResponse.isAcknowledged());
        MultiSearchTemplateRequest multiRequest = new MultiSearchTemplateRequest(); // <1>
                    "In which order are my OpenSearch queries executed?",
                String collectorName = collectorResult.getName();  // <2>
                Avg averageAge = elasticBucket.getAggregations().get("average_age"); // <3>
import org.opensearch.search.suggest.Suggest;
        request.setRequest(new SearchRequest("posts"));
            // end::search-scroll-execute-async
            ActionListener<ClearScrollResponse> listener =
        request.indicesOptions(IndicesOptions.lenientExpandOpen()); // <1>
        RestHighLevelClient client = highLevelClient();
            float maxScore = hits.getMaxScore();
                    public void onResponse(CountResponse countResponse) {
        bulkRequest.add(
            SearchResponse searchResponse = client.search(searchRequest, RequestOptions.DEFAULT); // <1>
            }
            SearchRequest searchRequest = new SearchRequest();
                    "user",
            SearchResponse initialSearchResponse = client.search(searchRequest, RequestOptions.DEFAULT);
                    "innerObject",
            // end::clear-scroll-execute-async
            // tag::search-request-profiling-get
            assertTrue(success);
        }
 * specific language governing permissions and limitations
            }
            sourceBuilder.from(0); // <3>
            // tag::clear-scroll-add-scroll-ids
        String [] searchTerms = {"opensearch", "dashboards"};
import org.opensearch.action.fieldcaps.FieldCapabilitiesResponse;
import org.opensearch.index.rankeval.RankEvalResponse;
            SearchHits hits = searchResponse.getHits();  // <4>
            assertNotNull(hits.getHits()[0].getSourceAsMap().get("title"));
                };
            searchSourceBuilder.suggest(suggestBuilder);
import org.opensearch.search.profile.query.QueryProfileShardResult;
                // <2>
 * ownership. Elasticsearch licenses this file to you under
            final CountDownLatch latch = new CountDownLatch(1);
            multiRequest.add(request);  // <3>
                .field("doc_values", "false")
 */
import org.opensearch.index.rankeval.PrecisionAtK;
                    "On Net Neutrality",
        assertTrue(isSearchable);
import org.opensearch.client.RequestOptions;
                    public void onFailure(Exception e) {
 *
            // tag::search-hits-info
            // Replace the empty listener by a blocking listener in test
    }
        String id = response.getId(); // <2>
        indexSearchTestData();
            searchRequest.source(searchSourceBuilder);
import static org.hamcrest.Matchers.equalTo;
            };
            // tag::clear-scroll-execute
            SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
                    "user",
                // tag::search-request-aggregations-iterator
                Bucket elasticBucket = byCompanyAggregation.getBucketByKey("OpenSearch"); // <2>
 * this work for additional information regarding copyright
                    Map<String, HighlightField> highlightFields = hit.getHighlightFields();
                .endObject()
                }
            MatchQueryBuilder matchQueryBuilder = new MatchQueryBuilder("user", "foobar"); // <1>
        ExplainRequest request = new ExplainRequest("contributors", "1");
            request.setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE);
        // end::explain-execute-listener
        Map<String, Object> scriptParams = new HashMap<>();
            request.add(
            assertEquals(1.0 / 3.0, qualityLevel, 0.0);
            // tag::search-query-setter
        listener = new LatchedActionListener<>(listener, latch);
                    Text[] fragments = highlight.fragments();  // <2>
            // end::search-source-basics
        // end::search-template-request-options
        // tag::explain-execute-async
            new IndexRequest("blog").id("1")
import org.opensearch.script.mustache.MultiSearchTemplateRequest;
            assertTrue(latch.await(30L, TimeUnit.SECONDS));
        assertTrue(latch.await(30L, TimeUnit.SECONDS));
        // tag::search-template-execute
            request.add(
import org.opensearch.index.rankeval.MetricDetail;
        assertTrue(searchResponse.getHits().getTotalHits().value() > 0);
import org.opensearch.search.aggregations.bucket.range.Range;
                @Override
                CollectorResult collectorResult = queryProfileResult.getCollectorResult();  // <1>
import org.opensearch.action.search.ClearScrollResponse;
            assertSame(RestStatus.OK, bulkResponse.status());
            request.addScrollId(scrollId); // <2>
        // tag::register-script
            ActionListener<SearchResponse> scrollListener =
                )
                searchResponse = client.scroll(scrollRequest, RequestOptions.DEFAULT);
        RestHighLevelClient client = highLevelClient();
            // end::rank-eval-execute
 * KIND, either express or implied.  See the License for the
                    MediaTypeRegistry.JSON,
        );
            // tag::multi-search-request-basic
            RankEvalResponse response = client.rankEval(request, RequestOptions.DEFAULT);
import org.opensearch.client.OpenSearchRestHighLevelClientTestCase;
import static org.hamcrest.Matchers.containsString;
                }
        MultiSearchTemplateResponse multiResponse = client.msearchTemplate(multiRequest, RequestOptions.DEFAULT);
                    "user",
            // end::search-source-setter
                    .source(MediaTypeRegistry.JSON, "title", "Current status and upcoming changes in OpenSearch")
        FieldCapabilities textCapabilities = userResponse.get("keyword");
        MultiSearchTemplateResponse multiResponse = client.msearchTemplate(multiRequest, RequestOptions.DEFAULT);
                    String message = ex.getMessage();
                )
import org.opensearch.index.get.GetResult;
import static org.hamcrest.Matchers.containsInAnyOrder;
                    // <1>
        );
        BulkResponse bulkResponse = highLevelClient().bulk(bulkRequest, RequestOptions.DEFAULT);
            // tag::search-source-setter
            scrollRequest.scroll(TimeValue.timeValueSeconds(60L)); // <1>
            new IndexRequest("posts").id("3")
        {
        }
            RestStatus status = searchResponse.status();
            listener = new LatchedActionListener<>(listener, latch);
                .endObject()
                // tag::search-request-aggregations-get
        // end::multi-search-template-response
        // Replace the empty listener by a blocking listener for tests.
            for (QueryProfileShardResult queryProfileResult : queryProfileShardResults) { // <2>
            searchRequest.indicesOptions(IndicesOptions.lenientExpandOpen()); // <1>
            String scrollId = initialSearchResponse.getScrollId();
            );
                    assertThat(fragments[0].string(), containsString("<em>foobar</em>"));
            // end::search-request-suggestion
    public void testSearchRequestAggregations() throws IOException {
import org.opensearch.search.aggregations.bucket.terms.Terms.Bucket;
import org.opensearch.script.ScriptType;
            // end::multi-search-execute-listener
                    "id",
            searchSourceBuilder.query(QueryBuilders.matchQuery("user", "foobar"));
                    "The Future of Federated Search in OpenSearch",
            // tag::search-request-suggestion
        // tag::field-caps-execute-async
            request.add(new IndexRequest("posts").id("2").source(MediaTypeRegistry.JSON, "company", "OpenSearch", "age", 30));
            SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
            public void onFailure(Exception e) {
            searchSourceBuilder.highlighter(highlightBuilder);
    protected void registerQueryScript(RestClient restClient) throws IOException {
                    assertThat(fragments[0].string(), containsString("<em>OpenSearch</em>"));
            final CountDownLatch clearScrollLatch = new CountDownLatch(1);
            // end::count-request-basic
                    "title",
        {
    public void testSearch() throws Exception {
                    List<ProfileResult> profiledChildren = profileResult.getProfiledChildren(); // <4>
            clearScrollRequest.addScrollId(scrollId);
            countRequest.source(searchSourceBuilder); // <4>
import java.io.IOException;
            SearchResponse searchResponse = client.search(searchRequest, RequestOptions.DEFAULT);
                .field("type", "keyword")
            "{" +
                        String suggestText = option.getText().string();
                searchResponse.getHits();
            ClearScrollResponse clearScrollResponse = client.clearScroll(clearScrollRequest, RequestOptions.DEFAULT);
            searchRequest.source(sourceBuilder);
        );
                .endObject()
            listener = new LatchedActionListener<>(listener, latch);
            // end::search-response-1
                    .source(MediaTypeRegistry.JSON, "title", "In which order are my OpenSearch queries executed?")
            // end::rank-eval-execute-async
            HighlightBuilder.Field highlightTitle =
import org.opensearch.script.mustache.MultiSearchTemplateResponse.Item;
            MultiSearchRequest request = new MultiSearchRequest();    // <1>
                QueryBuilders.boolQuery().should(matchQuery("title", "OpenSearch")).should(matchQuery("user", "foobar"))
import org.opensearch.common.unit.Fuzziness;
                    )
        // tag::explain-execute
                        Collections.singletonMap("key", "value")
            // end::multi-search-execute-async
            String scrollId = searchResponse.getScrollId();
import org.opensearch.search.sort.SortOrder;
            BulkResponse bulkResponse = client.bulk(request, RequestOptions.DEFAULT);
            Map<String, Object> scriptParams = new HashMap<>();
                .source(
 * GitHub history for details.
            request.add(new IndexRequest("posts").id("1").source(MediaTypeRegistry.JSON, "user", "foobar"));
            // end::search-request-indices
                    "innerObject",
            MultiSearchResponse.Item secondResponse = response.getResponses()[1];  // <4>
                // tag::search-request-suggestion-get
            List<QueryProfileShardResult> queryProfileShardResults =
                SearchScrollRequest scrollRequest = new SearchScrollRequest(scrollId); // <4>
            // Replace the empty listener by a blocking listener in test
        RestHighLevelClient client = highLevelClient();
        request.fetchSourceContext(new FetchSourceContext(true, new String[]{"user"}, null)); // <1>
            final CountDownLatch latch = new CountDownLatch(1);
import org.opensearch.index.rankeval.RatedRequest;
            scriptParams.put("value", searchTerm);
import org.opensearch.index.rankeval.RankEvalSpec;
                String id = hit.getId();
        FieldCapabilitiesResponse response = client.fieldCaps(request, RequestOptions.DEFAULT);
            sourceBuilder.sort(new ScoreSortBuilder().order(SortOrder.DESC)); // <1>
            // tag::count-request-args
    }
        bulkRequest.add(new IndexRequest("author").id("1").source(MediaTypeRegistry.JSON, "user", "foobar"));
        assertTrue(authorsResponse.isAcknowledged());
        bulkRequest.add(
        RestHighLevelClient client = highLevelClient();
                    HighlightField highlight = highlightFields.get("title");
            boolean succeeded = clearScrollResponse.isSucceeded();
            List<RatedSearchHit> hitsAndRatings = evalQuality.getHitsAndRatings();
            }
        {
            // end::search-request-highlighting
            request.add(new IndexRequest("posts").id("4").source(MediaTypeRegistry.JSON, "user", "corge"));
import org.opensearch.index.rankeval.EvaluationMetric;
        // tag::get-result
        // end::register-script
                        "user",
                new IndexRequest("posts").id("3")
            ActionListener<RankEvalResponse> listener = new ActionListener<RankEvalResponse>() {
            long numHits = totalHits.value();
                Long collectorTimeInMillis = collectorResult.getTime(); // <3>
            searchSourceBuilder.query(QueryBuilders.termQuery("tags", "opensearch"));
        client.searchTemplateAsync(request, RequestOptions.DEFAULT, listener); // <1>
        SearchTemplateResponse response = client.searchTemplate(request, RequestOptions.DEFAULT);
        assertTrue(match);
                // end::search-request-aggregations-asMap
                .field("doc_values", "false")
                    .source(
            // end::search-execute
            countRequest.source(sourceBuilder);
        Map<String, Object> params = new HashMap<>();
import org.opensearch.search.suggest.SuggestBuilder;
                String error = item.getFailureMessage(); // <2>
            // tag::clear-scroll-request
            assertNull(firstResponse.getFailure());                                // <2>
        // end::explain-execute-async
 * Licensed to Elasticsearch under one or more contributor
                    // <2>
            double evaluationResult = response.getMetricScore();   // <1>
            Boolean terminatedEarly = searchResponse.isTerminatedEarly();
            .fields("user")
                        "In which order are my OpenSearch queries executed?",
        }
            matchQueryBuilder.prefixLength(3); // <2>
            // tag::search-execute-listener
            assertEquals("3", ratedSearchHit.getSearchHit().getId());   // <4>
                for (SearchHit hit : hits.getHits()) {
            scrollId = searchScrollResponse.getScrollId();  // <2>
        {
        bulkRequest.add(
            {
            @Override
                    "user",
            request.add(new IndexRequest("posts").id("3").source(MediaTypeRegistry.JSON, "company", "OpenSearch", "age", 40));
            // end::search-request-indicesOptions
                    .field("age"));
        assertThat(fields.get("user").getValue(), equalTo("quuz"));
        SearchResponse searchResponse = multiResponse.getResponses()[0].getResponse().getResponse();
                    Text[] fragments = highlight.fragments();
                SearchResponse searchResponse = searchTemplateResponse.getResponse();
            // end::search-hits-singleHit
                    "innerObject",
            searchRequest.source(searchSourceBuilder); // <4>
        }
        // end::explain-request-stored-field
        SearchResponse searchResponse = response.getResponse();
import org.opensearch.index.rankeval.RankEvalRequest;
            // Replace the empty listener by a blocking listener in test
                new IndexRequest("posts").id("1")
            client.searchAsync(searchRequest, RequestOptions.DEFAULT, listener); // <1>
            request.setScriptType(ScriptType.STORED);
import org.opensearch.core.common.bytes.BytesReference;
            suggestBuilder.addSuggestion("suggest_user", termSuggestionBuilder); // <2>
        assertArrayEquals(indices, new String[] { "authors", "contributors" });
        request.setSimulate(true); // <1>
            @Override
        assertTrue(hasExplanation);
            IndexRequest request = new IndexRequest("posts").id("1").source(MediaTypeRegistry.JSON, "tags", "opensearch", "comments", 123);
                    // <2>
        // tag::multi-search-template-execute
            public void onResponse(ExplainResponse explainResponse) {
        }
        boolean isSearchable = textCapabilities.isSearchable();
                new IndexRequest("posts").id("3").source(MediaTypeRegistry.JSON, "title", "The Future of Federated Search in OpenSearch")
            client.msearchAsync(request, RequestOptions.DEFAULT, listener); // <1>
                .endObject()
        );
        listener = new LatchedActionListener<>(listener, latch);
 */
            SearchRequest searchRequest = new SearchRequest("posts"); // <1>
import org.opensearch.client.Request;
import org.opensearch.index.rankeval.RatedDocument;
            RestStatus status = countResponse.status();
                new IndexRequest("posts").id("2")
        indexSearchTestData();
                    )
import org.opensearch.search.profile.ProfileShardResult;
            public void onResponse(FieldCapabilitiesResponse response) {
            // end::multi-search-execute
                float score = hit.getScore();
            CountRequest countRequest = new CountRequest("blog") // <1>
            };
                    long queryTimeInMillis = profileResult.getTime(); // <3>
            searchRequest.scroll(scroll);
            Boolean terminatedEarly = countResponse.isTerminatedEarly();
            MultiSearchResponse response = client.msearch(request, RequestOptions.DEFAULT);
            Map<String, Object> params = new HashMap<>();
            "      \"size\" : \"{{size}}\"" +
import org.opensearch.action.explain.ExplainRequest;
            request.setRequest(new SearchRequest("posts"));
        CreateIndexResponse reviewersResponse = highLevelClient().indices().create(reviewersRequest, RequestOptions.DEFAULT);
        }
        MultiSearchTemplateRequest multiRequest = new MultiSearchTemplateRequest();
        {
            }
            ClearScrollRequest clearScrollRequest = new ClearScrollRequest();
            HighlightBuilder.Field highlightUser = new HighlightBuilder.Field("user");
                Suggest suggest = searchResponse.getSuggest(); // <1>
        // tag::search-template-execute-listener
import org.opensearch.action.search.ClearScrollRequest;
import org.opensearch.client.Response;
                    "XYZ Joins Forces with OpenSearch",
                .endObject()
            // end::search-scroll-execute-listener
        SearchTemplateResponse renderResponse = client.searchTemplate(request, RequestOptions.DEFAULT);
            );
package org.opensearch.client.documentation;
 * Unless required by applicable law or agreed to in writing,
            searchSourceBuilder.query(matchQueryBuilder);
                    MediaTypeRegistry.JSON,
    }
            assertTrue(clearScrollResponse.isSucceeded());
            "      \"query\": { \"match\" : { \"{{field}}\" : \"{{value}}\" } }," +
            // end::count-response-1
                    "title",
        RestHighLevelClient client = highLevelClient();
    public void testFieldCaps() throws Exception {
        request.setProfile(true);
                // tag::search-hits-singleHit-source
            // end::clear-scroll-add-scroll-ids
                Map<String, Object> innerObject =
                public void onResponse(SearchResponse searchResponse) {
                String documentTitle = (String) sourceAsMap.get("title");
                    MediaTypeRegistry.JSON,
            assertEquals(PrecisionAtK.NAME, metricName);                // <6>
                // tag::search-request-profiling-queries-collectors
        bulkRequest.add(
                    highlight = highlightFields.get("user");
            // tag::search-hits-get
        // Replace the empty listener by a blocking listener for tests.
                .startObject("user")
            // tag::rank-eval-execute-async
                    Collections.singletonMap("key", "value")
                try {
import org.opensearch.index.query.QueryBuilder;
                .startObject("id")
            // tag::search-scroll2
import org.opensearch.common.document.DocumentField;
                // failures should be handled here
        assertThat(source, equalTo(Collections.singletonMap("user", "quuz")));
            request.setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE);
            BulkRequest request = new BulkRequest();
                public void onResponse(ClearScrollResponse clearScrollResponse) {
            assertFalse(bulkResponse.hasFailures());
                        (Map<String, Object>) sourceAsMap.get("innerObject");
                    }
            // end::search-query-builder-options
        CreateIndexResponse authorsResponse = highLevelClient().indices().create(authorsRequest, RequestOptions.DEFAULT);
        assertFalse(bulkResponse.hasFailures());
            }
        request.storedFields(new String[]{"user"}); // <1>
        // end::explain-request-preference
        // end::search-template-execute-listener
            "    \"lang\": \"mustache\"," +
import org.opensearch.search.sort.FieldSortBuilder;
    }
                // <1>
            assertEquals(0, searchResponse.getFailedShards());
        ActionListener<FieldCapabilitiesResponse> listener = new ActionListener<FieldCapabilitiesResponse>() {
        // end::multi-search-template-request-sync
            hits = searchScrollResponse.getHits(); // <3>
        assertNotNull(multiResponse.getResponses()[0]);
            // end::rank-eval-response
        request.setScriptType(ScriptType.STORED);
                .endObject()
            assertEquals(1, hits.getHits().length);
                @Override
        boolean match = response.isMatch(); // <4>
        String index = response.getIndex(); // <1>
                public void onFailure(Exception e) {
                    HighlightField highlight = highlightFields.get("title"); // <1>
            }
            // end::search-request-aggregations
            new IndexRequest("blog").id("2")
                        MediaTypeRegistry.JSON,
            secondSearchRequest.source(searchSourceBuilder);
        client.msearchTemplateAsync(multiRequest, RequestOptions.DEFAULT, listener);
import org.opensearch.core.rest.RestStatus;
            {
            int successfulShards = searchResponse.getSuccessfulShards();
            }
        // tag::multi-search-template-request-sync
        scriptRequest.setJsonEntity(
            );
            ActionListener<MultiSearchResponse> listener = new ActionListener<MultiSearchResponse>() {
            assertNull(hits.getHits()[0].getSourceAsMap().get("user"));
                }
            searchRequest.indices("posts");
            SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder(); // <2>
            // tag::clear-scroll-execute-listener
        scriptParams.put("field", "title");
        RestHighLevelClient client = highLevelClient();
        assertEquals(
            ActionListener<SearchResponse> listener = new ActionListener<SearchResponse>() {
            request.setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE);
            listener = new LatchedActionListener<>(listener, clearScrollLatch);
                    "title",
            @Override
                    "Current status and upcoming changes in OpenSearch",
            client.scrollAsync(scrollRequest, RequestOptions.DEFAULT, scrollListener); // <1>
            // tag::count-execute
        assertTrue(authorsResponse.isAcknowledged());
                                                            .fuzziness(Fuzziness.AUTO)
            searchSourceBuilder.size(size); // <1>
        };
        }
                    new HighlightBuilder.Field("title"); // <2>
        ActionListener<SearchTemplateResponse> listener = new ActionListener<SearchTemplateResponse>() {
    public void testSearchRequestSuggestions() throws IOException {
            }
                    // end::search-request-aggregations-get-wrongCast
        {
            // end::search-request-preference
            SearchRequest searchRequest = new SearchRequest();
        indexSearchTestData();
                    )
                    .field("company.keyword");
            request.setRequest(new SearchRequest("posts"));
            // tag::search-query-builders
            SearchRequest searchRequest = new SearchRequest();
        ActionListener<MultiSearchTemplateResponse> listener = new ActionListener<MultiSearchTemplateResponse>() {
            // end::rank-eval-execute-listener
            // end::count-execute-listener
import org.opensearch.search.builder.SearchSourceBuilder;
            RatedRequest ratedRequest =                                   // <4>
    }
            // tag::search-scroll-execute-async
        RestClient restClient = client();
            MetricDetail metricDetails = evalQuality.getMetricDetails();
        assertFalse(bulkResponse.hasFailures());
                @Override
            assertSame(RestStatus.CREATED, indexResponse.status());
                    // <1>
        String[] nonAggregatableIndices = textCapabilities.nonAggregatableIndices();//<4>
        RestClient restClient = client();
                    1,
                // end::search-hits-singleHit-properties
            List<RatedDocument> ratedDocs = new ArrayList<>();
            {
                // <1>
            // end::rank-eval-request-basic
import java.util.HashMap;
        request.setScriptParams(scriptParams); // <3>
        scriptParams.put("size", 5);
            for (QueryProfileShardResult queryProfileResult : queryProfileShardResults) {
        ActionListener<ExplainResponse> listener = new ActionListener<ExplainResponse>() {
 *
                        "innerObject",
            // tag::search-request-basic
                        MediaTypeRegistry.JSON,
            ProfileShardResult profileShardResult = profilingResults.values().iterator().next();
import org.apache.lucene.search.TotalHits;
            request.add(
            // tag::search-query-builder-options
            // end::search-request-profiling-aggs
            SearchResponse searchResponse = client.scroll(scrollRequest, RequestOptions.DEFAULT);
        RestHighLevelClient client = highLevelClient();
            // whether the number of hits is accurate (EQUAL_TO) or a lower bound of the total (GREATER_THAN_OR_EQUAL_TO)
            searchSourceBuilder.aggregation(aggregation);
                // <2>
        // end::multi-search-template-request-inline
            sourceBuilder.fetchSource(true);
    @SuppressWarnings({ "unused" })
        assertTrue(exists);
import org.opensearch.search.profile.query.CollectorResult;
            ratedDocs.add(new RatedDocument("posts", "1", 1));            // <2>
            }
                    new RankEvalSpec(ratedRequests, metric);              // <5>
            SearchSourceBuilder searchQuery = new SearchSourceBuilder();
            // tag::search-request-routing
import static org.hamcrest.Matchers.greaterThan;
    @SuppressWarnings("unused")
                    "title",
                    @Override
                List<CollectorResult> profiledChildren = collectorResult.getProfiledChildren(); // <4>
            // tag::rank-eval-execute
            // end::search-source-sorting
        // end::render-search-template-request
            // end::count-response-2
        // tag::search-template-execute-async
            // tag::multi-search-execute-listener
        // tag::field-caps-response
import org.opensearch.client.core.CountResponse;
            searchSourceBuilder.query(QueryBuilders.matchAllQuery()); // <3>
                        "user",
                .startObject("user")
            // end::search-request-routing
import org.opensearch.action.index.IndexRequest;
            String scrollId = searchResponse.getScrollId(); // <3>
            assertThat(released, greaterThan(0));
        // end::get-result
        // end::multi-search-template-execute
            assertEquals(1.0 / 3.0, evaluationResult, 0.0);
            // tag::rank-eval-response
        }
        // tag::explain-request-stored-field
            // tag::search-query-builder-ctor
            ClearScrollResponse response = client.clearScroll(request, RequestOptions.DEFAULT);
        for (String searchTerm : searchTerms) {
        }
                )
            request.setScrollIds(scrollIds);
            // Replace the empty listener by a blocking listener in test
        RestHighLevelClient client = highLevelClient();
        bulkRequest.setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE);
            XContentFactory.jsonBuilder()
import org.opensearch.search.fetch.subphase.FetchSourceContext;
            request.setScriptParams(params);
            while (searchHits != null && searchHits.length > 0) { // <2>
            // tag::multi-search-execute
            TotalHits.Relation relation = totalHits.relation();
                    "id",
        }
                        long numberOfDocs = elasticBucket.getDocCount();
        request.setRequest(new SearchRequest("posts")); // <1>
                .startObject()
        // end::explain-execute
            for (SearchHit hit : searchHits) {
                )
            }
            @Override
        // tag::render-search-template-request
            ClearScrollRequest request = new ClearScrollRequest(); // <1>
import org.opensearch.search.suggest.term.TermSuggestion;
            // tag::search-scroll-example
                    String fragmentString = fragments[0].string();
                        // <1>
                    Collections.singletonMap("key", "value")
import org.opensearch.action.index.IndexResponse;
        {
    public void testExplain() throws Exception {
            SearchRequest searchRequest = new SearchRequest();
            XContentFactory.jsonBuilder()
import org.opensearch.core.action.ActionListener;
            assertFalse(bulkResponse.hasFailures());
        }
            params.put("field", "title");
        String [] searchTerms = {"opensearch", "opensearch-dashboards"};
            // end::search-execute-listener
import org.opensearch.search.aggregations.Aggregation;
import org.opensearch.common.unit.TimeValue;
            searchResponse = secondResponse.getResponse();
        client.fieldCapsAsync(request, RequestOptions.DEFAULT, listener); // <1>
        // tag::field-caps-request-indicesOptions
            @Override
                for (Aggregation agg : aggregations) {
            searchRequest.source(searchSourceBuilder);
            searchRequest.source(searchSourceBuilder);
        }
    }
        {
                Aggregations aggregations = searchResponse.getAggregations();
import org.opensearch.search.aggregations.AggregationBuilders;
                }
        {
            // end::clear-scroll-add-scroll-id
import org.apache.lucene.search.Explanation;
        );
            for (SearchHit hit : searchHits) {
            }
            // end::search-request-profiling
        };
            SearchResponse searchResponse = client.search(searchRequest, RequestOptions.DEFAULT);
                    }
            request.setScriptParams(scriptParams);
            // tag::clear-scroll-add-scroll-id
        // tag::field-caps-execute
            // tag::search-request-profiling-queries
            int failedShards = searchResponse.getFailedShards();
            searchRequest.source(searchSourceBuilder);
        bulkRequest.add(new IndexRequest("contributors").id("1").source(MediaTypeRegistry.JSON, "id", 1, "user", "quuz"));
            // end::search-hits-info
            SearchHits hits = searchResponse.getHits();
            final CountDownLatch latch = new CountDownLatch(1);
        // tag::explain-request-source
        request.setScript( // <2>
        Request scriptRequest = new Request("POST", "/_scripts/title_search");
            String[] excludeFields = new String[] {"user"};
                }
        }
            // tag::search-source-basics
            searchRequest.source(searchSourceBuilder);
import org.opensearch.search.suggest.SuggestBuilders;
        request.setExplain(true);
import org.opensearch.action.search.SearchResponse;
        assertSame(RestStatus.OK, bulkResponse.status());
            for (ShardSearchFailure failure : searchResponse.getShardFailures()) {
            // tag::rank-eval-execute-listener
            aggregation.subAggregation(AggregationBuilders.avg("average_age")
    }
        }
                .source(
        SearchTemplateRequest request = new SearchTemplateRequest();
import java.util.List;
        }
            // tag::search-request-highlighting
        params.put("size", 5);
        request.setScriptParams(params);
        // end::search-template-request-inline
import org.opensearch.client.RestClient;
            TotalHits totalHits = hits.getTotalHits();
    public void testSearchRequestProfiling() throws IOException {
            assertFalse(ratedSearchHit.getRating().isPresent());        // <5>
                }
import org.opensearch.script.mustache.SearchTemplateRequest;
    }
            for (ShardSearchFailure failure : countResponse.getShardFailures()) {
            SearchRequest searchRequest = new SearchRequest(); // <1>
                .field("type", "keyword")
            {
        assertNotNull(multiResponse.getResponses()[0]);
        assertNotNull(getResult);
        CreateIndexResponse authorsResponse = highLevelClient().indices().create(authorsRequest, RequestOptions.DEFAULT);
            TimeValue took = searchResponse.getTook();
                        Arrays.asList("foobar", "grault"),
            int skippedShards = countResponse.getSkippedShards();
            assertEquals(3, detail.getRetrieved());
            scriptParams.put("size", 5);
        BytesReference source = renderResponse.getSource(); // <1>
import org.opensearch.action.bulk.BulkRequest;
        GetResult getResult = response.getGetResult(); // <7>
import org.opensearch.search.fetch.subphase.highlight.HighlightBuilder;
                    assertEquals(1, fragments.length);
                SuggestBuilders.termSuggestion("user").text("fooarb"); // <1>
                    .source(
            HighlightBuilder highlightBuilder = new HighlightBuilder(); // <1>
                        "innerObject",
    }
    @SuppressWarnings("unused")
 * Code wrapped in {@code tag} and {@code end} tags is included in the docs.
                .startObject("id")
            "  }" +
                    "title",
            request.setScriptType(ScriptType.INLINE);
import org.opensearch.search.SearchHits;
        }
                    assertEquals(1, fragments.length);
                    partialResults.get("foobar_query");                 // <2>
        {
                // tag::search-request-highlighting-get
                    }
            params.put("value", searchTerm);
            SearchScrollRequest scrollRequest = new SearchScrollRequest(scrollId); // <1>
            // tag::rank-eval-request-basic
            // end::count-execute
import org.opensearch.action.bulk.BulkResponse;
            "    \"source\": {" +
            // tag::count-source-basics
                // tag::search-hits-singleHit-properties
                List<Object> users = (List<Object>) sourceAsMap.get("user");
                @Override
            // end::search-scroll-init
            };
        // tag::multi-search-template-request-stored
                .endObject()
    public void testSearchTemplateWithStoredScript() throws Exception {
            assertEquals(4, searchResponse.getHits().getTotalHits().value());
        {
            {
            // end::multi-search-response
        );
 * compatible open source license.
            IndexResponse indexResponse = client.index(request, RequestOptions.DEFAULT);
            boolean success = response.isSucceeded(); // <1>
            // end::search-scroll-example
                // end::search-request-aggregations-get
        indexSearchTestData();
            assertThat(aggsProfileResults.getProfileResults().size(), equalTo(1));
            matchQueryBuilder.fuzziness(Fuzziness.AUTO); // <1>
            assertEquals(1, hits.getHits().length);
            // end::count-request-args
            assertTrue(latch.await(30L, TimeUnit.SECONDS));
            assertTrue(latch.await(30L, TimeUnit.SECONDS));
        assertNotNull(searchResponse);
        indexCountTestData();
                    Collections.singletonList("foobar"),
                // tag::search-request-aggregations-asList
        client.explainAsync(request, RequestOptions.DEFAULT, listener); // <1>
            searchSourceBuilder.query(matchQuery("title", "OpenSearch"));
            assertFalse(bulkResponse.hasFailures());
                public void onResponse(RankEvalResponse response) {
        // tag::explain-response
                    }
            // tag::count-response-2
                }
    public void testMultiSearch() throws Exception {
            // end::search-hits-get
        // end::search-template-request-stored
            Aggregations aggregations = searchResponse.getAggregations();
            CountRequest countRequest = new CountRequest(); // <1>
import org.opensearch.index.query.QueryBuilders;
        boolean hasExplanation = response.hasExplanation(); // <5>
            params.put("size", 5);
                    Map<String, HighlightField> highlightFields = hit.getHighlightFields();
            BulkResponse bulkResponse = client.bulk(request, RequestOptions.DEFAULT);
            assertSame(RestStatus.OK, bulkResponse.status());
                        "Current status and upcoming changes in OpenSearch",
            if (item.isFailure()) {
            public void onResponse(MultiSearchTemplateResponse response) {
            assertEquals(3, numHits);
            // tag::search-source-sorting
            ClearScrollResponse clearScrollResponse = client.clearScroll(clearScrollRequest, RequestOptions.DEFAULT);
                    new RatedRequest("foobar_query", ratedDocs, searchQuery);
            CountResponse countResponse = client
        // tag::field-caps-request
        // end::field-caps-execute-listener
                )
            // tag::search-response-1
                // end::search-request-highlighting-get
        // tag::search-template-request-stored
                        "title",
        }
            "{" +
        registerQueryScript(restClient);
            SearchTemplateRequest request = new SearchTemplateRequest();  // <2>
import org.opensearch.action.explain.ExplainResponse;
            searchSourceBuilder.aggregation(AggregationBuilders.histogram("by_comments").field("comments").interval(100));
        // end::multi-search-template-request-stored
                }
        assertFalse(isAggregatable);
 * license agreements. See the NOTICE file distributed with
            );
        Response scriptResponse = restClient.performRequest(scriptRequest);
            searchRequest.preference("_local"); // <1>
                    MediaTypeRegistry.JSON,
                long aggTimeInMillis = profileResult.getTime(); // <4>
            ClearScrollRequest clearScrollRequest = new ClearScrollRequest(); // <5>
            SearchRequest secondSearchRequest = new SearchRequest();  // <4>
            public void onFailure(Exception e) {
                .preference("_local"); // <4>
            "}");
                .startObject("user")
            searchSourceBuilder = new SearchSourceBuilder();
            final CountDownLatch latch = new CountDownLatch(1);
                    .source(
        // end::explain-request-source
            String metricName = metricDetails.getMetricName();
                    String type = agg.getType();
            assertEquals(TotalHits.Relation.EQUAL_TO, relation);
            assertEquals("foobar_query", evalQuality.getId());
                String sourceAsString = hit.getSourceAsString();
import java.util.ArrayList;
 * SPDX-License-Identifier: Apache-2.0
            "    }" +
        CountDownLatch latch = new CountDownLatch(1);
    }
            scrollRequest.scroll("60s"); // <2>
                    3,
            EvalQueryQuality evalQuality =
            EvaluationMetric metric = new PrecisionAtK();                 // <1>
            // end::multi-search-request-basic
    }
            multiRequest.add(request);
            searchQuery.query(QueryBuilders.matchQuery("user", "foobar"));// <3>
                    Collections.singletonMap("key", "value")
            SuggestionBuilder termSuggestionBuilder =
                .startObject("properties")
        // end::search-template-execute
                        Bucket elasticBucket = ((Terms) agg).getBucketByKey("OpenSearch");
            @Override
            // tag::search-request-indicesOptions
        // tag::explain-request-routing
            }
            SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder(); // <2>
            public void onResponse(SearchTemplateResponse response) {
 */
                    MediaTypeRegistry.JSON,
import org.opensearch.script.mustache.SearchTemplateResponse;
    @SuppressWarnings({ "unused", "unchecked" })
 * not use this file except in compliance with the License.
                    new ActionListener<ClearScrollResponse>() {
            request.add(
                    response.getPartialResults();
    private void indexSearchTestData() throws IOException {
                    "innerObject",
            // tag::search-hits-singleHit
            ("{  \"size\" : \"5\",  \"query\": { \"match\" : { \"title\" : \"opensearch\" } }}").replaceAll("\\s+", ""),
            BulkRequest request = new BulkRequest();
/**
                TermSuggestion termSuggestion = suggest.getSuggestion("suggest_user"); // <2>
                "  \"size\" : \"{{size}}\"" +
            clearScrollRequest.addScrollId(scrollId);
                @Override
        {
                    @Override
            int totalShards = countResponse.getTotalShards();
        for (Item item : multiResponse.getResponses()) { // <1>
                Terms byCompanyAggregation = aggregations.get("by_company"); // <1>
            final Scroll scroll = new Scroll(TimeValue.timeValueMinutes(1L));
            final CountDownLatch latch = new CountDownLatch(1);
            @Override
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            double qualityLevel = evalQuality.metricScore();        // <3>
                        Collections.singletonMap("key", "value")
import java.util.Map;
            // end::search-response-2
            SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
                    fragments = highlight.fragments();
/*
            SearchSourceBuilder sourceBuilder = new SearchSourceBuilder(); // <1>
            SearchScrollRequest scrollRequest = new SearchScrollRequest();
        );
        bulkRequest.add(new IndexRequest("authors").id("1").source(MediaTypeRegistry.JSON, "id", 1, "user", "foobar"));
        SearchResponse searchResponse = response.getResponse();
                }
                .indicesOptions(IndicesOptions.lenientExpandOpen()) // <3>
                    // <2>
        // end::explain-response
            ActionListener<CountResponse> listener =
            SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
            assertFalse(bulkResponse.hasFailures());
                @Override
            assertNotNull(scrollId);
            // tag::count-request-basic
        RestHighLevelClient client = highLevelClient();
        CreateIndexRequest authorsRequest = new CreateIndexRequest("authors").mapping(
    @SuppressWarnings("unused")
            AggregationProfileShardResult aggsProfileResults =
                searchHits = searchResponse.getHits().getHits();
    public void testSearchTemplateWithInlineScript() throws Exception {
            SearchResponse searchResponse = client.search(searchRequest, RequestOptions.DEFAULT);
        Explanation explanation = response.getExplanation(); // <6>
        // end::field-caps-execute
                                                            .maxExpansions(10);
            RatedSearchHit ratedSearchHit = hitsAndRatings.get(2);
import org.opensearch.action.LatchedActionListener;
        }
                    // <2>
        assertNotNull(explanation);
                // end::search-request-profiling-queries-results
import org.opensearch.action.support.WriteRequest;
        CreateIndexRequest reviewersRequest = new CreateIndexRequest("contributors").mapping(
            // tag::search-source-filtering-includes
            request.setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE);
        params.put("field", "title");
        assertNotNull(source);
        BulkResponse bulkResponse = highLevelClient().bulk(bulkRequest, RequestOptions.DEFAULT);
            }
                .source(
        indexSearchTestData();
            // tag::search-scroll-execute-listener
        registerQueryScript(restClient);
                        MediaTypeRegistry.JSON,
 * under the License.
            };
                    profileShardResult.getQueryProfileResults(); // <1>
            SearchResponse searchResponse = client.search(searchRequest, RequestOptions.DEFAULT);
    public void testCount() throws Exception {
        // tag::search-template-request-inline
                "}");
import org.opensearch.index.rankeval.RatedSearchHit;
        CountDownLatch latch = new CountDownLatch(1);
import org.opensearch.action.search.ShardSearchFailure;
        );
                    // <1>
                }
                .count(countRequest, RequestOptions.DEFAULT);
                    if (type.equals(TermsAggregationBuilder.NAME)) {
            client.clearScrollAsync(request, RequestOptions.DEFAULT, listener); // <1>
            }
import org.opensearch.common.xcontent.XContentFactory;
import org.opensearch.client.RestHighLevelClient;
            XContentFactory.jsonBuilder()
            // tag::multi-search-execute-async
            sourceBuilder.timeout(new TimeValue(60, TimeUnit.SECONDS)); // <5>
            );
                .source(
        // tag::search-template-request-options
            searchRequest.scroll("60s");
            Map<String, ProfileShardResult> profilingResults =
            List<RatedRequest> ratedRequests = Arrays.asList(ratedRequest);
            int totalShards = searchResponse.getTotalShards();
        // tag::explain-execute-listener
                    Arrays.asList("foobar", "grault"),
        Map<String, DocumentField> fields = getResult.getFields(); // <2>
            // end::clear-scroll-response
            {
                for (SearchHit hit : hits.getHits()) {
                // end::search-request-suggestion-get
        {
                List<ProfileResult> profiledChildren = profileResult.getProfiledChildren(); // <5>
        }
        for (String searchTerm : searchTerms) {
            sourceBuilder.size(5); // <4>
        CreateIndexRequest authorsRequest = new CreateIndexRequest("author").mapping(
            // tag::count-execute-listener
            // tag::clear-scroll-response
            assertNotNull(hits.getHits()[0].getSourceAsMap().get("innerObject"));
        assertNull(nonSearchableIndices);
                scrollRequest.scroll(scroll);
        assertThat(id, equalTo("1"));
            SearchResponse searchResponse = firstResponse.getResponse();           // <3>
    @SuppressWarnings("unused")
        // tag::multi-search-template-execute-async
            RankEvalRequest request =                                     // <6>
import org.opensearch.core.xcontent.MediaTypeRegistry;
            boolean timedOut = searchResponse.isTimedOut();
                    searchResponse.getProfileResults(); // <1>
            // end::search-request-basic
    public void testSearchRequestHighlighting() throws IOException {
                    String queryName = profileResult.getQueryName(); // <2>
            // Replace the empty listener by a blocking listener in test
                List<Aggregation> aggregationList = aggregations.asList();
            "  \"size\" : \"{{size}}\"" +
            matchQueryBuilder.maxExpansions(10); // <3>
                .endObject()
            countRequest.indices("blog", "author");
            "  \"query\": { \"match\" : { \"{{field}}\" : \"{{value}}\" } }," +
                    "id",
            client.countAsync(countRequest, RequestOptions.DEFAULT, listener); // <1>
                    for (TermSuggestion.Entry.Option option : entry) { // <4>
                // end::search-hits-singleHit-source
            // tag::search-request-profiling-aggs
            SearchResponse searchResponse = client.search(searchRequest, RequestOptions.DEFAULT);
        }
            }
            SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
import org.opensearch.action.search.SearchScrollRequest;
            Map<String, EvalQueryQuality> partialResults =
                    new ActionListener<SearchResponse>() {
            @Override
        indexSearchTestData();
            int failedShards = countResponse.getFailedShards();
        params.put("value", "opensearch");
                .field("type", "keyword")
        listener = new LatchedActionListener<>(listener, latch);
            // tag::multi-search-response
            // tag::count-execute-async
            SearchHit[] searchHits = searchResponse.getHits().getHits();
                        "innerObject",
        };
        // end::render-search-template-response
            // end::count-execute-async
                double avg = averageAge.getValue();
    }
            assertSame(RestStatus.OK, bulkResponse.status());
            searchRequest.routing("routing"); // <1>
import org.opensearch.client.indices.CreateIndexResponse;
        request.preference("_local"); // <1>
import org.opensearch.action.search.MultiSearchRequest;
                String aggName = profileResult.getQueryName(); // <3>
                public void onResponse(MultiSearchResponse response) {
            request.add(
                    "innerObject",
            assertNotNull(countResponse);
            assertEquals(3L, searchResponse.getHits().getTotalHits().value());
                .endObject()
        );
        // end::field-caps-request-indicesOptions
            SearchRequest searchRequest = new SearchRequest("posts");
            highlightBuilder.field(highlightUser);
                new IndexRequest("posts").id("2")
            assertTrue(clearScrollLatch.await(30L, TimeUnit.SECONDS));
            listener = new LatchedActionListener<>(listener, latch);
            SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
 * this file be licensed under the Apache-2.0 license or a
        assertArrayEquals(nonAggregatableIndices, new String[] { "authors" });
            int size = 1;
        BulkRequest bulkRequest = new BulkRequest();
                SearchTemplateResponse searchTemplateResponse = item.getResponse(); // <3>
    @SuppressWarnings({ "unused", "rawtypes" })
            searchRequest.source(searchSourceBuilder);
    @SuppressWarnings({ "unused", "unchecked" })
import org.opensearch.action.search.SearchRequest;
            // tag::search-scroll-execute-sync
import org.opensearch.action.support.IndicesOptions;
                Terms companyAggregation = (Terms) aggregationMap.get("by_company");
                    "innerObject",
                    Collections.singletonMap("key", "value")
        {
        listener = new LatchedActionListener<>(listener, latch);
        assertNotNull(multiResponse);
}
                .field("type", "keyword")
 * You may obtain a copy of the License at
        assertEquals(searchTerms.length, multiResponse.getResponses().length);
            firstSearchRequest.source(searchSourceBuilder);
        // end::field-caps-response
        assertTrue(searchResponse.getHits().getTotalHits().value() > 0);
        // tag::multi-search-template-execute-listener
            listener = new LatchedActionListener<>(listener, latch);
import org.opensearch.script.mustache.MultiSearchTemplateResponse;
            // end::search-scroll2
                .source(
                assertEquals(30, avg, 0.0);
            SearchHit[] searchHits = hits.getHits();
            searchSourceBuilder.query(QueryBuilders.matchQuery("user", "quxx"));
import java.util.concurrent.TimeUnit;
                    Arrays.asList("tyler", "foobar"),
        Map<String, Object> source = getResult.getSource(); // <1>
            new IndexRequest("blog").id("3")
                }
            new IndexRequest("posts").id("1")
            assertNotNull(profileShardResult);
            scrollListener = new LatchedActionListener<>(scrollListener, latch);
/*
                    Arrays.asList("foobar", "quuz"),
            .indices("posts", "authors", "contributors");
        RestHighLevelClient client = highLevelClient();
        request.setScriptType(ScriptType.INLINE);
                    "user",
                    "user",
                        "title",
                    Collections.singletonMap("key", "value")
            assertNotNull(hits.getHits()[0].getSourceAsString());
            // end::scroll-request-arguments
                for (TermSuggestion.Entry entry : termSuggestion.getEntries()) { // <3>
        // tag::render-search-template-response
            // end::clear-scroll-execute-listener
        assertThat(userResponse.keySet(), containsInAnyOrder("keyword", "text"));
        CountDownLatch latch = new CountDownLatch(1);
            // tag::scroll-request-arguments
                assertEquals(1, termSuggestion.getEntries().get(0).getOptions().size());
    }
        String[] indices = textCapabilities.indices(); // <2>
            SearchRequest searchRequest = new SearchRequest();
        Map<String, FieldCapabilities> userResponse = response.getField("user");  // <1>
                    "title",
    }
        // tag::multi-search-template-request-inline
            sourceBuilder.fetchSource(false);
                @Override
        // end::field-caps-request
                @Override
    public void testScroll() throws Exception {
        RestHighLevelClient client = highLevelClient();
                // end::search-request-aggregations-asList
 *
        {
                        Arrays.asList("foobar", "quuz"),
 *    http://www.apache.org/licenses/LICENSE-2.0
            TermsAggregationBuilder aggregation = AggregationBuilders.terms("by_company")
            searchSourceBuilder.query(QueryBuilders.matchAllQuery());
                    new RankEvalRequest(specification, new String[] { "posts" });
            searchSourceBuilder.profile(true);
        indexSearchTestData();
                    Arrays.asList("foobar", "quxx"),
        RestHighLevelClient client = highLevelClient();
            public void onFailure(Exception e) {
            // tag::search-request-preference
            // tag::clear-scroll-execute-async
/*
                .routing("routing") // <2>
        {
        {
        request.routing("routing"); // <1>
            sourceBuilder.query(QueryBuilders.termQuery("user", "foobar")); // <2>
        RestHighLevelClient client = highLevelClient();
        // tag::search-template-response
    public void testRankEval() throws Exception {
            request.add(new IndexRequest("posts").id("2").source(MediaTypeRegistry.JSON, "user", "quxx"));
            }
                // <1>
                }
        RestHighLevelClient client = highLevelClient();
            sourceBuilder.fetchSource(includeFields, excludeFields);
            searchRequest.scroll(TimeValue.timeValueMinutes(1L)); // <2>
                        "user",
            BulkRequest request = new BulkRequest();
        bulkRequest.setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE);
            // tag::search-request-profiling
        RestHighLevelClient client = highLevelClient();
            request.add(secondSearchRequest);
    public void testBuildingSearchQueries() {
            // tag::search-response-2
                new IndexRequest("posts").id("1")
import org.opensearch.search.profile.ProfileResult;
            request.add(new IndexRequest("posts").id("1").source(MediaTypeRegistry.JSON, "company", "OpenSearch", "age", 20));
        // end::explain-request
        scriptParams.put("value", "opensearch");
                        "The Future of Federated Search in OpenSearch",
import org.opensearch.action.search.MultiSearchResponse;
            assertEquals(1, searchResponse.getHits().getTotalHits().value());
            scrollRequest.scroll(TimeValue.timeValueSeconds(30));
import org.opensearch.action.fieldcaps.FieldCapabilitiesRequest;
                    2,
        assertTrue(latch.await(30L, TimeUnit.SECONDS));
                String index = hit.getIndex();
            }
            request.setScript("title_search");
                .startObject("properties")
    }
                // <2>
        {
        request.setScript("title_search");
        // tag::multi-search-template-response
            SearchTemplateRequest request = new SearchTemplateRequest();
        // Replace the empty listener by a blocking listener for tests.
 * Documentation for search APIs in the high level java client.
            request.setScript(
            assertTrue(succeeded);
            // end::search-query-builders
                Map<String, Aggregation> aggregationMap = aggregations.getAsMap();
            SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
            "}");
            String[] includeFields = new String[] {"title", "innerObject.*"};
import org.opensearch.action.fieldcaps.FieldCapabilities;
                    Collections.singletonMap("key", "value")
import org.opensearch.client.core.CountRequest;
            assertNotNull(client.count(countRequest, RequestOptions.DEFAULT));
            // Replace the empty listener by a blocking listener in test
                // <3>
            // end::search-request-profiling-get
                public void onFailure(Exception e) {
            CountRequest countRequest = new CountRequest();
            request.add(firstSearchRequest);                          // <3>
            // end::search-execute-async
            assertNotNull(client.search(searchRequest, RequestOptions.DEFAULT));
 * software distributed under the License is distributed on an
                public void onFailure(Exception e) {
import org.opensearch.search.Scroll;
            assertNotNull(searchResponse);
        FieldCapabilitiesRequest request = new FieldCapabilitiesRequest()
            for (Map.Entry<String, ProfileShardResult> profilingResult : profilingResults.entrySet()) { // <2>
                }
        assertSame(RestStatus.OK, bulkResponse.status());
                } catch (ClassCastException ex) {
            scrollRequest.scrollId(scrollId);
        bulkRequest.add(
            SearchRequest searchRequest = new SearchRequest();
            // end::search-query-builder-ctor
            highlightBuilder.field(highlightTitle);  // <4>
                }
    }
                public void onFailure(Exception e) {
            // tag::search-scroll-init
            // end::search-query-setter
            }
                // do something with the SearchHit
                    profileShardResult.getAggregationProfileResults(); // <1>
            }
                    "Doubling Down on Open?",
        }
 */
        // end::search-template-execute-async
import org.opensearch.search.sort.ScoreSortBuilder;
        // end::field-caps-execute-async
        SearchTemplateRequest request = new SearchTemplateRequest();
            SearchResponse searchScrollResponse = client.scroll(scrollRequest, RequestOptions.DEFAULT);
        assertNotNull(searchResponse);
import org.opensearch.search.aggregations.metrics.Avg;
        assertTrue(latch.await(30L, TimeUnit.SECONDS));
                hits = searchResponse.getHits();
                assertEquals("foobar", termSuggestion.getEntries().get(0).getOptions().get(0).getText().string());
            // tag::search-execute
                    assertThat(message, containsString("org.opensearch.search.aggregations.bucket.terms.ParsedStringTerms"));
        bulkRequest.add(
            assertThat(queryProfileShardResults.size(), equalTo(1));
            assertEquals(1, detail.getRelevantRetrieved());             // <7>
                @Override
        indexSearchTestData();
        // tag::field-caps-execute-listener
    }
            PrecisionAtK.Detail detail = (PrecisionAtK.Detail) metricDetails;
                "{" +
            RankEvalSpec specification =
                new ActionListener<CountResponse>() {
import org.opensearch.search.SearchHit;
 * the Apache License, Version 2.0 (the "License"); you may
        SearchTemplateResponse response = client.searchTemplate(request, RequestOptions.DEFAULT);
                assertEquals(1, termSuggestion.getEntries().size());
        RestHighLevelClient client = highLevelClient();
        ExplainResponse response = client.explain(request, RequestOptions.DEFAULT);
                                                            .prefixLength(3)
        // end::multi-search-template-execute-async
        }
import org.opensearch.index.rankeval.EvalQueryQuality;
            }
            }
            int successfulShards = countResponse.getSuccessfulShards();
import org.opensearch.search.profile.aggregation.AggregationProfileShardResult;
        assertTrue(latch.await(30L, TimeUnit.SECONDS));
            assertTrue(latch.await(30L, TimeUnit.SECONDS));
            assertNull(secondResponse.getFailure());
                    // <1>
        };
            request.add(new IndexRequest("posts").id("3").source(MediaTypeRegistry.JSON, "user", "quzz"));
import java.util.Collections;
            // end::count-source-setter
                        Arrays.asList("foobar", "quxx"),
        BulkRequest bulkRequest = new BulkRequest();
                public void onFailure(Exception e) {
                    MediaTypeRegistry.JSON,
import org.opensearch.search.aggregations.bucket.terms.TermsAggregationBuilder;
                        // <2>
        boolean isAggregatable = textCapabilities.isAggregatable();
import org.opensearch.core.common.text.Text;
            }
            client.rankEvalAsync(request, RequestOptions.DEFAULT, listener); // <1>
    public void testMultiSearchTemplateWithStoredScript() throws Exception {
import org.opensearch.search.suggest.SuggestionBuilder;
                // tag::search-request-profiling-queries-results
 * The OpenSearch Contributors require contributions made to
        {
        assertNotNull(multiResponse);
import org.opensearch.client.indices.CreateIndexRequest;
            scriptParams.put("field", "title");
        // end::multi-search-template-execute-listener
            SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
            SuggestBuilder suggestBuilder = new SuggestBuilder();
            // end::search-request-profiling-queries
                )
            // end::search-source-filtering-off
            BulkResponse bulkResponse = client.bulk(request, RequestOptions.DEFAULT);
                    // tag::search-request-aggregations-get-wrongCast
            // tag::count-response-1
                .startObject()
        assertTrue(searchResponse.getHits().getTotalHits().value() > 0);
            // tag::search-request-aggregations
            sourceBuilder.sort(new FieldSortBuilder("id").order(SortOrder.ASC));  // <2>
                        "title",
        // tag::explain-request-preference
                .source(
            assertTrue(latch.await(30L, TimeUnit.SECONDS));
        // end::search-template-response
                    // <2>
            assertEquals(4, countResponse.getCount());
            // tag::count-source-setter
        String[] nonSearchableIndices = textCapabilities.nonSearchableIndices(); // <3>
    }
                scrollId = searchResponse.getScrollId();
            );
import org.opensearch.search.aggregations.bucket.terms.Terms;
            }
                assertEquals(3, elasticBucket.getDocCount());
        assertEquals(searchTerms.length, multiResponse.getResponses().length);
        assertThat(index, equalTo("contributors"));
            request.addScrollId(scrollId);
            SearchRequest firstSearchRequest = new SearchRequest();   // <2>
            SearchResponse searchResponse = client.search(searchRequest, RequestOptions.DEFAULT);
        );
            // end::search-source-filtering-includes
            QueryBuilder matchQueryBuilder = QueryBuilders.matchQuery("user", "foobar")
            }
                Map<String, Object> sourceAsMap = hit.getSourceAsMap();
            request.add(
                .field("store", "true")
        {
            assertSame(RestStatus.OK, bulkResponse.status());
            SearchRequest searchRequest = new SearchRequest("posts");
            searchSourceBuilder.query(matchQuery("title", "OpenSearch"));
                .endObject()
                .field("type", "keyword")
        }
                // <1>
            "  \"script\": {" +
                        Collections.singletonMap("key", "value")
            // end::clear-scroll-execute
            BulkResponse bulkResponse = client.bulk(request, RequestOptions.DEFAULT);
            int released = response.getNumFreed(); // <2>
                String key = profilingResult.getKey(); // <3>
        assertTrue(searchResponse.getHits().getTotalHits().value() > 0);
        // end::explain-request-routing
                    Range range = aggregations.get("by_company"); // <1>
            BulkRequest request = new BulkRequest();
            // end::count-source-basics
            searchSourceBuilder.query(
import org.opensearch.index.query.MatchQueryBuilder;
                SearchHits hits = searchResponse.getHits();
