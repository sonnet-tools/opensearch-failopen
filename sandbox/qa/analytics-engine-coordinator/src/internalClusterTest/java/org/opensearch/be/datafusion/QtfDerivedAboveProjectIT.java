    public void testQtfFires_outerProjectRunsDerivedUpperOnStage3() throws Exception {
        ClusterService clusterService = internalCluster().getInstance(ClusterService.class, node);  
            withRewriterLogLevel("DEBUG", () -> {
        );
        assertTrue("index creation must be acknowledged", response.isAcknowledged());  
import org.opensearch.cluster.metadata.IndexMetadata;
 */
                .setSource(
    }
 *       ({@code UPPER(URL)}). If Stage 3 weren't separated and run as Substrait by  
import java.util.Collections;  
        return List.of(  
            .put(FeatureFlags.STREAM_TRANSPORT, true)  
package org.opensearch.be.datafusion;
                    REWRITER_LOGGER_NAME,
    private static PluginInfo classpathPlugin(Class<? extends Plugin> pluginClass, List<String> extendedPlugins) {
            .build();
import org.opensearch.arrow.allocator.ArrowBasePlugin;
import org.opensearch.cluster.service.ClusterService;  
 * <ol>  
 *   <li><b>Engagement</b> — the rewriter's "[QTF] fired" debug line is captured by a
        return List.of(ArrowBasePlugin.class, CompositeDataFormatPlugin.class, MockCommitterEnginePlugin.class);
            .setSettings(indexSettings)  
 * </ol>
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
import org.opensearch.index.engine.dataformat.stub.MockCommitterEnginePlugin;
            .indices()
                    // EventDate is returned by the executor as a formatted string
            .cluster()
    private static final String REWRITER_LOGGER_NAME = "org.opensearch.analytics.planner.rules.OpenSearchLateMaterializationRewriter";  
import java.util.Locale;
     */
    /**  
            "1.8",
    // ── Infrastructure ──────────────────────────────────────────────────────
import org.opensearch.analytics.exec.DefaultPlanExecutor;
import org.opensearch.Version;
import org.opensearch.analytics.sql.SqlPlanRunner;
                    assertEquals("row " + i + " EventDate mismatch", expectedDate, row[1]);
                    "QTF rewriter must fire for multi-shard sort+limit with above-anchor fetch-only cols",  
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
 * COORDINATOR_REDUCE actually runs derived expressions over the LM-stitched output.  
 * The OpenSearch Contributors require contributions made to  
                )
        ensureGreen(INDEX);
import org.opensearch.test.MockLogAppender;
    }  
            null,
import org.opensearch.analytics.AnalyticsPlugin;  
    @Override
    }  
    }
import org.opensearch.arrow.flight.transport.FlightStreamPlugin;  
            classpathPlugin(ParquetOnlyDataFormatPlugin.class, Collections.emptyList()),  
            false  
        return new SqlPlanRunner(clusterService, executor);
            .prepareUpdateSettings()  
    private interface ThrowingRunnable {  
                    "https://example.com/page" + i,  
        client().admin()
            .setTransientSettings(Settings.builder().put("logger." + REWRITER_LOGGER_NAME, level).build())
     * an index_filter() to attach against — the default {@code datafusion.indexed.query_strategy=indexed}
    private static final String INDEX = "qtf_derived_idx";
                    Level.DEBUG,
     * hot path; tests that need to observe engagement raise it just for their duration.
 */  
    @Override
                    String expectedUrl = "HTTPS://EXAMPLE.COM/PAGE" + i;
/*  
 *
                }  
    private SqlPlanRunner sqlPlanRunner() {
            .put(super.nodeSettings(nodeOrdinal))
            Version.CURRENT,
                    i + 1
                .prepareUpdateSettings()
 * End-to-end IT for QTF (late materialization) Stage 3 — verifies the post-LM
            "NA",  
        client().admin().indices().prepareRefresh(INDEX).get();
public class QtfDerivedAboveProjectIT extends OpenSearchIntegTestCase {  
 * this file be licensed under the Apache-2.0 license or a
    protected Collection<Class<? extends Plugin>> nodePlugins() {  
        Logger rewriterLogger = LogManager.getLogger(REWRITER_LOGGER_NAME);
import org.opensearch.common.util.FeatureFlags;
 *       DAGBuilder's wrapper-cut, the engine would either error (LM stage doesn't run
            .build();
        // 10 docs spread across two shards. URLs are lowercase so UPPER on Stage 3 is observable.  
        return new PluginInfo(  
import org.opensearch.plugins.PluginInfo;  
     * rejects plans with no filter.  
                    String expectedDate = String.format(Locale.ROOT, "2026-05-%02d 00:00:00", i + 1);
    }
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, shardCount)
 *   <li><b>Stage 3 compute</b> — the SELECT carries a derived expression
                .get();  
import org.opensearch.common.settings.Settings;
    }
        } finally {
        );
    /**
 *       LM-stitched VSR was fed into Stage 3 and the post-LM Project executed.</li>  
                    "2026-05-" + String.format(Locale.ROOT, "%02d", i + 1),
            appender.assertAllExpectationsMatched();  
    }
     * production operators would use), runs the body, and resets the override afterward.
                new MockLogAppender.SeenEventExpectation(
                    assertEquals("row " + i + " UPPER(URL) mismatch", expectedUrl, row[0]);  
    }  
    @Override
        String node = internalCluster().getNodeNames()[0];
            body.run();
 *
import java.util.List;
    protected Settings nodeSettings(int nodeOrdinal) {
     */
            .put("index.pluggable.dataformat", "composite")
        try {  
        DefaultPlanExecutor executor = internalCluster().getInstance(DefaultPlanExecutor.class, node);
            .setMapping("URL", "type=keyword,index=false", "EventDate", "type=date", "CounterID", "type=integer")
        return Settings.builder()  
                List<Object[]> rows = runner.executeSql(  
     * uppercased URL.
     * Flips the QTF rewriter's logger to {@code level} via cluster settings (the same path
            classpathPlugin(DataFusionPlugin.class, List.of(AnalyticsPlugin.class.getName()))
 *       off by default in production).</li>
 * SPDX-License-Identifier: Apache-2.0
        void run() throws Exception;
                    "CounterID",  
import org.apache.logging.log4j.Logger;  
            client().admin()  
        createAndSeedIndex(2);  
            appender.addExpectation(
                    Object[] row = rows.get(i);
            );
                    "*[QTF] fired*"  
        for (int i = 0; i < 10; i++) {
            pluginClass.getName(),  
                .get();
                    "URL",
                );
 *       Substrait) or return raw URLs. Asserting on uppercased values proves the
     *  
        // CounterID is monotonically increasing so `WHERE CounterID > 0` matches all rows.
                for (int i = 0; i < 5; i++) {  
     * The rewriter's "fired" log line is intentionally DEBUG so prod stays log-quiet on the  
     * must run on the post-LM Stage 3. Verifies engagement via log capture and result via
        }
            client().prepareIndex(INDEX)  
        try (MockLogAppender appender = MockLogAppender.createForLoggers(rewriterLogger)) {  
    private void withRewriterLogLevel(String level, ThrowingRunnable body) throws Exception {  
import org.opensearch.test.OpenSearchIntegTestCase;
import org.opensearch.plugins.Plugin;
                    // (yyyy-MM-dd HH:mm:ss, midnight on the seeded date).  
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.SUITE, numDataNodes = 2, numClientNodes = 0)
import org.opensearch.composite.CompositeDataFormatPlugin;  
            .put(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG, true)
    }
        client().admin().indices().prepareFlush(INDEX).get();  
/**
import java.util.Collection;
                    "EventDate",
     * SELECT UPPER(URL), EventDate FROM qtf_derived_idx WHERE CounterID > 0 ORDER BY EventDate LIMIT 5
import org.opensearch.parquet.ParquetOnlyDataFormatPlugin;  
import org.opensearch.action.admin.indices.create.CreateIndexResponse;
            .putList("index.composite.secondary_data_formats")  
 *       flipped to DEBUG via cluster settings only for the duration of the test (it stays  
            .put("index.pluggable.dataformat.enabled", true)  
            .get();
                )
                    "SELECT UPPER(URL) AS u, EventDate FROM " + INDEX + " WHERE CounterID > 0 ORDER BY EventDate LIMIT 5"
        }
    private void createAndSeedIndex(int shardCount) {
            pluginClass.getName(),
            extendedPlugins,
                // 10 seeded docs with EventDate 2026-05-01..2026-05-10; ASC LIMIT 5 → first 5.
        Settings indexSettings = Settings.builder()  
            .put("index.composite.primary_data_format", "parquet")
            "classpath plugin",
            classpathPlugin(AnalyticsPlugin.class, Collections.emptyList()),
            .get();
            .prepareCreate(INDEX)
    @FunctionalInterface
 * @opensearch.internal  
 *       {@link MockLogAppender}, proving QTF actually triggered. The rewriter logger is
                .setTransientSettings(Settings.builder().putNull("logger." + REWRITER_LOGGER_NAME).build())  
            });
     * — multi-shard so QTF fires, outer Project carries a non-passthrough RexCall (UPPER) that  
     * <p>The {@code WHERE CounterID > 0} predicate is here to give the indexed query strategy
            classpathPlugin(FlightStreamPlugin.class, List.of(ArrowBasePlugin.class.getName())),
                SqlPlanRunner runner = sqlPlanRunner();
    protected Collection<PluginInfo> additionalNodePlugins() {
}
 *
                .cluster()
        CreateIndexResponse response = client().admin()  
        }
 * <p>Two assertions per test:
                assertEquals("LIMIT 5 must yield 5 rows", 5, rows.size());
 * compatible open source license.
