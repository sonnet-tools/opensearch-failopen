        // Substrait fragment's NamedTable (which carries the planner's logical alias/pattern name),
                }
        this(backends, List.of(), nativeAllocator, namedWriteableRegistry, readerContextStore);
            AnalyticsSearchBackendPlugin.CanMatchResult result = backend.canMatchWithBounds(shard, filterBytes, sortColumn);
    ) {
        } catch (Exception e) {
                    return 0;
    /**
    private ResolvedFragment resolveFragment(FragmentExecutionRequest request, IndexShard shard) {
            ExchangeSink partitionedSink = buildPartitionedSink(backend, producerState, ctx, queryId, stageId);
        // Producer's ExchangeSinkContext carries no child inputs (the producer IS the source) and
    public void setShuffleSenderDeps(
                    resolved.queryId,
                long contextId = task.getId();
            );
 *
                LOGGER.warn(
                responseHandler.onBatch(it.next());
            if (backends.containsKey(alt.getBackendId())) {
 * {@link IndexShard} from the transport action.
        String backendId,
                            rowsProduced += batch.getRowCount();
        if (selectedPlan == null) {
            responseHandler.onFailure(e);
                + request.getPlanAlternatives().stream().map(FragmentExecutionRequest.PlanAlternative::getBackendId).toList()
                    if (engine != null) {
                )
 * the framework's QUERY pool via {@link ArrowNativeAllocator#getPoolAllocator(String)}. One allocator
            // is the one place guaranteed to see the real cause and stack.
                    }
                }
                BackendExecutionContext backendContext = null;
        BufferAllocator queryPool = nativeAllocator.getPoolAllocator(NativeAllocatorPoolConfig.POOL_QUERY);
            }
     */
     * and fail-fast with a typed error rather than null-deref.
        // Fallback table name only — the backend derives the actual registration name from the
import java.io.IOException;
        // stream.close() (which would race the in-flight native pull).
     * streams batches via {@link StreamingFragmentResponseHandler}. Forks onto
                        + " on "
                        task.getHeader(Task.X_OPAQUE_ID)
            throw e;
     *   <li><b>Standard path:</b> batches go back to the originating coordinator through
                    }
        for (FragmentExecutionRequest.PlanAlternative alt : request.getPlanAlternatives()) {
                final long startNanos = System.nanoTime();
        try {
                            backendContext.close();
                sinkCtx
                        Iterator<EngineResultBatch> it = stream.iterator();
                        fragmentTookNanos,
                allocator,
        // so this concrete shard index name is used only when no plan is supplied.
                    "startFragment failed [queryId={}, stageId={}, shardId={}]",
    /**
     * Holder for the result of {@link #resolveProducerSink}: the partitioned sink to drain into
                public List<String> getFieldNames() {
        ReaderContext readerContext,
     * error (rather than null-deref) so misconfiguration is obvious during plugin startup.
        }
    }
                        }
                        }
                    shuffleBufferRegistry.clearForQuery(request.getQueryId());
            throw new IllegalStateException("No ReaderProvider on " + shard.shardId());
            public long trackStart() {
                }
    private FragmentResources startFragment(FragmentExecutionRequest request, ResolvedFragment resolved, IndexShard shard, Task task)
    /**
        // close() frees it immediately instead of waiting for the reaper.
        String tableName = request.getShardId().getIndexName();
            // Lucene backend both sources the shard's hasDeletions signal (probed just below) and
        ctx.setShuffleBufferRegistry(shuffleBufferRegistry);
    ) {
import org.opensearch.analytics.exec.shuffle.ShuffleSenderImpl;
            // never reached / never finished the engine construction — if the handle was
     * channel. A per-stream staging child therefore cannot be closed at stream close without racing the
    }
                // Register handle and tracker together under the query's contextId so concurrent
    private final ReaderContextStore readerContextStore;
        // effect immediately via Arrow's parent-cap check at allocateBytes — no listener needed.
     * map for the node's lifetime ({@code BaseAllocator#newChildAllocator} registers unconditionally; only
                        responseHandler.onComplete();
     * route through its session-context execution path rather than the shard-scan one.
            FragmentInstructionHandler handler = factory.createHandler(node);
                EngineResultStream stream = null;
                            LOGGER.debug(
            }
import java.util.Map;
            } catch (Exception suppressed) {
    /**
                        drainIntoPartitionedSink(partitionedSink, stream, responseHandler);
            throw new RuntimeException("Failed to start streaming fragment on " + shard.shardId(), e);
        ctx.setFragmentBytes(plan.getFragmentBytes());
     */
                columns,
                } catch (Exception ignore) {}
                        try {
            // Close the sink here so isLast markers ship before FragmentResources.close() tears
     * {@code executor} so the iterator drain doesn't pin the transport thread — mirrors
        IndexShard shard,
    /**
                    // Cascaded shuffle: a worker fragment can ALSO be a shuffle producer (its plan
        return new ResolvedFragment(readerProvider, selectedPlan, request.getQueryId(), request.getStageId(), shardIdStr);
        throw new IllegalArgumentException(
                trackerCleanup = backend.configureFilterDelegation(contextId, handle, buildDelegationThreadTracker(task), backendContext);
     */
                        // a single header-only frame on the coordinator-bound stream (mirrors the shard
     *       response handler still receives a single {@code onComplete} (no batches) so the
     */
            // Close the backend execution context as a safety net for failure paths that
     * </ul>
                    // reach here. Guarded for non-shuffle workers (registry null / no such buffer →
                    ExchangeSink partitionedSink = producer.partitionedSink();
        try {
                        // producer path). drainIntoPartitionedSink closes the sink when done.
     */
     * Evaluates whether a shard can possibly match the given filter predicates.
 * Acquires a reader from the shard's composite engine, builds an
     * in a single try-with-resources scope. Runs on the caller's executor — exhausting the
            queryId,
    private record ResolvedExecution(FragmentResources resources, ResolvedFragment resolved) implements AutoCloseable {
package org.opensearch.analytics.exec;
                    } else {
                try {
    ) {
    /** Selects the first plan alternative whose backend is registered on this node — same logic
     * single header-only zero-row response on the coordinator-bound stream. Without that
    private static boolean assertReaderInvariants(
                    .stream()
    }
            // Convert native errors (e.g. memory-pool / admission trips) to typed exceptions via the
                        }
                    ctx.setShuffleBufferRegistry(shuffleBufferRegistry);
            // to async dispatch / stream transport and can be re-wrapped or swallowed downstream, so this
            if (backendContext != null) {
        BackendExecutionContext backendContext = null;
        ArrowNativeAllocator nativeAllocator,
            // partitioned sink, and unwrap the carrier so the engine factory sees the upstream
        // On cancel, release a fetch parked in the native pull via cooperative cancellation, not
                SearchExecEngine<ShardScanExecutionContext, EngineResultStream> engine = null;
        ReaderContextStore readerContextStore
     * transport has ≥1 frame to terminate on. Reader-independent — shared by the shard-fragment
                trackerCleanup,
                            responseHandler.onComplete();
        List<AnalyticsOperationListener> listeners,
                        } catch (Exception ignore) {}
                        + request.getQueryId()
        } catch (OpenSearchException e) {
                listener.onResponse(new AnalyticsCanMatchResponse(true));
            listener.onResponse(new AnalyticsCanMatchResponse(result.canMatch(), result.bounds()));
 */
            ShardScanExecutionContext ctx = buildContext(request, readerContext.getReader(), resolved.plan, shard, task);
        AnalyticsSearchBackendPlugin backend = backends.get(backendId);
        AnalyticsShardTask task
import org.opensearch.analytics.backend.EngineResultStream;
        org.opensearch.transport.client.Client client,
                        .stream()
    private static boolean assertAscending(long[] values) {
                public VectorSchemaRoot getArrowRoot() {
                        } catch (Exception ignore) {}
     *   <li><b>Hash-shuffle producer path:</b> when the fragment's instruction chain produced a
            );
                readerContext.getReader(),
            LOGGER.error(
     * framework constructs the {@link org.opensearch.analytics.spi.ShuffleSender} pre-stamped
        // this reader. When it does, close() keeps the reader in the store for the fetch; otherwise
        AnalyticsSearchBackendPlugin backend = backends.get(request.getBackendId());
            }
     * {@link AnalyticsSearchBackendPlugin#fetchByRowIds}. Deliberately not per-stream: the Flight transport
import org.apache.logging.log4j.Logger;
                    engine = backend.getSearchExecEngineProvider().createSearchExecEngine(ctx, backendContext);
     * allocator for every later batch ({@code FlightServerChannel#transferIntoStreamRoot}: "The producer's
            // Handle exchange — if plan has delegation, ask accepting backend for handle and pass to driving
     * fetch phase will reuse this reader. Derived from the {@link ShardScanInstructionNode} the
        }
        // buffers on cancel is safe: a cancelled query won't consume them again. Idempotent.
        // into another in-process sink). fragmentBytes is left empty for the same reason — the
                null,
 * compatible open source license.
        void onComplete();
import org.apache.arrow.vector.BigIntVector;
                @Override
import org.opensearch.index.engine.exec.IndexReaderProvider;
 * cross-allocator bug with foreign-backed buffers from the C Data Interface.
            );
                    importStagingAllocator.getName(),
import org.opensearch.analytics.backend.SearchExecEngine;
    }
     */
            return;
import java.util.Iterator;
     * ({@link #startFragment}) and worker-fragment ({@link #executeWorkerFragmentStreamingAsync})
    }
     * instruction list is empty.
            stream = engine.execute(ctx);
                throw new IllegalStateException(
            try {
            // Fetch is terminal: free the reader eagerly.
                    // Free the shuffle buffer this worker task consumed (keyed by the worker's own
            // Fetch is terminal: free the reader eagerly.
            );
            Exception converted = convertWith(resolved.plan().getBackendId(), e);
                    outstanding
    private DelegationThreadTracker buildDelegationThreadTracker(Task task) {
        }
        org.opensearch.cluster.service.ClusterService clusterService
            // cancellation listener) so they don't leak when the worker never starts.
            onComplete();
                        filterTreeShape,
            if (backend == null) {
        return true;
        ctx.setAllocator(allocator);
     * QTF fetch phase: retrieves specific rows by global row ID via the backend SPI and
        } catch (Exception e) {
                        + shard.shardId()
        return backend == null ? e : backend.convertException(e);
     *       sink the framework attached to {@link FragmentResources#partitionedSink}; the
     * batches back through the channel. The transport thread returns immediately.
        assert assertFetchInvariants(readerContext, request.getQueryId());
                    return schemaRef.getFields().stream().map(Field::getName).toList();
            ctx.setHasDeletedDocs(luceneBackend != null && luceneBackend.hasDeletedDocs(ctx));
        return backend.getExchangeSinkProvider()
                // Collector for deleted-doc filtering. Register a Lucene handle (no coordinator
            AnalyticsSearchBackendPlugin luceneBackend = backends.get("lucene");
                    "No backend registered for backendId="
        }
            LOGGER.warn(
                new IllegalArgumentException(
import org.opensearch.analytics.spi.ShardScanInstructionNode;
        EngineResultStream resultStream,
                service.taskExecutionStartedOnThread(taskId, threadId);
            // (e.g., Lucene + Tantivy), group expressions by acceptingBackendId and create one handle per group.
            return new ResolvedExecution(resources, resolved);
     * min/max of {@code sortColumn} when one is given. The backend owns the sequencing; this
                FilterDelegationHandle handle = acceptingBackend.getFilterDelegationHandle(delegation.delegatedExpressions(), ctx);
        // transitions to SUCCEEDED on isLast=true.
            }
     * Callback interface for async fragment streaming results.
        // ShardScanExecutionContext#getImportStagingAllocator), so the staging target must not be able to
     */
                    // Extract DataFusion execution metrics only when needed
    /**
                    // byte[]; without this it lives for the JVM's lifetime and accumulates across
        Task task
        Map<String, AnalyticsSearchBackendPlugin> backends,
            // exit"). Closing on a non-zero balance would throw from BaseAllocator#close AND strand the
                            shuffleBufferRegistry.removeBuffer(request.getQueryId(), request.getStageId(), request.getPartitionIndex());
     * Per-node shuffle buffer registry. Plumbed into every {@link ShardScanExecutionContext} so
                            stream.close();
                    }
            long outstanding = importStagingAllocator.getAllocatedMemory();
                        if (request.profile() && metricsJson != null) {
    }
        }
     * Acquires the per-shard {@link ReaderContext}, materialises the rowId vector, invokes
                    }
            );
                // queries have isolated FFM callback bindings. The returned cleanup removes the
                        } catch (Exception ignore) {}
            final String cancelQueryId = request.getQueryId();
        String[] columns = request.getColumns();
import org.opensearch.analytics.exec.action.FetchByRowIdsRequest;
        for (InstructionNode node : instructions) {
    private FragmentExecutionRequest.PlanAlternative selectWorkerPlan(WorkerFragmentRequest request) {
                        stats
        ReaderContext readerContext = readerContextStore.createContext(request.getQueryId(), shard.shardId(), gatedReader);
                    );
     * Drains the engine result stream into the producer's partitioned sink AND emits a
    /** Cross-phase reader cache for QTF — query phase stores, fetch phase acquires. */
            }
        );
            );
        }
                        hasPartialAggregate,
        }
    private void drainIntoPartitionedSink(
            // delegation). See FilterDelegationHandle#LIVE_DOCS_MATCH_ALL_ANNOTATION_ID.
            if (rowIdVector != null) rowIdVector.close();
        this.namedWriteableRegistry = namedWriteableRegistry;
            return;
                }
        Executor executor
    }
        default void onCompleteWithMetrics(byte[] metrics) {
    /**
     */
                // expressions) so the FFM callbacks can serve it. Skipped when Lucene is the driving
                    readerContextStore.freeContext(request.getQueryId(), shard.shardId());
                return threadId;
                if (task == null) {
    /**
                    backendContext.close();
     * frame, the streaming transport never sees an end-of-stream marker (Flight requires
        return new DelegationThreadTracker() {
        ShardScanExecutionContext ctx,
            rowIdVector = new BigIntVector(DocumentInput.ROW_ID_FIELD, allocator);
        try {
                    + ". Available: "
     * As {@link #canMatch(IndexShard, byte[], String, ActionListener)}, plus the shard-wide
        IndexShard shard,
        }
    private record ProducerSinkResolution(ExchangeSink partitionedSink, BackendExecutionContext engineContext) {
            importStagingAllocator
        }
                        // Producer worker: ship batches out-of-band via the partitioned sink and emit
        }
                        }
    }
        EngineResultStream stream = null;
        int stageId
    private String selectedBackendId(FragmentExecutionRequest request) {
            final VectorSchemaRoot vsrRef = headerRoot;
                        + "; available: "
    private final BufferAllocator importStagingAllocator;
        }
     * Build a {@link DelegationThreadTracker} that attributes FFM delegation callback work
            ProducerSinkResolution producer = resolveProducerSink(backend, backendContext, ctx, resolved.queryId, resolved.stageId);
            // which may already refuse tasks (FlightServerChannel#close logs "root reclaimed at process
                count++;
     * and reader acquisition: workers don't scan shards, they read only from named-input
    /**
        ctx.setImportStagingAllocator(importStagingAllocator);
        ActionListener<AnalyticsCanMatchResponse> listener
            rowIdVector.setValueCount(rowIds.length);
                    ctx.setNamedWriteableRegistry(namedWriteableRegistry);
        } catch (Exception e) {
        IndexShard shard,
                        } else {
import org.opensearch.analytics.spi.FragmentInstructionHandler;
     * <p>Builds a {@link ShardScanExecutionContext} with {@code reader=null}; the backend's
     * single zero-row, schema-bearing response on the coordinator-bound stream so the streaming
            responseHandler.onFailure(
        if (backends.isEmpty()) {
                            handler = factory.createHandler(node);
            });
                    responseHandler.onComplete();
            producerState.getSide()
                    // path (resolveProducerSink), so no dedicated stage type is needed. Non-producer
                            );
    /**
                    .anyMatch(n -> n.type() == org.opensearch.analytics.spi.InstructionType.SETUP_PARTIAL_AGGREGATE)
 * Data-node service that executes plan fragments against local shards.
                // Filter delegation routes per-query state via taskId; without a task we cannot
                        try {
                        // schema-bearing frame before completeStream — see
                    return vsrRef;
                        backendContext,
                    responseHandler.onFailure(convertWith(selectedBackendId(request), e));
                                new String(metricsJson, StandardCharsets.UTF_8)
        }
                return scan.requestsRowIds();
     * (createProvider/createCollector/collectDocs) to the query's task via
                        responseHandler.onComplete();
                        request.getQueryId(),
     * backend's partitioned sink and unwraps the carrier so the engine factory sees the upstream
        // part-way through an array strands the whole native batch (see
     * Until set, fragments that emit a {@code ShuffleProducerOutputState} fail fast with a typed
            resources = new FragmentResources(readerContextStore, readerContext, null, stream, null, rowIdVector, false);
                            responseHandler.onBatch(batch);
        this(backends, List.of(), nativeAllocator, null, null);
            // this same task during engine.execute. setCancellationListener is single-slot and the
        Map<String, AnalyticsSearchBackendPlugin> backends,
            listener.onFragmentFailure(resolved.queryId, resolved.stageId, resolved.shardIdStr, e);
        }
     * The node-scoped allocator Arrow C Data imports are staged on. Owned (and closed) here; the
                                "[FragmentMetrics] shard={} metrics={}",
                // delegation resources to avoid leaks.
            // A stream still in flight at shutdown keeps its batches charged to the staging allocator until
        GatedCloseable<Reader> gatedReader = resolved.readerProvider.acquireReader();
import org.opensearch.arrow.allocator.ArrowNativeAllocator;
        // case where a stage genuinely has multiple value-producing alternatives — pick the
     */
    @Override
            // ACTUALLY-SELECTED backend so a resource-exhaustion failure surfaces as 429 instead of a
                    }
            // down the engine. close() is idempotent on the sink contract; FragmentResources
        ctx.setQueryCachingPolicy(shard.getQueryCachingPolicy());
            return null;
    public void executeFetchByRowIdsAsync(
                        FragmentInstructionHandlerFactory factory = backend.getInstructionHandlerFactory();
        ctx.setMapperService(shard.mapperService());
                    resolved.shardIdStr
        Executor executor
                } catch (Exception e) {
            // populated this query's buffers on the node — clear them here (same backstop as the
    ) {
        ctx.setNamedWriteableRegistry(namedWriteableRegistry);
                }
                new IllegalStateException(
        if (backend == null) {
                    + backends.keySet()
                        + shard.shardId()
     */
     * <p>Two output paths:
        } catch (Exception e) {
import org.opensearch.analytics.spi.AnalyticsSearchBackendPlugin;
    /**
                    e.addSuppressed(suppressed);
            );
/*
     *
        }
        WorkerFragmentRequest request,
 * Flight's outbound handler co-locates its transfer target on the same root (see
    }
                service.taskExecutionFinishedOnThread(taskId, threadId);
            responseHandler.onFailure(e);
            if (values[i] < values[i - 1]) {
        if (instructions.isEmpty()) return null;
        AnalyticsShardTask task,
            // does NOT redundantly close it (see comment in FragmentResources.close()).
            );
        return true;
import org.apache.logging.log4j.message.ParameterizedMessage;
                throw converted instanceof RuntimeException re ? re : new RuntimeException(converted);
                        drainAndEmitHeader(exec.resources(), responseHandler);
                if (metricsJson != null) {
    }
            return;
                        while (it.hasNext()) {
            DelegationDescriptor delegation = resolved.plan.getDelegationDescriptor();
                        while (it.hasNext()) {
    public FragmentResources executeFragmentStreaming(FragmentExecutionRequest request, IndexShard shard, AnalyticsShardTask task) {
                long rowsProduced = 0;
            ctx.getAllocator(),
import java.nio.charset.StandardCharsets;
     *
                    + request.getPlanAlternatives().stream().map(FragmentExecutionRequest.PlanAlternative::getBackendId).toList()
        NamedWriteableRegistry namedWriteableRegistry,
        }
        assert assertReaderInvariants(gatedReader, readerContext, request.getQueryId(), shard);
            public void trackEnd(long threadId) {
    private ResolvedExecution executeFragmentStreamingResolved(
     * unavailable — {@code FilterTreeCallbacks} null-guards the tracker (tracking is simply
                    return null;
            }
    }
import org.apache.arrow.memory.BufferAllocator;
                        + " — query phase missing or context expired"
    }
            // it earlier would pull off-heap memory out from under the native FFM call.
                FilterDelegationHandle handle = luceneBackend.getFilterDelegationHandle(java.util.List.of(), ctx);
                producerState.getTargetWorkerNodeIds(),
        byte[] filterBytes,
        AnalyticsShardTask task,
                    throw new IllegalStateException("Filter delegation requires a tracked task for per-query isolation");
        return false;
                    boolean hasPartialAggregate = resolved.plan()
    }
                long contextId = task.getId();
            sink.close();
import org.opensearch.analytics.spi.ExchangeSinkContext;
    ) {
            AnalyticsSearchBackendPlugin backend = backends.get(resolved.plan.getBackendId());
                selectedPlan = alt;
                    DelegationDescriptor delegation = resolved.plan().getDelegationDescriptor();
                        }
                readerContext,
        void onBatch(EngineResultBatch batch) throws Exception;
                        shard.shardId().toString(),
            listener.onFragmentFailure(resolved.queryId, resolved.stageId, resolved.shardIdStr, e);
                new FragmentResources(readerContextStore, readerContext, engine, stream, trackerCleanup, false).close();
            throw new AssertionError("ReaderContext returned null reader for queryId=" + queryId);
                } catch (Exception suppressed) {
     * with {@code (queryId, targetStageId, side)} from {@code producerState}, then hands it to
        if (gatedReader == null) {
                        + " requires non-empty rowIds and columns; got rowIds="
        FetchByRowIdsRequest request,
 *
     * empty schema so the response carries a recognizable Arrow Flight frame.
     *       coordinator's transport stream closes cleanly. The peer-to-peer shuffle traffic
            backendContext = handler.apply(node, ctx, backendContext);
     */
                        // Drain into the partitioned sink AND emit a single header-only
        for (FragmentExecutionRequest.PlanAlternative alt : request.getPlanAlternatives()) {
            allocator.close();
        AnalyticsShardTask task,
    private ShuffleBufferRegistry shuffleBufferRegistry;
     * is missing (expired before fetch arrived, or query-phase reader-store invariant
     * Builds the backend-specific partitioned sink for a hash-shuffle producer fragment. The
    }
                    FragmentExecutionStats stats = new FragmentExecutionStats(
     * the child's own {@code close()} deregisters) — one stranded allocator per query.
     * on the analytics-engine plugin's internals (the registry is an SPI surface). Set once at
                            engine.close();
 * <p>Does NOT hold {@code IndicesService} — receives an already-resolved
            ExchangeSink partitionedSink = producer.partitionedSink();
                importStagingAllocator
            });
                        ),
        // buffers for not-yet-consumed partitions would also leak. Clearing ALL of this query's
            // the Flight channel frees its stream root — and that free is posted to the flight executor,
     * <p>Reuses the {@link ReaderContext} opened during the query phase. If the context
                    // queries → OOM. Runs on success AND failure (both hit this finally). The
     * streams that {@link org.opensearch.analytics.spi.ShuffleScanInstructionNode} handlers
            AnalyticsSearchBackendPlugin backend = backends.get(backendId);
    ) {
                }
    }
                try {
            }
        if (capturedSchema == null) {
                ),
import org.opensearch.analytics.spi.ShuffleSender;
        if (taskResourceTrackingService == null) {
        BackendExecutionContext backendContext,
    // ── Assertion helpers (invoked only when -ea is enabled; bodies are dead in production) ──
                }
                new IllegalStateException(
                rowIdVector,
            } else {
     * exactly one, whatever the execution path.
        TaskResourceTrackingService service = taskResourceTrackingService;
                try {
        org.opensearch.threadpool.ThreadPool threadPool,
        // no downstream sink (the partitioned sink ships out-of-band via the ShuffleSender, not
                    responseHandler.onFailure(e);
                    );
                trackerCleanup = backend.configureFilterDelegation(contextId, handle, buildDelegationThreadTracker(task), backendContext);
                        usedSecondaryIndex,
    ) {
        if (readerContext == null) {
            // its finally never executes. Producers dispatch concurrently and may already have
                } else {
        // Child uses Long.MAX_VALUE so dynamic resizes of parquet.native.pool.query.max take
            readerContextStore.releaseAndFree(request.getQueryId(), shard.shardId());
     * allocator must be long-lived (not closed per-request)"), then frees it asynchronously with its own
                        // producer output reaches the worker peer-to-peer via the shuffle transport.
     */
                        task.getId(),
    public void executeFragmentStreamingAsync(
            clusterService,
                }
                    ProducerSinkResolution producer = resolveProducerSink(
    private final BufferAllocator allocator;
            } else {
            // generic 500. Only wrap as a generic RuntimeException when conversion found nothing.
import org.apache.logging.log4j.LogManager;
        FragmentExecutionRequest request,
                sender,
        ReaderContext readerContext = readerContextStore.acquireContext(request.getQueryId(), shard.shardId());
     * {@link TaskResourceTrackingService}. Returns {@code null} when task resource tracking is
    }
                    AnalyticsSearchBackendPlugin backend = backends.get(plan.getBackendId());
                readerContextStore,
        }
                    );
        ExchangeSink sink,
                    if (backendContext != null) {
                LOGGER.debug("[FragmentExecution] shard={} task={}", shard.shardId(), task.getId());
            responseHandler.onFailure(
        ArrowNativeAllocator nativeAllocator,
        FragmentExecutionRequest request,
        } finally {
import java.util.List;
            ctx.setHasPartialAggregate(
        IndexReaderProvider readerProvider = shard.getReaderProvider();
        // finally, so a leak report from the service allocator cannot skip the staging allocator's release.
    private void drainAndEmitHeader(FragmentResources ctx, StreamingFragmentResponseHandler responseHandler) throws Exception {
                    } else {
     * registered locally. Mirrors {@link #resolveFragment}'s selection so exception conversion uses the
import org.opensearch.analytics.spi.InstructionNode;
        if (shuffleBufferRegistry != null) {
    public void close() {
                    String filterTreeShape = delegation != null ? delegation.treeShape().name() : null;
                    "Arrow import staging allocator [{}] still holds {} bytes at shutdown; reclaimed at process exit",
            return;
        Runnable trackerCleanup = null;
            responseHandler.onFailure(
                                shard.shardId(),
     * disabled for those upcalls).
            }
            // worker); addCancellationListener composes so both fire.
            // Fetch is terminal: free the reader eagerly.
                return;
    ) {
            throw e;
        }
        }
                throw new AssertionError("rowIds not ascending at index " + i + ": " + values[i - 1] + " > " + values[i]);
        BigIntVector rowIdVector = null;
     * <p>Schema selection: take the schema from the first batch the engine emits and
                String acceptingBackendId = delegation.delegatedExpressions().getFirst().getAcceptingBackendId();
import org.opensearch.analytics.spi.ExchangeSink;
                        try {
        ReaderContextStore readerContextStore
                    if (exec.resources().partitionedSink() != null) {
                requiresTopDocs,
    public BufferAllocator getImportStagingAllocator() {
 * to produce results.
     * Reader-independent — takes {@code queryId}/{@code stageId} directly rather than a shard-only
                        request.getStageId()
        try {
            // Log the original failure with its full stack at the origin: the thrown exception is handed
     * {@link BackendExecutionContext} and returns the next one. Returns {@code null} when the
        }
            resources.close();
                        + request.getBackendId()
     * org.opensearch.analytics.spi.ShuffleWorkerSetupInstructionNode}).
            // TODO: currently assumes single accepting backend. When multiple accepting backends exist
     * register on the session context (created by {@link
            .createPartitionedSink(
 * {@link ShardScanExecutionContext}, and invokes the backend's {@link SearchExecEngine}
                            request.getPartitionIndex()
     */
            return new FragmentResources(
            });
                        + backends.keySet()
        return executeFragmentStreamingResolved(request, shard, task).resources;
        // native side). Asserted here so violations are caught in dev builds before the FFM call.
     * Applies each instruction handler in order. Each handler reads the previous handler's
                            request.getQueryId(),
import org.opensearch.index.engine.exec.IndexReaderProvider.Reader;
 * per service means memory accounting is reported at the service level. For the streaming path, Arrow
                            responseHandler.onCompleteWithMetrics(metricsJson);
import org.opensearch.analytics.spi.ShuffleProducerOutputState;
        // request typically carries a single alternative. We still iterate to handle the
        if (backendContext instanceof ShuffleProducerOutputState producerState) {
    }
     * coordinator-reduce path borrows the same one via {@code CoordinatorAllocatorHandle} so a node has
     * Async variant for hash-shuffle worker fragments. Skips {@code IndicesService.getShard}
            if (converted != e) {
                ctx
        }
        }
                        e
        ResolvedFragment resolved = resolveFragment(request, shard);
import org.opensearch.analytics.exec.canmatch.AnalyticsCanMatchResponse;
    private void drainFetchByRowIds(
                return alt;
                    ResolvedFragment resolved = exec.resolved();
    ) {
            @Override
        @Override
        this.readerContextStore = readerContextStore;
                )
    public interface StreamingFragmentResponseHandler {
     *       happens out-of-band on {@code AnalyticsShuffleDataAction}.</li>
import org.opensearch.analytics.spi.FragmentInstructionHandlerFactory;
            responseHandler.onFailure(e);
import org.opensearch.analytics.spi.InstructionType;
                    // per-query clearForQuery backstop (cancellation path) covers tasks that never
    private org.opensearch.cluster.service.ClusterService clusterService;
                @Override
                long threadId = Thread.currentThread().threadId();
            listener.onResponse(new AnalyticsCanMatchResponse(true));
            );
        ShuffleSender sender = new ShuffleSenderImpl(
                        byte[] metricsJson = exec.resources().getExecutionMetrics();
                        responseHandler.onComplete();
        // Abort backstop: if the query is cancelled (client disconnect, timeout, explicit kill) the
import org.apache.arrow.vector.VectorSchemaRoot;
                public int getRowCount() {
                    listener.onFragmentSuccess(
 *
     */
        // follows, rather than us inferring it from the row-id signal here.
                        // least one Arrow Flight frame (the streaming transport requires ≥1
        );
        FragmentResources resources = null;
        List<InstructionNode> instructions,
    public void setShuffleBufferRegistry(ShuffleBufferRegistry registry) {
        return importStagingAllocator;
        this.allocator = queryPool.newChildAllocator("analytics-search-service", 0, Long.MAX_VALUE);
                ),
        try {
        String sortColumn,
     * transport, and one that is left open instead stays registered in the root's {@code childAllocators}
                } finally {
        canMatch(shard, filterBytes, backendId, null, listener);
            }
            } else if (ctx.hasDeletedDocs() && luceneBackend != null && task != null && !"lucene".equals(resolved.plan.getBackendId())) {
            responseHandler.onFailure(e);
    }
        // analytics-engine allocations are tracked and capped by the framework. Hard-fail if
        } catch (Exception e) {
    public AnalyticsSearchService(
        ctx.setShardId(shard.shardId());
     * the backend, drains the stream into {@code responseHandler}, and releases all resources
        this.clusterService = clusterService;
                @Override
    ) {
    }
            FragmentResources resources = startFragment(request, resolved, shard, task);
        IndexShard shard,
        return true;
                converted == e ? new RuntimeException("Failed to execute fetch-by-row-ids on " + shard.shardId(), e) : converted
import org.opensearch.analytics.backend.EngineResultBatch;
                    if (!instructions.isEmpty()) {
    ) throws Exception {
            throw new AssertionError("createContext returned null for queryId=" + queryId);
     *       {@code ShuffleProducerOutputState}, the engine's output drains into the partitioned
        FetchByRowIdsRequest request,
     * never fires onResponse(null) and the producer task hangs.
import org.opensearch.tasks.Task;
            return;
    ) {
    }
                // backend (it applies liveDocs natively) or the shard has no deletions.
            executor.execute(() -> {
            backendContext = producer.engineContext();
                    resolved.stageId,
        };
        if (readerContext.getReader() == null) {
                        .getInstructions()
            // shards through the indexed deleted-doc filtering path.
    public void setTaskResourceTrackingService(TaskResourceTrackingService service) {
        this.nativeAllocator = nativeAllocator;
        StreamingFragmentResponseHandler responseHandler,
        try {
        String shardIdStr = shard.shardId().toString();
                importStagingAllocator.close();
                        () -> new org.apache.logging.log4j.message.ParameterizedMessage(
        this.threadPool = threadPool;
     * the backend's {@code createPartitionedSink}. The backend never sees transport types.
        if (readerContext.getReader() == null) {
                "No plan alternative matches available backends. Alternatives: "
            // bytes, because close() sets isClosed before its leak check. Report and let process exit
            task.addCancellationListener(() -> shuffleBufferRegistry.clearForQuery(cancelQueryId));
        try (VectorSchemaRoot headerRoot = VectorSchemaRoot.create(capturedSchema, allocator)) {
                engine,
        long taskId = task.getId();
        // Arrow's same-root invariant for cross-plugin handoff.
                    // carries a ShuffleProducerInstructionNode) — e.g. an intermediate join level whose
                        ctx,
import org.opensearch.arrow.spi.NativeAllocatorPoolConfig;
     * Whether the query phase emits shard-global {@code __row_id__} values — i.e. a QTF query whose
    ) {
            if (backends.containsKey(alt.getBackendId())) {
                    boolean usedSecondaryIndex = delegation != null;
            @Override
            throw new AssertionError("no backends registered — service constructor invariant violated");
        ShuffleProducerOutputState producerState,
        } catch (Exception e) {
import org.opensearch.analytics.spi.DelegationThreadTracker;
        void onFailure(Exception e);
            for (int i = 0; i < rowIds.length; i++) {
                producerState.getPartitionCount(),
    private static BackendExecutionContext applyInstructionHandlers(
     *
            task.clearCancellationListener();
     * chain produced a {@link ShuffleProducerOutputState}, builds the framework ShuffleSender + the
     * plugin startup; null until then, in which case hash-shuffle handlers see a null registry
        // same as any other batch, decrements the partial-task counter, and the stage
            // serves the reserved match-all collector (registered further below when there is no
    private ShardScanExecutionContext buildContext(
            threadPool,
            producerState.getQueryId(),
                }
    private org.opensearch.transport.client.Client client;
                        + ", columns="
        IndexShard shard
    /**
                    ctx.setImportStagingAllocator(importStagingAllocator);
                    // output feeds a higher shuffle. Same instruction-driven mechanism as the shard
            // FragmentResources keeps the rowIdVector alive until the stream drains — closing
        AnalyticsSearchBackendPlugin backend,
            // engine's call would overwrite this buffer-cleanup hook (→ leak on cancel of a running
import org.opensearch.analytics.spi.ShuffleBufferRegistry;
    /**
                producerState.getHashKeyChannels(),
        for (FragmentExecutionRequest.PlanAlternative alt : request.getPlanAlternatives()) {
                    LOGGER.error(
                            EngineResultBatch batch = it.next();
import org.opensearch.index.engine.dataformat.DocumentInput;
        /** Called with execution metrics when profiling is enabled. Default delegates to onComplete(). */
        this.client = client;
import org.opensearch.analytics.backend.ShardScanExecutionContext;
        String queryId,
                responseHandler.onComplete();
        return null;
    private org.opensearch.threadpool.ThreadPool threadPool;
        }
     * another (segment topology may differ across reopens).
                        for (InstructionNode node : instructions) {
                // isolate concurrent queries from each other. Validate before allocating any
        try {
        }
        }
     * {@code __row_id__} values produced by one reader cannot be reinterpreted by
     * same backend that produced the failure. Returns null if none is registered.
            listener.onFragmentFailure(resolved.queryId, resolved.stageId, resolved.shardIdStr, e);
            Iterator<EngineResultBatch> it = ctx.stream().iterator();
        // A query that requested top-N docs (row-ids) will be followed by a fetch phase that reuses
import org.opensearch.analytics.exec.task.AnalyticsShardTask;
            if (backends.containsKey(alt.getBackendId())) {
            throw new IllegalArgumentException(
    /**
            executor.execute(() -> drainFetchByRowIds(request, shard, task, responseHandler));
    }
    }
                            responseHandler.onBatch(it.next());
    }
        SearchExecEngine<ShardScanExecutionContext, EngineResultStream> engine = null;
        public void close() throws Exception {
            // reclaim them instead.
            return;
    private boolean assertFetchInvariants(ReaderContext readerContext, String queryId) {
        if (readerContext == null) {
            }
        this.shuffleBufferRegistry = registry;
        StreamingFragmentResponseHandler responseHandler
    private static final Logger LOGGER = LogManager.getLogger(AnalyticsSearchService.class);
public class AnalyticsSearchService implements AutoCloseable {
    ) {
        StreamingFragmentResponseHandler responseHandler,
            if (outstanding == 0) {
            if (shuffleBufferRegistry != null) {
                }
                    FragmentExecutionRequest.PlanAlternative plan = selectWorkerPlan(request);
                    if (shuffleBufferRegistry != null) {
                    // Query phase failed: no fetch will follow, so free the reader eagerly (no-op if already freed).
                break;
import org.opensearch.OpenSearchException;
                } catch (Exception e) {
                e.addSuppressed(suppressed);
        // Caller contract: rowIds must already be sorted ascending (RowSelection invariant on
                );
                        try {
                    "AnalyticsSearchService: shuffle sender deps not plumbed; "
                        // DatafusionResultStream's empty-stream synthesis comment). The
        for (int i = 1; i < values.length; i++) {
    private final AnalyticsOperationListener listener;
     * builds its reused stream root on the first emitted batch's vector allocator and charges that same
                )
        }
                    }
        int stageId
            stageId,
            // executeFragmentStreamingAsync; we just attach the sink to FragmentResources here.
    }
                // binding after query execution completes.
                + ". Available: "
        listener.onPreFragmentExecution(request.getQueryId(), request.getStageId(), shardIdStr);
            throw new AssertionError("acquireReader returned null for shard " + shard.shardId());
        }
     */
            // Hash-shuffle producer routing: if the instruction chain produced a
            if (rowIdVector != null) rowIdVector.close();
        );
    }
                    // workers (the common leaf-consumer case) get a null sink and drain to the response.
        return ctx;
        try {
     * Dispatches to the named backend. Fail-open on any error or unknown backend.
        assert task != null : "fetch on " + shard.shardId() + " requires a non-null AnalyticsShardTask";
        } finally {
        } catch (OpenSearchException e) {
 * SPDX-License-Identifier: Apache-2.0
        this.listener = new AnalyticsOperationListener.CompositeListener(listeners);
                        request.getStageId(),
    private ExchangeSink buildPartitionedSink(
            "No worker plan alternative matches available backends. Alternatives: "
 * this file be licensed under the Apache-2.0 license or a
                partitionedSink,
                    shard.shardId(),
        // TODO: the coordinator (which knows the query shape) should tell us whether a fetch
        }
            // Fetch is the terminal phase: no fetch follows, so close() frees the reader eagerly.
        }
 * @opensearch.internal
     * session state. Otherwise returns the context unchanged with a null sink (non-producer fragment).
        long[] rowIds = request.getRowIds();
                        Iterator<EngineResultBatch> it = exec.resources().stream().iterator();
                    ctx.setAllocator(allocator);
 * {@code FlightOutboundHandler#processBatchTask}), keeping transfers same-root and avoiding the known
                new ParameterizedMessage(
        return backendContext;
                    if (partitionedSink != null) {
     * the engine should run against (the upstream session state, unwrapped from the producer carrier).
    public void canMatch(IndexShard shard, byte[] filterBytes, String backendId, ActionListener<AnalyticsCanMatchResponse> listener) {
     * transfer that batch into the sink. If the engine emits zero batches, fall back to an
        drainIntoPartitionedSink(ctx.partitionedSink(), ctx.stream(), responseHandler);
        this.importStagingAllocator = allocator.getRoot().newChildAllocator("arrow-import-staging", 0, Long.MAX_VALUE);
                public Object getFieldValue(String fieldName, int rowIndex) {
            // executor.execute rejected (pool shutdown / saturated) before the worker body ran, so
            responseHandler.onFailure(backend.convertException(e));
                    resolved.stageId
                rowIdVector.set(i, rowIds[i]);
                    // stage + partition). The buffer holds the partition's payload as on-heap
    /**
                    if (request.profile() || LOGGER.isDebugEnabled()) {
            }
            // ShuffleProducerOutputState, build the framework ShuffleSender + the backend's
     * (null when this fragment is not a hash-shuffle producer) and the {@link BackendExecutionContext}
        return new ProducerSinkResolution(null, backendContext);
                            request.getStageId(),
                @Override
    public AnalyticsSearchService(Map<String, AnalyticsSearchBackendPlugin> backends, ArrowNativeAllocator nativeAllocator) {
        // first one whose backend is registered locally.
            }
    private final ArrowNativeAllocator nativeAllocator;
                e
     * Drains a hash-shuffle producer fragment's engine output into its {@code partitionedSink}
import org.opensearch.analytics.exec.action.WorkerFragmentRequest;
                        + " on "
            readerContextStore.releaseAndFree(request.getQueryId(), shard.shardId());
import org.opensearch.analytics.spi.DelegationDescriptor;
                + backends.keySet()
                        shard.indexSettings(),
        int stageId, String shardIdStr) {
import org.opensearch.core.tasks.TaskCancelledException;
            responseHandler.onFailure(new TaskCancelledException("Fetch task cancelled before execution: " + task.getReasonCancelled()));
        Executor executor
     *  the shard-fragment path uses but inlined here so workers don't need a shardId/IndexShard
     * Async variant that forks fragment execution onto the given executor and streams
        } finally {
                        request.getQueryId(),
    }
    }
                        } catch (Exception ignore) {}
     * <ul>
            // Engine sees the upstream session state, not the carrier.
            throw e;
                    "No ReaderContext for queryId="
        } catch (Exception e) {
                    // idempotent no-op).
                    int delegatedPredicateCount = delegation != null ? delegation.delegatedPredicateCount() : 0;
        BackendExecutionContext backendContext = null;
        StreamingFragmentResponseHandler responseHandler,
                        .anyMatch(n -> n.type() == InstructionType.SETUP_PARTIAL_AGGREGATE);
     * ONE node-scoped allocator that every backend stages its Arrow C Data Interface imports on, handed to
        }
                e
            producerState.getTargetStageId(),
        assert assertAscending(rowIds);
            final Schema schemaRef = capturedSchema;
            headerRoot.setRowCount(0);
     * broken), the call fails — there is no cold-start fallback because shard-global
     * {@link org.opensearch.analytics.spi.ShuffleSender} for hash-shuffle producer fragments.
            if (request.profile()) {
        AnalyticsSearchBackendPlugin backend,
        StreamingFragmentResponseHandler responseHandler
    }
        Reader reader,
        }
                    if (stream != null) {
import org.opensearch.common.concurrent.GatedCloseable;
        FragmentExecutionRequest.PlanAlternative plan,
                );
        }
        ShardScanExecutionContext ctx = new ShardScanExecutionContext(tableName, task, reader);
/**
            engine = backend.getSearchExecEngineProvider().createSearchExecEngine(ctx, backendContext);
                byte[] metricsJson = ctx.getExecutionMetrics();
            List.of(),
     * Backend id of the plan alternative {@code request} will actually run — the first whose backend is
                stream,
    public void executeWorkerFragmentStreamingAsync(
import java.util.concurrent.Executor;
        // serializes this as a regular frame; the coordinator's listener treats it the
        IndexShard shard,
    static boolean requestsRowIds(List<InstructionNode> instructions) {
    }
    }
                            "executeWorkerFragmentStreamingAsync failed [queryId={}, stageId={}, partition={}]",
        this.backends = backends;
    }
        ExchangeSinkContext sinkCtx = new ExchangeSinkContext(
            Iterator<EngineResultBatch> it = resultStream.iterator();
                    responseHandler.onCompleteWithMetrics(metricsJson);
                    }
    private TaskResourceTrackingService taskResourceTrackingService;
 * <p>Owns a service-lifetime {@link BufferAllocator} shared by every fragment, obtained as a child of
            if (node instanceof ShardScanInstructionNode scan) {
        IndexShard shard,
        task.setCancellationListener(() -> backend.cancelByContext(task.getNativeTaskId()));
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
    /**
                    backendContext = producer.engineContext();
    private Exception convertWith(String backendId, Exception e) {
                    resolved.queryId,
        // fill up before the pool itself is exhausted.
                    List<InstructionNode> instructions = plan.getInstructions();
import org.apache.arrow.vector.types.pojo.Field;
     *  to drive selection. */
     */
    }
        ShardScanExecutionContext ctx,
        FragmentExecutionRequest.PlanAlternative selectedPlan = null;
        boolean requiresTopDocs = requestsRowIds(resolved.plan.getInstructions());
            EngineResultStream stream = backend.fetchByRowIds(
    }
                    } else {
import org.opensearch.analytics.exec.action.FragmentExecutionRequest;
            /* downstream */ null,
    private final NamedWriteableRegistry namedWriteableRegistry;
        try (FragmentResources ctx = resources) {
        int count = 0;
        // Backend selection happens on the coordinator (PlanAlternativeSelector), so the
        String queryId,
    private ProducerSinkResolution resolveProducerSink(
        }
import org.opensearch.analytics.spi.BackendExecutionContext;
     * the backends via {@link ShardScanExecutionContext#setImportStagingAllocator} and
                            backendContext = handler.apply(node, ctx, backendContext);
     * {@code ResolvedFragment}.
     * (which ships batches out-of-band to worker peers via the shuffle transport), then emits a
        ctx.setIndexSettings(shard.indexSettings());
            capturedSchema = new Schema(List.of());
            // Additive (not set): the DataFusion engine registers its own native-cancel listener on
            responseHandler.onBatch(new EngineResultBatch() {
        } catch (TaskCancelledException | IllegalStateException | IllegalArgumentException e) {
        throws IOException {
            // session state (not the carrier). The drain into the sink happens later in
                resolved.plan.getInstructions()
            return new ProducerSinkResolution(partitionedSink, producerState.getDelegate());
    /** Converts {@code e} via the named backend's exception SPI; returns {@code e} unchanged if the backend is absent or doesn't recognize it. */
        ShardScanExecutionContext ctx
 * The OpenSearch Contributors require contributions made to
            rowIdVector.allocateNew(rowIds.length);
                    ShardScanExecutionContext ctx = new ShardScanExecutionContext(/* tableName */ "", task, /* reader */ null);
            readerContextStore.releaseAndFree(request.getQueryId(), shard.shardId());
                    long fragmentTookNanos = System.nanoTime() - startNanos;
                        + (rowIds == null ? "null" : rowIds.length)
        // worker body below may never reach its finally to free its buffer — and producer-side
        if (rowIds == null || rowIds.length == 0 || columns == null || columns.length == 0) {
            while (it.hasNext()) {
                        // zero-row response on the coordinator-bound stream so it has at
                        + shard.shardId()
 */
import org.opensearch.index.shard.IndexShard;
     */
                        + "setShuffleSenderDeps(client, threadPool, clusterService) must be called at plugin startup"
     * {@link org.opensearch.analytics.spi.SearchExecEngineProvider} must tolerate this and
    }
import org.opensearch.analytics.backend.AnalyticsOperationListener;
            client,
                        backend,
            }
    public void canMatch(
     * producer paths. Closes {@code sink} in {@code finally} so isLast markers ship before the
        String queryId,
            );
                    }
     *
                // Query phase failed: no fetch will follow, so free the reader eagerly (requiresTopDocs=false).
                if (capturedSchema == null) {
                    ctx.setFragmentBytes(plan.getFragmentBytes());
            new byte[0],
            }
                        delegatedPredicateCount,
import org.opensearch.core.action.ActionListener;
                        + (columns == null ? "null" : columns.length)
                        // response carries no row data (rowsProduced stays 0 on this stream);
     * hash-shuffle scan handlers can reach the buffer slice they need without a hard dependency
     * worker-fragment ({@link #executeWorkerFragmentStreamingAsync}) paths. When the instruction
        // the framework is missing — silently falling back to a separate root would break
    /**
    /**
            ctx.getTask() == null ? 0L : ctx.getTask().getId(),
                () -> new org.apache.logging.log4j.message.ParameterizedMessage(
        if (readerProvider == null) {
        try {
        NamedWriteableRegistry namedWriteableRegistry,
    public AnalyticsSearchService(
    }
            if (client == null || threadPool == null || clusterService == null) {
            Exception converted = backend.convertException(e);
        }
        } catch (Exception e) {
                VectorSchemaRoot batch = it.next().getArrowRoot();
        ctx.setQueryCache(shard.getQueryCache());
    ) {
                sink.feed(batch);
    /**
        // Source the service-level allocator from the unified framework's query pool so all
     * ≥1 schema-bearing frame before completeStream), so the coordinator's stage listener
 *
            }
        GatedCloseable<Reader> gatedReader,
     * caller tears down the engine; the sink contract is idempotent-on-close.
            );
     * Hash-shuffle producer routing, shared by the shard-fragment ({@link #startFragment}) and
        AnalyticsSearchBackendPlugin backend,
     */
}
                    );
     * just forwards. Fail-open on any error or unknown backend: match, no bounds.
                    "fetch on "
     * Plumb the transport client + thread pool + cluster state needed to construct a
            backendContext = applyInstructionHandlers(backend, resolved.plan.getInstructions(), ctx);
                    stream = engine.execute(ctx);
                try (ResolvedExecution exec = executeFragmentStreamingResolved(request, shard, task)) {
import org.apache.arrow.vector.types.pojo.Schema;
        }
    /**
        FragmentInstructionHandlerFactory factory = backend.getInstructionHandlerFactory();
        FragmentExecutionRequest request,
            // already transferred, close() is a no-op (implementations must be idempotent).
            throw new AssertionError("acquired ReaderContext has null reader for queryId=" + queryId);
     * {@link #executeFragmentStreamingAsync}.
     */
            // Stamp ctx.hasDeletedDocs so ShardScanInstructionHandler can route deletion-bearing
     * coordinator put in the plan (the same flag that makes the backend emit row ids).
import org.opensearch.tasks.TaskResourceTrackingService;
    private final Map<String, AnalyticsSearchBackendPlugin> backends;
        Schema capturedSchema = null;
            LOGGER.debug("drainAndEmitHeader: drained {} batches, closing sink", count);
     *       {@code responseHandler.onBatch} / {@code onComplete}.</li>
                AnalyticsSearchBackendPlugin acceptingBackend = backends.get(acceptingBackendId);
    }
            }
            while (it.hasNext()) {
        AnalyticsShardTask task,
                        if (LOGGER.isDebugEnabled() && metricsJson != null) {
        // Parented at the ROOT rather than the query pool, and unbounded: a C Data import that fails
                // No delegation, but a non-Lucene driving backend will inject the reserved match-all
                    "[FragmentExecution] failed to start streaming fragment on shard={} queryId={} stageId={}",
            }
                return alt.getBackendId();
    private record ResolvedFragment(IndexReaderProvider readerProvider, FragmentExecutionRequest.PlanAlternative plan, String queryId,
        // partitioning operates on the engine's terminal output, not on a plan.
                    capturedSchema = batch.getSchema();
        for (InstructionNode node : instructions) {
        // Emit one zero-row response carrying the captured schema. The Flight transport
        this.taskResourceTrackingService = service;
     */
                FragmentInstructionHandler handler;
            responseHandler.onFailure(
                task.getNativeTaskId(),
            executor.execute(() -> {
            }
     * iterator here lets the native engine apply backpressure when the channel is slow.
import org.opensearch.analytics.spi.FilterDelegationHandle;
import org.opensearch.analytics.backend.FragmentExecutionStats;
        if (task.isCancelled()) {
        //
            }
                        rowsProduced,
            if (delegation != null) {
