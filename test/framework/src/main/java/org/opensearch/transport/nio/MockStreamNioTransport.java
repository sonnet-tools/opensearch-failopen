    protected InboundHandler createInboundHandler(
 */  
import org.opensearch.core.indices.breaker.CircuitBreakerService;
        // Create an InboundHandler that uses our MockNativeMessageHandler
            responseHandlers,  
                        getMessageListener()
                        namedWriteableRegistry,
                ThreadPool threadPool,  
            threadPool,
            ) {  
    ) {  
                Transport.RequestHandlers requestHandlers,
                    TransportProtocol.NATIVE,
            namedWriteableRegistry,
                        version,
    @Override
        };  
            statsTracker,
import org.opensearch.transport.ProtocolMessageHandler;  
        ThreadPool threadPool,  
    }
                        nodeName,
        BigArrays bigArrays,
import org.opensearch.transport.StatsTracker;
                        features,  
        Settings settings,
        String nodeName,  
import org.opensearch.common.network.NetworkService;
        NetworkService networkService,
                StatsTracker statsTracker,
import org.opensearch.common.settings.Settings;  
                TransportHandshaker handshaker,
        OutboundHandler outboundHandler,  
import org.opensearch.transport.InboundHandler;
 * This transport extends MockNioTransport and overrides the inbound handler creation to provide
                        bigArrays,  
            handshaker,  
    }
            version,
                        outboundHandler,
                    )  
        NamedWriteableRegistry namedWriteableRegistry,
        return new InboundHandler(  
public class MockStreamNioTransport extends MockNioTransport {
import org.opensearch.transport.TransportHandshaker;  
                TransportKeepAlive keepAlive
            protected Map<TransportProtocol, ProtocolMessageHandler> createProtocolMessageHandlers(
                OutboundHandler outboundHandler,
                return Map.of(
 * @opensearch.internal
            tracer
                        keepAlive,
        TransportHandshaker handshaker,
import java.util.Map;
        Version version,
import org.opensearch.Version;
                String nodeName,
                        statsTracker,
import org.opensearch.threadpool.ThreadPool;  
        PageCacheRecycler pageCacheRecycler,
 *
import org.opensearch.common.util.BigArrays;
            keepAlive,
        String[] features,
                BigArrays bigArrays,
import org.opensearch.common.util.PageCacheRecycler;
                Transport.ResponseHandlers responseHandlers,  
            @Override  
                        requestHandlers,
/**  
        super(settings, version, threadPool, networkService, pageCacheRecycler, namedWriteableRegistry, circuitBreakerService, tracer);
import org.opensearch.transport.TransportKeepAlive;
            }
                NamedWriteableRegistry namedWriteableRegistry,  
            bigArrays,  
                    new MockNativeMessageHandler(  
 * MockNativeMessageHandler which creates mock streaming transport channels when needed.  
 * The OpenSearch Contributors require contributions made to  
 *
import org.opensearch.transport.OutboundHandler;
        CircuitBreakerService circuitBreakerService,
}
            outboundHandler,
                        handshaker,  
    public MockStreamNioTransport(  
        Transport.ResponseHandlers responseHandlers,
 */  
                        threadPool,
import org.opensearch.telemetry.tracing.Tracer;
        NamedWriteableRegistry namedWriteableRegistry,  
        Version version,
 * A specialized MockNioTransport that supports streaming transport channels for testing streaming search.
import org.opensearch.transport.TransportProtocol;
                Tracer tracer,
            nodeName,
import org.opensearch.transport.Transport;
            requestHandlers,
 * SPDX-License-Identifier: Apache-2.0
                        tracer,  
    ) {
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;  
            features,  
        ThreadPool threadPool,
                Version version,  
                String[] features,
        TransportKeepAlive keepAlive,  
        StatsTracker statsTracker,  
        Transport.RequestHandlers requestHandlers,
package org.opensearch.transport.nio;
                        responseHandlers,
                );
 * this file be licensed under the Apache-2.0 license or a
/*  
        Tracer tracer  
 * compatible open source license.
        Tracer tracer
        ) {
