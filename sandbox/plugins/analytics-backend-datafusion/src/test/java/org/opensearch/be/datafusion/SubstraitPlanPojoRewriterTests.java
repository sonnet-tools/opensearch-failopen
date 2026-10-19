        Plan plan = buildPlan(scan);
        Plan rewritten = SubstraitPlanPojoRewriter.rewrite(buildFilterPlan(literal));
            .names(List.of("test_table"))
        Expression condition = getFilterCondition(rewritten);  
        Expression varchar3 = ImmutableExpression.VarCharLiteral.builder().value("option3").length(7).nullable(true).build();  
    }
            .addArguments(fieldRef, tsLiteral)
        assertTrue(condition instanceof Expression.ScalarFunctionInvocation);
    // --- VarCharLiteral → StrLiteral tests ---
        assertFalse(strLit.nullable());
        Plan rewritten = SubstraitPlanPojoRewriter.rewrite(plan);
            .outputType(R.BOOLEAN)
import io.substrait.expression.FieldReference;  
        Project project = Project.builder().input(scan).addExpressions(varcharLiteral).build();
        Plan rewritten = SubstraitPlanPojoRewriter.rewrite(plan);
import io.substrait.expression.Expression;
    }
        );
        assertTrue("Expected StrLiteral in function args, got " + arg1.getClass(), arg1 instanceof Expression.StrLiteral);
        NamedScan scan = NamedScan.builder()
            .build();  
        List<Expression> expressions = rewrittenProject.getExpressions();
        Expression.StrLiteral str3 = (Expression.StrLiteral) expressions.get(2);
 */  
        Expression.ScalarFunctionInvocation rewrittenEq = (Expression.ScalarFunctionInvocation) condition;
        Expression.PrecisionTimestampLiteral pts = (Expression.PrecisionTimestampLiteral) getFilterCondition(rewritten);
        Plan plan = buildFilterPlan(strLiteral);
        Expression.PrecisionTimestampLiteral pts = (Expression.PrecisionTimestampLiteral) getFilterCondition(rewritten);  
    public void testTimestampInsideScalarFunction() {  
    public void testStrLiteralUnchanged() {
    public void testTimestampPrecision9PassThrough() {
        // Rewriter walks into scalar-function arguments but no longer touches timestamp literals.
        Expression.StrLiteral strLit = (Expression.StrLiteral) condition;
        Project rewrittenProject = (Project) rewritten.getRoots().get(0).getInput();
        return buildPlan(filter);
        Plan rewritten = SubstraitPlanPojoRewriter.rewrite(buildFilterPlan(gtCall));
            .initialSchema(NamedStruct.of(List.of("col0"), R.struct(R.I64)))  
            .initialSchema(NamedStruct.of(List.of("col0"), R.struct(R.precisionTimestamp(3))))
        Expression arg1 = (Expression) rewrittenEq.arguments().get(1);  
        Expression.StrLiteral str2 = (Expression.StrLiteral) expressions.get(1);
        Expression.ScalarFunctionInvocation rewrittenGt = (Expression.ScalarFunctionInvocation) getFilterCondition(rewritten);
        Filter filter = Filter.builder().input(scan).condition(condition).build();
        Plan plan = buildFilterPlan(varcharLiteral);
    public void testVarCharLiteralInsideScalarFunction() {
    private static Plan buildFilterPlan(Expression condition) {
        Expression.PrecisionTimestampLiteral pts = (Expression.PrecisionTimestampLiteral) getFilterCondition(rewritten);  
        Plan rewritten = SubstraitPlanPojoRewriter.rewrite(plan);
        NamedScan scan = NamedScan.builder()
    /** precision-6 literal passes through unchanged — DataFusion handles coercion against ms columns. */  
            .outputType(R.BOOLEAN)  
        Expression.StrLiteral strLit = (Expression.StrLiteral) condition;  
        Expression.StrLiteral strLit = (Expression.StrLiteral) arg1;
            .names(List.of("test_table"))  
        SimpleExtension.ScalarFunctionVariant eqFunc = extensions.getScalarFunction(
            .nullable(false)
        Expression condition = getFilterCondition(rewritten);
        Plan plan = buildFilterPlan(eqCall);  
    public void testTimestampPrecision6PassThrough() {
        Expression gtCall = Expression.ScalarFunctionInvocation.builder()
    }
        assertEquals("option2", str2.value());
    }
    public void testBareNameUnchanged() {
    }
        assertTrue(condition instanceof Expression.StrLiteral);  
 * this file be licensed under the Apache-2.0 license or a
        Expression varchar2 = ImmutableExpression.VarCharLiteral.builder().value("option2").length(7).nullable(false).build();
        assertEquals("Total", strLit.value());
        // Simulates AddTotals label='Sum' scenario where VarCharLiteral appears in Project expressions  
        assertFalse(strLit.nullable());  
    public void testTimestampPrecision3Unchanged() {
    public void testNullableVarCharLiteralPreservesNullability() {  
    public void testVarCharLiteralConvertedToStrLiteralInProject() {
    }
    }  
        assertEquals(9, pts.precision());
    }
        FieldReference fieldRef = FieldReference.newRootStructReference(0, R.STRING);
        // Ensures existing StrLiterals are not modified
        SimpleExtension.ExtensionCollection extensions = DefaultExtensionCatalog.DEFAULT_COLLECTION;  
            .precision(3)
        Expression.StrLiteral strLit = (Expression.StrLiteral) expr;
    }
            .build();
        assertTrue(condition instanceof Expression.StrLiteral);
        Expression condition = getFilterCondition(rewritten);  
            .build();
        long epochMillis = 1704067200000L;  
        Plan rewritten = SubstraitPlanPojoRewriter.rewrite(plan);
        assertEquals(epochNanos, pts.value());
        Plan plan = buildPlan(project);
        Expression.StrLiteral strLit = (Expression.StrLiteral) condition;
        return Plan.builder().addRoots(root).build();  
        SimpleExtension.ScalarFunctionVariant gtFunc = extensions.getScalarFunction(
        Plan plan = buildFilterPlan(varcharLiteral);  
        assertEquals("nullable_value", strLit.value());  
import org.opensearch.test.OpenSearchTestCase;
    public void testMultipleVarCharLiteralsInProject() {  
        Expression varcharLiteral = ImmutableExpression.VarCharLiteral.builder().value("nullable_value").length(14).nullable(true).build();
        assertFalse(strLit.nullable());  
    }  
        Expression varcharLiteral = ImmutableExpression.VarCharLiteral.builder().value("Total").length(5).nullable(false).build();  
            .nullable(false)
/*  
        Expression.PrecisionTimestampLiteral arg1 = (Expression.PrecisionTimestampLiteral) rewrittenGt.arguments().get(1);
    }  
        Plan rewritten = SubstraitPlanPojoRewriter.rewrite(buildFilterPlan(literal));
            .value(epochMicros)
    }
        Plan rewritten = SubstraitPlanPojoRewriter.rewrite(plan);  
package org.opensearch.be.datafusion;
            .build();
    public void testVarCharLiteralConvertedToStrLiteralInFilter() {
            .build();
        NamedScan rewrittenScan = (NamedScan) rewritten.getRoots().get(0).getInput();
            SimpleExtension.FunctionAnchor.of(DefaultExtensionCatalog.FUNCTIONS_COMPARISON, "gt:any_any")
        Expression tsLiteral = ImmutableExpression.PrecisionTimestampLiteral.builder()
            .names(List.of("test_table"))
        Expression literal = ImmutableExpression.PrecisionTimestampLiteral.builder()
        assertFalse(str1.nullable());
        Expression literal = ImmutableExpression.PrecisionTimestampLiteral.builder().value(epochNanos).precision(9).nullable(false).build();
import io.substrait.extension.DefaultExtensionCatalog;
    }  
    private static final TypeCreator R = TypeCreator.of(false);
import io.substrait.relation.Filter;
        NamedScan scan = NamedScan.builder()  
import io.substrait.relation.Project;
import io.substrait.relation.NamedScan;  
    }  
 * SPDX-License-Identifier: Apache-2.0
        SimpleExtension.ExtensionCollection extensions = DefaultExtensionCatalog.DEFAULT_COLLECTION;
        assertTrue("Expected StrLiteral, got " + condition.getClass(), condition instanceof Expression.StrLiteral);
import io.substrait.expression.ImmutableExpression;
        assertTrue("Nullability should be preserved", strLit.nullable());
        assertEquals("option1", str1.value());
        assertEquals("option3", str3.value());  
        assertEquals(6, arg1.precision());  
            .precision(6)  
        Plan rewritten = SubstraitPlanPojoRewriter.rewrite(plan);
        Expression varchar1 = ImmutableExpression.VarCharLiteral.builder().value("option1").length(7).nullable(false).build();
        assertEquals(List.of("parquet_dates"), rewrittenScan.getNames());
            .initialSchema(NamedStruct.of(List.of("col0"), R.struct(R.I64)))
            .addArguments(fieldRef, varcharLiteral)
        Plan plan = buildPlan(project);
        assertEquals("label", strLit.value());  
            .value(epochMicros)
        Project project = Project.builder().input(scan).addExpressions(varchar1, varchar2, varchar3).build();
        );  
            .build();
        assertEquals("Sum", strLit.value());
        NamedScan scan = NamedScan.builder()
        assertEquals(3, expressions.size());
            .names(List.of("parquet_dates"))  
        long epochNanos = 1704067200000000000L;  
        Expression expr = rewrittenProject.getExpressions().get(0);
 * compatible open source license.
            .build();  
    private static Expression getFilterCondition(Plan plan) {  
import io.substrait.type.TypeCreator;  
        assertTrue("Expected StrLiteral, got " + expr.getClass(), expr instanceof Expression.StrLiteral);  
        Project rewrittenProject = (Project) rewritten.getRoots().get(0).getInput();
        assertFalse(str2.nullable());  
 *
public class SubstraitPlanPojoRewriterTests extends OpenSearchTestCase {
 * The OpenSearch Contributors require contributions made to  
            .precision(6)  
        Expression condition = getFilterCondition(rewritten);
        return filter.getCondition();
        long epochMicros = 1704067200000000L;
    // --- helpers ---  
        assertEquals("already_string", strLit.value());
        assertTrue(str3.nullable());
        // Tests VarCharLiteral within a function call (e.g., CASE expressions with string constants)
import io.substrait.plan.Plan;
            SimpleExtension.FunctionAnchor.of(DefaultExtensionCatalog.FUNCTIONS_COMPARISON, "equal:any_any")  
            .declaration(eqFunc)
        Expression literal = ImmutableExpression.PrecisionTimestampLiteral.builder()
        Plan.Root root = Plan.Root.builder().input(rel).addNames("col0").build();
        Expression eqCall = Expression.ScalarFunctionInvocation.builder()  
            .build();
        Plan rewritten = SubstraitPlanPojoRewriter.rewrite(plan);
        Expression varcharLiteral = ImmutableExpression.VarCharLiteral.builder().value("label").length(5).nullable(false).build();  
        Plan rewritten = SubstraitPlanPojoRewriter.rewrite(buildFilterPlan(literal));
        assertEquals(3, pts.precision());
import io.substrait.type.NamedStruct;
        assertEquals(epochMillis, pts.value());  
        assertEquals(epochMicros, arg1.value());
            .nullable(false)
        Expression strLiteral = ImmutableExpression.StrLiteral.builder().value("already_string").nullable(false).build();  
        FieldReference fieldRef = FieldReference.newRootStructReference(0, R.precisionTimestamp(3));
        Filter filter = (Filter) plan.getRoots().get(0).getInput();
        assertEquals(6, pts.precision());
import io.substrait.extension.SimpleExtension;  
        Expression.StrLiteral str1 = (Expression.StrLiteral) expressions.get(0);  
            .value(epochMillis)  
        // Tests multiple VarChar literals in a single Project (e.g., Chart/Trendline with multiple string options)
            .build();  
}
            .declaration(gtFunc)  
        Expression varcharLiteral = ImmutableExpression.VarCharLiteral.builder().value("Sum").length(3).nullable(false).build();
import java.util.List;  
        long epochMicros = 1704067200000000L;
    private static Plan buildPlan(io.substrait.relation.Rel rel) {
            .initialSchema(NamedStruct.of(List.of("col0"), R.struct(R.I64)))
        assertEquals(epochMicros, pts.value());
