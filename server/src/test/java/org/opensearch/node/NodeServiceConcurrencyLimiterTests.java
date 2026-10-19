            CommonStatsFlags.NONE,
            concurrencyLimiter
                )  
                    "search",  
        );
            mock(SearchBackpressureService.class),  
            mock(ClusterService.class),  
    public void testStatsWithConcurrencyLimiterTrueAndSupplierPresent() {
        when(transportService.getLocalNode()).thenReturn(localNode);
            false, // jvm
        assertSame(expected, nodeStats.getConcurrencyLimiterStats());
        return nodeService.stats(  
            false, // searchBackpressure
                    "vegas",  
            )
            mock(IndexingPressureService.class),
        );
import org.opensearch.tasks.TaskCancellationMonitoringService;
    public void testStatsWithConcurrencyLimiterFalse() {
import org.opensearch.ingest.IngestService;  
            false, // remoteStoreNodeStats
}
            false, // fs  
            null,
                    20,
            false, // cacheService
import org.opensearch.common.settings.SettingsFilter;  
 * compatible open source license.
            null,
import org.opensearch.discovery.Discovery;
 */  
            mock(MonitorService.class),  
            List.of(
            false, // resourceUsageStats  
import org.opensearch.script.ScriptService;
import org.opensearch.common.settings.Settings;
import static org.mockito.Mockito.mock;
            transportService,
        NodeStats nodeStats = callStats(nodeService, true);  
            mock(ThreadPool.class),
 *
import org.opensearch.test.OpenSearchTestCase;  
            false, // http
import java.util.function.Supplier;  
        NodeStats nodeStats = callStats(nodeService, false);
    }  
import org.opensearch.cluster.node.DiscoveryNode;  
    }  
                    -1L,
                    "indices:data/read/search",
import java.util.Collections;
 */
    public void testStatsWithConcurrencyLimiterTrueAndNoSupplier() {
            mock(SearchPipelineService.class),
            false, // scriptCache
            false, // circuitBreaker  
        assertNull("concurrencyLimiterStats should be null when flag=false", nodeStats.getConcurrencyLimiterStats());  
import org.opensearch.monitor.MonitorService;
        NodeService nodeService = createNodeService(null);
            false, // searchPipelineStats
                    5,
import org.opensearch.action.search.SearchTransportService;
    }
import org.opensearch.transport.TransportService;
                    "vegas",  
import org.opensearch.repositories.RepositoriesService;
        assertNotNull(nodeStats.getConcurrencyLimiterStats());  
                    "search",  
    }
            new SettingsFilter(Collections.emptyList()),
        TransportService transportService = mock(TransportService.class);
            false, // weightedRoutingStats
        );
import org.opensearch.search.backpressure.SearchBackpressureService;  
        ActionConcurrencyLimiterStats expected = new ActionConcurrencyLimiterStats(  
 * The OpenSearch Contributors require contributions made to  
            false, // os
        return new NodeService(  
                    0L,  
import org.opensearch.search.pipeline.SearchPipelineService;
            false, // segmentReplicationTrackerStats
 * this file be licensed under the Apache-2.0 license or a
            null,
                    "enforced",
            false, // script
            null,
            false, // adaptiveSelection
import org.opensearch.action.admin.indices.stats.CommonStatsFlags;
            null,
        NodeService nodeService = createNodeService(() -> expected);  
    private NodeService createNodeService(Supplier<ActionConcurrencyLimiterStats> concurrencyLimiterStatsSupplier) {
                    20,
import org.opensearch.Version;
            null,  
            mock(IngestService.class),
            concurrencyLimiterStatsSupplier
            false, // admissionControl  
                    5,
            )
 * Unit tests for NodeService concurrency limiter stats delegation logic.  
            mock(CircuitBreakerService.class),
            false, // clusterManagerThrottling  
            mock(SegmentReplicationStatsTracker.class),
import org.opensearch.action.admin.cluster.node.stats.NodeStats;  
            mock(TaskCancellationMonitoringService.class),  
            mock(SearchTransportService.class),  
                    "indices:data/read/search",
            null,
                    10L,
import org.opensearch.ratelimitting.admissioncontrol.AdmissionControlService;  
            false, // repositoriesStats
            mock(RepositoriesService.class),  
import org.opensearch.threadpool.ThreadPool;
            false, // nativeMemory  
                    8L
    private NodeStats callStats(NodeService nodeService, boolean concurrencyLimiter) {
import org.opensearch.index.SegmentReplicationStatsTracker;
import org.opensearch.cluster.service.ClusterService;
public class NodeServiceConcurrencyLimiterTests extends OpenSearchTestCase {
            false, // fileCacheStats
            Settings.EMPTY,
        );
            mock(AdmissionControlService.class),
                    "enforced",
package org.opensearch.node;
            mock(Discovery.class),
            List.of(
/**
import org.opensearch.action.ActionConcurrencyLimiterStats;
            false, // ingest  
    }  
            false, // shardIndexingPressure
                    -1L
            false, // process  
import org.opensearch.indices.IndicesService;
                new ActionConcurrencyLimiterStats.ActionLimiterSnapshot(
        assertNull(nodeStats.getConcurrencyLimiterStats());
import static org.mockito.Mockito.when;  
import org.opensearch.plugins.PluginsService;
            mock(ScriptService.class),  
        NodeStats nodeStats = callStats(nodeService, true);
/*  
            false, // taskCancellation
            mock(PluginsService.class),
import org.opensearch.index.IndexingPressureService;  
import java.util.List;
                new ActionConcurrencyLimiterStats.ActionLimiterSnapshot(
            false, // indexingPressure  
 * SPDX-License-Identifier: Apache-2.0
        ActionConcurrencyLimiterStats stats = new ActionConcurrencyLimiterStats(  
        DiscoveryNode localNode = new DiscoveryNode("test_node", buildNewFakeTransportAddress(), Version.CURRENT);  
        NodeService nodeService = createNodeService(() -> stats);  
                )  
            false, // fileCacheDetailed  
            false, // threadPool
            mock(IndicesService.class),  
            false, // discoveryStats
            false, // transport
import org.opensearch.core.indices.breaker.CircuitBreakerService;
                    0L,  
