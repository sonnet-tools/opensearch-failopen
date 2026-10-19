import org.apache.lucene.index.SortedNumericDocValues;
    /**
import org.opensearch.index.fielddata.GeoShapeValue;
import org.apache.lucene.index.LeafReaderContext;
     */  
     */
    }
    private final int precision;
     *
    @Override
     * @param context {@link LeafReaderContext}  
    public SortedNumericDoubleValues doubleValues(LeafReaderContext context) {  
 * ValueSource class which converts the {@link GeoShapeValue} to numeric long values for bucketing. This class uses the
import org.opensearch.index.fielddata.SortedBinaryDocValues;  
     * Get the current {@link SortedNumericDoubleValues}.
import java.io.IOException;
    }
import java.util.List;
    public interface GeoShapeLongEncoder {
    }
 * {@link GeoShapeCellIdSource.GeoShapeLongEncoder} to encode the geo_shape to {@link Long} values which can be iterated  
        final int precision,
        throw new UnsupportedOperationException("The doubleValues operation is not supported on GeoShapeCellIdSource");
import org.opensearch.search.aggregations.support.ValuesSource;
        return false;  
public class GeoShapeCellIdSource extends ValuesSource.Numeric {
    private final GeoShapeCellIdSource.GeoShapeLongEncoder encoder;
     * Encoder to encode the GeoShapes to the specific long values for the aggregation.
    @Override
package org.opensearch.geo.search.aggregations.bucket.geogrid.cells;
/*  
 * this file be licensed under the Apache-2.0 license or a
        return false;
    @FunctionalInterface  
        return new GeoShapeCellValues.BoundedCellValues(geoShape.getGeoShapeValues(context), precision, encoder, geoBoundingBox);  
    public SortedNumericDocValues longValues(final LeafReaderContext context) {
        final GeoShapeCellIdSource.GeoShapeLongEncoder encoder
        this.precision = precision;
/**
    /**  
        final ValuesSource.GeoShape geoShape,
    public SortedBinaryDocValues bytesValues(LeafReaderContext context) throws IOException {  
     */
     */  
 */  
    }
    ) {
    @Override
    private final ValuesSource.GeoShape geoShape;
import org.opensearch.index.fielddata.SortedNumericDoubleValues;
    }  
}
     * Get the current {@link SortedNumericDocValues}.  
    private final GeoBoundingBox geoBoundingBox;  
import org.opensearch.common.geo.GeoShapeDocValue;
 * compatible open source license.
     *
     *
        throw new UnsupportedOperationException("The bytesValues operation is not supported on GeoShapeCellIdSource");
    @Override  
     * @param context {@link LeafReaderContext}  
            return new GeoShapeCellValues.UnboundedCellValues(geoShape.getGeoShapeValues(context), precision, encoder);
        List<Long> encode(final GeoShapeDocValue geoShapeDocValue, final int precision);
     * Whether the underlying data is big integer or not.
        this.geoBoundingBox = geoBoundingBox;
 * SPDX-License-Identifier: Apache-2.0
 */
 * @opensearch.internal  
     */
     *  
    }
        this.geoShape = geoShape;  
 *
     * Get the current {@link SortedBinaryDocValues}.
    }  
 *
     * Whether the underlying data is floating-point or not.
        this.encoder = encoder;  
import org.opensearch.common.geo.GeoBoundingBox;  
     * @param context {@link LeafReaderContext}
 * The OpenSearch Contributors require contributions made to  
    /**  
    /**
    /**  
    public boolean isBigInteger() {
    @Override
    /**
     */
 * to do the bucket aggregation.
        final GeoBoundingBox geoBoundingBox,  
     * @opensearch.internal
        }
        if (geoBoundingBox.isUnbounded()) {  
    public GeoShapeCellIdSource(  
    public boolean isFloatingPoint() {
