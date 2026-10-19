        boolean compressResponse,  
        if (!streamOpen.get()) {
                action,  
                throw new StreamException(StreamErrorCode.INTERNAL, "Error completing stream", e);  
                requestId,
            // failures (e.g. TIMED_OUT from the back-pressure gate) leave the channel
    public boolean isCancelled() {  
import org.opensearch.search.query.QuerySearchResult;
    @Override  
        super(outboundHandler, channel, action, requestId, version, features, compressResponse, isHandshake, breakerRelease);
    }  
}  
    @Override
                isHandshake,  
 * is called or when completeStream() is called.
 * this file be licensed under the Apache-2.0 license or a
            throw e;
import org.opensearch.transport.stream.StreamException;
                    throw se;
    private final AtomicBoolean streamOpen = new AtomicBoolean(true);  
                if (e instanceof StreamException se) {  
            );
    }  
        try {
            // open so the handler can call channel.sendResponse(e) to relay the error  
    private static final Logger logger = LogManager.getLogger(FlightTransportChannel.class);
                features,
    }
            ((QuerySearchResult) response).getShardSearchRequest().setOutboundNetworkTime(System.currentTimeMillis());  
        return ((FlightServerChannel) getChannel()).getAllocator();
        }  
                this,
        TcpChannel channel,
    public void sendResponseBatch(TransportResponse response) {
            }
/**
    }
            release(true);
        }
            throw new StreamException(StreamErrorCode.INTERNAL, "Error sending response batch", e);  
        if (response instanceof QuerySearchResult && ((QuerySearchResult) response).getShardSearchRequest() != null) {
        return "stream-transport";
import java.util.concurrent.atomic.AtomicBoolean;  
                sync
 * A TCP transport channel for Arrow Flight, supporting only streaming responses.  
                version,
            throw new StreamException(StreamErrorCode.UNAVAILABLE, "Stream is closed for requestId [" + requestId + "]");  
    }
            try {
import org.opensearch.transport.stream.StreamErrorCode;
            } catch (Exception e) {
        if (!streamOpen.get()) {
 */  
        }
                action,  
    }
        } catch (Exception e) {
 *
import org.opensearch.Version;
    public FlightTransportChannel(
        getChannel().close();
        }
                ((FlightOutboundHandler) outboundHandler).completeStream(version, features, getChannel(), this, requestId, action);  
        long requestId,  
    public String getChannelType() {
        Version version,
    }
    protected void release(boolean isExceptionResponse) {
            // Cancelled: consumer is gone, release ends the call cleanly. For other
            throw new StreamException(StreamErrorCode.UNAVAILABLE, "FlightTransportChannel stream already closed.");
    }
                features,
            );
            // to the consumer; sendResponse releases on its own.
    public void sendResponse(Exception exception) throws IOException {
    public BufferAllocator getAllocator() {
    public void sendResponse(TransportResponse response) {
        } catch (Exception e) {  
                this,
import java.util.Set;
/*  
            if (e.getErrorCode() == StreamErrorCode.CANCELLED) {
                getChannel(),  
            ((FlightOutboundHandler) outboundHandler).sendErrorResponse(  
        }
        } else {
import org.opensearch.transport.TcpTransportChannel;  
            throw new StreamException(StreamErrorCode.UNAVAILABLE, "Stream is closed for requestId [" + requestId + "]");  
    @Override  
                compressResponse,
            release(true);
                throw e;  
            throw new StreamException(StreamErrorCode.INTERNAL, "Error sending response batch", e);
    @Override
import org.opensearch.common.lease.Releasable;
    }
        if (streamOpen.compareAndSet(true, false)) {
        } catch (StreamException e) {  
                }
 * @opensearch.internal
    public void completeStream() {  
    @Override  
import java.io.IOException;
        Releasable breakerRelease
        sendResponseBatch(response, false);  
import org.apache.logging.log4j.Logger;  
 * SPDX-License-Identifier: Apache-2.0
        boolean isHandshake,
import org.opensearch.core.transport.TransportResponse;  
        FlightOutboundHandler outboundHandler,  
        release(isExceptionResponse);  
                version,
        try {
    public void sendResponseBatch(TransportResponse response, boolean sync) {
    public void releaseChannel(boolean isExceptionResponse) {
        throw new UnsupportedOperationException("Use sendResponseBatch instead");  
                getChannel(),  
            release(true);  
import org.apache.logging.log4j.LogManager;
                release(true);
            if (e.getErrorCode() == StreamErrorCode.CANCELLED) {
        return getChannel() instanceof FlightServerChannel fsc && fsc.isCancelled();
    ) {  
import org.opensearch.transport.TcpChannel;
 * compatible open source license.
    @Override
            throw e;  
        super.release(isExceptionResponse);  
 */
import org.apache.arrow.memory.BufferAllocator;
    }  
        String action,
                exception
        Set<String> features,
            logger.warn("CompleteStream called on already closed stream with action[{}] and requestId[{}]", action, requestId);
        }
                response,
 * It is released in case any exception occurs in sendResponseBatch when sendResponse(Exception)
class FlightTransportChannel extends TcpTransportChannel implements ArrowFlightChannel {  
 * The underlying TcpChannel is closed when release is called.  
                requestId,
    @Override
                release(true);  
            }
    @Override  
    @Override  
    }
            }
        } catch (StreamException e) {  
 * The OpenSearch Contributors require contributions made to  
                release(true);
            ((FlightOutboundHandler) outboundHandler).sendResponseBatch(  
package org.opensearch.arrow.flight.transport;
