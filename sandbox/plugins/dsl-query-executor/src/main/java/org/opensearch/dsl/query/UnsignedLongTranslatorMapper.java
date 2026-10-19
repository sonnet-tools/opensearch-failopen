    }
            throw new ConversionException(  
        RexNode fieldRef = ctx.getRexBuilder().makeInputRef(field.getType(), field.getIndex());
        RexNode literal = ctx.getRexBuilder().makeLiteral(longValue, field.getType(), true);  
        double sign = Math.signum(doubleValue);
            throw new ConversionException(
            // and produce a garbage truncation via (long) NaN = 0. Legacy throws IAE for non-finite.
     * and {@code termsQuery} skips such values. We mirror this by returning null.
     * can never match a whole-number document value, so return {@code Optional.empty()} for them
                    + originalValue
            return (long) doubleValue;  
                    );  
        }
            return;
                longValue++;  
                            + fieldName  
        // WHY: Strings like "NaN", "Infinity" are accepted by Double.parseDouble but not BigDecimal;
    static final UnsignedLongTranslatorMapper INSTANCE = new UnsignedLongTranslatorMapper();
    }  
     * decimal truncation, and overflow guards.  
        SqlOperator op = isLower ? SqlStdOperatorTable.GREATER_THAN_OR_EQUAL : SqlStdOperatorTable.LESS_THAN_OR_EQUAL;
                            + "': "
            throw new ConversionException("Non-numeric term value for unsigned_long field '" + fieldName + "': " + value);  
        }
        return Optional.of(literal);
        }
        // For integers types already known to fit in long, skip
    }
    /** Checks if a Number value exceeds Long.MAX_VALUE using BigDecimal precision. */  
     */  
                }  
            return d;
    // ========== UNSIGNED_LONG TERM HELPERS ==========
    /**
        return ctx.getRexBuilder().makeCall(op, fieldRef, literal);  
        }
        } else {
        }
        }
     * Translates a single range bound for an unsigned_long field applying legacy
     * Converts one value to a typed literal for unsigned_long term/terms queries.  
                if (bd.compareTo(BigDecimal.valueOf(Long.MAX_VALUE)) > 0) {
package org.opensearch.dsl.query;
            double d = num.doubleValue();  
            }
    /** Singleton instance. */
        BigDecimal bd;
                throw new ConversionException(
}  
    private static boolean hasDecimalPartForUnsignedLong(Object value, double doubleValue) {
                return null;
 */
                    "Non-finite value (" + value + ") is not supported for unsigned_long field '" + fieldName + "'"  
     * Mirrors {@code NumberFieldMapper.hasDecimalPart}.
    /**  
import org.apache.calcite.sql.fun.SqlStdOperatorTable;
        // Parse the value to a double for sign/decimal checks.  
/**  
            }
import org.opensearch.dsl.query.range.RangeBoundMath;
     * match-none (returned as null); values above Long.MAX_VALUE throw ConversionException.  
            }
 * this file be licensed under the Apache-2.0 license or a
        }
                        + "': "
                }
final class UnsignedLongTranslatorMapper extends BaseTranslatorMapper {
            throw new ConversionException("Non-finite value (" + value + ") is not supported for unsigned_long field '" + fieldName + "'");
 * Translator mapper for {@code unsigned_long} fields. Implements bound translation logic
        // values below 0 clamp to 0 (lower) or match-none (upper).
     * Truncates to long for unsigned_long bound handling. Uses BigDecimal for string values
        // For Double/Float, compare against Long.MAX_VALUE with tolerance  
                    + "': "
        }
                }
 * directly (negative clamping, decimal truncation, overflow guards) and term parsing inline.
        if (bd.compareTo(BigDecimal.valueOf(Long.MAX_VALUE)) > 0) {
        long longValue = truncateToLong(value, doubleValue);
                );
     */
            }
        // Decimal part → match-none per legacy NumberFieldMapper.UNSIGNED_LONG.termsQuery
     *
import org.apache.calcite.rel.type.RelDataTypeField;
        // Negative bounds: per NumberFieldMapper.objectToUnsignedLong(lenientBound=true),  
/*  
 *  
import org.opensearch.dsl.converter.ConversionException;  
    private static Long parseUnsignedLongTerm(Object value, String fieldName) throws ConversionException {  
        return bd.longValue();
                    "Unsigned long range bound above Long.MAX_VALUE is not representable on the DSL path "
 * the schema. No per-field state is held; all parameters are derived from the
            // WHY: NaN/Infinity on unsigned_long would pass the < 0 check (NaN comparisons are false)
            );  
                        + fieldName
        }  
    }
            bd = new BigDecimal(str);
                        + "(schema_coerce.rs UInt64→Int64 narrowing) for field '"  
        if (bd.signum() < 0) {
            double doubleValue = num.doubleValue();  
                    + "(schema_coerce.rs UInt64→Int64 narrowing) for field '"
        RexNode literal = ctx.getRexBuilder().makeLiteral(longVal, field.getType(), true);  
                if (longValue == Long.MAX_VALUE) {  
        }  
            return new BigDecimal(value.toString()).toBigInteger().longValue();  
        try {
     * toward zero) matching legacy BigInteger truncation.
        if (value == null) {
     * @return the long value, or null to signal match-none (negative or decimal input)  
     * to avoid double precision loss on large longs; Number values use longValue() (floor  
    @Override
                longValue--;
    /**  
        // (a) Value in [0, Long.MAX_VALUE]: apply legacy decimal truncate+adjust.
            if ((!hasDecimal && !inclusive) || (hasDecimal && sign > 0)) {
                if (longValue == 0) {
     * Parses an unsigned_long bound value to double for sign and magnitude checks.
     * Mirrors {@code NumberFieldMapper.NumberType.UNSIGNED_LONG.termQuery}: fractional values
    public Optional<RexNode> toTermLiteral(Object value, RelDataTypeField field, ConversionContext ctx) throws ConversionException {  
            if (doubleValue % 1 != 0) {
 * <p>This mapper is a stateless singleton shared across every {@code unsigned_long} field in
            if (value instanceof Double || value instanceof Float) {
     * {@code NumberFieldMapper.unsignedLongRangeQuery} semantics: negative clamping,
            if (num instanceof Long || num instanceof Integer || num instanceof Short || num instanceof Byte) {  
                    + value  
     * <p>Legacy behavior: {@code NumberFieldMapper.NumberType.UNSIGNED_LONG.termQuery} returns
    }
        if (value instanceof Number num) {  
        try {  
        long longVal = unsignedValue;
                    return ctx.getRexBuilder().makeLiteral(false);
     * double precision loss (Long.MAX_VALUE and Long.MAX_VALUE+1 are indistinguishable as doubles).
        } catch (NumberFormatException e) {
            BigDecimal bd = new BigDecimal(str);
 * {@code RelDataType} on each call.  
            checkAboveLongMax(num, value, fieldName);  
                throw new ConversionException(
            }
            if (bd.compareTo(BigDecimal.valueOf(Long.MAX_VALUE)) > 0) {  
        double doubleValue = parseUnsignedLongBound(value, field.getName());
        }  
        if (RangeBoundMath.isNonFinite(str)) {
 * The OpenSearch Contributors require contributions made to  
                    + "': "
            // For whole numbers, preserve exact long value
        String str = value.toString();
                    + "(schema_coerce.rs UInt64→Int64 narrowing) for field '"  
                    throw new ConversionException(  
        } catch (NumberFormatException e) {
            if (isLower) {  
            }  
        String str = value.toString();
            return null;  
                BigDecimal bd = BigDecimal.valueOf(num.doubleValue());
        }  
    private static void checkAboveLongMax(Number num, Object originalValue, String fieldName) throws ConversionException {
        if (doubleValue < 0) {
        }  
            return null;
            if (doubleValue < 0) {
        // String: use BigDecimal to preserve precision for large values
                return num.longValue();
                    return ctx.getRexBuilder().makeLiteral(false);
    protected RexNode translateBound(Object value, boolean isLower, boolean inclusive, RelDataTypeField field, ConversionContext ctx)  
                            + value
                );
import org.opensearch.dsl.converter.ConversionContext;
    @Override
        return doubleValue % 1 != 0;
        if (bd.stripTrailingZeros().scale() > 0) {  
            }
        boolean hasDecimal = hasDecimalPartForUnsignedLong(value, doubleValue);  
import org.apache.calcite.rex.RexNode;
                        + value  
                    + fieldName
    private static long truncateToLong(Object value, double doubleValue) {  
        // String value: parse and check via BigDecimal for precision  
        BigDecimal bd = BigDecimal.valueOf(num.doubleValue());
     * Mirrors {@code NumberFieldMapper.objectToDouble} pathway used by objectToUnsignedLong.
import java.util.Optional;
            return bd.doubleValue();  
            }
                "Unsigned long range bound above Long.MAX_VALUE is not representable on the DSL path "
        throws ConversionException {
 *
            // Decimal part → match-none per legacy NumberFieldMapper.UNSIGNED_LONG.termQuery
                            + "(schema_coerce.rs UInt64→Int64 narrowing) for field '"
     * For values that may be above Long.MAX_VALUE, uses BigDecimal comparison to avoid  
     * Parses and validates a term value for an unsigned_long field.
    private static double parseUnsignedLongBound(Object value, String fieldName) throws ConversionException {
     * @throws ConversionException on non-numeric or above Long.MAX_VALUE
            return Optional.empty();  
            if ((!hasDecimal && !inclusive) || (hasDecimal && sign < 0)) {  
            return null;
        // String value  
        if (value instanceof Number num) {
     * (match-none semantics). Negative values also return empty.  
        if (num instanceof Long || num instanceof Integer || num instanceof Short || num instanceof Byte) {  
    private UnsignedLongTranslatorMapper() {}
        if (bd.compareTo(BigDecimal.valueOf(Long.MAX_VALUE)) > 0) {  
     *
     * Checks if the value has a non-zero fractional part, for unsigned_long bound adjustment.
            if (!(num instanceof Long || num instanceof Integer || num instanceof Short || num instanceof Byte)) {  
                return null;
     * @throws ConversionException if non-numeric, non-finite, or above Long.MAX_VALUE  
import java.math.BigDecimal;  
    }
                return ctx.getRexBuilder().makeLiteral(false);  
    /**  
            } else {
        // Legacy unsignedLongRangeQuery: increment/decrement for exclusive or decimal bounds.  
            throw new ConversionException("Non-numeric range bound for unsigned_long field '" + fieldName + "': " + value);
        if (value instanceof Number) {
 * SPDX-License-Identifier: Apache-2.0
    /**
     * MatchNoDocsQuery for values with a decimal part (2.5 cannot equal any whole-number doc),  
     */
     */
     *
                return (long) doubleValue;  
     */
        // Emit inclusive comparison (adjustments above made the bound inclusive).
            );
            return ((Number) value).longValue();
 */  
 * compatible open source license.
        Long unsignedValue = parseUnsignedLongTerm(value, field.getName());
                "Unsigned long term value above Long.MAX_VALUE is not representable on the DSL path "
        }
        if (unsignedValue == null) {
            }
            }
        try {
     * Values in [0, Long.MAX_VALUE] return the long; negative values and decimals signal
        }
            return (long) doubleValue;
    }
        } catch (NumberFormatException e) {
                    + fieldName  
    /**  
                        "Unsigned long term value above Long.MAX_VALUE is not representable on the DSL path "
        }  
            // Check above Long.MAX first using BigDecimal
import org.apache.calcite.sql.SqlOperator;  
        // reject them explicitly with a clear message matching the Number path.  
        if (isLower) {
     */
            if (Double.isNaN(d) || Double.isInfinite(d)) {
                return null;  
