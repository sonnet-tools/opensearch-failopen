import java.util.concurrent.CountDownLatch;
            } catch (Exception e) {
        public TestPlugin() {}  
                Version.CURRENT,
                null,
            try {  
        }
        Sink sink = new Sink();
            new Field("batch_id", FieldType.nullable(new ArrowType.Int(32, true)), null),
        @Override
/**
        assertTrue(latch.await(30, TimeUnit.SECONDS));
            this.batchCount = in.readInt();
            ActionFilters actionFilters,  
import org.opensearch.Version;
        int batchesSeen = 0;  
            }  
        }
 * compatible open source license.
import org.opensearch.transport.TransportException;  
            this.profile = in.readBoolean();
import org.opensearch.core.common.io.stream.StreamInput;
import org.opensearch.action.ActionRequest;
                    boolean isLast = (b == request.batchCount - 1);  
                for (int b = 0; b < request.batchCount; b++) {
 *
        @Override
                FlightStreamPlugin.class.getName(),
 * SPDX-License-Identifier: Apache-2.0
 * End-to-end test for {@link ArrowBatchResponse}'s metadata channel: producer attaches  
                stream.cancel("test error", e);
        @Override
import org.opensearch.core.common.io.stream.StreamOutput;  
        assertEquals(dataBatches - 1, sink.metadataBatchIndex);
                    }
    }  
import org.opensearch.arrow.transport.ArrowBatchResponse;
    }
                    sink.dataRowTotal += root.getRowCount();
                    VectorSchemaRoot root = response.getRoot();
import org.opensearch.action.support.TransportAction;  
        private void handle(FragmentRequest request, TransportChannel channel, Task task) throws IOException {
                    retainedRoots.add(root);
        }
                failure.set(e);  
        AtomicReference<Exception> failure = new AtomicReference<>();
import org.opensearch.action.ActionRequestValidationException;  
        }  
    }
        Sink sink = new Sink();
        DiscoveryNode node = getClusterState().nodes().iterator().next();
import org.opensearch.arrow.allocator.ArrowBasePlugin;
                        sink.metadataBatchIndex = idx;
    public void testMetadataAttachedToLastBatch() throws Exception {  
            batchId.setValueCount(rowCount);
        );
        assertEquals(dataBatches, sink.batchesSeen);
import org.opensearch.action.ActionType;
import org.apache.arrow.vector.types.pojo.FieldType;
    static class Sink {
                long totalRows = 0;  
                }  
        int dataBatches = 4;
            )
        @Override  
        assertArrayEquals(expectedMetrics, sink.metrics);  
            super(root);
                    if (isLast && request.profile) {
        sts.sendRequest(  
import org.opensearch.arrow.spi.NativeAllocatorPoolConfig;
    }  
            VectorSchemaRoot root = VectorSchemaRoot.create(DATA_SCHEMA, allocator);
        FragmentRequest(int batchCount, int rowsPerBatch, boolean profile) {  
    }  
                        sink.metadataObservations++;
            );
            TransportRequestOptions.builder().withType(TransportRequestOptions.Type.STREAM).build(),
            this.failure = failure;
        public FragmentResponse read(StreamInput in) throws IOException {  
        assertNull(sink.metrics);
        assertNull(String.valueOf(failure.get()), failure.get());  
        public FragmentResponse(VectorSchemaRoot root, byte[] metadata) {
            new FragmentRequest(dataBatches, rowsPerBatch, false),  
            }  
    @Override
 * opaque bytes to a batch via {@code new ArrowBatchResponse(root, metadata)}; consumer
                }  
        @Inject  
        )
        super.setUp();  
        }
            super(NAME, FragmentResponse::new);
                channel.completeStream();
import org.opensearch.transport.TransportRequestOptions;
import org.apache.arrow.vector.types.pojo.ArrowType;  
            value.allocateNew();
        @Override
import org.opensearch.action.support.ActionFilters;
                if (e.getErrorCode() != StreamErrorCode.CANCELLED) channel.sendResponse(e);  
            IntVector batchId = (IntVector) root.getVector("batch_id");
import org.opensearch.tasks.Task;
                FragmentAction.NAME,
            value.setValueCount(rowCount);
        return List.of(TestPlugin.class, ArrowBasePlugin.class);  
            out.writeInt(batchCount);
            this.latch = latch;  
            ArrowNativeAllocator nativeAllocator
        int dataRowTotal = 0;
            out.writeInt(rowsPerBatch);
import org.opensearch.transport.TransportChannel;
    protected Collection<PluginInfo> additionalNodePlugins() {
        }
import org.opensearch.transport.stream.StreamException;  
}
            super(root, metadata);
 * reads them via {@code response.getMetadata()}. Wire path is Arrow Flight's
import org.opensearch.common.inject.Inject;
        private final int batchCount;
                while ((response = stream.nextResponse()) != null) {
    public void testNoMetadataWhenProfilingDisabled() throws Exception {
        public void writeTo(StreamOutput out) throws IOException {
    }
            listener.onFailure(new UnsupportedOperationException("Use StreamTransportService"));
            } finally {
    protected Collection<Class<? extends Plugin>> nodePlugins() {
            return List.of(new ActionHandler<>(FragmentAction.INSTANCE, TransportFragmentAction.class));
import org.apache.arrow.vector.VectorSchemaRoot;
        }
        protected void doExecute(Task task, FragmentRequest request, ActionListener<FragmentResponse> listener) {  
import java.util.ArrayList;
        }
            latch.countDown();  
        byte[] expectedMetrics = "{\"output_rows\":12,\"elapsed_compute_ns\":12345}".getBytes(StandardCharsets.UTF_8);  
            TransportRequestOptions.builder().withType(TransportRequestOptions.Type.STREAM).build(),
        }  
            this.allocator = nativeAllocator.getPoolAllocator(NativeAllocatorPoolConfig.POOL_FLIGHT)
        private final CountDownLatch latch;  
            super(in);  
            } catch (StreamException e) {
        public void handleException(TransportException exp) {
                "1.8",
        internalCluster().ensureAtLeastNumDataNodes(2);
                batchId.setSafe(i, batchIndex);
        }
        assertTrue(latch.await(30, TimeUnit.SECONDS));
 * {@code putNext(ArrowBuf)}.  
            StreamTransportService streamTransportService,
        public static final String NAME = "cluster:internal/test/fragment_with_metadata";
        }
        assertEquals(0, sink.metadataObservations);
        ) {
    public static class FragmentRequest extends ActionRequest {
import org.opensearch.arrow.transport.ArrowBatchResponseHandler;  
            return null;
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.plugins.ActionPlugin;
    }
                    int idx = sink.batchesSeen++;  
    @Override  
import java.util.concurrent.TimeUnit;  
        StreamTransportService sts = internalCluster().getInstance(StreamTransportService.class);  
            streamTransportService.registerRequestHandler(  
                FragmentRequest::new,  
public class StreamMetadataIT extends OpenSearchIntegTestCase {
                value.setSafe(i, batchIndex * 1000 + i);
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.SUITE, minNumDataNodes = 2, maxNumDataNodes = 2)  
        AtomicReference<Exception> failure = new AtomicReference<>();
        );  
 * The OpenSearch Contributors require contributions made to  
                channel.sendResponse(e);
        }  
        private final List<VectorSchemaRoot> retainedRoots = new ArrayList<>();
            super(in);
    );
        public FragmentRequest(StreamInput in) throws IOException {  
import org.opensearch.plugins.Plugin;
        CollectingHandler(Sink sink, CountDownLatch latch, AtomicReference<Exception> failure) {
        private VectorSchemaRoot createDataBatch(int batchIndex, int rowCount) {  
import java.util.List;
            new FragmentRequest(dataBatches, rowsPerBatch, true),  
        public ActionRequestValidationException validate() {
        private final boolean profile;
            super.writeTo(out);  
                    VectorSchemaRoot root = createDataBatch(b, request.rowsPerBatch);
import org.apache.arrow.memory.BufferAllocator;  
    }
                false  
            out.writeBoolean(profile);  
import java.io.IOException;  
import java.nio.charset.StandardCharsets;
                stream.close();
    }
        CountDownLatch latch = new CountDownLatch(1);  
                    r.close();
        StreamTransportService sts = internalCluster().getInstance(StreamTransportService.class);
import org.opensearch.plugins.PluginInfo;  
            failure.set(exp);
        private final Sink sink;
                List.of(ArrowBasePlugin.class.getName()),
        }
                latch.countDown();
        int rowsPerBatch = 3;
import static org.opensearch.common.util.FeatureFlags.STREAM_TRANSPORT;  
        public String executor() {
                FragmentResponse response;
    public static class TransportFragmentAction extends TransportAction<FragmentRequest, FragmentResponse> {  
    public static class FragmentAction extends ActionType<FragmentResponse> {  
        public FragmentResponse(VectorSchemaRoot root) {  
            super(FragmentAction.NAME, actionFilters, streamTransportService.getTaskManager());  
    }  
    }  
import org.opensearch.arrow.allocator.ArrowNativeAllocator;
        @Override  
                ThreadPool.Names.GENERIC,
    }
        int rowsPerBatch = 5;  
            this.rowsPerBatch = in.readInt();  
                        byte[] metrics = ("{\"output_rows\":" + (totalRows + request.rowsPerBatch) + ",\"elapsed_compute_ns\":12345}")
        CountDownLatch latch = new CountDownLatch(1);  
                        channel.sendResponseBatch(new FragmentResponse(root, metrics));
        public TransportFragmentAction(
import org.apache.arrow.vector.types.pojo.Field;
                "classpath plugin",
        int metadataObservations = 0;
import org.apache.arrow.vector.IntVector;
            this.sink = sink;
    @LockFeatureFlag(STREAM_TRANSPORT)  
                this::handle
                FlightStreamPlugin.class.getName(),  
import org.opensearch.transport.stream.StreamErrorCode;
        public static final FragmentAction INSTANCE = new FragmentAction();
import org.opensearch.transport.stream.StreamTransportResponse;
            root.setRowCount(rowCount);  
        assertNull(String.valueOf(failure.get()), failure.get());  
 */  
        private final int rowsPerBatch;  
        }
            node,
        public FragmentResponse(StreamInput in) throws IOException {
                .newChildAllocator("metadata-test", 0, Long.MAX_VALUE);
        );  
import org.opensearch.test.OpenSearchIntegTestCase;
/*  
            new PluginInfo(  
import org.opensearch.transport.StreamTransportService;
            return new FragmentResponse(in);
        @Override  
                "NA",  
        }  
package org.opensearch.arrow.flight;
            this.batchCount = batchCount;
            this.rowsPerBatch = rowsPerBatch;
    public static class FragmentResponse extends ArrowBatchResponse {
        assertEquals(dataBatches * rowsPerBatch, sink.dataRowTotal);  
            }  
        assertEquals(1, sink.metadataObservations);
                            .getBytes(StandardCharsets.UTF_8);  
            FragmentAction.NAME,
                    if (response.getMetadata() != null) {  
    @LockFeatureFlag(STREAM_TRANSPORT)
                        channel.sendResponseBatch(new FragmentResponse(root));  
        }
    public static class TestPlugin extends Plugin implements ActionPlugin {
        int dataBatches = 3;
                    } else {
        private final BufferAllocator allocator;
        return List.of(
            for (int i = 0; i < rowCount; i++) {  
import org.opensearch.core.action.ActionListener;  
            try {
        public List<ActionHandler<? extends ActionRequest, ? extends ActionResponse>> getActions() {  
            return ThreadPool.Names.GENERIC;
            } catch (Exception e) {
                        sink.metrics = response.getMetadata();  
import org.apache.arrow.vector.types.pojo.Schema;  
import java.util.concurrent.atomic.AtomicReference;
            FragmentAction.NAME,
            node,
                for (VectorSchemaRoot r : retainedRoots)  
import java.util.Collection;  
        byte[] metrics = null;
            return root;
                    totalRows += request.rowsPerBatch;
import org.opensearch.core.action.ActionResponse;
        DiscoveryNode node = getClusterState().nodes().iterator().next();
    private static final Schema DATA_SCHEMA = new Schema(  
        assertEquals(dataBatches * rowsPerBatch, sink.dataRowTotal);  
        assertEquals(dataBatches, sink.batchesSeen);
            IntVector value = (IntVector) root.getVector("value");  
        sts.sendRequest(  
@ThreadLeakScope(ThreadLeakScope.Scope.NONE)
        private final AtomicReference<Exception> failure;
            this.profile = profile;  
 */
import org.opensearch.threadpool.ThreadPool;  
        int metadataBatchIndex = -1;  
            new Field("value", FieldType.nullable(new ArrowType.Int(32, true)), null)  
        @Override
            batchId.allocateNew();
        }  
            new CollectingHandler(sink, latch, failure)
        public void handleStreamResponse(StreamTransportResponse<FragmentResponse> stream) {
        private FragmentAction() {
            new CollectingHandler(sink, latch, failure)
import org.opensearch.arrow.flight.transport.FlightStreamPlugin;  
                    }
    static class CollectingHandler extends ArrowBatchResponseHandler<FragmentResponse> {
import org.opensearch.cluster.node.DiscoveryNode;
        }
    public void setUp() throws Exception {
import com.carrotsearch.randomizedtesting.annotations.ThreadLeakScope;
        List.of(
    @Override
