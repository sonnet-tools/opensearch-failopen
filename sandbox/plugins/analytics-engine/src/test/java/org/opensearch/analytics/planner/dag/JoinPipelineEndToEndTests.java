        Stage root = dag.rootStage();
        OpenSearchJoin rootJoin = (OpenSearchJoin) root.getFragment();
    /** Drive the first three coordinator-side passes and return the resulting DAG. */
        // Root join's inputs are reducer-wrapped StageInputScans (post-DAG-cut shape).
        );
            root.getFragment() instanceof OpenSearchJoin
 * </ul>
import org.opensearch.analytics.planner.rel.OpenSearchTableScan;
import org.opensearch.analytics.planner.rel.OpenSearchStageInputScan;
        int leftCols = leftScan.getRowType().getFieldCount();
    }
        return dag;
 * {@link BackendPlanAdapter#adaptAll}.
        assertTrue("Root join left input must be ExchangeReducer", rootJoin.getLeft() instanceof OpenSearchExchangeReducer);
import java.util.Set;
/**
     * (DataFusion picks the operator from the non-equi predicate). This is the M0 path,
        assertTrue("Right reducer's input must be StageInputScan placeholder", rightReducer.getInput() instanceof OpenSearchStageInputScan);
                    "Mock DataFusion is the only join-capable backend in the harness",
 * Integration-style tests that exercise the <b>coordinator-side pipeline</b> for a join —
            // the pre-fork annotated tree (for replanning). Assertion lives on planAlternatives.
                assertEquals(MockDataFusionBackend.NAME, alternative.backendId());
 * {@link org.opensearch.analytics.spi.FragmentConvertor} — that pass is already covered by
        // Root is the coordinator join stage.
     * <pre>
        QueryDAG dag = buildDagThroughAdapter(/* shards */ 5, makeInnerEquiJoin());
 * SPDX-License-Identifier: Apache-2.0
 *
            assertFalse("PlanForker must have produced at least one plan alternative per stage", child.getPlanAlternatives().isEmpty());
 * quick regression.
        OpenSearchJoin rootJoin = (OpenSearchJoin) root.getFragment();
import org.opensearch.analytics.planner.rel.OpenSearchExchangeReducer;
import org.apache.calcite.rel.type.RelDataType;
 * shapes that aggregate/union queries don't.
        assertEquals("Root must have exactly 2 child stages for a binary join", 2, root.getChildStages().size());
        OpenSearchExchangeReducer rightReducer = (OpenSearchExchangeReducer) rootJoin.getRight();
            assertNotNull("Child stage must have a shard target resolver", child.getTargetResolver());
     *   Child stage 1: OpenSearchTableScan (right)
        RexNode condition = rexBuilder.makeCall(
/*
        assertTrue("Left reducer's input must be StageInputScan placeholder", leftReducer.getInput() instanceof OpenSearchStageInputScan);
     * SINGLETON on each input regardless of the join condition, and the DAG cuts at the
        );
import org.opensearch.analytics.planner.BasePlannerRulesTests;
        OpenSearchExchangeReducer rightReducer = (OpenSearchExchangeReducer) rootJoin.getRight();
 * execution (DataFusion runtime) requires spinning up a full OpenSearch cluster with the
 *
        RelNode cboOutput = runPlanner(logicalPlan, context);
    /**
        RelNode leftScan = stubScan(mockTable("test_index", "status", "size"));
    private LogicalJoin makeInnerEquiJoin() {
        assertEquals(2, root.getChildStages().size());
     *   Root: OpenSearchJoin (coordinator)
        return LogicalJoin.create(leftScan, rightScan, List.of(), condition, Set.of(), JoinRelType.INNER);
public class JoinPipelineEndToEndTests extends BasePlannerRulesTests {
 *   <li>DAG cut shape is stable across shard counts and equi/theta join variants.</li>
        assertTrue("Right reducer's input must be StageInputScan placeholder", rightReducer.getInput() instanceof OpenSearchStageInputScan);
        PlanForker.forkAll(dag, context.getCapabilityRegistry());
        for (Stage child : root.getChildStages()) {
        RelNode rightScan = stubScan(mockTable("test_index", "status", "size"));
 * {@link FragmentConversionDriverTests} with its own recording convertor. Running actual native
        PlannerContext context = buildContext("parquet", shardCount, intFields());
import org.opensearch.analytics.planner.MockDataFusionBackend;
        return LogicalJoin.create(leftScan, rightScan, List.of(), condition, Set.of(), JoinRelType.INNER);
 * The OpenSearch Contributors require contributions made to
        assertNull("Root stage must have no shard target (coordinator-side)", root.getTargetResolver());
     *
 * @opensearch.internal
 * compatible open source license.
    private LogicalJoin makeThetaJoin() {
        RelNode rightScan = stubScan(mockTable("test_index", "status", "size"));
package org.opensearch.analytics.planner.dag;
import java.util.List;
    private QueryDAG buildDagThroughAdapter(int shardCount, RelNode logicalPlan) {
     */
        // Same root-level shape as the equi case: OpenSearchJoin at the coordinator with
     * single-shard case — the number of shards affects target resolution at dispatch time, not the
 *
 *   <li>Plan forking narrows per-stage {@code viableBackends} to a single concrete backend.</li>
    public void testInnerEquiJoinMultiShardKeepsSameDagShape() {
                    MockDataFusionBackend.NAME,
    }
        QueryDAG dag = buildDagThroughAdapter(/* shards */ 3, makeThetaJoin());
            rexBuilder.makeInputRef(intType, leftCols)
        assertNull("Root stage must have no shard target (coordinator-side)", root.getTargetResolver());
 */
        RelNode leftScan = stubScan(mockTable("test_index", "status", "size"));
import org.apache.calcite.rel.core.JoinRelType;
        assertTrue("Root join left input must be ExchangeReducer", rootJoin.getLeft() instanceof OpenSearchExchangeReducer);
    /**
            }
}
import org.opensearch.analytics.planner.PlannerImpl;
        OpenSearchExchangeReducer leftReducer = (OpenSearchExchangeReducer) rootJoin.getLeft();
        RexNode condition = rexBuilder.makeCall(
     * </pre>
import org.apache.calcite.plan.RelOptUtil;
 *
        );
 * <ul>
            assertFalse(child.getPlanAlternatives().isEmpty());
            root.getFragment() instanceof OpenSearchJoin
import org.apache.calcite.rex.RexNode;
            rexBuilder.makeInputRef(intType, 0),
        QueryDAG dag = buildDagThroughAdapter(/* shards */ 3, makeInnerEquiJoin());
        int leftCols = leftScan.getRowType().getFieldCount();
        assertTrue("Root join right input must be ExchangeReducer", rootJoin.getRight() instanceof OpenSearchExchangeReducer);
            rexBuilder.makeInputRef(intType, leftCols)
        // producing OpenSearchJoin(ER(scan), ER(scan)) with two child stages. Single-shard
                assertEquals(
                );
        assertEquals("Root must have exactly 2 child stages for a binary join", 2, root.getChildStages().size());
import org.apache.logging.log4j.LogManager;
     *   └─ OpenSearchExchangeReducer → OpenSearchStageInputScan (right)
     */
import org.apache.logging.log4j.Logger;
 *
        LOGGER.info("Marked+CBO RelNode:\n{}", RelOptUtil.toString(cboOutput));
    }
            "Root stage fragment must be OpenSearchJoin, got " + root.getFragment().getClass().getSimpleName(),
     *   Child stage 0: OpenSearchTableScan (left)
     * silently alter the coordinator-side pipeline.
     * restored after PR #21639 had inadvertently rejected non-equi at the marker rule.
 * arrow-flight-rpc extension — doable via {@code internalClusterTest} but too heavyweight for a
     * Multi-shard variant: each join input is a 5-shard scan. Structural shape is identical to the
        assertTrue(
        LOGGER.info("Adapted QueryDAG:\n{}", dag);
        Stage root = dag.rootStage();
        LOGGER.info("Input RelNode:\n{}", RelOptUtil.toString(logicalPlan));
        RelDataType intType = typeFactory.createSqlType(SqlTypeName.INTEGER);
import org.apache.calcite.rel.RelNode;
     * Theta (non-equi) joins route through the same coordinator-centric DAG shape as equi
        Stage root = dag.rootStage();
import org.apache.calcite.rel.logical.LogicalJoin;
        assertTrue(root.getFragment() instanceof OpenSearchJoin);
 * <p>These tests double as regression anchors for the Codex findings across M0/M1/M2:
 */
    }
            assertTrue(child.getFragment() instanceof OpenSearchTableScan);
            for (StagePlan alternative : child.getPlanAlternatives()) {
     * Each child stage has a plan alternative narrowed to a single backend after {@code PlanForker}.
 * <p>The existing {@link DAGBuilderTests} only exercises the first two steps; these tests ensure
import org.opensearch.analytics.planner.rel.OpenSearchJoin;
            "Root stage fragment must be OpenSearchJoin, got " + root.getFragment().getClass().getSimpleName(),
    /**
    }
 * <p>The last pipeline step ({@link FragmentConversionDriver#convertAll}) is NOT driven here
        }
     */
            assertTrue("Child stage fragment must be a scan", child.getFragment() instanceof OpenSearchTableScan);
        // same-table joins go SHARD-local under PR's design and don't have child stages.
        assertTrue("Left reducer's input must be StageInputScan placeholder", leftReducer.getInput() instanceof OpenSearchStageInputScan);
    public void testThetaJoinRoutesThroughCoordinatorCentric() {
        assertTrue("Root join right input must be ExchangeReducer", rootJoin.getRight() instanceof OpenSearchExchangeReducer);
 * this file be licensed under the Apache-2.0 license or a
        // Two child stages — one per join input.
 *   <li>Every marked join admits at least one backend via the post-intersection capability check.</li>
 * because the mock backend in {@link BasePlannerRulesTests} doesn't ship a real
 * that all four passes compose correctly for join queries, which exercise multi-input stage
    private static final Logger LOGGER = LogManager.getLogger(JoinPipelineEndToEndTests.class);
import org.apache.calcite.sql.fun.SqlStdOperatorTable;
        // two reducer-wrapped StageInputScan inputs.
    // ---- Query builders (local to these pipeline tests) ----
        BackendPlanAdapter.adaptAll(dag, context.getCapabilityRegistry());
            rexBuilder.makeInputRef(intType, 0),
                    alternative.backendId()
            assertNotNull(child.getTargetResolver());
        assertTrue(
        }
     * INNER equi-join of two single-shard tables produces the expected coordinator-centric shape:
            for (StagePlan alternative : child.getPlanAlternatives()) {
import org.apache.calcite.sql.type.SqlTypeName;
     * per-side reducers. NestedLoopJoinExec runs at the coordinator at execution time
        for (Stage child : root.getChildStages()) {
            SqlStdOperatorTable.LESS_THAN,
 * {@link PlannerImpl#createPlan} → {@link DAGBuilder#build} → {@link PlanForker#forkAll} →
        OpenSearchExchangeReducer leftReducer = (OpenSearchExchangeReducer) rootJoin.getLeft();
    public void testInnerEquiJoinDagShapeAndAlternatives() {
        RelDataType intType = typeFactory.createSqlType(SqlTypeName.INTEGER);
        QueryDAG dag = DAGBuilder.build(cboOutput, context.getCapabilityRegistry(), mockClusterService(), TEST_RESOLVER);
            }
            // PlanForker narrows viableBackends on plan alternatives, but Stage.fragment keeps
     *   ├─ OpenSearchExchangeReducer → OpenSearchStageInputScan (left)
        );
     * joins under M2: marker rule produces an {@link OpenSearchJoin}, the split rule demands
            SqlStdOperatorTable.EQUALS,
import org.opensearch.analytics.planner.PlannerContext;
    }
     * DAG topology. This test pins that invariant so future shard-count-dependent changes don't
        // Multi-shard so PR #21639's split rule demands COORDINATOR+SINGLETON on each input,
