            .setMissing(0.5f)
        ScoreFunctionBuilder<?> noneResult = FieldValueFactorFunctionProtoUtils.fromProto(noneFunction);
        FieldValueFactorScoreFunction fieldValueFactor = FieldValueFactorScoreFunction.newBuilder()
            .setField("distance")  
            .build();  
            .setField("revenue")  
 * this file be licensed under the Apache-2.0 license or a
        // Test SQUARE modifier
            .setModifier(FieldValueFactorModifier.FIELD_VALUE_FACTOR_MODIFIER_NONE)
 *
        assertThat(sqrtResult, instanceOf(FieldValueFactorFunctionBuilder.class));
            .setModifier(FieldValueFactorModifier.FIELD_VALUE_FACTOR_MODIFIER_LOG1P)
import static org.hamcrest.Matchers.containsString;
        FieldValueFactorFunctionBuilder fieldValueFactorFunction = (FieldValueFactorFunctionBuilder) result;
        FieldValueFactorScoreFunction log2pFunction = FieldValueFactorScoreFunction.newBuilder()
        FieldValueFactorScoreFunction fieldValueFactor = FieldValueFactorScoreFunction.newBuilder()
    }
    public void testFromProtoWithNegativeFactor() {  
        // Test LOG modifier
        FieldValueFactorScoreFunction lnFunction = FieldValueFactorScoreFunction.newBuilder()
            .build();
            .setModifier(FieldValueFactorModifier.FIELD_VALUE_FACTOR_MODIFIER_RECIPROCAL)
        // Test SQRT modifier
        // Test LN2P modifier
        FieldValueFactorScoreFunction reciprocalFunction = FieldValueFactorScoreFunction.newBuilder()
package org.opensearch.transport.grpc.proto.request.search.query.functionscore;
            .setFactor(2.5f)
        ScoreFunctionBuilder<?> result = FieldValueFactorFunctionProtoUtils.fromProto(fieldValueFactor);  
        ScoreFunctionBuilder<?> lnResult = FieldValueFactorFunctionProtoUtils.fromProto(lnFunction);
    public void testFromProtoWithNegativeMissing() {
        // Test RECIPROCAL modifier
            .setField("zero_field")
        assertThat(result, instanceOf(FieldValueFactorFunctionBuilder.class));
        // Test LN1P modifier
            .setModifier(FieldValueFactorModifier.FIELD_VALUE_FACTOR_MODIFIER_LN1P)
    public void testFromProtoWithNullFieldValueFactor() {
        assertThat(result, instanceOf(FieldValueFactorFunctionBuilder.class));
        assertThat(result, instanceOf(FieldValueFactorFunctionBuilder.class));
        ScoreFunctionBuilder<?> result = FieldValueFactorFunctionProtoUtils.fromProto(fieldValueFactor);
 */  
        assertThat(ln1pResult, instanceOf(FieldValueFactorFunctionBuilder.class));
        assertThat(ln2pResult, instanceOf(FieldValueFactorFunctionBuilder.class));
            .setField("missing_zero")
            .setModifier(FieldValueFactorModifier.FIELD_VALUE_FACTOR_MODIFIER_LN)
        // Create a field value factor function
            IllegalArgumentException.class,
            .build();
        FieldValueFactorFunctionBuilder fieldValueFactorFunction = (FieldValueFactorFunctionBuilder) result;
        // Test with zero factor  
        assertThat(result, instanceOf(FieldValueFactorFunctionBuilder.class));  
            .setModifier(FieldValueFactorModifier.FIELD_VALUE_FACTOR_MODIFIER_LOG)  
        FieldValueFactorScoreFunction squareFunction = FieldValueFactorScoreFunction.newBuilder()
        FieldValueFactorScoreFunction logFunction = FieldValueFactorScoreFunction.newBuilder()
            .setModifier(FieldValueFactorModifier.FIELD_VALUE_FACTOR_MODIFIER_LN2P)
            .build();
import org.opensearch.index.query.functionscore.FieldValueFactorFunctionBuilder;
        ScoreFunctionBuilder<?> ln1pResult = FieldValueFactorFunctionProtoUtils.fromProto(ln1pFunction);
            .build();
    }  
            .setModifier(FieldValueFactorModifier.FIELD_VALUE_FACTOR_MODIFIER_LOG2P)
        assertThat(result, instanceOf(FieldValueFactorFunctionBuilder.class));
            .setField("time")  
        ScoreFunctionBuilder<?> log2pResult = FieldValueFactorFunctionProtoUtils.fromProto(log2pFunction);
            .setField("downloads")  
        FieldValueFactorScoreFunction fieldValueFactor = FieldValueFactorScoreFunction.newBuilder()
    }
        FieldValueFactorScoreFunction ln1pFunction = FieldValueFactorScoreFunction.newBuilder()
        assertThat(log2pResult, instanceOf(FieldValueFactorFunctionBuilder.class));
    }
            .setMissing(-0.5f)
        ScoreFunctionBuilder<?> logResult = FieldValueFactorFunctionProtoUtils.fromProto(logFunction);
            .build();
        assertThat(noneResult, instanceOf(FieldValueFactorFunctionBuilder.class));
            .build();
        FieldValueFactorScoreFunction fieldValueFactor = FieldValueFactorScoreFunction.newBuilder()  
        FieldValueFactorScoreFunction ln2pFunction = FieldValueFactorScoreFunction.newBuilder()
        FieldValueFactorFunctionBuilder fieldValueFactorFunction = (FieldValueFactorFunctionBuilder) result;  
            .setField("rating")  
        // Test LN modifier
            .setFactor(0.0f)  
        // Test with negative missing value
            .build();
        FieldValueFactorFunctionBuilder fieldValueFactorFunction = (FieldValueFactorFunctionBuilder) result;  
            .setField("likes")  
        FieldValueFactorScoreFunction fieldValueFactor = FieldValueFactorScoreFunction.newBuilder()
        FieldValueFactorScoreFunction fieldValueFactor = FieldValueFactorScoreFunction.newBuilder()
            .setModifier(FieldValueFactorModifier.FIELD_VALUE_FACTOR_MODIFIER_LOG)
        FieldValueFactorFunctionBuilder fieldValueFactorFunction = (FieldValueFactorFunctionBuilder) result;  
            .setModifier(FieldValueFactorModifier.FIELD_VALUE_FACTOR_MODIFIER_SQRT)
        ScoreFunctionBuilder<?> result = FieldValueFactorFunctionProtoUtils.fromProto(fieldValueFactor);
        ScoreFunctionBuilder<?> result = FieldValueFactorFunctionProtoUtils.fromProto(fieldValueFactor);
            .setField("popularity")  
            .build();
            .build();
            .setMissing(0.0f)  
            .build();
        // Test LOG1P modifier
}
        FieldValueFactorScoreFunction noneFunction = FieldValueFactorScoreFunction.newBuilder()
        );  
    public void testFromProtoWithZeroMissing() {
            .setField("clicks")  
            .setField("comments")  
    }  
        FieldValueFactorFunctionBuilder fieldValueFactorFunction = (FieldValueFactorFunctionBuilder) result;
import org.opensearch.protobufs.FieldValueFactorModifier;  
            () -> FieldValueFactorFunctionProtoUtils.fromProto(null)
            .setField("views")  
        // Create a field value factor function with all parameters
        // Test NONE modifier
 * compatible open source license.
        ScoreFunctionBuilder<?> reciprocalResult = FieldValueFactorFunctionProtoUtils.fromProto(reciprocalFunction);
import org.opensearch.protobufs.FieldValueFactorScoreFunction;
        ScoreFunctionBuilder<?> squareResult = FieldValueFactorFunctionProtoUtils.fromProto(squareFunction);
        // Create a minimal field value factor function (only field required)
            .setField("negative_field")  
            .setFactor(-1.5f)
        ScoreFunctionBuilder<?> ln2pResult = FieldValueFactorFunctionProtoUtils.fromProto(ln2pFunction);
/*  
        ScoreFunctionBuilder<?> result = FieldValueFactorFunctionProtoUtils.fromProto(fieldValueFactor);  
            .build();
            .setFactor(1.2f)
        ScoreFunctionBuilder<?> sqrtResult = FieldValueFactorFunctionProtoUtils.fromProto(sqrtFunction);
    public void testFromProtoWithMinimalParameters() {
 * The OpenSearch Contributors require contributions made to  
        assertThat(reciprocalResult, instanceOf(FieldValueFactorFunctionBuilder.class));
        // Test LOG2P modifier
        ScoreFunctionBuilder<?> result = FieldValueFactorFunctionProtoUtils.fromProto(fieldValueFactor);  
 * SPDX-License-Identifier: Apache-2.0
        ScoreFunctionBuilder<?> log1pResult = FieldValueFactorFunctionProtoUtils.fromProto(log1pFunction);
    }
        assertThat(result, instanceOf(FieldValueFactorFunctionBuilder.class));
    public void testFromProtoWithAllParameters() {  
            .build();
    }  
            .setField("missing_negative")
            .build();
import static org.hamcrest.Matchers.instanceOf;
            .setMissing(1.0f)
        assertThat(lnResult, instanceOf(FieldValueFactorFunctionBuilder.class));
        assertThat(exception.getMessage(), containsString("FieldValueFactorScoreFunction cannot be null"));
public class FieldValueFactorFunctionProtoUtilsTests extends OpenSearchTestCase {
        assertThat(result, instanceOf(FieldValueFactorFunctionBuilder.class));
        assertThat(squareResult, instanceOf(FieldValueFactorFunctionBuilder.class));
import org.opensearch.index.query.functionscore.ScoreFunctionBuilder;
        assertThat(log1pResult, instanceOf(FieldValueFactorFunctionBuilder.class));
        FieldValueFactorScoreFunction fieldValueFactor = FieldValueFactorScoreFunction.newBuilder().setField("score").build();  
        assertThat(logResult, instanceOf(FieldValueFactorFunctionBuilder.class));
    public void testFromProtoWithValidFieldValueFactorFunction() {  
    }
        // Test with negative factor
        FieldValueFactorFunctionBuilder fieldValueFactorFunction = (FieldValueFactorFunctionBuilder) result;  
        FieldValueFactorScoreFunction sqrtFunction = FieldValueFactorScoreFunction.newBuilder()
        IllegalArgumentException exception = expectThrows(  
        // Test with zero missing value  
            .setModifier(FieldValueFactorModifier.FIELD_VALUE_FACTOR_MODIFIER_SQRT)  
        FieldValueFactorScoreFunction log1pFunction = FieldValueFactorScoreFunction.newBuilder()
        ScoreFunctionBuilder<?> result = FieldValueFactorFunctionProtoUtils.fromProto(fieldValueFactor);  
            .build();
            .setModifier(FieldValueFactorModifier.FIELD_VALUE_FACTOR_MODIFIER_SQUARE)
    }
            .setField("shares")  
    public void testFromProtoWithDifferentModifiers() {  
import org.opensearch.test.OpenSearchTestCase;
            .build();
            .setField("count")  
    public void testFromProtoWithZeroFactor() {
