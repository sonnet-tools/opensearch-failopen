        memoryLimit = in.readVLong();
        builder.field(PRIMARY_REJECTIONS, primaryRejections);
            this.memoryLimit = limit;
            return this;
        private long currentCombinedCoordinatingAndPrimaryBytes = 0;
        this.currentReplicaBytes = currentReplicaBytes;
        out.writeVLong(currentReplicaBytes);
        }
        }
            this.replicaRejections = rejections;
    public long getCurrentCoordinatingBytes() {
        return totalReplicaBytes;
    private static final String COORDINATING_REJECTIONS = "coordinating_rejections";
        currentCoordinatingBytes = in.readVLong();
        this.primaryRejections = primaryRejections;
 * compatible open source license.
 */
 * @opensearch.api
         * @return A new IndexingPressureStats instance.
 * software distributed under the License is distributed on an
    }
    private final long totalReplicaBytes;
        public Builder totalReplicaBytes(long bytes) {
        builder.humanReadableField(COMBINED_IN_BYTES, COMBINED, new ByteSizeValue(currentCombinedCoordinatingAndPrimaryBytes));
         */
        private long currentReplicaBytes = 0;
        return currentPrimaryBytes;
            this.totalReplicaBytes = bytes;
    @Override
    }
        return totalCombinedCoordinatingAndPrimaryBytes;
        builder.humanReadableField(COORDINATING_IN_BYTES, COORDINATING, new ByteSizeValue(currentCoordinatingBytes));
    public long getTotalCombinedCoordinatingAndPrimaryBytes() {
    private final long currentCombinedCoordinatingAndPrimaryBytes;
        long currentPrimaryBytes,
        this.replicaRejections = replicaRejections;
            return this;
        totalPrimaryBytes = in.readVLong();
    public long getCurrentPrimaryBytes() {
        primaryRejections = in.readVLong();
        private long primaryRejections = 0;
            return this;
            this.primaryRejections = rejections;
    public void writeTo(StreamOutput out) throws IOException {
        long coordinatingRejections,
        replicaRejections = in.readVLong();
        builder.humanReadableField(PRIMARY_IN_BYTES, PRIMARY, new ByteSizeValue(currentPrimaryBytes));
        }
        out.writeVLong(currentCombinedCoordinatingAndPrimaryBytes);
    }
    }
        return totalPrimaryBytes;
    /**
        out.writeVLong(totalCombinedCoordinatingAndPrimaryBytes);
    private static final String COORDINATING = "coordinating";
        long primaryRejections,
    ) {
    private static final String COORDINATING_IN_BYTES = "coordinating_in_bytes";
        }
    private final long primaryRejections;
        private long totalReplicaBytes = 0;
        long currentCombinedCoordinatingAndPrimaryBytes,
        out.writeVLong(totalCoordinatingBytes);
        builder.startObject("memory");
 * ownership. Elasticsearch licenses this file to you under
    }
        builder.humanReadableField(LIMIT_IN_BYTES, LIMIT, new ByteSizeValue(memoryLimit));
            return this;
        return currentCoordinatingBytes;
            return this;
        this.memoryLimit = memoryLimit;
    }
        return totalCoordinatingBytes;
        out.writeVLong(totalReplicaBytes);
    public long getPrimaryRejections() {
        long memoryLimit
         * Creates a {@link IndexingPressureStats} object from the builder's current state.
    private final long totalCombinedCoordinatingAndPrimaryBytes;
        private long totalCombinedCoordinatingAndPrimaryBytes = 0;
     * Builder for the {@link IndexingPressureStats} class.
 *
 * Licensed to Elasticsearch under one or more contributor
        public Builder totalCombinedCoordinatingAndPrimaryBytes(long bytes) {
        this.coordinatingRejections = builder.coordinatingRejections;
        this.totalReplicaBytes = builder.totalReplicaBytes;
    private final long replicaRejections;
 * You may obtain a copy of the License at
        this.totalReplicaBytes = totalReplicaBytes;
        public Builder currentPrimaryBytes(long bytes) {
    private static final String COMBINED_IN_BYTES = "combined_coordinating_and_primary_in_bytes";
    private final long coordinatingRejections;
        public IndexingPressureStats build() {
 * Modifications Copyright OpenSearch Contributors. See
        this.currentCombinedCoordinatingAndPrimaryBytes = currentCombinedCoordinatingAndPrimaryBytes;
        long totalCoordinatingBytes,
    /**
        builder.endObject();
public class IndexingPressureStats implements Writeable, ToXContentFragment {
            return this;
    private final long memoryLimit;
    private final long totalPrimaryBytes;
 *     http://www.apache.org/licenses/LICENSE-2.0
        this.totalCombinedCoordinatingAndPrimaryBytes = totalCombinedCoordinatingAndPrimaryBytes;
            this.currentReplicaBytes = bytes;
        }
        public Builder() {}
 *
    @Override
        }
 *
    public long getReplicaRejections() {
        long totalCombinedCoordinatingAndPrimaryBytes,
        long currentReplicaBytes,
    private final long totalCoordinatingBytes;
        return currentCombinedCoordinatingAndPrimaryBytes;
 * this file be licensed under the Apache-2.0 license or a
        long replicaRejections,
@PublicApi(since = "1.3.0")
            this.totalCoordinatingBytes = bytes;
        this.totalCoordinatingBytes = builder.totalCoordinatingBytes;
    public long getCurrentReplicaBytes() {
        out.writeVLong(coordinatingRejections);
        return primaryRejections;
        }
 * this work for additional information regarding copyright
}
 * KIND, either express or implied.  See the License for the
    }
    public long getCurrentCombinedCoordinatingAndPrimaryBytes() {
    }
    public long getTotalCoordinatingBytes() {
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.common.annotation.PublicApi;
        this.totalPrimaryBytes = builder.totalPrimaryBytes;
     * @param builder The builder instance containing all the values.
    private final long currentReplicaBytes;
    private static final String LIMIT_IN_BYTES = "limit_in_bytes";
        builder.startObject("indexing_pressure");
            return this;
     * Private constructor that takes a builder.
    }
        public Builder currentCombinedCoordinatingAndPrimaryBytes(long bytes) {
 *
    }
        this.currentPrimaryBytes = builder.currentPrimaryBytes;
        public Builder replicaRejections(long rejections) {
        this.coordinatingRejections = coordinatingRejections;
        builder.endObject();
            return this;
import org.opensearch.core.xcontent.ToXContentFragment;
        this.currentReplicaBytes = builder.currentReplicaBytes;
        this.replicaRejections = builder.replicaRejections;
        this.currentCoordinatingBytes = builder.currentCoordinatingBytes;
 */
        totalReplicaBytes = in.readVLong();
        private long replicaRejections = 0;
 * specific language governing permissions and limitations
    public long getTotalReplicaBytes() {
            this.currentCombinedCoordinatingAndPrimaryBytes = bytes;
        public Builder totalCoordinatingBytes(long bytes) {
/*
     */
    public long getTotalPrimaryBytes() {
        currentReplicaBytes = in.readVLong();
        builder.humanReadableField(ALL_IN_BYTES, ALL, new ByteSizeValue(totalReplicaBytes + totalCombinedCoordinatingAndPrimaryBytes));
        }
        }
import java.io.IOException;
    }
        builder.humanReadableField(COORDINATING_IN_BYTES, COORDINATING, new ByteSizeValue(totalCoordinatingBytes));
    private static final String REPLICA_IN_BYTES = "replica_in_bytes";
    }
        out.writeVLong(memoryLimit);
     * Provides a fluent API for constructing a IndexingPressureStats object.
            this.totalPrimaryBytes = bytes;
        /**
            return new IndexingPressureStats(this);
            this.totalCombinedCoordinatingAndPrimaryBytes = bytes;
        return replicaRejections;
    private static final String ALL = "all";
 * The OpenSearch Contributors require contributions made to
    public static class Builder {
        builder.startObject("total");
        }
        private long coordinatingRejections = 0;
            return this;
            return this;
        builder.humanReadableField(REPLICA_IN_BYTES, REPLICA, new ByteSizeValue(totalReplicaBytes));
import org.opensearch.core.xcontent.XContentBuilder;
import org.opensearch.core.common.unit.ByteSizeValue;
        private long memoryLimit = 0;
    public IndexingPressureStats(
        public Builder memoryLimit(long limit) {
        builder.humanReadableField(PRIMARY_IN_BYTES, PRIMARY, new ByteSizeValue(totalPrimaryBytes));
import org.opensearch.core.common.io.stream.StreamInput;
        this.primaryRejections = builder.primaryRejections;
 */
/*
            this.coordinatingRejections = rejections;
        builder.humanReadableField(COMBINED_IN_BYTES, COMBINED, new ByteSizeValue(totalCombinedCoordinatingAndPrimaryBytes));
    private IndexingPressureStats(Builder builder) {
        private long currentPrimaryBytes = 0;
        public Builder coordinatingRejections(long rejections) {
    }
    public long getCoordinatingRejections() {
            this.currentCoordinatingBytes = bytes;
        long currentCoordinatingBytes,
        return builder.endObject();
        return coordinatingRejections;
        this.totalPrimaryBytes = totalPrimaryBytes;
        return currentReplicaBytes;
 */
        currentPrimaryBytes = in.readVLong();
        this.totalCoordinatingBytes = totalCoordinatingBytes;
    private static final String REPLICA_REJECTIONS = "replica_rejections";
            return this;
        totalCoordinatingBytes = in.readVLong();
        this.currentPrimaryBytes = currentPrimaryBytes;
/**
    public IndexingPressureStats(StreamInput in) throws IOException {
    private static final String COMBINED = "combined_coordinating_and_primary";
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        this.totalCombinedCoordinatingAndPrimaryBytes = builder.totalCombinedCoordinatingAndPrimaryBytes;
 * license agreements. See the NOTICE file distributed with
 * not use this file except in compliance with the License.
    }
        builder.startObject("current");
package org.opensearch.index.stats;
    private static final String PRIMARY_IN_BYTES = "primary_in_bytes";
     * This is the sole entry point for creating a new IndexingPressureStats object.
        public Builder currentReplicaBytes(long bytes) {
        out.writeVLong(primaryRejections);
/*
        builder.humanReadableField(REPLICA_IN_BYTES, REPLICA, new ByteSizeValue(currentReplicaBytes));
        private long currentCoordinatingBytes = 0;
    private static final String LIMIT = "limit";
        builder.humanReadableField(ALL_IN_BYTES, ALL, new ByteSizeValue(currentReplicaBytes + currentCombinedCoordinatingAndPrimaryBytes));
        out.writeVLong(currentCoordinatingBytes);
        this.currentCoordinatingBytes = currentCoordinatingBytes;
 * Base indexing pressure statistics
    }
    private static final String ALL_IN_BYTES = "all_in_bytes";
    private final long currentPrimaryBytes;
            return this;
     * Use {@link Builder} instead.
        coordinatingRejections = in.readVLong();
    private static final String PRIMARY_REJECTIONS = "primary_rejections";
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
        out.writeVLong(replicaRejections);
        this.memoryLimit = builder.memoryLimit;
        public Builder primaryRejections(long rejections) {
     */
    private final long currentCoordinatingBytes;
    private static final String PRIMARY = "primary";
     */
    }
        private long totalPrimaryBytes = 0;
        builder.field(COORDINATING_REJECTIONS, coordinatingRejections);
 * GitHub history for details.
        this.currentCombinedCoordinatingAndPrimaryBytes = builder.currentCombinedCoordinatingAndPrimaryBytes;
        builder.endObject();
     * This constructor will be deprecated starting in version 3.4.0.
        currentCombinedCoordinatingAndPrimaryBytes = in.readVLong();
        out.writeVLong(totalPrimaryBytes);
    @Deprecated
 * under the License.
        public Builder currentCoordinatingBytes(long bytes) {
import org.opensearch.core.common.io.stream.StreamOutput;
        builder.field(REPLICA_REJECTIONS, replicaRejections);
        public Builder totalPrimaryBytes(long bytes) {
        }
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.core.common.io.stream.Writeable;
    /**
        long totalPrimaryBytes,
        totalCombinedCoordinatingAndPrimaryBytes = in.readVLong();
 * SPDX-License-Identifier: Apache-2.0
        out.writeVLong(currentPrimaryBytes);
        }
        }
        private long totalCoordinatingBytes = 0;
    }
        long totalReplicaBytes,
            this.currentPrimaryBytes = bytes;
    private static final String REPLICA = "replica";
