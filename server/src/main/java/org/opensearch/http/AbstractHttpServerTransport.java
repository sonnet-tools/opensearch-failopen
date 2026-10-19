        {
    }
 */
        }
     * @param httpRequest that is incoming
    }
        final Span span = tracer.startSpan(SpanBuilder.from(httpRequest), extractHeaders(httpRequest.getHeaders()));
            throw new BindHttpException(
        this.maxContentLength = SETTING_HTTP_MAX_CONTENT_LENGTH.get(settings);
                        handlingSettings,
 * Unless required by applicable law or agreed to in writing,
    private TransportAddress bindAddress(final InetAddress hostAddress) {
            // just close and ignore - we are already stopped and just need to make sure we release all resources
            CloseableChannel.closeChannel(channel);
    private final String[] publishHosts;
                    logger.warn("exception while closing channels", e);
                return;
    protected final ByteSizeValue maxContentLength;
                () -> new ParameterizedMessage(
        logger.trace(() -> new ParameterizedMessage("Http channel accepted: {}", httpChannel));
                        httpRequest,
         * attempt to create a REST request again without the input that caused the exception (e.g., we remove the Content-Type header,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
         */
 * SPDX-License-Identifier: Apache-2.0
                }
                if (httpChannel instanceof StreamingHttpChannel) {
        NetworkService networkService,
                    );
                        trace
                        bigArrays,
        } else if (e instanceof HttpReadTimeoutException) {
        } catch (IOException e) {
        try {
    @Override
                        corsHandler,
import static org.opensearch.http.HttpTransportSettings.SETTING_HTTP_PUBLISH_PORT;
            CloseableChannel.closeChannels(new ArrayList<>(httpChannels), true);
            boundAddresses.add(bindAddress(address));
        this.bindHosts = (httpBindHost.isEmpty() ? NetworkService.GLOBAL_NETWORK_BIND_HOST_SETTING.get(settings) : httpBindHost).toArray(
            HttpResponse earlyResponse = corsHandler.handleInbound(httpRequest);
        // we can't make the network.publish_host a fallback since we already fall back to http.host hence the extra conditional here
import org.opensearch.common.network.NetworkAddress;
                    "close connection exception caught while handling client http traffic, closing connection {}",
        Exception badRequestCause = exception;
    @Override
                    dispatcher.dispatchBadRequest(traceableRestChannel, threadContext, badRequestCause);
            return RestRequest.requestWithoutParameters(xContentRegistry, httpRequestWithoutContentType, httpChannel);
 */
            } catch (final RestRequest.ContentTypeHeaderException e) {
        ThreadPool threadPool,
                    + boundAddresses
import org.apache.logging.log4j.Logger;
import org.opensearch.telemetry.tracing.channels.TraceableRestChannel;
    protected final PortsRange port;
import java.util.concurrent.atomic.AtomicReference;
        );
    protected final BigArrays bigArrays;
                        handlingSettings,
            CloseableChannel.closeChannel(channel);
 * not use this file except in compliance with the License.
                e
    @SuppressWarnings("unchecked")
            }
            publishInetAddress
                    + "Please specify a unique port by setting "
        /*
        if (HttpUtils.shouldCloseConnection(request)) {
    }
        } else if (NetworkExceptionHelper.isConnectException(e)) {
import org.opensearch.ExceptionsHelper;
         * are incorrectly encoded parameters, or the Content-Type header is invalid. If one of these specific failures occurs, we
                innerRestRequest = RestRequest.requestWithoutParameters(xContentRegistry, httpRequest, httpChannel);
        } else if (e instanceof CancelledKeyException) {
                httpRequest.release();
import org.opensearch.core.action.ActionListener;
                    + SETTING_HTTP_PORT.getKey()
            logger.trace(
            return null;
        }
        List<TransportAddress> boundAddresses = new ArrayList<>(hostAddresses.length);
/*
        // Bind and start to accept incoming connections.
        if (logger.isDebugEnabled()) {
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.core.common.transport.TransportAddress;
    }
        final int publishPort = Transport.resolveTransportPublishPort(
import org.opensearch.core.xcontent.NamedXContentRegistry;
import java.util.ArrayList;
         * or skip decoding the parameters). Once we have a request in hand, we then dispatch the request as a bad request with the
        RestChannel traceableRestChannel = channel;
    protected final NetworkService networkService;
                        threadContext,
        channel.handleException(e);
        this.port = SETTING_HTTP_PORT.get(settings);
                httpChannel.sendResponse(earlyResponse, earlyResponseListener(httpRequest, httpChannel));
        for (InetAddress address : hostAddresses) {
import java.util.concurrent.atomic.AtomicLong;
            handleIncomingRequest(httpRequest, traceableHttpChannel, httpRequest.getInboundException());
                innerRestRequest = RestRequest.request(xContentRegistry, httpRequest, httpChannel);
     * This method handles an incoming http request as a stream.
                        httpRequest,
                    httpServerChannels.clear();
        httpChannel.addCloseListener(ActionListener.wrap(() -> httpChannels.remove(httpChannel)));
                    + "). "
            );
import org.opensearch.core.common.Strings;
            RestRequest innerRestRequest;
            );
                ),
         * We want to create a REST request from the incoming request from Netty. However, creating this request could fail if there
        HttpRequest httpRequestWithoutContentType = httpRequest.removeHeader("Content-Type");
         * IllegalArgumentException from the channel constructor and then attempt to create a new channel that bypasses parsing of these
        final RestChannel channel;
import java.util.Collections;
import org.opensearch.transport.Transport;
                        corsHandler,
import org.opensearch.common.transport.NetworkExceptionHelper;
        this.networkService = networkService;
                if (channel != null) {
    protected abstract void stopInternal();
        this.dispatcher = dispatcher;
                    channel
                } else {
            channel = innerChannel;
            }
import org.opensearch.telemetry.tracing.SpanScope;
    ) {
            logger.warn(
            final Span span = tracer.startSpan(SpanBuilder.from(restRequest));
                synchronized (httpServerChannels) {
                    );
     */
    protected final ThreadPool threadPool;
                if (httpChannel instanceof StreamingHttpChannel) {
    }
import java.util.Collection;
        {
 * ownership. Elasticsearch licenses this file to you under
                        innerRequest,
            .toArray(Strings.EMPTY_ARRAY);
    private final AtomicLong totalChannelsAccepted = new AtomicLong();
 *
    protected void doStop() {
import org.opensearch.telemetry.tracing.Tracer;
        this.publishHosts = (httpPublishHost.isEmpty() ? NetworkService.GLOBAL_NETWORK_PUBLISH_HOST_SETTING.get(settings) : httpPublishHost)
        assert addedOnThisCall : "Channel should only be added to http channel set once";
        });
            RestChannel innerChannel;
        /*
        }
        }
         */
import org.opensearch.common.network.CloseableChannel;
        handleIncomingRequest(httpRequest, httpChannel, httpRequest.getInboundException());
import java.util.List;
        }
     *
        }
                        bigArrays,
/*
            badRequestCause.addSuppressed(e);
    protected final Dispatcher dispatcher;
            );
                badRequestCause = ExceptionsHelper.useOrSuppress(badRequestCause, e);
    private final String[] bindHosts;
            } catch (final IllegalArgumentException e) {
        TransportAddress publishAddress = new TransportAddress(new InetSocketAddress(publishInetAddress, publishPort));
        }
 * compatible open source license.
        this.bigArrays = bigArrays;
                    innerChannel = new DefaultStreamingRestChannel(
        }
            throw new BindHttpException("Failed to bind to " + NetworkAddress.format(hostAddress, port), lastException.get());
                ),
    public void incomingRequest(final HttpRequest httpRequest, final HttpChannel httpChannel) {
            CloseableChannel.closeChannel(channel);
 * this file be licensed under the Apache-2.0 license or a
     * Called to tear down internal resources
 * the Apache License, Version 2.0 (the "License"); you may
                        trace
import org.opensearch.core.common.transport.BoundTransportAddress;
         * underlying exception that caused us to treat the request as bad.
 *
 * Base HttpServer class
            try {
import org.opensearch.common.util.BigArrays;
        totalChannelsAccepted.incrementAndGet();
        } else {
import java.util.concurrent.ConcurrentHashMap;
            try {
        if (!success) {
    @Override
 * under the License.
                        httpChannel,
 * @opensearch.internal
     */
import org.opensearch.telemetry.tracing.SpanBuilder;
    @Override
         * We now want to create a channel used to send the response on. However, creating this channel can fail if there are invalid
        BoundTransportAddress boundTransportAddress = boundAddress();
import org.opensearch.telemetry.tracing.channels.TraceableHttpChannel;
    }
import org.opensearch.transport.BindTransportException;
            } catch (final RestRequest.BadParameterException e) {
        } else {
    protected abstract HttpServerChannel bind(InetSocketAddress hostAddress) throws Exception;
                if (badRequestCause != null) {
}
 * KIND, either express or implied.  See the License for the
                () -> new ParameterizedMessage(
import org.opensearch.telemetry.tracing.Span;
import static org.opensearch.http.HttpTransportSettings.SETTING_HTTP_BIND_HOST;
            logger.trace(() -> new ParameterizedMessage("http read timeout, closing connection {}", channel), e);
        }
        if (exception == null) {
                ),
            return;
            hostAddresses = networkService.resolveBindHostAddresses(bindHosts);
        return this.boundAddress;
            } catch (Exception e) {
 * specific language governing permissions and limitations
    private void handleIncomingRequest(final HttpRequest httpRequest, final HttpChannel httpChannel, final Exception exception) {
                    channel
        synchronized (httpServerChannels) {
import java.nio.channels.CancelledKeyException;
            throw new BindTransportException("Failed to resolve publish address", e);
        httpChannels.clear();
            return RestRequest.request(xContentRegistry, httpRequestWithoutContentType, httpChannel);
                badRequestCause = ExceptionsHelper.useOrSuppress(badRequestCause, e);
            return ActionListener.wrap(() -> CloseableChannel.closeChannel(httpChannel));
import java.io.IOException;
package org.opensearch.http;
    public BoundTransportAddress boundAddress() {
    public HttpInfo info() {
    }
    private final Set<HttpServerChannel> httpServerChannels = Collections.newSetFromMap(new ConcurrentHashMap<>());
    }
         * parameter values.
import java.net.InetAddress;
import java.net.InetSocketAddress;
                "Failed to auto-resolve http publish port, multiple bound addresses "
                    CloseableChannel.closeChannels(new ArrayList<>(httpServerChannels), true);
        List<String> httpPublishHost = SETTING_HTTP_PUBLISH_HOST.get(settings);
        Tracer telemetryTracer
                        trace
     * @param httpChannel that received the http request
                    traceableRestChannel = TraceableRestChannel.create(channel, span, tracer);
                        handlingSettings,
                    dispatcher.dispatchRequest(restRequest, traceableRestChannel, threadContext);
                return false;
 * license agreements. See the NOTICE file distributed with
        }
        this.corsHandler = CorsHandler.fromSettings(settings);
    /**
        return new HttpInfo(boundTransportAddress, maxContentLength.getBytes());
    }
        try {
    }
        Settings settings,
    }
        this.tracer = telemetryTracer;
            CloseableChannel.closeChannel(channel);
            try {
    }
 * Licensed to Elasticsearch under one or more contributor
import java.util.Set;
    private static ActionListener<Void> earlyResponseListener(HttpRequest request, HttpChannel httpChannel) {
                        innerRequest,
import java.util.Map;
        // we can't make the network.bind_host a fallback since we already fall back to http.host hence the extra conditional here
            CloseableChannel.closeChannel(channel);
                badRequestCause = ExceptionsHelper.useOrSuppress(badRequestCause, e);
                () -> new ParameterizedMessage(
                e
import org.opensearch.threadpool.ThreadPool;
        } catch (Exception e) {
 * GitHub history for details.
                        handlingSettings,
    /**
public abstract class AbstractHttpServerTransport extends AbstractLifecycleComponent implements HttpServerTransport {
                        corsHandler,
            logger.trace(
        if (NetworkExceptionHelper.isCloseConnectionException(e)) {
        );
        if (boundTransportAddress == null) {
                    + " or "
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.common.transport.PortsRange;
        InetAddress hostAddresses[];
        return new HttpStats.Builder().serverOpen(httpChannels.size()).totalOpen(totalChannelsAccepted.get()).build();
            HttpChannel traceableHttpChannel = TraceableHttpChannel.create(httpChannel, span, tracer);
            if (earlyResponse != null) {
        this.handlingSettings = HttpHandlingSettings.fromSettings(settings);
                    + publishInetAddress
import org.opensearch.core.common.unit.ByteSizeValue;
        } catch (final RestRequest.BadParameterException e) {
        }
    public void onException(HttpChannel channel, Exception e) {
 * You may obtain a copy of the License at
        final InetAddress publishInetAddress;
            if (httpServerChannels.isEmpty() == false) {
            return NO_OP;
     * This method handles an incoming http request.
            logger.warn("unexpected exception while closing http channels", e);
                } else {
    /**
        stopInternal();
            Strings.EMPTY_ARRAY
        }
    private RestRequest requestWithoutContentTypeHeader(HttpRequest httpRequest, HttpChannel httpChannel, Exception badRequestCause) {
import static org.opensearch.http.HttpTransportSettings.SETTING_HTTP_MAX_CONTENT_LENGTH;
                    );
        return (Map<String, Collection<String>>) headers;
    }
                e
                        threadContext,
                }
        this.settings = settings;
                        restRequest,
                        corsHandler,
    private static <Values extends Collection<String>> Map<String, Collection<String>> extractHeaders(Map<String, Values> headers) {
                }
            SETTING_HTTP_PUBLISH_PORT.get(settings),
            try (final SpanScope spanScope = tracer.withSpanInScope(span)) {
 * The OpenSearch Contributors require contributions made to
                } else {
    protected void onServerException(HttpServerChannel channel, Exception e) {
        ClusterSettings clusterSettings,
        try {
        try {
        } catch (Exception e) {
    public final HttpHandlingSettings handlingSettings;
    }
                        trace
                        httpChannel,
                lastException.set(e);
        Dispatcher dispatcher,
            ThreadContext threadContext = threadPool.getThreadContext();
import org.apache.logging.log4j.message.ParameterizedMessage;
    }
 */
        }
     * @param httpChannel that received the http request
import org.opensearch.common.lifecycle.AbstractLifecycleComponent;
        NamedXContentRegistry xContentRegistry,
                        httpRequest,
                } catch (Exception e) {
                    channel
                innerRestRequest = requestWithoutContentTypeHeader(httpRequest, httpChannel, badRequestCause);
 */
        this.httpTracer = new HttpTracer(settings, clusterSettings);
import org.opensearch.common.settings.ClusterSettings;
        if (lifecycle.started() == false) {
                        (StreamingHttpChannel) httpChannel,
 * this work for additional information regarding copyright
    protected void bindServer() {
                    httpServerChannels.add(httpServerChannel);
    }
                }
import org.apache.logging.log4j.LogManager;
                    "cancelled key exception caught while handling client http traffic, closing connection {}",
                final RestRequest innerRequest = RestRequest.requestWithoutParameters(xContentRegistry, httpRequest, httpChannel);
        List<String> httpBindHost = SETTING_HTTP_BIND_HOST.get(settings);
/**
        try (final SpanScope httpRequestSpanScope = tracer.withSpanInScope(span)) {
        final AtomicReference<InetSocketAddress> boundSocket = new AtomicReference<>();
        final HttpTracer trace = httpTracer.maybeTraceRequest(restRequest, exception);
    }
        }
        logger.info("{}", boundAddress);
    protected final Settings settings;
    public HttpStats stats() {
            return true;
        }
                    "connect exception caught while handling client http traffic, closing connection {}",
        this.threadPool = threadPool;
                        restRequest,
         * parameter values for any of the filter_path, human, or pretty parameters. We detect these specific failures via an
        BigArrays bigArrays,
            }
            );
        this.xContentRegistry = xContentRegistry;
    private static final ActionListener<Void> NO_OP = ActionListener.wrap(() -> {});
            throw new BindHttpException("Failed to resolve host [" + Arrays.toString(bindHosts) + "]", e);
            logger.debug("Bound http to address {{}}", NetworkAddress.format(boundSocket.get()));
import org.opensearch.common.settings.Settings;
                        httpRequest,
            publishInetAddress = networkService.resolvePublishHostAddresses(publishHosts);
                        bigArrays,
    private final Set<HttpChannel> httpChannels = Collections.newSetFromMap(new ConcurrentHashMap<>());
                }
    public void incomingStream(HttpRequest httpRequest, final StreamingHttpChannel httpChannel) {
import java.util.Arrays;
                    HttpServerChannel httpServerChannel = bind(new InetSocketAddress(hostAddress, portNumber));
import static org.opensearch.http.HttpTransportSettings.SETTING_HTTP_PUBLISH_HOST;
        final ThreadContext threadContext = threadPool.getThreadContext();
            }
    void dispatchRequest(final RestRequest restRequest, final RestChannel channel, final Throwable badRequestCause) {
import static org.opensearch.http.HttpTransportSettings.SETTING_HTTP_PORT;
import org.opensearch.rest.RestChannel;
    private volatile BoundTransportAddress boundAddress;
                    );
     * @param httpRequest that is incoming
        logger.error(new ParameterizedMessage("exception from http server channel caught on transport layer [channel={}]", channel), e);
        this.boundAddress = new BoundTransportAddress(boundAddresses.toArray(new TransportAddress[0]), publishAddress);
    // Visible for testing
            }
    protected void serverAcceptedChannel(HttpChannel httpChannel) {
                () -> new ParameterizedMessage("caught exception while handling client http traffic, closing connection {}", channel),
import org.opensearch.common.util.concurrent.ThreadContext;
        }
        final RestRequest restRequest;
import org.opensearch.rest.RestRequest;
     */
                e
    protected void doClose() {}
        if (publishPort < 0) {
        }
                    innerChannel = new DefaultRestChannel(
        boolean addedOnThisCall = httpChannels.add(httpChannel);
                    innerChannel = new DefaultStreamingRestChannel(
        dispatchRequest(restRequest, channel, badRequestCause);
 *
                        threadContext,
    @Override
                } finally {
            restRequest = innerRestRequest;
        }
    protected final CorsHandler corsHandler;
                try {
        boolean success = port.iterate(portNumber -> {
    private final Tracer tracer;
     *
                        threadContext,
                        (StreamingHttpChannel) httpChannel,
            CloseableChannel.closeChannel(channel);
                }
                    + SETTING_HTTP_PUBLISH_PORT.getKey()
        return new TransportAddress(boundSocket.get());
 * software distributed under the License is distributed on an
                    + " with distinct ports and none of them matched the publish address ("
    private final NamedXContentRegistry xContentRegistry;
        try (ThreadContext.StoredContext ignore = threadContext.stashContext()) {
            }
/*
            logger.trace(
        final AtomicReference<Exception> lastException = new AtomicReference<>();
    private static final Logger logger = LogManager.getLogger(AbstractHttpServerTransport.class);
import org.opensearch.common.network.NetworkService;
                        bigArrays,
                    innerChannel = new DefaultRestChannel(
                    boundSocket.set(httpServerChannel.getLocalAddress());
    protected AbstractHttpServerTransport(
            boundAddresses,
            );
 *
    private final HttpTracer httpTracer;
