            builder = new LinearDecayFunctionBuilder(
                numericPlacement.hasOffset() ? numericPlacement.getOffset() : null
        return builder;
     */  
        LinearDecayFunctionBuilder builder;  
     * Similar to {@link org.opensearch.index.query.functionscore.DecayFunctionParser},
     * @throws IllegalArgumentException if the decayFunction is null or doesn't contain placements
     * Parses a numeric decay placement and creates a LinearDecayFunctionBuilder.  
                origin,  
                numericPlacement.getOrigin(),
     * @param geoPlacement the protobuf geo decay placement containing origin (lat/lon), scale, offset, and decay  
     * @param fieldName the field name to apply linear decay
        }
                datePlacement.getScale(),
                geoPlacement.getDecay()
    private static LinearDecayFunctionBuilder parseNumericLinearDecay(String fieldName, NumericDecayPlacement numericPlacement) {
                numericPlacement.getOrigin(),  
            builder = new LinearDecayFunctionBuilder(
                geoPlacement.getScale(),
                fieldName,
            builder = new LinearDecayFunctionBuilder(
 */
 * compatible open source license.
                numericPlacement.getScale(),
            );  
        return builder;  
import org.opensearch.protobufs.DateDecayPlacement;  
import org.opensearch.protobufs.GeoDecayPlacement;  
    }
    }  
     * @param fieldName the field name to apply linear decay
        } else {  
     * @return the corresponding OpenSearch LinearDecayFunctionBuilder  
                fieldName,  
import org.opensearch.protobufs.MultiValueMode;
import org.opensearch.protobufs.NumericDecayPlacement;
     *  
import java.util.Map;
                geoPoint,
                geoPlacement.hasOffset() ? geoPlacement.getOffset() : null
            builder = new LinearDecayFunctionBuilder(
     * Converts a Protocol Buffer DecayFunction to an OpenSearch ScoreFunctionBuilder.
        }
import org.opensearch.protobufs.DecayFunction;
     * Similar to {@link org.opensearch.index.query.functionscore.DecayFunctionParser},
import org.opensearch.index.query.functionscore.ScoreFunctionBuilder;
            builder = parseDateLinearDecay(fieldName, decayPlacement.getDateDecayPlacement());
            throw new IllegalArgumentException("DecayFunction must have at least one placement");  
     * Parses a geo decay placement and creates a LinearDecayFunctionBuilder.
        LinearDecayFunctionBuilder builder;  
                numericPlacement.getScale(),
        String fieldName = entry.getKey();
     * @param decayFunction the Protocol Buffer DecayFunction  
            throw new IllegalArgumentException("Unsupported decay placement type");  
        return builder;  
                datePlacement.hasOffset() ? datePlacement.getOffset() : null
        }
 * this file be licensed under the Apache-2.0 license or a
    private static LinearDecayFunctionBuilder parseGeoLinearDecay(String fieldName, GeoDecayPlacement geoPlacement) {  
    }
     * Parses a date decay placement and creates a LinearDecayFunctionBuilder.
                datePlacement.hasOffset() ? datePlacement.getOffset() : null,  
     *
                datePlacement.getDecay()
            builder.setMultiValueMode(DecayFunctionProtoUtils.parseMultiValueMode(decayFunction.getMultiValueMode()));
            );
 * SPDX-License-Identifier: Apache-2.0
 *
     * Similar to {@link org.opensearch.index.query.functionscore.DecayFunctionParser},
}
        } else if (decayPlacement.hasDateDecayPlacement()) {  
 */  
        if (geoPlacement.hasDecay()) {
        if (datePlacement.hasDecay()) {
    private static LinearDecayFunctionBuilder parseDateLinearDecay(String fieldName, DateDecayPlacement datePlacement) {  
     * @return the corresponding OpenSearch LinearDecayFunctionBuilder
        } else {  
        } else if (decayPlacement.hasGeoDecayPlacement()) {
    /**  
import org.opensearch.protobufs.DecayPlacement;
    /**  
            builder = parseGeoLinearDecay(fieldName, decayPlacement.getGeoDecayPlacement());
     * this method constructs a decay function for numeric field values.
                geoPoint,  
                fieldName,  
    /**
                origin,
     */
     * @return the corresponding OpenSearch ScoreFunctionBuilder
     */
            );  
     * @return the corresponding OpenSearch LinearDecayFunctionBuilder
            builder = new LinearDecayFunctionBuilder(
            );
/*  
        Object origin = datePlacement.hasOrigin() ? datePlacement.getOrigin() : null;
     * this method constructs a decay function for geographic field values.  
            builder = new LinearDecayFunctionBuilder(
    }
        }  
            );  
    /**  
     *
        }
 * This utility handles the transformation of Protocol Buffer DecayFunction objects  
                fieldName,
     * @param fieldName the field name to apply linear decay
        LinearDecayFunctionBuilder builder;  
        if (decayFunction == null || decayFunction.getPlacementCount() == 0) {
            builder = parseNumericLinearDecay(fieldName, decayPlacement.getNumericDecayPlacement());  
        LinearDecayFunctionBuilder builder;
package org.opensearch.transport.grpc.proto.request.search.query.functionscore;
class LinearDecayFunctionProtoUtils {  
                numericPlacement.getDecay()
        // Set multi_value_mode if present  
     * @param numericPlacement the protobuf numeric decay placement containing origin, scale, offset, and decay
        GeoPoint geoPoint = GeoPointProtoUtils.parseGeoPoint(geoPlacement.getOrigin());
 * into OpenSearch LinearDecayFunctionBuilder instances.
                geoPlacement.hasOffset() ? geoPlacement.getOffset() : null,  
import org.opensearch.index.query.functionscore.LinearDecayFunctionBuilder;
        }
    }
                numericPlacement.hasOffset() ? numericPlacement.getOffset() : null,  
 * The OpenSearch Contributors require contributions made to  
    static ScoreFunctionBuilder<?> fromProto(DecayFunction decayFunction) {
     * Similar to {@link org.opensearch.index.query.functionscore.DecayFunctionParser#fromXContent(org.opensearch.core.xcontent.XContentParser)},
     * this method constructs a decay function for date field values.  
     * this method parses the Protocol Buffer representation and creates a properly configured  
     * @param datePlacement the protobuf date decay placement containing origin (date), scale, offset, and decay  
 * Utility class for converting Protocol Buffer DecayFunction to OpenSearch LinearDecayFunctionBuilder.
        } else {
        Map.Entry<String, DecayPlacement> entry = decayFunction.getPlacementMap().entrySet().iterator().next();  
    private LinearDecayFunctionProtoUtils() {
                geoPlacement.getScale(),
        return builder;  
        if (decayFunction.hasMultiValueMode() && decayFunction.getMultiValueMode() != MultiValueMode.MULTI_VALUE_MODE_UNSPECIFIED) {
        } else {  
        if (numericPlacement.hasDecay()) {
     */
        DecayPlacement decayPlacement = entry.getValue();
                datePlacement.getScale(),
     * LinearDecayFunctionBuilder with decay placement parameters (numeric, geo, or date).
            );
                fieldName,
                fieldName,  
/**
import org.opensearch.transport.grpc.proto.request.common.GeoPointProtoUtils;  
     *
        if (decayPlacement.hasNumericDecayPlacement()) {
        // Utility class, no instances  
import org.opensearch.common.geo.GeoPoint;  
