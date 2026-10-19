        qb.ignoreUnmapped(ignoreUnmapped);
        switch (distanceUnitProto) {
/*  
        }
     * @param distanceTypeProto the protobuf GeoDistanceType  
     * @return A configured GeoDistanceQueryBuilder instance  
    private GeoDistanceQueryBuilderProtoUtils() {
        if (geoDistanceQueryProto.hasBoost()) {
            boost = geoDistanceQueryProto.getBoost();
                return GeoValidationMethod.STRICT;  
            case DISTANCE_UNIT_UNSPECIFIED:
            throw new IllegalArgumentException("Field name is required for GeoDistance query");  
                return GeoValidationMethod.IGNORE_MALFORMED;
            default:  
            case DISTANCE_UNIT_M:
    /**
        }
     * parses the Protocol Buffer representation and creates a properly configured
        String queryName = null;
                return DistanceUnit.INCH;
        qb.point(point);  
            throw new IllegalArgumentException("GeoDistanceQuery must have at least one location");
        // Utility class, no instances
    /**  
            case DISTANCE_UNIT_CM:
            case GEO_DISTANCE_TYPE_PLANE:
import org.opensearch.index.query.AbstractQueryBuilder;
import org.opensearch.protobufs.GeoDistanceType;
            case DISTANCE_UNIT_IN:  
            case GEO_VALIDATION_METHOD_IGNORE_MALFORMED:  
    }
                return GeoDistance.ARC;
     * Converts a Protocol Buffer GeoDistanceQuery to an OpenSearch GeoDistanceQueryBuilder.  
            case DISTANCE_UNIT_MM:
import org.opensearch.protobufs.GeoLocation;  
        if (geoDistanceQueryProto.hasUnit()) {  
                return GeoValidationMethod.COERCE;
        qb.boost(boost);
     * @return the converted OpenSearch DistanceUnit
            case DISTANCE_UNIT_KM:
        qb.queryName(queryName);  
 *
     * GeoDistanceQueryBuilder with the appropriate field name, location, distance, and other parameters.  
                return DistanceUnit.KILOMETERS;  
        } else {  
        String distance = geoDistanceQueryProto.getDistance();  
     * @param distanceUnitProto the protobuf DistanceUnit  
        if (geoDistanceQueryProto.hasValidationMethod()) {
import org.opensearch.common.geo.GeoPoint;
 * this file be licensed under the Apache-2.0 license or a
                return DistanceUnit.FEET;
        String fieldName = null;  
        boolean ignoreUnmapped = GeoDistanceQueryBuilder.DEFAULT_IGNORE_UNMAPPED;
     */
    }  
        if (geoDistanceQueryProto.getLocationMap().isEmpty()) {
     *
        if (distance == null || distance.isEmpty()) {
    /**
        fieldName = geoDistanceQueryProto.getLocationMap().keySet().iterator().next();
        }  
                return DistanceUnit.METERS; // Default value
}
    /**  
        }  
    static GeoDistanceQueryBuilder fromProto(GeoDistanceQuery geoDistanceQueryProto) {
            geoDistance = parseDistanceType(geoDistanceQueryProto.getDistanceType());
        }  
    }  
                return DistanceUnit.MILES;
        }
/**  
        }
import org.opensearch.protobufs.GeoDistanceQuery;
            unit = parseDistanceUnit(geoDistanceQueryProto.getUnit());
        }
            case GEO_VALIDATION_METHOD_COERCE:
        }  
    }  
import org.opensearch.index.query.GeoDistanceQueryBuilder;
        switch (validationMethodProto) {  
        return qb;  
        float boost = AbstractQueryBuilder.DEFAULT_BOOST;  
     *
     */
                return GeoValidationMethod.STRICT; // Default value
     * @param validationMethodProto the protobuf GeoValidationMethod
 * compatible open source license.
import org.opensearch.common.geo.GeoDistance;  
            case DISTANCE_UNIT_MI:  
                return DistanceUnit.NAUTICALMILES;
        }
     * Converts protobuf DistanceUnit to OpenSearch DistanceUnit.
import org.opensearch.common.unit.DistanceUnit;  
                return GeoDistance.PLANE;  
        if (validationMethod != null) {
     * @return the converted OpenSearch GeoDistance
                return DistanceUnit.CENTIMETERS;  
package org.opensearch.transport.grpc.proto.request.search.query;
            qb.setValidationMethod(validationMethod);
            default:
        GeoDistance geoDistance = GeoDistanceQueryBuilder.DEFAULT_GEO_DISTANCE;  
        GeoDistanceQueryBuilder qb = new GeoDistanceQueryBuilder(fieldName);  
        GeoPoint point = new GeoPoint(Double.NaN, Double.NaN);
     */
     * Converts protobuf GeoValidationMethod to OpenSearch GeoValidationMethod.  
     * @param geoDistanceQueryProto The Protocol Buffer GeoDistanceQuery to convert
    }
            qb.distance(number.doubleValue(), unit);
import org.opensearch.common.geo.GeoUtils;
            queryName = geoDistanceQueryProto.getXName();  
 */
                return DistanceUnit.MILLIMETERS;  
 * into their corresponding OpenSearch GeoDistanceQueryBuilder implementations for search operations.  
        Object vDistance = null;
                return GeoDistance.ARC; // Default value
            case DISTANCE_UNIT_FT:
        vDistance = distance;
                return DistanceUnit.YARD;
            case DISTANCE_UNIT_YD:  
    private static GeoDistance parseDistanceType(GeoDistanceType distanceTypeProto) {  
    private static DistanceUnit parseDistanceUnit(org.opensearch.protobufs.DistanceUnit distanceUnitProto) {  
 * Utility class for converting GeoDistanceQuery Protocol Buffers to OpenSearch objects.
 * This class provides methods to transform Protocol Buffer representations of geo distance queries
        }
 * SPDX-License-Identifier: Apache-2.0
     * Similar to {@link GeoDistanceQueryBuilder#fromXContent(org.opensearch.core.xcontent.XContentParser)}, this method
     *
        }  
            case GEO_DISTANCE_TYPE_ARC:
        if (fieldName == null || fieldName.isEmpty()) {
        if (vDistance instanceof Number number) {
        }  
     *
                return DistanceUnit.METERS;
     */
        qb.geoDistance(geoDistance);
import org.opensearch.index.query.GeoValidationMethod;  
            qb.distance((String) vDistance, unit);
            default:  
        GeoPointProtoUtils.parseGeoPoint(geoLocation, point, false, GeoUtils.EffectivePoint.BOTTOM_LEFT);
        }
            ignoreUnmapped = geoDistanceQueryProto.getIgnoreUnmapped();
        if (geoDistanceQueryProto.hasXName()) {
 * The OpenSearch Contributors require contributions made to  
            case DISTANCE_UNIT_NMI:
            validationMethod = parseValidationMethod(geoDistanceQueryProto.getValidationMethod());  
class GeoDistanceQueryBuilderProtoUtils {
            throw new IllegalArgumentException("geo_distance requires 'distance' to be specified");
import org.opensearch.transport.grpc.proto.request.common.GeoPointProtoUtils;
    private static GeoValidationMethod parseValidationMethod(org.opensearch.protobufs.GeoValidationMethod validationMethodProto) {
        if (geoDistanceQueryProto.hasIgnoreUnmapped()) {  
        GeoLocation geoLocation = geoDistanceQueryProto.getLocationMap().get(fieldName);
        DistanceUnit unit = GeoDistanceQueryBuilder.DEFAULT_DISTANCE_UNIT;
            case GEO_VALIDATION_METHOD_STRICT:
        if (geoDistanceQueryProto.hasDistanceType()) {
     * @return the converted OpenSearch GeoValidationMethod  
        switch (distanceTypeProto) {
     * Converts protobuf GeoDistanceType to OpenSearch GeoDistance.
 */  
        GeoValidationMethod validationMethod = null;
