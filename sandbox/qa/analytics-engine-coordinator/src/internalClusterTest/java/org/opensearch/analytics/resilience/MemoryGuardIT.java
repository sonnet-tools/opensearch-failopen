        expectThrows(
        expectThrows(
                    .put("datafusion.memory_guard.execution.critical_threshold", 0.95)
            .cluster()
        );
        expectThrows(
 */
        NodesStatsResponse stats = client().admin().cluster().prepareNodesStats().addMetric("breaker").get();
                client().prepareIndex(INDEX_NAME)
            bulk.add(
                .get();
            .putList("index.composite.secondary_data_formats")
import java.util.Collections;
        assertTrue("analytics_backend_datafusion breaker should be registered", found);
        assertTrue(response.isAcknowledged());
        // Set pool to 1 byte — any GROUP BY should fail
                .setTransientSettings(Settings.builder().put("datafusion.memory_guard.execution.critical_threshold", -0.5).build())
        );
            .put("index.composite.primary_data_format", "parquet")
    }
            IllegalArgumentException.class,
                return true;
                .get()
import org.opensearch.be.datafusion.DataFusionPlugin;
    /** True if {@code t}'s cause chain carries a 429 OpenSearchException or a known memory-pressure message marker. */
    public void testBreakerStatsReflectDynamicLimitUpdate() {
import org.opensearch.core.indices.breaker.CircuitBreakerStats;
import org.opensearch.arrow.flight.transport.FlightStreamPlugin;
    }
    protected Collection<PluginInfo> additionalNodePlugins() {
/**
        }
                .prepareUpdateSettings()
            pluginClass.getName(),
        NodesStatsResponse stats = client().admin().cluster().prepareNodesStats().addMetric("breaker").get();
            if (msg != null
            .get();
import org.opensearch.common.xcontent.XContentFactory;
import org.opensearch.ppl.action.PPLRequest;
        );
                .get()
            assertTrue(
            client().admin()
            .put(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG, true)
                return true;
            }
                .cluster()
import org.opensearch.composite.CompositeDataFormatPlugin;
 * - Breaker stats (tripped count, live limit) are correctly reported after dynamic updates
            if (c instanceof OpenSearchException ose && ose.status() == org.opensearch.core.rest.RestStatus.TOO_MANY_REQUESTS) {
 * - Queries are rejected when pool limit is exhausted
            .cluster()
            String msg = c.getMessage();
        try {
            pluginClass.getName(),
            TestPPLPlugin.class,
            () -> client().admin()
                .cluster()
            // in the CAUSE CHAIN, not the top-level message. The native trip is converted on the data node
    }
                .setTransientSettings(Settings.builder().put("datafusion.memory_guard.admission_reject_threshold", -0.1).build())
            ArrowBasePlugin.class,
        } finally {
            .startObject("properties")
                .cluster()
            CompositeDataFormatPlugin.class,
import org.opensearch.action.bulk.BulkResponse;
                .prepareUpdateSettings()
        ClusterUpdateSettingsResponse response = client().admin()
        assertTrue(response.isAcknowledged());
        );
import org.opensearch.ppl.TestPPLPlugin;
import org.opensearch.action.admin.cluster.settings.ClusterUpdateSettingsResponse;
import org.opensearch.common.util.FeatureFlags;
import org.opensearch.action.admin.cluster.node.stats.NodeStats;
                .cluster()
        return new PluginInfo(
        Settings indexSettings = Settings.builder()
import org.opensearch.ppl.action.UnifiedPPLExecuteAction;
package org.opensearch.analytics.resilience;
        refresh(INDEX_NAME);
    public void testMemoryGuardThresholdRejectsOutOfRange() {
                .prepareUpdateSettings()
                .setTransientSettings(Settings.builder().put("datafusion.memory_pool_limit_bytes", 256 * 1024 * 1024L).build())
        createIndexAndIngest();
            // (NativeErrorConverter) to a 429-bearing OpenSearchException; walk the chain for that 429 (or
import org.opensearch.core.xcontent.XContentBuilder;
            .setTransientSettings(Settings.builder().put("datafusion.min_target_partitions", 4).build())
                Exception.class,
    }
            // The shard fragment wraps the failure as "Stage N failed", so the memory-pressure signal lives
        assertNotNull("Breaker stats should not be null", breakerStats);
            "classpath plugin",
        for (int i = 0; i < 2000; i++) {
                "Memory-pool exhaustion must surface as HTTP 429 somewhere in the failure chain, got: " + ex,
    private void createIndexAndIngest() throws Exception {
            .put("index.pluggable.dataformat.enabled", true)
                () -> executePPL("source = " + INDEX_NAME + " | stats count() by url")
            IllegalArgumentException.class,
        assertEquals("Breaker limit should reflect dynamic update", newLimit, breakerStats.getLimit());
    }
        assertNotNull(response);
import java.util.Collection;
            classpathPlugin(DataFusionPlugin.class, List.of(AnalyticsPlugin.class.getName()))
    public void testBreakerRegisteredWithCorrectName() {
 * - Dynamic settings (min_target_partitions, memory_guard thresholds) are accepted and validated
    @Override
import java.util.List;
        );
        expectThrows(
                    .build()
 *
        long newLimit = 42 * 1024 * 1024L;
            classpathPlugin(AnalyticsPlugin.class, Collections.emptyList()),
            () -> client().admin()
    private PPLResponse executePPL(String query) {
            .put(super.nodeSettings(nodeOrdinal))
            .setTransientSettings(Settings.builder().put("datafusion.memory_pool_limit_bytes", 1L).build())
            CircuitBreakerStats breakerStats = nodeStats.getBreaker().getStats("analytics_backend_datafusion");
        assertTrue(
import org.opensearch.analytics.AnalyticsPlugin;
import org.opensearch.OpenSearchException;
                .prepareUpdateSettings()
 * compatible open source license.
import org.opensearch.test.OpenSearchIntegTestCase;
import org.opensearch.arrow.allocator.ArrowBasePlugin;
 * - Breaker is registered with correct name (analytics_backend_datafusion)
 *
            .startObject("url").field("type", "keyword").field("index", "false").endObject()
    public void testQuerySucceedsAtNormalPoolLimit() throws Exception {
            // the legacy message markers as a fallback).
            .put("index.pluggable.dataformat", "composite")
    @Override
        BulkRequestBuilder bulk = client().prepareBulk();
        for (NodeStats nodeStats : stats.getNodes()) {
            .get();
 * - Queries succeed under normal memory limits
        ClusterUpdateSettingsResponse response = client().admin()
            null,
        );
                found = true;
    }
import org.opensearch.Version;
    private static PluginInfo classpathPlugin(Class<? extends Plugin> pluginClass, List<String> extendedPlugins) {
import org.opensearch.parquet.ParquetOnlyDataFormatPlugin;
            );
            .setTransientSettings(Settings.builder().put("datafusion.memory_pool_limit_bytes", newLimit).build())
                    .put("datafusion.memory_guard.admission_reject_threshold", 0.9)
import org.opensearch.cluster.metadata.IndexMetadata;
        assertEquals("0.5", response.getTransientSettings().get("datafusion.memory_guard.admission_throttle_threshold"));
    }
    public void testMemoryGuardThresholdsSettable() {
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 1, numClientNodes = 0, supportsDedicatedMasters = false)
                    .setSource("user_id", i, "url", "https://example.com/" + UUID.randomUUID(), "count", i % 100)
        boolean found = false;
            Exception ex = expectThrows(
                    || msg.contains("Resources exhausted")
public class MemoryGuardIT extends OpenSearchIntegTestCase {
    }
    }
            "NA",
        CircuitBreakerStats breakerStats = stats.getNodes().get(0).getBreaker().getStats("analytics_backend_datafusion");
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
            )
            if (breakerStats != null) {
            () -> client().admin()
        return false;
import org.opensearch.index.engine.dataformat.stub.MockCommitterEnginePlugin;
            .prepareUpdateSettings()
            IllegalArgumentException.class,
        assertEquals("0.85", response.getTransientSettings().get("datafusion.memory_guard.execution.spill_threshold"));
        assertFalse("Bulk ingest should not have errors", bulkResponse.hasFailures());
        ClusterUpdateSettingsResponse response = client().admin()
                    .put("datafusion.memory_guard.admission_throttle_threshold", 0.5)
            .startObject()
    }
                    || msg.contains("analytics_backend_datafusion")
        assertEquals("4", response.getTransientSettings().get("datafusion.min_target_partitions"));
            .startObject("count").field("type", "integer").endObject()
            .prepareUpdateSettings()
    }
    @Override
        return Settings.builder()
                Settings.builder()
                .get()
        );
            client().admin().indices().prepareCreate(INDEX_NAME).setSettings(indexSettings).setMapping(mapping).get().isAcknowledged()
            // Reset so cluster teardown doesn't fail
            () -> client().admin()
        }
        createIndexAndIngest();
            .put("datafusion.spill_directory", createTempDir().toString())
            classpathPlugin(FlightStreamPlugin.class, List.of(ArrowBasePlugin.class.getName())),
    }
    }
 * The OpenSearch Contributors require contributions made to
            );
            .prepareUpdateSettings()
                .get()
                .prepareUpdateSettings()
            false
            }
}
        client().admin()
        }
            extendedPlugins,
        XContentBuilder mapping = XContentFactory.jsonBuilder()
                .get()
        return List.of(
        assertEquals("0.9", response.getTransientSettings().get("datafusion.memory_guard.admission_reject_threshold"));
                .prepareUpdateSettings()
    public void testMinTargetPartitionsRejectsZero() {
                .setTransientSettings(Settings.builder().put("datafusion.memory_guard.execution.spill_threshold", 2.0).build())
            .startObject("user_id").field("type", "long").endObject()
import org.opensearch.common.settings.Settings;
            .cluster()
            .prepareUpdateSettings()
        assertTrue(response.isAcknowledged());
    private static final String INDEX_NAME = "mem_guard_test";
 * Verifies:
            "1.8",
 * SPDX-License-Identifier: Apache-2.0
            .setTransientSettings(
        PPLResponse response = executePPL("source = " + INDEX_NAME + " | stats count()");
        }
                .setTransientSettings(Settings.builder().put("datafusion.min_target_partitions", 0).build())
            .get();
    }
                    || msg.contains("insufficient memory budget"))) {
import org.opensearch.plugins.PluginInfo;
                hasMemoryPressureSignal(ex)
    }
                && (msg.contains("CircuitBreakingException")
import org.opensearch.action.admin.cluster.node.stats.NodesStatsResponse;
            .build();
import org.opensearch.ppl.action.PPLResponse;
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        );
    protected Settings nodeSettings(int nodeOrdinal) {
        );
import org.opensearch.action.bulk.BulkRequestBuilder;
            .build();
/*
            IllegalArgumentException.class,
            classpathPlugin(ParquetOnlyDataFormatPlugin.class, Collections.emptyList()),
        return client().execute(UnifiedPPLExecuteAction.INSTANCE, new PPLRequest(query)).actionGet();
import java.util.UUID;
                break;
        expectThrows(
            () -> client().admin()
            IllegalArgumentException.class,
                .cluster()
                .setTransientSettings(Settings.builder().put("datafusion.memory_guard.admission_throttle_threshold", 1.5).build())
            MockCommitterEnginePlugin.class
            Version.CURRENT,
    private static boolean hasMemoryPressureSignal(Throwable t) {
        assertEquals("0.95", response.getTransientSettings().get("datafusion.memory_guard.execution.critical_threshold"));
    public void testMinTargetPartitionsSettable() {
        for (Throwable c = t; c != null && c != c.getCause(); c = c.getCause()) {
            .put(FeatureFlags.STREAM_TRANSPORT, true)
        BulkResponse bulkResponse = bulk.get();
        return List.of(
                .cluster()
    protected Collection<Class<? extends Plugin>> nodePlugins() {
            );
    public void testQueryRejectedWhenPoolExhausted() throws Exception {
import org.opensearch.plugins.Plugin;
 */
            }
            .endObject()
                    .put("datafusion.memory_guard.execution.spill_threshold", 0.85)
            .get();
            .endObject();
 * this file be licensed under the Apache-2.0 license or a
        ensureGreen(INDEX_NAME);
 * Integration tests for the DataFusion memory guard and circuit breaker.
            .cluster()
