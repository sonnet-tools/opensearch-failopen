 * <p>The fixed-second arithmetic path (s/m/h/d/w) is covered by the timechart-route
            ((RexLiteral) call.getOperands().get(0)).getValueAs(String.class)
        RelDataType tsType = rexBuilder.getTypeFactory()
        RexBuilder rexBuilder = new RexBuilder(typeFactory);
    /**
package org.opensearch.be.datafusion;
        RexCall original = makeSpanCall(rexBuilder, tsType, BigDecimal.valueOf(250), "us");  
    }
     *  {@code date_bin("40 milliseconds", @timestamp)}. */  
        RexNode fieldRef = rexBuilder.makeInputRef(tsType, 0);
        RelOptCluster cluster = newCluster();
 * Unit tests for the sub-second multi-unit lowering path in {@link SpanAdapter}.
import org.apache.calcite.rex.RexCall;
     *  to 1 and accidentally hit the date_trunc path. */
        RexNode adapted = new SpanAdapter().adapt(original, List.of(), cluster);
import org.apache.calcite.plan.hep.HepProgramBuilder;
    }
            ReturnTypes.explicit(tsType),  
            OperandTypes.VARIADIC,
 *
            SqlFunctionCategory.USER_DEFINED_FUNCTION  
    }  
        RelDataType tsType = rexBuilder.getTypeFactory()
        RelDataTypeFactory typeFactory = new JavaTypeFactoryImpl();  
    }  
        RelDataTypeFactory typeFactory = new JavaTypeFactoryImpl();  
        assertSame("sub-second multi-unit must lower to LOCAL_DATE_BIN_OP", SpanAdapter.LOCAL_DATE_BIN_OP, call.getOperator());  
        assertSame("fractional interval must fall through unchanged", original, adapted);
import org.apache.calcite.sql.type.ReturnTypes;  
import org.apache.calcite.sql.SqlKind;
        RexNode fractionalInterval = rexBuilder.makeLiteral(new BigDecimal("2.5"), decType);  
        RexBuilder rexBuilder = cluster.getRexBuilder();
        RexCall call = (RexCall) adapted;
    public void testMillisecondMultiUnitRewritesToDateBin() {
        RexNode intervalLit = rexBuilder.makeLiteral(interval, intType);  
import org.apache.calcite.plan.RelOptCluster;
/**
            "SPAN",
import org.opensearch.test.OpenSearchTestCase;
 * SPDX-License-Identifier: Apache-2.0
    public void testFractionalIntervalForSubSecondFallsThrough() {
import org.apache.calcite.sql.SqlFunctionCategory;  
        assertSame(SpanAdapter.LOCAL_DATE_BIN_OP, adapted.getOperator());  
        // Use precision-3 nullable timestamp — distinct from LOCAL_DATE_BIN_OP's  
            "40 milliseconds",
        RelDataType tsType = rexBuilder.getTypeFactory()
     * assertion during fragment conversion. Regression guard mirroring the same check  
        RelOptCluster cluster = newCluster();  
            SqlKind.OTHER_FUNCTION,
        RexNode adapted = new SpanAdapter().adapt(original, List.of(), cluster);
 */  
        RexNode unitLit = rexBuilder.makeLiteral(unit);
 *  
        RelOptCluster cluster = newCluster();
 * end-to-end suite. This class targets the gap that the timechart PR explicitly left
            ReturnTypes.explicit(tsType),  
        RexCall original = makeSpanCall(rexBuilder, tsType, BigDecimal.valueOf(40), "ms");
            null,
            "SPAN",
    public void testSubSecondUnitOneStaysOnDateTruncPath() {
import org.apache.calcite.sql.SqlFunction;
        RelDataTypeFactory typeFactory = rexBuilder.getTypeFactory();
        assertEquals("adapted date_bin call must declare the same type as the original SPAN call", original.getType(), adapted.getType());  
import java.math.BigDecimal;
import org.apache.calcite.rex.RexNode;
        RexCall original = makeSpanCall(rexBuilder, tsType, BigDecimal.ONE, "ms");
        );
        assertEquals(
            .createTypeWithNullability(rexBuilder.getTypeFactory().createSqlType(SqlTypeName.TIMESTAMP, 0), true);  
            .createTypeWithNullability(rexBuilder.getTypeFactory().createSqlType(SqlTypeName.TIMESTAMP, 3), true);  
        assertEquals(tsType, original.getType());  
            "stride must be DataFusion's string-form interval with the count",  
}
 * out — {@code us} and {@code ms} with {@code N > 1} — which is what dashboard logs-tab  
        RelDataType tsType = rexBuilder.getTypeFactory()  
        RexBuilder rexBuilder = cluster.getRexBuilder();
        RexNode fieldRef = rexBuilder.makeInputRef(tsType, 0);
        RexCall original = makeSpanCall(rexBuilder, tsType, BigDecimal.valueOf(40), "ms");
        assertEquals("date_bin takes (stride, source)", 2, call.getOperands().size());
import org.apache.calcite.sql.type.OperandTypes;
 * histogram queries hit when bucket width is sub-second (e.g.
     * The adapted call MUST preserve the original SPAN call's {@link RelDataType}. The  
        assertEquals("250 microseconds", ((RexLiteral) adapted.getOperands().get(0)).getValueAs(String.class));
 * The OpenSearch Contributors require contributions made to  
        RexCall original = (RexCall) rexBuilder.makeCall(spanOp, List.of(fieldRef, fractionalInterval, unitLit));
import org.apache.calcite.jdbc.JavaTypeFactoryImpl;
 * compatible open source license.
     */
            .createTypeWithNullability(rexBuilder.getTypeFactory().createSqlType(SqlTypeName.TIMESTAMP, 0), true);
        RexBuilder rexBuilder = cluster.getRexBuilder();  
    /** N == 1 for sub-second units must NOT take the date_bin path — date_trunc handles it. */
 * this file be licensed under the Apache-2.0 license or a
        return RelOptCluster.create(new HepPlanner(new HepProgramBuilder().build()), rexBuilder);
import org.apache.calcite.sql.type.SqlTypeName;
            SqlFunctionCategory.USER_DEFINED_FUNCTION  
import org.apache.calcite.rel.type.RelDataType;
 */  
 * {@code span(@timestamp, 40ms)}).
        );  
import java.util.List;
    }
     * on {@link SpanBucketAdapterTests#testAdaptedCallPreservesOriginalReturnType}.
            null,
import org.apache.calcite.rex.RexBuilder;
    private static RexCall makeSpanCall(RexBuilder rexBuilder, RelDataType tsType, BigDecimal interval, String unit) {  
        RexNode unitLit = rexBuilder.makeLiteral("ms");
        RelDataType tsType = typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.TIMESTAMP, 0), true);  
import org.apache.calcite.rel.type.RelDataTypeFactory;  
        // ARG1_NULLABLE inferred type if the operand was a different type.
    }  
import org.apache.calcite.rex.RexLiteral;  
        assertEquals("N==1 ms stays on date_trunc (the cheaper path), NOT date_bin", "DATE_TRUNC", adapted.getOperator().getName());
public class SpanAdapterSubSecondTests extends OpenSearchTestCase {
     *  needs a DECIMAL literal type so the fractional value survives; INTEGER would coerce  
/*  
    private static RelOptCluster newCluster() {
    /** Non-integer interval for sub-second units must fall through unchanged. The interval
        assertTrue("adapted node must be a RexCall, got " + adapted.getClass(), adapted instanceof RexCall);
        RexNode adapted = new SpanAdapter().adapt(original, List.of(), cluster);
    /** The dashboard-trigger case: {@code span(@timestamp, 40ms)} lowers to
            OperandTypes.VARIADIC,
        RexBuilder rexBuilder = cluster.getRexBuilder();
        RelDataType decType = typeFactory.createSqlType(SqlTypeName.DECIMAL, 5, 2);
        );
    public void testAdaptedDateBinCallPreservesOriginalReturnType() {  
        RelOptCluster cluster = RelOptCluster.create(new HepPlanner(new HepProgramBuilder().build()), rexBuilder);
import org.apache.calcite.plan.hep.HepPlanner;  
     * enclosing Project caches its rowType from the pre-adaptation expression; any
        RexBuilder rexBuilder = new RexBuilder(typeFactory);
        return (RexCall) rexBuilder.makeCall(spanOp, List.of(fieldRef, intervalLit, unitLit));
        SqlFunction spanOp = new SqlFunction(  
        RexCall adapted = (RexCall) new SpanAdapter().adapt(original, List.of(), cluster);  
    public void testMicrosecondMultiUnitRewritesToDateBin() {  
        RelOptCluster cluster = newCluster();
        RelDataType intType = typeFactory.createSqlType(SqlTypeName.INTEGER);
     * Calcite-inferred-type drift breaks {@code Project.isValid}'s compatibleTypes
        RexCall adapted = (RexCall) new SpanAdapter().adapt(original, List.of(), cluster);
            SqlKind.OTHER_FUNCTION,
    }  
        SqlFunction spanOp = new SqlFunction(  
            .createTypeWithNullability(rexBuilder.getTypeFactory().createSqlType(SqlTypeName.TIMESTAMP, 0), true);
