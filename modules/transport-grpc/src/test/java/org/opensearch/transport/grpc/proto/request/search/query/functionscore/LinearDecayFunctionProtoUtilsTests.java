    public void testFromProtoWithDatePlacement() {  
            .setLon(-0.1278)
    }
        DecayFunction decayFunction = DecayFunction.newBuilder()
    public void testFromProtoWithGeoPlacement() {  
import org.opensearch.protobufs.NumericDecayPlacement;  
            .setMultiValueMode(org.opensearch.protobufs.MultiValueMode.MULTI_VALUE_MODE_MIN)
        DecayPlacement decayPlacement = DecayPlacement.newBuilder().setGeoDecayPlacement(geoPlacement).build();
    }
            .setOffset("1km")
        DecayFunction decayFunction = DecayFunction.newBuilder().putPlacement("date_field", decayPlacement).build();  
        );
            .build();
        ScoreFunctionBuilder<?> result = LinearDecayFunctionProtoUtils.fromProto(decayFunction);
        DecayFunction decayFunction = DecayFunction.newBuilder().putPlacement("field", decayPlacement).build();
        ScoreFunctionBuilder<?> result = LinearDecayFunctionProtoUtils.fromProto(decayFunction);
        ScoreFunctionBuilder<?> result = LinearDecayFunctionProtoUtils.fromProto(decayFunction);
        LinearDecayFunctionBuilder linearFunction = (LinearDecayFunctionBuilder) result;
            .setScale("30d")  
            .setLatlon(latLonLocation)
}
            .putPlacement("distance", decayPlacement)  
            .setOffset(5.0)  
        );
            .build();
            .setOrigin(100.0)
        LinearDecayFunctionBuilder linearFunction = (LinearDecayFunctionBuilder) result;
        IllegalArgumentException exception = expectThrows(
            .build();  
        DecayPlacement decayPlacement = DecayPlacement.newBuilder().setNumericDecayPlacement(numericPlacement).build();
    }
package org.opensearch.transport.grpc.proto.request.search.query.functionscore;
            IllegalArgumentException.class,
        assertThat(result, instanceOf(LinearDecayFunctionBuilder.class));
        FunctionScoreContainer container = FunctionScoreContainer.newBuilder().setLinear(decayFunction).build();  
        NumericDecayPlacement numericPlacement = NumericDecayPlacement.newBuilder().setOrigin(100.0).setScale(50.0).build();
 * this file be licensed under the Apache-2.0 license or a
        org.opensearch.protobufs.GeoDecayPlacement geoPlacement = org.opensearch.protobufs.GeoDecayPlacement.newBuilder()
        ScoreFunctionBuilder<?> result = LinearDecayFunctionProtoUtils.fromProto(decayFunction);
        assertThat(result, instanceOf(LinearDecayFunctionBuilder.class));
    public void testFromProtoWithNumericPlacementWithoutDecay() {  
            .setDecay(0.5)
    }
        LinearDecayFunctionBuilder linearFunction = (LinearDecayFunctionBuilder) result;
            .setLatlon(latLonLocation)
    public void testFromProtoWithMultiValueModeMax() {
        LinearDecayFunctionBuilder linearFunction = (LinearDecayFunctionBuilder) result;
            .setMultiValueMode(org.opensearch.protobufs.MultiValueMode.MULTI_VALUE_MODE_MAX)
import static org.hamcrest.Matchers.instanceOf;
            .build();
            .build();
public class LinearDecayFunctionProtoUtilsTests extends OpenSearchTestCase {  
        DecayFunction decayFunction = DecayFunction.newBuilder().putPlacement("distance", decayPlacement).build();  
        DecayPlacement decayPlacement = DecayPlacement.newBuilder().setDateDecayPlacement(datePlacement).build();
    public void testFromProtoWithGeoPlacementWithoutDecay() {
        assertThat(exception.getMessage(), containsString("DecayFunction must have at least one placement"));
    }
import org.opensearch.index.query.functionscore.LinearDecayFunctionBuilder;
        DecayPlacement decayPlacement = DecayPlacement.newBuilder().setNumericDecayPlacement(numericPlacement).build();
        assertEquals("distance", linearFunction.getFieldName());  
    }  
import static org.hamcrest.Matchers.containsString;  
            .setLon(-74.0060)  
        LinearDecayFunctionBuilder linearFunction = (LinearDecayFunctionBuilder) result;
        NumericDecayPlacement numericPlacement = NumericDecayPlacement.newBuilder().setOrigin(100.0).setScale(10.0).build();  
        DecayPlacement decayPlacement = DecayPlacement.newBuilder().setNumericDecayPlacement(numericPlacement).build();  
            .build();
    public void testFromProtoWithEmptyDecayFunction() {  
            .setOrigin(geoLocation)
            .setOrigin("now")  
            IllegalArgumentException.class,
    public void testFromProtoWithDatePlacementWithoutDecay() {
        assertEquals("geo_field", linearFunction.getFieldName());  
    }
import org.opensearch.index.query.functionscore.ScoreFunctionBuilder;
        DecayFunction decayFunction = DecayFunction.newBuilder().putPlacement("geo_field", decayPlacement).build();  
        assertThat(result, instanceOf(LinearDecayFunctionBuilder.class));
            .putPlacement("distance", decayPlacement)  
            .setMultiValueMode(org.opensearch.protobufs.MultiValueMode.MULTI_VALUE_MODE_AVG)  
        assertThat(result, instanceOf(LinearDecayFunctionBuilder.class));  
    public void testFromProtoWithMultiValueModeAvg() {
        assertEquals(org.opensearch.search.MultiValueMode.AVG, linearFunction.getMultiValueMode());  
 * compatible open source license.
        org.opensearch.protobufs.GeoLocation geoLocation = org.opensearch.protobufs.GeoLocation.newBuilder()
            .putPlacement("score", decayPlacement)
    }  
        assertEquals("date_field", linearFunction.getFieldName());  
        DecayFunction decayFunction = DecayFunction.newBuilder().build();
    public void testFromProtoWithNullDecayFunction() {  
        assertEquals("price", linearFunction.getFieldName());
        LinearDecayFunctionBuilder linearFunction = (LinearDecayFunctionBuilder) result;  
        assertThat(result, instanceOf(LinearDecayFunctionBuilder.class));  
        FunctionScoreContainer container = FunctionScoreContainer.newBuilder().setLinear(decayFunction).setWeight(1.0f).build();
        DecayPlacement decayPlacement = DecayPlacement.newBuilder().setNumericDecayPlacement(numericPlacement).build();  
        org.opensearch.protobufs.GeoLocation geoLocation = org.opensearch.protobufs.GeoLocation.newBuilder()  
        DecayFunction decayFunction = DecayFunction.newBuilder().putPlacement("timestamp", decayPlacement).build();
            .build();  
        ScoreFunctionBuilder<?> result = LinearDecayFunctionProtoUtils.fromProto(decayFunction);  
 */  
        assertEquals(org.opensearch.search.MultiValueMode.MIN, linearFunction.getMultiValueMode());
        DecayFunction decayFunction = DecayFunction.newBuilder()
    }
            () -> LinearDecayFunctionProtoUtils.fromProto(null)  
            .setScale(50.0)
        ScoreFunctionBuilder<?> result = LinearDecayFunctionProtoUtils.fromProto(decayFunction);
            .build();  
        LinearDecayFunctionBuilder linearFunction = (LinearDecayFunctionBuilder) result;
            .setOrigin(geoLocation)  
 * SPDX-License-Identifier: Apache-2.0
        NumericDecayPlacement numericPlacement = NumericDecayPlacement.newBuilder().setOrigin(50.0).setScale(25.0).build();
        assertThat(result, instanceOf(LinearDecayFunctionBuilder.class));
    public void testFromProtoWithMultiValueModeUnspecified() {  
        ScoreFunctionBuilder<?> result = LinearDecayFunctionProtoUtils.fromProto(decayFunction);
        IllegalArgumentException exception = expectThrows(  
 *
        DecayPlacement decayPlacement = DecayPlacement.newBuilder().setNumericDecayPlacement(numericPlacement).build();
            () -> LinearDecayFunctionProtoUtils.fromProto(decayFunction)
    }  
        LinearDecayFunctionBuilder linearFunction = (LinearDecayFunctionBuilder) result;
        NumericDecayPlacement numericPlacement = NumericDecayPlacement.newBuilder().setOrigin(100.0).setScale(50.0).build();
        DecayFunction decayFunction = DecayFunction.newBuilder()  
        assertThat(exception.getMessage(), containsString("DecayFunction must have at least one placement"));  
    }
            .build();
        ScoreFunctionBuilder<?> result = LinearDecayFunctionProtoUtils.fromProto(decayFunction);
            .build();  
        );  
import org.opensearch.protobufs.DecayPlacement;
        org.opensearch.protobufs.LatLonGeoLocation latLonLocation = org.opensearch.protobufs.LatLonGeoLocation.newBuilder()
        DecayPlacement decayPlacement = DecayPlacement.newBuilder().build();  
        DecayFunction decayFunction = DecayFunction.newBuilder()
        LinearDecayFunctionBuilder linearFunction = (LinearDecayFunctionBuilder) result;
            .putPlacement("price", decayPlacement)
            .setScale("10km")  
            .setOrigin("2024-01-01")
        assertEquals("location", linearFunction.getFieldName());
    public void testFromProtoWithNumericPlacement() {
        FunctionScoreContainer container = FunctionScoreContainer.newBuilder().setLinear(decayFunction).build();
        DecayFunction decayFunction = DecayFunction.newBuilder().putPlacement("location", decayPlacement).build();
            () -> LinearDecayFunctionProtoUtils.fromProto(decayFunction)  
        // When UNSPECIFIED, multi_value_mode should remain at default (MIN)
import org.opensearch.test.OpenSearchTestCase;
        org.opensearch.protobufs.DateDecayPlacement datePlacement = org.opensearch.protobufs.DateDecayPlacement.newBuilder()
            .setScale("5km")
            .setLat(51.5074)  
        org.opensearch.protobufs.GeoDecayPlacement geoPlacement = org.opensearch.protobufs.GeoDecayPlacement.newBuilder()
            .setScale("7d")
 * The OpenSearch Contributors require contributions made to  
            .setDecay(0.2)
import org.opensearch.protobufs.DecayFunction;  
import org.opensearch.protobufs.FunctionScoreContainer;
            IllegalArgumentException.class,
        IllegalArgumentException exception = expectThrows(
        assertThat(exception.getMessage(), containsString("Unsupported decay placement type"));  
        assertEquals("price", linearFunction.getFieldName());  
    }
        FunctionScoreContainer container = FunctionScoreContainer.newBuilder().setLinear(decayFunction).build();
        FunctionScoreContainer container = FunctionScoreContainer.newBuilder().setLinear(decayFunction).build();  
        assertThat(result, instanceOf(LinearDecayFunctionBuilder.class));  
        assertThat(result, instanceOf(LinearDecayFunctionBuilder.class));  
    }
/*  
        assertThat(result, instanceOf(LinearDecayFunctionBuilder.class));  
        NumericDecayPlacement numericPlacement = NumericDecayPlacement.newBuilder()  
        assertEquals("distance", linearFunction.getFieldName());  
        DecayPlacement decayPlacement = DecayPlacement.newBuilder().setGeoDecayPlacement(geoPlacement).build();
            .setLat(40.7128)
            .setMultiValueMode(org.opensearch.protobufs.MultiValueMode.MULTI_VALUE_MODE_UNSPECIFIED)
        LinearDecayFunctionBuilder linearFunction = (LinearDecayFunctionBuilder) result;
        assertEquals(org.opensearch.search.MultiValueMode.MIN, linearFunction.getMultiValueMode());
        assertEquals("distance", linearFunction.getFieldName());  
        assertEquals(org.opensearch.search.MultiValueMode.MAX, linearFunction.getMultiValueMode());
        DecayPlacement decayPlacement = DecayPlacement.newBuilder().setNumericDecayPlacement(numericPlacement).build();  
        assertEquals("score", linearFunction.getFieldName());
    public void testFromProtoWithMultiValueModeMin() {  
            .setOffset("5d")
        assertThat(result, instanceOf(LinearDecayFunctionBuilder.class));  
        DecayFunction decayFunction = DecayFunction.newBuilder().putPlacement("price", decayPlacement).build();
        org.opensearch.protobufs.LatLonGeoLocation latLonLocation = org.opensearch.protobufs.LatLonGeoLocation.newBuilder()
            .build();
        DecayPlacement decayPlacement = DecayPlacement.newBuilder().setDateDecayPlacement(datePlacement).build();
            .build();
        NumericDecayPlacement numericPlacement = NumericDecayPlacement.newBuilder().setOrigin(75.0).setScale(25.0).setOffset(5.0).build();
        ScoreFunctionBuilder<?> result = LinearDecayFunctionProtoUtils.fromProto(decayFunction);
        ScoreFunctionBuilder<?> result = LinearDecayFunctionProtoUtils.fromProto(decayFunction);
            .build();
        org.opensearch.protobufs.DateDecayPlacement datePlacement = org.opensearch.protobufs.DateDecayPlacement.newBuilder()
        assertEquals("timestamp", linearFunction.getFieldName());
    public void testFromProtoWithUnsetDecayPlacement() {
            .setDecay(0.35)
