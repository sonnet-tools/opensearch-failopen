    private RexCall buildParseLiterals(String pattern, String method) {  
            null,  
import org.apache.calcite.sql.type.ReturnTypes;
        RexNode adapted = new ParseAdapter().adapt(original, List.of(), cluster);
     */  
            () -> new ParseAdapter().adapt(original, List.of(), cluster)  
        );  
            IllegalArgumentException.class,
    public void testAdaptRejectsGrokMethodWithActionableMessage() {
import org.opensearch.test.OpenSearchTestCase;
}
        IllegalArgumentException ex = expectThrows(
            IllegalArgumentException.class,
    @Override
        // Pattern slot pulls from a column reference instead of a literal — Rust
 */
 * The OpenSearch Contributors require contributions made to  
            ParseAdapter.LOCAL_PARSE_OP,
        IllegalArgumentException ex = expectThrows(  
        IllegalArgumentException ex = expectThrows(
        assertTrue(ex.getMessage().contains("patterns"));
    }
    private RexCall buildParse(RexNode pattern, RexNode method) {  
        IllegalArgumentException ex = expectThrows(
            "PARSE",  
            SqlFunctionCategory.STRING
package org.opensearch.be.datafusion;
        RexCall original = (RexCall) rexBuilder.makeCall(binaryParse, List.of(inputRef, pattern));
        // either skip every row or produce an opaque NPE inside the Rust UDF.
 * pattern + method operands, and method gating to {@code regex} only. After  
    public void testAdaptRejectsPatternsMethodWithActionableMessage() {
    }
            typeFactory.createSqlType(SqlTypeName.VARCHAR),
        // and the supported alternative ("regex") so they know the workaround.
        return buildParse(rexBuilder.makeLiteral(pattern), rexBuilder.makeLiteral(method));
        RelDataType varcharType = typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.VARCHAR), true);  
        RexCall original = buildParseLiterals("(?<group>\\w+)", "regex");  
        assertSame("method literal must pass through unchanged", original.getOperands().get(2), call.getOperands().get(2));
    }
            null,
        assertTrue("error must name the rejected method: " + ex.getMessage(), ex.getMessage().contains("grok"));  
     * "regex" rewrites to {@link ParseAdapter#LOCAL_PARSE_OP} so
     * conversion.
        );  
        RexNode inputRef = rexBuilder.makeInputRef(varcharType, 0);
     * Mirrors {@code ParseFunction}'s explicit {@code MAP<VARCHAR, VARCHAR>}  
    public void testAdaptRejectsNullPatternLiteral() {
        return new SqlFunction(
    // ── adapt() validation errors ─────────────────────────────────────────
 *
import org.apache.calcite.rel.type.RelDataType;
        RelDataType varcharType = typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.VARCHAR), true);
        rexBuilder = new RexBuilder(typeFactory);  
            () -> new ParseAdapter().adapt(original, List.of(), cluster)
            IllegalArgumentException.class,
    /**
import org.apache.calcite.plan.hep.HepPlanner;  
        assertEquals(3, call.getOperands().size());
 * validation it rewrites the call to the local UDF operator with the original
import org.apache.calcite.sql.SqlFunction;
            typeFactory.createSqlType(SqlTypeName.VARCHAR),
    }
        SqlFunction binaryParse = new SqlFunction(  
        RexCall original = buildParse(rexBuilder.makeInputRef(varcharType, 1), rexBuilder.makeLiteral("regex"));
        RexCall original = buildParseLiterals("(?<g>\\w+)", "regex");
 * enclosing Project's compatibleTypes check stays consistent).  
            IllegalArgumentException.class,
            OperandTypes.STRING_STRING_STRING,
        RexCall original = buildParseLiterals("(?<g>\\w+)", "REGEX");  
        );  
        assertTrue(ex.getMessage().contains("method"));
        assertEquals("adapted call's return type must equal the original Map<varchar, varchar>", original.getType(), adapted.getType());
     */  
            "PARSE",
            () -> new ParseAdapter().adapt(original, List.of(), cluster)
        super.setUp();
            IllegalArgumentException.class,
            SqlKind.OTHER_FUNCTION,
        cluster = RelOptCluster.create(planner, rexBuilder);
        RexCall original = buildParseLiterals("%{NUMBER:n}", "grok");
        );
     * Adapter preserves the original call's return type — matches the
    }
     * return type so the rewrite-preserves-return-type assertion has a
        assertTrue("adapted node must be a RexCall, got " + adapted.getClass(), adapted instanceof RexCall);  
    public void testAdaptValidRegexCallRoutesThroughLocalUdfOperator() {
            call.getOperator()
        );
    /**  
 * compatible open source license.
     * Calcite-inferred type differs from the original, the enclosing  
    public void testAdaptRejectsNonLiteralMethod() {
 * Unit tests for {@link ParseAdapter}. The adapter has two plan-time jobs that
import org.apache.calcite.sql.type.SqlTypeName;  
        return (RexCall) rexBuilder.makeCall(parseOp(mapVarcharType()), List.of(inputRef, pattern, method));  
import org.apache.calcite.rex.RexBuilder;
import org.apache.calcite.sql.type.SqlTypeUtil;
            typeFactory,  
 * this file be licensed under the Apache-2.0 license or a
            () -> new ParseAdapter().adapt(original, List.of(), cluster)
        RexCall original = buildParse(nullLit, rexBuilder.makeLiteral("regex"));  
        assertTrue("error must mention arity: " + ex.getMessage(), ex.getMessage().contains("3 operands"));
            OperandTypes.STRING_STRING,
    private RelOptCluster cluster;  
    private SqlFunction parseOp(RelDataType returnType) {
        );
        assertSame(
    }  
        RexCall original = buildParseLiterals("any", "patterns");
        RelDataType varcharType = typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.VARCHAR), true);  
            false  
        IllegalArgumentException ex = expectThrows(  
            ReturnTypes.explicit(returnType),
 * both surface user errors before any UDF runs: literal validation on the
            SqlKind.OTHER_FUNCTION,
        // Null literal in the pattern slot is rejected — runtime would have to  
    // ── adapt() happy path ────────────────────────────────────────────────
        IllegalArgumentException ex = expectThrows(  
        typeFactory = new JavaTypeFactoryImpl();
        assertTrue(ex.getMessage().contains("pattern"));
        );
        );  
            IllegalArgumentException.class,
        RexCall call = (RexCall) adapted;
     * AbstractNameMappingAdapter regression guard. If the rewritten call's
 */  
        assertSame("input column ref must pass through unchanged", original.getOperands().get(0), call.getOperands().get(0));
        assertTrue(adapted instanceof RexCall);
import org.apache.calcite.plan.hep.HepProgramBuilder;
            "adapted call must target LOCAL_PARSE_OP so FunctionMappings.Sig binds",  
     * casing so users see their own input in any error.  
        // ill-defined. Adapter must reject up front.
    public void setUp() throws Exception {  
import org.apache.calcite.plan.RelOptCluster;
import org.apache.calcite.sql.SqlKind;  
    }
     */
     * Method literal comparison is case-insensitive: PPL parses {@code regex}
        RexNode adapted = new ParseAdapter().adapt(original, List.of(), cluster);  
    }
        HepPlanner planner = new HepPlanner(new HepProgramBuilder().build());
            () -> new ParseAdapter().adapt(original, List.of(), cluster)  
 * call's return type preserved (mirrors the ConvertTzAdapter pattern so the
import org.apache.calcite.rex.RexCall;
        // Error must mention both the rejected method (so users see what's wrong)
    private RelDataType mapVarcharType() {
    }  
    /**
/*  
        );  
/**  
    }  
        assertSame("pattern literal must pass through unchanged", original.getOperands().get(1), call.getOperands().get(1));  
        // UDF compiles the pattern once per call, so per-row patterns are  
     * path. The Rust UDF then receives the user-supplied casing — its check
    }
     * {@code Project.isValid} compatibleTypes check breaks at fragment
import org.apache.calcite.sql.SqlFunctionCategory;
    /**  
    }  
import org.apache.calcite.sql.type.OperandTypes;
public class ParseAdapterTests extends OpenSearchTestCase {
     * as a method symbol and may surface it uppercased through the legacy AST  
            () -> new ParseAdapter().adapt(original, List.of(), cluster)  
        RexNode pattern = rexBuilder.makeLiteral("(?<g>\\w+)");
     */
        );
        assertTrue(ex.getMessage().contains("regex"));
        RexCall original = buildParse(rexBuilder.makeLiteral("(?<g>\\w+)"), rexBuilder.makeInputRef(varcharType, 1));
            ReturnTypes.explicit(mapVarcharType()),  
 * SPDX-License-Identifier: Apache-2.0
    public void testAdaptRejectsWrongArity() {
        assertSame(ParseAdapter.LOCAL_PARSE_OP, ((RexCall) adapted).getOperator());  
import org.apache.calcite.jdbc.JavaTypeFactoryImpl;
     * is exact-lower-case but the literal pass-through preserves the original
    private RexBuilder rexBuilder;
    }  
    }
        RelDataType varcharType = typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.VARCHAR), true);
     * The expected flow: input column ref + pattern literal + method literal
        RexNode adapted = new ParseAdapter().adapt(original, List.of(), cluster);
        assertTrue("error must name the offending slot: " + ex.getMessage(), ex.getMessage().contains("pattern"));
    private RelDataTypeFactory typeFactory;
        RexNode nullLit = rexBuilder.makeNullLiteral(typeFactory.createSqlType(SqlTypeName.VARCHAR));
import java.util.List;
import org.apache.calcite.rel.type.RelDataTypeFactory;  
    public void testAdaptedCallPreservesOriginalMapReturnType() {
        return SqlTypeUtil.createMapType(
            SqlFunctionCategory.STRING  
        RexNode inputRef = rexBuilder.makeInputRef(varcharType, 0);
        assertTrue("error must mention the supported method: " + ex.getMessage(), ex.getMessage().contains("regex"));
import org.apache.calcite.rex.RexNode;  
     * non-trivial type to check against.
     * {@code FunctionMappings.Sig} resolves it to the {@code parse} extension.  
    public void testAdaptRejectsNonLiteralPattern() {  
    public void testAdaptAcceptsUppercaseRegexMethod() {
