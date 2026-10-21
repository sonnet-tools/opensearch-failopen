        public ActionRequestValidationException validate() {
        private final Sink sink;
            );
        Sink sink = new Sink();
            this.rowsPerBatch = rowsPerBatch;
            out.writeInt(rowsPerBatch);
        int dataBatches = 3;
        private final CountDownLatch latch;
 *
            new FragmentRequest(dataBatches, rowsPerBatch, true),
        }
                Version.CURRENT,
import org.opensearch.transport.TransportException;
            } finally {
        public FragmentResponse read(StreamInput in) throws IOException {
        int dataRowTotal = 0;
                        channel.sendResponseBatch(new FragmentResponse(root));
        @Override
                        channel.sendResponseBatch(new FragmentResponse(root, metrics));
        public String executor() {
        assertEquals(dataBatches, sink.batchesSeen);
                FragmentAction.NAME,
            value.allocateNew();
        Sink sink = new Sink();
        assertEquals(1, sink.metadataObservations);
    public static class FragmentAction extends ActionType<FragmentResponse> {
        @Inject
            super.writeTo(out);
                failure.set(e);
            }
                    } else {
public class StreamMetadataIT extends OpenSearchIntegTestCase {
        @Override
            TransportRequestOptions.builder().withType(TransportRequestOptions.Type.STREAM).build(),
        public FragmentResponse(StreamInput in) throws IOException {
import org.opensearch.transport.stream.StreamTransportResponse;
        protected void doExecute(Task task, FragmentRequest request, ActionListener<FragmentResponse> listener) {
 * this file be licensed under the Apache-2.0 license or a
        public static final String NAME = "cluster:internal/test/fragment_with_metadata";
import org.opensearch.arrow.transport.ArrowBatchResponseHandler;
        private final AtomicReference<Exception> failure;
                FlightStreamPlugin.class.getName(),
                        sink.metadataObservations++;
                "NA",
        int rowsPerBatch = 5;
                for (VectorSchemaRoot r : retainedRoots)
            latch.countDown();
            FragmentAction.NAME,
    public void setUp() throws Exception {
            out.writeBoolean(profile);
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.SUITE, minNumDataNodes = 2, maxNumDataNodes = 2)
import org.apache.arrow.vector.types.pojo.Field;
import org.opensearch.action.support.TransportAction;
            try {
                "classpath plugin",
import org.opensearch.plugins.ActionPlugin;
        }
        }
 */
        }
        }
                    VectorSchemaRoot root = response.getRoot();
        ) {
import org.opensearch.core.common.io.stream.StreamOutput;
        )
        }
                .newChildAllocator("metadata-test", 0, Long.MAX_VALUE);
            node,
            }
            this.batchCount = in.readInt();
            new Field("batch_id", FieldType.nullable(new ArrowType.Int(32, true)), null),
import java.io.IOException;
 * reads them via {@code response.getMetadata()}. Wire path is Arrow Flight's
        assertTrue(latch.await(30, TimeUnit.SECONDS));
        assertEquals(0, sink.metadataObservations);
        byte[] expectedMetrics = "{\"output_rows\":12,\"elapsed_compute_ns\":12345}".getBytes(StandardCharsets.UTF_8);
                latch.countDown();
        assertArrayEquals(expectedMetrics, sink.metrics);
        CountDownLatch latch = new CountDownLatch(1);
        FragmentRequest(int batchCount, int rowsPerBatch, boolean profile) {
            this.profile = in.readBoolean();
import org.opensearch.plugins.PluginInfo;
        public FragmentResponse(VectorSchemaRoot root, byte[] metadata) {
        private final List<VectorSchemaRoot> retainedRoots = new ArrayList<>();
        @Override
            ArrowNativeAllocator nativeAllocator
        private final BufferAllocator allocator;
import org.opensearch.action.ActionType;
        byte[] metrics = null;
import org.opensearch.transport.stream.StreamErrorCode;
        int batchesSeen = 0;
            super(in);
                batchId.setSafe(i, batchIndex);
        private final boolean profile;
import org.opensearch.transport.stream.StreamException;
        public void handleException(TransportException exp) {
        assertTrue(latch.await(30, TimeUnit.SECONDS));
        StreamTransportService sts = internalCluster().getInstance(StreamTransportService.class);
import org.opensearch.action.support.ActionFilters;
import org.opensearch.arrow.allocator.ArrowNativeAllocator;
        return List.of(
            this.failure = failure;
    @LockFeatureFlag(STREAM_TRANSPORT)
            return new FragmentResponse(in);
import org.opensearch.core.common.io.stream.StreamInput;
import org.opensearch.Version;
        }
/**
                null,
            batchId.setValueCount(rowCount);
            ActionFilters actionFilters,
 * End-to-end test for {@link ArrowBatchResponse}'s metadata channel: producer attaches
import org.opensearch.arrow.flight.transport.FlightStreamPlugin;
            } catch (Exception e) {
        sts.sendRequest(
            StreamTransportService streamTransportService,
            this.batchCount = batchCount;
import org.apache.arrow.vector.IntVector;
    }
        DiscoveryNode node = getClusterState().nodes().iterator().next();
        List.of(
        AtomicReference<Exception> failure = new AtomicReference<>();
import org.opensearch.transport.TransportRequestOptions;
        public FragmentResponse(VectorSchemaRoot root) {
            return null;
            return ThreadPool.Names.GENERIC;
            super(NAME, FragmentResponse::new);
import org.opensearch.action.ActionRequest;
        CountDownLatch latch = new CountDownLatch(1);
    public void testNoMetadataWhenProfilingDisabled() throws Exception {
                    if (response.getMetadata() != null) {
        }
        }
            } catch (Exception e) {
        public FragmentRequest(StreamInput in) throws IOException {
            TransportRequestOptions.builder().withType(TransportRequestOptions.Type.STREAM).build(),
            streamTransportService.registerRequestHandler(
                for (int b = 0; b < request.batchCount; b++) {
import org.apache.arrow.vector.types.pojo.Schema;
            this.sink = sink;
import org.apache.arrow.memory.BufferAllocator;
import java.util.concurrent.atomic.AtomicReference;
            this.rowsPerBatch = in.readInt();
import org.opensearch.threadpool.ThreadPool;
@ThreadLeakScope(ThreadLeakScope.Scope.NONE)
        public void handleStreamResponse(StreamTransportResponse<FragmentResponse> stream) {
        );
            super(root);
        assertEquals(dataBatches - 1, sink.metadataBatchIndex);
                while ((response = stream.nextResponse()) != null) {
        }
            return root;
                FlightStreamPlugin.class.getName(),
    );
import java.nio.charset.StandardCharsets;
    public void testMetadataAttachedToLastBatch() throws Exception {
    public static class FragmentResponse extends ArrowBatchResponse {
package org.opensearch.arrow.flight;
        assertNull(sink.metrics);
            value.setValueCount(rowCount);
        }
        DiscoveryNode node = getClusterState().nodes().iterator().next();
            IntVector batchId = (IntVector) root.getVector("batch_id");
        @Override
            root.setRowCount(rowCount);
                channel.sendResponse(e);
                    sink.dataRowTotal += root.getRowCount();
 * The OpenSearch Contributors require contributions made to
            try {
        super.setUp();
    }
import org.opensearch.transport.TransportChannel;
import org.opensearch.cluster.node.DiscoveryNode;
        );
import java.util.Collection;
                stream.cancel("test error", e);
        }
                        byte[] metrics = ("{\"output_rows\":" + (totalRows + request.rowsPerBatch) + ",\"elapsed_compute_ns\":12345}")
    protected Collection<PluginInfo> additionalNodePlugins() {
import org.opensearch.core.action.ActionResponse;
                    totalRows += request.rowsPerBatch;
            } catch (StreamException e) {
    }
                    boolean isLast = (b == request.batchCount - 1);
    }
                    r.close();
    static class CollectingHandler extends ArrowBatchResponseHandler<FragmentResponse> {
            )
import java.util.concurrent.CountDownLatch;
                }
        sts.sendRequest(
            node,
import java.util.List;
        public TestPlugin() {}
        public static final FragmentAction INSTANCE = new FragmentAction();
    }
            super(root, metadata);
            new FragmentRequest(dataBatches, rowsPerBatch, false),
        }
import org.opensearch.arrow.allocator.ArrowBasePlugin;
            new PluginInfo(
    }
        }
import org.opensearch.action.ActionRequestValidationException;
        assertEquals(dataBatches * rowsPerBatch, sink.dataRowTotal);
            failure.set(exp);
    protected Collection<Class<? extends Plugin>> nodePlugins() {
                    }
    @Override
        private final int rowsPerBatch;
        private FragmentAction() {
 * SPDX-License-Identifier: Apache-2.0
}
    }
        @Override
    }
        int metadataObservations = 0;
import org.opensearch.plugins.Plugin;
            return List.of(new ActionHandler<>(FragmentAction.INSTANCE, TransportFragmentAction.class));
import org.opensearch.tasks.Task;
                false
                if (e.getErrorCode() != StreamErrorCode.CANCELLED) channel.sendResponse(e);
        }
        assertNull(String.valueOf(failure.get()), failure.get());
        int rowsPerBatch = 3;
    public static class TestPlugin extends Plugin implements ActionPlugin {
    @Override
                stream.close();
import java.util.ArrayList;
            }
            IntVector value = (IntVector) root.getVector("value");
            batchId.allocateNew();
        @Override
        @Override
            this.profile = profile;
import org.opensearch.common.inject.Inject;
                long totalRows = 0;
        CollectingHandler(Sink sink, CountDownLatch latch, AtomicReference<Exception> failure) {
import org.opensearch.arrow.spi.NativeAllocatorPoolConfig;
            new CollectingHandler(sink, latch, failure)
        assertEquals(dataBatches, sink.batchesSeen);
        public TransportFragmentAction(
                    }
 * {@code putNext(ArrowBuf)}.
                this::handle
                FragmentResponse response;
import org.apache.arrow.vector.VectorSchemaRoot;
 */
                }
        assertNull(String.valueOf(failure.get()), failure.get());
        public List<ActionHandler<? extends ActionRequest, ? extends ActionResponse>> getActions() {
        int dataBatches = 4;
                    retainedRoots.add(root);
                "1.8",
                        sink.metadataBatchIndex = idx;
import org.apache.arrow.vector.types.pojo.FieldType;
            super(FragmentAction.NAME, actionFilters, streamTransportService.getTaskManager());
        public void writeTo(StreamOutput out) throws IOException {
    @Override
                            .getBytes(StandardCharsets.UTF_8);
        @Override
        AtomicReference<Exception> failure = new AtomicReference<>();
            FragmentAction.NAME,
        private final int batchCount;
    private static final Schema DATA_SCHEMA = new Schema(
    public static class TransportFragmentAction extends TransportAction<FragmentRequest, FragmentResponse> {
    }
            for (int i = 0; i < rowCount; i++) {
    @LockFeatureFlag(STREAM_TRANSPORT)
        private void handle(FragmentRequest request, TransportChannel channel, Task task) throws IOException {
        private VectorSchemaRoot createDataBatch(int batchIndex, int rowCount) {
    }
/*
            listener.onFailure(new UnsupportedOperationException("Use StreamTransportService"));
        }
        int metadataBatchIndex = -1;
import com.carrotsearch.randomizedtesting.annotations.ThreadLeakScope;
        assertEquals(dataBatches * rowsPerBatch, sink.dataRowTotal);
        StreamTransportService sts = internalCluster().getInstance(StreamTransportService.class);
            new Field("value", FieldType.nullable(new ArrowType.Int(32, true)), null)
                List.of(ArrowBasePlugin.class.getName()),
import org.opensearch.test.OpenSearchIntegTestCase;
        internalCluster().ensureAtLeastNumDataNodes(2);
            super(in);
        }
                channel.completeStream();
 * opaque bytes to a batch via {@code new ArrowBatchResponse(root, metadata)}; consumer
 * compatible open source license.
import org.opensearch.core.action.ActionListener;
            new CollectingHandler(sink, latch, failure)
                    if (isLast && request.profile) {
import org.opensearch.transport.StreamTransportService;
import static org.opensearch.common.util.FeatureFlags.STREAM_TRANSPORT;
    }
                    int idx = sink.batchesSeen++;
    public static class FragmentRequest extends ActionRequest {
                ThreadPool.Names.GENERIC,
        }
    static class Sink {
import org.opensearch.arrow.transport.ArrowBatchResponse;
            out.writeInt(batchCount);
import org.apache.arrow.vector.types.pojo.ArrowType;
                    VectorSchemaRoot root = createDataBatch(b, request.rowsPerBatch);
                FragmentRequest::new,
import java.util.concurrent.TimeUnit;
            this.latch = latch;
                value.setSafe(i, batchIndex * 1000 + i);
    }
        return List.of(TestPlugin.class, ArrowBasePlugin.class);
            this.allocator = nativeAllocator.getPoolAllocator(NativeAllocatorPoolConfig.POOL_FLIGHT)
        );
                        sink.metrics = response.getMetadata();
            VectorSchemaRoot root = VectorSchemaRoot.create(DATA_SCHEMA, allocator);
