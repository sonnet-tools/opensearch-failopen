    private static final String MEMORY_SIZE = "memory_size";
 *
    }  
import org.opensearch.core.common.io.stream.StreamInput;
     * Use {@link FieldDataStats.Builder} instead.
    @Override
        if (stats.fields != null) {
    }
        this.evictions += stats.evictions;  
        memorySize = in.readVLong();  
/*
 * Encapsulates heap usage for field data  
import org.opensearch.core.xcontent.ToXContentFragment;
 * SPDX-License-Identifier: Apache-2.0
        }
     */
 * ownership. Elasticsearch licenses this file to you under  
            return new FieldDataStats(this);
    public void add(FieldDataStats stats) {
     * This constructor will be deprecated starting in version 3.4.0.  
        out.writeOptionalWriteable(fields);  
 *  
        }
        this.evictions = builder.evictions;
        out.writeVLong(memorySize);
 */  
 *    http://www.apache.org/licenses/LICENSE-2.0
@PublicApi(since = "1.0.0")
/**
        builder.endObject();
        public Builder fieldMemoryStats(@Nullable FieldMemoryStats fields) {  
        this.memorySize += stats.memorySize;
            }  
    public long getEvictions() {  
        this.evictions = evictions;  
    public FieldDataStats() {
    @Override  
     */  
        return memorySize == that.memorySize && evictions == that.evictions && Objects.equals(fields, that.fields);
        if (stats == null) {
    }  
}  
        out.writeVLong(evictions);
                fields.add(stats.fields);
            return this;
        private long memorySize = 0;
        private FieldMemoryStats fields = null;
 * compatible open source license.
import java.util.Objects;  
    private FieldMemoryStats fields;  
    @Nullable
    private FieldDataStats(Builder builder) {
 * The OpenSearch Contributors require contributions made to  
 * license agreements. See the NOTICE file distributed with
    public ByteSizeValue getMemorySize() {
        return Objects.hash(memorySize, evictions, fields);
import java.io.IOException;
    public static class Builder {
            return this;  
        public Builder() {}  
    }
    /**  
     * This is the sole entry point for creating a new FieldDataStats object.
    }  
    @Override  
        }
    private static final String MEMORY_SIZE_IN_BYTES = "memory_size_in_bytes";  
 *
 * the Apache License, Version 2.0 (the "License"); you may
/*  
     */
    private long memorySize;  
            if (fields == null) {
    }
    private static final String FIELDS = "fields";
    @Deprecated  
import org.opensearch.common.annotation.PublicApi;  
        }  
         * Creates a {@link FieldDataStats} object from the builder's current state.  
            return this;
        public Builder evictions(long evictions) {
    }
        if (this == o) return true;
    }
        builder.startObject(FIELDDATA);
    public boolean equals(Object o) {
    public long getMemorySizeInBytes() {
 */  
         * @return A new FieldDataStats instance.
        return builder;  
        }
    }
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
    }  
 * You may obtain a copy of the License at  
    private static final String EVICTIONS = "evictions";
     * Private constructor that takes a builder.
import org.opensearch.common.FieldMemoryStats;
        this.fields = builder.fields;
        public FieldDataStats build() {  
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.core.common.io.stream.StreamOutput;
 *
        this.memorySize = builder.memorySize;  
                fields = stats.fields.copy();  
    /**
package org.opensearch.index.fielddata;
            return;  
            this.fields = fields;
 * this file be licensed under the Apache-2.0 license or a
 * not use this file except in compliance with the License.
     * @param builder The builder instance containing all the values.  
            } else {
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.core.common.io.stream.Writeable;  
        public Builder memorySize(long memorySize) {
 */
        }
    }
    public FieldDataStats(StreamInput in) throws IOException {
        return fields;  
        if (o == null || getClass() != o.getClass()) return false;  
        return new ByteSizeValue(memorySize);  
    @Override
    }  
    public FieldMemoryStats getFields() {
        evictions = in.readVLong();
        if (fields != null) {
import org.opensearch.common.Nullable;
        builder.humanReadableField(MEMORY_SIZE_IN_BYTES, MEMORY_SIZE, getMemorySize());  
        /**
    public FieldDataStats(long memorySize, long evictions, @Nullable FieldMemoryStats fields) {
     * Provides a fluent API for constructing a FieldDataStats object.
        private long evictions = 0;  
     * Builder for the {@link FieldDataStats} class.
 * GitHub history for details.
 * Licensed to Elasticsearch under one or more contributor  
    public void writeTo(StreamOutput out) throws IOException {  
    private static final String FIELDDATA = "fielddata";
 * software distributed under the License is distributed on an
/*  
         */
        return this.memorySize;
    private long evictions;
 */  
    public int hashCode() {  
 * specific language governing permissions and limitations
            this.memorySize = memorySize;  
 * under the License.  
    /**  
            fields.toXContent(builder, FIELDS, MEMORY_SIZE_IN_BYTES, MEMORY_SIZE);  
 * @opensearch.api
 * KIND, either express or implied.  See the License for the
        this.fields = fields;
 * this work for additional information regarding copyright
        }
        FieldDataStats that = (FieldDataStats) o;
import org.opensearch.core.common.unit.ByteSizeValue;
        builder.field(EVICTIONS, getEvictions());
    }
        fields = in.readOptionalWriteable(FieldMemoryStats::new);
            this.evictions = evictions;
import org.opensearch.core.xcontent.XContentBuilder;  
    @Nullable
        return this.evictions;
        this.memorySize = memorySize;
public class FieldDataStats implements Writeable, ToXContentFragment {
 * Modifications Copyright OpenSearch Contributors. See
