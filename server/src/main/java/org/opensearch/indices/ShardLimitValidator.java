            doValidate(maxShardPerCluster, maxShardPerNode);
        */
                shardPool
        }
        if (shardLimit.isPresent()) {
            throw ex;
    private void setShardLimitPerCluster(int newValue) {
     * then indexes which are starting with dot and are not data stream index are ignored.
                + newShards
    public static final String SETTING_MAX_SHARDS_PER_CLUSTER_KEY = "cluster.routing.allocation.total_shards_limit";
                state.getNodes().getWarmNodes().size(),
            final List<Setting<?>> settings = Collections.singletonList(SETTING_CLUSTER_MAX_SHARDS_PER_NODE);
            .filter(index -> !shouldIndexBeIgnored(index.getName()))
                + shardPool
     *
                + currentOpenShards
     * @param indexName  The index which needs to be validated.
            .addSettingsUpdateConsumer(
    // package-private for testing
            );
     * Returns true if the index name starts with '.' else false.
        }
    static final class MaxRemoteCapableShardPerNodeLimitValidator implements Setting.Validator<Integer> {
        if (this.ignoreDotIndexes) {
     * Gets the currently configured value of the {@link ShardLimitValidator#SETTING_CLUSTER_MAX_SHARDS_PER_CLUSTER} setting.
     * @return If present, an error message to be given as the reason for failing
 * see {@link org.opensearch.cluster.routing.allocation.decider.ShardsLimitAllocationDecider}.
import org.opensearch.cluster.metadata.IndexMetadata;
 *
    public static final Setting<Integer> SETTING_CLUSTER_MAX_REMOTE_CAPABLE_SHARDS_PER_NODE = Setting.intSetting(
        clusterService.getClusterSettings().addSettingsUpdateConsumer(SETTING_CLUSTER_MAX_SHARDS_PER_NODE, this::setShardLimitPerNode);
                + shardPool
     * Validates the MaxShadPerCluster threshold.
        SETTING_MAX_SHARDS_PER_CLUSTER_KEY,
import org.opensearch.common.util.FeatureFlags;
            ValidationException ex = new ValidationException();
            return;
        Setting.Property.NodeScope
        clusterService.getClusterSettings()
    private volatile boolean ignoreDotIndexes;
    }
    }
            throw e;
 *
                + maxShardsInCluster
            /*
            String errorMessage = "this action would add ["
    }
     */
    }
        public void validate(Integer value) {}
    public Optional<String> checkShardLimit(int newShards, ClusterState state, RoutingPool shardPool) {
        new MaxRemoteCapableShardPerNodeLimitValidator(),
        1000,
    /**
 *     http://www.apache.org/licenses/LICENSE-2.0
import java.util.ArrayList;
            final List<Setting<?>> settings = Collections.singletonList(SETTING_CLUSTER_MAX_REMOTE_CAPABLE_SHARDS_PER_CLUSTER);
 * the Apache License, Version 2.0 (the "License"); you may
        }
    public int getShardLimitPerNode() {
 * this file be licensed under the Apache-2.0 license or a
    }
    public void validateShardLimit(ClusterState currentState, Index[] indicesToOpen) {
    }
                "MaxShardPerCluster " + maxShardPerCluster + " should be greater than or equal to MaxShardPerNode " + maxShardPerNode
     * then the indexes starting with '.' are ignored except the data-stream indexes.
        @Override
    public static final Setting<Integer> SETTING_CLUSTER_MAX_SHARDS_PER_NODE = Setting.intSetting(
 * compatible open source license.
            return validateDotIndex(indexName) && !isDataStreamIndex(indexName);
    static Optional<String> checkShardLimit(
    public void validateShardLimitForIndices(Index[] indices, ClusterState currentState, Function<Index, Integer> shardCalculator)
        // Only enforce the shard limit if we have at least one data node, so that we don't block
/*
import org.opensearch.core.index.Index;
import org.opensearch.index.IndexModule;
 */
     */
import java.util.function.Function;
    /**
 * The OpenSearch Contributors require contributions made to
    }
     */
        public void validate(Integer maxShardPerCluster, Map<Setting<?>, Object> settings) {
    }
        @Override
     * @throws ValidationException If any routing pool would exceed shard limits
    public static final Setting<Boolean> SETTING_CLUSTER_IGNORE_DOT_INDEXES = Setting.boolSetting(
public class ShardLimitValidator {
    }
 * this work for additional information regarding copyright
     * Validates the MaxShadPerCluster threshold.
        -1,
    }
        "cluster.max_shards_per_node",
        "cluster.ignore_dot_indexes",
        clusterService.getClusterSettings()
    /**
     */
            .addSettingsUpdateConsumer(SETTING_CLUSTER_MAX_REMOTE_CAPABLE_SHARDS_PER_NODE, this::setRemoteCapableShardShardLimitPerNode);
        /*
        "cluster.max_remote_capable_shards_per_node",
    }
    private static void doValidate(final int maxShardPerCluster, final int maxShardPerNode) {
    );
        public Iterator<Setting<?>> settings() {
    private void setRemoteCapableShardShardLimitPerCluster(int newValue) {
     * Further also validates if the cluster.ignore_dot_indexes is set to true.
 * controlled by a different setting,
import org.opensearch.cluster.service.ClusterService;
                + "] total "
import java.util.Optional;
        this.remoteCapableShardLimitPerCluster.set(newValue);
        public Iterator<Setting<?>> settings() {
                + " shards open";
                getShardLimitPerNode(),
import static org.opensearch.cluster.metadata.IndexMetadata.INDEX_NUMBER_OF_SHARDS_SETTING;
     * @param indicesToOpen The indices which are to be opened.
        if (maxShardsInCluster == -1) {
    public int getRemoteCapableShardLimitPerCluster() {
import java.util.Arrays;
            );
        int maxShardsPerNodeSetting,
        final int shardsToCreate = numberOfShards * (1 + numberOfReplicas);
     * Validates the MaxShadPerNode threshold.
            }
     * @param indexName  The index which needs to be validated.
        Setting.Property.NodeScope
                && indexSettings.getAsBoolean(IndexModule.IS_WARM_INDEX_SETTING.getKey(), false));
     */
     * shard limit only for non system indices and if the cluster.ignore_dot_indexes property is set to true
            e.addValidationError(shardLimit.get());
     */
    public ShardLimitValidator(final Settings settings, ClusterService clusterService, SystemIndices systemIndices) {
        new MaxShardPerClusterLimitValidator(),
        @Override
        1,
    private void setIgnoreDotIndexes(boolean newValue) {
        int newShards,
    public void validateShardLimit(final String indexName, final Settings settings, final ClusterState state) {
     * currently closed and will be opened, ignores indices which are already open. Adding to this it validates the
     * Returns true if the index is dataStreamIndex false otherwise.
import java.util.concurrent.atomic.AtomicInteger;
        return isRemoteCapableIndex ? RoutingPool.REMOTE_CAPABLE : RoutingPool.LOCAL_ONLY;
        }
            .filter(index -> currentState.metadata().index(index).getState().equals(IndexMetadata.State.CLOSE))
        } else return systemIndices.validateSystemIndex(indexName);
    public static final Setting<Integer> SETTING_CLUSTER_MAX_REMOTE_CAPABLE_SHARDS_PER_CLUSTER = Setting.intSetting(
        Setting.Property.NodeScope
 * @opensearch.internal
     */
        If so then it does not validate any index which starts with '.'.
    static final class MaxShardPerNodeLimitValidator implements Setting.Validator<Integer> {
import org.opensearch.common.settings.Settings;
        throws ValidationException {
     * Index is ignored if it is a system index or if cluster.ignore_dot_indexes is set to true
     * @return the current value of the setting
    }
    private static int getTotalShardCount(ClusterState state, Index index) {
    /**
                getRemoteCapableShardLimitPerNode(),
        final RoutingPool shardRoutingPool = getShardRoutingPool(settings);
        int nodeCount,
     * Validates the MaxShadPerNode threshold.
        }
            );
        Setting.Property.Dynamic,
 */
            || (FeatureFlags.isEnabled(FeatureFlags.WRITABLE_WARM_INDEX_EXPERIMENTAL_FLAG)
        // index creation during cluster setup
 * updated correctly on setting updates, etc.
        }
    );
                Collectors.toMap(index -> RoutingPool.getIndexPool(currentState.metadata().index(index)), shardCalculator, Integer::sum)
            If so then it does not validate any index which starts with '.'
        }
        @Override
        }
 * Unless required by applicable law or agreed to in writing,
     * @param settings       the settings of the index to be created
import java.util.Map;
    /**
        @Override
 * KIND, either express or implied.  See the License for the
     * Validates shard limits for a collection of indices using a provided shard calculation function.
        return remoteCapableShardLimitPerNode.get();
    );
            .addSettingsUpdateConsumer(SETTING_CLUSTER_MAX_SHARDS_PER_CLUSTER, this::setShardLimitPerCluster);
        Setting.Property.Dynamic,
                SETTING_CLUSTER_MAX_REMOTE_CAPABLE_SHARDS_PER_CLUSTER,
 * This class contains the logic used to check the cluster-wide shard limit before shards are created and ensuring that the limit is
        @Override
                + "] maximum "
     * Gets the currently configured value of the {@link ShardLimitValidator#SETTING_CLUSTER_MAX_REMOTE_CAPABLE_SHARDS_PER_CLUSTER} setting.
 * specific language governing permissions and limitations
            ex.addValidationErrors(violations);
        new MaxRemoteCapableShardPerClusterLimitValidator(),
        }
     * Validates whether a list of indices can be opened without going over the cluster shard limit.  Only counts indices which are
    }
    private void setRemoteCapableShardShardLimitPerNode(int newValue) {
            : checkShardLimit(
        }
        -1,
import java.util.List;
        this.ignoreDotIndexes = SETTING_CLUSTER_IGNORE_DOT_INDEXES.get(settings);
    protected final AtomicInteger shardLimitPerCluster = new AtomicInteger();
        this.remoteCapableShardLimitPerNode.set(newValue);
     * @param newShards         The number of shards to be added by this operation
     */
        public void validate(Integer maxShardPerNode, Map<Setting<?>, Object> settings) {
        this.systemIndices = systemIndices;
        if (maxShardPerCluster != -1 && maxShardPerCluster < maxShardPerNode) {
     */
            however data-stream indexes are still validated.
        1,
     * Checks to see if an operation can be performed without taking the cluster over the cluster-wide shard limit.
                state.getNodes().getDataNodes().size(),
    /**
     * @throws ValidationException If this operation would take the cluster over the limit and enforcement is enabled.
                newShards,
        @Override
        if ((currentOpenShards + newShards) > maxShardsInCluster) {
    public static final Setting<Integer> SETTING_CLUSTER_MAX_SHARDS_PER_CLUSTER = Setting.intSetting(
        this.remoteCapableShardLimitPerNode.set(SETTING_CLUSTER_MAX_REMOTE_CAPABLE_SHARDS_PER_NODE.get(settings));
    /**
            final int maxShardPerCluster = (int) settings.get(SETTING_CLUSTER_MAX_SHARDS_PER_CLUSTER);
        }
     * @param indexName  The index which needs to be validated.
 * Modifications Copyright OpenSearch Contributors. See
        false,
            final ValidationException e = new ValidationException();
            return Optional.empty();
    }
        return indexName.charAt(0) == '.';
            throw new IllegalArgumentException(
        this.ignoreDotIndexes = newValue;
        if (nodeCount == 0 || newShards < 0) {
/*
     * @return the current value of the setting.
    );
import java.util.stream.Collectors;
 * NOTE: This is the limit applied at *shard creation time*. If you are looking for the limit applied at *allocation* time, which is
            Further also validates if the cluster.ignore_dot_indexes is set to true.
 * ownership. Elasticsearch licenses this file to you under
 * <p>
    private boolean isDataStreamIndex(String indexName) {
        return indexMetadata.getNumberOfShards() * (1 + indexMetadata.getNumberOfReplicas());
    }
    private boolean validateDotIndex(String indexName) {
    }
     * @return the current value of the setting.
        return shardLimitPerCluster.get();
 * GitHub history for details.
            return settings.iterator();
 * You may obtain a copy of the License at
    /**
            final int maxShardPerCluster = (int) settings.get(SETTING_CLUSTER_MAX_REMOTE_CAPABLE_SHARDS_PER_CLUSTER);
        int maxShardsInCluster = maxShardsPerClusterSetting;
    }
        clusterService.getClusterSettings()
     */
    /**
    }
        Further also validates if the cluster.ignore_dot_indexes is set to true.
     * @throws ValidationException if creating this index would put the cluster over the cluster shard limit
import org.opensearch.cluster.ClusterState;
     * Returns an error message if appropriate, or an empty {@link Optional} otherwise.
        } else {
        "cluster.routing.allocation.total_remote_capable_shards_limit",
        public void validate(Integer value) {}
        }
     * Validate shard limit only for non system indices as it is not hard limit anyways.
        return remoteCapableShardLimitPerCluster.get();
        this.shardLimitPerCluster.set(newValue);
import org.opensearch.common.settings.Setting;
    public int getRemoteCapableShardLimitPerNode() {
                getShardLimitPerCluster(),
 * not use this file except in compliance with the License.
     * If so then it does not validate any index which starts with '.' except data-stream index.
                state.getMetadata().getTotalOpenRemoteCapableIndexShards(),
    protected final AtomicInteger remoteCapableShardLimitPerNode = new AtomicInteger();
        @Override
        int maxShardsPerClusterSetting,
            if (error.isPresent()) {
        public void validate(Integer maxShardPerCluster, Map<Setting<?>, Object> settings) {
/*
        return Optional.empty();
     *
                getRemoteCapableShardLimitPerCluster(),
    }
        return shardPool == RoutingPool.REMOTE_CAPABLE
     */
    public int getShardLimitPerCluster() {
            final List<Setting<?>> settings = Collections.singletonList(SETTING_CLUSTER_MAX_SHARDS_PER_CLUSTER);
                + " shards, but this cluster currently has ["
    private void setShardLimitPerNode(int newValue) {
        public void validate(Integer value) {}
     *
        public Iterator<Setting<?>> settings() {
            )
                violations.add(error.get());
            .toArray(Index[]::new);
    static final class MaxRemoteCapableShardPerClusterLimitValidator implements Setting.Validator<Integer> {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        }
            maxShardsInCluster = computedMaxShards;
        Setting.Property.NodeScope
        public Iterator<Setting<?>> settings() {
import java.util.Collections;
        @Override
            final int maxShardPerNode = (int) settings.get(SETTING_CLUSTER_MAX_SHARDS_PER_NODE);
 * Licensed to Elasticsearch under one or more contributor
    }
        Index[] filteredIndices = Arrays.stream(indicesToOpen)
     * @param currentState The current cluster state
     * an operation. If empty, a sign that the operation is valid.
     * @param currentState The current cluster state.
        1000,
        this.shardLimitPerNode.set(SETTING_CLUSTER_MAX_SHARDS_PER_NODE.get(settings));
        return shardLimitPerNode.get();
        Map<RoutingPool, Integer> shardCountByRoutingPool = Arrays.stream(indices)
        this.shardLimitPerCluster.set(SETTING_CLUSTER_MAX_SHARDS_PER_CLUSTER.get(settings));
    }
    /**
     * @param shardCalculator Function to calculate shard count for each index
                newShards,
     *
     * @param state          the current cluster state
        int computedMaxShards = (int) Math.min(Integer.MAX_VALUE, (long) maxShardsPerNodeSetting * nodeCount);
    protected final AtomicInteger shardLimitPerNode = new AtomicInteger();
        }
     */
    /**
import java.util.Iterator;
     * @param indexName      the name of the index being created
        @Override
        Validate shard limit only for non system indices as it is not hard limit anyways.
 */
        for (Map.Entry<RoutingPool, Integer> entry : shardCountByRoutingPool.entrySet()) {
            final int maxShardPerNode = (int) settings.get(SETTING_CLUSTER_MAX_REMOTE_CAPABLE_SHARDS_PER_NODE);
     *
        new MaxShardPerNodeLimitValidator(),
            ? checkShardLimit(
import org.opensearch.common.ValidationException;
        this.shardLimitPerNode.set(newValue);
        -1,
    /**
 * SPDX-License-Identifier: Apache-2.0
            */
    /**
        @Override
    }
     */
/**
        Setting.Property.Dynamic,
            maxShardsInCluster = Math.min(maxShardsInCluster, computedMaxShards);
        }
            doValidate(maxShardPerCluster, maxShardPerNode);
    static final class MaxShardPerClusterLimitValidator implements Setting.Validator<Integer> {
}
    private final SystemIndices systemIndices;
        final Optional<String> shardLimit = checkShardLimit(shardsToCreate, state, shardRoutingPool);
    }
            validateShardLimitForIndices(filteredIndices, currentState, index -> getTotalShardCount(currentState, index));
    }
            doValidate(maxShardPerCluster, maxShardPerNode);
 * under the License.
     *
 *
     */
     * @return the current value of the setting
import org.opensearch.cluster.metadata.DataStream;
     */
            final List<Setting<?>> settings = Collections.singletonList(SETTING_CLUSTER_MAX_REMOTE_CAPABLE_SHARDS_PER_NODE);
                state.getMetadata().getTotalOpenIndexShards(),
        Setting.Property.Dynamic,
                this::setRemoteCapableShardShardLimitPerCluster
    private boolean shouldIndexBeIgnored(String indexName) {
     * Gets the currently configured value of the {@link ShardLimitValidator#SETTING_CLUSTER_MAX_SHARDS_PER_NODE} setting.
        this.remoteCapableShardLimitPerCluster.set(SETTING_CLUSTER_MAX_REMOTE_CAPABLE_SHARDS_PER_CLUSTER.get(settings));
        if (filteredIndices.length > 0) {
import org.opensearch.cluster.routing.RoutingPool;
     * @param state             The current cluster state
     * Checks whether an index can be created without going over the cluster shard limit.
            return settings.iterator();
            return Optional.of(errorMessage);
 */
                shardPool
     * Gets the currently configured value of the {@link ShardLimitValidator#SETTING_CLUSTER_MAX_REMOTE_CAPABLE_SHARDS_PER_NODE} setting.
    /**
        List<String> violations = new ArrayList<>();
        public void validate(Integer value) {}
        final int numberOfReplicas = IndexMetadata.INDEX_NUMBER_OF_REPLICAS_SETTING.get(settings);
            Validate shard limit only for non system indices as it is not hard limit anyways.
 * software distributed under the License is distributed on an
    protected final AtomicInteger remoteCapableShardLimitPerCluster = new AtomicInteger();
        Boolean isRemoteCapableIndex = IndexModule.Type.REMOTE_SNAPSHOT.match(indexSettings)
        if (shouldIndexBeIgnored(indexName)) {
            Optional<String> error = checkShardLimit(entry.getValue(), currentState, entry.getKey());
        public void validate(Integer maxShardPerNode, Map<Setting<?>, Object> settings) {
    }
        return indexName.startsWith(DataStream.BACKING_INDEX_PREFIX);
                + "]/["
        long currentOpenShards,
    /**
     *
            return settings.iterator();
package org.opensearch.indices;
        Setting.Property.NodeScope
    ) {
            .collect(
        }
     * Returns true if the index should be ignored during validation.
        RoutingPool shardPool
     * @param indices The indices to validate
            return settings.iterator();
        final int numberOfShards = INDEX_NUMBER_OF_SHARDS_SETTING.get(settings);
            );
 *
        clusterService.getClusterSettings().addSettingsUpdateConsumer(SETTING_CLUSTER_IGNORE_DOT_INDEXES, this::setIgnoreDotIndexes);
        }
        -1,
        @Override
        if (!violations.isEmpty()) {
 * license agreements. See the NOTICE file distributed with
        IndexMetadata indexMetadata = state.metadata().index(index);
            doValidate(maxShardPerCluster, maxShardPerNode);
    );
        Setting.Property.Dynamic,
    static RoutingPool getShardRoutingPool(Settings indexSettings) {
