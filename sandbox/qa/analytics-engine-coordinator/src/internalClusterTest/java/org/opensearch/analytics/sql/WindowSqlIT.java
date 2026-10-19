     * distinctly from DENSE_RANK end-to-end.
     * a gap (rank 4) — the two assertions together prove the functions are distinct.
    protected Collection<PluginInfo> additionalNodePlugins() {
        SqlPlanRunner runner = sqlPlanRunner();  
        for (Object[] row : rows) {
    /** {@code SUM(val) OVER ()} — unframed grand total over a 2-shard index. RexOver in the
    /**  
            .put("index.pluggable.dataformat", "composite")
    public void testCountOver_unframed_2shard() {  
            classpathPlugin(FlightStreamPlugin.class, List.of(ArrowBasePlugin.class.getName())),
            pluginClass.getName(),
import org.opensearch.cluster.metadata.IndexMetadata;
 * This matches the shape PPL's {@code eventstats} produces (clean {@code SUM($0) OVER ()}
 * {@code RexOver} programmatically via Calcite's {@link RelBuilder} — bypassing the SQL
        List<Object[]> rows = runner.executeRel(plan);
        assertEquals("dense rank of val=3 has no gap after the global tie", 3L, (long) valToRank.get(3));  
            classpathPlugin(ParquetOnlyDataFormatPlugin.class, Collections.emptyList()),  
        RexBuilder rex = b.getRexBuilder();
        Map<Integer, Long> valToRank = collectValToRank(rows);  
            int val = (i % 3) + 1;
    private static PluginInfo classpathPlugin(Class<? extends Plugin> pluginClass, List<String> extendedPlugins) {
            false,
        assertEquals("rank of val=3 skips to 4 after the global tie", 4L, (long) valToRank.get(3));
        assertEquals(TOTAL_DOCS, rows.size());
    }  
        assertEquals("dense rank of val=1", 1L, (long) valToRank.get(1));
        RexNode valRef = rex.makeInputRef(b.peek(), 0);
        List<Object[]> rows = runner.executeRel(plan);
import org.apache.calcite.tools.RelBuilder;
    @Override
            assertEquals((long) TOTAL_DOCS, ((Number) row[1]).longValue());
        Settings indexSettings = Settings.builder()  
        assertEquals("dense rank of tied val=2", 2L, (long) valToRank.get(2));  
        assertEquals("one output row per input row", TOTAL_DOCS, rows.size());
    public void testDenseRankOver_orderBy_tie_1shard() {
        }  
        CreateIndexResponse response = client().admin()  
    @Override
import org.apache.calcite.rex.RexWindowBounds;
import com.google.common.collect.ImmutableList;
     *  repeated on every output row. */
    }  
        RexNode over = rex.makeOver(
            false
    private RelNode buildRankProject(SqlPlanRunner runner, org.apache.calcite.sql.SqlAggFunction rankFn) {
}
            classpathPlugin(DataFusionPlugin.class, List.of(AnalyticsPlugin.class.getName()))
            rankFn,  
import org.opensearch.plugins.PluginInfo;  
     * gap. Contrast with {@link #testRankOver_orderBy_tie_1shard}, where the same data yields
        client().admin().indices().prepareFlush(INDEX).get();
 * this file be licensed under the Apache-2.0 license or a
    @Override
            .putList("index.composite.secondary_data_formats")  
     *  against the assembled stream. With val ∈ {1,2,3,1,2,3} the per-row total is 12,  
        return out;  
        b.rename(List.of("val", "rank"));
    /**
    private void createAndSeedTieIndex(int shardCount) {
            false  
import org.opensearch.composite.CompositeDataFormatPlugin;
        Map<Integer, Long> valToRank = collectValToRank(rows);
            false,  
        CreateIndexResponse response = client().admin()  
    private SqlPlanRunner sqlPlanRunner() {
            .put("index.pluggable.dataformat.enabled", true)  
    }
            false
        // Output row order is not guaranteed; assert the val→rank mapping as a set of pairs.  
 * with no nullability wrapper).
 */
 * The OpenSearch Contributors require contributions made to  
        assertEquals("rank of tied val=2 (gap semantics)", 2L, (long) valToRank.get(2));  
            .indices()
        b.scan(INDEX);
        Map<Integer, Long> valToRank = collectValToRank(rows);
            .put(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG, true)
        List<Object[]> rows = runner.executeRel(plan);
            .put("index.pluggable.dataformat.enabled", true)  
import org.apache.calcite.rex.RexFieldCollation;  
            .setSettings(indexSettings)  
     * RexOver cost gate gathered both shards to a single node before the window ran. Were the
     * the dense ranks are {1,2,2,3} — tied rows share rank 2 and the next rank is 3 with no  
        List<Object[]> rows = runner.executeRel(plan);
import org.opensearch.be.datafusion.DataFusionPlugin;  
    private static final String INDEX = "window_idx";  
 * @opensearch.internal
     * SUM-empty-set CASE wrap that the SQL parser would emit — matches the shape PPL's
     */
 */  
        RexNode over = rex.makeOver(
     * {@code RANK() OVER (ORDER BY val)} over a single-shard index seeded with a tie.
     *  Should equal {@link #TOTAL_DOCS}. */
        return new SqlPlanRunner(clusterService, executor);
import org.opensearch.arrow.flight.transport.FlightStreamPlugin;
        assertEquals("dense rank of val=1", 1L, (long) valToRank.get(1));
        RelBuilder b = runner.relBuilder();  
import org.opensearch.common.util.FeatureFlags;
        List<Object[]> rows = runner.executeRel(plan);
     * {@code DENSE_RANK() OVER (ORDER BY val)} over the tied data across <b>2 shards</b>. Mirror
public class WindowSqlIT extends OpenSearchIntegTestCase {
        assertTrue("index creation must be acknowledged", response.isAcknowledged());  
    protected Settings nodeSettings(int nodeOrdinal) {
     */  
            .get();
    }  
        createAndSeedIndex(2);
        assertEquals("rank of val=1", 1L, (long) valToRank.get(1));
 * parser, which wraps {@code SUM(...) OVER ()} in a CASE expression for SQL
        ensureGreen(INDEX);
    }  
            false,  
     * Builds {@code LogicalProject(val=$0, agg=AGG(val) OVER ()) FROM index} via RelBuilder +  
            .put(FeatureFlags.STREAM_TRANSPORT, true)  
package org.opensearch.analytics.sql;
        List<Object[]> rows = runner.executeRel(plan);  
            .put("index.composite.primary_data_format", "parquet")
            agg,
        assertEquals(TIE_DOCS, rows.size());
    public void testSumOver_unframed_2shard() {
            null,
    /**  
import org.opensearch.test.OpenSearchIntegTestCase;
    private static final int[] TIE_VALS = { 1, 2, 2, 3 };
    /**
            ImmutableList.<RexNode>of(),
import org.opensearch.arrow.allocator.ArrowBasePlugin;
     * (likely on different shards) would no longer share a rank. This is the test that proves  
            false,
            Long prior = out.put(val, rank);
            .build();
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
        SqlPlanRunner runner = sqlPlanRunner();
        );
            false,
import org.opensearch.Version;  
import org.apache.calcite.sql.fun.SqlStdOperatorTable;  
 * End-to-end IT for window functions. Constructs {@code LogicalProject} carrying a  
            ImmutableList.of(new RexFieldCollation(valRef, java.util.Collections.emptySet())),  // ORDER BY val  
            .prepareCreate(INDEX)
    }
            .indices()
        for (Object[] row : rows) {  
            .setMapping("val", "type=integer")
        Map<Integer, Long> valToRank = collectValToRank(rows);
        ClusterService clusterService = internalCluster().getInstance(ClusterService.class, node);  
     * With vals {1,2,2,3} the ranks are {1,2,2,4} — the tied rows share rank 2 and the
        for (int val : TIE_VALS) {
            List.of(),  
    }
            List.of(valRef),
        RelBuilder b = runner.relBuilder();  
        assertEquals("rank of val=1", 1L, (long) valToRank.get(1));
            .build();
            false,  
            "1.8",
import java.util.Map;  
     * window evaluated shard-locally, each shard would restart its rank at 1 and the tied 2s
            }
 *  
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.SUITE, numDataNodes = 2, numClientNodes = 0)  
 * SPDX-License-Identifier: Apache-2.0
     * the implicit frame is RANGE UNBOUNDED PRECEDING TO CURRENT ROW (rangeBased=false).  
    /** Folds {@code [val, rank]} output rows into a {@code val → rank} map. The tied rows  
        client().admin().indices().prepareRefresh(INDEX).get();
        b.scan(INDEX);
        assertEquals(TIE_DOCS, rows.size());  
import java.util.List;
            .build();
        RelNode plan = buildRankProject(runner, SqlStdOperatorTable.RANK);
     * Builds {@code LogicalProject(val=$0, rank=RANKFN() OVER (ORDER BY val)) FROM index}. RANK /
import org.opensearch.parquet.ParquetOnlyDataFormatPlugin;
        b.project(b.field(0), over);
     */
 * compatible open source license.
     */  
        b.project(b.field(0), over);  
        assertEquals("dense rank of tied val=2 — one global rank across shards", 2L, (long) valToRank.get(2));
        b.rename(List.of("val", "agg"));
        DefaultPlanExecutor executor = internalCluster().getInstance(DefaultPlanExecutor.class, node);
    public void testDenseRankOver_orderBy_tie_2shard() {  
        return b.build();  
    // ── Infrastructure ──────────────────────────────────────────────────────
import org.apache.calcite.rex.RexNode;
        assertEquals(TIE_DOCS, rows.size());
        assertEquals("rank of val=3 skips to 4 after the tie", 4L, (long) valToRank.get(3));
    /**
        for (Object[] row : rows) {
    }
            .putList("index.composite.secondary_data_formats")  
            RexWindowBounds.CURRENT_ROW,
        SqlPlanRunner runner = sqlPlanRunner();  
import org.opensearch.action.admin.indices.create.CreateIndexResponse;
        createAndSeedTieIndex(2);
    }
            classpathPlugin(AnalyticsPlugin.class, Collections.emptyList()),
    private RelNode buildWindowedProject(SqlPlanRunner runner, org.apache.calcite.sql.SqlAggFunction agg, SqlTypeName outType) {
            b.getTypeFactory().createSqlType(SqlTypeName.BIGINT),
        }
            .put(super.nodeSettings(nodeOrdinal))
        RelNode plan = buildRankProject(runner, SqlStdOperatorTable.DENSE_RANK);  
            "classpath plugin",
import org.opensearch.common.settings.Settings;  
            RexWindowBounds.UNBOUNDED_PRECEDING,
        createAndSeedTieIndex(1);
            if (prior != null) {
     * next rank skips to 4 (gap semantics). This is the case that proves RANK is wired  
        }
        );  
            .put("index.pluggable.dataformat", "composite")
            assertEquals("SUM(val) OVER () must equal grand total 12 on every row", 12L, ((Number) row[1]).longValue());  
            pluginClass.getName(),  
import java.util.Collections;
import org.opensearch.cluster.service.ClusterService;
     * {@code DENSE_RANK() OVER (ORDER BY val)} over the same tied data. With vals {1,2,2,3}
            "NA",  
            true,
        Settings indexSettings = Settings.builder()  
        SqlPlanRunner runner = sqlPlanRunner();
            true,
import org.opensearch.analytics.exec.DefaultPlanExecutor;  
    private static final int TIE_DOCS = TIE_VALS.length;  
        RexNode valRef = rex.makeInputRef(b.peek(), 0);  
        ensureGreen(INDEX);
        RelNode plan = buildRankProject(runner, SqlStdOperatorTable.DENSE_RANK);
/**
            outRelType,  
            .get();
        return new PluginInfo(  
        }
     * of {@link #testRankOver_orderBy_tie_2shard}: the dense ranks stay {1,2,2,3} only if the  
        Map<Integer, Long> out = new java.util.HashMap<>();  
        return Settings.builder()  
            RexWindowBounds.UNBOUNDED_PRECEDING,
    protected Collection<Class<? extends Plugin>> nodePlugins() {  
import org.apache.calcite.sql.type.SqlTypeName;
import org.opensearch.analytics.AnalyticsPlugin;
            client().prepareIndex(INDEX).setSource("val", val).get();
        // vals {1, 2, 2, 3} — the duplicated 2 is the tie that distinguishes RANK from DENSE_RANK.  
    }  
        assertEquals(TIE_DOCS, rows.size());  
            .prepareCreate(INDEX)
        SqlPlanRunner runner = sqlPlanRunner();
            .put("index.composite.primary_data_format", "parquet")
            .setMapping("val", "type=integer")
import org.apache.calcite.rel.RelNode;  
    }
    }
        RexBuilder rex = b.getRexBuilder();
import java.util.Collection;  
        return List.of(  
import org.opensearch.plugins.Plugin;
        createAndSeedIndex(2);  
     * gather assembled a single global stream before ranking.
        }  
    private static Map<Integer, Long> collectValToRank(List<Object[]> rows) {
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, shardCount)
            int val = ((Number) row[0]).intValue();
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, shardCount)
    }
        String node = internalCluster().getNodeNames()[0];
        createAndSeedTieIndex(2);
    /** {@code COUNT(val) OVER ()} — unframed count of non-null vals over a 2-shard index.
     *  Project triggers the cost gate so the planner inserts a gather; the window evaluates
     * own RelNode lowering produces.  
    /**
     */
 * NULL-on-empty-set semantics that DataFusion's physical planner doesn't yet support.  
import org.apache.calcite.rex.RexBuilder;
            List.of(),
        client().admin().indices().prepareFlush(INDEX).get();
    private void createAndSeedIndex(int shardCount) {
        client().admin().indices().prepareRefresh(INDEX).get();
        assertEquals("rank of tied val=2 — one global rank across shards", 2L, (long) valToRank.get(2));  
 *
     * DENSE_RANK take no operands and require an ORDER BY; with an ORDER BY and no explicit frame
     * end-to-end for ranking functions.
    private static final int TOTAL_DOCS = 6;
        for (int i = 0; i < TOTAL_DOCS; i++) {  
        );
                assertEquals("all rows with val=" + val + " must share one rank", (long) prior, rank);  
        return List.of(ArrowBasePlugin.class, CompositeDataFormatPlugin.class, MockCommitterEnginePlugin.class);
import org.apache.calcite.rel.type.RelDataType;
        );
    }
     */
     * {@link RexBuilder#makeOver}. {@code nullWhenCountZero=false} suppresses Calcite's
    public void testRankOver_orderBy_tie_1shard() {  
     *  carry the same val and the same rank, so collapsing them loses nothing. */
/*  
            client().prepareIndex(INDEX).setSource("val", val).get();
     * the cross-shard gather (validated structurally in {@code WindowPlanShapeTests}) is wired
        assertEquals("dense rank of val=3 has no gap after the tie", 3L, (long) valToRank.get(3));
import org.opensearch.index.engine.dataformat.stub.MockCommitterEnginePlugin;  
            Version.CURRENT,
            .setSettings(indexSettings)  
        RelNode plan = buildRankProject(runner, SqlStdOperatorTable.RANK);  
    }  
        createAndSeedTieIndex(1);
     * The result must match the 1-shard case exactly — {1,2,2,4} — which only holds if the  
        RelDataType outRelType = b.getTypeFactory().createTypeWithNullability(b.getTypeFactory().createSqlType(outType), true);  
            RexWindowBounds.UNBOUNDED_FOLLOWING,  
        RelNode plan = buildWindowedProject(runner, SqlStdOperatorTable.SUM, SqlTypeName.BIGINT);
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
        SqlPlanRunner runner = sqlPlanRunner();
            ImmutableList.<RexFieldCollation>of(),
    public void testRankOver_orderBy_tie_2shard() {
    }
        assertTrue("index creation must be acknowledged", response.isAcknowledged());  
        return b.build();
            long rank = ((Number) row[1]).longValue();  
            extendedPlugins,
        RelNode plan = buildWindowedProject(runner, SqlStdOperatorTable.COUNT, SqlTypeName.BIGINT);  
     * {@code RANK() OVER (ORDER BY val)} over the same tied data spread across <b>2 shards</b>.
