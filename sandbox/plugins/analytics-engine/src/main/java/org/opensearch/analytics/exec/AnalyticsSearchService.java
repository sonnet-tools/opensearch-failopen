                                shard.shardId(),  
    /**  
            );  
        this.client = client;
                task.getNativeTaskId(),
        this.threadPool = threadPool;  
            .createPartitionedSink(
        this.allocator = queryPool.newChildAllocator("analytics-search-service", 0, Long.MAX_VALUE);
        }
            responseHandler.onFailure(new TaskCancelledException("Fetch task cancelled before execution: " + task.getReasonCancelled()));
     * single zero-row, schema-bearing response on the coordinator-bound stream so the streaming
    /**  
                    return 0;
                        Iterator<EngineResultBatch> it = stream.iterator();
            // bytes, because close() sets isClosed before its leak check. Report and let process exit  
     * {@code executor} so the iterator drain doesn't pin the transport thread — mirrors
                // binding after query execution completes.
        // case where a stage genuinely has multiple value-producing alternatives — pick the  
                        // producer path). drainIntoPartitionedSink closes the sink when done.  
                        // Producer worker: ship batches out-of-band via the partitioned sink and emit
    /**  
            listener.onFragmentFailure(resolved.queryId, resolved.stageId, resolved.shardIdStr, e);  
     */  
                } catch (Exception suppressed) {
                        stats  
                break;  
    }
        String sortColumn,  
            listener.onResponse(new AnalyticsCanMatchResponse(true));  
                );  
        String queryId,
    // ── Assertion helpers (invoked only when -ea is enabled; bodies are dead in production) ──  
                        task.getId(),  
     */
                if (metricsJson != null) {
        return executeFragmentStreamingResolved(request, shard, task).resources;
            }
            // generic 500. Only wrap as a generic RuntimeException when conversion found nothing.  
                        Iterator<EngineResultBatch> it = exec.resources().stream().iterator();
                        responseHandler.onComplete();
            responseHandler.onFailure(e);
     * {@link AnalyticsSearchBackendPlugin#fetchByRowIds}. Deliberately not per-stream: the Flight transport  
                            engine.close();
     * Until set, fragments that emit a {@code ShuffleProducerOutputState} fail fast with a typed  
import org.opensearch.index.engine.dataformat.DocumentInput;
     * builds its reused stream root on the first emitted batch's vector allocator and charges that same
        try {
    private ShuffleBufferRegistry shuffleBufferRegistry;
                    + ". Available: "
                if (capturedSchema == null) {  
        ReaderContext readerContext,
            }  
     * Acquires the per-shard {@link ReaderContext}, materialises the rowId vector, invokes
     * broken), the call fails — there is no cold-start fallback because shard-global  
            // Fetch is terminal: free the reader eagerly.
            ShardScanExecutionContext ctx = buildContext(request, readerContext.getReader(), resolved.plan, shard, task);  
     */  
            if (shuffleBufferRegistry != null) {
        SearchExecEngine<ShardScanExecutionContext, EngineResultStream> engine = null;
            }  
                    // stage + partition). The buffer holds the partition's payload as on-heap
            producerState.getQueryId(),  
                } finally {  
            // Fetch is the terminal phase: no fetch follows, so close() frees the reader eagerly.  
                // queries have isolated FFM callback bindings. The returned cleanup removes the
                        + request.getQueryId()
    }  
            );  
        return ctx;  
    private final AnalyticsOperationListener listener;
        if (readerContext == null) {
     *  the shard-fragment path uses but inlined here so workers don't need a shardId/IndexShard  
        TaskResourceTrackingService service = taskResourceTrackingService;  
        BufferAllocator queryPool = nativeAllocator.getPoolAllocator(NativeAllocatorPoolConfig.POOL_QUERY);  
     * <p>Builds a {@link ShardScanExecutionContext} with {@code reader=null}; the backend's
}  
                    "No ReaderContext for queryId="  
                sender,
                    listener.onFragmentSuccess(  
            }
/*  
     * </ul>  
        StreamingFragmentResponseHandler responseHandler,  
                BackendExecutionContext backendContext = null;
            // exit"). Closing on a non-zero balance would throw from BaseAllocator#close AND strand the
     * Holder for the result of {@link #resolveProducerSink}: the partitioned sink to drain into
                    );
     * single header-only zero-row response on the coordinator-bound stream. Without that  
    }
        ReaderContextStore readerContextStore
                try {
            try {
            // ShuffleProducerOutputState, build the framework ShuffleSender + the backend's  
import org.opensearch.analytics.backend.EngineResultStream;  
                        // producer output reaches the worker peer-to-peer via the shuffle transport.
            // worker); addCancellationListener composes so both fire.  
import java.util.Iterator;
                    throw new IllegalStateException("Filter delegation requires a tracked task for per-query isolation");
            // populated this query's buffers on the node — clear them here (same backstop as the  
            responseHandler.onFailure(e);  
    private static final Logger LOGGER = LogManager.getLogger(AnalyticsSearchService.class);
            // Engine sees the upstream session state, not the carrier.  
                    return null;
    }
     * chain produced a {@link ShuffleProducerOutputState}, builds the framework ShuffleSender + the  
     * transfer that batch into the sink. If the engine emits zero batches, fall back to an  
            LOGGER.error(
            } else {  
                        try {
        // ShardScanExecutionContext#getImportStagingAllocator), so the staging target must not be able to
    ) throws Exception {
     * allocator must be long-lived (not closed per-request)"), then frees it asynchronously with its own  
        if (rowIds == null || rowIds.length == 0 || columns == null || columns.length == 0) {
                    shard.shardId(),
        this(backends, List.of(), nativeAllocator, namedWriteableRegistry, readerContextStore);
                }
    }
     * Async variant for hash-shuffle worker fragments. Skips {@code IndicesService.getShard}
                        shard.shardId().toString(),  
                SearchExecEngine<ShardScanExecutionContext, EngineResultStream> engine = null;  
                } else {  
                LOGGER.debug("[FragmentExecution] shard={} task={}", shard.shardId(), task.getId());
    /**
        }  
    ) {
        throw new IllegalArgumentException(
     * Evaluates whether a shard can possibly match the given filter predicates.
                importStagingAllocator.close();
            );  
                    ExchangeSink partitionedSink = producer.partitionedSink();
        AnalyticsSearchBackendPlugin backend,
    public void executeFetchByRowIdsAsync(
     * <p>Schema selection: take the schema from the first batch the engine emits and
    ) {  
    }
                        for (InstructionNode node : instructions) {
                        + shard.shardId()
                // backend (it applies liveDocs natively) or the shard has no deletions.
     * route through its session-context execution path rather than the shard-scan one.
    }
    /**  
                    // Free the shuffle buffer this worker task consumed (keyed by the worker's own
     * exactly one, whatever the execution path.  
                // expressions) so the FFM callbacks can serve it. Skipped when Lucene is the driving
 * this file be licensed under the Apache-2.0 license or a
        }
     * Applies each instruction handler in order. Each handler reads the previous handler's
                new ParameterizedMessage(
                        drainIntoPartitionedSink(partitionedSink, stream, responseHandler);
        }
            return;
                        request.getStageId(),
                        request.getQueryId(),
    }  
    /**
            task.addCancellationListener(() -> shuffleBufferRegistry.clearForQuery(cancelQueryId));
                try {  
    private String selectedBackendId(FragmentExecutionRequest request) {
            // Fetch is terminal: free the reader eagerly.  
    private final BufferAllocator importStagingAllocator;  
                service.taskExecutionFinishedOnThread(taskId, threadId);
            FragmentInstructionHandler handler = factory.createHandler(node);
        }
        StreamingFragmentResponseHandler responseHandler,
    ) {
        return backend.getExchangeSinkProvider()  
import org.apache.arrow.vector.types.pojo.Field;
            stream = engine.execute(ctx);  
    private ResolvedExecution executeFragmentStreamingResolved(
                long contextId = task.getId();  
                    // Cascaded shuffle: a worker fragment can ALSO be a shuffle producer (its plan
                trackerCleanup = backend.configureFilterDelegation(contextId, handle, buildDelegationThreadTracker(task), backendContext);  
        byte[] filterBytes,
            }
        ShuffleSender sender = new ShuffleSenderImpl(
        ExchangeSinkContext sinkCtx = new ExchangeSinkContext(
                    outstanding  
    }
 * <p>Does NOT hold {@code IndicesService} — receives an already-resolved  
import org.opensearch.analytics.spi.FragmentInstructionHandler;
                        + request.getBackendId()
     * {@link org.opensearch.analytics.spi.SearchExecEngineProvider} must tolerate this and  
                "No plan alternative matches available backends. Alternatives: "
        return new DelegationThreadTracker() {
    }
            FragmentResources resources = startFragment(request, resolved, shard, task);  
            );  
                // Register handle and tracker together under the query's contextId so concurrent  
                    );
        }
                    } else {  
            final String cancelQueryId = request.getQueryId();
                );
import org.opensearch.arrow.allocator.ArrowNativeAllocator;
            readerContextStore.releaseAndFree(request.getQueryId(), shard.shardId());
     * framework constructs the {@link org.opensearch.analytics.spi.ShuffleSender} pre-stamped  
    private org.opensearch.threadpool.ThreadPool threadPool;  
    ) {  
                    resolved.shardIdStr  
            // engine's call would overwrite this buffer-cleanup hook (→ leak on cancel of a running
        }
        }  
                    backendContext = producer.engineContext();
     */  
    ) {
                + backends.keySet()  
                    return vsrRef;
        ReaderContext readerContext = readerContextStore.createContext(request.getQueryId(), shard.shardId(), gatedReader);
        ReaderContextStore readerContextStore  
                FragmentInstructionHandler handler;
            for (int i = 0; i < rowIds.length; i++) {
     * the child's own {@code close()} deregisters) — one stranded allocator per query.
import java.util.Map;  
        long[] rowIds = request.getRowIds();
                long rowsProduced = 0;
            producerState.getTargetStageId(),
                @Override  
                count++;
                        rowsProduced,
     * Async variant that forks fragment execution onto the given executor and streams
                    ProducerSinkResolution producer = resolveProducerSink(  
            // serves the reserved match-all collector (registered further below when there is no  
                byte[] metricsJson = ctx.getExecutionMetrics();  
    public interface StreamingFragmentResponseHandler {
import org.opensearch.analytics.backend.AnalyticsOperationListener;
        };
    }  
    private ResolvedFragment resolveFragment(FragmentExecutionRequest request, IndexShard shard) {
                        delegatedPredicateCount,  
        // follows, rather than us inferring it from the row-id signal here.  
                            handler = factory.createHandler(node);
        assert task != null : "fetch on " + shard.shardId() + " requires a non-null AnalyticsShardTask";  
    /**
                long threadId = Thread.currentThread().threadId();
 * {@link ShardScanExecutionContext}, and invokes the backend's {@link SearchExecEngine}  
                sinkCtx  
    }
    private boolean assertFetchInvariants(ReaderContext readerContext, String queryId) {
            ExchangeSink partitionedSink = producer.partitionedSink();
    private DelegationThreadTracker buildDelegationThreadTracker(Task task) {
        // finally, so a leak report from the service allocator cannot skip the staging allocator's release.
                        request.getStageId()
                // Query phase failed: no fetch will follow, so free the reader eagerly (requiresTopDocs=false).
        return false;
        this.readerContextStore = readerContextStore;
                }
     *   <li><b>Standard path:</b> batches go back to the originating coordinator through
                        // zero-row response on the coordinator-bound stream so it has at
            // ACTUALLY-SELECTED backend so a resource-exhaustion failure surfaces as 429 instead of a
import org.opensearch.analytics.exec.action.FetchByRowIdsRequest;
            throw e;
                    if (stream != null) {
        );  
    /**  
    }
import org.opensearch.analytics.spi.BackendExecutionContext;
                            responseHandler.onCompleteWithMetrics(metricsJson);
                sink.feed(batch);  
            return;
                    if (shuffleBufferRegistry != null) {
 * {@code FlightOutboundHandler#processBatchTask}), keeping transfers same-root and avoiding the known
                    }
    public void setShuffleSenderDeps(  
                    List<InstructionNode> instructions = plan.getInstructions();
        BackendExecutionContext backendContext = null;  
     * Plumb the transport client + thread pool + cluster state needed to construct a
            listener.onResponse(new AnalyticsCanMatchResponse(result.canMatch(), result.bounds()));
            responseHandler.onFailure(
 * to produce results.
     */  
            );
        FragmentExecutionRequest request,  
     * same backend that produced the failure. Returns null if none is registered.
     * coordinator put in the plan (the same flag that makes the backend emit row ids).
                        .getInstructions()  
                ctx
     */
                    }
                    .stream()  
        // first one whose backend is registered locally.
    }
                    + request.getPlanAlternatives().stream().map(FragmentExecutionRequest.PlanAlternative::getBackendId).toList()  
 */  
import org.opensearch.analytics.spi.ExchangeSink;
import org.opensearch.analytics.exec.action.FragmentExecutionRequest;
    static boolean requestsRowIds(List<InstructionNode> instructions) {
                allocator,  
            if (values[i] < values[i - 1]) {
        if (capturedSchema == null) {  
     *       {@code responseHandler.onBatch} / {@code onComplete}.</li>
        // Fallback table name only — the backend derives the actual registration name from the  
import org.opensearch.analytics.spi.InstructionNode;
        FetchByRowIdsRequest request,
        StreamingFragmentResponseHandler responseHandler,  
            });
    public void setShuffleBufferRegistry(ShuffleBufferRegistry registry) {
        ShardScanExecutionContext ctx,  
    private FragmentResources startFragment(FragmentExecutionRequest request, ResolvedFragment resolved, IndexShard shard, Task task)
    public void canMatch(
            @Override  
     */
        }
        AnalyticsShardTask task,
            } catch (Exception suppressed) {
    }  
                long contextId = task.getId();  
        }
        Executor executor  
     *
     *       {@code ShuffleProducerOutputState}, the engine's output drains into the partitioned
        }
        try {
            // already transferred, close() is a no-op (implementations must be idempotent).  
     * plugin startup; null until then, in which case hash-shuffle handlers see a null registry
                        + (rowIds == null ? "null" : rowIds.length)
                    "No backend registered for backendId="
import org.apache.arrow.vector.VectorSchemaRoot;  
                }  
     *       response handler still receives a single {@code onComplete} (no batches) so the  
    public AnalyticsSearchService(
            threadPool,
            if (request.profile()) {
     * Drains a hash-shuffle producer fragment's engine output into its {@code partitionedSink}
            DelegationDescriptor delegation = resolved.plan.getDelegationDescriptor();
            }
        // partitioning operates on the engine's terminal output, not on a plan.
            ctx.getTask() == null ? 0L : ctx.getTask().getId(),
            long outstanding = importStagingAllocator.getAllocatedMemory();
            // A stream still in flight at shutdown keeps its batches charged to the staging allocator until
     * unavailable — {@code FilterTreeCallbacks} null-guards the tracker (tracking is simply
     */
                    readerContextStore.freeContext(request.getQueryId(), shard.shardId());
            queryId,  
                    }
        try (FragmentResources ctx = resources) {  
     * backend's partitioned sink and unwraps the carrier so the engine factory sees the upstream
                    // reach here. Guarded for non-shuffle workers (registry null / no such buffer →  
     * streams that {@link org.opensearch.analytics.spi.ShuffleScanInstructionNode} handlers
            rowIdVector.setValueCount(rowIds.length);
                        try {
    }
    /**  
     * <ul>  
    public void setTaskResourceTrackingService(TaskResourceTrackingService service) {  
     * Callback interface for async fragment streaming results.
                    resolved.queryId,
     * Backend id of the plan alternative {@code request} will actually run — the first whose backend is  
                public VectorSchemaRoot getArrowRoot() {  
                partitionedSink,  
                    ctx.setAllocator(allocator);
            // Lucene backend both sources the shard's hasDeletions signal (probed just below) and
        try {
                    String filterTreeShape = delegation != null ? delegation.treeShape().name() : null;
                        + ", columns="
                readerContext,  
                return alt.getBackendId();
        ExchangeSink sink,
                        + shard.shardId()  
                        usedSecondaryIndex,
     *   <li><b>Hash-shuffle producer path:</b> when the fragment's instruction chain produced a  
        } catch (Exception e) {
            // session state (not the carrier). The drain into the sink happens later in
        } finally {
                }
     * register on the session context (created by {@link
     *  
                }  
    private final NamedWriteableRegistry namedWriteableRegistry;  
                null,
                    responseHandler.onFailure(e);
        } catch (Exception e) {  
                throw new IllegalStateException(  
     */  
     */
import org.opensearch.analytics.backend.EngineResultBatch;
                readerContextStore,
                        // a single header-only frame on the coordinator-bound stream (mirrors the shard
            responseHandler.onFailure(
            return new ProducerSinkResolution(partitionedSink, producerState.getDelegate());
     * Builds the backend-specific partitioned sink for a hash-shuffle producer fragment. The
                    // Extract DataFusion execution metrics only when needed  
            }
                        hasPartialAggregate,
import org.apache.logging.log4j.message.ParameterizedMessage;
    private Exception convertWith(String backendId, Exception e) {
     * Dispatches to the named backend. Fail-open on any error or unknown backend.  
                            backendContext.close();
 * cross-allocator bug with foreign-backed buffers from the C Data Interface.
            if (backends.containsKey(alt.getBackendId())) {
            return new FragmentResources(
            ExchangeSink partitionedSink = buildPartitionedSink(backend, producerState, ctx, queryId, stageId);
            }
            if (backend == null) {
                        filterTreeShape,
        org.opensearch.transport.client.Client client,
                selectedPlan = alt;
        String backendId,
import org.opensearch.analytics.spi.FragmentInstructionHandlerFactory;  
        // serializes this as a regular frame; the coordinator's listener treats it the  
                // Filter delegation routes per-query state via taskId; without a task we cannot  
    public BufferAllocator getImportStagingAllocator() {
     *       coordinator's transport stream closes cleanly. The peer-to-peer shuffle traffic
import org.opensearch.analytics.spi.AnalyticsSearchBackendPlugin;
        return importStagingAllocator;  
            "No worker plan alternative matches available backends. Alternatives: "  
        if (readerContext.getReader() == null) {
                                new String(metricsJson, StandardCharsets.UTF_8)
            );
import org.opensearch.analytics.exec.task.AnalyticsShardTask;  
        // effect immediately via Arrow's parent-cap check at allocateBytes — no listener needed.
        // Emit one zero-row response carrying the captured schema. The Flight transport
     * The node-scoped allocator Arrow C Data imports are staged on. Owned (and closed) here; the
     * never fires onResponse(null) and the producer task hangs.  
            sink.close();
            producerState.getSide()
                            request.getStageId(),  
                listener.onResponse(new AnalyticsCanMatchResponse(true));  
            AnalyticsSearchBackendPlugin.CanMatchResult result = backend.canMatchWithBounds(shard, filterBytes, sortColumn);  
        // buffers on cancel is safe: a cancelled query won't consume them again. Idempotent.  
    }
            // shards through the indexed deleted-doc filtering path.
            throw e;
                    "startFragment failed [queryId={}, stageId={}, shardId={}]",  
     * As {@link #canMatch(IndexShard, byte[], String, ActionListener)}, plus the shard-wide
        }  
        // Producer's ExchangeSinkContext carries no child inputs (the producer IS the source) and
            while (it.hasNext()) {
     * instruction list is empty.  
                        + " on "  
            responseHandler.onFailure(
                    long fragmentTookNanos = System.nanoTime() - startNanos;
                @Override
        ctx.setIndexSettings(shard.indexSettings());  
import org.opensearch.OpenSearchException;  
                        if (LOGGER.isDebugEnabled() && metricsJson != null) {  
                } catch (Exception ignore) {}
        // TODO: the coordinator (which knows the query shape) should tell us whether a fetch
 * @opensearch.internal
        }
            );
     * error (rather than null-deref) so misconfiguration is obvious during plugin startup.
        FragmentExecutionRequest.PlanAlternative plan,
 * per service means memory accounting is reported at the service level. For the streaming path, Arrow
            }
     * transport has ≥1 frame to terminate on. Reader-independent — shared by the shard-fragment
                            request.getPartitionIndex()
        FragmentResources resources = null;  
    public AnalyticsSearchService(
                responseHandler.onBatch(it.next());  
        try {  
        /** Called with execution metrics when profiling is enabled. Default delegates to onComplete(). */  
                        } catch (Exception ignore) {}  
    /**
            ProducerSinkResolution producer = resolveProducerSink(backend, backendContext, ctx, resolved.queryId, resolved.stageId);
                new IllegalStateException(  
        // Substrait fragment's NamedTable (which carries the planner's logical alias/pattern name),
            responseHandler.onFailure(e);  
            // Close the sink here so isLast markers ship before FragmentResources.close() tears
                rowIdVector,
                    // workers (the common leaf-consumer case) get a null sink and drain to the response.
        this.clusterService = clusterService;
        canMatch(shard, filterBytes, backendId, null, listener);  
     * batches back through the channel. The transport thread returns immediately.  
        } catch (Exception e) {  
                        } catch (Exception ignore) {}
import org.apache.arrow.memory.BufferAllocator;
                        fragmentTookNanos,
    ) {
                        try {  
                    "AnalyticsSearchService: shuffle sender deps not plumbed; "
        AnalyticsSearchBackendPlugin backend = backends.get(backendId);
                FilterDelegationHandle handle = acceptingBackend.getFilterDelegationHandle(delegation.delegatedExpressions(), ctx);
import org.opensearch.analytics.spi.ShuffleProducerOutputState;
     * QTF fetch phase: retrieves specific rows by global row ID via the backend SPI and
                        FragmentInstructionHandlerFactory factory = backend.getInstructionHandlerFactory();  
    private static boolean assertAscending(long[] values) {  
        Runnable trackerCleanup = null;
                    AnalyticsSearchBackendPlugin backend = backends.get(plan.getBackendId());
     * ≥1 schema-bearing frame before completeStream), so the coordinator's stage listener
                trackerCleanup = backend.configureFilterDelegation(contextId, handle, buildDelegationThreadTracker(task), backendContext);
        // On cancel, release a fetch parked in the native pull via cooperative cancellation, not  
        GatedCloseable<Reader> gatedReader = resolved.readerProvider.acquireReader();
                        task.getHeader(Task.X_OPAQUE_ID)
        }
        this.namedWriteableRegistry = namedWriteableRegistry;
                engine,
        IndexShard shard,
        BigIntVector rowIdVector = null;
                            request.getQueryId(),
            rowIdVector = new BigIntVector(DocumentInput.ROW_ID_FIELD, allocator);
     * <p>Reuses the {@link ReaderContext} opened during the query phase. If the context
     * the backends via {@link ShardScanExecutionContext#setImportStagingAllocator} and
                        responseHandler.onComplete();
                    resolved.stageId,
            // Hash-shuffle producer routing: if the instruction chain produced a
        }
    public AnalyticsSearchService(Map<String, AnalyticsSearchBackendPlugin> backends, ArrowNativeAllocator nativeAllocator) {  
 *
            throw new AssertionError("no backends registered — service constructor invariant violated");
        // Caller contract: rowIds must already be sorted ascending (RowSelection invariant on
 * {@link IndexShard} from the transport action.
                        if (request.profile() && metricsJson != null) {
/**  
        }  
                    // output feeds a higher shuffle. Same instruction-driven mechanism as the shard  
    /**
        FragmentExecutionRequest request,  
        }
        try (VectorSchemaRoot headerRoot = VectorSchemaRoot.create(capturedSchema, allocator)) {  
        );
        task.setCancellationListener(() -> backend.cancelByContext(task.getNativeTaskId()));
            LOGGER.warn(
                        + " on "
                    return schemaRef.getFields().stream().map(Field::getName).toList();  
                throw converted instanceof RuntimeException re ? re : new RuntimeException(converted);  
                stream,
            // partitioned sink, and unwrap the carrier so the engine factory sees the upstream
                        .anyMatch(n -> n.type() == InstructionType.SETUP_PARTIAL_AGGREGATE);
                + ". Available: "
                    // path (resolveProducerSink), so no dedicated stage type is needed. Non-producer
import org.apache.arrow.vector.types.pojo.Schema;
    private void drainFetchByRowIds(  
    }  
     * just forwards. Fail-open on any error or unknown backend: match, no bounds.  
            // the Flight channel frees its stream root — and that free is posted to the flight executor,  
                        .stream()
        } catch (Exception e) {
     * producer paths. Closes {@code sink} in {@code finally} so isLast markers ship before the
     * with {@code (queryId, targetStageId, side)} from {@code producerState}, then hands it to
            ctx.setHasPartialAggregate(
            AnalyticsSearchBackendPlugin backend = backends.get(backendId);
                        + "setShuffleSenderDeps(client, threadPool, clusterService) must be called at plugin startup"
    /**
    /**
            return;  
        // native side). Asserted here so violations are caught in dev builds before the FFM call.  
        ShardScanExecutionContext ctx
                producerState.getTargetWorkerNodeIds(),
    ) {
                )
                    // idempotent no-op).
                    }  
        this.nativeAllocator = nativeAllocator;
import org.opensearch.index.engine.exec.IndexReaderProvider;
            if (rowIdVector != null) rowIdVector.close();  
        ctx.setAllocator(allocator);  
            if (backendContext != null) {
                        + (columns == null ? "null" : columns.length)  
                        } else {  
        IndexShard shard,  
                    );
        ctx.setMapperService(shard.mapperService());
        }  
                        }
                ),
     * another (segment topology may differ across reopens).
                    int delegatedPredicateCount = delegation != null ? delegation.delegatedPredicateCount() : 0;  
        try {
        this.taskResourceTrackingService = service;
        Executor executor
    }
            backendContext = applyInstructionHandlers(backend, resolved.plan.getInstructions(), ctx);
        } catch (TaskCancelledException | IllegalStateException | IllegalArgumentException e) {
                            shuffleBufferRegistry.removeBuffer(request.getQueryId(), request.getStageId(), request.getPartitionIndex());
 * Flight's outbound handler co-locates its transfer target on the same root (see  
     */
    private FragmentExecutionRequest.PlanAlternative selectWorkerPlan(WorkerFragmentRequest request) {
                    ctx.setNamedWriteableRegistry(namedWriteableRegistry);
    private record ResolvedFragment(IndexReaderProvider readerProvider, FragmentExecutionRequest.PlanAlternative plan, String queryId,
            if (client == null || threadPool == null || clusterService == null) {
        ShardScanExecutionContext ctx,
import org.opensearch.analytics.backend.SearchExecEngine;
            }
                    FragmentExecutionStats stats = new FragmentExecutionStats(  
            // Handle exchange — if plan has delegation, ask accepting backend for handle and pass to driving
                resolved.plan.getInstructions()
        // fill up before the pool itself is exhausted.
                public int getRowCount() {
                if (task == null) {  
                        responseHandler.onComplete();
            // FragmentResources keeps the rowIdVector alive until the stream drains — closing
        for (FragmentExecutionRequest.PlanAlternative alt : request.getPlanAlternatives()) {  
     * the backend's {@code createPartitionedSink}. The backend never sees transport types.
                    if (exec.resources().partitionedSink() != null) {  
                    capturedSchema = batch.getSchema();
                ),
        int stageId, String shardIdStr) {
            onComplete();
    ) {
        } catch (Exception e) {
    private ExchangeSink buildPartitionedSink(
                try {  
     * ({@link #startFragment}) and worker-fragment ({@link #executeWorkerFragmentStreamingAsync})  
                            rowsProduced += batch.getRowCount();
import org.opensearch.analytics.spi.ShuffleBufferRegistry;
                    );  
            // this same task during engine.execute. setCancellationListener is single-slot and the
                        byte[] metricsJson = exec.resources().getExecutionMetrics();
                () -> new org.apache.logging.log4j.message.ParameterizedMessage(
                    FragmentExecutionRequest.PlanAlternative plan = selectWorkerPlan(request);
                return;
        } finally {
     * Hash-shuffle producer routing, shared by the shard-fragment ({@link #startFragment}) and
                )
 * the framework's QUERY pool via {@link ArrowNativeAllocator#getPoolAllocator(String)}. One allocator
            // which may already refuse tasks (FlightServerChannel#close logs "root reclaimed at process
 *
        ctx.setQueryCache(shard.getQueryCache());  
            // delegation). See FilterDelegationHandle#LIVE_DOCS_MATCH_ALL_ANNOTATION_ID.
 * compatible open source license.
        return backendContext;
                    boolean usedSecondaryIndex = delegation != null;
    }
        String queryId,
     * transport, and one that is left open instead stays registered in the root's {@code childAllocators}
        try {  
        Schema capturedSchema = null;
import org.opensearch.analytics.spi.DelegationDescriptor;  
    private final ArrowNativeAllocator nativeAllocator;
            }
        }  
import org.opensearch.analytics.spi.ExchangeSinkContext;  
            ctx.getAllocator(),
        boolean requiresTopDocs = requestsRowIds(resolved.plan.getInstructions());
import org.opensearch.common.concurrent.GatedCloseable;  
        //  
        if (readerProvider == null) {  
        }  
        // Backend selection happens on the coordinator (PlanAlternativeSelector), so the
            throw new IllegalArgumentException(
    ) {
            stageId,
        IndexReaderProvider readerProvider = shard.getReaderProvider();
     * {@code ResolvedFragment}.
        assert assertReaderInvariants(gatedReader, readerContext, request.getQueryId(), shard);  
     * registered locally. Mirrors {@link #resolveFragment}'s selection so exception conversion uses the
                rowIdVector.set(i, rowIds[i]);
        String queryId,
        try {
            listener.onFragmentFailure(resolved.queryId, resolved.stageId, resolved.shardIdStr, e);  
        EngineResultStream resultStream,  
            if (node instanceof ShardScanInstructionNode scan) {  
     *  to drive selection. */
                        ctx,  
     * {@link TaskResourceTrackingService}. Returns {@code null} when task resource tracking is  
        } catch (OpenSearchException e) {
    public void executeFragmentStreamingAsync(
                                "[FragmentMetrics] shard={} metrics={}",
                        } catch (Exception ignore) {}
            throw new AssertionError("acquired ReaderContext has null reader for queryId=" + queryId);
    private final BufferAllocator allocator;
        FragmentExecutionRequest request,  
import org.opensearch.analytics.exec.action.WorkerFragmentRequest;  
        ShuffleProducerOutputState producerState,  
        }
        drainIntoPartitionedSink(ctx.partitionedSink(), ctx.stream(), responseHandler);
        for (int i = 1; i < values.length; i++) {
        listener.onPreFragmentExecution(request.getQueryId(), request.getStageId(), shardIdStr);
        }
    /**
        return true;  
                            "executeWorkerFragmentStreamingAsync failed [queryId={}, stageId={}, partition={}]",
                    }  
                // Collector for deleted-doc filtering. Register a Lucene handle (no coordinator  
        ctx.setShuffleBufferRegistry(shuffleBufferRegistry);
import org.apache.logging.log4j.Logger;
    ) {
     */
    }
                }
                            stream.close();  
                producerState.getPartitionCount(),  
import org.opensearch.arrow.spi.NativeAllocatorPoolConfig;
            // executor.execute rejected (pool shutdown / saturated) before the worker body ran, so
                    ctx.setShuffleBufferRegistry(shuffleBufferRegistry);
                @Override
            // it earlier would pull off-heap memory out from under the native FFM call.
            public long trackStart() {  
            /* downstream */ null,  
                    if (engine != null) {  
                        + shard.shardId()
                    DelegationDescriptor delegation = resolved.plan().getDelegationDescriptor();
        // Source the service-level allocator from the unified framework's query pool so all
                e
            List.of(),
        this(backends, List.of(), nativeAllocator, null, null);
        if (gatedReader == null) {
        this.shuffleBufferRegistry = registry;  
     * iterator here lets the native engine apply backpressure when the channel is slow.
        IndexShard shard,  
            );  
                    if (backendContext != null) {
     * (createProvider/createCollector/collectDocs) to the query's task via
                            responseHandler.onComplete();
    /**
            // never reached / never finished the engine construction — if the handle was
        try {
                return alt;
                } catch (Exception e) {
                final long startNanos = System.nanoTime();  
            backendContext = handler.apply(node, ctx, backendContext);
                        + " requires non-empty rowIds and columns; got rowIds="  
     * {@link BackendExecutionContext} and returns the next one. Returns {@code null} when the
                }
                        backendContext,
        ctx.setFragmentBytes(plan.getFragmentBytes());
     */
 * SPDX-License-Identifier: Apache-2.0
            // does NOT redundantly close it (see comment in FragmentResources.close()).
 * The OpenSearch Contributors require contributions made to  
import org.apache.logging.log4j.LogManager;  
                    if (partitionedSink != null) {  
                        e  
        AnalyticsShardTask task,
                    e.addSuppressed(suppressed);
                    // carries a ShuffleProducerInstructionNode) — e.g. an intermediate join level whose
     * and reader acquisition: workers don't scan shards, they read only from named-input  
                service.taskExecutionStartedOnThread(taskId, threadId);
                    } else {  
                        backend,
                }
            return null;  
     * the backend, drains the stream into {@code responseHandler}, and releases all resources
            throw new AssertionError("ReaderContext returned null reader for queryId=" + queryId);  
 *  
        this.backends = backends;
     * hash-shuffle scan handlers can reach the buffer slice they need without a hard dependency  
            }  
        this.importStagingAllocator = allocator.getRoot().newChildAllocator("arrow-import-staging", 0, Long.MAX_VALUE);  
     */  
        return null;
        IndexShard shard,
        if (backend == null) {
                            LOGGER.debug(
                    ctx.setImportStagingAllocator(importStagingAllocator);  
            EngineResultStream stream = backend.fetchByRowIds(
                responseHandler.onComplete();
    private final ReaderContextStore readerContextStore;
                        // response carries no row data (rowsProduced stays 0 on this stream);  
    private TaskResourceTrackingService taskResourceTrackingService;  
        ResolvedFragment resolved = resolveFragment(request, shard);
                e
import org.opensearch.analytics.spi.DelegationThreadTracker;
                        while (it.hasNext()) {
        for (FragmentExecutionRequest.PlanAlternative alt : request.getPlanAlternatives()) {  
    /** Selects the first plan alternative whose backend is registered on this node — same logic
                requiresTopDocs,
        } catch (OpenSearchException e) {
            listener.onFragmentFailure(resolved.queryId, resolved.stageId, resolved.shardIdStr, e);  
        WorkerFragmentRequest request,
        FragmentInstructionHandlerFactory factory = backend.getInstructionHandlerFactory();
                    ShardScanExecutionContext ctx = new ShardScanExecutionContext(/* tableName */ "", task, /* reader */ null);  
        if (backendContext instanceof ShuffleProducerOutputState producerState) {
            );  
                            responseHandler.onBatch(batch);
        ctx.setQueryCachingPolicy(shard.getQueryCachingPolicy());
        AnalyticsSearchBackendPlugin backend = backends.get(request.getBackendId());
        GatedCloseable<Reader> gatedReader,  
                )
        } catch (Exception e) {
     * Build a {@link DelegationThreadTracker} that attributes FFM delegation callback work
                        + " — query phase missing or context expired"
                producerState.getHashKeyChannels(),
                new FragmentResources(readerContextStore, readerContext, engine, stream, trackerCleanup, false).close();  
            throw e;
            // down the engine. close() is idempotent on the sink contract; FragmentResources  
        AnalyticsShardTask task,
 * <p>Owns a service-lifetime {@link BufferAllocator} shared by every fragment, obtained as a child of  
import org.opensearch.analytics.spi.ShardScanInstructionNode;  
                String acceptingBackendId = delegation.delegatedExpressions().getFirst().getAcceptingBackendId();
            resources = new FragmentResources(readerContextStore, readerContext, null, stream, null, rowIdVector, false);
        ctx.setShardId(shard.shardId());
        // Arrow's same-root invariant for cross-plugin handoff.
     *
                        }  
                        while (it.hasNext()) {
                return threadId;  
        EngineResultStream stream = null;
            }
     * the engine should run against (the upstream session state, unwrapped from the producer carrier).
                    responseHandler.onFailure(convertWith(selectedBackendId(request), e));
     *       sink the framework attached to {@link FragmentResources#partitionedSink}; the
    /**
        }
        BackendExecutionContext backendContext = null;
    ) {
     */
        // stream.close() (which would race the in-flight native pull).
        if (taskResourceTrackingService == null) {
import org.opensearch.analytics.spi.InstructionType;
            capturedSchema = new Schema(List.of());
     * coordinator-reduce path borrows the same one via {@code CoordinatorAllocatorHandle} so a node has
                    // byte[]; without this it lives for the JVM's lifetime and accumulates across  
                        } catch (Exception ignore) {}
                    }
            readerContextStore.releaseAndFree(request.getQueryId(), shard.shardId());
            task.clearCancellationListener();  
        return new ResolvedFragment(readerProvider, selectedPlan, request.getQueryId(), request.getStageId(), shardIdStr);
    /**
                // isolate concurrent queries from each other. Validate before allocating any
     * in a single try-with-resources scope. Runs on the caller's executor — exhausting the  
        @Override
import java.io.IOException;
     */
                            responseHandler.onBatch(it.next());  
                    // Query phase failed: no fetch will follow, so free the reader eagerly (no-op if already freed).  
                VectorSchemaRoot batch = it.next().getArrowRoot();
                        + "; available: "
                try (ResolvedExecution exec = executeFragmentStreamingResolved(request, shard, task)) {
        // Abort backstop: if the query is cancelled (client disconnect, timeout, explicit kill) the  
        ctx.setImportStagingAllocator(importStagingAllocator);
    private static BackendExecutionContext applyInstructionHandlers(
        for (InstructionNode node : instructions) {  
                        () -> new org.apache.logging.log4j.message.ParameterizedMessage(  
     * {@code __row_id__} values produced by one reader cannot be reinterpreted by
    }
        }  
package org.opensearch.analytics.exec;
        String tableName = request.getShardId().getIndexName();  
            if (converted != e) {
        return backend == null ? e : backend.convertException(e);  
import org.opensearch.analytics.exec.canmatch.AnalyticsCanMatchResponse;
        int stageId
            Iterator<EngineResultBatch> it = resultStream.iterator();  
                + request.getPlanAlternatives().stream().map(FragmentExecutionRequest.PlanAlternative::getBackendId).toList()
                    importStagingAllocator.getName(),
        return true;
        }
            return new ResolvedExecution(resources, resolved);
                public List<String> getFieldNames() {
                columns,
            client,  
            AnalyticsSearchBackendPlugin backend = backends.get(resolved.plan.getBackendId());  
            });
        assert assertFetchInvariants(readerContext, request.getQueryId());  
        FragmentExecutionRequest.PlanAlternative selectedPlan = null;
        // into another in-process sink). fragmentBytes is left empty for the same reason — the  
        if (readerContext == null) {  
                        }  
import org.opensearch.tasks.Task;
                            backendContext = handler.apply(node, ctx, backendContext);  
                        try {  
        // close() frees it immediately instead of waiting for the reaper.
    private final Map<String, AnalyticsSearchBackendPlugin> backends;
        if (readerContext.getReader() == null) {  
            LOGGER.debug("drainAndEmitHeader: drained {} batches, closing sink", count);  
                        // schema-bearing frame before completeStream — see
        int stageId  
                    if (!instructions.isEmpty()) {
        // the framework is missing — silently falling back to a separate root would break
            }
    }
            throw new IllegalStateException("No ReaderProvider on " + shard.shardId());
            });  
                EngineResultStream stream = null;
        }
            if (backends.containsKey(alt.getBackendId())) {  
        AnalyticsShardTask task
 *
            // TODO: currently assumes single accepting backend. When multiple accepting backends exist
        IndexShard shard  
                e.addSuppressed(suppressed);
     */
import java.util.List;
                        request.getQueryId(),
                AnalyticsSearchBackendPlugin acceptingBackend = backends.get(acceptingBackendId);  
import org.opensearch.analytics.exec.shuffle.ShuffleSenderImpl;
        } catch (Exception e) {
    private org.opensearch.transport.client.Client client;
            throw new RuntimeException("Failed to start streaming fragment on " + shard.shardId(), e);
                            );
            }  
                    } else {  
            // cancellation listener) so they don't leak when the worker never starts.
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
            final VectorSchemaRoot vsrRef = headerRoot;
    private void drainAndEmitHeader(FragmentResources ctx, StreamingFragmentResponseHandler responseHandler) throws Exception {  
                    .anyMatch(n -> n.type() == org.opensearch.analytics.spi.InstructionType.SETUP_PARTIAL_AGGREGATE)
            executor.execute(() -> {
            // Stamp ctx.hasDeletedDocs so ShardScanInstructionHandler can route deletion-bearing
                // delegation resources to avoid leaks.
    private record ResolvedExecution(FragmentResources resources, ResolvedFragment resolved) implements AutoCloseable {  
                        }
            } else if (ctx.hasDeletedDocs() && luceneBackend != null && task != null && !"lucene".equals(resolved.plan.getBackendId())) {
import java.util.concurrent.Executor;
        IndexShard shard,  
     */
                    "[FragmentExecution] failed to start streaming fragment on shard={} queryId={} stageId={}",  
     * fetch phase will reuse this reader. Derived from the {@link ShardScanInstructionNode} the
                    resolved.queryId,
            clusterService,
        StreamingFragmentResponseHandler responseHandler
import java.nio.charset.StandardCharsets;  
            throw new AssertionError("createContext returned null for queryId=" + queryId);  
        if (task.isCancelled()) {
            executor.execute(() -> drainFetchByRowIds(request, shard, task, responseHandler));  
    public void executeWorkerFragmentStreamingAsync(  
                new IllegalArgumentException(  
    }
                converted == e ? new RuntimeException("Failed to execute fetch-by-row-ids on " + shard.shardId(), e) : converted
                LOGGER.warn(  
    /**  
     * Per-node shuffle buffer registry. Plumbed into every {@link ShardScanExecutionContext} so
        if (selectedPlan == null) {  
import org.opensearch.analytics.spi.ShuffleSender;  
import org.opensearch.tasks.TaskResourceTrackingService;  
        // this reader. When it does, close() keeps the reader in the store for the fetch; otherwise  
        void onComplete();
        }
            if (outstanding == 0) {  
            // reclaim them instead.
        // Child uses Long.MAX_VALUE so dynamic resizes of parquet.native.pool.query.max take
     * (null when this fragment is not a hash-shuffle producer) and the {@link BackendExecutionContext}  
    private record ProducerSinkResolution(ExchangeSink partitionedSink, BackendExecutionContext engineContext) {  
     * map for the node's lifetime ({@code BaseAllocator#newChildAllocator} registers unconditionally; only  
            if (rowIdVector != null) rowIdVector.close();  
                    "fetch on "
        String[] columns = request.getColumns();  
        NamedWriteableRegistry namedWriteableRegistry,
            // Additive (not set): the DataFusion engine registers its own native-cancel listener on  
        }
                    ResolvedFragment resolved = exec.resolved();  
        if (shuffleBufferRegistry != null) {
    }
        }
            return;
    public FragmentResources executeFragmentStreaming(FragmentExecutionRequest request, IndexShard shard, AnalyticsShardTask task) {
     * channel. A per-stream staging child therefore cannot be closed at stream close without racing the
     * caller tears down the engine; the sink contract is idempotent-on-close.
            // Log the original failure with its full stack at the origin: the thrown exception is handed
            }
    private ProducerSinkResolution resolveProducerSink(  
                    }  
    public void canMatch(IndexShard shard, byte[] filterBytes, String backendId, ActionListener<AnalyticsCanMatchResponse> listener) {
     * frame, the streaming transport never sees an end-of-stream marker (Flight requires
        AnalyticsShardTask task,  
            allocator.close();  
                        // DatafusionResultStream's empty-stream synthesis comment). The
        }
    /** Converts {@code e} via the named backend's exception SPI; returns {@code e} unchanged if the backend is absent or doesn't recognize it. */  
        throws IOException {  
                new IllegalStateException(
                            EngineResultBatch batch = it.next();  
                    "Arrow import staging allocator [{}] still holds {} bytes at shutdown; reclaimed at process exit",
import org.opensearch.index.shard.IndexShard;
                    resolved.stageId  
    private static boolean assertReaderInvariants(
        ArrowNativeAllocator nativeAllocator,
    /**
            final Schema schemaRef = capturedSchema;  
                        // least one Arrow Flight frame (the streaming transport requires ≥1  
        assert assertAscending(rowIds);
            Iterator<EngineResultBatch> it = ctx.stream().iterator();
import org.opensearch.analytics.backend.ShardScanExecutionContext;  
        FetchByRowIdsRequest request,
     *       happens out-of-band on {@code AnalyticsShuffleDataAction}.</li>
    }
            // Fetch is terminal: free the reader eagerly.
     * session state. Otherwise returns the context unchanged with a null sink (non-producer fragment).
    }
        // analytics-engine allocations are tracked and capped by the framework. Hard-fail if  
     * Drains the engine result stream into the producer's partitioned sink AND emits a
        IndexShard shard,
        Map<String, AnalyticsSearchBackendPlugin> backends,
            resources.close();  
            importStagingAllocator
        } catch (Exception e) {  
                        }
        ctx.setNamedWriteableRegistry(namedWriteableRegistry);
import org.opensearch.core.action.ActionListener;
            while (it.hasNext()) {
     * {@link #executeFragmentStreamingAsync}.
        // buffers for not-yet-consumed partitions would also leak. Clearing ALL of this query's
                readerContext.getReader(),  
    }
        // transitions to SUCCEEDED on isLast=true.
                } catch (Exception e) {
     * disabled for those upcalls).
        } finally {
                    backendContext.close();  
        return true;  
            // to async dispatch / stream transport and can be re-wrapped or swallowed downstream, so this
        NamedWriteableRegistry namedWriteableRegistry,
                    boolean hasPartialAggregate = resolved.plan()
            // is the one place guaranteed to see the real cause and stack.  
            );
        AnalyticsSearchBackendPlugin backend,
            AnalyticsSearchBackendPlugin luceneBackend = backends.get("lucene");
                        shard.indexSettings(),
        String shardIdStr = shard.shardId().toString();  
     * allocator for every later batch ({@code FlightServerChannel#transferIntoStreamRoot}: "The producer's
            }  
                    shuffleBufferRegistry.clearForQuery(request.getQueryId());
        }
import org.opensearch.analytics.spi.FilterDelegationHandle;
                        ),
            // (e.g., Lucene + Tantivy), group expressions by acceptingBackendId and create one handle per group.  
    }  
            if (backends.containsKey(alt.getBackendId())) {
 */
                trackerCleanup,  
                FilterDelegationHandle handle = luceneBackend.getFilterDelegationHandle(java.util.List.of(), ctx);
    public void close() {  
    /**  
        void onFailure(Exception e);
        this.listener = new AnalyticsOperationListener.CompositeListener(listeners);  
        Reader reader,
     * Reader-independent — takes {@code queryId}/{@code stageId} directly rather than a shard-only  
import org.opensearch.core.tasks.TaskCancelledException;  
    }
 * Data-node service that executes plan fragments against local shards.
                    responseHandler.onComplete();
                }  
            if (delegation != null) {
        Task task
        if (instructions.isEmpty()) return null;  
     * (which ships batches out-of-band to worker peers via the shuffle transport), then emits a  
        // Parented at the ROOT rather than the query pool, and unbounded: a C Data import that fails
     * on the analytics-engine plugin's internals (the registry is an SPI surface). Set once at
            throw new AssertionError("acquireReader returned null for shard " + shard.shardId());  
    ) {
    }  
        );
     * org.opensearch.analytics.spi.ShuffleWorkerSetupInstructionNode}).  
        }
     * streams batches via {@link StreamingFragmentResponseHandler}. Forks onto  
                    ctx.setFragmentBytes(plan.getFragmentBytes());
                    engine = backend.getSearchExecEngineProvider().createSearchExecEngine(ctx, backendContext);
            // its finally never executes. Producers dispatch concurrently and may already have
    }
            responseHandler.onFailure(
    }
     * worker-fragment ({@link #executeWorkerFragmentStreamingAsync}) paths. When the instruction
        org.opensearch.threadpool.ThreadPool threadPool,
            readerContextStore.releaseAndFree(request.getQueryId(), shard.shardId());
     * ONE node-scoped allocator that every backend stages its Arrow C Data Interface imports on, handed to
            headerRoot.setRowCount(0);
            // Close the backend execution context as a safety net for failure paths that
    private org.opensearch.cluster.service.ClusterService clusterService;
     * Whether the query phase emits shard-global {@code __row_id__} values — i.e. a QTF query whose  
public class AnalyticsSearchService implements AutoCloseable {  
                    responseHandler.onCompleteWithMetrics(metricsJson);
            );
            }
                    if (request.profile() || LOGGER.isDebugEnabled()) {
        // part-way through an array strands the whole native batch (see  
        ReaderContext readerContext = readerContextStore.acquireContext(request.getQueryId(), shard.shardId());
    }
        for (InstructionNode node : instructions) {
     */  
        StreamingFragmentResponseHandler responseHandler
        // same as any other batch, decrements the partial-task counter, and the stage
     * <p>Two output paths:
import org.apache.arrow.vector.BigIntVector;
            rowIdVector.allocateNew(rowIds.length);  
    @Override
                    }
        return new ProducerSinkResolution(null, backendContext);  
    /** Cross-phase reader cache for QTF — query phase stores, fetch phase acquires. */
            @Override
    ) {
        long taskId = task.getId();
                return scan.requestsRowIds();
    }
        org.opensearch.cluster.service.ClusterService clusterService  
                        + backends.keySet()  
                    stream = engine.execute(ctx);
    }
                        drainAndEmitHeader(exec.resources(), responseHandler);
     * empty schema so the response carries a recognizable Arrow Flight frame.
     */
                    LOGGER.error(
        List<AnalyticsOperationListener> listeners,  
        BackendExecutionContext backendContext,
    private ShardScanExecutionContext buildContext(
            // executeFragmentStreamingAsync; we just attach the sink to FragmentResources here.  
     * is missing (expired before fetch arrived, or query-phase reader-store invariant
        public void close() throws Exception {
                @Override
        }
        List<InstructionNode> instructions,  
        default void onCompleteWithMetrics(byte[] metrics) {
            ctx.setHasDeletedDocs(luceneBackend != null && luceneBackend.hasDeletedDocs(ctx));  
            backendContext = producer.engineContext();  
        Map<String, AnalyticsSearchBackendPlugin> backends,
            engine = backend.getSearchExecEngineProvider().createSearchExecEngine(ctx, backendContext);
import org.opensearch.index.engine.exec.IndexReaderProvider.Reader;  
            return;  
                    + backends.keySet()
                // No delegation, but a non-Lucene driving backend will inject the reserved match-all
        ActionListener<AnalyticsCanMatchResponse> listener
            responseHandler.onFailure(backend.convertException(e));
        // no downstream sink (the partitioned sink ships out-of-band via the ShuffleSender, not
    private void drainIntoPartitionedSink(
        // request typically carries a single alternative. We still iterate to handle the
                throw new AssertionError("rowIds not ascending at index " + i + ": " + values[i - 1] + " > " + values[i]);  
                    // queries → OOM. Runs on success AND failure (both hit this finally). The
        // so this concrete shard index name is used only when no plan is supplied.
                }
            } else {
     * {@link org.opensearch.analytics.spi.ShuffleSender} for hash-shuffle producer fragments.
import org.opensearch.analytics.backend.FragmentExecutionStats;
        int count = 0;  
        Executor executor
     * min/max of {@code sortColumn} when one is given. The backend owns the sequencing; this
            responseHandler.onFailure(e);
        for (FragmentExecutionRequest.PlanAlternative alt : request.getPlanAlternatives()) {
        // worker body below may never reach its finally to free its buffer — and producer-side
                public Object getFieldValue(String fieldName, int rowIndex) {  
            responseHandler.onBatch(new EngineResultBatch() {
        ArrowNativeAllocator nativeAllocator,  
            Exception converted = backend.convertException(e);  
     * and fail-fast with a typed error rather than null-deref.  
            Exception converted = convertWith(resolved.plan().getBackendId(), e);
                        // Drain into the partitioned sink AND emit a single header-only
                    // per-query clearForQuery backstop (cancellation path) covers tasks that never
            // Convert native errors (e.g. memory-pool / admission trips) to typed exceptions via the
        }  
            return;  
        try {  
        void onBatch(EngineResultBatch batch) throws Exception;
            executor.execute(() -> {
            public void trackEnd(long threadId) {
        if (backends.isEmpty()) {  
            new byte[0],  
    ) {  
                importStagingAllocator
        AnalyticsSearchBackendPlugin backend,
 * Acquires a reader from the shard's composite engine, builds an
     *
        // A query that requested top-N docs (row-ids) will be followed by a fetch phase that reuses
        ShardScanExecutionContext ctx = new ShardScanExecutionContext(tableName, task, reader);
            }  
