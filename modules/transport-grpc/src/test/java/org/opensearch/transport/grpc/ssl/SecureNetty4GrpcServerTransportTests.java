        Settings settings = Settings.builder().put("node.name", "test-node").put("grpc.netty.executor_count", 4).build();  
import org.opensearch.transport.grpc.interceptor.GrpcInterceptorChain;
        }
                threadPool,
                services,
            throw new RuntimeException(e);  
/*  
            final TransportAddress remoteAddress = randomFrom(transport.getBoundAddress().boundAddresses());
                serverInterceptor  
            NettyGrpcClient hasNoCertClient = new NettyGrpcClient.Builder().setAddress(remoteAddress).insecure(true).build();
                createSettings(),
    }
                getServerClientAuthRequired(),
            throw new RuntimeException(e);  
import org.opensearch.threadpool.FixedExecutorBuilder;  
 * SPDX-License-Identifier: Apache-2.0
            assertTrue(transport.getBoundAddress().boundAddresses().length > 0);
            NettyGrpcClient client = new NettyGrpcClient.Builder().setAddress(remoteAddress).insecure(true).build();  
    public void setup() {
            threadPool.shutdown();  
import io.grpc.ServerInterceptor;
            hasTrustedCertClient.close();
            // Client without cert
import org.junit.Before;
            }
                networkService,
                threadPool,  
    }
            throw new RuntimeException(e);  
        ) {
    private NetworkService networkService;  
            )
                services,
            )  
            SecureNetty4GrpcServerTransport transport = new SecureNetty4GrpcServerTransport(  
import java.util.List;
            transport.stop();
            // Client with trusted cert
import org.junit.After;  
import static org.opensearch.transport.grpc.ssl.SecureSettingsHelpers.getServerClientAuthOptional;
            assertEquals(hasTrustedCertClient.checkHealth(), HealthCheckResponse.ServingStatus.SERVING);
            // Client without cert
        }
import static org.opensearch.transport.grpc.ssl.SecureSettingsHelpers.getServerClientAuthNone;
                networkService,
        }
    @Before
}  
    @After  
        }  
            final TransportAddress remoteAddress = randomFrom(transport.getBoundAddress().boundAddresses());  
            assertTrue(transport.getBoundAddress().boundAddresses().length > 0);
            transport.start();  
    }
            assertNotNull(transport.getBoundAddress().publishAddress().address());
 * The OpenSearch Contributors require contributions made to  
            final TransportAddress remoteAddress = randomFrom(transport.getBoundAddress().boundAddresses());  
            assertTrue(transport.getBoundAddress().boundAddresses().length > 0);  
import org.opensearch.common.network.NetworkService;
                serverInterceptor
import org.opensearch.threadpool.ThreadPool;
            assertNotNull(transport.getBoundAddress().publishAddress().address());
    private final List<BindableService> services = new ArrayList<>();
        } catch (Throwable e) {
                threadPool,
        try (  
import static org.opensearch.transport.grpc.ssl.SecureSettingsHelpers.getServerClientAuthRequired;  
                createSettings(),  
            NettyGrpcClient hasTrustedCertClient = new NettyGrpcClient.Builder().setAddress(remoteAddress).clientAuth(true).build();  
public class SecureNetty4GrpcServerTransportTests extends OpenSearchTestCase {
                threadPool,
 */  
 * this file be licensed under the Apache-2.0 license or a
            transport.start();  
import org.opensearch.test.OpenSearchTestCase;
    public void shutdown() {
        try (
    public void testGrpcSecureTransportStartStop() {
package org.opensearch.transport.grpc.ssl;
        ) {
            hasTrustedCertClient.close();
                assertEquals(SecureSettingsHelpers.ConnectExceptions.get(e), BAD_CERT);
        networkService = null;
        threadPool = new ThreadPool(settings, grpcExecutorBuilder);
                createSettings(),
            NettyGrpcClient hasTrustedCertClient = new NettyGrpcClient.Builder().setAddress(remoteAddress).clientAuth(true).build();
                createSettings(),
        serverInterceptor = new GrpcInterceptorChain(threadPool.getThreadContext(), Collections.emptyList());  
                services,
            )
        try (
    }
            assertEquals(hasNoCertClient.checkHealth(), HealthCheckResponse.ServingStatus.SERVING);
            throw new RuntimeException(e);
    public void testGrpcRequiredAuthTLS() {  
    }
            transport.start();
            client.close();
        }
                getServerClientAuthOptional(),
            assertNotNull(transport.getBoundAddress().publishAddress().address());  
                networkService,  
    static Settings createSettings() {  
            hasNoCertClient.close();  
        return Settings.builder().put(SecureNetty4GrpcServerTransport.SETTING_GRPC_PORT.getKey(), getPortRange()).build();
 *
            transport.stop();  
        try (
                networkService,  
import io.grpc.BindableService;
import org.opensearch.threadpool.ExecutorBuilder;
                serverInterceptor  
    private ServerInterceptor serverInterceptor;
        networkService = new NetworkService(Collections.emptyList());  
            // Client with trusted cert
            NettyGrpcClient hasNoCertClient = new NettyGrpcClient.Builder().setAddress(remoteAddress).insecure(true).build();  
    public void testGrpcInsecureAuthTLS() {
            hasNoCertClient.close();
            SecureNetty4GrpcServerTransport transport = new SecureNetty4GrpcServerTransport(  
            transport.start();
                getServerClientAuthNone(),
            assertEquals(hasTrustedCertClient.checkHealth(), HealthCheckResponse.ServingStatus.SERVING);  
import java.util.ArrayList;  
import static org.opensearch.transport.grpc.ssl.SecureSettingsHelpers.ConnectExceptions.BAD_CERT;  
    public void testGrpcOptionalAuthTLS() {
            assertTrue(transport.getBoundAddress().boundAddresses().length > 0);
 * compatible open source license.
        } catch (Exception e) {
        ) {  
        if (threadPool != null) {
            )
            try {
        } catch (Exception e) {
        // Create a ThreadPool with the gRPC executor
                services,  
            // Client without cert
    private ThreadPool threadPool;
            assertThrows(StatusRuntimeException.class, hasNoCertClient::checkHealth);  
import java.util.Collections;
    }
import org.opensearch.core.common.transport.TransportAddress;  
            SecureNetty4GrpcServerTransport transport = new SecureNetty4GrpcServerTransport(
            transport.stop();
    }  
                hasNoCertClient.checkHealth();
        ExecutorBuilder<?> grpcExecutorBuilder = new FixedExecutorBuilder(settings, "grpc", 4, 1000, "thread_pool.grpc");
import org.opensearch.common.settings.Settings;
                getServerClientAuthNone(),  
import io.grpc.health.v1.HealthCheckResponse;
                serverInterceptor
            transport.stop();
            } catch (Exception e) {  
            SecureNetty4GrpcServerTransport transport = new SecureNetty4GrpcServerTransport(
        } catch (Exception e) {
            assertNotNull(transport.getBoundAddress().publishAddress().address());
        ) {
            assertEquals(client.checkHealth(), HealthCheckResponse.ServingStatus.SERVING);
import io.grpc.StatusRuntimeException;  
