        return (RexCall) rexBuilder.makeCall(nullable(SqlTypeName.INTEGER), op, operands);
import org.apache.calcite.plan.RelOptCluster;
 * SPDX-License-Identifier: Apache-2.0
    @Override  
        RexNode dateLit = rexBuilder.makeLiteral("2003-10-03", typeFactory.createSqlType(SqlTypeName.VARCHAR), true);
public class OsYearweekAdapterTests extends OpenSearchTestCase {  
 * operand unchanged. The 0-arg branch falls back to the parent {@code AbstractNameMappingAdapter}.
 */
        return typeFactory.createTypeWithNullability(typeFactory.createSqlType(t), true);
     * UDF op, and (b) replace the raw VARCHAR operand with a TIMESTAMP-typed expression.  
}  
    }
 * VARCHAR / TIME first operand to TIMESTAMP via {@link DatePartAdapters#coerceCharacterOperandToTimestamp}
    }
    }
import org.apache.calcite.sql.SqlKind;  
import org.apache.calcite.rel.type.RelDataType;
    private RelDataTypeFactory typeFactory;
    /** TIMESTAMP first operand must skip the coercion path and route directly to os_yearweek. */
    /**
/*  
import org.apache.calcite.sql.type.SqlTypeName;  
        RexCall call = yearweekCall(List.of(tsRef), 1);
import org.apache.calcite.plan.hep.HepPlanner;  
    }  
    public void testYearweekTimestampOperandTargetsOsYearweek() {  
        RexNode mode = rexBuilder.makeExactLiteral(BigDecimal.valueOf(3), typeFactory.createSqlType(SqlTypeName.INTEGER));  
    }
package org.opensearch.be.datafusion;
        assertTrue("YEARWEEK must be rewritten", result instanceof RexCall);
import org.opensearch.test.OpenSearchTestCase;
    private RexCall yearweekCall(List<RexNode> operands, int operandTypeCount) {
            new SqlFunction(
    private RexBuilder rexBuilder;  
            rewritten.getOperands().get(0).getType().getSqlTypeName()
        super.setUp();
        RexNode result = new RustUdfDateTimeAdapters.OsYearweekAdapter().adapt(call, List.of(), cluster);  
                ReturnTypes.INTEGER_NULLABLE,
        SqlFunction op = new SqlFunction(
        RexNode result = new RustUdfDateTimeAdapters.OsYearweekAdapter().adapt(call, List.of(), cluster);
     * 0-arg call must fall back to the parent name-mapping adapter — coercion logic only runs when
     */
        HepPlanner planner = new HepPlanner(new HepProgramBuilder().build());
                SqlFunctionCategory.TIMEDATE
     * 2-arg form: the date operand is coerced, but the integer mode operand passes through unchanged
        assertSame(RustUdfDateTimeAdapters.LOCAL_OS_YEARWEEK_OP, rewritten.getOperator());  
import java.util.List;
                OperandTypes.NILADIC,  
        RexNode result = new RustUdfDateTimeAdapters.OsYearweekAdapter().adapt(call, List.of(), cluster);
/**  
    public void testYearweekVarcharOperandCoercedToTimestamp() {
 * Unit tests for {@link RustUdfDateTimeAdapters.OsYearweekAdapter}. The adapter must (a) coerce a
        RexCall call = yearweekCall(List.of(lit), 1);
import org.apache.calcite.jdbc.JavaTypeFactoryImpl;
        );  
                SqlKind.OTHER_FUNCTION,  
    /**  
    }
 *
    /**  
import org.apache.calcite.sql.SqlFunctionCategory;
import java.math.BigDecimal;  
            ),
            SqlTypeName.TIMESTAMP,
        RexCall call = (RexCall) rexBuilder.makeCall(
    private RelOptCluster cluster;
    private RelDataType nullable(SqlTypeName t) {  
 * before binding the {@code precision_timestamp<P>} signature, and (b) preserve a 2-arg call's mode  
        RexCall call = yearweekCall(List.of(dateLit, mode), 2);
        RexCall rewritten = (RexCall) result;  
     * — its type must NOT be transformed and the value must be preserved.
            SqlKind.OTHER_FUNCTION,
        rexBuilder = new RexBuilder(typeFactory);
import org.apache.calcite.rex.RexCall;
        assertSame(RustUdfDateTimeAdapters.LOCAL_OS_YEARWEEK_OP, rewritten.getOperator());
        RexNode result = new RustUdfDateTimeAdapters.OsYearweekAdapter().adapt(call, List.of(), cluster);  
     * 1-arg form with a VARCHAR operand: the rewrite must (a) replace YEARWEEK with the os_yearweek
        assertSame("rewrite must target os_yearweek", RustUdfDateTimeAdapters.LOCAL_OS_YEARWEEK_OP, rewritten.getOperator());
    public void testYearweekModeOperandPassesThroughUnchanged() {
        );
import org.apache.calcite.sql.SqlFunction;
            SqlFunctionCategory.TIMEDATE
 * compatible open source license.
import org.apache.calcite.rex.RexBuilder;
        RexNode lit = rexBuilder.makeLiteral("2003-10-03", typeFactory.createSqlType(SqlTypeName.VARCHAR), true);  
        );  
        RexNode tsRef = rexBuilder.makeInputRef(nullable(SqlTypeName.TIMESTAMP), 0);
            "TIMESTAMP operand must remain TIMESTAMP after coercion (no-op)",  
        cluster = RelOptCluster.create(planner, rexBuilder);  
            operandTypeCount == 2 ? OperandTypes.ANY_ANY : OperandTypes.ANY,
            nullable(SqlTypeName.INTEGER),  
            SqlTypeName.TIMESTAMP,
            ReturnTypes.INTEGER_NULLABLE,
        RexCall rewritten = (RexCall) result;  
import org.apache.calcite.sql.type.OperandTypes;
 */  
        assertEquals("mode operand must be preserved at index 1", 2, rewritten.getOperands().size());
import org.apache.calcite.sql.type.ReturnTypes;
    public void setUp() throws Exception {
            null,  
        assertSame(RustUdfDateTimeAdapters.LOCAL_OS_YEARWEEK_OP, ((RexCall) result).getOperator());
        );  
                "YEARWEEK",
            "YEARWEEK",  
        RexCall rewritten = (RexCall) result;
        assertTrue("0-arg YEARWEEK should still produce a RexCall (parent's name-mapping result)", result instanceof RexCall);  
        assertSame("mode operand must be the same RexNode (identity), not a re-wrapped copy", mode, rewritten.getOperands().get(1));
 * The OpenSearch Contributors require contributions made to  
     */  
            "coerced operand must be TIMESTAMP-typed",  
            List.of()  
            rewritten.getOperands().get(0).getType().getSqlTypeName()
                null,
    }
import org.apache.calcite.plan.hep.HepProgramBuilder;
import org.apache.calcite.rex.RexNode;  
        assertEquals(
    public void testYearweekZeroArgFallsThroughToParent() {
        assertEquals(
     * there is at least one operand to coerce.
 * this file be licensed under the Apache-2.0 license or a
        typeFactory = new JavaTypeFactoryImpl();  
import org.apache.calcite.rel.type.RelDataTypeFactory;  
     */  
