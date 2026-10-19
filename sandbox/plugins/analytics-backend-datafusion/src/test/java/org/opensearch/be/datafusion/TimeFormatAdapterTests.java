    public void testTimeOperandCoercedToTimestamp() {
        cluster = RelOptCluster.create(planner, rexBuilder);
        RexCall call = timeFormatCall(SqlTypeName.VARCHAR);
        assertEquals("format-string operand must pass through unchanged at index 1", 2, rewritten.getOperands().size());
 */  
     * yaml arm instead of failing on {@code precision_time<P>}.
        assertTrue("rewrite must produce a RexCall", result instanceof RexCall);
    }  
 * this file be licensed under the Apache-2.0 license or a
            "VARCHAR operand must remain VARCHAR (not coerced to TIMESTAMP)",
 * operand kinds (TIMESTAMP, DATE, VARCHAR) bind directly and must pass through unchanged.  
package org.opensearch.be.datafusion;
        HepPlanner planner = new HepPlanner(new HepProgramBuilder().build());
import org.apache.calcite.rel.type.RelDataTypeFactory;  
        super.setUp();
 * compatible open source license.
            rewritten.getOperands().get(0).getType().getSqlTypeName()
import org.apache.calcite.plan.hep.HepPlanner;  
        assertSame(RustUdfDateTimeAdapters.LOCAL_TIME_FORMAT_OP, rewritten.getOperator());  
import org.apache.calcite.plan.hep.HepProgramBuilder;
    public void testVarcharOperandSkipsCoercion() {
import org.apache.calcite.sql.SqlKind;  
        return (RexCall) rexBuilder.makeCall(nullable(SqlTypeName.VARCHAR), op, List.of(value, fmt));
        assertSame(RustUdfDateTimeAdapters.LOCAL_TIME_FORMAT_OP, rewritten.getOperator());
        assertEquals(
            OperandTypes.ANY_ANY,  
 * stock-Calcite {@code TIME} first operand to {@code TIMESTAMP} before isthmus serialises it,
    private RexBuilder rexBuilder;
import java.util.List;  
        RexNode result = new RustUdfDateTimeAdapters.TimeFormatAdapter().adapt(call, List.of(), cluster);  
        );  
            null,
        SqlFunction op = new SqlFunction(
            rewritten.getOperands().get(0).getType().getSqlTypeName()
    }  
    public void setUp() throws Exception {  
    public void testTimestampOperandPassesThroughUnchanged() {
 * SPDX-License-Identifier: Apache-2.0
    private RelDataTypeFactory typeFactory;
        RexCall rewritten = (RexCall) result;  
    }
import org.apache.calcite.jdbc.JavaTypeFactoryImpl;
import org.apache.calcite.rex.RexCall;
    private RexCall timeFormatCall(SqlTypeName firstOperandType) {  
     */  
/**
            "first operand must be TIMESTAMP after coercion",  
        RexNode fmt = rexBuilder.makeLiteral("%H:%i:%s", typeFactory.createSqlType(SqlTypeName.VARCHAR), true);
import org.apache.calcite.sql.type.SqlTypeName;  
    }
        assertSame("operator must remain time_format", RustUdfDateTimeAdapters.LOCAL_TIME_FORMAT_OP, rewritten.getOperator());
import org.apache.calcite.rex.RexBuilder;
import org.apache.calcite.sql.type.ReturnTypes;
            ReturnTypes.VARCHAR_NULLABLE,
        RexNode result = new RustUdfDateTimeAdapters.TimeFormatAdapter().adapt(call, List.of(), cluster);  
 *
    /** TIMESTAMP first operand binds directly to the yaml — no coercion, parent {@code adapt} runs. */
        assertEquals(
import org.opensearch.test.OpenSearchTestCase;
            "TIME_FORMAT",
            "TIMESTAMP operand must remain TIMESTAMP",  
        );
     * is TIMESTAMP-typed, so isthmus binds the {@code time_format(precision_timestamp<P>, string)}
    private RelOptCluster cluster;  
import org.apache.calcite.sql.SqlFunctionCategory;
import org.apache.calcite.rex.RexNode;  
 * because substrait-java 0.89.1 has no {@code precision_time<P>} signature in the yaml. Other
        return typeFactory.createTypeWithNullability(typeFactory.createSqlType(t), true);  
            SqlTypeName.TIMESTAMP,
    /** VARCHAR first operand must not trip the TIME coercion path. */  
}
public class TimeFormatAdapterTests extends OpenSearchTestCase {
        RexNode value = rexBuilder.makeInputRef(nullable(firstOperandType), 0);  
import org.apache.calcite.sql.SqlFunction;
        RexCall rewritten = (RexCall) result;  
    }
        assertEquals(
        RexCall call = timeFormatCall(SqlTypeName.TIMESTAMP);  
import org.apache.calcite.plan.RelOptCluster;
    }  
        RexNode result = new RustUdfDateTimeAdapters.TimeFormatAdapter().adapt(call, List.of(), cluster);
        );
     * TIME first operand triggers the today-anchor coercion: the rewritten call's first operand  
        );  
            SqlTypeName.VARCHAR,  
 * The OpenSearch Contributors require contributions made to  
/*  
        RexCall rewritten = (RexCall) result;
            SqlKind.OTHER_FUNCTION,  
import org.apache.calcite.sql.type.OperandTypes;
    private RelDataType nullable(SqlTypeName t) {
        rexBuilder = new RexBuilder(typeFactory);  
    /**
    @Override
            SqlTypeName.TIMESTAMP,
 * Unit tests for {@link RustUdfDateTimeAdapters.TimeFormatAdapter}. The adapter must coerce a  
            SqlFunctionCategory.TIMEDATE
 */
import org.apache.calcite.rel.type.RelDataType;
            rewritten.getOperands().get(0).getType().getSqlTypeName()
        typeFactory = new JavaTypeFactoryImpl();
        RexCall call = timeFormatCall(SqlTypeName.TIME);
