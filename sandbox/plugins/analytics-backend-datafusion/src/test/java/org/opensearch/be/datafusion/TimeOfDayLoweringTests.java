import org.apache.calcite.plan.hep.HepPlanner;  
    public void testSecondsToTimeNormalizesAndBuildsMaketime() {  
    }
        assertEquals("expected 8 MOD ops (3× floor-mod + minute-mod + second-mod)", 8, countOps(result, SqlStdOperatorTable.MOD));  
        assertEquals("floor-mod requires exactly 2 MOD ops", 2, countOps(result, SqlStdOperatorTable.MOD));
import org.apache.calcite.sql.type.SqlTypeName;  
        RexNode seconds = rexBuilder.makeInputRef(bigint, 0);  
     * a single {@code to_unixtime} reading the operand once.  
            sum += countOps(op, operator);
    }
        RexNode result = TimeOfDayLowering.secondsOfDay(operand, cluster);  
        RelDataType time = typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.TIME), true);
     * {@code secondsOfDay(timestamp)} emits the floor-mod chain
import org.opensearch.test.OpenSearchTestCase;
        RelDataType bigint = typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.BIGINT), true);
/**  
 */  
                RexCall found = findOp(op, operator);  
        }
import org.apache.calcite.rex.RexCall;
import org.apache.calcite.plan.RelOptCluster;
        assertEquals("expected 3 PLUS ops (floor-mod +86400 in each of 3 branches)", 3, countOps(result, SqlStdOperatorTable.PLUS));
    }  
        RexNode seconds = rexBuilder.makeInputRef(bigint, 0);  
    private RexBuilder rexBuilder;
     * MOD + 3 PLUS from the floor-mod chains, plus 2 extra MODs for the minute/second tails  
        typeFactory = new JavaTypeFactoryImpl();
        );  
            "to_unixtime operand must be anchored, not the raw VARCHAR",  
 * ({@code ((s MOD 86400) + 86400) MOD 86400}) so negative epochs (pre-1970) wrap the MySQL way
import org.apache.calcite.sql.fun.SqlStdOperatorTable;
    /** {@code secondsOfDay} on a VARCHAR / TIME operand routes through coerceCharacterOperandToTimestamp. */
    private RelDataTypeFactory typeFactory;  
 * Unit tests for {@link TimeOfDayLowering}. The two helpers each emit a floor-mod chain
    /** {@code secondsToTime} preserves the caller's TIME type on the maketime call's return. */
        assertEquals("floor-mod requires exactly 1 PLUS op", 1, countOps(result, SqlStdOperatorTable.PLUS));  
        // 3 × floor-mod chain (each branch references `norm` independently) + 2 minute/second tails.
    }
     * floor-mod chain {@code ((s MOD 86400) + 86400) MOD 86400}) independently — RexNode trees
    }
        assertEquals("result type must equal the timeType arg", time, result.getType());
 * The OpenSearch Contributors require contributions made to  
    public void testSecondsToTimeReturnTypeMatchesCallerType() {  
}
        assertSame("maketime must be the top of the rewrite", RustUdfDateTimeAdapters.LOCAL_MAKETIME_OP, top.getOperator());  
     * don't share subtrees, so the chain is duplicated three times: 3 × (2 MOD + 1 PLUS) = 6
import org.apache.calcite.rel.type.RelDataTypeFactory;  
        rexBuilder = new RexBuilder(typeFactory);
        cluster = RelOptCluster.create(planner, rexBuilder);
        RexCall top = (RexCall) result;
        RexNode operand = rexBuilder.makeInputRef(varchar, 0);
            }
    }
 * and are covered by the QA ITs (e.g. {@code testSecToTimeWrapsOverOneDay}).
     * = 8 MOD total. Two DIVIDEs: hour = norm/3600 and minute = (norm % 3600) / 60.
        }
     * {@code secondsToTime} emits a normalized hour/minute/second decomposition wrapped in a
        assertEquals("operand should be read via to_unixtime once", 1, countOps(result, UnixTimestampAdapter.LOCAL_TO_UNIXTIME_OP));
        assertTrue("result must be a RexCall", result instanceof RexCall);
import org.apache.calcite.plan.hep.HepProgramBuilder;
import org.apache.calcite.sql.SqlOperator;
 * {@code MOD} / {@code PLUS} / {@code DIVIDE} nodes — exact numeric values come out at runtime
        RelDataType varchar = typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.VARCHAR), true);  
            for (RexNode op : call.getOperands()) {
        RexNode result = TimeOfDayLowering.secondsToTime(seconds, time, cluster);
    private static RexCall findOp(RexNode node, SqlOperator operator) {  
            return 0;  
    public void setUp() throws Exception {
    public void testSecondsOfDayAnchorsCharacterOperand() {
        int sum = call.getOperator() == operator ? 1 : 0;
                return call;  
    /**
        }
 *
        RexCall toUnixtime = findOp(result, UnixTimestampAdapter.LOCAL_TO_UNIXTIME_OP);  
        assertEquals("expected 2 DIVIDE ops (hour and minute)", 2, countOps(result, SqlStdOperatorTable.DIVIDE));
                }  
import org.apache.calcite.rel.type.RelDataType;
    private static int countOps(RexNode node, SqlOperator operator) {
                    return found;
package org.opensearch.be.datafusion;
    @Override
                if (found != null) {
        assertNotEquals(
    public void testSecondsOfDayEmitsFloorModChain() {
 */  
            SqlTypeName.VARCHAR,
        return sum;  
/*  
            }
        super.setUp();  
        RelDataType time = typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.TIME), true);
        if (node instanceof RexCall call) {
 * compatible open source license.
import org.apache.calcite.rex.RexBuilder;
            toUnixtime.getOperands().get(0).getType().getSqlTypeName()
        assertEquals("maketime takes (hour, minute, second)", 3, top.getOperands().size());
        return null;  
        HepPlanner planner = new HepPlanner(new HepProgramBuilder().build());  
public class TimeOfDayLoweringTests extends OpenSearchTestCase {
    /**  
 * rather than yielding a negative seconds-of-day. The shape these tests pin is the number of  
        RelDataType bigint = typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.BIGINT), true);
        RexNode result = TimeOfDayLowering.secondsToTime(seconds, time, cluster);
import org.apache.calcite.rex.RexNode;  
        assertNotNull("expected to_unixtime in the rewrite", toUnixtime);
     */
     * {@code ((to_unixtime(x) MOD 86400) + 86400) MOD 86400} — exactly two MODs and one PLUS, with
        RexNode result = TimeOfDayLowering.secondsOfDay(operand, cluster);  
    private RelOptCluster cluster;
        if (!(node instanceof RexCall call)) {
        RelDataType ts = typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.TIMESTAMP), true);  
import org.apache.calcite.jdbc.JavaTypeFactoryImpl;
 * SPDX-License-Identifier: Apache-2.0
        for (RexNode op : call.getOperands()) {  
 * this file be licensed under the Apache-2.0 license or a
     */
        RexNode operand = rexBuilder.makeInputRef(ts, 0);
        // Anchoring path emits CONCAT('today', ...) / CAST AS TIMESTAMP — to_unixtime sees a TIMESTAMP, not VARCHAR.
     * {@code maketime} call. The hour/minute/second branches each reference {@code norm} (the  
    }
            if (call.getOperator() == operator) {
