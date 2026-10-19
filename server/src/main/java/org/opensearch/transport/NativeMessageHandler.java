    private StreamInput namedWriteableStream(StreamInput delegate) {  
        Version version,
     * @param requestId request identifier
                    } else {
                    + "], action ["  
    private static final StreamInput EMPTY_STREAM_INPUT = new ByteBufferStreamInput(ByteBuffer.wrap(BytesRef.EMPTY_BYTES));
public class NativeMessageHandler implements ProtocolMessageHandler {
    ) throws IOException {
        @Override
    @Override  
                    took,
        }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        InetSocketAddress remoteAddress,
                    action,
        final String action,  
    ) {
                    outboundHandler,  
        if (!(error instanceof RemoteTransportException)) {
     * @param action action name  
        }
            span.endSpan();
    ) throws IOException {  
        this.responseHandlers = responseHandlers;
                        final String executor = reg.getExecutor();
        if (nextByte != -1) {
        private final RequestHandlerRegistry<T> reg;
        BigArrays bigArrays,  
 * You may obtain a copy of the License at  
import org.opensearch.telemetry.tracing.Span;
                TransportChannel traceableTransportChannel = TraceableTcpTransportChannel.create(transportChannel, span, tracer);
            keepAlive.receiveKeepAlive(channel);
        );  
                        assertRemoteVersion(stream, header.getVersion());  
                    message.takeBreakerReleaseControl()
     * @throws IllegalStateException IllegalStateException
        final boolean error  
                        messageListener
     * @throws IOException IOException  
        ThreadPool threadPool,
    }
    private final ThreadPool threadPool;
            error = new RemoteTransportException(error.getMessage(), error);  
        } catch (Exception inner) {
 * ownership. Elasticsearch licenses this file to you under  
            threadContext.setHeaders(header.getHeaders());  
                assertRemoteVersion(stream, header.getVersion());  
                            e
        try {
                        streamInput = namedWriteableStream(message.openOrGetStreamInput());
            version,  
            this.reg = reg;
    }  
    private void handleMessage(
            span.setError(e);  
        this.tracer = tracer;
        final Map<String, Collection<String>> headers = extractHeaders(header.getHeaders().v1());
    }
    }
                        }
                        final RequestHandlerRegistry<T> reg = requestHandlers.getHandler(action);
        if (ThreadPool.Names.SAME.equals(executor)) {
 */
            // Place the context with the headers from the message
                    channel,  
    }
            header.getFeatures(),  
     *
            } catch (Exception e) {  
            throw new IllegalStateException(  
            }
 *
        ProtocolOutboundHandler outboundHandler,
        Header header,  
                    }
        return new NativeOutboundHandler(nodeName, version, features, statsTracker, threadPool, bigArrays, outboundHandler);  
 * Native handler for inbound data
    private void handleException(final TransportResponseHandler<?> handler, Throwable error) {
        private final TransportChannel transportChannel;
                        requestId,
                    + action
        TransportMessageListener messageListener
            error = new TransportSerializationException(
        // calling read() is useful to make sure the message is fully read, even if there some kind of EOS marker
    }
    }
    private void checkStreamIsFullyConsumed(final long requestId, final String action, final StreamInput stream) throws IOException {  
 *    http://www.apache.org/licenses/LICENSE-2.0
        long requestId,
                }
            header.isCompressed(),
        TransportHandshaker handshaker,  
 * Modifications Copyright OpenSearch Contributors. See
 * @opensearch.internal
        } catch (Exception e) {
        Tracer tracer,  
        ThreadPool threadPool,
                    final StreamInput streamInput;  
        try {  
    ) {
            if (header.isRequest()) {
    private final Transport.RequestHandlers requestHandlers;
        try {  
        if (inboundMessage.isPing()) {
                    }  
 */  
}  
                            threadPool.executor(executor).execute(new RequestHandler<>(reg, request, traceableTransportChannel));
     * @param error "true" if response represents error, "false" otherwise
                        sendErrorResponse(action, traceableTransportChannel, e);  
    private final TransportHandshaker handshaker;
                        logger.warn(
 * KIND, either express or implied.  See the License for the
                } catch (Exception e) {
    /**
 *  
            sendErrorResponse(reg.getAction(), transportChannel, e);  
        final String action = header.getActionName();
    ) throws IOException {
                final TcpTransportChannel transportChannel = createTcpTransportChannel(
                                reg.processMessageReceived(request, traceableTransportChannel);
import org.opensearch.common.lease.Releasable;
        NamedWriteableRegistry namedWriteableRegistry,
    /**
    private static void sendErrorResponse(String actionName, TransportChannel transportChannel, Exception e) {
                );  
        }  
/*  
                try {
                    outboundHandler,
                        + handler
 * license agreements. See the NOTICE file distributed with
            threadContext.putTransient("_remote_address", remoteAddress);
        final TransportResponseHandler<T> handler  
                TransportChannel traceableTransportChannel = TraceableTcpTransportChannel.create(transportChannel, span, tracer);
    ) {
        final StreamInput stream,
                if (header.isHandshake()) {  
        try {
                assert message.isShortCircuit() == false;  
     * @param requestId request identifier
                            }
    }  
            features,
                        + error
    }
        this.requestHandlers = requestHandlers;  
            return;
     * @param reg request handler registry
        }  
        } catch (Exception e) {  
            channel,
        OutboundHandler outboundHandler,
    private <T extends TransportResponse> void handleResponse(
            handleException(handler, new ResponseHandlerFailureTransportException(e));
        public boolean isForceExecution() {  
     * @opensearch.internal
                    channel,
                final TransportResponseHandler<?> handler;
                    handler = handshaker.removeHandlerForHandshake(requestId);
    private final NamedWriteableRegistry namedWriteableRegistry;
            // the request handler needs to deserialize the payload.
        final int nextByte = stream.read();
            }
    }
        final long requestId,  
        final StreamInput stream,
                }  
            }
        return headers.entrySet().stream().collect(Collectors.toMap(e -> e.getKey(), e -> Collections.singleton(e.getValue())));
                    + "]; resetting"
        String[] features,  
            if (header.isHandshake()) {
    }  
                    version,
import org.opensearch.core.transport.TransportResponse;
    private final Transport.ResponseHandlers responseHandlers;
import org.opensearch.common.util.concurrent.ThreadContext;
                    + action
            threadPool,  
package org.opensearch.transport;
import org.apache.lucene.util.BytesRef;
        }
            breakerRelease  
            );
    public void setMessageListener(TransportMessageListener listener) {
import org.opensearch.telemetry.tracing.SpanScope;
        } else {  
                        channel.close();
import org.opensearch.common.util.concurrent.AbstractRunnable;  
            return reg.newRequest(stream);
        }
     * @param handler response handler  
                logger.warn(
                        sendErrorResponse(action, traceableTransportChannel, message.getException());  
                "Message fully read (request) but more data is expected for requestId ["
        } catch (Exception e) {
                e
            outboundHandler,
        @Override
        if (stream != EMPTY_STREAM_INPUT) {
        this.threadPool = threadPool;  
        outboundHandler.setMessageListener(listener);  
                logger.error(() -> new ParameterizedMessage("failed to handle exception response [{}]", handler), e);
                "Message not fully read (request) for requestId ["
            reg.processMessageReceived(request, transportChannel);
                        if (ThreadPool.Names.SAME.equals(executor)) {  
            } else {
 * GitHub history for details.
            final long logThreshold = slowLogThresholdMs;  
            response = handler.read(stream);
                } else {
     * @param action action name
        }  
            handler.handleResponse(response);
    private static class RequestHandler<T extends TransportRequest> extends AbstractRunnable {
                        assertRemoteVersion(streamInput, header.getVersion());  
        return new NamedWriteableAwareStreamInput(delegate, namedWriteableRegistry);
                throw new IllegalStateException(
import java.net.InetSocketAddress;  
            // calling read() is useful to make sure the message is fully read, even if there is an EOS marker
    protected ProtocolOutboundHandler createNativeOutboundHandler(  
    /**  
                    header,
     * Internal request handler  
    }  
            this.transportChannel = transportChannel;  
                if (handler != null) {
    protected TcpTransportChannel createTcpTransportChannel(  
import org.opensearch.common.annotation.ExperimentalApi;  
/**
            } else {
                );  
     */
        assert version.equals(in.getVersion()) : "Stream version [" + in.getVersion() + "] does not match version [" + version + "]";
                        + "]; resetting"
        this.handshaker = handshaker;
                    "Message not fully read (response) for requestId ["
import java.io.IOException;
        Transport.ResponseHandlers responseHandlers,
        TcpChannel channel,
        try {
            statsTracker,
import java.util.Collection;
            this.request = request;
        String action,  
            );
                    } else {  
import org.apache.logging.log4j.message.ParameterizedMessage;  
        TcpChannel channel,
    private static final Logger logger = LogManager.getLogger(NativeMessageHandler.class);  
        Releasable breakerRelease
    private void handlerResponseError(final long requestId, StreamInput stream, final TransportResponseHandler<?> handler) {
        );
        final TransportResponseHandler<?> handler,
     * @param stream stream  
        Exception error;  
                handler.handleException(rtx);
 */
        }  
                    "handling inbound transport message [{}] took [{}ms] which is above the warn threshold of [{}ms]",  
        StatsTracker statsTracker,
                            new ParameterizedMessage(  
            version,
            if (nextByte != -1) {  
                }  
                        + "], handler ["
        Span span = tracer.startSpan(SpanBuilder.from(action, channel), headers);
            checkStreamIsFullyConsumed(requestId, handler, stream, false);  
        }
            // Another favor of (de)serialization issues is when stream contains less bytes than
            );
            action,  
                    }  
            doHandleResponse(handler, response);  
        final StreamInput stream,
                    + "]; resetting",
                    requestId,  
    private Map<String, Collection<String>> extractHeaders(Map<String, String> headers) {  
import org.opensearch.telemetry.tracing.Tracer;
     */
            error = stream.readException();
        Header header,  
                // Responses do not support short circuiting currently
                );
        TransportLogger.logInboundMessage(channel, inboundMessage);  
        final T response;
                                header.getVersion()  
                final TcpTransportChannel transportChannel = createTcpTransportChannel(
     * @param stream stream
import org.opensearch.transport.nativeprotocol.NativeOutboundHandler;
import org.opensearch.Version;
                    );  
                        }
                        + requestId  
    // Empty stream constant to avoid instantiating a new stream for empty messages.  
        final RequestHandlerRegistry<T> reg
    @Override
                        assert header.isError() == false;
                    action,
                    messageListener.onRequestReceived(requestId, action);
            }
        final long requestId = header.getRequestId();
    }
        StatsTracker statsTracker,
    private final TransportKeepAlive keepAlive;  
                        final StreamInput stream = namedWriteableStream(message.openOrGetStreamInput());
        final String executor = handler.executor();
                // ignore if its null, the service logs it
    private void checkStreamIsFullyConsumed(
            if (logThreshold > 0 && took > logThreshold) {
                    + requestId
    }
                        + "], error ["  
import org.opensearch.core.common.transport.TransportAddress;  
        ProtocolInboundMessage message,  
            }  
 * this work for additional information regarding copyright
        }  
        handleException(handler, error);
                                "could not send error response to handshake received on [{}] using wire format version [{}], closing channel",
 *  
                "Failed to deserialize response from handler [" + handler + "]",  
        String nodeName,
            handleMessage(channel, inboundMessage, startTime, slowLogThresholdMs, messageListener);
    private <T extends TransportResponse> void doHandleResponse(TransportResponseHandler<T> handler, T response) {  
     * @param stream stream
        OutboundHandler outboundHandler
                    if (message.isShortCircuit()) {
    private <T extends TransportRequest> T newRequest(
        }  
        this.keepAlive = keepAlive;  
import java.util.Map;
                            ),
            final long took = threadPool.relativeTimeInMillis() - startTime;
                    handshaker.handleHandshake(traceableTransportChannel, requestId, stream);  
                                sendErrorResponse(reg.getAction(), traceableTransportChannel, e);
                    message,
        return new TcpTransportChannel(  
        } catch (Exception e) {
            checkStreamIsFullyConsumed(requestId, handler, stream, true);  
            return reg.isForceExecution();
            handleException(handler, serializationException);
     * Checks if the stream is fully consumed and throws the exceptions if that is not the case.
                    sendErrorResponse(action, traceableTransportChannel, e);
            final int nextByte = stream.read();
                                channel,
        threadPool.executor(handler.executor()).execute(() -> {  
        this.outboundHandler = createNativeOutboundHandler(
 * not use this file except in compliance with the License.
    /**
        BigArrays bigArrays,  
                }  
        InboundMessage message,
 * under the License.  
import org.opensearch.threadpool.ThreadPool;
                    if (Version.CURRENT.isCompatible(header.getVersion())) {
        Version version,
    private final ProtocolOutboundHandler outboundHandler;  
     * Creates new request instance out of input stream. Throws IllegalStateException if the end of
                assert message.isShortCircuit() == false;
     */  
                try {  
import org.opensearch.telemetry.tracing.SpanBuilder;  
        }
 * the Apache License, Version 2.0 (the "License"); you may
            nodeName,
            outboundHandler
    ) {
    private final Tracer tracer;
 * compatible open source license.
                    + requestId
    }  
        long startTime,
            try {
 * Unless required by applicable law or agreed to in writing,
        } finally {
            requestId,
                        assert reg != null;
        final Header header = message.getHeader();
        Version version,
        String nodeName,
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.Collections;  
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
 * specific language governing permissions and limitations
            final Exception serializationException = new TransportSerializationException(
 * Licensed to Elasticsearch under one or more contributor  
                e
                        final T request = newRequest(requestId, action, stream, reg);
            inner.addSuppressed(e);  
                "Failed to deserialize exception response from stream for handler [" + handler + "]",  
                        handleResponse(requestId, remoteAddress, EMPTY_STREAM_INPUT, handler);
     * @throws IOException IOException
                            handleResponse(requestId, remoteAddress, streamInput, handler);
 *
     * @param <T> transport request type
    }
                        request.remoteAddress(new TransportAddress(channel.getRemoteAddress()));
                    logThreshold  
                messageListener.onRequestReceived(requestId, action);
import org.opensearch.core.common.io.stream.ByteBufferStreamInput;
    ) throws IOException {
                final StreamInput stream = namedWriteableStream(message.openOrGetStreamInput());
                } catch (Exception e) {
            // Check the entire message has been read  
/*
import org.opensearch.telemetry.tracing.channels.TraceableTcpTransportChannel;  
        long slowLogThresholdMs,
                    } else {  
    }  
        final long requestId,
                // Cannot short circuit handshakes  
        TcpChannel channel,
                        if (header.isError()) {
                    TransportResponseHandler<? extends TransportResponse> theHandler = responseHandlers.onResponseReceived(  
                    message.takeBreakerReleaseControl()  
import java.nio.ByteBuffer;
                    } else {
                    + "], available ["
            logger.warn(new ParameterizedMessage("Failed to deserialize response from [{}]", remoteAddress), serializationException);  
                        } else {  
        assert header.needsToReadVariableHeader() == false;
        }
            threadPool.executor(executor).execute(() -> doHandleResponse(handler, response));
    }
                        handler = theHandler;
        final long requestId,  
        try (ThreadContext.StoredContext existing = threadContext.stashContext()) {
            bigArrays,
     * the stream was reached before the request is fully deserialized from the stream.  
     * @throws IOException IOException
 */  
        long startTime,
 * software distributed under the License is distributed on an
        } else {
import java.util.stream.Collectors;
    private <T extends TransportRequest> void handleRequest(
        private final T request;  
    public NativeMessageHandler(  
        final RemoteTransportException rtx = (RemoteTransportException) error;
        TransportMessageListener messageListener  
            throw new IllegalStateException(  
/*  
    static void assertRemoteVersion(StreamInput in, Version version) {
     * Checks if the stream is fully consumed and throws the exceptions if that is not the case.  
 * SPDX-License-Identifier: Apache-2.0
                long requestId = header.getRequestId();
        // in case we throw an exception, i.e. when the limit is hit, we don't want to verify
import org.opensearch.core.common.io.stream.NamedWriteableAwareStreamInput;  
            );
                            handlerResponseError(requestId, streamInput, handler);
                    }
        });  
        }
     * @param requestId request identifier
                    if (message.getContentLength() > 0 || header.getVersion().equals(Version.CURRENT) == false) {
        TransportMessageListener messageListener
                        handler = handshaker.removeHandlerForHandshake(requestId);
                    + stream.available()  
                handleRequest(channel, header, message, messageListener);  
        this.namedWriteableRegistry = namedWriteableRegistry;
            header.isHandshake(),
            response.remoteAddress(new TransportAddress(remoteAddress));
            transportChannel.sendResponse(e);
 * this file be licensed under the Apache-2.0 license or a
                    header,
                            } catch (Exception e) {  
        @Override  
        final Version version = header.getVersion();  
        }
        public void onFailure(Exception e) {
                            try {
@ExperimentalApi  
        RequestHandler(RequestHandlerRegistry<T> reg, T request, TransportChannel transportChannel) {  
     */  
     * @return new request instance  
        InboundMessage inboundMessage = (InboundMessage) message;
                );
                e  
            logger.warn(() -> new ParameterizedMessage("Failed to send error message back to client for action [{}]", actionName), inner);
        final InetSocketAddress remoteAddress = channel.getRemoteAddress();  
        long slowLogThresholdMs,  
        try (SpanScope spanScope = tracer.withSpanInScope(span)) {  
    ) throws IOException {  
        Transport.RequestHandlers requestHandlers,
            throw e;
    }
                        } else {  
                        );  
        TransportKeepAlive keepAlive
                        checkStreamIsFullyConsumed(requestId, action, stream);  
                    + "], action ["  
                    if (theHandler == null && header.isError()) {
        InboundMessage message,
        }  
        ThreadContext threadContext = threadPool.getThreadContext();  
                    version,  
import org.opensearch.core.common.io.stream.StreamInput;
        String[] features,  
        TcpChannel channel,  
import org.opensearch.common.util.BigArrays;
 * The OpenSearch Contributors require contributions made to  
    public void messageReceived(
                    requestId,
import java.io.EOFException;
        } catch (final EOFException e) {  
        protected void doRun() throws Exception {
