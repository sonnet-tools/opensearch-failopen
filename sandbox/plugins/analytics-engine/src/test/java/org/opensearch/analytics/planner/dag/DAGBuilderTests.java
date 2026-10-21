        RelNode filter = makeFilter(scan, makeEquals(2, SqlTypeName.VARCHAR, "x"));
     * DAGBuilder must not hardcode SINGLETON. Asserts that a non-singleton ExchangeInfo
 * The OpenSearch Contributors require contributions made to
                    SqlTypeName.INTEGER,
        assertTrue(reducer.getInput() instanceof OpenSearchStageInputScan);
                    SqlTypeName.SMALLINT,
        OpenSearchExchangeReducer customReducer = new OpenSearchExchangeReducer(
 * this file be licensed under the Apache-2.0 license or a
    public void testTwoStageQueries() {
            null,
        assertBottomUpIds(dag.rootStage());
    public void testReducerHasNoInputSinkDecoratorForNonQtf() {
                new SqlTypeName[] {
        assertEquals(StageExecutionType.SHARD_FRAGMENT, scan.getExecutionType());
import org.opensearch.analytics.planner.ClickBench;
            new CapabilityRegistry(List.of(DATAFUSION, LUCENE), FieldStorageResolver::new),
        RelNode cboOutput = runPlanner(logicalPlan, context);
        RelNode filter = makeFilter(scan, makeEquals(0, SqlTypeName.INTEGER, 5));
        QueryDAG dag = DAGBuilder.build(cbo, context.getCapabilityRegistry(), mockClusterService(), TEST_RESOLVER);
 * clean diff of the full tree.
     * but WITH an outer Project above Sort+Limit. Post-LM, Stage 3's fragment is
        RelDataType dateType = typeFactory.createSqlType(SqlTypeName.DATE);
            "StageInputScan rowType must include " + OpenSearchLateMaterialization.UGSI_FIELD,
        assertTrue(scanDag.rootStage().getFragment() instanceof OpenSearchTableScan);
        // Outer Project: pick URL ($2) and EventDate ($4) — mirrors PPL `... | fields URL, EventDate`.
        assertNotNull("scan stage must have a target resolver", scan.getTargetResolver());
        QueryDAG aggDag = buildDAG(2, makeAggregate(sumCall()));
 */
        assertEquals(StageExecutionType.COORDINATOR_REDUCE, dag.rootStage().getExecutionType());
     * </pre>
        QueryDAG dag = DAGBuilder.build(customReducer, context.getCapabilityRegistry(), mockClusterService(), TEST_RESOLVER);
        assertEquals(1, aggDag.rootStage().getChildStages().size());
        );
        assertNull(dag.rootStage().getInputSinkDecorator());
        LOGGER.info("Post-CBO/LM RelNode:\n{}", RelOptUtil.toString(cbo));
     *   Stage 0 SHARD_FRAGMENT       (Filter? + Scan)
            filter,
            )
        assertEquals(StageExecutionType.LATE_MATERIALIZATION, lm.getExecutionType());
        PlanForker.forkAll(dag, context.getCapabilityRegistry());
        );
     * LOCAL_PASSTHROUGH instead so the stage just relays Stitcher output upward.
        QueryDAG dag = buildQtfDag("SELECT URL, EventDate FROM hits ORDER BY EventDate LIMIT 10", 2);
        assertTrue(
import org.opensearch.analytics.planner.rel.OpenSearchExchangeReducer;
        // QTF must have fired (LM wrapper present) and there must be no Project above it.
                    SqlTypeName.DATE,
    }
        assertNotNull(aggDag.rootStage().getExchangeSinkProvider());
        for (Stage child : stage.getChildStages()) {
import org.opensearch.analytics.planner.PlannerImpl;
     * because the root stage executes a backend plan locally (LOCAL_COMPUTE).
    /**
            @Override
     * Multi-shard QTF produces four stages, dataflow runs bottom-up from shards to the post-LM
        );
                    SqlTypeName.VARCHAR,
        // Build DAG + run conversion. The bug is that Stage 3 (root) gets a bare StageInputScan
import org.apache.calcite.plan.RelOptUtil;
import org.apache.calcite.rel.logical.LogicalValues;
        RelCollation collation = RelCollations.of(new RelFieldCollation(4, RelFieldCollation.Direction.ASCENDING));
    public void testReducerExchangeInfoFlowsToChildStage() {
    private static final Logger LOGGER = LogManager.getLogger(DAGBuilderTests.class);
            false
    public void testQtfDag_multiShardFourStages() {
        Stage child = dag.rootStage().getChildStages().get(0);
    // ── QTF (late-materialization) DAG shapes ──────────────────────────────
            originalReducer.getTraitSet(),
 * Structural invariants on the {@link QueryDAG} that don't depend on the full plan shape —
     * and has a target resolver (no coord/child split).
        Stage lm = postLm.getChildStages().get(0);
     * RESULT(SINGLETON) demand without an ER, so the root stage runs on the data node directly
            "Stage 0 Scan rowType must carry " + OpenSearchLateMaterialization.ROW_ID_FIELD + ", got " + scanFieldNames,
        assertNotNull("compute leaf needs a sink provider for its local backend output", dag.rootStage().getExchangeSinkProvider());
        RecordingConvertor convertor = new RecordingConvertor();
            "post-LM root with above-ops must be COORDINATOR_REDUCE",
    }
     * itself stays a pure scatter/gather/stitch and the post-LM Project (or any future
     * The reducer's own {@link ExchangeInfo} must flow into the cut child stage —
     * COORDINATOR_REDUCE so the convertor serializes the Project for execution.
        LogicalSort sort = LogicalSort.create(
        RelNode cbo = runPlanner(logical, context);
 * SPDX-License-Identifier: Apache-2.0
        assertSame("LM wrapper should be at the root (no Project above)", wrapper, RelNodeUtils.unwrapHep(cbo));
        assertNotNull(aggChild.getTargetResolver());
                    SqlTypeName.DATE,
     * Filter/Aggregate/Sort) runs on Substrait via the standard reduce path.
    }
        RelNode scan = stubScan(
     *   Stage 2 LATE_MATERIALIZATION (wrapper rooted at StageInputScan(stage 1))
 * <p>Exact-string DAG-shape tests that lock in the {@link QueryDAG#toString()} output live in
                new String[] { "CounterID", "UserID", "URL", "Title", "EventDate", "AdvEngineID", "ParamPrice" },
import org.opensearch.analytics.planner.CapabilityRegistry;
            "rootStage must contain the LM wrapper",
import org.apache.calcite.rel.RelCollation;
import com.google.common.collect.ImmutableList;
 *
 * stage counts, targetResolver / sinkProvider presence, exchangeInfo propagation.
        assertNotNull("QTF should fire", wrapper);
     * through {@link DAGBuilder}. Returns the four-stage DAG documented at
        PlannerContext context = buildContext("parquet", 2, ClickBench.BASIC_FIELDS, List.of(df, LUCENE));
import java.util.List;
import org.apache.calcite.rel.logical.LogicalSort;
                    SqlTypeName.VARCHAR,
    public void testQtfDag_lmAtRoot_noOuterProject_convertsCleanly() {
     */
        assertNull("scan stage carries no input decorator", scan.getInputSinkDecorator());
     * (falls through to {@code getInputs().getFirst()} → NoSuchElementException). Route to
        PlannerContext context = new PlannerContext(
        // and convertReduceNode trips on getInputs().getFirst().
        RelNode scan = stubScan(
        assertBottomUpIds(scanDag.rootStage());
        ExchangeInfo customInfo = ExchangeInfo.hashDistributed(List.of(0), /* partitionCount */ 2);
        QueryDAG aggDag = buildDAG(1, makeAggregate(sumCall()));
            List.of("URL", "EventDate")
     * attachment because there's no shard to target, and (2) still install a sink provider
        QueryDAG scanDag = buildDAG(1, stubScan(mockTable("test_index", "status", "size")));
import org.apache.calcite.rel.RelFieldCollation;
     * Substrait declares the helper column. Without it, Stage 1's reduce plan references
            @Override
    }
     *     ↓
        assertEquals(1, reduce.getChildStages().size());
        List<String> scanFieldNames = tableScan.getRowType().getFieldNames();
        );
     *   Stage 3 COORDINATOR_REDUCE   (post-LM ops: outer Project, etc.)  ← root
     * Reducer stages outside QTF carry no {@code inputSinkDecorator} — confirms the decorator
        assertNotNull("Stage 0 fragment must contain an OpenSearchTableScan", tableScan);
        LOGGER.info("QTF QueryDAG:\n{}", dag);
        MockDataFusionBackend df = new MockDataFusionBackend() {
        RelNode cbo = runPlanner(project, context);
        QueryDAG dag = DAGBuilder.build(cboOutput, context.getCapabilityRegistry(), mockClusterService(), TEST_RESOLVER);
            scanFieldNames.contains(OpenSearchLateMaterialization.ROW_ID_FIELD)
        QueryDAG dag = buildDAG(2, plan);
        assertNull("no TableScan → no ShardTargetResolver", dag.rootStage().getTargetResolver());
        );
        OpenSearchExchangeReducer reducer = (OpenSearchExchangeReducer) scanDag.rootStage().getFragment();
        );
            rexBuilder.makeLiteral(10, typeFactory.createSqlType(SqlTypeName.INTEGER), true)
     * <p>Stage 3 is the post-LM compute stage, separated by {@link DAGBuilder} so the LM stage
        ImmutableList<ImmutableList<RexLiteral>> tuples = ImmutableList.of(ImmutableList.of(one));
     */
        assertEquals(0, reduceInputScan.getChildStageId());
            reduceInputScan.getRowType().getFieldNames().contains(OpenSearchLateMaterialization.UGSI_FIELD)
import org.apache.calcite.rex.RexLiteral;
        org.apache.calcite.rel.logical.LogicalProject project = org.apache.calcite.rel.logical.LogicalProject.create(
                    SqlTypeName.SMALLINT,
     * structure (ExchangeReducer → StageInputScan, null targetResolver) and child structure
            state,
        // Drive through marking + CBO + LM rewrite. RecordingConvertor swapped onto the
            dag.rootStage().getExecutionType()
import org.opensearch.analytics.planner.BasePlannerRulesTests;
     * coordinator reduce:
                "test_index",
            }
            mockTable(
     *     ↓
        // Sort on EventDate ($4) with fetch=10 — anchor.
        assertNotNull("QTF rewriter should fire (URL fetch-only)", wrapper);
        QueryDAG dag = DAGBuilder.build(cbo, context.getCapabilityRegistry(), mockClusterService(), TEST_RESOLVER);
        Stage scanChild = scanDag.rootStage().getChildStages().get(0);
     *     ↓   inputSinkDecorator = OrdinalAppendingSink (stamps shard ordinal as ___ugsi)
            assertBottomUpIds(child);
                "test_index",
import org.opensearch.analytics.planner.rel.OpenSearchValues;
    /**
        OpenSearchExchangeReducer originalReducer = (OpenSearchExchangeReducer) cbo;
        assertNotNull("LM cut must install OrdinalAppendingSink decorator on reducer", reduce.getInputSinkDecorator());
        assertTrue(scanDag.rootStage().getFragment() instanceof OpenSearchExchangeReducer);
            RelNodeUtils.findNode(dag.rootStage().getFragment(), OpenSearchLateMaterialization.class)
    private QueryDAG buildQtfDag(String sql, int shardCount) {
            collation,
    public void testValuesRootHasNoTargetResolverButHasSink() {
     * {@code convertAll} succeeds.
    private static void assertBottomUpIds(Stage stage) {
        FragmentConversionDriver.convertAll(dag, context.getCapabilityRegistry());
        assertNotNull(aggChild.getExchangeInfo());
            customInfo
     *
        assertNotNull(aggDag.rootStage().getTargetResolver());
        LOGGER.info("QueryDAG:\n{}", dag);
            mockTable(
            originalReducer.getCluster(),
    public void testSingleShardProducesSingleStageDag() {
import org.opensearch.analytics.planner.FieldStorageResolver;
        assertNotSame("Outer Project should sit above the LM wrapper", wrapper, RelNodeUtils.unwrapHep(cbo));
import org.opensearch.analytics.planner.PlannerContext;
        assertEquals(StageExecutionType.SHARD_FRAGMENT, scan.getExecutionType());
     */
     * Drives SQL through the full planner so the QTF rewriter fires, then runs the result
                return convertor;
        // StageInputScan must carry ___ugsi — cutAtExchange uses the reducer's output rowType.
        Stage scan = reduce.getChildStages().get(0);
            originalReducer.getViableBackends(),
            null,
     * is a QTF-only attachment, not a regression on every reduce.
        Stage postLm = dag.rootStage();
        );
        PlanForker.forkAll(dag, context.getCapabilityRegistry());
        Stage scan = dag.rootStage().getChildStages().getFirst().getChildStages().getFirst().getChildStages().getFirst();
    public void testQtfDag_lmAtRoot_withOuterProject_isCoordReduce() {
        // LM at root with no above-ops: the LM stage IS the root — no synthetic post-LM stage.
        LOGGER.info("Input RelNode:\n{}", RelOptUtil.toString(logicalPlan));
            sort,
     * placed on the reducer survives the cut, which is the contract that lets
     * with zero inputs, which {@code FragmentConversionDriver.convertReduceNode} cannot handle
import org.apache.logging.log4j.Logger;
        );
            )
     */
        MockDataFusionBackend df = new MockDataFusionBackend() {
        QueryDAG dag = buildDAG(3, makeAggregate(sumCall()));
    public void testQtfDag_stage0ScanCarriesRowIdHelper() {
 *
        assertEquals(1, postLm.getChildStages().size());
    }
import org.apache.calcite.rel.RelDistribution;
        LogicalSort sort = LogicalSort.create(
        assertNull("post-LM reduce carries no input decorator", postLm.getInputSinkDecorator());
            StageExecutionType.COORDINATOR_REDUCE,
        FragmentConversionDriver.convertAll(dag, context.getCapabilityRegistry());
        OpenSearchLateMaterialization wrapper = RelNodeUtils.findNode(cbo, OpenSearchLateMaterialization.class);
                    SqlTypeName.BIGINT }
        assertEquals(RelDistribution.Type.SINGLETON, aggChild.getExchangeInfo().distributionType());
            "LM fragment must contain OpenSearchLateMaterialization wrapper",
     */
/**
        assertNotNull(
        assertNull(scanDag.rootStage().getTargetResolver());
/*
        RecordingConvertor convertor = new RecordingConvertor();
        RelNode logical = stubScan(mockTable("test_index", "status", "size"));
     * {@code input-0.__row_id__} but the partition exposes only the physical cols and
        assertTrue(scanChild.getFragment() instanceof OpenSearchTableScan);
        LOGGER.info("QueryDAG:\n{}", dag);
    /**
     */
        LOGGER.info("QueryDAG:\n{}", dag);
            originalReducer.getInput(),
import org.opensearch.analytics.planner.rel.OpenSearchStageInputScan;
    }
import org.opensearch.analytics.spi.FragmentConvertor;
        // Stage 3 has real compute (the Project) on top of the StageInputScan → COORDINATOR_REDUCE.
    /**
        assertEquals(0, scan.getChildStages().size());
        assertNotNull(scanChild.getTargetResolver());
        assertEquals(customInfo, child.getExchangeInfo());
            "LM at CBO root must be promoted to rootStage; no synthetic post-LM stage",
        RelNode plan = LogicalValues.create(cluster, rowType, tuples);
    }
        // For a multi-shard scan, the planner inserts an OpenSearchExchangeReducer at the root.
            dag.rootStage().getExecutionType()
     * post-LM root stage to COORDINATOR_REDUCE — the fragment is a bare {@link OpenSearchStageInputScan}
     *
     * rewriter narrows the Scan to {@code [belowAnchorPhysicalFields..., __row_id__]} via an
     * override rowType; this asserts that override survives DAG cuts so the converted
        RelDataType varcharType = typeFactory.createSqlType(SqlTypeName.VARCHAR);
import org.opensearch.analytics.planner.MockDataFusionBackend;
import org.apache.calcite.rel.type.RelDataType;
        assertEquals("Values is leaf — no child stages", 0, dag.rootStage().getChildStages().size());
     * Contrast to {@link #testQtfDag_lmAtRoot_noOuterProject_convertsCleanly}: SAME query shape
            List.of(rexBuilder.makeInputRef(varcharType, 2), rexBuilder.makeInputRef(dateType, 4)),
import org.apache.logging.log4j.LogManager;
        Stage aggChild = aggDag.rootStage().getChildStages().get(0);
     *   Stage 1 COORDINATOR_REDUCE   (Sort+Limit over reduce-set, ___row_id, ___ugsi)
import org.opensearch.cluster.ClusterState;
    /**
        assertNull(aggDag.rootStage().getTargetResolver());
        QueryDAG dag = DAGBuilder.build(cbo, context.getCapabilityRegistry(), mockClusterService(), TEST_RESOLVER);
        );
            public FragmentConvertor getFragmentConvertor() {
    }
            filter,
            assertTrue("child stageId must be lower than parent", child.getStageId() < stage.getStageId());
        ClusterState state = SqlPlannerTestFixture.clusterStateWith(ClickBench.INDEX, ClickBench.BASIC_FIELDS, "parquet", shardCount);
     */
     * <pre>
     * {@link #testQtfDag_multiShardFourStages}.
package org.opensearch.analytics.planner.dag;
     * Multi-shard scan and aggregate both produce two stages. Verifies coordinator root
     * Single-shard plans produce a single-stage DAG: SOURCE(SINGLETON) satisfies the root's
    private QueryDAG buildDAG(int shardCount, RelNode logicalPlan) {
                    SqlTypeName.BIGINT,
        assertNotNull(scanDag.rootStage().getTargetResolver());
        );
        RelNode parsed = SqlPlannerTestFixture.parseSql(sql, state);
        assertBottomUpIds(aggDag.rootStage());
        RelDataType intType = typeFactory.createSqlType(SqlTypeName.INTEGER);
    /**
                new SqlTypeName[] {
        RelDataType rowType = typeFactory.builder().add("a", intType).build();
            }
        Stage reduce = lm.getChildStages().get(0);
    /**
        OpenSearchLateMaterialization wrapper = RelNodeUtils.findNode(cbo, OpenSearchLateMaterialization.class);
        RelCollation collation = RelCollations.of(new RelFieldCollation(4, RelFieldCollation.Direction.ASCENDING));
     */
        RexLiteral one = (RexLiteral) rexBuilder.makeLiteral(1, intType, true);
        assertEquals(
import org.opensearch.analytics.planner.RelNodeUtils;
import org.opensearch.analytics.planner.rel.OpenSearchLateMaterialization;
            public FragmentConvertor getFragmentConvertor() {
     * DataFusion fails the registration with "No field named __row_id__".
            rexBuilder.makeLiteral(10, typeFactory.createSqlType(SqlTypeName.INTEGER), true)
        QueryDAG scanDag = buildDAG(5, stubScan(mockTable("test_index", "status", "size")));
    }
        OpenSearchTableScan tableScan = RelNodeUtils.findNode(scan.getFragment(), OpenSearchTableScan.class);
     * QTF wrapper ends up at the post-CBO root with NO operators above it (e.g. PPL frontends
 * compatible open source license.
        assertEquals(1, lm.getChildStages().size());
import org.apache.calcite.rel.RelCollations;
public class DAGBuilderTests extends BasePlannerRulesTests {
        assertEquals(StageExecutionType.COORDINATOR_REDUCE, postLm.getExecutionType());
 */
import org.apache.calcite.rel.RelNode;
        };
import org.apache.calcite.sql.type.SqlTypeName;
        return dag;
 * {@link DAGShapeTests} — those catch regressions in fragment placement or stage cuts via a
     * <p>Repro: build {@code Sort(Filter(Scan))} directly (bypasses SQL parse which would add an outer
import org.opensearch.analytics.planner.SqlPlannerTestFixture;
        assertNull(aggChild.getExchangeSinkProvider());
        assertNotNull(reduceInputScan);
        PlannerContext context = buildContext("parquet", 2, ClickBench.BASIC_FIELDS, List.of(df, LUCENE));
                    SqlTypeName.INTEGER,
    }
                return convertor;
    }
        assertTrue(
     * future shuffle/broadcast strategies work without DAGBuilder changes.
        return dag;
                    SqlTypeName.VARCHAR,
        assertEquals(0, aggDag.rootStage().getChildStages().size());
        );
     */
        // mockTable's columns mirror ClickBench's BASIC_FIELDS so QTF detects fetch-only fields.
     */
    /**
     * that don't add an outer Project around Sort+Limit). DAGBuilder must NOT route the resulting
        assertEquals(StageExecutionType.COORDINATOR_REDUCE, reduce.getExecutionType());
        assertTrue("root fragment must be OpenSearchValues", dag.rootStage().getFragment() instanceof OpenSearchValues);
            collation,
        RelNode cbo = runPlanner(sort, context);
            StageExecutionType.LATE_MATERIALIZATION,
        OpenSearchStageInputScan reduceInputScan = RelNodeUtils.findNode(reduce.getFragment(), OpenSearchStageInputScan.class);
     * (TableScan leaf, non-null targetResolver, correct ExchangeInfo).
import org.opensearch.analytics.planner.rel.OpenSearchTableScan;
        assertNotNull(
        var context = buildContext("parquet", 2, intFields());
        assertEquals(1, scanDag.rootStage().getChildStages().size());
        );
     * Stage 0's shard fragment must propagate {@code __row_id__} on its Scan output. The
     * with no TableScan in the fragment. DAGBuilder must (1) skip {@code ShardTargetResolver}
            RelNodeUtils.findNode(lm.getFragment(), OpenSearchLateMaterialization.class)
        LOGGER.info("Post-CBO/LM RelNode:\n{}", RelOptUtil.toString(cbo));
        // Filter on CounterID ($0) so filter/sort cols don't subsume the project — keeps URL fetch-only.
    /**
            List.of(),
        // ILIKE on URL ($2) — fetch-only column not in the anchor's sort key.
    /**
        var context = buildContext("parquet", shardCount, intFields());
        }
     * Project), drive through the planner + DAGBuilder + FragmentConversionDriver, assert
                    SqlTypeName.VARCHAR,
    }
                    SqlTypeName.BIGINT }
                new String[] { "CounterID", "UserID", "URL", "Title", "EventDate", "AdvEngineID", "ParamPrice" },
        assertEquals(
     * {@code Project(StageInputScan)} — real coordinator-side compute. Must be
                    SqlTypeName.BIGINT,
        LOGGER.info("Marked+CBO RelNode:\n{}", RelOptUtil.toString(cboOutput));
        assertEquals(0, scanDag.rootStage().getChildStages().size());
}
        );
        // datafusion mock backend so FragmentConversionDriver.convertAll has something to call.
        // Build LogicalSort(LogicalFilter(stubScan)) — no Project anywhere above the anchor.
        RelNode cbo = PlannerImpl.runAllOptimizations(parsed, context);
     * Literal-row source (LogicalValues / OpenSearchValues): a coordinator-local compute leaf
        QueryDAG dag = buildQtfDag("SELECT URL, EventDate FROM hits ORDER BY EventDate LIMIT 10", 2);
        };
