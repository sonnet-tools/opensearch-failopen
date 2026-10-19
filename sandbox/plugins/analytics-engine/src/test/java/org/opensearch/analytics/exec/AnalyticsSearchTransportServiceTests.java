import org.opensearch.test.OpenSearchTestCase;
        ClusterService clusterService = mock(ClusterService.class);
     * — NOT a NullPointerException ("Cannot invoke Object.hashCode() because key is null") that escapes
        IntVector vec = (IntVector) vsr.getVector(name);
        DiscoveryNode target = mock(DiscoveryNode.class);
 * {@link AnalyticsSearchTransportService#dispatchFragmentStreaming} — specifically that a batch
        DiscoveryNode node = mock(DiscoveryNode.class);
    private TransportResponseHandler<FragmentExecutionArrowResponse> captureHandler(  
import org.apache.arrow.vector.types.pojo.Field;  
import org.apache.arrow.vector.types.pojo.Schema;
            @SuppressWarnings("unchecked")
 * Verifies fragment handler registration and the stream-drain ownership contract in  
            assertTrue("prefetched-but-undelivered root buffers must be freed", isClosed(nextRoot));  
            // loop, so only the consumer is responsible for it — close it here to avoid the test leaking.
        new AnalyticsSearchTransportService(
    }
import static org.mockito.Mockito.when;  
 */  
        vsr.setRowCount(1);
            any(),
import org.opensearch.analytics.exec.action.FragmentExecutionRequest;
                handlerCaptor.capture()
                any(),  
                    throw new RuntimeException("consumer failed mid-stream");
import org.opensearch.threadpool.ThreadPool;  
import static org.mockito.ArgumentMatchers.any;
    public void testPrefetchedRootReleasedWhenConsumerThrows() throws Exception {
            handler.handleStreamResponse(stream);  
import org.mockito.ArgumentCaptor;
import static org.mockito.Mockito.never;
            verify(stream).cancel(anyString(), any());  
 * The OpenSearch Contributors require contributions made to  
            thrown instanceof NullPointerException || thrown.getCause() instanceof NullPointerException  
                any(Transport.Connection.class),
import static org.mockito.Mockito.mock;  
     * Node churn: the target node has left the cluster by the time we dispatch (a null
            "must not be a NullPointerException (got " + thrown + ")",
        vec.allocateNew(1);  
        );
            any(),  
        StreamTransportService transportService = mock(StreamTransportService.class);
/*  
        VectorSchemaRoot vsr = VectorSchemaRoot.create(schema, allocator);
    private static VectorSchemaRoot newIntRoot(BufferAllocator allocator, String name, int value) {
            TransportResponseHandler<FragmentExecutionArrowResponse> handler = captureHandler(new StreamingResponseListener<>() {
        );
        );  
            .sendChildRequest(
 * released when the stream fails mid-drain. Otherwise its claimed Arrow root (POOL_FLIGHT buffers)  
            transportService,
import org.opensearch.tasks.TaskResourceTrackingService;
        IndicesService indicesService = mock(IndicesService.class);  
    ) {
            if (!isClosed(lastRoot)) {  
    }  
     * from the connection manager. Guards the production NPE seen under node churn.
        service.dispatchFragmentStreaming(
            verify(stream, never()).close();
        Schema schema = new Schema(singletonList(field));  
        // dispatch looks up the connection directly from the passed DiscoveryNode (no cluster-state re-resolution).
                public void onFailure(Exception e) {}  
        Transport.Connection conn = mock(Transport.Connection.class);
            FragmentExecutionArrowResponse next = new FragmentExecutionArrowResponse(nextRoot);
     */
import org.opensearch.cluster.service.ClusterService;
 * this file be licensed under the Apache-2.0 license or a
        assertFalse("handler must have been dispatched to sendChildRequest", handlers.isEmpty());  
            taskResourceTrackingService
     * prefetched batch it never delivered. That batch's root must be closed by the loop's finally —
import org.apache.arrow.memory.RootAllocator;
            target,
import java.util.List;
import static org.mockito.Mockito.doAnswer;
import org.opensearch.analytics.exec.action.FragmentExecutionArrowResponse;
        );  
            clusterService,
        when(transportService.getConnection(target)).thenReturn(mock(Transport.Connection.class));
        );
 * prefetched (read one ahead, to compute {@code isLast}) but never delivered to the consumer is
        List<TransportResponseHandler<FragmentExecutionArrowResponse>> handlers = handlerCaptor.getAllValues();
import static org.mockito.Mockito.verify;
        IndicesService indicesService = mock(IndicesService.class);
            });
            // the producer's streamRoot in the allocator ledger.
import static org.mockito.ArgumentMatchers.anyBoolean;
            VectorSchemaRoot nextRoot = newIntRoot(root, "b", 2);  
            mock(Task.class),  
        when(target.getId()).thenReturn("node-1");  
            clusterService,
        try (RootAllocator root = new RootAllocator(Long.MAX_VALUE)) {  
        IndicesService indicesService = mock(IndicesService.class);  
            anyBoolean(),
                @Override  
            FragmentExecutionArrowResponse last = new FragmentExecutionArrowResponse(lastRoot);
import org.apache.arrow.memory.BufferAllocator;
                }  
            indicesService,
        TransportService regularTransportService = mock(TransportService.class);  
        @SuppressWarnings("unchecked")
import org.opensearch.transport.stream.StreamTransportResponse;  
 * SPDX-License-Identifier: Apache-2.0
 * compatible open source license.
            indicesService,  
import org.opensearch.cluster.node.DiscoveryNode;  
    }
            searchService,
        ClusterService clusterService = mock(ClusterService.class);
            regularTransportService,
            transportService,
import static org.mockito.ArgumentMatchers.eq;
        return vsr.getFieldVectors().stream().allMatch(v -> v.getBufferSize() == 0);
        TransportService regularTransportService = mock(TransportService.class);
            new PendingExecutions(1),
            listener,
import org.opensearch.indices.IndicesService;
            taskResourceTrackingService
            mock(FragmentExecutionRequest.class),  
            // The undelivered prefetch is closed by the loop; the delivered batch's ownership left the
        );
public class AnalyticsSearchTransportServiceTests extends OpenSearchTestCase {  
            // Consumer threw mid-stream → abnormal exit → cancel() (not plain close()) so the data-node  
        AnalyticsSearchService searchService = mock(AnalyticsSearchService.class);
            taskResourceTrackingService  
/**
            null
        AnalyticsSearchTransportService service = new AnalyticsSearchTransportService(  
            VectorSchemaRoot lastRoot = newIntRoot(root, "a", 1);
        AnalyticsSearchTransportService service = new AnalyticsSearchTransportService(
            StreamTransportResponse<FragmentExecutionArrowResponse> stream = mock(StreamTransportResponse.class);
        assertSame(conn, service.getConnection(node));
        assertFalse(
        // Capture the handler instead of actually sending.
import org.apache.arrow.vector.VectorSchemaRoot;
import org.opensearch.transport.TransportResponseHandler;
            regularTransportService,  
            searchService,
     * {@code stream.close()} only frees the cursor, not the already-claimed response root.  
            any()
        // And a present node is looked up directly via the stream transport (no cluster-state re-resolution).  
import org.opensearch.analytics.exec.action.FragmentExecutionAction;  
        StreamTransportService transportService = mock(StreamTransportService.class);  
import static java.util.Collections.singletonList;  
            indicesService,  
        TransportService regularTransportService = mock(TransportService.class);
        return vsr;  
import static org.mockito.ArgumentMatchers.anyString;  
    }
            when(stream.nextResponse()).thenReturn(last, next, null);  
            eq(ThreadPool.Names.SAME),  
            clusterService,  
        ClusterService clusterService = mock(ClusterService.class);  
    }
 */
        vec.set(0, value);
            anyBoolean(),
 *
     */  
        Exception thrown = expectThrows(ConnectTransportException.class, () -> service.getConnection(null));  
import org.opensearch.transport.Transport;  
    /**
        return handlers.get(handlers.size() - 1);
            // producer is notified and tears down its FlightServerChannel; close() alone would strand
        }
import org.apache.arrow.vector.types.pojo.FieldType;
                eq(FragmentExecutionAction.NAME),  
        );
import org.opensearch.transport.ConnectTransportException;
    private static boolean isClosed(VectorSchemaRoot vsr) {
            regularTransportService,  
            );
        TaskResourceTrackingService taskResourceTrackingService = mock(TaskResourceTrackingService.class);
            // last: delivered to the consumer (which throws). next: prefetched, never delivered.
                @Override
    public void testFragmentHandlerRegisteredWithSameExecutor() {
            TransportResponseHandler.class  
        TaskResourceTrackingService taskResourceTrackingService = mock(TaskResourceTrackingService.class);
    /** A closed VectorSchemaRoot has released its buffers — its vectors report zero buffer size. */  
            // next was prefetched and never delivered, so the drain loop's finally must release it.
        StreamTransportService transportService = mock(StreamTransportService.class);  
            }
        when(transportService.getConnection(node)).thenReturn(conn);  
        doAnswer(inv -> null).when(transportService)  
        Field field = new Field(name, FieldType.nullable(new ArrowType.Int(32, true)), null);
    /** Builds and registers the service, captures the streaming handler passed to sendChildRequest. */
            transportService,
 * would leak on every failed query.
import org.apache.arrow.vector.IntVector;  
}
import org.opensearch.tasks.Task;  
        StreamingResponseListener<FragmentExecutionArrowResponse> listener
    public void testGetConnectionWithNullNodeThrowsConnectExceptionNotNpe() {
import org.opensearch.transport.TransportService;
        AnalyticsSearchService searchService = mock(AnalyticsSearchService.class);
     * {@link DiscoveryNode}). The connection lookup must surface a clean {@link ConnectTransportException}  
        TaskResourceTrackingService taskResourceTrackingService = mock(TaskResourceTrackingService.class);
import org.opensearch.transport.StreamTransportService;
        AnalyticsSearchService searchService = mock(AnalyticsSearchService.class);
                lastRoot.close();
     * When the consumer's {@code onStreamResponse} throws mid-drain, the drain loop owns a
                public boolean onStreamResponse(FragmentExecutionArrowResponse response, boolean isLast) {
                any(),
package org.opensearch.analytics.exec;
            searchService,
        verify(transportService).registerRequestHandler(
        ArgumentCaptor<TransportResponseHandler<FragmentExecutionArrowResponse>> handlerCaptor = ArgumentCaptor.forClass(
            eq(FragmentExecutionAction.NAME),
    /**  
    }  
                any(),
import org.apache.arrow.vector.types.pojo.ArrowType;
