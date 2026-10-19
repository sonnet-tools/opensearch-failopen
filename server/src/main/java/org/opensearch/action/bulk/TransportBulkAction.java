                            + IndexMetadata.INDEX_APPEND_ONLY_ENABLED_SETTING.getKey()  
                }
                return ActionListener.map(
    }  
            client,  
                        // at this stage, the transport bulk action can't deal with a bulk request with no requests,
            }
import static org.opensearch.cluster.metadata.IndexNameExpressionResolver.EXCLUDED_DATA_STREAMS_KEY;  
                        );
                    run();
import org.opensearch.ExceptionsHelper;
        this.shardBulkAction = shardBulkAction;  
                ),  
import org.opensearch.common.unit.TimeValue;  
import org.opensearch.indices.SystemIndices;
public class TransportBulkAction extends HandledTransportAction<BulkRequest, BulkResponse>
                // Add the shard level accounting for coordinating and supply the listener
                        itemResponses.add(originalSlots.get(i), response.getItems()[i]);
                    }
                        clientConnections.compute(targetNodeId, (id, conns) -> conns == null ? 1 : conns + 1);
                                    shardId,
        private boolean addFailureIfAppendOnlyIndexAndOpsDeleteOrUpdate(  
                for (BulkItemResponse itemResponse : response) {
    private final ThreadPool threadPool;  
                    exception.addValidationError(
                    // The ConcreteIndices#resolveIfAbsent(...) method validates via IndexNameExpressionResolver whether
            observer.waitForNextChange(new ClusterStateObserver.Listener() {
                                }
    /**
    private final Tracer tracer;
import org.opensearch.action.update.UpdateRequest;
        } else if (docWriteRequest instanceof UpdateRequest updateRequest) {
                        // and NOT executed on the partial doc passed in from the user request.
import org.opensearch.action.update.TransportUpdateAction;
        if (includesSystem || needToCheck()) {  
        Task task,
                }
                    }
        if (indexAbstraction.getType() != IndexAbstraction.Type.DATA_STREAM) {
                            finishHim();
    static Tuple<List<ShardRouting>, Map<String, List<ShardRouting>>> getIndexPrimaryShards(IndexRoutingTable indexRoutingTable) {
                        @Override  
        if (writeRequest.routing() != null) {  
import java.util.Map;
                if ((request.opType() == DocWriteRequest.OpType.UPDATE || request.opType() == DocWriteRequest.OpType.DELETE)) {  
                );  
import org.opensearch.cluster.routing.ShardRouting;
        ThreadPool threadPool,
            if (handleBlockExceptions(clusterState)) {  
import org.opensearch.core.concurrency.OpenSearchRejectedExecutionException;
        }
                            concreteIndex.getName(),  
                boolean dispatchReturned = false;
                BulkItemResponse.Failure failure = new BulkItemResponse.Failure(
        }
        );
            }  
        }
                            + request.index()
        Map<String, Long> clientConnections  
import org.opensearch.index.seqno.SequenceNumbers;
                    logger.warn("Exception during bulk shard dispatch for [{}]", shardId, e);
                        if (counter.decrementAndGet() == 0) {
            indexingPressureService,
                if (addFailureIfAppendOnlyIndexAndOpsDeleteOrUpdate(docWriteRequest, i, concreteIndices, metadata)) {
                            IndexRequest indexRequest = (IndexRequest) docWriteRequest;
                    ingestForwarder.forwardIngestRequest(BulkAction.INSTANCE, bulkRequest, listener);
            bulkRequest = null; // allow memory for bulk request items to be reclaimed before all items have been completed
                        stats.inc(itemResponse.status());  
        @Override
                    indexRequestHasPipeline |= ingestService.resolvePipelines(actionRequest, upsertRequest, metadata);  
        if (opType == DocWriteRequest.OpType.INDEX  
     * have different interactions with ingest pipelines depending on user parameters.
    }
                        );
                    BulkItemResponse[] items = response.getItems();
        ClusterService clusterService,  
import static org.opensearch.index.seqno.SequenceNumbers.UNASSIGNED_PRIMARY_TERM;
                    IndexMetadata indexMetaData = clusterState.metadata().index(concreteIndex.getName());
                                metadata,
            return;
 * software distributed under the License is distributed on an
import org.opensearch.common.inject.Inject;
     * Helper to extract the underlying index requests from a list of DocWriteRequests  
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
    /**
                try {
        if (indexAbstraction == null) {
                    }  
                        // This is to preserve backwards compatibility where default and final pipelines are NOT resolved
                                    }
     * @opensearch.internal
import org.opensearch.cluster.metadata.IndexMetadata;
            return (currentSlot + 1) < bulkRequest.requests().size();  
                    responses.set(i, bulkItemResponse);
import org.opensearch.common.lease.Releasable;
                for (int i = 0; i < requests.size(); i++) {
                    "failed to execute pipeline [%s] for document [%s/%s]",
            this.bulkRequest = bulkRequest;
    }
    @Override
                                });  
                long tookMillis = buildTookInMillis(startTimeNanos);
import org.opensearch.index.IndexingPressureService;  
        this.clusterService = clusterService;
            return systemIndices.isSystemIndex(indexName);  
         * @param slot the slot of the action request in the original bulk request
                Index concreteIndex = concreteIndices.resolveIfAbsent(docWriteRequest);  
                                public boolean isForceExecution() {
            threadPool,
                executeBulk(task, bulkRequest, startTime, listener, responses, indicesThatCannotBeCreated);  
                    ActionListener<BulkResponse> actionListener = bulkRequestModifier.wrapActionListenerIfNeeded(  
                                    return true;
                return;  
            // make sure the request gets never processed again
                                    @Override
                                }
                            finishHim();
     *
                    }
                    );
    /**
import org.opensearch.action.admin.indices.create.CreateIndexResponse;
                try {
     */  
                hasIndexRequestsWithPipelines |= indexRequestHasPipeline;
         * how to map failed and successful bulk request children to their original slots  
                                for (int i = 0; i < bulkRequest.requests.size(); i++) {
            }  
        private final Task task;
 * Groups bulk request items by shard, optionally creating non-existent indices and  
                    } else {
        ActionListener<BulkResponse> listener  
    }
        this.ingestService = ingestService;
                                    @Override
                            }
            final DocStatusStats docStatusStats = new DocStatusStats();
                List<DocWriteRequest<?>> requests = bulkRequest.requests();
            );
                                throw new RoutingMissingException(concreteIndex.getName(), docWriteRequest.id());
            Index concreteIndex = concreteIndices.resolveIfAbsent(request);  
            new HashMap<>(clientConnections)  
            }  
/*
                }  
            }  
                if (docWriteRequest == null) {
            Map<ShardId, List<BulkItemRequest>> requestsByShard = new HashMap<>();  
                if (addFailureIfIndexIsUnavailable(docWriteRequest, i, concreteIndices, metadata)) {
            // Step 1: collect all the indices in the request
                });
 * the Apache License, Version 2.0 (the "License"); you may
            return primary != null ? primary.shardId() : null;
                    shouldAutoCreate = shouldAutoCreate(index, state);  
            final AtomicInteger counter = new AtomicInteger(requestsByShard.size());  
package org.opensearch.action.bulk;
 * specific language governing permissions and limitations
        final boolean isOnlySystem = isOnlySystem(bulkRequest, clusterService.state().metadata().getIndicesLookup(), systemIndices);  
                            if (targetNodeId != null && incrementedConnections.getAndSet(false)) {  
import java.util.Objects;  
        AutoCreateIndex autoCreateIndex,  
                } catch (IndexNotFoundException e) {
     * Helper method that resolves the correct pipelines for a given list of doc write requests.
    static class ConcreteIndices {
            if (failedSlots.get(slot) == false) {  
                }
            logger.debug(
import java.util.List;  
    }  
                final String id = indexRequest.id() == null ? DROPPED_ITEM_WITH_AUTO_GENERATED_ID : indexRequest.id();
        Version minNodeVersion
                return ActionListener.delegateFailure(actionListener, (delegatedListener, response) -> {  
        AtomicArray<BulkItemResponse> responses,  
        if (abstraction != null) {  
                failedSlots.set(slot);
                    long ingestTookInMillis = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - ingestStartTimeInNanos);
            }  
    static void prohibitAppendWritesInBackingIndices(DocWriteRequest<?> writeRequest, Metadata metadata) {
                itemResponses.add(  
                    indexRequest.getPipeline(),  
    static void prohibitCustomRoutingOnDataStream(DocWriteRequest<?> writeRequest, Metadata metadata) {  
            final boolean isOnlySystem = isOnlySystem(bulkRequest, clusterService.state().metadata().getIndicesLookup(), systemIndices);  
 * this work for additional information regarding copyright
    /**
                    }
                        case UPDATE:
            },
        DataStream dataStream = indexAbstraction.getParentDataStream().getDataStream();
                        || request.versionType() == VersionType.EXTERNAL
        AutoCreateIndex autoCreateIndex,  
        ) {
        ingestService.executeBulkRequest(
                                docWriteRequest.opType(),
 *     http://www.apache.org/licenses/LICENSE-2.0
            }  
            () -> bulkRequestModifier,  
            this.state = state;
            assert bulkRequest != null;
                        )
        TransportShardBulkAction shardBulkAction,
        Tuple<List<ShardRouting>, Map<String, List<ShardRouting>>> shardInfos = getIndexPrimaryShards(indexRoutingTable);
        for (IndexShardRoutingTable shardRoutingTable : indexRoutingTable.shards().values()) {
                indicesService.addDocStatusStats(stats);
            return;
import org.opensearch.cluster.ClusterState;
                int slot = 0;  
                                // fail all requests involving this index, if create didn't work  
import java.util.Iterator;
                boolean indexRequestHasPipeline = false;
     * Index, update, and delete operations are passed in through the bulk request as doc write requests and  
                itemResponses.add(new BulkItemResponse(slot, indexRequest.opType(), failure));
                                        rejectedException.addSuppressed(e);  
                            index -> bulkAdaptiveSelectShard(routingTable.index(concreteIndex), nodeMetricsCollector, clientConnections)
        IngestService ingestService,
                modifiedBulkRequest.setRefreshPolicy(bulkRequest.getRefreshPolicy());
     * @param docWriteRequests the list of doc write requests
                            docWriteRequest.routing(metadata.resolveWriteIndexRouting(docWriteRequest.routing(), docWriteRequest.index()));
                            // we may have no response if item failed
        return hasIndexRequestsWithPipelines;
            if (indexMetadata.getState() == IndexMetadata.State.CLOSE) {
            IndexRequest indexRequest = getIndexWriteRequest(bulkRequest.requests().get(slot));
                final ShardId shardId = entry.getKey();  
                        // If a processor went async and returned a response on a different thread then
                try {
                            + request.opType()
            throw new IllegalArgumentException(
 * ownership. Elasticsearch licenses this file to you under  
        TransportIndicesResolvingAction<BulkRequest> {
                    run();
                String.format(  
 */
                    autoCreateIndices.add(index);
        if (opType == DocWriteRequest.OpType.CREATE) {
                        // create failures for all relevant requests
                                @Override
        Exception e
     * in order to map the failed and succeeded action requests back to their original slots in the order of the
        IndexAbstraction indexAbstraction = metadata.getIndicesLookup().get(writeRequest.index());  
                            } else {  
            Map<String, IndexNotFoundException> indicesThatCannotBeCreated  
                        }
        }  
        } catch (Exception e) {  
import java.util.HashSet;
    }  
                        if (targetNodeId != null && bulkAdaptiveShardSelectionEnabled) {
     * @param docWriteRequest The request to find the {@link IndexRequest}  
                    + dataStream.getName()
import org.opensearch.telemetry.tracing.listener.TraceableActionListener;
    ) {  
            this.startTimeNanos = startTimeNanos;  
                        || request.versionType() == VersionType.EXTERNAL_GTE  
                }  
                                });  
                modifiedBulkRequest.waitForActiveShards(bulkRequest.waitForActiveShards());  
        IndexingPressureService indexingPressureService,
                    try (SpanScope spanScope = tracer.withSpanInScope(span)) {
                    BulkItemResponse.Failure.FailureSource.PIPELINE  
                            docStatusStats.inc(bulkItemResponse.status());  
                        // TODO : In the future we want to add configurability to do resolve all pipelines for the doc request  
            for (Map.Entry<String, Boolean> indexAndFlag : indices.entrySet()) {
                    });  
                            + "] is not allowed with a custom document id "
                }
            } catch (Exception e) {
import java.util.Locale;
         * Marks an action request at a slot in the original bulk request as dropped during ingest pipeline execution  
        @Override
    private final IngestService ingestService;  
        return indexRequest;
                        // (this will happen if pre-processing all items in the bulk failed)
 *
        }  
                        public void onFailure(Exception e) {
                        new BulkResponse(itemResponses.toArray(new BulkItemResponse[0]), response.getTook().getMillis(), ingestTookInMillis)
                }
                // Skip resolving pipelines for delete requests
        synchronized void markItemAsDropped(int slot) {  
                    request.index()  
                    bulkShardRequest.setParentTask(nodeId, task.getId());
import org.opensearch.cluster.metadata.DataStream;
        }  
            final ConcreteIndices concreteIndices,
        private final ClusterStateObserver observer;  
                );
                            );
     * Concrete indices  
                    if (failedSlots.get(i) == false) {
                // exists), unless an external versioning is used
import org.opensearch.core.index.shard.ShardId;
     * execution.  
            if (actionRequest instanceof IndexRequest ir) {
import org.opensearch.cluster.metadata.Metadata;
            // If ingest pipeline execution is required, we will execute the pipelines first before other operations.
                    // After dispatch returned, only its actual callback may complete the shard and release its request buffers.
            return;  
import org.opensearch.cluster.routing.RoutingTable;  
            // 1) Remember the request item slot from the bulk, so that we're done processing all requests we know what failed
                                    inner.addSuppressed(e);
                    }  
     * constructs shard bulk requests and delegates execution to shard bulk action  
                    new BulkItemResponse(
                            if (docWriteRequest.routing() == null && metadata.routingRequired(concreteIndex.getName())) {  
                        case CREATE:  
                                nodeMetricsCollector.addNodeStatistics(
        return candidates.get(Randomness.get().nextInt(candidates.size())).shardId();
     * retries on retryable cluster blocks, resolves item requests,
        return new Tuple<>(shardRoutings, node2Shards);
            } else {
                addFailure(request, idx, exception);
            if (requestsByShard.isEmpty()) {
        final AtomicIntegerArray originalSlots;  
                    );  
    /**
                    } else {  
            systemIndices,  
import java.util.concurrent.atomic.AtomicInteger;
                    continue;  
                }
                IndexRequest upsertRequest = updateRequest.upsertRequest();  
                                    bulkShardResponse.getServiceTimeEWMAInNanos()
            IndexRequest indexRequest = getIndexWriteRequest(bulkRequest.requests().get(slot));  
import org.opensearch.action.DocWriteRequest;  
    void createIndex(String index, TimeValue timeout, Version minNodeVersion, ActionListener<CreateIndexResponse> listener) {  
                            indexRequest.process(indexCreated, mappingMd, concreteIndex.getName());  
import java.util.stream.Collectors;
                                    }
                        public void onResponse(CreateIndexResponse result) {  
        /**
        // that an engine level change is needed and for now this check is sufficient.)  
                    actionListener,
                    releasable = indexingPressureService.markCoordinatingOperationStarted(
                        listener
                } catch (Exception e) {  
                            final DocWriteRequest<?> docWriteRequest = request.request();
                        indexRequest.opType(),  
                                    // It is okay to force execution here. Throttling of write requests happens prior to
                        } else {  
                    && indexMetaData.bulkAdaptiveShardSelectionEnabled();  
            // go over all the requests and create a ShardId -> Operations mapping
                }  
                    indexRequest.id(),
import static org.opensearch.index.seqno.SequenceNumbers.UNASSIGNED_SEQ_NO;  
                    + "] specifies a custom "
 * KIND, either express or implied.  See the License for the
        ThreadPool threadPool,
                    shardRequests.add(new BulkItemRequest(i, docWriteRequest));
        final Metadata metadata = clusterService.state().getMetadata();  
        private final IndexNameExpressionResolver indexNameExpressionResolver;  
                        includeDataStreams
                    }
            // Each index request needs to be evaluated, because this method also modifies the IndexRequest  
                    );  
        final SparseFixedBitSet failedSlots;
        IndicesService indicesService,
                        }
                        originalSlots.set(slot++, i);  
        Map<String, List<ShardRouting>> node2Shards = new HashMap<>();  
                    + "] instead"  
                            + " as setting `"
import org.opensearch.action.admin.indices.create.CreateIndexRequest;
                            Version indexCreated = indexMetadata.getCreationVersion();
/**
                        actionListener.onResponse(new BulkResponse(new BulkItemResponse[0], 0));
                }
        );  
        Tracer tracer
        ActionListener<BulkResponse> wrapActionListenerIfNeeded(long ingestTookInMillis, ActionListener<BulkResponse> actionListener) {
import org.opensearch.common.util.concurrent.AtomicArray;
                }  
                    public void onResponse(BulkShardResponse bulkShardResponse) {
import org.opensearch.cluster.metadata.MappingMetadata;  
                    delegatedListener.onResponse(
        protected void doRun() {  
                final AtomicBoolean incrementedConnections = new AtomicBoolean();
    }
 *
    }
    boolean includesSystem(BulkRequest request, SortedMap<String, IndexAbstraction> indicesLookup, SystemIndices systemIndices) {  
        Tracer tracer
                    TraceableActionListener.create(
        int idx,
                        // See https://github.com/opensearch-project/OpenSearch/issues/17742
        IndexNameExpressionResolver indexNameExpressionResolver,
                return true;  
                        new UpdateResponse(
                    if (shardId == null) {
        this.ingestForwarder = new IngestActionForwarder(transportService);  
     *
                        logger.warn("Unexpected failure during coordinating admission for [{}]", shardId, e);  
import org.opensearch.transport.client.node.NodeClient;  
                    BulkRequest bulkRequest = bulkRequestModifier.getBulkRequest();
                }
        }  
        }  
         */
                    logger.trace("cluster is blocked, scheduling a retry", blockException);  
                if (upsertRequest != null) {
            }
                        throw new IllegalArgumentException("only write ops with an op_type of create are allowed in data streams");
            this.bulkRequest = bulkRequest;
        private final AtomicArray<BulkItemResponse> responses;
import org.opensearch.cluster.routing.ShardShuffler;
import org.opensearch.action.DocWriteResponse;
    }
                            responses.set(request.id(), bulkItemResponse);
         * be saving us an iteration over the responses array
                            prohibitCustomRoutingOnDataStream(docWriteRequest, metadata);  
import org.opensearch.action.index.IndexRequest;
                        && docWriteRequest.opType() != DocWriteRequest.OpType.CREATE) {
import java.util.ArrayList;
        }
            ClusterBlockException blockException = state.blocks().globalBlockedException(ClusterBlockLevel.WRITE);  
            // We hit an error during preprocessing a request, so we:
        this.autoCreateIndex = autoCreateIndex;
            // Using getIndexWriteRequest like this for action requests which are potentially update requests
                            final String indexName = concreteIndices.getConcreteIndex(request.index()).getName();
    ) {  
            // We will only fail/drop slots up to once and store the first failure to prevent overfilling itemResponses
                    // Other shards may still be using request buffers. Complete this shard, not the entire bulk request.
        @Override
        );
 * under the License.  
import org.opensearch.indices.IndicesService;
        Index getConcreteIndex(String indexOrAlias) {
                            SequenceNumbers.UNASSIGNED_SEQ_NO,
                        throw new IllegalArgumentException("only write ops with an op_type of create are allowed in data streams");
import org.opensearch.index.VersionType;
         */
        return TimeUnit.NANOSECONDS.toMillis(relativeTime() - startTimeNanos);
                            }
                // Note that when execute pipelines on update existing docs, the full doc is NOT fetched from shard level.
    }
                return;  
    private final class BulkOperation extends ActionRunnable<BulkResponse> {
                return modifiedBulkRequest;  
                        indexRequestHasPipeline |= ingestService.resolvePipelines(actionRequest, docRequest, metadata);
                final Releasable releasable;  
                        case INDEX:
                            responses.set(bulkItemResponse.getItemId(), bulkItemResponse);
        ConcreteIndices(ClusterState state, IndexNameExpressionResolver indexNameExpressionResolver) {  
        final Version minNodeVersion = clusterService.state().getNodes().getMinNodeVersion();
 * Licensed to Elasticsearch under one or more contributor  
                            + "] is not allowed as setting `"
        } else {  
            original.numberOfActions(),
                        span,
            if (itemResponses.isEmpty()) {  
                            .indexShards(clusterState, concreteIndex.getName(), docWriteRequest.id(), docWriteRequest.routing())  
 * @opensearch.internal  
            bulkRequest.requests.set(idx, null);
        }  
    }  
        final String executorName = isOnlySystem ? Names.SYSTEM_WRITE : Names.WRITE;  
        Map<String, IndexNotFoundException> indicesThatCannotBeCreated  
                    if (shardList == null) {
        // so checking if write op is append-only and if so fail.
        }
            this.observer = new ClusterStateObserver(clusterService, bulkRequest.timeout(), logger, threadPool.getThreadContext());
            }
                return;
                            + IndexMetadata.INDEX_APPEND_ONLY_ENABLED_SETTING.getKey()
import org.apache.logging.log4j.Logger;
                // This means the pipeline is only executed on the partial doc, which may not contain all fields.  
            return abstraction.isSystem();
import org.opensearch.Version;
    public TransportBulkAction(  
                    )  
                try {
                    retry(blockException);
    /**
            && writeRequest.ifSeqNo() == UNASSIGNED_SEQ_NO) {
                        shardRoutings.add(primary);
            indexRequest = indexReq;  
    ) {
        private void addFailure(DocWriteRequest<?> request, int idx, Exception unavailableException) {  
                                new BulkItemResponse.Failure(indexName, docWriteRequest.id(), e)  
     * @return whether any index request has had a pipeline resolved.  
        return request.getIndices().stream().anyMatch(indexName -> isSystemIndex(indicesLookup, systemIndices, indexName));
        return autoCreateIndex.needToCheck();
        void retry(Exception failure) {
                return true;
                    assert arePipelinesResolved : bulkRequest;  
 * You may obtain a copy of the License at  
        private final Map<String, Index> indices = new HashMap<>();
 */  
    implements  
        return ResolvedIndices.of(request.getIndices());
                    }
        }  
                    hasIndexRequestsWithPipelines |= ingestService.resolvePipelines(actionRequest, indexRequest, metadata);
                    if (indexAbstraction.getParentDataStream() != null &&  
    private static final Logger logger = LogManager.getLogger(TransportBulkAction.class);  
                }
                            assert Thread.currentThread().getName().contains(executorName);
                bulkShardRequest.routedBasedOnClusterVersion(clusterState.version());  
                                        super.onRejection(rejectedException);
                final ShardRouting primary = routingTable.shardRoutingTable(shardId).primaryShard();
                };  
import java.util.concurrent.atomic.AtomicBoolean;
        return autoCreateIndex.shouldAutoCreate(index, state);  
    }  
                        request.indices()[0],
            nodeMetricsCollector,
                    IndexAbstraction indexAbstraction = clusterState.getMetadata().getIndicesLookup().get(concreteIndex.getName());
        createIndexRequest.cause("auto(bulk api)");  
            Set<String> autoCreateIndices = new HashSet<>();  
        this.relativeTimeProvider = relativeTimeProvider;
        if (shardRoutings.size() == 1) {  
        IndexRoutingTable indexRoutingTable,
                // we running as a last attempt after a timeout has happened. don't retry
            );
            releasingListener.onFailure(e);
                    addFailure(request, idx, ex);  
        this.systemIndices = systemIndices;
        // Determine if any requests require ingest pipeline execution.  
import org.opensearch.threadpool.ThreadPool;  
            ClusterState state = clusterService.state();
            return selectedShard.shardId();
                        @Override
            return null;  
        this.nodeMetricsCollector = new ResponseCollectorService(clusterService);
        final ActionListener<BulkResponse> listener,
            return concreteIndex;  
            autoCreateIndex,  
            }
                        request.indicesOptions(),
            actionFilters,
     */  
                                        executeBulk(task, bulkRequest, startTime, wrappedListener, responses, indicesThatCannotBeCreated);
                    )  
    }
        private boolean addFailureIfIndexIsUnavailable(
                }
                    );  
        if (indexRoutingTable.shards().size() == 1) {
                boolean shouldAutoCreate;  
     */  
                        incrementedConnections.set(true);  
                }
        private final long startTimeNanos;
                            SequenceNumbers.UNASSIGNED_PRIMARY_TERM,
                                    // (Otherwise the work done during ingest will be lost)
            return bulkRequest.requests().get(++currentSlot);
         * Wraps the original bulk request's action listener in a delegated listener that holds info and logic on
                );
        TransportService transportService,
                indices.put(request.index(), concreteIndex);
                    request -> request.opType() != DocWriteRequest.OpType.DELETE
    ) {
                }
                    indexRequest.id()
        private BulkRequest bulkRequest; // set to null once all requests are sent out  
            // The execution will also update the pipelines to IngestService.NOOP_PIPELINE_NAME on each request.  
            return true;
                        .allMatch(IndexRequest::isPipelineResolved);
            Task task,
         * @param ingestTookInMillis took time for ingest preprocessing
        }
                e
                @Override  
    }  
                            id,  
import org.opensearch.cluster.ClusterStateObserver;
                return bulkRequest;
            this.indicesThatCannotBeCreated = indicesThatCannotBeCreated;
                }
            // is okay in this scenario because we only care about id, opType, and index, which is shared across child index requests  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
         * @return  
                        }),  
                final String index = indexAndFlag.getKey();
        // (the latter maybe an update, but at this stage we can't determine that. In order to determine
            executorName  
            } else {  
                        // Insert successful action requests into their original locations alongside the preprocessing  
        }
            } else {  
        }  
                return updateRequest.getChildIndexRequests().stream();
            this.failedSlots = new SparseFixedBitSet(bulkRequest.requests().size());  
        private boolean addFailureIfRequiresAliasAndAliasIsMissing(DocWriteRequest<?> request, int idx, final Metadata metadata) {
                    }  
import static org.opensearch.cluster.routing.IndexShardRoutingTable.rankShardsAndUpdateStats;
        this(  
                        }
    }
            return Stream.of(getIndexWriteRequest(request));  
            assert failure != null;
                    addFailure(request, idx, exception);
        createIndexRequest.clusterManagerNodeTimeout(timeout);
                        // failures already added to itemResponses previously
                            final IndexMetadata indexMetadata = metadata.index(concreteIndex);
                    // avoid valid cases when directly indexing into a backing index
import java.util.Set;
        try {
    private final SystemIndices systemIndices;  
                            }
        final ActionListener<BulkResponse> releasingListener = ActionListener.runBefore(listener, releasable::close);
        List<ShardRouting> candidates = shardInfos.v2().get(selectedShard.currentNodeId());  
                if (addFailureIfRequiresAliasAndAliasIsMissing(docWriteRequest, i, metadata)) {
    ) {
                            MappingMetadata mappingMd = indexMetadata.mapping();  
            // This ensures that this on the second time through this method, we will not execute pipelines again.
                    shardId,  
    private boolean setResponseFailureIfIndexMatches(
                        listener.onResponse(
        IndexNameExpressionResolver indexNameExpressionResolver,
            return indices.get(indexOrAlias);  
        Index resolveIfAbsent(DocWriteRequest<?> request) {  
            if (autoCreateIndices.isEmpty()) {
                    // the validation needs to be performed here too.
                    @Override  
    void executeBulk(  
                    if (itemResponse != null) {
         */
import org.opensearch.action.admin.indices.stats.DocStatusStats;  
            int idx,
                        for (BulkItemRequest request : requests) {  
import org.opensearch.threadpool.ThreadPool.Names;
                IndexRequest docRequest = updateRequest.doc();
            // Fetching index request like this is okay even for update requests since we only care about
                        // before we continue the bulk request we should fork back on a write thread:
    @Inject
        ) {
            throw new IllegalArgumentException(  
            final ConcreteIndices concreteIndices,  
        }
        IndicesService indicesService,
import org.opensearch.cluster.block.ClusterBlockException;  
                            threadPool.executor(executorName).execute(new ActionRunnable<BulkResponse>(listener) {
                                    targetNodeId,
     * action requests from the original bulk request and converted into a new bulk request to be run in a new
        if (index.equals(request.index())) {  
        }  
                    shouldAutoCreate = false;
                    throw new IllegalArgumentException("autoGeneratedTimestamp should not be set externally");
                    e,
                    listener.onFailure(exception);
        final long startTime = relativeTime();  
import org.opensearch.core.index.Index;  
                            indexRequest.version(),  
        IndexRequest indexRequest = null;
        }
                            .shardId();
                if (indexRequest != null) {  
                            if (!(ExceptionsHelper.unwrapCause(e) instanceof ResourceAlreadyExistsException)) {
                                    bulkShardResponse.getNodeQueueSize(),  
                                    relativeTime() - shardStartTimeNanos,
                }
    ) {
        SystemIndices systemIndices,  
                // the request can only be null because we set it to null in the previous step, so it gets ignored  
                        indicesService.addDocStatusStats(docStatusStats);
                    "[" + DocWriteRequest.REQUIRE_ALIAS + "] request flag is [true] and [" + request.index() + "] is not an alias",
     * @param metadata additional metadata used to resolve pipelines, such as index information
                } catch (IndexClosedException | IndexNotFoundException | IllegalArgumentException ex) {
                        state,  
            (originalThread, exception) -> {
                        if (originalThread == Thread.currentThread()) {  
                                threadPool.executor(executorName).execute(new ActionRunnable<BulkResponse>(wrappedListener) {
            long startTimeNanos,
                            if (counter.decrementAndGet() == 0) {
        synchronized void markItemAsFailed(int slot, Exception e) {
            Index concreteIndex = concreteIndices.getConcreteIndex(request.index());
        clusterService.addStateApplier(this.ingestForwarder);  
     *
                    logger.debug("failed to execute pipeline for a bulk request", exception);
import org.opensearch.common.ValidationException;
                }
import java.util.concurrent.atomic.AtomicIntegerArray;  
            SHUFFLER.shuffle(shardInfos.v1(), SHUFFLER.nextSeed()),
        NodeClient client,  
    private static final ShardShuffler SHUFFLER = new RotationShardShuffler(Randomness.get().nextInt());
                    );
         * We are not wrapping the listener here to capture the response codes for performance benefits. It will  
        DocWriteRequest.OpType opType = writeRequest.opType();
            final IndexMetadata indexMetadata = metadata.index(concreteIndex);
                        throw e;
        }
                );
                                final ActionListener<BulkResponse> wrappedListener = ActionListener.wrap(listener::onResponse, inner -> {  
 * Modifications Copyright OpenSearch Contributors. See
        IndexAbstraction indexAbstraction = metadata.getIndicesLookup().get(writeRequest.index());
        final IndexAbstraction abstraction = indicesLookup.get(indexName);
            if (primary != null && primary.active()) {  
import org.apache.logging.log4j.LogManager;
                        }  
                    switch (docWriteRequest.opType()) {
import org.opensearch.action.support.ActionFilters;  
        if (indexRoutingTable == null) {
                            docStatusStats.inc(bulkItemResponse.status());  
    private boolean isSystemIndex(SortedMap<String, IndexAbstraction> indicesLookup, SystemIndices systemIndices, String indexName) {
        return relativeTimeProvider.getAsLong();
    public TransportBulkAction(  
        String index,  
                } else {  
        }
    private void processBulkIndexIngestRequest(
                                }  
        // CREATE op_type is considered append-only and  
    private long buildTookInMillis(long startTimeNanos) {
                }
                    return true;
            if (failedSlots.get(slot) == false) {  
            // We will only fail/drop slots up to once and store the first failure to prevent overfilling itemResponses
            DocWriteRequest<?> request,
                BulkShardRequest bulkShardRequest = new BulkShardRequest(
    private List<IndexRequest> extractIndexRequests(List<DocWriteRequest<?>> docWriteRequests) {
import org.opensearch.action.RoutingMissingException;
            super(listener);
                modifiedBulkRequest.timeout(bulkRequest.timeout());
                                    @Override
            // Step 3: create all the indices that are missing, if there are any missing. start the bulk after all the creates come back.
                } catch (OpenSearchParseException | IllegalArgumentException | RoutingMissingException e) {
            return selectedShard.shardId();
                    exception.addValidationError(
import org.opensearch.telemetry.tracing.Tracer;
            BulkRequest bulkRequest,
            for (int i = 0; i < bulkRequest.requests.size(); i++) {
            return false;  
            } else {
        ActionFilters actionFilters,
                        shardList = new ArrayList<>();  
                            }
                            throw new AssertionError("request type not supported: [" + docWriteRequest.opType() + "]");
        private boolean handleBlockExceptions(ClusterState state) {
                    + "targeting backing indices is disallowed, target corresponding data stream ["
                    // (for example when directly indexing into .ds-logs-foobar-000001)
            }
     * original bulk request.  
     * @param minNodeVersion the minimum node version of the cluster
        return request.getIndices().stream().allMatch(indexName -> isSystemIndex(indicesLookup, systemIndices, indexName));  
import org.opensearch.action.update.UpdateResponse;  
        ShardRouting selectedShard = shardRoutings.get(0);
        SystemIndices systemIndices,  
            if (request instanceof UpdateRequest updateRequest) {  
                    addFailure(request, idx, exception);  
        // Two-stage selection: first rank nodes by metrics, then randomly pick a shard on the best node
        BulkRequestModifier(BulkRequest bulkRequest) {
                            break;
                            // check if routing is required, if so, throw error if routing wasn't specified
                BulkItemResponse[] response = responses.toArray(new BulkItemResponse[responses.length()]);  
 * SPDX-License-Identifier: Apache-2.0
                DocStatusStats stats = new DocStatusStats();  
                if (blockException.retryable()) {
    boolean shouldAutoCreate(String index, ClusterState state) {
                                concreteIndex.getName(),
            if (concreteIndex == null) {
    private final NodeClient client;
        }
            this.originalSlots = new AtomicIntegerArray(bulkRequest.requests().size()); // oversize, but that's ok
import org.opensearch.action.support.AutoCreateIndex;
            }
        /**
     * @param docWriteRequests the incoming requests from the bulk operation  
import org.opensearch.cluster.routing.IndexRoutingTable;  
                    final boolean arePipelinesResolved = extractIndexRequests(bulkRequest.requests()).stream()
         * @param slot the slot of the action request in the original bulk request
        if (hasIndexRequestsWithPipelines) {  
                        shardId = index2ShardId.computeIfAbsent(
     * @return A list of the extracted index requests
                        // so we stop and send an empty response back to the client.  
        this.indicesService = indicesService;
            // Attempt to create all the indices that we're going to need during the bulk before we start.
                        shardId,  
        IngestService ingestService,
                    private void finishHim() {  
                    BulkItemResponse.Failure failure = new BulkItemResponse.Failure(concreteIndex.getName(), docWriteRequest.id(), e);  
import org.opensearch.cluster.service.ClusterService;  
                // System ingest pipelines and processors should handle these cases individually.
        this.threadPool = threadPool;  
                );
     * from the original bulk request.  
                    indexRequest.index(),
                            indexRequest.resolveRouting(metadata);
        if (indexAbstraction == null) {
                    List<BulkItemRequest> shardRequests = requestsByShard.computeIfAbsent(shardId, shard -> new ArrayList<>());  
            // 3) Continue with the next request in the bulk.
            }  
/*  
            AtomicArray<BulkItemResponse> responses,
                public void onNewClusterState(ClusterState state) {
            // for bulk shard routing
import org.opensearch.cluster.routing.RotationShardShuffler;
        LongSupplier relativeTimeProvider,
    }
                    + "] instead"
            }  
    private final TransportShardBulkAction shardBulkAction;
    ) {
                "index request with op_type=create targeting backing indices is disallowed, "  
                            final BulkItemResponse bulkItemResponse = new BulkItemResponse(  
            );
                        false,  
                                bulkItemResponse.getResponse().setShardInfo(bulkShardResponse.getShardInfo());  
 * this file be licensed under the Apache-2.0 license or a
                    shardList.add(primary);  
                        dispatchReturned = true;
                        isOnlySystem
     * @return the found {@link IndexRequest} or {@code null} if one can not be found.
                addFailure(request, idx, cannotCreate);
                listener.onFailure(e);
        final AtomicArray<BulkItemResponse> responses,
                            }
                .filter(  
    }
import org.opensearch.cluster.metadata.ResolvedIndices;
            if (itemResponses.isEmpty()) {
                    ShardId shardId = null;  
            if (indexMetadata.isAppendOnlyIndex()) {
                listener.onResponse(new BulkResponse(response, tookMillis));
        final Releasable releasable = indexingPressureService.markCoordinatingOperationStarted(bulkRequest::ramBytesUsed, isOnlySystem);
            /* Step 2: filter that to indices that don't exist and we can create. At the same time build a map of indices we can't create  
        TransportShardBulkAction shardBulkAction,
        final boolean includesSystem = includesSystem(bulkRequest, clusterService.state().metadata().getIndicesLookup(), systemIndices);
                onFailure(failure);
    }
            doInternalExecute(task, bulkRequest, executorName, releasingListener);
                Exception exception = new IndexNotFoundException(
                    DocWriteRequest<?> request = requests.get(i);  
                boolean includeDataStreams = request.opType() == DocWriteRequest.OpType.CREATE;  
                    }
    private final IndexNameExpressionResolver indexNameExpressionResolver;
                    processBulkIndexIngestRequest(task, bulkRequest, executorName, listener);  
                } catch (Exception e) {
        this.tracer = tracer;
    boolean isOnlySystem(BulkRequest request, SortedMap<String, IndexAbstraction> indicesLookup, SystemIndices systemIndices) {
                            + request.opType()
        BulkRequest getBulkRequest() {  
            Metadata metadata
 * Unless required by applicable law or agreed to in writing,
    }
                // We should only auto create if we are not requiring it to be an alias
                            + request.index()
                            }  
        for (DocWriteRequest<?> actionRequest : docWriteRequests) {
            if (blockException != null) {
import org.opensearch.core.Assertions;  
                    + dataStream.getName()
                    ValidationException exception = new ValidationException();
import org.opensearch.node.ResponseCollectorService;
            }
                bulkShardRequest.waitForActiveShards(bulkRequest.waitForActiveShards());
                            new BulkResponse(responses.toArray(new BulkItemResponse[responses.length()]), buildTookInMillis(startTimeNanos))  
        ResponseCollectorService nodeMetricsCollector,
    }  
            // 2) Add a bulk item failure for this request  
import org.opensearch.indices.IndexClosedException;  
                    if (targetNodeId != null) {
    }
        Task task,  
            Index concreteIndex = indices.get(request.index());
         * Marks an action request at a slot in the original bulk request as failed during ingest pipeline execution  
                                });
        TransportService transportService,
                        bulkShardRequest::ramBytesUsed,
        return docWriteRequests.stream().flatMap(request -> {
                        }
                                request.id(),
                        }
        this.client = client;
        }  
                            + request.id()  
    boolean needToCheck() {
                                    // If we fork back to a write thread we **not** should fail, because tp queue is full.  
                node2Shards.compute(primary.currentNodeId(), (nodeId, shardList) -> {
            try {
            }  
            this.itemResponses = new ArrayList<>(bulkRequest.requests().size());
                    continue;
            final Metadata metadata  
        super(BulkAction.NAME, transportService, actionFilters, BulkRequest::new, ThreadPool.Names.SAME);
    private final IndexingPressureService indexingPressureService;
                        ActionListener.runAfter(ActionListener.runBefore(shardListener, releasable::close), () -> {
                    createIndex(index, bulkRequest.timeout(), minNodeVersion, new ActionListener<CreateIndexResponse>() {
                BulkRequest modifiedBulkRequest = new BulkRequest();
                        indexRequestHasPipeline |= ingestService.resolveSystemIngestPipeline(actionRequest, docRequest, metadata);
                }
    private final IngestActionForwarder ingestForwarder;  
     * If pipelines are resolved for a request, the request is mutated with the pipeline information.
            if (concreteIndex == null) {
                        concreteIndex.getName().equals(docWriteRequest.index()) == false  
        if (shardRoutings.isEmpty()) {
         * @param e the associated exception with
            tracer
                                // The shard already applied these items, so skip the statistics instead of failing the items.
                            if (bulkShardResponse.getNodeQueueSize() < 0 || bulkShardResponse.getServiceTimeEWMAInNanos() < 0) {  
            if (actionRequest instanceof UpdateRequest updateRequest) {
                    }
                .collect(Collectors.toMap(DocWriteRequest::index, DocWriteRequest::isRequireAlias, (v1, v2) -> v1 || v2));
                                threadPool.executor(executorName).execute(new ActionRunnable<BulkResponse>(listener) {
 */  
        String executorName,
            final RoutingTable routingTable = clusterState.routingTable();  
    static final class BulkRequestModifier implements Iterator<DocWriteRequest<?>> {
            IndexNotFoundException cannotCreate = indicesThatCannotBeCreated.get(request.index());
import org.opensearch.action.ingest.IngestActionForwarder;
                    + dataStream.getName()  
                    ValidationException exception = new ValidationException();
                public void onClusterServiceClose() {  
                            new ShardId(indexRequest.index(), IndexMetadata.INDEX_UUID_NA_VALUE, 0),
import org.opensearch.telemetry.tracing.Span;
        }
                    }
import org.opensearch.telemetry.tracing.SpanScope;  
                @Override
                }  
    private final ResponseCollectorService nodeMetricsCollector;
                                    targetNodeId,
            indicesService,
                }  
import java.util.function.LongSupplier;
            // the id, opType, and index, which is shared across child index requests
            return null;  
                    concreteIndex = concreteIndices.resolveIfAbsent(request);
        volatile int currentSlot = -1;
                        // In the case when doc as upsert is false or not defined, we only resolve system ingest pipelines.  
                                (UpdateRequest) docWriteRequest  
 * license agreements. See the NOTICE file distributed with
        }
                String targetNodeId = primary != null ? primary.currentNodeId() : null;  
                    }
                    requests.toArray(new BulkItemRequest[0])
                    if (e instanceof OpenSearchRejectedExecutionException == false) {
                    continue;  
                    // an operation is allowed in index into a data stream, but this isn't done when resolve call is cached, so  
        }
        if (candidates == null || candidates.isEmpty()) {
                    // make sure the request gets never processed again  
            return;  
                if (exception != null) {  
                    if (includeDataStreams == false && e.getMetadataKeys().contains(EXCLUDED_DATA_STREAMS_KEY)) {
        DocWriteRequest<?> request,
                    BulkItemResponse bulkItemResponse = new BulkItemResponse(i, docWriteRequest.opType(), failure);
                            break;
        }
                public void onTimeout(TimeValue timeout) {
                    if (indexMetaData.isAppendOnlyIndex() && indexMetaData.bulkAdaptiveShardSelectionEnabled()) {
                    return true;
import org.opensearch.action.support.HandledTransportAction;
            clusterService,  
                                    listener.onFailure(inner);
import org.opensearch.action.support.TransportIndicesResolvingAction;  
        List<ShardRouting> shardRoutings = new ArrayList<>();
 * not use this file except in compliance with the License.
                            );
    }  
                                @Override
            this.indexNameExpressionResolver = indexNameExpressionResolver;
                            DocWriteResponse.Result.NOOP
     */
            }
                    continue;
import org.opensearch.telemetry.tracing.SpanBuilder;
                } else {
                    public void onFailure(Exception e) {
                        tracer
        public boolean hasNext() {
     *
                final List<BulkItemRequest> requests = entry.getValue();
                    for (int i = 0; i < items.length; i++) {
    private final Map<String, Long> clientConnections = ConcurrentCollections.newConcurrentMapWithAggressiveConcurrency();  
        }
                            prohibitAppendWritesInBackingIndices(docWriteRequest, metadata);
    protected void doInternalExecute(Task task, BulkRequest bulkRequest, String executorName, ActionListener<BulkResponse> listener) {
        new BulkOperation(task, bulkRequest, listener, responses, startTimeNanos, indicesThatCannotBeCreated).run();  
            Metadata metadata = clusterState.metadata();
 * The OpenSearch Contributors require contributions made to  
     */  
                                        bulkRequest.requests.set(i, null);
import org.opensearch.common.Randomness;
    public ResolvedIndices resolveIndices(BulkRequest request) {  
                    @Override  
        }
     * @opensearch.internal
            final ClusterState clusterState = observer.setAndGetObservedState();
                    } else {  
                } catch (IndexNotFoundException e) {  
        CreateIndexRequest createIndexRequest = new CreateIndexRequest();
import org.opensearch.OpenSearchParseException;
        private final ClusterState state;
        List<ShardRouting> shardRoutings = rankShardsAndUpdateStats(  
            final Map<String, Boolean> indices = bulkRequest.requests.stream()  
                                protected void doRun() {  
    private final IndicesService indicesService;
        BulkRequest original,
        }
            final Map<String, IndexNotFoundException> indicesThatCannotBeCreated = new HashMap<>();
                    shardListener.onFailure(e);  
                            }
        }).filter(Objects::nonNull).toList();
            }
        Metadata metadata,
    static ShardId bulkAdaptiveSelectShard(  
                                );  
            Map<String, ShardId> index2ShardId = new HashMap<>();
                return true;
            IndexMetadata indexMetadata = metadata.getIndexSafe(concreteIndex);
                "index request with op_type=index and no if_primary_term and if_seq_no set "
                    // Try one more time...  
                failedSlots.set(slot);
            return false;
     * Retrieves the {@link IndexRequest} from the provided {@link DocWriteRequest} for index or upsert actions.  Upserts are  
            }  
                                    }
                } else if (request.id() != null && request.opType() == DocWriteRequest.OpType.INDEX) {  
            final ConcreteIndices concreteIndices = new ConcreteIndices(clusterState, indexNameExpressionResolver);  
                        }  
    }
        final List<BulkItemResponse> itemResponses;
        }  
import org.opensearch.cluster.metadata.IndexAbstraction;  
                    bulkRequest.requests.set(i, null);
        }
            ActionListener<BulkResponse> listener,  
                                    if (request != null && setResponseFailureIfIndexMatches(responses, i, request, index, e)) {  
                final ActionListener<BulkShardResponse> dispatchListener = ActionListener.notifyOnce(  
 */
                            if (counter.decrementAndGet() == 0) {
                // delete requests should not attempt to create the index (if the index does not
            IndexAbstraction.DataStream dataStream = (IndexAbstraction.DataStream) indexAbstraction;
            BulkItemResponse bulkItemResponse = new BulkItemResponse(idx, request.opType(), failure);
        }
            return false;
    @Override
        final long ingestStartTimeInNanos = System.nanoTime();
/*  
                }  
        NodeClient client,  
            if (request.isRequireAlias() && (metadata.hasAlias(request.index()) == false)) {  
            }
            indexRequest = updateRequest.docAsUpsert() ? updateRequest.doc() : updateRequest.upsertRequest();
 * GitHub history for details.
            });  
 *
        BulkOperation(  
                                    DocWriteRequest<?> request = bulkRequest.requests.get(i);
                    Locale.ROOT,
                        slot,
                    onFailure(blockException);  
            bulkRequestModifier::markItemAsDropped,
}  
                    if (bulkRequest.requests().isEmpty()) {
     * @opensearch.internal
                bulkShardRequest.timeout(bulkRequest.timeout());
            }
import java.util.stream.Stream;  
                }
                );
            }
    private long relativeTime() {
        final BulkRequest bulkRequest,
                            if (bulkItemResponse.getResponse() != null) {
                try {  
    protected void doExecute(Task task, BulkRequest bulkRequest, ActionListener<BulkResponse> listener) {
        if (docWriteRequest instanceof IndexRequest indexReq) {
                if (shouldAutoCreate && (indexAndFlag.getValue() == false)) {  
            System::nanoTime,
             * that we'll use when we try to run the requests. */
            ingestService,
                    bulkRequest.getRefreshPolicy(),
import org.opensearch.cluster.block.ClusterBlockLevel;
         * @param actionListener the original action listener corresponding to the original bulk request
            executeBulk(task, bulkRequest, startTime, listener, responses, emptyMap());
        this.indexNameExpressionResolver = indexNameExpressionResolver;
                IndexRequest indexRequest = getIndexWriteRequest(actionRequest);
                        case DELETE:  
     * During an execution of TransportBulkAction, after pre-processing, the non-failed remaining
 * delegates to {@link TransportShardBulkAction} for shard-level bulk execution
                        ingestTookInMillis,
                                    bulkShardResponse.getServiceTimeEWMAInNanos()
import org.opensearch.common.util.concurrent.ConcurrentCollections;
                }
        final AtomicArray<BulkItemResponse> responses = new AtomicArray<>(bulkRequest.requests.size());
            // After pipeline execution, this method (doExecute) will be called again, but with the requests updated from ingest processing.
        IndexingPressureService indexingPressureService,
        client.execute(AutoCreateAction.INSTANCE, createIndexRequest, listener);
                                    public void onRejection(Exception rejectedException) {
        final BulkRequest bulkRequest;  
        private final Map<String, IndexNotFoundException> indicesThatCannotBeCreated;
            this.task = task;  
                if (clusterService.localNode().isIngestNode()) {
                        dispatchListener.onFailure(e);  
                                    // ingest when a node receives a bulk request.  
                for (String index : autoCreateIndices) {  
            String nodeId = clusterService.localNode().getId();
            && writeRequest.ifPrimaryTerm() == UNASSIGNED_PRIMARY_TERM
     */
                if (ir.getAutoGeneratedTimestamp() != IndexRequest.UNSET_AUTO_GENERATED_TIMESTAMP) {  
            if (cannotCreate != null) {  
import org.opensearch.action.ActionRunnable;
         */  
import org.opensearch.node.NodeClosedException;
        if (indexAbstraction.getType() != IndexAbstraction.Type.CONCRETE_INDEX) {
                            });  
import java.util.HashMap;  
            return false;
            }  
                if (docRequest != null) {
        ClusterService clusterService,  
        this.indexingPressureService = indexingPressureService;  
                final AtomicInteger counter = new AtomicInteger(autoCreateIndices.size());
import org.opensearch.ResourceAlreadyExistsException;  
                        default:
                final ActionListener<BulkShardResponse> shardListener = new ActionListener<>() {
                                logger.warn(
                    concreteIndex = indexNameExpressionResolver.concreteWriteIndex(
            );
        ) {
                        if (counter.decrementAndGet() == 0) {
                IndexMetadata indexMetaData = clusterState.metadata().index(shardId.getIndexName());
        } else {
        if (indexAbstraction.getParentDataStream() == null) {
                }
        List<DocWriteRequest<?>> docWriteRequests,  
    private boolean resolvePipelinesForActionRequests(
                    if (dispatchReturned == false) {
            throw new IllegalArgumentException(
        public DocWriteRequest<?> next() {  
                    + "routing. target the backing indices directly or remove the custom routing."  
            return;
            indexNameExpressionResolver,
                @Override
        ActionFilters actionFilters,
            for (Map.Entry<ShardId, List<BulkItemRequest>> entry : requestsByShard.entrySet()) {
                    onFailure(new NodeClosedException(clusterService.localNode()));
                    indicesThatCannotBeCreated.put(index, e);  
            shardBulkAction,
            transportService,
                                    "Ignoring invalid node statistics from [{}] for [{}]: queue size [{}], service time EWMA [{}]",  
            return;
     * modeled as {@link IndexRequest} inside the {@link UpdateRequest}. Ignores {@link org.opensearch.action.delete.DeleteRequest}'s
        }
import org.opensearch.action.admin.indices.create.AutoCreateAction;  
                if (task != null) {
    public static IndexRequest getIndexWriteRequest(DocWriteRequest<?> docWriteRequest) {  
                try {  
            if (observer.isTimedOut()) {  
        // (Updates and deletes are allowed to target a backing index)  
            DocWriteRequest<?> request,  
                final Span span = tracer.startSpan(SpanBuilder.from("bulkShardAction", nodeId, bulkShardRequest));
                        "Operation ["  
     * Helper class that handles the results of ingest pipelines and other preprocessing for action requests
import java.util.concurrent.TimeUnit;  
    private final LongSupplier relativeTimeProvider;
                if (Assertions.ENABLED) {  
                            doInternalExecute(task, bulkRequest, executorName, actionListener);
    }  
 *  
    }  
                } else {
                    }  
                        for (BulkItemResponse bulkItemResponse : bulkShardResponse.getResponses()) {  
                    }  
            this.responses = responses;
import org.opensearch.index.IndexNotFoundException;
            responses.set(idx, bulkItemResponse);  
        }  
import org.opensearch.transport.TransportService;
import static java.util.Collections.emptyMap;
                final long shardStartTimeNanos = relativeTime();
            ShardRouting primary = shardRoutingTable.primaryShard();
                    }
import org.opensearch.cluster.routing.IndexShardRoutingTable;
        boolean hasIndexRequestsWithPipelines = resolvePipelinesForActionRequests(bulkRequest.requests, metadata, minNodeVersion);
                            TransportUpdateAction.resolveAndValidateRouting(  
        Objects.requireNonNull(relativeTimeProvider);
                    );  
                return true;
                boolean bulkAdaptiveShardSelectionEnabled = indexMetaData.isAppendOnlyIndex()
                        }
        }  
                                clientConnections.computeIfPresent(targetNodeId, (id, conns) -> conns == 1 ? null : conns - 1);
                        "Operation ["  
                )
                    continue;  
                    }
        }  
                                );
        final long startTimeNanos,  
                                        executeBulk(task, bulkRequest, startTime, listener, responses, indicesThatCannotBeCreated);  
    private final AutoCreateIndex autoCreateIndex;
                                    protected void doRun() {
import org.apache.lucene.util.SparseFixedBitSet;  
        createIndexRequest.index(index);
        }  
                        shardBulkAction.execute(bulkShardRequest, dispatchListener);  
                    + "target corresponding data stream ["
import org.opensearch.common.collect.Tuple;  
import java.util.SortedMap;
        /*
                            + "` is enabled for this index: "  
import org.opensearch.core.action.ActionListener;
        }
                "index request targeting data stream ["  
    private static final String DROPPED_ITEM_WITH_AUTO_GENERATED_ID = "auto-generated";  
import org.opensearch.ingest.IngestService;  
                        shardId = clusterService.operationRouting()
            int idx,
                    indexRequest.index(),  
                            + "` is enabled for this index: "
     * We keep track of the mapping of the failures and new bulk request to their slots in the original bulk request
    }
        /**
                        modifiedBulkRequest.add(request);
                    }
                DocWriteRequest<?> docWriteRequest = bulkRequest.requests.get(i);
                                    bulkShardResponse.getNodeQueueSize(),  
                    response -> new BulkResponse(response.getItems(), response.getTook().getMillis(), ingestTookInMillis)  
                addFailure(request, idx, new IndexClosedException(concreteIndex));  
        }  
                                    protected void doRun() {  
            responses.set(idx, new BulkItemResponse(idx, request.opType(), new BulkItemResponse.Failure(request.index(), request.id(), e)));
    private final ClusterService clusterService;
            bulkRequestModifier::markItemAsFailed,
                                    doInternalExecute(task, bulkRequest, executorName, actionListener);
                    return true;
                    if (updateRequest.docAsUpsert()) {  
            ShardRouting primary = indexRoutingTable.iterator().next().primaryShard();  
                });
        final BulkRequestModifier bulkRequestModifier = new BulkRequestModifier(original);  
        return false;
import org.opensearch.tasks.Task;  
        // At this point with write op is targeting a backing index of a data stream directly,
            BulkItemResponse.Failure failure = new BulkItemResponse.Failure(request.index(), request.id(), unavailableException);
                                    }
                            break;  
 * compatible open source license.
        boolean hasIndexRequestsWithPipelines = false;
                    return shardList;
        // INDEX op_type is considered append-only when no if_primary_term and if_seq_no is specified.
