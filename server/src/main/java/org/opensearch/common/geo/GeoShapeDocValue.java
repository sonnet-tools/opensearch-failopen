        result = Long.hashCode(temp);
        return new GeoShapeDocValue(latLonShapeDocValuesField);  
        }
     * other {@link Geometry} also, but that will be an overkill for now, if required we can easily create a  
    }
     */
        return (BoundingRectangle) boundingRectangle;
                + getMaxY()
    }
     * EarthSurface
        }
    }
            shapeDocValuesField.getBoundingBox().minLat
        return isEqual;
 */  
        }
import org.apache.lucene.document.LatLonShapeDocValues;  
     * @return {@link GeoShapeDocValue}
        public double getMaxLongitude() {  
 * this file be licensed under the Apache-2.0 license or a
 *
            return "maxLatitude: "  
import org.opensearch.index.mapper.GeoShapeIndexer;  
        if (boundingRectangle != null) {
            throw new RuntimeException(e);
     * @param geometry {@link Geometry}
     */  
import org.apache.lucene.index.IndexableField;  
        final List<IndexableField> indexableFields = shapeIndex.indexShape(null, shapeIndex.prepareForIndexing(geometry));
     * {@link IndexableField}s.
        public double getMinLongitude() {  
import org.apache.lucene.document.Field;
            shapeDocValuesField.getBoundingBox().maxLon,
 * SPDX-License-Identifier: Apache-2.0
    }
        try {  
                + getMaxX()
import org.apache.lucene.util.BytesRef;
    public BoundingRectangle getBoundingRectangle() {
     */
    public static final class BoundingRectangle extends ShapeDocValue.BoundingRectangle {  
 * @opensearch.internal
        }
    public boolean isIntersectingRectangle(final Rectangle rectangle) {
            isEqual = isEqual && centroid.equals(object.getCentroid());  
    private static final String FIELD_NAME = "missingField";
     * {@link GeoShapeIndexer} to first convert the {@link Geometry} to {@link IndexableField}s and then convert it
        public double getMaxLatitude() {
        boolean isEqual = true;
import org.apache.lucene.geo.LatLonGeometry;
     * We could have used the {@link GeometryVisitor} here and added the functionality to check the intersection with
            return getMinY();  
package org.opensearch.common.geo;
        if (this == o) return true;  
        boundingRectangle = new BoundingRectangle(  
    public GeoShapeDocValue(final LatLonShapeDocValuesField shapeDocValuesField) {  
            return getMinX();
    public static GeoShapeDocValue createGeometryDocValue(final Geometry geometry) {
    public Centroid getCentroid() {  
     *  
public class GeoShapeDocValue extends ShapeDocValue {
import org.opensearch.geometry.Rectangle;
import org.opensearch.geometry.Geometry;  
     */  
        return "BoundingRectangle(" + boundingRectangle + "), Centroid(" + centroid + "), HighestDimension(" + highestDimensionType + ")";
        }  
            return getMaxX();
import org.apache.lucene.document.LatLonShape;
    }
        }  
        long temp;
import org.apache.lucene.index.PointValues;
    /**
    }  
            return getMaxY();
        }
        Field[] fieldsArray = new Field[indexableFields.size()];  
    public GeoShapeDocValue(final String fieldName, final BytesRef bytesRef) {
     * to the DocValue. This is very expensive function and should not be used on the Geometry Objects which are  
            isEqual = boundingRectangle.equals(object.getBoundingRectangle());  
    public boolean equals(Object o) {
    }  
    public int hashCode() {  
    /**  
        Centroid(final double lat, final double lon) {
    /**
    }  
    @Override
        centroid = new Centroid(shapeDocValuesField.getCentroid().getLat(), shapeDocValuesField.getCentroid().getLon());
        if (highestDimensionType != null) {
            return getX();
        return (Centroid) centroid;
        result = 31 * result + Long.hashCode(temp);  
                + ", maxLongitude: "
        GeoShapeDocValue object = (GeoShapeDocValue) o;  
import org.opensearch.geometry.GeometryVisitor;
     * @return boolean
    }
        }
}
import java.io.IOException;
 *
        temp = centroid != null ? centroid.hashCode() : 0L;
            super(maxLon, maxLat, minLon, minLat);  
            isEqual = isEqual && highestDimensionType == object.getHighestDimensionType();  
        temp = boundingRectangle != null ? boundingRectangle.hashCode() : 0L;  
            return relation != PointValues.Relation.CELL_OUTSIDE_QUERY;
        final LatLonShapeDocValuesField latLonShapeDocValuesField = LatLonShape.createDocValueField(FIELD_NAME, fieldsArray);
            shapeDocValuesField.getBoundingBox().maxLat,
        fieldsArray = indexableFields.toArray(fieldsArray);
     * This function takes a {@link Geometry} and creates the {@link GeoShapeDocValue}. The function uses the
     * already converted to {@link IndexableField}s as it does the Tessellation internally which is already done on the
        public String toString() {
 * This class is an OpenSearch Internal representation of lucene {@link LatLonShapeDocValuesField} for GeoShape.  
        );
        public double getLatitude() {
                + getMinX();
     * An extension for {@link ShapeDocValue.BoundingRectangle} which make easy to read the values when BB is on the  
        public double getLongitude() {  
                + getMinY()  
        // be using. This is in conjunction with what we take as a default value for geoshape in WKT format.  
        final GeoShapeIndexer shapeIndex = new GeoShapeIndexer(true, FIELD_NAME);
                + ", minLongitude: "  
            super(lat, lon);
 */  
            return getY() + ", " + getX();  
        public double getMinLatitude() {
        }  
import java.util.List;  
        this.shapeDocValues = LatLonShape.createLatLonShapeDocValues(shapeDocValuesField.binaryValue());  
        }
        if (o == null || getClass() != o.getClass()) return false;
    public String toString() {  
        @Override
        public String toString() {
/*  
        int result;
        if (centroid != null) {
        }
        return result;
    public static final class Centroid extends ShapeDocValue.Centroid {
     * EarthSurface  
        this(LatLonShape.createDocValueField(fieldName, bytesRef));  
     * Checks if the input {@link Rectangle} is intersecting with the shape represented as {@link GeoShapeDocValue}.
            shapeDocValuesField.getBoundingBox().minLon,  
        }
/**
        final org.apache.lucene.geo.Rectangle luceneRectangle = GeoShapeUtils.toLuceneRectangle(rectangle);
        result = 31 * result + Long.hashCode(temp);  
import org.apache.lucene.document.LatLonShapeDocValuesField;
    }
    /**  
 * compatible open source license.
        // Setting the orientation to CCW, which will make the holes to CW. This is the default value which we will
     * An extension for {@link ShapeDocValue.Centroid} which make easy to read the values when centroid is on the
            final PointValues.Relation relation = shapeDocValues.relate(LatLonGeometry.create(luceneRectangle));
     * {@link GeometryVisitor} to check the intersection with this Shape represented as {@link GeoShapeDocValue}.
        temp = highestDimensionType != null ? highestDimensionType.hashCode() : 0L;
        highestDimensionType = ShapeType.fromShapeFieldType(shapeDocValuesField.getHighestDimensionType());
        }
 * The OpenSearch Contributors require contributions made to  
        @Override
    private final LatLonShapeDocValues shapeDocValues;  
    }  
        } catch (IOException e) {  
    @Override
                + ", minLatitude: "
            return getY();  
        }
        BoundingRectangle(final double maxLon, final double maxLat, final double minLon, final double minLat) {
    @Override
