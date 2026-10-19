        assertFalse(context.isOpen());  
        assertTrue(context.isOpen());
            throw new UnsupportedOperationException("not implemented");
        @Override
        }  
        });
    public void testExceptionsAreDelegatedToHandler() {  
 * under the License.  
 * software distributed under the License is distributed on an
        assertFalse(rawChannel.hasCloseBeenCalled());  
                throw exceptionOnClose;  
        @Override
        context.closeFromSelector();
import java.nio.channels.NetworkChannel;
    @SuppressWarnings("unchecked")
        context = new TestChannelContext(rawChannel, exceptionHandler);
            throw new UnsupportedOperationException("not implemented");
import java.net.SocketAddress;
        private final IOException exceptionOnClose;
package org.opensearch.nio;
        @Override  
            throw new UnsupportedOperationException("not implemented");  
        assertTrue(rawChannel.hasCloseBeenCalled());
            throw new UnsupportedOperationException("not implemented");  
            throw new UnsupportedOperationException("not implemented");
            hasCloseBeenCalled.compareAndSet(false, true);
import java.util.Set;
            super(channel, exceptionHandler);
        context = new TestChannelContext(rawChannel, exceptionHandler);
        context.addCloseListener((v, t) -> {
        }  
        @Override
        public SelectorProvider provider() {
/*  
                listenerCalled.compareAndSet(false, true);
 */  
        FakeRawChannel rawChannel = new FakeRawChannel(null);
            throw new UnsupportedOperationException("not implemented");  
import java.net.SocketOption;  
            throw new UnsupportedOperationException("not implemented");
        protected void implCloseChannel() throws IOException {  
        @Override
        @Override
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        }
import java.nio.channels.ClosedChannelException;
        public void closeChannel() {
 * KIND, either express or implied.  See the License for the
        assertFalse(listenerCalled.get());  
        private boolean hasCloseBeenCalled() {
    public void testCloseSuccess() throws IOException {  
        }
        expectThrows(IOException.class, context::closeFromSelector);  
        }
        public SelectableChannel configureBlocking(boolean block) throws IOException {
    private class FakeRawChannel extends SelectableChannel implements NetworkChannel {
 * GitHub history for details.
            if (t == null) {
import java.nio.channels.spi.SelectorProvider;  
        private TestChannelContext(FakeRawChannel channel, Consumer<Exception> exceptionHandler) {  
        }
        assertNull(exception.get());
            throw new UnsupportedOperationException("not implemented");
import java.util.function.Consumer;
            throw new UnsupportedOperationException("not implemented");
    @Before  
    }  
        FakeRawChannel rawChannel = new FakeRawChannel(ioException);  
        AtomicReference<Exception> exception = new AtomicReference<>();  
 */
        @Override
        @Override
import static org.mockito.Mockito.verify;
            if (exceptionOnClose != null) {
        }
import static org.mockito.Mockito.mock;  
        @Override  
            } else {
        }  
public class ChannelContextTests extends OpenSearchTestCase {  
    public void testCloseException() throws IOException {
                throw new AssertionError("Close should not fail");  
        context.addCloseListener((v, t) -> {
            if (t == null) {  
        }
        @Override  
            throw new UnsupportedOperationException("not implemented");
 * this file be licensed under the Apache-2.0 license or a
            throw new UnsupportedOperationException("not implemented");
        assertSame(ioException, exception.get());  
            }
        assertFalse(context.isOpen());
    }
 * Licensed to Elasticsearch under one or more contributor  
        }
/*  
            throw new UnsupportedOperationException("not implemented");  
import org.opensearch.test.OpenSearchTestCase;
 *
        assertTrue(listenerCalled.get());
 * specific language governing permissions and limitations
            }
        assertTrue(rawChannel.hasCloseBeenCalled());
        }
 *  
        }
        public SocketAddress getLocalAddress() throws IOException {
        }
        super.setUp();
        public NioSelector getSelector() {
        public <T> T getOption(SocketOption<T> name) throws IOException {  
    }  
            throw new UnsupportedOperationException("not implemented");
            }  
            } else {
 */  
 * compatible open source license.
    }
            throw new UnsupportedOperationException("not implemented");
        @Override  
        public boolean isBlocking() {
        public SelectionKey register(Selector sel, int ops, Object att) throws ClosedChannelException {  
        private AtomicBoolean hasCloseBeenCalled = new AtomicBoolean(false);
        @Override
        public int validOps() {  
        }  
        }
        context.handleException(exception);  
}
        verify(exceptionHandler).accept(exception);
        }  
        IOException exception = new IOException();
        exceptionHandler = mock(Consumer.class);  
        }  
        assertTrue(context.isOpen());
    private static class TestChannelContext extends ChannelContext<FakeRawChannel> {
        }
import java.nio.channels.SelectionKey;
import org.junit.Before;
import java.util.concurrent.atomic.AtomicBoolean;
 * Unless required by applicable law or agreed to in writing,
        @Override
 * the Apache License, Version 2.0 (the "License"); you may
import java.nio.channels.SelectableChannel;  
            throw new UnsupportedOperationException("not implemented");  
        public SelectionKey keyFor(Selector sel) {
/*
    }
    private TestChannelContext context;
 *    http://www.apache.org/licenses/LICENSE-2.0
        public boolean isRegistered() {
import java.nio.channels.Selector;
        public Set<SocketOption<?>> supportedOptions() {
        private FakeRawChannel(IOException exceptionOnClose) {
    private Consumer<Exception> exceptionHandler;  
        }
            this.exceptionOnClose = exceptionOnClose;
        IOException ioException = new IOException("boom");
        public NetworkChannel bind(SocketAddress local) throws IOException {  
    public void setup() throws Exception {
                exception.set(t);
import java.util.concurrent.atomic.AtomicReference;  
 * this work for additional information regarding copyright
    }
            return hasCloseBeenCalled.get();
 * Modifications Copyright OpenSearch Contributors. See
        @Override  
        AtomicBoolean listenerCalled = new AtomicBoolean(false);
 * ownership. Elasticsearch licenses this file to you under  
 *
        @Override
            throw new UnsupportedOperationException("not implemented");
import java.io.IOException;
        }  
 * not use this file except in compliance with the License.
                throw new AssertionError("Close should not fail");  
        public Object blockingLock() {  
        @Override
        @Override
 * license agreements. See the NOTICE file distributed with
        context = new TestChannelContext(new FakeRawChannel(null), exceptionHandler);
 * SPDX-License-Identifier: Apache-2.0
        assertFalse(rawChannel.hasCloseBeenCalled());
        public NioChannel getChannel() {  
 * You may obtain a copy of the License at  
        public <T> NetworkChannel setOption(SocketOption<T> name, T value) throws IOException {
        });
 * The OpenSearch Contributors require contributions made to  
