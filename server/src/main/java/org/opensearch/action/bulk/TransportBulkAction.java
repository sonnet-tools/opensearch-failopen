            // We will only fail/drop slots up to once and store the first failure to prevent overfilling itemResponses
        this.systemIndices = systemIndices;
                    IndexAbstraction indexAbstraction = clusterState.getMetadata().getIndicesLookup().get(concreteIndex.getName());
                            + "] is not allowed as setting `"
                public void onTimeout(TimeValue timeout) {
                    }
        ActionFilters actionFilters,
            this.failedSlots = new SparseFixedBitSet(bulkRequest.requests().size());
 * this work for additional information regarding copyright
            Set<String> autoCreateIndices = new HashSet<>();
                                    listener.onFailure(inner);
                }
                    ingestForwarder.forwardIngestRequest(BulkAction.INSTANCE, bulkRequest, listener);
                        case DELETE:
        final boolean includesSystem = includesSystem(bulkRequest, clusterService.state().metadata().getIndicesLookup(), systemIndices);
    ) {
                    IndexMetadata indexMetaData = clusterState.metadata().index(concreteIndex.getName());
            return false;
                    }
                if (shouldAutoCreate && (indexAndFlag.getValue() == false)) {
            final boolean isOnlySystem = isOnlySystem(bulkRequest, clusterService.state().metadata().getIndicesLookup(), systemIndices);
        if (indexRoutingTable == null) {
                        if (counter.decrementAndGet() == 0) {
                hasIndexRequestsWithPipelines |= indexRequestHasPipeline;
        private final Task task;
            final Metadata metadata
                                    public void onRejection(Exception rejectedException) {
                                    if (request != null && setResponseFailureIfIndexMatches(responses, i, request, index, e)) {
                            }
            for (Map.Entry<String, Boolean> indexAndFlag : indices.entrySet()) {
        IndexingPressureService indexingPressureService,
    }
        }
            new HashMap<>(clientConnections)
                                    return true;
import org.opensearch.indices.IndexClosedException;
        private final ClusterState state;
import org.opensearch.action.index.IndexRequest;
                            }
                        }
import org.opensearch.core.concurrency.OpenSearchRejectedExecutionException;
                    indexRequest.id()
            Metadata metadata = clusterState.metadata();
        TransportShardBulkAction shardBulkAction,
            this.bulkRequest = bulkRequest;
            if (observer.isTimedOut()) {
            original.numberOfActions(),
     * in order to map the failed and succeeded action requests back to their original slots in the order of the
                        indexRequestHasPipeline |= ingestService.resolveSystemIngestPipeline(actionRequest, docRequest, metadata);
    /**
                }
                    + "] instead"
                try {
                if (upsertRequest != null) {
    /**
import java.util.Set;
            }
                final String id = indexRequest.id() == null ? DROPPED_ITEM_WITH_AUTO_GENERATED_ID : indexRequest.id();
        SystemIndices systemIndices,
            }
            if (request instanceof UpdateRequest updateRequest) {
            // Attempt to create all the indices that we're going to need during the bulk before we start.
 *
                    concreteIndex = concreteIndices.resolveIfAbsent(request);
import org.opensearch.action.admin.indices.create.AutoCreateAction;
                final long shardStartTimeNanos = relativeTime();
                }
                failedSlots.set(slot);
                                    @Override
        private final long startTimeNanos;
        }
        }
                    continue;
                    continue;
                failedSlots.set(slot);
            && writeRequest.ifPrimaryTerm() == UNASSIGNED_PRIMARY_TERM
                                        super.onRejection(rejectedException);
                    + "routing. target the backing indices directly or remove the custom routing."
            // the id, opType, and index, which is shared across child index requests
                    exception.addValidationError(
        }
    }
         * Marks an action request at a slot in the original bulk request as failed during ingest pipeline execution
                final ActionListener<BulkShardResponse> shardListener = new ActionListener<>() {
}
        if (indexAbstraction.getParentDataStream() == null) {
                    )
                    }
            if (failedSlots.get(slot) == false) {
            threadPool,
                        }
        if (indexAbstraction.getType() != IndexAbstraction.Type.CONCRETE_INDEX) {
                            finishHim();
import org.opensearch.action.update.TransportUpdateAction;
            assert bulkRequest != null;
        DocWriteRequest<?> request,
import java.util.concurrent.atomic.AtomicInteger;
                        shardId = index2ShardId.computeIfAbsent(
    private final NodeClient client;
                                    targetNodeId,
                // This means the pipeline is only executed on the partial doc, which may not contain all fields.
                    BulkItemResponse.Failure failure = new BulkItemResponse.Failure(concreteIndex.getName(), docWriteRequest.id(), e);
                }
            throw new IllegalArgumentException(
 * the Apache License, Version 2.0 (the "License"); you may
        private boolean handleBlockExceptions(ClusterState state) {
import org.opensearch.cluster.block.ClusterBlockException;
        } else {
                    indexRequest.getPipeline(),
import org.opensearch.cluster.metadata.DataStream;
                    ValidationException exception = new ValidationException();
                                nodeMetricsCollector.addNodeStatistics(
        private final AtomicArray<BulkItemResponse> responses;
                        } else {
import org.opensearch.index.VersionType;
                    }
        ClusterService clusterService,
        final long startTimeNanos,
            IndexNotFoundException cannotCreate = indicesThatCannotBeCreated.get(request.index());
import org.opensearch.telemetry.tracing.listener.TraceableActionListener;
                    throw new IllegalArgumentException("autoGeneratedTimestamp should not be set externally");
                            if (counter.decrementAndGet() == 0) {
                    "failed to execute pipeline [%s] for document [%s/%s]",
    }
                                // The shard already applied these items, so skip the statistics instead of failing the items.
        synchronized void markItemAsDropped(int slot) {
                            + IndexMetadata.INDEX_APPEND_ONLY_ENABLED_SETTING.getKey()
            Metadata metadata
                return true;
                } catch (IndexNotFoundException e) {
        clusterService.addStateApplier(this.ingestForwarder);
            if (autoCreateIndices.isEmpty()) {
        client.execute(AutoCreateAction.INSTANCE, createIndexRequest, listener);
                DocWriteRequest<?> docWriteRequest = bulkRequest.requests.get(i);
                    continue;
                            indexRequest.version(),
        private boolean addFailureIfRequiresAliasAndAliasIsMissing(DocWriteRequest<?> request, int idx, final Metadata metadata) {
                            SequenceNumbers.UNASSIGNED_PRIMARY_TERM,
            }
                    // make sure the request gets never processed again
                                throw new RoutingMissingException(concreteIndex.getName(), docWriteRequest.id());
                                final ActionListener<BulkResponse> wrappedListener = ActionListener.wrap(listener::onResponse, inner -> {
                            id,
                                    inner.addSuppressed(e);
            bulkRequestModifier::markItemAsFailed,
        IndexAbstraction indexAbstraction = metadata.getIndicesLookup().get(writeRequest.index());
        new BulkOperation(task, bulkRequest, listener, responses, startTimeNanos, indicesThatCannotBeCreated).run();
                    BulkItemResponse bulkItemResponse = new BulkItemResponse(i, docWriteRequest.opType(), failure);
    }
                });
            }
 *
import org.opensearch.action.update.UpdateResponse;
                        clientConnections.compute(targetNodeId, (id, conns) -> conns == null ? 1 : conns + 1);
import java.util.Objects;
        // (the latter maybe an update, but at this stage we can't determine that. In order to determine
                            + request.index()
                            assert Thread.currentThread().getName().contains(executorName);
 * ownership. Elasticsearch licenses this file to you under
     *
                }
                boolean bulkAdaptiveShardSelectionEnabled = indexMetaData.isAppendOnlyIndex()
                                );
import java.util.ArrayList;
                final Releasable releasable;
            if (primary != null && primary.active()) {
                                logger.warn(
                            }
                        state,
                    }
                    indicesThatCannotBeCreated.put(index, e);
import org.opensearch.cluster.routing.IndexShardRoutingTable;
        public DocWriteRequest<?> next() {
        IndicesService indicesService,
        Version minNodeVersion
                                }
import org.opensearch.common.util.concurrent.ConcurrentCollections;
                                    bulkShardResponse.getServiceTimeEWMAInNanos()
            return null;
            throw new IllegalArgumentException(
    static class ConcreteIndices {
            () -> bulkRequestModifier,
                    BulkRequest bulkRequest = bulkRequestModifier.getBulkRequest();
                        // create failures for all relevant requests
                public void onClusterServiceClose() {
            if (indexMetadata.getState() == IndexMetadata.State.CLOSE) {
        ActionFilters actionFilters,
import org.opensearch.index.IndexNotFoundException;
            }
        this.tracer = tracer;
                    if (itemResponse != null) {
            // 3) Continue with the next request in the bulk.
    private final ClusterService clusterService;
    private final IndexNameExpressionResolver indexNameExpressionResolver;
                    );
         * be saving us an iteration over the responses array
                    return shardList;
            ClusterBlockException blockException = state.blocks().globalBlockedException(ClusterBlockLevel.WRITE);
        }
                            if (targetNodeId != null && incrementedConnections.getAndSet(false)) {
                        shardList = new ArrayList<>();
                addFailure(request, idx, cannotCreate);
            if (concreteIndex == null) {
        IngestService ingestService,
                                    }
            }
                    )
                return true;
            IndexAbstraction.DataStream dataStream = (IndexAbstraction.DataStream) indexAbstraction;
        return new Tuple<>(shardRoutings, node2Shards);
            String nodeId = clusterService.localNode().getId();
            assert failure != null;
        this.shardBulkAction = shardBulkAction;
                return;
                    for (int i = 0; i < items.length; i++) {
            } else {
            // for bulk shard routing
            // After pipeline execution, this method (doExecute) will be called again, but with the requests updated from ingest processing.
                "index request with op_type=index and no if_primary_term and if_seq_no set "
 *     http://www.apache.org/licenses/LICENSE-2.0
                    shardRequests.add(new BulkItemRequest(i, docWriteRequest));
        return hasIndexRequestsWithPipelines;
            // We hit an error during preprocessing a request, so we:
                            docStatusStats.inc(bulkItemResponse.status());
import org.opensearch.tasks.Task;
        volatile int currentSlot = -1;
                }
                        for (BulkItemResponse bulkItemResponse : bulkShardResponse.getResponses()) {
                };
                try {
        final ActionListener<BulkResponse> listener,
                    final boolean arePipelinesResolved = extractIndexRequests(bulkRequest.requests()).stream()
                BulkItemResponse.Failure failure = new BulkItemResponse.Failure(
            nodeMetricsCollector,
                    );
import org.opensearch.action.update.UpdateRequest;
                    if (indexMetaData.isAppendOnlyIndex() && indexMetaData.bulkAdaptiveShardSelectionEnabled()) {
            SHUFFLER.shuffle(shardInfos.v1(), SHUFFLER.nextSeed()),
        this.indicesService = indicesService;
                .filter(
                                    // If we fork back to a write thread we **not** should fail, because tp queue is full.
                    e,
    private final Tracer tracer;
                    logger.debug("failed to execute pipeline for a bulk request", exception);
import org.apache.logging.log4j.Logger;
        if (includesSystem || needToCheck()) {
        void retry(Exception failure) {
                ),
                        new BulkResponse(itemResponses.toArray(new BulkItemResponse[0]), response.getTook().getMillis(), ingestTookInMillis)
        for (IndexShardRoutingTable shardRoutingTable : indexRoutingTable.shards().values()) {
         */
                                request.id(),
            indicesService,
            (originalThread, exception) -> {
                    new BulkItemResponse(
            }
                } else {
    }
            // We will only fail/drop slots up to once and store the first failure to prevent overfilling itemResponses
                    BulkItemResponse[] items = response.getItems();
                    shardId,
                long tookMillis = buildTookInMillis(startTimeNanos);
 */
        ShardRouting selectedShard = shardRoutings.get(0);
    void createIndex(String index, TimeValue timeout, Version minNodeVersion, ActionListener<CreateIndexResponse> listener) {
        SystemIndices systemIndices,
                        // TODO : In the future we want to add configurability to do resolve all pipelines for the doc request
    private boolean isSystemIndex(SortedMap<String, IndexAbstraction> indicesLookup, SystemIndices systemIndices, String indexName) {
            );
        final SparseFixedBitSet failedSlots;
                            .indexShards(clusterState, concreteIndex.getName(), docWriteRequest.id(), docWriteRequest.routing())
                    indexRequest.index(),
                                );
                        includeDataStreams
    }
            } else {
                            responses.set(bulkItemResponse.getItemId(), bulkItemResponse);
        return ResolvedIndices.of(request.getIndices());
        IndexAbstraction indexAbstraction = metadata.getIndicesLookup().get(writeRequest.index());
 * compatible open source license.
    private boolean resolvePipelinesForActionRequests(
            return selectedShard.shardId();
                    + dataStream.getName()
                if ((request.opType() == DocWriteRequest.OpType.UPDATE || request.opType() == DocWriteRequest.OpType.DELETE)) {
import org.opensearch.cluster.metadata.Metadata;
            }
                    return true;
        return indexRequest;
                    createIndex(index, bulkRequest.timeout(), minNodeVersion, new ActionListener<CreateIndexResponse>() {
    }
            AtomicArray<BulkItemResponse> responses,
            return false;
                addFailure(request, idx, exception);
                executeBulk(task, bulkRequest, startTime, listener, responses, indicesThatCannotBeCreated);
                    // avoid valid cases when directly indexing into a backing index
                                    // ingest when a node receives a bulk request.
 *
        }
     * execution.
                        // This is to preserve backwards compatibility where default and final pipelines are NOT resolved
        return TimeUnit.NANOSECONDS.toMillis(relativeTime() - startTimeNanos);
    @Inject
 * Groups bulk request items by shard, optionally creating non-existent indices and
    private final AutoCreateIndex autoCreateIndex;
                    DocWriteRequest<?> request = requests.get(i);
        ) {
        DataStream dataStream = indexAbstraction.getParentDataStream().getDataStream();
                    concreteIndex = indexNameExpressionResolver.concreteWriteIndex(
        }
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
        Map<String, IndexNotFoundException> indicesThatCannotBeCreated
        IndicesService indicesService,
     * Helper method that resolves the correct pipelines for a given list of doc write requests.
                            SequenceNumbers.UNASSIGNED_SEQ_NO,
            doInternalExecute(task, bulkRequest, executorName, releasingListener);
                    bulkRequest.requests.set(i, null);
                        actionListener.onResponse(new BulkResponse(new BulkItemResponse[0], 0));
        if (writeRequest.routing() != null) {
            return false;
                    ValidationException exception = new ValidationException();
                    exception.addValidationError(
                    TraceableActionListener.create(
            bulkRequestModifier::markItemAsDropped,
                    // an operation is allowed in index into a data stream, but this isn't done when resolve call is cached, so
import org.opensearch.action.DocWriteRequest;
    private boolean setResponseFailureIfIndexMatches(
                    }
                        || request.versionType() == VersionType.EXTERNAL_GTE
    }
            this.startTimeNanos = startTimeNanos;
                    shardListener.onFailure(e);
                                    protected void doRun() {
                });
            }
                    }
                    addFailure(request, idx, ex);
                            + request.id()
        for (DocWriteRequest<?> actionRequest : docWriteRequests) {
                    // Try one more time...
                // the request can only be null because we set it to null in the previous step, so it gets ignored
        Index resolveIfAbsent(DocWriteRequest<?> request) {
        IndexRequest indexRequest = null;
                            Version indexCreated = indexMetadata.getCreationVersion();
                    public void onFailure(Exception e) {
     * @param metadata additional metadata used to resolve pipelines, such as index information
        return docWriteRequests.stream().flatMap(request -> {
     * Retrieves the {@link IndexRequest} from the provided {@link DocWriteRequest} for index or upsert actions.  Upserts are
                    // After dispatch returned, only its actual callback may complete the shard and release its request buffers.
                );
     * If pipelines are resolved for a request, the request is mutated with the pipeline information.
                modifiedBulkRequest.setRefreshPolicy(bulkRequest.getRefreshPolicy());
                    }
                        .allMatch(IndexRequest::isPipelineResolved);
            // 1) Remember the request item slot from the bulk, so that we're done processing all requests we know what failed
    }
    }
                            });
                        }
                            finishHim();
            IndexMetadata indexMetadata = metadata.getIndexSafe(concreteIndex);
            int idx,
                );
     * We keep track of the mapping of the failures and new bulk request to their slots in the original bulk request
                for (int i = 0; i < requests.size(); i++) {
                            break;
        @Override
                    "[" + DocWriteRequest.REQUIRE_ALIAS + "] request flag is [true] and [" + request.index() + "] is not an alias",
                return true;
    private final IngestService ingestService;
            BulkItemResponse.Failure failure = new BulkItemResponse.Failure(request.index(), request.id(), unavailableException);
        }
            if (indexMetadata.isAppendOnlyIndex()) {
                }
                if (clusterService.localNode().isIngestNode()) {
import org.opensearch.indices.SystemIndices;
        @Override
        }
        this.client = client;
            return abstraction.isSystem();
                    responses.set(i, bulkItemResponse);
                                    // It is okay to force execution here. Throttling of write requests happens prior to
        }
            final IndexMetadata indexMetadata = metadata.index(concreteIndex);
    void executeBulk(
import org.opensearch.ResourceAlreadyExistsException;
                                new BulkItemResponse.Failure(indexName, docWriteRequest.id(), e)
    /**
                    && indexMetaData.bulkAdaptiveShardSelectionEnabled();
                            if (bulkItemResponse.getResponse() != null) {
    private static final ShardShuffler SHUFFLER = new RotationShardShuffler(Randomness.get().nextInt());
                    + "targeting backing indices is disallowed, target corresponding data stream ["
import org.opensearch.common.collect.Tuple;
        this.ingestForwarder = new IngestActionForwarder(transportService);
            this.state = state;
                final ShardId shardId = entry.getKey();
         * @param slot the slot of the action request in the original bulk request
     * Helper to extract the underlying index requests from a list of DocWriteRequests
        NodeClient client,
                        itemResponses.add(originalSlots.get(i), response.getItems()[i]);
                    request.index()
     * @return A list of the extracted index requests
import java.util.Map;
     */
                    public void onResponse(BulkShardResponse bulkShardResponse) {
        /**
        TransportShardBulkAction shardBulkAction,
        if (opType == DocWriteRequest.OpType.CREATE) {
                            + request.opType()
import org.opensearch.cluster.routing.RotationShardShuffler;
                    addFailure(request, idx, exception);
                    });
                            new ShardId(indexRequest.index(), IndexMetadata.INDEX_UUID_NA_VALUE, 0),
                listener.onResponse(new BulkResponse(response, tookMillis));
                    if (failedSlots.get(i) == false) {
                } catch (OpenSearchParseException | IllegalArgumentException | RoutingMissingException e) {
    }
                if (blockException.retryable()) {
        Map<String, List<ShardRouting>> node2Shards = new HashMap<>();
        } else if (docWriteRequest instanceof UpdateRequest updateRequest) {
                public void onNewClusterState(ClusterState state) {
        ActionListener<BulkResponse> wrapActionListenerIfNeeded(long ingestTookInMillis, ActionListener<BulkResponse> actionListener) {
 * license agreements. See the NOTICE file distributed with
        final AtomicArray<BulkItemResponse> responses,
                DocStatusStats stats = new DocStatusStats();
                        span,
                    shouldAutoCreate = shouldAutoCreate(index, state);
            long startTimeNanos,
                @Override
        private final Map<String, Index> indices = new HashMap<>();
 * GitHub history for details.
                            + "` is enabled for this index: "
                    }
                indicesService.addDocStatusStats(stats);
        LongSupplier relativeTimeProvider,
        );
                    retry(blockException);
        final long startTime = relativeTime();
            final DocStatusStats docStatusStats = new DocStatusStats();
import static org.opensearch.cluster.routing.IndexShardRoutingTable.rankShardsAndUpdateStats;
import org.opensearch.ExceptionsHelper;
    }
                        request.indices()[0],
    }
import org.opensearch.cluster.ClusterState;
                }
            return Stream.of(getIndexWriteRequest(request));
                    response -> new BulkResponse(response.getItems(), response.getTook().getMillis(), ingestTookInMillis)
                } else {
                        false,
        // so checking if write op is append-only and if so fail.
        }
            IndexRequest indexRequest = getIndexWriteRequest(bulkRequest.requests().get(slot));
                "index request with op_type=create targeting backing indices is disallowed, "
        if (opType == DocWriteRequest.OpType.INDEX
                IndexRequest upsertRequest = updateRequest.upsertRequest();
             * that we'll use when we try to run the requests. */
                                    bulkShardResponse.getServiceTimeEWMAInNanos()
                        @Override
            Task task,
        protected void doRun() {
                }
                    }
                    return true;
                            responses.set(request.id(), bulkItemResponse);
                    Locale.ROOT,
                            final IndexMetadata indexMetadata = metadata.index(concreteIndex);
import java.util.concurrent.atomic.AtomicBoolean;
        IngestService ingestService,
                            .shardId();
        if (indexAbstraction == null) {
    }
     */
                            }
                }
        private BulkRequest bulkRequest; // set to null once all requests are sent out
            this.itemResponses = new ArrayList<>(bulkRequest.requests().size());
                return updateRequest.getChildIndexRequests().stream();
    boolean shouldAutoCreate(String index, ClusterState state) {
        BulkRequest original,
            if (requestsByShard.isEmpty()) {
        synchronized void markItemAsFailed(int slot, Exception e) {
                        // and NOT executed on the partial doc passed in from the user request.
                        // at this stage, the transport bulk action can't deal with a bulk request with no requests,
import org.opensearch.action.ingest.IngestActionForwarder;
                    } else {
     * @opensearch.internal
                                        executeBulk(task, bulkRequest, startTime, listener, responses, indicesThatCannotBeCreated);
     * @opensearch.internal
                } catch (IndexClosedException | IndexNotFoundException | IllegalArgumentException ex) {
                                metadata,
                );
                    onFailure(blockException);
    private final SystemIndices systemIndices;
                                        rejectedException.addSuppressed(e);
            shardBulkAction,
        AutoCreateIndex autoCreateIndex,
            Index concreteIndex = concreteIndices.getConcreteIndex(request.index());
import org.opensearch.cluster.metadata.IndexMetadata;
import org.opensearch.core.index.Index;
import org.opensearch.action.RoutingMissingException;
    static ShardId bulkAdaptiveSelectShard(
        if (indexAbstraction.getType() != IndexAbstraction.Type.DATA_STREAM) {
                return bulkRequest;
        return false;
            observer.waitForNextChange(new ClusterStateObserver.Listener() {
        }
     * have different interactions with ingest pipelines depending on user parameters.
        final IndexAbstraction abstraction = indicesLookup.get(indexName);
        private final Map<String, IndexNotFoundException> indicesThatCannotBeCreated;
        // Determine if any requests require ingest pipeline execution.
            }
                @Override
            tracer
                }
 * KIND, either express or implied.  See the License for the
                }
            && writeRequest.ifSeqNo() == UNASSIGNED_SEQ_NO) {
            }
     * modeled as {@link IndexRequest} inside the {@link UpdateRequest}. Ignores {@link org.opensearch.action.delete.DeleteRequest}'s
                                    }
        }
    protected void doExecute(Task task, BulkRequest bulkRequest, ActionListener<BulkResponse> listener) {
            bulkRequest.requests.set(idx, null);
        }
        List<ShardRouting> candidates = shardInfos.v2().get(selectedShard.currentNodeId());
                BulkRequest modifiedBulkRequest = new BulkRequest();
            }
 * You may obtain a copy of the License at
                    );
 */
                } catch (Exception e) {
                        logger.warn("Unexpected failure during coordinating admission for [{}]", shardId, e);
/*
                            DocWriteResponse.Result.NOOP
         */
                return;
                    indexRequestHasPipeline |= ingestService.resolvePipelines(actionRequest, upsertRequest, metadata);
                .collect(Collectors.toMap(DocWriteRequest::index, DocWriteRequest::isRequireAlias, (v1, v2) -> v1 || v2));
                // delete requests should not attempt to create the index (if the index does not
                                protected void doRun() {
            final Map<String, Boolean> indices = bulkRequest.requests.stream()
        return request.getIndices().stream().anyMatch(indexName -> isSystemIndex(indicesLookup, systemIndices, indexName));
        final BulkRequest bulkRequest;
            this.indexNameExpressionResolver = indexNameExpressionResolver;
        }
         * how to map failed and successful bulk request children to their original slots
                    );
        Map<String, Long> clientConnections
        if (shardRoutings.isEmpty()) {
                    // Other shards may still be using request buffers. Complete this shard, not the entire bulk request.
                    // The ConcreteIndices#resolveIfAbsent(...) method validates via IndexNameExpressionResolver whether
        TransportService transportService,
                        concreteIndex.getName().equals(docWriteRequest.index()) == false
            return bulkRequest.requests().get(++currentSlot);
                "index request targeting data stream ["
import org.opensearch.node.ResponseCollectorService;
        private final ClusterStateObserver observer;
                        modifiedBulkRequest.add(request);
    ) {
        BulkOperation(
            }
        Tracer tracer
        }
    }
                    try (SpanScope spanScope = tracer.withSpanInScope(span)) {
         * @param slot the slot of the action request in the original bulk request
            return;
        if (indexAbstraction == null) {
                        // If a processor went async and returned a response on a different thread then
            this.observer = new ClusterStateObserver(clusterService, bulkRequest.timeout(), logger, threadPool.getThreadContext());
                                @Override
        public boolean hasNext() {
                    actionListener,
            }
    }
        final ActionListener<BulkResponse> releasingListener = ActionListener.runBefore(listener, releasable::close);
        }
            return;
import org.opensearch.cluster.service.ClusterService;
                    }
                        // before we continue the bulk request we should fork back on a write thread:
            // 2) Add a bulk item failure for this request
                    shouldAutoCreate = false;
 * SPDX-License-Identifier: Apache-2.0
        }
                            if (!(ExceptionsHelper.unwrapCause(e) instanceof ResourceAlreadyExistsException)) {
                                    }
    }
            ShardRouting primary = indexRoutingTable.iterator().next().primaryShard();
            clusterService,
        ActionListener<BulkResponse> listener
import org.opensearch.telemetry.tracing.SpanBuilder;
                        if (originalThread == Thread.currentThread()) {
        AutoCreateIndex autoCreateIndex,
    boolean isOnlySystem(BulkRequest request, SortedMap<String, IndexAbstraction> indicesLookup, SystemIndices systemIndices) {
                List<DocWriteRequest<?>> requests = bulkRequest.requests();
            indexRequest = updateRequest.docAsUpsert() ? updateRequest.doc() : updateRequest.upsertRequest();
                            break;
        @Override
            }
                    List<BulkItemRequest> shardRequests = requestsByShard.computeIfAbsent(shardId, shard -> new ArrayList<>());
            );
            final ConcreteIndices concreteIndices,
        IndexNameExpressionResolver indexNameExpressionResolver,
                }
                try {
            bulkRequest = null; // allow memory for bulk request items to be reclaimed before all items have been completed
        // CREATE op_type is considered append-only and
    private final Map<String, Long> clientConnections = ConcurrentCollections.newConcurrentMapWithAggressiveConcurrency();
                            // check if routing is required, if so, throw error if routing wasn't specified
import org.opensearch.action.DocWriteResponse;
        }
        final boolean isOnlySystem = isOnlySystem(bulkRequest, clusterService.state().metadata().getIndicesLookup(), systemIndices);
                            );
            autoCreateIndex,
                    }
        this.threadPool = threadPool;
import org.opensearch.cluster.metadata.MappingMetadata;
        if (candidates == null || candidates.isEmpty()) {
                    bulkRequest.getRefreshPolicy(),
                                        executeBulk(task, bulkRequest, startTime, wrappedListener, responses, indicesThatCannotBeCreated);
        if (abstraction != null) {
                    // the validation needs to be performed here too.
        Objects.requireNonNull(relativeTimeProvider);
        }
            // Each index request needs to be evaluated, because this method also modifies the IndexRequest
                        throw new IllegalArgumentException("only write ops with an op_type of create are allowed in data streams");
package org.opensearch.action.bulk;
        BulkRequest getBulkRequest() {
                    listener.onFailure(exception);
                }
import org.opensearch.common.unit.TimeValue;
        NodeClient client,
    private final TransportShardBulkAction shardBulkAction;
                                    doInternalExecute(task, bulkRequest, executorName, actionListener);
                } catch (Exception e) {
            // make sure the request gets never processed again
    private final ResponseCollectorService nodeMetricsCollector;
                    if (dispatchReturned == false) {
                        indicesService.addDocStatusStats(docStatusStats);
        Metadata metadata,
import java.util.HashSet;
        // INDEX op_type is considered append-only when no if_primary_term and if_seq_no is specified.
    private final IngestActionForwarder ingestForwarder;
                                // fail all requests involving this index, if create didn't work
import java.util.stream.Stream;
                    + "] specifies a custom "
        final Releasable releasable = indexingPressureService.markCoordinatingOperationStarted(bulkRequest::ramBytesUsed, isOnlySystem);
        final BulkRequest bulkRequest,
            if (actionRequest instanceof UpdateRequest updateRequest) {
     * @opensearch.internal
            return;
                int slot = 0;
                            + " as setting `"
        // At this point with write op is targeting a backing index of a data stream directly,
                    if (shardList == null) {
         * Marks an action request at a slot in the original bulk request as dropped during ingest pipeline execution
                IndexMetadata indexMetaData = clusterState.metadata().index(shardId.getIndexName());
import java.util.Iterator;
            );
/**
        } else {
        boolean hasIndexRequestsWithPipelines = false;
import org.opensearch.action.admin.indices.stats.DocStatusStats;
                                (UpdateRequest) docWriteRequest
                    shardList.add(primary);
            final ConcreteIndices concreteIndices = new ConcreteIndices(clusterState, indexNameExpressionResolver);
                    hasIndexRequestsWithPipelines |= ingestService.resolvePipelines(actionRequest, indexRequest, metadata);
                            doInternalExecute(task, bulkRequest, executorName, actionListener);
                final String index = indexAndFlag.getKey();
    boolean needToCheck() {
            return;
                            }
            if (failedSlots.get(slot) == false) {
     */
        }
                    logger.warn("Exception during bulk shard dispatch for [{}]", shardId, e);
    public static IndexRequest getIndexWriteRequest(DocWriteRequest<?> docWriteRequest) {
        }
            if (itemResponses.isEmpty()) {
        return request.getIndices().stream().allMatch(indexName -> isSystemIndex(indicesLookup, systemIndices, indexName));
import static org.opensearch.index.seqno.SequenceNumbers.UNASSIGNED_SEQ_NO;
                    + "] instead"
                itemResponses.add(new BulkItemResponse(slot, indexRequest.opType(), failure));
                BulkShardRequest bulkShardRequest = new BulkShardRequest(
                }
                            if (counter.decrementAndGet() == 0) {
 * The OpenSearch Contributors require contributions made to
                // Add the shard level accounting for coordinating and supply the listener
import org.opensearch.action.admin.indices.create.CreateIndexRequest;
 * @opensearch.internal
     * Helper class that handles the results of ingest pipelines and other preprocessing for action requests
                    + dataStream.getName()
/*
                return ActionListener.delegateFailure(actionListener, (delegatedListener, response) -> {
        }
                return modifiedBulkRequest;
     * @return whether any index request has had a pipeline resolved.
     * Index, update, and delete operations are passed in through the bulk request as doc write requests and
        this.indexingPressureService = indexingPressureService;
                    requests.toArray(new BulkItemRequest[0])
            }
            this.indicesThatCannotBeCreated = indicesThatCannotBeCreated;
import org.opensearch.action.support.ActionFilters;
        super(BulkAction.NAME, transportService, actionFilters, BulkRequest::new, ThreadPool.Names.SAME);
        createIndexRequest.index(index);
                    ActionListener<BulkResponse> actionListener = bulkRequestModifier.wrapActionListenerIfNeeded(
import static org.opensearch.cluster.metadata.IndexNameExpressionResolver.EXCLUDED_DATA_STREAMS_KEY;
        }).filter(Objects::nonNull).toList();
        }
                if (indexRequest != null) {
                    } else {
                            MappingMetadata mappingMd = indexMetadata.mapping();
     * original bulk request.
            super(listener);
                    if (targetNodeId != null) {
            return primary != null ? primary.shardId() : null;
    ) {
                        public void onFailure(Exception e) {
                final AtomicInteger counter = new AtomicInteger(autoCreateIndices.size());
        );
                            } else {
import org.opensearch.threadpool.ThreadPool;
            try {
        final AtomicArray<BulkItemResponse> responses = new AtomicArray<>(bulkRequest.requests.size());
    ) {
                node2Shards.compute(primary.currentNodeId(), (nodeId, shardList) -> {
 * Unless required by applicable law or agreed to in writing,
                        if (targetNodeId != null && bulkAdaptiveShardSelectionEnabled) {
            DocWriteRequest<?> request,
                try {
import org.apache.logging.log4j.LogManager;
                indices.put(request.index(), concreteIndex);
        private boolean addFailureIfIndexIsUnavailable(
            return;
import org.opensearch.common.Randomness;
                    );
                if (docWriteRequest == null) {
    private final class BulkOperation extends ActionRunnable<BulkResponse> {
                        // Insert successful action requests into their original locations alongside the preprocessing
                bulkShardRequest.waitForActiveShards(bulkRequest.waitForActiveShards());
     *
        DocWriteRequest.OpType opType = writeRequest.opType();
            Map<String, ShardId> index2ShardId = new HashMap<>();
                itemResponses.add(
                        default:
         * @param actionListener the original action listener corresponding to the original bulk request
                                bulkItemResponse.getResponse().setShardInfo(bulkShardResponse.getShardInfo());
import org.opensearch.cluster.routing.IndexRoutingTable;
            ShardRouting primary = shardRoutingTable.primaryShard();
        }
                    + dataStream.getName()
        );
        ThreadPool threadPool,
                            final BulkItemResponse bulkItemResponse = new BulkItemResponse(
                            index -> bulkAdaptiveSelectShard(routingTable.index(concreteIndex), nodeMetricsCollector, clientConnections)
                        bulkShardRequest::ramBytesUsed,
                            TransportUpdateAction.resolveAndValidateRouting(
import org.opensearch.cluster.routing.ShardRouting;
                );
                    );
     * from the original bulk request.
    ) {
import static org.opensearch.index.seqno.SequenceNumbers.UNASSIGNED_PRIMARY_TERM;
                                });
                        request.indicesOptions(),
                            prohibitCustomRoutingOnDataStream(docWriteRequest, metadata);
            this.task = task;
            Index concreteIndex = concreteIndices.resolveIfAbsent(request);
    /**
                    if (updateRequest.docAsUpsert()) {
            return indices.get(indexOrAlias);
        }
 */
        IndexNameExpressionResolver indexNameExpressionResolver,
                                }
    implements
                }
    /**
import org.opensearch.Version;
 * this file be licensed under the Apache-2.0 license or a
    private static final Logger logger = LogManager.getLogger(TransportBulkAction.class);
            indexRequest = indexReq;
        List<ShardRouting> shardRoutings = rankShardsAndUpdateStats(
            // This ensures that this on the second time through this method, we will not execute pipelines again.
                        new UpdateResponse(
                    logger.trace("cluster is blocked, scheduling a retry", blockException);
    static void prohibitAppendWritesInBackingIndices(DocWriteRequest<?> writeRequest, Metadata metadata) {
         * @param e the associated exception with
            releasingListener.onFailure(e);
    }
            }
     * @return the found {@link IndexRequest} or {@code null} if one can not be found.
import org.opensearch.action.support.HandledTransportAction;
import java.util.function.LongSupplier;
                            if (docWriteRequest.routing() == null && metadata.routingRequired(concreteIndex.getName())) {
            for (int i = 0; i < bulkRequest.requests.size(); i++) {
import org.opensearch.cluster.metadata.IndexAbstraction;
            BulkRequest bulkRequest,
 * under the License.
        this.ingestService = ingestService;
                                    bulkShardResponse.getNodeQueueSize(),
                        slot,
            final ConcreteIndices concreteIndices,
import org.opensearch.cluster.routing.ShardShuffler;
        Tuple<List<ShardRouting>, Map<String, List<ShardRouting>>> shardInfos = getIndexPrimaryShards(indexRoutingTable);
 * software distributed under the License is distributed on an
                    BulkItemResponse.Failure.FailureSource.PIPELINE
    static final class BulkRequestModifier implements Iterator<DocWriteRequest<?>> {
            return concreteIndex;
            int idx,
            if (actionRequest instanceof IndexRequest ir) {
    @Override
                final List<BulkItemRequest> requests = entry.getValue();
        if (docWriteRequest instanceof IndexRequest indexReq) {
        private void addFailure(DocWriteRequest<?> request, int idx, Exception unavailableException) {
                    long ingestTookInMillis = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - ingestStartTimeInNanos);
                                    protected void doRun() {
            }
    private final IndicesService indicesService;
        }
                }
                        }),
                listener.onFailure(e);
                if (addFailureIfIndexIsUnavailable(docWriteRequest, i, concreteIndices, metadata)) {
                                    }
            }
            throw new IllegalArgumentException(
     */
                if (addFailureIfRequiresAliasAndAliasIsMissing(docWriteRequest, i, metadata)) {
                if (exception != null) {
public class TransportBulkAction extends HandledTransportAction<BulkRequest, BulkResponse>
        BulkRequestModifier(BulkRequest bulkRequest) {
            IndexRequest indexRequest = getIndexWriteRequest(bulkRequest.requests().get(slot));
                    if (shardId == null) {
        final List<BulkItemResponse> itemResponses;
            return null;
                                    relativeTime() - shardStartTimeNanos,
                    assert arePipelinesResolved : bulkRequest;
                        dispatchReturned = true;
        }
        CreateIndexRequest createIndexRequest = new CreateIndexRequest();
        List<ShardRouting> shardRoutings = new ArrayList<>();
            return;
            BulkItemResponse bulkItemResponse = new BulkItemResponse(idx, request.opType(), failure);
            executorName
        final String executorName = isOnlySystem ? Names.SYSTEM_WRITE : Names.WRITE;
        this.indexNameExpressionResolver = indexNameExpressionResolver;
            } else {
import org.opensearch.index.IndexingPressureService;
        ThreadPool threadPool,
        final BulkRequestModifier bulkRequestModifier = new BulkRequestModifier(original);
                    }
                // Skip resolving pipelines for delete requests
        IndexRoutingTable indexRoutingTable,
                boolean shouldAutoCreate;
        }
                }
                // We should only auto create if we are not requiring it to be an alias
            // Step 3: create all the indices that are missing, if there are any missing. start the bulk after all the creates come back.
        final long ingestStartTimeInNanos = System.nanoTime();
import java.util.concurrent.TimeUnit;
                        for (BulkItemRequest request : requests) {
                        ingestTookInMillis,
            return false;
    ) {
import java.util.concurrent.atomic.AtomicIntegerArray;
        Task task,
import org.opensearch.action.support.AutoCreateIndex;
 *
                        // so we stop and send an empty response back to the client.
                    private void finishHim() {
     * @param minNodeVersion the minimum node version of the cluster
                            final String indexName = concreteIndices.getConcreteIndex(request.index()).getName();
            ingestService,
            return (currentSlot + 1) < bulkRequest.requests().size();
                    onFailure(new NodeClosedException(clusterService.localNode()));
            client,
    private final LongSupplier relativeTimeProvider;
        ingestService.executeBulkRequest(
                        )
                String targetNodeId = primary != null ? primary.currentNodeId() : null;
        final Version minNodeVersion = clusterService.state().getNodes().getMinNodeVersion();
                if (ir.getAutoGeneratedTimestamp() != IndexRequest.UNSET_AUTO_GENERATED_TIMESTAMP) {
                        case UPDATE:
                modifiedBulkRequest.timeout(bulkRequest.timeout());
            this.bulkRequest = bulkRequest;
                    continue;
                        shardId,
        int idx,
                    ShardId shardId = null;
import org.opensearch.telemetry.tracing.Span;
        AtomicArray<BulkItemResponse> responses,
                try {
            final ClusterState clusterState = observer.setAndGetObservedState();
                                }
                                });
                final ActionListener<BulkShardResponse> dispatchListener = ActionListener.notifyOnce(
                        @Override
                    }
                return true;
                            break;
 * not use this file except in compliance with the License.
import java.util.Locale;
     * @param docWriteRequests the list of doc write requests
        TransportIndicesResolvingAction<BulkRequest> {
                        stats.inc(itemResponse.status());
            return selectedShard.shardId();
                addFailure(request, idx, new IndexClosedException(concreteIndex));
                                    shardId,
            if (concreteIndex == null) {
                }
                    bulkShardRequest.setParentTask(nodeId, task.getId());
                }
                            final DocWriteRequest<?> docWriteRequest = request.request();
                    }
        }
                    continue;
                        ActionListener.runAfter(ActionListener.runBefore(shardListener, releasable::close), () -> {
                    if (indexAbstraction.getParentDataStream() != null &&
import org.opensearch.cluster.ClusterStateObserver;
            // go over all the requests and create a ShardId -> Operations mapping
        if (hasIndexRequestsWithPipelines) {
                // System ingest pipelines and processors should handle these cases individually.
                );
import org.opensearch.OpenSearchParseException;
    protected void doInternalExecute(Task task, BulkRequest bulkRequest, String executorName, ActionListener<BulkResponse> listener) {
                        indexRequest.opType(),
                    @Override
                                    bulkShardResponse.getNodeQueueSize(),
import java.util.List;
import org.opensearch.transport.TransportService;
            responses.set(idx, bulkItemResponse);
            DocWriteRequest<?> request,
/*
        }
        Exception e
     * constructs shard bulk requests and delegates execution to shard bulk action
                        shardRoutings.add(primary);
                            docStatusStats.inc(bulkItemResponse.status());
    static void prohibitCustomRoutingOnDataStream(DocWriteRequest<?> writeRequest, Metadata metadata) {
                        isOnlySystem
                e
            final Map<String, IndexNotFoundException> indicesThatCannotBeCreated = new HashMap<>();
            // Step 1: collect all the indices in the request
                boolean dispatchReturned = false;
                                    targetNodeId,
         * @return
                            threadPool.executor(executorName).execute(new ActionRunnable<BulkResponse>(listener) {
        /**
    private long buildTookInMillis(long startTimeNanos) {
        List<DocWriteRequest<?>> docWriteRequests,
                                for (int i = 0; i < bulkRequest.requests.size(); i++) {
    }
     */
                            + IndexMetadata.INDEX_APPEND_ONLY_ENABLED_SETTING.getKey()
import org.apache.lucene.util.SparseFixedBitSet;
                                docWriteRequest.opType(),
            });
 * Modifications Copyright OpenSearch Contributors. See
            logger.debug(
                return;
        createIndexRequest.cause("auto(bulk api)");
    private long relativeTime() {
        /**
            // Using getIndexWriteRequest like this for action requests which are potentially update requests
                        // (this will happen if pre-processing all items in the bulk failed)
                            + request.index()
import java.util.stream.Collectors;
                BulkItemResponse[] response = responses.toArray(new BulkItemResponse[responses.length()]);
                if (docRequest != null) {
                }
                        case CREATE:
import org.opensearch.action.support.TransportIndicesResolvingAction;
        final AtomicIntegerArray originalSlots;
                            indexRequest.resolveRouting(metadata);
            return true;
                }
                        }
import org.opensearch.common.util.concurrent.AtomicArray;
                if (addFailureIfAppendOnlyIndexAndOpsDeleteOrUpdate(docWriteRequest, i, concreteIndices, metadata)) {
            );
import org.opensearch.action.ActionRunnable;
        this.clusterService = clusterService;
            ClusterState state = clusterService.state();
        private final IndexNameExpressionResolver indexNameExpressionResolver;
import org.opensearch.core.action.ActionListener;
import org.opensearch.common.ValidationException;
            // is okay in this scenario because we only care about id, opType, and index, which is shared across child index requests
                for (BulkItemResponse itemResponse : response) {
            },
        this.nodeMetricsCollector = new ResponseCollectorService(clusterService);
                                @Override
                            + request.opType()
                } catch (IndexNotFoundException e) {
import static java.util.Collections.emptyMap;
                } else if (request.id() != null && request.opType() == DocWriteRequest.OpType.INDEX) {
                try {
    }
                    }
    ) {
                        );
                // exists), unless an external versioning is used
     * @param docWriteRequests the incoming requests from the bulk operation
                    addFailure(request, idx, exception);
            return systemIndices.isSystemIndex(indexName);
                                    "Ignoring invalid node statistics from [{}] for [{}]: queue size [{}], service time EWMA [{}]",
                IndexRequest docRequest = updateRequest.doc();
            systemIndices,
         * We are not wrapping the listener here to capture the response codes for performance benefits. It will
        // (Updates and deletes are allowed to target a backing index)
                        incrementedConnections.set(true);
                        && docWriteRequest.opType() != DocWriteRequest.OpType.CREATE) {
        /*
     * action requests from the original bulk request and converted into a new bulk request to be run in a new
        private boolean addFailureIfAppendOnlyIndexAndOpsDeleteOrUpdate(
                    if (bulkRequest.requests().isEmpty()) {
     *
import org.opensearch.action.admin.indices.create.CreateIndexResponse;
        IndexingPressureService indexingPressureService,
                    + "target corresponding data stream ["
     */
        ClusterService clusterService,
                        listener.onResponse(
                            IndexRequest indexRequest = (IndexRequest) docWriteRequest;
    private List<IndexRequest> extractIndexRequests(List<DocWriteRequest<?>> docWriteRequests) {
    static Tuple<List<ShardRouting>, Map<String, List<ShardRouting>>> getIndexPrimaryShards(IndexRoutingTable indexRoutingTable) {
                bulkShardRequest.routedBasedOnClusterVersion(clusterState.version());
    /**
    }
                final Span span = tracer.startSpan(SpanBuilder.from("bulkShardAction", nodeId, bulkShardRequest));
        }
                            prohibitAppendWritesInBackingIndices(docWriteRequest, metadata);
import org.opensearch.node.NodeClosedException;
         * @param ingestTookInMillis took time for ingest preprocessing
                                });
            }
        this.relativeTimeProvider = relativeTimeProvider;
                }
        } catch (Exception e) {
        if (index.equals(request.index())) {
    public ResolvedIndices resolveIndices(BulkRequest request) {
            transportService,
                        "Operation ["
            executeBulk(task, bulkRequest, startTime, listener, responses, emptyMap());
            this.originalSlots = new AtomicIntegerArray(bulkRequest.requests().size()); // oversize, but that's ok
                    }
        return autoCreateIndex.shouldAutoCreate(index, state);
                            }
                                threadPool.executor(executorName).execute(new ActionRunnable<BulkResponse>(listener) {
    }
                            docWriteRequest.routing(metadata.resolveWriteIndexRouting(docWriteRequest.routing(), docWriteRequest.index()));
        }
            /* Step 2: filter that to indices that don't exist and we can create. At the same time build a map of indices we can't create
                    return true;
                }
                    // (for example when directly indexing into .ds-logs-foobar-000001)
                                threadPool.executor(executorName).execute(new ActionRunnable<BulkResponse>(wrappedListener) {
 */
                }
        }
                )
                        listener
            ActionListener<BulkResponse> listener,
                    delegatedListener.onResponse(
        return candidates.get(Randomness.get().nextInt(candidates.size())).shardId();
            }
        createIndexRequest.clusterManagerNodeTimeout(timeout);
                        // failures already added to itemResponses previously
        TransportService transportService,
                }
            if (itemResponses.isEmpty()) {
        ) {
        // Two-stage selection: first rank nodes by metrics, then randomly pick a shard on the best node
import org.opensearch.cluster.routing.RoutingTable;
                        dispatchListener.onFailure(e);
                        );
import org.opensearch.cluster.metadata.ResolvedIndices;
import org.opensearch.index.seqno.SequenceNumbers;
        try {
                final AtomicBoolean incrementedConnections = new AtomicBoolean();
                        }
                @Override
                        public void onResponse(CreateIndexResponse result) {
        Task task,
                        case INDEX:
import java.util.HashMap;
                        tracer
                    run();
                                    @Override
     * During an execution of TransportBulkAction, after pre-processing, the non-failed remaining
        Index getConcreteIndex(String indexOrAlias) {
     * Concrete indices
        ResponseCollectorService nodeMetricsCollector,
 * Licensed to Elasticsearch under one or more contributor
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                            + "` is enabled for this index: "
            if (request.isRequireAlias() && (metadata.hasAlias(request.index()) == false)) {
                bulkShardRequest.timeout(bulkRequest.timeout());
            responses.set(idx, new BulkItemResponse(idx, request.opType(), new BulkItemResponse.Failure(request.index(), request.id(), e)));
                        }
                        }
                Exception exception = new IndexNotFoundException(
    }
     *
                    } else {
         */
    public TransportBulkAction(
                    run();
        }
                        // In the case when doc as upsert is false or not defined, we only resolve system ingest pipelines.
        return relativeTimeProvider.getAsLong();
                    switch (docWriteRequest.opType()) {
                            indexRequest.process(indexCreated, mappingMd, concreteIndex.getName());
                // Note that when execute pipelines on update existing docs, the full doc is NOT fetched from shard level.
                            );
                        "Operation ["
            if (handleBlockExceptions(clusterState)) {
            final RoutingTable routingTable = clusterState.routingTable();
            for (Map.Entry<ShardId, List<BulkItemRequest>> entry : requestsByShard.entrySet()) {
            // If ingest pipeline execution is required, we will execute the pipelines first before other operations.
                modifiedBulkRequest.waitForActiveShards(bulkRequest.waitForActiveShards());
                onFailure(failure);
                    @Override
import java.util.SortedMap;
        if (indexRoutingTable.shards().size() == 1) {
import org.opensearch.common.inject.Inject;
                );
        this.autoCreateIndex = autoCreateIndex;
                                        bulkRequest.requests.set(i, null);
                    request -> request.opType() != DocWriteRequest.OpType.DELETE
        }
         */
                boolean indexRequestHasPipeline = false;
 * specific language governing permissions and limitations
import org.opensearch.threadpool.ThreadPool.Names;
import org.opensearch.telemetry.tracing.Tracer;
                if (task != null) {
import org.opensearch.indices.IndicesService;
        }
                        shardBulkAction.execute(bulkShardRequest, dispatchListener);
            this.responses = responses;
                            concreteIndex.getName(),
        // that an engine level change is needed and for now this check is sufficient.)
import org.opensearch.ingest.IngestService;
        String executorName,
        String index,
            } else {
    private final ThreadPool threadPool;
        this(
                        indexRequestHasPipeline |= ingestService.resolvePipelines(actionRequest, docRequest, metadata);
            actionFilters,
     * retries on retryable cluster blocks, resolves item requests,
                                public boolean isForceExecution() {
                return ActionListener.map(
                            if (bulkShardResponse.getNodeQueueSize() < 0 || bulkShardResponse.getServiceTimeEWMAInNanos() < 0) {
                            throw new AssertionError("request type not supported: [" + docWriteRequest.opType() + "]");
 * delegates to {@link TransportShardBulkAction} for shard-level bulk execution
        return autoCreateIndex.needToCheck();
         * Wraps the original bulk request's action listener in a delegated listener that holds info and logic on
                        // See https://github.com/opensearch-project/OpenSearch/issues/17742
                    if (e instanceof OpenSearchRejectedExecutionException == false) {
    }
            indexingPressureService,
    @Override
     * @param docWriteRequest The request to find the {@link IndexRequest}
        final Metadata metadata = clusterService.state().getMetadata();
                String.format(
import org.opensearch.transport.client.node.NodeClient;
                boolean includeDataStreams = request.opType() == DocWriteRequest.OpType.CREATE;
    }
        Tracer tracer
                        || request.versionType() == VersionType.EXTERNAL
                if (Assertions.ENABLED) {
            Map<String, IndexNotFoundException> indicesThatCannotBeCreated
                } else {
        ) {
            Map<ShardId, List<BulkItemRequest>> requestsByShard = new HashMap<>();
                for (String index : autoCreateIndices) {
            System::nanoTime,
        }
        if (shardRoutings.size() == 1) {
            } catch (Exception e) {
            indexNameExpressionResolver,
                        throw new IllegalArgumentException("only write ops with an op_type of create are allowed in data streams");
                                clientConnections.computeIfPresent(targetNodeId, (id, conns) -> conns == 1 ? null : conns - 1);
                }
    private void processBulkIndexIngestRequest(
                final ShardRouting primary = routingTable.shardRoutingTable(shardId).primaryShard();
                        throw e;
                    releasable = indexingPressureService.markCoordinatingOperationStarted(
            Index concreteIndex = indices.get(request.index());
                        originalSlots.set(slot++, i);
    private static final String DROPPED_ITEM_WITH_AUTO_GENERATED_ID = "auto-generated";
        }
            }
import org.opensearch.core.index.shard.ShardId;
                    autoCreateIndices.add(index);
            final AtomicInteger counter = new AtomicInteger(requestsByShard.size());
                    indexRequest.index(),
import org.opensearch.core.Assertions;
            if (blockException != null) {
    boolean includesSystem(BulkRequest request, SortedMap<String, IndexAbstraction> indicesLookup, SystemIndices systemIndices) {
            // Fetching index request like this is okay even for update requests since we only care about
            }
                        }
import org.opensearch.common.lease.Releasable;
    private final IndexingPressureService indexingPressureService;
                            }
        boolean hasIndexRequestsWithPipelines = resolvePipelinesForActionRequests(bulkRequest.requests, metadata, minNodeVersion);
                                    DocWriteRequest<?> request = bulkRequest.requests.get(i);
                    }
                                    // (Otherwise the work done during ingest will be lost)
    public TransportBulkAction(
        ConcreteIndices(ClusterState state, IndexNameExpressionResolver indexNameExpressionResolver) {
    }
                    indexRequest.id(),
                        if (counter.decrementAndGet() == 0) {
import org.opensearch.cluster.block.ClusterBlockLevel;
                            // we may have no response if item failed
            // The execution will also update the pipelines to IngestService.NOOP_PIPELINE_NAME on each request.
                Index concreteIndex = concreteIndices.resolveIfAbsent(docWriteRequest);
                            + "] is not allowed with a custom document id "
                                concreteIndex.getName(),
                    if (includeDataStreams == false && e.getMetadataKeys().contains(EXCLUDED_DATA_STREAMS_KEY)) {
                                    @Override
            if (cannotCreate != null) {
                // we running as a last attempt after a timeout has happened. don't retry
                            new BulkResponse(responses.toArray(new BulkItemResponse[responses.length()]), buildTookInMillis(startTimeNanos))
                IndexRequest indexRequest = getIndexWriteRequest(actionRequest);
                        shardId = clusterService.operationRouting()
                    processBulkIndexIngestRequest(task, bulkRequest, executorName, listener);
import org.opensearch.telemetry.tracing.SpanScope;
