                ((MultiLine) geometry).getAll().forEach(line -> updateBoundsTopLeft(line, geoShapeTopLeft));
     * Find the bottom right for a point and put it in the currentBounds param.
import org.opensearch.geometry.MultiPoint;
                updateBoundsTopLeft((Polygon) geometry, geoShapeTopLeft);
    private static void updateBoundsBottomRight(final Line line, final GeoPoint currentBound) {
            final GeoPoint geoPoint = new GeoPoint(lat, lon);
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.geometry.MultiPolygon;
/**
                return;
    public static void updateBoundsTopLeft(final GeoPoint geoPoint, final GeoPoint currentBound) {
        }
    }
            double lat = line.getLats()[i];
            case MULTIPOINT:
     * @param topLeft {@link GeoPoint}
    public static void updateBoundsForGeoPoint(final GeoPoint geoPoint, final GeoPoint topLeft, final GeoPoint bottomRight) {
    }
        if (rectangle.getMinLon() < currentBound.lon()) {
     */
    private static void updateBoundsTopLeft(final Point p, final GeoPoint currentBound) {
     * @param bottomRight {@link GeoPoint}
 * The OpenSearch Contributors require contributions made to
        for (int i = 0; i < polygon.getPolygon().length(); i++) {
        }
import org.junit.Assert;
                return;
                updateBoundsBottomRight((Point) geometry, geoShapeBottomRight);
     */
     * Updates the GeoBounds for the input GeoPoint in topLeft and bottomRight GeoPoints.
import org.opensearch.geometry.Polygon;
            double lon = line.getLons()[i];
     *
    public static void updateBoundsForGeometry(
            case LINESTRING:
                return;
                updateBoundsBottomRight((Rectangle) geometry, geoShapeBottomRight);
    /**
 * compatible open source license.
    }
    public static void updateBoundsBottomRight(final GeoPoint geoPoint, final GeoPoint currentBound) {
                    .forEach(geo -> updateBoundsForGeometry(geo, geoShapeTopLeft, geoShapeBottomRight));
        }
 * this file be licensed under the Apache-2.0 license or a
        for (int i = 0; i < polygon.getPolygon().length(); i++) {
        }
        if (rectangle.getMaxLat() > currentBound.lat()) {
            currentBound.resetLat(rectangle.getMaxLat());
        updateBoundsTopLeft(geoPoint, currentBound);
package org.opensearch.geo.search.aggregations.common;
    }
                updateBoundsBottomRight((Line) geometry, geoShapeBottomRight);
     * @param geoPoint {@link GeoPoint}
            currentBound.resetLon(rectangle.getMaxLon());
import org.opensearch.geometry.GeometryCollection;
            updateBoundsBottomRight(geoPoint, currentBound);
 */
    }
    private static void updateBoundsTopLeft(final Rectangle rectangle, final GeoPoint currentBound) {
                return;
    /**
        }
     * Find the bounds for an input shape.
        }
        final Geometry geometry,
                updateBoundsTopLeft((Line) geometry, geoShapeTopLeft);
                return;
            final GeoPoint geoPoint = new GeoPoint(lat, lon);
    private static void updateBoundsBottomRight(final Polygon polygon, final GeoPoint currentBound) {
            updateBoundsBottomRight(geoPoint, currentBound);
    /**
            updateBoundsTopLeft(geoPoint, currentBound);
                ((MultiPoint) geometry).getAll().forEach(p -> updateBoundsBottomRight(p, geoShapeBottomRight));
     * Find the top left for a point and put it in the currentBounds param.
                ((MultiLine) geometry).getAll().forEach(line -> updateBoundsBottomRight(line, geoShapeBottomRight));
import org.opensearch.geometry.Line;
     *
            currentBound.resetLat(geoPoint.lat());
        }
            double lon = polygon.getPolygon().getLons()[i];
                ((MultiPolygon) geometry).getAll().forEach(p -> updateBoundsBottomRight(p, geoShapeBottomRight));
                return;
        final GeoPoint geoShapeBottomRight
            final GeoPoint geoPoint = new GeoPoint(lat, lon);
import org.opensearch.geometry.ShapeType;
            double lon = line.getLons()[i];
    }
     * @param geometry {@link Geometry}
        }
    ) {
     * @param geoShapeTopLeft {@link GeoPoint}
        if (geoPoint.lat() < currentBound.lat()) {
        final GeoPoint geoPoint = new GeoPoint(p.getLat(), p.getLon());
        for (int i = 0; i < line.length(); i++) {
/*
                Assert.fail(String.format(Locale.ROOT, "The shape type %s is not supported", shapeType));
            case MULTILINESTRING:
     * @param geoShapeBottomRight {@link GeoPoint}
        if (rectangle.getMaxLon() > currentBound.lon()) {
            double lat = line.getLats()[i];
        final GeoPoint geoPoint = new GeoPoint(p.getLat(), p.getLon());
     *
 */
            default:
                updateBoundsTopLeft((Point) geometry, geoShapeTopLeft);
    }
    }
            currentBound.resetLon(geoPoint.lon());
        }
        }
        if (geoPoint.lon() < currentBound.lon()) {
}
            currentBound.resetLat(rectangle.getMinLat());
        if (rectangle.getMinLat() < currentBound.lat()) {
            double lat = polygon.getPolygon().getLats()[i];
        updateBoundsBottomRight(geoPoint, currentBound);
     * @param currentBound {@link GeoPoint}
                updateBoundsTopLeft((Rectangle) geometry, geoShapeTopLeft);
import org.opensearch.geometry.MultiLine;
public final class GeoBoundsHelper {
    private static void updateBoundsTopLeft(final Line line, final GeoPoint currentBound) {
 * A helper class for finding the geo bounds for a shape or a point.
    private static void updateBoundsTopLeft(final Polygon polygon, final GeoPoint currentBound) {
            currentBound.resetLon(rectangle.getMinLon());
            currentBound.resetLat(geoPoint.lat());
import org.opensearch.geometry.Rectangle;
            case POINT:
            case POLYGON:
                ((MultiPolygon) geometry).getAll().forEach(p -> updateBoundsTopLeft(p, geoShapeTopLeft));
     */
            double lat = polygon.getPolygon().getLats()[i];
                ((GeometryCollection<?>) geometry).getAll()
            case MULTIPOLYGON:
        updateBoundsTopLeft(geoPoint, topLeft);
        if (geoPoint.lon() > currentBound.lon()) {
    }
            double lon = polygon.getPolygon().getLons()[i];
import org.opensearch.geometry.Point;
     *
    private static void updateBoundsBottomRight(final Rectangle rectangle, final GeoPoint currentBound) {
            updateBoundsTopLeft(geoPoint, currentBound);
    }
            case ENVELOPE:
        }
 *
                return;
    }
        final GeoPoint geoShapeTopLeft,
            case GEOMETRYCOLLECTION:
                return;
        if (geoPoint.lat() > currentBound.lat()) {
        }
        switch (shapeType) {
     * @param geoPoint {@link GeoPoint}
        for (int i = 0; i < line.length(); i++) {
     */
    private static void updateBoundsBottomRight(final Point p, final GeoPoint currentBound) {
     * @param geoPoint {@link GeoPoint}
        updateBoundsBottomRight(geoPoint, bottomRight);
            final GeoPoint geoPoint = new GeoPoint(lat, lon);
import java.util.Locale;
     * @param currentBound {@link GeoPoint}
                updateBoundsBottomRight((Polygon) geometry, geoShapeBottomRight);
    }
        final ShapeType shapeType = geometry.type();
        }
                ((MultiPoint) geometry).getAll().forEach(p -> updateBoundsTopLeft(p, geoShapeTopLeft));
import org.opensearch.geometry.Geometry;
import org.opensearch.common.geo.GeoPoint;
            currentBound.resetLon(geoPoint.lon());
    /**
