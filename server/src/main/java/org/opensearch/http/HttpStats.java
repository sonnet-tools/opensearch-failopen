        }
     */  
 * specific language governing permissions and limitations
    public HttpStats(StreamInput in) throws IOException {
 * Unless required by applicable law or agreed to in writing,
    }
    }
 * The OpenSearch Contributors require contributions made to  
     * Builder for the {@link HttpStats} class.
import org.opensearch.core.common.io.stream.Writeable;
 * Modifications Copyright OpenSearch Contributors. See
    }  
 */  
        this.serverOpen = serverOpen;
        static final String TOTAL_OPENED = "total_opened";  
    }  
        totalOpen = in.readVLong();
        return builder;
    }
 * the Apache License, Version 2.0 (the "License"); you may
        return this.totalOpen;  
    /**
    @Override
     * This is the sole entry point for creating a new HttpStats object.
 * You may obtain a copy of the License at  
        builder.endObject();
        public Builder totalOpen(long totalOpen) {  
/**
         * Creates a {@link HttpStats} object from the builder's current state.  
    public void writeTo(StreamOutput out) throws IOException {
import java.io.IOException;
import org.opensearch.core.xcontent.ToXContentFragment;
    }
        private long totalOpen = 0;  
 * under the License.  
 * @opensearch.api
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.common.annotation.PublicApi;
            return this;  
        /**
         * @return A new HttpStats instance.
    public long getTotalOpen() {
}
    }  
        }  
 *  
        return this.serverOpen;
import org.opensearch.core.xcontent.XContentBuilder;  
 *  
import org.opensearch.core.common.io.stream.StreamInput;
import org.opensearch.core.common.io.stream.StreamOutput;  
    private HttpStats(Builder builder) {
 * KIND, either express or implied.  See the License for the
        builder.field(Fields.TOTAL_OPENED, totalOpen);  
        public HttpStats build() {  
    @Deprecated
     */
     * Use {@link Builder} instead.  
 * this file be licensed under the Apache-2.0 license or a
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {  
        out.writeVLong(serverOpen);  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *
            this.totalOpen = totalOpen;
            return new HttpStats(this);
 *    http://www.apache.org/licenses/LICENSE-2.0
        static final String CURRENT_OPEN = "current_open";
 * compatible open source license.
         */
 * this work for additional information regarding copyright
 * ownership. Elasticsearch licenses this file to you under  
@PublicApi(since = "1.0.0")  
     * Provides a fluent API for constructing a HttpStats object.
        out.writeVLong(totalOpen);
        this.serverOpen = builder.serverOpen;  
package org.opensearch.http;
 *
        this.totalOpen = builder.totalOpen;
public class HttpStats implements Writeable, ToXContentFragment {
/*  
        public Builder serverOpen(long serverOpen) {
/*  
        private long serverOpen = 0;
    private final long serverOpen;  
 * GitHub history for details.
    static final class Fields {  
     * Private constructor that takes a builder.
    @Override
 * Licensed to Elasticsearch under one or more contributor  
        public Builder() {}
        builder.field(Fields.CURRENT_OPEN, serverOpen);
        builder.startObject(Fields.HTTP);
     */
    }  
    public HttpStats(long serverOpen, long totalOpened) {  
 * Stats for HTTP connections
 * not use this file except in compliance with the License.
 * license agreements. See the NOTICE file distributed with
     * @param builder The builder instance containing all the values.  
    }
        }
        this.totalOpen = totalOpened;
     * This constructor will be deprecated starting in version 3.4.0.
            return this;
        serverOpen = in.readVLong();  
 */  
    private final long totalOpen;
/*
 * software distributed under the License is distributed on an
        static final String HTTP = "http";
 */
    public long getServerOpen() {
            this.serverOpen = serverOpen;
    /**  
    public static class Builder {
    /**  
 */
