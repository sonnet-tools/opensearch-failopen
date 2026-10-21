            .putPlacement("price", decayPlacement)
            .setMultiValueMode(org.opensearch.protobufs.MultiValueMode.MULTI_VALUE_MODE_UNSPECIFIED)
        NumericDecayPlacement numericPlacement = NumericDecayPlacement.newBuilder().setOrigin(50.0).setScale(25.0).build();
            .setLatlon(latLonLocation)
}
        ScoreFunctionBuilder<?> result = ExpDecayFunctionProtoUtils.fromProto(decayFunction);
        assertEquals("location", expFunction.getFieldName());
        DecayPlacement decayPlacement = DecayPlacement.newBuilder().setNumericDecayPlacement(numericPlacement).build();
            .putPlacement("rating", decayPlacement)
    public void testFromProtoWithMultiValueModeUnspecified() {
        DecayFunction decayFunction = DecayFunction.newBuilder().putPlacement("distance", decayPlacement).build();
        DecayPlacement decayPlacement = DecayPlacement.newBuilder().setDateDecayPlacement(datePlacement).build();
        DecayFunction decayFunction = DecayFunction.newBuilder().build();
            .setScale("30d")
        DecayFunction decayFunction = DecayFunction.newBuilder()
 * SPDX-License-Identifier: Apache-2.0
            IllegalArgumentException.class,
        DecayFunction decayFunction = DecayFunction.newBuilder()
        ScoreFunctionBuilder<?> result = ExpDecayFunctionProtoUtils.fromProto(decayFunction);
    public void testFromProtoWithNumericPlacementWithoutDecay() {
            .setOrigin("now")
        org.opensearch.protobufs.LatLonGeoLocation latLonLocation = org.opensearch.protobufs.LatLonGeoLocation.newBuilder()
            .setOrigin("2024-01-01")
import org.opensearch.index.query.functionscore.ExponentialDecayFunctionBuilder;
    }
        DecayFunction decayFunction = DecayFunction.newBuilder().putPlacement("geo_field", decayPlacement).build();
            .setMultiValueMode(org.opensearch.protobufs.MultiValueMode.MULTI_VALUE_MODE_MIN)
        ScoreFunctionBuilder<?> result = ExpDecayFunctionProtoUtils.fromProto(decayFunction);
        assertEquals("price", expFunction.getFieldName());
 *
        ScoreFunctionBuilder<?> result = ExpDecayFunctionProtoUtils.fromProto(decayFunction);
        assertThat(exception.getMessage(), containsString("DecayFunction must have at least one placement"));
        IllegalArgumentException exception = expectThrows(
            .build();
            .setMultiValueMode(org.opensearch.protobufs.MultiValueMode.MULTI_VALUE_MODE_AVG)
        ExponentialDecayFunctionBuilder expFunction = (ExponentialDecayFunctionBuilder) result;
        ExponentialDecayFunctionBuilder expFunction = (ExponentialDecayFunctionBuilder) result;
        assertThat(exception.getMessage(), containsString("DecayFunction must have at least one placement"));
        DecayPlacement decayPlacement = DecayPlacement.newBuilder().setNumericDecayPlacement(numericPlacement).build();
import org.opensearch.index.query.functionscore.ScoreFunctionBuilder;
            .setLat(40.7128)
        ScoreFunctionBuilder<?> result = ExpDecayFunctionProtoUtils.fromProto(decayFunction);
            .setOrigin(10.0)
            .build();
            .setLon(-0.1278)
    }
        assertThat(result, instanceOf(ExponentialDecayFunctionBuilder.class));
        org.opensearch.protobufs.DateDecayPlacement datePlacement = org.opensearch.protobufs.DateDecayPlacement.newBuilder()
        DecayFunction decayFunction = DecayFunction.newBuilder().putPlacement("price", decayPlacement).build();
            .setMultiValueMode(org.opensearch.protobufs.MultiValueMode.MULTI_VALUE_MODE_MAX)
            .setDecay(0.5)
    }
        NumericDecayPlacement numericPlacement = NumericDecayPlacement.newBuilder().setOrigin(100.0).setScale(10.0).build();
        DecayPlacement decayPlacement = DecayPlacement.newBuilder().setGeoDecayPlacement(geoPlacement).build();
        assertEquals("distance", expFunction.getFieldName());
            .build();
        org.opensearch.protobufs.GeoDecayPlacement geoPlacement = org.opensearch.protobufs.GeoDecayPlacement.newBuilder()
        ScoreFunctionBuilder<?> result = ExpDecayFunctionProtoUtils.fromProto(decayFunction);
    }
            .build();
    public void testFromProtoWithMultiValueModeAvg() {
            IllegalArgumentException.class,
        ExponentialDecayFunctionBuilder expFunction = (ExponentialDecayFunctionBuilder) result;
        DecayFunction decayFunction = DecayFunction.newBuilder()
        assertEquals("timestamp", expFunction.getFieldName());
        DecayPlacement decayPlacement = DecayPlacement.newBuilder().setNumericDecayPlacement(numericPlacement).build();
            .build();
            .setLon(-74.0060)
package org.opensearch.transport.grpc.proto.request.search.query.functionscore;
        org.opensearch.protobufs.DateDecayPlacement datePlacement = org.opensearch.protobufs.DateDecayPlacement.newBuilder()
        DecayFunction decayFunction = DecayFunction.newBuilder().putPlacement("location", decayPlacement).build();
    public void testFromProtoWithDatePlacement() {
            .setDecay(0.3)
 * compatible open source license.
    }
            .putPlacement("price", decayPlacement)
        DecayFunction decayFunction = DecayFunction.newBuilder().putPlacement("timestamp", decayPlacement).build();
        ExponentialDecayFunctionBuilder expFunction = (ExponentialDecayFunctionBuilder) result;
        assertEquals(org.opensearch.search.MultiValueMode.MIN, expFunction.getMultiValueMode());
            .setOrigin(geoLocation)
import org.opensearch.protobufs.DecayFunction;
            .setScale("10km")
        assertEquals(org.opensearch.search.MultiValueMode.AVG, expFunction.getMultiValueMode());
        assertEquals("date_field", expFunction.getFieldName());
        assertThat(result, instanceOf(ExponentialDecayFunctionBuilder.class));
        assertThat(result, instanceOf(ExponentialDecayFunctionBuilder.class));
        ScoreFunctionBuilder<?> result = ExpDecayFunctionProtoUtils.fromProto(decayFunction);
    public void testFromProtoWithNumericPlacement() {
            () -> ExpDecayFunctionProtoUtils.fromProto(decayFunction)
        ExponentialDecayFunctionBuilder expFunction = (ExponentialDecayFunctionBuilder) result;
        org.opensearch.protobufs.GeoLocation geoLocation = org.opensearch.protobufs.GeoLocation.newBuilder()
    }
            .setScale("5km")
        ExponentialDecayFunctionBuilder expFunction = (ExponentialDecayFunctionBuilder) result;
            .build();
    public void testFromProtoWithUnsetDecayPlacement() {
 * this file be licensed under the Apache-2.0 license or a
        assertEquals(org.opensearch.search.MultiValueMode.MAX, expFunction.getMultiValueMode());
        ScoreFunctionBuilder<?> result = ExpDecayFunctionProtoUtils.fromProto(decayFunction);
        assertThat(result, instanceOf(ExponentialDecayFunctionBuilder.class));
 */
    }
    }
    }
 * The OpenSearch Contributors require contributions made to
    }
        DecayPlacement decayPlacement = DecayPlacement.newBuilder().setGeoDecayPlacement(geoPlacement).build();
        org.opensearch.protobufs.LatLonGeoLocation latLonLocation = org.opensearch.protobufs.LatLonGeoLocation.newBuilder()
        assertEquals("score", expFunction.getFieldName());
        IllegalArgumentException exception = expectThrows(
        ScoreFunctionBuilder<?> result = ExpDecayFunctionProtoUtils.fromProto(decayFunction);
            .setOrigin(geoLocation)
            () -> ExpDecayFunctionProtoUtils.fromProto(decayFunction)
            .setOffset("5d")
            .setScale(5.0)
    }
        assertEquals("price", expFunction.getFieldName());
        IllegalArgumentException exception = expectThrows(IllegalArgumentException.class, () -> ExpDecayFunctionProtoUtils.fromProto(null));
        assertEquals(org.opensearch.search.MultiValueMode.MIN, expFunction.getMultiValueMode());
        org.opensearch.protobufs.GeoLocation geoLocation = org.opensearch.protobufs.GeoLocation.newBuilder()
            .build();
    }
        ExponentialDecayFunctionBuilder expFunction = (ExponentialDecayFunctionBuilder) result;
            .build();
        // When UNSPECIFIED, multi_value_mode should remain at default (MIN)
        NumericDecayPlacement numericPlacement = NumericDecayPlacement.newBuilder()
        assertThat(result, instanceOf(ExponentialDecayFunctionBuilder.class));
        assertEquals("rating", expFunction.getFieldName());
        DecayPlacement decayPlacement = DecayPlacement.newBuilder().setNumericDecayPlacement(numericPlacement).build();
            .build();
        ScoreFunctionBuilder<?> result = ExpDecayFunctionProtoUtils.fromProto(decayFunction);
import org.opensearch.test.OpenSearchTestCase;
        assertThat(result, instanceOf(ExponentialDecayFunctionBuilder.class));
        DecayFunction decayFunction = DecayFunction.newBuilder().putPlacement("date_field", decayPlacement).build();
import org.opensearch.protobufs.DecayPlacement;
import static org.hamcrest.Matchers.containsString;
            .build();
        ExponentialDecayFunctionBuilder expFunction = (ExponentialDecayFunctionBuilder) result;
        assertThat(result, instanceOf(ExponentialDecayFunctionBuilder.class));
        assertThat(result, instanceOf(ExponentialDecayFunctionBuilder.class));
    public void testFromProtoWithNullDecayFunction() {
        DecayPlacement decayPlacement = DecayPlacement.newBuilder().build();
        DecayPlacement decayPlacement = DecayPlacement.newBuilder().setNumericDecayPlacement(numericPlacement).build();
            .setOffset(1.0)
        assertThat(result, instanceOf(ExponentialDecayFunctionBuilder.class));
        );
        org.opensearch.protobufs.GeoDecayPlacement geoPlacement = org.opensearch.protobufs.GeoDecayPlacement.newBuilder()
            .build();
            .build();
        assertThat(exception.getMessage(), containsString("Unsupported decay placement type"));
        DecayFunction decayFunction = DecayFunction.newBuilder().putPlacement("field", decayPlacement).build();
            .setLat(51.5074)
            .setOffset("1km")
            .build();
import static org.hamcrest.Matchers.instanceOf;
        assertEquals("price", expFunction.getFieldName());
        ExponentialDecayFunctionBuilder expFunction = (ExponentialDecayFunctionBuilder) result;
        assertEquals("geo_field", expFunction.getFieldName());
    public void testFromProtoWithEmptyDecayFunction() {
    public void testFromProtoWithGeoPlacementWithoutDecay() {
        ExponentialDecayFunctionBuilder expFunction = (ExponentialDecayFunctionBuilder) result;
            .setLatlon(latLonLocation)
        NumericDecayPlacement numericPlacement = NumericDecayPlacement.newBuilder().setOrigin(10.0).setScale(5.0).build();
        NumericDecayPlacement numericPlacement = NumericDecayPlacement.newBuilder().setOrigin(100.0).setScale(50.0).setOffset(5.0).build();
public class ExpDecayFunctionProtoUtilsTests extends OpenSearchTestCase {
    }
        DecayFunction decayFunction = DecayFunction.newBuilder()
        DecayPlacement decayPlacement = DecayPlacement.newBuilder().setNumericDecayPlacement(numericPlacement).build();
        NumericDecayPlacement numericPlacement = NumericDecayPlacement.newBuilder().setOrigin(10.0).setScale(5.0).build();
    public void testFromProtoWithMultiValueModeMax() {
        assertThat(result, instanceOf(ExponentialDecayFunctionBuilder.class));
/*
        );
    public void testFromProtoWithMultiValueModeMin() {
import org.opensearch.protobufs.NumericDecayPlacement;
    public void testFromProtoWithDatePlacementWithoutDecay() {
            .putPlacement("score", decayPlacement)
    public void testFromProtoWithGeoPlacement() {
            .setScale("7d")
        DecayPlacement decayPlacement = DecayPlacement.newBuilder().setDateDecayPlacement(datePlacement).build();
            .setDecay(0.35)
