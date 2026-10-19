            exception.getMessage()
        int totalShards = counts.getFailingIndexShards() * (1 + counts.getFailingIndexReplicas());
     */
            counts.getShardsPerNode(),
                + totalShards
            .put(SETTING_NUMBER_OF_SHARDS, 1)
            counts.getShardsPerNode(),
        final Settings settings = Settings.builder()
     *
import static org.opensearch.cluster.metadata.MetadataIndexStateServiceTests.addClosedIndex;
        // Use a mocked clusterService - for unit tests we won't be updating the setting anyway.
            .put(SETTING_CLUSTER_MAX_SHARDS_PER_NODE.getKey(), 1)
        shardLimitValidator.validateShardLimit("abc", settings, state);
     * fails when it exceeds the cluster max shard limit
        );
            RoutingPool.LOCAL_ONLY
            maxShardLimitOnCluster,
 */
     * This test validates that dataStream index creation succeeds
        final Metadata.Builder metadata = Metadata.builder(state.metadata());
        assertFalse(errorMessage.isPresent());
    public void testSystemIndexOpeningSucceeds() {
            counts.getFailingIndexShards(),
    public void testDotIndexOpeningFails() {
    }
        );
        Optional<String> errorMessage = ShardLimitValidator.checkShardLimit(
        shardLimitValidator.validateShardLimit(".ds-test-index", settings, state);
            state.getNodes().getDataNodes().size(),
    public static ClusterState createClusterForShardLimitTest(int nodesInCluster, int shardsInIndex, int replicas) {
/*
            .put(SETTING_MAX_SHARDS_PER_CLUSTER_KEY, maxShardLimitOnCluster)
    public static ClusterState createClusterForShardLimitTest(
            ValidationException.class,
        final ShardLimitValidator shardLimitValidator = createTestShardLimitService(1, true);
     * @param clusterService   the cluster service to use
            .put(SETTING_NUMBER_OF_REPLICAS, 1)
        int closedIndexShards,
        shardLimitValidator.validateShardLimit(state, indices);
            .build();
            counts.getFirstIndexReplicas(),
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
     * @param maxShardsPerNode the value to use for the max shards per node setting
            state.getNodes().getDataNodes().size(),
                + "] total LOCAL_ONLY shards, but this cluster currently has ["
            counts.getFailingIndexReplicas()
                + "]/["
    /**
    }
 * the Apache License, Version 2.0 (the "License"); you may
            randomAlphaOfLengthBetween(5, 15),
            counts.getFailingIndexShards(),
            .put(SETTING_VERSION_CREATED, Version.CURRENT)
        Index[] indices = Arrays.stream(state.metadata().indices().values().toArray(new IndexMetadata[0]))
     * This test validates that dataStream index creation fails
        ShardCounts counts = forDataNodeCount(nodesInCluster);
        state = addClosedIndex(closeIndexName, closedIndexShards, closedIndexReplicas, state);
            counts.getFirstIndexShards(),
            shardsToAdd,
        String closeIndexName,
            counts.getFirstIndexReplicas(),
    public void testDataStreamIndexCreationFails() {
            ".tasks",               // Adding closed system index to cluster state
                + "]/["
        int maxShards = Math.min(counts.getShardsPerNode() * nodesInCluster, maxShardLimitOnCluster);
    public void testOverShardLimitWithMaxShardCountLimit() {
            .put(SETTING_CLUSTER_IGNORE_DOT_INDEXES.getKey(), ignoreDotIndexes)
        // Shard limit validation succeeds without any issues as system index is being opened
        ValidationException exception = expectThrows(
        int currentShards = counts.getFirstIndexShards() * (1 + counts.getFirstIndexReplicas());
    /**
        );
            -1,
        int shardsToAdd = counts.getFailingIndexShards() * (1 + counts.getFailingIndexReplicas());
                + currentShards
                + 1
     * Creates a {@link ShardLimitValidator} for testing with the given setting and a given cluster service.
                + "] maximum LOCAL_ONLY shards open",
            .build();
            counts.getFailingIndexShards(),
        errorMessage = ShardLimitValidator.checkShardLimit(
            .put(SETTING_NUMBER_OF_REPLICAS, 1)
        final ClusterState state = createClusterForShardLimitTest(1, 1, 0);
 * software distributed under the License is distributed on an
import java.util.Optional;
 *
    }
                + totalShards
        final int maxShardLimitOnCluster = 5;
            state.getNodes().getDataNodes().size(),
                + "] maximum LOCAL_ONLY shards open;",
            state.getNodes().getDataNodes().size(),
        );
        int nodesInCluster = randomIntBetween(2, 90);
     * @return a test instance
    }
        assertFalse(errorMessage.isPresent());
            counts.getFailingIndexReplicas()
     */
                + maxShards
                + "] total LOCAL_ONLY shards, but this cluster currently has ["
        DiscoveryNodes nodes = mock(DiscoveryNodes.class);
        Index[] indices = Arrays.stream(state.metadata().indices().values().toArray(new IndexMetadata[0]))
     */
                + "] total LOCAL_ONLY shards, but this cluster currently has ["
            .settings(Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT))
        ClusterState state = createClusterForShardLimitTest(
    public void testDotIndexOpeningSucceeds() {
        );
        when(nodes.getDataNodes()).thenReturn(dataNodes);
        );
        state = addOpenedIndex(openIndexName, openIndexShards, openIndexReplicas, state);
            exception.getMessage()
        return new ShardLimitValidator(limitOnlySettings, clusterService, new SystemIndices(emptyMap()));
    }
    /**
            () -> shardLimitValidator.validateShardLimit(state, indices)
    }
            metadata.persistentSettings(Settings.EMPTY);
import static org.mockito.Mockito.mock;
                + 1
        );
 * You may obtain a copy of the License at
        Settings clusterSettings = Settings.builder().build();
            state.getNodes().getDataNodes().size(),
                + "] maximum LOCAL_ONLY shards open;",
        );
import org.opensearch.cluster.metadata.Metadata;
        ShardCounts counts = forDataNodeCount(nodesInCluster);
            dataNodes.put(randomAlphaOfLengthBetween(5, 15), mock(DiscoveryNode.class));
            () -> shardLimitValidator.validateShardLimit(state, indices)
                + "] total LOCAL_ONLY shards, but this cluster currently has ["
    }
        return ClusterState.builder(ClusterName.DEFAULT).metadata(metadata).nodes(nodes).build();
        assertTrue(errorMessage.isPresent());
            state.getMetadata().getTotalOpenIndexShards(),
            .put(SETTING_CLUSTER_IGNORE_DOT_INDEXES.getKey(), false)
            .put(SETTING_VERSION_CREATED, Version.CURRENT)
     * opening fails when it exceeds the cluster max shard limit if the
        return new ShardLimitValidator(limitOnlySettings, clusterService, new SystemIndices(emptyMap()));
        ClusterState state = createClusterForShardLimitTest(nodesInCluster, counts.getFirstIndexShards(), counts.getFirstIndexReplicas());
                + 2
        }
        Settings limitOnlySettings = Settings.builder()
            .toArray(new Index[2]);
            .build();
            RoutingPool.LOCAL_ONLY
        );
 * specific language governing permissions and limitations
     */
            nodesInCluster,
            -1,
                + maxShards
        int openIndexReplicas,
     * @param limitOnlySettings the setting used for creating ShardLimitValidator.
                + totalShards
     * even when it exceeds the cluster max shard limit
    }
        int maxShards = counts.getShardsPerNode() * nodesInCluster;
            ".ds-test-index",               // Adding closed data stream index to cluster state
    public void testNonSystemIndexCreationFails() {
            openIndexShards,
                + currentShards
     * This test validates that non-system index creation
 * Modifications Copyright OpenSearch Contributors. See
}
            counts.getFailingIndexReplicas()
            state.getMetadata().getTotalOpenIndexShards(),
        final ClusterState state = createClusterForShardLimitTest(1, 1, 0);
                + "] maximum LOCAL_ONLY shards open;",
import static java.util.Collections.emptyMap;
package org.opensearch.indices;
    public void testNonSystemIndexCreationPassesWithMaxShardLimitOnCluster() {
            .build();
        return createClusterForShardLimitTest(
        Index[] indices = Arrays.stream(state.metadata().indices().values().toArray(new IndexMetadata[0]))
                + 1
        int maxShards = counts.getShardsPerNode() * nodesInCluster;
        final ShardLimitValidator shardLimitValidator = createTestShardLimitService(4, true);
        int nodesInCluster = randomIntBetween(1, 90);
                + "] total LOCAL_ONLY shards, but this cluster currently has ["
            counts.getFailingIndexReplicas()
        ShardCounts counts = forDataNodeCount(nodesInCluster);
     * when the setting cluster.ignore_dot_indexes is set to false.
            randomAlphaOfLengthBetween(5, 15),
        ShardLimitValidator shardLimitValidator = createTestShardLimitService(counts.getShardsPerNode(), false);
        ClusterState state = createClusterForShardLimitTest(
     * @param maxShardsPerNode the value to use for the max shards per node setting
 * KIND, either express or implied.  See the License for the
        Settings limitOnlySettings = Settings.builder()
import org.opensearch.cluster.routing.RoutingPool;
            "Validation Failed: 1: this action would add ["
                + "]/["
     */
            ValidationException.class,
import org.opensearch.test.OpenSearchTestCase;
            .build();
        final ShardLimitValidator shardLimitValidator = createTestShardLimitService(1, false);
        int nodesInCluster = randomIntBetween(2, 90);
     * cluster.ignore_dot_indexes setting is set to true.
        );
            .put(SETTING_NUMBER_OF_SHARDS, 1)
        return new ShardLimitValidator(limitOnlySettings, clusterService, new SystemIndices(emptyMap()));
                + "]/["
    public void testOverShardLimit() {
                + (Integer.MAX_VALUE - 1)
                + 2
        final ValidationException exception = expectThrows(
            "Validation Failed: 1: this action would add ["
        ShardCounts counts = forDataNodeCount(nodesInCluster);
    public void testUnderShardLimit() {
    }
        final Settings settings = Settings.builder()
            state.getMetadata().getTotalOpenIndexShards(),
        final Settings settings = Settings.builder()
        assertTrue(errorMessage.isPresent());
        );
    public void testSystemIndexCreationSucceeds() {
import java.util.Map;
        int currentShards = counts.getFirstIndexShards() * (1 + counts.getFirstIndexReplicas());
            metadata.persistentSettings(Settings.EMPTY);
            .put(SETTING_VERSION_CREATED, Version.CURRENT)
            .put(SETTING_NUMBER_OF_REPLICAS, 1)
            counts.getFirstIndexShards(),
        Settings limitOnlySettings = Settings.builder()
     * This test validates that index having '.' in the first character
     * This test validates that non-system index opening
        Optional<String> errorMessage = ShardLimitValidator.checkShardLimit(
            .collect(Collectors.toList())
        return ClusterState.builder(state).metadata(metadata).nodes(nodes).build();
                + "] total LOCAL_ONLY shards, but this cluster currently has ["
            errorMessage.get()
    /**
import org.opensearch.core.index.Index;
        assertEquals(
     * This test validates that index starting with dot creation Succeeds
        );
    public static ShardLimitValidator createTestShardLimitService(int maxShardsPerNode, boolean ignoreDotIndexes) {
        );
        final Settings settings = Settings.builder()
                + "] total LOCAL_ONLY shards, but this cluster currently has ["
        final int maxShardLimitPerNode = 500_000_000;
        int nodesInCluster = randomIntBetween(1, 90);
        assertEquals(
    public static ClusterState createClusterForShardLimitTest(
        Settings limitOnlySettings = Settings.builder()
        Settings clusterSettings = Settings.builder().build();
    }
            .creationDate(randomLong())
        DiscoveryNodes nodes = mock(DiscoveryNodes.class);
                + "] maximum LOCAL_ONLY shards open",
            .put(SETTING_VERSION_CREATED, Version.CURRENT)
        if (randomBoolean()) {
        final ValidationException exception = expectThrows(
 * Licensed to Elasticsearch under one or more contributor
    }
        boolean ignoreDotIndexes,
    public void testDotIndexCreationSucceeds() {
    public void testComputedMaxShardsOfClusterIntOverFlow() {
 * not use this file except in compliance with the License.
            exception.getMessage()
    }
import org.opensearch.cluster.ClusterState;
            randomAlphaOfLengthBetween(5, 15),
        // Use a mocked clusterService - for unit tests we won't be updating the setting anyway.
    }
        int nodesInCluster,
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_REPLICAS;
    }
        ShardCounts counts = forDataNodeCount(nodesInCluster);
 */
import java.util.Arrays;
        final ValidationException exception = expectThrows(
        );
import org.opensearch.cluster.node.DiscoveryNodes;
import java.util.stream.Collectors;
            .put(SETTING_VERSION_CREATED, Version.CURRENT)
        int openIndexShards,
        ClusterState state = createClusterForShardLimitTest(15, 1, 1);
     * This test validates that index having '.' in the first character
        );
        when(nodes.getDataNodes()).thenReturn(dataNodes);
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_VERSION_CREATED;
                + "]/["
        int nodesInCluster,
        ClusterState state = createClusterForShardLimitTest(
                + maxShards
                + currentShards
            .put(SETTING_VERSION_CREATED, Version.CURRENT)
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_SHARDS;
            () -> shardLimitValidator.validateShardLimit(state, indices)
        int totalShards = counts.getFailingIndexShards() * (1 + counts.getFailingIndexReplicas());
 * compatible open source license.
        final ClusterState state = createClusterForShardLimitTest(1, 1, 0);
 *
            .put(SETTING_NUMBER_OF_REPLICAS, 1)
import org.opensearch.common.settings.ClusterSettings;
        when(clusterService.getClusterSettings()).thenReturn(
     * This test validates that index starting with '.ds-'
                + maxShardLimitOnCluster
        final ShardLimitValidator shardLimitValidator = createTestShardLimitService(1, false);
            ValidationException.class,
        );
        Optional<String> errorMessage = ShardLimitValidator.checkShardLimit(
        int totalShards = counts.getFailingIndexShards() * (1 + counts.getFailingIndexReplicas());
        );
                + "]/["
import java.util.HashMap;
        ShardCounts counts = forDataNodeCount(nodesInCluster);
            ".test-index",               // Adding closed index starting with dot to cluster state
            () -> shardLimitValidator.validateShardLimit(".test-index", settings, state)
     * Creates a {@link ShardLimitValidator} for testing with the given setting and a mocked cluster service.
import org.opensearch.cluster.ClusterName;
        ClusterService clusterService
            closedIndexReplicas
        String openIndexName,
     * when the setting cluster.ignore_dot_indexes is set to true.
            () -> shardLimitValidator.validateShardLimit("abc", settings, state)
        IndexMetadata.Builder indexMetadata = IndexMetadata.builder(randomAlphaOfLengthBetween(5, 15))
                + "] maximum LOCAL_ONLY shards open;",
     * cluster.ignore_dot_indexes is set to true.
    public void testDotIndexCreationFails() {
            .numberOfReplicas(replicas);
            "this action would add ["
     * @param ignoreDotIndexes validates if index starting with dot should be ignored or not
        ShardCounts counts = forDataNodeCount(nodesInCluster - 1);
            .put(SETTING_NUMBER_OF_SHARDS, 1)
            counts.getShardsPerNode(),
     *
                + 2
            RoutingPool.LOCAL_ONLY
    }
        final Settings settings = Settings.builder()
    public void testNonSystemIndexCreationFailsWithMaxShardLimitOnCluster() {
        int currentShards = counts.getFirstIndexShards() * (1 + counts.getFirstIndexReplicas());
        final ShardLimitValidator shardLimitValidator = createTestShardLimitService(limitOnlySettings);
     * @return a test instance
import org.opensearch.cluster.shards.ShardCounts;
            .collect(Collectors.toList())
            () -> shardLimitValidator.validateShardLimit(".ds-test-index", settings, state)
            .toArray(new Index[2]);
                + maxShards
            .map(IndexMetadata::getIndex)
        if (randomBoolean()) {
            nodesInCluster,
            .collect(Collectors.toList())
import org.opensearch.common.settings.Settings;
    ) {
            state.getMetadata().getTotalOpenIndexShards(),
        } else {
 */
        int maxShardsPerNode,
        ValidationException exception = expectThrows(
     */
            .put(SETTING_VERSION_CREATED, Version.CURRENT)
        ClusterState state = ClusterState.builder(ClusterName.DEFAULT).build();
    }
     * opening fails when it exceeds the cluster max shard limit if the
    public static ShardLimitValidator createTestShardLimitService(
     * fails when it exceeds the cluster max shard limit
            new ClusterSettings(limitOnlySettings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)
                + "] maximum LOCAL_ONLY shards open;",
            counts.getFirstIndexReplicas(),
        Metadata.Builder metadata = Metadata.builder().put(indexMetadata);
            .toArray(new Index[2]);
                + 2
                + 1
        }
            counts.getFirstIndexReplicas(),
/*
        int maxShards = counts.getShardsPerNode() * nodesInCluster;
        shardLimitValidator.validateShardLimit(".tasks", settings, state);
import static org.opensearch.indices.ShardLimitValidator.SETTING_CLUSTER_IGNORE_DOT_INDEXES;
        int closedIndexReplicas
 * under the License.
            .map(IndexMetadata::getIndex)
        ClusterService clusterService = mock(ClusterService.class);
        final ShardLimitValidator shardLimitValidator = createTestShardLimitService(1, false);
        int maxShardLimitOnCluster = shardsToAdd - 1;
    }
            .build();
            closedIndexShards,
        ClusterState state = createClusterForShardLimitTest(nodesInCluster, counts.getFirstIndexShards(), counts.getFirstIndexReplicas());
            .put(SETTING_VERSION_CREATED, Version.CURRENT)
            shardsToAdd,
            .put(SETTING_CLUSTER_MAX_SHARDS_PER_NODE.getKey(), maxShardsPerNode)
    }
        );
        final ClusterState state = createClusterForShardLimitTest(1, 1, 0);
            nodesInCluster,
            "Validation Failed: 1: this action would add ["
        final ShardLimitValidator shardLimitValidator = createTestShardLimitService(1, true);
        }
                + 2
    }
            .build();
            .put(SETTING_NUMBER_OF_SHARDS, 1)
    /**
        );
 * license agreements. See the NOTICE file distributed with
import static org.opensearch.cluster.shards.ShardCounts.forDataNodeCount;
            .build();
            counts.getFailingIndexReplicas()
        assertEquals(
        ShardLimitValidator shardLimitValidator = createTestShardLimitService(counts.getShardsPerNode(), true);
            "Validation Failed: 1: this action would add ["
import static org.mockito.Mockito.when;
    /**
            .map(IndexMetadata::getIndex)
        assertEquals(
        final ClusterState state = createClusterForShardLimitTest(1, 1, 0);
        final Map<String, DiscoveryNode> dataNodes = new HashMap<>();
        );
    /**
        ValidationException exception = expectThrows(
        );
        final Settings settings = Settings.builder()
        final Settings settings = Settings.builder()
     *
        final ClusterState state = createClusterForShardLimitTest(1, 1, 0);
            .map(IndexMetadata::getIndex)
        );
     * Creates a {@link ShardLimitValidator} for testing with the given setting and a mocked cluster service.
    /**
            .put(SETTING_CLUSTER_MAX_SHARDS_PER_NODE.getKey(), maxShardsPerNode)
        int shardsToAdd = counts.getFailingIndexShards() * (1 + counts.getFailingIndexReplicas());
        Index[] indices = Arrays.stream(state.metadata().indices().values().toArray(new IndexMetadata[0]))
            dataNodes.put(randomAlphaOfLengthBetween(5, 15), mock(DiscoveryNode.class));
            counts.getFailingIndexShards(),
            errorMessage.get()
 *
            2,
        int nodesInCluster = randomIntBetween(2, 90);
            exception.getMessage()
        );
        assertEquals(
    }
import static org.opensearch.indices.ShardLimitValidator.SETTING_CLUSTER_MAX_SHARDS_PER_NODE;
            .build();
            "Validation Failed: 1: this action would add ["
                + "]/["
        assertEquals(
import org.opensearch.Version;
        for (int i = 0; i < nodesInCluster; i++) {
 * GitHub history for details.
            nodesInCluster,
        Optional<String> errorMessage = ShardLimitValidator.checkShardLimit(
            exception.getMessage()
     * even though it exceeds the cluster max shard limit
        ShardLimitValidator shardLimitValidator = createTestShardLimitService(counts.getShardsPerNode(), false);
     * when the cluster.ignore_dot_indexes is set to true, and we don't reach the max shard per node limit.
    }
            ValidationException.class,
            counts.getFirstIndexShards(),
                + "] total LOCAL_ONLY shards, but this cluster currently has ["
        int closedIndexReplicas
                + 1
            .put(SETTING_NUMBER_OF_REPLICAS, 1)
            ValidationException.class,
    ) {
            ValidationException.class,
public class ShardLimitValidatorTests extends OpenSearchTestCase {
 * this work for additional information regarding copyright
            .put(SETTING_NUMBER_OF_SHARDS, 1)
        int currentShards = counts.getFirstIndexShards() * (1 + counts.getFirstIndexReplicas());
     */
        final Map<String, DiscoveryNode> dataNodes = new HashMap<>();
import org.opensearch.cluster.service.ClusterService;
            .put(SETTING_MAX_SHARDS_PER_CLUSTER_KEY, maxShardLimitOnCluster)
        final ClusterState state = createClusterForShardLimitTest(1, 1, 0);
     * This test validates that system index creation succeeds
            counts.getFirstIndexShards(),
     * cluster.ignore_dot_indexes is set to false.
    }
            "this action would add ["
            randomAlphaOfLengthBetween(5, 15),
     * @return a test instance
        ClusterState state = createClusterForShardLimitTest(
     * when the cluster.ignore_dot_indexes is set to true, and we reach the max shard per node limit.
        shardLimitValidator.validateShardLimit(state, indices);
        int totalShards = counts.getFailingIndexShards() * (1 + counts.getFailingIndexReplicas());
     * This test validates that index starting with dot creation fails
                + "] maximum LOCAL_ONLY shards open;",
            metadata.transientSettings(Settings.EMPTY);
            counts.getFirstIndexShards(),
                + Integer.MAX_VALUE
            -1,
                + 1
            "Validation Failed: 1: this action would add ["
    }
            maxShardLimitPerNode,
                + "] maximum LOCAL_ONLY shards open",
    /**
        );
            exception.getMessage()
                + currentShards
            .put(SETTING_CLUSTER_IGNORE_DOT_INDEXES.getKey(), ignoreDotIndexes)
                + totalShards
            .build();
     */
    ) {
            randomAlphaOfLengthBetween(5, 15),
        assertEquals(
                + "]/["
            .build();
                + "] maximum LOCAL_ONLY shards open;",
        assertEquals(
        int maxShards = counts.getShardsPerNode() * nodesInCluster;
        ClusterService clusterService = mock(ClusterService.class);
/*
 * ownership. Elasticsearch licenses this file to you under
        );
 *     http://www.apache.org/licenses/LICENSE-2.0
     */
            .toArray(new Index[2]);
     */
        final ClusterState state = createClusterForShardLimitTest(1, 1, 0);
 * Unless required by applicable law or agreed to in writing,
        when(clusterService.getClusterSettings()).thenReturn(
        int closedIndexShards,
     * opening of such indexes succeeds even when it exceeds the cluster max shard limit if the
        int nodesInCluster = randomIntBetween(2, 90);
            .put(SETTING_NUMBER_OF_SHARDS, 1)
        );
            nodesInCluster,
 * SPDX-License-Identifier: Apache-2.0
            randomAlphaOfLengthBetween(5, 15),
        assertEquals(
                + "]/["
                + 1
     * This test validates that system index opening succeeds
import org.opensearch.cluster.node.DiscoveryNode;
        final ValidationException exception = expectThrows(
    /**
                + "] total LOCAL_ONLY shards, but this cluster currently has ["
     * @param ignoreDotIndexes validates if index starting with dot should be ignored or not
        );
        }
import org.opensearch.cluster.metadata.IndexMetadata;
            Integer.MAX_VALUE - 1,
        // Shard limit validation succeeds without any issues
            .numberOfShards(shardsInIndex)
        ClusterState state = createClusterForShardLimitTest(
            .collect(Collectors.toList())
            counts.getFirstIndexReplicas(),
        } else {
            ValidationException.class,
        );
            RoutingPool.LOCAL_ONLY
        shardLimitValidator.validateShardLimit(".test-index", settings, state);
        int shardsToAdd = randomIntBetween(1, (counts.getShardsPerNode() * nodesInCluster) - existingShards);
            maxShardLimitPerNode,
                + totalShards
        ShardLimitValidator shardLimitValidator = createTestShardLimitService(counts.getShardsPerNode(), false);
 * this file be licensed under the Apache-2.0 license or a
        ShardLimitValidator shardLimitValidator = createTestShardLimitService(counts.getShardsPerNode(), true);
            new ClusterSettings(limitOnlySettings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)
        for (int i = 0; i < nodesInCluster; i++) {
            .collect(Collectors.toList())
        final Settings settings = Settings.builder()
            openIndexReplicas,
    /**
            errorMessage.get()
        int openIndexShards,
                + "]/["
            .put(SETTING_CLUSTER_IGNORE_DOT_INDEXES.getKey(), false)
            .map(IndexMetadata::getIndex)
    /**
                + maxShards
            counts.getFailingIndexShards(),
            -1,
            .toArray(new Index[2]);
        ShardCounts counts = forDataNodeCount(nodesInCluster);
import org.opensearch.common.ValidationException;
        int openIndexReplicas,
            "Validation Failed: 1: this action would add ["
        int existingShards = counts.getFirstIndexShards() * (1 + counts.getFirstIndexReplicas());
            shardsToAdd,
            RoutingPool.LOCAL_ONLY
            state.getMetadata().getTotalOpenIndexShards(),
        assertEquals(
        // Calculate the counts for a cluster 1 node smaller than we have to ensure we have headroom
    public void testDataStreamIndexOpeningFails() {
            .put(SETTING_NUMBER_OF_SHARDS, 1)
            exception.getMessage()
     */
        int totalShards = counts.getFailingIndexShards() * (1 + counts.getFailingIndexReplicas());
     */
        );
import static org.opensearch.indices.ShardLimitValidator.SETTING_MAX_SHARDS_PER_CLUSTER_KEY;
            .build();
                + "] total LOCAL_ONLY shards, but this cluster currently has ["
import static org.opensearch.cluster.metadata.MetadataIndexStateServiceTests.addOpenedIndex;
    public void testNonSystemIndexOpeningFails() {
        );
        int nodesInCluster = randomIntBetween(2, 90);
    public void testDataStreamIndexCreationSucceeds() {
            metadata.transientSettings(Settings.EMPTY);
            .put(SETTING_NUMBER_OF_REPLICAS, 1)
            .put(SETTING_CLUSTER_MAX_SHARDS_PER_NODE.getKey(), 3)
            .put(SETTING_NUMBER_OF_SHARDS, 1)
     */
    private static ShardLimitValidator createTestShardLimitService(final Settings limitOnlySettings) {
            () -> shardLimitValidator.validateShardLimit("abc", settings, state)
        int nodesInCluster = randomIntBetween(2, 90);
        final int maxShardLimitOnCluster = 1;
        final ShardLimitValidator shardLimitValidator = createTestShardLimitService(limitOnlySettings);
        Index[] indices = Arrays.stream(state.metadata().indices().values().toArray(new IndexMetadata[0]))
            nodesInCluster,
     */
            .put(SETTING_NUMBER_OF_REPLICAS, 1)
                + currentShards
            "this action would add ["
    /**
 * The OpenSearch Contributors require contributions made to
        ClusterState state = createClusterForShardLimitTest(nodesInCluster, counts.getFirstIndexShards(), counts.getFirstIndexReplicas());
            ".test-index",               // Adding closed index starting with dot to cluster state
        int currentShards = counts.getFirstIndexShards() * (1 + counts.getFirstIndexReplicas());
            .put(SETTING_NUMBER_OF_REPLICAS, 1)
    /**
