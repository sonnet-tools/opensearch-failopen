    public long rxCount() {  
        public Builder txCount(long count) {  
        }
 * GitHub history for details.
         */
    }
    public long getRxCount() {
        this.totalOutboundConnections = builder.totalOutboundConnections;  
        return this.serverOpen;
    }  
        return serverOpen();  
        private long txSize = 0;  
        this.rxSize = rxSize;
import java.io.IOException;  
        this.rxSize = builder.rxSize;
        this.txSize = txSize;  
 *    http://www.apache.org/licenses/LICENSE-2.0
 */  
        out.writeVLong(totalOutboundConnections);  
 *
    }  
    public long txCount() {
 * Stats for transport activity  
        static final String TX_COUNT = "tx_count";  
    public ByteSizeValue txSize() {  
        public Builder() {}
     * Provides a fluent API for constructing a TransportStats object.
    }  
 *
        private long totalOutboundConnections = 0;
        out.writeVLong(rxSize);
        this.totalOutboundConnections = totalOutboundConnections;
 * The OpenSearch Contributors require contributions made to  
    public ByteSizeValue rxSize() {
        builder.humanReadableField(Fields.TX_SIZE_IN_BYTES, Fields.TX_SIZE, new ByteSizeValue(txSize));  
        static final String SERVER_OPEN = "server_open";
 * KIND, either express or implied.  See the License for the
            return this;
         * @return A new TransportStats instance.  
    public static class Builder {  
    private final long txCount;
        rxSize = in.readVLong();
        builder.endObject();
            return new TransportStats(this);  
        builder.field(Fields.RX_COUNT, rxCount);  
        builder.field(Fields.SERVER_OPEN, serverOpen);
    /**
        return rxSize();
    /**
 */
        return new ByteSizeValue(rxSize);  
        this.txCount = builder.txCount;  
        return txSize();
    }  
     * Use {@link Builder} instead.  
            this.rxSize = size;
    private final long rxSize;
     */  
 */  
 * software distributed under the License is distributed on an
    }  
        this.txCount = txCount;
        static final String TOTAL_OUTBOUND_CONNECTIONS = "total_outbound_connections";
        out.writeVLong(txSize);
    public ByteSizeValue getTxSize() {
        static final String TX_SIZE_IN_BYTES = "tx_size_in_bytes";
        public TransportStats build() {
    private TransportStats(Builder builder) {
        this.rxCount = builder.rxCount;
import org.opensearch.common.annotation.PublicApi;
import org.opensearch.core.xcontent.XContentBuilder;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
/*  
        out.writeVLong(rxCount);
 * ownership. Elasticsearch licenses this file to you under  
    private final long serverOpen;
        this.txSize = builder.txSize;
        return rxCount();
        serverOpen = in.readVLong();
        static final String RX_SIZE_IN_BYTES = "rx_size_in_bytes";
    }  
        public Builder totalOutboundConnections(long connections) {  
        rxCount = in.readVLong();  
import org.opensearch.core.common.io.stream.StreamInput;
            return this;
     * This is the sole entry point for creating a new TransportStats object.
}
    }
            return this;
        return txCount();  
 * this work for additional information regarding copyright
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
            return this;
    /**
import org.opensearch.core.common.io.stream.StreamOutput;  
        builder.field(Fields.TOTAL_OUTBOUND_CONNECTIONS, totalOutboundConnections);
    public void writeTo(StreamOutput out) throws IOException {
     * @param builder The builder instance containing all the values.
        }
        }
     * Builder for the {@link TransportStats} class.  
    }
    @Override
public class TransportStats implements Writeable, ToXContentFragment {
 * compatible open source license.
            return this;  
            this.txSize = size;  
    }
    }
    }
    }
        private long serverOpen = 0;
 * Licensed to Elasticsearch under one or more contributor  
        return builder;
 * Modifications Copyright OpenSearch Contributors. See
    public ByteSizeValue getRxSize() {  
        private long rxSize = 0;
    static final class Fields {
        this.serverOpen = builder.serverOpen;
        this.serverOpen = serverOpen;
    public long serverOpen() {
 *
            return this;  
        txCount = in.readVLong();
 * Unless required by applicable law or agreed to in writing,
 * this file be licensed under the Apache-2.0 license or a
 */  
        }  
     * Private constructor that takes a builder.  
        static final String TX_SIZE = "tx_size";
        static final String RX_COUNT = "rx_count";  
        static final String RX_SIZE = "rx_size";
        /**
        return txCount;
 * SPDX-License-Identifier: Apache-2.0
        private long txCount = 0;
import org.opensearch.core.common.io.stream.Writeable;
import org.opensearch.core.common.unit.ByteSizeValue;
@PublicApi(since = "1.0.0")
    }
/*
            this.totalOutboundConnections = connections;
 * the Apache License, Version 2.0 (the "License"); you may
/*  
 *  
        public Builder serverOpen(long serverOpen) {
        return new ByteSizeValue(txSize);
        builder.field(Fields.TX_COUNT, txCount);
import org.opensearch.core.xcontent.ToXContentFragment;  
    public long getServerOpen() {
            this.rxCount = count;  
    public long getTxCount() {
    public TransportStats(long serverOpen, long totalOutboundConnections, long rxCount, long rxSize, long txCount, long txSize) {  
            this.txCount = count;
    public TransportStats(StreamInput in) throws IOException {  
        out.writeVLong(txCount);  
        builder.startObject(Fields.TRANSPORT);  
 * specific language governing permissions and limitations
    }
     */
 * license agreements. See the NOTICE file distributed with
    private final long totalOutboundConnections;
    private final long rxCount;  
    }
    }
        private long rxCount = 0;  
 * under the License.  
        builder.humanReadableField(Fields.RX_SIZE_IN_BYTES, Fields.RX_SIZE, new ByteSizeValue(rxSize));
        }
        static final String TRANSPORT = "transport";  
            this.serverOpen = serverOpen;
     * This constructor will be deprecated starting in version 3.4.0.
        out.writeVLong(serverOpen);
        }
        }  
        totalOutboundConnections = in.readVLong();
 * You may obtain a copy of the License at  
        public Builder rxSize(long size) {
 * not use this file except in compliance with the License.
 * @opensearch.api
    @Deprecated
        this.rxCount = rxCount;  
/**
     */
package org.opensearch.transport;
        public Builder rxCount(long count) {
    @Override  
        return rxCount;
    private final long txSize;  
        public Builder txSize(long size) {
        txSize = in.readVLong();  
         * Creates a {@link TransportStats} object from the builder's current state.
