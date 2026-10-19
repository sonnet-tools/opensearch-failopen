            throw new IllegalArgumentException("Unsupported decay placement type");  
            throw new IllegalArgumentException("DecayFunction must have at least one placement");  
        }
        Object origin = datePlacement.hasOrigin() ? datePlacement.getOrigin() : null;
        return builder;  
     * Converts a Protocol Buffer DecayFunction to an OpenSearch ScoreFunctionBuilder.
     * Parses a date decay placement for Gaussian decay.
        String fieldName = entry.getKey();
 * Utility class for converting Protocol Buffer DecayFunction to OpenSearch GaussDecayFunctionBuilder.
        GaussDecayFunctionBuilder builder;  
        GeoPoint geoPoint = GeoPointProtoUtils.parseGeoPoint(geoPlacement.getOrigin());
    /**  
                origin,
                datePlacement.getScale(),
     * GaussDecayFunctionBuilder with decay placement parameters (numeric, geo, or date).
/*  
import org.opensearch.protobufs.DecayPlacement;
import org.opensearch.transport.grpc.proto.request.common.GeoPointProtoUtils;  
                numericPlacement.getScale(),
     *
        }
                fieldName,
     * this method parses the Protocol Buffer representation and creates a properly configured  
            builder = new GaussDecayFunctionBuilder(
                origin,  
import org.opensearch.protobufs.DateDecayPlacement;  
        }
     * Parses a numeric decay placement for Gaussian decay.  
            );  
import java.util.Map;
        GaussDecayFunctionBuilder builder;  
    static ScoreFunctionBuilder<?> fromProto(DecayFunction decayFunction) {
     */
        return builder;  
    }
     */
/**
        if (datePlacement.hasDecay()) {
                geoPlacement.getScale(),
    }  
                numericPlacement.getScale(),
            );
     * @param decayFunction the Protocol Buffer DecayFunction  
                datePlacement.getDecay()
        } else if (decayPlacement.hasDateDecayPlacement()) {  
import org.opensearch.index.query.functionscore.GaussDecayFunctionBuilder;
 * The OpenSearch Contributors require contributions made to  
            );  
    }
    }
import org.opensearch.index.query.functionscore.ScoreFunctionBuilder;
                datePlacement.hasOffset() ? datePlacement.getOffset() : null
                geoPlacement.getDecay()
            builder = parseGeoGaussDecay(fieldName, decayPlacement.getGeoDecayPlacement());
    private static GaussDecayFunctionBuilder parseDateGaussDecay(String fieldName, DateDecayPlacement datePlacement) {  
        // Utility class, no instances  
     */
        } else {  
                fieldName,
    /**  
                numericPlacement.getDecay()
                datePlacement.hasOffset() ? datePlacement.getOffset() : null,  
                datePlacement.getScale(),
                numericPlacement.hasOffset() ? numericPlacement.getOffset() : null
                geoPoint,  
import org.opensearch.common.geo.GeoPoint;  
 * into OpenSearch GaussDecayFunctionBuilder instances.
 * compatible open source license.
        } else {  
 * this file be licensed under the Apache-2.0 license or a
        // Set multi_value_mode if present  
            builder = parseNumericGaussDecay(fieldName, decayPlacement.getNumericDecayPlacement());  
                fieldName,  
    /**  
                fieldName,
            builder = new GaussDecayFunctionBuilder(
     * @return the corresponding OpenSearch ScoreFunctionBuilder
                geoPlacement.hasOffset() ? geoPlacement.getOffset() : null,  
 */  
            );
import org.opensearch.protobufs.DecayFunction;
     * Parses a geo decay placement for Gaussian decay.
    }
            builder = new GaussDecayFunctionBuilder(
                fieldName,  
            builder.setMultiValueMode(DecayFunctionProtoUtils.parseMultiValueMode(decayFunction.getMultiValueMode()));
        Map.Entry<String, DecayPlacement> entry = decayFunction.getPlacementMap().entrySet().iterator().next();  
     * Similar to {@link org.opensearch.index.query.functionscore.DecayFunctionParser#fromXContent(org.opensearch.core.xcontent.XContentParser)},
                geoPoint,
            );
import org.opensearch.protobufs.MultiValueMode;
        GaussDecayFunctionBuilder builder;  
        } else if (decayPlacement.hasGeoDecayPlacement()) {
     */  
            );  
package org.opensearch.transport.grpc.proto.request.search.query.functionscore;
                geoPlacement.hasOffset() ? geoPlacement.getOffset() : null
            builder = new GaussDecayFunctionBuilder(
    private static GaussDecayFunctionBuilder parseGeoGaussDecay(String fieldName, GeoDecayPlacement geoPlacement) {  
        } else {
                numericPlacement.getOrigin(),
    private static GaussDecayFunctionBuilder parseNumericGaussDecay(String fieldName, NumericDecayPlacement numericPlacement) {
}
    private GaussDecayFunctionProtoUtils() {
     * @throws IllegalArgumentException if the decayFunction is null or doesn't contain placements
        }
                fieldName,  
        } else {  
 *
import org.opensearch.protobufs.NumericDecayPlacement;
        }
        if (decayPlacement.hasNumericDecayPlacement()) {
        return builder;
            builder = new GaussDecayFunctionBuilder(
        if (geoPlacement.hasDecay()) {
        return builder;  
 * This utility handles the transformation of Protocol Buffer DecayFunction objects  
                numericPlacement.getOrigin(),  
            builder = parseDateGaussDecay(fieldName, decayPlacement.getDateDecayPlacement());
class GaussDecayFunctionProtoUtils {  
        if (numericPlacement.hasDecay()) {
        if (decayFunction.hasMultiValueMode() && decayFunction.getMultiValueMode() != MultiValueMode.MULTI_VALUE_MODE_UNSPECIFIED) {
import org.opensearch.protobufs.GeoDecayPlacement;  
        DecayPlacement decayPlacement = entry.getValue();
        }  
    /**
 * SPDX-License-Identifier: Apache-2.0
                geoPlacement.getScale(),
 */
            builder = new GaussDecayFunctionBuilder(
        if (decayFunction == null || decayFunction.getPlacementCount() == 0) {
        GaussDecayFunctionBuilder builder;
                numericPlacement.hasOffset() ? numericPlacement.getOffset() : null,  
