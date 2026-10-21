            assertNotNull(transport.getBoundAddress().publishAddress().address());
        transport.stop();
        transport.close();
import static org.hamcrest.Matchers.not;
        transport.stop();
    public void testGracefulShutdownWithException() {
            MatcherAssert.assertThat(transport.getBoundAddress().boundAddresses(), not(emptyArray()));
        // Create settings with a specific port
            assertNotNull("Worker event loop group should be created", workerGroup);
        Settings settings = Settings.builder()
        transport.close();
            assertNotNull(transport.getBoundAddress().publishAddress().address());
        // Test that invalid settings are handled properly
        // Verify everything is shutdown (except executor which is managed by OpenSearch's ThreadPool)
            assertTrue("Boss group should be shutdown after failed start", bossGroup.isShutdown());
import java.util.List;
            .put(Netty4GrpcServerTransport.SETTING_GRPC_WORKER_COUNT.getKey(), 4)
        transport.start();
    public void testInvalidHostBinding() {
import org.opensearch.test.OpenSearchTestCase;
            assertTrue("Port should be in range 9300-9400", actualPort >= 9300 && actualPort <= 9400);
        // Get references to the thread pools
        ExecutorService executor = transport.getGrpcExecutorForTesting();
        networkService = new NetworkService(List.of());
            assertEquals(
import org.opensearch.threadpool.ExecutorBuilder;
        Settings settings = createSettings();
                InetAddresses.toAddrString(publishAddress.address().getAddress())
        EventLoopGroup workerGroup = transport.getWorkerEventLoopGroupForTesting();
        Netty4GrpcServerTransport transport = new Netty4GrpcServerTransport(settings, services, networkService, threadPool);
            transport.start();
        // Create a transport that will fail to start
            .put(Netty4GrpcServerTransport.SETTING_GRPC_PORT.getKey(), "999999") // Invalid port
        Netty4GrpcServerTransport transport = new Netty4GrpcServerTransport(settings, services, networkService, threadPool);
            transport.stop();
            IllegalArgumentException.class,
    }
        assertTrue("Boss group should be shutdown", bossGroup.isShutdown());
    }
import io.grpc.BindableService;
            );
    public void testCloseWithNullResources() {
        assertNotNull("Executor should still exist", executor);
        // Test binding to multiple localhost addresses
        // Create settings with a specific host
    private List<BindableService> services;
        assertNull("Boss group should be null before start", transport.getBossEventLoopGroupForTesting());
            TransportAddress publishAddress = transport.getBoundAddress().publishAddress();
import org.opensearch.threadpool.FixedExecutorBuilder;
    public void testWithCustomPublishHost() {
    public void testWithCustomPublishPort() {
        assertNotNull("Executor should still exist", executor);
            final TransportAddress remoteAddress = randomFrom(transport.getBoundAddress().boundAddresses());
        transport.stop();
        assertNull("Worker group should be null before start", transport.getWorkerEventLoopGroupForTesting());
    private static Settings createSettings() {
            .put(Netty4GrpcServerTransport.SETTING_GRPC_PUBLISH_HOST.getKey(), "127.0.0.1")
        if (executor != null) {
    }
            int actualPort = boundAddress.publishAddress().getPort();
        Settings settings = Settings.builder()
        Netty4GrpcServerTransport transport = new Netty4GrpcServerTransport(settings, services, networkService, threadPool);
            // Verify executor is created and managed by OpenSearch ThreadPool
        ExecutorService executor = transport.getGrpcExecutorForTesting();
                "Publish host should match the specified value",
            assertNotNull(publishAddress.address());
    }
        // Simulate an interruption during shutdown to test exception handling paths
            .build();
    public void testWithCustomPort() {
            .build();
        Settings settings = createSettings();
    }
        Settings settings = Settings.builder()
        transport.close();
        Settings settings = Settings.builder()
        // Test that boss and worker event loop groups are separate
        }
    }
    @Before
    public void testSeparateEventLoopGroups() {
        // Clear interrupt status
import java.util.concurrent.ExecutorService;
        Settings settings = Settings.builder().put(Netty4GrpcServerTransport.SETTING_GRPC_PORT.getKey(), "9300-9400").build();
    }
        assertNotNull("Executor should be created", executor);
        // Test with a port range
            assertNotNull(boundAddress.address());
            .build();
            .put(Netty4GrpcServerTransport.SETTING_GRPC_PORT.getKey(), OpenSearchTestCase.getPortRange())
        // Normal shutdown should work
    public void testShutdownTimeoutHandling() throws InterruptedException {
        // Stop should handle the interrupt gracefully
        }
        transport.start();
        // Start should fail due to host resolution failure
        assertNotNull("Boss group should be created", bossGroup);
        // Test that invalid executor count settings are handled properly
            MatcherAssert.assertThat(transport.getBoundAddress().boundAddresses(), not(emptyArray()));
    }
    }
    }
        // Force shutdown to test the interrupt handling code paths
                "127.0.0.1",
        Settings invalidSettings = Settings.builder()
        if (threadPool != null) {
    }
        try (Netty4GrpcServerTransport transport = new Netty4GrpcServerTransport(settings, services, networkService, threadPool)) {
        transport.stop();
        }
        transport.stop();
            // Note: The executor is now managed by OpenSearch's ThreadPool system
    public void testInterruptedShutdownHandling() throws InterruptedException {
        transport.close();
            transport.stop();
            .put(Netty4GrpcServerTransport.SETTING_GRPC_WORKER_COUNT.getKey(), 0) // Invalid: should be >= 1
            assertNotNull(transport.getBoundAddress().publishAddress().address());
        );
import org.opensearch.core.common.transport.BoundTransportAddress;
            .put(Netty4GrpcServerTransport.SETTING_GRPC_PORT.getKey(), OpenSearchTestCase.getPortRange())
    public void testGrpcTransportHealthcheck() {
        EventLoopGroup bossGroup = transport.getBossEventLoopGroupForTesting();
            assertTrue("Should have at least one bound address", boundAddress.boundAddresses().length > 0);
        // Create settings that will cause publish port resolution to fail
        }
    }
 * compatible open source license.
        // Test that close() handles null resources gracefully
        // Test that exceptions during shutdown don't prevent cleanup
        Settings settings = createSettings();
            assertEquals("Publish port should match the specified value", 9000, publishAddress.getPort());
        try (Netty4GrpcServerTransport transport = new Netty4GrpcServerTransport(settings, services, networkService, threadPool)) {
    public void testMultipleBindAddresses() {
            transport.start();
        threadPool = new ThreadPool(settings, grpcExecutorBuilder);
            assertNotNull("Bound address should not be null", boundAddress);
        Settings settings = Settings.builder()
        Settings settings = Settings.builder()
                "127.0.0.1",
import org.opensearch.common.settings.Settings;
        } catch (Exception e) {
            assertNotNull("Executor should still exist after failed start", executor);
            transport.start();
        try (Netty4GrpcServerTransport transport = new Netty4GrpcServerTransport(settings, services, networkService, threadPool)) {
            assertNotNull(publishAddress.address());
        Settings settings = Settings.builder().put(Netty4GrpcServerTransport.SETTING_GRPC_PORT.getKey(), "9000-9010").build();
        Settings settings = Settings.builder()
        }
            .build();
    public void testWithCustomWorkerCount() {
 * SPDX-License-Identifier: Apache-2.0
            MatcherAssert.assertThat(transport.getBoundAddress().boundAddresses(), not(emptyArray()));
        // Create settings with a specific executor count
        // Test that executor is properly shutdown when transport stops
        Netty4GrpcServerTransport transport = new Netty4GrpcServerTransport(settingsWithInvalidPort, services, networkService, threadPool);
            assertNotNull("Bound address should not be null", boundAddress);
        // Test default executor count (should be 2x allocated processors)
            () -> { new Netty4GrpcServerTransport(invalidSettings, services, networkService, threadPool); }
        // doClose should handle cleanup gracefully even if resources are already shutdown
        // Create settings with a specific publish host
        }
            );
        // Multiple closes should be safe
            assertNotNull("gRPC executor should be created", executor);
import org.opensearch.common.network.NetworkService;
            // Note: The executor is now managed by OpenSearch's ThreadPool system
            assertNotNull("gRPC executor should be created", executor);
    public void setup() {
        Thread.interrupted();
import io.grpc.netty.shaded.io.netty.channel.EventLoopGroup;
    public void testExecutorShutdownOnStop() {
        bossGroup.shutdownGracefully(0, 0, java.util.concurrent.TimeUnit.MILLISECONDS);
        EventLoopGroup workerGroup = transport.getWorkerEventLoopGroupForTesting();
            MatcherAssert.assertThat(transport.getBoundAddress().boundAddresses(), not(emptyArray()));
            EventLoopGroup workerGroup = transport.getWorkerEventLoopGroupForTesting();
            .put(Netty4GrpcServerTransport.SETTING_GRPC_PORT.getKey(), "0") // Dynamic port
    @After
}
    }
            .put("node.name", "test-node")
        // Event loop groups should be shutdown
            .put(Netty4GrpcServerTransport.SETTING_GRPC_HOST.getKey(), "127.0.0.1")
        EventLoopGroup workerGroup = transport.getWorkerEventLoopGroupForTesting();
import org.opensearch.threadpool.ThreadPool;
            transport.stop();
            MatcherAssert.assertThat(transport.getBoundAddress().boundAddresses(), not(emptyArray()));
        // Note: The executor is managed by OpenSearch's ThreadPool and is not shutdown when transport stops
        Netty4GrpcServerTransport transport = new Netty4GrpcServerTransport(settings, services, networkService, threadPool);
        }
            .put(Netty4GrpcServerTransport.SETTING_GRPC_PORT.getKey(), OpenSearchTestCase.getPortRange())
        assertTrue("Boss group should be shutdown after transport stop", bossGroup.isShutdown());
            transport.stop();
        ExecutorService executor = transport.getGrpcExecutorForTesting();
        transport.close();
        int expectedExecutorCount = OpenSearchExecutors.allocatedProcessors(settings) * 2;
        expectThrows(Exception.class, transport::start);
        // Now call stop - it should handle the already shutdown resources gracefully
        transport.stop();
        transport.close();
            .put(Netty4GrpcServerTransport.SETTING_GRPC_PUBLISH_PORT.getKey(), 9000)
        try (Netty4GrpcServerTransport transport = new Netty4GrpcServerTransport(settings, services, networkService, threadPool)) {
                assertTrue(client.listServices().get().size() > 1);
        transport.start();
            final TransportAddress remoteAddress = randomFrom(transport.getBoundAddress().boundAddresses());
    public void testSettingsValidation() {
    public void testEventLoopGroupsShutdownOnStop() {
            .put(Netty4GrpcServerTransport.SETTING_GRPC_PORT.getKey(), OpenSearchTestCase.getPortRange())
        assertNotNull("Executor should be created", executor);
        // Multiple closes should be safe
        // Test with invalid bind host to trigger host resolution error
import org.hamcrest.MatcherAssert;
            TransportAddress publishAddress = transport.getBoundAddress().publishAddress();
        if (bossGroup != null) {
            .build();
        Settings settings = createSettings();
            BoundTransportAddress boundAddress = transport.getBoundAddress();
    public void testWithCustomBindHost() {
import org.junit.Before;
            assertNotNull(publishAddress.address());
    }
        EventLoopGroup workerGroup = transport.getWorkerEventLoopGroupForTesting();
    public void testExecutorCountSettingsValidation() {
        }
        transport.close();
    }
        // Create settings with a specific worker count
                "127.0.0.1",
    }
        // Interrupt the current thread to test interrupt handling
        assertNotNull("Worker group should be created", workerGroup);
    }
        assertFalse("Worker group should not be shutdown initially", workerGroup.isShutdown());
        assertNotNull("Worker group should be created", workerGroup);
    public void testDefaultExecutorCount() {
        // Close should still be safe to call
                assertEquals(client.checkHealth(), HealthCheckResponse.ServingStatus.SERVING);
            transport.stop();
        // Close should handle null resources gracefully
        ExecutorBuilder<?> grpcExecutorBuilder = new FixedExecutorBuilder(settings, "grpc", 4, 1000, "thread_pool.grpc");
        assertFalse("Executor should not be shutdown initially", executor.isShutdown());
            .put(Netty4GrpcServerTransport.SETTING_GRPC_PORT.getKey(), OpenSearchTestCase.getPortRange())
            transport.stop();
        Settings settings = createSettings();
            transport.start();
        assertNotNull("Executor should be created", executor);
            TransportAddress publishAddress = transport.getBoundAddress().publishAddress();
            assertNotSame("Boss and worker event loop groups should be different instances", bossGroup, workerGroup);
    public void testWithCustomHost() {
        // Create settings with a specific bind host
public class Netty4GrpcServerTransportTests extends OpenSearchTestCase {
    public void testBasicStartAndStop() {
            assertNotNull(publishAddress.address());
            assertEquals(
            .put(Netty4GrpcServerTransport.SETTING_GRPC_WORKER_COUNT.getKey(), 4)
    public void cleanup() {
    public void testStartFailureTriggersCleanup() {
    public void testWithCustomExecutorCount() {
                "Bind host should match the specified value",
        try (Netty4GrpcServerTransport transport = new Netty4GrpcServerTransport(settings, services, networkService, threadPool)) {
import org.opensearch.common.network.InetAddresses;
        }
    }
            transport.start();
        }
        }
            .put(Netty4GrpcServerTransport.SETTING_GRPC_BIND_HOST.getKey(), "invalid.host.that.does.not.exist")
        // Resources may still exist - executor is managed by OpenSearch's ThreadPool
            transport.stop();
    private ThreadPool threadPool;
        // Start should fail
            .put(Netty4GrpcServerTransport.SETTING_GRPC_BIND_HOST.getKey(), "127.0.0.1")
/*
        executor.shutdownNow();
            .build();
        }
            .put(Netty4GrpcServerTransport.SETTING_GRPC_PORT.getKey(), OpenSearchTestCase.getPortRange())
        EventLoopGroup bossGroup = transport.getBossEventLoopGroupForTesting();
        expectThrows(Exception.class, transport::start);
        transport.start();
        transport.close();
            transport.stop();
                InetAddresses.toAddrString(boundAddress.address().getAddress())
        Settings settingsWithInvalidPort = Settings.builder()
            assertEquals(
            IllegalArgumentException.class,
            .put(Netty4GrpcServerTransport.SETTING_GRPC_PUBLISH_PORT.getKey(), "65536") // Invalid publish port
        assertTrue("Worker group should be shutdown after transport stop", workerGroup.isShutdown());
    }
    }
        try (Netty4GrpcServerTransport transport = new Netty4GrpcServerTransport(settings, services, networkService, threadPool)) {
import org.junit.After;
    public void testPortRangeHandling() {
            TransportAddress publishAddress = transport.getBoundAddress().publishAddress();
            assertTrue("Worker group should be shutdown after failed start", workerGroup.isShutdown());
        Settings settings = createSettings();
        }
            }
        services = List.of();
        }
            );
            transport.start();
        try (Netty4GrpcServerTransport transport = new Netty4GrpcServerTransport(settings, services, networkService, threadPool)) {
        Settings settings = Settings.builder()
            .put(Netty4GrpcServerTransport.SETTING_GRPC_PORT.getKey(), OpenSearchTestCase.getPortRange())
            transport.start();
        Netty4GrpcServerTransport transport = new Netty4GrpcServerTransport(settings, services, networkService, threadPool);
import org.opensearch.core.common.transport.TransportAddress;
            MatcherAssert.assertThat(transport.getBoundAddress().boundAddresses(), not(emptyArray()));
        Settings settings = Settings.builder()
            MatcherAssert.assertThat(transport.getBoundAddress().boundAddresses(), not(emptyArray()));
            .build();
            assertTrue("Port should be in the specified range", publishAddress.getPort() >= 9000 && publishAddress.getPort() <= 9010);
            transport.stop();
        assertNotNull("Boss group should be created", bossGroup);
    }
        Thread.currentThread().interrupt();
        Settings invalidSettings = Settings.builder()
            BoundTransportAddress boundAddress = transport.getBoundAddress();
            transport.start();
            .build();
            transport.start();
        transport.start();
        // Create settings with a specific publish port
    }
 * The OpenSearch Contributors require contributions made to
        try (Netty4GrpcServerTransport transport = new Netty4GrpcServerTransport(createSettings(), services, networkService, threadPool)) {
        }
            transport.stop();
            .put(Netty4GrpcServerTransport.SETTING_GRPC_EXECUTOR_COUNT.getKey(), 8)
            () -> { new Netty4GrpcServerTransport(invalidSettings, services, networkService, threadPool); }
    private NetworkService networkService;
                "Host should match the specified value",
        Netty4GrpcServerTransport transport = new Netty4GrpcServerTransport(settings, services, networkService, threadPool);
        try (Netty4GrpcServerTransport transport = new Netty4GrpcServerTransport(settings, services, networkService, threadPool)) {
        transport.close();
            .put(Netty4GrpcServerTransport.SETTING_GRPC_PORT.getKey(), OpenSearchTestCase.getPortRange())
            .put(Netty4GrpcServerTransport.SETTING_GRPC_PORT.getKey(), OpenSearchTestCase.getPortRange())
        // Start should fail due to publish port resolution
        assertTrue("Worker group should be shutdown", workerGroup.isShutdown());
            EventLoopGroup bossGroup = transport.getBossEventLoopGroupForTesting();
            .putList(Netty4GrpcServerTransport.SETTING_GRPC_BIND_HOST.getKey(), "127.0.0.1", "localhost")
            transport.stop();
        assertTrue("Boss group should be shutdown", bossGroup.isShutdown());
 *
        transport.close();
        EventLoopGroup bossGroup = transport.getBossEventLoopGroupForTesting();
            assertNotNull("Boss event loop group should be created", bossGroup);
            transport.stop();
import io.grpc.health.v1.HealthCheckResponse;
    }
    public void testResourceCleanupOnClose() {
            throw new RuntimeException(e);
    }
            transport.stop();
package org.opensearch.transport.grpc;
 */
            transport.stop();
        try (Netty4GrpcServerTransport transport = new Netty4GrpcServerTransport(settings, services, networkService, threadPool)) {
    }
        Settings settings = createSettings();
        expectThrows(Exception.class, transport::start);
        // Don't start the transport, so resources should be null
        Settings settings = createSettings();
            .build();
            transport.start();
        // Resources should be cleaned up after failure - the implementation calls doStop() in the finally block
        return Settings.builder().put(Netty4GrpcServerTransport.SETTING_GRPC_PORT.getKey(), OpenSearchTestCase.getPortRange()).build();
            .put(Netty4GrpcServerTransport.SETTING_GRPC_PORT.getKey(), OpenSearchTestCase.getPortRange())
            transport.start();
        EventLoopGroup bossGroup = transport.getBossEventLoopGroupForTesting();
    }
            .put(Netty4GrpcServerTransport.SETTING_GRPC_EXECUTOR_COUNT.getKey(), 4)
    }
            .put(Netty4GrpcServerTransport.SETTING_GRPC_PORT.getKey(), OpenSearchTestCase.getPortRange())
        }
            .build();
        workerGroup.shutdownGracefully(0, 0, java.util.concurrent.TimeUnit.MILLISECONDS);
        Settings settings = Settings.builder()
            try (NettyGrpcClient client = new NettyGrpcClient.Builder().setAddress(remoteAddress).build()) {
import org.opensearch.common.util.concurrent.OpenSearchExecutors;
    }
            .build();
        Netty4GrpcServerTransport transport = new Netty4GrpcServerTransport(settings, services, networkService, threadPool);
        assertFalse("Boss group should not be shutdown initially", bossGroup.isShutdown());
        transport.close();
            ExecutorService executor = transport.getGrpcExecutorForTesting();
            transport.start();
        // Test that event loop groups are properly shutdown when transport stops
        transport.start();
            .build();
        expectThrows(
            try (NettyGrpcClient client = new NettyGrpcClient.Builder().setAddress(remoteAddress).build()) {
    public void testPublishPortResolutionFailure() {
        Settings settings = Settings.builder()
        assertTrue("Worker group should be shutdown", workerGroup.isShutdown());
import org.opensearch.transport.grpc.ssl.NettyGrpcClient;
        expectThrows(
                InetAddresses.toAddrString(publishAddress.address().getAddress())
            transport.start();
        assertNotNull("Executor should still exist after transport stop", executor);
            threadPool.shutdown();
        // Create a ThreadPool with the gRPC executor
    }
 * this file be licensed under the Apache-2.0 license or a
        ExecutorService executor = transport.getGrpcExecutorForTesting();
        Netty4GrpcServerTransport transport = new Netty4GrpcServerTransport(settings, services, networkService, threadPool);
        );
            .build();
            // We can't easily verify the thread count as it's encapsulated within OpenSearch's executor implementation
            ExecutorService executor = transport.getGrpcExecutorForTesting();
        transport.close();
            }
        try (Netty4GrpcServerTransport transport = new Netty4GrpcServerTransport(createSettings(), services, networkService, threadPool)) {
        Netty4GrpcServerTransport transport = new Netty4GrpcServerTransport(settings, services, networkService, threadPool);
        try (Netty4GrpcServerTransport transport = new Netty4GrpcServerTransport(createSettings(), services, networkService, threadPool)) {
            MatcherAssert.assertThat(transport.getBoundAddress().boundAddresses(), not(emptyArray()));
            TransportAddress boundAddress = transport.getBoundAddress().boundAddresses()[0];
        assertNotNull("Worker group should be created", workerGroup);
        }
import static org.hamcrest.Matchers.emptyArray;
        if (workerGroup != null) {
    public void testGrpcTransportListServices() {
            throw new RuntimeException(e);
        assertNotNull("Boss group should be created", bossGroup);
        try (Netty4GrpcServerTransport transport = new Netty4GrpcServerTransport(settings, services, networkService, threadPool)) {
        transport.close();
        // Verify executor still exists (managed by OpenSearch's ThreadPool)
            .build();
        try (Netty4GrpcServerTransport transport = new Netty4GrpcServerTransport(settings, services, networkService, threadPool)) {
        assertNull("Executor should be null before start", transport.getGrpcExecutorForTesting());
        }
            transport.start();
            .put(Netty4GrpcServerTransport.SETTING_GRPC_EXECUTOR_COUNT.getKey(), 0) // Invalid: should be >= 1
        } catch (Exception e) {
            // The actual thread count is configured via the FixedExecutorBuilder in the test setup
