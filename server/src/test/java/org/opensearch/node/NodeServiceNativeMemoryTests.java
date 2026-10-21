 * Unit tests for NodeService native memory stats delegation logic.
            false, // discoveryStats
            null // concurrencyLimiterStatsSupplier
import org.opensearch.action.search.SearchTransportService;
            mock(IndicesService.class),
            false  // concurrencyLimiter
            false, // weightedRoutingStats
 *
        );
            false, // scriptCache
            mock(ThreadPool.class),
    public void testStatsWithNativeMemoryTrueAndSupplierPresent() {
            null, // aggregationUsageService
import org.opensearch.tasks.TaskCancellationMonitoringService;
            false, // fs
            false, // searchPipelineStats
            false, // clusterManagerThrottling
import org.opensearch.cluster.node.DiscoveryNode;
            CommonStatsFlags.NONE,
}
import static org.mockito.Mockito.mock;
            false, // admissionControl
import org.opensearch.discovery.Discovery;
        );
            new SettingsFilter(Collections.emptyList()),
        TransportService transportService = mock(TransportService.class);
            false, // searchBackpressure
            false, // fileCacheStats
            false, // remoteStoreNodeStats
            nativeAllocatorStatsSupplier,
            false, // script
            null, // cacheService
            mock(SearchTransportService.class),
            false, // cacheService
import java.util.List;
            mock(TaskCancellationMonitoringService.class),
import org.opensearch.action.admin.cluster.node.stats.NodeStats;
 */
            false, // ingest
        );
/**
import org.opensearch.transport.TransportService;
import org.opensearch.Version;
            false, // weightedRoutingStats
            false, // taskCancellation
            true,  // nativeMemory
package org.opensearch.node;
    /**
            false, // cacheService
import org.opensearch.index.SegmentReplicationStatsTracker;
 * this file be licensed under the Apache-2.0 license or a
            false, // searchPipelineStats
     * returns null for the nativeAllocatorStats field.
/*
            mock(IndexingPressureService.class),
import java.util.function.Supplier;
            false, // remoteStoreNodeStats
            List.of(new NativeAllocatorPoolStats.PoolStats("flight", 100L, 200L, 2048L))
            false, // remoteStoreNodeStats
            false, // indexingPressure
            false, // ingest
            false, // searchBackpressure
            CommonStatsFlags.NONE,
            null, // resourceUsageCollectorService
            null, // responseCollectorService - not needed when adaptiveSelection=false
     * nativeAllocatorStats field regardless of whether the supplier is present.
        NodeService nodeService = createNodeService(() -> expected);
    private NodeService createNodeService(Supplier<NativeAllocatorPoolStats> nativeAllocatorStatsSupplier) {
import org.opensearch.ratelimitting.admissioncontrol.AdmissionControlService;
import org.opensearch.repositories.RepositoriesService;
            false, // circuitBreaker
            false, // scriptCache
import org.opensearch.indices.IndicesService;
 * SPDX-License-Identifier: Apache-2.0
            false, // discoveryStats
            false, // fileCacheDetailed
import org.opensearch.monitor.MonitorService;
        assertNull("nativeAllocatorStats should be null when no supplier registered", nodeStats.getNativeAllocatorStats());
        NodeStats nodeStats = nodeService.stats(
            false, // http
            mock(MonitorService.class),
            false, // adaptiveSelection
 * compatible open source license.
            false, // jvm
            false, // repositoriesStats
public class NodeServiceNativeMemoryTests extends OpenSearchTestCase {
            null, // httpServerTransport
import org.opensearch.action.admin.indices.stats.CommonStatsFlags;
            mock(IngestService.class),
            false, // process
            mock(ClusterService.class),
        NativeAllocatorPoolStats expected = new NativeAllocatorPoolStats(
            false, // resourceUsageStats
            false, // shardIndexingPressure
        assertNull("nativeAllocatorStats should be null when nativeMemory=false", nodeStats.getNativeAllocatorStats());
            false, // process
            false, // discoveryStats
        when(transportService.getLocalNode()).thenReturn(localNode);
     */
            false, // circuitBreaker
            false, // segmentReplicationTrackerStats
    public void testStatsWithNativeMemoryTrueAndNoSupplier() {
     * returns the stats from the supplier.
            false, // transport
    /**
            false, // jvm
        NodeStats nodeStats = nodeService.stats(
import org.opensearch.index.IndexingPressureService;
            false, // taskCancellation
            false, // adaptiveSelection
import org.opensearch.common.settings.Settings;
import org.opensearch.core.indices.breaker.CircuitBreakerService;
            false  // concurrencyLimiter
            false, // fileCacheStats
 * Validates that NodeService correctly delegates to the native allocator stats
            false  // concurrencyLimiter
            false, // fileCacheDetailed
 * and returns null otherwise.
import static org.mockito.Mockito.when;
            false, // threadPool
 * <p>
import org.opensearch.search.pipeline.SearchPipelineService;
        );
import org.opensearch.cluster.service.ClusterService;
            mock(PluginsService.class),
        );
            false, // admissionControl
            false, // ingest
            List.of(new NativeAllocatorPoolStats.PoolStats("flight", 100L, 200L, 2048L))
            false, // circuitBreaker
            false, // searchPipelineStats
            false, // admissionControl
            mock(SearchBackpressureService.class),
            false, // segmentReplicationTrackerStats
            false, // os
     */
            false, // adaptiveSelection
import org.opensearch.ingest.IngestService;
            false, // indexingPressure
            false, // resourceUsageStats
            false, // scriptCache
    }
     * Tests that stats() with nativeMemory=true and no supplier
import java.util.Collections;
     * Tests that stats() with nativeMemory=true and a non-null supplier
            mock(SegmentReplicationStatsTracker.class),
            false, // fileCacheStats
            false, // script
    public void testStatsWithNativeMemoryFalse() {
            false, // resourceUsageStats
    /**
            false, // cacheService
 */
            false, // shardIndexingPressure
import org.opensearch.plugins.PluginsService;
        assertNotNull("nativeAllocatorStats should be present when supplier returns non-null", nodeStats.getNativeAllocatorStats());
            false, // nativeMemory
            false, // segmentReplicationTrackerStats
            Settings.EMPTY,
            false, // threadPool
        NodeService nodeService = createNodeService(() -> expected);
            true,  // nativeMemory
            mock(Discovery.class),
            2048L,
            4096L,
import org.opensearch.threadpool.ThreadPool;
            false, // threadPool
     */
            false, // os
            false, // script
            false, // clusterManagerThrottling
            null, // nodeCacheService
            mock(SearchPipelineService.class),
    }
            false, // fs
     * Tests that stats() with nativeMemory=false returns null for the
            false, // repositoriesStats
        );
            transportService,
            false, // http
            false, // weightedRoutingStats
 * supplier when nativeMemory=true and the supplier is non-null,
import org.opensearch.search.backpressure.SearchBackpressureService;
            8192L,
            false, // http
            false, // searchBackpressure
import org.opensearch.script.ScriptService;
    }
            1024L,
            false, // shardIndexingPressure
            false, // indexingPressure
            CommonStatsFlags.NONE,
    }
        return new NodeService(
        NodeStats nodeStats = nodeService.stats(
            false, // clusterManagerThrottling
            false, // fileCacheDetailed
import org.opensearch.plugin.stats.NativeAllocatorPoolStats;
        assertSame(expected, nodeStats.getNativeAllocatorStats());
 * The OpenSearch Contributors require contributions made to
            mock(RepositoriesService.class),
            false, // repositoriesStats
            false, // jvm
            false, // transport
        NodeService nodeService = createNodeService(null);
import org.opensearch.common.settings.SettingsFilter;
            mock(AdmissionControlService.class),
            false, // taskCancellation
            false, // process
            false, // os
            false, // transport
            false, // fs
            mock(CircuitBreakerService.class),
        DiscoveryNode localNode = new DiscoveryNode("test_node", buildNewFakeTransportAddress(), Version.CURRENT);
        NativeAllocatorPoolStats expected = new NativeAllocatorPoolStats(
            mock(ScriptService.class),
import org.opensearch.test.OpenSearchTestCase;
