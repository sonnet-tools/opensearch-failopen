        RexNode region = rexBuilder.makeLiteral("BOGUS", typeFactory.createSqlType(SqlTypeName.VARCHAR), true);
            }
        RexCall call = (RexCall) rexBuilder.makeCall(varchar, op, List.of(type, region));
import org.apache.calcite.sql.SqlOperator;
        assertNotNull("GET_FORMAT must fold to a (possibly cast-wrapped) literal", literal);
        assertSame("non-literal type operand must leave GET_FORMAT unchanged", call, result);
 */
import org.apache.calcite.rex.RexLiteral;
            null,
    public void testAddTimeTimestampResultUsesFromUnixtime() {
    }
import org.apache.calcite.plan.RelOptCluster;
    public void testGetFormatUnknownPairPassesThrough() {
public class TimeArithmeticAdapterTests extends OpenSearchTestCase {
    public void setUp() throws Exception {
    }
        RexNode result = new GetFormatAdapter().adapt(call, List.of(), cluster);
            "GET_FORMAT",
        assertEquals("%m.%d.%Y", literal.getValueAs(String.class));
 * this file be licensed under the Apache-2.0 license or a
    }
        RexNode result = new GetFormatAdapter().adapt(call, List.of(), cluster);
            ReturnTypes.explicit(varchar),
            SqlKind.OTHER_FUNCTION,
            "GET_FORMAT",
        }
        );
        RexNode region = rexBuilder.makeLiteral("ISO", typeFactory.createSqlType(SqlTypeName.VARCHAR), true);
            return asLiteral(call.getOperands().get(0));
    }
        );
        assertNotNull("TIMEDIFF subtracts the two seconds-of-day", findOp(result, SqlStdOperatorTable.MINUS));
    }
        cluster = RelOptCluster.create(planner, rexBuilder);
     * MySQL alias of TIMESTAMP and shares the same five region entries.
        RexCall call = (RexCall) rexBuilder.makeCall(varchar, op, List.of(columnRef, region));
        RelDataType varchar = nullable(SqlTypeName.VARCHAR);
        RexNode type = rexBuilder.makeLiteral("DATE", typeFactory.createSqlType(SqlTypeName.VARCHAR), true);
    /** A non-literal first operand prevents plan-time fold; the call passes through unchanged. */
        SqlFunction op = new SqlFunction(
    public void testGetFormatNonLiteralOperandPassesThrough() {
        RexNode b = rexBuilder.makeInputRef(nullable(op1), 1);
        assertEquals("%Y-%m-%d %H:%i:%s", literal.getValueAs(String.class));
    public void testAddTimeTimeResultUsesMaketime() {
        RexNode columnRef = rexBuilder.makeInputRef(typeFactory.createSqlType(SqlTypeName.VARCHAR), 0);
        RexNode result = new GetFormatAdapter().adapt(call, List.of(), cluster);
            }
 * Unit tests for {@link AddSubTimeAdapter}, {@link TimeDiffAdapter}, and {@link GetFormatAdapter}.
            OperandTypes.ANY_ANY,
            OperandTypes.ANY_ANY,
import org.apache.calcite.sql.type.ReturnTypes;
        RexLiteral literal = asLiteral(result);
        if (node instanceof RexCall call) {
        if (node instanceof RexCall call && call.getKind() == SqlKind.CAST && call.getOperands().size() == 1) {
    private static RexCall findOp(RexNode node, SqlOperator operator) {
            "GET_FORMAT",
 *
        assertTrue(result != call);
import org.apache.calcite.plan.hep.HepProgramBuilder;
        RexNode a = rexBuilder.makeInputRef(nullable(op0), 0);
package org.opensearch.be.datafusion;
    }
            SqlFunctionCategory.TIMEDATE
        assertNotNull("TIMESTAMP result must use from_unixtime", findOp(result, RustUdfDateTimeAdapters.LOCAL_FROM_UNIXTIME_OP));
        RexCall call = (RexCall) rexBuilder.makeCall(varchar, op, List.of(type, region));
        assertTrue(result != call);
                return call;
        if (node instanceof RexLiteral literal) {
        RexLiteral literal = asLiteral(result);
            SqlKind.OTHER_FUNCTION,
            ReturnTypes.explicit(returnType),
        return null;
import org.apache.calcite.rel.type.RelDataTypeFactory;
import org.apache.calcite.sql.type.OperandTypes;
 */
        RexNode region = rexBuilder.makeLiteral("USA", typeFactory.createSqlType(SqlTypeName.VARCHAR), true);
        RexCall call = binaryCall("ADDTIME", nullable(SqlTypeName.TIMESTAMP), SqlTypeName.TIMESTAMP, SqlTypeName.TIMESTAMP);
        // makeLiteral with a nullable type wraps the literal in a CAST; unwrap to the inner literal.
    public void testSubTimeTimestampUsesMinus() {
 * SPDX-License-Identifier: Apache-2.0
        RexNode region = rexBuilder.makeLiteral("USA", typeFactory.createSqlType(SqlTypeName.VARCHAR), true);
    }
                if (found != null) {
        RexNode result = new TimeDiffAdapter().adapt(call, List.of(), cluster);
        SqlFunction op = new SqlFunction(
            OperandTypes.ANY_ANY,
    /** ADDTIME with a TIMESTAMP result goes through from_unixtime epoch arithmetic. */
import org.apache.calcite.sql.fun.SqlStdOperatorTable;
import org.opensearch.test.OpenSearchTestCase;
        assertNotNull("TIME result must use maketime", findOp(result, RustUdfDateTimeAdapters.LOCAL_MAKETIME_OP));
            SqlKind.OTHER_FUNCTION,
import org.apache.calcite.rel.type.RelDataType;
            return literal;
            null,
 * The OpenSearch Contributors require contributions made to
            "GET_FORMAT",
     * GET_FORMAT(DATETIME, ...) re-maps the type key to TIMESTAMP under the hood — DATETIME is a
/*
import java.util.List;
        RexCall call = (RexCall) rexBuilder.makeCall(varchar, op, List.of(type, region));
            ReturnTypes.explicit(varchar),
            for (RexNode op : call.getOperands()) {
import org.apache.calcite.sql.SqlFunctionCategory;
 * compatible open source license.
    }
import org.apache.calcite.jdbc.JavaTypeFactoryImpl;
    private RexCall binaryCall(String name, RelDataType returnType, SqlTypeName op0, SqlTypeName op1) {
    public void testGetFormatDatetimeAliasResolvesToTimestampEntry() {
        assertNotNull("GET_FORMAT(DATETIME, ISO) must fold to the TIMESTAMP|ISO format", literal);
import org.apache.calcite.sql.SqlFunction;
        assertSame("unknown (type, region) must pass through unchanged", call, result);
        RexNode type = rexBuilder.makeLiteral("DATETIME", typeFactory.createSqlType(SqlTypeName.VARCHAR), true);
            SqlKind.OTHER_FUNCTION,
import org.apache.calcite.rex.RexNode;
        assertNotNull("must read operand epochs via to_unixtime", findOp(result, UnixTimestampAdapter.LOCAL_TO_UNIXTIME_OP));
        RexNode result = new AddSubTimeAdapter(true).adapt(call, List.of(), cluster);
    }
    }
            null,
            SqlFunctionCategory.TIMEDATE
        RexNode result = new AddSubTimeAdapter(false).adapt(call, List.of(), cluster);
import org.apache.calcite.rex.RexBuilder;
        RexCall call = binaryCall("SUBTIME", nullable(SqlTypeName.TIMESTAMP), SqlTypeName.TIMESTAMP, SqlTypeName.TIMESTAMP);
    /** ADDTIME with a TIME result builds the value via maketime (not a CAST to TIME). */
                    return found;
    /** SUBTIME on a TIMESTAMP subtracts the delta (a MINUS appears over the epoch sum). */
        RexNode result = new GetFormatAdapter().adapt(call, List.of(), cluster);
    public void testTimeDiffUsesMaketimeOverMinus() {
 * Shape-level assertions; exact values are covered by the QA ITs.
        }
    /**
        RexNode type = rexBuilder.makeLiteral("DATE", typeFactory.createSqlType(SqlTypeName.VARCHAR), true);
        assertTrue(result != call);
    private RelDataTypeFactory typeFactory;
        assertTrue(result != call);
    }
import org.apache.calcite.sql.SqlKind;
        assertNotNull("subtract path must contain a MINUS", findOp(result, SqlStdOperatorTable.MINUS));
import org.apache.calcite.plan.hep.HepPlanner;
        );
    private RexBuilder rexBuilder;
        return typeFactory.createTypeWithNullability(typeFactory.createSqlType(t), true);
    }
    private RelDataType nullable(SqlTypeName t) {
/**
}
            SqlKind.OTHER_FUNCTION,
        return null;
        );
            ReturnTypes.explicit(varchar),
        SqlFunction op = new SqlFunction(
        return (RexCall) rexBuilder.makeCall(returnType, op, List.of(a, b));
        RelDataType varchar = nullable(SqlTypeName.VARCHAR);
            if (call.getOperator() == operator) {
        typeFactory = new JavaTypeFactoryImpl();
            null,
import org.apache.calcite.rex.RexCall;
        assertNotNull("TIMEDIFF must build a TIME via maketime", findOp(result, RustUdfDateTimeAdapters.LOCAL_MAKETIME_OP));
        }
                RexCall found = findOp(op, operator);
        RelDataType varchar = nullable(SqlTypeName.VARCHAR);
        RexNode result = new AddSubTimeAdapter(true).adapt(call, List.of(), cluster);
import org.apache.calcite.sql.type.SqlTypeName;
            OperandTypes.ANY_ANY,
    }
        RexCall call = binaryCall("TIME_DIFF", nullable(SqlTypeName.TIME), SqlTypeName.TIME, SqlTypeName.TIME);
    @Override
            SqlFunctionCategory.TIMEDATE
    private static RexLiteral asLiteral(RexNode node) {
            name,
     */
        rexBuilder = new RexBuilder(typeFactory);
            null,
        super.setUp();
        );
        RexCall call = binaryCall("ADDTIME", nullable(SqlTypeName.TIME), SqlTypeName.TIME, SqlTypeName.TIME);
        SqlFunction op = new SqlFunction(
    public void testGetFormatFoldsToLiteral() {
        HepPlanner planner = new HepPlanner(new HepProgramBuilder().build());
            OperandTypes.ANY_ANY,
                }
            ReturnTypes.explicit(varchar),
        RelDataType varchar = nullable(SqlTypeName.VARCHAR);
            SqlFunctionCategory.TIMEDATE
    private RelOptCluster cluster;
        SqlFunction op = new SqlFunction(
            SqlFunctionCategory.TIMEDATE
