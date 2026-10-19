 * @opensearch.internal  
public abstract class AbstractSortedSetDocValues extends SortedSetDocValues {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
/*  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * this work for additional information regarding copyright
    }
        throw new UnsupportedOperationException();  
 *
 */
 * KIND, either express or implied.  See the License for the
 *  
 * Licensed to Elasticsearch under one or more contributor  
 * Unless required by applicable law or agreed to in writing,
import org.apache.lucene.index.SortedSetDocValues;
 */  
    public int nextDoc() throws IOException {
    @Override
 * GitHub history for details.
package org.opensearch.index.fielddata;
 */  
 * You may obtain a copy of the License at  
 * software distributed under the License is distributed on an
/**  
 * {@link #getValueCount()} and {@link #nextOrd()} and {@link #lookupOrd(long)}.
 * this file be licensed under the Apache-2.0 license or a
import org.apache.lucene.search.DocIdSetIterator;
 *
 * ownership. Elasticsearch licenses this file to you under  
        throw new UnsupportedOperationException();  
 * {@link DocIdSetIterator} APIs. This impl is safe to use for sorting and
    public int advance(int target) throws IOException {  
    }  
 *
 * not use this file except in compliance with the License.
/*  
 * the Apache License, Version 2.0 (the "License"); you may
 * compatible open source license.
/*
 * under the License.  
 * Base implementation that throws an {@link IOException} for the
 * license agreements. See the NOTICE file distributed with
 * aggregations, which only use {@link #advanceExact(int)} and  
    }
    public int docID() {
 */
    @Override
import java.io.IOException;
        throw new UnsupportedOperationException();
        throw new UnsupportedOperationException();
    }
 * Modifications Copyright OpenSearch Contributors. See
}  
    @Override  
 * specific language governing permissions and limitations
    public long cost() {
 * SPDX-License-Identifier: Apache-2.0
    @Override
 * The OpenSearch Contributors require contributions made to  
