            rexBuilder.makeLiteral(0.5, typeFactory.createSqlType(SqlTypeName.DOUBLE), true)
        BackendPlanAdapter.adaptAll(dag, context.getCapabilityRegistry());
public class BackendPlanAdapterTests extends BasePlannerRulesTests {
import org.apache.calcite.rel.core.JoinRelType;
            SqlStdOperatorTable.GREATER_THAN,
            SqlStdOperatorTable.GREATER_THAN,
        PlanForker.forkAll(dag, context.getCapabilityRegistry());
            }
        if (node instanceof AnnotatedPredicate annotated) return findCallByName(annotated.getOriginal(), name);
        RelOptTable leftTable = mockTable("test_index", "status", "size");
        assertEquals("ABS operand should remain INPUT_REF without adapter", SqlKind.INPUT_REF, absCall.getOperands().getFirst().getKind());
        return null;
    public void testSinAdapterInProjectInsertsCastForIntegerField() {
            rexBuilder.makeLiteral(0.5, typeFactory.createSqlType(SqlTypeName.DOUBLE), true)
        // ABS should have CAST on its direct RexInputRef operand
            "SIN operand should remain INPUT_REF with no adapters registered",
            "SIN operand should be CAST after adaptation in join condition",
                );
        RexNode absGt = rexBuilder.makeCall(
            }
        LogicalFilter filter = LogicalFilter.create(stubScan(table), condition);
        );
        assertEquals(SqlKind.INPUT_REF, eq.getOperands().get(1).getKind());
        RexNode condition = rexBuilder.makeCall(
        RelOptTable rightTable = mockTable("test_index", "status", "size");
    public void testJoinConditionAdapterInsertsCastForIntegerField() {
     * <p>Verifies the adapter chain runs on the join condition: SIN's INPUT_REF operand
            if (found != null) return found;
        if (node instanceof RexCall call) {
            rexBuilder.makeLiteral(10, typeFactory.createSqlType(SqlTypeName.INTEGER), true)
            if (call.getOperator().getName().equalsIgnoreCase(name)) return call;
    }
        StagePlan plan = findStagePlanByFragmentType(dag, OpenSearchFilter.class);
        }
     * fragment is an instance of {@code expected}. Used to find a specific operator
     * Walks the DAG depth-first and returns the first {@link StagePlan} whose resolved
            SqlStdOperatorTable.GREATER_THAN,
    }
        PlanForker.forkAll(dag, context.getCapabilityRegistry());
    public void testNoAdaptersRegisteredLeavesEverythingUnchanged() {
        OpenSearchFilter adaptedFilter = (OpenSearchFilter) plan.resolvedFragment();
    }
        RelNode marked = runPlanner(join, context);
                        Set.of(MockDataFusionBackend.PARQUET_DATA_FORMAT),
        // SIN's operand is ABS (a RexCall, not RexInputRef) — adapter should NOT insert CAST
        PlanForker.forkAll(dag, context.getCapabilityRegistry());
     * the Join's condition passes through structurally unchanged. Guards against the
        StagePlan plan = findStagePlanByFragmentType(dag, OpenSearchJoin.class);
     * `Unable to convert call NUMBER_TO_STRING(fp64?)`).
        StagePlan found = findStagePlanInTree(dag.rootStage(), expected);
        RexCall sinCall = null;
import org.opensearch.analytics.planner.rel.OpenSearchJoin;
        assertEquals(
        return false;
        assertTrue("Annotations must survive adaptation", containsAnnotation(adaptedFilter.getCondition()));
 * this file be licensed under the Apache-2.0 license or a
            }
        RexNode condition = rexBuilder.makeCall(
            SqlStdOperatorTable.ABS,
    }
                    adaptedOperands.add(
                if (containsAnnotation(operand)) return true;
import org.apache.calcite.sql.type.ReturnTypes;
import org.apache.calcite.rel.RelNode;
        RelNode rightScan = stubScan(table);
     * should be wrapped in a CAST after adaptation, exactly as it would on a Filter.
        RexCall absResult = findCallByName(adaptedFilter.getCondition(), "ABS");
        null,
        );
package org.opensearch.analytics.planner.dag;
import org.apache.calcite.plan.RelOptUtil;
import org.opensearch.analytics.planner.rel.OperatorAnnotation;
        return found;
            rexBuilder.makeInputRef(typeFactory.createSqlType(SqlTypeName.INTEGER), 0)
        SqlKind.OTHER_FUNCTION,
     * dispatcher accidentally rebuilding (and possibly mis-configuring) Joins that don't
        PlannerContext context = buildContext("parquet", 1, intFields(), List.of(dfWithAdapter));
        ReturnTypes.DOUBLE,
        SqlFunctionCategory.NUMERIC
        if (found == null) {
        SqlTypeName[] fieldTypes
            }
        return adaptSinFilter(operandType, fields, fields.keySet().toArray(String[]::new), null);
            @Override
    );
    /** SIN(integer_column) should be adapted to SIN(CAST(integer_column AS DOUBLE)). */
            for (RexNode expr : adaptedProject.getProjects()) {
        PlanForker.forkAll(dag, context.getCapabilityRegistry());
        RelNode marked = runPlanner(filter, context);
        assertNotNull("SIN call should exist in condition", sinCall);
import org.opensearch.analytics.spi.ScalarFunctionAdapter;
            sinResult.getOperands().getFirst().getKind()
            SqlStdOperatorTable.GREATER_THAN,
     */
        RexCall sinResult = findCallByName(adaptedJoin.getCondition(), "SIN");
            if (operand instanceof RexInputRef) {
    }
    };
                    );
            adaptedOperands.add(operand);
        }
import org.apache.calcite.rex.RexInputRef;
                if (typeName == SqlTypeName.INTEGER || typeName == SqlTypeName.BIGINT) {
        assertNotNull("SIN call should exist in adapted condition", sinCall);
                        false
        // Join condition: SIN(left.$0) > 0.5. SIN is a PPL UDF whose adapter inserts
        );
        // Condition is structurally identical: EQUALS($0, $2) — both operands still INPUT_REF.
        };
            sinCall.getOperands().getFirst().getKind()
            }
                return Map.of(ScalarFunction.SIN, sinCastAdapter);
        assertEquals("SIN operand should be CAST after adaptation", SqlKind.CAST, sinCall.getOperands().getFirst().getKind());
            sinCall,
            new String[] { "price", "amount" },
import org.apache.calcite.rel.logical.LogicalFilter;
            }
            protected Set<ProjectCapability> projectCapabilities() {
    /** No adapters registered — plan should pass through completely unchanged. */
            protected Map<ScalarFunction, ScalarFunctionAdapter> scalarFunctionAdapters() {
        assertNotSame("SIN operand should NOT be CAST for double field", SqlKind.CAST, sinCall.getOperands().getFirst().getKind());
    }
            @Override
        PlannerContext context = buildContext("parquet", 1, intFields(), List.of(dfWithBothAdapters));
import org.opensearch.analytics.planner.PlannerContext;
}
        LogicalFilter filter = LogicalFilter.create(stubScan(mockTable("test_index", "status", "size")), condition);
            for (RexNode operand : call.getOperands()) {
/*
                return Map.of(ScalarFunction.SIN, castAdapter, ScalarFunction.ABS, castAdapter);
     *
        PlannerContext context = buildContext("parquet", 1, fields, List.of(dfWithAdapter));
        };
        assertTrue("Annotations must survive when no adapters registered", containsAnnotation(adaptedFilter.getCondition()));
        RelOptTable table = fieldTypes != null ? mockTable("test_index", fieldNames, fieldTypes) : mockTable("test_index", fieldNames);
 *
    }
import org.opensearch.analytics.spi.FieldType;
        SqlTypeName operandType,
        RexCall sinCall = findCallByName(adaptedFilter.getCondition(), "SIN");
    /** SIN(integer_column) in a project should also get CAST inserted. */
        RelNode marked = runPlanner(join, context);
        RexCall absCall = findCallByName(adaptedFilter.getCondition(), "ABS");
                if (found != null) return found;
        );
        // CAST(... AS DOUBLE) around any RexInputRef operand whose type is INTEGER/BIGINT.
                return Map.of(ScalarFunction.SIN, sinCastAdapter);
    }
        if (plan.resolvedFragment() instanceof org.opensearch.analytics.planner.rel.OpenSearchProject adaptedProject) {
        QueryDAG dag = DAGBuilder.build(marked, context.getCapabilityRegistry(), mockClusterService(), TEST_RESOLVER);
import org.apache.calcite.sql.SqlKind;
        RexNode sinGt = rexBuilder.makeCall(
 * The OpenSearch Contributors require contributions made to
    public void testJoinConditionNoOpWhenNoAdaptedFunctions() {
        RelNode marked = runPlanner(filter, context);
import org.apache.logging.log4j.Logger;
            rexBuilder.makeLiteral(0.5, typeFactory.createSqlType(SqlTypeName.DOUBLE), true)
        assertNotNull("SIN call should exist in adapted project", sinCall);
     * need adaptation.
        );
            SqlTypeName.DOUBLE,
        );
        MockDataFusionBackend dfWithAdapter = new MockDataFusionBackend() {
        ScalarFunctionAdapter castAdapter = sinCastAdapter; // same logic works for ABS
    }
        return changed ? call.clone(call.getType(), adaptedOperands) : call;
        assertNotNull("SIN call should exist in adapted condition", sinCall);
        RelNode scan = stubScan(mockTable("test_index", "status", "size"));
        BackendPlanAdapter.adaptAll(dag, context.getCapabilityRegistry());
        RelNode marked = runPlanner(project, context);
        StagePlan plan = findStagePlanByFragmentType(dag, org.opensearch.analytics.planner.rel.OpenSearchProject.class);
     * reaches the substrait converter unrewritten and fails (e.g. PPL transpose's
        assertEquals(
                if (sinCall != null) break;
     */
import org.apache.calcite.plan.RelOptTable;
import org.opensearch.analytics.planner.rel.OpenSearchFilter;
import java.util.Map;
        if (node instanceof OperatorAnnotation) return true;
import org.apache.calcite.sql.fun.SqlStdOperatorTable;
    private static boolean containsAnnotation(RexNode node) {
import org.opensearch.analytics.planner.rel.AnnotatedPredicate;
import org.apache.calcite.sql.SqlFunction;
            rexBuilder.makeLiteral(0.5, typeFactory.createSqlType(SqlTypeName.DOUBLE), true)
            protected Map<ScalarFunction, ScalarFunctionAdapter> scalarFunctionAdapters() {
        // Find SIN call in the project expressions
        };
        RexCall sinResult = findCallByName(adaptedFilter.getCondition(), "SIN");
        RelNode marked = runPlanner(filter, context);
    private static final SqlFunction SIN_FUNCTION = new SqlFunction(
        "SIN",
        RelNode join = LogicalJoin.create(leftScan, rightScan, List.of(), condition, Set.of(), JoinRelType.INNER);
    private static StagePlan findStagePlanInTree(org.opensearch.analytics.planner.dag.Stage stage, Class<?> expected) {
            doubleFields,
            SqlStdOperatorTable.GREATER_THAN,
        RelNode rightScan = stubScan(rightTable);
                    changed = true;
        OpenSearchFilter adaptedFilter = (OpenSearchFilter) plan.resolvedFragment();
            }
        BackendPlanAdapter.adaptAll(dag, context.getCapabilityRegistry());
        QueryDAG dag = DAGBuilder.build(marked, context.getCapabilityRegistry(), mockClusterService(), TEST_RESOLVER);
                return Map.of(ScalarFunction.SIN, sinCastAdapter);
            protected Map<ScalarFunction, ScalarFunctionAdapter> scalarFunctionAdapters() {
            @Override
                return Set.of(
        RexNode sinCall = rexBuilder.makeCall(SIN_FUNCTION, rexBuilder.makeInputRef(typeFactory.createSqlType(SqlTypeName.INTEGER), 0));
        StagePlan plan = findStagePlanByFragmentType(dag, OpenSearchFilter.class);
        // Equi-join on left.$0 == right.$0 — no PPL UDF, nothing for adapter to rewrite.
            "SIN operand should be ABS (no double-CAST)",
        RexNode condition = rexBuilder.makeCall(
        LOGGER.debug("Marked:\n{}", RelOptUtil.toString(marked));
        LogicalProject project = LogicalProject.create(scan, List.of(), List.of(sinExpr), List.of("sin_status"));
        QueryDAG dag = DAGBuilder.build(marked, context.getCapabilityRegistry(), mockClusterService(), TEST_RESOLVER);
            @Override
     * into inner-Join conditions, so any PPL UDF that lived above a Join can ride into the
        assertNotNull("SIN call should exist in adapted condition", sinCall);
        RexCall sinCall = findCallByName(adaptedFilter.getCondition(), "SIN");
    public void testSinAdapterNoOpForDoubleField() {
                SqlTypeName typeName = operand.getType().getSqlTypeName();
                        Set.of(FieldType.INTEGER, FieldType.DOUBLE),
/**
        RelNode join = LogicalJoin.create(leftScan, rightScan, List.of(), condition, Set.of(), JoinRelType.INNER);
                RexCall found = findCallByName(operand, name);
        PlanForker.forkAll(dag, context.getCapabilityRegistry());
                    )
import org.opensearch.analytics.planner.MockDataFusionBackend;
        );
        RexNode condition = rexBuilder.makeCall(
        OpenSearchJoin adaptedJoin = (OpenSearchJoin) plan.resolvedFragment();
                        cluster.getRexBuilder().makeCast(cluster.getTypeFactory().createSqlType(SqlTypeName.DOUBLE), operand)
        RelNode marked = runPlanner(filter, context);
    }
    /**
    /**
            rexBuilder.makeInputRef(typeFactory.createSqlType(SqlTypeName.INTEGER), 2)
    private RexCall adaptSinFilter(
        BackendPlanAdapter.adaptAll(dag, context.getCapabilityRegistry());
        StagePlan plan = findStagePlanByFragmentType(dag, OpenSearchFilter.class);
        OpenSearchFilter adaptedFilter = (OpenSearchFilter) plan.resolvedFragment();
import org.opensearch.analytics.spi.ScalarFunction;
import org.apache.calcite.rex.RexNode;
        RelOptTable table = mockTable("test_index", "status", "size");
        assertNotNull("ABS call should exist in adapted condition", absCall);
            new SqlTypeName[] { SqlTypeName.DOUBLE, SqlTypeName.DOUBLE }
import org.opensearch.analytics.planner.BasePlannerRulesTests;
        LOGGER.info("Marked project:\n{}", RelOptUtil.toString(marked));
        assertNotNull("SIN call should exist in adapted join condition", sinResult);
        BackendPlanAdapter.adaptAll(dag, context.getCapabilityRegistry());
    /** Nested SIN(ABS($0)) — both have adapters, only one CAST at the leaf. */
import org.apache.calcite.rex.RexCall;
        RexCall eq = (RexCall) adaptedJoin.getCondition();
        );
            }
        }
        );
 * SPDX-License-Identifier: Apache-2.0
            "ABS",
                return Map.of(ScalarFunction.SIN, sinCastAdapter);
            StagePlan found = findStagePlanInTree(child, expected);
        assertTrue("Annotations must survive mixed adaptation", containsAnnotation(adaptedFilter.getCondition()));
     * Join with no adapted UDFs in its condition — adapter chain runs but rewrites nothing,
        RexCall sinCall = adaptSinFilter(SqlTypeName.INTEGER, intFields());
    }
import org.apache.logging.log4j.LogManager;
        MockDataFusionBackend dfWithAdapter = new MockDataFusionBackend() {
            throw new AssertionError("No stage plan in DAG produces a " + expected.getSimpleName() + " fragment");
     * Join's condition. Without dispatching OpenSearchJoin in adaptNode, that inlined UDF
            SqlKind.INPUT_REF,
    private static StagePlan findStagePlanByFragmentType(QueryDAG dag, Class<?> expected) {
    public void testMixedAdaptedAndNonAdaptedFunctions() {
     * coord-stage ER) without coupling tests to a particular DAG depth.
        RexNode sinCall = rexBuilder.makeCall(SIN_FUNCTION, rexBuilder.makeInputRef(typeFactory.createSqlType(operandType), 0));
    }
        for (RexNode operand : call.getOperands()) {
            @Override
        for (StagePlan plan : stage.getPlanAlternatives()) {
        LogicalFilter filter = LogicalFilter.create(stubScan(mockTable("test_index", "status", "size")), condition);
        QueryDAG dag = DAGBuilder.build(marked, context.getCapabilityRegistry(), mockClusterService(), TEST_RESOLVER);
     * within multi-stage plans (e.g. the data-node Filter stage when the root is a
    }
        );
        PlanForker.forkAll(dag, context.getCapabilityRegistry());
        RexNode absCall = rexBuilder.makeCall(
        LogicalFilter filter = LogicalFilter.create(stubScan(mockTable("test_index", "status", "size")), condition);
            rexBuilder.makeCall(SIN_FUNCTION, rexBuilder.makeInputRef(typeFactory.createSqlType(SqlTypeName.INTEGER), 0)),
            sinAbsCall,
                assertTrue("Project annotations must survive adaptation", containsAnnotation(expr));
            @Override
    /**
        }
        PlanForker.forkAll(dag, context.getCapabilityRegistry());
        RelNode leftScan = stubScan(table);
        BackendPlanAdapter.adaptAll(dag, context.getCapabilityRegistry());
        for (org.opensearch.analytics.planner.dag.Stage child : stage.getChildStages()) {
                sinCall = findCallByName(expr, "SIN");
            protected Map<ScalarFunction, ScalarFunctionAdapter> scalarFunctionAdapters() {
import java.util.ArrayList;
    public void testNestedAdaptedFunctionsProduceSingleCast() {
        if (node instanceof RexCall call) {
        PlannerContext context = buildContext("parquet", 1, intFields(), List.of(dfWithSinAdapterOnly));
        assertEquals(SqlKind.EQUALS, eq.getKind());
        PlannerContext context = buildContext("parquet", 1, intFields());
    ) {
        RelNode leftScan = stubScan(leftTable);
     * Join condition carries SIN(integer_column) — a PPL UDF that the SIN adapter rewrites to
        boolean changed = false;
            SqlKind.CAST,
        StagePlan plan = findStagePlanByFragmentType(dag, OpenSearchFilter.class);
            ((RexCall) sinResult.getOperands().getFirst()).getOperator().getName()
                        ScalarFunction.SIN,
        return null;
    private static RexCall findCallByName(RexNode node, String name) {
        return findCallByName(adaptedFilter.getCondition(), "SIN");
     * SIN(CAST(... AS DOUBLE)). Calcite's FILTER_INTO_JOIN rule inlines outer-Filter predicates
        OpenSearchJoin adaptedJoin = (OpenSearchJoin) plan.resolvedFragment();
        assertNotNull("SIN call should exist", sinResult);
            SqlStdOperatorTable.GREATER_THAN,
        QueryDAG dag = DAGBuilder.build(marked, context.getCapabilityRegistry(), mockClusterService(), TEST_RESOLVER);
            rexBuilder.makeLiteral(0.5, typeFactory.createSqlType(SqlTypeName.DOUBLE), true)
        MockDataFusionBackend dfWithAdapter = new MockDataFusionBackend() {
 */
    private RexCall adaptSinFilter(SqlTypeName operandType, Map<String, Map<String, Object>> fields) {
        Map<String, Map<String, Object>> fields,
        MockDataFusionBackend dfWithBothAdapters = new MockDataFusionBackend() {
        String[] fieldNames,
        };
import java.util.Set;
 */
            }
                    new ProjectCapability.Scalar(
            SqlStdOperatorTable.EQUALS,
    /** SIN(double_column) should NOT be adapted — no CAST needed. */
            sinCall,
        QueryDAG dag = DAGBuilder.build(marked, context.getCapabilityRegistry(), mockClusterService(), TEST_RESOLVER);
        List<RexNode> adaptedOperands = new ArrayList<>(call.getOperands().size());
import org.opensearch.analytics.spi.ProjectCapability;
        );
        MockDataFusionBackend dfWithSinAdapterOnly = new MockDataFusionBackend() {
 * compatible open source license.
 * Tests for {@link BackendPlanAdapter} — verifies per-function adapters are applied
        assertEquals("SIN operand should be CAST after adaptation", SqlKind.CAST, sinCall.getOperands().getFirst().getKind());
        RexNode sinAbsCall = rexBuilder.makeCall(SIN_FUNCTION, absCall);
    private final ScalarFunctionAdapter sinCastAdapter = (call, fieldStorage, cluster) -> {
        };
        assertEquals(SqlKind.INPUT_REF, eq.getOperands().get(0).getKind());
            rexBuilder.makeCall(SqlStdOperatorTable.ABS, rexBuilder.makeInputRef(typeFactory.createSqlType(SqlTypeName.INTEGER), 1)),
        PlannerContext context = buildContext("parquet", 1, intFields());
import org.apache.calcite.sql.type.OperandTypes;
import org.apache.calcite.rel.logical.LogicalProject;
            for (RexNode operand : call.getOperands()) {
        assertEquals("SIN operand should be CAST after adaptation in project", SqlKind.CAST, sinCall.getOperands().getFirst().getKind());
        assertEquals(
     */
            rexBuilder.makeCall(SIN_FUNCTION, rexBuilder.makeInputRef(typeFactory.createSqlType(SqlTypeName.INTEGER), 0)),
import java.util.List;
        RexNode condition = rexBuilder.makeCall(
        BackendPlanAdapter.adaptAll(dag, context.getCapabilityRegistry());
        RexCall sinCall = adaptSinFilter(
        }
            rexBuilder.makeInputRef(typeFactory.createSqlType(SqlTypeName.INTEGER), 0),
        RexNode sinExpr = rexBuilder.makeCall(SIN_FUNCTION, rexBuilder.makeInputRef(typeFactory.createSqlType(SqlTypeName.INTEGER), 0));
    }
        OperandTypes.NUMERIC,
    public void testSinAdapterInsertsCastForIntegerField() {
import org.apache.calcite.rel.logical.LogicalJoin;
        );
                }
        StagePlan plan = findStagePlanByFragmentType(dag, OpenSearchJoin.class);
import org.apache.calcite.sql.type.SqlTypeName;
        RexNode condition = rexBuilder.makeCall(SqlStdOperatorTable.AND, sinGt, absGt);
            protected Map<ScalarFunction, ScalarFunctionAdapter> scalarFunctionAdapters() {
        }
 * correctly between plan forking and fragment conversion.
    /** Filter with SIN (adapted) AND ABS (no adapter) — SIN gets CAST, ABS unchanged. */
import org.apache.calcite.sql.SqlFunctionCategory;
        }
            if (expected.isInstance(plan.resolvedFragment())) return plan;
        assertNotNull("ABS call should exist", absResult);
        assertEquals("ABS operand should be CAST", SqlKind.CAST, absResult.getOperands().getFirst().getKind());
                    continue;
        PlannerContext context = buildContext("parquet", 1, intFields(), List.of(dfWithAdapter));
        QueryDAG dag = DAGBuilder.build(marked, context.getCapabilityRegistry(), mockClusterService(), TEST_RESOLVER);
        OpenSearchFilter adaptedFilter = (OpenSearchFilter) plan.resolvedFragment();
        Map<String, Map<String, Object>> doubleFields = Map.of("price", Map.of("type", "double"), "amount", Map.of("type", "double"));
    private static final Logger LOGGER = LogManager.getLogger(BackendPlanAdapterTests.class);
            }
