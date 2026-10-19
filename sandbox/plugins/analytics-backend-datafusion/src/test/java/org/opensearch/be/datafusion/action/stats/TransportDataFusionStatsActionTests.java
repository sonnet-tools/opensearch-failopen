        assertNull(filtered.getSpillStats());
        filter.add("fragment_executor_gate");
        assertNotNull(result);  
import static org.mockito.Mockito.verify;  
import org.opensearch.test.OpenSearchTestCase;
    public void testFilteredStatsWithEmptyFilter() {
        );
        assertEquals(stats.getFragmentExecutorGateStats(), result.getFragmentExecutorGateStats());
        assertEquals(stats, response.getStats());
 * and the transport infrastructure.
        assertSame(stats, result);  
        super.setUp();  
 * Validates: Requirements 5.1, 5.2, 5.3
    private ClusterService mockClusterService;  
        DataFusionStatsNodesRequest nodesRequest = new DataFusionStatsNodesRequest(new String[0], Collections.emptySet());
        assertEquals(stats.getNativeExecutorsStats().getCpuRuntime(), result.getNativeExecutorsStats().getCpuRuntime());
import java.util.Map;
        PartitionGateStats fragmentExecutorGate = new PartitionGateStats("fragment_executor_gate", 64, 3, 150, 500, 0, 64, 0, 0);
    }
        assertTrue(result.getNativeExecutorsStats().getTaskMonitors().isEmpty());
            mockClusterService,
        action.nodeOperation(nodeRequest);
        when(mockDataFusionService.getStats()).thenThrow(new IllegalStateException("DataFusionService has not been started"));
    }
        when(mockDataFusionService.getStats()).thenReturn(stats);
        action = new TransportDataFusionStatsAction(
        assertNull(result);
        assertEquals(localNode, response.getNode());  
        Map<String, TaskMonitorStats> taskMonitors = new LinkedHashMap<>();
        DataFusionStatsNodeResponse response = action.nodeOperation(nodeRequest);  
        when(mockClusterService.getClusterName()).thenReturn(new ClusterName("test-cluster"));  
    private DiscoveryNode localNode;
        TransportService mockTransportService = mock(TransportService.class);
        // io_runtime should be null (not in filter)
    public void testNodeOperationHandlesServiceNotStarted() {  
 * The OpenSearch Contributors require contributions made to  
/*  
import static org.mockito.Mockito.when;
        DataFusionStats result = TransportDataFusionStatsAction.filteredStats(stats, filter);
        assertNull(response.getStats());
        assertNotNull(result.getNativeExecutorsStats());
import org.opensearch.be.datafusion.stats.DataFusionStats;
import java.util.Collections;
        DataFusionStatsNodeRequest nodeRequest = new DataFusionStatsNodeRequest(nodesRequest);
    // ---- Test 6: filteredStats with multiple sections ----
    // ---- Test: filter with "disk_spill" includes SpillStats ----
    // ---- Test 3: filteredStats with null filter returns original stats ----
        assertNotNull(filtered.getSpillStats());
        // fragment_executor_gate should be present  
    }
        DataFusionStatsNodesRequest nodesRequest = new DataFusionStatsNodesRequest(new String[0], Collections.emptySet());  
        return new DataFusionStats(null, null, null, new SpillStats("/mnt/spill", 100L, 60L, 40L, 80L, 0L));
    }  
        DataFusionStats filtered = TransportDataFusionStatsAction.filteredStats(statsWithSpill(), Set.of("disk_spill"));
    // ---- Helper: build a full DataFusionStats with all sections populated ----
        assertNotNull(result);  
    }  
        DataFusionStats stats = buildFullStats();
        DataFusionStatsNodeRequest nodeRequest = new DataFusionStatsNodeRequest(nodesRequest);  
 *
    }
        // query_execution task monitor should be present
import java.util.HashSet;  
        verify(mockDataFusionService).getStats();
import java.util.Set;  
import org.opensearch.threadpool.ThreadPool;
            mockTransportService,
    // ---- Test: filter without "disk_spill" excludes SpillStats ----  
    }  
import org.opensearch.be.datafusion.stats.PartitionGateStats;  
        taskMonitors.put("plan_setup", new TaskMonitorStats(1000, 1100, 1200, 0, 0));
import org.opensearch.transport.TransportService;  
import java.util.LinkedHashMap;
        DataFusionStats filtered = TransportDataFusionStatsAction.filteredStats(statsWithSpill(), Set.of());
        when(mockClusterService.localNode()).thenReturn(localNode);
import org.opensearch.cluster.node.DiscoveryNode;
        DataFusionStatsNodesRequest nodesRequest = new DataFusionStatsNodesRequest(new String[0], Collections.emptySet());
        Set<String> filter = new HashSet<>();
        DataFusionStats result = TransportDataFusionStatsAction.filteredStats(stats, Collections.emptySet());
        taskMonitors.put("stream_next", new TaskMonitorStats(700, 800, 900, 0, 0));
            mockDataFusionService
        filter.add("cpu_runtime");  
 * Unit tests for {@link TransportDataFusionStatsAction}.
        taskMonitors.put("query_execution", new TaskMonitorStats(400, 500, 600, 0, 0));  
 * compatible open source license.
        assertSame(stats, result);
        assertEquals("/mnt/spill", filtered.getSpillStats().getDirectory());  
        DataFusionStatsNodeResponse response = action.nodeOperation(nodeRequest);
        // io_runtime should be present
    }
import static org.mockito.Mockito.mock;
 *  
        Map<String, TaskMonitorStats> monitors = result.getNativeExecutorsStats().getTaskMonitors();
        assertTrue(monitors.containsKey("query_execution"));
public class TransportDataFusionStatsActionTests extends OpenSearchTestCase {  
        NativeExecutorsStats nativeStats = new NativeExecutorsStats(io, cpu, taskMonitors);  
    public void testFilterExcludesSpillWhenNotRequested() {
    }
        RuntimeMetrics io = new RuntimeMetrics(4, 1000, 500, 10, 5, 2, 20, 100, 8);
}
    // ---- Test 5: filteredStats with single section (io_runtime) ----
    }
        assertNotNull(result.getNativeExecutorsStats());
    }  
        mockClusterService = mock(ClusterService.class);
        assertEquals(1, monitors.size());  
        Set<String> filter = Set.of("io_runtime");
    // ---- Test 7: filteredStats with null stats input returns null ----
        return new DataFusionStats(nativeStats, fragmentExecutorGate, null, null);
import org.opensearch.Version;
    private DataFusionService mockDataFusionService;
        assertNotNull(response);
import org.opensearch.cluster.service.ClusterService;  
        DataFusionStats stats = buildFullStats();  
        DataFusionStats stats = buildFullStats();
    public void testFilterIncludesSpillWhenRequested() {  
        when(mockDataFusionService.getStats()).thenReturn(stats);  
        assertNotNull(filtered.getSpillStats());
        assertNull(result.getNativeExecutorsStats().getIoRuntime());  
    // ---- Test 2: nodeOperation returns correct response ----
 */  
        // cpu_runtime should be null
    // ---- Test 1: nodeOperation calls dataFusionService.getStats() ----
        DataFusionStats stats = buildFullStats();
        ActionFilters mockActionFilters = mock(ActionFilters.class);
    }
 *
    public void testFilteredStatsWithNullStats() {
        DataFusionStats result = TransportDataFusionStatsAction.filteredStats(null, Set.of("io_runtime"));
        assertNotNull(response);  
        // cpu_runtime should be present
        // task monitors should be empty
        taskMonitors.put("coordinator_reduce", new TaskMonitorStats(100, 200, 300, 0, 0));
    private TransportDataFusionStatsAction action;
        assertNotNull(result.getFragmentExecutorGateStats());
        DataFusionStats filtered = TransportDataFusionStatsAction.filteredStats(statsWithSpill(), Set.of("io_runtime"));  
    }
    public void testNodeOperationCallsGetStats() {
        assertNotNull(result.getNativeExecutorsStats().getIoRuntime());  
        assertEquals(stats.getNativeExecutorsStats().getIoRuntime(), result.getNativeExecutorsStats().getIoRuntime());
        DataFusionStats stats = buildFullStats();
import org.opensearch.be.datafusion.stats.TaskMonitorStats;  
import org.opensearch.action.support.ActionFilters;
        DataFusionStatsNodeRequest nodeRequest = new DataFusionStatsNodeRequest(nodesRequest);
            mockActionFilters,  
    public void testFilteredStatsWithSingleSection() {  
 * this file be licensed under the Apache-2.0 license or a
 * <p>Tests the {@code nodeOperation()} method and the package-private  
    // ---- Test 8: nodeOperation handles service not started (IllegalStateException) ----
    // ---- Test: empty filter returns all sections including spill ----
    // ---- Helper: build DataFusionStats with only a populated SpillStats section ----
/**  
        assertEquals(stats.getNativeExecutorsStats().getTaskMonitors().get("query_execution"), monitors.get("query_execution"));
    private static DataFusionStats buildFullStats() {
    public void setUp() throws Exception {
 */
 * SPDX-License-Identifier: Apache-2.0
    public void testFilteredStatsWithNullFilter() {
            mockThreadPool,  
        assertEquals(localNode, response.getNode());
        assertNotNull(result.getNativeExecutorsStats().getCpuRuntime());  
import org.opensearch.be.datafusion.stats.RuntimeMetrics;
    // ---- Test 4: filteredStats with empty filter returns original stats ----  
import org.opensearch.be.datafusion.stats.SpillStats;
package org.opensearch.be.datafusion.action.stats;
        filter.add("query_execution");
        localNode = new DiscoveryNode("test-node", buildNewFakeTransportAddress(), Version.CURRENT);
import org.opensearch.be.datafusion.stats.NativeExecutorsStats;
        DataFusionStats stats = buildFullStats();
        assertNull(result.getFragmentExecutorGateStats());
import org.opensearch.cluster.ClusterName;
        // gate stats should be null  
    private static DataFusionStats statsWithSpill() {  
    public void testNodeOperationReturnsCorrectResponse() {  
        assertNull(result.getNativeExecutorsStats().getCpuRuntime());  
    public void testFilteredStatsWithMultipleSections() {  
import org.opensearch.be.datafusion.DataFusionService;  
        mockDataFusionService = mock(DataFusionService.class);
        ThreadPool mockThreadPool = mock(ThreadPool.class);  
        DataFusionStats result = TransportDataFusionStatsAction.filteredStats(stats, null);
    @Override
 * {@code filteredStats()} helper. Uses Mockito to mock {@link DataFusionService}
    }  
    public void testEmptyFilterReturnsAllSectionsIncludingSpill() {  
        RuntimeMetrics cpu = new RuntimeMetrics(8, 2000, 1000, 20, 10, 4, 40, 200, 16);  
        DataFusionStats result = TransportDataFusionStatsAction.filteredStats(stats, filter);
