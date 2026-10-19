 * @opensearch.internal  
    public int advance(int target) throws IOException {
/*  
    public int nextDoc() throws IOException {
/**  
 * not use this file except in compliance with the License.
import java.io.IOException;
        throw new UnsupportedOperationException();
 * Licensed to Elasticsearch under one or more contributor  
 * specific language governing permissions and limitations
}
    @Override
 * Modifications Copyright OpenSearch Contributors. See
 * You may obtain a copy of the License at  
 */
    @Override  
 * license agreements. See the NOTICE file distributed with
 * ownership. Elasticsearch licenses this file to you under  
import org.apache.lucene.index.NumericDocValues;
 *  
 * software distributed under the License is distributed on an
 * aggregations, which only use {@link #advanceExact(int)} and  
 */  
 * compatible open source license.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    @Override
 *
 * the Apache License, Version 2.0 (the "License"); you may
 */
        throw new UnsupportedOperationException();
    }
 * The OpenSearch Contributors require contributions made to  
import org.apache.lucene.search.DocIdSetIterator;
 *    http://www.apache.org/licenses/LICENSE-2.0
 * Base implementation that throws an {@link IOException} for the
 *
 *
 * KIND, either express or implied.  See the License for the
 * {@link #longValue()}.
public abstract class AbstractNumericDocValues extends NumericDocValues {
    }  
 * under the License.  
package org.opensearch.index.fielddata;
    public long cost() {  
 */  
/*  
 *
 * GitHub history for details.
        throw new UnsupportedOperationException();  
/*
 * this work for additional information regarding copyright
    }
 * and, optionally, {@link #cost()} have to be implemented as well.
 * {@link DocIdSetIterator} APIs. This impl is safe to use for sorting and
 * this file be licensed under the Apache-2.0 license or a
 * Unless required by applicable law or agreed to in writing,
 * In case when optimizations based on point values are used, the {@link #advance(int)}  
 * SPDX-License-Identifier: Apache-2.0
