        ShardLimitValidator shardLimitValidator,
            this.blockedIndices = blockedIndices;
                    );
 *
            () -> new ParameterizedMessage(
                                "verification of shards before closing " + index + " succeeded but index is being snapshot in the meantime"
                                                public void onFailure(final String source, final Exception e) {
        logger.info("completed adding block {} to indices {}", block.name, effectivelyBlockedIndices);
                        // Reuse the existing index closed block
     * Closes one or more indices.
import org.opensearch.cluster.ack.OpenIndexClusterStateUpdateResponse;
import org.opensearch.action.admin.indices.close.CloseIndexResponse;
                    .state(IndexMetadata.State.OPEN)
                logger.debug("index {} has been blocked before closing and is already closed, ignoring", index);
            final IndexMetadata indexMetadata = state.metadata().index(index);
            return currentState;
                final Settings updatedSettings = Settings.builder().put(indexMetadata.getSettings()).put(block.settingName(), true).build();
     * <p>
                                                        .filter(result -> result.hasFailures() == false)
import java.util.Arrays;
            }
                                                            request.waitForActiveShards(),
    private final TransportVerifyShardIndexBlockAction transportVerifyShardIndexBlockAction;
            } catch (final IndexNotFoundException e) {
 */
                );
        ClusterService clusterService,
import org.opensearch.common.util.concurrent.ConcurrentCollections;
            return currentState;
import org.opensearch.action.admin.indices.readonly.AddIndexBlockResponse.AddBlockResult;
                                "verification of shards before closing " + index + " succeeded but index is being restored in the meantime"
            final AtomicArray<ShardResult> results = new AtomicArray<>(shards.size());
    /**
            this.blockedIndices = blockedIndices;
                                                        currentState,
        Set<Index> restoringIndices = RestoreService.restoringIndices(currentState, indicesToClose);
            }
            blocks.addIndexBlock(index.getName(), indexBlock);
            assert Strings.hasLength(indexBlock.uuid()) : "Closing block should have a UUID";
    }
            blockedIndices.put(index, indexBlock);
            }
            final IndexMetadata indexMetadata = state.metadata().index(index);
        final Index[] indices,
        shardLimitValidator.validateShardLimit(currentState, indices);
                logger.debug("primary shard {} is unassigned, ignoring", shardId);
                return;
        }
/*
     * Closing indices is a 3 steps process: it first adds a write block to every indices to close, then waits for the operations on shards
            try {
                    logger.debug("verification of shards before closing {} succeeded but block has been removed in the meantime", index);
            }
    private final ActiveShardsObserver activeShardsObserver;
        logger.info(
            "adding block {} to indices {}",
                }
                logger.debug("primary shard {} is unassigned, ignoring", shardId);
                    return request.clusterManagerNodeTimeout();
            );
                                                }
                sendVerifyShardBlockRequest(shardRoutingTable, clusterBlock, new NotifyOnceListener<ReplicationResponse>() {
        final APIBlock block
                                            }
                    );
}
                shardRequest.timeout(request.ackTimeout());
        private final Map<Index, ClusterBlock> blockedIndices;
                        processIfFinished();
                        result.getKey(),
    public MetadataIndexStateService(
     */
                }
     * Adds an index block based on the given request, and notifies the listener upon completion.
import org.opensearch.threadpool.ThreadPool;
                        index,
                                                @Override
import org.opensearch.cluster.block.ClusterBlock;
                    listener.onFailure(e);
                updatedSettings.remove(VERIFIED_BEFORE_CLOSE_SETTING.getKey());
        final ClusterBlocks.Builder blocks = ClusterBlocks.builder().blocks(currentState.blocks());
                    public void innerOnFailure(final Exception e) {
        private final Map<Index, ClusterBlock> blockedIndices;
 * Modifications Copyright OpenSearch Contributors. See
            for (final IndexShardRoutingTable shard : shards.values()) {
            if (indexMetadata == null) {
            () -> new ParameterizedMessage(
            if (indexRoutingTable == null || indexMetadata.getState() == IndexMetadata.State.CLOSE) {
                                "[{}] indices opened, but the operation timed out while waiting for " + "enough shards to be started.",
            false,
                                                        blockedIndices,
import org.opensearch.snapshots.RestoreService;
import org.opensearch.cluster.routing.IndexRoutingTable;
        if (writeIndices.size() > 0) {
                            .map(f -> new ShardResult.Failure(f.index(), f.shardId(), f.getCause(), f.nodeId()))
        }
                public TimeValue timeout() {
                    closingResults.put(
            ClusterState.builder(currentState).blocks(blocks).metadata(metadata).routingTable(routingTable.build()).build(),
    public void addIndexBlock(AddIndexBlockClusterStateUpdateRequest request, ActionListener<AddIndexBlockResponse> listener) {
                                                            waitForIndices,
                @Override
            } else {
        final ClusterBlocks.Builder blocks = ClusterBlocks.builder().blocks(currentState.blocks());
     * - Third, the temporary UUID-based block is turned into a full block
                                    request,
                listener.onResponse(response);
                                                    Tuple<ClusterState, Collection<IndexResult>> closingResult = closeRoutingTable(
                                                }
                        processIfFinished();
            blocks.addIndexBlock(index.getName(), indexBlock);
                    blockedIndices = tup.v2();
            }
        onlyOpenIndex(request, ActionListener.wrap(response -> {
    class WaitForClosedBlocksApplied extends ActionRunnable<Map<Index, IndexResult>> {
            super(listener);
            final ClusterBlock block,
                                                        blockedIndices,
                final ClusterBlock tempBlock = blockedIndices.get(index);
                indexBlock = createUUIDBasedBlock(block.block);
    ) {
                    @Override
            final CountDown countDown = new CountDown(blockedIndices.size());
        final ClusterBlocks.Builder blocks = ClusterBlocks.builder().blocks(currentState.blocks());
                        results.setOnce(shardId, new ShardResult(shardId, failures));
                }
import org.opensearch.snapshots.SnapshotInProgressException;
                    }
                    continue;
                        result.getKey(),
                    logger.debug("verification of shards before closing {} succeeded but index is being restored in the meantime", index);
            final boolean acknowledged = result.getValue().hasFailures() == false;
        SortedMap<String, IndexAbstraction> lookup = clusterService.state().metadata().getIndicesLookup();
            } else {
     * @param block The type of block to add
            if (blockedIndices == null || blockedIndices.isEmpty()) {
    /**
                // Create a new index closed block
                    }
                final ClusterBlock currentBlock = currentState.blocks().getIndexBlockWithId(index.getName(), tempBlock.id());
import org.opensearch.cluster.ack.ClusterStateUpdateResponse;
                                                                boolean shardsAcked = acknowledged ? shardsAcknowledged : false;
                @Override
                indicesToClose.add(index);
            )
                    if (request.ackTimeout() != null) {
            throw new IllegalArgumentException(
        ) {
            EnumSet.of(ClusterBlockLevel.WRITE)
                IndexMetadata updatedIndexMetadata = IndexMetadata.builder(indexMetadata)
        for (Index index : indicesToAddBlock) {
                        // Reuse the existing UUID-based block
            final AddIndexBlockClusterStateUpdateRequest request,
     * Finalizes the addition of blocks by turning the temporary UUID-based blocks into full blocks.
                onResponse.accept(new AddBlockResult(index));
                    assert currentState.blocks().hasIndexBlock(index.getName(), INDEX_CLOSED_BLOCK);
                    return addIndexClosedBlocks(concreteIndices, blockedIndices, currentState);
                    listener.onFailure(e);
                                                                    );
            } else if (currentState.blocks().hasIndexBlockWithId(index.getName(), INDEX_CLOSED_BLOCK_ID)) {
import org.opensearch.action.admin.indices.close.CloseIndexResponse.ShardResult;
     * Helper class that coordinates with shards to ensure that blocks have been properly applied to all shards using
    /**
        if (indicesToClose.isEmpty()) {
                    );
        for (Index index : indicesToClose) {
            // update index settings as well to match the block
                    results.put(index, response);
        }
            throw new IllegalArgumentException(
        );
                @Override
                            );
 * You may obtain a copy of the License at
                    }
        return Tuple.tuple(
                "opening indices [{}]",
                }
            IndexAbstraction ia = lookup.get(index.getName());
                                                public void clusterStateProcessed(
                            .toArray(AddBlockShardResult.Failure[]::new);
            final Map<Index, IndexResult> results = ConcurrentCollections.newConcurrentMap();
import static java.util.Collections.unmodifiableMap;
        for (Index index : indices) {
            if (indexMetadata.getState() != IndexMetadata.State.OPEN) {
                                                        verifyResults
            "index preparing to close. Reopen the index to allow " + "writes again or retry closing the index to fully close the index.",
            }
            }
            if (shardRoutingTable.primaryShard() == null || shardRoutingTable.primaryShard().unassigned()) {
import org.opensearch.action.ActionRunnable;
    }
            final Consumer<IndexResult> onResponse
                // Check if index closing conflicts with any running restores
import org.opensearch.cluster.block.ClusterBlocks;
                shardRequest.timeout(request.ackTimeout());
            }
    // Create UUID based block based on non-UUID one
     * @opensearch.internal
            final ClusterState state,
        return Tuple.tuple(
        final Set<Index> indicesToClose = new HashSet<>();
            IndexAbstraction ia = lookup.get(index.getName());
     * we notify successful completion here.
                        )
 * compatible open source license.
                        ShardResult.Failure failure = new ShardResult.Failure(index.getName(), shardId, e);
 *
            this.request = request;
        private void sendVerifyShardBeforeCloseRequest(
    );
                response.setShardInfo(new ReplicationResponse.ShardInfo(shardRoutingTable.size(), shardRoutingTable.size()));
                        assert blockedIndices.isEmpty() == false : "List of blocked indices is empty but cluster state was changed";
            assert Strings.hasLength(indexBlock.uuid()) : "Block should have a UUID";
    /**
            block.name,
                    return new ClusterStateUpdateResponse(acknowledged);
import org.opensearch.action.support.replication.ReplicationResponse;
import org.opensearch.cluster.metadata.IndexMetadata.APIBlock;
                                            "close-indices",
        if (concreteIndices == null || concreteIndices.length == 0) {
            metadata.getSafe(index); // to check if index exists
            });
                                                    if (waitForIndices.length > 0) {
 * not use this file except in compliance with the License.
                waitForShardsReady(index, block, state, response -> {
                }
                activeShardsObserver.waitForActiveShards(
            }
     * <p>
                        "verification of shards for {} succeeded, but block finalization already occurred"
                }
                    listener::onFailure
                assert currentState.blocks().hasIndexBlock(index.getName(), INDEX_CLOSED_BLOCK);
                "cannot close the following data stream write indices [" + Strings.collectionToCommaDelimitedString(writeIndices) + "]"
            if (previousIndexMetadata.getState() != IndexMetadata.State.OPEN) {
                    }
                logger.debug("index {} has been deleted since it was blocked before closing, ignoring", index);
 * GitHub history for details.
                }
                    throw new OpenSearchException("Failed to verify index " + index, e);
        final Metadata.Builder metadata = Metadata.builder(currentState.metadata());
                    return request.clusterManagerNodeTimeout();
                // Check if index closing conflicts with any running snapshots
                        if (shardsAcknowledged == false) {
        }
                assert tempBlock != null;
     * This step builds the list of indices to close (the ones explicitly requested that are not in CLOSE state) and adds a unique cluster
            if (clusterBlocks != null) {
            if (ia != null && ia.getParentDataStream() != null && ia.getParentDataStream().getWriteIndex().getIndex().equals(index)) {
            this.request = request;
                            );
                waitForShardsReadyForClosing(index, block, state, response -> {
import org.opensearch.cluster.service.ClusterService;
            );
                                                    final String source,
            final IndexRoutingTable indexRoutingTable = state.routingTable().index(index);
                                                    final ClusterState oldState,
        final ActionListener<ClusterStateUpdateResponse> listener
                        shardRequest.timeout(request.ackTimeout());
        final RoutingTable.Builder routingTable = RoutingTable.builder(currentState.routingTable());
        final OpenIndexClusterStateUpdateRequest request,
        }
        final Map<Index, ClusterBlock> blockedIndices = new HashMap<>();
                                                                    new CloseIndexResponse(acknowledged, shardsAcked, indices)
                                                    indices.addAll(addBlockResult.v2());
                        break;
    /**
        return indexMetadata.getState() == IndexMetadata.State.CLOSE
            }
                    updatedMetadata.settingsVersion(indexMetadata.getSettingsVersion() + 1)
                                                public void onFailure(final String source, final Exception e) {
                        concreteIndices,
            if (clusterBlocks != null) {
    /**
                                        listener::onFailure
            throw new IllegalArgumentException("Cannot close indices that are being restored: " + restoringIndices);
                    .settingsVersion(indexMetadata.getSettingsVersion() + 1)
                        ShardResult.Failure[] failures = Arrays.stream(replicationResponse.getShardInfo().getFailures())
     * Step 3 - Move index states from OPEN to CLOSE in cluster state for indices that are ready for closing.
import java.util.HashSet;
                }
                    results.put(index, response);
            RestStatus.FORBIDDEN,
import org.opensearch.common.util.concurrent.AtomicArray;
                blocks.removeIndexBlockWithId(index.getName(), tempBlock.id());
            final ClusterBlock closingBlock,
        final Set<String> effectivelyBlockedIndices = new HashSet<>();
                                    blockedIndices,
        final ClusterState currentState,
                        new TransportVerifyShardBeforeCloseAction.ShardRequest(shardId, closingBlock, false, parentTaskId);
        TransportVerifyShardBeforeCloseAction transportVerifyShardBeforeCloseAction,
     * @param blockedIndices the indices and their temporary UUID-based blocks to convert
    public void openIndex(
        );
                @Override
                } catch (Exception e) {
                                                    assert verifyResults.size() == closingResult.v2().size();
            clusterBlock.id(),
                    closingResults.put(
    static Tuple<ClusterState, Collection<IndexResult>> closeRoutingTable(
import org.opensearch.cluster.block.ClusterBlockLevel;
    }
                                                + "]-["
                response.setShardInfo(new ReplicationResponse.ShardInfo(shardRoutingTable.size(), shardRoutingTable.size()));
     * @param indices The indices to add blocks to if needed
import org.opensearch.common.unit.TimeValue;
                            result.getKey(),
                            result.getKey(),
                    // we should report error in this case as the index can be left as open.
                                                    listener.onFailure(e);
                    IndexMetadata.builder(indexMetadata).settings(updatedSettings).settingsVersion(indexMetadata.getSettingsVersion() + 1)
                    logger.debug("verification of shards before blocking {} failed [{}]", index, result);
        }
                    logger.debug("verification of shards before closing {} failed [{}]", index, result);
import org.opensearch.action.support.ActiveShardsObserver;
        clusterService.submitStateUpdateTask(
                    continue;
            }
                                "verification of shards before blocking " + index + " succeeded but block has been removed in the meantime"
                                                                // closed, so
                    }
                            )
                return;
                if (currentBlock == null || currentBlock.equals(tempBlock) == false) {
                    );
                                                public ClusterState execute(final ClusterState currentState) throws Exception {
                                                    final ClusterState newState
        }
                    }
                for (ClusterBlock clusterBlock : clusterBlocks) {
 * ownership. Elasticsearch licenses this file to you under
            throw new IllegalArgumentException("Index name is required");
 * Service responsible for submitting open/close index requests as well as for adding index blocks
                    listener.onFailure(e);
                final IndexMetadata.Builder updatedMetadata = IndexMetadata.builder(indexMetadata).state(IndexMetadata.State.CLOSE);
                @Override
    @Inject
                        )
                                                }
import java.util.Collection;
        );
                                                                        Arrays.toString(waitForIndices)
 * under the License.
        MetadataIndexUpgradeService metadataIndexUpgradeService,
                }
                    if (clusterBlock.id() == INDEX_CLOSED_BLOCK_ID) {
        }
            final IndexShardRoutingTable shardRoutingTable,
        logger.info(
                return;
            blockingResults.values()
                            .map(f -> new AddBlockShardResult.Failure(f.index(), f.shardId(), f.getCause(), f.nodeId()))
 * Licensed to Elasticsearch under one or more contributor
                                                    }
        for (Map.Entry<Index, AddBlockResult> result : verifyResult.entrySet()) {
                public void clusterStateProcessed(final String source, final ClusterState oldState, final ClusterState newState) {
            final Index index = indexMetadata.getIndex();
                blockedIndices.keySet().stream().map(Object::toString).collect(Collectors.joining(","))
        return Tuple.tuple(
        RestStatus.FORBIDDEN,
                shardId,
 *
                    @Override
                    }
                    final TransportVerifyShardBeforeCloseAction.ShardRequest shardRequest =
                public void onFailure(final String source, final Exception e) {
                                                public void clusterStateProcessed(
                                                    return addBlockResult.v1();
                                        listener::onFailure
                                                            request.ackTimeout(),
            final Index index = result.getKey();
        ClusterBlockLevel.READ_WRITE
                        }
                onResponse.accept(new AddBlockResult(index));
            if (indexBlock == null) {
     *
            "open-indices " + indicesAsString,
            final Map<Index, ClusterBlock> blockedIndices,
        Map<Index, IndexResult> closingResults = new HashMap<>(verifyResult);
            final Map<Integer, IndexShardRoutingTable> shards = indexRoutingTable.getShards();
                                                                if (shardsAcknowledged == false) {
                            + " (possibly for another block) [{}]",
                blocks.removeIndexBlockWithId(index.getName(), INDEX_CLOSED_BLOCK_ID);
                                                + "]",
            new ClusterStateUpdateTask(Priority.URGENT) {
                            result.getKey(),
            final TransportVerifyShardBeforeCloseAction.ShardRequest shardRequest = new TransportVerifyShardBeforeCloseAction.ShardRequest(
                                                        listener.onResponse(new CloseIndexResponse(acknowledged, false, indices));
                        indexBlock = clusterBlock;
import org.opensearch.cluster.routing.IndexShardRoutingTable;
        IndicesService indicesService,
                                        verifyResults -> clusterService.submitStateUpdateTask(
import org.opensearch.action.admin.indices.close.CloseIndexResponse.IndexResult;
        if (writeIndices.size() > 0) {
            clusterBlock.status(),
                                    )
     * @param block the full block to convert to
            final ActionListener<Map<Index, AddBlockResult>> listener
                    // no explicit wait for other nodes needed as we use AckedClusterStateUpdateTask
import org.apache.logging.log4j.Logger;
     * Using this three-step process ensures non-interference by other operations in case where
                parentTaskId
        // Check if index closing conflicts with any running snapshots
        ) {
                            .execute(
        final RoutingTable.Builder routingTable = RoutingTable.builder(currentState.routingTable());
        "index closed",
        final Set<String> closedIndices = new HashSet<>();
            if (currentState.blocks().hasIndexBlock(index.getName(), block.block)) {
                                                + blockedIndices.keySet().stream().map(Index::getName).collect(Collectors.joining(", "))
            final ClusterState state = clusterService.state();
                });
            final Index index,
import java.util.HashMap;
                    } else {
    class WaitForBlocksApplied extends ActionRunnable<Map<Index, AddBlockResult>> {
        this.threadPool = threadPool;
                                                    listener.onResponse(new AddIndexBlockResponse(acknowledged, acknowledged, indices));
                                                @Override
                logger.debug("add block {} to index {} succeeded", block.block, index);
                    return allocationService.reroute(updatedState, "indices opened [" + indicesAsString + "]");
                                                ) {
                Set<Index> snapshottingIndices = SnapshotsService.snapshottingIndices(currentState, singleton(index));
                    }
    public static ClusterBlock createUUIDBasedBlock(ClusterBlock clusterBlock) {
     *   (see {@link #finalizeBlock(ClusterState, Map, Map, APIBlock)}.
                                                                }
import org.opensearch.core.rest.RestStatus;
import org.opensearch.indices.IndicesService;
        }
                            )
                            new IllegalStateException(
                    if (oldState == newState) {
        false,
import org.opensearch.cluster.ClusterState;
    }
            clusterBlock.retryable(),
                }
        final Metadata.Builder metadata = Metadata.builder(currentState.metadata());
                    @Override
        this.indicesService = indicesService;
            );
        private final AddIndexBlockClusterStateUpdateRequest request;
        for (Index index : concreteIndices) {
                        result.getKey(),
                }
        @Override
                public ClusterState execute(final ClusterState currentState) {
            }
                                                + request.getBlock().name
            final IndexShardRoutingTable shardRoutingTable,
                                                        );
            );
                            .toArray(ShardResult.Failure[]::new);
            }
                    }
                assert state.blocks().hasIndexBlock(index.getName(), INDEX_CLOSED_BLOCK);
            } else {
    static ClusterState addIndexClosedBlocks(
                }
        if (concreteIndices == null || concreteIndices.length == 0) {
        protected void doRun() throws Exception {
            );
     * the index is considered ready to be closed.
                        AddBlockShardResult.Failure failure = new AddBlockShardResult.Failure(index.getName(), shardId, e);
            if (block.setting().get(indexMetadata.getSettings()) == false) {
            if (request.ackTimeout() != null) {
        return new ClusterBlock(
                return;
                indexBlock = createIndexClosingBlock();
            }
            final Set<ClusterBlock> clusterBlocks = currentState.blocks().indices().get(index.getName());
                            logger.debug(
     */
                closedIndices.add(index.getName());
    /**
                                Arrays.toString(indexNames)
    private void onlyOpenIndex(
                                            }
                                        verifyResults -> clusterService.submitStateUpdateTask(
                                                                            + "for enough shards to be started.",
        }
            clusterBlock.disableStatePersistence(),
                public void onResponse(ReplicationResponse replicationResponse) {
                    indexNames,
                                                }
import org.opensearch.indices.ShardLimitValidator;
import org.opensearch.action.admin.indices.close.CloseIndexClusterStateUpdateRequest;
import org.apache.logging.log4j.LogManager;
                }
            if (indexRoutingTable == null || indexMetadata.getState() == IndexMetadata.State.CLOSE) {
            final AtomicArray<AddBlockShardResult> results = new AtomicArray<>(shards.size());
        List<String> writeIndices = new ArrayList<>();
 * license agreements. See the NOTICE file distributed with
                onResponse.accept(new IndexResult(index));
            }
                public void onFailure(Exception e) {
        }
                final IndexMetadata indexMetadata = metadata.getSafe(index);
import org.apache.logging.log4j.message.ParameterizedMessage;
                        currentState,
                updatedIndexMetadata = metadataIndexUpgradeService.upgradeIndexMetadata(updatedIndexMetadata, minIndexCompatibilityVersion);
                    final ClusterState updatedState = openIndices(request.indices(), currentState);
import org.opensearch.core.index.shard.ShardId;
                        listener.onResponse(new OpenIndexClusterStateUpdateResponse(response.isAcknowledged(), shardsAcknowledged));
     * <p>
            final Map<Integer, IndexShardRoutingTable> shards = indexRoutingTable.getShards();
        clusterService.submitStateUpdateTask(
        // Check if index closing conflicts with any running restores
            UUIDs.randomBase64UUID(),
    public static final int INDEX_CLOSED_BLOCK_ID = 4;
                            new IllegalStateException(
                @Override
import org.opensearch.action.admin.indices.readonly.AddIndexBlockResponse.AddBlockShardResult;
     * - Second, shards are checked to have properly applied the UUID-based block.
            false,
            transportVerifyShardBeforeCloseAction.execute(shardRequest, new ActionListener<ReplicationResponse>() {
            }
import org.opensearch.cluster.ClusterStateUpdateTask;
import org.opensearch.cluster.routing.allocation.AllocationService;
import org.opensearch.cluster.routing.RoutingTable;
    }
        false,
 * specific language governing permissions and limitations
                        .settings(Settings.builder().put(indexMetadata.getSettings()).put(VERIFIED_BEFORE_CLOSE_SETTING.getKey(), true))
        }
                                                            },
        return ClusterState.builder(currentState).blocks(blocks).metadata(metadata).routingTable(routingTable.build()).build();
                assert currentBlock != null && currentBlock.equals(tempBlock) && currentBlock.id() == block.block.id();
    }
                metadata.put(
                                new WaitForClosedBlocksApplied(
                    if (countDown.countDown()) {
    }
 * software distributed under the License is distributed on an
                listener.onResponse(response);
            }
                    .settings(updatedSettings)
            if (indexMetadata.getState() != IndexMetadata.State.OPEN) {
import java.util.EnumSet;
        final Metadata.Builder metadata = Metadata.builder(currentState.metadata());
        List<String> writeIndices = new ArrayList<>();
        );
                                                @Override
                blocks.addIndexBlock(index.getName(), block.block);
                                                    final String source,
                        assert blockedIndices.isEmpty() == false : "List of blocked indices is empty but cluster state was changed";
                public void clusterStateProcessed(final String source, final ClusterState oldState, final ClusterState newState) {
     * - First, a temporary UUID-based block is added to the index
                @Override
                                                            shardsAcknowledged -> {
            }
     * @return the updated cluster state, as well as the (failed and successful) index-level results for adding the block
            }
                try {
import org.opensearch.core.index.Index;
                                                        currentState,
     * Adding blocks is done in three steps:
                        new IndexResult(
                writeIndices.add(index.getName());
            blockedIndices.put(index, indexBlock);
                                                    );
                                                    indices.addAll(closingResult.v2());
        );
        final Map<Index, ClusterBlock> blockedIndices,
 */
                metadata.put(updatedIndexMetadata, true);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                    continue;
                        request.getBlock()
        AllocationService allocationService,
                        results.setOnce(shardId, new AddBlockShardResult(shardId, failures));
                }
    ) {
        final RoutingTable.Builder routingTable = RoutingTable.builder(currentState.routingTable());
                            );
            final Set<ClusterBlock> clusterBlocks = currentState.blocks().indices().get(index.getName());
        Map<Index, AddBlockResult> blockingResults = new HashMap<>(verifyResult);
            blockedIndices
                blocks.addIndexBlock(index.getName(), INDEX_CLOSED_BLOCK);
                metadata.put(
        );
                                            "finalize-index-block-["
            final ActionListener<ReplicationResponse> listener
    private final AllocationService allocationService;
                        indexBlock = clusterBlock;
                final Settings.Builder updatedSettings = Settings.builder().put(indexMetadata.getSettings());
                    private void processIfFinished() {
import org.opensearch.common.settings.Setting;
    /**
     *   (see {@link #addIndexBlock(Index[], ClusterState, APIBlock)}.
            if (ia != null && ia.getParentDataStream() != null && ia.getParentDataStream().getWriteIndex().getIndex().equals(index)) {
     * @return Generates a {@link ClusterBlock} that blocks read and write operations on soon-to-be-closed indices. The
                String.join(",", indicesToOpen.stream().map(i -> (CharSequence) i.getIndex().toString())::iterator)
        if (indicesToAddBlock.isEmpty()) {
                                            new ClusterStateUpdateTask(Priority.URGENT) {
        for (Index index : concreteIndices) {
                                                    listener.onFailure(e);
        ) {
        }
import java.util.Set;
        }
                    private void processIfFinished() {
                            )
    /**
     * @param currentState The current cluster state
                        assert blockedIndices.isEmpty() : "List of blocked indices is not empty but cluster state wasn't changed";
                        results.setOnce(shardId, new ShardResult(shardId, new ShardResult.Failure[] { failure }));
        ThreadPool threadPool,
    ) {
        );
            blockedIndices.keySet().stream().map(Object::toString).collect(Collectors.toList())
            throw new IllegalArgumentException("Index name is required");
    );
        }, listener::onFailure));
            final ShardId shardId = shardRoutingTable.shardId();
            } catch (final IndexNotFoundException e) {
        for (IndexMetadata previousIndexMetadata : indicesToOpen) {
                        listener.onResponse(new AddIndexBlockResponse(true, false, Collections.emptyList()));
                    return tup.v1();
                @Override
     */
                final int shardId = shardRoutingTable.shardId().id();
import org.opensearch.common.collect.Tuple;
import java.util.SortedMap;
                        new IndexResult(
    public static boolean isIndexVerifiedBeforeClosed(final IndexMetadata indexMetadata) {
        final RoutingTable.Builder routingTable = RoutingTable.builder(currentState.routingTable());
                });
        ) {
    }
        );
        final Index[] concreteIndices = request.indices();
                logger.debug("index {} is already closed, ignoring", index);
                        results.setOnce(shardId, new AddBlockShardResult(shardId, new AddBlockShardResult.Failure[] { failure }));
            }
            if (shardRoutingTable.primaryShard() == null || shardRoutingTable.primaryShard().unassigned()) {
                            new IllegalStateException(
     */
                    public void innerOnResponse(final ReplicationResponse replicationResponse) {
            final Map<Index, ClusterBlock> blockedIndices,
                    request.ackTimeout(),
        return new ClusterBlock(
        final String indicesAsString = Arrays.toString(request.indices());
        }
                        }
        final APIBlock block
                public ClusterState execute(final ClusterState currentState) {
                    if (clusterBlock.id() == block.block.id()) {
                    continue;
    }
     * Step 1 - Start closing indices by adding a write block
            final CountDown countDown = new CountDown(blockedIndices.size());
                onResponse.accept(new IndexResult(index));
    public void closeIndices(final CloseIndexClusterStateUpdateRequest request, final ActionListener<CloseIndexResponse> listener) {
                if (snapshottingIndices.isEmpty() == false) {
                    continue;
                                                private final List<AddBlockResult> indices = new ArrayList<>();
                @Override
        }
                        break;
                    );
 *     http://www.apache.org/licenses/LICENSE-2.0
                if (restoringIndices.isEmpty() == false) {
                final IndexShardRoutingTable shardRoutingTable = shard;
                        )
                                )
        protected void doRun() throws Exception {
            ClusterState.builder(currentState).blocks(blocks).metadata(metadata).routingTable(routingTable.build()).build(),
        final Map<Index, ClusterBlock> blockedIndices,
                "closing indices {}",
import org.opensearch.core.tasks.TaskId;
        final Metadata.Builder metadata = Metadata.builder(currentState.metadata());
    private static final Logger logger = LogManager.getLogger(MetadataIndexStateService.class);
            super(listener);
                "Cannot close indices that are being snapshotted: "
            final CountDown countDown = new CountDown(shards.size());
import java.util.stream.Collectors;
        }
                String[] indexNames = Arrays.stream(request.indices()).map(Index::getName).toArray(String[]::new);
     */
                });
 * @opensearch.internal
                logger.debug("index {} is closed, no need to wait for shards, ignoring", index);
                if (acknowledged == false) {
        }
                        )
                                            new ClusterStateUpdateTask(Priority.URGENT) {
            final Map<Index, AddBlockResult> results = ConcurrentCollections.newConcurrentMap();
     * This step iterates over the indices previously blocked and sends a {@link TransportVerifyShardBeforeCloseAction} to each shard. If
import org.opensearch.action.admin.indices.close.TransportVerifyShardBeforeCloseAction;
                        new IndexResult(
                }
                public TimeValue timeout() {
            return Tuple.tuple(currentState, Collections.emptyMap());
                    transportVerifyShardBeforeCloseAction.execute(shardRequest, listener);
        ) {
                );
            if (indexMetadata.getState() != IndexMetadata.State.CLOSE) {
        final Set<Index> indicesToAddBlock = new HashSet<>();
        "index.verified_before_close",
                true,
        return ClusterState.builder(updatedState).routingTable(routingTable.build()).build();
                    continue;
        private WaitForBlocksApplied(
        false,
                                                        .map(result -> result.getIndex().getName())
import java.util.List;
            final IndexMetadata indexMetadata = metadata.getSafe(index);
        4,
            && VERIFIED_BEFORE_CLOSE_SETTING.exists(indexMetadata.getSettings())
                logger.debug("index {} has been blocked before closing and is now deleted, ignoring", index);
                                                                listener.onResponse(
     * @return a tuple of the updated cluster state, as well as the blocks that got added
 * The OpenSearch Contributors require contributions made to
                    );
import org.opensearch.action.admin.indices.readonly.TransportVerifyShardIndexBlockAction;
        for (Map.Entry<Index, IndexResult> result : verifyResult.entrySet()) {
import org.opensearch.common.util.concurrent.CountDown;
        );
                                                        activeShardsObserver.waitForActiveShards(
import org.opensearch.core.action.NotifyOnceListener;
                }
                effectivelyBlockedIndices.add(index.getName());
                logger.debug("index {} has been deleted since blocking it started, ignoring", index);
                "cannot add a block to the following data stream write indices ["
                            new IllegalStateException(
            ClusterBlock indexBlock = null;
            for (final IndexShardRoutingTable shard : shards.values()) {
        final Map<Index, ClusterBlock> blockedIndices,
            if (indexBlock == null) {
    static Tuple<ClusterState, Map<Index, ClusterBlock>> addIndexBlock(
     */
                    }
/*
     *
            final ClusterState state,
/**
                    if (oldState == newState) {
                    logger.debug("verification of shards before closing {} succeeded but index is already closed", index);
                                                @Override
        private void sendVerifyShardBlockRequest(
                                                    final boolean acknowledged = indices.stream().noneMatch(AddBlockResult::hasFailures);
        final ClusterState currentState
                    continue;
        logger.info(
            });
            }
                                                    assert verifyResults.size() == addBlockResult.v2().size();
     * Step 2 - Wait for indices to be ready for closing
        if (snapshottingIndices.isEmpty() == false) {
        final Version minIndexCompatibilityVersion = currentState.getNodes().getMaxNodeVersion().minimumIndexCompatibilityVersion();
                        processIfFinished();
                }
                                    request,
            new ClusterStateUpdateTask(Priority.URGENT) {
                @Override
        for (Index index : indices) {
     *   (see {@link WaitForBlocksApplied}).
            throw new SnapshotInProgressException(
        Set<Index> snapshottingIndices = SnapshotsService.snapshottingIndices(currentState, indicesToClose);
        private void waitForShardsReadyForClosing(
    ) {
            }
                assert closingBlock != null;
                if (currentState.blocks().hasIndexBlock(index.getName(), closingBlock) == false) {
        }
            if (blockedIndices == null || blockedIndices.isEmpty()) {
        this.activeShardsObserver = new ActiveShardsObserver(clusterService, threadPool);
                                                ) {
                                                            listener::onFailure
    private final TransportVerifyShardBeforeCloseAction transportVerifyShardBeforeCloseAction;
                        if (countDown.countDown()) {
import java.util.Map;
                        listener.onResponse(new CloseIndexResponse(true, false, Collections.emptyList()));
                            onResponse.accept(new AddBlockResult(index, results.toArray(new AddBlockShardResult[results.length()])));
            "moving to block " + clusterBlock.description(),
        }
                                                @Override
                parentTaskId
        this.shardLimitValidator = shardLimitValidator;
                final ReplicationResponse response = new ReplicationResponse();
        final List<IndexMetadata> indicesToOpen = new ArrayList<>();
                        result.getKey(),
        @Override
        final Index[] concreteIndices = request.indices();
        this.metadataIndexUpgradeService = metadataIndexUpgradeService;
/*
        private WaitForClosedBlocksApplied(
     * this action succeed then the shard is considered to be ready for closing. When all shards of a given index are ready for closing,
            final ClusterBlock clusterBlock,
     * should start to reject writing operations and we can proceed with step 2.
                }
                        listener.onResponse(unmodifiableMap(results));
                                                                );
                    @Override
                                                    Tuple<ClusterState, Collection<AddBlockResult>> addBlockResult = finalizeBlock(
    private final IndicesService indicesService;
                for (ClusterBlock clusterBlock : clusterBlocks) {
                                                    final ClusterState oldState,
        if (indicesToOpen.isEmpty()) {
            try {
                    },
        final OpenIndexClusterStateUpdateRequest request,
        assert clusterBlock.uuid() == null : "no UUID expected on source block";
import org.opensearch.common.inject.Inject;
import org.opensearch.OpenSearchException;
                                                @Override
                    final Tuple<ClusterState, Map<Index, ClusterBlock>> tup = addIndexBlock(
import static java.util.Collections.singleton;
                logger.debug("closing index {} succeeded", index);
                    shardsAcknowledged -> {
                listener.onResponse(new OpenIndexClusterStateUpdateResponse(false, false));
        this.clusterService = clusterService;
 * Unless required by applicable law or agreed to in writing,
                                                    );
    public static final ClusterBlock INDEX_CLOSED_BLOCK = new ClusterBlock(
                            )
        }
                        listener.onResponse(unmodifiableMap(results));
                throw new IllegalArgumentException("Cannot wait for closed blocks to be applied, list of blocked indices is empty or null");
            final Index index,
    }
        Setting.Property.PrivateIndex
    ) {
                                                                // (see ShardsAcknowledgedResponse constructor)
                    indicesService.verifyIndexMetadata(updatedIndexMetadata, updatedIndexMetadata);
    ClusterState openIndices(final Index[] indices, final ClusterState currentState) {
                @Override
 * this work for additional information regarding copyright
     * @opensearch.metadata
            "add-block-index-to-close " + Arrays.toString(concreteIndices),
 *
                closingBlock,
import org.opensearch.cluster.AckedClusterStateUpdateTask;
        }
import java.util.Collections;
        final ClusterBlocks.Builder blocks = ClusterBlocks.builder().blocks(currentState.blocks());
     */
        }
        private final CloseIndexClusterStateUpdateRequest request;
        for (IndexMetadata indexMetadata : indicesToOpen) {
            }
                );
    private final ClusterService clusterService;
            final TransportVerifyShardIndexBlockAction.ShardRequest shardRequest = new TransportVerifyShardIndexBlockAction.ShardRequest(
        this.transportVerifyShardBeforeCloseAction = transportVerifyShardBeforeCloseAction;
                                                        request.getBlock()
                assert tempBlock.uuid() != null;
    }
            blockedIndices.forEach((index, block) -> {
            final ClusterState state = clusterService.state();
                        result
import org.opensearch.common.UUIDs;
                                "verification of shards before closing " + index + " succeeded but block has been removed in the meantime"
                indicesToAddBlock.add(index);
                private Map<Index, ClusterBlock> blockedIndices;
                    if (countDown.countDown()) {
     * block (or reuses an existing one) to every index to close in the cluster state. After the cluster state is published, the shards
            }
            "add-index-block-[" + request.getBlock().name + "]-" + Arrays.toString(concreteIndices),
        final Index[] indices,
     * cluster block is generated with the id value equals to {@link #INDEX_CLOSED_BLOCK_ID} and a unique UUID.
                                                    final ClusterState newState
     */
                    }
        ClusterState updatedState = ClusterState.builder(currentState).metadata(metadata).blocks(blocks).build();
                final ClusterBlock closingBlock = blockedIndices.get(index);
 */
    private final ShardLimitValidator shardLimitValidator;
                                        ),
                if (currentBlock != null && currentBlock.equals(block.block)) {
            final Index index = result.getKey();
            final ActionListener<Map<Index, IndexResult>> listener
        final ClusterState currentState,
import org.opensearch.core.action.ActionListener;
     * Updates the cluster state for the given indices with the given index block,
            final ShardId shardId = shardRoutingTable.shardId();
            final ActionListener<ReplicationResponse> listener
            final IndexMetadata indexMetadata = currentState.metadata().getIndexSafe(index);
                }
    }
import java.util.function.Consumer;
        final ClusterState currentState,
    static Tuple<ClusterState, Collection<AddBlockResult>> finalizeBlock(
        );
        for (Index index : indices) {
                                                    final String[] waitForIndices = indices.stream()
            final ClusterBlock closingBlock,
                    logger.debug("verification of shards before closing {} succeeded but index is being snapshot in the meantime", index);
        }
import org.opensearch.common.Priority;
            if (indexMetadata == null) {
                sendVerifyShardBeforeCloseRequest(shardRoutingTable, closingBlock, new NotifyOnceListener<ReplicationResponse>() {
    }
    }
                    continue;
                                    blockedIndices,
            INDEX_CLOSED_BLOCK_ID,
            UUIDs.randomBase64UUID(),
                private final Map<Index, ClusterBlock> blockedIndices = new HashMap<>();
                                                                    logger.debug(
        clusterService.submitStateUpdateTask(
                    public void innerOnFailure(final Exception e) {
                indicesToOpen.add(indexMetadata);
                                                        .filter(result -> newState.routingTable().hasIndex(result.getIndex()))
     */
                                                                        "[{}] indices closed, but the operation timed out while waiting "
            }
                }
                                                                // value
                    }
        final Map<Index, IndexResult> verifyResult
                    closingResults.put(
                logger.debug("index {} already has block {}, ignoring", index, block.block);
                                new WaitForBlocksApplied(
                        new AddBlockResult(
            final CountDown countDown = new CountDown(shards.size());
                    + ". Try again after snapshot finishes or cancel the currently running snapshot."
    private final MetadataIndexUpgradeService metadataIndexUpgradeService;
            transportVerifyShardIndexBlockAction.execute(shardRequest, listener);
                final IndexShardRoutingTable shardRoutingTable = shard;
        }
        TransportVerifyShardIndexBlockAction transportVerifyShardIndexBlockAction
import org.opensearch.common.settings.Settings;
            final TaskId parentTaskId = new TaskId(clusterService.localNode().getId(), request.taskId());
        final Metadata.Builder metadata = Metadata.builder(currentState.metadata());
                block,
     * @param currentState the cluster state to update
 * KIND, either express or implied.  See the License for the
            blockedIndices.forEach((index, block) -> {
        private void waitForShardsReady(
            final Consumer<AddBlockResult> onResponse
                                )
                                    )
 * the Apache License, Version 2.0 (the "License"); you may
            final boolean acknowledged = result.getValue().hasFailures() == false;
                                                public ClusterState execute(final ClusterState currentState) throws Exception {
                }
                    request.waitForActiveShards(),
                return;
        final ClusterBlocks.Builder blocks = ClusterBlocks.builder().blocks(currentState.blocks());
        }
            }
                                                }
                                                    } else {
                return;
            }
            final TaskId parentTaskId = new TaskId(clusterService.localNode().getId(), request.taskId());
            });
        final ActionListener<OpenIndexClusterStateUpdateResponse> listener
                if (indexMetadata.getState() == IndexMetadata.State.CLOSE) {
                    // we should report error in this case as the index can be left as open.
                                                                // acknowledged maybe be false but some indices may have been correctly
                    } else {
                        threadPool.executor(ThreadPool.Names.MANAGEMENT)
import org.opensearch.core.common.Strings;
            if (response.isAcknowledged()) {
     * to be terminated and finally closes the indices by moving their state to CLOSE.
                if (acknowledged == false) {
                }
            ClusterBlock indexBlock = null;
                            .execute(
     * @param verifyResult the index-level results for adding the block
import org.opensearch.action.admin.indices.open.OpenIndexClusterStateUpdateRequest;
package org.opensearch.cluster.metadata;
                public ClusterState execute(final ClusterState currentState) {
                        if (countDown.countDown()) {
            false,
        this.allocationService = allocationService;
                                                }
                throw new IllegalArgumentException("Cannot wait for blocks to be applied, list of blocked indices is empty or null");
                        AddBlockShardResult.Failure[] failures = Arrays.stream(replicationResponse.getShardInfo().getFailures())
            }
            final IndexMetadata indexMetadata = metadata.getSafe(index);
            && VERIFIED_BEFORE_CLOSE_SETTING.get(indexMetadata.getSettings());
                routingTable.addAsFromOpenToClose(metadata.getSafe(index));
                }
                        assert blockedIndices.isEmpty() : "List of blocked indices is not empty but cluster state wasn't changed";
            if (request.ackTimeout() != null) {
            closingResults.values()
                            onResponse.accept(new IndexResult(index, results.toArray(new ShardResult[results.length()])));
                // The index might be closed because we couldn't import it due to old incompatible version
                    + Strings.collectionToCommaDelimitedString(writeIndices)
            throw new IllegalArgumentException("Index name is required");
                routingTable.addAsFromCloseToOpen(updatedState.metadata().getIndexSafe(previousIndexMetadata.getIndex()));
            }
import org.opensearch.Version;
        );
                protected ClusterStateUpdateResponse newResponse(boolean acknowledged) {
 */
                    .build();
                // We need to check that this index can be upgraded to the current version
        ) {
            blocks.removeIndexBlockWithId(index.getName(), INDEX_CLOSED_BLOCK_ID);
                final ReplicationResponse response = new ReplicationResponse();
            final CloseIndexClusterStateUpdateRequest request,
 * SPDX-License-Identifier: Apache-2.0
                shardId,
     * and also returns the updated indices (and their blocks) in a map.
                                                        .toArray(String[]::new);
                            result.getKey(),
        SortedMap<String, IndexAbstraction> lookup = clusterService.state().metadata().getIndicesLookup();
public class MetadataIndexStateService {
                logger.debug("index {} has since been deleted, ignoring", index);
                    + snapshottingIndices
                                                private final List<IndexResult> indices = new ArrayList<>();
    ) {
                                                    final boolean acknowledged = indices.stream().noneMatch(IndexResult::hasFailures);
        this.transportVerifyShardIndexBlockAction = transportVerifyShardIndexBlockAction;
import org.opensearch.index.IndexNotFoundException;
import org.opensearch.action.admin.indices.readonly.AddIndexBlockClusterStateUpdateRequest;
        }
            )
                                                        verifyResults,
            // Always removes index closed blocks (note: this can fail on-going close index actions)
            clusterBlock.isAllowReleaseResources(),
                    public void innerOnResponse(final ReplicationResponse replicationResponse) {
                    }
    public static final Setting<Boolean> VERIFIED_BEFORE_CLOSE_SETTING = Setting.boolSetting(
                    logger.debug(
                final int shardId = shardRoutingTable.shardId().id();
import java.util.ArrayList;
            clusterBlock.levels()
                @Override
        }
                        processIfFinished();
                        }
            ClusterState.builder(currentState).blocks(blocks).metadata(metadata).routingTable(routingTable.build()).build(),
        Setting.Property.IndexScope,
                    logger.debug("verification of shards before blocking {} succeeded but block has been removed in the meantime", index);
                                                                // we maintain a kind of coherency by overriding the shardsAcknowledged
        false,
                                    ActionListener.wrap(
        if (restoringIndices.isEmpty() == false) {
                Set<Index> restoringIndices = RestoreService.restoringIndices(currentState, singleton(index));
        if (request.indices() == null || request.indices().length == 0) {
                public void onFailure(final String source, final Exception e) {
        final RoutingTable.Builder routingTable = RoutingTable.builder(updatedState.routingTable());
import org.opensearch.snapshots.SnapshotsService;
        final Map<Index, AddBlockResult> verifyResult,
                writeIndices.add(index.getName());
            new AckedClusterStateUpdateTask<ClusterStateUpdateResponse>(Priority.URGENT, request, listener) {
 * this file be licensed under the Apache-2.0 license or a
                                                    return allocationService.reroute(closingResult.v1(), "indices closed");
                    + "]"
    private final ThreadPool threadPool;
        logger.info("completed closing of indices {}", closedIndices);
                                    ActionListener.wrap(
                final IndexMetadata indexMetadata = metadata.getSafe(index);
    public static ClusterBlock createIndexClosingBlock() {
    ) {
    }
                        threadPool.executor(ThreadPool.Names.MANAGEMENT)
                    blockingResults.put(
import org.opensearch.action.admin.indices.readonly.AddIndexBlockResponse;
                indicesToOpen.add(indexMetadata);
            final IndexRoutingTable indexRoutingTable = state.routingTable().index(index);
                // Create a new UUID-based block
     * {@link TransportVerifyShardIndexBlockAction}.
                });
        }
                                        ),
            }
