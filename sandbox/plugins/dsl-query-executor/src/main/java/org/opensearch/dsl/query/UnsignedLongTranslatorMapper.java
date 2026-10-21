            return null;
            throw new ConversionException("Non-numeric term value for unsigned_long field '" + fieldName + "': " + value);
        if (value instanceof Number num) {
                return null;
        // Parse the value to a double for sign/decimal checks.
        return bd.longValue();
        // Legacy unsignedLongRangeQuery: increment/decrement for exclusive or decimal bounds.
            // For whole numbers, preserve exact long value
 *
        // String value
                BigDecimal bd = BigDecimal.valueOf(num.doubleValue());
        }
    @Override
        // For Double/Float, compare against Long.MAX_VALUE with tolerance
        if (bd.compareTo(BigDecimal.valueOf(Long.MAX_VALUE)) > 0) {
     * {@code NumberFieldMapper.unsignedLongRangeQuery} semantics: negative clamping,
 * this file be licensed under the Apache-2.0 license or a
                return ctx.getRexBuilder().makeLiteral(false);
        // Negative bounds: per NumberFieldMapper.objectToUnsignedLong(lenientBound=true),
     * Checks if the value has a non-zero fractional part, for unsigned_long bound adjustment.
                if (longValue == 0) {
                        + fieldName
        long longValue = truncateToLong(value, doubleValue);
     * double precision loss (Long.MAX_VALUE and Long.MAX_VALUE+1 are indistinguishable as doubles).
 * <p>This mapper is a stateless singleton shared across every {@code unsigned_long} field in
            bd = new BigDecimal(str);
        try {
        if (bd.signum() < 0) {
import org.apache.calcite.rex.RexNode;
                            + fieldName
    protected RexNode translateBound(Object value, boolean isLower, boolean inclusive, RelDataTypeField field, ConversionContext ctx)
     * @throws ConversionException on non-numeric or above Long.MAX_VALUE
    /**
import org.opensearch.dsl.converter.ConversionContext;
    static final UnsignedLongTranslatorMapper INSTANCE = new UnsignedLongTranslatorMapper();
            }
        try {
     * (match-none semantics). Negative values also return empty.
 * SPDX-License-Identifier: Apache-2.0
        }
        // values below 0 clamp to 0 (lower) or match-none (upper).
    private static long truncateToLong(Object value, double doubleValue) {
     * Converts one value to a typed literal for unsigned_long term/terms queries.
        if (num instanceof Long || num instanceof Integer || num instanceof Short || num instanceof Byte) {
        if (isLower) {
            } else {
     * match-none (returned as null); values above Long.MAX_VALUE throw ConversionException.
                    "Non-finite value (" + value + ") is not supported for unsigned_long field '" + fieldName + "'"
                );
                }
                    + "': "
            if (Double.isNaN(d) || Double.isInfinite(d)) {
        // String value: parse and check via BigDecimal for precision
/**
            return (long) doubleValue;
        } catch (NumberFormatException e) {
     * decimal truncation, and overflow guards.
     */
                    + "(schema_coerce.rs UInt64→Int64 narrowing) for field '"
            if (num instanceof Long || num instanceof Integer || num instanceof Short || num instanceof Byte) {
                    + originalValue
     */
            if (isLower) {
                return num.longValue();
     * Parses and validates a term value for an unsigned_long field.
                    + fieldName
                        + "(schema_coerce.rs UInt64→Int64 narrowing) for field '"
        } else {
 * directly (negative clamping, decimal truncation, overflow guards) and term parsing inline.
            double doubleValue = num.doubleValue();
        return doubleValue % 1 != 0;
            if (value instanceof Double || value instanceof Float) {
        // Emit inclusive comparison (adjustments above made the bound inclusive).
     * to avoid double precision loss on large longs; Number values use longValue() (floor
            }
    /**
     * and {@code termsQuery} skips such values. We mirror this by returning null.
            return d;
                throw new ConversionException(
    /**
            throw new ConversionException("Non-finite value (" + value + ") is not supported for unsigned_long field '" + fieldName + "'");
            if (bd.compareTo(BigDecimal.valueOf(Long.MAX_VALUE)) > 0) {
 * {@code RelDataType} on each call.
        // String: use BigDecimal to preserve precision for large values
     * MatchNoDocsQuery for values with a decimal part (2.5 cannot equal any whole-number doc),
import org.opensearch.dsl.query.range.RangeBoundMath;
        }
    }
            double d = num.doubleValue();
    private static double parseUnsignedLongBound(Object value, String fieldName) throws ConversionException {
     * Parses an unsigned_long bound value to double for sign and magnitude checks.
        return Optional.of(literal);
     * For values that may be above Long.MAX_VALUE, uses BigDecimal comparison to avoid
        }
}
            );
    }
        double doubleValue = parseUnsignedLongBound(value, field.getName());
        // (a) Value in [0, Long.MAX_VALUE]: apply legacy decimal truncate+adjust.
     */
 *
        SqlOperator op = isLower ? SqlStdOperatorTable.GREATER_THAN_OR_EQUAL : SqlStdOperatorTable.LESS_THAN_OR_EQUAL;
                longValue++;
 * Translator mapper for {@code unsigned_long} fields. Implements bound translation logic
        if (RangeBoundMath.isNonFinite(str)) {
    /**
        }
            if ((!hasDecimal && !inclusive) || (hasDecimal && sign < 0)) {
final class UnsignedLongTranslatorMapper extends BaseTranslatorMapper {
                    );
        if (doubleValue < 0) {
            }
import org.apache.calcite.sql.fun.SqlStdOperatorTable;
import org.apache.calcite.rel.type.RelDataTypeField;
                throw new ConversionException(
            return new BigDecimal(value.toString()).toBigInteger().longValue();
            }
     *
            throw new ConversionException(
        if (bd.compareTo(BigDecimal.valueOf(Long.MAX_VALUE)) > 0) {
            if (doubleValue % 1 != 0) {
     */
        }
        }
 * the schema. No per-field state is held; all parameters are derived from the
        }
        }
     * Translates a single range bound for an unsigned_long field applying legacy
                return null;
            if (doubleValue < 0) {
        return ctx.getRexBuilder().makeCall(op, fieldRef, literal);
            );
     * Mirrors {@code NumberFieldMapper.hasDecimalPart}.
     * toward zero) matching legacy BigInteger truncation.
            return null;
        long longVal = unsignedValue;
     * Values in [0, Long.MAX_VALUE] return the long; negative values and decimals signal
        }
    // ========== UNSIGNED_LONG TERM HELPERS ==========
    }
        } catch (NumberFormatException e) {
 * The OpenSearch Contributors require contributions made to
            // WHY: NaN/Infinity on unsigned_long would pass the < 0 check (NaN comparisons are false)
                    throw new ConversionException(
        try {
        // For integers types already known to fit in long, skip
            return;
import org.opensearch.dsl.converter.ConversionException;
        // reject them explicitly with a clear message matching the Number path.
            }
        } catch (NumberFormatException e) {
        }
 * compatible open source license.
    private static void checkAboveLongMax(Number num, Object originalValue, String fieldName) throws ConversionException {
                        + value
                "Unsigned long range bound above Long.MAX_VALUE is not representable on the DSL path "
                return null;
            return bd.doubleValue();
    private static boolean hasDecimalPartForUnsignedLong(Object value, double doubleValue) {
                            + "(schema_coerce.rs UInt64→Int64 narrowing) for field '"
                    + "(schema_coerce.rs UInt64→Int64 narrowing) for field '"
                    return ctx.getRexBuilder().makeLiteral(false);
        RexNode fieldRef = ctx.getRexBuilder().makeInputRef(field.getType(), field.getIndex());
     *
 */
            throw new ConversionException(
     * <p>Legacy behavior: {@code NumberFieldMapper.NumberType.UNSIGNED_LONG.termQuery} returns
    private static Long parseUnsignedLongTerm(Object value, String fieldName) throws ConversionException {
import java.math.BigDecimal;
            return (long) doubleValue;
     * @return the long value, or null to signal match-none (negative or decimal input)
    @Override
            // Decimal part → match-none per legacy NumberFieldMapper.UNSIGNED_LONG.termQuery
     * @throws ConversionException if non-numeric, non-finite, or above Long.MAX_VALUE
    /** Checks if a Number value exceeds Long.MAX_VALUE using BigDecimal precision. */
                }
            }
                    + fieldName
                "Unsigned long term value above Long.MAX_VALUE is not representable on the DSL path "
        boolean hasDecimal = hasDecimalPartForUnsignedLong(value, doubleValue);
     * Truncates to long for unsigned_long bound handling. Uses BigDecimal for string values
     * Mirrors {@code NumberFieldMapper.objectToDouble} pathway used by objectToUnsignedLong.
                        "Unsigned long term value above Long.MAX_VALUE is not representable on the DSL path "
            }
        if (value == null) {
     * Mirrors {@code NumberFieldMapper.NumberType.UNSIGNED_LONG.termQuery}: fractional values
     * can never match a whole-number document value, so return {@code Optional.empty()} for them
import org.apache.calcite.sql.SqlOperator;
            if (!(num instanceof Long || num instanceof Integer || num instanceof Short || num instanceof Byte)) {
    }
        }
        if (value instanceof Number) {
                    + "': "
        String str = value.toString();
            // Check above Long.MAX first using BigDecimal
                longValue--;
/*
            // and produce a garbage truncation via (long) NaN = 0. Legacy throws IAE for non-finite.
            }
     */
                );
            if ((!hasDecimal && !inclusive) || (hasDecimal && sign > 0)) {
        if (bd.stripTrailingZeros().scale() > 0) {
        if (unsignedValue == null) {
        double sign = Math.signum(doubleValue);
            BigDecimal bd = new BigDecimal(str);
        }
    }
                    + value
    }
            }
                            + value
                    return ctx.getRexBuilder().makeLiteral(false);
                return (long) doubleValue;
        RexNode literal = ctx.getRexBuilder().makeLiteral(longVal, field.getType(), true);
    public Optional<RexNode> toTermLiteral(Object value, RelDataTypeField field, ConversionContext ctx) throws ConversionException {
            checkAboveLongMax(num, value, fieldName);
        Long unsignedValue = parseUnsignedLongTerm(value, field.getName());
import java.util.Optional;
        // Decimal part → match-none per legacy NumberFieldMapper.UNSIGNED_LONG.termsQuery
    /**
        BigDecimal bd = BigDecimal.valueOf(num.doubleValue());
    /** Singleton instance. */
            throw new ConversionException("Non-numeric range bound for unsigned_long field '" + fieldName + "': " + value);
                    "Unsigned long range bound above Long.MAX_VALUE is not representable on the DSL path "
        // WHY: Strings like "NaN", "Infinity" are accepted by Double.parseDouble but not BigDecimal;
            return ((Number) value).longValue();
        throws ConversionException {
                        + "': "
    }
        String str = value.toString();
        }
    private UnsignedLongTranslatorMapper() {}
                }
     *
    /**
 */
        BigDecimal bd;
        if (value instanceof Number num) {
        RexNode literal = ctx.getRexBuilder().makeLiteral(longValue, field.getType(), true);
                            + "': "
        }
                if (longValue == Long.MAX_VALUE) {
     */
package org.opensearch.dsl.query;
            }
        }
            return null;
                if (bd.compareTo(BigDecimal.valueOf(Long.MAX_VALUE)) > 0) {
            return Optional.empty();
