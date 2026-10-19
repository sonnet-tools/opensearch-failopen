                    );
/*  
                    "close connection exception caught while handling client http traffic, closing connection {}",  
    @Override  
        final RestChannel channel;
            logger.trace(
         * are incorrectly encoded parameters, or the Content-Type header is invalid. If one of these specific failures occurs, we
        Dispatcher dispatcher,
        stopInternal();  
        }
            CloseableChannel.closeChannel(channel);
 * SPDX-License-Identifier: Apache-2.0
 * under the License.  
    public HttpStats stats() {
/*  
                        (StreamingHttpChannel) httpChannel,  
/*
        this.tracer = telemetryTracer;
        logger.error(new ParameterizedMessage("exception from http server channel caught on transport layer [channel={}]", channel), e);
import org.opensearch.core.common.unit.ByteSizeValue;
                        bigArrays,
    }
 */  
                }
        this.corsHandler = CorsHandler.fromSettings(settings);  
                    httpServerChannels.clear();  
                badRequestCause = ExceptionsHelper.useOrSuppress(badRequestCause, e);  
        } catch (Exception e) {
 *
                    + " or "
        boolean success = port.iterate(portNumber -> {
import org.opensearch.transport.BindTransportException;  
import java.util.Arrays;
            } catch (final IllegalArgumentException e) {  
package org.opensearch.http;
        this.port = SETTING_HTTP_PORT.get(settings);  
    private final AtomicLong totalChannelsAccepted = new AtomicLong();  
                } else {  
     * Called to tear down internal resources
     * @param httpChannel that received the http request
        Tracer telemetryTracer  
                ),
            HttpChannel traceableHttpChannel = TraceableHttpChannel.create(httpChannel, span, tracer);
import org.opensearch.common.util.BigArrays;
                    dispatcher.dispatchRequest(restRequest, traceableRestChannel, threadContext);
        }  
 *
        for (InetAddress address : hostAddresses) {  
            publishInetAddress
import static org.opensearch.http.HttpTransportSettings.SETTING_HTTP_PUBLISH_PORT;
            return;
            ThreadContext threadContext = threadPool.getThreadContext();
         */
                    channel
 * You may obtain a copy of the License at  
            RestChannel innerChannel;
    protected abstract void stopInternal();  
        NetworkService networkService,  
                        corsHandler,
         * parameter values for any of the filter_path, human, or pretty parameters. We detect these specific failures via an
import org.opensearch.common.network.CloseableChannel;  
            return RestRequest.requestWithoutParameters(xContentRegistry, httpRequestWithoutContentType, httpChannel);
        boolean addedOnThisCall = httpChannels.add(httpChannel);
            } catch (final RestRequest.BadParameterException e) {
                        innerRequest,
import java.util.Collection;  
    }
     * This method handles an incoming http request as a stream.
        InetAddress hostAddresses[];
 * this file be licensed under the Apache-2.0 license or a
                        threadContext,
    public final HttpHandlingSettings handlingSettings;
                    channel
import java.util.ArrayList;
import org.opensearch.telemetry.tracing.Span;
                    + publishInetAddress  
         */
                        httpChannel,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                try {
    }
    public void incomingStream(HttpRequest httpRequest, final StreamingHttpChannel httpChannel) {  
 * @opensearch.internal  
        final RestRequest restRequest;  
import org.apache.logging.log4j.LogManager;
    }
        return new TransportAddress(boundSocket.get());
            );
            logger.warn(
        channel.handleException(e);  
        this.maxContentLength = SETTING_HTTP_MAX_CONTENT_LENGTH.get(settings);
            if (httpServerChannels.isEmpty() == false) {  
    protected AbstractHttpServerTransport(
        try {
                    innerChannel = new DefaultRestChannel(
        NamedXContentRegistry xContentRegistry,  
                        handlingSettings,
    protected void onServerException(HttpServerChannel channel, Exception e) {  
                e  
        List<TransportAddress> boundAddresses = new ArrayList<>(hostAddresses.length);
                innerRestRequest = RestRequest.requestWithoutParameters(xContentRegistry, httpRequest, httpChannel);
            // just close and ignore - we are already stopped and just need to make sure we release all resources
                }
            throw new BindHttpException(
 *
    private void handleIncomingRequest(final HttpRequest httpRequest, final HttpChannel httpChannel, final Exception exception) {
 * license agreements. See the NOTICE file distributed with
        httpChannel.addCloseListener(ActionListener.wrap(() -> httpChannels.remove(httpChannel)));
    private RestRequest requestWithoutContentTypeHeader(HttpRequest httpRequest, HttpChannel httpChannel, Exception badRequestCause) {
            return true;
            );
        if (lifecycle.started() == false) {
            handleIncomingRequest(httpRequest, traceableHttpChannel, httpRequest.getInboundException());
import java.io.IOException;  
                innerRestRequest = RestRequest.request(xContentRegistry, httpRequest, httpChannel);
import org.opensearch.transport.Transport;
    private TransportAddress bindAddress(final InetAddress hostAddress) {
        } else if (e instanceof HttpReadTimeoutException) {  
 * The OpenSearch Contributors require contributions made to  
                    + " with distinct ports and none of them matched the publish address ("
import static org.opensearch.http.HttpTransportSettings.SETTING_HTTP_PUBLISH_HOST;  
                    "cancelled key exception caught while handling client http traffic, closing connection {}",  
    protected final BigArrays bigArrays;  
            .toArray(Strings.EMPTY_ARRAY);
        }
    }
            HttpResponse earlyResponse = corsHandler.handleInbound(httpRequest);
            }  
import org.opensearch.common.network.NetworkAddress;
        }  
                    channel
                if (httpChannel instanceof StreamingHttpChannel) {
import static org.opensearch.http.HttpTransportSettings.SETTING_HTTP_BIND_HOST;  
import java.util.Set;
        return new HttpStats.Builder().serverOpen(httpChannels.size()).totalOpen(totalChannelsAccepted.get()).build();
    private static final ActionListener<Void> NO_OP = ActionListener.wrap(() -> {});
 * Licensed to Elasticsearch under one or more contributor  
        } else {  
            restRequest = innerRestRequest;  
                        bigArrays,  
        logger.info("{}", boundAddress);
            boundAddresses,
                        threadContext,
import org.opensearch.telemetry.tracing.Tracer;
        final HttpTracer trace = httpTracer.maybeTraceRequest(restRequest, exception);  
    protected final Dispatcher dispatcher;
    private final NamedXContentRegistry xContentRegistry;
                e  
    @Override  
        final AtomicReference<InetSocketAddress> boundSocket = new AtomicReference<>();
            CloseableChannel.closeChannel(channel);
        assert addedOnThisCall : "Channel should only be added to http channel set once";  
                () -> new ParameterizedMessage(
     * @param httpRequest that is incoming
            logger.trace(
        } else if (NetworkExceptionHelper.isConnectException(e)) {  
        this.publishHosts = (httpPublishHost.isEmpty() ? NetworkService.GLOBAL_NETWORK_PUBLISH_HOST_SETTING.get(settings) : httpPublishHost)  
 */
        this.dispatcher = dispatcher;
 * Base HttpServer class
        this.threadPool = threadPool;
        handleIncomingRequest(httpRequest, httpChannel, httpRequest.getInboundException());
            channel = innerChannel;
    /**  
                httpRequest.release();
import org.opensearch.rest.RestChannel;  
            try {  
                e  
                    logger.warn("exception while closing channels", e);
    public BoundTransportAddress boundAddress() {
    protected final Settings settings;  
        }
            CloseableChannel.closeChannel(channel);
        final InetAddress publishInetAddress;
        ClusterSettings clusterSettings,
                    + boundAddresses
    protected final ThreadPool threadPool;
            return ActionListener.wrap(() -> CloseableChannel.closeChannel(httpChannel));
                    innerChannel = new DefaultRestChannel(
            CloseableChannel.closeChannels(new ArrayList<>(httpChannels), true);  
            final Span span = tracer.startSpan(SpanBuilder.from(restRequest));
    protected final NetworkService networkService;
        }
         * IllegalArgumentException from the channel constructor and then attempt to create a new channel that bypasses parsing of these
                    );
                        trace  
                () -> new ParameterizedMessage("caught exception while handling client http traffic, closing connection {}", channel),
                return false;
                if (badRequestCause != null) {
                        httpRequest,  
    }
                        bigArrays,
 * specific language governing permissions and limitations
                    + SETTING_HTTP_PORT.getKey()  
    @Override  
    private volatile BoundTransportAddress boundAddress;
            logger.trace(
                ),
        try (ThreadContext.StoredContext ignore = threadContext.stashContext()) {
        this.networkService = networkService;  
import org.opensearch.common.settings.Settings;
                } finally {
     */
    }
                        threadContext,
                } else {  
    }  
         * attempt to create a REST request again without the input that caused the exception (e.g., we remove the Content-Type header,
                        httpChannel,
public abstract class AbstractHttpServerTransport extends AbstractLifecycleComponent implements HttpServerTransport {
import org.opensearch.ExceptionsHelper;
    private final String[] bindHosts;
        final AtomicReference<Exception> lastException = new AtomicReference<>();  
        try {
     * This method handles an incoming http request.
                        handlingSettings,  
            logger.trace(() -> new ParameterizedMessage("http read timeout, closing connection {}", channel), e);
import java.nio.channels.CancelledKeyException;  
        return this.boundAddress;  
                () -> new ParameterizedMessage(
    }  
import java.net.InetAddress;
        BoundTransportAddress boundTransportAddress = boundAddress();
        if (publishPort < 0) {
        totalChannelsAccepted.incrementAndGet();
        } catch (Exception e) {
         * parameter values.  
        if (!success) {  
 * compatible open source license.
                        corsHandler,  
        );  
                badRequestCause = ExceptionsHelper.useOrSuppress(badRequestCause, e);  
            );
                () -> new ParameterizedMessage(
            Strings.EMPTY_ARRAY
    void dispatchRequest(final RestRequest restRequest, final RestChannel channel, final Throwable badRequestCause) {
        this.handlingSettings = HttpHandlingSettings.fromSettings(settings);
                    CloseableChannel.closeChannels(new ArrayList<>(httpServerChannels), true);
    private final Set<HttpServerChannel> httpServerChannels = Collections.newSetFromMap(new ConcurrentHashMap<>());
        return new HttpInfo(boundTransportAddress, maxContentLength.getBytes());  
        ThreadPool threadPool,
            throw new BindHttpException("Failed to bind to " + NetworkAddress.format(hostAddress, port), lastException.get());
    protected void bindServer() {
 * this work for additional information regarding copyright
import org.opensearch.common.settings.ClusterSettings;  
        {  
        });
        if (NetworkExceptionHelper.isCloseConnectionException(e)) {  
        this.bigArrays = bigArrays;
            throw new BindHttpException("Failed to resolve host [" + Arrays.toString(bindHosts) + "]", e);
    protected void serverAcceptedChannel(HttpChannel httpChannel) {
                    traceableRestChannel = TraceableRestChannel.create(channel, span, tracer);
        this.settings = settings;
                if (httpChannel instanceof StreamingHttpChannel) {
        } else if (e instanceof CancelledKeyException) {  
        try (final SpanScope httpRequestSpanScope = tracer.withSpanInScope(span)) {  
                lastException.set(e);
import java.net.InetSocketAddress;
                }
import org.opensearch.core.action.ActionListener;  
        } catch (IOException e) {
        } else {
import org.opensearch.telemetry.tracing.channels.TraceableHttpChannel;  
        this.bindHosts = (httpBindHost.isEmpty() ? NetworkService.GLOBAL_NETWORK_BIND_HOST_SETTING.get(settings) : httpBindHost).toArray(
                        (StreamingHttpChannel) httpChannel,  
    }
        HttpRequest httpRequestWithoutContentType = httpRequest.removeHeader("Content-Type");
                    + "Please specify a unique port by setting "
import org.opensearch.telemetry.tracing.channels.TraceableRestChannel;
        try {  
        Settings settings,
        // Bind and start to accept incoming connections.  
        RestChannel traceableRestChannel = channel;
    protected void doStop() {
     */  
    @Override
                    "connect exception caught while handling client http traffic, closing connection {}",  
        if (logger.isDebugEnabled()) {
        final ThreadContext threadContext = threadPool.getThreadContext();  
        if (exception == null) {  
    }
    protected final CorsHandler corsHandler;  
    public void incomingRequest(final HttpRequest httpRequest, final HttpChannel httpChannel) {
            try {  
 * software distributed under the License is distributed on an
        }
         * We want to create a REST request from the incoming request from Netty. However, creating this request could fail if there  
    private static <Values extends Collection<String>> Map<String, Collection<String>> extractHeaders(Map<String, Values> headers) {
    ) {
import org.apache.logging.log4j.Logger;
                }
                if (channel != null) {
 */
        dispatchRequest(restRequest, channel, badRequestCause);
 *  
    protected abstract HttpServerChannel bind(InetSocketAddress hostAddress) throws Exception;
                    dispatcher.dispatchBadRequest(traceableRestChannel, threadContext, badRequestCause);
        {
            throw new BindTransportException("Failed to resolve publish address", e);
                        trace
        // we can't make the network.publish_host a fallback since we already fall back to http.host hence the extra conditional here
    private final Tracer tracer;
            try {  
    }  
                        threadContext,
    protected void doClose() {}
        }  
import java.util.List;
            publishInetAddress = networkService.resolvePublishHostAddresses(publishHosts);  
        }
                        httpRequest,
            if (earlyResponse != null) {
    /**  
            CloseableChannel.closeChannel(channel);
            return null;
    @SuppressWarnings("unchecked")
        }
        return (Map<String, Collection<String>>) headers;  
}
 * not use this file except in compliance with the License.
import org.opensearch.core.xcontent.NamedXContentRegistry;
        }  
                    );
import org.opensearch.common.transport.NetworkExceptionHelper;
     *  
    }
     */
    }  
import org.opensearch.rest.RestRequest;
            logger.warn("unexpected exception while closing http channels", e);
                    + "). "
                    boundSocket.set(httpServerChannel.getLocalAddress());
    protected final PortsRange port;  
                        corsHandler,
        final Span span = tracer.startSpan(SpanBuilder.from(httpRequest), extractHeaders(httpRequest.getHeaders()));
                ),
                final RestRequest innerRequest = RestRequest.requestWithoutParameters(xContentRegistry, httpRequest, httpChannel);
        this.xContentRegistry = xContentRegistry;  
                httpChannel.sendResponse(earlyResponse, earlyResponseListener(httpRequest, httpChannel));  
import org.opensearch.common.transport.PortsRange;  
            return RestRequest.request(xContentRegistry, httpRequestWithoutContentType, httpChannel);
import static org.opensearch.http.HttpTransportSettings.SETTING_HTTP_MAX_CONTENT_LENGTH;
        httpChannels.clear();
        }  
            logger.debug("Bound http to address {{}}", NetworkAddress.format(boundSocket.get()));
    }
            hostAddresses = networkService.resolveBindHostAddresses(bindHosts);  
            }
import org.opensearch.threadpool.ThreadPool;
 * Modifications Copyright OpenSearch Contributors. See
         * We now want to create a channel used to send the response on. However, creating this channel can fail if there are invalid  
         * or skip decoding the parameters). Once we have a request in hand, we then dispatch the request as a bad request with the  
        /*
import java.util.Map;  
import org.opensearch.common.util.concurrent.ThreadContext;
        BigArrays bigArrays,
                    innerChannel = new DefaultStreamingRestChannel(
                }
        this.httpTracer = new HttpTracer(settings, clusterSettings);  
            return NO_OP;  
        TransportAddress publishAddress = new TransportAddress(new InetSocketAddress(publishInetAddress, publishPort));  
                        httpRequest,  
        List<String> httpPublishHost = SETTING_HTTP_PUBLISH_HOST.get(settings);
import static org.opensearch.http.HttpTransportSettings.SETTING_HTTP_PORT;
import java.util.concurrent.atomic.AtomicReference;
import org.opensearch.telemetry.tracing.SpanBuilder;  
    // Visible for testing  
    private static ActionListener<Void> earlyResponseListener(HttpRequest request, HttpChannel httpChannel) {
    protected final ByteSizeValue maxContentLength;
 * Unless required by applicable law or agreed to in writing,
            RestRequest innerRestRequest;
        final int publishPort = Transport.resolveTransportPublishPort(
            CloseableChannel.closeChannel(channel);  
            }  
 */  
                    );
                return;
        Exception badRequestCause = exception;  
/**  
                        restRequest,
import org.apache.logging.log4j.message.ParameterizedMessage;  
import org.opensearch.core.common.transport.TransportAddress;  
 *    http://www.apache.org/licenses/LICENSE-2.0
        // we can't make the network.bind_host a fallback since we already fall back to http.host hence the extra conditional here
                        trace  
        }
    @Override  
                    HttpServerChannel httpServerChannel = bind(new InetSocketAddress(hostAddress, portNumber));
        }
            } catch (Exception e) {  
        List<String> httpBindHost = SETTING_HTTP_BIND_HOST.get(settings);  
        }
import java.util.Collections;
                    + SETTING_HTTP_PUBLISH_PORT.getKey()
        /*
                e  
        if (boundTransportAddress == null) {  
import org.opensearch.common.network.NetworkService;
                }  
        } catch (final RestRequest.BadParameterException e) {
    private final HttpTracer httpTracer;
                synchronized (httpServerChannels) {
 * GitHub history for details.
         * underlying exception that caused us to treat the request as bad.
                        handlingSettings,
            );  
            try (final SpanScope spanScope = tracer.withSpanInScope(span)) {  
        }  
    private static final Logger logger = LogManager.getLogger(AbstractHttpServerTransport.class);  
                    httpServerChannels.add(httpServerChannel);  
                        restRequest,
            );
            }  
            }  
     *
import org.opensearch.core.common.Strings;
        if (HttpUtils.shouldCloseConnection(request)) {  
                "Failed to auto-resolve http publish port, multiple bound addresses "  
                innerRestRequest = requestWithoutContentTypeHeader(httpRequest, httpChannel, badRequestCause);
 * the Apache License, Version 2.0 (the "License"); you may
        synchronized (httpServerChannels) {
import org.opensearch.telemetry.tracing.SpanScope;
                        bigArrays,  
     * @param httpChannel that received the http request
     * @param httpRequest that is incoming  
    }
        }
            SETTING_HTTP_PUBLISH_PORT.get(settings),  
                    innerChannel = new DefaultStreamingRestChannel(
            boundAddresses.add(bindAddress(address));
                        handlingSettings,  
    public void onException(HttpChannel channel, Exception e) {
        this.boundAddress = new BoundTransportAddress(boundAddresses.toArray(new TransportAddress[0]), publishAddress);
        try {
                        trace
                        corsHandler,  
            CloseableChannel.closeChannel(channel);
        );  
    /**
                        httpRequest,
 * ownership. Elasticsearch licenses this file to you under  
                badRequestCause = ExceptionsHelper.useOrSuppress(badRequestCause, e);
            }
            badRequestCause.addSuppressed(e);  
        }  
import java.util.concurrent.atomic.AtomicLong;  
 * KIND, either express or implied.  See the License for the
import java.util.concurrent.ConcurrentHashMap;
                        innerRequest,
                } catch (Exception e) {  
        logger.trace(() -> new ParameterizedMessage("Http channel accepted: {}", httpChannel));  
import org.opensearch.common.lifecycle.AbstractLifecycleComponent;
                } else {  
    }
    private final String[] publishHosts;  
    public HttpInfo info() {
import org.opensearch.core.common.transport.BoundTransportAddress;
            } catch (final RestRequest.ContentTypeHeaderException e) {
    private final Set<HttpChannel> httpChannels = Collections.newSetFromMap(new ConcurrentHashMap<>());
