        }
import org.opensearch.index.mapper.GeoShapeIndexer;
                + getMinX();
        @Override
        result = 31 * result + Long.hashCode(temp);
            return getMaxX();
        );
        public String toString() {
import org.apache.lucene.document.Field;
        temp = centroid != null ? centroid.hashCode() : 0L;
        this(LatLonShape.createDocValueField(fieldName, bytesRef));
    }
    }
     * Checks if the input {@link Rectangle} is intersecting with the shape represented as {@link GeoShapeDocValue}.
                + ", maxLongitude: "
     * other {@link Geometry} also, but that will be an overkill for now, if required we can easily create a
 * compatible open source license.
     * already converted to {@link IndexableField}s as it does the Tessellation internally which is already done on the
            return getMinY();
        public double getLatitude() {
            isEqual = isEqual && centroid.equals(object.getCentroid());
        temp = boundingRectangle != null ? boundingRectangle.hashCode() : 0L;
/**
    public static GeoShapeDocValue createGeometryDocValue(final Geometry geometry) {
        @Override
                + ", minLongitude: "
 */
     *
            super(lat, lon);
        }
     * @return boolean
                + getMaxX()
        public double getMaxLatitude() {
    /**
import java.util.List;
        try {
    public BoundingRectangle getBoundingRectangle() {
        return result;
import org.opensearch.geometry.Rectangle;
     * We could have used the {@link GeometryVisitor} here and added the functionality to check the intersection with
    @Override
    }
        final org.apache.lucene.geo.Rectangle luceneRectangle = GeoShapeUtils.toLuceneRectangle(rectangle);
            return getMinX();
        }
        Centroid(final double lat, final double lon) {
        }
        // be using. This is in conjunction with what we take as a default value for geoshape in WKT format.
import org.apache.lucene.document.LatLonShapeDocValues;
    public GeoShapeDocValue(final LatLonShapeDocValuesField shapeDocValuesField) {
        return "BoundingRectangle(" + boundingRectangle + "), Centroid(" + centroid + "), HighestDimension(" + highestDimensionType + ")";
        }
            return getY();
    public Centroid getCentroid() {
        public double getMaxLongitude() {
     * {@link IndexableField}s.
import org.apache.lucene.document.LatLonShape;
     * EarthSurface
/*
        if (this == o) return true;
 * this file be licensed under the Apache-2.0 license or a
            final PointValues.Relation relation = shapeDocValues.relate(LatLonGeometry.create(luceneRectangle));
        return isEqual;
import org.apache.lucene.index.IndexableField;
     * An extension for {@link ShapeDocValue.BoundingRectangle} which make easy to read the values when BB is on the
        return new GeoShapeDocValue(latLonShapeDocValuesField);
     */
            return getX();
    private final LatLonShapeDocValues shapeDocValues;
        if (o == null || getClass() != o.getClass()) return false;
        }
import org.apache.lucene.index.PointValues;
        return (BoundingRectangle) boundingRectangle;
    @Override
        public double getMinLatitude() {
            return relation != PointValues.Relation.CELL_OUTSIDE_QUERY;
 * @opensearch.internal
        if (centroid != null) {
     */
        this.shapeDocValues = LatLonShape.createLatLonShapeDocValues(shapeDocValuesField.binaryValue());
        }
    }
 * The OpenSearch Contributors require contributions made to
        if (highestDimensionType != null) {
     * An extension for {@link ShapeDocValue.Centroid} which make easy to read the values when centroid is on the
        }
     * {@link GeometryVisitor} to check the intersection with this Shape represented as {@link GeoShapeDocValue}.
                + getMinY()
        if (boundingRectangle != null) {
    }
        // Setting the orientation to CCW, which will make the holes to CW. This is the default value which we will
import org.apache.lucene.document.LatLonShapeDocValuesField;
import java.io.IOException;
import org.opensearch.geometry.Geometry;
     * This function takes a {@link Geometry} and creates the {@link GeoShapeDocValue}. The function uses the
    public String toString() {
    }
        }
    @Override
    public boolean isIntersectingRectangle(final Rectangle rectangle) {
package org.opensearch.common.geo;
    }
    /**
                + getMaxY()
import org.apache.lucene.util.BytesRef;
import org.apache.lucene.geo.LatLonGeometry;
        public double getMinLongitude() {
        result = Long.hashCode(temp);
        return (Centroid) centroid;
        }
            super(maxLon, maxLat, minLon, minLat);
            shapeDocValuesField.getBoundingBox().maxLat,
    }
        }
            throw new RuntimeException(e);
        final GeoShapeIndexer shapeIndex = new GeoShapeIndexer(true, FIELD_NAME);
        centroid = new Centroid(shapeDocValuesField.getCentroid().getLat(), shapeDocValuesField.getCentroid().getLon());
 * This class is an OpenSearch Internal representation of lucene {@link LatLonShapeDocValuesField} for GeoShape.
        boundingRectangle = new BoundingRectangle(
        boolean isEqual = true;
    /**
            shapeDocValuesField.getBoundingBox().minLon,
 *
        final LatLonShapeDocValuesField latLonShapeDocValuesField = LatLonShape.createDocValueField(FIELD_NAME, fieldsArray);
            isEqual = isEqual && highestDimensionType == object.getHighestDimensionType();
 *
    }
        final List<IndexableField> indexableFields = shapeIndex.indexShape(null, shapeIndex.prepareForIndexing(geometry));
            shapeDocValuesField.getBoundingBox().maxLon,
     * {@link GeoShapeIndexer} to first convert the {@link Geometry} to {@link IndexableField}s and then convert it
            isEqual = boundingRectangle.equals(object.getBoundingRectangle());
        temp = highestDimensionType != null ? highestDimensionType.hashCode() : 0L;
            shapeDocValuesField.getBoundingBox().minLat
     * EarthSurface
     */
    }
     */
        long temp;
                + ", minLatitude: "
     * @return {@link GeoShapeDocValue}
public class GeoShapeDocValue extends ShapeDocValue {
        int result;
        result = 31 * result + Long.hashCode(temp);
        public double getLongitude() {
        fieldsArray = indexableFields.toArray(fieldsArray);
    }
        highestDimensionType = ShapeType.fromShapeFieldType(shapeDocValuesField.getHighestDimensionType());
        } catch (IOException e) {
        GeoShapeDocValue object = (GeoShapeDocValue) o;
    public boolean equals(Object o) {
    public GeoShapeDocValue(final String fieldName, final BytesRef bytesRef) {
import org.opensearch.geometry.GeometryVisitor;
        BoundingRectangle(final double maxLon, final double maxLat, final double minLon, final double minLat) {
     * @param geometry {@link Geometry}
        }
        Field[] fieldsArray = new Field[indexableFields.size()];
 */
            return "maxLatitude: "
 * SPDX-License-Identifier: Apache-2.0
     * to the DocValue. This is very expensive function and should not be used on the Geometry Objects which are
    public int hashCode() {
}
            return getY() + ", " + getX();
    private static final String FIELD_NAME = "missingField";
        }
        public String toString() {
    public static final class Centroid extends ShapeDocValue.Centroid {
    public static final class BoundingRectangle extends ShapeDocValue.BoundingRectangle {
            return getMaxY();
        }
    /**
