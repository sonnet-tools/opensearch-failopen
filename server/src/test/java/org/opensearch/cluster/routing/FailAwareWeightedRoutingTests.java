        routingTableBuilder.add(indexRoutingTableBuilder.build());
        routingTableBuilder.add(indexRoutingTableBuilder.build());
        ShardRouting shardRoutingB = TestShardRouting.newShardRouting("test", 0, "node_zone_b", false, ShardRoutingState.STARTED);
            OriginalIndicesTests.randomOriginalIndices()
        List<ShardRouting> shardRoutings = new ArrayList<>();
import org.opensearch.test.OpenSearchTestCase;
        String clusterAlias = randomBoolean() ? null : randomAlphaOfLengthBetween(5, 10);
            shardId,
        shardRoutings.add(shardRoutingA);
import static java.util.Collections.singletonMap;
        DiscoveryNodes.Builder nodeBuilder = DiscoveryNodes.builder(clusterState.nodes());
    }
        // set up index
        // set up nodes
        );
        indexRoutingTableBuilder.addIndexShard(indexShardRoutingBuilder.build());
        searchShardIterator.nextOrNull();
                    .put(SETTING_VERSION_CREATED, Version.CURRENT)
        clusterState = ClusterState.builder(clusterState).routingTable(routingTableBuilder.build()).build();
        assertNotNull(next);
            clusterAlias,
        IndexRoutingTable.Builder indexRoutingTableBuilder = IndexRoutingTable.builder(indexMetadata.getIndex());
        IndexRoutingTable.Builder indexRoutingTableBuilder = IndexRoutingTable.builder(indexMetadata.getIndex());
        indexShardRoutingBuilder.addShard(shardRoutingA);
    }
import org.opensearch.cluster.node.DiscoveryNode;
        next = FailAwareWeightedRouting.getInstance()
            .build();
        IndexShardRoutingTable.Builder indexShardRoutingBuilder = new IndexShardRoutingTable.Builder(shardId);
        indexShardRoutingBuilder.addShard(shardRoutingA);
        SearchShardIterator searchShardIterator = new SearchShardIterator(
    }
        assertNull(next);
        Metadata.Builder metadataBuilder = Metadata.builder(clusterState.metadata());
    public void testFindNextWithFailOpenDueTo5xx() throws IOException {
                    .put(SETTING_NUMBER_OF_SHARDS, 1)
        ShardRouting shardRoutingC = TestShardRouting.newShardRouting("test", 0, "node_zone_c", false, ShardRoutingState.STARTED);
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_VERSION_CREATED;
            Collections.singleton(DiscoveryNodeRole.DATA_ROLE),
            .build();
    private ClusterState setUpCluster() {
        IndexShardRoutingTable.Builder indexShardRoutingBuilder = new IndexShardRoutingTable.Builder(shardId);
        return clusterState;
        next = FailAwareWeightedRouting.getInstance()
            .findNext(searchShardIterator, clusterState, new NodeNotConnectedException(node, "Node is not " + "connected"), () -> {});
            Version.CURRENT
import org.opensearch.Version;
        SearchShardIterator searchShardIterator = new SearchShardIterator(
import java.util.Collections;
            OriginalIndicesTests.randomOriginalIndices()
        assertEquals(0, shardSkipped.get());
        metadataBuilder.putCustom(WeightedRoutingMetadata.TYPE, weightedRoutingMetadata);
            .build();
            .findNext(searchShardIterator, clusterState, new OpenSearchRejectedExecutionException(), () -> shardSkipped.incrementAndGet());
import org.opensearch.common.settings.Settings;
        // fail open is not executed since fail open conditions don't met
        ShardRouting shardRoutingB = TestShardRouting.newShardRouting("test", 0, "node_zone_b", true, ShardRoutingState.STARTED);
            )
            shardRoutings,
        shardRoutings.add(shardRoutingB);
        // fail open is not executed since fail open conditions don't met
        IndexMetadata indexMetadata = IndexMetadata.builder("test")
            clusterAlias,
        indexShardRoutingBuilder.addShard(shardRoutingC);
        indexRoutingTableBuilder.addIndexShard(indexShardRoutingBuilder.build());
                Settings.builder()
            )
import org.opensearch.core.concurrency.OpenSearchRejectedExecutionException;
        shardRoutings.add(shardRoutingB);
        ShardRouting shardRoutingB = TestShardRouting.newShardRouting("test", 0, "node_zone_b", false, ShardRoutingState.STARTED);
        SearchShardTarget next = FailAwareWeightedRouting.getInstance()
            .settings(
            .findNext(searchShardIterator, clusterState, new OpenSearchRejectedExecutionException(), () -> shardSkipped.incrementAndGet());
            )
        shardRoutings.add(shardRoutingC);
            )
        ClusterState clusterState = setUpCluster(Settings.builder().put("cluster.routing.ignore_weighted_routing", true).build());
            shardRoutings,
        assertNotNull(next);
        ShardRouting shardRoutingA = TestShardRouting.newShardRouting("test", 0, "node_zone_a", true, ShardRoutingState.STARTED);
    public void testFindNextWithoutFailOpen() throws IOException {
        metadataBuilder.put(indexMetadata, false).generateClusterUuidIfNeeded();
        indexRoutingTableBuilder.addIndexShard(indexShardRoutingBuilder.build());
            .build();
        final ShardId shardId = new ShardId("test", "_na_", 0);
            Collections.singleton(DiscoveryNodeRole.DATA_ROLE),
        );
        routingTableBuilder.add(indexRoutingTableBuilder.build());
            .settings(
        RoutingTable.Builder routingTableBuilder = RoutingTable.builder();
            )
        // set up index
        // set up index
                    .put(SETTING_NUMBER_OF_SHARDS, 1)
import org.opensearch.action.search.SearchShardIterator;
                    .put(SETTING_NUMBER_OF_REPLICAS, 2)
        searchShardIterator.nextOrNull();
        shardRoutings.add(shardRoutingC);
                    .put(SETTING_VERSION_CREATED, Version.CURRENT)
            .findNext(searchShardIterator, clusterState, new OpenSearchRejectedExecutionException(), () -> shardSkipped.incrementAndGet());
 */
        ClusterState clusterState = setUpCluster();
            .findNext(searchShardIterator, clusterState, new OpenSearchRejectedExecutionException(), () -> shardsSkipped.incrementAndGet());
        clusterState = ClusterState.builder(clusterState).routingTable(routingTableBuilder.build()).build();
        IndexShardRoutingTable.Builder indexShardRoutingBuilder = new IndexShardRoutingTable.Builder(shardId);
        ShardRouting shardRoutingC = TestShardRouting.newShardRouting("test", 0, "node_zone_c", false, ShardRoutingState.STARTED);
        List<ShardRouting> shardRoutings = new ArrayList<>();
        indexShardRoutingBuilder.addShard(shardRoutingC);
            Version.CURRENT
    }
        Map<String, Double> weights = Map.of("a", 1.0, "b", 1.0, "c", 0.0);
        RoutingTable.Builder routingTableBuilder = RoutingTable.builder();
import org.opensearch.core.index.shard.ShardId;
        SearchShardTarget next = FailAwareWeightedRouting.getInstance()
 * SPDX-License-Identifier: Apache-2.0
        DiscoveryNode nodeC = new DiscoveryNode(
        clusterState = ClusterState.builder(clusterState).routingTable(routingTableBuilder.build()).build();
            shardId,
        List<ShardRouting> shardRoutings = new ArrayList<>();
import java.util.concurrent.atomic.AtomicInteger;
            Version.CURRENT
    }
import java.io.IOException;
        shardRoutings.add(shardRoutingB);
            .settings(
        ShardRouting shardRoutingA = TestShardRouting.newShardRouting("test", 0, "node_zone_a", true, ShardRoutingState.STARTED);
import org.opensearch.cluster.node.DiscoveryNodes;
        clusterState = ClusterState.builder(clusterState).nodes(nodeBuilder).build();
            .build();
        ClusterState clusterState = ClusterState.builder(new ClusterName("test")).build();
                    .put(SETTING_CREATION_DATE, System.currentTimeMillis())
        indexShardRoutingBuilder.addShard(shardRoutingA);
import org.opensearch.cluster.ClusterName;
        searchShardIterator.nextOrNull();
        RoutingTable.Builder routingTableBuilder = RoutingTable.builder();
        IndexMetadata indexMetadata = IndexMetadata.builder("test")
import org.opensearch.cluster.ClusterState;
                Settings.builder()
        SearchShardTarget next = FailAwareWeightedRouting.getInstance()
        indexShardRoutingBuilder.addShard(shardRoutingC);
                    .put(SETTING_NUMBER_OF_SHARDS, 1)
        metadataBuilder.put(indexMetadata, false).generateClusterUuidIfNeeded();
        assertEquals(1, shardSkipped.get());
        Metadata.Builder metadataBuilder = Metadata.builder(clusterState.metadata());
        final ShardId shardId = new ShardId("test", "_na_", 0);
import org.opensearch.cluster.metadata.IndexMetadata;
        IndexRoutingTable.Builder indexRoutingTableBuilder = IndexRoutingTable.builder(indexMetadata.getIndex());
            .findNext(searchShardIterator, clusterState, new OpenSearchRejectedExecutionException(), () -> shardSkipped.incrementAndGet());
        ClusterState clusterState = setUpCluster();
        // set up index
        RoutingTable.Builder routingTableBuilder = RoutingTable.builder();
        assertEquals(1, shardsSkipped.incrementAndGet());
        );
        ShardRouting shardRoutingA = TestShardRouting.newShardRouting("test", 0, "node_zone_a", true, ShardRoutingState.STARTED);
                Settings.builder()
        metadataBuilder.put(indexMetadata, false).generateClusterUuidIfNeeded();
import org.opensearch.search.SearchShardTarget;
    }
        AtomicInteger shardSkipped = new AtomicInteger();
        next = FailAwareWeightedRouting.getInstance()
        clusterState = ClusterState.builder(clusterState).routingTable(routingTableBuilder.build()).build();
        indexShardRoutingBuilder.addShard(shardRoutingC);
        metadataBuilder.put(indexMetadata, false).generateClusterUuidIfNeeded();
            "node_zone_c",
            shardRoutings,
        assertNotNull(next);
        ShardRouting shardRoutingC = TestShardRouting.newShardRouting("test", 0, "node_zone_c", false, ShardRoutingState.STARTED);
    }
            buildNewFakeTransportAddress(),
        assertEquals("node_zone_c", next.getNodeId());
        Metadata.Builder metadataBuilder = Metadata.builder(clusterState.metadata());
        metadataBuilder.put(indexMetadata, false).generateClusterUuidIfNeeded();
                    .put(SETTING_NUMBER_OF_REPLICAS, 2)
            buildNewFakeTransportAddress(),
        ShardRouting shardRoutingB = TestShardRouting.newShardRouting("test", 0, "node_zone_b", false, ShardRoutingState.STARTED);
        final ShardId shardId = new ShardId("test", "_na_", 0);
        assertEquals(0, shardSkipped.get());
            "node_zone_b",
        indexShardRoutingBuilder.addShard(shardRoutingA);
                    .put(SETTING_VERSION_CREATED, Version.CURRENT)
                    .put(SETTING_CREATION_DATE, System.currentTimeMillis())
import org.opensearch.cluster.node.DiscoveryNodeRole;
import org.opensearch.cluster.metadata.WeightedRoutingMetadata;
        indexShardRoutingBuilder.addShard(shardRoutingB);
        IndexMetadata indexMetadata = IndexMetadata.builder("test")
        SearchShardTarget next = FailAwareWeightedRouting.getInstance()
    private ClusterState setUpCluster(Settings transientSettings) {
        Metadata.Builder metadataBuilder = Metadata.builder(clusterState.metadata()).transientSettings(transientSettings);
        assertNotNull(next);
        String clusterAlias = randomBoolean() ? null : randomAlphaOfLengthBetween(5, 10);
            OriginalIndicesTests.randomOriginalIndices()
        SearchShardTarget next = FailAwareWeightedRouting.getInstance()
        next = FailAwareWeightedRouting.getInstance()
            clusterAlias,
        searchShardIterator.nextOrNull();
        assertNotNull(next);
        indexShardRoutingBuilder.addShard(shardRoutingB);
import java.util.List;
        shardRoutings.add(shardRoutingC);
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_REPLICAS;
        indexShardRoutingBuilder.addShard(shardRoutingC);
        );
            singletonMap("zone", "b"),
/*
        indexShardRoutingBuilder.addShard(shardRoutingA);
        AtomicInteger shardSkipped = new AtomicInteger();
        final ShardId shardId = new ShardId("test", "_na_", 0);
        IndexMetadata indexMetadata = IndexMetadata.builder("test")
        shardRoutings.add(shardRoutingA);
}
package org.opensearch.cluster.routing;
            "node_zone_a",
import java.util.ArrayList;
        ClusterState clusterState = setUpCluster();
            OriginalIndicesTests.randomOriginalIndices()
            singletonMap("zone", "a"),
                    .put(SETTING_VERSION_CREATED, Version.CURRENT)
        assertNull(next);
        IndexShardRoutingTable.Builder indexShardRoutingBuilder = new IndexShardRoutingTable.Builder(shardId);
    public void testFindNextWithIgnoreWeightedRoutingTrue() throws IOException {
        DiscoveryNode node = clusterState.nodes().get("node_zone_b");
            buildNewFakeTransportAddress(),
        IndexShardRoutingTable.Builder indexShardRoutingBuilder = new IndexShardRoutingTable.Builder(shardId);
        );
            clusterAlias,
            .findNext(searchShardIterator, clusterState, new OpenSearchRejectedExecutionException(), () -> shardSkipped.incrementAndGet());
        ShardRouting shardRoutingA = TestShardRouting.newShardRouting("test", 0, "node_zone_a", true, ShardRoutingState.STARTED);
                    .put(SETTING_VERSION_CREATED, Version.CURRENT)
        SearchShardIterator searchShardIterator = new SearchShardIterator(
                    .put(SETTING_CREATION_DATE, System.currentTimeMillis())
        SearchShardIterator searchShardIterator = new SearchShardIterator(
        SearchShardIterator searchShardIterator = new SearchShardIterator(
public class FailAwareWeightedRoutingTests extends OpenSearchTestCase {
            OriginalIndicesTests.randomOriginalIndices()
                Settings.builder()
import org.opensearch.action.OriginalIndicesTests;
        List<ShardRouting> shardRoutings = new ArrayList<>();
    public void testFindNextWithJustOneShardInStandbyZone() throws IOException {
        shardRoutings.add(shardRoutingC);
            .findNext(searchShardIterator, clusterState, new OpenSearchRejectedExecutionException(), () -> shardSkipped.incrementAndGet());
        DiscoveryNode nodeB = new DiscoveryNode(
        assertNull(next);
        RoutingTable.Builder routingTableBuilder = RoutingTable.builder();
        ShardRouting shardRoutingB = TestShardRouting.newShardRouting("test", 0, "node_zone_b", false, ShardRoutingState.STARTED);
        WeightedRouting weightedRouting = new WeightedRouting("zone", weights);
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_CREATION_DATE;
        // fail open is not executed since fail open conditions don't met
        String clusterAlias = randomBoolean() ? null : randomAlphaOfLengthBetween(5, 10);
        indexShardRoutingBuilder.addShard(shardRoutingB);
        nodeBuilder.add(nodeA);
        WeightedRoutingMetadata weightedRoutingMetadata = new WeightedRoutingMetadata(weightedRouting, 0);
            singletonMap("zone", "c"),
        ClusterState clusterState = setUpCluster();
        routingTableBuilder.add(indexRoutingTableBuilder.build());
            shardRoutings,
        IndexRoutingTable.Builder indexRoutingTableBuilder = IndexRoutingTable.builder(indexMetadata.getIndex());
 *
 * this file be licensed under the Apache-2.0 license or a
        Metadata.Builder metadataBuilder = Metadata.builder(clusterState.metadata());
        ShardRouting shardRoutingA = TestShardRouting.newShardRouting("test", 0, null, false, ShardRoutingState.UNASSIGNED);
            clusterAlias,
        clusterState = ClusterState.builder(clusterState).metadata(metadataBuilder).build();
        ShardRouting shardRoutingC = TestShardRouting.newShardRouting("test", 0, "node_zone_c", false, ShardRoutingState.STARTED);
        IndexMetadata indexMetadata = IndexMetadata.builder("test")
                    .put(SETTING_CREATION_DATE, System.currentTimeMillis())
            .findNext(searchShardIterator, clusterState, new OpenSearchRejectedExecutionException(), () -> shardSkipped.incrementAndGet());
        // since there is an unassigned shard in the cluster, fail open is executed and shard present in node with
        assertEquals("node_zone_c", next.getNodeId());
        );
        indexRoutingTableBuilder.addIndexShard(indexShardRoutingBuilder.build());
        shardRoutings.add(shardRoutingB);
            shardId,
        // fail open is executed and shard present in node with weighted routing weight zero is returned
        ShardRouting shardRoutingC = TestShardRouting.newShardRouting("test", 0, "node_zone_c", false, ShardRoutingState.STARTED);
        AtomicInteger shardsSkipped = new AtomicInteger();
            shardId,
        String clusterAlias = randomBoolean() ? null : randomAlphaOfLengthBetween(5, 10);
        final ShardId shardId = new ShardId("test", "_na_", 0);
import org.opensearch.transport.NodeNotConnectedException;
            .settings(
        nodeBuilder.add(nodeC);
        nodeBuilder.add(nodeB);
        assertNotNull(next);
            Collections.singleton(DiscoveryNodeRole.DATA_ROLE),
                    .put(SETTING_NUMBER_OF_REPLICAS, 2)
        searchShardIterator.nextOrNull();
            .settings(
            shardRoutings,
                    .put(SETTING_CREATION_DATE, System.currentTimeMillis())
        indexShardRoutingBuilder.addShard(shardRoutingB);
                    .put(SETTING_NUMBER_OF_SHARDS, 1)
        Metadata.Builder metadataBuilder = Metadata.builder(clusterState.metadata());
        IndexRoutingTable.Builder indexRoutingTableBuilder = IndexRoutingTable.builder(indexMetadata.getIndex());
                    .put(SETTING_NUMBER_OF_REPLICAS, 2)
import java.util.Map;
        // Node in zone b is disconnected
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_SHARDS;
        // weighted routing weight zero is returned
        );
        shardRoutings.add(shardRoutingA);
        searchShardIterator.nextOrNull();
    public void testFindNextWithFailOpenDueToUnassignedShard() throws IOException {
                    .put(SETTING_NUMBER_OF_REPLICAS, 2)
        routingTableBuilder.add(indexRoutingTableBuilder.build());
        clusterState = ClusterState.builder(clusterState).routingTable(routingTableBuilder.build()).build();
        return setUpCluster(Settings.EMPTY);
        );
        indexRoutingTableBuilder.addIndexShard(indexShardRoutingBuilder.build());
        shardRoutings.add(shardRoutingA);
                Settings.builder()
 * The OpenSearch Contributors require contributions made to
        // set up weighted routing weights
            shardId,
        List<ShardRouting> shardRoutings = new ArrayList<>();
        DiscoveryNode nodeA = new DiscoveryNode(
                    .put(SETTING_NUMBER_OF_SHARDS, 1)
        AtomicInteger shardSkipped = new AtomicInteger();
        indexShardRoutingBuilder.addShard(shardRoutingB);
 * compatible open source license.
import org.opensearch.cluster.metadata.Metadata;
        shardRoutings.add(shardRoutingC);
        String clusterAlias = randomBoolean() ? null : randomAlphaOfLengthBetween(5, 10);
