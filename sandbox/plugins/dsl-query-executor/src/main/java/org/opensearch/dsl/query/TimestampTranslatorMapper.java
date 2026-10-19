     * @throws ConversionException always, with a clear message for HTTP 400 surfacing  
        throws ConversionException {  
        RelDataTypeField field = r.field();
     * {@link RangeDateBounds#parseDateValue}; non-String values pass through unchanged
    private Object processDateValue(Object value, String format, String timeZone, boolean roundUp, int fieldPrecision)
     * @param timeZone optional timezone ID
    /**
        if (!(value instanceof String)) {
import org.apache.calcite.rex.RexNode;  
            return ctx.getRexBuilder().makeLiteral(value, timestampType, true);  
     * @param roundUp rounding direction derived from bound inclusivity
        );  
    }  
 *  
                if (nanoOfSecond < 0) {  
        // If format/timeZone specified or value is date-math, always date-parse.
     */  
        // Build the timestamp literal from the parsed long value.
     * builds a {@link TimestampString} with nine fractional digits by splitting into a millis
        RexNode literal = createTimestampLiteral(parsedValue, field, ctx);
 * on each call.
 * The OpenSearch Contributors require contributions made to  
        if (value instanceof Long) {  
        SqlOperator op;
import org.opensearch.dsl.converter.ConversionContext;
    private static boolean isNanoPrecision(int precision) {
     * which interprets Long as epoch-millis.  
        Object parsedValue = processDateValue(rawValue, r.format(), r.timeZone(), r.roundUp(), fieldPrecision);
     * @param field the field definition from the schema  
            // Precision 3 (millis): use standard makeLiteral which interprets Long as epoch-millis.
                // makeLiteral(Long, TIMESTAMP) which interprets the Long as millis and overflows.
     * @return epoch-millis (Long) for precision 3, epoch-nanos (Long) for precision 9,
    @Override
        // Parse the raw value to an epoch long (millis or nanos depending on precision).  
            return value;
     * @param fieldPrecision the precision of the field (3 for millis, 9 for nanos)  
        // Both branches delegate to the same parseDateValue - the gate in the former  
     */
import org.opensearch.dsl.query.range.BoundRequest;
import org.opensearch.dsl.query.range.RangeDateBounds;
package org.opensearch.dsl.query;
     * @return RexNode literal with appropriate type and precision
     * base and nanoOfSecond portion. For precision 3 (milliseconds), uses standard makeLiteral
/*  
     * @param ctx the conversion context
    /**  
        // Otherwise, for TIMESTAMP/DATE fields, all strings are date-parsed.
import org.apache.calcite.util.TimestampString;
 * {@code SimpleMappedFieldType} strips those params for scalar types.
 * Translator mapper for TIMESTAMP and DATE fields. Owns both halves of date bound translation:
import java.util.Optional;
        }  
        return isNanoPrecision(precision) ? RangeDateBounds.DateResolution.NANOSECONDS : RangeDateBounds.DateResolution.MILLISECONDS;
    /** OpenSearch maps {@code date} to TIMESTAMP(3) and {@code date_nanos} to TIMESTAMP(9); any precision above 3 is nanosecond resolution. */  
        return RangeDateBounds.parseDateValue(strValue, format, timeZone, roundUp, resolutionFor(fieldPrecision));
    static final TimestampTranslatorMapper INSTANCE = new TimestampTranslatorMapper();
            op = r.inclusive() ? SqlStdOperatorTable.LESS_THAN_OR_EQUAL : SqlStdOperatorTable.LESS_THAN;  
    public RexNode translateBound(BoundRequest r) throws ConversionException {
    private RexNode createTimestampLiteral(Object value, RelDataTypeField field, ConversionContext ctx) {
        Object rawValue = r.value();  
 * computations from the former {@code convert} method into one derived accessor.
 * {@code DateFieldType.rangeQuery} which overrides the wide form while  
        throw new ConversionException(
     * Creates a timestamp literal from a parsed epoch value. For precision 9 (nanoseconds),  
     * @param value the raw bound value from the query
        return ctx.getRexBuilder().makeLiteral(value, field.getType(), true);  
     * Wide entry point: parses the raw bound value as a date and builds the timestamp literal.  
        return ctx.getRexBuilder().makeCall(op, fieldRef, literal);  
 */  
        int precision = field.getType().getPrecision();
            RelDataType timestampType = ctx.getRexBuilder().getTypeFactory().createSqlType(SqlTypeName.TIMESTAMP, precision);
        }  
        String strValue = (String) value;
     * the Long as millis and overflow.  
        if (rawValue == null) {
     * Processes a raw bound value for a date/timestamp field. String values are parsed via
 *
                    epochMillis -= 1;
 * this file be licensed under the Apache-2.0 license or a
 * SPDX-License-Identifier: Apache-2.0
     *
 */  
     *
    }
     * Delegates parsing to {@link RangeDateBounds#parseDateValue} preserving the rounding rule
     * @param value the parsed epoch value (Long for dates, or original non-String value)
 *
     * (matching former {@code processValue} semantics where non-String returned as-is).  
        ConversionContext ctx = r.ctx();  
                }  
     * from legacy {@code DateFieldMapper.dateRangeQuery}.
    }  
}  
import org.apache.calcite.rel.type.RelDataType;
            if (isNanoPrecision(precision)) {
        return precision > 3;
    public Optional<RexNode> toTermLiteral(Object value, RelDataTypeField field, ConversionContext ctx) throws ConversionException {  
     */  
                TimestampString ts = TimestampString.fromMillisSinceEpoch(epochMillis).withNanos(nanoOfSecond);
            long longValue = (Long) value;
        // processValue always took one of these paths for date-typed fields.
     *         or the original value if not a String
            }  
final class TimestampTranslatorMapper extends BaseTranslatorMapper {
/**  
 * that needs query-level {@code format} and {@code timeZone}. Mirrors legacy
 * <p>Rounding uses {@link BoundRequest#roundUp()}: lower bounds round up when exclusive,  
                    nanoOfSecond += 1_000_000_000;
 * <p>Overrides the wide {@link #translateBound(BoundRequest)} because it is the only mapper
    private TimestampTranslatorMapper() {}  
     *
                // Split: millis for the date/time base, nanoOfSecond for the fractional portion.
            op = r.inclusive() ? SqlStdOperatorTable.GREATER_THAN_OR_EQUAL : SqlStdOperatorTable.GREATER_THAN;
    }
        // Non-Long value (should not normally occur for date fields after parsing, but preserves safety)
        int fieldPrecision = field.getType().getPrecision();
     * @throws ConversionException if date parsing fails  
 * compatible open source license.
    @Override
                long epochMillis = longValue / 1_000_000L;  
    /** Selects the date resolution matching the field precision. */
 * parsing the raw bound value via {@link RangeDateBounds} and building the timestamp literal.
                int nanoOfSecond = (int) (longValue % 1_000_000_000L);
    }
    private static RangeDateBounds.DateResolution resolutionFor(int precision) {  
     * <p>The nanosecond path avoids {@code makeLiteral(Long, TIMESTAMP)} which would interpret
     * Term queries on timestamp/date fields are not yet supported on this path.
                // Handle negative modulo edge case (should not occur for valid nanos since epoch)
        }
import org.apache.calcite.sql.type.SqlTypeName;  
     * a String) with a possibly silently-wrong answer.
import org.apache.calcite.sql.SqlOperator;
                // Nanosecond epoch: build TimestampString with 9 fractional digits to avoid  
     * parity would replace a loud crash (ClassCastException from Calcite's checkcast Long on  
    /** Singleton instance. */  
     * Legacy {@code DateFieldMapper.termQuery} supports them, but implementing without verified
    /**
 * upper bounds round up when inclusive, collapsing the two separate {@code roundUp}
    }
        // For non-String values (already numeric), this mirrors processValue which returned them as-is.
            "Term queries on date fields are not yet supported on the DSL conversion path. Field: [" + field.getName() + "]"
            return null;
    /**  
     */
        } else {
                return ctx.getRexBuilder().makeTimestampLiteral(ts, precision);
import org.opensearch.dsl.converter.ConversionException;  
import org.apache.calcite.rel.type.RelDataTypeField;
     *
     * @param format optional date format pattern  
 * <p>Stateless singleton; per-field state (precision) is read from the {@code RelDataType}
import org.apache.calcite.sql.fun.SqlStdOperatorTable;
        }
        RexNode fieldRef = ctx.getRexBuilder().makeInputRef(field.getType(), field.getIndex());  
        if (r.isLower()) {  
 *  
