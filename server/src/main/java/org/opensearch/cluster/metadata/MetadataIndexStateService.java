    class WaitForBlocksApplied extends ActionRunnable<Map<Index, AddBlockResult>> {
    private final AllocationService allocationService;  
                onResponse.accept(new IndexResult(index));  
     */
        private final Map<Index, ClusterBlock> blockedIndices;
        final Index[] concreteIndices = request.indices();
        Set<Index> restoringIndices = RestoreService.restoringIndices(currentState, indicesToClose);
                    results.put(index, response);
 * compatible open source license.
import org.opensearch.snapshots.SnapshotsService;
        }
            if (indexMetadata.getState() != IndexMetadata.State.OPEN) {  
import java.util.Collection;
            new ClusterStateUpdateTask(Priority.URGENT) {
                });
import org.opensearch.cluster.service.ClusterService;  
import org.opensearch.action.admin.indices.readonly.TransportVerifyShardIndexBlockAction;
        final Map<Index, AddBlockResult> verifyResult,
                        new IndexResult(  
    static Tuple<ClusterState, Collection<IndexResult>> closeRoutingTable(
            }  
            if (blockedIndices == null || blockedIndices.isEmpty()) {
package org.opensearch.cluster.metadata;
                    @Override
                }
                return;  
            final TransportVerifyShardBeforeCloseAction.ShardRequest shardRequest = new TransportVerifyShardBeforeCloseAction.ShardRequest(
            }
import java.util.HashMap;
        }  
 *  
            final IndexMetadata indexMetadata = metadata.getSafe(index);  
                                                                // closed, so
/*
    class WaitForClosedBlocksApplied extends ActionRunnable<Map<Index, IndexResult>> {  
            }
    }  
import org.opensearch.core.rest.RestStatus;
/**
                    }
                    logger.debug("verification of shards before blocking {} succeeded but block has been removed in the meantime", index);
                }  
                "cannot close the following data stream write indices [" + Strings.collectionToCommaDelimitedString(writeIndices) + "]"
                    continue;
                parentTaskId
                            result.getKey(),
        @Override  
            final ClusterBlock closingBlock,
            ClusterState.builder(currentState).blocks(blocks).metadata(metadata).routingTable(routingTable.build()).build(),  
            } else {
                blocks.removeIndexBlockWithId(index.getName(), INDEX_CLOSED_BLOCK_ID);
        return Tuple.tuple(  
                            )  
import org.opensearch.core.index.Index;
        ) {
            }  
                indexBlock = createIndexClosingBlock();
    private final TransportVerifyShardBeforeCloseAction transportVerifyShardBeforeCloseAction;
     * @param block The type of block to add
        SortedMap<String, IndexAbstraction> lookup = clusterService.state().metadata().getIndicesLookup();
                }  
                        results.setOnce(shardId, new AddBlockShardResult(shardId, failures));
            "moving to block " + clusterBlock.description(),
            final Index index,  
import org.opensearch.common.util.concurrent.CountDown;
                    continue;
            UUIDs.randomBase64UUID(),  
        }  
            final IndexMetadata indexMetadata = state.metadata().index(index);  
                                                + "]-["
            }  
        ) {
                    transportVerifyShardBeforeCloseAction.execute(shardRequest, listener);  
                                                        currentState,
                indicesToAddBlock.add(index);
            }  
                            new IllegalStateException(
                            result.getKey(),
                if (snapshottingIndices.isEmpty() == false) {  
                if (indexMetadata.getState() == IndexMetadata.State.CLOSE) {
                                        verifyResults -> clusterService.submitStateUpdateTask(
        final Map<Index, ClusterBlock> blockedIndices,
            final boolean acknowledged = result.getValue().hasFailures() == false;
                    blockedIndices = tup.v2();
            final IndexMetadata indexMetadata = currentState.metadata().getIndexSafe(index);
                }
                sendVerifyShardBlockRequest(shardRoutingTable, clusterBlock, new NotifyOnceListener<ReplicationResponse>() {
                                                    listener.onFailure(e);  
/*  
                                                    final String source,  
        final Map<Index, ClusterBlock> blockedIndices,
                // We need to check that this index can be upgraded to the current version
import org.opensearch.cluster.routing.IndexShardRoutingTable;  
        return Tuple.tuple(
            final ClusterState state = clusterService.state();  
                    + ". Try again after snapshot finishes or cancel the currently running snapshot."
                    return addIndexClosedBlocks(concreteIndices, blockedIndices, currentState);
                assert currentBlock != null && currentBlock.equals(tempBlock) && currentBlock.id() == block.block.id();
            if (indexMetadata == null) {  
                                                    final boolean acknowledged = indices.stream().noneMatch(AddBlockResult::hasFailures);
 * Licensed to Elasticsearch under one or more contributor  
                            .map(f -> new AddBlockShardResult.Failure(f.index(), f.shardId(), f.getCause(), f.nodeId()))
                            );
                                                        blockedIndices,
    private final ClusterService clusterService;
        final List<IndexMetadata> indicesToOpen = new ArrayList<>();
            ClusterState.builder(currentState).blocks(blocks).metadata(metadata).routingTable(routingTable.build()).build(),
            final ShardId shardId = shardRoutingTable.shardId();
                            new IllegalStateException(
        // Check if index closing conflicts with any running restores
    public MetadataIndexStateService(
     * Adding blocks is done in three steps:  
import org.opensearch.snapshots.SnapshotInProgressException;
                                                }  
 * KIND, either express or implied.  See the License for the
 * The OpenSearch Contributors require contributions made to  
                                                    }
                                                                boolean shardsAcked = acknowledged ? shardsAcknowledged : false;
    private final ThreadPool threadPool;
        );
                    private void processIfFinished() {
                        results.setOnce(shardId, new ShardResult(shardId, new ShardResult.Failure[] { failure }));
     * block (or reuses an existing one) to every index to close in the cluster state. After the cluster state is published, the shards  
    ) {  
    ) {
        Map<Index, AddBlockResult> blockingResults = new HashMap<>(verifyResult);
     * @param currentState the cluster state to update
                                        listener::onFailure
     * and also returns the updated indices (and their blocks) in a map.
                if (currentBlock != null && currentBlock.equals(block.block)) {
                waitForShardsReady(index, block, state, response -> {
                updatedSettings.remove(VERIFIED_BEFORE_CLOSE_SETTING.getKey());
            transportVerifyShardBeforeCloseAction.execute(shardRequest, new ActionListener<ReplicationResponse>() {
            return Tuple.tuple(currentState, Collections.emptyMap());
                                                @Override  
                    + Strings.collectionToCommaDelimitedString(writeIndices)
        clusterService.submitStateUpdateTask(
                        listener.onResponse(new AddIndexBlockResponse(true, false, Collections.emptyList()));
            );  
                public ClusterState execute(final ClusterState currentState) {
    ) {
     * @return a tuple of the updated cluster state, as well as the blocks that got added
    private final IndicesService indicesService;
                        if (countDown.countDown()) {  
                response.setShardInfo(new ReplicationResponse.ShardInfo(shardRoutingTable.size(), shardRoutingTable.size()));
                assert closingBlock != null;
                    listener.onFailure(e);
            throw new SnapshotInProgressException(
        for (Map.Entry<Index, IndexResult> result : verifyResult.entrySet()) {
    private final ActiveShardsObserver activeShardsObserver;
    static Tuple<ClusterState, Map<Index, ClusterBlock>> addIndexBlock(
                if (acknowledged == false) {
        }
                                                    indices.addAll(addBlockResult.v2());
import org.opensearch.indices.ShardLimitValidator;
            closingResults.values()
                                                    if (waitForIndices.length > 0) {
                if (restoringIndices.isEmpty() == false) {
                                        ),  
            "add-block-index-to-close " + Arrays.toString(concreteIndices),  
            this.blockedIndices = blockedIndices;
                    indexNames,
import org.opensearch.core.common.Strings;
                assert currentState.blocks().hasIndexBlock(index.getName(), INDEX_CLOSED_BLOCK);
                        threadPool.executor(ThreadPool.Names.MANAGEMENT)
    }
import org.opensearch.common.collect.Tuple;  
                    continue;  
                        result.getKey(),
            final IndexRoutingTable indexRoutingTable = state.routingTable().index(index);  
import org.opensearch.cluster.routing.RoutingTable;
        ClusterService clusterService,
    /**
        false,  
        final Set<String> closedIndices = new HashSet<>();  
        protected void doRun() throws Exception {  
import java.util.ArrayList;
                logger.debug("index {} is closed, no need to wait for shards, ignoring", index);
                @Override  
                    indicesService.verifyIndexMetadata(updatedIndexMetadata, updatedIndexMetadata);
    // Create UUID based block based on non-UUID one
        final OpenIndexClusterStateUpdateRequest request,
                @Override
                onResponse.accept(new IndexResult(index));
        final RoutingTable.Builder routingTable = RoutingTable.builder(currentState.routingTable());
            for (final IndexShardRoutingTable shard : shards.values()) {
                throw new IllegalArgumentException("Cannot wait for blocks to be applied, list of blocked indices is empty or null");
                assert state.blocks().hasIndexBlock(index.getName(), INDEX_CLOSED_BLOCK);
                                                        verifyResults  
                    // we should report error in this case as the index can be left as open.  
                }
                String.join(",", indicesToOpen.stream().map(i -> (CharSequence) i.getIndex().toString())::iterator)
                    logger.debug(
        }
                    continue;
                                                                // (see ShardsAcknowledgedResponse constructor)
                        indexBlock = clusterBlock;  
                                                public void clusterStateProcessed(
        }
            // Always removes index closed blocks (note: this can fail on-going close index actions)  
     * this action succeed then the shard is considered to be ready for closing. When all shards of a given index are ready for closing,
import org.opensearch.common.Priority;
        private final Map<Index, ClusterBlock> blockedIndices;
            blockedIndices.forEach((index, block) -> {
    }
                                    request,  
 * ownership. Elasticsearch licenses this file to you under  
                                )
                    + "]"  
        onlyOpenIndex(request, ActionListener.wrap(response -> {
        if (restoringIndices.isEmpty() == false) {  
            blocks.addIndexBlock(index.getName(), indexBlock);
import org.opensearch.OpenSearchException;
                        results.setOnce(shardId, new AddBlockShardResult(shardId, new AddBlockShardResult.Failure[] { failure }));
        }
        "index closed",  
                            )
                                                public ClusterState execute(final ClusterState currentState) throws Exception {
    private static final Logger logger = LogManager.getLogger(MetadataIndexStateService.class);
            UUIDs.randomBase64UUID(),  
        4,
                return;
        this.transportVerifyShardBeforeCloseAction = transportVerifyShardBeforeCloseAction;  
                                                ) {  
                        ShardResult.Failure[] failures = Arrays.stream(replicationResponse.getShardInfo().getFailures())  
                        indexBlock = clusterBlock;  
        for (Index index : indices) {
     *  
import org.opensearch.cluster.routing.IndexRoutingTable;
            final Consumer<AddBlockResult> onResponse  
        shardLimitValidator.validateShardLimit(currentState, indices);  
                                                                // value  
            final Map<Index, AddBlockResult> results = ConcurrentCollections.newConcurrentMap();
     * This step builds the list of indices to close (the ones explicitly requested that are not in CLOSE state) and adds a unique cluster
        protected void doRun() throws Exception {
            }
                        listener.onResponse(new OpenIndexClusterStateUpdateResponse(response.isAcknowledged(), shardsAcknowledged));  
import org.apache.logging.log4j.LogManager;
    public static final int INDEX_CLOSED_BLOCK_ID = 4;  
                logger.debug("index {} is already closed, ignoring", index);
                                                + request.getBlock().name  
            EnumSet.of(ClusterBlockLevel.WRITE)  
                    }
                routingTable.addAsFromOpenToClose(metadata.getSafe(index));  
import org.opensearch.common.settings.Setting;
                assert tempBlock != null;
import org.opensearch.action.admin.indices.close.CloseIndexClusterStateUpdateRequest;
                    results.put(index, response);  
                        assert blockedIndices.isEmpty() : "List of blocked indices is not empty but cluster state wasn't changed";  
                block,
                                                        );
        ShardLimitValidator shardLimitValidator,  
        final ActionListener<ClusterStateUpdateResponse> listener  
        final RoutingTable.Builder routingTable = RoutingTable.builder(updatedState.routingTable());  
import org.opensearch.core.action.NotifyOnceListener;  
                public void onFailure(Exception e) {
        }
                }
        // Check if index closing conflicts with any running snapshots
                IndexMetadata updatedIndexMetadata = IndexMetadata.builder(indexMetadata)
    public static final Setting<Boolean> VERIFIED_BEFORE_CLOSE_SETTING = Setting.boolSetting(
                    final Tuple<ClusterState, Map<Index, ClusterBlock>> tup = addIndexBlock(  
            final ActionListener<ReplicationResponse> listener
                return;
                            .execute(
        this.activeShardsObserver = new ActiveShardsObserver(clusterService, threadPool);
                public TimeValue timeout() {
    public static final ClusterBlock INDEX_CLOSED_BLOCK = new ClusterBlock(
            }
                                                public void onFailure(final String source, final Exception e) {
                        threadPool.executor(ThreadPool.Names.MANAGEMENT)
            ClusterBlock indexBlock = null;  
            new ClusterStateUpdateTask(Priority.URGENT) {  
import org.opensearch.action.admin.indices.readonly.AddIndexBlockResponse;
            if (ia != null && ia.getParentDataStream() != null && ia.getParentDataStream().getWriteIndex().getIndex().equals(index)) {
                                                        currentState,
                                                    final ClusterState oldState,
        this.clusterService = clusterService;  
                                "verification of shards before closing " + index + " succeeded but index is being snapshot in the meantime"  
     */
        }, listener::onFailure));
                        .settings(Settings.builder().put(indexMetadata.getSettings()).put(VERIFIED_BEFORE_CLOSE_SETTING.getKey(), true))
            blockedIndices.put(index, indexBlock);
            throw new IllegalArgumentException("Cannot close indices that are being restored: " + restoringIndices);
import org.opensearch.Version;
            false,
                routingTable.addAsFromCloseToOpen(updatedState.metadata().getIndexSafe(previousIndexMetadata.getIndex()));  
    /**
                    listener.onFailure(e);
                                                    listener.onResponse(new AddIndexBlockResponse(acknowledged, acknowledged, indices));  
            }
        Map<Index, IndexResult> closingResults = new HashMap<>(verifyResult);
 * license agreements. See the NOTICE file distributed with
                listener.onResponse(response);  
}  
import org.opensearch.common.settings.Settings;  
                });
            return currentState;
        final Metadata.Builder metadata = Metadata.builder(currentState.metadata());
     * Closing indices is a 3 steps process: it first adds a write block to every indices to close, then waits for the operations on shards
            } else {  
                        result.getKey(),
                        processIfFinished();
                                                public void onFailure(final String source, final Exception e) {  
                    logger.debug("verification of shards before closing {} succeeded but index is being snapshot in the meantime", index);
                closingBlock,  
                        }
        final Metadata.Builder metadata = Metadata.builder(currentState.metadata());  
            final ActionListener<Map<Index, IndexResult>> listener
                private final Map<Index, ClusterBlock> blockedIndices = new HashMap<>();  
                                                @Override
                        if (countDown.countDown()) {
        if (writeIndices.size() > 0) {
 */  
        final ClusterState currentState,  
    ClusterState openIndices(final Index[] indices, final ClusterState currentState) {
                        results.setOnce(shardId, new ShardResult(shardId, failures));  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            if (request.ackTimeout() != null) {
            clusterBlock.levels()  
                }  
                metadata.put(
    public void closeIndices(final CloseIndexClusterStateUpdateRequest request, final ActionListener<CloseIndexResponse> listener) {
                );
                                                }
                public TimeValue timeout() {
                                                            request.waitForActiveShards(),
        if (indicesToAddBlock.isEmpty()) {  
                final Settings.Builder updatedSettings = Settings.builder().put(indexMetadata.getSettings());
    }
import org.opensearch.common.UUIDs;
                return;
                    listener::onFailure
                }  
        if (request.indices() == null || request.indices().length == 0) {
            final boolean acknowledged = result.getValue().hasFailures() == false;
                                "verification of shards before closing " + index + " succeeded but index is being restored in the meantime"
            final TaskId parentTaskId = new TaskId(clusterService.localNode().getId(), request.taskId());  
     * the index is considered ready to be closed.
                final Settings updatedSettings = Settings.builder().put(indexMetadata.getSettings()).put(block.settingName(), true).build();  
    }  
                    @Override
                        break;
                });
                if (currentState.blocks().hasIndexBlock(index.getName(), closingBlock) == false) {  
                        // Reuse the existing index closed block
        return indexMetadata.getState() == IndexMetadata.State.CLOSE
        private void sendVerifyShardBeforeCloseRequest(
                assert tempBlock.uuid() != null;
        clusterService.submitStateUpdateTask(
        return ClusterState.builder(currentState).blocks(blocks).metadata(metadata).routingTable(routingTable.build()).build();
                }  
        logger.info("completed closing of indices {}", closedIndices);
            );  
     * @param indices The indices to add blocks to if needed
            }  
            if (indexMetadata.getState() != IndexMetadata.State.CLOSE) {
                    IndexMetadata.builder(indexMetadata).settings(updatedSettings).settingsVersion(indexMetadata.getSettingsVersion() + 1)  
                    public void innerOnFailure(final Exception e) {  
                            .map(f -> new ShardResult.Failure(f.index(), f.shardId(), f.getCause(), f.nodeId()))
                    if (clusterBlock.id() == INDEX_CLOSED_BLOCK_ID) {
                                                                            + "for enough shards to be started.",
            final ClusterState state,  
     * Using this three-step process ensures non-interference by other operations in case where
                                                }  
                                                    Tuple<ClusterState, Collection<IndexResult>> closingResult = closeRoutingTable(  
            }
        final String indicesAsString = Arrays.toString(request.indices());  
                                                        .filter(result -> newState.routingTable().hasIndex(result.getIndex()))
        TransportVerifyShardIndexBlockAction transportVerifyShardIndexBlockAction  
        ) {  
        false,
import org.opensearch.cluster.ClusterStateUpdateTask;
                    } else {  
                @Override
        this.metadataIndexUpgradeService = metadataIndexUpgradeService;
                }  
                final int shardId = shardRoutingTable.shardId().id();
                        index,
                        concreteIndices,
     * <p>  
                writeIndices.add(index.getName());
 *
 * @opensearch.internal
                waitForShardsReadyForClosing(index, block, state, response -> {  
            ClusterBlock indexBlock = null;  
                                    blockedIndices,
            final IndexShardRoutingTable shardRoutingTable,
import org.opensearch.action.admin.indices.close.CloseIndexResponse;
        for (Index index : indicesToAddBlock) {
                            .execute(  
                public void onFailure(final String source, final Exception e) {
            }  
        assert clusterBlock.uuid() == null : "no UUID expected on source block";  
            "adding block {} to indices {}",  
            throw new IllegalArgumentException(  
                        }
     * @param blockedIndices the indices and their temporary UUID-based blocks to convert  
                    return new ClusterStateUpdateResponse(acknowledged);  
                    logger.debug("verification of shards before closing {} succeeded but index is already closed", index);  
        final ClusterState currentState,  
                                                                // we maintain a kind of coherency by overriding the shardsAcknowledged
                listener.onResponse(response);
                    return tup.v1();  
import org.opensearch.action.admin.indices.readonly.AddIndexBlockResponse.AddBlockResult;  
    );  
            blocks.removeIndexBlockWithId(index.getName(), INDEX_CLOSED_BLOCK_ID);
        "index.verified_before_close",
        }
                if (currentBlock == null || currentBlock.equals(tempBlock) == false) {
            final CountDown countDown = new CountDown(blockedIndices.size());  
import java.util.Collections;
    ) {
            // update index settings as well to match the block  
                                                public void clusterStateProcessed(
                            onResponse.accept(new IndexResult(index, results.toArray(new ShardResult[results.length()])));
                                                                        Arrays.toString(waitForIndices)  
            }  
        return new ClusterBlock(
                                                    final ClusterState oldState,  
            }  
            this.request = request;  
                                                                );
            final Set<ClusterBlock> clusterBlocks = currentState.blocks().indices().get(index.getName());
        ) {  
                                                + blockedIndices.keySet().stream().map(Index::getName).collect(Collectors.joining(", "))
                                                            request.ackTimeout(),  
import java.util.stream.Collectors;
    private final ShardLimitValidator shardLimitValidator;  
            final AtomicArray<ShardResult> results = new AtomicArray<>(shards.size());  
            );
                for (ClusterBlock clusterBlock : clusterBlocks) {  
            final IndexMetadata indexMetadata = state.metadata().index(index);
            }  
                                                            },  
        private WaitForBlocksApplied(
    }
            } else if (currentState.blocks().hasIndexBlockWithId(index.getName(), INDEX_CLOSED_BLOCK_ID)) {
                                            "close-indices",  
                writeIndices.add(index.getName());
    ) {
import org.opensearch.core.action.ActionListener;
import org.opensearch.action.admin.indices.open.OpenIndexClusterStateUpdateRequest;  
     * Helper class that coordinates with shards to ensure that blocks have been properly applied to all shards using  
import org.opensearch.common.inject.Inject;
                    );  
        }
                    logger.debug("verification of shards before closing {} succeeded but block has been removed in the meantime", index);
                    if (clusterBlock.id() == block.block.id()) {
            blockedIndices  
        final Map<Index, ClusterBlock> blockedIndices = new HashMap<>();  
import org.opensearch.cluster.block.ClusterBlockLevel;
            false,
     * - Second, shards are checked to have properly applied the UUID-based block.  
            }
            final IndexShardRoutingTable shardRoutingTable,  
import org.opensearch.cluster.ClusterState;  
        }
    /**  
import org.opensearch.action.admin.indices.close.TransportVerifyShardBeforeCloseAction;
                    .build();
import org.opensearch.action.support.ActiveShardsObserver;  
                                                    Tuple<ClusterState, Collection<AddBlockResult>> addBlockResult = finalizeBlock(  
/*  
 * Service responsible for submitting open/close index requests as well as for adding index blocks
                    blockingResults.put(
        final ClusterBlocks.Builder blocks = ClusterBlocks.builder().blocks(currentState.blocks());
import org.opensearch.index.IndexNotFoundException;  
public class MetadataIndexStateService {  
    );  
 * this file be licensed under the Apache-2.0 license or a
     *   (see {@link #addIndexBlock(Index[], ClusterState, APIBlock)}.
    public static ClusterBlock createUUIDBasedBlock(ClusterBlock clusterBlock) {
            if (indexMetadata.getState() != IndexMetadata.State.OPEN) {
            }
                    } else {
                                                @Override
            }
    static Tuple<ClusterState, Collection<AddBlockResult>> finalizeBlock(
                        assert blockedIndices.isEmpty() : "List of blocked indices is not empty but cluster state wasn't changed";
    public static boolean isIndexVerifiedBeforeClosed(final IndexMetadata indexMetadata) {
            final CountDown countDown = new CountDown(blockedIndices.size());
     * should start to reject writing operations and we can proceed with step 2.
                                                }
        final Metadata.Builder metadata = Metadata.builder(currentState.metadata());  
                indicesToOpen.add(indexMetadata);
import org.apache.logging.log4j.Logger;
    private final MetadataIndexUpgradeService metadataIndexUpgradeService;
                        if (shardsAcknowledged == false) {  
                        break;
    public void addIndexBlock(AddIndexBlockClusterStateUpdateRequest request, ActionListener<AddIndexBlockResponse> listener) {
            RestStatus.FORBIDDEN,
                            );  
import java.util.SortedMap;  
            ClusterState.builder(currentState).blocks(blocks).metadata(metadata).routingTable(routingTable.build()).build(),
            final IndexMetadata indexMetadata = metadata.getSafe(index);
            super(listener);
                        }  
    static ClusterState addIndexClosedBlocks(  
     * <p>
        }  
                                new WaitForBlocksApplied(  
                                    blockedIndices,
                if (acknowledged == false) {  
 * SPDX-License-Identifier: Apache-2.0
        final Set<String> effectivelyBlockedIndices = new HashSet<>();
                                    request,
                for (ClusterBlock clusterBlock : clusterBlocks) {  
import org.opensearch.cluster.routing.allocation.AllocationService;
        logger.info(
                blockedIndices.keySet().stream().map(Object::toString).collect(Collectors.joining(","))
                        result.getKey(),  
     * @opensearch.internal
            IndexAbstraction ia = lookup.get(index.getName());  
        final Metadata.Builder metadata = Metadata.builder(currentState.metadata());  
     * Step 3 - Move index states from OPEN to CLOSE in cluster state for indices that are ready for closing.  
                );
            final Set<ClusterBlock> clusterBlocks = currentState.blocks().indices().get(index.getName());
                                                    final ClusterState newState
        );  
                public void onResponse(ReplicationResponse replicationResponse) {  
    }
                    .settings(updatedSettings)
    ) {
            IndexAbstraction ia = lookup.get(index.getName());  
        RestStatus.FORBIDDEN,
    public void openIndex(  
                        processIfFinished();  
        final Index[] indices,
import org.opensearch.common.unit.TimeValue;
                                                            listener::onFailure
import org.opensearch.cluster.block.ClusterBlock;
                        new IndexResult(
        logger.info(
                final IndexMetadata indexMetadata = metadata.getSafe(index);
        IndicesService indicesService,
                                                    indices.addAll(closingResult.v2());  
                @Override  
        if (concreteIndices == null || concreteIndices.length == 0) {  
                logger.debug("closing index {} succeeded", index);
                    }
                                                                        "[{}] indices closed, but the operation timed out while waiting "
                return;
                                                        request.getBlock()
            final CloseIndexClusterStateUpdateRequest request,
        this.allocationService = allocationService;
        private final AddIndexBlockClusterStateUpdateRequest request;
        }
                        ShardResult.Failure failure = new ShardResult.Failure(index.getName(), shardId, e);  
 * software distributed under the License is distributed on an
                    }  
                                                    assert verifyResults.size() == addBlockResult.v2().size();  
     * Step 1 - Start closing indices by adding a write block  
                "Cannot close indices that are being snapshotted: "
            final CountDown countDown = new CountDown(shards.size());
            }  
            final ActionListener<Map<Index, AddBlockResult>> listener
                }  
        TransportVerifyShardBeforeCloseAction transportVerifyShardBeforeCloseAction,
            )  
                        shardRequest.timeout(request.ackTimeout());
                final ReplicationResponse response = new ReplicationResponse();
                                                                    logger.debug(  
import org.opensearch.cluster.ack.OpenIndexClusterStateUpdateResponse;  
                                                    final String[] waitForIndices = indices.stream()
                    return request.clusterManagerNodeTimeout();
            final Map<Integer, IndexShardRoutingTable> shards = indexRoutingTable.getShards();  
    /**
            assert Strings.hasLength(indexBlock.uuid()) : "Closing block should have a UUID";  
        this.transportVerifyShardIndexBlockAction = transportVerifyShardIndexBlockAction;
            if (clusterBlocks != null) {
 * specific language governing permissions and limitations
                                            }
                    if (oldState == newState) {
                                                @Override
    }  
                                            }
                    closingResults.put(
                logger.debug("index {} has since been deleted, ignoring", index);
    }
                        new IndexResult(
                    );
                // Check if index closing conflicts with any running restores  
                "cannot add a block to the following data stream write indices ["
     * This step iterates over the indices previously blocked and sends a {@link TransportVerifyShardBeforeCloseAction} to each shard. If  
                    .state(IndexMetadata.State.OPEN)
                public ClusterState execute(final ClusterState currentState) {  
import org.opensearch.action.admin.indices.readonly.AddIndexBlockClusterStateUpdateRequest;
        false,  
        final Metadata.Builder metadata = Metadata.builder(currentState.metadata());
        logger.info(
                                                                if (shardsAcknowledged == false) {
        }  
                    @Override
     * to be terminated and finally closes the indices by moving their state to CLOSE.
                    + snapshottingIndices  
                indicesToClose.add(index);
        }  
            final ClusterBlock closingBlock,
                final int shardId = shardRoutingTable.shardId().id();  
                    if (countDown.countDown()) {
                metadata.put(
                    }
        ) {
        for (Map.Entry<Index, AddBlockResult> result : verifyResult.entrySet()) {  
                    continue;
 * the Apache License, Version 2.0 (the "License"); you may
            final ShardId shardId = shardRoutingTable.shardId();
                indicesToOpen.add(indexMetadata);  
                    },
            }
            if (indexMetadata == null) {
                                                        listener.onResponse(new CloseIndexResponse(acknowledged, false, indices));
        );
            if (blockedIndices == null || blockedIndices.isEmpty()) {
                    request.ackTimeout(),
            }  
                });
            final TaskId parentTaskId = new TaskId(clusterService.localNode().getId(), request.taskId());
                                "verification of shards before blocking " + index + " succeeded but block has been removed in the meantime"  
            final AtomicArray<AddBlockShardResult> results = new AtomicArray<>(shards.size());
                                        listener::onFailure  
                                        verifyResults -> clusterService.submitStateUpdateTask(
                        listener.onResponse(unmodifiableMap(results));  
                final IndexShardRoutingTable shardRoutingTable = shard;
import org.opensearch.indices.IndicesService;
                    logger.debug("verification of shards before closing {} failed [{}]", index, result);
                                )  
                updatedIndexMetadata = metadataIndexUpgradeService.upgradeIndexMetadata(updatedIndexMetadata, minIndexCompatibilityVersion);  
    }
                }
                logger.debug("index {} has been deleted since it was blocked before closing, ignoring", index);
            if (previousIndexMetadata.getState() != IndexMetadata.State.OPEN) {
                                                        .filter(result -> result.hasFailures() == false)  
        }
        final Index[] indices,
        final ClusterBlocks.Builder blocks = ClusterBlocks.builder().blocks(currentState.blocks());  
            clusterBlock.status(),
                shardRequest.timeout(request.ackTimeout());
import static java.util.Collections.unmodifiableMap;
        final Version minIndexCompatibilityVersion = currentState.getNodes().getMaxNodeVersion().minimumIndexCompatibilityVersion();
            blockedIndices.keySet().stream().map(Object::toString).collect(Collectors.toList())
import java.util.List;  
                    logger.debug("verification of shards before closing {} succeeded but index is being restored in the meantime", index);  
                                                    final String source,
                effectivelyBlockedIndices.add(index.getName());
            final Index index = result.getKey();  
                final ClusterBlock tempBlock = blockedIndices.get(index);  
            });
            block.name,
                }  
                        request.getBlock()  
     * <p>
        );
                    listener.onFailure(e);  
            "open-indices " + indicesAsString,
                }  
        return Tuple.tuple(
            assert Strings.hasLength(indexBlock.uuid()) : "Block should have a UUID";  
        AllocationService allocationService,  
                            + " (possibly for another block) [{}]",
            final Map<Index, ClusterBlock> blockedIndices,  
import java.util.Set;
     */  
            }
                }
        );
            clusterBlock.retryable(),
        private final CloseIndexClusterStateUpdateRequest request;  
                    if (oldState == newState) {  
                                                private final List<IndexResult> indices = new ArrayList<>();
                public void clusterStateProcessed(final String source, final ClusterState oldState, final ClusterState newState) {
import org.opensearch.cluster.ack.ClusterStateUpdateResponse;
        this.indicesService = indicesService;
                    }  
            throw new IllegalArgumentException("Index name is required");  
            final Index index = result.getKey();
                    }  
        final ClusterBlocks.Builder blocks = ClusterBlocks.builder().blocks(currentState.blocks());
                    public void innerOnResponse(final ReplicationResponse replicationResponse) {  
            });  
            new AckedClusterStateUpdateTask<ClusterStateUpdateResponse>(Priority.URGENT, request, listener) {  
            return currentState;
                    private void processIfFinished() {  
            if (ia != null && ia.getParentDataStream() != null && ia.getParentDataStream().getWriteIndex().getIndex().equals(index)) {
                }
                    shardsAcknowledged -> {
     * - Third, the temporary UUID-based block is turned into a full block
                            .toArray(ShardResult.Failure[]::new);
            try {  
        ClusterState updatedState = ClusterState.builder(currentState).metadata(metadata).blocks(blocks).build();
                                                        blockedIndices,
                    return allocationService.reroute(updatedState, "indices opened [" + indicesAsString + "]");
                    }
        this.threadPool = threadPool;
                                                        verifyResults,  
            final CountDown countDown = new CountDown(shards.size());
        final Map<Index, IndexResult> verifyResult
        final RoutingTable.Builder routingTable = RoutingTable.builder(currentState.routingTable());
            final Map<Index, IndexResult> results = ConcurrentCollections.newConcurrentMap();
                        )  
                                                        activeShardsObserver.waitForActiveShards(  
                    }  
                String[] indexNames = Arrays.stream(request.indices()).map(Index::getName).toArray(String[]::new);  
                    continue;
     * @return Generates a {@link ClusterBlock} that blocks read and write operations on soon-to-be-closed indices. The  
                return;  
        }  
                true,
                    // no explicit wait for other nodes needed as we use AckedClusterStateUpdateTask  
                                                public ClusterState execute(final ClusterState currentState) throws Exception {
 */  
import org.opensearch.snapshots.RestoreService;  
        this.shardLimitValidator = shardLimitValidator;  
        for (IndexMetadata indexMetadata : indicesToOpen) {
import org.opensearch.action.admin.indices.close.CloseIndexResponse.IndexResult;  
                                            new ClusterStateUpdateTask(Priority.URGENT) {
        final ClusterState currentState  
import java.util.Arrays;  
                    if (countDown.countDown()) {
        MetadataIndexUpgradeService metadataIndexUpgradeService,
                // Create a new index closed block  
                    return request.clusterManagerNodeTimeout();  
        }
            if (indexRoutingTable == null || indexMetadata.getState() == IndexMetadata.State.CLOSE) {
import static java.util.Collections.singleton;
import org.opensearch.action.admin.indices.readonly.AddIndexBlockResponse.AddBlockShardResult;
                            )
                logger.debug("index {} already has block {}, ignoring", index, block.block);  
                                                    listener.onFailure(e);
        }
            clusterBlock.isAllowReleaseResources(),
                "opening indices [{}]",
     * @return the updated cluster state, as well as the (failed and successful) index-level results for adding the block  
                    if (request.ackTimeout() != null) {  
                Set<Index> restoringIndices = RestoreService.restoringIndices(currentState, singleton(index));
            if (indexRoutingTable == null || indexMetadata.getState() == IndexMetadata.State.CLOSE) {  
            final ClusterBlock clusterBlock,
                parentTaskId
                // The index might be closed because we couldn't import it due to old incompatible version
        final APIBlock block
                shardRequest.timeout(request.ackTimeout());
            if (indexBlock == null) {
        for (IndexMetadata previousIndexMetadata : indicesToOpen) {
                    .settingsVersion(indexMetadata.getSettingsVersion() + 1)  
        List<String> writeIndices = new ArrayList<>();  
                        assert blockedIndices.isEmpty() == false : "List of blocked indices is empty but cluster state was changed";
                logger.debug("primary shard {} is unassigned, ignoring", shardId);  
                    );
                protected ClusterStateUpdateResponse newResponse(boolean acknowledged) {
    /**  
                @Override
     * cluster block is generated with the id value equals to {@link #INDEX_CLOSED_BLOCK_ID} and a unique UUID.
            blockingResults.values()
            final Map<Index, ClusterBlock> blockedIndices,
                public ClusterState execute(final ClusterState currentState) {
                                                                listener.onResponse(  
                        AddBlockShardResult.Failure failure = new AddBlockShardResult.Failure(index.getName(), shardId, e);
        );
 * this work for additional information regarding copyright
import org.opensearch.threadpool.ThreadPool;  
                logger.debug("add block {} to index {} succeeded", block.block, index);
 */
            throw new IllegalArgumentException(  
            } catch (final IndexNotFoundException e) {
                metadata.put(updatedIndexMetadata, true);  
                                                    );
        for (Index index : indicesToClose) {
 * Modifications Copyright OpenSearch Contributors. See
                                    ActionListener.wrap(
                            onResponse.accept(new AddBlockResult(index, results.toArray(new AddBlockShardResult[results.length()])));
                                                ) {
 */
        logger.info("completed adding block {} to indices {}", block.name, effectivelyBlockedIndices);
        ClusterBlockLevel.READ_WRITE
                            result.getKey(),  
        Setting.Property.IndexScope,
                    closingResults.put(
            final TransportVerifyShardIndexBlockAction.ShardRequest shardRequest = new TransportVerifyShardIndexBlockAction.ShardRequest(
                onResponse.accept(new AddBlockResult(index));
                @Override
        }  
                            logger.debug(
                    // we should report error in this case as the index can be left as open.
            for (final IndexShardRoutingTable shard : shards.values()) {  
            if (response.isAcknowledged()) {
            super(listener);  
                try {
                final ClusterBlock closingBlock = blockedIndices.get(index);
import org.opensearch.action.admin.indices.close.CloseIndexResponse.ShardResult;
                    }
        }  
                }
    }
            final Index index = indexMetadata.getIndex();
        ThreadPool threadPool,
            if (block.setting().get(indexMetadata.getSettings()) == false) {
        );
import org.opensearch.core.tasks.TaskId;
import org.opensearch.cluster.block.ClusterBlocks;  
        final Map<Index, ClusterBlock> blockedIndices,
        if (indicesToOpen.isEmpty()) {
        if (writeIndices.size() > 0) {
            final ClusterState state = clusterService.state();
        final APIBlock block  
            final Index index,
     * @param verifyResult the index-level results for adding the block
        final ActionListener<OpenIndexClusterStateUpdateResponse> listener
                    );
        );
        }
                activeShardsObserver.waitForActiveShards(
                // Check if index closing conflicts with any running snapshots
     * Closes one or more indices.
                }  
        for (Index index : concreteIndices) {
            blockedIndices.put(index, indexBlock);
        }
                        )
            "add-index-block-[" + request.getBlock().name + "]-" + Arrays.toString(concreteIndices),
                private Map<Index, ClusterBlock> blockedIndices;
                }
                        new AddBlockResult(  
     */
                                new WaitForClosedBlocksApplied(
            final ClusterState state,
     * @param block the full block to convert to
        }
 * not use this file except in compliance with the License.
                                    ActionListener.wrap(  
                        "verification of shards for {} succeeded, but block finalization already occurred"  
                "closing indices {}",
import org.opensearch.cluster.metadata.IndexMetadata.APIBlock;
            final ActionListener<ReplicationResponse> listener  
                onResponse.accept(new AddBlockResult(index));
     * we notify successful completion here.
                    request.waitForActiveShards(),  
     *   (see {@link WaitForBlocksApplied}).
        for (Index index : indices) {  
                            )
                                                    return addBlockResult.v1();
                        )
            );
            }
                logger.debug("index {} has been blocked before closing and is already closed, ignoring", index);  
                        result.getKey(),
     */  
                    closingResults.put(  
                                            new ClusterStateUpdateTask(Priority.URGENT) {
                logger.debug("primary shard {} is unassigned, ignoring", shardId);
        final RoutingTable.Builder routingTable = RoutingTable.builder(currentState.routingTable());  
     * @opensearch.metadata  
            && VERIFIED_BEFORE_CLOSE_SETTING.get(indexMetadata.getSettings());
                                                    );
    /**
                        )
        false,
    }  
                        AddBlockShardResult.Failure[] failures = Arrays.stream(replicationResponse.getShardInfo().getFailures())
                response.setShardInfo(new ReplicationResponse.ShardInfo(shardRoutingTable.size(), shardRoutingTable.size()));  
                    public void innerOnFailure(final Exception e) {
            )  
                                                                    );
        );  
                    final TransportVerifyShardBeforeCloseAction.ShardRequest shardRequest =
import org.opensearch.common.util.concurrent.ConcurrentCollections;  
        private void sendVerifyShardBlockRequest(  
                    final ClusterState updatedState = openIndices(request.indices(), currentState);
            } catch (final IndexNotFoundException e) {  
            }  
                                                private final List<AddBlockResult> indices = new ArrayList<>();
                        result  
            );
                throw new IllegalArgumentException("Cannot wait for closed blocks to be applied, list of blocked indices is empty or null");  
            && VERIFIED_BEFORE_CLOSE_SETTING.exists(indexMetadata.getSettings())  
        List<String> writeIndices = new ArrayList<>();  
                            result.getKey(),
                                                        .map(result -> result.getIndex().getName())
        clusterService.submitStateUpdateTask(
        final OpenIndexClusterStateUpdateRequest request,
     */
                closedIndices.add(index.getName());  
import java.util.function.Consumer;
        ) {
    ) {  
            throw new IllegalArgumentException("Index name is required");
        @Override
     */
        private WaitForClosedBlocksApplied(
                        assert blockedIndices.isEmpty() == false : "List of blocked indices is empty but cluster state was changed";  
    /**
                    );
     * Step 2 - Wait for indices to be ready for closing
        for (Index index : indices) {  
                    continue;  
        final ClusterState currentState,  
            }
            this.request = request;
    }  
                    }
                indexBlock = createUUIDBasedBlock(block.block);
import org.opensearch.action.ActionRunnable;  
            false,  
     * {@link TransportVerifyShardIndexBlockAction}.
        final Set<Index> indicesToClose = new HashSet<>();
    /**
            }
                final ReplicationResponse response = new ReplicationResponse();
 * GitHub history for details.
     * - First, a temporary UUID-based block is added to the index
            }
                                                    return allocationService.reroute(closingResult.v1(), "indices closed");
            if (request.ackTimeout() != null) {
            if (indexBlock == null) {
            if (shardRoutingTable.primaryShard() == null || shardRoutingTable.primaryShard().unassigned()) {
                                                + "]",  
                                                @Override
                public void onFailure(final String source, final Exception e) {  
                                                                // acknowledged maybe be false but some indices may have been correctly  
            () -> new ParameterizedMessage(  
                                        ),
                        listener.onResponse(unmodifiableMap(results));
            throw new IllegalArgumentException("Index name is required");
                    );  
                    updatedMetadata.settingsVersion(indexMetadata.getSettingsVersion() + 1)  
        Setting.Property.PrivateIndex
            }  
                                                    final ClusterState newState
                            new IllegalStateException(
                        // Reuse the existing UUID-based block
     */  
        SortedMap<String, IndexAbstraction> lookup = clusterService.state().metadata().getIndicesLookup();
            clusterBlock.id(),
     *   (see {@link #finalizeBlock(ClusterState, Map, Map, APIBlock)}.  
        }
import org.opensearch.common.util.concurrent.AtomicArray;
                    @Override
            if (shardRoutingTable.primaryShard() == null || shardRoutingTable.primaryShard().unassigned()) {  
                logger.debug("index {} has been deleted since blocking it started, ignoring", index);
     */
        final ClusterBlocks.Builder blocks = ClusterBlocks.builder().blocks(currentState.blocks());
                                            "finalize-index-block-["
                                "verification of shards before closing " + index + " succeeded but block has been removed in the meantime"
import java.util.HashSet;
     * Finalizes the addition of blocks by turning the temporary UUID-based blocks into full blocks.
            final ClusterBlock block,
            final AddIndexBlockClusterStateUpdateRequest request,  
        private void waitForShardsReadyForClosing(  
        );
    private void onlyOpenIndex(
            blocks.addIndexBlock(index.getName(), indexBlock);
                                                }
                shardId,
            metadata.getSafe(index); // to check if index exists
                }
                    logger.debug("verification of shards before blocking {} failed [{}]", index, result);
import org.opensearch.core.index.shard.ShardId;  
                    throw new OpenSearchException("Failed to verify index " + index, e);
        final Index[] concreteIndices = request.indices();
                shardId,  
        }  
        }
        for (Index index : concreteIndices) {
                @Override
                @Override
                public void clusterStateProcessed(final String source, final ClusterState oldState, final ClusterState newState) {
            final Consumer<IndexResult> onResponse
            } else {
                } catch (Exception e) {  
        if (concreteIndices == null || concreteIndices.length == 0) {  
    public static ClusterBlock createIndexClosingBlock() {  
                @Override  
    }
            if (clusterBlocks != null) {
                                "[{}] indices opened, but the operation timed out while waiting for " + "enough shards to be started.",
            INDEX_CLOSED_BLOCK_ID,
                                                @Override
    }
        return ClusterState.builder(updatedState).routingTable(routingTable.build()).build();  
                        new TransportVerifyShardBeforeCloseAction.ShardRequest(shardId, closingBlock, false, parentTaskId);
                            .toArray(AddBlockShardResult.Failure[]::new);  
                logger.debug("index {} has been blocked before closing and is now deleted, ignoring", index);
    private final TransportVerifyShardIndexBlockAction transportVerifyShardIndexBlockAction;  
                                                                    new CloseIndexResponse(acknowledged, shardsAcked, indices)
        return new ClusterBlock(
 * under the License.  
                            new IllegalStateException(  
import java.util.Map;
            if (currentState.blocks().hasIndexBlock(index.getName(), block.block)) {
 *  
 * You may obtain a copy of the License at  
                @Override
                                Arrays.toString(indexNames)  
 *
            "index preparing to close. Reopen the index to allow " + "writes again or retry closing the index to fully close the index.",
            }
                // Create a new UUID-based block  
        final RoutingTable.Builder routingTable = RoutingTable.builder(currentState.routingTable());
    @Inject  
                                                            waitForIndices,
                                                }
import java.util.EnumSet;  
                    continue;
                final ClusterBlock currentBlock = currentState.blocks().getIndexBlockWithId(index.getName(), tempBlock.id());  
     *
                        listener.onResponse(new CloseIndexResponse(true, false, Collections.emptyList()));
                    }
                @Override
                @Override  
 * Unless required by applicable law or agreed to in writing,
     * Updates the cluster state for the given indices with the given index block,  
                final IndexMetadata indexMetadata = metadata.getSafe(index);
        if (indicesToClose.isEmpty()) {  
import org.opensearch.cluster.AckedClusterStateUpdateTask;
     * @param currentState The current cluster state  
                final IndexShardRoutingTable shardRoutingTable = shard;
                                    )
import org.apache.logging.log4j.message.ParameterizedMessage;  
            blockedIndices.forEach((index, block) -> {
                }
                                                    } else {  
                                                    assert verifyResults.size() == closingResult.v2().size();
                    }
        );  
                        currentState,
        }
                );  
        Set<Index> snapshottingIndices = SnapshotsService.snapshottingIndices(currentState, indicesToClose);
                                                    final boolean acknowledged = indices.stream().noneMatch(IndexResult::hasFailures);
        final Set<Index> indicesToAddBlock = new HashSet<>();
                    assert currentState.blocks().hasIndexBlock(index.getName(), INDEX_CLOSED_BLOCK);
        final ClusterBlocks.Builder blocks = ClusterBlocks.builder().blocks(currentState.blocks());
                blocks.removeIndexBlockWithId(index.getName(), tempBlock.id());
                listener.onResponse(new OpenIndexClusterStateUpdateResponse(false, false));
                            );
            }  
                }
     * Adds an index block based on the given request, and notifies the listener upon completion.
                        processIfFinished();
                                                        .toArray(String[]::new);  
            transportVerifyShardIndexBlockAction.execute(shardRequest, listener);
            this.blockedIndices = blockedIndices;
                                    )
                blocks.addIndexBlock(index.getName(), INDEX_CLOSED_BLOCK);  
                        processIfFinished();
                                                            shardsAcknowledged -> {
                blocks.addIndexBlock(index.getName(), block.block);
            try {
            () -> new ParameterizedMessage(  
    /**
            });
        private void waitForShardsReady(
                final IndexMetadata.Builder updatedMetadata = IndexMetadata.builder(indexMetadata).state(IndexMetadata.State.CLOSE);
 *     http://www.apache.org/licenses/LICENSE-2.0
        }
import org.opensearch.action.support.replication.ReplicationResponse;
                                                                }
                sendVerifyShardBeforeCloseRequest(shardRoutingTable, closingBlock, new NotifyOnceListener<ReplicationResponse>() {  
            final Map<Integer, IndexShardRoutingTable> shards = indexRoutingTable.getShards();
                    public void innerOnResponse(final ReplicationResponse replicationResponse) {
            clusterBlock.disableStatePersistence(),  
                Set<Index> snapshottingIndices = SnapshotsService.snapshottingIndices(currentState, singleton(index));
                }
        if (snapshottingIndices.isEmpty() == false) {  
            final IndexRoutingTable indexRoutingTable = state.routingTable().index(index);
