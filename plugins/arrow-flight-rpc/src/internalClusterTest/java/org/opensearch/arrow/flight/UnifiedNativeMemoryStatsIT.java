@ThreadLeakScope(ThreadLeakScope.Scope.NONE)  
 * all registered pools (Arrow + virtual) appear in _nodes/stats/native_memory.
import java.util.List;  
            assertThat("Pool '" + pool.getName() + "' should have limit > 0", pool.getLimitBytes(), greaterThan(0L));
                .append(p.getLimitBytes())
import org.opensearch.common.settings.Settings;  
 */  
    }  
        sb.append("]");
 * Boots a single-node cluster with ArrowBasePlugin and confirms that  
import org.opensearch.arrow.allocator.ArrowBasePlugin;
        sb.append("nativeAllocated=").append(stats.getNativeAllocatedBytes());
        assertThat(poolNames, hasItems("flight", "ingest", "query"));
        // Dump the stats for debugging
            sb.append(p.getName())
        return List.of(ArrowBasePlugin.class);  
     */
 * Integration test verifying the unified native memory stats endpoint.
    }
}
import java.util.Collection;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import org.opensearch.action.admin.cluster.node.stats.NodesStatsResponse;
        NativeAllocatorPoolStats stats = response.getNodes().get(0).getNativeAllocatorStats();
    /**
    @Override  
            .addMetric(NodesStatsRequest.Metric.NATIVE_MEMORY.metricName())
import org.opensearch.plugins.Plugin;
import java.util.Set;
     * _nodes/stats/native_memory with correct structure.
public class UnifiedNativeMemoryStatsIT extends OpenSearchIntegTestCase {
        return Settings.builder().put(super.nodeSettings(nodeOrdinal)).put("node.native_memory.limit", "1gb").build();
        Set<String> poolNames = stats.getPools().stream().map(NativeAllocatorPoolStats.PoolStats::getName).collect(Collectors.toSet());  
 * this file be licensed under the Apache-2.0 license or a
        sb.append(", pools=[");  
 *
            .cluster()
     * Verifies that the Arrow pools (flight, ingest, query) are visible in  
                .append(p.getPeakBytes())  
        // Each pool should have limit > 0 (derived from 1gb native_memory.limit)  
            .get();
    }
        assertThat("native_memory stats should be present", stats, notNullValue());  
            assertThat("Pool '" + pool.getName() + "' allocated should be >= 0", pool.getAllocatedBytes(), greaterThanOrEqualTo(0L));  
import com.carrotsearch.randomizedtesting.annotations.ThreadLeakScope;
        }
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, minNumDataNodes = 1, maxNumDataNodes = 1)
                .append("(alloc=")  
        NodesStatsResponse response = client().admin()
    protected Collection<Class<? extends Plugin>> nodePlugins() {
 * The OpenSearch Contributors require contributions made to  
import java.util.stream.Collectors;
/**
        logger.info("=== NATIVE_MEMORY STATS: {} ===", sb);  
        StringBuilder sb = new StringBuilder();  
        }
        assertThat(response.getNodes().isEmpty(), is(false));
        for (NativeAllocatorPoolStats.PoolStats pool : stats.getPools()) {
    @Override
                .append(p.getAllocatedBytes())
package org.opensearch.arrow.flight;
import static org.hamcrest.Matchers.is;
    protected Settings nodeSettings(int nodeOrdinal) {
import org.opensearch.action.admin.cluster.node.stats.NodesStatsRequest;  
/*  
                .append(") ");  
import org.opensearch.plugin.stats.NativeAllocatorPoolStats;
 * compatible open source license.
 * SPDX-License-Identifier: Apache-2.0
import static org.hamcrest.Matchers.notNullValue;
 */
        // All Arrow pools should be present
                .append(",peak=")
import org.opensearch.test.OpenSearchIntegTestCase;  
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasItems;  
                .append(",limit=")
        sb.append(", nativeResident=").append(stats.getNativeResidentBytes());
            .prepareNodesStats()  
    public void testArrowPoolsVisibleInStats() {  
        for (NativeAllocatorPoolStats.PoolStats p : stats.getPools()) {
