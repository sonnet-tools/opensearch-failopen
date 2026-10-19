            () -> shardLimitValidator.validateShardLimit(".ds-test-index", settings, state)
            exception.getMessage()
        final Settings settings = Settings.builder()
        int currentShards = counts.getFirstIndexShards() * (1 + counts.getFirstIndexReplicas());
        );
            counts.getFirstIndexShards(),
        Index[] indices = Arrays.stream(state.metadata().indices().values().toArray(new IndexMetadata[0]))  
/*  
        Metadata.Builder metadata = Metadata.builder().put(indexMetadata);
            randomAlphaOfLengthBetween(5, 15),
            randomAlphaOfLengthBetween(5, 15),  
     */  
            "Validation Failed: 1: this action would add ["  
                + currentShards  
        );  
        );
     */
        assertEquals(  
            ValidationException.class,
            state.getMetadata().getTotalOpenIndexShards(),  
            counts.getShardsPerNode(),
            "this action would add ["
        errorMessage = ShardLimitValidator.checkShardLimit(  
            randomAlphaOfLengthBetween(5, 15),
    }
    }
                + "] total LOCAL_ONLY shards, but this cluster currently has ["  
            RoutingPool.LOCAL_ONLY  
 * software distributed under the License is distributed on an
    public static ClusterState createClusterForShardLimitTest(int nodesInCluster, int shardsInIndex, int replicas) {
        // Use a mocked clusterService - for unit tests we won't be updating the setting anyway.  
     * This test validates that index having '.' in the first character  
            nodesInCluster,
import static org.mockito.Mockito.when;
            exception.getMessage()  
            .build();
    ) {  
        ShardCounts counts = forDataNodeCount(nodesInCluster);
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_SHARDS;
        int closedIndexShards,  
            new ClusterSettings(limitOnlySettings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)  
                + totalShards
                + "]/["  
        assertFalse(errorMessage.isPresent());
     * @param limitOnlySettings the setting used for creating ShardLimitValidator.
        final ClusterState state = createClusterForShardLimitTest(1, 1, 0);  
            state.getNodes().getDataNodes().size(),
                + "]/["
        );  
            .put(SETTING_VERSION_CREATED, Version.CURRENT)
        );
import static org.mockito.Mockito.mock;  
     * @param ignoreDotIndexes validates if index starting with dot should be ignored or not
            .build();
            "this action would add ["  
        );
        ShardCounts counts = forDataNodeCount(nodesInCluster);
                + "]/["
        assertEquals(
        );
        int maxShards = counts.getShardsPerNode() * nodesInCluster;
            .map(IndexMetadata::getIndex)
     * cluster.ignore_dot_indexes setting is set to true.
        shardLimitValidator.validateShardLimit(".test-index", settings, state);
                + 2
            nodesInCluster,
        if (randomBoolean()) {  
            .put(SETTING_CLUSTER_IGNORE_DOT_INDEXES.getKey(), ignoreDotIndexes)  
     * This test validates that system index creation succeeds
        final int maxShardLimitOnCluster = 5;  
            nodesInCluster,
            counts.getFirstIndexShards(),
        int openIndexShards,
            randomAlphaOfLengthBetween(5, 15),
    }
        ShardCounts counts = forDataNodeCount(nodesInCluster);
    /**
        ClusterState state = createClusterForShardLimitTest(nodesInCluster, counts.getFirstIndexShards(), counts.getFirstIndexReplicas());
        IndexMetadata.Builder indexMetadata = IndexMetadata.builder(randomAlphaOfLengthBetween(5, 15))  
            exception.getMessage()
            metadata.transientSettings(Settings.EMPTY);  
     * cluster.ignore_dot_indexes is set to true.  
            .put(SETTING_NUMBER_OF_REPLICAS, 1)  
     */
        );
            () -> shardLimitValidator.validateShardLimit("abc", settings, state)  
        int totalShards = counts.getFailingIndexShards() * (1 + counts.getFailingIndexReplicas());
        ValidationException exception = expectThrows(
        int nodesInCluster = randomIntBetween(2, 90);  
        int nodesInCluster = randomIntBetween(1, 90);
        ShardCounts counts = forDataNodeCount(nodesInCluster - 1);
 *     http://www.apache.org/licenses/LICENSE-2.0
     * This test validates that system index opening succeeds
            ValidationException.class,
        final ClusterState state = createClusterForShardLimitTest(1, 1, 0);  
            .toArray(new Index[2]);
        Index[] indices = Arrays.stream(state.metadata().indices().values().toArray(new IndexMetadata[0]))  
            state.getNodes().getDataNodes().size(),  
        assertEquals(  
     * This test validates that dataStream index creation fails  
    public void testNonSystemIndexCreationFails() {
     */
        }  
                + "]/["  
            ValidationException.class,  
     * This test validates that non-system index creation
    }  
            exception.getMessage()  
                + maxShards
import org.opensearch.cluster.shards.ShardCounts;
        final Settings settings = Settings.builder()
        final Settings settings = Settings.builder()
        int nodesInCluster = randomIntBetween(2, 90);  
        final ValidationException exception = expectThrows(
    /**  
                + "] maximum LOCAL_ONLY shards open;",  
 * compatible open source license.
    }
            .collect(Collectors.toList())
            .put(SETTING_VERSION_CREATED, Version.CURRENT)
            .put(SETTING_MAX_SHARDS_PER_CLUSTER_KEY, maxShardLimitOnCluster)
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            openIndexShards,  
     * fails when it exceeds the cluster max shard limit
                + "] maximum LOCAL_ONLY shards open;",  
        final ShardLimitValidator shardLimitValidator = createTestShardLimitService(1, true);  
        int currentShards = counts.getFirstIndexShards() * (1 + counts.getFirstIndexReplicas());  
            counts.getFirstIndexShards(),  
        );
                + maxShardLimitOnCluster
            .put(SETTING_NUMBER_OF_SHARDS, 1)  
        int maxShards = Math.min(counts.getShardsPerNode() * nodesInCluster, maxShardLimitOnCluster);  
        when(nodes.getDataNodes()).thenReturn(dataNodes);
        shardLimitValidator.validateShardLimit("abc", settings, state);
        );  
            () -> shardLimitValidator.validateShardLimit("abc", settings, state)  
        int openIndexReplicas,
                + "] maximum LOCAL_ONLY shards open;",
    }  
        assertEquals(
        ShardLimitValidator shardLimitValidator = createTestShardLimitService(counts.getShardsPerNode(), true);
            () -> shardLimitValidator.validateShardLimit(".test-index", settings, state)  
        ValidationException exception = expectThrows(  
        int nodesInCluster = randomIntBetween(2, 90);
        int nodesInCluster = randomIntBetween(2, 90);  
     */
                + 1  
 * GitHub history for details.
        state = addClosedIndex(closeIndexName, closedIndexShards, closedIndexReplicas, state);  
import static org.opensearch.indices.ShardLimitValidator.SETTING_CLUSTER_MAX_SHARDS_PER_NODE;
            .settings(Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT))
        final Settings settings = Settings.builder()
        return new ShardLimitValidator(limitOnlySettings, clusterService, new SystemIndices(emptyMap()));  
            state.getMetadata().getTotalOpenIndexShards(),
            ValidationException.class,
            .toArray(new Index[2]);  
 * the Apache License, Version 2.0 (the "License"); you may
                + "]/["
        int nodesInCluster = randomIntBetween(1, 90);  
        int totalShards = counts.getFailingIndexShards() * (1 + counts.getFailingIndexReplicas());
 * this work for additional information regarding copyright
            2,  
     * @param maxShardsPerNode the value to use for the max shards per node setting  
    ) {
     * @param maxShardsPerNode the value to use for the max shards per node setting  
        return ClusterState.builder(state).metadata(metadata).nodes(nodes).build();
                + "]/["
        );
    public void testSystemIndexOpeningSucceeds() {
        shardLimitValidator.validateShardLimit(".tasks", settings, state);
        assertEquals(
import java.util.Optional;
        final ShardLimitValidator shardLimitValidator = createTestShardLimitService(1, true);
        Optional<String> errorMessage = ShardLimitValidator.checkShardLimit(
                + totalShards
        // Calculate the counts for a cluster 1 node smaller than we have to ensure we have headroom
                + 2
     */
            .put(SETTING_CLUSTER_MAX_SHARDS_PER_NODE.getKey(), maxShardsPerNode)
    }  
                + 1
        final int maxShardLimitPerNode = 500_000_000;  
                + "] total LOCAL_ONLY shards, but this cluster currently has ["
                + 1
        }
public class ShardLimitValidatorTests extends OpenSearchTestCase {  
            .put(SETTING_NUMBER_OF_REPLICAS, 1)
    public void testNonSystemIndexCreationPassesWithMaxShardLimitOnCluster() {
        Settings limitOnlySettings = Settings.builder()
        when(nodes.getDataNodes()).thenReturn(dataNodes);
        final ValidationException exception = expectThrows(
     * Creates a {@link ShardLimitValidator} for testing with the given setting and a mocked cluster service.  
            -1,  
        int maxShards = counts.getShardsPerNode() * nodesInCluster;  
            counts.getShardsPerNode(),
        ShardCounts counts = forDataNodeCount(nodesInCluster);  
        );
    }
     * opening of such indexes succeeds even when it exceeds the cluster max shard limit if the  
            metadata.persistentSettings(Settings.EMPTY);
        final ShardLimitValidator shardLimitValidator = createTestShardLimitService(limitOnlySettings);  
            closedIndexReplicas
        final ShardLimitValidator shardLimitValidator = createTestShardLimitService(4, true);
    public void testNonSystemIndexOpeningFails() {
        );
        }
        );  
            state.getMetadata().getTotalOpenIndexShards(),  
        int existingShards = counts.getFirstIndexShards() * (1 + counts.getFirstIndexReplicas());
            counts.getFirstIndexReplicas(),  
        int maxShardLimitOnCluster = shardsToAdd - 1;  
        int totalShards = counts.getFailingIndexShards() * (1 + counts.getFailingIndexReplicas());
/*  
    }
        DiscoveryNodes nodes = mock(DiscoveryNodes.class);
    public static ShardLimitValidator createTestShardLimitService(int maxShardsPerNode, boolean ignoreDotIndexes) {
            counts.getFirstIndexShards(),  
            RoutingPool.LOCAL_ONLY
        int currentShards = counts.getFirstIndexShards() * (1 + counts.getFirstIndexReplicas());  
    /**
    public void testOverShardLimitWithMaxShardCountLimit() {  
        final int maxShardLimitOnCluster = 1;  
            counts.getFailingIndexReplicas()
 *
     * @param clusterService   the cluster service to use
            ValidationException.class,
                + Integer.MAX_VALUE
                + "] total LOCAL_ONLY shards, but this cluster currently has ["
            "Validation Failed: 1: this action would add ["
        ShardLimitValidator shardLimitValidator = createTestShardLimitService(counts.getShardsPerNode(), false);
    }
import org.opensearch.common.ValidationException;
            -1,  
                + totalShards
            counts.getFailingIndexReplicas()  
        final ShardLimitValidator shardLimitValidator = createTestShardLimitService(1, false);  
     * @return a test instance  
    /**  
            .build();
     * @param ignoreDotIndexes validates if index starting with dot should be ignored or not
                + maxShards
        Settings limitOnlySettings = Settings.builder()
            metadata.transientSettings(Settings.EMPTY);
     * cluster.ignore_dot_indexes is set to false.
    public void testDataStreamIndexCreationFails() {  
        ClusterState state = createClusterForShardLimitTest(nodesInCluster, counts.getFirstIndexShards(), counts.getFirstIndexReplicas());  
        );  
        final Map<String, DiscoveryNode> dataNodes = new HashMap<>();
    public void testDotIndexOpeningSucceeds() {  
            .build();
        );
            .put(SETTING_CLUSTER_IGNORE_DOT_INDEXES.getKey(), false)  
 */
    }
     * when the cluster.ignore_dot_indexes is set to true, and we don't reach the max shard per node limit.
        shardLimitValidator.validateShardLimit(".ds-test-index", settings, state);  
    public static ShardLimitValidator createTestShardLimitService(
        }
    }
            -1,
            "Validation Failed: 1: this action would add ["
            nodesInCluster,  
     * @return a test instance
            randomAlphaOfLengthBetween(5, 15),
        ClusterService clusterService
            .put(SETTING_VERSION_CREATED, Version.CURRENT)
            counts.getFailingIndexShards(),
            errorMessage.get()
        final ClusterState state = createClusterForShardLimitTest(1, 1, 0);  
        );
            ".test-index",               // Adding closed index starting with dot to cluster state  
    }  
    public void testUnderShardLimit() {
            .build();  
                + "] maximum LOCAL_ONLY shards open",  
import static org.opensearch.indices.ShardLimitValidator.SETTING_CLUSTER_IGNORE_DOT_INDEXES;  
            counts.getFailingIndexReplicas()  
            shardsToAdd,
            -1,
    /**  
            shardsToAdd,
        final ClusterState state = createClusterForShardLimitTest(1, 1, 0);  
        return createClusterForShardLimitTest(  
        int openIndexShards,  
        assertEquals(
                + "] maximum LOCAL_ONLY shards open;",
package org.opensearch.indices;
                + currentShards
                + "] total LOCAL_ONLY shards, but this cluster currently has ["
                + currentShards
        ClusterService clusterService = mock(ClusterService.class);  
        final Settings settings = Settings.builder()  
 */  
        int totalShards = counts.getFailingIndexShards() * (1 + counts.getFailingIndexReplicas());
import static org.opensearch.cluster.metadata.MetadataIndexStateServiceTests.addClosedIndex;  
                + (Integer.MAX_VALUE - 1)
                + maxShards  
                + "] maximum LOCAL_ONLY shards open;",  
                + 1
 * You may obtain a copy of the License at  
    public void testDotIndexCreationFails() {
import org.opensearch.cluster.ClusterName;
    }
                + 1  
            .put(SETTING_NUMBER_OF_SHARDS, 1)
            .put(SETTING_NUMBER_OF_SHARDS, 1)  
        int nodesInCluster = randomIntBetween(2, 90);
            state.getNodes().getDataNodes().size(),
 * KIND, either express or implied.  See the License for the
    }  
        int currentShards = counts.getFirstIndexShards() * (1 + counts.getFirstIndexReplicas());  
            .put(SETTING_NUMBER_OF_REPLICAS, 1)
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_REPLICAS;  
            .collect(Collectors.toList())  
        int totalShards = counts.getFailingIndexShards() * (1 + counts.getFailingIndexReplicas());
    /**
    }  
        ClusterState state = createClusterForShardLimitTest(nodesInCluster, counts.getFirstIndexShards(), counts.getFirstIndexReplicas());
        assertFalse(errorMessage.isPresent());
        );  
            .toArray(new Index[2]);  
import static java.util.Collections.emptyMap;
 * The OpenSearch Contributors require contributions made to  
        int closedIndexShards,  
            ".ds-test-index",               // Adding closed data stream index to cluster state
            .map(IndexMetadata::getIndex)
 * this file be licensed under the Apache-2.0 license or a
        ShardLimitValidator shardLimitValidator = createTestShardLimitService(counts.getShardsPerNode(), false);  
     * when the setting cluster.ignore_dot_indexes is set to true.  
    /**
     *
        Index[] indices = Arrays.stream(state.metadata().indices().values().toArray(new IndexMetadata[0]))
/*
            .put(SETTING_VERSION_CREATED, Version.CURRENT)  
            .put(SETTING_NUMBER_OF_REPLICAS, 1)
            .put(SETTING_NUMBER_OF_SHARDS, 1)
            () -> shardLimitValidator.validateShardLimit(state, indices)
        );  
        int nodesInCluster = randomIntBetween(2, 90);
     * This test validates that non-system index opening
     * This test validates that index starting with '.ds-'
        ClusterState state = ClusterState.builder(ClusterName.DEFAULT).build();
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_VERSION_CREATED;
            "Validation Failed: 1: this action would add ["
        Optional<String> errorMessage = ShardLimitValidator.checkShardLimit(
    public void testNonSystemIndexCreationFailsWithMaxShardLimitOnCluster() {
            counts.getFirstIndexReplicas(),
        shardLimitValidator.validateShardLimit(state, indices);
            .put(SETTING_NUMBER_OF_REPLICAS, 1)
import java.util.Map;
                + 2
    /**
import java.util.stream.Collectors;  
import org.opensearch.Version;
     * opening fails when it exceeds the cluster max shard limit if the
        return new ShardLimitValidator(limitOnlySettings, clusterService, new SystemIndices(emptyMap()));  
        final ClusterState state = createClusterForShardLimitTest(1, 1, 0);
     */
     * when the setting cluster.ignore_dot_indexes is set to false.  
        Settings limitOnlySettings = Settings.builder()
     * This test validates that dataStream index creation succeeds
                + "]/["
     * This test validates that index starting with dot creation Succeeds
            .put(SETTING_NUMBER_OF_SHARDS, 1)  
     * opening fails when it exceeds the cluster max shard limit if the
     *
            counts.getShardsPerNode(),
                + 1  
            errorMessage.get()
                + "]/["
import static org.opensearch.cluster.shards.ShardCounts.forDataNodeCount;
    /**
        final Map<String, DiscoveryNode> dataNodes = new HashMap<>();  
                + 1  
            .put(SETTING_CLUSTER_IGNORE_DOT_INDEXES.getKey(), ignoreDotIndexes)  
                + "] total LOCAL_ONLY shards, but this cluster currently has ["  
        int closedIndexReplicas
            exception.getMessage()
            randomAlphaOfLengthBetween(5, 15),
 * specific language governing permissions and limitations
        );
     * fails when it exceeds the cluster max shard limit  
            errorMessage.get()
            ".tasks",               // Adding closed system index to cluster state
            .collect(Collectors.toList())
     * This test validates that index having '.' in the first character
        ClusterState state = createClusterForShardLimitTest(
        ShardCounts counts = forDataNodeCount(nodesInCluster);  
                + "] total LOCAL_ONLY shards, but this cluster currently has ["
        final ClusterState state = createClusterForShardLimitTest(1, 1, 0);  
        Settings limitOnlySettings = Settings.builder()
import org.opensearch.cluster.service.ClusterService;  
            .build();
     *
}
    ) {
            .put(SETTING_NUMBER_OF_SHARDS, 1)  
        return ClusterState.builder(ClusterName.DEFAULT).metadata(metadata).nodes(nodes).build();  
    }
        assertEquals(  
        );
        final Metadata.Builder metadata = Metadata.builder(state.metadata());
import org.opensearch.cluster.node.DiscoveryNodes;
        final ShardLimitValidator shardLimitValidator = createTestShardLimitService(limitOnlySettings);  
        final ValidationException exception = expectThrows(
        assertEquals(
     */
    public void testOverShardLimit() {
            counts.getFirstIndexShards(),
        assertEquals(
        int nodesInCluster,
        );
        Settings clusterSettings = Settings.builder().build();  
            shardsToAdd,  
        boolean ignoreDotIndexes,
        Settings clusterSettings = Settings.builder().build();
        final Settings settings = Settings.builder()
     * when the cluster.ignore_dot_indexes is set to true, and we reach the max shard per node limit.
    }
        );
    /**
        );
            maxShardLimitPerNode,  
            .put(SETTING_NUMBER_OF_REPLICAS, 1)
            ".test-index",               // Adding closed index starting with dot to cluster state
        when(clusterService.getClusterSettings()).thenReturn(
    /**  
            dataNodes.put(randomAlphaOfLengthBetween(5, 15), mock(DiscoveryNode.class));
                + "]/["
                + "] maximum LOCAL_ONLY shards open;",
     * Creates a {@link ShardLimitValidator} for testing with the given setting and a mocked cluster service.
            "Validation Failed: 1: this action would add ["  
                + "] maximum LOCAL_ONLY shards open",  
            "Validation Failed: 1: this action would add ["  
import java.util.Arrays;
        );
    public void testComputedMaxShardsOfClusterIntOverFlow() {
        int maxShards = counts.getShardsPerNode() * nodesInCluster;
                + "] maximum LOCAL_ONLY shards open;",
            dataNodes.put(randomAlphaOfLengthBetween(5, 15), mock(DiscoveryNode.class));
 * ownership. Elasticsearch licenses this file to you under  
        if (randomBoolean()) {  
        assertEquals(
import org.opensearch.common.settings.Settings;
                + "] total LOCAL_ONLY shards, but this cluster currently has ["
            .toArray(new Index[2]);  
        );
            metadata.persistentSettings(Settings.EMPTY);  
            Integer.MAX_VALUE - 1,
        shardLimitValidator.validateShardLimit(state, indices);
        final Settings settings = Settings.builder()
            counts.getFailingIndexReplicas()
            nodesInCluster,
            .build();
            .put(SETTING_VERSION_CREATED, Version.CURRENT)
    public void testSystemIndexCreationSucceeds() {
        // Use a mocked clusterService - for unit tests we won't be updating the setting anyway.
            openIndexReplicas,
    }
        Index[] indices = Arrays.stream(state.metadata().indices().values().toArray(new IndexMetadata[0]))
    /**  
            .put(SETTING_CLUSTER_MAX_SHARDS_PER_NODE.getKey(), 3)
            .put(SETTING_VERSION_CREATED, Version.CURRENT)
            .collect(Collectors.toList())
        ShardCounts counts = forDataNodeCount(nodesInCluster);
            .put(SETTING_NUMBER_OF_SHARDS, 1)  
            counts.getFailingIndexShards(),
    /**
                + 2  
        ClusterState state = createClusterForShardLimitTest(15, 1, 1);
        DiscoveryNodes nodes = mock(DiscoveryNodes.class);  
        ClusterState state = createClusterForShardLimitTest(
    public void testDataStreamIndexCreationSucceeds() {
            exception.getMessage()
    public void testDotIndexCreationSucceeds() {
                + 2
import org.opensearch.cluster.metadata.Metadata;
import static org.opensearch.cluster.metadata.MetadataIndexStateServiceTests.addOpenedIndex;
            .map(IndexMetadata::getIndex)
                + "] total LOCAL_ONLY shards, but this cluster currently has ["  
            closedIndexShards,  
        Optional<String> errorMessage = ShardLimitValidator.checkShardLimit(
            counts.getFirstIndexReplicas(),
        final ClusterState state = createClusterForShardLimitTest(1, 1, 0);
     * @return a test instance  
        // Shard limit validation succeeds without any issues  
        final Settings settings = Settings.builder()
        final ClusterState state = createClusterForShardLimitTest(1, 1, 0);  
            .build();
        String closeIndexName,
            ValidationException.class,  
    public void testDataStreamIndexOpeningFails() {
            RoutingPool.LOCAL_ONLY
        ShardLimitValidator shardLimitValidator = createTestShardLimitService(counts.getShardsPerNode(), false);
            .put(SETTING_MAX_SHARDS_PER_CLUSTER_KEY, maxShardLimitOnCluster)
        } else {
                + maxShards  
    }  
        ClusterState state = createClusterForShardLimitTest(
                + currentShards
            .put(SETTING_CLUSTER_MAX_SHARDS_PER_NODE.getKey(), maxShardsPerNode)
     * Creates a {@link ShardLimitValidator} for testing with the given setting and a given cluster service.
        );  
    }
        // Shard limit validation succeeds without any issues as system index is being opened
                + totalShards  
            .build();
        ValidationException exception = expectThrows(  
            .put(SETTING_CLUSTER_MAX_SHARDS_PER_NODE.getKey(), 1)
        String openIndexName,
            counts.getFailingIndexReplicas()  
            .map(IndexMetadata::getIndex)  
        int closedIndexReplicas
            RoutingPool.LOCAL_ONLY
        } else {
        for (int i = 0; i < nodesInCluster; i++) {
    public static ClusterState createClusterForShardLimitTest(  
            "Validation Failed: 1: this action would add ["
            counts.getFailingIndexShards(),
 * license agreements. See the NOTICE file distributed with
            .build();
            .numberOfReplicas(replicas);
        return new ShardLimitValidator(limitOnlySettings, clusterService, new SystemIndices(emptyMap()));  
            ValidationException.class,
            state.getNodes().getDataNodes().size(),
            RoutingPool.LOCAL_ONLY
            .map(IndexMetadata::getIndex)
        ShardCounts counts = forDataNodeCount(nodesInCluster);
    }  
            counts.getFirstIndexReplicas(),
            state.getMetadata().getTotalOpenIndexShards(),
        );
import org.opensearch.cluster.ClusterState;  
        Optional<String> errorMessage = ShardLimitValidator.checkShardLimit(
                + "] maximum LOCAL_ONLY shards open",
            .put(SETTING_NUMBER_OF_SHARDS, 1)  
    }
        final ShardLimitValidator shardLimitValidator = createTestShardLimitService(1, false);  
        Index[] indices = Arrays.stream(state.metadata().indices().values().toArray(new IndexMetadata[0]))  
        int maxShardsPerNode,  
        int shardsToAdd = counts.getFailingIndexShards() * (1 + counts.getFailingIndexReplicas());
        int openIndexReplicas,
            maxShardLimitOnCluster,
     * This test validates that index starting with dot creation fails
        assertTrue(errorMessage.isPresent());
        int shardsToAdd = randomIntBetween(1, (counts.getShardsPerNode() * nodesInCluster) - existingShards);  
            .build();
            maxShardLimitPerNode,
import org.opensearch.cluster.metadata.IndexMetadata;
 *
 * Modifications Copyright OpenSearch Contributors. See
     */
        ClusterState state = createClusterForShardLimitTest(
import org.opensearch.test.OpenSearchTestCase;  
    public static ClusterState createClusterForShardLimitTest(
        int currentShards = counts.getFirstIndexShards() * (1 + counts.getFirstIndexReplicas());
     */  
        state = addOpenedIndex(openIndexName, openIndexShards, openIndexReplicas, state);
    /**
    private static ShardLimitValidator createTestShardLimitService(final Settings limitOnlySettings) {
        ClusterState state = createClusterForShardLimitTest(  
     */
            counts.getFailingIndexShards(),  
 * Unless required by applicable law or agreed to in writing,
 * not use this file except in compliance with the License.
        when(clusterService.getClusterSettings()).thenReturn(
            () -> shardLimitValidator.validateShardLimit(state, indices)
     * even though it exceeds the cluster max shard limit  
            exception.getMessage()
            .numberOfShards(shardsInIndex)  
            .collect(Collectors.toList())
        int nodesInCluster,  
import org.opensearch.cluster.routing.RoutingPool;
     * even when it exceeds the cluster max shard limit  
import static org.opensearch.indices.ShardLimitValidator.SETTING_MAX_SHARDS_PER_CLUSTER_KEY;
            .toArray(new Index[2]);
            .put(SETTING_VERSION_CREATED, Version.CURRENT)
            counts.getFailingIndexShards(),
            counts.getFirstIndexReplicas(),  
 *  
            state.getMetadata().getTotalOpenIndexShards(),
        for (int i = 0; i < nodesInCluster; i++) {  
        int maxShards = counts.getShardsPerNode() * nodesInCluster;
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.core.index.Index;
                + "] total LOCAL_ONLY shards, but this cluster currently has ["
            "this action would add ["  
import org.opensearch.common.settings.ClusterSettings;  
            .creationDate(randomLong())
            .put(SETTING_NUMBER_OF_REPLICAS, 1)
        ClusterService clusterService = mock(ClusterService.class);
                + maxShards
                + "] total LOCAL_ONLY shards, but this cluster currently has ["
 */  
                + "]/["
import java.util.HashMap;  
            nodesInCluster,  
 * SPDX-License-Identifier: Apache-2.0
    public void testDotIndexOpeningFails() {
                + totalShards  
        final ShardLimitValidator shardLimitValidator = createTestShardLimitService(1, false);  
        int shardsToAdd = counts.getFailingIndexShards() * (1 + counts.getFailingIndexReplicas());
     */
     */  
            state.getNodes().getDataNodes().size(),  
        );
        assertTrue(errorMessage.isPresent());
        );
            () -> shardLimitValidator.validateShardLimit(state, indices)
        final ValidationException exception = expectThrows(
            new ClusterSettings(limitOnlySettings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)  
import org.opensearch.cluster.node.DiscoveryNode;  
     */  
                + currentShards
            .put(SETTING_CLUSTER_IGNORE_DOT_INDEXES.getKey(), false)  
        ShardLimitValidator shardLimitValidator = createTestShardLimitService(counts.getShardsPerNode(), true);
            .put(SETTING_VERSION_CREATED, Version.CURRENT)
            .build();
            .put(SETTING_NUMBER_OF_REPLICAS, 1)
 * under the License.  
