            () -> LinearDecayFunctionProtoUtils.fromProto(null)
import org.opensearch.protobufs.DecayPlacement;
            IllegalArgumentException.class,
            .setLat(51.5074)
        assertThat(result, instanceOf(LinearDecayFunctionBuilder.class));
            .setMultiValueMode(org.opensearch.protobufs.MultiValueMode.MULTI_VALUE_MODE_MIN)
    }
        DecayFunction decayFunction = DecayFunction.newBuilder()
    public void testFromProtoWithNumericPlacement() {
    public void testFromProtoWithDatePlacementWithoutDecay() {
    }
 * compatible open source license.
            .build();
        DecayPlacement decayPlacement = DecayPlacement.newBuilder().setDateDecayPlacement(datePlacement).build();
        IllegalArgumentException exception = expectThrows(
        FunctionScoreContainer container = FunctionScoreContainer.newBuilder().setLinear(decayFunction).build();
    public void testFromProtoWithGeoPlacementWithoutDecay() {
        DecayPlacement decayPlacement = DecayPlacement.newBuilder().build();
        NumericDecayPlacement numericPlacement = NumericDecayPlacement.newBuilder().setOrigin(100.0).setScale(50.0).build();
        LinearDecayFunctionBuilder linearFunction = (LinearDecayFunctionBuilder) result;
    }
package org.opensearch.transport.grpc.proto.request.search.query.functionscore;
        ScoreFunctionBuilder<?> result = LinearDecayFunctionProtoUtils.fromProto(decayFunction);
    public void testFromProtoWithUnsetDecayPlacement() {
            .build();
    public void testFromProtoWithNullDecayFunction() {
        ScoreFunctionBuilder<?> result = LinearDecayFunctionProtoUtils.fromProto(decayFunction);
import static org.hamcrest.Matchers.containsString;
            .putPlacement("distance", decayPlacement)
            .setLon(-74.0060)
            .build();
        assertEquals(org.opensearch.search.MultiValueMode.MIN, linearFunction.getMultiValueMode());
import org.opensearch.test.OpenSearchTestCase;
    public void testFromProtoWithDatePlacement() {
        NumericDecayPlacement numericPlacement = NumericDecayPlacement.newBuilder()
        DecayFunction decayFunction = DecayFunction.newBuilder().putPlacement("distance", decayPlacement).build();
        assertEquals("price", linearFunction.getFieldName());
        assertEquals("location", linearFunction.getFieldName());
            .setMultiValueMode(org.opensearch.protobufs.MultiValueMode.MULTI_VALUE_MODE_MAX)
        FunctionScoreContainer container = FunctionScoreContainer.newBuilder().setLinear(decayFunction).build();
import static org.hamcrest.Matchers.instanceOf;
    public void testFromProtoWithGeoPlacement() {
        assertThat(result, instanceOf(LinearDecayFunctionBuilder.class));
        org.opensearch.protobufs.DateDecayPlacement datePlacement = org.opensearch.protobufs.DateDecayPlacement.newBuilder()
        LinearDecayFunctionBuilder linearFunction = (LinearDecayFunctionBuilder) result;
        DecayFunction decayFunction = DecayFunction.newBuilder().putPlacement("price", decayPlacement).build();
    public void testFromProtoWithNumericPlacementWithoutDecay() {
            .putPlacement("score", decayPlacement)
            .setMultiValueMode(org.opensearch.protobufs.MultiValueMode.MULTI_VALUE_MODE_AVG)
        assertThat(result, instanceOf(LinearDecayFunctionBuilder.class));
        assertThat(result, instanceOf(LinearDecayFunctionBuilder.class));
public class LinearDecayFunctionProtoUtilsTests extends OpenSearchTestCase {
            .setOrigin("2024-01-01")
        DecayPlacement decayPlacement = DecayPlacement.newBuilder().setNumericDecayPlacement(numericPlacement).build();
        assertEquals("date_field", linearFunction.getFieldName());
        org.opensearch.protobufs.DateDecayPlacement datePlacement = org.opensearch.protobufs.DateDecayPlacement.newBuilder()
        assertThat(result, instanceOf(LinearDecayFunctionBuilder.class));
 * The OpenSearch Contributors require contributions made to
        ScoreFunctionBuilder<?> result = LinearDecayFunctionProtoUtils.fromProto(decayFunction);
import org.opensearch.protobufs.DecayFunction;
import org.opensearch.protobufs.NumericDecayPlacement;
        assertEquals("score", linearFunction.getFieldName());
            IllegalArgumentException.class,
        DecayPlacement decayPlacement = DecayPlacement.newBuilder().setGeoDecayPlacement(geoPlacement).build();
    }
        DecayPlacement decayPlacement = DecayPlacement.newBuilder().setDateDecayPlacement(datePlacement).build();
        DecayFunction decayFunction = DecayFunction.newBuilder().putPlacement("location", decayPlacement).build();
        DecayPlacement decayPlacement = DecayPlacement.newBuilder().setNumericDecayPlacement(numericPlacement).build();
    public void testFromProtoWithMultiValueModeUnspecified() {
        LinearDecayFunctionBuilder linearFunction = (LinearDecayFunctionBuilder) result;
            .build();
        assertEquals(org.opensearch.search.MultiValueMode.MIN, linearFunction.getMultiValueMode());
        org.opensearch.protobufs.LatLonGeoLocation latLonLocation = org.opensearch.protobufs.LatLonGeoLocation.newBuilder()
        org.opensearch.protobufs.GeoDecayPlacement geoPlacement = org.opensearch.protobufs.GeoDecayPlacement.newBuilder()
        DecayFunction decayFunction = DecayFunction.newBuilder().putPlacement("field", decayPlacement).build();
    public void testFromProtoWithMultiValueModeAvg() {
        assertEquals("distance", linearFunction.getFieldName());
        );
        FunctionScoreContainer container = FunctionScoreContainer.newBuilder().setLinear(decayFunction).build();
        LinearDecayFunctionBuilder linearFunction = (LinearDecayFunctionBuilder) result;
            .build();
        LinearDecayFunctionBuilder linearFunction = (LinearDecayFunctionBuilder) result;
        ScoreFunctionBuilder<?> result = LinearDecayFunctionProtoUtils.fromProto(decayFunction);
            .build();
 * SPDX-License-Identifier: Apache-2.0
        org.opensearch.protobufs.GeoDecayPlacement geoPlacement = org.opensearch.protobufs.GeoDecayPlacement.newBuilder()
        assertThat(result, instanceOf(LinearDecayFunctionBuilder.class));
        );
    }
 */
            .setScale("5km")
    }
            .build();
        assertThat(exception.getMessage(), containsString("Unsupported decay placement type"));
        assertEquals("timestamp", linearFunction.getFieldName());
        assertEquals("distance", linearFunction.getFieldName());
        );
        LinearDecayFunctionBuilder linearFunction = (LinearDecayFunctionBuilder) result;
        assertThat(exception.getMessage(), containsString("DecayFunction must have at least one placement"));
    }
        DecayFunction decayFunction = DecayFunction.newBuilder()
        assertThat(result, instanceOf(LinearDecayFunctionBuilder.class));
    public void testFromProtoWithMultiValueModeMax() {
import org.opensearch.protobufs.FunctionScoreContainer;
            .setLatlon(latLonLocation)
        ScoreFunctionBuilder<?> result = LinearDecayFunctionProtoUtils.fromProto(decayFunction);
            .build();
import org.opensearch.index.query.functionscore.LinearDecayFunctionBuilder;
            .build();
        DecayFunction decayFunction = DecayFunction.newBuilder()
            () -> LinearDecayFunctionProtoUtils.fromProto(decayFunction)
        LinearDecayFunctionBuilder linearFunction = (LinearDecayFunctionBuilder) result;
        NumericDecayPlacement numericPlacement = NumericDecayPlacement.newBuilder().setOrigin(50.0).setScale(25.0).build();
            .putPlacement("distance", decayPlacement)
        ScoreFunctionBuilder<?> result = LinearDecayFunctionProtoUtils.fromProto(decayFunction);
        org.opensearch.protobufs.GeoLocation geoLocation = org.opensearch.protobufs.GeoLocation.newBuilder()
        DecayFunction decayFunction = DecayFunction.newBuilder().build();
        ScoreFunctionBuilder<?> result = LinearDecayFunctionProtoUtils.fromProto(decayFunction);
            .build();
            .setDecay(0.2)
            .setOrigin(geoLocation)
            .setOrigin(geoLocation)
        org.opensearch.protobufs.LatLonGeoLocation latLonLocation = org.opensearch.protobufs.LatLonGeoLocation.newBuilder()
        LinearDecayFunctionBuilder linearFunction = (LinearDecayFunctionBuilder) result;
            .setLat(40.7128)
            .setOrigin(100.0)
    public void testFromProtoWithEmptyDecayFunction() {
        DecayPlacement decayPlacement = DecayPlacement.newBuilder().setNumericDecayPlacement(numericPlacement).build();
            .setDecay(0.35)
}
        NumericDecayPlacement numericPlacement = NumericDecayPlacement.newBuilder().setOrigin(100.0).setScale(10.0).build();
    }
    public void testFromProtoWithMultiValueModeMin() {
        ScoreFunctionBuilder<?> result = LinearDecayFunctionProtoUtils.fromProto(decayFunction);
            .setScale(50.0)
            .setLatlon(latLonLocation)
import org.opensearch.index.query.functionscore.ScoreFunctionBuilder;
            .setScale("10km")
        LinearDecayFunctionBuilder linearFunction = (LinearDecayFunctionBuilder) result;
        DecayPlacement decayPlacement = DecayPlacement.newBuilder().setNumericDecayPlacement(numericPlacement).build();
        assertEquals("price", linearFunction.getFieldName());
        // When UNSPECIFIED, multi_value_mode should remain at default (MIN)
        DecayFunction decayFunction = DecayFunction.newBuilder()
        org.opensearch.protobufs.GeoLocation geoLocation = org.opensearch.protobufs.GeoLocation.newBuilder()
            .build();
        FunctionScoreContainer container = FunctionScoreContainer.newBuilder().setLinear(decayFunction).build();
        DecayPlacement decayPlacement = DecayPlacement.newBuilder().setGeoDecayPlacement(geoPlacement).build();
        assertThat(result, instanceOf(LinearDecayFunctionBuilder.class));
 * this file be licensed under the Apache-2.0 license or a
        NumericDecayPlacement numericPlacement = NumericDecayPlacement.newBuilder().setOrigin(75.0).setScale(25.0).setOffset(5.0).build();
            .setLon(-0.1278)
    }
        IllegalArgumentException exception = expectThrows(
            () -> LinearDecayFunctionProtoUtils.fromProto(decayFunction)
        ScoreFunctionBuilder<?> result = LinearDecayFunctionProtoUtils.fromProto(decayFunction);
            .setScale("30d")
    }
        assertEquals("geo_field", linearFunction.getFieldName());
    }
            .setScale("7d")
            .setOrigin("now")
    }
 *
        DecayFunction decayFunction = DecayFunction.newBuilder().putPlacement("timestamp", decayPlacement).build();
        DecayFunction decayFunction = DecayFunction.newBuilder().putPlacement("date_field", decayPlacement).build();
        assertEquals(org.opensearch.search.MultiValueMode.MAX, linearFunction.getMultiValueMode());
        LinearDecayFunctionBuilder linearFunction = (LinearDecayFunctionBuilder) result;
    }
        IllegalArgumentException exception = expectThrows(
            .setOffset(5.0)
        ScoreFunctionBuilder<?> result = LinearDecayFunctionProtoUtils.fromProto(decayFunction);
            .setOffset("1km")
            .setDecay(0.5)
        assertThat(result, instanceOf(LinearDecayFunctionBuilder.class));
        DecayPlacement decayPlacement = DecayPlacement.newBuilder().setNumericDecayPlacement(numericPlacement).build();
        DecayFunction decayFunction = DecayFunction.newBuilder().putPlacement("geo_field", decayPlacement).build();
        FunctionScoreContainer container = FunctionScoreContainer.newBuilder().setLinear(decayFunction).setWeight(1.0f).build();
        assertThat(result, instanceOf(LinearDecayFunctionBuilder.class));
            .build();
        assertThat(exception.getMessage(), containsString("DecayFunction must have at least one placement"));
        DecayPlacement decayPlacement = DecayPlacement.newBuilder().setNumericDecayPlacement(numericPlacement).build();
            IllegalArgumentException.class,
        assertEquals(org.opensearch.search.MultiValueMode.AVG, linearFunction.getMultiValueMode());
            .setOffset("5d")
/*
        assertEquals("distance", linearFunction.getFieldName());
            .build();
        NumericDecayPlacement numericPlacement = NumericDecayPlacement.newBuilder().setOrigin(100.0).setScale(50.0).build();
            .setMultiValueMode(org.opensearch.protobufs.MultiValueMode.MULTI_VALUE_MODE_UNSPECIFIED)
            .putPlacement("price", decayPlacement)
