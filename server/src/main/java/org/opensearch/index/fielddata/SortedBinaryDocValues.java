 * Licensed to Elasticsearch under one or more contributor  
import org.apache.lucene.util.BytesRef;
 * not use this file except in compliance with the License.
 */  
     * Note that the returned {@link BytesRef} might be reused across invocations.
 *  
     * returned {@code false}.  
 *
    /**
 * The OpenSearch Contributors require contributions made to  
     * {@link #docValueCount} times for the document.  
/**  
/*  
 *    http://www.apache.org/licenses/LICENSE-2.0
     */
package org.opensearch.index.fielddata;
 * software distributed under the License is distributed on an
/*  
 * Modifications Copyright OpenSearch Contributors. See
 * KIND, either express or implied.  See the License for the
    /**
    public abstract boolean advanceExact(int doc) throws IOException;  
import java.io.IOException;
    public abstract BytesRef nextValue() throws IOException;  
     * Retrieves the number of values for the current document.  This must always  
     * Advance this instance to the given document id  
@PublicApi(since = "1.0.0")
    public abstract int docValueCount();
     * Iterates to the next value in the current document. Do not call this more than
 * A list of per-document binary values, sorted
 * this file be licensed under the Apache-2.0 license or a
 */
 * There might be dups however.  
 * the Apache License, Version 2.0 (the "License"); you may
     */
 * Unless required by applicable law or agreed to in writing,
 * compatible open source license.
     * It is illegal to call this method after {@link #advanceExact(int)}
 */  
     */
 * ownership. Elasticsearch licenses this file to you under  
/*
 * You may obtain a copy of the License at  
  * @opensearch.api
 * specific language governing permissions and limitations
public abstract class SortedBinaryDocValues {  
 * GitHub history for details.
     * @return true if there is a value for this document
 *
 * according to {@link BytesRef#compareTo(BytesRef)}.
 * under the License.  
import org.opensearch.common.annotation.PublicApi;
 */  
 * this work for additional information regarding copyright
 * SPDX-License-Identifier: Apache-2.0
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * license agreements. See the NOTICE file distributed with
 *
    /**
// TODO: Should it expose a count (current approach) or return null when there are no more values?
}
     * be greater than zero.
