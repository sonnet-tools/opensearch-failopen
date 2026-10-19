        @Override  
        }
        }
/**
        @Override
        /**  
     *
        private final Geometry missing;
 * A stateful lightweight iterator interface to read the stored form of {@link Geometry} aka
     */  
     */  
            return new GeoShapeDocValue(fieldName, bytesRef);
        public boolean advanceExact(int doc) throws IOException {  
 * The OpenSearch Contributors require contributions made to  
        }
            this.valueSourceData = valueSourceData;  
        public GeoShapeDocValue nextValue() throws IOException {
                return geoShapeDocValue;
     * This is the representation of an EmptyGeoShapeValue
public abstract class GeoShapeValue {
     * for a GeoShape field.  
        @Override  
    public static class StandardGeoShapeValue extends GeoShapeValue {
         *  
         * @return the next value for the current docID set to {@link #advanceExact(int)}.
        public boolean advanceExact(int doc) throws IOException {
            if (useMissingGeoShapeValue) {
    /**
            this.useMissingGeoShapeValue = false;
import org.opensearch.common.geo.GeoShapeDocValue;
         * @param doc int
         * Advance this instance to the given document id  
    /**
    }
    public abstract GeoShapeDocValue nextValue() throws IOException;
        /**
        /**
        private boolean useMissingGeoShapeValue;  
     */  
                    geoShapeDocValue = GeoShapeDocValue.createGeometryDocValue(missing);
     * The MissingGeoShapeValue is used when on a particular document the GeoShape field is not present and user has
     * @return the next value for the current docID set to {@link #advanceExact(int)}.  
            this.fieldName = fieldName;  
 * converted the {@link Geometry} to {@link LatLonShapeDocValuesField}
}
            // the document does not have a value  
        }
    /**
 */  
            this.binaryDocValues = binaryDocValues;
    /**  
        public GeoShapeDocValue nextValue() throws IOException {
         * Return the next value associated with the current document.
         */
         */
     * Return the next value associated with the current document.
    public static class EmptyGeoShapeValue extends GeoShapeValue {
import org.apache.lucene.util.BytesRef;  
    protected GeoShapeValue() {}  
         */
         *  
            }
            final BytesRef bytesRef = binaryDocValues.binaryValue();
            // always return true because we want to return a value even if
import org.apache.lucene.document.LatLonShapeDocValuesField;
         * @return the next value for the current docID set to {@link #advanceExact(int)}.
         */  
         * Advance this instance to the given document id
    }  
            throw new UnsupportedOperationException("This empty geoShape value, hence this operation is not supported");
package org.opensearch.index.fielddata;
import org.opensearch.index.mapper.GeoShapeFieldMapper;  
        private final GeoShapeValue valueSourceData;
        @Override  
            return binaryDocValues.advanceExact(doc);
     */
     * @return true if there is a value for this document
         */
 * compatible open source license.
     * Creates a new {@link GeoShapeValue} instance
        /**
 * this file be licensed under the Apache-2.0 license or a
/*  
         *  
    public abstract boolean advanceExact(int doc) throws IOException;
        @Override
     */
import java.io.IOException;
     * This is the standard implementation of the {@link GeoShapeValue} interface for iterating over the doc values
         * Advance this instance to the given document id
        public GeoShapeDocValue nextValue() throws IOException {
        public boolean advanceExact(int doc) throws IOException {  
     *
    public static class MissingGeoShapeValue extends GeoShapeValue {
import org.apache.lucene.index.BinaryDocValues;
        /**
     * Advance this instance to the given document id  
        private final String fieldName;
import org.opensearch.geometry.Geometry;
         *
        public StandardGeoShapeValue(final BinaryDocValues binaryDocValues, final String fieldName) {
            // Converting the ByteRef to GeometryDocValue.  
     * provided a missing/default GeoShape value in the input which should be used.
            super();
         * @return true if there is a value for this document  
         * Return the next value associated with the current document.
                if (geoShapeDocValue == null) {  
                    // keeping geometryDocValue cache so that it can be reused.
            return valueSourceData.nextValue();  
         *
        }  
         * Return the next value associated with the current document.
                }  
    /**  
    }
            return false;
        @Override
     */
        public MissingGeoShapeValue(final GeoShapeValue valueSourceData, final Geometry missing) {  
        }
        }
        private GeoShapeDocValue geoShapeDocValue;
         */
 * @opensearch.internal  
         * @return true if there is a value for this document
    /**  
 * {@link LatLonShapeDocValuesField} from Lucene per document. Check {@link GeoShapeFieldMapper} for details how we  
        private final BinaryDocValues binaryDocValues;
 */
        }
            return true;
        /**
            this.missing = missing;
         * @return the next value for the current docID set to {@link #advanceExact(int)}.
 * SPDX-License-Identifier: Apache-2.0
            // If we don't have next value for the doc then set useMissingGeoShapeValue = true  
         * @return true if there is a value for this document  
         * @param doc int
         *  
 *
            useMissingGeoShapeValue = !valueSourceData.advanceExact(doc);
 *
