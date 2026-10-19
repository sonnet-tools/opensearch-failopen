        QueryDAG dag = buildQtfDag("SELECT URL, EventDate FROM hits ORDER BY EventDate LIMIT 10", 2);
                    SqlTypeName.BIGINT,  
    }
        LOGGER.info("Marked+CBO RelNode:\n{}", RelOptUtil.toString(cboOutput));
     *   Stage 1 COORDINATOR_REDUCE   (Sort+Limit over reduce-set, ___row_id, ___ugsi)
import org.opensearch.analytics.planner.BasePlannerRulesTests;  
        RelNode logical = stubScan(mockTable("test_index", "status", "size"));
    }
                new SqlTypeName[] {
    /**  
 * clean diff of the full tree.
            mockTable(
package org.opensearch.analytics.planner.dag;
        Stage reduce = lm.getChildStages().get(0);  
import org.opensearch.analytics.planner.rel.OpenSearchTableScan;  
     * Multi-shard scan and aggregate both produce two stages. Verifies coordinator root
            dag.rootStage().getExecutionType()  
     * itself stays a pure scatter/gather/stitch and the post-LM Project (or any future
        // For a multi-shard scan, the planner inserts an OpenSearchExchangeReducer at the root.
    /**  
import org.opensearch.analytics.planner.RelNodeUtils;
        FragmentConversionDriver.convertAll(dag, context.getCapabilityRegistry());  
        OpenSearchExchangeReducer customReducer = new OpenSearchExchangeReducer(
 *
        // Outer Project: pick URL ($2) and EventDate ($4) — mirrors PPL `... | fields URL, EventDate`.
            originalReducer.getViableBackends(),  
        QueryDAG dag = DAGBuilder.build(customReducer, context.getCapabilityRegistry(), mockClusterService(), TEST_RESOLVER);
            collation,
     * because the root stage executes a backend plan locally (LOCAL_COMPUTE).
 * stage counts, targetResolver / sinkProvider presence, exchangeInfo propagation.  
                new String[] { "CounterID", "UserID", "URL", "Title", "EventDate", "AdvEngineID", "ParamPrice" },  
        RelNode cboOutput = runPlanner(logicalPlan, context);
 * The OpenSearch Contributors require contributions made to  
    }  
            false
     * <p>Repro: build {@code Sort(Filter(Scan))} directly (bypasses SQL parse which would add an outer
     *
     */
        assertEquals(StageExecutionType.SHARD_FRAGMENT, scan.getExecutionType());
        assertNull(dag.rootStage().getInputSinkDecorator());  
        RelNode cbo = runPlanner(project, context);
            originalReducer.getTraitSet(),
 *
        return dag;
        MockDataFusionBackend df = new MockDataFusionBackend() {
     * LOCAL_PASSTHROUGH instead so the stage just relays Stitcher output upward.  
                    SqlTypeName.VARCHAR,
 * Structural invariants on the {@link QueryDAG} that don't depend on the full plan shape —
        };  
        assertEquals(StageExecutionType.LATE_MATERIALIZATION, lm.getExecutionType());
import org.apache.calcite.rel.RelFieldCollation;  
import org.opensearch.analytics.planner.rel.OpenSearchValues;
            public FragmentConvertor getFragmentConvertor() {  
    }  
        var context = buildContext("parquet", 2, intFields());
            customInfo
        assertNotNull("compute leaf needs a sink provider for its local backend output", dag.rootStage().getExchangeSinkProvider());
     * but WITH an outer Project above Sort+Limit. Post-LM, Stage 3's fragment is
            StageExecutionType.LATE_MATERIALIZATION,
            sort,  
        RelNode filter = makeFilter(scan, makeEquals(2, SqlTypeName.VARCHAR, "x"));  
        QueryDAG aggDag = buildDAG(1, makeAggregate(sumCall()));
        RelNode scan = stubScan(  
    /**  
        assertEquals(1, reduce.getChildStages().size());  
    }
        assertEquals(  
        QueryDAG dag = DAGBuilder.build(cbo, context.getCapabilityRegistry(), mockClusterService(), TEST_RESOLVER);  
        assertNull("no TableScan → no ShardTargetResolver", dag.rootStage().getTargetResolver());
                "test_index",
    private QueryDAG buildQtfDag(String sql, int shardCount) {  
     * QTF wrapper ends up at the post-CBO root with NO operators above it (e.g. PPL frontends
        OpenSearchExchangeReducer reducer = (OpenSearchExchangeReducer) scanDag.rootStage().getFragment();  
        );
        LOGGER.info("QueryDAG:\n{}", dag);
        RecordingConvertor convertor = new RecordingConvertor();  
                "test_index",
        PlannerContext context = new PlannerContext(
        ImmutableList<ImmutableList<RexLiteral>> tuples = ImmutableList.of(ImmutableList.of(one));
        RelNode plan = LogicalValues.create(cluster, rowType, tuples);
        );  
import org.apache.calcite.plan.RelOptUtil;
import org.opensearch.analytics.planner.CapabilityRegistry;
     * RESULT(SINGLETON) demand without an ER, so the root stage runs on the data node directly
        QueryDAG dag = buildDAG(2, plan);
    public void testValuesRootHasNoTargetResolverButHasSink() {  
        PlannerContext context = buildContext("parquet", 2, ClickBench.BASIC_FIELDS, List.of(df, LUCENE));
    private static final Logger LOGGER = LogManager.getLogger(DAGBuilderTests.class);
import org.apache.calcite.rel.RelCollation;  
        LogicalSort sort = LogicalSort.create(
        assertNull(aggChild.getExchangeSinkProvider());
     * with zero inputs, which {@code FragmentConversionDriver.convertReduceNode} cannot handle
            List.of("URL", "EventDate")  
import org.opensearch.analytics.planner.rel.OpenSearchStageInputScan;
        Stage postLm = dag.rootStage();
        );
     * post-LM root stage to COORDINATOR_REDUCE — the fragment is a bare {@link OpenSearchStageInputScan}  
        // LM at root with no above-ops: the LM stage IS the root — no synthetic post-LM stage.
import org.apache.calcite.rel.RelNode;
     * through {@link DAGBuilder}. Returns the four-stage DAG documented at  
import org.opensearch.analytics.spi.FragmentConvertor;
     */
        assertEquals(StageExecutionType.COORDINATOR_REDUCE, reduce.getExecutionType());
        );
     * is a QTF-only attachment, not a regression on every reduce.
 */  
        assertEquals(1, postLm.getChildStages().size());
            new CapabilityRegistry(List.of(DATAFUSION, LUCENE), FieldStorageResolver::new),  
        PlanForker.forkAll(dag, context.getCapabilityRegistry());
        for (Stage child : stage.getChildStages()) {  
     * <pre>
import org.opensearch.analytics.planner.FieldStorageResolver;  
     * Project), drive through the planner + DAGBuilder + FragmentConversionDriver, assert  
                    SqlTypeName.SMALLINT,
        LOGGER.info("QueryDAG:\n{}", dag);
import com.google.common.collect.ImmutableList;
        assertNotNull(aggChild.getExchangeInfo());
        );  
        assertEquals("Values is leaf — no child stages", 0, dag.rootStage().getChildStages().size());
 */
        LogicalSort sort = LogicalSort.create(  
        RelDataType varcharType = typeFactory.createSqlType(SqlTypeName.VARCHAR);  
import org.apache.calcite.rel.type.RelDataType;
        // Build DAG + run conversion. The bug is that Stage 3 (root) gets a bare StageInputScan
        }  
    public void testSingleShardProducesSingleStageDag() {
            originalReducer.getCluster(),  
     */
        );
        assertEquals(RelDistribution.Type.SINGLETON, aggChild.getExchangeInfo().distributionType());  
     */  
        QueryDAG dag = DAGBuilder.build(cbo, context.getCapabilityRegistry(), mockClusterService(), TEST_RESOLVER);  
        assertNotNull(reduceInputScan);
        QueryDAG dag = buildDAG(3, makeAggregate(sumCall()));
     *     ↓   inputSinkDecorator = OrdinalAppendingSink (stamps shard ordinal as ___ugsi)  
        LOGGER.info("QTF QueryDAG:\n{}", dag);
import org.opensearch.analytics.planner.MockDataFusionBackend;
                    SqlTypeName.VARCHAR,
        assertTrue(scanChild.getFragment() instanceof OpenSearchTableScan);
            RelNodeUtils.findNode(lm.getFragment(), OpenSearchLateMaterialization.class)
            )  
            StageExecutionType.COORDINATOR_REDUCE,
     * DAGBuilder must not hardcode SINGLETON. Asserts that a non-singleton ExchangeInfo
     * Reducer stages outside QTF carry no {@code inputSinkDecorator} — confirms the decorator  
    }
        Stage lm = postLm.getChildStages().get(0);
        // Sort on EventDate ($4) with fetch=10 — anchor.
        QueryDAG scanDag = buildDAG(1, stubScan(mockTable("test_index", "status", "size")));  
        RelNode filter = makeFilter(scan, makeEquals(0, SqlTypeName.INTEGER, 5));  
import org.apache.calcite.rel.logical.LogicalSort;
                return convertor;
        RelDataType intType = typeFactory.createSqlType(SqlTypeName.INTEGER);
     * {@code convertAll} succeeds.
            "Stage 0 Scan rowType must carry " + OpenSearchLateMaterialization.ROW_ID_FIELD + ", got " + scanFieldNames,  
        OpenSearchLateMaterialization wrapper = RelNodeUtils.findNode(cbo, OpenSearchLateMaterialization.class);
        assertBottomUpIds(aggDag.rootStage());
        assertTrue("root fragment must be OpenSearchValues", dag.rootStage().getFragment() instanceof OpenSearchValues);  
     *     ↓
import java.util.List;
/**
        RelNode cbo = runPlanner(logical, context);  
            collation,
        QueryDAG dag = buildQtfDag("SELECT URL, EventDate FROM hits ORDER BY EventDate LIMIT 10", 2);  
    // ── QTF (late-materialization) DAG shapes ──────────────────────────────
    public void testReducerExchangeInfoFlowsToChildStage() {  
    }
     *   Stage 2 LATE_MATERIALIZATION (wrapper rooted at StageInputScan(stage 1))
                    SqlTypeName.BIGINT }
            "LM at CBO root must be promoted to rootStage; no synthetic post-LM stage",
import org.opensearch.analytics.planner.SqlPlannerTestFixture;
            null,
        assertNotNull(aggDag.rootStage().getExchangeSinkProvider());
        assertNotNull(
        RelDataType rowType = typeFactory.builder().add("a", intType).build();
        org.apache.calcite.rel.logical.LogicalProject project = org.apache.calcite.rel.logical.LogicalProject.create(
    public void testQtfDag_lmAtRoot_noOuterProject_convertsCleanly() {  
    public void testTwoStageQueries() {  
        assertNotNull("Stage 0 fragment must contain an OpenSearchTableScan", tableScan);
        RelCollation collation = RelCollations.of(new RelFieldCollation(4, RelFieldCollation.Direction.ASCENDING));
 * this file be licensed under the Apache-2.0 license or a
        assertNotNull("LM cut must install OrdinalAppendingSink decorator on reducer", reduce.getInputSinkDecorator());
        RelNode scan = stubScan(  
import org.opensearch.analytics.planner.PlannerContext;
    private QueryDAG buildDAG(int shardCount, RelNode logicalPlan) {
            RelNodeUtils.findNode(dag.rootStage().getFragment(), OpenSearchLateMaterialization.class)
import org.opensearch.analytics.planner.rel.OpenSearchLateMaterialization;
    /**
            rexBuilder.makeLiteral(10, typeFactory.createSqlType(SqlTypeName.INTEGER), true)  
    /**  
        assertTrue(reducer.getInput() instanceof OpenSearchStageInputScan);
        PlanForker.forkAll(dag, context.getCapabilityRegistry());
        );
     * Literal-row source (LogicalValues / OpenSearchValues): a coordinator-local compute leaf
        // datafusion mock backend so FragmentConversionDriver.convertAll has something to call.
     * that don't add an outer Project around Sort+Limit). DAGBuilder must NOT route the resulting
    /**
     * Stage 0's shard fragment must propagate {@code __row_id__} on its Scan output. The
                    SqlTypeName.VARCHAR,
        );
        Stage child = dag.rootStage().getChildStages().get(0);
        LOGGER.info("Input RelNode:\n{}", RelOptUtil.toString(logicalPlan));  
            @Override
        OpenSearchStageInputScan reduceInputScan = RelNodeUtils.findNode(reduce.getFragment(), OpenSearchStageInputScan.class);  
import org.apache.calcite.rex.RexLiteral;
        assertBottomUpIds(dag.rootStage());  
            assertBottomUpIds(child);
            filter,  
    /**
        // mockTable's columns mirror ClickBench's BASIC_FIELDS so QTF detects fetch-only fields.
        QueryDAG dag = DAGBuilder.build(cboOutput, context.getCapabilityRegistry(), mockClusterService(), TEST_RESOLVER);  
            scanFieldNames.contains(OpenSearchLateMaterialization.ROW_ID_FIELD)
import org.apache.calcite.rel.RelDistribution;
        QueryDAG aggDag = buildDAG(2, makeAggregate(sumCall()));  
     * The reducer's own {@link ExchangeInfo} must flow into the cut child stage —
     * {@code Project(StageInputScan)} — real coordinator-side compute. Must be
            }
                    SqlTypeName.INTEGER,
            "StageInputScan rowType must include " + OpenSearchLateMaterialization.UGSI_FIELD,
        assertNotNull(scanChild.getTargetResolver());  
    public void testQtfDag_lmAtRoot_withOuterProject_isCoordReduce() {
import org.opensearch.analytics.planner.PlannerImpl;  
        PlannerContext context = buildContext("parquet", 2, ClickBench.BASIC_FIELDS, List.of(df, LUCENE));
 * <p>Exact-string DAG-shape tests that lock in the {@link QueryDAG#toString()} output live in
 * compatible open source license.
     * Single-shard plans produce a single-stage DAG: SOURCE(SINGLETON) satisfies the root's
            )  
import org.opensearch.analytics.planner.rel.OpenSearchExchangeReducer;  
    }  
                    SqlTypeName.INTEGER,
        assertEquals(StageExecutionType.SHARD_FRAGMENT, scan.getExecutionType());  
        FragmentConversionDriver.convertAll(dag, context.getCapabilityRegistry());  
            @Override
                    SqlTypeName.SMALLINT,
     * with no TableScan in the fragment. DAGBuilder must (1) skip {@code ShardTargetResolver}
        Stage scan = dag.rootStage().getChildStages().getFirst().getChildStages().getFirst().getChildStages().getFirst();
    /**
        ExchangeInfo customInfo = ExchangeInfo.hashDistributed(List.of(0), /* partitionCount */ 2);
            assertTrue("child stageId must be lower than parent", child.getStageId() < stage.getStageId());
            "post-LM root with above-ops must be COORDINATOR_REDUCE",
     */
    /**
}  
        Stage aggChild = aggDag.rootStage().getChildStages().get(0);
        assertNotNull("QTF should fire", wrapper);  
        assertEquals(0, scan.getChildStages().size());  
     * (TableScan leaf, non-null targetResolver, correct ExchangeInfo).
        // and convertReduceNode trips on getInputs().getFirst().
                    SqlTypeName.DATE,  
        );  
public class DAGBuilderTests extends BasePlannerRulesTests {  
        OpenSearchLateMaterialization wrapper = RelNodeUtils.findNode(cbo, OpenSearchLateMaterialization.class);  
     * structure (ExchangeReducer → StageInputScan, null targetResolver) and child structure  
    }
            "LM fragment must contain OpenSearchLateMaterialization wrapper",
        assertNotSame("Outer Project should sit above the LM wrapper", wrapper, RelNodeUtils.unwrapHep(cbo));
        );
            mockTable(
        );
     * </pre>
        // Stage 3 has real compute (the Project) on top of the StageInputScan → COORDINATOR_REDUCE.
/*  
            originalReducer.getInput(),
        assertEquals(customInfo, child.getExchangeInfo());  
        };  
     * {@link #testQtfDag_multiShardFourStages}.
     * Filter/Aggregate/Sort) runs on Substrait via the standard reduce path.
        );
        var context = buildContext("parquet", shardCount, intFields());
        assertNull(scanDag.rootStage().getTargetResolver());
        assertEquals(0, aggDag.rootStage().getChildStages().size());  
        assertEquals(1, scanDag.rootStage().getChildStages().size());  
import org.opensearch.analytics.planner.ClickBench;
        RelDataType dateType = typeFactory.createSqlType(SqlTypeName.DATE);
            List.of(rexBuilder.makeInputRef(varcharType, 2), rexBuilder.makeInputRef(dateType, 4)),
     */
     * DataFusion fails the registration with "No field named __row_id__".  
    private static void assertBottomUpIds(Stage stage) {
        return dag;
        // Build LogicalSort(LogicalFilter(stubScan)) — no Project anywhere above the anchor.
        // ILIKE on URL ($2) — fetch-only column not in the anchor's sort key.
     * Drives SQL through the full planner so the QTF rewriter fires, then runs the result
        assertBottomUpIds(scanDag.rootStage());
     * future shuffle/broadcast strategies work without DAGBuilder changes.
 * SPDX-License-Identifier: Apache-2.0
                new SqlTypeName[] {
        assertNotNull("QTF rewriter should fire (URL fetch-only)", wrapper);
        assertEquals(1, lm.getChildStages().size());
     * COORDINATOR_REDUCE so the convertor serializes the Project for execution.  
import org.opensearch.cluster.ClusterState;  
        assertNull(aggDag.rootStage().getTargetResolver());  
        assertEquals(StageExecutionType.COORDINATOR_REDUCE, dag.rootStage().getExecutionType());
        assertSame("LM wrapper should be at the root (no Project above)", wrapper, RelNodeUtils.unwrapHep(cbo));
import org.apache.logging.log4j.LogManager;
        assertEquals(StageExecutionType.COORDINATOR_REDUCE, postLm.getExecutionType());  
    }  
            List.of(),
        assertEquals(0, scanDag.rootStage().getChildStages().size());
            filter,
        assertNull("scan stage carries no input decorator", scan.getInputSinkDecorator());
                    SqlTypeName.VARCHAR,
        );
        assertEquals(0, reduceInputScan.getChildStageId());
     * {@code input-0.__row_id__} but the partition exposes only the physical cols and
        RelCollation collation = RelCollations.of(new RelFieldCollation(4, RelFieldCollation.Direction.ASCENDING));
            public FragmentConvertor getFragmentConvertor() {  
        LOGGER.info("Post-CBO/LM RelNode:\n{}", RelOptUtil.toString(cbo));  
     */
        RelNode parsed = SqlPlannerTestFixture.parseSql(sql, state);
     */
        // StageInputScan must carry ___ugsi — cutAtExchange uses the reducer's output rowType.
     * attachment because there's no shard to target, and (2) still install a sink provider  
     *     ↓
            reduceInputScan.getRowType().getFieldNames().contains(OpenSearchLateMaterialization.UGSI_FIELD)
                    SqlTypeName.DATE,  
    /**  
            }
     * override rowType; this asserts that override survives DAG cuts so the converted  
     *
                return convertor;
        assertEquals(1, aggDag.rootStage().getChildStages().size());
            "rootStage must contain the LM wrapper",  
            rexBuilder.makeLiteral(10, typeFactory.createSqlType(SqlTypeName.INTEGER), true)
    }
    public void testReducerHasNoInputSinkDecoratorForNonQtf() {  
 * {@link DAGShapeTests} — those catch regressions in fragment placement or stage cuts via a  
        RexLiteral one = (RexLiteral) rexBuilder.makeLiteral(1, intType, true);  
     * Multi-shard QTF produces four stages, dataflow runs bottom-up from shards to the post-LM  
        QueryDAG scanDag = buildDAG(5, stubScan(mockTable("test_index", "status", "size")));
        OpenSearchTableScan tableScan = RelNodeUtils.findNode(scan.getFragment(), OpenSearchTableScan.class);
        assertTrue(  
            state,
     * <p>Stage 3 is the post-LM compute stage, separated by {@link DAGBuilder} so the LM stage  
        LOGGER.info("QueryDAG:\n{}", dag);
     * coordinator reduce:
     * Substrait declares the helper column. Without it, Stage 1's reduce plan references
        assertNotNull(scanDag.rootStage().getTargetResolver());
     *   Stage 0 SHARD_FRAGMENT       (Filter? + Scan)  
     * and has a target resolver (no coord/child split).  
        List<String> scanFieldNames = tableScan.getRowType().getFieldNames();
        MockDataFusionBackend df = new MockDataFusionBackend() {
        assertNotNull(aggDag.rootStage().getTargetResolver());
            dag.rootStage().getExecutionType()  
        QueryDAG dag = DAGBuilder.build(cbo, context.getCapabilityRegistry(), mockClusterService(), TEST_RESOLVER);  
                new String[] { "CounterID", "UserID", "URL", "Title", "EventDate", "AdvEngineID", "ParamPrice" },  
        OpenSearchExchangeReducer originalReducer = (OpenSearchExchangeReducer) cbo;
        assertNotNull(aggChild.getTargetResolver());  
            null,  
        // Drive through marking + CBO + LM rewrite. RecordingConvertor swapped onto the
     */
        assertNotNull("scan stage must have a target resolver", scan.getTargetResolver());
        RecordingConvertor convertor = new RecordingConvertor();  
        Stage scanChild = scanDag.rootStage().getChildStages().get(0);
     * Contrast to {@link #testQtfDag_lmAtRoot_noOuterProject_convertsCleanly}: SAME query shape  
        assertTrue(scanDag.rootStage().getFragment() instanceof OpenSearchTableScan);  
        Stage scan = reduce.getChildStages().get(0);
        assertTrue(
        // QTF must have fired (LM wrapper present) and there must be no Project above it.
import org.apache.calcite.sql.type.SqlTypeName;  
        assertNull("post-LM reduce carries no input decorator", postLm.getInputSinkDecorator());
     * placed on the reducer survives the cut, which is the contract that lets  
     */
        assertTrue(scanDag.rootStage().getFragment() instanceof OpenSearchExchangeReducer);
        RelNode cbo = runPlanner(sort, context);
    public void testQtfDag_stage0ScanCarriesRowIdHelper() {
     *   Stage 3 COORDINATOR_REDUCE   (post-LM ops: outer Project, etc.)  ← root  
import org.apache.calcite.rel.RelCollations;
        assertNotNull(  
     * (falls through to {@code getInputs().getFirst()} → NoSuchElementException). Route to
                    SqlTypeName.BIGINT,  
                    SqlTypeName.BIGINT }
     * rewriter narrows the Scan to {@code [belowAnchorPhysicalFields..., __row_id__]} via an
        LOGGER.info("Post-CBO/LM RelNode:\n{}", RelOptUtil.toString(cbo));  
    }  
        ClusterState state = SqlPlannerTestFixture.clusterStateWith(ClickBench.INDEX, ClickBench.BASIC_FIELDS, "parquet", shardCount);
    public void testQtfDag_multiShardFourStages() {
        RelNode cbo = PlannerImpl.runAllOptimizations(parsed, context);
        // Filter on CounterID ($0) so filter/sort cols don't subsume the project — keeps URL fetch-only.
        assertEquals(  
import org.apache.logging.log4j.Logger;
import org.apache.calcite.rel.logical.LogicalValues;  
