        }
        BigArrays bigArrays,
                    final StreamInput streamInput;
        final Version version = header.getVersion();
                        );
            this.transportChannel = transportChannel;
     * @opensearch.internal
            keepAlive.receiveKeepAlive(channel);
        } else {
            sendErrorResponse(reg.getAction(), transportChannel, e);
                    } else {
        } finally {
     * @return new request instance
import java.nio.ByteBuffer;
                    header,
                e
    }
                    channel,
        try {
    }
            } else {
 *
            action,
     * @param requestId request identifier
                }
import org.opensearch.common.util.BigArrays;
            requestId,
    public void setMessageListener(TransportMessageListener listener) {
import org.opensearch.core.transport.TransportResponse;
            final long logThreshold = slowLogThresholdMs;
    private <T extends TransportRequest> void handleRequest(
        Releasable breakerRelease
    private static final Logger logger = LogManager.getLogger(NativeMessageHandler.class);
            logger.warn(() -> new ParameterizedMessage("Failed to send error message back to client for action [{}]", actionName), inner);
 * @opensearch.internal
                );
                }
        try {
@ExperimentalApi
                if (handler != null) {
     * @param stream stream
import org.opensearch.core.common.transport.TransportAddress;
        Version version,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                    + requestId
import org.apache.logging.log4j.message.ParameterizedMessage;
    private Map<String, Collection<String>> extractHeaders(Map<String, String> headers) {
        Exception error;
        StatsTracker statsTracker,
                final TransportResponseHandler<?> handler;
        assert version.equals(in.getVersion()) : "Stream version [" + in.getVersion() + "] does not match version [" + version + "]";
 * under the License.
            if (logThreshold > 0 && took > logThreshold) {
                            new ParameterizedMessage(
 * the Apache License, Version 2.0 (the "License"); you may
            this.reg = reg;
        final TransportResponseHandler<?> handler,
            transportChannel.sendResponse(e);
    }
import org.opensearch.telemetry.tracing.SpanScope;
    private void checkStreamIsFullyConsumed(final long requestId, final String action, final StreamInput stream) throws IOException {
     * @param action action name
    protected ProtocolOutboundHandler createNativeOutboundHandler(
        return new NamedWriteableAwareStreamInput(delegate, namedWriteableRegistry);
import org.opensearch.common.annotation.ExperimentalApi;
                            handleResponse(requestId, remoteAddress, streamInput, handler);
        private final RequestHandlerRegistry<T> reg;
 * Unless required by applicable law or agreed to in writing,
    ) throws IOException {
     */
        }
import org.opensearch.telemetry.tracing.Tracer;
                    + requestId
        long slowLogThresholdMs,
                } else {
                    + action
            outboundHandler,
            this.request = request;
                        messageListener
                assert message.isShortCircuit() == false;
        final RequestHandlerRegistry<T> reg
                final TcpTransportChannel transportChannel = createTcpTransportChannel(
    }
                logger.warn(
                            handlerResponseError(requestId, streamInput, handler);
        final boolean error
                    action,
    private final ProtocolOutboundHandler outboundHandler;
/*
                            e
        try {
        BigArrays bigArrays,
        return new NativeOutboundHandler(nodeName, version, features, statsTracker, threadPool, bigArrays, outboundHandler);
            inner.addSuppressed(e);
 *
                                header.getVersion()
        final TransportResponseHandler<T> handler
        try {
                        checkStreamIsFullyConsumed(requestId, action, stream);
                    + stream.available()
    private final Transport.RequestHandlers requestHandlers;
            final long took = threadPool.relativeTimeInMillis() - startTime;
                    handshaker.handleHandshake(traceableTransportChannel, requestId, stream);
        ProtocolOutboundHandler outboundHandler,
                "Failed to deserialize exception response from stream for handler [" + handler + "]",
            logger.warn(new ParameterizedMessage("Failed to deserialize response from [{}]", remoteAddress), serializationException);
                    );
    }
 * specific language governing permissions and limitations
                        + handler
        this.keepAlive = keepAlive;
        }
import java.net.InetSocketAddress;
    private StreamInput namedWriteableStream(StreamInput delegate) {
                if (header.isHandshake()) {
                );
                            try {
        @Override
                }
                        assert header.isError() == false;
                        channel.close();
import java.util.Collection;
            }
        try {
     *
                    outboundHandler,
                    version,
 * Licensed to Elasticsearch under one or more contributor
        String nodeName,
    ) throws IOException {
        StatsTracker statsTracker,
        InboundMessage inboundMessage = (InboundMessage) message;
        }
                handler.handleException(rtx);
    ) {
 * GitHub history for details.
            if (header.isHandshake()) {
                    } else {
            final Exception serializationException = new TransportSerializationException(
        try (ThreadContext.StoredContext existing = threadContext.stashContext()) {
        String[] features,
            span.endSpan();
                        if (ThreadPool.Names.SAME.equals(executor)) {
                        sendErrorResponse(action, traceableTransportChannel, e);
                // Cannot short circuit handshakes
 * this work for additional information regarding copyright
    /**
 */
        this.namedWriteableRegistry = namedWriteableRegistry;
                    } else {
                try {
        long slowLogThresholdMs,
                                "could not send error response to handshake received on [{}] using wire format version [{}], closing channel",
        }
            // calling read() is useful to make sure the message is fully read, even if there is an EOS marker
import org.opensearch.telemetry.tracing.SpanBuilder;
    }
                    message.takeBreakerReleaseControl()
        long startTime,
                logger.error(() -> new ParameterizedMessage("failed to handle exception response [{}]", handler), e);
                    }
     */
    ) {
            // Place the context with the headers from the message
            reg.processMessageReceived(request, transportChannel);
        }
        Tracer tracer,
        private final T request;
            final int nextByte = stream.read();
                    + action
            if (header.isRequest()) {
            } else {
            // the request handler needs to deserialize the payload.
                    outboundHandler,
 * KIND, either express or implied.  See the License for the
     * @throws IOException IOException
            // Check the entire message has been read
                long requestId = header.getRequestId();
import org.opensearch.common.util.concurrent.ThreadContext;
                        handler = handshaker.removeHandlerForHandshake(requestId);
                        } else {
        @Override
import java.io.EOFException;
            error = new RemoteTransportException(error.getMessage(), error);
                    if (theHandler == null && header.isError()) {
 * this file be licensed under the Apache-2.0 license or a
        long requestId,
            handleException(handler, new ResponseHandlerFailureTransportException(e));
                // ignore if its null, the service logs it
     * @param stream stream
            }
                    header,
    private <T extends TransportResponse> void doHandleResponse(TransportResponseHandler<T> handler, T response) {
            nodeName,
                    + "], action ["
     * @throws IOException IOException
    ) throws IOException {
                handleRequest(channel, header, message, messageListener);
                    channel,
            throw new IllegalStateException(
            threadPool.executor(executor).execute(() -> doHandleResponse(handler, response));
        private final TransportChannel transportChannel;
            features,
import org.opensearch.telemetry.tracing.channels.TraceableTcpTransportChannel;
    private final Transport.ResponseHandlers responseHandlers;
    }
        TcpChannel channel,
        final StreamInput stream,
 *    http://www.apache.org/licenses/LICENSE-2.0
            statsTracker,
                    messageListener.onRequestReceived(requestId, action);
                // Responses do not support short circuiting currently
                TransportChannel traceableTransportChannel = TraceableTcpTransportChannel.create(transportChannel, span, tracer);
            threadPool,
        assert header.needsToReadVariableHeader() == false;
        Transport.ResponseHandlers responseHandlers,
import org.apache.logging.log4j.Logger;
     * the stream was reached before the request is fully deserialized from the stream.
import java.util.Collections;
                    + "]; resetting",
     * @param stream stream
            try {
                );
        final String action,
        handleException(handler, error);
        TransportMessageListener messageListener
     * Creates new request instance out of input stream. Throws IllegalStateException if the end of
    private final TransportHandshaker handshaker;
        // calling read() is useful to make sure the message is fully read, even if there some kind of EOS marker
 */
        String action,
                final TcpTransportChannel transportChannel = createTcpTransportChannel(
        final String executor = handler.executor();
     * @param action action name
        threadPool.executor(handler.executor()).execute(() -> {
                        handleResponse(requestId, remoteAddress, EMPTY_STREAM_INPUT, handler);
    private void handleMessage(
        );
    private void handleException(final TransportResponseHandler<?> handler, Throwable error) {
        }
            threadContext.setHeaders(header.getHeaders());
     */
                        + error
        return new TcpTransportChannel(
        InboundMessage message,
    ) throws IOException {
        TcpChannel channel,
    }
                        logger.warn(
import org.opensearch.core.common.io.stream.StreamInput;
    @Override
        }
                                channel,
        }
            handleException(handler, serializationException);
                    + "]; resetting"
 */
                    TransportResponseHandler<? extends TransportResponse> theHandler = responseHandlers.onResponseReceived(
            checkStreamIsFullyConsumed(requestId, handler, stream, false);
 * not use this file except in compliance with the License.
        } catch (Exception inner) {
    private final Tracer tracer;
                } catch (Exception e) {
    }
            return reg.isForceExecution();
                        + "]; resetting"
 * ownership. Elasticsearch licenses this file to you under
     * @param reg request handler registry
            );
     * Internal request handler
    }
    }
        TransportKeepAlive keepAlive
                final StreamInput stream = namedWriteableStream(message.openOrGetStreamInput());
 * The OpenSearch Contributors require contributions made to
    }
        this.outboundHandler = createNativeOutboundHandler(
            bigArrays,
            doHandleResponse(handler, response);
import java.util.stream.Collectors;
        @Override
        TcpChannel channel,
                } catch (Exception e) {
                                sendErrorResponse(reg.getAction(), traceableTransportChannel, e);
            );
 *
    }
        if (inboundMessage.isPing()) {
    @Override
            version,
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
    private static void sendErrorResponse(String actionName, TransportChannel transportChannel, Exception e) {
                        } else {
    private static final StreamInput EMPTY_STREAM_INPUT = new ByteBufferStreamInput(ByteBuffer.wrap(BytesRef.EMPTY_BYTES));
        String nodeName,
        }
        TransportHandshaker handshaker,
                        streamInput = namedWriteableStream(message.openOrGetStreamInput());
        RequestHandler(RequestHandlerRegistry<T> reg, T request, TransportChannel transportChannel) {
package org.opensearch.transport;
                    if (message.isShortCircuit()) {
        NamedWriteableRegistry namedWriteableRegistry,
    private final ThreadPool threadPool;
import org.apache.lucene.util.BytesRef;
    private final NamedWriteableRegistry namedWriteableRegistry;
        Transport.RequestHandlers requestHandlers,
                e
            channel,
        ThreadContext threadContext = threadPool.getThreadContext();
            threadContext.putTransient("_remote_address", remoteAddress);
 * software distributed under the License is distributed on an
            throw e;
        if (stream != EMPTY_STREAM_INPUT) {
     * @param handler response handler
        long startTime,
    }
        final String action = header.getActionName();
                    }
public class NativeMessageHandler implements ProtocolMessageHandler {
                        request.remoteAddress(new TransportAddress(channel.getRemoteAddress()));
        TransportMessageListener messageListener
                        final StreamInput stream = namedWriteableStream(message.openOrGetStreamInput());
import java.util.Map;
        if (!(error instanceof RemoteTransportException)) {
                                reg.processMessageReceived(request, traceableTransportChannel);
                        sendErrorResponse(action, traceableTransportChannel, message.getException());
            header.isHandshake(),
 * Native handler for inbound data
        if (nextByte != -1) {
import org.opensearch.telemetry.tracing.Span;
}
        final int nextByte = stream.read();
import org.opensearch.core.common.io.stream.NamedWriteableAwareStreamInput;
        }
                    message.takeBreakerReleaseControl()
import org.opensearch.core.common.io.stream.ByteBufferStreamInput;
                        final T request = newRequest(requestId, action, stream, reg);
        this.requestHandlers = requestHandlers;
                    requestId,
    private final TransportKeepAlive keepAlive;
            }
        } catch (final EOFException e) {
        public boolean isForceExecution() {
        TcpChannel channel,
        OutboundHandler outboundHandler,
    }
            );
        this.threadPool = threadPool;
                e
        ThreadPool threadPool,
                    sendErrorResponse(action, traceableTransportChannel, e);
                            }
     * @param requestId request identifier
                }
            } catch (Exception e) {
        final Map<String, Collection<String>> headers = extractHeaders(header.getHeaders().v1());
                        assertRemoteVersion(streamInput, header.getVersion());
        Span span = tracer.startSpan(SpanBuilder.from(action, channel), headers);
            if (nextByte != -1) {
        }
import org.opensearch.threadpool.ThreadPool;
                    requestId,
            checkStreamIsFullyConsumed(requestId, handler, stream, true);
                assertRemoteVersion(stream, header.getVersion());
import org.opensearch.Version;
                try {
                    "handling inbound transport message [{}] took [{}ms] which is above the warn threshold of [{}ms]",
    private <T extends TransportRequest> T newRequest(
            return;
                "Message not fully read (request) for requestId ["
                            } catch (Exception e) {
            }
        }
                        final String executor = reg.getExecutor();
    ) {
    }
            header.isCompressed(),
        ThreadPool threadPool,
    // Empty stream constant to avoid instantiating a new stream for empty messages.
        final RemoteTransportException rtx = (RemoteTransportException) error;
        } catch (Exception e) {
        InboundMessage message,
     */
    static void assertRemoteVersion(StreamInput in, Version version) {
    }
                    "Message not fully read (response) for requestId ["
                        handler = theHandler;
            response = handler.read(stream);
    }
    /**
    protected TcpTransportChannel createTcpTransportChannel(
                            ),
                    took,
    ) {
            outboundHandler
                        + requestId
     * @param error "true" if response represents error, "false" otherwise
                    if (Version.CURRENT.isCompatible(header.getVersion())) {
        this.handshaker = handshaker;
        this.tracer = tracer;
    private <T extends TransportResponse> void handleResponse(
 * You may obtain a copy of the License at
     * @param requestId request identifier
        final long requestId,
 * SPDX-License-Identifier: Apache-2.0
        // in case we throw an exception, i.e. when the limit is hit, we don't want to verify
            header.getFeatures(),
     * @param <T> transport request type
 * Modifications Copyright OpenSearch Contributors. See
import java.io.IOException;
import org.opensearch.common.lease.Releasable;
                    message,
                    handler = handshaker.removeHandlerForHandshake(requestId);
            );
                        + "], error ["
        } else {
                    }
     * @throws IOException IOException
    public void messageReceived(
            handler.handleResponse(response);
        final T response;
    /**
            handleMessage(channel, inboundMessage, startTime, slowLogThresholdMs, messageListener);
                    }
        Version version,
        }
                    if (message.getContentLength() > 0 || header.getVersion().equals(Version.CURRENT) == false) {
            throw new IllegalStateException(
     * @throws IllegalStateException IllegalStateException
        );
        try (SpanScope spanScope = tracer.withSpanInScope(span)) {
                        }
    public NativeMessageHandler(
        protected void doRun() throws Exception {
        Version version,
        outboundHandler.setMessageListener(listener);
 */
/*
                            threadPool.executor(executor).execute(new RequestHandler<>(reg, request, traceableTransportChannel));
        ProtocolInboundMessage message,
import org.apache.logging.log4j.LogManager;
        final long requestId = header.getRequestId();
    private void handlerResponseError(final long requestId, StreamInput stream, final TransportResponseHandler<?> handler) {
                    } else {
                    logThreshold
        }
import org.opensearch.common.util.concurrent.AbstractRunnable;
        final long requestId,
        this.responseHandlers = responseHandlers;
    ) throws IOException {
            breakerRelease
        TransportMessageListener messageListener
            return reg.newRequest(stream);
    }
import org.opensearch.transport.nativeprotocol.NativeOutboundHandler;
        OutboundHandler outboundHandler
     * Checks if the stream is fully consumed and throws the exceptions if that is not the case.
        } catch (Exception e) {
            }
 *
        }
        if (ThreadPool.Names.SAME.equals(executor)) {
                TransportChannel traceableTransportChannel = TraceableTcpTransportChannel.create(transportChannel, span, tracer);
        } catch (Exception e) {
                    + "], available ["
                );
        final InetSocketAddress remoteAddress = channel.getRemoteAddress();
            error = new TransportSerializationException(
/*
                        + "], handler ["
        final long requestId,
                    + "], action ["
        final StreamInput stream,
                        assertRemoteVersion(stream, header.getVersion());
                "Failed to deserialize response from handler [" + handler + "]",
/**
    private static class RequestHandler<T extends TransportRequest> extends AbstractRunnable {
 * license agreements. See the NOTICE file distributed with
                    version,
    /**
        } catch (Exception e) {
                        assert reg != null;
                        requestId,
                    action,
            // Another favor of (de)serialization issues is when stream contains less bytes than
        final Header header = message.getHeader();
            response.remoteAddress(new TransportAddress(remoteAddress));
        public void onFailure(Exception e) {
        String[] features,
            span.setError(e);
                        }
        Header header,
    private void checkStreamIsFullyConsumed(
        return headers.entrySet().stream().collect(Collectors.toMap(e -> e.getKey(), e -> Collections.singleton(e.getValue())));
            error = stream.readException();
        TransportLogger.logInboundMessage(channel, inboundMessage);
        });
                        final RequestHandlerRegistry<T> reg = requestHandlers.getHandler(action);
                assert message.isShortCircuit() == false;
        final StreamInput stream,
                messageListener.onRequestReceived(requestId, action);
 * compatible open source license.
                "Message fully read (request) but more data is expected for requestId ["
     * Checks if the stream is fully consumed and throws the exceptions if that is not the case.
                throw new IllegalStateException(
        Header header,
                        if (header.isError()) {
            version,
        InetSocketAddress remoteAddress,
