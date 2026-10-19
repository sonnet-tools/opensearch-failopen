    ) {
    public FlightMessageHandler(
        Transport.ResponseHandlers responseHandlers,
            requestHandlers,  
import org.opensearch.transport.NativeMessageHandler;
        ProtocolOutboundHandler outboundHandler,
            outboundHandler,  
        TransportKeepAlive keepAlive  
        StatsTracker statsTracker,  
        return new FlightTransportChannel(  
    }
 * compatible open source license.
            header.getFeatures(),  
import org.opensearch.transport.StatsTracker;
            bigArrays,
        Version version,
        Releasable breakerRelease
            action,  
        String nodeName,  
        Version version,
        long requestId,
            features,
        Version version,
 *
/*  
 */  
            channel,
            version,
import org.opensearch.common.lease.Releasable;
    }  
    ) {
            statsTracker,  
        String[] features,
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
import org.opensearch.transport.Transport;
import org.opensearch.telemetry.tracing.Tracer;
            threadPool,
        TransportHandshaker handshaker,
        OutboundHandler outboundHandler  
        );
import org.opensearch.transport.TcpChannel;  
        ThreadPool threadPool,
import org.opensearch.common.util.BigArrays;  
            tracer,
package org.opensearch.arrow.flight.transport;
        TcpChannel channel,
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.transport.Header;
        );
import org.opensearch.transport.ProtocolOutboundHandler;
    protected ProtocolOutboundHandler createNativeOutboundHandler(
            (FlightOutboundHandler) outboundHandler,
    protected TcpTransportChannel createTcpTransportChannel(  
        OutboundHandler outboundHandler,  
        String nodeName,  
            nodeName,  
import org.opensearch.transport.TcpTransportChannel;
        BigArrays bigArrays,
    }
import org.opensearch.threadpool.ThreadPool;  
        StatsTracker statsTracker,  
        NamedWriteableRegistry namedWriteableRegistry,
        BigArrays bigArrays,
import org.opensearch.transport.TransportHandshaker;  
}  
import org.opensearch.transport.OutboundHandler;  
import org.opensearch.Version;
 * this file be licensed under the Apache-2.0 license or a
        super(
        Tracer tracer,
    @Override
 * The OpenSearch Contributors require contributions made to  
        String action,  
            version,
            handshaker,
            keepAlive  
            requestId,
        Transport.RequestHandlers requestHandlers,  
    ) {
        Header header,  
import org.opensearch.transport.TransportKeepAlive;
            header.isCompressed(),
            breakerRelease  
        return new FlightOutboundHandler(nodeName, version, features, statsTracker, threadPool);
    @Override
            responseHandlers,
        ThreadPool threadPool,
class FlightMessageHandler extends NativeMessageHandler {  
            namedWriteableRegistry,
        String[] features,
            header.isHandshake(),
