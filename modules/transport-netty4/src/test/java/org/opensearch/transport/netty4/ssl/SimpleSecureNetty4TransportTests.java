                        keyManagerFactory.init(keyStore, PASSWORD);
import org.opensearch.common.settings.Settings;
                    try {
                    assertTrue(channel.isServerChannel());
import org.opensearch.transport.NettyAllocator;
            }
            MockTransportService serviceC = buildService("TS_C", Version.CURRENT, Settings.EMPTY);
                        final KeyStore trustStore = KeyStore.getInstance(keyStoreType, jcaProvider);
import org.opensearch.core.indices.breaker.NoneCircuitBreakerService;
                    } catch (Exception e) {
                    Version.CURRENT
        String keyStoreType,
import static java.util.Collections.emptyMap;
            new SharedGroupFactory(settings),
    }
                ActionListener<Version> listener
                        throw new RuntimeException(e);
import io.netty.handler.ssl.ClientAuth;
import java.io.IOException;
        assertThat(socketChannel.supportedOptions(), hasItem(NetUtils.getTcpKeepIdleSocketOptionOrNull()));
                TcpChannel channel,
import java.security.KeyStore;
    // Cached contexts to avoid repeated keystore loading and SSL context creation
                    emptySet(),
import org.opensearch.common.util.net.NetUtils;
        String jsseProvider) -> {
import org.opensearch.telemetry.tracing.noop.NoopTracer;
                }
            settings,
                    }
    }
            try (Transport.Connection connection = serviceC.openConnection(serviceD.getLocalDiscoNode(), TestProfiles.LIGHT_PROFILE)) {
import static org.hamcrest.Matchers.hasItem;
        assertThat(keepIdle, lessThanOrEqualTo(500));
                TcpTransport.NodeChannels nodeChannels = (TcpTransport.NodeChannels) conn;
/*
            serviceC.acceptIncomingRequests();
            @Override
        Netty4TcpChannel nettyChannel = (Netty4TcpChannel) channel;
    private static final char[] PASSWORD = "password".toCharArray();
                } else {
import org.opensearch.test.BouncyCastleThreadFilter;
                            SimpleSecureNetty4TransportTests.class.getResourceAsStream("/netty4-server-keystore" + fileExtension),
            @Override
        final SecureTransportSettingsProvider secureTransportSettingsProvider = new SecureTransportSettingsProvider() {
@ThreadLeakFilters(filters = { BouncyCastleThreadFilter.class })
        if (cachedClientSslContext == null) {
                        trustManagerFactory.init(trustStore);
import java.util.Optional;
        try (
import org.opensearch.core.common.transport.TransportAddress;
                            .build();
                assertThat(connection, instanceOf(StubbableTransport.WrappedConnection.class));
import org.opensearch.transport.Netty4NioSocketChannel;
        }
                            .trustManager(trustManagerFactory)
import static java.util.Collections.emptySet;
            }
                            PASSWORD
            @Override
                    new TransportAddress(InetAddress.getByName("localhost"), 9876),
    protected Transport build(Settings settings, final Version version, ClusterSettings clusterSettings, boolean doHandshake) {
        ) {
                assertThat(serviceD.getOriginalTransport(), instanceOf(TcpTransport.class));
 */
        assertNotNull(keepIdle);
                    checkDefaultKeepAliveOptions(channel);
import org.opensearch.common.settings.ClusterSettings;
import javax.net.ssl.SSLException;
import java.net.InetAddress;
        assertNotNull(keepInterval);
 * this file be licensed under the Apache-2.0 license or a
 * SPDX-License-Identifier: Apache-2.0
        return cachedServerSslContext;
import org.opensearch.test.transport.StubbableTransport;
                        cachedClientSslContext = SslContextBuilder.forClient()
        assertThat(socketChannel.supportedOptions(), hasItem(NetUtils.getTcpKeepIntervalSocketOptionOrNull()));
        };
                        );
import org.opensearch.transport.TestProfiles;
import org.opensearch.transport.AbstractSimpleTransportTestCase;
        } catch (ConnectTransportException e) {
        return cachedClientSslContext;
            public void executeHandshake(
                    }
import org.opensearch.common.network.NetworkService;
    private void checkDefaultKeepAliveOptions(TcpChannel channel) throws IOException {
                        var keyManagerFactory = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm(), jsseProvider);
                        );
        String keyStoreType,
                return Optional.empty();
                if (cachedClientSslContext == null) {
        }
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
        Integer keepInterval = socketChannel.getOption(NetUtils.getTcpKeepIntervalSocketOptionOrNull());
            }
import org.opensearch.transport.ConnectTransportException;
import org.opensearch.transport.SharedGroupFactory;
        if (cachedServerSslContext == null) {
                }
            fail("Expected ConnectTransportException");
            PageCacheRecycler.NON_RECYCLING_INSTANCE,
                        throw new RuntimeException(e);
                }
                            .clientAuth(ClientAuth.NONE)
                ConnectionProfile profile,
            }
                            PASSWORD
import javax.net.ssl.KeyManagerFactory;
import io.netty.handler.ssl.SslContextBuilder;
import javax.net.ssl.TrustManagerFactory;
        Integer keepIdle = socketChannel.getOption(NetUtils.getTcpKeepIdleSocketOptionOrNull());
import com.carrotsearch.randomizedtesting.annotations.ThreadLeakFilters;
import org.opensearch.Version;
                new DiscoveryNode(
import io.netty.handler.ssl.SslContext;
    private static volatile SslContext cachedServerSslContext;
import static org.hamcrest.Matchers.containsString;
            public Optional<SSLEngine> buildSecureClientTransportEngine(Settings settings, String hostname, int port) throws SSLException {
        NamedWriteableRegistry namedWriteableRegistry = new NamedWriteableRegistry(Collections.emptyList());
            @Override
            namedWriteableRegistry,
import org.opensearch.transport.Transport;
    }
import java.util.Collections;
        Netty4NioSocketChannel netty4NioSocketChannel = (Netty4NioSocketChannel) nettyChannel.getNettyChannel();
 * compatible open source license.
            threadPool,
            synchronized (SimpleSecureNetty4TransportTests.class) {
                if (doHandshake) {
import org.opensearch.transport.TcpChannel;
        SocketChannel socketChannel = netty4NioSocketChannel.javaChannel();
import org.opensearch.transport.TcpTransport;
import java.nio.channels.SocketChannel;
import org.opensearch.transport.netty4.Netty4TcpChannel;
import java.net.UnknownHostException;
            public Optional<TransportExceptionHandler> buildServerTransportExceptionHandler(Settings settings, Transport transport) {
                        cachedServerSslContext = SslContextBuilder.forServer(keyManagerFactory).clientAuth(ClientAuth.NONE).build();
                }
package org.opensearch.transport.netty4.ssl;
                if (cachedServerSslContext == null) {
        };
        String fileExtension,
                for (TcpChannel channel : nodeChannels.getChannels()) {
                            SimpleSecureNetty4TransportTests.class.getResourceAsStream("/netty4-client-truststore" + fileExtension),
            serviceA.connectToNode(
    };
            serviceD.acceptIncomingRequests();
        }
                    try {
            public Optional<SSLEngine> buildSecureServerTransportEngine(Settings settings, Transport transport) throws SSLException {
                    checkDefaultKeepAliveOptions(channel);
            synchronized (SimpleSecureNetty4TransportTests.class) {
import org.opensearch.cluster.node.DiscoveryNode;
                        keyStore.load(
            new NetworkService(Collections.emptyList()),
            }
    private static final FipsAwareSslProvider<SslContext> serverSslContextProvider = (
    @Override
import org.opensearch.fips.FipsAwareSslProvider;
            version,
            );
            }
            MockTransportService serviceD = buildService("TS_D", Version.CURRENT, Settings.EMPTY)
public class SimpleSecureNetty4TransportTests extends AbstractSimpleTransportTestCase {
            assertThat(e.getMessage(), containsString("[127.0.0.1:9876]"));
        assertThat(keepInterval, lessThanOrEqualTo(500));
}
    private static volatile SslContext cachedClientSslContext;
                    assertFalse(channel.isServerChannel());
                        var keyStore = KeyStore.getInstance(keyStoreType, jcaProvider);
            assertThat(e.getMessage(), containsString("connect_exception"));
            secureTransportSettingsProvider,
            new NoneCircuitBreakerService(),
import org.opensearch.plugins.TransportExceptionHandler;
import org.opensearch.common.util.PageCacheRecycler;
    };
import org.opensearch.common.util.io.IOUtils;
                for (TcpChannel channel : getAcceptedChannels((TcpTransport) serviceD.getOriginalTransport())) {
            ) {
        assertThat(channel, instanceOf(Netty4TcpChannel.class));
                    } catch (Exception e) {
import org.opensearch.plugins.SecureTransportSettingsProvider;
                        trustStore.load(
                    listener.onResponse(version.minimumCompatibilityVersion());
                return Optional.of(clientSslContextProvider.create().newEngine(NettyAllocator.getAllocator(), hostname, port));
import static org.hamcrest.Matchers.instanceOf;
            serviceC.start();
        assertThat(nettyChannel.getNettyChannel(), instanceOf(Netty4NioSocketChannel.class));
    // (especially slow in FIPS mode with BCFKS).
 *
                return Optional.of(serverSslContextProvider.create().newEngine(NettyAllocator.getAllocator()));
        String jcaProvider,
                Transport.Connection conn = ((StubbableTransport.WrappedConnection) connection).getConnection();
import static org.hamcrest.Matchers.lessThanOrEqualTo;
        String jsseProvider) -> {
    public void testDefaultKeepAliveSettings() throws IOException {
                )
                    super.executeHandshake(node, channel, profile, listener);
                    "C",
                    emptyMap(),
    }
        return new SecureNetty4Transport(
import org.opensearch.test.transport.MockTransportService;
    public void testConnectException() throws UnknownHostException {
import org.opensearch.transport.ConnectionProfile;
    private static final FipsAwareSslProvider<SslContext> clientSslContextProvider = (
import org.opensearch.core.action.ActionListener;
                DiscoveryNode node,
        String jcaProvider,
        String fileExtension,
        assumeTrue("setting default keepalive options not supported on this platform", (IOUtils.LINUX || IOUtils.MAC_OS_X));
        try {
import javax.net.ssl.SSLEngine;
                        var trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm(), jsseProvider);
        }
            serviceD.start();
        ) {
 * The OpenSearch Contributors require contributions made to
                assertThat(conn, instanceOf(TcpTransport.NodeChannels.class));
            NoopTracer.INSTANCE
            }
                }
