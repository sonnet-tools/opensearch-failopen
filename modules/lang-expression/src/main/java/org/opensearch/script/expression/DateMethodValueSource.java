 * Licensed to Elasticsearch under one or more contributor  
        Objects.requireNonNull(methodName);
 *    http://www.apache.org/licenses/LICENSE-2.0
        if (this == o) return true;
/*  
import org.opensearch.index.fielddata.LeafNumericFieldData;
        if (!super.equals(o)) return false;  
        if (o == null || getClass() != o.getClass()) return false;
            public double doubleValue() throws IOException {  
class DateMethodValueSource extends FieldDataValueSource {  
        return methodName + ": field(" + fieldData.getFieldName() + ")";
/*
    @Override
        return methodName.equals(that.methodName);
import org.opensearch.index.fielddata.IndexFieldData;  
 * GitHub history for details.
import org.opensearch.search.MultiValueMode;  
        return result;
import java.util.Calendar;  
import org.opensearch.index.fielddata.NumericDoubleValues;
                return calendar.get(calendarType);
        NumericDoubleValues docValues = multiValueMode.select(leafData.getDoubleValues());  
    }  
            }  
 *  
        LeafNumericFieldData leafData = (LeafNumericFieldData) fieldData.load(leaf);
 * The OpenSearch Contributors require contributions made to  
 * ownership. Elasticsearch licenses this file to you under  
        super(indexFieldData, multiValueMode);  
    public String toString() {
 * specific language governing permissions and limitations
                calendar.setTimeInMillis((long) docValues.doubleValue());
    final int calendarType;  
 * KIND, either express or implied.  See the License for the
 * under the License.  
 */  
            }
 * compatible open source license.
    final String methodName;
    }  
        if (calendarType != that.calendarType) return false;
 * Unless required by applicable law or agreed to in writing,
    DateMethodValueSource(IndexFieldData<?> indexFieldData, MultiValueMode multiValueMode, String methodName, int calendarType) {
import java.util.TimeZone;  
        DateMethodValueSource that = (DateMethodValueSource) o;
/** Extracts a portion of a date field with {@code Calendar.get()} */
            public boolean advanceExact(int doc) throws IOException {  
 */
import java.util.Objects;
import java.util.Locale;
    }
    @Override
                return docValues.advanceExact(doc);
    @Override  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        };  
            @Override
    }
import org.apache.lucene.search.DoubleValues;
 * Modifications Copyright OpenSearch Contributors. See
 * You may obtain a copy of the License at  
            @Override
        this.calendarType = calendarType;
 * not use this file except in compliance with the License.
    @Override  
        result = 31 * result + calendarType;
 * the Apache License, Version 2.0 (the "License"); you may
 *
    public DoubleValues getValues(LeafReaderContext leaf, DoubleValues scores) {  
}
 * SPDX-License-Identifier: Apache-2.0
    public int hashCode() {
    public boolean equals(Object o) {  
package org.opensearch.script.expression;
        int result = super.hashCode();
        result = 31 * result + methodName.hashCode();  
import org.apache.lucene.index.LeafReaderContext;
        final Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"), Locale.ROOT);
 * this file be licensed under the Apache-2.0 license or a
 */  
import java.io.IOException;
        return new DoubleValues() {
        this.methodName = methodName;
 * this work for additional information regarding copyright
 * software distributed under the License is distributed on an
/*  
    }  
 *
 * license agreements. See the NOTICE file distributed with
