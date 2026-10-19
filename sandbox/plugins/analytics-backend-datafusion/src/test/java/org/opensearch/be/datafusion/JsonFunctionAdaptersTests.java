            ReturnTypes.explicit(booleanNotNull),
            "adapted call's return type must equal the original call's return type, "  
            SqlFunctionCategory.STRING  
            "JSON_ARRAY_LENGTH",  
        assertSame(valueRef, call.getOperands().get(0));  
            ReturnTypes.explicit(varcharNullable),
            adapted.getType()  
        RexCall call = (RexCall) adapted;
        );  
        RelDataType integerNullable = typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.INTEGER), true);  
            SqlFunctionCategory.STRING
    public void testJsonArrayStripsFlagAndTagsHeterogeneousValues() {
import org.apache.calcite.plan.RelOptCluster;
        );  
    }  
    public void testJsonArrayLengthPreservesOriginalReturnType() {  
        assertEquals("triple per pair", 3, call.getOperands().size());
        RelDataType varcharNullable = typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.VARCHAR), true);
     * The adapter MUST preserve the Calcite {@link RelDataType} of the original call.  
     * Strips the leading SqlJsonConstructorNullClause flag and inserts a  
        );  
    }
        RexCall original = (RexCall) rexBuilder.makeCall(pplJsonOp, List.of(valueRef));
    }  
            SqlKind.OTHER_FUNCTION,  
        RexCall original = (RexCall) rexBuilder.makeCall(pplJsonValidOp, List.of(valueRef));
    public void testJsonArrayLengthRewritesToLocalOp() {
        RexNode adapted = new JsonFunctionAdapters.JsonArrayLengthAdapter().adapt(original, List.of(), cluster);
public class JsonFunctionAdaptersTests extends OpenSearchTestCase {
        );
import org.apache.calcite.rex.RexCall;
    public void setUp() throws Exception {  
            OperandTypes.STRING,
        assertEquals("n", ((org.apache.calcite.rex.RexLiteral) call.getOperands().get(0)).getValueAs(String.class));
        // Synthesize JSON_ARRAY_LENGTH(value) with a single VARCHAR operand.
            null,
            OperandTypes.VARIADIC,  
                + "otherwise the enclosing Project.rowType assertion fails in fragment conversion",  
    private RelDataTypeFactory typeFactory;
        RexNode intLit = rexBuilder.makeLiteral(1, integerNullable);
 */
            original.getType(),
        SqlFunction pplJsonValidOp = new SqlFunction(
        SqlFunction pplJsonArrayLengthOp = new SqlFunction(
            call.getOperator()
        assertEquals(
            "adapted call must target LOCAL_JSON_ARRAY_LENGTH_OP",  
            SqlKind.OTHER_FUNCTION,
import org.apache.calcite.rex.RexBuilder;
            ReturnTypes.explicit(varcharNullable),
import org.apache.calcite.jdbc.JavaTypeFactoryImpl;
    // ── JsonAdapter ───────────────────────────────────────────────────────  
            adapted.getType()
            ReturnTypes.explicit(varcharNullable),
            ReturnTypes.explicit(bigintNullable),  
        RexNode tag = call.getOperands().get(1);  
        );
    private RexBuilder rexBuilder;
     * {@link UnixTimestampAdapterTests#testAdaptedCallPreservesOriginalReturnType()}  
     * {@code LOCAL_JSON_VALID_OP}, so a naive {@code rexBuilder.makeCall(op, args)}
        RexCall original = (RexCall) rexBuilder.makeCall(pplJsonArrayLengthOp, List.of(valueRef));  
        assertSame(
import org.apache.calcite.sql.type.ReturnTypes;
        RelDataType integerNullable = typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.INTEGER), true);  
            OperandTypes.STRING,
            null,  
        );  
    /**
    private RelOptCluster cluster;  
        RexNode adapted = new JsonFunctionAdapters.JsonObjectAdapter().adapt(original, List.of(), cluster);  
        RelDataType varcharNullable = typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.VARCHAR), true);  
     * typeFactory type instance and trip {@code Project.isValid}'s
 * (shape + {@code testAdaptedCallPreservesOriginalReturnType} regression
import org.apache.calcite.sql.SqlFunction;
import org.apache.calcite.plan.hep.HepPlanner;  
 *
        assertEquals("numeric value gets tag 'n'", "n", ((org.apache.calcite.rex.RexLiteral) tag).getValueAs(String.class));
            SqlKind.OTHER_FUNCTION,  
import org.apache.calcite.sql.type.SqlTypeName;  
        );
    }
 * compatible open source license.
    public void testJsonRewritesToLocalOp() {
     * per-value type tag between each (key, value) pair so the Rust UDF can
 * Unit tests for the JSON-function adapter inner classes in  
        RexCall original = (RexCall) rexBuilder.makeCall(stdJsonArrayOp, List.of(flag, intLit, strLit));  
            SqlKind.OTHER_FUNCTION,
        assertSame(JsonFunctionAdapters.JsonArrayAdapter.LOCAL_JSON_ARRAY_OP, call.getOperator());
    /**
    // ── JsonValidAdapter ──────────────────────────────────────────────────
            null,  
        assertEquals("json is unary — no prepend / append", 1, call.getOperands().size());
     * PPL declares {@code JSON_ARRAY_LENGTH} with INTEGER_FORCE_NULLABLE; the
            null,  
        RexCall original = (RexCall) rexBuilder.makeCall(stdJsonObjectOp, List.of(flag, keyLiteral, intLiteral));
        // Expected operand layout: [tag1, val1, tag2, val2]. 4 ops total.  
 * {@link JsonFunctionAdapters}. Each inner adapter gets its own test method
        );  
            SqlKind.OTHER_FUNCTION,
        assertSame(JsonFunctionAdapters.JsonObjectAdapter.LOCAL_JSON_OBJECT_OP, call.getOperator());  
    /**
        );  
            ReturnTypes.explicit(booleanNullable),
        SqlFunction pplJsonOp = new SqlFunction(
        RexNode keyLiteral = rexBuilder.makeLiteral("name");  
     * {@code IS_JSON_VALUE} returns {@code BOOLEAN_NULLABLE}, same as  
        // adapter's contract is purely shape-based — any single-VARCHAR-operand  
            "JSON_ARRAY_LENGTH",
        // Synthesize JSON_VALID(value). In production the source operator is
            "JSON_OBJECT",  
 * this file be licensed under the Apache-2.0 license or a
    }
package org.opensearch.be.datafusion;
        assertEquals(booleanNotNull, original.getType());  
     * Same regression guard as {@link #testJsonArrayLengthPreservesOriginalReturnType}:  
import org.apache.calcite.rex.RexNode;  
        // Expected operand layout: [key, "n", castInt]. Flag stripped; tag "n" inserted before integer.
        assertSame("arg 0 must be the original value operand", valueRef, call.getOperands().get(0));
        HepPlanner planner = new HepPlanner(new HepProgramBuilder().build());
        assertSame(
     */  
            "JSON_VALID",  
            OperandTypes.STRING,
        // regression assertion actually distinguishes "preserve" from "infer".
        RexNode adapted = new JsonFunctionAdapters.JsonValidAdapter().adapt(original, List.of(), cluster);
            original.getType(),
        RexNode valueRef = rexBuilder.makeInputRef(varcharNullable, 0);
            "adapted call's return type must equal the original call's return type, "
    /** Strips the flag and inserts one tag per value. Mixed-type input → mixed tags. */  
        SqlFunction pplJsonValidOp = new SqlFunction(
    public void testJsonValidPreservesOriginalReturnType() {
 * The OpenSearch Contributors require contributions made to  
        assertEquals(bigintNullable, original.getType());
            "JSON_ARRAY",
        assertEquals("json_array_length is unary — no prepend / append", 1, call.getOperands().size());
        assertEquals("pair per value", 4, call.getOperands().size());
    public void testJsonObjectStripsFlagAndInsertsTypeTags() {
        SqlFunction pplJsonArrayLengthOp = new SqlFunction(  
        RexNode flag = rexBuilder.makeFlag(org.apache.calcite.sql.SqlJsonConstructorNullClause.NULL_ON_NULL);
     * for the original incident.
import org.apache.calcite.sql.SqlFunctionCategory;
        SqlFunction stdJsonObjectOp = new SqlFunction(
    // ── JsonArrayAdapter ──────────────────────────────────────────────────
     * locally-declared {@code LOCAL_JSON_ARRAY_LENGTH_OP} uses
     * would happen to produce the right type — pick a differently-nullable BOOLEAN
            "JSON_VALID",  
import org.apache.calcite.plan.hep.HepProgramBuilder;
    }  
}
            SqlFunctionCategory.STRING
        RelDataType varcharNullable = typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.VARCHAR), true);
            SqlFunctionCategory.STRING
            OperandTypes.STRING,  
            SqlFunctionCategory.STRING
        assertEquals("json_valid is unary — no prepend / append", 1, call.getOperands().size());
        assertTrue("adapted node must be a RexCall, got " + adapted.getClass(), adapted instanceof RexCall);
        RexCall original = (RexCall) rexBuilder.makeCall(pplJsonValidOp, List.of(valueRef));
 */  
        // RexCall must rewrite to LOCAL_JSON_VALID_OP. Using a SqlFunction stand-in
            SqlFunctionCategory.STRING
            OperandTypes.STRING,
                + "otherwise the enclosing Project.rowType assertion fails in fragment conversion",
        assertTrue("adapted node must be a RexCall, got " + adapted.getClass(), adapted instanceof RexCall);  
        );
        RexNode adapted = new JsonFunctionAdapters.JsonArrayLengthAdapter().adapt(original, List.of(), cluster);  
            JsonFunctionAdapters.JsonValidAdapter.LOCAL_JSON_VALID_OP,
 * guard). See {@link UnixTimestampAdapterTests} for the regression-guard rationale.  
        // Calcite's JSON_OBJECT prepends a SYMBOL-typed flag operand. Synthesize one with makeFlag.
        RexCall original = (RexCall) rexBuilder.makeCall(pplJsonArrayLengthOp, List.of(valueRef));
        typeFactory = new JavaTypeFactoryImpl();
        RexCall call = (RexCall) adapted;
        SqlFunction stdJsonArrayOp = new SqlFunction(
    }
            SqlKind.OTHER_FUNCTION,
        RelDataType varcharNullable = typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.VARCHAR), true);  
     * emit numerics unquoted vs strings quoted.
        RexNode adapted = new JsonFunctionAdapters.JsonArrayAdapter().adapt(original, List.of(), cluster);
        RexNode intLiteral = rexBuilder.makeLiteral(5, integerNullable);
            JsonFunctionAdapters.JsonArrayLengthAdapter.LOCAL_JSON_ARRAY_LENGTH_OP,
        RexNode valueRef = rexBuilder.makeInputRef(varcharNullable, 0);
import org.apache.calcite.rel.type.RelDataType;
     * here to make the assertion actually distinguish "preserve" from "infer".  
        );  
        // exercises the same code path and keeps the test self-contained.
    // ── JsonObjectAdapter ─────────────────────────────────────────────────  
        // Pick a type that specifically differs from what LOCAL_JSON_ARRAY_LENGTH_OP's
            null,  
        RelDataType booleanNullable = typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.BOOLEAN), true);
        RexCall call = (RexCall) adapted;
            OperandTypes.VARIADIC,
            call.getOperator()
import java.util.List;  
     */
        RexNode flag = rexBuilder.makeFlag(org.apache.calcite.sql.SqlJsonConstructorNullClause.NULL_ON_NULL);
        RexNode strLit = rexBuilder.makeLiteral("Tom");  
        RelDataType booleanNotNull = typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.BOOLEAN), false);
        RexCall call = (RexCall) adapted;  
        RexNode valueRef = rexBuilder.makeInputRef(varcharNullable, 0);
        RelDataType integerNullable = typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.INTEGER), true);
            SqlFunctionCategory.STRING
            ReturnTypes.explicit(integerNullable),
        RexNode valueRef = rexBuilder.makeInputRef(varcharNullable, 0);
        assertEquals("s", ((org.apache.calcite.rex.RexLiteral) call.getOperands().get(2)).getValueAs(String.class));  
     * {@code compatibleTypes} check during fragment conversion. See
            null,
        rexBuilder = new RexBuilder(typeFactory);  
    public void testJsonValidRewritesToLocalOp() {  
        RexNode valueRef = rexBuilder.makeInputRef(varcharNullable, 0);  
        RelDataType varcharNullable = typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.VARCHAR), true);  
/*  
import org.apache.calcite.sql.SqlKind;  
     * the cached {@code Project.rowType} matches post-adaptation. Production
        // ReturnTypes.INTEGER_NULLABLE would compute — BIGINT here — so the  
        // SqlStdOperatorTable.IS_JSON_VALUE (a SqlPostfixOperator) but the
     */
        assertSame("arg 0 must be the original value operand", valueRef, call.getOperands().get(0));
import org.apache.calcite.rel.type.RelDataTypeFactory;  
            "adapted call must target LOCAL_JSON_VALID_OP",  
        super.setUp();
        RexCall call = (RexCall) adapted;
import org.apache.calcite.sql.type.OperandTypes;
     * {@code ReturnTypes.INTEGER_NULLABLE} which would infer a different  
    }
        RexNode adapted = new JsonFunctionAdapters.JsonValidAdapter().adapt(original, List.of(), cluster);
    @Override
        RexNode adapted = new JsonFunctionAdapters.JsonAdapter().adapt(original, List.of(), cluster);  
    // ── JsonArrayLengthAdapter ────────────────────────────────────────────
        assertEquals(
     * the adapted call must keep the original call's {@link RelDataType} instance so
        assertSame("adapted call must target LOCAL_JSON_OP", JsonFunctionAdapters.JsonAdapter.LOCAL_JSON_OP, call.getOperator());
/**
            null,
        cluster = RelOptCluster.create(planner, rexBuilder);
            "JSON",
        RelDataType varcharNullable = typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.VARCHAR), true);
 * SPDX-License-Identifier: Apache-2.0
        assertTrue("adapted node must be a RexCall, got " + adapted.getClass(), adapted instanceof RexCall);  
        RelDataType bigintNullable = typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.BIGINT), true);
import org.opensearch.test.OpenSearchTestCase;
        RelDataType varcharNullable = typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.VARCHAR), true);  
            SqlKind.OTHER_FUNCTION,
