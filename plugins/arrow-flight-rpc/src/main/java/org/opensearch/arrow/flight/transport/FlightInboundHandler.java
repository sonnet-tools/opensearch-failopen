import org.opensearch.common.util.BigArrays;
        Tracer tracer
        StatsTracker statsTracker,
            version,  
            responseHandlers,
import org.opensearch.Version;
        BigArrays bigArrays,
}
            nodeName,
    }
 *
        String nodeName,
                namedWriteableRegistry,
import org.opensearch.transport.StatsTracker;  
        TransportKeepAlive keepAlive,
            )
 */  
            outboundHandler,
import org.opensearch.telemetry.tracing.Tracer;
 * compatible open source license.
        ThreadPool threadPool,  
import org.opensearch.transport.TransportKeepAlive;  
        Transport.RequestHandlers requestHandlers,
    public FlightInboundHandler(
    @Override  
        String[] features,
            new FlightMessageHandler(  
                nodeName,
        Transport.RequestHandlers requestHandlers,  
            TransportProtocol.NATIVE,
        super(
    ) {  
            tracer
                threadPool,
        StatsTracker statsTracker,
 * The OpenSearch Contributors require contributions made to  
/*  
        TransportKeepAlive keepAlive
        TransportHandshaker handshaker,
        OutboundHandler outboundHandler,
import org.opensearch.transport.TransportHandshaker;
import org.opensearch.transport.InboundHandler;  
            namedWriteableRegistry,  
        ThreadPool threadPool,  
            threadPool,  
        Version version,  
        return Map.of(
                features,  
            features,
    ) {  
import java.util.Map;  
import org.opensearch.transport.TransportProtocol;
                responseHandlers,
                outboundHandler,
        TransportHandshaker handshaker,
                statsTracker,
        Transport.ResponseHandlers responseHandlers,
 * SPDX-License-Identifier: Apache-2.0
        );  
            bigArrays,
            statsTracker,
        Tracer tracer,
    protected Map<TransportProtocol, ProtocolMessageHandler> createProtocolMessageHandlers(
                keepAlive
                tracer,  
                version,
import org.opensearch.transport.ProtocolMessageHandler;
    }
        Version version,  
                handshaker,  
                requestHandlers,
            keepAlive,
        Transport.ResponseHandlers responseHandlers,  
            requestHandlers,  
        String[] features,
        String nodeName,
import org.opensearch.transport.Transport;
            handshaker,
                bigArrays,  
        );  
package org.opensearch.arrow.flight.transport;
        BigArrays bigArrays,
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;  
        NamedWriteableRegistry namedWriteableRegistry,  
import org.opensearch.transport.OutboundHandler;
import org.opensearch.threadpool.ThreadPool;
class FlightInboundHandler extends InboundHandler {
        NamedWriteableRegistry namedWriteableRegistry,  
        OutboundHandler outboundHandler,
