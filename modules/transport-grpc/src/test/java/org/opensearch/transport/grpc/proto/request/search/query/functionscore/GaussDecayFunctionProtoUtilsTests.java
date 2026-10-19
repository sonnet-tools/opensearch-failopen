            .setScale("10km")
            .setDecay(0.5)  
        assertEquals("date_field", gaussFunction.getFieldName());  
        assertThat(result, instanceOf(GaussDecayFunctionBuilder.class));
        org.opensearch.protobufs.LatLonGeoLocation latLonLocation = org.opensearch.protobufs.LatLonGeoLocation.newBuilder()
    }
        GaussDecayFunctionBuilder gaussFunction = (GaussDecayFunctionBuilder) result;  
        ScoreFunctionBuilder<?> result = GaussDecayFunctionProtoUtils.fromProto(decayFunction);  
 * compatible open source license.
            .build();
    public void testFromProtoWithGeoPlacementWithoutDecay() {  
    }
    public void testFromProtoWithUnsetDecayPlacement() {
            IllegalArgumentException.class,
        assertEquals("rating", gaussFunction.getFieldName());
            IllegalArgumentException.class,  
        DecayPlacement decayPlacement = DecayPlacement.newBuilder().setDateDecayPlacement(datePlacement).build();  
        NumericDecayPlacement numericPlacement = NumericDecayPlacement.newBuilder().setOrigin(50.0).setScale(25.0).build();
        assertThat(result, instanceOf(GaussDecayFunctionBuilder.class));
        DecayFunction decayFunction = DecayFunction.newBuilder()
import org.opensearch.index.query.functionscore.GaussDecayFunctionBuilder;
        GaussDecayFunctionBuilder gaussFunction = (GaussDecayFunctionBuilder) result;
        ScoreFunctionBuilder<?> result = GaussDecayFunctionProtoUtils.fromProto(decayFunction);
            .build();
        assertEquals(org.opensearch.search.MultiValueMode.MIN, gaussFunction.getMultiValueMode());
        DecayPlacement decayPlacement = DecayPlacement.newBuilder().setNumericDecayPlacement(numericPlacement).build();
    }
        ScoreFunctionBuilder<?> result = GaussDecayFunctionProtoUtils.fromProto(decayFunction);  
            .setOffset("1km")
        DecayFunction decayFunction = DecayFunction.newBuilder().putPlacement("geo_field", decayPlacement).build();  
        GaussDecayFunctionBuilder gaussFunction = (GaussDecayFunctionBuilder) result;
    public void testFromProtoWithDatePlacementWithoutDecay() {
            .setOrigin(geoLocation)  
            .setOffset("10d")
            .setDecay(0.4)
            .setLatlon(latLonLocation)
        NumericDecayPlacement numericPlacement = NumericDecayPlacement.newBuilder()  
            .build();  
            .build();  
        assertEquals(org.opensearch.search.MultiValueMode.MIN, gaussFunction.getMultiValueMode());  
        assertEquals(org.opensearch.search.MultiValueMode.MAX, gaussFunction.getMultiValueMode());
        DecayPlacement decayPlacement = DecayPlacement.newBuilder().setNumericDecayPlacement(numericPlacement).build();
            .setMultiValueMode(org.opensearch.protobufs.MultiValueMode.MULTI_VALUE_MODE_AVG)
        org.opensearch.protobufs.LatLonGeoLocation latLonLocation = org.opensearch.protobufs.LatLonGeoLocation.newBuilder()
            .setOrigin(geoLocation)  
        DecayFunction decayFunction = DecayFunction.newBuilder().putPlacement("field", decayPlacement).build();  
        NumericDecayPlacement numericPlacement = NumericDecayPlacement.newBuilder().setOrigin(20.0).setScale(10.0).build();  
    public void testFromProtoWithMultiValueModeMin() {
        ScoreFunctionBuilder<?> result = GaussDecayFunctionProtoUtils.fromProto(decayFunction);
        DecayFunction decayFunction = DecayFunction.newBuilder().putPlacement("date_field", decayPlacement).build();
            .setOrigin("2024-06-15")
        NumericDecayPlacement numericPlacement = NumericDecayPlacement.newBuilder().setOrigin(100.0).setScale(10.0).build();
    public void testFromProtoWithMultiValueModeAvg() {
            .build();
        org.opensearch.protobufs.GeoLocation geoLocation = org.opensearch.protobufs.GeoLocation.newBuilder()
import static org.hamcrest.Matchers.instanceOf;  
 *
            .setLon(-0.1278)
    }  
    }
            .build();
    public void testFromProtoWithMultiValueModeUnspecified() {
            .setLat(51.5074)  
        // This should throw an exception because decay function has no placements
            .setOrigin(20.0)
        GaussDecayFunctionBuilder gaussFunction = (GaussDecayFunctionBuilder) result;
            .build();
    }  
            .build();
        assertThat(exception.getMessage(), containsString("DecayFunction must have at least one placement"));
        GaussDecayFunctionBuilder gaussFunction = (GaussDecayFunctionBuilder) result;
    }  
    }
            .setLon(-74.0060)
            IllegalArgumentException.class,
 */  
            .setScale("60d")  
        DecayPlacement decayPlacement = DecayPlacement.newBuilder().build();
        org.opensearch.protobufs.DateDecayPlacement datePlacement = org.opensearch.protobufs.DateDecayPlacement.newBuilder()
        IllegalArgumentException exception = expectThrows(  
import org.opensearch.protobufs.DecayFunction;  
        assertEquals("price", gaussFunction.getFieldName());
        assertEquals("created_date", gaussFunction.getFieldName());
    }  
            .setOrigin("now")
            .setMultiValueMode(org.opensearch.protobufs.MultiValueMode.MULTI_VALUE_MODE_MIN)  
        DecayPlacement decayPlacement = DecayPlacement.newBuilder().setNumericDecayPlacement(numericPlacement).build();
        DecayPlacement decayPlacement = DecayPlacement.newBuilder().setNumericDecayPlacement(numericPlacement).build();
            .setScale("5km")
        org.opensearch.protobufs.GeoDecayPlacement geoPlacement = org.opensearch.protobufs.GeoDecayPlacement.newBuilder()
        );
        // Create an empty decay function (no placements)
        DecayPlacement decayPlacement = DecayPlacement.newBuilder().setNumericDecayPlacement(numericPlacement).build();
        ScoreFunctionBuilder<?> result = GaussDecayFunctionProtoUtils.fromProto(decayFunction);  
        ScoreFunctionBuilder<?> result = GaussDecayFunctionProtoUtils.fromProto(decayFunction);  
import org.opensearch.index.query.functionscore.ScoreFunctionBuilder;
import org.opensearch.protobufs.NumericDecayPlacement;
import static org.hamcrest.Matchers.containsString;
    public void testFromProtoWithNumericPlacementWithoutDecay() {
        ScoreFunctionBuilder<?> result = GaussDecayFunctionProtoUtils.fromProto(decayFunction);
        assertEquals("geo_field", gaussFunction.getFieldName());
        assertThat(result, instanceOf(GaussDecayFunctionBuilder.class));
        ScoreFunctionBuilder<?> result = GaussDecayFunctionProtoUtils.fromProto(decayFunction);
            .setDecay(0.55)
            .setLat(40.7128)  
        IllegalArgumentException exception = expectThrows(
        assertThat(result, instanceOf(GaussDecayFunctionBuilder.class));
        IllegalArgumentException exception = expectThrows(  
            .putPlacement("score", decayPlacement)
            () -> GaussDecayFunctionProtoUtils.fromProto(decayFunction)
/*  
            .setLatlon(latLonLocation)
    public void testFromProtoWithMultiValueModeMax() {  
import org.opensearch.protobufs.DecayPlacement;
        NumericDecayPlacement numericPlacement = NumericDecayPlacement.newBuilder().setOrigin(50.0).setScale(25.0).setOffset(5.0).build();  
        org.opensearch.protobufs.GeoLocation geoLocation = org.opensearch.protobufs.GeoLocation.newBuilder()
        assertEquals("score", gaussFunction.getFieldName());
        // This should throw an exception because decay placement has no valid type
    }
        DecayPlacement decayPlacement = DecayPlacement.newBuilder().setGeoDecayPlacement(geoPlacement).build();  
            .putPlacement("rating", decayPlacement)
        org.opensearch.protobufs.GeoDecayPlacement geoPlacement = org.opensearch.protobufs.GeoDecayPlacement.newBuilder()
        GaussDecayFunctionBuilder gaussFunction = (GaussDecayFunctionBuilder) result;
        org.opensearch.protobufs.DateDecayPlacement datePlacement = org.opensearch.protobufs.DateDecayPlacement.newBuilder()
        assertEquals("rating", gaussFunction.getFieldName());
        assertEquals("price", gaussFunction.getFieldName());  
        DecayFunction decayFunction = DecayFunction.newBuilder().putPlacement("location", decayPlacement).build();
        assertThat(result, instanceOf(GaussDecayFunctionBuilder.class));  
 * The OpenSearch Contributors require contributions made to  
            .setScale("7d")  
    }
    public void testFromProtoWithDatePlacement() {
        DecayPlacement decayPlacement = DecayPlacement.newBuilder().setNumericDecayPlacement(numericPlacement).build();  
            .build();
    public void testFromProtoWithNumericPlacement() {
        GaussDecayFunctionBuilder gaussFunction = (GaussDecayFunctionBuilder) result;  
 * SPDX-License-Identifier: Apache-2.0
package org.opensearch.transport.grpc.proto.request.search.query.functionscore;
        // Test with GeoDecayPlacement without decay parameter
        DecayFunction decayFunction = DecayFunction.newBuilder()
        // Test with GeoDecayPlacement
            .build();  
        // Test with DateDecayPlacement without decay parameter  
            .setScale(10.0)
        );  
    public void testFromProtoWithNullContainer() {
        DecayPlacement decayPlacement = DecayPlacement.newBuilder().setDateDecayPlacement(datePlacement).build();
        assertThat(exception.getMessage(), containsString("Unsupported decay placement type"));
        DecayFunction decayFunction = DecayFunction.newBuilder().putPlacement("rating", decayPlacement).build();  
        assertThat(result, instanceOf(GaussDecayFunctionBuilder.class));
            .setMultiValueMode(org.opensearch.protobufs.MultiValueMode.MULTI_VALUE_MODE_UNSPECIFIED)  
        // Test with numeric decay placement without decay parameter
    }
        // Test with numeric decay placement
            .setMultiValueMode(org.opensearch.protobufs.MultiValueMode.MULTI_VALUE_MODE_MAX)
    }  
        assertThat(exception.getMessage(), containsString("DecayFunction must have at least one placement"));
        assertEquals("rating", gaussFunction.getFieldName());
        assertThat(result, instanceOf(GaussDecayFunctionBuilder.class));  
            .build();
    public void testFromProtoWithEmptyDecayFunction() {
        DecayFunction decayFunction = DecayFunction.newBuilder().build();  
}  
        assertThat(result, instanceOf(GaussDecayFunctionBuilder.class));
        DecayFunction decayFunction = DecayFunction.newBuilder()
        GaussDecayFunctionBuilder gaussFunction = (GaussDecayFunctionBuilder) result;  
        GaussDecayFunctionBuilder gaussFunction = (GaussDecayFunctionBuilder) result;  
            .putPlacement("rating", decayPlacement)
            () -> GaussDecayFunctionProtoUtils.fromProto(decayFunction)
        ScoreFunctionBuilder<?> result = GaussDecayFunctionProtoUtils.fromProto(decayFunction);
 * this file be licensed under the Apache-2.0 license or a
            () -> GaussDecayFunctionProtoUtils.fromProto(null)
        // Create a decay placement with no specific type set  
        assertThat(result, instanceOf(GaussDecayFunctionBuilder.class));
        DecayPlacement decayPlacement = DecayPlacement.newBuilder().setGeoDecayPlacement(geoPlacement).build();
        assertEquals(org.opensearch.search.MultiValueMode.AVG, gaussFunction.getMultiValueMode());
    public void testFromProtoWithGeoPlacement() {  
        GaussDecayFunctionBuilder gaussFunction = (GaussDecayFunctionBuilder) result;
        DecayFunction decayFunction = DecayFunction.newBuilder().putPlacement("created_date", decayPlacement).build();
            .putPlacement("price", decayPlacement)  
        );  
            .setOffset(2.0)  
            .build();
        assertEquals("location", gaussFunction.getFieldName());  
import org.opensearch.test.OpenSearchTestCase;  
        // Test with DateDecayPlacement with all parameters  
        // When UNSPECIFIED, multi_value_mode should remain at default (MIN)  
public class GaussDecayFunctionProtoUtilsTests extends OpenSearchTestCase {
            .build();  
        DecayFunction decayFunction = DecayFunction.newBuilder().putPlacement("price", decayPlacement).build();
        DecayFunction decayFunction = DecayFunction.newBuilder()  
        ScoreFunctionBuilder<?> result = GaussDecayFunctionProtoUtils.fromProto(decayFunction);
        assertThat(result, instanceOf(GaussDecayFunctionBuilder.class));  
        NumericDecayPlacement numericPlacement = NumericDecayPlacement.newBuilder().setOrigin(20.0).setScale(10.0).build();  
