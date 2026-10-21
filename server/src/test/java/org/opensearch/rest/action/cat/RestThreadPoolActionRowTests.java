                "size",
 */
import org.opensearch.test.rest.FakeRestRequest;
        final String nodeName = "n2";
        assertEquals(1, row.get(idx.get("active")).value);
public class RestThreadPoolActionRowTests extends OpenSearchTestCase {
        List<Table.Cell> row = table.getRows().get(0);
                .rejected(0)
            nodeName,
        ThreadPoolStats.Stats dummyStats = new ThreadPoolStats.Stats.Builder().name(poolName)
            .rejected(0)
        NodesStatsResponse nodesStatsResponse = mock(NodesStatsResponse.class);
        // All stat fields should be defaults (0, -1, or null), but parallelism should still be present
            .parallelism(parallelism)
            for (Table.Cell header : headers) {
            .threads(0)
                "node_name",
        ProcessInfo processInfo = mock(ProcessInfo.class);
    }
    }
        {
    }
        final String ip = "127.0.0.2";
                String[] aliases = expectedAliases.get(name);
        ThreadPool.Info fjInfo = new ThreadPool.Info(poolName, ThreadPool.ThreadPoolType.FORK_JOIN, parallelism, parallelism, null, null);
    private static Map<String, Integer> indexOf(Table t) {
                Map.entry("node_id", new String[] { "id" }),
            Collections.emptyMap(),
            .completed(0)
                Map.entry("core", new String[] { "cr" }),
                    } else {
        action.writeRow(table, "n", "id", "eid", 1L, "h", "ip", 9300, poolName, fjInfo, dummyStats);
        assertEquals(parallelism, row.get(idx.get("parallelism")).value);
                Map.entry("node_name", new String[] { "nn" }),
        Table table = action.getTableWithHeader(new FakeRestRequest.Builder(xContentRegistry()).build());
        assertNull(row.get(idx.get("size")).value);
        assertEquals(parallelism, row.get(idx.get("parallelism")).value);
        final String poolName = "fj_negative";
        String poolName = "jvector";
                "queue",
        }
        assertEquals(-1, row.get(idx.get("queue_size")).value);
        int[] parallelisms = { 3, 5 };
        }
        final String nodeName = "n1";
        assertEquals(-1, row.get(idx.get("total_wait_time")).value);
        final int parallelism = 0;
        final String eid = "e2";
        for (int i = 0; i < poolNames.length; i++) {
    }
        // Assert that the row is still written, and 'parallelism' is null
        // 1. Discovery node
        ThreadPool.Info fjInfo = new ThreadPool.Info(poolName, ThreadPool.ThreadPoolType.FORK_JOIN, parallelism, parallelism, null, null);
                .completed(0)
            .threads(0)
        final int port = 9300;
        assertEquals(1, table.getRows().size());
            .waitTimeNanos(-1)
        ClusterState mockClusterState = mock(ClusterState.class);
    public void testInvalidBooleanParam() {
                Map.entry("parallelism", new String[] { "pl" })
        assertEquals(3, row.get(idx.get("largest")).value);
        ThreadPool.Info fjInfo = null; // null info
        Table table = action.getTableWithHeader(new FakeRestRequest.Builder(xContentRegistry()).build());
            Map<String, String[]> expectedAliases = Map.ofEntries(
            .rejected(5L)
                .waitTimeNanos(-1)
import java.util.Map;
                .threads(0)
        ThreadPool.Info fjInfo = new ThreadPool.Info(poolName, ThreadPool.ThreadPoolType.FORK_JOIN, parallelism, parallelism, null, null);
import java.util.HashMap;
        String host = "localhost";
        for (int i = 0; i < t.getHeaders().size(); i++) {
                Map.entry("active", new String[] { "a" }),
        ).build();
            .threads(0)
        RestThreadPoolAction action = new RestThreadPoolAction();
    }
            .parallelism(parallelism)
import org.opensearch.rest.RestRequest;
            .completed(10L)
                "rejected",
        super.setUp();
            // Check header names and order
    }
            .waitTimeNanos(-1)
import org.opensearch.threadpool.ThreadPool;
            .build();
                "keep_alive",
import java.util.List;
        Table table = action.getTableWithHeader(new FakeRestRequest.Builder(xContentRegistry()).build());
        FakeRestRequest request = new FakeRestRequest.Builder(xContentRegistry()).withParams(
            .active(0)
            .largest(0)
        final String poolName = "generic";
                "completed",
        action.writeRow(table, "n", "id", "eid", 1L, "h", "ip", 9300, poolName, fjInfo, dummyStats);
            action.writeRow(table, "n" + i, "id" + i, "eid" + i, 1L, "h" + i, "ip" + i, 9300 + i, poolNames[i], fjInfo, dummyStats);
        final String poolName = "fj_nullinfo";
        // Act: Call buildTable directly
        assertEquals(0, row.get(idx.get("completed")).value);
import org.opensearch.action.admin.cluster.node.info.NodeInfo;
    public void testForkJoinRow() {
        int port = 9300;
        // 3. ThreadPool.Info for ForkJoin
        action.writeRow(table, "n", "id", "eid", 1L, "h", "ip", 9300, poolName, fjInfo, dummyStats);
            .threads(0)
                Map.entry("type", new String[] { "t" }),
import org.opensearch.cluster.node.DiscoveryNode;
        assertEquals(parallelism, table.getRows().get(0).get(indexOf(table).get("parallelism")).value);
        ThreadPoolStats.Stats dummyStats = new ThreadPoolStats.Stats.Builder().name(poolName)
            .build();
        assertEquals(4, row.get(idx.get("max")).value);
        when(nodeInfo.getInfo(ThreadPoolInfo.class)).thenReturn(threadPoolInfo);
        final Long pid = 5678L;
import org.opensearch.action.admin.cluster.node.stats.NodesStatsResponse;
    public void testForkJoinRowParallelismZero() {
        final int port = 9400;
                Map.entry("port", new String[] { "po" }),
                        fail("No alias found for header: " + name);
        int parallelism = 4;
import static org.mockito.Mockito.mock;
        final int parallelism = 3;
                "host",
        ).build();
        assertEquals(parallelism, table.getRows().get(0).get(indexOf(table).get("parallelism")).value);
            for (int i = 0; i < expectedHeaders.length; i++) {
                    }
            ThreadPoolStats.Stats dummyStats = new ThreadPoolStats.Stats.Builder().name(poolNames[i])
/*
        assertEquals(parallelism, table.getRows().get(0).get(indexOf(table).get("parallelism")).value);
        // 2. ClusterStateResponse
        Map<String, Integer> idx = indexOf(table);
            .queue(0)
        final Long pid = 1234L;
        assertNull(row.get(idx.get("core")).value);
    public void setUp() throws Exception {
import org.opensearch.action.admin.cluster.state.ClusterStateResponse;
            .threads(0)
        String nodeName = "n1";
        assertEquals(2, table.getRows().size());
        assertEquals(2, row.get(idx.get("queue")).value);
    public void testInvalidTimeoutParam() {
            nodeId,
            }
                parallelisms[i],
        final String host = "h2";
import org.opensearch.core.common.transport.TransportAddress;
            .active(0)
import org.opensearch.threadpool.ThreadPoolInfo;
            RestThreadPoolAction action = new RestThreadPoolAction();
        assertEquals("fork_join", row.get(idx.get("type")).value);
            .parallelism(parallelism)
                Map.entry("ephemeral_node_id", new String[] { "eid" }),
            .largest(0)
            .parallelism(parallelism)
        FakeRestRequest request = new FakeRestRequest.Builder(xContentRegistry()).withParams(
            .largest(0)
                Map.entry("host", new String[] { "h" }),
        DiscoveryNodes discoveryNodes = DiscoveryNodes.builder().add(discoveryNode).build();
                Map.entry("queue_size", new String[] { "qs" }),
            .parallelism(parallelism)
        assertNull(row.get(idx.get("parallelism")).value);
            );
        }
                "parallelism" };
        return m;
                        }
        assertNull(row.get(idx.get("keep_alive")).value);
            .queue(0)
                Map.entry("ip", new String[] { "i" }),
        assertEquals(3, table.getRows().get(0).get(idx.get("parallelism")).value);
            .active(0)
        ThreadPool.Info fjInfo = new ThreadPool.Info(poolName, ThreadPool.ThreadPoolType.FORK_JOIN, parallelism, parallelism, null, null);
            .completed(0)
                .active(0)
        assertEquals(poolName, row.get(idx.get("name")).value);
            .queue(0)
import static org.mockito.Mockito.when;
                "pid",
                "total_wait_time",
            Collections.singletonMap("local", "notABoolean")
        Map<String, Integer> idx = indexOf(table);
        when(nodesInfoResponse.getNodesMap()).thenReturn(nodeInfoMap);
        ThreadPoolStats threadPoolStats = new ThreadPoolStats(new ArrayList<>(List.of(fjStats)));
                "name",
        assertEquals(5L, row.get(idx.get("rejected")).value);
                }
        final String nodeId = "id2";
            .rejected(0)
                ThreadPool.ThreadPoolType.FORK_JOIN,
        assertEquals(0, row.get(idx.get("rejected")).value);
        assertEquals("fork_join", row.get(idx.get("type")).value);
        final String poolName = "fj_nullstats";
            .waitTimeNanos(111L)
        action.writeRow(table, nodeName, nodeId, eid, pid, host, ip, port, poolName, scalingInfo, stats);
            List<Table.Cell> headers = table.getHeaders();
        Table table = action.getTableWithHeader(new FakeRestRequest.Builder(xContentRegistry()).build());
                Map.entry("largest", new String[] { "l" }),
        final String host = "h1";
            // Expected headers in order (from the code)
                        List<String> aliasList = Arrays.asList(aliasValue.split(","));
            .rejected(0)
                Map.entry("pool_size", new String[] { "psz" }),
        final int parallelism = -5;
            );
            .queue(0)
 * SPDX-License-Identifier: Apache-2.0
        ThreadPoolStats.Stats dummyStats = new ThreadPoolStats.Stats.Builder().name(poolName)
        Table table = action.getTableWithHeader(new FakeRestRequest.Builder(xContentRegistry()).build());
            assertEquals("Header count", expectedHeaders.length, headers.size());
                Map.entry("name", new String[] { "n" }),
    }
        // 6. Fake REST request
                "node_id",
    }
            .queue(2)
    public void testNonForkJoinRowScaling() {
    public void testBuildTableWithForkJoinPool() throws Exception {
        assertTrue(e.getMessage().contains("failed to parse setting [cluster_manager_timeout]"));
        ThreadPoolStats.Stats stats = new ThreadPoolStats.Stats.Builder().name(poolName)
        action = new RestThreadPoolAction();
}
        when(clusterStateResponse.getState()).thenReturn(mockClusterState);
        assertEquals(0, row.get(idx.get("pool_size")).value);
import java.util.Arrays;
            .active(0)
            // Check aliases
        assertTrue(e.getMessage().contains("only [true] or [false] are allowed"));
        Map<String, Integer> m = new HashMap<>();
        action.writeRow(table, nodeName, nodeId, eid, pid, host, ip, port, poolName, fjInfo, dummyStats);
        Map<String, Integer> idx = indexOf(table);
        assertEquals(1, table.getRows().size());
            .waitTimeNanos(-1)
                            assertTrue("Alias " + alias + " for header " + name, aliasList.contains(alias));
        when(nodeStats.getThreadPool()).thenReturn(threadPoolStats);
        final String eid = "e1";
        ThreadPool.Info fjInfo = new ThreadPool.Info(poolName, ThreadPool.ThreadPoolType.FORK_JOIN, parallelism, parallelism, null, null);
        // Assert
            ThreadPool.Info fjInfo = new ThreadPool.Info(
        String nodeId = "node-1";
                "type",
        ThreadPool.Info scalingInfo = new ThreadPool.Info(poolName, ThreadPool.ThreadPoolType.SCALING, 1, 4, null, null);
    }
import org.opensearch.action.admin.cluster.node.info.NodesInfoResponse;
    }
                parallelisms[i],
    private RestThreadPoolAction action;
    }
        );
    public void testMultipleForkJoinRows() {
            .threads(0)
        String[] poolNames = { "fj1", "fj2" };
        DiscoveryNode discoveryNode = new DiscoveryNode(
    }
        when(nodesStatsResponse.getNodes()).thenReturn(List.of(nodeStats));
        ThreadPoolStats.Stats dummyStats = null; // null stats
        final String nodeId = "id1";
            Version.CURRENT
        ThreadPoolStats.Stats dummyStats = new ThreadPoolStats.Stats.Builder().name(poolName)
            .build();
            .build();
        ThreadPool.Info fjInfo = new ThreadPool.Info(poolName, ThreadPool.ThreadPoolType.FORK_JOIN, parallelism, parallelism, null, null);
        Table table = action.getTableWithHeader(new FakeRestRequest.Builder(xContentRegistry()).build());
        assertEquals(poolName, row.get(idx.get("name")).value);
        assertEquals(5, table.getRows().get(1).get(idx.get("parallelism")).value);
        NodeClient client = mock(NodeClient.class);
                null,
        final String poolName = "fj_large";
package org.opensearch.rest.action.cat;
            .rejected(0)
        RestThreadPoolAction action = new RestThreadPoolAction();
                String name = header.value.toString();
        assertNull(table.getRows().get(0).get(indexOf(table).get("parallelism")).value);
            .active(1)
                    String aliasValue = header.attr.get("alias");
            Collections.singletonMap("cluster_manager_timeout", "notATime")
import org.opensearch.test.OpenSearchTestCase;
        assertEquals("scaling", row.get(idx.get("type")).value);
                Map.entry("completed", new String[] { "c" }),
            .completed(0)
import org.opensearch.common.Table;
            .waitTimeNanos(-1)
            Collections.emptySet(),
        assertEquals(3, row.get(idx.get("pool_size")).value);
        ClusterStateResponse clusterStateResponse = mock(ClusterStateResponse.class);
        final String poolName = "jvector";
            Table table = action.getTableWithHeader(new FakeRestRequest.Builder(xContentRegistry()).build());
            .completed(0)
        assertEquals(1, row.get(idx.get("core")).value);
                "port",
import org.opensearch.Version;
    }
                null
            .largest(0)
                "queue_size",
            .completed(0)
                poolNames[i],
import org.opensearch.monitor.process.ProcessInfo;
        assertEquals(stats.getWaitTime(), row.get(idx.get("total_wait_time")).value);
        assertEquals(0, row.get(idx.get("largest")).value);
        final int parallelism = Integer.MAX_VALUE;
            .queue(0)
    public void testForkJoinRowNullInfo() {
        when(nodeInfo.getInfo(ThreadPoolInfo.class)).thenReturn(threadPoolInfo);
    }
            .queue(0)
        List<Table.Cell> row = table.getRows().get(0);
        action.writeRow(table, "n", "id", "eid", 1L, "h", "ip", 9300, poolName, fjInfo, dummyStats);
        final String poolName = "fj_zero";
        // Optionally assert other columns as well
import org.opensearch.transport.client.node.NodeClient;
        final String ip = "127.0.0.1";
            .build();
                "core",
                Map.entry("keep_alive", new String[] { "ka" }),
            .largest(0)
import org.opensearch.cluster.node.DiscoveryNodes;
        // Arrange: Build minimal fake cluster state
                Map.entry("max", new String[] { "mx" }),
        ThreadPoolStats.Stats dummyStats = new ThreadPoolStats.Stats.Builder().name(poolName)
            .rejected(0)
                        for (String alias : aliases) {
        action.writeRow(table, "n", "id", "eid", 1L, "h", "ip", 9300, poolName, fjInfo, dummyStats);
    public void testForkJoinRowNullStats() {
        NodeClient client = mock(NodeClient.class);
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> action.doCatRequest(request, client));
                .build();
        Table table = action.getTableWithHeader(new FakeRestRequest.Builder(xContentRegistry()).build());
import org.opensearch.action.admin.cluster.node.stats.NodeStats;
                "ip",
        RestRequest request = new FakeRestRequest.Builder(xContentRegistry()).build();
            .parallelism(-1)
        Map<String, NodeInfo> nodeInfoMap = Map.of(nodeId, nodeInfo);
                .parallelism(parallelisms[i])
        when(nodeInfo.getInfo(ProcessInfo.class)).thenReturn(processInfo);
        Map<String, NodeStats> nodeStatsMap = Map.of(nodeId, nodeStats);
    public void testForkJoinRowLargeParallelism() {
            .build();
            .largest(3)
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> action.doCatRequest(request, client));
        when(processInfo.getId()).thenReturn(1234L);
                "max",
            .active(0)
        assertEquals(parallelism, table.getRows().get(0).get(indexOf(table).get("parallelism")).value);
                "largest",
        NodesInfoResponse nodesInfoResponse = mock(NodesInfoResponse.class);
        // 5. ThreadPoolStats.Stats for ForkJoin
            .parallelism(parallelism)
    public void testForkJoinRowParallelismNegative() {
        assertEquals(poolName, row.get(idx.get("name")).value);
        final int parallelism = 7;
        assertEquals(0, row.get(idx.get("active")).value);
            .completed(0)
            m.put(t.getHeaders().get(i).value.toString(), i);
            .build();
        List<Table.Cell> row = table.getRows().get(0);
                Map.entry("total_wait_time", new String[] { "twt" }),
import java.net.InetAddress;
            new TransportAddress(InetAddress.getByName(ip), port),
        when(mockClusterState.nodes()).thenReturn(discoveryNodes);
        NodeStats nodeStats = mock(NodeStats.class);
                Map.entry("queue", new String[] { "q" }),
            .active(0)
    public void testTableHeadersAndAliases() {
import java.util.ArrayList;
                .largest(0)
                assertEquals("Header at " + i, expectedHeaders[i], headers.get(i).value.toString());
                Map.entry("size", new String[] { "sz" }),
        NodeInfo nodeInfo = mock(NodeInfo.class);
            .rejected(0)
                .queue(0)
                Map.entry("pid", new String[] { "p" }),
                    if (aliasValue != null) {
        Map<String, Integer> idx = indexOf(table);
            .waitTimeNanos(-1)
        assertEquals(10L, row.get(idx.get("completed")).value);
        Table table = action.getTableWithHeader(new FakeRestRequest.Builder(xContentRegistry()).build());
                "active",
                if (aliases != null) {
import java.util.Collections;
                Map.entry("rejected", new String[] { "r" }),
        assertNull(row.get(idx.get("max")).value);
        ThreadPoolStats.Stats fjStats = new ThreadPoolStats.Stats.Builder().name(poolName)
            .threads(3)
import org.opensearch.threadpool.ThreadPoolStats;
            String[] expectedHeaders = new String[] {
        when(nodesStatsResponse.getNodesMap()).thenReturn(nodeStatsMap);
        ThreadPoolInfo threadPoolInfo = new ThreadPoolInfo(List.of(fjInfo));
                "pool_size",
            }
        assertEquals(0, row.get(idx.get("queue")).value);
            .waitTimeNanos(-1)
            .largest(0)
        Table table = action.buildTable(request, clusterStateResponse, nodesInfoResponse, nodesStatsResponse);
        // 4. NodeInfoResponse
        final int parallelism = 4;
import org.opensearch.cluster.ClusterState;
    @Override
                "ephemeral_node_id",
        String ip = "127.0.0.1";
