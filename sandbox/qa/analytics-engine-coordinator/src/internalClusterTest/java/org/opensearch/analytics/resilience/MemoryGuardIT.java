            // The shard fragment wraps the failure as "Stage N failed", so the memory-pressure signal lives  
            IllegalArgumentException.class,
    @Override
import org.opensearch.be.datafusion.DataFusionPlugin;
    public void testMemoryGuardThresholdRejectsOutOfRange() {
            MockCommitterEnginePlugin.class
import org.opensearch.parquet.ParquetOnlyDataFormatPlugin;
import org.opensearch.plugins.PluginInfo;
            .build();
            if (c instanceof OpenSearchException ose && ose.status() == org.opensearch.core.rest.RestStatus.TOO_MANY_REQUESTS) {  
            classpathPlugin(FlightStreamPlugin.class, List.of(ArrowBasePlugin.class.getName())),
        assertEquals("4", response.getTransientSettings().get("datafusion.min_target_partitions"));  
                break;  
            bulk.add(
    protected Collection<PluginInfo> additionalNodePlugins() {  
        return client().execute(UnifiedPPLExecuteAction.INSTANCE, new PPLRequest(query)).actionGet();
import org.opensearch.analytics.AnalyticsPlugin;
            TestPPLPlugin.class,
            assertTrue(
            .put(FeatureFlags.STREAM_TRANSPORT, true)
            .prepareUpdateSettings()
            .startObject("user_id").field("type", "long").endObject()
            if (breakerStats != null) {
            classpathPlugin(ParquetOnlyDataFormatPlugin.class, Collections.emptyList()),
import org.opensearch.ppl.action.PPLRequest;  
        assertTrue(response.isAcknowledged());
                    .setSource("user_id", i, "url", "https://example.com/" + UUID.randomUUID(), "count", i % 100)  
 * Integration tests for the DataFusion memory guard and circuit breaker.
            () -> client().admin()
                .setTransientSettings(Settings.builder().put("datafusion.memory_pool_limit_bytes", 256 * 1024 * 1024L).build())
                .setTransientSettings(Settings.builder().put("datafusion.memory_guard.execution.spill_threshold", 2.0).build())  
            IllegalArgumentException.class,
    }
        CircuitBreakerStats breakerStats = stats.getNodes().get(0).getBreaker().getStats("analytics_backend_datafusion");
                    || msg.contains("Resources exhausted")  
                && (msg.contains("CircuitBreakingException")
    public void testQueryRejectedWhenPoolExhausted() throws Exception {  
    }
                () -> executePPL("source = " + INDEX_NAME + " | stats count() by url")
        );
                    .put("datafusion.memory_guard.admission_throttle_threshold", 0.5)  
                .prepareUpdateSettings()
            .put("index.pluggable.dataformat.enabled", true)
                .cluster()
                .setTransientSettings(Settings.builder().put("datafusion.memory_guard.admission_throttle_threshold", 1.5).build())
            .put("index.composite.primary_data_format", "parquet")  
        return List.of(  
import java.util.List;
import org.opensearch.action.admin.cluster.node.stats.NodeStats;  
    private static final String INDEX_NAME = "mem_guard_test";
        expectThrows(
                client().prepareIndex(INDEX_NAME)
            .cluster()
 * SPDX-License-Identifier: Apache-2.0
                    || msg.contains("insufficient memory budget"))) {
 * this file be licensed under the Apache-2.0 license or a
            .startObject("url").field("type", "keyword").field("index", "false").endObject()
            () -> client().admin()
                .get()
 * - Queries succeed under normal memory limits  
    }
        assertNotNull(response);  
        }
import org.opensearch.ppl.TestPPLPlugin;
import org.opensearch.action.admin.cluster.node.stats.NodesStatsResponse;
                return true;  
        ensureGreen(INDEX_NAME);
            );
            .startObject("properties")  
            () -> client().admin()
        );
        assertNotNull("Breaker stats should not be null", breakerStats);
 *  
import java.util.Collection;
        // Set pool to 1 byte — any GROUP BY should fail  
        expectThrows(
            false
        expectThrows(  
        for (NodeStats nodeStats : stats.getNodes()) {
            .prepareUpdateSettings()
        } finally {
        return false;  
import org.opensearch.ppl.action.PPLResponse;
        assertEquals("0.9", response.getTransientSettings().get("datafusion.memory_guard.admission_reject_threshold"));  
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 1, numClientNodes = 0, supportsDedicatedMasters = false)
import org.opensearch.core.xcontent.XContentBuilder;  
 * - Breaker stats (tripped count, live limit) are correctly reported after dynamic updates
        assertEquals("Breaker limit should reflect dynamic update", newLimit, breakerStats.getLimit());  
 */  
    private PPLResponse executePPL(String query) {
            if (msg != null
    }  
            .putList("index.composite.secondary_data_formats")
            client().admin().indices().prepareCreate(INDEX_NAME).setSettings(indexSettings).setMapping(mapping).get().isAcknowledged()
        XContentBuilder mapping = XContentFactory.jsonBuilder()
                "Memory-pool exhaustion must surface as HTTP 429 somewhere in the failure chain, got: " + ex,
            .get();
 * - Dynamic settings (min_target_partitions, memory_guard thresholds) are accepted and validated  
        }  
            .setTransientSettings(Settings.builder().put("datafusion.memory_pool_limit_bytes", 1L).build())
import org.opensearch.composite.CompositeDataFormatPlugin;
import org.opensearch.arrow.allocator.ArrowBasePlugin;  
        BulkRequestBuilder bulk = client().prepareBulk();
    }
                    .put("datafusion.memory_guard.execution.critical_threshold", 0.95)  
            .prepareUpdateSettings()  
public class MemoryGuardIT extends OpenSearchIntegTestCase {  
    protected Settings nodeSettings(int nodeOrdinal) {  
                .get()  
    }  
        );
                found = true;
        );
                hasMemoryPressureSignal(ex)  
}
        assertTrue("analytics_backend_datafusion breaker should be registered", found);  
        ClusterUpdateSettingsResponse response = client().admin()
    protected Collection<Class<? extends Plugin>> nodePlugins() {
            .get();
import org.opensearch.action.bulk.BulkResponse;
            "1.8",  
    @Override
            )
import org.opensearch.plugins.Plugin;  
            CircuitBreakerStats breakerStats = nodeStats.getBreaker().getStats("analytics_backend_datafusion");  
                .get()
import org.opensearch.ppl.action.UnifiedPPLExecuteAction;
                return true;
import org.opensearch.Version;
        }
    private static PluginInfo classpathPlugin(Class<? extends Plugin> pluginClass, List<String> extendedPlugins) {  
 * - Breaker is registered with correct name (analytics_backend_datafusion)
            }
import org.opensearch.common.xcontent.XContentFactory;  
        expectThrows(
            .cluster()  
            .setTransientSettings(Settings.builder().put("datafusion.min_target_partitions", 4).build())  
            classpathPlugin(DataFusionPlugin.class, List.of(AnalyticsPlugin.class.getName()))
    }  
import org.opensearch.core.indices.breaker.CircuitBreakerStats;
            pluginClass.getName(),
                .cluster()
/*  
            Version.CURRENT,
            .setTransientSettings(
        return new PluginInfo(
    public void testMinTargetPartitionsSettable() {
            .put("index.pluggable.dataformat", "composite")
                    .build()
        );  
        assertEquals("0.85", response.getTransientSettings().get("datafusion.memory_guard.execution.spill_threshold"));
            pluginClass.getName(),
 * The OpenSearch Contributors require contributions made to  
            Exception ex = expectThrows(
                .cluster()  
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)  
            CompositeDataFormatPlugin.class,  
        long newLimit = 42 * 1024 * 1024L;
            }
            IllegalArgumentException.class,
 * Verifies:
            () -> client().admin()  
import org.opensearch.OpenSearchException;
import org.opensearch.action.admin.cluster.settings.ClusterUpdateSettingsResponse;
            IllegalArgumentException.class,
        BulkResponse bulkResponse = bulk.get();  
                    .put("datafusion.memory_guard.execution.spill_threshold", 0.85)
            .prepareUpdateSettings()  
        for (Throwable c = t; c != null && c != c.getCause(); c = c.getCause()) {
    public void testMemoryGuardThresholdsSettable() {  
            .put("datafusion.spill_directory", createTempDir().toString())
 *
        return List.of(
    public void testBreakerRegisteredWithCorrectName() {
import org.opensearch.action.bulk.BulkRequestBuilder;  
            .build();  
        assertEquals("0.95", response.getTransientSettings().get("datafusion.memory_guard.execution.critical_threshold"));
    }  
        boolean found = false;
                    .put("datafusion.memory_guard.admission_reject_threshold", 0.9)
            .cluster()
        assertTrue(response.isAcknowledged());
                .prepareUpdateSettings()
            .cluster()
                .cluster()  
                .get()  
        ClusterUpdateSettingsResponse response = client().admin()
        client().admin()
        assertTrue(
                .get();
            // the legacy message markers as a fallback).  
            classpathPlugin(AnalyticsPlugin.class, Collections.emptyList()),  
                .setTransientSettings(Settings.builder().put("datafusion.memory_guard.execution.critical_threshold", -0.5).build())
import org.opensearch.test.OpenSearchIntegTestCase;  
        );  
        refresh(INDEX_NAME);  
            );
                .setTransientSettings(Settings.builder().put("datafusion.memory_guard.admission_reject_threshold", -0.1).build())
        NodesStatsResponse stats = client().admin().cluster().prepareNodesStats().addMetric("breaker").get();  
            .endObject()
import org.opensearch.common.settings.Settings;
                .get()
                .cluster()
                Exception.class,  
            extendedPlugins,  
                .cluster()
    }
            // (NativeErrorConverter) to a 429-bearing OpenSearchException; walk the chain for that 429 (or
import java.util.Collections;  
    }
            .get();  
            .endObject();
                .prepareUpdateSettings()
                .prepareUpdateSettings()
    @Override
            .setTransientSettings(Settings.builder().put("datafusion.memory_pool_limit_bytes", newLimit).build())
    }
            "classpath plugin",  
    }
 * compatible open source license.
            .get();  
        );  
            () -> client().admin()  
        Settings indexSettings = Settings.builder()
        createIndexAndIngest();
            "NA",
    }  
        assertEquals("0.5", response.getTransientSettings().get("datafusion.memory_guard.admission_throttle_threshold"));
            );
                Settings.builder()
            null,
        );
            .put(super.nodeSettings(nodeOrdinal))
            ArrowBasePlugin.class,
import org.opensearch.index.engine.dataformat.stub.MockCommitterEnginePlugin;
import org.opensearch.common.util.FeatureFlags;
        expectThrows(  
        assertTrue(response.isAcknowledged());
        NodesStatsResponse stats = client().admin().cluster().prepareNodesStats().addMetric("breaker").get();  
 * - Queries are rejected when pool limit is exhausted
        return Settings.builder()
    public void testMinTargetPartitionsRejectsZero() {  
                .prepareUpdateSettings()  
    /** True if {@code t}'s cause chain carries a 429 OpenSearchException or a known memory-pressure message marker. */  
    private void createIndexAndIngest() throws Exception {  
            .startObject()
                    || msg.contains("analytics_backend_datafusion")
        try {
        PPLResponse response = executePPL("source = " + INDEX_NAME + " | stats count()");
            IllegalArgumentException.class,  
            // in the CAUSE CHAIN, not the top-level message. The native trip is converted on the data node
            .put(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG, true)  
                .setTransientSettings(Settings.builder().put("datafusion.min_target_partitions", 0).build())  
            // Reset so cluster teardown doesn't fail  
        createIndexAndIngest();
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
            client().admin()
        assertFalse("Bulk ingest should not have errors", bulkResponse.hasFailures());
    public void testBreakerStatsReflectDynamicLimitUpdate() {  
        for (int i = 0; i < 2000; i++) {  
import org.opensearch.arrow.flight.transport.FlightStreamPlugin;
package org.opensearch.analytics.resilience;
                .prepareUpdateSettings()  
            String msg = c.getMessage();  
        );
 */
/**
        }
import org.opensearch.cluster.metadata.IndexMetadata;  
    }
            .startObject("count").field("type", "integer").endObject()  
    }
    private static boolean hasMemoryPressureSignal(Throwable t) {
        ClusterUpdateSettingsResponse response = client().admin()  
import java.util.UUID;
            }
    public void testQuerySucceedsAtNormalPoolLimit() throws Exception {  
