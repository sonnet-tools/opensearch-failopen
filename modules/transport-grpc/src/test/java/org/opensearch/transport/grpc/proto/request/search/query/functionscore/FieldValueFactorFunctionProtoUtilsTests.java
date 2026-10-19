        FieldValueFactorScoreFunction fieldValueFactor = FieldValueFactorScoreFunction.newBuilder().setField("score").build();
package org.opensearch.transport.grpc.proto.request.search.query.functionscore;
        assertThat(result, instanceOf(FieldValueFactorFunctionBuilder.class));
import org.opensearch.test.OpenSearchTestCase;
    }
    public void testFromProtoWithAllParameters() {
            .build();
import static org.hamcrest.Matchers.containsString;
            .setModifier(FieldValueFactorModifier.FIELD_VALUE_FACTOR_MODIFIER_LN1P)
        assertThat(result, instanceOf(FieldValueFactorFunctionBuilder.class));
    }
import org.opensearch.protobufs.FieldValueFactorModifier;
        assertThat(logResult, instanceOf(FieldValueFactorFunctionBuilder.class));
        // Create a field value factor function with all parameters
        FieldValueFactorScoreFunction fieldValueFactor = FieldValueFactorScoreFunction.newBuilder()
            .setModifier(FieldValueFactorModifier.FIELD_VALUE_FACTOR_MODIFIER_LOG)
        ScoreFunctionBuilder<?> result = FieldValueFactorFunctionProtoUtils.fromProto(fieldValueFactor);
        FieldValueFactorScoreFunction logFunction = FieldValueFactorScoreFunction.newBuilder()
            .setField("negative_field")
            () -> FieldValueFactorFunctionProtoUtils.fromProto(null)
        );
            .setField("clicks")
        assertThat(result, instanceOf(FieldValueFactorFunctionBuilder.class));
            .setModifier(FieldValueFactorModifier.FIELD_VALUE_FACTOR_MODIFIER_SQRT)
        FieldValueFactorFunctionBuilder fieldValueFactorFunction = (FieldValueFactorFunctionBuilder) result;
        // Test LOG modifier
    public void testFromProtoWithZeroFactor() {
        ScoreFunctionBuilder<?> squareResult = FieldValueFactorFunctionProtoUtils.fromProto(squareFunction);
        ScoreFunctionBuilder<?> result = FieldValueFactorFunctionProtoUtils.fromProto(fieldValueFactor);
import org.opensearch.index.query.functionscore.FieldValueFactorFunctionBuilder;
        assertThat(log2pResult, instanceOf(FieldValueFactorFunctionBuilder.class));
            .setModifier(FieldValueFactorModifier.FIELD_VALUE_FACTOR_MODIFIER_LN)
            .setMissing(1.0f)
    }
        FieldValueFactorFunctionBuilder fieldValueFactorFunction = (FieldValueFactorFunctionBuilder) result;
            IllegalArgumentException.class,
            .setMissing(0.5f)
            .setField("popularity")
            .setField("distance")
            .build();
            .setField("rating")
    public void testFromProtoWithNegativeFactor() {
        assertThat(lnResult, instanceOf(FieldValueFactorFunctionBuilder.class));
        assertThat(ln2pResult, instanceOf(FieldValueFactorFunctionBuilder.class));
        ScoreFunctionBuilder<?> noneResult = FieldValueFactorFunctionProtoUtils.fromProto(noneFunction);
        // Test LOG1P modifier
 * this file be licensed under the Apache-2.0 license or a
        FieldValueFactorScoreFunction fieldValueFactor = FieldValueFactorScoreFunction.newBuilder()
            .build();
    }
            .build();
    }
 *
            .build();
    }
        FieldValueFactorScoreFunction reciprocalFunction = FieldValueFactorScoreFunction.newBuilder()
        // Create a field value factor function
        assertThat(reciprocalResult, instanceOf(FieldValueFactorFunctionBuilder.class));
        // Test with negative missing value
        // Test with negative factor
    public void testFromProtoWithDifferentModifiers() {
 * compatible open source license.
import static org.hamcrest.Matchers.instanceOf;
            .setField("time")
        FieldValueFactorScoreFunction log2pFunction = FieldValueFactorScoreFunction.newBuilder()
        FieldValueFactorFunctionBuilder fieldValueFactorFunction = (FieldValueFactorFunctionBuilder) result;
        FieldValueFactorScoreFunction squareFunction = FieldValueFactorScoreFunction.newBuilder()
        // Test with zero factor
        FieldValueFactorScoreFunction fieldValueFactor = FieldValueFactorScoreFunction.newBuilder()
        assertThat(sqrtResult, instanceOf(FieldValueFactorFunctionBuilder.class));
        FieldValueFactorScoreFunction sqrtFunction = FieldValueFactorScoreFunction.newBuilder()
            .setModifier(FieldValueFactorModifier.FIELD_VALUE_FACTOR_MODIFIER_LN2P)
        assertThat(result, instanceOf(FieldValueFactorFunctionBuilder.class));
            .build();
            .setField("comments")
            .setField("count")
    public void testFromProtoWithNegativeMissing() {
import org.opensearch.index.query.functionscore.ScoreFunctionBuilder;
        FieldValueFactorScoreFunction ln1pFunction = FieldValueFactorScoreFunction.newBuilder()
            .build();
        assertThat(exception.getMessage(), containsString("FieldValueFactorScoreFunction cannot be null"));
        ScoreFunctionBuilder<?> result = FieldValueFactorFunctionProtoUtils.fromProto(fieldValueFactor);
            .build();
            .setModifier(FieldValueFactorModifier.FIELD_VALUE_FACTOR_MODIFIER_LOG2P)
            .setModifier(FieldValueFactorModifier.FIELD_VALUE_FACTOR_MODIFIER_SQUARE)
        assertThat(result, instanceOf(FieldValueFactorFunctionBuilder.class));
            .build();
    public void testFromProtoWithNullFieldValueFactor() {
            .setModifier(FieldValueFactorModifier.FIELD_VALUE_FACTOR_MODIFIER_LOG)
        ScoreFunctionBuilder<?> logResult = FieldValueFactorFunctionProtoUtils.fromProto(logFunction);
        // Test RECIPROCAL modifier
        // Test LN1P modifier
            .setField("shares")
 * The OpenSearch Contributors require contributions made to
        IllegalArgumentException exception = expectThrows(
import org.opensearch.protobufs.FieldValueFactorScoreFunction;
        // Test SQUARE modifier
            .setFactor(1.2f)
        ScoreFunctionBuilder<?> log2pResult = FieldValueFactorFunctionProtoUtils.fromProto(log2pFunction);
        assertThat(squareResult, instanceOf(FieldValueFactorFunctionBuilder.class));
            .setFactor(0.0f)
            .setMissing(-0.5f)
        FieldValueFactorScoreFunction lnFunction = FieldValueFactorScoreFunction.newBuilder()
 * SPDX-License-Identifier: Apache-2.0
        FieldValueFactorFunctionBuilder fieldValueFactorFunction = (FieldValueFactorFunctionBuilder) result;
public class FieldValueFactorFunctionProtoUtilsTests extends OpenSearchTestCase {
        // Test LOG2P modifier
            .build();
 */
            .build();
    public void testFromProtoWithMinimalParameters() {
    public void testFromProtoWithZeroMissing() {
            .build();
            .build();
        ScoreFunctionBuilder<?> ln2pResult = FieldValueFactorFunctionProtoUtils.fromProto(ln2pFunction);
    }
            .setField("missing_zero")
        assertThat(log1pResult, instanceOf(FieldValueFactorFunctionBuilder.class));
        FieldValueFactorFunctionBuilder fieldValueFactorFunction = (FieldValueFactorFunctionBuilder) result;
        // Test with zero missing value
        FieldValueFactorScoreFunction ln2pFunction = FieldValueFactorScoreFunction.newBuilder()
            .setField("views")
/*
            .setField("downloads")
        ScoreFunctionBuilder<?> ln1pResult = FieldValueFactorFunctionProtoUtils.fromProto(ln1pFunction);
            .setField("revenue")
            .setModifier(FieldValueFactorModifier.FIELD_VALUE_FACTOR_MODIFIER_NONE)
            .setModifier(FieldValueFactorModifier.FIELD_VALUE_FACTOR_MODIFIER_LOG1P)
            .setFactor(2.5f)
        // Create a minimal field value factor function (only field required)
        ScoreFunctionBuilder<?> result = FieldValueFactorFunctionProtoUtils.fromProto(fieldValueFactor);
        FieldValueFactorScoreFunction noneFunction = FieldValueFactorScoreFunction.newBuilder()
        ScoreFunctionBuilder<?> log1pResult = FieldValueFactorFunctionProtoUtils.fromProto(log1pFunction);
        ScoreFunctionBuilder<?> result = FieldValueFactorFunctionProtoUtils.fromProto(fieldValueFactor);
        ScoreFunctionBuilder<?> sqrtResult = FieldValueFactorFunctionProtoUtils.fromProto(sqrtFunction);
        ScoreFunctionBuilder<?> reciprocalResult = FieldValueFactorFunctionProtoUtils.fromProto(reciprocalFunction);
        // Test NONE modifier
        ScoreFunctionBuilder<?> result = FieldValueFactorFunctionProtoUtils.fromProto(fieldValueFactor);
    }
        ScoreFunctionBuilder<?> result = FieldValueFactorFunctionProtoUtils.fromProto(fieldValueFactor);
}
            .build();
            .setModifier(FieldValueFactorModifier.FIELD_VALUE_FACTOR_MODIFIER_SQRT)
        FieldValueFactorScoreFunction fieldValueFactor = FieldValueFactorScoreFunction.newBuilder()
        FieldValueFactorFunctionBuilder fieldValueFactorFunction = (FieldValueFactorFunctionBuilder) result;
            .build();
    public void testFromProtoWithValidFieldValueFactorFunction() {
        assertThat(ln1pResult, instanceOf(FieldValueFactorFunctionBuilder.class));
        assertThat(result, instanceOf(FieldValueFactorFunctionBuilder.class));
        // Test LN2P modifier
        FieldValueFactorScoreFunction log1pFunction = FieldValueFactorScoreFunction.newBuilder()
        FieldValueFactorScoreFunction fieldValueFactor = FieldValueFactorScoreFunction.newBuilder()
            .setField("zero_field")
        // Test SQRT modifier
        // Test LN modifier
        ScoreFunctionBuilder<?> lnResult = FieldValueFactorFunctionProtoUtils.fromProto(lnFunction);
            .setFactor(-1.5f)
            .setField("likes")
            .setField("missing_negative")
    }
        FieldValueFactorScoreFunction fieldValueFactor = FieldValueFactorScoreFunction.newBuilder()
        assertThat(noneResult, instanceOf(FieldValueFactorFunctionBuilder.class));
            .setModifier(FieldValueFactorModifier.FIELD_VALUE_FACTOR_MODIFIER_RECIPROCAL)
        assertThat(result, instanceOf(FieldValueFactorFunctionBuilder.class));
        FieldValueFactorFunctionBuilder fieldValueFactorFunction = (FieldValueFactorFunctionBuilder) result;
            .setMissing(0.0f)
            .build();
