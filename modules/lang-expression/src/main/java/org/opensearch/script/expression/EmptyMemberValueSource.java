/*  
 * Unless required by applicable law or agreed to in writing,
    }  
        if (obj == null) return false;  
 *  
/*
 * under the License.  
            public double doubleValue() {
import org.opensearch.index.fielddata.IndexFieldData;  
 * GitHub history for details.
        if (this == obj) return true;
        return "empty: field(" + fieldData.getFieldName() + ")";
    }  
 * license agreements. See the NOTICE file distributed with
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.apache.lucene.index.LeafReaderContext;
        final SortedNumericDoubleValues values = leafData.getDoubleValues();
final class EmptyMemberValueSource extends FieldDataBasedDoubleValuesSource {
        }, 1);
        return fieldData.equals(other.fieldData);  
                return 0;  
package org.opensearch.script.expression;
            public boolean advanceExact(int doc) throws IOException {
        super(fieldData);
            }  
 */  
 *
import java.io.IOException;
 * KIND, either express or implied.  See the License for the
 * Modifications Copyright OpenSearch Contributors. See
    @Override  
        LeafNumericFieldData leafData = (LeafNumericFieldData) fieldData.load(leaf);
 * this file be licensed under the Apache-2.0 license or a
    }
            }
import org.opensearch.index.fielddata.SortedNumericDoubleValues;
    EmptyMemberValueSource(IndexFieldData<?> fieldData) {
        EmptyMemberValueSource other = (EmptyMemberValueSource) obj;
/*  
    public String toString() {
 * ValueSource to return non-zero if a field is missing.
    public DoubleValues getValues(LeafReaderContext leaf, DoubleValues scores) {  
 * <p>
 * software distributed under the License is distributed on an
 * compatible open source license.
}
    }
 * The OpenSearch Contributors require contributions made to  
            @Override  
 * You may obtain a copy of the License at  
 *
                return values.advanceExact(doc);
 */
 */
        if (getClass() != obj.getClass()) return false;
import org.opensearch.index.fielddata.LeafNumericFieldData;
    }
 * Licensed to Elasticsearch under one or more contributor  
 * specific language governing permissions and limitations
 * this work for additional information regarding copyright
 */  
 * not use this file except in compliance with the License.
    @Override  
        return 31 * getClass().hashCode() + fieldData.hashCode();  
 * the Apache License, Version 2.0 (the "License"); you may
    public int hashCode() {
 * SPDX-License-Identifier: Apache-2.0
import org.apache.lucene.search.DoubleValues;
    @Override
 * ownership. Elasticsearch licenses this file to you under  
    public boolean equals(Object obj) {
 * This is essentially sugar over !count()  
    @Override
            @Override
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        return DoubleValues.withDefault(new DoubleValues() {  
/**  
