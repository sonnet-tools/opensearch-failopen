        Stage sortAggRoot = effectiveSortRoot(sortAggDag.rootStage());
        assertTwoAlternatives(dag.rootStage(), OpenSearchFilter.class);
                    "total_status"
            @Override
        // Each alternative's full pipeline must be narrowed to the same single backend
    /**
            sumCall()
import org.opensearch.analytics.spi.ScanCapability;
            assertNotNull(plan.resolvedFragment());
        QueryDAG dag = buildAndFork(2, makeAggregate(sumCall()));
        );
            protected Set<ScanCapability> scanCapabilities() {
            protected Set<EngineCapability> supportedEngineCapabilities() {
     * pre-QTF assertions expect.
    public void testComposedPipelineForking() {
     * TODO: extend with randomized tests that pick N backends from a pool and assert exactly N alternatives.
        // Child data node stage — two alternatives
     * Sort(Filter(Scan)) and Sort(Agg(Filter(Scan))) with limit — collated Sort always requires
    private QueryDAG buildAndFork(int shardCount, RelNode logicalPlan) {
     * QTF wraps the original sort+limit reduce inside a 4-stage spine: post-LM COORDINATOR_REDUCE
            3,
/*
    }
            assertPipelineViableBackends(
                makeAnd(
        QueryDAG dag = DAGBuilder.build(cboOutput, context.getCapabilityRegistry(), mockClusterService(), TEST_RESOLVER);
     */
import org.apache.calcite.rel.logical.LogicalUnion;
            LogicalFilter.create(stubScan(mockTable("test_index", "status", "size")), makeEquals(0, SqlTypeName.INTEGER, 200))
     * TODO: with delegation, a DF aggregate over a Lucene-delegated filter would produce
    public void testMixedAggCallsWithAndWithoutFieldArgs() {
            );
                ),
        FieldType.DATE,
import org.apache.calcite.sql.type.SqlTypeName;
 *
        for (StagePlan plan : sortAggRoot.getPlanAlternatives()) {
        assertTwoAlternatives(child, OpenSearchAggregate.class);
        Stage sortFilterRoot = effectiveSortRoot(sortFilterDag.rootStage());
        FieldType.LONG,
                "resolved fragment root must be " + expectedRootType.getSimpleName(),
                    SqlStdOperatorTable.SUM,
            );
            assertEquals(plan.backendId(), ((OpenSearchRelNode) plan.resolvedFragment()).getViableBackends().getFirst());
import org.apache.calcite.plan.RelOptUtil;
    }
            makeSort(makeFilter(stubScan(mockTable("test_index", "status", "size")), makeEquals(0, SqlTypeName.INTEGER, 200)), 10)
    }
    }
import java.util.List;
                List.of(OpenSearchAggregate.class, OpenSearchFilter.class, OpenSearchTableScan.class),
import org.opensearch.analytics.spi.FieldType;
    /**
        List<StagePlan> alternatives = stage.getPlanAlternatives();
        PlanForker.forkAll(dag, context.getCapabilityRegistry());
    private static void assertTwoAlternatives(Stage stage, Class<? extends OpenSearchRelNode> expectedRootType) {
        QueryDAG aggDag = buildAndFork(1, makeAggregate(sumCall()));
     * down the first-child chain until we hit the stage whose fragment is the OpenSearchSort the
        RelNode cboOutput = runPlanner(logicalPlan, context);
        assertEquals(1, dag.rootStage().getPlanAlternatives().size());
                return Set.of(new ScanCapability.DocValues(Set.of(MockLuceneBackend.LUCENE_DATA_FORMAT), SUPPORTED_TYPES));
 * Tests for {@link PlanForker} — verifies plan alternatives are generated correctly
     */
    }
            3,
     * alternatives where operator backend ≠ annotation backend — this assertion will need
    private static final Logger LOGGER = LogManager.getLogger(PlanForkerTests.class);
        FieldType.BOOLEAN
    }
            protected Set<EngineCapability> supportedEngineCapabilities() {
        LOGGER.info("Input RelNode:\n{}", RelOptUtil.toString(logicalPlan));
     * EXECUTION(SINGLETON), so the plan has an ER between the Sort and the scan subtree.
    public void testConstantPredicateEliminated() {
            rexBuilder.makeLiteral(1, typeFactory.createSqlType(SqlTypeName.INTEGER), true),
                    Set.of(MockLuceneBackend.LUCENE_DATA_FORMAT),
            makeFilter(stubScan(mockTable("test_index", "status", "size")), makeEquals(0, SqlTypeName.INTEGER, 200)),
                )
    public void testFilterWithMultipleAnnotatedPredicates() {
import org.opensearch.analytics.planner.rel.OpenSearchSort;
        QueryDAG dag = buildAndFork(
        MockLuceneBackend luceneWithScanAndAgg = new MockLuceneBackend() {
                )
        LogicalFilter filter = LogicalFilter.create(stubScan(mockTable("test_index", "status", "size")), constant);
                Set<EngineCapability> caps = new java.util.HashSet<>(super.supportedEngineCapabilities());
                    List.of(0),
import org.opensearch.analytics.spi.AggregateFunction;
        for (StagePlan plan : alternatives) {
            )
import org.opensearch.analytics.planner.rel.OpenSearchTableScan;
        assertFalse("filter on constant true must be eliminated", result instanceof OpenSearchFilter);
                );
                countStarCall(),
     * (e.g. DF operator with Lucene annotation for filter delegation produces a separate alternative).
            }
        RelNode pipeline = makeAggregate(
            assertEquals("Union resolves to the only backend that supports it", MockDataFusionBackend.NAME, plan.backendId());
        assertNotEquals("both alternatives must have distinct backends", alternatives.get(0).backendId(), alternatives.get(1).backendId());
            assertEquals(
        }
        assertEquals(1, sortFilterRoot.getPlanAlternatives().size());
    }
                    Map.of(AggregateFunction.SUM, Set.of(FieldType.INTEGER), AggregateFunction.COUNT, Set.of(FieldType.INTEGER))
    /**
                makeAggregate(
    /**
                return aggCaps(
        FieldType.INTEGER,
     * to be relaxed or split per delegation strategy.
                    sumCall()
        var context = buildContextWithExplicitStorage(shardCount, duplicatedIntFields(), List.of(DATAFUSION, luceneWithScanAndAgg));
        FieldType.KEYWORD,
    private static final Set<FieldType> SUPPORTED_TYPES = Set.of(
        var context = buildContext("parquet", 1, intFields());
            @Override
        QueryDAG dag = buildAndFork(1, pipeline);
            1,
    private static Stage effectiveSortRoot(Stage root) {
                Set.of(plan.backendId())
 * this file be licensed under the Apache-2.0 license or a
        MockDataFusionBackend unionCapableDf = new MockDataFusionBackend() {
        QueryDAG dag = buildAndFork(
                sumCall(),
     * Mixed aggregate: SUM(size), COUNT(*), SUM(status) — COUNT(*) has no field args.
            protected Set<ScanCapability> scanCapabilities() {
import org.opensearch.analytics.planner.MockDataFusionBackend;
            LogicalFilter.create(
                return Set.of(new ScanCapability.DocValues(Set.of(MockLuceneBackend.LUCENE_DATA_FORMAT), SUPPORTED_TYPES));
import java.util.Map;
        assertTwoAlternatives(dag.rootStage(), OpenSearchAggregate.class);
        QueryDAG dag = buildAndForkUnionCapable(1, union);
     * instead pick the child alternative whose backend the parent can use (DataFusion), so the Union
 */
 * for different query shapes with two viable backends.
                        SqlStdOperatorTable.GREATER_THAN,
import org.opensearch.analytics.planner.rel.OpenSearchFilter;
        // Sort(Agg(Filter(Scan))) with limit — multi-shard so split fires, root stage is FINAL+Sort
     */
    public void testSortQueryShapes() {
    }
        LOGGER.info("Marked+CBO RelNode:\n{}", RelOptUtil.toString(cboOutput));
     * Aggregate(Filter(Scan)) — most common OLAP shape. Verifies that forking narrows
    /** Multi-shard aggregate — child stage gets two alternatives, root gets one (only DF has ExchangeSinkProvider). */
 * compatible open source license.
     * All three get annotated. Verifies forking handles the mix without index misalignment.
                        rexBuilder.makeInputRef(typeFactory.createSqlType(SqlTypeName.INTEGER), 1),
 * to exactly one backend.
        for (StagePlan plan : dag.rootStage().getPlanAlternatives()) {
import org.opensearch.analytics.planner.MockLuceneBackend;
        RelNode union = LogicalUnion.create(
        for (StagePlan plan : sortFilterRoot.getPlanAlternatives()) {
        );
     * collection and replacement are consistent across multiple predicates.
        };
     * annotations consistently through the entire tree: both the aggregate root and the
 * SPDX-License-Identifier: Apache-2.0
import org.apache.logging.log4j.LogManager;
        );
            }
                    makeCall(
            if (stage.getChildStages().isEmpty()) return stage;
                "viableBackends must be narrowed to single backend",
        QueryDAG filterDag = buildAndFork(
        assertTwoAlternatives(scanDag.rootStage(), OpenSearchTableScan.class);
     */
import org.opensearch.analytics.planner.rel.OpenSearchAggregate;
            List.of(stubScan(mockTable("test_index", "status", "size")), stubScan(mockTable("test_index", "status", "size"))),
    /**
        }
            SqlStdOperatorTable.EQUALS,
        return stage;
        // column) so the aggregate keeps an unbounded group count; filtering the group key `status`
        assertTwoAlternatives(filterDag.rootStage(), OpenSearchFilter.class);
        LOGGER.info("QueryDAG after forking:\n{}", dag);
     * <p>Regression for the multi-input forking bug: {@code resolve()} used to take each child's
        // Root coordinator stage — only DF has ExchangeSinkProvider
    /** Single-shard scan, filter, and aggregate — two alternatives each, one per backend. */
        }
                return caps;
            1,
            stage = stage.getChildStages().getFirst();
    /**
        // which narrows the root stage to reduce-capable backends.
            assertTrue(plan.resolvedFragment() instanceof OpenSearchSort);
        assertTwoAlternatives(dag.rootStage(), OpenSearchAggregate.class);
        // to a constant would bound it to one row and SORT_REMOVE_REDUNDANT would drop the Sort.
     * Forking at the root stage is limited to backends that can reduce (only mock-parquet in
     * these tests) → one alternative per stage, not two.
                10
        return dag;
     * resolves to exactly one DataFusion alternative.
     * filter child in each alternative must be narrowed to the same single backend.
import org.opensearch.analytics.planner.BasePlannerRulesTests;
    public void testMultiInputForksChildToParentBackend() {
    /**
            @Override
                    )
     *
        Stage child = dag.rootStage().getChildStages().getFirst();
                plan.resolvedFragment(),
        QueryDAG dag = DAGBuilder.build(cboOutput, context.getCapabilityRegistry(), mockClusterService(), TEST_RESOLVER);
        assertEquals("expected two alternatives (one per viable backend)", 2, alternatives.size());
    private QueryDAG buildAndForkUnionCapable(int shardCount, RelNode logicalPlan) {
            makeMultiCallAggregate(
        }
                    0,
                caps.add(EngineCapability.UNION);
        };
        QueryDAG scanDag = buildAndFork(1, stubScan(mockTable("test_index", "status", "size")));
    }
            /* all */ true
            protected Set<AggregateCapability> aggregateCapabilities() {
import org.apache.calcite.rel.core.AggregateCall;
     * Filter with AND of two annotated predicates — verifies tree-walk annotation
        }
            rexBuilder.makeLiteral(1, typeFactory.createSqlType(SqlTypeName.INTEGER), true)
     */
     * annotation viable backends differ from operator backend, one plan per annotation target is generated
 * are viable, verifying that forking produces two alternatives and each is narrowed
     * Constant predicate (1=1) must be eliminated by ReduceExpressionsRule before marking.
            }
import java.util.Set;
                    stubScan(mockTable("test_index", "status", "size")),
                return Set.of(EngineCapability.SORT);
import org.apache.logging.log4j.Logger;
     * <em>first</em> alternative ({@code getFirst()}), which is the Lucene scan. The DataFusion-only
            assertTrue(
        QueryDAG sortAggDag = buildAndFork(
        LOGGER.info("Marked+CBO RelNode:\n{}", RelOptUtil.toString(cboOutput));
 * <p>All tests use duplicated doc values (both parquet and lucene) so both backends
     */
        assertTwoAlternatives(aggDag.rootStage(), OpenSearchAggregate.class);
            makeSort(
        }
        assertTrue("root must be the scan after filter elimination", result instanceof OpenSearchTableScan);
     * Union then had {@code viableBackends ∩ {lucene} = ∅}, so it produced <b>zero</b> plan
                    typeFactory.createSqlType(SqlTypeName.INTEGER),
     * A {@code Union} that only one backend supports (DataFusion has {@code EngineCapability.UNION};
        MockLuceneBackend luceneScan = new MockLuceneBackend() {
import org.apache.calcite.rel.RelNode;
        );
        // ReduceExpressionsRule folds 1=1 → TRUE, then filter on TRUE is removed.
        for (StagePlan plan : alternatives) {
                    false,
        RelNode result = runPlanner(filter, context);
import org.apache.calcite.rel.logical.LogicalFilter;
    );
            @Override
        var context = buildContextWithExplicitStorage(shardCount, duplicatedIntFields(), List.of(unionCapableDf, luceneScan));
                AggregateCall.create(
                1,
            @Override
                expectedRootType.isInstance(plan.resolvedFragment())
package org.opensearch.analytics.planner.dag;
        // reduce stage; this test was written pre-QTF to assert on the Sort stage. Skip past LM.
            1,
public class PlanForkerTests extends BasePlannerRulesTests {
                    makeEquals(0, SqlTypeName.INTEGER, 200),
        RelNode cboOutput = runPlanner(logicalPlan, context);
     * The filter disappears entirely — the root of the marked tree is the scan, not a filter.
    }
            );
        // QTF rewriter inserts a LATE_MATERIALIZATION root stage above the original Sort+Limit
     * Asserts a stage has exactly two alternatives (one per backend), each narrowed to a single backend.
    public void testSingleStageQueryShapes() {
                        rexBuilder.makeLiteral(100, typeFactory.createSqlType(SqlTypeName.INTEGER), true)
     */
import org.apache.calcite.sql.fun.SqlStdOperatorTable;
import org.opensearch.analytics.spi.EngineCapability;
/**
    }
            }
        );
        };
     * (root) → LATE_MATERIALIZATION → sort+limit COORDINATOR_REDUCE → SHARD_FRAGMENT. Descend
            )
        PlanForker.forkAll(dag, context.getCapabilityRegistry());
    }
 */
        );
    /** Like {@link #buildAndFork} but the DataFusion backend opts into {@code EngineCapability.UNION}. */
import org.apache.calcite.rex.RexNode;
        RexNode constant = rexBuilder.makeCall(
        QueryDAG sortFilterDag = buildAndFork(
}
 *
        // Sort(Filter(Scan)) with limit — multi-shard so root-demand SINGLETON requires a gather,
     * TODO: add delegation-aware forking tests once delegation is implemented — verify that when
            }
                    makeFilter(stubScan(mockTable("test_index", "status", "size")), makeEquals(1, SqlTypeName.INTEGER, 200)),
        );
        List<StagePlan> alternatives = dag.rootStage().getPlanAlternatives();
     */
    /**
        assertEquals(1, sortAggRoot.getPlanAlternatives().size());
            )
     * alternatives — later surfacing as a {@code NoSuchElementException} at execution. The forker must
import org.opensearch.analytics.spi.AggregateCapability;
        // over an ER, narrowed to reduce-capable backends. Filter pins `size` (field 1, a non-group
     *
    public void testMultiShardAggregateForksAllStages() {
                stubScan(mockTable("test_index", "status", "size")),
import org.opensearch.analytics.planner.rel.OpenSearchRelNode;
        );
        while (!(stage.getFragment() instanceof OpenSearchSort)) {
                ((OpenSearchRelNode) plan.resolvedFragment()).getViableBackends().size()
        Stage stage = root;
 * The OpenSearch Contributors require contributions made to
     * Lucene does not) over dual-viable scans (both backends viable for the scan, Lucene listed first).
        assertFalse("Union over dual-viable scans must produce a resolvable plan, not an empty list", alternatives.isEmpty());
        return dag;
            assertTrue(plan.resolvedFragment() instanceof OpenSearchSort);
