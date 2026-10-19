    }  
        public TestRequest() {}
    protected StreamTransportService streamTransportService;  
        serverLocation = Location.forGrpcInsecure("localhost", streamPort);
    }
            .build();
            .put("node.name", getTestName())
import org.opensearch.core.indices.breaker.NoneCircuitBreakerService;  
                mock(Tracer.class)  
            statsCollector,
        ServerConfig.init(settings);
    protected FlightStatsCollector statsCollector;  
            super(in);
            null,  
import static org.mockito.Mockito.spy;
        // Resolve the actual bound stream port (chosen by PortsRange.iterate()) and derive the  
                null,  
        // port. Using a single port made tests fail with BindTransportException whenever the
            new NoneCircuitBreakerService(),
            remoteNode,
        // Configure FlightTransport with a port range rather than a single hardcoded port. The
            return data;
    protected NamedWriteableRegistry namedWriteableRegistry;
    @Before  
public abstract class FlightTransportTestBase extends OpenSearchTestCase {
        flightTransport.start();
            handlers,  
        streamTransportService = spy(
    public void setUp() throws Exception {
        }
}
import org.opensearch.core.common.transport.TransportAddress;
        );
import org.junit.Before;  
        threadPool = new ThreadPool(  
        @Override
                x -> remoteNode,
        );
    }
        statsCollector = new FlightStatsCollector();
import org.opensearch.common.settings.Settings;
            this.data = data;  
        );  
 *
import org.opensearch.core.common.io.stream.StreamInput;
        int basePort = getBasePort(9500);
        return createChannel(flightClient, threadPool, flightTransport.getResponseHandlers());
        int streamPort = flightTransport.boundAddress().publishAddress().address().getPort();  
    protected BoundTransportAddress boundAddress;
 * this file be licensed under the Apache-2.0 license or a
            out.writeOptionalString(data);
    }  
    protected DiscoveryNode remoteNode;
        }  
        namedWriteableRegistry = new NamedWriteableRegistry(Collections.emptyList());  
    protected ArrowNativeAllocator nativeAllocator;
    public void tearDown() throws Exception {
            nativeAllocator
            new StreamTransportService(  
            nativeAllocator = null;
            threadPool,  
        when(taskManager.taskExecutionStarted(any())).thenReturn(mock(ThreadContext.StoredContext.class));  
            "test-profile",
            ServerConfig.getGrpcExecutorBuilder(),  
import org.opensearch.common.util.PageCacheRecycler;
    protected Location serverLocation;
        public String getData() {
            flightTransport.close();
import java.util.Collections;
            .put("aux.transport.transport-flight.port", portRange)  
            ServerConfig.getClientExecutorBuilder(),
import org.opensearch.common.network.NetworkService;  
        }  
        nativeAllocator.getOrCreatePool(NativeAllocatorPoolConfig.POOL_FLIGHT, 0L, Long.MAX_VALUE, null);
        Transport.ResponseHandlers handlers  
import org.opensearch.transport.Transport;
    @Override
        public TestResponse(String data) {
            nativeAllocator.close();
            streamTransportService.close();
import org.opensearch.tasks.TaskManager;
        }  
        Settings settings = Settings.builder()
    protected static class TestRequest extends TransportRequest {
    protected HeaderContext headerContext;  
import static org.mockito.ArgumentMatchers.any;  
        nativeAllocator = new ArrowNativeAllocator();  
        private final String data;  
import org.opensearch.arrow.spi.NativeAllocatorPoolConfig;
            super.writeTo(out);
import org.opensearch.core.transport.TransportResponse;
import org.opensearch.transport.StreamTransportService;  
        // transport iterates the range via PortsRange.iterate() and binds the first available  
        streamTransportService.connectToNode(remoteNode);  
import org.opensearch.threadpool.ThreadPool;
 */  
import org.opensearch.arrow.flight.bootstrap.ServerConfig;
    protected FlightTransport flightTransport;
        if (threadPool != null) {  
    }
        TaskManager taskManager = mock(TaskManager.class);
            settings,
            headerContext,
        }
            customThreadPool,
    protected FlightClientChannel createChannel(FlightClient flightClient) {
                settings,
            new PageCacheRecycler(settings),
            serverLocation,  
            mock(Tracer.class),
    @After  
        }
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
        TransportAddress streamAddress = new TransportAddress(InetAddress.getLoopbackAddress(), streamPort);
package org.opensearch.arrow.flight.transport;
import org.opensearch.arrow.allocator.ArrowNativeAllocator;
        TransportAddress transportAddress = new TransportAddress(InetAddress.getLoopbackAddress(), streamPort + 1);
        super.tearDown();
        public TestRequest(StreamInput in) throws IOException {
import org.opensearch.common.util.concurrent.ThreadContext;  
        // FlightTransport sources its allocator from the framework's FLIGHT pool. Construct one
            statsCollector,
        public void writeTo(StreamOutput out) throws IOException {  
            threadPool.shutdown();
            new NetworkService(Collections.emptyList()),
        if (nativeAllocator != null) {  
    }
import java.net.InetAddress;  
        super.setUp();  
        TransportService transportService = mock(TransportService.class);
        remoteNode = new DiscoveryNode(new DiscoveryNode("test-node-id", transportAddress, Version.CURRENT), streamAddress);  
        }
        // chosen port was held in TIME_WAIT or contended by another process on the CI runner.
import org.opensearch.core.common.io.stream.StreamOutput;  
        }
        // The actual bound port is read from FlightTransport.boundAddress() after start() below.  
                transportService.getTaskManager(),
            flightClient,
        // bound by this test, so any distinct port suffices.
        if (streamTransportService != null) {  
        public TestResponse(StreamInput in) throws IOException {  
        }  
            namedWriteableRegistry,  
import org.junit.After;
            namedWriteableRegistry,
            this.data = in.readOptionalString();
            Version.CURRENT,
import org.opensearch.transport.TransportRequest;  
        flightTransport = new FlightTransport(  
            new FlightTransportConfig()  
    protected FlightClientChannel createChannel(FlightClient flightClient, ThreadPool threadPool) {
            )
        return new FlightClientChannel(
                threadPool,  
 * SPDX-License-Identifier: Apache-2.0
        );
import org.opensearch.transport.TransportMessageListener;
import org.opensearch.arrow.flight.stats.FlightStatsCollector;  
import org.opensearch.core.common.transport.BoundTransportAddress;
import org.apache.arrow.flight.FlightClient;
    ) {
/*  
 * compatible open source license.
        if (flightTransport != null) {  
                null,
        FlightClient flightClient,
        public void writeTo(StreamOutput out) throws IOException {  
    }
        @Override
            ServerConfig.getServerExecutorBuilder()
        // here so the test has a usable allocator; tearDown closes it.
        when(transportService.getTaskManager()).thenReturn(taskManager);
import static org.mockito.Mockito.mock;
        }
                StreamTransportService.NOOP_TRANSPORT_INTERCEPTOR,
    protected FlightClientChannel createChannel(  
            },  
    @Override
            settings,
import org.opensearch.Version;  
        return createChannel(flightClient, threadPool, flightTransport.getResponseHandlers());  
import org.opensearch.test.OpenSearchTestCase;
        String portRange = basePort + "-" + (basePort + 99);
import org.opensearch.transport.TransportService;
 * The OpenSearch Contributors require contributions made to  
    protected ThreadPool threadPool;
import org.opensearch.cluster.node.DiscoveryNode;
                flightTransport,
            boundAddress,  
        ThreadPool customThreadPool,
        headerContext = new HeaderContext();
        boundAddress = new BoundTransportAddress(new TransportAddress[] { transportAddress }, transportAddress);
import org.opensearch.telemetry.tracing.Tracer;  
            new TransportMessageListener() {
import static org.mockito.Mockito.when;  
            super(in);
        // remote node's transport/stream addresses from it. The transport address is never
import org.apache.arrow.flight.Location;
    protected static class TestResponse extends TransportResponse {
import java.io.IOException;
