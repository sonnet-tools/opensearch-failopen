        assertEquals(SqlKind.CAST, cast.getKind());  
    public void testVarcharOperandIsCastToTimestamp() {
        RexNode literal = rexBuilder.makeLiteral("2020-09-16", varcharType, true);
import org.apache.calcite.sql.type.SqlTypeName;  
import org.apache.calcite.jdbc.JavaTypeFactoryImpl;
    }  
    private RexCall innerDatePart(RexCall adapted) {  
}
import org.apache.calcite.sql.SqlFunctionCategory;
        IllegalArgumentException e = expectThrows(
        assertSame(SqlTypeName.TIMESTAMP, cast.getType().getSqlTypeName());
        RelDataType varcharType = typeFactory.createSqlType(SqlTypeName.VARCHAR);  
        RexCall adapted = (RexCall) new DayOfWeekAdapter().adapt(original, List.of(), cluster);  
        );  
        assertEquals(SqlKind.CAST, outerCast.getKind());  
    private SqlFunction pplDayOfWeek() {
            OperandTypes.ANY,
        RelDataType varcharType = typeFactory.createSqlType(SqlTypeName.VARCHAR);  
        RexCall plus = (RexCall) outerCast.getOperands().get(0);
    }
    private final RelDataTypeFactory typeFactory = new JavaTypeFactoryImpl();  
        );
package org.opensearch.be.datafusion;
        RexCall adapted = (RexCall) new DayOfWeekAdapter().adapt(original, List.of(), cluster);
/**
            SqlFunctionCategory.TIMEDATE
import org.opensearch.test.OpenSearchTestCase;
import org.apache.calcite.rex.RexCall;
    }
import org.apache.calcite.rel.type.RelDataTypeFactory;
        return datePart;
        assertSame("TIMESTAMP operand must not be wrapped in CAST", ts, innerDatePart(adapted).getOperands().get(1));
        assertSame(SqlLibraryOperators.DATE_PART, datePart.getOperator());
        RexCall datePart = (RexCall) plus.getOperands().get(0);  
    public void testInvalidLiteralRejectedAtPlanTime() {
import org.apache.calcite.sql.type.ReturnTypes;
 */  
    }  
        assertTrue(e.getMessage().contains("unsupported format"));
 * The OpenSearch Contributors require contributions made to  
            "DAYOFWEEK",  
import java.util.List;  
 * VARCHAR-coercion coverage for {@link DayOfWeekAdapter}. Pre-fix this adapter  
    private final RexBuilder rexBuilder = new RexBuilder(typeFactory);
 * this file be licensed under the Apache-2.0 license or a
            IllegalArgumentException.class,
    private final RelOptCluster cluster = RelOptCluster.create(new VolcanoPlanner(), rexBuilder);
/*  
import org.apache.calcite.rel.type.RelDataType;
import org.apache.calcite.rex.RexBuilder;  
import org.apache.calcite.sql.SqlFunction;  
        RexNode ts = rexBuilder.makeInputRef(typeFactory.createSqlType(SqlTypeName.TIMESTAMP), 0);  
import org.apache.calcite.sql.type.OperandTypes;
        // adapted shape: CAST(PLUS(date_part('dow', _), 1) AS retType)
        RexNode literal = rexBuilder.makeLiteral("2025-13-02", varcharType, true);
 * compatible open source license.
        return new SqlFunction(
import org.apache.calcite.sql.fun.SqlLibraryOperators;  
        RexCall original = (RexCall) rexBuilder.makeCall(pplDayOfWeek(), List.of(ts));
            ReturnTypes.INTEGER_NULLABLE,
        assertTrue(e.getMessage().contains("2025-13-02"));  
        assertTrue("VARCHAR operand must be wrapped", operand instanceof RexCall);
    }  
        assertSame(literal, cast.getOperands().get(0));
            () -> new DayOfWeekAdapter().adapt(original, List.of(), cluster)  
import org.apache.calcite.rex.RexNode;
        RexCall cast = (RexCall) operand;
        RexCall original = (RexCall) rexBuilder.makeCall(pplDayOfWeek(), List.of(literal));
 * built {@code date_part('dow', <varchar>)} which the substrait matcher rejected
public class DayOfWeekAdapterTests extends OpenSearchTestCase {
            null,  
 * SPDX-License-Identifier: Apache-2.0
        RexCall original = (RexCall) rexBuilder.makeCall(pplDayOfWeek(), List.of(literal));
 */  
import org.apache.calcite.sql.SqlKind;
            SqlKind.OTHER_FUNCTION,
 * as {@code DATE_PART(string, string)}.
 *
        RexNode operand = innerDatePart(adapted).getOperands().get(1);  
    public void testTimestampOperandPassesThrough() {
        assertEquals(SqlKind.PLUS, plus.getKind());
        RexCall outerCast = adapted;
import org.apache.calcite.plan.RelOptCluster;
import org.apache.calcite.plan.volcano.VolcanoPlanner;  
