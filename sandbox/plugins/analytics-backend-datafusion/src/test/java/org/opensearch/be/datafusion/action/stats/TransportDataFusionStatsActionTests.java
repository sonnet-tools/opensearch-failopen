            mockTransportService,
    // ---- Test 1: nodeOperation calls dataFusionService.getStats() ----
    }
        assertNotNull(result.getNativeExecutorsStats());
import org.opensearch.be.datafusion.stats.DataFusionStats;
        when(mockDataFusionService.getStats()).thenReturn(stats);
        taskMonitors.put("plan_setup", new TaskMonitorStats(1000, 1100, 1200, 0, 0));
            mockActionFilters,
        assertEquals(1, monitors.size());
        Map<String, TaskMonitorStats> monitors = result.getNativeExecutorsStats().getTaskMonitors();
    public void setUp() throws Exception {
    public void testFilteredStatsWithSingleSection() {
package org.opensearch.be.datafusion.action.stats;
        DataFusionStats stats = buildFullStats();
    private TransportDataFusionStatsAction action;
    // ---- Test 5: filteredStats with single section (io_runtime) ----
        assertNull(response.getStats());
import java.util.Set;
        assertNull(result.getFragmentExecutorGateStats());
        taskMonitors.put("stream_next", new TaskMonitorStats(700, 800, 900, 0, 0));
        action = new TransportDataFusionStatsAction(
        DataFusionStatsNodesRequest nodesRequest = new DataFusionStatsNodesRequest(new String[0], Collections.emptySet());
 *
    private DiscoveryNode localNode;
import static org.mockito.Mockito.verify;
        assertNotNull(result.getNativeExecutorsStats().getIoRuntime());
        ThreadPool mockThreadPool = mock(ThreadPool.class);
import org.opensearch.action.support.ActionFilters;
import org.opensearch.test.OpenSearchTestCase;
 * Unit tests for {@link TransportDataFusionStatsAction}.
 * {@code filteredStats()} helper. Uses Mockito to mock {@link DataFusionService}
    private ClusterService mockClusterService;
        assertNotNull(filtered.getSpillStats());
import org.opensearch.cluster.node.DiscoveryNode;
    public void testFilterIncludesSpillWhenRequested() {
    // ---- Test 3: filteredStats with null filter returns original stats ----
        PartitionGateStats fragmentExecutorGate = new PartitionGateStats("fragment_executor_gate", 64, 3, 150, 500, 0, 64, 0, 0);
import static org.mockito.Mockito.mock;
        );
        DataFusionStats result = TransportDataFusionStatsAction.filteredStats(stats, filter);
}
        assertNotNull(result);
    }
import org.opensearch.Version;
    public void testFilterExcludesSpillWhenNotRequested() {
        // io_runtime should be present
import java.util.Map;
    }
        action.nodeOperation(nodeRequest);
        assertEquals(stats.getNativeExecutorsStats().getIoRuntime(), result.getNativeExecutorsStats().getIoRuntime());
    }
        DataFusionStatsNodeRequest nodeRequest = new DataFusionStatsNodeRequest(nodesRequest);
        DataFusionStats filtered = TransportDataFusionStatsAction.filteredStats(statsWithSpill(), Set.of());
    private static DataFusionStats statsWithSpill() {
    public void testNodeOperationCallsGetStats() {
    public void testFilteredStatsWithNullStats() {
    public void testEmptyFilterReturnsAllSectionsIncludingSpill() {
        assertNull(result.getNativeExecutorsStats().getCpuRuntime());
        taskMonitors.put("coordinator_reduce", new TaskMonitorStats(100, 200, 300, 0, 0));
 */
        assertEquals("/mnt/spill", filtered.getSpillStats().getDirectory());
        DataFusionStatsNodeRequest nodeRequest = new DataFusionStatsNodeRequest(nodesRequest);
        DataFusionStats stats = buildFullStats();
    }
        RuntimeMetrics cpu = new RuntimeMetrics(8, 2000, 1000, 20, 10, 4, 40, 200, 16);
        when(mockClusterService.getClusterName()).thenReturn(new ClusterName("test-cluster"));
        DataFusionStatsNodesRequest nodesRequest = new DataFusionStatsNodesRequest(new String[0], Collections.emptySet());
    public void testNodeOperationReturnsCorrectResponse() {
        DataFusionStats result = TransportDataFusionStatsAction.filteredStats(null, Set.of("io_runtime"));
        DataFusionStatsNodesRequest nodesRequest = new DataFusionStatsNodesRequest(new String[0], Collections.emptySet());
    // ---- Test: empty filter returns all sections including spill ----
    }
import org.opensearch.be.datafusion.stats.PartitionGateStats;
    // ---- Test 8: nodeOperation handles service not started (IllegalStateException) ----
        filter.add("cpu_runtime");
        RuntimeMetrics io = new RuntimeMetrics(4, 1000, 500, 10, 5, 2, 20, 100, 8);
 */
        DataFusionStats stats = buildFullStats();
        NativeExecutorsStats nativeStats = new NativeExecutorsStats(io, cpu, taskMonitors);
        return new DataFusionStats(nativeStats, fragmentExecutorGate, null, null);
/*
import org.opensearch.be.datafusion.stats.RuntimeMetrics;
        assertNull(result);
    public void testNodeOperationHandlesServiceNotStarted() {
        filter.add("query_execution");
        assertNotNull(result);
    // ---- Helper: build a full DataFusionStats with all sections populated ----
        assertTrue(result.getNativeExecutorsStats().getTaskMonitors().isEmpty());
 * and the transport infrastructure.
    }
    private static DataFusionStats buildFullStats() {
        DataFusionStatsNodeResponse response = action.nodeOperation(nodeRequest);
import org.opensearch.be.datafusion.stats.NativeExecutorsStats;
        mockDataFusionService = mock(DataFusionService.class);
    // ---- Test: filter without "disk_spill" excludes SpillStats ----
        DataFusionStats stats = buildFullStats();
        taskMonitors.put("query_execution", new TaskMonitorStats(400, 500, 600, 0, 0));
import org.opensearch.threadpool.ThreadPool;
    public void testFilteredStatsWithMultipleSections() {
        Map<String, TaskMonitorStats> taskMonitors = new LinkedHashMap<>();
 * compatible open source license.
        assertNotNull(result.getFragmentExecutorGateStats());
import org.opensearch.transport.TransportService;
        when(mockDataFusionService.getStats()).thenReturn(stats);
/**
            mockClusterService,
        // fragment_executor_gate should be present
    public void testFilteredStatsWithNullFilter() {
        DataFusionStatsNodeRequest nodeRequest = new DataFusionStatsNodeRequest(nodesRequest);
        TransportService mockTransportService = mock(TransportService.class);
        assertNull(result.getNativeExecutorsStats().getIoRuntime());
import java.util.LinkedHashMap;
        DataFusionStats stats = buildFullStats();
        localNode = new DiscoveryNode("test-node", buildNewFakeTransportAddress(), Version.CURRENT);
    @Override
 * The OpenSearch Contributors require contributions made to
import java.util.HashSet;
        DataFusionStats filtered = TransportDataFusionStatsAction.filteredStats(statsWithSpill(), Set.of("io_runtime"));
        assertEquals(localNode, response.getNode());
 * <p>Tests the {@code nodeOperation()} method and the package-private
        DataFusionStats stats = buildFullStats();
        // gate stats should be null
 * this file be licensed under the Apache-2.0 license or a
import static org.mockito.Mockito.when;
    // ---- Test: filter with "disk_spill" includes SpillStats ----
 * Validates: Requirements 5.1, 5.2, 5.3
        // query_execution task monitor should be present
    }
        // task monitors should be empty
        filter.add("fragment_executor_gate");
    }
        // cpu_runtime should be null
        mockClusterService = mock(ClusterService.class);
        DataFusionStatsNodeResponse response = action.nodeOperation(nodeRequest);
 *
    }
        Set<String> filter = new HashSet<>();
        ActionFilters mockActionFilters = mock(ActionFilters.class);
        DataFusionStats result = TransportDataFusionStatsAction.filteredStats(stats, filter);
        assertEquals(stats.getNativeExecutorsStats().getTaskMonitors().get("query_execution"), monitors.get("query_execution"));
    // ---- Helper: build DataFusionStats with only a populated SpillStats section ----
    // ---- Test 4: filteredStats with empty filter returns original stats ----
        assertNull(filtered.getSpillStats());
        assertNotNull(result.getNativeExecutorsStats());
    }
import java.util.Collections;
    }
        assertNotNull(response);
import org.opensearch.be.datafusion.stats.TaskMonitorStats;
        when(mockDataFusionService.getStats()).thenThrow(new IllegalStateException("DataFusionService has not been started"));
    }
        assertEquals(stats.getNativeExecutorsStats().getCpuRuntime(), result.getNativeExecutorsStats().getCpuRuntime());
        // cpu_runtime should be present
import org.opensearch.cluster.ClusterName;
import org.opensearch.cluster.service.ClusterService;
            mockDataFusionService
        assertTrue(monitors.containsKey("query_execution"));
        Set<String> filter = Set.of("io_runtime");
    private DataFusionService mockDataFusionService;
    // ---- Test 6: filteredStats with multiple sections ----
public class TransportDataFusionStatsActionTests extends OpenSearchTestCase {
        assertEquals(stats.getFragmentExecutorGateStats(), result.getFragmentExecutorGateStats());
        DataFusionStats filtered = TransportDataFusionStatsAction.filteredStats(statsWithSpill(), Set.of("disk_spill"));
        when(mockClusterService.localNode()).thenReturn(localNode);
        // io_runtime should be null (not in filter)
    }
 * SPDX-License-Identifier: Apache-2.0
    // ---- Test 7: filteredStats with null stats input returns null ----
            mockThreadPool,
import org.opensearch.be.datafusion.stats.SpillStats;
        return new DataFusionStats(null, null, null, new SpillStats("/mnt/spill", 100L, 60L, 40L, 80L, 0L));
        assertNotNull(result.getNativeExecutorsStats().getCpuRuntime());
        assertSame(stats, result);
        super.setUp();
import org.opensearch.be.datafusion.DataFusionService;
        assertNotNull(response);
        assertNotNull(filtered.getSpillStats());
        assertEquals(localNode, response.getNode());
 *
        verify(mockDataFusionService).getStats();
        assertEquals(stats, response.getStats());
    // ---- Test 2: nodeOperation returns correct response ----
    public void testFilteredStatsWithEmptyFilter() {
        assertSame(stats, result);
        DataFusionStats result = TransportDataFusionStatsAction.filteredStats(stats, Collections.emptySet());
        DataFusionStats result = TransportDataFusionStatsAction.filteredStats(stats, null);
