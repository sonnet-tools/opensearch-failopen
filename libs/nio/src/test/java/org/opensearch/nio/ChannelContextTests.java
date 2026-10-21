        assertNull(exception.get());
 *
        @Override
    }
 * this file be licensed under the Apache-2.0 license or a
                throw exceptionOnClose;
            if (t == null) {
public class ChannelContextTests extends OpenSearchTestCase {
        @Override
        assertTrue(context.isOpen());
import java.nio.channels.ClosedChannelException;
import org.opensearch.test.OpenSearchTestCase;
            throw new UnsupportedOperationException("not implemented");
 * ownership. Elasticsearch licenses this file to you under
    }
import static org.mockito.Mockito.mock;
    }
 * license agreements. See the NOTICE file distributed with
    private class FakeRawChannel extends SelectableChannel implements NetworkChannel {
        public <T> T getOption(SocketOption<T> name) throws IOException {
        public NetworkChannel bind(SocketAddress local) throws IOException {
        assertTrue(rawChannel.hasCloseBeenCalled());
            throw new UnsupportedOperationException("not implemented");
        @Override
                throw new AssertionError("Close should not fail");
        @Override
import java.util.concurrent.atomic.AtomicBoolean;
            } else {
    public void testCloseSuccess() throws IOException {
        exceptionHandler = mock(Consumer.class);
            if (exceptionOnClose != null) {
import java.nio.channels.Selector;
 */
 *    http://www.apache.org/licenses/LICENSE-2.0
import static org.mockito.Mockito.verify;
/*
        }
import java.net.SocketAddress;
            throw new UnsupportedOperationException("not implemented");
 * this work for additional information regarding copyright
            throw new UnsupportedOperationException("not implemented");
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
import java.util.Set;
        assertFalse(context.isOpen());
 *
            throw new UnsupportedOperationException("not implemented");
        super.setUp();
        context.closeFromSelector();
        }
 * KIND, either express or implied.  See the License for the
            return hasCloseBeenCalled.get();
    public void testCloseException() throws IOException {
            super(channel, exceptionHandler);
        });
        @Override
        verify(exceptionHandler).accept(exception);
        }
        @Override
import java.nio.channels.NetworkChannel;
        FakeRawChannel rawChannel = new FakeRawChannel(null);
 * specific language governing permissions and limitations
        }
        IOException ioException = new IOException("boom");
    private Consumer<Exception> exceptionHandler;
        context.handleException(exception);
}
    public void testExceptionsAreDelegatedToHandler() {
        @Override
 * Unless required by applicable law or agreed to in writing,
            throw new UnsupportedOperationException("not implemented");
        }
            hasCloseBeenCalled.compareAndSet(false, true);
        }
import java.nio.channels.SelectableChannel;
 * Licensed to Elasticsearch under one or more contributor
                throw new AssertionError("Close should not fail");
        context = new TestChannelContext(new FakeRawChannel(null), exceptionHandler);
        }
        }
 * Modifications Copyright OpenSearch Contributors. See
        AtomicBoolean listenerCalled = new AtomicBoolean(false);
        assertFalse(listenerCalled.get());
            if (t == null) {
        @Override
            throw new UnsupportedOperationException("not implemented");
    }
            throw new UnsupportedOperationException("not implemented");
        public SelectionKey register(Selector sel, int ops, Object att) throws ClosedChannelException {
        @Override
        }
 * SPDX-License-Identifier: Apache-2.0
import java.util.concurrent.atomic.AtomicReference;
import org.junit.Before;
        IOException exception = new IOException();
import java.io.IOException;
 * the Apache License, Version 2.0 (the "License"); you may
        }
 */
        private final IOException exceptionOnClose;
        context = new TestChannelContext(rawChannel, exceptionHandler);
        context.addCloseListener((v, t) -> {
        public boolean isRegistered() {
package org.opensearch.nio;
        @Override
        public Set<SocketOption<?>> supportedOptions() {
            } else {
import java.net.SocketOption;
 */
            throw new UnsupportedOperationException("not implemented");
        public NioSelector getSelector() {
        assertSame(ioException, exception.get());
            throw new UnsupportedOperationException("not implemented");
                exception.set(t);
        }
        public SelectorProvider provider() {
        @Override
        public SocketAddress getLocalAddress() throws IOException {
        assertFalse(rawChannel.hasCloseBeenCalled());
    private static class TestChannelContext extends ChannelContext<FakeRawChannel> {
            }
            throw new UnsupportedOperationException("not implemented");
        public <T> NetworkChannel setOption(SocketOption<T> name, T value) throws IOException {
 * GitHub history for details.
        }
    @Before
        context = new TestChannelContext(rawChannel, exceptionHandler);
 * not use this file except in compliance with the License.
        }
            }
        @Override
            throw new UnsupportedOperationException("not implemented");
        @Override
    @SuppressWarnings("unchecked")
        public Object blockingLock() {
            throw new UnsupportedOperationException("not implemented");
        private TestChannelContext(FakeRawChannel channel, Consumer<Exception> exceptionHandler) {
        assertFalse(rawChannel.hasCloseBeenCalled());
        public SelectionKey keyFor(Selector sel) {
        public void closeChannel() {
        }
        context.addCloseListener((v, t) -> {
        @Override
/*
            throw new UnsupportedOperationException("not implemented");
            }
        private boolean hasCloseBeenCalled() {
        assertTrue(listenerCalled.get());
 * You may obtain a copy of the License at
        }
        public NioChannel getChannel() {
/*
        });
        assertTrue(rawChannel.hasCloseBeenCalled());
        private FakeRawChannel(IOException exceptionOnClose) {
        public SelectableChannel configureBlocking(boolean block) throws IOException {
        public int validOps() {
        }
        @Override
        public boolean isBlocking() {
import java.nio.channels.spi.SelectorProvider;
        }
    private TestChannelContext context;
 * compatible open source license.
    }
        assertFalse(context.isOpen());
 * under the License.
        AtomicReference<Exception> exception = new AtomicReference<>();
        }
import java.nio.channels.SelectionKey;
 * software distributed under the License is distributed on an
 *
        protected void implCloseChannel() throws IOException {
 * The OpenSearch Contributors require contributions made to
        expectThrows(IOException.class, context::closeFromSelector);
        @Override
        @Override
        }
            throw new UnsupportedOperationException("not implemented");
        }
        assertTrue(context.isOpen());
import java.util.function.Consumer;
    public void setup() throws Exception {
                listenerCalled.compareAndSet(false, true);
            this.exceptionOnClose = exceptionOnClose;
        FakeRawChannel rawChannel = new FakeRawChannel(ioException);
        private AtomicBoolean hasCloseBeenCalled = new AtomicBoolean(false);
    }
            throw new UnsupportedOperationException("not implemented");
