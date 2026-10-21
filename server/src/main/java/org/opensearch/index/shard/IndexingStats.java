            deleteCount += stats.deleteCount;
            builder.field(Fields.INDEX_CURRENT, indexCurrent);
            long indexCurrent,
    private static final class Fields {
            private long indexTimeInMillis = 0;
            }
        public long getIndexCount() {
            private long indexCurrent = 0;
        private long indexCurrent;
                docStatusCounter = in.readArray(i -> new AtomicLong(i.readLong()), AtomicLong[]::new);
 * compatible open source license.
            }
            public Stats build() {
                return this;
            this.deleteTimeInMillis = builder.deleteTimeInMillis;
            boolean isThrottled,
            this.isThrottled = isThrottled;
                return this;
import java.util.Map;
            public DocStatusStats(StreamInput in) throws IOException {
            out.writeVLong(deleteCount);
                }
             *
     */
            // To be removed soon
        /**
            out.writeLong(throttleTimeInMillis);
        public boolean isThrottled() {
import org.opensearch.core.xcontent.XContentBuilder;
                this.isThrottled = throttled;
             * Increment counter for status by count
/*
             * @param status {@link RestStatus}
            return maxLastIndexRequestTimestamp;
            return indexCount;
            @Override
            out.writeVLong(indexFailedCount);
                for (int i = 0; i < docStatusCounter.length; ++i) {
            }
     * Fields for indexing statistics
        public long getNoopUpdateCount() {
            builder.field(Fields.IS_THROTTLED, isThrottled);
        /**
            return indexCurrent;
            long deleteCurrent,
        private long deleteTimeInMillis;
            out.writeVLong(indexTimeInMillis);
    }
                docStatusCounter[status.getStatusFamilyCode() - 1].addAndGet(delta);
            }
        ) {
 *
    private final Stats totalStats;
                deleteCount,
        public static class Builder {
        /**
 * The OpenSearch Contributors require contributions made to
            long indexFailedCount,
                for (int i = 0; i < docStatusCounter.length; ++i) {
            public Builder isThrottled(boolean throttled) {
import java.util.concurrent.atomic.AtomicLong;
            deleteTimeInMillis += stats.deleteTimeInMillis;
 * this file be licensed under the Apache-2.0 license or a
    /**
        ) {
             *
                deleteCurrent,
            builder.humanReadableField(Fields.DELETE_TIME_IN_MILLIS, Fields.DELETE_TIME, getDeleteTime());
            if (in.getVersion().onOrAfter(Version.V_3_2_0)) {
        /**
                add(status, 1L);
         */
            return indexFailedCount;
    }
                maxLastIndexRequestTimestamp = in.readLong();
     * Internal statistics for indexing
package org.opensearch.index.shard;
                assert docStatusCounter.length == 5 : "Length of incoming array should be 5! Got " + docStatusCounter.length;
        }
        /**
                return this;
        /**
            }
            public Builder deleteCurrent(long current) {
        private final DocStatusStats docStatusStats;
         * Use {@link Builder} instead.
    }
 * KIND, either express or implied.  See the License for the
        static final String DELETE_TOTAL = "delete_total";
            }
        public long getIndexCurrent() {
         * Tracks item level rest category class codes during indexing
        this.totalStats = totalStats;
        /**
        @Override
            private long throttleTimeInMillis = 0;
            this.deleteCurrent = deleteCurrent;
        /**
        public Stats(
        static final String INDEXING = "indexing";
                    }
     *
    public IndexingStats(StreamInput in) throws IOException {
            public Builder throttleTimeInMillis(long time) {
    @PublicApi(since = "1.0.0")
            if (in.readBoolean()) {
                return this;
            builder.humanReadableField(Fields.THROTTLED_TIME_IN_MILLIS, Fields.THROTTLED_TIME, getThrottleTime());
        if (indexingStats == null) {
            public Builder indexTimeInMillis(long time) {
        builder.startObject(Fields.INDEXING);
 * Unless required by applicable law or agreed to in writing,
            this.indexFailedCount = indexFailedCount;
                docStatusStats = null;
        Stats() {
            this.maxLastIndexRequestTimestamp = maxLastIndexRequestTimestamp;
        static final String DELETE_TIME = "delete_time";
                docStatusStats,
            builder.field(Fields.DELETE_CURRENT, deleteCurrent);
        if (out.getVersion().before(Version.V_2_0_0)) {
            indexCurrent = in.readVLong();
            builder.field(Fields.INDEX_TOTAL, indexCount);
            private long noopUpdateCount = 0;
                docStatusCounter = new AtomicLong[5];
        addTotals(indexingStats);
        @PublicApi(since = "1.0.0")
            long deleteCurrent,
        }
             */
            }
        public long getMaxLastIndexRequestTimestamp() {
             *
        }
            out.writeBoolean(isThrottled);
            throttleTimeInMillis += stats.throttleTimeInMillis;
     */
        private long indexFailedCount;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                indexTimeInMillis,
         * The total number of indexing operations
            }
            if (out.getVersion().onOrAfter(Version.V_3_2_0)) {
            this.docStatusStats = builder.docStatusStats;
import org.opensearch.common.annotation.PublicApi;
            public void add(final DocStatusStats stats) {
            long deleteTimeInMillis,
            builder.field(Fields.NOOP_UPDATE_TOTAL, noopUpdateCount);
 * Tracks indexing statistics
        static final String MAX_LAST_INDEX_REQUEST_TIMESTAMP = "max_last_index_request_timestamp";
            deleteCurrent = in.readVLong();
            /**
        static final String INDEX_FAILED = "index_failed";
        }
            throttleTimeInMillis = in.readLong();
            }
            indexCurrent += stats.indexCurrent;
            }
                out.writeLong(maxLastIndexRequestTimestamp);
            this.deleteCount = builder.deleteCount;
                return this;
                builder.startObject(Fields.DOC_STATUS);
         */
                return this;
             * @return A new Stats instance.
        totalStats = new Stats();
            private long deleteCount = 0;
            out.writeVLong(indexCurrent);
            this.deleteCurrent = builder.deleteCurrent;
         * The number of failed indexing operations
         * Returns the currently in-flight indexing operations.
 * software distributed under the License is distributed on an
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
        }
            if (getDocStatusStats() != null) {
 * under the License.
        private long indexCount;
             */
            DocStatusStats docStatusStats,
            private DocStatusStats docStatusStats = null;
        private long indexTimeInMillis;
        private long deleteCurrent;
 * GitHub history for details.
                }
            builder.humanReadableField(Fields.INDEX_TIME_IN_MILLIS, Fields.INDEX_TIME, getIndexTime());
            long indexCount,
                return this;
import org.opensearch.core.xcontent.ToXContent;
}
        static final String INDEX_TIME_IN_MILLIS = "index_time_in_millis";
        @Override
                docStatusStats = in.readOptionalWriteable(DocStatusStats::new);
    }
            return;
                return this;
 * specific language governing permissions and limitations
                return this;
        }
         */
            }
            public void writeTo(StreamOutput out) throws IOException {
            private long deleteTimeInMillis = 0;
            this.noopUpdateCount = builder.noopUpdateCount;
                assert typeStats.containsKey(MapperService.SINGLE_MAPPING_NAME);
@PublicApi(since = "1.0.0")
        public Stats(
        return this.totalStats;
            public Builder noopUpdateCount(long count) {
        static final String THROTTLED_TIME_IN_MILLIS = "throttle_time_in_millis";
    public Stats getTotal() {
            }
            noopUpdateCount = in.readVLong();
            }
            if (getDocStatusStats() != null) {
                Map<String, Stats> typeStats = in.readMap(StreamInput::readString, Stats::new);
                if (null == stats) {
    @Override
            }
                getDocStatusStats().toXContent(builder, params);
                this.indexTimeInMillis = time;
            this.deleteCount = deleteCount;
            } else {
        private long throttleTimeInMillis;
 * license agreements. See the NOTICE file distributed with
            return deleteCurrent;
            noopUpdateCount += stats.noopUpdateCount;
            long maxLastIndexRequestTimestamp
        /**
            out.writeVLong(noopUpdateCount);
import org.opensearch.core.common.io.stream.Writeable;
            long indexFailedCount,
            }
            long throttleTimeInMillis,
             * Increment counter for status
            this.isThrottled = builder.isThrottled;
            indexFailedCount = in.readVLong();
             */
        public Stats(StreamInput in) throws IOException {
        static final String DOC_STATUS = "doc_status";
import java.io.IOException;
         */
             */
        }
        }
            builder.field(Fields.MAX_LAST_INDEX_REQUEST_TIMESTAMP, maxLastIndexRequestTimestamp);
        }
            }
            public Builder indexCurrent(long current) {
        }
            this.maxLastIndexRequestTimestamp = builder.maxLastIndexRequestTimestamp;
        }
    }
                        String key = i + 1 + "xx";
                this.docStatusStats = stats;
                this.deleteTimeInMillis = time;
        totalStats.toXContent(builder, params);
            public DocStatusStats() {
        public TimeValue getThrottleTime() {
                indexFailedCount,
                maxLastIndexRequestTimestamp = 0L;
        }
            indexTimeInMillis = in.readVLong();
        public TimeValue getDeleteTime() {
                    docStatusCounter[i] = new AtomicLong(0);
            }
            if (in.getVersion().onOrAfter(Version.V_2_11_0) && in.getVersion().before(Version.V_3_4_0)) {
            long indexCurrent,
import org.opensearch.index.mapper.MapperService;
             * @param delta The value to add
        }
            @Override
    public void writeTo(StreamOutput out) throws IOException {
            }
         */
            private boolean isThrottled = false;
import org.opensearch.common.annotation.DeprecatedApi;
    @Override
        }
    }
            if (out.getVersion().onOrAfter(Version.V_2_11_0) && out.getVersion().before(Version.V_3_4_0)) {
            }
         * This is the sole entry point for creating a new Stats object.
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.core.rest.RestStatus;
            long indexTimeInMillis,
        static final String THROTTLED_TIME = "throttle_time";
        /**
        public TimeValue getIndexTime() {
            this.throttleTimeInMillis = throttleTimeInMillis;
 */
            long noopUpdateCount,
        }
         *
                return docStatusCounter;
                return this;
            indexCount += stats.indexCount;
         * This constructor will be deprecated starting in version 3.4.0.
         * Private constructor that takes a builder.
                deleteTimeInMillis,
            long noopUpdateCount,
    public IndexingStats(Stats totalStats) {
                isThrottled,
        public DocStatusStats getDocStatusStats() {
        builder.endObject();
            this.indexCount = indexCount;
            indexFailedCount += stats.indexFailedCount;
            out.writeBoolean(false);
        /**
 * Licensed to Elasticsearch under one or more contributor
        private Stats(Builder builder) {
         */
            isThrottled = in.readBoolean();
         * Gets the amount of time in a TimeValue that the index has been under merge throttling control
        }
import org.opensearch.Version;
                this.noopUpdateCount = count;
        }
                getDocStatusStats().add(stats.getDocStatusStats());
            this.noopUpdateCount = noopUpdateCount;
            deleteCount = in.readVLong();
     * @opensearch.api
 * You may obtain a copy of the License at
    public void addTotals(IndexingStats indexingStats) {
            }
        public long getDeleteCount() {
        static final String IS_THROTTLED = "is_throttled";
    public static class Stats implements Writeable, ToXContentFragment {
            this(
        static final String NOOP_UPDATE_TOTAL = "noop_update_total";
            this.deleteTimeInMillis = deleteTimeInMillis;
            this.indexCount = builder.indexCount;
        static final String INDEX_CURRENT = "index_current";
            this.indexCurrent = builder.indexCurrent;
            docStatusStats = null;
            public void inc(final RestStatus status) {
                return builder.endObject();
                    return;
 * the Apache License, Version 2.0 (the "License"); you may
            }
            public Builder docStatusStats(DocStatusStats stats) {
    }
        }
            void add(final RestStatus status, final long delta) {
            return new TimeValue(deleteTimeInMillis);
                indexCount,
                    long value = docStatusCounter[i].longValue();
             * Accumulate stats from the passed Object
         */
 * @opensearch.api
            builder.field(Fields.INDEX_FAILED, indexFailedCount);
            long deleteCount,
            public Builder maxLastIndexRequestTimestamp(long timestamp) {
            long throttleTimeInMillis,
        @DeprecatedApi(since = "3.4.0")
 * not use this file except in compliance with the License.
 */
         */
            this.indexTimeInMillis = builder.indexTimeInMillis;
        totalStats = new Stats(in);
        private long maxLastIndexRequestTimestamp;
            maxLastIndexRequestTimestamp = Math.max(maxLastIndexRequestTimestamp, stats.maxLastIndexRequestTimestamp);
            );
             * @param status {@link RestStatus}
                out.writeArray((o, v) -> o.writeLong(v.longValue()), docStatusCounter);
            } else {
    public void add(IndexingStats indexingStats) {
        }
                0L
import org.opensearch.core.common.io.stream.StreamInput;
    }
 * this work for additional information regarding copyright
                this.deleteCurrent = current;
                }
            out.writeVLong(indexCount);
            public Builder indexFailedCount(long count) {
            long indexTimeInMillis,
        totalStats.add(indexingStats.totalStats);
 *
        }
     *
        return builder;
            private long maxLastIndexRequestTimestamp = 0;
 *
            }
/*
            return new TimeValue(indexTimeInMillis);
            public Builder deleteCount(long count) {
import org.opensearch.core.xcontent.ToXContentFragment;
            out.writeVLong(deleteTimeInMillis);
            private long indexCount = 0;
        }
         */
/*
/**
            }
         * Returns the currently in-flight delete operations
                this.indexFailedCount = count;
            /**
        public long getDeleteCurrent() {
             * Creates a {@link Stats} object from the builder's current state.
            this.indexTimeInMillis = indexTimeInMillis;
        static final String DELETE_TIME_IN_MILLIS = "delete_time_in_millis";
            builder.field(Fields.DELETE_TOTAL, deleteCount);
                this.throttleTimeInMillis = time;
            final AtomicLong[] docStatusCounter;
            return new TimeValue(throttleTimeInMillis);
            deleteCurrent += stats.deleteCurrent;
public class IndexingStats implements Writeable, ToXContentFragment {
                }
            return;
            long deleteCount,
                        builder.field(key, value);
            /**
 *
                return this;
            return deleteCount;
            deleteTimeInMillis = in.readVLong();
        private long noopUpdateCount;
            return isThrottled;
            indexCount = in.readVLong();
 */
                    docStatusCounter[i].addAndGet(stats.docStatusCounter[i].longValue());
            public Builder deleteTimeInMillis(long time) {
        if (indexingStats == null) {
                return new Stats(this);
        public long getIndexFailedCount() {
    public XContentBuilder toXContent(XContentBuilder builder, ToXContent.Params params) throws IOException {
        static final String INDEX_TIME = "index_time";
            }
            DocStatusStats docStatusStats
        public void add(Stats stats) {
        @Deprecated(since = "3.4.0")
            public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
                assert typeStats.size() == 1;
            }
            public Builder() {}
        /**
            return docStatusStats;
            public Builder indexCount(long count) {
             * @param stats Instance storing {@link DocStatusStats}
                indexCurrent,
    }
import org.opensearch.core.common.io.stream.StreamOutput;
         * The total amount of time spend on executing delete operations.
            /**
            boolean isThrottled,
        if (in.getVersion().before(Version.V_2_0_0)) {
        static final String INDEX_TOTAL = "index_total";
        /**
         * @param builder The builder instance containing all the values.
         */
        public static class DocStatusStats implements Writeable, ToXContentFragment {
            this.throttleTimeInMillis = builder.throttleTimeInMillis;
         */
            indexTimeInMillis += stats.indexTimeInMillis;
         * This constructor will be deprecated starting in version 3.4.0.
            return builder;
         * @opensearch.api
         */
                throttleTimeInMillis,
            this.indexFailedCount = builder.indexFailedCount;
        }
    /**
                for (int i = 0; i < docStatusCounter.length; ++i) {
            this.indexCurrent = indexCurrent;
         * Provides a fluent API for constructing a Stats object.
         * Returns if the index is under merge throttling control
                this.indexCount = count;
        static final String DELETE_CURRENT = "delete_current";
import org.opensearch.common.unit.TimeValue;
            private long deleteCurrent = 0;
            }
            }
            }
        }
        private long deleteCount;
         */
            long indexCount,
                out.writeOptionalWriteable(docStatusStats);
                this.indexCurrent = current;
            return noopUpdateCount;
        }
         * The total amount of time spend on executing index operations.
         * Returns the number of delete operation executed
    }
         */
    public IndexingStats() {
     * @opensearch.internal
 * SPDX-License-Identifier: Apache-2.0
                    if (value > 0) {
 *    http://www.apache.org/licenses/LICENSE-2.0
        private boolean isThrottled;
        @Deprecated(since = "3.4.0")
                this.maxLastIndexRequestTimestamp = timestamp;
        }
         * Use {@link Builder} instead.
        /**
            private long indexFailedCount = 0;
            long deleteTimeInMillis,
                this.deleteCount = count;
            public AtomicLong[] getDocStatusCounter() {
        totalStats.writeTo(out);
 */
            isThrottled |= stats.isThrottled; // When combining if one is throttled set result to throttled.
        }
        public void writeTo(StreamOutput out) throws IOException {
         * Builder for the {@link Stats} class.
                noopUpdateCount,
            this.docStatusStats = docStatusStats;
                return this;
 * ownership. Elasticsearch licenses this file to you under
            out.writeVLong(deleteCurrent);
