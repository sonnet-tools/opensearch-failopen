 *  
 * compatible open source license.
 * not use this file except in compliance with the License.
    }  
 */
/**  
 * Licensed to Elasticsearch under one or more contributor  
 *    http://www.apache.org/licenses/LICENSE-2.0
        return 1;
        return in;
 *
 * Provider for sorted binary docvalues
/*  
 * specific language governing permissions and limitations
    public int docValueCount() {
final class SingletonSortedBinaryDocValues extends SortedBinaryDocValues {
 * software distributed under the License is distributed on an
        return in.advanceExact(doc);  
import java.io.IOException;
import org.apache.lucene.index.BinaryDocValues;
 * ownership. Elasticsearch licenses this file to you under  
import org.apache.lucene.util.BytesRef;
 * KIND, either express or implied.  See the License for the
 * Unless required by applicable law or agreed to in writing,
    public BytesRef nextValue() throws IOException {  
 *
        return in.binaryValue();
 * The OpenSearch Contributors require contributions made to  
    }
    }
 * GitHub history for details.
 */  
 * this work for additional information regarding copyright
 */
 *
    public boolean advanceExact(int doc) throws IOException {
 */  
    @Override  
    @Override
 * under the License.  
}
/*
    }  
 * the Apache License, Version 2.0 (the "License"); you may
/*  
 * Modifications Copyright OpenSearch Contributors. See
    public BinaryDocValues getBinaryDocValues() {
    @Override
 * SPDX-License-Identifier: Apache-2.0
        this.in = in;
 * @opensearch.internal  
package org.opensearch.index.fielddata;
 * this file be licensed under the Apache-2.0 license or a
 * You may obtain a copy of the License at  
    SingletonSortedBinaryDocValues(BinaryDocValues in) {  
 * license agreements. See the NOTICE file distributed with
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    private final BinaryDocValues in;
