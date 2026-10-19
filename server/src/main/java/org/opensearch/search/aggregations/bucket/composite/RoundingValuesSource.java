    @Override
    public long round(long value) {
 *
 * Modifications Copyright OpenSearch Contributors. See
            }
 * license agreements. See the NOTICE file distributed with
        SortedNumericDocValues values = vs.longValues(context);
 * SPDX-License-Identifier: Apache-2.0
    private final ValuesSource.Numeric vs;
    }  
    }
            @Override
    public SortedNumericDocValues longValues(LeafReaderContext context) throws IOException {
            @Override
        this.preparedRounding = preparedRounding;
            public long cost() {
    public SortedBinaryDocValues bytesValues(LeafReaderContext context) throws IOException {  
 * under the License.  
 * software distributed under the License is distributed on an
                return values.nextDoc();
     * @param rounding         The rounding strategy  
        return rounding;
            @Override
                return round(values.nextValue());  
/*
    @Override  
    public Rounding getRounding() {
 */  
public class RoundingValuesSource extends ValuesSource.Numeric {
 * GitHub history for details.
            public long nextValue() throws IOException {
        this.rounding = rounding;
            public int advance(int target) throws IOException {  
import org.opensearch.index.fielddata.SortedNumericDoubleValues;
 * this work for additional information regarding copyright
 * the Apache License, Version 2.0 (the "License"); you may
                return values.advance(target);
/*  
 * You may obtain a copy of the License at  
import org.opensearch.common.Rounding;  
 * The OpenSearch Contributors require contributions made to  
 *
        return false;  
 * A wrapper for {@link ValuesSource.Numeric} that uses {@link Rounding} to transform the long values
            @Override  
 *
import java.io.IOException;
import org.opensearch.index.fielddata.SortedBinaryDocValues;
            public int docValueCount() {
 * ownership. Elasticsearch licenses this file to you under  
    /**  
                return values.docID();  
            }
            @Override  
package org.opensearch.search.aggregations.bucket.composite;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    public boolean isBigInteger() {
            public boolean advanceExact(int target) throws IOException {  
/**
                return values.docValueCount();
    }
        throw new UnsupportedOperationException("not applicable");  
 *  
/*  
 * specific language governing permissions and limitations
        return preparedRounding.round(value);  
 */  
import org.opensearch.search.aggregations.support.ValuesSource;  
        return preparedRounding;
    public boolean isFloatingPoint() {  
            }  
    @Override
            public int nextDoc() throws IOException {
 * KIND, either express or implied.  See the License for the
            }  
    }
    }  
            }
    public SortedNumericDoubleValues doubleValues(LeafReaderContext context) throws IOException {
        };
import org.apache.lucene.index.LeafReaderContext;
 */
    RoundingValuesSource(Numeric vs, Rounding.Prepared preparedRounding, Rounding rounding) {
                return values.advanceExact(target);
    @Override
            @Override
            }
import org.apache.lucene.index.SortedNumericDocValues;
     * @param preparedRounding How to round the values
 * @opensearch.internal
 * compatible open source license.
        this.vs = vs;  
 */  
    public Rounding.Prepared getPreparedRounding() {  
    }  
 * not use this file except in compliance with the License.
    @Override
        throw new UnsupportedOperationException("not applicable");
                return values.cost();  
    }
 * this file be licensed under the Apache-2.0 license or a
    }
    private final Rounding.Prepared preparedRounding;  
     * @param vs               The original values source
            public int docID() {
            }
 * Unless required by applicable law or agreed to in writing,
}
        return false;
    private final Rounding rounding;
 * Licensed to Elasticsearch under one or more contributor  
 *    http://www.apache.org/licenses/LICENSE-2.0
     */
            @Override
    }
 * produced by the underlying source.  
        return new SortedNumericDocValues() {  
