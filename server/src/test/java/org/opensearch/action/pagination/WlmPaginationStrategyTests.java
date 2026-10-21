            pageSize,
        OpenSearchParseException ex = assertThrows(OpenSearchParseException.class, () -> new WlmPaginationStrategy.WlmStrategyToken(token));
        );
        SortOrder sortOrder = SortOrder.ASC;
            pageSize,
                        stats.get(0)
        String sortBy = SortBy.WORKLOAD_GROUP.name();
import org.opensearch.wlm.ResourceType;
        return statsList;
            new WlmStatsResponse(ClusterName.DEFAULT, statsList, Collections.emptyList())
        assertEquals("hashval", parsed.getHash());
            SortBy.NODE_ID,
            SortOrder.ASC,
                WlmPaginationStrategy strategy = new WlmPaginationStrategy(
        WlmPaginationStrategy paginationStrategy = new WlmPaginationStrategy(pageSize, nextToken, sortBy, sortOrder, response);
        Map<String, WorkloadGroupStats.WorkloadGroupStatsHolder> groupStats = new HashMap<>();
        assertFalse(token.isEmpty());
        assertEquals(5, paginationStrategy.getRequestedEntities().size());
    public void testValid() {
    }
    public void testPaginationWithMoreThanPageSize() {
        SortOrder sortOrder = SortOrder.ASC;
        WlmPaginationStrategy strategy = new WlmPaginationStrategy(
                    sortBy,
            response
        String token = PaginationStrategy.encryptStringToken("node1|groupX|7|hashval|ASC|NODE_ID");
            sortOrder,
        when(node.getId()).thenReturn("node-1");
    }
    public void testStart() {
    public void testFindIndex_found() {
        int workloadGroupCount = 5;
import org.opensearch.wlm.stats.WorkloadGroupStats;
    }
import org.opensearch.wlm.stats.SortOrder;
        // SortOrder and SortBy are blank
        SortBy sortBy = SortBy.WORKLOAD_GROUP;
            "NODE_ID"
            SortOrder.ASC,
        String nextToken = null;
            SortBy.NODE_ID,
                List<WlmStats> stats = strategy.getRequestedEntities();
    private WlmStatsResponse mockResponse(int count) {
                    new WlmStatsResponse(ClusterName.DEFAULT, statsList, Collections.emptyList())
        String sortOrder = SortOrder.ASC.name();
    }
import java.util.Collections;
            SortBy.NODE_ID,
        OpenSearchParseException ex = assertThrows(OpenSearchParseException.class, () -> new WlmPaginationStrategy.WlmStrategyToken(token));
        String malformedToken = PaginationStrategy.encryptStringToken("abc|def|ghi"); // only 3 parts, not 6
                    assertTrue(
            WorkloadGroupStats.WorkloadGroupStatsHolder statsHolder = new WorkloadGroupStats.WorkloadGroupStatsHolder();
            SortBy.WORKLOAD_GROUP,
        assertEquals(5, paginationStrategy.getRequestedEntities().size());
        assertNotNull(paginationStrategy.getRequestedEntities());
                            .next()
        assertTrue(ex.getMessage().contains("Invalid pagination token format"));
        OpenSearchParseException ex = assertThrows(OpenSearchParseException.class, () -> strategy.getStartIndex(statsList, token));
                    5,
                            .keySet()
        List<WlmStats> statsList = mockResponse(10).getNodes();
        }
    }
    }
        DiscoveryNode node = mock(DiscoveryNode.class);
        WlmStatsResponse response = mockResponse(5);
    public void testTokenStructureValidationFailure() {
public class WlmPaginationStrategyTests extends OpenSearchTestCase {
        WlmStatsResponse response = mockResponse(5);  // Mocking a response with 5 entries
                                stats.get(1).getWorkloadGroupStats().getStats().keySet().iterator().next()
            SortOrder.ASC,
        }
        assertEquals("groupX", parsed.getWorkloadGroupId());
        OptionalInt result = new WlmPaginationStrategy(
        Map<ResourceType, WorkloadGroupStats.ResourceStats> resourceMap = Map.of(ResourceType.CPU, dummyStats);
        assertNotNull(paginationStrategy.getResponseToken()); // Should have a next page token
        List<WlmStats> stats = generateRandomWlmStats(count);
            WlmStats wlmStats = new WlmStats(mockNode, new WorkloadGroupStats(workloadStats));
        WlmStatsResponse response = mockResponse(3);
        OpenSearchParseException ex = assertThrows(
    public void testInvalidTokenStructureTooShort() {
            workloadGroupCount,
                    );
            null,
import org.opensearch.action.admin.cluster.wlm.WlmStatsResponse;
import org.opensearch.cluster.node.DiscoveryNode;
            new WlmPaginationStrategy(pageSize, nextToken, sortBy, sortOrder, response);
    }
            null,
    public void testEmpty() {
        WorkloadGroupStats.WorkloadGroupStatsHolder holder = new WorkloadGroupStats.WorkloadGroupStatsHolder(1, 2, 3, 4, 5, 6, resourceMap);
        WlmPaginationStrategy paginationStrategy = new WlmPaginationStrategy(
        for (int i = 1; i <= count; i++) {
            null,
            for (SortOrder sortOrder : SortOrder.values()) {
            workloadGroupId,
 * The OpenSearch Contributors require contributions made to
/*
        assertNull(paginationStrategy.getResponseToken()); // Should not have a next page
        assertEquals("NODE_ID", parsed.getSortBy());
        assertEquals("Parameter [next_token] has been tainted and is incorrect. Please provide a valid [next_token].", thrown.getMessage());
        assertTrue(paginationStrategy.getRequestedEntities().isEmpty());
            response
            DiscoveryNode mockNode = DiscoveryNodeMock.createDummyNode(i);
        DiscoveryNode node = mock(DiscoveryNode.class);
        assertNotNull(token);
        String nextToken = null;
        int pageSize = 10;
    }
 */
            workloadStats.put("workload-group-" + i, statsHolder);
                            .getWorkloadGroupStats()
        String nextToken = null;
        assertEquals(pageSize, paginationStrategy.getRequestedEntities().size());
        assertEquals("ASC", parsed.getSortOrder());
        WlmStatsResponse response = mockResponse(0);
        WlmPaginationStrategy paginationStrategy = new WlmPaginationStrategy(pageSize, nextToken, sortBy, sortOrder, response);
        SortBy sortBy = SortBy.WORKLOAD_GROUP;
    public void testInvalidTokenEmptyFields() {
    public List<WlmStats> generateRandomWlmStats(int count) {
        List<WlmStats> statsList = generateRandomWlmStats(3);
                            .iterator()
            nodeId,
            "nonexistentGroup",
            SortOrder.ASC,
        List<WlmStats> statsList = List.of(wlmStats);
        SortBy sortBy = SortBy.WORKLOAD_GROUP;
        for (SortBy sortBy : SortBy.values()) {
                            .getStats()
    }
        WlmStats wlmStats = new WlmStats(node, stats);
        when(node.getId()).thenReturn("node-1");
        String token = PaginationStrategy.encryptStringToken("a|b|c");
                }
        assertTrue(ex.getMessage().contains("Invalid or outdated token"));
            10,
        assertTrue(ex.getMessage().contains("Invalid pagination token format"));
                        "Sorting should be in " + sortOrder + " order by node_id",
    }
            3,
        int pageSize = 10;
            null,
        assertTrue(result.isPresent());
}
    }
        int pageSize = 10;
            "nonexistentNode",
        OptionalInt result = new WlmPaginationStrategy(
        assertEquals(1, result.getAsInt());
    public void testInvalid() {
    public void testToken() {
        groupStats.put("group-1", holder);
import java.util.Map;
            SortBy.WORKLOAD_GROUP,
    }
    public void testGetStartIndexInvalidTokenThrows() {
    }
                } else if (sortBy == SortBy.WORKLOAD_GROUP) {
        ).findIndex(statsList, "node-1", "missing-group");
    }
        });
        WlmStatsResponse response = mockResponse(5);
        );
    }
        SortOrder sortOrder = SortOrder.ASC;
            null,
            currentHash,
                );
    public void testEmptyStatsNoResponseToken() {
import org.opensearch.cluster.ClusterName;
import java.util.List;
        WlmPaginationStrategy.WlmStrategyToken token = new WlmPaginationStrategy.WlmStrategyToken(tokenStr);
                if (sortBy == SortBy.NODE_ID) {
                assertFalse(stats.isEmpty());
import java.util.ArrayList;
    public void testPaginationWithExactPageSize() {
        WlmStatsResponse response = mockResponse(5);
        );
        SortBy sortBy = SortBy.WORKLOAD_GROUP;
                assertNotNull(stats);
        int pageSize = 3;
        String nodeId = "node1";
                    );
        );
            OpenSearchParseException.class,
        );
        assertEquals(3, paginationStrategy.getRequestedEntities().size());
    public void testPageLimit() {
 * SPDX-License-Identifier: Apache-2.0
            1,
        );
            () -> new WlmPaginationStrategy(5, malformedToken, SortBy.NODE_ID, SortOrder.DESC, mockResponse(1))
        List<WlmStats> statsList = new ArrayList<>();
            new WlmStatsResponse(ClusterName.DEFAULT, statsList, Collections.emptyList())
    }
        return new WlmStatsResponse(ClusterName.DEFAULT, stats, Collections.emptyList());
        WlmStatsResponse response = mockResponse(6);
            "ASC",
            new WlmStatsResponse(ClusterName.DEFAULT, statsList, Collections.emptyList())
    }
        assertEquals(3, paginationStrategy.getRequestedEntities().size());
import org.opensearch.OpenSearchParseException;
        WlmPaginationStrategy paginationStrategy = new WlmPaginationStrategy(pageSize, nextToken, sortBy, sortOrder, response);
        int pageSize = 3;
        WorkloadGroupStats stats = new WorkloadGroupStats(groupStats);
        WorkloadGroupStats stats = new WorkloadGroupStats(groupStats);
 * compatible open source license.
        WlmStats wlmStats = new WlmStats(node, stats);
import org.opensearch.wlm.stats.WlmStats;
        String nextToken = null;
                            .compareTo(
        assertEquals(7, parsed.getWorkloadGroupCount());
 *
import java.util.HashMap;
                    null,
        String nextToken = "invalid-token";
        int pageSize = 3;
                    assertTrue(
        OpenSearchParseException thrown = assertThrows(OpenSearchParseException.class, () -> {
            }
                            ) <= (sortOrder == SortOrder.ASC ? 0 : 1)
        assertTrue(strategy.getRequestedEntities().isEmpty());
        String workloadGroupId = "workloadGroup1";
        SortOrder sortOrder = SortOrder.ASC;
            statsList.add(wlmStats);
    public void testFindIndex_notFound() {
        String token = WlmPaginationStrategy.WlmStrategyToken.generateEncryptedToken(
package org.opensearch.action.pagination;
import static org.mockito.Mockito.mock;
        Map<String, WorkloadGroupStats.WorkloadGroupStatsHolder> groupStats = new HashMap<>();
                        "Sorting should be in " + sortOrder + " order by workload_group",
        WlmPaginationStrategy paginationStrategy = new WlmPaginationStrategy(pageSize, nextToken, sortBy, sortOrder, response);
        assertNotNull(paginationStrategy);
        WlmPaginationStrategy strategy = new WlmPaginationStrategy(10, null, SortBy.NODE_ID, SortOrder.ASC, response);
    public void testSorting() {
            sortBy
        assertFalse(result.isPresent());
        ).findIndex(statsList, "node-1", "group-1");
import org.opensearch.test.OpenSearchTestCase;
            Map<String, WorkloadGroupStats.WorkloadGroupStatsHolder> workloadStats = new HashMap<>();
    }
        int pageSize = 10;
        WlmPaginationStrategy paginationStrategy = new WlmPaginationStrategy(
        assertNull(strategy.getResponseToken());
                    sortOrder,
        List<WlmStats> statsList = List.of(wlmStats);
        WlmStatsResponse response = new WlmStatsResponse(ClusterName.DEFAULT, new ArrayList<>(), Collections.emptyList());
                        stats.get(0).getNode().getId().compareTo(stats.get(1).getNode().getId()) <= (sortOrder == SortOrder.ASC ? 0 : 1)
        String currentHash = "somehashvalue";
        WorkloadGroupStats.ResourceStats dummyStats = new WorkloadGroupStats.ResourceStats(0.1, 2, 3);
import static org.mockito.Mockito.when;
import org.opensearch.wlm.stats.SortBy;
    }
        String token = PaginationStrategy.encryptStringToken("node1|group1|3|hashval||");
            "dummyhash",
        String tokenStr = WlmPaginationStrategy.WlmStrategyToken.generateEncryptedToken(
 * this file be licensed under the Apache-2.0 license or a
        assertEquals("node1", parsed.getNodeId());
import java.util.OptionalInt;
        assertNotNull(paginationStrategy.getRequestedEntities());
        assertTrue(ex.getMessage().contains("Invalid pagination token format"));
        SortOrder sortOrder = SortOrder.ASC;
    public void testValidTokenParsing() {
        SortBy sortBy = SortBy.WORKLOAD_GROUP;
            SortOrder.ASC,
        WlmPaginationStrategy.WlmStrategyToken parsed = new WlmPaginationStrategy.WlmStrategyToken(token);
            1,
