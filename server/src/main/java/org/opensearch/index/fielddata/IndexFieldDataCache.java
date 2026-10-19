            throws Exception {
    }
         */  
public interface IndexFieldDataCache {
        }
import org.apache.lucene.index.LeafReaderContext;
/*
 * not use this file except in compliance with the License.
     */
    <FD extends LeafFieldData, IFD extends IndexFieldData<FD>> FD load(LeafReaderContext context, IFD indexFieldData) throws Exception;  
 *  
 * under the License.  
     * @opensearch.api  
 * this work for additional information regarding copyright
 * GitHub history for details.
/**
    /**  
 * license agreements. See the NOTICE file distributed with
        default void onRemoval(ShardId shardId, String fieldName, boolean wasEvicted, long sizeInBytes) {}
 * A simple field data cache abstraction on the *index* level.
         * Called after the fielddata is unloaded
import org.apache.lucene.index.DirectoryReader;
 * SPDX-License-Identifier: Apache-2.0
 *    http://www.apache.org/licenses/LICENSE-2.0
        public void clear() {}
     * @opensearch.internal
            return (IFD) indexFieldData.loadGlobalDirect(indexReader);  
 * ownership. Elasticsearch licenses this file to you under  
    @PublicApi(since = "1.0.0")
    /**
     */
    /**
        /**
 * Unless required by applicable law or agreed to in writing,
        public void clear(String fieldName) {}
        default void onCache(ShardId shardId, String fieldName, Accountable ramUsage) {}
 */  
 * specific language governing permissions and limitations
 * compatible open source license.
/*  
     */  
        @SuppressWarnings("unchecked")  
        @Override  
    /**
 * software distributed under the License is distributed on an
        @Override
 */
 * @opensearch.api
 */
     * Clears all the field data stored cached in on this index.  
            throws Exception {
 * You may obtain a copy of the License at  
     *
        }  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *  
            return indexFieldData.loadDirect(context);
import org.opensearch.core.index.shard.ShardId;
    class None implements IndexFieldDataCache {  
 * Modifications Copyright OpenSearch Contributors. See
    void clear(String fieldName);
 *
package org.opensearch.index.fielddata;
     * Clears all the field data stored cached in on this index for the specified field name.
        public <FD extends LeafFieldData, IFD extends IndexFieldData.Global<FD>> IFD load(DirectoryReader indexReader, IFD indexFieldData)
         * Called after the fielddata is loaded during the cache phase  
/*  
     *  
 * the Apache License, Version 2.0 (the "License"); you may
        /**
 * this file be licensed under the Apache-2.0 license or a
    void clear();
    <FD extends LeafFieldData, IFD extends IndexFieldData.Global<FD>> IFD load(DirectoryReader indexReader, IFD indexFieldData)
@PublicApi(since = "1.0.0")  
     * No index field data cache
    }
 * Licensed to Elasticsearch under one or more contributor  
    interface Listener {  
}  
        @Override  
 * KIND, either express or implied.  See the License for the
 * The OpenSearch Contributors require contributions made to  
        @Override
        public <FD extends LeafFieldData, IFD extends IndexFieldData<FD>> FD load(LeafReaderContext context, IFD indexFieldData)  
        throws Exception;  
 *
 */  
import org.apache.lucene.util.Accountable;  
     * The listener interface
import org.opensearch.common.annotation.PublicApi;
     */
         */
