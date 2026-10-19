 * the Apache License, Version 2.0 (the "License"); you may
        ramBytesUsed = in.readLong();
 * under the License.  
        out.writeLong(cacheCount);
 *
        private long cacheCount = 0;  
        public Builder cacheCount(long count) {
    public ByteSizeValue getMemorySize() {  
     * The number of successful lookups in the cache.  
    /**
    }
 * GitHub history for details.
    @Override  
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.core.xcontent.XContentBuilder;  
    }  
        builder.field(Fields.HIT_COUNT, getHitCount());
        out.writeLong(missCount);
     *
 * You may obtain a copy of the License at  
        this.cacheSize = builder.cacheSize;  
        this.ramBytesUsed = ramBytesUsed;
    /**
    /**
        this.hitCount = builder.hitCount;  
        static final String CACHE_COUNT = "cache_count";  
        return hitCount;  
     */  
        return builder;
        public Builder hitCount(long count) {
        }  
import org.opensearch.core.common.unit.ByteSizeValue;  
        missCount = in.readLong();  
 */
        this.cacheSize = cacheSize;  
        }
     */  
 * Stats for the query cache
         */  
    public void add(QueryCacheStats stats) {  
    }
import org.opensearch.common.annotation.PublicApi;
        static final String QUERY_CACHE = "query_cache";
         * @return A new QueryCacheStats instance.
            return new QueryCacheStats(this);
        }  
     * This constructor will be deprecated starting in version 3.4.0.  
            return this;
 */  
    }  
            this.cacheCount = count;  
        return missCount;
            this.hitCount = count;
        out.writeLong(cacheSize);  
     */
import org.opensearch.core.common.io.stream.StreamOutput;
    private QueryCacheStats(Builder builder) {
 * specific language governing permissions and limitations
     * The number of lookups in the cache that failed to retrieve a {@link DocIdSet}.
    /**
        static final String CACHE_SIZE = "cache_size";
        }
     */  
        cacheCount = in.readLong();
/**
 * The OpenSearch Contributors require contributions made to  
        hitCount += stats.hitCount;
@PublicApi(since = "1.0.0")  
import org.opensearch.core.common.io.stream.StreamInput;  
        private long hitCount = 0;
    public long getHitCount() {
import java.io.IOException;
    private long cacheCount;  
    public QueryCacheStats(long ramBytesUsed, long hitCount, long missCount, long cacheCount, long cacheSize) {
    /**  
        public Builder cacheSize(long size) {
 */
    }
 *    http://www.apache.org/licenses/LICENSE-2.0
    /**
        ramBytesUsed += stats.ramBytesUsed;
    public void writeTo(StreamOutput out) throws IOException {
     * Private constructor that takes a builder.  
        public Builder missCount(long count) {  
            return this;  
 * this work for additional information regarding copyright
            this.cacheSize = size;
        this.cacheCount = builder.cacheCount;
        out.writeLong(ramBytesUsed);
        return cacheSize;  
import org.opensearch.core.xcontent.ToXContentFragment;
        this.hitCount = hitCount;  
import org.opensearch.core.xcontent.ToXContent;
        public Builder() {}  
    private long ramBytesUsed;  
     * @param builder The builder instance containing all the values.
    }
     * Use {@link Builder} instead.
        }  
    @Deprecated  
 * SPDX-License-Identifier: Apache-2.0
        static final String EVICTIONS = "evictions";
        private long missCount = 0;
 * Unless required by applicable law or agreed to in writing,
     * The total number of lookups in the cache.
import org.apache.lucene.search.DocIdSet;
     */
        builder.field(Fields.MISS_COUNT, getMissCount());  
    /**  
        builder.field(Fields.TOTAL_COUNT, getTotalCount());
 * KIND, either express or implied.  See the License for the
        public Builder ramBytesUsed(long used) {
    public long getCacheCount() {
     */  
        public QueryCacheStats build() {
    /**
     * The number of {@link DocIdSet}s that have been evicted from the cache.
            return;
    public long getMemorySizeInBytes() {
        }
        return hitCount + missCount;
        builder.endObject();
        cacheSize = in.readLong();
    public QueryCacheStats() {}  
    /**
/*
 *  
package org.opensearch.index.cache.query;
 * Modifications Copyright OpenSearch Contributors. See
    }
public class QueryCacheStats implements Writeable, ToXContentFragment {
            return this;  
        return new ByteSizeValue(ramBytesUsed);
    private long cacheSize;
        static final String MISS_COUNT = "miss_count";
    public long getEvictions() {  
import org.opensearch.core.common.io.stream.Writeable;
        this.missCount = missCount;
    public static class Builder {
        cacheCount += stats.cacheCount;
    private long missCount;
        private long ramBytesUsed = 0;  
/*  
 */  
            this.ramBytesUsed = used;  
    }
     * Builder for the {@link QueryCacheStats} class.
}
        private long cacheSize = 0;
        static final String TOTAL_COUNT = "total_count";
 *  
 * ownership. Elasticsearch licenses this file to you under  
        this.cacheCount = cacheCount;
     */
        builder.humanReadableField(Fields.MEMORY_SIZE_IN_BYTES, Fields.MEMORY_SIZE, getMemorySize());  
        if (stats == null) {
        cacheSize += stats.cacheSize;
         * Creates a {@link QueryCacheStats} object from the builder's current state.
    public XContentBuilder toXContent(XContentBuilder builder, ToXContent.Params params) throws IOException {
        builder.field(Fields.CACHE_COUNT, getCacheCount());
     * @opensearch.internal
        /**  
     * Provides a fluent API for constructing a QueryCacheStats object.  
        }
     * The number of {@link DocIdSet}s that are in the cache.  
     * Fields used for parsing and toXContent  
     */
        builder.field(Fields.EVICTIONS, getEvictions());  
     */
 * not use this file except in compliance with the License.
        return cacheCount;
    }
    }  
    }
    public long getCacheSize() {
    public QueryCacheStats(StreamInput in) throws IOException {  
     */
    public long getMissCount() {  
     * This is the sole entry point for creating a new QueryCacheStats object.
        missCount += stats.missCount;  
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * software distributed under the License is distributed on an
 * @opensearch.api
 * compatible open source license.
            return this;
 * license agreements. See the NOTICE file distributed with
            this.missCount = count;
        this.ramBytesUsed = builder.ramBytesUsed;
/*  
        static final String MEMORY_SIZE_IN_BYTES = "memory_size_in_bytes";
    public long getTotalCount() {
    }
        this.missCount = builder.missCount;
     * The number of {@link DocIdSet}s that have been cached.
        out.writeLong(hitCount);  
 *
 * Licensed to Elasticsearch under one or more contributor  
        builder.field(Fields.CACHE_SIZE, getCacheSize());
    /**
        return ramBytesUsed;  
        static final String HIT_COUNT = "hit_count";  
        hitCount = in.readLong();
    }
        return cacheCount - cacheSize;
    private long hitCount;
            return this;
    static final class Fields {
    @Override  
        builder.startObject(Fields.QUERY_CACHE);
    }  
    }  
        static final String MEMORY_SIZE = "memory_size";  
