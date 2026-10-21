            .put("index.pluggable.dataformat", "composite")
            Version.CURRENT,
            .get();
    }
    private static final String LIMIT_KEY = TransportSearchAction.SHARD_COUNT_LIMIT_SETTING.getKey();
        withLimit(2, () -> {
        assertEquals("no limit configured, so all 4 shards run", 4, rows.size());
import org.opensearch.index.engine.dataformat.stub.MockCommitterEnginePlugin;
            .setTransientSettings(Settings.builder().putNull(LIMIT_KEY).build())
import org.opensearch.analytics.sql.SqlPlanRunner;
    private DefaultPlanExecutor executor() {
            internalCluster().getInstance(DefaultPlanExecutor.class, node)
import org.opensearch.cluster.metadata.IndexMetadata;
            .setSettings(indexSettings)
}
    /** SUITE scope shares a cluster, so every limit override has to be undone. */
        });
            client().prepareIndex(indexName).setSource("val", i + 1).get();
import org.opensearch.action.search.TransportSearchAction;
import java.util.List;
            classpathPlugin(DataFusionPlugin.class, List.of(AnalyticsPlugin.class.getName()))
                    updated,
        }
 *
     * single-index queries so that its aggressive default did not break them, which the unlimited
        }
import org.opensearch.composite.CompositeDataFormatPlugin;
        createSingleIndex("single_idx", 3);
            .putList("index.composite.secondary_data_formats")
            // The settings-update consumer propagates asynchronously; assertBusy tolerates the gap.
 * <p>The limit counts shards, not indices — an oversharded single index costs the coordinator the same
    public void testAliasQueryRejectedWhenShardCountExceedsLimit() {
 * compatible open source license.
            .get();
import org.opensearch.action.admin.indices.alias.IndicesAliasesRequest;
        return Settings.builder()
                .prepareUpdateSettings()
import org.opensearch.analytics.exec.DefaultPlanExecutor;
    private void createIndexWithAlias(String indexName, int shardCount) {
    private void setLimit(int limit) {
    private static final String ALIAS = "test_alias";
            .prepareUpdateSettings()
                    .cluster()
        try {
        ).actionGet();
                () -> assertEquals(
            null,
            classpathPlugin(FlightStreamPlugin.class, List.of(ArrowBasePlugin.class.getName())),
                () -> runner().executeSql("SELECT val FROM " + dynAlias)
    /** An unconfigured cluster rejects nothing, however wide the fan-out. */
            // Raise it — no restart.
 * as an alias spanning the same shards, so both are subject to it.
     * settings-update consumer), and a query must still succeed under the new value.
public class ShardCountLimitIT extends OpenSearchIntegTestCase {
import java.util.Collections;
                    "executor must observe the dynamic per-node concurrency update",
        final String dynAlias = "dynamic_alias";
            assertThat(ex.getMessage(), containsString("[2]"));
                )
    private void clearLimit() {
    /** No limit in node settings on purpose: the default is unlimited, and each test opts in transiently. */
        withLimit(2, () -> {
                    Settings.builder().putNull(AnalyticsQuerySettings.MAX_CONCURRENT_SHARD_REQUESTS_PER_NODE.getKey()).build()
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.SUITE, numDataNodes = 1, numClientNodes = 0, supportsDedicatedMasters = false)
    @Override
        }
    public void testSingleIndexIsSubjectToTheLimitToo() {
    @Override
            setLimit(10);
     * {@code _cluster/settings} must be observed by the live {@link DefaultPlanExecutor} (its
        createIndexWithAlias("idx_a", 2);
        try {
            internalCluster().getInstance(ClusterService.class, node),
    protected Settings nodeSettings(int nodeOrdinal) {
        createIndexWithAlias("dyn_b", 2, dynAlias); // 4 shards total
            .build();
    }
import org.opensearch.common.util.FeatureFlags;
            );
     * {@code analytics.query.max_concurrent_shard_requests_per_node} is dynamic: updating it via
import org.opensearch.common.settings.Settings;
        Settings indexSettings = Settings.builder()
        createIndexWithAlias(indexName, shardCount, ALIAS);
 */
            assertEquals(3, runner().executeSql("SELECT val FROM concurrency_idx").size());
        }
import static org.hamcrest.Matchers.containsString;
                .get();
    }
 * The OpenSearch Contributors require contributions made to
            assertThat(ex.getMessage(), containsString("[4] shards"));
    }
     * A single index is subject to the same ceiling — it counts shards, not indices. This is the one
    }
            assertThat(ex.getMessage(), containsString("[3] shards"));
import org.opensearch.arrow.allocator.ArrowBasePlugin;
        CreateIndexResponse response = client().admin()
            assertTrue(
    private static PluginInfo classpathPlugin(Class<? extends Plugin> pluginClass, List<String> extendedPlugins) {
        return List.of(
    /** The limit is dynamic: raising it unblocks a query that was rejected a moment earlier. */
                .setTransientSettings(
        client().admin().indices().prepareFlush(indexName).get();
            IllegalArgumentException ex = expectThrows(IllegalArgumentException.class, () -> runner().executeSql("SELECT val FROM " + ALIAS));
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
            assertThat(ex.getMessage(), containsString("[4] shards"));
            pluginClass.getName(),
import org.opensearch.analytics.AnalyticsPlugin;
                .get()
        );
        );
            .put(super.nodeSettings(nodeOrdinal))
            "NA",
import org.opensearch.Version;
            .put(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG, true)
import org.opensearch.test.OpenSearchIntegTestCase;
    /** An alias spanning 4 shards is rejected once an operator sets the limit below it. */
    }
                IllegalArgumentException.class,
            setLimit(2);
    // ── helpers ──────────────────────────────────────────────────────────
            .build();
    public void testMaxConcurrentShardRequestsPerNodeUpdatesDynamically() throws Exception {
import org.opensearch.be.datafusion.DataFusionPlugin;
 * The analytics path honours vanilla's {@code action.search.shard_count.limit} rather than a limit of
 */
import org.opensearch.cluster.service.ClusterService;
            assertThat(ex2.getMessage(), containsString("[2]"));
                .prepareUpdateSettings()
            false
            "1.8",
        String node = internalCluster().getNodeNames()[0];
    private SqlPlanRunner runner() {
        return List.of(ArrowBasePlugin.class, CompositeDataFormatPlugin.class, MockCommitterEnginePlugin.class);
            client().admin()
    }
                client().admin()
    private void createIndexWithAlias(String indexName, int shardCount, String aliasName) {
        client().admin().indices().aliases(
package org.opensearch.analytics.resilience;
            );
     */
            classpathPlugin(ParquetOnlyDataFormatPlugin.class, Collections.emptyList()),
    public void testLimitUpdatesDynamically() {
        createIndexWithAlias("idx_b", 2);
            );
    }
                    executor.maxConcurrentShardRequestsPerNode()
    /**
        try {
    private void withLimit(int limit, Runnable body) {
        });
 *
        } finally {
                .cluster()
            .prepareCreate(indexName)
import org.opensearch.plugins.Plugin;
        createIndexWithAlias("def_b", 2, alias);
/*
            .cluster()
                IllegalArgumentException.class,
                () -> runner().executeSql("SELECT val FROM single_idx")
     * default makes unnecessary.
    }
        createSingleIndex(indexName, shardCount);
            .setMapping("val", "type=integer")
            int updated = 3;
            clearLimit();
            IllegalArgumentException ex2 = expectThrows(
import org.opensearch.parquet.ParquetOnlyDataFormatPlugin;
            client().admin()
        List<Object[]> rows = runner().executeSql("SELECT val FROM " + alias);
    }
    @Override
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, shardCount)
import org.opensearch.action.admin.indices.create.CreateIndexResponse;
     * behaviour that changed when the analytics-specific limit was replaced: the old setting exempted
            new IndicesAliasesRequest().addAliasAction(IndicesAliasesRequest.AliasActions.add().index(indexName).alias(aliasName))
    public void testUnlimitedByDefault() {
            clearLimit();
        assertTrue(
            IllegalArgumentException ex = expectThrows(
        return new PluginInfo(
        } finally {
            body.run();
            .put("index.composite.primary_data_format", "parquet")
            );
                IllegalArgumentException.class,
                        Settings.builder().put(AnalyticsQuerySettings.MAX_CONCURRENT_SHARD_REQUESTS_PER_NODE.getKey(), updated).build()
            assertEquals(4, runner().executeSql("SELECT val FROM " + dynAlias).size());
 * this file be licensed under the Apache-2.0 license or a
    /**
            setLimit(limit);
            pluginClass.getName(),
import org.opensearch.plugins.PluginInfo;
            classpathPlugin(AnalyticsPlugin.class, Collections.emptyList()),
    }
        return new SqlPlanRunner(
            .put(FeatureFlags.STREAM_TRANSPORT, true)
            // Lower it back below the shard count — rejection resumes, proving the read is live.
        client().admin().indices().prepareRefresh(indexName).get();
                .setTransientSettings(Settings.builder().put(LIMIT_KEY, limit).build())
import org.opensearch.analytics.settings.AnalyticsQuerySettings;
            .indices()
        );
        createIndexWithAlias("def_a", 2, alias);
    }
            );
                    .isAcknowledged()
    }
        client().admin()
    }
                    .setTransientSettings(
    protected Collection<Class<? extends Plugin>> nodePlugins() {
    }
        } finally {
 * operation is the can-match pre-filter phase plus the per-node dispatch throttle; this setting is the
     */
 * its own, with vanilla's posture: unlimited unless an operator opts in. What bounds fan-out in normal
        ensureGreen(indexName);
            extendedPlugins,
                .cluster()
            assertThat(ex.getMessage(), containsString(LIMIT_KEY));
import org.opensearch.arrow.flight.transport.FlightStreamPlugin;
                    .get()
            .put("index.pluggable.dataformat.enabled", true)
import java.util.Collection;
/**
 * SPDX-License-Identifier: Apache-2.0
 * hard stop for operators who want one.
            "classpath plugin",
                .isAcknowledged()
        createSingleIndex("concurrency_idx", 3);
    }
        createIndexWithAlias("dyn_a", 2, dynAlias);
        );
        final String alias = "default_alias";
        for (int i = 0; i < shardCount; i++) {
            assertThat(ex.getMessage(), containsString(LIMIT_KEY));
                    .prepareUpdateSettings()
    private void createSingleIndex(String indexName, int shardCount) {
        assertTrue(response.isAcknowledged());
                )
        DefaultPlanExecutor executor = executor();
            assertThat(ex.getMessage(), containsString("alias [" + ALIAS + "]"));
    }
                    )
                () -> runner().executeSql("SELECT val FROM " + dynAlias)
    protected Collection<PluginInfo> additionalNodePlugins() {
            IllegalArgumentException ex = expectThrows(
            setLimit(2);
        return internalCluster().getInstance(DefaultPlanExecutor.class, internalCluster().getNodeNames()[0]);
            assertBusy(
