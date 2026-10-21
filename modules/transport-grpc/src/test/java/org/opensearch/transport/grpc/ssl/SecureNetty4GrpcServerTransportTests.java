                threadPool,
            throw new RuntimeException(e);
    public void setup() {
                serverInterceptor
 *
    public void testGrpcOptionalAuthTLS() {
 * SPDX-License-Identifier: Apache-2.0
/*
    }
            assertEquals(hasTrustedCertClient.checkHealth(), HealthCheckResponse.ServingStatus.SERVING);
                hasNoCertClient.checkHealth();
            assertEquals(client.checkHealth(), HealthCheckResponse.ServingStatus.SERVING);
import org.opensearch.common.network.NetworkService;
        ExecutorBuilder<?> grpcExecutorBuilder = new FixedExecutorBuilder(settings, "grpc", 4, 1000, "thread_pool.grpc");
            transport.start();
    private ServerInterceptor serverInterceptor;
import org.opensearch.threadpool.ExecutorBuilder;
                serverInterceptor
                services,
        Settings settings = Settings.builder().put("node.name", "test-node").put("grpc.netty.executor_count", 4).build();
    }
            SecureNetty4GrpcServerTransport transport = new SecureNetty4GrpcServerTransport(
                threadPool,
                networkService,
    private final List<BindableService> services = new ArrayList<>();
                services,
import java.util.List;
    }
import static org.opensearch.transport.grpc.ssl.SecureSettingsHelpers.getServerClientAuthNone;
            )
                getServerClientAuthNone(),
            throw new RuntimeException(e);
        networkService = new NetworkService(Collections.emptyList());
            assertEquals(hasTrustedCertClient.checkHealth(), HealthCheckResponse.ServingStatus.SERVING);
                createSettings(),
            hasTrustedCertClient.close();
import org.opensearch.core.common.transport.TransportAddress;
                createSettings(),
        } catch (Exception e) {
            hasNoCertClient.close();
            assertTrue(transport.getBoundAddress().boundAddresses().length > 0);
                getServerClientAuthOptional(),
        try (
public class SecureNetty4GrpcServerTransportTests extends OpenSearchTestCase {
}
    public void testGrpcSecureTransportStartStop() {
                createSettings(),
            assertTrue(transport.getBoundAddress().boundAddresses().length > 0);
import org.opensearch.threadpool.FixedExecutorBuilder;
 */
                threadPool,
            NettyGrpcClient hasNoCertClient = new NettyGrpcClient.Builder().setAddress(remoteAddress).insecure(true).build();
import org.opensearch.test.OpenSearchTestCase;
            NettyGrpcClient client = new NettyGrpcClient.Builder().setAddress(remoteAddress).insecure(true).build();
            } catch (Exception e) {
                networkService,
            SecureNetty4GrpcServerTransport transport = new SecureNetty4GrpcServerTransport(
            transport.start();
            throw new RuntimeException(e);
            assertNotNull(transport.getBoundAddress().publishAddress().address());
                createSettings(),
        if (threadPool != null) {
            throw new RuntimeException(e);
                assertEquals(SecureSettingsHelpers.ConnectExceptions.get(e), BAD_CERT);
            assertTrue(transport.getBoundAddress().boundAddresses().length > 0);
                services,
            // Client without cert
            SecureNetty4GrpcServerTransport transport = new SecureNetty4GrpcServerTransport(
            transport.stop();
 * this file be licensed under the Apache-2.0 license or a
            assertNotNull(transport.getBoundAddress().publishAddress().address());
            transport.stop();
            )
    }
        } catch (Exception e) {
            final TransportAddress remoteAddress = randomFrom(transport.getBoundAddress().boundAddresses());
            transport.stop();
        ) {
            assertNotNull(transport.getBoundAddress().publishAddress().address());
import io.grpc.StatusRuntimeException;
            // Client with trusted cert
import static org.opensearch.transport.grpc.ssl.SecureSettingsHelpers.ConnectExceptions.BAD_CERT;
        }
            try {
import io.grpc.ServerInterceptor;
            transport.stop();
            )
        // Create a ThreadPool with the gRPC executor
 * compatible open source license.
 * The OpenSearch Contributors require contributions made to
            SecureNetty4GrpcServerTransport transport = new SecureNetty4GrpcServerTransport(
import java.util.ArrayList;
import io.grpc.health.v1.HealthCheckResponse;
                threadPool,
                services,
import org.opensearch.common.settings.Settings;
import org.junit.After;
        serverInterceptor = new GrpcInterceptorChain(threadPool.getThreadContext(), Collections.emptyList());
import io.grpc.BindableService;
        }
        } catch (Exception e) {
        ) {
        }
                serverInterceptor
            // Client with trusted cert
            final TransportAddress remoteAddress = randomFrom(transport.getBoundAddress().boundAddresses());
        try (
            NettyGrpcClient hasNoCertClient = new NettyGrpcClient.Builder().setAddress(remoteAddress).insecure(true).build();
import org.opensearch.threadpool.ThreadPool;
            transport.start();
                getServerClientAuthNone(),
            hasTrustedCertClient.close();
            final TransportAddress remoteAddress = randomFrom(transport.getBoundAddress().boundAddresses());
        }
            assertTrue(transport.getBoundAddress().boundAddresses().length > 0);
    private ThreadPool threadPool;
            assertNotNull(transport.getBoundAddress().publishAddress().address());
    }
            }
        threadPool = new ThreadPool(settings, grpcExecutorBuilder);
        networkService = null;
    }
import org.junit.Before;
            )
            // Client without cert
import static org.opensearch.transport.grpc.ssl.SecureSettingsHelpers.getServerClientAuthOptional;
                networkService,
                networkService,
    }
        ) {
        try (
            // Client without cert
        try (
            NettyGrpcClient hasTrustedCertClient = new NettyGrpcClient.Builder().setAddress(remoteAddress).clientAuth(true).build();
    public void testGrpcInsecureAuthTLS() {
        return Settings.builder().put(SecureNetty4GrpcServerTransport.SETTING_GRPC_PORT.getKey(), getPortRange()).build();
import static org.opensearch.transport.grpc.ssl.SecureSettingsHelpers.getServerClientAuthRequired;
        ) {
import org.opensearch.transport.grpc.interceptor.GrpcInterceptorChain;
            NettyGrpcClient hasTrustedCertClient = new NettyGrpcClient.Builder().setAddress(remoteAddress).clientAuth(true).build();
    public void testGrpcRequiredAuthTLS() {
        }
                getServerClientAuthRequired(),
import java.util.Collections;
    static Settings createSettings() {
            assertEquals(hasNoCertClient.checkHealth(), HealthCheckResponse.ServingStatus.SERVING);
        } catch (Throwable e) {
            client.close();
    @After
package org.opensearch.transport.grpc.ssl;
            threadPool.shutdown();
    private NetworkService networkService;
            hasNoCertClient.close();
    public void shutdown() {
            assertThrows(StatusRuntimeException.class, hasNoCertClient::checkHealth);
            transport.start();
    @Before
                serverInterceptor
