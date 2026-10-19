                    makeCall(
        Stage stage = root;
    }  
            assertTrue(plan.resolvedFragment() instanceof OpenSearchSort);  
     * Forking at the root stage is limited to backends that can reduce (only mock-parquet in  
package org.opensearch.analytics.planner.dag;
     * Constant predicate (1=1) must be eliminated by ReduceExpressionsRule before marking.
        // Sort(Agg(Filter(Scan))) with limit — multi-shard so split fires, root stage is FINAL+Sort  
    /**  
        QueryDAG dag = buildAndFork(2, makeAggregate(sumCall()));
        QueryDAG sortAggDag = buildAndFork(
 * this file be licensed under the Apache-2.0 license or a
    /**
    public void testSortQueryShapes() {  
 *
            /* all */ true  
        QueryDAG dag = buildAndFork(
        // Sort(Filter(Scan)) with limit — multi-shard so root-demand SINGLETON requires a gather,
    public void testMixedAggCallsWithAndWithoutFieldArgs() {
        // Child data node stage — two alternatives
        assertTwoAlternatives(dag.rootStage(), OpenSearchAggregate.class);  
                expectedRootType.isInstance(plan.resolvedFragment())  
        LOGGER.info("Marked+CBO RelNode:\n{}", RelOptUtil.toString(cboOutput));  
import org.opensearch.analytics.planner.rel.OpenSearchAggregate;
import java.util.Set;  
            if (stage.getChildStages().isEmpty()) return stage;  
     *
                "viableBackends must be narrowed to single backend",  
        assertEquals(1, dag.rootStage().getPlanAlternatives().size());
                    SqlStdOperatorTable.SUM,
            assertEquals(
            SqlStdOperatorTable.EQUALS,
        }
        // which narrows the root stage to reduce-capable backends.
        assertEquals(1, sortFilterRoot.getPlanAlternatives().size());
import org.opensearch.analytics.planner.MockDataFusionBackend;  
            1,  
                stubScan(mockTable("test_index", "status", "size")),
                    sumCall()  
     * TODO: add delegation-aware forking tests once delegation is implemented — verify that when
     * resolves to exactly one DataFusion alternative.
    /**
     * Sort(Filter(Scan)) and Sort(Agg(Filter(Scan))) with limit — collated Sort always requires
            makeMultiCallAggregate(
        while (!(stage.getFragment() instanceof OpenSearchSort)) {
        assertTwoAlternatives(aggDag.rootStage(), OpenSearchAggregate.class);  
        QueryDAG dag = buildAndForkUnionCapable(1, union);
        RexNode constant = rexBuilder.makeCall(
    /**  
                    makeEquals(0, SqlTypeName.INTEGER, 200),
        Stage sortFilterRoot = effectiveSortRoot(sortFilterDag.rootStage());  
     * QTF wraps the original sort+limit reduce inside a 4-stage spine: post-LM COORDINATOR_REDUCE
        PlanForker.forkAll(dag, context.getCapabilityRegistry());
     * EXECUTION(SINGLETON), so the plan has an ER between the Sort and the scan subtree.
            List.of(stubScan(mockTable("test_index", "status", "size")), stubScan(mockTable("test_index", "status", "size"))),
     * (root) → LATE_MATERIALIZATION → sort+limit COORDINATOR_REDUCE → SHARD_FRAGMENT. Descend
            protected Set<ScanCapability> scanCapabilities() {
import org.opensearch.analytics.spi.AggregateFunction;
        return stage;  
                makeAggregate(
            stage = stage.getChildStages().getFirst();
            @Override
            @Override
            LogicalFilter.create(
                    false,  
    /**  
        // ReduceExpressionsRule folds 1=1 → TRUE, then filter on TRUE is removed.
 *
import org.opensearch.analytics.planner.rel.OpenSearchFilter;  
            protected Set<EngineCapability> supportedEngineCapabilities() {
 * to exactly one backend.
        QueryDAG sortFilterDag = buildAndFork(  
public class PlanForkerTests extends BasePlannerRulesTests {
        // QTF rewriter inserts a LATE_MATERIALIZATION root stage above the original Sort+Limit
            @Override
        QueryDAG filterDag = buildAndFork(
        LOGGER.info("Marked+CBO RelNode:\n{}", RelOptUtil.toString(cboOutput));
     * these tests) → one alternative per stage, not two.
            );
        Stage child = dag.rootStage().getChildStages().getFirst();
                    stubScan(mockTable("test_index", "status", "size")),  
     * Mixed aggregate: SUM(size), COUNT(*), SUM(status) — COUNT(*) has no field args.
/**
            )
        FieldType.LONG,
import java.util.List;
     * collection and replacement are consistent across multiple predicates.
        QueryDAG aggDag = buildAndFork(1, makeAggregate(sumCall()));
        for (StagePlan plan : alternatives) {  
    private static void assertTwoAlternatives(Stage stage, Class<? extends OpenSearchRelNode> expectedRootType) {
    }  
                    List.of(0),
        }  
 * are viable, verifying that forking produces two alternatives and each is narrowed
    private QueryDAG buildAndFork(int shardCount, RelNode logicalPlan) {
        };
                )
        }  
     */
            LogicalFilter.create(stubScan(mockTable("test_index", "status", "size")), makeEquals(0, SqlTypeName.INTEGER, 200))
                Set.of(plan.backendId())
        MockLuceneBackend luceneWithScanAndAgg = new MockLuceneBackend() {
     * <em>first</em> alternative ({@code getFirst()}), which is the Lucene scan. The DataFusion-only  
            protected Set<AggregateCapability> aggregateCapabilities() {  
                caps.add(EngineCapability.UNION);
                10
        return dag;
                        rexBuilder.makeLiteral(100, typeFactory.createSqlType(SqlTypeName.INTEGER), true)
     * down the first-child chain until we hit the stage whose fragment is the OpenSearchSort the  
    public void testMultiInputForksChildToParentBackend() {  
            makeSort(  
    public void testComposedPipelineForking() {  
        );
                1,
    }
                    makeFilter(stubScan(mockTable("test_index", "status", "size")), makeEquals(1, SqlTypeName.INTEGER, 200)),
                Set<EngineCapability> caps = new java.util.HashSet<>(super.supportedEngineCapabilities());
     */
    /** Multi-shard aggregate — child stage gets two alternatives, root gets one (only DF has ExchangeSinkProvider). */  
        assertEquals(1, sortAggRoot.getPlanAlternatives().size());  
        for (StagePlan plan : alternatives) {
        MockDataFusionBackend unionCapableDf = new MockDataFusionBackend() {
        FieldType.BOOLEAN
import org.opensearch.analytics.planner.rel.OpenSearchRelNode;
     * annotations consistently through the entire tree: both the aggregate root and the
 * SPDX-License-Identifier: Apache-2.0
            }
                return aggCaps(
        PlanForker.forkAll(dag, context.getCapabilityRegistry());
    private QueryDAG buildAndForkUnionCapable(int shardCount, RelNode logicalPlan) {  
                        rexBuilder.makeInputRef(typeFactory.createSqlType(SqlTypeName.INTEGER), 1),
    }
import org.opensearch.analytics.spi.AggregateCapability;
                    "total_status"
            );
        QueryDAG dag = buildAndFork(1, pipeline);
import org.apache.calcite.plan.RelOptUtil;
            rexBuilder.makeLiteral(1, typeFactory.createSqlType(SqlTypeName.INTEGER), true),  
     * Union then had {@code viableBackends ∩ {lucene} = ∅}, so it produced <b>zero</b> plan
 * Tests for {@link PlanForker} — verifies plan alternatives are generated correctly  
        }
        FieldType.KEYWORD,
import org.opensearch.analytics.planner.rel.OpenSearchSort;
            3,
    }
     * alternatives — later surfacing as a {@code NoSuchElementException} at execution. The forker must
        // reduce stage; this test was written pre-QTF to assert on the Sort stage. Skip past LM.
        assertTwoAlternatives(filterDag.rootStage(), OpenSearchFilter.class);  
                ),
     * (e.g. DF operator with Lucene annotation for filter delegation produces a separate alternative).  
            }
                ((OpenSearchRelNode) plan.resolvedFragment()).getViableBackends().size()
    }
    }
                return Set.of(EngineCapability.SORT);  
import org.apache.logging.log4j.Logger;
     */  
                return Set.of(new ScanCapability.DocValues(Set.of(MockLuceneBackend.LUCENE_DATA_FORMAT), SUPPORTED_TYPES));  
        assertNotEquals("both alternatives must have distinct backends", alternatives.get(0).backendId(), alternatives.get(1).backendId());  
import java.util.Map;
        RelNode pipeline = makeAggregate(
        // Root coordinator stage — only DF has ExchangeSinkProvider
            makeSort(makeFilter(stubScan(mockTable("test_index", "status", "size")), makeEquals(0, SqlTypeName.INTEGER, 200)), 10)
import org.apache.calcite.sql.fun.SqlStdOperatorTable;
        FieldType.DATE,  
        assertEquals("expected two alternatives (one per viable backend)", 2, alternatives.size());
        LOGGER.info("Input RelNode:\n{}", RelOptUtil.toString(logicalPlan));
    );
        assertFalse("filter on constant true must be eliminated", result instanceof OpenSearchFilter);  
        };
 */  
import org.opensearch.analytics.spi.FieldType;
        assertTwoAlternatives(dag.rootStage(), OpenSearchFilter.class);
            makeFilter(stubScan(mockTable("test_index", "status", "size")), makeEquals(0, SqlTypeName.INTEGER, 200)),
     */
        RelNode cboOutput = runPlanner(logicalPlan, context);
     * Filter with AND of two annotated predicates — verifies tree-walk annotation
import org.apache.calcite.rel.core.AggregateCall;  
            3,
        RelNode result = runPlanner(filter, context);
            1,  
    public void testMultiShardAggregateForksAllStages() {
        assertTwoAlternatives(dag.rootStage(), OpenSearchAggregate.class);  
        );  
        // to a constant would bound it to one row and SORT_REMOVE_REDUNDANT would drop the Sort.  
                return Set.of(new ScanCapability.DocValues(Set.of(MockLuceneBackend.LUCENE_DATA_FORMAT), SUPPORTED_TYPES));
 * compatible open source license.
import org.opensearch.analytics.planner.BasePlannerRulesTests;
        var context = buildContext("parquet", 1, intFields());  
                    )  
                    typeFactory.createSqlType(SqlTypeName.INTEGER),
            assertPipelineViableBackends(
import org.apache.calcite.rex.RexNode;  
        var context = buildContextWithExplicitStorage(shardCount, duplicatedIntFields(), List.of(DATAFUSION, luceneWithScanAndAgg));  
    /** Like {@link #buildAndFork} but the DataFusion backend opts into {@code EngineCapability.UNION}. */
        );
 */  
            assertTrue(plan.resolvedFragment() instanceof OpenSearchSort);
        }
                List.of(OpenSearchAggregate.class, OpenSearchFilter.class, OpenSearchTableScan.class),  
import org.apache.logging.log4j.LogManager;  
        assertTrue("root must be the scan after filter elimination", result instanceof OpenSearchTableScan);
        QueryDAG scanDag = buildAndFork(1, stubScan(mockTable("test_index", "status", "size")));
        assertFalse("Union over dual-viable scans must produce a resolvable plan, not an empty list", alternatives.isEmpty());
                plan.resolvedFragment(),
        for (StagePlan plan : sortAggRoot.getPlanAlternatives()) {
        assertTwoAlternatives(child, OpenSearchAggregate.class);  
            assertEquals("Union resolves to the only backend that supports it", MockDataFusionBackend.NAME, plan.backendId());
        QueryDAG dag = buildAndFork(
        assertTwoAlternatives(scanDag.rootStage(), OpenSearchTableScan.class);  
                makeAnd(  
            sumCall()  
     */  
    }
                countStarCall(),  
     * <p>Regression for the multi-input forking bug: {@code resolve()} used to take each child's
        QueryDAG dag = DAGBuilder.build(cboOutput, context.getCapabilityRegistry(), mockClusterService(), TEST_RESOLVER);  
     * Aggregate(Filter(Scan)) — most common OLAP shape. Verifies that forking narrows
     * annotation viable backends differ from operator backend, one plan per annotation target is generated
        );
import org.apache.calcite.rel.logical.LogicalUnion;
                        SqlStdOperatorTable.GREATER_THAN,  
     * instead pick the child alternative whose backend the parent can use (DataFusion), so the Union  
            )
            protected Set<ScanCapability> scanCapabilities() {
import org.opensearch.analytics.planner.rel.OpenSearchTableScan;  
    /**
            protected Set<EngineCapability> supportedEngineCapabilities() {  
                return caps;  
        List<StagePlan> alternatives = dag.rootStage().getPlanAlternatives();
     * A {@code Union} that only one backend supports (DataFusion has {@code EngineCapability.UNION};
     */
            @Override
     * Asserts a stage has exactly two alternatives (one per backend), each narrowed to a single backend.
            rexBuilder.makeLiteral(1, typeFactory.createSqlType(SqlTypeName.INTEGER), true)
            assertNotNull(plan.resolvedFragment());  
     * TODO: extend with randomized tests that pick N backends from a pool and assert exactly N alternatives.  
     * filter child in each alternative must be narrowed to the same single backend.  
import org.opensearch.analytics.spi.ScanCapability;
 * The OpenSearch Contributors require contributions made to  
                sumCall(),
        // Each alternative's full pipeline must be narrowed to the same single backend
        // column) so the aggregate keeps an unbounded group count; filtering the group key `status`
                    Set.of(MockLuceneBackend.LUCENE_DATA_FORMAT),
        LogicalFilter filter = LogicalFilter.create(stubScan(mockTable("test_index", "status", "size")), constant);  
    }
        return dag;
        Stage sortAggRoot = effectiveSortRoot(sortAggDag.rootStage());
        }
        List<StagePlan> alternatives = stage.getPlanAlternatives();  
     * alternatives where operator backend ≠ annotation backend — this assertion will need  
                    0,
import org.opensearch.analytics.planner.MockLuceneBackend;
                )  
        FieldType.INTEGER,  
import org.apache.calcite.sql.type.SqlTypeName;
        for (StagePlan plan : dag.rootStage().getPlanAlternatives()) {  
        QueryDAG dag = DAGBuilder.build(cboOutput, context.getCapabilityRegistry(), mockClusterService(), TEST_RESOLVER);
            )  
                    Map.of(AggregateFunction.SUM, Set.of(FieldType.INTEGER), AggregateFunction.COUNT, Set.of(FieldType.INTEGER))  
     * to be relaxed or split per delegation strategy.
 * for different query shapes with two viable backends.
}
     * All three get annotated. Verifies forking handles the mix without index misalignment.
            );  
            1,  
    public void testConstantPredicateEliminated() {
    public void testSingleStageQueryShapes() {
        );
        LOGGER.info("QueryDAG after forking:\n{}", dag);  
    private static final Set<FieldType> SUPPORTED_TYPES = Set.of(
        // over an ER, narrowed to reduce-capable backends. Filter pins `size` (field 1, a non-group
import org.opensearch.analytics.spi.EngineCapability;  
        MockLuceneBackend luceneScan = new MockLuceneBackend() {  
     */
            @Override  
                AggregateCall.create(
                "resolved fragment root must be " + expectedRootType.getSimpleName(),
        };
    /** Single-shard scan, filter, and aggregate — two alternatives each, one per backend. */  
     * TODO: with delegation, a DF aggregate over a Lucene-delegated filter would produce
    /**  
    }
        var context = buildContextWithExplicitStorage(shardCount, duplicatedIntFields(), List.of(unionCapableDf, luceneScan));  
            assertTrue(
     * The filter disappears entirely — the root of the marked tree is the scan, not a filter.  
import org.apache.calcite.rel.RelNode;
    }
     * Lucene does not) over dual-viable scans (both backends viable for the scan, Lucene listed first).  
    }
                );
    private static final Logger LOGGER = LogManager.getLogger(PlanForkerTests.class);  
     * pre-QTF assertions expect.
/*  
        RelNode cboOutput = runPlanner(logicalPlan, context);
import org.apache.calcite.rel.logical.LogicalFilter;
        );
     *
     */
        );  
            assertEquals(plan.backendId(), ((OpenSearchRelNode) plan.resolvedFragment()).getViableBackends().getFirst());
        for (StagePlan plan : sortFilterRoot.getPlanAlternatives()) {
    private static Stage effectiveSortRoot(Stage root) {  
    /**  
        RelNode union = LogicalUnion.create(
 * <p>All tests use duplicated doc values (both parquet and lucene) so both backends  
            }  
            }
        );
    public void testFilterWithMultipleAnnotatedPredicates() {
            }
