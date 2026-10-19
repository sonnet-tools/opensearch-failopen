        assertSame(SqlLibraryOperators.DATE_PART, datePart.getOperator());  
 *
        // adapted shape: CAST(FLOOR(CAST(date_part('second', _) AS DOUBLE)) AS retType)
        RexCall original = (RexCall) rexBuilder.makeCall(pplSecond(), List.of(ts));  
        RexCall cast = (RexCall) operand;
        RexNode literal = rexBuilder.makeLiteral("2025-12-01 15:02:61", varcharType, true);  
import org.apache.calcite.sql.SqlFunction;  
        RexCall adapted = (RexCall) new SecondAdapter().adapt(original, List.of(), cluster);
            ReturnTypes.INTEGER_NULLABLE,  
 */  
            SqlFunctionCategory.TIMEDATE  
        assertEquals(SqlKind.CAST, adapted.getKind());  
        RexNode ts = rexBuilder.makeInputRef(typeFactory.createSqlType(SqlTypeName.TIMESTAMP), 0);
        assertSame(literal, cast.getOperands().get(0));
        RexCall original = (RexCall) rexBuilder.makeCall(pplSecond(), List.of(literal));
 * VARCHAR-coercion coverage for {@link SecondAdapter}. Pre-fix this adapter
 * rejected as {@code DATE_PART(string, string)}.  
import org.apache.calcite.sql.SqlFunctionCategory;
import org.apache.calcite.rex.RexBuilder;  
import org.apache.calcite.sql.type.ReturnTypes;  
        RexNode operand = innerDatePart(adapted).getOperands().get(1);
}
    }
        return new SqlFunction(  
    private final RelDataTypeFactory typeFactory = new JavaTypeFactoryImpl();
import org.apache.calcite.plan.volcano.VolcanoPlanner;  
            SqlKind.OTHER_FUNCTION,
        RexCall adapted = (RexCall) new SecondAdapter().adapt(original, List.of(), cluster);  
        assertSame("TIMESTAMP operand must not be wrapped in CAST", ts, innerDatePart(adapted).getOperands().get(1));
 * SPDX-License-Identifier: Apache-2.0
        assertTrue("VARCHAR operand must be wrapped", operand instanceof RexCall);  
package org.opensearch.be.datafusion;
            () -> new SecondAdapter().adapt(original, List.of(), cluster)
    }
        RexNode literal = rexBuilder.makeLiteral("2020-09-16 17:30:45", varcharType, true);  
 */
    private final RelOptCluster cluster = RelOptCluster.create(new VolcanoPlanner(), rexBuilder);  
        return datePart;
        );  
    public void testTimestampOperandPassesThrough() {
/*  
    public void testVarcharOperandIsCastToTimestamp() {
        assertTrue(e.getMessage().contains("2025-12-01 15:02:61"));
    private final RexBuilder rexBuilder = new RexBuilder(typeFactory);
        assertSame(SqlTypeName.TIMESTAMP, cast.getType().getSqlTypeName());  
        RexCall datePart = (RexCall) innerCast.getOperands().get(0);
    public void testInvalidLiteralRejectedAtPlanTime() {
import org.apache.calcite.sql.SqlKind;
import org.apache.calcite.plan.RelOptCluster;
            OperandTypes.ANY,
            IllegalArgumentException.class,
        assertSame(SqlStdOperatorTable.FLOOR, floor.getOperator());
        RexCall innerCast = (RexCall) floor.getOperands().get(0);  
        IllegalArgumentException e = expectThrows(  
import org.apache.calcite.rel.type.RelDataType;
        RexCall floor = (RexCall) adapted.getOperands().get(0);
 * built {@code date_part('second', <varchar>)} which the substrait matcher
        assertEquals(SqlKind.CAST, cast.getKind());
 * The OpenSearch Contributors require contributions made to  
import org.apache.calcite.sql.fun.SqlStdOperatorTable;
import org.apache.calcite.sql.fun.SqlLibraryOperators;  
        );
import org.apache.calcite.sql.type.SqlTypeName;
        assertTrue(e.getMessage().contains("unsupported format"));
import org.apache.calcite.rex.RexCall;
        RelDataType varcharType = typeFactory.createSqlType(SqlTypeName.VARCHAR);
    }  
import org.apache.calcite.rel.type.RelDataTypeFactory;
 * compatible open source license.
/**  
import org.opensearch.test.OpenSearchTestCase;
            "SECOND",
    private SqlFunction pplSecond() {
        RexCall original = (RexCall) rexBuilder.makeCall(pplSecond(), List.of(literal));
import java.util.List;
import org.apache.calcite.rex.RexNode;
public class SecondAdapterTests extends OpenSearchTestCase {
        RelDataType varcharType = typeFactory.createSqlType(SqlTypeName.VARCHAR);
    }
        assertEquals(SqlKind.CAST, innerCast.getKind());
    private RexCall innerDatePart(RexCall adapted) {
    }
            null,
 * this file be licensed under the Apache-2.0 license or a
import org.apache.calcite.jdbc.JavaTypeFactoryImpl;
import org.apache.calcite.sql.type.OperandTypes;
