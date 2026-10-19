        return options.toArray(new CompressionOptions[0]);
import org.apache.logging.log4j.Logger;
        final Optional<TransportAdapterProvider<HttpServerTransport>> decompressorProviderOpt = secureHttpTransportSettingsProvider
            this.transport = transport;
        "h3.max_stream_local_length",
        final Dispatcher dispatcher,
            final Channel parent = parent(ctx.channel());
     * @param compressionLevel
            success = true;
import io.netty.handler.codec.http.HttpContentDecompressor;
 * The HTTP/3 transport implementations based on Netty 4.
    @Override
        if (cause0 instanceof DecoderException) {
        Netty4Utils.setAvailableProcessors(OpenSearchExecutors.NODE_PROCESSORS_SETTING.get(settings));
                return parent(channel.parent());
            sharedGroup = sharedGroupFactory.getHttpGroup();
    protected static final AttributeKey<SSLEngine> HTTP_SERVER_ENGINE_KEY = AttributeKey.newInstance("opensearch-quic-server-ssl-engine");
                            // Called for each connection
        );
            aggregator.setMaxCumulationBufferComponents(transport.maxCompositeBufferComponents);
            .filter(Optional::isPresent)
import io.netty.channel.Channel;
     * concurrent bidirectional streams at a time, to avoid reducing performance
     * Used in instances to conditionally decompress depending on the outcome from header verification
        }
            protected void initChannel(Channel ch) throws Exception {
                    .orElseThrow(() -> new OpenSearchException("The KeyManagerFactory instance is not provided"));
    private final TransportAdapterProvider<HttpServerTransport> decompressorProvider;
    private volatile SharedGroupFactory.SharedGroup sharedGroup;
     * Set the initial maximum stream limit for bidirectional streams.
import io.netty.handler.codec.http3.Http3Settings;
        logger.error("Exception during establishing a HTTP/3 connection: " + cause, cause);
                    .addLast(
import org.opensearch.http.AbstractHttpServerTransport;
import io.netty.util.AttributeKey;
        return this.settings;
            ch.pipeline().addLast("decoder_compress", transport.createDecompressor());
            .filter(p -> SecureHttpTransportSettingsProvider.REQUEST_HEADER_VERIFIER.equalsIgnoreCase(p.name()))
     * @param sharedGroupFactory shared group factory
        final DeflateOptions deflateOptions = StandardCompressionOptions.deflate(compressionLevel, windowBits, memLevel);
        }
            @Override
     *        memory usage.  The default value is {@code 15}.
        final List<CompressionOptions> options = new ArrayList<CompressionOptions>(4);
                final Http3Settings http3Settings = new Http3Settings();
    private final int readTimeoutMillis;
     * Extension point that allows a NetworkPlugin to extend the netty pipeline and inspect headers after request decoding
        options.add(deflateOptions);
        }
            }
import org.opensearch.threadpool.ThreadPool;
                    .handler(new ChannelInitializer<QuicChannel>() {
        "opensearch-quic-server-channel"
}
import io.netty.handler.codec.quic.QuicSslContext;
        }
            }
 * SPDX-License-Identifier: Apache-2.0
import java.util.stream.Collectors;
    }
                HttpResponseHeadersFactories.newHttp2Aware(transport.settings, transport)
import io.netty.handler.timeout.ReadTimeoutException;
     * Set the initial maximum data limit for remote bidirectional streams (in bytes).
     *
/**
            } else {
            } else if (channel instanceof NioDatagramChannel ndc) {
    private final ByteSizeValue maxChunkSize;
                parameters.flatMap(SecureHttpTransportParameters::clientAuth)
            this.handlingSettings = handlingSettings;
     */
        new ByteSizeValue(1000000, ByteSizeUnit.BYTES),
    }
import static org.opensearch.http.HttpTransportSettings.SETTING_PIPELINING_MAX_EVENTS;
     * @param windowBits
    /**
            return new ChannelInboundHandlerAdapter();
import org.opensearch.common.settings.Setting;
        return httpServerChannel;
            ch.pipeline().addLast(new Http3FrameToHttpObjectCodec(true));
        private final Netty4HttpRequestHandler requestHandler;
        options.add(StandardCompressionOptions.snappy());
                    .initialMaxStreamsBidirectional(SETTING_H3_MAX_STREAMS.get(settings).longValue())
    private final ByteSizeValue maxInitialLineLength;
            maxInitialLineLength,
     *        state.  {@code 1} uses minimum memory and {@code 9} uses maximum
                doStop(); // otherwise we leak threads since we never moved to started
                    })
     * which by default {@link NettyAllocator} does not provide.
                + "receive_predictor[{}], max_composite_buffer_components[{}]",
import org.opensearch.http.netty4.http3.SecureQuicTokenHandler;
import org.opensearch.common.settings.Setting.Property;
    protected ChannelInboundHandlerAdapter createHeaderVerifier() {
        private final NettyByteBufSizer byteBufSizer;
    /**
        ByteSizeValue receivePredictor = SETTING_HTTP_NETTY_RECEIVE_PREDICTOR_SIZE.get(settings);
import io.netty.handler.codec.http.HttpObjectAggregator;
                        new HttpContentCompressor(defaultCompressionOptions(handlingSettings.getCompressionLevel()))
            maxChunkSize,
            bootstrap.option(ChannelOption.ALLOCATOR, NettyAllocator.getAllocator(true));
                        @Override
import org.opensearch.http.HttpReadTimeoutException;
import io.netty.handler.codec.quic.QuicChannel;
            );
        return defaultCompressionOptions(compressionLevel, 15, 8);
            } else {
     * by reducing parallelism.
            bootstrap.channel(NioDatagramChannel.class);
            configurePipeline(ch);
        logger.debug(
import static org.opensearch.http.netty4.Netty4HttpServerTransport.SETTING_HTTP_NETTY_MAX_COMPOSITE_BUFFER_COMPONENTS;
        }
import static org.opensearch.http.HttpTransportSettings.SETTING_HTTP_MAX_CHUNK_SIZE;
import io.netty.channel.FixedRecvByteBufAllocator;
    private volatile Bootstrap bootstrap;
                                        null,
            }
            .orElse(TransportExceptionHandler.NOOP);
            receivePredictor,
import javax.net.ssl.SSLEngine;
                                    new Http3ServerConnectionHandler(
        public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        }
     * @param networkService network service
        final BigArrays bigArrays,
            bindServer();
            final HttpObjectAggregator aggregator = new HttpObjectAggregator(handlingSettings.getMaxContentLength());
     *
     *        compression level is {@code 6}.
     */
    }
        Netty4HttpServerChannel httpServerChannel = new Netty4HttpServerChannel(channel);
     * @return default compression options
        final NetworkService networkService,
/*
    private final RecvByteBufAllocator recvByteBufAllocator;
import org.opensearch.plugins.SecureHttpTransportSettingsProvider.SecureHttpTransportParameters;
     * although zstd-jni is on the classpath, {@link ZstdEncoder} requires direct buffers support
import org.opensearch.plugins.TransportExceptionHandler;
import javax.net.ssl.KeyManagerFactory;
    }
        final SecureHttpTransportSettingsProvider secureHttpTransportSettingsProvider,
     * @param settings settings
    protected void stopInternal() {
            ch.attr(HTTP_CHANNEL_KEY).set(nettyHttpChannel);
import static org.opensearch.http.HttpTransportSettings.SETTING_HTTP_MAX_INITIAL_LINE_LENGTH;
        protected HttpChannelHandler(final Netty4Http3ServerTransport transport, final HttpHandlingSettings handlingSettings) {
import io.netty.handler.codec.quic.QuicStreamChannel;
import io.netty.channel.ChannelHandlerContext;
        this.headerVerifier = headerVerifiers.isEmpty() ? null : headerVerifiers.get(0);
    public Settings settings() {
    private final SharedGroupFactory sharedGroupFactory;
    private final int maxCompositeBufferComponents;
                return Optional.empty();
    private static CompressionOptions[] defaultCompressionOptions(int compressionLevel, int windowBits, int memLevel) {
        }
        recvByteBufAllocator = new FixedRecvByteBufAllocator(receivePredictor.bytesAsInt());
                transport.onServerException(httpServerChannel, (Exception) cause);
    public void onException(HttpChannel channel, Exception cause0) {
import io.netty.handler.codec.http3.Http3;
        if (headerVerifiers.size() > 1) {
        } finally {
                return SecureHttpTransportSettingsProvider.REQUEST_DECOMPRESSOR;
            .filter(p -> SecureHttpTransportSettingsProvider.REQUEST_DECOMPRESSOR.equalsIgnoreCase(p.name()))
    protected void doStart() {
                final QuicSslContext sslContext = sslContextBuilder.applicationProtocols(
            return requestHandler;
            settings
        private final Netty4HttpResponseCreator responseCreator;
        final GzipOptions gzipOptions = StandardCompressionOptions.gzip(compressionLevel, windowBits, memLevel);
import io.netty.channel.RecvByteBufAllocator;
                final Optional<SecureHttpTransportParameters> parameters = secureHttpTransportSettingsProvider.parameters(settings);
    }
     */
                final KeyManagerFactory keyManagerFactory = parameters.flatMap(SecureHttpTransportParameters::keyManagerFactory)
    @Override
import org.opensearch.common.Randomness;
        this.maxCompositeBufferComponents = SETTING_HTTP_NETTY_MAX_COMPOSITE_BUFFER_COMPONENTS.get(settings);
        } else {
import org.opensearch.common.settings.Settings;
            bootstrap.option(ChannelOption.RECVBUF_ALLOCATOR, recvByteBufAllocator);
            super.onException(channel, new HttpReadTimeoutException(readTimeoutMillis, cause0));
    private final ByteSizeValue maxHeaderSize;
     * Creates new HTTP transport implementations based on Netty 4
import org.opensearch.http.HttpHandlingSettings;
    public static final Setting<ByteSizeValue> SETTING_H3_MAX_STREAM_LOCAL_LENGTH = Setting.byteSizeSetting(
                ch.pipeline().addLast(Http3.newQuicServerCodecBuilder().sslEngineProvider(q -> {
import org.apache.logging.log4j.LogManager;
            }
import org.opensearch.transport.TransportAdapterProvider;
import org.opensearch.common.network.NetworkService;
import io.netty.handler.codec.compression.StandardCompressionOptions;
            if (channel == null) {
     */
    }
     *        best compression.  {@code 0} means no compression.  The default
    public ChannelHandler configureServerChannelHandler() {
    private static final Logger logger = LogManager.getLogger(Netty4Http3ServerTransport.class);
    );
    /**
     * although zstd-jni is on the classpath, {@link ZstdEncoder} requires direct buffers support
import io.netty.handler.codec.compression.ZstdEncoder;
            }
            .stream()
    @Override
            ch.pipeline().addLast("byte_buf_sizer", byteBufSizer);
        private NioDatagramChannel parent(Channel channel) {
            final Netty4HttpChannel nettyHttpChannel = new Netty4HttpChannel(ch, HTTP_SERVER_ENGINE_KEY);
        }
        }
            options.add(StandardCompressionOptions.brotli());
    }
            if (handlingSettings.isCompression()) {
    public static final AttributeKey<Netty4HttpChannel> HTTP_CHANNEL_KEY = AttributeKey.newInstance("opensearch-quic-channel");
     *        value should be in the range {@code 9} to {@code 15} inclusive.
                    return engine;
                                    )
import org.opensearch.common.settings.ClusterSettings;
            cause = cause0.getCause();
import org.opensearch.OpenSearchException;
        this.maxInitialLineLength = SETTING_HTTP_MAX_INITIAL_LINE_LENGTH.get(settings);
            sharedGroup.shutdown();
import org.opensearch.transport.NettyByteBufSizer;
        @Override
     * @param compressionLevel
                    q.attr(HTTP_SERVER_ENGINE_KEY).set(engine);
    public Netty4Http3ServerTransport(
     * @param dispatcher dispatcher instance
                final QuicSslContextBuilder sslContextBuilder = QuicSslContextBuilder.forServer(keyManagerFactory, null);
import io.netty.handler.codec.compression.DeflateOptions;
    }
                return null;
        options.add(gzipOptions);
            throw new IllegalArgumentException("Cannot have more than one header verifier configured, supplied " + headerVerifiers.size());
        this.sharedGroupFactory = sharedGroupFactory;
    protected ChannelInboundHandlerAdapter createDecompressor() {
        ChannelFuture future = bootstrap.bind(socketAddress).sync();
                    final QuicSslEngine engine = sslContext.newEngine(q.alloc());
        }
    private final int connectTimeoutMillis;
            .findFirst();
                parameters.flatMap(SecureHttpTransportParameters::trustManagerFactory).ifPresent(sslContextBuilder::trustManager);
import org.opensearch.transport.NettyAllocator;
        private final Netty4Http3ServerTransport transport;
                            ch.pipeline()
            .map(p -> p.create(settings, this, ChannelInboundHandlerAdapter.class))
            this.responseCreator = new Netty4HttpResponseCreator();
        boolean success = false;
 * compatible open source license.
     *        compression level is {@code 6}.
import org.opensearch.plugins.SecureHttpTransportSettingsProvider;
            ch.pipeline().addLast("handler", requestHandler);
                    );
    }
        this.secureHttpTransportSettingsProvider = secureHttpTransportSettingsProvider;
                                        null,
                        protected void initChannel(QuicChannel ch) {
import io.netty.handler.ssl.ClientAuth;
    /**
    /**
import org.opensearch.core.xcontent.NamedXContentRegistry;
import org.opensearch.transport.SharedGroupFactory;
     *        at the expense of memory usage.  The default value is {@code 8}
    @Override
     */
            }
     *        {@code 1} yields the fastest compression and {@code 9} yields the
            super.exceptionCaught(ctx, cause);
import io.netty.channel.ChannelInitializer;
            .collect(Collectors.toList());
     *        {@code 1} yields the fastest compression and {@code 9} yields the
            .stream()
        this.maxChunkSize = SETTING_HTTP_MAX_CHUNK_SIZE.get(settings);
        }
import java.util.Optional;
            this.requestCreator = new Netty4Http3RequestCreator(
    );
     *        memory.  Larger values result in better and faster compression
 */
     */
                    io.netty.handler.codec.http3.Http3.supportedApplicationProtocols()
            bootstrap.handler(configureServerChannelHandler());
        decompressorProviderOpt.ifPresent(p -> logger.debug("Using request decompressor provider: {}", p));
        super(settings, networkService, bigArrays, threadPool, xContentRegistry, dispatcher, clusterSettings, tracer);
            if (cause instanceof Error) {
import org.opensearch.transport.netty4.Netty4Utils;
        final NamedXContentRegistry xContentRegistry,
                                        new HttpChannelHandler(Netty4Http3ServerTransport.this, handlingSettings),
import io.netty.handler.codec.DecoderException;
     * @return default compression options
            maxContentLength,
        final Settings settings,
        if (sharedGroup != null) {
        private final HttpHandlingSettings handlingSettings;
        Throwable cause = cause0;
     */
            this.requestHandler = new Netty4HttpRequestHandler(transport, HTTP_CHANNEL_KEY);
import static org.opensearch.http.HttpTransportSettings.SETTING_HTTP_MAX_CONTENT_LENGTH;
import java.util.concurrent.TimeUnit;
            maxCompositeBufferComponents
            ch.pipeline().addLast("aggregator", aggregator);
    private final SecureHttpTransportSettingsProvider secureHttpTransportSettingsProvider;
import io.netty.channel.ChannelOption;
     *        How much memory should be allocated for the internal compression
import static org.opensearch.http.HttpTransportSettings.SETTING_HTTP_MAX_HEADER_SIZE;
        } else {
                                        true
import io.netty.handler.codec.http3.Http3ServerConnectionHandler;
                    .tokenHandler(new SecureQuicTokenHandler(Randomness.createSecure()))
    private final ChannelInboundHandlerAdapter headerVerifier;
                    .ifPresent(clientAuth -> sslContextBuilder.clientAuth(ClientAuth.valueOf(clientAuth)));
            this.byteBufSizer = new NettyByteBufSizer();
    protected static final AttributeKey<Netty4HttpServerChannel> HTTP_SERVER_CHANNEL_KEY = AttributeKey.newInstance(
    private static CompressionOptions[] defaultCompressionOptions(int compressionLevel) {
import io.netty.handler.codec.quic.QuicSslContextBuilder;
     * @param threadPool thread pool instance
            return headerVerifier;
    );
     *
                    .initialMaxData(SETTING_HTTP_MAX_CONTENT_LENGTH.get(settings).getBytes())
import io.netty.channel.socket.nio.NioDatagramChannel;
import io.netty.channel.ChannelInboundHandlerAdapter;
    ) {
    /**
     *
        if (cause instanceof ReadTimeoutException) {
import io.netty.bootstrap.Bootstrap;
        this.decompressorProvider = decompressorProviderOpt.orElseGet(() -> new TransportAdapterProvider<HttpServerTransport>() {
     * @param clusterSettings cluster settings
import io.netty.handler.codec.http.HttpContentCompressor;
                                .addLast(
            super.onException(channel, cause0);
                http3Settings.maxFieldSectionSize(maxHeaderSize.getBytes());
    private final int pipeliningMaxEvents;
import org.opensearch.core.common.unit.ByteSizeValue;
import org.opensearch.http.HttpServerTransport;
        private final Netty4Http3RequestCreator requestCreator;
    protected static class HttpChannelHandler extends ChannelInitializer<QuicStreamChannel> {
import io.netty.channel.ChannelFuture;
        this.exceptionHandler = secureHttpTransportSettingsProvider.buildHttpServerExceptionHandler(settings, this)
     * Set the initial maximum data limit for local bidirectional streams (in bytes).
import io.netty.handler.codec.compression.CompressionOptions;
        this.readTimeoutMillis = Math.toIntExact(SETTING_HTTP_READ_TIMEOUT.get(settings).getMillis());
            if (success == false) {
     * @param xContentRegistry XContent registry instance
                                        new DefaultHttp3SettingsFrame(http3Settings),
    }
        return decompressorProvider.create(settings, this, ChannelInboundHandlerAdapter.class).orElseGet(HttpContentDecompressor::new);
        Channel channel = future.channel();
        Property.NodeScope
            ExceptionsHelper.maybeDieOnAnotherThread(cause);
import io.netty.handler.codec.http3.Http3FrameToHttpObjectCodec;
                                );
                transport.onServerException(httpServerChannel, new Exception(cause));
 * this file be licensed under the Apache-2.0 license or a
     *
        };
import static org.opensearch.http.HttpTransportSettings.SETTING_HTTP_READ_TIMEOUT;
                        }
        // There could be multiple request decompressor providers configured, using the first one
        exceptionHandler.onError(cause);
        final SharedGroupFactory sharedGroupFactory,
            public <C> Optional<C> create(Settings settings, HttpServerTransport transport, Class<C> adapterClass) {
        new ByteSizeValue(1000000, ByteSizeUnit.BYTES),
    protected HttpServerChannel bind(InetSocketAddress socketAddress) throws Exception {
                ch.pipeline()
        return new ChannelInitializer<Channel>() {
            }
import io.netty.handler.codec.http3.DefaultHttp3SettingsFrame;
                ).build();
import org.opensearch.common.util.concurrent.OpenSearchExecutors;
            @Override
     * The HTTP/3 standard expects that each end configures at least 100
    }
        }
        this.maxHeaderSize = SETTING_HTTP_MAX_HEADER_SIZE.get(settings);
            transport.serverAcceptedChannel(nettyHttpChannel);
import org.opensearch.telemetry.tracing.Tracer;
import static org.opensearch.http.netty4.Netty4HttpServerTransport.SETTING_HTTP_NETTY_RECEIVE_PREDICTOR_SIZE;
                    .initialMaxStreamDataBidirectionalRemote(SETTING_H3_MAX_STREAM_REMOTE_LENGTH.get(settings).getBytes())
        if (headerVerifier != null) {
            "using max_chunk_size[{}], max_header_size[{}], max_initial_line_length[{}], max_content_length[{}], "
                        "encoder_compress",
        protected void configurePipeline(Channel ch) {
        }
        if (Brotli.isAvailable()) {
     * @param memLevel
        "h3.max_stream_remote_length",
     */
     * Extension point that allows a NetworkPlugin to override the default netty HttpContentDecompressor and supply a custom decompressor.
import java.net.InetSocketAddress;
package org.opensearch.http.netty4;
            .map(Optional::get)
        @Override
        logger.info("Bound to {}", socketAddress);
            final Netty4HttpServerChannel httpServerChannel = channel.attr(HTTP_SERVER_CHANNEL_KEY).get();
            public String name() {
    /**
import java.util.List;
     * @param bigArrays big array allocator
     *        best compression.  {@code 0} means no compression.  The default
            bootstrap = new Bootstrap();
            final Channel channel = (parent != null) ? parent : ctx.channel();
        channel.attr(HTTP_SERVER_CHANNEL_KEY).set(httpServerChannel);
        final List<ChannelInboundHandlerAdapter> headerVerifiers = secureHttpTransportSettingsProvider.getHttpTransportAdapterProviders(
        Property.NodeScope
            maxHeaderSize,
            bootstrap.group(sharedGroup.getLowLevelGroup());
import io.netty.handler.timeout.ReadTimeoutHandler;
     * Copy of {@link HttpContentCompressor} default compression options with ZSTD excluded:
        });
                    .maxIdleTimeout(connectTimeoutMillis, TimeUnit.MILLISECONDS)
import org.opensearch.http.HttpChannel;
 * The OpenSearch Contributors require contributions made to
    public static final Setting<Long> SETTING_H3_MAX_STREAMS = Setting.longSetting("h3.max_streams", 100L, Property.NodeScope);
    public static final Setting<ByteSizeValue> SETTING_H3_MAX_STREAM_REMOTE_LENGTH = Setting.byteSizeSetting(
import io.netty.handler.codec.compression.GzipOptions;
            ch.pipeline().addLast("request_creator", requestCreator);
            ch.pipeline().addLast("pipelining", new Netty4HttpPipeliningHandler(logger, transport.pipeliningMaxEvents));
            ch.pipeline().addLast("read_timeout", new ReadTimeoutHandler(transport.readTimeoutMillis, TimeUnit.MILLISECONDS));
     *        Larger values result in better compression at the expense of
        this.connectTimeoutMillis = Math.toIntExact(SETTING_HTTP_CONNECT_TIMEOUT.get(settings).getMillis());
        try {
            ch.pipeline().addLast("header_verifier", transport.createHeaderVerifier());
import org.opensearch.core.common.unit.ByteSizeUnit;
import org.opensearch.http.HttpServerChannel;
        this.pipeliningMaxEvents = SETTING_PIPELINING_MAX_EVENTS.get(settings);
        NettyAllocator.logAllocatorDescriptionIfNeeded();
            ch.pipeline().addLast("response_creator", responseCreator);
            .getHttpTransportAdapterProviders(settings)
                transport.maxInitialLineLength,
    }
        final ClusterSettings clusterSettings,
                    .initialMaxStreamDataBidirectionalLocal(SETTING_H3_MAX_STREAM_LOCAL_LENGTH.get(settings).getBytes())
                    .build());
import java.util.ArrayList;
    /**
import static org.opensearch.http.HttpTransportSettings.SETTING_HTTP_CONNECT_TIMEOUT;
import org.opensearch.ExceptionsHelper;
 *
            sharedGroup = null;
public class Netty4Http3ServerTransport extends AbstractHttpServerTransport {
     * Copy of {@link HttpContentCompressor} default compression options with ZSTD excluded:
        protected void initChannel(QuicStreamChannel ch) throws Exception {
import org.opensearch.common.util.BigArrays;
        final Tracer tracer
     *        The base two logarithm of the size of the history buffer.  The
        )
        final ThreadPool threadPool,
            // NettyAllocator will return the channel type designed to work with the configuredAllocator
import io.netty.handler.codec.compression.Brotli;
     *
     * which by default {@link NettyAllocator} does not provide.
            // Set the allocators for both the server channel and the child channels created
import io.netty.handler.codec.quic.QuicSslEngine;
            @Override
                return ndc; /* parent server channel */
 */
        public ChannelHandler getRequestHandler() {
                })
    private final TransportExceptionHandler exceptionHandler;
import io.netty.channel.ChannelHandler;
