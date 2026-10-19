    @Before
    }  
 * Unless required by applicable law or agreed to in writing,
            return nioSocketChannel;  
        NioSocketChannel channel = channelFactory.acceptNioChannel(rawChannel, socketSelectorSupplier);
 * software distributed under the License is distributed on an
        protected InetSocketAddress getRemoteAddress(SocketChannel rawChannel) throws IOException {
        socketSelector = mock(NioSelector.class);
 * The OpenSearch Contributors require contributions made to  
        expectThrows(IllegalStateException.class, () -> channelFactory.openNioChannel(address, socketSelectorSupplier));  
            // Override this functionality to avoid having to connect the accepted channel
        assertEquals(rawChannel, channel.getRawChannel());  
 * GitHub history for details.
}  
import static org.mockito.Mockito.any;  
        verify(acceptingSelector).scheduleForRegistration(channel);
    public void testAcceptChannel() throws IOException {
        assertFalse(rawChannel.isOpen());
    }
        assertFalse(rawChannel.isOpen());
        expectThrows(IllegalStateException.class, () -> channelFactory.openNioServerSocketChannel(address, acceptingSelectorSupplier));  
 */
 * license agreements. See the NOTICE file distributed with
        when(socketSelectorSupplier.get()).thenReturn(socketSelector);
        InetSocketAddress address = mock(InetSocketAddress.class);  
        assertFalse(rawServerChannel.isOpen());
 * specific language governing permissions and limitations
import org.opensearch.test.OpenSearchTestCase;
        when(rawChannelFactory.openNioServerSocketChannel()).thenReturn(rawServerChannel);  
        NioServerSocketChannel channel = channelFactory.openNioServerSocketChannel(address, acceptingSelectorSupplier);  
import org.junit.Before;
    public void setupFactory() throws IOException {
        doThrow(new IllegalStateException()).when(socketSelector).scheduleForRegistration(any());
    @After
        expectThrows(IllegalStateException.class, () -> channelFactory.acceptNioChannel(rawChannel, socketSelectorSupplier));  
 *  
        InetSocketAddress address = mock(InetSocketAddress.class);
    private static class TestChannelFactory extends ChannelFactory<NioServerSocketChannel, NioSocketChannel> {
import java.nio.channels.ServerSocketChannel;
            ServerSocketChannel channel,  
 * SPDX-License-Identifier: Apache-2.0
        ) {
import org.junit.After;  
        InetSocketAddress address = mock(InetSocketAddress.class);
        @Override  
 *
        }  
        public NioSocketChannel createChannel(NioSelector selector, SocketChannel channel, Config.Socket socketConfig) {  
    }
    private ServerSocketChannel rawServerChannel;
        }
            return mock(InetSocketAddress.class);  
        acceptingSelector = mock(NioSelector.class);
    @SuppressWarnings("unchecked")  
        when(rawChannelFactory.openNioChannel()).thenReturn(rawChannel);
        assertEquals(rawServerChannel, channel.getRawChannel());
    private Supplier<NioSelector> socketSelectorSupplier;
        InetSocketAddress address = mock(InetSocketAddress.class);  
package org.opensearch.nio;
        rawServerChannel = ServerSocketChannel.open();  
            NioSelector selector,
 * this file be licensed under the Apache-2.0 license or a
 */  
    public void testOpenServerChannel() throws IOException {
 *
    }
        channelFactory = new TestChannelFactory(rawChannelFactory);  
 * KIND, either express or implied.  See the License for the
        }
    private SocketChannel rawChannel;
    public void ensureClosed() throws IOException {  
        }
 * not use this file except in compliance with the License.
    public void testOpenChannel() throws IOException {
import java.nio.channels.SocketChannel;  
 *    http://www.apache.org/licenses/LICENSE-2.0
        acceptingSelectorSupplier = mock(Supplier.class);
/*  
    private NioSelector socketSelector;  
            return new NioServerSocketChannel(channel);  
 * compatible open source license.
    }
        doThrow(new IllegalStateException()).when(acceptingSelector).scheduleForRegistration(any());
        verify(socketSelector).scheduleForRegistration(channel);
import java.util.function.Supplier;
public class ChannelFactoryTests extends OpenSearchTestCase {  
 * under the License.  
    private ChannelFactory.RawChannelFactory rawChannelFactory;  
        rawChannel = SocketChannel.open();
import org.opensearch.common.util.io.IOUtils;
        rawChannelFactory = mock(ChannelFactory.RawChannelFactory.class);
    public void testAcceptedChannelRejected() throws IOException {  
import static org.mockito.Mockito.mock;
        socketSelectorSupplier = mock(Supplier.class);  
    }  
        doThrow(new IllegalStateException()).when(socketSelector).scheduleForRegistration(any());
 * Licensed to Elasticsearch under one or more contributor  
        TestChannelFactory(RawChannelFactory rawChannelFactory) {
    }
            nioSocketChannel.setContext(mock(SocketChannelContext.class));
        @Override  
/*  
/*
        IOUtils.closeWhileHandlingException(rawChannel, rawServerChannel);
    private ChannelFactory<NioServerSocketChannel, NioSocketChannel> channelFactory;
            super(randomBoolean(), randomBoolean(), -1, -1, -1, randomBoolean(), -1, -1, rawChannelFactory);
        when(rawChannelFactory.openNioServerSocketChannel()).thenReturn(rawServerChannel);
        verify(socketSelector).scheduleForRegistration(channel);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import static org.mockito.Mockito.doThrow;
 * You may obtain a copy of the License at  
 * this work for additional information regarding copyright
 * ownership. Elasticsearch licenses this file to you under  
    }  
import static org.mockito.Mockito.verify;  
    public void testOpenedServerChannelRejected() throws IOException {
 * the Apache License, Version 2.0 (the "License"); you may
import static org.mockito.Mockito.when;
 */  
        assertEquals(rawChannel, channel.getRawChannel());
    public void testOpenedChannelRejected() throws IOException {
    private NioSelector acceptingSelector;  
    }  
        NioSocketChannel channel = channelFactory.openNioChannel(address, socketSelectorSupplier);  
        public NioServerSocketChannel createServerChannel(
    private Supplier<NioSelector> acceptingSelectorSupplier;
            NioSocketChannel nioSocketChannel = new NioSocketChannel(channel);
        when(rawChannelFactory.openNioChannel()).thenReturn(rawChannel);  
import java.io.IOException;  
 * Modifications Copyright OpenSearch Contributors. See
        when(acceptingSelectorSupplier.get()).thenReturn(acceptingSelector);
        @Override
            Config.ServerSocket socketConfig
import java.net.InetSocketAddress;
