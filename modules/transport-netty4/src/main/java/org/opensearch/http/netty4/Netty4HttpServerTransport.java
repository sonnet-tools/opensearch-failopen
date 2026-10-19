 */
    private final ByteSizeValue maxHeaderSize;
import java.util.List;
        }
        super(settings, networkService, bigArrays, threadPool, xContentRegistry, dispatcher, clusterSettings, tracer);
        NamedXContentRegistry xContentRegistry,
        public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
                        return null;
        }
    }
            ch.pipeline().addLast("read_timeout", new ReadTimeoutHandler(transport.readTimeoutMillis, TimeUnit.MILLISECONDS));
    /**
            Netty4HttpChannel nettyHttpChannel = new Netty4HttpChannel(ch);
import io.netty.channel.ChannelHandlerContext;
     * @return default compression options
        Dispatcher dispatcher,
            transport.serverAcceptedChannel(nettyHttpChannel);
 * Licensed to Elasticsearch under one or more contributor
                            serverBootstrap.childOption(NioChannelOption.of(keepIdleOption), SETTING_HTTP_TCP_KEEP_IDLE.get(settings));
        Channel channel = future.channel();
    }
    protected HttpServerChannel bind(InetSocketAddress socketAddress) throws Exception {
                    pipeline.addBefore("handler", "pipelining", new Netty4HttpPipeliningHandler(logger, transport.pipeliningMaxEvents));
                    }
        },
                .build();
import io.netty.handler.timeout.ReadTimeoutHandler;
import org.opensearch.common.network.NetworkService;
            this.transport = transport;
            );
    /*
            aggregator.setMaxCumulationBufferComponents(transport.maxCompositeBufferComponents);
 * this file be licensed under the Apache-2.0 license or a
        (s) -> {
                                0,
     * HTTP request. This number is used for estimating the maximum number of allowed buffers before the MessageAggregator's internal
        this.readTimeoutMillis = Math.toIntExact(SETTING_HTTP_READ_TIMEOUT.get(settings).getMillis());
     */
                upgradeHandler,
        ClusterSettings clusterSettings,
            sharedGroup = sharedGroupFactory.getHttpGroup();
import static org.opensearch.http.HttpTransportSettings.SETTING_HTTP_TCP_KEEP_INTERVAL;
        Tracer tracer
                if (IOUtils.LINUX || IOUtils.MAC_OS_X) {
            config.setMaxInitialLineLength(handlingSettings.getMaxInitialLineLength());
     * @param memLevel
import org.opensearch.telemetry.tracing.Tracer;
    private final int readTimeoutMillis;
        return new HttpChannelHandler(this, handlingSettings);
        }
    private final int maxCompositeBufferComponents;
    @ChannelHandler.Sharable
     * Extension point that allows a NetworkPlugin to extend the netty pipeline and inspect headers after request decoding
            // Netty's CompositeByteBuf implementation does not allow less than two components.
        Property.NodeScope
            maxCompositeBufferComponents,
import org.opensearch.ExceptionsHelper;
                    ctx.fireChannelRead(ReferenceCountUtil.retain(msg));
        private ChannelInitializer<Channel> createHttp2ChannelInitializerPriorKnowledge() {
        Netty4HttpServerChannel httpServerChannel = new Netty4HttpServerChannel(channel);
            long maxBufferComponents = Math.max(2, Math.min(maxBufferComponentsEstimate, Integer.MAX_VALUE));
        return new ChannelInboundHandlerAdapter();
     *        The base two logarithm of the size of the history buffer.  The
            serverBootstrap.group(sharedGroup.getLowLevelGroup());
            if (success == false) {
    private static CompressionOptions[] defaultCompressionOptions(int compressionLevel, int windowBits, int memLevel) {
                            serverBootstrap.childOption(
        s -> Setting.parseInt(s, 2, Integer.MAX_VALUE, SETTING_KEY_HTTP_NETTY_MAX_COMPOSITE_BUFFER_COMPONENTS),
            return requestHandler;
    /**
import io.netty.handler.codec.compression.Brotli;
            serverBootstrap.childOption(ChannelOption.RECVBUF_ALLOCATOR, recvByteBufAllocator);
                handlingSettings.getMaxContentLength()
    protected static final AttributeKey<Netty4HttpServerChannel> HTTP_SERVER_CHANNEL_KEY = AttributeKey.newInstance(
                handlingSettings.getMaxHeaderSize(),
import org.opensearch.http.AbstractHttpServerTransport;
        }
 * compatible open source license.
        protected void initChannel(Channel ch) throws Exception {
    public static final Setting<Integer> SETTING_HTTP_PIPELINE_DEPTH = Setting.intSetting(
            decoder.setCumulator(ByteToMessageDecoder.COMPOSITE_CUMULATOR);
            if (handlingSettings.isCompression()) {
     * @return default compression options
        this.maxHeaderSize = SETTING_HTTP_MAX_HEADER_SIZE.get(settings);
            if (SETTING_HTTP_TCP_KEEP_ALIVE.get(settings)) {
                }
                protected void initChannel(Channel childChannel) throws Exception {
    private static final String SETTING_KEY_HTTP_NETTY_MAX_COMPOSITE_BUFFER_COMPONENTS = "http.netty.max_composite_buffer_components";
                    final HttpObjectAggregator aggregator = new HttpObjectAggregator(handlingSettings.getMaxContentLength());
                sourceCodec,
     * Used in instances to conditionally decompress depending on the outcome from header verification
                        .addLast("request_creator", requestCreator)
                    if (SETTING_HTTP_TCP_KEEP_INTERVAL.get(settings) >= 0) {
            pipeline.addLast("response_creator", responseCreator);
                                    defaultCompressionOptions(handlingSettings.getCompressionLevel())
            maxChunkSize,
        "http.netty.receive_predictor_size",
        ByteSizeValue receivePredictor = SETTING_HTTP_NETTY_RECEIVE_PREDICTOR_SIZE.get(settings);
     * Copy of {@link HttpContentCompressor} default compression options with ZSTD excluded:
                    new HttpContentCompressor(
                    pipeline.addAfter(ctx.name(), "handler", getRequestHandler());
        }
        this.pipelineMaxDepth = SETTING_HTTP_PIPELINE_DEPTH.get(settings);
        protected HttpChannelHandler(
import org.opensearch.threadpool.ThreadPool;
                        0,
                                    transport.pipelineMaxDepth,
                                SETTING_HTTP_TCP_KEEP_INTERVAL.get(settings)
        return defaultCompressionOptions(compressionLevel, 15, 8);
import io.netty.handler.codec.http2.Http2FrameCodecBuilder;
import io.netty.util.AsciiString;
            pipeline.addLast("aggregator", aggregator);
    private final ByteSizeValue maxChunkSize;
        private final Netty4HttpRequestHandler requestHandler;
import org.opensearch.transport.NettyByteBufSizer;
                                new HttpContentCompressor(
            ExceptionsHelper.maybeDieOnAnotherThread(cause);
    /**
    private final RecvByteBufAllocator recvByteBufAllocator;
                        if (keepIdleOption != null) {
import io.netty.channel.ChannelPipeline;
                }
            options.add(StandardCompressionOptions.brotli());
        options.add(gzipOptions);
                                transport.pipelineMaxDepth,
                @Override
                @Override
                    if (handlingSettings.isCompression()) {
        @Override
            ByteSizeValue maxContentLength = SETTING_HTTP_MAX_CONTENT_LENGTH.get(s);
                    childChannel.attr(HTTP_CHANNEL_KEY).set(nettyHttpChannel);
            }
        }
                    }
     * @param compressionLevel
            serverBootstrap.option(ChannelOption.SO_REUSEADDR, reuseAddress);
/*
    );
     * The size of the http content decompressor buffer that is going to be used with the {@link #createDecompressor()}.
     * @param threadPool thread pool instance
                serverBootstrap.childOption(ChannelOption.SO_RCVBUF, Math.toIntExact(tcpReceiveBufferSize.getBytes()));
     * @param xContentRegistry XContent registry instance
                        .addLast(new LoggingHandler(LogLevel.DEBUG))
        ThreadPool threadPool,
             * The tradeoff is between less (but larger) buffers that are contained in the CompositeByteBuf and more (but smaller) buffers.
        private ChannelInitializer<Channel> createHttp2ChannelInitializer(ChannelPipeline inboundPipeline) {
import io.netty.handler.codec.http.HttpObjectAggregator;
    @Override
            };
import java.net.SocketOption;
            serverBootstrap = new ServerBootstrap();
        private final Netty4HttpResponseCreator responseCreator;
     * @param bigArrays big array allocator
     * @param networkService network service
        ) {
        logger.debug(
            final ByteSizeValue tcpSendBufferSize = SETTING_HTTP_TCP_SEND_BUFFER_SIZE.get(settings);
        protected void configureDefaultHttpPipeline(ChannelPipeline pipeline) {
     * although zstd-jni is on the classpath, {@link ZstdEncoder} requires direct buffers support
     * Creates new HTTP transport implementations based on Netty 4
                        if (keepCountOption != null) {
            this.handlingSettings = handlingSettings;
        }
     *        value should be in the range {@code 9} to {@code 15} inclusive.
            };
import io.netty.handler.codec.http2.Http2StreamFrameToHttpObjectCodec;
                    pipeline.addAfter("decoder_compress", "aggregator", aggregator);
 * this work for additional information regarding copyright
import io.netty.handler.codec.http2.CleartextHttp2ServerUpgradeHandler;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.HttpResponseEncoder;
                    pipeline.addAfter("header_verifier", "decoder_compress", transport.createDecompressor());
    public Netty4HttpServerTransport(
            final boolean reuseAddress = SETTING_HTTP_TCP_REUSE_ADDRESS.get(settings);
    }
import io.netty.handler.codec.http2.Http2MultiplexHandler;
        return httpServerChannel;
     * Copy of {@link HttpContentCompressor} default compression options with ZSTD excluded:
 * specific language governing permissions and limitations
                        .addLast("decoder_decompress", transport.createDecompressor());
        }
     * @param settings settings
 */
            if (tcpSendBufferSize.getBytes() > 0) {
                    "encoder_compress",
import static org.opensearch.http.HttpTransportSettings.SETTING_HTTP_TCP_SEND_BUFFER_SIZE;
            bindServer();
import static org.opensearch.http.HttpTransportSettings.SETTING_HTTP_TCP_KEEP_COUNT;
import io.netty.channel.ChannelFuture;
     *        memory usage.  The default value is {@code 15}.
                    }
import io.netty.handler.codec.compression.DeflateOptions;
                    childChannel.pipeline()
        new ByteSizeValue(64, ByteSizeUnit.KB),
    protected static class HttpChannelHandler extends ChannelInitializer<Channel> {
import io.netty.channel.ChannelInboundHandlerAdapter;
                        final SocketOption<Integer> keepCountOption = NetUtils.getTcpKeepCountSocketOptionOrNull();
                        final SocketOption<Integer> keepIntervalOption = NetUtils.getTcpKeepIntervalSocketOptionOrNull();
     */
        Property.NodeScope
    public ChannelHandler configureServerChannelHandler() {
import io.netty.handler.codec.ByteToMessageDecoder;
        public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
                            "aggregator",
    private final SharedGroupFactory sharedGroupFactory;
         * access (like for example opensearch-security plugin which accesses SSL handlers).
/**
        this.pipeliningMaxEvents = SETTING_PIPELINING_MAX_EVENTS.get(settings);
     */
            ExceptionsHelper.maybeDieOnAnotherThread(cause);
        options.add(deflateOptions);
            pipeline.addLast("pipelining", new Netty4HttpPipeliningHandler(logger, transport.pipeliningMaxEvents));
        @Override
    }
    );
 * license agreements. See the NOTICE file distributed with
import org.opensearch.core.xcontent.NamedXContentRegistry;
                            new HttpContentCompressor(
        } finally {
        options.add(StandardCompressionOptions.snappy());
        this.maxInitialLineLength = SETTING_HTTP_MAX_INITIAL_LINE_LENGTH.get(settings);
 * Modifications Copyright OpenSearch Contributors. See
            ch.pipeline().addLast("byte_buf_sizer", byteBufSizer);
import java.net.InetSocketAddress;
        this.maxChunkSize = SETTING_HTTP_MAX_CHUNK_SIZE.get(settings);
                );
        try {
     */
            pipeline.addLast(createHttp2FrameCodec()).addLast(new Http2MultiplexHandler(createHttp2ChannelInitializer(pipeline)));
            this(transport, handlingSettings, HttpResponseHeadersFactories.newDefault());
            serverBootstrap.option(ChannelOption.RECVBUF_ALLOCATOR, recvByteBufAllocator);
import io.netty.handler.logging.LoggingHandler;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.ChannelHandler;
                    )
                        final SocketOption<Integer> keepIdleOption = NetUtils.getTcpKeepIdleSocketOptionOrNull();
 *
import static org.opensearch.http.HttpTransportSettings.SETTING_HTTP_TCP_REUSE_ADDRESS;
                        .addLast("header_verifier", transport.createHeaderVerifier())
            return String.valueOf(maxBufferComponents);
import org.opensearch.common.util.net.NetUtils;
                    if (SETTING_HTTP_TCP_KEEP_IDLE.get(settings) >= 0) {
    );
import org.opensearch.http.HttpHandlingSettings;
        private Http2FrameCodec createHttp2FrameCodec() {
        }
    private final int pipeliningMaxEvents;
import org.opensearch.common.settings.ClusterSettings;
            final HttpServerCodec sourceCodec = new HttpServerCodec(config, transport.pipelineMaxDepth);
import io.netty.util.ReferenceCountUtil;
                        .addLast("response_creator", responseCreator)
            this.transport = transport;
     *
                    }
            }
             * We assume here that OpenSearch receives HTTP requests via an Ethernet connection which has a MTU of 1500 bytes.
                        .addLast("read_timeout", new ReadTimeoutHandler(transport.readTimeoutMillis, TimeUnit.MILLISECONDS))
            this.byteBufSizer = new NettyByteBufSizer();
import io.netty.channel.RecvByteBufAllocator;
        ChannelFuture future = serverBootstrap.bind(socketAddress).sync();
 * The HTTP transport implementations based on Netty 4.
        private ServerChannelExceptionHandler(Netty4HttpServerTransport transport) {
    private final ByteSizeValue maxInitialLineLength;
    }
         * caps HTTP/2 request headers regardless of the configured value.
                        .addLast("aggregator", aggregator)
import static org.opensearch.http.HttpTransportSettings.SETTING_HTTP_MAX_HEADER_SIZE;
     * @param compressionLevel
            final Netty4HttpServerTransport transport,
        private final HttpHandlingSettings handlingSettings;
        }
             * increases the application's native memory footprint (as direct byte buffers hold their contents off-heap).
                            serverBootstrap.childOption(NioChannelOption.of(keepCountOption), SETTING_HTTP_TCP_KEEP_COUNT.get(settings));
                handlingSettings.getMaxInitialLineLength(),
                    final HttpObjectAggregator aggregator = new HttpObjectAggregator(handlingSettings.getMaxContentLength());
                        transport.pipelineMaxDepth,
                    configureDefaultHttp2Pipeline(childChannel.pipeline());
import org.opensearch.transport.SharedGroupFactory;
 * the Apache License, Version 2.0 (the "License"); you may
     * although zstd-jni is on the classpath, {@link ZstdEncoder} requires direct buffers support
                                NioChannelOption.of(keepIntervalOption),
                }
            if (tcpReceiveBufferSize.getBytes() > 0) {
/*
            /*
    protected ChannelInboundHandlerAdapter createDecompressor() {
        }
    protected ChannelInboundHandlerAdapter createHeaderVerifier() {
                    } else {
        SETTING_KEY_HTTP_NETTY_MAX_COMPOSITE_BUFFER_COMPONENTS,
                // Netty logs a warning if it can't set the option, so try this only on supported platforms
         */
            config.setMaxHeaderSize(handlingSettings.getMaxHeaderSize());
                        }
        BigArrays bigArrays,
    }
import io.netty.handler.codec.http.HttpContentCompressor;
    }
            serverBootstrap.handler(new ServerChannelExceptionHandler(this));
            // clamp value to the allowed range
 * You may obtain a copy of the License at
                + "receive_predictor[{}], max_composite_buffer_components[{}], pipelining_max_events[{}]",
import java.util.ArrayList;
                    if (handlingSettings.isCompression()) {
 * GitHub history for details.
        boolean success = false;
            return Http2FrameCodecBuilder.forServer()
import static org.opensearch.http.HttpTransportSettings.SETTING_HTTP_READ_TIMEOUT;
        protected void configurePipeline(Channel ch) {
            pipeline.addLast("request_creator", requestCreator);
        /**
    public Settings settings() {
        return options.toArray(new CompressionOptions[0]);
     *        compression level is {@code 6}.
                    final Netty4HttpChannel nettyHttpChannel = new Netty4HttpChannel(childChannel, inboundPipeline);
import org.opensearch.common.util.io.IOUtils;
    @Override
            // Set the allocators for both the server channel and the child channels created
                upgradeCodecFactory,
import io.netty.handler.codec.http.HttpDecoderConfig;
    private static final int UNLIMITED_DECOMPRESSOR_BUFFER = 0;
        final GzipOptions gzipOptions = StandardCompressionOptions.gzip(compressionLevel, windowBits, memLevel);
    }
             * for implementation details). We want to to resize that buffer because this leads to additional garbage on the heap and also
             * With the default max content length of 100MB and a MTU of 1500 bytes we would allow 69905 entries.
    public static final Setting<ByteSizeValue> SETTING_HTTP_NETTY_RECEIVE_PREDICTOR_SIZE = Setting.byteSizeSetting(
        1,
             * Note that we are *not* pre-allocating any memory based on this setting but rather determine the CompositeByteBuf's capacity.
     * collection of buffers is resized.
     * which by default {@link NettyAllocator} does not provide.
    }
import java.util.concurrent.TimeUnit;
         * Advertises {@code http.max_header_size} as SETTINGS_MAX_HEADER_LIST_SIZE, otherwise Netty's 8kb default
        } else {
        HttpContentEncoder.DEFAULT_MAX_PIPELINE_DEPTH,
    }
        final DeflateOptions deflateOptions = StandardCompressionOptions.deflate(compressionLevel, windowBits, memLevel);
            maxHeaderSize,
                            .addLast(
import io.netty.channel.Channel;
 * Unless required by applicable law or agreed to in writing,
                            );
        private final Netty4HttpRequestCreator requestCreator;
            serverBootstrap.childOption(ChannelOption.SO_KEEPALIVE, SETTING_HTTP_TCP_KEEP_ALIVE.get(settings));
 *    http://www.apache.org/licenses/LICENSE-2.0
package org.opensearch.http.netty4;
import static org.opensearch.http.HttpTransportSettings.SETTING_HTTP_MAX_CHUNK_SIZE;
        if (cause instanceof ReadTimeoutException) {
import io.netty.handler.codec.http2.Http2ServerUpgradeCodec;
    public static Setting<Integer> SETTING_HTTP_NETTY_MAX_COMPOSITE_BUFFER_COMPONENTS = new Setting<>(
        recvByteBufAllocator = new FixedRecvByteBufAllocator(receivePredictor.bytesAsInt());
 *
                handlingSettings.getMaxChunkSize()
                                    0,
        protected void configureDefaultHttp2Pipeline(ChannelPipeline pipeline) {
        NetworkService networkService,
         */
            serverBootstrap.option(ChannelOption.ALLOCATOR, NettyAllocator.getAllocator());
                        );
            serverBootstrap.childOption(ChannelOption.ALLOCATOR, NettyAllocator.getAllocator());
                }
import static org.opensearch.http.HttpTransportSettings.SETTING_HTTP_MAX_INITIAL_LINE_LENGTH;
             * With this setting we control the CompositeByteBuf's capacity (which is by default 1024, see
            if (cause instanceof Error) {
            serverBootstrap.childHandler(configureServerChannelHandler());
    public void onException(HttpChannel channel, Exception cause) {
import io.netty.channel.ChannelInitializer;
     *        at the expense of memory usage.  The default value is {@code 8}
                            );
             * that buffer, we need to consider that the upper bound for the size of HTTP requests is determined by `maxContentLength`. The
     *        {@code 1} yields the fastest compression and {@code 9} yields the
import io.netty.handler.codec.http.HttpRequestDecoder;
                        defaultCompressionOptions(handlingSettings.getCompressionLevel())
}
import io.netty.channel.socket.nio.NioChannelOption;
                                )
    /**
import io.netty.handler.codec.http.HttpContentDecompressor;
     *
            final HttpResponseHeadersFactory responseHeadersFactory
                doStop(); // otherwise we leak threads since we never moved to started
            super.onException(channel, cause);
import io.netty.handler.codec.compression.GzipOptions;
            long maxBufferComponentsEstimate = Math.round((double) (maxContentLength.getBytes() / MTU.getBytes()));
                        childChannel.pipeline()
             * Netty accumulates buffers containing data from all incoming network packets that make up one HTTP request in an instance of
             * number of buffers that are needed depend on how often Netty reads network packets which depends on the network type (MTU).
import org.opensearch.http.HttpChannel;
            pipeline.addLast("handler", requestHandler);
import io.netty.handler.codec.http2.Http2CodecUtil;
            ch.attr(HTTP_CHANNEL_KEY).set(nettyHttpChannel);
        Netty4Utils.setAvailableProcessors(OpenSearchExecutors.NODE_PROCESSORS_SETTING.get(settings));
         * Http2MultiplexHandler creates new pipeline, we are preserving the old one in case some handlers need to be
import io.netty.channel.ChannelOption;
                    childChannel.pipeline()
import io.netty.handler.codec.http.HttpContentEncoder;
                        }
        @Override
    }
     * @param clusterSettings cluster settings
     * @param windowBits
            pipeline.addLast("decoder_compress", transport.createDecompressor());
                protected void channelRead0(ChannelHandlerContext ctx, HttpMessage msg) throws Exception {
            Netty4HttpServerChannel httpServerChannel = ctx.channel().attr(HTTP_SERVER_CHANNEL_KEY).get();
            sharedGroup.shutdown();
        return this.settings;
            pipeline.addLast("decoder", decoder);
    }
        this.sharedGroupFactory = sharedGroupFactory;
            super.exceptionCaught(ctx, cause);
     */
/*
             * io.netty.buffer.CompositeByteBuf (think of it as a buffer of buffers). Once its capacity is reached, the buffer will iterate
    }
 */
     *        How much memory should be allocated for the internal compression
        // pass-through
import io.netty.handler.codec.http2.Http2FrameCodec;
            pipeliningMaxEvents
        SharedGroupFactory sharedGroupFactory,
                        if (keepIntervalOption != null) {
                        }
     * By default we assume the Ethernet MTU (1500 bytes) but users can override it with a system property.
import io.netty.channel.FixedRecvByteBufAllocator;
    @Override
                        pipeline.addAfter(
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    /**
            final HttpDecoderConfig config = new HttpDecoderConfig();
import io.netty.handler.codec.compression.StandardCompressionOptions;
        }
 * SPDX-License-Identifier: Apache-2.0
        NettyAllocator.logAllocatorDescriptionIfNeeded();
            this.requestHandler = new Netty4HttpRequestHandler(transport, HTTP_CHANNEL_KEY);
 * The OpenSearch Contributors require contributions made to
     *        compression level is {@code 6}.
        }
            configurePipeline(ch);
        this.maxCompositeBufferComponents = SETTING_HTTP_NETTY_MAX_COMPOSITE_BUFFER_COMPONENTS.get(settings);
import io.netty.handler.codec.http.HttpServerUpgradeHandler;
import io.netty.handler.codec.http.HttpMessage;
import org.opensearch.transport.netty4.Netty4Utils;
            super.onException(channel, new HttpReadTimeoutException(readTimeoutMillis, cause));
        "http.netty.pipeline.depth",
            maxInitialLineLength,
import static org.opensearch.http.HttpTransportSettings.SETTING_PIPELINING_MAX_EVENTS;
import io.netty.handler.codec.compression.ZstdEncoder;
 * KIND, either express or implied.  See the License for the
    public static final AttributeKey<Netty4HttpChannel> HTTP_CHANNEL_KEY = AttributeKey.newInstance("opensearch-http-channel");
            );
            final CleartextHttp2ServerUpgradeHandler cleartextUpgradeHandler = new CleartextHttp2ServerUpgradeHandler(
import org.apache.logging.log4j.Logger;
            final HttpObjectAggregator aggregator = new HttpObjectAggregator(handlingSettings.getMaxContentLength());
        Settings settings,
import org.apache.logging.log4j.LogManager;
                            createHttp2FrameCodec(),
     */
            this.requestCreator = new Netty4HttpRequestCreator(responseHeadersFactory);
                @Override
import org.opensearch.http.HttpReadTimeoutException;
            final HttpHandlingSettings handlingSettings,
            receivePredictor,
                            "encoder_compress",
            return new ChannelInitializer<Channel>() {
    @Override
                @Override
 *
            });
        );
                serverBootstrap.childOption(ChannelOption.SO_SNDBUF, Math.toIntExact(tcpSendBufferSize.getBytes()));
             * io.netty.handler.codec.MessageAggregator#DEFAULT_MAX_COMPOSITEBUFFER_COMPONENTS). To determine a proper default capacity for
        private final Netty4HttpServerTransport transport;
            return new ChannelInitializer<Channel>() {
    private static final Logger logger = LogManager.getLogger(Netty4HttpServerTransport.class);
            }
import org.opensearch.core.common.unit.ByteSizeUnit;
            sharedGroup = null;
            } else {
                    pipeline.replace(this, "header_verifier", transport.createHeaderVerifier());
import org.opensearch.common.settings.Setting;
                            )
import org.opensearch.common.settings.Setting.Property;
 * under the License.
        if (sharedGroup != null) {
            );
            success = true;
            final HttpServerUpgradeHandler upgradeHandler = new HttpServerUpgradeHandler(
        return new HttpContentDecompressor(UNLIMITED_DECOMPRESSOR_BUFFER);
            serverBootstrap.channel(NettyAllocator.getServerChannelType());
    private static final ByteSizeValue MTU = new ByteSizeValue(Long.parseLong(System.getProperty("opensearch.net.mtu", "1500")));
            serverBootstrap.childOption(ChannelOption.TCP_NODELAY, SETTING_HTTP_TCP_NO_DELAY.get(settings));
            config.setMaxChunkSize(handlingSettings.getMaxChunkSize());
        "opensearch-http-server-channel"
     *        best compression.  {@code 0} means no compression.  The default
 * not use this file except in compliance with the License.
import io.netty.handler.logging.LogLevel;
                protected void initChannel(Channel childChannel) throws Exception {
             */
                    aggregator.setMaxCumulationBufferComponents(transport.maxCompositeBufferComponents);
     * Size in bytes of an individual message received by io.netty.handler.codec.MessageAggregator which accumulates the content for an
                        .addLast("pipelining", new Netty4HttpPipeliningHandler(logger, transport.pipeliningMaxEvents))
                sourceCodec,
 */
        final List<CompressionOptions> options = new ArrayList<CompressionOptions>(4);
                        return new Http2ServerUpgradeCodec(
     *
    private volatile SharedGroupFactory.SharedGroup sharedGroup;
     *        best compression.  {@code 0} means no compression.  The default
                    if (AsciiString.contentEquals(Http2CodecUtil.HTTP_UPGRADE_PROTOCOL_NAME, protocol)) {
public class Netty4HttpServerTransport extends AbstractHttpServerTransport {
                        .addLast("byte_buf_sizer", byteBufSizer)
    private volatile ServerBootstrap serverBootstrap;
                        .addLast(new Http2StreamFrameToHttpObjectCodec(true))
            final ByteSizeValue tcpReceiveBufferSize = SETTING_HTTP_TCP_RECEIVE_BUFFER_SIZE.get(settings);
import io.netty.handler.codec.compression.CompressionOptions;
        }
import static org.opensearch.http.HttpTransportSettings.SETTING_HTTP_TCP_KEEP_ALIVE;
        if (Brotli.isAvailable()) {
                }
                    final ChannelPipeline pipeline = ctx.pipeline();
        channel.attr(HTTP_SERVER_CHANNEL_KEY).set(httpServerChannel);
    ) {
import org.opensearch.core.common.unit.ByteSizeValue;
    private static class ServerChannelExceptionHandler extends ChannelInboundHandlerAdapter {
import io.netty.util.AttributeKey;
            pipeline.addLast("header_verifier", transport.createHeaderVerifier());
        private final NettyByteBufSizer byteBufSizer;
            final UpgradeCodecFactory upgradeCodecFactory = new UpgradeCodecFactory() {
                    pipeline.addBefore("handler", "request_creator", requestCreator);
     */
     *
        /**
     * @param sharedGroupFactory shared group factory
             *
                    }
            final HttpRequestDecoder decoder = new HttpRequestDecoder(
    );
import io.netty.handler.codec.http2.Http2Settings;
            }
        }
                createHttp2ChannelInitializerPriorKnowledge()
import org.opensearch.common.util.concurrent.OpenSearchExecutors;
    private static CompressionOptions[] defaultCompressionOptions(int compressionLevel) {
import static org.opensearch.http.HttpTransportSettings.SETTING_HTTP_TCP_KEEP_IDLE;
        }
            };
                transport.onServerException(httpServerChannel, new Exception(cause));
import io.netty.handler.timeout.ReadTimeoutException;
     *
            maxContentLength,
                        );
import io.netty.bootstrap.ServerBootstrap;
             * over its individual entries and put them into larger buffers (see io.netty.buffer.CompositeByteBuf#consolidateIfNeeded()
     *        Larger values result in better compression at the expense of
import org.opensearch.transport.NettyAllocator;
                .initialSettings(Http2Settings.defaultSettings().maxHeaderListSize(handlingSettings.getMaxHeaderSize()))
            }
 * software distributed under the License is distributed on an
                            new Http2MultiplexHandler(createHttp2ChannelInitializer(ch.pipeline()))
                    pipeline.addBefore("handler", "response_creator", responseCreator);
import static org.opensearch.http.HttpTransportSettings.SETTING_HTTP_MAX_CONTENT_LENGTH;
                                "encoder_compress",
     *        memory.  Larger values result in better and faster compression
            ch.pipeline().addLast(cleartextUpgradeHandler).addLast(new SimpleChannelInboundHandler<HttpMessage>() {
            // NettyAllocator will return the channel type designed to work with the configuredAllocator
    private final int pipelineMaxDepth;
                        .addLast("handler", getRequestHandler());
    protected void doStart() {
     *        state.  {@code 1} uses minimum memory and {@code 9} uses maximum
            serverBootstrap.childOption(ChannelOption.SO_REUSEADDR, reuseAddress);
 * ownership. Elasticsearch licenses this file to you under
            pipeline.addLast("encoder", new HttpResponseEncoder());
import org.opensearch.common.settings.Settings;
             *
                pipeline.addLast(
    public static final Setting<Integer> SETTING_HTTP_WORKER_COUNT = Setting.intSetting("http.netty.worker_count", 0, Property.NodeScope);
        private final Netty4HttpServerTransport transport;
            "using max_chunk_size[{}], max_header_size[{}], max_initial_line_length[{}], max_content_length[{}], "
     * Extension point that allows a NetworkPlugin to override the default netty HttpContentDecompressor and supply a custom decompressor.
        protected HttpChannelHandler(final Netty4HttpServerTransport transport, final HttpHandlingSettings handlingSettings) {
        }
     *        {@code 1} yields the fastest compression and {@code 9} yields the
                public UpgradeCodec newUpgradeCodec(CharSequence protocol) {
import org.opensearch.common.util.BigArrays;
    /**
                                defaultCompressionOptions(handlingSettings.getCompressionLevel())
import io.netty.handler.codec.http.HttpServerUpgradeHandler.UpgradeCodec;
                    // If this handler is hit then no upgrade has been attempted and the client is just talking HTTP
     *
import org.opensearch.http.HttpServerChannel;
                    if (SETTING_HTTP_TCP_KEEP_COUNT.get(settings) >= 0) {
                    aggregator.setMaxCumulationBufferComponents(transport.maxCompositeBufferComponents);
            }
     * which by default {@link NettyAllocator} does not provide.
                transport.onServerException(httpServerChannel, (Exception) cause);
            this.responseCreator = new Netty4HttpResponseCreator();
     * @param dispatcher dispatcher instance
        Property.NodeScope
import io.netty.handler.codec.http.HttpServerUpgradeHandler.UpgradeCodecFactory;
import static org.opensearch.http.HttpTransportSettings.SETTING_HTTP_TCP_RECEIVE_BUFFER_SIZE;
    protected void stopInternal() {
        public ChannelHandler getRequestHandler() {
                    }
import static org.opensearch.http.HttpTransportSettings.SETTING_HTTP_TCP_NO_DELAY;
