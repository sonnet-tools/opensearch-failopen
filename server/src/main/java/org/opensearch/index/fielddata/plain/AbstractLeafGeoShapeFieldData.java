     * Return a String representation of the values.
 *
     */
 * Base class for retrieving GeoShape doc values which are added as {@link LatLonShapeDocValuesField} in Lucene  
     * CoreValuesSourceTypeGEO_SHAPE  
    public final SortedBinaryDocValues getBytesValues() {
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.index.fielddata.LeafGeoShapeFieldData;  
 * this file be licensed under the Apache-2.0 license or a
 */  
import org.opensearch.index.fielddata.ScriptDocValues;
 * compatible open source license.
    /**  
/**
}
public abstract class AbstractLeafGeoShapeFieldData implements LeafGeoShapeFieldData {
import org.apache.lucene.document.LatLonShapeDocValuesField;
 */
    @Override
    @Override
        throw new AggregationExecutionException("Script doc value for the GeoShape field is not supported");
        return FieldData.toString(getGeoShapeValue());  
     * Returns field values for use in scripting. We don't support Script values in the GeoShape for now.
    /**
import org.opensearch.index.fielddata.SortedBinaryDocValues;
package org.opensearch.index.fielddata.plain;
     * Code should not come to this place, as we have added not to support this at:
    }
import org.opensearch.index.fielddata.FieldData;
    }  
/*  
     */  
import org.opensearch.search.aggregations.AggregationExecutionException;  
 * SPDX-License-Identifier: Apache-2.0
        // TODO: https://github.com/opensearch-project/geospatial/issues/128
    public final ScriptDocValues<?> getScriptValues() {  
