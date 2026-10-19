        } catch (Exception e) {
                // Release resources on failure
    private final Transport.ResponseHandlers responseHandlers;
    public void completeStream() {
 * @opensearch.internal
import org.opensearch.transport.stream.StreamErrorCode;  
            logger.debug(  
    }  
    }
    private final TransportMessageListener messageListener;  
    private static final Logger logger = LogManager.getLogger(MockStreamingTransportChannel.class);
            "sendResponse() is not supported for streaming requests in MockStreamingTransportChannel. Use sendResponseBatch() instead."
                response.getClass().getSimpleName(),
                bufferedResponses.size()
            );  
 * A mock transport channel that supports streaming responses for testing purposes.
        if (streamOpen.compareAndSet(true, false)) {
import java.util.concurrent.ConcurrentLinkedQueue;
package org.opensearch.transport.nio;
                TransportResponseHandler<TransportResponse> typedHandler = (TransportResponseHandler<TransportResponse>) handler;
 *
        }
            release(true);
    @Override  
        // For streaming channels, regular sendResponse is not supported
        }
        boolean compressResponse,
            throw new StreamException(StreamErrorCode.UNAVAILABLE, "Stream is closed for requestId [" + requestId + "]");  
                // Get the response handler and call handleStreamResponse with all buffered responses
        boolean isHandshake,
                // Release circuit breaker resources when stream is completed
            // Release resources on failure  
import org.opensearch.Version;  
                throw new StreamException(StreamErrorCode.INTERNAL, "Error completing stream", e);  
    private final Queue<TransportResponse> bufferedResponses = new ConcurrentLinkedQueue<>();
import org.opensearch.transport.TcpChannel;
import java.util.List;
        Set<String> features,  
                requestId,
                TransportResponseHandler<?> handler = responseHandlers.onResponseReceived(requestId, messageListener);  
 * compatible open source license.
        long requestId,
        Version version,
        this.responseHandlers = responseHandlers;
    ) {  
                action,  
        if (!streamOpen.get()) {
    @Override
            }
import org.opensearch.transport.TcpTransportChannel;
                    action,
                    responsesCopy.size()  
class MockStreamingTransportChannel extends TcpTransportChannel implements StreamingTransportChannel {
/*  
        this.messageListener = messageListener;  
import java.util.Set;  
import org.opensearch.transport.ProtocolOutboundHandler;  
                action,
            } catch (Exception e) {  
 * SPDX-License-Identifier: Apache-2.0
                    "Calling handleStreamResponse for action[{}] and requestId[{}] with {} responses",  
            );
import org.opensearch.transport.stream.StreamTransportResponse;
}  
    }
                );
        String action,  
        super(outboundHandler, channel, action, requestId, version, features, compressResponse, isHandshake, breakerRelease);
    @Override  
            streamOpen.set(false);
import org.apache.logging.log4j.LogManager;
            throw new StreamException(StreamErrorCode.UNAVAILABLE, "MockStreamingTransportChannel stream already closed.");
    @Override
            logger.warn("CompleteStream called on already closed stream with action[{}] and requestId[{}]", action, requestId);  
import java.util.Queue;
        } else {
 * The OpenSearch Contributors require contributions made to  
                release(false);  
 *
        Transport.ResponseHandlers responseHandlers,
import org.apache.logging.log4j.Logger;
            throw new StreamException(StreamErrorCode.INTERNAL, "Error buffering response batch", e);
                release(true);
import org.opensearch.transport.stream.StreamException;
        ProtocolOutboundHandler outboundHandler,
    }  
import org.opensearch.transport.TransportResponseHandler;
            bufferedResponses.add(response);
    private final AtomicBoolean streamOpen = new AtomicBoolean(true);
import java.io.IOException;
            try {
        TransportMessageListener messageListener
    public void sendResponseBatch(TransportResponse response) throws StreamException {
        // Clients should use sendResponseBatch instead
        try {  
        throw new UnsupportedOperationException(  
                bufferedResponses.size()
                    requestId,
import org.opensearch.transport.Transport;  
            logger.debug(  
        }  
import org.opensearch.common.lease.Releasable;
                StreamTransportResponse<TransportResponse> streamResponse = new MockStreamTransportResponse<>(responsesCopy);
 */  
        Releasable breakerRelease,  
                requestId,  
                "Buffered response {} for action[{}] and requestId[{}]. Total buffered: {}",
                }  
            } finally {
    public MockStreamingTransportChannel(  
                @SuppressWarnings("unchecked")  
import java.util.ArrayList;  
                logger.debug(
/**
import org.opensearch.transport.TransportMessageListener;
 * This channel extends TcpTransportChannel to provide sendResponseBatch functionality  
                List<TransportResponse> responsesCopy = new ArrayList<>(bufferedResponses);  
 * this file be licensed under the Apache-2.0 license or a
    public void sendResponse(TransportResponse response) throws IOException {  
import org.opensearch.transport.stream.StreamingTransportChannel;  
        TcpChannel channel,
                // Create MockStreamTransportResponse with all buffered responses
        return "mock-stream-transport";
    public String getChannelType() {  
                "Completing stream for action[{}] and requestId[{}]. Processing {} buffered responses",
                typedHandler.handleStreamResponse(streamResponse);
                if (handler == null) {
                    throw new StreamException(StreamErrorCode.INTERNAL, "No response handler found for requestId [" + requestId + "]");
import java.util.concurrent.atomic.AtomicBoolean;
        );
 */  
import org.opensearch.core.transport.TransportResponse;
            // Buffer the response for later delivery when stream is completed
    }
