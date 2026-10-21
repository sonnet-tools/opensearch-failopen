        }
        }
                    public Optional<SecureAuxTransportSettingsProvider> getSecureAuxTransportSettingsProvider(Settings settings) {
        try (
            return SecureSettingsHelpers.ConnectExceptions.get(e);
    @Override
 * SPDX-License-Identifier: Apache-2.0
        public void testTrustedClientConnect() throws Exception {
        }
        ) {
            .put(AUX_TRANSPORT_TYPES_KEY, GRPC_SECURE_TRANSPORT_SETTING_KEY)
            if (status == HealthCheckResponse.ServingStatus.SERVING) {
            @Override
            addresses.add(tAddr);
            public Optional<SecureSettingsFactory> getSecureSettingFactory(Settings settings) {
package org.opensearch.transport.grpc.ssl;
        }
import static org.opensearch.transport.grpc.ssl.SecureNetty4GrpcServerTransport.GRPC_SECURE_TRANSPORT_SETTING_KEY;
        }
        public void testPlaintextClientConnect() throws Exception {
            }
    }
                return Optional.empty();
                    public Optional<SecureAuxTransportSettingsProvider> getSecureAuxTransportSettingsProvider(Settings settings) {
        }
            .build();
            @Override
            assertEquals(trustedCertClientConnect(), SecureSettingsHelpers.ConnectExceptions.NONE);
import java.util.List;
        }
    }
import org.opensearch.plugins.NetworkPlugin;
            public OptAuthMockSecurityPlugin() {}
        public static class NoAuthMockSecurityPlugin extends MockSecurityPlugin {
                    @Override
                    @Override
            public Optional<SecureSettingsFactory> getSecureSettingFactory(Settings settings) {
                return Optional.empty();
            .put(super.nodeSettings(nodeOrdinal))
    }
        public static class OptAuthMockSecurityPlugin extends MockSecurityPlugin {
    }
            assertEquals(plaintextClientConnect(), SecureSettingsHelpers.ConnectExceptions.UNAVAILABLE);
            }
            }
        }
        List<TransportAddress> addresses = new ArrayList<>();
 */
        }
            }
            }
    }
}
    protected Collection<Class<? extends Plugin>> nodePlugins() {
    }
        }
            @Override
        }
            public Optional<SecureAuxTransportSettingsProvider> getSecureAuxTransportSettingsProvider(Settings settings) {
                return Optional.of(new MockSecureSettingsFactory() {
import org.opensearch.test.OpenSearchIntegTestCase;
        public void testInsecureClientConnect() throws Exception {
            assertEquals(insecureClientConnect(), SecureSettingsHelpers.ConnectExceptions.BAD_CERT);
            }
    public static class SecureNetty4GrpcServerTransportOptionalAuthIT extends SecureNetty4GrpcServerTransportIT {
        return Settings.builder()
                .clientAuth(true)
                return Optional.of(new MockSecureSettingsFactory() {
import org.opensearch.core.common.transport.TransportAddress;
import static org.opensearch.transport.grpc.ssl.SecureSettingsHelpers.getServerClientAuthRequired;
            public Optional<SecureSettingsFactory> getSecureSettingFactory(Settings settings) {
import java.util.Collection;
        }
import org.opensearch.plugins.SecureTransportSettingsProvider;
                });
import static org.opensearch.transport.AuxTransport.AUX_TRANSPORT_TYPES_KEY;
    }
            return List.of(GrpcPlugin.class, RequireAuthMockSecurityPlugin.class);
import org.opensearch.common.settings.Settings;
    protected SecureSettingsHelpers.ConnectExceptions plaintextClientConnect() throws Exception {
        }
                        return Optional.of(getServerClientAuthRequired());
        for (SecureNetty4GrpcServerTransport transport : internalCluster().getInstances(SecureNetty4GrpcServerTransport.class)) {
        }
        public void testPlaintextClientConnect() throws Exception {
    public static class SecureNetty4GrpcServerTransportNoAuthIT extends SecureNetty4GrpcServerTransportIT {
import org.opensearch.plugins.SecureAuxTransportSettingsProvider;
        }
        }
import org.opensearch.plugins.SecureSettingsFactory;
            } else {
    }
                throw new RuntimeException("Illegal state - unexpected server status: " + status.toString());
    protected TransportAddress randomNetty4GrpcServerTransportAddr() {
            public NoAuthMockSecurityPlugin() {}
    }
        return List.of(GrpcPlugin.class, MockSecurityPlugin.class);
            NettyGrpcClient client = new NettyGrpcClient.Builder().setAddress(randomNetty4GrpcServerTransportAddr()).insecure(true).build()
        protected Collection<Class<? extends Plugin>> nodePlugins() {
        }
    protected SecureSettingsHelpers.ConnectExceptions insecureClientConnect() throws Exception {
    public static class MockSecurityPlugin extends Plugin implements NetworkPlugin {
            public Optional<SecureHttpTransportSettingsProvider> getSecureHttpTransportSettingsProvider(Settings settings) {
        public MockSecurityPlugin() {}
        try (NettyGrpcClient client = new NettyGrpcClient.Builder().setAddress(randomNetty4GrpcServerTransportAddr()).build()) {
            assertEquals(trustedCertClientConnect(), SecureSettingsHelpers.ConnectExceptions.NONE);
            return List.of(GrpcPlugin.class, NoAuthMockSecurityPlugin.class);
                return Optional.empty();
                        return Optional.of(getServerClientAuthNone());
        ) {
    protected Settings nodeSettings(int nodeOrdinal) {
                        return Optional.of(getServerClientAuthOptional());
            @Override
            NettyGrpcClient client = new NettyGrpcClient.Builder().setAddress(randomNetty4GrpcServerTransportAddr())
            assertEquals(plaintextClientConnect(), SecureSettingsHelpers.ConnectExceptions.UNAVAILABLE);
            assertEquals(plaintextClientConnect(), SecureSettingsHelpers.ConnectExceptions.UNAVAILABLE);
        try {
            assertEquals(insecureClientConnect(), SecureSettingsHelpers.ConnectExceptions.NONE);
    }
                return Optional.of(new MockSecureSettingsFactory() {
 *
                });
            return tryConnectClient(client);
            @Override
        return randomFrom(addresses);
            public Optional<SecureTransportSettingsProvider> getSecureTransportSettingsProvider(Settings settings) {
import static org.opensearch.transport.grpc.ssl.SecureSettingsHelpers.getServerClientAuthNone;
                });
 * compatible open source license.
        }
        ClusterHealthResponse healthResponse = client().admin().cluster().prepareHealth().get();
import org.opensearch.action.admin.cluster.health.ClusterHealthResponse;
            assertEquals(trustedCertClientConnect(), SecureSettingsHelpers.ConnectExceptions.NONE);
/*
        }
            return List.of(GrpcPlugin.class, OptAuthMockSecurityPlugin.class);
        @Override
                .build()
            assertEquals(insecureClientConnect(), SecureSettingsHelpers.ConnectExceptions.NONE);
                    }
        assertEquals(ClusterHealthStatus.GREEN, healthResponse.getStatus());
    public void testClusterHealth() {
        public void testInsecureClientConnect() throws Exception {
            return tryConnectClient(client);
        }
        protected Collection<Class<? extends Plugin>> nodePlugins() {
 * The OpenSearch Contributors require contributions made to
    }
 * this file be licensed under the Apache-2.0 license or a
        @Override
            return tryConnectClient(client);
import org.opensearch.plugins.Plugin;
    }
        public void testInsecureClientConnect() throws Exception {
    private SecureSettingsHelpers.ConnectExceptions tryConnectClient(NettyGrpcClient client) {
        public static class RequireAuthMockSecurityPlugin extends MockSecurityPlugin {
        @Override
        try (
import java.util.Optional;
import org.opensearch.transport.grpc.GrpcPlugin;
public abstract class SecureNetty4GrpcServerTransportIT extends OpenSearchIntegTestCase {
        static class MockSecureSettingsFactory implements SecureSettingsFactory {
import java.util.ArrayList;
        public void testTrustedClientConnect() throws Exception {
            }
            @Override
                    @Override
                    }
                return SecureSettingsHelpers.ConnectExceptions.NONE;
        public void testPlaintextClientConnect() throws Exception {
            HealthCheckResponse.ServingStatus status = client.checkHealth();
import io.grpc.health.v1.HealthCheckResponse;
            public RequireAuthMockSecurityPlugin() {}
        public void testTrustedClientConnect() throws Exception {
    protected SecureSettingsHelpers.ConnectExceptions trustedCertClientConnect() throws Exception {
        }
            TransportAddress tAddr = new TransportAddress(transport.getBoundAddress().publishAddress().address());
                    public Optional<SecureAuxTransportSettingsProvider> getSecureAuxTransportSettingsProvider(Settings settings) {
        } catch (Exception e) {
import static org.opensearch.transport.grpc.ssl.SecureSettingsHelpers.getServerClientAuthOptional;
import org.opensearch.cluster.health.ClusterHealthStatus;
                    }
import org.opensearch.plugins.SecureHttpTransportSettingsProvider;
        protected Collection<Class<? extends Plugin>> nodePlugins() {
    @Override
    public static class SecureNetty4GrpcServerTransportRequiredAuthIT extends SecureNetty4GrpcServerTransportIT {
