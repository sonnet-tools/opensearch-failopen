                .subAggregation(  
        source.aggregation(AggregationBuilders.sum("test_sum").field("price"));
import static org.hamcrest.Matchers.equalTo;
    public void testCanUseStreamSearchWithMultipleTermsAggregations() {
            RestRequest restRequest = new FakeRestRequest.Builder(xContentRegistry()).build();  
                () -> new RestSearchAction(createClusterSettingsWithStreamSearchEnabled()).handleRequest(restRequest, channel, nodeClient)
    }
    public void testCanUseStreamSearchWithTwoLevelTermsAndMetricLeaf() {
        return new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
    public void testCanUseStreamSearchWithSingleTermsAggregation() {
            });  
        SearchRequest searchRequest = new SearchRequest();
import org.opensearch.test.rest.FakeRestChannel;
            FakeRestChannel channel = new FakeRestChannel(restRequest, false, 0);
import org.opensearch.action.search.StreamSearchAction;  
}
        source.aggregation(AggregationBuilders.histogram("test_histogram").field("timestamp").interval(1000));  
        );
        SetOnce<ActionType<?>> capturedActionType = new SetOnce<>();
                .subAggregation(AggregationBuilders.max("max_price").field("price"))  
        assertTrue(RestSearchAction.canUseStreamSearch(searchRequest));
import org.opensearch.common.settings.ClusterSettings;
    }
        SetOnce<ActionType<?>> capturedActionType = new SetOnce<>();
        SearchSourceBuilder source = new SearchSourceBuilder();
import org.opensearch.action.search.SearchRequest;
                .subAggregation(AggregationBuilders.min("min_price").field("price"))
                listener.onResponse(null);  
import org.opensearch.search.aggregations.AggregationBuilders;  
        searchRequest.source(source);  
import org.opensearch.action.ActionType;
                )  
        SearchSourceBuilder source = new SearchSourceBuilder();
import org.opensearch.test.OpenSearchTestCase;  
        source.aggregation(  
        assertFalse(RestSearchAction.canUseStreamSearch(searchRequest));  
        Settings settings = Settings.builder().put(STREAM_SEARCH_ENABLED.getKey(), true).build();  
    }
            AggregationBuilders.terms("test_terms")  
import org.opensearch.action.ActionRequest;
            public String getLocalNodeId() {
import org.opensearch.search.builder.SearchSourceBuilder;
import static org.opensearch.common.util.FeatureFlags.STREAM_TRANSPORT;
        source.aggregation(AggregationBuilders.terms("terms2").field("brand"));
import org.opensearch.rest.RestRequest;
    public void testCanUseStreamSearchWithTermsAndUnsupportedSubAggregation() {
        return searchRequest;  
    }
    }
        assertFalse(RestSearchAction.canUseStreamSearch(searchRequest));
        source.aggregation(
        );
        searchRequest.source(source);
                @Override
        assertFalse(RestSearchAction.canUseStreamSearch(searchRequest));
        assertFalse(RestSearchAction.canUseStreamSearch(searchRequest));
        source.aggregation(AggregationBuilders.terms("test_terms").field("category"));
import org.opensearch.core.action.ActionResponse;  
                        .field("brand")
                .field("category")
                .subAggregation(AggregationBuilders.terms("brand_terms").field("brand"))
    private NodeClient createMockNodeClient(SetOnce<ActionType<?>> capturedActionType) {  
    public void testCanUseStreamSearchWithSingleNonTermsAggregation() {
            FakeRestChannel channel = new FakeRestChannel(request, false, 0);
import org.opensearch.test.client.NoOpNodeClient;
        SearchRequest searchRequest = new SearchRequest();
        searchRequest.source(source);  
        SearchRequest searchRequest = new SearchRequest();
            RestRequest request = new FakeRestRequest.Builder(xContentRegistry()).build();  
    private ClusterSettings createClusterSettingsWithStreamSearchEnabled() {
    @LockFeatureFlag(STREAM_TRANSPORT)
            assertThat(e.getMessage(), equalTo("You need to enable stream transport first to use stream search."));
    }
        };
            assertTrue(clusterSettings.get(STREAM_SEARCH_ENABLED));
                    AggregationBuilders.terms("level2_terms")  
        SearchSourceBuilder source = new SearchSourceBuilder();
        assertTrue(RestSearchAction.canUseStreamSearch(searchRequest));  
            new RestSearchAction().handleRequest(request, channel, nodeClient);  
                .field("category")
        SearchRequest searchRequest = new SearchRequest();
    // When stream search is enabled but STREAM_TRANSPORT is disabled, should throw exception  
        SearchSourceBuilder source = new SearchSourceBuilder();
        assertTrue(RestSearchAction.canUseStreamSearch(searchRequest));
        searchRequest.source(source);
        searchRequest.source(source);
        SearchRequest searchRequest = new SearchRequest();  
        searchRequest.source(source);
        SearchSourceBuilder source = new SearchSourceBuilder();  
            public <Request extends ActionRequest, Response extends ActionResponse> Task executeLocally(  
        SearchRequest searchRequest = new SearchRequest();
        // 3-level terms nesting should be rejected (max 2 levels supported)  
    public void testCanUseStreamSearchWithNoAggregations() {  
                .field("category")
    }
                .field("category")
    public void testWithSearchStreamDisabled() throws Exception {  
        );  
        SearchRequest searchRequest = new SearchRequest();  
import static org.opensearch.action.search.StreamSearchTransportService.STREAM_SEARCH_ENABLED;  
        }
 * SPDX-License-Identifier: Apache-2.0
    }  
        SearchRequest searchRequest = new SearchRequest();  
import org.opensearch.tasks.Task;
        SearchRequest searchRequest = new SearchRequest();
            assertTrue(FeatureFlags.isEnabled(FeatureFlags.STREAM_TRANSPORT));
        assertFalse(RestSearchAction.canUseStreamSearch(searchRequest));  
        try (NodeClient nodeClient = new NoOpNodeClient(this.getTestName())) {
            AggregationBuilders.terms("test_terms")  
        searchRequest.source(source);
                        .subAggregation(AggregationBuilders.sum("sum_price").field("price"))
                        .field("brand")
import org.opensearch.action.search.SearchAction;  
    }  
            assertThat(capturedActionType.get(), equalTo(SearchAction.INSTANCE));
            @Override
                public void onFailure(Exception e) {}
    }
        source.aggregation(AggregationBuilders.terms("test_terms").field("category"));
import org.opensearch.common.settings.Settings;  
        source.aggregation(AggregationBuilders.terms("terms1").field("category"));
                .subAggregation(AggregationBuilders.histogram("price_hist").field("price").interval(10))
            @Override
    private SearchRequest createSearchRequestWithTermsAggregation() {
        assertFalse(RestSearchAction.canUseStreamSearch(searchRequest));
    }  
                )
    }  
public class RestSearchActionTests extends OpenSearchTestCase {
            Exception e = expectThrows(  
                .field("category")
            // Verify all conditions are met for stream search  
    // Tests for canUseStreamSearch method  
            }
            nodeClient.executeLocally(StreamSearchAction.INSTANCE, searchRequest, new ActionListener<>() {  
            ) {
            assertTrue(RestSearchAction.canUseStreamSearch(searchRequest));  
    public void testCanUseStreamSearchWithTermsAndNonTermsTopLevel() {
            }
        searchRequest.source(source);
    public void testCanUseStreamSearchWithSingleHistogramAggregation() {  
            // Execute the StreamSearchAction directly since we've verified the conditions
    public void testWithStreamSearchEnabledButStreamTransportDisabled() {
        source.aggregation(
                    AggregationBuilders.terms("level2_terms")
import org.opensearch.common.SetOnce;
import org.opensearch.index.query.QueryBuilders;
            AggregationBuilders.terms("level1_terms")
            AggregationBuilders.terms("level1_terms")  
 * this file be licensed under the Apache-2.0 license or a
        try (NodeClient nodeClient = createMockNodeClient(capturedActionType)) {
        source.aggregation(AggregationBuilders.terms("test_terms").field("category"));
                        .subAggregation(AggregationBuilders.terms("level3_terms").field("model"))  
    public void testCanUseStreamSearchWithNullSource() {
 *
                ActionListener<Response> listener  
        source.aggregation(
 */  
        }  
        assertTrue(RestSearchAction.canUseStreamSearch(searchRequest));
        searchRequest.source(source);  
    public void testCanUseStreamSearchWithTermsAndNestedTermsSubAggregation() {
            assertThat(capturedActionType.get(), equalTo(StreamSearchAction.INSTANCE));
            AggregationBuilders.terms("category_terms")  
        source.aggregation(
        // 2-level terms with metric leaf should be accepted
                IllegalArgumentException.class,
        return new NoOpNodeClient(this.getTestName()) {
                return new Task(1L, "test", action.name(), "test task", null, null);
        SearchSourceBuilder source = new SearchSourceBuilder();
 * compatible open source license.
    }  
        }  
        assertFalse(RestSearchAction.canUseStreamSearch(searchRequest));
        SearchRequest searchRequest = new SearchRequest();
        try (NodeClient nodeClient = createMockNodeClient(capturedActionType)) {
 * The OpenSearch Contributors require contributions made to  
    public void testWithStreamSearchAndTransportEnabled() {  
        );  
                capturedActionType.set(action);
        SearchSourceBuilder source = new SearchSourceBuilder();
        searchRequest.source(source);
    }
        );  
                .subAggregation(AggregationBuilders.sum("sum_price").field("price"))
        searchRequest.source(source);
package org.opensearch.rest.action.search;
import org.opensearch.core.action.ActionListener;
                return "test-node";  
        source.query(QueryBuilders.matchAllQuery());  
    }
        SearchSourceBuilder source = new SearchSourceBuilder();  
    }  
    }
import org.opensearch.common.util.FeatureFlags;
    }  
        ClusterSettings clusterSettings = createClusterSettingsWithStreamSearchEnabled();
                ActionType<Response> action,
        searchRequest.source(source);  
import org.opensearch.action.search.SearchResponse;
        SearchRequest searchRequest = new SearchRequest();
        SearchRequest searchRequest = new SearchRequest();  
/*  
                @Override
        SearchSourceBuilder source = new SearchSourceBuilder();
                .subAggregation(
        assertTrue(RestSearchAction.canUseStreamSearch(searchRequest));
    public void testCanUseStreamSearchWithTermsAndSupportedSubAggregations() {
        source.aggregation(AggregationBuilders.sum("test_sum").field("price"));
        SearchSourceBuilder source = new SearchSourceBuilder();
        SearchRequest searchRequest = createSearchRequestWithTermsAggregation();
                Request request,
        SearchRequest searchRequest = new SearchRequest();  
            );  
        SearchSourceBuilder source = new SearchSourceBuilder();  
import org.opensearch.transport.client.node.NodeClient;
import org.opensearch.test.rest.FakeRestRequest;  
    public void testCanUseStreamSearchWithThreeLevelTermsNesting() {
                public void onResponse(SearchResponse response) {}
        SearchSourceBuilder source = new SearchSourceBuilder();  
                .subAggregation(AggregationBuilders.cardinality("unique_brands").field("brand"))
