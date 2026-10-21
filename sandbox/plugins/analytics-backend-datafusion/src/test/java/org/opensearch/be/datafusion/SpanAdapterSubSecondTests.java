        return (RexCall) rexBuilder.makeCall(spanOp, List.of(fieldRef, intervalLit, unitLit));
            "SPAN",
 * Unit tests for the sub-second multi-unit lowering path in {@link SpanAdapter}.
 *
import org.opensearch.test.OpenSearchTestCase;
            .createTypeWithNullability(rexBuilder.getTypeFactory().createSqlType(SqlTypeName.TIMESTAMP, 0), true);
        SqlFunction spanOp = new SqlFunction(
        RexNode adapted = new SpanAdapter().adapt(original, List.of(), cluster);
        RelDataTypeFactory typeFactory = new JavaTypeFactoryImpl();
 * histogram queries hit when bucket width is sub-second (e.g.
            "SPAN",
 */
        assertSame(SpanAdapter.LOCAL_DATE_BIN_OP, adapted.getOperator());
        RexNode fractionalInterval = rexBuilder.makeLiteral(new BigDecimal("2.5"), decType);
            OperandTypes.VARIADIC,
import org.apache.calcite.rel.type.RelDataTypeFactory;
import org.apache.calcite.plan.hep.HepProgramBuilder;
    public void testFractionalIntervalForSubSecondFallsThrough() {
        assertEquals("adapted date_bin call must declare the same type as the original SPAN call", original.getType(), adapted.getType());
import org.apache.calcite.sql.SqlFunction;
        RexCall adapted = (RexCall) new SpanAdapter().adapt(original, List.of(), cluster);
            null,
        RelOptCluster cluster = newCluster();
        RexBuilder rexBuilder = cluster.getRexBuilder();
/*
import org.apache.calcite.rex.RexNode;
    }
        );
    /** Non-integer interval for sub-second units must fall through unchanged. The interval
        RexCall original = makeSpanCall(rexBuilder, tsType, BigDecimal.valueOf(40), "ms");
        RelDataType tsType = rexBuilder.getTypeFactory()
        RexCall adapted = (RexCall) new SpanAdapter().adapt(original, List.of(), cluster);
            ((RexLiteral) call.getOperands().get(0)).getValueAs(String.class)
        assertEquals(
        RelOptCluster cluster = newCluster();
        assertEquals(tsType, original.getType());
        RexBuilder rexBuilder = cluster.getRexBuilder();
public class SpanAdapterSubSecondTests extends OpenSearchTestCase {
        RexCall original = makeSpanCall(rexBuilder, tsType, BigDecimal.valueOf(250), "us");
    private static RelOptCluster newCluster() {
        RexCall call = (RexCall) adapted;
            "40 milliseconds",
            .createTypeWithNullability(rexBuilder.getTypeFactory().createSqlType(SqlTypeName.TIMESTAMP, 0), true);
        // ARG1_NULLABLE inferred type if the operand was a different type.
        assertEquals("250 microseconds", ((RexLiteral) adapted.getOperands().get(0)).getValueAs(String.class));
        RelOptCluster cluster = RelOptCluster.create(new HepPlanner(new HepProgramBuilder().build()), rexBuilder);
            "stride must be DataFusion's string-form interval with the count",
    /**
            ReturnTypes.explicit(tsType),
    }
        RexNode fieldRef = rexBuilder.makeInputRef(tsType, 0);
        // Use precision-3 nullable timestamp — distinct from LOCAL_DATE_BIN_OP's
        RelDataType tsType = rexBuilder.getTypeFactory()
        RexNode adapted = new SpanAdapter().adapt(original, List.of(), cluster);
            SqlKind.OTHER_FUNCTION,
    /** The dashboard-trigger case: {@code span(@timestamp, 40ms)} lowers to
        RelDataType tsType = rexBuilder.getTypeFactory()
        RexNode fieldRef = rexBuilder.makeInputRef(tsType, 0);
import org.apache.calcite.plan.RelOptCluster;
        );
import org.apache.calcite.sql.SqlFunctionCategory;
import org.apache.calcite.rel.type.RelDataType;
        RelDataType decType = typeFactory.createSqlType(SqlTypeName.DECIMAL, 5, 2);
        RexNode intervalLit = rexBuilder.makeLiteral(interval, intType);
        RexCall original = makeSpanCall(rexBuilder, tsType, BigDecimal.valueOf(40), "ms");
            SqlFunctionCategory.USER_DEFINED_FUNCTION
        assertTrue("adapted node must be a RexCall, got " + adapted.getClass(), adapted instanceof RexCall);
     * on {@link SpanBucketAdapterTests#testAdaptedCallPreservesOriginalReturnType}.
/**
    public void testMicrosecondMultiUnitRewritesToDateBin() {
 * out — {@code us} and {@code ms} with {@code N > 1} — which is what dashboard logs-tab
    private static RexCall makeSpanCall(RexBuilder rexBuilder, RelDataType tsType, BigDecimal interval, String unit) {
            SqlFunctionCategory.USER_DEFINED_FUNCTION
        RelDataTypeFactory typeFactory = rexBuilder.getTypeFactory();
        assertSame("sub-second multi-unit must lower to LOCAL_DATE_BIN_OP", SpanAdapter.LOCAL_DATE_BIN_OP, call.getOperator());
        RelDataType intType = typeFactory.createSqlType(SqlTypeName.INTEGER);
     *  {@code date_bin("40 milliseconds", @timestamp)}. */
 * <p>The fixed-second arithmetic path (s/m/h/d/w) is covered by the timechart-route
 * SPDX-License-Identifier: Apache-2.0
        RexBuilder rexBuilder = cluster.getRexBuilder();
import java.math.BigDecimal;
            OperandTypes.VARIADIC,
import org.apache.calcite.sql.type.SqlTypeName;
 */
     * Calcite-inferred-type drift breaks {@code Project.isValid}'s compatibleTypes
 * this file be licensed under the Apache-2.0 license or a
        );
    }
        RelOptCluster cluster = newCluster();
    }
    /** N == 1 for sub-second units must NOT take the date_bin path — date_trunc handles it. */
 * end-to-end suite. This class targets the gap that the timechart PR explicitly left
     */
        RexNode unitLit = rexBuilder.makeLiteral("ms");
import org.apache.calcite.sql.SqlKind;
     *  needs a DECIMAL literal type so the fractional value survives; INTEGER would coerce
    }
import org.apache.calcite.rex.RexBuilder;
        RelDataTypeFactory typeFactory = new JavaTypeFactoryImpl();
        return RelOptCluster.create(new HepPlanner(new HepProgramBuilder().build()), rexBuilder);
import org.apache.calcite.sql.type.ReturnTypes;
     * The adapted call MUST preserve the original SPAN call's {@link RelDataType}. The
import org.apache.calcite.plan.hep.HepPlanner;
 * compatible open source license.
import org.apache.calcite.rex.RexLiteral;
        RexCall original = (RexCall) rexBuilder.makeCall(spanOp, List.of(fieldRef, fractionalInterval, unitLit));
        RexNode adapted = new SpanAdapter().adapt(original, List.of(), cluster);
        RelOptCluster cluster = newCluster();
     * enclosing Project caches its rowType from the pre-adaptation expression; any
    public void testMillisecondMultiUnitRewritesToDateBin() {
        RelDataType tsType = rexBuilder.getTypeFactory()
        SqlFunction spanOp = new SqlFunction(
import org.apache.calcite.rex.RexCall;
    public void testSubSecondUnitOneStaysOnDateTruncPath() {
        RexCall original = makeSpanCall(rexBuilder, tsType, BigDecimal.ONE, "ms");
        RexBuilder rexBuilder = cluster.getRexBuilder();
        RexBuilder rexBuilder = new RexBuilder(typeFactory);
        assertEquals("N==1 ms stays on date_trunc (the cheaper path), NOT date_bin", "DATE_TRUNC", adapted.getOperator().getName());
            SqlKind.OTHER_FUNCTION,
import org.apache.calcite.sql.type.OperandTypes;
 * {@code span(@timestamp, 40ms)}).
        RexBuilder rexBuilder = new RexBuilder(typeFactory);
        assertEquals("date_bin takes (stride, source)", 2, call.getOperands().size());
    }
     *  to 1 and accidentally hit the date_trunc path. */
        assertSame("fractional interval must fall through unchanged", original, adapted);
package org.opensearch.be.datafusion;
            ReturnTypes.explicit(tsType),
     * assertion during fragment conversion. Regression guard mirroring the same check
    }
        RelDataType tsType = typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.TIMESTAMP, 0), true);
            null,
import java.util.List;
}
            .createTypeWithNullability(rexBuilder.getTypeFactory().createSqlType(SqlTypeName.TIMESTAMP, 3), true);
import org.apache.calcite.jdbc.JavaTypeFactoryImpl;
    public void testAdaptedDateBinCallPreservesOriginalReturnType() {
 *
 * The OpenSearch Contributors require contributions made to
            .createTypeWithNullability(rexBuilder.getTypeFactory().createSqlType(SqlTypeName.TIMESTAMP, 0), true);
        RexNode unitLit = rexBuilder.makeLiteral(unit);
