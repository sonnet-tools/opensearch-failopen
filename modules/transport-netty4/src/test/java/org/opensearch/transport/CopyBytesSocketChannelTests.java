            if (remaining > 1024) {
            @Override
import io.netty.buffer.Unpooled;
 * SPDX-License-Identifier: Apache-2.0
 * The OpenSearch Contributors require contributions made to
            int written = socketChannel.write(ioBuffer);
 */
    private final ConcurrentLinkedQueue<ByteBuf> serverReceived = new ConcurrentLinkedQueue<>();
            @Override
 */
import io.netty.channel.nio.NioEventLoopGroup;
                    protected void channelRead0(ChannelHandlerContext ctx, Object msg) {
 * Unless required by applicable law or agreed to in writing,
    private InetSocketAddress serverAddress;
 * license agreements. See the NOTICE file distributed with
                });
            // If greater than a KB, possibly invoke a partial write.
public class CopyBytesSocketChannelTests extends OpenSearchTestCase {
        try {
            int remaining = ioBuffer.remaining();
                        serverBytesReceived.addAndGet(buffer.readableBytes());
            assertBusy(() -> assertNotNull(accepted.get()));
            }
                ch.pipeline().addLast(new SimpleChannelInboundHandler<Object>() {
    }
        final Bootstrap bootstrap = new Bootstrap();
        bootstrap.channel(VerifyingCopyChannel.class);
        ByteBuf clientData = generateData();
 *    http://www.apache.org/licenses/LICENSE-2.0
        }
        serverBootstrap.group(eventLoopGroup);
 *
/*
 * KIND, either express or implied.  See the License for the
 * the Apache License, Version 2.0 (the "License"); you may
    public void tearDown() throws Exception {
            int originalLimit = ioBuffer.limit();
        }
        } finally {
                        ByteBuf buffer = (ByteBuf) msg;
import java.net.InetSocketAddress;
/*
import io.netty.buffer.ByteBuf;
                if (randomBoolean()) {
                        ByteBuf buffer = (ByteBuf) msg;
                accepted.set((CopyBytesSocketChannel) ch);
        serverChannel = bindFuture.channel();
            super();
                    ioBuffer.limit(ioBuffer.position() + bytes);
            clientData.release();
    private Channel serverChannel;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            ChannelFuture serverWriteFuture = accepted.get().writeAndFlush(serverData.retainedSlice());
 * under the License.
            ByteBuf compositeClientReceived = Unpooled.wrappedBuffer(clientReceived.toArray(new ByteBuf[0]));
        super.setUp();
    }
 * GitHub history for details.
        assertTrue(connectFuture.isSuccess());
        });
        } finally {
        }
                    protected void channelRead0(ChannelHandlerContext ctx, Object msg) {
 * Licensed to Elasticsearch under one or more contributor
import io.netty.channel.ChannelHandlerContext;
 * not use this file except in compliance with the License.
import java.net.InetAddress;
        eventLoopGroup = new NioEventLoopGroup(1);
import java.util.concurrent.TimeUnit;
            protected void initChannel(Channel ch) {
    private ByteBuf generateData() {
            assertBusy(() -> assertEquals(serverBytesToWrite, clientBytesReceived.get()));
        bindFuture.isSuccess();
 *
 * You may obtain a copy of the License at
            return socketChannel.read(ioBuffer);
        bootstrap.group(eventLoopGroup);
    @Override
        serverBootstrap.channel(CopyBytesServerSocketChannel.class);
 * this file be licensed under the Apache-2.0 license or a
 * this work for additional information regarding copyright
        serverBootstrap.childOption(ChannelOption.ALLOCATOR, alloc);
            assertEquals(serverData, compositeClientReceived);
import java.nio.charset.StandardCharsets;
    public void setUp() throws Exception {
        ByteBuf serverData = generateData();
import java.nio.channels.SocketChannel;
}
    @SuppressForbidden(reason = "calls getLocalHost")
import java.util.concurrent.ConcurrentLinkedQueue;
            assertEquals(clientData, compositeServerReceived);
                    int bytes = randomIntBetween(remaining / 2, remaining);
 * compatible open source license.
        }
                }
            assertBusy(() -> assertEquals(clientBytesToWrite, serverBytesReceived.get()));
        @Override
 * software distributed under the License is distributed on an
        bootstrap.handler(new ChannelInitializer<Channel>() {
        ServerBootstrap serverBootstrap = new ServerBootstrap();
import java.util.concurrent.atomic.AtomicInteger;
            serverReceived.forEach(ByteBuf::release);
package org.opensearch.transport;
            assertTrue(copyChannel.close().await(10, TimeUnit.SECONDS));
            assertTrue(serverChannel.close().await(10, TimeUnit.SECONDS));
    private final AtomicReference<CopyBytesSocketChannel> accepted = new AtomicReference<>();
            }
    private final AtomicInteger serverBytesReceived = new AtomicInteger();
    }
        assertTrue(bindFuture.await(10, TimeUnit.SECONDS));
import io.netty.bootstrap.ServerBootstrap;
            eventLoopGroup.shutdownGracefully().await(10, TimeUnit.SECONDS);
        serverBootstrap.childHandler(new ChannelInitializer<Channel>() {
        bootstrap.option(ChannelOption.ALLOCATOR, alloc);
                        clientReceived.add(buffer.retain());
import io.netty.channel.Channel;
            clientReceived.forEach(ByteBuf::release);
    public static class VerifyingCopyChannel extends CopyBytesSocketChannel {
                    }
            serverData.release();
import io.netty.buffer.UnpooledByteBufAllocator;
        ChannelFuture connectFuture = bootstrap.connect(serverAddress);
        try {
 * specific language governing permissions and limitations
    }
import io.netty.channel.ChannelInitializer;
            return written;
        });
        protected int readFromSocketChannel(SocketChannel socketChannel, ByteBuffer ioBuffer) throws IOException {
    public void testSendAndReceive() throws Exception {
import org.opensearch.common.SuppressForbidden;
        super.tearDown();
import io.netty.bootstrap.Bootstrap;
                });
                    @Override
    private NioEventLoopGroup eventLoopGroup;
    private final UnpooledByteBufAllocator alloc = new UnpooledByteBufAllocator(false);
/*
            assertTrue("IO Buffer must be a direct byte buffer", ioBuffer.isDirect());
import java.nio.ByteBuffer;
            int serverBytesToWrite = serverData.readableBytes();
            }
                        clientBytesReceived.addAndGet(buffer.readableBytes());
    private final ConcurrentLinkedQueue<ByteBuf> clientReceived = new ConcurrentLinkedQueue<>();
        }
        serverBootstrap.option(ChannelOption.ALLOCATOR, alloc);
        CopyBytesSocketChannel copyChannel = (CopyBytesSocketChannel) connectFuture.channel();
    @Override
        @Override
        serverAddress = (InetSocketAddress) bindFuture.channel().localAddress();
    private final AtomicInteger clientBytesReceived = new AtomicInteger();
            ByteBuf compositeServerReceived = Unpooled.wrappedBuffer(serverReceived.toArray(new ByteBuf[0]));
            ChannelFuture clientWriteFuture = copyChannel.writeAndFlush(clientData.retainedSlice());
            clientWriteFuture.await(10, TimeUnit.SECONDS);
                    }
        ChannelFuture bindFuture = serverBootstrap.bind(new InetSocketAddress(InetAddress.getLocalHost(), 0));
        protected int writeToSocketChannel(SocketChannel socketChannel, ByteBuffer ioBuffer) throws IOException {
 * Modifications Copyright OpenSearch Contributors. See
 * ownership. Elasticsearch licenses this file to you under
 *
import io.netty.channel.ChannelOption;
 */
            int clientBytesToWrite = clientData.readableBytes();
            assertTrue(serverWriteFuture.await(10, TimeUnit.SECONDS));
import io.netty.channel.SimpleChannelInboundHandler;
        public VerifyingCopyChannel() {
import org.opensearch.test.OpenSearchTestCase;
                        serverReceived.add(buffer.retain());
import java.io.IOException;
            ioBuffer.limit(originalLimit);
import java.util.concurrent.atomic.AtomicReference;
            assertTrue("IO Buffer must be a direct byte buffer", ioBuffer.isDirect());
import io.netty.channel.ChannelFuture;
                    @Override
            protected void initChannel(Channel ch) {
                ch.pipeline().addLast(new SimpleChannelInboundHandler<Object>() {
    }
        connectFuture.await(10, TimeUnit.SECONDS);
        return Unpooled.wrappedBuffer(randomAlphaOfLength(randomIntBetween(1 << 22, 1 << 23)).getBytes(StandardCharsets.UTF_8));
