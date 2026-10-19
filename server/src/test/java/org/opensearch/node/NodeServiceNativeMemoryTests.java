            false, // segmentReplicationTrackerStats
/*  
 * this file be licensed under the Apache-2.0 license or a
            false, // resourceUsageStats  
        );  
            false, // admissionControl  
            false, // scriptCache  
import org.opensearch.index.IndexingPressureService;
        );
            false, // clusterManagerThrottling
            false, // script
            false, // http  
import java.util.function.Supplier;  
            false, // clusterManagerThrottling  
import static org.mockito.Mockito.mock;
        NodeStats nodeStats = nodeService.stats(  
            false, // process  
            false, // searchBackpressure
            false, // taskCancellation
            false  // concurrencyLimiter
     */  
            false, // searchPipelineStats
            false, // repositoriesStats
            mock(SegmentReplicationStatsTracker.class),  
     * Tests that stats() with nativeMemory=false returns null for the
            null, // responseCollectorService - not needed when adaptiveSelection=false  
    /**
import org.opensearch.threadpool.ThreadPool;
            false, // process  
        NodeService nodeService = createNodeService(() -> expected);
            false, // shardIndexingPressure
            List.of(new NativeAllocatorPoolStats.PoolStats("flight", 100L, 200L, 2048L))  
            null, // cacheService  
            false, // discoveryStats
import org.opensearch.monitor.MonitorService;  
import org.opensearch.transport.TransportService;
/**
            false, // indexingPressure
     * returns the stats from the supplier.
            false, // ingest  
        NodeStats nodeStats = nodeService.stats(  
            false, // transport
            false  // concurrencyLimiter
 * and returns null otherwise.
import org.opensearch.search.pipeline.SearchPipelineService;
            false, // remoteStoreNodeStats
            null, // resourceUsageCollectorService
 * Unit tests for NodeService native memory stats delegation logic.  
            false, // segmentReplicationTrackerStats
import java.util.Collections;
import org.opensearch.common.settings.Settings;
            false, // ingest
            false, // searchBackpressure  
    }
            false, // cacheService
import org.opensearch.script.ScriptService;
 */
            null, // nodeCacheService  
            mock(RepositoriesService.class),
        assertNotNull("nativeAllocatorStats should be present when supplier returns non-null", nodeStats.getNativeAllocatorStats());
            false, // remoteStoreNodeStats  
import org.opensearch.core.indices.breaker.CircuitBreakerService;  
    }
import org.opensearch.action.search.SearchTransportService;
            false, // nativeMemory
            mock(SearchTransportService.class),
import org.opensearch.action.admin.indices.stats.CommonStatsFlags;  
import org.opensearch.search.backpressure.SearchBackpressureService;  
import org.opensearch.indices.IndicesService;
 * Validates that NodeService correctly delegates to the native allocator stats
}
 */  
            false, // indexingPressure  
            new SettingsFilter(Collections.emptyList()),
            2048L,
            1024L,  
        NodeService nodeService = createNodeService(() -> expected);
            false, // process
import org.opensearch.tasks.TaskCancellationMonitoringService;
            false, // admissionControl  
            null, // aggregationUsageService  
            false, // shardIndexingPressure
    }  
import org.opensearch.Version;
            false  // concurrencyLimiter
import org.opensearch.cluster.node.DiscoveryNode;
            false, // threadPool
            false, // resourceUsageStats
        DiscoveryNode localNode = new DiscoveryNode("test_node", buildNewFakeTransportAddress(), Version.CURRENT);
    public void testStatsWithNativeMemoryTrueAndNoSupplier() {  
import org.opensearch.ingest.IngestService;
            false, // jvm
     */
            false, // script
            true,  // nativeMemory  
 * SPDX-License-Identifier: Apache-2.0
            false, // threadPool
    /**  
            false, // jvm
            mock(Discovery.class),
            false, // repositoriesStats
            false, // script
import org.opensearch.cluster.service.ClusterService;  
            Settings.EMPTY,
            false, // resourceUsageStats  
     * Tests that stats() with nativeMemory=true and a non-null supplier
    public void testStatsWithNativeMemoryFalse() {
        NodeStats nodeStats = nodeService.stats(
     * nativeAllocatorStats field regardless of whether the supplier is present.  
    /**
import org.opensearch.ratelimitting.admissioncontrol.AdmissionControlService;  
            false, // repositoriesStats  
            false, // transport
            false, // fileCacheStats  
            List.of(new NativeAllocatorPoolStats.PoolStats("flight", 100L, 200L, 2048L))
            false, // discoveryStats
        );  
 * compatible open source license.
            false, // taskCancellation
            false, // jvm
            4096L,
            false, // shardIndexingPressure
            false, // http
            false, // circuitBreaker
            false, // fs  
            false, // adaptiveSelection
        );
            false, // fileCacheDetailed  
            false, // remoteStoreNodeStats
import java.util.List;
            mock(SearchBackpressureService.class),
        );  
            false, // indexingPressure  
            mock(SearchPipelineService.class),
            true,  // nativeMemory  
            transportService,  
            false, // os
        TransportService transportService = mock(TransportService.class);  
public class NodeServiceNativeMemoryTests extends OpenSearchTestCase {  
import org.opensearch.repositories.RepositoriesService;
        assertNull("nativeAllocatorStats should be null when nativeMemory=false", nodeStats.getNativeAllocatorStats());
            false, // scriptCache
        assertSame(expected, nodeStats.getNativeAllocatorStats());
            null, // httpServerTransport
package org.opensearch.node;
            false, // scriptCache
            false, // segmentReplicationTrackerStats
            false, // threadPool  
            false, // http
            false, // adaptiveSelection
            false, // fileCacheStats
            false, // discoveryStats  
import org.opensearch.action.admin.cluster.node.stats.NodeStats;
     */
    private NodeService createNodeService(Supplier<NativeAllocatorPoolStats> nativeAllocatorStatsSupplier) {
            false, // searchPipelineStats
     * returns null for the nativeAllocatorStats field.
        NativeAllocatorPoolStats expected = new NativeAllocatorPoolStats(
            CommonStatsFlags.NONE,
            false, // weightedRoutingStats
 * <p>
            false, // fs  
    }  
            false, // taskCancellation
        return new NodeService(
            mock(IndicesService.class),
            null // concurrencyLimiterStatsSupplier
import org.opensearch.plugin.stats.NativeAllocatorPoolStats;
            mock(ClusterService.class),
        assertNull("nativeAllocatorStats should be null when no supplier registered", nodeStats.getNativeAllocatorStats());
            false, // os
            false, // circuitBreaker  
            false, // cacheService
            nativeAllocatorStatsSupplier,
            false, // admissionControl
        NativeAllocatorPoolStats expected = new NativeAllocatorPoolStats(  
            false, // fileCacheStats
            false, // ingest  
 * The OpenSearch Contributors require contributions made to  
        NodeService nodeService = createNodeService(null);
            mock(ScriptService.class),
 * supplier when nativeMemory=true and the supplier is non-null,  
            mock(PluginsService.class),
            8192L,
            false, // cacheService
            CommonStatsFlags.NONE,
            false, // os  
            false, // searchBackpressure
            false, // circuitBreaker  
            false, // fileCacheDetailed  
            false, // searchPipelineStats  
            false, // clusterManagerThrottling  
            false, // transport
            false, // weightedRoutingStats
            CommonStatsFlags.NONE,
            false, // fileCacheDetailed
     * Tests that stats() with nativeMemory=true and no supplier  
            false, // weightedRoutingStats
import org.opensearch.discovery.Discovery;
            mock(IngestService.class),  
import org.opensearch.common.settings.SettingsFilter;
import static org.mockito.Mockito.when;  
            mock(ThreadPool.class),  
import org.opensearch.test.OpenSearchTestCase;  
import org.opensearch.plugins.PluginsService;
            mock(CircuitBreakerService.class),  
        when(transportService.getLocalNode()).thenReturn(localNode);
    public void testStatsWithNativeMemoryTrueAndSupplierPresent() {
 *
            false, // fs
            false, // adaptiveSelection
        );
            mock(AdmissionControlService.class),
            mock(MonitorService.class),
import org.opensearch.index.SegmentReplicationStatsTracker;  
            mock(IndexingPressureService.class),
            mock(TaskCancellationMonitoringService.class),
