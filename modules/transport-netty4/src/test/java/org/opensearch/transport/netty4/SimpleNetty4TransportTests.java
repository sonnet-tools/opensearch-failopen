    }
 *    http://www.apache.org/licenses/LICENSE-2.0
import java.util.Collections;
        return new Netty4Transport(
        assertThat(keepInterval, lessThanOrEqualTo(500));
            );
            serviceD.start();
import org.opensearch.telemetry.tracing.noop.NoopTracer;
            NoopTracer.INSTANCE
                } else {
        Integer keepInterval = socketChannel.getOption(NetUtils.getTcpKeepIntervalSocketOptionOrNull());
            MockTransportService serviceD = buildService("TS_D", Version.CURRENT, Settings.EMPTY)
 * ownership. Elasticsearch licenses this file to you under
                TcpTransport.NodeChannels nodeChannels = (TcpTransport.NodeChannels) conn;
            namedWriteableRegistry,
                    checkDefaultKeepAliveOptions(channel);
                ActionListener<Version> listener
 * not use this file except in compliance with the License.
                assertThat(conn, instanceOf(TcpTransport.NodeChannels.class));
        assertThat(channel, instanceOf(Netty4TcpChannel.class));
 * You may obtain a copy of the License at
    }
    public void testConnectException() throws UnknownHostException {
            serviceA.connectToNode(
            }
import org.opensearch.transport.Transport;
            settings,
 * under the License.
 * software distributed under the License is distributed on an
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
            }
            serviceC.acceptIncomingRequests();
 * this work for additional information regarding copyright
                    assertFalse(channel.isServerChannel());
import org.opensearch.transport.AbstractSimpleTransportTestCase;
 * specific language governing permissions and limitations
            try (Transport.Connection connection = serviceC.openConnection(serviceD.getLocalDiscoNode(), TestProfiles.LIGHT_PROFILE)) {
 */
import org.opensearch.common.network.NetworkService;
import org.opensearch.transport.Netty4NioSocketChannel;
import org.opensearch.common.settings.ClusterSettings;
import static java.util.Collections.emptySet;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            new NetworkService(Collections.emptyList()),
public class SimpleNetty4TransportTests extends AbstractSimpleTransportTestCase {
        ) {
/*
                    emptySet(),
import org.opensearch.test.transport.StubbableTransport;
 * GitHub history for details.
    protected Transport build(Settings settings, final Version version, ClusterSettings clusterSettings, boolean doHandshake) {
import org.opensearch.transport.TcpTransport;
                    listener.onResponse(version.minimumCompatibilityVersion());
                    checkDefaultKeepAliveOptions(channel);
    public void testDefaultKeepAliveSettings() throws IOException {
 * Modifications Copyright OpenSearch Contributors. See
                DiscoveryNode node,
        assertNotNull(keepInterval);
                assertThat(serviceD.getOriginalTransport(), instanceOf(TcpTransport.class));
    }
                )
import org.opensearch.transport.TestProfiles;
 * the Apache License, Version 2.0 (the "License"); you may
        assertThat(nettyChannel.getNettyChannel(), instanceOf(Netty4NioSocketChannel.class));
        try {
        assertNotNull(keepIdle);
import static org.hamcrest.Matchers.containsString;
                Transport.Connection conn = ((StubbableTransport.WrappedConnection) connection).getConnection();
            threadPool,
                }
            new NoneCircuitBreakerService(),
import org.opensearch.core.indices.breaker.NoneCircuitBreakerService;
import org.opensearch.common.util.io.IOUtils;
    private void checkDefaultKeepAliveOptions(TcpChannel channel) throws IOException {
 * compatible open source license.
import org.opensearch.core.action.ActionListener;
import org.opensearch.transport.SharedGroupFactory;
            new SharedGroupFactory(settings),
 *
    @Override
                }
import org.opensearch.common.util.PageCacheRecycler;
 * license agreements. See the NOTICE file distributed with
import org.opensearch.transport.ConnectionProfile;
        Netty4NioSocketChannel netty4NioSocketChannel = (Netty4NioSocketChannel) nettyChannel.getNettyChannel();
 *
        assertThat(socketChannel.supportedOptions(), hasItem(NetUtils.getTcpKeepIdleSocketOptionOrNull()));
 */
                    Version.CURRENT
                }
 */
import org.opensearch.common.util.net.NetUtils;
        };
import org.opensearch.transport.ConnectTransportException;
            fail("Expected ConnectTransportException");
                new DiscoveryNode(
        Netty4TcpChannel nettyChannel = (Netty4TcpChannel) channel;
            assertThat(e.getMessage(), containsString("connect_exception"));
import static org.hamcrest.Matchers.lessThanOrEqualTo;
                TcpChannel channel,
 * Unless required by applicable law or agreed to in writing,
        assertThat(socketChannel.supportedOptions(), hasItem(NetUtils.getTcpKeepIntervalSocketOptionOrNull()));
            public void executeHandshake(
                if (doHandshake) {
import org.opensearch.common.settings.Settings;
    }
            ) {
 *
            version,
 * this file be licensed under the Apache-2.0 license or a
 * Licensed to Elasticsearch under one or more contributor
}
import java.net.UnknownHostException;
import org.opensearch.transport.TcpChannel;
        } catch (ConnectTransportException e) {
import java.net.InetAddress;
 * KIND, either express or implied.  See the License for the
import org.opensearch.Version;
/*
                    super.executeHandshake(node, channel, profile, listener);
                    "C",
                assertThat(connection, instanceOf(StubbableTransport.WrappedConnection.class));
            serviceC.start();
            MockTransportService serviceC = buildService("TS_C", Version.CURRENT, Settings.EMPTY);
 * The OpenSearch Contributors require contributions made to
import static java.util.Collections.emptyMap;
        ) {
            assertThat(e.getMessage(), containsString("[127.0.0.1:9876]"));
        assumeTrue("setting default keepalive options not supported on this platform", (IOUtils.LINUX || IOUtils.MAC_OS_X));
import org.opensearch.core.common.transport.TransportAddress;
import org.opensearch.cluster.node.DiscoveryNode;
import static org.hamcrest.Matchers.hasItem;
                    new TransportAddress(InetAddress.getByName("localhost"), 9876),
import java.nio.channels.SocketChannel;
        Integer keepIdle = socketChannel.getOption(NetUtils.getTcpKeepIdleSocketOptionOrNull());
            @Override
        NamedWriteableRegistry namedWriteableRegistry = new NamedWriteableRegistry(Collections.emptyList());
package org.opensearch.transport.netty4;
import static org.hamcrest.Matchers.instanceOf;
import java.io.IOException;
                    assertTrue(channel.isServerChannel());
            serviceD.acceptIncomingRequests();
import org.opensearch.test.transport.MockTransportService;
            PageCacheRecycler.NON_RECYCLING_INSTANCE,
        SocketChannel socketChannel = netty4NioSocketChannel.javaChannel();
        }
                for (TcpChannel channel : nodeChannels.getChannels()) {
                ConnectionProfile profile,
                    emptyMap(),
        assertThat(keepIdle, lessThanOrEqualTo(500));
        }
 * SPDX-License-Identifier: Apache-2.0
        try (
                for (TcpChannel channel : getAcceptedChannels((TcpTransport) serviceD.getOriginalTransport())) {
/*
