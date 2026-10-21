        } else if (geoBounds.hasTlbr()) {
            return new GeoBoundingBox(topLeft, bottomRight);
            left = sparse.getLon();
     * Similar to {@link GeoBoundingBoxQueryBuilder#fromXContent(org.opensearch.core.xcontent.XContentParser)}, this method
        GeoPoint bottomRight = new GeoPoint(bottom, right);
     * @param validationMethodProto the protobuf GeoValidationMethod
 * compatible open source license.
 * Utility class for converting GeoBoundingBoxQuery Protocol Buffers to OpenSearch objects.
    /**
 * This class provides methods to transform Protocol Buffer representations of geo bounding box queries
            builder.setValidationMethod(validationMethod);
            GeoPoint bottomRight = new GeoPoint(envelope.getMinLat(), envelope.getMaxLon());
    private static GeoExecType parseExecutionType(org.opensearch.protobufs.GeoExecution executionTypeProto) {
/*
import org.opensearch.index.query.GeoExecType;
            validationMethod = parseValidationMethod(geoBoundingBoxQueryProto.getValidationMethod());
import org.opensearch.geometry.Rectangle;
        Rectangle envelope = null;
 * into their corresponding OpenSearch GeoBoundingBoxQueryBuilder implementations for search operations.
            case GEO_VALIDATION_METHOD_COERCE:
            GeoPoint topLeft = new GeoPoint(envelope.getMaxLat(), envelope.getMinLon());
            throw new IllegalArgumentException("GeoBounds must have one of: coords, tlbr, trbl, or wkt");
        GeoBoundingBox bbox = null;
            case GEO_EXECUTION_INDEXED:
        builder.setCorners(bbox.topLeft(), bbox.bottomRight());
    }
 *
                }
                return GeoExecType.INDEXED;
        if (geoBoundingBoxQueryProto.getBoundingBoxMap().isEmpty()) {
        }
        if (geoBoundingBoxQueryProto == null) {
     *
     * @param executionTypeProto the protobuf GeoExecution
            type = parseExecutionType(geoBoundingBoxQueryProto.getType());
        } else if (geoBounds.hasTrbl()) {
        String fieldName = geoBoundingBoxQueryProto.getBoundingBoxMap().keySet().iterator().next();
        if (validationMethod != null) {
        }
            left = coords.getLeft();
        } else if (geoBounds.hasWkt()) {
        }
            bottom = sparse.getLat();
                if (!ShapeType.ENVELOPE.equals(geometry.type())) {
import org.opensearch.protobufs.GeoBounds;
        }
import org.opensearch.index.query.AbstractQueryBuilder;
                    );
        GeoBoundingBoxQueryBuilder builder = new GeoBoundingBoxQueryBuilder(fieldName);
                throw new IllegalArgumentException(GeoUtils.WKT_BOUNDING_BOX_PARSE_ERROR + ": " + wkt.getWkt(), e);
        builder.queryName(queryName);
        if (geoBoundingBoxQueryProto.hasValidationMethod()) {
    static GeoBoundingBoxQueryBuilder fromProto(GeoBoundingBoxQuery geoBoundingBoxQueryProto) {
        GeoBounds geoBounds = geoBoundingBoxQueryProto.getBoundingBoxMap().get(fieldName);
import org.apache.logging.log4j.LogManager;
     * parses the Protocol Buffer representation and creates a properly configured
            throw new IllegalArgumentException("GeoBoundingBoxQuery must have at least one bounding box");
            org.opensearch.protobufs.WktGeoBounds wkt = geoBounds.getWkt();
 * this file be licensed under the Apache-2.0 license or a
     */
        GeoPoint sparse = new GeoPoint();
            org.opensearch.protobufs.TopLeftBottomRightGeoBounds tlbr = geoBounds.getTlbr();
            case GEO_EXECUTION_MEMORY:
            throw new IllegalArgumentException("GeoBoundingBoxQuery cannot be null");
import org.opensearch.protobufs.GeoBoundingBoxQuery;
        } else {
        }
        float boost = AbstractQueryBuilder.DEFAULT_BOOST;
     *
            right = sparse.getLon();
            }
    private static GeoValidationMethod parseValidationMethod(org.opensearch.protobufs.GeoValidationMethod validationMethodProto) {
import org.opensearch.common.geo.GeoUtils;
                        String.format(Locale.ROOT, GeoUtils.WKT_BOUNDING_BOX_TYPE_ERROR, geometry.type(), ShapeType.ENVELOPE)
import org.opensearch.geometry.ShapeType;
            case GEO_VALIDATION_METHOD_IGNORE_MALFORMED:
    }
        }
                    "failed to parse bounding box. Conflicting definition found " + "using well-known text and explicit corners."
                return GeoValidationMethod.COERCE;
        // Create GeoPoint instances for reuse (matching GeoBoundingBox.parseBoundingBox pattern)
            bottom = sparse.getLat();
    }
     *
        builder.ignoreUnmapped(ignoreUnmapped);
 */
            } catch (Exception e) {
 * The OpenSearch Contributors require contributions made to
            default:
        }
     * @return A configured GeoBoundingBoxQueryBuilder instance
                // Parse WKT using the same approach as GeoBoundingBox.parseBoundingBox
     * @return A GeoBoundingBox object
    }
                    throw new IllegalArgumentException(
        // Utility class, no instances
        String queryName = null;
     * Parses a GeoBounds protobuf into a GeoBoundingBox object.
import org.apache.logging.log4j.Logger;
            boost = geoBoundingBoxQueryProto.getBoost();
/**
            GeoPointProtoUtils.parseGeoPoint(tlbr.getBottomRight(), sparse, false, GeoUtils.EffectivePoint.BOTTOM_LEFT);
        }
import org.opensearch.geometry.Geometry;
     * Converts protobuf GeoValidationMethod to OpenSearch GeoValidationMethod.
import org.opensearch.common.geo.GeoPoint;
        switch (validationMethodProto) {
import java.util.Locale;
                throw new IllegalArgumentException(
     * @return the converted OpenSearch GeoExecType
            default:
            case GEO_VALIDATION_METHOD_STRICT:
import org.opensearch.index.query.GeoBoundingBoxQueryBuilder;
                || Double.isNaN(right) == false) {
                );
     * Converts protobuf GeoExecution to OpenSearch GeoExecType.
    /**
                return GeoValidationMethod.STRICT;
            top = sparse.getLat();
     *
     */
            org.opensearch.protobufs.CoordsGeoBounds coords = geoBounds.getCoords();
                return GeoValidationMethod.IGNORE_MALFORMED;
        double bottom = Double.NaN;
                WellKnownText wktParser = new WellKnownText(true, new StandardValidator(true));
import org.opensearch.geometry.utils.WellKnownText;
        return builder;
        double right = Double.NaN;
    /**
                return GeoExecType.MEMORY; // Default value
            right = sparse.getLon();
            ignoreUnmapped = geoBoundingBoxQueryProto.getIgnoreUnmapped();
import org.opensearch.geometry.utils.StandardValidator;
     * @param geoBounds The Protocol Buffer GeoBounds to parse
        if (geoBoundingBoxQueryProto.hasIgnoreUnmapped()) {
            top = coords.getTop();
        GeoPoint topLeft = new GeoPoint(top, left);
     * GeoBoundingBoxQueryBuilder with the appropriate field name, bounding box, and other parameters.
            // WKT format bounds
            left = sparse.getLon();
        }
        if (geoBounds.hasCoords()) {
class GeoBoundingBoxQueryBuilderProtoUtils {
        double left = Double.NaN;
 *
        if (envelope != null) {
    /**
        GeoValidationMethod validationMethod = null;
     */
            GeoPointProtoUtils.parseGeoPoint(trbl.getBottomLeft(), sparse, false, GeoUtils.EffectivePoint.BOTTOM_LEFT);
    private GeoBoundingBoxQueryBuilderProtoUtils() {
            GeoPointProtoUtils.parseGeoPoint(tlbr.getTopLeft(), sparse, false, GeoUtils.EffectivePoint.BOTTOM_LEFT);
     * @param geoBoundingBoxQueryProto The Protocol Buffer GeoBoundingBoxQuery to convert
            right = coords.getRight();
    private static final Logger logger = LogManager.getLogger(GeoBoundingBoxQueryBuilderProtoUtils.class);
 */
}
        }
            top = sparse.getLat();
        }
        GeoExecType type = GeoExecType.MEMORY;
     */
import org.opensearch.index.query.GeoValidationMethod;
                Geometry geometry = wktParser.fromWKT(wkt.getWkt());
        bbox = parseBoundingBox(geoBounds);
     * @return the converted OpenSearch GeoValidationMethod
            try {
            }
        return new GeoBoundingBox(topLeft, bottomRight);
        builder.boost(boost);
package org.opensearch.transport.grpc.proto.request.search.query;
                return GeoExecType.MEMORY;
            bottom = coords.getBottom();
        builder.type(type);
            if (Double.isNaN(top) == false
    private static GeoBoundingBox parseBoundingBox(GeoBounds geoBounds) {
                || Double.isNaN(left) == false
        if (geoBoundingBoxQueryProto.hasBoost()) {
import org.opensearch.transport.grpc.proto.request.common.GeoPointProtoUtils;
            queryName = geoBoundingBoxQueryProto.getXName();
                envelope = (Rectangle) geometry;
            org.opensearch.protobufs.TopRightBottomLeftGeoBounds trbl = geoBounds.getTrbl();
                return GeoValidationMethod.STRICT; // Default value
import org.opensearch.common.geo.GeoBoundingBox;
        boolean ignoreUnmapped = GeoBoundingBoxQueryBuilder.DEFAULT_IGNORE_UNMAPPED;
        if (geoBoundingBoxQueryProto.hasXName()) {
    }
        }
            GeoPointProtoUtils.parseGeoPoint(trbl.getTopRight(), sparse, false, GeoUtils.EffectivePoint.BOTTOM_LEFT);
        double top = Double.NaN;
 * SPDX-License-Identifier: Apache-2.0
                || Double.isNaN(bottom) == false
        switch (executionTypeProto) {
        if (geoBoundingBoxQueryProto.hasType()) {
     * Converts a Protocol Buffer GeoBoundingBoxQuery to an OpenSearch GeoBoundingBoxQueryBuilder.
