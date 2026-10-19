        createSingleIndex(indexName, shardCount);
    private DefaultPlanExecutor executor() {
        for (int i = 0; i < shardCount; i++) {
 * as an alias spanning the same shards, so both are subject to it.  
import java.util.Collection;
                )
        } finally {
        }
    }  
                .isAcknowledged()
 * operation is the can-match pre-filter phase plus the per-node dispatch throttle; this setting is the
import org.opensearch.composite.CompositeDataFormatPlugin;
    }
            assertThat(ex.getMessage(), containsString("[4] shards"));  
            setLimit(2);
                    .isAcknowledged()
            assertThat(ex.getMessage(), containsString("[4] shards"));
                .setTransientSettings(  
        Settings indexSettings = Settings.builder()
    }
                () -> assertEquals(  
        createIndexWithAlias("dyn_a", 2, dynAlias);  
            // Raise it — no restart.
    // ── helpers ──────────────────────────────────────────────────────────
            int updated = 3;
        ).actionGet();
        return List.of(  
    protected Settings nodeSettings(int nodeOrdinal) {  
            IllegalArgumentException ex = expectThrows(
            assertThat(ex.getMessage(), containsString("[3] shards"));
            clearLimit();  
        });  
            .put("index.composite.primary_data_format", "parquet")
            .prepareUpdateSettings()  
            assertEquals(4, runner().executeSql("SELECT val FROM " + dynAlias).size());
        createIndexWithAlias("def_a", 2, alias);
        createIndexWithAlias("idx_a", 2);
    /** The limit is dynamic: raising it unblocks a query that was rejected a moment earlier. */  
    }  
import org.opensearch.Version;
            assertThat(ex.getMessage(), containsString(LIMIT_KEY));
            );
import org.opensearch.plugins.Plugin;
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
            client().admin()  
                () -> runner().executeSql("SELECT val FROM single_idx")
 */
        final String dynAlias = "dynamic_alias";
     * default makes unnecessary.  
                () -> runner().executeSql("SELECT val FROM " + dynAlias)
        createIndexWithAlias("def_b", 2, alias);  
     */
    private void createSingleIndex(String indexName, int shardCount) {
import org.opensearch.analytics.settings.AnalyticsQuerySettings;
            assertBusy(
    private void withLimit(int limit, Runnable body) {
    protected Collection<PluginInfo> additionalNodePlugins() {
            .prepareCreate(indexName)
}
                    .cluster()
    }  
        assertEquals("no limit configured, so all 4 shards run", 4, rows.size());  
import org.opensearch.plugins.PluginInfo;
    private void setLimit(int limit) {
import org.opensearch.action.admin.indices.alias.IndicesAliasesRequest;
            new IndicesAliasesRequest().addAliasAction(IndicesAliasesRequest.AliasActions.add().index(indexName).alias(aliasName))  
            // The settings-update consumer propagates asynchronously; assertBusy tolerates the gap.
import org.opensearch.parquet.ParquetOnlyDataFormatPlugin;  
        );
        client().admin().indices().prepareFlush(indexName).get();  
        final String alias = "default_alias";
 * SPDX-License-Identifier: Apache-2.0
    }
        DefaultPlanExecutor executor = executor();
                .cluster()
            .put(super.nodeSettings(nodeOrdinal))
                    "executor must observe the dynamic per-node concurrency update",
            classpathPlugin(FlightStreamPlugin.class, List.of(ArrowBasePlugin.class.getName())),
    @Override
    /** An unconfigured cluster rejects nothing, however wide the fan-out. */
import org.opensearch.common.util.FeatureFlags;  
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.cluster.service.ClusterService;
    private void createIndexWithAlias(String indexName, int shardCount, String aliasName) {  
            null,
            assertEquals(3, runner().executeSql("SELECT val FROM concurrency_idx").size());
        String node = internalCluster().getNodeNames()[0];
            // Lower it back below the shard count — rejection resumes, proving the read is live.  
    private static PluginInfo classpathPlugin(Class<? extends Plugin> pluginClass, List<String> extendedPlugins) {
            client().admin()  
    /** SUITE scope shares a cluster, so every limit override has to be undone. */  
        createIndexWithAlias("dyn_b", 2, dynAlias); // 4 shards total
    private SqlPlanRunner runner() {  
                    .setTransientSettings(  
            );
        try {  
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, shardCount)  
        createSingleIndex("concurrency_idx", 3);  
        createIndexWithAlias("idx_b", 2);  
import java.util.Collections;  
            classpathPlugin(ParquetOnlyDataFormatPlugin.class, Collections.emptyList()),  
    private void clearLimit() {  
        }  
     * single-index queries so that its aggressive default did not break them, which the unlimited
                    .prepareUpdateSettings()
            assertThat(ex.getMessage(), containsString(LIMIT_KEY));
            .cluster()
            IllegalArgumentException ex = expectThrows(  
import org.opensearch.index.engine.dataformat.stub.MockCommitterEnginePlugin;
            .build();  
            .build();
                    .get()  
            classpathPlugin(AnalyticsPlugin.class, Collections.emptyList()),
import org.opensearch.arrow.flight.transport.FlightStreamPlugin;
    }
import org.opensearch.common.settings.Settings;
/**
    }
                        Settings.builder().put(AnalyticsQuerySettings.MAX_CONCURRENT_SHARD_REQUESTS_PER_NODE.getKey(), updated).build()
                IllegalArgumentException.class,
        return new SqlPlanRunner(
        }
    }
    }
    /** An alias spanning 4 shards is rejected once an operator sets the limit below it. */  
     */
            );
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.SUITE, numDataNodes = 1, numClientNodes = 0, supportsDedicatedMasters = false)
public class ShardCountLimitIT extends OpenSearchIntegTestCase {  
import org.opensearch.test.OpenSearchIntegTestCase;  
            setLimit(10);  
            assertTrue(
 * compatible open source license.
 * <p>The limit counts shards, not indices — an oversharded single index costs the coordinator the same
    public void testUnlimitedByDefault() {  
        assertTrue(
     * settings-update consumer), and a query must still succeed under the new value.  
    /**  
            "1.8",
                IllegalArgumentException.class,  
        );  
        withLimit(2, () -> {
        client().admin().indices().prepareRefresh(indexName).get();
import java.util.List;
        );
                .get();  
            "classpath plugin",
            .indices()  
            .get();
            .put(FeatureFlags.STREAM_TRANSPORT, true)
    }
 * The analytics path honours vanilla's {@code action.search.shard_count.limit} rather than a limit of  
        });
    private static final String LIMIT_KEY = TransportSearchAction.SHARD_COUNT_LIMIT_SETTING.getKey();  
    public void testSingleIndexIsSubjectToTheLimitToo() {
    }  
            internalCluster().getInstance(DefaultPlanExecutor.class, node)
        client().admin().indices().aliases(
            pluginClass.getName(),  
            body.run();
            assertThat(ex.getMessage(), containsString("[2]"));  
    private void createIndexWithAlias(String indexName, int shardCount) {
    /** No limit in node settings on purpose: the default is unlimited, and each test opts in transiently. */
            .get();
            assertThat(ex2.getMessage(), containsString("[2]"));  
        } finally {
    }
                .prepareUpdateSettings()
import org.opensearch.analytics.sql.SqlPlanRunner;
                .get()
     * {@code _cluster/settings} must be observed by the live {@link DefaultPlanExecutor} (its
            pluginClass.getName(),
    public void testLimitUpdatesDynamically() {
        } finally {
            setLimit(2);
                    updated,
import org.opensearch.cluster.metadata.IndexMetadata;  
            .setMapping("val", "type=integer")  
                    executor.maxConcurrentShardRequestsPerNode()  
            .put("index.pluggable.dataformat.enabled", true)
                .cluster()
 * this file be licensed under the Apache-2.0 license or a
            .setTransientSettings(Settings.builder().putNull(LIMIT_KEY).build())
                IllegalArgumentException.class,  
import org.opensearch.analytics.exec.DefaultPlanExecutor;  
    }
import org.opensearch.arrow.allocator.ArrowBasePlugin;  
    public void testMaxConcurrentShardRequestsPerNodeUpdatesDynamically() throws Exception {
        );
            Version.CURRENT,
    protected Collection<Class<? extends Plugin>> nodePlugins() {  
     * A single index is subject to the same ceiling — it counts shards, not indices. This is the one  
    private static final String ALIAS = "test_alias";
import org.opensearch.action.admin.indices.create.CreateIndexResponse;  
        createSingleIndex("single_idx", 3);  
/*  
    /**
 * its own, with vanilla's posture: unlimited unless an operator opts in. What bounds fan-out in normal
        CreateIndexResponse response = client().admin()
            classpathPlugin(DataFusionPlugin.class, List.of(AnalyticsPlugin.class.getName()))
                .setTransientSettings(Settings.builder().put(LIMIT_KEY, limit).build())  
            .setSettings(indexSettings)
            clearLimit();
                .prepareUpdateSettings()
     * behaviour that changed when the analytics-specific limit was replaced: the old setting exempted
        return internalCluster().getInstance(DefaultPlanExecutor.class, internalCluster().getNodeNames()[0]);  
package org.opensearch.analytics.resilience;
                    )
 *
                    Settings.builder().putNull(AnalyticsQuerySettings.MAX_CONCURRENT_SHARD_REQUESTS_PER_NODE.getKey()).build()
 *
        try {  
    @Override
    public void testAliasQueryRejectedWhenShardCountExceedsLimit() {
import org.opensearch.action.search.TransportSearchAction;
                client().admin()  
    }
 */  
        withLimit(2, () -> {
            false  
            .put(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG, true)  
            IllegalArgumentException ex = expectThrows(IllegalArgumentException.class, () -> runner().executeSql("SELECT val FROM " + ALIAS));  
        return Settings.builder()
        return List.of(ArrowBasePlugin.class, CompositeDataFormatPlugin.class, MockCommitterEnginePlugin.class);
        createIndexWithAlias(indexName, shardCount, ALIAS);  
    }
        return new PluginInfo(  
            .putList("index.composite.secondary_data_formats")
        ensureGreen(indexName);  
        }
            );
            assertThat(ex.getMessage(), containsString("alias [" + ALIAS + "]"));
import static org.hamcrest.Matchers.containsString;  
            setLimit(limit);  
            extendedPlugins,
            internalCluster().getInstance(ClusterService.class, node),  
import org.opensearch.analytics.AnalyticsPlugin;
            .put("index.pluggable.dataformat", "composite")  
 * hard stop for operators who want one.  
            IllegalArgumentException ex2 = expectThrows(
        assertTrue(response.isAcknowledged());
        client().admin()
        List<Object[]> rows = runner().executeSql("SELECT val FROM " + alias);
import org.opensearch.be.datafusion.DataFusionPlugin;
        try {
    @Override
     * {@code analytics.query.max_concurrent_shard_requests_per_node} is dynamic: updating it via
                () -> runner().executeSql("SELECT val FROM " + dynAlias)
    }  
                )
            );  
            "NA",  
            client().prepareIndex(indexName).setSource("val", i + 1).get();  
