            RexNode bound = translateBound(fromValue, true, rangeQuery.includeLower(), format, timeZone, field, ctx);  
        }
/*  
     * @return RangeQueryBuilder.class
     */  
import org.opensearch.common.geo.ShapeRelation;  
                    return bound; // overflow guard: match-none
     * - Timezone handling (time_zone parameter, defaults to UTC)  
import org.apache.calcite.rex.RexNode;  
    /**
    }  
        }  
            throw new ConversionException(
        boolean isDateField = RangeDateBounds.isDateType(fieldTypeName);  
import org.apache.calcite.rel.type.RelDataTypeField;
                case SMALLINT:
     * - Decimal-to-integer truncation per legacy NumberFieldMapper INTEGER.rangeQuery  
        return REGISTRY.resolve(field.getType()).translateBound(new BoundRequest(value, isLower, inclusive, format, timeZone, field, ctx));  
/**
                "Failed to coerce value '" + strValue + "' to numeric type " + fieldTypeName + ": " + e.getMessage()  
 * IP fields use 16-byte IPv6-mapped sortable encoding matching legacy
     *  
            throw new ConversionException("Range query '_name' parameter is not supported");  
     * Returns the query type this translator handles.  
    }
        RexNode fieldRef = ctx.getRexBuilder().makeInputRef(field.getType(), field.getIndex());
        // Unmapped field -> match-none (literal false), matching legacy DISJOINT for null fieldType.
                case DECIMAL:
                case DOUBLE:  
     * @param format optional date format from the range query
     * @throws ConversionException if boost specified, queryName specified, or DISJOINT relation  
            // VARCHAR/CHAR and other types: keep string as-is for lexicographic comparison
    public RexNode convert(QueryBuilder query, ConversionContext ctx) throws ConversionException {  
     * - TIMESTAMP/DATE and IP fields: delegated to per-type mapper classes via the TranslatorMapperRegistry
    ) throws ConversionException {  
        } catch (NumberFormatException e) {
     * @param value the value to process (can be String, Long, or other types)
                    return Double.valueOf(strValue);
    public Class<? extends QueryBuilder> getQueryType() {
     * For integer-family types, if the string contains a decimal point, it is parsed as a  
        SqlTypeName fieldTypeName,
     * - Date math expressions (now-7d, now/d, etc.)
     * @param value the processed bound value (may be null)
     * Translates a single range bound (lower or upper) into a comparison RexNode.  
     * @throws ConversionException if date parsing fails or numeric coercion fails  
     * For epoch_millis format, timezone is ignored since epoch is absolute.
        // Gate on field type
 * Implements date math expressions, inclusivity-keyed rounding, and millisecond/nanosecond precision.
     * @return processed value as epoch milliseconds (Long) for date, epoch nanos (Long) for date_nanos,
                }
        if (rangeQuery.boost() != AbstractQueryBuilder.DEFAULT_BOOST) {
 * roundUp=!includeLower; upper bound parsed with roundUp=includeUpper. The DateMathParser itself
        // including VARCHAR/CHAR keyword ranges.
import java.math.BigDecimal;  
     * - IP field range with InetAddress-order byte comparison
     * Handles:  
     * Converts a RangeQueryBuilder to a Calcite RexNode expression.
        if (rangeQuery.relation() == ShapeRelation.DISJOINT) {
     * - Date format conversion (format parameter)
        // mapper. The catch-all DefaultTranslatorMapper carries the entire non-UDT path
                case BIGINT:
     * Relation handling: per legacy SimpleMappedFieldType behavior, the relation parameter is
        return conditions.size() == 1 ? conditions.get(0) : ctx.getRexBuilder().makeCall(SqlStdOperatorTable.AND, conditions);
        String strValue = (String) value;  
        }  
                    }
            if (bound != null) {
 * Decimal bounds on integer-typed fields are truncated and adjusted per legacy
                if (bound instanceof RexLiteral && Boolean.FALSE.equals(((RexLiteral) bound).getValueAs(Boolean.class))) {
 * <p>  
        return RangeQueryBuilder.class;  
            Object toValue = isDateField
                if (bound instanceof RexLiteral && Boolean.FALSE.equals(((RexLiteral) bound).getValueAs(Boolean.class))) {
                case FLOAT:
public class RangeQueryTranslator implements QueryTranslator {
    /**  
 * The OpenSearch Contributors require contributions made to  
     * Processes a range query value, with behavior gated on context and field type.
        }
import org.opensearch.dsl.query.TranslatorMapperRegistry;
     * <p>
 * this file be licensed under the Apache-2.0 license or a
     * - Inclusivity-keyed rounding per legacy DateFieldMapper.dateRangeQuery
     * @param roundUp whether to round up to end of time unit (true) or down to start (false)
     */
     *   (starts with "now" or contains "||"), it is always parsed as a date value.
                case TINYINT:  
     * queries). DISJOINT is rejected, though RangeQueryBuilder itself rejects it at builder
import org.apache.calcite.sql.fun.SqlStdOperatorTable;
                    return Integer.valueOf(strValue);
        if (rangeQuery.from() != null) {  
     * level before our translator is invoked.
     */
        String timeZone,  
     * - Nanosecond precision timestamps for date_nanos (TIMESTAMP(9))
     * @return RexNode comparison, literal false for overflow match-none, or null if value is null
                conditions.add(bound);
                ? rangeQuery.to()  
        }  
    /**  
                    return new BigDecimal(strValue);  
            Object fromValue = isDateField  
            if (bound != null) {  
        }
     *
        int fieldPrecision
        if (format != null || timeZone != null || RangeDateBounds.isDateMathExpression(strValue)) {  
        }  
     * <p>  
            return value;  
            );
            // For date fields, the mapper owns parsing - pass raw value with format/timeZone.
 * <p>  
            // For non-date fields, pre-process here as before (numeric coercion, string passthrough).
    @Override
import org.apache.calcite.sql.type.SqlTypeName;
            RexNode bound = translateBound(toValue, false, rangeQuery.includeUpper(), format, timeZone, field, ctx);
     * @param ctx the conversion context
     * - Unmapped fields return literal false (match-none)
        try {
        // Delegate remaining types (including scaled_float, unsigned_long via tier 1,
        if (rangeQuery.to() != null) {
        if (value == null) {
        int fieldPrecision = field.getType().getPrecision();  
package org.opensearch.dsl.query.range;
        List<RexNode> conditions = new ArrayList<>();
     * @param field the field definition from the schema  
        boolean inclusive,
    }
        // Upper bound: rounding keyed on inclusivity per DateFieldMapper.dateRangeQuery  
        Object value,
 * RangeQueryBuilder.doToQuery which rewrites to ExistsQueryBuilder.
    }
     * @param query the RangeQueryBuilder to convert  
    }
        }
                    if (fieldTypeName == SqlTypeName.BIGINT) {
     * @param fieldTypeName the SqlTypeName of the target field
        String fieldName = rangeQuery.fieldName();
 * <p>  
     * - For numeric fields (INTEGER, BIGINT, DOUBLE, etc.): string values are coerced to numbers.  
            return ctx.getRexBuilder().makeCall(SqlStdOperatorTable.IS_NOT_NULL, fieldRef);
    private Object processValue(
     * Double so the decimal-adjust logic in convert() applies.
 * <p>  
     * Applies decimal truncation and overflow guards for integer-typed fields per legacy
            return null;
     * @param fieldPrecision the precision of the field (3 for date/millis, 9 for date_nanos)  
     * <p>
                    return bound; // overflow guard: match-none  
                    if (strValue.contains(".")) {
        }  
                case REAL:  
 * No-bounds queries return IS_NOT_NULL (exists semantics), matching legacy
        String timeZone = rangeQuery.timeZone();
            return RangeDateBounds.parseDateValue(strValue, format, timeZone, roundUp, resolutionFor(fieldPrecision));
                    return Double.valueOf(strValue);
    private RexNode translateBound(
     * @param inclusive true if the original bound is inclusive (gte/lte vs gt/lt)  
        // identical queries regardless of relation). Note: RangeQueryBuilder itself rejects DISJOINT
        // If format/timeZone specified or value is date-math, always date-parse
        if (value == null) {
     *  
     * <p>
                case INTEGER:  
 * null fieldType yields DISJOINT relation and MatchNoneQueryBuilder.
        boolean isLower,  
 * <p>
                : processValue(rangeQuery.from(), format, timeZone, !rangeQuery.includeLower(), fieldTypeName, fieldPrecision);
    private static final TranslatorMapperRegistry REGISTRY = TranslatorMapperRegistry.INSTANCE;  
            return null;
        String format = rangeQuery.format();
        }  
 * compatible open source license.
     * {@code NumberFieldMapper.NumberType.INTEGER.rangeQuery} semantics.
    /** Selects the date resolution matching the field precision. */
            }  
import java.util.ArrayList;
        // which rewrites to ExistsQueryBuilder when both from and to are null.  
     * Processing logic:  
                    return Float.valueOf(strValue);
            throw new ConversionException("Range query 'relation' parameter does not support DISJOINT");
    }  
     * Field-type gating for string values (when no format/timeZone/date-math indicators):
 * Supports gte, gt, lte, lt operators, format, time_zone, and relation parameters.  
        RelDataTypeField field,
        if (!(value instanceof String)) {
        return precision > 3;
    }
        } else {
    /**
        // integer decimal-adjust, whole-integer, and generic tail) to the registry-resolved  
 * Converts a {@link RangeQueryBuilder} to Calcite comparison RexNodes.
        SqlTypeName fieldTypeName = field.getType().getSqlTypeName();
        Object value,  
     * - Numeric and date range comparisons (gte, gt, lte, lt)
 * SPDX-License-Identifier: Apache-2.0
     * Coerces a string value to a numeric type matching the field.
     *
            }
        }
            return ctx.getRexBuilder().makeLiteral(false);
            throw new ConversionException("Range query 'boost' parameter is not supported");
                        return Double.valueOf(strValue);  
            return strValue;  
            return coerceToNumber(strValue, fieldTypeName);  
     * @param isLower true if this is the lower bound, false for upper
            switch (fieldTypeName) {
        if (RangeBoundMath.isNumericType(fieldTypeName)) {
     * @return RexNode representing the range comparison(s)
        String format,
        // Lower bound: rounding keyed on inclusivity per DateFieldMapper.dateRangeQuery
import java.util.List;
 * {@code IpFieldMapper.rangeQuery} with {@code InetAddressPoint.encode} byte ordering.
     */
                : processValue(rangeQuery.to(), format, timeZone, rangeQuery.includeUpper(), fieldTypeName, fieldPrecision);
        RelDataTypeField field = ctx.getRowType().getField(fieldName, false, false);  
        return isNanoPrecision(precision) ? RangeDateBounds.DateResolution.NANOSECONDS : RangeDateBounds.DateResolution.MILLISECONDS;  
        ConversionContext ctx
     * - VARCHAR/CHAR fields: kept as-is for lexicographic comparison
 * {@code NumberFieldMapper.NumberType.INTEGER.rangeQuery} semantics.
        // at builder level, so this is a defensive check.  
     * @param timeZone optional timezone ID (e.g., "America/New_York", defaults to "UTC")  
        String format,
                    // If the string has a decimal part, parse as Double to allow decimal-adjust logic
    private static boolean isNanoPrecision(int precision) {  
        // Relation check: per legacy SimpleMappedFieldType.rangeQuery() and DateFieldType.rangeQuery(),  
import org.opensearch.dsl.converter.ConversionContext;
                default:
     * <p>
     * - Numeric fields: coerced to number using the field's type  
        }  
     * - No-bounds queries return IS_NOT_NULL (exists semantics)
import org.apache.calcite.rex.RexLiteral;
     *         Number for string-to-number coercion, or original value
        String timeZone,
        boolean roundUp,  
    private Number coerceToNumber(String strValue, SqlTypeName fieldTypeName) throws ConversionException {  
import org.opensearch.index.query.AbstractQueryBuilder;
}  
 */  
     * Non-string values are returned as-is regardless of field type.  
 * Unmapped fields return literal false (no matches), matching legacy behavior where
    ) throws ConversionException {  
    private static RangeDateBounds.DateResolution resolutionFor(int precision) {
        if (rangeQuery.queryName() != null) {
        }
 * Date rounding follows legacy {@code DateFieldMapper.dateRangeQuery}: lower bound parsed with  
     * - Rejection of unsupported _name (queryName) parameter  
    /** OpenSearch maps {@code date} to TIMESTAMP(3) and {@code date_nanos} to TIMESTAMP(9) (see OpenSearchSchemaBuilder.mapFieldType); any precision above 3 is nanosecond resolution. */
 * handles explicit rounding operators (/d etc.) using the roundUp flag.
 */  
        // DISJOINT is rejected; INTERSECTS/CONTAINS/WITHIN are silently ignored (scalar fields produce
import org.opensearch.index.query.QueryBuilder;  
        if (conditions.isEmpty()) {
    /**
                    }
     * <p>
        if (field == null) {
     * @param format optional date format pattern (e.g., "dd/MM/yyyy")
     * - For VARCHAR/CHAR fields: string values are kept as-is for lexicographic comparison.
                ? rangeQuery.from()
            }  
     * @param timeZone optional time zone from the range query
     * - Millisecond precision timestamps (TIMESTAMP(3))  
import org.opensearch.dsl.converter.ConversionException;
    @Override
     * silently ignored for scalar fields (INTERSECTS, CONTAINS, WITHIN all produce identical  
                }  
 *
     */  
     * @param ctx the conversion context containing schema and RexBuilder
        RangeQueryBuilder rangeQuery = (RangeQueryBuilder) query;
import org.opensearch.dsl.query.QueryTranslator;  
                conditions.add(bound);
                        return Long.valueOf(strValue);  
        // No bounds -> IS_NOT_NULL (exists semantics), matching legacy RangeQueryBuilder.doToQuery
import org.opensearch.index.query.RangeQueryBuilder;
     * - If format or timeZone is specified, or the string is a date-math expression
