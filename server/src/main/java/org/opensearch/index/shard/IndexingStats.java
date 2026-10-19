            this.indexTimeInMillis = builder.indexTimeInMillis;
                this.indexCurrent = current;
        private long deleteCount;  
        }
        public void add(Stats stats) {  
             */  
                return this;  
            private long indexCurrent = 0;
    public void add(IndexingStats indexingStats) {
         * Tracks item level rest category class codes during indexing
 * license agreements. See the NOTICE file distributed with
        }
            return builder;  
        }  
import org.opensearch.index.mapper.MapperService;  
                indexCurrent,
            private long deleteTimeInMillis = 0;
            out.writeVLong(noopUpdateCount);  
            long indexTimeInMillis,  
            indexTimeInMillis = in.readVLong();
                        String key = i + 1 + "xx";
/*
         */  
            builder.humanReadableField(Fields.DELETE_TIME_IN_MILLIS, Fields.DELETE_TIME, getDeleteTime());
                    docStatusCounter[i] = new AtomicLong(0);  
            public Builder deleteTimeInMillis(long time) {  
            private boolean isThrottled = false;
             * @param delta The value to add
            if (getDocStatusStats() != null) {  
         * Gets the amount of time in a TimeValue that the index has been under merge throttling control
         */
            builder.field(Fields.INDEX_CURRENT, indexCurrent);  
            this.deleteCurrent = deleteCurrent;
import org.opensearch.common.annotation.DeprecatedApi;
        @PublicApi(since = "1.0.0")  
            out.writeVLong(deleteCurrent);
                this.deleteCurrent = current;  
            public void inc(final RestStatus status) {  
            builder.field(Fields.IS_THROTTLED, isThrottled);  
            return docStatusStats;
            }
        static final String INDEX_CURRENT = "index_current";
        /**
        Stats() {  
         * The total number of indexing operations
            }
    public void writeTo(StreamOutput out) throws IOException {
                this.indexTimeInMillis = time;
        public TimeValue getDeleteTime() {
        }  
            long deleteTimeInMillis,
            this.deleteCount = builder.deleteCount;
                for (int i = 0; i < docStatusCounter.length; ++i) {  
        ) {
     */
         */
 * this file be licensed under the Apache-2.0 license or a
 */
    private final Stats totalStats;
                this.maxLastIndexRequestTimestamp = timestamp;
        public TimeValue getIndexTime() {
 * software distributed under the License is distributed on an
        private long deleteTimeInMillis;
         * Returns the currently in-flight delete operations  
                this.deleteCount = count;
        this.totalStats = totalStats;
            if (getDocStatusStats() != null) {
            public Builder isThrottled(boolean throttled) {
    }  
            this.noopUpdateCount = noopUpdateCount;
        static final String INDEXING = "indexing";  
        static final String DELETE_TIME = "delete_time";
            this.noopUpdateCount = builder.noopUpdateCount;
import org.opensearch.common.annotation.PublicApi;  
        private long throttleTimeInMillis;
        }
         * @param builder The builder instance containing all the values.
         */  
             * Increment counter for status
            }  
                isThrottled,
import org.opensearch.core.common.io.stream.StreamInput;
    @Override  
            void add(final RestStatus status, final long delta) {
        private final DocStatusStats docStatusStats;  
             * Accumulate stats from the passed Object  
            return maxLastIndexRequestTimestamp;  
            return indexCurrent;
        @Deprecated(since = "3.4.0")
        static final String INDEX_TOTAL = "index_total";
        static final String NOOP_UPDATE_TOTAL = "noop_update_total";
                assert typeStats.containsKey(MapperService.SINGLE_MAPPING_NAME);
            noopUpdateCount = in.readVLong();
 * You may obtain a copy of the License at  
 * SPDX-License-Identifier: Apache-2.0
            public AtomicLong[] getDocStatusCounter() {
                return this;  
                docStatusCounter = in.readArray(i -> new AtomicLong(i.readLong()), AtomicLong[]::new);
            deleteCount = in.readVLong();
                return this;  
         */
         * Returns the currently in-flight indexing operations.
        }
            return isThrottled;  
            DocStatusStats docStatusStats,
            this.docStatusStats = docStatusStats;
                out.writeOptionalWriteable(docStatusStats);
public class IndexingStats implements Writeable, ToXContentFragment {  
            long indexTimeInMillis,
        private long indexCurrent;
    public XContentBuilder toXContent(XContentBuilder builder, ToXContent.Params params) throws IOException {
        if (in.getVersion().before(Version.V_2_0_0)) {  
            long deleteCount,  
            throttleTimeInMillis += stats.throttleTimeInMillis;
}
        public long getIndexFailedCount() {
         * Private constructor that takes a builder.
            out.writeVLong(indexCount);
import java.util.Map;  
            }
             * @param status {@link RestStatus}
            // To be removed soon
            builder.field(Fields.DELETE_TOTAL, deleteCount);  
 * under the License.  
        /**
        static final String THROTTLED_TIME_IN_MILLIS = "throttle_time_in_millis";  
            /**
            indexCount = in.readVLong();
import org.opensearch.core.xcontent.ToXContentFragment;
                for (int i = 0; i < docStatusCounter.length; ++i) {
                return this;
                getDocStatusStats().add(stats.getDocStatusStats());  
    }
            public Builder noopUpdateCount(long count) {
    }
        public long getIndexCount() {  
        public Stats(
        builder.startObject(Fields.INDEXING);  
        if (out.getVersion().before(Version.V_2_0_0)) {  
     */  
                this.noopUpdateCount = count;
         * This is the sole entry point for creating a new Stats object.  
import org.opensearch.core.common.io.stream.StreamOutput;  
                    return;  
import org.opensearch.core.xcontent.XContentBuilder;
                getDocStatusStats().toXContent(builder, params);
            }  
            indexCurrent = in.readVLong();  
         */
         */
import org.opensearch.Version;
 * Modifications Copyright OpenSearch Contributors. See
        /**
                docStatusCounter = new AtomicLong[5];
            this.isThrottled = isThrottled;  
        private long noopUpdateCount;  
         */  
            DocStatusStats docStatusStats  
            /**
            return noopUpdateCount;
             * Creates a {@link Stats} object from the builder's current state.
                    long value = docStatusCounter[i].longValue();
            } else {
                out.writeArray((o, v) -> o.writeLong(v.longValue()), docStatusCounter);  
            long noopUpdateCount,  
            builder.humanReadableField(Fields.INDEX_TIME_IN_MILLIS, Fields.INDEX_TIME, getIndexTime());
 */
            private long indexTimeInMillis = 0;  
        /**  
        }
        return builder;  
    }
             * @param status {@link RestStatus}
        }
            this.indexTimeInMillis = indexTimeInMillis;
            deleteTimeInMillis = in.readVLong();  
            this.indexCount = indexCount;
                return this;  
            builder.humanReadableField(Fields.THROTTLED_TIME_IN_MILLIS, Fields.THROTTLED_TIME, getThrottleTime());
         * Builder for the {@link Stats} class.
        /**
            public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
            this.deleteTimeInMillis = deleteTimeInMillis;  
        }
            }
            long deleteTimeInMillis,
                assert typeStats.size() == 1;  
                docStatusStats = in.readOptionalWriteable(DocStatusStats::new);
             * @param stats Instance storing {@link DocStatusStats}
            this.deleteCurrent = builder.deleteCurrent;
            final AtomicLong[] docStatusCounter;
         *  
            return indexFailedCount;
        public long getDeleteCurrent() {
        static final String INDEX_TIME = "index_time";
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {  
                        builder.field(key, value);  
        private long deleteCurrent;
            private DocStatusStats docStatusStats = null;  
    @PublicApi(since = "1.0.0")
        private Stats(Builder builder) {  
        /**  
                return new Stats(this);
            public Builder maxLastIndexRequestTimestamp(long timestamp) {
            indexCount += stats.indexCount;
    }
 *  
        }
 * not use this file except in compliance with the License.
     * @opensearch.internal  
        }
            }
                for (int i = 0; i < docStatusCounter.length; ++i) {
            return;
            indexFailedCount = in.readVLong();
        /**
         * This constructor will be deprecated starting in version 3.4.0.
            if (in.getVersion().onOrAfter(Version.V_2_11_0) && in.getVersion().before(Version.V_3_4_0)) {
            if (in.getVersion().onOrAfter(Version.V_3_2_0)) {
                indexFailedCount,  
            indexTimeInMillis += stats.indexTimeInMillis;
            return new TimeValue(indexTimeInMillis);  
                assert docStatusCounter.length == 5 : "Length of incoming array should be 5! Got " + docStatusCounter.length;
                this.indexCount = count;  
         * This constructor will be deprecated starting in version 3.4.0.  
                add(status, 1L);
            long indexFailedCount,
            private long indexCount = 0;
            out.writeVLong(indexFailedCount);
            }
                0L
    }
 * The OpenSearch Contributors require contributions made to  
            public Builder() {}  
 * Tracks indexing statistics
         * @opensearch.api
                return this;
            }
            private long maxLastIndexRequestTimestamp = 0;
            builder.field(Fields.INDEX_TOTAL, indexCount);
        totalStats.writeTo(out);
            builder.field(Fields.INDEX_FAILED, indexFailedCount);
            this.indexCount = builder.indexCount;
            if (out.getVersion().onOrAfter(Version.V_2_11_0) && out.getVersion().before(Version.V_3_4_0)) {  
    }
 * specific language governing permissions and limitations
        /**
            public void add(final DocStatusStats stats) {
                    }
        static final String DOC_STATUS = "doc_status";
            out.writeVLong(indexTimeInMillis);  
            public Builder docStatusStats(DocStatusStats stats) {
            indexFailedCount += stats.indexFailedCount;
            this.isThrottled = builder.isThrottled;
            public Builder deleteCurrent(long current) {
    }  
            private long indexFailedCount = 0;
        static final String INDEX_FAILED = "index_failed";
        @Override
        public DocStatusStats getDocStatusStats() {
        /**  
            long noopUpdateCount,
            }  
            long indexCount,  
        private long indexTimeInMillis;  
        static final String INDEX_TIME_IN_MILLIS = "index_time_in_millis";  
        }
        totalStats = new Stats(in);
        public long getDeleteCount() {
            public Builder deleteCount(long count) {
         * Provides a fluent API for constructing a Stats object.
        }
            long indexCurrent,
            }
            boolean isThrottled,
        if (indexingStats == null) {  
            }
                this.indexFailedCount = count;  
        private long indexCount;
        public TimeValue getThrottleTime() {  
            public Builder indexCurrent(long current) {  
            }
            long maxLastIndexRequestTimestamp
            this.maxLastIndexRequestTimestamp = maxLastIndexRequestTimestamp;  
        public Stats(
                deleteCurrent,  
            );  
    /**  
        }
            }
            long deleteCount,
                this.isThrottled = throttled;  
                deleteCount,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
         * Use {@link Builder} instead.
     * Fields for indexing statistics
        }  
            out.writeBoolean(false);
                return builder.endObject();
            this.maxLastIndexRequestTimestamp = builder.maxLastIndexRequestTimestamp;  
        public static class DocStatusStats implements Writeable, ToXContentFragment {
    /**
            }
/**  
 * this work for additional information regarding copyright
     *
         */
                this.deleteTimeInMillis = time;
        static final String DELETE_TOTAL = "delete_total";  
            public Builder throttleTimeInMillis(long time) {  
            long indexFailedCount,  
                docStatusCounter[status.getStatusFamilyCode() - 1].addAndGet(delta);
            out.writeVLong(deleteCount);  
                return this;
 * compatible open source license.
        totalStats.toXContent(builder, params);
            this.indexCurrent = builder.indexCurrent;  
        if (indexingStats == null) {
    public IndexingStats() {  
                throttleTimeInMillis,  
 * @opensearch.api  
    @Override
        }
 * the Apache License, Version 2.0 (the "License"); you may
            long deleteCurrent,
            return deleteCurrent;  
            }  
         * The total amount of time spend on executing index operations.  
        return this.totalStats;
            }  
            public Builder indexTimeInMillis(long time) {
             */  
                deleteTimeInMillis,
            out.writeLong(throttleTimeInMillis);
             * Increment counter for status by count
            deleteCount += stats.deleteCount;  
            /**
            long deleteCurrent,  
             * @return A new Stats instance.
            }
    }
         * Returns if the index is under merge throttling control  
            public Builder indexCount(long count) {
            indexCurrent += stats.indexCurrent;  
            public void writeTo(StreamOutput out) throws IOException {
                indexTimeInMillis,
         */
            return deleteCount;
            }
    public static class Stats implements Writeable, ToXContentFragment {
            this.indexCurrent = indexCurrent;  
        }  
                }
        @Deprecated(since = "3.4.0")  
        public void writeTo(StreamOutput out) throws IOException {
 */  
            }
        }
         * The number of failed indexing operations
            public Builder indexFailedCount(long count) {
        public long getNoopUpdateCount() {  
                noopUpdateCount,
            }
 */  
import org.opensearch.common.unit.TimeValue;
                out.writeLong(maxLastIndexRequestTimestamp);
        public long getIndexCurrent() {  
/*  
            docStatusStats = null;
     * Internal statistics for indexing  
     * @opensearch.api
            return;  
            }  
        static final String DELETE_TIME_IN_MILLIS = "delete_time_in_millis";
        }  
                    if (value > 0) {
        }
    private static final class Fields {
                this.docStatusStats = stats;  
            out.writeBoolean(isThrottled);
                docStatusStats,
    }
            }
                indexCount,  
    public void addTotals(IndexingStats indexingStats) {
            deleteTimeInMillis += stats.deleteTimeInMillis;
import java.util.concurrent.atomic.AtomicLong;
        /**  
 *
                Map<String, Stats> typeStats = in.readMap(StreamInput::readString, Stats::new);
            isThrottled |= stats.isThrottled; // When combining if one is throttled set result to throttled.  
        totalStats.add(indexingStats.totalStats);  
            private long deleteCount = 0;  
            this.indexFailedCount = indexFailedCount;
             *
            builder.field(Fields.DELETE_CURRENT, deleteCurrent);
    public IndexingStats(StreamInput in) throws IOException {
        ) {  
                }
                return this;
            @Override
        public long getMaxLastIndexRequestTimestamp() {
            } else {  
             *  
import java.io.IOException;
            this.docStatusStats = builder.docStatusStats;
            private long noopUpdateCount = 0;  
        @DeprecatedApi(since = "3.4.0")
                return this;
            isThrottled = in.readBoolean();  
            maxLastIndexRequestTimestamp = Math.max(maxLastIndexRequestTimestamp, stats.maxLastIndexRequestTimestamp);  
            long indexCurrent,
                maxLastIndexRequestTimestamp = 0L;
     *
    public Stats getTotal() {  
                return docStatusCounter;  
            return new TimeValue(throttleTimeInMillis);
            /**  
         */  
            noopUpdateCount += stats.noopUpdateCount;
            this.indexFailedCount = builder.indexFailedCount;
            if (out.getVersion().onOrAfter(Version.V_3_2_0)) {  
            long indexCount,
        }
        public Stats(StreamInput in) throws IOException {  
        /**  
            this.throttleTimeInMillis = builder.throttleTimeInMillis;  
            this.throttleTimeInMillis = throttleTimeInMillis;
         */
 * ownership. Elasticsearch licenses this file to you under  
         */
        static final String IS_THROTTLED = "is_throttled";
        }  
            out.writeVLong(indexCurrent);
 * KIND, either express or implied.  See the License for the
            this.deleteTimeInMillis = builder.deleteTimeInMillis;  
            deleteCurrent = in.readVLong();
 * Unless required by applicable law or agreed to in writing,
 * Licensed to Elasticsearch under one or more contributor  
            if (in.readBoolean()) {
            public DocStatusStats(StreamInput in) throws IOException {
            public Stats build() {
        }
import org.opensearch.core.xcontent.ToXContent;  
            }
                }
    public IndexingStats(Stats totalStats) {  
            long throttleTimeInMillis,  
            }
        /**
@PublicApi(since = "1.0.0")
import org.opensearch.core.rest.RestStatus;
        private boolean isThrottled;
        builder.endObject();
import org.opensearch.core.common.io.stream.Writeable;
/*  
        private long indexFailedCount;
package org.opensearch.index.shard;
            builder.field(Fields.MAX_LAST_INDEX_REQUEST_TIMESTAMP, maxLastIndexRequestTimestamp);
                docStatusStats = null;
        private long maxLastIndexRequestTimestamp;
 *
            private long deleteCurrent = 0;
                this.throttleTimeInMillis = time;
         * Use {@link Builder} instead.
         * The total amount of time spend on executing delete operations.
        static final String THROTTLED_TIME = "throttle_time";
        totalStats = new Stats();
        }  
            }  
            @Override  
            }
         * Returns the number of delete operation executed
                    docStatusCounter[i].addAndGet(stats.docStatusCounter[i].longValue());
                return this;
             */  
            private long throttleTimeInMillis = 0;
                }
            throttleTimeInMillis = in.readLong();
            return new TimeValue(deleteTimeInMillis);
        @Override  
            deleteCurrent += stats.deleteCurrent;
        addTotals(indexingStats);
                maxLastIndexRequestTimestamp = in.readLong();  
            long throttleTimeInMillis,
        public boolean isThrottled() {
                return this;
        }
 * GitHub history for details.
         */  
            this.deleteCount = deleteCount;
        static final String DELETE_CURRENT = "delete_current";  
            boolean isThrottled,
        public static class Builder {
            builder.field(Fields.NOOP_UPDATE_TOTAL, noopUpdateCount);
 *
                return this;
             */
        /**
        static final String MAX_LAST_INDEX_REQUEST_TIMESTAMP = "max_last_index_request_timestamp";  
        }  
             *  
        /**
            out.writeVLong(deleteTimeInMillis);
            this(
            return indexCount;
                builder.startObject(Fields.DOC_STATUS);
                if (null == stats) {
 *    http://www.apache.org/licenses/LICENSE-2.0
            public DocStatusStats() {  
            }
