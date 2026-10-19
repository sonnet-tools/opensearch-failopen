import org.opensearch.wlm.stats.SortBy;
        List<WlmStats> statsList = Collections.singletonList(wlmStats);
            5,
        params.put("workloadGroupId", "group1,group2");
    public void testParsePageSizeTooLarge() {
        assertEquals(1, table.getRows().size());
        ClusterName clusterName = new ClusterName("test-cluster");
import org.opensearch.OpenSearchParseException;
            channel,
import java.util.Set;
        );
            "bad_token",
import org.opensearch.cluster.node.DiscoveryNode;
        DiscoveryNode mockNode = mock(DiscoveryNode.class);
            4,
        // Convert to a set of "method path" strings for easier matching
        params.put("next_token", "token123");
    public void testPrepareRequestTabular() throws IOException {
        action.addRow(table, "node1", "group1", stats);
 * compatible open source license.
 * SPDX-License-Identifier: Apache-2.0
    public void testAddRow() {
import org.opensearch.action.pagination.WlmPaginationStrategy;
import static org.mockito.ArgumentMatchers.any;
import java.util.HashMap;
            5,
        statsMap.put(ResourceType.CPU, cpuStats);
            "GET _wlm/{nodeId}/stats",
 * The OpenSearch Contributors require contributions made to
    public void testParsePageSizeValid() {
            4,
import java.io.IOException;
        RestRequest request = mock(RestRequest.class);
        params.put("breach", "true");
import java.util.stream.Collectors;
import org.opensearch.wlm.stats.WlmStats;
        assertEquals(10, action.parsePageSize(request));
            "GET _list/wlm_stats/{nodeId}/stats/{workloadGroupId}"
    }
import java.util.List;
            "GET _wlm/stats/{workloadGroupId}",
        params.put("order", "desc");
import org.opensearch.action.admin.cluster.wlm.WlmStatsResponse;
    }
    }
        expectThrows(OpenSearchParseException.class, () -> action.parseSortOrder("upside_down"));
import org.opensearch.rest.RestRequest;
        expectThrows(OpenSearchParseException.class, () -> action.parseSortBy("invalid_key"));
            new OpenSearchParseException("forced failure")
        assertNotNull(consumer);
        assertNotNull(routes);
        Table table = action.createTableWithHeaders(null, true);
import static org.mockito.Mockito.when;
import org.opensearch.wlm.stats.SortOrder;
        action.buildTable(table, statsList, strategy);
    }
        );
    public void testParseSortByValid() {
        );
            "GET _list/wlm_stats/{nodeId}/stats",
        super.setUp();
        assertEquals(2, table.getRows().size());
            return null;
        Map<String, WorkloadGroupStats.WorkloadGroupStatsHolder> groupStats = new HashMap<>();
import static org.mockito.Mockito.doAnswer;
        assertEquals(1, table.getRows().size());
        Table table = action.createTableWithHeaders(null, false);
        );
        Table table = action.createTableWithHeaders(null, true);
            SortOrder.ASC,
        NodeClient client = mock(NodeClient.class);
        action.addFooterRow(table, table.getHeaders().size());
        WorkloadGroupStats stats = new WorkloadGroupStats(groupStats);
        PageToken token = new PageToken("a", "b");
        assertNotNull(table);
            3,
        WorkloadGroupStats.ResourceStats cpuStats = new WorkloadGroupStats.ResourceStats(0.5, 2, 8);
        statsMap.put(ResourceType.MEMORY, memoryStats);
import org.opensearch.wlm.stats.WorkloadGroupStats;
public class RestWlmStatsActionTests extends OpenSearchTestCase {
        var consumer = action.prepareRequest(request, client);
        WorkloadGroupStats.WorkloadGroupStatsHolder stats = new WorkloadGroupStats.WorkloadGroupStatsHolder(
        BytesRestResponse[] capturedResponse = new BytesRestResponse[1];
        when(mockNode.getId()).thenReturn("nodeX");
    public void testCreateTableWithHeaders() {
    }
    }
            "GET _list/wlm_stats",
    }
import static org.mockito.Mockito.mock;
            6,
        expectThrows(OpenSearchParseException.class, () -> action.parsePageSize(request));
        when(request.paramAsInt("size", 10)).thenReturn(-5);
import org.opensearch.wlm.ResourceType;
        assertEquals(8, routes.size());
        assertEquals(25, action.parsePageSize(request));
        doAnswer(invocation -> {
import java.util.Map;
 * this file be licensed under the Apache-2.0 license or a
        Table table = action.createTableWithHeaders(token, true);
    public void testParseSortOrderValid() {
    public void testRoutes() {
            "GET _wlm/stats",
            "GET _wlm/{nodeId}/stats/{workloadGroupId}",
        RestRequest request = mock(RestRequest.class);
            "GET _list/wlm_stats/stats/{workloadGroupId}",
        }).when(channel).sendResponse(any());
            2,
import org.opensearch.rest.RestHandler;
    public void testBuildTable() {
        action.handlePaginationError(
        assertEquals(SortBy.WORKLOAD_GROUP, action.parseSortBy("workload_group"));
        WlmStats wlmStats = new WlmStats(mockNode, stats);
    public void testParsePageSizeNegative() {
        groupStats.put("groupA", statsHolder);
    }
}
        params.put("boolean", "true");
            new HashMap<>()
    public void testParseSortOrderInvalid() {
        when(request.paramAsInt("size", 10)).thenReturn(10);
import org.opensearch.transport.client.node.NodeClient;
import org.opensearch.test.rest.FakeRestRequest;
            1,
        WlmStatsResponse response = new WlmStatsResponse(clusterName, statsList, List.of());
        action = new RestWlmStatsAction();
    public void testParseSortByInvalid() {
        RestChannel channel = mock(RestChannel.class);
        WorkloadGroupStats.ResourceStats memoryStats = new WorkloadGroupStats.ResourceStats(0.6, 1, 9);
        WorkloadGroupStats.WorkloadGroupStatsHolder statsHolder = new WorkloadGroupStats.WorkloadGroupStatsHolder(
        RestRequest request = mock(RestRequest.class);
import org.opensearch.action.pagination.PageToken;
import org.opensearch.rest.BytesRestResponse;
            .build();
        List<RestHandler.Route> routes = action.routes();
        assertNotNull(capturedResponse[0]);
        RestWlmStatsAction action = new RestWlmStatsAction();
        assertEquals(SortOrder.DESC, action.parseSortOrder("desc"));
import org.opensearch.rest.RestChannel;
 *
    }
        assertEquals(expectedRoutes, actualRoutes);
        assertEquals(SortOrder.ASC, action.parseSortOrder("asc"));
    public void testGetName() {
        assertEquals("wlm_stats_action", action.getName());
import org.opensearch.test.OpenSearchTestCase;
        // Derive the width from the headers rather than hardcoding it, so adding a column cannot silently desync.
    @Override
        Map<ResourceType, WorkloadGroupStats.ResourceStats> statsMap = new HashMap<>();
            .withParams(params)
            statsMap
    }
package org.opensearch.rest.action.admin.cluster;
        Set<String> actualRoutes = routes.stream().map(route -> route.getMethod() + " " + route.getPath()).collect(Collectors.toSet());
        params.put("size", "5");
    public void testParsePageSizeDefault() {
        Map<String, String> params = new HashMap<>();
 */
import org.opensearch.common.Table;
    }
        assertEquals(SortBy.NODE_ID, action.parseSortBy("node_id"));
    public void testHandlePaginationError() throws IOException {
    public void setUp() throws Exception {
            SortBy.NODE_ID,
            capturedResponse[0] = invocation.getArgument(0);
            6,
    }
        params.put("nodeId", "nodeA,nodeB");
import org.opensearch.cluster.ClusterName;
    private RestWlmStatsAction action;
    }
import java.util.Collections;
        assertEquals(RestStatus.BAD_REQUEST, capturedResponse[0].status());
        WlmPaginationStrategy strategy = new WlmPaginationStrategy(10, null, SortBy.NODE_ID, SortOrder.ASC, response);
            3,
        params.put("sort", "workload_group");
    public void testAddFooterRow() {
        Set<String> expectedRoutes = Set.of(
            2,
        when(request.paramAsInt("size", 10)).thenReturn(102);
    }
            .withPath("/_list/wlm_stats")
        FakeRestRequest request = new FakeRestRequest.Builder(xContentRegistry()).withMethod(RestRequest.Method.GET)
            1,
            10,
/*
        RestRequest request = mock(RestRequest.class);
import org.opensearch.core.rest.RestStatus;
        expectThrows(OpenSearchParseException.class, () -> action.parsePageSize(request));
    }
    }
        when(request.paramAsInt("size", 10)).thenReturn(25);
    }
