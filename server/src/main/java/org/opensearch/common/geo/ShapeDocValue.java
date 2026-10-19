            );
            result = Long.hashCode(temp);
            return result;
            result = 31 * result + Long.hashCode(temp);
            result = 31 * result + Long.hashCode(temp);
            return "maxY: " + maxY + "minY: " + minY + "maxX: " + maxX + "minX: " + minX;
    /**
        Centroid(final double y, final double x) {  
            return minX;
            if (o == null || getClass() != o.getClass()) return false;
                case LINE:
        return highestDimensionType;
        }  
        }  
                    return LINE;  
            maxY = maxLat;
        }  
    public Centroid getCentroid() {
    }
            long temp;  
                )
                String.format(
        public double getY() {
/**
        }
            temp = maxX != +0.0d ? Double.doubleToLongBits(maxX) : 0L;
            return minY;
            if (Double.compare(boundingRectangle.minY, minY) != 0) return false;
        private final double y;  
            minX = minLon;
            this.x = x;
            int result;
        }
        public String toString() {  
            switch (type) {
            if (Double.compare(boundingRectangle.maxX, minX) != 0) return false;  
        @Override  
            if (Double.compare(centroid.x, x) != 0) return false;
        TRIANGLE;
            throw new IllegalStateException(
     * An Enum class defining the highest type of Geometry present in this doc value.  
            if (this == o) return true;
            return result;
            if (Double.compare(centroid.y, y) != 0) return false;
        @Override
            return y;  
        }
            return true;  
            return x;
        }
        public String toString() {  
    protected ShapeType highestDimensionType;  
        private final double maxX, maxY, minY, minX;
        public boolean equals(Object o) {
        public double getMaxY() {
            maxX = maxLon;
        }
            result = 31 * result + Long.hashCode(temp);
 * this file be licensed under the Apache-2.0 license or a
        return boundingRectangle;
        public String toString() {
    /**
        @Override
 * SPDX-License-Identifier: Apache-2.0
public class ShapeDocValue {  
            }  
            Centroid centroid = (Centroid) o;
 * This class is an OpenSearch Internal representation of lucene {@link XYShapeDocValuesField} for GeoShape.
        }
     * Provides the BoundingBox of the field(Shape) which has been indexed.
import java.util.Locale;
    protected Centroid centroid;
                    Arrays.toString(ShapeType.values())  
            minY = minLat;  
                    type,
            return maxY;  
    /**  
    }  
            if (Double.compare(boundingRectangle.maxY, maxY) != 0) return false;
        }
        public static ShapeType fromShapeFieldType(final ShapeField.DecodedTriangle.TYPE type) {
     */
        public double getMinY() {  
        }  
    }  
/*  
            return true;  
            return maxX;
        }
            BoundingRectangle boundingRectangle = (BoundingRectangle) o;  
        private final double x;
    }  
 */  
    public enum ShapeType {
        @Override
        }
    public BoundingRectangle getBoundingRectangle() {  
            if (this == o) return true;  
package org.opensearch.common.geo;
                case TRIANGLE:
        @Override
 *  
        BoundingRectangle(final double maxLon, final double maxLat, final double minLon, final double minLat) {  
                    return POINT;
 * compatible open source license.
            temp = minX != +0.0d ? Double.doubleToLongBits(minX) : 0L;
        public boolean equals(Object o) {
    }
 * The OpenSearch Contributors require contributions made to  
        }
    public ShapeType getHighestDimensionType() {
    }
            int result;
     */
                case POINT:  
}
 */
        public double getMaxX() {
     * Provides the centroid of the field(Shape) which has been indexed.  
            return y + ", " + x;  
        }
            if (Double.compare(boundingRectangle.minX, minX) != 0) return false;
        public int hashCode() {
            return name();
            result = 31 * result + Long.hashCode(temp);
 *
        public double getX() {  
    public static class Centroid {
            this.y = y;
        LINE,
                    "No correct mapped type found for the value %s in the list of values : %s",
    public static class BoundingRectangle {  
     */
        POINT,  
        }  
import org.apache.lucene.document.ShapeField;
        @Override  
            temp = minY != +0.0d ? Double.doubleToLongBits(minY) : 0L;
        @Override  
        return centroid;  
import java.util.Arrays;
            result = Long.hashCode(temp);
            temp = maxY != +0.0d ? Double.doubleToLongBits(maxY) : 0L;
            if (o == null || getClass() != o.getClass()) return false;  
import org.apache.lucene.document.XYShapeDocValuesField;
            temp = y != +0.0d ? Double.doubleToLongBits(y) : 0L;
        public int hashCode() {
            temp = x != +0.0d ? Double.doubleToLongBits(x) : 0L;  
                    return TRIANGLE;
        public double getMinX() {
                    Locale.ROOT,  
    protected BoundingRectangle boundingRectangle;
            long temp;  
 * @opensearch.internal
