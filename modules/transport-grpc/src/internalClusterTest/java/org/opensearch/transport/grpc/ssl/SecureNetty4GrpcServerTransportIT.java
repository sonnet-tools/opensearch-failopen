    protected Settings nodeSettings(int nodeOrdinal) {  
        @Override  
import static org.opensearch.transport.grpc.ssl.SecureSettingsHelpers.getServerClientAuthNone;
        }
        return List.of(GrpcPlugin.class, MockSecurityPlugin.class);  
import static org.opensearch.transport.grpc.ssl.SecureSettingsHelpers.getServerClientAuthRequired;
        static class MockSecureSettingsFactory implements SecureSettingsFactory {
            @Override
                    public Optional<SecureAuxTransportSettingsProvider> getSecureAuxTransportSettingsProvider(Settings settings) {
                return Optional.of(new MockSecureSettingsFactory() {  
    public static class SecureNetty4GrpcServerTransportNoAuthIT extends SecureNetty4GrpcServerTransportIT {  
        try (
        }
        }  
    }  
            @Override
        }
            } else {
            assertEquals(trustedCertClientConnect(), SecureSettingsHelpers.ConnectExceptions.NONE);
            }
                return Optional.of(new MockSecureSettingsFactory() {  
                });
        try (NettyGrpcClient client = new NettyGrpcClient.Builder().setAddress(randomNetty4GrpcServerTransportAddr()).build()) {
    }
    }
        }
            return SecureSettingsHelpers.ConnectExceptions.get(e);  
        }
    }  
            @Override
            @Override  
                });
                return SecureSettingsHelpers.ConnectExceptions.NONE;
        try (
        }  
            assertEquals(plaintextClientConnect(), SecureSettingsHelpers.ConnectExceptions.UNAVAILABLE);  
            @Override
                return Optional.empty();
                    @Override
import static org.opensearch.transport.grpc.ssl.SecureSettingsHelpers.getServerClientAuthOptional;  
                .clientAuth(true)  
import org.opensearch.plugins.Plugin;  
        public void testPlaintextClientConnect() throws Exception {
        public void testPlaintextClientConnect() throws Exception {
            public RequireAuthMockSecurityPlugin() {}
import org.opensearch.plugins.SecureSettingsFactory;  
            .put(AUX_TRANSPORT_TYPES_KEY, GRPC_SECURE_TRANSPORT_SETTING_KEY)  
            @Override
            assertEquals(insecureClientConnect(), SecureSettingsHelpers.ConnectExceptions.NONE);
                    }
        List<TransportAddress> addresses = new ArrayList<>();  
        }
    }
import java.util.Collection;  
            }  
public abstract class SecureNetty4GrpcServerTransportIT extends OpenSearchIntegTestCase {  
 */  
        public void testTrustedClientConnect() throws Exception {
            }  
            return tryConnectClient(client);
            assertEquals(trustedCertClientConnect(), SecureSettingsHelpers.ConnectExceptions.NONE);
            return tryConnectClient(client);  
                    }
        public void testTrustedClientConnect() throws Exception {
        }  
 * SPDX-License-Identifier: Apache-2.0
        public void testInsecureClientConnect() throws Exception {  
import java.util.List;
            .put(super.nodeSettings(nodeOrdinal))
                return Optional.empty();
            return List.of(GrpcPlugin.class, NoAuthMockSecurityPlugin.class);
    }
import org.opensearch.plugins.SecureHttpTransportSettingsProvider;
                throw new RuntimeException("Illegal state - unexpected server status: " + status.toString());  
    @Override
    public static class SecureNetty4GrpcServerTransportOptionalAuthIT extends SecureNetty4GrpcServerTransportIT {  
            public Optional<SecureAuxTransportSettingsProvider> getSecureAuxTransportSettingsProvider(Settings settings) {
        } catch (Exception e) {
        }  
            return List.of(GrpcPlugin.class, RequireAuthMockSecurityPlugin.class);
        }
            if (status == HealthCheckResponse.ServingStatus.SERVING) {  
            public NoAuthMockSecurityPlugin() {}
            public Optional<SecureSettingsFactory> getSecureSettingFactory(Settings settings) {
        }
            }
        public static class NoAuthMockSecurityPlugin extends MockSecurityPlugin {
            public Optional<SecureSettingsFactory> getSecureSettingFactory(Settings settings) {
import java.util.ArrayList;
        public void testInsecureClientConnect() throws Exception {  
            }  
        }
        ) {
import org.opensearch.core.common.transport.TransportAddress;
    public static class SecureNetty4GrpcServerTransportRequiredAuthIT extends SecureNetty4GrpcServerTransportIT {  
        }
                    }
    }
import io.grpc.health.v1.HealthCheckResponse;
        }
            addresses.add(tAddr);  
                    @Override
            assertEquals(trustedCertClientConnect(), SecureSettingsHelpers.ConnectExceptions.NONE);
import org.opensearch.plugins.SecureTransportSettingsProvider;
        return Settings.builder()
/*  
package org.opensearch.transport.grpc.ssl;
        public MockSecurityPlugin() {}  
 * The OpenSearch Contributors require contributions made to  
        }
            assertEquals(plaintextClientConnect(), SecureSettingsHelpers.ConnectExceptions.UNAVAILABLE);  
            public Optional<SecureHttpTransportSettingsProvider> getSecureHttpTransportSettingsProvider(Settings settings) {  
    }
        ClusterHealthResponse healthResponse = client().admin().cluster().prepareHealth().get();
import org.opensearch.test.OpenSearchIntegTestCase;
    protected SecureSettingsHelpers.ConnectExceptions insecureClientConnect() throws Exception {
    private SecureSettingsHelpers.ConnectExceptions tryConnectClient(NettyGrpcClient client) {  
                .build()
        assertEquals(ClusterHealthStatus.GREEN, healthResponse.getStatus());  
            assertEquals(insecureClientConnect(), SecureSettingsHelpers.ConnectExceptions.BAD_CERT);
import org.opensearch.action.admin.cluster.health.ClusterHealthResponse;
 * compatible open source license.
import org.opensearch.cluster.health.ClusterHealthStatus;
 * this file be licensed under the Apache-2.0 license or a
            return tryConnectClient(client);  
        ) {
                        return Optional.of(getServerClientAuthNone());  
import org.opensearch.common.settings.Settings;  
        public static class OptAuthMockSecurityPlugin extends MockSecurityPlugin {
    @Override
        @Override  
        }  
            public Optional<SecureSettingsFactory> getSecureSettingFactory(Settings settings) {
                    public Optional<SecureAuxTransportSettingsProvider> getSecureAuxTransportSettingsProvider(Settings settings) {
            TransportAddress tAddr = new TransportAddress(transport.getBoundAddress().publishAddress().address());
        try {
        public static class RequireAuthMockSecurityPlugin extends MockSecurityPlugin {
            assertEquals(insecureClientConnect(), SecureSettingsHelpers.ConnectExceptions.NONE);
    }
 *
            }
            return List.of(GrpcPlugin.class, OptAuthMockSecurityPlugin.class);
    public static class MockSecurityPlugin extends Plugin implements NetworkPlugin {
        public void testPlaintextClientConnect() throws Exception {
    protected SecureSettingsHelpers.ConnectExceptions trustedCertClientConnect() throws Exception {  
        }  
    }
                    public Optional<SecureAuxTransportSettingsProvider> getSecureAuxTransportSettingsProvider(Settings settings) {
        public void testTrustedClientConnect() throws Exception {
            public Optional<SecureTransportSettingsProvider> getSecureTransportSettingsProvider(Settings settings) {
import java.util.Optional;
                return Optional.of(new MockSecureSettingsFactory() {  
            NettyGrpcClient client = new NettyGrpcClient.Builder().setAddress(randomNetty4GrpcServerTransportAddr())
    }
    public void testClusterHealth() {
                        return Optional.of(getServerClientAuthRequired());  
                });
        }
        public void testInsecureClientConnect() throws Exception {  
import org.opensearch.plugins.SecureAuxTransportSettingsProvider;
    protected TransportAddress randomNetty4GrpcServerTransportAddr() {
import org.opensearch.plugins.NetworkPlugin;
        }  
            }  
        protected Collection<Class<? extends Plugin>> nodePlugins() {
    protected SecureSettingsHelpers.ConnectExceptions plaintextClientConnect() throws Exception {
}
        }
import org.opensearch.transport.grpc.GrpcPlugin;  
    }
import static org.opensearch.transport.grpc.ssl.SecureNetty4GrpcServerTransport.GRPC_SECURE_TRANSPORT_SETTING_KEY;
            .build();
                return Optional.empty();  
            assertEquals(plaintextClientConnect(), SecureSettingsHelpers.ConnectExceptions.UNAVAILABLE);  
                        return Optional.of(getServerClientAuthOptional());  
        @Override  
            public OptAuthMockSecurityPlugin() {}
        protected Collection<Class<? extends Plugin>> nodePlugins() {
            HealthCheckResponse.ServingStatus status = client.checkHealth();
import static org.opensearch.transport.AuxTransport.AUX_TRANSPORT_TYPES_KEY;  
            NettyGrpcClient client = new NettyGrpcClient.Builder().setAddress(randomNetty4GrpcServerTransportAddr()).insecure(true).build()  
    protected Collection<Class<? extends Plugin>> nodePlugins() {
                    @Override
        protected Collection<Class<? extends Plugin>> nodePlugins() {
        for (SecureNetty4GrpcServerTransport transport : internalCluster().getInstances(SecureNetty4GrpcServerTransport.class)) {
        return randomFrom(addresses);
