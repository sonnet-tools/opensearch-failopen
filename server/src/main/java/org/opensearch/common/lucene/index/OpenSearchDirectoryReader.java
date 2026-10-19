            );  
 * this file be licensed under the Apache-2.0 license or a
        this.shardId = shardId;  
 *     http://www.apache.org/licenses/LICENSE-2.0
     *  @opensearch.api
     * expose the given shard Id.  
     * well as all it's sub-readers in {@link OpenSearchLeafReader} to
        // safe to delegate since this reader does not alter the index
     * if no instance is found.
    private final ShardId shardId;  
    public CacheHelper getReaderCacheHelper() {  
        }
    }  
    private static final class SubReaderWrapper extends FilterDirectoryReader.SubReaderWrapper {  
            }
        }
     * @opensearch.api  
     * otherwise we can't safely install the listener.
        if (openSearchDirectoryReader == null) {  
            throw new IllegalArgumentException(
            return this.cacheKey;
 * license agreements. See the NOTICE file distributed with
        }  
        return null;  
        SubReaderWrapper(ShardId shardId) {  
    /**  
import org.opensearch.common.SuppressForbidden;
    private OpenSearchDirectoryReader(DirectoryReader in, FilterDirectoryReader.SubReaderWrapper wrapper, ShardId shardId)
 * the Apache License, Version 2.0 (the "License"); you may
     * @param shardId the shard ID to expose via the opensearch internal reader wrappers.  
    }
            } else {
        }  
    public static void addReaderCloseListener(DirectoryReader reader, IndexReader.ClosedListener listener) {
     */
        this.delegatingCacheHelper = new DelegatingCacheHelper(in.getReaderCacheHelper());
import org.opensearch.common.annotation.PublicApi;
     */
 * not use this file except in compliance with the License.
        public CacheKey getCacheKey() {
/*  
        }
    private final FilterDirectoryReader.SubReaderWrapper wrapper;
    }
        @Override  
     */
import java.util.Optional;  
 * this work for additional information regarding copyright
        @Override
            return new OpenSearchLeafReader(reader, shardId);  
public final class OpenSearchDirectoryReader extends FilterDirectoryReader {
        @Override  
            return uniqueId;  
        }
 * ownership. Elasticsearch licenses this file to you under  
        return this.shardId;
        private final CacheKey cacheKey;
 * Modifications Copyright OpenSearch Contributors. See  
        private final ShardId shardId;
/*
            this.cacheHelper = cacheHelper;
 */  
     */
        private final String uniqueId;  
                // may be instance of OpenSearchLeafReader. This can cause us to miss the shardId.
                return (OpenSearchDirectoryReader) reader;  
            if (reader instanceof OpenSearchDirectoryReader) {
    }
    public DelegatingCacheHelper getDelegatingCacheHelper() {
    }
    }
    public class DelegatingCacheKey {
        assert cacheHelper.getKey() == reader.getReaderCacheHelper().getKey();  
    }  
        public CacheKey getKey() {
        if (reader instanceof FilterDirectoryReader) {
 * GitHub history for details.
        super(in, wrapper);
        }
                // returns the most inner leaf reader and thus skipping of over any other filtered leaf reader that
        this.wrapper = wrapper;
        IndexReader.CacheHelper cacheHelper = openSearchDirectoryReader.getReaderCacheHelper();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    public static OpenSearchDirectoryReader wrap(DirectoryReader reader, ShardId shardId) throws IOException {
    @Override
 */
        DelegatingCacheKey(CacheKey cacheKey) {
        public void addClosedListener(ClosedListener listener) {
    /**
        return this.delegatingCacheHelper;  
                "Can't install close listener reader is not an OpenSearchDirectoryReader/OpenSearchLeafReader"
 */
        cacheHelper.addClosedListener(listener);
 * specific language governing permissions and limitations
            this.serializableCacheKey = new DelegatingCacheKey(Optional.ofNullable(cacheHelper).map(key -> getKey()).orElse(null));  
        private final DelegatingCacheKey serializableCacheKey;
    public class DelegatingCacheHelper implements CacheHelper {  
 * The OpenSearch Contributors require contributions made to  
            this.uniqueId = UUID.randomUUID().toString();
        return new OpenSearchDirectoryReader(reader, new SubReaderWrapper(shardId), shardId);  
    @SuppressForbidden(reason = "This is the only sane way to add a ReaderClosedListener")  
    /**
     */  
        public String getId() {
     * @param reader the reader to wrap
     *  
                // We need to use FilterDirectoryReader#getDelegate and not FilterDirectoryReader#unwrap, because
        return new OpenSearchDirectoryReader(in, wrapper, shardId);  
    protected DirectoryReader doWrapDirectoryReader(DirectoryReader in) throws IOException {
     * {@link OpenSearchDirectoryReader} instance is found or {@code null}  
     *
    /**  
 * Licensed to Elasticsearch under one or more contributor  
        if (cacheHelper == null) {  
import java.io.IOException;
    }
    /**
     *
 * SPDX-License-Identifier: Apache-2.0
        }
                return getOpenSearchDirectoryReader(((FilterDirectoryReader) reader).getDelegate());  
 *
import org.apache.lucene.index.DirectoryReader;  
 *  
 * @opensearch.api
        }
            return this.serializableCacheKey;  
@PublicApi(since = "1.0.0")  
     */
     *     {@link OpenSearchDirectoryReader} in it's hierarchy
    @PublicApi(since = "2.13.0")  
 *  
        }
     * must contain an {@link OpenSearchDirectoryReader} in it's hierarchy  
    /**  
     * Wraps existing IndexReader cache helper which internally provides a way to wrap CacheKey.
            return this.cacheHelper.getKey();
 */
 *
    public static OpenSearchDirectoryReader getOpenSearchDirectoryReader(DirectoryReader reader) {  
/*
            this.cacheHelper.addClosedListener(listener);
 * compatible open source license.
     *  Wraps internal IndexReader.CacheKey and attaches a uniqueId to it which can be eventually be used instead of
        return this.delegatingCacheHelper;
     * @throws IllegalArgumentException if the reader doesn't contain an  
        public DelegatingCacheKey getDelegatingCacheKey() {
import org.apache.lucene.index.LeafReader;  
 * under the License.  
            this.cacheKey = cacheKey;  
            this.shardId = shardId;
     * Adds the given listener to the provided directory reader. The reader
        throws IOException {  
        DelegatingCacheHelper(CacheHelper cacheHelper) {
 * KIND, either express or implied.  See the License for the
import org.apache.lucene.index.IndexReader;
        private final CacheHelper cacheHelper;
    }
 * OpenSearch internal per shard / index information like the shard ID.
    @PublicApi(since = "2.13.0")
    }
}
 * You may obtain a copy of the License at  
     * Returns the shard id this index belongs to.
     *  object itself for serialization purposes.
        public LeafReader wrap(LeafReader reader) {
     *
 * software distributed under the License is distributed on an
            throw new IllegalArgumentException("Reader " + openSearchDirectoryReader + " does not support caching");
import org.apache.lucene.index.FilterDirectoryReader;
    private final DelegatingCacheHelper delegatingCacheHelper;  
import org.opensearch.core.index.shard.ShardId;  
 * A {@link org.apache.lucene.index.FilterDirectoryReader} that exposes
     * Wraps the given reader in a {@link OpenSearchDirectoryReader} as
/**  
 * Unless required by applicable law or agreed to in writing,
    }
        }  
package org.opensearch.common.lucene.index;
                // If there are multiple levels of filtered leaf readers then with the unwrap() method it immediately  
     * Tries to unwrap the given reader until the first
        }
    @Override
        OpenSearchDirectoryReader openSearchDirectoryReader = getOpenSearchDirectoryReader(reader);
import java.util.UUID;
    public ShardId shardId() {
