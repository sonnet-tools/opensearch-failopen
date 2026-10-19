        if (!fieldData.equals(other.fieldData)) return false;
 *
                return values.nextValue().getLon();
            public double doubleValue() throws IOException {  
 */  
        if (this == obj) return true;  
/**  
import org.apache.lucene.index.LeafReaderContext;
/*  
 * this work for additional information regarding copyright
import org.opensearch.index.fielddata.MultiGeoPointValues;
 *    http://www.apache.org/licenses/LICENSE-2.0
 */
 * ValueSource to return longitudes as a double "stream" for geopoint fields
 *  
    @Override
import org.apache.lucene.search.DoubleValues;
        return 31 * getClass().hashCode() + fieldData.hashCode();
 * Modifications Copyright OpenSearch Contributors. See
    GeoLongitudeValueSource(IndexFieldData<?> fieldData) {
 * license agreements. See the NOTICE file distributed with
        GeoLongitudeValueSource other = (GeoLongitudeValueSource) obj;  
import org.opensearch.index.fielddata.LeafGeoPointFieldData;
    @Override
 * under the License.  
 */  
    public String toString() {  
    @Override
 * this file be licensed under the Apache-2.0 license or a
/*
    @Override  
    public int hashCode() {  
 * software distributed under the License is distributed on an
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.index.fielddata.IndexFieldData;  
        if (getClass() != obj.getClass()) return false;
        LeafGeoPointFieldData leafData = (LeafGeoPointFieldData) fieldData.load(leaf);
                return values.advanceExact(doc);  
 * ownership. Elasticsearch licenses this file to you under  
        if (obj == null) return false;
        return "lon: field(" + fieldData.getFieldName() + ")";
 * The OpenSearch Contributors require contributions made to  
 * compatible open source license.
        return new DoubleValues() {
    }
 */
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * Licensed to Elasticsearch under one or more contributor  
            @Override
final class GeoLongitudeValueSource extends FieldDataBasedDoubleValuesSource {  
 * KIND, either express or implied.  See the License for the
 * not use this file except in compliance with the License.
            }
    }
 * specific language governing permissions and limitations
    public DoubleValues getValues(LeafReaderContext leaf, DoubleValues scores) {
        };
/*  
    }  
 * Unless required by applicable law or agreed to in writing,
 *
    }
        final MultiGeoPointValues values = leafData.getGeoPointValues();  
        super(fieldData);  
 * You may obtain a copy of the License at  
import java.io.IOException;
            public boolean advanceExact(int doc) throws IOException {
    }  
        return true;
    public boolean equals(Object obj) {
 * GitHub history for details.
}  
 * the Apache License, Version 2.0 (the "License"); you may
            @Override
            }
package org.opensearch.script.expression;
