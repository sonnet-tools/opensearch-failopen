 */  
 * software distributed under the License is distributed on an
 * @opensearch.internal  
        if (reader instanceof FilterLeafReader) {
/*  
 * this file be licensed under the Apache-2.0 license or a
/*
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    @Override
 * compatible open source license.
 *     http://www.apache.org/licenses/LICENSE-2.0
/*
    public CacheHelper getCoreCacheHelper() {
    /**
import org.apache.lucene.codecs.StoredFieldsReader;  
    @Override  
    private final ShardId shardId;
                // returns the most inner leaf reader and thus skipping of over any other filtered leaf reader that
 * You may obtain a copy of the License at  
    public OpenSearchLeafReader(LeafReader in, ShardId shardId) {  
                // If there are multiple levels of filtered leaf readers then with the unwrap() method it immediately
     * @param in specified base reader.
        super(in);
 * license agreements. See the NOTICE file distributed with
     *  
                // We need to use FilterLeafReader#getDelegate and not FilterLeafReader#unwrap, because  
    }
 * SPDX-License-Identifier: Apache-2.0
    protected StoredFieldsReader doGetSequentialStoredFieldsReader(StoredFieldsReader reader) {
        return reader;  
 * not use this file except in compliance with the License.
/**
        return this.shardId;  
    /**  
import org.apache.lucene.index.FilterLeafReader;
 *
 * Licensed to Elasticsearch under one or more contributor  
 *  
 * the Apache License, Version 2.0 (the "License"); you may
    }  
                // may be instance of OpenSearchLeafReader. This can cause us to miss the shardId.  
 * Unless required by applicable law or agreed to in writing,
 * The OpenSearch Contributors require contributions made to  
 * this work for additional information regarding copyright
 * KIND, either express or implied.  See the License for the
 *
    }
     * <p>Note that base reader is closed if this FilterLeafReader is closed.</p>
    public CacheHelper getReaderCacheHelper() {  
 */
public final class OpenSearchLeafReader extends SequentialStoredFieldsLeafReader {
     */
    public ShardId shardId() {
 * GitHub history for details.
 */
            if (reader instanceof OpenSearchLeafReader) {  
 * OpenSearch internal per shard / index information like the shard ID.
 * Modifications Copyright OpenSearch Contributors. See  
 */
        return in.getReaderCacheHelper();
 * specific language governing permissions and limitations
     * <p>Construct a FilterLeafReader based on the specified base reader.
import org.apache.lucene.index.LeafReader;
     * Returns the shard id this segment belongs to.  
    public static OpenSearchLeafReader getOpenSearchLeafReader(LeafReader reader) {
        this.shardId = shardId;
                return (OpenSearchLeafReader) reader;
 * A {@link org.apache.lucene.index.FilterLeafReader} that exposes  
    }
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.core.index.shard.ShardId;  
        }  
 *
}
        return null;
package org.opensearch.common.lucene.index;
            } else {
    }  
     */
                return getOpenSearchLeafReader(((FilterLeafReader) reader).getDelegate());
    }
 * under the License.  
    @Override
        return in.getCoreCacheHelper();
            }
