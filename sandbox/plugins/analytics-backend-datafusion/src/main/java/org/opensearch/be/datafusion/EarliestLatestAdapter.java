     * (rare) skew implication.
        String expression = literalValue.toString();
    /** {@code latest(expr, ts)} → {@code ts <= folded(expr)}. */
        Long absoluteMillis = tryParseAbsolute(trimmed);
    }
                throw new IllegalArgumentException("Unexpected character '" + c + "' at position " + i + " in input: " + trimmed);
import org.opensearch.analytics.spi.FieldStorageInfo;
    private static RexNode buildRhs(String input, RexBuilder rexBuilder) {
        switch (unit) {
            }
 * {@link DateTimeAdapters#LOCAL_NOW_OP now()}-symbolic expression. The expression
            // not an ISO instant
 *   <li><b>Weekday snap</b> ({@code '@w'}, {@code '@w0'}–{@code '@w7'}) →
        } catch (DateTimeParseException ignored) {
        for (DateTimeFormatter fmt : ABSOLUTE_FORMATTERS) {
    }
 * lookup, so it's fully aligned with the engine's clock.
    private static Long tryParseAbsolute(String input) {
                return "w";
        if ("now".equalsIgnoreCase(trimmed) || "now()".equalsIgnoreCase(trimmed)) {
                    new SqlIntervalQualifier(TimeUnit.MONTH, null, SqlParserPos.ZERO),
     * Weekday snap: most recent (≤ today) day whose ISO weekday matches {@code targetIsoDay}
            case "m" -> dateTrunc(base, "minute", rexBuilder);
                throw new IllegalArgumentException("Unsupported snap unit: " + rawUnit);
 * Picked by the relative-time DSL form. {@code BASE} below is
        RexNode unitLit = rexBuilder.makeLiteral(unit, varcharType, false);
 *       {@code '-1mon-2d'}) → {@code ts >= DATETIME_PLUS(BASE, INTERVAL_DAY(millis))}
    private static RexNode applySnap(RexNode base, String rawUnit, RexBuilder rexBuilder) {
            }
 */
            }
import java.time.format.DateTimeParseException;
            }
        DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss", Locale.ROOT),
package org.opensearch.be.datafusion;
 * keeping EARLIEST/LATEST coherent with every other PPL datetime function that
import org.apache.logging.log4j.LogManager;
    }
    }
    private static String normalizeUnit(String rawUnit) {
            }
                return makeIntervalAdd(
                    j++;
                // MONTH and YEAR use INTERVAL_YEAR_MONTH (months as backing unit), not millis.
import java.time.format.DateTimeFormatter;
                return "h";
        } catch (DateTimeParseException ignored) {
 *
        long millis;
 * a Sunday→Monday (or whichever day) boundary — extremely rare in OLAP workloads.
    private static RexNode makeTimestampMillisLiteral(RexBuilder rexBuilder, long epochMillis) {
                return "y";
import org.apache.calcite.sql.fun.SqlStdOperatorTable;
        RexNode interval = rexBuilder.makeIntervalLiteral(value, qualifier);
import org.apache.calcite.sql.SqlIntervalQualifier;
        }
            // PPL grammar enforces a string literal here; non-literal is defensive.
                    rexBuilder
        try {
                tsArg.getType().isNullable()
        }
                );
        String trimmed = input.trim();
    public static final class LatestAdapter implements ScalarFunctionAdapter {
                    yield applyWeekdaySnap(base, targetDay, rexBuilder);
                while (k < trimmed.length() && Character.isLetter(trimmed.charAt(k))) {
            }
 * survives Substrait emit and is folded by DataFusion's {@code SimplifyExpressions}
        RexNode rhs;
            // not a date-only
        if (call.getOperands().size() != 2) {
 *
import org.apache.calcite.rex.RexCall;
import java.time.ZonedDateTime;
                return makeIntervalAdd(
            tsAligned,
            LOGGER.warn("Failed to fold scalar earliest/latest expression [{}]: {}", expression, e.getMessage());
                millis = signedValue * 7L * 86_400_000L;
        RelDataTypeFactory typeFactory = rexBuilder.getTypeFactory();
        }
import org.apache.logging.log4j.Logger;
 * RexCalls into engine-agnostic timestamp comparisons whose right-hand side is a
                }
            case "m" -> ChronoUnit.MINUTES;
                int value = valueStr.isEmpty() ? 1 : Integer.parseInt(valueStr);
    private static RexNode applyWeekdaySnap(RexNode base, int targetIsoDay, RexBuilder rexBuilder) {
     */
        // pin-back CAST when only nullability differs — `Filter.isValid` rejects such casts.
            }
 *   <li><b>Snap on a coarse unit</b> ({@code '@d'}, {@code '@h'}, {@code '@mon'},
                    base,
}
        RexBuilder rexBuilder = cluster.getRexBuilder();
 * <h2>Weekday-snap clock skew</h2>
                // try next formatter
        }
            } else if (c == '+' || c == '-') {
            default -> throw new IllegalArgumentException("Unsupported unit: " + unit);
            case "mon", "month", "months" -> {
                i = k;
    private static final Logger LOGGER = LogManager.getLogger(EarliestLatestAdapter.class);
import org.apache.calcite.rex.RexNode;
            }
                return makeIntervalAdd(
            case "h", "hr", "hrs", "hour", "hours" -> {
 *
import org.apache.calcite.rex.RexBuilder;
        return rexBuilder.makeCall(SqlStdOperatorTable.DATETIME_PLUS, base, interval);
                return ldt.toInstant(ZoneOffset.UTC).toEpochMilli();
import org.apache.calcite.sql.type.SqlTypeName;
 * adapter time and DataFusion's {@code query_execution_start_time} are taken at
        try {
 *
        } catch (RuntimeException e) {
            default -> {
            case "w", "wk", "wks", "week", "weeks" -> {
import java.time.temporal.ChronoUnit;
                    j++;
        return rexBuilder.makeCall(SqlStdOperatorTable.DATETIME_PLUS, dayTrunc, interval);
        return rexBuilder.makeTimestampLiteral(TimestampString.fromMillisSinceEpoch(epochMillis), 3);
 *
 *   <li><b>Mixed</b> ({@code '-1h@d'}, {@code '@d-1h'}, {@code '-1mon@w'}) → chunks
    }
            throw new IllegalArgumentException("relative-time expression cannot be empty");
        RexNode interval = rexBuilder.makeIntervalLiteral(BigDecimal.valueOf(-diff * 86_400_000L), dayQualifier);
        DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.ROOT),
            return rewrite(original, fieldStorage, cluster, true);
            case "h" -> dateTrunc(base, "hour", rexBuilder);
            case "d" -> {
        }
 *   <li><b>Absolute literal</b> ({@code '2024-01-15'}, {@code '2024-01-15 12:00:00'},
 */
    private static RexNode makeIntervalAdd(RexNode base, BigDecimal value, SqlIntervalQualifier qualifier, RexBuilder rexBuilder) {
            return call;
    }
 *       and offset-after-snap both work because every chunk reduces to a RexCall
        };
 * SPDX-License-Identifier: Apache-2.0
        }
                LocalDateTime ldt = LocalDateTime.parse(input, fmt);
            if (c == '@') {
            case "d" -> dateTrunc(base, "day", rexBuilder);
        switch (rawUnit.toLowerCase(Locale.ROOT)) {
 * <p>Computing {@code diff} requires knowing what weekday "now" falls on. The JVM
                    base,
                long months = signedValue * 3L;
        return null;
                }
            case "s" -> {
            }
                );
                if (lower.matches("w[0-7]")) return lower;
 * at the engine's own plan time, anchored to {@code query_execution_start_time} —
                millis = signedValue * 1000L;
 * The non-weekday path uses {@code date_trunc} without any adapter-side weekday
import java.time.LocalDateTime;
            isEarliest ? SqlStdOperatorTable.GREATER_THAN_OR_EQUAL : SqlStdOperatorTable.LESS_THAN_OR_EQUAL,
            case "q" -> {
        // Symbolic now() base; chunks transform it left-to-right.
        @Override
    /** Probes for ChronoUnit for unit tests / debug; not used in adapt path. */
        long signedValue = (sign == '-' ? -1L : 1L) * value;
                long months = signedValue;
    }
            return dayTrunc;
                return "m";
            try {
        return result;
            LocalDate d = LocalDate.parse(input);
import org.apache.calcite.rel.type.RelDataTypeFactory;
import java.util.Locale;
    }
        Object literalValue = literal.getValue2();
    private static RexNode applyOffset(RexNode base, char sign, int value, String rawUnit, RexBuilder rexBuilder) {
 *       composed left-to-right per chunk.</li>
    /** Parses an absolute timestamp; returns epoch millis or null if the input isn't an absolute literal. */
            case "m", "min", "mins", "minute", "minutes" -> {
                throw new IllegalArgumentException("Unsupported unit alias: " + rawUnit);
        RexNode comparison = rexBuilder.makeCall(
        // Absolute timestamp literal — emit a TIMESTAMP_LITERAL. No "now" needed.
                millis = signedValue * 60_000L;
        DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss", Locale.ROOT),
        RelDataType varcharType = typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.VARCHAR), false);
                String valueStr = trimmed.substring(i + 1, j);
        }
            case "M" -> dateTrunc(base, "month", rexBuilder);
            return call;
    /** Builds the right-hand side of the comparison (a TIMESTAMP-typed expression). */
        if (SqlTypeUtil.equalSansNullability(tf, comparison.getType(), call.getType())) {
                return "s";
import org.apache.calcite.avatica.util.TimeUnit;
    }
 *   <li><b>Pure offset</b> ({@code '-7d'}, {@code '+30m'}, {@code 'now'},
import org.apache.calcite.sql.parser.SqlParserPos;
            }
        return switch (unit) {
        if (literalValue == null) {
                qualifier = new SqlIntervalQualifier(TimeUnit.DAY, null, SqlParserPos.ZERO);
            case "s", "sec", "secs", "second", "seconds" -> {
        if (tsArg.getType().getSqlTypeName() != SqlTypeName.TIMESTAMP) {
                int k = j;
    private static final DateTimeFormatter[] ABSOLUTE_FORMATTERS = new DateTimeFormatter[] {
                );
    public static final class EarliestAdapter implements ScalarFunctionAdapter {
 * already lowers to DataFusion's {@code now()}.
import org.apache.calcite.rel.type.RelDataType;
                long months = signedValue * 12L;
            case "q" -> dateTrunc(base, "quarter", rexBuilder);
        SqlIntervalQualifier qualifier;
                result = applySnap(result, rawUnit, rexBuilder);
 *       {@code '@y'}, {@code '@q'}) → {@code date_trunc('day'|'hour'|'month'|'year'|
    /**
            case "M" -> {
            case "y" -> dateTrunc(base, "year", rexBuilder);
    }
 * compatible open source license.
            throw new IllegalArgumentException("relative-time expression cannot be null");
 *
/**
 *       ISO with {@code T}/{@code Z}) → {@code ts >= TIMESTAMP_LITERAL}. No "now"
            return makeTimestampMillisLiteral(rexBuilder, absoluteMillis);
    }
                    BigDecimal.valueOf(months),
            }
    // ── chunk → RexNode transforms ──────────────────────────────────────────────
        if (!(exprArg instanceof RexLiteral literal)) {
 *
        }
 *       with the same TIMESTAMP type.</li>
                }
import java.time.Instant;
 * <ul>
            case "s" -> ChronoUnit.SECONDS;
        return rexBuilder.makeCast(call.getType(), comparison, true);
        // ISO date-only first.
            }
                qualifier = new SqlIntervalQualifier(TimeUnit.DAY, null, SqlParserPos.ZERO);
    /** {@code earliest(expr, ts)} → {@code ts >= folded(expr)}. */
        return makeIntervalAdd(base, BigDecimal.valueOf(millis), qualifier, rexBuilder);
                if (unit.matches("w[0-7]")) {
        );
    private static RexNode dateTrunc(RexNode base, String unit, RexBuilder rexBuilder) {
                qualifier = new SqlIntervalQualifier(TimeUnit.DAY, null, SqlParserPos.ZERO);
        int i = 0;
            case "y" -> ChronoUnit.YEARS;
        }
 *       "Weekday-snap clock skew" below.</li>
        DateTimeFormatter.ISO_DATE_TIME,
import org.apache.calcite.plan.RelOptCluster;
 * <h2>Emission shapes</h2>
import java.time.ZoneOffset;
import java.time.LocalDate;
            return call;
        String unit = normalizeUnit(rawUnit);
                    rexBuilder
            RelDataType plainTs = typeFactory.createTypeWithNullability(
            case "y", "yr", "yrs", "year", "years" -> {
        };
        // Align the column side with a plain TIMESTAMP if needed (it normally is on
        if (comparison.getType().equals(call.getType())) {
        }
            } else {
            return rewrite(original, fieldStorage, cluster, false);
import org.apache.calcite.util.TimestampString;
                return "d";
 * {@link DateTimeAdapters#LOCAL_NOW_OP now()}.
            case "d", "day", "days" -> {
import java.util.List;
            case "w" -> applyWeekdaySnap(base, 7, rexBuilder); // PPL @w == Sunday
            case "m" -> {
            case "d" -> ChronoUnit.DAYS;
     * (1=Mon..7=Sun). Compute the day-count delta from the adapter-time clock; emit
            char c = trimmed.charAt(i);
        RexNode tsAligned = tsArg;
                millis = signedValue * 3_600_000L;
 *       involved; resolved on the JVM side once.</li>
                    base,
     * {@code date_trunc('day', base) - <delta> days}. See class javadoc for the
        if (trimmed.isEmpty()) {
            default -> throw new IllegalArgumentException("Unsupported offset unit: " + rawUnit);
            }
 * Rewrites scalar PPL {@code earliest(literal, ts)} / {@code latest(literal, ts)}
            );
        }
import org.apache.calcite.rex.RexLiteral;
        }
 *
                i = j;
        new DateTimeFormatterBuilder().appendPattern("MM/dd/yyyy:HH:mm:ss").toFormatter(Locale.ROOT), };
        RexNode tsArg = call.getOperands().get(1);
 *       {@code DATETIME_PLUS(date_trunc('day', BASE), INTERVAL_DAY(-diff))} where
                int j = i + 1;
 * this file be licensed under the Apache-2.0 license or a
        return rexBuilder.makeCall(DateTimeAdapters.LOCAL_DATE_TRUNC_OP, unitLit, base);
 * The OpenSearch Contributors require contributions made to
 *       'quarter', BASE)}.</li>
        }
import org.apache.calcite.sql.type.SqlTypeUtil;
                result = applyOffset(result, c, value, rawUnit, rexBuilder);
        }
                return "M";
            return comparison;
                    new SqlIntervalQualifier(TimeUnit.MONTH, null, SqlParserPos.ZERO),
        // ISO instant ('2024-01-15T12:00:00Z') first — has zone info.
                }
        while (i < trimmed.length()) {
        public RexNode adapt(RexCall original, List<FieldStorageInfo> fieldStorage, RelOptCluster cluster) {
            return d.atStartOfDay(ZoneOffset.UTC).toInstant().toEpochMilli();
            return result;
            case "M" -> ChronoUnit.MONTHS;
                String rawUnit = trimmed.substring(j, k);
                String lower = rawUnit.toLowerCase(Locale.ROOT);
    /** {@code @<unit>(base)} → {@code date_trunc(unit, base)} or weekday-shifted variant. */
        if (input == null) {
                typeFactory.createSqlType(SqlTypeName.TIMESTAMP, 3),
        if (diff == 0) {
            return comparison;
            case "h" -> ChronoUnit.HOURS;
    private EarliestLatestAdapter() {}
                while (j < trimmed.length() && Character.isLetterOrDigit(trimmed.charAt(j))) {
 *       {@code diff} is the day-count from BASE's weekday back to the target weekday.
        }
    @SuppressWarnings("unused")
        RelDataTypeFactory tf = rexBuilder.getTypeFactory();
            return Instant.parse(input).toEpochMilli();
        @Override
            case "h" -> {
            }
        }
    private static RexNode rewrite(RexCall call, List<FieldStorageInfo> fieldStorage, RelOptCluster cluster, boolean isEarliest) {
                qualifier = new SqlIntervalQualifier(TimeUnit.DAY, null, SqlParserPos.ZERO);
        String unit = normalizeUnit(rawUnit);
        // Pin to the call's declared type for the enclosing Filter/Project, but skip the
 * <p>For absolute literals there's no "now" at all, so no skew concern.
/*
 * </ul>
    }
 *       compose: each chunk transforms the previous expression. Snap-after-offset
                return "q";
import java.math.BigDecimal;
            RelDataTypeFactory typeFactory = rexBuilder.getTypeFactory();
public final class EarliestLatestAdapter {
                    BigDecimal.valueOf(months),
import java.time.format.DateTimeFormatterBuilder;
                    int targetDay = unit.equals("w0") || unit.equals("w7") ? 7 : Integer.parseInt(unit.substring(1));
                int j = i + 1;
        }
                String rawUnit = trimmed.substring(i + 1, j);
    /** {@code base + sign * value <unit>} as a RexCall. */
            }
            return call;
        public RexNode adapt(RexCall original, List<FieldStorageInfo> fieldStorage, RelOptCluster cluster) {
            tsAligned = rexBuilder.makeCast(plainTs, tsArg);
            }
                    new SqlIntervalQualifier(TimeUnit.MONTH, null, SqlParserPos.ZERO),
            case "w" -> {
        int diff = (todayIsoDay - targetIsoDay + 7) % 7; // backward day count, 0..6
    private static ChronoUnit mapChronoUnit(String unit) {
                qualifier = new SqlIntervalQualifier(TimeUnit.DAY, null, SqlParserPos.ZERO);
            case "y" -> {
            }
        RexNode result = rexBuilder.makeCall(DateTimeAdapters.LOCAL_NOW_OP);
 * different moments (different processes, ms-scale skew). For weekday-snap this
        if (absoluteMillis != null) {
                while (j < trimmed.length() && Character.isDigit(trimmed.charAt(j))) {
        return switch (unit) {
            case "s" -> dateTrunc(base, "second", rexBuilder);
            }
import org.opensearch.analytics.spi.ScalarFunctionAdapter;
        int todayIsoDay = ZonedDateTime.now(ZoneOffset.UTC).getDayOfWeek().getValue(); // 1..7
            }
 * matters only when the query runs within a few-ms window straddling midnight on
                millis = signedValue * 86_400_000L;
        RexNode exprArg = call.getOperands().get(0);
        try {
 * @opensearch.internal
            case "q", "qtr", "qtrs", "quarter", "quarters" -> {
            rhs
        }
                    rexBuilder
                    BigDecimal.valueOf(months),
            }
            default -> {
        }
        SqlIntervalQualifier dayQualifier = new SqlIntervalQualifier(TimeUnit.DAY, null, SqlParserPos.ZERO);
    }
                    k++;
            } catch (DateTimeParseException ignored) {
            rhs = buildRhs(expression, rexBuilder);
            case "w" -> ChronoUnit.WEEKS;
        // the analytics-engine path, but be defensive against UDT carryovers).
        }
        RexNode dayTrunc = dateTrunc(base, "day", rexBuilder);
 *       {@code diff} is computed at adapter time using the JVM clock — see
    // ── Absolute timestamp literal parsing (port from EarliestLatestAdapter) ────
