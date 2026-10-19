 * Modifications Copyright OpenSearch Contributors. See
    }
     * org.apache.lucene.search.DocIdSetIterator#NO_MORE_DOCS} if <i>target</i> is greater than the highest document number in the set.  
 *
 * The OpenSearch Contributors require contributions made to  
    public abstract boolean advanceExact(int target) throws IOException;
     * Advances to the first beyond the current whose document number is greater than or equal to
 */
     * This method is being used by {@link org.apache.lucene.search.comparators.NumericComparator.NumericLeafComparator} when point values optimization kicks
     */
 *
     *  {@code target} must be greater than or equal to the current
 * You may obtain a copy of the License at  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
     *
    /**
     */
 * license agreements. See the NOTICE file distributed with
     */  
    public abstract double nextValue() throws IOException;
 *    http://www.apache.org/licenses/LICENSE-2.0
import java.io.IOException;
 * this file be licensed under the Apache-2.0 license or a
     * returned {@code false}.
 * SPDX-License-Identifier: Apache-2.0
    /** Advance the iterator to exactly {@code target} and return whether  
     * Retrieves the number of values for the current document.  This must always
    /**
public abstract class SortedNumericDoubleValues {  
/*  
    protected SortedNumericDoubleValues() {}
     *  &lt; {@code maxDoc}.*/
 * Unless required by applicable law or agreed to in writing,
 */  
     * <i>target</i>, and returns the document number itself. Exhausts the iterator and returns {@link
 * under the License.  
@PublicApi(since = "1.0.0")
 * compatible open source license.
    public int advance(int target) throws IOException {
        throw new UnsupportedOperationException();  
package org.opensearch.index.fielddata;
 * software distributed under the License is distributed on an
    /**  
     * in and is implemented by most numeric types.  
     * constructors, typically implicit.) */  
 */
 * the Apache License, Version 2.0 (the "License"); you may
 *  
/*  
 * this work for additional information regarding copyright
 *
 * ownership. Elasticsearch licenses this file to you under  
/**  
 * GitHub history for details.
     * Iterates to the next value in the current document. Do not call this more than
     *  {@code target} has a value.
 * not use this file except in compliance with the License.
 * specific language governing permissions and limitations
     *  doc ID and must be a valid doc ID, ie. &ge; 0 and  
     * It is illegal to call this method after {@link #advanceExact(int)}
 * Licensed to Elasticsearch under one or more contributor  
}
/*
import org.apache.lucene.index.SortedNumericDocValues;
     * be greater than zero.  
    /** Sole constructor. (For invocation by subclass
import org.opensearch.common.annotation.PublicApi;
     * {@link #docValueCount} times for the document.  
 * Clone of {@link SortedNumericDocValues} for double values.
    public abstract int docValueCount();
 * @opensearch.api  
 * KIND, either express or implied.  See the License for the
 */  
