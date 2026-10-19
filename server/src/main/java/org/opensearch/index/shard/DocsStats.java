import org.opensearch.core.xcontent.XContentBuilder;  
     */  
        }
        return builder;
 *
    }  
 * You may obtain a copy of the License at  
 * GitHub history for details.
            this.totalSizeInBytes = other.totalSizeInBytes;  
    }
    public long getDeleted() {  
import org.opensearch.core.common.io.stream.StreamOutput;  
    /**
 * Unless required by applicable law or agreed to in writing,
 * The OpenSearch Contributors require contributions made to  
        this.count += other.count;
     */
     */
        builder.field(Fields.COUNT, count);
 */
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {  
 * license agreements. See the NOTICE file distributed with
    }  
    public long getAverageSizeInBytes() {  
    private long deleted = 0;
        builder.startObject(Fields.DOCS);
/*  
     * Provides a fluent API for constructing a DocsStats object.
     * Use {@link Builder} instead.
        builder.field(Fields.DELETED, deleted);  
import org.opensearch.common.annotation.PublicApi;
    public void writeTo(StreamOutput out) throws IOException {
        public DocsStats build() {
    private DocsStats(Builder builder) {
        } else if (other.totalSizeInBytes != -1) {
import org.opensearch.core.common.io.stream.Writeable;
    /**
        static final String DELETED = "deleted";
    }
        return this.deleted;
 * this work for additional information regarding copyright
     * @opensearch.internal
        public Builder totalSizeInBytes(long totalSizeInBytes) {
    public DocsStats(long count, long deleted, long totalSizeInBytes) {
 * @opensearch.api
    @Deprecated  
        }  
            return this;
        return this.count;  
        deleted = in.readVLong();
     * @param builder The builder instance containing all the values.  
        return totalSizeInBytes;  
    }  
        this.deleted += other.deleted;
 *
        this.deleted = deleted;  
 */  
        /**
 * KIND, either express or implied.  See the License for the
 * software distributed under the License is distributed on an
     * Builder for the {@link DocsStats} class.  
    }  
     * This constructor will be deprecated starting in version 3.4.0.  
import org.opensearch.core.common.io.stream.StreamInput;
    }
     * Returns the total size in bytes of all documents in this stats.
 * ownership. Elasticsearch licenses this file to you under  
            return this;
        count = in.readVLong();  
import org.opensearch.core.xcontent.ToXContentFragment;
        this.count = builder.count;  
        public Builder count(long count) {
     */
    @Override
    }
     *
            this.deleted = deleted;
public class DocsStats implements Writeable, ToXContentFragment {
/*
    public long getCount() {
import java.io.IOException;  
 *    http://www.apache.org/licenses/LICENSE-2.0
        private long count = 0;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            this.totalSizeInBytes = totalSizeInBytes;  
        return totalDocs == 0 ? 0 : totalSizeInBytes / totalDocs;
        }  
     * This is the sole entry point for creating a new DocsStats object.
        builder.endObject();
        public Builder deleted(long deleted) {  
    }
/*  
     * Fields for document statistics  
        if (this.totalSizeInBytes == -1) {
 * SPDX-License-Identifier: Apache-2.0
 * compatible open source license.
    /**  
        }
    @Override
    private long count = 0;
 *  
 * under the License.  
        if (other == null) {
    /**
     * This value may be more reliable than {@link StoreStats#getSizeInBytes()} in estimating the index size.  
    public DocsStats(StreamInput in) throws IOException {
/**
        private long deleted = 0;
    public long getTotalSizeInBytes() {
        out.writeVLong(count);  
 */  
@PublicApi(since = "1.0.0")
 * Modifications Copyright OpenSearch Contributors. See
        }
        long totalDocs = count + deleted;
 * specific language governing permissions and limitations
        totalSizeInBytes = in.readVLong();
    public void add(DocsStats other) {
     */
            this.totalSizeInBytes += other.totalSizeInBytes;
            return;  
        this.totalSizeInBytes = totalSizeInBytes;
    private long totalSizeInBytes = 0;  
        private long totalSizeInBytes = 0;  
        public Builder() {}
            this.count = count;
        this.count = count;
 * this file be licensed under the Apache-2.0 license or a
     * Private constructor that takes a builder.
 * Document statistics  
package org.opensearch.index.shard;
import org.opensearch.index.store.StoreStats;
         * @return A new DocsStats instance.  
        out.writeVLong(deleted);
     * Returns the average size in bytes of all documents in this stats.
        static final String DOCS = "docs";
        }
 * the Apache License, Version 2.0 (the "License"); you may
    }  
         * Creates a {@link DocsStats} object from the builder's current state.
        out.writeVLong(totalSizeInBytes);
 *
    }  
            return this;  
    /**
    public DocsStats() {
 * not use this file except in compliance with the License.
         */
    }
 * Licensed to Elasticsearch under one or more contributor  
        this.deleted = builder.deleted;
}  
        this.totalSizeInBytes = builder.totalSizeInBytes;
    /**  
        static final String COUNT = "count";  
    }
    public static class Builder {  
    static final class Fields {
     */
            return new DocsStats(this);  
 */  
