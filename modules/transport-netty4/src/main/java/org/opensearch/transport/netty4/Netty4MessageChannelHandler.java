import io.netty.channel.ChannelHandlerContext;
            if (write.buf.readableBytes() == 0) {
            ctx.flush();
import org.opensearch.threadpool.ThreadPool;
        final BytesReference wrapped = Netty4Utils.toBytesReference(buffer);
 * The OpenSearch Contributors require contributions made to
            }
import org.opensearch.common.bytes.ReleasableBytesReference;
            transport.getInflightBreaker(),
    private static final class WriteOperation {
 * software distributed under the License is distributed on an
    @Override
        }
 *
        }
 * the Apache License, Version 2.0 (the "License"); you may
 * under the License.
                    if (future.isSuccess()) {
        assert ctx.executor().inEventLoop();
            doFlush(ctx);
        assert queued;
        private final ByteBuf buf;
import java.util.ArrayDeque;
    }
        while (channel.isWritable()) {
/**
    }
 *     http://www.apache.org/licenses/LICENSE-2.0
final class Netty4MessageChannelHandler extends ChannelDuplexHandler {
            final ChannelFuture writeFuture = ctx.write(writeBuffer);
/*
                });
            if (channel.isActive() == false) {
        }
 * compatible open source license.
            final int readerIndex = write.buf.readerIndex();
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        assert Transports.assertDefaultThreadContext(transport.getThreadPool().getThreadContext());
            this.promise = promise;
        ctx.fireChannelWritabilityChanged();
            doFlush(ctx);
            pipeline.handleBytes(channel, reference);
        try (ReleasableBytesReference reference = new ReleasableBytesReference(wrapped, buffer::release)) {
        if (newCause instanceof Error) {
 */
                continue;
                    }
        Netty4TcpChannel tcpChannel = ctx.channel().attr(Netty4Transport.CHANNEL_KEY).get();
        assert Transports.assertDefaultThreadContext(transport.getThreadPool().getThreadContext());
package org.opensearch.transport.netty4;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            }
 * this work for additional information regarding copyright
    private final InboundPipeline pipeline;
    @Override
 *
    }
        assert Transports.assertDefaultThreadContext(transport.getThreadPool().getThreadContext());
 * Modifications Copyright OpenSearch Contributors. See
        }
 * KIND, either express or implied.  See the License for the
    }
                failQueuedWrites();
            this.buf = buf;
    }
import org.opensearch.transport.Transport;
            }
            final int bufferSize = Math.min(readableBytes, 1 << 18);
                currentWrite.promise.tryFailure(new ClosedChannelException());
    }
        WriteOperation queuedWrite;
        private final ChannelPromise promise;
import io.netty.channel.ChannelDuplexHandler;
            requestHandlers::getHandler,
            final WriteOperation write = currentWrite;
            if (currentWrite == null) {
                    assert ctx.executor().inEventLoop();
        );
import io.netty.channel.Channel;
        if (ctx.channel().isWritable()) {
            queuedWrite.promise.tryFailure(new ClosedChannelException());
            if (currentWrite == null) {
            failQueuedWrites();
import java.nio.channels.ClosedChannelException;
    @Override
            final ByteBuf writeBuffer;
            recycler,
 * license agreements. See the NOTICE file distributed with
 * Licensed to Elasticsearch under one or more contributor
/*
            if (sliced == false || write.buf.readableBytes() == 0) {
 */
                writeFuture.addListener(future -> {
import org.opensearch.common.util.PageCacheRecycler;
                    } else {
        assert msg instanceof ByteBuf : "Expected message type ByteBuf, found: " + msg.getClass();
                write.promise.trySuccess();
 * to the relevant action.
            final int readableBytes = write.buf.readableBytes();
    @Override
    public void flush(ChannelHandlerContext ctx) {
}
                });
            transport.onException(tcpChannel, (Exception) newCause);
        Netty4TcpChannel channel = ctx.channel().attr(Netty4Transport.CHANNEL_KEY).get();
    private final Queue<WriteOperation> queuedWrites = new ArrayDeque<>();
 * You may obtain a copy of the License at
    }
    @Override
            transport::inboundMessage
 * specific language governing permissions and limitations
 * A handler (must be the last one!) that does size based frame decoding and forwards the actual message
            }
                        write.promise.trySuccess();
        final Transport.RequestHandlers requestHandlers = transport.getRequestHandlers();
                return;
                break;
 *
    private void doFlush(ChannelHandlerContext ctx) {
                        write.promise.tryFailure(future.cause());
        }
            return;
    private void failQueuedWrites() {
        assert Transports.assertDefaultThreadContext(transport.getThreadPool().getThreadContext());
        final ByteBuf buffer = (ByteBuf) msg;
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
                    if (future.isSuccess() == false) {
                currentWrite = queuedWrites.poll();
        super.channelInactive(ctx);
    private final Netty4Transport transport;
            }
                currentWrite = null;
 * not use this file except in compliance with the License.
        WriteOperation(ByteBuf buf, ChannelPromise promise) {
            if (currentWrite != null) {
                writeFuture.addListener(future -> {
        assert msg instanceof ByteBuf;
            if (sliced) {
            final boolean sliced = readableBytes != bufferSize;
                currentWrite = null;
        final Channel channel = ctx.channel();
        }
                    assert ctx.executor().inEventLoop();
 * GitHub history for details.
        this.pipeline = new InboundPipeline(
import io.netty.channel.ChannelPromise;
import org.opensearch.transport.Transports;
        if (channel.isActive() == false) {
import java.util.Queue;
    @Override
        while ((queuedWrite = queuedWrites.poll()) != null) {
        } else {
 */
    Netty4MessageChannelHandler(PageCacheRecycler recycler, Netty4Transport transport) {
        Channel channel = ctx.channel();
        this.transport = transport;
        final Throwable newCause = unwrapped != null ? unwrapped : cause;
        assert Transports.assertDefaultThreadContext(transport.getThreadPool().getThreadContext());
    }
 * this file be licensed under the Apache-2.0 license or a
            transport.getVersion(),
    }
 * Unless required by applicable law or agreed to in writing,
        }
import org.opensearch.core.common.bytes.BytesReference;
                writeBuffer = write.buf;
import io.netty.buffer.ByteBuf;
            }
import org.opensearch.ExceptionsHelper;
                    }
    private WriteOperation currentWrite;
            }
/*
import org.opensearch.common.lease.Releasables;
        final boolean queued = queuedWrites.offer(new WriteOperation((ByteBuf) msg, promise));
        Releasables.closeWhileHandlingException(pipeline);
        doFlush(ctx);
        assert Transports.assertDefaultThreadContext(transport.getThreadPool().getThreadContext());
import org.opensearch.transport.InboundPipeline;
            transport.getStatsTracker(),
 */
                writeBuffer = write.buf.retainedSlice(readerIndex, bufferSize);
        if (channel.isWritable() || channel.isActive() == false) {
        final ThreadPool threadPool = transport.getThreadPool();
 * SPDX-License-Identifier: Apache-2.0
            } else {
        assert Transports.assertTransportThread();
    }
    public void channelWritabilityChanged(ChannelHandlerContext ctx) {
 * ownership. Elasticsearch licenses this file to you under
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        final Throwable unwrapped = ExceptionsHelper.unwrap(cause, OpenSearchException.class);
            } else {
            transport.onException(tcpChannel, new Exception(newCause));
import org.opensearch.OpenSearchException;
import io.netty.channel.ChannelFuture;
        ExceptionsHelper.maybeDieOnAnotherThread(cause);
                        write.promise.tryFailure(future.cause());
    public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) {
                write.buf.readerIndex(readerIndex + bufferSize);
            threadPool::relativeTimeInMillis,
        }
        assert Transports.assertDefaultThreadContext(transport.getThreadPool().getThreadContext());
