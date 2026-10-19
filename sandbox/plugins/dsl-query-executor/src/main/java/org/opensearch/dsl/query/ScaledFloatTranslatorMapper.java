import org.opensearch.dsl.converter.ConversionException;
                "Scaled value overflows Long range for field '" + fieldName + "': " + bound + " * " + sft.getScalingFactor()
     * Parses an object to a finite double, rejecting NaN and Infinity.  
     */
            throw new ConversionException("Scaled value overflows Long range for field '" + fieldName + "': " + value + " * " + factor);  
    private static double parseFiniteDouble(Object value, String fieldName) throws ConversionException {
        if (Double.isNaN(doubleValue) || Double.isInfinite(doubleValue)) {  
        double scaled = doubleValue * factor;
 */  
        }
    private static long scaleBound(Object bound, ScaledFloatType sft, String fieldName) throws ConversionException {  
        }
            } else {
package org.opensearch.dsl.query;
    /**
            } catch (NumberFormatException e) {
     * Reached from {@link TermQueryTranslator} and {@link TermsQueryTranslator} via toTermLiteral.
        RexNode fieldRef = ctx.getRexBuilder().makeInputRef(field.getType(), field.getIndex());
 * SPDX-License-Identifier: Apache-2.0
        return Optional.of(literal);
                    return ctx.getRexBuilder().makeLiteral(false);
     * @throws ConversionException if the value is non-numeric or non-finite
    static final ScaledFloatTranslatorMapper INSTANCE = new ScaledFloatTranslatorMapper();
        SqlOperator op = isLower ? SqlStdOperatorTable.GREATER_THAN_OR_EQUAL : SqlStdOperatorTable.LESS_THAN_OR_EQUAL;  
            try {  
                scaledBound++;
 * Translator mapper for {@code scaled_float} fields. Implements scaling via  
import org.apache.calcite.rel.type.RelDataTypeField;
        if (value instanceof Number) {  
        } else {
    @Override  
     */  
        double doubleValue;
import org.opensearch.analytics.schema.ScaledFloatType;
import org.apache.calcite.sql.SqlOperator;  
        ScaledFloatType sft = (ScaledFloatType) field.getType();
        // increment (lower) or decrement (upper) to make them inclusive.
                scaledBound--;  
     *
final class ScaledFloatTranslatorMapper extends BaseTranslatorMapper {
 * the schema. The scaling factor is read from {@link ScaledFloatType#getScalingFactor()} on
 * <p>This mapper is a stateless singleton shared across every {@code scaled_float} field in  
            doubleValue = ((Number) value).doubleValue();
        double doubleValue = parseFiniteDouble(value, fieldName);  
    }  
/**
    /**
        if (!inclusive) {
                doubleValue = Double.parseDouble(value.toString());
            throw new ConversionException(
}
 *
        ScaledFloatType sft = (ScaledFloatType) field.getType();  
    public Optional<RexNode> toTermLiteral(Object value, RelDataTypeField field, ConversionContext ctx) throws ConversionException {
    private ScaledFloatTranslatorMapper() {}  
    /**
        return doubleValue;  
        RexNode literal = ctx.getRexBuilder().makeLiteral(scaledBound, field.getType(), true);
        long scaledValue = scaleToLong(value, sft.getScalingFactor(), field.getName());  
import java.util.Optional;  
     * Scales via {@code Math.round(value * factor)} then applies integer inclusivity adjustment
        }
    }  
 * this file be licensed under the Apache-2.0 license or a
 * each call, never cached on this instance. Legacy {@code ScaledFloatFieldMapper.java:176}
        // Inclusivity adjustment per NumberFieldMapper.longRangeQuery: exclusive bounds  
     */
        RexNode literal = ctx.getRexBuilder().makeLiteral(scaledValue, field.getType(), true);
        }
 * The OpenSearch Contributors require contributions made to  
        return Math.round(scaled);
 * {@code Math.round(value * factor)} inline.
 */  
     * {@code NumberFieldMapper.longRangeQuery} semantics.  
        if (value == null) {
        return Math.round(scaled);
        }
            throw new ConversionException("Non-finite value for scaled_float field '" + fieldName + "': " + value);
                }
     */
import org.apache.calcite.sql.fun.SqlStdOperatorTable;
                if (scaledBound == Long.MIN_VALUE) {  
        throws ConversionException {
     *  
        double scaled = doubleValue * sft.getScalingFactor();
            }
import org.opensearch.dsl.converter.ConversionContext;  
     * Scales a bound value for a scaled_float field per  
        }
    @Override
 * holds {@code scalingFactor} as an instance field because there the object IS the field;  
    /**
import org.apache.calcite.rex.RexNode;
            }
            if (isLower) {  
     * Converts one value to a scaled long literal for term/terms queries.
        if (Double.isNaN(scaled) || Double.isInfinite(scaled) || scaled > Long.MAX_VALUE || scaled < Long.MIN_VALUE) {  
                    return ctx.getRexBuilder().makeLiteral(false);
    private static long scaleToLong(Object value, double factor, String fieldName) throws ConversionException {
                }  
     * Mirrors {@code ScaledFloatFieldMapper.ScaledFloatFieldType.termQuery}: scales via  
    protected RexNode translateBound(Object value, boolean isLower, boolean inclusive, RelDataTypeField field, ConversionContext ctx)  
 * our mapper serves every scaled_float field, so a cached factor would corrupt a second
        double doubleValue = parseFiniteDouble(bound, fieldName);
        long scaledBound = scaleBound(value, sft, field.getName());
     *
                throw new ConversionException("Non-numeric term value for scaled_float field '" + fieldName + "': " + value);  
     * Scales a term/terms value to a long for scaled_float equality queries.  
     * {@code Math.round(value * factor)} then builds an exact equality literal.
    }  
                if (scaledBound == Long.MAX_VALUE) {
            return null;  
     * {@code Math.round(doubleValue * scalingFactor)}.
        return ctx.getRexBuilder().makeCall(op, fieldRef, literal);
     * per legacy {@code ScaledFloatFieldMapper.ScaledFloatFieldType.rangeQuery} and
     * @throws ConversionException if the value is non-numeric, non-finite, or the scaled result overflows Long
 * compatible open source license.
     */
    }
    /**
/*  
    /** Singleton instance. */  
            );  
 * field with a different factor.
    }
        if (Double.isNaN(scaled) || Double.isInfinite(scaled) || scaled > Long.MAX_VALUE || scaled < Long.MIN_VALUE) {
     * {@code ScaledFloatFieldMapper.ScaledFloatFieldType.rangeQuery} semantics:
 *
     * @throws ConversionException if the value is non-numeric, non-finite, or overflows Long after scaling  
     * Translates a single range bound for a scaled_float field.  
