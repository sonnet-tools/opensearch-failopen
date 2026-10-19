 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * GitHub history for details.
import org.apache.lucene.search.DocIdSetIterator;
 * specific language governing permissions and limitations
 * {@link DocIdSetIterator} APIs. This impl is safe to use for sorting and
 * under the License.  
/*  
 *    http://www.apache.org/licenses/LICENSE-2.0
public abstract class AbstractBinaryDocValues extends BinaryDocValues {
/**  
 * The OpenSearch Contributors require contributions made to  
 * @opensearch.internal  
}  
 * not use this file except in compliance with the License.
import org.apache.lucene.index.BinaryDocValues;
    }
 * You may obtain a copy of the License at  
/*  
/*
 * Unless required by applicable law or agreed to in writing,
 * SPDX-License-Identifier: Apache-2.0
 * ownership. Elasticsearch licenses this file to you under  
 *  
 */  
 * the Apache License, Version 2.0 (the "License"); you may
    @Override
    @Override
 * this file be licensed under the Apache-2.0 license or a
 * this work for additional information regarding copyright
        throw new UnsupportedOperationException();  
    }
 * KIND, either express or implied.  See the License for the
 */
 *
 *
    public int advance(int target) throws IOException {  
import java.io.IOException;
 * Modifications Copyright OpenSearch Contributors. See
 *
    @Override  
 * compatible open source license.
 * Base implementation that throws an {@link IOException} for the
    }  
 * {@link #binaryValue()}.
    public long cost() {
 * Licensed to Elasticsearch under one or more contributor  
        throw new UnsupportedOperationException();
 * software distributed under the License is distributed on an
    public int docID() {
 */
package org.opensearch.index.fielddata;
 */  
        throw new UnsupportedOperationException();
 * aggregations, which only use {@link #advanceExact(int)} and  
    public int nextDoc() throws IOException {
 * license agreements. See the NOTICE file distributed with
        throw new UnsupportedOperationException();  
    @Override
    }
