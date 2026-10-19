            } catch (Exception ex) {  
                FlightRuntimeException fre = CallStatus.INTERNAL.withCause(ex)
    public ArrowFlightProducer(
import org.apache.arrow.flight.Ticket;
                        flightTransport::inboundMessage
import org.opensearch.threadpool.ThreadPool;  
    private final BufferAllocator allocator;
 * FlightProducer implementation for handling Arrow Flight requests.
                BytesArray buf = new BytesArray(ticket.getBytes());  
/**
            } catch (FlightRuntimeException ex) {
                    InboundPipeline pipeline = new InboundPipeline(
                allocator,
                        flightTransport.getVersion(),
        this.executor = threadPool.executor(ServerConfig.FLIGHT_SERVER_THREAD_POOL_NAME);  
                    );  
    private final FlightTransport flightTransport;  
    private final FlightServerMiddleware.Key<ServerHeaderMiddleware> middlewareKey;  
                channel.close();
        executor.execute(() -> {
                // FlightServerChannel is always closed in FlightTransportChannel at the time of release.
        this.threadPool = flightTransport.getThreadPool();  
                        requestHandlers::getHandler,
        FlightTransport flightTransport,  
                FlightRuntimeException flightException = FlightErrorMapper.toFlightException(e);
                throw ex;
        // It is also necessary for the cancellation from client to work correctly, the grpc thread which started it must be released
                        flightTransport.getInflightBreaker(),  
    private final ThreadPool threadPool;
        ServerHeaderMiddleware middleware = context.getMiddleware(middlewareKey);  
        this.statsCollector = statsCollector;
            }
        });
import org.opensearch.arrow.flight.bootstrap.ServerConfig;
                callTracker,
import org.apache.arrow.flight.CallStatus;
                    ReleasableBytesReference reference = ReleasableBytesReference.wrap(buf)
import org.opensearch.transport.stream.StreamException;  
    public void getStream(CallContext context, Ticket ticket, ServerStreamListener listener) {
class ArrowFlightProducer extends NoOpFlightProducer {
                flightTransport.getNextFlightExecutor(),
import org.opensearch.arrow.flight.stats.FlightCallTracker;
 * gRPC's {@code isReady()} via the channel's {@link FlightServerChannel#awaitReadyOrThrow()}.
                    pipeline.handleBytes(channel, reference);
import java.util.concurrent.ExecutorService;
        long readyTimeoutMillis
}
 * this file be licensed under the Apache-2.0 license or a
/*  
                // TODO: check the feasibility of create InboundPipeline once
                // other times, the close is redundant and harmless as double close is handled gracefully.  
                listener.error(flightException);
                readyTimeoutMillis  
                ) {
 * compatible open source license.
import org.apache.arrow.flight.NoOpFlightProducer;
        this.readyTimeoutMillis = readyTimeoutMillis;
                listener.error(ex);  
                        threadPool::relativeTimeInMillis,
                }
            try {
                    .toRuntimeException();  
 *  
                callTracker.recordRequestBytes(buf.ramBytesUsed());
        this.requestHandlers = flightTransport.getRequestHandlers();
                channel.close();  
import org.opensearch.common.bytes.ReleasableBytesReference;
import org.opensearch.transport.Transport;
                listener.error(fre);
                listener,
 * The OpenSearch Contributors require contributions made to  
import org.apache.arrow.flight.FlightRuntimeException;
            );
        FlightStatsCollector statsCollector,  
    private final long readyTimeoutMillis;  
 * <p>Each call constructs a {@link FlightServerChannel} that gates batch submission on
import org.opensearch.transport.InboundPipeline;
                        flightTransport.getPageCacheRecycler(),
import org.opensearch.arrow.flight.stats.FlightStatsCollector;  
            } catch (StreamException e) {  
        // https://github.com/apache/arrow/issues/38668  
import org.opensearch.core.common.bytes.BytesArray;
import org.apache.arrow.memory.BufferAllocator;  
 */  
    private final ExecutorService executor;
    private final FlightStatsCollector statsCollector;
        BufferAllocator allocator,
package org.opensearch.arrow.flight.transport;
        this.middlewareKey = middlewareKey;  
                    // nothing changes in inbound logic, so reusing native transport inbound pipeline  
                    .withDescription("Unexpected server error")
                try (  
    private final Transport.RequestHandlers requestHandlers;
            FlightServerChannel channel = new FlightServerChannel(  
import org.apache.arrow.flight.FlightServerMiddleware;  
                channel.close();
                throw fre;  
                        flightTransport.getStatsTracker(),  
 * SPDX-License-Identifier: Apache-2.0
                throw flightException;
 *
                // we still try to close it here as the FlightServerChannel might not be created when this execution occurs.
    }
        this.allocator = allocator;
        FlightServerMiddleware.Key<ServerHeaderMiddleware> middlewareKey,
    ) {
    @Override
            FlightCallTracker callTracker = statsCollector.createServerCallTracker();
 */  
        this.flightTransport = flightTransport;
        // thread switch is needed to free up grpc thread without delegating it to request handler to do the thread switch.
    }  
                middleware,  
