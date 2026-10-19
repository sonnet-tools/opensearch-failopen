        // ABS should have CAST on its direct RexInputRef operand
        );  
import org.opensearch.analytics.planner.rel.OperatorAnnotation;
            }  
        BackendPlanAdapter.adaptAll(dag, context.getCapabilityRegistry());  
        RexNode sinGt = rexBuilder.makeCall(
 * correctly between plan forking and fragment conversion.  
    }
        RexCall absResult = findCallByName(adaptedFilter.getCondition(), "ABS");
        RexCall sinCall = adaptSinFilter(
    /** Nested SIN(ABS($0)) — both have adapters, only one CAST at the leaf. */
        SqlTypeName[] fieldTypes  
        assertEquals(  
                        false  
        PlannerContext context = buildContext("parquet", 1, intFields(), List.of(dfWithSinAdapterOnly));  
    /** SIN(double_column) should NOT be adapted — no CAST needed. */
                return Map.of(ScalarFunction.SIN, sinCastAdapter);
        RexCall sinCall = findCallByName(adaptedFilter.getCondition(), "SIN");
            protected Set<ProjectCapability> projectCapabilities() {  
        return found;
            SqlStdOperatorTable.GREATER_THAN,
        return adaptSinFilter(operandType, fields, fields.keySet().toArray(String[]::new), null);
     * <p>Verifies the adapter chain runs on the join condition: SIN's INPUT_REF operand  
        );
    public void testSinAdapterInProjectInsertsCastForIntegerField() {
                if (sinCall != null) break;
 */  
        }  
                return Map.of(ScalarFunction.SIN, castAdapter, ScalarFunction.ABS, castAdapter);
                SqlTypeName typeName = operand.getType().getSqlTypeName();
     */
        // Find SIN call in the project expressions
    }
    );
    public void testMixedAdaptedAndNonAdaptedFunctions() {
                        Set.of(MockDataFusionBackend.PARQUET_DATA_FORMAT),
        LogicalFilter filter = LogicalFilter.create(stubScan(mockTable("test_index", "status", "size")), condition);  
        Map<String, Map<String, Object>> doubleFields = Map.of("price", Map.of("type", "double"), "amount", Map.of("type", "double"));
        RelNode rightScan = stubScan(rightTable);
        StagePlan plan = findStagePlanByFragmentType(dag, OpenSearchFilter.class);  
     * within multi-stage plans (e.g. the data-node Filter stage when the root is a
import org.opensearch.analytics.planner.BasePlannerRulesTests;
        // SIN's operand is ABS (a RexCall, not RexInputRef) — adapter should NOT insert CAST  
                    adaptedOperands.add(
        BackendPlanAdapter.adaptAll(dag, context.getCapabilityRegistry());  
            "SIN operand should remain INPUT_REF with no adapters registered",
        if (found == null) {
        }
        return findCallByName(adaptedFilter.getCondition(), "SIN");  
            @Override  
import java.util.Set;
        RexNode condition = rexBuilder.makeCall(
            "ABS",
        PlannerContext context = buildContext("parquet", 1, fields, List.of(dfWithAdapter));  
        RelOptTable table = mockTable("test_index", "status", "size");  
        QueryDAG dag = DAGBuilder.build(marked, context.getCapabilityRegistry(), mockClusterService(), TEST_RESOLVER);  
    private static boolean containsAnnotation(RexNode node) {  
        return null;  
        assertNotNull("SIN call should exist in adapted condition", sinCall);
 * The OpenSearch Contributors require contributions made to  
        }
            @Override  
            rexBuilder.makeLiteral(0.5, typeFactory.createSqlType(SqlTypeName.DOUBLE), true)
        BackendPlanAdapter.adaptAll(dag, context.getCapabilityRegistry());
        );
import org.apache.calcite.rex.RexCall;
        RexNode condition = rexBuilder.makeCall(
        RelNode marked = runPlanner(project, context);  
import org.apache.calcite.rel.core.JoinRelType;
            SqlStdOperatorTable.EQUALS,  
        };
import org.opensearch.analytics.planner.rel.OpenSearchJoin;
            rexBuilder.makeLiteral(0.5, typeFactory.createSqlType(SqlTypeName.DOUBLE), true)  
        SqlKind.OTHER_FUNCTION,
    private RexCall adaptSinFilter(
        };
            SqlTypeName.DOUBLE,  
        RexCall sinResult = findCallByName(adaptedFilter.getCondition(), "SIN");
            sinCall.getOperands().getFirst().getKind()
                return Map.of(ScalarFunction.SIN, sinCastAdapter);
    public void testJoinConditionAdapterInsertsCastForIntegerField() {  
        QueryDAG dag = DAGBuilder.build(marked, context.getCapabilityRegistry(), mockClusterService(), TEST_RESOLVER);
        RelOptTable leftTable = mockTable("test_index", "status", "size");
            protected Map<ScalarFunction, ScalarFunctionAdapter> scalarFunctionAdapters() {
        PlanForker.forkAll(dag, context.getCapabilityRegistry());
            rexBuilder.makeLiteral(0.5, typeFactory.createSqlType(SqlTypeName.DOUBLE), true)  
import org.apache.calcite.plan.RelOptUtil;
        assertEquals("ABS operand should remain INPUT_REF without adapter", SqlKind.INPUT_REF, absCall.getOperands().getFirst().getKind());
            if (found != null) return found;
        LOGGER.debug("Marked:\n{}", RelOptUtil.toString(marked));  
        SqlTypeName operandType,  
     * Join condition carries SIN(integer_column) — a PPL UDF that the SIN adapter rewrites to
        RelNode marked = runPlanner(join, context);
    }  
 * Tests for {@link BackendPlanAdapter} — verifies per-function adapters are applied
import org.apache.calcite.sql.type.ReturnTypes;
    /** Filter with SIN (adapted) AND ABS (no adapter) — SIN gets CAST, ABS unchanged. */  
        QueryDAG dag = DAGBuilder.build(marked, context.getCapabilityRegistry(), mockClusterService(), TEST_RESOLVER);
        StagePlan plan = findStagePlanByFragmentType(dag, OpenSearchFilter.class);
        };  
        LogicalFilter filter = LogicalFilter.create(stubScan(mockTable("test_index", "status", "size")), condition);
    }
        RexNode condition = rexBuilder.makeCall(  
 * this file be licensed under the Apache-2.0 license or a
        assertEquals("SIN operand should be CAST after adaptation in project", SqlKind.CAST, sinCall.getOperands().getFirst().getKind());  
        QueryDAG dag = DAGBuilder.build(marked, context.getCapabilityRegistry(), mockClusterService(), TEST_RESOLVER);  
    }
        PlannerContext context = buildContext("parquet", 1, intFields(), List.of(dfWithAdapter));
    /**
        PlanForker.forkAll(dag, context.getCapabilityRegistry());  
        );  
        // Equi-join on left.$0 == right.$0 — no PPL UDF, nothing for adapter to rewrite.
        return false;
    private RexCall adaptSinFilter(SqlTypeName operandType, Map<String, Map<String, Object>> fields) {
            if (expected.isInstance(plan.resolvedFragment())) return plan;  
     * `Unable to convert call NUMBER_TO_STRING(fp64?)`).
        assertNotNull("SIN call should exist in adapted join condition", sinResult);
            rexBuilder.makeCall(SqlStdOperatorTable.ABS, rexBuilder.makeInputRef(typeFactory.createSqlType(SqlTypeName.INTEGER), 1)),  
     */
            for (RexNode expr : adaptedProject.getProjects()) {
import org.apache.calcite.sql.fun.SqlStdOperatorTable;
            SqlStdOperatorTable.GREATER_THAN,
            new SqlTypeName[] { SqlTypeName.DOUBLE, SqlTypeName.DOUBLE }  
        for (RexNode operand : call.getOperands()) {  
        );  
    public void testNoAdaptersRegisteredLeavesEverythingUnchanged() {
import org.apache.calcite.rel.RelNode;  
        MockDataFusionBackend dfWithBothAdapters = new MockDataFusionBackend() {
        List<RexNode> adaptedOperands = new ArrayList<>(call.getOperands().size());
        MockDataFusionBackend dfWithAdapter = new MockDataFusionBackend() {
            ((RexCall) sinResult.getOperands().getFirst()).getOperator().getName()  
import org.opensearch.analytics.spi.ScalarFunction;
            for (RexNode operand : call.getOperands()) {  
            SqlStdOperatorTable.GREATER_THAN,
        ReturnTypes.DOUBLE,  
 */
            adaptedOperands.add(operand);
        RelNode marked = runPlanner(filter, context);  
import org.apache.calcite.sql.type.SqlTypeName;
        RexNode absGt = rexBuilder.makeCall(
        assertEquals(SqlKind.INPUT_REF, eq.getOperands().get(1).getKind());
import org.apache.calcite.sql.SqlFunctionCategory;  
                    changed = true;
        MockDataFusionBackend dfWithSinAdapterOnly = new MockDataFusionBackend() {
            rexBuilder.makeInputRef(typeFactory.createSqlType(SqlTypeName.INTEGER), 0),
        assertEquals(
     *
        // CAST(... AS DOUBLE) around any RexInputRef operand whose type is INTEGER/BIGINT.
        RelNode marked = runPlanner(filter, context);
            new String[] { "price", "amount" },
        RexNode sinCall = rexBuilder.makeCall(SIN_FUNCTION, rexBuilder.makeInputRef(typeFactory.createSqlType(SqlTypeName.INTEGER), 0));
        assertEquals("ABS operand should be CAST", SqlKind.CAST, absResult.getOperands().getFirst().getKind());
     * coord-stage ER) without coupling tests to a particular DAG depth.  
            protected Map<ScalarFunction, ScalarFunctionAdapter> scalarFunctionAdapters() {
        assertEquals(
        StagePlan plan = findStagePlanByFragmentType(dag, OpenSearchFilter.class);
        RexCall absCall = findCallByName(adaptedFilter.getCondition(), "ABS");  
            rexBuilder.makeCall(SIN_FUNCTION, rexBuilder.makeInputRef(typeFactory.createSqlType(SqlTypeName.INTEGER), 0)),
        RelNode scan = stubScan(mockTable("test_index", "status", "size"));  
        if (node instanceof AnnotatedPredicate annotated) return findCallByName(annotated.getOriginal(), name);  
            rexBuilder.makeCall(SIN_FUNCTION, rexBuilder.makeInputRef(typeFactory.createSqlType(SqlTypeName.INTEGER), 0)),
                if (containsAnnotation(operand)) return true;
        }  
import java.util.Map;
import org.apache.calcite.rel.logical.LogicalProject;
                    );  
            @Override  
        PlanForker.forkAll(dag, context.getCapabilityRegistry());
        RelNode join = LogicalJoin.create(leftScan, rightScan, List.of(), condition, Set.of(), JoinRelType.INNER);
        RexNode condition = rexBuilder.makeCall(  
        PlannerContext context = buildContext("parquet", 1, intFields());  
                    new ProjectCapability.Scalar(
        assertNotNull("SIN call should exist", sinResult);
        // Condition is structurally identical: EQUALS($0, $2) — both operands still INPUT_REF.
import org.opensearch.analytics.spi.ScalarFunctionAdapter;  
            "SIN operand should be CAST after adaptation in join condition",  
import org.opensearch.analytics.planner.MockDataFusionBackend;  
            }
    private static RexCall findCallByName(RexNode node, String name) {
    private static StagePlan findStagePlanByFragmentType(QueryDAG dag, Class<?> expected) {
     * Walks the DAG depth-first and returns the first {@link StagePlan} whose resolved  
    public void testJoinConditionNoOpWhenNoAdaptedFunctions() {  
        RexNode condition = rexBuilder.makeCall(
        PlanForker.forkAll(dag, context.getCapabilityRegistry());
        }
            protected Map<ScalarFunction, ScalarFunctionAdapter> scalarFunctionAdapters() {  
        }  
        }
                        ScalarFunction.SIN,  
package org.opensearch.analytics.planner.dag;
 *
        RexCall sinCall = findCallByName(adaptedFilter.getCondition(), "SIN");
        assertNotNull("SIN call should exist in condition", sinCall);  
        PlanForker.forkAll(dag, context.getCapabilityRegistry());
            doubleFields,
import java.util.List;  
        QueryDAG dag = DAGBuilder.build(marked, context.getCapabilityRegistry(), mockClusterService(), TEST_RESOLVER);
                return Map.of(ScalarFunction.SIN, sinCastAdapter);
            protected Map<ScalarFunction, ScalarFunctionAdapter> scalarFunctionAdapters() {
        RexNode condition = rexBuilder.makeCall(SqlStdOperatorTable.AND, sinGt, absGt);  
        );  
            }  
                return Set.of(
            if (call.getOperator().getName().equalsIgnoreCase(name)) return call;
        PlanForker.forkAll(dag, context.getCapabilityRegistry());
        QueryDAG dag = DAGBuilder.build(marked, context.getCapabilityRegistry(), mockClusterService(), TEST_RESOLVER);
import org.apache.calcite.rex.RexNode;
            @Override
        Map<String, Map<String, Object>> fields,
    }
        QueryDAG dag = DAGBuilder.build(marked, context.getCapabilityRegistry(), mockClusterService(), TEST_RESOLVER);  
            rexBuilder.makeInputRef(typeFactory.createSqlType(SqlTypeName.INTEGER), 0)
        if (node instanceof RexCall call) {
        for (StagePlan plan : stage.getPlanAlternatives()) {
    }
        assertNotNull("ABS call should exist in adapted condition", absCall);
        OpenSearchFilter adaptedFilter = (OpenSearchFilter) plan.resolvedFragment();  
        OpenSearchFilter adaptedFilter = (OpenSearchFilter) plan.resolvedFragment();
import java.util.ArrayList;
    private static final Logger LOGGER = LogManager.getLogger(BackendPlanAdapterTests.class);
    public void testNestedAdaptedFunctionsProduceSingleCast() {  
     */
        );
        RelOptTable rightTable = mockTable("test_index", "status", "size");
        RexCall sinResult = findCallByName(adaptedJoin.getCondition(), "SIN");  
import org.apache.calcite.rel.logical.LogicalFilter;
import org.opensearch.analytics.planner.PlannerContext;
        null,
     * into inner-Join conditions, so any PPL UDF that lived above a Join can ride into the
        LOGGER.info("Marked project:\n{}", RelOptUtil.toString(marked));
        StagePlan plan = findStagePlanByFragmentType(dag, OpenSearchFilter.class);
        RexCall sinCall = null;  
        StagePlan plan = findStagePlanByFragmentType(dag, org.opensearch.analytics.planner.rel.OpenSearchProject.class);
    /**
        assertNotSame("SIN operand should NOT be CAST for double field", SqlKind.CAST, sinCall.getOperands().getFirst().getKind());  
import org.apache.calcite.plan.RelOptTable;
/**
        };
        assertNotNull("SIN call should exist in adapted condition", sinCall);
import org.opensearch.analytics.spi.ProjectCapability;
        assertNotNull("ABS call should exist", absResult);  
    }
        BackendPlanAdapter.adaptAll(dag, context.getCapabilityRegistry());
        );
        RelOptTable table = fieldTypes != null ? mockTable("test_index", fieldNames, fieldTypes) : mockTable("test_index", fieldNames);
        if (plan.resolvedFragment() instanceof org.opensearch.analytics.planner.rel.OpenSearchProject adaptedProject) {
import org.apache.calcite.sql.type.OperandTypes;  
     * SIN(CAST(... AS DOUBLE)). Calcite's FILTER_INTO_JOIN rule inlines outer-Filter predicates  
        RelNode marked = runPlanner(filter, context);
import org.opensearch.analytics.spi.FieldType;  
        boolean changed = false;
        if (node instanceof RexCall call) {
        assertEquals("SIN operand should be CAST after adaptation", SqlKind.CAST, sinCall.getOperands().getFirst().getKind());  
        assertEquals(SqlKind.INPUT_REF, eq.getOperands().get(0).getKind());
                    )
        assertEquals(SqlKind.EQUALS, eq.getKind());  
     * Join with no adapted UDFs in its condition — adapter chain runs but rewrites nothing,
                assertTrue("Project annotations must survive adaptation", containsAnnotation(expr));  
                if (typeName == SqlTypeName.INTEGER || typeName == SqlTypeName.BIGINT) {  
            "SIN operand should be ABS (no double-CAST)",
                    continue;
        assertTrue("Annotations must survive when no adapters registered", containsAnnotation(adaptedFilter.getCondition()));
            if (operand instanceof RexInputRef) {
            }  
            rexBuilder.makeInputRef(typeFactory.createSqlType(SqlTypeName.INTEGER), 2)
        String[] fieldNames,
        RexNode sinCall = rexBuilder.makeCall(SIN_FUNCTION, rexBuilder.makeInputRef(typeFactory.createSqlType(operandType), 0));
            SqlStdOperatorTable.GREATER_THAN,  
                return Map.of(ScalarFunction.SIN, sinCastAdapter);
 * compatible open source license.
            SqlStdOperatorTable.GREATER_THAN,
        BackendPlanAdapter.adaptAll(dag, context.getCapabilityRegistry());  
        RexCall eq = (RexCall) adaptedJoin.getCondition();
                }  
            for (RexNode operand : call.getOperands()) {  
        MockDataFusionBackend dfWithAdapter = new MockDataFusionBackend() {
    }  
        OperandTypes.NUMERIC,
    /** SIN(integer_column) in a project should also get CAST inserted. */  
        RelNode leftScan = stubScan(leftTable);  
    /** SIN(integer_column) should be adapted to SIN(CAST(integer_column AS DOUBLE)). */
     * reaches the substrait converter unrewritten and fails (e.g. PPL transpose's  
    public void testSinAdapterNoOpForDoubleField() {  
        OpenSearchFilter adaptedFilter = (OpenSearchFilter) plan.resolvedFragment();  
        StagePlan plan = findStagePlanByFragmentType(dag, OpenSearchJoin.class);
            throw new AssertionError("No stage plan in DAG produces a " + expected.getSimpleName() + " fragment");
        for (org.opensearch.analytics.planner.dag.Stage child : stage.getChildStages()) {
        PlannerContext context = buildContext("parquet", 1, intFields(), List.of(dfWithAdapter));  
    }  
            }  
        assertNotNull("SIN call should exist in adapted condition", sinCall);
}
            @Override  
            protected Map<ScalarFunction, ScalarFunctionAdapter> scalarFunctionAdapters() {
     * Join's condition. Without dispatching OpenSearchJoin in adaptNode, that inlined UDF
import org.apache.calcite.rex.RexInputRef;  
    }
            SqlKind.INPUT_REF,  
            }
    };
                if (found != null) return found;
            SqlStdOperatorTable.ABS,  
        if (node instanceof OperatorAnnotation) return true;
            @Override
import org.opensearch.analytics.planner.rel.OpenSearchFilter;  
     * fragment is an instance of {@code expected}. Used to find a specific operator
    }  
        BackendPlanAdapter.adaptAll(dag, context.getCapabilityRegistry());
        return changed ? call.clone(call.getType(), adaptedOperands) : call;
     * should be wrapped in a CAST after adaptation, exactly as it would on a Filter.
        return null;
            SqlKind.CAST,
        OpenSearchJoin adaptedJoin = (OpenSearchJoin) plan.resolvedFragment();  
        StagePlan plan = findStagePlanByFragmentType(dag, OpenSearchJoin.class);
    /** No adapters registered — plan should pass through completely unchanged. */
            sinResult.getOperands().getFirst().getKind()
        assertTrue("Annotations must survive mixed adaptation", containsAnnotation(adaptedFilter.getCondition()));
     * the Join's condition passes through structurally unchanged. Guards against the
        RelNode leftScan = stubScan(table);
import org.apache.logging.log4j.LogManager;  
import org.opensearch.analytics.planner.rel.AnnotatedPredicate;
                );
            }  
        );
public class BackendPlanAdapterTests extends BasePlannerRulesTests {
            rexBuilder.makeLiteral(0.5, typeFactory.createSqlType(SqlTypeName.DOUBLE), true)
        assertTrue("Annotations must survive adaptation", containsAnnotation(adaptedFilter.getCondition()));
        );
import org.apache.logging.log4j.Logger;
        PlannerContext context = buildContext("parquet", 1, intFields());
        RexNode sinExpr = rexBuilder.makeCall(SIN_FUNCTION, rexBuilder.makeInputRef(typeFactory.createSqlType(SqlTypeName.INTEGER), 0));
        RexNode absCall = rexBuilder.makeCall(
    ) {
        RexCall sinCall = adaptSinFilter(SqlTypeName.INTEGER, intFields());  
        LogicalProject project = LogicalProject.create(scan, List.of(), List.of(sinExpr), List.of("sin_status"));
    }  
        OpenSearchJoin adaptedJoin = (OpenSearchJoin) plan.resolvedFragment();
    private static final SqlFunction SIN_FUNCTION = new SqlFunction(  
        // Join condition: SIN(left.$0) > 0.5. SIN is a PPL UDF whose adapter inserts  
    private final ScalarFunctionAdapter sinCastAdapter = (call, fieldStorage, cluster) -> {  
            rexBuilder.makeLiteral(0.5, typeFactory.createSqlType(SqlTypeName.DOUBLE), true)
        PlanForker.forkAll(dag, context.getCapabilityRegistry());
        RelNode marked = runPlanner(join, context);  
        SqlFunctionCategory.NUMERIC  
            }
                RexCall found = findCallByName(operand, name);
        RelNode rightScan = stubScan(table);
        LogicalFilter filter = LogicalFilter.create(stubScan(mockTable("test_index", "status", "size")), condition);
            }  
        LogicalFilter filter = LogicalFilter.create(stubScan(table), condition);  
     * need adaptation.
     * dispatcher accidentally rebuilding (and possibly mis-configuring) Joins that don't  
        RelNode marked = runPlanner(filter, context);  
        RelNode join = LogicalJoin.create(leftScan, rightScan, List.of(), condition, Set.of(), JoinRelType.INNER);
        RexNode sinAbsCall = rexBuilder.makeCall(SIN_FUNCTION, absCall);  
            StagePlan found = findStagePlanInTree(child, expected);  
        );
        MockDataFusionBackend dfWithAdapter = new MockDataFusionBackend() {
/*  
        PlannerContext context = buildContext("parquet", 1, intFields(), List.of(dfWithBothAdapters));  
        BackendPlanAdapter.adaptAll(dag, context.getCapabilityRegistry());
        };
            sinAbsCall,  
    private static StagePlan findStagePlanInTree(org.opensearch.analytics.planner.dag.Stage stage, Class<?> expected) {
            }  
        assertNotNull("SIN call should exist in adapted project", sinCall);
        OpenSearchFilter adaptedFilter = (OpenSearchFilter) plan.resolvedFragment();
            sinCall,
    /**  
        "SIN",
            rexBuilder.makeLiteral(10, typeFactory.createSqlType(SqlTypeName.INTEGER), true)
                        cluster.getRexBuilder().makeCast(cluster.getTypeFactory().createSqlType(SqlTypeName.DOUBLE), operand)
        assertEquals("SIN operand should be CAST after adaptation", SqlKind.CAST, sinCall.getOperands().getFirst().getKind());
            SqlStdOperatorTable.GREATER_THAN,  
    }
 * SPDX-License-Identifier: Apache-2.0
        );
import org.apache.calcite.sql.SqlFunction;
                sinCall = findCallByName(expr, "SIN");
            sinCall,
        ScalarFunctionAdapter castAdapter = sinCastAdapter; // same logic works for ABS
import org.apache.calcite.sql.SqlKind;
import org.apache.calcite.rel.logical.LogicalJoin;  
                        Set.of(FieldType.INTEGER, FieldType.DOUBLE),
    public void testSinAdapterInsertsCastForIntegerField() {
        StagePlan found = findStagePlanInTree(dag.rootStage(), expected);  
