import org.apache.calcite.sql.type.SqlTypeName;
        assertEquals(2, root.getChildStages().size());
import java.util.List;
 * execution (DataFusion runtime) requires spinning up a full OpenSearch cluster with the  
        LOGGER.info("Marked+CBO RelNode:\n{}", RelOptUtil.toString(cboOutput));
        OpenSearchExchangeReducer rightReducer = (OpenSearchExchangeReducer) rootJoin.getRight();
            root.getFragment() instanceof OpenSearchJoin
    }
        RexNode condition = rexBuilder.makeCall(
                    MockDataFusionBackend.NAME,
import org.apache.logging.log4j.Logger;
 *   <li>Every marked join admits at least one backend via the post-intersection capability check.</li>  
            // the pre-fork annotated tree (for replanning). Assertion lives on planAlternatives.
            for (StagePlan alternative : child.getPlanAlternatives()) {  
            // PlanForker narrows viableBackends on plan alternatives, but Stage.fragment keeps
        for (Stage child : root.getChildStages()) {
import org.apache.calcite.rex.RexNode;  
        assertTrue(root.getFragment() instanceof OpenSearchJoin);  
        assertTrue("Left reducer's input must be StageInputScan placeholder", leftReducer.getInput() instanceof OpenSearchStageInputScan);
    // ---- Query builders (local to these pipeline tests) ----  
    public void testThetaJoinRoutesThroughCoordinatorCentric() {
        assertNull("Root stage must have no shard target (coordinator-side)", root.getTargetResolver());  
            assertNotNull(child.getTargetResolver());  
 * {@link FragmentConversionDriverTests} with its own recording convertor. Running actual native
            for (StagePlan alternative : child.getPlanAlternatives()) {
        assertTrue("Right reducer's input must be StageInputScan placeholder", rightReducer.getInput() instanceof OpenSearchStageInputScan);  
 *  
        LOGGER.info("Input RelNode:\n{}", RelOptUtil.toString(logicalPlan));
import org.opensearch.analytics.planner.PlannerContext;
        assertTrue(
        }
        assertTrue("Right reducer's input must be StageInputScan placeholder", rightReducer.getInput() instanceof OpenSearchStageInputScan);
        assertNull("Root stage must have no shard target (coordinator-side)", root.getTargetResolver());  
import org.opensearch.analytics.planner.rel.OpenSearchExchangeReducer;  
 */  
import org.opensearch.analytics.planner.MockDataFusionBackend;  
     * silently alter the coordinator-side pipeline.  
import org.opensearch.analytics.planner.rel.OpenSearchTableScan;  
 * {@link org.opensearch.analytics.spi.FragmentConvertor} — that pass is already covered by
     *   ├─ OpenSearchExchangeReducer → OpenSearchStageInputScan (left)
     * per-side reducers. NestedLoopJoinExec runs at the coordinator at execution time
        // producing OpenSearchJoin(ER(scan), ER(scan)) with two child stages. Single-shard
            assertTrue("Child stage fragment must be a scan", child.getFragment() instanceof OpenSearchTableScan);  
            }
        assertTrue(
                assertEquals(MockDataFusionBackend.NAME, alternative.backendId());
 * {@link PlannerImpl#createPlan} → {@link DAGBuilder#build} → {@link PlanForker#forkAll} →
     * restored after PR #21639 had inadvertently rejected non-equi at the marker rule.  
     */
 * @opensearch.internal
        RelDataType intType = typeFactory.createSqlType(SqlTypeName.INTEGER);
    }
        assertEquals("Root must have exactly 2 child stages for a binary join", 2, root.getChildStages().size());
    }
        BackendPlanAdapter.adaptAll(dag, context.getCapabilityRegistry());
 *
 * The OpenSearch Contributors require contributions made to  
        assertTrue("Root join left input must be ExchangeReducer", rootJoin.getLeft() instanceof OpenSearchExchangeReducer);  
            rexBuilder.makeInputRef(intType, leftCols)
            rexBuilder.makeInputRef(intType, 0),
            assertFalse("PlanForker must have produced at least one plan alternative per stage", child.getPlanAlternatives().isEmpty());  
        int leftCols = leftScan.getRowType().getFieldCount();
        Stage root = dag.rootStage();
 *   <li>DAG cut shape is stable across shard counts and equi/theta join variants.</li>
        RelNode cboOutput = runPlanner(logicalPlan, context);  
    private LogicalJoin makeThetaJoin() {  
    private QueryDAG buildDagThroughAdapter(int shardCount, RelNode logicalPlan) {  
        // Root is the coordinator join stage.  
    public void testInnerEquiJoinDagShapeAndAlternatives() {  
    public void testInnerEquiJoinMultiShardKeepsSameDagShape() {
     */
        }  
        assertTrue("Root join right input must be ExchangeReducer", rootJoin.getRight() instanceof OpenSearchExchangeReducer);
        LOGGER.info("Adapted QueryDAG:\n{}", dag);
        Stage root = dag.rootStage();
     * INNER equi-join of two single-shard tables produces the expected coordinator-centric shape:
import org.apache.calcite.rel.type.RelDataType;
        assertTrue("Root join right input must be ExchangeReducer", rootJoin.getRight() instanceof OpenSearchExchangeReducer);
public class JoinPipelineEndToEndTests extends BasePlannerRulesTests {
     * </pre>
    private static final Logger LOGGER = LogManager.getLogger(JoinPipelineEndToEndTests.class);  
            assertNotNull("Child stage must have a shard target resolver", child.getTargetResolver());
        RelNode leftScan = stubScan(mockTable("test_index", "status", "size"));
     * Multi-shard variant: each join input is a 5-shard scan. Structural shape is identical to the  
     *   Child stage 1: OpenSearchTableScan (right)
        for (Stage child : root.getChildStages()) {
        // Root join's inputs are reducer-wrapped StageInputScans (post-DAG-cut shape).
        OpenSearchJoin rootJoin = (OpenSearchJoin) root.getFragment();  
    }  
 * <p>These tests double as regression anchors for the Codex findings across M0/M1/M2:
import org.apache.logging.log4j.LogManager;  
import org.opensearch.analytics.planner.PlannerImpl;
import org.apache.calcite.plan.RelOptUtil;
import org.opensearch.analytics.planner.BasePlannerRulesTests;
        // Same root-level shape as the equi case: OpenSearchJoin at the coordinator with
        QueryDAG dag = buildDagThroughAdapter(/* shards */ 3, makeInnerEquiJoin());
    /**  
import org.apache.calcite.sql.fun.SqlStdOperatorTable;
            root.getFragment() instanceof OpenSearchJoin
 * {@link BackendPlanAdapter#adaptAll}.
 *  
import org.opensearch.analytics.planner.rel.OpenSearchJoin;
     * <pre>
        // same-table joins go SHARD-local under PR's design and don't have child stages.  
            rexBuilder.makeInputRef(intType, 0),  
import org.opensearch.analytics.planner.rel.OpenSearchStageInputScan;
            SqlStdOperatorTable.EQUALS,
     * (DataFusion picks the operator from the non-equi predicate). This is the M0 path,
     * joins under M2: marker rule produces an {@link OpenSearchJoin}, the split rule demands
     * DAG topology. This test pins that invariant so future shard-count-dependent changes don't
package org.opensearch.analytics.planner.dag;
        QueryDAG dag = DAGBuilder.build(cboOutput, context.getCapabilityRegistry(), mockClusterService(), TEST_RESOLVER);
 *
 *   <li>Plan forking narrows per-stage {@code viableBackends} to a single concrete backend.</li>
        RelNode rightScan = stubScan(mockTable("test_index", "status", "size"));
 * because the mock backend in {@link BasePlannerRulesTests} doesn't ship a real  
        );  
        OpenSearchExchangeReducer leftReducer = (OpenSearchExchangeReducer) rootJoin.getLeft();
}  
        return dag;  
    }
     * Each child stage has a plan alternative narrowed to a single backend after {@code PlanForker}.
    /** Drive the first three coordinator-side passes and return the resulting DAG. */
 */  
 * quick regression.
     * Theta (non-equi) joins route through the same coordinator-centric DAG shape as equi
    /**  
    private LogicalJoin makeInnerEquiJoin() {
 * this file be licensed under the Apache-2.0 license or a
     * single-shard case — the number of shards affects target resolution at dispatch time, not the
    /**
import java.util.Set;  
 * <p>The last pipeline step ({@link FragmentConversionDriver#convertAll}) is NOT driven here
     *   Child stage 0: OpenSearchTableScan (left)  
        );
 * arrow-flight-rpc extension — doable via {@code internalClusterTest} but too heavyweight for a
        Stage root = dag.rootStage();
            assertTrue(child.getFragment() instanceof OpenSearchTableScan);
 * SPDX-License-Identifier: Apache-2.0
        assertTrue("Left reducer's input must be StageInputScan placeholder", leftReducer.getInput() instanceof OpenSearchStageInputScan);
 * compatible open source license.
        // Two child stages — one per join input.
import org.apache.calcite.rel.core.JoinRelType;  
 * that all four passes compose correctly for join queries, which exercise multi-input stage
        QueryDAG dag = buildDagThroughAdapter(/* shards */ 3, makeThetaJoin());  
        RexNode condition = rexBuilder.makeCall(
        RelDataType intType = typeFactory.createSqlType(SqlTypeName.INTEGER);  
        assertTrue("Root join left input must be ExchangeReducer", rootJoin.getLeft() instanceof OpenSearchExchangeReducer);
     *  
        RelNode leftScan = stubScan(mockTable("test_index", "status", "size"));  
            "Root stage fragment must be OpenSearchJoin, got " + root.getFragment().getClass().getSimpleName(),  
        PlanForker.forkAll(dag, context.getCapabilityRegistry());  
        OpenSearchJoin rootJoin = (OpenSearchJoin) root.getFragment();
        return LogicalJoin.create(leftScan, rightScan, List.of(), condition, Set.of(), JoinRelType.INNER);
                    "Mock DataFusion is the only join-capable backend in the harness",  
 * <ul>
import org.apache.calcite.rel.logical.LogicalJoin;
        RelNode rightScan = stubScan(mockTable("test_index", "status", "size"));
        return LogicalJoin.create(leftScan, rightScan, List.of(), condition, Set.of(), JoinRelType.INNER);  
        OpenSearchExchangeReducer rightReducer = (OpenSearchExchangeReducer) rootJoin.getRight();  
 *
/*  
     *   Root: OpenSearchJoin (coordinator)  
     */
        // two reducer-wrapped StageInputScan inputs.  
 * <p>The existing {@link DAGBuilderTests} only exercises the first two steps; these tests ensure
 * </ul>  
            rexBuilder.makeInputRef(intType, leftCols)
/**
                    alternative.backendId()
        QueryDAG dag = buildDagThroughAdapter(/* shards */ 5, makeInnerEquiJoin());  
     *   └─ OpenSearchExchangeReducer → OpenSearchStageInputScan (right)
                assertEquals(
        OpenSearchExchangeReducer leftReducer = (OpenSearchExchangeReducer) rootJoin.getLeft();  
 * shapes that aggregate/union queries don't.  
            SqlStdOperatorTable.LESS_THAN,  
        int leftCols = leftScan.getRowType().getFieldCount();  
            assertFalse(child.getPlanAlternatives().isEmpty());
        // Multi-shard so PR #21639's split rule demands COORDINATOR+SINGLETON on each input,
            }
import org.apache.calcite.rel.RelNode;
            "Root stage fragment must be OpenSearchJoin, got " + root.getFragment().getClass().getSimpleName(),  
 * Integration-style tests that exercise the <b>coordinator-side pipeline</b> for a join —  
                );  
    }
        assertEquals("Root must have exactly 2 child stages for a binary join", 2, root.getChildStages().size());
     * SINGLETON on each input regardless of the join condition, and the DAG cuts at the  
        );
        PlannerContext context = buildContext("parquet", shardCount, intFields());
        );
