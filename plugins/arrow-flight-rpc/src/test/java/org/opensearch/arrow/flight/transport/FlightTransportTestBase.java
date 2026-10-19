                flightTransport,
            },
        // remote node's transport/stream addresses from it. The transport address is never
            super(in);
    protected StreamTransportService streamTransportService;
 * The OpenSearch Contributors require contributions made to
import org.opensearch.core.common.transport.BoundTransportAddress;
            mock(Tracer.class),
            flightClient,
        // port. Using a single port made tests fail with BindTransportException whenever the
        super.setUp();
public abstract class FlightTransportTestBase extends OpenSearchTestCase {
}
            new PageCacheRecycler(settings),
            super(in);
            nativeAllocator = null;
import static org.mockito.ArgumentMatchers.any;
    protected FlightClientChannel createChannel(FlightClient flightClient, ThreadPool threadPool) {
            serverLocation,
    }
        super.tearDown();
        flightTransport.start();
import org.opensearch.tasks.TaskManager;
            .build();
import static org.mockito.Mockito.when;
            ServerConfig.getGrpcExecutorBuilder(),
        int streamPort = flightTransport.boundAddress().publishAddress().address().getPort();
            namedWriteableRegistry,
        @Override
    protected ThreadPool threadPool;
import org.opensearch.core.indices.breaker.NoneCircuitBreakerService;
        // bound by this test, so any distinct port suffices.
        }
            nativeAllocator
        // here so the test has a usable allocator; tearDown closes it.
    @Before
        public String getData() {
import java.io.IOException;
            )
    @Override
        if (streamTransportService != null) {
import static org.mockito.Mockito.mock;
 *
import org.opensearch.transport.TransportService;
import org.opensearch.arrow.allocator.ArrowNativeAllocator;
    protected FlightTransport flightTransport;
import org.opensearch.common.network.NetworkService;
                null,
        when(taskManager.taskExecutionStarted(any())).thenReturn(mock(ThreadContext.StoredContext.class));
            super.writeTo(out);
    protected FlightStatsCollector statsCollector;
        streamTransportService.connectToNode(remoteNode);
            new FlightTransportConfig()
        }
import org.opensearch.core.transport.TransportResponse;
        );
    protected BoundTransportAddress boundAddress;
        }
        remoteNode = new DiscoveryNode(new DiscoveryNode("test-node-id", transportAddress, Version.CURRENT), streamAddress);
        @Override
import java.util.Collections;
            customThreadPool,
import org.opensearch.core.common.io.stream.StreamOutput;
            settings,
 */
    protected FlightClientChannel createChannel(
        Settings settings = Settings.builder()
        streamTransportService = spy(
        return createChannel(flightClient, threadPool, flightTransport.getResponseHandlers());
            this.data = data;
        if (nativeAllocator != null) {
                threadPool,
    }
        public void writeTo(StreamOutput out) throws IOException {
import org.junit.Before;
        threadPool = new ThreadPool(
        TransportService transportService = mock(TransportService.class);
            handlers,
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
        if (flightTransport != null) {
import org.opensearch.common.util.concurrent.ThreadContext;
        Transport.ResponseHandlers handlers
    protected static class TestResponse extends TransportResponse {
            this.data = in.readOptionalString();
        TransportAddress transportAddress = new TransportAddress(InetAddress.getLoopbackAddress(), streamPort + 1);
    public void tearDown() throws Exception {
            new StreamTransportService(
        );
    }
        headerContext = new HeaderContext();
        ThreadPool customThreadPool,
import org.opensearch.transport.TransportMessageListener;
    protected Location serverLocation;
        // chosen port was held in TIME_WAIT or contended by another process on the CI runner.
import static org.mockito.Mockito.spy;
                mock(Tracer.class)
            boundAddress,
        when(transportService.getTaskManager()).thenReturn(taskManager);
        }
    protected static class TestRequest extends TransportRequest {
            namedWriteableRegistry,
    protected ArrowNativeAllocator nativeAllocator;
        TransportAddress streamAddress = new TransportAddress(InetAddress.getLoopbackAddress(), streamPort);
            null,
        }
    }
    }
        if (threadPool != null) {
            ServerConfig.getServerExecutorBuilder()
            new NetworkService(Collections.emptyList()),
            nativeAllocator.close();
        flightTransport = new FlightTransport(
        }
                settings,
 * SPDX-License-Identifier: Apache-2.0
import org.junit.After;
    protected DiscoveryNode remoteNode;
package org.opensearch.arrow.flight.transport;
        );
        }
import org.opensearch.telemetry.tracing.Tracer;
        );
import org.apache.arrow.flight.FlightClient;
        nativeAllocator = new ArrowNativeAllocator();
            threadPool,
    protected HeaderContext headerContext;
    protected NamedWriteableRegistry namedWriteableRegistry;
        // The actual bound port is read from FlightTransport.boundAddress() after start() below.
import org.opensearch.common.settings.Settings;
        return new FlightClientChannel(
            return data;
        ServerConfig.init(settings);
            settings,
import org.opensearch.transport.StreamTransportService;
        nativeAllocator.getOrCreatePool(NativeAllocatorPoolConfig.POOL_FLIGHT, 0L, Long.MAX_VALUE, null);
        // Configure FlightTransport with a port range rather than a single hardcoded port. The
        FlightClient flightClient,
        // Resolve the actual bound stream port (chosen by PortsRange.iterate()) and derive the
import org.opensearch.test.OpenSearchTestCase;
import org.opensearch.arrow.flight.stats.FlightStatsCollector;
import org.opensearch.threadpool.ThreadPool;
            new NoneCircuitBreakerService(),
        TaskManager taskManager = mock(TaskManager.class);
        String portRange = basePort + "-" + (basePort + 99);
        public TestResponse(String data) {
                x -> remoteNode,
    @After
        private final String data;
            headerContext,
import org.opensearch.core.common.io.stream.StreamInput;
            .put("aux.transport.transport-flight.port", portRange)
import org.apache.arrow.flight.Location;
            remoteNode,
        }
            ServerConfig.getClientExecutorBuilder(),
    @Override
        serverLocation = Location.forGrpcInsecure("localhost", streamPort);
            statsCollector,
        public TestRequest(StreamInput in) throws IOException {
                transportService.getTaskManager(),
        return createChannel(flightClient, threadPool, flightTransport.getResponseHandlers());
            "test-profile",
                null,
import org.opensearch.transport.Transport;
            streamTransportService.close();
        namedWriteableRegistry = new NamedWriteableRegistry(Collections.emptyList());
            Version.CURRENT,
    ) {
import org.opensearch.core.common.transport.TransportAddress;
    }
import org.opensearch.Version;
                StreamTransportService.NOOP_TRANSPORT_INTERCEPTOR,
        statsCollector = new FlightStatsCollector();
            .put("node.name", getTestName())
import org.opensearch.common.util.PageCacheRecycler;
 * this file be licensed under the Apache-2.0 license or a
        }
        }
            threadPool.shutdown();
        // transport iterates the range via PortsRange.iterate() and binds the first available
            flightTransport.close();
            statsCollector,
/*
import org.opensearch.arrow.flight.bootstrap.ServerConfig;
import org.opensearch.transport.TransportRequest;
            new TransportMessageListener() {
import org.opensearch.arrow.spi.NativeAllocatorPoolConfig;
        public void writeTo(StreamOutput out) throws IOException {
import java.net.InetAddress;
 * compatible open source license.
            out.writeOptionalString(data);
        public TestResponse(StreamInput in) throws IOException {
    }
import org.opensearch.cluster.node.DiscoveryNode;
        boundAddress = new BoundTransportAddress(new TransportAddress[] { transportAddress }, transportAddress);
        int basePort = getBasePort(9500);
        // FlightTransport sources its allocator from the framework's FLIGHT pool. Construct one
        public TestRequest() {}
    protected FlightClientChannel createChannel(FlightClient flightClient) {
    public void setUp() throws Exception {
