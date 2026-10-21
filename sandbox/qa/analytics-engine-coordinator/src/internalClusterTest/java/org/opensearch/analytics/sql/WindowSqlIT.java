        b.rename(List.of("val", "agg"));
import org.opensearch.parquet.ParquetOnlyDataFormatPlugin;
    public void testDenseRankOver_orderBy_tie_1shard() {
            pluginClass.getName(),
     *  carry the same val and the same rank, so collapsing them loses nothing. */
        String node = internalCluster().getNodeNames()[0];
    }
            Version.CURRENT,
            RexWindowBounds.UNBOUNDED_PRECEDING,
            int val = (i % 3) + 1;
        assertEquals("dense rank of val=1", 1L, (long) valToRank.get(1));
            .get();
            .build();
import org.opensearch.cluster.service.ClusterService;
    }
    /**
public class WindowSqlIT extends OpenSearchIntegTestCase {
    private void createAndSeedIndex(int shardCount) {
    }
 * NULL-on-empty-set semantics that DataFusion's physical planner doesn't yet support.
            ImmutableList.<RexFieldCollation>of(),
                assertEquals("all rows with val=" + val + " must share one rank", (long) prior, rank);
            false,
     * RexOver cost gate gathered both shards to a single node before the window ran. Were the
        b.project(b.field(0), over);
    public void testDenseRankOver_orderBy_tie_2shard() {
    }
            client().prepareIndex(INDEX).setSource("val", val).get();
            client().prepareIndex(INDEX).setSource("val", val).get();
    @Override
            .setSettings(indexSettings)
        assertEquals("rank of val=1", 1L, (long) valToRank.get(1));
            .prepareCreate(INDEX)
 * compatible open source license.
        assertEquals("rank of tied val=2 (gap semantics)", 2L, (long) valToRank.get(2));
        return Settings.builder()
            assertEquals("SUM(val) OVER () must equal grand total 12 on every row", 12L, ((Number) row[1]).longValue());
            false,
     * {@code DENSE_RANK() OVER (ORDER BY val)} over the tied data across <b>2 shards</b>. Mirror
        client().admin().indices().prepareFlush(INDEX).get();
     */
        b.project(b.field(0), over);
            rankFn,
            false,
        RelDataType outRelType = b.getTypeFactory().createTypeWithNullability(b.getTypeFactory().createSqlType(outType), true);
            RexWindowBounds.CURRENT_ROW,
            .indices()
     * {@code DENSE_RANK() OVER (ORDER BY val)} over the same tied data. With vals {1,2,2,3}
        );
import java.util.List;
/**
     * With vals {1,2,2,3} the ranks are {1,2,2,4} — the tied rows share rank 2 and the
     * the cross-shard gather (validated structurally in {@code WindowPlanShapeTests}) is wired
        Settings indexSettings = Settings.builder()
        SqlPlanRunner runner = sqlPlanRunner();
    private void createAndSeedTieIndex(int shardCount) {
    private static final int[] TIE_VALS = { 1, 2, 2, 3 };
            .indices()
    }
    private static final int TIE_DOCS = TIE_VALS.length;
import org.opensearch.common.settings.Settings;
     */
/*
            classpathPlugin(DataFusionPlugin.class, List.of(AnalyticsPlugin.class.getName()))
import org.apache.calcite.rex.RexNode;
        RexNode over = rex.makeOver(
     */
    protected Collection<PluginInfo> additionalNodePlugins() {
        RexNode over = rex.makeOver(
            agg,
            false,
        assertEquals("rank of val=3 skips to 4 after the tie", 4L, (long) valToRank.get(3));
import org.apache.calcite.sql.type.SqlTypeName;
        return out;
            List.of(),
            List.of(valRef),
 */
     */
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, shardCount)
            .put(super.nodeSettings(nodeOrdinal))
     */
        SqlPlanRunner runner = sqlPlanRunner();
        Map<Integer, Long> out = new java.util.HashMap<>();
import org.opensearch.action.admin.indices.create.CreateIndexResponse;
    private RelNode buildWindowedProject(SqlPlanRunner runner, org.apache.calcite.sql.SqlAggFunction agg, SqlTypeName outType) {
 *
        b.rename(List.of("val", "rank"));
 * The OpenSearch Contributors require contributions made to
    /**
            .setMapping("val", "type=integer")
        Map<Integer, Long> valToRank = collectValToRank(rows);
            RexWindowBounds.UNBOUNDED_FOLLOWING,
        SqlPlanRunner runner = sqlPlanRunner();
     *  repeated on every output row. */
    /**
    private SqlPlanRunner sqlPlanRunner() {
            classpathPlugin(FlightStreamPlugin.class, List.of(ArrowBasePlugin.class.getName())),
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
    /**
    }
        return b.build();
    }
        for (int i = 0; i < TOTAL_DOCS; i++) {
     *  Project triggers the cost gate so the planner inserts a gather; the window evaluates
 * parser, which wraps {@code SUM(...) OVER ()} in a CASE expression for SQL
import org.apache.calcite.sql.fun.SqlStdOperatorTable;
        assertEquals("one output row per input row", TOTAL_DOCS, rows.size());
     * {@code RANK() OVER (ORDER BY val)} over a single-shard index seeded with a tie.
            classpathPlugin(ParquetOnlyDataFormatPlugin.class, Collections.emptyList()),
     *  against the assembled stream. With val ∈ {1,2,3,1,2,3} the per-row total is 12,
    @Override
            .put("index.pluggable.dataformat", "composite")
            false,
        RelNode plan = buildWindowedProject(runner, SqlStdOperatorTable.SUM, SqlTypeName.BIGINT);
        CreateIndexResponse response = client().admin()
        ensureGreen(INDEX);
        List<Object[]> rows = runner.executeRel(plan);
    public void testRankOver_orderBy_tie_1shard() {
import org.opensearch.common.util.FeatureFlags;
        );
        Settings indexSettings = Settings.builder()
        assertEquals("rank of val=3 skips to 4 after the global tie", 4L, (long) valToRank.get(3));
    }
import org.opensearch.plugins.Plugin;
            RexWindowBounds.UNBOUNDED_PRECEDING,
    }
    public void testRankOver_orderBy_tie_2shard() {
        CreateIndexResponse response = client().admin()
        for (Object[] row : rows) {
    }
            }
        RelNode plan = buildRankProject(runner, SqlStdOperatorTable.RANK);
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, shardCount)
        ClusterService clusterService = internalCluster().getInstance(ClusterService.class, node);
 */
            .put(FeatureFlags.STREAM_TRANSPORT, true)
        }
        RelNode plan = buildWindowedProject(runner, SqlStdOperatorTable.COUNT, SqlTypeName.BIGINT);
 * with no nullability wrapper).
        RelNode plan = buildRankProject(runner, SqlStdOperatorTable.DENSE_RANK);
import com.google.common.collect.ImmutableList;
import org.apache.calcite.rex.RexFieldCollation;
            ImmutableList.of(new RexFieldCollation(valRef, java.util.Collections.emptySet())),  // ORDER BY val
        List<Object[]> rows = runner.executeRel(plan);
    private static final String INDEX = "window_idx";
import org.opensearch.composite.CompositeDataFormatPlugin;
            .prepareCreate(INDEX)
    }
 *
        return new PluginInfo(
        assertEquals(TIE_DOCS, rows.size());
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
        SqlPlanRunner runner = sqlPlanRunner();
            null,
        return new SqlPlanRunner(clusterService, executor);
    private RelNode buildRankProject(SqlPlanRunner runner, org.apache.calcite.sql.SqlAggFunction rankFn) {
            false,
        assertEquals(TIE_DOCS, rows.size());
     */
     * the implicit frame is RANGE UNBOUNDED PRECEDING TO CURRENT ROW (rangeBased=false).
            extendedPlugins,
            true,
        assertEquals("rank of val=1", 1L, (long) valToRank.get(1));
        assertEquals("rank of tied val=2 — one global rank across shards", 2L, (long) valToRank.get(2));
     * own RelNode lowering produces.
        }
        Map<Integer, Long> valToRank = collectValToRank(rows);
        assertEquals("dense rank of tied val=2 — one global rank across shards", 2L, (long) valToRank.get(2));
        createAndSeedTieIndex(2);
    /**
import org.apache.calcite.tools.RelBuilder;
import org.opensearch.arrow.allocator.ArrowBasePlugin;
            .put(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG, true)
import org.apache.calcite.rel.RelNode;
    public void testSumOver_unframed_2shard() {
        client().admin().indices().prepareRefresh(INDEX).get();
            if (prior != null) {
import java.util.Collections;
 * @opensearch.internal
        return b.build();
        RexNode valRef = rex.makeInputRef(b.peek(), 0);
            .put("index.composite.primary_data_format", "parquet")
        SqlPlanRunner runner = sqlPlanRunner();
            "NA",
        RelBuilder b = runner.relBuilder();
        assertEquals(TIE_DOCS, rows.size());
            .setSettings(indexSettings)
        assertEquals("dense rank of val=1", 1L, (long) valToRank.get(1));
        RexBuilder rex = b.getRexBuilder();
     * distinctly from DENSE_RANK end-to-end.
import org.opensearch.plugins.PluginInfo;
     * gap. Contrast with {@link #testRankOver_orderBy_tie_1shard}, where the same data yields
        RelBuilder b = runner.relBuilder();
import java.util.Collection;
            .put("index.composite.primary_data_format", "parquet")
    /** Folds {@code [val, rank]} output rows into a {@code val → rank} map. The tied rows
    private static final int TOTAL_DOCS = 6;
            classpathPlugin(AnalyticsPlugin.class, Collections.emptyList()),
            true,
        createAndSeedTieIndex(2);
        Map<Integer, Long> valToRank = collectValToRank(rows);
        }
    }
import java.util.Map;
        client().admin().indices().prepareFlush(INDEX).get();
            .putList("index.composite.secondary_data_formats")
    /**
        assertEquals(TOTAL_DOCS, rows.size());
     *  Should equal {@link #TOTAL_DOCS}. */
import org.opensearch.cluster.metadata.IndexMetadata;
import org.opensearch.Version;
        RelNode plan = buildRankProject(runner, SqlStdOperatorTable.RANK);
            .put("index.pluggable.dataformat.enabled", true)
        );
        // vals {1, 2, 2, 3} — the duplicated 2 is the tie that distinguishes RANK from DENSE_RANK.
        // Output row order is not guaranteed; assert the val→rank mapping as a set of pairs.
            .get();
            false
    private static Map<Integer, Long> collectValToRank(List<Object[]> rows) {
     * gather assembled a single global stream before ranking.
     * Builds {@code LogicalProject(val=$0, rank=RANKFN() OVER (ORDER BY val)) FROM index}. RANK /
     * window evaluated shard-locally, each shard would restart its rank at 1 and the tied 2s
    protected Collection<Class<? extends Plugin>> nodePlugins() {
    public void testCountOver_unframed_2shard() {
            false
        RexBuilder rex = b.getRexBuilder();
        return List.of(
            pluginClass.getName(),
     * of {@link #testRankOver_orderBy_tie_2shard}: the dense ranks stay {1,2,2,3} only if the
     * {@link RexBuilder#makeOver}. {@code nullWhenCountZero=false} suppresses Calcite's
            .setMapping("val", "type=integer")
        RexNode valRef = rex.makeInputRef(b.peek(), 0);
        return List.of(ArrowBasePlugin.class, CompositeDataFormatPlugin.class, MockCommitterEnginePlugin.class);
     * DENSE_RANK take no operands and require an ORDER BY; with an ORDER BY and no explicit frame
        assertTrue("index creation must be acknowledged", response.isAcknowledged());
     * The result must match the 1-shard case exactly — {1,2,2,4} — which only holds if the
     * (likely on different shards) would no longer share a rank. This is the test that proves
import org.apache.calcite.rel.type.RelDataType;
            false
        }
            .put("index.pluggable.dataformat.enabled", true)
     * SUM-empty-set CASE wrap that the SQL parser would emit — matches the shape PPL's
        b.scan(INDEX);
        assertEquals("dense rank of val=3 has no gap after the global tie", 3L, (long) valToRank.get(3));
            outRelType,
        assertEquals(TIE_DOCS, rows.size());
        ensureGreen(INDEX);
        List<Object[]> rows = runner.executeRel(plan);
    /** {@code SUM(val) OVER ()} — unframed grand total over a 2-shard index. RexOver in the
        for (Object[] row : rows) {
    protected Settings nodeSettings(int nodeOrdinal) {
        DefaultPlanExecutor executor = internalCluster().getInstance(DefaultPlanExecutor.class, node);
        b.scan(INDEX);
        createAndSeedIndex(2);
        assertTrue("index creation must be acknowledged", response.isAcknowledged());
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.SUITE, numDataNodes = 2, numClientNodes = 0)
    }
    @Override
            "classpath plugin",
        createAndSeedTieIndex(1);
import org.opensearch.index.engine.dataformat.stub.MockCommitterEnginePlugin;
    /** {@code COUNT(val) OVER ()} — unframed count of non-null vals over a 2-shard index.
            .putList("index.composite.secondary_data_formats")
        createAndSeedIndex(2);
import org.opensearch.analytics.AnalyticsPlugin;
            .build();
 * End-to-end IT for window functions. Constructs {@code LogicalProject} carrying a
        Map<Integer, Long> valToRank = collectValToRank(rows);
import org.opensearch.be.datafusion.DataFusionPlugin;
            long rank = ((Number) row[1]).longValue();
        }
        client().admin().indices().prepareRefresh(INDEX).get();
import org.opensearch.arrow.flight.transport.FlightStreamPlugin;
import org.opensearch.test.OpenSearchIntegTestCase;
import org.apache.calcite.rex.RexWindowBounds;
    private static PluginInfo classpathPlugin(Class<? extends Plugin> pluginClass, List<String> extendedPlugins) {
     * {@code RANK() OVER (ORDER BY val)} over the same tied data spread across <b>2 shards</b>.
        createAndSeedTieIndex(1);
}
            assertEquals((long) TOTAL_DOCS, ((Number) row[1]).longValue());
     * next rank skips to 4 (gap semantics). This is the case that proves RANK is wired
 * SPDX-License-Identifier: Apache-2.0
        List<Object[]> rows = runner.executeRel(plan);
        for (Object[] row : rows) {
import org.apache.calcite.rex.RexBuilder;
        SqlPlanRunner runner = sqlPlanRunner();
            List.of(),
        RelNode plan = buildRankProject(runner, SqlStdOperatorTable.DENSE_RANK);
     * end-to-end for ranking functions.
import org.opensearch.analytics.exec.DefaultPlanExecutor;
            int val = ((Number) row[0]).intValue();
    }
 * This matches the shape PPL's {@code eventstats} produces (clean {@code SUM($0) OVER ()}
     * a gap (rank 4) — the two assertions together prove the functions are distinct.
package org.opensearch.analytics.sql;
 * this file be licensed under the Apache-2.0 license or a
 * {@code RexOver} programmatically via Calcite's {@link RelBuilder} — bypassing the SQL
            "1.8",
        List<Object[]> rows = runner.executeRel(plan);
     * the dense ranks are {1,2,2,3} — tied rows share rank 2 and the next rank is 3 with no
            ImmutableList.<RexNode>of(),
        List<Object[]> rows = runner.executeRel(plan);
    }
    // ── Infrastructure ──────────────────────────────────────────────────────
            .put("index.pluggable.dataformat", "composite")
            b.getTypeFactory().createSqlType(SqlTypeName.BIGINT),
     * Builds {@code LogicalProject(val=$0, agg=AGG(val) OVER ()) FROM index} via RelBuilder +
        assertEquals("dense rank of val=3 has no gap after the tie", 3L, (long) valToRank.get(3));
            Long prior = out.put(val, rank);
        assertEquals("dense rank of tied val=2", 2L, (long) valToRank.get(2));
        for (int val : TIE_VALS) {
    }
            .build();
        );
