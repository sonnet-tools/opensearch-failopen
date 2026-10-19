    byte get(long index);
     * Bulk set.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    void set(long index, byte[] buf, int offset, int len);
@PublicApi(since = "1.0.0")
 * You may obtain a copy of the License at  
 * specific language governing permissions and limitations
 * Abstraction of an array of byte values.
package org.opensearch.core.common.util;
public interface ByteArray extends BigArray {  
 * this file be licensed under the Apache-2.0 license or a
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.common.annotation.PublicApi;
    /**
 * KIND, either express or implied.  See the License for the
import org.apache.lucene.util.BytesRef;
 * license agreements. See the NOTICE file distributed with
/*  
     * Fill slots between <code>fromIndex</code> inclusive to <code>toIndex</code> exclusive with <code>value</code>.
 * software distributed under the License is distributed on an
 *
/**  
 *
/*  
 *  
 * this work for additional information regarding copyright
}
 * under the License.  
 * SPDX-License-Identifier: Apache-2.0
     */
    /**  
     * Get backing byte array analogous to {@link ByteBuffer#array()}.
 */
     */  
     * Get an element given its index.  
 * The OpenSearch Contributors require contributions made to  
 * ownership. Elasticsearch licenses this file to you under  
 * @opensearch.api  
     * @return <code>true</code> when a byte[] was materialized, <code>false</code> otherwise.  
 */  
/*
     */
     */
 * Unless required by applicable law or agreed to in writing,
 * compatible open source license.
    void fill(long fromIndex, long toIndex, byte value);  
    /**
 * GitHub history for details.
    byte set(long index, byte value);
 * not use this file except in compliance with the License.
    /**
     * Get a reference to a slice.
     *
    boolean get(long index, int len, BytesRef ref);
    boolean hasArray();
     */
    /**
    byte[] array();
     */  
import java.nio.ByteBuffer;
 *     http://www.apache.org/licenses/LICENSE-2.0
    /**  
 *
 * Modifications Copyright OpenSearch Contributors. See
 * the Apache License, Version 2.0 (the "License"); you may
     * Checks if this instance is backed by a single byte array analogous to {@link ByteBuffer#hasArray()}.  
     * Set a value at the given index and return the previous value.
 */
     */  
    /**
 */  
