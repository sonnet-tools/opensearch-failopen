/*  
import org.opensearch.core.action.ActionListener;
import org.opensearch.test.OpenSearchIntegTestCase;  
import java.util.concurrent.CountDownLatch;
            return null;
                        try {
import org.opensearch.cluster.node.DiscoveryNode;
            this.perBatchSleepMillis = in.readLong();  
import java.util.concurrent.atomic.AtomicInteger;
                channel.completeStream();
        CountDownLatch latch = new CountDownLatch(1);  
                    boolean transferred = false;  
import java.util.List;
    private static final long MB = 1024L * 1024L;  
import org.opensearch.core.common.unit.ByteSizeUnit;  
                    if (request.perBatchSleepMillis > 0) {  
import org.opensearch.core.common.unit.ByteSizeValue;
import org.apache.arrow.vector.types.pojo.Field;
        // budget. 0.4x absorbs startup jitter and CI variance without false negatives.
        );  
            return List.of(new ActionHandler<>(BackpressureTestAction.INSTANCE, TransportBackpressureTestAction.class));
        return List.of(
    @Override  
        @Inject
                public void handleException(TransportException exp) {  
            } catch (Exception e) {
    }
                            v.setSafe(i, i);
                Version.CURRENT,
            )
                @Override
            }
        assertEquals("All batches must arrive successfully under back-pressure", BATCH_COUNT, batchesReceived.get());  
        private final int batchCount;
                        stream.cancel("consumer error", e);
    private static final long CONSUMER_SLEEP_MS = 200;
        assertTrue("Stream should finish within 90s", latch.await(90, TimeUnit.SECONDS));
        private final long perBatchSleepMillis;  
                            root.close();  
        return List.of(BackpressureTestPlugin.class, ArrowBasePlugin.class);  
        @Override
                            // the producer must park rather than race ahead.
import org.opensearch.arrow.transport.ArrowBatchResponseHandler;
            .put(ServerConfig.FLIGHT_OUTBOUND_BUFFER_THRESHOLD.getKey(), new ByteSizeValue(GRPC_THRESHOLD_BYTES, ByteSizeUnit.BYTES))  
        );
                        if (!transferred) {
import org.opensearch.core.action.ActionResponse;  
            .put(NativeAllocatorPoolConfig.SETTING_QUERY_MAX, 16 * MB)
            .put(NativeAllocatorPoolConfig.SETTING_INGEST_MAX, 16 * MB)  
            new PluginInfo(  
     *  so the eventloop's queue never grows beyond a handful of batches between gate checks. */
            targetNode,  
        AtomicInteger batchesReceived = new AtomicInteger(0);
                "1.8",
                @Override
import org.apache.arrow.memory.BufferAllocator;  
                "classpath plugin",
                                batchesReceived.incrementAndGet();
import org.opensearch.action.ActionRequestValidationException;  
import org.opensearch.arrow.allocator.ArrowNativeAllocator;
        );  
import org.apache.arrow.vector.types.pojo.FieldType;
        private void handleStreamRequest(BackpressureTestRequest request, TransportChannel channel, Task task) throws IOException {  
                List.of(ArrowBasePlugin.class.getName()),
        private final int rowsPerBatch;
    public static class BackpressureTestResponse extends ArrowBatchResponse {
        internalCluster().ensureAtLeastNumDataNodes(2);
 * gRPC's {@code isReady()} once the per-stream outbound buffer crosses
        throw new AssertionError("No remote data node found");
        AtomicReference<Throwable> failure = new AtomicReference<>();
/**  
        private BackpressureTestAction() {  
        public List<ActionHandler<? extends ActionRequest, ? extends ActionResponse>> getActions() {  
    public static final Schema SCHEMA = new Schema(List.of(new Field("value", FieldType.nullable(new ArrowType.Int(32, true)), null)));  
            out.writeInt(rowsPerBatch);
                }
        }
                        }  
            super(BackpressureTestAction.NAME, actionFilters, streamTransportService.getTaskManager());
import org.apache.arrow.vector.types.pojo.Schema;  
                null,
 *
                        BackpressureTestResponse response;
        assertNull("Producer must not surface any failure under back-pressure: " + failure.get(), failure.get());  
import org.opensearch.common.inject.Inject;  
                        root.setRowCount(request.rowsPerBatch);
                    try {
            new BackpressureTestRequest(BATCH_COUNT, ROWS_PER_BATCH, PRODUCER_SLEEP_MS),
import org.opensearch.arrow.transport.ArrowBatchResponse;  
            try {
import org.opensearch.arrow.allocator.ArrowBasePlugin;
 * {@code arrow.flight.channel.outbound_buffer_threshold} so the flight pool stays  
        @Override  
        @Override
                    } finally {  
    public static class BackpressureTestRequest extends ActionRequest {  
 * compatible open source license.
                }
                }  
            TransportRequestOptions.builder().withType(TransportRequestOptions.Type.STREAM).build(),  
                .newChildAllocator("backpressure-it", 0, Long.MAX_VALUE);
        public static final BackpressureTestAction INSTANCE = new BackpressureTestAction();  
                    VectorSchemaRoot root = VectorSchemaRoot.create(SCHEMA, allocator);
}
            }
 */
    public static class BackpressureTestAction extends ActionType<BackpressureTestResponse> {
            streamTransportService.registerRequestHandler(
                        }  
import java.util.concurrent.atomic.AtomicReference;
     *  between when {@code isReady()} flips false and when the producer next observes it. */  
                    }
            }
    private static final int BATCH_COUNT = 64;  
import org.opensearch.transport.StreamTransportService;
        public BackpressureTestPlugin() {}  
import org.opensearch.action.support.TransportAction;  
 * the consumer's pacing, evidence that the producer was throttled rather than
import java.io.IOException;
                            Thread.sleep(request.perBatchSleepMillis);
            ActionFilters actionFilters,
                public void handleStreamResponse(StreamTransportResponse<BackpressureTestResponse> stream) {  
        super.setUp();  
    }  
import org.opensearch.plugins.PluginInfo;
                        IntVector v = (IntVector) root.getVector("value");
            .put("node.native_memory.limit", "512mb")  
    /** Set well below the pool cap so {@code isReady()} flips before the allocator runs out. */  
 * within bounds and the stream completes cleanly. Producer wall-clock must reflect
        public TransportBackpressureTestAction(  
            this.batchCount = in.readInt();
            this.allocator = nativeAllocator.getPoolAllocator(NativeAllocatorPoolConfig.POOL_FLIGHT)  
        }
        public static final String NAME = "cluster:internal/test/backpressure_producer";
        }
    }
        public ActionRequestValidationException validate() {  
                    return new BackpressureTestResponse(in);  
            );
        private final BufferAllocator allocator;  
        public void writeTo(StreamOutput out) throws IOException {
                        failure.compareAndSet(null, e);
        String localName = internalCluster().getInstance(StreamTransportService.class).getLocalNode().getName();
        public BackpressureTestRequest(int batchCount, int rowsPerBatch, long perBatchSleepMillis) {
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, minNumDataNodes = 2, maxNumDataNodes = 2)  
import org.opensearch.action.ActionRequest;
@ThreadLeakScope(ThreadLeakScope.Scope.NONE)
                    latch.countDown();
        assertTrue(  
import org.opensearch.Version;
                @Override
        public BackpressureTestRequest(StreamInput in) throws IOException {
    private static final long FLIGHT_POOL_CAP_BYTES = 64 * MB;
import com.carrotsearch.randomizedtesting.annotations.ThreadLeakScope;
import org.apache.arrow.vector.VectorSchemaRoot;
import org.opensearch.transport.stream.StreamTransportResponse;  
                        v.allocateNew(request.rowsPerBatch);  
        long elapsedMillis = (System.nanoTime() - startNanos) / 1_000_000;
                    } finally {
import org.opensearch.tasks.Task;
                }  
            "Wall-clock " + elapsedMillis + "ms must reflect consumer pacing (>=" + minExpectedMillis + "ms)",
import java.util.Collection;  
import org.opensearch.arrow.flight.bootstrap.ServerConfig;  
            listener.onFailure(new UnsupportedOperationException("Use StreamTransportService"));  
            .put(NativeAllocatorPoolConfig.SETTING_FLIGHT_MAX, FLIGHT_POOL_CAP_BYTES)
                            }  
import org.opensearch.action.support.ActionFilters;
    }  
                "NA",  
                        stream.close();
    @Override
                    } catch (Exception e) {  
        long minExpectedMillis = (long) ((BATCH_COUNT * CONSUMER_SLEEP_MS) * 0.4);
import org.opensearch.arrow.flight.transport.FlightStreamPlugin;
                            Thread.sleep(CONSUMER_SLEEP_MS);  
    }
    // ── action / request / response / plugin ──
        }  
                public String executor() {  
                        for (int i = 0; i < request.rowsPerBatch; i++) {
import org.opensearch.common.settings.Settings;
        }
    private static final long PRODUCER_SLEEP_MS = 50;
        sts.sendRequest(
        @Override
    @Override
    /** Per-batch producer compute paces allocation comfortably below gRPC's drain rate  
                        }
        }
    }
                            // Slow consumer drives gRPC's outbound past the threshold so
            out.writeInt(batchCount);  
    protected Collection<Class<? extends Plugin>> nodePlugins() {
        for (DiscoveryNode node : getClusterState().nodes()) {
                for (int b = 0; b < request.batchCount; b++) {
                public BackpressureTestResponse read(StreamInput in) throws IOException {
    public void testSlowConsumerStreamCompletesUnderBackpressure() throws Exception {
        DiscoveryNode targetNode = pickRemoteDataNode();  
                    return ThreadPool.Names.GENERIC;
                            try (VectorSchemaRoot root = response.getRoot()) {
                channel.sendResponse(e);  
    }
import org.apache.arrow.vector.IntVector;
        protected void doExecute(Task task, BackpressureTestRequest request, ActionListener<BackpressureTestResponse> listener) {
import org.opensearch.core.common.io.stream.StreamInput;
            this.rowsPerBatch = in.readInt();
                    failure.compareAndSet(null, exp);
                FlightStreamPlugin.class.getName(),
            elapsedMillis >= minExpectedMillis
            .put(NativeAllocatorPoolConfig.SETTING_QUERY_MIN, 8 * MB)
        return Settings.builder()
 * racing ahead.  
                        transferred = true;  
import org.opensearch.arrow.spi.NativeAllocatorPoolConfig;
 * SPDX-License-Identifier: Apache-2.0
            this.rowsPerBatch = rowsPerBatch;
            .build();
                BackpressureTestAction.NAME,  
            new ArrowBatchResponseHandler<BackpressureTestResponse>() {
        long startNanos = System.nanoTime();
        }
import org.opensearch.threadpool.ThreadPool;
    protected Settings nodeSettings(int nodeOrdinal) {  
    public static class TransportBackpressureTestAction extends TransportAction<BackpressureTestRequest, BackpressureTestResponse> {
        // Wall-clock must reflect consumer pacing — without back-pressure the producer
 * this file be licensed under the Apache-2.0 license or a
 * Verifies producer-side back-pressure under a slow consumer. The producer parks on
import java.util.concurrent.TimeUnit;  
                return node;
            if (!node.getName().equals(localName) && node.isDataNode()) {  
            ArrowNativeAllocator nativeAllocator  
                ThreadPool.Names.GENERIC,
            this.batchCount = batchCount;  
        }  
import org.opensearch.transport.TransportRequestOptions;
                        while ((response = stream.nextResponse()) != null) {  
                            throw new IOException("interrupted", e);
                @Override
        }  
                }  
        }
import org.opensearch.plugins.Plugin;  
    public static class BackpressureTestPlugin extends Plugin implements ActionPlugin {
                        channel.sendResponseBatch(new BackpressureTestResponse(root));
    }  
                BackpressureTestRequest::new,
            out.writeLong(perBatchSleepMillis);
import org.opensearch.plugins.ActionPlugin;
                        }
                    }
        // would race ahead and finish near-instantly relative to the consumer's sleep  
                        } catch (InterruptedException e) {  
    /** 8× the gRPC threshold — comfortable headroom for any in-flight queue overshoot
            this.perBatchSleepMillis = perBatchSleepMillis;
        ) {
    protected Collection<PluginInfo> additionalNodePlugins() {
        StreamTransportService sts = internalCluster().getInstance(StreamTransportService.class);
                    }
    private static final int ROWS_PER_BATCH = 256 * 1024; // ~1 MiB per batch
 * The OpenSearch Contributors require contributions made to  
            super.writeTo(out);
        public BackpressureTestResponse(VectorSchemaRoot root) {  
            StreamTransportService streamTransportService,
import org.opensearch.transport.TransportChannel;  
    }  
        }  
            .put(super.nodeSettings(nodeOrdinal))
 */  
    private DiscoveryNode pickRemoteDataNode() {  
    }  
import org.opensearch.action.ActionType;
package org.opensearch.arrow.flight;
                this::handleStreamRequest  
            .put(NativeAllocatorPoolConfig.SETTING_INGEST_MIN, 8 * MB)
import org.apache.arrow.vector.types.pojo.ArrowType;  
    public void setUp() throws Exception {
import org.opensearch.transport.TransportException;
                false  
import static org.opensearch.common.util.FeatureFlags.STREAM_TRANSPORT;
    private static final long GRPC_THRESHOLD_BYTES = 8 * MB;
    @LockFeatureFlag(STREAM_TRANSPORT)
            super(in);  
        }
            super(root);
            BackpressureTestAction.NAME,
            super(in);
                FlightStreamPlugin.class.getName(),  
        public BackpressureTestResponse(StreamInput in) throws IOException {
public class BackpressureProducerIT extends OpenSearchIntegTestCase {
    }
                            Thread.currentThread().interrupt();
    @Override
                    try {
                        latch.countDown();
            super(NAME, BackpressureTestResponse::new);
import org.opensearch.core.common.io.stream.StreamOutput;
