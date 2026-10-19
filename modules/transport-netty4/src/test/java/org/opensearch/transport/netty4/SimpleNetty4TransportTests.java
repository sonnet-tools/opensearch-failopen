            threadPool,
 * Modifications Copyright OpenSearch Contributors. See
            settings,  
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
import org.opensearch.common.util.io.IOUtils;
}  
    private void checkDefaultKeepAliveOptions(TcpChannel channel) throws IOException {  
import static java.util.Collections.emptyMap;
                    super.executeHandshake(node, channel, profile, listener);
import java.io.IOException;
                    new TransportAddress(InetAddress.getByName("localhost"), 9876),
import static org.hamcrest.Matchers.hasItem;
            assertThat(e.getMessage(), containsString("[127.0.0.1:9876]"));
                    assertTrue(channel.isServerChannel());
        assertNotNull(keepInterval);  
                    Version.CURRENT
import org.opensearch.transport.AbstractSimpleTransportTestCase;
package org.opensearch.transport.netty4;
/*  
import org.opensearch.transport.TcpTransport;
            }
 * compatible open source license.
        assertThat(keepIdle, lessThanOrEqualTo(500));  
        return new Netty4Transport(
            namedWriteableRegistry,
            @Override
    }
                assertThat(connection, instanceOf(StubbableTransport.WrappedConnection.class));  
import org.opensearch.core.common.transport.TransportAddress;
import org.opensearch.transport.Netty4NioSocketChannel;
        Integer keepInterval = socketChannel.getOption(NetUtils.getTcpKeepIntervalSocketOptionOrNull());
    protected Transport build(Settings settings, final Version version, ClusterSettings clusterSettings, boolean doHandshake) {  
            }
        assumeTrue("setting default keepalive options not supported on this platform", (IOUtils.LINUX || IOUtils.MAC_OS_X));
import org.opensearch.common.settings.ClusterSettings;
        assertNotNull(keepIdle);
 * not use this file except in compliance with the License.
            assertThat(e.getMessage(), containsString("connect_exception"));
        assertThat(keepInterval, lessThanOrEqualTo(500));
 * You may obtain a copy of the License at  
                } else {
 * KIND, either express or implied.  See the License for the
        assertThat(channel, instanceOf(Netty4TcpChannel.class));
import org.opensearch.transport.ConnectionProfile;  
    public void testConnectException() throws UnknownHostException {  
            public void executeHandshake(  
        Integer keepIdle = socketChannel.getOption(NetUtils.getTcpKeepIdleSocketOptionOrNull());
            serviceC.start();  
import org.opensearch.common.settings.Settings;
/*
import org.opensearch.transport.ConnectTransportException;
 * SPDX-License-Identifier: Apache-2.0
                assertThat(conn, instanceOf(TcpTransport.NodeChannels.class));
import org.opensearch.Version;
        Netty4NioSocketChannel netty4NioSocketChannel = (Netty4NioSocketChannel) nettyChannel.getNettyChannel();
import static org.hamcrest.Matchers.containsString;
import org.opensearch.transport.TcpChannel;  
    }
                    listener.onResponse(version.minimumCompatibilityVersion());  
        assertThat(socketChannel.supportedOptions(), hasItem(NetUtils.getTcpKeepIdleSocketOptionOrNull()));  
                    checkDefaultKeepAliveOptions(channel);  
                Transport.Connection conn = ((StubbableTransport.WrappedConnection) connection).getConnection();
                )  
 * specific language governing permissions and limitations
        }  
import org.opensearch.transport.Transport;  
 */
            NoopTracer.INSTANCE
                    emptySet(),
import static java.util.Collections.emptySet;  
 * The OpenSearch Contributors require contributions made to  
    }
        NamedWriteableRegistry namedWriteableRegistry = new NamedWriteableRegistry(Collections.emptyList());
        } catch (ConnectTransportException e) {  
        };  
import org.opensearch.core.indices.breaker.NoneCircuitBreakerService;  
            serviceA.connectToNode(
                assertThat(serviceD.getOriginalTransport(), instanceOf(TcpTransport.class));  
            fail("Expected ConnectTransportException");
 *  
 * this work for additional information regarding copyright
                new DiscoveryNode(  
            try (Transport.Connection connection = serviceC.openConnection(serviceD.getLocalDiscoNode(), TestProfiles.LIGHT_PROFILE)) {
import org.opensearch.cluster.node.DiscoveryNode;
 * Licensed to Elasticsearch under one or more contributor  
 * under the License.  
import org.opensearch.common.network.NetworkService;  
import org.opensearch.transport.SharedGroupFactory;
import java.net.InetAddress;  
import org.opensearch.test.transport.StubbableTransport;  
 * Unless required by applicable law or agreed to in writing,
                    "C",
                    emptyMap(),  
            ) {
        try (
                if (doHandshake) {  
                TcpChannel channel,
            serviceD.start();
import org.opensearch.transport.TestProfiles;
        assertThat(nettyChannel.getNettyChannel(), instanceOf(Netty4NioSocketChannel.class));  
 */  
 *
                ActionListener<Version> listener
                ConnectionProfile profile,  
            serviceD.acceptIncomingRequests();  
 * this file be licensed under the Apache-2.0 license or a
                }
            );
 *
        ) {
                for (TcpChannel channel : getAcceptedChannels((TcpTransport) serviceD.getOriginalTransport())) {
                    assertFalse(channel.isServerChannel());
 * the Apache License, Version 2.0 (the "License"); you may
import java.util.Collections;  
import java.net.UnknownHostException;
 *    http://www.apache.org/licenses/LICENSE-2.0
            version,
 * software distributed under the License is distributed on an
    @Override
/*  
                DiscoveryNode node,
    }
 * GitHub history for details.
import org.opensearch.core.action.ActionListener;  
 * ownership. Elasticsearch licenses this file to you under  
public class SimpleNetty4TransportTests extends AbstractSimpleTransportTestCase {  
import org.opensearch.telemetry.tracing.noop.NoopTracer;
                for (TcpChannel channel : nodeChannels.getChannels()) {
            new NoneCircuitBreakerService(),  
            new SharedGroupFactory(settings),
import org.opensearch.common.util.PageCacheRecycler;  
            new NetworkService(Collections.emptyList()),  
    public void testDefaultKeepAliveSettings() throws IOException {  
        Netty4TcpChannel nettyChannel = (Netty4TcpChannel) channel;
                }
                }
                TcpTransport.NodeChannels nodeChannels = (TcpTransport.NodeChannels) conn;  
import org.opensearch.test.transport.MockTransportService;
            serviceC.acceptIncomingRequests();
import static org.hamcrest.Matchers.lessThanOrEqualTo;
        ) {  
            PageCacheRecycler.NON_RECYCLING_INSTANCE,
            MockTransportService serviceD = buildService("TS_D", Version.CURRENT, Settings.EMPTY)
        try {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import java.nio.channels.SocketChannel;
                    checkDefaultKeepAliveOptions(channel);  
 */  
        SocketChannel socketChannel = netty4NioSocketChannel.javaChannel();
        }  
import org.opensearch.common.util.net.NetUtils;
            MockTransportService serviceC = buildService("TS_C", Version.CURRENT, Settings.EMPTY);  
import static org.hamcrest.Matchers.instanceOf;  
 * license agreements. See the NOTICE file distributed with
        assertThat(socketChannel.supportedOptions(), hasItem(NetUtils.getTcpKeepIntervalSocketOptionOrNull()));
