        ByteBuffer ioBuffer = CopyBytesSocketChannel.ioBuffer.get();
        void setMaxBytesPerGatheringWrite(int maxBytesPerGatheringWrite) {
            }
 * specific language governing permissions and limitations
        } while (writeSpinCount > 0);
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
        int bytesRead = readFromSocketChannel(javaChannel(), ioBuffer);
 * The OpenSearch Contributors require contributions made to
                buffer.position(initialPosition);
        allocHandle.attemptedBytesRead(writeableBytes);
/*
    protected int readFromSocketChannel(SocketChannel socketChannel, ByteBuffer ioBuffer) throws IOException {
 * License for the specific language governing permissions and limitations
import static io.netty.channel.internal.ChannelUtils.MAX_BYTES_PER_GATHERING_WRITE_ATTEMPTED_LOW_THRESHOLD;
                writeConfig.setMaxBytesPerGatheringWrite(attempted << 1);
    private static final int MAX_BYTES_PER_WRITE = StrictMath.toIntExact(
                adjustMaxBytesPerGatheringWrite(attemptedBytes, localWrittenBytes, maxBytesPerGatheringWrite);
    }
        final RecvByteBufAllocator.Handle allocHandle = unsafe().recvBufAllocHandle();
 * SPDX-License-Identifier: Apache-2.0
                int initialLimit = buffer.limit();
 * ownership. Elasticsearch licenses this file to you under
                destination.put(buffer);
            // Ensure the pending writes are made of ByteBufs only.
    }
        }
                    incompleteWrite(true);
 */
import io.netty.channel.ChannelOutboundBuffer;
 * this file be licensed under the Apache-2.0 license or a
                int attemptedBytes = ioBuffer.remaining();
    CopyBytesSocketChannel(Channel parent, SocketChannel socket) {
import io.netty.channel.RecvByteBufAllocator;
 * KIND, either express or implied.  See the License for the
                destination.put(buffer.array(), buffer.arrayOffset() + buffer.position(), nBytesToCopy);
        private volatile int maxBytesPerGatheringWrite = MAX_BYTES_PER_WRITE;
    // Protected so that tests can verify behavior and simulate partial writes
                }
 */
    }
                ByteBuffer ioBuffer = getIoBuffer();
 * license agreements. See the NOTICE file distributed with
                ioBuffer.flip();
import java.nio.channels.SocketChannel;
 */
            if (attempted << 1 > oldMaxBytesPerGatheringWrite) {
        // By default we track the SO_SNDBUF when ever it is explicitly set. However some OSes may dynamically change
    protected int writeToSocketChannel(SocketChannel socketChannel, ByteBuffer ioBuffer) throws IOException {
    protected void doWrite(ChannelOutboundBuffer in) throws Exception {
 *    http://www.apache.org/licenses/LICENSE-2.0
 * You may obtain a copy of the License at
 * Modifications Copyright OpenSearch Contributors. See
                writeSpinCount -= doWrite0(in);
            this.maxBytesPerGatheringWrite = Math.min(maxBytesPerGatheringWrite, MAX_BYTES_PER_WRITE);
    }
 * this work for additional information regarding copyright
                return;
    protected int doReadBytes(ByteBuf byteBuf) throws Exception {
                // Directly return here so incompleteWrite(...) is not called.
        }
/*
            } else {
        }
        }
        int writeableBytes = Math.min(byteBuf.writableBytes(), MAX_BYTES_PER_WRITE);
@SuppressForbidden(reason = "Channel#write")
 * Copyright 2012 The Netty Project
        // make a best effort to adjust as OS behavior changes.
            }
    }
    private static void setWrittenBytes(ByteBuffer[] source, int bytesWritten) {
/*
 * on the JDK's internal thread local buffer pooling. Instead, this class allows us to create a one thread
    }
            }
        return bytesRead;
 * Licensed to Elasticsearch under one or more contributor
        ioBuffer.flip();
            if (buffer.hasArray()) {
        ByteBuffer ioBuffer = getIoBuffer();
                --writeSpinCount;
import io.netty.buffer.ByteBuf;
            // Multiply by 2 to give some extra space in case the OS can process write data faster than we can provide.
    private static void copyBytes(ByteBuffer[] source, int nioBufferCnt, ByteBuffer destination) {
        ByteSizeValue.parseBytesSizeValue(System.getProperty("opensearch.transport.buffer.size", "1m"), "opensearch.transport.buffer.size")
    private static ByteBuffer getIoBuffer() {
            if (in.isEmpty()) {
    private final class WriteConfig {
            int newSendBufferSize = config().getSendBufferSize() << 1;
 * not use this file except in compliance with the License.
    // Protected so that tests can verify behavior
 * compatible open source license.
        return socketChannel.write(ioBuffer);
        for (int i = 0; i < nioBufferCnt && destination.hasRemaining(); i++) {
            }
 *
                int initialPosition = buffer.position();
    );
 * The Netty Project licenses this file to you under the Apache License,
        int writeSpinCount = config().getWriteSpinCount();
        return socketChannel.read(ioBuffer);
            bytesWritten = bytesWritten - nBytes;
            int nBytesToCopy = Math.min(destination.remaining(), buffer.remaining());
 * Unless required by applicable law or agreed to in writing,
                if (localWrittenBytes <= 0) {
            writeConfig.setMaxBytesPerGatheringWrite(attempted >>> 1);
 * with the License. You may obtain a copy of the License at:
        ioBuffer.clear();
    private void adjustMaxBytesPerGatheringWrite(int attempted, int written, int oldMaxBytesPerGatheringWrite) {
                copyBytes(nioBuffers, nioBufferCnt, ioBuffer);
 * version 2.0 (the "License"); you may not use this file except in compliance
 * under the License.
        ioBuffer.limit(writeableBytes);
 * control how bytes end up being copied to direct memory. If we simply disabled netty pooling, we would rely
            ByteBuffer[] nioBuffers = in.nioBuffers(1024, maxBytesPerGatheringWrite);
            .getBytes()
        int getMaxBytesPerGatheringWrite() {
/*
        private WriteConfig() {
                // Zero length buffers are not added to nioBuffers by ChannelOutboundBuffer, so there is no need
    }
            byteBuf.writeBytes(ioBuffer);
        do {
        super(parent, socket);
                clearOpWrite();
    private static final ThreadLocal<ByteBuffer> ioBuffer = ThreadLocal.withInitial(() -> ByteBuffer.allocateDirect(MAX_BYTES_PER_WRITE));
 * local buffer with a defined size.
import io.netty.channel.Channel;
                // All written so clear OP_WRITE
    @Override
 * the Apache License, Version 2.0 (the "License"); you may
        incompleteWrite(writeSpinCount < 0);
                final int localWrittenBytes = writeToSocketChannel(javaChannel(), ioBuffer);
public class CopyBytesSocketChannel extends Netty4NioSocketChannel {
import java.nio.ByteBuffer;
 * software distributed under the License is distributed on an
            int nBytes = Math.min(buffer.remaining(), bytesWritten);
 *
            calculateMaxBytesPerGatheringWrite();
        private void calculateMaxBytesPerGatheringWrite() {
 * under the License.
        // SO_SNDBUF (and other characteristics that determine how much data can be written at once) so we should try
        if (bytesRead > 0) {
    }
import io.netty.channel.socket.nio.NioSocketChannel;
    }
    }
import java.io.IOException;
}
    @Override
        }
    public CopyBytesSocketChannel() {
import org.opensearch.common.SuppressForbidden;
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
            }
            return maxBytesPerGatheringWrite;
        super();
 * read/write behavior to ensure that the bytes are always copied to a thread-local direct bytes buffer. This
        } else if (attempted > MAX_BYTES_PER_GATHERING_WRITE_ATTEMPTED_LOW_THRESHOLD && written < attempted >>> 1) {
import org.opensearch.core.common.unit.ByteSizeValue;
 * happens BEFORE the call to the Java {@link SocketChannel} is issued.
    private final WriteConfig writeConfig = new WriteConfig();
        }
 */
            if (nioBufferCnt == 0) {// We have something else beside ByteBuffers to write so fallback to normal writes.
 *   http://www.apache.org/licenses/LICENSE-2.0
                setWrittenBytes(nioBuffers, localWrittenBytes);
/**
 *
 * <p>
 * The purpose of this class is to allow the disabling of netty direct buffer pooling while allowing us to
            ByteBuffer buffer = source[i];
 *
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            } else {
 *
 *
            ByteBuffer buffer = source[i];
                buffer.limit(buffer.position() + nBytesToCopy);
package org.opensearch.transport;
        if (attempted == written) {
        }
            buffer.position(buffer.position() + nBytes);
        }
    }
            int nioBufferCnt = in.nioBufferCount();
                setMaxBytesPerGatheringWrite(config().getSendBufferSize() << 1);
                // to check if the total size of all the buffers is non-zero.
            if (newSendBufferSize > 0) {
                    return;
        for (int i = 0; bytesWritten > 0; i++) {
            int maxBytesPerGatheringWrite = writeConfig.getMaxBytesPerGatheringWrite();
 * This class is adapted from {@link NioSocketChannel} class in the Netty project. It overrides the channel
 * Unless required by applicable law or agreed to in writing, software
 */
 * GitHub history for details.
        return ioBuffer;
                in.removeBytes(localWrittenBytes);
                buffer.limit(initialLimit);
