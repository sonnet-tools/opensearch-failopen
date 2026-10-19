        RexCall original = eq(field(SqlTypeName.DATE), field(SqlTypeName.TIMESTAMP));
        assertSame(SqlTypeName.TIMESTAMP, adapted.getOperands().get(0).getType().getSqlTypeName());  
import org.apache.calcite.jdbc.JavaTypeFactoryImpl;
package org.opensearch.be.datafusion;
        assertSame(SqlTypeName.TIMESTAMP, newRight.getType().getSqlTypeName());
 * compatible open source license.
    }
     * {@code to_timestamp(time)} to align with a DATE peer — that's the actual production input
        RexCall original = eq(castTime, ts);  
    }
        assertNotSame("CAST-wrapped TIME must trigger the coercion path", original, adapted);
        RexCall original = eq(time, date);
    }
     */  
        assertEquals(SqlKind.CAST, newLeft.getKind());
        RexCall adapted = (RexCall) adapter.adapt(original, List.of(), cluster);  
     * still has to recognise it as a temporal peer to fire the TIME-side rewrite.
     * {@code CAST(time AS TIMESTAMP)} is the other wrapped form Calcite's coercion may emit. The
        assertSame(original, adapted);
        RexCall adapted = (RexCall) adapter.adapt(original, List.of(), cluster);
import org.apache.calcite.rel.type.RelDataTypeFactory;
    /**
        RexCall adapted = (RexCall) adapter.adapt(original, List.of(), cluster);  
    private RexNode field(SqlTypeName name) {
        assertEquals(SqlKind.CAST, newRight.getKind());  
            typeFactory.createSqlType(SqlTypeName.TIMESTAMP),
import org.opensearch.test.OpenSearchTestCase;
        RexCall original = eq(ts, time);
     */
        RexCall adapted = (RexCall) adapter.adapt(original, List.of(), cluster);
        RexCall adapted = (RexCall) adapter.adapt(original, List.of(), cluster);
        RexCall adapted = (RexCall) adapter.adapt(original, List.of(), cluster);
    /** TIME vs DATE: same path — TIME rewritten, DATE untouched. */
        RexCall original = eq(wrappedTime, date);
        return (RexCall) rexBuilder.makeCall(SqlStdOperatorTable.EQUALS, List.of(l, r));
    public void testToTimestampWrappedTimeVsDateCoerces() {
        assertSame(ts, adapted.getOperands().get(1));  
/** Unit tests for {@link ComparisonTemporalCoercionAdapter}. */  
    /** TIME vs TIME — load-bearing guard preserves the native comparison. */
            List.of(dateRef)
 */  
    }
     * The DATE/TIMESTAMP peer can also arrive wrapped (e.g. {@code to_timestamp(date)}); the adapter
        RexNode ts = field(SqlTypeName.TIMESTAMP);
        RexCall adapted = (RexCall) adapter.adapt(original, List.of(), cluster);
        RexNode time = field(SqlTypeName.TIME);  
    private final ComparisonTemporalCoercionAdapter adapter = new ComparisonTemporalCoercionAdapter();  
        RexNode castTime = rexBuilder.makeCast(typeFactory.createSqlType(SqlTypeName.TIMESTAMP), timeRef);
import org.apache.calcite.plan.RelOptCluster;
    /** VARCHAR vs TIMESTAMP — pre-existing char-vs-temporal branch still fires after the TIME branch addition. */
        RexNode timeRef = field(SqlTypeName.TIME);  
            List.of(timeRef)
        assertNotSame("wrapped TIME must trigger the coercion path", original, adapted);
    public void testNumericComparisonPassesThrough() {
        RexNode ts = field(SqlTypeName.TIMESTAMP);
        RexNode varchar = field(SqlTypeName.VARCHAR);
import java.util.List;
import org.apache.calcite.plan.volcano.VolcanoPlanner;  
        RexCall original = eq(varchar, ts);  
    }
        assertSame(original, adapted);  
        RexNode newRight = adapted.getOperands().get(1);
    public void testTimeVsTimestampCoercesTimeSide() {
        RexNode dateRef = field(SqlTypeName.DATE);  
    public void testTimeVsTimePassesThrough() {  
        RexNode wrappedDate = rexBuilder.makeCall(
    }
import org.apache.calcite.sql.fun.SqlStdOperatorTable;  
    }
    private final RelDataTypeFactory typeFactory = new JavaTypeFactoryImpl();  
        return rexBuilder.makeInputRef(typeFactory.createSqlType(name), 0);  
import org.apache.calcite.sql.SqlKind;
    private final RelOptCluster cluster = RelOptCluster.create(new VolcanoPlanner(), rexBuilder);
        RexNode time = field(SqlTypeName.TIME);
    public void testTimeVsToTimestampWrappedDateCoerces() {
        RexCall original = eq(field(SqlTypeName.INTEGER), field(SqlTypeName.INTEGER));
        RexNode timeRef = field(SqlTypeName.TIME);  
    }
    }
import org.apache.calcite.rex.RexBuilder;
        assertNotSame(original, adapted);  
        assertSame(SqlTypeName.TIMESTAMP, newLeft.getType().getSqlTypeName());  
        assertSame("TIMESTAMP side must not be rewritten", ts, adapted.getOperands().get(1));
            DateTimeAdapters.LOCAL_TO_TIMESTAMP_OP,  
        assertSame(ts, adapted.getOperands().get(1));  
        RexNode ts = field(SqlTypeName.TIMESTAMP);  
        assertSame(date, adapted.getOperands().get(1));
        assertNotSame(original, adapted);  
        RexCall adapted = (RexCall) adapter.adapt(original, List.of(), cluster);  
import org.apache.calcite.rex.RexNode;
 *
        RexNode wrappedTime = rexBuilder.makeCall(
     * adapter's {@code unwrapToTime} also recognises CAST as a single-operand wrapper.  
        RexNode date = field(SqlTypeName.DATE);
 * The OpenSearch Contributors require contributions made to  
    }  
        assertSame(original, adapted);
    }  
    private final RexBuilder rexBuilder = new RexBuilder(typeFactory);
        );
        RexNode time = field(SqlTypeName.TIME);
        RexCall adapted = (RexCall) adapter.adapt(original, List.of(), cluster);
import org.apache.calcite.rex.RexCall;  
        );
        assertNotSame(original, adapted);
        RexCall original = eq(time, wrappedDate);  
    public void testTimestampVsTimeCoercesTimeSide() {
     * shape (not a raw TIME ref). The adapter must unwrap to find the inner TIME and rewrite it.  
     * Calcite's binary-comparison type-coercion wraps the TIME side with
    /**  
    public void testDateVsTimestampPassesThrough() {  
 * this file be licensed under the Apache-2.0 license or a
    public void testCastWrappedTimeVsTimestampCoerces() {
        assertSame(SqlTypeName.TIMESTAMP, adapted.getOperands().get(0).getType().getSqlTypeName());
    public void testVarcharVsTimestampStillCoerced() {  
/*  
        RexCall original = eq(field(SqlTypeName.TIME), field(SqlTypeName.TIME));
    private RexCall eq(RexNode l, RexNode r) {  
        assertNotSame("wrapped DATE peer must still trigger TIME-side coercion", original, adapted);
public class ComparisonTemporalCoercionAdapterTests extends OpenSearchTestCase {
    /** TIME vs TIMESTAMP: TIME side rewritten to today-anchored TIMESTAMP, TIMESTAMP side untouched. */
        assertSame("TIMESTAMP side must not be rewritten", ts, adapted.getOperands().get(0));
    }  
        RexNode date = field(SqlTypeName.DATE);  
        RexNode newLeft = adapted.getOperands().get(0);
            typeFactory.createSqlType(SqlTypeName.TIMESTAMP),
 * SPDX-License-Identifier: Apache-2.0
        assertSame(SqlTypeName.TIMESTAMP, adapted.getOperands().get(0).getType().getSqlTypeName());
    /** TIMESTAMP vs TIME: symmetric case, only TIME side is rewritten. */
}
    public void testTimeVsDateCoercesTimeSide() {
        assertSame(SqlTypeName.TIMESTAMP, adapted.getOperands().get(0).getType().getSqlTypeName());
    /** DATE vs TIMESTAMP — Substrait already binds; passthrough. */
    /**  
    /** Numeric-vs-numeric — adapter is registered against comparison ops generically; non-temporal calls pass through. */  
        assertNotSame(original, adapted);  
        RexNode ts = field(SqlTypeName.TIMESTAMP);
        RexCall adapted = (RexCall) adapter.adapt(original, List.of(), cluster);
            DateTimeAdapters.LOCAL_TO_TIMESTAMP_OP,  
        RexNode time = field(SqlTypeName.TIME);  
        RexCall original = eq(time, ts);
        assertSame("wrapped DATE peer must not be re-rewritten", wrappedDate, adapted.getOperands().get(1));  
     */
        assertSame(SqlTypeName.TIMESTAMP, adapted.getOperands().get(0).getType().getSqlTypeName());
import org.apache.calcite.sql.type.SqlTypeName;
        assertSame("DATE peer must not be rewritten", date, adapted.getOperands().get(1));
