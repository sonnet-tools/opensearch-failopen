import static org.hamcrest.Matchers.greaterThan;
/*  
            ArrowBasePlugin.class,
        return Arrays.asList(
        assertThat("native_memory stats should be present", stats, notNullValue());  
            DataFusionPlugin.class  
/**
        );
        NativeAllocatorPoolStats stats = response.getNodes().get(0).getNativeAllocatorStats();
    public void testAllSixPoolsVisibleInStats() {  
import org.opensearch.action.admin.cluster.node.stats.NodesStatsResponse;
    @Override
public class UnifiedNativeMemoryFullStackIT extends OpenSearchIntegTestCase {  
            assertThat("Pool '" + pool.getName() + "' limit should be > 0", pool.getLimitBytes(), greaterThan(0L));
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, minNumDataNodes = 1, maxNumDataNodes = 1)
    protected Settings nodeSettings(int nodeOrdinal) {
        return Settings.builder().put(super.nodeSettings(nodeOrdinal)).put("node.native_memory.limit", "2gb").build();  
            LucenePlugin.class,
        assertThat("native allocated_bytes should be > 0", stats.getNativeAllocatedBytes(), greaterThan(0L));
        NodesStatsResponse response = client().admin()
        // All 6 pools should be present
 * SPDX-License-Identifier: Apache-2.0
 * compatible open source license.
            CompositeDataFormatPlugin.class,
import static org.hamcrest.Matchers.notNullValue;
        Set<String> poolNames = stats.getPools().stream().map(NativeAllocatorPoolStats.PoolStats::getName).collect(Collectors.toSet());  
            .get();
    protected Collection<Class<? extends Plugin>> nodePlugins() {  
        }
        // Each pool should have limit > 0  
            .cluster()
import java.util.stream.Collectors;
package org.opensearch.composite;
        assertThat(poolNames, hasItems("flight", "ingest", "query", "datafusion", "write", "merge"));
@ThreadLeakScope(ThreadLeakScope.Scope.NONE)
 *
import org.opensearch.action.admin.cluster.node.stats.NodesStatsRequest;  
            assertThat("Pool '" + pool.getName() + "' allocated should be >= 0", pool.getAllocatedBytes(), greaterThanOrEqualTo(0L));  
    }
import org.opensearch.parquet.ParquetDataFormatPlugin;  
import org.opensearch.common.settings.Settings;
        assertThat("native resident_bytes should be > 0", stats.getNativeResidentBytes(), greaterThan(0L));
import static org.hamcrest.Matchers.hasItems;  
 */  
}
    }  
import java.util.Arrays;
 * Full-stack IT verifying all 6 pools appear in _nodes/stats/native_memory.
        for (NativeAllocatorPoolStats.PoolStats pool : stats.getPools()) {
            ParquetDataFormatPlugin.class,  
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.is;
import org.opensearch.test.OpenSearchIntegTestCase;  
        assertThat(response.getNodes().isEmpty(), is(false));
 */  
            .prepareNodesStats()  
            .addMetric(NodesStatsRequest.Metric.NATIVE_MEMORY.metricName())
import java.util.Collection;  
import org.opensearch.plugin.stats.NativeAllocatorPoolStats;
import com.carrotsearch.randomizedtesting.annotations.ThreadLeakScope;
import org.opensearch.plugins.Plugin;
import org.opensearch.be.datafusion.DataFusionPlugin;  
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.be.lucene.LucenePlugin;
import org.opensearch.arrow.allocator.ArrowBasePlugin;
        // Native memory stats (jemalloc) should be available since DataFusion plugin sets the supplier  
    @Override
    }
 * this file be licensed under the Apache-2.0 license or a
import java.util.Set;
