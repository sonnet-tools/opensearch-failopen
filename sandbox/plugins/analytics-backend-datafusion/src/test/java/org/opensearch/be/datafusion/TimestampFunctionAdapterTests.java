import org.apache.calcite.util.TimestampString;
        // unwrap one CAST level if present.
        RexCall innerDate = buildLocalDateCall("2020-08-26");
    public void testYear2262JustInsideBoundaryAccepted() {
     * {@code LOCAL_TO_TIMESTAMP_OP}; DataFusion's runtime treats
public class TimestampFunctionAdapterTests extends OpenSearchTestCase {
        // to LOCAL_TO_TIMESTAMP_OP. We just verify the adapter didn't fold.
        assertTrue(unwrapped instanceof RexCall);
package org.opensearch.be.datafusion;
        RexNode adapted = adapter.adapt(call, List.of(), cluster);
        RexNode adapted = adapter.adapt(call, List.of(), cluster);
            () -> TimestampFunctionAdapter.parseTimestamp("0001-01-01 00:00:00")
 * SPDX-License-Identifier: Apache-2.0
        }
        assertEquals("timestamp:2025-13-02 in unsupported format, please use 'yyyy-MM-dd HH:mm:ss[.SSSSSSSSS]'", e.getMessage());
        super.setUp();
    // ── adapt(): Shape A — TIMESTAMP('<varchar literal>') folds ───────────
    }
    }
        RexNode adapted = adapter.adapt(call, List.of(), cluster);
        assertEquals("2024-01-01 15:00:00", TimestampFunctionAdapter.parseTimestamp("2024-01-01T10:00:00-05:00").toString());
        RexCall call2 = buildOneArgCall(makeVarcharLiteral("2025-12-01 15:02:61"));
            e.getMessage().contains("outside the supported range")
        RexCall call = buildTwoArgCall("2020-01-01 10:00:00", "01:30:00");
import org.apache.calcite.sql.type.ReturnTypes;
            e.getMessage().contains("outside the supported range")
        RexCall call = (RexCall) rexBuilder.makeCall(TIMESTAMP_OP, List.of(dateCol, timeCol));
    // ── adapt(): Shape E — TIMESTAMP('<lit>', '<time-lit>') ───────────────
    public void testAdaptShapeAFoldsVarcharLiteralToTypedTimestamp() {
        // Bad time → tryFoldTwoArg returns null → DATETIME_ADAPTER rename. Not a literal.
        RexCall outer = (RexCall) unwrapped;
    public void testAdaptShapeAUnparseableInputThrowsIllegalArgument() {
     *  {@code CalciteRexNodeVisitor.visitLiteral} calls
        // DATE-typed column emits a native CAST(Date → TIMESTAMP) instead of to_timestamp(Date32).
        adapter = new TimestampFunctionAdapter();
    public void testAdaptShapeFDateColumnLiftsViaCast() {
        RexNode unwrapped = unwrapCast(adapted);
        RexCall outerCall = buildOneArgCall(innerTime);
import org.apache.calcite.rex.RexCall;
        RexLiteral literal = unwrapCastLiteral(adapted);
            "error must mention the supported range, got: " + e.getMessage(),
        rexBuilder = new RexBuilder(typeFactory);
        assertEquals("2024-01-15 10:30:00", TimestampFunctionAdapter.parseTimestamp("2024-01-15T10:30:00").toString());
            IllegalArgumentException.class,
import org.apache.calcite.rel.type.RelDataType;
import java.time.LocalDate;
    }
    }
        RexCall call = buildOneArgCall(columnRef);
    }
    public void testIsoWithTNoZ() {
    public void testAdaptShapeETwoArgFoldsTimestampPlusTime() {
        // Inner is CAST(PLUS(to_unixtime(date), to_unixtime(time)) AS DOUBLE).
    public void testAdaptShapeBRejectsUnparseableDateInput() {
        assertEquals(SqlTypeName.TIMESTAMP, castCall.getType().getSqlTypeName());
    public void testAdaptShapeETwoArgUnparseableTimestampThrowsIllegalArgument() {
    private RexCall buildLocalTimeCall(String literal) {
        RexNode unwrapped = unwrapCast(adapted);
        RexCall castCall = (RexCall) adapted;
     * TIMESTAMP — not VARCHAR — so the fold path doesn't catch it. The
    public void testYearBefore1677RejectsAtPlanTime() {
    }
        );
    public void testAdaptShapeETwoArgUnparseableTimeFallsThrough() {
            () -> TimestampFunctionAdapter.parseTimestamp("3077-04-12 09:07:00")
    private RexCall buildLocalDateCall(String literal) {
        assertSame("expected rename to LOCAL_TO_TIMESTAMP_OP", DateTimeAdapters.LOCAL_TO_TIMESTAMP_OP, ((RexCall) unwrapped).getOperator());
        RelDataType varcharType = typeFactory.createSqlType(SqlTypeName.VARCHAR, value.length());
            node = call.getOperands().get(0);
        );
        return (RexCall) rexBuilder.makeCall(DateTimeAdapters.LOCAL_TIME_OP, List.of(makeVarcharLiteral(literal)));
 * compatible open source license.
 *
     * {@code to_timestamp(timestamp)} as identity.
     *  precision and nullability differ from the original. */
    }
    public void testAdaptShapeDTimestampOfTimestampRoutesToDatetimeAdapter() {
        // Adapter wraps in a CAST to the call's declared type when precision differs;
        cluster = RelOptCluster.create(planner, rexBuilder);
        assertFalse("expected fall-through, not a typed literal", unwrapCast(adapted) instanceof RexLiteral);
        // with the typed format-hint message — same surface as the 1-arg unparseable path.
        // LocalDate.parse rejects datetime-with-time strings — adapter returns null
        RexNode adapted = adapter.adapt(call, List.of(), cluster);
    }
    }
        RexNode sumCast = outer.getOperands().get(0);
        // from tryFoldLiteral and falls through to DATETIME_ADAPTER, which renames
        assertFalse("expected fall-through to DATETIME_ADAPTER, not a typed literal", unwrapCast(adapted) instanceof RexLiteral);
import org.apache.calcite.sql.type.OperandTypes;
     * dispatcher falls through to DATETIME_ADAPTER which renames to
    // ── parseTimestamp helper coverage (preserved from the previous suite) ─
    public void testIsoWithTAndZ() {
    /**
    private static RexLiteral unwrapCastLiteral(RexNode node) {
        for (int i = 0; i < 2; i++) {
        assertTrue(
            "expected RexCall fall-through to DATETIME_ADAPTER, got " + unwrapped.getClass().getSimpleName(),
            () -> TimestampFunctionAdapter.parseTimestamp("2025-12-01 15:02:61")
    private RelOptCluster cluster;
     * via {@code * 1000} and the optimizer emits an opaque
        assertEquals("timestamp:2025-13-02 in unsupported format, please use 'yyyy-MM-dd HH:mm:ss[.SSSSSSSSS]'", e.getMessage());
    private static final SqlFunction TIMESTAMP_OP = new SqlFunction(
    public void testAdaptShapeFTimestampColumnRoutesToDatetimeAdapter() {
        RexNode adapted = adapter.adapt(outerCall, List.of(), cluster);
        assertEquals("timestamp:2025-12-01 15:02:61 in unsupported format, please use 'yyyy-MM-dd HH:mm:ss[.SSSSSSSSS]'", e2.getMessage());
        SqlFunctionCategory.TIMEDATE
        RexNode adapted = adapter.adapt(call, List.of(), cluster);
        assertEquals(today + " 10:20:30", literal.getValueAs(TimestampString.class).toString());
        IllegalArgumentException e = expectThrows(
    /**
    // ── helpers ───────────────────────────────────────────────────────────
            IllegalArgumentException.class,
import org.opensearch.test.OpenSearchTestCase;
        // Today's UTC date + the time
        RexCall call = buildTwoArgCall("2020-01-01 10:00:00", "not-a-time");
        assertEquals("2024-01-01 00:00:00", TimestampFunctionAdapter.parseTimestamp("2024-01-01T00:00:00Z").toString());
    );
     */
        assertTrue("expected RexLiteral after unwrap, got " + unwrapped.getClass().getSimpleName(), unwrapped instanceof RexLiteral);
        );
        OperandTypes.ANY,
        );
        ReturnTypes.TIMESTAMP,
     *  multi-char strings. The {@code allowCast=true} flag prevents Calcite from
        RexNode columnRef = rexBuilder.makeInputRef(tsType, 0);
        return (RexCall) rexBuilder.makeCall(TIMESTAMP_OP, List.of(makeVarcharLiteral(tsLit), makeVarcharLiteral(timeLit)));
import org.apache.calcite.sql.SqlFunctionCategory;
        );
        assertEquals("1677-09-22 00:00:00", TimestampFunctionAdapter.parseTimestamp("1677-09-22 00:00:00").toString());
    // ── adapt(): Shape B — TIMESTAMP(DATE('<lit>')) ───────────────────────
        return rexBuilder.makeLiteral(value, varcharType, true);
    @Override
        RelDataType tsType = typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.TIMESTAMP), true);
        RexCall outerCall = buildOneArgCall(innerDate);
     *  the call's declared type; some fold paths produce nested CASTs when both
     * already been folded by this same adapter into a typed TIMESTAMP literal.
        // Each PLUS operand is to_unixtime(<col>).
    }
     * Values below the i64-ns floor (~year 1677) must reject up front, mirroring
        assertEquals("2020-08-26 00:00:00", literal.getValueAs(TimestampString.class).toString());
        assertEquals("timestamp:not-a-timestamp in unsupported format, please use 'yyyy-MM-dd HH:mm:ss[.SSSSSSSSS]'", e.getMessage());
    }
        // symmetric.
        null,
        RexCall call = buildOneArgCall(makeVarcharLiteral("2020-01-01 00:00:00"));
    }
        RexLiteral literal = unwrapCastLiteral(adapted);
        RexLiteral literal = unwrapCastLiteral(adapted);
        RexCall sum = (RexCall) ((RexCall) sumCast).getOperands().get(0);
        assertEquals("2262-04-11 23:47:16", TimestampFunctionAdapter.parseTimestamp("2262-04-11 23:47:16").toString());
        // Not a literal — fell through to the rename path.
        RexCall outerCall = buildOneArgCall(innerTimestamp);
}
    }
    }
     * second; nano precision past 854775807 would still overflow but that's a
        // Both signs in one test — they exercise the same OffsetDateTime → UTC
        RexNode dateCol = rexBuilder.makeInputRef(tsType, 0);
    public void testTimezoneOffsetConvertsToUtc() {
    public void testAdaptShapeBFoldsDateLiteralToMidnightUtc() {
        assertEquals(innerTimestamp, ((RexCall) unwrapped).getOperands().get(0));
        RexCall call = buildOneArgCall(columnRef);
    private RexNode makeVarcharLiteral(String value) {
    /** Build a VARCHAR literal the way the PPL frontend does:
    /**
        );
        // Bad first arg propagates out of parseTimestamp as IllegalArgumentException
 */
    }
        assertTrue(sumCast instanceof RexCall);
    }
        RexCall innerDate = buildLocalDateCall("2020-08-26 10:00:00");
     */
        RexCall outerCall = buildOneArgCall(innerDate);
        assertEquals("2024-01-01 04:30:00", TimestampFunctionAdapter.parseTimestamp("2024-01-01T10:00:00+05:30").toString());
import org.apache.calcite.sql.SqlFunction;
    /**
        RexCall innerTime = buildLocalTimeCall("10:20:30");
        assertEquals("2024-01-01 00:00:00", TimestampFunctionAdapter.parseTimestamp("2024-01-01").toString());
        typeFactory = new JavaTypeFactoryImpl();
    // ── adapt(): Shape D — TIMESTAMP(TIMESTAMP('<lit>')) ──────────────────
     * Values past the i64-ns ceiling (~year 2262) must reject up front. Without
        return (RexLiteral) unwrapped;
        assertSame("expected rename to LOCAL_TO_TIMESTAMP_OP", DateTimeAdapters.LOCAL_TO_TIMESTAMP_OP, op);
        HepPlanner planner = new HepPlanner(new HepProgramBuilder().build());
        RexNode adapted = adapter.adapt(call, List.of(), cluster);
     *  declared return type matter to the adapter. */
        assertEquals("2020-01-01 00:00:00", literal.getValueAs(TimestampString.class).toString());
        assertEquals(1, outer.getOperands().size());
    }
    public void testAdaptTwoArgTemporalColumnsRewriteToFromUnixtime() {
            () -> TimestampFunctionAdapter.parseTimestamp("2025-13-02")
import org.apache.calcite.rel.type.RelDataTypeFactory;
        assertEquals("2024-01-01 10:30:00.123", TimestampFunctionAdapter.parseTimestamp("2024-01-01T10:30:00.123Z").toString());
            unwrapped instanceof RexCall
    private static RexNode unwrapCast(RexNode node) {
        RexNode columnRef = rexBuilder.makeInputRef(dateType, 0);
     */
        RexCall call = buildTwoArgCall("not-a-timestamp", "01:30:00");
        IllegalArgumentException e = expectThrows(
    }
        RexNode adapted = adapter.adapt(outerCall, List.of(), cluster);
    }
    }
     * The outer adapter's operand is therefore a {@code RexLiteral} of type
        assertEquals("timestamp:2025-12-01 15:02:61 in unsupported format, please use 'yyyy-MM-dd HH:mm:ss[.SSSSSSSSS]'", e2.getMessage());
    public void testYear1677JustInsideLowerBoundaryAccepted() {
    }
    /** Peel all CAST levels. The adapter wraps the folded literal in a CAST to
        assertEquals("2024-01-01 10:30:00", TimestampFunctionAdapter.parseTimestamp("2024-01-01 10:30:00").toString());
        assertSame("CAST operand must be the original DATE column ref", columnRef, castCall.getOperands().get(0));
import org.apache.calcite.sql.SqlKind;
import org.apache.calcite.rex.RexBuilder;
        assertSame(RustUdfDateTimeAdapters.LOCAL_FROM_UNIXTIME_OP, outer.getOperator());
        RexNode unwrapped = unwrapCast(node);
     * the upper-bound check. Without this guard, year-0001 literals slip past the
    // ── adapt(): Shape F — column ref → DATETIME_ADAPTER ──────────────────
        RexLiteral innerTimestamp = (RexLiteral) rexBuilder.makeTimestampLiteral(new TimestampString("2020-01-01 00:00:00"), 3);
    }
     * sub-second concern not exercised by user input formats).
        assertEquals(SqlTypeName.TIMESTAMP, literal.getType().getSqlTypeName());
    }
    /** TIMESTAMP(date_col, time_col) rewrites to from_unixtime(to_unixtime(d) + to_unixtime(t)). */
import java.time.ZoneOffset;
     * Right at the i64-ns floor — must succeed. Mirrors {@link #testYear2262JustInsideBoundaryAccepted}.
    // ── i64-ns range validation ───────────────────────────────────────────
import org.apache.calcite.jdbc.JavaTypeFactoryImpl;
import org.apache.calcite.rex.RexLiteral;
        return (RexCall) rexBuilder.makeCall(TIMESTAMP_OP, List.of(operand));
     */
        assertTrue("expected CAST, got " + adapted.getClass().getSimpleName(), adapted instanceof RexCall);
        }
    public void setUp() throws Exception {
    private RelDataTypeFactory typeFactory;
import org.apache.calcite.rex.RexNode;
        SqlKind.OTHER_FUNCTION,
        SqlOperator op = ((RexCall) unwrapped).getOperator();
        assertEquals("2020-01-01 11:30:00", literal.getValueAs(TimestampString.class).toString());
        IllegalArgumentException e = expectThrows(
        // conversion branch; the sign-flip on offset minutes is mathematically
        // The inner timestamp literal is preserved as the operand.
import org.apache.calcite.plan.hep.HepProgramBuilder;
        );
import org.apache.calcite.sql.type.SqlTypeName;
        RexNode adapted = adapter.adapt(outerCall, List.of(), cluster);
     * planner and die at execution with an opaque {@code StreamException}.
        // Outer: from_unixtime(<sum>). Strip CAST wrapper if present.
        RexNode adapted = adapter.adapt(outerCall, List.of(), cluster);
        assertTrue("expected RexCall, got " + unwrapped.getClass().getSimpleName(), unwrapped instanceof RexCall);
        IllegalArgumentException e2 = expectThrows(
     * this guard, DataFusion's simplify_expressions widens TIMESTAMP(3) → ns
        assertEquals("2024-01-01 10:30:00.123456789", TimestampFunctionAdapter.parseTimestamp("2024-01-01T10:30:00.123456789Z").toString());
        RexNode unwrapped = unwrapCast(adapted);
    public void testAdaptShapeCFoldsTimeLiteralWithTodayUtc() {
        RexCall call = buildOneArgCall(makeVarcharLiteral("2025-13-02"));
import java.util.List;
    // ── adapt(): Shape C — TIMESTAMP(TIME('<lit>')) ───────────────────────
    /** Stand-in for PPL's TIMESTAMP function — only the operand shape and the
            assertSame(UnixTimestampAdapter.LOCAL_TO_UNIXTIME_OP, toUnix.getOperator());
    }
            RexCall toUnix = (RexCall) sum.getOperands().get(i);
    public void testUnparseableInputThrowsIllegalArgument() {
    }
    }
        assertTrue(
     *  {@code SqlTypeName.VARCHAR} match in {@code tryFoldLiteral} doesn't fire. */
        RelDataType tsType = typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.TIMESTAMP), true);
        // TIMESTAMP-typed column falls through to DatetimeAdapter rename.
    }
    public void testYearAfter2262RejectsAtPlanTime() {
     * Right at the i64-ns ceiling — must succeed (boundary inclusive on the
            IllegalArgumentException.class,
    }
 * this file be licensed under the Apache-2.0 license or a
    }
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> adapter.adapt(call, List.of(), cluster));
        assertEquals(SqlKind.PLUS, sum.getKind());
        String today = LocalDate.now(ZoneOffset.UTC).toString();
    public void testDateOnly() {
        IllegalArgumentException e2 = expectThrows(IllegalArgumentException.class, () -> adapter.adapt(call2, List.of(), cluster));
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> adapter.adapt(call, List.of(), cluster));
        RelDataType dateType = typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.DATE), true);
        return node;
        while (node instanceof RexCall call && call.getKind() == SqlKind.CAST) {
        RexNode timeCol = rexBuilder.makeInputRef(tsType, 1);
    private RexCall buildOneArgCall(RexNode operand) {
    public void testWithMilliseconds() {
        "TIMESTAMP",
     */
    }
import org.apache.calcite.sql.SqlOperator;
    }
    private RexCall buildTwoArgCall(String tsLit, String timeLit) {
        RexLiteral literal = unwrapCastLiteral(adapted);
import org.apache.calcite.plan.RelOptCluster;
    private TimestampFunctionAdapter adapter;
            "error must mention the supported range, got: " + e.getMessage(),
     * {@code Arrow error: Arithmetic overflow} at execution.
        assertEquals(SqlKind.CAST, castCall.getKind());
    public void testSpaceSeparatorPassthrough() {
            IllegalArgumentException.class,
/*
 * The OpenSearch Contributors require contributions made to
        return (RexCall) rexBuilder.makeCall(DateTimeAdapters.LOCAL_DATE_OP, List.of(makeVarcharLiteral(literal)));
        assertTrue(
     *  normalizing the requested VARCHAR back to CHAR — without it, the adapter's
    private RexBuilder rexBuilder;
     * After bottom-up adapter walk, the inner {@code TIMESTAMP('lit')} has
    }
        assertEquals(SqlKind.CAST, ((RexCall) sumCast).getKind());
    public void testWithNanoseconds() {
     *  {@code rexBuilder.makeLiteral(value, type, /*allowCast=*\/ true)} for
import org.apache.calcite.plan.hep.HepPlanner;
    /**
