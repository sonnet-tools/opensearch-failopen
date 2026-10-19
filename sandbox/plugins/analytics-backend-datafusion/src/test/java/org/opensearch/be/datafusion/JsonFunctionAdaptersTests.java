        assertEquals("json_array_length is unary — no prepend / append", 1, call.getOperands().size());
 * Unit tests for the JSON-function adapter inner classes in
        HepPlanner planner = new HepPlanner(new HepProgramBuilder().build());
        SqlFunction stdJsonArrayOp = new SqlFunction(
        // SqlStdOperatorTable.IS_JSON_VALUE (a SqlPostfixOperator) but the
        RelDataType varcharNullable = typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.VARCHAR), true);
    /**
        RexCall call = (RexCall) adapted;
            "adapted call's return type must equal the original call's return type, "
            OperandTypes.STRING,
            OperandTypes.STRING,
                + "otherwise the enclosing Project.rowType assertion fails in fragment conversion",
        RelDataType integerNullable = typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.INTEGER), true);
     * the cached {@code Project.rowType} matches post-adaptation. Production
        RexCall original = (RexCall) rexBuilder.makeCall(stdJsonArrayOp, List.of(flag, intLit, strLit));
import org.apache.calcite.plan.RelOptCluster;
    }
        );
            null,
        RexNode adapted = new JsonFunctionAdapters.JsonArrayLengthAdapter().adapt(original, List.of(), cluster);
import org.apache.calcite.sql.type.ReturnTypes;
            SqlFunctionCategory.STRING
        );
        RexNode valueRef = rexBuilder.makeInputRef(varcharNullable, 0);
        SqlFunction pplJsonValidOp = new SqlFunction(
     * typeFactory type instance and trip {@code Project.isValid}'s
        assertSame(
        // regression assertion actually distinguishes "preserve" from "infer".
        // ReturnTypes.INTEGER_NULLABLE would compute — BIGINT here — so the
    private RexBuilder rexBuilder;
    // ── JsonValidAdapter ──────────────────────────────────────────────────
        );
            SqlFunctionCategory.STRING
            OperandTypes.STRING,
        RexCall call = (RexCall) adapted;
        );
        RelDataType varcharNullable = typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.VARCHAR), true);
     * the adapted call must keep the original call's {@link RelDataType} instance so
            OperandTypes.VARIADIC,
        assertTrue("adapted node must be a RexCall, got " + adapted.getClass(), adapted instanceof RexCall);
        // Synthesize JSON_ARRAY_LENGTH(value) with a single VARCHAR operand.
        assertEquals(bigintNullable, original.getType());
        );
        RexNode adapted = new JsonFunctionAdapters.JsonArrayLengthAdapter().adapt(original, List.of(), cluster);
        assertSame(
        RexCall original = (RexCall) rexBuilder.makeCall(pplJsonOp, List.of(valueRef));
        // RexCall must rewrite to LOCAL_JSON_VALID_OP. Using a SqlFunction stand-in
    public void testJsonRewritesToLocalOp() {
     * here to make the assertion actually distinguish "preserve" from "infer".
     * The adapter MUST preserve the Calcite {@link RelDataType} of the original call.
        // Expected operand layout: [tag1, val1, tag2, val2]. 4 ops total.
        );
            null,
    }
        assertEquals("json is unary — no prepend / append", 1, call.getOperands().size());
        assertTrue("adapted node must be a RexCall, got " + adapted.getClass(), adapted instanceof RexCall);
import org.apache.calcite.rel.type.RelDataType;
        assertEquals(
     * {@code LOCAL_JSON_VALID_OP}, so a naive {@code rexBuilder.makeCall(op, args)}
     * {@code compatibleTypes} check during fragment conversion. See
        RexNode adapted = new JsonFunctionAdapters.JsonValidAdapter().adapt(original, List.of(), cluster);
import org.apache.calcite.sql.type.OperandTypes;
 * compatible open source license.
        RexNode flag = rexBuilder.makeFlag(org.apache.calcite.sql.SqlJsonConstructorNullClause.NULL_ON_NULL);
        RexNode keyLiteral = rexBuilder.makeLiteral("name");
import org.apache.calcite.rex.RexBuilder;
        cluster = RelOptCluster.create(planner, rexBuilder);
        SqlFunction pplJsonArrayLengthOp = new SqlFunction(
        RexNode adapted = new JsonFunctionAdapters.JsonObjectAdapter().adapt(original, List.of(), cluster);
 */
        RexCall original = (RexCall) rexBuilder.makeCall(pplJsonArrayLengthOp, List.of(valueRef));
        );
        typeFactory = new JavaTypeFactoryImpl();
     * emit numerics unquoted vs strings quoted.
        // Pick a type that specifically differs from what LOCAL_JSON_ARRAY_LENGTH_OP's
    /**
     * {@code ReturnTypes.INTEGER_NULLABLE} which would infer a different
import org.apache.calcite.jdbc.JavaTypeFactoryImpl;
        SqlFunction pplJsonArrayLengthOp = new SqlFunction(
    // ── JsonObjectAdapter ─────────────────────────────────────────────────
import org.apache.calcite.sql.SqlKind;
            SqlKind.OTHER_FUNCTION,
import org.apache.calcite.plan.hep.HepPlanner;
        rexBuilder = new RexBuilder(typeFactory);
            "adapted call must target LOCAL_JSON_ARRAY_LENGTH_OP",
        RexCall call = (RexCall) adapted;
            SqlKind.OTHER_FUNCTION,
        assertSame("arg 0 must be the original value operand", valueRef, call.getOperands().get(0));
        RelDataType varcharNullable = typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.VARCHAR), true);
        assertEquals("triple per pair", 3, call.getOperands().size());
            "JSON_ARRAY_LENGTH",
        assertSame(JsonFunctionAdapters.JsonArrayAdapter.LOCAL_JSON_ARRAY_OP, call.getOperator());
        RexNode intLiteral = rexBuilder.makeLiteral(5, integerNullable);
     */
     * Strips the leading SqlJsonConstructorNullClause flag and inserts a
     * Same regression guard as {@link #testJsonArrayLengthPreservesOriginalReturnType}:
    public void testJsonArrayStripsFlagAndTagsHeterogeneousValues() {
            ReturnTypes.explicit(varcharNullable),
     */
            OperandTypes.STRING,
            JsonFunctionAdapters.JsonArrayLengthAdapter.LOCAL_JSON_ARRAY_LENGTH_OP,
    public void testJsonArrayLengthPreservesOriginalReturnType() {
    private RelOptCluster cluster;
            SqlKind.OTHER_FUNCTION,
            adapted.getType()
        RelDataType varcharNullable = typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.VARCHAR), true);
import org.apache.calcite.rex.RexCall;
import org.apache.calcite.sql.type.SqlTypeName;
     * {@code IS_JSON_VALUE} returns {@code BOOLEAN_NULLABLE}, same as
 *
import org.opensearch.test.OpenSearchTestCase;
        );
            SqlKind.OTHER_FUNCTION,
            JsonFunctionAdapters.JsonValidAdapter.LOCAL_JSON_VALID_OP,
            "JSON_VALID",
        SqlFunction pplJsonValidOp = new SqlFunction(
    public void setUp() throws Exception {
        RexNode intLit = rexBuilder.makeLiteral(1, integerNullable);
        RexCall original = (RexCall) rexBuilder.makeCall(pplJsonValidOp, List.of(valueRef));
 * SPDX-License-Identifier: Apache-2.0
        RexCall original = (RexCall) rexBuilder.makeCall(pplJsonValidOp, List.of(valueRef));
        RexNode strLit = rexBuilder.makeLiteral("Tom");
    // ── JsonAdapter ───────────────────────────────────────────────────────
            "JSON_OBJECT",
        RelDataType varcharNullable = typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.VARCHAR), true);
 * this file be licensed under the Apache-2.0 license or a
    // ── JsonArrayLengthAdapter ────────────────────────────────────────────
        assertEquals(
            SqlFunctionCategory.STRING
/*
            SqlFunctionCategory.STRING
        super.setUp();
            original.getType(),
            "adapted call must target LOCAL_JSON_VALID_OP",
            OperandTypes.STRING,
    public void testJsonValidRewritesToLocalOp() {
            "JSON_ARRAY_LENGTH",
        RelDataType integerNullable = typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.INTEGER), true);
 * (shape + {@code testAdaptedCallPreservesOriginalReturnType} regression
        // Synthesize JSON_VALID(value). In production the source operator is
        RexNode tag = call.getOperands().get(1);
            OperandTypes.VARIADIC,
            "JSON_ARRAY",
            ReturnTypes.explicit(bigintNullable),
        RexNode flag = rexBuilder.makeFlag(org.apache.calcite.sql.SqlJsonConstructorNullClause.NULL_ON_NULL);
        assertSame("adapted call must target LOCAL_JSON_OP", JsonFunctionAdapters.JsonAdapter.LOCAL_JSON_OP, call.getOperator());
        assertEquals("s", ((org.apache.calcite.rex.RexLiteral) call.getOperands().get(2)).getValueAs(String.class));
            ReturnTypes.explicit(varcharNullable),
            original.getType(),
        assertTrue("adapted node must be a RexCall, got " + adapted.getClass(), adapted instanceof RexCall);
     * for the original incident.
        );
            call.getOperator()
            SqlKind.OTHER_FUNCTION,
    }
            null,
    public void testJsonValidPreservesOriginalReturnType() {
public class JsonFunctionAdaptersTests extends OpenSearchTestCase {
        );
package org.opensearch.be.datafusion;
    /** Strips the flag and inserts one tag per value. Mixed-type input → mixed tags. */
    public void testJsonArrayLengthRewritesToLocalOp() {
        assertEquals("numeric value gets tag 'n'", "n", ((org.apache.calcite.rex.RexLiteral) tag).getValueAs(String.class));
        );
        // Expected operand layout: [key, "n", castInt]. Flag stripped; tag "n" inserted before integer.
            SqlKind.OTHER_FUNCTION,
     * would happen to produce the right type — pick a differently-nullable BOOLEAN
        RexNode valueRef = rexBuilder.makeInputRef(varcharNullable, 0);
        RexCall call = (RexCall) adapted;
     * locally-declared {@code LOCAL_JSON_ARRAY_LENGTH_OP} uses
            ReturnTypes.explicit(booleanNullable),
        RexNode adapted = new JsonFunctionAdapters.JsonArrayAdapter().adapt(original, List.of(), cluster);
            null,
            SqlFunctionCategory.STRING
     * per-value type tag between each (key, value) pair so the Rust UDF can
import org.apache.calcite.sql.SqlFunctionCategory;
/**
 */
    @Override
        RexNode valueRef = rexBuilder.makeInputRef(varcharNullable, 0);
        assertEquals("n", ((org.apache.calcite.rex.RexLiteral) call.getOperands().get(0)).getValueAs(String.class));
        RexNode adapted = new JsonFunctionAdapters.JsonAdapter().adapt(original, List.of(), cluster);
            call.getOperator()
 * The OpenSearch Contributors require contributions made to
            adapted.getType()
    /**
            SqlKind.OTHER_FUNCTION,
            "adapted call's return type must equal the original call's return type, "
import org.apache.calcite.plan.hep.HepProgramBuilder;
    }
import java.util.List;
import org.apache.calcite.rel.type.RelDataTypeFactory;
    // ── JsonArrayAdapter ──────────────────────────────────────────────────
        assertSame(valueRef, call.getOperands().get(0));
import org.apache.calcite.rex.RexNode;
            "JSON_VALID",
    }
        // Calcite's JSON_OBJECT prepends a SYMBOL-typed flag operand. Synthesize one with makeFlag.
        RexNode valueRef = rexBuilder.makeInputRef(varcharNullable, 0);
        assertEquals("json_valid is unary — no prepend / append", 1, call.getOperands().size());
            SqlFunctionCategory.STRING
        RexNode adapted = new JsonFunctionAdapters.JsonValidAdapter().adapt(original, List.of(), cluster);
        assertEquals("pair per value", 4, call.getOperands().size());
     * {@link UnixTimestampAdapterTests#testAdaptedCallPreservesOriginalReturnType()}
        RexNode valueRef = rexBuilder.makeInputRef(varcharNullable, 0);
     */
        RelDataType varcharNullable = typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.VARCHAR), true);
 * guard). See {@link UnixTimestampAdapterTests} for the regression-guard rationale.
            "JSON",
        RelDataType booleanNullable = typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.BOOLEAN), true);
    private RelDataTypeFactory typeFactory;
    }
     * PPL declares {@code JSON_ARRAY_LENGTH} with INTEGER_FORCE_NULLABLE; the
            ReturnTypes.explicit(integerNullable),
            SqlFunctionCategory.STRING
        // adapter's contract is purely shape-based — any single-VARCHAR-operand
        RexCall call = (RexCall) adapted;
        RexCall original = (RexCall) rexBuilder.makeCall(pplJsonArrayLengthOp, List.of(valueRef));
import org.apache.calcite.sql.SqlFunction;
        RelDataType bigintNullable = typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.BIGINT), true);
        // exercises the same code path and keeps the test self-contained.
        RelDataType booleanNotNull = typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.BOOLEAN), false);
            null,
}
        RelDataType integerNullable = typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.INTEGER), true);
        assertSame("arg 0 must be the original value operand", valueRef, call.getOperands().get(0));
    }
        RexCall original = (RexCall) rexBuilder.makeCall(stdJsonObjectOp, List.of(flag, keyLiteral, intLiteral));
        SqlFunction pplJsonOp = new SqlFunction(
    }
 * {@link JsonFunctionAdapters}. Each inner adapter gets its own test method
            ReturnTypes.explicit(varcharNullable),
            null,
            null,
        assertSame(JsonFunctionAdapters.JsonObjectAdapter.LOCAL_JSON_OBJECT_OP, call.getOperator());
        assertEquals(booleanNotNull, original.getType());
        SqlFunction stdJsonObjectOp = new SqlFunction(
        RelDataType varcharNullable = typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.VARCHAR), true);
            ReturnTypes.explicit(booleanNotNull),
                + "otherwise the enclosing Project.rowType assertion fails in fragment conversion",
    public void testJsonObjectStripsFlagAndInsertsTypeTags() {
