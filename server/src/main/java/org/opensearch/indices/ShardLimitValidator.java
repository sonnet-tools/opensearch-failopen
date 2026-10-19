                + " shards open";  
     * @param currentState The current cluster state.  
        return isRemoteCapableIndex ? RoutingPool.REMOTE_CAPABLE : RoutingPool.LOCAL_ONLY;
        if (maxShardsInCluster == -1) {
    private volatile boolean ignoreDotIndexes;  
                newShards,
        Setting.Property.Dynamic,
        List<String> violations = new ArrayList<>();  
     */  
        1,  
     */
     *
     */
        // Only enforce the shard limit if we have at least one data node, so that we don't block
import org.opensearch.core.index.Index;
                getRemoteCapableShardLimitPerNode(),
            ValidationException ex = new ValidationException();  
import java.util.Collections;  
    }
import org.opensearch.common.ValidationException;  
 */  
            validateShardLimitForIndices(filteredIndices, currentState, index -> getTotalShardCount(currentState, index));
        new MaxRemoteCapableShardPerClusterLimitValidator(),
        }  
            if (error.isPresent()) {  
        -1,  
    /**
        return remoteCapableShardLimitPerCluster.get();
import java.util.Arrays;
        }
 * see {@link org.opensearch.cluster.routing.allocation.decider.ShardsLimitAllocationDecider}.
        this.remoteCapableShardLimitPerCluster.set(newValue);
            e.addValidationError(shardLimit.get());
        @Override  
        If so then it does not validate any index which starts with '.'.
     * Validates the MaxShadPerNode threshold.
    /**  
        }
     * Checks whether an index can be created without going over the cluster shard limit.  
            return settings.iterator();  
    protected final AtomicInteger shardLimitPerNode = new AtomicInteger();
        int newShards,
        }  
     * @param currentState The current cluster state
     * Validates the MaxShadPerCluster threshold.
            : checkShardLimit(
    protected final AtomicInteger remoteCapableShardLimitPerCluster = new AtomicInteger();
    static final class MaxRemoteCapableShardPerNodeLimitValidator implements Setting.Validator<Integer> {
 * compatible open source license.
 */  
 * this file be licensed under the Apache-2.0 license or a
        clusterService.getClusterSettings().addSettingsUpdateConsumer(SETTING_CLUSTER_IGNORE_DOT_INDEXES, this::setIgnoreDotIndexes);  
        @Override  
    }  
    /**
        clusterService.getClusterSettings()  
     * @param indexName      the name of the index being created
                violations.add(error.get());
 * KIND, either express or implied.  See the License for the
        @Override  
                shardPool
     */
        final int numberOfShards = INDEX_NUMBER_OF_SHARDS_SETTING.get(settings);
import org.opensearch.cluster.routing.RoutingPool;
    private final SystemIndices systemIndices;
        -1,
import org.opensearch.cluster.metadata.IndexMetadata;  
import java.util.Map;  
    }
     * @param indexName  The index which needs to be validated.
        public void validate(Integer value) {}
        if ((currentOpenShards + newShards) > maxShardsInCluster) {
        if (filteredIndices.length > 0) {
            final List<Setting<?>> settings = Collections.singletonList(SETTING_CLUSTER_MAX_SHARDS_PER_NODE);
     * Returns true if the index name starts with '.' else false.
    );
    private static void doValidate(final int maxShardPerCluster, final int maxShardPerNode) {
     */  
public class ShardLimitValidator {  
import java.util.List;
     * Index is ignored if it is a system index or if cluster.ignore_dot_indexes is set to true
        Setting.Property.Dynamic,
     */  
        }
        // index creation during cluster setup  
     */  
            }
        }  
    static RoutingPool getShardRoutingPool(Settings indexSettings) {  
     * Validates whether a list of indices can be opened without going over the cluster shard limit.  Only counts indices which are
            doValidate(maxShardPerCluster, maxShardPerNode);  
            )  
    public int getRemoteCapableShardLimitPerNode() {
        /*
            .filter(index -> !shouldIndexBeIgnored(index.getName()))  
     */
                state.getMetadata().getTotalOpenIndexShards(),  
    }
                && indexSettings.getAsBoolean(IndexModule.IS_WARM_INDEX_SETTING.getKey(), false));  
     * @param shardCalculator Function to calculate shard count for each index
import java.util.concurrent.atomic.AtomicInteger;
 * Licensed to Elasticsearch under one or more contributor  
    /**  
        Map<RoutingPool, Integer> shardCountByRoutingPool = Arrays.stream(indices)
        return remoteCapableShardLimitPerNode.get();
            Further also validates if the cluster.ignore_dot_indexes is set to true.
     * @param settings       the settings of the index to be created  
/*
    }
        this.remoteCapableShardLimitPerCluster.set(SETTING_CLUSTER_MAX_REMOTE_CAPABLE_SHARDS_PER_CLUSTER.get(settings));  
     */
        Setting.Property.Dynamic,  
            throw new IllegalArgumentException(  
     * @param indexName  The index which needs to be validated.  
    }  
import org.opensearch.common.util.FeatureFlags;  
     * currently closed and will be opened, ignores indices which are already open. Adding to this it validates the
        public void validate(Integer maxShardPerCluster, Map<Setting<?>, Object> settings) {
                newShards,  
     * @param indices The indices to validate  
            final int maxShardPerCluster = (int) settings.get(SETTING_CLUSTER_MAX_REMOTE_CAPABLE_SHARDS_PER_CLUSTER);
        "cluster.max_remote_capable_shards_per_node",
        IndexMetadata indexMetadata = state.metadata().index(index);
        }
        public Iterator<Setting<?>> settings() {
    }
    }  
 * You may obtain a copy of the License at  
/**
        RoutingPool shardPool  
            .filter(index -> currentState.metadata().index(index).getState().equals(IndexMetadata.State.CLOSE))
        int maxShardsPerClusterSetting,
    private void setIgnoreDotIndexes(boolean newValue) {
        this.shardLimitPerNode.set(newValue);
    private boolean shouldIndexBeIgnored(String indexName) {  
            final List<Setting<?>> settings = Collections.singletonList(SETTING_CLUSTER_MAX_REMOTE_CAPABLE_SHARDS_PER_NODE);
     *
            return settings.iterator();  
    public ShardLimitValidator(final Settings settings, ClusterService clusterService, SystemIndices systemIndices) {
     * Returns true if the index is dataStreamIndex false otherwise.
    public int getShardLimitPerCluster() {
    /**  
                getShardLimitPerNode(),
    }
     * then the indexes starting with '.' are ignored except the data-stream indexes.
     *  
    /**  
                + currentOpenShards
    private void setRemoteCapableShardShardLimitPerCluster(int newValue) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }
            || (FeatureFlags.isEnabled(FeatureFlags.WRITABLE_WARM_INDEX_EXPERIMENTAL_FLAG)
        @Override  
    /**
        int computedMaxShards = (int) Math.min(Integer.MAX_VALUE, (long) maxShardsPerNodeSetting * nodeCount);
import java.util.Iterator;
    private static int getTotalShardCount(ClusterState state, Index index) {  
        public void validate(Integer value) {}
import java.util.Optional;
        this.shardLimitPerCluster.set(newValue);  
                + shardPool
        clusterService.getClusterSettings()
        }
            .toArray(Index[]::new);
    }  
        this.ignoreDotIndexes = SETTING_CLUSTER_IGNORE_DOT_INDEXES.get(settings);
}
    }
 *
     * Gets the currently configured value of the {@link ShardLimitValidator#SETTING_CLUSTER_MAX_REMOTE_CAPABLE_SHARDS_PER_NODE} setting.
            */
        if (this.ignoreDotIndexes) {
                SETTING_CLUSTER_MAX_REMOTE_CAPABLE_SHARDS_PER_CLUSTER,  
 * Modifications Copyright OpenSearch Contributors. See
        @Override  
        this.shardLimitPerCluster.set(SETTING_CLUSTER_MAX_SHARDS_PER_CLUSTER.get(settings));
     * If so then it does not validate any index which starts with '.' except data-stream index.  
                + "] maximum "
    /**
        return shardLimitPerCluster.get();  
     * Gets the currently configured value of the {@link ShardLimitValidator#SETTING_CLUSTER_MAX_REMOTE_CAPABLE_SHARDS_PER_CLUSTER} setting.  
        } else {  
import static org.opensearch.cluster.metadata.IndexMetadata.INDEX_NUMBER_OF_SHARDS_SETTING;  
        if (!violations.isEmpty()) {
                + newShards  
    private boolean validateDotIndex(String indexName) {
     * @param newShards         The number of shards to be added by this operation
        this.remoteCapableShardLimitPerNode.set(SETTING_CLUSTER_MAX_REMOTE_CAPABLE_SHARDS_PER_NODE.get(settings));
import java.util.stream.Collectors;
    static final class MaxShardPerNodeLimitValidator implements Setting.Validator<Integer> {
        return indexName.startsWith(DataStream.BACKING_INDEX_PREFIX);  
        this.shardLimitPerNode.set(SETTING_CLUSTER_MAX_SHARDS_PER_NODE.get(settings));  
        this.ignoreDotIndexes = newValue;
            final ValidationException e = new ValidationException();  
        final int shardsToCreate = numberOfShards * (1 + numberOfReplicas);
            );
     * @param indexName  The index which needs to be validated.  
    }
 * under the License.  
            .addSettingsUpdateConsumer(SETTING_CLUSTER_MAX_REMOTE_CAPABLE_SHARDS_PER_NODE, this::setRemoteCapableShardShardLimitPerNode);  
    /**  
     */
        Setting.Property.NodeScope  
    private void setShardLimitPerNode(int newValue) {
            return settings.iterator();  
            final List<Setting<?>> settings = Collections.singletonList(SETTING_CLUSTER_MAX_SHARDS_PER_CLUSTER);
            return Optional.of(errorMessage);
import org.opensearch.common.settings.Setting;
     * an operation. If empty, a sign that the operation is valid.
            final int maxShardPerNode = (int) settings.get(SETTING_CLUSTER_MAX_SHARDS_PER_NODE);
            If so then it does not validate any index which starts with '.'  
        }
            Validate shard limit only for non system indices as it is not hard limit anyways.
 *
        Setting.Property.NodeScope
    /**
        @Override  
 * The OpenSearch Contributors require contributions made to  
    public int getShardLimitPerNode() {  
            .collect(
     * @throws ValidationException if creating this index would put the cluster over the cluster shard limit
    protected final AtomicInteger shardLimitPerCluster = new AtomicInteger();
        Setting.Property.NodeScope  
        }  
    }
     * @param state             The current cluster state
        public void validate(Integer maxShardPerNode, Map<Setting<?>, Object> settings) {
        @Override  
        clusterService.getClusterSettings()
     * Validates the MaxShadPerCluster threshold.
     */
            doValidate(maxShardPerCluster, maxShardPerNode);  
     *
     */  
        public void validate(Integer maxShardPerNode, Map<Setting<?>, Object> settings) {
                shardPool
    );
 * ownership. Elasticsearch licenses this file to you under  
            );
        throws ValidationException {  
     * then indexes which are starting with dot and are not data stream index are ignored.
        }
 */
import org.opensearch.common.settings.Settings;
     * @return the current value of the setting.  
import org.opensearch.cluster.service.ClusterService;
            however data-stream indexes are still validated.
    ) {
    static Optional<String> checkShardLimit(  
            );
    public static final Setting<Boolean> SETTING_CLUSTER_IGNORE_DOT_INDEXES = Setting.boolSetting(  
        if (shardLimit.isPresent()) {
        clusterService.getClusterSettings().addSettingsUpdateConsumer(SETTING_CLUSTER_MAX_SHARDS_PER_NODE, this::setShardLimitPerNode);
        int nodeCount,
     * Validates shard limits for a collection of indices using a provided shard calculation function.
 */
    public static final Setting<Integer> SETTING_CLUSTER_MAX_SHARDS_PER_CLUSTER = Setting.intSetting(  
    private void setShardLimitPerCluster(int newValue) {
    public int getRemoteCapableShardLimitPerCluster() {  
        }  
        Index[] filteredIndices = Arrays.stream(indicesToOpen)
        return indexMetadata.getNumberOfShards() * (1 + indexMetadata.getNumberOfReplicas());
        int maxShardsPerNodeSetting,  
        SETTING_MAX_SHARDS_PER_CLUSTER_KEY,
        1000,
            );
/*  
            ? checkShardLimit(
        final Optional<String> shardLimit = checkShardLimit(shardsToCreate, state, shardRoutingPool);
    }
            ex.addValidationErrors(violations);
            doValidate(maxShardPerCluster, maxShardPerNode);  
        public Iterator<Setting<?>> settings() {
import java.util.ArrayList;
                getShardLimitPerCluster(),
    public void validateShardLimit(ClusterState currentState, Index[] indicesToOpen) {
    }
package org.opensearch.indices;
        @Override  
            maxShardsInCluster = Math.min(maxShardsInCluster, computedMaxShards);
            return validateDotIndex(indexName) && !isDataStreamIndex(indexName);
        @Override  
        Further also validates if the cluster.ignore_dot_indexes is set to true.
                + maxShardsInCluster  
     * @return the current value of the setting.
        if (nodeCount == 0 || newShards < 0) {
        "cluster.max_shards_per_node",
 * not use this file except in compliance with the License.
        return Optional.empty();  
        }  
    }
    }
    }
        Setting.Property.Dynamic,
 *  
/*  
            return;
    // package-private for testing
            throw ex;
     * Further also validates if the cluster.ignore_dot_indexes is set to true.
    private boolean isDataStreamIndex(String indexName) {
     * @return the current value of the setting
            doValidate(maxShardPerCluster, maxShardPerNode);  
     * @return the current value of the setting
     * Gets the currently configured value of the {@link ShardLimitValidator#SETTING_CLUSTER_MAX_SHARDS_PER_CLUSTER} setting.
 * specific language governing permissions and limitations
 *     http://www.apache.org/licenses/LICENSE-2.0
 * SPDX-License-Identifier: Apache-2.0
                + "]/["
            Optional<String> error = checkShardLimit(entry.getValue(), currentState, entry.getKey());
     *  
        public Iterator<Setting<?>> settings() {
        }
        1,  
    /**
     * Checks to see if an operation can be performed without taking the cluster over the cluster-wide shard limit.
        if (maxShardPerCluster != -1 && maxShardPerCluster < maxShardPerNode) {
        final int numberOfReplicas = IndexMetadata.INDEX_NUMBER_OF_REPLICAS_SETTING.get(settings);  
     * @throws ValidationException If any routing pool would exceed shard limits  
        */  
        Setting.Property.Dynamic,
    }
 * NOTE: This is the limit applied at *shard creation time*. If you are looking for the limit applied at *allocation* time, which is  
    /**
    }
            /*  
     * Validates the MaxShadPerNode threshold.
            return settings.iterator();  
 * updated correctly on setting updates, etc.
    }
    /**
     *
        long currentOpenShards,
    public static final Setting<Integer> SETTING_CLUSTER_MAX_REMOTE_CAPABLE_SHARDS_PER_NODE = Setting.intSetting(  
    }
        this.systemIndices = systemIndices;
    /**
    public Optional<String> checkShardLimit(int newShards, ClusterState state, RoutingPool shardPool) {  
 * This class contains the logic used to check the cluster-wide shard limit before shards are created and ensuring that the limit is  
        Setting.Property.NodeScope  
        public void validate(Integer maxShardPerCluster, Map<Setting<?>, Object> settings) {
        -1,
    public static final String SETTING_MAX_SHARDS_PER_CLUSTER_KEY = "cluster.routing.allocation.total_shards_limit";
        new MaxShardPerNodeLimitValidator(),
                + "] total "
        } else return systemIndices.validateSystemIndex(indexName);  
     */  
    public static final Setting<Integer> SETTING_CLUSTER_MAX_REMOTE_CAPABLE_SHARDS_PER_CLUSTER = Setting.intSetting(  
        int maxShardsInCluster = maxShardsPerClusterSetting;  
    );
        }
                Collectors.toMap(index -> RoutingPool.getIndexPool(currentState.metadata().index(index)), shardCalculator, Integer::sum)  
     */
    public void validateShardLimitForIndices(Index[] indices, ClusterState currentState, Function<Index, Integer> shardCalculator)
        @Override  
        @Override  
     * @param state          the current cluster state
                getRemoteCapableShardLimitPerCluster(),  
 * software distributed under the License is distributed on an
     * @throws ValidationException If this operation would take the cluster over the limit and enforcement is enabled.
import org.opensearch.cluster.ClusterState;
            final List<Setting<?>> settings = Collections.singletonList(SETTING_CLUSTER_MAX_REMOTE_CAPABLE_SHARDS_PER_CLUSTER);
            final int maxShardPerCluster = (int) settings.get(SETTING_CLUSTER_MAX_SHARDS_PER_CLUSTER);
 * the Apache License, Version 2.0 (the "License"); you may
                state.getMetadata().getTotalOpenRemoteCapableIndexShards(),
                state.getNodes().getWarmNodes().size(),
     */  
        new MaxShardPerClusterLimitValidator(),
        Setting.Property.NodeScope  
        "cluster.ignore_dot_indexes",
                this::setRemoteCapableShardShardLimitPerCluster
    private void setRemoteCapableShardShardLimitPerNode(int newValue) {  
    /**  
    public static final Setting<Integer> SETTING_CLUSTER_MAX_SHARDS_PER_NODE = Setting.intSetting(  
        if (shouldIndexBeIgnored(indexName)) {
 * Unless required by applicable law or agreed to in writing,
                state.getNodes().getDataNodes().size(),  
        public void validate(Integer value) {}
     * shard limit only for non system indices and if the cluster.ignore_dot_indexes property is set to true  
        Validate shard limit only for non system indices as it is not hard limit anyways.  
            throw e;
        this.remoteCapableShardLimitPerNode.set(newValue);
        public void validate(Integer value) {}
     * Returns true if the index should be ignored during validation.  
                + " shards, but this cluster currently has ["  
        -1,  
        @Override  
    );
        new MaxRemoteCapableShardPerNodeLimitValidator(),
 * GitHub history for details.
            return Optional.empty();
                + shardPool
            final int maxShardPerNode = (int) settings.get(SETTING_CLUSTER_MAX_REMOTE_CAPABLE_SHARDS_PER_NODE);
     * Validate shard limit only for non system indices as it is not hard limit anyways.
                "MaxShardPerCluster " + maxShardPerCluster + " should be greater than or equal to MaxShardPerNode " + maxShardPerNode
 * <p>
        final RoutingPool shardRoutingPool = getShardRoutingPool(settings);  
import org.opensearch.index.IndexModule;
            String errorMessage = "this action would add ["
     * @param indicesToOpen The indices which are to be opened.
    );
            .addSettingsUpdateConsumer(SETTING_CLUSTER_MAX_SHARDS_PER_CLUSTER, this::setShardLimitPerCluster);
        "cluster.routing.allocation.total_remote_capable_shards_limit",
            .addSettingsUpdateConsumer(
        for (Map.Entry<RoutingPool, Integer> entry : shardCountByRoutingPool.entrySet()) {
     *
 * @opensearch.internal
    }  
 * this work for additional information regarding copyright
    public void validateShardLimit(final String indexName, final Settings settings, final ClusterState state) {
    protected final AtomicInteger remoteCapableShardLimitPerNode = new AtomicInteger();  
 * license agreements. See the NOTICE file distributed with
     * Returns an error message if appropriate, or an empty {@link Optional} otherwise.
     * @return If present, an error message to be given as the reason for failing  
 * controlled by a different setting,
        }
        1000,
import java.util.function.Function;  
     * Gets the currently configured value of the {@link ShardLimitValidator#SETTING_CLUSTER_MAX_SHARDS_PER_NODE} setting.  
    static final class MaxShardPerClusterLimitValidator implements Setting.Validator<Integer> {
            maxShardsInCluster = computedMaxShards;
 *  
        return shardLimitPerNode.get();
import org.opensearch.cluster.metadata.DataStream;
        false,
        return indexName.charAt(0) == '.';  
        Boolean isRemoteCapableIndex = IndexModule.Type.REMOTE_SNAPSHOT.match(indexSettings)
        public Iterator<Setting<?>> settings() {
        return shardPool == RoutingPool.REMOTE_CAPABLE
    }  
        }  
    static final class MaxRemoteCapableShardPerClusterLimitValidator implements Setting.Validator<Integer> {
