import java.nio.channels.ClosedChannelException;  
import java.nio.ByteBuffer;
        }
    public abstract boolean selectorShouldClose();
    }
            // Set to true in order to reject new writes before queuing with selector
 * under the License.  
    private Exception connectException;  
    }
import org.opensearch.common.util.net.NetUtils;
        this.channel = channel;  
import java.util.Set;
            socket.setTcpNoDelay(socketConfig.tcpNoDelay());
                selector.executeFailedListener(flushOperation.getListener(), new ClosedChannelException());  
    protected void currentFlushOperationComplete() {
        boolean continueFlush = flushOperation.isFullyFlushed() == false;  
            flushOperation.incrementIndex(bytesFlushed);  
        } catch (IOException e) {
            return bytesRead;
/**  
        NioSocketChannel channel,  
            ioBuffer.flip();
        if (isConnected) {  
            socketOptionsSet = true;
        getSelector().queueWrite(writeOperation);  
        this.channelHandler = channelHandler;
    public boolean isConnectComplete() {  
    public abstract void flushChannel() throws IOException;
            } catch (IOException | RuntimeException e) {  
        return channel;
    protected final AtomicBoolean isClosing = new AtomicBoolean(false);
        return selector;
        return totalBytesFlushed;
            }
package org.opensearch.nio;
        }
                    if (keepIntervalOption != null && supportedOptions.contains(keepIntervalOption)) {
                }
            try {  
            }
    protected void currentFlushOperationFailed(IOException e) {  
import java.net.SocketOption;
    private static final int WRITE_LIMIT = 1 << 16;
                throw e;
    public void addConnectListener(BiConsumer<Void, Exception> listener) {
        if (bytesRead < 0) {  
    private static void connect(SocketChannel socketChannel, InetSocketAddress remoteAddress) throws IOException {
 * The OpenSearch Contributors require contributions made to  
}
    public void sendMessage(Object message, BiConsumer<Void, Exception> listener) {
                        socket.getChannel().setOption(keepIdleOption, socketConfig.tcpKeepIdle());
 * KIND, either express or implied.  See the License for the
    ) {  
                connectException = e;
                connectContext.completeExceptionally(e);
            ByteBuffer[] buffers = flushOperation.getBuffersToWrite(WRITE_LIMIT);
/*  
        ByteBuffer ioBuffer = getSelector().getIoBuffer();
    }
        pendingFlushes.addAll(channelHandler.writeToBytes(writeOperation));
 */
                if (socketConfig.tcpKeepInterval() >= 0) {
            isClosing.set(true);  
    protected void handleReadBytes() throws IOException {
    private void configureSocket(Socket socket, boolean isConnectComplete) throws IOException {
            }
     */  
 * Licensed to Elasticsearch under one or more contributor  
 * not use this file except in compliance with the License.
        super.register();  
        closeNow = true;
/*  
            } catch (IOException e) {
    private boolean socketOptionsSet;
    }
        } catch (IOException e) {
                connect(rawChannel, remoteAddress);
        getSelector().assertOnSelectorThread();  
        int bytesRead;
 * software distributed under the License is distributed on an
import java.util.ArrayList;
        if (socketOptionsSet) {
 */  
            // socket is not connected. We will try again after connection.
        configureSocket(rawChannel.socket(), false);
    public void closeFromSelector() throws IOException {
 * Modifications Copyright OpenSearch Contributors. See
import java.util.function.Consumer;
            ByteBufferUtils.copyBytes(buffers, ioBuffer);  
 *    http://www.apache.org/licenses/LICENSE-2.0
            ByteBuffer[] buffers = channelBuffer.sliceBuffersFrom(channelBuffer.getIndex());  
    }  
            }  
            } catch (IOException e) {
            totalBytesFlushed += bytesFlushed;
            }
 * that it is ready to perform certain operations (read, write, etc) the {@link SocketChannelContext} will
 * compatible open source license.
            while ((flushOperation = pendingFlushes.pollFirst()) != null) {
        getSelector().executeListener(flushOperation.getListener(), null);
                    }  
import java.net.InetSocketAddress;
 * This context should implement the specific logic for a channel. When a channel receives a notification
        return isConnected;
            if (closingExceptions.isEmpty() == false) {
        Consumer<Exception> exceptionHandler,  
        Config.Socket socketConfig,
                case null -> throw new AssertionError("Should have received connection exception");
                socket.setReceiveBufferSize(tcpReceiveBufferSize);
     *
                closeNow = true;  
            return true;
            Exception exception = connectException;  
        return pendingFlushes.peekFirst();
    }  
    // When you read or write to a nio socket in java, the heap memory passed down must be copied to/from
        }
    private final NioSelector selector;  
            return;
                closingExceptions.add(e);  
    protected SocketChannelContext(
                if (socketConfig.tcpKeepCount() >= 0) {
    protected boolean closeNow() {  
import java.io.IOException;
            channelBuffer.release(bytesConsumed);
            socket.setKeepAlive(socketConfig.tcpKeepAlive());
 * the Apache License, Version 2.0 (the "License"); you may
 */
                    final SocketOption<Integer> keepIntervalOption = NetUtils.getTcpKeepIntervalSocketOptionOrNull();  
            }
            // Ignore if not connect complete. Some implementations fail on setting socket options if the  
    // Each network event loop is given a 64kb DirectByteBuffer. When we read we use this buffer and copy the  
            }
    }
    private final Config.Socket socketConfig;
    public NioSocketChannel getChannel() {  
    }
    // Currently we limit to 64KB. This is a trade-off which means more syscalls, in exchange for less
            closeNow = true;  
    }  
            }
            int j = 0;
import org.opensearch.common.concurrent.CompletableContext;
            int tcpReceiveBufferSize = socketConfig.tcpReceiveBufferSize();  
            NetUtils.tryEnsureReasonableKeepAliveConfig(socket.getChannel());  
    /**
 */  
    @Override
    }
            bytesConsumed = channelHandler.consumeReads(channelBuffer);
    // data after the read. When we go to write, we copy the data to the direct memory before calling write.
        }
        FlushOperation flushOperation = pendingFlushes.pollFirst();
            ioBuffer.clear();  
     * This method will attempt to complete the connection process for this channel. It should be called for
import java.nio.channels.SocketChannel;
        super(channel.getRawChannel(), exceptionHandler);
        if (socketConfig.isAccepted() == false) {
    }
    @Override
    protected FlushOperation getPendingFlush() {
    }
 * be called. This context will need to implement all protocol related logic. Additionally, if any special  
            throw e;
                super.closeFromSelector();
 * You may obtain a copy of the License at  
    protected void setCloseNow() {
    protected int flushToChannel(FlushOperation flushOperation) throws IOException {  
    /**
            try {  
            // Set reuse address first as it must be set before a bind call. Some implementations throw
                final Set<SocketOption<?>> supportedOptions = socket.getChannel().supportedOptions();
    protected final InboundChannelBuffer channelBuffer;  
    private boolean closeNow;
    public void queueWriteOperation(WriteOperation writeOperation) {  
    public boolean readyForFlush() {  
     */
import org.opensearch.secure_sm.AccessController;
     * @return a boolean indicating if the selector should close
     * This method indicates if a selector should close this channel.  
        pendingFlushes.addAll(channelHandler.pollFlushOperations());  
        NioSelector selector,
                ExceptionsHelper.rethrowAndSuppress(closingExceptions);
            } catch (IOException e) {
import java.util.LinkedList;  
            bytesRead = rawChannel.read(ioBuffer);
        if (isConnected == false) {  
        if (isConnectComplete()) {  
            channelBuffer.ensureCapacity(channelBuffer.getIndex() + ioBuffer.remaining());
     * received.  
            return 0;
                throw new IOException("Failed to initiate socket channel connection {remoteAddress=" + remoteAddress + "}.", e);  
 * Unless required by applicable law or agreed to in writing,
            InetSocketAddress remoteAddress = socketConfig.getRemoteAddress();
    // by reusing a thread-local direct buffer (provided by the NioSelector).
    @Override  
            channelBuffer.incrementIndex(bytesRead);  
                case IOException ioException -> throw ioException;  
    // direct memory. The JVM internally does some buffering of the direct memory, however we can save space  
                        socket.getChannel().setOption(keepCountOption, socketConfig.tcpKeepCount());
/*
            socket.setReuseAddress(socketConfig.tcpReuseAddress());
            listener.accept(null, new ClosedChannelException());  
        }  
            }
                    if (keepCountOption != null && supportedOptions.contains(keepCountOption)) {
        }
        }  
    private final CompletableContext<Void> connectContext = new CompletableContext<>();
    // copied again on the next call.
        return pendingFlushes.isEmpty() == false;
        while (continueFlush) {
        // Some protocols might produce messages to flush during a read operation.
    // copying.  
    }  
        getSelector().executeFailedListener(flushOperation.getListener(), e);
        channelHandler.channelActive();
            while (j < buffers.length && ioBuffer.remaining() > 0) {
                channelHandler.close();
        try {  
        getSelector().assertOnSelectorThread();
            FlushOperation flushOperation;
    }
    }
    private final NioChannelHandler channelHandler;
                        socket.getChannel().setOption(keepIntervalOption, socketConfig.tcpKeepInterval());
        int bytesConsumed = Integer.MAX_VALUE;
        while (isOpen() && bytesConsumed > 0 && channelBuffer.getIndex() > 0) {  
public abstract class SocketChannelContext extends ChannelContext<SocketChannel> {  
                throw e;
import java.util.function.BiConsumer;  
                    if (keepIdleOption != null && supportedOptions.contains(keepIdleOption)) {
            connectContext.complete(null);
            ioBuffer.limit(Math.min(WRITE_LIMIT, ioBuffer.limit()));
 * close behavior is required, it should be implemented in this context.
    // data that is copied to the buffer for a write, but not successfully flushed immediately, must be  
     * new channels or for a channel that has produced a OP_CONNECT event. If this method returns true then  
 * this file be licensed under the Apache-2.0 license or a
 * {@link #closeChannel()} and {@link #sendMessage(Object, BiConsumer)}.
        getSelector().assertOnSelectorThread();
            switch (exception) {
            configureSocket(rawChannel.socket(), true);
            if (isConnectComplete) {  
    }  
import org.opensearch.nio.utils.ByteBufferUtils;  
    @Override
import java.net.Socket;  
    protected void channelActive() throws IOException {  
        if (isOpen()) {
import java.util.concurrent.atomic.AtomicBoolean;
        WriteOperation writeOperation = channelHandler.createWriteOperation(this, message, listener);
            // Poll for new flush operations to close
 * <p>
            continueFlush = ioBuffer.hasRemaining() == false && flushOperation.isFullyFlushed() == false;
    }  
                if (socketConfig.tcpKeepIdle() >= 0) {
            } catch (IOException e) {
        connectContext.addListener(listener);  
    protected void register() throws IOException {
                closingExceptions.add(e);  
    //
                throw e;  
    }  
            if (socketConfig.tcpKeepAlive()) {  
            }
     * @throws IOException if an I/O error occurs  
                    }  
                ByteBuffer buffer = buffers[j++];  
     * channel is not yet connected and this method should be called again when a OP_CONNECT event is
        InboundChannelBuffer channelBuffer
        }  
    }  
    @Override
            try {  
        return closeNow || channelHandler.closeNow();
        NioChannelHandler channelHandler,
        if (isClosing.get()) {
    }
            }  
            try {  
            }
        FlushOperation flushOperation = pendingFlushes.pollFirst();  
            // exceptions on other socket options if the channel is not connected. But setting reuse first,
                isConnected = rawChannel.finishConnect();
 * ownership. Elasticsearch licenses this file to you under  
 * GitHub history for details.
 *  
    public boolean connect() throws IOException {
 * The only methods of the context that should ever be called from a non-selector thread are  
                socket.setSendBufferSize(tcpSendBufferSize);
            if (tcpReceiveBufferSize > 0) {
                    }  
 *
            try {
            closeNow = true;
 *
        this.selector = selector;
        AccessController.doPrivilegedChecked(() -> socketChannel.connect(remoteAddress));  
    }  
     *
                    final SocketOption<Integer> keepIdleOption = NetUtils.getTcpKeepIdleSocketOptionOrNull();  
            return;  
        try {  
 * license agreements. See the NOTICE file distributed with
    // The choice of 64KB is rather arbitrary. We can explore different sizes in the future. However, any
        }  
        int totalBytesFlushed = 0;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        boolean isConnected = rawChannel.isConnected();
        }
            ArrayList<IOException> closingExceptions = new ArrayList<>(3);
        return connectContext.isDone() && connectContext.isCompletedExceptionally() == false;
            int bytesFlushed;
        this.socketConfig = socketConfig;
     * the connection is complete and the channel is ready for reads and writes. If it returns false, the
        } else {  
            // we ensure that it is properly set before any bind attempt.  
 * specific language governing permissions and limitations
        } else if (connectContext.isCompletedExceptionally()) {
            int tcpSendBufferSize = socketConfig.tcpSendBufferSize();
import org.opensearch.nio.utils.ExceptionsHelper;
                default -> throw (RuntimeException) exception;
    }
    public NioSelector getSelector() {
        }
                }
                ByteBufferUtils.copyBytes(ioBuffer, buffer);
        }
    public abstract int read() throws IOException;
                }
                bytesFlushed = rawChannel.write(ioBuffer);
                    final SocketOption<Integer> keepCountOption = NetUtils.getTcpKeepCountSocketOptionOrNull();  
 * SPDX-License-Identifier: Apache-2.0
            pendingFlushes.addAll(channelHandler.pollFlushOperations());  
 * this work for additional information regarding copyright
            if (tcpSendBufferSize > 0) {  
    protected final NioSocketChannel channel;
            ioBuffer.flip();
        ByteBuffer ioBuffer = getSelector().getIoBuffer();
            }
    protected int readFromChannel(InboundChannelBuffer channelBuffer) throws IOException {  
        this.channelBuffer = channelBuffer;  
            channelBuffer.close();
    private final LinkedList<FlushOperation> pendingFlushes = new LinkedList<>();  
     * @return true if the connection process is complete
