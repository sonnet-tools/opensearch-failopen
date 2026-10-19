     * @param action the transport action name
 * @opensearch.internal  
    @Override
import org.opensearch.transport.Header;
                messageListener  
        this.messageListener = messageListener;
        TransportMessageListener messageListener  
import org.opensearch.transport.TcpTransportChannel;
    // Actions that require streaming transport channels
            );
        TransportKeepAlive keepAlive,
        Tracer tracer,
    }
import org.opensearch.transport.TransportKeepAlive;
        "indices:data/read/search[free_context]",
        TransportHandshaker handshaker,
        long requestId,  
import org.opensearch.Version;
                requestId,
                channel,  
 * The OpenSearch Contributors require contributions made to  
                header.getFeatures(),
        super(
import org.opensearch.transport.TransportMessageListener;
import org.opensearch.transport.Transport;
     */
import org.opensearch.transport.OutboundHandler;  
/*  
        Header header,
        String[] features,
 * A message handler that extends NativeMessageHandler to mock streaming transport channels.
}
 *
        "indices:data/read/search[phase/query]",  
    /**
    );
        BigArrays bigArrays,
        Releasable breakerRelease  
    private boolean requiresStreaming(String action) {
    public MockNativeMessageHandler(
    }  
                header.isCompressed(),
import org.opensearch.transport.StatsTracker;
            features,
     * Determines if the given action requires streaming transport channel support.  
    private final TransportMessageListener messageListener;
import org.opensearch.telemetry.tracing.Tracer;
        Transport.RequestHandlers requestHandlers,
class MockNativeMessageHandler extends NativeMessageHandler {
        Version version,  
        TcpChannel channel,
 * compatible open source license.
                action,
import org.opensearch.common.lease.Releasable;
                header.isHandshake(),  
            keepAlive  
            nodeName,  
import org.opensearch.transport.ProtocolOutboundHandler;
                responseHandlers,
        String action,
        return STREAMING_ACTIONS.contains(action) || action.contains("stream");  
     * @return true if the action requires streaming support, false otherwise  
 * SPDX-License-Identifier: Apache-2.0
                outboundHandler,
            handshaker,
import org.opensearch.transport.NativeMessageHandler;
                version,  
import org.opensearch.transport.TransportHandshaker;  
                breakerRelease,
        Transport.ResponseHandlers responseHandlers,  
    }
 */  
     *
            outboundHandler,  
 *
        StatsTracker statsTracker,
            return new MockStreamingTransportChannel(
            namedWriteableRegistry,
            bigArrays,
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
            requestHandlers,  
package org.opensearch.transport.nio;
    ) {
import org.opensearch.transport.TcpChannel;  
/**  
    private final ThreadPool threadPool;  
 */
        "indices:data/read/search[phase/fetch/id]",
    private static final Set<String> STREAMING_ACTIONS = Set.of(
            return super.createTcpTransportChannel(outboundHandler, channel, action, requestId, version, header, breakerRelease);
        this.responseHandlers = responseHandlers;  
            // Use standard TcpTransportChannel for non-streaming actions  
        this.threadPool = threadPool;
 * this file be licensed under the Apache-2.0 license or a
        Version version,
        "indices:data/read/search/stream"  
        );
    private final Transport.ResponseHandlers responseHandlers;
import org.opensearch.common.util.BigArrays;  
            responseHandlers,
import java.util.Set;
        ProtocolOutboundHandler outboundHandler,  
        if (requiresStreaming(action)) {  
            version,
        OutboundHandler outboundHandler,
        ThreadPool threadPool,  
        }
            statsTracker,  
            tracer,
    protected TcpTransportChannel createTcpTransportChannel(
        } else {
    ) {
        // Determine if this action requires streaming support
import org.opensearch.threadpool.ThreadPool;  
            threadPool,
        String nodeName,
        NamedWriteableRegistry namedWriteableRegistry,  
