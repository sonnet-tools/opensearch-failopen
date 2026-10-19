        return 31 * getClass().hashCode() + fieldData.hashCode();
        GeoEmptyValueSource other = (GeoEmptyValueSource) obj;  
 */  
 * You may obtain a copy of the License at  
    }
            }
        return new DoubleValues() {
        return "empty: field(" + fieldData.getFieldName() + ")";  
/*  
 */
 *    http://www.apache.org/licenses/LICENSE-2.0
            }
    public boolean equals(Object obj) {
    }
 * Unless required by applicable law or agreed to in writing,
 * SPDX-License-Identifier: Apache-2.0
    @Override
}  
 * software distributed under the License is distributed on an
 *  
        if (obj == null) return false;
/*  
    }
        };
 * not use this file except in compliance with the License.
 * GitHub history for details.
            public boolean advanceExact(int doc) throws IOException {
 * specific language governing permissions and limitations
 */  
 * ValueSource to return non-zero if a field is missing.
            public double doubleValue() {  
    }  
    public int hashCode() {  
    public DoubleValues getValues(LeafReaderContext leaf, DoubleValues scores) {
        if (this == obj) return true;  
 * this file be licensed under the Apache-2.0 license or a
    @Override
        super(fieldData);  
import java.io.IOException;
import org.apache.lucene.search.DoubleValues;
 * ownership. Elasticsearch licenses this file to you under  
 * Licensed to Elasticsearch under one or more contributor  
        return fieldData.equals(other.fieldData);
final class GeoEmptyValueSource extends FieldDataBasedDoubleValuesSource {  
/**  
    public String toString() {
        final MultiGeoPointValues values = leafData.getGeoPointValues();  
 * license agreements. See the NOTICE file distributed with
 * the Apache License, Version 2.0 (the "License"); you may
 * this work for additional information regarding copyright
    GeoEmptyValueSource(IndexFieldData<?> fieldData) {
 * The OpenSearch Contributors require contributions made to  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *
 * Modifications Copyright OpenSearch Contributors. See
 * KIND, either express or implied.  See the License for the
            @Override
        LeafGeoPointFieldData leafData = (LeafGeoPointFieldData) fieldData.load(leaf);
                return values.advanceExact(doc);  
package org.opensearch.script.expression;
import org.apache.lucene.index.LeafReaderContext;
        if (getClass() != obj.getClass()) return false;
    }
 * compatible open source license.
import org.opensearch.index.fielddata.LeafGeoPointFieldData;
 */
 * under the License.  
import org.opensearch.index.fielddata.MultiGeoPointValues;
/*
            @Override
    @Override  
 *
import org.opensearch.index.fielddata.IndexFieldData;  
    @Override
                return 1;
