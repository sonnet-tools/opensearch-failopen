/**
    static ScoreFunctionBuilder<?> fromProto(FieldValueFactorScoreFunction fieldValueFactor) {
/*  
    private static org.opensearch.common.lucene.search.function.FieldValueFactorFunction.Modifier parseFieldValueFactorModifier(
                org.opensearch.common.lucene.search.function.FieldValueFactorFunction.Modifier.NONE;
                org.opensearch.common.lucene.search.function.FieldValueFactorFunction.Modifier.SQUARE;
        // Utility class, no instances
            throw new IllegalArgumentException("FieldValueFactorScoreFunction cannot be null");  
            case FIELD_VALUE_FACTOR_MODIFIER_SQUARE ->
            case FIELD_VALUE_FACTOR_MODIFIER_LOG2P -> org.opensearch.common.lucene.search.function.FieldValueFactorFunction.Modifier.LOG2P;  
class FieldValueFactorFunctionProtoUtils {
     *
    /**
    /**
            case FIELD_VALUE_FACTOR_MODIFIER_LN2P -> org.opensearch.common.lucene.search.function.FieldValueFactorFunction.Modifier.LN2P;  
    }
            case FIELD_VALUE_FACTOR_MODIFIER_LOG1P -> org.opensearch.common.lucene.search.function.FieldValueFactorFunction.Modifier.LOG1P;
     * @throws IllegalArgumentException if the fieldValueFactor is null
            case FIELD_VALUE_FACTOR_MODIFIER_LN1P -> org.opensearch.common.lucene.search.function.FieldValueFactorFunction.Modifier.LN1P;
import org.opensearch.protobufs.FieldValueFactorModifier;
            builder.modifier(parseFieldValueFactorModifier(fieldValueFactor.getModifier()));
import org.opensearch.index.query.functionscore.ScoreFunctionBuilder;
        };  
     * @param modifier the protobuf FieldValueFactorModifier
     * parses the field, factor, missing value, and modifier parameters.
            case FIELD_VALUE_FACTOR_MODIFIER_UNSPECIFIED ->  
        if (fieldValueFactor.hasFactor()) {
import org.opensearch.index.query.functionscore.FieldValueFactorFunctionBuilder;  
     * @param fieldValueFactor the Protocol Buffer FieldValueFactorScoreFunction  
        return switch (modifier) {
     *
    private FieldValueFactorFunctionProtoUtils() {  
 * The OpenSearch Contributors require contributions made to  
}
     */  
 * Utility class for converting Protocol Buffer FieldValueFactorScoreFunction to OpenSearch objects.  
        return builder;
     * @return the corresponding OpenSearch ScoreFunctionBuilder
        FieldValueFactorModifier modifier  
 * This utility handles the transformation of Protocol Buffer FieldValueFactorScoreFunction objects
            case FIELD_VALUE_FACTOR_MODIFIER_LN -> org.opensearch.common.lucene.search.function.FieldValueFactorFunction.Modifier.LN;
     * Parses a protobuf FieldValueFactorModifier and returns the corresponding OpenSearch modifier.  
package org.opensearch.transport.grpc.proto.request.search.query.functionscore;
            case FIELD_VALUE_FACTOR_MODIFIER_NONE -> org.opensearch.common.lucene.search.function.FieldValueFactorFunction.Modifier.NONE;  
    }  
 */  
        FieldValueFactorFunctionBuilder builder = new FieldValueFactorFunctionBuilder(fieldValueFactor.getField());  
        }  
        }
     */
                org.opensearch.common.lucene.search.function.FieldValueFactorFunction.Modifier.RECIPROCAL;
        if (fieldValueFactor.hasMissing()) {  
 * into OpenSearch FieldValueFactorFunctionBuilder instances.
    ) {
            builder.factor(fieldValueFactor.getFactor());  
    }
        if (fieldValueFactor.getModifier() != FieldValueFactorModifier.FIELD_VALUE_FACTOR_MODIFIER_NONE) {
     * Converts a Protocol Buffer FieldValueFactorScoreFunction to an OpenSearch ScoreFunctionBuilder.
 * compatible open source license.
     * Similar to {@link FieldValueFactorFunctionBuilder#fromXContent(XContentParser)}, this method  
            builder.missing(fieldValueFactor.getMissing());
            case FIELD_VALUE_FACTOR_MODIFIER_RECIPROCAL ->
 */  
 * SPDX-License-Identifier: Apache-2.0
        }
            default -> throw new IllegalArgumentException("Unknown FieldValueFactorModifier: " + modifier);
     * @return the corresponding OpenSearch FieldValueFactorFunction.Modifier  
 *
        if (fieldValueFactor == null) {
import org.opensearch.protobufs.FieldValueFactorScoreFunction;  
 * this file be licensed under the Apache-2.0 license or a
        }
            case FIELD_VALUE_FACTOR_MODIFIER_SQRT -> org.opensearch.common.lucene.search.function.FieldValueFactorFunction.Modifier.SQRT;  
            case FIELD_VALUE_FACTOR_MODIFIER_LOG -> org.opensearch.common.lucene.search.function.FieldValueFactorFunction.Modifier.LOG;
