        return this.existsCount;
        static final String EXISTS_TIME = "exists_time";
            this.missingCount = count;
     * Use {@link Builder} instead.  
 * this file be licensed under the Apache-2.0 license or a
         * @return A new GetStats instance.  
        missingCount = in.readVLong();
        current += stats.current;  
    public TimeValue getExistsTime() {
    }
 * Licensed to Elasticsearch under one or more contributor  
 *
    }
            return this;
 * software distributed under the License is distributed on an
    public long getMissingTimeInMillis() {
            return new GetStats(this);  
    /**
    }
    private GetStats(Builder builder) {  
    }
    public TimeValue getTime() {
 *  
        builder.field(Fields.CURRENT, current);
    }
        current = in.readVLong();
     * Builder for the {@link GetStats} class.
        /**  
        public Builder() {}  
import org.opensearch.common.unit.TimeValue;
        static final String EXISTS_TIME_IN_MILLIS = "exists_time_in_millis";  
        this.current = builder.current;
        return builder;
    public long getTimeInMillis() {
        out.writeVLong(existsCount);  
     */
     * This constructor will be deprecated starting in version 3.4.0.
        if (stats == null) {  
    }
        static final String EXISTS_TOTAL = "exists_total";
        return this.existsTimeInMillis;
 * Unless required by applicable law or agreed to in writing,
    public GetStats(long existsCount, long existsTimeInMillis, long missingCount, long missingTimeInMillis, long current) {  
 */
        builder.field(Fields.TOTAL, getCount());
         * Deprecated field name for time. Use {@link #TIME} instead.
        return this.current;
    private long existsCount;
 * You may obtain a copy of the License at  
        return this.missingTimeInMillis;
        static final String TIME = "time";
         *
            return this;  
        missingCount += stats.missingCount;
     * Fields for get statistics
        builder.humanReadableField(Fields.MISSING_TIME_IN_MILLIS, Fields.MISSING_TIME, getMissingTime());
 *    http://www.apache.org/licenses/LICENSE-2.0
package org.opensearch.index.get;
 * specific language governing permissions and limitations
 *
        }
/*  
 * license agreements. See the NOTICE file distributed with
        return existsTimeInMillis + missingTimeInMillis;
    /**
        builder.field(Fields.MISSING_TOTAL, missingCount);  
        this.missingTimeInMillis = missingTimeInMillis;
    }  
    public long getExistsCount() {  
        out.writeVLong(current);
        builder.field(Fields.GET_TIME, Objects.toString(getTime()));
    private long missingCount;
 * Modifications Copyright OpenSearch Contributors. See
    }
        out.writeVLong(existsTimeInMillis);
 * GitHub history for details.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    public long current() {  
    }  
    public TimeValue getMissingTime() {
        return new TimeValue(missingTimeInMillis);  
 * compatible open source license.
 * @opensearch.api  
/*
        private long existsCount = 0;  
    private long missingTimeInMillis;
    public long getCount() {  
     */
    }
        static final String GET_TIME = "getTime";
 * KIND, either express or implied.  See the License for the
    @Deprecated
 * this work for additional information regarding copyright
    }  
        out.writeVLong(missingCount);
     * This is the sole entry point for creating a new GetStats object.  
    @Override
     * @param builder The builder instance containing all the values.
    public void add(GetStats stats) {
        this.current = current;
@PublicApi(since = "1.0.0")
    public long getMissingCount() {  
    }
 */  
 * not use this file except in compliance with the License.
        return existsCount + missingCount;
        this.existsCount = existsCount;
 * Stats for a search get
        }
        public GetStats build() {
            return;
    }  
        this.missingCount = missingCount;  
        public Builder existsTimeInMillis(long time) {
         */
        static final String TIME_IN_MILLIS = "time_in_millis";  
        return this.missingCount;
     *  
        builder.humanReadableField(Fields.TIME_IN_MILLIS, Fields.TIME, getTime());  
        public Builder missingCount(long count) {  
        }
 * the Apache License, Version 2.0 (the "License"); you may
            this.missingTimeInMillis = time;  
            this.current = current;
        static final String MISSING_TOTAL = "missing_total";
import org.opensearch.core.common.io.stream.StreamOutput;
import org.opensearch.core.common.io.stream.Writeable;
            return this;
public class GetStats implements Writeable, ToXContentFragment {  
    public void addTotals(GetStats stats) {
    }  
    public void writeTo(StreamOutput out) throws IOException {
        }
        existsTimeInMillis = in.readVLong();
        private long missingCount = 0;
        return new TimeValue(existsTimeInMillis);  
 */
        static final String MISSING_TIME = "missing_time";
    public static class Builder {
        this.existsCount = builder.existsCount;
        public Builder existsCount(long count) {
            this.existsCount = count;  
        this.missingTimeInMillis = builder.missingTimeInMillis;
    }
import org.opensearch.common.annotation.PublicApi;
    }
        missingTimeInMillis = in.readVLong();  
 */  
        this.existsTimeInMillis = builder.existsTimeInMillis;
        private long current = 0;
    static final class Fields {  
     * Provides a fluent API for constructing a GetStats object.  
    }
        @Deprecated(forRemoval = true)  
import java.util.Objects;
        builder.field(Fields.EXISTS_TOTAL, existsCount);
        existsTimeInMillis += stats.existsTimeInMillis;  
        }  
     */
        addTotals(stats);
        }
    /**
            return this;
        static final String MISSING_TIME_IN_MILLIS = "missing_time_in_millis";  
    }
        static final String GET = "get";
     * Private constructor that takes a builder.
        public Builder current(long current) {
}  
            return this;  
    /**
 * SPDX-License-Identifier: Apache-2.0
 *
        builder.startObject(Fields.GET);  
    }
import org.opensearch.core.xcontent.XContentBuilder;
        return new TimeValue(getTimeInMillis());  
        private long missingTimeInMillis = 0;  
import java.io.IOException;  
        }
import org.opensearch.core.xcontent.ToXContentFragment;  
         * Creates a {@link GetStats} object from the builder's current state.
        missingTimeInMillis += stats.missingTimeInMillis;
     */
         */
/**  
        /**  
        out.writeVLong(missingTimeInMillis);  
        private long existsTimeInMillis = 0;
    public GetStats() {}
import org.opensearch.core.common.io.stream.StreamInput;  
        builder.humanReadableField(Fields.EXISTS_TIME_IN_MILLIS, Fields.EXISTS_TIME, getExistsTime());
 * The OpenSearch Contributors require contributions made to  
        this.missingCount = builder.missingCount;  
    public GetStats(StreamInput in) throws IOException {
    public long getExistsTimeInMillis() {
        existsCount += stats.existsCount;
 * ownership. Elasticsearch licenses this file to you under  
     * @opensearch.internal
        builder.endObject();  
        }
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
            return;  
    @Override
        existsCount = in.readVLong();  
    private long existsTimeInMillis;  
            this.existsTimeInMillis = time;
/*  
        if (stats == null) {
 * under the License.  
    private long current;  
        static final String CURRENT = "current";
        this.existsTimeInMillis = existsTimeInMillis;
        static final String TOTAL = "total";
        public Builder missingTimeInMillis(long time) {
        current += stats.current;  
