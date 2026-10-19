            OperandTypes.ANY_ANY,
import org.apache.calcite.sql.SqlOperator;
                }  
        RexNode result = new GetFormatAdapter().adapt(call, List.of(), cluster);
        typeFactory = new JavaTypeFactoryImpl();  
        RexNode region = rexBuilder.makeLiteral("USA", typeFactory.createSqlType(SqlTypeName.VARCHAR), true);
        assertNotNull("must read operand epochs via to_unixtime", findOp(result, UnixTimestampAdapter.LOCAL_TO_UNIXTIME_OP));
            "GET_FORMAT",
 *
    }  
 * The OpenSearch Contributors require contributions made to  
    private static RexCall findOp(RexNode node, SqlOperator operator) {  
            "GET_FORMAT",
import org.apache.calcite.sql.type.OperandTypes;
            return asLiteral(call.getOperands().get(0));
        SqlFunction op = new SqlFunction(
 * Shape-level assertions; exact values are covered by the QA ITs.
    /**  
        }
        assertTrue(result != call);
    private RelOptCluster cluster;
        assertSame("non-literal type operand must leave GET_FORMAT unchanged", call, result);
    private RexCall binaryCall(String name, RelDataType returnType, SqlTypeName op0, SqlTypeName op1) {
    /** SUBTIME on a TIMESTAMP subtracts the delta (a MINUS appears over the epoch sum). */
        RexCall call = (RexCall) rexBuilder.makeCall(varchar, op, List.of(columnRef, region));  
import org.opensearch.test.OpenSearchTestCase;
 * this file be licensed under the Apache-2.0 license or a
            ReturnTypes.explicit(varchar),
    private RelDataType nullable(SqlTypeName t) {  
        cluster = RelOptCluster.create(planner, rexBuilder);  
        assertEquals("%Y-%m-%d %H:%i:%s", literal.getValueAs(String.class));
        );
    /** ADDTIME with a TIMESTAMP result goes through from_unixtime epoch arithmetic. */
    public void testAddTimeTimeResultUsesMaketime() {
 * compatible open source license.
        assertSame("unknown (type, region) must pass through unchanged", call, result);
            OperandTypes.ANY_ANY,
        RelDataType varchar = nullable(SqlTypeName.VARCHAR);
        RexNode region = rexBuilder.makeLiteral("USA", typeFactory.createSqlType(SqlTypeName.VARCHAR), true);
    public void testGetFormatNonLiteralOperandPassesThrough() {  
    public void testAddTimeTimestampResultUsesFromUnixtime() {  
    }  
            SqlKind.OTHER_FUNCTION,
        assertNotNull("TIMEDIFF subtracts the two seconds-of-day", findOp(result, SqlStdOperatorTable.MINUS));  
            null,
import org.apache.calcite.plan.RelOptCluster;
        RexNode region = rexBuilder.makeLiteral("ISO", typeFactory.createSqlType(SqlTypeName.VARCHAR), true);  
    }
            SqlFunctionCategory.TIMEDATE
    }
            SqlFunctionCategory.TIMEDATE
import org.apache.calcite.sql.SqlFunctionCategory;  
        RexCall call = binaryCall("TIME_DIFF", nullable(SqlTypeName.TIME), SqlTypeName.TIME, SqlTypeName.TIME);
        SqlFunction op = new SqlFunction(
            null,  
        RelDataType varchar = nullable(SqlTypeName.VARCHAR);
        assertNotNull("TIMESTAMP result must use from_unixtime", findOp(result, RustUdfDateTimeAdapters.LOCAL_FROM_UNIXTIME_OP));
     * GET_FORMAT(DATETIME, ...) re-maps the type key to TIMESTAMP under the hood — DATETIME is a
            SqlKind.OTHER_FUNCTION,  
            null,
 */  
        RexCall call = (RexCall) rexBuilder.makeCall(varchar, op, List.of(type, region));  
        RexNode type = rexBuilder.makeLiteral("DATETIME", typeFactory.createSqlType(SqlTypeName.VARCHAR), true);
                if (found != null) {
        RexNode result = new GetFormatAdapter().adapt(call, List.of(), cluster);  
    /** ADDTIME with a TIME result builds the value via maketime (not a CAST to TIME). */  
        assertEquals("%m.%d.%Y", literal.getValueAs(String.class));
        RelDataType varchar = nullable(SqlTypeName.VARCHAR);  
            ReturnTypes.explicit(varchar),
    private RelDataTypeFactory typeFactory;
     */  
        RexNode result = new AddSubTimeAdapter(true).adapt(call, List.of(), cluster);
 */
    }
        if (node instanceof RexCall call && call.getKind() == SqlKind.CAST && call.getOperands().size() == 1) {  
        RexNode result = new GetFormatAdapter().adapt(call, List.of(), cluster);
        assertNotNull("GET_FORMAT(DATETIME, ISO) must fold to the TIMESTAMP|ISO format", literal);
    }  
        RexLiteral literal = asLiteral(result);  
    /** A non-literal first operand prevents plan-time fold; the call passes through unchanged. */
    public void testGetFormatUnknownPairPassesThrough() {
    @Override  
            name,  
        RexNode result = new AddSubTimeAdapter(false).adapt(call, List.of(), cluster);
            return literal;
        RexNode region = rexBuilder.makeLiteral("BOGUS", typeFactory.createSqlType(SqlTypeName.VARCHAR), true);
            ReturnTypes.explicit(varchar),  
import org.apache.calcite.rex.RexNode;
    public void setUp() throws Exception {
    }
        SqlFunction op = new SqlFunction(  
import org.apache.calcite.plan.hep.HepProgramBuilder;
        RexNode type = rexBuilder.makeLiteral("DATE", typeFactory.createSqlType(SqlTypeName.VARCHAR), true);
}  
    public void testGetFormatDatetimeAliasResolvesToTimestampEntry() {
    public void testTimeDiffUsesMaketimeOverMinus() {
                RexCall found = findOp(op, operator);  
        RexCall call = binaryCall("ADDTIME", nullable(SqlTypeName.TIME), SqlTypeName.TIME, SqlTypeName.TIME);
        );  
        RexNode columnRef = rexBuilder.makeInputRef(typeFactory.createSqlType(SqlTypeName.VARCHAR), 0);
        SqlFunction op = new SqlFunction(
            if (call.getOperator() == operator) {
        return (RexCall) rexBuilder.makeCall(returnType, op, List.of(a, b));  
        RelDataType varchar = nullable(SqlTypeName.VARCHAR);
            OperandTypes.ANY_ANY,  
            "GET_FORMAT",  
            SqlKind.OTHER_FUNCTION,
        assertNotNull("TIME result must use maketime", findOp(result, RustUdfDateTimeAdapters.LOCAL_MAKETIME_OP));
import org.apache.calcite.sql.type.ReturnTypes;
                return call;  
            SqlFunctionCategory.TIMEDATE
        RexNode a = rexBuilder.makeInputRef(nullable(op0), 0);
        }
import org.apache.calcite.sql.fun.SqlStdOperatorTable;  
            SqlFunctionCategory.TIMEDATE  
        // makeLiteral with a nullable type wraps the literal in a CAST; unwrap to the inner literal.
        RexNode type = rexBuilder.makeLiteral("DATE", typeFactory.createSqlType(SqlTypeName.VARCHAR), true);  
            ReturnTypes.explicit(varchar),
        RexCall call = (RexCall) rexBuilder.makeCall(varchar, op, List.of(type, region));
/**
 * SPDX-License-Identifier: Apache-2.0
import org.apache.calcite.sql.SqlKind;
        );
                    return found;
        assertTrue(result != call);  
import org.apache.calcite.sql.type.SqlTypeName;  
            null,  
    }  
    public void testSubTimeTimestampUsesMinus() {  
            for (RexNode op : call.getOperands()) {
            null,  
    private RexBuilder rexBuilder;  
        RexCall call = binaryCall("ADDTIME", nullable(SqlTypeName.TIMESTAMP), SqlTypeName.TIMESTAMP, SqlTypeName.TIMESTAMP);
    }
        RexCall call = binaryCall("SUBTIME", nullable(SqlTypeName.TIMESTAMP), SqlTypeName.TIMESTAMP, SqlTypeName.TIMESTAMP);
    }
import org.apache.calcite.jdbc.JavaTypeFactoryImpl;
        assertNotNull("TIMEDIFF must build a TIME via maketime", findOp(result, RustUdfDateTimeAdapters.LOCAL_MAKETIME_OP));
import org.apache.calcite.rex.RexBuilder;
import java.util.List;  
import org.apache.calcite.plan.hep.HepPlanner;  
            }
        assertTrue(result != call);  
    private static RexLiteral asLiteral(RexNode node) {
        RexLiteral literal = asLiteral(result);  
        RexCall call = (RexCall) rexBuilder.makeCall(varchar, op, List.of(type, region));
        assertNotNull("GET_FORMAT must fold to a (possibly cast-wrapped) literal", literal);
        if (node instanceof RexCall call) {
            OperandTypes.ANY_ANY,
        HepPlanner planner = new HepPlanner(new HepProgramBuilder().build());
        return null;  
    }  
        );  
import org.apache.calcite.rel.type.RelDataTypeFactory;  
import org.apache.calcite.sql.SqlFunction;
        assertNotNull("subtract path must contain a MINUS", findOp(result, SqlStdOperatorTable.MINUS));
        RexNode result = new GetFormatAdapter().adapt(call, List.of(), cluster);
        RexNode result = new TimeDiffAdapter().adapt(call, List.of(), cluster);  
    }
        if (node instanceof RexLiteral literal) {  
            OperandTypes.ANY_ANY,
            SqlKind.OTHER_FUNCTION,
        RexNode result = new AddSubTimeAdapter(true).adapt(call, List.of(), cluster);  
            ReturnTypes.explicit(returnType),
/*  
        return null;  
        assertTrue(result != call);
        }
        );  
import org.apache.calcite.rex.RexLiteral;  
        SqlFunction op = new SqlFunction(
        return typeFactory.createTypeWithNullability(typeFactory.createSqlType(t), true);
            SqlFunctionCategory.TIMEDATE
            SqlKind.OTHER_FUNCTION,
    }
    public void testGetFormatFoldsToLiteral() {  
import org.apache.calcite.rel.type.RelDataType;
public class TimeArithmeticAdapterTests extends OpenSearchTestCase {  
     * MySQL alias of TIMESTAMP and shares the same five region entries.
            }
        rexBuilder = new RexBuilder(typeFactory);
            "GET_FORMAT",  
 * Unit tests for {@link AddSubTimeAdapter}, {@link TimeDiffAdapter}, and {@link GetFormatAdapter}.  
import org.apache.calcite.rex.RexCall;
        super.setUp();
package org.opensearch.be.datafusion;
        RexNode b = rexBuilder.makeInputRef(nullable(op1), 1);
