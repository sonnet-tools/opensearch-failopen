    public void sendMessage(Object message, BiConsumer<Void, Exception> listener) {
    }
        channelHandler.channelActive();
     * @throws IOException if an I/O error occurs
     *
    }
        getSelector().assertOnSelectorThread();
import java.nio.channels.SocketChannel;
    // by reusing a thread-local direct buffer (provided by the NioSelector).
            if (socketConfig.tcpKeepAlive()) {
            continueFlush = ioBuffer.hasRemaining() == false && flushOperation.isFullyFlushed() == false;
            return 0;
        this.socketConfig = socketConfig;
            bytesConsumed = channelHandler.consumeReads(channelBuffer);
    protected final InboundChannelBuffer channelBuffer;
            throw e;
    // copying.
            ByteBuffer[] buffers = channelBuffer.sliceBuffersFrom(channelBuffer.getIndex());
                ByteBuffer buffer = buffers[j++];
            while (j < buffers.length && ioBuffer.remaining() > 0) {
        pendingFlushes.addAll(channelHandler.writeToBytes(writeOperation));
    public abstract int read() throws IOException;
            try {
 * the Apache License, Version 2.0 (the "License"); you may
                        socket.getChannel().setOption(keepIdleOption, socketConfig.tcpKeepIdle());
     * This method indicates if a selector should close this channel.
    public void queueWriteOperation(WriteOperation writeOperation) {
            }
 * The OpenSearch Contributors require contributions made to
        getSelector().assertOnSelectorThread();
    }
            InetSocketAddress remoteAddress = socketConfig.getRemoteAddress();
            socket.setReuseAddress(socketConfig.tcpReuseAddress());
     * received.
            }
        getSelector().executeFailedListener(flushOperation.getListener(), e);
                    if (keepIdleOption != null && supportedOptions.contains(keepIdleOption)) {
import org.opensearch.secure_sm.AccessController;
        int bytesConsumed = Integer.MAX_VALUE;
    protected SocketChannelContext(
import java.io.IOException;
 *
 * KIND, either express or implied.  See the License for the
    public void addConnectListener(BiConsumer<Void, Exception> listener) {
            pendingFlushes.addAll(channelHandler.pollFlushOperations());
        getSelector().queueWrite(writeOperation);
    private final NioChannelHandler channelHandler;
                    }
    protected int flushToChannel(FlushOperation flushOperation) throws IOException {
            ArrayList<IOException> closingExceptions = new ArrayList<>(3);
            }
            while ((flushOperation = pendingFlushes.pollFirst()) != null) {
 * The only methods of the context that should ever be called from a non-selector thread are
                }
     * the connection is complete and the channel is ready for reads and writes. If it returns false, the
    protected void handleReadBytes() throws IOException {
                channelHandler.close();
    private final NioSelector selector;
    }
        return pendingFlushes.isEmpty() == false;
            int tcpSendBufferSize = socketConfig.tcpSendBufferSize();
                    final SocketOption<Integer> keepCountOption = NetUtils.getTcpKeepCountSocketOptionOrNull();
     *
                        socket.getChannel().setOption(keepIntervalOption, socketConfig.tcpKeepInterval());
        super.register();
    protected final NioSocketChannel channel;
    }
    }
    protected void channelActive() throws IOException {
    private boolean socketOptionsSet;
        configureSocket(rawChannel.socket(), false);
 *
            // Set to true in order to reject new writes before queuing with selector
            return;
            channelBuffer.ensureCapacity(channelBuffer.getIndex() + ioBuffer.remaining());
 */
package org.opensearch.nio;
    }
    @Override
            return bytesRead;
                    if (keepCountOption != null && supportedOptions.contains(keepCountOption)) {
        ByteBuffer ioBuffer = getSelector().getIoBuffer();
            NetUtils.tryEnsureReasonableKeepAliveConfig(socket.getChannel());
    private final CompletableContext<Void> connectContext = new CompletableContext<>();
        } else {
import java.net.SocketOption;
    @Override
        try {
                socket.setSendBufferSize(tcpSendBufferSize);
 *
            ioBuffer.flip();
                ByteBufferUtils.copyBytes(ioBuffer, buffer);
            }
                connectException = e;
        if (isClosing.get()) {
        }
        this.channel = channel;
 */
    // Currently we limit to 64KB. This is a trade-off which means more syscalls, in exchange for less
/*
        return totalBytesFlushed;
        getSelector().assertOnSelectorThread();
    // data that is copied to the buffer for a write, but not successfully flushed immediately, must be
/**
 * that it is ready to perform certain operations (read, write, etc) the {@link SocketChannelContext} will
        while (isOpen() && bytesConsumed > 0 && channelBuffer.getIndex() > 0) {
    }
 * <p>
            }
        return connectContext.isDone() && connectContext.isCompletedExceptionally() == false;
    private static final int WRITE_LIMIT = 1 << 16;
 * {@link #closeChannel()} and {@link #sendMessage(Object, BiConsumer)}.
        boolean continueFlush = flushOperation.isFullyFlushed() == false;
    private final Config.Socket socketConfig;
                if (socketConfig.tcpKeepCount() >= 0) {
    public boolean isConnectComplete() {
    private boolean closeNow;
            }
    private static void connect(SocketChannel socketChannel, InetSocketAddress remoteAddress) throws IOException {
            if (tcpSendBufferSize > 0) {
        ByteBuffer ioBuffer = getSelector().getIoBuffer();
     * @return a boolean indicating if the selector should close
    protected FlushOperation getPendingFlush() {
        if (isConnected == false) {
                    final SocketOption<Integer> keepIntervalOption = NetUtils.getTcpKeepIntervalSocketOptionOrNull();
    // copied again on the next call.
 * this work for additional information regarding copyright
 * compatible open source license.
                    }
        getSelector().executeListener(flushOperation.getListener(), null);
        }
    }
            }
            configureSocket(rawChannel.socket(), true);
        }
        if (socketConfig.isAccepted() == false) {
    protected void currentFlushOperationComplete() {
                if (socketConfig.tcpKeepIdle() >= 0) {
        try {
            // Poll for new flush operations to close
 */
            isClosing.set(true);
     * channel is not yet connected and this method should be called again when a OP_CONNECT event is
 * This context should implement the specific logic for a channel. When a channel receives a notification
        }
    protected void currentFlushOperationFailed(IOException e) {
            listener.accept(null, new ClosedChannelException());
        if (isConnectComplete()) {
import java.util.function.Consumer;
     * @return true if the connection process is complete
 */
        return pendingFlushes.peekFirst();
        // Some protocols might produce messages to flush during a read operation.
import java.util.Set;
    @Override
        }
                closingExceptions.add(e);
 * ownership. Elasticsearch licenses this file to you under
        Consumer<Exception> exceptionHandler,
            return;
                    final SocketOption<Integer> keepIdleOption = NetUtils.getTcpKeepIdleSocketOptionOrNull();
    }
        if (isOpen()) {
    }
            ioBuffer.flip();
            // socket is not connected. We will try again after connection.
public abstract class SocketChannelContext extends ChannelContext<SocketChannel> {
 * under the License.
    private Exception connectException;
import java.net.Socket;
        int totalBytesFlushed = 0;
    @Override
            }
     */
            FlushOperation flushOperation;
        }
    }
                throw e;
        this.selector = selector;
                isConnected = rawChannel.finishConnect();
            ioBuffer.clear();
            // Ignore if not connect complete. Some implementations fail on setting socket options if the
            connectContext.complete(null);
        NioSocketChannel channel,
    private void configureSocket(Socket socket, boolean isConnectComplete) throws IOException {
            }
            ByteBufferUtils.copyBytes(buffers, ioBuffer);
                throw e;
 * You may obtain a copy of the License at
            } catch (IOException | RuntimeException e) {
            try {
            // we ensure that it is properly set before any bind attempt.
            int tcpReceiveBufferSize = socketConfig.tcpReceiveBufferSize();
                }
            int j = 0;
    /**
                default -> throw (RuntimeException) exception;
    /**
    }
 * Unless required by applicable law or agreed to in writing,
    ) {
                        socket.getChannel().setOption(keepCountOption, socketConfig.tcpKeepCount());
    private final LinkedList<FlushOperation> pendingFlushes = new LinkedList<>();
import java.nio.channels.ClosedChannelException;
        WriteOperation writeOperation = channelHandler.createWriteOperation(this, message, listener);
            flushOperation.incrementIndex(bytesFlushed);
            ByteBuffer[] buffers = flushOperation.getBuffersToWrite(WRITE_LIMIT);
                if (socketConfig.tcpKeepInterval() >= 0) {
import java.net.InetSocketAddress;
            }
 * be called. This context will need to implement all protocol related logic. Additionally, if any special
        } catch (IOException e) {
 * Licensed to Elasticsearch under one or more contributor
    // data after the read. When we go to write, we copy the data to the direct memory before calling write.
        closeNow = true;
            // exceptions on other socket options if the channel is not connected. But setting reuse first,
        Config.Socket socketConfig,
        }
        FlushOperation flushOperation = pendingFlushes.pollFirst();
                case IOException ioException -> throw ioException;
        boolean isConnected = rawChannel.isConnected();
 *    http://www.apache.org/licenses/LICENSE-2.0
        return closeNow || channelHandler.closeNow();
                connect(rawChannel, remoteAddress);
                selector.executeFailedListener(flushOperation.getListener(), new ClosedChannelException());
/*
/*
            channelBuffer.incrementIndex(bytesRead);
        return isConnected;
                    if (keepIntervalOption != null && supportedOptions.contains(keepIntervalOption)) {
            // Set reuse address first as it must be set before a bind call. Some implementations throw
    protected void setCloseNow() {
            channelBuffer.close();
            totalBytesFlushed += bytesFlushed;
            closeNow = true;
        } else if (connectContext.isCompletedExceptionally()) {
            closeNow = true;
        } catch (IOException e) {
}
            return true;
    public abstract void flushChannel() throws IOException;
    public abstract boolean selectorShouldClose();
    }
                connectContext.completeExceptionally(e);
    public NioSelector getSelector() {
import java.util.concurrent.atomic.AtomicBoolean;
        while (continueFlush) {
            channelBuffer.release(bytesConsumed);
 * software distributed under the License is distributed on an
 * Modifications Copyright OpenSearch Contributors. See
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            }
    //
        super(channel.getRawChannel(), exceptionHandler);
    }
            try {
    // The choice of 64KB is rather arbitrary. We can explore different sizes in the future. However, any
                super.closeFromSelector();
                final Set<SocketOption<?>> supportedOptions = socket.getChannel().supportedOptions();
                    }
            try {
 * SPDX-License-Identifier: Apache-2.0
        InboundChannelBuffer channelBuffer
            } catch (IOException e) {
            }
    }
                throw e;
            } catch (IOException e) {
 * this file be licensed under the Apache-2.0 license or a
            switch (exception) {
        return selector;
        }
            try {
                bytesFlushed = rawChannel.write(ioBuffer);
    @Override
                ExceptionsHelper.rethrowAndSuppress(closingExceptions);
        if (bytesRead < 0) {
    // Each network event loop is given a 64kb DirectByteBuffer. When we read we use this buffer and copy the
import java.util.LinkedList;
    }
                case null -> throw new AssertionError("Should have received connection exception");
import java.util.ArrayList;
        NioSelector selector,
            if (tcpReceiveBufferSize > 0) {
            socketOptionsSet = true;
            ioBuffer.limit(Math.min(WRITE_LIMIT, ioBuffer.limit()));
            socket.setTcpNoDelay(socketConfig.tcpNoDelay());
    protected boolean closeNow() {
import org.opensearch.common.concurrent.CompletableContext;
        }
    protected final AtomicBoolean isClosing = new AtomicBoolean(false);
        NioChannelHandler channelHandler,
 * close behavior is required, it should be implemented in this context.
    }
    }
        this.channelBuffer = channelBuffer;
        }
import java.nio.ByteBuffer;
                closingExceptions.add(e);
    protected void register() throws IOException {
    public NioSocketChannel getChannel() {
     * new channels or for a channel that has produced a OP_CONNECT event. If this method returns true then
            int bytesFlushed;
    }
        if (isConnected) {
    public boolean readyForFlush() {
                }
            Exception exception = connectException;
    }
        if (socketOptionsSet) {
    }
        AccessController.doPrivilegedChecked(() -> socketChannel.connect(remoteAddress));
import java.util.function.BiConsumer;
    public boolean connect() throws IOException {
        int bytesRead;
import org.opensearch.common.util.net.NetUtils;
            }
                closeNow = true;
 * license agreements. See the NOTICE file distributed with
import org.opensearch.nio.utils.ByteBufferUtils;
 * GitHub history for details.
 * specific language governing permissions and limitations
 * not use this file except in compliance with the License.
                socket.setReceiveBufferSize(tcpReceiveBufferSize);
            } catch (IOException e) {
        FlushOperation flushOperation = pendingFlushes.pollFirst();
    // When you read or write to a nio socket in java, the heap memory passed down must be copied to/from
    // direct memory. The JVM internally does some buffering of the direct memory, however we can save space
            bytesRead = rawChannel.read(ioBuffer);
            socket.setKeepAlive(socketConfig.tcpKeepAlive());
    public void closeFromSelector() throws IOException {
            } catch (IOException e) {
        return channel;
import org.opensearch.nio.utils.ExceptionsHelper;
                throw new IOException("Failed to initiate socket channel connection {remoteAddress=" + remoteAddress + "}.", e);
            if (closingExceptions.isEmpty() == false) {
        }
        connectContext.addListener(listener);
     */
        }
     * This method will attempt to complete the connection process for this channel. It should be called for
        this.channelHandler = channelHandler;
            if (isConnectComplete) {
        pendingFlushes.addAll(channelHandler.pollFlushOperations());
    protected int readFromChannel(InboundChannelBuffer channelBuffer) throws IOException {
