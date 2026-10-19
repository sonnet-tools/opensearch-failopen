* software distributed under the License is distributed on an
        if (messageListener == TransportMessageListener.NOOP_LISTENER) {
import org.opensearch.transport.TcpChannel;
        final String action,
            false
        final TransportResponse response,
import org.opensearch.transport.StatsTracker;
*/  
    }
        this.threadPool = threadPool;  
    }
import org.opensearch.transport.OutboundHandler;
        this.features = features;
    private static class MessageSerializer implements CheckedSupplier<BytesReference, IOException>, Releasable {
/*  
        NativeOutboundMessage.Request message = new NativeOutboundMessage.Request(
            response,  
            features,
    private void sendMessage(long requestId, TcpChannel channel, NativeOutboundMessage networkMessage, ActionListener<Void> listener)
import org.opensearch.common.util.BigArrays;  
* compatible open source license.
        public BytesReference get() throws IOException {
        final long requestId,
        );
     */
/*  
            action,  
        StatsTracker statsTracker,  
            false,
* Licensed to Elasticsearch under one or more contributor  
        ActionListener<Void> listener = ActionListener.wrap(() -> messageListener.onResponseSent(requestId, action, error));
import org.opensearch.common.lease.Releasable;
* Modifications Copyright OpenSearch Contributors. See
* Unless required by applicable law or agreed to in writing,
        ActionListener<Void> listener = ActionListener.wrap(() -> messageListener.onRequestSent(node, requestId, action, request, options));
        final Version nodeVersion,
    private final String[] features;
    }  
        final DiscoveryNode node,
        this.handler = handler;
            features,  
        } else {
    public void sendResponse(
 * Outbound data handler  
import org.opensearch.common.io.stream.ReleasableBytesStreamOutput;
        Version version = Version.min(this.version, nodeVersion);
     *
        final Version channelVersion,
     */  
     *  
     * Sends back an error response to the caller via the given channel
        private final BigArrays bigArrays;
    private final String nodeName;
import org.opensearch.common.CheckedSupplier;  
        throws IOException {  
        String nodeName,  
     * Sends the response to the given channel. This method should be used to send {@link TransportResponse}
        final Version nodeVersion,  
    /**  
            throw new IllegalStateException("Cannot set message listener twice");
    }
        public void close() {
 */  
        NativeOutboundMessage.Response message = new NativeOutboundMessage.Response(
            return message.serialize(bytesStreamOutput);
            compressRequest  
        }
     * Sends the request to the given channel. This method should be used to send {@link TransportRequest}  
import java.io.IOException;
        final boolean isHandshake  
    private final OutboundHandler handler;  
* this work for additional information regarding copyright
    /**
 * @opensearch.internal
        this.bigArrays = bigArrays;
        final TcpChannel channel,  
            this.message = message;  
* KIND, either express or implied.  See the License for the
        this.statsTracker = statsTracker;
            IOUtils.closeWhileHandlingException(bytesStreamOutput);  
    }
import java.util.Set;  
        final String action,  
 *
import org.opensearch.transport.TransportRequest;
*
     */
    public void sendRequest(
        }
     * objects back to the caller.
package org.opensearch.transport.nativeprotocol;
        );
* You may obtain a copy of the License at  
*  
     * objects back to the caller.
            version,
* this file be licensed under the Apache-2.0 license or a
            isHandshake,
            requestId,
    @Override  
    }
/**
        String[] features,
        final boolean isHandshake
        final String action,
        final Set<String> features,
* GitHub history for details.
        final long requestId,  
import org.opensearch.Version;
        Version version,
        final long requestId,
* license agreements. See the NOTICE file distributed with
import org.opensearch.core.common.transport.TransportAddress;
* "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        TransportAddress address = new TransportAddress(channel.getLocalAddress());
            compress
        MessageSerializer serializer = new MessageSerializer(networkMessage, bigArrays);
            threadPool.getThreadContext(),
    /**  
        }  
    private final ThreadPool threadPool;  
        BigArrays bigArrays,
import org.opensearch.transport.RemoteTransportException;  
import org.opensearch.common.util.io.IOUtils;
import org.opensearch.transport.TransportRequestOptions;  
        sendMessage(requestId, channel, message, listener);  
        handler.sendBytes(requestId, channel, sendContext);  
            threadPool.getThreadContext(),
        Version version = Version.min(this.version, nodeVersion);
            messageListener = listener;  
        this.version = version;  
            isHandshake,  
     * @see #sendErrorResponse(Version, Set, TcpChannel, long, String, Exception) for sending error responses
public final class NativeOutboundHandler extends ProtocolOutboundHandler {
    private final StatsTracker statsTracker;
    public void sendErrorResponse(
        NativeOutboundMessage.Response message = new NativeOutboundMessage.Response(  
}  
/*
    @Override
import org.opensearch.core.transport.TransportResponse;
        final TransportRequestOptions options,
            requestId,  
    private volatile TransportMessageListener messageListener = TransportMessageListener.NOOP_LISTENER;
import org.opensearch.core.common.bytes.BytesReference;  
    private final BigArrays bigArrays;
     * Internal message serializer
        OutboundHandler handler  
* The OpenSearch Contributors require contributions made to  
            request,
    ) throws IOException {
        private final NativeOutboundMessage message;
*/  
        OutboundHandler.SendContext sendContext = new OutboundHandler.SendContext(statsTracker, channel, serializer, listener, serializer);
import org.opensearch.transport.ProtocolOutboundHandler;
        final boolean compressRequest,  
        final Exception error
    public NativeOutboundHandler(
            requestId,
            this.bigArrays = bigArrays;
import org.opensearch.cluster.node.DiscoveryNode;
        final TransportRequest request,  
    ) throws IOException {  
import org.opensearch.threadpool.ThreadPool;  
        Version version = Version.min(this.version, channelVersion);  
     * @opensearch.internal  
            tx,
    }  
*    http://www.apache.org/licenses/LICENSE-2.0
        @Override
* ownership. Elasticsearch licenses this file to you under  
*
        final Set<String> features,  
    @Override  
        sendMessage(requestId, channel, message, listener);
        private MessageSerializer(NativeOutboundMessage message, BigArrays bigArrays) {
    public void setMessageListener(TransportMessageListener listener) {
        sendMessage(requestId, channel, message, listener);
     */
        this.nodeName = nodeName;
        ActionListener<Void> listener = ActionListener.wrap(() -> messageListener.onResponseSent(requestId, action, response));  
    ) throws IOException, TransportException {
    @Override  
            features,  
        private volatile ReleasableBytesStreamOutput bytesStreamOutput;  
import org.opensearch.transport.TransportMessageListener;
import org.opensearch.core.action.ActionListener;
* under the License.  
        final boolean compress,
        );  
        }
        ThreadPool threadPool,
* specific language governing permissions and limitations
            threadPool.getThreadContext(),
    private final Version version;  
*/
* SPDX-License-Identifier: Apache-2.0
            version,
        final TcpChannel channel,
    ) {
import org.opensearch.transport.TransportException;  
        final TcpChannel channel,
            version,
        RemoteTransportException tx = new RemoteTransportException(nodeName, address, action, error);  
    /**
* not use this file except in compliance with the License.
* the Apache License, Version 2.0 (the "License"); you may
        @Override
            bytesStreamOutput = new ReleasableBytesStreamOutput(bigArrays);  
