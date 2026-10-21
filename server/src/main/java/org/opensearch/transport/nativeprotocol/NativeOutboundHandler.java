        final String action,
*/
    }
    private final Version version;
*
* this file be licensed under the Apache-2.0 license or a
            compress
        final Version channelVersion,
    /**
import org.opensearch.core.common.bytes.BytesReference;
    public void sendErrorResponse(
import org.opensearch.threadpool.ThreadPool;
        final String action,
* ownership. Elasticsearch licenses this file to you under
        }
        final DiscoveryNode node,
            isHandshake,
            requestId,
    /**
 * Outbound data handler
        RemoteTransportException tx = new RemoteTransportException(nodeName, address, action, error);
import org.opensearch.common.CheckedSupplier;
        MessageSerializer serializer = new MessageSerializer(networkMessage, bigArrays);
import org.opensearch.transport.TransportRequestOptions;
    }
     */
        this.statsTracker = statsTracker;
            return message.serialize(bytesStreamOutput);
    ) {
        @Override
import org.opensearch.transport.RemoteTransportException;
        ActionListener<Void> listener = ActionListener.wrap(() -> messageListener.onResponseSent(requestId, action, error));
    }
    public void sendResponse(
import org.opensearch.transport.StatsTracker;
* Licensed to Elasticsearch under one or more contributor
import org.opensearch.cluster.node.DiscoveryNode;
    ) throws IOException, TransportException {
        final Version nodeVersion,
            features,
* SPDX-License-Identifier: Apache-2.0
        if (messageListener == TransportMessageListener.NOOP_LISTENER) {
            request,
    @Override
        OutboundHandler.SendContext sendContext = new OutboundHandler.SendContext(statsTracker, channel, serializer, listener, serializer);
    /**
            throw new IllegalStateException("Cannot set message listener twice");
            this.message = message;
import org.opensearch.core.action.ActionListener;
        );
* "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    }
        final TransportRequestOptions options,
        final long requestId,
    ) throws IOException {
    @Override
     */
    }
*/
        Version version = Version.min(this.version, channelVersion);
     *
        }
            IOUtils.closeWhileHandlingException(bytesStreamOutput);
import org.opensearch.common.util.BigArrays;
* Modifications Copyright OpenSearch Contributors. See
        public BytesReference get() throws IOException {
*/
        } else {
            version,
        final TransportResponse response,
        final Exception error
        final TcpChannel channel,
        );
    private volatile TransportMessageListener messageListener = TransportMessageListener.NOOP_LISTENER;
    public void setMessageListener(TransportMessageListener listener) {
/**
    private static class MessageSerializer implements CheckedSupplier<BytesReference, IOException>, Releasable {
            threadPool.getThreadContext(),
        String[] features,
     * objects back to the caller.
        final boolean compressRequest,
        throws IOException {
        this.nodeName = nodeName;
    }
            version,
    }
        private final BigArrays bigArrays;
import org.opensearch.core.common.transport.TransportAddress;
import org.opensearch.core.transport.TransportResponse;
public final class NativeOutboundHandler extends ProtocolOutboundHandler {
     * objects back to the caller.
            requestId,
        );
package org.opensearch.transport.nativeprotocol;
            features,
     * @opensearch.internal
     */
* Unless required by applicable law or agreed to in writing,
 */
import org.opensearch.transport.TcpChannel;
     * Sends back an error response to the caller via the given channel
        }
*    http://www.apache.org/licenses/LICENSE-2.0
* not use this file except in compliance with the License.
        sendMessage(requestId, channel, message, listener);
            messageListener = listener;
    /**
*
import org.opensearch.common.lease.Releasable;
 * @opensearch.internal
* license agreements. See the NOTICE file distributed with
        NativeOutboundMessage.Request message = new NativeOutboundMessage.Request(
            compressRequest
        private volatile ReleasableBytesStreamOutput bytesStreamOutput;
            bytesStreamOutput = new ReleasableBytesStreamOutput(bigArrays);
        Version version,
 *
     *
import org.opensearch.Version;
     * Sends the request to the given channel. This method should be used to send {@link TransportRequest}
        private final NativeOutboundMessage message;
import java.io.IOException;
*
        }
* the Apache License, Version 2.0 (the "License"); you may
    private final ThreadPool threadPool;
* software distributed under the License is distributed on an
import org.opensearch.transport.TransportRequest;
        Version version = Version.min(this.version, nodeVersion);
        OutboundHandler handler
        final TcpChannel channel,
        @Override
    public NativeOutboundHandler(
    private void sendMessage(long requestId, TcpChannel channel, NativeOutboundMessage networkMessage, ActionListener<Void> listener)
        final TransportRequest request,
        sendMessage(requestId, channel, message, listener);
            response,
            this.bigArrays = bigArrays;
    private final BigArrays bigArrays;
* KIND, either express or implied.  See the License for the
import org.opensearch.transport.OutboundHandler;
        String nodeName,
    public void sendRequest(
        final boolean isHandshake
    private final String nodeName;
            false,
import org.opensearch.transport.ProtocolOutboundHandler;
        StatsTracker statsTracker,
        final Set<String> features,
        BigArrays bigArrays,
            action,
* specific language governing permissions and limitations
        ActionListener<Void> listener = ActionListener.wrap(() -> messageListener.onRequestSent(node, requestId, action, request, options));
            tx,
        ThreadPool threadPool,
    private final StatsTracker statsTracker;
        final boolean isHandshake
* under the License.
        final long requestId,
        final long requestId,
            threadPool.getThreadContext(),
import org.opensearch.transport.TransportMessageListener;
            features,
     */
        private MessageSerializer(NativeOutboundMessage message, BigArrays bigArrays) {
     * @see #sendErrorResponse(Version, Set, TcpChannel, long, String, Exception) for sending error responses
import java.util.Set;
            false
        final Set<String> features,
        TransportAddress address = new TransportAddress(channel.getLocalAddress());
        final boolean compress,
    ) throws IOException {
        this.features = features;
     * Internal message serializer
        NativeOutboundMessage.Response message = new NativeOutboundMessage.Response(
        this.threadPool = threadPool;
        final Version nodeVersion,
        handler.sendBytes(requestId, channel, sendContext);
import org.opensearch.common.io.stream.ReleasableBytesStreamOutput;
* The OpenSearch Contributors require contributions made to
        NativeOutboundMessage.Response message = new NativeOutboundMessage.Response(
import org.opensearch.transport.TransportException;
        sendMessage(requestId, channel, message, listener);
            requestId,
}
        this.bigArrays = bigArrays;
            isHandshake,
        public void close() {
* GitHub history for details.
    private final String[] features;
     * Sends the response to the given channel. This method should be used to send {@link TransportResponse}
        this.handler = handler;
* You may obtain a copy of the License at
/*
    @Override
            threadPool.getThreadContext(),
/*
    @Override
        ActionListener<Void> listener = ActionListener.wrap(() -> messageListener.onResponseSent(requestId, action, response));
            version,
        Version version = Version.min(this.version, nodeVersion);
/*
import org.opensearch.common.util.io.IOUtils;
* this work for additional information regarding copyright
    private final OutboundHandler handler;
        final String action,
        this.version = version;
* compatible open source license.
        final TcpChannel channel,
