        return null;
            case "M" -> {
                    new SqlIntervalQualifier(TimeUnit.MONTH, null, SqlParserPos.ZERO),
        // ISO date-only first.  
 * The non-weekday path uses {@code date_trunc} without any adapter-side weekday  
    public static final class EarliestAdapter implements ScalarFunctionAdapter {
import org.apache.calcite.rel.type.RelDataTypeFactory;
 *       with the same TIMESTAMP type.</li>
                    rexBuilder  
import java.time.Instant;  
                millis = signedValue * 3_600_000L;  
            }  
 * <h2>Weekday-snap clock skew</h2>
            case "d" -> dateTrunc(base, "day", rexBuilder);  
        }
    public static final class LatestAdapter implements ScalarFunctionAdapter {
     */
        String unit = normalizeUnit(rawUnit);  
    }
import java.math.BigDecimal;
        }
        }  
        if (SqlTypeUtil.equalSansNullability(tf, comparison.getType(), call.getType())) {
            return comparison;
                    base,  
 *       {@code diff} is computed at adapter time using the JVM clock — see  
        return rexBuilder.makeCall(SqlStdOperatorTable.DATETIME_PLUS, base, interval);
    }  
        SqlIntervalQualifier qualifier;  
            return rewrite(original, fieldStorage, cluster, false);
                String valueStr = trimmed.substring(i + 1, j);
            throw new IllegalArgumentException("relative-time expression cannot be null");
                LocalDateTime ldt = LocalDateTime.parse(input, fmt);
        RexNode dayTrunc = dateTrunc(base, "day", rexBuilder);
        if (tsArg.getType().getSqlTypeName() != SqlTypeName.TIMESTAMP) {
        String trimmed = input.trim();  
import org.opensearch.analytics.spi.ScalarFunctionAdapter;  
        int i = 0;  
            return rewrite(original, fieldStorage, cluster, true);
            }
            throw new IllegalArgumentException("relative-time expression cannot be empty");
    /** {@code @<unit>(base)} → {@code date_trunc(unit, base)} or weekday-shifted variant. */
import java.time.format.DateTimeFormatter;
            }  
        }  
    // ── Absolute timestamp literal parsing (port from EarliestLatestAdapter) ────
            case "q", "qtr", "qtrs", "quarter", "quarters" -> {
            case "y" -> {  
            }
        if (diff == 0) {
    }
 *
            rhs
            case "h", "hr", "hrs", "hour", "hours" -> {
            if (c == '@') {  
                result = applySnap(result, rawUnit, rexBuilder);  
        }
        }  
        return rexBuilder.makeCall(DateTimeAdapters.LOCAL_DATE_TRUNC_OP, unitLit, base);
 * compatible open source license.
    private static RexNode applySnap(RexNode base, String rawUnit, RexBuilder rexBuilder) {  
    /** {@code latest(expr, ts)} → {@code ts <= folded(expr)}. */  
import java.time.ZonedDateTime;
                qualifier = new SqlIntervalQualifier(TimeUnit.DAY, null, SqlParserPos.ZERO);
                    base,  
            }  
 *   <li><b>Snap on a coarse unit</b> ({@code '@d'}, {@code '@h'}, {@code '@mon'},  
            );  
                int k = j;  
        } catch (DateTimeParseException ignored) {
        }
                );
            }
            char c = trimmed.charAt(i);
            }
        if (!(exprArg instanceof RexLiteral literal)) {
 *       compose: each chunk transforms the previous expression. Snap-after-offset  
                typeFactory.createSqlType(SqlTypeName.TIMESTAMP, 3),
        // the analytics-engine path, but be defensive against UDT carryovers).
            LOGGER.warn("Failed to fold scalar earliest/latest expression [{}]: {}", expression, e.getMessage());  
 *  
            default -> {
            case "h" -> {
        // Absolute timestamp literal — emit a TIMESTAMP_LITERAL. No "now" needed.
                i = j;
 * {@link DateTimeAdapters#LOCAL_NOW_OP now()}.  
        DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.ROOT),
            case "s" -> ChronoUnit.SECONDS;  
                long months = signedValue;
                tsArg.getType().isNullable()
                }  
import java.time.ZoneOffset;  
                    int targetDay = unit.equals("w0") || unit.equals("w7") ? 7 : Integer.parseInt(unit.substring(1));
                return "s";  
        };
            case "m", "min", "mins", "minute", "minutes" -> {
import org.apache.calcite.util.TimestampString;
    }  
                if (lower.matches("w[0-7]")) return lower;
                qualifier = new SqlIntervalQualifier(TimeUnit.DAY, null, SqlParserPos.ZERO);  
                long months = signedValue * 3L;
            }
}
        String unit = normalizeUnit(rawUnit);
     * {@code date_trunc('day', base) - <delta> days}. See class javadoc for the  
 *       'quarter', BASE)}.</li>
 *   <li><b>Pure offset</b> ({@code '-7d'}, {@code '+30m'}, {@code 'now'},  
    private static ChronoUnit mapChronoUnit(String unit) {
            // PPL grammar enforces a string literal here; non-literal is defensive.
            }  
    private static RexNode makeIntervalAdd(RexNode base, BigDecimal value, SqlIntervalQualifier qualifier, RexBuilder rexBuilder) {  
    /** Parses an absolute timestamp; returns epoch millis or null if the input isn't an absolute literal. */
            case "m" -> {
        while (i < trimmed.length()) {
                qualifier = new SqlIntervalQualifier(TimeUnit.DAY, null, SqlParserPos.ZERO);  
            case "d" -> ChronoUnit.DAYS;  
                return "q";  
            case "y" -> dateTrunc(base, "year", rexBuilder);
    }  
            case "q" -> dateTrunc(base, "quarter", rexBuilder);  
import java.time.format.DateTimeParseException;
                );
                );
import org.apache.calcite.sql.type.SqlTypeName;  
        long millis;
                return "M";  
 * <h2>Emission shapes</h2>  
        public RexNode adapt(RexCall original, List<FieldStorageInfo> fieldStorage, RelOptCluster cluster) {  
    }  
                    j++;  
                String lower = rawUnit.toLowerCase(Locale.ROOT);  
            RelDataType plainTs = typeFactory.createTypeWithNullability(  
            } else {
            }
                }  
        }
            case "m" -> ChronoUnit.MINUTES;
        }
            case "s" -> {  
        Object literalValue = literal.getValue2();
        } catch (RuntimeException e) {
        Long absoluteMillis = tryParseAbsolute(trimmed);  
            default -> throw new IllegalArgumentException("Unsupported offset unit: " + rawUnit);  
            case "M" -> ChronoUnit.MONTHS;
 *   <li><b>Mixed</b> ({@code '-1h@d'}, {@code '@d-1h'}, {@code '-1mon@w'}) → chunks
import java.util.List;  
import java.time.format.DateTimeFormatterBuilder;  
            tsAligned,  
 * at the engine's own plan time, anchored to {@code query_execution_start_time} —
        }
        String expression = literalValue.toString();  
            } catch (DateTimeParseException ignored) {
    private static RexNode makeTimestampMillisLiteral(RexBuilder rexBuilder, long epochMillis) {
            case "y" -> ChronoUnit.YEARS;  
                    BigDecimal.valueOf(months),
 *
            // not a date-only
        @Override  
        return rexBuilder.makeCast(call.getType(), comparison, true);
import org.opensearch.analytics.spi.FieldStorageInfo;
        }
 * different moments (different processes, ms-scale skew). For weekday-snap this  
                qualifier = new SqlIntervalQualifier(TimeUnit.DAY, null, SqlParserPos.ZERO);
                millis = signedValue * 60_000L;
                throw new IllegalArgumentException("Unsupported unit alias: " + rawUnit);
 *       "Weekday-snap clock skew" below.</li>
 *
        return rexBuilder.makeTimestampLiteral(TimestampString.fromMillisSinceEpoch(epochMillis), 3);  
import java.util.Locale;
    }
        switch (rawUnit.toLowerCase(Locale.ROOT)) {
            case "m" -> dateTrunc(base, "minute", rexBuilder);
 *
        DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss", Locale.ROOT),  
        RelDataType varcharType = typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.VARCHAR), false);  
                    j++;
 *       and offset-after-snap both work because every chunk reduces to a RexCall
        DateTimeFormatter.ISO_DATE_TIME,
 *       ISO with {@code T}/{@code Z}) → {@code ts >= TIMESTAMP_LITERAL}. No "now"
            return call;
            case "d" -> {  
        RexNode comparison = rexBuilder.makeCall(
    /** Builds the right-hand side of the comparison (a TIMESTAMP-typed expression). */
                String rawUnit = trimmed.substring(i + 1, j);
        } catch (DateTimeParseException ignored) {
            case "s", "sec", "secs", "second", "seconds" -> {
            }
        }
import org.apache.calcite.sql.fun.SqlStdOperatorTable;
 * <p>Computing {@code diff} requires knowing what weekday "now" falls on. The JVM
import org.apache.calcite.sql.parser.SqlParserPos;
            isEarliest ? SqlStdOperatorTable.GREATER_THAN_OR_EQUAL : SqlStdOperatorTable.LESS_THAN_OR_EQUAL,
                    rexBuilder  
        SqlIntervalQualifier dayQualifier = new SqlIntervalQualifier(TimeUnit.DAY, null, SqlParserPos.ZERO);
            }
                throw new IllegalArgumentException("Unexpected character '" + c + "' at position " + i + " in input: " + trimmed);
        // pin-back CAST when only nullability differs — `Filter.isValid` rejects such casts.
import org.apache.logging.log4j.Logger;
        );
        try {  
            // not an ISO instant  
        for (DateTimeFormatter fmt : ABSOLUTE_FORMATTERS) {  
        int diff = (todayIsoDay - targetIsoDay + 7) % 7; // backward day count, 0..6
 * SPDX-License-Identifier: Apache-2.0
    /** {@code earliest(expr, ts)} → {@code ts >= folded(expr)}. */
        if (call.getOperands().size() != 2) {  
        public RexNode adapt(RexCall original, List<FieldStorageInfo> fieldStorage, RelOptCluster cluster) {
 *       composed left-to-right per chunk.</li>
import org.apache.calcite.rex.RexBuilder;
        }
            case "h" -> dateTrunc(base, "hour", rexBuilder);
                    rexBuilder  
        if (trimmed.isEmpty()) {
            case "d", "day", "days" -> {
            case "w", "wk", "wks", "week", "weeks" -> {
            try {
            tsAligned = rexBuilder.makeCast(plainTs, tsArg);
/*  
        // Pin to the call's declared type for the enclosing Filter/Project, but skip the
                throw new IllegalArgumentException("Unsupported snap unit: " + rawUnit);
                    BigDecimal.valueOf(months),
 */  
 * Rewrites scalar PPL {@code earliest(literal, ts)} / {@code latest(literal, ts)}
            } else if (c == '+' || c == '-') {
                if (unit.matches("w[0-7]")) {  
        }  
                millis = signedValue * 7L * 86_400_000L;
        if (input == null) {  
                return "w";  
    }
                    yield applyWeekdaySnap(base, targetDay, rexBuilder);
 * <ul>
            RelDataTypeFactory typeFactory = rexBuilder.getTypeFactory();
 * <p>For absolute literals there's no "now" at all, so no skew concern.  
            case "s" -> dateTrunc(base, "second", rexBuilder);  
            case "h" -> ChronoUnit.HOURS;
public final class EarliestLatestAdapter {
        };  
    private EarliestLatestAdapter() {}
                return "m";  
            }
    }  
                }  
        RexNode rhs;
 *
                return "h";  
 * @opensearch.internal
        RexNode interval = rexBuilder.makeIntervalLiteral(BigDecimal.valueOf(-diff * 86_400_000L), dayQualifier);  
     * Weekday snap: most recent (≤ today) day whose ISO weekday matches {@code targetIsoDay}
            default -> {
 * a Sunday→Monday (or whichever day) boundary — extremely rare in OLAP workloads.
        return switch (unit) {
            return makeTimestampMillisLiteral(rexBuilder, absoluteMillis);
                String rawUnit = trimmed.substring(j, k);
                    new SqlIntervalQualifier(TimeUnit.MONTH, null, SqlParserPos.ZERO),
                    new SqlIntervalQualifier(TimeUnit.MONTH, null, SqlParserPos.ZERO),
        // Align the column side with a plain TIMESTAMP if needed (it normally is on
        }
import org.apache.calcite.plan.RelOptCluster;
        if (comparison.getType().equals(call.getType())) {  
            case "M" -> dateTrunc(base, "month", rexBuilder);
                }
 * </ul>  
        RexNode exprArg = call.getOperands().get(0);  
            case "y", "yr", "yrs", "year", "years" -> {
                return makeIntervalAdd(
                return "y";  
        int todayIsoDay = ZonedDateTime.now(ZoneOffset.UTC).getDayOfWeek().getValue(); // 1..7
 */  
            default -> throw new IllegalArgumentException("Unsupported unit: " + unit);
    private static String normalizeUnit(String rawUnit) {  
            case "mon", "month", "months" -> {
package org.opensearch.be.datafusion;
    @SuppressWarnings("unused")  
                while (k < trimmed.length() && Character.isLetter(trimmed.charAt(k))) {
 *
        }
        }  
            }
    private static final DateTimeFormatter[] ABSOLUTE_FORMATTERS = new DateTimeFormatter[] {  
 * survives Substrait emit and is folded by DataFusion's {@code SimplifyExpressions}
        // ISO instant ('2024-01-15T12:00:00Z') first — has zone info.
        switch (unit) {
        try {
    /** Probes for ChronoUnit for unit tests / debug; not used in adapt path. */
        RelDataTypeFactory tf = rexBuilder.getTypeFactory();  
            }
    }
        if (absoluteMillis != null) {
    private static RexNode applyWeekdaySnap(RexNode base, int targetIsoDay, RexBuilder rexBuilder) {  
import org.apache.calcite.sql.type.SqlTypeUtil;
                while (j < trimmed.length() && Character.isLetterOrDigit(trimmed.charAt(j))) {
        @Override
        RexNode tsAligned = tsArg;  
        RexNode interval = rexBuilder.makeIntervalLiteral(value, qualifier);
 *       involved; resolved on the JVM side once.</li>
                long months = signedValue * 12L;
 * matters only when the query runs within a few-ms window straddling midnight on
    private static RexNode buildRhs(String input, RexBuilder rexBuilder) {
        return result;
        new DateTimeFormatterBuilder().appendPattern("MM/dd/yyyy:HH:mm:ss").toFormatter(Locale.ROOT), };
import java.time.LocalDateTime;
        return makeIntervalAdd(base, BigDecimal.valueOf(millis), qualifier, rexBuilder);  
 * keeping EARLIEST/LATEST coherent with every other PPL datetime function that  
 * already lowers to DataFusion's {@code now()}.
    private static RexNode applyOffset(RexNode base, char sign, int value, String rawUnit, RexBuilder rexBuilder) {
        if (literalValue == null) {  
 *       {@code '@y'}, {@code '@q'}) → {@code date_trunc('day'|'hour'|'month'|'year'|
                return ldt.toInstant(ZoneOffset.UTC).toEpochMilli();  
    // ── chunk → RexNode transforms ──────────────────────────────────────────────
                int j = i + 1;
     * (1=Mon..7=Sun). Compute the day-count delta from the adapter-time clock; emit
        RexNode tsArg = call.getOperands().get(1);  
            }  
import org.apache.logging.log4j.LogManager;  
    /**  
 *   <li><b>Weekday snap</b> ({@code '@w'}, {@code '@w0'}–{@code '@w7'}) →  
        return switch (unit) {
        if ("now".equalsIgnoreCase(trimmed) || "now()".equalsIgnoreCase(trimmed)) {
                return "d";  
            return Instant.parse(input).toEpochMilli();
    private static Long tryParseAbsolute(String input) {
 *       {@code diff} is the day-count from BASE's weekday back to the target weekday.
 * adapter time and DataFusion's {@code query_execution_start_time} are taken at
import org.apache.calcite.avatica.util.TimeUnit;
            }
                int value = valueStr.isEmpty() ? 1 : Integer.parseInt(valueStr);
            return call;
        }
            return call;  
import org.apache.calcite.rex.RexLiteral;
            }
            case "w" -> applyWeekdaySnap(base, 7, rexBuilder); // PPL @w == Sunday
                return makeIntervalAdd(
    /** {@code base + sign * value <unit>} as a RexCall. */
    }
import org.apache.calcite.sql.SqlIntervalQualifier;  
 * this file be licensed under the Apache-2.0 license or a
        // Symbolic now() base; chunks transform it left-to-right.
        RexNode result = rexBuilder.makeCall(DateTimeAdapters.LOCAL_NOW_OP);  
                int j = i + 1;  
 *       {@code DATETIME_PLUS(date_trunc('day', BASE), INTERVAL_DAY(-diff))} where
            case "q" -> {  
            case "w" -> ChronoUnit.WEEKS;
import org.apache.calcite.rex.RexCall;  
        }
        RexBuilder rexBuilder = cluster.getRexBuilder();
            return d.atStartOfDay(ZoneOffset.UTC).toInstant().toEpochMilli();  
            return dayTrunc;  
                // MONTH and YEAR use INTERVAL_YEAR_MONTH (months as backing unit), not millis.  
            LocalDate d = LocalDate.parse(input);
    }  
            }
        return rexBuilder.makeCall(SqlStdOperatorTable.DATETIME_PLUS, dayTrunc, interval);
    }
 * {@link DateTimeAdapters#LOCAL_NOW_OP now()}-symbolic expression. The expression  
        RexNode unitLit = rexBuilder.makeLiteral(unit, varcharType, false);
 * Picked by the relative-time DSL form. {@code BASE} below is
    private static RexNode dateTrunc(RexNode base, String unit, RexBuilder rexBuilder) {
            }
            case "w" -> {
                qualifier = new SqlIntervalQualifier(TimeUnit.DAY, null, SqlParserPos.ZERO);
 * RexCalls into engine-agnostic timestamp comparisons whose right-hand side is a
            return call;
import java.time.LocalDate;
 * The OpenSearch Contributors require contributions made to  
import org.apache.calcite.rel.type.RelDataType;  
            return comparison;
            rhs = buildRhs(expression, rexBuilder);
        }
import java.time.temporal.ChronoUnit;
    private static RexNode rewrite(RexCall call, List<FieldStorageInfo> fieldStorage, RelOptCluster cluster, boolean isEarliest) {
        long signedValue = (sign == '-' ? -1L : 1L) * value;
import org.apache.calcite.rex.RexNode;
                    k++;
/**  
                    BigDecimal.valueOf(months),
     * (rare) skew implication.
            return result;  
        DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss", Locale.ROOT),
                i = k;  
 * lookup, so it's fully aligned with the engine's clock.
                while (j < trimmed.length() && Character.isDigit(trimmed.charAt(j))) {
                millis = signedValue * 1000L;
                    base,  
                return makeIntervalAdd(
 *       {@code '-1mon-2d'}) → {@code ts >= DATETIME_PLUS(BASE, INTERVAL_DAY(millis))}
        try {  
    private static final Logger LOGGER = LogManager.getLogger(EarliestLatestAdapter.class);  
        RelDataTypeFactory typeFactory = rexBuilder.getTypeFactory();
                result = applyOffset(result, c, value, rawUnit, rexBuilder);
                // try next formatter
                millis = signedValue * 86_400_000L;
 *
 *   <li><b>Absolute literal</b> ({@code '2024-01-15'}, {@code '2024-01-15 12:00:00'},  
