            settings.putList("index.sort.order", sortOrders);
public class IndexSortPropagationIT extends OpenSearchIntegTestCase {
package org.opensearch.be.datafusion;
    }
            "NA",
    /**
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.SUITE, numDataNodes = 2, numClientNodes = 0)
        return List.of(
        for (int i = 0; i < DOC_COUNT; i++) {
        // overloads (the (String, Settings, String) form would collide on null arguments).
            classpathPlugin(FlightStreamPlugin.class, List.of(ArrowBasePlugin.class.getName())),
        List<String> aKeys = a.stream().map(IndexSortPropagationIT::rowKey).sorted().toList();
        SqlPlanRunner runner = sqlPlanRunner();
 *   <li>the claim doesn't match the writer's actual physical layout, or</li>
        createAndSeedBothIndices();
 * SPDX-License-Identifier: Apache-2.0
        List<Object[]> sorted = runner.executeSql("SELECT URL, CounterID FROM " + IDX_SORTED + sql);
 * {@code output_ordering} from {@code DataSourceExec} and unlock the
    /**
    }
    protected Collection<PluginInfo> additionalNodePlugins() {
     */
    /**
 * each segment via {@code index.sort.field}. The risk we're guarding against in this IT is a
    }
    private static void assertOrderedRowsEqual(String label, List<Object[]> a, List<Object[]> b) {
     * Filter-only query — no sort, no limit. Must produce the same rows in both indices.
     * Seeds the same {@code DOC_COUNT} docs into the given index. Doc IDs are stable so both
        List<String> bKeys = b.stream().map(IndexSortPropagationIT::rowKey).sorted().toList();
import org.opensearch.parquet.ParquetOnlyDataFormatPlugin;
            .put(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG, true)
 * and threads them into {@link org.opensearch.index.engine.exec.EngineReaderManager} →
        );
        return new PluginInfo(
    private static final int SHARDS = 2;
        createCompositeIndex(IDX_SORTED, List.of("CounterID", "EventDate"), List.of("desc", "desc"));
import org.opensearch.Version;
        String sql = " WHERE CounterID > 0 GROUP BY EventDate ORDER BY COUNT(*) DESC, EventDate ASC LIMIT 5";
     */
    }
 * claim is safe here only because the OpenSearch parquet writer enforces the same sort within
        assertResultsEquivalent("filter-only", unsorted, sorted);
    }
        List<Object[]> unsorted = runner.executeSql(
    /**
            classpathPlugin(AnalyticsPlugin.class, Collections.emptyList()),
        assertEquals("LIMIT 10 must produce 10 rows for unsorted", 10, unsorted.size());
        );
            .put("index.composite.primary_data_format", "parquet")
    /**
            "SELECT URL, EventDate, CounterID FROM " + IDX_SORTED + " WHERE CounterID > 5"
    }
                .get();
     * ORDER BY a non-sort column. The sort declaration must not re-route results based on
 * @opensearch.internal
    @Override
 * {@code repartition_preserving_order} / {@code sort_prefix} optimizations.
            .put(FeatureFlags.STREAM_TRANSPORT, true)
        List<Object[]> sorted = runner.executeSql("SELECT URL, EventDate, CounterID FROM " + IDX_SORTED + sql);
            .indices()
     * Order-sensitive comparison — for queries with a deterministic ORDER BY.
    }
import org.opensearch.analytics.sql.SqlPlanRunner;
        return new SqlPlanRunner(clusterService, executor);
 * configured, one without — and assert that the query results are byte-identical for several
 * query shapes (filter-only, sort+limit, agg+sort). If our patch lies, results would differ.
import org.opensearch.test.OpenSearchIntegTestCase;
 */
     *   - {@code IDX_UNSORTED}: no {@code index.sort.field}.
        assertEquals(label + ": row count mismatch", a.size(), b.size());
     * Agg + sort on aggregate output — the sort declaration must NOT bleed into queries that
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, SHARDS)
            .putList("index.composite.secondary_data_formats");
        client().admin().indices().prepareRefresh(index).get();
    protected Collection<Class<? extends Plugin>> nodePlugins() {
    /**
import org.opensearch.cluster.service.ClusterService;
        String node = internalCluster().getNodeNames()[0];
    private static final int DOC_COUNT = 30;
                    i + 1
        List<Object[]> unsorted = runner.executeSql("SELECT URL, EventDate, CounterID FROM " + IDX_UNSORTED + sql);
 * <ul>
     * Creates two parallel indices ingested with the same docs:
 */
        }
     */
    public void testSortLimit_resultsMatchAcrossSortedAndUnsorted() throws Exception {
    }
    private void createCompositeIndex(String name, List<String> sortFields, List<String> sortOrders) {
     * don't reference the sort columns in their ORDER BY.
import org.opensearch.plugins.Plugin;
 *
    protected Settings nodeSettings(int nodeOrdinal) {
 * <p>Background. The DatafusionPlugin reads {@code index.sort.field} / {@code index.sort.order} off
        assertOrderedRowsEqual("sort+limit", unsorted, sorted);
     * indices end up with identical content.
    /**
     * rows in the same order.
     * matches a prefix of {@code index.sort.field}. Both indices must produce the same top-N
            Version.CURRENT,
 *
        DefaultPlanExecutor executor = internalCluster().getInstance(DefaultPlanExecutor.class, node);
        ensureGreen(name);
        }
        );
    }
        Settings.Builder settings = Settings.builder()
        SqlPlanRunner runner = sqlPlanRunner();
            classpathPlugin(DataFusionPlugin.class, List.of(AnalyticsPlugin.class.getName()))
    }
     * unrelated columns.
     */
}
        return List.of(ArrowBasePlugin.class, CompositeDataFormatPlugin.class, MockCommitterEnginePlugin.class);
     * Sorts both lists by a stable key derived from each row before comparing.
    }
     */
import java.util.Collection;
            pluginClass.getName(),
        ClusterService clusterService = internalCluster().getInstance(ClusterService.class, node);
/**
    }
    @Override
        }
import java.util.Locale;
        StringBuilder sb = new StringBuilder();
 *
        createAndSeedBothIndices();
            .put(super.nodeSettings(nodeOrdinal))
import org.opensearch.analytics.AnalyticsPlugin;
    }
import org.opensearch.common.util.FeatureFlags;
            settings.putList("index.sort.field", sortFields);
                    "2026-05-" + String.format(Locale.ROOT, "%02d", (i % 10) + 1),
        }
     */
/*
        assertEquals(label + ": row count mismatch", a.size(), b.size());
            assertEquals(label + ": row " + i + " mismatch", rowKey(a.get(i)), rowKey(b.get(i)));
                    "URL",
 * this file be licensed under the Apache-2.0 license or a
    private static PluginInfo classpathPlugin(Class<? extends Plugin> pluginClass, List<String> extendedPlugins) {
        String sql = " WHERE CounterID > 0 ORDER BY URL ASC LIMIT 8";
        if (sortFields != null && !sortFields.isEmpty()) {
        seed(IDX_SORTED);
     * Sort+LIMIT — the query that actually exercises {@code sort_prefix} when the ORDER BY
import org.opensearch.analytics.exec.DefaultPlanExecutor;
    // ── Infrastructure ──────────────────────────────────────────────────────
            classpathPlugin(ParquetOnlyDataFormatPlugin.class, Collections.emptyList()),
    /**
 * regression where:
            .build();
        createCompositeIndex(IDX_UNSORTED, /*sortFields*/ null, /*sortOrders*/ null);
    private void seed(String index) {
import org.opensearch.composite.CompositeDataFormatPlugin;
 * propagation in the analytics-backend-datafusion vanilla query path.
    }
                    "https://example.com/page" + i,
        // Local helper renamed to avoid ambiguity with OpenSearchIntegTestCase#createIndex
    private static final String IDX_SORTED = "sort_prop_sorted";
            // Same content for both indices — only physical layout differs because of index.sort.field.
     */
        client().admin().indices().prepareFlush(index).get();
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
import org.opensearch.common.settings.Settings;
        SqlPlanRunner runner = sqlPlanRunner();
import org.opensearch.arrow.flight.transport.FlightStreamPlugin;
            .put("index.pluggable.dataformat.enabled", true)
        for (Object cell : row) {
        List<Object[]> sorted = runner.executeSql(
 * {@link org.opensearch.index.IndexSettings}, ships them across FFM in {@code df_create_reader},
        assertEquals("LIMIT 10 must produce 10 rows for sorted", 10, sorted.size());
        assertOrderedRowsEqual("sort-on-non-sort-column", unsorted, sorted);
    private SqlPlanRunner sqlPlanRunner() {
 * Correctness IT for the {@code index.sort.field} → DataFusion {@code with_file_sort_order(...)}
            .put("index.pluggable.dataformat", "composite")
        SqlPlanRunner runner = sqlPlanRunner();
            .setMapping("URL", "type=keyword,index=false", "EventDate", "type=date", "CounterID", "type=integer")
            pluginClass.getName(),
            null,
        List<Object[]> unsorted = runner.executeSql("SELECT EventDate, COUNT(*) AS c FROM " + IDX_UNSORTED + sql);
 * (Rust-side {@code session_context.rs}) the lists become a
        // For sort+LIMIT, row ORDER must match — not just multiset equality.
import java.util.List;
import org.opensearch.arrow.allocator.ArrowBasePlugin;
            .get();
 * <p>Strategy: ingest the same set of rows into two indices — one with {@code index.sort.field}
 *
     * Multiset comparison — for queries where row order isn't guaranteed (e.g. filter-only).
import org.opensearch.cluster.metadata.IndexMetadata;
    private static final String IDX_UNSORTED = "sort_prop_unsorted";
import java.util.Collections;
        return Settings.builder()
 * {@code ListingOptions::with_file_sort_order(...)} call, which makes DataFusion advertise
        createAndSeedBothIndices();
    public void testAggSortOnAggregate_resultsMatchAcrossSortedAndUnsorted() throws Exception {
        for (int i = 0; i < a.size(); i++) {
            .prepareCreate(name)
        // ORDER BY (CounterID DESC, EventDate DESC) is a prefix of the sort declared on IDX_SORTED.
        assertTrue("index creation must be acknowledged for " + name, response.isAcknowledged());
 * <p>{@code with_file_sort_order} is a <b>per-file claim</b> — DataFusion does not verify it. The
import org.opensearch.action.admin.indices.create.CreateIndexResponse;
     */
                )
    public void testFilterOnly_resultsMatchAcrossSortedAndUnsorted() throws Exception {
            "SELECT URL, EventDate, CounterID FROM " + IDX_UNSORTED + " WHERE CounterID > 5"
        return sb.toString();
        CreateIndexResponse response = client().admin()
    }
        List<Object[]> sorted = runner.executeSql("SELECT EventDate, COUNT(*) AS c FROM " + IDX_SORTED + sql);
        String sql = " WHERE CounterID > 0 ORDER BY CounterID DESC, EventDate DESC LIMIT 10";
        assertOrderedRowsEqual("agg+sort", unsorted, sorted);
 * compatible open source license.
            "classpath plugin",
                    "EventDate",
 * {@code ShardView.sort_fields}/{@code sort_orders}. At session-context build time
import org.opensearch.plugins.PluginInfo;
 *
    private void createAndSeedBothIndices() {
        List<Object[]> unsorted = runner.executeSql("SELECT URL, CounterID FROM " + IDX_UNSORTED + sql);
            .setSettings(settings.build())
        // tiebreaker-stable ORDER BY (count, then date) → ordered comparison is meaningful.
            client().prepareIndex(index)
 * </ul>
        createAndSeedBothIndices();
    @Override
                .setSource(
            // CounterID: 1..DOC_COUNT, EventDate spans 2026-05-01..2026-05-(1 + i mod 10).
 *   <li>the optimizer mis-uses the claim and silently drops or re-orders rows.</li>
 *
        assertEquals(label + ": row content mismatch", aKeys, bKeys);
            "1.8",
     *   - {@code IDX_SORTED}: {@code index.sort.field=[CounterID, EventDate]} both descending.
            false
    private static void assertResultsEquivalent(String label, List<Object[]> a, List<Object[]> b) {
        );
 * The OpenSearch Contributors require contributions made to
        seed(IDX_UNSORTED);
    private static String rowKey(Object[] row) {
import org.opensearch.index.engine.dataformat.stub.MockCommitterEnginePlugin;
            extendedPlugins,
            sb.append(cell == null ? "<null>" : cell.toString()).append('|');
                    "CounterID",
    public void testSortOnNonSortColumn_resultsMatchAcrossSortedAndUnsorted() throws Exception {
