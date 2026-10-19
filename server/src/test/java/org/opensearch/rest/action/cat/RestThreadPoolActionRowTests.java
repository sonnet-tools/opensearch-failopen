        final int parallelism = 4;
            .active(0)
        Table table = action.getTableWithHeader(new FakeRestRequest.Builder(xContentRegistry()).build());  
        final String host = "h1";  
        // Optionally assert other columns as well
        assertTrue(e.getMessage().contains("only [true] or [false] are allowed"));
                "core",  
            .rejected(0)
        // Arrange: Build minimal fake cluster state
        when(nodeInfo.getInfo(ThreadPoolInfo.class)).thenReturn(threadPoolInfo);  
    }  
                }
        ).build();
                Map.entry("size", new String[] { "sz" }),
        // 4. NodeInfoResponse  
            .largest(0)  
            .completed(0)
                Map.entry("pid", new String[] { "p" }),
        assertEquals(poolName, row.get(idx.get("name")).value);
        FakeRestRequest request = new FakeRestRequest.Builder(xContentRegistry()).withParams(  
            m.put(t.getHeaders().get(i).value.toString(), i);
            Version.CURRENT  
        {
        Map<String, NodeStats> nodeStatsMap = Map.of(nodeId, nodeStats);
    }
                "active",
                "queue",  
        assertEquals(1, row.get(idx.get("active")).value);
        // Act: Call buildTable directly
            .rejected(0)
                .build();  
        final int port = 9400;
        assertEquals(0, row.get(idx.get("rejected")).value);
    public void testBuildTableWithForkJoinPool() throws Exception {  
            .parallelism(parallelism)  
        NodeInfo nodeInfo = mock(NodeInfo.class);
    public void testForkJoinRow() {
        final Long pid = 1234L;
            Collections.singletonMap("local", "notABoolean")
            .parallelism(parallelism)  
        Map<String, NodeInfo> nodeInfoMap = Map.of(nodeId, nodeInfo);
        List<Table.Cell> row = table.getRows().get(0);
    public void testForkJoinRowNullInfo() {
                "queue_size",
        final String nodeName = "n1";
        final int parallelism = Integer.MAX_VALUE;
import org.opensearch.cluster.node.DiscoveryNode;  
    public void testInvalidBooleanParam() {
        Table table = action.getTableWithHeader(new FakeRestRequest.Builder(xContentRegistry()).build());  
                Map.entry("queue", new String[] { "q" }),  
        when(nodesInfoResponse.getNodesMap()).thenReturn(nodeInfoMap);
        final String poolName = "fj_nullstats";
        assertEquals(1, row.get(idx.get("core")).value);
        final String eid = "e1";
        assertEquals(parallelism, row.get(idx.get("parallelism")).value);
        ThreadPool.Info scalingInfo = new ThreadPool.Info(poolName, ThreadPool.ThreadPoolType.SCALING, 1, 4, null, null);
                Map.entry("completed", new String[] { "c" }),
            .threads(0)
        String nodeId = "node-1";
        ThreadPool.Info fjInfo = new ThreadPool.Info(poolName, ThreadPool.ThreadPoolType.FORK_JOIN, parallelism, parallelism, null, null);  
        final Long pid = 5678L;
        // 6. Fake REST request
            .active(0)
                "largest",  
            .parallelism(parallelism)
            .threads(0)
            .waitTimeNanos(-1)
import java.util.ArrayList;
            .build();
        // 2. ClusterStateResponse  
            .queue(0)
            .largest(0)  
                "node_id",
        assertEquals(2, row.get(idx.get("queue")).value);  
        assertEquals(1, table.getRows().size());  
            RestThreadPoolAction action = new RestThreadPoolAction();
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> action.doCatRequest(request, client));
            .waitTimeNanos(-1)
            .build();
                "type",  
            .waitTimeNanos(-1)
            );
        ThreadPool.Info fjInfo = null; // null info
    }  
        for (int i = 0; i < poolNames.length; i++) {  
            .waitTimeNanos(-1)
            .parallelism(parallelism)
        final int parallelism = 3;
            .waitTimeNanos(-1)
                Map.entry("type", new String[] { "t" }),  
                "parallelism" };
import org.opensearch.action.admin.cluster.node.stats.NodesStatsResponse;  
        String[] poolNames = { "fj1", "fj2" };
        int[] parallelisms = { 3, 5 };  
        NodesStatsResponse nodesStatsResponse = mock(NodesStatsResponse.class);  
            .build();
        assertTrue(e.getMessage().contains("failed to parse setting [cluster_manager_timeout]"));
        final String poolName = "generic";
        ThreadPool.Info fjInfo = new ThreadPool.Info(poolName, ThreadPool.ThreadPoolType.FORK_JOIN, parallelism, parallelism, null, null);
        int port = 9300;  
                        }  
        final int parallelism = 0;  
        ClusterState mockClusterState = mock(ClusterState.class);
    public void testNonForkJoinRowScaling() {  
        assertEquals(3, row.get(idx.get("largest")).value);
        ClusterStateResponse clusterStateResponse = mock(ClusterStateResponse.class);
        ThreadPoolStats.Stats fjStats = new ThreadPoolStats.Stats.Builder().name(poolName)
 */
import org.opensearch.threadpool.ThreadPoolInfo;  
            // Expected headers in order (from the code)
        assertEquals(parallelism, row.get(idx.get("parallelism")).value);  
                poolNames[i],
            .rejected(0)
        when(processInfo.getId()).thenReturn(1234L);
            Collections.emptySet(),
        Table table = action.getTableWithHeader(new FakeRestRequest.Builder(xContentRegistry()).build());
import org.opensearch.action.admin.cluster.node.info.NodesInfoResponse;
                "name",
                "ip",  
            Table table = action.getTableWithHeader(new FakeRestRequest.Builder(xContentRegistry()).build());  
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> action.doCatRequest(request, client));
            .completed(10L)
                .queue(0)
import org.opensearch.Version;
            .build();
                "node_name",
    public void testForkJoinRowParallelismZero() {
import org.opensearch.action.admin.cluster.node.info.NodeInfo;  
            .active(0)
            .queue(0)
        String poolName = "jvector";
package org.opensearch.rest.action.cat;  
        }  
        action.writeRow(table, nodeName, nodeId, eid, pid, host, ip, port, poolName, fjInfo, dummyStats);
        final String poolName = "jvector";  
                Map.entry("name", new String[] { "n" }),
import java.util.Collections;
import org.opensearch.transport.client.node.NodeClient;
        ThreadPoolStats.Stats dummyStats = new ThreadPoolStats.Stats.Builder().name(poolName)
                Map.entry("node_name", new String[] { "nn" }),
                Map.entry("total_wait_time", new String[] { "twt" }),
            .largest(0)
                .completed(0)  
    }  
        ThreadPoolStats.Stats stats = new ThreadPoolStats.Stats.Builder().name(poolName)
        assertNull(row.get(idx.get("max")).value);  
            );
    public void testMultipleForkJoinRows() {
                    if (aliasValue != null) {
            action.writeRow(table, "n" + i, "id" + i, "eid" + i, 1L, "h" + i, "ip" + i, 9300 + i, poolNames[i], fjInfo, dummyStats);
        ThreadPool.Info fjInfo = new ThreadPool.Info(poolName, ThreadPool.ThreadPoolType.FORK_JOIN, parallelism, parallelism, null, null);  
        assertEquals(parallelism, table.getRows().get(0).get(indexOf(table).get("parallelism")).value);
        // 5. ThreadPoolStats.Stats for ForkJoin  
        assertNull(row.get(idx.get("parallelism")).value);
import java.util.HashMap;
import org.opensearch.test.OpenSearchTestCase;  
        when(nodesStatsResponse.getNodes()).thenReturn(List.of(nodeStats));
    public void setUp() throws Exception {
            List<Table.Cell> headers = table.getHeaders();
            .largest(0)
                parallelisms[i],
        assertEquals(0, row.get(idx.get("active")).value);  
        for (int i = 0; i < t.getHeaders().size(); i++) {
            .build();
        }  
        when(clusterStateResponse.getState()).thenReturn(mockClusterState);
                Map.entry("core", new String[] { "cr" }),  
                assertEquals("Header at " + i, expectedHeaders[i], headers.get(i).value.toString());
                .active(0)  
        Map<String, Integer> idx = indexOf(table);
            .largest(0)  
                parallelisms[i],
                Map.entry("parallelism", new String[] { "pl" })
        RestThreadPoolAction action = new RestThreadPoolAction();  
                if (aliases != null) {  
        assertNull(row.get(idx.get("core")).value);
        ThreadPool.Info fjInfo = new ThreadPool.Info(poolName, ThreadPool.ThreadPoolType.FORK_JOIN, parallelism, parallelism, null, null);
    }
        when(mockClusterState.nodes()).thenReturn(discoveryNodes);  
        String ip = "127.0.0.1";
import java.util.Map;
    public void testForkJoinRowNullStats() {  
            .parallelism(parallelism)  
        assertEquals(parallelism, table.getRows().get(0).get(indexOf(table).get("parallelism")).value);
                null
    public void testForkJoinRowParallelismNegative() {  
import java.util.List;  
        final int port = 9300;
import java.net.InetAddress;
        assertEquals(parallelism, table.getRows().get(0).get(indexOf(table).get("parallelism")).value);  
        assertEquals(parallelism, table.getRows().get(0).get(indexOf(table).get("parallelism")).value);  
                "ephemeral_node_id",  
        // Assert
            .rejected(0)
    }
        action.writeRow(table, "n", "id", "eid", 1L, "h", "ip", 9300, poolName, fjInfo, dummyStats);
                .threads(0)
        Map<String, Integer> idx = indexOf(table);
        assertEquals("fork_join", row.get(idx.get("type")).value);  
        assertEquals(stats.getWaitTime(), row.get(idx.get("total_wait_time")).value);
        ).build();
            .largest(3)
    public void testInvalidTimeoutParam() {
            .build();
            Collections.emptyMap(),
            .waitTimeNanos(-1)  
        when(nodeInfo.getInfo(ProcessInfo.class)).thenReturn(processInfo);  
                Map.entry("host", new String[] { "h" }),
    }
                ThreadPool.ThreadPoolType.FORK_JOIN,  
            .rejected(0)  
                Map.entry("largest", new String[] { "l" }),  
import org.opensearch.common.Table;
            .queue(0)  
/*  
        assertEquals(10L, row.get(idx.get("completed")).value);  
            .threads(0)
        NodesInfoResponse nodesInfoResponse = mock(NodesInfoResponse.class);  
            .threads(0)
        final String nodeId = "id1";  
    }
        DiscoveryNodes discoveryNodes = DiscoveryNodes.builder().add(discoveryNode).build();
        final String eid = "e2";  
            .completed(0)
        return m;
        RestRequest request = new FakeRestRequest.Builder(xContentRegistry()).build();
                    } else {
        ThreadPoolStats threadPoolStats = new ThreadPoolStats(new ArrayList<>(List.of(fjStats)));
            assertEquals("Header count", expectedHeaders.length, headers.size());  
                "size",
            .threads(0)  
                Map.entry("node_id", new String[] { "id" }),
                        fail("No alias found for header: " + name);
        String nodeName = "n1";  
        action.writeRow(table, "n", "id", "eid", 1L, "h", "ip", 9300, poolName, fjInfo, dummyStats);
        FakeRestRequest request = new FakeRestRequest.Builder(xContentRegistry()).withParams(  
        assertEquals(4, row.get(idx.get("max")).value);  
import static org.mockito.Mockito.when;
                Map.entry("port", new String[] { "po" }),
import org.opensearch.core.common.transport.TransportAddress;  
        assertEquals("scaling", row.get(idx.get("type")).value);  
            ThreadPool.Info fjInfo = new ThreadPool.Info(
            .queue(0)  
                "rejected",
        ThreadPoolStats.Stats dummyStats = new ThreadPoolStats.Stats.Builder().name(poolName)
        final String ip = "127.0.0.1";
        ThreadPoolStats.Stats dummyStats = new ThreadPoolStats.Stats.Builder().name(poolName)
        Table table = action.getTableWithHeader(new FakeRestRequest.Builder(xContentRegistry()).build());  
                .largest(0)
            }  
        assertEquals(0, row.get(idx.get("queue")).value);
            .queue(0)  
        assertNull(row.get(idx.get("keep_alive")).value);
                Map.entry("pool_size", new String[] { "psz" }),
        assertEquals(0, row.get(idx.get("pool_size")).value);
                "max",
        Table table = action.getTableWithHeader(new FakeRestRequest.Builder(xContentRegistry()).build());
        action.writeRow(table, nodeName, nodeId, eid, pid, host, ip, port, poolName, scalingInfo, stats);
        ProcessInfo processInfo = mock(ProcessInfo.class);
        assertNull(table.getRows().get(0).get(indexOf(table).get("parallelism")).value);  
        NodeStats nodeStats = mock(NodeStats.class);  
        // All stat fields should be defaults (0, -1, or null), but parallelism should still be present  
        assertEquals(3, table.getRows().get(0).get(idx.get("parallelism")).value);
                .rejected(0)
                Map.entry("ip", new String[] { "i" }),  
        final int parallelism = -5;
    private RestThreadPoolAction action;
        // 1. Discovery node
        ThreadPool.Info fjInfo = new ThreadPool.Info(poolName, ThreadPool.ThreadPoolType.FORK_JOIN, parallelism, parallelism, null, null);  
import org.opensearch.test.rest.FakeRestRequest;
import org.opensearch.threadpool.ThreadPool;
import org.opensearch.rest.RestRequest;
            for (int i = 0; i < expectedHeaders.length; i++) {
                Map.entry("queue_size", new String[] { "qs" }),
            nodeId,
                Map.entry("ephemeral_node_id", new String[] { "eid" }),  
                "keep_alive",  
        NodeClient client = mock(NodeClient.class);
        action.writeRow(table, "n", "id", "eid", 1L, "h", "ip", 9300, poolName, fjInfo, dummyStats);
            .parallelism(parallelism)  
        List<Table.Cell> row = table.getRows().get(0);  
                "total_wait_time",
                .parallelism(parallelisms[i])
        Table table = action.getTableWithHeader(new FakeRestRequest.Builder(xContentRegistry()).build());
        ThreadPoolInfo threadPoolInfo = new ThreadPoolInfo(List.of(fjInfo));
        assertEquals(poolName, row.get(idx.get("name")).value);
                    }  
                Map.entry("keep_alive", new String[] { "ka" }),  
        assertNull(row.get(idx.get("size")).value);
        assertEquals(0, row.get(idx.get("largest")).value);
                String[] aliases = expectedAliases.get(name);
        Table table = action.getTableWithHeader(new FakeRestRequest.Builder(xContentRegistry()).build());
        when(nodeStats.getThreadPool()).thenReturn(threadPoolStats);
            // Check aliases
        Table table = action.getTableWithHeader(new FakeRestRequest.Builder(xContentRegistry()).build());  
import org.opensearch.cluster.ClusterState;
            .rejected(0)
            Collections.singletonMap("cluster_manager_timeout", "notATime")
        Map<String, Integer> m = new HashMap<>();  
import org.opensearch.cluster.node.DiscoveryNodes;
            nodeName,
            .build();  
                "pool_size",
        assertEquals(5, table.getRows().get(1).get(idx.get("parallelism")).value);  
        // 3. ThreadPool.Info for ForkJoin
        DiscoveryNode discoveryNode = new DiscoveryNode(  
        );
    }
                "pid",
import org.opensearch.threadpool.ThreadPoolStats;
        final int parallelism = 7;
        ThreadPoolStats.Stats dummyStats = new ThreadPoolStats.Stats.Builder().name(poolName)
        assertEquals(-1, row.get(idx.get("queue_size")).value);  
    public void testForkJoinRowLargeParallelism() {  
        final String nodeId = "id2";
        action.writeRow(table, "n", "id", "eid", 1L, "h", "ip", 9300, poolName, fjInfo, dummyStats);
            .largest(0)  
        assertEquals(1, table.getRows().size());
        when(nodesStatsResponse.getNodesMap()).thenReturn(nodeStatsMap);
        assertEquals(2, table.getRows().size());  
        action.writeRow(table, "n", "id", "eid", 1L, "h", "ip", 9300, poolName, fjInfo, dummyStats);  
        action = new RestThreadPoolAction();
            .queue(2)
            ThreadPoolStats.Stats dummyStats = new ThreadPoolStats.Stats.Builder().name(poolNames[i])  
        assertEquals(3, row.get(idx.get("pool_size")).value);
                    String aliasValue = header.attr.get("alias");
    @Override
            .completed(0)
        assertEquals("fork_join", row.get(idx.get("type")).value);
        ThreadPoolStats.Stats dummyStats = new ThreadPoolStats.Stats.Builder().name(poolName)  
        super.setUp();  
}  
        NodeClient client = mock(NodeClient.class);
            }
        final String poolName = "fj_zero";
    }
            .waitTimeNanos(111L)  
import org.opensearch.action.admin.cluster.node.stats.NodeStats;
            .completed(0)  
                Map.entry("max", new String[] { "mx" }),
                Map.entry("rejected", new String[] { "r" }),
            .rejected(5L)  
        }
            Map<String, String[]> expectedAliases = Map.ofEntries(  
        final String nodeName = "n2";
import org.opensearch.action.admin.cluster.state.ClusterStateResponse;
            new TransportAddress(InetAddress.getByName(ip), port),  
        int parallelism = 4;  
        ThreadPool.Info fjInfo = new ThreadPool.Info(poolName, ThreadPool.ThreadPoolType.FORK_JOIN, parallelism, parallelism, null, null);  
        final String poolName = "fj_large";
            .threads(3)  
                "host",
                Map.entry("active", new String[] { "a" }),
                .waitTimeNanos(-1)
        List<Table.Cell> row = table.getRows().get(0);
    public void testTableHeadersAndAliases() {  
        assertEquals(5L, row.get(idx.get("rejected")).value);
        Map<String, Integer> idx = indexOf(table);
            .queue(0)  
        final String ip = "127.0.0.2";  
    private static Map<String, Integer> indexOf(Table t) {
import java.util.Arrays;  
            .active(1)
                "port",
            .completed(0)
    }
        assertEquals(0, row.get(idx.get("completed")).value);  
    }
    }  
import static org.mockito.Mockito.mock;  
            for (Table.Cell header : headers) {  
public class RestThreadPoolActionRowTests extends OpenSearchTestCase {  
                null,  
 * SPDX-License-Identifier: Apache-2.0
        final String host = "h2";
        final String poolName = "fj_negative";
            .completed(0)
        assertEquals(poolName, row.get(idx.get("name")).value);
            // Check header names and order
                            assertTrue("Alias " + alias + " for header " + name, aliasList.contains(alias));
        RestThreadPoolAction action = new RestThreadPoolAction();  
    }
            String[] expectedHeaders = new String[] {  
            .parallelism(-1)
        Table table = action.buildTable(request, clusterStateResponse, nodesInfoResponse, nodesStatsResponse);
        when(nodeInfo.getInfo(ThreadPoolInfo.class)).thenReturn(threadPoolInfo);
        final String poolName = "fj_nullinfo";  
            .threads(0)
            .active(0)
                "completed",
        // Assert that the row is still written, and 'parallelism' is null
            .active(0)
import org.opensearch.monitor.process.ProcessInfo;
        assertEquals(-1, row.get(idx.get("total_wait_time")).value);
        Map<String, Integer> idx = indexOf(table);  
                String name = header.value.toString();
        ThreadPoolStats.Stats dummyStats = null; // null stats
                        for (String alias : aliases) {
            .active(0)  
                        List<String> aliasList = Arrays.asList(aliasValue.split(","));  
        String host = "localhost";
