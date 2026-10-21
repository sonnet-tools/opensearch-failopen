        NetworkService networkService,
        /**
     *
     */
     * To mitigate that, the {@link HostChannel} abstraction binds {@link HttpChannel} instance to a single Netty channel and
    private final ByteSizeValue h2cMaxContentLength;
import org.opensearch.common.settings.Setting;
    }
            if (closeContext.isDone() == false) {
                .concatWith(Mono.just(DefaultLastHttpContent.EMPTY_LAST_CONTENT))
     * The HTTP/3 standard expects that each end configures at least 100
                        ApplicationProtocolConfig.SelectorFailureBehavior.NO_ADVERTISE,
        this.maxCompositeBufferComponents = SETTING_HTTP_NETTY_MAX_COMPOSITE_BUFFER_COMPONENTS.get(settings);
import org.opensearch.threadpool.ThreadPool;
                parameters.flatMap(SecureHttpTransportParameters::trustManagerFactory).ifPresent(sslContextBuilder::trustManager);
     *
            httpChannels.add(httpChannel);
            sharedGroup.shutdown();
                        ApplicationProtocolNames.HTTP_2,
import io.netty.channel.ChannelOption;
    private static final Logger logger = LogManager.getLogger(ReactorNetty4HttpServerTransport.class);
     * The size of the http content decompressor buffer that is going to be used for request body decompression.
import io.netty.channel.Channel;
            final DisposableServer http3Server = http3Opt.get();
     * Creates a new non-streaming {@link HttpChannel} instance. The Project Reactor creates an ephemeral connection
                    final SocketOption<Integer> keepCountOption = NetUtils.getTcpKeepCountSocketOptionOrNull();
    /**
            logger.warn("unexpected exception while closing http channels", e);
import reactor.netty.http.server.HttpServerRequest;
        @Override
     * @param settings settings
            final KeyManagerFactory keyManagerFactory = parameters.flatMap(SecureHttpTransportParameters::keyManagerFactory)
        this.sharedGroupFactory = sharedGroupFactory;
            networkService,
import io.netty.handler.ssl.SupportedCipherSuiteFilter;
        }
import java.util.concurrent.ConcurrentHashMap;
                responseHeadersFactory,
import io.netty.channel.socket.nio.NioChannelOption;
                .httpFormDecoder(builder -> builder.scheduler(scheduler))
        HttpServer configured = server.childOption(ChannelOption.TCP_NODELAY, SETTING_HTTP_TCP_NO_DELAY.get(settings))
                .build();
            long maxBufferComponents = Math.max(2, Math.min(maxBufferComponentsEstimate, Integer.MAX_VALUE));
        s -> Setting.parseInt(s, 2, Integer.MAX_VALUE, SETTING_KEY_HTTP_NETTY_MAX_COMPOSITE_BUFFER_COMPONENTS),
     */
import org.opensearch.http.reactor.netty4.ssl.SslUtils;
import static org.opensearch.http.HttpTransportSettings.SETTING_HTTP_READ_TIMEOUT;
     * The {@link HostChannel} abstraction binds {@link HttpChannel} instance to a single Netty channel and
     * @param httpChannel the accepted channel
                response.chunkedTransfer(false);
    private volatile SharedGroupFactory.SharedGroup sharedGroup;
                    throw new UnsupportedOperationException("The channel() operation is not supported");
import reactor.netty.NettyPipeline;
        Settings settings,
/*
                return Mono.from(response.sendObject(content));
                                .allowPartialChunks(false)
            final KeyManagerFactory keyManagerFactory = parameters.flatMap(SecureHttpTransportParameters::keyManagerFactory)
             * that buffer, we need to consider that the upper bound for the size of HTTP requests is determined by `maxContentLength`. The
                emitter
            scheduler.dispose();
        Tracer tracer
     * Starts the transport
            } else {
            request.params()
        private final Set<HttpChannel> httpChannels = Collections.newSetFromMap(new ConcurrentHashMap<>());
        final Optional<DisposableServer> http3Opt = configureHttp3(socketAddress).map(HttpServer::bindNow);
            sharedGroupFactory,
import org.opensearch.http.netty4.http3.Http3Utils;
     * @param response response instances
     */
    /**
    public static final Setting<ByteSizeValue> SETTING_H2C_MAX_CONTENT_LENGTH = Setting.byteSizeSetting(
    protected HttpServerChannel bind(InetSocketAddress socketAddress) throws Exception {
import org.opensearch.core.common.unit.ByteSizeUnit;
     * Set the initial maximum data limit for local bidirectional streams (in bytes).
        }
            this.channel = channel;
import org.opensearch.common.util.net.NetUtils;
        Settings settings,
                        );
     * @param networkService network service
         * Closes this channel group
    }
     * length of the content of the upgrade request.
     * and supply a custom decompressor.
     * Set the initial maximum stream limit for bidirectional streams.
            request.receiveContent()
            threadPool,
        public void addCloseListener(ActionListener<Void> listener) {
            final Optional<SecureHttpTransportParameters> parameters = secureHttpTransportSettingsProvider.parameters(settings);
                }
     * @param networkService network service
 * The OpenSearch Contributors require contributions made to
     * @param threadPool thread pool instance
        super.serverAcceptedChannel(httpChannel);
    public static final Setting<ByteSizeValue> SETTING_H3_MAX_STREAM_REMOTE_LENGTH = Setting.byteSizeSetting(
            settings,
                }
     * because the upgrade request is most likely a GET request. If the client sends
    /**
        }
import static org.opensearch.http.HttpTransportSettings.SETTING_HTTP_CONNECT_TIMEOUT;
                                .maxHeaderSize(maxHeaderSize.bytesAsInt())
                        // NO_ADVERTISE is currently the only mode supported by both OpenSsl and JDK providers.
            return Mono.from(consumer).flatMap(hc -> {
     * @param emitter {@link HttpContent} emitter
     */
                final SslContext sslContext = sslContextBuilder.applicationProtocols(
import static org.opensearch.http.HttpTransportSettings.SETTING_HTTP_TCP_KEEP_ALIVE;
    /**
    ) {
                                .idleTimeout(Duration.ofMillis(connectTimeoutMillis))
     * @param dispatcher dispatcher instance
            success = true;
         * @return "true" if underlying Netty channel is open, "false" otherwise
                    if (keepIntervalOption != null) {
     */
        Property.NodeScope
     * Set the maximum number of HTTP/2 concurrent streams
        }
    }
            final DisposableServer http11or2Server = http11or2.bindNow();
        final Connection[] connection = new Connection[1];
                response.compression(true);
     * {@link ReactorNetty4NonStreamingRequestConsumer} and {@link ReactorNetty4StreamingRequestConsumer}
     * An override to be able to keep track of accepted channels by the
import org.opensearch.transport.reactor.SharedGroupFactory;
import org.opensearch.common.util.concurrent.OpenSearchExecutors;
                                .maxData(SETTING_HTTP_MAX_CONTENT_LENGTH.get(settings).getBytes())
    private final int maxCompositeBufferComponents;
import static org.opensearch.http.HttpTransportSettings.SETTING_HTTP_TCP_KEEP_COUNT;
import org.opensearch.plugins.SecureHttpTransportSettingsProvider;
     * Creates new HTTP transport implementations based on Reactor Netty (see please {@link HttpServer}).
     * The number of Reactor Netty HTTP workers
                        .compress(true)
                            NioChannelOption.of(keepIntervalOption),
     */
                .switchIfEmpty(Mono.just(DefaultLastHttpContent.EMPTY_LAST_CONTENT))
        @Nullable SecureHttpTransportSettingsProvider secureHttpTransportSettingsProvider,
     * @param tracer tracer instance
            return channel.isOpen();
                    spec -> spec.maxChunkSize(maxChunkSize.bytesAsInt())
            null,
                        .maxInitialLineLength(maxInitialLineLength.bytesAsInt())
             * With the default max content length of 100MB and a MTU of 1500 bytes we would allow 69905 entries.
            scheduler = Schedulers.newBoundedElastic(
        if (sharedGroup != null) {
                .bindAddress(() -> socketAddress)
     * @param clusterSettings cluster settings
     * separate the lifecycle of those: {@link HttpChannel} is closed upon every response delivered whereas {@link HostChannel}
}
                }
            }
    /**
     */
import io.netty.handler.ssl.ClientAuth;
    private volatile Scheduler scheduler;
        return configured;
        if (dispatchHandlerOpt.map(RestHandler::supportsStreaming).orElse(false)) {
     * Set the initial maximum data limit for remote bidirectional streams (in bytes).
    );
import org.opensearch.core.common.unit.ByteSizeValue;
        }
     * Handles incoming Reactor Netty request
                public Channel channel() {
     * @param cause exception occurred
         */
    protected void doStart() {
 * SPDX-License-Identifier: Apache-2.0
            super.onException(channel, cause);
import reactor.netty.DisposableChannel;
             * increases the application's native memory footprint (as direct byte buffers hold their contents off-heap).
         */
                .httpRequestDecoder(
import org.opensearch.rest.RestRequest.Method;
        } catch (final RuntimeException ex) {
    public ReactorNetty4HttpServerTransport(
        this.maxInitialLineLength = SETTING_HTTP_MAX_INITIAL_LINE_LENGTH.get(settings);
                                .maxFieldSectionSize(maxHeaderSize.bytesAsInt())
import org.reactivestreams.Publisher;
                public void disposeNow() {
        100L,
                this,
                        configured = configured.childOption(
    public ReactorNetty4HttpServerTransport(
import org.opensearch.common.settings.ClusterSettings;
import reactor.netty.http.server.HttpServer;
        final HttpServer http11or2 = configureHttp11orHttp2(
        HttpChannel newHttpChannel(HttpServerRequest request, HttpServerResponse response, FluxSink<HttpContent> emitter) {
public class ReactorNetty4HttpServerTransport extends AbstractHttpServerTransport {
        this.connectTimeoutMillis = Math.toIntExact(SETTING_HTTP_CONNECT_TIMEOUT.get(settings).getMillis());
                                .maxStreamsBidirectional(SETTING_H3_MAX_STREAMS.get(settings).longValue())
                        .handle((req, res) -> incomingRequest(req, res))
        final Optional<RestHandler> dispatchHandlerOpt = dispatcher.dispatchHandler(
import io.netty.channel.ChannelInboundHandlerAdapter;
        this.readTimeoutMillis = Math.toIntExact(SETTING_HTTP_READ_TIMEOUT.get(settings).getMillis());
        void close(HttpChannel httpChannel) {
     * @param request request instance
        ThreadPool threadPool,
        // does respect it for H2C and HTTP/1.1)
     */
import org.opensearch.common.network.NetworkService;
     * @param xContentRegistry XContent registry instance
                ).build();
            return new ReactorNetty4CompositeHttpServerChannel(http11or2Server.channel(), http3Server.channel());
                        .bindAddress(() -> socketAddress)
import org.apache.logging.log4j.Logger;
                response
    HttpChannel newNonStreamingHttpChannel(HttpServerRequest request, HttpServerResponse response, FluxSink<HttpContent> emitter) {
        /**
        },
    }
    /**
        if (http3Opt.isEmpty()) {
import static org.opensearch.http.HttpTransportSettings.SETTING_HTTP_TCP_KEEP_IDLE;
            parameters.flatMap(SecureHttpTransportParameters::clientAuth)
         */
import org.opensearch.common.settings.Settings;
        this.h2cMaxContentLength = SETTING_H2C_MAX_CONTENT_LENGTH.get(settings);
     * @param tracer tracer instance
            .childOption(ChannelOption.SO_KEEPALIVE, SETTING_HTTP_TCP_KEEP_ALIVE.get(settings));
import io.netty.handler.timeout.ReadTimeoutException;
        );
                .switchIfEmpty(Mono.just(DefaultLastHttpContent.EMPTY_LAST_CONTENT))
                            SETTING_HTTP_TCP_KEEP_INTERVAL.get(settings)
     *
            configured = configured.childOption(ChannelOption.SO_SNDBUF, Math.toIntExact(tcpSendBufferSize.getBytes()));
    /**
    @Override
    private final int connectTimeoutMillis;
import java.util.Set;
     * and eventually could cause out of memory.
        final ByteSizeValue tcpSendBufferSize = SETTING_HTTP_TCP_SEND_BUFFER_SIZE.get(settings);
    private static void disposeQuietly(final DisposableChannel disposable) {
import static org.opensearch.http.HttpTransportSettings.SETTING_HTTP_MAX_CHUNK_SIZE;
                        )
    @Override
        }
            }
                .ifPresent(clientAuth -> sslContextBuilder.clientAuth(ClientAuth.valueOf(clientAuth)));
     * is closed only when the Netty channel it is attached to is closed.
        }
             * We assume here that OpenSearch receives HTTP requests via an Ethernet connection which has a MTU of 1500 bytes.
        hostChannels.clear();
            Netty4Utils.addListener(channel.closeFuture(), closeContext);
        private final Channel channel;
import static org.opensearch.http.HttpTransportSettings.SETTING_HTTP_MAX_HEADER_SIZE;
             * Netty accumulates buffers containing data from all incoming network packets that make up one HTTP request in an instance of
            bigArrays,
        final ByteSizeValue tcpReceiveBufferSize = SETTING_HTTP_TCP_RECEIVE_BUFFER_SIZE.get(settings);
    public void serverAcceptedChannel(HttpChannel httpChannel) {
        }
     * connections as it leads to explosion of {@link HttpChannel} instances that are tracked by {@link AbstractHttpServerTransport}
import org.opensearch.transport.netty4.Netty4Utils;
     * Extension point that allows a NetworkPlugin to override the default netty HttpContentDecompressor
import static org.opensearch.http.HttpTransportSettings.SETTING_HTTP_MAX_INITIAL_LINE_LENGTH;
     * @param channel HTTP channel
        * @return new {@link HttpChannel} instance
        this(
    private static final ByteSizeValue MTU = new ByteSizeValue(Long.parseLong(System.getProperty("opensearch.net.mtu", "1500")));
        final boolean reuseAddress = SETTING_HTTP_TCP_REUSE_ADDRESS.get(settings);
            disposableServer = null;
            // Netty's CompositeByteBuf implementation does not allow less than two components.
                                .maxInitialLineLength(maxInitialLineLength.bytesAsInt())
    ) {
                final FullHttpResponse r = (FullHttpResponse) hc;
             * io.netty.buffer.CompositeByteBuf (think of it as a buffer of buffers). Once its capacity is reached, the buffer will iterate
                request,
    );
    private final ByteSizeValue maxHeaderSize;
import reactor.core.scheduler.Schedulers;
            ByteSizeValue maxContentLength = SETTING_HTTP_MAX_CONTENT_LENGTH.get(s);
import reactor.netty.Connection;
import reactor.core.publisher.Mono;
                        // ACCEPT is currently the only mode supported by both OpenSsl and JDK providers.
            disposableServer = new DisposableServer() {
        public void close() {
                .orElseThrow(() -> new OpenSearchException("The KeyManagerFactory instance is not provided"));
            // clamp value to the allowed range
                }
        configured = configured.option(ChannelOption.SO_REUSEADDR, reuseAddress);
                request,
                r.headers().forEach(h -> response.addHeader(h.getKey(), h.getValue()));
import org.opensearch.plugins.SecureHttpTransportSettingsProvider.SecureHttpTransportParameters;
        return new HttpContentDecompressor(UNLIMITED_DECOMPRESSOR_BUFFER);
                        ApplicationProtocolConfig.Protocol.ALPN,
     */
    );
        Dispatcher dispatcher,
     */
import io.netty.handler.ssl.SslContextBuilder;
                .orElseThrow(() -> new OpenSearchException("The KeyManagerFactory instance is not provided"));
        if (request.uri().length() > maxInitialLineLength.bytesAsInt()) {
     * Used in instances to conditionally decompress depending on the outcome from header verification.
                                .h2cMaxContentLength(h2cMaxContentLength.bytesAsInt())
                "http-form-decoder"
        Property.NodeScope
             *
    /**
        this.maxChunkSize = SETTING_HTTP_MAX_CHUNK_SIZE.get(settings);
     * By default the server will reject an upgrade request with non-empty content,
     * Configure the maximum length of the content of the HTTP/2.0 clear-text upgrade request.
     * @param xContentRegistry XContent registry instance
        "h2c.max_content_length",
         * Creates and binds new {@link HttpChannel} instance to this channel group
     * @param bigArrays big array allocator
import java.util.Arrays;
            if (disposable != null) {
            httpChannels.remove(httpChannel);
        "h3.max_stream_local_length",
        this.maxHeaderSize = SETTING_HTTP_MAX_HEADER_SIZE.get(settings);
import java.net.SocketOption;
        try {
        }
import io.netty.handler.codec.quic.QuicSslContextBuilder;
             * for implementation details). We want to to resize that buffer because this leads to additional garbage on the heap and also
                    io.netty.handler.codec.http3.Http3.supportedApplicationProtocols()
        "h2.max_concurrent_streams",
            tracer
    }
    }
         * Unbinds {@link HttpChannel} instance
         */
        }
        request.withConnection(c -> connection[0] = c);
                @Override
        new ByteSizeValue(65536, ByteSizeUnit.KB),
             * over its individual entries and put them into larger buffers (see io.netty.buffer.CompositeByteBuf#consolidateIfNeeded()
     * Binds the transport engine to the socket address
     *
import org.opensearch.http.HttpChannel;
        ClusterSettings clusterSettings,
            // Netty logs a warning if it can't set the option, so try this only on supported platforms
    private final SecureHttpTransportSettingsProvider secureHttpTransportSettingsProvider;
            final SslContext sslContext = sslContextBuilder.protocols(
     */
        * @param request HTTP request
        /**
            final ReactorNetty4StreamingRequestConsumer<HttpContent> consumer = new ReactorNetty4StreamingRequestConsumer<>(
import io.netty.handler.codec.http.FullHttpResponse;
    /**
        } else {
                this,
import static org.opensearch.http.HttpTransportSettings.SETTING_HTTP_MAX_CONTENT_LENGTH;
    @Override
            request.receiveContent()
    /**
        } else {
import java.util.Map;
                maxCompositeBufferComponents
        "h3.max_stream_remote_length",
            });
                if (SETTING_HTTP_TCP_KEEP_COUNT.get(settings) >= 0) {
                response,
    public void onException(HttpChannel channel, Exception cause) {
     * @param threadPool thread pool instance
         * Checks if underlying Netty channel is open
                                .maxStreamDataBidirectionalRemote(SETTING_H3_MAX_STREAM_REMOTE_LENGTH.get(settings).getBytes())
        }
    }
        // At least now, Reactor Netty does not respect maxInitialLineLength setting for HTTP/2 (but
import org.opensearch.common.util.BigArrays;
            configured = configured.childOption(ChannelOption.SO_RCVBUF, Math.toIntExact(tcpReceiveBufferSize.getBytes()));
        }
                .http2Settings(spec -> spec.maxHeaderListSize(maxHeaderSize.bytesAsInt()).maxConcurrentStreams(h2MaxConcurrentStreams))
    static final class HostChannel implements CloseableChannel {
import static org.opensearch.http.HttpTransportSettings.SETTING_HTTP_TCP_SEND_BUFFER_SIZE;
            configured = configured.secure(spec -> spec.sslContext(sslContext)).protocol(HttpProtocol.HTTP11, HttpProtocol.H2);
    public static final Setting<Long> SETTING_H3_MAX_STREAMS = Setting.longSetting("h3.max_streams", 100L, Property.NodeScope);
import java.util.Optional;
        private final CompletableContext<Void> closeContext = new CompletableContext<>();
        }
    /**
        SharedGroupFactory sharedGroupFactory,
                    if (keepIdleOption != null) {
import org.opensearch.core.xcontent.NamedXContentRegistry;
    public static final Setting<Long> SETTING_H2_MAX_CONCURRENT_STREAMS = Setting.longSetting(
                        configured = configured.childOption(NioChannelOption.of(keepIdleOption), SETTING_HTTP_TCP_KEEP_IDLE.get(settings));
                        .http3Settings(
    }
    private HttpServer configureHttp11orHttp2(final HttpServer server) throws Exception {
    /**
             * number of buffers that are needed depend on how often Netty reads network packets which depends on the network type (MTU).
            sharedGroup = sharedGroupFactory.getHttpGroup();
    /**
     */
     * @param sharedGroupFactory shared group factory
    }
import reactor.core.publisher.FluxSink;
                        .h2cMaxContentLength(h2cMaxContentLength.bytesAsInt())
                        .maxHeaderSize(maxHeaderSize.bytesAsInt())
                        .runOn(sharedGroup.getLowLevelGroup())
            clusterSettings,
import java.time.Duration;
     *
    }
                .handle((req, res) -> incomingRequest(req, res))
     */
     * @param settings settings
                if (SETTING_HTTP_TCP_KEEP_IDLE.get(settings) >= 0) {
                        ApplicationProtocolConfig.SelectedListenerFailureBehavior.ACCEPT,
            final SslContextBuilder sslContextBuilder = SslContextBuilder.forServer(keyManagerFactory);
        }
    /**
import reactor.netty.http.server.HttpServerResponse;
                    )
        NetworkService networkService,
     * separate the lifecycle of those: {@link HttpChannel} is closed upon every response delivered whereas {@link HostChannel}
                .subscribe(consumer, error -> {}, () -> consumer.accept(DefaultLastHttpContent.EMPTY_LAST_CONTENT));
     * @param bigArrays big array allocator
        }
        if (scheduler != null) {
import static org.opensearch.http.HttpTransportSettings.SETTING_HTTP_TCP_RECEIVE_BUFFER_SIZE;
                parameters.map(SecureHttpTransportParameters::protocols).orElseGet(() -> Arrays.asList(SslUtils.DEFAULT_SSL_PROTOCOLS))
            final Optional<SecureHttpTransportParameters> parameters = secureHttpTransportSettingsProvider.parameters(settings);
        } else {
            }
        final Method method = HttpConversionUtil.convertMethod(request.method());
import org.opensearch.common.util.io.IOUtils;
    protected ChannelInboundHandlerAdapter createDecompressor() {
     * @param response HTTP response
            final ReactorNetty4NonStreamingHttpChannel httpChannel = new ReactorNetty4NonStreamingHttpChannel(
     */
    private final Map<Channel, HostChannel> hostChannels = new ConcurrentHashMap<>();
     * @param clusterSettings cluster settings
        Property.NodeScope
        Netty4Utils.setAvailableProcessors(OpenSearchExecutors.NODE_PROCESSORS_SETTING.get(settings));
                        .doOnConnection(conn -> conn.addHandlerFirst(NettyPipeline.HttpDecompressor, createDecompressor()))
    /**
    @Override
             * With this setting we control the CompositeByteBuf's capacity (which is by default 1024, see
        try {
     */
                .ifPresent(ciphers -> sslContextBuilder.ciphers(ciphers, SupportedCipherSuiteFilter.INSTANCE));
            );
    public static final Setting<ByteSizeValue> SETTING_H3_MAX_STREAM_LOCAL_LENGTH = Setting.byteSizeSetting(
import org.opensearch.common.Randomness;
import org.opensearch.telemetry.tracing.Tracer;
import io.netty.handler.ssl.ApplicationProtocolConfig;
            dispatcher,
        NamedXContentRegistry xContentRegistry,
                    disposeQuietly(http3Server);
                    }
        final HostChannel hostChannel = hostChannels.computeIfAbsent(channel, key -> new HostChannel(key));
    private final ByteSizeValue maxChunkSize;
 *
             */
        } catch (Exception e) {
                    disposeQuietly(http11or2Server);
                        ApplicationProtocolNames.HTTP_1_1
import org.opensearch.rest.RestHandler;
            method,
        return Optional.empty();
            if (success == false) {
            xContentRegistry,
            return response.sendObject(consumer);
        new ByteSizeValue(1000000, ByteSizeUnit.BYTES),
                response.trailerHeaders(c -> r.trailingHeaders().forEach(h -> c.add(h.getKey(), h.getValue())));
     * @param sharedGroupFactory shared group factory
                @Override
            sharedGroup = null;
import org.opensearch.common.settings.Setting.Property;
     */
                        .allowPartialChunks(false)
            disposableServer = http11or2.bindNow();
        try {
    }
            configured = configured.protocol(HttpProtocol.HTTP11, HttpProtocol.H2C);
/**
        NamedXContentRegistry xContentRegistry,
            HttpServer.create()
import org.opensearch.common.Nullable;
             * The tradeoff is between less (but larger) buffers that are contained in the CompositeByteBuf and more (but smaller) buffers.
import org.opensearch.http.HttpServerChannel;
                            spec -> spec.maxChunkSize(maxChunkSize.bytesAsInt())
     * The maximum number of composite components for request accumulation
    private static final int UNLIMITED_DECOMPRESSOR_BUFFER = 0;
                        .protocol(HttpProtocol.HTTP3)
    private Optional<HttpServer> configureHttp3(InetSocketAddress socketAddress) throws Exception {
            super.onException(channel, new HttpReadTimeoutException(readTimeoutMillis, cause));
import org.opensearch.http.netty4.http3.SecureQuicTokenHandler;
        ThreadPool threadPool,
import org.opensearch.OpenSearchException;
                        );
import io.netty.buffer.ByteBuf;
     * Creates new HTTP transport implementations based on Reactor Netty (see please {@link HttpServer}).
             * Note that we are *not* pre-allocating any memory based on this setting but rather determine the CompositeByteBuf's capacity.
        );
         * @param httpChannel {@link HttpChannel} instance
                this,
    );
import java.net.InetSocketAddress;
            if (IOUtils.LINUX || IOUtils.MAC_OS_X) {
                .readTimeout(Duration.ofMillis(readTimeoutMillis))
    public static final Setting<Integer> SETTING_HTTP_WORKER_COUNT = Setting.intSetting("http.netty.worker_count", 0, Property.NodeScope);
        }
        if (secureHttpTransportSettingsProvider != null) {
        @Override
 */
                .idleTimeout(Duration.ofMillis(connectTimeoutMillis))
 * this file be licensed under the Apache-2.0 license or a
        return hostChannel.newHttpChannel(request, response, emitter);
                    new ApplicationProtocolConfig(
    private final SharedGroupFactory sharedGroupFactory;
        if (tcpReceiveBufferSize.getBytes() > 0) {
        @Override
 */
import org.opensearch.http.AbstractHttpServerTransport;
        final Channel channel = connection[0].channel();
import io.netty.handler.codec.http.DefaultLastHttpContent;
     * Exception handler
                final ByteBuf content = r.content().copy();
     */
        if (cause instanceof ReadTimeoutException) {
    /**
import org.opensearch.common.network.CloseableChannel;
            )
                )
            return response.status(HttpResponseStatus.REQUEST_URI_TOO_LONG).send();
     *
import org.opensearch.core.action.ActionListener;
import javax.net.ssl.KeyManagerFactory;
            final ReactorNetty4NonStreamingRequestConsumer<HttpContent> consumer = new ReactorNetty4NonStreamingRequestConsumer<>(
    private static final String SETTING_KEY_HTTP_NETTY_MAX_COMPOSITE_BUFFER_COMPONENTS = "http.netty.max_composite_buffer_components";
        // different protocols (UDP, TCP)
            }
import reactor.netty.http.HttpProtocol;
import java.util.Collections;
            );
            );
    private final long h2MaxConcurrentStreams;
                )
                parameters.flatMap(SecureHttpTransportParameters::clientAuth)
        Dispatcher dispatcher,
             * io.netty.handler.codec.MessageAggregator#DEFAULT_MAX_COMPOSITEBUFFER_COMPONENTS). To determine a proper default capacity for
            closeContext.addListener(ActionListener.toBiConsumer(listener));
    }
        if (disposableServer != null) {
        BigArrays bigArrays,
                        )
import static org.opensearch.http.HttpTransportSettings.SETTING_HTTP_TCP_KEEP_INTERVAL;
                        configured = configured.childOption(
import reactor.core.scheduler.Scheduler;
                .doOnConnection(conn -> conn.addHandlerFirst(NettyPipeline.HttpDecompressor, createDecompressor()))
        }
                    if (keepCountOption != null) {
     * @param secureHttpTransportSettingsProvider secure HTTP transport settings provider
     */
     * Called to tear down internal resources
        * @param emitter {@link HttpContent} emitter
                .applicationProtocolConfig(
     * @param dispatcher dispatcher instance
                disposable.disposeNow();
                        .readTimeout(Duration.ofMillis(readTimeoutMillis))
    /**
            throw new IllegalStateException("Failed to obtain connection from HttpServerRequest");
import static org.opensearch.http.HttpTransportSettings.SETTING_HTTP_HTTP3_ENABLED;
     * @return response publisher
        Property.NodeScope
import org.opensearch.common.concurrent.CompletableContext;
        (s) -> {
                response.status(r.status());
        hostChannel.addCloseListener(ActionListener.wrap(() -> hostChannels.remove(channel)));
    }
        } finally {
 * The HTTP transport implementations based on Reactor Netty (see please {@link HttpServer}).
     * a non-GET upgrade request, {@link #h2cMaxContentLength} specifies the maximum
            return new ReactorNetty4HttpServerChannel(disposableServer.channel());
            );
            };
                    }
                    }
     * @param request HTTP request
            parameters.flatMap(SecureHttpTransportParameters::trustManagerFactory).ifPresent(sslContextBuilder::trustManager);
        this.secureHttpTransportSettingsProvider = secureHttpTransportSettingsProvider;
     * concurrent bidirectional streams at a time, to avoid reducing performance
        * @param response HTTP response
    public static Setting<Integer> SETTING_HTTP_NETTY_MAX_COMPOSITE_BUFFER_COMPONENTS = new Setting<>(
import static org.opensearch.http.HttpTransportSettings.SETTING_HTTP_TCP_REUSE_ADDRESS;
import io.netty.handler.ssl.ApplicationProtocolNames;
                response,
     */
    private volatile DisposableServer disposableServer;
                    HttpServer.create()
        new ByteSizeValue(1000000, ByteSizeUnit.BYTES),
            request.uri(),
                );
    /**
import static org.opensearch.http.HttpTransportSettings.SETTING_HTTP_TCP_NO_DELAY;
            bindServer();
                            spec -> spec.tokenHandler(new SecureQuicTokenHandler(Randomness.createSecure()))
                        .secure(spec -> spec.sslContext(sslContext))
     *
        BigArrays bigArrays,
import org.opensearch.http.HttpReadTimeoutException;
        }
    /**
import io.netty.handler.codec.http.HttpResponseStatus;
    private final ByteSizeValue maxInitialLineLength;
     * Quietly disposes the channel.
    protected void stopInternal() {
    /**
                    .ifPresent(clientAuth -> sslContextBuilder.clientAuth(ClientAuth.valueOf(clientAuth)));
    protected Publisher<Void> incomingRequest(HttpServerRequest request, HttpServerResponse response) {
                Schedulers.DEFAULT_BOUNDED_ELASTIC_QUEUESIZE,
    );
                    final SocketOption<Integer> keepIntervalOption = NetUtils.getTcpKeepIntervalSocketOptionOrNull();
                                .maxStreamDataBidirectionalLocal(SETTING_H3_MAX_STREAM_LOCAL_LENGTH.get(settings).getBytes())
        if (connection[0] == null) {
                .compress(true)
    @Override
        SETTING_KEY_HTTP_NETTY_MAX_COMPOSITE_BUFFER_COMPONENTS,
            // Do nothing
     * by reducing parallelism.
package org.opensearch.http.reactor.netty4;
                            SETTING_HTTP_TCP_KEEP_COUNT.get(settings)
    private final int readTimeoutMillis;
     * @return new {@link HttpChannel} instance
        // Configure SSL context if available
        boolean success = false;
                if (SETTING_HTTP_TCP_KEEP_INTERVAL.get(settings) >= 0) {
        Property.NodeScope
        this.h2MaxConcurrentStreams = SETTING_H2_MAX_CONCURRENT_STREAMS.get(settings);
                channel.close();
                Schedulers.DEFAULT_BOUNDED_ELASTIC_SIZE,
        ClusterSettings clusterSettings,
        // Configure SSL context if available
        Tracer tracer
        }
                .runOn(sharedGroup.getLowLevelGroup())
                        .httpRequestDecoder(
                    final SocketOption<Integer> keepIdleOption = NetUtils.getTcpKeepIdleSocketOptionOrNull();
                final QuicSslContextBuilder sslContextBuilder = QuicSslContextBuilder.forServer(keyManagerFactory, null);
        }
     * @param socketAddress socket address to bind to
        HostChannel(Channel channel) {
import org.apache.logging.log4j.LogManager;
        final HttpResponseHeadersFactory responseHeadersFactory = HttpResponseHeadersFactories.newDefault(settings, this);
                        .idleTimeout(Duration.ofMillis(connectTimeoutMillis))
        if (tcpSendBufferSize.getBytes() > 0) {
                        .httpFormDecoder(builder -> builder.scheduler(scheduler))
     *
            parameters.map(SecureHttpTransportParameters::cipherSuites)
     *
            if (Http3Utils.isHttp3Available() && SETTING_HTTP_HTTP3_ENABLED.get(settings).booleanValue() == true) {
import io.netty.handler.ssl.SslContext;
     * over Netty channel all the time and runs request / response conversation over it. It does not work well with persistent
             *
                            NioChannelOption.of(keepCountOption),
            return httpChannel;
import reactor.netty.DisposableServer;
                .subscribe(consumer);
            /*
            incomingStream(new ReactorNetty4HttpRequest(request, responseHeadersFactory), consumer.httpChannel());
            }
 * compatible open source license.
            CloseableChannel.closeChannels(new ArrayList<>(hostChannels.values()), true);
        public boolean isOpen() {
import io.netty.handler.codec.http.HttpContentDecompressor;
import java.util.ArrayList;
            scheduler = null;
     * is closed only when the Netty channel it is attached to is closed.
        if (secureHttpTransportSettingsProvider != null) {
                return Optional.of(
        }
        /**
import io.netty.handler.codec.http.HttpContent;
                }
        super(settings, networkService, bigArrays, threadPool, xContentRegistry, dispatcher, clusterSettings, tracer);
            return String.valueOf(maxBufferComponents);
        }
                request,
            long maxBufferComponentsEstimate = Math.round((double) (maxContentLength.getBytes() / MTU.getBytes()));
                Netty4Utils.addListener(channel.close(), closeContext);
        );
        SharedGroupFactory sharedGroupFactory,
                doStop(); // otherwise we leak threads since we never moved to started
     */
        if (SETTING_HTTP_TCP_KEEP_ALIVE.get(settings)) {
        } else {
        configured = configured.childOption(ChannelOption.SO_REUSEADDR, reuseAddress);
            closeContext.addListener((v, ex) -> { httpChannels.forEach(HttpChannel::close); });
    }
            request.fullPath(),
        // The HTTP/3 server binds to the same port as HTTP/2 or HTTP/1.1 since those are
            disposeQuietly(disposableServer);
