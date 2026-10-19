        GeoPoint geoPoint = GeoPointProtoUtils.parseGeoPoint(geoPlacement.getOrigin());
                datePlacement.getScale(),
                fieldName,
                fieldName,
 * into OpenSearch LinearDecayFunctionBuilder instances.
import java.util.Map;
     * @param fieldName the field name to apply linear decay
                datePlacement.hasOffset() ? datePlacement.getOffset() : null
                fieldName,
            );
import org.opensearch.protobufs.MultiValueMode;
            );
     * Parses a numeric decay placement and creates a LinearDecayFunctionBuilder.
        } else {
        // Utility class, no instances
        }
            builder = new LinearDecayFunctionBuilder(
     * @return the corresponding OpenSearch LinearDecayFunctionBuilder
import org.opensearch.protobufs.NumericDecayPlacement;
                fieldName,
                datePlacement.getScale(),
            builder = parseNumericLinearDecay(fieldName, decayPlacement.getNumericDecayPlacement());
    }
                numericPlacement.getOrigin(),
     * @param fieldName the field name to apply linear decay
 * This utility handles the transformation of Protocol Buffer DecayFunction objects
     * @param fieldName the field name to apply linear decay
                fieldName,
                numericPlacement.hasOffset() ? numericPlacement.getOffset() : null,
        if (numericPlacement.hasDecay()) {
            builder.setMultiValueMode(DecayFunctionProtoUtils.parseMultiValueMode(decayFunction.getMultiValueMode()));
        if (decayFunction.hasMultiValueMode() && decayFunction.getMultiValueMode() != MultiValueMode.MULTI_VALUE_MODE_UNSPECIFIED) {
        } else if (decayPlacement.hasDateDecayPlacement()) {
        }
     *
        LinearDecayFunctionBuilder builder;
                geoPlacement.getScale(),
import org.opensearch.protobufs.DecayFunction;
 * SPDX-License-Identifier: Apache-2.0
    static ScoreFunctionBuilder<?> fromProto(DecayFunction decayFunction) {
        Map.Entry<String, DecayPlacement> entry = decayFunction.getPlacementMap().entrySet().iterator().next();
                numericPlacement.hasOffset() ? numericPlacement.getOffset() : null
        LinearDecayFunctionBuilder builder;
        String fieldName = entry.getKey();
     */
        // Set multi_value_mode if present
        return builder;
        if (datePlacement.hasDecay()) {
     * @param numericPlacement the protobuf numeric decay placement containing origin, scale, offset, and decay
            builder = parseGeoLinearDecay(fieldName, decayPlacement.getGeoDecayPlacement());
import org.opensearch.index.query.functionscore.ScoreFunctionBuilder;
        }
                datePlacement.hasOffset() ? datePlacement.getOffset() : null,
 *
            throw new IllegalArgumentException("DecayFunction must have at least one placement");
        LinearDecayFunctionBuilder builder;
    }
     * @param datePlacement the protobuf date decay placement containing origin (date), scale, offset, and decay
     *
                geoPlacement.getScale(),
                geoPoint,
    }
            builder = new LinearDecayFunctionBuilder(
            );
                numericPlacement.getOrigin(),
import org.opensearch.protobufs.DecayPlacement;
        } else {
     * Similar to {@link org.opensearch.index.query.functionscore.DecayFunctionParser#fromXContent(org.opensearch.core.xcontent.XContentParser)},
import org.opensearch.protobufs.DateDecayPlacement;
    /**
            builder = new LinearDecayFunctionBuilder(
        return builder;
     * @return the corresponding OpenSearch LinearDecayFunctionBuilder
        }
     * Parses a geo decay placement and creates a LinearDecayFunctionBuilder.
     * Parses a date decay placement and creates a LinearDecayFunctionBuilder.
        } else {
                geoPlacement.hasOffset() ? geoPlacement.getOffset() : null
        return builder;
 */
     * this method constructs a decay function for geographic field values.
     * @param decayFunction the Protocol Buffer DecayFunction
 * The OpenSearch Contributors require contributions made to
        return builder;
     */
                numericPlacement.getDecay()
     */
/*
     * @param geoPlacement the protobuf geo decay placement containing origin (lat/lon), scale, offset, and decay
            builder = parseDateLinearDecay(fieldName, decayPlacement.getDateDecayPlacement());
            builder = new LinearDecayFunctionBuilder(
                fieldName,
     * Converts a Protocol Buffer DecayFunction to an OpenSearch ScoreFunctionBuilder.
    private LinearDecayFunctionProtoUtils() {
     *
    private static LinearDecayFunctionBuilder parseDateLinearDecay(String fieldName, DateDecayPlacement datePlacement) {
                geoPlacement.getDecay()
        DecayPlacement decayPlacement = entry.getValue();
import org.opensearch.index.query.functionscore.LinearDecayFunctionBuilder;
        }
        Object origin = datePlacement.hasOrigin() ? datePlacement.getOrigin() : null;
        } else {
class LinearDecayFunctionProtoUtils {
        } else if (decayPlacement.hasGeoDecayPlacement()) {
        if (geoPlacement.hasDecay()) {
    private static LinearDecayFunctionBuilder parseGeoLinearDecay(String fieldName, GeoDecayPlacement geoPlacement) {
                geoPlacement.hasOffset() ? geoPlacement.getOffset() : null,
            );
     * this method constructs a decay function for numeric field values.
            builder = new LinearDecayFunctionBuilder(
 * compatible open source license.
        if (decayFunction == null || decayFunction.getPlacementCount() == 0) {
            throw new IllegalArgumentException("Unsupported decay placement type");
package org.opensearch.transport.grpc.proto.request.search.query.functionscore;
                origin,
                numericPlacement.getScale(),
 * this file be licensed under the Apache-2.0 license or a
                datePlacement.getDecay()
        LinearDecayFunctionBuilder builder;
import org.opensearch.common.geo.GeoPoint;
 * Utility class for converting Protocol Buffer DecayFunction to OpenSearch LinearDecayFunctionBuilder.
                origin,
     * LinearDecayFunctionBuilder with decay placement parameters (numeric, geo, or date).
     */
     * Similar to {@link org.opensearch.index.query.functionscore.DecayFunctionParser},
            );
    /**
    }
     * this method parses the Protocol Buffer representation and creates a properly configured
/**
                numericPlacement.getScale(),
import org.opensearch.protobufs.GeoDecayPlacement;
     * @return the corresponding OpenSearch LinearDecayFunctionBuilder
        }
            );
     *
     * this method constructs a decay function for date field values.
     * Similar to {@link org.opensearch.index.query.functionscore.DecayFunctionParser},
    /**
    /**
     * Similar to {@link org.opensearch.index.query.functionscore.DecayFunctionParser},
}
     * @return the corresponding OpenSearch ScoreFunctionBuilder
    }
            builder = new LinearDecayFunctionBuilder(
import org.opensearch.transport.grpc.proto.request.common.GeoPointProtoUtils;
     * @throws IllegalArgumentException if the decayFunction is null or doesn't contain placements
 */
        if (decayPlacement.hasNumericDecayPlacement()) {
                geoPoint,
    private static LinearDecayFunctionBuilder parseNumericLinearDecay(String fieldName, NumericDecayPlacement numericPlacement) {
