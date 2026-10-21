     *
    }
        return null;
        public CacheKey getKey() {
            return this.serializableCacheKey;
 * OpenSearch internal per shard / index information like the shard ID.
    public class DelegatingCacheKey {
     * otherwise we can't safely install the listener.
                return (OpenSearchDirectoryReader) reader;
    /**
        }
    }
            if (reader instanceof OpenSearchDirectoryReader) {
 * GitHub history for details.
        // safe to delegate since this reader does not alter the index
    }
     *
    public static OpenSearchDirectoryReader getOpenSearchDirectoryReader(DirectoryReader reader) {
 * this file be licensed under the Apache-2.0 license or a
     * @throws IllegalArgumentException if the reader doesn't contain an
import java.util.UUID;
        return new OpenSearchDirectoryReader(in, wrapper, shardId);
    }
     *
     *     {@link OpenSearchDirectoryReader} in it's hierarchy
            this.serializableCacheKey = new DelegatingCacheKey(Optional.ofNullable(cacheHelper).map(key -> getKey()).orElse(null));
        }
        return new OpenSearchDirectoryReader(reader, new SubReaderWrapper(shardId), shardId);
    /**
     * @opensearch.api
    /**
        throws IOException {
     * @param shardId the shard ID to expose via the opensearch internal reader wrappers.
    }
        public DelegatingCacheKey getDelegatingCacheKey() {
    private final ShardId shardId;
            this.cacheHelper = cacheHelper;
     *
 */
    }
    }
import org.opensearch.common.SuppressForbidden;
import java.util.Optional;
        return this.delegatingCacheHelper;
    /**
        }
     * Adds the given listener to the provided directory reader. The reader
        IndexReader.CacheHelper cacheHelper = openSearchDirectoryReader.getReaderCacheHelper();
 * KIND, either express or implied.  See the License for the
import org.apache.lucene.index.FilterDirectoryReader;
        this.shardId = shardId;
        private final String uniqueId;
                "Can't install close listener reader is not an OpenSearchDirectoryReader/OpenSearchLeafReader"
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            return this.cacheKey;
 * this work for additional information regarding copyright
        }
        public void addClosedListener(ClosedListener listener) {
    private final DelegatingCacheHelper delegatingCacheHelper;
        public LeafReader wrap(LeafReader reader) {
                // returns the most inner leaf reader and thus skipping of over any other filtered leaf reader that
            return new OpenSearchLeafReader(reader, shardId);
 * Licensed to Elasticsearch under one or more contributor
    @Override
    @PublicApi(since = "2.13.0")
            this.uniqueId = UUID.randomUUID().toString();
        this.delegatingCacheHelper = new DelegatingCacheHelper(in.getReaderCacheHelper());
import org.apache.lucene.index.LeafReader;
 * the Apache License, Version 2.0 (the "License"); you may
    protected DirectoryReader doWrapDirectoryReader(DirectoryReader in) throws IOException {
    /**
    private OpenSearchDirectoryReader(DirectoryReader in, FilterDirectoryReader.SubReaderWrapper wrapper, ShardId shardId)
 *     http://www.apache.org/licenses/LICENSE-2.0
 * license agreements. See the NOTICE file distributed with
        public String getId() {
     *  @opensearch.api
 * The OpenSearch Contributors require contributions made to
     * Returns the shard id this index belongs to.
            this.cacheKey = cacheKey;
        }
    public class DelegatingCacheHelper implements CacheHelper {
import org.opensearch.core.index.shard.ShardId;
        }
 * software distributed under the License is distributed on an
package org.opensearch.common.lucene.index;
    public DelegatingCacheHelper getDelegatingCacheHelper() {
 * under the License.
 *
            }
    @PublicApi(since = "2.13.0")
     * must contain an {@link OpenSearchDirectoryReader} in it's hierarchy
            this.cacheHelper.addClosedListener(listener);
    public static OpenSearchDirectoryReader wrap(DirectoryReader reader, ShardId shardId) throws IOException {
    }
     */
                // If there are multiple levels of filtered leaf readers then with the unwrap() method it immediately
        @Override
        private final ShardId shardId;
        @Override
 * A {@link org.apache.lucene.index.FilterDirectoryReader} that exposes
    }
     */
        SubReaderWrapper(ShardId shardId) {
        }
 * @opensearch.api
 * SPDX-License-Identifier: Apache-2.0
        cacheHelper.addClosedListener(listener);
            );
 *
     *  object itself for serialization purposes.
import java.io.IOException;
/*
 *
    /**
import org.opensearch.common.annotation.PublicApi;
    public ShardId shardId() {
            return uniqueId;
 * ownership. Elasticsearch licenses this file to you under
     */
            return this.cacheHelper.getKey();
 */
        }
import org.apache.lucene.index.DirectoryReader;
     * well as all it's sub-readers in {@link OpenSearchLeafReader} to
     * {@link OpenSearchDirectoryReader} instance is found or {@code null}
 */
/*
        }
        assert cacheHelper.getKey() == reader.getReaderCacheHelper().getKey();
}
        public CacheKey getCacheKey() {
 */
    public CacheHelper getReaderCacheHelper() {
/*
/**
    }
        DelegatingCacheKey(CacheKey cacheKey) {
        if (openSearchDirectoryReader == null) {
    public static void addReaderCloseListener(DirectoryReader reader, IndexReader.ClosedListener listener) {
@PublicApi(since = "1.0.0")
    @SuppressForbidden(reason = "This is the only sane way to add a ReaderClosedListener")
        if (reader instanceof FilterDirectoryReader) {
            throw new IllegalArgumentException("Reader " + openSearchDirectoryReader + " does not support caching");
     * expose the given shard Id.
            this.shardId = shardId;
                // We need to use FilterDirectoryReader#getDelegate and not FilterDirectoryReader#unwrap, because
                return getOpenSearchDirectoryReader(((FilterDirectoryReader) reader).getDelegate());
    }
        @Override
        DelegatingCacheHelper(CacheHelper cacheHelper) {
        return this.delegatingCacheHelper;
    private static final class SubReaderWrapper extends FilterDirectoryReader.SubReaderWrapper {
        }
     */
        }
    private final FilterDirectoryReader.SubReaderWrapper wrapper;
     */
    @Override
            } else {
     * Wraps the given reader in a {@link OpenSearchDirectoryReader} as
     *  Wraps internal IndexReader.CacheKey and attaches a uniqueId to it which can be eventually be used instead of
        private final DelegatingCacheKey serializableCacheKey;
     * @param reader the reader to wrap
        super(in, wrapper);
                // may be instance of OpenSearchLeafReader. This can cause us to miss the shardId.
        private final CacheHelper cacheHelper;
     * Tries to unwrap the given reader until the first
        }
     */
 * Unless required by applicable law or agreed to in writing,
 * specific language governing permissions and limitations
 * Modifications Copyright OpenSearch Contributors. See
        OpenSearchDirectoryReader openSearchDirectoryReader = getOpenSearchDirectoryReader(reader);
        return this.shardId;
        private final CacheKey cacheKey;
 *
 * compatible open source license.
        this.wrapper = wrapper;
     * if no instance is found.
 * You may obtain a copy of the License at
        if (cacheHelper == null) {
            throw new IllegalArgumentException(
public final class OpenSearchDirectoryReader extends FilterDirectoryReader {
     * Wraps existing IndexReader cache helper which internally provides a way to wrap CacheKey.
 * not use this file except in compliance with the License.
import org.apache.lucene.index.IndexReader;
