        List<RexNode> innerExprs = ((LogicalProject) innerInput).getProjects();
        SqlKind.OTHER_FUNCTION,
            assertFalse("Field ref should not be annotated", expr instanceof AnnotatedProjectExpression);
            protected Set<DelegationType> acceptedDelegations() {
    // ---- Helpers ----
    // ---- Delegation edge cases ----
    );
     * via the backend's {@code ScalarFunctionAdapter}.
            }
            protected Set<DelegationType> supportedDelegations() {
        // Lucene supports painless but doesn't accept PROJECT delegation
                break;
    );
    public void testNestedScalarFunctions() {
            "Third project expression must remain a RexOver, was " + result.getProjects().get(2).getClass().getSimpleName(),
            }
    }
import org.opensearch.analytics.spi.AnalyticsSearchBackendPlugin;
    @SafeVarargs
        // scalar call as an operand. The project rule recurses into operands
            result,
            if (innerExpr instanceof RexOver) {
        );
        assertAnnotation(result.getProjects().get(1), MockLuceneBackend.NAME);
    // ---- Opaque natively supported ----
            SqlStdOperatorTable.CEIL,
        RexNode expr = rexBuilder.makeCall(scalarMaxUdf, intRef, intRef);
package org.opensearch.analytics.planner;
            rexBuilder.makeInputRef(typeFactory.createSqlType(SqlTypeName.VARCHAR), 0),
        Set<ProjectCapability> caps = new HashSet<>();
    // ---- Scalar functions ----
        };
 * handling, and painless script delegation.
            protected Set<DelegationType> supportedDelegations() {
            outerExprs.get(1) instanceof RexInputRef
            protected Set<DelegationType> acceptedDelegations() {
            result,
            List.of(),
        RelNode agg = makeAggregate(
            @Override
                assertNoAnnotationInTree(operand);
        if (node instanceof RexCall call) {
        RelNode stripped = annotated.stripAnnotations(annotated.getInputs());
        RexNode value = rexBuilder.makeInputRef(typeFactory.createSqlType(SqlTypeName.INTEGER), 1);
        // baseline and bypasses capability routing; this test wants to exercise the
            "Expected planner to surface window-function capability gap, got: " + exception.getMessage(),
            SqlStdOperatorTable.CEIL,
        RelNode result = runProjectOnAgg(1);
        assertTrue("Outer FLOOR must be annotated", topLevel instanceof AnnotatedProjectExpression);
        assertTrue(result.getViableBackends().contains(MockDataFusionBackend.NAME));
                OpenSearchTableScan.class
        );
        RexNode outerExpr = rexBuilder.makeCall(SqlStdOperatorTable.FLOOR, ceilExpr);
    public void testPainlessDelegationFromDataFusionToLucene() {
        );
    /**
/*
            makeEquals(1, SqlTypeName.INTEGER, 100)
            SqlStdOperatorTable.CEIL,
        RexNode ceilExpr = rexBuilder.makeCall(
    public void testScalarFunctionWithAnyReturnTypeUsesOperandFallback() {
        MockLuceneBackend luceneAccepting = new MockLuceneBackend() {
    private List<AnalyticsSearchBackendPlugin> delegationBackends(String... opaqueOps) {
     */
        RexNode painlessExpr = rexBuilder.makeCall(PAINLESS, rexBuilder.makeInputRef(typeFactory.createSqlType(SqlTypeName.VARCHAR), 0));
        MockDataFusionBackend dfWithScalarsAndDelegation = new MockDataFusionBackend() {
        };
            SqlFunctionCategory.USER_DEFINED_FUNCTION
        );
            assertNoAnnotationInTree(expr);
                return Set.of();
            rexBuilder.makeInputRef(typeFactory.createSqlType(SqlTypeName.VARCHAR), 0),
        // declares support for, the rule must throw. Uses CEIL rather than CAST because
            false,
        MockDataFusionBackend dfWithPainless = new MockDataFusionBackend() {
        // FLOOR(CEIL(v_int)) — outer and inner both capability-declared scalars so
    }
        // Negative guard: the short-circuit must apply only to passthrough. If a RexCall is
        // depth before the plan reaches the backend FragmentConvertor — Substrait isthmus
    }
    // ---- Window functions ----
            new String[] { "name", "value" },
    }
    }
            @Override
        );
        }
            protected Set<ProjectCapability> projectCapabilities() {
            SqlStdOperatorTable.CEIL,
        );
        // CEIL(value) — capability-declared scalar. CAST was used previously but is
    /**
     */
        MockLuceneBackend luceneAccepting = new MockLuceneBackend() {
    }
            Set.of(MockDataFusionBackend.NAME)
        // (see OpenSearchProjectRule.BASELINE_SCALAR_OPS) and bypasses capability routing;
            @Override
            outerOriginal.getOperands().get(0) instanceof AnnotatedProjectExpression
            protected Set<org.opensearch.analytics.spi.WindowCapability> windowCapabilities() {
            stubScan(
                mockTable("test_index", new String[] { "name", "value" }, new SqlTypeName[] { SqlTypeName.VARCHAR, SqlTypeName.INTEGER })
            fieldNames.add("col_" + i);
    }
            "parquet",
    /**
            rowNumber
            rexBuilder.makeInputRef(typeFactory.createSqlType(SqlTypeName.INTEGER), 1)
            "test_index",
        List<AnalyticsSearchBackendPlugin> backends,
     */
        UnsupportedFunctionException exception = expectThrows(UnsupportedFunctionException.class, () -> runPlanner(project, context));
        );
            assertNoAnnotationInTree(expr);
import org.apache.calcite.rex.RexNode;
            @Override
            delegationBackends("painless"),
        };
        MockLuceneBackend luceneWithPainlessNoAccept = new MockLuceneBackend() {
        // carved out of capability enforcement (see OpenSearchProjectRule.BASELINE_SCALAR_OPS).
        RelOptTable table = mockTable(
     * it into a substrait {@code WindowFunctionInvocation}.
    }
 */
            result.getProjects().get(2) instanceof RexOver
            fieldRef,
            protected Set<ProjectCapability> projectCapabilities() {
                    scalarCaps(Set.of(MockDataFusionBackend.PARQUET_DATA_FORMAT), EnumSet.allOf(ScalarFunction.class)),
            protected Set<ProjectCapability> projectCapabilities() {
        Set<ProjectCapability> result = new HashSet<>();
        assertTrue(
        assertTrue(result.getViableBackends().contains(MockDataFusionBackend.NAME));
        );
            @Override
        PlannerContext context = buildContext("parquet", nameValueFields(), List.of(dfWithScalarFunctions(), LUCENE));
        OpenSearchProject result = runProject(
            SqlKind.OTHER_FUNCTION,
            List.of(dfWithDelegation, luceneAccepting, thirdBackend)
import com.google.common.collect.ImmutableList;
            opBinding -> typeFactory.createSqlType(SqlTypeName.ANY),
            null,
        assertFalse(
    /** DF (with PROJECT delegation) + Lucene (accepting, with given opaque ops). */
            "suggest",
            @Override
        OpenSearchProject result = runProject(
        // Reference the INTEGER column (index 1) from the stub scan's (VARCHAR, INTEGER) schema.
        }
            }
        assertTrue(result.getViableBackends().contains(MockDataFusionBackend.NAME));
                    opaqueCaps(Set.of(MockDataFusionBackend.PARQUET_DATA_FORMAT), "painless")
        assertFalse("Field ref should not be annotated", result.getProjects().get(0) instanceof AnnotatedProjectExpression);
            OperandTypes.VARIADIC,
            }
     * at every level.
        LogicalProject project = LogicalProject.create(stubScan(table), List.of(), List.of(ceilExpr), List.of("ceil_v"));
     */
    private static void assertNoAnnotationInTree(RexNode node) {
import org.apache.calcite.plan.RelOptTable;
        );
            rexBuilder.makeInputRef(typeFactory.createSqlType(SqlTypeName.INTEGER), 1)
            assertFalse("Passthrough expressions must not be annotated", expr instanceof AnnotatedProjectExpression);
            }
        LogicalProject project = LogicalProject.create(
        ReturnTypes.VARCHAR_2000,
    }
        RelOptTable table = mockTable(
import org.opensearch.analytics.spi.ProjectCapability;
        // Lucene supports painless but no delegation configured
     * Builds a {@code ROW_NUMBER() OVER (PARTITION BY $partitionField ORDER BY $orderField)}
        assertPipelineViableBackends(
        RelNode result = unwrapExchange(runPlanner(project, context));
        }
        RexNode ceilExpr = rexBuilder.makeCall(
            RexWindowExclusion.EXCLUDE_NO_OTHER,
    // ---- Nested expressions ----
        );
        assertAnnotation(result.getProjects().get(1), MockLuceneBackend.NAME);
        assertTrue(exception.getMessage().contains("is not currently supported"));
            @Override
import org.opensearch.analytics.planner.rel.AnnotatedProjectExpression;
    private OpenSearchProject runProject(
            @Override
        };
        assertTrue("Inner Project must contain the hoisted RexOver, exprs=" + innerExprs, foundRexOver);
            Set.of(MockDataFusionBackend.NAME)
    public void testOpaqueOperationSupportedNatively() {
                return opaqueCaps(Set.of(MockLuceneBackend.LUCENE_DATA_FORMAT), "painless");
            }
        assertTrue(result.getViableBackends().contains(MockDataFusionBackend.NAME));
        assertTrue("Stripped plan should be a plain LogicalProject", stripped instanceof LogicalProject);
import org.apache.calcite.sql.type.SqlTypeName;
            }
        RexNode painlessExpr = rexBuilder.makeCall(PAINLESS, rexBuilder.makeInputRef(typeFactory.createSqlType(SqlTypeName.VARCHAR), 0));
                mockTable("test_index", new String[] { "name", "value" }, new SqlTypeName[] { SqlTypeName.VARCHAR, SqlTypeName.INTEGER })
 * SPDX-License-Identifier: Apache-2.0
        RexNode partition = rexBuilder.makeInputRef(
        null,
        return new MockDataFusionBackend() {
            SqlStdOperatorTable.CEIL,
        LogicalProject project = LogicalProject.create(stubScan(table), List.of(), List.of(exprs), fieldNames);
        };
        // AnnotatedProjectExpression. stripAnnotations must remove every wrapper at every
            "parquet",
        MockLuceneBackend lucene = new MockLuceneBackend() {
        RexNode ceilExpr = rexBuilder.makeCall(
            List.of(dfWithDelegation, luceneWithPainlessNoAccept)
    }
        // CEIL over SUM result (field 1) — capability-declared scalar that flows through
            }
            caps.add(new ProjectCapability.Scalar(func, Set.of(FieldType.values()), formats, true));
        // CAST is baseline (see OpenSearchProjectRule.BASELINE_SCALAR_OPS) and would not
        // A backend that declares NO ProjectCapability should still execute a passthrough
        MockDataFusionBackend df = new MockDataFusionBackend() {
        RelOptTable table = mockTable(
    public void testRowNumberOverPartitionByOrderByMarksAsWindow() {
        boolean foundRexOver = false;
    }
            }
    }
        assertTrue(result.getViableBackends().contains(MockDataFusionBackend.NAME));
        assertTrue(((AnnotatedProjectExpression) expr).getViableBackends().contains(expectedBackend));
                OpenSearchProject.class,
        );
            SqlStdOperatorTable.ROW_NUMBER,
            }
        assertTrue("Inner plan must be a LogicalProject carrying the hoisted RexOver", innerInput instanceof LogicalProject);
            rexBuilder.makeCall(PAINLESS, rexBuilder.makeInputRef(typeFactory.createSqlType(SqlTypeName.VARCHAR), 0))
        };
        RexNode innerCall = outerAnnotation.getOriginal();
        RexNode suggestExpr = rexBuilder.makeCall(suggest, rexBuilder.makeInputRef(typeFactory.createSqlType(SqlTypeName.VARCHAR), 0));
            }
        RexNode painlessExpr = rexBuilder.makeCall(PAINLESS, rexBuilder.makeInputRef(typeFactory.createSqlType(SqlTypeName.VARCHAR), 0));
                return Set.of(DelegationType.PROJECT);
            RexWindowBounds.UNBOUNDED_PRECEDING,
        // RexExpressionConverter#visitOver downstream, which doesn't recognize the wrapper.
        assertTrue(exception.getMessage().contains("is not currently supported"));
            result.addAll(set);
            caps.add(new ProjectCapability.Opaque(name, formats));
    }
    private OpenSearchProject runProject(RexNode... exprs) {
    // ---- Delegation ----
    public void testProjectOnAggregateScanSingleShard() {
        );
import org.apache.calcite.plan.RelOptUtil;
    public void testProjectOnFilteredScan() {
        assertTrue(result.getViableBackends().contains(MockDataFusionBackend.NAME));
        );
        };
    }
        assertSame("precondition: UDF return type must be ANY", SqlTypeName.ANY, expr.getType().getSqlTypeName());
            null,
        assertTrue(
        RexNode painlessExpr = rexBuilder.makeCall(PAINLESS, rexBuilder.makeInputRef(typeFactory.createSqlType(SqlTypeName.VARCHAR), 0));
        };
 * Tests for project rule: scalar function validation, opaque operation
     * outer project must carry no annotation wrappers, and the inner project must preserve the
    public void testStripAnnotationsRecursivelyUnwrapsNestedExpressions() {
        PlannerContext context = buildContext("parquet", nameValueFields());
        assertAnnotation(result.getProjects().get(0), MockLuceneBackend.NAME);
    public void testUnsupportedScalarFunctionErrors() {
        for (int i = 0; i < exprs.length; i++)
}
            typeFactory.createSqlType(SqlTypeName.BIGINT),
        assertTrue("Stripped plan must be a plain LogicalProject", stripped instanceof LogicalProject);
                OpenSearchAggregate.class,
            Map.of("name", Map.of("type", "keyword")),
            protected Set<DelegationType> acceptedDelegations() {
    ) {
import org.opensearch.analytics.planner.rel.OpenSearchTableScan;
        assertPipelineViableBackends(
            ),
            @Override
            "Expression tree must not contain AnnotatedProjectExpression after strip: " + node,
            @Override
            @Override
        assertTrue(innerCall instanceof RexCall);
            "Inner CEIL must also be annotated (recursive annotateExpr behavior)",
        assertFalse("RexOver must not be annotated", result.getProjects().get(2) instanceof AnnotatedProjectExpression);
        //
        LogicalProject project = LogicalProject.create(stubScan(table), List.of(), List.of(painlessExpr), List.of("scripted"));
            SqlKind.OTHER_FUNCTION,
            }
        // resolution; this test's intent is to exercise the capability-match happy path.
        assertTrue(result.getViableBackends().contains(MockDataFusionBackend.NAME));
        return caps;
            List.of(dfWithPainless, LUCENE),
            MockDataFusionBackend.PARQUET_DATA_FORMAT,
            }
    }
        );
        // AnnotatedProjectExpression.
     * window-narrowing pass; the {@link RexOver} itself is left unannotated so that
        for (String name : names)
        RexNode topLevel = annotated.getProjects().get(0);
            true,
            SqlStdOperatorTable.CEIL,
        assertAnnotation(result.getProjects().get(0), MockLuceneBackend.NAME);
        // Negative guard: when a RexCall uses a capability-declared scalar that no backend
        assertAnnotation(result.getProjects().get(0), MockDataFusionBackend.NAME);
    }
            protected Set<ProjectCapability> projectCapabilities() {
        logger.info("Plan:\n{}", RelOptUtil.toString(result));
            }
        // present and the backend declares no matching scalar ProjectCapability, the rule must
            SqlStdOperatorTable.CEIL,
    }
    public void testProjectOnAggregateScanMultiShard() {
        );
    private RelNode runProjectOnAgg(int shardCount) {
            }
            new String[] { "name", "value" },
     * fall back to inferring the operand type (DOUBLE here) so downstream backend capability
            protected Set<ProjectCapability> projectCapabilities() {
        // projection (only field refs). Verifies the short-circuit in OpenSearchProjectRule.onMatch
     */
    }
            rexBuilder.makeCall(PAINLESS, rexBuilder.makeInputRef(typeFactory.createSqlType(SqlTypeName.VARCHAR), 0))
        assertTrue(
        return runProject("parquet", List.of(dfWithScalarFunctions(), LUCENE), Set.of(MockDataFusionBackend.NAME), exprs);
        String format,
            protected Set<DelegationType> supportedDelegations() {
        );
        );
            }
            List.of(
        OpenSearchProject result = runProject(
        // Strip and assert no AnnotatedProjectExpression survives anywhere in the RexNode tree.
            @Override
        // OpenSearchProjectRule.BASELINE_SCALAR_OPS) and no longer produce annotation.
                return Set.of(DelegationType.PROJECT);
        return rexBuilder.makeOver(
            @Override
        );
            }
            OperandTypes.ANY,
    public void testExpressionProjectionStillRequiresCapabilityWithoutDeclaration() {
        assertAnnotation(result.getProjects().get(0), MockDataFusionBackend.NAME);
        // annotation. CAST was used previously but is baseline (see
            List.of(new MockDataFusionBackend(), LUCENE),
        assertTrue(result.getViableBackends().contains(MockDataFusionBackend.NAME));
    }
    }
            @Override
import org.apache.calcite.sql.type.OperandTypes;
        );
            protected Set<ProjectCapability> projectCapabilities() {
        // Sanity: confirm the rule produced the nested-wrapper shape this test exercises.
            List.of(rexBuilder.makeInputRef(typeFactory.createSqlType(SqlTypeName.VARCHAR), 0), rowNumber),
        RexNode ceilExpr = rexBuilder.makeCall(
            rexBuilder.makeInputRef(typeFactory.createSqlType(SqlTypeName.INTEGER), 1)
    private OpenSearchProject runProject(String format, List<AnalyticsSearchBackendPlugin> backends, RexNode... exprs) {
    public void testDelegationFailsWhenAcceptorRejectsDelegationType() {
    private static Set<ProjectCapability> opaqueCaps(Set<String> formats, String... names) {
        // still throw — otherwise a later refactor could silently loosen the gate too much.
        // PLUS / POWER are baseline (see OpenSearchProjectRule.BASELINE_SCALAR_OPS), so
        assertTrue(result.getViableBackends().contains(MockDataFusionBackend.NAME));
     * and rewrites the outer expression to a {@link RexInputRef} into the hoisted slot. The
    }
        };
        // structure while still going through capability resolution.
        }
        return result;
            }
    private static Set<ProjectCapability> scalarCaps(Set<String> formats, Set<ScalarFunction> functions) {
                return "mock-third";
        SqlFunction scalarMaxUdf = new SqlFunction(
     * time rather than failing later in substrait emission.
        MockDataFusionBackend dfNoWindow = new MockDataFusionBackend() {
    }
     * When no viable backend declares a {@link org.opensearch.analytics.spi.WindowCapability}
            Set.of()
            "parquet",
            scalarExpr
            rexBuilder.makeInputRef(typeFactory.createSqlType(SqlTypeName.VARCHAR), 0),
            new String[] { "name", "value" },
            }
    }
import org.opensearch.analytics.spi.ScalarFunction;
    public void testPassthroughProjectionSucceedsWithoutProjectCapability() {
                return opaqueCaps(Set.of(MockLuceneBackend.LUCENE_DATA_FORMAT), "suggest");
        OpenSearchProject result = runProject(outerExpr);
    public void testStripAnnotationsPreservesRexOver() {
    }
        OpenSearchProject annotated = runProject(rexBuilder.makeInputRef(typeFactory.createSqlType(SqlTypeName.VARCHAR), 0), rowNumber);
        assertTrue(result.getViableBackends().contains(MockDataFusionBackend.NAME));
    private static Set<ProjectCapability> combine(Set<ProjectCapability>... sets) {
import org.apache.calcite.sql.SqlKind;
import org.opensearch.analytics.planner.rel.OpenSearchExchangeReducer;
        // that skips the backend-refinement gate when no RexCall needs evaluation.
            for (RexNode operand : call.getOperands()) {
            new SqlTypeName[] { SqlTypeName.VARCHAR, SqlTypeName.INTEGER }
        RelNode stripped = annotated.stripAnnotations(annotated.getInputs());
            Map.of("name", Map.of("type", "keyword")),
import java.util.Map;
        for (Set<ProjectCapability> set : sets)
                return opaqueCaps(Set.of(MockLuceneBackend.LUCENE_DATA_FORMAT), "painless");
            }
     * Strip-annotations on a project containing a {@link RexOver} hoists each unique window
        LogicalProject project = LogicalProject.create(agg, List.of(), List.of(ceilExpr), List.of("col_0"));
        RexNode scalarExpr = rexBuilder.makeCall(
    /**
    }
        RelOptTable table = mockTable("test_index", new String[] { "name" }, new SqlTypeName[] { SqlTypeName.VARCHAR });
        };
        UnsupportedFunctionException exception = expectThrows(UnsupportedFunctionException.class, () -> runPlanner(project, context));
        assertFalse(result.getViableBackends().contains(MockLuceneBackend.NAME));
    private static final SqlFunction HIGHLIGHT = new SqlFunction(
        RelNode innerInput = stripped.getInputs().get(0);
        //
            false
        RexNode rowNumber = makeRowNumberOver(/*partitionField*/ 0, /*orderField*/ 1);
                return scalarCaps(Set.of(MockDataFusionBackend.PARQUET_DATA_FORMAT), EnumSet.allOf(ScalarFunction.class));
            List.of("name", "rn")
    private static Map<String, Map<String, Object>> nameValueFields() {
        // The operand-type fallback must resolve INTEGER → FieldType.INTEGER so the backend
import org.opensearch.analytics.spi.DelegationType;
        return Map.of("name", Map.of("type", "keyword"), "value", Map.of("type", "integer"));
            protected Set<ProjectCapability> projectCapabilities() {
        return caps;
        for (RexNode expr : result.getProjects()) {
        OpenSearchProject result = runProject(ceilExpr);
            painlessExpr,
        RexNode upperExpr = rexBuilder.makeCall(SqlStdOperatorTable.UPPER, painlessExpr);
        );
            new SqlTypeName[] { SqlTypeName.VARCHAR, SqlTypeName.INTEGER }
    }
            delegationBackends("painless", "highlight"),
        OpenSearchProject result = runProject(
/**
                return Set.of(DelegationType.PROJECT);
                return Set.of(DelegationType.PROJECT);
            rexBuilder.makeCall(HIGHLIGHT, rexBuilder.makeInputRef(typeFactory.createSqlType(SqlTypeName.VARCHAR), 0))
        assertAnnotation(result.getProjects().get(0), MockDataFusionBackend.NAME);
     * {@link RexOver} verbatim so isthmus's {@code RexExpressionConverter#visitOver} can decode
            new SqlTypeName[] { SqlTypeName.VARCHAR, SqlTypeName.INTEGER }
import org.apache.calcite.rex.RexWindowExclusion;
        UnsupportedFunctionException exception = expectThrows(UnsupportedFunctionException.class, () -> runPlanner(project, context));
                foundRexOver = true;
        };
            @Override
 *
            protected Set<ProjectCapability> projectCapabilities() {
            ),
        // because they bypass capability enforcement and would not produce an
        assertFalse("Field ref must not be annotated", result.getProjects().get(0) instanceof AnnotatedProjectExpression);
            rexBuilder.makeInputRef(agg.getRowType().getFieldList().get(1).getType(), 1)
        List<RexNode> outerExprs = ((LogicalProject) stripped).getProjects();
        };
    }
        RelNode result = unwrapExchange(runPlanner(project, context));
                return scalarCaps(Set.of(MockDataFusionBackend.PARQUET_DATA_FORMAT), EnumSet.allOf(ScalarFunction.class));
        );
import org.apache.calcite.sql.type.ReturnTypes;
        };
import java.util.EnumSet;
            @Override
        UnsupportedFunctionException exception = expectThrows(UnsupportedFunctionException.class, () -> runPlanner(project, context));
        RelNode filter = makeFilter(
            "SCALAR_MAX",
    }
 */
        "highlight",
            protected Set<DelegationType> acceptedDelegations() {
        RexCall outerOriginal = (RexCall) ((AnnotatedProjectExpression) topLevel).getOriginal();
        assertFalse("Field ref should not be annotated", result.getProjects().get(0) instanceof AnnotatedProjectExpression);
        // CEIL(v_int) — capability-declared scalar. CAST was used previously but is baseline
                return opaqueCaps(Set.of(MockLuceneBackend.LUCENE_DATA_FORMAT), opaqueOps);
            partitionField
import org.apache.calcite.rex.RexOver;
        assertTrue(
        }
        SqlFunctionCategory.USER_DEFINED_FUNCTION
        );
            true,
import java.util.ArrayList;
        List<String> fieldNames = List.of("col_0");
     * Project(Filter(Scan)) — verifies annotation propagation through filter→project
        logger.info("Plan:\n{}", RelOptUtil.toString(result));
                return opaqueCaps(Set.of(MockLuceneBackend.LUCENE_DATA_FORMAT), "painless");
        RexNode fieldRef = rexBuilder.makeInputRef(typeFactory.createSqlType(SqlTypeName.VARCHAR), 0);
        );
        // capability lookup succeeds.
        }
        }
    // ---- Mixed backends in one projection ----
        assertAnnotation(result.getProjects().get(0), MockDataFusionBackend.NAME);
    }
        // was used previously but both PLUS and CAST are baseline scalars (see
            result,
            rexBuilder.makeInputRef(typeFactory.createSqlType(SqlTypeName.INTEGER), 1)
 * compatible open source license.
     * {@code ROW_NUMBER() OVER (PARTITION BY ... ORDER BY ...)} inside a {@code LogicalProject}.
    // ---- Simple projection ----
    private MockDataFusionBackend dfWithScalarFunctions() {
        RexNode ceilExpr = rexBuilder.makeCall(
        RexNode rowNumber = makeRowNumberOver(/*partitionField*/ 0, /*orderField*/ 1);
    }
            "parquet",
        PlannerContext context = buildContext(
    /**
        OpenSearchProject result = runProject(
        RelNode result = runProjectOnAgg(2);
        RexFieldCollation order = new RexFieldCollation(
        );
            delegationBackends("painless"),
            new String[] { "name", "value" },
            rexBuilder.makeInputRef(typeFactory.createSqlType(SqlTypeName.INTEGER), 1)
        SqlFunction suggest = new SqlFunction(
        logger.info("Plan ({} shard(s)):\n{}", shardCount, RelOptUtil.toString(result));
            List.of(),
 * this file be licensed under the Apache-2.0 license or a
            "parquet",
        SqlKind.OTHER_FUNCTION,
        RexNode ceilExpr = rexBuilder.makeCall(
            new SqlTypeName[] { SqlTypeName.VARCHAR, SqlTypeName.INTEGER }
     * The project rule narrows viable backends via {@link
     * dispatch proceeds normally. The actual operator rewrite to {@code GREATEST} happens later
import java.util.HashSet;
        );
        return (OpenSearchProject) result;
        // trigger capability enforcement.
        assertAnnotation(result.getProjects().get(0), MockDataFusionBackend.NAME);
        OperandTypes.ANY,
        MockLuceneBackend luceneWithPainless = new MockLuceneBackend() {
        OperandTypes.ANY,
        LogicalProject project = LogicalProject.create(filter, List.of(), List.of(ceilExpr), fieldNames);
        RelOptTable table = mockTable(
        );
            List.of(OpenSearchProject.class, OpenSearchAggregate.class, OpenSearchTableScan.class),
        );
public class ProjectRuleTests extends BasePlannerRulesTests {
        RelOptTable table = mockTable("test_index", new String[] { "name" }, new SqlTypeName[] { SqlTypeName.VARCHAR });
            "test_index",
import org.apache.calcite.sql.SqlFunctionCategory;
        return result;
        // call".
import org.apache.calcite.rex.RexInputRef;
        // Uses CEIL (capability-declared scalar) rather than CAST — CAST is a baseline operator
        OpenSearchProject result = runProject(
            rexBuilder.makeInputRef(typeFactory.createSqlType(SqlTypeName.VARCHAR), 0),
    public void testSimpleFieldProjection() {
            }
import org.apache.calcite.sql.fun.SqlStdOperatorTable;
            ImmutableList.of(order),
        );
        assertPipelineViableBackends(result, List.of(OpenSearchProject.class, OpenSearchTableScan.class), expectedViable);
            ReturnTypes.VARCHAR_2000,
        assertTrue("Expected OpenSearchProject", result instanceof OpenSearchProject);
        PlannerContext context = buildContext("parquet", nameValueFields(), List.of(dfNoWindow, LUCENE));
     * RexOver against the (VARCHAR, INTEGER) stub-scan schema.
        assertAnnotation(((OpenSearchProject) result).getProjects().get(0), MockDataFusionBackend.NAME);
            List.of(DATAFUSION, luceneWithPainless)
            false,
        // annotation happens at both levels. CAST / PLUS / POWER are baseline scalars (see
        Set<ProjectCapability> caps = new HashSet<>();
     * directly into a substrait {@code WindowFunctionInvocation}.
                return combine(
            stubScan(table),
        for (RexNode expr : outerExprs) {
            "Hoisted outer expr must be a RexInputRef into the inner Project, was " + outerExprs.get(1).getClass().getSimpleName(),
            protected Set<ProjectCapability> projectCapabilities() {
                return Set.of(DelegationType.PROJECT);
        OpenSearchProject annotated = runProject(floorCall);
        "painless",
        // OpenSearchProjectRule.BASELINE_SCALAR_OPS) and are deliberately not used here
import org.apache.calcite.rex.RexWindowBounds;
     */
            public String name() {
            "Expected AnnotatedProjectExpression, got " + expr.getClass().getSimpleName(),
            @Override
        for (RexNode expr : result.getProjects()) {
            "test_index",
        );
    }
        AnnotatedProjectExpression outerAnnotation = (AnnotatedProjectExpression) result.getProjects().get(0);
        // Third backend declares "suggest" so isOpaqueOperation returns true, but no acceptor handles it
            protected Set<DelegationType> supportedDelegations() {
        RexNode intRef = rexBuilder.makeInputRef(typeFactory.createSqlType(SqlTypeName.INTEGER), 1);
        RexNode rowNumber = makeRowNumberOver(/*partitionField*/ 0, /*orderField*/ 1);
     * PPL's {@code top}/{@code rare}/{@code streamstats} commands lower to
            node instanceof AnnotatedProjectExpression
     */
        LogicalProject project = LogicalProject.create(stubScan(table), List.of(), List.of(suggestExpr), List.of("sg"));
        assertTrue(result.getViableBackends().contains(MockDataFusionBackend.NAME));
        );
            List.of(partition),
        return List.of(df, lucene);
            expr instanceof AnnotatedProjectExpression
    public void testPainlessErrorsWithoutDelegation() {
            protected Set<DelegationType> supportedDelegations() {
        // project-over-filter annotation path.
        );
        assertPipelineViableBackends(
     * call into a child {@link LogicalProject} (see {@code OpenSearchProject#liftNestedRexOver})
    /**
        Set<String> expectedViable,
            rexBuilder.makeInputRef(typeFactory.createSqlType(SqlTypeName.INTEGER), 1)
        // has no converter for ANNOTATED_PROJECT_EXPR and would throw "Unable to convert
        PlannerContext context = buildContext(format, nameValueFields(), backends);
            RexWindowBounds.CURRENT_ROW,
        PlannerContext context = buildContext("parquet", shardCount, nameValueFields(), List.of(dfWithScalarFunctions(), LUCENE));
    private RexNode makeRowNumberOver(int partitionField, int orderField) {
        assertTrue(exception.getMessage().contains("is not currently supported"));
        LogicalProject project = LogicalProject.create(stubScan(table), List.of(), List.of(ceilExpr), List.of("casted"));
    /** DF backend with all scalar functions declared. */
        MockDataFusionBackend dfWithDelegation = new MockDataFusionBackend() {
    private void assertAnnotation(RexNode expr, String expectedBackend) {
        PlannerContext context = buildContext(
            typeFactory.createSqlType(partitionField == 0 ? SqlTypeName.VARCHAR : SqlTypeName.INTEGER),
        assertTrue(result.getViableBackends().contains(MockDataFusionBackend.NAME));
        null,
                return Set.of(DelegationType.PROJECT);
        assertFalse("Field ref must not be annotated", result.getProjects().get(1) instanceof AnnotatedProjectExpression);
    public void testDelegationFailsWhenAcceptorLacksOpaqueOp() {
            List.of(dfWithScalarsAndDelegation, luceneAccepting),
    }
    }
        // OpenSearchProjectRule.BASELINE_SCALAR_OPS).
     * Project(Agg(Scan)) — single shard: SOURCE(SINGLETON) scan satisfies the root's
import org.apache.calcite.rex.RexCall;
        assertTrue(
        OpenSearchProject result = runProject("parquet", List.of(dfWithScalarsAndDelegation, luceneAccepting), upperExpr);
        );
        RexNode floorCall = rexBuilder.makeCall(SqlStdOperatorTable.FLOOR, ceilCall);
        assertAnnotation(painlessInside, MockLuceneBackend.NAME);
        List<String> fieldNames = new ArrayList<>();
        assertAnnotation(((OpenSearchProject) result).getProjects().get(0), MockDataFusionBackend.NAME);
                return scalarCaps(Set.of(MockDataFusionBackend.PARQUET_DATA_FORMAT), EnumSet.allOf(ScalarFunction.class));
import org.apache.calcite.rex.RexFieldCollation;
import org.apache.calcite.sql.SqlFunction;
        UnsupportedFunctionException exception = expectThrows(UnsupportedFunctionException.class, () -> runPlanner(project, context));
        );
        RexNode... exprs
        // RexOver and pass-through field refs must NOT be annotated — RexOver dispatches through
import org.opensearch.analytics.spi.FieldType;
    public void testScalarWrappingOpaqueOp() {
        // FLOOR(CEIL(value)) — a non-baseline scalar call with another non-baseline
        // UPPER(PAINLESS(x)) — non-baseline scalar wrapping an opaque op. PLUS(CAST(...), ...)
        assertTrue(exception.getMessage().contains("is not currently supported"));
        // at the appended slot so substrait emission sees the WindowFunction at top level.
     * strip-annotations / isthmus's {@code RexExpressionConverter#visitOver} can decode it
import org.apache.calcite.rel.logical.LogicalProject;
            SqlFunctionCategory.USER_DEFINED_FUNCTION
    }
        };
        PlannerContext context = buildContext("parquet", nameValueFields(), List.of(new MockDataFusionBackend(), LUCENE));
        RexNode ceilCall = rexBuilder.makeCall(SqlStdOperatorTable.CEIL, value);
     * PPL emits {@code SCALAR_MAX(a, b, c)} as a UDF whose return type is {@link SqlTypeName#ANY}
        );
        MockDataFusionBackend dfWithDelegation = new MockDataFusionBackend() {
        MockLuceneBackend luceneAccepting = new MockLuceneBackend() {
            }
        for (ScalarFunction func : functions) {
     * org.opensearch.analytics.spi.BackendCapabilityProvider#windowCapabilities()} on the rule's
        RelOptTable table = mockTable("test_index", new String[] { "name" }, new SqlTypeName[] { SqlTypeName.VARCHAR });
            rexBuilder.makeInputRef(typeFactory.createSqlType(SqlTypeName.INTEGER), 1)
        OpenSearchProject result = runProject(
                OpenSearchAggregate.class,
        assertAnnotation(((OpenSearchProject) result).getProjects().get(0), MockDataFusionBackend.NAME);
    public void testMixedFieldAndPainlessWithDelegation() {
        // CEIL(int_col) — capability-declared scalar. CAST was used previously but is
            rexBuilder.makeInputRef(typeFactory.createSqlType(SqlTypeName.INTEGER), orderField),
            ),
        assertTrue(exception.getMessage().contains("is not currently supported"));
            "parquet",
import org.apache.calcite.rel.RelNode;
                return opaqueCaps(Set.of(MockLuceneBackend.LUCENE_DATA_FORMAT), "painless");
        };
        // The inner Project (hoisted from liftNestedRexOver) must hold the original RexOver
        OpenSearchProject result = runProject(expr);
        MockDataFusionBackend dfWithScalarsAndDelegation = new MockDataFusionBackend() {
                return scalarCaps(Set.of(MockDataFusionBackend.PARQUET_DATA_FORMAT), EnumSet.allOf(ScalarFunction.class));
            }
     * RESULT(SINGLETON) demand, so the aggregate stays SINGLE and no ER is inserted.
            stubScan(
            @Override
        return runProject(format, backends, Set.of(MockDataFusionBackend.NAME), exprs);
        // this test uses FLOOR+CEIL to preserve the nested-call-with-nested-annotation
            Map.of("name", Map.of("type", "keyword")),
    public void testRowNumberWithoutWindowCapabilityErrors() {
        );
     * — a consequence of the underlying {@code ScalarMaxFunction} being polymorphic across numeric
            "parquet",
        SqlFunctionCategory.USER_DEFINED_FUNCTION
            protected Set<ProjectCapability> projectCapabilities() {
import java.util.Set;
            }
            Set.of(MockDataFusionBackend.NAME)
        for (RexNode expr : ((LogicalProject) stripped).getProjects()) {
        );
                OpenSearchExchangeReducer.class,
        assertAnnotation(result.getProjects().get(2), MockDataFusionBackend.NAME);
        LogicalProject project = LogicalProject.create(stubScan(table), List.of(), List.of(painlessExpr), List.of("scripted_field"));
        for (RexNode innerExpr : innerExprs) {
     * and string types. The project rule must not reject such calls outright; instead it should
     * covering {@code ROW_NUMBER}, the planner must surface a capability-gap error at plan
                return Set.of(DelegationType.PROJECT);
            @Override
            "test_index",
            }
    public void testHighlightDelegation() {
                return opaqueCaps(Set.of(MockLuceneBackend.LUCENE_DATA_FORMAT), "painless", "highlight");
            exception.getMessage().contains("ROW_NUMBER") && exception.getMessage().contains("is not currently supported")
    }
            @Override
    }
        // baseline (see OpenSearchProjectRule.BASELINE_SCALAR_OPS) and bypasses capability
        );
    public void testSupportedScalarFunction() {
        // the test still intends to exercise scalar-backend annotation.
            rexBuilder.makeInputRef(typeFactory.createSqlType(SqlTypeName.INTEGER), 1)
import java.util.List;
            protected Set<ProjectCapability> projectCapabilities() {
            "parquet",
            List.of(OpenSearchProject.class, OpenSearchFilter.class, OpenSearchTableScan.class),
        ReturnTypes.VARCHAR_2000,
 * The OpenSearch Contributors require contributions made to
            protected Set<ProjectCapability> projectCapabilities() {
        // (annotateExpr), so both FLOOR and the inner CEIL get wrapped in
            @Override
import org.opensearch.analytics.planner.rel.OpenSearchAggregate;
    /**
        RelNode result = unwrapExchange(runPlanner(project, context));
        PlannerContext context = buildContext(
            rexBuilder.makeInputRef(typeFactory.createSqlType(SqlTypeName.INTEGER), 1),
import org.opensearch.analytics.planner.rel.OpenSearchFilter;
            sumCall()
    // ---- Composed pipeline shapes ----
import org.opensearch.analytics.planner.rel.OpenSearchProject;
            rexBuilder.makeCall(PAINLESS, rexBuilder.makeInputRef(typeFactory.createSqlType(SqlTypeName.VARCHAR), 0))
                return Set.of(DelegationType.PROJECT);
        RexNode painlessInside = ((RexCall) innerCall).getOperands().get(0);
            @Override
        OpenSearchProject result = runProject(
        );
            @Override
                );
                return Set.of(DelegationType.PROJECT);
        MockLuceneBackend thirdBackend = new MockLuceneBackend() {
    public void testMixedBackendsInProjection() {
    private static final SqlFunction PAINLESS = new SqlFunction(
        UnsupportedFunctionException exception = expectThrows(UnsupportedFunctionException.class, () -> runPlanner(project, context));
        );
