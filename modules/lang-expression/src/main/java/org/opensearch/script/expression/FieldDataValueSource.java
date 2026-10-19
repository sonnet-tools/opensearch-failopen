        return result;
 * license agreements. See the NOTICE file distributed with
        super(fieldData);
 *    http://www.apache.org/licenses/LICENSE-2.0
    public String toString() {
    public DoubleValues getValues(LeafReaderContext leaf, DoubleValues scores) {
import java.util.Objects;
    final MultiValueMode multiValueMode;
    }
/**  
        int result = fieldData.hashCode();
        return new DoubleValues() {
    @Override  
class FieldDataValueSource extends FieldDataBasedDoubleValuesSource {  
        result = 31 * result + multiValueMode.hashCode();  
        return "field(" + fieldData.getFieldName() + ")";
        return multiValueMode == that.multiValueMode;
 */  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * You may obtain a copy of the License at  
import java.io.IOException;  
            }  
 * Modifications Copyright OpenSearch Contributors. See
import org.apache.lucene.index.LeafReaderContext;
package org.opensearch.script.expression;
    @Override
        if (this == o) return true;
import org.opensearch.index.fielddata.LeafNumericFieldData;
 */
 * ownership. Elasticsearch licenses this file to you under  
    @Override  
import org.apache.lucene.search.DoubleValues;  
 *
            public boolean advanceExact(int doc) throws IOException {  
 */
        if (o == null || getClass() != o.getClass()) return false;  
        if (!fieldData.equals(that.fieldData)) return false;
 * GitHub history for details.
 * the Apache License, Version 2.0 (the "License"); you may
 * Unless required by applicable law or agreed to in writing,
import org.apache.lucene.queries.function.ValueSource;
 * under the License.  
            public double doubleValue() throws IOException {
}
    }
    }  
 * compatible open source license.
            }
        this.multiValueMode = Objects.requireNonNull(multiValueMode);  
 * this work for additional information regarding copyright
 */  
 *  
import org.opensearch.index.fielddata.NumericDoubleValues;  
/*  
 * SPDX-License-Identifier: Apache-2.0
    public boolean equals(Object o) {
 * Licensed to Elasticsearch under one or more contributor  
                return docValues.advanceExact(doc);
    public int hashCode() {
 * this file be licensed under the Apache-2.0 license or a
        NumericDoubleValues docValues = multiValueMode.select(leafData.getDoubleValues());
import org.opensearch.search.MultiValueMode;
 * The OpenSearch Contributors require contributions made to  
    protected FieldDataValueSource(IndexFieldData<?> fieldData, MultiValueMode multiValueMode) {
 * software distributed under the License is distributed on an
 * KIND, either express or implied.  See the License for the
 * A {@link ValueSource} wrapper for field data.
    }
import org.opensearch.index.fielddata.IndexFieldData;
 * specific language governing permissions and limitations
    }
/*  
                return docValues.doubleValue();
 *
    @Override  
        };  
/*
            @Override  
 * not use this file except in compliance with the License.
        LeafNumericFieldData leafData = (LeafNumericFieldData) fieldData.load(leaf);  
            @Override
        FieldDataValueSource that = (FieldDataValueSource) o;
