    /**
            "NA",
            // CounterID: 1..DOC_COUNT, EventDate spans 2026-05-01..2026-05-(1 + i mod 10).  
     * Multiset comparison — for queries where row order isn't guaranteed (e.g. filter-only).  
            .put("index.pluggable.dataformat", "composite")  
            settings.putList("index.sort.field", sortFields);
        return Settings.builder()
            classpathPlugin(DataFusionPlugin.class, List.of(AnalyticsPlugin.class.getName()))  
            .get();
import org.opensearch.cluster.service.ClusterService;  
    private static final int SHARDS = 2;
    }
import java.util.Locale;
        for (int i = 0; i < DOC_COUNT; i++) {
            .prepareCreate(name)
     */  
        createAndSeedBothIndices();
        List<Object[]> unsorted = runner.executeSql("SELECT URL, EventDate, CounterID FROM " + IDX_UNSORTED + sql);
            settings.putList("index.sort.order", sortOrders);
import org.opensearch.index.engine.dataformat.stub.MockCommitterEnginePlugin;
            "SELECT URL, EventDate, CounterID FROM " + IDX_SORTED + " WHERE CounterID > 5"
 * <p>Strategy: ingest the same set of rows into two indices — one with {@code index.sort.field}
     */
        String sql = " WHERE CounterID > 0 GROUP BY EventDate ORDER BY COUNT(*) DESC, EventDate ASC LIMIT 5";  
        // Local helper renamed to avoid ambiguity with OpenSearchIntegTestCase#createIndex
    private static final int DOC_COUNT = 30;
import java.util.Collection;
    public void testSortLimit_resultsMatchAcrossSortedAndUnsorted() throws Exception {
        return new PluginInfo(
     */
        }  
        // ORDER BY (CounterID DESC, EventDate DESC) is a prefix of the sort declared on IDX_SORTED.
                    "https://example.com/page" + i,
    /**
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
        );  
        if (sortFields != null && !sortFields.isEmpty()) {  
            sb.append(cell == null ? "<null>" : cell.toString()).append('|');
        SqlPlanRunner runner = sqlPlanRunner();
 * and threads them into {@link org.opensearch.index.engine.exec.EngineReaderManager} →  
        List<String> bKeys = b.stream().map(IndexSortPropagationIT::rowKey).sorted().toList();  
        createCompositeIndex(IDX_SORTED, List.of("CounterID", "EventDate"), List.of("desc", "desc"));
 * each segment via {@code index.sort.field}. The risk we're guarding against in this IT is a  
     */  
        createAndSeedBothIndices();
 *
        return List.of(
    }  
            null,  
 * propagation in the analytics-backend-datafusion vanilla query path.
 *
                .setSource(  
 * {@code ListingOptions::with_file_sort_order(...)} call, which makes DataFusion advertise  
package org.opensearch.be.datafusion;
/*  
    private static final String IDX_SORTED = "sort_prop_sorted";  
import org.opensearch.arrow.flight.transport.FlightStreamPlugin;
            pluginClass.getName(),
            .setMapping("URL", "type=keyword,index=false", "EventDate", "type=date", "CounterID", "type=integer")  
        seed(IDX_UNSORTED);  
            extendedPlugins,
    private static final String IDX_UNSORTED = "sort_prop_unsorted";
        String sql = " WHERE CounterID > 0 ORDER BY CounterID DESC, EventDate DESC LIMIT 10";  
        SqlPlanRunner runner = sqlPlanRunner();
        }  
public class IndexSortPropagationIT extends OpenSearchIntegTestCase {  
        SqlPlanRunner runner = sqlPlanRunner();
            "classpath plugin",
        List<Object[]> sorted = runner.executeSql("SELECT URL, EventDate, CounterID FROM " + IDX_SORTED + sql);
import org.opensearch.plugins.Plugin;  
    }
 * this file be licensed under the Apache-2.0 license or a
        );  
        List<Object[]> unsorted = runner.executeSql("SELECT URL, CounterID FROM " + IDX_UNSORTED + sql);
        return new SqlPlanRunner(clusterService, executor);
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, SHARDS)  
        SqlPlanRunner runner = sqlPlanRunner();  
                    "URL",
        assertTrue("index creation must be acknowledged for " + name, response.isAcknowledged());
 * SPDX-License-Identifier: Apache-2.0
        createAndSeedBothIndices();  
        seed(IDX_SORTED);
    private static PluginInfo classpathPlugin(Class<? extends Plugin> pluginClass, List<String> extendedPlugins) {
     *   - {@code IDX_SORTED}: {@code index.sort.field=[CounterID, EventDate]} both descending.
import org.opensearch.composite.CompositeDataFormatPlugin;  
 * configured, one without — and assert that the query results are byte-identical for several  
            assertEquals(label + ": row " + i + " mismatch", rowKey(a.get(i)), rowKey(b.get(i)));
            .put("index.composite.primary_data_format", "parquet")
    }
     * don't reference the sort columns in their ORDER BY.  
     * indices end up with identical content.
 *  
    /**
    }  
            client().prepareIndex(index)
import org.opensearch.action.admin.indices.create.CreateIndexResponse;
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.SUITE, numDataNodes = 2, numClientNodes = 0)
    protected Settings nodeSettings(int nodeOrdinal) {
    @Override  
    /**  
import org.opensearch.cluster.metadata.IndexMetadata;
                )
 * <ul>  
     * Seeds the same {@code DOC_COUNT} docs into the given index. Doc IDs are stable so both
 * {@link org.opensearch.index.IndexSettings}, ships them across FFM in {@code df_create_reader},
            .put("index.pluggable.dataformat.enabled", true)
        List<Object[]> unsorted = runner.executeSql(
     */  
        List<Object[]> sorted = runner.executeSql(
        Settings.Builder settings = Settings.builder()
    }
}  
 * {@code output_ordering} from {@code DataSourceExec} and unlock the
            .setSettings(settings.build())
import java.util.List;  
        assertEquals(label + ": row count mismatch", a.size(), b.size());
    private static String rowKey(Object[] row) {
            pluginClass.getName(),  
     * unrelated columns.
            "SELECT URL, EventDate, CounterID FROM " + IDX_UNSORTED + " WHERE CounterID > 5"
    /**
    private static void assertResultsEquivalent(String label, List<Object[]> a, List<Object[]> b) {  
            classpathPlugin(AnalyticsPlugin.class, Collections.emptyList()),
        assertOrderedRowsEqual("sort-on-non-sort-column", unsorted, sorted);
        StringBuilder sb = new StringBuilder();  
        // For sort+LIMIT, row ORDER must match — not just multiset equality.  
     *   - {@code IDX_UNSORTED}: no {@code index.sort.field}.
            .put(FeatureFlags.STREAM_TRANSPORT, true)
     * ORDER BY a non-sort column. The sort declaration must not re-route results based on  
                    "EventDate",  
     * Filter-only query — no sort, no limit. Must produce the same rows in both indices.
        DefaultPlanExecutor executor = internalCluster().getInstance(DefaultPlanExecutor.class, node);
        return sb.toString();
     */
                    "CounterID",
    @Override  
        assertOrderedRowsEqual("agg+sort", unsorted, sorted);
        ensureGreen(name);  
        for (Object cell : row) {
        }  
 * claim is safe here only because the OpenSearch parquet writer enforces the same sort within
            .put(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG, true)
 *
            .put(super.nodeSettings(nodeOrdinal))  
            Version.CURRENT,  
 * </ul>  
        assertEquals("LIMIT 10 must produce 10 rows for unsorted", 10, unsorted.size());
        CreateIndexResponse response = client().admin()
        List<Object[]> unsorted = runner.executeSql("SELECT EventDate, COUNT(*) AS c FROM " + IDX_UNSORTED + sql);
/**  
import org.opensearch.parquet.ParquetOnlyDataFormatPlugin;
    private void createAndSeedBothIndices() {
        client().admin().indices().prepareRefresh(index).get();
        );  
import org.opensearch.plugins.PluginInfo;
 * Correctness IT for the {@code index.sort.field} → DataFusion {@code with_file_sort_order(...)}
        ClusterService clusterService = internalCluster().getInstance(ClusterService.class, node);  
    private static void assertOrderedRowsEqual(String label, List<Object[]> a, List<Object[]> b) {
    // ── Infrastructure ──────────────────────────────────────────────────────
    /**
 * {@code ShardView.sort_fields}/{@code sort_orders}. At session-context build time
        List<String> aKeys = a.stream().map(IndexSortPropagationIT::rowKey).sorted().toList();
    public void testSortOnNonSortColumn_resultsMatchAcrossSortedAndUnsorted() throws Exception {  
                    "2026-05-" + String.format(Locale.ROOT, "%02d", (i % 10) + 1),
        assertEquals(label + ": row count mismatch", a.size(), b.size());
        String sql = " WHERE CounterID > 0 ORDER BY URL ASC LIMIT 8";
 * regression where:
        createAndSeedBothIndices();
import org.opensearch.arrow.allocator.ArrowBasePlugin;  
    }
    public void testAggSortOnAggregate_resultsMatchAcrossSortedAndUnsorted() throws Exception {
     */  
     * Order-sensitive comparison — for queries with a deterministic ORDER BY.
import org.opensearch.analytics.sql.SqlPlanRunner;
     * Agg + sort on aggregate output — the sort declaration must NOT bleed into queries that
    /**
import org.opensearch.common.util.FeatureFlags;
        assertEquals("LIMIT 10 must produce 10 rows for sorted", 10, sorted.size());
    private SqlPlanRunner sqlPlanRunner() {
 * compatible open source license.
    @Override
    /**  
 * {@code repartition_preserving_order} / {@code sort_prefix} optimizations.
 */  
 * The OpenSearch Contributors require contributions made to  
        // overloads (the (String, Settings, String) form would collide on null arguments).  
    private void createCompositeIndex(String name, List<String> sortFields, List<String> sortOrders) {
    }  
        client().admin().indices().prepareFlush(index).get();
        String node = internalCluster().getNodeNames()[0];
            classpathPlugin(ParquetOnlyDataFormatPlugin.class, Collections.emptyList()),
import org.opensearch.analytics.AnalyticsPlugin;  
    }
 *  
 */
import org.opensearch.Version;
            false
import org.opensearch.test.OpenSearchIntegTestCase;
 *   <li>the claim doesn't match the writer's actual physical layout, or</li>
            .indices()  
    }  
    }
    }  
        for (int i = 0; i < a.size(); i++) {  
 *
    }
     * matches a prefix of {@code index.sort.field}. Both indices must produce the same top-N
    }
        assertResultsEquivalent("filter-only", unsorted, sorted);
import org.opensearch.analytics.exec.DefaultPlanExecutor;
        createCompositeIndex(IDX_UNSORTED, /*sortFields*/ null, /*sortOrders*/ null);
    public void testFilterOnly_resultsMatchAcrossSortedAndUnsorted() throws Exception {  
        return List.of(ArrowBasePlugin.class, CompositeDataFormatPlugin.class, MockCommitterEnginePlugin.class);  
        // tiebreaker-stable ORDER BY (count, then date) → ordered comparison is meaningful.
import org.opensearch.common.settings.Settings;
        assertEquals(label + ": row content mismatch", aKeys, bKeys);
            "1.8",
        );
     */
     * Creates two parallel indices ingested with the same docs:  
     * rows in the same order.
        List<Object[]> sorted = runner.executeSql("SELECT URL, CounterID FROM " + IDX_SORTED + sql);  
    protected Collection<Class<? extends Plugin>> nodePlugins() {
 * (Rust-side {@code session_context.rs}) the lists become a
                .get();
 * @opensearch.internal  
 * <p>Background. The DatafusionPlugin reads {@code index.sort.field} / {@code index.sort.order} off
        List<Object[]> sorted = runner.executeSql("SELECT EventDate, COUNT(*) AS c FROM " + IDX_SORTED + sql);
     * Sort+LIMIT — the query that actually exercises {@code sort_prefix} when the ORDER BY  
    }  
import java.util.Collections;
            .build();  
 * query shapes (filter-only, sort+limit, agg+sort). If our patch lies, results would differ.
            classpathPlugin(FlightStreamPlugin.class, List.of(ArrowBasePlugin.class.getName())),  
     * Sorts both lists by a stable key derived from each row before comparing.
        }
    protected Collection<PluginInfo> additionalNodePlugins() {
 * <p>{@code with_file_sort_order} is a <b>per-file claim</b> — DataFusion does not verify it. The
 *   <li>the optimizer mis-uses the claim and silently drops or re-orders rows.</li>
                    i + 1  
        assertOrderedRowsEqual("sort+limit", unsorted, sorted);
            .putList("index.composite.secondary_data_formats");
    private void seed(String index) {
            // Same content for both indices — only physical layout differs because of index.sort.field.
