 * {@code to_timestamp(to_date(...))} chain that DataFusion can't execute on
     * widening a TIMESTAMP(3) to TIMESTAMP(9) via {@code * 1000}), surfacing as
        }
        throw new IllegalArgumentException(  
import java.time.Instant;
    /**
                    return null;
        RexNode operand = stripOperatorAnnotation(original.getOperands().get(0));
        }
        // adapter walk, the inner DATE/TIME has been renamed by DateAdapter /
        // The dual-format toleration matches legacy {@code ExprTimestampValue} parsing — the
     *
        RexNode op1 = stripOperatorAnnotation(original.getOperands().get(1));  
        rejectIfOutsideI64NsRange(ldt);  
import java.time.LocalTime;
        if (tsValue == null || timeValue == null) {  
     *       {@link TimestampString} value back to {@link LocalDateTime}.</li>  
            return LocalDate.parse(input).atStartOfDay();  
     * which calls {@code exprAddTime}.
                return rexBuilder.makeTimestampLiteral(toTimestampString(midnight), foldPrecision(midnight, precision));
     */
        if (!(op0 instanceof RexLiteral lit0) || lit0.getType().getSqlTypeName() != SqlTypeName.VARCHAR) {
        try {
import org.apache.calcite.sql.SqlOperator;
/**
        (int) Math.floorMod(Long.MIN_VALUE, 1_000_000_000L),
                LocalTime time;  
import org.apache.calcite.sql.SqlKind;  
                LocalDateTime midnight = date.atStartOfDay();  
    }  
 *       <td>works</td></tr>
     * literal for plan-time folds. Without it, a TIMESTAMP-typed (or CAST-wrapped) shape
    }
 * the surrounding Project's rowType matches.  
        if (typeName == SqlTypeName.CHAR || typeName == SqlTypeName.VARCHAR) {  
        }
 *   <tr><td>B</td>  
 * this file be licensed under the Apache-2.0 license or a
 *       <td>plan-time fold (varchar literal)</td>
        }
                    return null;
     * {@code ExprTimeValue} / {@code TimestampFunction}.  
        }
     */
            } catch (RuntimeException unused) {
        if (operand.getType().getSqlTypeName() != SqlTypeName.DATE) {
        } catch (DateTimeParseException ignored) {}
    private static final LocalDateTime I64_NS_MIN = LocalDateTime.ofEpochSecond(  
            return wrapWithCallType(folded, original, cluster);  
     * {@link LocalDateTime} so callers doing calendar math (TIMESTAMPADD, TIMESTAMPDIFF,  
        RexNode op0 = stripOperatorAnnotation(original.getOperands().get(0));
     * into typed TIMESTAMP literals, matching legacy semantics from the SQL
            return LocalDateTime.ofInstant(Instant.parse(input), ZoneOffset.UTC);
            || tn == SqlTypeName.DATE
     *   <li>TIMESTAMP-typed {@link RexLiteral} — Calcite's {@code RexBuilder.makeCast} on  
                return parseLocalDateTime(value);
    /**  
        null,
            return null;  
    private static int resolvePrecision(List<FieldStorageInfo> fieldStorage) {
        }
        if (typeName == SqlTypeName.TIMESTAMP || typeName == SqlTypeName.TIMESTAMP_WITH_LOCAL_TIME_ZONE) {  
            addTime = parseTimeOfDay(timeValue);  
    }
            if (ts == null) return null;
     *
    private static RexNode tryCombineTimestampPlusTime(RexCall original, RelOptCluster cluster) {
     */
        // SQL plugin's renderer emits space-separated, but user literals frequently arrive as
 *           {@code TimestampFunction.timestamp(props, dt, addTime) = exprAddTime}</td>  
                return LocalDateTime.parse(input.replace(' ', 'T'));  
import org.apache.calcite.plan.RelOptCluster;
import java.time.ZoneOffset;
     */
 *       <td>plan-time fold (TIME-of-literal): combine time with today's UTC date,
 *   <tr><td>A</td>
 *       <td>{@code TIMESTAMP(DATE('2020-08-26'))}</td>
    }  
     * silently in DataFusion's optimizer (e.g. {@code simplify_expressions}
        RexNode dateLifted = tryLiftDateOperand(original, cluster);
    }  
     * Project's rowType matches.
     * parsing fails — caller falls through to the non-literal rewrite path.
        }
    }  
 *   <caption>TIMESTAMP shape coverage</caption>  
            && innerCall.getOperands().size() == 1
     * ISO-8601. Mirrors the previous adapter's fall-through chain so cherry-picked  
/*  
            TimestampString ts = lit.getValueAs(TimestampString.class);
        } catch (DateTimeParseException e) {
 *  
            .createTypeWithNullability(rexBuilder.getTypeFactory().createSqlType(SqlTypeName.DOUBLE), true);
 *       <td>{@code TIMESTAMP(TIMESTAMP('lit'))}</td>
import java.time.LocalDateTime;
        try {
    public RexNode adapt(RexCall original, List<FieldStorageInfo> fieldStorage, RelOptCluster cluster) {  
                return null;  
 * The OpenSearch Contributors require contributions made to  
    }
        String tsValue = lit0.getValueAs(String.class);
        // Pick precision from field storage: date_nanos → 9, otherwise default to 3  
    /**
            && innerLiteral.getType().getSqlTypeName() == SqlTypeName.VARCHAR) {  
        return rexBuilder.makeTimestampLiteral(toTimestampString(sum), foldPrecision(sum, precision));
        if (original.getOperands().size() != 1) {
     * Recover a literal {@link LocalDateTime} from an adapter operand that may already be a  
import org.opensearch.analytics.spi.FieldStorageInfo;
     * Parses the first arg as a timestamp, the second as a time-of-day,
     */  
     * cases that used to work still work.
     * timestamp-shaped form (a raw VARCHAR literal, a folded TIMESTAMP literal, or a
     * (TIMESTAMPADD literal fold) share one rendering site — the i64-ns range check
                } catch (DateTimeParseException e) {  
        RexNode sumFp = rexBuilder.makeCast(fp64, sum, true);
 *
     */
            return null;
 */  
     * Pick a precision for fold output. {@code date_nanos} fields force 9  
            String.format(java.util.Locale.ROOT, "timestamp:%s in unsupported format, please use 'yyyy-MM-dd HH:mm:ss[.SSSSSSSSS]'", input)
        if (operand instanceof RexCall innerCall  
        RexBuilder rexBuilder = cluster.getRexBuilder();
     * Render a {@link LocalDateTime} as a Calcite {@link TimestampString}, preserving  
 * compatible open source license.
     * {@code ExprTimestampValue}: {@code yyyy-MM-dd HH:mm:ss[.SSSSSSSSS]} and
            // Sub-ms inputs need precision ≥6 — makeTimestampLiteral truncates the value to the precision.
     * stays here so it isn't bypassed.  
    private static RexNode tryFoldTwoArg(RexCall original, int precision, RexBuilder rexBuilder) {
     *       a varchar literal folds inline to a typed literal, so the wrapper RexCall is
     * everything else defaults to 3 (millisecond), which is wide enough for
     * <p>Returns {@code null} when the call shape isn't a foldable literal —
 *   <tr><td>C</td>
 *       <td>works</td></tr>  
            && stripOperatorAnnotation(innerCall.getOperands().get(0)) instanceof RexLiteral innerLiteral
        if (!(op1 instanceof RexLiteral lit1) || lit1.getType().getSqlTypeName() != SqlTypeName.VARCHAR) {
 *       <td>works</td></tr>
        Long.MAX_VALUE / 1_000_000_000L,
            return chosen;
     * The analytics-engine route serializes TIMESTAMP values as i64 nanoseconds
    );
     * Lift the chosen RexNode to the call's declared type so the surrounding  
     * <p>Bounds are the exact i64-ns ends — {@code Long.MAX_VALUE} ns is  
            ldt.getDayOfMonth(),
            return LocalDateTime.parse(input);  
     * {@code 1677-09-21 00:12:43.145224192 UTC}. Lower-bound rejection is
    /** TIMESTAMP(date col, time col) -> from_unixtime(to_unixtime(date) + to_unixtime(time)). */
        }  
     * matching Shape B's literal fold. Returns {@code null} for non-DATE operands.
            ts = ts.withNanos(nanos);
class TimestampFunctionAdapter implements ScalarFunctionAdapter {
        RexNode op1 = stripOperatorAnnotation(original.getOperands().get(1));
        for (FieldStorageInfo field : fieldStorage) {  
                LocalDateTime ldt = LocalDateTime.of(today, time);
        Math.floorDiv(Long.MIN_VALUE, 1_000_000_000L),
    /**
 *   <tr><th>Shape</th><th>Example</th><th>Path</th><th>Status</th></tr>
        RexNode combined = tryCombineTimestampPlusTime(original, cluster);  
        } catch (DateTimeParseException ignored) {}  
 *
        if (!isTemporal(op0) || !isTemporal(op1)) {
     * Parse a varchar timestamp literal in the formats accepted by legacy
        }
 *           {@link DateTimeAdapters.DatetimeAdapter} which renames to DataFusion's
        if (original.getOperands().size() != 2) {  
            return rexBuilder.makeTimestampLiteral(toTimestampString(ldt), foldPrecision(ldt, precision));  
        try {  
            return null;
 * </table>
                return parseLocalDateTime(ts.toString());
    static TimestampString toTimestampString(LocalDateTime ldt) {
     * {@code makeTimestampLiteral(value, precision)} truncates the value to {@code precision}
                return null;
     * {@code TimestampFunction.timestamp(properties, datetime, addTime)}
    /**
    /**
            }
    private static RexNode tryLiftDateOperand(RexCall original, RelOptCluster cluster) {  
        if (folded != null) {
     */
        return ts;
                return 9;
    }
 *           {@link DateTimeAdapters.DatetimeAdapter} → DataFusion builtin
            } catch (DateTimeParseException ignored) {}
     * adds the time onto the timestamp. Matches legacy  
        return rexBuilder.makeCall(RustUdfDateTimeAdapters.LOCAL_FROM_UNIXTIME_OP, sumFp);  
                return null;
                return formatter == null ? LocalTime.parse(input) : LocalTime.parse(input, formatter);
                return null;  
        }
            return null;
 *       <td>plan-time fold (DATE-of-literal): combine date with 00:00:00 UTC,
     * brittle space-vs-T separator handling that goes with it.
import org.apache.calcite.rex.RexBuilder;
 *           second as time-of-day, add. Matches
     * Bump fold precision to 6 when the input carries non-zero sub-millisecond digits.  
     * plugin's {@code ExprTimestampValue} / {@code ExprDateValue} /
 *       <td>operand is {@code RexInputRef}; fold doesn't catch. Routes to
                try {
    }
            String value = lit.getValueAs(String.class);
import java.util.List;  
        try {
 *       <td>{@code TIMESTAMP('2020-01-01 00:00:00')}</td>  
    private static final DateTimeAdapters.DatetimeAdapter DATETIME_ADAPTER = new DateTimeAdapters.DatetimeAdapter();  
        return wrapWithCallType(DATETIME_ADAPTER.adapt(original, fieldStorage, cluster), original, cluster);
                return rexBuilder.makeTimestampLiteral(toTimestampString(ldt), foldPrecision(ldt, precision));
    private static LocalTime parseTimeOfDay(String input) {
            LocalDateTime ldt = parseLocalDateTime(value);
 *           matches {@code ExprTimeValue.timestampValue} </td>
    }
            try {  
        if (ldt.isAfter(I64_NS_MAX) || ldt.isBefore(I64_NS_MIN)) {
            // Shape B: TIMESTAMP(DATE('lit')) — combine date with 00:00:00 UTC.
            return null;
    /**
     * Returns {@code null} for non-literal shapes (column refs, expressions) or when
            return dateLifted;
        if (original.getOperands().size() != 1) {
        return cluster.getRexBuilder().makeAbstractCast(original.getType(), chosen);
     */  
     * <ul>  
        // (millisecond). Using ms-precision for the common case keeps the folded
            return null;  
        return node;
        }  
     * up front with a clear message so users see the limit at plan time.
        }
 *       <td>{@link #parseTimestamp} throws {@code IllegalArgumentException}
 *       <td>rejects with HTTP 400</td></tr>
        if (input.contains(" ") && !input.contains("T")) {
 *       <td>inner Shape A fold collapses the call into a typed TIMESTAMP literal;  
 *       <td>{@code TIMESTAMP('2020-01-01 10:00:00', '01:30:00')}</td>  
            String innerValue = innerLiteral.getValueAs(String.class);
            } catch (DateTimeParseException ignored) {}
            throw new IllegalArgumentException("timestamp " + ldt + " is outside the supported range");
     * Same accept-set as {@link #parseTimestamp(String)} but returns the parsed value as a
        );
            return null;
            return LocalDateTime.ofInstant(OffsetDateTime.parse(input).toInstant(), ZoneOffset.UTC);
    private static RexNode tryFoldLiteral(RexCall original, List<FieldStorageInfo> fieldStorage, RelOptCluster cluster) {
        SqlTypeName tn = node.getType().getSqlTypeName();
     * precision decision is keyed off the source {@link LocalDateTime}'s nano-of-second instead.
        while (node instanceof OperatorAnnotation annotation && annotation.unwrap() != null) {
     * (nanosecond) precision so values can compare equal to native ts values;
     * </ul>  
        LocalDateTime base = parseLocalDateTime(tsValue);  
    );
            // Shape C: TIMESTAMP(TIME('lit')) — combine time with today's UTC date.
 *   <tr><td>F</td>
 *           the outer adapter sees a TIMESTAMP-typed operand, falls through to
    }  
        return ldt.getNano() % 1_000_000 == 0 ? resolved : Math.max(resolved, 6);
            }
            if (value == null) return null;
        RexNode unix0 = rexBuilder.makeCall(UnixTimestampAdapter.LOCAL_TO_UNIXTIME_OP, op0);  
        java.time.format.DateTimeFormatter.ofPattern("HH:mm:ss", java.util.Locale.ROOT),
            }
        java.time.format.DateTimeFormatter.ofPattern("HH:mm", java.util.Locale.ROOT) };  
        ZoneOffset.UTC  
        return tn == SqlTypeName.TIMESTAMP
        }  
    /**
import org.apache.calcite.rex.RexCall;  
     *       gone by the time the adapter sees it. Convert the literal's
    private static boolean isTemporal(RexNode node) {  
     * etc.) avoid the {@code TimestampString → String → LocalDateTime} round-trip and the
 * this stack ({@code Unsupported data type Date32 for function to_timestamp}).  
     * 1-arg {@code TIMESTAMP(<date>)} on a DATE column: emit a native CAST instead of  
    }
     */
            ldt.getHour(),
import org.opensearch.analytics.spi.ScalarFunctionAdapter;  
            try {  
import org.opensearch.analytics.planner.rel.OperatorAnnotation;
     * fractional digits, so folding {@code .123456} at the resolved precision (3) silently drops
            ldt.getMonthValue(),  
 *       <td>plan-time fold (2-arg literal-literal): parse first as timestamp,
        // Shapes B and C: TIMESTAMP(DATE/TIME(<varchar literal>)). After bottom-up  
        }
        RexNode unwrapped = node;  
        return 3;
        }  
        try {
        org.apache.calcite.rel.type.RelDataType fp64 = rexBuilder.getTypeFactory()  
            try {
    private static RexNode wrapWithCallType(RexNode chosen, RexCall original, RelOptCluster cluster) {  
            return null;  
        // literal's i64 representation well within range — TIMESTAMP(9) at year
        }  
            String value = literal.getValueAs(String.class);  
        for (java.time.format.DateTimeFormatter formatter : TIME_OF_DAY_FORMATS) {
 * SPDX-License-Identifier: Apache-2.0
 *       <td>works</td></tr>
     * sub-second nanos. Package-private so sibling adapters that compute calendar shifts
        ZoneOffset.UTC  
    /** {@code null} entry means "use {@link LocalTime#parse(CharSequence)}'s default ISO format".
            unwrapped = call.getOperands().get(0);  
        TimestampString ts = new TimestampString(
        );
            return tryFoldTwoArg(original, precision, rexBuilder);
        if (combined != null) {
            && call.getOperands().size() == 1  
            if (innerOp == DateTimeAdapters.LOCAL_TIME_OP) {
            }  
 * <p>The chosen RexNode is wrapped in a CAST to the call's declared type so
 */  
        }
 *           second-61, garbage). HTTP 400 with the bare input as the message.</td>  
 *           matches {@code ExprDateValue.timestampValue() = date.atStartOfDay(UTC)}</td>  
     *   <li>VARCHAR/CHAR {@link RexLiteral} — original PPL string literal, parse via the
     * Recognize the four nested-with-literal shapes and fold them at plan time  
        RexNode operand = stripOperatorAnnotation(original.getOperands().get(0));
import org.apache.calcite.rex.RexLiteral;
            ldt.getSecond()
        int precision = resolvePrecision(fieldStorage);
    }
            if (innerOp == DateTimeAdapters.LOCAL_DATE_OP) {
            || tn == SqlTypeName.TIME;
    /**
 * <p>The fold path bypasses runtime evaluation and avoids the
        if (operand instanceof RexLiteral literal && literal.getType().getSqlTypeName() == SqlTypeName.VARCHAR) {
    private static final java.time.format.DateTimeFormatter[] TIME_OF_DAY_FORMATS = new java.time.format.DateTimeFormatter[] {  
     * the µs digits the user typed. {@code TimestampString} exposes no nano accessor, so the  
                try {
        throw new DateTimeParseException("Unsupported time format", input, 0);
     * an opaque {@code Arrow error: Arithmetic overflow} at execution. Reject  
 *   <tr><td>E</td>
            ldt.getMinute(),  
     * {@code to_timestamp} UDF rejects (Date32 is not in its accepted-type list).
    static TimestampString parseTimestamp(String input) {  
        }
        if (nanos > 0) {
    static LocalDateTime extractLocalDateTimeLiteral(RexNode node) {
            } catch (RuntimeException unused) {
import org.apache.calcite.rex.RexNode;
        RexNode op0 = stripOperatorAnnotation(original.getOperands().get(0));  
     * Shape E: 2-arg literal-literal {@code TIMESTAMP('<datetime>', '<time>')}.
                LocalDate today = LocalDate.now(ZoneOffset.UTC);  
            SqlOperator innerOp = innerCall.getOperator();
        }  
        // PPL/MySQL-style {@code yyyy-MM-dd HH:mm:ss[.fff]} uses a space separator; ISO needs T.  
        // ISO with T from JSON tools. Both shapes round-trip through this method.  
            if (innerValue == null) {  
        // 3077 overflows i64 (max ~year 2262), TIMESTAMP(3) does not.  
 * <table>
                }
        }  
 *   <tr><td>G</td>
    private static RexNode stripOperatorAnnotation(RexNode node) {
     * symmetric with the upper bound; without it, year-0001 literals slip past  
        }  
            // padding) don't drift two parsers.  
    /**  
        LocalDateTime sum = base.plusNanos(addTime.toNanoOfDay());
        RexNode folded = tryFoldLiteral(original, fieldStorage, cluster);
        return null;  
     */
     * {@code 2262-04-11 23:47:16.854775807 UTC} and {@code Long.MIN_VALUE} ns is
                LocalDate date;  
 *       <td>{@code TIMESTAMP(<column>)}</td>  
            }  
            }  
import java.time.format.DateTimeParseException;
     * since epoch (Substrait/Arrow). Values past the i64-ns ceiling overflow  
     * the planner and die at execution with an opaque {@code StreamException}.
 * Routes PPL {@code TIMESTAMP(...)} calls to the right backend path.  
        int nanos = ldt.getNano();  
        LocalTime addTime;
     *       legacy accept-set.</li>
            return null;
                    date = LocalDate.parse(innerValue);
            if ("date_nanos".equals(field.getMappingType())) {
     * caller falls through to the DatetimeAdapter rename path.  
        // Shape A: TIMESTAMP(<varchar literal>) — parse and fold.
     * letting it lower to {@code to_timestamp(date_col)}, which DataFusion's
 *       <td>{@code TIMESTAMP(TIME('10:20:30'))}</td>  
import org.apache.calcite.util.TimestampString;  
     *  
        return toTimestampString(parseLocalDateTime(input));
     * The CAST maps to arrow's Date32 → Timestamp(Nanosecond) kernel — midnight UTC,  
        RexNode sum = rexBuilder.makeCall(org.apache.calcite.sql.fun.SqlStdOperatorTable.PLUS, unix0, unix1);
            // Calcite's TimestampString stringifies as `yyyy-MM-dd HH:mm:ss[.fff...]`. Reuse
     *  Locale-pinned formatters avoid the default-locale forbidden-api hit. */
        if (dateLifted != null) {  
        return cluster.getRexBuilder().makeAbstractCast(original.getType(), operand);
                || call.getType().getSqlTypeName() == SqlTypeName.TIMESTAMP_WITH_LOCAL_TIME_ZONE)) {
 *           builtin {@code to_timestamp(timestamp)} (identity at runtime)</td>  
 *           with the raw input when no format matches (covers month-13,
 *       <td>{@code TIMESTAMP('<bad string>')}</td>  
 *       <td>works</td></tr>
    static LocalDateTime parseLocalDateTime(String input) {
import java.time.OffsetDateTime;  
import java.time.LocalDate;  
 *   <tr><td>D</td>
            return null;
            }
    private static final LocalDateTime I64_NS_MAX = LocalDateTime.ofEpochSecond(  
     *       the CAST shape when the wrapper has nullability differences; peel it.</li>
            try {  
        return null;  
package org.opensearch.be.datafusion;
 *       <td>works for DATE / TIMESTAMP / VARCHAR columns</td></tr>
        RexNode unix1 = rexBuilder.makeCall(UnixTimestampAdapter.LOCAL_TO_UNIXTIME_OP, op1);
     */
    }  
    }
 *           {@code to_timestamp}.</td>  
    /**
        }
        // TimeAdapter to LOCAL_DATE_OP / LOCAL_TIME_OP.
    @Override
 *
        if (!(unwrapped instanceof RexLiteral lit)) {
     * {@code CAST(<varchar lit> AS TIMESTAMP)}). Recognized shapes:
     * year-of-i64-ns-overflow boundary cases (year 3077+).  
        (int) (Long.MAX_VALUE % 1_000_000_000L),
     *   <li>{@code CAST(<varchar lit> AS TIMESTAMP)} {@link RexCall} — Calcite preserves
        } catch (DateTimeParseException ignored) {}
     * would hide the literal and the fold would never fire.  
            && call.getKind() == SqlKind.CAST
                    time = LocalTime.parse(innerValue);
            node = annotation.unwrap();  
        }  
        }  
        if (chosen.getType().equals(original.getType())) {
        }  
 *
            ldt.getYear(),
            || tn == SqlTypeName.TIMESTAMP_WITH_LOCAL_TIME_ZONE  
        RexBuilder rexBuilder = cluster.getRexBuilder();
    private static void rejectIfOutsideI64NsRange(LocalDateTime ldt) {  
        } catch (DateTimeParseException ignored) {}
                }
    private static int foldPrecision(LocalDateTime ldt, int resolved) {  
        }
            return wrapWithCallType(combined, original, cluster);
}
            && (call.getType().getSqlTypeName() == SqlTypeName.TIMESTAMP
                } catch (DateTimeParseException e) {  
        if (original.getOperands().size() == 2) {
     * <p>Sibling adapters (TIMESTAMPADD, TIMESTAMPDIFF) call this to recover the original
            if (value == null) {
        SqlTypeName typeName = lit.getType().getSqlTypeName();
import org.apache.calcite.sql.type.SqlTypeName;
        if (unwrapped instanceof RexCall call
 * @opensearch.internal
    }
        String timeValue = lit1.getValueAs(String.class);
            // the shared accept-set so future renderer changes (precision tweaks, sub-second
