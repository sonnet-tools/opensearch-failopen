            SortOrder.ASC,  
import java.util.Map;
            for (SortOrder sortOrder : SortOrder.values()) {
        WlmStats wlmStats = new WlmStats(node, stats);
import org.opensearch.wlm.stats.WorkloadGroupStats;
                }
                    sortOrder,  
        );  
        WlmStatsResponse response = mockResponse(3);  
    }
            3,
        WorkloadGroupStats.ResourceStats dummyStats = new WorkloadGroupStats.ResourceStats(0.1, 2, 3);
        WlmPaginationStrategy.WlmStrategyToken parsed = new WlmPaginationStrategy.WlmStrategyToken(token);
 * compatible open source license.
        String nextToken = "invalid-token";
import java.util.HashMap;
        assertEquals(pageSize, paginationStrategy.getRequestedEntities().size());
        for (SortBy sortBy : SortBy.values()) {  
        assertEquals(7, parsed.getWorkloadGroupCount());
            statsList.add(wlmStats);  
import java.util.OptionalInt;
        String token = PaginationStrategy.encryptStringToken("node1|group1|3|hashval||");  
                    5,  
package org.opensearch.action.pagination;
                    new WlmStatsResponse(ClusterName.DEFAULT, statsList, Collections.emptyList())
        SortOrder sortOrder = SortOrder.ASC;
import org.opensearch.action.admin.cluster.wlm.WlmStatsResponse;
                    null,
    }  
            response
    }
            response
        WlmStats wlmStats = new WlmStats(node, stats);
            pageSize,  
        );
        String token = PaginationStrategy.encryptStringToken("node1|groupX|7|hashval|ASC|NODE_ID");  
        assertEquals(5, paginationStrategy.getRequestedEntities().size());  
            OpenSearchParseException.class,
            SortBy.WORKLOAD_GROUP,
        List<WlmStats> statsList = List.of(wlmStats);
        assertTrue(ex.getMessage().contains("Invalid pagination token format"));
                    sortBy,
            }  
        String workloadGroupId = "workloadGroup1";  
        ).findIndex(statsList, "node-1", "missing-group");  
            null,
import static org.mockito.Mockito.mock;
        int pageSize = 10;  
                            .compareTo(
        OpenSearchParseException ex = assertThrows(  
                        "Sorting should be in " + sortOrder + " order by node_id",
 * this file be licensed under the Apache-2.0 license or a
        assertNotNull(paginationStrategy);  
        WlmPaginationStrategy strategy = new WlmPaginationStrategy(
    public void testPaginationWithMoreThanPageSize() {
            new WlmPaginationStrategy(pageSize, nextToken, sortBy, sortOrder, response);
            1,  
            nodeId,
            "nonexistentGroup",  
                    assertTrue(
            SortBy.WORKLOAD_GROUP,  
            workloadStats.put("workload-group-" + i, statsHolder);  
public class WlmPaginationStrategyTests extends OpenSearchTestCase {
import org.opensearch.wlm.ResourceType;  
    public List<WlmStats> generateRandomWlmStats(int count) {
        );
    public void testValid() {
        WorkloadGroupStats stats = new WorkloadGroupStats(groupStats);
        Map<ResourceType, WorkloadGroupStats.ResourceStats> resourceMap = Map.of(ResourceType.CPU, dummyStats);  
                            .next()  
            () -> new WlmPaginationStrategy(5, malformedToken, SortBy.NODE_ID, SortOrder.DESC, mockResponse(1))
        }
                        "Sorting should be in " + sortOrder + " order by workload_group",  
        assertTrue(result.isPresent());
    public void testToken() {
import java.util.Collections;
        DiscoveryNode node = mock(DiscoveryNode.class);  
    }
        });  
    }  
        int pageSize = 3;  
        for (int i = 1; i <= count; i++) {
import org.opensearch.wlm.stats.SortOrder;
        assertTrue(ex.getMessage().contains("Invalid pagination token format"));
        WorkloadGroupStats.WorkloadGroupStatsHolder holder = new WorkloadGroupStats.WorkloadGroupStatsHolder(1, 2, 3, 4, 5, 6, resourceMap);
        WlmStatsResponse response = mockResponse(6);
        WlmPaginationStrategy paginationStrategy = new WlmPaginationStrategy(
        String sortOrder = SortOrder.ASC.name();  
        OpenSearchParseException ex = assertThrows(OpenSearchParseException.class, () -> new WlmPaginationStrategy.WlmStrategyToken(token));
                            .getWorkloadGroupStats()
        WlmPaginationStrategy strategy = new WlmPaginationStrategy(10, null, SortBy.NODE_ID, SortOrder.ASC, response);
        SortOrder sortOrder = SortOrder.ASC;  
            new WlmStatsResponse(ClusterName.DEFAULT, statsList, Collections.emptyList())
            SortOrder.ASC,
                    assertTrue(  
            currentHash,
    public void testValidTokenParsing() {
        );  
    }
        List<WlmStats> stats = generateRandomWlmStats(count);  
        assertNull(strategy.getResponseToken());
import org.opensearch.wlm.stats.WlmStats;  
        ).findIndex(statsList, "node-1", "group-1");
        OpenSearchParseException ex = assertThrows(OpenSearchParseException.class, () -> new WlmPaginationStrategy.WlmStrategyToken(token));
        assertTrue(strategy.getRequestedEntities().isEmpty());  
        );
            null,
                assertNotNull(stats);
        assertEquals("node1", parsed.getNodeId());  
                        stats.get(0)
        }
        return new WlmStatsResponse(ClusterName.DEFAULT, stats, Collections.emptyList());
            new WlmStatsResponse(ClusterName.DEFAULT, statsList, Collections.emptyList())
            sortBy  
            SortBy.NODE_ID,
    public void testPaginationWithExactPageSize() {
    public void testEmpty() {
import java.util.List;  
        assertEquals("groupX", parsed.getWorkloadGroupId());
                List<WlmStats> stats = strategy.getRequestedEntities();  
        int pageSize = 3;  
        SortOrder sortOrder = SortOrder.ASC;  
        assertNotNull(token);  
            SortOrder.ASC,
        SortBy sortBy = SortBy.WORKLOAD_GROUP;
    }
        int pageSize = 10;
    }  
import org.opensearch.OpenSearchParseException;
        WlmPaginationStrategy paginationStrategy = new WlmPaginationStrategy(pageSize, nextToken, sortBy, sortOrder, response);  
        DiscoveryNode node = mock(DiscoveryNode.class);
        WlmStatsResponse response = mockResponse(5);
        Map<String, WorkloadGroupStats.WorkloadGroupStatsHolder> groupStats = new HashMap<>();  
            "nonexistentNode",
            null,
        groupStats.put("group-1", holder);
        String nextToken = null;  
        WlmStatsResponse response = mockResponse(5);  // Mocking a response with 5 entries
    }
}
                            ) <= (sortOrder == SortOrder.ASC ? 0 : 1)  
        String nodeId = "node1";
            null,
        assertEquals(3, paginationStrategy.getRequestedEntities().size());
                            .keySet()
                            .iterator()
        int pageSize = 10;  
    public void testTokenStructureValidationFailure() {  
import static org.mockito.Mockito.when;
    public void testSorting() {  
            pageSize,
 */  
        );
                WlmPaginationStrategy strategy = new WlmPaginationStrategy(
    private WlmStatsResponse mockResponse(int count) {
    }  
    public void testEmptyStatsNoResponseToken() {
        SortBy sortBy = SortBy.WORKLOAD_GROUP;
        List<WlmStats> statsList = generateRandomWlmStats(3);
import org.opensearch.wlm.stats.SortBy;
    public void testFindIndex_found() {
        assertFalse(token.isEmpty());
        SortBy sortBy = SortBy.WORKLOAD_GROUP;
        OptionalInt result = new WlmPaginationStrategy(  
    }
    }
        SortOrder sortOrder = SortOrder.ASC;  
        WlmPaginationStrategy.WlmStrategyToken token = new WlmPaginationStrategy.WlmStrategyToken(tokenStr);  
        int pageSize = 10;
        when(node.getId()).thenReturn("node-1");  
                                stats.get(1).getWorkloadGroupStats().getStats().keySet().iterator().next()
        WlmPaginationStrategy paginationStrategy = new WlmPaginationStrategy(  
    }  
        assertNotNull(paginationStrategy.getRequestedEntities());  
        assertEquals("Parameter [next_token] has been tainted and is incorrect. Please provide a valid [next_token].", thrown.getMessage());
            DiscoveryNode mockNode = DiscoveryNodeMock.createDummyNode(i);
        WlmStatsResponse response = mockResponse(5);
            Map<String, WorkloadGroupStats.WorkloadGroupStatsHolder> workloadStats = new HashMap<>();
        assertNull(paginationStrategy.getResponseToken()); // Should not have a next page
        String sortBy = SortBy.WORKLOAD_GROUP.name();
    public void testInvalidTokenStructureTooShort() {
        WlmStatsResponse response = mockResponse(0);
                assertFalse(stats.isEmpty());  
        WorkloadGroupStats stats = new WorkloadGroupStats(groupStats);  
            new WlmStatsResponse(ClusterName.DEFAULT, statsList, Collections.emptyList())  
        OpenSearchParseException thrown = assertThrows(OpenSearchParseException.class, () -> {
            "dummyhash",
        String nextToken = null;
    public void testInvalidTokenEmptyFields() {
            workloadGroupCount,  
        SortBy sortBy = SortBy.WORKLOAD_GROUP;
        assertNotNull(paginationStrategy.getResponseToken()); // Should have a next page token  
        assertEquals("ASC", parsed.getSortOrder());
            sortOrder,
        when(node.getId()).thenReturn("node-1");
            10,
        assertTrue(ex.getMessage().contains("Invalid pagination token format"));
            "NODE_ID"
        String token = WlmPaginationStrategy.WlmStrategyToken.generateEncryptedToken(  
        int workloadGroupCount = 5;
                } else if (sortBy == SortBy.WORKLOAD_GROUP) {
 * The OpenSearch Contributors require contributions made to  
        List<WlmStats> statsList = mockResponse(10).getNodes();
        assertFalse(result.isPresent());
        SortBy sortBy = SortBy.WORKLOAD_GROUP;
import org.opensearch.cluster.ClusterName;  
        WlmStatsResponse response = mockResponse(5);
        WlmPaginationStrategy paginationStrategy = new WlmPaginationStrategy(pageSize, nextToken, sortBy, sortOrder, response);  
        // SortOrder and SortBy are blank
        SortOrder sortOrder = SortOrder.ASC;
        OpenSearchParseException ex = assertThrows(OpenSearchParseException.class, () -> strategy.getStartIndex(statsList, token));
        return statsList;
        int pageSize = 3;
        OptionalInt result = new WlmPaginationStrategy(
        List<WlmStats> statsList = new ArrayList<>();
import java.util.ArrayList;  
            SortOrder.ASC,  
    public void testGetStartIndexInvalidTokenThrows() {
        WlmPaginationStrategy paginationStrategy = new WlmPaginationStrategy(pageSize, nextToken, sortBy, sortOrder, response);
        String nextToken = null;
        assertTrue(paginationStrategy.getRequestedEntities().isEmpty());
        WlmStatsResponse response = new WlmStatsResponse(ClusterName.DEFAULT, new ArrayList<>(), Collections.emptyList());  
        assertNotNull(paginationStrategy.getRequestedEntities());
    public void testFindIndex_notFound() {
            SortBy.NODE_ID,
import org.opensearch.cluster.node.DiscoveryNode;
    }  
            1,
                if (sortBy == SortBy.NODE_ID) {
        assertEquals(3, paginationStrategy.getRequestedEntities().size());
    public void testStart() {
            SortOrder.ASC,
                );
                    );  
        Map<String, WorkloadGroupStats.WorkloadGroupStatsHolder> groupStats = new HashMap<>();  
        assertEquals("hashval", parsed.getHash());  
    }  
 *
        assertEquals("NODE_ID", parsed.getSortBy());
            WorkloadGroupStats.WorkloadGroupStatsHolder statsHolder = new WorkloadGroupStats.WorkloadGroupStatsHolder();
    public void testPageLimit() {
        assertEquals(1, result.getAsInt());
                        stats.get(0).getNode().getId().compareTo(stats.get(1).getNode().getId()) <= (sortOrder == SortOrder.ASC ? 0 : 1)
 * SPDX-License-Identifier: Apache-2.0
            workloadGroupId,
        String currentHash = "somehashvalue";
        String nextToken = null;  
        assertTrue(ex.getMessage().contains("Invalid or outdated token"));  
        String token = PaginationStrategy.encryptStringToken("a|b|c");  
        WlmPaginationStrategy paginationStrategy = new WlmPaginationStrategy(pageSize, nextToken, sortBy, sortOrder, response);
    }
                            .getStats()  
/*  
    }  
    public void testInvalid() {
            WlmStats wlmStats = new WlmStats(mockNode, new WorkloadGroupStats(workloadStats));
            null,  
        assertEquals(5, paginationStrategy.getRequestedEntities().size());
    }
                    );
    }
import org.opensearch.test.OpenSearchTestCase;
        String malformedToken = PaginationStrategy.encryptStringToken("abc|def|ghi"); // only 3 parts, not 6
        String tokenStr = WlmPaginationStrategy.WlmStrategyToken.generateEncryptedToken(
            "ASC",  
        List<WlmStats> statsList = List.of(wlmStats);  
            SortBy.NODE_ID,  
