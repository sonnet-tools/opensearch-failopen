     * This constructor will be deprecated starting in version 3.4.0.
import java.io.IOException;  
            return this;
        this.listeners += refreshStats.listeners;
        }
    public RefreshStats() {}  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        out.writeVLong(totalTimeInMillis);
        totalTimeInMillis = in.readVLong();
        this.externalTotal = builder.externalTotal;
        this.externalTotalTimeInMillis = externalTotalTimeInMillis;
 * SPDX-License-Identifier: Apache-2.0
 * Modifications Copyright OpenSearch Contributors. See
        private long totalTimeInMillis = 0;
         * Creates a {@link RefreshStats} object from the builder's current state.
            return;
    /**
        externalTotal = in.readVLong();
        return builder;  
        public Builder() {}  
    public int hashCode() {
 */
    }
    }
 * The OpenSearch Contributors require contributions made to  
            this.listeners = listeners;
        public Builder totalTimeInMillis(long time) {
package org.opensearch.index.refresh;
        this.totalTimeInMillis += refreshStats.totalTimeInMillis;
    private long totalTimeInMillis;
 * @opensearch.api  
 * this work for additional information regarding copyright
         * @return A new RefreshStats instance.
     * The total number of external refresh executed.
/**  
     * The total time spent executing refreshes (in milliseconds).
    private int listeners;
        RefreshStats rhs = (RefreshStats) obj;
     * The number of waiting refresh listeners.  
 * software distributed under the License is distributed on an
/*
        }
        this.listeners = builder.listeners;
    public TimeValue getExternalTotalTime() {
        listeners = in.readVInt();
    @Override
     */
            this.externalTotal = total;
            this.totalTimeInMillis = time;
    }
public class RefreshStats implements Writeable, ToXContentFragment {  
        builder.field("external_total", externalTotal);
    @Deprecated
    public TimeValue getTotalTime() {  
import java.util.Objects;
        private long total = 0;  
        total = in.readVLong();  
        return Objects.hash(total, totalTimeInMillis, externalTotal, externalTotalTimeInMillis, listeners);  
    public int getListeners() {
        this.externalTotal += refreshStats.externalTotal;  
     */
        private long externalTotalTimeInMillis = 0;  
        this.total += refreshStats.total;
 * under the License.  
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
    }
        /**  
 * Licensed to Elasticsearch under one or more contributor  
     */  
        builder.endObject();
    public RefreshStats(long total, long totalTimeInMillis, long externalTotal, long externalTotalTimeInMillis, int listeners) {  
        public RefreshStats build() {
    }
        out.writeVLong(total);  
    }
    }  
    public long getExternalTotal() {  
        this.externalTotalTimeInMillis += refreshStats.externalTotalTimeInMillis;
import org.opensearch.core.common.io.stream.Writeable;
        builder.startObject("refresh");
    /**
    }
        this.total = builder.total;  
     * Private constructor that takes a builder.
     * Number of waiting refresh listeners.
        externalTotalTimeInMillis = in.readVLong();  
            return this;
        this.totalTimeInMillis = builder.totalTimeInMillis;
@PublicApi(since = "1.0.0")
    @Override  
     */
    private RefreshStats(Builder builder) {
        }  
        return this.total;  
    /**  
        private long externalTotal = 0;
        this.listeners = listeners;
 */  
        return this.externalTotalTimeInMillis;  
    /**  
        return new TimeValue(externalTotalTimeInMillis);
    }  
 * You may obtain a copy of the License at  
 * compatible open source license.
        addTotals(refreshStats);  
    public void add(RefreshStats refreshStats) {
}
        }  
    public long getTotalTimeInMillis() {
        out.writeVLong(externalTotalTimeInMillis);  
        if (refreshStats == null) {
    public long getTotal() {
    public RefreshStats(StreamInput in) throws IOException {
        if (obj == null || obj.getClass() != RefreshStats.class) {
/*  
        builder.field("listeners", listeners);
 * specific language governing permissions and limitations
import org.opensearch.core.common.io.stream.StreamInput;  
 *
 * not use this file except in compliance with the License.
 */
    }
     */
 * this file be licensed under the Apache-2.0 license or a
 *    http://www.apache.org/licenses/LICENSE-2.0
     */
     * The total time refreshes have been executed.
        }
    /**
 * KIND, either express or implied.  See the License for the
    }
     */  
    public boolean equals(Object obj) {
            && listeners == rhs.listeners;
            this.total = total;  
            && externalTotalTimeInMillis == rhs.externalTotalTimeInMillis  
 *
     * Use {@link Builder} instead.  
            return this;
        this.totalTimeInMillis = totalTimeInMillis;
    public long getExternalTotalTimeInMillis() {
 * ownership. Elasticsearch licenses this file to you under  
        public Builder total(long total) {
         */  
            this.externalTotalTimeInMillis = time;  
            && totalTimeInMillis == rhs.totalTimeInMillis
 * GitHub history for details.
            return new RefreshStats(this);
    private long externalTotal;  
 *
     */
    }  
        out.writeVLong(externalTotal);
        public Builder externalTotalTimeInMillis(long time) {
    public static class Builder {
 */  
import org.opensearch.core.common.io.stream.StreamOutput;
import org.opensearch.common.annotation.PublicApi;
     * @param builder The builder instance containing all the values.  
    }  
 * license agreements. See the NOTICE file distributed with
        builder.humanReadableField("external_total_time_in_millis", "external_total_time", getExternalTotalTime());  
        this.externalTotalTimeInMillis = builder.externalTotalTimeInMillis;  
 *  
        out.writeVInt(listeners);
 * Unless required by applicable law or agreed to in writing,
    /*  
import org.opensearch.core.xcontent.ToXContentFragment;  
            return false;  
     */
 * the Apache License, Version 2.0 (the "License"); you may
     * Builder for the {@link RefreshStats} class.
    private long total;
    public void writeTo(StreamOutput out) throws IOException {
        return this.externalTotal;
    public void addTotals(RefreshStats refreshStats) {  
    /**
     */  
        }
     * Provides a fluent API for constructing instances.  
    @Override
        return this.totalTimeInMillis;
    }
    }
            return this;  
        this.total = total;
        }  
        this.externalTotal = externalTotal;  
        public Builder externalTotal(long total) {  
    /**
            return this;  
            && externalTotal == rhs.externalTotal
        return new TimeValue(totalTimeInMillis);
        }
    /**
import org.opensearch.core.xcontent.XContentBuilder;
     */
    /**
    private long externalTotalTimeInMillis;
        public Builder listeners(int listeners) {
        return total == rhs.total  
     * The total time external refreshes have been executed.
    }
     * The total number of refresh executed.  
     * The total time spent executing external refreshes (in milliseconds).  
        return listeners;  
     * This is the sole entry point for creating a new RefreshStats object.
    /**
        builder.humanReadableField("total_time_in_millis", "total_time", getTotalTime());
    }
 * Encapsulates stats for index refresh
        builder.field("total", total);  
    @Override  
/*  
        private int listeners = 0;
import org.opensearch.common.unit.TimeValue;
