            public void onComplete() {
            }
                            stream.cancel("analytics stream aborted before clean end-of-stream", null);
            private BufferAllocator batchAllocator = null;
        TransportService transportService,
                        // Synthesize a final null-payload, isLast=true response so the
     *                    shard provably irrelevant.
                try {
                    try {
                    FragmentExecutionArrowResponse last = null;
                    request.getBackendId(),
                        next = null;
            @Override
        AnalyticsSearchService searchService,
                    // its FlightServerChannel; close() alone frees only this cursor and strands the
        FragmentExecutionRequest request,
     * the batch, which gates the next {@code stream.nextResponse} call and propagates
import org.opensearch.cluster.service.ClusterService;
                            } catch (IOException ioe) {
                    // producer's streamRoot. Mirrors core StreamSearchTransportService.
    ) {
        BooleanSupplier stillNeeded
        TransportRequest request,
            WorkerFragmentRequest::new,
                Transport.Connection connection = getConnection(targetNode);
    private void dispatchStreaming(
                    listener.onFailure(e);
import org.opensearch.analytics.exec.action.FetchByRowIdsAction;
     * per-node concurrency window.
                            next.getRoot().close();
        PendingExecutions pending,
                    sentinel.setRowCount(0);
                Transport.Connection connection = getConnection(targetNode);
            (request, channel, task) -> {
                                onFailure(e);
                        boolean keepReading = listener.onStreamResponse(delivering, isLast);
            ThreadPool.Names.SAME,
                    channelResponseHandler(channel),
        TransportResponseHandler<FragmentExecutionArrowResponse> handler = new TransportResponseHandler<>() {
            @Override
            AdmissionControlActionType.SEARCH,
            @Override
            (request, channel, task) -> searchService.executeWorkerFragmentStreamingAsync(
                            // Consumer stopped early (satisfied or stage failed); the finally cancels
                    @Override
import org.opensearch.transport.TransportException;
     * Dispatches a worker-fragment request to the target node. Sibling of
                // finally can release any undelivered prefetch on failure (stream.close() frees only
            true,
import java.io.IOException;
            throw new ConnectTransportException(null, "target node left the cluster before dispatch");
                    options,
            @Override
            }
    public StreamTransportService getStreamingTransportService() {
                    throw new RuntimeException(sendException);
                (AnalyticsShardTask) task,
            @Override
            @Override
import org.opensearch.analytics.exec.action.FragmentExecutionRequest;
    private static void registerWorkerFragmentHandler(StreamTransportService transportService, AnalyticsSearchService searchService) {
        return streamingTransportService.getConnection(node);
        );
        Task parentTask,
                        }
            );
public class AnalyticsSearchTransportService {
                        // is fully consumed by the coord-reduce sink rather than streamed back.
    ) {
                        // fires onResponse(null) and the producer stage transitions to SUCCEEDED.
            }
                    batchSchema = root.getSchema();
        // shard fragment handler — upstream renamed the stream-transport field to
     *                    because the reason to abandon usually appears while the request waits: see
                        @Override
import org.opensearch.tasks.TaskResourceTrackingService;
        };
                            if (!isLast && next != null) {
            // The target left the cluster between planning and dispatch. Surface a clean
                            listener.onStreamComplete(next.getMetadata());
        pending.tryRun(() -> {
            public String executor() {
                "analytics-engine requires the STREAM_TRANSPORT feature flag to be enabled "
        StreamingResponseListener<FragmentExecutionArrowResponse> listener,
            }
import org.opensearch.transport.TransportRequestOptions;
                            last.getRoot().close();
                            last = null;
                }
                    + FeatureFlags.STREAM_TRANSPORT
    private final ClusterService clusterService;
            WorkerFragmentExecutionAction.NAME,
    }
                IndexShard shard = indicesService.indexServiceSafe(request.getShardId().getIndex()).getShard(request.getShardId().id());
                    while ((current = stream.nextResponse()) != null) {
                return false;
    }
                                next = null;
                IndexShard shard = indicesService.indexServiceSafe(request.getShardId().getIndex()).getShard(request.getShardId().id());
                            }
import org.opensearch.analytics.exec.action.WorkerFragmentRequest;
     * Adapter from {@link AnalyticsSearchService.StreamingFragmentResponseHandler} to the
                        // task before the profile snapshot fires.
        transportService.registerRequestHandler(
        TransportRequestOptions options = TransportRequestOptions.builder().withType(TransportRequestOptions.Type.STREAM).build();
                    last = stream.nextResponse();
                    WorkerFragmentExecutionAction.NAME,
            }
    }
                            && next.getMetadata() != null;
                    listener.onFailure(e);
            ThreadPool.Names.SEARCH,
        PendingExecutions pending,
                } finally {
            } catch (Exception e) {
import org.opensearch.analytics.backend.EngineResultBatch;
 * The OpenSearch Contributors require contributions made to
import org.apache.arrow.memory.BufferAllocator;
            }
                    pending.finishAndRunNext();
                return ThreadPool.Names.SAME;
    /**
                    request,
import org.opensearch.common.inject.Inject;
                            // the stream. Release any undelivered prefetch first.
                } catch (Exception e) {
            AnalyticsCanMatchAction.NAME,
    /** Closes a response's claimed Arrow root if present, swallowing close failures. */
                return true;
     * through the blocking {@code channel.sendResponseBatch} call.
                    }
        Task parentTask,
        AnalyticsSearchService searchService,
                );
     */
        BooleanSupplier stillNeeded
                    }
                } finally {
        );
    private final StreamTransportService streamingTransportService;
                        // consumed by the coord-reduce sink rather than streamed back). Synthesize
import org.opensearch.indices.IndicesService;
            }
                    } catch (Exception ignore) {}
                                // nothing more we can do
import org.opensearch.transport.StreamTransportService;
                } catch (Exception e) {
import org.opensearch.transport.stream.StreamException;
        // MPP hash-shuffle worker fragments ride the STREAM transport (batched results), same as the
        TransportRequestOptions options = TransportRequestOptions.builder().withType(TransportRequestOptions.Type.STREAM).build();
                    if (last != null) {
                        @Override
            }
                        // Hash-shuffle producer / worker fragments stream zero responses (their
                        // stage transitions to SUCCEEDED.
    public void dispatchFragmentStreaming(
                    @Override
 * this file be licensed under the Apache-2.0 license or a
                }
     * channel streaming API. Each batch is sent on the channel; onComplete completes the
                // false so the finally cancel()s the stream rather than just closing the cursor.
     * because {@code listener.onStreamResponse} blocks until the downstream sink accepts
                    terminatedCleanly = true;
                        if (last.getRoot() != null && last.getRoot().getRowCount() == 0 && last.getMetadata() != null) {
                    shard,
                    channel.sendResponseBatch(new FragmentExecutionArrowResponse(root));
                    batchAllocator = root.getFieldVectors().getFirst().getAllocator();
            @Override
                    pending.finishAndRunNext();
                            return;
            }
                        }
            ThreadPool.Names.SAME,
                // Set true only on an expected end (full drain or sentinel). Any other exit leaves it
                    }
     *
            private Schema batchSchema = null;
                    request,
     * channel — the response shape is identical (Arrow streaming), only the request differs.
        return streamingTransportService;
                        transportService.getThreadPool().executor(ThreadPool.Names.SEARCH),
     * Shared streaming dispatch path for {@link FragmentExecutionAction} and
                    listener.onFailure(AnalyticsTransportErrors.fromWireError(e));
            // ConnectTransportException instead of letting a null node reach the connection
        IndicesService indicesService,
    @Inject
                    }
        } catch (Exception ignore) {}
    public AnalyticsSearchTransportService(
                            return;
        if (node == null) {
                    listener.onFailure(e);
                if (batchSchema != null && batchAllocator != null) {
                    throw e;
                    // On an abnormal exit, cancel() (not close()) so the data-node producer tears down
                    (AnalyticsShardTask) task,
                );
                try {
                } finally {
import org.opensearch.tasks.Task;
                transportService.getThreadPool().executor(ThreadPool.Names.SEARCH)
     */
        IndicesService indicesService
            false,
            true,
import org.opensearch.transport.TransportResponseHandler;
        // streamingTransportService when it introduced the regular transport for can-match.
                    FragmentExecutionArrowResponse current;
            true,
        }
                streamingTransportService.sendChildRequest(connection, actionName, request, parentTask, options, handler);
     *                    or {@code null} to always send. {@code false} abandons the send — nothing
        DiscoveryNode targetNode,
        searchService.setTaskResourceTrackingService(taskResourceTrackingService);
                // stream already closed after a mid-stream failure), Flight never took ownership, so
 * {@link StreamTransportService} (analytics-engine is streaming-only) and
import java.util.function.BooleanSupplier;
                    } catch (Exception ce) {
                    channel.sendResponse(AnalyticsTransportErrors.toWireError(e));
                } finally {
 * SPDX-License-Identifier: Apache-2.0
            public boolean skipsDeserialization() {
     * {@link #dispatchFragmentStreaming} — same streaming-response handler shape, same
                        listener.onStreamResponse(new FragmentExecutionArrowResponse((VectorSchemaRoot) null), true);
                channel.completeStream();
                        transportService.getThreadPool().executor(ThreadPool.Names.SEARCH),
import org.opensearch.analytics.exec.action.WorkerFragmentExecutionAction;
                    + "=true)"
    }
                    ContextAwareExecutor.wrap(
                request,
                        // Null our ref before the call so a throw can't make finally double-close it.
                }
import org.opensearch.analytics.exec.action.FragmentExecutionArrowResponse;
    /**
                    )
            public void handleResponse(FragmentExecutionArrowResponse response) {
    ) {
                            return;
                                channel.sendResponse(response);
    }
            FragmentExecutionAction.NAME,
            return true;
    }
                    // Release any batches the loop still owns and never delivered.
            }
                }
                    public void onBatch(EngineResultBatch batch) throws Exception {
            false,
        };
        }
    /** Regular (non-stream) transport used for the unary can-match RPC. */
            }
                            // Sentinel = clean end-of-stream; producer is already completing.
            }
                    pending.finishAndRunNext();
                            && next.getRoot().getRowCount() == 0
            }
                    request,
import org.opensearch.transport.Transport;
                try {
 * compatible open source license.
    ) {
                            channel.sendResponse(e);
     * {@link AnalyticsSearchService#executeFetchByRowIdsAsync} so a slow coordinator parks
                } finally {
package org.opensearch.analytics.exec;
                        // coordinator's stage-execution listener fires onResponse(null) and the
            if (stillNeeded != null && stillNeeded.getAsBoolean() == false) {
                        }
                    }
            throw new IllegalStateException(
                        return;
            public boolean skipsDeserialization() {
            public void onBatch(EngineResultBatch batch) throws Exception {
                    }
    }
            }
                        public void onFailure(Exception e) {
                        // Stream may already be cancelled — close sentinel to prevent leak
                try {
        try {
import org.opensearch.core.common.io.stream.StreamInput;
                    // Loop exited because nextResponse() returned null — the stream drained fully.
     */
                        }
        AnalyticsSearchService searchService,
                        next = stream.nextResponse();
     * stream; onFailure ignores cancellation and forwards everything else as an exception
                            return;
                            }
import org.opensearch.index.shard.IndexShard;
                }
                try {
            public FragmentExecutionArrowResponse read(StreamInput in) throws IOException {
            public String executor() {
 * Stateless transport dispatch component for fragment requests. Owns the
        transportService.registerRequestHandler(
                } catch (Exception e) {
                new AnalyticsSearchService.StreamingFragmentResponseHandler() {
                FragmentExecutionArrowResponse next = null;
            }
                    try {
    private final TransportService transportService;
                            terminatedCleanly = true;
            false,
        this.transportService = transportService;
                    VectorSchemaRoot sentinel = VectorSchemaRoot.create(batchSchema, batchAllocator);
        return new AnalyticsSearchService.StreamingFragmentResponseHandler() {
        });
     * {@link FetchByRowIdsAction}. Drains the response stream inline — backpressure flows
import org.opensearch.transport.TransportService;
                    pending.finishAndRunNext();
import org.opensearch.common.inject.Singleton;
import org.opensearch.analytics.exec.canmatch.AnalyticsCanMatchRequest;
            }
                    pending.finishAndRunNext();
                return new FragmentExecutionArrowResponse(in);
                }
                    + "("
                );
    }
                    @Override
        TransportService transportService,
                        // output goes peer-to-peer via AnalyticsShuffleDataAction, or is fully
    private static void registerFetchByRowIdsHandler(
                        if (terminatedCleanly) {
                    channelResponseHandler(channel),
                        boolean isLast = next == null || nextIsSentinel;
                        }
            }
        TaskResourceTrackingService taskResourceTrackingService
     * {@link #dispatchFragmentStreaming} but for the {@link WorkerFragmentExecutionAction}
                try {
            AdmissionControlActionType.SEARCH,
                VectorSchemaRoot root = batch.getArrowRoot();
                // close root here to avoid leaking the imported batch.
    }
            (request, channel, task) -> {
        registerStreamingFragmentHandler(this.streamingTransportService, searchService, indicesService);
                // the cursor, not claimed roots).
import org.opensearch.analytics.exec.action.FragmentExecutionAction;
            ThreadPool.Names.SAME,
import org.opensearch.cluster.node.DiscoveryNode;
                if (batchSchema == null && root.getFieldVectors().isEmpty() == false) {
        );
    ) {
                },
                        if (last != null) {
                    listener.onFailure(AnalyticsTransportErrors.fromWireError(e));
                    pending.finishAndRunNext();
                // hold what the loop still owns; null each the instant ownership transfers so the
            }
            FetchByRowIdsRequest::new,
            } catch (Exception e) {
        String actionName,
                    } catch (Exception ignore) {}
                // We own each claimed response root until it's handed to the consumer. `last`/`next`
        StreamTransportService streamingTransportService,
import org.opensearch.analytics.exec.canmatch.AnalyticsCanMatchResponse;
            FragmentExecutionRequest::new,
                searchService.executeFragmentStreamingAsync(
                        // a final null-payload isLast=true so the stage's response listener still
import org.apache.arrow.vector.VectorSchemaRoot;
    ) {
                            next = null;
    }
                IndexShard shard = indicesService.indexServiceSafe(request.getShardId().getIndex()).getShard(request.getShardId().id());
     * Mirrors {@link #registerStreamingFragmentHandler} for the QTF fetch-by-rowids path.
                        if (nextIsSentinel) {
                        try {
                        boolean nextIsSentinel = next != null
     * shape is identical, only the request type differs.
                    new ActionListener<>() {
import org.opensearch.threadpool.ThreadPool;
 * their own {@link PendingExecutions} instance to gate dispatch concurrency.
                    listener.onFailure(AnalyticsTransportErrors.fromWireError(e));
    Transport.Connection getConnection(DiscoveryNode node) {
    /**
import org.apache.arrow.vector.types.pojo.Schema;
            @Override
}
        StreamTransportService transportService,
     * the handler skips {@code IndicesService.getShard} and reader acquisition entirely.
        IndicesService indicesService
                        FragmentExecutionArrowResponse delivering = last;
@Singleton
 */
 */
import org.opensearch.core.action.ActionListener;
                        }
            public void onCompleteWithMetrics(byte[] metrics) {
            public FragmentExecutionArrowResponse read(StreamInput in) throws IOException {
                try {
            return;
     *                    {@code ShardTaskRunner}, where earlier shards' results can make a later
                    if (last == null) {
    }
        );
                        if (nextIsSentinel) {
            // Permit consumed — a worker dispatch always attempts the send (no stillNeeded gate),
        return transportService;
                    pending.finishAndRunNext();
                    (AnalyticsShardTask) task,
            // manager, where it NPEs ("Cannot invoke Object.hashCode() because key is null").
        StreamTransportService transportService,
        if (streamingTransportService == null) {
                }
import org.opensearch.common.util.FeatureFlags;
     * Forks the iterator drain onto the SEARCH executor via
    ) {
     *                    goes on the wire and {@code listener} is never invoked. Checked this late
            AnalyticsCanMatchRequest::new,
            // so it never declines back to PendingExecutions.
                        }
import org.opensearch.analytics.exec.task.AnalyticsShardTask;
            try {
                    }
                        }
    private static AnalyticsSearchService.StreamingFragmentResponseHandler channelResponseHandler(TransportChannel channel) {
                    handler
                        listener.onStreamResponse(last, true);
     * name routes the request to {@link FetchByRowIdsAction} on the data node.
                        if (!keepReading) {
                    }
            }
     */
                    }
     * gRPC flow control back to the data node.
                        // Consumer takes ownership of `last` (it closes the root on all its paths).
                    closeResponseQuietly(next);
        dispatchStreaming(FragmentExecutionAction.NAME, request, targetNode, listener, parentTask, pending, stillNeeded);
                // On success Flight takes ownership of root. If sendResponseBatch throws (e.g. the
        Task parentTask,
                    listener.onStreamResponse(response, true);
 * connection lookup.
            AdmissionControlActionType.SEARCH,
        StreamingResponseListener<FragmentExecutionArrowResponse> listener,
            }
 *
/*
     * {@link #registerStreamingFragmentHandler}, but for fragments that have no shard scan —
                    pending.finishAndRunNext();
            @Override
                }
                        channel.sendResponseBatch(new FragmentExecutionArrowResponse(sentinel, metrics));
                } finally {
                    closeResponseQuietly(last);
    private static void closeResponseQuietly(FragmentExecutionArrowResponse response) {
                        }
            public void handleException(TransportException e) {
                    shard,
        if (response == null || response.getRoot() == null) {
                            try {
        StreamingResponseListener<FragmentExecutionArrowResponse> listener,
    }
                        channel.sendResponseBatch(new FragmentExecutionArrowResponse(batch.getArrowRoot()));
        this.clusterService = clusterService;
        TransportResponseHandler<FragmentExecutionArrowResponse> handler = new TransportResponseHandler<>() {
            @Override
                }
                            stream.close();
        registerWorkerFragmentHandler(this.streamingTransportService, searchService);
        WorkerFragmentRequest request,
            public void handleStreamResponse(StreamTransportResponse<FragmentExecutionArrowResponse> stream) {
    ) {
                        // Treat sentinel as end-of-stream: the current batch is the last real data batch.
     * a search thread, not the transport thread, and the engine sees natural backpressure
        FetchByRowIdsRequest request,
import org.opensearch.transport.TransportRequest;
        }
        IndicesService indicesService
                try {
                        transportService.getThreadPool()
                            && next.getRoot() != null
            try {
                } finally {
                streamingTransportService.sendChildRequest(
            public void handleStreamResponse(StreamTransportResponse<FragmentExecutionArrowResponse> stream) {
                channel.completeStream();
                }
            @Override
     */
                            listener.onStreamResponse(last, false);
        dispatchStreaming(FetchByRowIdsAction.NAME, request, targetNode, listener, parentTask, pending, null);
 *
                        last = current;
        DiscoveryNode targetNode,
                            listener.onStreamComplete(last.getMetadata());
                FragmentExecutionArrowResponse last = null;
                } catch (Exception sendException) {
                );
        StreamingResponseListener<FragmentExecutionArrowResponse> listener,
import org.opensearch.transport.stream.StreamErrorCode;
                        if (e instanceof StreamException se && se.getErrorCode() == StreamErrorCode.CANCELLED) {
        // Can-match is a unary RPC — regular transport, not the stream transport (batches only).
        DiscoveryNode targetNode,
                            }
                    } else {
                    try {
                        // Worker fragments may have an empty response stream when their output
    public TransportService getTransportService() {
            )
                        stream.close();
        PendingExecutions pending
    /**
            public void handleResponse(FragmentExecutionArrowResponse response) {
                    request.getFilterBytes(),
                                if (next.getRoot() != null) next.getRoot().close();
    /**
            FetchByRowIdsAction.NAME,
        registerFetchByRowIdsHandler(this.streamingTransportService, searchService, indicesService);
                    try {
        pending.tryRun(() -> {
        };
        this.streamingTransportService = streamingTransportService;
import org.opensearch.transport.stream.StreamTransportResponse;
                        e.addSuppressed(ce);
    public void dispatchFetchByRowIds(
            response.getRoot().close();
                searchService.canMatch(
            @Override
 *
        });
                    public void onComplete() {
                }
                    shard,
                        public void onResponse(AnalyticsCanMatchResponse response) {
                } finally {
            (request, channel, task) -> {
                        } catch (Exception ignored) {}
                    ContextAwareExecutor.wrap(
        DiscoveryNode targetNode,
    /**
     * Dispatches a fragment-execution RPC to {@code targetNode}, subject to {@code pending}'s
        transportService.registerRequestHandler(
/**
        Task parentTask,
                        root.close();
                        listener.onStreamResponse(new FragmentExecutionArrowResponse((VectorSchemaRoot) null), true);
                            terminatedCleanly = true;
 * @opensearch.internal
    private static void registerCanMatchHandler(
     */
                    public void onFailure(Exception e) {
                return ThreadPool.Names.SAME;
            @Override
            public void handleException(TransportException e) {
        AnalyticsSearchService searchService,
                    }
                        transportService.getThreadPool()
                    parentTask,
                return new FragmentExecutionArrowResponse(in);
                try {
    }
        ClusterService clusterService,
import org.opensearch.ratelimitting.admissioncontrol.enums.AdmissionControlActionType;
                }
        registerCanMatchHandler(this.transportService, searchService, indicesService);
                        last = null;
     */
                    request.getSortColumn(),
                    } catch (Exception e) {
        transportService.registerRequestHandler(
                            try {
            }
                        sentinel.close();
                    connection,
                    while (last != null) {
                        last = next;
                        // Deliver metrics BEFORE signalling isLast so they're stored on the
                    listener.onStreamResponse(response, true);
                        channel.completeStream();
    }
            @Override
import org.opensearch.transport.ConnectTransportException;
    private static void registerStreamingFragmentHandler(
                try {
                        // Profiling sentinel: 0 rows with metadata attached. Deliver metrics and exit.
import org.opensearch.analytics.exec.canmatch.AnalyticsCanMatchAction;
            @Override
            @Override
                            } catch (IOException e) {
                boolean terminatedCleanly = false;
                        } else {
import org.opensearch.transport.TransportChannel;
    /**
     * Registers the worker-fragment streaming handler. Sibling of
            return true;
                searchService.executeFetchByRowIdsAsync(
 * <p>Does NOT track per-query or per-node concurrency state — callers provide
     * {@link PendingExecutions} gating, same cancellation propagation. Different action
                return true;
     * @param stillNeeded last-moment check, run immediately before the send once a permit is granted,
            }
                                channel.sendResponse(new AnalyticsCanMatchResponse(true));
            public void onFailure(Exception e) {
import org.opensearch.analytics.exec.action.FetchByRowIdsRequest;
                    )
     * response. Shared by the streaming-fragment and fetch-by-rowids handlers — the dispatch
    public void dispatchWorkerFragmentStreaming(
        PendingExecutions pending
     * Dispatches a QTF fetch-by-rowids RPC to {@code targetNode}. Mirrors
