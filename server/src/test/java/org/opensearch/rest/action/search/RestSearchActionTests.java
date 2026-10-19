            public String getLocalNodeId() {
            assertTrue(clusterSettings.get(STREAM_SEARCH_ENABLED));
        source.aggregation(AggregationBuilders.histogram("test_histogram").field("timestamp").interval(1000));
import org.opensearch.test.rest.FakeRestRequest;
                @Override
    public void testCanUseStreamSearchWithTermsAndNonTermsTopLevel() {
import org.opensearch.test.OpenSearchTestCase;
            RestRequest restRequest = new FakeRestRequest.Builder(xContentRegistry()).build();
    }
    public void testCanUseStreamSearchWithNullSource() {
        source.aggregation(AggregationBuilders.terms("terms2").field("brand"));
    // When stream search is enabled but STREAM_TRANSPORT is disabled, should throw exception
    public void testWithSearchStreamDisabled() throws Exception {
            Exception e = expectThrows(
        SearchRequest searchRequest = new SearchRequest();
    }
        );
import org.opensearch.action.search.SearchRequest;
            RestRequest request = new FakeRestRequest.Builder(xContentRegistry()).build();
 * The OpenSearch Contributors require contributions made to
                listener.onResponse(null);
        SearchSourceBuilder source = new SearchSourceBuilder();
import org.opensearch.tasks.Task;
        assertFalse(RestSearchAction.canUseStreamSearch(searchRequest));
            FakeRestChannel channel = new FakeRestChannel(request, false, 0);
            @Override
                )
import static org.opensearch.common.util.FeatureFlags.STREAM_TRANSPORT;
    public void testCanUseStreamSearchWithTermsAndNestedTermsSubAggregation() {
            AggregationBuilders.terms("test_terms")
        SearchSourceBuilder source = new SearchSourceBuilder();
        assertFalse(RestSearchAction.canUseStreamSearch(searchRequest));
            assertThat(capturedActionType.get(), equalTo(StreamSearchAction.INSTANCE));
import org.opensearch.index.query.QueryBuilders;
    public void testCanUseStreamSearchWithMultipleTermsAggregations() {
        assertTrue(RestSearchAction.canUseStreamSearch(searchRequest));
        source.aggregation(AggregationBuilders.terms("test_terms").field("category"));
        SearchSourceBuilder source = new SearchSourceBuilder();
import org.opensearch.rest.RestRequest;
                .subAggregation(
        SearchSourceBuilder source = new SearchSourceBuilder();
            assertThat(e.getMessage(), equalTo("You need to enable stream transport first to use stream search."));
        source.query(QueryBuilders.matchAllQuery());
            }
            });
            new RestSearchAction().handleRequest(request, channel, nodeClient);
import org.opensearch.common.util.FeatureFlags;
        assertFalse(RestSearchAction.canUseStreamSearch(searchRequest));
            ) {
            FakeRestChannel channel = new FakeRestChannel(restRequest, false, 0);
 *
        SearchRequest searchRequest = new SearchRequest();
            assertThat(capturedActionType.get(), equalTo(SearchAction.INSTANCE));
    }
        source.aggregation(
            );
                .subAggregation(AggregationBuilders.cardinality("unique_brands").field("brand"))
                .field("category")
        );
import org.opensearch.common.settings.Settings;
        searchRequest.source(source);
    }
            // Verify all conditions are met for stream search
                .field("category")
        };
        searchRequest.source(source);
        }
    }
        SetOnce<ActionType<?>> capturedActionType = new SetOnce<>();
import static org.hamcrest.Matchers.equalTo;
    public void testCanUseStreamSearchWithSingleTermsAggregation() {
            // Execute the StreamSearchAction directly since we've verified the conditions
            public <Request extends ActionRequest, Response extends ActionResponse> Task executeLocally(
        SearchSourceBuilder source = new SearchSourceBuilder();
                public void onFailure(Exception e) {}
import org.opensearch.test.rest.FakeRestChannel;
        searchRequest.source(source);
    }
    public void testCanUseStreamSearchWithThreeLevelTermsNesting() {
import org.opensearch.transport.client.node.NodeClient;
    }
    public void testCanUseStreamSearchWithTwoLevelTermsAndMetricLeaf() {
    }
        source.aggregation(AggregationBuilders.terms("test_terms").field("category"));
        SearchSourceBuilder source = new SearchSourceBuilder();
            nodeClient.executeLocally(StreamSearchAction.INSTANCE, searchRequest, new ActionListener<>() {
                .field("category")
        SearchRequest searchRequest = new SearchRequest();
        SearchRequest searchRequest = new SearchRequest();
        SetOnce<ActionType<?>> capturedActionType = new SetOnce<>();
        searchRequest.source(source);
        SearchSourceBuilder source = new SearchSourceBuilder();
    public void testCanUseStreamSearchWithSingleHistogramAggregation() {
        SearchRequest searchRequest = new SearchRequest();
        assertFalse(RestSearchAction.canUseStreamSearch(searchRequest));
    public void testCanUseStreamSearchWithTermsAndSupportedSubAggregations() {
            assertTrue(RestSearchAction.canUseStreamSearch(searchRequest));
import org.opensearch.test.client.NoOpNodeClient;
        }
        searchRequest.source(source);
        SearchRequest searchRequest = new SearchRequest();
            }
            assertTrue(FeatureFlags.isEnabled(FeatureFlags.STREAM_TRANSPORT));
        SearchRequest searchRequest = new SearchRequest();
    public void testWithStreamSearchAndTransportEnabled() {
    }
        source.aggregation(AggregationBuilders.sum("test_sum").field("price"));
        assertFalse(RestSearchAction.canUseStreamSearch(searchRequest));
        // 2-level terms with metric leaf should be accepted
                capturedActionType.set(action);
        }
        SearchRequest searchRequest = new SearchRequest();
                .field("category")
    }
            AggregationBuilders.terms("category_terms")
            @Override
                    AggregationBuilders.terms("level2_terms")
/*
        SearchSourceBuilder source = new SearchSourceBuilder();
    }
    // Tests for canUseStreamSearch method
        SearchSourceBuilder source = new SearchSourceBuilder();
    }
        assertFalse(RestSearchAction.canUseStreamSearch(searchRequest));
                .subAggregation(AggregationBuilders.histogram("price_hist").field("price").interval(10))
        assertFalse(RestSearchAction.canUseStreamSearch(searchRequest));
        searchRequest.source(source);
                )
import org.opensearch.search.aggregations.AggregationBuilders;
        assertTrue(RestSearchAction.canUseStreamSearch(searchRequest));
        try (NodeClient nodeClient = new NoOpNodeClient(this.getTestName())) {
                    AggregationBuilders.terms("level2_terms")
    public void testWithStreamSearchEnabledButStreamTransportDisabled() {
            AggregationBuilders.terms("test_terms")
                        .field("brand")
import org.opensearch.common.SetOnce;
import org.opensearch.action.search.StreamSearchAction;
        assertTrue(RestSearchAction.canUseStreamSearch(searchRequest));
        searchRequest.source(source);
    }
    public void testCanUseStreamSearchWithNoAggregations() {
                .subAggregation(
import org.opensearch.action.search.SearchAction;
import org.opensearch.action.search.SearchResponse;
        SearchRequest searchRequest = createSearchRequestWithTermsAggregation();
    public void testCanUseStreamSearchWithTermsAndUnsupportedSubAggregation() {
    @LockFeatureFlag(STREAM_TRANSPORT)
                IllegalArgumentException.class,
    private NodeClient createMockNodeClient(SetOnce<ActionType<?>> capturedActionType) {
        );
    private SearchRequest createSearchRequestWithTermsAggregation() {
        searchRequest.source(source);
        searchRequest.source(source);
                        .subAggregation(AggregationBuilders.sum("sum_price").field("price"))
                        .field("brand")
                .field("category")
            AggregationBuilders.terms("level1_terms")
                public void onResponse(SearchResponse response) {}
        return new NoOpNodeClient(this.getTestName()) {
        assertTrue(RestSearchAction.canUseStreamSearch(searchRequest));
import org.opensearch.core.action.ActionListener;
    private ClusterSettings createClusterSettingsWithStreamSearchEnabled() {
        SearchRequest searchRequest = new SearchRequest();
    public void testCanUseStreamSearchWithSingleNonTermsAggregation() {
        // 3-level terms nesting should be rejected (max 2 levels supported)
                ActionListener<Response> listener
        );
        SearchSourceBuilder source = new SearchSourceBuilder();
                Request request,
        SearchRequest searchRequest = new SearchRequest();
        ClusterSettings clusterSettings = createClusterSettingsWithStreamSearchEnabled();
        );
                        .subAggregation(AggregationBuilders.terms("level3_terms").field("model"))
                return new Task(1L, "test", action.name(), "test task", null, null);
        SearchSourceBuilder source = new SearchSourceBuilder();
        assertTrue(RestSearchAction.canUseStreamSearch(searchRequest));
        source.aggregation(
        return searchRequest;
                .subAggregation(AggregationBuilders.min("min_price").field("price"))
        searchRequest.source(source);
        searchRequest.source(source);
        source.aggregation(AggregationBuilders.terms("terms1").field("category"));
        searchRequest.source(source);
                return "test-node";
                .subAggregation(AggregationBuilders.sum("sum_price").field("price"))
        source.aggregation(
                .subAggregation(AggregationBuilders.max("max_price").field("price"))
        SearchRequest searchRequest = new SearchRequest();
        return new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
import org.opensearch.action.ActionType;
        source.aggregation(
    }
        SearchSourceBuilder source = new SearchSourceBuilder();
}
import static org.opensearch.action.search.StreamSearchTransportService.STREAM_SEARCH_ENABLED;
        source.aggregation(AggregationBuilders.terms("test_terms").field("category"));
import org.opensearch.core.action.ActionResponse;
            AggregationBuilders.terms("level1_terms")
        try (NodeClient nodeClient = createMockNodeClient(capturedActionType)) {
 * this file be licensed under the Apache-2.0 license or a
public class RestSearchActionTests extends OpenSearchTestCase {
        source.aggregation(
 */
        SearchRequest searchRequest = new SearchRequest();
                () -> new RestSearchAction(createClusterSettingsWithStreamSearchEnabled()).handleRequest(restRequest, channel, nodeClient)
    }
        source.aggregation(AggregationBuilders.sum("test_sum").field("price"));
import org.opensearch.common.settings.ClusterSettings;
import org.opensearch.action.ActionRequest;
        SearchRequest searchRequest = new SearchRequest();
                @Override
    }
                .subAggregation(AggregationBuilders.terms("brand_terms").field("brand"))
    }
        try (NodeClient nodeClient = createMockNodeClient(capturedActionType)) {
 * SPDX-License-Identifier: Apache-2.0
        Settings settings = Settings.builder().put(STREAM_SEARCH_ENABLED.getKey(), true).build();
                ActionType<Response> action,
    }
package org.opensearch.rest.action.search;
import org.opensearch.search.builder.SearchSourceBuilder;
 * compatible open source license.
