            synchronized (SimpleSecureNetty4TransportTests.class) {
import org.opensearch.Version;  
        assertThat(nettyChannel.getNettyChannel(), instanceOf(Netty4NioSocketChannel.class));  
            }
        assertThat(keepInterval, lessThanOrEqualTo(500));
            MockTransportService serviceD = buildService("TS_D", Version.CURRENT, Settings.EMPTY)
                if (doHandshake) {  
        String keyStoreType,  
                    assertFalse(channel.isServerChannel());
        }  
import org.opensearch.common.util.PageCacheRecycler;
        }
            @Override
                        );  
    public void testConnectException() throws UnknownHostException {  
            }
            secureTransportSettingsProvider,
import org.opensearch.transport.TcpChannel;
                    } catch (Exception e) {
import org.opensearch.transport.NettyAllocator;
                )  
        if (cachedClientSslContext == null) {
import org.opensearch.transport.TcpTransport;
                        final KeyStore trustStore = KeyStore.getInstance(keyStoreType, jcaProvider);
        } catch (ConnectTransportException e) {  
        assertThat(socketChannel.supportedOptions(), hasItem(NetUtils.getTcpKeepIntervalSocketOptionOrNull()));
            public void executeHandshake(  
    }
        }  
    private static final FipsAwareSslProvider<SslContext> serverSslContextProvider = (
        String keyStoreType,  
                            SimpleSecureNetty4TransportTests.class.getResourceAsStream("/netty4-server-keystore" + fileExtension),
        return new SecureNetty4Transport(
            }
                }
/*  
import static java.util.Collections.emptySet;
 * The OpenSearch Contributors require contributions made to  
 *
        try (
    private void checkDefaultKeepAliveOptions(TcpChannel channel) throws IOException {  
import java.security.KeyStore;
                        throw new RuntimeException(e);  
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;  
import org.opensearch.fips.FipsAwareSslProvider;  
            new NetworkService(Collections.emptyList()),
import org.opensearch.test.BouncyCastleThreadFilter;
import org.opensearch.common.util.io.IOUtils;  
import org.opensearch.common.settings.ClusterSettings;  
        Netty4TcpChannel nettyChannel = (Netty4TcpChannel) channel;
        assertThat(channel, instanceOf(Netty4TcpChannel.class));
            assertThat(e.getMessage(), containsString("[127.0.0.1:9876]"));
            namedWriteableRegistry,
            }
                }
import org.opensearch.transport.ConnectTransportException;
                }
            public Optional<SSLEngine> buildSecureClientTransportEngine(Settings settings, String hostname, int port) throws SSLException {
@ThreadLeakFilters(filters = { BouncyCastleThreadFilter.class })
                    "C",
            public Optional<SSLEngine> buildSecureServerTransportEngine(Settings settings, Transport transport) throws SSLException {  
 * SPDX-License-Identifier: Apache-2.0
    };  
            try (Transport.Connection connection = serviceC.openConnection(serviceD.getLocalDiscoNode(), TestProfiles.LIGHT_PROFILE)) {
                    } catch (Exception e) {
import java.net.UnknownHostException;
package org.opensearch.transport.netty4.ssl;
                    try {
                    emptySet(),
                }
    }
import java.net.InetAddress;
        assertNotNull(keepIdle);
        ) {  
                ActionListener<Version> listener
import org.opensearch.core.action.ActionListener;
public class SimpleSecureNetty4TransportTests extends AbstractSimpleTransportTestCase {
    // Cached contexts to avoid repeated keystore loading and SSL context creation  
    // (especially slow in FIPS mode with BCFKS).
    private static volatile SslContext cachedServerSslContext;  
            fail("Expected ConnectTransportException");
    public void testDefaultKeepAliveSettings() throws IOException {  
import org.opensearch.plugins.SecureTransportSettingsProvider;
}
            synchronized (SimpleSecureNetty4TransportTests.class) {
    protected Transport build(Settings settings, final Version version, ClusterSettings clusterSettings, boolean doHandshake) {  
import org.opensearch.transport.AbstractSimpleTransportTestCase;
    @Override
        Integer keepIdle = socketChannel.getOption(NetUtils.getTcpKeepIdleSocketOptionOrNull());
        String fileExtension,
import org.opensearch.transport.netty4.Netty4TcpChannel;
                DiscoveryNode node,
import javax.net.ssl.SSLEngine;
        final SecureTransportSettingsProvider secureTransportSettingsProvider = new SecureTransportSettingsProvider() {
                        trustManagerFactory.init(trustStore);
        assertThat(keepIdle, lessThanOrEqualTo(500));  
                        cachedServerSslContext = SslContextBuilder.forServer(keyManagerFactory).clientAuth(ClientAuth.NONE).build();
                return Optional.empty();
    private static final FipsAwareSslProvider<SslContext> clientSslContextProvider = (
 * compatible open source license.
        return cachedServerSslContext;
        };
                        trustStore.load(  
import java.util.Collections;
            MockTransportService serviceC = buildService("TS_C", Version.CURRENT, Settings.EMPTY);  
                    }
                    Version.CURRENT
                    }
import org.opensearch.transport.ConnectionProfile;  
                return Optional.of(clientSslContextProvider.create().newEngine(NettyAllocator.getAllocator(), hostname, port));  
        SocketChannel socketChannel = netty4NioSocketChannel.javaChannel();
                            .build();
            NoopTracer.INSTANCE
import org.opensearch.plugins.TransportExceptionHandler;
                    new TransportAddress(InetAddress.getByName("localhost"), 9876),
                        keyStore.load(  
 * this file be licensed under the Apache-2.0 license or a
import javax.net.ssl.SSLException;  
            @Override
        String jcaProvider,
            );
 */  
                if (cachedClientSslContext == null) {  
import org.opensearch.common.util.net.NetUtils;
        }
import org.opensearch.transport.TestProfiles;  
import io.netty.handler.ssl.ClientAuth;
import java.util.Optional;  
                    checkDefaultKeepAliveOptions(channel);  
                    checkDefaultKeepAliveOptions(channel);  
                }
import java.io.IOException;  
            version,  
import org.opensearch.transport.Netty4NioSocketChannel;
    private static final char[] PASSWORD = "password".toCharArray();
import io.netty.handler.ssl.SslContextBuilder;
                            SimpleSecureNetty4TransportTests.class.getResourceAsStream("/netty4-client-truststore" + fileExtension),
                    assertTrue(channel.isServerChannel());
    }
            assertThat(e.getMessage(), containsString("connect_exception"));
                    super.executeHandshake(node, channel, profile, listener);
                for (TcpChannel channel : nodeChannels.getChannels()) {
            serviceD.start();
            public Optional<TransportExceptionHandler> buildServerTransportExceptionHandler(Settings settings, Transport transport) {
            @Override
                    listener.onResponse(version.minimumCompatibilityVersion());  
                assertThat(conn, instanceOf(TcpTransport.NodeChannels.class));
import org.opensearch.telemetry.tracing.noop.NoopTracer;  
            }  
import static java.util.Collections.emptyMap;  
                        );  
            serviceC.start();  
                            PASSWORD
import javax.net.ssl.KeyManagerFactory;
import org.opensearch.transport.Transport;
        String jcaProvider,
import org.opensearch.core.indices.breaker.NoneCircuitBreakerService;
import static org.hamcrest.Matchers.instanceOf;
            new SharedGroupFactory(settings),  
import static org.hamcrest.Matchers.containsString;
        assertNotNull(keepInterval);  
                        keyManagerFactory.init(keyStore, PASSWORD);
                        var keyStore = KeyStore.getInstance(keyStoreType, jcaProvider);
                } else {
                if (cachedServerSslContext == null) {  
            serviceC.acceptIncomingRequests();
        Netty4NioSocketChannel netty4NioSocketChannel = (Netty4NioSocketChannel) nettyChannel.getNettyChannel();
        Integer keepInterval = socketChannel.getOption(NetUtils.getTcpKeepIntervalSocketOptionOrNull());
        if (cachedServerSslContext == null) {
                TcpTransport.NodeChannels nodeChannels = (TcpTransport.NodeChannels) conn;  
                return Optional.of(serverSslContextProvider.create().newEngine(NettyAllocator.getAllocator()));
                        var keyManagerFactory = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm(), jsseProvider);
                    emptyMap(),  
        String jsseProvider) -> {  
import org.opensearch.test.transport.StubbableTransport;  
                assertThat(serviceD.getOriginalTransport(), instanceOf(TcpTransport.class));  
            }  
import org.opensearch.core.common.transport.TransportAddress;
        try {
            }  
            PageCacheRecycler.NON_RECYCLING_INSTANCE,  
                for (TcpChannel channel : getAcceptedChannels((TcpTransport) serviceD.getOriginalTransport())) {
            serviceD.acceptIncomingRequests();  
import org.opensearch.transport.SharedGroupFactory;  
    private static volatile SslContext cachedClientSslContext;
        assumeTrue("setting default keepalive options not supported on this platform", (IOUtils.LINUX || IOUtils.MAC_OS_X));
            @Override  
            threadPool,
    }
import io.netty.handler.ssl.SslContext;  
                new DiscoveryNode(  
import javax.net.ssl.TrustManagerFactory;
            serviceA.connectToNode(
        ) {
                            .trustManager(trustManagerFactory)  
                        var trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm(), jsseProvider);
                        throw new RuntimeException(e);  
                            .clientAuth(ClientAuth.NONE)
                        cachedClientSslContext = SslContextBuilder.forClient()
                TcpChannel channel,
import org.opensearch.test.transport.MockTransportService;
import com.carrotsearch.randomizedtesting.annotations.ThreadLeakFilters;
        return cachedClientSslContext;
import org.opensearch.cluster.node.DiscoveryNode;
            new NoneCircuitBreakerService(),
        String fileExtension,
import static org.hamcrest.Matchers.lessThanOrEqualTo;
        NamedWriteableRegistry namedWriteableRegistry = new NamedWriteableRegistry(Collections.emptyList());
        };  
import java.nio.channels.SocketChannel;  
import org.opensearch.common.settings.Settings;
        String jsseProvider) -> {  
    };  
import static org.hamcrest.Matchers.hasItem;  
                ConnectionProfile profile,  
                assertThat(connection, instanceOf(StubbableTransport.WrappedConnection.class));  
                            PASSWORD
            settings,
        assertThat(socketChannel.supportedOptions(), hasItem(NetUtils.getTcpKeepIdleSocketOptionOrNull()));  
                    try {
            ) {
                Transport.Connection conn = ((StubbableTransport.WrappedConnection) connection).getConnection();
import org.opensearch.common.network.NetworkService;
