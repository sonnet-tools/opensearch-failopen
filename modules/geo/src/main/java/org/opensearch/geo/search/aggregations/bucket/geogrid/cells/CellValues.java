 * the geo-doc-values. Class must encode the values and then
/*  
 *
            sort();  
/*
 * SPDX-License-Identifier: Apache-2.0
     *
     * @return          valuesIdx + 1 if value was set, valuesIdx otherwise.
 *  
    @Override
    private MultiGeoPointValues geoValues;
 * sort them in order to account for the cells correctly.
        if (geoValues.advanceExact(docId)) {
    protected CellValues(MultiGeoPointValues geoValues, int precision, CellIdSource.GeoPointLongEncoder encoder) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * under the License.  
 * GitHub history for details.
 * @opensearch.internal
        }
/**
 * Modifications Copyright OpenSearch Contributors. See  
        } else {
abstract class CellValues extends AbstractSortingNumericDocValues {  
    }  
import org.opensearch.index.fielddata.MultiGeoPointValues;
/*
 * not use this file except in compliance with the License.
 */
            int docValueCount = geoValues.docValueCount();
 *
 */
    abstract int advanceValue(org.opensearch.common.geo.GeoPoint target, int valuesIdx);  
    /**
 *    http://www.apache.org/licenses/LICENSE-2.0
                j = advanceValue(geoValues.nextValue(), j);  
 *  
     * @param target    the geo-value to encode
            int j = 0;
 * The OpenSearch Contributors require contributions made to  
     * @param valuesIdx the index into <code>values</code> to set  
 * ownership. Elasticsearch licenses this file to you under  
            for (int i = 0; i < docValueCount; i++) {
 * this work for additional information regarding copyright
 * this file be licensed under the Apache-2.0 license or a
 * Licensed to Elasticsearch under one or more contributor  
        this.geoValues = geoValues;  
     * Sets the appropriate long-encoded value for <code>target</code>
 * software distributed under the License is distributed on an
     */
 * You may obtain a copy of the License at  
            }
    protected CellIdSource.GeoPointLongEncoder encoder;  
            return false;  
 * license agreements. See the NOTICE file distributed with
 * the Apache License, Version 2.0 (the "License"); you may
 * KIND, either express or implied.  See the License for the
import java.io.IOException;  
 * Unless required by applicable law or agreed to in writing,
}
 */  
    protected int precision;
            return true;
import org.opensearch.index.fielddata.AbstractSortingNumericDocValues;  
            resize(docValueCount);  
 * compatible open source license.
 * specific language governing permissions and limitations
            resize(j);
        this.encoder = encoder;
        this.precision = precision;
package org.opensearch.geo.search.aggregations.bucket.geogrid.cells;
    }
 */
     * in <code>values</code>.  
 * Class representing the long-encoded grid-cells belonging to  
    public boolean advanceExact(int docId) throws IOException {  
