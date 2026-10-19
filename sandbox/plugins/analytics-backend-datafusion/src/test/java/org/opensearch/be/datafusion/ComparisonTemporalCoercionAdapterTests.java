        RexCall adapted = (RexCall) adapter.adapt(original, List.of(), cluster);
        RexCall original = eq(castTime, ts);
            DateTimeAdapters.LOCAL_TO_TIMESTAMP_OP,
        RexCall adapted = (RexCall) adapter.adapt(original, List.of(), cluster);
        RexNode castTime = rexBuilder.makeCast(typeFactory.createSqlType(SqlTypeName.TIMESTAMP), timeRef);
        RexCall adapted = (RexCall) adapter.adapt(original, List.of(), cluster);
 * The OpenSearch Contributors require contributions made to
        );
    /** TIME vs TIMESTAMP: TIME side rewritten to today-anchored TIMESTAMP, TIMESTAMP side untouched. */
        RexCall original = eq(field(SqlTypeName.TIME), field(SqlTypeName.TIME));
package org.opensearch.be.datafusion;
     */
        return rexBuilder.makeInputRef(typeFactory.createSqlType(name), 0);
    public void testTimeVsTimePassesThrough() {
        assertNotSame("wrapped TIME must trigger the coercion path", original, adapted);
        RexCall original = eq(varchar, ts);
            typeFactory.createSqlType(SqlTypeName.TIMESTAMP),
        assertSame("wrapped DATE peer must not be re-rewritten", wrappedDate, adapted.getOperands().get(1));
import org.apache.calcite.rex.RexCall;
     * {@code to_timestamp(time)} to align with a DATE peer — that's the actual production input
     * adapter's {@code unwrapToTime} also recognises CAST as a single-operand wrapper.
    }
        assertNotSame("wrapped DATE peer must still trigger TIME-side coercion", original, adapted);
        assertNotSame(original, adapted);
import org.opensearch.test.OpenSearchTestCase;
        assertSame(SqlTypeName.TIMESTAMP, newLeft.getType().getSqlTypeName());
        RexNode date = field(SqlTypeName.DATE);
     */
    public void testTimeVsToTimestampWrappedDateCoerces() {
        assertSame(SqlTypeName.TIMESTAMP, newRight.getType().getSqlTypeName());
/** Unit tests for {@link ComparisonTemporalCoercionAdapter}. */
 * this file be licensed under the Apache-2.0 license or a
import org.apache.calcite.sql.fun.SqlStdOperatorTable;
import org.apache.calcite.sql.SqlKind;
        RexCall adapted = (RexCall) adapter.adapt(original, List.of(), cluster);
        RexNode dateRef = field(SqlTypeName.DATE);
        RexCall original = eq(field(SqlTypeName.DATE), field(SqlTypeName.TIMESTAMP));
        RexCall adapted = (RexCall) adapter.adapt(original, List.of(), cluster);
        RexNode time = field(SqlTypeName.TIME);
     * Calcite's binary-comparison type-coercion wraps the TIME side with
     * still has to recognise it as a temporal peer to fire the TIME-side rewrite.
    /** DATE vs TIMESTAMP — Substrait already binds; passthrough. */
    }
        assertSame("TIMESTAMP side must not be rewritten", ts, adapted.getOperands().get(1));
        return (RexCall) rexBuilder.makeCall(SqlStdOperatorTable.EQUALS, List.of(l, r));
        RexCall original = eq(time, date);
        RexNode newLeft = adapted.getOperands().get(0);
public class ComparisonTemporalCoercionAdapterTests extends OpenSearchTestCase {
     * The DATE/TIMESTAMP peer can also arrive wrapped (e.g. {@code to_timestamp(date)}); the adapter
import org.apache.calcite.jdbc.JavaTypeFactoryImpl;
    /** TIME vs DATE: same path — TIME rewritten, DATE untouched. */
    private final RelOptCluster cluster = RelOptCluster.create(new VolcanoPlanner(), rexBuilder);
        assertSame(SqlTypeName.TIMESTAMP, adapted.getOperands().get(0).getType().getSqlTypeName());
    public void testCastWrappedTimeVsTimestampCoerces() {
/*
        assertSame(SqlTypeName.TIMESTAMP, adapted.getOperands().get(0).getType().getSqlTypeName());
     */
    /** TIMESTAMP vs TIME: symmetric case, only TIME side is rewritten. */
        RexNode date = field(SqlTypeName.DATE);
        assertSame("DATE peer must not be rewritten", date, adapted.getOperands().get(1));
        assertNotSame(original, adapted);
    }
            List.of(dateRef)
    public void testToTimestampWrappedTimeVsDateCoerces() {
    }
 * SPDX-License-Identifier: Apache-2.0
        RexCall original = eq(time, wrappedDate);
        RexNode time = field(SqlTypeName.TIME);
        assertNotSame("CAST-wrapped TIME must trigger the coercion path", original, adapted);
     * {@code CAST(time AS TIMESTAMP)} is the other wrapped form Calcite's coercion may emit. The
     * shape (not a raw TIME ref). The adapter must unwrap to find the inner TIME and rewrite it.
        assertEquals(SqlKind.CAST, newLeft.getKind());
import org.apache.calcite.sql.type.SqlTypeName;
        RexNode timeRef = field(SqlTypeName.TIME);
        RexCall adapted = (RexCall) adapter.adapt(original, List.of(), cluster);
        RexCall adapted = (RexCall) adapter.adapt(original, List.of(), cluster);
        assertSame(ts, adapted.getOperands().get(1));
        assertSame(date, adapted.getOperands().get(1));
        assertNotSame(original, adapted);
    public void testVarcharVsTimestampStillCoerced() {
import org.apache.calcite.rex.RexNode;
    private final RelDataTypeFactory typeFactory = new JavaTypeFactoryImpl();
    public void testDateVsTimestampPassesThrough() {
 */
    public void testTimestampVsTimeCoercesTimeSide() {
}
    }
    }
        RexCall adapted = (RexCall) adapter.adapt(original, List.of(), cluster);
    public void testTimeVsTimestampCoercesTimeSide() {
        RexCall original = eq(ts, time);
        assertSame(SqlTypeName.TIMESTAMP, adapted.getOperands().get(0).getType().getSqlTypeName());
    /** Numeric-vs-numeric — adapter is registered against comparison ops generically; non-temporal calls pass through. */
        RexNode time = field(SqlTypeName.TIME);
        assertSame(original, adapted);
            typeFactory.createSqlType(SqlTypeName.TIMESTAMP),
    /** TIME vs TIME — load-bearing guard preserves the native comparison. */
 *
            DateTimeAdapters.LOCAL_TO_TIMESTAMP_OP,
        );
    private RexNode field(SqlTypeName name) {
        assertEquals(SqlKind.CAST, newRight.getKind());
import org.apache.calcite.plan.volcano.VolcanoPlanner;
    public void testNumericComparisonPassesThrough() {
import org.apache.calcite.rel.type.RelDataTypeFactory;
import org.apache.calcite.plan.RelOptCluster;
        RexCall original = eq(wrappedTime, date);
        RexNode newRight = adapted.getOperands().get(1);
    /** VARCHAR vs TIMESTAMP — pre-existing char-vs-temporal branch still fires after the TIME branch addition. */
    private RexCall eq(RexNode l, RexNode r) {
import java.util.List;
        RexCall adapted = (RexCall) adapter.adapt(original, List.of(), cluster);
    }
        RexNode wrappedTime = rexBuilder.makeCall(
        RexCall adapted = (RexCall) adapter.adapt(original, List.of(), cluster);
        RexNode ts = field(SqlTypeName.TIMESTAMP);
    /**
    }
        RexNode varchar = field(SqlTypeName.VARCHAR);
    public void testTimeVsDateCoercesTimeSide() {
    private final ComparisonTemporalCoercionAdapter adapter = new ComparisonTemporalCoercionAdapter();
    }
        assertSame(original, adapted);
        RexCall original = eq(time, ts);
        assertSame(original, adapted);
    }
        RexNode wrappedDate = rexBuilder.makeCall(
        RexNode ts = field(SqlTypeName.TIMESTAMP);
    /**
import org.apache.calcite.rex.RexBuilder;
        assertSame("TIMESTAMP side must not be rewritten", ts, adapted.getOperands().get(0));
        RexNode timeRef = field(SqlTypeName.TIME);
    /**
        assertSame(SqlTypeName.TIMESTAMP, adapted.getOperands().get(0).getType().getSqlTypeName());
        RexNode ts = field(SqlTypeName.TIMESTAMP);
        assertNotSame(original, adapted);
        assertSame(ts, adapted.getOperands().get(1));
    private final RexBuilder rexBuilder = new RexBuilder(typeFactory);
    }
        RexNode time = field(SqlTypeName.TIME);
    }
        RexNode ts = field(SqlTypeName.TIMESTAMP);
 * compatible open source license.
        RexCall original = eq(field(SqlTypeName.INTEGER), field(SqlTypeName.INTEGER));
        assertSame(SqlTypeName.TIMESTAMP, adapted.getOperands().get(0).getType().getSqlTypeName());
            List.of(timeRef)
