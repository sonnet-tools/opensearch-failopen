            .setMapping("URL", "type=keyword,index=false", "EventDate", "type=date", "CounterID", "type=integer")
                    assertEquals("row " + i + " EventDate mismatch", expectedDate, row[1]);
import org.opensearch.common.settings.Settings;
            extendedPlugins,
import org.opensearch.arrow.flight.transport.FlightStreamPlugin;
        CreateIndexResponse response = client().admin()
            "classpath plugin",
            body.run();
        void run() throws Exception;
import org.opensearch.analytics.AnalyticsPlugin;
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
 *
 * </ol>
            .putList("index.composite.secondary_data_formats")
    protected Collection<PluginInfo> additionalNodePlugins() {
            .put(super.nodeSettings(nodeOrdinal))
                .setTransientSettings(Settings.builder().putNull("logger." + REWRITER_LOGGER_NAME).build())
 * this file be licensed under the Apache-2.0 license or a
                new MockLogAppender.SeenEventExpectation(
            .put("index.pluggable.dataformat.enabled", true)
            classpathPlugin(AnalyticsPlugin.class, Collections.emptyList()),
                    Level.DEBUG,
     * production operators would use), runs the body, and resets the override afterward.
            .build();
import org.opensearch.analytics.sql.SqlPlanRunner;
                )
 * End-to-end IT for QTF (late materialization) Stage 3 — verifies the post-LM
/**
                    String expectedUrl = "HTTPS://EXAMPLE.COM/PAGE" + i;
                    Object[] row = rows.get(i);
                    "QTF rewriter must fire for multi-shard sort+limit with above-anchor fetch-only cols",
                    REWRITER_LOGGER_NAME,
            pluginClass.getName(),
import java.util.Collection;
            .cluster()
            );
    private interface ThrowingRunnable {
 * SPDX-License-Identifier: Apache-2.0
            .prepareUpdateSettings()
import org.opensearch.plugins.Plugin;
        // 10 docs spread across two shards. URLs are lowercase so UPPER on Stage 3 is observable.
                assertEquals("LIMIT 5 must yield 5 rows", 5, rows.size());
        Logger rewriterLogger = LogManager.getLogger(REWRITER_LOGGER_NAME);
 *       LM-stitched VSR was fed into Stage 3 and the post-LM Project executed.</li>
    @Override
        return List.of(ArrowBasePlugin.class, CompositeDataFormatPlugin.class, MockCommitterEnginePlugin.class);
        String node = internalCluster().getNodeNames()[0];
    @Override
        );
import org.opensearch.parquet.ParquetOnlyDataFormatPlugin;
    }
/*
     * — multi-shard so QTF fires, outer Project carries a non-passthrough RexCall (UPPER) that
        assertTrue("index creation must be acknowledged", response.isAcknowledged());
                .setSource(
    private static final String REWRITER_LOGGER_NAME = "org.opensearch.analytics.planner.rules.OpenSearchLateMaterializationRewriter";
            classpathPlugin(ParquetOnlyDataFormatPlugin.class, Collections.emptyList()),
        return Settings.builder()
                // 10 seeded docs with EventDate 2026-05-01..2026-05-10; ASC LIMIT 5 → first 5.
                    i + 1
 *       {@link MockLogAppender}, proving QTF actually triggered. The rewriter logger is
import org.opensearch.analytics.exec.DefaultPlanExecutor;
    protected Settings nodeSettings(int nodeOrdinal) {
        try (MockLogAppender appender = MockLogAppender.createForLoggers(rewriterLogger)) {
 *
        );
            client().admin()
        return new SqlPlanRunner(clusterService, executor);
                .get();
        createAndSeedIndex(2);
        client().admin()
import java.util.Collections;
import org.opensearch.composite.CompositeDataFormatPlugin;
            .put(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG, true)
            .build();
            .get();
            null,
        for (int i = 0; i < 10; i++) {
import org.opensearch.test.MockLogAppender;
        }
     * hot path; tests that need to observe engagement raise it just for their duration.
     */
import org.opensearch.plugins.PluginInfo;
     * rejects plans with no filter.
import java.util.List;
 *       off by default in production).</li>
import org.opensearch.action.admin.indices.create.CreateIndexResponse;
        }
import org.opensearch.common.util.FeatureFlags;
    }
        ensureGreen(INDEX);
        client().admin().indices().prepareRefresh(INDEX).get();
    // ── Infrastructure ──────────────────────────────────────────────────────
    }
 */
import org.opensearch.cluster.metadata.IndexMetadata;
                }
                .cluster()
 *       DAGBuilder's wrapper-cut, the engine would either error (LM stage doesn't run
        }
     */
    private static final String INDEX = "qtf_derived_idx";
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, shardCount)
}
     * The rewriter's "fired" log line is intentionally DEBUG so prod stays log-quiet on the
            classpathPlugin(DataFusionPlugin.class, List.of(AnalyticsPlugin.class.getName()))
    @Override
 * <ol>
    @FunctionalInterface
 * <p>Two assertions per test:
                    // EventDate is returned by the executor as a formatted string
    private static PluginInfo classpathPlugin(Class<? extends Plugin> pluginClass, List<String> extendedPlugins) {
import org.apache.logging.log4j.LogManager;
    }
            pluginClass.getName(),
        // CounterID is monotonically increasing so `WHERE CounterID > 0` matches all rows.
                List<Object[]> rows = runner.executeSql(
            "NA",
     * an index_filter() to attach against — the default {@code datafusion.indexed.query_strategy=indexed}
        try {
    /**
    private void withRewriterLogLevel(String level, ThrowingRunnable body) throws Exception {
import org.opensearch.test.OpenSearchIntegTestCase;
 *       ({@code UPPER(URL)}). If Stage 3 weren't separated and run as Substrait by
    }
                .prepareUpdateSettings()
    public void testQtfFires_outerProjectRunsDerivedUpperOnStage3() throws Exception {
import org.apache.logging.log4j.Logger;
    protected Collection<Class<? extends Plugin>> nodePlugins() {
import org.opensearch.arrow.allocator.ArrowBasePlugin;
    /**
import org.apache.logging.log4j.Level;
 * The OpenSearch Contributors require contributions made to
     *
    private void createAndSeedIndex(int shardCount) {
            client().prepareIndex(INDEX)
public class QtfDerivedAboveProjectIT extends OpenSearchIntegTestCase {
                    String expectedDate = String.format(Locale.ROOT, "2026-05-%02d 00:00:00", i + 1);
     * SELECT UPPER(URL), EventDate FROM qtf_derived_idx WHERE CounterID > 0 ORDER BY EventDate LIMIT 5
                    "2026-05-" + String.format(Locale.ROOT, "%02d", i + 1),
                    // (yyyy-MM-dd HH:mm:ss, midnight on the seeded date).
            });
                    "https://example.com/page" + i,
import org.opensearch.cluster.service.ClusterService;
     * Flips the QTF rewriter's logger to {@code level} via cluster settings (the same path
 * compatible open source license.
     * must run on the post-LM Stage 3. Verifies engagement via log capture and result via
    }
 *   <li><b>Stage 3 compute</b> — the SELECT carries a derived expression
     * <p>The {@code WHERE CounterID > 0} predicate is here to give the indexed query strategy
            .setTransientSettings(Settings.builder().put("logger." + REWRITER_LOGGER_NAME, level).build())
                    assertEquals("row " + i + " UPPER(URL) mismatch", expectedUrl, row[0]);
        DefaultPlanExecutor executor = internalCluster().getInstance(DefaultPlanExecutor.class, node);
            false
        client().admin().indices().prepareFlush(INDEX).get();
            .put("index.pluggable.dataformat", "composite")
    }
 *       flipped to DEBUG via cluster settings only for the duration of the test (it stays
                SqlPlanRunner runner = sqlPlanRunner();
    }
        } finally {
                    "URL",
 *   <li><b>Engagement</b> — the rewriter's "[QTF] fired" debug line is captured by a
        Settings indexSettings = Settings.builder()
        ClusterService clusterService = internalCluster().getInstance(ClusterService.class, node);
        return new PluginInfo(
                    "SELECT UPPER(URL) AS u, EventDate FROM " + INDEX + " WHERE CounterID > 0 ORDER BY EventDate LIMIT 5"
            .get();
 */
                    "EventDate",
 *
            "1.8",
            .indices()
                for (int i = 0; i < 5; i++) {
import org.opensearch.Version;
 * @opensearch.internal
 * COORDINATOR_REDUCE actually runs derived expressions over the LM-stitched output.
                );
            appender.addExpectation(
                )
                    "CounterID",
            .put("index.composite.primary_data_format", "parquet")
import org.opensearch.index.engine.dataformat.stub.MockCommitterEnginePlugin;
     * uppercased URL.
            .put(FeatureFlags.STREAM_TRANSPORT, true)
    private SqlPlanRunner sqlPlanRunner() {
        return List.of(
            .prepareCreate(INDEX)
            withRewriterLogLevel("DEBUG", () -> {
            appender.assertAllExpectationsMatched();
            Version.CURRENT,
package org.opensearch.be.datafusion;
            .setSettings(indexSettings)
            classpathPlugin(FlightStreamPlugin.class, List.of(ArrowBasePlugin.class.getName())),
 *       Substrait) or return raw URLs. Asserting on uppercased values proves the
    }
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.SUITE, numDataNodes = 2, numClientNodes = 0)
                .get();
                    "*[QTF] fired*"
import java.util.Locale;
