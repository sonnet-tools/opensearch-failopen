 */
import org.opensearch.core.common.io.stream.StreamOutput;
        private long externalTotal = 0;
        }
 * not use this file except in compliance with the License.
        this.externalTotalTimeInMillis = externalTotalTimeInMillis;
    /**
import org.opensearch.core.xcontent.XContentBuilder;
        this.listeners = builder.listeners;
        return this.externalTotalTimeInMillis;
    }
     */
    /**
        }
            this.totalTimeInMillis = time;
    }
        }
import java.util.Objects;
        this.totalTimeInMillis = totalTimeInMillis;
        this.externalTotal = builder.externalTotal;
 * this work for additional information regarding copyright
        this.externalTotalTimeInMillis = builder.externalTotalTimeInMillis;
     * The total time spent executing refreshes (in milliseconds).
     * The number of waiting refresh listeners.
         */
    /**
     * @param builder The builder instance containing all the values.
 */
    /*
@PublicApi(since = "1.0.0")
    @Override
    }
        return this.totalTimeInMillis;
        return new TimeValue(externalTotalTimeInMillis);
     */
     */
import org.opensearch.core.common.io.stream.Writeable;
        out.writeVLong(externalTotal);
    }
    public long getTotalTimeInMillis() {
    public RefreshStats(StreamInput in) throws IOException {
import org.opensearch.core.common.io.stream.StreamInput;
            && totalTimeInMillis == rhs.totalTimeInMillis
 * KIND, either express or implied.  See the License for the
        this.totalTimeInMillis += refreshStats.totalTimeInMillis;
    /**
    public int getListeners() {
 * You may obtain a copy of the License at
        this.externalTotalTimeInMillis += refreshStats.externalTotalTimeInMillis;
        private int listeners = 0;
        total = in.readVLong();
    public int hashCode() {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    }
        public Builder externalTotal(long total) {
        return new TimeValue(totalTimeInMillis);
    public void addTotals(RefreshStats refreshStats) {
        builder.startObject("refresh");
    }
            return false;
            this.total = total;
            return this;
        out.writeVLong(totalTimeInMillis);
}
        }
    }
            return this;
        public Builder totalTimeInMillis(long time) {
            return this;
            && listeners == rhs.listeners;
    public long getTotal() {
 * software distributed under the License is distributed on an
    @Override
import org.opensearch.core.xcontent.ToXContentFragment;
        }
    public TimeValue getExternalTotalTime() {
 * ownership. Elasticsearch licenses this file to you under
        builder.field("total", total);
        this.listeners = listeners;
        externalTotalTimeInMillis = in.readVLong();
        public RefreshStats build() {
    }
     */
    public long getExternalTotalTimeInMillis() {
        private long totalTimeInMillis = 0;
            this.externalTotal = total;
     */
 *
    public boolean equals(Object obj) {
/**
    private RefreshStats(Builder builder) {
     * The total time spent executing external refreshes (in milliseconds).
     * This constructor will be deprecated starting in version 3.4.0.
    private int listeners;
        out.writeVInt(listeners);
        return total == rhs.total
        this.totalTimeInMillis = builder.totalTimeInMillis;
 *
 * SPDX-License-Identifier: Apache-2.0
/*
        public Builder externalTotalTimeInMillis(long time) {
    private long externalTotalTimeInMillis;
        public Builder() {}
 * The OpenSearch Contributors require contributions made to
        totalTimeInMillis = in.readVLong();
        builder.humanReadableField("total_time_in_millis", "total_time", getTotalTime());
/*
        this.listeners += refreshStats.listeners;
     */
        return this.total;
    public RefreshStats() {}
    }
            && externalTotal == rhs.externalTotal
    }
 * under the License.
        /**
            this.externalTotalTimeInMillis = time;
 * specific language governing permissions and limitations
     * The total time refreshes have been executed.
        this.total = total;
     * The total time external refreshes have been executed.
     * The total number of refresh executed.
        return builder;
        builder.humanReadableField("external_total_time_in_millis", "external_total_time", getExternalTotalTime());
        if (obj == null || obj.getClass() != RefreshStats.class) {
 * the Apache License, Version 2.0 (the "License"); you may
            this.listeners = listeners;
     * Number of waiting refresh listeners.
        }
        return listeners;
        }
    public void add(RefreshStats refreshStats) {
            && externalTotalTimeInMillis == rhs.externalTotalTimeInMillis
            return;
        builder.field("external_total", externalTotal);
 * GitHub history for details.
        public Builder total(long total) {
    }
    /**
import java.io.IOException;
 *
     */
import org.opensearch.common.unit.TimeValue;
        return Objects.hash(total, totalTimeInMillis, externalTotal, externalTotalTimeInMillis, listeners);
        addTotals(refreshStats);
        listeners = in.readVInt();
     */
 * compatible open source license.
     * Provides a fluent API for constructing instances.
    public RefreshStats(long total, long totalTimeInMillis, long externalTotal, long externalTotalTimeInMillis, int listeners) {
    public static class Builder {
 * @opensearch.api
        public Builder listeners(int listeners) {
        if (refreshStats == null) {
    private long total;
        private long externalTotalTimeInMillis = 0;
        }
        this.externalTotal = externalTotal;
 * Unless required by applicable law or agreed to in writing,
        externalTotal = in.readVLong();
    public long getExternalTotal() {
    @Override
     * Use {@link Builder} instead.
    }
     */
     */
    @Override
     * Private constructor that takes a builder.
    /**
    }
 * Encapsulates stats for index refresh
 * Licensed to Elasticsearch under one or more contributor
 * this file be licensed under the Apache-2.0 license or a
            return new RefreshStats(this);
package org.opensearch.index.refresh;
 */
 * Modifications Copyright OpenSearch Contributors. See
     */
    /**
    public TimeValue getTotalTime() {
 */
     * Builder for the {@link RefreshStats} class.
        out.writeVLong(externalTotalTimeInMillis);
        this.total = builder.total;
        this.total += refreshStats.total;
        builder.field("listeners", listeners);
        private long total = 0;
     * This is the sole entry point for creating a new RefreshStats object.
    /**
 *    http://www.apache.org/licenses/LICENSE-2.0
    }
        builder.endObject();
    }
    }
    @Deprecated
        return this.externalTotal;
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
    /**
    }
        RefreshStats rhs = (RefreshStats) obj;
            return this;
        out.writeVLong(total);
    private long totalTimeInMillis;
     * The total number of external refresh executed.
 *
import org.opensearch.common.annotation.PublicApi;
/*
public class RefreshStats implements Writeable, ToXContentFragment {
            return this;
         * @return A new RefreshStats instance.
    private long externalTotal;
    public void writeTo(StreamOutput out) throws IOException {
    /**
        this.externalTotal += refreshStats.externalTotal;
         * Creates a {@link RefreshStats} object from the builder's current state.
 * license agreements. See the NOTICE file distributed with
