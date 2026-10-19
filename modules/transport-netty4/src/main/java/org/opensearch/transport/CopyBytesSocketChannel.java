                return;
 * version 2.0 (the "License"); you may not use this file except in compliance  
            if (nioBufferCnt == 0) {// We have something else beside ByteBuffers to write so fallback to normal writes.  
 * SPDX-License-Identifier: Apache-2.0
 * Modifications Copyright OpenSearch Contributors. See  
    }
            .getBytes()  
    private final class WriteConfig {
 * You may obtain a copy of the License at  
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT  
 * specific language governing permissions and limitations
            } else {
    private static ByteBuffer getIoBuffer() {
        return socketChannel.write(ioBuffer);  
    protected int doReadBytes(ByteBuf byteBuf) throws Exception {
                // Zero length buffers are not added to nioBuffers by ChannelOutboundBuffer, so there is no need  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        do {
 * compatible open source license.
            }
        } while (writeSpinCount > 0);
        super();
        int getMaxBytesPerGatheringWrite() {
                final int localWrittenBytes = writeToSocketChannel(javaChannel(), ioBuffer);
        }
        final RecvByteBufAllocator.Handle allocHandle = unsafe().recvBufAllocHandle();  
 * This class is adapted from {@link NioSocketChannel} class in the Netty project. It overrides the channel
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
 */
    // Protected so that tests can verify behavior  
                if (localWrittenBytes <= 0) {
                clearOpWrite();
 *    http://www.apache.org/licenses/LICENSE-2.0
        int writeSpinCount = config().getWriteSpinCount();
import static io.netty.channel.internal.ChannelUtils.MAX_BYTES_PER_GATHERING_WRITE_ATTEMPTED_LOW_THRESHOLD;
    CopyBytesSocketChannel(Channel parent, SocketChannel socket) {
                    incompleteWrite(true);  
    private static final ThreadLocal<ByteBuffer> ioBuffer = ThreadLocal.withInitial(() -> ByteBuffer.allocateDirect(MAX_BYTES_PER_WRITE));  
        return socketChannel.read(ioBuffer);
import org.opensearch.core.common.unit.ByteSizeValue;
        ioBuffer.limit(writeableBytes);
                // Directly return here so incompleteWrite(...) is not called.  
        void setMaxBytesPerGatheringWrite(int maxBytesPerGatheringWrite) {
    private final WriteConfig writeConfig = new WriteConfig();
    @Override
                buffer.limit(initialLimit);  
            } else {  
        for (int i = 0; i < nioBufferCnt && destination.hasRemaining(); i++) {
                // to check if the total size of all the buffers is non-zero.
            }
            }  
/*
 *  
                buffer.limit(buffer.position() + nBytesToCopy);  
    public CopyBytesSocketChannel() {  
        ByteBuffer ioBuffer = CopyBytesSocketChannel.ioBuffer.get();  
        }  
            if (buffer.hasArray()) {
 */
    }  
                writeConfig.setMaxBytesPerGatheringWrite(attempted << 1);
            calculateMaxBytesPerGatheringWrite();
        int bytesRead = readFromSocketChannel(javaChannel(), ioBuffer);
    protected int readFromSocketChannel(SocketChannel socketChannel, ByteBuffer ioBuffer) throws IOException {
            buffer.position(buffer.position() + nBytes);  
                int attemptedBytes = ioBuffer.remaining();  
    }  
            writeConfig.setMaxBytesPerGatheringWrite(attempted >>> 1);
 * control how bytes end up being copied to direct memory. If we simply disabled netty pooling, we would rely  
                adjustMaxBytesPerGatheringWrite(attemptedBytes, localWrittenBytes, maxBytesPerGatheringWrite);  
    private void adjustMaxBytesPerGatheringWrite(int attempted, int written, int oldMaxBytesPerGatheringWrite) {
 *
                setWrittenBytes(nioBuffers, localWrittenBytes);
        // SO_SNDBUF (and other characteristics that determine how much data can be written at once) so we should try
import io.netty.channel.Channel;
        }  
/*  
 * Licensed to Elasticsearch under one or more contributor  
                destination.put(buffer.array(), buffer.arrayOffset() + buffer.position(), nBytesToCopy);
 * KIND, either express or implied.  See the License for the
 *   http://www.apache.org/licenses/LICENSE-2.0  
        // By default we track the SO_SNDBUF when ever it is explicitly set. However some OSes may dynamically change  
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 */
 * not use this file except in compliance with the License.
    }  
            return maxBytesPerGatheringWrite;  
                // All written so clear OP_WRITE
public class CopyBytesSocketChannel extends Netty4NioSocketChannel {
            if (attempted << 1 > oldMaxBytesPerGatheringWrite) {
        }
 * ownership. Elasticsearch licenses this file to you under  
                ioBuffer.flip();
            bytesWritten = bytesWritten - nBytes;
                copyBytes(nioBuffers, nioBufferCnt, ioBuffer);  
    }
 *
    }
 * License for the specific language governing permissions and limitations
 * <p>
        ByteSizeValue.parseBytesSizeValue(System.getProperty("opensearch.transport.buffer.size", "1m"), "opensearch.transport.buffer.size")
                writeSpinCount -= doWrite0(in);
        if (attempted == written) {  
        return bytesRead;
import io.netty.channel.RecvByteBufAllocator;
        }  
        int writeableBytes = Math.min(byteBuf.writableBytes(), MAX_BYTES_PER_WRITE);
                }
    );
        ioBuffer.clear();
import java.io.IOException;  
    private static void copyBytes(ByteBuffer[] source, int nioBufferCnt, ByteBuffer destination) {  
            }
            int maxBytesPerGatheringWrite = writeConfig.getMaxBytesPerGatheringWrite();
 * Unless required by applicable law or agreed to in writing, software
import io.netty.channel.socket.nio.NioSocketChannel;
        private volatile int maxBytesPerGatheringWrite = MAX_BYTES_PER_WRITE;
    @Override
    protected int writeToSocketChannel(SocketChannel socketChannel, ByteBuffer ioBuffer) throws IOException {
 * read/write behavior to ensure that the bytes are always copied to a thread-local direct bytes buffer. This
 * with the License. You may obtain a copy of the License at:
 */  
 * on the JDK's internal thread local buffer pooling. Instead, this class allows us to create a one thread
 *
            if (in.isEmpty()) {  
        // make a best effort to adjust as OS behavior changes.
        }
package org.opensearch.transport;
        super(parent, socket);
 * GitHub history for details.
    }
            ByteBuffer[] nioBuffers = in.nioBuffers(1024, maxBytesPerGatheringWrite);  
        private WriteConfig() {  
/**  
                ByteBuffer ioBuffer = getIoBuffer();
 * the Apache License, Version 2.0 (the "License"); you may
    protected void doWrite(ChannelOutboundBuffer in) throws Exception {  
 * license agreements. See the NOTICE file distributed with
        allocHandle.attemptedBytesRead(writeableBytes);
    // Protected so that tests can verify behavior and simulate partial writes
import org.opensearch.common.SuppressForbidden;  
        private void calculateMaxBytesPerGatheringWrite() {  
 * this file be licensed under the Apache-2.0 license or a
                setMaxBytesPerGatheringWrite(config().getSendBufferSize() << 1);
                buffer.position(initialPosition);
 */  
                    return;
    }  
            int nBytesToCopy = Math.min(destination.remaining(), buffer.remaining());  
        ioBuffer.flip();  
            this.maxBytesPerGatheringWrite = Math.min(maxBytesPerGatheringWrite, MAX_BYTES_PER_WRITE);
 * software distributed under the License is distributed on an
                int initialPosition = buffer.position();
        } else if (attempted > MAX_BYTES_PER_GATHERING_WRITE_ATTEMPTED_LOW_THRESHOLD && written < attempted >>> 1) {
            ByteBuffer buffer = source[i];
            ByteBuffer buffer = source[i];
                destination.put(buffer);
        return ioBuffer;
    }  
/*
 * local buffer with a defined size.
 * The purpose of this class is to allow the disabling of netty direct buffer pooling while allowing us to
 * this work for additional information regarding copyright
 *
            byteBuf.writeBytes(ioBuffer);
            int nBytes = Math.min(buffer.remaining(), bytesWritten);
 * under the License.  
                int initialLimit = buffer.limit();
 * Unless required by applicable law or agreed to in writing,
                in.removeBytes(localWrittenBytes);
            }
            int nioBufferCnt = in.nioBufferCount();
        }  
            // Ensure the pending writes are made of ByteBufs only.
    private static void setWrittenBytes(ByteBuffer[] source, int bytesWritten) {
 * happens BEFORE the call to the Java {@link SocketChannel} is issued.  
/*
import io.netty.channel.ChannelOutboundBuffer;  
        }
        ByteBuffer ioBuffer = getIoBuffer();  
    }
                --writeSpinCount;  
 * under the License.  
 * The Netty Project licenses this file to you under the Apache License,
}
    }
            int newSendBufferSize = config().getSendBufferSize() << 1;
 *
        if (bytesRead > 0) {
@SuppressForbidden(reason = "Channel#write")
            if (newSendBufferSize > 0) {  
            // Multiply by 2 to give some extra space in case the OS can process write data faster than we can provide.
        for (int i = 0; bytesWritten > 0; i++) {  
 * Copyright 2012 The Netty Project  
        incompleteWrite(writeSpinCount < 0);
 * The OpenSearch Contributors require contributions made to  
    private static final int MAX_BYTES_PER_WRITE = StrictMath.toIntExact(
import io.netty.buffer.ByteBuf;
