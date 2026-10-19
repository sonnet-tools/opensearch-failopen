                        // Worker fragments may have an empty response stream when their output
                    channelResponseHandler(channel),  
        DiscoveryNode targetNode,  
        // shard fragment handler — upstream renamed the stream-transport field to
                    FragmentExecutionArrowResponse current;  
     * the batch, which gates the next {@code stream.nextResponse} call and propagates  
        this.streamingTransportService = streamingTransportService;
                } finally {
        this.transportService = transportService;  
                        boolean keepReading = listener.onStreamResponse(delivering, isLast);
                    try {
                    ContextAwareExecutor.wrap(  
            public void onFailure(Exception e) {
                            && next.getRoot() != null  
    }
                "analytics-engine requires the STREAM_TRANSPORT feature flag to be enabled "
                    // Release any batches the loop still owns and never delivered.
                    pending.finishAndRunNext();
        };  
                    @Override
        TransportService transportService,
     */
        return streamingTransportService;
        if (node == null) {
            }
    public void dispatchFetchByRowIds(
                (AnalyticsShardTask) task,
                return ThreadPool.Names.SAME;  
        DiscoveryNode targetNode,  
    }
import org.opensearch.analytics.exec.action.FragmentExecutionArrowResponse;
                    ContextAwareExecutor.wrap(
import org.opensearch.core.common.io.stream.StreamInput;
     *  
            ThreadPool.Names.SEARCH,
            @Override
                        next = stream.nextResponse();  
                if (batchSchema != null && batchAllocator != null) {  
                    // On an abnormal exit, cancel() (not close()) so the data-node producer tears down
                                next = null;
            // ConnectTransportException instead of letting a null node reach the connection
            // Permit consumed — a worker dispatch always attempts the send (no stillNeeded gate),  
                        } catch (Exception ignored) {}
                            // Sentinel = clean end-of-stream; producer is already completing.
                    request.getSortColumn(),  
            FetchByRowIdsRequest::new,
                }
import org.opensearch.transport.TransportChannel;
            public void handleStreamResponse(StreamTransportResponse<FragmentExecutionArrowResponse> stream) {
            WorkerFragmentExecutionAction.NAME,
                    if (last != null) {
                transportService.getThreadPool().executor(ThreadPool.Names.SEARCH)
                }
package org.opensearch.analytics.exec;
            false,
     * Shared streaming dispatch path for {@link FragmentExecutionAction} and  
                        // fires onResponse(null) and the producer stage transitions to SUCCEEDED.
                    (AnalyticsShardTask) task,
    }
        AnalyticsSearchService searchService,
        } catch (Exception ignore) {}
                );
        AnalyticsSearchService searchService,
                // Set true only on an expected end (full drain or sentinel). Any other exit leaves it  
        AnalyticsSearchService searchService,
        TransportService transportService,
        }
     * the handler skips {@code IndicesService.getShard} and reader acquisition entirely.
        // Can-match is a unary RPC — regular transport, not the stream transport (batches only).
                            listener.onStreamComplete(next.getMetadata());
                        if (e instanceof StreamException se && se.getErrorCode() == StreamErrorCode.CANCELLED) {  
            }  
                    }  
        Task parentTask,
                        root.close();  
                        // Null our ref before the call so a throw can't make finally double-close it.
    @Inject
        });  
                } catch (Exception sendException) {
                    pending.finishAndRunNext();  
    ) {
            AnalyticsCanMatchRequest::new,
            @Override
            WorkerFragmentRequest::new,
        DiscoveryNode targetNode,
                    while (last != null) {
        );
                        transportService.getThreadPool()  
                    } else {
        TransportRequest request,
                        // is fully consumed by the coord-reduce sink rather than streamed back.  
                    public void onFailure(Exception e) {
                        listener.onStreamResponse(new FragmentExecutionArrowResponse((VectorSchemaRoot) null), true);
                    // Loop exited because nextResponse() returned null — the stream drained fully.
        // MPP hash-shuffle worker fragments ride the STREAM transport (batched results), same as the  
     * Registers the worker-fragment streaming handler. Sibling of
     * response. Shared by the streaming-fragment and fetch-by-rowids handlers — the dispatch
                    (AnalyticsShardTask) task,
    private static void registerStreamingFragmentHandler(  
            try {  
                                channel.sendResponse(new AnalyticsCanMatchResponse(true));
            public boolean skipsDeserialization() {  
                    public void onComplete() {  
                    + FeatureFlags.STREAM_TRANSPORT  
     */
import org.opensearch.transport.stream.StreamErrorCode;
    }
        StreamTransportService transportService,  
 * Stateless transport dispatch component for fragment requests. Owns the
                            try {
            public void handleException(TransportException e) {
@Singleton
                    throw e;
    }
        dispatchStreaming(FetchByRowIdsAction.NAME, request, targetNode, listener, parentTask, pending, null);
                        if (last != null) {  
                    batchSchema = root.getSchema();
import org.opensearch.analytics.exec.action.FetchByRowIdsAction;
                if (batchSchema == null && root.getFieldVectors().isEmpty() == false) {
                            return;  
            AdmissionControlActionType.SEARCH,  
            }
                    pending.finishAndRunNext();
            @Override
                        // output goes peer-to-peer via AnalyticsShuffleDataAction, or is fully
                            && next.getMetadata() != null;
            }
                    parentTask,
                        e.addSuppressed(ce);
                            last = null;
                    closeResponseQuietly(next);  
                    listener.onStreamResponse(response, true);
                // finally can release any undelivered prefetch on failure (stream.close() frees only
                            terminatedCleanly = true;
                        boolean nextIsSentinel = next != null
    private final ClusterService clusterService;  
                        // Stream may already be cancelled — close sentinel to prevent leak  
                try {  
            @Override
        return streamingTransportService.getConnection(node);
                }
                    }  
            throw new IllegalStateException(  
                        channel.sendResponseBatch(new FragmentExecutionArrowResponse(sentinel, metrics));
        StreamingResponseListener<FragmentExecutionArrowResponse> listener,
 * compatible open source license.
                    try {
                try {  
    public TransportService getTransportService() {
                            terminatedCleanly = true;
import org.opensearch.index.shard.IndexShard;
public class AnalyticsSearchTransportService {
            }
        transportService.registerRequestHandler(
                        transportService.getThreadPool().executor(ThreadPool.Names.SEARCH),
                        stream.close();
            }  
            public String executor() {
import org.opensearch.transport.TransportRequestOptions;
            }
                    request,  
        StreamingResponseListener<FragmentExecutionArrowResponse> listener,
        IndicesService indicesService
                                channel.sendResponse(response);
            AnalyticsCanMatchAction.NAME,  
import org.opensearch.transport.Transport;
                    if (last == null) {
     */
                return new FragmentExecutionArrowResponse(in);  
                }  
                } finally {  
                // the cursor, not claimed roots).  
                            next.getRoot().close();  
import org.opensearch.common.inject.Inject;  
import org.opensearch.tasks.Task;
import org.opensearch.analytics.exec.action.WorkerFragmentRequest;
import org.opensearch.indices.IndicesService;  
        StreamTransportService streamingTransportService,
                    + "("
                try {
            (request, channel, task) -> searchService.executeWorkerFragmentStreamingAsync(
                            last.getRoot().close();  
            try {
                    pending.finishAndRunNext();
            // manager, where it NPEs ("Cannot invoke Object.hashCode() because key is null").
        StreamingResponseListener<FragmentExecutionArrowResponse> listener,
    }  
        BooleanSupplier stillNeeded
            public void onCompleteWithMetrics(byte[] metrics) {
    ) {  
 * connection lookup.  
                            }
                            }
                } catch (Exception e) {
        Task parentTask,
                searchService.canMatch(
                    listener.onFailure(e);
            if (stillNeeded != null && stillNeeded.getAsBoolean() == false) {  
                    closeResponseQuietly(last);
                            channel.sendResponse(e);
                    pending.finishAndRunNext();  
            // The target left the cluster between planning and dispatch. Surface a clean  
                FragmentExecutionArrowResponse last = null;
                        // Consumer takes ownership of `last` (it closes the root on all its paths).
                            if (!isLast && next != null) {
        PendingExecutions pending  
import org.opensearch.tasks.TaskResourceTrackingService;  
import org.opensearch.analytics.exec.action.WorkerFragmentExecutionAction;
     * Forks the iterator drain onto the SEARCH executor via  
                try {
                                if (next.getRoot() != null) next.getRoot().close();  
        WorkerFragmentRequest request,
                        }
                    connection,
            AdmissionControlActionType.SEARCH,
import org.opensearch.analytics.exec.action.FragmentExecutionAction;
 * their own {@link PendingExecutions} instance to gate dispatch concurrency.  
    ) {
                    listener.onFailure(AnalyticsTransportErrors.fromWireError(e));  
                        boolean isLast = next == null || nextIsSentinel;  
    /**
            }  
            private Schema batchSchema = null;
            public FragmentExecutionArrowResponse read(StreamInput in) throws IOException {
            ThreadPool.Names.SAME,  
            public void handleResponse(FragmentExecutionArrowResponse response) {
                // On success Flight takes ownership of root. If sendResponseBatch throws (e.g. the
                        listener.onStreamResponse(new FragmentExecutionArrowResponse((VectorSchemaRoot) null), true);
                IndexShard shard = indicesService.indexServiceSafe(request.getShardId().getIndex()).getShard(request.getShardId().id());  
                        // Treat sentinel as end-of-stream: the current batch is the last real data batch.
        IndicesService indicesService,
 */  
                            return;  
                    request,  
 *
        AnalyticsSearchService searchService,
    private static void closeResponseQuietly(FragmentExecutionArrowResponse response) {
                } finally {
            );
                }
    ) {
            public void handleResponse(FragmentExecutionArrowResponse response) {
                        if (nextIsSentinel) {
import org.apache.arrow.memory.BufferAllocator;
                    }  
            } catch (Exception e) {
                            listener.onStreamComplete(last.getMetadata());
                    }
            true,  
                    pending.finishAndRunNext();
            @Override  
    }
}
                return ThreadPool.Names.SAME;
                    channelResponseHandler(channel),
                        } else {
import java.util.function.BooleanSupplier;
                    last = stream.nextResponse();
            public void onBatch(EngineResultBatch batch) throws Exception {
        pending.tryRun(() -> {
     * because {@code listener.onStreamResponse} blocks until the downstream sink accepts
    private static void registerWorkerFragmentHandler(StreamTransportService transportService, AnalyticsSearchService searchService) {  
                        // coordinator's stage-execution listener fires onResponse(null) and the
                    }
                    handler  
                    listener.onFailure(AnalyticsTransportErrors.fromWireError(e));
        transportService.registerRequestHandler(
            (request, channel, task) -> {  
                    VectorSchemaRoot sentinel = VectorSchemaRoot.create(batchSchema, batchAllocator);
            FetchByRowIdsAction.NAME,
    /**
                searchService.executeFetchByRowIdsAsync(
import org.opensearch.analytics.exec.action.FragmentExecutionRequest;  
import org.opensearch.transport.TransportRequest;
                boolean terminatedCleanly = false;
/*  
                }
                        next = null;  
     * Dispatches a QTF fetch-by-rowids RPC to {@code targetNode}. Mirrors
                        return;  
                request,  
                    new ActionListener<>() {
                }
                channel.completeStream();
                        transportService.getThreadPool().executor(ThreadPool.Names.SEARCH),
 *
    /** Closes a response's claimed Arrow root if present, swallowing close failures. */  
        try {
                            } catch (IOException e) {  
import org.opensearch.cluster.service.ClusterService;
                        channel.completeStream();
                    shard,  
                    shard,  
                        }
    }  
                    + "=true)"
            @Override  
 * this file be licensed under the Apache-2.0 license or a
            // so it never declines back to PendingExecutions.
                    try {  
                    // its FlightServerChannel; close() alone frees only this cursor and strands the
            )  
                        last = current;  
        TransportResponseHandler<FragmentExecutionArrowResponse> handler = new TransportResponseHandler<>() {
import org.opensearch.transport.stream.StreamException;  
                        FragmentExecutionArrowResponse delivering = last;  
                    FragmentExecutionArrowResponse last = null;
        registerWorkerFragmentHandler(this.streamingTransportService, searchService);  
        BooleanSupplier stillNeeded
                    pending.finishAndRunNext();  
            }
            }
                    }
                        // Profiling sentinel: 0 rows with metadata attached. Deliver metrics and exit.  
                        if (nextIsSentinel) {  
                        }
            public void handleStreamResponse(StreamTransportResponse<FragmentExecutionArrowResponse> stream) {
     * channel — the response shape is identical (Arrow streaming), only the request differs.
                        last = next;
        StreamTransportService transportService,
                            stream.close();  
        );
        Task parentTask,
            }  
        pending.tryRun(() -> {  
                new AnalyticsSearchService.StreamingFragmentResponseHandler() {
            false,
                } finally {  
                        }
import org.opensearch.ratelimitting.admissioncontrol.enums.AdmissionControlActionType;
                } finally {
    private static void registerFetchByRowIdsHandler(
        FragmentExecutionRequest request,  
    private final StreamTransportService streamingTransportService;
     * {@link AnalyticsSearchService#executeFetchByRowIdsAsync} so a slow coordinator parks
     * a search thread, not the transport thread, and the engine sees natural backpressure
                }  
                        }
    public void dispatchWorkerFragmentStreaming(
                return true;
    }
                        if (terminatedCleanly) {
        transportService.registerRequestHandler(
                    channel.sendResponseBatch(new FragmentExecutionArrowResponse(root));  
            public FragmentExecutionArrowResponse read(StreamInput in) throws IOException {
        }  
    ) {
                } finally {
                        if (!keepReading) {
        };  
                try {  
                }
                    while ((current = stream.nextResponse()) != null) {
import org.opensearch.analytics.exec.canmatch.AnalyticsCanMatchRequest;
                }  
        return new AnalyticsSearchService.StreamingFragmentResponseHandler() {  
        registerStreamingFragmentHandler(this.streamingTransportService, searchService, indicesService);
    ) {  
        if (response == null || response.getRoot() == null) {
                return new FragmentExecutionArrowResponse(in);
     * through the blocking {@code channel.sendResponseBatch} call.  
     * channel streaming API. Each batch is sent on the channel; onComplete completes the  
                    listener.onStreamResponse(response, true);  
                    throw new RuntimeException(sendException);  
            return true;
        return transportService;  
        // streamingTransportService when it introduced the regular transport for can-match.
                        // stage transitions to SUCCEEDED.  
            @Override
                        public void onResponse(AnalyticsCanMatchResponse response) {  
import org.opensearch.transport.stream.StreamTransportResponse;
                                // nothing more we can do
                        }  
                            // Consumer stopped early (satisfied or stage failed); the finally cancels  
                    terminatedCleanly = true;  
                            return;  
                        // Hash-shuffle producer / worker fragments stream zero responses (their  
        dispatchStreaming(FragmentExecutionAction.NAME, request, targetNode, listener, parentTask, pending, stillNeeded);
    private void dispatchStreaming(  
     * per-node concurrency window.
import org.opensearch.cluster.node.DiscoveryNode;
            }
        IndicesService indicesService  
                            stream.cancel("analytics stream aborted before clean end-of-stream", null);
        registerFetchByRowIdsHandler(this.streamingTransportService, searchService, indicesService);
        searchService.setTaskResourceTrackingService(taskResourceTrackingService);
    }
 * The OpenSearch Contributors require contributions made to  
        Task parentTask,  
        TransportRequestOptions options = TransportRequestOptions.builder().withType(TransportRequestOptions.Type.STREAM).build();
                    request.getBackendId(),
                    @Override  
                );
                // stream already closed after a mid-stream failure), Flight never took ownership, so  
                        @Override
import org.opensearch.transport.TransportService;
     * {@link #registerStreamingFragmentHandler}, but for fragments that have no shard scan —  
            private BufferAllocator batchAllocator = null;
                    )  
            throw new ConnectTransportException(null, "target node left the cluster before dispatch");  
            }
            public void handleException(TransportException e) {
        DiscoveryNode targetNode,  
        TransportResponseHandler<FragmentExecutionArrowResponse> handler = new TransportResponseHandler<>() {  
            }
                // hold what the loop still owns; null each the instant ownership transfers so the
     *                    or {@code null} to always send. {@code false} abandons the send — nothing
                    try {  
                }  
                    options,
            }  
                    }
                        // consumed by the coord-reduce sink rather than streamed back). Synthesize
                    shard,
                return false;
    /**
        TaskResourceTrackingService taskResourceTrackingService  
                        // a final null-payload isLast=true so the stage's response listener still  
                    pending.finishAndRunNext();  
            AdmissionControlActionType.SEARCH,  
    ) {
                streamingTransportService.sendChildRequest(  
            @Override
                } catch (Exception e) {  
    /**
            @Override
    }
     * Adapter from {@link AnalyticsSearchService.StreamingFragmentResponseHandler} to the
                    }
                } finally {
                    public void onBatch(EngineResultBatch batch) throws Exception {
import org.opensearch.transport.TransportResponseHandler;  
                    )
                    @Override
                    sentinel.setRowCount(0);
                IndexShard shard = indicesService.indexServiceSafe(request.getShardId().getIndex()).getShard(request.getShardId().id());
            response.getRoot().close();  
                    } catch (Exception ce) {
    /**
                    listener.onFailure(e);
                    }
                searchService.executeFragmentStreamingAsync(
                            try {
            } catch (Exception e) {  
            @Override  
/**  
    Transport.Connection getConnection(DiscoveryNode node) {
            }
            true,
                        public void onFailure(Exception e) {  
 * <p>Does NOT track per-query or per-node concurrency state — callers provide
                                onFailure(e);
                try {
                } catch (Exception e) {
                streamingTransportService.sendChildRequest(connection, actionName, request, parentTask, options, handler);
                VectorSchemaRoot root = batch.getArrowRoot();  
            return true;
                );
            @Override
    }
                            } catch (IOException ioe) {  
        String actionName,
     *                    {@code ShardTaskRunner}, where earlier shards' results can make a later
import java.io.IOException;  
     * Dispatches a worker-fragment request to the target node. Sibling of  
            public String executor() {  
     * @param stillNeeded last-moment check, run immediately before the send once a permit is granted,
    private final TransportService transportService;
     * name routes the request to {@link FetchByRowIdsAction} on the data node.
import org.opensearch.threadpool.ThreadPool;
     * stream; onFailure ignores cancellation and forwards everything else as an exception
        TransportRequestOptions options = TransportRequestOptions.builder().withType(TransportRequestOptions.Type.STREAM).build();
     */
        };
                        }  
    }  
                return true;
            @Override  
                    } catch (Exception ignore) {}
                            }
    private static AnalyticsSearchService.StreamingFragmentResponseHandler channelResponseHandler(TransportChannel channel) {
 * @opensearch.internal
                    }
                        last = null;
     * {@link FetchByRowIdsAction}. Drains the response stream inline — backpressure flows
                    request,
            public boolean skipsDeserialization() {
     * {@link #dispatchFragmentStreaming} but for the {@link WorkerFragmentExecutionAction}
                            && next.getRoot().getRowCount() == 0
import org.opensearch.analytics.backend.EngineResultBatch;
                );
            @Override
import org.opensearch.analytics.exec.task.AnalyticsShardTask;  
     * gRPC flow control back to the data node.
            }
                }
                // false so the finally cancel()s the stream rather than just closing the cursor.
     *                    goes on the wire and {@code listener} is never invoked. Checked this late  
        registerCanMatchHandler(this.transportService, searchService, indicesService);  
                        @Override
                    } catch (Exception ignore) {}
            false,
            FragmentExecutionRequest::new,
    /**
        });
        FetchByRowIdsRequest request,
    /** Regular (non-stream) transport used for the unary can-match RPC. */
            @Override  
            }
                        }  
            FragmentExecutionAction.NAME,  
            }
                channel.completeStream();
    ) {
                        // Synthesize a final null-payload, isLast=true response so the
     * Mirrors {@link #registerStreamingFragmentHandler} for the QTF fetch-by-rowids path.
 */  
     */
        );  
                // We own each claimed response root until it's handed to the consumer. `last`/`next`  
                        if (last.getRoot() != null && last.getRoot().getRowCount() == 0 && last.getMetadata() != null) {
    public AnalyticsSearchTransportService(  
                            return;
                        // task before the profile snapshot fires.  
                            next = null;
                try {
            (request, channel, task) -> {  
 *
            @Override
    public StreamTransportService getStreamingTransportService() {  
                        // Deliver metrics BEFORE signalling isLast so they're stored on the
            }
import org.opensearch.transport.TransportException;  
                        transportService.getThreadPool()
                        try {  
    public void dispatchFragmentStreaming(
                            listener.onStreamResponse(last, false);
                    listener.onFailure(AnalyticsTransportErrors.fromWireError(e));
     * Dispatches a fragment-execution RPC to {@code targetNode}, subject to {@code pending}'s
            ThreadPool.Names.SAME,  
import org.opensearch.analytics.exec.canmatch.AnalyticsCanMatchResponse;
import org.opensearch.common.util.FeatureFlags;
            @Override
                    channel.sendResponse(AnalyticsTransportErrors.toWireError(e));
import org.opensearch.transport.ConnectTransportException;
     * {@link #dispatchFragmentStreaming} — same streaming-response handler shape, same  
            ThreadPool.Names.SAME,
    /**  
                try {
                try {  
            true,
import org.opensearch.core.action.ActionListener;  
            }  
            }
import org.opensearch.analytics.exec.action.FetchByRowIdsRequest;  
                Transport.Connection connection = getConnection(targetNode);
    private static void registerCanMatchHandler(  
        ClusterService clusterService,  
                    request.getFilterBytes(),
     */  
     *                    shard provably irrelevant.  
                IndexShard shard = indicesService.indexServiceSafe(request.getShardId().getIndex()).getShard(request.getShardId().id());
                try {  
                        }
                        sentinel.close();
                Transport.Connection connection = getConnection(targetNode);
                // close root here to avoid leaking the imported batch.
                    batchAllocator = root.getFieldVectors().getFirst().getAllocator();  
                } finally {
import org.apache.arrow.vector.VectorSchemaRoot;
        IndicesService indicesService  
import org.opensearch.analytics.exec.canmatch.AnalyticsCanMatchAction;  
        PendingExecutions pending,  
 * {@link StreamTransportService} (analytics-engine is streaming-only) and
     * shape is identical, only the request type differs.  
            return;  
                    // producer's streamRoot. Mirrors core StreamSearchTransportService.  
     * {@link PendingExecutions} gating, same cancellation propagation. Different action
                FragmentExecutionArrowResponse next = null;
     */  
                    WorkerFragmentExecutionAction.NAME,
                    listener.onFailure(e);
                        channel.sendResponseBatch(new FragmentExecutionArrowResponse(batch.getArrowRoot()));
 * SPDX-License-Identifier: Apache-2.0
            public void onComplete() {  
     *                    because the reason to abandon usually appears while the request waits: see
        PendingExecutions pending  
                },
        transportService.registerRequestHandler(
import org.opensearch.transport.StreamTransportService;  
                    } catch (Exception e) {
            (request, channel, task) -> {
        }
    }
        if (streamingTransportService == null) {
        StreamingResponseListener<FragmentExecutionArrowResponse> listener,
import org.opensearch.common.inject.Singleton;
        PendingExecutions pending,
        );
                        listener.onStreamResponse(last, true);  
        this.clusterService = clusterService;
import org.apache.arrow.vector.types.pojo.Schema;  
                            // the stream. Release any undelivered prefetch first.
