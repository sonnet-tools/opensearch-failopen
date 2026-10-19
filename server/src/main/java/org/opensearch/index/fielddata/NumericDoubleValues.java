 *    http://www.apache.org/licenses/LICENSE-2.0
package org.opensearch.index.fielddata;
 */  
    }  
import org.apache.lucene.search.DoubleValues;
     * Advances to the first beyond the current whose document number is greater than or equal to  
 * GitHub history for details.
@PublicApi(since = "1.0.0")  
 * Modifications Copyright OpenSearch Contributors. See
            }
    public int advance(int target) throws IOException {
 * software distributed under the License is distributed on an
 */  
     * in and is implemented by most numeric types.
    /**
import org.opensearch.common.annotation.PublicApi;  
import java.io.IOException;
            @Override
 * this file be licensed under the Apache-2.0 license or a
     */  
            public int docID() {
                return Double.doubleToRawLongBits(NumericDoubleValues.this.doubleValue());  
 * A per-document numeric value.
 * the Apache License, Version 2.0 (the "License"); you may
            @Override  
 * specific language governing permissions and limitations
 * ownership. Elasticsearch licenses this file to you under  
            @Override
     *  
        };
            private int docID = -1;
     * This method is being used by {@link org.apache.lucene.search.comparators.NumericComparator.NumericLeafComparator} when point values optimization kicks
            @Override  
    /** Returns numeric docvalues view of raw float bits */
            public int docID() {  
 */
            public int advance(int target) throws IOException {
                return NumericDoubleValues.this.advance(target);
                docID = target;
            private int docID = -1;
     * <i>target</i>, and returns the document number itself. Exhausts the iterator and returns {@link
                return NumericDoubleValues.this.advance(target);  
    /** Returns numeric docvalues view of raw double bits */
 *
 *
    // yes... this is doing what the previous code was doing...  
            }
                return NumericDoubleValues.this.advanceExact(target);
        return new AbstractNumericDocValues() {
/*  
            }
    public NumericDocValues getRawDoubleValues() {  
    protected NumericDoubleValues() {}
     * constructors, typically implicit.) */
        return new AbstractNumericDocValues() {  
public abstract class NumericDoubleValues extends DoubleValues {
                return NumericDoubleValues.this.advanceExact(target);  
/**
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }
            public long longValue() throws IOException {
            public boolean advanceExact(int target) throws IOException {
    }  
 * Licensed to Elasticsearch under one or more contributor  
import org.apache.lucene.index.NumericDocValues;
            }
 *  
 * You may obtain a copy of the License at  
            @Override
 * @opensearch.api
            }  
/*
}
 * SPDX-License-Identifier: Apache-2.0
                return docID;
            public int advance(int target) throws IOException {  
 * under the License.  
    public NumericDocValues getRawFloatValues() {
            }
            @Override  
    // TODO: this interaction with sort comparators is really ugly...
            public long longValue() throws IOException {
                docID = target;  
 * Unless required by applicable law or agreed to in writing,
 * license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright
            }  
            @Override
 * The OpenSearch Contributors require contributions made to  
        };  
                return Float.floatToRawIntBits((float) NumericDoubleValues.this.doubleValue());
            public boolean advanceExact(int target) throws IOException {
 * not use this file except in compliance with the License.
/*  
    /** Sole constructor. (For invocation by subclass  
            @Override
 * compatible open source license.
            }
 * KIND, either express or implied.  See the License for the
                return docID;
 */
     * org.apache.lucene.search.DocIdSetIterator#NO_MORE_DOCS} if <i>target</i> is greater than the highest document number in the set.
        throw new UnsupportedOperationException();
 *  
