     * Similar to {@link org.opensearch.index.query.functionscore.DecayFunctionParser#fromXContent(org.opensearch.core.xcontent.XContentParser)},
        ExponentialDecayFunctionBuilder builder;  
 * SPDX-License-Identifier: Apache-2.0
    /**
import org.opensearch.protobufs.DecayPlacement;
            throw new IllegalArgumentException("Unsupported decay placement type");  
        Map.Entry<String, DecayPlacement> entry = decayFunction.getPlacementMap().entrySet().iterator().next();  
import org.opensearch.index.query.functionscore.ScoreFunctionBuilder;
            );
        DecayPlacement decayPlacement = entry.getValue();
import org.opensearch.index.query.functionscore.ExponentialDecayFunctionBuilder;
        String fieldName = entry.getKey();
package org.opensearch.transport.grpc.proto.request.search.query.functionscore;
 * This utility handles the transformation of Protocol Buffer DecayFunction objects  
                numericPlacement.getDecay()
 * into OpenSearch ExponentialDecayFunctionBuilder instances.
            builder = new ExponentialDecayFunctionBuilder(
    private static ExponentialDecayFunctionBuilder parseGeoExpDecay(String fieldName, GeoDecayPlacement geoPlacement) {  
    }
            builder = parseGeoExpDecay(fieldName, decayPlacement.getGeoDecayPlacement());
import org.opensearch.protobufs.DecayFunction;
import org.opensearch.protobufs.NumericDecayPlacement;
        ExponentialDecayFunctionBuilder builder;  
}
    /**  
    private static ExponentialDecayFunctionBuilder parseDateExpDecay(String fieldName, DateDecayPlacement datePlacement) {  
import org.opensearch.common.geo.GeoPoint;  
     * Parses a date decay placement for exponential decay.
        return builder;
 * The OpenSearch Contributors require contributions made to  
    /**  
                numericPlacement.getOrigin(),  
        Object origin = datePlacement.hasOrigin() ? datePlacement.getOrigin() : null;
                fieldName,  
        }
import org.opensearch.protobufs.MultiValueMode;
    static ScoreFunctionBuilder<?> fromProto(DecayFunction decayFunction) {
                datePlacement.getScale(),
        }
        }
        return builder;  
                origin,
            );  
    }
                geoPlacement.hasOffset() ? geoPlacement.getOffset() : null
                geoPlacement.hasOffset() ? geoPlacement.getOffset() : null,  
        GeoPoint geoPoint = GeoPointProtoUtils.parseGeoPoint(geoPlacement.getOrigin());
/**
                fieldName,
                numericPlacement.hasOffset() ? numericPlacement.getOffset() : null
            builder = new ExponentialDecayFunctionBuilder(
    /**  
                geoPlacement.getDecay()
 */  
        if (numericPlacement.hasDecay()) {
import org.opensearch.transport.grpc.proto.request.common.GeoPointProtoUtils;  
import org.opensearch.protobufs.GeoDecayPlacement;  
            builder.setMultiValueMode(DecayFunctionProtoUtils.parseMultiValueMode(decayFunction.getMultiValueMode()));
                geoPoint,  
                fieldName,
        ExponentialDecayFunctionBuilder builder;
            );  
            );
/*  
                datePlacement.getDecay()
                numericPlacement.getScale(),
                numericPlacement.hasOffset() ? numericPlacement.getOffset() : null,  
class ExpDecayFunctionProtoUtils {  
        } else {  
     * Parses a geo decay placement for exponential decay.
 * this file be licensed under the Apache-2.0 license or a
        }  
        return builder;  
            builder = new ExponentialDecayFunctionBuilder(
     * @throws IllegalArgumentException if the decayFunction is null or doesn't contain placements
import org.opensearch.protobufs.DateDecayPlacement;  
            builder = new ExponentialDecayFunctionBuilder(
     */
                datePlacement.hasOffset() ? datePlacement.getOffset() : null
        } else if (decayPlacement.hasDateDecayPlacement()) {  
        // Utility class, no instances  
        if (datePlacement.hasDecay()) {
                numericPlacement.getScale(),
import java.util.Map;
    }
                fieldName,
        } else if (decayPlacement.hasGeoDecayPlacement()) {
        // Set multi_value_mode if present  
            builder = new ExponentialDecayFunctionBuilder(
                datePlacement.hasOffset() ? datePlacement.getOffset() : null,  
        if (decayFunction == null || decayFunction.getPlacementCount() == 0) {
            builder = parseDateExpDecay(fieldName, decayPlacement.getDateDecayPlacement());
                origin,  
     * ExponentialDecayFunctionBuilder with decay placement parameters (numeric, geo, or date).
     */
    private ExpDecayFunctionProtoUtils() {
        if (geoPlacement.hasDecay()) {
                geoPlacement.getScale(),
     *
        } else {  
            );
                numericPlacement.getOrigin(),
        return builder;  
     * Converts a Protocol Buffer DecayFunction to an OpenSearch ScoreFunctionBuilder.
 * Utility class for converting Protocol Buffer DecayFunction to OpenSearch ExponentialDecayFunctionBuilder.
    private static ExponentialDecayFunctionBuilder parseNumericExpDecay(String fieldName, NumericDecayPlacement numericPlacement) {
     * this method parses the Protocol Buffer representation and creates a properly configured  
     * Parses a numeric decay placement for exponential decay.  
        } else {
        ExponentialDecayFunctionBuilder builder;  
            throw new IllegalArgumentException("DecayFunction must have at least one placement");  
 * compatible open source license.
            );  
     * @return the corresponding OpenSearch ScoreFunctionBuilder
                geoPoint,
                datePlacement.getScale(),
    }  
                geoPlacement.getScale(),
     * @param decayFunction the Protocol Buffer DecayFunction  
        if (decayFunction.hasMultiValueMode() && decayFunction.getMultiValueMode() != MultiValueMode.MULTI_VALUE_MODE_UNSPECIFIED) {
            builder = new ExponentialDecayFunctionBuilder(
     */  
        if (decayPlacement.hasNumericDecayPlacement()) {
     */
                fieldName,  
        }
    }
 *
        }
                fieldName,  
            builder = parseNumericExpDecay(fieldName, decayPlacement.getNumericDecayPlacement());  
        } else {  
 */
