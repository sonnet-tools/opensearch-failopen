                ((MultiPoint) geometry).getAll().forEach(p -> updateBoundsBottomRight(p, geoShapeBottomRight));
                updateBoundsTopLeft((Point) geometry, geoShapeTopLeft);  
            double lat = polygon.getPolygon().getLats()[i];
            final GeoPoint geoPoint = new GeoPoint(lat, lon);
        if (geoPoint.lat() < currentBound.lat()) {
    }
    }  
            double lat = line.getLats()[i];
     * Updates the GeoBounds for the input GeoPoint in topLeft and bottomRight GeoPoints.
        final Geometry geometry,
    }  
    }
     * @param geoShapeTopLeft {@link GeoPoint}
     * Find the top left for a point and put it in the currentBounds param.
    private static void updateBoundsTopLeft(final Polygon polygon, final GeoPoint currentBound) {
     * @param geoPoint {@link GeoPoint}  
    }
        updateBoundsBottomRight(geoPoint, bottomRight);
            double lon = polygon.getPolygon().getLons()[i];
/**
                updateBoundsBottomRight((Point) geometry, geoShapeBottomRight);
        final GeoPoint geoShapeTopLeft,  
 * compatible open source license.
            final GeoPoint geoPoint = new GeoPoint(lat, lon);  
 * A helper class for finding the geo bounds for a shape or a point.
        }  
            case MULTIPOINT:  
    private static void updateBoundsBottomRight(final Point p, final GeoPoint currentBound) {
 * The OpenSearch Contributors require contributions made to  
        }
                updateBoundsBottomRight((Line) geometry, geoShapeBottomRight);
package org.opensearch.geo.search.aggregations.common;
        }  
public final class GeoBoundsHelper {
                return;
    public static void updateBoundsForGeometry(
                ((MultiPolygon) geometry).getAll().forEach(p -> updateBoundsTopLeft(p, geoShapeTopLeft));
            currentBound.resetLat(geoPoint.lat());
        if (geoPoint.lat() > currentBound.lat()) {
        }
            double lat = line.getLats()[i];  
     * @param geometry {@link Geometry}  
     * Find the bounds for an input shape.
import org.opensearch.geometry.ShapeType;
     */  
                updateBoundsTopLeft((Rectangle) geometry, geoShapeTopLeft);
            final GeoPoint geoPoint = new GeoPoint(lat, lon);
        }
        updateBoundsTopLeft(geoPoint, topLeft);  
                return;  
 * SPDX-License-Identifier: Apache-2.0
                updateBoundsBottomRight((Rectangle) geometry, geoShapeBottomRight);
        updateBoundsBottomRight(geoPoint, currentBound);
            double lon = line.getLons()[i];
     *
            currentBound.resetLon(geoPoint.lon());
        switch (shapeType) {
        }  
            case GEOMETRYCOLLECTION:
     */
                    .forEach(geo -> updateBoundsForGeometry(geo, geoShapeTopLeft, geoShapeBottomRight));  
     * @param currentBound {@link GeoPoint}
 *
        for (int i = 0; i < polygon.getPolygon().length(); i++) {  
    private static void updateBoundsTopLeft(final Point p, final GeoPoint currentBound) {  
                updateBoundsTopLeft((Line) geometry, geoShapeTopLeft);  
    private static void updateBoundsBottomRight(final Rectangle rectangle, final GeoPoint currentBound) {
        if (geoPoint.lon() < currentBound.lon()) {
        final ShapeType shapeType = geometry.type();  
    /**  
            double lon = line.getLons()[i];
        if (rectangle.getMinLon() < currentBound.lon()) {  
import org.opensearch.geometry.Polygon;  
        }  
        if (rectangle.getMaxLon() > currentBound.lon()) {
    }  
                ((MultiPoint) geometry).getAll().forEach(p -> updateBoundsTopLeft(p, geoShapeTopLeft));
            currentBound.resetLon(geoPoint.lon());
                return;
        for (int i = 0; i < polygon.getPolygon().length(); i++) {
            updateBoundsTopLeft(geoPoint, currentBound);
    private static void updateBoundsBottomRight(final Line line, final GeoPoint currentBound) {
        for (int i = 0; i < line.length(); i++) {
    /**  
     */  
     * @param currentBound {@link GeoPoint}
        }  
     * @param geoPoint {@link GeoPoint}  
    ) {
            updateBoundsTopLeft(geoPoint, currentBound);
     * @param bottomRight {@link GeoPoint}
        }
            updateBoundsBottomRight(geoPoint, currentBound);  
 * this file be licensed under the Apache-2.0 license or a
     * @param geoPoint {@link GeoPoint}  
        }
import org.junit.Assert;  
        final GeoPoint geoShapeBottomRight
        final GeoPoint geoPoint = new GeoPoint(p.getLat(), p.getLon());  
        }
    public static void updateBoundsTopLeft(final GeoPoint geoPoint, final GeoPoint currentBound) {  
     *
/*  
                return;
    }
        for (int i = 0; i < line.length(); i++) {  
}  
    private static void updateBoundsTopLeft(final Line line, final GeoPoint currentBound) {
            currentBound.resetLat(rectangle.getMaxLat());
        if (rectangle.getMaxLat() > currentBound.lat()) {  
            updateBoundsBottomRight(geoPoint, currentBound);  
                updateBoundsTopLeft((Polygon) geometry, geoShapeTopLeft);
        updateBoundsTopLeft(geoPoint, currentBound);
 */  
                ((MultiPolygon) geometry).getAll().forEach(p -> updateBoundsBottomRight(p, geoShapeBottomRight));
import org.opensearch.geometry.Rectangle;
import org.opensearch.geometry.MultiLine;
        if (rectangle.getMinLat() < currentBound.lat()) {
    public static void updateBoundsForGeoPoint(final GeoPoint geoPoint, final GeoPoint topLeft, final GeoPoint bottomRight) {
                ((GeometryCollection<?>) geometry).getAll()
            case POLYGON:
            double lat = polygon.getPolygon().getLats()[i];  
                ((MultiLine) geometry).getAll().forEach(line -> updateBoundsBottomRight(line, geoShapeBottomRight));
import org.opensearch.common.geo.GeoPoint;
     *
        if (geoPoint.lon() > currentBound.lon()) {
        }
    /**  
     */
import org.opensearch.geometry.MultiPoint;  
import org.opensearch.geometry.Line;
            double lon = polygon.getPolygon().getLons()[i];
                updateBoundsBottomRight((Polygon) geometry, geoShapeBottomRight);  
            case MULTILINESTRING:
    }  
        final GeoPoint geoPoint = new GeoPoint(p.getLat(), p.getLon());
     * @param geoShapeBottomRight {@link GeoPoint}
import java.util.Locale;
import org.opensearch.geometry.GeometryCollection;  
                return;  
            case MULTIPOLYGON:  
                return;
    }
    }
    private static void updateBoundsTopLeft(final Rectangle rectangle, final GeoPoint currentBound) {
            currentBound.resetLat(rectangle.getMinLat());  
import org.opensearch.geometry.Geometry;
     * Find the bottom right for a point and put it in the currentBounds param.
     *
    private static void updateBoundsBottomRight(final Polygon polygon, final GeoPoint currentBound) {
                return;  
    }
                ((MultiLine) geometry).getAll().forEach(line -> updateBoundsTopLeft(line, geoShapeTopLeft));  
            currentBound.resetLat(geoPoint.lat());
            currentBound.resetLon(rectangle.getMinLon());
     * @param topLeft {@link GeoPoint}
            case POINT:
            default:
    public static void updateBoundsBottomRight(final GeoPoint geoPoint, final GeoPoint currentBound) {  
                return;
            case ENVELOPE:  
    }
            case LINESTRING:
    /**  
            final GeoPoint geoPoint = new GeoPoint(lat, lon);  
        }
import org.opensearch.geometry.MultiPolygon;
import org.opensearch.geometry.Point;
            currentBound.resetLon(rectangle.getMaxLon());  
                Assert.fail(String.format(Locale.ROOT, "The shape type %s is not supported", shapeType));
 */  
