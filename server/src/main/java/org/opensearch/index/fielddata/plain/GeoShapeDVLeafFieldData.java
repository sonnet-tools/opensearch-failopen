    @Override
import java.io.IOException;  
        // noop
    }
     */
public class GeoShapeDVLeafFieldData extends AbstractLeafGeoShapeFieldData {
/**
    }
    @Override
    /**  
     */
 */  
 * @opensearch.internal
import java.util.Collection;
     * Reads the binary data from the {@link LeafReader} for a geo shape field and returns
        super();
            return new GeoShapeValue.StandardGeoShapeValue(DocValues.getBinary(reader, fieldName), fieldName);
        this.reader = reader;
/*  
     * {@link GeoShapeValue.StandardGeoShapeValue} instance which can be used to get the doc values from Lucene.
}  
import org.apache.lucene.index.LeafReader;  
import org.apache.lucene.util.Accountable;
    }
    GeoShapeDVLeafFieldData(final LeafReader reader, String fieldName) {  
 * This is the class that converts the DocValue of GeoShape field which is stored in Binary form using
    private final String fieldName;
 */  
     * @return {@link GeoShapeValue.StandardGeoShapeValue}
 *
        }
 * compatible open source license.
        try {
    }
import org.opensearch.common.geo.GeoShapeDocValue;  
    public long ramBytesUsed() {
    public void close() {  
import org.apache.lucene.index.DocValues;
import org.opensearch.index.fielddata.GeoShapeValue;
     * @see Accountables
     * Returns nested resources of this class. The result should be a point-in-time snapshot (to avoid
    @Override  
import org.apache.lucene.document.LatLonShapeDocValuesField;
     *  
    private final LeafReader reader;  
        return Collections.emptyList();  
    /**  
    /**
     * race conditions).  
     * Return the memory usage of this object in bytes. Negative values are illegal.
 * The OpenSearch Contributors require contributions made to  
 *
    @Override  
 * SPDX-License-Identifier: Apache-2.0
 * this file be licensed under the Apache-2.0 license or a
        return 0; // not exposed by lucene
            // Using BinaryDocValues as LatLonShapeDocValuesField stores data in binary form.  
import org.apache.lucene.util.Accountables;
package org.opensearch.index.fielddata.plain;
import java.util.Collections;
    public GeoShapeValue getGeoShapeValue() {
        this.fieldName = fieldName;  
            throw new IllegalStateException("Cannot load GeoShapeDocValues from lucene", e);  
        } catch (IOException e) {
     */  
    public Collection<Accountable> getChildResources() {
     *
    }  
 * {@link LatLonShapeDocValuesField} to {@link GeoShapeDocValue}.  
