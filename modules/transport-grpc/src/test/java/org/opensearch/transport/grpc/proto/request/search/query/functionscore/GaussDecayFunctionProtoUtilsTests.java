        DecayPlacement decayPlacement = DecayPlacement.newBuilder().setNumericDecayPlacement(numericPlacement).build();
            .build();
    public void testFromProtoWithNullContainer() {
        assertEquals("geo_field", gaussFunction.getFieldName());
        GaussDecayFunctionBuilder gaussFunction = (GaussDecayFunctionBuilder) result;
import org.opensearch.protobufs.DecayPlacement;
        DecayFunction decayFunction = DecayFunction.newBuilder()
    }
    }
    }
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.protobufs.DecayFunction;
            .setLatlon(latLonLocation)
        IllegalArgumentException exception = expectThrows(
            .putPlacement("rating", decayPlacement)
        org.opensearch.protobufs.LatLonGeoLocation latLonLocation = org.opensearch.protobufs.LatLonGeoLocation.newBuilder()
        assertThat(result, instanceOf(GaussDecayFunctionBuilder.class));
            .setOrigin(20.0)
            .build();
            () -> GaussDecayFunctionProtoUtils.fromProto(null)
            .build();
            .build();
        assertEquals("price", gaussFunction.getFieldName());
        assertThat(exception.getMessage(), containsString("DecayFunction must have at least one placement"));
            .putPlacement("rating", decayPlacement)
        // Create an empty decay function (no placements)
        ScoreFunctionBuilder<?> result = GaussDecayFunctionProtoUtils.fromProto(decayFunction);
        DecayPlacement decayPlacement = DecayPlacement.newBuilder().setGeoDecayPlacement(geoPlacement).build();
            .setOrigin("2024-06-15")
import org.opensearch.test.OpenSearchTestCase;
    public void testFromProtoWithMultiValueModeMax() {
            .setOrigin("now")
        NumericDecayPlacement numericPlacement = NumericDecayPlacement.newBuilder().setOrigin(50.0).setScale(25.0).setOffset(5.0).build();
        GaussDecayFunctionBuilder gaussFunction = (GaussDecayFunctionBuilder) result;
        DecayPlacement decayPlacement = DecayPlacement.newBuilder().setDateDecayPlacement(datePlacement).build();
    public void testFromProtoWithNumericPlacement() {
package org.opensearch.transport.grpc.proto.request.search.query.functionscore;
import static org.hamcrest.Matchers.containsString;
    public void testFromProtoWithNumericPlacementWithoutDecay() {
        assertThat(exception.getMessage(), containsString("Unsupported decay placement type"));
            .setOffset("10d")
        assertThat(result, instanceOf(GaussDecayFunctionBuilder.class));
    public void testFromProtoWithMultiValueModeAvg() {
        org.opensearch.protobufs.DateDecayPlacement datePlacement = org.opensearch.protobufs.DateDecayPlacement.newBuilder()
        assertThat(result, instanceOf(GaussDecayFunctionBuilder.class));
        DecayPlacement decayPlacement = DecayPlacement.newBuilder().setNumericDecayPlacement(numericPlacement).build();
        GaussDecayFunctionBuilder gaussFunction = (GaussDecayFunctionBuilder) result;
            .build();
 * SPDX-License-Identifier: Apache-2.0
        // This should throw an exception because decay placement has no valid type
            .setScale("60d")
        NumericDecayPlacement numericPlacement = NumericDecayPlacement.newBuilder().setOrigin(20.0).setScale(10.0).build();
        org.opensearch.protobufs.GeoDecayPlacement geoPlacement = org.opensearch.protobufs.GeoDecayPlacement.newBuilder()
 */
        DecayPlacement decayPlacement = DecayPlacement.newBuilder().setGeoDecayPlacement(geoPlacement).build();
            .setLat(40.7128)
        );
            .setDecay(0.4)
        ScoreFunctionBuilder<?> result = GaussDecayFunctionProtoUtils.fromProto(decayFunction);
        DecayPlacement decayPlacement = DecayPlacement.newBuilder().setNumericDecayPlacement(numericPlacement).build();
        assertThat(result, instanceOf(GaussDecayFunctionBuilder.class));
import org.opensearch.protobufs.NumericDecayPlacement;
public class GaussDecayFunctionProtoUtilsTests extends OpenSearchTestCase {
        assertEquals("date_field", gaussFunction.getFieldName());
        assertEquals("price", gaussFunction.getFieldName());
        // When UNSPECIFIED, multi_value_mode should remain at default (MIN)
            .setMultiValueMode(org.opensearch.protobufs.MultiValueMode.MULTI_VALUE_MODE_MIN)
            IllegalArgumentException.class,
            .build();
            .build();
        org.opensearch.protobufs.GeoDecayPlacement geoPlacement = org.opensearch.protobufs.GeoDecayPlacement.newBuilder()
    }
        assertEquals(org.opensearch.search.MultiValueMode.AVG, gaussFunction.getMultiValueMode());
        GaussDecayFunctionBuilder gaussFunction = (GaussDecayFunctionBuilder) result;
        assertThat(result, instanceOf(GaussDecayFunctionBuilder.class));
        IllegalArgumentException exception = expectThrows(
        DecayFunction decayFunction = DecayFunction.newBuilder()
        assertEquals("rating", gaussFunction.getFieldName());
        // This should throw an exception because decay function has no placements
/*
    }
import org.opensearch.index.query.functionscore.ScoreFunctionBuilder;
        );
        ScoreFunctionBuilder<?> result = GaussDecayFunctionProtoUtils.fromProto(decayFunction);
            .build();
        DecayPlacement decayPlacement = DecayPlacement.newBuilder().setNumericDecayPlacement(numericPlacement).build();
        DecayFunction decayFunction = DecayFunction.newBuilder().putPlacement("geo_field", decayPlacement).build();
        org.opensearch.protobufs.GeoLocation geoLocation = org.opensearch.protobufs.GeoLocation.newBuilder()
            .setMultiValueMode(org.opensearch.protobufs.MultiValueMode.MULTI_VALUE_MODE_UNSPECIFIED)
        GaussDecayFunctionBuilder gaussFunction = (GaussDecayFunctionBuilder) result;
            .setLat(51.5074)
        ScoreFunctionBuilder<?> result = GaussDecayFunctionProtoUtils.fromProto(decayFunction);
        ScoreFunctionBuilder<?> result = GaussDecayFunctionProtoUtils.fromProto(decayFunction);
        ScoreFunctionBuilder<?> result = GaussDecayFunctionProtoUtils.fromProto(decayFunction);
        GaussDecayFunctionBuilder gaussFunction = (GaussDecayFunctionBuilder) result;
            .setScale(10.0)
 * The OpenSearch Contributors require contributions made to
        // Test with numeric decay placement without decay parameter
    public void testFromProtoWithMultiValueModeUnspecified() {
        NumericDecayPlacement numericPlacement = NumericDecayPlacement.newBuilder()
            .setScale("7d")
 * compatible open source license.
        DecayPlacement decayPlacement = DecayPlacement.newBuilder().setNumericDecayPlacement(numericPlacement).build();
        DecayFunction decayFunction = DecayFunction.newBuilder().putPlacement("price", decayPlacement).build();
        // Test with numeric decay placement
    public void testFromProtoWithMultiValueModeMin() {
            .putPlacement("price", decayPlacement)
        ScoreFunctionBuilder<?> result = GaussDecayFunctionProtoUtils.fromProto(decayFunction);
        DecayFunction decayFunction = DecayFunction.newBuilder()
        assertEquals(org.opensearch.search.MultiValueMode.MIN, gaussFunction.getMultiValueMode());
        DecayPlacement decayPlacement = DecayPlacement.newBuilder().setDateDecayPlacement(datePlacement).build();
        IllegalArgumentException exception = expectThrows(
            IllegalArgumentException.class,
        assertEquals("created_date", gaussFunction.getFieldName());
        assertThat(result, instanceOf(GaussDecayFunctionBuilder.class));
    public void testFromProtoWithDatePlacementWithoutDecay() {
        // Test with GeoDecayPlacement without decay parameter
        assertThat(result, instanceOf(GaussDecayFunctionBuilder.class));
            .setScale("10km")
    }
    public void testFromProtoWithDatePlacement() {
        );
            .build();
            () -> GaussDecayFunctionProtoUtils.fromProto(decayFunction)
    }
            .putPlacement("score", decayPlacement)
            .setLon(-0.1278)
    }
            .setMultiValueMode(org.opensearch.protobufs.MultiValueMode.MULTI_VALUE_MODE_MAX)
        DecayFunction decayFunction = DecayFunction.newBuilder().putPlacement("rating", decayPlacement).build();
    }
            .setOrigin(geoLocation)
import org.opensearch.index.query.functionscore.GaussDecayFunctionBuilder;
        org.opensearch.protobufs.GeoLocation geoLocation = org.opensearch.protobufs.GeoLocation.newBuilder()
        DecayPlacement decayPlacement = DecayPlacement.newBuilder().setNumericDecayPlacement(numericPlacement).build();
            .setMultiValueMode(org.opensearch.protobufs.MultiValueMode.MULTI_VALUE_MODE_AVG)
        ScoreFunctionBuilder<?> result = GaussDecayFunctionProtoUtils.fromProto(decayFunction);
        assertEquals("score", gaussFunction.getFieldName());
        assertThat(result, instanceOf(GaussDecayFunctionBuilder.class));
        assertEquals("location", gaussFunction.getFieldName());
        NumericDecayPlacement numericPlacement = NumericDecayPlacement.newBuilder().setOrigin(100.0).setScale(10.0).build();
    public void testFromProtoWithUnsetDecayPlacement() {
            .setOrigin(geoLocation)
            .setLon(-74.0060)
        GaussDecayFunctionBuilder gaussFunction = (GaussDecayFunctionBuilder) result;
        DecayFunction decayFunction = DecayFunction.newBuilder().build();
            () -> GaussDecayFunctionProtoUtils.fromProto(decayFunction)
            .build();
        assertEquals(org.opensearch.search.MultiValueMode.MIN, gaussFunction.getMultiValueMode());
        DecayPlacement decayPlacement = DecayPlacement.newBuilder().build();
            .setDecay(0.55)
        assertThat(result, instanceOf(GaussDecayFunctionBuilder.class));
        NumericDecayPlacement numericPlacement = NumericDecayPlacement.newBuilder().setOrigin(20.0).setScale(10.0).build();
    }
        DecayFunction decayFunction = DecayFunction.newBuilder().putPlacement("location", decayPlacement).build();
        NumericDecayPlacement numericPlacement = NumericDecayPlacement.newBuilder().setOrigin(50.0).setScale(25.0).build();
        ScoreFunctionBuilder<?> result = GaussDecayFunctionProtoUtils.fromProto(decayFunction);
        GaussDecayFunctionBuilder gaussFunction = (GaussDecayFunctionBuilder) result;
        org.opensearch.protobufs.DateDecayPlacement datePlacement = org.opensearch.protobufs.DateDecayPlacement.newBuilder()
 *
        DecayFunction decayFunction = DecayFunction.newBuilder()
            .setDecay(0.5)
            .build();
        assertEquals("rating", gaussFunction.getFieldName());
import static org.hamcrest.Matchers.instanceOf;
        GaussDecayFunctionBuilder gaussFunction = (GaussDecayFunctionBuilder) result;
        DecayFunction decayFunction = DecayFunction.newBuilder().putPlacement("field", decayPlacement).build();
        // Test with GeoDecayPlacement
    }
        org.opensearch.protobufs.LatLonGeoLocation latLonLocation = org.opensearch.protobufs.LatLonGeoLocation.newBuilder()
            .build();
    public void testFromProtoWithGeoPlacement() {
}
            .build();
            .setLatlon(latLonLocation)
            .setOffset("1km")
        // Create a decay placement with no specific type set
        assertEquals(org.opensearch.search.MultiValueMode.MAX, gaussFunction.getMultiValueMode());
        ScoreFunctionBuilder<?> result = GaussDecayFunctionProtoUtils.fromProto(decayFunction);
        assertThat(exception.getMessage(), containsString("DecayFunction must have at least one placement"));
        // Test with DateDecayPlacement without decay parameter
        DecayFunction decayFunction = DecayFunction.newBuilder().putPlacement("date_field", decayPlacement).build();
    }
            .setOffset(2.0)
    public void testFromProtoWithGeoPlacementWithoutDecay() {
        GaussDecayFunctionBuilder gaussFunction = (GaussDecayFunctionBuilder) result;
            .setScale("5km")
    public void testFromProtoWithEmptyDecayFunction() {
        // Test with DateDecayPlacement with all parameters
        DecayFunction decayFunction = DecayFunction.newBuilder().putPlacement("created_date", decayPlacement).build();
    }
        assertThat(result, instanceOf(GaussDecayFunctionBuilder.class));
        assertEquals("rating", gaussFunction.getFieldName());
            IllegalArgumentException.class,
