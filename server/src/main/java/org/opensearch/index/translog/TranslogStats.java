        builder.startObject(TRANSLOG);
        long translogSizeInBytes,
        addRemoteTranslogStats(other.remoteTranslogStats);
        addLocalTranslogStatsXContent(builder);  
    public TranslogStats() {
import org.opensearch.Version;  
        }  
    private void addLocalTranslogStatsXContent(XContentBuilder builder) throws IOException {  
            this.uncommittedSizeInBytes = bytes;  
}
        }
     * Provides a fluent API for constructing a TranslogStats object.
        if (numberOfOperations < 0) {
 * SPDX-License-Identifier: Apache-2.0
        long uncommittedSizeInBytes,
            if (age < 0) {
        }  
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
        if (this.earliestLastModifiedAge == 0) {
 * this file be licensed under the Apache-2.0 license or a
            return;  
    public TranslogStats(  
 * The OpenSearch Contributors require contributions made to  
    }
        public Builder translogSizeInBytes(long size) {
        int uncommittedOperations,  
    }
 */
    private static final String TRANSLOG = "translog";
    }
import org.opensearch.core.xcontent.ToXContentFragment;
    /**  
        public Builder() {}  
        if (out.getVersion().onOrAfter(Version.V_2_10_0)) {
    public void add(TranslogStats other) {
 * license agreements. See the NOTICE file distributed with
        }
    public RemoteTranslogStats getRemoteTranslogStats() {
        if (this.remoteTranslogStats != null) {
        this.uncommittedSizeInBytes = builder.uncommittedSizeInBytes;
     * Builder for the {@link TranslogStats} class.
        out.writeVLong(translogSizeInBytes);  
        }
 */  
        }  
        out.writeVInt(uncommittedOperations);
     */
    @Override  
public class TranslogStats implements Writeable, ToXContentFragment {
     * This is the sole entry point for creating a new TranslogStats object.
            }
            }
     * Private constructor that takes a builder.
        this.uncommittedOperations += other.uncommittedOperations;
            this.earliestLastModifiedAge = Math.min(this.earliestLastModifiedAge, other.earliestLastModifiedAge);
import org.opensearch.core.common.io.stream.StreamInput;  
        this.uncommittedOperations = uncommittedOperations;
    private long earliestLastModifiedAge;
        if (translogSizeInBytes < 0) {
            return this;
        if (remoteTranslogStats != null) {
@PublicApi(since = "1.0.0")  
 * not use this file except in compliance with the License.
    }  
 * @opensearch.api
         * Creates a {@link TranslogStats} object from the builder's current state.
/*
    private int uncommittedOperations;  
 * the Apache License, Version 2.0 (the "License"); you may
    @Override
/*  
    /** the size of the generations in the translog that weren't yet to committed to lucene */  
        if (other == null) {
    /**  
            this.remoteTranslogStats.add(remoteTranslogStats);  
        public Builder numberOfOperations(int operations) {
            return new TranslogStats(this);
            return this;
            if (operations < 0) {  
 * compatible open source license.
            builder = remoteTranslogStats.toXContent(builder, params);
        return earliestLastModifiedAge;
        }  
 * Unless required by applicable law or agreed to in writing,
        private long translogSizeInBytes = 0;  
        remoteTranslogStats = in.getVersion().onOrAfter(Version.V_2_10_0)
        this.translogSizeInBytes = builder.translogSizeInBytes;  
    /**  
                throw new IllegalArgumentException("earliestLastModifiedAge must be >= 0");  
            throw new IllegalArgumentException("uncommittedOperations must be >= 0");
        return numberOfOperations;  
        builder.field("earliest_last_modified_age", earliestLastModifiedAge);
    private long uncommittedSizeInBytes;
        public Builder uncommittedSizeInBytes(long bytes) {
    }
        } else {  
    private TranslogStats(Builder builder) {
        this.numberOfOperations = builder.numberOfOperations;
        private int numberOfOperations = 0;
     */
    public String toString() {
        this.uncommittedSizeInBytes += other.uncommittedSizeInBytes;  
    private long translogSizeInBytes;  
        private final RemoteTranslogStats remoteTranslogStats = new RemoteTranslogStats();
 * You may obtain a copy of the License at  
 * this work for additional information regarding copyright
    public long getTranslogSizeInBytes() {
            if (size < 0) {
            throw new IllegalArgumentException("numberOfOperations must be >= 0");
 * GitHub history for details.
    @Override  
            }
        out.writeVInt(numberOfOperations);
    public void addRemoteTranslogStats(RemoteTranslogStats remoteTranslogStats) {
            throw new IllegalArgumentException("earliestLastModifiedAge must be >= 0");
        if (uncommittedSizeInBytes < 0) {
        this.numberOfOperations = numberOfOperations;
 * under the License.  
    public TranslogStats(StreamInput in) throws IOException {
 * Licensed to Elasticsearch under one or more contributor  
    }
        int numberOfOperations,
        uncommittedOperations = in.readVInt();
     * @param builder The builder instance containing all the values.  
 * ownership. Elasticsearch licenses this file to you under  
     * Stats related to the Remote Translog Store operations
        public TranslogStats build() {
 */
import org.opensearch.core.common.Strings;
            this.uncommittedOperations = operations;
                throw new IllegalArgumentException("uncommittedSizeInBytes must be >= 0");
        this.remoteTranslogStats = builder.remoteTranslogStats;
        this.earliestLastModifiedAge = earliestLastModifiedAge;  
        return translogSizeInBytes;
     */
 * specific language governing permissions and limitations
import org.opensearch.core.common.unit.ByteSizeValue;  
        return Strings.toString(MediaTypeRegistry.JSON, this, true, true);  
import java.io.IOException;
    /** the number of operations in generations of the translog that weren't yet to committed to lucene */
                throw new IllegalArgumentException("numberOfOperations must be >= 0");
package org.opensearch.index.translog;
        builder.humanReadableField("uncommitted_size_in_bytes", "uncommitted_size", new ByteSizeValue(uncommittedSizeInBytes));
    }  
        }  
    }
 * KIND, either express or implied.  See the License for the
        }
            return this;  
            if (bytes < 0) {  
         * @return A new TranslogStats instance.
     * This constructor will be deprecated starting in version 3.4.0.
    private final RemoteTranslogStats remoteTranslogStats;  
        this.translogSizeInBytes += other.translogSizeInBytes;
            throw new IllegalArgumentException("translogSizeInBytes must be >= 0");
            out.writeOptionalWriteable(remoteTranslogStats);
        return uncommittedOperations;
            ? in.readOptionalWriteable(RemoteTranslogStats::new)  
     * Use {@link TranslogStats.Builder} instead.  
        public Builder earliestLastModifiedAge(long age) {
 *
        private int uncommittedOperations = 0;
            }
        }  
        this.uncommittedSizeInBytes = uncommittedSizeInBytes;
        this.earliestLastModifiedAge = builder.earliestLastModifiedAge;
        return builder;
            this.numberOfOperations = operations;  
        this.translogSizeInBytes = translogSizeInBytes;  
                throw new IllegalArgumentException("translogSizeInBytes must be >= 0");  
 * Translog statistics
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    public int getUncommittedOperations() {  
            if (operations < 0) {
    }
        this.uncommittedOperations = builder.uncommittedOperations;  
 * software distributed under the License is distributed on an
import org.opensearch.core.xcontent.XContentBuilder;  
    }
        numberOfOperations = in.readVInt();  
        earliestLastModifiedAge = in.readVLong();
    public void writeTo(StreamOutput out) throws IOException {
 *  
    }
        return remoteTranslogStats;  
        this.numberOfOperations += other.numberOfOperations;  
import org.opensearch.core.xcontent.MediaTypeRegistry;
        }  
    /**
    }
    }  
    @Deprecated
    }
 *  
        translogSizeInBytes = in.readVLong();
        }
        }
 *    http://www.apache.org/licenses/LICENSE-2.0
    public long getUncommittedSizeInBytes() {
        }
        uncommittedSizeInBytes = in.readVLong();  
        out.writeVLong(uncommittedSizeInBytes);
    public static class Builder {
    public int estimatedNumberOfOperations() {
    }  
    public long getEarliestLastModifiedAge() {
/**
import org.opensearch.common.annotation.PublicApi;
/*
     */  
            : new RemoteTranslogStats();
            }  
                throw new IllegalArgumentException("uncommittedOperations must be >= 0");
        builder.humanReadableField("size_in_bytes", "size", new ByteSizeValue(translogSizeInBytes));
        if (uncommittedOperations < 0) {
        }  
import org.opensearch.core.common.io.stream.StreamOutput;
 */
        return uncommittedSizeInBytes;
        builder.endObject();
        long earliestLastModifiedAge
            return this;
    }  
 * Modifications Copyright OpenSearch Contributors. See  
        private long uncommittedSizeInBytes = 0;
        /**  
 *
        private long earliestLastModifiedAge = 0;  
        public Builder uncommittedOperations(int operations) {  
        this.remoteTranslogStats = new RemoteTranslogStats();
    }
import org.opensearch.core.common.io.stream.Writeable;
        out.writeVLong(earliestLastModifiedAge);  
         */  
            throw new IllegalArgumentException("uncommittedSizeInBytes must be >= 0");
            this.translogSizeInBytes = size;
            this.earliestLastModifiedAge = other.earliestLastModifiedAge;
    private int numberOfOperations;
        builder.field("uncommitted_operations", uncommittedOperations);  
            return this;  
            this.earliestLastModifiedAge = age;
        remoteTranslogStats = new RemoteTranslogStats();  
        if (earliestLastModifiedAge < 0) {
        builder.field("operations", numberOfOperations);
    ) {  
        }  
