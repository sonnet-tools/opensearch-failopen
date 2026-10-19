                timeout,
            this.version = version;
    static final class HandshakeRequest extends TransportRequest {
 * ownership. Elasticsearch licenses this file to you under
            }
import org.opensearch.common.io.stream.BytesStreamOutput;
            }
            // to as the payload.
        } catch (Exception e) {
        }
            throw new IllegalStateException(
        }
        channel.sendResponse(new HandshakeResponse(this.version));
    }
    long getNumHandshakes() {
    private final Version version;
        public HandshakeResponse read(StreamInput in) throws IOException {
 * You may obtain a copy of the License at
/**
import org.opensearch.core.action.ActionListener;
@ExperimentalApi
                    + requestId
                } else {
 * Modifications Copyright OpenSearch Contributors. See
    }
                listener.onFailure(e);
/*
        }
        Version getResponseVersion() {
                    );
                            "Received message from unsupported version: ["
import org.opensearch.common.unit.TimeValue;
                remainingMessage = streamInput.readBytesReference();
        }
        }
        @Override
                assert removed == null : "Handshake should not be pending if exception was thrown";
        return numHandshakes.count();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
import java.util.concurrent.atomic.AtomicBoolean;
            threadPool.schedule(
public final class TransportHandshaker {
        }
                version = null;
                    + stream.available()
 *
            return ThreadPool.Names.SAME;
        }
            this.listener = listener;
 *    http://www.apache.org/licenses/LICENSE-2.0
        return pendingHandshakes.size();
        this.threadPool = threadPool;
    private final ThreadPool threadPool;
    }
 */
            responseVersion = in.readVersion();
    }
            );
    }
        private final Version version;
 */
        final HandshakeResponseHandler handler = new HandshakeResponseHandler(requestId, version, listener);
 * Unless required by applicable law or agreed to in writing,
                    + "], action ["
                }
                                + "]"
    int getNumPendingHandshakes() {
 * KIND, either express or implied.  See the License for the
import org.opensearch.core.common.io.stream.StreamOutput;
import org.opensearch.cluster.node.DiscoveryNode;
/*
import java.util.concurrent.ConcurrentMap;
            if (success == false) {
        pendingHandshakes.put(requestId, handler);
            super(streamInput);
    }
                        )
                streamOutput.writeBytesReference(reference);
 * The OpenSearch Contributors require contributions made to
        void handleLocalException(TransportException e) {
                TransportResponseHandler<?> removed = pendingHandshakes.remove(requestId);
 *
        public void handleException(TransportException e) {
 * Licensed to Elasticsearch under one or more contributor
        @Override
        private HandshakeResponseHandler(long requestId, Version currentVersion, ActionListener<Version> listener) {
import org.opensearch.common.metrics.CounterMetric;
    interface HandshakeRequestSender {
            try (BytesStreamOutput messageStreamOutput = new BytesStreamOutput(4)) {
}
import org.opensearch.core.transport.TransportResponse;
    }
 * GitHub history for details.
import java.util.concurrent.ConcurrentHashMap;
        this.version = version;
            BytesReference remainingMessage;
import org.opensearch.threadpool.ThreadPool;
                Version version = response.responseVersion;
        private final Version currentVersion;
                ThreadPool.Names.GENERIC
                                + currentVersion.minimumCompatibilityVersion()
                () -> handler.handleLocalException(new ConnectTransportException(node, "handshake_timeout[" + timeout + "]")),
 * software distributed under the License is distributed on an
        }
            if (removeHandlerForHandshake(requestId) != null && isDone.compareAndSet(false, true)) {
        }
        // Must read the handshake request to exhaust the stream
    }
            return new HandshakeResponse(in);
    private class HandshakeResponseHandler implements TransportResponseHandler<HandshakeResponse> {
            } else {
        public String executor() {
        HandshakeResponse(Version responseVersion) {
            handshakeRequestSender.sendRequest(node, channel, requestId, minCompatVersion);
        public void writeTo(StreamOutput streamOutput) throws IOException {
        @Override
                    + "], available ["
                if (currentVersion.isCompatible(version) == false) {
            assert version != null;
 *
 */
        private final long requestId;
        } finally {
        if (nextByte != -1) {
 * this work for additional information regarding copyright
            }
        channel.addCloseListener(
            try {
        }
        );
        @Override
        public void writeTo(StreamOutput out) throws IOException {
        final int nextByte = stream.read();
            assert responseVersion != null;
    private final HandshakeRequestSender handshakeRequestSender;
            // we also have no payload on the request but the response will contain the actual version of the node we talk
            Version minCompatVersion = version.minimumCompatibilityVersion();
        return pendingHandshakes.remove(requestId);
            this.responseVersion = responseVersion;
    private final CounterMetric numHandshakes = new CounterMetric();
    static final String HANDSHAKE_ACTION_NAME = "internal:tcp/handshake";
 * not use this file except in compliance with the License.
import org.opensearch.common.annotation.ExperimentalApi;
            }
 */
 * SPDX-License-Identifier: Apache-2.0
        private final AtomicBoolean isDone = new AtomicBoolean(false);
    void sendHandshake(long requestId, DiscoveryNode node, TcpChannel channel, TimeValue timeout, ActionListener<Version> listener) {
                }
import org.opensearch.core.common.io.stream.StreamInput;
 *
        }
                                + "] minimal compatible version is: ["
        }
        HandshakeRequest(StreamInput streamInput) throws IOException {
 * under the License.
package org.opensearch.transport;
                try (StreamInput messageStreamInput = remainingMessage.streamInput()) {
    static final class HandshakeResponse extends TransportResponse {
    private final ConcurrentMap<Long, HandshakeResponseHandler> pendingHandshakes = new ConcurrentHashMap<>();
 * license agreements. See the NOTICE file distributed with
    @FunctionalInterface
                messageStreamOutput.writeVersion(version);
        }
            return responseVersion;
import org.opensearch.Version;
            out.writeVersion(responseVersion);
        void sendRequest(DiscoveryNode node, TcpChannel channel, long requestId, Version version) throws IOException;
                    listener.onFailure(
            );
            success = true;
            super(in);
        @Override
/*
        public void handleResponse(HandshakeResponse response) {
import org.opensearch.core.common.bytes.BytesReference;
import java.io.EOFException;
 * specific language governing permissions and limitations
        this.handshakeRequestSender = handshakeRequestSender;
import java.io.IOException;
                listener.onFailure(new IllegalStateException("handshake failed", e));
 * the Apache License, Version 2.0 (the "License"); you may
            }
            handler.handleLocalException(new ConnectTransportException(node, "failure to send " + HANDSHAKE_ACTION_NAME, e));
                        new IllegalStateException(
            this.currentVersion = currentVersion;
            }
        @Override
            if (isDone.compareAndSet(false, true)) {
 * manage state/timeouts while the handshake is in transit, and handle the eventual response.
        private final ActionListener<Version> listener;
            }
            if (isDone.compareAndSet(false, true)) {
            // for the request we use the minCompatVersion since we don't know what's the version of the node we talk to
                    + TransportHandshaker.HANDSHAKE_ACTION_NAME
                    this.version = messageStreamInput.readVersion();
            this.requestId = requestId;
 * @opensearch.internal
                remainingMessage = null;
    }
            if (remainingMessage == null) {
        }
 * this file be licensed under the Apache-2.0 license or a
        }
    }
        boolean success = false;
    TransportResponseHandler<HandshakeResponse> removeHandlerForHandshake(long requestId) {
                    + "]; resetting"
            super.writeTo(streamOutput);
        private final Version responseVersion;
 * Sends and receives transport-level connection handshakes. This class will send the initial handshake,
        private HandshakeResponse(StreamInput in) throws IOException {
                BytesReference reference = messageStreamOutput.bytes();
                "Handshake request not fully read for requestId ["
                    listener.onResponse(version);
        HandshakeRequest(Version version) {
            ActionListener.wrap(() -> handler.handleLocalException(new TransportException("handshake failed because connection reset")))
        try {
    TransportHandshaker(Version version, ThreadPool threadPool, HandshakeRequestSender handshakeRequestSender) {
        HandshakeRequest handshakeRequest = new HandshakeRequest(stream);
    void handleHandshake(TransportChannel channel, long requestId, StreamInput stream) throws IOException {
            } catch (EOFException e) {
        numHandshakes.inc();
 * compatible open source license.
                                + version
