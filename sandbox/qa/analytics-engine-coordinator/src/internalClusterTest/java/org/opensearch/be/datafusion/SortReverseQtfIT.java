                    "*reversing segment iteration*"
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, NUM_SHARDS)
 *   <li><b>Keyword filter + reversal</b> — same fixture, predicate is
                List<Object[]> rows = runner.executeSql(
        assertTrue("index creation must be acknowledged", response.isAcknowledged());
            .put(FeatureFlags.STREAM_TRANSPORT, true)
            body.run();
        for (int batch = 0; batch < FLUSHES; batch++) {
    /**
            assertEquals("row " + i + " category mismatch", "C0", rows.get(i)[2]);
    protected Collection<Class<? extends Plugin>> nodePlugins() {
            .putList("index.sort.field", List.of("ts"))
 * compatible open source license.
     * delegation test is straightforward.
                "type=integer",
            if ("C0".equals(categoryFor(ts))) {
            .indices()
        SqlPlanRunner runner = sqlPlanRunner();
                // a Lucene secondary, a plain `type=keyword` mapping is rejected by the
        // Mirrors QtfDerivedAboveProjectIT: parquet-only with MockCommitter for commit
import org.opensearch.cluster.metadata.IndexMetadata;
        ensureGreen(INDEX);
                .cluster()
}
/**
            .put(super.nodeSettings(nodeOrdinal))
 * </ol>
    }
 * highest-priority segment first. The reversal is an iteration-order flip only — per-segment
        if (!indexExists(INDEX)) {
    }
            .prepareCreate(INDEX)
                "type=keyword,index=false"
        // "newest first" slice, which is exactly what reversal optimizes.
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.SUITE, numDataNodes = 2, numClientNodes = 0)
import org.opensearch.plugins.PluginInfo;
                List<Object[]> rows = runner.executeSql(
            seedDocs();
            appender.addExpectation(
import java.util.Collection;
    }
                    .setSource(
        // index.sort.field=[ts] index.sort.order=[asc] — the catalog-monotonic key. Each
 *   <li><b>Reversal triggers, results correct</b> —
            .prepareUpdateSettings()
    /**
        Logger rustLogger = LogManager.getLogger(RUST_LOGGER_NAME);
 *       "reversing segment iteration" Rust log line via {@link MockLogAppender} on
                        (int) (ts + 1),
            long expectedTs = c0DescByTs.get(i);
                );
                "payload",
     * over the seeded fixture. Mirrors {@link #categoryFor(long)} so the test is robust to
                        "category",
        return List.of(ArrowBasePlugin.class, CompositeDataFormatPlugin.class, MockCommitterEnginePlugin.class);
    protected Settings nodeSettings(int nodeOrdinal) {
    /**
     */
                )
 * this file be licensed under the Apache-2.0 license or a
        // plugin loader can't satisfy (constructor expects DataFusionPlugin) and breaks
            .putList("index.composite.secondary_data_formats")
        assertEquals("LIMIT 4 must yield 4 rows", c0DescByTs.size(), rows.size());
                    "*reversing segment iteration*"
    /**
                    Level.DEBUG,
                    assertEquals("row " + i + " payload mismatch", payloadFor(expectedTs), rows.get(i)[1]);
            .put("index.pluggable.dataformat", "composite")
     * of all rows and exercises a real cross-segment filter.
            .get();
 * per-shard segment iteration order so a {@code TopK} above the scan pulls the
            classpathPlugin(AnalyticsPlugin.class, Collections.emptyList()),
    private static final String INDEX = "sort_reverse_qtf_idx";
                }
    private void seedDocs() {
            });
     * round-robin (C0/C1/C2) at ingest time, so {@code category = 'C0'} matches roughly 1/3
                    assertEquals("row " + i + " payload mismatch", payloadFor(expectedTs), rows.get(i)[1]);
     * Round-robin category assignment so each category has roughly TOTAL_DOCS/3 rows
                    assertEquals("row " + i + " ts mismatch", expectedTs, ((Number) rows.get(i)[0]).longValue());
        try (MockLogAppender appender = MockLogAppender.createForLoggers(rustLogger)) {
                for (int i = 0; i < 5; i++) {
        // earliest-ingest to latest-ingest. Query ORDER BY ts DESC then asks for the
            client().admin()
    private SqlPlanRunner sqlPlanRunner() {
            appender.assertAllExpectationsMatched();
                    Level.DEBUG,
            .put("index.composite.primary_data_format", "parquet")
            .build();
    @Override
import org.opensearch.analytics.exec.DefaultPlanExecutor;
 *       {@code RustLoggerBridge} to prove the optimization fired, and asserts the top-k
            withRustLogLevel("DEBUG", () -> {
    public void testReversalTriggers_orderByTsDescLimit_correctResults() throws Exception {
     * count is 2–4 (depending on doc routing) — within the test contract.
     * <p>Predicate: {@code category = 'C0'}. Each ts is assigned to one of three categories
import org.opensearch.arrow.flight.transport.FlightStreamPlugin;
        }
import org.opensearch.plugins.Plugin;
    /**
                "type=long",
        // segment is internally sorted ASC on ts; the per-shard segment list goes from
        );
        }
            .build();
                    )
import java.util.List;
import org.opensearch.index.engine.dataformat.stub.MockCommitterEnginePlugin;
 *       pushdown path) plus {@code ORDER BY ts DESC LIMIT k}. Verifies that keyword
        Settings indexSettings = Settings.builder()
                out.add(ts);
        try (MockLogAppender appender = MockLogAppender.createForLoggers(rustLogger)) {
 * verified by the Rust unit tests).
import org.opensearch.composite.CompositeDataFormatPlugin;
 * (variance from doc routing). Per-doc {@code ts} is a monotonically increasing epoch-millis
        return Settings.builder()
    @FunctionalInterface
 * advertised by reversal observable in principle (this test asserts correctness; pruning is
                    long expectedTs = i;
    private void withRustLogLevel(String level, ThrowingRunnable body) throws Exception {
package org.opensearch.be.datafusion;
                    "SELECT ts, payload FROM " + INDEX + " WHERE counter > 0 ORDER BY ts DESC LIMIT 5"
import java.util.Collections;
                "ts",
 * <p><b>What this test verifies.</b> When {@code index.sort.field=ts asc} is configured and a
    public void testNoReversal_orderByTsAscLimit_correctResults() throws Exception {
     */
            "SELECT ts, payload, category FROM " + INDEX + " WHERE category = 'C0' ORDER BY ts DESC LIMIT 4"
 *       <em>not</em> fire and results are still correct.</li>
        // every IT in the same JVM.
                "type=keyword,index=false",
            .cluster()
        // we compute the expected list from the same generator so the test mirrors ingest.
            classpathPlugin(FlightStreamPlugin.class, List.of(ArrowBasePlugin.class.getName())),
 * The OpenSearch Contributors require contributions made to
    @Override
import org.opensearch.parquet.ParquetOnlyDataFormatPlugin;
            .setMapping(
    private static final int DOCS_PER_FLUSH = 8;
                // Top 5 by ts DESC = the 5 latest-ingested docs (ts = TOTAL_DOCS-1 .. TOTAL_DOCS-5).
        client().admin()
    // ── Infrastructure ──────────────────────────────────────────────────────
 * <ol>
        return String.format(Locale.ROOT, "p-%04d", ts);
    private void createSortedIndex() {
 *
 *       {@code ORDER BY ts ASC} (matches catalog direction). Asserts the optimization does
import org.opensearch.cluster.service.ClusterService;
        );
    public void testReversal_keywordFilter_correctResults() throws Exception {
    }
 *
 * (query phase → fetch phase) still resolves to the right rows.
            "1.8",
            appender.assertAllExpectationsMatched();
     * Expected top-{@code limit} ts values for {@code WHERE category = 'C0' ORDER BY ts DESC}
                    "SELECT ts, payload FROM " + INDEX + " WHERE counter > 0 ORDER BY ts ASC LIMIT 5"
 *   <li><b>Same direction, no reversal</b> — same fixture, same query but
                for (int i = 0; i < 5; i++) {
        }
            false
import org.opensearch.analytics.sql.SqlPlanRunner;
            .put("index.pluggable.dataformat.enabled", true)
        CreateIndexResponse response = client().admin()
 *
        // classpath auto-loads its AnalyticsSearchBackendPlugin SPI, which the test
 * @opensearch.internal
    }
                        payloadFor(ts),
    private interface ThrowingRunnable {
            null,
import org.opensearch.analytics.AnalyticsPlugin;
/*
            client().admin().indices().prepareRefresh(INDEX).get();
            createSortedIndex();
                assertEquals("LIMIT 5 must yield 5 rows", 5, rows.size());
        Logger rustLogger = LogManager.getLogger(RUST_LOGGER_NAME);
                    .get();
            pluginClass.getName(),
     * Reversal + keyword equality filter. Verifies the QTF row-id round-trip
                }
                long ts = (long) batch * DOCS_PER_FLUSH + i;
import org.opensearch.common.util.FeatureFlags;
        try {
     * Logger name for the Rust → Java log bridge. Anything {@code log_debug!()}'d on the
            .put(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG, true)
                .get();
        return List.of(
    public void setUp() throws Exception {
 * {@code global_base} values are preserved so QTF's {@code __row_id__} round-trip
    }
                );
            extendedPlugins,
 *
        }
    }
            }
 *       rows by {@code ts DESC} are correct.</li>
 * value so segment-local min/max ranges don't overlap, making the page-stats pruning hint
     * each batch. Per-shard each batch becomes one parquet segment, so per-shard segment
     */
 * <p><b>Fixture shape.</b> 2 shards, 3 flushes per shard → 2–4 parquet segments per shard
import org.opensearch.test.OpenSearchIntegTestCase;
     *
import org.opensearch.arrow.allocator.ArrowBasePlugin;
            );
     * spread across all flush batches. Deterministic so expected-row computation in the
                client().prepareIndex(INDEX)
        }
     * Catalog ASC + query ASC ⇒ NO reversal. Negative path: log line must NOT appear, and
     * Seed {@link #TOTAL_DOCS} docs in {@link #FLUSHES} batches with a flush+refresh after
     */
            pluginClass.getName(),
                // DataFusion evaluates string eq on the parquet column directly.
                .prepareUpdateSettings()
    @Override
                        categoryFor(ts)
    private static final int FLUSHES = 3;
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
 *       integer filter + {@code ORDER BY ts DESC LIMIT k}. Captures the
                    assertEquals("row " + i + " ts mismatch", expectedTs, ((Number) rows.get(i)[0]).longValue());
     */
 * (analog of Lucene's {@code shouldUseTimeSeriesDescSortOptimization}).
import org.opensearch.test.MockLogAppender;
            ensureGreen(INDEX);
        return new SqlPlanRunner(clusterService, executor);
 * <p><b>Three scenarios:</b>
                SqlPlanRunner runner = sqlPlanRunner();
        // lifecycle. No Lucene secondary — adding analytics-backend-lucene to the IT
                "counter",
import org.opensearch.action.admin.indices.create.CreateIndexResponse;
            )
            .setSettings(indexSettings)
                        "ts",
                new MockLogAppender.UnseenEventExpectation(
    protected Collection<PluginInfo> additionalNodePlugins() {
                        "payload",
     * (top-k by ts DESC) AND that the Rust reversal log line was emitted.
            withRustLogLevel("DEBUG", () -> {
            "classpath plugin",
            assertEquals("row " + i + " ts mismatch", expectedTs, ((Number) rows.get(i)[0]).longValue());
            Version.CURRENT,
                new MockLogAppender.SeenEventExpectation(
        }
    }
        } finally {
 */
     */
            client().admin().indices().prepareFlush(INDEX).get();
import org.opensearch.common.settings.Settings;
                // composite engine. Equality predicates on this field still work because
    private static final int TOTAL_DOCS = FLUSHES * DOCS_PER_FLUSH;
    private static final String RUST_LOGGER_NAME = "org.opensearch.nativebridge.spi.RustLoggerBridge";
    }
                    long expectedTs = TOTAL_DOCS - 1 - i;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Level;
     * (query → fetch) survives reversal when the predicate is a keyword equality
        }
                        ts,
 * End-to-end integration test for the indexed-parquet sort-aware segment reversal optimization
 * SPDX-License-Identifier: Apache-2.0
        java.util.ArrayList<Long> out = new java.util.ArrayList<>();
    @Override
                .setTransientSettings(Settings.builder().putNull("logger." + RUST_LOGGER_NAME).build())
     * fixture-size changes.
            .get();
        return new PluginInfo(
    }
        String node = internalCluster().getNodeNames()[0];
            .setTransientSettings(Settings.builder().put("logger." + RUST_LOGGER_NAME, level).build())
 *
        void run() throws Exception;
                    RUST_LOGGER_NAME,
     * Catalog ASC + query DESC ⇒ reversal must fire. Asserts the result set is correct
public class SortReverseQtfIT extends OpenSearchIntegTestCase {
    }
                    "indexed_executor must log the segment-iteration reversal",
        return out;
                    RUST_LOGGER_NAME,
        );
import org.opensearch.Version;
            classpathPlugin(ParquetOnlyDataFormatPlugin.class, Collections.emptyList()),
import java.util.Locale;
        DefaultPlanExecutor executor = internalCluster().getInstance(DefaultPlanExecutor.class, node);
    private static final int NUM_SHARDS = 2;
    private static PluginInfo classpathPlugin(Class<? extends Plugin> pluginClass, List<String> extendedPlugins) {
    private static String categoryFor(long ts) {
            for (int i = 0; i < DOCS_PER_FLUSH; i++) {
            .putList("index.sort.order", List.of("asc"))
                    "indexed_executor must NOT reverse when query direction matches catalog",
    }
     * result remains correct (top-k by ts ASC).
            }
        super.setUp();
 *       filtering composes with reversal: row IDs round-trip across the QTF query→fetch
     */
 */
                SqlPlanRunner runner = sqlPlanRunner();
import org.apache.logging.log4j.Logger;
 *       {@code category = 'C0'} (keyword equality evaluated via the parquet predicate
                // index=false avoids requiring Lucene's FULL_TEXT_SEARCH capability — without
        return "C" + (ts % 3);
 *       hop and the returned rows match expected.</li>
            assertEquals("row " + i + " payload mismatch", payloadFor(expectedTs), rows.get(i)[1]);
    /**
            appender.addExpectation(
        ClusterService clusterService = internalCluster().getInstance(ClusterService.class, node);
    /**
        // C0 is at ts ≡ 0 (mod 3). Top 4 by ts DESC of {0,3,6,...,TOTAL_DOCS-3 if divisible}:
     * Rust side surfaces here at {@code DEBUG}.
                        "counter",
    }
            });
 * QTF query asks {@code ORDER BY ts DESC LIMIT k}, the indexed-parquet executor reverses the
                )
        List<Long> c0DescByTs = expectedC0TsDesc(4);
    private static String payloadFor(long ts) {
    }
            classpathPlugin(DataFusionPlugin.class, List.of(AnalyticsPlugin.class.getName()))
    }
            );
                "category",
        List<Object[]> rows = runner.executeSql(
        for (int i = 0; i < rows.size(); i++) {
    }
     * (evaluated through the parquet predicate pushdown path).
                assertEquals("LIMIT 5 must yield 5 rows", 5, rows.size());
            "NA",
    private static List<Long> expectedC0TsDesc(int limit) {
        for (long ts = TOTAL_DOCS - 1; ts >= 0 && out.size() < limit; ts--) {
