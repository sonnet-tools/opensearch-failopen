        return List.of(ArrowBasePlugin.class, CompositeDataFormatPlugin.class, MockCommitterEnginePlugin.class);
            .put("index.pluggable.dataformat.enabled", true)  
    }
            pluginClass.getName(),  
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, shardCount)
/**  
        createAndSeedHttpLogsIndex(1);
 * this file be licensed under the Apache-2.0 license or a
        );  
        assertTrue("index creation must be acknowledged", response.isAcknowledged());  
    /** Values as a Join arm, 1-shard scan. */
        client().admin().indices().prepareFlush(INDEX).get();  
        SqlPlanRunner runner = sqlPlanRunner();
    }
import org.opensearch.analytics.AnalyticsPlugin;  
        boolean foundLiteral = false;
        for (Object[] row : rows) {
            vals.add(((Number) row[0]).intValue());
    private void createAndSeedIndex(int shardCount) {
            .put(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG, true)
     *  still runs as LOCAL_COMPUTE on coord. */  
 * SPDX-License-Identifier: Apache-2.0
    private void assertUnionAllValuesAndScan() {
    /** Values as a Join arm, 2-shard scan. */
        List<Object[]> rows = runner.executeSql(  
import org.opensearch.action.admin.indices.create.CreateIndexResponse;
        DefaultPlanExecutor executor = internalCluster().getInstance(DefaultPlanExecutor.class, node);
            .setMapping("verb", "type=keyword,index=false", "size", "type=integer")
        assertEquals("source-less SELECT must produce a single row", 1, rows.size());
    /**
        Object[] row = rows.getFirst();
        Object[][] docs = { { "GET", 100 }, { "POST", 50 }, { "GET", 200 }, { "GET", 300 } };
import org.opensearch.arrow.flight.transport.FlightStreamPlugin;
import org.opensearch.plugins.PluginInfo;
        for (int i = 0; i < TOTAL_DOCS; i++) {
 * @opensearch.internal  
        assertInnerJoinScanWithValues();
        assertEquals("UNION ALL of 6 idx rows + 1 values row must yield 7", 7, rows.size());  
     * and the aggregate runs over the filtered scan output. Result: a single row  
    }
            .setMapping("val", "type=integer")
    private static final String INDEX = "values_idx";
            .setSettings(indexSettings)  
        assertEquals("SUM(size) over verb='GET' rows", 600L, ((Number) row[1]).longValue());
import org.opensearch.be.datafusion.DataFusionPlugin;
            pluginClass.getName(),
        Settings indexSettings = Settings.builder()
            if (((Number) row[0]).intValue() == 99) {  
            .build();
        assertInnerJoinScanWithValues();
        java.util.Collections.sort(vals);  
     * {@code LogicalValues}. With no shard scan in the fragment, DAGBuilder picks  
 * stage runs locally on the coordinator (LOCAL_COMPUTE); these tests verify it feeds a
 * compatible open source license.
            .put("index.pluggable.dataformat", "composite")
        // Three distinct vals, each repeated → 1, 2, 3, 1, 2, 3.  
        createAndSeedIndex(1);
    @Override
     * {@code LOCAL_COMPUTE}; LocalComputeStageExecutionFactory hands the Substrait plan to
        assertUnionAllValuesAndScan();
            }  
        );
            classpathPlugin(ParquetOnlyDataFormatPlugin.class, Collections.emptyList()),  
     *  COORDINATOR+SINGLETON (1-shard scan path doesn't need an ER), but the Values arm
import org.opensearch.cluster.metadata.IndexMetadata;
            "SELECT i.val FROM " + INDEX + " i JOIN (VALUES (1), (2)) AS v(x) ON i.val = v.x"
import org.opensearch.cluster.service.ClusterService;  
            "1.8",
import org.opensearch.common.util.FeatureFlags;
            .put("index.composite.primary_data_format", "parquet")
package org.opensearch.analytics.sql;
     */
import java.util.Collections;  
            classpathPlugin(DataFusionPlugin.class, List.of(AnalyticsPlugin.class.getName()))
    }  
    private static PluginInfo classpathPlugin(Class<? extends Plugin> pluginClass, List<String> extendedPlugins) {
     *
    /** Values as a Union arm, 1-shard scan. Scan arm and Values arm are both already at
import java.util.List;
            classpathPlugin(AnalyticsPlugin.class, Collections.emptyList()),
            .put(super.nodeSettings(nodeOrdinal))
        String node = internalCluster().getNodeNames()[0];
        List<Object[]> rows = runner.executeSql("SELECT 1 + 1, 'x'");
        client().admin().indices().prepareRefresh("http_logs").get();
        for (int i = 0; i < docs.length; i++) {
        ensureGreen("http_logs");
        return List.of(  
        assertUnionAllValuesAndScan();  
    /**
        );
 *
 *
 * The OpenSearch Contributors require contributions made to  
     * {@code (2, total_size_of_GET_rows)}.
    }  
            .setSettings(indexSettings)
    protected Settings nodeSettings(int nodeOrdinal) {
            extendedPlugins,
import org.opensearch.common.settings.Settings;
                foundLiteral = true;
            .put("index.pluggable.dataformat.enabled", true)
/*  
        assertEquals("single aggregated row expected", 1, rows.size());
        }
        ensureGreen(INDEX);
     * Int32/Int64 width drift in the reduce sink that's being fixed in another change.
import org.opensearch.test.OpenSearchIntegTestCase;
        assertTrue("http_logs creation must be acknowledged", response.isAcknowledged());
        assertEquals(2, ((Number) rows.getFirst()[0]).intValue());  
        assertEquals("x must be 1 + 1", 2, ((Number) row[0]).intValue());  
import org.opensearch.analytics.exec.DefaultPlanExecutor;
            .put("index.pluggable.dataformat", "composite")
    public void testInnerJoin_scanWithValuesArm_2shard() {  
            .putList("index.composite.secondary_data_formats")  
            client().prepareIndex(INDEX).setSource("val", val).get();  
     * the OpenSearchProject expression list — no Values rel is introduced for it —
        createAndSeedIndex(1);
        );
    /** Values as a Union arm, 2-shard scan. Scan arm gathers across 2 shards via ER;  
    }  
        client().admin().indices().prepareFlush("http_logs").get();  
    }
    }
        }
import org.opensearch.arrow.allocator.ArrowBasePlugin;  
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, shardCount)
    }  
}
        return new SqlPlanRunner(clusterService, executor);
    public void testUnionAll_valuesArm_andScanArm_1shard() {
    @Override
        CreateIndexResponse response = client().admin()
    protected Collection<PluginInfo> additionalNodePlugins() {
    }  
        assertTrue("UNION result must contain the literal 99 from the Values arm", foundLiteral);
import java.util.Collection;
    }
            classpathPlugin(FlightStreamPlugin.class, List.of(ArrowBasePlugin.class.getName())),
                break;
            .indices()
        SqlPlanRunner runner = sqlPlanRunner();  
public class ValuesSqlIT extends OpenSearchIntegTestCase {  
            Version.CURRENT,
            "SELECT val FROM " + INDEX + " UNION ALL SELECT x FROM (VALUES (99)) AS v(x)"
     * a Project that mixes a constant ({@code 1 + 1 AS x}) with an aggregate column  
        SqlPlanRunner runner = sqlPlanRunner();
            .get();  
        ClusterService clusterService = internalCluster().getInstance(ClusterService.class, node);  
        for (Object[] row : rows) {  
     */
import org.opensearch.parquet.ParquetOnlyDataFormatPlugin;
    }
            .prepareCreate("http_logs")  
    private void createAndSeedHttpLogsIndex(int shardCount) {  
     * Literal-projection + aggregate + filter against {@code http_logs}: confirms
            .indices()
    private SqlPlanRunner sqlPlanRunner() {
        return Settings.builder()  
    public void testLiteralWithAggregateAndFilter_1shard() {  
        List<Object[]> rows = runner.executeSql("SELECT 1 + 1 AS x, SUM(size) FROM http_logs WHERE verb = 'GET'");  
            "NA",  
     * Source-less {@code SELECT 1 + 1, 'x'} — Calcite lowers this to a single-row
import org.opensearch.index.engine.dataformat.stub.MockCommitterEnginePlugin;
     * ({@code SUM(size)}) survives the planner end-to-end. The constant folds into
    public void testInnerJoin_scanWithValuesArm_1shard() {  
        client().admin().indices().prepareRefresh(INDEX).get();
 */
    private void assertInnerJoinScanWithValues() {
            "classpath plugin",
        return new PluginInfo(  
     *  Values arm runs as LOCAL_COMPUTE on coord. */
    public void testValues_literalRow() {
        Settings indexSettings = Settings.builder()  
    private static final int TOTAL_DOCS = 6;  
    }
    }  
            .build();
        createAndSeedIndex(2);
        SqlPlanRunner runner = sqlPlanRunner();  
    }
            int val = (i % 3) + 1;
        assertEquals("JOIN over Values must yield 4 rows (matches: 1,1,2,2)", 4, rows.size());
            client().prepareIndex("http_logs").setSource("verb", docs[i][0], "size", docs[i][1]).get();  
            .put("index.composite.primary_data_format", "parquet")  
 * wiring beyond the existing MultiInputExchangeSink machinery.
            .build();
import org.opensearch.Version;
import org.opensearch.composite.CompositeDataFormatPlugin;  
        List<Object[]> rows = runner.executeSql(
 * multi-input parent (Union / Join) alongside a shard-side scan arm without extra  
     * DataFusion's local session with no childInputs. Exercises the pure
            null,
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.SUITE, numDataNodes = 2, numClientNodes = 0)
 */  
        // Seeded rows: GET/100, POST/50, GET/200, GET/300 → GET sum = 600
            .get();
import org.opensearch.plugins.Plugin;  
        }
        createAndSeedIndex(2);  
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)  
            .prepareCreate(INDEX)
    @Override
import java.util.ArrayList;
            .putList("index.composite.secondary_data_formats")
        }
    // ── Test infrastructure ─────────────────────────────────────────────────
            .put(FeatureFlags.STREAM_TRANSPORT, true)  
        assertEquals("matched rows must be [1,1,2,2]", List.of(1, 1, 2, 2), vals);
     * <p>1-shard only for now — the multi-shard PARTIAL→FINAL path hits a separate  
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
        List<Integer> vals = new ArrayList<>();
    public void testUnionAll_valuesArm_andScanArm_2shard() {
    protected Collection<Class<? extends Plugin>> nodePlugins() {  
 * End-to-end IT for {@code LogicalValues} composed with set/join operators. The Values
        assertEquals("x", rows.getFirst()[1]);
     * coordinator-only execution path.  
        CreateIndexResponse response = client().admin()  
            false  
