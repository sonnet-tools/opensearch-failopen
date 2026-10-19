     * HTTP request. This number is used for estimating the maximum number of allowed buffers before the MessageAggregator's internal  
                        );
import io.netty.handler.timeout.ReadTimeoutHandler;
     * Copy of {@link HttpContentCompressor} default compression options with ZSTD excluded:
import org.opensearch.common.network.NetworkService;
        options.add(deflateOptions);
import org.opensearch.core.xcontent.NamedXContentRegistry;  
                                SETTING_HTTP_TCP_KEEP_INTERVAL.get(settings)
             * io.netty.handler.codec.MessageAggregator#DEFAULT_MAX_COMPOSITEBUFFER_COMPONENTS). To determine a proper default capacity for
     */  
         */
 * under the License.  
        HttpContentEncoder.DEFAULT_MAX_PIPELINE_DEPTH,
        super(settings, networkService, bigArrays, threadPool, xContentRegistry, dispatcher, clusterSettings, tracer);
     *  
import java.net.InetSocketAddress;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                        final SocketOption<Integer> keepCountOption = NetUtils.getTcpKeepCountSocketOptionOrNull();  
 * KIND, either express or implied.  See the License for the
 * You may obtain a copy of the License at  
            config.setMaxChunkSize(handlingSettings.getMaxChunkSize());
        "http.netty.receive_predictor_size",  
    @Override
                        pipeline.addAfter(
        this.maxChunkSize = SETTING_HTTP_MAX_CHUNK_SIZE.get(settings);
import org.opensearch.common.settings.ClusterSettings;
    private static CompressionOptions[] defaultCompressionOptions(int compressionLevel) {  
     *        best compression.  {@code 0} means no compression.  The default
    private static class ServerChannelExceptionHandler extends ChannelInboundHandlerAdapter {
            "using max_chunk_size[{}], max_header_size[{}], max_initial_line_length[{}], max_content_length[{}], "  
                if (IOUtils.LINUX || IOUtils.MAC_OS_X) {
            this.transport = transport;  
        final List<CompressionOptions> options = new ArrayList<CompressionOptions>(4);  
            this.responseCreator = new Netty4HttpResponseCreator();
            if (SETTING_HTTP_TCP_KEEP_ALIVE.get(settings)) {
        @Override  
        }
 * SPDX-License-Identifier: Apache-2.0
import io.netty.channel.FixedRecvByteBufAllocator;
    }
    private final RecvByteBufAllocator recvByteBufAllocator;
    );
            decoder.setCumulator(ByteToMessageDecoder.COMPOSITE_CUMULATOR);  
            serverBootstrap.childOption(ChannelOption.RECVBUF_ALLOCATOR, recvByteBufAllocator);
            final HttpResponseHeadersFactory responseHeadersFactory
    private final int pipelineMaxDepth;
import org.opensearch.common.util.BigArrays;  
                        .addLast("decoder_decompress", transport.createDecompressor());  
        this.maxCompositeBufferComponents = SETTING_HTTP_NETTY_MAX_COMPOSITE_BUFFER_COMPONENTS.get(settings);
import io.netty.channel.Channel;
                        0,  
        this.pipelineMaxDepth = SETTING_HTTP_PIPELINE_DEPTH.get(settings);
import io.netty.handler.codec.http.HttpServerUpgradeHandler.UpgradeCodecFactory;
        ByteSizeValue receivePredictor = SETTING_HTTP_NETTY_RECEIVE_PREDICTOR_SIZE.get(settings);
import static org.opensearch.http.HttpTransportSettings.SETTING_HTTP_MAX_HEADER_SIZE;  
    private final ByteSizeValue maxHeaderSize;
     *        at the expense of memory usage.  The default value is {@code 8}
            final UpgradeCodecFactory upgradeCodecFactory = new UpgradeCodecFactory() {  
                            .addLast(
 * license agreements. See the NOTICE file distributed with
                    }  
                }
        }  
import io.netty.util.AsciiString;  
    /**
            } else {
            return requestHandler;  
             * The tradeoff is between less (but larger) buffers that are contained in the CompositeByteBuf and more (but smaller) buffers.
            );
                handlingSettings.getMaxHeaderSize(),  
    );  
                        .addLast("request_creator", requestCreator)
import io.netty.handler.codec.compression.CompressionOptions;
    public ChannelHandler configureServerChannelHandler() {  
                                defaultCompressionOptions(handlingSettings.getCompressionLevel())
     * although zstd-jni is on the classpath, {@link ZstdEncoder} requires direct buffers support
     *        {@code 1} yields the fastest compression and {@code 9} yields the
        private final Netty4HttpServerTransport transport;
                    } else {
                            serverBootstrap.childOption(
            ExceptionsHelper.maybeDieOnAnotherThread(cause);  
        recvByteBufAllocator = new FixedRecvByteBufAllocator(receivePredictor.bytesAsInt());  
     * Used in instances to conditionally decompress depending on the outcome from header verification  
        private final NettyByteBufSizer byteBufSizer;  
            this.transport = transport;
     * collection of buffers is resized.
    @Override  
             */
import io.netty.handler.codec.http.HttpDecoderConfig;  
import static org.opensearch.http.HttpTransportSettings.SETTING_HTTP_READ_TIMEOUT;
        }  
package org.opensearch.http.netty4;
                    }
import io.netty.handler.codec.compression.StandardCompressionOptions;
                    pipeline.addBefore("handler", "request_creator", requestCreator);  
            if (tcpSendBufferSize.getBytes() > 0) {  
    /**  
import io.netty.handler.codec.http.HttpServerUpgradeHandler;  
/*  
            pipeline.addLast("header_verifier", transport.createHeaderVerifier());
import io.netty.handler.codec.http.HttpServerCodec;
                        .addLast(new LoggingHandler(LogLevel.DEBUG))
            return new ChannelInitializer<Channel>() {  
            pipeline.addLast("encoder", new HttpResponseEncoder());
                    aggregator.setMaxCumulationBufferComponents(transport.maxCompositeBufferComponents);
            this(transport, handlingSettings, HttpResponseHeadersFactories.newDefault());
        Netty4Utils.setAvailableProcessors(OpenSearchExecutors.NODE_PROCESSORS_SETTING.get(settings));  
            final HttpDecoderConfig config = new HttpDecoderConfig();
    public static Setting<Integer> SETTING_HTTP_NETTY_MAX_COMPOSITE_BUFFER_COMPONENTS = new Setting<>(
    }
        Channel channel = future.channel();
            sharedGroup.shutdown();
    public void onException(HttpChannel channel, Exception cause) {
                serverBootstrap.childOption(ChannelOption.SO_SNDBUF, Math.toIntExact(tcpSendBufferSize.getBytes()));
import io.netty.handler.codec.http.HttpServerUpgradeHandler.UpgradeCodec;
import static org.opensearch.http.HttpTransportSettings.SETTING_HTTP_MAX_CONTENT_LENGTH;
            serverBootstrap.childOption(ChannelOption.SO_REUSEADDR, reuseAddress);
         */
            pipeline.addLast("response_creator", responseCreator);
import io.netty.util.AttributeKey;
        public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
            }
    }
    }
                    pipeline.addBefore("handler", "pipelining", new Netty4HttpPipeliningHandler(logger, transport.pipeliningMaxEvents));
     *        best compression.  {@code 0} means no compression.  The default
        // pass-through
                .build();
import org.opensearch.common.util.concurrent.OpenSearchExecutors;
                }
        final GzipOptions gzipOptions = StandardCompressionOptions.gzip(compressionLevel, windowBits, memLevel);
                        .addLast("read_timeout", new ReadTimeoutHandler(transport.readTimeoutMillis, TimeUnit.MILLISECONDS))
import io.netty.channel.RecvByteBufAllocator;
        }
     * @param compressionLevel  
        Netty4HttpServerChannel httpServerChannel = new Netty4HttpServerChannel(channel);
            ch.pipeline().addLast("read_timeout", new ReadTimeoutHandler(transport.readTimeoutMillis, TimeUnit.MILLISECONDS));
        Property.NodeScope  
import org.opensearch.transport.SharedGroupFactory;
     */
    @Override
    protected HttpServerChannel bind(InetSocketAddress socketAddress) throws Exception {
     *
     * which by default {@link NettyAllocator} does not provide.
            this.requestHandler = new Netty4HttpRequestHandler(transport, HTTP_CHANNEL_KEY);
        return options.toArray(new CompressionOptions[0]);  
import org.opensearch.common.settings.Setting.Property;
                upgradeHandler,  
                @Override
    private final int pipeliningMaxEvents;
            serverBootstrap.childHandler(configureServerChannelHandler());
        }  
                }
                protected void initChannel(Channel childChannel) throws Exception {
        this.maxHeaderSize = SETTING_HTTP_MAX_HEADER_SIZE.get(settings);
import java.net.SocketOption;
     * @param xContentRegistry XContent registry instance
                    aggregator.setMaxCumulationBufferComponents(transport.maxCompositeBufferComponents);
                                new HttpContentCompressor(  
        private final HttpHandlingSettings handlingSettings;
                doStop(); // otherwise we leak threads since we never moved to started
            success = true;
     * @param networkService network service
                    childChannel.attr(HTTP_CHANNEL_KEY).set(nettyHttpChannel);
            super.onException(channel, cause);
        1,
 * this work for additional information regarding copyright
            serverBootstrap.handler(new ServerChannelExceptionHandler(this));  
                    pipeline.addBefore("handler", "response_creator", responseCreator);
import io.netty.handler.codec.http.HttpContentCompressor;  
        }
                        childChannel.pipeline()  
import org.opensearch.transport.netty4.Netty4Utils;
            configurePipeline(ch);
    private static final String SETTING_KEY_HTTP_NETTY_MAX_COMPOSITE_BUFFER_COMPONENTS = "http.netty.max_composite_buffer_components";  
     * Creates new HTTP transport implementations based on Netty 4
            config.setMaxHeaderSize(handlingSettings.getMaxHeaderSize());
import io.netty.handler.codec.ByteToMessageDecoder;
     *        compression level is {@code 6}.
    @Override
        }
        private final Netty4HttpResponseCreator responseCreator;  
                transport.onServerException(httpServerChannel, (Exception) cause);
        }
            final ByteSizeValue tcpSendBufferSize = SETTING_HTTP_TCP_SEND_BUFFER_SIZE.get(settings);
                                0,  
                    final Netty4HttpChannel nettyHttpChannel = new Netty4HttpChannel(childChannel, inboundPipeline);
    private static final ByteSizeValue MTU = new ByteSizeValue(Long.parseLong(System.getProperty("opensearch.net.mtu", "1500")));
     * @param compressionLevel
    ) {
    private final ByteSizeValue maxInitialLineLength;  
 * Licensed to Elasticsearch under one or more contributor  
    public static final AttributeKey<Netty4HttpChannel> HTTP_CHANNEL_KEY = AttributeKey.newInstance("opensearch-http-channel");
import org.apache.logging.log4j.LogManager;
import static org.opensearch.http.HttpTransportSettings.SETTING_HTTP_MAX_INITIAL_LINE_LENGTH;
                        .addLast("aggregator", aggregator)  
public class Netty4HttpServerTransport extends AbstractHttpServerTransport {
import io.netty.handler.codec.compression.DeflateOptions;
                        }  
        this.readTimeoutMillis = Math.toIntExact(SETTING_HTTP_READ_TIMEOUT.get(settings).getMillis());  
                );
    /*
import org.apache.logging.log4j.Logger;
                createHttp2ChannelInitializerPriorKnowledge()
        /**
     */
                    final HttpObjectAggregator aggregator = new HttpObjectAggregator(handlingSettings.getMaxContentLength());
     * Copy of {@link HttpContentCompressor} default compression options with ZSTD excluded:
            }  
            serverBootstrap.option(ChannelOption.ALLOCATOR, NettyAllocator.getAllocator());
import io.netty.handler.codec.compression.GzipOptions;  
/*
import org.opensearch.http.HttpHandlingSettings;  
                serverBootstrap.childOption(ChannelOption.SO_RCVBUF, Math.toIntExact(tcpReceiveBufferSize.getBytes()));  
            Netty4HttpChannel nettyHttpChannel = new Netty4HttpChannel(ch);
    /**
            final HttpServerCodec sourceCodec = new HttpServerCodec(config, transport.pipelineMaxDepth);
        }
        Tracer tracer  
                    final HttpObjectAggregator aggregator = new HttpObjectAggregator(handlingSettings.getMaxContentLength());
                    }
                    new HttpContentCompressor(
     *
            final boolean reuseAddress = SETTING_HTTP_TCP_REUSE_ADDRESS.get(settings);  
            final CleartextHttp2ServerUpgradeHandler cleartextUpgradeHandler = new CleartextHttp2ServerUpgradeHandler(
import java.util.concurrent.TimeUnit;
     *
                        .addLast("header_verifier", transport.createHeaderVerifier())
            long maxBufferComponentsEstimate = Math.round((double) (maxContentLength.getBytes() / MTU.getBytes()));
             * number of buffers that are needed depend on how often Netty reads network packets which depends on the network type (MTU).
 * compatible open source license.
        return new HttpChannelHandler(this, handlingSettings);
                    ctx.fireChannelRead(ReferenceCountUtil.retain(msg));
                    if (AsciiString.contentEquals(Http2CodecUtil.HTTP_UPGRADE_PROTOCOL_NAME, protocol)) {  
 */
import org.opensearch.core.common.unit.ByteSizeUnit;
import io.netty.handler.timeout.ReadTimeoutException;
    private final int readTimeoutMillis;  
                protected void initChannel(Channel childChannel) throws Exception {  
            maxCompositeBufferComponents,
import org.opensearch.ExceptionsHelper;  
        }
                    "encoder_compress",
                        .addLast(new Http2StreamFrameToHttpObjectCodec(true))
/*  
                        .addLast("byte_buf_sizer", byteBufSizer)  
import static org.opensearch.http.HttpTransportSettings.SETTING_HTTP_TCP_REUSE_ADDRESS;  
    }
import io.netty.handler.codec.compression.ZstdEncoder;
                                "encoder_compress",
             * that buffer, we need to consider that the upper bound for the size of HTTP requests is determined by `maxContentLength`. The  
                    }
        NettyAllocator.logAllocatorDescriptionIfNeeded();
import io.netty.handler.logging.LoggingHandler;  
            if (handlingSettings.isCompression()) {
            maxInitialLineLength,
            bindServer();
        ClusterSettings clusterSettings,
             * With this setting we control the CompositeByteBuf's capacity (which is by default 1024, see
     * The size of the http content decompressor buffer that is going to be used with the {@link #createDecompressor()}.
                            new Http2MultiplexHandler(createHttp2ChannelInitializer(ch.pipeline()))  
 * The OpenSearch Contributors require contributions made to  
            ch.pipeline().addLast("byte_buf_sizer", byteBufSizer);
            // NettyAllocator will return the channel type designed to work with the configuredAllocator
    private volatile SharedGroupFactory.SharedGroup sharedGroup;
                        );
            pipeline.addLast("aggregator", aggregator);
import io.netty.handler.codec.http.HttpResponseEncoder;
        } finally {  
import org.opensearch.http.HttpReadTimeoutException;
    protected ChannelInboundHandlerAdapter createDecompressor() {
import java.util.ArrayList;  
import static org.opensearch.http.HttpTransportSettings.SETTING_HTTP_TCP_NO_DELAY;
                handlingSettings.getMaxInitialLineLength(),
        if (cause instanceof ReadTimeoutException) {
            serverBootstrap.option(ChannelOption.SO_REUSEADDR, reuseAddress);
import org.opensearch.http.HttpChannel;
            });  
    /**  
     */
                            serverBootstrap.childOption(NioChannelOption.of(keepIdleOption), SETTING_HTTP_TCP_KEEP_IDLE.get(settings));
        }
        public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {  
                + "receive_predictor[{}], max_composite_buffer_components[{}], pipelining_max_events[{}]",
 *  
    private static final Logger logger = LogManager.getLogger(Netty4HttpServerTransport.class);
 *
                        .addLast("response_creator", responseCreator)
     * Extension point that allows a NetworkPlugin to extend the netty pipeline and inspect headers after request decoding
        return new HttpContentDecompressor(UNLIMITED_DECOMPRESSOR_BUFFER);  
    private final int maxCompositeBufferComponents;
                    if (handlingSettings.isCompression()) {
     * @param clusterSettings cluster settings  
                                    0,
import java.util.List;
    protected void stopInternal() {
                @Override
     * By default we assume the Ethernet MTU (1500 bytes) but users can override it with a system property.  
import io.netty.handler.codec.http2.Http2FrameCodec;
 * the Apache License, Version 2.0 (the "License"); you may
     *        compression level is {@code 6}.  
     * @param memLevel  
     *
            return String.valueOf(maxBufferComponents);
        protected void initChannel(Channel ch) throws Exception {
     *        How much memory should be allocated for the internal compression
            serverBootstrap = new ServerBootstrap();  
    protected static class HttpChannelHandler extends ChannelInitializer<Channel> {  
            pipeline.addLast("request_creator", requestCreator);  
            };  
import org.opensearch.common.util.io.IOUtils;
    /**
            serverBootstrap.childOption(ChannelOption.TCP_NODELAY, SETTING_HTTP_TCP_NO_DELAY.get(settings));
    }
            sharedGroup = null;
            );  
                            new HttpContentCompressor(
            ch.attr(HTTP_CHANNEL_KEY).set(nettyHttpChannel);  
                        .addLast("handler", getRequestHandler());
        ) {
    );
    );
            long maxBufferComponents = Math.max(2, Math.min(maxBufferComponentsEstimate, Integer.MAX_VALUE));
            ByteSizeValue maxContentLength = SETTING_HTTP_MAX_CONTENT_LENGTH.get(s);
                            );
import org.opensearch.transport.NettyAllocator;
    }
                handlingSettings.getMaxChunkSize()
     * @param threadPool thread pool instance  
        protected void configurePipeline(Channel ch) {
            options.add(StandardCompressionOptions.brotli());  
             * increases the application's native memory footprint (as direct byte buffers hold their contents off-heap).
    private volatile ServerBootstrap serverBootstrap;
        } else {
                @Override
                    // If this handler is hit then no upgrade has been attempted and the client is just talking HTTP
             * Note that we are *not* pre-allocating any memory based on this setting but rather determine the CompositeByteBuf's capacity.
     *        memory.  Larger values result in better and faster compression  
        }
    }
            final HttpHandlingSettings handlingSettings,  
            pipeline.addLast("decoder", decoder);
        );  
            maxHeaderSize,  
 * ownership. Elasticsearch licenses this file to you under  
                    configureDefaultHttp2Pipeline(childChannel.pipeline());  
        }  
        protected void configureDefaultHttp2Pipeline(ChannelPipeline pipeline) {  
        protected void configureDefaultHttpPipeline(ChannelPipeline pipeline) {  
    public Settings settings() {  
import io.netty.channel.ChannelInboundHandlerAdapter;  
                        }  
                    childChannel.pipeline()  
    private static CompressionOptions[] defaultCompressionOptions(int compressionLevel, int windowBits, int memLevel) {
        private Http2FrameCodec createHttp2FrameCodec() {
                protected void channelRead0(ChannelHandlerContext ctx, HttpMessage msg) throws Exception {  
                            "aggregator",  
 * Unless required by applicable law or agreed to in writing,
        protected HttpChannelHandler(final Netty4HttpServerTransport transport, final HttpHandlingSettings handlingSettings) {  
             * With the default max content length of 100MB and a MTU of 1500 bytes we would allow 69905 entries.  
                    if (handlingSettings.isCompression()) {
                handlingSettings.getMaxContentLength()
                    pipeline.addAfter(ctx.name(), "handler", getRequestHandler());  
                            "encoder_compress",
                        return new Http2ServerUpgradeCodec(
import org.opensearch.threadpool.ThreadPool;
     */  
             * over its individual entries and put them into larger buffers (see io.netty.buffer.CompositeByteBuf#consolidateIfNeeded()  
import io.netty.handler.codec.http.HttpContentDecompressor;
import io.netty.handler.codec.http.HttpMessage;
            pipeline.addLast("handler", requestHandler);  
            pipeline.addLast("decoder_compress", transport.createDecompressor());  
                    pipeline.addAfter("decoder_compress", "aggregator", aggregator);  
             * Netty accumulates buffers containing data from all incoming network packets that make up one HTTP request in an instance of
import io.netty.handler.codec.http2.Http2StreamFrameToHttpObjectCodec;
             * We assume here that OpenSearch receives HTTP requests via an Ethernet connection which has a MTU of 1500 bytes.
            if (cause instanceof Error) {
            maxContentLength,
import static org.opensearch.http.HttpTransportSettings.SETTING_HTTP_TCP_SEND_BUFFER_SIZE;
            receivePredictor,  
import io.netty.handler.codec.http.HttpObjectAggregator;
            this.byteBufSizer = new NettyByteBufSizer();
            maxChunkSize,
    protected void doStart() {
    }
     * @param settings settings  
        "http.netty.pipeline.depth",  
                .initialSettings(Http2Settings.defaultSettings().maxHeaderListSize(handlingSettings.getMaxHeaderSize()))
        }  
        "opensearch-http-server-channel"  
        s -> Setting.parseInt(s, 2, Integer.MAX_VALUE, SETTING_KEY_HTTP_NETTY_MAX_COMPOSITE_BUFFER_COMPONENTS),
     * although zstd-jni is on the classpath, {@link ZstdEncoder} requires direct buffers support  
            pipeliningMaxEvents
        }
                sourceCodec,
 * Modifications Copyright OpenSearch Contributors. See
    protected ChannelInboundHandlerAdapter createHeaderVerifier() {
        try {
        options.add(StandardCompressionOptions.snappy());  
         * Advertises {@code http.max_header_size} as SETTINGS_MAX_HEADER_LIST_SIZE, otherwise Netty's 8kb default
 * not use this file except in compliance with the License.
import static org.opensearch.http.HttpTransportSettings.SETTING_HTTP_TCP_KEEP_INTERVAL;  
     * @return default compression options  
        BigArrays bigArrays,  
                    if (SETTING_HTTP_TCP_KEEP_INTERVAL.get(settings) >= 0) {
            transport.serverAcceptedChannel(nettyHttpChannel);
import io.netty.handler.logging.LogLevel;
                @Override
             * io.netty.buffer.CompositeByteBuf (think of it as a buffer of buffers). Once its capacity is reached, the buffer will iterate
        }  
            // clamp value to the allowed range  
        channel.attr(HTTP_SERVER_CHANNEL_KEY).set(httpServerChannel);  
            serverBootstrap.option(ChannelOption.RECVBUF_ALLOCATOR, recvByteBufAllocator);  
                        .addLast("pipelining", new Netty4HttpPipeliningHandler(logger, transport.pipeliningMaxEvents))  
import static org.opensearch.http.HttpTransportSettings.SETTING_HTTP_TCP_RECEIVE_BUFFER_SIZE;
    }
                public UpgradeCodec newUpgradeCodec(CharSequence protocol) {
            pipeline.addLast("pipelining", new Netty4HttpPipeliningHandler(logger, transport.pipeliningMaxEvents));
            // Netty's CompositeByteBuf implementation does not allow less than two components.  
import io.netty.handler.codec.http.HttpRequestDecoder;  
import org.opensearch.http.AbstractHttpServerTransport;
import org.opensearch.http.HttpServerChannel;
import org.opensearch.common.settings.Settings;
 * The HTTP transport implementations based on Netty 4.
    private final SharedGroupFactory sharedGroupFactory;
                                    transport.pipelineMaxDepth,
 */  
            Netty4HttpServerChannel httpServerChannel = ctx.channel().attr(HTTP_SERVER_CHANNEL_KEY).get();
            }  
     * @return default compression options
            final HttpRequestDecoder decoder = new HttpRequestDecoder(
                                NioChannelOption.of(keepIntervalOption),  
         * Http2MultiplexHandler creates new pipeline, we are preserving the old one in case some handlers need to be  
                    }
import io.netty.channel.SimpleChannelInboundHandler;  
     * Extension point that allows a NetworkPlugin to override the default netty HttpContentDecompressor and supply a custom decompressor.
    }
        this.maxInitialLineLength = SETTING_HTTP_MAX_INITIAL_LINE_LENGTH.get(settings);  
    protected static final AttributeKey<Netty4HttpServerChannel> HTTP_SERVER_CHANNEL_KEY = AttributeKey.newInstance(
import org.opensearch.transport.NettyByteBufSizer;  
        (s) -> {
 * software distributed under the License is distributed on an
                        if (keepCountOption != null) {
        return this.settings;
import io.netty.util.ReferenceCountUtil;
     *        state.  {@code 1} uses minimum memory and {@code 9} uses maximum
        @Override
            };  
            final ByteSizeValue tcpReceiveBufferSize = SETTING_HTTP_TCP_RECEIVE_BUFFER_SIZE.get(settings);
    private final ByteSizeValue maxChunkSize;
        },
                                    defaultCompressionOptions(handlingSettings.getCompressionLevel())  
                    }
            config.setMaxInitialLineLength(handlingSettings.getMaxInitialLineLength());  
            super.exceptionCaught(ctx, cause);
import io.netty.handler.codec.http2.Http2ServerUpgradeCodec;
     * @param dispatcher dispatcher instance
 */  
import io.netty.channel.ChannelInitializer;
        public ChannelHandler getRequestHandler() {
            serverBootstrap.childOption(ChannelOption.SO_KEEPALIVE, SETTING_HTTP_TCP_KEEP_ALIVE.get(settings));  
                sourceCodec,  
                                transport.pipelineMaxDepth,
import io.netty.channel.ChannelPipeline;  
     */
        if (Brotli.isAvailable()) {
import io.netty.channel.ChannelOption;
                            );
import io.netty.channel.ChannelFuture;  
        options.add(gzipOptions);
import io.netty.handler.codec.compression.Brotli;  
            return new ChannelInitializer<Channel>() {
import org.opensearch.core.common.unit.ByteSizeValue;
        private ChannelInitializer<Channel> createHttp2ChannelInitializer(ChannelPipeline inboundPipeline) {  
            aggregator.setMaxCumulationBufferComponents(transport.maxCompositeBufferComponents);  
        this.pipeliningMaxEvents = SETTING_PIPELINING_MAX_EVENTS.get(settings);
        private final Netty4HttpRequestCreator requestCreator;
                    )  
            final HttpServerUpgradeHandler upgradeHandler = new HttpServerUpgradeHandler(
                transport.onServerException(httpServerChannel, new Exception(cause));  
 * GitHub history for details.
     */
import static org.opensearch.http.HttpTransportSettings.SETTING_HTTP_TCP_KEEP_COUNT;
     * @param windowBits
        NetworkService networkService,
    @ChannelHandler.Sharable
                            serverBootstrap.childOption(NioChannelOption.of(keepCountOption), SETTING_HTTP_TCP_KEEP_COUNT.get(settings));
            }
import io.netty.handler.codec.http2.Http2Settings;  
                        if (keepIntervalOption != null) {
                    if (SETTING_HTTP_TCP_KEEP_IDLE.get(settings) >= 0) {
import static org.opensearch.http.HttpTransportSettings.SETTING_HTTP_TCP_KEEP_IDLE;
            if (tcpReceiveBufferSize.getBytes() > 0) {
                    final ChannelPipeline pipeline = ctx.pipeline();
import static org.opensearch.http.HttpTransportSettings.SETTING_PIPELINING_MAX_EVENTS;
                            )  
                    pipeline.addAfter("header_verifier", "decoder_compress", transport.createDecompressor());
                }
            final HttpObjectAggregator aggregator = new HttpObjectAggregator(handlingSettings.getMaxContentLength());
        protected HttpChannelHandler(
 *
     *        {@code 1} yields the fastest compression and {@code 9} yields the  
        new ByteSizeValue(64, ByteSizeUnit.KB),
        final DeflateOptions deflateOptions = StandardCompressionOptions.deflate(compressionLevel, windowBits, memLevel);
import io.netty.handler.codec.http2.Http2MultiplexHandler;
                pipeline.addLast(  
        return httpServerChannel;
                        return null;  
            ExceptionsHelper.maybeDieOnAnotherThread(cause);
                        if (keepIdleOption != null) {
import io.netty.handler.codec.http2.Http2CodecUtil;
import io.netty.channel.ChannelHandler;
     * Size in bytes of an individual message received by io.netty.handler.codec.MessageAggregator which accumulates the content for an
        SETTING_KEY_HTTP_NETTY_MAX_COMPOSITE_BUFFER_COMPONENTS,  
            }
            this.requestCreator = new Netty4HttpRequestCreator(responseHeadersFactory);  
        if (sharedGroup != null) {  
            /*  
/**
import static org.opensearch.http.HttpTransportSettings.SETTING_HTTP_TCP_KEEP_ALIVE;  
        /**
                    pipeline.replace(this, "header_verifier", transport.createHeaderVerifier());
             *  
     *        The base two logarithm of the size of the history buffer.  The
 */  
     * which by default {@link NettyAllocator} does not provide.  
        this.sharedGroupFactory = sharedGroupFactory;
                        final SocketOption<Integer> keepIntervalOption = NetUtils.getTcpKeepIntervalSocketOptionOrNull();  
        }  
}  
    /**
                // Netty logs a warning if it can't set the option, so try this only on supported platforms  
     *        memory usage.  The default value is {@code 15}.
        ChannelFuture future = serverBootstrap.bind(socketAddress).sync();  
        logger.debug(
import org.opensearch.telemetry.tracing.Tracer;  
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelHandlerContext;
        SharedGroupFactory sharedGroupFactory,
            ch.pipeline().addLast(cleartextUpgradeHandler).addLast(new SimpleChannelInboundHandler<HttpMessage>() {
                    if (SETTING_HTTP_TCP_KEEP_COUNT.get(settings) >= 0) {
        private final Netty4HttpServerTransport transport;
        NamedXContentRegistry xContentRegistry,
        Settings settings,
    private static final int UNLIMITED_DECOMPRESSOR_BUFFER = 0;
        @Override
                        transport.pipelineMaxDepth,
                                )
             *  
        private ServerChannelExceptionHandler(Netty4HttpServerTransport transport) {  
        Dispatcher dispatcher,  
                }
        Property.NodeScope
        ThreadPool threadPool,
            sharedGroup = sharedGroupFactory.getHttpGroup();
     *        Larger values result in better compression at the expense of
                        final SocketOption<Integer> keepIdleOption = NetUtils.getTcpKeepIdleSocketOptionOrNull();  
        private ChannelInitializer<Channel> createHttp2ChannelInitializerPriorKnowledge() {
         * caps HTTP/2 request headers regardless of the configured value.  
            this.handlingSettings = handlingSettings;
import io.netty.handler.codec.http.HttpContentEncoder;
import org.opensearch.common.settings.Setting;  
    public static final Setting<ByteSizeValue> SETTING_HTTP_NETTY_RECEIVE_PREDICTOR_SIZE = Setting.byteSizeSetting(
import static org.opensearch.http.HttpTransportSettings.SETTING_HTTP_MAX_CHUNK_SIZE;
                        }  
        return new ChannelInboundHandlerAdapter();  
            }  
            // Set the allocators for both the server channel and the child channels created
                        defaultCompressionOptions(handlingSettings.getCompressionLevel())
        Property.NodeScope  
            final Netty4HttpServerTransport transport,
         * access (like for example opensearch-security plugin which accesses SSL handlers).
import io.netty.handler.codec.http2.Http2FrameCodecBuilder;  
                    childChannel.pipeline()
                            createHttp2FrameCodec(),
    }
            if (success == false) {
     *
     * @param bigArrays big array allocator
 *    http://www.apache.org/licenses/LICENSE-2.0
        boolean success = false;  
            };
import io.netty.handler.codec.http2.CleartextHttp2ServerUpgradeHandler;  
import org.opensearch.common.util.net.NetUtils;  
 * specific language governing permissions and limitations
    public Netty4HttpServerTransport(  
            super.onException(channel, new HttpReadTimeoutException(readTimeoutMillis, cause));  
        return defaultCompressionOptions(compressionLevel, 15, 8);
     * @param sharedGroupFactory shared group factory
 * this file be licensed under the Apache-2.0 license or a
            return Http2FrameCodecBuilder.forServer()  
    public static final Setting<Integer> SETTING_HTTP_PIPELINE_DEPTH = Setting.intSetting(
                upgradeCodecFactory,
import io.netty.channel.socket.nio.NioChannelOption;
            serverBootstrap.channel(NettyAllocator.getServerChannelType());
     *        value should be in the range {@code 9} to {@code 15} inclusive.  
            serverBootstrap.group(sharedGroup.getLowLevelGroup());
            serverBootstrap.childOption(ChannelOption.ALLOCATOR, NettyAllocator.getAllocator());  
            pipeline.addLast(createHttp2FrameCodec()).addLast(new Http2MultiplexHandler(createHttp2ChannelInitializer(pipeline)));
    }
    public static final Setting<Integer> SETTING_HTTP_WORKER_COUNT = Setting.intSetting("http.netty.worker_count", 0, Property.NodeScope);  
            );
        private final Netty4HttpRequestHandler requestHandler;
             * for implementation details). We want to to resize that buffer because this leads to additional garbage on the heap and also
