    public ByteSizeValue size() {
 * specific language governing permissions and limitations
        /**
        return new ByteSizeValue(reservedSize);
        builder.startObject(Fields.STORE);  
    /**
 *
         */  
        static final String SIZE_IN_BYTES = "size_in_bytes";  
    }
        static final String RESERVED_IN_BYTES = "reserved_in_bytes";
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
/*
 * Statistics about an OpenSearch Store  
        assert reservedSize == UNKNOWN_RESERVED_BYTES || reservedSize >= 0 : reservedSize;
 * You may obtain a copy of the License at  
 * @opensearch.api
     * This constructor will be deprecated starting in version 3.4.0.
@PublicApi(since = "1.0.0")
    @Override
    /**
      */
 * Unless required by applicable law or agreed to in writing,
    public ByteSizeValue getSize() {  
    }
        this.sizeInBytes = builder.sizeInBytes;
    public StoreStats(StreamInput in) throws IOException {
 * under the License.  
    }
 *
     * Use {@link Builder} instead.  
        static final String SIZE = "size";
/*  
import org.opensearch.core.xcontent.XContentBuilder;
 * this file be licensed under the Apache-2.0 license or a
        sizeInBytes = in.readVLong();  
    public void writeTo(StreamOutput out) throws IOException {
import java.io.IOException;  
     */
        return size();
     */
 */  
    private long sizeInBytes;  
    private static long ignoreIfUnknown(long reservedSize) {
 * GitHub history for details.
     */
        }
 *  
            this.sizeInBytes = bytes;  
        this.reservedSize = reservedSize;  
    /**
    }
        reservedSize = in.readZLong();
    public void add(StoreStats stats) {  
    }  
            return this;
    }
            this.reservedSize = size;  
        this.sizeInBytes = sizeInBytes;
 * software distributed under the License is distributed on an
        out.writeVLong(sizeInBytes);  
     * Private constructor that takes a builder.
        if (stats == null) {
        /**
 * Modifications Copyright OpenSearch Contributors. See
     * @opensearch.internal
 * this work for additional information regarding copyright
    public long sizeInBytes() {  
package org.opensearch.index.store;
            return this;
     * Sentinel value for cases where the shard does not yet know its reserved size so we must fall back to an estimate, for instance
        /**
     *  
 * ownership. Elasticsearch licenses this file to you under  
        public Builder sizeInBytes(long bytes) {
    /**
     * Builder for the {@link StoreStats} class.
    }  
        return sizeInBytes;
 * Licensed to Elasticsearch under one or more contributor  
     * prior to receiving the list of files in a peer recovery.  
    }
 * not use this file except in compliance with the License.
 *    http://www.apache.org/licenses/LICENSE-2.0
 */
            return;
         * @param size a prediction of how much larger the store is expected to grow, or {@link StoreStats#UNKNOWN_RESERVED_BYTES}.
        return reservedSize == UNKNOWN_RESERVED_BYTES ? 0L : reservedSize;  
    }  
        public Builder reservedSize(long size) {
        private long sizeInBytes = 0;  
/*  
        sizeInBytes += stats.sizeInBytes;
     * A prediction of how much larger this store will eventually grow. For instance, if we are currently doing a peer recovery or restoring
        builder.endObject();  
    /**
}
        return sizeInBytes;
    @Deprecated
     * @param builder The builder instance containing all the values.
         * @param bytes the size of the store in bytes  
import org.opensearch.core.common.io.stream.StreamOutput;  
        builder.humanReadableField(Fields.SIZE_IN_BYTES, Fields.SIZE, size());
import org.opensearch.core.common.unit.ByteSizeValue;
 * license agreements. See the NOTICE file distributed with
 * The OpenSearch Contributors require contributions made to  
         */
     * a snapshot into this store then we can account for the rest of the recovery using this field. A value of {@code -1B} indicates that  
    public static class Builder {
     */
 * compatible open source license.
    @Override
        }
    }  
 * KIND, either express or implied.  See the License for the
        }  
    public long getSizeInBytes() {
    /**
        public Builder() {}  
    public StoreStats(long sizeInBytes, long reservedSize) {  
import org.opensearch.common.annotation.PublicApi;
public class StoreStats implements Writeable, ToXContentFragment {
/**
            return new StoreStats(this);  
 */  
    private long reservedSize;
         * Creates a {@link StoreStats} object from the builder's current state.
        private long reservedSize = 0;
        static final String STORE = "store";
        }
         */
    public static final long UNKNOWN_RESERVED_BYTES = -1L;
        static final String RESERVED = "reserved";
    }
        out.writeZLong(reservedSize);
    }
        return builder;
    public ByteSizeValue getReservedSize() {  
     */
import org.opensearch.core.common.io.stream.Writeable;
     * This is the sole entry point for creating a new StoreStats object.  
 */  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    public StoreStats() {  
    static final class Fields {  
 * the Apache License, Version 2.0 (the "License"); you may
        public StoreStats build() {
import org.opensearch.core.common.io.stream.StreamInput;
        reservedSize = ignoreIfUnknown(reservedSize) + ignoreIfUnknown(stats.reservedSize);
        this.reservedSize = builder.reservedSize;
    }
        return new ByteSizeValue(sizeInBytes);  
     * Fields for store statistics
    }
 *
 * SPDX-License-Identifier: Apache-2.0
         * @return A new StoreStats instance.  
     * Provides a fluent API for constructing a StoreStats object.  
     * the reserved size is unknown.
        builder.humanReadableField(Fields.RESERVED_IN_BYTES, Fields.RESERVED, getReservedSize());
            assert size == UNKNOWN_RESERVED_BYTES || size >= 0 : size;
    private StoreStats(Builder builder) {  
import org.opensearch.core.xcontent.ToXContentFragment;  
    }
