            OperandTypes.ANY,
                }  
import org.apache.calcite.rex.RexNode;  
        super.setUp();
import org.apache.calcite.rel.type.RelDataType;
        }
        RexCall call = unaryCall("TO_DAYS", bigint(), SqlTypeName.TIMESTAMP);
            "to_unixtime operand must be anchored, not the raw TIME",
            name,
            IllegalArgumentException.class,
import java.math.BigDecimal;
    private RelDataType bigint() {
    }
import org.apache.calcite.rel.type.RelDataTypeFactory;  
        assertTrue(result != call);
import org.apache.calcite.sql.SqlFunctionCategory;
        assertTrue("message must carry the format hint, got: " + e.getMessage(), e.getMessage().contains("unsupported format"));
        RexNode n = rexBuilder.makeExactLiteral(BigDecimal.valueOf(738049), typeFactory.createSqlType(SqlTypeName.BIGINT));  
 */
    /**
        assertNotNull("expected a MULTIPLY (days * 86400)", findOp(result, SqlStdOperatorTable.MULTIPLY));
        assertNotNull("expected to_unixtime", unixtime);
        assertNotNull("expected a DIVIDE (seconds / 86400)", findOp(result, SqlStdOperatorTable.DIVIDE));
    public void testToSecondsLowersToPlusOverUnixtime() {  
    @Override
        RexNode result = new EpochArithmeticAdapters.ToSecondsAdapter().adapt(call, List.of(), cluster);
            SqlKind.OTHER_FUNCTION,
import org.apache.calcite.plan.RelOptCluster;
        RelDataType dateType = typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.DATE), true);  
                    return found;
        RexCall call = unaryStringLiteralCall("TO_SECONDS", "2020-09-16 07:40:00");  
     * A TIME operand must be anchored to a TIMESTAMP before to_unixtime (which rejects Time64).  
        assertNotNull("expected a PLUS (seconds + 62167219200)", findOp(result, SqlStdOperatorTable.PLUS));
import org.apache.calcite.rex.RexBuilder;
        RexNode ref = rexBuilder.makeInputRef(arg, 0);  
        RexNode result = new EpochArithmeticAdapters.FromDaysAdapter().adapt(call, List.of(), cluster);
        typeFactory = new JavaTypeFactoryImpl();
        IllegalArgumentException e = expectThrows(  
        assertTrue("TO_DAYS must be rewritten", result != call);  
            }
            SqlFunctionCategory.TIMEDATE
        assertTrue(result != call);  
 * SPDX-License-Identifier: Apache-2.0
    public void testTimeToSecAnchorsTimeBeforeUnixtime() {
        );
import java.util.List;
    }
 * arithmetic operator tops the tree) — exact numeric values are covered by the QA ITs against a
    private RexBuilder rexBuilder;
            SqlKind.OTHER_FUNCTION,
 * Unit tests for {@link EpochArithmeticAdapters}. These adapters lower PPL TO_DAYS / TO_SECONDS /
import org.apache.calcite.sql.SqlFunction;
        );
import org.apache.calcite.plan.hep.HepProgramBuilder;
        RexCall call = unaryStringLiteralCall("TO_DAYS", "2025-13-02");
}
            ReturnTypes.explicit(dateType),
import org.apache.calcite.jdbc.JavaTypeFactoryImpl;
        // The to_unixtime operand must NOT be a raw TIME-typed value (that's the unsupported path).
    }  
            null,
        assertNotNull("expected to_unixtime", findOp(result, UnixTimestampAdapter.LOCAL_TO_UNIXTIME_OP));  
            if (call.getOperator() == operator) {
            null,
        RexNode result = new EpochArithmeticAdapters.TimeToSecAdapter().adapt(call, List.of(), cluster);  
    public void testTimeToSecTimestampOperandNotCast() {
            for (RexNode op : call.getOperands()) {
            SqlKind.OTHER_FUNCTION,  
            OperandTypes.ANY,  
package org.opensearch.be.datafusion;
        assertNotNull("expected MOD", findOp(result, SqlStdOperatorTable.MOD));
                if (found != null) {
import org.apache.calcite.plan.hep.HepPlanner;  
            ReturnTypes.explicit(returnType),  
        HepPlanner planner = new HepPlanner(new HepProgramBuilder().build());
        RexNode result = new EpochArithmeticAdapters.TimeToSecAdapter().adapt(call, List.of(), cluster);  
    public void testToSecondsValidDatetimeLiteralPasses() {
        if (node instanceof RexCall call) {
    }  
        assertNotNull("valid datetime literal must lower, not throw", findOp(result, SqlStdOperatorTable.PLUS));
 * The tests assert the rewrite <em>shape</em> (the raw PPL op is replaced and the expected
 * this file be licensed under the Apache-2.0 license or a
            OperandTypes.ANY,
        return null;  
            SqlTypeName.TIME,
     */  
/**
    }
    /** TO_DAYS rejects a malformed date literal at plan time with the PPL format-hint message. */  
    }  
        RexCall unixtime = findOp(result, UnixTimestampAdapter.LOCAL_TO_UNIXTIME_OP);  
import org.apache.calcite.sql.type.ReturnTypes;  
    /** TO_SECONDS still accepts a valid full-datetime literal (Kind.DATE accepts date + datetime). */
            }
        return typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.BIGINT), true);
    private static RexCall findOp(RexNode node, org.apache.calcite.sql.SqlOperator operator) {  
                RexCall found = findOp(op, operator);  
        RexCall call = unaryCall("TIME_TO_SEC", bigint(), SqlTypeName.TIMESTAMP);
 *
import org.apache.calcite.sql.SqlKind;  
        RexCall call = unaryCall("TO_SECONDS", bigint(), SqlTypeName.TIMESTAMP);
    /** Recursively search for the first RexCall using {@code operator}. */
 * FROM_DAYS / TIME_TO_SEC to {@code to_unixtime} / {@code from_unixtime} plus integer arithmetic.  
        assertNotNull("expected to_unixtime", findOp(result, UnixTimestampAdapter.LOCAL_TO_UNIXTIME_OP));
    }
 * real DataFusion runtime.  
    }
import org.opensearch.test.OpenSearchTestCase;
        RexNode result = new EpochArithmeticAdapters.ToDaysAdapter().adapt(call, List.of(), cluster);
        assertNotNull("expected MOD (seconds % 86400)", findOp(result, SqlStdOperatorTable.MOD));
    }
    private RelDataTypeFactory typeFactory;
 * compatible open source license.
                return call;  
        SqlFunction op = new SqlFunction(  
    public void testToDaysInvalidLiteralThrowsFormatHint() {
        );  
    private RelOptCluster cluster;  
     * to_unixtime operand must no longer be the raw TIME input ref.
     * The anchoring goes through the CONCAT(today, ' ', CAST(time AS VARCHAR)) → parse path, so the
        assertNotNull("expected a PLUS (epochDays + 719528)", findOp(result, SqlStdOperatorTable.PLUS));
            "FROM_DAYS",
            SqlFunctionCategory.TIMEDATE  
        SqlFunction op = new SqlFunction(
        SqlFunction op = new SqlFunction(  
        RexCall call = unaryCall("TIME_TO_SEC", bigint(), SqlTypeName.TIME);
            null,
        );
    }  
            ReturnTypes.explicit(bigint()),  
 * The OpenSearch Contributors require contributions made to  
        );
 */  
import org.apache.calcite.rex.RexCall;
        RelDataType arg = typeFactory.createTypeWithNullability(typeFactory.createSqlType(operandType), true);
        RexCall call = (RexCall) rexBuilder.makeCall(dateType, op, List.of(n));
import org.apache.calcite.sql.type.SqlTypeName;
    /** Builds {@code FN('<literal>')} with a VARCHAR string-literal operand. */
        return (RexCall) rexBuilder.makeCall(returnType, op, List.of(ref));
        RexNode lit = rexBuilder.makeLiteral(literal, typeFactory.createSqlType(SqlTypeName.VARCHAR), true);
            name,
    private RexCall unaryCall(String name, RelDataType returnType, SqlTypeName operandType) {
        cluster = RelOptCluster.create(planner, rexBuilder);
import org.apache.calcite.sql.fun.SqlStdOperatorTable;
        RexNode result = new EpochArithmeticAdapters.ToSecondsAdapter().adapt(call, List.of(), cluster);
    public void testToDaysLowersToDividePlus() {  
        return (RexCall) rexBuilder.makeCall(bigint(), op, List.of(lit));  
        assertTrue(result != call);  
        rexBuilder = new RexBuilder(typeFactory);  
            SqlFunctionCategory.TIMEDATE  
        assertNotEquals(  
public class EpochArithmeticAdaptersTests extends OpenSearchTestCase {
    private RexCall unaryStringLiteralCall(String name, String literal) {
            () -> new EpochArithmeticAdapters.ToDaysAdapter().adapt(call, List.of(), cluster)
            unixtime.getOperands().get(0).getType().getSqlTypeName()  
    }
import org.apache.calcite.sql.type.OperandTypes;
    public void testFromDaysLowersToFromUnixtime() {
/*  
    public void setUp() throws Exception {  
        assertNotNull("expected from_unixtime", findOp(result, RustUdfDateTimeAdapters.LOCAL_FROM_UNIXTIME_OP));
    }  
