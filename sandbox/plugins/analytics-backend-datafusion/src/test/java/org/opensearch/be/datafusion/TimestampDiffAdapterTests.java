        assertEquals(BigDecimal.valueOf(expectedDivisor), divisor.getValue());
    /** Build TIMESTAMPDIFF(unit, t1, t2) on TIMESTAMP columns and assert the divisor of the inner DIVIDE. */  
import org.apache.calcite.rel.type.RelDataType;
        assertStandaloneDivisor("YEAR", 365L * 86_400L);  
    /** Variable MONTH out-unit uses 30-day approximation: divisor = 30 * 86400. */
        RexCall divide = (RexCall) outerCast.getOperands().get(0);
    }  
import org.apache.calcite.sql.type.SqlTypeName;
    private static final SqlFunction TIMESTAMPDIFF_OP = new SqlFunction(  
    public void testMonthUnitUsesThirtyDayApproximation() {  
        RexNode adapted = adapter.adapt(original, List.of(), cluster);
    }
public class TimestampDiffAdapterTests extends OpenSearchTestCase {
        "TIMESTAMPDIFF",
import org.apache.calcite.sql.SqlFunctionCategory;
import org.opensearch.test.OpenSearchTestCase;
import org.apache.calcite.sql.SqlKind;  
    private final RelOptCluster cluster = RelOptCluster.create(new VolcanoPlanner(), rexBuilder);  
package org.opensearch.be.datafusion;
        SqlKind.OTHER_FUNCTION,
    /** Variable YEAR out-unit uses 365-day approximation: divisor = 365 * 86400. */
        RelDataType tsType = typeFactory.createSqlType(SqlTypeName.TIMESTAMP);
import org.apache.calcite.sql.type.OperandTypes;
 */  
        assertStandaloneDivisor("DAY", 86_400L);
        RexNode unitLit = rexBuilder.makeLiteral(unit);  
 * compatible open source license.
        RexCall original = (RexCall) rexBuilder.makeCall(TIMESTAMPDIFF_OP, List.of(unitLit, t1, t2));  
 * this file be licensed under the Apache-2.0 license or a
    public void testDayUnitDivisorIs86400() {
import java.math.BigDecimal;
        RexLiteral divisor = (RexLiteral) divide.getOperands().get(1);  
import org.apache.calcite.rel.type.RelDataTypeFactory;
    private final RelDataTypeFactory typeFactory = new JavaTypeFactoryImpl();
import org.apache.calcite.sql.type.ReturnTypes;  
import org.apache.calcite.jdbc.JavaTypeFactoryImpl;
import org.apache.calcite.rex.RexBuilder;  
}  
        ReturnTypes.BIGINT_NULLABLE,  
/*  
        RexNode t1 = rexBuilder.makeInputRef(tsType, 0);
import org.apache.calcite.rex.RexNode;  
import org.apache.calcite.rex.RexCall;
import org.apache.calcite.plan.volcano.VolcanoPlanner;  
import org.apache.calcite.rex.RexLiteral;
        SqlFunctionCategory.TIMEDATE  
import java.util.List;
    private final RexBuilder rexBuilder = new RexBuilder(typeFactory);
    );
import org.apache.calcite.sql.SqlFunction;
        assertEquals(SqlKind.CAST, outerCast.getKind());  
    }
    private final TimestampDiffAdapter adapter = new TimestampDiffAdapter();
        assertSame(SqlStdOperatorTable.DIVIDE, divide.getOperator());
 * SPDX-License-Identifier: Apache-2.0
        RexNode t2 = rexBuilder.makeInputRef(tsType, 1);
        null,
        assertStandaloneDivisor("MONTH", 30L * 86_400L);
 * The OpenSearch Contributors require contributions made to  
import org.apache.calcite.sql.fun.SqlStdOperatorTable;
        RexCall outerCast = (RexCall) adapted;
        // Outer is CAST(scaled AS BIGINT); peel one level.
        OperandTypes.VARIADIC,
    public void testYearUnitUsesThreeSixtyFiveDayApproximation() {
    }
/** Covers {@link TimestampDiffAdapter} standalone shape: {@code (to_unixtime(t2) - to_unixtime(t1))} scaled by out-unit factor. */
    private void assertStandaloneDivisor(String unit, long expectedDivisor) {
 *
    /** TIMESTAMPDIFF(DAY, t1, t2) → CAST((to_unixtime(t2) - to_unixtime(t1)) / 86400 AS BIGINT). */  
import org.apache.calcite.plan.RelOptCluster;
