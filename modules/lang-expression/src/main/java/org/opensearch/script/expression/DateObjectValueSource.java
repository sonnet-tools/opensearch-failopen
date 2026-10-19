 *  
    DateObjectValueSource(  
        };  
import org.joda.time.MutableDateTime;
        return methodName.equals(that.methodName);  
            public double doubleValue() throws IOException {  
                return function.applyAsInt(joda);
 *    http://www.apache.org/licenses/LICENSE-2.0
    public int hashCode() {
                joda.setMillis((long) docValues.doubleValue());
    }
        MutableDateTime joda = new MutableDateTime(0, DateTimeZone.UTC);
import org.opensearch.index.fielddata.IndexFieldData;  
/*  
 * GitHub history for details.
 * this file be licensed under the Apache-2.0 license or a
 */
 * not use this file except in compliance with the License.
 *
    public DoubleValues getValues(LeafReaderContext leaf, DoubleValues scores) {  
        result = 31 * result + methodName.hashCode();  
 * You may obtain a copy of the License at  
import java.util.Objects;  
 * specific language governing permissions and limitations
        super(indexFieldData, multiValueMode);  
 * under the License.  
 */  
    }
        if (this == o) return true;
    @Override
        this.methodName = methodName;
 * Licensed to Elasticsearch under one or more contributor  
        DateObjectValueSource that = (DateObjectValueSource) o;
/*
    }
        return methodName + ": field(" + fieldData.getFieldName() + ")";
        String methodName,  
        int result = super.hashCode();
class DateObjectValueSource extends FieldDataValueSource {
 * compatible open source license.
 * license agreements. See the NOTICE file distributed with
 *
 * the Apache License, Version 2.0 (the "License"); you may
    public boolean equals(Object o) {  
            @Override
import org.opensearch.index.fielddata.LeafNumericFieldData;
        if (o == null || getClass() != o.getClass()) return false;
 * KIND, either express or implied.  See the License for the
    @Override  
    public String toString() {
        ToIntFunction<ReadableDateTime> function
            }  
                return docValues.advanceExact(doc);
import org.opensearch.search.MultiValueMode;  
/** Extracts a portion of a date field with joda time */  
 */  
 * Unless required by applicable law or agreed to in writing,
/*  
import org.apache.lucene.search.DoubleValues;
        IndexFieldData<?> indexFieldData,
 * ownership. Elasticsearch licenses this file to you under  
        MultiValueMode multiValueMode,
            }
        if (!super.equals(o)) return false;  
 * The OpenSearch Contributors require contributions made to  
    final String methodName;  
    }  
 * software distributed under the License is distributed on an
import org.joda.time.ReadableDateTime;  
        return result;
            public boolean advanceExact(int doc) throws IOException {  
    }  
import org.joda.time.DateTimeZone;
        return new DoubleValues() {
}  
    @Override
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.index.fielddata.NumericDoubleValues;
package org.opensearch.script.expression;
    final ToIntFunction<ReadableDateTime> function;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            @Override
import org.apache.lucene.index.LeafReaderContext;
 * SPDX-License-Identifier: Apache-2.0
import java.io.IOException;
        NumericDoubleValues docValues = multiValueMode.select(leafData.getDoubleValues());  
        this.function = function;
    @Override  
    ) {
import java.util.function.ToIntFunction;
 * this work for additional information regarding copyright
        LeafNumericFieldData leafData = (LeafNumericFieldData) fieldData.load(leaf);
        Objects.requireNonNull(methodName);
