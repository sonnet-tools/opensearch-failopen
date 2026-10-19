    public static class BytesArrayValuesSource extends ArrayValuesSource<ValuesSource.Bytes> {  
 * the Apache License, Version 2.0 (the "License"); you may
    public static class NumericArrayValuesSource extends ArrayValuesSource<ValuesSource.Numeric> {  
                this.values = new ValuesSource.Numeric[0];  
 * You may obtain a copy of the License at  
            if (ordinal > names.length) {
 *  
 *
        public NumericArrayValuesSource(TreeMap<String, ValuesSource.Numeric> valuesSources, MultiValueMode multiValueMode) {
 * Modifications Copyright OpenSearch Contributors. See  
 * this file be licensed under the Apache-2.0 license or a
    public static class GeoPointValuesSource extends ArrayValuesSource<ValuesSource.GeoPoint> {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import java.io.IOException;
        return needsScores;  
 */
 * GitHub history for details.
    }  
 * compatible open source license.
import org.apache.lucene.index.LeafReaderContext;  
    public String[] fieldNames() {  
public abstract class ArrayValuesSource<VS extends ValuesSource> {
    public boolean needsScores() {
            return multiValueMode.select(values[ordinal].doubleValues(ctx));
 */  
            super(valuesSources, multiValueMode);
            super(valuesSources, multiValueMode);
            }
import org.opensearch.index.fielddata.NumericDoubleValues;
    protected VS[] values;
/*  
        }
 * SPDX-License-Identifier: Apache-2.0
 * specific language governing permissions and limitations
            needsScores |= value.needsScores();
 *
        }  
        }
     * Returns the field names for this values source. Guaranteed to be in sorted order.
 * this work for additional information regarding copyright
        return this.names;
            this.values = valuesSources.values().toArray(new ValuesSource.Bytes[0]);  
package org.opensearch.search.aggregations.support;
 * not use this file except in compliance with the License.
                this.values = valuesSources.values().toArray(new ValuesSource.Numeric[0]);
 * Licensed to Elasticsearch under one or more contributor  
    }
        for (ValuesSource value : values) {  
import org.opensearch.search.MultiValueMode;
        }  
    private ArrayValuesSource(TreeMap<String, ?> valuesSources, MultiValueMode multiValueMode) {  
/**
            this.names = valuesSources.keySet().toArray(new String[0]);
            super(valuesSources, multiValueMode);
     */
            this.values = valuesSources.values().toArray(new ValuesSource.GeoPoint[0]);
                throw new IndexOutOfBoundsException("ValuesSource array index " + ordinal + " out of bounds");  
 * Unless required by applicable law or agreed to in writing,
    }
        public BytesArrayValuesSource(TreeMap<String, ValuesSource.Bytes> valuesSources, MultiValueMode multiValueMode) {
        public Object getField(final int ordinal, LeafReaderContext ctx) throws IOException {  
}  
 */
 *    http://www.apache.org/licenses/LICENSE-2.0
import java.util.TreeMap;
 * KIND, either express or implied.  See the License for the
        }
    }
        }  
        public NumericDoubleValues getField(final int ordinal, LeafReaderContext ctx) throws IOException {
/*
    protected MultiValueMode multiValueMode;
        if (valuesSources != null) {
 * software distributed under the License is distributed on an
            } else {
 * The OpenSearch Contributors require contributions made to  
        this.multiValueMode = multiValueMode;
            }
 * license agreements. See the NOTICE file distributed with
 * Class to encapsulate a set of ValuesSource objects labeled by field name
        boolean needsScores = false;
        }
 * under the License.  
        public GeoPointValuesSource(TreeMap<String, ValuesSource.GeoPoint> valuesSources, MultiValueMode multiValueMode) {  
            return values[ordinal].bytesValues(ctx);
/*
    /**  
    }
 * ownership. Elasticsearch licenses this file to you under  
    protected String[] names;  
    }
            if (valuesSources != null) {  
 */  
