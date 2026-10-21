            case DISTANCE_UNIT_M:
 *
     * Converts protobuf GeoDistanceType to OpenSearch GeoDistance.
        }
        }
            case DISTANCE_UNIT_YD:
        return qb;
    }
class GeoDistanceQueryBuilderProtoUtils {
     * @return the converted OpenSearch DistanceUnit
     * @param validationMethodProto the protobuf GeoValidationMethod
            throw new IllegalArgumentException("geo_distance requires 'distance' to be specified");
            case DISTANCE_UNIT_MI:
                return DistanceUnit.METERS; // Default value
     *
        fieldName = geoDistanceQueryProto.getLocationMap().keySet().iterator().next();
    /**
import org.opensearch.index.query.AbstractQueryBuilder;
     * @return the converted OpenSearch GeoDistance
        switch (distanceUnitProto) {
        GeoPointProtoUtils.parseGeoPoint(geoLocation, point, false, GeoUtils.EffectivePoint.BOTTOM_LEFT);
                return GeoDistance.ARC;
            boost = geoDistanceQueryProto.getBoost();
/*
            case GEO_VALIDATION_METHOD_COERCE:
        }
            ignoreUnmapped = geoDistanceQueryProto.getIgnoreUnmapped();
        if (fieldName == null || fieldName.isEmpty()) {
 * SPDX-License-Identifier: Apache-2.0
    private static GeoDistance parseDistanceType(GeoDistanceType distanceTypeProto) {
                return DistanceUnit.FEET;
        qb.boost(boost);
            case GEO_DISTANCE_TYPE_ARC:
 */
        String distance = geoDistanceQueryProto.getDistance();
                return DistanceUnit.YARD;
        if (vDistance instanceof Number number) {
     * Similar to {@link GeoDistanceQueryBuilder#fromXContent(org.opensearch.core.xcontent.XContentParser)}, this method
            validationMethod = parseValidationMethod(geoDistanceQueryProto.getValidationMethod());
        } else {
            case DISTANCE_UNIT_UNSPECIFIED:
                return GeoValidationMethod.STRICT; // Default value
                return DistanceUnit.NAUTICALMILES;
        }
                return DistanceUnit.KILOMETERS;
        }
        }
import org.opensearch.common.geo.GeoUtils;
                return GeoValidationMethod.IGNORE_MALFORMED;
import org.opensearch.common.unit.DistanceUnit;
    }
     *
        }
 * The OpenSearch Contributors require contributions made to
     */
        String queryName = null;
 */
        if (geoDistanceQueryProto.hasXName()) {
                return GeoValidationMethod.STRICT;
        Object vDistance = null;
        }
/**
import org.opensearch.index.query.GeoValidationMethod;
            default:
        GeoDistanceQueryBuilder qb = new GeoDistanceQueryBuilder(fieldName);
import org.opensearch.transport.grpc.proto.request.common.GeoPointProtoUtils;
            throw new IllegalArgumentException("Field name is required for GeoDistance query");
     * Converts protobuf GeoValidationMethod to OpenSearch GeoValidationMethod.
        qb.queryName(queryName);
import org.opensearch.protobufs.GeoDistanceQuery;
package org.opensearch.transport.grpc.proto.request.search.query;
import org.opensearch.index.query.GeoDistanceQueryBuilder;
        DistanceUnit unit = GeoDistanceQueryBuilder.DEFAULT_DISTANCE_UNIT;
                return GeoValidationMethod.COERCE;
        String fieldName = null;
     * @param distanceTypeProto the protobuf GeoDistanceType
    }
     *
     * @param distanceUnitProto the protobuf DistanceUnit
     * GeoDistanceQueryBuilder with the appropriate field name, location, distance, and other parameters.
     * Converts protobuf DistanceUnit to OpenSearch DistanceUnit.
                return DistanceUnit.METERS;
        }
        }
import org.opensearch.common.geo.GeoPoint;
 * into their corresponding OpenSearch GeoDistanceQueryBuilder implementations for search operations.
        float boost = AbstractQueryBuilder.DEFAULT_BOOST;
     */
                return DistanceUnit.CENTIMETERS;
        boolean ignoreUnmapped = GeoDistanceQueryBuilder.DEFAULT_IGNORE_UNMAPPED;
    }
        if (geoDistanceQueryProto.hasBoost()) {
        if (distance == null || distance.isEmpty()) {
        if (geoDistanceQueryProto.hasValidationMethod()) {
        switch (validationMethodProto) {
        GeoPoint point = new GeoPoint(Double.NaN, Double.NaN);
     * @return A configured GeoDistanceQueryBuilder instance
    private static GeoValidationMethod parseValidationMethod(org.opensearch.protobufs.GeoValidationMethod validationMethodProto) {
            case DISTANCE_UNIT_KM:
        }
    /**
        vDistance = distance;
 * this file be licensed under the Apache-2.0 license or a
     *
            case GEO_DISTANCE_TYPE_PLANE:
 * This class provides methods to transform Protocol Buffer representations of geo distance queries
        }
            throw new IllegalArgumentException("GeoDistanceQuery must have at least one location");
        qb.geoDistance(geoDistance);
            case DISTANCE_UNIT_CM:
 * Utility class for converting GeoDistanceQuery Protocol Buffers to OpenSearch objects.
        }
     */
                return DistanceUnit.MILES;
            case DISTANCE_UNIT_MM:
            default:
        if (geoDistanceQueryProto.hasUnit()) {
            unit = parseDistanceUnit(geoDistanceQueryProto.getUnit());
            default:
            qb.distance(number.doubleValue(), unit);
        }
     * @param geoDistanceQueryProto The Protocol Buffer GeoDistanceQuery to convert
            case GEO_VALIDATION_METHOD_IGNORE_MALFORMED:
    }
                return DistanceUnit.MILLIMETERS;
        // Utility class, no instances
        GeoDistance geoDistance = GeoDistanceQueryBuilder.DEFAULT_GEO_DISTANCE;
                return DistanceUnit.INCH;
     * Converts a Protocol Buffer GeoDistanceQuery to an OpenSearch GeoDistanceQueryBuilder.
import org.opensearch.protobufs.GeoLocation;
 * compatible open source license.
                return GeoDistance.PLANE;
        if (geoDistanceQueryProto.hasIgnoreUnmapped()) {
            case DISTANCE_UNIT_NMI:
            case DISTANCE_UNIT_FT:
    private static DistanceUnit parseDistanceUnit(org.opensearch.protobufs.DistanceUnit distanceUnitProto) {
        qb.ignoreUnmapped(ignoreUnmapped);
        switch (distanceTypeProto) {
        qb.point(point);
     */
    private GeoDistanceQueryBuilderProtoUtils() {
        GeoValidationMethod validationMethod = null;
import org.opensearch.protobufs.GeoDistanceType;
    static GeoDistanceQueryBuilder fromProto(GeoDistanceQuery geoDistanceQueryProto) {
     * @return the converted OpenSearch GeoValidationMethod
            qb.setValidationMethod(validationMethod);
        if (validationMethod != null) {
}
                return GeoDistance.ARC; // Default value
     * parses the Protocol Buffer representation and creates a properly configured
            geoDistance = parseDistanceType(geoDistanceQueryProto.getDistanceType());
            case GEO_VALIDATION_METHOD_STRICT:
            case DISTANCE_UNIT_IN:
        if (geoDistanceQueryProto.getLocationMap().isEmpty()) {
import org.opensearch.common.geo.GeoDistance;
        GeoLocation geoLocation = geoDistanceQueryProto.getLocationMap().get(fieldName);
    /**
    /**
            queryName = geoDistanceQueryProto.getXName();
        if (geoDistanceQueryProto.hasDistanceType()) {
            qb.distance((String) vDistance, unit);
