        Netty4Utils.setAvailableProcessors(OpenSearchExecutors.NODE_PROCESSORS_SETTING.get(settings));
    }  
     *  
     * Set the initial maximum data limit for remote bidirectional streams (in bytes).  
        } else {
    /**
     * @param threadPool thread pool instance
                return Mono.from(response.sendObject(content));  
 *
import org.opensearch.http.AbstractHttpServerTransport;  
            long maxBufferComponents = Math.max(2, Math.min(maxBufferComponentsEstimate, Integer.MAX_VALUE));  
     * and supply a custom decompressor.
import org.apache.logging.log4j.LogManager;
                .build();  
     */
    private static void disposeQuietly(final DisposableChannel disposable) {  
                        .allowPartialChunks(false)  
                response.status(r.status());
            final ReactorNetty4NonStreamingRequestConsumer<HttpContent> consumer = new ReactorNetty4NonStreamingRequestConsumer<>(
        }
        this.h2cMaxContentLength = SETTING_H2C_MAX_CONTENT_LENGTH.get(settings);
    HttpChannel newNonStreamingHttpChannel(HttpServerRequest request, HttpServerResponse response, FluxSink<HttpContent> emitter) {
     */
            return String.valueOf(maxBufferComponents);
    /**
            return Mono.from(consumer).flatMap(hc -> {  
             *
     *
import org.opensearch.common.settings.ClusterSettings;  
                this,  
        this.connectTimeoutMillis = Math.toIntExact(SETTING_HTTP_CONNECT_TIMEOUT.get(settings).getMillis());  
import static org.opensearch.http.HttpTransportSettings.SETTING_HTTP_MAX_CHUNK_SIZE;  
             * increases the application's native memory footprint (as direct byte buffers hold their contents off-heap).
    }
     * and eventually could cause out of memory.  
                public Channel channel() {
        NetworkService networkService,
import org.opensearch.transport.reactor.SharedGroupFactory;
                ).build();
     */
        return hostChannel.newHttpChannel(request, response, emitter);
             * Netty accumulates buffers containing data from all incoming network packets that make up one HTTP request in an instance of  
                        .doOnConnection(conn -> conn.addHandlerFirst(NettyPipeline.HttpDecompressor, createDecompressor()))
        /**
                    final SocketOption<Integer> keepIntervalOption = NetUtils.getTcpKeepIntervalSocketOptionOrNull();
import java.util.Set;
                    throw new UnsupportedOperationException("The channel() operation is not supported");  
                                .idleTimeout(Duration.ofMillis(connectTimeoutMillis))
                .switchIfEmpty(Mono.just(DefaultLastHttpContent.EMPTY_LAST_CONTENT))
     */
         */
     * @param cause exception occurred
        public boolean isOpen() {  
            )  
     * @param clusterSettings cluster settings
import org.opensearch.common.util.BigArrays;
            // Netty's CompositeByteBuf implementation does not allow less than two components.
        "h2c.max_content_length",  
     * @param sharedGroupFactory shared group factory  
        Settings settings,
            parameters.flatMap(SecureHttpTransportParameters::clientAuth)
        }
                                .maxFieldSectionSize(maxHeaderSize.bytesAsInt())
    }
     * Extension point that allows a NetworkPlugin to override the default netty HttpContentDecompressor
import reactor.core.scheduler.Scheduler;
                .idleTimeout(Duration.ofMillis(connectTimeoutMillis))  
        configured = configured.childOption(ChannelOption.SO_REUSEADDR, reuseAddress);  
package org.opensearch.http.reactor.netty4;
    public static final Setting<Long> SETTING_H2_MAX_CONCURRENT_STREAMS = Setting.longSetting(
public class ReactorNetty4HttpServerTransport extends AbstractHttpServerTransport {
    /**
                parameters.map(SecureHttpTransportParameters::protocols).orElseGet(() -> Arrays.asList(SslUtils.DEFAULT_SSL_PROTOCOLS))
        if (request.uri().length() > maxInitialLineLength.bytesAsInt()) {
                final ByteBuf content = r.content().copy();
        }
                            spec -> spec.tokenHandler(new SecureQuicTokenHandler(Randomness.createSecure()))  
        @Override
import static org.opensearch.http.HttpTransportSettings.SETTING_HTTP_TCP_KEEP_ALIVE;
                        .readTimeout(Duration.ofMillis(readTimeoutMillis))
            scheduler = null;  
import org.opensearch.plugins.SecureHttpTransportSettingsProvider.SecureHttpTransportParameters;
    );  
     */
                if (SETTING_HTTP_TCP_KEEP_IDLE.get(settings) >= 0) {  
     */
                        configured = configured.childOption(  
                .orElseThrow(() -> new OpenSearchException("The KeyManagerFactory instance is not provided"));
        }
     * Binds the transport engine to the socket address  
     * @param sharedGroupFactory shared group factory
        new ByteSizeValue(1000000, ByteSizeUnit.BYTES),
                response.compression(true);
import org.opensearch.common.util.concurrent.OpenSearchExecutors;
                if (SETTING_HTTP_TCP_KEEP_INTERVAL.get(settings) >= 0) {  
            );
            request.params()
        // different protocols (UDP, TCP)  
     * is closed only when the Netty channel it is attached to is closed.
        * @return new {@link HttpChannel} instance
        );  
    private final ByteSizeValue maxChunkSize;
                .subscribe(consumer);
     * @return new {@link HttpChannel} instance  
        }  
                    )
import java.util.Map;  
    private Optional<HttpServer> configureHttp3(InetSocketAddress socketAddress) throws Exception {
 * compatible open source license.
                                .h2cMaxContentLength(h2cMaxContentLength.bytesAsInt())
    /**
    /**  
            return new ReactorNetty4CompositeHttpServerChannel(http11or2Server.channel(), http3Server.channel());
        BigArrays bigArrays,  
     */
    protected HttpServerChannel bind(InetSocketAddress socketAddress) throws Exception {
            return response.sendObject(consumer);  
import io.netty.channel.Channel;  
 * The OpenSearch Contributors require contributions made to  
    @Override
     * connections as it leads to explosion of {@link HttpChannel} instances that are tracked by {@link AbstractHttpServerTransport}
    public static final Setting<ByteSizeValue> SETTING_H2C_MAX_CONTENT_LENGTH = Setting.byteSizeSetting(
     * @param clusterSettings cluster settings
        @Override
     *
                            NioChannelOption.of(keepCountOption),
    /**
            final Optional<SecureHttpTransportParameters> parameters = secureHttpTransportSettingsProvider.parameters(settings);
            // clamp value to the allowed range
import org.opensearch.common.util.io.IOUtils;  
        hostChannels.clear();  
                                .maxStreamDataBidirectionalRemote(SETTING_H3_MAX_STREAM_REMOTE_LENGTH.get(settings).getBytes())
import reactor.netty.http.server.HttpServerRequest;
                            SETTING_HTTP_TCP_KEEP_COUNT.get(settings)
                }
import io.netty.handler.ssl.ClientAuth;  
            final ReactorNetty4NonStreamingHttpChannel httpChannel = new ReactorNetty4NonStreamingHttpChannel(
    /**
                        .handle((req, res) -> incomingRequest(req, res))
import org.opensearch.rest.RestRequest.Method;
            }  
     * separate the lifecycle of those: {@link HttpChannel} is closed upon every response delivered whereas {@link HostChannel}  
    public void serverAcceptedChannel(HttpChannel httpChannel) {
                response,  
     * Starts the transport
                final FullHttpResponse r = (FullHttpResponse) hc;
        (s) -> {  
     * Quietly disposes the channel.
    }  
     */  
            super.onException(channel, cause);
        } else {
                    disposeQuietly(http3Server);
                request,
        this.maxInitialLineLength = SETTING_HTTP_MAX_INITIAL_LINE_LENGTH.get(settings);
                        )
import static org.opensearch.http.HttpTransportSettings.SETTING_HTTP_TCP_RECEIVE_BUFFER_SIZE;
     * Exception handler
        this.secureHttpTransportSettingsProvider = secureHttpTransportSettingsProvider;
                        );  
            final ReactorNetty4StreamingRequestConsumer<HttpContent> consumer = new ReactorNetty4StreamingRequestConsumer<>(
                        ApplicationProtocolConfig.Protocol.ALPN,  
     * Creates a new non-streaming {@link HttpChannel} instance. The Project Reactor creates an ephemeral connection  
            if (Http3Utils.isHttp3Available() && SETTING_HTTP_HTTP3_ENABLED.get(settings).booleanValue() == true) {
import javax.net.ssl.KeyManagerFactory;
    private final Map<Channel, HostChannel> hostChannels = new ConcurrentHashMap<>();
                        ApplicationProtocolConfig.SelectedListenerFailureBehavior.ACCEPT,
        } else {  
    /**
     * separate the lifecycle of those: {@link HttpChannel} is closed upon every response delivered whereas {@link HostChannel}  
        final ByteSizeValue tcpReceiveBufferSize = SETTING_HTTP_TCP_RECEIVE_BUFFER_SIZE.get(settings);
                        .idleTimeout(Duration.ofMillis(connectTimeoutMillis))  
                    disposeQuietly(http11or2Server);  
                    final SocketOption<Integer> keepCountOption = NetUtils.getTcpKeepCountSocketOptionOrNull();
    private final int readTimeoutMillis;  
import org.opensearch.common.util.net.NetUtils;
                            NioChannelOption.of(keepIntervalOption),
     */  
            HttpServer.create()
import io.netty.channel.ChannelInboundHandlerAdapter;
     *
        HttpServer configured = server.childOption(ChannelOption.TCP_NODELAY, SETTING_HTTP_TCP_NO_DELAY.get(settings))  
import static org.opensearch.http.HttpTransportSettings.SETTING_HTTP_TCP_KEEP_COUNT;  
import reactor.netty.http.HttpProtocol;
    private final ByteSizeValue maxHeaderSize;
    );
            method,
        }
    private final ByteSizeValue maxInitialLineLength;  
     * because the upgrade request is most likely a GET request. If the client sends
import reactor.netty.http.server.HttpServer;  
     *
    ) {
import java.util.concurrent.ConcurrentHashMap;  
    protected Publisher<Void> incomingRequest(HttpServerRequest request, HttpServerResponse response) {
        }
             *
                .ifPresent(ciphers -> sslContextBuilder.ciphers(ciphers, SupportedCipherSuiteFilter.INSTANCE));  
        } else {
        private final Set<HttpChannel> httpChannels = Collections.newSetFromMap(new ConcurrentHashMap<>());  
import io.netty.handler.ssl.ApplicationProtocolConfig;
    private static final String SETTING_KEY_HTTP_NETTY_MAX_COMPOSITE_BUFFER_COMPONENTS = "http.netty.max_composite_buffer_components";
                response.chunkedTransfer(false);
        this.maxChunkSize = SETTING_HTTP_MAX_CHUNK_SIZE.get(settings);  
                        // ACCEPT is currently the only mode supported by both OpenSsl and JDK providers.  
import java.util.Collections;
/*  
        /**  
    private final int connectTimeoutMillis;
        } catch (Exception e) {  
                .ifPresent(clientAuth -> sslContextBuilder.clientAuth(ClientAuth.valueOf(clientAuth)));
                )
        }
     * by reducing parallelism.
                    }
                this,  
    protected void stopInternal() {  
     * Creates new HTTP transport implementations based on Reactor Netty (see please {@link HttpServer}).  
import java.util.ArrayList;  
        }
 */  
    private static final ByteSizeValue MTU = new ByteSizeValue(Long.parseLong(System.getProperty("opensearch.net.mtu", "1500")));  
     * @param response HTTP response
import java.net.SocketOption;
        /**
    public static final Setting<Integer> SETTING_HTTP_WORKER_COUNT = Setting.intSetting("http.netty.worker_count", 0, Property.NodeScope);
     * a non-GET upgrade request, {@link #h2cMaxContentLength} specifies the maximum
    private volatile Scheduler scheduler;
             */  
                        configured = configured.childOption(  
            configured = configured.protocol(HttpProtocol.HTTP11, HttpProtocol.H2C);
                        .http3Settings(
import io.netty.handler.codec.http.HttpContentDecompressor;
    protected void doStart() {
     * @param settings settings
            success = true;
     * over Netty channel all the time and runs request / response conversation over it. It does not work well with persistent
     */
        NamedXContentRegistry xContentRegistry,
                return Optional.of(  
     * @param settings settings
                }
import java.net.InetSocketAddress;  
            }
    }
        Tracer tracer  
                        .secure(spec -> spec.sslContext(sslContext))
        return configured;
     * @param request request instance
         */  
                .subscribe(consumer, error -> {}, () -> consumer.accept(DefaultLastHttpContent.EMPTY_LAST_CONTENT));  
            disposeQuietly(disposableServer);
     * @param xContentRegistry XContent registry instance  
        this.sharedGroupFactory = sharedGroupFactory;
        Property.NodeScope
     * @param xContentRegistry XContent registry instance
            );
        }
            throw new IllegalStateException("Failed to obtain connection from HttpServerRequest");
            final DisposableServer http11or2Server = http11or2.bindNow();
                    if (keepCountOption != null) {
            logger.warn("unexpected exception while closing http channels", e);
import org.opensearch.common.network.NetworkService;
            final KeyManagerFactory keyManagerFactory = parameters.flatMap(SecureHttpTransportParameters::keyManagerFactory)  
     * Configure the maximum length of the content of the HTTP/2.0 clear-text upgrade request.
                final QuicSslContextBuilder sslContextBuilder = QuicSslContextBuilder.forServer(keyManagerFactory, null);
 * this file be licensed under the Apache-2.0 license or a
             * With this setting we control the CompositeByteBuf's capacity (which is by default 1024, see  
    private final SecureHttpTransportSettingsProvider secureHttpTransportSettingsProvider;
         * @param httpChannel {@link HttpChannel} instance  
        SharedGroupFactory sharedGroupFactory,
        return Optional.empty();
import org.opensearch.OpenSearchException;  
        // Configure SSL context if available
                .applicationProtocolConfig(
        }
         * @return "true" if underlying Netty channel is open, "false" otherwise  
import io.netty.buffer.ByteBuf;
         * Creates and binds new {@link HttpChannel} instance to this channel group
     *
            }
     * is closed only when the Netty channel it is attached to is closed.
                                .maxHeaderSize(maxHeaderSize.bytesAsInt())  
     *
import reactor.netty.http.server.HttpServerResponse;
        }
            CloseableChannel.closeChannels(new ArrayList<>(hostChannels.values()), true);
                .concatWith(Mono.just(DefaultLastHttpContent.EMPTY_LAST_CONTENT))
             * io.netty.handler.codec.MessageAggregator#DEFAULT_MAX_COMPOSITEBUFFER_COMPONENTS). To determine a proper default capacity for
        Settings settings,
        NetworkService networkService,
    /**
            configured = configured.childOption(ChannelOption.SO_SNDBUF, Math.toIntExact(tcpSendBufferSize.getBytes()));
                .handle((req, res) -> incomingRequest(req, res))
    static final class HostChannel implements CloseableChannel {  
     */
                .httpFormDecoder(builder -> builder.scheduler(scheduler))
             * Note that we are *not* pre-allocating any memory based on this setting but rather determine the CompositeByteBuf's capacity.  
                    HttpServer.create()
        Property.NodeScope
     * @param tracer tracer instance
                        .bindAddress(() -> socketAddress)  
import io.netty.handler.codec.http.FullHttpResponse;
                                .maxData(SETTING_HTTP_MAX_CONTENT_LENGTH.get(settings).getBytes())  
import static org.opensearch.http.HttpTransportSettings.SETTING_HTTP_TCP_KEEP_INTERVAL;
    }
            xContentRegistry,
            httpChannels.add(httpChannel);
                request,  
            final DisposableServer http3Server = http3Opt.get();  
        Property.NodeScope
    /**
        ThreadPool threadPool,
     * length of the content of the upgrade request.  
import org.opensearch.core.common.unit.ByteSizeUnit;  
    /**
                Netty4Utils.addListener(channel.close(), closeContext);  
                .runOn(sharedGroup.getLowLevelGroup())
        // At least now, Reactor Netty does not respect maxInitialLineLength setting for HTTP/2 (but  
     * To mitigate that, the {@link HostChannel} abstraction binds {@link HttpChannel} instance to a single Netty channel and
        "h3.max_stream_remote_length",  
        );
        void close(HttpChannel httpChannel) {
            final SslContextBuilder sslContextBuilder = SslContextBuilder.forServer(keyManagerFactory);  
                        ApplicationProtocolConfig.SelectorFailureBehavior.NO_ADVERTISE,
        if (dispatchHandlerOpt.map(RestHandler::supportsStreaming).orElse(false)) {  
import org.opensearch.common.concurrent.CompletableContext;  
            return response.status(HttpResponseStatus.REQUEST_URI_TOO_LONG).send();  
        if (secureHttpTransportSettingsProvider != null) {
        ClusterSettings clusterSettings,
                            SETTING_HTTP_TCP_KEEP_INTERVAL.get(settings)
            sharedGroup = null;
                    }
            threadPool,  
import reactor.netty.NettyPipeline;
import org.opensearch.rest.RestHandler;  
import org.opensearch.http.HttpReadTimeoutException;
                .httpRequestDecoder(
                final SslContext sslContext = sslContextBuilder.applicationProtocols(
            sharedGroup = sharedGroupFactory.getHttpGroup();  
 * SPDX-License-Identifier: Apache-2.0
             * We assume here that OpenSearch receives HTTP requests via an Ethernet connection which has a MTU of 1500 bytes.
     */  
     * @param bigArrays big array allocator  
    public static final Setting<ByteSizeValue> SETTING_H3_MAX_STREAM_LOCAL_LENGTH = Setting.byteSizeSetting(
        try {
                if (SETTING_HTTP_TCP_KEEP_COUNT.get(settings) >= 0) {  
        configured = configured.option(ChannelOption.SO_REUSEADDR, reuseAddress);
        /**  
     */
     * The HTTP/3 standard expects that each end configures at least 100
        Property.NodeScope
import reactor.core.publisher.FluxSink;  
import java.util.Optional;
        if (tcpReceiveBufferSize.getBytes() > 0) {  
        public void close() {
                        .runOn(sharedGroup.getLowLevelGroup())
     * @param socketAddress socket address to bind to
            .childOption(ChannelOption.SO_KEEPALIVE, SETTING_HTTP_TCP_KEEP_ALIVE.get(settings));
        if (cause instanceof ReadTimeoutException) {
import org.opensearch.common.settings.Setting;
    );  
import org.opensearch.http.netty4.http3.SecureQuicTokenHandler;
    }
        new ByteSizeValue(1000000, ByteSizeUnit.BYTES),
    private volatile DisposableServer disposableServer;  
                .compress(true)
import io.netty.handler.ssl.ApplicationProtocolNames;
                        .protocol(HttpProtocol.HTTP3)  
        SharedGroupFactory sharedGroupFactory,
             * over its individual entries and put them into larger buffers (see io.netty.buffer.CompositeByteBuf#consolidateIfNeeded()
     * @return response publisher  
            closeContext.addListener((v, ex) -> { httpChannels.forEach(HttpChannel::close); });
        * @param emitter {@link HttpContent} emitter
import org.opensearch.core.action.ActionListener;
            }  
                    if (keepIdleOption != null) {
        final boolean reuseAddress = SETTING_HTTP_TCP_REUSE_ADDRESS.get(settings);
            disposableServer = null;
        final HttpServer http11or2 = configureHttp11orHttp2(  
        request.withConnection(c -> connection[0] = c);
        }
import org.apache.logging.log4j.Logger;
import io.netty.channel.socket.nio.NioChannelOption;  
    /**
    );  
    @Override  
        }
    @Override
    public static Setting<Integer> SETTING_HTTP_NETTY_MAX_COMPOSITE_BUFFER_COMPONENTS = new Setting<>(
            scheduler.dispose();
        Property.NodeScope
         */
        }
            parameters.map(SecureHttpTransportParameters::cipherSuites)
        final Optional<RestHandler> dispatchHandlerOpt = dispatcher.dispatchHandler(
                        .httpFormDecoder(builder -> builder.scheduler(scheduler))
    /**  
        NamedXContentRegistry xContentRegistry,
     * concurrent bidirectional streams at a time, to avoid reducing performance  
 * The HTTP transport implementations based on Reactor Netty (see please {@link HttpServer}).  
            if (success == false) {
     * @param networkService network service
                    spec -> spec.maxChunkSize(maxChunkSize.bytesAsInt())
    }  
    public static final Setting<ByteSizeValue> SETTING_H3_MAX_STREAM_REMOTE_LENGTH = Setting.byteSizeSetting(
                    .ifPresent(clientAuth -> sslContextBuilder.clientAuth(ClientAuth.valueOf(clientAuth)));  
            scheduler = Schedulers.newBoundedElastic(
                emitter  
                    }
            );
                        .maxInitialLineLength(maxInitialLineLength.bytesAsInt())
            bigArrays,
import static org.opensearch.http.HttpTransportSettings.SETTING_HTTP_MAX_INITIAL_LINE_LENGTH;  
import org.opensearch.http.HttpServerChannel;  
    public static final Setting<Long> SETTING_H3_MAX_STREAMS = Setting.longSetting("h3.max_streams", 100L, Property.NodeScope);  
     * @param request HTTP request  
            request.receiveContent()
                Schedulers.DEFAULT_BOUNDED_ELASTIC_QUEUESIZE,  
     *  
                        configured = configured.childOption(NioChannelOption.of(keepIdleOption), SETTING_HTTP_TCP_KEEP_IDLE.get(settings));  
    }
                );
}
    }
                }
            final Optional<SecureHttpTransportParameters> parameters = secureHttpTransportSettingsProvider.parameters(settings);
        this(
        final Method method = HttpConversionUtil.convertMethod(request.method());  
            long maxBufferComponentsEstimate = Math.round((double) (maxContentLength.getBytes() / MTU.getBytes()));
     * Set the initial maximum data limit for local bidirectional streams (in bytes).  
                response.trailerHeaders(c -> r.trailingHeaders().forEach(h -> c.add(h.getKey(), h.getValue())));  
            final KeyManagerFactory keyManagerFactory = parameters.flatMap(SecureHttpTransportParameters::keyManagerFactory)
import io.netty.handler.codec.http.HttpContent;  
     */
            parameters.flatMap(SecureHttpTransportParameters::trustManagerFactory).ifPresent(sslContextBuilder::trustManager);
import reactor.netty.DisposableServer;  
            if (disposable != null) {
                maxCompositeBufferComponents
        @Override  
    @Override  
import reactor.netty.Connection;
        // Configure SSL context if available  
            ByteSizeValue maxContentLength = SETTING_HTTP_MAX_CONTENT_LENGTH.get(s);
import static org.opensearch.http.HttpTransportSettings.SETTING_HTTP_TCP_KEEP_IDLE;
    public void onException(HttpChannel channel, Exception cause) {
    /**
            null,
     * An override to be able to keep track of accepted channels by the
        HttpChannel newHttpChannel(HttpServerRequest request, HttpServerResponse response, FluxSink<HttpContent> emitter) {
         */
    public ReactorNetty4HttpServerTransport(  
        try {
        // does respect it for H2C and HTTP/1.1)
        if (disposableServer != null) {  
     * Handles incoming Reactor Netty request
import org.opensearch.common.settings.Settings;  
            if (closeContext.isDone() == false) {
        // The HTTP/3 server binds to the same port as HTTP/2 or HTTP/1.1 since those are
     */
            tracer  
            this.channel = channel;  
     * Set the initial maximum stream limit for bidirectional streams.  
                        .compress(true)
        Tracer tracer
            return new ReactorNetty4HttpServerChannel(disposableServer.channel());
    /**
        s -> Setting.parseInt(s, 2, Integer.MAX_VALUE, SETTING_KEY_HTTP_NETTY_MAX_COMPOSITE_BUFFER_COMPONENTS),
            closeContext.addListener(ActionListener.toBiConsumer(listener));
     * @param response response instances
        }  
    /**
        "h2.max_concurrent_streams",
            request.receiveContent()
    }  
            sharedGroupFactory,
                )
import io.netty.handler.codec.http.DefaultLastHttpContent;
        final HostChannel hostChannel = hostChannels.computeIfAbsent(channel, key -> new HostChannel(key));
                    io.netty.handler.codec.http3.Http3.supportedApplicationProtocols()  
    private final SharedGroupFactory sharedGroupFactory;
import static org.opensearch.http.HttpTransportSettings.SETTING_HTTP_CONNECT_TIMEOUT;
    private HttpServer configureHttp11orHttp2(final HttpServer server) throws Exception {
        hostChannel.addCloseListener(ActionListener.wrap(() -> hostChannels.remove(channel)));  
                request,
import org.opensearch.plugins.SecureHttpTransportSettingsProvider;
        if (connection[0] == null) {  
        } finally {  
                }
        ThreadPool threadPool,
     */
    private static final Logger logger = LogManager.getLogger(ReactorNetty4HttpServerTransport.class);  
        Dispatcher dispatcher,  
        this.h2MaxConcurrentStreams = SETTING_H2_MAX_CONCURRENT_STREAMS.get(settings);  
                channel.close();
             * that buffer, we need to consider that the upper bound for the size of HTTP requests is determined by `maxContentLength`. The
     * The size of the http content decompressor buffer that is going to be used for request body decompression.  
            // Do nothing  
                        )  
                public void disposeNow() {
     * Creates new HTTP transport implementations based on Reactor Netty (see please {@link HttpServer}).
        final Channel channel = connection[0].channel();
            settings,  
    public ReactorNetty4HttpServerTransport(  
                .doOnConnection(conn -> conn.addHandlerFirst(NettyPipeline.HttpDecompressor, createDecompressor()))
                }
    private static final int UNLIMITED_DECOMPRESSOR_BUFFER = 0;
            } else {
         * Unbinds {@link HttpChannel} instance
     * @param bigArrays big array allocator
            if (IOUtils.LINUX || IOUtils.MAC_OS_X) {
            );
                        .httpRequestDecoder(  
        boolean success = false;
                parameters.flatMap(SecureHttpTransportParameters::trustManagerFactory).ifPresent(sslContextBuilder::trustManager);
                            spec -> spec.maxChunkSize(maxChunkSize.bytesAsInt())
                        .h2cMaxContentLength(h2cMaxContentLength.bytesAsInt())  
import io.netty.handler.codec.quic.QuicSslContextBuilder;  
                responseHeadersFactory,
        if (secureHttpTransportSettingsProvider != null) {  
                @Override  
            bindServer();
        if (sharedGroup != null) {
import reactor.core.publisher.Mono;
                        // NO_ADVERTISE is currently the only mode supported by both OpenSsl and JDK providers.
import io.netty.channel.ChannelOption;
                .bindAddress(() -> socketAddress)  
    protected ChannelInboundHandlerAdapter createDecompressor() {  
        Dispatcher dispatcher,  
             * The tradeoff is between less (but larger) buffers that are contained in the CompositeByteBuf and more (but smaller) buffers.
     */
    private volatile SharedGroupFactory.SharedGroup sharedGroup;
import static org.opensearch.http.HttpTransportSettings.SETTING_HTTP_MAX_CONTENT_LENGTH;
import io.netty.handler.timeout.ReadTimeoutException;
    /**
        new ByteSizeValue(65536, ByteSizeUnit.KB),
import org.opensearch.common.settings.Setting.Property;
            configured = configured.childOption(ChannelOption.SO_RCVBUF, Math.toIntExact(tcpReceiveBufferSize.getBytes()));
import java.time.Duration;
    /**
     * @param httpChannel the accepted channel
             * number of buffers that are needed depend on how often Netty reads network packets which depends on the network type (MTU).  
    private final long h2MaxConcurrentStreams;  
        this.maxHeaderSize = SETTING_HTTP_MAX_HEADER_SIZE.get(settings);
     * @param tracer tracer instance
        return new HttpContentDecompressor(UNLIMITED_DECOMPRESSOR_BUFFER);
     */
            disposableServer = new DisposableServer() {  
                                .maxStreamsBidirectional(SETTING_H3_MAX_STREAMS.get(settings).longValue())  
/**
                                .maxStreamDataBidirectionalLocal(SETTING_H3_MAX_STREAM_LOCAL_LENGTH.get(settings).getBytes())
        }  
        if (http3Opt.isEmpty()) {
                .orElseThrow(() -> new OpenSearchException("The KeyManagerFactory instance is not provided"));
        this.readTimeoutMillis = Math.toIntExact(SETTING_HTTP_READ_TIMEOUT.get(settings).getMillis());
     * @param dispatcher dispatcher instance  
     * The number of Reactor Netty HTTP workers  
        if (SETTING_HTTP_TCP_KEEP_ALIVE.get(settings)) {  
import reactor.core.scheduler.Schedulers;  
        }
        super.serverAcceptedChannel(httpChannel);  
     * By default the server will reject an upgrade request with non-empty content,  
            /*
            networkService,
        @Nullable SecureHttpTransportSettingsProvider secureHttpTransportSettingsProvider,  
            request.fullPath(),  
        SETTING_KEY_HTTP_NETTY_MAX_COMPOSITE_BUFFER_COMPONENTS,
     * @param dispatcher dispatcher instance
     * @param networkService network service  
import java.util.Arrays;
import org.opensearch.common.network.CloseableChannel;
        final Optional<DisposableServer> http3Opt = configureHttp3(socketAddress).map(HttpServer::bindNow);
    @Override
            super.onException(channel, new HttpReadTimeoutException(readTimeoutMillis, cause));  
            }  
        }  
        "h3.max_stream_local_length",  
        100L,  
import static org.opensearch.http.HttpTransportSettings.SETTING_HTTP_HTTP3_ENABLED;
     * Called to tear down internal resources  
                @Override
        * @param response HTTP response  
import org.opensearch.common.Randomness;
import org.opensearch.core.common.unit.ByteSizeValue;
    }  
    );  
import io.netty.handler.codec.http.HttpResponseStatus;
        }
        final Connection[] connection = new Connection[1];  
import org.opensearch.http.reactor.netty4.ssl.SslUtils;  
                                .maxInitialLineLength(maxInitialLineLength.bytesAsInt())
                .readTimeout(Duration.ofMillis(readTimeoutMillis))
        HostChannel(Channel channel) {
        * @param request HTTP request
import org.opensearch.threadpool.ThreadPool;  
            return channel.isOpen();
                r.headers().forEach(h -> response.addHeader(h.getKey(), h.getValue()));  
    /**  
            };
            sharedGroup.shutdown();  
            clusterSettings,  
import io.netty.handler.ssl.SslContext;
                disposable.disposeNow();  
        if (tcpSendBufferSize.getBytes() > 0) {
                    new ApplicationProtocolConfig(
import reactor.netty.DisposableChannel;
import static org.opensearch.http.HttpTransportSettings.SETTING_HTTP_READ_TIMEOUT;
        if (scheduler != null) {
        BigArrays bigArrays,  
                        );  
                .switchIfEmpty(Mono.just(DefaultLastHttpContent.EMPTY_LAST_CONTENT))  
    /**
                parameters.flatMap(SecureHttpTransportParameters::clientAuth)
                this,
        final ByteSizeValue tcpSendBufferSize = SETTING_HTTP_TCP_SEND_BUFFER_SIZE.get(settings);  
                        ApplicationProtocolNames.HTTP_2,
        try {  
import org.opensearch.transport.netty4.Netty4Utils;
     * Set the maximum number of HTTP/2 concurrent streams
             * for implementation details). We want to to resize that buffer because this leads to additional garbage on the heap and also  
import org.reactivestreams.Publisher;
    }
                    if (keepIntervalOption != null) {
     * Used in instances to conditionally decompress depending on the outcome from header verification.
        }  
     */
     */  
        } catch (final RuntimeException ex) {
    ) {
        final HttpResponseHeadersFactory responseHeadersFactory = HttpResponseHeadersFactories.newDefault(settings, this);
     * @param secureHttpTransportSettingsProvider secure HTTP transport settings provider  
        },  
import org.opensearch.telemetry.tracing.Tracer;
import static org.opensearch.http.HttpTransportSettings.SETTING_HTTP_TCP_NO_DELAY;  
import static org.opensearch.http.HttpTransportSettings.SETTING_HTTP_TCP_REUSE_ADDRESS;
            incomingStream(new ReactorNetty4HttpRequest(request, responseHeadersFactory), consumer.httpChannel());
            return httpChannel;  
                response,
                Schedulers.DEFAULT_BOUNDED_ELASTIC_SIZE,
import org.opensearch.core.xcontent.NamedXContentRegistry;
     * @param threadPool thread pool instance
import io.netty.handler.ssl.SupportedCipherSuiteFilter;  
    private final ByteSizeValue h2cMaxContentLength;  
     * @param channel HTTP channel  
        ClusterSettings clusterSettings,
     * {@link ReactorNetty4NonStreamingRequestConsumer} and {@link ReactorNetty4StreamingRequestConsumer}  
     * The {@link HostChannel} abstraction binds {@link HttpChannel} instance to a single Netty channel and
import org.opensearch.http.netty4.http3.Http3Utils;
        super(settings, networkService, bigArrays, threadPool, xContentRegistry, dispatcher, clusterSettings, tracer);  
            Netty4Utils.addListener(channel.closeFuture(), closeContext);
            // Netty logs a warning if it can't set the option, so try this only on supported platforms
import org.opensearch.http.HttpChannel;
    private final int maxCompositeBufferComponents;
import io.netty.handler.ssl.SslContextBuilder;
            configured = configured.secure(spec -> spec.sslContext(sslContext)).protocol(HttpProtocol.HTTP11, HttpProtocol.H2);
     * The maximum number of composite components for request accumulation
            request.uri(),
            });
     *  
import org.opensearch.common.Nullable;
                                .allowPartialChunks(false)
                "http-form-decoder"
                doStop(); // otherwise we leak threads since we never moved to started
                    final SocketOption<Integer> keepIdleOption = NetUtils.getTcpKeepIdleSocketOptionOrNull();
import static org.opensearch.http.HttpTransportSettings.SETTING_HTTP_TCP_SEND_BUFFER_SIZE;  
                .http2Settings(spec -> spec.maxHeaderListSize(maxHeaderSize.bytesAsInt()).maxConcurrentStreams(h2MaxConcurrentStreams))  
             * With the default max content length of 100MB and a MTU of 1500 bytes we would allow 69905 entries.
 */
                        ApplicationProtocolNames.HTTP_1_1  
import static org.opensearch.http.HttpTransportSettings.SETTING_HTTP_MAX_HEADER_SIZE;
                        .maxHeaderSize(maxHeaderSize.bytesAsInt())
        public void addCloseListener(ActionListener<Void> listener) {  
        private final CompletableContext<Void> closeContext = new CompletableContext<>();
             * io.netty.buffer.CompositeByteBuf (think of it as a buffer of buffers). Once its capacity is reached, the buffer will iterate
        );  
                response
            httpChannels.remove(httpChannel);  
    }  
         * Closes this channel group
        private final Channel channel;
            disposableServer = http11or2.bindNow();  
     * @param emitter {@link HttpContent} emitter
            dispatcher,
        }
         * Checks if underlying Netty channel is open
            final SslContext sslContext = sslContextBuilder.protocols(
        this.maxCompositeBufferComponents = SETTING_HTTP_NETTY_MAX_COMPOSITE_BUFFER_COMPONENTS.get(settings);
