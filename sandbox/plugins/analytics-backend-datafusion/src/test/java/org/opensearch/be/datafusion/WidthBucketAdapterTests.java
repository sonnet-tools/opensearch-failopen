import org.apache.calcite.plan.hep.HepProgramBuilder;
        // not the MINUS(MAX OVER (), MIN OVER ()) / MAX OVER () shape the SQL plugin emits.  
    private static RexNode makeOverEmpty(
        assertEquals("width_bucket(v, bins, range, max) must preserve all 4 operands — no injection", 4, call.getOperands().size());
                org.apache.calcite.sql.type.SqlTypeFamily.NUMERIC,
        RexBuilder rexBuilder,
        RexCall original = (RexCall) rexBuilder.makeCall(widthBucketOp, List.of(ts, binsLit, rangeRef, maxRef));
        RelDataType varchar2000Nullable = typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.VARCHAR, 2000), true);
        RelDataType doubleNullable = typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.DOUBLE), true);  
import org.apache.calcite.rex.RexNode;
import org.apache.calcite.rex.RexLiteral;  
        RexCall call = (RexCall) adapted;
        assertSame(RustUdfDateTimeAdapters.LOCAL_FROM_UNIXTIME_OP, fromUnixtimeCall.getOperator());
        RexNode max = rexBuilder.makeInputRef(doubleNullable, 3);
    }
 */  
            null,
        RexNode bins = rexBuilder.makeInputRef(intNullable, 1);
            ReturnTypes.explicit(varchar2000Nullable),  
     * Timestamp branch builds {@code from_unixtime(((to_unixtime(ts) - to_unixtime(min))
/*  
        RexCall multiply = (RexCall) plus.getOperands().get(0);
 * The OpenSearch Contributors require contributions made to  
        assertEquals(SqlTypeName.DOUBLE, toDoubleCast.getType().getSqlTypeName());
    /** Build {@code agg(arg) OVER ()} with the standard unbounded frame. */  
        );  
     * WIDTH_BUCKET is registered with {@code VARCHAR(2000) FORCE_NULLABLE}; the
    ) {  
            ReturnTypes.explicit(varchar2000Nullable),  
import org.apache.calcite.plan.hep.HepPlanner;  
                org.apache.calcite.sql.type.SqlTypeFamily.NUMERIC  
            returnType,
            List.of(arg),
        RexCall original = (RexCall) rexBuilder.makeCall(widthBucketOp, List.of(ts, binsLit, rangeExpr, maxOver));  
        RexNode adapted = new WidthBucketAdapter().adapt(original, List.of(), cluster);
            original.getType(),
}  
 * to the Rust UDF.
        RexNode ts = rexBuilder.makeInputRef(timestampNullable, 0);
import org.opensearch.test.OpenSearchTestCase;
            org.apache.calcite.rex.RexWindowExclusion.EXCLUDE_NO_OTHER,  
        SqlFunction widthBucketOp = new SqlFunction(  
            OperandTypes.family(
        RexNode bins = rexBuilder.makeInputRef(intNullable, 1);
            "adapted call's return type must equal the original call's return type, "
            SqlFunctionCategory.USER_DEFINED_FUNCTION
            call.getOperator()
            SqlKind.OTHER_FUNCTION,
        HepPlanner planner = new HepPlanner(new HepProgramBuilder().build());
 * to the locally-declared lowercase {@code width_bucket} whose Sig resolves
                org.apache.calcite.sql.type.SqlTypeFamily.NUMERIC,
    /**  
                org.apache.calcite.sql.type.SqlTypeFamily.NUMERIC,  
            null,
        assertSame("arg 0 must be the original value operand", value, call.getOperands().get(0));
import org.apache.calcite.sql.type.SqlTypeFamily;  
            OperandTypes.family(SqlTypeFamily.ANY, SqlTypeFamily.NUMERIC, SqlTypeFamily.ANY, SqlTypeFamily.ANY),  
            SqlKind.OTHER_FUNCTION,  
 * compatible open source license.
import org.apache.calcite.jdbc.JavaTypeFactoryImpl;
        RelOptCluster cluster = RelOptCluster.create(planner, rexBuilder);  
        org.apache.calcite.sql.SqlAggFunction agg,  
            agg,  
            "WIDTH_BUCKET",
            false
        RexNode adapted = new WidthBucketAdapter().adapt(original, List.of(), cluster);
            null,
    public void testTimestampPatternMismatchReturnsCallUnchanged() {
        HepPlanner planner = new HepPlanner(new HepProgramBuilder().build());  
    /** Pattern-match miss returns the call unchanged so substrait surfaces its own error. */  
        RexBuilder rexBuilder = new RexBuilder(typeFactory);
 * SPDX-License-Identifier: Apache-2.0
        // PLUS(MULTIPLY(DIVIDE(MINUS(to_unixtime(ts), to_unixtime(min)), stride), stride), to_unixtime(min))
     * The {@code RexOver(MIN)} identity must be reused so substrait CSE can dedup it.  
        RexNode max = rexBuilder.makeInputRef(doubleNullable, 3);
            SqlKind.OTHER_FUNCTION,
        RexNode binsLit = rexBuilder.makeLiteral(20, typeFactory.createSqlType(SqlTypeName.INTEGER), false);
            SqlFunctionCategory.USER_DEFINED_FUNCTION
     * {@link SpanBucketAdapterTests#testAdaptedCallPreservesOriginalReturnType}.
                + "otherwise the enclosing Project.rowType assertion fails in fragment conversion",  
        assertEquals(SqlKind.PLUS, plus.getKind());  
        RexNode value = rexBuilder.makeInputRef(doubleNullable, 0);
 *
        RelDataType varcharNullable = typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.VARCHAR), true);
        assertEquals(SqlKind.CAST, outerCast.getKind());  
import org.apache.calcite.rex.RexBuilder;
        HepPlanner planner = new HepPlanner(new HepProgramBuilder().build());  
 * {@code WIDTH_BUCKET(value, num_bins, data_range, max_value)} rewritten  
        assertSame(original, new WidthBucketAdapter().adapt(original, List.of(), cluster));
    }
            RexWindowBounds.UNBOUNDED_PRECEDING,
        RexNode rangeExpr = rexBuilder.makeCall(timestampNullable, SqlStdOperatorTable.MINUS, List.of(maxOver, minOver));
            ),
        RexCall toDoubleCast = (RexCall) fromUnixtimeCall.getOperands().get(0);  
    }
        RelDataTypeFactory typeFactory = new JavaTypeFactoryImpl();  
import org.apache.calcite.sql.type.SqlTypeName;
public class WidthBucketAdapterTests extends OpenSearchTestCase {
        assertEquals(
            List.of(),
        RexNode ts = rexBuilder.makeInputRef(timestampNullable, 0);
import org.apache.calcite.sql.SqlFunction;  
        RexBuilder rexBuilder = new RexBuilder(typeFactory);
        RexNode range = rexBuilder.makeInputRef(doubleNullable, 2);  
            OperandTypes.family(
        RelDataType returnType
        RexBuilder rexBuilder = new RexBuilder(typeFactory);  
            null,
                org.apache.calcite.sql.type.SqlTypeFamily.NUMERIC,
        SqlFunction widthBucketOp = new SqlFunction(  
        );
            RexWindowBounds.UNBOUNDED_FOLLOWING,
        SqlFunction widthBucketOp = new SqlFunction(
        RelDataType intNullable = typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.INTEGER), true);
        assertEquals(SqlKind.TIMES, multiply.getKind());
    public void testAdaptedCallPreservesOriginalReturnType() {  
        RexCall fromUnixtimeCall = (RexCall) outerCast.getOperands().get(0);  
                org.apache.calcite.sql.type.SqlTypeFamily.NUMERIC,
        RelDataType timestampNullable = typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.TIMESTAMP), true);
    }
        // Build WIDTH_BUCKET(ts, 20, range_ref, max_ref) — operands 2/3 are plain InputRefs,
            com.google.common.collect.ImmutableList.of(),  
        RexNode binsLit = rexBuilder.makeLiteral(20, typeFactory.createSqlType(SqlTypeName.INTEGER), false);
    }  
import org.apache.calcite.sql.SqlKind;
            "WIDTH_BUCKET",
        RexCall plus = (RexCall) toDoubleCast.getOperands().get(0);
import org.apache.calcite.rel.type.RelDataTypeFactory;  
            OperandTypes.family(SqlTypeFamily.ANY, SqlTypeFamily.NUMERIC, SqlTypeFamily.ANY, SqlTypeFamily.ANY),
        RexNode arg,
            ReturnTypes.explicit(varchar2000Nullable),
            false,
        );  
            "WIDTH_BUCKET",
        assertSame(minOver, outerMinUnixtime.getOperands().get(0));
        RexNode maxOver = makeOverEmpty(rexBuilder, SqlStdOperatorTable.MAX, ts, timestampNullable);  
                org.apache.calcite.sql.type.SqlTypeFamily.NUMERIC,  
            true,
 */  
        RelDataTypeFactory typeFactory = new JavaTypeFactoryImpl();
        RelDataType timestampNullable = typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.TIMESTAMP), true);
        assertSame("arg 2 must be the original data_range operand", range, call.getOperands().get(2));
            false,  
     */
        assertEquals(SqlKind.DIVIDE, stride.getKind());
        RelDataTypeFactory typeFactory = new JavaTypeFactoryImpl();
        RexCall stride = (RexCall) multiply.getOperands().get(1);  
        );  
        HepPlanner planner = new HepPlanner(new HepProgramBuilder().build());
        RelDataType varchar2000Nullable = typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.VARCHAR, 2000), true);
            WidthBucketAdapter.LOCAL_WIDTH_BUCKET_OP,
        assertEquals(20L, ((Number) ((RexLiteral) stride.getOperands().get(1)).getValue()).longValue());  
        assertSame("arg 1 must be the original num_bins operand", bins, call.getOperands().get(1));  
     * The adapter MUST preserve the original call's {@link RelDataType}. PPL's  
        RelOptCluster cluster = RelOptCluster.create(planner, rexBuilder);
        RelDataType varchar2000Nullable = typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.VARCHAR, 2000), true);  
        RelOptCluster cluster = RelOptCluster.create(planner, rexBuilder);
import org.apache.calcite.rex.RexWindowBounds;
        RexCall outerCast = (RexCall) new WidthBucketAdapter().adapt(original, List.of(), cluster);
            adapted.getType()
        );  
import org.apache.calcite.plan.RelOptCluster;
     */
 * this file be licensed under the Apache-2.0 license or a
import org.apache.calcite.sql.type.OperandTypes;
        RelDataType intNullable = typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.INTEGER), true);
        RexNode rangeRef = rexBuilder.makeInputRef(timestampNullable, 1);  
            SqlFunctionCategory.USER_DEFINED_FUNCTION
    public void testWidthBucketRewritesTimestampToDataAwareBucket() {
            ),
            SqlFunctionCategory.USER_DEFINED_FUNCTION  
     * adapted operator's inferred type must not drift, or the enclosing Project's
                org.apache.calcite.sql.type.SqlTypeFamily.NUMERIC  
 * Same shape as {@link SpanBucketAdapterTests}: PPL-emitted uppercase
        assertSame(
        RexNode value = rexBuilder.makeInputRef(doubleNullable, 0);
        RexNode maxRef = rexBuilder.makeInputRef(timestampNullable, 2);
        // CSE prerequisite: origin's to_unixtime arg is the same RexOver(MIN) used in stride math.
            true,
import java.util.List;
        return rexBuilder.makeOver(
import org.apache.calcite.rex.RexCall;
 * Unit tests for {@link WidthBucketAdapter} — pure rename cat-4 adapter.
            "adapted call must target the locally-declared width_bucket operator",  
     * cached rowType mismatches. Regression guard consistent with  
        );
import org.apache.calcite.sql.SqlFunctionCategory;
        RelDataType doubleNullable = typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.DOUBLE), true);  
     * / stride) * stride + to_unixtime(min))} with {@code stride = (max - min) / N}.
        RexBuilder rexBuilder = new RexBuilder(typeFactory);
import org.apache.calcite.sql.fun.SqlStdOperatorTable;  
        RexNode minOver = makeOverEmpty(rexBuilder, SqlStdOperatorTable.MIN, ts, timestampNullable);
        RexNode range = rexBuilder.makeInputRef(doubleNullable, 2);  
        RexCall original = (RexCall) rexBuilder.makeCall(widthBucketOp, List.of(value, bins, range, max));
        );  
        assertEquals(SqlKind.MINUS, ((RexCall) stride.getOperands().get(0)).getKind());
        RelOptCluster cluster = RelOptCluster.create(planner, rexBuilder);
            "WIDTH_BUCKET",
        assertTrue("adapted node must be a RexCall, got " + adapted.getClass(), adapted instanceof RexCall);  
    public void testWidthBucketRewritesToLocalOperator() {  
        RelDataTypeFactory typeFactory = new JavaTypeFactoryImpl();
        assertEquals(SqlKind.CAST, toDoubleCast.getKind());
import org.apache.calcite.rel.type.RelDataType;
        assertSame("arg 3 must be the original max_value operand", max, call.getOperands().get(3));
        RexCall outerMinUnixtime = (RexCall) plus.getOperands().get(1);
            SqlKind.OTHER_FUNCTION,
        assertEquals(original.getType(), outerCast.getType());
        RexCall original = (RexCall) rexBuilder.makeCall(widthBucketOp, List.of(value, bins, range, max));
        assertEquals(varchar2000Nullable, original.getType());  
package org.opensearch.be.datafusion;
        assertSame(UnixTimestampAdapter.LOCAL_TO_UNIXTIME_OP, outerMinUnixtime.getOperator());  
            ReturnTypes.explicit(varcharNullable),  
    /**
        SqlFunction widthBucketOp = new SqlFunction(  
/**  
import org.apache.calcite.sql.type.ReturnTypes;
