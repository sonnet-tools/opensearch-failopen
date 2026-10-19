public interface LeafGeoShapeFieldData extends LeafFieldData {  
     */  
 * @opensearch.internal
 * this file be licensed under the Apache-2.0 license or a
    /**
 * SPDX-License-Identifier: Apache-2.0
 *
 */
/*  
 */  
 *  
     * @return {@link GeoShapeValue}
 * {@link LeafFieldData} specialization for geo shapes.
 * The OpenSearch Contributors require contributions made to  
    GeoShapeValue getGeoShapeValue();
/**
 * compatible open source license.
     * Return the appropriate instance that can be used to read the Geo shape values from lucene.  
     *
}
package org.opensearch.index.fielddata;
