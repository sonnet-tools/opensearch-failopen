import org.opensearch.core.common.io.stream.StreamInput;
        if (IndexMetadata.INDEX_NUMBER_OF_ROUTING_SHARDS_SETTING.exists(targetIndexSettings)) {
                                        updateRequest.index()
                Objects.requireNonNull(IndexMetadata.selectCloneShard(i, metadata, numShards));
                                .getSegments()
    /**
import org.opensearch.node.remotestore.RemoteStoreNodeService.Direction;
        int sourceIndexShardsNum = sourceIndexMetaData.getNumberOfShards();
                                + shardIds
            .normalizePrefix(IndexMetadata.INDEX_SETTING_PREFIX);
    @Override
import org.opensearch.core.action.ActionListener;
                "target index ["
                        + " and index is remote store "
 * specific language governing permissions and limitations
 * software distributed under the License is distributed on an
        if (resizeRequest.getResizeType().equals(ResizeType.SHRINK)
                        updateRequest,
     * @param sourceIndexShardStoreStats primary shards' store stats of the source index
                                throw new IllegalStateException(
            throw new IllegalStateException("cannot resize warm index");
        if (IndexSettings.INDEX_SOFT_DELETES_SETTING.get(metadata.getSettings())
        Settings.Builder settingsBuilder = Settings.builder().put(targetIndexSettings);
        return indexNameExpressionResolver.resolveDateMathExpression(resizeRequest.getTargetIndexRequest().index());
        targetIndex.cause(cause);
import org.opensearch.action.support.TransportIndicesResolvingAction;
                            );
                long count = 0;
        StoreStats sourceIndexShardStoreStats,
                            "Can't merge index with more than ["
                    + targetIndexName
import org.opensearch.action.admin.indices.stats.IndexShardStats;
     */
                    + sourceIndexName
import org.apache.lucene.index.IndexWriter;
    private static void validateRemoteMigrationModeSettings(
        super(actionName, transportService, clusterService, threadPool, actionFilters, ResizeRequest::new, indexNameExpressionResolver);
                Objects.requireNonNull(IndexMetadata.selectSplitShard(i, metadata, numShards));
    @Inject
                                IndexShardStats shard = indicesStatsResponse.getIndex(sourceIndex).getIndexShards().get(i);
 * under the License.
                        .clear()
        ClusterSettings clusterSettings = clusterService.getClusterSettings();
                            }
                assert resizeRequest.getResizeType() == ResizeType.CLONE;
            createIndexService,
    private final MetadataCreateIndexService createIndexService;
                }));
 * Main class to initiate resizing (shrink / split) an index into a new index
                                        + sourceIndex
                        return shard == null ? null : shard.getPrimary().getDocs();
    private final Client client;
        }
        CompatibilityMode compatibilityMode = clusterSettings.get(RemoteStoreNodeService.REMOTE_STORE_COMPATIBILITY_MODE_SETTING);
 * this file be licensed under the Apache-2.0 license or a
            return sourceIndexShardsNum;
                    client.admin()
                numShards = calculateTargetIndexShardsNum(resizeRequest.getMaxShardSize(), primaryShardsStoreStats, metadata);
                                + "] docs - too many documents in shards "
import org.opensearch.cluster.block.ClusterBlockLevel;
     * will be equal to the source index's shards count.
import org.opensearch.cluster.node.DiscoveryNode;
                                    response -> new ResizeResponse(
        final CreateIndexRequest targetIndex = resizeRequest.getTargetIndexRequest();
                        + " is not allowed as remote migration mode is mixed"
            client.admin()
     * Calculate target index's shards count according to max_shard_ize and the source index's storage(only primary shards included)
     * Reports the resize source index as the main resolved index. The target index is reported as sub-action "indices:admin/create".
        final IndexMetadata metadata = state.metadata().index(sourceIndexName);
import org.opensearch.core.index.shard.ShardId;
                .execute(ActionListener.delegateFailure(listener, (delegatedListener, indicesStatsResponse) -> {
import org.opensearch.action.support.ActionFilters;
        String cause = resizeRequest.getResizeType().name().toLowerCase(Locale.ROOT) + "_index";
                    );
     * @param maxShardSize the maximum size of a primary shard in the target index
import org.opensearch.cluster.service.ClusterService;
            if (splitFromSingleShards == false) {
import org.opensearch.index.IndexNotFoundException;
 * ownership. Elasticsearch licenses this file to you under
            } else {
        final ResizeType type,
            .put(targetIndex.settings())
     *                               is false, then throw IllegalStateException. If migration direction is [DocRep] and
        final ResizeRequest resizeRequest,
                                    )
            if (invalidConfiguration) {
}
     * Reject resize request if cluster mode is [Mixed] and migration direction is [RemoteStore] and index is not on
                                );
    }
    implements
        return ThreadPool.Names.SAME;
                Set<ShardId> shardIds = IndexMetadata.selectShrinkShards(i, metadata, numShards);
        targetIndexSettingsBuilder.remove(IndexMetadata.SETTING_HISTORY_UUID);
                        ActionListener.map(
                        .indices()
        final ActionListener<ResizeResponse> listener
        } else {
        Client client
    ) {
                                updateRequest.index()
            .aliases(targetIndex.aliases())
            if (resizeRequest.getResizeType() == ResizeType.SHRINK) {
                        }));
import org.opensearch.index.IndexModule;
        );
            .recoverFrom(metadata.getIndex())
    protected String getClusterManagerActionName(DiscoveryNode node) {
                                        + "]. Please wait for replication to complete and retry. Use the _cat/segment_replication/"
                                response.isShardsAcknowledged(),
        }
            }
            }
        if (compatibilityMode == CompatibilityMode.MIXED) {
                // we just execute this to ensure we get the right exceptions if the number of shards is wrong etc.
        final IntFunction<DocsStats> perShardDocStats,
 *     http://www.apache.org/licenses/LICENSE-2.0
                        )
    }
        // less than 1
    ) {
    protected static int calculateTargetIndexShardsNum(
        // there is no need to fetch docs stats for split but we keep it simple and do it anyway for simplicity of the code
            return 1;
                                )
import org.opensearch.node.remotestore.RemoteStoreNodeService;
/*
                                    "Replication still in progress for index ["
package org.opensearch.action.admin.indices.shrink;
                                        response.isAcknowledged(),
    @Override
 * KIND, either express or implied.  See the License for the
 */
        }
            threadPool,
 * license agreements. See the NOTICE file distributed with
    }
            .settings(targetIndex.settings())
import org.opensearch.action.admin.indices.create.CreateIndexClusterStateUpdateRequest;
        }
    protected ClusterBlockException checkBlock(ResizeRequest request, ClusterState state) {
     * maximum shard size requirement. If max_shard_size is less than the source index's single shard size, then target index's shards count
     *                               index's SETTING_REMOTE_STORE_ENABLED is true, then throw IllegalStateException.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            boolean isRemoteStoreEnabled = sourceIndexMetadata.getSettings().getAsBoolean(SETTING_REMOTE_STORE_ENABLED, false);
                .prepareRefresh(sourceIndex)
        // if minimum shards count is greater than the source index's shards count, then the source index's shards count will be returned
        final Settings.Builder targetIndexSettingsBuilder = Settings.builder()
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_REMOTE_STORE_ENABLED;
        // it will block target index's metadata writes and then cause the new shards to be unassigned,
                    + "] will be blocked by [index.blocks.read_only=true] which is copied from the source index ["
import java.util.Locale;
 *
import org.opensearch.cluster.metadata.ResolvedIndices;
                                return shard == null ? null : shard.getPrimary().getDocs();
    static CreateIndexClusterStateUpdateRequest prepareCreateIndexRequest(
                    }
import org.opensearch.cluster.block.ClusterBlockException;
    }
        TransportIndicesResolvingAction<ResizeRequest> {
        final String sourceIndex = resolveSourceIndex(resizeRequest);
                .indices()
        // find the lowest factor of the source index's shards count here, because minimum shards count may not be a factor
        int minValue = (int) Math.ceil((double) sourceIndexShardStoreStats.getSizeInBytes() / maxShardSize.getBytes());
    }
        if (maxShardSize == null
            indexNameExpressionResolver,
            || maxShardSize.getBytes() == 0
            transportService,
    }
        String sourceIndexName,
                numShards = metadata.getNumberOfShards();
            actionFilters,
                            createIndexService.createIndex(
            clusterService,
    // static for unittesting this method
import org.opensearch.node.remotestore.RemoteStoreNodeService.CompatibilityMode;
    ) {
                        IndexShardStats shard = indicesStatsResponse.getIndex(sourceIndex).getIndexShards().get(i);
                                ActionListener.map(
/*
        return state.blocks().indexBlockedException(ClusterBlockLevel.METADATA_WRITE, request.getTargetIndexRequest().index());
import org.opensearch.common.settings.ClusterSettings;
        // but if user overwrites the setting to `false` or `null`, everything is fine.
                );
            .clusterManagerNodeTimeout(targetIndex.clusterManagerNodeTimeout())
                .prepareStats(sourceIndex)
        TransportService transportService,
 *
    ) {
                }));
        // calculate the minimum shards count according to source index's storage, ceiling ensures that the minimum shards count is never
                                .getTotal()
        Client client
        for (int i = minValue; i < sourceIndexShardsNum; i++) {
        final ResizeRequest resizeRequest,
        MetadataCreateIndexService createIndexService,
        IndexMetadata indexMetadata = state.metadata().index(sourceIndex);
                            )
            .resizeType(resizeRequest.getResizeType())
                        );
        ClusterService clusterService,
                            }, indicesStatsResponse.getPrimaries().store, clusterSettings, sourceIndex, targetIndex);
 *
                        count += docsStats.getCount();
                        + type
            || sourceIndexShardStoreStats == null
     * @return target index's shards number
                .indices()
        // We should check the source index's setting `index.blocks.read_only`, because the setting will be copied to target index,
 * Modifications Copyright OpenSearch Contributors. See
        return indexNameExpressionResolver.resolveDateMathExpression(resizeRequest.getSourceIndex());
            numShards = IndexMetadata.INDEX_NUMBER_OF_SHARDS_SETTING.get(targetIndexSettings);
            .waitForActiveShards(targetIndex.waitForActiveShards())
        // we go async right away
        // We don't need to check the setting `index.blocks.metadata`, because it was checked when fetching index stats
                    createIndexService.createIndex(
        if (minValue >= sourceIndexShardsNum) {
                // we just execute this to ensure we get the right exceptions if the number of shards is wrong or less then etc.
                    CreateIndexClusterStateUpdateRequest updateRequest = prepareCreateIndexRequest(resizeRequest, state, i -> {
    }
    @Override
        }
            && state.metadata().isSegmentReplicationEnabled(sourceIndex)
            throw new IllegalArgumentException(
        final String targetIndex = resolveTargetIndex(resizeRequest);
import org.opensearch.cluster.ClusterState;
        TransportService transportService,
    protected String executor() {
                            delegatedListener,
                    }, indicesStatsResponse.getPrimaries().store, clusterSettings, sourceIndex, targetIndex);
import org.opensearch.index.IndexSettings;
        if (IndexMetadata.INDEX_NUMBER_OF_SHARDS_SETTING.exists(targetIndexSettings)) {
    ) {
            .copySettings(resizeRequest.getCopySettings() == null ? false : resizeRequest.getCopySettings());
        final StoreStats primaryShardsStoreStats,
 */
                    + "], this will disable metadata writes and cause the shards to be unassigned"
                    if (count > IndexWriter.MAX_DOCS) {
            // miss the mappings for everything is corrupted and hard to debug
import org.opensearch.index.shard.DocsStats;
        targetIndex.settings(settingsBuilder);
import org.opensearch.action.support.clustermanager.TransportClusterManagerNodeAction;
            final boolean splitFromSingleShards = resizeRequest.getResizeType() == ResizeType.SPLIT && metadata.getNumberOfShards() == 1;
            && IndexSettings.INDEX_SOFT_DELETES_SETTING.get(targetIndexSettings) == false) {
        }
                            CreateIndexClusterStateUpdateRequest updateRequest = prepareCreateIndexRequest(resizeRequest, state, i -> {
/**
        this.createIndexService = createIndexService;
    }
            boolean invalidConfiguration = (migrationDirection == Direction.REMOTE_STORE && isRemoteStoreEnabled == false)
public class TransportResizeAction extends TransportClusterManagerNodeAction<ResizeRequest, ResizeResponse>
    }
            assert resizeRequest.getResizeType() != ResizeType.SPLIT : "split must specify the number of shards explicitly";
 * The OpenSearch Contributors require contributions made to
                .setDocs(true)
                            response -> new ResizeResponse(
            || sourceIndexShardStoreStats.getSizeInBytes() == 0) {
    ) {
                || (migrationDirection == Direction.DOCREP && isRemoteStoreEnabled);
 */
                                    delegatedIndicesStatsListener,
            if (sourceIndexShardsNum % i == 0) {
            throw new IllegalArgumentException("Can't disable [index.soft_deletes.enabled] setting on resize");
    @Override
        MetadataCreateIndexService createIndexService,
            // if we have a source index with 1 shards it's legal to set this
 * Licensed to Elasticsearch under one or more contributor
                        throw new IllegalStateException(
            );
    /**
        final ClusterState state,
        }
                .clear()
import org.opensearch.threadpool.ThreadPool;
 *
            throw new IndexNotFoundException(sourceIndexName);
     */
     * @param type resize type
            && Integer.valueOf(indexMetadata.getSettings().get(SETTING_NUMBER_OF_REPLICAS)) > 0) {
            }
        }
                    if (docsStats != null) {
    public TransportResizeAction(
    }
import org.opensearch.index.store.StoreStats;
                throw new IllegalStateException(
                                        + " api to check if the index is up to date (e.g. bytes_behind == 0)."
     * REMOTE_STORE_ENABLED node or [DocRep] and index is on REMOTE_STORE_ENABLED node.
        IndexNameExpressionResolver indexNameExpressionResolver,
 * You may obtain a copy of the License at
        final int numShards;
import org.opensearch.common.settings.Settings;
 * the Apache License, Version 2.0 (the "License"); you may
    private String resolveTargetIndex(ResizeRequest resizeRequest) {
     *                               index's SETTING_REMOTE_STORE_ENABLED is not equal to the migration direction's value.
            } else {
        } else {
        ActionFilters actionFilters,
        return ResolvedIndices.of(resolveSourceIndex(resizeRequest))
        return sourceIndexShardsNum;
        this.client = client;
        }
            .ackTimeout(targetIndex.timeout())
        }
     */
 * this work for additional information regarding copyright
        settingsBuilder.put("index.number_of_shards", numShards);
/*
            // applied once we took the snapshot and if somebody messes things up and switches the index read/write and adds docs we
            && IndexMetadata.INDEX_READ_ONLY_SETTING.exists(targetIndexSettings) == false) {
import java.util.Objects;
    protected ResizeResponse read(StreamInput in) throws IOException {
    }
        }
import org.opensearch.common.inject.Inject;
 * @opensearch.internal
import org.opensearch.transport.client.Client;
        return super.getClusterManagerActionName(node);
        ActionFilters actionFilters,
                }
        for (int i = 0; i < numShards; i++) {
                                        + sourceIndex
        if (metadata == null) {
import org.opensearch.core.common.unit.ByteSizeValue;
     * @param clusterSettings cluster settings
     * for shrink. Target index's shards count is the lowest factor of the source index's primary shards count which satisfies the
    public ResolvedIndices resolveIndices(ResizeRequest resizeRequest) {
            // mappings are updated on the node when creating in the shards, this prevents race-conditions since all mapping must be
    protected TransportResizeAction(
        String targetIndexName
            && indexMetadata != null
            if (resizeRequest.getResizeType() == ResizeType.SHRINK) {
        ClusterService clusterService,
        if (IndexMetadata.INDEX_READ_ONLY_SETTING.get(metadata.getSettings()) == true
                            if (indicesStatsResponse.getIndex(sourceIndex)
import org.opensearch.action.admin.indices.create.CreateIndexRequest;
        }
                for (ShardId id : shardIds) {
                                + IndexWriter.MAX_DOCS
                throw new IllegalArgumentException("cannot provide index.number_of_routing_shards on resize");
            client.admin()
import java.util.Set;
            ResizeAction.NAME,
 * GitHub history for details.
        ThreadPool threadPool,
        IndexMetadata sourceIndexMetaData
        if (indexMetadata.getSettings().getAsBoolean(IndexModule.IS_WARM_INDEX_SETTING.getKey(), false) == true) {
 * SPDX-License-Identifier: Apache-2.0
                                updateRequest,
    /**
        final ClusterState state,
                    DocsStats docsStats = perShardDocStats.apply(id.id());
                return i;
        ClusterSettings clusterSettings
                .setStore(true)
                                response.isAcknowledged(),
    @Override
                .execute(ActionListener.delegateFailure(listener, (delegatedRefreshListener, refreshResponse) -> {
            client
                        + (isRemoteStoreEnabled ? "enabled" : "disabled")
        IndexMetadata sourceIndexMetadata,
    private String resolveSourceIndex(ResizeRequest resizeRequest) {
        validateRemoteMigrationModeSettings(resizeRequest.getResizeType(), metadata, clusterSettings);
            && IndexSettings.INDEX_SOFT_DELETES_SETTING.exists(targetIndexSettings)
                        .setDocs(true)
                    }
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.cluster.metadata.MetadataCreateIndexService;
import java.util.function.IntFunction;
                        .setStore(true)
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_REPLICAS;
    }
            Direction migrationDirection = clusterSettings.get(RemoteStoreNodeService.MIGRATION_DIRECTION_SETTING);
        IndexNameExpressionResolver indexNameExpressionResolver,
import java.io.IOException;
import org.opensearch.transport.TransportService;
    protected void clusterManagerOperation(
        return new ResizeResponse(in);
                                        response.isShardsAcknowledged(),
        String actionName,
 * compatible open source license.
     *                               For example, if migration direction is [RemoteStore] and index's SETTING_REMOTE_STORE_ENABLED
                    "Index "
        final ClusterSettings clusterSettings,
            }
    }
     * @param sourceIndexMetaData source index's metadata
        ByteSizeValue maxShardSize,
     * @throws IllegalStateException if cluster mode is [Mixed] and migration direction is [RemoteStore] or [DocRep] and
    @Override
            } else if (resizeRequest.getResizeType() == ResizeType.SPLIT) {
 */
import org.opensearch.cluster.metadata.IndexMetadata;
     * @param sourceIndexMetadata source index's metadata
        final Settings targetIndexSettings = targetIndexSettingsBuilder.build();
            .withLocalSubActions(CreateIndexAction.INSTANCE, ResolvedIndices.Local.of(resolveTargetIndex(resizeRequest)));
                        .setSegments(true)
 * not use this file except in compliance with the License.
                        .prepareStats(sourceIndex)
import org.opensearch.action.admin.indices.create.CreateIndexAction;
        ThreadPool threadPool,
            }
                                .getReplicationStats().maxBytesBehind != 0) {
        this(
                        .execute(ActionListener.delegateFailure(listener, (delegatedIndicesStatsListener, indicesStatsResponse) -> {
        return new CreateIndexClusterStateUpdateRequest(cause, targetIndex.index(), targetIndexName)
