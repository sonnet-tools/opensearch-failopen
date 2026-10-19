     */
            new Field("batch_id", FieldType.nullable(new ArrowType.Int(32, true)), null),
        assertNull("No exception expected: " + failure.get(), failure.get());  
                latch.countDown();
     * verifies each retained batch still holds its data. Mirrors an async consumer that defers
        private final int batchCount;
        }
    }  
        }
                channel.completeStream();  
        TestArrowResponseHandler(List<ReceivedBatch> batches, CountDownLatch latch, AtomicReference<Exception> failure) {  
        }  
                @Override  
        @Override  
            StreamTransportService streamTransportService,
import org.apache.arrow.vector.VarCharVector;
        private final AtomicReference<Exception> failure;
            this.batchCount = in.readInt();
    public void testParallelBatchProduction() throws Exception {  
        @Override
    /** Deep-copies data out of the Arrow batch so the root can be closed immediately. */
        CountDownLatch latch = new CountDownLatch(1);
 */
                        sent++;  
import org.apache.arrow.memory.BufferAllocator;  
import org.opensearch.transport.stream.StreamErrorCode;  
                }  
                        channel.sendResponseBatch(new TestArrowResponse(createBatch(allocator, batch, request.rowsPerBatch)));
                channel.sendResponse(e);
            for (TestArrowResponse r : retained) {
                assertTrue("Batch ID should be in range [0, 100)", batch.batchId >= 0 && batch.batchId < 100);
                        producers.submit(() -> {  
        public void handleStreamResponse(StreamTransportResponse<TestArrowResponse> streamResponse) {
import org.opensearch.action.support.ActionFilters;  
        }
        assertEquals(batchCount, retained.size());
            new Field("name", FieldType.nullable(new ArrowType.Utf8()), null),  
        public TransportTestArrowAction(
            List<ReceivedBatch> batches = sendAndReceive(node, 1, 3, 1);  
    private void assertBatchIntegrity(ReceivedBatch batch) {  
            return ThreadPool.Names.GENERIC;
                @Override
            IntVector valueVector = (IntVector) batch.getVector("value");
            this.names = new ArrayList<>();
        // Each batch has a unique batch_id. Verifies:
            // name = "row-{batchId}-{rowIndex}"  
                IntVector batchIdVec = (IntVector) root.getVector("batch_id");  
                        });  
            }
                r.getRoot().close();  
            } finally {
            }  
            super(root);
        public ActionRequestValidationException validate() {  
                    CountDownLatch producersDone = new CountDownLatch(request.batchCount);
        }  
import org.opensearch.arrow.transport.ArrowBatchResponse;  
                TestArrowRequest::new,  
                assertEquals("Each batch should have 10 rows", 10, batch.rowCount);
                    latch.countDown();
        }  
import java.nio.charset.StandardCharsets;
                    // Parallel production: N threads produce batches into a queue,
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.SUITE, minNumDataNodes = 2, maxNumDataNodes = 2)  
            super(TestArrowAction.NAME, actionFilters, streamTransportService.getTaskManager());  
            super(in);  
            return List.of(new ActionHandler<>(TestArrowAction.INSTANCE, TransportTestArrowAction.class));
        private VectorSchemaRoot createBatch(BufferAllocator allocator, int batchIndex, int rowCount) {
            this.rowsPerBatch = in.readInt();
     * on the executor thread.
import org.opensearch.plugins.Plugin;  
import org.apache.arrow.vector.VectorSchemaRoot;  
import org.opensearch.Version;
                batchIdVector.setSafe(i, batchIndex);
            assertEquals("Name must match expected pattern", expectedName, batch.names.get(i));
import org.opensearch.arrow.flight.transport.FlightStreamPlugin;
        }
    // ── Tests ──  
            for (int i = 0; i < rowCount; i++) {  
            for (ReceivedBatch batch : batches) {  
    }  
            IntVector batchIdVector = (IntVector) root.getVector("batch_id");
@ThreadLeakScope(ThreadLeakScope.Scope.NONE)
        }  
 *
 * this file be licensed under the Apache-2.0 license or a
                public TestArrowResponse read(StreamInput in) throws IOException {
        private final int rowsPerBatch;
        )
                List.of(ArrowBasePlugin.class.getName()),  
            super.writeTo(out);
        assertTrue("Stream should complete within 30s", latch.await(30, TimeUnit.SECONDS));  
    private List<ReceivedBatch> sendAndReceive(DiscoveryNode node, int batchCount, int rowsPerBatch, int parallelism) throws Exception {
        sts.sendRequest(
    @LockFeatureFlag(STREAM_TRANSPORT)
            } catch (Exception e) {
    /**
                assertEquals("row count must survive stream close", rowsPerBatch, root.getRowCount());
    // ── Helpers ──
                        channel.sendResponseBatch(response);
import org.opensearch.transport.StreamTransportService;
            TransportRequestOptions.builder().withType(TransportRequestOptions.Type.STREAM).build(),
                VarCharVector nameVec = (VarCharVector) root.getVector("name");
            nameVector.allocateNew();  
        ) {
                            }
        @Override
                TestArrowResponse response;  
 * verifying typed data integrity end-to-end.  
                    return new TestArrowResponse(in);  
import com.carrotsearch.randomizedtesting.annotations.ThreadLeakScope;
            )
        @Inject  
            }
        {
            this.batchCount = batchCount;  
 * SPDX-License-Identifier: Apache-2.0
                Version.CURRENT,
                    BlockingQueue<TestArrowResponse> queue = new LinkedBlockingQueue<>();  
                }
        int batchCount = 3;
import org.opensearch.transport.stream.StreamTransportResponse;
            }
                public void handleException(TransportException exp) {  
                        TestArrowResponse response;  
            IntVector valueVector = (IntVector) root.getVector("value");
        }
     * Each producer thread creates a batch with its own child allocator,
    }
                                VectorSchemaRoot root = createBatch(allocator, batchIndex, request.rowsPerBatch);
    }
        public TestArrowResponse(StreamInput in) throws IOException {
            new PluginInfo(
                streamResponse.close();  
            TestArrowAction.NAME,
            } catch (Exception e) {  
        assertTrue("Stream should complete within 30s", latch.await(30, TimeUnit.SECONDS));
        }  
        private final BufferAllocator allocator;
            assertEquals("Value must match expected pattern", batch.batchId * 1000 + i, batch.values.get(i).intValue());
            ReceivedBatch batch = batches.get(0);  
    );  
            this.allocator = nativeAllocator.getPoolAllocator(NativeAllocatorPoolConfig.POOL_FLIGHT)
package org.opensearch.arrow.flight;
                public String executor() {  
                    }
                        TestArrowResponse response = queue.poll(10, TimeUnit.SECONDS);  
                    // main thread drains and sends serially.
            assertEquals("Should receive 1 batch", 1, batches.size());
            this.latch = latch;
        final List<String> names;
        @Override  
                }
            assertEquals("All batch IDs should be unique", 5, batchIds.size());
import org.opensearch.transport.TransportException;
    }
                        streamResponse.cancel("Test error", e);
import org.opensearch.transport.TransportChannel;  
                    // Drain: send batches as they become available  
        );  
import java.util.Set;
            ActionFilters actionFilters,  
        }  
    }  
            out.writeInt(parallelism);
        List<TestArrowResponse> retained = new ArrayList<>();  
            listener.onFailure(new UnsupportedOperationException("Use StreamTransportService"));
            super(in);
                    producers.shutdown();
            assertEquals(3, batch.rowCount);
                        streamResponse.close();
            assertEquals("All 100 batch IDs must be present (no lost/duplicated batches)", 100, batchIds.size());
import org.opensearch.arrow.allocator.ArrowNativeAllocator;  
                        batches.add(new ReceivedBatch(batch));  
            VarCharVector nameVector = (VarCharVector) batch.getVector("name");
        private final int parallelism;  
                                throw new RuntimeException(e);
            this.rowsPerBatch = rowsPerBatch;
            return null;
                values.add(valueVector.get(i));  
            this.parallelism = in.readInt();  
            this.batchIds = new ArrayList<>();  
                failure.set(e);
                names.add(new String(nameVector.get(i), StandardCharsets.UTF_8));
    private static final Schema TEST_SCHEMA = new Schema(  
            valueVector.allocateNew();
                        if (response == null) throw new IOException("Timed out waiting for producer");
        );  
                    try (VectorSchemaRoot batch = response.getRoot()) {
            node,
                    }
                "classpath plugin",  
                .newChildAllocator("native-arrow-test", 0, Long.MAX_VALUE);
                        failure.set(e);
            new Field("value", FieldType.nullable(new ArrowType.Int(32, true)), null)
        public TestArrowRequest(StreamInput in) throws IOException {
                    failure.set(exp);
            assertEquals("Should receive 100 batches", 100, batches.size());
import org.opensearch.core.common.io.stream.StreamInput;  
            this.rowCount = batch.getRowCount();
                @Override
            new TestArrowRequest(batchCount, rowsPerBatch, 1),  
        private final List<ReceivedBatch> batches;
            this.failure = failure;  
        super.setUp();
    public void testBatchesSurviveStreamAdvanceAndClose() throws Exception {  
 */  
                assertBatchIntegrity(batch);
    public static class NativeArrowTestPlugin extends Plugin implements ActionPlugin {
                batchIds.add(batchIdVector.get(i));
            out.writeInt(batchCount);  
        }  
        internalCluster().ensureAtLeastNumDataNodes(2);
            ArrowNativeAllocator nativeAllocator
        StreamTransportService sts = internalCluster().getInstance(StreamTransportService.class);
            }  
        return batches;
            try {  
import java.io.IOException;
                while ((response = streamResponse.nextResponse()) != null) {
                            try {
        final int batchId;
                        while ((response = streamResponse.nextResponse()) != null) {
            super(NAME, TestArrowResponse::new);
 * Tests serial and parallel batch production with zero-copy transfer,
            } catch (StreamException e) {
        int rowsPerBatch = 4;
            this.batchId = rowCount > 0 ? batchIds.get(0) : -1;
                ThreadPool.Names.GENERIC,
import org.opensearch.plugins.PluginInfo;
            return root;  
    }  
            VectorSchemaRoot root = VectorSchemaRoot.create(TEST_SCHEMA, allocator);  
        protected void doExecute(Task task, TestArrowRequest request, ActionListener<TestArrowResponse> listener) {  
import java.util.List;  
    @Override
            List<ReceivedBatch> batches = sendAndReceive(node, 100, 10, 5);
                assertEquals("valueCount must survive stream close", rowsPerBatch, batchIdVec.getValueCount());  
                        final int batchIndex = batch;
            TestArrowAction.NAME,  
            assertBatchIntegrity(batch);  
            failure.set(exp);
import org.opensearch.cluster.node.DiscoveryNode;
        // - All 100 batches arrive  
        CountDownLatch latch = new CountDownLatch(1);
    /** Verifies that all rows in a batch have the same batch_id and consistent name/value. */
        {  
                    }
            // advanced and closed.
import org.apache.arrow.vector.types.pojo.FieldType;  
    }  
     * Collects every batch without reading vector data, fully drains and closes the stream, then
        }  
/*  
            streamTransportService.registerRequestHandler(  
        public static final String NAME = "cluster:internal/test/native_arrow";
     * reading until after the stream has advanced or been closed.  
    @Override
                assertEquals(4, batch.rowCount);
                    try {
import java.util.concurrent.Executors;
import org.opensearch.transport.stream.StreamException;
    public static class TransportTestArrowAction extends TransportAction<TestArrowRequest, TestArrowResponse> {  
                if (request.parallelism <= 1) {
    @LockFeatureFlag(STREAM_TRANSPORT)
        }
import org.apache.arrow.vector.IntVector;
            }
    }  
            }
import org.opensearch.tasks.Task;
                }  
                    assertEquals("batch_id survives", batchIdx, batchIdVec.get(row));
        }
        // - Each batch's data is internally consistent (batch_id matches across all rows)
    public static class TestArrowRequest extends ActionRequest {  
import org.opensearch.core.action.ActionListener;
    static class ReceivedBatch {  
import java.util.concurrent.BlockingQueue;
                        }
        final List<Integer> batchIds;  
            }
    protected Collection<PluginInfo> additionalNodePlugins() {
                batchIds.add(batch.batchId);
            try {
                    // Serial production
import org.opensearch.action.ActionRequest;  
            batchIdVector.allocateNew();
        public String executor() {
import org.opensearch.plugins.ActionPlugin;
        public NativeArrowTestPlugin() {}
            return new TestArrowResponse(in);
                this::handleStreamRequest
        StreamTransportService sts = internalCluster().getInstance(StreamTransportService.class);
            TransportRequestOptions.builder().withType(TransportRequestOptions.Type.STREAM).build(),
        final List<Integer> values;
public class NativeArrowTransportIT extends OpenSearchIntegTestCase {
                    } finally {  
 * compatible open source license.
            for (ReceivedBatch batch : batches) {
    @Override
import java.util.concurrent.ExecutorService;
            Set<Integer> batchIds = new HashSet<>();  
        public static final TestArrowAction INSTANCE = new TestArrowAction();  
                FlightStreamPlugin.class.getName(),
            // value = batchId * 1000 + rowIndex  
                public void handleStreamResponse(StreamTransportResponse<TestArrowResponse> streamResponse) {
import org.opensearch.action.ActionRequestValidationException;
                    while (sent < request.batchCount) {
    }  
import org.opensearch.arrow.spi.NativeAllocatorPoolConfig;
        }
            DiscoveryNode node = getClusterState().nodes().iterator().next();
            String expectedName = "row-" + batch.batchId + "-" + i;
                @Override
     * puts it on a queue. The main thread drains the queue and sends
    protected Collection<Class<? extends Plugin>> nodePlugins() {  
                }
        // - No batch is lost or duplicated
import org.opensearch.action.ActionType;
                assertBatchIntegrity(batch);  
            // Every retained batch must still have its data intact even though the stream has
                            } finally {  
            DiscoveryNode node = getClusterState().nodes().iterator().next();
    }
                    assertEquals("name survives", "row-" + batchIdx + "-" + row, new String(nameVec.get(row), StandardCharsets.UTF_8));  
    @LockFeatureFlag(STREAM_TRANSPORT)
                                queue.put(new TestArrowResponse(root));  
/**  
            IntVector batchIdVector = (IntVector) batch.getVector("batch_id");  
import java.util.concurrent.CountDownLatch;  
 * Integration test for the native Arrow transport path.
        public void writeTo(StreamOutput out) throws IOException {
        List.of(
                    }
    public void setUp() throws Exception {  
import java.util.concurrent.TimeUnit;
        DiscoveryNode node = getClusterState().nodes().iterator().next();
            node,
                VectorSchemaRoot root = retained.get(batchIdx).getRoot();
            root.setRowCount(rowCount);
     * batches via sendResponseBatch(). The framework does zero-copy transfer  
        ReceivedBatch(VectorSchemaRoot batch) {
        List<ReceivedBatch> batches = new ArrayList<>();  
        return List.of(NativeArrowTestPlugin.class, ArrowBasePlugin.class);
            );
import org.opensearch.common.inject.Inject;  
            for (int batchIdx = 0; batchIdx < retained.size(); batchIdx++) {  
        }
            }  
            new TestArrowResponseHandler(batches, latch, failure)  
        final int rowCount;
     */
import org.apache.arrow.vector.types.pojo.ArrowType;
                for (int row = 0; row < rowsPerBatch; row++) {
        assertNull("No exception expected: " + failure.get(), failure.get());
            this.parallelism = parallelism;
        sts.sendRequest(  
import java.util.HashSet;
import java.util.Collection;
import java.util.ArrayList;  
        // 100 batches, 10 rows each, produced by 5 parallel threads.
                    int sent = 0;
        );
            assertEquals(0, batch.batchId);
        private final CountDownLatch latch;  
        return List.of(  
                    for (int batch = 0; batch < request.batchCount; batch++) {  
        }
        {  
    @LockFeatureFlag(STREAM_TRANSPORT)
                    producersDone.await(30, TimeUnit.SECONDS);  
            assertEquals("Should receive 5 batches", 5, batches.size());
        AtomicReference<Exception> failure = new AtomicReference<>();
                "1.8",  
            new TestArrowRequest(batchCount, rowsPerBatch, parallelism),
        public TestArrowRequest(int batchCount, int rowsPerBatch, int parallelism) {
    }
                streamResponse.cancel("Test error", e);  
                if (e.getErrorCode() != StreamErrorCode.CANCELLED) channel.sendResponse(e);
                "NA",
import org.opensearch.transport.TransportRequestOptions;
        for (int i = 0; i < batch.rowCount; i++) {
            Set<Integer> batchIds = new HashSet<>();
                    assertEquals("value survives", batchIdx * 1000 + row, valueVec.get(row));
            out.writeInt(rowsPerBatch);
            assertEquals("batch_id must be consistent across all rows", batch.batchId, batch.batchIds.get(i).intValue());
}
        } finally {
                TestArrowAction.NAME,
                    } catch (Exception e) {  
        public void handleException(TransportException exp) {
    static class TestArrowResponseHandler extends ArrowBatchResponseHandler<TestArrowResponse> {
    /**  
                } else {  
            new ArrowBatchResponseHandler<TestArrowResponse>() {
import org.opensearch.test.OpenSearchIntegTestCase;  
import org.apache.arrow.vector.types.pojo.Field;
        @Override  
                }
import org.opensearch.threadpool.ThreadPool;
                                producersDone.countDown();
    public void testSingleBatchNativeArrow() throws Exception {  
import org.opensearch.action.support.TransportAction;
            latch.countDown();  
        public List<ActionHandler<? extends ActionRequest, ? extends ActionResponse>> getActions() {
                valueVector.setSafe(i, batchIndex * 1000 + i);  
        }
        }
import java.util.concurrent.LinkedBlockingQueue;  
                nameVector.setSafe(i, ("row-" + batchIndex + "-" + i).getBytes(StandardCharsets.UTF_8));
                        // Collect references WITHOUT reading vector data — defer that until after close.
            DiscoveryNode node = getClusterState().nodes().iterator().next();
                FlightStreamPlugin.class.getName(),
        }
import org.opensearch.arrow.allocator.ArrowBasePlugin;
                    }
        private TestArrowAction() {  
            List<ReceivedBatch> batches = sendAndReceive(node, 5, 4, 1);
import java.util.concurrent.atomic.AtomicReference;
                        latch.countDown();
        @Override
 * The OpenSearch Contributors require contributions made to  
    // ── Inner classes: Action, Request, Response, Handler, Plugin ──  
        @Override  
     * Server-side handler. Produces batches using a thread pool.  
    public void testMultipleBatchesSerialNativeArrow() throws Exception {
                IntVector valueVec = (IntVector) root.getVector("value");
    }
    }
    }
        }
                            retained.add(response);  
                    return ThreadPool.Names.GENERIC;
                    ExecutorService producers = Executors.newFixedThreadPool(request.parallelism);
            VarCharVector nameVector = (VarCharVector) root.getVector("name");  
import org.opensearch.core.common.io.stream.StreamOutput;
import static org.opensearch.common.util.FeatureFlags.STREAM_TRANSPORT;
        @Override  
                }
            this.batches = batches;
import org.opensearch.arrow.transport.ArrowBatchResponseHandler;
            for (int i = 0; i < rowCount; i++) {  
    public static class TestArrowAction extends ActionType<TestArrowResponse> {
            this.values = new ArrayList<>();
        try {  
        }  
        public TestArrowResponse(VectorSchemaRoot root) {  
import org.apache.arrow.vector.types.pojo.Schema;
                null,
                            } catch (Exception e) {
        private void handleStreamRequest(TestArrowRequest request, TransportChannel channel, Task task) throws IOException {
    }  
        AtomicReference<Exception> failure = new AtomicReference<>();
        public TestArrowResponse read(StreamInput in) throws IOException {  
                false
                batchIds.add(batch.batchId);  
import org.opensearch.core.action.ActionResponse;
    public static class TestArrowResponse extends ArrowBatchResponse {
                    for (int batch = 0; batch < request.batchCount; batch++) {
