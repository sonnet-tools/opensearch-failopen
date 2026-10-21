    public void testToSecondsValidDatetimeLiteralPasses() {
    /** TO_SECONDS still accepts a valid full-datetime literal (Kind.DATE accepts date + datetime). */
    }
        assertNotNull("valid datetime literal must lower, not throw", findOp(result, SqlStdOperatorTable.PLUS));
package org.opensearch.be.datafusion;
            null,
            ReturnTypes.explicit(bigint()),
 */
            name,
    public void setUp() throws Exception {
import org.apache.calcite.sql.type.SqlTypeName;
    /** Builds {@code FN('<literal>')} with a VARCHAR string-literal operand. */
import java.math.BigDecimal;
     * A TIME operand must be anchored to a TIMESTAMP before to_unixtime (which rejects Time64).
        assertNotNull("expected MOD (seconds % 86400)", findOp(result, SqlStdOperatorTable.MOD));
     * The anchoring goes through the CONCAT(today, ' ', CAST(time AS VARCHAR)) → parse path, so the
/*
        RexCall call = unaryStringLiteralCall("TO_SECONDS", "2020-09-16 07:40:00");
    }
        assertNotNull("expected to_unixtime", findOp(result, UnixTimestampAdapter.LOCAL_TO_UNIXTIME_OP));
 *
        SqlFunction op = new SqlFunction(
     * to_unixtime operand must no longer be the raw TIME input ref.
import org.apache.calcite.sql.type.OperandTypes;
        );
            }
 * compatible open source license.
 * arithmetic operator tops the tree) — exact numeric values are covered by the QA ITs against a
    public void testTimeToSecTimestampOperandNotCast() {
    @Override
        super.setUp();
import org.apache.calcite.sql.SqlKind;
            SqlKind.OTHER_FUNCTION,
    }
import org.apache.calcite.rel.type.RelDataTypeFactory;
        SqlFunction op = new SqlFunction(
        RexCall call = unaryCall("TIME_TO_SEC", bigint(), SqlTypeName.TIMESTAMP);
import org.apache.calcite.sql.SqlFunctionCategory;
        assertNotEquals(
import org.opensearch.test.OpenSearchTestCase;
        assertTrue(result != call);
        if (node instanceof RexCall call) {
            "FROM_DAYS",
    }
            SqlKind.OTHER_FUNCTION,
        RexNode result = new EpochArithmeticAdapters.FromDaysAdapter().adapt(call, List.of(), cluster);
        assertNotNull("expected a PLUS (seconds + 62167219200)", findOp(result, SqlStdOperatorTable.PLUS));
        assertTrue(result != call);
 * SPDX-License-Identifier: Apache-2.0
            ReturnTypes.explicit(returnType),
            SqlFunctionCategory.TIMEDATE
        }
import org.apache.calcite.rex.RexNode;
 * FROM_DAYS / TIME_TO_SEC to {@code to_unixtime} / {@code from_unixtime} plus integer arithmetic.
    public void testTimeToSecAnchorsTimeBeforeUnixtime() {
        cluster = RelOptCluster.create(planner, rexBuilder);
     */
        RexCall call = (RexCall) rexBuilder.makeCall(dateType, op, List.of(n));
import org.apache.calcite.plan.hep.HepPlanner;
        RexCall call = unaryStringLiteralCall("TO_DAYS", "2025-13-02");
    private RexCall unaryStringLiteralCall(String name, String literal) {
                if (found != null) {
        return (RexCall) rexBuilder.makeCall(bigint(), op, List.of(lit));
import org.apache.calcite.rex.RexCall;
        assertNotNull("expected MOD", findOp(result, SqlStdOperatorTable.MOD));
    }
        typeFactory = new JavaTypeFactoryImpl();
        RexNode n = rexBuilder.makeExactLiteral(BigDecimal.valueOf(738049), typeFactory.createSqlType(SqlTypeName.BIGINT));
        assertNotNull("expected to_unixtime", findOp(result, UnixTimestampAdapter.LOCAL_TO_UNIXTIME_OP));
 * real DataFusion runtime.
            null,
    public void testToSecondsLowersToPlusOverUnixtime() {
    public void testFromDaysLowersToFromUnixtime() {
        assertNotNull("expected a DIVIDE (seconds / 86400)", findOp(result, SqlStdOperatorTable.DIVIDE));
    }
    private RexCall unaryCall(String name, RelDataType returnType, SqlTypeName operandType) {
            unixtime.getOperands().get(0).getType().getSqlTypeName()
 */
    }
        RexNode result = new EpochArithmeticAdapters.ToSecondsAdapter().adapt(call, List.of(), cluster);
        );
                }
        return typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.BIGINT), true);
        RelDataType dateType = typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.DATE), true);
        rexBuilder = new RexBuilder(typeFactory);
 * The OpenSearch Contributors require contributions made to
        RexNode result = new EpochArithmeticAdapters.ToSecondsAdapter().adapt(call, List.of(), cluster);
        RexCall call = unaryCall("TO_SECONDS", bigint(), SqlTypeName.TIMESTAMP);
            SqlKind.OTHER_FUNCTION,
    /**
            IllegalArgumentException.class,
            for (RexNode op : call.getOperands()) {
}
    private RelOptCluster cluster;
                return call;
            ReturnTypes.explicit(dateType),
    }
import org.apache.calcite.plan.RelOptCluster;
                RexCall found = findOp(op, operator);
import java.util.List;
import org.apache.calcite.sql.fun.SqlStdOperatorTable;
    private RexBuilder rexBuilder;
            null,
        RexCall unixtime = findOp(result, UnixTimestampAdapter.LOCAL_TO_UNIXTIME_OP);
            () -> new EpochArithmeticAdapters.ToDaysAdapter().adapt(call, List.of(), cluster)
            SqlFunctionCategory.TIMEDATE
        return (RexCall) rexBuilder.makeCall(returnType, op, List.of(ref));
        return null;
        // The to_unixtime operand must NOT be a raw TIME-typed value (that's the unsupported path).
        RexNode result = new EpochArithmeticAdapters.ToDaysAdapter().adapt(call, List.of(), cluster);
        RelDataType arg = typeFactory.createTypeWithNullability(typeFactory.createSqlType(operandType), true);
    }
import org.apache.calcite.sql.SqlFunction;
import org.apache.calcite.sql.type.ReturnTypes;
import org.apache.calcite.rex.RexBuilder;
        );
    }
            OperandTypes.ANY,
    public void testToDaysInvalidLiteralThrowsFormatHint() {
        assertTrue("message must carry the format hint, got: " + e.getMessage(), e.getMessage().contains("unsupported format"));
        assertNotNull("expected a PLUS (epochDays + 719528)", findOp(result, SqlStdOperatorTable.PLUS));
        RexNode ref = rexBuilder.makeInputRef(arg, 0);
            }
/**
 * this file be licensed under the Apache-2.0 license or a
        assertNotNull("expected a MULTIPLY (days * 86400)", findOp(result, SqlStdOperatorTable.MULTIPLY));
        assertNotNull("expected to_unixtime", unixtime);
            name,
                    return found;
            if (call.getOperator() == operator) {
            OperandTypes.ANY,
    public void testToDaysLowersToDividePlus() {
        assertTrue(result != call);
    }
            SqlFunctionCategory.TIMEDATE
        HepPlanner planner = new HepPlanner(new HepProgramBuilder().build());
    private RelDataTypeFactory typeFactory;
        RexCall call = unaryCall("TIME_TO_SEC", bigint(), SqlTypeName.TIME);
        );
        assertNotNull("expected from_unixtime", findOp(result, RustUdfDateTimeAdapters.LOCAL_FROM_UNIXTIME_OP));
        );
    /** TO_DAYS rejects a malformed date literal at plan time with the PPL format-hint message. */
 * Unit tests for {@link EpochArithmeticAdapters}. These adapters lower PPL TO_DAYS / TO_SECONDS /
import org.apache.calcite.rel.type.RelDataType;
        SqlFunction op = new SqlFunction(
        RexCall call = unaryCall("TO_DAYS", bigint(), SqlTypeName.TIMESTAMP);
    }
public class EpochArithmeticAdaptersTests extends OpenSearchTestCase {
            OperandTypes.ANY,
            SqlTypeName.TIME,
 * The tests assert the rewrite <em>shape</em> (the raw PPL op is replaced and the expected
        IllegalArgumentException e = expectThrows(
    private RelDataType bigint() {
    /** Recursively search for the first RexCall using {@code operator}. */
    private static RexCall findOp(RexNode node, org.apache.calcite.sql.SqlOperator operator) {
        RexNode result = new EpochArithmeticAdapters.TimeToSecAdapter().adapt(call, List.of(), cluster);
        assertTrue("TO_DAYS must be rewritten", result != call);
        RexNode result = new EpochArithmeticAdapters.TimeToSecAdapter().adapt(call, List.of(), cluster);
import org.apache.calcite.jdbc.JavaTypeFactoryImpl;
            "to_unixtime operand must be anchored, not the raw TIME",
        RexNode lit = rexBuilder.makeLiteral(literal, typeFactory.createSqlType(SqlTypeName.VARCHAR), true);
import org.apache.calcite.plan.hep.HepProgramBuilder;
