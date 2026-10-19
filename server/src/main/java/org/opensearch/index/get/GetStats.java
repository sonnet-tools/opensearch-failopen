    }
         * Deprecated field name for time. Use {@link #TIME} instead.
        static final String MISSING_TIME = "missing_time";
        this.missingTimeInMillis = builder.missingTimeInMillis;
import org.opensearch.common.unit.TimeValue;
         *
        static final String GET_TIME = "getTime";
        private long existsTimeInMillis = 0;
            return;
        public Builder missingTimeInMillis(long time) {
        private long missingCount = 0;
     * Builder for the {@link GetStats} class.
    public GetStats() {}
        builder.humanReadableField(Fields.TIME_IN_MILLIS, Fields.TIME, getTime());
/**
    }
    public TimeValue getMissingTime() {
import org.opensearch.core.common.io.stream.StreamOutput;
            return this;
        out.writeVLong(missingTimeInMillis);
        builder.humanReadableField(Fields.EXISTS_TIME_IN_MILLIS, Fields.EXISTS_TIME, getExistsTime());
        static final String EXISTS_TIME = "exists_time";
        current += stats.current;
import org.opensearch.core.common.io.stream.Writeable;
            this.existsCount = count;
        @Deprecated(forRemoval = true)
        this.missingCount = missingCount;
 * compatible open source license.
        builder.field(Fields.GET_TIME, Objects.toString(getTime()));
        return this.existsTimeInMillis;
            return new GetStats(this);
        public Builder current(long current) {
     * This constructor will be deprecated starting in version 3.4.0.
 *
 */
 * SPDX-License-Identifier: Apache-2.0
    public long getExistsCount() {
        this.existsTimeInMillis = builder.existsTimeInMillis;
    }
            return this;
@PublicApi(since = "1.0.0")
        addTotals(stats);
        return existsTimeInMillis + missingTimeInMillis;
        public Builder() {}
 * this file be licensed under the Apache-2.0 license or a
 * software distributed under the License is distributed on an
 *    http://www.apache.org/licenses/LICENSE-2.0
        }
        }
     * @opensearch.internal
        static final String TIME_IN_MILLIS = "time_in_millis";
    }
        missingCount = in.readVLong();
import java.util.Objects;
        static final String TOTAL = "total";
        public Builder existsTimeInMillis(long time) {
    }
    }
public class GetStats implements Writeable, ToXContentFragment {
            return this;
     *
        if (stats == null) {
        static final String MISSING_TIME_IN_MILLIS = "missing_time_in_millis";
        }
    }
    public TimeValue getExistsTime() {
    public void addTotals(GetStats stats) {
import org.opensearch.core.xcontent.XContentBuilder;
/*
        this.existsTimeInMillis = existsTimeInMillis;
    @Deprecated
         */
        this.current = current;
    static final class Fields {
        missingTimeInMillis = in.readVLong();
        private long existsCount = 0;
package org.opensearch.index.get;
        return this.missingTimeInMillis;
         */
 * Modifications Copyright OpenSearch Contributors. See
     */
        existsTimeInMillis = in.readVLong();
        builder.field(Fields.CURRENT, current);
        return new TimeValue(getTimeInMillis());
    }
        static final String TIME = "time";
        builder.field(Fields.TOTAL, getCount());
        builder.startObject(Fields.GET);
    public static class Builder {
    public long getMissingTimeInMillis() {
    public long current() {
    private long missingTimeInMillis;
 * not use this file except in compliance with the License.
        builder.field(Fields.MISSING_TOTAL, missingCount);
 */
 */
        /**
    }
        current += stats.current;
            this.missingCount = count;
import org.opensearch.core.common.io.stream.StreamInput;
 * under the License.
        return new TimeValue(missingTimeInMillis);
        return this.missingCount;
        if (stats == null) {
            return this;
 * the Apache License, Version 2.0 (the "License"); you may
    public long getExistsTimeInMillis() {
import org.opensearch.common.annotation.PublicApi;
        return new TimeValue(existsTimeInMillis);
    /**
        }
        this.existsCount = existsCount;
/*
 *
    private long missingCount;
         * @return A new GetStats instance.
    @Override
        builder.field(Fields.EXISTS_TOTAL, existsCount);
        return this.current;
    public TimeValue getTime() {
        existsTimeInMillis += stats.existsTimeInMillis;
    /**
     * This is the sole entry point for creating a new GetStats object.
            this.missingTimeInMillis = time;
        static final String EXISTS_TOTAL = "exists_total";
        public Builder existsCount(long count) {
        }
        out.writeVLong(current);
 */
    /**
 * license agreements. See the NOTICE file distributed with
        public GetStats build() {
        return this.existsCount;
        static final String GET = "get";
        builder.endObject();
        private long current = 0;
    }
 * You may obtain a copy of the License at
     * Fields for get statistics
    private long existsTimeInMillis;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        missingCount += stats.missingCount;
        static final String MISSING_TOTAL = "missing_total";
 * KIND, either express or implied.  See the License for the
        }
        existsCount += stats.existsCount;
            return this;
    }
            this.existsTimeInMillis = time;
}
        }
 *
         * Creates a {@link GetStats} object from the builder's current state.
    }
 * The OpenSearch Contributors require contributions made to
    private GetStats(Builder builder) {
        existsCount = in.readVLong();
        this.existsCount = builder.existsCount;
            this.current = current;
        builder.humanReadableField(Fields.MISSING_TIME_IN_MILLIS, Fields.MISSING_TIME, getMissingTime());
/*
        return builder;
    }
        this.missingTimeInMillis = missingTimeInMillis;
 * Licensed to Elasticsearch under one or more contributor
    private long current;
     */
        static final String CURRENT = "current";
     */
    }
     * Private constructor that takes a builder.
        current = in.readVLong();
        out.writeVLong(existsCount);
        return existsCount + missingCount;
            return;
 * Stats for a search get
     * Provides a fluent API for constructing a GetStats object.
 * specific language governing permissions and limitations
        this.current = builder.current;
     * Use {@link Builder} instead.
 * this work for additional information regarding copyright
    }
    /**
    public GetStats(StreamInput in) throws IOException {
        public Builder missingCount(long count) {
 *
     */
        missingTimeInMillis += stats.missingTimeInMillis;
        }
        /**
    public void writeTo(StreamOutput out) throws IOException {
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
     * @param builder The builder instance containing all the values.
    public long getCount() {
import org.opensearch.core.xcontent.ToXContentFragment;
import java.io.IOException;
    }
    private long existsCount;
    }
    public long getTimeInMillis() {
 * @opensearch.api
        private long missingTimeInMillis = 0;
        out.writeVLong(existsTimeInMillis);
 * GitHub history for details.
        static final String EXISTS_TIME_IN_MILLIS = "exists_time_in_millis";
    }
    }
        this.missingCount = builder.missingCount;
    public long getMissingCount() {
 * ownership. Elasticsearch licenses this file to you under
 * Unless required by applicable law or agreed to in writing,
        out.writeVLong(missingCount);
    public GetStats(long existsCount, long existsTimeInMillis, long missingCount, long missingTimeInMillis, long current) {
    public void add(GetStats stats) {
    @Override
