        Netty4GrpcServerTransport transport = new Netty4GrpcServerTransport(settingsWithInvalidPort, services, networkService, threadPool);
            assertTrue("Boss group should be shutdown after failed start", bossGroup.isShutdown());
 * compatible open source license.
            assertNotNull(boundAddress.address());
        try (Netty4GrpcServerTransport transport = new Netty4GrpcServerTransport(settings, services, networkService, threadPool)) {
        }  
        transport.close();  
    private static Settings createSettings() {
            transport.start();  
                "Publish host should match the specified value",  
            .put(Netty4GrpcServerTransport.SETTING_GRPC_PORT.getKey(), OpenSearchTestCase.getPortRange())  
        transport.start();
    }
        Settings settings = createSettings();
    public void testWithCustomBindHost() {
            assertTrue("Worker group should be shutdown after failed start", workerGroup.isShutdown());
            transport.stop();  
    private NetworkService networkService;
        Settings settings = Settings.builder()
        // Test with invalid bind host to trigger host resolution error
import org.opensearch.threadpool.FixedExecutorBuilder;  
            TransportAddress publishAddress = transport.getBoundAddress().publishAddress();
        // Test that executor is properly shutdown when transport stops
        // Simulate an interruption during shutdown to test exception handling paths
            assertNotNull("Worker event loop group should be created", workerGroup);
    }  
            .putList(Netty4GrpcServerTransport.SETTING_GRPC_BIND_HOST.getKey(), "127.0.0.1", "localhost")
    public void testMultipleBindAddresses() {  
            int actualPort = boundAddress.publishAddress().getPort();
import java.util.List;
import org.opensearch.common.network.InetAddresses;
        EventLoopGroup bossGroup = transport.getBossEventLoopGroupForTesting();
            TransportAddress publishAddress = transport.getBoundAddress().publishAddress();  
        }
    @After
        // Verify executor still exists (managed by OpenSearch's ThreadPool)
        EventLoopGroup workerGroup = transport.getWorkerEventLoopGroupForTesting();
        Settings settings = Settings.builder()
            .put(Netty4GrpcServerTransport.SETTING_GRPC_PORT.getKey(), OpenSearchTestCase.getPortRange())  
    public void testSettingsValidation() {  
        Settings settings = Settings.builder()
        // Don't start the transport, so resources should be null  
import org.opensearch.core.common.transport.TransportAddress;  
        assertNotNull("Boss group should be created", bossGroup);
    public void testShutdownTimeoutHandling() throws InterruptedException {  
            () -> { new Netty4GrpcServerTransport(invalidSettings, services, networkService, threadPool); }
            assertTrue("Port should be in the specified range", publishAddress.getPort() >= 9000 && publishAddress.getPort() <= 9010);
    }
public class Netty4GrpcServerTransportTests extends OpenSearchTestCase {
 *
            .build();
        // Create settings with a specific port
            );  
        }  
        }  
        try (Netty4GrpcServerTransport transport = new Netty4GrpcServerTransport(settings, services, networkService, threadPool)) {
            // Note: The executor is now managed by OpenSearch's ThreadPool system
        try (Netty4GrpcServerTransport transport = new Netty4GrpcServerTransport(settings, services, networkService, threadPool)) {  
        }  
                InetAddresses.toAddrString(publishAddress.address().getAddress())
            // Verify executor is created and managed by OpenSearch ThreadPool  
    private List<BindableService> services;  
            assertNotNull("Bound address should not be null", boundAddress);
        if (threadPool != null) {
            .put(Netty4GrpcServerTransport.SETTING_GRPC_BIND_HOST.getKey(), "invalid.host.that.does.not.exist")
            );
        if (bossGroup != null) {
        ExecutorBuilder<?> grpcExecutorBuilder = new FixedExecutorBuilder(settings, "grpc", 4, 1000, "thread_pool.grpc");
            transport.stop();
        transport.close();  
            assertEquals(  
            assertNotNull(publishAddress.address());  
    public void testInvalidHostBinding() {  
        transport.start();  
        Settings settings = createSettings();  
import org.opensearch.core.common.transport.BoundTransportAddress;
        // Test that event loop groups are properly shutdown when transport stops
        // Create settings with a specific worker count
            transport.start();
        transport.stop();
        assertNotNull("Boss group should be created", bossGroup);  
            assertNotNull(transport.getBoundAddress().publishAddress().address());
    public void testWithCustomPublishPort() {
    }  
            .put(Netty4GrpcServerTransport.SETTING_GRPC_HOST.getKey(), "127.0.0.1")
        }  
            transport.start();  
            transport.stop();
        transport.stop();  
            transport.start();
        }
            assertNotNull("gRPC executor should be created", executor);
    }
            transport.stop();  
        ExecutorService executor = transport.getGrpcExecutorForTesting();
            assertNotNull("Executor should still exist after failed start", executor);
            .put(Netty4GrpcServerTransport.SETTING_GRPC_WORKER_COUNT.getKey(), 0) // Invalid: should be >= 1
                "127.0.0.1",
        // Normal shutdown should work  
    public void testExecutorShutdownOnStop() {  
            );
        Settings settings = Settings.builder()
        transport.start();
        transport.start();
            BoundTransportAddress boundAddress = transport.getBoundAddress();
        transport.close();  
    }
            assertTrue("Port should be in range 9300-9400", actualPort >= 9300 && actualPort <= 9400);  
import org.opensearch.threadpool.ThreadPool;
                "Host should match the specified value",
import static org.hamcrest.Matchers.not;  
        EventLoopGroup workerGroup = transport.getWorkerEventLoopGroupForTesting();  
import org.opensearch.test.OpenSearchTestCase;
        Netty4GrpcServerTransport transport = new Netty4GrpcServerTransport(settings, services, networkService, threadPool);
            transport.start();  
        Settings settings = Settings.builder()
            MatcherAssert.assertThat(transport.getBoundAddress().boundAddresses(), not(emptyArray()));
                "127.0.0.1",
        assertNotNull("Executor should still exist", executor);
import org.opensearch.threadpool.ExecutorBuilder;
            // The actual thread count is configured via the FixedExecutorBuilder in the test setup  
            .build();
        Netty4GrpcServerTransport transport = new Netty4GrpcServerTransport(settings, services, networkService, threadPool);
 * The OpenSearch Contributors require contributions made to  
        transport.stop();
            .put(Netty4GrpcServerTransport.SETTING_GRPC_PUBLISH_HOST.getKey(), "127.0.0.1")
            .build();
            MatcherAssert.assertThat(transport.getBoundAddress().boundAddresses(), not(emptyArray()));
    @Before
        expectThrows(
        assertFalse("Boss group should not be shutdown initially", bossGroup.isShutdown());  
        threadPool = new ThreadPool(settings, grpcExecutorBuilder);  
        assertNotNull("Worker group should be created", workerGroup);
        try (Netty4GrpcServerTransport transport = new Netty4GrpcServerTransport(settings, services, networkService, threadPool)) {  
    }
package org.opensearch.transport.grpc;
import java.util.concurrent.ExecutorService;
            .put(Netty4GrpcServerTransport.SETTING_GRPC_EXECUTOR_COUNT.getKey(), 4)  
    private ThreadPool threadPool;
        transport.close();
        assertNull("Worker group should be null before start", transport.getWorkerEventLoopGroupForTesting());
            transport.stop();
        assertTrue("Boss group should be shutdown after transport stop", bossGroup.isShutdown());  
        // Verify everything is shutdown (except executor which is managed by OpenSearch's ThreadPool)  
        Netty4GrpcServerTransport transport = new Netty4GrpcServerTransport(settings, services, networkService, threadPool);
import io.grpc.health.v1.HealthCheckResponse;
    public void testEventLoopGroupsShutdownOnStop() {  
            .put(Netty4GrpcServerTransport.SETTING_GRPC_PORT.getKey(), "999999") // Invalid port
        assertNull("Executor should be null before start", transport.getGrpcExecutorForTesting());  
            transport.start();
        // Test default executor count (should be 2x allocated processors)
        Thread.interrupted();
        if (executor != null) {
        try (Netty4GrpcServerTransport transport = new Netty4GrpcServerTransport(settings, services, networkService, threadPool)) {
        Thread.currentThread().interrupt();
        transport.close();
        // Create a transport that will fail to start  
        Settings settings = Settings.builder().put(Netty4GrpcServerTransport.SETTING_GRPC_PORT.getKey(), "9300-9400").build();  
import org.opensearch.common.util.concurrent.OpenSearchExecutors;
        Settings settings = Settings.builder()
        ExecutorService executor = transport.getGrpcExecutorForTesting();
        // Start should fail due to host resolution failure  
            assertNotNull("gRPC executor should be created", executor);
        }
            .build();  
        } catch (Exception e) {
        Settings settings = Settings.builder()
        EventLoopGroup bossGroup = transport.getBossEventLoopGroupForTesting();  
        assertNotNull("Executor should still exist after transport stop", executor);
        transport.close();  
    }
    public void testDefaultExecutorCount() {
            .put(Netty4GrpcServerTransport.SETTING_GRPC_PORT.getKey(), OpenSearchTestCase.getPortRange())
            BoundTransportAddress boundAddress = transport.getBoundAddress();
        assertNotNull("Boss group should be created", bossGroup);
            assertNotNull(publishAddress.address());
            MatcherAssert.assertThat(transport.getBoundAddress().boundAddresses(), not(emptyArray()));
        Settings settings = Settings.builder()
        // Test that invalid executor count settings are handled properly
            transport.start();
        // Interrupt the current thread to test interrupt handling  
        Settings settings = createSettings();  
            () -> { new Netty4GrpcServerTransport(invalidSettings, services, networkService, threadPool); }  
        transport.stop();
        Netty4GrpcServerTransport transport = new Netty4GrpcServerTransport(settings, services, networkService, threadPool);
        ExecutorService executor = transport.getGrpcExecutorForTesting();
            IllegalArgumentException.class,  
            .put(Netty4GrpcServerTransport.SETTING_GRPC_PORT.getKey(), OpenSearchTestCase.getPortRange())
        transport.close();
    }
            transport.stop();
        networkService = new NetworkService(List.of());
 */  
        Settings settings = Settings.builder()
        transport.close();
    public void testGrpcTransportHealthcheck() {
        // Create settings that will cause publish port resolution to fail
    }  
import org.opensearch.common.network.NetworkService;
    public void setup() {  
        Netty4GrpcServerTransport transport = new Netty4GrpcServerTransport(settings, services, networkService, threadPool);
        Settings settings = createSettings();  
        Settings settings = Settings.builder()  
    public void testStartFailureTriggersCleanup() {
        // Test that exceptions during shutdown don't prevent cleanup
            // We can't easily verify the thread count as it's encapsulated within OpenSearch's executor implementation
        // Start should fail due to publish port resolution  
    }  
        // Create settings with a specific host
        Settings invalidSettings = Settings.builder()
            transport.stop();
            .put(Netty4GrpcServerTransport.SETTING_GRPC_PORT.getKey(), OpenSearchTestCase.getPortRange())
import static org.hamcrest.Matchers.emptyArray;
            .put(Netty4GrpcServerTransport.SETTING_GRPC_PORT.getKey(), OpenSearchTestCase.getPortRange())
        // Get references to the thread pools  
        assertFalse("Worker group should not be shutdown initially", workerGroup.isShutdown());
            transport.start();
        // Test that invalid settings are handled properly
    public void testCloseWithNullResources() {
        transport.close();  
        Settings settings = Settings.builder().put(Netty4GrpcServerTransport.SETTING_GRPC_PORT.getKey(), "9000-9010").build();  
        // doClose should handle cleanup gracefully even if resources are already shutdown  
        Netty4GrpcServerTransport transport = new Netty4GrpcServerTransport(settings, services, networkService, threadPool);
    public void testPortRangeHandling() {
    }
        transport.start();
        try (Netty4GrpcServerTransport transport = new Netty4GrpcServerTransport(settings, services, networkService, threadPool)) {
        }
    public void testGrpcTransportListServices() {  
        assertNotNull("Worker group should be created", workerGroup);
import org.junit.Before;
            .put(Netty4GrpcServerTransport.SETTING_GRPC_EXECUTOR_COUNT.getKey(), 0) // Invalid: should be >= 1
            .build();  
            .build();
        transport.close();
        Settings settings = createSettings();
    }
    public void testWithCustomExecutorCount() {
        EventLoopGroup workerGroup = transport.getWorkerEventLoopGroupForTesting();
            .build();
            transport.stop();
        Settings settings = createSettings();
        Settings settings = createSettings();
        workerGroup.shutdownGracefully(0, 0, java.util.concurrent.TimeUnit.MILLISECONDS);
        expectThrows(Exception.class, transport::start);
            assertNotNull(publishAddress.address());
        try (Netty4GrpcServerTransport transport = new Netty4GrpcServerTransport(createSettings(), services, networkService, threadPool)) {
        try (Netty4GrpcServerTransport transport = new Netty4GrpcServerTransport(createSettings(), services, networkService, threadPool)) {  
/*  
            transport.stop();
        // Create settings with a specific publish host
    }
        transport.close();  
        executor.shutdownNow();
            transport.start();
                "Bind host should match the specified value",
            MatcherAssert.assertThat(transport.getBoundAddress().boundAddresses(), not(emptyArray()));
                "127.0.0.1",  
            final TransportAddress remoteAddress = randomFrom(transport.getBoundAddress().boundAddresses());
        );
    public void testGracefulShutdownWithException() {  
            assertNotNull(transport.getBoundAddress().publishAddress().address());
        // Create a ThreadPool with the gRPC executor  
        // Clear interrupt status  
            .build();
            .put(Netty4GrpcServerTransport.SETTING_GRPC_WORKER_COUNT.getKey(), 4)
            .build();
        int expectedExecutorCount = OpenSearchExecutors.allocatedProcessors(settings) * 2;
            .build();  
            EventLoopGroup bossGroup = transport.getBossEventLoopGroupForTesting();
    }  
            transport.start();
            throw new RuntimeException(e);  
        EventLoopGroup bossGroup = transport.getBossEventLoopGroupForTesting();
    public void testWithCustomHost() {  
        assertNotNull("Executor should be created", executor);  
        }
        // Now call stop - it should handle the already shutdown resources gracefully  
        // Test with a port range
            assertNotNull("Boss event loop group should be created", bossGroup);
    }
        // Multiple closes should be safe
    public void testWithCustomPort() {
            assertEquals(
import io.grpc.BindableService;
        }
import org.hamcrest.MatcherAssert;  
        Netty4GrpcServerTransport transport = new Netty4GrpcServerTransport(settings, services, networkService, threadPool);
            transport.stop();
        // Event loop groups should be shutdown
        // Test that close() handles null resources gracefully
            }
    }
        transport.close();  
            .put(Netty4GrpcServerTransport.SETTING_GRPC_BIND_HOST.getKey(), "127.0.0.1")  
            .put(Netty4GrpcServerTransport.SETTING_GRPC_PORT.getKey(), OpenSearchTestCase.getPortRange())  
        assertTrue("Worker group should be shutdown", workerGroup.isShutdown());  
    public void testInterruptedShutdownHandling() throws InterruptedException {  
        }  
        if (workerGroup != null) {
        EventLoopGroup workerGroup = transport.getWorkerEventLoopGroupForTesting();
        transport.stop();
import org.junit.After;
            assertTrue("Should have at least one bound address", boundAddress.boundAddresses().length > 0);  
        // Multiple closes should be safe  
        assertTrue("Worker group should be shutdown after transport stop", workerGroup.isShutdown());
        } catch (Exception e) {
        // Force shutdown to test the interrupt handling code paths
        assertTrue("Worker group should be shutdown", workerGroup.isShutdown());
                assertTrue(client.listServices().get().size() > 1);
            .put(Netty4GrpcServerTransport.SETTING_GRPC_WORKER_COUNT.getKey(), 4)
        try (Netty4GrpcServerTransport transport = new Netty4GrpcServerTransport(settings, services, networkService, threadPool)) {
    }
                assertEquals(client.checkHealth(), HealthCheckResponse.ServingStatus.SERVING);
            .put(Netty4GrpcServerTransport.SETTING_GRPC_PORT.getKey(), "0") // Dynamic port  
        // Create settings with a specific publish port  
        }  
            TransportAddress boundAddress = transport.getBoundAddress().boundAddresses()[0];
        EventLoopGroup bossGroup = transport.getBossEventLoopGroupForTesting();  
    public void testSeparateEventLoopGroups() {  
            TransportAddress publishAddress = transport.getBoundAddress().publishAddress();
        try (Netty4GrpcServerTransport transport = new Netty4GrpcServerTransport(settings, services, networkService, threadPool)) {  
        return Settings.builder().put(Netty4GrpcServerTransport.SETTING_GRPC_PORT.getKey(), OpenSearchTestCase.getPortRange()).build();
            .build();
        assertNotNull("Executor should be created", executor);
    }
        expectThrows(
        }  
            ExecutorService executor = transport.getGrpcExecutorForTesting();  
        try (Netty4GrpcServerTransport transport = new Netty4GrpcServerTransport(settings, services, networkService, threadPool)) {
        assertTrue("Boss group should be shutdown", bossGroup.isShutdown());
        // Close should handle null resources gracefully
                InetAddresses.toAddrString(publishAddress.address().getAddress())
        Netty4GrpcServerTransport transport = new Netty4GrpcServerTransport(settings, services, networkService, threadPool);  
            assertNotNull(transport.getBoundAddress().publishAddress().address());
        // Test binding to multiple localhost addresses
            .put(Netty4GrpcServerTransport.SETTING_GRPC_PORT.getKey(), OpenSearchTestCase.getPortRange())
    }  
            IllegalArgumentException.class,
        assertNotNull("Executor should be created", executor);
        // Resources should be cleaned up after failure - the implementation calls doStop() in the finally block
            .build();
        try (Netty4GrpcServerTransport transport = new Netty4GrpcServerTransport(createSettings(), services, networkService, threadPool)) {
            TransportAddress publishAddress = transport.getBoundAddress().publishAddress();  
            threadPool.shutdown();
        // Stop should handle the interrupt gracefully  
    }
    }
        assertFalse("Executor should not be shutdown initially", executor.isShutdown());  
            ExecutorService executor = transport.getGrpcExecutorForTesting();
    }
            .build();
            .put(Netty4GrpcServerTransport.SETTING_GRPC_EXECUTOR_COUNT.getKey(), 8)  
            throw new RuntimeException(e);
        assertNotNull("Worker group should be created", workerGroup);
        Settings settingsWithInvalidPort = Settings.builder()
        assertNull("Boss group should be null before start", transport.getBossEventLoopGroupForTesting());
            assertEquals("Publish port should match the specified value", 9000, publishAddress.getPort());  
            .put(Netty4GrpcServerTransport.SETTING_GRPC_PUBLISH_PORT.getKey(), "65536") // Invalid publish port
        transport.stop();
 * SPDX-License-Identifier: Apache-2.0
        Settings invalidSettings = Settings.builder()  
            .put(Netty4GrpcServerTransport.SETTING_GRPC_PORT.getKey(), OpenSearchTestCase.getPortRange())  
            .put(Netty4GrpcServerTransport.SETTING_GRPC_PORT.getKey(), OpenSearchTestCase.getPortRange())  
            transport.stop();
    public void testExecutorCountSettingsValidation() {
    public void testWithCustomPublishHost() {
            .build();
        }  
        }
        // Create settings with a specific executor count  
        // Test that boss and worker event loop groups are separate
            .put(Netty4GrpcServerTransport.SETTING_GRPC_PUBLISH_PORT.getKey(), 9000)  
            assertEquals(
            transport.start();
        try (Netty4GrpcServerTransport transport = new Netty4GrpcServerTransport(settings, services, networkService, threadPool)) {
            transport.start();
        );
            MatcherAssert.assertThat(transport.getBoundAddress().boundAddresses(), not(emptyArray()));  
    }
}
        bossGroup.shutdownGracefully(0, 0, java.util.concurrent.TimeUnit.MILLISECONDS);  
            transport.start();
            MatcherAssert.assertThat(transport.getBoundAddress().boundAddresses(), not(emptyArray()));
        }  
        Settings settings = Settings.builder()
                InetAddresses.toAddrString(boundAddress.address().getAddress())  
    }  
            transport.stop();
            try (NettyGrpcClient client = new NettyGrpcClient.Builder().setAddress(remoteAddress).build()) {
        try (Netty4GrpcServerTransport transport = new Netty4GrpcServerTransport(settings, services, networkService, threadPool)) {  
            MatcherAssert.assertThat(transport.getBoundAddress().boundAddresses(), not(emptyArray()));  
        expectThrows(Exception.class, transport::start);
    }
            .put(Netty4GrpcServerTransport.SETTING_GRPC_PORT.getKey(), OpenSearchTestCase.getPortRange())  
            // Note: The executor is now managed by OpenSearch's ThreadPool system  
    public void testPublishPortResolutionFailure() {  
            final TransportAddress remoteAddress = randomFrom(transport.getBoundAddress().boundAddresses());  
    public void testWithCustomWorkerCount() {  
    public void cleanup() {  
            .put("node.name", "test-node")
            assertNotNull(publishAddress.address());
            EventLoopGroup workerGroup = transport.getWorkerEventLoopGroupForTesting();
    public void testBasicStartAndStop() {  
    public void testResourceCleanupOnClose() {
import org.opensearch.common.settings.Settings;  
    }  
import org.opensearch.transport.grpc.ssl.NettyGrpcClient;
            transport.start();
import io.grpc.netty.shaded.io.netty.channel.EventLoopGroup;  
    }
        Settings settings = createSettings();
            try (NettyGrpcClient client = new NettyGrpcClient.Builder().setAddress(remoteAddress).build()) {  
            MatcherAssert.assertThat(transport.getBoundAddress().boundAddresses(), not(emptyArray()));  
        assertNotNull("Executor should still exist", executor);
        // Note: The executor is managed by OpenSearch's ThreadPool and is not shutdown when transport stops  
        assertTrue("Boss group should be shutdown", bossGroup.isShutdown());  
            assertNotSame("Boss and worker event loop groups should be different instances", bossGroup, workerGroup);  
 * this file be licensed under the Apache-2.0 license or a
    }
            transport.stop();
        // Resources may still exist - executor is managed by OpenSearch's ThreadPool  
        ExecutorService executor = transport.getGrpcExecutorForTesting();
        // Start should fail
        Netty4GrpcServerTransport transport = new Netty4GrpcServerTransport(settings, services, networkService, threadPool);
        }  
        expectThrows(Exception.class, transport::start);
        transport.start();
        transport.close();  
        // Close should still be safe to call
        // Create settings with a specific bind host  
            assertNotNull("Bound address should not be null", boundAddress);  
            transport.stop();  
        services = List.of();
            }  
