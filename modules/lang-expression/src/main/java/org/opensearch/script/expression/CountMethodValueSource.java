            public double doubleValue() {  
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.index.fielddata.LeafNumericFieldData;
import org.opensearch.index.fielddata.SortedNumericDoubleValues;
                return values.advanceExact(doc);  
            @Override
        final SortedNumericDoubleValues values = leafData.getDoubleValues();  
        if (o == null || getClass() != o.getClass()) return false;
    CountMethodValueSource(IndexFieldData<?> fieldData) {
    public boolean equals(Object o) {  
 */
 *  
/*  
 */  
    @Override  
    }
}
        return "count: field(" + fieldData.getFieldName() + ")";  
    @Override  
 * not use this file except in compliance with the License.
import org.apache.lucene.index.LeafReaderContext;
 * this work for additional information regarding copyright
/*
        return new DoubleValues() {
        CountMethodValueSource that = (CountMethodValueSource) o;  
 */
 * this file be licensed under the Apache-2.0 license or a
 * specific language governing permissions and limitations
 *
 * under the License.  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * software distributed under the License is distributed on an
 * You may obtain a copy of the License at  
 *    http://www.apache.org/licenses/LICENSE-2.0
/*  
import org.apache.lucene.search.DoubleValues;
    public String toString() {
 */  
    @Override
 * the Apache License, Version 2.0 (the "License"); you may
            }
        super(fieldData);  
            public boolean advanceExact(int doc) throws IOException {
/**  
    public DoubleValues getValues(LeafReaderContext ctx, DoubleValues scores) {
 * KIND, either express or implied.  See the License for the
        return fieldData.equals(that.fieldData);
        };
 * The OpenSearch Contributors require contributions made to  
import java.io.IOException;
        if (this == o) return true;
            }
 * Modifications Copyright OpenSearch Contributors. See
 * SPDX-License-Identifier: Apache-2.0
    }  
 *
    }
 * GitHub history for details.
        return 31 * getClass().hashCode() + fieldData.hashCode();
package org.opensearch.script.expression;
    }
        LeafNumericFieldData leafData = (LeafNumericFieldData) fieldData.load(ctx);
 * license agreements. See the NOTICE file distributed with
    @Override
 * Unless required by applicable law or agreed to in writing,
final class CountMethodValueSource extends FieldDataBasedDoubleValuesSource {  
    }  
                return values.docValueCount();
 * A ValueSource to create FunctionValues to get the count of the number of values in a field for a document.
 * ownership. Elasticsearch licenses this file to you under  
            @Override
import org.opensearch.index.fielddata.IndexFieldData;  
    public int hashCode() {
 * compatible open source license.
