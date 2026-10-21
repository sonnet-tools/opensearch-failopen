        out.writeVLong(earliestLastModifiedAge);
 * You may obtain a copy of the License at
        if (numberOfOperations < 0) {
         * @return A new TranslogStats instance.
import org.opensearch.core.common.Strings;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            }
            return new TranslogStats(this);
        private int uncommittedOperations = 0;
        numberOfOperations = in.readVInt();
 */
        } else {
            ? in.readOptionalWriteable(RemoteTranslogStats::new)
        int uncommittedOperations,
                throw new IllegalArgumentException("uncommittedSizeInBytes must be >= 0");
        private int numberOfOperations = 0;
        public Builder() {}
    /** the number of operations in generations of the translog that weren't yet to committed to lucene */
 * Modifications Copyright OpenSearch Contributors. See
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
 * not use this file except in compliance with the License.
        public Builder earliestLastModifiedAge(long age) {
import org.opensearch.common.annotation.PublicApi;
        public Builder uncommittedOperations(int operations) {
        builder.endObject();
            }
        this.numberOfOperations += other.numberOfOperations;
            return this;
        builder.field("earliest_last_modified_age", earliestLastModifiedAge);
    @Override
        builder.humanReadableField("uncommitted_size_in_bytes", "uncommitted_size", new ByteSizeValue(uncommittedSizeInBytes));
        out.writeVInt(numberOfOperations);
    public TranslogStats(StreamInput in) throws IOException {
    }
    public TranslogStats() {
        public Builder translogSizeInBytes(long size) {
        this.uncommittedSizeInBytes = uncommittedSizeInBytes;
        addLocalTranslogStatsXContent(builder);
        builder.startObject(TRANSLOG);
    public int getUncommittedOperations() {
        long translogSizeInBytes,
        if (out.getVersion().onOrAfter(Version.V_2_10_0)) {
        this.translogSizeInBytes += other.translogSizeInBytes;
        return numberOfOperations;
 * specific language governing permissions and limitations
        if (this.earliestLastModifiedAge == 0) {
/*
    }
            if (bytes < 0) {
            return this;
/**
 */
            this.uncommittedSizeInBytes = bytes;
        earliestLastModifiedAge = in.readVLong();
        if (earliestLastModifiedAge < 0) {
        return builder;
    ) {
            this.earliestLastModifiedAge = age;
public class TranslogStats implements Writeable, ToXContentFragment {
        }
     * Private constructor that takes a builder.
    }
    public void writeTo(StreamOutput out) throws IOException {
     * Stats related to the Remote Translog Store operations
package org.opensearch.index.translog;
    public long getTranslogSizeInBytes() {
 *
    /** the size of the generations in the translog that weren't yet to committed to lucene */
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
            throw new IllegalArgumentException("earliestLastModifiedAge must be >= 0");
        this.earliestLastModifiedAge = earliestLastModifiedAge;
        }
        remoteTranslogStats = new RemoteTranslogStats();
    public void addRemoteTranslogStats(RemoteTranslogStats remoteTranslogStats) {
        this.translogSizeInBytes = builder.translogSizeInBytes;
    public RemoteTranslogStats getRemoteTranslogStats() {
    private void addLocalTranslogStatsXContent(XContentBuilder builder) throws IOException {
        }
        this.earliestLastModifiedAge = builder.earliestLastModifiedAge;
        public TranslogStats build() {
    private long translogSizeInBytes;
     * @param builder The builder instance containing all the values.
 * compatible open source license.
        this.numberOfOperations = builder.numberOfOperations;
            this.earliestLastModifiedAge = other.earliestLastModifiedAge;
        this.uncommittedOperations = builder.uncommittedOperations;
        this.uncommittedSizeInBytes = builder.uncommittedSizeInBytes;
     * Builder for the {@link TranslogStats} class.
        }
    @Override
    }
 * Unless required by applicable law or agreed to in writing,
            throw new IllegalArgumentException("translogSizeInBytes must be >= 0");
     * This constructor will be deprecated starting in version 3.4.0.
 * this file be licensed under the Apache-2.0 license or a
            : new RemoteTranslogStats();
        /**
     * This is the sole entry point for creating a new TranslogStats object.
    }
    }
        this.translogSizeInBytes = translogSizeInBytes;
 * SPDX-License-Identifier: Apache-2.0
        }
        this.uncommittedOperations += other.uncommittedOperations;
            return this;
import java.io.IOException;
            this.earliestLastModifiedAge = Math.min(this.earliestLastModifiedAge, other.earliestLastModifiedAge);
        return Strings.toString(MediaTypeRegistry.JSON, this, true, true);
                throw new IllegalArgumentException("numberOfOperations must be >= 0");
        int numberOfOperations,
        builder.humanReadableField("size_in_bytes", "size", new ByteSizeValue(translogSizeInBytes));
    /**
            return this;
 * Translog statistics
        private long earliestLastModifiedAge = 0;
    public int estimatedNumberOfOperations() {
        this.remoteTranslogStats = builder.remoteTranslogStats;
            throw new IllegalArgumentException("uncommittedSizeInBytes must be >= 0");
 */
 * the Apache License, Version 2.0 (the "License"); you may
        long uncommittedSizeInBytes,
        long earliestLastModifiedAge
        return uncommittedOperations;
        }
        }
        out.writeVLong(uncommittedSizeInBytes);
        out.writeVInt(uncommittedOperations);
import org.opensearch.core.common.io.stream.Writeable;
 * license agreements. See the NOTICE file distributed with
         * Creates a {@link TranslogStats} object from the builder's current state.
    @Deprecated
import org.opensearch.core.xcontent.ToXContentFragment;
            if (operations < 0) {
import org.opensearch.core.xcontent.XContentBuilder;
        return uncommittedSizeInBytes;
    }
        uncommittedSizeInBytes = in.readVLong();
            if (age < 0) {
    }
    }
            this.remoteTranslogStats.add(remoteTranslogStats);
    private final RemoteTranslogStats remoteTranslogStats;
            return;
        private final RemoteTranslogStats remoteTranslogStats = new RemoteTranslogStats();
        uncommittedOperations = in.readVInt();
            this.translogSizeInBytes = size;
     */
        if (remoteTranslogStats != null) {
 * KIND, either express or implied.  See the License for the
    private static final String TRANSLOG = "translog";
         */
        }
import org.opensearch.core.common.unit.ByteSizeValue;
 * GitHub history for details.
    private long uncommittedSizeInBytes;
            if (size < 0) {
        }
            }
            return this;
     */
    }
import org.opensearch.core.common.io.stream.StreamInput;
import org.opensearch.Version;
 * under the License.
    /**
            }
                throw new IllegalArgumentException("earliestLastModifiedAge must be >= 0");
    private int uncommittedOperations;
        return remoteTranslogStats;
     * Provides a fluent API for constructing a TranslogStats object.
        public Builder uncommittedSizeInBytes(long bytes) {
            throw new IllegalArgumentException("uncommittedOperations must be >= 0");
        return translogSizeInBytes;
 *
/*
    public String toString() {
        private long uncommittedSizeInBytes = 0;
    }
        private long translogSizeInBytes = 0;
    }
            this.numberOfOperations = operations;
        this.uncommittedOperations = uncommittedOperations;
    public long getUncommittedSizeInBytes() {
        public Builder numberOfOperations(int operations) {
        this.uncommittedSizeInBytes += other.uncommittedSizeInBytes;
        if (translogSizeInBytes < 0) {
        }
}
            this.uncommittedOperations = operations;
    private int numberOfOperations;
        builder.field("uncommitted_operations", uncommittedOperations);
    private long earliestLastModifiedAge;
    }
        builder.field("operations", numberOfOperations);
        if (this.remoteTranslogStats != null) {
    }
            builder = remoteTranslogStats.toXContent(builder, params);
import org.opensearch.core.xcontent.MediaTypeRegistry;
        }
@PublicApi(since = "1.0.0")
        this.numberOfOperations = numberOfOperations;
 * ownership. Elasticsearch licenses this file to you under
 *
 */
     */
 * this work for additional information regarding copyright
        }
    public void add(TranslogStats other) {
                throw new IllegalArgumentException("translogSizeInBytes must be >= 0");
                throw new IllegalArgumentException("uncommittedOperations must be >= 0");
        this.remoteTranslogStats = new RemoteTranslogStats();
    }
import org.opensearch.core.common.io.stream.StreamOutput;
    @Override
    }
        translogSizeInBytes = in.readVLong();
     */
        addRemoteTranslogStats(other.remoteTranslogStats);
            }
/*
        }
        }
        }
        out.writeVLong(translogSizeInBytes);
    /**
            out.writeOptionalWriteable(remoteTranslogStats);
        }
        return earliestLastModifiedAge;
 * @opensearch.api
    /**
     * Use {@link TranslogStats.Builder} instead.
 * The OpenSearch Contributors require contributions made to
        if (other == null) {
            throw new IllegalArgumentException("numberOfOperations must be >= 0");
        if (uncommittedOperations < 0) {
        if (uncommittedSizeInBytes < 0) {
        remoteTranslogStats = in.getVersion().onOrAfter(Version.V_2_10_0)
    private TranslogStats(Builder builder) {
    }
 * software distributed under the License is distributed on an
    public TranslogStats(
 * Licensed to Elasticsearch under one or more contributor
    public long getEarliestLastModifiedAge() {
    public static class Builder {
            if (operations < 0) {
