        SqlPlanRunner runner = sqlPlanRunner();
    private static PluginInfo classpathPlugin(Class<? extends Plugin> pluginClass, List<String> extendedPlugins) {
        client().admin().indices().prepareRefresh("http_logs").get();
        }
        createAndSeedIndex(1);
            .put(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG, true)
     *
    }
        }
import java.util.Collection;
        assertEquals("matched rows must be [1,1,2,2]", List.of(1, 1, 2, 2), vals);
    }
        // Three distinct vals, each repeated → 1, 2, 3, 1, 2, 3.
    /**
     *  COORDINATOR+SINGLETON (1-shard scan path doesn't need an ER), but the Values arm
        ensureGreen(INDEX);
     *  Values arm runs as LOCAL_COMPUTE on coord. */
        );
        createAndSeedIndex(2);
            .put("index.pluggable.dataformat.enabled", true)
import java.util.List;
    /** Values as a Union arm, 1-shard scan. Scan arm and Values arm are both already at
    }
    protected Collection<PluginInfo> additionalNodePlugins() {
            .put("index.composite.primary_data_format", "parquet")
    }
            classpathPlugin(ParquetOnlyDataFormatPlugin.class, Collections.emptyList()),
            .put(super.nodeSettings(nodeOrdinal))
import org.opensearch.action.admin.indices.create.CreateIndexResponse;
            "NA",
package org.opensearch.analytics.sql;
            .put(FeatureFlags.STREAM_TRANSPORT, true)
    }
        // Seeded rows: GET/100, POST/50, GET/200, GET/300 → GET sum = 600
    }
            classpathPlugin(FlightStreamPlugin.class, List.of(ArrowBasePlugin.class.getName())),
        );
    public void testLiteralWithAggregateAndFilter_1shard() {
/*
import org.opensearch.test.OpenSearchIntegTestCase;
    }
import org.opensearch.analytics.AnalyticsPlugin;
    // ── Test infrastructure ─────────────────────────────────────────────────
     * Literal-projection + aggregate + filter against {@code http_logs}: confirms
        createAndSeedIndex(1);
            .indices()
    protected Collection<Class<? extends Plugin>> nodePlugins() {
        List<Integer> vals = new ArrayList<>();
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.SUITE, numDataNodes = 2, numClientNodes = 0)
        boolean foundLiteral = false;
import org.opensearch.arrow.flight.transport.FlightStreamPlugin;
        client().admin().indices().prepareRefresh(INDEX).get();
        return List.of(
        SqlPlanRunner runner = sqlPlanRunner();
    private void createAndSeedIndex(int shardCount) {
import org.opensearch.index.engine.dataformat.stub.MockCommitterEnginePlugin;
     * ({@code SUM(size)}) survives the planner end-to-end. The constant folds into
        Settings indexSettings = Settings.builder()
            .build();
                break;
        }
            if (((Number) row[0]).intValue() == 99) {
            .setSettings(indexSettings)
     * {@code (2, total_size_of_GET_rows)}.
            .put("index.pluggable.dataformat", "composite")
            .build();
        assertEquals("x", rows.getFirst()[1]);
        CreateIndexResponse response = client().admin()
     *  still runs as LOCAL_COMPUTE on coord. */
 * End-to-end IT for {@code LogicalValues} composed with set/join operators. The Values
        return List.of(ArrowBasePlugin.class, CompositeDataFormatPlugin.class, MockCommitterEnginePlugin.class);
        for (Object[] row : rows) {
            null,
            pluginClass.getName(),
            "SELECT val FROM " + INDEX + " UNION ALL SELECT x FROM (VALUES (99)) AS v(x)"
        assertTrue("index creation must be acknowledged", response.isAcknowledged());
            }
        assertEquals(2, ((Number) rows.getFirst()[0]).intValue());
 */
     * {@code LogicalValues}. With no shard scan in the fragment, DAGBuilder picks
        assertTrue("UNION result must contain the literal 99 from the Values arm", foundLiteral);
        assertEquals("source-less SELECT must produce a single row", 1, rows.size());
}
            .setMapping("val", "type=integer")
        ClusterService clusterService = internalCluster().getInstance(ClusterService.class, node);
        assertEquals("JOIN over Values must yield 4 rows (matches: 1,1,2,2)", 4, rows.size());
import org.opensearch.analytics.exec.DefaultPlanExecutor;
import org.opensearch.Version;
        List<Object[]> rows = runner.executeSql(
 * wiring beyond the existing MultiInputExchangeSink machinery.
        client().admin().indices().prepareFlush("http_logs").get();
        assertUnionAllValuesAndScan();
    /** Values as a Union arm, 2-shard scan. Scan arm gathers across 2 shards via ER;
    private static final String INDEX = "values_idx";
        );
        }
        return new SqlPlanRunner(clusterService, executor);
    }
     * Source-less {@code SELECT 1 + 1, 'x'} — Calcite lowers this to a single-row
            .prepareCreate("http_logs")
     * coordinator-only execution path.
        SqlPlanRunner runner = sqlPlanRunner();
        assertUnionAllValuesAndScan();
            .build();
        createAndSeedHttpLogsIndex(1);
        client().admin().indices().prepareFlush(INDEX).get();
     * <p>1-shard only for now — the multi-shard PARTIAL→FINAL path hits a separate
        assertEquals("UNION ALL of 6 idx rows + 1 values row must yield 7", 7, rows.size());
    /**
    public void testUnionAll_valuesArm_andScanArm_1shard() {
        for (int i = 0; i < TOTAL_DOCS; i++) {
            .indices()
    }
import org.opensearch.plugins.Plugin;
    }
     * a Project that mixes a constant ({@code 1 + 1 AS x}) with an aggregate column
    public void testInnerJoin_scanWithValuesArm_2shard() {
        ensureGreen("http_logs");
    private SqlPlanRunner sqlPlanRunner() {
    private void assertUnionAllValuesAndScan() {
        assertEquals("x must be 1 + 1", 2, ((Number) row[0]).intValue());
        Settings indexSettings = Settings.builder()
 */
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
            .get();
import java.util.ArrayList;
     * and the aggregate runs over the filtered scan output. Result: a single row
            .put("index.pluggable.dataformat", "composite")
     * Int32/Int64 width drift in the reduce sink that's being fixed in another change.
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, shardCount)
        List<Object[]> rows = runner.executeSql(
    }
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, shardCount)
import org.opensearch.be.datafusion.DataFusionPlugin;
 * SPDX-License-Identifier: Apache-2.0
public class ValuesSqlIT extends OpenSearchIntegTestCase {
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
 * stage runs locally on the coordinator (LOCAL_COMPUTE); these tests verify it feeds a
    /** Values as a Join arm, 1-shard scan. */
        );
    }
    }
        CreateIndexResponse response = client().admin()
            client().prepareIndex("http_logs").setSource("verb", docs[i][0], "size", docs[i][1]).get();
            Version.CURRENT,
import org.opensearch.common.util.FeatureFlags;
            int val = (i % 3) + 1;
    private void assertInnerJoinScanWithValues() {
        return new PluginInfo(
    public void testValues_literalRow() {
        SqlPlanRunner runner = sqlPlanRunner();
            client().prepareIndex(INDEX).setSource("val", val).get();
        List<Object[]> rows = runner.executeSql("SELECT 1 + 1, 'x'");
 * compatible open source license.
import org.opensearch.arrow.allocator.ArrowBasePlugin;
    @Override
        for (Object[] row : rows) {
    }
 * this file be licensed under the Apache-2.0 license or a
            .putList("index.composite.secondary_data_formats")
     * {@code LOCAL_COMPUTE}; LocalComputeStageExecutionFactory hands the Substrait plan to
        Object[][] docs = { { "GET", 100 }, { "POST", 50 }, { "GET", 200 }, { "GET", 300 } };
    protected Settings nodeSettings(int nodeOrdinal) {
import org.opensearch.common.settings.Settings;
 * The OpenSearch Contributors require contributions made to
     */
            false
    @Override
/**
            classpathPlugin(DataFusionPlugin.class, List.of(AnalyticsPlugin.class.getName()))
            extendedPlugins,
            classpathPlugin(AnalyticsPlugin.class, Collections.emptyList()),
        return Settings.builder()
            "1.8",
    private void createAndSeedHttpLogsIndex(int shardCount) {
            .putList("index.composite.secondary_data_formats")
        assertInnerJoinScanWithValues();
            .prepareCreate(INDEX)
    public void testInnerJoin_scanWithValuesArm_1shard() {
 *
        java.util.Collections.sort(vals);
            "classpath plugin",
            .setSettings(indexSettings)
     * the OpenSearchProject expression list — no Values rel is introduced for it —
import org.opensearch.parquet.ParquetOnlyDataFormatPlugin;
    }
import org.opensearch.plugins.PluginInfo;
        List<Object[]> rows = runner.executeSql("SELECT 1 + 1 AS x, SUM(size) FROM http_logs WHERE verb = 'GET'");
        String node = internalCluster().getNodeNames()[0];
 * @opensearch.internal
            .setMapping("verb", "type=keyword,index=false", "size", "type=integer")
                foundLiteral = true;
import java.util.Collections;
            pluginClass.getName(),
 * multi-input parent (Union / Join) alongside a shard-side scan arm without extra
import org.opensearch.composite.CompositeDataFormatPlugin;
        Object[] row = rows.getFirst();
 *
        assertEquals("single aggregated row expected", 1, rows.size());
    /** Values as a Join arm, 2-shard scan. */
import org.opensearch.cluster.metadata.IndexMetadata;
            "SELECT i.val FROM " + INDEX + " i JOIN (VALUES (1), (2)) AS v(x) ON i.val = v.x"
    public void testUnionAll_valuesArm_andScanArm_2shard() {
            .put("index.pluggable.dataformat.enabled", true)
        DefaultPlanExecutor executor = internalCluster().getInstance(DefaultPlanExecutor.class, node);
            vals.add(((Number) row[0]).intValue());
import org.opensearch.cluster.service.ClusterService;
    @Override
     */
        for (int i = 0; i < docs.length; i++) {
            .get();
     * DataFusion's local session with no childInputs. Exercises the pure
    private static final int TOTAL_DOCS = 6;
        assertTrue("http_logs creation must be acknowledged", response.isAcknowledged());
        createAndSeedIndex(2);
        assertInnerJoinScanWithValues();
            .put("index.composite.primary_data_format", "parquet")
        assertEquals("SUM(size) over verb='GET' rows", 600L, ((Number) row[1]).longValue());
