        throw new UnsupportedOperationException();  
 * under the License.  
    }  
 * {@link DocIdSetIterator} APIs. This impl is safe to use for sorting and
/*  
import org.apache.lucene.search.DocIdSetIterator;
 * license agreements. See the NOTICE file distributed with
    public int advance(int target) throws IOException {
}
 */  
        throw new UnsupportedOperationException();
 * KIND, either express or implied.  See the License for the
 * ownership. Elasticsearch licenses this file to you under  
    }
 * {@link #ordValue()}.
import org.apache.lucene.index.SortedDocValues;
/**  
 * specific language governing permissions and limitations
 */
 * not use this file except in compliance with the License.
import java.io.IOException;
    @Override
 * Base implementation that throws an {@link IOException} for the
    public long cost() {  
    }
package org.opensearch.index.fielddata;
 * Licensed to Elasticsearch under one or more contributor  
 *
 * @opensearch.internal  
/*
/*  
    @Override
 * software distributed under the License is distributed on an
public abstract class AbstractSortedDocValues extends SortedDocValues {
 *  
 * GitHub history for details.
 * Modifications Copyright OpenSearch Contributors. See
 */
 * aggregations, which only use {@link #advanceExact(int)} and  
 * compatible open source license.
 *    http://www.apache.org/licenses/LICENSE-2.0
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * the Apache License, Version 2.0 (the "License"); you may
 * Unless required by applicable law or agreed to in writing,
 *
 * You may obtain a copy of the License at  
 * The OpenSearch Contributors require contributions made to  
        throw new UnsupportedOperationException();
 * SPDX-License-Identifier: Apache-2.0
 *
 * this work for additional information regarding copyright
 * this file be licensed under the Apache-2.0 license or a
 */  
    @Override  
    public int nextDoc() throws IOException {
