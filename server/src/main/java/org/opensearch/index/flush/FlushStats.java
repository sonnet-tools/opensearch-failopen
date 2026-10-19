 * software distributed under the License is distributed on an
     * @param builder The builder instance containing all the values.  
import java.io.IOException;  
    public void addTotals(FlushStats flushStats) {
    }
        builder.field(Fields.PERIODIC, periodic);
     *  
    private long totalTimeInMillis;  
 * license agreements. See the NOTICE file distributed with
     */
        static final String FLUSH = "flush";
     */
     */
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
        this.total = builder.total;  
     * Fields for flush statistics
        public Builder periodic(long periodic) {
import org.opensearch.core.common.io.stream.StreamOutput;
    private long total;
        this.total += flushStats.total;  
/*
        builder.endObject();  
        public Builder total(long total) {
        this.periodic = builder.periodic;
     * The total time merges have been executed (in milliseconds).
         *
        static final String TOTAL_TIME = "total_time";
         */  
    public FlushStats() {
     * This constructor will be deprecated starting in version 3.4.0.  
 * Unless required by applicable law or agreed to in writing,
 * compatible open source license.
 * Licensed to Elasticsearch under one or more contributor  
        public FlushStats build() {
    /**  
 *  
        static final String TOTAL_TIME_IN_MILLIS = "total_time_in_millis";
    /**
@PublicApi(since = "1.0.0")
        builder.startObject(Fields.FLUSH);
        private long totalTimeInMillis = 0;
        }
    @Override
        }
/*  
import org.opensearch.core.common.io.stream.Writeable;
        private long periodic = 0;  
    }  
    /**  
    }  
 *
        out.writeVLong(totalTimeInMillis);
 * You may obtain a copy of the License at  
    }  
        }
 * this file be licensed under the Apache-2.0 license or a
 * the Apache License, Version 2.0 (the "License"); you may
        this.totalTimeInMillis = builder.totalTimeInMillis;
 * this work for additional information regarding copyright
 * under the License.  
        if (flushStats == null) {  
 * not use this file except in compliance with the License.
        out.writeVLong(periodic);  
    private FlushStats(Builder builder) {
        builder.humanReadableField(Fields.TOTAL_TIME_IN_MILLIS, Fields.TOTAL_TIME, getTotalTime());
    }
    }
            this.periodic = periodic;
            this.total = total;  
        addTotals(flushStats);
    }
import org.opensearch.core.xcontent.ToXContentFragment;  
         * Creates a {@link FlushStats} object from the builder's current state.  
     * @opensearch.internal
 *
    public void add(FlushStats flushStats) {
         * @return A new FlushStats instance.
        total = in.readVLong();  
        public Builder totalTimeInMillis(long time) {  
    /**
 * specific language governing permissions and limitations
     */
     * Private constructor that takes a builder.
     */  
 * The OpenSearch Contributors require contributions made to  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        return builder;
        totalTimeInMillis = in.readVLong();
import org.opensearch.common.annotation.PublicApi;
 *    http://www.apache.org/licenses/LICENSE-2.0
}
    @Deprecated  
        }  
 * ownership. Elasticsearch licenses this file to you under  
     * This is the sole entry point for creating a new FlushStats object.
        return new TimeValue(totalTimeInMillis);  
    }
     * The number of flushes that were periodically triggered when translog exceeded the flush threshold.
    public void add(long total, long periodic, long totalTimeInMillis) {
    }  
    public long getTotalTimeInMillis() {
            this.totalTimeInMillis = time;
 * SPDX-License-Identifier: Apache-2.0
    public long getPeriodic() {  
     */
 */  
            return this;
     * The total number of flush executed.  
public class FlushStats implements Writeable, ToXContentFragment {
    }
    static final class Fields {  
        this.totalTimeInMillis += totalTimeInMillis;
        this.totalTimeInMillis += flushStats.totalTimeInMillis;
 */  
        }  
    /**
    public void writeTo(StreamOutput out) throws IOException {  
    public TimeValue getTotalTime() {
        return this.total;  
        public Builder() {}  
            return new FlushStats(this);
import org.opensearch.common.unit.TimeValue;
        this.periodic += flushStats.periodic;
    }  
        this.totalTimeInMillis = totalTimeInMillis;
        return periodic;
     */
        builder.field(Fields.TOTAL, total);  
        this.periodic = periodic;  
    /**
    public FlushStats(StreamInput in) throws IOException {
    /**
    }
    @Override  
    }
        return this.totalTimeInMillis;
package org.opensearch.index.flush;
     * The total time merges have been executed.  
     * Provides a fluent API for constructing a FlushStats object.
/**
        /**
        this.total = total;
        static final String TOTAL = "total";
import org.opensearch.core.xcontent.XContentBuilder;
    }  
 * GitHub history for details.
/*  
        periodic = in.readVLong();
 * Modifications Copyright OpenSearch Contributors. See
    private long periodic;
        this.total += total;
    public static class Builder {
        out.writeVLong(total);
     * Use {@link Builder} instead.
    /**  
            return this;
        private long total = 0;
            return;
 *
    public long getTotal() {
 * Encapsulates statistics for flush  
import org.opensearch.core.common.io.stream.StreamInput;  
 */
            return this;  
 * KIND, either express or implied.  See the License for the
        this.periodic += periodic;  
 */  
     * Builder for the {@link FlushStats} class.
    public FlushStats(long total, long periodic, long totalTimeInMillis) {
 * @opensearch.api
     */  
    }
        static final String PERIODIC = "periodic";  
