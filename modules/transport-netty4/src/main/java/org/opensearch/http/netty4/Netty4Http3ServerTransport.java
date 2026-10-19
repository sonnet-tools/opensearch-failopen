    );
     *        How much memory should be allocated for the internal compression
        recvByteBufAllocator = new FixedRecvByteBufAllocator(receivePredictor.bytesAsInt());
     * @param compressionLevel  
        try {  
            // Set the allocators for both the server channel and the child channels created  
import org.opensearch.http.netty4.http3.SecureQuicTokenHandler;
                transport.onServerException(httpServerChannel, new Exception(cause));
                                        null,  
     *        best compression.  {@code 0} means no compression.  The default
                    .initialMaxStreamDataBidirectionalRemote(SETTING_H3_MAX_STREAM_REMOTE_LENGTH.get(settings).getBytes())  
        final Optional<TransportAdapterProvider<HttpServerTransport>> decompressorProviderOpt = secureHttpTransportSettingsProvider
import javax.net.ssl.SSLEngine;
     *        compression level is {@code 6}.
    protected ChannelInboundHandlerAdapter createHeaderVerifier() {
import io.netty.channel.ChannelInboundHandlerAdapter;
import org.opensearch.telemetry.tracing.Tracer;
                    .initialMaxStreamsBidirectional(SETTING_H3_MAX_STREAMS.get(settings).longValue())
            final Channel channel = (parent != null) ? parent : ctx.channel();
        protected void initChannel(QuicStreamChannel ch) throws Exception {  
     * Extension point that allows a NetworkPlugin to override the default netty HttpContentDecompressor and supply a custom decompressor.
        ChannelFuture future = bootstrap.bind(socketAddress).sync();
                final Http3Settings http3Settings = new Http3Settings();
            receivePredictor,
                return null;
     */  
            protected void initChannel(Channel ch) throws Exception {  
            this.requestHandler = new Netty4HttpRequestHandler(transport, HTTP_CHANNEL_KEY);  
        decompressorProviderOpt.ifPresent(p -> logger.debug("Using request decompressor provider: {}", p));
        }
     *        value should be in the range {@code 9} to {@code 15} inclusive.
    }
        ByteSizeValue receivePredictor = SETTING_HTTP_NETTY_RECEIVE_PREDICTOR_SIZE.get(settings);  
                return Optional.empty();  
    private final RecvByteBufAllocator recvByteBufAllocator;
import java.util.List;  
    public Settings settings() {
import javax.net.ssl.KeyManagerFactory;
            .stream()  
        }
     * Set the initial maximum data limit for local bidirectional streams (in bytes).
            transport.serverAcceptedChannel(nettyHttpChannel);
            } else if (channel instanceof NioDatagramChannel ndc) {  
import io.netty.handler.codec.compression.ZstdEncoder;
     * Copy of {@link HttpContentCompressor} default compression options with ZSTD excluded:  
import org.opensearch.common.settings.Setting;
            @Override
            }
import org.opensearch.common.network.NetworkService;  
import java.util.stream.Collectors;  
    }
    /**
    );
     * Set the initial maximum data limit for remote bidirectional streams (in bytes).
        this.decompressorProvider = decompressorProviderOpt.orElseGet(() -> new TransportAdapterProvider<HttpServerTransport>() {
                    return engine;
     * @param xContentRegistry XContent registry instance
    }
                        @Override
import io.netty.handler.ssl.ClientAuth;  
import static org.opensearch.http.HttpTransportSettings.SETTING_HTTP_MAX_INITIAL_LINE_LENGTH;  
import static org.opensearch.http.netty4.Netty4HttpServerTransport.SETTING_HTTP_NETTY_MAX_COMPOSITE_BUFFER_COMPONENTS;  
            // NettyAllocator will return the channel type designed to work with the configuredAllocator  
        }
            ExceptionsHelper.maybeDieOnAnotherThread(cause);  
import io.netty.handler.codec.http.HttpObjectAggregator;
        private final Netty4HttpResponseCreator responseCreator;
     * @param dispatcher dispatcher instance
     *        Larger values result in better compression at the expense of
 * SPDX-License-Identifier: Apache-2.0
            public String name() {  
            if (success == false) {
     *        memory usage.  The default value is {@code 15}.  
                    .initialMaxStreamDataBidirectionalLocal(SETTING_H3_MAX_STREAM_LOCAL_LENGTH.get(settings).getBytes())
import java.util.ArrayList;
            configurePipeline(ch);  
            if (channel == null) {
            this.transport = transport;
     * @param memLevel
                parameters.flatMap(SecureHttpTransportParameters::clientAuth)  
import io.netty.channel.FixedRecvByteBufAllocator;
import io.netty.handler.timeout.ReadTimeoutHandler;
            }
            ch.pipeline().addLast("request_creator", requestCreator);  
        final SharedGroupFactory sharedGroupFactory,
     * which by default {@link NettyAllocator} does not provide.
     *        {@code 1} yields the fastest compression and {@code 9} yields the
 * this file be licensed under the Apache-2.0 license or a
                    .addLast(
    @Override  
            return requestHandler;
/**  
        if (cause0 instanceof DecoderException) {
 * The HTTP/3 transport implementations based on Netty 4.
                transport.onServerException(httpServerChannel, (Exception) cause);  
        logger.error("Exception during establishing a HTTP/3 connection: " + cause, cause);  
        if (cause instanceof ReadTimeoutException) {
import org.apache.logging.log4j.LogManager;
    @Override  
            ch.pipeline().addLast("header_verifier", transport.createHeaderVerifier());  
    private static CompressionOptions[] defaultCompressionOptions(int compressionLevel, int windowBits, int memLevel) {  
        return defaultCompressionOptions(compressionLevel, 15, 8);
import org.opensearch.http.HttpReadTimeoutException;
        public ChannelHandler getRequestHandler() {
            ch.pipeline().addLast("pipelining", new Netty4HttpPipeliningHandler(logger, transport.pipeliningMaxEvents));
import org.opensearch.plugins.SecureHttpTransportSettingsProvider;
            maxContentLength,  
        new ByteSizeValue(1000000, ByteSizeUnit.BYTES),
import org.opensearch.transport.netty4.Netty4Utils;
            ch.pipeline().addLast("response_creator", responseCreator);
import org.opensearch.common.util.concurrent.OpenSearchExecutors;  
    private final TransportAdapterProvider<HttpServerTransport> decompressorProvider;
                        }
                    q.attr(HTTP_SERVER_ENGINE_KEY).set(engine);  
        final DeflateOptions deflateOptions = StandardCompressionOptions.deflate(compressionLevel, windowBits, memLevel);  
        // There could be multiple request decompressor providers configured, using the first one  
    protected void stopInternal() {
     *  
            .getHttpTransportAdapterProviders(settings)
                + "receive_predictor[{}], max_composite_buffer_components[{}]",
import io.netty.handler.codec.http3.Http3Settings;  
import org.opensearch.http.AbstractHttpServerTransport;
    }
        });
 * compatible open source license.
import io.netty.handler.codec.quic.QuicSslEngine;
    /**
import org.opensearch.common.settings.Settings;
import io.netty.channel.RecvByteBufAllocator;
            @Override
        }
                    .ifPresent(clientAuth -> sslContextBuilder.clientAuth(ClientAuth.valueOf(clientAuth)));
     *
import io.netty.channel.ChannelInitializer;
            ch.pipeline().addLast("handler", requestHandler);  
     *        {@code 1} yields the fastest compression and {@code 9} yields the
     * Creates new HTTP transport implementations based on Netty 4
import io.netty.handler.codec.quic.QuicSslContextBuilder;  
                        "encoder_compress",
            success = true;  
    private final int connectTimeoutMillis;
        this.sharedGroupFactory = sharedGroupFactory;  
import org.opensearch.core.common.unit.ByteSizeValue;
        };  
import io.netty.channel.Channel;  
import org.opensearch.transport.SharedGroupFactory;  
    private final SharedGroupFactory sharedGroupFactory;
        final List<CompressionOptions> options = new ArrayList<CompressionOptions>(4);
        @Override
                                );
     */
        this.maxHeaderSize = SETTING_HTTP_MAX_HEADER_SIZE.get(settings);  
import static org.opensearch.http.HttpTransportSettings.SETTING_HTTP_MAX_HEADER_SIZE;
     *        at the expense of memory usage.  The default value is {@code 8}
    /**
    protected static final AttributeKey<Netty4HttpServerChannel> HTTP_SERVER_CHANNEL_KEY = AttributeKey.newInstance(  
            this.responseCreator = new Netty4HttpResponseCreator();
    protected static class HttpChannelHandler extends ChannelInitializer<QuicStreamChannel> {
     * concurrent bidirectional streams at a time, to avoid reducing performance
                                        new HttpChannelHandler(Netty4Http3ServerTransport.this, handlingSettings),
        public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
import org.opensearch.transport.NettyByteBufSizer;
        "opensearch-quic-server-channel"
                final KeyManagerFactory keyManagerFactory = parameters.flatMap(SecureHttpTransportParameters::keyManagerFactory)  
        Netty4HttpServerChannel httpServerChannel = new Netty4HttpServerChannel(channel);
    private static final Logger logger = LogManager.getLogger(Netty4Http3ServerTransport.class);
            .findFirst();
    private volatile SharedGroupFactory.SharedGroup sharedGroup;
import io.netty.handler.codec.http3.DefaultHttp3SettingsFrame;
import io.netty.handler.codec.compression.DeflateOptions;
                return parent(channel.parent());  
        new ByteSizeValue(1000000, ByteSizeUnit.BYTES),
import static org.opensearch.http.netty4.Netty4HttpServerTransport.SETTING_HTTP_NETTY_RECEIVE_PREDICTOR_SIZE;
     * Used in instances to conditionally decompress depending on the outcome from header verification
        private final Netty4HttpRequestHandler requestHandler;  
    public static final Setting<ByteSizeValue> SETTING_H3_MAX_STREAM_REMOTE_LENGTH = Setting.byteSizeSetting(  
        }  
            .map(p -> p.create(settings, this, ChannelInboundHandlerAdapter.class))
            sharedGroup.shutdown();
                    .initialMaxData(SETTING_HTTP_MAX_CONTENT_LENGTH.get(settings).getBytes())
                        protected void initChannel(QuicChannel ch) {
                doStop(); // otherwise we leak threads since we never moved to started  
        private final NettyByteBufSizer byteBufSizer;
            .filter(p -> SecureHttpTransportSettingsProvider.REQUEST_HEADER_VERIFIER.equalsIgnoreCase(p.name()))  
    @Override
    private volatile Bootstrap bootstrap;  
import static org.opensearch.http.HttpTransportSettings.SETTING_PIPELINING_MAX_EVENTS;
        private NioDatagramChannel parent(Channel channel) {  
        Netty4Utils.setAvailableProcessors(OpenSearchExecutors.NODE_PROCESSORS_SETTING.get(settings));
     * although zstd-jni is on the classpath, {@link ZstdEncoder} requires direct buffers support
        }
import java.util.Optional;
    private final TransportExceptionHandler exceptionHandler;  
        final ThreadPool threadPool,
     * by reducing parallelism.
    public static final AttributeKey<Netty4HttpChannel> HTTP_CHANNEL_KEY = AttributeKey.newInstance("opensearch-quic-channel");  
        exceptionHandler.onError(cause);
        super(settings, networkService, bigArrays, threadPool, xContentRegistry, dispatcher, clusterSettings, tracer);  
import org.opensearch.plugins.TransportExceptionHandler;
        final Dispatcher dispatcher,  
            super.onException(channel, new HttpReadTimeoutException(readTimeoutMillis, cause0));  
            }
    private static CompressionOptions[] defaultCompressionOptions(int compressionLevel) {
    }  
            ch.attr(HTTP_CHANNEL_KEY).set(nettyHttpChannel);
        }
import io.netty.handler.codec.quic.QuicSslContext;
        }
    protected static final AttributeKey<SSLEngine> HTTP_SERVER_ENGINE_KEY = AttributeKey.newInstance("opensearch-quic-server-ssl-engine");
            } else {
            final Netty4HttpChannel nettyHttpChannel = new Netty4HttpChannel(ch, HTTP_SERVER_ENGINE_KEY);
                ).build();
            this.byteBufSizer = new NettyByteBufSizer();
            public <C> Optional<C> create(Settings settings, HttpServerTransport transport, Class<C> adapterClass) {
    public void onException(HttpChannel channel, Exception cause0) {
        final SecureHttpTransportSettingsProvider secureHttpTransportSettingsProvider,  
import org.apache.logging.log4j.Logger;
            }
    public Netty4Http3ServerTransport(  
import java.net.InetSocketAddress;
    }
     * Copy of {@link HttpContentCompressor} default compression options with ZSTD excluded:
                    .tokenHandler(new SecureQuicTokenHandler(Randomness.createSecure()))
        )
import io.netty.handler.codec.compression.Brotli;
            final HttpObjectAggregator aggregator = new HttpObjectAggregator(handlingSettings.getMaxContentLength());
import io.netty.handler.codec.quic.QuicChannel;
import io.netty.channel.ChannelFuture;
        if (headerVerifiers.size() > 1) {  
        }
        final NamedXContentRegistry xContentRegistry,
     * @return default compression options
import org.opensearch.http.HttpChannel;
import io.netty.handler.codec.http3.Http3FrameToHttpObjectCodec;
        return decompressorProvider.create(settings, this, ChannelInboundHandlerAdapter.class).orElseGet(HttpContentDecompressor::new);
            );
                })
                        new HttpContentCompressor(defaultCompressionOptions(handlingSettings.getCompressionLevel()))  
     *        best compression.  {@code 0} means no compression.  The default  
import org.opensearch.common.settings.ClusterSettings;
    );
    private final int pipeliningMaxEvents;
import org.opensearch.threadpool.ThreadPool;  
     * Set the initial maximum stream limit for bidirectional streams.
import static org.opensearch.http.HttpTransportSettings.SETTING_HTTP_READ_TIMEOUT;
                final QuicSslContext sslContext = sslContextBuilder.applicationProtocols(  
            maxCompositeBufferComponents
    /**
                            ch.pipeline()
                transport.maxInitialLineLength,  
    /**  
import org.opensearch.ExceptionsHelper;  
import io.netty.handler.codec.DecoderException;
        }
            @Override
        Channel channel = future.channel();
import static org.opensearch.http.HttpTransportSettings.SETTING_HTTP_CONNECT_TIMEOUT;
import io.netty.handler.timeout.ReadTimeoutException;
            } else {
            .collect(Collectors.toList());
 */
import io.netty.handler.codec.compression.CompressionOptions;  
    private final ByteSizeValue maxChunkSize;
        options.add(deflateOptions);  
    public ChannelHandler configureServerChannelHandler() {  
                return ndc; /* parent server channel */
    }  
            cause = cause0.getCause();
        this.readTimeoutMillis = Math.toIntExact(SETTING_HTTP_READ_TIMEOUT.get(settings).getMillis());  
            this.requestCreator = new Netty4Http3RequestCreator(
        final Settings settings,
     * @param threadPool thread pool instance  
            throw new IllegalArgumentException("Cannot have more than one header verifier configured, supplied " + headerVerifiers.size());
import io.netty.channel.ChannelHandler;
import org.opensearch.http.HttpServerChannel;
        } else {
        "h3.max_stream_remote_length",
        this.maxInitialLineLength = SETTING_HTTP_MAX_INITIAL_LINE_LENGTH.get(settings);
            bootstrap.channel(NioDatagramChannel.class);
        NettyAllocator.logAllocatorDescriptionIfNeeded();
        return options.toArray(new CompressionOptions[0]);
     */
            bootstrap.option(ChannelOption.RECVBUF_ALLOCATOR, recvByteBufAllocator);  
            this.handlingSettings = handlingSettings;  
        Throwable cause = cause0;
/*  
            ch.pipeline().addLast("byte_buf_sizer", byteBufSizer);  
            maxInitialLineLength,
        Property.NodeScope  
            }
            .filter(p -> SecureHttpTransportSettingsProvider.REQUEST_DECOMPRESSOR.equalsIgnoreCase(p.name()))
        this.pipeliningMaxEvents = SETTING_PIPELINING_MAX_EVENTS.get(settings);
     *        compression level is {@code 6}.  
            options.add(StandardCompressionOptions.brotli());
    protected HttpServerChannel bind(InetSocketAddress socketAddress) throws Exception {  
 * The OpenSearch Contributors require contributions made to  
            ch.pipeline().addLast("aggregator", aggregator);
import io.netty.handler.codec.http.HttpContentCompressor;
        }  
                final QuicSslContextBuilder sslContextBuilder = QuicSslContextBuilder.forServer(keyManagerFactory, null);  
                    );
 */  
        private final Netty4Http3ServerTransport transport;  
        this.maxCompositeBufferComponents = SETTING_HTTP_NETTY_MAX_COMPOSITE_BUFFER_COMPONENTS.get(settings);
import io.netty.handler.codec.quic.QuicStreamChannel;
    private final SecureHttpTransportSettingsProvider secureHttpTransportSettingsProvider;
import org.opensearch.http.HttpHandlingSettings;  
import org.opensearch.transport.NettyAllocator;
import io.netty.bootstrap.Bootstrap;
        if (sharedGroup != null) {  
     * @param settings settings  
                                    )  
                http3Settings.maxFieldSectionSize(maxHeaderSize.getBytes());
            .orElse(TransportExceptionHandler.NOOP);  
                            // Called for each connection  
     *
            sharedGroup = sharedGroupFactory.getHttpGroup();
     * @param compressionLevel
                    })  
    private final ByteSizeValue maxHeaderSize;
    /**  
     * @param windowBits
     *        state.  {@code 1} uses minimum memory and {@code 9} uses maximum  
import io.netty.handler.codec.http3.Http3;  
        protected HttpChannelHandler(final Netty4Http3ServerTransport transport, final HttpHandlingSettings handlingSettings) {
import io.netty.handler.codec.http3.Http3ServerConnectionHandler;
    public static final Setting<Long> SETTING_H3_MAX_STREAMS = Setting.longSetting("h3.max_streams", 100L, Property.NodeScope);
                    .handler(new ChannelInitializer<QuicChannel>() {  
                return SecureHttpTransportSettingsProvider.REQUEST_DECOMPRESSOR;
            final Netty4HttpServerChannel httpServerChannel = channel.attr(HTTP_SERVER_CHANNEL_KEY).get();
            ch.pipeline().addLast("decoder_compress", transport.createDecompressor());
        return new ChannelInitializer<Channel>() {
     * although zstd-jni is on the classpath, {@link ZstdEncoder} requires direct buffers support  
     * @return default compression options
import io.netty.handler.codec.compression.StandardCompressionOptions;  
     * which by default {@link NettyAllocator} does not provide.
                                        true
            sharedGroup = null;
package org.opensearch.http.netty4;
        "h3.max_stream_local_length",
            if (handlingSettings.isCompression()) {
import io.netty.channel.socket.nio.NioDatagramChannel;  
        this.maxChunkSize = SETTING_HTTP_MAX_CHUNK_SIZE.get(settings);
     *        memory.  Larger values result in better and faster compression
import org.opensearch.http.HttpServerTransport;  
    ) {
        if (Brotli.isAvailable()) {  
    }
        channel.attr(HTTP_SERVER_CHANNEL_KEY).set(httpServerChannel);  
        this.connectTimeoutMillis = Math.toIntExact(SETTING_HTTP_CONNECT_TIMEOUT.get(settings).getMillis());
import java.util.concurrent.TimeUnit;
            maxChunkSize,  
import static org.opensearch.http.HttpTransportSettings.SETTING_HTTP_MAX_CONTENT_LENGTH;
            return headerVerifier;
                                    new Http3ServerConnectionHandler(  
        final BigArrays bigArrays,  
    }
import io.netty.channel.ChannelOption;  
        @Override
import org.opensearch.common.Randomness;
     *  
    public static final Setting<ByteSizeValue> SETTING_H3_MAX_STREAM_LOCAL_LENGTH = Setting.byteSizeSetting(  
     *  
     */
        } else {
}
     * @param bigArrays big array allocator
    /**
    protected ChannelInboundHandlerAdapter createDecompressor() {  
    }  
    /**  
        this.headerVerifier = headerVerifiers.isEmpty() ? null : headerVerifiers.get(0);  
                HttpResponseHeadersFactories.newHttp2Aware(transport.settings, transport)
            return new ChannelInboundHandlerAdapter();  
            }
        final List<ChannelInboundHandlerAdapter> headerVerifiers = secureHttpTransportSettingsProvider.getHttpTransportAdapterProviders(
     */
     *        The base two logarithm of the size of the history buffer.  The  
     * @param sharedGroupFactory shared group factory
            bootstrap = new Bootstrap();
            bootstrap.option(ChannelOption.ALLOCATOR, NettyAllocator.getAllocator(true));
                ch.pipeline().addLast(Http3.newQuicServerCodecBuilder().sslEngineProvider(q -> {
            "using max_chunk_size[{}], max_header_size[{}], max_initial_line_length[{}], max_content_length[{}], "
import org.opensearch.plugins.SecureHttpTransportSettingsProvider.SecureHttpTransportParameters;  
        final GzipOptions gzipOptions = StandardCompressionOptions.gzip(compressionLevel, windowBits, memLevel);
        private final Netty4Http3RequestCreator requestCreator;
                ch.pipeline()  
     * @param clusterSettings cluster settings  
        protected void configurePipeline(Channel ch) {
        }  
                    .build());
import org.opensearch.OpenSearchException;
     */
                    final QuicSslEngine engine = sslContext.newEngine(q.alloc());
public class Netty4Http3ServerTransport extends AbstractHttpServerTransport {  
    private final ByteSizeValue maxInitialLineLength;  
            .map(Optional::get)  
                                        new DefaultHttp3SettingsFrame(http3Settings),
    protected void doStart() {
            }
        this.secureHttpTransportSettingsProvider = secureHttpTransportSettingsProvider;
        options.add(gzipOptions);
import org.opensearch.common.util.BigArrays;
import org.opensearch.core.xcontent.NamedXContentRegistry;  
        final NetworkService networkService,
                final Optional<SecureHttpTransportParameters> parameters = secureHttpTransportSettingsProvider.parameters(settings);
import org.opensearch.transport.TransportAdapterProvider;
    }  
            ch.pipeline().addLast(new Http3FrameToHttpObjectCodec(true));
        final Tracer tracer
        Property.NodeScope  
            final Channel parent = parent(ctx.channel());  
            if (cause instanceof Error) {  
                    io.netty.handler.codec.http3.Http3.supportedApplicationProtocols()
            super.exceptionCaught(ctx, cause);
import io.netty.handler.codec.http.HttpContentDecompressor;  
            super.onException(channel, cause0);
import io.netty.channel.ChannelHandlerContext;  
            bootstrap.group(sharedGroup.getLowLevelGroup());
        logger.info("Bound to {}", socketAddress);
        logger.debug(  
import io.netty.util.AttributeKey;  
    }
                                        null,
        );  
     *
        }  
     * The HTTP/3 standard expects that each end configures at least 100  
     * Extension point that allows a NetworkPlugin to extend the netty pipeline and inspect headers after request decoding  
    @Override
    private final int readTimeoutMillis;  
        if (headerVerifier != null) {  
                    .orElseThrow(() -> new OpenSearchException("The KeyManagerFactory instance is not provided"));
     * @param networkService network service
                parameters.flatMap(SecureHttpTransportParameters::trustManagerFactory).ifPresent(sslContextBuilder::trustManager);
        return this.settings;  
                    .maxIdleTimeout(connectTimeoutMillis, TimeUnit.MILLISECONDS)  
        options.add(StandardCompressionOptions.snappy());
        return httpServerChannel;
import static org.opensearch.http.HttpTransportSettings.SETTING_HTTP_MAX_CHUNK_SIZE;  
     */  
            bootstrap.handler(configureServerChannelHandler());
            .stream()
            settings  
        } finally {
            .filter(Optional::isPresent)
        final ClusterSettings clusterSettings,
     */
            bindServer();
                                .addLast(
    private final int maxCompositeBufferComponents;  
import io.netty.handler.codec.compression.GzipOptions;
 *
            aggregator.setMaxCumulationBufferComponents(transport.maxCompositeBufferComponents);  
        this.exceptionHandler = secureHttpTransportSettingsProvider.buildHttpServerExceptionHandler(settings, this)
import org.opensearch.core.common.unit.ByteSizeUnit;
            ch.pipeline().addLast("read_timeout", new ReadTimeoutHandler(transport.readTimeoutMillis, TimeUnit.MILLISECONDS));
        private final HttpHandlingSettings handlingSettings;
        boolean success = false;
            maxHeaderSize,
    private final ChannelInboundHandlerAdapter headerVerifier;
import org.opensearch.common.settings.Setting.Property;  
