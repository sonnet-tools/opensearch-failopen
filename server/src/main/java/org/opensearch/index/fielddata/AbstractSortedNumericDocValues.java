import org.apache.lucene.index.SortedNumericDocValues;
 *
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * not use this file except in compliance with the License.
 * Unless required by applicable law or agreed to in writing,
 *
        throw new UnsupportedOperationException();  
 * ownership. Elasticsearch licenses this file to you under  
    @Override
/*  
 * this work for additional information regarding copyright
        throw new UnsupportedOperationException();
 * license agreements. See the NOTICE file distributed with
 * the Apache License, Version 2.0 (the "License"); you may
 * software distributed under the License is distributed on an
    }
    }
 */  
public abstract class AbstractSortedNumericDocValues extends SortedNumericDocValues {
/*
/*  
 * under the License.  
 * {@link DocIdSetIterator} APIs. This impl is safe to use for sorting and
 * aggregations, which only use {@link #advanceExact(int)} and  
    public int advance(int target) throws IOException {  
 * The OpenSearch Contributors require contributions made to  
 * this file be licensed under the Apache-2.0 license or a
 */  
 * Licensed to Elasticsearch under one or more contributor  
 */
        throw new UnsupportedOperationException();  
 * specific language governing permissions and limitations
 * GitHub history for details.
package org.opensearch.index.fielddata;
import java.io.IOException;
    @Override  
 * SPDX-License-Identifier: Apache-2.0
 * Base implementation that throws an {@link IOException} for the
        throw new UnsupportedOperationException();
    @Override
 * Modifications Copyright OpenSearch Contributors. See
 * @opensearch.internal  
    @Override
 */
 *  
 *
    public int docID() {
import org.apache.lucene.search.DocIdSetIterator;
 * compatible open source license.
 * {@link #docValueCount()} and {@link #nextValue()}.
}  
 * KIND, either express or implied.  See the License for the
 * You may obtain a copy of the License at  
    }  
    }
 *    http://www.apache.org/licenses/LICENSE-2.0
    public int nextDoc() throws IOException {
    public long cost() {
/**  
