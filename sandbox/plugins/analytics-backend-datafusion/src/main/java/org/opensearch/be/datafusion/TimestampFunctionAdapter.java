        }
 * <table>
    @Override
    private static int foldPrecision(LocalDateTime ldt, int resolved) {
 *           {@link DateTimeAdapters.DatetimeAdapter} which renames to DataFusion's
    private static int resolvePrecision(List<FieldStorageInfo> fieldStorage) {
                return parseLocalDateTime(ts.toString());
            // Sub-ms inputs need precision ≥6 — makeTimestampLiteral truncates the value to the precision.
import java.time.ZoneOffset;
        }
    static LocalDateTime parseLocalDateTime(String input) {
            return LocalDateTime.ofInstant(OffsetDateTime.parse(input).toInstant(), ZoneOffset.UTC);
 * <p>The fold path bypasses runtime evaluation and avoids the
     * ISO-8601. Mirrors the previous adapter's fall-through chain so cherry-picked
        }
 * @opensearch.internal
     * Parse a varchar timestamp literal in the formats accepted by legacy
    /**
    private static boolean isTemporal(RexNode node) {
            // Calcite's TimestampString stringifies as `yyyy-MM-dd HH:mm:ss[.fff...]`. Reuse
     *       gone by the time the adapter sees it. Convert the literal's
                LocalDateTime ldt = LocalDateTime.of(today, time);
        // 3077 overflows i64 (max ~year 2262), TIMESTAMP(3) does not.
     * literal for plan-time folds. Without it, a TIMESTAMP-typed (or CAST-wrapped) shape
            // the shared accept-set so future renderer changes (precision tweaks, sub-second
 *       <td>works</td></tr>
            ldt.getYear(),
            ldt.getDayOfMonth(),
 *       <td>plan-time fold (varchar literal)</td>
        if (original.getOperands().size() != 1) {
        ZoneOffset.UTC
        SqlTypeName tn = node.getType().getSqlTypeName();
                return null;
        try {
     * </ul>
        if (operand.getType().getSqlTypeName() != SqlTypeName.DATE) {
            String value = lit.getValueAs(String.class);
        // ISO with T from JSON tools. Both shapes round-trip through this method.
 *           matches {@code ExprTimeValue.timestampValue} </td>
    }
        if (operand instanceof RexLiteral literal && literal.getType().getSqlTypeName() == SqlTypeName.VARCHAR) {
        if (tsValue == null || timeValue == null) {
import org.apache.calcite.rex.RexBuilder;
     * {@code TimestampFunction.timestamp(properties, datetime, addTime)}
     * Parses the first arg as a timestamp, the second as a time-of-day,
        }
import org.apache.calcite.rex.RexNode;
    }
     */
     * {@code 1677-09-21 00:12:43.145224192 UTC}. Lower-bound rejection is
        try {
        return tn == SqlTypeName.TIMESTAMP
     * symmetric with the upper bound; without it, year-0001 literals slip past
import org.apache.calcite.rex.RexCall;
            return null;
        if (typeName == SqlTypeName.CHAR || typeName == SqlTypeName.VARCHAR) {
        }
/**
 *
 * </table>
            return LocalDate.parse(input).atStartOfDay();
        LocalDateTime sum = base.plusNanos(addTime.toNanoOfDay());
    }
            return tryFoldTwoArg(original, precision, rexBuilder);
 */
        for (FieldStorageInfo field : fieldStorage) {
            // Shape C: TIMESTAMP(TIME('lit')) — combine time with today's UTC date.
     * {@code ExprTimestampValue}: {@code yyyy-MM-dd HH:mm:ss[.SSSSSSSSS]} and
        null,
            return null;
            }
    /** TIMESTAMP(date col, time col) -> from_unixtime(to_unixtime(date) + to_unixtime(time)). */
        if (original.getOperands().size() == 2) {
    private static RexNode tryFoldLiteral(RexCall original, List<FieldStorageInfo> fieldStorage, RelOptCluster cluster) {
    private static RexNode stripOperatorAnnotation(RexNode node) {
        LocalDateTime base = parseLocalDateTime(tsValue);
            && innerLiteral.getType().getSqlTypeName() == SqlTypeName.VARCHAR) {
                try {
import java.time.format.DateTimeParseException;
     * 1-arg {@code TIMESTAMP(<date>)} on a DATE column: emit a native CAST instead of
        }
 *   <tr><td>B</td>
        return ldt.getNano() % 1_000_000 == 0 ? resolved : Math.max(resolved, 6);
     * {@code ExprTimeValue} / {@code TimestampFunction}.
                LocalDate today = LocalDate.now(ZoneOffset.UTC);
            return null;
            TimestampString ts = lit.getValueAs(TimestampString.class);
     * up front with a clear message so users see the limit at plan time.
            if (value == null) return null;
     */
        // SQL plugin's renderer emits space-separated, but user literals frequently arrive as
     * Project's rowType matches.
            SqlOperator innerOp = innerCall.getOperator();
        (int) (Long.MAX_VALUE % 1_000_000_000L),
     * Pick a precision for fold output. {@code date_nanos} fields force 9
                return null;
 *       <td>works</td></tr>
    private static RexNode tryLiftDateOperand(RexCall original, RelOptCluster cluster) {
        java.time.format.DateTimeFormatter.ofPattern("HH:mm:ss", java.util.Locale.ROOT),
     * fractional digits, so folding {@code .123456} at the resolved precision (3) silently drops
        RexNode sumFp = rexBuilder.makeCast(fp64, sum, true);
        return rexBuilder.makeCall(RustUdfDateTimeAdapters.LOCAL_FROM_UNIXTIME_OP, sumFp);
     * {@code to_timestamp} UDF rejects (Date32 is not in its accepted-type list).
        RexNode op1 = stripOperatorAnnotation(original.getOperands().get(1));
    }
            }
    }
     * The analytics-engine route serializes TIMESTAMP values as i64 nanoseconds
        rejectIfOutsideI64NsRange(ldt);
            if (innerValue == null) {
                return LocalDateTime.parse(input.replace(' ', 'T'));
        } catch (DateTimeParseException ignored) {}
        // Shapes B and C: TIMESTAMP(DATE/TIME(<varchar literal>)). After bottom-up
        }
        SqlTypeName typeName = lit.getType().getSqlTypeName();
 *           {@link DateTimeAdapters.DatetimeAdapter} → DataFusion builtin
     * cases that used to work still work.
        }
        try {
            && call.getOperands().size() == 1
        }
                return parseLocalDateTime(value);
    /**
            return wrapWithCallType(folded, original, cluster);
 *           the outer adapter sees a TIMESTAMP-typed operand, falls through to
        TimestampString ts = new TimestampString(
import org.apache.calcite.util.TimestampString;
     * Same accept-set as {@link #parseTimestamp(String)} but returns the parsed value as a
 *       <td>plan-time fold (TIME-of-literal): combine time with today's UTC date,
            } catch (DateTimeParseException ignored) {}
 *   <tr><td>G</td>
 * this file be licensed under the Apache-2.0 license or a
 *   <tr><th>Shape</th><th>Example</th><th>Path</th><th>Status</th></tr>
        if (!(op0 instanceof RexLiteral lit0) || lit0.getType().getSqlTypeName() != SqlTypeName.VARCHAR) {
 * {@code to_timestamp(to_date(...))} chain that DataFusion can't execute on
        if (chosen.getType().equals(original.getType())) {
    /**
            LocalDateTime ldt = parseLocalDateTime(value);
    private static LocalTime parseTimeOfDay(String input) {
        if (!(unwrapped instanceof RexLiteral lit)) {
            && call.getKind() == SqlKind.CAST
     * the µs digits the user typed. {@code TimestampString} exposes no nano accessor, so the
            ts = ts.withNanos(nanos);
import org.apache.calcite.rex.RexLiteral;
     * (TIMESTAMPADD literal fold) share one rendering site — the i64-ns range check
 *       <td>{@code TIMESTAMP(<column>)}</td>
import org.apache.calcite.sql.SqlOperator;
            return null;
import org.apache.calcite.sql.SqlKind;
            .createTypeWithNullability(rexBuilder.getTypeFactory().createSqlType(SqlTypeName.DOUBLE), true);
            throw new IllegalArgumentException("timestamp " + ldt + " is outside the supported range");
import java.time.LocalDateTime;
                return null;
     * since epoch (Substrait/Arrow). Values past the i64-ns ceiling overflow
        return node;
 *
        if (input.contains(" ") && !input.contains("T")) {
     * caller falls through to the DatetimeAdapter rename path.
            return LocalDateTime.parse(input);
     * stays here so it isn't bypassed.
        String timeValue = lit1.getValueAs(String.class);
     * Lift the chosen RexNode to the call's declared type so the surrounding
        } catch (DateTimeParseException ignored) {}
        } catch (DateTimeParseException ignored) {}
     * <ul>
        throw new DateTimeParseException("Unsupported time format", input, 0);
        } catch (DateTimeParseException ignored) {}
        LocalTime addTime;
        }
     * {@code 2262-04-11 23:47:16.854775807 UTC} and {@code Long.MIN_VALUE} ns is
     * into typed TIMESTAMP literals, matching legacy semantics from the SQL
     * {@code CAST(<varchar lit> AS TIMESTAMP)}). Recognized shapes:
    private static final LocalDateTime I64_NS_MAX = LocalDateTime.ofEpochSecond(
        int precision = resolvePrecision(fieldStorage);
import org.apache.calcite.plan.RelOptCluster;
     * an opaque {@code Arrow error: Arithmetic overflow} at execution. Reject
     */
            try {
                    return null;
import java.time.OffsetDateTime;
        return rexBuilder.makeTimestampLiteral(toTimestampString(sum), foldPrecision(sum, precision));
                } catch (DateTimeParseException e) {
                    time = LocalTime.parse(innerValue);
    /**
        return null;
            return dateLifted;
            String.format(java.util.Locale.ROOT, "timestamp:%s in unsupported format, please use 'yyyy-MM-dd HH:mm:ss[.SSSSSSSSS]'", input)
     * would hide the literal and the fold would never fire.
     * timestamp-shaped form (a raw VARCHAR literal, a folded TIMESTAMP literal, or a
import org.opensearch.analytics.spi.FieldStorageInfo;
        int nanos = ldt.getNano();
            return rexBuilder.makeTimestampLiteral(toTimestampString(ldt), foldPrecision(ldt, precision));
            }
            && stripOperatorAnnotation(innerCall.getOperands().get(0)) instanceof RexLiteral innerLiteral
        RexNode sum = rexBuilder.makeCall(org.apache.calcite.sql.fun.SqlStdOperatorTable.PLUS, unix0, unix1);
            return chosen;
 *       <td>{@code TIMESTAMP(DATE('2020-08-26'))}</td>
            // Shape B: TIMESTAMP(DATE('lit')) — combine date with 00:00:00 UTC.
import org.opensearch.analytics.planner.rel.OperatorAnnotation;
 *       <td>{@code TIMESTAMP('2020-01-01 10:00:00', '01:30:00')}</td>
     */
    /**
        RexNode op0 = stripOperatorAnnotation(original.getOperands().get(0));
                } catch (DateTimeParseException e) {
        } catch (DateTimeParseException e) {
        if (original.getOperands().size() != 2) {
     * {@code makeTimestampLiteral(value, precision)} truncates the value to {@code precision}
 */
     * everything else defaults to 3 (millisecond), which is wide enough for
                return rexBuilder.makeTimestampLiteral(toTimestampString(midnight), foldPrecision(midnight, precision));
                LocalTime time;
            return null;
    private static RexNode tryCombineTimestampPlusTime(RexCall original, RelOptCluster cluster) {
                    return null;
        if (nanos > 0) {
                return formatter == null ? LocalTime.parse(input) : LocalTime.parse(input, formatter);
 *       <td>plan-time fold (2-arg literal-literal): parse first as timestamp,
        return cluster.getRexBuilder().makeAbstractCast(original.getType(), chosen);
class TimestampFunctionAdapter implements ScalarFunctionAdapter {
            return null;
 *           {@code TimestampFunction.timestamp(props, dt, addTime) = exprAddTime}</td>
import java.time.Instant;
                }
 *       <td>rejects with HTTP 400</td></tr>
    /**
        );
 *   <tr><td>F</td>
        }
     */
 *
        }
     * silently in DataFusion's optimizer (e.g. {@code simplify_expressions}
import org.apache.calcite.sql.type.SqlTypeName;
     * year-of-i64-ns-overflow boundary cases (year 3077+).
    static TimestampString parseTimestamp(String input) {
 * this stack ({@code Unsupported data type Date32 for function to_timestamp}).
 *
     *   <li>{@code CAST(<varchar lit> AS TIMESTAMP)} {@link RexCall} — Calcite preserves
import java.time.LocalTime;
            if ("date_nanos".equals(field.getMappingType())) {
    );
     * parsing fails — caller falls through to the non-literal rewrite path.
     */
    }
    private static final java.time.format.DateTimeFormatter[] TIME_OF_DAY_FORMATS = new java.time.format.DateTimeFormatter[] {
     * <p>Returns {@code null} when the call shape isn't a foldable literal —
        return wrapWithCallType(DATETIME_ADAPTER.adapt(original, fieldStorage, cluster), original, cluster);
            ldt.getMonthValue(),
    }
            return null;
    static LocalDateTime extractLocalDateTimeLiteral(RexNode node) {
     *   <li>VARCHAR/CHAR {@link RexLiteral} — original PPL string literal, parse via the
        while (node instanceof OperatorAnnotation annotation && annotation.unwrap() != null) {
    /**
                return 9;
            if (value == null) {
    /** {@code null} entry means "use {@link LocalTime#parse(CharSequence)}'s default ISO format".
import org.opensearch.analytics.spi.ScalarFunctionAdapter;
 *       <td>works</td></tr>
            if (ts == null) return null;
                return rexBuilder.makeTimestampLiteral(toTimestampString(ldt), foldPrecision(ldt, precision));
        return ts;
     * (nanosecond) precision so values can compare equal to native ts values;
            return null;
        return null;
    private static final DateTimeAdapters.DatetimeAdapter DATETIME_ADAPTER = new DateTimeAdapters.DatetimeAdapter();
        if (combined != null) {
        }
            try {
    }
            return null;
     */
        if (!isTemporal(op0) || !isTemporal(op1)) {
        RexBuilder rexBuilder = cluster.getRexBuilder();
        RexNode combined = tryCombineTimestampPlusTime(original, cluster);
 *   <caption>TIMESTAMP shape coverage</caption>
     * adds the time onto the timestamp. Matches legacy
    }
        // The dual-format toleration matches legacy {@code ExprTimestampValue} parsing — the
    private static RexNode tryFoldTwoArg(RexCall original, int precision, RexBuilder rexBuilder) {
        if (typeName == SqlTypeName.TIMESTAMP || typeName == SqlTypeName.TIMESTAMP_WITH_LOCAL_TIME_ZONE) {
        // Shape A: TIMESTAMP(<varchar literal>) — parse and fold.
 *   <tr><td>C</td>
            ldt.getMinute(),
        }
        }
        // (millisecond). Using ms-precision for the common case keeps the folded
            }
        if (!(op1 instanceof RexLiteral lit1) || lit1.getType().getSqlTypeName() != SqlTypeName.VARCHAR) {
     *       the CAST shape when the wrapper has nullability differences; peel it.</li>
     */
                LocalDateTime midnight = date.atStartOfDay();
    public RexNode adapt(RexCall original, List<FieldStorageInfo> fieldStorage, RelOptCluster cluster) {
     * Returns {@code null} for non-literal shapes (column refs, expressions) or when
     * <p>Sibling adapters (TIMESTAMPADD, TIMESTAMPDIFF) call this to recover the original
    static TimestampString toTimestampString(LocalDateTime ldt) {
        return 3;
        String tsValue = lit0.getValueAs(String.class);
     * {@link LocalDateTime} so callers doing calendar math (TIMESTAMPADD, TIMESTAMPDIFF,
            } catch (RuntimeException unused) {
     * widening a TIMESTAMP(3) to TIMESTAMP(9) via {@code * 1000}), surfacing as
        RexNode unix0 = rexBuilder.makeCall(UnixTimestampAdapter.LOCAL_TO_UNIXTIME_OP, op0);
     *   <li>TIMESTAMP-typed {@link RexLiteral} — Calcite's {@code RexBuilder.makeCast} on
 * compatible open source license.
        (int) Math.floorMod(Long.MIN_VALUE, 1_000_000_000L),
 *           with the raw input when no format matches (covers month-13,
    /**
     *       legacy accept-set.</li>
 *       <td>{@code TIMESTAMP('<bad string>')}</td>
    private static RexNode wrapWithCallType(RexNode chosen, RexCall original, RelOptCluster cluster) {
        RexNode unix1 = rexBuilder.makeCall(UnixTimestampAdapter.LOCAL_TO_UNIXTIME_OP, op1);
 *   <tr><td>D</td>
        // PPL/MySQL-style {@code yyyy-MM-dd HH:mm:ss[.fff]} uses a space separator; ISO needs T.
 *       <td>works</td></tr>
            // padding) don't drift two parsers.
 *       <td>inner Shape A fold collapses the call into a typed TIMESTAMP literal;
     * matching Shape B's literal fold. Returns {@code null} for non-DATE operands.
            return LocalDateTime.ofInstant(Instant.parse(input), ZoneOffset.UTC);
import java.time.LocalDate;
    }
 *           matches {@code ExprDateValue.timestampValue() = date.atStartOfDay(UTC)}</td>
    private static void rejectIfOutsideI64NsRange(LocalDateTime ldt) {
        RexNode op0 = stripOperatorAnnotation(original.getOperands().get(0));
        if (operand instanceof RexCall innerCall
     */
/*
     * letting it lower to {@code to_timestamp(date_col)}, which DataFusion's
        // Pick precision from field storage: date_nanos → 9, otherwise default to 3
     * The CAST maps to arrow's Date32 → Timestamp(Nanosecond) kernel — midnight UTC,
     */
        RexNode dateLifted = tryLiftDateOperand(original, cluster);
    }
                || call.getType().getSqlTypeName() == SqlTypeName.TIMESTAMP_WITH_LOCAL_TIME_ZONE)) {
        }
 * Routes PPL {@code TIMESTAMP(...)} calls to the right backend path.
        RexBuilder rexBuilder = cluster.getRexBuilder();
     * plugin's {@code ExprTimestampValue} / {@code ExprDateValue} /
            ldt.getSecond()
     * sub-second nanos. Package-private so sibling adapters that compute calendar shifts
            node = annotation.unwrap();
        throw new IllegalArgumentException(
    }
        }
        if (original.getOperands().size() != 1) {
        if (folded != null) {
     * Render a {@link LocalDateTime} as a Calcite {@link TimestampString}, preserving
            return null;
        RexNode folded = tryFoldLiteral(original, fieldStorage, cluster);
        }
    /**
            || tn == SqlTypeName.DATE
 *
        RexNode unwrapped = node;
                }
            || tn == SqlTypeName.TIME;
        ZoneOffset.UTC
     * Recognize the four nested-with-literal shapes and fold them at plan time
            try {
import java.util.List;
 *           second as time-of-day, add. Matches
                return null;
     * <p>Bounds are the exact i64-ns ends — {@code Long.MAX_VALUE} ns is
            && innerCall.getOperands().size() == 1
                LocalDate date;
            } catch (DateTimeParseException ignored) {}
     */
        // TimeAdapter to LOCAL_DATE_OP / LOCAL_TIME_OP.
        }
        return toTimestampString(parseLocalDateTime(input));
     * precision decision is keyed off the source {@link LocalDateTime}'s nano-of-second instead.
        // literal's i64 representation well within range — TIMESTAMP(9) at year
    }
     *       {@link TimestampString} value back to {@link LocalDateTime}.</li>
     * Recover a literal {@link LocalDateTime} from an adapter operand that may already be a
 *           second-61, garbage). HTTP 400 with the bare input as the message.</td>
 * <p>The chosen RexNode is wrapped in a CAST to the call's declared type so
     *
     * which calls {@code exprAddTime}.
        try {
     * the planner and die at execution with an opaque {@code StreamException}.
     * Shape E: 2-arg literal-literal {@code TIMESTAMP('<datetime>', '<time>')}.
                try {
 *       <td>plan-time fold (DATE-of-literal): combine date with 00:00:00 UTC,
     *       a varchar literal folds inline to a typed literal, so the wrapper RexCall is
            ldt.getHour(),
        }
        RexNode operand = stripOperatorAnnotation(original.getOperands().get(0));
            try {
 *       <td>{@link #parseTimestamp} throws {@code IllegalArgumentException}
            String innerValue = innerLiteral.getValueAs(String.class);
 * the surrounding Project's rowType matches.
    }
            }
    /**
     *
        );
}
        Long.MAX_VALUE / 1_000_000_000L,
        if (unwrapped instanceof RexCall call
            && (call.getType().getSqlTypeName() == SqlTypeName.TIMESTAMP
    }
     * etc.) avoid the {@code TimestampString → String → LocalDateTime} round-trip and the
     * brittle space-vs-T separator handling that goes with it.
            }
        }
            return wrapWithCallType(combined, original, cluster);
        }
 * The OpenSearch Contributors require contributions made to
        // adapter walk, the inner DATE/TIME has been renamed by DateAdapter /
 *           {@code to_timestamp}.</td>
        if (ldt.isAfter(I64_NS_MAX) || ldt.isBefore(I64_NS_MIN)) {
                    date = LocalDate.parse(innerValue);
    private static final LocalDateTime I64_NS_MIN = LocalDateTime.ofEpochSecond(
            } catch (RuntimeException unused) {
        try {
            unwrapped = call.getOperands().get(0);
 *   <tr><td>E</td>
        }
 *   <tr><td>A</td>
package org.opensearch.be.datafusion;
 *       <td>{@code TIMESTAMP(TIME('10:20:30'))}</td>
        org.apache.calcite.rel.type.RelDataType fp64 = rexBuilder.getTypeFactory()
        for (java.time.format.DateTimeFormatter formatter : TIME_OF_DAY_FORMATS) {
    );
    /**
     *
            if (innerOp == DateTimeAdapters.LOCAL_DATE_OP) {
    }
        if (dateLifted != null) {
            String value = literal.getValueAs(String.class);
            addTime = parseTimeOfDay(timeValue);
            }
 *       <td>works</td></tr>
     * Bump fold precision to 6 when the input carries non-zero sub-millisecond digits.
        RexNode op1 = stripOperatorAnnotation(original.getOperands().get(1));
 *       <td>operand is {@code RexInputRef}; fold doesn't catch. Routes to
        }
        java.time.format.DateTimeFormatter.ofPattern("HH:mm", java.util.Locale.ROOT) };
 *           builtin {@code to_timestamp(timestamp)} (identity at runtime)</td>
        Math.floorDiv(Long.MIN_VALUE, 1_000_000_000L),
            || tn == SqlTypeName.TIMESTAMP_WITH_LOCAL_TIME_ZONE
     *  Locale-pinned formatters avoid the default-locale forbidden-api hit. */
        }
            if (innerOp == DateTimeAdapters.LOCAL_TIME_OP) {
 *       <td>works for DATE / TIMESTAMP / VARCHAR columns</td></tr>
 * SPDX-License-Identifier: Apache-2.0
        }
        RexNode operand = stripOperatorAnnotation(original.getOperands().get(0));
 *       <td>{@code TIMESTAMP('2020-01-01 00:00:00')}</td>
 *       <td>{@code TIMESTAMP(TIMESTAMP('lit'))}</td>
        return cluster.getRexBuilder().makeAbstractCast(original.getType(), operand);
