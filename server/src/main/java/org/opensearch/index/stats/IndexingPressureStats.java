        this.currentCombinedCoordinatingAndPrimaryBytes = builder.currentCombinedCoordinatingAndPrimaryBytes;
        }
        private long replicaRejections = 0;
        private long memoryLimit = 0;
        public Builder() {}
        }  
    private final long currentCombinedCoordinatingAndPrimaryBytes;  
     * Provides a fluent API for constructing a IndexingPressureStats object.  
 * SPDX-License-Identifier: Apache-2.0
    }  
 *
    }
            this.totalReplicaBytes = bytes;
 *  
        }  
    private final long primaryRejections;
        public Builder totalReplicaBytes(long bytes) {  
}
        return builder.endObject();
        out.writeVLong(currentCombinedCoordinatingAndPrimaryBytes);
        builder.humanReadableField(PRIMARY_IN_BYTES, PRIMARY, new ByteSizeValue(currentPrimaryBytes));
        long replicaRejections,
            return this;  
        long totalCombinedCoordinatingAndPrimaryBytes,
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
        builder.startObject("current");
 * software distributed under the License is distributed on an
        return totalReplicaBytes;
        long coordinatingRejections,  
 */  
 * Modifications Copyright OpenSearch Contributors. See
        public Builder currentCombinedCoordinatingAndPrimaryBytes(long bytes) {
        this.coordinatingRejections = coordinatingRejections;
    public long getCurrentCombinedCoordinatingAndPrimaryBytes() {
        }  
        long totalReplicaBytes,
            return this;  
    private static final String COORDINATING_REJECTIONS = "coordinating_rejections";  
    public long getCoordinatingRejections() {
import org.opensearch.core.common.io.stream.Writeable;
        private long currentPrimaryBytes = 0;  
 * Base indexing pressure statistics  
        out.writeVLong(memoryLimit);  
        /**  
        replicaRejections = in.readVLong();  
        primaryRejections = in.readVLong();
    private static final String LIMIT = "limit";  
        private long currentCoordinatingBytes = 0;
            return this;
        builder.humanReadableField(REPLICA_IN_BYTES, REPLICA, new ByteSizeValue(totalReplicaBytes));  
        this.memoryLimit = builder.memoryLimit;
    }
    }  
    private static final String COORDINATING_IN_BYTES = "coordinating_in_bytes";
        }  
        this.currentCoordinatingBytes = builder.currentCoordinatingBytes;
 */
        builder.field(PRIMARY_REJECTIONS, primaryRejections);  
 * under the License.  
 */  
import org.opensearch.core.common.io.stream.StreamOutput;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        totalCombinedCoordinatingAndPrimaryBytes = in.readVLong();  
    private final long totalPrimaryBytes;  
 * Licensed to Elasticsearch under one or more contributor  
 *     http://www.apache.org/licenses/LICENSE-2.0
        builder.startObject("total");
     */
    }  
        public Builder memoryLimit(long limit) {
        builder.startObject("indexing_pressure");
        this.totalCombinedCoordinatingAndPrimaryBytes = totalCombinedCoordinatingAndPrimaryBytes;
        builder.endObject();
    public void writeTo(StreamOutput out) throws IOException {
        this.totalPrimaryBytes = totalPrimaryBytes;
            return this;
            this.totalCoordinatingBytes = bytes;  
/*
        out.writeVLong(primaryRejections);
            this.currentCoordinatingBytes = bytes;
        builder.humanReadableField(ALL_IN_BYTES, ALL, new ByteSizeValue(currentReplicaBytes + currentCombinedCoordinatingAndPrimaryBytes));  
        public Builder totalCombinedCoordinatingAndPrimaryBytes(long bytes) {  
        this.currentPrimaryBytes = currentPrimaryBytes;
    private static final String COMBINED = "combined_coordinating_and_primary";
    private final long currentPrimaryBytes;
    }
     * Use {@link Builder} instead.  
    public long getCurrentCoordinatingBytes() {
 * license agreements. See the NOTICE file distributed with
            this.currentCombinedCoordinatingAndPrimaryBytes = bytes;  
        private long currentReplicaBytes = 0;
import org.opensearch.common.annotation.PublicApi;
    /**
        public Builder coordinatingRejections(long rejections) {
import org.opensearch.core.xcontent.ToXContentFragment;  
         * Creates a {@link IndexingPressureStats} object from the builder's current state.
    public long getTotalPrimaryBytes() {
        currentCombinedCoordinatingAndPrimaryBytes = in.readVLong();
        return totalPrimaryBytes;  
    private static final String PRIMARY = "primary";  
    private static final String ALL_IN_BYTES = "all_in_bytes";
        builder.endObject();
    }
        memoryLimit = in.readVLong();
        }
            return this;  
        totalPrimaryBytes = in.readVLong();
         * @return A new IndexingPressureStats instance.
        currentPrimaryBytes = in.readVLong();
    public long getCurrentReplicaBytes() {
            this.currentPrimaryBytes = bytes;
    ) {
        this.currentPrimaryBytes = builder.currentPrimaryBytes;  
 * @opensearch.api
    }  
@PublicApi(since = "1.3.0")
    @Override  
        builder.humanReadableField(COORDINATING_IN_BYTES, COORDINATING, new ByteSizeValue(currentCoordinatingBytes));  
        builder.humanReadableField(COMBINED_IN_BYTES, COMBINED, new ByteSizeValue(currentCombinedCoordinatingAndPrimaryBytes));
        long currentReplicaBytes,
    private final long currentCoordinatingBytes;
        this.currentCoordinatingBytes = currentCoordinatingBytes;
            this.primaryRejections = rejections;
    }  
        currentReplicaBytes = in.readVLong();
        private long primaryRejections = 0;  
        this.totalReplicaBytes = totalReplicaBytes;
     * This is the sole entry point for creating a new IndexingPressureStats object.
        long primaryRejections,
            return this;
     */
        }
        builder.humanReadableField(REPLICA_IN_BYTES, REPLICA, new ByteSizeValue(currentReplicaBytes));
        out.writeVLong(totalCoordinatingBytes);  
        this.currentReplicaBytes = currentReplicaBytes;  
            this.memoryLimit = limit;
        }
     */
        return currentReplicaBytes;
 * not use this file except in compliance with the License.
import org.opensearch.core.common.unit.ByteSizeValue;
        builder.humanReadableField(COORDINATING_IN_BYTES, COORDINATING, new ByteSizeValue(totalCoordinatingBytes));
    /**
    private static final String REPLICA_REJECTIONS = "replica_rejections";
        out.writeVLong(currentReplicaBytes);
        this.totalCoordinatingBytes = totalCoordinatingBytes;  
 * GitHub history for details.
        coordinatingRejections = in.readVLong();
     * This constructor will be deprecated starting in version 3.4.0.
        public Builder replicaRejections(long rejections) {
    private static final String PRIMARY_REJECTIONS = "primary_rejections";
        totalReplicaBytes = in.readVLong();  
    private static final String COORDINATING = "coordinating";
    private final long totalCoordinatingBytes;
        out.writeVLong(currentPrimaryBytes);  
        public Builder currentPrimaryBytes(long bytes) {  
    public long getPrimaryRejections() {  
    public static class Builder {
        totalCoordinatingBytes = in.readVLong();
        builder.humanReadableField(PRIMARY_IN_BYTES, PRIMARY, new ByteSizeValue(totalPrimaryBytes));
        currentCoordinatingBytes = in.readVLong();  
    private final long coordinatingRejections;
        return totalCombinedCoordinatingAndPrimaryBytes;
        long currentCoordinatingBytes,  
        long currentCombinedCoordinatingAndPrimaryBytes,
        builder.endObject();
        builder.field(REPLICA_REJECTIONS, replicaRejections);
    }  
        private long totalPrimaryBytes = 0;
import org.opensearch.core.xcontent.XContentBuilder;
        private long coordinatingRejections = 0;
            this.replicaRejections = rejections;  
 * this file be licensed under the Apache-2.0 license or a
 * KIND, either express or implied.  See the License for the
        this.currentCombinedCoordinatingAndPrimaryBytes = currentCombinedCoordinatingAndPrimaryBytes;  
        public Builder primaryRejections(long rejections) {  
        builder.humanReadableField(ALL_IN_BYTES, ALL, new ByteSizeValue(totalReplicaBytes + totalCombinedCoordinatingAndPrimaryBytes));
    }
    public IndexingPressureStats(  
        out.writeVLong(totalReplicaBytes);
        return primaryRejections;
        long totalCoordinatingBytes,
 * specific language governing permissions and limitations
    public long getTotalCombinedCoordinatingAndPrimaryBytes() {  
    }
    /**  
        this.primaryRejections = builder.primaryRejections;  
        public Builder totalPrimaryBytes(long bytes) {
        out.writeVLong(currentCoordinatingBytes);
        }
        public Builder currentCoordinatingBytes(long bytes) {
        out.writeVLong(coordinatingRejections);  
    }
    private static final String LIMIT_IN_BYTES = "limit_in_bytes";
            this.totalPrimaryBytes = bytes;
    public long getReplicaRejections() {
            return new IndexingPressureStats(this);
    private static final String PRIMARY_IN_BYTES = "primary_in_bytes";
        long memoryLimit  
    private static final String COMBINED_IN_BYTES = "combined_coordinating_and_primary_in_bytes";  
        out.writeVLong(totalCombinedCoordinatingAndPrimaryBytes);
 * the Apache License, Version 2.0 (the "License"); you may
        builder.humanReadableField(LIMIT_IN_BYTES, LIMIT, new ByteSizeValue(memoryLimit));  
        this.replicaRejections = replicaRejections;  
        return replicaRejections;
/*  
        public Builder currentReplicaBytes(long bytes) {
    @Deprecated
        return currentPrimaryBytes;
            return this;
            return this;
            this.currentReplicaBytes = bytes;  
public class IndexingPressureStats implements Writeable, ToXContentFragment {
 * Unless required by applicable law or agreed to in writing,
        return currentCombinedCoordinatingAndPrimaryBytes;
        builder.field(COORDINATING_REJECTIONS, coordinatingRejections);
 */  
        }
        private long totalCombinedCoordinatingAndPrimaryBytes = 0;  
    private static final String REPLICA = "replica";
            return this;
     * Private constructor that takes a builder.
    private static final String ALL = "all";
    private final long replicaRejections;  
/**
/*  
         */  
        public IndexingPressureStats build() {
        long totalPrimaryBytes,  
     * Builder for the {@link IndexingPressureStats} class.
            return this;
    }
    }
 * The OpenSearch Contributors require contributions made to  
        out.writeVLong(totalPrimaryBytes);
    public IndexingPressureStats(StreamInput in) throws IOException {
        this.totalCoordinatingBytes = builder.totalCoordinatingBytes;
            this.totalCombinedCoordinatingAndPrimaryBytes = bytes;
package org.opensearch.index.stats;
        private long totalReplicaBytes = 0;  
        }
     * @param builder The builder instance containing all the values.  
    public long getTotalCoordinatingBytes() {
        this.totalCombinedCoordinatingAndPrimaryBytes = builder.totalCombinedCoordinatingAndPrimaryBytes;  
        }  
    }
import java.io.IOException;  
        builder.humanReadableField(COMBINED_IN_BYTES, COMBINED, new ByteSizeValue(totalCombinedCoordinatingAndPrimaryBytes));  
    private final long totalCombinedCoordinatingAndPrimaryBytes;
    public long getTotalReplicaBytes() {  
    private final long currentReplicaBytes;  
        }
import org.opensearch.core.common.io.stream.StreamInput;
        this.currentReplicaBytes = builder.currentReplicaBytes;
        return currentCoordinatingBytes;  
        builder.startObject("memory");  
        return totalCoordinatingBytes;
        this.totalReplicaBytes = builder.totalReplicaBytes;  
    private final long memoryLimit;
        this.coordinatingRejections = builder.coordinatingRejections;
 * You may obtain a copy of the License at  
 *
            this.coordinatingRejections = rejections;
        this.replicaRejections = builder.replicaRejections;
 *
        public Builder totalCoordinatingBytes(long bytes) {
    public long getCurrentPrimaryBytes() {  
            return this;  
    private final long totalReplicaBytes;
    }
            return this;
        out.writeVLong(replicaRejections);
 * this work for additional information regarding copyright
    private static final String REPLICA_IN_BYTES = "replica_in_bytes";  
    private IndexingPressureStats(Builder builder) {
 * compatible open source license.
 * ownership. Elasticsearch licenses this file to you under  
        return coordinatingRejections;  
    @Override  
        private long totalCoordinatingBytes = 0;
        this.primaryRejections = primaryRejections;
        this.totalPrimaryBytes = builder.totalPrimaryBytes;
        this.memoryLimit = memoryLimit;
        private long currentCombinedCoordinatingAndPrimaryBytes = 0;
        long currentPrimaryBytes,
