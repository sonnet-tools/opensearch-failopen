 * compatible open source license.
        ScoreFunctionBuilder<?> result = ExpDecayFunctionProtoUtils.fromProto(decayFunction);
            .build();  
        assertEquals("price", expFunction.getFieldName());
            .putPlacement("rating", decayPlacement)
        assertEquals("geo_field", expFunction.getFieldName());
            .setOrigin(geoLocation)
            .build();  
public class ExpDecayFunctionProtoUtilsTests extends OpenSearchTestCase {
    public void testFromProtoWithMultiValueModeUnspecified() {
            .setScale(5.0)
    }
    }
 * this file be licensed under the Apache-2.0 license or a
            .putPlacement("price", decayPlacement)
            .setMultiValueMode(org.opensearch.protobufs.MultiValueMode.MULTI_VALUE_MODE_MAX)  
        org.opensearch.protobufs.LatLonGeoLocation latLonLocation = org.opensearch.protobufs.LatLonGeoLocation.newBuilder()
        NumericDecayPlacement numericPlacement = NumericDecayPlacement.newBuilder().setOrigin(50.0).setScale(25.0).build();  
        DecayFunction decayFunction = DecayFunction.newBuilder()
            () -> ExpDecayFunctionProtoUtils.fromProto(decayFunction)
    }
        org.opensearch.protobufs.GeoDecayPlacement geoPlacement = org.opensearch.protobufs.GeoDecayPlacement.newBuilder()  
        ScoreFunctionBuilder<?> result = ExpDecayFunctionProtoUtils.fromProto(decayFunction);  
import org.opensearch.test.OpenSearchTestCase;  
            .setOrigin(10.0)  
    }  
        ExponentialDecayFunctionBuilder expFunction = (ExponentialDecayFunctionBuilder) result;
            .putPlacement("price", decayPlacement)
            .setMultiValueMode(org.opensearch.protobufs.MultiValueMode.MULTI_VALUE_MODE_AVG)
    }  
import org.opensearch.index.query.functionscore.ExponentialDecayFunctionBuilder;
        DecayFunction decayFunction = DecayFunction.newBuilder().putPlacement("date_field", decayPlacement).build();
 */  
        DecayPlacement decayPlacement = DecayPlacement.newBuilder().setNumericDecayPlacement(numericPlacement).build();
            .setOrigin("now")
        ExponentialDecayFunctionBuilder expFunction = (ExponentialDecayFunctionBuilder) result;
        org.opensearch.protobufs.GeoLocation geoLocation = org.opensearch.protobufs.GeoLocation.newBuilder()
    }  
        assertEquals("price", expFunction.getFieldName());  
    }
            .build();  
            .setLat(40.7128)
        ScoreFunctionBuilder<?> result = ExpDecayFunctionProtoUtils.fromProto(decayFunction);
    }  
        ScoreFunctionBuilder<?> result = ExpDecayFunctionProtoUtils.fromProto(decayFunction);
        org.opensearch.protobufs.LatLonGeoLocation latLonLocation = org.opensearch.protobufs.LatLonGeoLocation.newBuilder()  
            .setLatlon(latLonLocation)  
        assertThat(exception.getMessage(), containsString("DecayFunction must have at least one placement"));
            IllegalArgumentException.class,  
        ScoreFunctionBuilder<?> result = ExpDecayFunctionProtoUtils.fromProto(decayFunction);
        assertThat(result, instanceOf(ExponentialDecayFunctionBuilder.class));
        NumericDecayPlacement numericPlacement = NumericDecayPlacement.newBuilder().setOrigin(10.0).setScale(5.0).build();
        ExponentialDecayFunctionBuilder expFunction = (ExponentialDecayFunctionBuilder) result;
        assertThat(result, instanceOf(ExponentialDecayFunctionBuilder.class));  
        DecayPlacement decayPlacement = DecayPlacement.newBuilder().setNumericDecayPlacement(numericPlacement).build();  
        assertThat(result, instanceOf(ExponentialDecayFunctionBuilder.class));  
        IllegalArgumentException exception = expectThrows(
import static org.hamcrest.Matchers.containsString;
        assertThat(result, instanceOf(ExponentialDecayFunctionBuilder.class));  
        assertEquals(org.opensearch.search.MultiValueMode.MAX, expFunction.getMultiValueMode());  
        DecayFunction decayFunction = DecayFunction.newBuilder().putPlacement("price", decayPlacement).build();
        org.opensearch.protobufs.DateDecayPlacement datePlacement = org.opensearch.protobufs.DateDecayPlacement.newBuilder()  
            .build();
        // When UNSPECIFIED, multi_value_mode should remain at default (MIN)
    public void testFromProtoWithNumericPlacement() {
        org.opensearch.protobufs.GeoDecayPlacement geoPlacement = org.opensearch.protobufs.GeoDecayPlacement.newBuilder()
        DecayFunction decayFunction = DecayFunction.newBuilder()
        ExponentialDecayFunctionBuilder expFunction = (ExponentialDecayFunctionBuilder) result;
    public void testFromProtoWithNullDecayFunction() {
    }
            .build();
            .build();
            .setOffset("5d")
        DecayPlacement decayPlacement = DecayPlacement.newBuilder().build();
}
        IllegalArgumentException exception = expectThrows(  
            .putPlacement("score", decayPlacement)  
        ScoreFunctionBuilder<?> result = ExpDecayFunctionProtoUtils.fromProto(decayFunction);
        IllegalArgumentException exception = expectThrows(IllegalArgumentException.class, () -> ExpDecayFunctionProtoUtils.fromProto(null));  
        DecayPlacement decayPlacement = DecayPlacement.newBuilder().setNumericDecayPlacement(numericPlacement).build();  
    }
            .setLon(-74.0060)
            .setScale("5km")
        DecayFunction decayFunction = DecayFunction.newBuilder()  
    public void testFromProtoWithEmptyDecayFunction() {
        ExponentialDecayFunctionBuilder expFunction = (ExponentialDecayFunctionBuilder) result;  
            .setDecay(0.35)
        assertThat(result, instanceOf(ExponentialDecayFunctionBuilder.class));
import org.opensearch.protobufs.DecayPlacement;
    public void testFromProtoWithGeoPlacement() {
        assertEquals(org.opensearch.search.MultiValueMode.MIN, expFunction.getMultiValueMode());  
    public void testFromProtoWithNumericPlacementWithoutDecay() {  
        ExponentialDecayFunctionBuilder expFunction = (ExponentialDecayFunctionBuilder) result;
import org.opensearch.protobufs.NumericDecayPlacement;
    }
    public void testFromProtoWithMultiValueModeMin() {
        ScoreFunctionBuilder<?> result = ExpDecayFunctionProtoUtils.fromProto(decayFunction);
        assertEquals(org.opensearch.search.MultiValueMode.MIN, expFunction.getMultiValueMode());
            .setOrigin("2024-01-01")
        );
        assertThat(result, instanceOf(ExponentialDecayFunctionBuilder.class));
            .setScale("7d")
            .setScale("30d")  
    }
            .build();
    public void testFromProtoWithMultiValueModeAvg() {  
        ExponentialDecayFunctionBuilder expFunction = (ExponentialDecayFunctionBuilder) result;
            .setOrigin(geoLocation)  
        DecayPlacement decayPlacement = DecayPlacement.newBuilder().setDateDecayPlacement(datePlacement).build();
        assertThat(exception.getMessage(), containsString("Unsupported decay placement type"));
        DecayFunction decayFunction = DecayFunction.newBuilder()  
        ScoreFunctionBuilder<?> result = ExpDecayFunctionProtoUtils.fromProto(decayFunction);
        );  
            .setScale("10km")
        assertThat(exception.getMessage(), containsString("DecayFunction must have at least one placement"));
        DecayFunction decayFunction = DecayFunction.newBuilder().putPlacement("field", decayPlacement).build();
    public void testFromProtoWithDatePlacement() {  
        DecayPlacement decayPlacement = DecayPlacement.newBuilder().setGeoDecayPlacement(geoPlacement).build();
        assertEquals("timestamp", expFunction.getFieldName());
        assertEquals("score", expFunction.getFieldName());  
import org.opensearch.protobufs.DecayFunction;  
        DecayFunction decayFunction = DecayFunction.newBuilder().putPlacement("location", decayPlacement).build();  
        assertEquals("price", expFunction.getFieldName());
        assertEquals("rating", expFunction.getFieldName());
        assertEquals("date_field", expFunction.getFieldName());
import org.opensearch.index.query.functionscore.ScoreFunctionBuilder;
            .build();
        DecayPlacement decayPlacement = DecayPlacement.newBuilder().setNumericDecayPlacement(numericPlacement).build();  
            .setLatlon(latLonLocation)
            .build();
    }  
        NumericDecayPlacement numericPlacement = NumericDecayPlacement.newBuilder().setOrigin(10.0).setScale(5.0).build();
        NumericDecayPlacement numericPlacement = NumericDecayPlacement.newBuilder()
        ExponentialDecayFunctionBuilder expFunction = (ExponentialDecayFunctionBuilder) result;
        DecayPlacement decayPlacement = DecayPlacement.newBuilder().setGeoDecayPlacement(geoPlacement).build();
        NumericDecayPlacement numericPlacement = NumericDecayPlacement.newBuilder().setOrigin(100.0).setScale(50.0).setOffset(5.0).build();
        assertEquals("location", expFunction.getFieldName());
            .build();  
    public void testFromProtoWithUnsetDecayPlacement() {
        DecayPlacement decayPlacement = DecayPlacement.newBuilder().setDateDecayPlacement(datePlacement).build();
            .setOffset(1.0)
            .setDecay(0.3)  
/*  
        org.opensearch.protobufs.DateDecayPlacement datePlacement = org.opensearch.protobufs.DateDecayPlacement.newBuilder()
        assertThat(result, instanceOf(ExponentialDecayFunctionBuilder.class));
        DecayFunction decayFunction = DecayFunction.newBuilder().putPlacement("geo_field", decayPlacement).build();  
            .setDecay(0.5)
    public void testFromProtoWithGeoPlacementWithoutDecay() {
        DecayFunction decayFunction = DecayFunction.newBuilder().putPlacement("timestamp", decayPlacement).build();
        ExponentialDecayFunctionBuilder expFunction = (ExponentialDecayFunctionBuilder) result;  
        ScoreFunctionBuilder<?> result = ExpDecayFunctionProtoUtils.fromProto(decayFunction);  
        assertEquals(org.opensearch.search.MultiValueMode.AVG, expFunction.getMultiValueMode());
        DecayFunction decayFunction = DecayFunction.newBuilder().putPlacement("distance", decayPlacement).build();
            .build();  
 *
        DecayPlacement decayPlacement = DecayPlacement.newBuilder().setNumericDecayPlacement(numericPlacement).build();
        ScoreFunctionBuilder<?> result = ExpDecayFunctionProtoUtils.fromProto(decayFunction);  
            .setOffset("1km")  
 * The OpenSearch Contributors require contributions made to  
            .setLon(-0.1278)
            .setLat(51.5074)  
        assertThat(result, instanceOf(ExponentialDecayFunctionBuilder.class));
            IllegalArgumentException.class,
    public void testFromProtoWithDatePlacementWithoutDecay() {
        DecayPlacement decayPlacement = DecayPlacement.newBuilder().setNumericDecayPlacement(numericPlacement).build();
        org.opensearch.protobufs.GeoLocation geoLocation = org.opensearch.protobufs.GeoLocation.newBuilder()
            .setMultiValueMode(org.opensearch.protobufs.MultiValueMode.MULTI_VALUE_MODE_UNSPECIFIED)
        assertEquals("distance", expFunction.getFieldName());  
        ExponentialDecayFunctionBuilder expFunction = (ExponentialDecayFunctionBuilder) result;  
 * SPDX-License-Identifier: Apache-2.0
        assertThat(result, instanceOf(ExponentialDecayFunctionBuilder.class));
        NumericDecayPlacement numericPlacement = NumericDecayPlacement.newBuilder().setOrigin(100.0).setScale(10.0).build();
            .build();
            .setMultiValueMode(org.opensearch.protobufs.MultiValueMode.MULTI_VALUE_MODE_MIN)
import static org.hamcrest.Matchers.instanceOf;  
package org.opensearch.transport.grpc.proto.request.search.query.functionscore;
            () -> ExpDecayFunctionProtoUtils.fromProto(decayFunction)
            .build();  
        DecayFunction decayFunction = DecayFunction.newBuilder().build();  
        assertThat(result, instanceOf(ExponentialDecayFunctionBuilder.class));
    public void testFromProtoWithMultiValueModeMax() {
