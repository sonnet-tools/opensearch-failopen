     * cached rowType mismatches. Regression guard consistent with
        HepPlanner planner = new HepPlanner(new HepProgramBuilder().build());
import org.apache.calcite.plan.hep.HepProgramBuilder;
        );
        RelDataType varchar2000Nullable = typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.VARCHAR, 2000), true);
public class WidthBucketAdapterTests extends OpenSearchTestCase {
import org.apache.calcite.plan.RelOptCluster;
        RexNode ts = rexBuilder.makeInputRef(timestampNullable, 0);
        HepPlanner planner = new HepPlanner(new HepProgramBuilder().build());
        RexBuilder rexBuilder = new RexBuilder(typeFactory);
import org.apache.calcite.plan.hep.HepPlanner;
        RexNode maxOver = makeOverEmpty(rexBuilder, SqlStdOperatorTable.MAX, ts, timestampNullable);
                org.apache.calcite.sql.type.SqlTypeFamily.NUMERIC,
        assertSame(
        RelDataType intNullable = typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.INTEGER), true);
            adapted.getType()
            ),
import org.apache.calcite.rex.RexCall;
 * SPDX-License-Identifier: Apache-2.0
        );
            ),
        SqlFunction widthBucketOp = new SqlFunction(
/*
                org.apache.calcite.sql.type.SqlTypeFamily.NUMERIC
    ) {
    }
        RelOptCluster cluster = RelOptCluster.create(planner, rexBuilder);
    /** Build {@code agg(arg) OVER ()} with the standard unbounded frame. */
import org.apache.calcite.jdbc.JavaTypeFactoryImpl;
        RelDataType returnType
}
import org.apache.calcite.sql.type.ReturnTypes;
        assertEquals("width_bucket(v, bins, range, max) must preserve all 4 operands — no injection", 4, call.getOperands().size());
        RexBuilder rexBuilder = new RexBuilder(typeFactory);
                org.apache.calcite.sql.type.SqlTypeFamily.NUMERIC,
        // not the MINUS(MAX OVER (), MIN OVER ()) / MAX OVER () shape the SQL plugin emits.
import org.apache.calcite.sql.SqlKind;
            OperandTypes.family(SqlTypeFamily.ANY, SqlTypeFamily.NUMERIC, SqlTypeFamily.ANY, SqlTypeFamily.ANY),
        RexBuilder rexBuilder = new RexBuilder(typeFactory);
                org.apache.calcite.sql.type.SqlTypeFamily.NUMERIC,
    /**
        RexNode rangeExpr = rexBuilder.makeCall(timestampNullable, SqlStdOperatorTable.MINUS, List.of(maxOver, minOver));
            WidthBucketAdapter.LOCAL_WIDTH_BUCKET_OP,
            "WIDTH_BUCKET",
            SqlKind.OTHER_FUNCTION,
     * / stride) * stride + to_unixtime(min))} with {@code stride = (max - min) / N}.
        SqlFunction widthBucketOp = new SqlFunction(
        // PLUS(MULTIPLY(DIVIDE(MINUS(to_unixtime(ts), to_unixtime(min)), stride), stride), to_unixtime(min))
        RexNode max = rexBuilder.makeInputRef(doubleNullable, 3);
            OperandTypes.family(SqlTypeFamily.ANY, SqlTypeFamily.NUMERIC, SqlTypeFamily.ANY, SqlTypeFamily.ANY),
                org.apache.calcite.sql.type.SqlTypeFamily.NUMERIC,
        RexCall fromUnixtimeCall = (RexCall) outerCast.getOperands().get(0);
        assertSame(UnixTimestampAdapter.LOCAL_TO_UNIXTIME_OP, outerMinUnixtime.getOperator());
        assertEquals(SqlKind.DIVIDE, stride.getKind());
        assertSame(minOver, outerMinUnixtime.getOperands().get(0));
        RexNode value = rexBuilder.makeInputRef(doubleNullable, 0);
            "WIDTH_BUCKET",
            com.google.common.collect.ImmutableList.of(),
            ReturnTypes.explicit(varchar2000Nullable),
        assertEquals(SqlTypeName.DOUBLE, toDoubleCast.getType().getSqlTypeName());
    public void testTimestampPatternMismatchReturnsCallUnchanged() {
import java.util.List;
import org.apache.calcite.sql.type.SqlTypeFamily;
            ReturnTypes.explicit(varchar2000Nullable),
        RelOptCluster cluster = RelOptCluster.create(planner, rexBuilder);
            null,
import org.apache.calcite.rel.type.RelDataTypeFactory;
            SqlKind.OTHER_FUNCTION,
import org.apache.calcite.rex.RexNode;
        );
        RexCall multiply = (RexCall) plus.getOperands().get(0);
        RexNode adapted = new WidthBucketAdapter().adapt(original, List.of(), cluster);
     * The adapter MUST preserve the original call's {@link RelDataType}. PPL's
        RexBuilder rexBuilder = new RexBuilder(typeFactory);
 * {@code WIDTH_BUCKET(value, num_bins, data_range, max_value)} rewritten
                org.apache.calcite.sql.type.SqlTypeFamily.NUMERIC,
    }
            true,
                org.apache.calcite.sql.type.SqlTypeFamily.NUMERIC
        RexNode max = rexBuilder.makeInputRef(doubleNullable, 3);
     * WIDTH_BUCKET is registered with {@code VARCHAR(2000) FORCE_NULLABLE}; the
        RexNode range = rexBuilder.makeInputRef(doubleNullable, 2);
        RelDataTypeFactory typeFactory = new JavaTypeFactoryImpl();
        RelOptCluster cluster = RelOptCluster.create(planner, rexBuilder);
        RexNode minOver = makeOverEmpty(rexBuilder, SqlStdOperatorTable.MIN, ts, timestampNullable);
        assertSame(RustUdfDateTimeAdapters.LOCAL_FROM_UNIXTIME_OP, fromUnixtimeCall.getOperator());
        assertEquals(SqlKind.TIMES, multiply.getKind());
        HepPlanner planner = new HepPlanner(new HepProgramBuilder().build());
            SqlKind.OTHER_FUNCTION,
        assertEquals(SqlKind.PLUS, plus.getKind());
 */
            OperandTypes.family(
        RexCall stride = (RexCall) multiply.getOperands().get(1);
        assertSame("arg 3 must be the original max_value operand", max, call.getOperands().get(3));
            call.getOperator()
    private static RexNode makeOverEmpty(
        assertEquals(SqlKind.MINUS, ((RexCall) stride.getOperands().get(0)).getKind());
        RelDataType intNullable = typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.INTEGER), true);
        );
     * adapted operator's inferred type must not drift, or the enclosing Project's
     */
        assertSame(original, new WidthBucketAdapter().adapt(original, List.of(), cluster));
    /**
            agg,
import org.apache.calcite.sql.type.OperandTypes;
            SqlFunctionCategory.USER_DEFINED_FUNCTION
            List.of(),
import org.apache.calcite.sql.SqlFunction;
            null,
        RexNode bins = rexBuilder.makeInputRef(intNullable, 1);
        RexCall outerCast = (RexCall) new WidthBucketAdapter().adapt(original, List.of(), cluster);
    public void testWidthBucketRewritesToLocalOperator() {
            ReturnTypes.explicit(varcharNullable),
import org.opensearch.test.OpenSearchTestCase;
            null,
        RelDataType doubleNullable = typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.DOUBLE), true);
            SqlFunctionCategory.USER_DEFINED_FUNCTION
 * to the Rust UDF.
import org.apache.calcite.sql.fun.SqlStdOperatorTable;
        RelDataTypeFactory typeFactory = new JavaTypeFactoryImpl();
        org.apache.calcite.sql.SqlAggFunction agg,
    }
import org.apache.calcite.sql.SqlFunctionCategory;
        RelDataTypeFactory typeFactory = new JavaTypeFactoryImpl();
import org.apache.calcite.rex.RexBuilder;
            OperandTypes.family(
        RelDataType varchar2000Nullable = typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.VARCHAR, 2000), true);
/**
        );
            original.getType(),
        RexBuilder rexBuilder,
        RexCall original = (RexCall) rexBuilder.makeCall(widthBucketOp, List.of(value, bins, range, max));
        assertEquals(
package org.opensearch.be.datafusion;
            RexWindowBounds.UNBOUNDED_FOLLOWING,
        SqlFunction widthBucketOp = new SqlFunction(
            RexWindowBounds.UNBOUNDED_PRECEDING,
            false
            SqlFunctionCategory.USER_DEFINED_FUNCTION
        RexNode range = rexBuilder.makeInputRef(doubleNullable, 2);
        );
        RexCall original = (RexCall) rexBuilder.makeCall(widthBucketOp, List.of(value, bins, range, max));
import org.apache.calcite.rex.RexLiteral;
        RexCall outerMinUnixtime = (RexCall) plus.getOperands().get(1);
            "adapted call's return type must equal the original call's return type, "
     * {@link SpanBucketAdapterTests#testAdaptedCallPreservesOriginalReturnType}.
        assertSame("arg 1 must be the original num_bins operand", bins, call.getOperands().get(1));
            List.of(arg),
     */
    }
        RexNode maxRef = rexBuilder.makeInputRef(timestampNullable, 2);
                + "otherwise the enclosing Project.rowType assertion fails in fragment conversion",
        RexNode adapted = new WidthBucketAdapter().adapt(original, List.of(), cluster);
        RexNode value = rexBuilder.makeInputRef(doubleNullable, 0);
            false,
        RexNode arg,
import org.apache.calcite.sql.type.SqlTypeName;
 * to the locally-declared lowercase {@code width_bucket} whose Sig resolves
 *
        RelOptCluster cluster = RelOptCluster.create(planner, rexBuilder);
        RexCall toDoubleCast = (RexCall) fromUnixtimeCall.getOperands().get(0);
        RexNode binsLit = rexBuilder.makeLiteral(20, typeFactory.createSqlType(SqlTypeName.INTEGER), false);
        // CSE prerequisite: origin's to_unixtime arg is the same RexOver(MIN) used in stride math.
        RexCall original = (RexCall) rexBuilder.makeCall(widthBucketOp, List.of(ts, binsLit, rangeExpr, maxOver));
        assertTrue("adapted node must be a RexCall, got " + adapted.getClass(), adapted instanceof RexCall);
 */
        RexNode ts = rexBuilder.makeInputRef(timestampNullable, 0);
        );
 * compatible open source license.
            ReturnTypes.explicit(varchar2000Nullable),
            "adapted call must target the locally-declared width_bucket operator",
        RexNode bins = rexBuilder.makeInputRef(intNullable, 1);
        RelDataType varcharNullable = typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.VARCHAR), true);
import org.apache.calcite.rel.type.RelDataType;
 * this file be licensed under the Apache-2.0 license or a
        RelDataType doubleNullable = typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.DOUBLE), true);
        assertEquals(SqlKind.CAST, toDoubleCast.getKind());
        assertSame("arg 2 must be the original data_range operand", range, call.getOperands().get(2));
    public void testWidthBucketRewritesTimestampToDataAwareBucket() {
            SqlFunctionCategory.USER_DEFINED_FUNCTION
        HepPlanner planner = new HepPlanner(new HepProgramBuilder().build());
        assertEquals(original.getType(), outerCast.getType());
        RexCall original = (RexCall) rexBuilder.makeCall(widthBucketOp, List.of(ts, binsLit, rangeRef, maxRef));
            org.apache.calcite.rex.RexWindowExclusion.EXCLUDE_NO_OTHER,
        RexNode rangeRef = rexBuilder.makeInputRef(timestampNullable, 1);
    public void testAdaptedCallPreservesOriginalReturnType() {
        RelDataTypeFactory typeFactory = new JavaTypeFactoryImpl();
        RelDataType varchar2000Nullable = typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.VARCHAR, 2000), true);
            "WIDTH_BUCKET",
import org.apache.calcite.rex.RexWindowBounds;
        assertEquals(SqlKind.CAST, outerCast.getKind());
            false,
        RexNode binsLit = rexBuilder.makeLiteral(20, typeFactory.createSqlType(SqlTypeName.INTEGER), false);
        SqlFunction widthBucketOp = new SqlFunction(
            true,
    }
        assertEquals(varchar2000Nullable, original.getType());
        return rexBuilder.makeOver(
                org.apache.calcite.sql.type.SqlTypeFamily.NUMERIC,
        RelDataType timestampNullable = typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.TIMESTAMP), true);
 * Unit tests for {@link WidthBucketAdapter} — pure rename cat-4 adapter.
     * Timestamp branch builds {@code from_unixtime(((to_unixtime(ts) - to_unixtime(min))
 * Same shape as {@link SpanBucketAdapterTests}: PPL-emitted uppercase
 * The OpenSearch Contributors require contributions made to
     * The {@code RexOver(MIN)} identity must be reused so substrait CSE can dedup it.
            returnType,
            null,
            "WIDTH_BUCKET",
        RelDataType timestampNullable = typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.TIMESTAMP), true);
        assertEquals(20L, ((Number) ((RexLiteral) stride.getOperands().get(1)).getValue()).longValue());
        RexCall plus = (RexCall) toDoubleCast.getOperands().get(0);
        RexCall call = (RexCall) adapted;
        assertSame("arg 0 must be the original value operand", value, call.getOperands().get(0));
            SqlKind.OTHER_FUNCTION,
    /** Pattern-match miss returns the call unchanged so substrait surfaces its own error. */
        // Build WIDTH_BUCKET(ts, 20, range_ref, max_ref) — operands 2/3 are plain InputRefs,
