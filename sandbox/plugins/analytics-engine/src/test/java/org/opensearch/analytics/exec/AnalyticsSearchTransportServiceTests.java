        service.dispatchFragmentStreaming(
        AnalyticsSearchService searchService = mock(AnalyticsSearchService.class);
            taskResourceTrackingService
        TaskResourceTrackingService taskResourceTrackingService = mock(TaskResourceTrackingService.class);
 * would leak on every failed query.
import org.apache.arrow.vector.VectorSchemaRoot;
/*
     * When the consumer's {@code onStreamResponse} throws mid-drain, the drain loop owns a
        when(target.getId()).thenReturn("node-1");
        IndicesService indicesService = mock(IndicesService.class);
    }
    /** A closed VectorSchemaRoot has released its buffers — its vectors report zero buffer size. */
        List<TransportResponseHandler<FragmentExecutionArrowResponse>> handlers = handlerCaptor.getAllValues();
import org.opensearch.cluster.service.ClusterService;
public class AnalyticsSearchTransportServiceTests extends OpenSearchTestCase {
    ) {
import org.apache.arrow.vector.types.pojo.Schema;
import org.opensearch.transport.stream.StreamTransportResponse;
import org.opensearch.transport.TransportResponseHandler;
import org.opensearch.transport.ConnectTransportException;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doAnswer;
            searchService,
            // the producer's streamRoot in the allocator ledger.
            null
        IndicesService indicesService = mock(IndicesService.class);
            );
     */
            VectorSchemaRoot lastRoot = newIntRoot(root, "a", 1);
                    throw new RuntimeException("consumer failed mid-stream");
 *
            regularTransportService,
        assertFalse("handler must have been dispatched to sendChildRequest", handlers.isEmpty());
import org.opensearch.analytics.exec.action.FragmentExecutionArrowResponse;
            .sendChildRequest(
            when(stream.nextResponse()).thenReturn(last, next, null);
            listener,
            VectorSchemaRoot nextRoot = newIntRoot(root, "b", 2);
    /**
        AnalyticsSearchTransportService service = new AnalyticsSearchTransportService(
        StreamTransportService transportService = mock(StreamTransportService.class);
            clusterService,
import org.apache.arrow.memory.BufferAllocator;
                any(),
            transportService,
                any(Transport.Connection.class),
            mock(Task.class),
        ClusterService clusterService = mock(ClusterService.class);
            anyBoolean(),
 */
            taskResourceTrackingService
        DiscoveryNode target = mock(DiscoveryNode.class);
import org.apache.arrow.vector.types.pojo.Field;
        TransportService regularTransportService = mock(TransportService.class);
import static org.mockito.Mockito.when;
            }
        vec.set(0, value);
import org.opensearch.tasks.TaskResourceTrackingService;
        verify(transportService).registerRequestHandler(
            regularTransportService,
        AnalyticsSearchService searchService = mock(AnalyticsSearchService.class);
        );
            indicesService,
}
        new AnalyticsSearchTransportService(
        TransportService regularTransportService = mock(TransportService.class);
    }
        );
        AnalyticsSearchService searchService = mock(AnalyticsSearchService.class);
import org.apache.arrow.vector.IntVector;
            regularTransportService,
    /** Builds and registers the service, captures the streaming handler passed to sendChildRequest. */
            // loop, so only the consumer is responsible for it — close it here to avoid the test leaking.
 * compatible open source license.
        StreamTransportService transportService = mock(StreamTransportService.class);
        );
    private static VectorSchemaRoot newIntRoot(BufferAllocator allocator, String name, int value) {
            FragmentExecutionArrowResponse last = new FragmentExecutionArrowResponse(lastRoot);
import static org.mockito.ArgumentMatchers.anyBoolean;
 * released when the stream fails mid-drain. Otherwise its claimed Arrow root (POOL_FLIGHT buffers)
 * The OpenSearch Contributors require contributions made to
            // last: delivered to the consumer (which throws). next: prefetched, never delivered.
            taskResourceTrackingService
            transportService,
            any(),
    private static boolean isClosed(VectorSchemaRoot vsr) {
            transportService,
            });
        // Capture the handler instead of actually sending.
            // next was prefetched and never delivered, so the drain loop's finally must release it.
import org.opensearch.analytics.exec.action.FragmentExecutionAction;
     * {@link DiscoveryNode}). The connection lookup must surface a clean {@link ConnectTransportException}
import static org.mockito.ArgumentMatchers.anyString;
        }
                eq(FragmentExecutionAction.NAME),
import org.opensearch.analytics.exec.action.FragmentExecutionRequest;
        VectorSchemaRoot vsr = VectorSchemaRoot.create(schema, allocator);
            thrown instanceof NullPointerException || thrown.getCause() instanceof NullPointerException
                public void onFailure(Exception e) {}
package org.opensearch.analytics.exec;
            indicesService,
    }
        TransportService regularTransportService = mock(TransportService.class);
            clusterService,
            // The undelivered prefetch is closed by the loop; the delivered batch's ownership left the
                @Override
import static org.mockito.ArgumentMatchers.eq;
            clusterService,
            eq(ThreadPool.Names.SAME),
        Exception thrown = expectThrows(ConnectTransportException.class, () -> service.getConnection(null));
     * {@code stream.close()} only frees the cursor, not the already-claimed response root.
        );
import static org.mockito.Mockito.mock;
            if (!isClosed(lastRoot)) {
            // producer is notified and tears down its FlightServerChannel; close() alone would strand
import org.opensearch.threadpool.ThreadPool;
import org.apache.arrow.memory.RootAllocator;
import org.opensearch.tasks.Task;
            eq(FragmentExecutionAction.NAME),
        ClusterService clusterService = mock(ClusterService.class);
            assertTrue("prefetched-but-undelivered root buffers must be freed", isClosed(nextRoot));
        assertSame(conn, service.getConnection(node));
import static java.util.Collections.singletonList;
            // Consumer threw mid-stream → abnormal exit → cancel() (not plain close()) so the data-node
            any(),
import org.opensearch.indices.IndicesService;
            TransportResponseHandler<FragmentExecutionArrowResponse> handler = captureHandler(new StreamingResponseListener<>() {
import org.apache.arrow.vector.types.pojo.ArrowType;
 * Verifies fragment handler registration and the stream-drain ownership contract in
import org.opensearch.test.OpenSearchTestCase;
        AnalyticsSearchTransportService service = new AnalyticsSearchTransportService(
        assertFalse(
/**
        IndicesService indicesService = mock(IndicesService.class);
        Transport.Connection conn = mock(Transport.Connection.class);
                any(),
            TransportResponseHandler.class
            searchService,
    }
        StreamTransportService transportService = mock(StreamTransportService.class);
import java.util.List;
        DiscoveryNode node = mock(DiscoveryNode.class);
        );
        doAnswer(inv -> null).when(transportService)
        StreamingResponseListener<FragmentExecutionArrowResponse> listener
    }
                @Override
                public boolean onStreamResponse(FragmentExecutionArrowResponse response, boolean isLast) {
 * this file be licensed under the Apache-2.0 license or a
            verify(stream).cancel(anyString(), any());
     * prefetched batch it never delivered. That batch's root must be closed by the loop's finally —
            indicesService,
    /**
        vsr.setRowCount(1);
            target,
            "must not be a NullPointerException (got " + thrown + ")",
                lastRoot.close();
        Field field = new Field(name, FieldType.nullable(new ArrowType.Int(32, true)), null);
        when(transportService.getConnection(node)).thenReturn(conn);
import static org.mockito.Mockito.verify;
            handler.handleStreamResponse(stream);
        TaskResourceTrackingService taskResourceTrackingService = mock(TaskResourceTrackingService.class);
            @SuppressWarnings("unchecked")
        try (RootAllocator root = new RootAllocator(Long.MAX_VALUE)) {
        return handlers.get(handlers.size() - 1);
 * SPDX-License-Identifier: Apache-2.0
        @SuppressWarnings("unchecked")
            any()
                }
     * — NOT a NullPointerException ("Cannot invoke Object.hashCode() because key is null") that escapes
            new PendingExecutions(1),
            searchService,
            StreamTransportResponse<FragmentExecutionArrowResponse> stream = mock(StreamTransportResponse.class);
        IntVector vec = (IntVector) vsr.getVector(name);
        );
    private TransportResponseHandler<FragmentExecutionArrowResponse> captureHandler(
    }
        return vsr;
            verify(stream, never()).close();
        when(transportService.getConnection(target)).thenReturn(mock(Transport.Connection.class));
        vec.allocateNew(1);
import org.opensearch.cluster.node.DiscoveryNode;
            mock(FragmentExecutionRequest.class),
        // And a present node is looked up directly via the stream transport (no cluster-state re-resolution).
            anyBoolean(),
    public void testPrefetchedRootReleasedWhenConsumerThrows() throws Exception {
 * prefetched (read one ahead, to compute {@code isLast}) but never delivered to the consumer is
 * {@link AnalyticsSearchTransportService#dispatchFragmentStreaming} — specifically that a batch
import org.mockito.ArgumentCaptor;
import static org.mockito.Mockito.never;
import org.apache.arrow.vector.types.pojo.FieldType;
            FragmentExecutionArrowResponse next = new FragmentExecutionArrowResponse(nextRoot);
    public void testFragmentHandlerRegisteredWithSameExecutor() {
                any(),
        return vsr.getFieldVectors().stream().allMatch(v -> v.getBufferSize() == 0);
 */
        );
        Schema schema = new Schema(singletonList(field));
        TaskResourceTrackingService taskResourceTrackingService = mock(TaskResourceTrackingService.class);
        ClusterService clusterService = mock(ClusterService.class);
    public void testGetConnectionWithNullNodeThrowsConnectExceptionNotNpe() {
import org.opensearch.transport.TransportService;
        ArgumentCaptor<TransportResponseHandler<FragmentExecutionArrowResponse>> handlerCaptor = ArgumentCaptor.forClass(
        // dispatch looks up the connection directly from the passed DiscoveryNode (no cluster-state re-resolution).
import org.opensearch.transport.StreamTransportService;
                handlerCaptor.capture()
     */
import org.opensearch.transport.Transport;
     * Node churn: the target node has left the cluster by the time we dispatch (a null
     * from the connection manager. Guards the production NPE seen under node churn.
