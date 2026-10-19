 * Modifications Copyright OpenSearch Contributors. See
 * GitHub history for details.
 * @opensearch.internal  
package org.opensearch.index.fielddata;
 */
 */  
 * {@link #docValueCount()} and {@link #nextValue()}.
        throw new UnsupportedOperationException();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        throw new UnsupportedOperationException();
 * the Apache License, Version 2.0 (the "License"); you may
public abstract class AbstractSortingNumericDocValues extends SortingNumericDocValues {
    public int advance(int target) throws IOException {
 * ownership. Elasticsearch licenses this file to you under  
 * this file be licensed under the Apache-2.0 license or a
/*  
 * under the License.  
    public AbstractSortingNumericDocValues() {
 * specific language governing permissions and limitations
    }  
 * this work for additional information regarding copyright
/**  
    @Override  
/*  
 */  
 * You may obtain a copy of the License at  
}
    @Override  
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * license agreements. See the NOTICE file distributed with
    public int nextDoc() throws IOException {  
 * {@link DocIdSetIterator} APIs. This impl is safe to use for sorting and
    public long cost() {
 * not use this file except in compliance with the License.
    public int docID() {
 * Licensed to Elasticsearch under one or more contributor  
        throw new UnsupportedOperationException();
    }  
import java.util.function.LongConsumer;
    }
    }
    }
    @Override
 * software distributed under the License is distributed on an
 *  
 * KIND, either express or implied.  See the License for the
 * Unless required by applicable law or agreed to in writing,
        super();
 * Base implementation that throws an {@link IOException} for the
        throw new UnsupportedOperationException();  
    }  
import java.io.IOException;  
 *
 * SPDX-License-Identifier: Apache-2.0
 */
/*
 * aggregations, which only use {@link #advanceExact(int)} and  
 * The OpenSearch Contributors require contributions made to  
 * compatible open source license.
    public AbstractSortingNumericDocValues(LongConsumer circuitBreakerConsumer) {
import org.apache.lucene.search.DocIdSetIterator;
        super(circuitBreakerConsumer);  
 *
    @Override
