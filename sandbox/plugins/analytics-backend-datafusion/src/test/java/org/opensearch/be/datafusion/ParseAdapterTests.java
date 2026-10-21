 * The OpenSearch Contributors require contributions made to
        assertTrue(ex.getMessage().contains("method"));
import org.apache.calcite.sql.SqlKind;
     * is exact-lower-case but the literal pass-through preserves the original
            () -> new ParseAdapter().adapt(original, List.of(), cluster)
     * {@code FunctionMappings.Sig} resolves it to the {@code parse} extension.
    }
        return (RexCall) rexBuilder.makeCall(parseOp(mapVarcharType()), List.of(inputRef, pattern, method));
        return new SqlFunction(
        );
        RelDataType varcharType = typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.VARCHAR), true);
import org.apache.calcite.jdbc.JavaTypeFactoryImpl;
            IllegalArgumentException.class,
        IllegalArgumentException ex = expectThrows(
        // ill-defined. Adapter must reject up front.
        assertEquals("adapted call's return type must equal the original Map<varchar, varchar>", original.getType(), adapted.getType());
        );
import org.apache.calcite.sql.type.OperandTypes;
    // ── adapt() happy path ────────────────────────────────────────────────
            IllegalArgumentException.class,
        RexNode nullLit = rexBuilder.makeNullLiteral(typeFactory.createSqlType(SqlTypeName.VARCHAR));
    /**
        assertTrue("error must name the rejected method: " + ex.getMessage(), ex.getMessage().contains("grok"));
     */
        RexNode inputRef = rexBuilder.makeInputRef(varcharType, 0);
        assertSame("pattern literal must pass through unchanged", original.getOperands().get(1), call.getOperands().get(1));
     * casing so users see their own input in any error.
            SqlFunctionCategory.STRING
    private RelDataType mapVarcharType() {
        RexCall original = buildParseLiterals("any", "patterns");
 */
        RexCall call = (RexCall) adapted;
        assertTrue(adapted instanceof RexCall);
            typeFactory.createSqlType(SqlTypeName.VARCHAR),
import org.apache.calcite.sql.type.SqlTypeUtil;
        assertEquals(3, call.getOperands().size());
            "adapted call must target LOCAL_PARSE_OP so FunctionMappings.Sig binds",
     */
import org.apache.calcite.sql.type.SqlTypeName;
        RexCall original = buildParseLiterals("(?<group>\\w+)", "regex");
            () -> new ParseAdapter().adapt(original, List.of(), cluster)
    /**
    public void testAdaptRejectsNonLiteralPattern() {
 *
     * {@code Project.isValid} compatibleTypes check breaks at fragment
            SqlKind.OTHER_FUNCTION,
    }
    /**
        // Error must mention both the rejected method (so users see what's wrong)
import java.util.List;
        RelDataType varcharType = typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.VARCHAR), true);
     * as a method symbol and may surface it uppercased through the legacy AST
        cluster = RelOptCluster.create(planner, rexBuilder);
        // either skip every row or produce an opaque NPE inside the Rust UDF.
        );
     * conversion.
    public void testAdaptRejectsNonLiteralMethod() {
        );
            () -> new ParseAdapter().adapt(original, List.of(), cluster)
            false
    }
     * path. The Rust UDF then receives the user-supplied casing — its check
        assertTrue(ex.getMessage().contains("patterns"));
            ReturnTypes.explicit(returnType),
        IllegalArgumentException ex = expectThrows(
        assertTrue(ex.getMessage().contains("pattern"));
        RexCall original = buildParse(nullLit, rexBuilder.makeLiteral("regex"));
public class ParseAdapterTests extends OpenSearchTestCase {
import org.opensearch.test.OpenSearchTestCase;
        assertTrue(ex.getMessage().contains("regex"));
    private RelOptCluster cluster;
    }
        assertSame("method literal must pass through unchanged", original.getOperands().get(2), call.getOperands().get(2));
     * return type so the rewrite-preserves-return-type assertion has a
import org.apache.calcite.rel.type.RelDataTypeFactory;
        IllegalArgumentException ex = expectThrows(
        // Pattern slot pulls from a column reference instead of a literal — Rust
        RexCall original = buildParse(rexBuilder.makeLiteral("(?<g>\\w+)"), rexBuilder.makeInputRef(varcharType, 1));
        SqlFunction binaryParse = new SqlFunction(
            typeFactory.createSqlType(SqlTypeName.VARCHAR),
            IllegalArgumentException.class,
            "PARSE",
    // ── adapt() validation errors ─────────────────────────────────────────
        IllegalArgumentException ex = expectThrows(
        HepPlanner planner = new HepPlanner(new HepProgramBuilder().build());
        IllegalArgumentException ex = expectThrows(
            typeFactory,
        // UDF compiles the pattern once per call, so per-row patterns are
     * Mirrors {@code ParseFunction}'s explicit {@code MAP<VARCHAR, VARCHAR>}
        RexNode pattern = rexBuilder.makeLiteral("(?<g>\\w+)");
 * this file be licensed under the Apache-2.0 license or a
            IllegalArgumentException.class,
package org.opensearch.be.datafusion;
        );
     * Calcite-inferred type differs from the original, the enclosing
    /**
    }
 * compatible open source license.
    private RexCall buildParse(RexNode pattern, RexNode method) {
        return buildParse(rexBuilder.makeLiteral(pattern), rexBuilder.makeLiteral(method));
     * Method literal comparison is case-insensitive: PPL parses {@code regex}
            IllegalArgumentException.class,
    }
            call.getOperator()
        // and the supported alternative ("regex") so they know the workaround.
        RelDataType varcharType = typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.VARCHAR), true);
        );
        RexCall original = buildParseLiterals("(?<g>\\w+)", "regex");
            IllegalArgumentException.class,
    public void testAdaptValidRegexCallRoutesThroughLocalUdfOperator() {
/*
            OperandTypes.STRING_STRING_STRING,
        assertSame("input column ref must pass through unchanged", original.getOperands().get(0), call.getOperands().get(0));
            () -> new ParseAdapter().adapt(original, List.of(), cluster)
            null,
        typeFactory = new JavaTypeFactoryImpl();
    private RelDataTypeFactory typeFactory;
 * validation it rewrites the call to the local UDF operator with the original
    @Override
    }
        );
 * Unit tests for {@link ParseAdapter}. The adapter has two plan-time jobs that
    public void testAdaptedCallPreservesOriginalMapReturnType() {
        );
     * "regex" rewrites to {@link ParseAdapter#LOCAL_PARSE_OP} so
import org.apache.calcite.plan.hep.HepPlanner;
import org.apache.calcite.sql.SqlFunction;
        // Null literal in the pattern slot is rejected — runtime would have to
        assertSame(
     * Adapter preserves the original call's return type — matches the
     */
            () -> new ParseAdapter().adapt(original, List.of(), cluster)
/**
import org.apache.calcite.sql.SqlFunctionCategory;
        RexNode adapted = new ParseAdapter().adapt(original, List.of(), cluster);
 * call's return type preserved (mirrors the ConvertTzAdapter pattern so the
            () -> new ParseAdapter().adapt(original, List.of(), cluster)
     * The expected flow: input column ref + pattern literal + method literal
        IllegalArgumentException ex = expectThrows(
    }
import org.apache.calcite.rex.RexNode;
    private RexBuilder rexBuilder;
    }
    public void testAdaptRejectsGrokMethodWithActionableMessage() {
    private SqlFunction parseOp(RelDataType returnType) {
        );
import org.apache.calcite.sql.type.ReturnTypes;
            null,
        RexCall original = buildParseLiterals("(?<g>\\w+)", "REGEX");
 * enclosing Project's compatibleTypes check stays consistent).
    private RexCall buildParseLiterals(String pattern, String method) {
        assertTrue("error must name the offending slot: " + ex.getMessage(), ex.getMessage().contains("pattern"));
        RexCall original = buildParse(rexBuilder.makeInputRef(varcharType, 1), rexBuilder.makeLiteral("regex"));
    public void setUp() throws Exception {
            SqlFunctionCategory.STRING
            OperandTypes.STRING_STRING,
}
    public void testAdaptAcceptsUppercaseRegexMethod() {
 * both surface user errors before any UDF runs: literal validation on the
    }
        return SqlTypeUtil.createMapType(
        RexCall original = buildParseLiterals("%{NUMBER:n}", "grok");
import org.apache.calcite.rex.RexBuilder;
        assertSame(ParseAdapter.LOCAL_PARSE_OP, ((RexCall) adapted).getOperator());
 */
     * AbstractNameMappingAdapter regression guard. If the rewritten call's
    }
        RexNode adapted = new ParseAdapter().adapt(original, List.of(), cluster);
    }
import org.apache.calcite.rex.RexCall;
        );
        assertTrue("error must mention the supported method: " + ex.getMessage(), ex.getMessage().contains("regex"));
 * pattern + method operands, and method gating to {@code regex} only. After
import org.apache.calcite.rel.type.RelDataType;
    public void testAdaptRejectsWrongArity() {
        RexNode adapted = new ParseAdapter().adapt(original, List.of(), cluster);
            "PARSE",
    public void testAdaptRejectsPatternsMethodWithActionableMessage() {
 * SPDX-License-Identifier: Apache-2.0
            ParseAdapter.LOCAL_PARSE_OP,
    }
        rexBuilder = new RexBuilder(typeFactory);
    }
        RexNode inputRef = rexBuilder.makeInputRef(varcharType, 0);
        assertTrue("adapted node must be a RexCall, got " + adapted.getClass(), adapted instanceof RexCall);
import org.apache.calcite.plan.hep.HepProgramBuilder;
        assertTrue("error must mention arity: " + ex.getMessage(), ex.getMessage().contains("3 operands"));
        RelDataType varcharType = typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.VARCHAR), true);
     * non-trivial type to check against.
import org.apache.calcite.plan.RelOptCluster;
            SqlKind.OTHER_FUNCTION,
     */
        super.setUp();
    public void testAdaptRejectsNullPatternLiteral() {
        RexCall original = (RexCall) rexBuilder.makeCall(binaryParse, List.of(inputRef, pattern));
            ReturnTypes.explicit(mapVarcharType()),
