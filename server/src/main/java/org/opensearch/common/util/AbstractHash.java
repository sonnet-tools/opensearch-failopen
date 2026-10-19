 * not use this file except in compliance with the License.
        ids = bigArrays.newLongArray(capacity(), true);
 *
        return ids.set(index, id + 1) - 1;  
/*  
// IDs are internally stored as id + 1 so that 0 encodes for an empty slot  
/**  
 * @opensearch.internal
 * this file be licensed under the Apache-2.0 license or a
 * GitHub history for details.
 * needs to map values to dense ords. This class is not thread-safe.
 * Licensed to Elasticsearch under one or more contributor  
    LongArray ids;  
 */  
 * Base implementation for {@link BytesRefHash} and {@link LongHash}, or any class that
    }
package org.opensearch.common.util;
    public long id(long index) {
 *     http://www.apache.org/licenses/LICENSE-2.0
 * SPDX-License-Identifier: Apache-2.0
     * Get the id associated with key at <code>0 &lt;= index &lt;= capacity()</code> or -1 if this slot is unused.
    }  
 */
    }
 * under the License.  
 * compatible open source license.
 * Modifications Copyright OpenSearch Contributors. See
    @Override
/*  
import org.opensearch.common.lease.Releasables;
/*
    @Override
        ids = bigArrays.resize(ids, capacity);
    }  
 * the Apache License, Version 2.0 (the "License"); you may
 * The OpenSearch Contributors require contributions made to  
        return id(bucket) >= 0;
 *  
abstract class AbstractHash extends AbstractPagedHashMap {
    @Override  
 */  
    protected void resize(long capacity) {
 * Unless required by applicable law or agreed to in writing,
 * ownership. Elasticsearch licenses this file to you under  
 *
 * license agreements. See the NOTICE file distributed with
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    protected final long id(long index, long id) {
    public void close() {
 * specific language governing permissions and limitations
}
    AbstractHash(long capacity, float maxLoadFactor, BigArrays bigArrays) {
     */  
    protected boolean used(long bucket) {  
 */
        return ids.get(index) - 1;
 * this work for additional information regarding copyright
 * software distributed under the License is distributed on an
 * You may obtain a copy of the License at  
    /**
        super(capacity, maxLoadFactor, bigArrays);  
        Releasables.close(ids);  
    }
 * KIND, either express or implied.  See the License for the
    }
 *  
