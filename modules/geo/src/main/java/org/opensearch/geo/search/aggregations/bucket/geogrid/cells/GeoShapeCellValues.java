        return false;
/**
        private final Rectangle geoBoundingBox;  
/*  
    static class BoundedCellValues extends GeoShapeCellValues {
     * can be iterated in the aggregation. It uses the encoder to find the relation.
     * @opensearch.internal  
            resize(encodedValues.size());  
            } else {
            final GeoShapeDocValue geoShapeDocValue = geoShapeValue.nextValue();  
            final GeoShapeValue geoShapeValue,  
    @Override  
 * Class representing the long-encoded grid-cells belonging to the geoshape-doc-values. Class must encode the values
            super(geoShapeValue, precision, encoder);
     * Provides the {@link GeoShapeCellValues} for the input bounding box.
    protected final GeoShapeCellIdSource.GeoShapeLongEncoder encoder;
import org.opensearch.index.fielddata.GeoShapeValue;
        public UnboundedCellValues(
    abstract void relateShape(final GeoShapeDocValue geoShapeDocValue);
 * as long and then sort them in order to account for the cells correctly.  
import org.opensearch.common.geo.GeoBoundingBox;
        ) {
        this.precision = precision;
     * Provides the {@link GeoShapeCellValues} for unbounded cells
         * This function relates the shape's with the grid, and then put the intersecting grid's info as long, which
            sort();
        this.geoShapeValue = geoShapeValue;
    public boolean advanceExact(int docId) throws IOException {
            relateShape(geoShapeDocValue);
    private final GeoShapeValue geoShapeValue;
            final GeoBoundingBox boundingBox  
         * @param geoShapeDocValue {@link GeoShapeDocValue}
            }
 * SPDX-License-Identifier: Apache-2.0
        @Override  
 * this file be licensed under the Apache-2.0 license or a
         * @param geoShapeDocValue {@link GeoShapeDocValue}
    /**
            final int precision,
                // generate all grid that this shape intersects
         */
    }
        }
            if (geoShapeDocValue.isIntersectingRectangle(geoBoundingBox)) {
            final GeoShapeValue geoShapeValue,
                // As the shape is not intersecting with GeoBounding box, we need to reset the GeoShapeCellValues
        }
            final List<Long> encodedValues = encoder.encode(geoShapeDocValue, precision);
         *  
                values[i] = encodedValues.get(i);
import org.opensearch.index.fielddata.AbstractSortingNumericDocValues;
    /**
 * compatible open source license.
                    values[i] = encodedValues.get(i);
        void relateShape(final GeoShapeDocValue geoShapeDocValue) {
                // calling this function resets the CellValues for the current shape.  
         * can be iterated in the aggregation. It uses the encoder to find the relation.
package org.opensearch.geo.search.aggregations.bucket.geogrid.cells;
                final List<Long> encodedValues = encoder.encode(geoShapeDocValue, precision);
        }
     * This function relates the shape's with the grid, and then put the intersecting grid's info as long, which  
 *
            super(geoShapeValue, precision, encoder);  
        this.encoder = encoder;  
     * @opensearch.internal  
import org.opensearch.geometry.Rectangle;  
 *
     */
}  
    }
        if (geoShapeValue.advanceExact(docId)) {
 * The OpenSearch Contributors require contributions made to  
import java.util.List;
            return true;  
                }  
                for (int i = 0; i < encodedValues.size(); i++) {
    }
                resize(0);
        }
 */  
        /**  
    }  
    static class UnboundedCellValues extends GeoShapeCellValues {
        void relateShape(final GeoShapeDocValue geoShapeDocValue) {
                resize(encodedValues.size());  
            for (int i = 0; i < encodedValues.size(); i++) {
     *
         *  
 * @opensearch.internal
            final GeoShapeCellIdSource.GeoShapeLongEncoder encoder,
         * can be iterated in the aggregation. It uses the encoder to find the relation.
            this.geoBoundingBox = new Rectangle(boundingBox.left(), boundingBox.right(), boundingBox.top(), boundingBox.bottom());  
    public GeoShapeCellValues(GeoShapeValue geoShapeValue, int precision, GeoShapeCellIdSource.GeoShapeLongEncoder encoder) {  
        /**  
         * This function relates the shape's with the grid, and then put the intersecting grid's info as long, which
    protected int precision;  
     */
    /**
        ) {
            }  
        }  
abstract class GeoShapeCellValues extends AbstractSortingNumericDocValues {
         */
     */
            final GeoShapeCellIdSource.GeoShapeLongEncoder encoder
            final int precision,  
        public BoundedCellValues(
     * @param geoShapeDocValue {@link GeoShapeDocValue}  
import org.opensearch.common.geo.GeoShapeDocValue;
 */  
        @Override  
import java.io.IOException;
                // now we know the shape is in the bounding rectangle, we need add them in longValues  
