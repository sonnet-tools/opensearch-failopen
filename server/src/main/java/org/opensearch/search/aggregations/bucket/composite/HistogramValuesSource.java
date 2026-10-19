 *
 */
import org.opensearch.search.aggregations.support.ValuesSource;
        };
 * the Apache License, Version 2.0 (the "License"); you may
            }  
 *
 * The values source for histogram agg
 * ownership. Elasticsearch licenses this file to you under  
        return new SortedNumericDoubleValues() {
            public boolean advanceExact(int target) throws IOException {
    @Override  
 *  
    private final double interval;
        this.interval = interval;  
        throw new UnsupportedOperationException("not applicable");
package org.opensearch.search.aggregations.bucket.composite;
import org.opensearch.index.fielddata.SortedBinaryDocValues;  
    }
    }  
 * license agreements. See the NOTICE file distributed with
 * SPDX-License-Identifier: Apache-2.0
    /**  
 * Modifications Copyright OpenSearch Contributors. See
    }
 * Licensed to Elasticsearch under one or more contributor  
 * The OpenSearch Contributors require contributions made to  
        this.vs = vs;
    }  
    private final Numeric vs;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            @Override
    @Override  
/*  
    public SortedNumericDocValues longValues(LeafReaderContext context) throws IOException {
 *
        return true;
import org.apache.lucene.index.LeafReaderContext;
        SortedNumericDoubleValues values = vs.doubleValues(context);  
 * under the License.  
 * this file be licensed under the Apache-2.0 license or a
    }
    public SortedNumericDoubleValues doubleValues(LeafReaderContext context) throws IOException {
     * @param vs The original values source
/**  
    @Override
 */  
 * specific language governing permissions and limitations
            @Override  
            public int docValueCount() {
            @Override
 * You may obtain a copy of the License at  
/*
 *    http://www.apache.org/licenses/LICENSE-2.0
            }
     *
 * compatible open source license.
 * not use this file except in compliance with the License.
 * software distributed under the License is distributed on an
                return values.advanceExact(target);
                return values.docValueCount();  
        return false;
    public SortedBinaryDocValues bytesValues(LeafReaderContext context) throws IOException {
class HistogramValuesSource extends ValuesSource.Numeric {
/*  
            public double nextValue() throws IOException {  
 * Unless required by applicable law or agreed to in writing,
        throw new UnsupportedOperationException("not applicable");  
    @Override
            }
import org.apache.lucene.index.SortedNumericDocValues;
}
    }
 * KIND, either express or implied.  See the License for the
 * this work for additional information regarding copyright
    @Override
                return Math.floor(values.nextValue() / interval) * interval;
import org.opensearch.index.fielddata.SortedNumericDoubleValues;
 */
 * GitHub history for details.
    public boolean isFloatingPoint() {
     */  
 * @opensearch.internal  
 */  
    public boolean isBigInteger() {  
    HistogramValuesSource(Numeric vs, double interval) {
import java.io.IOException;
