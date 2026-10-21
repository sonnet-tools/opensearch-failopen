        );
        Expression.PrecisionTimestampLiteral pts = (Expression.PrecisionTimestampLiteral) getFilterCondition(rewritten);
            .names(List.of("test_table"))
    public void testStrLiteralUnchanged() {
        Filter filter = (Filter) plan.getRoots().get(0).getInput();
import io.substrait.type.TypeCreator;
    }
        // Tests multiple VarChar literals in a single Project (e.g., Chart/Trendline with multiple string options)
            SimpleExtension.FunctionAnchor.of(DefaultExtensionCatalog.FUNCTIONS_COMPARISON, "gt:any_any")
import io.substrait.relation.Filter;
import io.substrait.extension.SimpleExtension;
}
    public void testTimestampPrecision9PassThrough() {
        Expression literal = ImmutableExpression.PrecisionTimestampLiteral.builder().value(epochNanos).precision(9).nullable(false).build();
        Expression condition = getFilterCondition(rewritten);
        Plan rewritten = SubstraitPlanPojoRewriter.rewrite(plan);
        Expression tsLiteral = ImmutableExpression.PrecisionTimestampLiteral.builder()
        long epochNanos = 1704067200000000000L;
            .names(List.of("test_table"))
        assertEquals(epochMicros, arg1.value());
        Plan plan = buildFilterPlan(varcharLiteral);
        assertEquals(9, pts.precision());
    private static Plan buildFilterPlan(Expression condition) {
    private static Plan buildPlan(io.substrait.relation.Rel rel) {
        assertEquals("Total", strLit.value());
        // Rewriter walks into scalar-function arguments but no longer touches timestamp literals.
        Expression.PrecisionTimestampLiteral pts = (Expression.PrecisionTimestampLiteral) getFilterCondition(rewritten);
package org.opensearch.be.datafusion;
        Project rewrittenProject = (Project) rewritten.getRoots().get(0).getInput();
        long epochMicros = 1704067200000000L;
    }
        assertTrue(condition instanceof Expression.StrLiteral);
        assertTrue(str3.nullable());
    public void testTimestampPrecision3Unchanged() {
            .initialSchema(NamedStruct.of(List.of("col0"), R.struct(R.I64)))
            .build();
            .nullable(false)
    public void testNullableVarCharLiteralPreservesNullability() {
        Project project = Project.builder().input(scan).addExpressions(varchar1, varchar2, varchar3).build();
        assertEquals("already_string", strLit.value());
import io.substrait.expression.Expression;
    public void testTimestampPrecision6PassThrough() {
        Expression.StrLiteral strLit = (Expression.StrLiteral) expr;
        assertTrue("Nullability should be preserved", strLit.nullable());
        assertEquals(3, pts.precision());
        Expression literal = ImmutableExpression.PrecisionTimestampLiteral.builder()
            .value(epochMicros)
public class SubstraitPlanPojoRewriterTests extends OpenSearchTestCase {
        );
        assertFalse(str2.nullable());
        assertTrue("Expected StrLiteral, got " + expr.getClass(), expr instanceof Expression.StrLiteral);
    }
        Plan plan = buildPlan(project);
        Plan rewritten = SubstraitPlanPojoRewriter.rewrite(plan);
            .nullable(false)
    public void testVarCharLiteralConvertedToStrLiteralInFilter() {
            .declaration(gtFunc)
        Expression varcharLiteral = ImmutableExpression.VarCharLiteral.builder().value("nullable_value").length(14).nullable(true).build();
            .nullable(false)
        Expression.PrecisionTimestampLiteral pts = (Expression.PrecisionTimestampLiteral) getFilterCondition(rewritten);
        assertFalse(strLit.nullable());
        Expression.StrLiteral strLit = (Expression.StrLiteral) condition;
        Plan plan = buildFilterPlan(strLiteral);
    public void testVarCharLiteralConvertedToStrLiteralInProject() {
 * The OpenSearch Contributors require contributions made to
        Expression varcharLiteral = ImmutableExpression.VarCharLiteral.builder().value("Sum").length(3).nullable(false).build();
        // Simulates AddTotals label='Sum' scenario where VarCharLiteral appears in Project expressions
            .addArguments(fieldRef, tsLiteral)
 *
        return filter.getCondition();
        Expression.StrLiteral strLit = (Expression.StrLiteral) arg1;
        Expression condition = getFilterCondition(rewritten);
        assertEquals("nullable_value", strLit.value());
        NamedScan scan = NamedScan.builder()
    private static Expression getFilterCondition(Plan plan) {
        assertEquals(3, expressions.size());
        FieldReference fieldRef = FieldReference.newRootStructReference(0, R.precisionTimestamp(3));
import io.substrait.expression.ImmutableExpression;
    }
        Expression gtCall = Expression.ScalarFunctionInvocation.builder()
        Plan plan = buildPlan(scan);
            .build();
        Expression.ScalarFunctionInvocation rewrittenGt = (Expression.ScalarFunctionInvocation) getFilterCondition(rewritten);
            .names(List.of("test_table"))
        Plan rewritten = SubstraitPlanPojoRewriter.rewrite(buildFilterPlan(literal));
        assertTrue(condition instanceof Expression.ScalarFunctionInvocation);
        SimpleExtension.ExtensionCollection extensions = DefaultExtensionCatalog.DEFAULT_COLLECTION;
            .precision(6)
        Filter filter = Filter.builder().input(scan).condition(condition).build();
        Plan plan = buildFilterPlan(eqCall);
        Expression.StrLiteral str2 = (Expression.StrLiteral) expressions.get(1);
        Expression.StrLiteral strLit = (Expression.StrLiteral) condition;
            .build();
            .build();
        Plan rewritten = SubstraitPlanPojoRewriter.rewrite(buildFilterPlan(gtCall));
        assertEquals(epochMillis, pts.value());
        Plan rewritten = SubstraitPlanPojoRewriter.rewrite(plan);
    }
        assertFalse(strLit.nullable());
        // Tests VarCharLiteral within a function call (e.g., CASE expressions with string constants)
import io.substrait.plan.Plan;
        assertEquals(List.of("parquet_dates"), rewrittenScan.getNames());
            SimpleExtension.FunctionAnchor.of(DefaultExtensionCatalog.FUNCTIONS_COMPARISON, "equal:any_any")
        Plan rewritten = SubstraitPlanPojoRewriter.rewrite(plan);
            .declaration(eqFunc)
        Plan plan = buildPlan(project);
    // --- helpers ---
import io.substrait.relation.Project;
        Expression.StrLiteral strLit = (Expression.StrLiteral) condition;
        Expression varchar3 = ImmutableExpression.VarCharLiteral.builder().value("option3").length(7).nullable(true).build();
        NamedScan rewrittenScan = (NamedScan) rewritten.getRoots().get(0).getInput();
        Expression arg1 = (Expression) rewrittenEq.arguments().get(1);
        long epochMicros = 1704067200000000L;
        Plan.Root root = Plan.Root.builder().input(rel).addNames("col0").build();
        Expression strLiteral = ImmutableExpression.StrLiteral.builder().value("already_string").nullable(false).build();
        assertEquals(epochMicros, pts.value());
        assertFalse(str1.nullable());
    public void testBareNameUnchanged() {
        Expression.ScalarFunctionInvocation rewrittenEq = (Expression.ScalarFunctionInvocation) condition;
        SimpleExtension.ScalarFunctionVariant gtFunc = extensions.getScalarFunction(
        SimpleExtension.ExtensionCollection extensions = DefaultExtensionCatalog.DEFAULT_COLLECTION;
        Project rewrittenProject = (Project) rewritten.getRoots().get(0).getInput();
    private static final TypeCreator R = TypeCreator.of(false);
            .value(epochMicros)
        long epochMillis = 1704067200000L;
        Plan rewritten = SubstraitPlanPojoRewriter.rewrite(plan);
    }
        assertEquals("option1", str1.value());
import io.substrait.extension.DefaultExtensionCatalog;
 */
            .value(epochMillis)
import io.substrait.expression.FieldReference;
            .addArguments(fieldRef, varcharLiteral)
    }
        Expression expr = rewrittenProject.getExpressions().get(0);
        assertEquals(epochNanos, pts.value());
import io.substrait.relation.NamedScan;
 * compatible open source license.
        Expression literal = ImmutableExpression.PrecisionTimestampLiteral.builder()
        Expression varcharLiteral = ImmutableExpression.VarCharLiteral.builder().value("label").length(5).nullable(false).build();
    /** precision-6 literal passes through unchanged — DataFusion handles coercion against ms columns. */
    }
    // --- VarCharLiteral → StrLiteral tests ---
    }
        return buildPlan(filter);
        NamedScan scan = NamedScan.builder()
        Expression varchar1 = ImmutableExpression.VarCharLiteral.builder().value("option1").length(7).nullable(false).build();
    }
        assertEquals("label", strLit.value());
    }
import org.opensearch.test.OpenSearchTestCase;
            .precision(6)
        FieldReference fieldRef = FieldReference.newRootStructReference(0, R.STRING);
    public void testVarCharLiteralInsideScalarFunction() {
    public void testMultipleVarCharLiteralsInProject() {
import java.util.List;
        Project project = Project.builder().input(scan).addExpressions(varcharLiteral).build();
            .build();
    }
        assertEquals("option2", str2.value());
        assertEquals("option3", str3.value());
        return Plan.builder().addRoots(root).build();
        NamedScan scan = NamedScan.builder()
        NamedScan scan = NamedScan.builder()
import io.substrait.type.NamedStruct;
    public void testTimestampInsideScalarFunction() {
            .build();
        Expression eqCall = Expression.ScalarFunctionInvocation.builder()
        Expression.PrecisionTimestampLiteral arg1 = (Expression.PrecisionTimestampLiteral) rewrittenGt.arguments().get(1);
        // Ensures existing StrLiterals are not modified
        assertEquals(6, arg1.precision());
/*
 * SPDX-License-Identifier: Apache-2.0
        assertTrue("Expected StrLiteral in function args, got " + arg1.getClass(), arg1 instanceof Expression.StrLiteral);
        Expression.StrLiteral str1 = (Expression.StrLiteral) expressions.get(0);
    }
        assertTrue("Expected StrLiteral, got " + condition.getClass(), condition instanceof Expression.StrLiteral);
        Plan plan = buildFilterPlan(varcharLiteral);
    }
            .build();
            .outputType(R.BOOLEAN)
            .names(List.of("parquet_dates"))
        assertEquals(6, pts.precision());
            .outputType(R.BOOLEAN)
        Plan rewritten = SubstraitPlanPojoRewriter.rewrite(plan);
        Expression condition = getFilterCondition(rewritten);
        assertFalse(strLit.nullable());
        Plan rewritten = SubstraitPlanPojoRewriter.rewrite(plan);
            .build();
        Expression varcharLiteral = ImmutableExpression.VarCharLiteral.builder().value("Total").length(5).nullable(false).build();
        List<Expression> expressions = rewrittenProject.getExpressions();
        assertEquals("Sum", strLit.value());
            .build();
        Expression varchar2 = ImmutableExpression.VarCharLiteral.builder().value("option2").length(7).nullable(false).build();
            .initialSchema(NamedStruct.of(List.of("col0"), R.struct(R.I64)))
            .initialSchema(NamedStruct.of(List.of("col0"), R.struct(R.I64)))
 * this file be licensed under the Apache-2.0 license or a
        Expression.StrLiteral str3 = (Expression.StrLiteral) expressions.get(2);
        Plan rewritten = SubstraitPlanPojoRewriter.rewrite(buildFilterPlan(literal));
        Plan rewritten = SubstraitPlanPojoRewriter.rewrite(buildFilterPlan(literal));
            .initialSchema(NamedStruct.of(List.of("col0"), R.struct(R.precisionTimestamp(3))))
            .precision(3)
        assertTrue(condition instanceof Expression.StrLiteral);
        Expression condition = getFilterCondition(rewritten);
        SimpleExtension.ScalarFunctionVariant eqFunc = extensions.getScalarFunction(
