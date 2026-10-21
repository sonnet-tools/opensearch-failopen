                case DECIMAL:
    private RexNode translateBound(
     * @param value the value to process (can be String, Long, or other types)
        // at builder level, so this is a defensive check.
        if (rangeQuery.from() != null) {
                default:
import org.opensearch.index.query.QueryBuilder;
}
     * - Inclusivity-keyed rounding per legacy DateFieldMapper.dateRangeQuery
public class RangeQueryTranslator implements QueryTranslator {
    /** Selects the date resolution matching the field precision. */
                        return Double.valueOf(strValue);
        // mapper. The catch-all DefaultTranslatorMapper carries the entire non-UDT path
        }
    }
     * @return processed value as epoch milliseconds (Long) for date, epoch nanos (Long) for date_nanos,
     * - For VARCHAR/CHAR fields: string values are kept as-is for lexicographic comparison.
        // Gate on field type
     * silently ignored for scalar fields (INTERSECTS, CONTAINS, WITHIN all produce identical
        return conditions.size() == 1 ? conditions.get(0) : ctx.getRexBuilder().makeCall(SqlStdOperatorTable.AND, conditions);
     * @param ctx the conversion context containing schema and RexBuilder
    ) throws ConversionException {
     */
import org.apache.calcite.rel.type.RelDataTypeField;
            return null;
            }
        // including VARCHAR/CHAR keyword ranges.
 * Supports gte, gt, lte, lt operators, format, time_zone, and relation parameters.
     * @throws ConversionException if date parsing fails or numeric coercion fails
     */
        boolean roundUp,
                case SMALLINT:
                case FLOAT:
    ) throws ConversionException {
     * Coerces a string value to a numeric type matching the field.
    /**
        if (rangeQuery.queryName() != null) {
     * Converts a RangeQueryBuilder to a Calcite RexNode expression.
                    if (fieldTypeName == SqlTypeName.BIGINT) {
 * compatible open source license.
     * - IP field range with InetAddress-order byte comparison
        int fieldPrecision
                    }
     * - If format or timeZone is specified, or the string is a date-math expression
    private static RangeDateBounds.DateResolution resolutionFor(int precision) {
 * Date rounding follows legacy {@code DateFieldMapper.dateRangeQuery}: lower bound parsed with
     * level before our translator is invoked.
        String format,
        }
     * - Nanosecond precision timestamps for date_nanos (TIMESTAMP(9))
        // Relation check: per legacy SimpleMappedFieldType.rangeQuery() and DateFieldType.rangeQuery(),
 * RangeQueryBuilder.doToQuery which rewrites to ExistsQueryBuilder.
                conditions.add(bound);
import org.opensearch.dsl.converter.ConversionException;
    }
            // VARCHAR/CHAR and other types: keep string as-is for lexicographic comparison
        if (rangeQuery.boost() != AbstractQueryBuilder.DEFAULT_BOOST) {
                    return Integer.valueOf(strValue);
                : processValue(rangeQuery.from(), format, timeZone, !rangeQuery.includeLower(), fieldTypeName, fieldPrecision);
    /**
    }
        ConversionContext ctx
                    return bound; // overflow guard: match-none
     *         Number for string-to-number coercion, or original value
 * null fieldType yields DISJOINT relation and MatchNoneQueryBuilder.
 *
        // If format/timeZone specified or value is date-math, always date-parse
        Object value,
            return RangeDateBounds.parseDateValue(strValue, format, timeZone, roundUp, resolutionFor(fieldPrecision));
     * @param roundUp whether to round up to end of time unit (true) or down to start (false)
     * <p>
                case REAL:
     * @param timeZone optional timezone ID (e.g., "America/New_York", defaults to "UTC")
                case INTEGER:
     *   (starts with "now" or contains "||"), it is always parsed as a date value.
 * {@code IpFieldMapper.rangeQuery} with {@code InetAddressPoint.encode} byte ordering.
     * @return RexNode representing the range comparison(s)
     * - Numeric fields: coerced to number using the field's type
        if (!(value instanceof String)) {
        // No bounds -> IS_NOT_NULL (exists semantics), matching legacy RangeQueryBuilder.doToQuery
import org.opensearch.index.query.AbstractQueryBuilder;
     * <p>
            RexNode bound = translateBound(fromValue, true, rangeQuery.includeLower(), format, timeZone, field, ctx);
                case DOUBLE:
            Object toValue = isDateField
        String timeZone,
        int fieldPrecision = field.getType().getPrecision();
     * @param ctx the conversion context
 * Converts a {@link RangeQueryBuilder} to Calcite comparison RexNodes.
     * @throws ConversionException if boost specified, queryName specified, or DISJOINT relation
    public RexNode convert(QueryBuilder query, ConversionContext ctx) throws ConversionException {
                    return new BigDecimal(strValue);
            return ctx.getRexBuilder().makeLiteral(false);
import java.util.ArrayList;
                    return Double.valueOf(strValue);
        }
            );
        if (conditions.isEmpty()) {
            throw new ConversionException("Range query 'boost' parameter is not supported");
     * Field-type gating for string values (when no format/timeZone/date-math indicators):
     * Non-string values are returned as-is regardless of field type.
    @Override
    }
     * <p>
        try {
    private static final TranslatorMapperRegistry REGISTRY = TranslatorMapperRegistry.INSTANCE;
import org.apache.calcite.sql.fun.SqlStdOperatorTable;
                    return Double.valueOf(strValue);
            throw new ConversionException("Range query 'relation' parameter does not support DISJOINT");
        if (value == null) {
     * @param fieldTypeName the SqlTypeName of the target field
import org.apache.calcite.rex.RexNode;
            // For date fields, the mapper owns parsing - pass raw value with format/timeZone.
        if (rangeQuery.relation() == ShapeRelation.DISJOINT) {
        } catch (NumberFormatException e) {
     * Processes a range query value, with behavior gated on context and field type.
import org.opensearch.dsl.query.TranslatorMapperRegistry;
        Object value,
     * @param inclusive true if the original bound is inclusive (gte/lte vs gt/lt)
     * - Timezone handling (time_zone parameter, defaults to UTC)
        String timeZone,
            switch (fieldTypeName) {
        SqlTypeName fieldTypeName,
                if (bound instanceof RexLiteral && Boolean.FALSE.equals(((RexLiteral) bound).getValueAs(Boolean.class))) {
        List<RexNode> conditions = new ArrayList<>();
     */
            return value;
     * @param timeZone optional time zone from the range query
 * IP fields use 16-byte IPv6-mapped sortable encoding matching legacy
     * - TIMESTAMP/DATE and IP fields: delegated to per-type mapper classes via the TranslatorMapperRegistry
        }
                case TINYINT:
     * - No-bounds queries return IS_NOT_NULL (exists semantics)
     * - Date format conversion (format parameter)
     */
            // For non-date fields, pre-process here as before (numeric coercion, string passthrough).
                    // If the string has a decimal part, parse as Double to allow decimal-adjust logic
        // identical queries regardless of relation). Note: RangeQueryBuilder itself rejects DISJOINT
                }
import java.util.List;
    public Class<? extends QueryBuilder> getQueryType() {
 * SPDX-License-Identifier: Apache-2.0
        RangeQueryBuilder rangeQuery = (RangeQueryBuilder) query;
     * @param format optional date format from the range query
        } else {
        String strValue = (String) value;
     * Processing logic:
/**
     *
     * Handles:
     * <p>
 */
     * Relation handling: per legacy SimpleMappedFieldType behavior, the relation parameter is
        // which rewrites to ExistsQueryBuilder when both from and to are null.
        String format = rangeQuery.format();
 * <p>
 */
import java.math.BigDecimal;
     * Double so the decimal-adjust logic in convert() applies.
        // integer decimal-adjust, whole-integer, and generic tail) to the registry-resolved
import org.opensearch.dsl.query.QueryTranslator;
    private Number coerceToNumber(String strValue, SqlTypeName fieldTypeName) throws ConversionException {
import org.opensearch.index.query.RangeQueryBuilder;
            return null;
                }
 * Unmapped fields return literal false (no matches), matching legacy behavior where
import org.opensearch.common.geo.ShapeRelation;
                conditions.add(bound);
        if (value == null) {
/*
     * Returns the query type this translator handles.
            return strValue;
        // Unmapped field -> match-none (literal false), matching legacy DISJOINT for null fieldType.
    /** OpenSearch maps {@code date} to TIMESTAMP(3) and {@code date_nanos} to TIMESTAMP(9) (see OpenSearchSchemaBuilder.mapFieldType); any precision above 3 is nanosecond resolution. */
        return REGISTRY.resolve(field.getType()).translateBound(new BoundRequest(value, isLower, inclusive, format, timeZone, field, ctx));
package org.opensearch.dsl.query.range;
        // DISJOINT is rejected; INTERSECTS/CONTAINS/WITHIN are silently ignored (scalar fields produce
        // Delegate remaining types (including scaled_float, unsigned_long via tier 1,
        }
 * roundUp=!includeLower; upper bound parsed with roundUp=includeUpper. The DateMathParser itself
     * For integer-family types, if the string contains a decimal point, it is parsed as a
     * Translates a single range bound (lower or upper) into a comparison RexNode.
                ? rangeQuery.to()
        String timeZone = rangeQuery.timeZone();
     * - For numeric fields (INTEGER, BIGINT, DOUBLE, etc.): string values are coerced to numbers.
        // Upper bound: rounding keyed on inclusivity per DateFieldMapper.dateRangeQuery
                    if (strValue.contains(".")) {
            if (bound != null) {
            Object fromValue = isDateField
import org.apache.calcite.sql.type.SqlTypeName;
        String fieldName = rangeQuery.fieldName();
     * <p>
                if (bound instanceof RexLiteral && Boolean.FALSE.equals(((RexLiteral) bound).getValueAs(Boolean.class))) {
     *
     * - VARCHAR/CHAR fields: kept as-is for lexicographic comparison
 * No-bounds queries return IS_NOT_NULL (exists semantics), matching legacy
                    return Float.valueOf(strValue);
        }
                    }
     * - Date math expressions (now-7d, now/d, etc.)
        boolean isLower,
                    return bound; // overflow guard: match-none
        if (rangeQuery.to() != null) {
     * @param value the processed bound value (may be null)
     * Applies decimal truncation and overflow guards for integer-typed fields per legacy
 * Decimal bounds on integer-typed fields are truncated and adjusted per legacy
        RelDataTypeField field,
 * this file be licensed under the Apache-2.0 license or a
 * {@code NumberFieldMapper.NumberType.INTEGER.rangeQuery} semantics.
        return isNanoPrecision(precision) ? RangeDateBounds.DateResolution.NANOSECONDS : RangeDateBounds.DateResolution.MILLISECONDS;
        if (RangeBoundMath.isNumericType(fieldTypeName)) {
     * - Numeric and date range comparisons (gte, gt, lte, lt)
        // Lower bound: rounding keyed on inclusivity per DateFieldMapper.dateRangeQuery
     * - Rejection of unsupported _name (queryName) parameter
     */
    }
        RexNode fieldRef = ctx.getRexBuilder().makeInputRef(field.getType(), field.getIndex());
                ? rangeQuery.from()
     * @param fieldPrecision the precision of the field (3 for date/millis, 9 for date_nanos)
                        return Long.valueOf(strValue);
 * The OpenSearch Contributors require contributions made to
    private static boolean isNanoPrecision(int precision) {
     * For epoch_millis format, timezone is ignored since epoch is absolute.
    /**
 * <p>
            }
     * - Decimal-to-integer truncation per legacy NumberFieldMapper INTEGER.rangeQuery
            throw new ConversionException(
     * @return RexNode comparison, literal false for overflow match-none, or null if value is null
                case BIGINT:
            throw new ConversionException("Range query '_name' parameter is not supported");
     *
            return ctx.getRexBuilder().makeCall(SqlStdOperatorTable.IS_NOT_NULL, fieldRef);
 * <p>
    }
            return coerceToNumber(strValue, fieldTypeName);
        return RangeQueryBuilder.class;
 * <p>
    /**
        }
     * - Millisecond precision timestamps (TIMESTAMP(3))
                "Failed to coerce value '" + strValue + "' to numeric type " + fieldTypeName + ": " + e.getMessage()
        }
import org.opensearch.dsl.converter.ConversionContext;
     * @param field the field definition from the schema
        }
        }
 * Implements date math expressions, inclusivity-keyed rounding, and millisecond/nanosecond precision.
     * {@code NumberFieldMapper.NumberType.INTEGER.rangeQuery} semantics.
        if (format != null || timeZone != null || RangeDateBounds.isDateMathExpression(strValue)) {
     * @param format optional date format pattern (e.g., "dd/MM/yyyy")
        }
        }
        String format,
    private Object processValue(
                : processValue(rangeQuery.to(), format, timeZone, rangeQuery.includeUpper(), fieldTypeName, fieldPrecision);
    /**
import org.apache.calcite.rex.RexLiteral;
    @Override
     * @param isLower true if this is the lower bound, false for upper
        RelDataTypeField field = ctx.getRowType().getField(fieldName, false, false);
        boolean isDateField = RangeDateBounds.isDateType(fieldTypeName);
 * <p>
            RexNode bound = translateBound(toValue, false, rangeQuery.includeUpper(), format, timeZone, field, ctx);
     *
        SqlTypeName fieldTypeName = field.getType().getSqlTypeName();
     * @param query the RangeQueryBuilder to convert
     * - Unmapped fields return literal false (match-none)
        }
    }
        if (field == null) {
     * <p>
            }
     * @return RangeQueryBuilder.class
            if (bound != null) {
 * handles explicit rounding operators (/d etc.) using the roundUp flag.
     * queries). DISJOINT is rejected, though RangeQueryBuilder itself rejects it at builder
        boolean inclusive,
        return precision > 3;
