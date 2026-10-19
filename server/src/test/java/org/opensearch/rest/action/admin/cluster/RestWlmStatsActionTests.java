    public void testParseSortOrderValid() {  
        assertEquals(RestStatus.BAD_REQUEST, capturedResponse[0].status());
            new OpenSearchParseException("forced failure")
        WlmPaginationStrategy strategy = new WlmPaginationStrategy(10, null, SortBy.NODE_ID, SortOrder.ASC, response);
    }  
import org.opensearch.common.Table;
        when(request.paramAsInt("size", 10)).thenReturn(25);
            "GET _list/wlm_stats",  
    public void testParsePageSizeDefault() {  
import org.opensearch.wlm.stats.WlmStats;
            "GET _wlm/stats",
import java.util.Set;  
            .withParams(params)
        assertNotNull(table);  
import org.opensearch.rest.RestChannel;
    }
        assertEquals(expectedRoutes, actualRoutes);  
        RestRequest request = mock(RestRequest.class);
            "GET _list/wlm_stats/stats/{workloadGroupId}",
import static org.mockito.Mockito.when;  
import org.opensearch.test.OpenSearchTestCase;
    public void testRoutes() {  
    public void testAddFooterRow() {  
        );
import java.util.HashMap;  
        when(request.paramAsInt("size", 10)).thenReturn(102);
        params.put("sort", "workload_group");  
        assertEquals(25, action.parsePageSize(request));  
    @Override  
        Map<String, String> params = new HashMap<>();
import org.opensearch.wlm.stats.SortOrder;  
        Set<String> expectedRoutes = Set.of(
        action.addFooterRow(table, table.getHeaders().size());  
    public void testCreateTableWithHeaders() {  
            statsMap
 *
import org.opensearch.action.pagination.PageToken;  
import org.opensearch.rest.RestRequest;  
    public void testPrepareRequestTabular() throws IOException {  
        assertNotNull(capturedResponse[0]);
        WorkloadGroupStats.ResourceStats memoryStats = new WorkloadGroupStats.ResourceStats(0.6, 1, 9);
import org.opensearch.rest.RestHandler;
        NodeClient client = mock(NodeClient.class);
    private RestWlmStatsAction action;
        assertEquals(8, routes.size());
import org.opensearch.rest.BytesRestResponse;  
        params.put("size", "5");  
        RestChannel channel = mock(RestChannel.class);  
        assertEquals(1, table.getRows().size());
        WorkloadGroupStats.WorkloadGroupStatsHolder stats = new WorkloadGroupStats.WorkloadGroupStatsHolder(
            "GET _wlm/{nodeId}/stats/{workloadGroupId}",
    }
        action.handlePaginationError(
        List<WlmStats> statsList = Collections.singletonList(wlmStats);  
    public void setUp() throws Exception {
            2,
        RestRequest request = mock(RestRequest.class);
import org.opensearch.OpenSearchParseException;
import org.opensearch.transport.client.node.NodeClient;  
        assertEquals(SortOrder.ASC, action.parseSortOrder("asc"));
package org.opensearch.rest.action.admin.cluster;
        super.setUp();
        assertNotNull(routes);
 */  
            4,
        WorkloadGroupStats.WorkloadGroupStatsHolder statsHolder = new WorkloadGroupStats.WorkloadGroupStatsHolder(
import org.opensearch.cluster.ClusterName;
        Table table = action.createTableWithHeaders(token, true);
        WlmStats wlmStats = new WlmStats(mockNode, stats);
            5,  
import org.opensearch.wlm.ResourceType;
        when(request.paramAsInt("size", 10)).thenReturn(10);
            3,
            return null;
        ClusterName clusterName = new ClusterName("test-cluster");
import org.opensearch.action.admin.cluster.wlm.WlmStatsResponse;
        assertEquals("wlm_stats_action", action.getName());  
        BytesRestResponse[] capturedResponse = new BytesRestResponse[1];
        assertEquals(SortBy.WORKLOAD_GROUP, action.parseSortBy("workload_group"));
            6,
            4,  
            2,  
    }
import org.opensearch.wlm.stats.SortBy;
import java.util.Map;
    public void testParsePageSizeNegative() {  
        expectThrows(OpenSearchParseException.class, () -> action.parseSortBy("invalid_key"));  
    }
    public void testAddRow() {  
            capturedResponse[0] = invocation.getArgument(0);  
import java.io.IOException;
        params.put("workloadGroupId", "group1,group2");  
import org.opensearch.action.pagination.WlmPaginationStrategy;
}
        expectThrows(OpenSearchParseException.class, () -> action.parsePageSize(request));  
 * The OpenSearch Contributors require contributions made to  
        when(mockNode.getId()).thenReturn("nodeX");  
        WorkloadGroupStats.ResourceStats cpuStats = new WorkloadGroupStats.ResourceStats(0.5, 2, 8);
    public void testHandlePaginationError() throws IOException {
        Map<ResourceType, WorkloadGroupStats.ResourceStats> statsMap = new HashMap<>();  
    public void testParsePageSizeValid() {  
    public void testParsePageSizeTooLarge() {  
        RestWlmStatsAction action = new RestWlmStatsAction();
        // Derive the width from the headers rather than hardcoding it, so adding a column cannot silently desync.
        DiscoveryNode mockNode = mock(DiscoveryNode.class);
    }
        PageToken token = new PageToken("a", "b");
        statsMap.put(ResourceType.MEMORY, memoryStats);
    public void testGetName() {
        RestRequest request = mock(RestRequest.class);
            .withPath("/_list/wlm_stats")  
import java.util.stream.Collectors;
        );  
        Table table = action.createTableWithHeaders(null, false);
import java.util.List;
        when(request.paramAsInt("size", 10)).thenReturn(-5);
    }
        var consumer = action.prepareRequest(request, client);
    public void testParseSortOrderInvalid() {
        RestRequest request = mock(RestRequest.class);
public class RestWlmStatsActionTests extends OpenSearchTestCase {
            3,
        params.put("next_token", "token123");
            SortOrder.ASC,  
import static org.mockito.Mockito.doAnswer;
            .build();
        FakeRestRequest request = new FakeRestRequest.Builder(xContentRegistry()).withMethod(RestRequest.Method.GET)
    }  
import static org.mockito.Mockito.mock;
    public void testBuildTable() {
import org.opensearch.wlm.stats.WorkloadGroupStats;
        WlmStatsResponse response = new WlmStatsResponse(clusterName, statsList, List.of());  
        groupStats.put("groupA", statsHolder);
 * this file be licensed under the Apache-2.0 license or a
        assertEquals(SortOrder.DESC, action.parseSortOrder("desc"));
    }  
    }
        );
        params.put("nodeId", "nodeA,nodeB");
    }
    }
import org.opensearch.core.rest.RestStatus;
    }
            "bad_token",  
import org.opensearch.cluster.node.DiscoveryNode;  
    }
            1,
            5,
            "GET _list/wlm_stats/{nodeId}/stats",
import java.util.Collections;
        statsMap.put(ResourceType.CPU, cpuStats);
        assertEquals(10, action.parsePageSize(request));  
            SortBy.NODE_ID,
import static org.mockito.ArgumentMatchers.any;  
            "GET _list/wlm_stats/{nodeId}/stats/{workloadGroupId}"  
    }
        WorkloadGroupStats stats = new WorkloadGroupStats(groupStats);  
            10,
    }  
        // Convert to a set of "method path" strings for easier matching
        assertNotNull(consumer);  
            6,
        Map<String, WorkloadGroupStats.WorkloadGroupStatsHolder> groupStats = new HashMap<>();
        List<RestHandler.Route> routes = action.routes();  
        assertEquals(2, table.getRows().size());
            "GET _wlm/{nodeId}/stats",  
            new HashMap<>()  
        doAnswer(invocation -> {
        action.addRow(table, "node1", "group1", stats);
    }
        expectThrows(OpenSearchParseException.class, () -> action.parsePageSize(request));  
            1,  
        Table table = action.createTableWithHeaders(null, true);
    public void testParseSortByValid() {  
        params.put("breach", "true");
        );
        }).when(channel).sendResponse(any());
        assertEquals(SortBy.NODE_ID, action.parseSortBy("node_id"));
            channel,
        Set<String> actualRoutes = routes.stream().map(route -> route.getMethod() + " " + route.getPath()).collect(Collectors.toSet());
/*  
        action = new RestWlmStatsAction();  
 * compatible open source license.
 * SPDX-License-Identifier: Apache-2.0
        action.buildTable(table, statsList, strategy);  
        params.put("boolean", "true");
        expectThrows(OpenSearchParseException.class, () -> action.parseSortOrder("upside_down"));  
        Table table = action.createTableWithHeaders(null, true);
        assertEquals(1, table.getRows().size());  
import org.opensearch.test.rest.FakeRestRequest;
    public void testParseSortByInvalid() {
            "GET _wlm/stats/{workloadGroupId}",
        params.put("order", "desc");
