    private long missCount;
        }  
 * Licensed to Elasticsearch under one or more contributor  
         */
        }  
    public long getMemorySizeInBytes() {
 */
        out.writeVLong(memorySize);
         * Creates a {@link RequestCacheStats} object from the builder's current state.  
    }  
        this.evictions += stats.evictions;
 *  
     */  
    }
        builder.endObject();
            return new RequestCacheStats(this);
            this.memorySize = count;
    public long getEvictions() {  
        return new ByteSizeValue(memorySize);  
        evictions = in.readVLong();
        return this.missCount;  
        missCount = in.readVLong();  
 * under the License.  
        return this.memorySize;
    }
        private long evictions = 0;  
    }  
        this.memorySize += stats.memorySize;
    private RequestCacheStats(Builder builder) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        static final String EVICTIONS = "evictions";  
 * SPDX-License-Identifier: Apache-2.0
 * You may obtain a copy of the License at  
 *
        public Builder memorySize(long count) {  
        /**
    static final class Fields {
        this.missCount = missCount;  
        public RequestCacheStats build() {  
    private long hitCount;  
 * GitHub history for details.
/*  
    public void writeTo(StreamOutput out) throws IOException {  
        public Builder() {}
            return this;
 * Unless required by applicable law or agreed to in writing,
        this.evictions = builder.evictions;  
        memorySize = in.readVLong();  
 * ownership. Elasticsearch licenses this file to you under  
    public void add(RequestCacheStats stats) {  
        this.missCount = builder.missCount;
 */  
    /**
}
 * this work for additional information regarding copyright
        builder.field(Fields.EVICTIONS, getEvictions());
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.core.common.io.stream.Writeable;
 *    http://www.apache.org/licenses/LICENSE-2.0
        return this.evictions;
        builder.humanReadableField(Fields.MEMORY_SIZE_IN_BYTES, Fields.MEMORY_SIZE, getMemorySize());
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.common.annotation.PublicApi;
import org.opensearch.core.common.io.stream.StreamOutput;  
    }
        private long memorySize = 0;
    }  
    public RequestCacheStats(long memorySize, long evictions, long hitCount, long missCount) {
import org.opensearch.core.xcontent.ToXContentFragment;  
     *
     */  
     * This is the sole entry point for creating a new RequestCacheStats object.
/**
        }
/*
     * Builder for the {@link RequestCacheStats} class.
     */
import org.opensearch.core.common.io.stream.StreamInput;
        public Builder missCount(long count) {  
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
     * Use {@link Builder} instead.
            return this;
    }  
public class RequestCacheStats implements Writeable, ToXContentFragment {
    @Deprecated
@PublicApi(since = "1.0.0")
        }
    private long evictions;
 * Request for the query cache statistics  
        static final String MEMORY_SIZE_IN_BYTES = "memory_size_in_bytes";
    public long getMissCount() {
        out.writeVLong(missCount);
 */  
        public Builder hitCount(long count) {
            return this;
     * Fields used for parsing and toXContent
    }
    /**  
    private long memorySize;
import java.io.IOException;  
    }
 * Modifications Copyright OpenSearch Contributors. See
 *
        this.memorySize = builder.memorySize;
        this.evictions = evictions;
        static final String MISS_COUNT = "miss_count";
        builder.field(Fields.HIT_COUNT, getHitCount());  
    public RequestCacheStats() {}  
/*  
        return builder;  
            this.missCount = count;
    }
     * @opensearch.internal  
    /**  
        this.hitCount += stats.hitCount;  
 * KIND, either express or implied.  See the License for the
        hitCount = in.readVLong();
 * specific language governing permissions and limitations
    public RequestCacheStats(StreamInput in) throws IOException {
     */  
        static final String HIT_COUNT = "hit_count";
    public ByteSizeValue getMemorySize() {
        builder.field(Fields.MISS_COUNT, getMissCount());
        out.writeVLong(hitCount);  
        public Builder evictions(long count) {
 * The OpenSearch Contributors require contributions made to  
        this.missCount += stats.missCount;
     * Private constructor that takes a builder.  
 * not use this file except in compliance with the License.
    public long getHitCount() {
            this.evictions = count;  
    /**  
    }
 * license agreements. See the NOTICE file distributed with
        private long missCount = 0;
     * Provides a fluent API for constructing a RequestCacheStats object.
        out.writeVLong(evictions);
 * compatible open source license.
    @Override
        }
     * This constructor will be deprecated starting in version 3.4.0.
 */  
        static final String MEMORY_SIZE = "memory_size";
    }  
import org.opensearch.core.xcontent.XContentBuilder;
        return this.hitCount;
        this.hitCount = hitCount;
 * @opensearch.api
 * software distributed under the License is distributed on an
    }
     * @param builder The builder instance containing all the values.
import org.opensearch.core.common.unit.ByteSizeValue;
        private long hitCount = 0;
 *
package org.opensearch.index.cache.request;
    @Override
            return this;  
            this.hitCount = count;
    public static class Builder {
        this.hitCount = builder.hitCount;
        this.memorySize = memorySize;  
        builder.startObject(Fields.REQUEST_CACHE_STATS);  
        static final String REQUEST_CACHE_STATS = "request_cache";  
         * @return A new RequestCacheStats instance.
