import org.apache.calcite.sql.type.OperandTypes;
import org.apache.calcite.rex.RexNode;
        RexNode count = rexBuilder.makeBigintLiteral(BigDecimal.valueOf(1L));
        RexNode unit = rexBuilder.makeLiteral("YEAR");
import org.apache.calcite.rex.RexCall;
        assertEquals("||", concat.getOperator().getName());
        RexNode adapted = adapter.adapt(original, List.of(), cluster);
import org.apache.calcite.sql.fun.SqlStdOperatorTable;  
     * the calendar-exact fold path which returns a TIMESTAMP literal directly.
 * The OpenSearch Contributors require contributions made to  
    private static final SqlFunction TIMESTAMPADD_OP = new SqlFunction(
    private final TimestampAddAdapter adapter = new TimestampAddAdapter();  
        RexNode adapted = adapter.adapt(original, List.of(), cluster);
 */  
        RexCall original = (RexCall) rexBuilder.makeCall(TIMESTAMPADD_OP, List.of(unit, count, ts));  
import org.apache.calcite.sql.SqlKind;
        RexNode ts = rexBuilder.makeLiteral("2001-03-06 00:00:00");
import org.apache.calcite.sql.SqlFunctionCategory;
import org.opensearch.test.OpenSearchTestCase;
        RexNode unit = rexBuilder.makeLiteral("HOUR");
    public void testYearUnitLowersToMonthInterval() {
        ReturnTypes.TIMESTAMP,
    }  
    private final RelDataTypeFactory typeFactory = new JavaTypeFactoryImpl();  
 * compatible open source license.
        RexCall original = (RexCall) rexBuilder.makeCall(TIMESTAMPADD_OP, List.of(unit, count, tsCol));  
/** Covers {@link TimestampAddAdapter}: standalone TIMESTAMPADD lowers to DATETIME_PLUS with a base-unit interval; TIME first arg gets today-anchored. */  
        RexCall original = (RexCall) rexBuilder.makeCall(TIMESTAMPADD_OP, List.of(unit, count, tsCol));
    }
        OperandTypes.VARIADIC,
    /**
        // Walk down: outer DATETIME_PLUS (or CAST wrap) → first operand is CAST(CONCAT(...) AS TIMESTAMP).  
     * Uses a column ref (not a literal) to exercise the interval path; literal-literal hits
        RelDataType timeType = typeFactory.createSqlType(SqlTypeName.TIME);  
        null,  
            : (RexCall) adapted;  
import java.math.BigDecimal;  
    /** TIMESTAMPADD(HOUR, 5, TIME-col) anchors TIME to today UTC via CONCAT before the interval add. */
/*  
        RexCall outer = adapted instanceof RexCall && ((RexCall) adapted).getKind() == SqlKind.CAST
    private final RexBuilder rexBuilder = new RexBuilder(typeFactory);
        RexNode count = rexBuilder.makeBigintLiteral(BigDecimal.valueOf(15L));  
    public void testUnknownUnitPassesThrough() {
}  
    public void testTimeOperandAnchoredToToday() {  
        RexNode tsCol = rexBuilder.makeInputRef(timestampType, 0);
import org.apache.calcite.rel.type.RelDataType;
     */  
     * TIMESTAMPADD(YEAR, 15, ts-col) → DATETIME_PLUS(CAST AS TIMESTAMP, INTERVAL 180 MONTH).  
import org.apache.calcite.rex.RexBuilder;  
        "TIMESTAMPADD",  
    private final RelOptCluster cluster = RelOptCluster.create(new VolcanoPlanner(), rexBuilder);
    /** Unrecognised unit keeps the original RexCall (substrait surfaces the failure). */
        RexCall concat = (RexCall) castNode.getOperands().get(0);  
    );  
        RexNode tsCol = rexBuilder.makeInputRef(timeType, 0);
            : (RexCall) adapted;
        RexNode count = rexBuilder.makeBigintLiteral(BigDecimal.valueOf(5L));
        RelDataType timestampType = typeFactory.createSqlType(SqlTypeName.TIMESTAMP);
        assertSame(original, adapted);
        RexCall outer = adapted instanceof RexCall && ((RexCall) adapted).getKind() == SqlKind.CAST
            ? (RexCall) ((RexCall) adapted).getOperands().get(0)  
import org.apache.calcite.rel.type.RelDataTypeFactory;
package org.opensearch.be.datafusion;
import org.apache.calcite.jdbc.JavaTypeFactoryImpl;
 * SPDX-License-Identifier: Apache-2.0
        assertSame(SqlStdOperatorTable.DATETIME_PLUS, outer.getOperator());
public class TimestampAddAdapterTests extends OpenSearchTestCase {
        SqlKind.OTHER_FUNCTION,
        RexCall castNode = (RexCall) outer.getOperands().get(0);
        RexNode adapted = adapter.adapt(original, List.of(), cluster);
    }
import org.apache.calcite.plan.volcano.VolcanoPlanner;  
        assertEquals(SqlKind.CAST, castNode.getKind());
        SqlFunctionCategory.TIMEDATE
 * this file be licensed under the Apache-2.0 license or a
 *
import org.apache.calcite.plan.RelOptCluster;
import org.apache.calcite.sql.type.SqlTypeName;  
import java.util.List;
            ? (RexCall) ((RexCall) adapted).getOperands().get(0)
        RexNode unit = rexBuilder.makeLiteral("FORTNIGHT");  
        // Either DATETIME_PLUS or a CAST wrapping it depending on type matching.
import org.apache.calcite.sql.SqlFunction;  
import org.apache.calcite.sql.type.ReturnTypes;
