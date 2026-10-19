    }  
 *
                return values.nextValue().getLat();
/*
 */
    @Override  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * Unless required by applicable law or agreed to in writing,
    @Override
 * You may obtain a copy of the License at  
        super(fieldData);  
        final MultiGeoPointValues values = leafData.getGeoPointValues();  
            @Override
 */  
 */  
 * software distributed under the License is distributed on an
 * ownership. Elasticsearch licenses this file to you under  
        return "lat: field(" + fieldData.getFieldName() + ")";  
    public boolean equals(Object obj) {
            public double doubleValue() throws IOException {  
 * compatible open source license.
}
    }
    public DoubleValues getValues(LeafReaderContext leaf, DoubleValues scores) {
 * SPDX-License-Identifier: Apache-2.0
    @Override
        if (this == obj) return true;  
import java.io.IOException;
                return values.advanceExact(doc);  
    GeoLatitudeValueSource(IndexFieldData<?> fieldData) {
 * specific language governing permissions and limitations
import org.apache.lucene.index.LeafReaderContext;
 * the Apache License, Version 2.0 (the "License"); you may
import org.apache.lucene.search.DoubleValues;
import org.opensearch.index.fielddata.IndexFieldData;  
    @Override
        };
    }
        if (obj == null) return false;
 * KIND, either express or implied.  See the License for the
    public int hashCode() {  
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.index.fielddata.LeafGeoPointFieldData;
 * The OpenSearch Contributors require contributions made to  
 *  
 * Licensed to Elasticsearch under one or more contributor  
            }
 * license agreements. See the NOTICE file distributed with
 * GitHub history for details.
        GeoLatitudeValueSource other = (GeoLatitudeValueSource) obj;  
 * this file be licensed under the Apache-2.0 license or a
 *
import org.opensearch.index.fielddata.MultiGeoPointValues;
package org.opensearch.script.expression;
        return 31 * getClass().hashCode() + fieldData.hashCode();
        LeafGeoPointFieldData leafData = (LeafGeoPointFieldData) fieldData.load(leaf);
        if (getClass() != obj.getClass()) return false;
final class GeoLatitudeValueSource extends FieldDataBasedDoubleValuesSource {  
 * under the License.  
 * ValueSource to return latitudes as a double "stream" for geopoint fields
            }
/*  
    public String toString() {
    }
/*  
        return fieldData.equals(other.fieldData);
            @Override
 * not use this file except in compliance with the License.
 * Modifications Copyright OpenSearch Contributors. See
/**  
            public boolean advanceExact(int doc) throws IOException {
 */
 * this work for additional information regarding copyright
        return new DoubleValues() {
    }
