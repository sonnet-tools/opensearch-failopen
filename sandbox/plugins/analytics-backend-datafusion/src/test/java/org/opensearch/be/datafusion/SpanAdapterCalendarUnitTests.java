        RelDataType tsType = rexBuilder.getTypeFactory()
import java.util.List;
import java.math.BigDecimal;
        RexBuilder rexBuilder = cluster.getRexBuilder();
        RexNode intervalLit = rexBuilder.makeLiteral(interval, intType);  
 * SPDX-License-Identifier: Apache-2.0
        assertEquals("1970-01-01T00:00:00Z", ((RexLiteral) adapted.getOperands().get(2)).getValueAs(String.class));
import org.apache.calcite.sql.type.OperandTypes;
        RexCall adapted = (RexCall) new SpanAdapter().adapt(original, List.of(), cluster);  
 *
        assertSame(SpanAdapter.LOCAL_DATE_BIN_OP, adapted.getOperator());
        RexNode fieldRef = rexBuilder.makeInputRef(tsType, 0);
import org.opensearch.test.OpenSearchTestCase;
    }  
        assertEquals(expectedStride, ((RexLiteral) adapted.getOperands().get(0)).getValueAs(String.class));
            SqlFunctionCategory.USER_DEFINED_FUNCTION  
package org.opensearch.be.datafusion;
import org.apache.calcite.sql.SqlFunction;
            .createTypeWithNullability(rexBuilder.getTypeFactory().createSqlType(SqlTypeName.TIMESTAMP, 0), true);  
        assertCalendarStride(BigDecimal.valueOf(2), "q", "2 quarter");
import org.apache.calcite.plan.hep.HepPlanner;  
    public void testCalendarQuarterUnitRewriteToDateBin() {
import org.apache.calcite.plan.hep.HepProgramBuilder;
    }  
        SqlFunction spanOp = new SqlFunction(  
        RelDataTypeFactory typeFactory = new JavaTypeFactoryImpl();  
import org.apache.calcite.rex.RexCall;
 * this file be licensed under the Apache-2.0 license or a
import org.apache.calcite.rex.RexBuilder;
    private void assertCalendarStride(BigDecimal n, String unit, String expectedStride) {
            "SPAN",
import org.apache.calcite.rex.RexLiteral;  
/*  
public class SpanAdapterCalendarUnitTests extends OpenSearchTestCase {
        RexCall original = makeSpanCall(rexBuilder, tsType, n, unit);
        RexBuilder rexBuilder = new RexBuilder(typeFactory);
 * The OpenSearch Contributors require contributions made to  
import org.apache.calcite.sql.SqlKind;
        RelOptCluster cluster = newCluster();  
import org.apache.calcite.sql.type.SqlTypeName;
import org.apache.calcite.sql.type.ReturnTypes;  
    /** SPAN(ts, 3, 'M') → date_bin("3 month", ts, '1970-01-01T00:00:00Z'). */
import org.apache.calcite.rex.RexNode;
        return (RexCall) rexBuilder.makeCall(spanOp, List.of(fieldRef, intervalLit, unitLit));
            SqlKind.OTHER_FUNCTION,
    }
import org.apache.calcite.sql.SqlFunctionCategory;  
import org.apache.calcite.plan.RelOptCluster;
    }
/** Calendar-unit time spans (M/q/y) lower to {@code date_bin("<N> <unit>", t, '1970-01-01T00:00:00Z')}. */
 * compatible open source license.
        RexNode unitLit = rexBuilder.makeLiteral(unit);
        );
    }  
            null,
    public void testCalendarYearUnitRewriteToDateBin() {
    /** SPAN(ts, 5, 'y') → date_bin("5 year", ts, '1970-01-01T00:00:00Z'). N==1 takes the cheaper date_trunc path. */
import org.apache.calcite.jdbc.JavaTypeFactoryImpl;
    public void testCalendarMonthUnitRewriteToDateBin() {  
import org.apache.calcite.rel.type.RelDataType;
}
 */  
        return RelOptCluster.create(new HepPlanner(new HepProgramBuilder().build()), rexBuilder);
        RelDataType intType = rexBuilder.getTypeFactory().createSqlType(SqlTypeName.INTEGER);
    private static RexCall makeSpanCall(RexBuilder rexBuilder, RelDataType tsType, BigDecimal interval, String unit) {
        assertCalendarStride(BigDecimal.valueOf(3), "M", "3 month");
        assertEquals("calendar-unit date_bin takes (stride, source, origin)", 3, adapted.getOperands().size());  
    }  
            OperandTypes.VARIADIC,
    private static RelOptCluster newCluster() {
    /** SPAN(ts, 2, 'q') → date_bin("2 quarter", ts, '1970-01-01T00:00:00Z'). */  
        assertCalendarStride(BigDecimal.valueOf(5), "y", "5 year");  
            ReturnTypes.explicit(tsType),  
import org.apache.calcite.rel.type.RelDataTypeFactory;  
