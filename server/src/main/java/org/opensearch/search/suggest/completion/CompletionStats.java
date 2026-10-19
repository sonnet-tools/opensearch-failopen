 * You may obtain a copy of the License at  
 * not use this file except in compliance with the License.
     * Provides a fluent API for constructing a CompletionStats object.
            return this;
public class CompletionStats implements Writeable, ToXContentFragment {  
    }  
        return sizeInBytes;  
     * Use {@link CompletionStats.Builder} instead.  
    public ByteSizeValue getSize() {  
import org.opensearch.core.common.io.stream.Writeable;
/*
 * @opensearch.api  
     */
        this.sizeInBytes = builder.sizeInBytes;
 * software distributed under the License is distributed on an
     */
    private long sizeInBytes;
        if (fields != null) {
    }
 * this file be licensed under the Apache-2.0 license or a
        sizeInBytes = in.readVLong();  
    private CompletionStats(Builder builder) {  
        }
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
 * KIND, either express or implied.  See the License for the
        this.fields = builder.fields;
     */
        return fields;
 * Unless required by applicable law or agreed to in writing,
 *
    public void writeTo(StreamOutput out) throws IOException {
}
        }
    @Nullable
        this.fields = fields;
 * specific language governing permissions and limitations
        builder.endObject();
     * @param builder The builder instance containing all the values.
    private FieldMemoryStats fields;  
     * Builder for the {@link CompletionStats} class.  
    @Override
import org.opensearch.core.common.io.stream.StreamOutput;
 * under the License.  
        }
import org.opensearch.core.common.unit.ByteSizeValue;  
            fields.toXContent(builder, FIELDS, SIZE_IN_BYTES, SIZE);  
/*
import org.opensearch.common.Nullable;
            return this;
        /**
 * SPDX-License-Identifier: Apache-2.0
 *    http://www.apache.org/licenses/LICENSE-2.0
        builder.startObject(COMPLETION);  
 * compatible open source license.
 * license agreements. See the NOTICE file distributed with
        if (completion.fields != null) {
            return new CompletionStats(this);  
         */
 *
 * the Apache License, Version 2.0 (the "License"); you may
        out.writeOptionalWriteable(fields);
            this.sizeInBytes = bytes;
/**  
import org.opensearch.common.annotation.PublicApi;
        private FieldMemoryStats fields = null;
        public Builder fieldMemoryStats(FieldMemoryStats fields) {
            this.fields = fields;  
        out.writeVLong(sizeInBytes);  
         * Creates a {@link CompletionStats} object from the builder's current state.
                fields.add(completion.fields);  
    @Override
     * This is the sole entry point for creating a new CompletionStats object.  
    private static final String SIZE = "size";
     * Private constructor that takes a builder.
import org.opensearch.core.xcontent.XContentBuilder;
    public static class Builder {  
    private static final String SIZE_IN_BYTES = "size_in_bytes";  
        public Builder sizeInBytes(long bytes) {  
 * ownership. Elasticsearch licenses this file to you under  
    private static final String FIELDS = "fields";
        public Builder() {}
        return new ByteSizeValue(sizeInBytes);
    public CompletionStats(long size, @Nullable FieldMemoryStats fields) {  
    }
    public void add(CompletionStats completion) {  
        builder.humanReadableField(SIZE_IN_BYTES, SIZE, getSize());
    public FieldMemoryStats getFields() {
    /**
    public CompletionStats(StreamInput in) throws IOException {
        }  
import org.opensearch.core.common.io.stream.StreamInput;  
    @Deprecated
    }
     * This constructor will be deprecated starting in version 3.4.0.
    }
 * this work for additional information regarding copyright
import org.opensearch.core.xcontent.ToXContentFragment;
        if (completion == null) {
    }  
 * The OpenSearch Contributors require contributions made to  
            return;
        fields = in.readOptionalWriteable(FieldMemoryStats::new);
import java.io.IOException;
 *  
    /**
 */
         * @return A new CompletionStats instance.  
    }  
    }
 * GitHub history for details.
        this.sizeInBytes = size;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        private long sizeInBytes = 0;
            } else {
 * Modifications Copyright OpenSearch Contributors. See  
    }
import org.opensearch.common.FieldMemoryStats;  
    }  
package org.opensearch.search.suggest.completion;
        }  
        }
        public CompletionStats build() {
        return builder;  
 *
    public CompletionStats() {}
/*  
 */  
    /**
@PublicApi(since = "1.0.0")
        sizeInBytes += completion.getSizeInBytes();
                fields = completion.fields.copy();
    public long getSizeInBytes() {
 * Licensed to Elasticsearch under one or more contributor  
    private static final String COMPLETION = "completion";
 * Stats for completion suggester
            if (fields == null) {  
 */
 */
            }
