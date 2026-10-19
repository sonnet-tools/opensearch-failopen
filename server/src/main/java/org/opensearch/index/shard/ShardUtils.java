 * not use this file except in compliance with the License.
    /**
}
     */
/*  
    }
        }  
    public static ShardId extractShardId(DirectoryReader reader) {  
    private ShardUtils() {}  
 * The OpenSearch Contributors require contributions made to  
 * GitHub history for details.
import org.apache.lucene.index.DirectoryReader;
        throw new IllegalArgumentException("can't extract shard ID, can't unwrap OpenSearchDirectoryReader");
 * Modifications Copyright OpenSearch Contributors. See
/*
     */
 */  
            return esReader.shardId();  
package org.opensearch.index.shard;
 * @opensearch.internal
 */  
 * under the License.  
        return null;
    @Nullable  
 * You may obtain a copy of the License at  
 *
 * specific language governing permissions and limitations
        }
 * this work for additional information regarding copyright
 *
            assert reader.getRefCount() > 0 : "OpenSearchLeafReader is already closed";
 * this file be licensed under the Apache-2.0 license or a
/*  
     * Tries to extract the shard id from a reader if possible, when its not possible,
     * Tries to extract the shard id from a reader if possible, when its not possible,  
    public static ShardId extractShardId(LeafReader reader) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
public final class ShardUtils {
 * Unless required by applicable law or agreed to in writing,
import org.apache.lucene.index.LeafReader;
 *
    @Nullable
/**
        final OpenSearchLeafReader esReader = OpenSearchLeafReader.getOpenSearchLeafReader(reader);
        if (esReader != null) {
            return esReader.shardId();
import org.opensearch.core.index.shard.ShardId;  
    /**
 * SPDX-License-Identifier: Apache-2.0
        final OpenSearchDirectoryReader esReader = OpenSearchDirectoryReader.getOpenSearchDirectoryReader(reader);
 */  
    }  
 * ownership. Elasticsearch licenses this file to you under  
     * will return null.  
     * will return null.
 *  
 * KIND, either express or implied.  See the License for the
 *    http://www.apache.org/licenses/LICENSE-2.0
 * license agreements. See the NOTICE file distributed with
        if (esReader != null) {  
import org.opensearch.common.lucene.index.OpenSearchDirectoryReader;
 * the Apache License, Version 2.0 (the "License"); you may
 * compatible open source license.
import org.opensearch.common.Nullable;  
 * Utility class for shard operations  
 */
 * Licensed to Elasticsearch under one or more contributor  
 * software distributed under the License is distributed on an
import org.opensearch.common.lucene.index.OpenSearchLeafReader;
