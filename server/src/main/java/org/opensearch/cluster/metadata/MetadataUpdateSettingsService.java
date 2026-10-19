                        Settings indexSettings;
                            // Now check that we can create the index with the updated settings (dynamic and non-dynamic).
                wrapPreservingContext(listener, threadPool.getThreadContext())
                        .blocks(blocks)
import org.opensearch.index.IndexSettings;
            }  
                            );
import java.util.Locale;  
                    }
                ) == false) {
                        final int updatedNumberOfSearchReplicas = IndexMetadata.INDEX_NUMBER_OF_SEARCH_REPLICAS_SETTING.get(openSettings);  
                            metadataBuilder.updateNumberOfReplicas(updatedNumberOfReplicas, actualIndices);
            String currentStoreType = clusterState.metadata().getIndexSafe(index).getSettings().get(storeTypeKey, "");
                                if (index.getName().charAt(0) != '.') {  
        Settings.Builder settingsForClosedIndices = Settings.builder();
                        throw ExceptionsHelper.convertToOpenSearchException(ex);
        this.indicesService = indicesService;
import org.opensearch.core.index.Index;  
                    return ClusterState.builder(currentState).metadata(metadataBuilder).build();
                            builder.settingsVersion(1 + builder.settingsVersion());  
 * GitHub history for details.
                        for (Index index : closeIndices) {
                        validateSearchReplicaCountSettings(normalizedSettings, request.indices(), currentState);
                if (updateBlock) {
    public void updateSettings(
                    for (Map.Entry<String, Tuple<Version, String>> entry : request.versions().entrySet()) {
                                if (IndexMetadata.INDEX_NUMBER_OF_REPLICAS_SETTING.exists(indexSettings) == false) {
                                );  
    private void validateSearchReplicaCountSettings(Settings requestSettings, Index[] indices, ClusterState currentState) {
                } else {  
                                        ValidationException ex = new ValidationException();
    ) {
            return;
                        }
import org.apache.logging.log4j.Logger;
            }  
        Settings.Builder settingsForOpenIndices = Settings.builder();
                                    }
                );  
                            shardLimitValidator.validateShardLimitForIndices(
import org.opensearch.common.settings.Settings;
        final Settings openSettings = settingsForOpenIndices.build();  
                            final IndexMetadata currentMetadata = currentState.getMetadata().getIndexSafe(index);
                                }  
                        }
                                    indexSettings.put(  
                        actualIndices[i] = index.getName();
                                    }
                public ClusterState execute(ClusterState currentState) {
        int oldNumberOfReplicas = indexMetadata.getNumberOfReplicas();  
package org.opensearch.cluster.metadata;
 */  
                                    false, // ignorePrivateSettings
        );  
                        throw exception;  
                                        IndexMetadata.SETTING_NUMBER_OF_REPLICAS,
                                if (index.getName().charAt(0) != '.') {  
                        );  
                                }  
                                 * creating the index, we ensure this by explicitly providing a value for the setting to the default (one) if
                            }
        }
                            ).ifPresent(validationErrors::add);
     */
import org.opensearch.common.settings.IndexScopedSettings;
                        ValidationException exception = new ValidationException();
            false, // don't validate dependencies here we check it below never allow to change the number of shards
                                    true, // validateDependencies
                                /*
                }
                            validateOverlap(
import org.opensearch.cluster.service.ClusterManagerTaskThrottler;
 * this work for additional information regarding copyright
                                 * there is a not value provided on the source of the index creation. A user can update this setting though,
                    final ClusterBlocks.Builder blocks = ClusterBlocks.builder().blocks(currentState.blocks());
 * license agreements. See the NOTICE file distributed with
import org.opensearch.cluster.block.ClusterBlocks;
     * @param requestSettings {@link Settings}
                        if (indexMetadata != null) {
                    + "] can only be used with remote store enabled clusters"  
import java.util.Collection;  
                wrapPreservingContext(listener, threadPool.getThreadContext())
                            String.format(
            .normalizePrefix(IndexMetadata.INDEX_SETTING_PREFIX)
            throw new IllegalArgumentException(
        validateRefreshIntervalSettings(normalizedSettings, clusterService.getClusterSettings());
                        changed |= maybeUpdateClusterBlock(actualIndices, blocks, block.block, block.setting, openSettings);
 */
    private int getTotalNewShards(Index index, ClusterState currentState, int updatedNumberOfReplicas) {  
    private final ClusterManagerTaskThrottler.ThrottlingKey updateSettingsTaskKey;
     * @param indices indices that are changing
import static org.opensearch.cluster.routing.allocation.decider.ShardsLimitAllocationDecider.INDEX_TOTAL_PRIMARY_SHARDS_PER_NODE_SETTING;
                            IndexMetadata indexMetadata = metadataBuilder.getSafe(index);
                                        ex.addValidationError(error.get());  
            new AckedClusterStateUpdateTask<ClusterStateUpdateResponse>(
import static org.opensearch.common.settings.AbstractScopedSettings.ARCHIVED_SETTINGS_PREFIX;
    public MetadataUpdateSettingsService(
                                Locale.ROOT,  
                    }
                                    indexSettings.put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, defaultReplicaCount);
                    "Cannot change store type from 'cryptofs' for index [" + index.getName() + "] - cryptofs store type is immutable"
import org.opensearch.common.inject.Inject;  
                                updatedNumberOfSearchReplicas,
import org.opensearch.indices.IndicesService;
/*
        int replicaIncrease = updatedNumberOfReplicas - oldNumberOfReplicas;
import java.util.Arrays;
 * compatible open source license.
        Setting<Boolean> setting,  
 * not use this file except in compliance with the License.
        );
                            shardLimitValidator.validateShardLimitForIndices(
 *  
                    }
 *     http://www.apache.org/licenses/LICENSE-2.0
                                }  
                                openIndices  
    private static boolean maybeUpdateClusterBlock(
 * specific language governing permissions and limitations
        ShardLimitValidator shardLimitValidator,  
            }
import org.opensearch.cluster.routing.allocation.AllocationService;
import org.opensearch.ExceptionsHelper;  
        if (!isRemoteSegmentStoreEnabled) {  
                                metadataBuilder.put(IndexMetadata.builder(indexMetadata).settings(finalSettings));
import java.util.HashSet;
                        }
                    }
            // Prevent changing TO cryptofs from any other type  
                            MetadataCreateIndexService.validateStoreTypeSettings(indexSettings);  
 * KIND, either express or implied.  See the License for the
                || isArchived
                            normalizedSettings,
                    }
                                 * The setting index.number_of_replicas is special; we require that this setting has a value in the index. When  
        // Only validate if store.type is being explicitly modified
                    }
        int indexRemoteCapablePrimaryShardsPerNode = INDEX_TOTAL_REMOTE_CAPABLE_PRIMARY_SHARDS_PER_NODE_SETTING.get(indexSettings);
        final Settings normalizedSettings = Settings.builder()
                            }  
     * Updates the cluster block only iff the setting exists in the given settings  
                        .build();  
     * Validates crypto store settings are immutable after index creation.  
 */  
import static org.opensearch.cluster.metadata.MetadataCreateIndexService.validateTranslogFlushIntervalSettingsForCompositeIndex;
                    Set<Index> closeIndices = new HashSet<>();  
 * @opensearch.internal
                    for (final String index : actualIndices) {
                                    );
        // primaries is a placement concern, so it only requires the segments to be remote backed; isRemoteStoreNode()
        clusterService.submitStateUpdateTask(  
                            /*
                        }
                            if (Version.CURRENT.equals(indexMetadata.getCreationVersion()) == false) {
        Collection<DiscoveryNode> nodes = clusterService.state().nodes().getNodes().values();
        final int defaultReplicaCount = clusterService.getClusterSettings().get(Metadata.DEFAULT_REPLICA_COUNT_SETTING);
        this.shardLimitValidator = shardLimitValidator;  
                                if (preserveExisting) {
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_REMOTE_STORE_ENABLED;
                                        updatedNumberOfSearchReplicas,  
                                        IndexMetadata.INDEX_NUMBER_OF_REPLICAS_SETTING.get(Settings.EMPTY)
import org.apache.logging.log4j.LogManager;
                    }  
import org.opensearch.threadpool.ThreadPool;
        }
    private final ClusterService clusterService;  
                            logger.info("updating number_of_replicas to [{}] for indices {}", updatedNumberOfReplicas, actualIndices);  
 * Service responsible for submitting update index settings requests
                            Settings.Builder indexSettings = Settings.builder().put(indexMetadata.getSettings());
    private final ThreadPool threadPool;
            return;  
    }
                "Setting ["
        final ActionListener<ClusterStateUpdateResponse> listener
     */
import java.util.Optional;
            false,
                            closeIndices.add(index);
import org.opensearch.cluster.AckedClusterStateUpdateTask;
        // Task is onboarded for throttling, it will get retried from associated TransportClusterManagerNodeAction.  
                                request.indices(),
import org.opensearch.common.ValidationException;
                            metadataBuilder.put(builder);
import org.opensearch.indices.ShardLimitValidator;  
                                    finalSettings.filter(k -> indexScopedSettings.isPrivateSetting(k) == false),  
            assert setting != null // we already validated the normalized settings
                    Set<Index> openIndices = new HashSet<>();
 *
                        validateTranslogFlushIntervalSettingsForCompositeIndex(
                                 * an explicit value for the setting.
        clusterService.submitStateUpdateTask(  
                        }
            } else {
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_SEARCH_REPLICAS;  
 * the Apache License, Version 2.0 (the "License"); you may
                public ClusterManagerTaskThrottler.ThrottlingKey getClusterManagerThrottlingKey() {
            new AckedClusterStateUpdateTask<ClusterStateUpdateResponse>(
                    if (!closeIndices.isEmpty()) {
     *  
            final boolean updateBlock = setting.get(openSettings);
                    if (blocks.hasIndexBlock(index, block)) {
                        Index index = request.indices()[i];
                    boolean changed = false;  
        this.allocationService = allocationService;  
                        final IndexMetadata metadata = currentState.metadata().getIndexSafe(index);  
                }
                    }
                request,
/**
        return replicaIncrease * shardsInIndex;
                                if (IndexMetadata.INDEX_NUMBER_OF_REPLICAS_SETTING.exists(indexSettings) == false) {
                    // now, reroute in case things change that require it (like number of replicas)
                        } else {  
                                    );
        }
            );
                                    );  
    private final AllocationService allocationService;
import org.opensearch.cluster.ClusterState;
 * this file be licensed under the Apache-2.0 license or a
                        }
                    + INDEX_TOTAL_PRIMARY_SHARDS_PER_NODE_SETTING.getKey()  
                        exception.addValidationErrors(validationErrors);
                                        AutoExpandSearchReplicas.SETTING.get(openSettings)
                            )
                    try {  
            }  
        updateSettingsTaskKey = clusterService.registerClusterManagerTask(UPDATE_SETTINGS, true);
                            logger.info(  
                        if (metadata.getState() == IndexMetadata.State.OPEN) {
                @Override
                        for (Index index : openIndices) {
                protected ClusterStateUpdateResponse newResponse(boolean acknowledged) {  
                                 * not set. A user can update this setting though, including updating it to null, indicating that they want to  
                    final String[] actualIndices = new String[request.indices().length];
                );
                    ClusterState updatedState = ClusterState.builder(currentState)
                                    true  // ignoreArchivedSettings  
import org.opensearch.common.regex.Regex;
                    return new ClusterStateUpdateResponse(acknowledged);
 *
                                        .settingsVersion(1 + indexMetadata.getSettingsVersion())
                    // on an open index
                        || IndexSettings.INDEX_TRANSLOG_RETENTION_SIZE_SETTING.exists(normalizedSettings)) {  
    }
        final ActionListener<ClusterStateUpdateResponse> listener  
                            );
                                 */
                                currentState,  
                    + " hasValue: "
import java.io.IOException;  
                            indicesService.verifyIndexMetadata(currentMetadata, updatedMetadata);
                                 * use the value configured by cluster settings or a default value 1. In this case, we again have to provide
                            indicesService.verifyIndexMetadata(currentMetadata, updatedMetadata);
                                 * there is no value provided on the source of the index creation or "cluster.default_number_of_replicas" is
                throw new IllegalArgumentException(  
                                );
                    }  
                        }
                    // increment settings versions
            if (isArchived == false && (isWildcard || setting.isDynamic())) {
                    return new ClusterStateUpdateResponse(acknowledged);
     * Validates that if we are trying to update search replica count the index is segrep enabled.
                            metadata.getSettings()
        }
                            Settings.Builder indexSettings = Settings.builder().put(indexMetadata.getSettings());  
                request,
                            }
                                        AutoExpandReplicas.SETTING.get(openSettings)
 * under the License.  
                             * TODO: should we update the in-sync allocation IDs once the data is deleted by the node?
                             * We do not update the in-sync allocation IDs as they will be removed upon the first index operation which makes
                || (isWildcard && normalizedSettings.hasValue(key) == false) : "unknown setting: "  
import org.opensearch.cluster.service.ClusterService;
        final String storeTypeKey = "index.store.type";  
    @Inject  
                    + "] or ["
/*  
                }
import static org.opensearch.cluster.metadata.MetadataCreateIndexService.validateTranslogDurabilitySettings;
                        );
                    "To set " + SETTING_NUMBER_OF_SEARCH_REPLICAS + ", " + SETTING_REMOTE_STORE_ENABLED + " must be set to true"
                        changed = true;
                             *
                @Override
                @Override
                                    true, // validateDependencies
                                 * The setting index.number_of_replicas is special; we require that this setting has a value in the index. When
                    Metadata.Builder metadataBuilder = Metadata.builder(currentState.metadata());  
            "update-index-compatibility-versions",
                            final IndexMetadata.Builder builder = IndexMetadata.builder(metadataBuilder.get(index));
                        }
        final int updatedNumberOfSearchReplicas = IndexMetadata.INDEX_NUMBER_OF_SEARCH_REPLICAS_SETTING.get(requestSettings);  
                            // Verifies that the current index settings can be updated with the updated dynamic settings.  
                            Settings.Builder updates = Settings.builder();
                    if (blocks.hasIndexBlock(index, block) == false) {
                                        ValidationException ex = new ValidationException();
import org.opensearch.action.admin.indices.settings.put.UpdateSettingsClusterStateUpdateRequest;
        return changed;
        ThreadPool threadPool,
import org.opensearch.action.admin.indices.upgrade.post.UpgradeSettingsClusterStateUpdateRequest;  
                        throw new IllegalArgumentException(
                                 * including updating it to null, indicating that they want to use the default value. In this case, we again
    ) {  
                Priority.URGENT,  
                                );
                }
        IndexScopedSettings indexScopedSettings,
        // If default value (-1), no validation needed
                                "Can't update non dynamic settings [%s] for open indices %s",
                }
import org.opensearch.cluster.node.DiscoveryNode;  
                                        throw ex;
        int shardsInIndex = indexMetadata.getNumberOfShards();
                    }  
        if (setting.exists(openSettings)) {
        // would additionally demand a cluster state repository, which segments_only nodes never configure.  
        if (indexPrimaryShardsPerNode == -1 && indexRemoteCapablePrimaryShardsPerNode == -1) {
        if (updatedNumberOfSearchReplicas > 0) {
        for (String key : normalizedSettings.keySet()) {  
                                indexScopedSettings.validate(  
                            );
        boolean isRemoteSegmentStoreEnabled = !nodes.isEmpty() && nodes.stream().allMatch(DiscoveryNode::isRemoteSegmentStoreNode);
                    updatedState = allocationService.reroute(updatedState, "settings update");
                                    IndexMetadata.builder(indexMetadata)
    }
                    // allow to change any settings to a close index, and only allow dynamic settings to be changed  
                    if (IndexMetadata.INDEX_NUMBER_OF_SEARCH_REPLICAS_SETTING.exists(openSettings)) {
                    RoutingTable.Builder routingTableBuilder = RoutingTable.builder(currentState.routingTable());  
            normalizedSettings.filter(s -> Regex.isSimpleMatchPattern(s) == false), // don't validate wildcards  
                                                .put(IndexMetadata.SETTING_VERSION_UPGRADED, entry.getValue().v1())  
                    if (changed == false) {
import static org.opensearch.cluster.service.ClusterManagerTask.UPDATE_SETTINGS;  
import java.util.List;
    private final IndicesService indicesService;
                    Metadata.Builder metadataBuilder = Metadata.builder(currentState.metadata());
                    }  
                                "updating number_of_Search Replicas to [{}] for indices {}",
import org.opensearch.core.action.ActionListener;
        ClusterBlock block,
        // (allMatch is vacuously true on an empty node set, which must not count as remote-store enabled). Balancing
            ) {  
                    if (!skippedSettings.isEmpty() && !openIndices.isEmpty()) {  
    /**
                                currentState,  
    /**
                                normalizedSettings.keySet(),
                                    indexSettings.put(indexMetadata.getSettings());
        int indexPrimaryShardsPerNode = INDEX_TOTAL_PRIMARY_SHARDS_PER_NODE_SETTING.get(indexSettings);
                                // no reason to pollute the settings, we didn't really upgrade anything  
                        .routingTable(routingTableBuilder.build())
     * @param currentState {@link ClusterState} current cluster state  
        indexScopedSettings.validate(
                    if (validationErrors.size() > 0) {  
                    + " isWildcard: "
                    index -> currentState.metadata().index(index.getName()).getSettings().getAsBoolean(SETTING_REMOTE_STORE_ENABLED, false)
            String newStoreType = indexSettings.get(storeTypeKey);  
                skippedSettings.add(key);
 * ownership. Elasticsearch licenses this file to you under  
        AllocationService allocationService,  
                                        ex.addValidationError(error.get());  
                    if (!openIndices.isEmpty()) {
import static org.opensearch.index.IndexSettings.same;
            true
                            final IndexMetadata currentMetadata = currentState.getMetadata().getIndexSafe(index);
                            // This step is mandatory since we allow to update non-dynamic settings on closed indices.  
                             * these copies stale.  
                    if (IndexSettings.INDEX_TRANSLOG_RETENTION_AGE_SETTING.exists(normalizedSettings)
                }
                        }  
                                    Optional<String> error = awarenessReplicaBalance.validate(
    private final IndexScopedSettings indexScopedSettings;
        String[] actualIndices,  
            if ("cryptofs".equals(currentStoreType) && !"cryptofs".equals(newStoreType)) {  
                                request.indices(),
 * You may obtain a copy of the License at  
 * Licensed to Elasticsearch under one or more contributor  
            settingsForClosedIndices.copy(key, normalizedSettings);  
                        blocks.addIndexBlock(index, block);  
            // Prevent changing FROM cryptofs to anything else (including null)
                                /*
                            if (indexScopedSettings.updateDynamicSettings(openSettings, indexSettings, updates, index.getName())) {
                                    indexSettings.put(indexMetadata.getSettings());  
                    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                                    if (error.isPresent()) {
                                findComponentTemplate(currentState.metadata(), metadata.context()).template().settings(),  
 * Modifications Copyright OpenSearch Contributors. See
    public static void validateCryptoStoreSettings(Settings indexSettings, Index[] indices, ClusterState clusterState) {
                @Override
                                        throw ex;
        if (!indexSettings.keySet().contains(storeTypeKey)) {  
            boolean isWildcard = setting == null && Regex.isSimpleMatchPattern(key);
                    }
    ) {
import org.opensearch.cluster.ack.ClusterStateUpdateResponse;  
                            }
    private static final Logger logger = LogManager.getLogger(MetadataUpdateSettingsService.class);
                            routingTableBuilder.updateNumberOfReplicas(updatedNumberOfReplicas, actualIndices);
                        if (metadata.context() != null) {  
                    return updateSettingsTaskKey;  
                            // Verify that this won't take us over the cluster shard limit.  
        final Set<String> skippedSettings = new HashSet<>();  
import org.opensearch.cluster.routing.allocation.AwarenessReplicaBalance;  
                            // validate storeType for deprecating index stores
                                Settings finalSettings = indexSettings.build();
        // Get the setting value  
        }
                    for (int i = 0; i < request.indices().length; i++) {  
                            Settings.Builder updates = Settings.builder();
                        for (Index index : openIndices) {  
        final UpgradeSettingsClusterStateUpdateRequest request,  
                            metadataBuilder.updateNumberOfSearchReplicas(updatedNumberOfSearchReplicas, actualIndices);
        ClusterService clusterService,
                                metadataBuilder.put(IndexMetadata.builder(indexMetadata).settings(finalSettings));  
import org.opensearch.cluster.block.ClusterBlock;
            "update-settings " + Arrays.toString(request.indices()),
                            IndexMetadata.SETTING_NUMBER_OF_REPLICAS,
                .allMatch(  
        this.indexScopedSettings = indexScopedSettings;
        }
     * Ensures this setting can only be modified for existing indices in remote store enabled clusters.  
                        String index = entry.getKey();
                public ClusterState execute(ClusterState currentState) {
import org.opensearch.Version;
    }  
                            // Verify that this won't take us over the cluster shard limit.  
        validateTranslogDurabilitySettings(normalizedSettings, clusterService.getClusterSettings(), clusterService.getSettings());
                        return currentState;
        ClusterBlocks.Builder blocks,
                                metadataBuilder.put(
                                    if (error.isPresent()) {
        boolean changed = false;  
            .build();
                                    // No replica count validation for system indices
                        blocks.removeIndexBlock(index, block);
import static org.opensearch.cluster.metadata.MetadataCreateIndexService.validateRefreshIntervalSettings;  
                    return updatedState;  
                                 * creating the index, we ensure this by explicitly providing a value for the setting to the default (one) if  
                            MetadataCreateIndexService.validateTranslogRetentionSettings(indexSettings);
    public void upgradeIndexSettings(
    }  
import java.util.Set;  
                    + isWildcard  
        validateIndexTotalPrimaryShardsPerNodeSetting(normalizedSettings, clusterService);  
                        }
                                }  
            if (!"cryptofs".equals(currentStoreType) && "cryptofs".equals(newStoreType)) {
     */
        this.threadPool = threadPool;
                    for (IndexMetadata.APIBlock block : IndexMetadata.APIBlock.values()) {  
                                skippedSettings,
    }
                    final List<String> validationErrors = new ArrayList<>();
                                index -> getTotalNewShards(index, currentState, updatedNumberOfReplicas)
                                if (preserveExisting) {
                    + key
            }  
            boolean isArchived = key.startsWith(ARCHIVED_SETTINGS_PREFIX);  
    /**
                    + normalizedSettings.hasValue(key);
import java.util.ArrayList;
        final Settings closedSettings = settingsForClosedIndices.build();
        final UpdateSettingsClusterStateUpdateRequest request,
public class MetadataUpdateSettingsService {  
                        IndexMetadata indexMetadata = metadataBuilder.get(index);  
                        for (String index : actualIndices) {
            // Only allow dynamic settings and wildcards for open indices. Skip archived settings.
        this.awarenessReplicaBalance = awarenessReplicaBalance;
            for (String index : actualIndices) {  
                            IndexMetadata indexMetadata = metadataBuilder.getSafe(index);  
    private AwarenessReplicaBalance awarenessReplicaBalance;
    }
    /**
                                    finalSettings.filter(k -> indexScopedSettings.isPrivateSetting(k) == false),
            Setting setting = indexScopedSettings.get(key);
                        changed = true;  
/*  
                                        .settings(  
                throw new IllegalArgumentException(
        IndicesService indicesService,
                             */  
                throw new IllegalArgumentException("Cannot change store type to 'cryptofs' for index [" + index.getName() + "]");
            true, // Ignore archived setting.  
                                index.getName()
    public static void validateIndexTotalPrimaryShardsPerNodeSetting(Settings indexSettings, ClusterService clusterService) {
        AwarenessReplicaBalance awarenessReplicaBalance
 * SPDX-License-Identifier: Apache-2.0
                        if (preserveExisting == false) {
                protected ClusterStateUpdateResponse newResponse(boolean acknowledged) {  
                                Settings finalSettings = indexSettings.build();
 * software distributed under the License is distributed on an
    }  
     * Validates the 'index.routing.allocation.total_primary_shards_per_node' setting during index settings update.
                                            Settings.builder()
        final boolean preserveExisting = request.isPreserveExisting();
                    + INDEX_TOTAL_REMOTE_CAPABLE_PRIMARY_SHARDS_PER_NODE_SETTING.getKey()
                                    Optional<String> error = awarenessReplicaBalance.validate(
import java.util.Map;
import static org.opensearch.cluster.metadata.MetadataCreateIndexService.validateOverlap;
import static org.opensearch.action.support.ContextPreservingActionListener.wrapPreservingContext;
                            changed = true;
                                indexScopedSettings.validate(
                                    // No replica count validation for system indices
            ) {  
                                }
        ); // validate internal or private index settings
                @Override  
                Priority.URGENT,  
                            }
                            indexSettings = metadataBuilder.get(index).getSettings();  
            if (Arrays.stream(indices)
                            indicesService.verifyIndexMetadata(updatedMetadata, updatedMetadata);
                        if (same(currentState.metadata().index(index).getSettings(), metadataBuilder.get(index).getSettings()) == false) {  
                        .metadata(metadataBuilder)  
                            for (Index index : request.indices()) {
import org.opensearch.common.Priority;  
}  
                                 * have to provide an explicit value for the setting to the default (one).  
        for (Index index : indices) {
import org.opensearch.common.collect.Tuple;
                                    false, // ignorePrivateSettings  
        }
                            final IndexMetadata updatedMetadata = updatedState.metadata().getIndexSafe(index);
 * The OpenSearch Contributors require contributions made to  
            }
                            routingTableBuilder.updateNumberOfSearchReplicas(updatedNumberOfSearchReplicas, actualIndices);
                            defaultReplicaCount
                    if (IndexMetadata.INDEX_NUMBER_OF_REPLICAS_SETTING.exists(openSettings)) {
     */
            }  
                            for (Index index : request.indices()) {
                                        )
                    } catch (IOException ex) {  
                settingsForOpenIndices.copy(key, normalizedSettings);  
                        final int updatedNumberOfReplicas = openSettings.getAsInt(  
 *  
 */
                        }
import static org.opensearch.cluster.metadata.MetadataIndexTemplateService.findComponentTemplate;  
        // Remote store is enabled only when there is at least one node and every node has a remote segment store  
                            if (indexScopedSettings.updateSettings(closedSettings, indexSettings, updates, index.getName())) {  
                        if (preserveExisting == false) {
                                        updatedNumberOfReplicas,  
 * Unless required by applicable law or agreed to in writing,
        IndexMetadata indexMetadata = currentState.metadata().index(index);
                                 */  
import org.opensearch.cluster.routing.RoutingTable;
                                index -> getTotalNewShards(index, currentState, updatedNumberOfSearchReplicas)
        validateCryptoStoreSettings(normalizedSettings, request.indices(), clusterService.state());
                                actualIndices  
import org.opensearch.common.settings.Setting;  
                        ).ifPresent(validationErrors::add);
                            openIndices.add(index);
    ) {
                            clusterService.getClusterSettings(),  
                                                .put(indexMetadata.getSettings())
                                    true  // ignoreArchivedSettings
        this.clusterService = clusterService;
    private final ShardLimitValidator shardLimitValidator;  
                    }  
                    }  
                            final IndexMetadata updatedMetadata = updatedState.metadata().getIndexSafe(index);  
        Settings openSettings
                                }
            .put(request.settings())  
                        for (Index index : closeIndices) {  
import static org.opensearch.cluster.routing.allocation.decider.ShardsLimitAllocationDecider.INDEX_TOTAL_REMOTE_CAPABLE_PRIMARY_SHARDS_PER_NODE_SETTING;
