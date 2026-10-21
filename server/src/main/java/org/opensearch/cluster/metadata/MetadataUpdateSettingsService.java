 * license agreements. See the NOTICE file distributed with
     */
        AllocationService allocationService,
                    for (Map.Entry<String, Tuple<Version, String>> entry : request.versions().entrySet()) {
            ) {
            } else {
            ) {
        IndexScopedSettings indexScopedSettings,
                                            Settings.builder()
    }
                            IndexMetadata.SETTING_NUMBER_OF_REPLICAS,
                                        IndexMetadata.INDEX_NUMBER_OF_REPLICAS_SETTING.get(Settings.EMPTY)
                            clusterService.getClusterSettings(),
 *
    private final ClusterService clusterService;
            }
        if (updatedNumberOfSearchReplicas > 0) {
                || isArchived
                        actualIndices[i] = index.getName();
                    }
            "update-settings " + Arrays.toString(request.indices()),
import static org.opensearch.cluster.metadata.MetadataCreateIndexService.validateTranslogFlushIntervalSettingsForCompositeIndex;
                        Settings indexSettings;
                                        updatedNumberOfSearchReplicas,
                                if (index.getName().charAt(0) != '.') {
    /**
import org.opensearch.cluster.routing.allocation.AwarenessReplicaBalance;
                    + " isWildcard: "
                            if (Version.CURRENT.equals(indexMetadata.getCreationVersion()) == false) {
        if (setting.exists(openSettings)) {
                throw new IllegalArgumentException("Cannot change store type to 'cryptofs' for index [" + index.getName() + "]");
                        throw new IllegalArgumentException(
                }
     * @param indices indices that are changing
 * KIND, either express or implied.  See the License for the
 * Service responsible for submitting update index settings requests
        return replicaIncrease * shardsInIndex;
                            }
                                 * including updating it to null, indicating that they want to use the default value. In this case, we again
        clusterService.submitStateUpdateTask(
                        String index = entry.getKey();
                }
                        exception.addValidationErrors(validationErrors);
                    RoutingTable.Builder routingTableBuilder = RoutingTable.builder(currentState.routingTable());
                throw new IllegalArgumentException(
            String newStoreType = indexSettings.get(storeTypeKey);
                        for (String index : actualIndices) {
                        }
        this.clusterService = clusterService;
                    if (!closeIndices.isEmpty()) {
                                Settings finalSettings = indexSettings.build();
 * Modifications Copyright OpenSearch Contributors. See
 *     http://www.apache.org/licenses/LICENSE-2.0
        Collection<DiscoveryNode> nodes = clusterService.state().nodes().getNodes().values();
                            indicesService.verifyIndexMetadata(currentMetadata, updatedMetadata);
                                 * not set. A user can update this setting though, including updating it to null, indicating that they want to
                                 * The setting index.number_of_replicas is special; we require that this setting has a value in the index. When
                        changed = true;
        }
                            // Verify that this won't take us over the cluster shard limit.
    private final ShardLimitValidator shardLimitValidator;
            }
import org.opensearch.cluster.service.ClusterService;
    }
                        }
                    if (!openIndices.isEmpty()) {
                    // increment settings versions
        final UpdateSettingsClusterStateUpdateRequest request,
                            changed = true;
                            metadataBuilder.updateNumberOfReplicas(updatedNumberOfReplicas, actualIndices);
                    for (int i = 0; i < request.indices().length; i++) {
                Priority.URGENT,
                                );
import org.opensearch.action.admin.indices.settings.put.UpdateSettingsClusterStateUpdateRequest;
 * software distributed under the License is distributed on an
import java.util.HashSet;
        // Get the setting value
import org.opensearch.cluster.node.DiscoveryNode;
            boolean isArchived = key.startsWith(ARCHIVED_SETTINGS_PREFIX);
                        }
        indexScopedSettings.validate(
    @Inject
 * specific language governing permissions and limitations
                            shardLimitValidator.validateShardLimitForIndices(
                        }
import java.util.ArrayList;
                        }
            new AckedClusterStateUpdateTask<ClusterStateUpdateResponse>(
import org.opensearch.core.action.ActionListener;
import org.opensearch.cluster.ClusterState;
    private AwarenessReplicaBalance awarenessReplicaBalance;
import org.opensearch.cluster.routing.RoutingTable;
import org.opensearch.cluster.block.ClusterBlock;
        if (!isRemoteSegmentStoreEnabled) {
    public static void validateIndexTotalPrimaryShardsPerNodeSetting(Settings indexSettings, ClusterService clusterService) {
        this.awarenessReplicaBalance = awarenessReplicaBalance;
                        final int updatedNumberOfSearchReplicas = IndexMetadata.INDEX_NUMBER_OF_SEARCH_REPLICAS_SETTING.get(openSettings);
            return;
                                normalizedSettings.keySet(),
                    // allow to change any settings to a close index, and only allow dynamic settings to be changed
     *
                } else {
                    + INDEX_TOTAL_PRIMARY_SHARDS_PER_NODE_SETTING.getKey()
                        validateSearchReplicaCountSettings(normalizedSettings, request.indices(), currentState);
                                    false, // ignorePrivateSettings
                            if (indexScopedSettings.updateSettings(closedSettings, indexSettings, updates, index.getName())) {
import org.opensearch.common.ValidationException;
                            Settings.Builder updates = Settings.builder();
import java.util.List;
                        .build();
        }
     */
                                    true  // ignoreArchivedSettings
        // Only validate if store.type is being explicitly modified
                                 * creating the index, we ensure this by explicitly providing a value for the setting to the default (one) if
                    }
                                }
                                    finalSettings.filter(k -> indexScopedSettings.isPrivateSetting(k) == false),
        final Settings normalizedSettings = Settings.builder()
        int indexPrimaryShardsPerNode = INDEX_TOTAL_PRIMARY_SHARDS_PER_NODE_SETTING.get(indexSettings);
                public ClusterState execute(ClusterState currentState) {
                request,
            true
                                }
                            validateOverlap(
                                        .settings(
                                // no reason to pollute the settings, we didn't really upgrade anything
public class MetadataUpdateSettingsService {
                    }
                    final String[] actualIndices = new String[request.indices().length];
 * ownership. Elasticsearch licenses this file to you under
                            logger.info("updating number_of_replicas to [{}] for indices {}", updatedNumberOfReplicas, actualIndices);
                    } catch (IOException ex) {
    private static final Logger logger = LogManager.getLogger(MetadataUpdateSettingsService.class);
                                indexScopedSettings.validate(
        validateCryptoStoreSettings(normalizedSettings, request.indices(), clusterService.state());
                                "Can't update non dynamic settings [%s] for open indices %s",
                            String.format(
            for (String index : actualIndices) {
        final Settings closedSettings = settingsForClosedIndices.build();
                        final IndexMetadata metadata = currentState.metadata().getIndexSafe(index);
                    }
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_REMOTE_STORE_ENABLED;
     * Updates the cluster block only iff the setting exists in the given settings
                    ClusterState updatedState = ClusterState.builder(currentState)
                        ).ifPresent(validationErrors::add);
package org.opensearch.cluster.metadata;
                            ).ifPresent(validationErrors::add);
                            // Verify that this won't take us over the cluster shard limit.
                            metadata.getSettings()
                            Settings.Builder indexSettings = Settings.builder().put(indexMetadata.getSettings());
                            Settings.Builder indexSettings = Settings.builder().put(indexMetadata.getSettings());
                            metadataBuilder.updateNumberOfSearchReplicas(updatedNumberOfSearchReplicas, actualIndices);
        ShardLimitValidator shardLimitValidator,
            Setting setting = indexScopedSettings.get(key);
                                    indexSettings.put(indexMetadata.getSettings());
                                    // No replica count validation for system indices
                        validateTranslogFlushIntervalSettingsForCompositeIndex(
                            indicesService.verifyIndexMetadata(updatedMetadata, updatedMetadata);
                                index.getName()
import org.opensearch.common.settings.Settings;
                                        updatedNumberOfReplicas,
            }
                                }
 * The OpenSearch Contributors require contributions made to
                                updatedNumberOfSearchReplicas,
            if ("cryptofs".equals(currentStoreType) && !"cryptofs".equals(newStoreType)) {
                            openIndices.add(index);
                                    );
                        if (indexMetadata != null) {
                                }
                settingsForOpenIndices.copy(key, normalizedSettings);
 * GitHub history for details.
                                "updating number_of_Search Replicas to [{}] for indices {}",
                                metadataBuilder.put(IndexMetadata.builder(indexMetadata).settings(finalSettings));
                                currentState,
                                 * have to provide an explicit value for the setting to the default (one).
                }
import org.opensearch.Version;
                @Override
            "update-index-compatibility-versions",
            .build();
                    for (IndexMetadata.APIBlock block : IndexMetadata.APIBlock.values()) {
    /**
                    "To set " + SETTING_NUMBER_OF_SEARCH_REPLICAS + ", " + SETTING_REMOTE_STORE_ENABLED + " must be set to true"
        Settings openSettings
    }
    private void validateSearchReplicaCountSettings(Settings requestSettings, Index[] indices, ClusterState currentState) {
                                    indexSettings.put(indexMetadata.getSettings());
                            shardLimitValidator.validateShardLimitForIndices(
                                        IndexMetadata.SETTING_NUMBER_OF_REPLICAS,
import java.util.Optional;
                        final int updatedNumberOfReplicas = openSettings.getAsInt(
                    }
                            MetadataCreateIndexService.validateStoreTypeSettings(indexSettings);
                if (updateBlock) {
            return;
 * this work for additional information regarding copyright
                        for (Index index : openIndices) {
                                /*
                    }
import org.opensearch.cluster.service.ClusterManagerTaskThrottler;
                                    }
                }
                                        .settingsVersion(1 + indexMetadata.getSettingsVersion())
import org.opensearch.common.Priority;
                            final IndexMetadata updatedMetadata = updatedState.metadata().getIndexSafe(index);
            settingsForClosedIndices.copy(key, normalizedSettings);
                            IndexMetadata indexMetadata = metadataBuilder.getSafe(index);
            }
    }
        if (indexPrimaryShardsPerNode == -1 && indexRemoteCapablePrimaryShardsPerNode == -1) {
                                metadataBuilder.put(
                    if (!skippedSettings.isEmpty() && !openIndices.isEmpty()) {
import org.opensearch.common.collect.Tuple;
    private static boolean maybeUpdateClusterBlock(
                                /*
/*
                    if (IndexMetadata.INDEX_NUMBER_OF_REPLICAS_SETTING.exists(openSettings)) {
        int replicaIncrease = updatedNumberOfReplicas - oldNumberOfReplicas;
import org.opensearch.core.index.Index;
                    "Cannot change store type from 'cryptofs' for index [" + index.getName() + "] - cryptofs store type is immutable"
            // Prevent changing FROM cryptofs to anything else (including null)
                                 * use the value configured by cluster settings or a default value 1. In this case, we again have to provide
import org.opensearch.indices.ShardLimitValidator;
                                        ex.addValidationError(error.get());
                request,
                                openIndices
            normalizedSettings.filter(s -> Regex.isSimpleMatchPattern(s) == false), // don't validate wildcards
                                 * The setting index.number_of_replicas is special; we require that this setting has a value in the index. When
                    + INDEX_TOTAL_REMOTE_CAPABLE_PRIMARY_SHARDS_PER_NODE_SETTING.getKey()
                        .blocks(blocks)
                    return ClusterState.builder(currentState).metadata(metadataBuilder).build();
                            final IndexMetadata currentMetadata = currentState.getMetadata().getIndexSafe(index);
     */
                    if (blocks.hasIndexBlock(index, block) == false) {
                        if (same(currentState.metadata().index(index).getSettings(), metadataBuilder.get(index).getSettings()) == false) {
        // would additionally demand a cluster state repository, which segments_only nodes never configure.
                            // Now check that we can create the index with the updated settings (dynamic and non-dynamic).
                public ClusterState execute(ClusterState currentState) {
                            normalizedSettings,
 * @opensearch.internal
                    if (IndexSettings.INDEX_TRANSLOG_RETENTION_AGE_SETTING.exists(normalizedSettings)
                    Metadata.Builder metadataBuilder = Metadata.builder(currentState.metadata());
            if (Arrays.stream(indices)
                                 * an explicit value for the setting.
        // Task is onboarded for throttling, it will get retried from associated TransportClusterManagerNodeAction.
                                        AutoExpandSearchReplicas.SETTING.get(openSettings)
                                    if (error.isPresent()) {
                            final IndexMetadata updatedMetadata = updatedState.metadata().getIndexSafe(index);
        final Set<String> skippedSettings = new HashSet<>();
        ClusterBlocks.Builder blocks,
                             * TODO: should we update the in-sync allocation IDs once the data is deleted by the node?
import org.opensearch.threadpool.ThreadPool;
                    // now, reroute in case things change that require it (like number of replicas)
                    + isWildcard
                                        throw ex;
                        for (Index index : closeIndices) {
                }
                                    finalSettings.filter(k -> indexScopedSettings.isPrivateSetting(k) == false),
    public void updateSettings(
     * Validates the 'index.routing.allocation.total_primary_shards_per_node' setting during index settings update.
        final ActionListener<ClusterStateUpdateResponse> listener
                        }
        // (allMatch is vacuously true on an empty node set, which must not count as remote-store enabled). Balancing
}
                        if (preserveExisting == false) {
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_SEARCH_REPLICAS;
        validateTranslogDurabilitySettings(normalizedSettings, clusterService.getClusterSettings(), clusterService.getSettings());
                            for (Index index : request.indices()) {
import static org.opensearch.cluster.metadata.MetadataCreateIndexService.validateTranslogDurabilitySettings;
                                    // No replica count validation for system indices
        this.indexScopedSettings = indexScopedSettings;
                                 * there is no value provided on the source of the index creation or "cluster.default_number_of_replicas" is
        final String storeTypeKey = "index.store.type";
                                if (IndexMetadata.INDEX_NUMBER_OF_REPLICAS_SETTING.exists(indexSettings) == false) {
 *
import org.opensearch.indices.IndicesService;
import org.opensearch.action.admin.indices.upgrade.post.UpgradeSettingsClusterStateUpdateRequest;
            // Only allow dynamic settings and wildcards for open indices. Skip archived settings.
                                    indexSettings.put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, defaultReplicaCount);
import static org.opensearch.cluster.metadata.MetadataIndexTemplateService.findComponentTemplate;
        final boolean preserveExisting = request.isPreserveExisting();
import org.opensearch.ExceptionsHelper;
        // primaries is a placement concern, so it only requires the segments to be remote backed; isRemoteStoreNode()
                            defaultReplicaCount
                        if (preserveExisting == false) {
        for (Index index : indices) {
/*
import java.util.Arrays;
    private final AllocationService allocationService;
import java.util.Collection;
                                skippedSettings,
    ) {
        this.indicesService = indicesService;
    private final IndexScopedSettings indexScopedSettings;
        ClusterBlock block,
                                request.indices(),
import org.opensearch.common.inject.Inject;
import static org.opensearch.cluster.service.ClusterManagerTask.UPDATE_SETTINGS;
        }
                skippedSettings.add(key);
                    }
                    }
        if (!indexSettings.keySet().contains(storeTypeKey)) {
                    if (validationErrors.size() > 0) {
/*
                                    IndexMetadata.builder(indexMetadata)
    public void upgradeIndexSettings(
        );
                        .routingTable(routingTableBuilder.build())
                    Set<Index> closeIndices = new HashSet<>();
                                    true, // validateDependencies
        validateIndexTotalPrimaryShardsPerNodeSetting(normalizedSettings, clusterService);
                    if (blocks.hasIndexBlock(index, block)) {
                             */
                    }
                .allMatch(
                             * these copies stale.
                            indexSettings = metadataBuilder.get(index).getSettings();
                    Set<Index> openIndices = new HashSet<>();
                    + "] or ["
            throw new IllegalArgumentException(
import static org.opensearch.action.support.ContextPreservingActionListener.wrapPreservingContext;
                            final IndexMetadata.Builder builder = IndexMetadata.builder(metadataBuilder.get(index));
                                    false, // ignorePrivateSettings
    }
            // Prevent changing TO cryptofs from any other type
    }
                @Override
                        blocks.addIndexBlock(index, block);
            assert setting != null // we already validated the normalized settings
                    }
                        changed = true;
            boolean isWildcard = setting == null && Regex.isSimpleMatchPattern(key);
                                request.indices(),
        final Settings openSettings = settingsForOpenIndices.build();
 */
        boolean changed = false;
 * under the License.
                                    if (error.isPresent()) {
        this.threadPool = threadPool;
    ) {
                    + normalizedSettings.hasValue(key);
                            // validate storeType for deprecating index stores
                            routingTableBuilder.updateNumberOfReplicas(updatedNumberOfReplicas, actualIndices);
                                if (preserveExisting) {
                            /*
                            IndexMetadata indexMetadata = metadataBuilder.getSafe(index);
                        blocks.removeIndexBlock(index, block);
import java.util.Locale;
import static org.opensearch.cluster.metadata.MetadataCreateIndexService.validateOverlap;
                @Override
                        for (Index index : openIndices) {
                        );
    private final ThreadPool threadPool;
 * Unless required by applicable law or agreed to in writing,
                    }
                        Index index = request.indices()[i];
import org.opensearch.common.settings.Setting;
                                    Optional<String> error = awarenessReplicaBalance.validate(
                            builder.settingsVersion(1 + builder.settingsVersion());
        }
                        }
        }
                    final ClusterBlocks.Builder blocks = ClusterBlocks.builder().blocks(currentState.blocks());
    private final ClusterManagerTaskThrottler.ThrottlingKey updateSettingsTaskKey;
                                }
                                currentState,
                        return currentState;
                                        AutoExpandReplicas.SETTING.get(openSettings)
                                    }
                                    true, // validateDependencies
                        || IndexSettings.INDEX_TRANSLOG_RETENTION_SIZE_SETTING.exists(normalizedSettings)) {
        updateSettingsTaskKey = clusterService.registerClusterManagerTask(UPDATE_SETTINGS, true);
                @Override
                        if (metadata.getState() == IndexMetadata.State.OPEN) {
                                actualIndices
                                                .put(indexMetadata.getSettings())
 * Licensed to Elasticsearch under one or more contributor
                                 * there is a not value provided on the source of the index creation. A user can update this setting though,
import org.apache.logging.log4j.Logger;
                );
                                    true  // ignoreArchivedSettings
                                if (IndexMetadata.INDEX_NUMBER_OF_REPLICAS_SETTING.exists(indexSettings) == false) {
                                );
    /**
            final boolean updateBlock = setting.get(openSettings);
                || (isWildcard && normalizedSettings.hasValue(key) == false) : "unknown setting: "
 * SPDX-License-Identifier: Apache-2.0
 *
import java.util.Set;
                throw new IllegalArgumentException(
                             *
    ) {
                            routingTableBuilder.updateNumberOfSearchReplicas(updatedNumberOfSearchReplicas, actualIndices);
                        .metadata(metadataBuilder)
                                index -> getTotalNewShards(index, currentState, updatedNumberOfReplicas)
        AwarenessReplicaBalance awarenessReplicaBalance
                            for (Index index : request.indices()) {
     */
                                Locale.ROOT,
                        throw exception;
            false, // don't validate dependencies here we check it below never allow to change the number of shards
        }
        ClusterService clusterService,
                wrapPreservingContext(listener, threadPool.getThreadContext())
                    if (changed == false) {
import org.opensearch.index.IndexSettings;
                            indicesService.verifyIndexMetadata(currentMetadata, updatedMetadata);
                            // This step is mandatory since we allow to update non-dynamic settings on closed indices.
        ); // validate internal or private index settings
                            if (indexScopedSettings.updateDynamicSettings(openSettings, indexSettings, updates, index.getName())) {
        // If default value (-1), no validation needed
                                if (preserveExisting) {
                    final List<String> validationErrors = new ArrayList<>();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        String[] actualIndices,
        ThreadPool threadPool,
                    }
                            );
import org.opensearch.cluster.routing.allocation.AllocationService;
                            final IndexMetadata currentMetadata = currentState.getMetadata().getIndexSafe(index);
 */
                    try {
                        );
        int shardsInIndex = indexMetadata.getNumberOfShards();
import static org.opensearch.cluster.routing.allocation.decider.ShardsLimitAllocationDecider.INDEX_TOTAL_REMOTE_CAPABLE_PRIMARY_SHARDS_PER_NODE_SETTING;
import org.opensearch.cluster.AckedClusterStateUpdateTask;
            }
 */
                                    indexSettings.put(
                                        throw ex;
                Priority.URGENT,
                @Override
            }
            String currentStoreType = clusterState.metadata().getIndexSafe(index).getSettings().get(storeTypeKey, "");
            }
                        }
                                indexScopedSettings.validate(
            );
 * the Apache License, Version 2.0 (the "License"); you may
        final ActionListener<ClusterStateUpdateResponse> listener
                protected ClusterStateUpdateResponse newResponse(boolean acknowledged) {
        // Remote store is enabled only when there is at least one node and every node has a remote segment store
        int indexRemoteCapablePrimaryShardsPerNode = INDEX_TOTAL_REMOTE_CAPABLE_PRIMARY_SHARDS_PER_NODE_SETTING.get(indexSettings);
                            }
                                findComponentTemplate(currentState.metadata(), metadata.context()).template().settings(),
                        changed |= maybeUpdateClusterBlock(actualIndices, blocks, block.block, block.setting, openSettings);
                                metadataBuilder.put(IndexMetadata.builder(indexMetadata).settings(finalSettings));
                                if (index.getName().charAt(0) != '.') {
                            metadataBuilder.put(builder);
                    + "] can only be used with remote store enabled clusters"
                    return updatedState;
                                );
                             * We do not update the in-sync allocation IDs as they will be removed upon the first index operation which makes
    private int getTotalNewShards(Index index, ClusterState currentState, int updatedNumberOfReplicas) {
                ) == false) {
            new AckedClusterStateUpdateTask<ClusterStateUpdateResponse>(
            .put(request.settings())
            .normalizePrefix(IndexMetadata.INDEX_SETTING_PREFIX)
                );
                        if (metadata.context() != null) {
                            }
                    }
                            // Verifies that the current index settings can be updated with the updated dynamic settings.
/**
    }
     * @param requestSettings {@link Settings}
                            }
                            );
                    // on an open index
                    if (IndexMetadata.INDEX_NUMBER_OF_SEARCH_REPLICAS_SETTING.exists(openSettings)) {
        boolean isRemoteSegmentStoreEnabled = !nodes.isEmpty() && nodes.stream().allMatch(DiscoveryNode::isRemoteSegmentStoreNode);
                                 * creating the index, we ensure this by explicitly providing a value for the setting to the default (one) if
import static org.opensearch.cluster.routing.allocation.decider.ShardsLimitAllocationDecider.INDEX_TOTAL_PRIMARY_SHARDS_PER_NODE_SETTING;
                    }
     * Validates crypto store settings are immutable after index creation.
                            closeIndices.add(index);
            true, // Ignore archived setting.
                                 */
 * You may obtain a copy of the License at
                wrapPreservingContext(listener, threadPool.getThreadContext())
 * this file be licensed under the Apache-2.0 license or a
                public ClusterManagerTaskThrottler.ThrottlingKey getClusterManagerThrottlingKey() {
        }
 * compatible open source license.
import java.util.Map;
            false,
        final int defaultReplicaCount = clusterService.getClusterSettings().get(Metadata.DEFAULT_REPLICA_COUNT_SETTING);
     * @param currentState {@link ClusterState} current cluster state
                        }
                    return updateSettingsTaskKey;
                                Settings finalSettings = indexSettings.build();
                        IndexMetadata indexMetadata = metadataBuilder.get(index);
                            );
import org.opensearch.cluster.ack.ClusterStateUpdateResponse;
        IndicesService indicesService,
                                        ValidationException ex = new ValidationException();
        return changed;
                        } else {
 */
                                        ex.addValidationError(error.get());
                    Metadata.Builder metadataBuilder = Metadata.builder(currentState.metadata());
            if (!"cryptofs".equals(currentStoreType) && "cryptofs".equals(newStoreType)) {
                                    );
        final int updatedNumberOfSearchReplicas = IndexMetadata.INDEX_NUMBER_OF_SEARCH_REPLICAS_SETTING.get(requestSettings);
                                 */
import static org.opensearch.index.IndexSettings.same;
                        ValidationException exception = new ValidationException();
        Settings.Builder settingsForOpenIndices = Settings.builder();
                    boolean changed = false;
                    updatedState = allocationService.reroute(updatedState, "settings update");
import java.io.IOException;
import static org.opensearch.cluster.metadata.MetadataCreateIndexService.validateRefreshIntervalSettings;
        );
                                        ValidationException ex = new ValidationException();
                "Setting ["
                                                .put(IndexMetadata.SETTING_VERSION_UPGRADED, entry.getValue().v1())
    public static void validateCryptoStoreSettings(Settings indexSettings, Index[] indices, ClusterState clusterState) {
                        for (Index index : closeIndices) {
    /**
                    }
        int oldNumberOfReplicas = indexMetadata.getNumberOfReplicas();
        IndexMetadata indexMetadata = currentState.metadata().index(index);
        final UpgradeSettingsClusterStateUpdateRequest request,
     * Validates that if we are trying to update search replica count the index is segrep enabled.
import org.apache.logging.log4j.LogManager;
                    for (final String index : actualIndices) {
    }
                }
                                        )
                                    Optional<String> error = awarenessReplicaBalance.validate(
    public MetadataUpdateSettingsService(
        clusterService.submitStateUpdateTask(
    ) {
        for (String key : normalizedSettings.keySet()) {
    private final IndicesService indicesService;
            if (isArchived == false && (isWildcard || setting.isDynamic())) {
        Setting<Boolean> setting,
                    index -> currentState.metadata().index(index.getName()).getSettings().getAsBoolean(SETTING_REMOTE_STORE_ENABLED, false)
                    return new ClusterStateUpdateResponse(acknowledged);
                            logger.info(
                                index -> getTotalNewShards(index, currentState, updatedNumberOfSearchReplicas)
                    return new ClusterStateUpdateResponse(acknowledged);
                        throw ExceptionsHelper.convertToOpenSearchException(ex);
                    + " hasValue: "
     * Ensures this setting can only be modified for existing indices in remote store enabled clusters.
import org.opensearch.common.settings.IndexScopedSettings;
                    + key
                            }
        this.allocationService = allocationService;
                                    );
import static org.opensearch.common.settings.AbstractScopedSettings.ARCHIVED_SETTINGS_PREFIX;
import org.opensearch.cluster.block.ClusterBlocks;
 * not use this file except in compliance with the License.
                            Settings.Builder updates = Settings.builder();
                            MetadataCreateIndexService.validateTranslogRetentionSettings(indexSettings);
                protected ClusterStateUpdateResponse newResponse(boolean acknowledged) {
                            )
                                }
        Settings.Builder settingsForClosedIndices = Settings.builder();
        validateRefreshIntervalSettings(normalizedSettings, clusterService.getClusterSettings());
 *
import org.opensearch.common.regex.Regex;
                        }
        this.shardLimitValidator = shardLimitValidator;
                        }
