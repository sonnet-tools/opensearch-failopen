                        streamResponse.cancel("Test error", e);
import org.opensearch.transport.stream.StreamErrorCode;
import org.opensearch.cluster.node.DiscoveryNode;
                if (request.parallelism <= 1) {
            new TestArrowRequest(batchCount, rowsPerBatch, 1),
 * compatible open source license.
            Set<Integer> batchIds = new HashSet<>();
                    }
        @Override
            ReceivedBatch batch = batches.get(0);
        private final List<ReceivedBatch> batches;
import org.opensearch.action.ActionRequestValidationException;
    // ── Tests ──
                    BlockingQueue<TestArrowResponse> queue = new LinkedBlockingQueue<>();
                    }
                    try (VectorSchemaRoot batch = response.getRoot()) {
                        // Collect references WITHOUT reading vector data — defer that until after close.
        {
        protected void doExecute(Task task, TestArrowRequest request, ActionListener<TestArrowResponse> listener) {
                .newChildAllocator("native-arrow-test", 0, Long.MAX_VALUE);
import org.apache.arrow.vector.VarCharVector;
 * this file be licensed under the Apache-2.0 license or a
        List<TestArrowResponse> retained = new ArrayList<>();
                IntVector batchIdVec = (IntVector) root.getVector("batch_id");
    }
                public TestArrowResponse read(StreamInput in) throws IOException {
        @Override
        CountDownLatch latch = new CountDownLatch(1);
        private void handleStreamRequest(TestArrowRequest request, TransportChannel channel, Task task) throws IOException {
import org.opensearch.core.common.io.stream.StreamOutput;
    private List<ReceivedBatch> sendAndReceive(DiscoveryNode node, int batchCount, int rowsPerBatch, int parallelism) throws Exception {
        final int rowCount;
    }
            super.writeTo(out);
        int batchCount = 3;
        }
            for (int batchIdx = 0; batchIdx < retained.size(); batchIdx++) {
            } finally {
            this.batches = batches;
    }
                        sent++;
     * Server-side handler. Produces batches using a thread pool.
                            retained.add(response);
                }
        public List<ActionHandler<? extends ActionRequest, ? extends ActionResponse>> getActions() {
                                queue.put(new TestArrowResponse(root));
                for (int row = 0; row < rowsPerBatch; row++) {
                }
 */
        @Override
            this.parallelism = parallelism;
                    while (sent < request.batchCount) {
 * verifying typed data integrity end-to-end.
                r.getRoot().close();
                assertEquals(4, batch.rowCount);
        assertTrue("Stream should complete within 30s", latch.await(30, TimeUnit.SECONDS));
                assertBatchIntegrity(batch);
import org.opensearch.plugins.ActionPlugin;
        internalCluster().ensureAtLeastNumDataNodes(2);
        }
        }
import java.util.concurrent.BlockingQueue;
        }
    public void testMultipleBatchesSerialNativeArrow() throws Exception {
                null,
                                VectorSchemaRoot root = createBatch(allocator, batchIndex, request.rowsPerBatch);
            listener.onFailure(new UnsupportedOperationException("Use StreamTransportService"));
            )
                @Override
    @LockFeatureFlag(STREAM_TRANSPORT)
import org.opensearch.arrow.transport.ArrowBatchResponse;
import org.opensearch.threadpool.ThreadPool;
import org.apache.arrow.vector.types.pojo.Schema;
                    assertEquals("value survives", batchIdx * 1000 + row, valueVec.get(row));
                    ExecutorService producers = Executors.newFixedThreadPool(request.parallelism);
            for (int i = 0; i < rowCount; i++) {
package org.opensearch.arrow.flight;
            VarCharVector nameVector = (VarCharVector) batch.getVector("name");
        public String executor() {
    /** Deep-copies data out of the Arrow batch so the root can be closed immediately. */
import org.opensearch.transport.TransportRequestOptions;
            latch.countDown();
import org.opensearch.core.common.io.stream.StreamInput;
        // - All 100 batches arrive
    /** Verifies that all rows in a batch have the same batch_id and consistent name/value. */
            super(in);
                this::handleStreamRequest
            // Every retained batch must still have its data intact even though the stream has
                }
            DiscoveryNode node = getClusterState().nodes().iterator().next();
        public TestArrowRequest(int batchCount, int rowsPerBatch, int parallelism) {
            this.batchCount = batchCount;
            // value = batchId * 1000 + rowIndex
        public NativeArrowTestPlugin() {}
            IntVector batchIdVector = (IntVector) root.getVector("batch_id");
        ReceivedBatch(VectorSchemaRoot batch) {
                    // Serial production
                assertEquals("valueCount must survive stream close", rowsPerBatch, batchIdVec.getValueCount());
    static class TestArrowResponseHandler extends ArrowBatchResponseHandler<TestArrowResponse> {
     */
        assertTrue("Stream should complete within 30s", latch.await(30, TimeUnit.SECONDS));
        public ActionRequestValidationException validate() {
 * Tests serial and parallel batch production with zero-copy transfer,
        private final CountDownLatch latch;
    @Override
                        producers.submit(() -> {
        }
        DiscoveryNode node = getClusterState().nodes().iterator().next();
import java.util.List;
import java.util.Set;
            for (TestArrowResponse r : retained) {
    @LockFeatureFlag(STREAM_TRANSPORT)
import org.opensearch.Version;
            super(in);
                FlightStreamPlugin.class.getName(),
            }
            return root;
 * The OpenSearch Contributors require contributions made to
        for (int i = 0; i < batch.rowCount; i++) {
            batchIdVector.allocateNew();
                public String executor() {
                } else {
import org.opensearch.arrow.flight.transport.FlightStreamPlugin;
import org.opensearch.core.action.ActionResponse;
import java.util.concurrent.LinkedBlockingQueue;
                    }
        }
                    } finally {
    }
import org.opensearch.plugins.PluginInfo;
public class NativeArrowTransportIT extends OpenSearchIntegTestCase {
        }
                    for (int batch = 0; batch < request.batchCount; batch++) {
        }
    }
                    // Parallel production: N threads produce batches into a queue,
                        while ((response = streamResponse.nextResponse()) != null) {
                IntVector valueVec = (IntVector) root.getVector("value");
import org.apache.arrow.vector.IntVector;
                nameVector.setSafe(i, ("row-" + batchIndex + "-" + i).getBytes(StandardCharsets.UTF_8));
                        });
                    latch.countDown();
            return ThreadPool.Names.GENERIC;
            super(root);
                    }
        }
    public static class TestArrowAction extends ActionType<TestArrowResponse> {
            TestArrowAction.NAME,
import java.util.concurrent.TimeUnit;
        final List<String> names;
import org.opensearch.arrow.transport.ArrowBatchResponseHandler;
                    CountDownLatch producersDone = new CountDownLatch(request.batchCount);
                channel.sendResponse(e);
            super(TestArrowAction.NAME, actionFilters, streamTransportService.getTaskManager());
                assertEquals("Each batch should have 10 rows", 10, batch.rowCount);
        }
                names.add(new String(nameVector.get(i), StandardCharsets.UTF_8));
                assertEquals("row count must survive stream close", rowsPerBatch, root.getRowCount());
                        final int batchIndex = batch;
        @Inject
            this.batchCount = in.readInt();
    @LockFeatureFlag(STREAM_TRANSPORT)
                }
            VarCharVector nameVector = (VarCharVector) root.getVector("name");
        public static final TestArrowAction INSTANCE = new TestArrowAction();
    @Override
            out.writeInt(parallelism);
import org.opensearch.transport.stream.StreamException;
                batchIds.add(batch.batchId);
            assertEquals("All batch IDs should be unique", 5, batchIds.size());
            assertEquals("batch_id must be consistent across all rows", batch.batchId, batch.batchIds.get(i).intValue());
            this.allocator = nativeAllocator.getPoolAllocator(NativeAllocatorPoolConfig.POOL_FLIGHT)
        super.setUp();
                            } finally {
                "NA",
        private final int batchCount;
        public TestArrowResponse(VectorSchemaRoot root) {
     * reading until after the stream has advanced or been closed.
        final int batchId;
    }
import org.opensearch.action.support.ActionFilters;
        } finally {
            this.rowsPerBatch = rowsPerBatch;
                streamResponse.close();
                    int sent = 0;
        assertNull("No exception expected: " + failure.get(), failure.get());
                FlightStreamPlugin.class.getName(),
            nameVector.allocateNew();
    public static class TestArrowResponse extends ArrowBatchResponse {
        @Override
    public void testSingleBatchNativeArrow() throws Exception {
            List<ReceivedBatch> batches = sendAndReceive(node, 5, 4, 1);
    // ── Inner classes: Action, Request, Response, Handler, Plugin ──
                    assertEquals("batch_id survives", batchIdx, batchIdVec.get(row));
        assertNull("No exception expected: " + failure.get(), failure.get());
import org.opensearch.common.inject.Inject;
            } catch (Exception e) {
/*
            IntVector batchIdVector = (IntVector) batch.getVector("batch_id");
    }
                    // Drain: send batches as they become available
                    for (int batch = 0; batch < request.batchCount; batch++) {
        }
            StreamTransportService streamTransportService,
                        channel.sendResponseBatch(new TestArrowResponse(createBatch(allocator, batch, request.rowsPerBatch)));
            TestArrowAction.NAME,
import static org.opensearch.common.util.FeatureFlags.STREAM_TRANSPORT;
            for (ReceivedBatch batch : batches) {
import com.carrotsearch.randomizedtesting.annotations.ThreadLeakScope;
        List<ReceivedBatch> batches = new ArrayList<>();
                                producersDone.countDown();
import java.util.concurrent.ExecutorService;
                ThreadPool.Names.GENERIC,
            } catch (StreamException e) {
        public void handleStreamResponse(StreamTransportResponse<TestArrowResponse> streamResponse) {
        // 100 batches, 10 rows each, produced by 5 parallel threads.
                    producersDone.await(30, TimeUnit.SECONDS);
        public TestArrowResponse(StreamInput in) throws IOException {
        }
        sts.sendRequest(
     * Collects every batch without reading vector data, fully drains and closes the stream, then
            this.parallelism = in.readInt();
        // - Each batch's data is internally consistent (batch_id matches across all rows)
                        latch.countDown();
        public TestArrowRequest(StreamInput in) throws IOException {
    static class ReceivedBatch {
            assertEquals("Name must match expected pattern", expectedName, batch.names.get(i));
            }
        private TestArrowAction() {
            ArrowNativeAllocator nativeAllocator
    protected Collection<PluginInfo> additionalNodePlugins() {
     * puts it on a queue. The main thread drains the queue and sends
import java.util.concurrent.CountDownLatch;
        public TestArrowResponse read(StreamInput in) throws IOException {
            try {
            } catch (Exception e) {
        private VectorSchemaRoot createBatch(BufferAllocator allocator, int batchIndex, int rowCount) {
            assertEquals("Value must match expected pattern", batch.batchId * 1000 + i, batch.values.get(i).intValue());
        public TransportTestArrowAction(
            }
    /**
            root.setRowCount(rowCount);
/**
import org.opensearch.action.ActionRequest;
                            } catch (Exception e) {
    @LockFeatureFlag(STREAM_TRANSPORT)
import java.util.concurrent.Executors;
import org.opensearch.transport.TransportException;
     * verifies each retained batch still holds its data. Mirrors an async consumer that defers
        AtomicReference<Exception> failure = new AtomicReference<>();
    protected Collection<Class<? extends Plugin>> nodePlugins() {
            List<ReceivedBatch> batches = sendAndReceive(node, 1, 3, 1);
        private final int rowsPerBatch;
            out.writeInt(rowsPerBatch);
                channel.completeStream();
            return List.of(new ActionHandler<>(TestArrowAction.INSTANCE, TransportTestArrowAction.class));
            return new TestArrowResponse(in);
        }
        private final BufferAllocator allocator;
                    } catch (Exception e) {
    @Override
                TestArrowAction.NAME,
     * on the executor thread.
        assertEquals(batchCount, retained.size());
            // advanced and closed.
        {
            this.values = new ArrayList<>();
            assertBatchIntegrity(batch);
            VectorSchemaRoot root = VectorSchemaRoot.create(TEST_SCHEMA, allocator);
import java.util.ArrayList;
    }
            try {
                    producers.shutdown();
    public void testBatchesSurviveStreamAdvanceAndClose() throws Exception {
            }
        StreamTransportService sts = internalCluster().getInstance(StreamTransportService.class);
     * Each producer thread creates a batch with its own child allocator,
            ActionFilters actionFilters,
    }
            new PluginInfo(
            new Field("name", FieldType.nullable(new ArrowType.Utf8()), null),
                    assertEquals("name survives", "row-" + batchIdx + "-" + row, new String(nameVec.get(row), StandardCharsets.UTF_8));
            Set<Integer> batchIds = new HashSet<>();
    }
                    }
        return List.of(NativeArrowTestPlugin.class, ArrowBasePlugin.class);
        private final int parallelism;
import org.opensearch.transport.StreamTransportService;
            IntVector valueVector = (IntVector) batch.getVector("value");
    );
                valueVector.setSafe(i, batchIndex * 1000 + i);
import org.opensearch.transport.TransportChannel;
import java.nio.charset.StandardCharsets;
import java.util.Collection;
    }
        );
                }
                            try {
        );
                    return ThreadPool.Names.GENERIC;
import org.opensearch.plugins.Plugin;
     * batches via sendResponseBatch(). The framework does zero-copy transfer
            super(NAME, TestArrowResponse::new);
        List.of(
import java.io.IOException;
        }
import org.opensearch.tasks.Task;
            failure.set(exp);
            for (int i = 0; i < rowCount; i++) {
            assertEquals(0, batch.batchId);
            assertEquals(3, batch.rowCount);
import org.opensearch.transport.stream.StreamTransportResponse;
                    return new TestArrowResponse(in);
            this.batchIds = new ArrayList<>();
    private void assertBatchIntegrity(ReceivedBatch batch) {
            // name = "row-{batchId}-{rowIndex}"
import java.util.concurrent.atomic.AtomicReference;
        private final AtomicReference<Exception> failure;
                @Override
        }
    // ── Helpers ──
                TestArrowResponse response;
            this.names = new ArrayList<>();
                    try {
                streamResponse.cancel("Test error", e);
                    // main thread drains and sends serially.
 * Integration test for the native Arrow transport path.
        @Override
            new ArrowBatchResponseHandler<TestArrowResponse>() {
            assertEquals("Should receive 100 batches", 100, batches.size());
                batchIds.add(batchIdVector.get(i));
                List.of(ArrowBasePlugin.class.getName()),
        @Override
                "classpath plugin",
                public void handleException(TransportException exp) {
                    failure.set(exp);
}
        @Override
        @Override
                }
        public void writeTo(StreamOutput out) throws IOException {
    private static final Schema TEST_SCHEMA = new Schema(
            for (ReceivedBatch batch : batches) {
                @Override
                while ((response = streamResponse.nextResponse()) != null) {
import java.util.HashSet;
                batchIds.add(batch.batchId);
        }
        final List<Integer> values;
            valueVector.allocateNew();
                        channel.sendResponseBatch(response);
    public static class NativeArrowTestPlugin extends Plugin implements ActionPlugin {
import org.opensearch.arrow.spi.NativeAllocatorPoolConfig;
            new Field("value", FieldType.nullable(new ArrowType.Int(32, true)), null)
    }
        ) {
                        streamResponse.close();
                                throw new RuntimeException(e);
    /**
        // Each batch has a unique batch_id. Verifies:
    }
        StreamTransportService sts = internalCluster().getInstance(StreamTransportService.class);
import org.apache.arrow.vector.types.pojo.FieldType;
            IntVector valueVector = (IntVector) root.getVector("value");
            TransportRequestOptions.builder().withType(TransportRequestOptions.Type.STREAM).build(),
                assertTrue("Batch ID should be in range [0, 100)", batch.batchId >= 0 && batch.batchId < 100);
            this.rowsPerBatch = in.readInt();
    public void testParallelBatchProduction() throws Exception {
import org.apache.arrow.memory.BufferAllocator;
        try {
        return batches;
import org.opensearch.arrow.allocator.ArrowBasePlugin;
                TestArrowRequest::new,
            }
        TestArrowResponseHandler(List<ReceivedBatch> batches, CountDownLatch latch, AtomicReference<Exception> failure) {
                failure.set(e);
        public static final String NAME = "cluster:internal/test/native_arrow";
            assertEquals("All 100 batch IDs must be present (no lost/duplicated batches)", 100, batchIds.size());
        final List<Integer> batchIds;
            this.batchId = rowCount > 0 ? batchIds.get(0) : -1;
import org.opensearch.action.support.TransportAction;
                        TestArrowResponse response = queue.poll(10, TimeUnit.SECONDS);
import org.opensearch.test.OpenSearchIntegTestCase;
 */
            List<ReceivedBatch> batches = sendAndReceive(node, 100, 10, 5);
            }
                        TestArrowResponse response;
        public void handleException(TransportException exp) {
import org.apache.arrow.vector.types.pojo.ArrowType;
                        if (response == null) throw new IOException("Timed out waiting for producer");
            DiscoveryNode node = getClusterState().nodes().iterator().next();
                        batches.add(new ReceivedBatch(batch));
                values.add(valueVector.get(i));
            this.latch = latch;
import org.opensearch.arrow.allocator.ArrowNativeAllocator;
                }
            }
        }
                Version.CURRENT,
import org.apache.arrow.vector.types.pojo.Field;
        sts.sendRequest(
                assertBatchIntegrity(batch);
            }
        }
 *
     */
                false
            new Field("batch_id", FieldType.nullable(new ArrowType.Int(32, true)), null),
    public void setUp() throws Exception {
        CountDownLatch latch = new CountDownLatch(1);
            );
                latch.countDown();
            new TestArrowResponseHandler(batches, latch, failure)
            }
        AtomicReference<Exception> failure = new AtomicReference<>();
import org.opensearch.core.action.ActionListener;
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.SUITE, minNumDataNodes = 2, maxNumDataNodes = 2)
            TransportRequestOptions.builder().withType(TransportRequestOptions.Type.STREAM).build(),
        // - No batch is lost or duplicated
            this.rowCount = batch.getRowCount();
        }
@ThreadLeakScope(ThreadLeakScope.Scope.NONE)
            node,
                        failure.set(e);
            assertEquals("Should receive 1 batch", 1, batches.size());
            DiscoveryNode node = getClusterState().nodes().iterator().next();
    public static class TestArrowRequest extends ActionRequest {
            return null;
 * SPDX-License-Identifier: Apache-2.0
                "1.8",
                            }
            node,
                public void handleStreamResponse(StreamTransportResponse<TestArrowResponse> streamResponse) {
        int rowsPerBatch = 4;
                VectorSchemaRoot root = retained.get(batchIdx).getRoot();
        }
        }
        );
    }
        {
        )
    }
            out.writeInt(batchCount);
            String expectedName = "row-" + batch.batchId + "-" + i;
    public static class TransportTestArrowAction extends TransportAction<TestArrowRequest, TestArrowResponse> {
                batchIdVector.setSafe(i, batchIndex);
            new TestArrowRequest(batchCount, rowsPerBatch, parallelism),
                        }
        return List.of(
            streamTransportService.registerRequestHandler(
    }
import org.opensearch.action.ActionType;
        }
                @Override
        }
                VarCharVector nameVec = (VarCharVector) root.getVector("name");
                if (e.getErrorCode() != StreamErrorCode.CANCELLED) channel.sendResponse(e);
import org.apache.arrow.vector.VectorSchemaRoot;
            assertEquals("Should receive 5 batches", 5, batches.size());
            this.failure = failure;
