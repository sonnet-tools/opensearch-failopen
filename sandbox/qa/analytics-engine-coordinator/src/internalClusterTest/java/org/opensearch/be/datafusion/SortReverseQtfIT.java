    }
        );
            .setSettings(indexSettings)
 *
/*  
 *   <li><b>Keyword filter + reversal</b> — same fixture, predicate is
                "ts",  
    @FunctionalInterface  
            );
 * @opensearch.internal
 * (analog of Lucene's {@code shouldUseTimeSeriesDescSortOptimization}).  
                // composite engine. Equality predicates on this field still work because
            withRustLogLevel("DEBUG", () -> {  
    protected Settings nodeSettings(int nodeOrdinal) {
            });  
            pluginClass.getName(),
                        categoryFor(ts)  
            Version.CURRENT,
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, NUM_SHARDS)  
 * SPDX-License-Identifier: Apache-2.0
 * (query phase → fetch phase) still resolves to the right rows.
import org.opensearch.arrow.flight.transport.FlightStreamPlugin;
import org.opensearch.arrow.allocator.ArrowBasePlugin;  
     */
            body.run();
                }
            .get();  
                // DataFusion evaluates string eq on the parquet column directly.  
 * The OpenSearch Contributors require contributions made to  
     * each batch. Per-shard each batch becomes one parquet segment, so per-shard segment
            "classpath plugin",
            false  
    private static final int DOCS_PER_FLUSH = 8;
    /**  
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.SUITE, numDataNodes = 2, numClientNodes = 0)
                    assertEquals("row " + i + " payload mismatch", payloadFor(expectedTs), rows.get(i)[1]);
            appender.addExpectation(  
                    "SELECT ts, payload FROM " + INDEX + " WHERE counter > 0 ORDER BY ts DESC LIMIT 5"  
 *
        // segment is internally sorted ASC on ts; the per-shard segment list goes from
    private static PluginInfo classpathPlugin(Class<? extends Plugin> pluginClass, List<String> extendedPlugins) {
            .get();
    /**
        );
import java.util.Collection;
                    assertEquals("row " + i + " ts mismatch", expectedTs, ((Number) rows.get(i)[0]).longValue());  
            null,
    @Override
            .put(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG, true)
 *       rows by {@code ts DESC} are correct.</li>  
                assertEquals("LIMIT 5 must yield 5 rows", 5, rows.size());  
                );
import org.opensearch.common.settings.Settings;
                    RUST_LOGGER_NAME,  
            for (int i = 0; i < DOCS_PER_FLUSH; i++) {
        DefaultPlanExecutor executor = internalCluster().getInstance(DefaultPlanExecutor.class, node);
        // every IT in the same JVM.  
    }
    public void testReversal_keywordFilter_correctResults() throws Exception {  
                        payloadFor(ts),
                }
import java.util.List;
 *       integer filter + {@code ORDER BY ts DESC LIMIT k}. Captures the  
            appender.assertAllExpectationsMatched();
                    long expectedTs = i;
import org.opensearch.index.engine.dataformat.stub.MockCommitterEnginePlugin;
        return List.of(  
 *       {@code category = 'C0'} (keyword equality evaluated via the parquet predicate
        java.util.ArrayList<Long> out = new java.util.ArrayList<>();
    }  
    private static List<Long> expectedC0TsDesc(int limit) {  
     * round-robin (C0/C1/C2) at ingest time, so {@code category = 'C0'} matches roughly 1/3  
import org.opensearch.analytics.AnalyticsPlugin;  
                "category",
import org.opensearch.cluster.metadata.IndexMetadata;
        Logger rustLogger = LogManager.getLogger(RUST_LOGGER_NAME);
        CreateIndexResponse response = client().admin()
     * over the seeded fixture. Mirrors {@link #categoryFor(long)} so the test is robust to  
        return String.format(Locale.ROOT, "p-%04d", ts);
            assertEquals("row " + i + " payload mismatch", payloadFor(expectedTs), rows.get(i)[1]);  
            .put("index.composite.primary_data_format", "parquet")
     * Expected top-{@code limit} ts values for {@code WHERE category = 'C0' ORDER BY ts DESC}
        Logger rustLogger = LogManager.getLogger(RUST_LOGGER_NAME);
     */  
     * Rust side surfaces here at {@code DEBUG}.
 * (variance from doc routing). Per-doc {@code ts} is a monotonically increasing epoch-millis  
                    "indexed_executor must log the segment-iteration reversal",
import org.opensearch.test.MockLogAppender;
    }  
    /**
                long ts = (long) batch * DOCS_PER_FLUSH + i;
                "payload",
            .put(super.nodeSettings(nodeOrdinal))
        }  
 *       pushdown path) plus {@code ORDER BY ts DESC LIMIT k}. Verifies that keyword  
        return List.of(ArrowBasePlugin.class, CompositeDataFormatPlugin.class, MockCommitterEnginePlugin.class);
                "type=keyword,index=false"
                new MockLogAppender.UnseenEventExpectation(
            ensureGreen(INDEX);
            .cluster()  
    /**  
                        "payload",  
    }  
                "type=long",
                )
            assertEquals("row " + i + " ts mismatch", expectedTs, ((Number) rows.get(i)[0]).longValue());
            withRustLogLevel("DEBUG", () -> {
            extendedPlugins,
            classpathPlugin(DataFusionPlugin.class, List.of(AnalyticsPlugin.class.getName()))
 * QTF query asks {@code ORDER BY ts DESC LIMIT k}, the indexed-parquet executor reverses the  
import org.opensearch.plugins.Plugin;  
import org.opensearch.analytics.exec.DefaultPlanExecutor;
    private void withRustLogLevel(String level, ThrowingRunnable body) throws Exception {
                SqlPlanRunner runner = sqlPlanRunner();
 *   <li><b>Reversal triggers, results correct</b> —
                "counter",
    }
     */
    }
        SqlPlanRunner runner = sqlPlanRunner();
                    "indexed_executor must NOT reverse when query direction matches catalog",  
            }
            .prepareCreate(INDEX)  
     * delegation test is straightforward.
import org.opensearch.cluster.service.ClusterService;  
        // earliest-ingest to latest-ingest. Query ORDER BY ts DESC then asks for the  
        for (int i = 0; i < rows.size(); i++) {  
                    "*reversing segment iteration*"  
    }
        }
        } finally {  
            });  
                    .get();
        for (int batch = 0; batch < FLUSHES; batch++) {  
                .prepareUpdateSettings()  
            assertEquals("row " + i + " category mismatch", "C0", rows.get(i)[2]);
    private static final String RUST_LOGGER_NAME = "org.opensearch.nativebridge.spi.RustLoggerBridge";
        return new PluginInfo(  
        // Mirrors QtfDerivedAboveProjectIT: parquet-only with MockCommitter for commit
    public void testNoReversal_orderByTsAscLimit_correctResults() throws Exception {
        List<Long> c0DescByTs = expectedC0TsDesc(4);
import org.opensearch.plugins.PluginInfo;
    private void seedDocs() {
     */
    private static String payloadFor(long ts) {  
     * Seed {@link #TOTAL_DOCS} docs in {@link #FLUSHES} batches with a flush+refresh after
        assertTrue("index creation must be acknowledged", response.isAcknowledged());
            classpathPlugin(AnalyticsPlugin.class, Collections.emptyList()),
        Settings indexSettings = Settings.builder()
        ensureGreen(INDEX);  
                    long expectedTs = TOTAL_DOCS - 1 - i;
import org.opensearch.parquet.ParquetOnlyDataFormatPlugin;
        }
                List<Object[]> rows = runner.executeSql(
 * </ol>  
                    Level.DEBUG,
        // plugin loader can't satisfy (constructor expects DataFusionPlugin) and breaks
                out.add(ts);
            pluginClass.getName(),  
            .prepareUpdateSettings()
            createSortedIndex();
            .build();
                        "counter",
    @Override
/**
            .setTransientSettings(Settings.builder().put("logger." + RUST_LOGGER_NAME, level).build())
     * fixture-size changes.
        // lifecycle. No Lucene secondary — adding analytics-backend-lucene to the IT  
        String node = internalCluster().getNodeNames()[0];  
public class SortReverseQtfIT extends OpenSearchIntegTestCase {
    private void createSortedIndex() {  
                assertEquals("LIMIT 5 must yield 5 rows", 5, rows.size());  
            if ("C0".equals(categoryFor(ts))) {  
        client().admin()
 * compatible open source license.
     * of all rows and exercises a real cross-segment filter.
 */  
}  
    }
    private static final int NUM_SHARDS = 2;
     */  
                List<Object[]> rows = runner.executeSql(  
        if (!indexExists(INDEX)) {
        super.setUp();  
 *       "reversing segment iteration" Rust log line via {@link MockLogAppender} on
 * <ol>
            client().admin().indices().prepareFlush(INDEX).get();
 * advertised by reversal observable in principle (this test asserts correctness; pruning is
                SqlPlanRunner runner = sqlPlanRunner();
package org.opensearch.be.datafusion;
 *       {@code RustLoggerBridge} to prove the optimization fired, and asserts the top-k
import java.util.Collections;  
            "SELECT ts, payload, category FROM " + INDEX + " WHERE category = 'C0' ORDER BY ts DESC LIMIT 4"  
    }
 *
            .put("index.pluggable.dataformat", "composite")  
            .indices()
            .setMapping(
                    assertEquals("row " + i + " payload mismatch", payloadFor(expectedTs), rows.get(i)[1]);
            classpathPlugin(ParquetOnlyDataFormatPlugin.class, Collections.emptyList()),  
import org.opensearch.Version;
    // ── Infrastructure ──────────────────────────────────────────────────────
    }
    /**  
                );
import org.apache.logging.log4j.Level;
 * <p><b>What this test verifies.</b> When {@code index.sort.field=ts asc} is configured and a
 * verified by the Rust unit tests).  
                )  
            "1.8",
import org.apache.logging.log4j.Logger;  
        try (MockLogAppender appender = MockLogAppender.createForLoggers(rustLogger)) {  
            client().admin()
                    RUST_LOGGER_NAME,
        try (MockLogAppender appender = MockLogAppender.createForLoggers(rustLogger)) {
        // we compute the expected list from the same generator so the test mirrors ingest.  
 * End-to-end integration test for the indexed-parquet sort-aware segment reversal optimization
    /**  
     * Logger name for the Rust → Java log bridge. Anything {@code log_debug!()}'d on the
     */
 * <p><b>Three scenarios:</b>  
                    )
                // Top 5 by ts DESC = the 5 latest-ingested docs (ts = TOTAL_DOCS-1 .. TOTAL_DOCS-5).
        // C0 is at ts ≡ 0 (mod 3). Top 4 by ts DESC of {0,3,6,...,TOTAL_DOCS-3 if divisible}:
    }  
            seedDocs();  
            .putList("index.composite.secondary_data_formats")
     */
     *
                "type=keyword,index=false",
    }
     * Round-robin category assignment so each category has roughly TOTAL_DOCS/3 rows
 *
 *       hop and the returned rows match expected.</li>
import org.opensearch.action.admin.indices.create.CreateIndexResponse;
            );
    @Override
            )  
            }  
            long expectedTs = c0DescByTs.get(i);
            .put("index.pluggable.dataformat.enabled", true)
        return new SqlPlanRunner(clusterService, executor);  
        }  
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
import org.opensearch.test.OpenSearchIntegTestCase;  
    @Override  
import org.apache.logging.log4j.LogManager;
import org.opensearch.composite.CompositeDataFormatPlugin;  
    private SqlPlanRunner sqlPlanRunner() {
                // a Lucene secondary, a plain `type=keyword` mapping is rejected by the
    /**
                        (int) (ts + 1),
        return out;
                .get();
     * Catalog ASC + query ASC ⇒ NO reversal. Negative path: log line must NOT appear, and
    protected Collection<Class<? extends Plugin>> nodePlugins() {
            classpathPlugin(FlightStreamPlugin.class, List.of(ArrowBasePlugin.class.getName())),
            appender.addExpectation(
 * this file be licensed under the Apache-2.0 license or a
 */  
    }
    }
import org.opensearch.analytics.sql.SqlPlanRunner;
        for (long ts = TOTAL_DOCS - 1; ts >= 0 && out.size() < limit; ts--) {
                "type=integer",  
    private static final String INDEX = "sort_reverse_qtf_idx";
            client().admin().indices().prepareRefresh(INDEX).get();
                    assertEquals("row " + i + " ts mismatch", expectedTs, ((Number) rows.get(i)[0]).longValue());  
                for (int i = 0; i < 5; i++) {
     * (top-k by ts DESC) AND that the Rust reversal log line was emitted.
            .putList("index.sort.field", List.of("ts"))  
        // index.sort.field=[ts] index.sort.order=[asc] — the catalog-monotonic key. Each
                    "*reversing segment iteration*"
                new MockLogAppender.SeenEventExpectation(
 * {@code global_base} values are preserved so QTF's {@code __row_id__} round-trip  
    private static final int FLUSHES = 3;  
                // index=false avoids requiring Lucene's FULL_TEXT_SEARCH capability — without  
     * (evaluated through the parquet predicate pushdown path).  
            "NA",  
     * (query → fetch) survives reversal when the predicate is a keyword equality
        return Settings.builder()  
                for (int i = 0; i < 5; i++) {
                    "SELECT ts, payload FROM " + INDEX + " WHERE counter > 0 ORDER BY ts ASC LIMIT 5"
 *       filtering composes with reversal: row IDs round-trip across the QTF query→fetch
                        ts,  
                        "ts",
 * highest-priority segment first. The reversal is an iteration-order flip only — per-segment
        );
                    Level.DEBUG,
        }  
 *   <li><b>Same direction, no reversal</b> — same fixture, same query but
                    .setSource(
 * per-shard segment iteration order so a {@code TopK} above the scan pulls the
            .put(FeatureFlags.STREAM_TRANSPORT, true)  
    private static String categoryFor(long ts) {  
 *
        }  
     * Catalog ASC + query DESC ⇒ reversal must fire. Asserts the result set is correct  
                        "category",
            .build();
                .cluster()
        }  
    public void setUp() throws Exception {
    private interface ThrowingRunnable {
    }
 * <p><b>Fixture shape.</b> 2 shards, 3 flushes per shard → 2–4 parquet segments per shard
     * result remains correct (top-k by ts ASC).
    protected Collection<PluginInfo> additionalNodePlugins() {
                client().prepareIndex(INDEX)  
    private static final int TOTAL_DOCS = FLUSHES * DOCS_PER_FLUSH;
                .setTransientSettings(Settings.builder().putNull("logger." + RUST_LOGGER_NAME).build())
     * <p>Predicate: {@code category = 'C0'}. Each ts is assigned to one of three categories
        ClusterService clusterService = internalCluster().getInstance(ClusterService.class, node);
        // "newest first" slice, which is exactly what reversal optimizes.
    public void testReversalTriggers_orderByTsDescLimit_correctResults() throws Exception {  
import org.opensearch.common.util.FeatureFlags;
     * spread across all flush batches. Deterministic so expected-row computation in the  
            appender.assertAllExpectationsMatched();
 *       <em>not</em> fire and results are still correct.</li>  
 * value so segment-local min/max ranges don't overlap, making the page-stats pruning hint
        try {
            .putList("index.sort.order", List.of("asc"))
 *       {@code ORDER BY ts ASC} (matches catalog direction). Asserts the optimization does
        void run() throws Exception;
        // classpath auto-loads its AnalyticsSearchBackendPlugin SPI, which the test
import java.util.Locale;
        List<Object[]> rows = runner.executeSql(
     * count is 2–4 (depending on doc routing) — within the test contract.  
     * Reversal + keyword equality filter. Verifies the QTF row-id round-trip
        assertEquals("LIMIT 4 must yield 4 rows", c0DescByTs.size(), rows.size());
        return "C" + (ts % 3);
