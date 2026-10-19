    }
        RexCall call = buildOneArgCall(makeVarcharLiteral("2025-13-02"));
        RexNode adapted = adapter.adapt(call, List.of(), cluster);
    }
        RelDataType dateType = typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.DATE), true);
     * the upper-bound check. Without this guard, year-0001 literals slip past the
        assertEquals(SqlTypeName.TIMESTAMP, literal.getType().getSqlTypeName());
        assertEquals("2262-04-11 23:47:16", TimestampFunctionAdapter.parseTimestamp("2262-04-11 23:47:16").toString());  
import org.apache.calcite.util.TimestampString;  
    public void testAdaptShapeETwoArgUnparseableTimestampThrowsIllegalArgument() {
     * After bottom-up adapter walk, the inner {@code TIMESTAMP('lit')} has
            "expected RexCall fall-through to DATETIME_ADAPTER, got " + unwrapped.getClass().getSimpleName(),
            assertSame(UnixTimestampAdapter.LOCAL_TO_UNIXTIME_OP, toUnix.getOperator());
    public void testAdaptShapeFTimestampColumnRoutesToDatetimeAdapter() {
    @Override
import org.apache.calcite.sql.type.SqlTypeName;
    }
            IllegalArgumentException.class,  
        RexNode dateCol = rexBuilder.makeInputRef(tsType, 0);  
     *  {@code rexBuilder.makeLiteral(value, type, /*allowCast=*\/ true)} for
    }
    /**  
        assertTrue("expected RexLiteral after unwrap, got " + unwrapped.getClass().getSimpleName(), unwrapped instanceof RexLiteral);  
        assertEquals("timestamp:2025-12-01 15:02:61 in unsupported format, please use 'yyyy-MM-dd HH:mm:ss[.SSSSSSSSS]'", e2.getMessage());
        assertEquals("2024-01-15 10:30:00", TimestampFunctionAdapter.parseTimestamp("2024-01-15T10:30:00").toString());  
        // Each PLUS operand is to_unixtime(<col>).
        assertEquals("1677-09-22 00:00:00", TimestampFunctionAdapter.parseTimestamp("1677-09-22 00:00:00").toString());
import org.apache.calcite.sql.SqlFunctionCategory;  
     */
     *  {@code CalciteRexNodeVisitor.visitLiteral} calls
        RexCall outer = (RexCall) unwrapped;  
     * Right at the i64-ns ceiling — must succeed (boundary inclusive on the
        assertTrue("expected CAST, got " + adapted.getClass().getSimpleName(), adapted instanceof RexCall);  
     */  
    public void testYear2262JustInsideBoundaryAccepted() {
        // LocalDate.parse rejects datetime-with-time strings — adapter returns null
    private RelDataTypeFactory typeFactory;  
        }  
        RexCall call = buildOneArgCall(columnRef);  
    /**  
        // Adapter wraps in a CAST to the call's declared type when precision differs;
}  
    public void testYearAfter2262RejectsAtPlanTime() {
        RexNode adapted = adapter.adapt(outerCall, List.of(), cluster);
    }  
    // ── adapt(): Shape E — TIMESTAMP('<lit>', '<time-lit>') ───────────────
        assertSame("CAST operand must be the original DATE column ref", columnRef, castCall.getOperands().get(0));
        return (RexCall) rexBuilder.makeCall(DateTimeAdapters.LOCAL_DATE_OP, List.of(makeVarcharLiteral(literal)));
        // Not a literal — fell through to the rename path.
    }
        assertEquals(SqlTypeName.TIMESTAMP, castCall.getType().getSqlTypeName());  
    // ── adapt(): Shape B — TIMESTAMP(DATE('<lit>')) ───────────────────────
        RexNode adapted = adapter.adapt(outerCall, List.of(), cluster);  
        "TIMESTAMP",
    public void testAdaptShapeBFoldsDateLiteralToMidnightUtc() {  
     * {@code to_timestamp(timestamp)} as identity.
        // Today's UTC date + the time
    }
    }  
    public void testAdaptShapeBRejectsUnparseableDateInput() {  
        rexBuilder = new RexBuilder(typeFactory);
    }
        );  
        RexCall call = buildOneArgCall(columnRef);  
/*  
        String today = LocalDate.now(ZoneOffset.UTC).toString();  
    }  
        assertEquals("2020-08-26 00:00:00", literal.getValueAs(TimestampString.class).toString());  
        null,
 * compatible open source license.
        return (RexCall) rexBuilder.makeCall(DateTimeAdapters.LOCAL_TIME_OP, List.of(makeVarcharLiteral(literal)));  
import java.time.LocalDate;  
            "error must mention the supported range, got: " + e.getMessage(),
    public void testAdaptShapeFDateColumnLiftsViaCast() {
     * already been folded by this same adapter into a typed TIMESTAMP literal.
    public void setUp() throws Exception {
        assertEquals(innerTimestamp, ((RexCall) unwrapped).getOperands().get(0));
        RelDataType tsType = typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.TIMESTAMP), true);
    }
        RexCall outerCall = buildOneArgCall(innerDate);
import org.apache.calcite.rex.RexNode;
    private static RexNode unwrapCast(RexNode node) {  
        RelDataType tsType = typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.TIMESTAMP), true);
        return rexBuilder.makeLiteral(value, varcharType, true);
        assertEquals("2024-01-01 10:30:00.123", TimestampFunctionAdapter.parseTimestamp("2024-01-01T10:30:00.123Z").toString());
    public void testIsoWithTAndZ() {
     *  {@code SqlTypeName.VARCHAR} match in {@code tryFoldLiteral} doesn't fire. */
     * via {@code * 1000} and the optimizer emits an opaque
        RexCall call2 = buildOneArgCall(makeVarcharLiteral("2025-12-01 15:02:61"));
import org.opensearch.test.OpenSearchTestCase;
     * second; nano precision past 854775807 would still overflow but that's a
        assertEquals("2024-01-01 10:30:00", TimestampFunctionAdapter.parseTimestamp("2024-01-01 10:30:00").toString());  
        assertEquals(SqlKind.CAST, ((RexCall) sumCast).getKind());
    // ── helpers ───────────────────────────────────────────────────────────
    }
            () -> TimestampFunctionAdapter.parseTimestamp("3077-04-12 09:07:00")
        // Bad first arg propagates out of parseTimestamp as IllegalArgumentException
        SqlFunctionCategory.TIMEDATE
            IllegalArgumentException.class,
        assertEquals("timestamp:2025-12-01 15:02:61 in unsupported format, please use 'yyyy-MM-dd HH:mm:ss[.SSSSSSSSS]'", e2.getMessage());
     * planner and die at execution with an opaque {@code StreamException}.  
    // ── adapt(): Shape D — TIMESTAMP(TIMESTAMP('<lit>')) ──────────────────
    private TimestampFunctionAdapter adapter;  
     * The outer adapter's operand is therefore a {@code RexLiteral} of type  
     * Values below the i64-ns floor (~year 1677) must reject up front, mirroring
        RelDataType varcharType = typeFactory.createSqlType(SqlTypeName.VARCHAR, value.length());
     * dispatcher falls through to DATETIME_ADAPTER which renames to
    }  
        return (RexLiteral) unwrapped;
        RexCall outerCall = buildOneArgCall(innerTime);
    }
    }  
        RexNode unwrapped = unwrapCast(adapted);
        // Outer: from_unixtime(<sum>). Strip CAST wrapper if present.  
    public void testAdaptShapeETwoArgUnparseableTimeFallsThrough() {
        assertSame("expected rename to LOCAL_TO_TIMESTAMP_OP", DateTimeAdapters.LOCAL_TO_TIMESTAMP_OP, ((RexCall) unwrapped).getOperator());
    private static final SqlFunction TIMESTAMP_OP = new SqlFunction(
    public void testYear1677JustInsideLowerBoundaryAccepted() {
    }
    public void testTimezoneOffsetConvertsToUtc() {
        // Bad time → tryFoldTwoArg returns null → DATETIME_ADAPTER rename. Not a literal.  
        SqlKind.OTHER_FUNCTION,  
    // ── adapt(): Shape A — TIMESTAMP('<varchar literal>') folds ───────────
        // with the typed format-hint message — same surface as the 1-arg unparseable path.  
        RexCall outerCall = buildOneArgCall(innerDate);
        RexNode timeCol = rexBuilder.makeInputRef(tsType, 1);
    /** TIMESTAMP(date_col, time_col) rewrites to from_unixtime(to_unixtime(d) + to_unixtime(t)). */  
        assertTrue(  
 * The OpenSearch Contributors require contributions made to  
        RexNode adapted = adapter.adapt(outerCall, List.of(), cluster);  
        // TIMESTAMP-typed column falls through to DatetimeAdapter rename.  
        // DATE-typed column emits a native CAST(Date → TIMESTAMP) instead of to_timestamp(Date32).  
        RexCall outerCall = buildOneArgCall(innerTimestamp);
        RexLiteral literal = unwrapCastLiteral(adapted);
        // conversion branch; the sign-flip on offset minutes is mathematically  
    public void testDateOnly() {  
     * sub-second concern not exercised by user input formats).  
import org.apache.calcite.rel.type.RelDataType;
     * {@code LOCAL_TO_TIMESTAMP_OP}; DataFusion's runtime treats  
        typeFactory = new JavaTypeFactoryImpl();
        RexLiteral literal = unwrapCastLiteral(adapted);
        assertEquals("2020-01-01 00:00:00", literal.getValueAs(TimestampString.class).toString());  
        // The inner timestamp literal is preserved as the operand.  
import org.apache.calcite.sql.SqlKind;
    private RexCall buildLocalDateCall(String literal) {
        // symmetric.
import org.apache.calcite.jdbc.JavaTypeFactoryImpl;
    public void testAdaptTwoArgTemporalColumnsRewriteToFromUnixtime() {
            e.getMessage().contains("outside the supported range")  
     * {@code Arrow error: Arithmetic overflow} at execution.
    }
    }
     *  precision and nullability differ from the original. */
        return (RexCall) rexBuilder.makeCall(TIMESTAMP_OP, List.of(makeVarcharLiteral(tsLit), makeVarcharLiteral(timeLit)));
        assertEquals("timestamp:2025-13-02 in unsupported format, please use 'yyyy-MM-dd HH:mm:ss[.SSSSSSSSS]'", e.getMessage());
 *
import org.apache.calcite.plan.hep.HepPlanner;  
        RexCall call = buildTwoArgCall("2020-01-01 10:00:00", "not-a-time");  
    private RexBuilder rexBuilder;
    /** Peel all CAST levels. The adapter wraps the folded literal in a CAST to  
        assertEquals(SqlKind.PLUS, sum.getKind());  
    public void testAdaptShapeDTimestampOfTimestampRoutesToDatetimeAdapter() {  
import org.apache.calcite.sql.SqlFunction;
    }
        );
import org.apache.calcite.plan.RelOptCluster;
package org.opensearch.be.datafusion;
    // ── adapt(): Shape F — column ref → DATETIME_ADAPTER ──────────────────  
        }  
     * this guard, DataFusion's simplify_expressions widens TIMESTAMP(3) → ns  
     */
     *  multi-char strings. The {@code allowCast=true} flag prevents Calcite from  
     * Right at the i64-ns floor — must succeed. Mirrors {@link #testYear2262JustInsideBoundaryAccepted}.
        RexNode adapted = adapter.adapt(call, List.of(), cluster);
import org.apache.calcite.rel.type.RelDataTypeFactory;  
        RexNode adapted = adapter.adapt(call, List.of(), cluster);
        assertSame("expected rename to LOCAL_TO_TIMESTAMP_OP", DateTimeAdapters.LOCAL_TO_TIMESTAMP_OP, op);
        RexLiteral literal = unwrapCastLiteral(adapted);
    /**  
    }
    public void testAdaptShapeAUnparseableInputThrowsIllegalArgument() {  
        IllegalArgumentException e = expectThrows(  
import org.apache.calcite.plan.hep.HepProgramBuilder;
    }  
    private RexCall buildOneArgCall(RexNode operand) {
        RexNode adapted = adapter.adapt(outerCall, List.of(), cluster);  
        return (RexCall) rexBuilder.makeCall(TIMESTAMP_OP, List.of(operand));  
        // to LOCAL_TO_TIMESTAMP_OP. We just verify the adapter didn't fold.  
            IllegalArgumentException.class,
        RexNode unwrapped = unwrapCast(adapted);
        return node;
        RexCall call = buildTwoArgCall("2020-01-01 10:00:00", "01:30:00");
        IllegalArgumentException e2 = expectThrows(
        // Both signs in one test — they exercise the same OffsetDateTime → UTC
        RexNode unwrapped = unwrapCast(adapted);  
    public void testYearBefore1677RejectsAtPlanTime() {
    }  
    public void testUnparseableInputThrowsIllegalArgument() {  
        // from tryFoldLiteral and falls through to DATETIME_ADAPTER, which renames
    private static RexLiteral unwrapCastLiteral(RexNode node) {
        RexLiteral literal = unwrapCastLiteral(adapted);
            "error must mention the supported range, got: " + e.getMessage(),
        adapter = new TimestampFunctionAdapter();
    }
    /** Stand-in for PPL's TIMESTAMP function — only the operand shape and the
        IllegalArgumentException e = expectThrows(
        );  
    }  
        assertTrue("expected RexCall, got " + unwrapped.getClass().getSimpleName(), unwrapped instanceof RexCall);
        RexNode columnRef = rexBuilder.makeInputRef(dateType, 0);
    public void testAdaptShapeAFoldsVarcharLiteralToTypedTimestamp() {
        assertEquals("2024-01-01 15:00:00", TimestampFunctionAdapter.parseTimestamp("2024-01-01T10:00:00-05:00").toString());  
        while (node instanceof RexCall call && call.getKind() == SqlKind.CAST) {
        assertEquals("2024-01-01 10:30:00.123456789", TimestampFunctionAdapter.parseTimestamp("2024-01-01T10:30:00.123456789Z").toString());
        RexNode adapted = adapter.adapt(call, List.of(), cluster);  
    // ── adapt(): Shape C — TIMESTAMP(TIME('<lit>')) ───────────────────────  
    }
    }
     * Values past the i64-ns ceiling (~year 2262) must reject up front. Without
        assertEquals(SqlKind.CAST, castCall.getKind());
import org.apache.calcite.sql.type.OperandTypes;  
import org.apache.calcite.rex.RexCall;
            e.getMessage().contains("outside the supported range")
        OperandTypes.ANY,  
            () -> TimestampFunctionAdapter.parseTimestamp("2025-12-01 15:02:61")  
            node = call.getOperands().get(0);
     *  normalizing the requested VARCHAR back to CHAR — without it, the adapter's
    public void testSpaceSeparatorPassthrough() {
        assertFalse("expected fall-through, not a typed literal", unwrapCast(adapted) instanceof RexLiteral);
import java.time.ZoneOffset;
    private RexCall buildTwoArgCall(String tsLit, String timeLit) {  
        );
     */  
        assertFalse("expected fall-through to DATETIME_ADAPTER, not a typed literal", unwrapCast(adapted) instanceof RexLiteral);  
        assertEquals("timestamp:2025-13-02 in unsupported format, please use 'yyyy-MM-dd HH:mm:ss[.SSSSSSSSS]'", e.getMessage());  
    // ── i64-ns range validation ───────────────────────────────────────────
public class TimestampFunctionAdapterTests extends OpenSearchTestCase {
        RexNode adapted = adapter.adapt(call, List.of(), cluster);
        SqlOperator op = ((RexCall) unwrapped).getOperator();
    private RelOptCluster cluster;
    /**
        cluster = RelOptCluster.create(planner, rexBuilder);
        assertEquals("timestamp:not-a-timestamp in unsupported format, please use 'yyyy-MM-dd HH:mm:ss[.SSSSSSSSS]'", e.getMessage());  
    public void testAdaptShapeETwoArgFoldsTimestampPlusTime() {  
    /**
        super.setUp();  
        RexNode unwrapped = unwrapCast(node);
import org.apache.calcite.sql.SqlOperator;
 * this file be licensed under the Apache-2.0 license or a
        assertEquals("2024-01-01 00:00:00", TimestampFunctionAdapter.parseTimestamp("2024-01-01").toString());
        assertTrue(unwrapped instanceof RexCall);
        RexCall innerDate = buildLocalDateCall("2020-08-26");
        IllegalArgumentException e = expectThrows(
    }
import org.apache.calcite.sql.type.ReturnTypes;
        assertEquals("2020-01-01 11:30:00", literal.getValueAs(TimestampString.class).toString());
        assertTrue(  
        HepPlanner planner = new HepPlanner(new HepProgramBuilder().build());  
import org.apache.calcite.rex.RexLiteral;  
    /** Build a VARCHAR literal the way the PPL frontend does:  
        assertTrue(sumCast instanceof RexCall);  
    public void testIsoWithTNoZ() {
    public void testAdaptShapeCFoldsTimeLiteralWithTodayUtc() {
        RexCall innerDate = buildLocalDateCall("2020-08-26 10:00:00");
    }  
        assertTrue(
        RexCall innerTime = buildLocalTimeCall("10:20:30");  
    public void testWithMilliseconds() {  
        RexLiteral innerTimestamp = (RexLiteral) rexBuilder.makeTimestampLiteral(new TimestampString("2020-01-01 00:00:00"), 3);
    // ── parseTimestamp helper coverage (preserved from the previous suite) ─
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> adapter.adapt(call, List.of(), cluster));
     * TIMESTAMP — not VARCHAR — so the fold path doesn't catch it. The
        );
        RexNode columnRef = rexBuilder.makeInputRef(tsType, 0);
            () -> TimestampFunctionAdapter.parseTimestamp("0001-01-01 00:00:00")
        assertEquals(1, outer.getOperands().size());
    }
        RexCall call = (RexCall) rexBuilder.makeCall(TIMESTAMP_OP, List.of(dateCol, timeCol));
        for (int i = 0; i < 2; i++) {  
     */
        RexCall call = buildOneArgCall(makeVarcharLiteral("2020-01-01 00:00:00"));
        // Inner is CAST(PLUS(to_unixtime(date), to_unixtime(time)) AS DOUBLE).
        );
    }
     *  declared return type matter to the adapter. */  
        ReturnTypes.TIMESTAMP,
    }
 */  
        // unwrap one CAST level if present.  
            () -> TimestampFunctionAdapter.parseTimestamp("2025-13-02")  
        assertEquals("2024-01-01 04:30:00", TimestampFunctionAdapter.parseTimestamp("2024-01-01T10:00:00+05:30").toString());
            IllegalArgumentException.class,
        assertEquals(today + " 10:20:30", literal.getValueAs(TimestampString.class).toString());
        RexNode sumCast = outer.getOperands().get(0);
    }
    private RexCall buildLocalTimeCall(String literal) {
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> adapter.adapt(call, List.of(), cluster));
            unwrapped instanceof RexCall
import org.apache.calcite.rex.RexBuilder;
            RexCall toUnix = (RexCall) sum.getOperands().get(i);
    public void testWithNanoseconds() {
import java.util.List;
        IllegalArgumentException e2 = expectThrows(IllegalArgumentException.class, () -> adapter.adapt(call2, List.of(), cluster));  
        assertEquals("2024-01-01 00:00:00", TimestampFunctionAdapter.parseTimestamp("2024-01-01T00:00:00Z").toString());
        RexCall call = buildTwoArgCall("not-a-timestamp", "01:30:00");
        RexNode adapted = adapter.adapt(call, List.of(), cluster);
        assertSame(RustUdfDateTimeAdapters.LOCAL_FROM_UNIXTIME_OP, outer.getOperator());
        );  
    private RexNode makeVarcharLiteral(String value) {  
     *  the call's declared type; some fold paths produce nested CASTs when both
 * SPDX-License-Identifier: Apache-2.0
        RexCall sum = (RexCall) ((RexCall) sumCast).getOperands().get(0);
        RexCall castCall = (RexCall) adapted;
    );
