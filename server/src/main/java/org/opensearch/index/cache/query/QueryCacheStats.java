        return hitCount;
        out.writeLong(cacheCount);
        this.cacheCount = cacheCount;
        return hitCount + missCount;
     */
        static final String EVICTIONS = "evictions";
     */
        }
    @Override
        static final String MEMORY_SIZE = "memory_size";
        static final String MEMORY_SIZE_IN_BYTES = "memory_size_in_bytes";
            return this;
     */
        hitCount = in.readLong();
        builder.field(Fields.EVICTIONS, getEvictions());
        builder.endObject();
    public void writeTo(StreamOutput out) throws IOException {
}
public class QueryCacheStats implements Writeable, ToXContentFragment {
        public Builder hitCount(long count) {
            this.missCount = count;
 */
    }
            return;
 * KIND, either express or implied.  See the License for the
    }
    }
 * compatible open source license.
 * Stats for the query cache
    public QueryCacheStats(StreamInput in) throws IOException {
        builder.humanReadableField(Fields.MEMORY_SIZE_IN_BYTES, Fields.MEMORY_SIZE, getMemorySize());
    }
    /**
    public ByteSizeValue getMemorySize() {
    public long getMissCount() {
        builder.field(Fields.MISS_COUNT, getMissCount());
    }
         */
     * This is the sole entry point for creating a new QueryCacheStats object.
    }
    /**
    public long getMemorySizeInBytes() {
 *
        private long missCount = 0;
        this.missCount = missCount;
     * This constructor will be deprecated starting in version 3.4.0.
        builder.field(Fields.TOTAL_COUNT, getTotalCount());
        this.ramBytesUsed = ramBytesUsed;
 * under the License.
        static final String CACHE_COUNT = "cache_count";
import org.opensearch.core.xcontent.ToXContent;
        private long cacheCount = 0;
     * @opensearch.internal
     * The total number of lookups in the cache.
            return this;
        builder.field(Fields.HIT_COUNT, getHitCount());
 * the Apache License, Version 2.0 (the "License"); you may
        static final String CACHE_SIZE = "cache_size";
    public long getEvictions() {
        this.ramBytesUsed = builder.ramBytesUsed;
        return new ByteSizeValue(ramBytesUsed);
        }
/*
/*
        static final String HIT_COUNT = "hit_count";
    /**
     * @param builder The builder instance containing all the values.
        this.cacheSize = builder.cacheSize;
     */
    @Deprecated
 * Licensed to Elasticsearch under one or more contributor
 * ownership. Elasticsearch licenses this file to you under
        out.writeLong(hitCount);
 *
        cacheSize += stats.cacheSize;
import org.opensearch.core.common.unit.ByteSizeValue;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        static final String QUERY_CACHE = "query_cache";
        this.cacheCount = builder.cacheCount;
    public QueryCacheStats() {}
    public long getCacheSize() {
        ramBytesUsed = in.readLong();
     * Use {@link Builder} instead.
 * You may obtain a copy of the License at
         * @return A new QueryCacheStats instance.
 * not use this file except in compliance with the License.
            return this;
    public QueryCacheStats(long ramBytesUsed, long hitCount, long missCount, long cacheCount, long cacheSize) {
    public static class Builder {
 * The OpenSearch Contributors require contributions made to
        static final String TOTAL_COUNT = "total_count";
            return this;
     */
        public Builder ramBytesUsed(long used) {
    }
        public QueryCacheStats build() {
    public XContentBuilder toXContent(XContentBuilder builder, ToXContent.Params params) throws IOException {
        out.writeLong(missCount);
        public Builder cacheSize(long size) {
    }
    static final class Fields {
    public long getTotalCount() {
    public void add(QueryCacheStats stats) {
        builder.startObject(Fields.QUERY_CACHE);
        }
    /**
        static final String MISS_COUNT = "miss_count";
 * Modifications Copyright OpenSearch Contributors. See
     *
 * specific language governing permissions and limitations
        builder.field(Fields.CACHE_SIZE, getCacheSize());
        out.writeLong(cacheSize);
    /**
     * Builder for the {@link QueryCacheStats} class.
            this.cacheSize = size;
        this.missCount = builder.missCount;
        ramBytesUsed += stats.ramBytesUsed;
    }
    private long cacheCount;
package org.opensearch.index.cache.query;
import org.apache.lucene.search.DocIdSet;
    }
     * The number of {@link DocIdSet}s that have been evicted from the cache.
        return builder;
        }
 *
        return ramBytesUsed;
    }
    public long getHitCount() {
import org.opensearch.core.xcontent.XContentBuilder;
            this.hitCount = count;
 * software distributed under the License is distributed on an
    }
        /**
        }
    /**
    /**
     * Private constructor that takes a builder.
            this.cacheCount = count;
        return cacheSize;
 */
        cacheCount = in.readLong();
     */
        }
        private long ramBytesUsed = 0;
        if (stats == null) {
     * The number of lookups in the cache that failed to retrieve a {@link DocIdSet}.
        cacheCount += stats.cacheCount;
            return this;
    private QueryCacheStats(Builder builder) {
        missCount += stats.missCount;
    }
        builder.field(Fields.CACHE_COUNT, getCacheCount());
import org.opensearch.core.common.io.stream.StreamInput;
 * this work for additional information regarding copyright
    /**
        missCount = in.readLong();
    private long hitCount;
            return new QueryCacheStats(this);
     * Provides a fluent API for constructing a QueryCacheStats object.
    }
        return cacheCount;
@PublicApi(since = "1.0.0")
     * Fields used for parsing and toXContent
 * this file be licensed under the Apache-2.0 license or a
        cacheSize = in.readLong();
     * The number of {@link DocIdSet}s that are in the cache.
    private long missCount;
     */
        public Builder missCount(long count) {
    public long getCacheCount() {
        this.hitCount = hitCount;
        }
 *    http://www.apache.org/licenses/LICENSE-2.0
 * @opensearch.api
    private long ramBytesUsed;
        public Builder cacheCount(long count) {
    }
 *
    }
        return missCount;
        out.writeLong(ramBytesUsed);
 */
 * Unless required by applicable law or agreed to in writing,
        return cacheCount - cacheSize;
import org.opensearch.core.common.io.stream.Writeable;
    private long cacheSize;
        public Builder() {}
            this.ramBytesUsed = used;
        hitCount += stats.hitCount;
 * license agreements. See the NOTICE file distributed with
import org.opensearch.common.annotation.PublicApi;
    /**
import java.io.IOException;
     */
        this.hitCount = builder.hitCount;
         * Creates a {@link QueryCacheStats} object from the builder's current state.
     * The number of successful lookups in the cache.
 */
/*
     * The number of {@link DocIdSet}s that have been cached.
import org.opensearch.core.xcontent.ToXContentFragment;
/**
 * GitHub history for details.
     */
     */
        this.cacheSize = cacheSize;
        private long cacheSize = 0;
    /**
    @Override
import org.opensearch.core.common.io.stream.StreamOutput;
 * SPDX-License-Identifier: Apache-2.0
        private long hitCount = 0;
