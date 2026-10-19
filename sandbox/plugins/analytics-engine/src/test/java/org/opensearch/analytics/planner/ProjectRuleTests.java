import org.opensearch.analytics.spi.FieldType;
        assertAnnotation(result.getProjects().get(0), MockDataFusionBackend.NAME);  
            }  
        );
     */
        PlannerContext context = buildContext("parquet", shardCount, nameValueFields(), List.of(dfWithScalarFunctions(), LUCENE));  
            protected Set<ProjectCapability> projectCapabilities() {
            new String[] { "name", "value" },  
        PlannerContext context = buildContext("parquet", nameValueFields(), List.of(new MockDataFusionBackend(), LUCENE));
        OpenSearchProject result = runProject(
        // Third backend declares "suggest" so isOpaqueOperation returns true, but no acceptor handles it
            new SqlTypeName[] { SqlTypeName.VARCHAR, SqlTypeName.INTEGER }
        OpenSearchProject result = runProject(  
            }  
        );
/*  
    }
        assertTrue(exception.getMessage().contains("is not currently supported"));
public class ProjectRuleTests extends BasePlannerRulesTests {
        RexNode partition = rexBuilder.makeInputRef(  
        MockDataFusionBackend dfNoWindow = new MockDataFusionBackend() {
    public void testDelegationFailsWhenAcceptorLacksOpaqueOp() {
    }
        PlannerContext context = buildContext(
        assertTrue(result.getViableBackends().contains(MockDataFusionBackend.NAME));
        LogicalProject project = LogicalProject.create(stubScan(table), List.of(), List.of(ceilExpr), List.of("ceil_v"));  
        );
        RexNode painlessExpr = rexBuilder.makeCall(PAINLESS, rexBuilder.makeInputRef(typeFactory.createSqlType(SqlTypeName.VARCHAR), 0));
     * {@link RexOver} verbatim so isthmus's {@code RexExpressionConverter#visitOver} can decode
        // UPPER(PAINLESS(x)) — non-baseline scalar wrapping an opaque op. PLUS(CAST(...), ...)
     * RexOver against the (VARCHAR, INTEGER) stub-scan schema.  
    /**
        List<String> fieldNames = new ArrayList<>();  
            Map.of("name", Map.of("type", "keyword")),  
        // declares support for, the rule must throw. Uses CEIL rather than CAST because  
import org.opensearch.analytics.spi.ScalarFunction;  
    @SafeVarargs
            protected Set<ProjectCapability> projectCapabilities() {
            "test_index",
        };  
        //
            protected Set<ProjectCapability> projectCapabilities() {
        OpenSearchProject result = runProject("parquet", List.of(dfWithScalarsAndDelegation, luceneAccepting), upperExpr);  
        // that skips the backend-refinement gate when no RexCall needs evaluation.
            new SqlTypeName[] { SqlTypeName.VARCHAR, SqlTypeName.INTEGER }
     */
import org.opensearch.analytics.planner.rel.OpenSearchFilter;
                return opaqueCaps(Set.of(MockLuceneBackend.LUCENE_DATA_FORMAT), "painless");
            exception.getMessage().contains("ROW_NUMBER") && exception.getMessage().contains("is not currently supported")
        );
        RexNode intRef = rexBuilder.makeInputRef(typeFactory.createSqlType(SqlTypeName.INTEGER), 1);  
import org.apache.calcite.sql.type.OperandTypes;
        for (RexNode expr : result.getProjects()) {
            SqlKind.OTHER_FUNCTION,
        MockDataFusionBackend dfWithScalarsAndDelegation = new MockDataFusionBackend() {
    }
        RexNode rowNumber = makeRowNumberOver(/*partitionField*/ 0, /*orderField*/ 1);
            "test_index",
            @Override
            rexBuilder.makeInputRef(typeFactory.createSqlType(SqlTypeName.INTEGER), 1),
        // The operand-type fallback must resolve INTEGER → FieldType.INTEGER so the backend
        RexNode ceilExpr = rexBuilder.makeCall(  
            rexBuilder.makeInputRef(typeFactory.createSqlType(SqlTypeName.INTEGER), 1)
            }  
            @Override
        // Negative guard: when a RexCall uses a capability-declared scalar that no backend
            }  
        for (RexNode expr : ((LogicalProject) stripped).getProjects()) {
                return Set.of(DelegationType.PROJECT);
        // FLOOR(CEIL(v_int)) — outer and inner both capability-declared scalars so  
        };
        boolean foundRexOver = false;  
        );
        PlannerContext context = buildContext(
     * covering {@code ROW_NUMBER}, the planner must surface a capability-gap error at plan  
            List.of(),
            "parquet",  
            false,
            rexBuilder.makeCall(PAINLESS, rexBuilder.makeInputRef(typeFactory.createSqlType(SqlTypeName.VARCHAR), 0))  
    // ---- Opaque natively supported ----  
        RexNode scalarExpr = rexBuilder.makeCall(
            protected Set<DelegationType> supportedDelegations() {
        logger.info("Plan:\n{}", RelOptUtil.toString(result));  
            result,
    }
            false,
                return Set.of(DelegationType.PROJECT);
        // PLUS / POWER are baseline (see OpenSearchProjectRule.BASELINE_SCALAR_OPS), so  
        // call".
            protected Set<ProjectCapability> projectCapabilities() {
        assertTrue(result.getViableBackends().contains(MockDataFusionBackend.NAME));
import org.opensearch.analytics.spi.DelegationType;  
            List.of(DATAFUSION, luceneWithPainless)
    );
        // at the appended slot so substrait emission sees the WindowFunction at top level.
            "parquet",
        // OpenSearchProjectRule.BASELINE_SCALAR_OPS) and no longer produce annotation.  
            ),
        );
                return scalarCaps(Set.of(MockDataFusionBackend.PARQUET_DATA_FORMAT), EnumSet.allOf(ScalarFunction.class));
            result.getProjects().get(2) instanceof RexOver  
        RexNode ceilExpr = rexBuilder.makeCall(
            @Override
            @Override  
import org.apache.calcite.sql.type.SqlTypeName;
        assertFalse("Field ref should not be annotated", result.getProjects().get(0) instanceof AnnotatedProjectExpression);
            rexBuilder.makeInputRef(typeFactory.createSqlType(SqlTypeName.VARCHAR), 0),  
        assertAnnotation(painlessInside, MockLuceneBackend.NAME);
        // present and the backend declares no matching scalar ProjectCapability, the rule must
        };
    /** DF backend with all scalar functions declared. */  
            protected Set<DelegationType> supportedDelegations() {
        for (RexNode innerExpr : innerExprs) {
        OpenSearchProject result = runProject(  
     * Strip-annotations on a project containing a {@link RexOver} hoists each unique window
                return Set.of(DelegationType.PROJECT);  
            SqlStdOperatorTable.CEIL,
    );
     * Project(Agg(Scan)) — single shard: SOURCE(SINGLETON) scan satisfies the root's
import org.apache.calcite.sql.fun.SqlStdOperatorTable;
            }
        assertTrue("Stripped plan must be a plain LogicalProject", stripped instanceof LogicalProject);  
    private OpenSearchProject runProject(RexNode... exprs) {
        assertTrue(
import org.apache.calcite.plan.RelOptTable;
    /**  
    public void testSupportedScalarFunction() {  
        RexNode upperExpr = rexBuilder.makeCall(SqlStdOperatorTable.UPPER, painlessExpr);
                return opaqueCaps(Set.of(MockLuceneBackend.LUCENE_DATA_FORMAT), "painless");
    }  
            false  
import java.util.Map;  
     * window-narrowing pass; the {@link RexOver} itself is left unannotated so that
     * PPL's {@code top}/{@code rare}/{@code streamstats} commands lower to
        };
    // ---- Nested expressions ----  
        SqlFunctionCategory.USER_DEFINED_FUNCTION  
            rexBuilder.makeInputRef(typeFactory.createSqlType(SqlTypeName.INTEGER), 1)
        OpenSearchProject result = runProject(
            }
            caps.add(new ProjectCapability.Scalar(func, Set.of(FieldType.values()), formats, true));  
        // CAST is baseline (see OpenSearchProjectRule.BASELINE_SCALAR_OPS) and would not
            @Override
            delegationBackends("painless"),
            @Override  
        PlannerContext context = buildContext(format, nameValueFields(), backends);
    }
     */
            MockDataFusionBackend.PARQUET_DATA_FORMAT,  
            result,
    public void testPassthroughProjectionSucceedsWithoutProjectCapability() {
import org.opensearch.analytics.planner.rel.OpenSearchAggregate;  
 */  
            SqlStdOperatorTable.CEIL,
    }
     * RESULT(SINGLETON) demand, so the aggregate stays SINGLE and no ER is inserted.
        // AnnotatedProjectExpression.
    // ---- Simple projection ----  
            rexBuilder.makeInputRef(typeFactory.createSqlType(SqlTypeName.INTEGER), 1)
            @Override
import java.util.List;
        assertAnnotation(result.getProjects().get(2), MockDataFusionBackend.NAME);  
        RelNode result = runProjectOnAgg(2);  
        RexNode expr = rexBuilder.makeCall(scalarMaxUdf, intRef, intRef);
        RelOptTable table = mockTable("test_index", new String[] { "name" }, new SqlTypeName[] { SqlTypeName.VARCHAR });
    public void testProjectOnFilteredScan() {  
        // Uses CEIL (capability-declared scalar) rather than CAST — CAST is a baseline operator
        RelOptTable table = mockTable(
        RexNode rowNumber = makeRowNumberOver(/*partitionField*/ 0, /*orderField*/ 1);  
    }
            "Expected AnnotatedProjectExpression, got " + expr.getClass().getSimpleName(),
     */  
        assertTrue(
            "Inner CEIL must also be annotated (recursive annotateExpr behavior)",
            null,  
    // ---- Delegation ----
    }
            OperandTypes.ANY,
            protected Set<DelegationType> acceptedDelegations() {  
            fieldRef,
     */
            rexBuilder.makeInputRef(typeFactory.createSqlType(SqlTypeName.INTEGER), 1)
        assertTrue(result.getViableBackends().contains(MockDataFusionBackend.NAME));  
        ReturnTypes.VARCHAR_2000,  
        OpenSearchProject result = runProject(expr);
                mockTable("test_index", new String[] { "name", "value" }, new SqlTypeName[] { SqlTypeName.VARCHAR, SqlTypeName.INTEGER })  
            @Override  
        assertTrue("Stripped plan should be a plain LogicalProject", stripped instanceof LogicalProject);
        assertPipelineViableBackends(
import org.apache.calcite.rex.RexInputRef;
        MockLuceneBackend thirdBackend = new MockLuceneBackend() {
     * and rewrites the outer expression to a {@link RexInputRef} into the hoisted slot. The  
        assertSame("precondition: UDF return type must be ANY", SqlTypeName.ANY, expr.getType().getSqlTypeName());
        assertFalse("RexOver must not be annotated", result.getProjects().get(2) instanceof AnnotatedProjectExpression);  
    }  
        assertTrue(exception.getMessage().contains("is not currently supported"));
            "test_index",
        assertFalse("Field ref must not be annotated", result.getProjects().get(0) instanceof AnnotatedProjectExpression);
        // Strip and assert no AnnotatedProjectExpression survives anywhere in the RexNode tree.
        );
        assertTrue("Outer FLOOR must be annotated", topLevel instanceof AnnotatedProjectExpression);
        OpenSearchProject annotated = runProject(floorCall);  
    }
            rowNumber
            }
 * SPDX-License-Identifier: Apache-2.0
        // RexOver and pass-through field refs must NOT be annotated — RexOver dispatches through
import org.apache.calcite.rex.RexFieldCollation;
            "Hoisted outer expr must be a RexInputRef into the inner Project, was " + outerExprs.get(1).getClass().getSimpleName(),  
            @Override  
        );
            ),  
        );
        for (ScalarFunction func : functions) {
        List<RexNode> outerExprs = ((LogicalProject) stripped).getProjects();
     * fall back to inferring the operand type (DOUBLE here) so downstream backend capability
        assertTrue("Inner Project must contain the hoisted RexOver, exprs=" + innerExprs, foundRexOver);
        RelNode stripped = annotated.stripAnnotations(annotated.getInputs());
            rexBuilder.makeInputRef(typeFactory.createSqlType(SqlTypeName.VARCHAR), 0),  
import org.apache.calcite.sql.SqlFunctionCategory;
        return Map.of("name", Map.of("type", "keyword"), "value", Map.of("type", "integer"));  
            @Override
            "test_index",
     * via the backend's {@code ScalarFunctionAdapter}.
            @Override
            @Override
        assertTrue(result.getViableBackends().contains(MockDataFusionBackend.NAME));
import org.apache.calcite.rel.logical.LogicalProject;
                return scalarCaps(Set.of(MockDataFusionBackend.PARQUET_DATA_FORMAT), EnumSet.allOf(ScalarFunction.class));
        "highlight",
        assertTrue(result.getViableBackends().contains(MockDataFusionBackend.NAME));  
        RelNode result = runProjectOnAgg(1);
    private RelNode runProjectOnAgg(int shardCount) {  
    public void testDelegationFailsWhenAcceptorRejectsDelegationType() {
            protected Set<DelegationType> supportedDelegations() {
import org.opensearch.analytics.planner.rel.AnnotatedProjectExpression;
        RexNode painlessInside = ((RexCall) innerCall).getOperands().get(0);
            assertNoAnnotationInTree(expr);  
        for (RexNode expr : result.getProjects()) {  
     * at every level.
        logger.info("Plan:\n{}", RelOptUtil.toString(result));  
        // OpenSearchProjectRule.BASELINE_SCALAR_OPS).  
        AnnotatedProjectExpression outerAnnotation = (AnnotatedProjectExpression) result.getProjects().get(0);
            new String[] { "name", "value" },  
            List.of(dfWithDelegation, luceneWithPainlessNoAccept)
            "parquet",
        );
        RelOptTable table = mockTable(
        assertTrue(result.getViableBackends().contains(MockDataFusionBackend.NAME));
        // FLOOR(CEIL(value)) — a non-baseline scalar call with another non-baseline
        );  
        }
            "Expected planner to surface window-function capability gap, got: " + exception.getMessage(),
            Set.of()  
     * When no viable backend declares a {@link org.opensearch.analytics.spi.WindowCapability}
        // CEIL(value) — capability-declared scalar. CAST was used previously but is
        Set<ProjectCapability> caps = new HashSet<>();
                return opaqueCaps(Set.of(MockLuceneBackend.LUCENE_DATA_FORMAT), "suggest");
        // Lucene supports painless but doesn't accept PROJECT delegation  
            RexWindowBounds.UNBOUNDED_PRECEDING,
        RelNode innerInput = stripped.getInputs().get(0);  
    }  
        OpenSearchProject result = runProject(  
        // scalar call as an operand. The project rule recurses into operands
        // resolution; this test's intent is to exercise the capability-match happy path.  
    public void testRowNumberOverPartitionByOrderByMarksAsWindow() {  
    private static final SqlFunction HIGHLIGHT = new SqlFunction(  
        // the test still intends to exercise scalar-backend annotation.
    private OpenSearchProject runProject(String format, List<AnalyticsSearchBackendPlugin> backends, RexNode... exprs) {  
    public void testUnsupportedScalarFunctionErrors() {
    ) {  
import org.opensearch.analytics.planner.rel.OpenSearchTableScan;
        assertAnnotation(((OpenSearchProject) result).getProjects().get(0), MockDataFusionBackend.NAME);  
     * call into a child {@link LogicalProject} (see {@code OpenSearchProject#liftNestedRexOver})
        RexNode ceilExpr = rexBuilder.makeCall(
        );
 * The OpenSearch Contributors require contributions made to  
        OpenSearchProject result = runProject(ceilExpr);
        LogicalProject project = LogicalProject.create(agg, List.of(), List.of(ceilExpr), List.of("col_0"));
        RelNode agg = makeAggregate(
        Set<String> expectedViable,
            protected Set<ProjectCapability> projectCapabilities() {  
     * strip-annotations / isthmus's {@code RexExpressionConverter#visitOver} can decode it  
        // Negative guard: the short-circuit must apply only to passthrough. If a RexCall is  
                return opaqueCaps(Set.of(MockLuceneBackend.LUCENE_DATA_FORMAT), "painless", "highlight");
import java.util.HashSet;
        RexFieldCollation order = new RexFieldCollation(
    // ---- Helpers ----  
        );  
            rexBuilder.makeInputRef(typeFactory.createSqlType(SqlTypeName.VARCHAR), 0),
        UnsupportedFunctionException exception = expectThrows(UnsupportedFunctionException.class, () -> runPlanner(project, context));  
            @Override
            }
    }
        assertTrue("Expected OpenSearchProject", result instanceof OpenSearchProject);
        // CEIL(v_int) — capability-declared scalar. CAST was used previously but is baseline
import java.util.Set;
        RexNode painlessExpr = rexBuilder.makeCall(PAINLESS, rexBuilder.makeInputRef(typeFactory.createSqlType(SqlTypeName.VARCHAR), 0));  
import com.google.common.collect.ImmutableList;
            assertFalse("Passthrough expressions must not be annotated", expr instanceof AnnotatedProjectExpression);
            List.of("name", "rn")
        );
            result,
        UnsupportedFunctionException exception = expectThrows(UnsupportedFunctionException.class, () -> runPlanner(project, context));
            public String name() {
        );
            true,  
        assertAnnotation(result.getProjects().get(0), MockDataFusionBackend.NAME);  
        // Reference the INTEGER column (index 1) from the stub scan's (VARCHAR, INTEGER) schema.  
    }
        );  
        for (Set<ProjectCapability> set : sets)
        // RexExpressionConverter#visitOver downstream, which doesn't recognize the wrapper.  
            assertFalse("Field ref should not be annotated", expr instanceof AnnotatedProjectExpression);  
        LogicalProject project = LogicalProject.create(stubScan(table), List.of(), List.of(suggestExpr), List.of("sg"));  
            SqlFunctionCategory.USER_DEFINED_FUNCTION
                );  
        // A backend that declares NO ProjectCapability should still execute a passthrough
        logger.info("Plan ({} shard(s)):\n{}", shardCount, RelOptUtil.toString(result));
    public void testStripAnnotationsRecursivelyUnwrapsNestedExpressions() {  
    }
        return rexBuilder.makeOver(
    }  
        );
        RelNode result = unwrapExchange(runPlanner(project, context));
        ReturnTypes.VARCHAR_2000,  
        assertPipelineViableBackends(
        }
 * Tests for project rule: scalar function validation, opaque operation
        // Lucene supports painless but no delegation configured  
        }
            }
import org.apache.calcite.sql.SqlFunction;
            scalarExpr  
        assertTrue("Inner plan must be a LogicalProject carrying the hoisted RexOver", innerInput instanceof LogicalProject);
        RexNode fieldRef = rexBuilder.makeInputRef(typeFactory.createSqlType(SqlTypeName.VARCHAR), 0);  
        LogicalProject project = LogicalProject.create(
    }
        assertAnnotation(result.getProjects().get(0), MockDataFusionBackend.NAME);
        OperandTypes.ANY,
                    opaqueCaps(Set.of(MockDataFusionBackend.PARQUET_DATA_FORMAT), "painless")
        // structure while still going through capability resolution.
                return scalarCaps(Set.of(MockDataFusionBackend.PARQUET_DATA_FORMAT), EnumSet.allOf(ScalarFunction.class));  
            protected Set<ProjectCapability> projectCapabilities() {  
            @Override
            RexWindowExclusion.EXCLUDE_NO_OTHER,
        );
    private List<AnalyticsSearchBackendPlugin> delegationBackends(String... opaqueOps) {
                OpenSearchProject.class,
        // capability lookup succeeds.
    public void testPainlessErrorsWithoutDelegation() {
            @Override  
            SqlStdOperatorTable.CEIL,  
        Set<ProjectCapability> result = new HashSet<>();  
            assertNoAnnotationInTree(expr);  
        RexNode topLevel = annotated.getProjects().get(0);  
            SqlFunctionCategory.USER_DEFINED_FUNCTION
    public void testProjectOnAggregateScanMultiShard() {
    }
import org.apache.calcite.rex.RexCall;  
        // still throw — otherwise a later refactor could silently loosen the gate too much.
    }  
        MockDataFusionBackend dfWithDelegation = new MockDataFusionBackend() {
        // Sanity: confirm the rule produced the nested-wrapper shape this test exercises.
            protected Set<ProjectCapability> projectCapabilities() {  
        RexNode outerExpr = rexBuilder.makeCall(SqlStdOperatorTable.FLOOR, ceilExpr);  
        RexNode innerCall = outerAnnotation.getOriginal();
            delegationBackends("painless"),  
        };  
}  
                OpenSearchAggregate.class,
        MockLuceneBackend luceneWithPainless = new MockLuceneBackend() {
        RexNode painlessExpr = rexBuilder.makeCall(PAINLESS, rexBuilder.makeInputRef(typeFactory.createSqlType(SqlTypeName.VARCHAR), 0));  
        );  
            List.of(partition),  
                assertNoAnnotationInTree(operand);
        // because they bypass capability enforcement and would not produce an  
                return scalarCaps(Set.of(MockDataFusionBackend.PARQUET_DATA_FORMAT), EnumSet.allOf(ScalarFunction.class));
        UnsupportedFunctionException exception = expectThrows(UnsupportedFunctionException.class, () -> runPlanner(project, context));  
            protected Set<ProjectCapability> projectCapabilities() {
        return runProject("parquet", List.of(dfWithScalarFunctions(), LUCENE), Set.of(MockDataFusionBackend.NAME), exprs);  
    }
    public void testProjectOnAggregateScanSingleShard() {
        };  
        // (annotateExpr), so both FLOOR and the inner CEIL get wrapped in  
            new String[] { "name", "value" },  
            SqlKind.OTHER_FUNCTION,  
        // AnnotatedProjectExpression. stripAnnotations must remove every wrapper at every
            protected Set<ProjectCapability> projectCapabilities() {  
            SqlStdOperatorTable.CEIL,
                break;
import org.apache.calcite.rex.RexWindowExclusion;  
        );  
    /**  
    }
        PlannerContext context = buildContext("parquet", nameValueFields(), List.of(dfWithScalarFunctions(), LUCENE));
        //  
    }
        );
        // (see OpenSearchProjectRule.BASELINE_SCALAR_OPS) and bypasses capability routing;  
            node instanceof AnnotatedProjectExpression
            Set.of(MockDataFusionBackend.NAME)
     * Project(Filter(Scan)) — verifies annotation propagation through filter→project  
                return Set.of(DelegationType.PROJECT);
        assertFalse(result.getViableBackends().contains(MockLuceneBackend.NAME));
            new String[] { "name", "value" },  
        MockLuceneBackend luceneAccepting = new MockLuceneBackend() {
        }  
        OpenSearchProject result = runProject(
    }
            rexBuilder.makeCall(HIGHLIGHT, rexBuilder.makeInputRef(typeFactory.createSqlType(SqlTypeName.VARCHAR), 0))  
        RexNode... exprs
            ImmutableList.of(order),
            @Override
        assertTrue(  
        assertTrue(exception.getMessage().contains("is not currently supported"));
    }
    private OpenSearchProject runProject(
            true,
 * handling, and painless script delegation.
        );
    }  
            @Override  
            rexBuilder.makeInputRef(typeFactory.createSqlType(SqlTypeName.INTEGER), 1)  
        assertTrue(result.getViableBackends().contains(MockDataFusionBackend.NAME));  
        OpenSearchProject result = runProject(outerExpr);
        SqlKind.OTHER_FUNCTION,
            "parquet",
                OpenSearchExchangeReducer.class,  
    /**  
            rexBuilder.makeCall(PAINLESS, rexBuilder.makeInputRef(typeFactory.createSqlType(SqlTypeName.VARCHAR), 0))
        LogicalProject project = LogicalProject.create(stubScan(table), List.of(), List.of(painlessExpr), List.of("scripted_field"));  
        assertAnnotation(result.getProjects().get(0), MockLuceneBackend.NAME);
            }
 */  
            "Third project expression must remain a RexOver, was " + result.getProjects().get(2).getClass().getSimpleName(),
    }
    private RexNode makeRowNumberOver(int partitionField, int orderField) {
            expr instanceof AnnotatedProjectExpression  
 *
        // depth before the plan reaches the backend FragmentConvertor — Substrait isthmus
                return Set.of(DelegationType.PROJECT);
            }  
    private static void assertNoAnnotationInTree(RexNode node) {
    }
            protected Set<ProjectCapability> projectCapabilities() {  
    }  
        // baseline and bypasses capability routing; this test wants to exercise the
        // project-over-filter annotation path.  
    public void testExpressionProjectionStillRequiresCapabilityWithoutDeclaration() {
    /** DF (with PROJECT delegation) + Lucene (accepting, with given opaque ops). */
     * dispatch proceeds normally. The actual operator rewrite to {@code GREATEST} happens later  
        SqlKind.OTHER_FUNCTION,
        return List.of(df, lucene);
            }
                foundRexOver = true;  
                return Set.of();
        };  
        }
            List.of(OpenSearchProject.class, OpenSearchAggregate.class, OpenSearchTableScan.class),
            protected Set<org.opensearch.analytics.spi.WindowCapability> windowCapabilities() {  
        return caps;
        RexNode value = rexBuilder.makeInputRef(typeFactory.createSqlType(SqlTypeName.INTEGER), 1);  
        return (OpenSearchProject) result;  
        UnsupportedFunctionException exception = expectThrows(UnsupportedFunctionException.class, () -> runPlanner(project, context));
    private static Set<ProjectCapability> scalarCaps(Set<String> formats, Set<ScalarFunction> functions) {  
        assertPipelineViableBackends(  
            protected Set<DelegationType> acceptedDelegations() {
            @Override  
        // baseline (see OpenSearchProjectRule.BASELINE_SCALAR_OPS) and bypasses capability
            @Override
    /**
            List.of(OpenSearchProject.class, OpenSearchFilter.class, OpenSearchTableScan.class),  
        "painless",
    public void testMixedBackendsInProjection() {  
        RelOptTable table = mockTable("test_index", new String[] { "name" }, new SqlTypeName[] { SqlTypeName.VARCHAR });
        LogicalProject project = LogicalProject.create(stubScan(table), List.of(), List.of(painlessExpr), List.of("scripted"));
            caps.add(new ProjectCapability.Opaque(name, formats));
            @Override
            rexBuilder.makeInputRef(typeFactory.createSqlType(SqlTypeName.VARCHAR), 0),
            opBinding -> typeFactory.createSqlType(SqlTypeName.ANY),
     * PPL emits {@code SCALAR_MAX(a, b, c)} as a UDF whose return type is {@link SqlTypeName#ANY}
            List.of(rexBuilder.makeInputRef(typeFactory.createSqlType(SqlTypeName.VARCHAR), 0), rowNumber),
        OperandTypes.ANY,
     * and string types. The project rule must not reject such calls outright; instead it should
        return runProject(format, backends, Set.of(MockDataFusionBackend.NAME), exprs);
     * time rather than failing later in substrait emission.
        );
            List.of(dfWithPainless, LUCENE),
            sumCall()
        List<RexNode> innerExprs = ((LogicalProject) innerInput).getProjects();
            RexWindowBounds.CURRENT_ROW,  
            new SqlTypeName[] { SqlTypeName.VARCHAR, SqlTypeName.INTEGER }
            null,
            }
        SqlFunction suggest = new SqlFunction(
        // CEIL over SUM result (field 1) — capability-declared scalar that flows through
        assertTrue(((AnnotatedProjectExpression) expr).getViableBackends().contains(expectedBackend));
        RelNode stripped = annotated.stripAnnotations(annotated.getInputs());  
    /**
        );  
                return combine(  
            }
import org.apache.calcite.plan.RelOptUtil;  
        assertAnnotation(result.getProjects().get(0), MockDataFusionBackend.NAME);  
            "parquet",
        );
        RelOptTable table = mockTable(
        return result;  
        assertTrue(exception.getMessage().contains("is not currently supported"));
        MockDataFusionBackend dfWithDelegation = new MockDataFusionBackend() {  
        assertTrue(innerCall instanceof RexCall);  
            rexBuilder.makeInputRef(typeFactory.createSqlType(SqlTypeName.INTEGER), 1)
        MockDataFusionBackend df = new MockDataFusionBackend() {  
        assertAnnotation(result.getProjects().get(0), MockDataFusionBackend.NAME);
                return opaqueCaps(Set.of(MockLuceneBackend.LUCENE_DATA_FORMAT), opaqueOps);
            "parquet",
            "parquet",
            for (RexNode operand : call.getOperands()) {
            protected Set<ProjectCapability> projectCapabilities() {
        for (RexNode expr : outerExprs) {
        RexNode floorCall = rexBuilder.makeCall(SqlStdOperatorTable.FLOOR, ceilCall);
import org.apache.calcite.rex.RexOver;
     * Builds a {@code ROW_NUMBER() OVER (PARTITION BY $partitionField ORDER BY $orderField)}
            partitionField
            "SCALAR_MAX",
            protected Set<ProjectCapability> projectCapabilities() {
        assertFalse("Field ref should not be annotated", result.getProjects().get(0) instanceof AnnotatedProjectExpression);
import org.apache.calcite.sql.type.ReturnTypes;  
     * outer project must carry no annotation wrappers, and the inner project must preserve the
        );
            stubScan(
            stubScan(table),
            rexBuilder.makeInputRef(typeFactory.createSqlType(SqlTypeName.INTEGER), orderField),
     * it into a substrait {@code WindowFunctionInvocation}.  
            new SqlTypeName[] { SqlTypeName.VARCHAR, SqlTypeName.INTEGER }
    // ---- Composed pipeline shapes ----  
        RelNode result = unwrapExchange(runPlanner(project, context));
                return "mock-third";
            Set.of(MockDataFusionBackend.NAME)
            }  
        assertAnnotation(result.getProjects().get(0), MockLuceneBackend.NAME);  
            }  
        for (String name : names)
            protected Set<DelegationType> supportedDelegations() {
        OpenSearchProject annotated = runProject(rexBuilder.makeInputRef(typeFactory.createSqlType(SqlTypeName.VARCHAR), 0), rowNumber);
        for (int i = 0; i < exprs.length; i++)
    // ---- Mixed backends in one projection ----
        assertAnnotation(((OpenSearchProject) result).getProjects().get(0), MockDataFusionBackend.NAME);
            painlessExpr,
        };
        assertTrue(result.getViableBackends().contains(MockDataFusionBackend.NAME));
        RexNode ceilExpr = rexBuilder.makeCall(  
        assertTrue(result.getViableBackends().contains(MockDataFusionBackend.NAME));  
        // CEIL(int_col) — capability-declared scalar. CAST was used previously but is
        null,
        null,
                mockTable("test_index", new String[] { "name", "value" }, new SqlTypeName[] { SqlTypeName.VARCHAR, SqlTypeName.INTEGER })  
import org.opensearch.analytics.planner.rel.OpenSearchExchangeReducer;
import org.apache.calcite.sql.SqlKind;  
            fieldNames.add("col_" + i);
    private void assertAnnotation(RexNode expr, String expectedBackend) {  
        );
    }
                OpenSearchAggregate.class,
            ),
        );  
            outerOriginal.getOperands().get(0) instanceof AnnotatedProjectExpression
            @Override  
            rexBuilder.makeInputRef(typeFactory.createSqlType(SqlTypeName.INTEGER), 1)  
            }
            }  
    public void testOpaqueOperationSupportedNatively() {
            List.of(),  
                return Set.of(DelegationType.PROJECT);
        );  
        RexNode suggestExpr = rexBuilder.makeCall(suggest, rexBuilder.makeInputRef(typeFactory.createSqlType(SqlTypeName.VARCHAR), 0));
        LogicalProject project = LogicalProject.create(stubScan(table), List.of(), List.of(exprs), fieldNames);  
            }
        RelNode result = unwrapExchange(runPlanner(project, context));
        }
        );
    }  
        RelOptTable table = mockTable(
        };
        LogicalProject project = LogicalProject.create(filter, List.of(), List.of(ceilExpr), fieldNames);  
            OperandTypes.VARIADIC,  
            "Expression tree must not contain AnnotatedProjectExpression after strip: " + node,  
                OpenSearchTableScan.class
    private static Set<ProjectCapability> combine(Set<ProjectCapability>... sets) {
 * compatible open source license.
        assertAnnotation(((OpenSearchProject) result).getProjects().get(0), MockDataFusionBackend.NAME);  
import org.apache.calcite.rex.RexWindowBounds;
/**  
    }
        RexNode ceilExpr = rexBuilder.makeCall(
import java.util.ArrayList;
        RexCall outerOriginal = (RexCall) ((AnnotatedProjectExpression) topLevel).getOriginal();
import org.apache.calcite.rel.RelNode;
            }
        assertTrue(exception.getMessage().contains("is not currently supported"));  
            rexBuilder.makeCall(PAINLESS, rexBuilder.makeInputRef(typeFactory.createSqlType(SqlTypeName.VARCHAR), 0))
        assertFalse("Field ref must not be annotated", result.getProjects().get(1) instanceof AnnotatedProjectExpression);
        RexNode painlessExpr = rexBuilder.makeCall(PAINLESS, rexBuilder.makeInputRef(typeFactory.createSqlType(SqlTypeName.VARCHAR), 0));
            }  
        );  
        RelNode filter = makeFilter(
            SqlStdOperatorTable.CEIL,
        Set<ProjectCapability> caps = new HashSet<>();  
    // ---- Delegation edge cases ----
            SqlStdOperatorTable.CEIL,  
    /**
    public void testHighlightDelegation() {
        };
    public void testSimpleFieldProjection() {
            outerExprs.get(1) instanceof RexInputRef
        );  
            typeFactory.createSqlType(partitionField == 0 ? SqlTypeName.VARCHAR : SqlTypeName.INTEGER),
    // ---- Scalar functions ----
        );
            ReturnTypes.VARCHAR_2000,
            SqlStdOperatorTable.ROW_NUMBER,
        assertTrue(
            protected Set<DelegationType> acceptedDelegations() {  
        );
        };
        if (node instanceof RexCall call) {  
        // was used previously but both PLUS and CAST are baseline scalars (see
        };  
        };
    }
        MockLuceneBackend luceneAccepting = new MockLuceneBackend() {  
     */
            "parquet",
            "suggest",  
        };
            typeFactory.createSqlType(SqlTypeName.BIGINT),  
    }
    private static Map<String, Map<String, Object>> nameValueFields() {
            Map.of("name", Map.of("type", "keyword")),  
            @Override
        List<AnalyticsSearchBackendPlugin> backends,  
        // annotation happens at both levels. CAST / PLUS / POWER are baseline scalars (see
    public void testScalarWrappingOpaqueOp() {  
    public void testMixedFieldAndPainlessWithDelegation() {
    }
    public void testScalarFunctionWithAnyReturnTypeUsesOperandFallback() {  
        OpenSearchProject result = runProject(  
            rexBuilder.makeInputRef(typeFactory.createSqlType(SqlTypeName.INTEGER), 1)  
        MockLuceneBackend luceneWithPainlessNoAccept = new MockLuceneBackend() {
                return opaqueCaps(Set.of(MockLuceneBackend.LUCENE_DATA_FORMAT), "painless");  
            if (innerExpr instanceof RexOver) {
        OpenSearchProject result = runProject(
        String format,
            makeEquals(1, SqlTypeName.INTEGER, 100)
    }  
        );
import org.opensearch.analytics.planner.rel.OpenSearchProject;  
        assertTrue(result.getViableBackends().contains(MockDataFusionBackend.NAME));
        PlannerContext context = buildContext(
    // ---- Window functions ----
            }
            }
        };  
        UnsupportedFunctionException exception = expectThrows(UnsupportedFunctionException.class, () -> runPlanner(project, context));
                return Set.of(DelegationType.PROJECT);  
                    scalarCaps(Set.of(MockDataFusionBackend.PARQUET_DATA_FORMAT), EnumSet.allOf(ScalarFunction.class)),
        return new MockDataFusionBackend() {
        RexNode ceilCall = rexBuilder.makeCall(SqlStdOperatorTable.CEIL, value);
        );
        PlannerContext context = buildContext("parquet", nameValueFields());
        MockDataFusionBackend dfWithScalarsAndDelegation = new MockDataFusionBackend() {
        RexNode ceilExpr = rexBuilder.makeCall(
                return opaqueCaps(Set.of(MockLuceneBackend.LUCENE_DATA_FORMAT), "painless");  
        assertPipelineViableBackends(result, List.of(OpenSearchProject.class, OpenSearchTableScan.class), expectedViable);
        RelOptTable table = mockTable("test_index", new String[] { "name" }, new SqlTypeName[] { SqlTypeName.VARCHAR });
     */
            }
        }
        List<String> fieldNames = List.of("col_0");
            Map.of("name", Map.of("type", "keyword")),
        );  
        MockLuceneBackend luceneAccepting = new MockLuceneBackend() {  
            protected Set<DelegationType> acceptedDelegations() {
        assertTrue(result.getViableBackends().contains(MockDataFusionBackend.NAME));
     * org.opensearch.analytics.spi.BackendCapabilityProvider#windowCapabilities()} on the rule's
import org.apache.calcite.rex.RexNode;  
     * The project rule narrows viable backends via {@link  
            @Override
            delegationBackends("painless", "highlight"),
            List.of(dfWithDelegation, luceneAccepting, thirdBackend)
    public void testRowNumberWithoutWindowCapabilityErrors() {  
        SqlFunctionCategory.USER_DEFINED_FUNCTION  
            stubScan(
import org.opensearch.analytics.spi.ProjectCapability;
        assertTrue(result.getViableBackends().contains(MockDataFusionBackend.NAME));  
        PlannerContext context = buildContext("parquet", nameValueFields(), List.of(dfNoWindow, LUCENE));
            List.of(new MockDataFusionBackend(), LUCENE),
        // projection (only field refs). Verifies the short-circuit in OpenSearchProjectRule.onMatch  
        // this test uses FLOOR+CEIL to preserve the nested-call-with-nested-annotation
        // trigger capability enforcement.
    private static final SqlFunction PAINLESS = new SqlFunction(  
            List.of(dfWithScalarsAndDelegation, luceneAccepting),  
        );
import java.util.EnumSet;  
        // The inner Project (hoisted from liftNestedRexOver) must hold the original RexOver
        );  
     * directly into a substrait {@code WindowFunctionInvocation}.
        MockLuceneBackend lucene = new MockLuceneBackend() {
        SqlFunction scalarMaxUdf = new SqlFunction(
        RexNode rowNumber = makeRowNumberOver(/*partitionField*/ 0, /*orderField*/ 1);  
package org.opensearch.analytics.planner;
 * this file be licensed under the Apache-2.0 license or a
        LogicalProject project = LogicalProject.create(stubScan(table), List.of(), List.of(ceilExpr), List.of("casted"));  
        MockDataFusionBackend dfWithPainless = new MockDataFusionBackend() {  
    }
        // OpenSearchProjectRule.BASELINE_SCALAR_OPS) and are deliberately not used here
     * {@code ROW_NUMBER() OVER (PARTITION BY ... ORDER BY ...)} inside a {@code LogicalProject}.
    private static Set<ProjectCapability> opaqueCaps(Set<String> formats, String... names) {
            protected Set<DelegationType> supportedDelegations() {
        UnsupportedFunctionException exception = expectThrows(UnsupportedFunctionException.class, () -> runPlanner(project, context));
    public void testNestedScalarFunctions() {
        assertFalse(
            List.of(  
                return Set.of(DelegationType.PROJECT);  
            Set.of(MockDataFusionBackend.NAME)  
            SqlStdOperatorTable.CEIL,
        // annotation. CAST was used previously but is baseline (see
        assertTrue(  
        assertAnnotation(result.getProjects().get(1), MockLuceneBackend.NAME);
    public void testPainlessDelegationFromDataFusionToLucene() {  
                return Set.of(DelegationType.PROJECT);
        return caps;  
        assertAnnotation(result.getProjects().get(1), MockLuceneBackend.NAME);
        return result;  
import org.opensearch.analytics.spi.AnalyticsSearchBackendPlugin;
    private MockDataFusionBackend dfWithScalarFunctions() {
        // has no converter for ANNOTATED_PROJECT_EXPR and would throw "Unable to convert  
            }
    public void testStripAnnotationsPreservesRexOver() {
        // carved out of capability enforcement (see OpenSearchProjectRule.BASELINE_SCALAR_OPS).
     * — a consequence of the underlying {@code ScalarMaxFunction} being polymorphic across numeric  
            rexBuilder.makeInputRef(agg.getRowType().getFieldList().get(1).getType(), 1)  
            result.addAll(set);
