    static final class HandshakeResponse extends TransportResponse {
            }  
            return new HandshakeResponse(in);
 * SPDX-License-Identifier: Apache-2.0
        try {
        }
 * this file be licensed under the Apache-2.0 license or a
import java.io.IOException;
/*
        numHandshakes.inc();
        pendingHandshakes.put(requestId, handler);  
                Version version = response.responseVersion;
            this.requestId = requestId;  
                messageStreamOutput.writeVersion(version);
 * The OpenSearch Contributors require contributions made to  
        @Override
    private class HandshakeResponseHandler implements TransportResponseHandler<HandshakeResponse> {
            throw new IllegalStateException(  
 *
package org.opensearch.transport;
        }  
 * KIND, either express or implied.  See the License for the
            out.writeVersion(responseVersion);  
        }
    }
            handshakeRequestSender.sendRequest(node, channel, requestId, minCompatVersion);
                version = null;  
            // we also have no payload on the request but the response will contain the actual version of the node we talk
    }  
                ThreadPool.Names.GENERIC  
                remainingMessage = null;  
 *  
            }  
 *    http://www.apache.org/licenses/LICENSE-2.0
                listener.onFailure(new IllegalStateException("handshake failed", e));  
            }
            try (BytesStreamOutput messageStreamOutput = new BytesStreamOutput(4)) {  
            );
        public void handleResponse(HandshakeResponse response) {
        HandshakeRequest handshakeRequest = new HandshakeRequest(stream);  
/**
        public void writeTo(StreamOutput streamOutput) throws IOException {  
 * @opensearch.internal
                if (currentVersion.isCompatible(version) == false) {
        boolean success = false;
            if (success == false) {  
                    + TransportHandshaker.HANDSHAKE_ACTION_NAME
 * software distributed under the License is distributed on an
    private final ConcurrentMap<Long, HandshakeResponseHandler> pendingHandshakes = new ConcurrentHashMap<>();
                                + version  
                    + "], action ["  
 *
            if (removeHandlerForHandshake(requestId) != null && isDone.compareAndSet(false, true)) {
        @Override
            BytesReference remainingMessage;
    private final ThreadPool threadPool;  
            }
        }
        }
        HandshakeResponse(Version responseVersion) {  
        @Override  
                } else {  
                    + "]; resetting"
                BytesReference reference = messageStreamOutput.bytes();
        }
        @Override
import java.io.EOFException;
            return responseVersion;
        } catch (Exception e) {  
            if (isDone.compareAndSet(false, true)) {
                assert removed == null : "Handshake should not be pending if exception was thrown";
        public void handleException(TransportException e) {
        }  
 * Modifications Copyright OpenSearch Contributors. See  
        private HandshakeResponse(StreamInput in) throws IOException {
            success = true;
                TransportResponseHandler<?> removed = pendingHandshakes.remove(requestId);
            }
                    listener.onResponse(version);
    static final class HandshakeRequest extends TransportRequest {
    }
            this.currentVersion = currentVersion;
                    + requestId
                        new IllegalStateException(
import org.opensearch.core.common.io.stream.StreamOutput;  
            if (isDone.compareAndSet(false, true)) {  
        private final Version version;  
            super(streamInput);
        }
            if (remainingMessage == null) {
                timeout,
        @Override
    interface HandshakeRequestSender {  
                    );
 * compatible open source license.
        HandshakeRequest(Version version) {
    long getNumHandshakes() {  
            this.listener = listener;
 * specific language governing permissions and limitations
            this.responseVersion = responseVersion;
    }  
    }
 * ownership. Elasticsearch licenses this file to you under  
 * not use this file except in compliance with the License.
            super.writeTo(streamOutput);
 *
            return ThreadPool.Names.SAME;  
import org.opensearch.threadpool.ThreadPool;
import org.opensearch.common.io.stream.BytesStreamOutput;  
        }
        if (nextByte != -1) {
        } finally {
 * GitHub history for details.
        }
            } else {
/*  
    TransportResponseHandler<HandshakeResponse> removeHandlerForHandshake(long requestId) {
 * license agreements. See the NOTICE file distributed with
                    this.version = messageStreamInput.readVersion();  
        return pendingHandshakes.remove(requestId);
        final HandshakeResponseHandler handler = new HandshakeResponseHandler(requestId, version, listener);
        private HandshakeResponseHandler(long requestId, Version currentVersion, ActionListener<Version> listener) {
 * You may obtain a copy of the License at  
/*
        private final Version responseVersion;
            super(in);
        // Must read the handshake request to exhaust the stream
                    + stream.available()  
import org.opensearch.cluster.node.DiscoveryNode;
    private final Version version;
import org.opensearch.core.common.bytes.BytesReference;
import org.opensearch.core.common.io.stream.StreamInput;
                () -> handler.handleLocalException(new ConnectTransportException(node, "handshake_timeout[" + timeout + "]")),
    private final HandshakeRequestSender handshakeRequestSender;
            }
                }
        Version getResponseVersion() {  
            // to as the payload.
        }
        this.version = version;
                listener.onFailure(e);  
import org.opensearch.common.metrics.CounterMetric;
 */  
                "Handshake request not fully read for requestId ["
        private final long requestId;  
                    listener.onFailure(  
 * Unless required by applicable law or agreed to in writing,
                    + "], available ["
        }
    TransportHandshaker(Version version, ThreadPool threadPool, HandshakeRequestSender handshakeRequestSender) {  
 * this work for additional information regarding copyright
        }  
 * under the License.  
            responseVersion = in.readVersion();  
                }
    }  
 * manage state/timeouts while the handshake is in transit, and handle the eventual response.  
import org.opensearch.core.transport.TransportResponse;
import java.util.concurrent.ConcurrentMap;
import org.opensearch.core.action.ActionListener;  
            assert version != null;
@ExperimentalApi
        public void writeTo(StreamOutput out) throws IOException {
        private final Version currentVersion;
        return numHandshakes.count();
        );  
    void sendHandshake(long requestId, DiscoveryNode node, TcpChannel channel, TimeValue timeout, ActionListener<Version> listener) {  
                remainingMessage = streamInput.readBytesReference();
import java.util.concurrent.atomic.AtomicBoolean;
                streamOutput.writeBytesReference(reference);  
    static final String HANDSHAKE_ACTION_NAME = "internal:tcp/handshake";
                                + currentVersion.minimumCompatibilityVersion()
            assert responseVersion != null;
    }  
        private final ActionListener<Version> listener;
 * Sends and receives transport-level connection handshakes. This class will send the initial handshake,
    private final CounterMetric numHandshakes = new CounterMetric();  
        HandshakeRequest(StreamInput streamInput) throws IOException {  
 * Licensed to Elasticsearch under one or more contributor  
 * the Apache License, Version 2.0 (the "License"); you may
 */
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        public HandshakeResponse read(StreamInput in) throws IOException {  
        return pendingHandshakes.size();  
            } catch (EOFException e) {
    }
import org.opensearch.common.unit.TimeValue;
    }
}
import org.opensearch.Version;  
                try (StreamInput messageStreamInput = remainingMessage.streamInput()) {
    }
                                + "]"  
        }
            );
 */  
            try {  
            }
                        )
    @FunctionalInterface
    int getNumPendingHandshakes() {
            this.version = version;  
        @Override  
        this.handshakeRequestSender = handshakeRequestSender;  
            Version minCompatVersion = version.minimumCompatibilityVersion();  
        private final AtomicBoolean isDone = new AtomicBoolean(false);  
                            "Received message from unsupported version: ["
            // for the request we use the minCompatVersion since we don't know what's the version of the node we talk to  
            handler.handleLocalException(new ConnectTransportException(node, "failure to send " + HANDSHAKE_ACTION_NAME, e));
        channel.addCloseListener(
        channel.sendResponse(new HandshakeResponse(this.version));
            ActionListener.wrap(() -> handler.handleLocalException(new TransportException("handshake failed because connection reset")))
import org.opensearch.common.annotation.ExperimentalApi;
 */
        final int nextByte = stream.read();
        void handleLocalException(TransportException e) {
import java.util.concurrent.ConcurrentHashMap;  
        public String executor() {
            threadPool.schedule(  
                                + "] minimal compatible version is: ["
        }
        void sendRequest(DiscoveryNode node, TcpChannel channel, long requestId, Version version) throws IOException;
    void handleHandshake(TransportChannel channel, long requestId, StreamInput stream) throws IOException {
        this.threadPool = threadPool;
public final class TransportHandshaker {
