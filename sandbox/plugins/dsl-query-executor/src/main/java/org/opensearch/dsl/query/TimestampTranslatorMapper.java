import org.opensearch.dsl.query.range.BoundRequest;
     * Term queries on timestamp/date fields are not yet supported on this path.
    }
import java.util.Optional;
import org.apache.calcite.sql.fun.SqlStdOperatorTable;
                    nanoOfSecond += 1_000_000_000;
     * @param value the parsed epoch value (Long for dates, or original non-String value)
     * @param roundUp rounding direction derived from bound inclusivity
        // Otherwise, for TIMESTAMP/DATE fields, all strings are date-parsed.
final class TimestampTranslatorMapper extends BaseTranslatorMapper {
     *
     * <p>The nanosecond path avoids {@code makeLiteral(Long, TIMESTAMP)} which would interpret
            op = r.inclusive() ? SqlStdOperatorTable.LESS_THAN_OR_EQUAL : SqlStdOperatorTable.LESS_THAN;
        Object parsedValue = processDateValue(rawValue, r.format(), r.timeZone(), r.roundUp(), fieldPrecision);
            }
 * compatible open source license.
        return isNanoPrecision(precision) ? RangeDateBounds.DateResolution.NANOSECONDS : RangeDateBounds.DateResolution.MILLISECONDS;
     */
    private TimestampTranslatorMapper() {}
     * Delegates parsing to {@link RangeDateBounds#parseDateValue} preserving the rounding rule
            long longValue = (Long) value;
package org.opensearch.dsl.query;
     *
     */
        }
     * @param value the raw bound value from the query
    public Optional<RexNode> toTermLiteral(Object value, RelDataTypeField field, ConversionContext ctx) throws ConversionException {
            return null;
     * Wide entry point: parses the raw bound value as a date and builds the timestamp literal.
    private static RangeDateBounds.DateResolution resolutionFor(int precision) {
 * on each call.
                // makeLiteral(Long, TIMESTAMP) which interprets the Long as millis and overflows.
     * a String) with a possibly silently-wrong answer.
     * Creates a timestamp literal from a parsed epoch value. For precision 9 (nanoseconds),
        ConversionContext ctx = r.ctx();
 * this file be licensed under the Apache-2.0 license or a
     * @param field the field definition from the schema
import org.apache.calcite.rel.type.RelDataTypeField;
        // For non-String values (already numeric), this mirrors processValue which returned them as-is.
 * <p>Rounding uses {@link BoundRequest#roundUp()}: lower bounds round up when exclusive,
    /**
        return precision > 3;
        // Build the timestamp literal from the parsed long value.
     * @return RexNode literal with appropriate type and precision
     * {@link RangeDateBounds#parseDateValue}; non-String values pass through unchanged
        // Parse the raw value to an epoch long (millis or nanos depending on precision).
        // Both branches delegate to the same parseDateValue - the gate in the former
 *
    private static boolean isNanoPrecision(int precision) {
                // Handle negative modulo edge case (should not occur for valid nanos since epoch)
                // Nanosecond epoch: build TimestampString with 9 fractional digits to avoid
     * Legacy {@code DateFieldMapper.termQuery} supports them, but implementing without verified
                    epochMillis -= 1;
        throw new ConversionException(
import org.opensearch.dsl.query.range.RangeDateBounds;
     * @return epoch-millis (Long) for precision 3, epoch-nanos (Long) for precision 9,
        if (value instanceof Long) {
 */
    static final TimestampTranslatorMapper INSTANCE = new TimestampTranslatorMapper();
    }
     * @throws ConversionException always, with a clear message for HTTP 400 surfacing
}
     * from legacy {@code DateFieldMapper.dateRangeQuery}.
            op = r.inclusive() ? SqlStdOperatorTable.GREATER_THAN_OR_EQUAL : SqlStdOperatorTable.GREATER_THAN;
 * parsing the raw bound value via {@link RangeDateBounds} and building the timestamp literal.
import org.opensearch.dsl.converter.ConversionContext;
 * computations from the former {@code convert} method into one derived accessor.
 * that needs query-level {@code format} and {@code timeZone}. Mirrors legacy
                long epochMillis = longValue / 1_000_000L;
 *
/*
     * @param timeZone optional timezone ID
     * @throws ConversionException if date parsing fails
        String strValue = (String) value;
        if (rawValue == null) {
 * <p>Overrides the wide {@link #translateBound(BoundRequest)} because it is the only mapper
            return value;
     * which interprets Long as epoch-millis.
    private RexNode createTimestampLiteral(Object value, RelDataTypeField field, ConversionContext ctx) {
 * The OpenSearch Contributors require contributions made to
            // Precision 3 (millis): use standard makeLiteral which interprets Long as epoch-millis.
        return ctx.getRexBuilder().makeCall(op, fieldRef, literal);
    }
 * {@code SimpleMappedFieldType} strips those params for scalar types.
        // Non-Long value (should not normally occur for date fields after parsing, but preserves safety)
 * SPDX-License-Identifier: Apache-2.0
        SqlOperator op;
     * @param fieldPrecision the precision of the field (3 for millis, 9 for nanos)
     */
                int nanoOfSecond = (int) (longValue % 1_000_000_000L);
     * the Long as millis and overflow.
     * base and nanoOfSecond portion. For precision 3 (milliseconds), uses standard makeLiteral
    public RexNode translateBound(BoundRequest r) throws ConversionException {
 *
        );
                TimestampString ts = TimestampString.fromMillisSinceEpoch(epochMillis).withNanos(nanoOfSecond);
/**
import org.apache.calcite.sql.SqlOperator;
     * Processes a raw bound value for a date/timestamp field. String values are parsed via
        if (!(value instanceof String)) {
    /** Selects the date resolution matching the field precision. */
 * Translator mapper for TIMESTAMP and DATE fields. Owns both halves of date bound translation:
        int precision = field.getType().getPrecision();
     * (matching former {@code processValue} semantics where non-String returned as-is).
     * @param format optional date format pattern
            if (isNanoPrecision(precision)) {
     *
import org.apache.calcite.sql.type.SqlTypeName;
        // processValue always took one of these paths for date-typed fields.
                return ctx.getRexBuilder().makeTimestampLiteral(ts, precision);
        }
                // Split: millis for the date/time base, nanoOfSecond for the fractional portion.
     * builds a {@link TimestampString} with nine fractional digits by splitting into a millis
        }
        return RangeDateBounds.parseDateValue(strValue, format, timeZone, roundUp, resolutionFor(fieldPrecision));
    @Override
    /**
    }
        int fieldPrecision = field.getType().getPrecision();
     */
 * {@code DateFieldType.rangeQuery} which overrides the wide form while
import org.apache.calcite.util.TimestampString;
     * @param ctx the conversion context
    }
                }
        RelDataTypeField field = r.field();
 *
            return ctx.getRexBuilder().makeLiteral(value, timestampType, true);
import org.opensearch.dsl.converter.ConversionException;
import org.apache.calcite.rel.type.RelDataType;
    /** OpenSearch maps {@code date} to TIMESTAMP(3) and {@code date_nanos} to TIMESTAMP(9); any precision above 3 is nanosecond resolution. */
                if (nanoOfSecond < 0) {
     *
        RexNode fieldRef = ctx.getRexBuilder().makeInputRef(field.getType(), field.getIndex());
            "Term queries on date fields are not yet supported on the DSL conversion path. Field: [" + field.getName() + "]"
 * upper bounds round up when inclusive, collapsing the two separate {@code roundUp}
        if (r.isLower()) {
        } else {
        Object rawValue = r.value();
    /**
 */
import org.apache.calcite.rex.RexNode;
        throws ConversionException {
            RelDataType timestampType = ctx.getRexBuilder().getTypeFactory().createSqlType(SqlTypeName.TIMESTAMP, precision);
        // If format/timeZone specified or value is date-math, always date-parse.
     *         or the original value if not a String
    }
 * <p>Stateless singleton; per-field state (precision) is read from the {@code RelDataType}
    /** Singleton instance. */
        }
    /**
        RexNode literal = createTimestampLiteral(parsedValue, field, ctx);
        return ctx.getRexBuilder().makeLiteral(value, field.getType(), true);
    @Override
    private Object processDateValue(Object value, String format, String timeZone, boolean roundUp, int fieldPrecision)
     * parity would replace a loud crash (ClassCastException from Calcite's checkcast Long on
