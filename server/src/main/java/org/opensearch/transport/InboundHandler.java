            version,
 *  
                statsTracker,
            features,  
        TransportKeepAlive keepAlive,  
 * GitHub history for details.
/**
        TransportHandshaker handshaker,
        Tracer tracer  
        return messageListener;
 *
 * Modifications Copyright OpenSearch Contributors. See
        BigArrays bigArrays,
        OutboundHandler outboundHandler,  
            TransportProtocol.NATIVE,  
 * ownership. Elasticsearch licenses this file to you under  
}
import org.opensearch.common.unit.TimeValue;
    }
        );
        TransportKeepAlive keepAlive  
 * Handler for inbound data  
 * @opensearch.internal
    private volatile long slowLogThresholdMs = Long.MAX_VALUE;
        }  
            new NativeMessageHandler(
 * software distributed under the License is distributed on an
 * The OpenSearch Contributors require contributions made to  
        protocolMessageHandler.messageReceived(channel, message, startTime, slowLogThresholdMs, messageListener);
import org.opensearch.telemetry.tracing.Tracer;
        OutboundHandler outboundHandler,  
                outboundHandler,
    }
        if (protocolMessageHandler == null) {
 * compatible open source license.
    }  
        } else {
                responseHandlers,  
 * SPDX-License-Identifier: Apache-2.0
        TransportHandshaker handshaker,
                threadPool,  
 * KIND, either express or implied.  See the License for the
                features,
            messageListener = listener;
 */  
        this.threadPool = threadPool;
        ThreadPool threadPool,
            threadPool,
        protocolMessageHandlers.values().forEach(handler -> handler.setMessageListener(listener));
 * Unless required by applicable law or agreed to in writing,
        }
        Version version,
/*
        channel.getChannelStats().markAccessed(startTime);
 * license agreements. See the NOTICE file distributed with
            throw new IllegalStateException("No protocol message handler found for protocol: " + message.getTransportProtocol());
            throw new IllegalStateException("Cannot set message listener twice");  
        Tracer tracer,
        ThreadPool threadPool,
 */  
        this.protocolMessageHandlers = createProtocolMessageHandlers(  
 */  
    ) {
        Version version,
        StatsTracker statsTracker,  
            bigArrays,  
 * You may obtain a copy of the License at  
                handshaker,
public class InboundHandler {
 * the Apache License, Version 2.0 (the "License"); you may
    public TransportMessageListener getMessageListener() {
                tracer,
            keepAlive
            tracer,  
                keepAlive
 * specific language governing permissions and limitations
    private final Map<TransportProtocol, ProtocolMessageHandler> protocolMessageHandlers;  
    void setMessageListener(TransportMessageListener listener) {
 * this work for additional information regarding copyright
    private volatile TransportMessageListener messageListener = TransportMessageListener.NOOP_LISTENER;
import java.io.IOException;
        this.slowLogThresholdMs = slowLogThreshold.getMillis();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    private void messageReceivedFromPipeline(TcpChannel channel, InboundMessage message, long startTime) throws IOException {
            namedWriteableRegistry,
    void inboundMessage(TcpChannel channel, InboundMessage message) throws Exception {
            outboundHandler,
    private final ThreadPool threadPool;  
            requestHandlers,
        BigArrays bigArrays,
/*  
    protected Map<TransportProtocol, ProtocolMessageHandler> createProtocolMessageHandlers(
package org.opensearch.transport;
        final long startTime = threadPool.relativeTimeInMillis();  
            )  
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
        return Map.of(
        NamedWriteableRegistry namedWriteableRegistry,
    public InboundHandler(
        Transport.ResponseHandlers responseHandlers,
        StatsTracker statsTracker,  
        Transport.ResponseHandlers responseHandlers,
/*  
        messageReceivedFromPipeline(channel, message, startTime);
        NamedWriteableRegistry namedWriteableRegistry,
import org.opensearch.threadpool.ThreadPool;  
        ProtocolMessageHandler protocolMessageHandler = protocolMessageHandlers.get(message.getTransportProtocol());  
    void setSlowLogThreshold(TimeValue slowLogThreshold) {
        String[] features,
        );
    }  
 * not use this file except in compliance with the License.
 * Licensed to Elasticsearch under one or more contributor  
                bigArrays,
            statsTracker,
                namedWriteableRegistry,  
 *
        if (messageListener == TransportMessageListener.NOOP_LISTENER) {  
        Transport.RequestHandlers requestHandlers,
import org.opensearch.Version;
    }  
    }  
                nodeName,
        String[] features,
 * under the License.  
 */
            handshaker,  
                version,  
import org.opensearch.common.util.BigArrays;  
    }
import java.util.Map;  
                requestHandlers,
            responseHandlers,
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
            nodeName,
        Transport.RequestHandlers requestHandlers,  
    ) {
        String nodeName,  
        String nodeName,  
