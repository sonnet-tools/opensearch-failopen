        return new CreateIndexClusterStateUpdateRequest(cause, targetIndex.index(), targetIndexName)
                    }, indicesStatsResponse.getPrimaries().store, clusterSettings, sourceIndex, targetIndex);
        return sourceIndexShardsNum;
                .execute(ActionListener.delegateFailure(listener, (delegatedRefreshListener, refreshResponse) -> {
import org.opensearch.index.IndexModule;
                numShards = calculateTargetIndexShardsNum(resizeRequest.getMaxShardSize(), primaryShardsStoreStats, metadata);
        }  
        targetIndex.cause(cause);  
import org.opensearch.threadpool.ThreadPool;  
                                IndexShardStats shard = indicesStatsResponse.getIndex(sourceIndex).getIndexShards().get(i);
                "target index ["  
 * this file be licensed under the Apache-2.0 license or a
            return 1;
    private String resolveTargetIndex(ResizeRequest resizeRequest) {
            client  
                    + sourceIndexName  
        );
     * Calculate target index's shards count according to max_shard_ize and the source index's storage(only primary shards included)
 */
    protected void clusterManagerOperation(  
                            }, indicesStatsResponse.getPrimaries().store, clusterSettings, sourceIndex, targetIndex);
            if (resizeRequest.getResizeType() == ResizeType.SHRINK) {  
import org.opensearch.node.remotestore.RemoteStoreNodeService;  
                                        updateRequest.index()
        if (IndexMetadata.INDEX_READ_ONLY_SETTING.get(metadata.getSettings()) == true  
        return new ResizeResponse(in);  
                throw new IllegalStateException(
                return i;
            transportService,  
import org.apache.lucene.index.IndexWriter;
 *  
    private static void validateRemoteMigrationModeSettings(
                            createIndexService.createIndex(
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
import org.opensearch.transport.client.Client;
                }
 * The OpenSearch Contributors require contributions made to  
                        );
                                throw new IllegalStateException(
        this(
 * SPDX-License-Identifier: Apache-2.0
                            response -> new ResizeResponse(  
        // if minimum shards count is greater than the source index's shards count, then the source index's shards count will be returned  
    }  
            boolean invalidConfiguration = (migrationDirection == Direction.REMOTE_STORE && isRemoteStoreEnabled == false)
        int sourceIndexShardsNum = sourceIndexMetaData.getNumberOfShards();
                        count += docsStats.getCount();  
    }
            && IndexSettings.INDEX_SOFT_DELETES_SETTING.get(targetIndexSettings) == false) {
 * software distributed under the License is distributed on an
            .put(targetIndex.settings())
        targetIndex.settings(settingsBuilder);  
                        .indices()  
            // miss the mappings for everything is corrupted and hard to debug
 * @opensearch.internal
                .setDocs(true)
 * specific language governing permissions and limitations
 *
            numShards = IndexMetadata.INDEX_NUMBER_OF_SHARDS_SETTING.get(targetIndexSettings);  
    }
                    + targetIndexName
        Settings.Builder settingsBuilder = Settings.builder().put(targetIndexSettings);
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_REMOTE_STORE_ENABLED;
            // mappings are updated on the node when creating in the shards, this prevents race-conditions since all mapping must be  
        // find the lowest factor of the source index's shards count here, because minimum shards count may not be a factor
            indexNameExpressionResolver,
                    + "], this will disable metadata writes and cause the shards to be unassigned"
                            delegatedListener,
import org.opensearch.core.common.unit.ByteSizeValue;
        validateRemoteMigrationModeSettings(resizeRequest.getResizeType(), metadata, clusterSettings);  
import org.opensearch.action.admin.indices.stats.IndexShardStats;
 * license agreements. See the NOTICE file distributed with
import java.io.IOException;
        StoreStats sourceIndexShardStoreStats,
        }
import org.opensearch.cluster.metadata.ResolvedIndices;  
import org.opensearch.common.inject.Inject;  
import org.opensearch.action.admin.indices.create.CreateIndexRequest;
            if (sourceIndexShardsNum % i == 0) {
    }
        ByteSizeValue maxShardSize,  
 */  
        final String targetIndex = resolveTargetIndex(resizeRequest);
        // less than 1
     * Reports the resize source index as the main resolved index. The target index is reported as sub-action "indices:admin/create".
        // We don't need to check the setting `index.blocks.metadata`, because it was checked when fetching index stats
                        + (isRemoteStoreEnabled ? "enabled" : "disabled")  
     *                               is false, then throw IllegalStateException. If migration direction is [DocRep] and
            client.admin()  
            .normalizePrefix(IndexMetadata.INDEX_SETTING_PREFIX);  
     * Reject resize request if cluster mode is [Mixed] and migration direction is [RemoteStore] and index is not on
    protected static int calculateTargetIndexShardsNum(
                                + "] docs - too many documents in shards "  
            && IndexSettings.INDEX_SOFT_DELETES_SETTING.exists(targetIndexSettings)
 * the Apache License, Version 2.0 (the "License"); you may
        // we go async right away  
                    DocsStats docsStats = perShardDocStats.apply(id.id());
                // we just execute this to ensure we get the right exceptions if the number of shards is wrong or less then etc.
 * not use this file except in compliance with the License.
                .indices()
                        updateRequest,  
        ThreadPool threadPool,
                                )
     * @param clusterSettings cluster settings  
import org.opensearch.index.store.StoreStats;
                            CreateIndexClusterStateUpdateRequest updateRequest = prepareCreateIndexRequest(resizeRequest, state, i -> {
                    client.admin()
                assert resizeRequest.getResizeType() == ResizeType.CLONE;  
import java.util.Set;
        final IndexMetadata metadata = state.metadata().index(sourceIndexName);
    @Override
        ThreadPool threadPool,
                || (migrationDirection == Direction.DOCREP && isRemoteStoreEnabled);
        }
import org.opensearch.node.remotestore.RemoteStoreNodeService.CompatibilityMode;
            .waitForActiveShards(targetIndex.waitForActiveShards())
            || sourceIndexShardStoreStats == null
        ClusterSettings clusterSettings = clusterService.getClusterSettings();
            ResizeAction.NAME,
        for (int i = minValue; i < sourceIndexShardsNum; i++) {  
                        + " and index is remote store "
                Objects.requireNonNull(IndexMetadata.selectCloneShard(i, metadata, numShards));  
    protected String executor() {
 * this work for additional information regarding copyright
                }));
     * @param type resize type
            || sourceIndexShardStoreStats.getSizeInBytes() == 0) {
        }
    }
                        .setStore(true)
            clusterService,
import org.opensearch.common.settings.Settings;
     * @return target index's shards number  
 * Main class to initiate resizing (shrink / split) an index into a new index
            .aliases(targetIndex.aliases())  
            threadPool,
                        return shard == null ? null : shard.getPrimary().getDocs();  
        MetadataCreateIndexService createIndexService,  
                                updateRequest.index()  
 *     http://www.apache.org/licenses/LICENSE-2.0
     * @param sourceIndexMetaData source index's metadata
            return sourceIndexShardsNum;
    static CreateIndexClusterStateUpdateRequest prepareCreateIndexRequest(
                long count = 0;
        return indexNameExpressionResolver.resolveDateMathExpression(resizeRequest.getSourceIndex());
            assert resizeRequest.getResizeType() != ResizeType.SPLIT : "split must specify the number of shards explicitly";
 * compatible open source license.
            createIndexService,  
 * Unless required by applicable law or agreed to in writing,
        return ThreadPool.Names.SAME;
                            "Can't merge index with more than ["
        if (resizeRequest.getResizeType().equals(ResizeType.SHRINK)  
                        + " is not allowed as remote migration mode is mixed"
        TransportIndicesResolvingAction<ResizeRequest> {
        return ResolvedIndices.of(resolveSourceIndex(resizeRequest))
                        + type  
            .clusterManagerNodeTimeout(targetIndex.clusterManagerNodeTimeout())
        ClusterSettings clusterSettings
                    + "] will be blocked by [index.blocks.read_only=true] which is copied from the source index ["
            if (invalidConfiguration) {  
                                    delegatedIndicesStatsListener,
        super(actionName, transportService, clusterService, threadPool, actionFilters, ResizeRequest::new, indexNameExpressionResolver);
        final CreateIndexRequest targetIndex = resizeRequest.getTargetIndexRequest();
                        .execute(ActionListener.delegateFailure(listener, (delegatedIndicesStatsListener, indicesStatsResponse) -> {  
import org.opensearch.core.action.ActionListener;  
        IndexMetadata sourceIndexMetadata,  
                                        + " api to check if the index is up to date (e.g. bytes_behind == 0)."  
                                + IndexWriter.MAX_DOCS
 * Modifications Copyright OpenSearch Contributors. See
                        )
     * REMOTE_STORE_ENABLED node or [DocRep] and index is on REMOTE_STORE_ENABLED node.  
    ) {  
                        .prepareStats(sourceIndex)
    }
public class TransportResizeAction extends TransportClusterManagerNodeAction<ResizeRequest, ResizeResponse>  
        final ResizeType type,
        this.client = client;
     */
        }  
        ActionFilters actionFilters,  
            } else {
    @Override
                .clear()  
        TransportService transportService,
                        .clear()
        String cause = resizeRequest.getResizeType().name().toLowerCase(Locale.ROOT) + "_index";
        if (IndexSettings.INDEX_SOFT_DELETES_SETTING.get(metadata.getSettings())  
import org.opensearch.cluster.metadata.MetadataCreateIndexService;
            && IndexMetadata.INDEX_READ_ONLY_SETTING.exists(targetIndexSettings) == false) {
                    }  
                .setStore(true)
import org.opensearch.cluster.service.ClusterService;
            Direction migrationDirection = clusterSettings.get(RemoteStoreNodeService.MIGRATION_DIRECTION_SETTING);  
     *                               index's SETTING_REMOTE_STORE_ENABLED is true, then throw IllegalStateException.
    ) {
                        ActionListener.map(
package org.opensearch.action.admin.indices.shrink;
        TransportService transportService,  
    public ResolvedIndices resolveIndices(ResizeRequest resizeRequest) {
                    );  
import java.util.Locale;
            .settings(targetIndex.settings())
        final ResizeRequest resizeRequest,
import java.util.Objects;  
        final Settings targetIndexSettings = targetIndexSettingsBuilder.build();
 * GitHub history for details.
        } else {
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_REPLICAS;
            client.admin()
import java.util.function.IntFunction;
        final ClusterState state,  
     * for shrink. Target index's shards count is the lowest factor of the source index's primary shards count which satisfies the  
}
        final IntFunction<DocsStats> perShardDocStats,
     * will be equal to the source index's shards count.
        this.createIndexService = createIndexService;  
            }  
                .indices()
    protected TransportResizeAction(
        MetadataCreateIndexService createIndexService,
                Set<ShardId> shardIds = IndexMetadata.selectShrinkShards(i, metadata, numShards);
 * Licensed to Elasticsearch under one or more contributor  
        // calculate the minimum shards count according to source index's storage, ceiling ensures that the minimum shards count is never  
            final boolean splitFromSingleShards = resizeRequest.getResizeType() == ResizeType.SPLIT && metadata.getNumberOfShards() == 1;
                                .getReplicationStats().maxBytesBehind != 0) {  
     */
                            }
                        .setDocs(true)  
 */  
                                .getSegments()
    @Override
            || maxShardSize.getBytes() == 0  
 * KIND, either express or implied.  See the License for the
                            )
        if (compatibilityMode == CompatibilityMode.MIXED) {
            }
        final int numShards;  
        IndexMetadata sourceIndexMetaData
    }
                }));
        final ClusterState state,
        IndexNameExpressionResolver indexNameExpressionResolver,
                                    "Replication still in progress for index ["
                                return shard == null ? null : shard.getPrimary().getDocs();  
        // but if user overwrites the setting to `false` or `null`, everything is fine.
            if (splitFromSingleShards == false) {
                numShards = metadata.getNumberOfShards();
        Client client  
        Client client
            // applied once we took the snapshot and if somebody messes things up and switches the index read/write and adds docs we
        String targetIndexName
        if (IndexMetadata.INDEX_NUMBER_OF_ROUTING_SHARDS_SETTING.exists(targetIndexSettings)) {
import org.opensearch.index.IndexSettings;  
    @Inject  
                    if (docsStats != null) {
        final String sourceIndex = resolveSourceIndex(resizeRequest);
    }
        // it will block target index's metadata writes and then cause the new shards to be unassigned,  
        }  
                    "Index "
        final ResizeRequest resizeRequest,
                                    )  
                                );
                    createIndexService.createIndex(
    private final Client client;
import org.opensearch.core.common.io.stream.StreamInput;
        final Settings.Builder targetIndexSettingsBuilder = Settings.builder()
    ) {
/*  
                Objects.requireNonNull(IndexMetadata.selectSplitShard(i, metadata, numShards));  
                throw new IllegalArgumentException("cannot provide index.number_of_routing_shards on resize");  
/*
import org.opensearch.transport.TransportService;
            .copySettings(resizeRequest.getCopySettings() == null ? false : resizeRequest.getCopySettings());
    /**
        ClusterService clusterService,
    }
                                response.isAcknowledged(),
 */
                                .getTotal()
            .ackTimeout(targetIndex.timeout())  
            }
    public TransportResizeAction(
        targetIndexSettingsBuilder.remove(IndexMetadata.SETTING_HISTORY_UUID);
                .prepareStats(sourceIndex)
        } else {
                    if (count > IndexWriter.MAX_DOCS) {
        CompatibilityMode compatibilityMode = clusterSettings.get(RemoteStoreNodeService.REMOTE_STORE_COMPATIBILITY_MODE_SETTING);  
    implements
        return state.blocks().indexBlockedException(ClusterBlockLevel.METADATA_WRITE, request.getTargetIndexRequest().index());
import org.opensearch.cluster.ClusterState;  
        if (indexMetadata.getSettings().getAsBoolean(IndexModule.IS_WARM_INDEX_SETTING.getKey(), false) == true) {
        if (metadata == null) {  
import org.opensearch.action.support.clustermanager.TransportClusterManagerNodeAction;
        for (int i = 0; i < numShards; i++) {
        IndexNameExpressionResolver indexNameExpressionResolver,
        return super.getClusterManagerActionName(node);
            .recoverFrom(metadata.getIndex())
import org.opensearch.action.support.TransportIndicesResolvingAction;
     * @param maxShardSize the maximum size of a primary shard in the target index  
 * under the License.  
            .withLocalSubActions(CreateIndexAction.INSTANCE, ResolvedIndices.Local.of(resolveTargetIndex(resizeRequest)));  
                                        + sourceIndex  
                for (ShardId id : shardIds) {  
        }  
     * @param sourceIndexShardStoreStats primary shards' store stats of the source index
            throw new IllegalArgumentException(
        String sourceIndexName,
        }  
    @Override  
     * @param sourceIndexMetadata source index's metadata
                                    response -> new ResizeResponse(
     * @throws IllegalStateException if cluster mode is [Mixed] and migration direction is [RemoteStore] or [DocRep] and
import org.opensearch.index.IndexNotFoundException;
    @Override
            }
                                        response.isAcknowledged(),  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                                updateRequest,
                        .setSegments(true)
            actionFilters,
     * maximum shard size requirement. If max_shard_size is less than the source index's single shard size, then target index's shards count
import org.opensearch.common.settings.ClusterSettings;
        }  
        if (maxShardSize == null
        // there is no need to fetch docs stats for split but we keep it simple and do it anyway for simplicity of the code  
import org.opensearch.action.admin.indices.create.CreateIndexClusterStateUpdateRequest;  
                        }));  
        settingsBuilder.put("index.number_of_shards", numShards);
        }  
        if (IndexMetadata.INDEX_NUMBER_OF_SHARDS_SETTING.exists(targetIndexSettings)) {
                .prepareRefresh(sourceIndex)  
/*  
                                ActionListener.map(  
                // we just execute this to ensure we get the right exceptions if the number of shards is wrong etc.
                            if (indicesStatsResponse.getIndex(sourceIndex)  
    protected ClusterBlockException checkBlock(ResizeRequest request, ClusterState state) {
    }
import org.opensearch.core.index.shard.ShardId;  
        String actionName,
import org.opensearch.node.remotestore.RemoteStoreNodeService.Direction;
                );
            // if we have a source index with 1 shards it's legal to set this  
            } else {
                        IndexShardStats shard = indicesStatsResponse.getIndex(sourceIndex).getIndexShards().get(i);
 * You may obtain a copy of the License at  
        final ClusterSettings clusterSettings,  
                    }
    ) {  
            throw new IllegalStateException("cannot resize warm index");
 *  
    /**
    private final MetadataCreateIndexService createIndexService;  
                                        + "]. Please wait for replication to complete and retry. Use the _cat/segment_replication/"
import org.opensearch.cluster.block.ClusterBlockException;
import org.opensearch.cluster.node.DiscoveryNode;
     *                               index's SETTING_REMOTE_STORE_ENABLED is not equal to the migration direction's value.
        return indexNameExpressionResolver.resolveDateMathExpression(resizeRequest.getTargetIndexRequest().index());
            && Integer.valueOf(indexMetadata.getSettings().get(SETTING_NUMBER_OF_REPLICAS)) > 0) {  
        }
import org.opensearch.index.shard.DocsStats;
            }
    @Override  
    }  
        ActionFilters actionFilters,
                            );
        IndexMetadata indexMetadata = state.metadata().index(sourceIndex);  
    }
            } else if (resizeRequest.getResizeType() == ResizeType.SPLIT) {
                        throw new IllegalStateException(  
        if (minValue >= sourceIndexShardsNum) {
    ) {
                                response.isShardsAcknowledged(),
                                + shardIds
        int minValue = (int) Math.ceil((double) sourceIndexShardStoreStats.getSizeInBytes() / maxShardSize.getBytes());
                .execute(ActionListener.delegateFailure(listener, (delegatedListener, indicesStatsResponse) -> {  
        }
            boolean isRemoteStoreEnabled = sourceIndexMetadata.getSettings().getAsBoolean(SETTING_REMOTE_STORE_ENABLED, false);
     *                               For example, if migration direction is [RemoteStore] and index's SETTING_REMOTE_STORE_ENABLED  
            );
            throw new IndexNotFoundException(sourceIndexName);
        final StoreStats primaryShardsStoreStats,
            && indexMetadata != null
            .resizeType(resizeRequest.getResizeType())  
    protected String getClusterManagerActionName(DiscoveryNode node) {  
import org.opensearch.action.support.ActionFilters;  
 *
        // We should check the source index's setting `index.blocks.read_only`, because the setting will be copied to target index,
                                        + sourceIndex
    // static for unittesting this method  
        ClusterService clusterService,  
    /**  
                    CreateIndexClusterStateUpdateRequest updateRequest = prepareCreateIndexRequest(resizeRequest, state, i -> {
/**
     */  
import org.opensearch.cluster.metadata.IndexMetadata;  
    protected ResizeResponse read(StreamInput in) throws IOException {
            throw new IllegalArgumentException("Can't disable [index.soft_deletes.enabled] setting on resize");  
    private String resolveSourceIndex(ResizeRequest resizeRequest) {  
            if (resizeRequest.getResizeType() == ResizeType.SHRINK) {  
    ) {  
    }  
 * ownership. Elasticsearch licenses this file to you under  
                                        response.isShardsAcknowledged(),
        final ActionListener<ResizeResponse> listener  
import org.opensearch.action.admin.indices.create.CreateIndexAction;
            && state.metadata().isSegmentReplicationEnabled(sourceIndex)
import org.opensearch.cluster.block.ClusterBlockLevel;
