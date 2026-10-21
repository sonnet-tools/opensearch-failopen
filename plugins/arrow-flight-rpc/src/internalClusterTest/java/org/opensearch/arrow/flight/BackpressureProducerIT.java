import org.opensearch.plugins.ActionPlugin;
            elapsedMillis >= minExpectedMillis
                }
import org.opensearch.arrow.allocator.ArrowBasePlugin;
        private final int rowsPerBatch;
        assertTrue(
 * SPDX-License-Identifier: Apache-2.0
                        stream.close();
    public static class TransportBackpressureTestAction extends TransportAction<BackpressureTestRequest, BackpressureTestResponse> {
    }
            try {
 * compatible open source license.
import org.opensearch.arrow.allocator.ArrowNativeAllocator;
            .put(NativeAllocatorPoolConfig.SETTING_FLIGHT_MAX, FLIGHT_POOL_CAP_BYTES)
        assertEquals("All batches must arrive successfully under back-pressure", BATCH_COUNT, batchesReceived.get());
        // Wall-clock must reflect consumer pacing — without back-pressure the producer
    private DiscoveryNode pickRemoteDataNode() {
 */
}
                "1.8",
 * racing ahead.
    // ── action / request / response / plugin ──
            streamTransportService.registerRequestHandler(
                        try {
import org.apache.arrow.vector.types.pojo.Field;
                    if (request.perBatchSleepMillis > 0) {
        public static final BackpressureTestAction INSTANCE = new BackpressureTestAction();
    private static final long CONSUMER_SLEEP_MS = 200;
import java.util.concurrent.CountDownLatch;
                List.of(ArrowBasePlugin.class.getName()),
import static org.opensearch.common.util.FeatureFlags.STREAM_TRANSPORT;
                            Thread.sleep(CONSUMER_SLEEP_MS);
                    } catch (Exception e) {
    public static final Schema SCHEMA = new Schema(List.of(new Field("value", FieldType.nullable(new ArrowType.Int(32, true)), null)));
                    }
     *  so the eventloop's queue never grows beyond a handful of batches between gate checks. */
                        IntVector v = (IntVector) root.getVector("value");
    private static final int BATCH_COUNT = 64;
            super(in);
        }
                    return new BackpressureTestResponse(in);
                            }
        public List<ActionHandler<? extends ActionRequest, ? extends ActionResponse>> getActions() {
                @Override
import org.opensearch.action.ActionRequest;
                    return ThreadPool.Names.GENERIC;
            .put(NativeAllocatorPoolConfig.SETTING_QUERY_MAX, 16 * MB)
 * the consumer's pacing, evidence that the producer was throttled rather than
    public static class BackpressureTestPlugin extends Plugin implements ActionPlugin {
 * gRPC's {@code isReady()} once the per-stream outbound buffer crosses
                    VectorSchemaRoot root = VectorSchemaRoot.create(SCHEMA, allocator);
        return List.of(BackpressureTestPlugin.class, ArrowBasePlugin.class);
        return Settings.builder()
    @Override
            TransportRequestOptions.builder().withType(TransportRequestOptions.Type.STREAM).build(),
    /** Set well below the pool cap so {@code isReady()} flips before the allocator runs out. */
 * within bounds and the stream completes cleanly. Producer wall-clock must reflect
            super(in);
            .put(NativeAllocatorPoolConfig.SETTING_INGEST_MIN, 8 * MB)
                public String executor() {
        public TransportBackpressureTestAction(
                public BackpressureTestResponse read(StreamInput in) throws IOException {
        );
                }
                    }
import org.opensearch.arrow.flight.transport.FlightStreamPlugin;
                        if (!transferred) {
    }
import org.opensearch.core.common.unit.ByteSizeValue;
import org.opensearch.Version;
            out.writeLong(perBatchSleepMillis);
import org.opensearch.plugins.PluginInfo;
        sts.sendRequest(
import org.opensearch.action.support.TransportAction;
            super(NAME, BackpressureTestResponse::new);
 * The OpenSearch Contributors require contributions made to
import org.opensearch.transport.StreamTransportService;
        for (DiscoveryNode node : getClusterState().nodes()) {
                ThreadPool.Names.GENERIC,
            .put(NativeAllocatorPoolConfig.SETTING_QUERY_MIN, 8 * MB)
        long startNanos = System.nanoTime();
                "NA",
import org.opensearch.tasks.Task;
                        failure.compareAndSet(null, e);
import org.opensearch.core.common.io.stream.StreamInput;
import org.opensearch.test.OpenSearchIntegTestCase;
import org.apache.arrow.vector.types.pojo.Schema;
    private static final long GRPC_THRESHOLD_BYTES = 8 * MB;
                    try {
                            throw new IOException("interrupted", e);
            .build();
                FlightStreamPlugin.class.getName(),
        public BackpressureTestRequest(StreamInput in) throws IOException {
        long elapsedMillis = (System.nanoTime() - startNanos) / 1_000_000;
import org.opensearch.threadpool.ThreadPool;
                null,
    }
        // budget. 0.4x absorbs startup jitter and CI variance without false negatives.
    private static final long FLIGHT_POOL_CAP_BYTES = 64 * MB;
                        while ((response = stream.nextResponse()) != null) {
        }
            StreamTransportService streamTransportService,
import org.opensearch.core.action.ActionListener;
        @Override
                @Override
                @Override
public class BackpressureProducerIT extends OpenSearchIntegTestCase {
    }
                        } catch (InterruptedException e) {
                        latch.countDown();
    }
            );
        throw new AssertionError("No remote data node found");
    private static final long PRODUCER_SLEEP_MS = 50;
                for (int b = 0; b < request.batchCount; b++) {
            super(root);
        @Override
            ArrowNativeAllocator nativeAllocator
/**
            }
                    } finally {
import java.io.IOException;
import org.opensearch.core.common.io.stream.StreamOutput;
import org.opensearch.core.common.unit.ByteSizeUnit;
                }
                        }
    }
        @Override
        }
    /** 8× the gRPC threshold — comfortable headroom for any in-flight queue overshoot
        AtomicInteger batchesReceived = new AtomicInteger(0);
import org.opensearch.arrow.flight.bootstrap.ServerConfig;
        String localName = internalCluster().getInstance(StreamTransportService.class).getLocalNode().getName();
import org.opensearch.transport.stream.StreamTransportResponse;
import org.apache.arrow.vector.IntVector;
            super.writeTo(out);
        );
                }
                BackpressureTestAction.NAME,
            this.allocator = nativeAllocator.getPoolAllocator(NativeAllocatorPoolConfig.POOL_FLIGHT)
        long minExpectedMillis = (long) ((BATCH_COUNT * CONSUMER_SLEEP_MS) * 0.4);
            listener.onFailure(new UnsupportedOperationException("Use StreamTransportService"));
                        v.allocateNew(request.rowsPerBatch);
            this.perBatchSleepMillis = perBatchSleepMillis;
@ThreadLeakScope(ThreadLeakScope.Scope.NONE)
                "classpath plugin",
    private static final int ROWS_PER_BATCH = 256 * 1024; // ~1 MiB per batch
        public BackpressureTestResponse(VectorSchemaRoot root) {
                    failure.compareAndSet(null, exp);
import org.opensearch.action.support.ActionFilters;
        private BackpressureTestAction() {
                            try (VectorSchemaRoot root = response.getRoot()) {
            ActionFilters actionFilters,
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, minNumDataNodes = 2, maxNumDataNodes = 2)
                BackpressureTestRequest::new,
        return List.of(
import org.opensearch.action.ActionType;
        DiscoveryNode targetNode = pickRemoteDataNode();
                        }
        );
        StreamTransportService sts = internalCluster().getInstance(StreamTransportService.class);
    protected Collection<PluginInfo> additionalNodePlugins() {
import org.opensearch.arrow.spi.NativeAllocatorPoolConfig;
        }
        @Override
 */
    protected Collection<Class<? extends Plugin>> nodePlugins() {
import org.opensearch.action.ActionRequestValidationException;
package org.opensearch.arrow.flight;
        internalCluster().ensureAtLeastNumDataNodes(2);
            .put("node.native_memory.limit", "512mb")
        }
/*
                        channel.sendResponseBatch(new BackpressureTestResponse(root));
            )
                        transferred = true;
                            Thread.sleep(request.perBatchSleepMillis);
        }
            BackpressureTestAction.NAME,
        assertTrue("Stream should finish within 90s", latch.await(90, TimeUnit.SECONDS));
                public void handleStreamResponse(StreamTransportResponse<BackpressureTestResponse> stream) {
    }
            new BackpressureTestRequest(BATCH_COUNT, ROWS_PER_BATCH, PRODUCER_SLEEP_MS),
            } catch (Exception e) {
                        BackpressureTestResponse response;
        private final long perBatchSleepMillis;
        }
        ) {
                        for (int i = 0; i < request.rowsPerBatch; i++) {
                        stream.cancel("consumer error", e);
import org.opensearch.transport.TransportRequestOptions;
            .put(super.nodeSettings(nodeOrdinal))
            }
        }
import org.opensearch.arrow.transport.ArrowBatchResponse;
        private final BufferAllocator allocator;
                            root.close();
import com.carrotsearch.randomizedtesting.annotations.ThreadLeakScope;
import org.opensearch.transport.TransportException;
            .put(NativeAllocatorPoolConfig.SETTING_INGEST_MAX, 16 * MB)
            out.writeInt(batchCount);
        public static final String NAME = "cluster:internal/test/backpressure_producer";
            }
 * this file be licensed under the Apache-2.0 license or a
                    try {
        // would race ahead and finish near-instantly relative to the consumer's sleep
        public BackpressureTestRequest(int batchCount, int rowsPerBatch, long perBatchSleepMillis) {
            this.batchCount = in.readInt();
        super.setUp();
                    boolean transferred = false;
import org.opensearch.transport.TransportChannel;
                channel.sendResponse(e);
        public void writeTo(StreamOutput out) throws IOException {
            new PluginInfo(
    public static class BackpressureTestResponse extends ArrowBatchResponse {
    @Override
    @LockFeatureFlag(STREAM_TRANSPORT)
                .newChildAllocator("backpressure-it", 0, Long.MAX_VALUE);
                }
    private static final long MB = 1024L * 1024L;
            this.rowsPerBatch = in.readInt();
    public static class BackpressureTestAction extends ActionType<BackpressureTestResponse> {
     *  between when {@code isReady()} flips false and when the producer next observes it. */
    }
 * {@code arrow.flight.channel.outbound_buffer_threshold} so the flight pool stays
                    } finally {
import org.apache.arrow.vector.VectorSchemaRoot;
        public ActionRequestValidationException validate() {
            this.rowsPerBatch = rowsPerBatch;
                    }
import java.util.concurrent.atomic.AtomicInteger;
        private void handleStreamRequest(BackpressureTestRequest request, TransportChannel channel, Task task) throws IOException {
                        }
            return List.of(new ActionHandler<>(BackpressureTestAction.INSTANCE, TransportBackpressureTestAction.class));
        private final int batchCount;
    }
import java.util.List;
                FlightStreamPlugin.class.getName(),
                return node;
        protected void doExecute(Task task, BackpressureTestRequest request, ActionListener<BackpressureTestResponse> listener) {
import org.apache.arrow.vector.types.pojo.FieldType;
        }
                            // Slow consumer drives gRPC's outbound past the threshold so
            super(BackpressureTestAction.NAME, actionFilters, streamTransportService.getTaskManager());
                            // the producer must park rather than race ahead.
                                batchesReceived.incrementAndGet();
    }
        }
    public static class BackpressureTestRequest extends ActionRequest {
            if (!node.getName().equals(localName) && node.isDataNode()) {
 * Verifies producer-side back-pressure under a slow consumer. The producer parks on
    public void setUp() throws Exception {
        AtomicReference<Throwable> failure = new AtomicReference<>();
import org.opensearch.plugins.Plugin;
            new ArrowBatchResponseHandler<BackpressureTestResponse>() {
            "Wall-clock " + elapsedMillis + "ms must reflect consumer pacing (>=" + minExpectedMillis + "ms)",
    protected Settings nodeSettings(int nodeOrdinal) {
    /** Per-batch producer compute paces allocation comfortably below gRPC's drain rate
                channel.completeStream();
import org.opensearch.cluster.node.DiscoveryNode;
                        root.setRowCount(request.rowsPerBatch);
    public void testSlowConsumerStreamCompletesUnderBackpressure() throws Exception {
                            v.setSafe(i, i);
        public BackpressureTestResponse(StreamInput in) throws IOException {
        CountDownLatch latch = new CountDownLatch(1);
import java.util.concurrent.TimeUnit;
                false
            .put(ServerConfig.FLIGHT_OUTBOUND_BUFFER_THRESHOLD.getKey(), new ByteSizeValue(GRPC_THRESHOLD_BYTES, ByteSizeUnit.BYTES))
        public BackpressureTestPlugin() {}
        assertNull("Producer must not surface any failure under back-pressure: " + failure.get(), failure.get());
            return null;
        @Inject
                this::handleStreamRequest
import java.util.concurrent.atomic.AtomicReference;
import org.opensearch.arrow.transport.ArrowBatchResponseHandler;
import java.util.Collection;
        }
    @Override
            this.perBatchSleepMillis = in.readLong();
    @Override
import org.apache.arrow.vector.types.pojo.ArrowType;
                            Thread.currentThread().interrupt();
        }
                public void handleException(TransportException exp) {
    }
                    latch.countDown();
            targetNode,
 *
import org.apache.arrow.memory.BufferAllocator;
import org.opensearch.core.action.ActionResponse;
                        }
            this.batchCount = batchCount;
                @Override
            out.writeInt(rowsPerBatch);
                Version.CURRENT,
import org.opensearch.common.settings.Settings;
import org.opensearch.common.inject.Inject;
