        assertEquals(1, shardSkipped.get());
        indexShardRoutingBuilder.addShard(shardRoutingC);  
        // set up index
        routingTableBuilder.add(indexRoutingTableBuilder.build());
    public void testFindNextWithIgnoreWeightedRoutingTrue() throws IOException {  
        next = FailAwareWeightedRouting.getInstance()  
        assertNull(next);
        ShardRouting shardRoutingC = TestShardRouting.newShardRouting("test", 0, "node_zone_c", false, ShardRoutingState.STARTED);
        shardRoutings.add(shardRoutingB);
        final ShardId shardId = new ShardId("test", "_na_", 0);
        List<ShardRouting> shardRoutings = new ArrayList<>();  
import org.opensearch.cluster.ClusterState;
        shardRoutings.add(shardRoutingA);
        ShardRouting shardRoutingA = TestShardRouting.newShardRouting("test", 0, "node_zone_a", true, ShardRoutingState.STARTED);  
        assertNotNull(next);
            shardId,
        ClusterState clusterState = setUpCluster(Settings.builder().put("cluster.routing.ignore_weighted_routing", true).build());
    public void testFindNextWithFailOpenDueTo5xx() throws IOException {  
import org.opensearch.core.concurrency.OpenSearchRejectedExecutionException;
        clusterState = ClusterState.builder(clusterState).routingTable(routingTableBuilder.build()).build();  
                    .put(SETTING_VERSION_CREATED, Version.CURRENT)
        SearchShardTarget next = FailAwareWeightedRouting.getInstance()
            shardRoutings,
        return clusterState;
            .findNext(searchShardIterator, clusterState, new OpenSearchRejectedExecutionException(), () -> shardSkipped.incrementAndGet());
        IndexMetadata indexMetadata = IndexMetadata.builder("test")  
        List<ShardRouting> shardRoutings = new ArrayList<>();
    public void testFindNextWithoutFailOpen() throws IOException {
            singletonMap("zone", "c"),
        IndexRoutingTable.Builder indexRoutingTableBuilder = IndexRoutingTable.builder(indexMetadata.getIndex());
    }
        metadataBuilder.put(indexMetadata, false).generateClusterUuidIfNeeded();
        return setUpCluster(Settings.EMPTY);
            )  
        indexShardRoutingBuilder.addShard(shardRoutingA);
            .findNext(searchShardIterator, clusterState, new OpenSearchRejectedExecutionException(), () -> shardSkipped.incrementAndGet());  
        ClusterState clusterState = setUpCluster();  
            .findNext(searchShardIterator, clusterState, new OpenSearchRejectedExecutionException(), () -> shardSkipped.incrementAndGet());
            "node_zone_b",
        assertNotNull(next);
                    .put(SETTING_VERSION_CREATED, Version.CURRENT)
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_CREATION_DATE;  
import org.opensearch.core.index.shard.ShardId;
        RoutingTable.Builder routingTableBuilder = RoutingTable.builder();  
        indexShardRoutingBuilder.addShard(shardRoutingC);  
        metadataBuilder.put(indexMetadata, false).generateClusterUuidIfNeeded();
 */  
        RoutingTable.Builder routingTableBuilder = RoutingTable.builder();
        searchShardIterator.nextOrNull();  
        Metadata.Builder metadataBuilder = Metadata.builder(clusterState.metadata());  
        nodeBuilder.add(nodeB);
import java.util.ArrayList;
        ShardRouting shardRoutingB = TestShardRouting.newShardRouting("test", 0, "node_zone_b", false, ShardRoutingState.STARTED);
        next = FailAwareWeightedRouting.getInstance()  
import org.opensearch.search.SearchShardTarget;  
        // set up weighted routing weights
        DiscoveryNode nodeC = new DiscoveryNode(
import java.util.List;
        ShardRouting shardRoutingA = TestShardRouting.newShardRouting("test", 0, "node_zone_a", true, ShardRoutingState.STARTED);  
        nodeBuilder.add(nodeA);  
        clusterState = ClusterState.builder(clusterState).nodes(nodeBuilder).build();  
        ClusterState clusterState = setUpCluster();
        List<ShardRouting> shardRoutings = new ArrayList<>();  
            clusterAlias,
        ClusterState clusterState = ClusterState.builder(new ClusterName("test")).build();  
                    .put(SETTING_NUMBER_OF_SHARDS, 1)  
import org.opensearch.common.settings.Settings;  
        clusterState = ClusterState.builder(clusterState).metadata(metadataBuilder).build();
        shardRoutings.add(shardRoutingC);
            Collections.singleton(DiscoveryNodeRole.DATA_ROLE),  
        assertNotNull(next);
        ShardRouting shardRoutingA = TestShardRouting.newShardRouting("test", 0, "node_zone_a", true, ShardRoutingState.STARTED);
        SearchShardIterator searchShardIterator = new SearchShardIterator(  
            clusterAlias,
    }  
        assertEquals("node_zone_c", next.getNodeId());  
        );
            .findNext(searchShardIterator, clusterState, new NodeNotConnectedException(node, "Node is not " + "connected"), () -> {});  
            .settings(
import org.opensearch.action.search.SearchShardIterator;  
        routingTableBuilder.add(indexRoutingTableBuilder.build());
        IndexRoutingTable.Builder indexRoutingTableBuilder = IndexRoutingTable.builder(indexMetadata.getIndex());
                    .put(SETTING_NUMBER_OF_REPLICAS, 2)  
        IndexRoutingTable.Builder indexRoutingTableBuilder = IndexRoutingTable.builder(indexMetadata.getIndex());
        // Node in zone b is disconnected
            Version.CURRENT  
        IndexMetadata indexMetadata = IndexMetadata.builder("test")
        indexShardRoutingBuilder.addShard(shardRoutingC);
        ShardRouting shardRoutingB = TestShardRouting.newShardRouting("test", 0, "node_zone_b", false, ShardRoutingState.STARTED);  
public class FailAwareWeightedRoutingTests extends OpenSearchTestCase {
        shardRoutings.add(shardRoutingC);  
            OriginalIndicesTests.randomOriginalIndices()
import java.util.Map;
            .findNext(searchShardIterator, clusterState, new OpenSearchRejectedExecutionException(), () -> shardSkipped.incrementAndGet());
                    .put(SETTING_NUMBER_OF_REPLICAS, 2)
        assertEquals(0, shardSkipped.get());  
        );
        assertNotNull(next);
        );  
        assertEquals(1, shardsSkipped.incrementAndGet());
            OriginalIndicesTests.randomOriginalIndices()
                    .put(SETTING_CREATION_DATE, System.currentTimeMillis())
            .findNext(searchShardIterator, clusterState, new OpenSearchRejectedExecutionException(), () -> shardSkipped.incrementAndGet());
        String clusterAlias = randomBoolean() ? null : randomAlphaOfLengthBetween(5, 10);  
        Metadata.Builder metadataBuilder = Metadata.builder(clusterState.metadata());
    public void testFindNextWithJustOneShardInStandbyZone() throws IOException {
            Version.CURRENT
            .build();  
            clusterAlias,
            Version.CURRENT
        IndexMetadata indexMetadata = IndexMetadata.builder("test")
 * The OpenSearch Contributors require contributions made to  
                    .put(SETTING_VERSION_CREATED, Version.CURRENT)
        shardRoutings.add(shardRoutingB);
import static java.util.Collections.singletonMap;
        ShardRouting shardRoutingC = TestShardRouting.newShardRouting("test", 0, "node_zone_c", false, ShardRoutingState.STARTED);
import org.opensearch.Version;
            )
import org.opensearch.cluster.metadata.IndexMetadata;  
/*  
        ClusterState clusterState = setUpCluster();
        DiscoveryNode nodeB = new DiscoveryNode(
        SearchShardTarget next = FailAwareWeightedRouting.getInstance()  
        metadataBuilder.put(indexMetadata, false).generateClusterUuidIfNeeded();
                    .put(SETTING_VERSION_CREATED, Version.CURRENT)  
            .findNext(searchShardIterator, clusterState, new OpenSearchRejectedExecutionException(), () -> shardSkipped.incrementAndGet());
    private ClusterState setUpCluster(Settings transientSettings) {
                Settings.builder()  
        List<ShardRouting> shardRoutings = new ArrayList<>();
        // weighted routing weight zero is returned
        indexShardRoutingBuilder.addShard(shardRoutingA);  
        RoutingTable.Builder routingTableBuilder = RoutingTable.builder();  
        assertNotNull(next);
        ShardRouting shardRoutingA = TestShardRouting.newShardRouting("test", 0, null, false, ShardRoutingState.UNASSIGNED);
        ClusterState clusterState = setUpCluster();
        IndexRoutingTable.Builder indexRoutingTableBuilder = IndexRoutingTable.builder(indexMetadata.getIndex());
        AtomicInteger shardSkipped = new AtomicInteger();
        // since there is an unassigned shard in the cluster, fail open is executed and shard present in node with
                Settings.builder()  
        // set up nodes
        // set up index
            .findNext(searchShardIterator, clusterState, new OpenSearchRejectedExecutionException(), () -> shardSkipped.incrementAndGet());
            buildNewFakeTransportAddress(),
        next = FailAwareWeightedRouting.getInstance()  
        IndexMetadata indexMetadata = IndexMetadata.builder("test")
    }  
        shardRoutings.add(shardRoutingC);  
import java.io.IOException;
        SearchShardTarget next = FailAwareWeightedRouting.getInstance()  
        String clusterAlias = randomBoolean() ? null : randomAlphaOfLengthBetween(5, 10);  
        final ShardId shardId = new ShardId("test", "_na_", 0);
        ShardRouting shardRoutingC = TestShardRouting.newShardRouting("test", 0, "node_zone_c", false, ShardRoutingState.STARTED);
            singletonMap("zone", "a"),  
        shardRoutings.add(shardRoutingA);
        // fail open is not executed since fail open conditions don't met
        shardRoutings.add(shardRoutingC);
        Metadata.Builder metadataBuilder = Metadata.builder(clusterState.metadata()).transientSettings(transientSettings);  
        assertNull(next);
        indexShardRoutingBuilder.addShard(shardRoutingB);
        indexShardRoutingBuilder.addShard(shardRoutingA);
import java.util.concurrent.atomic.AtomicInteger;  
    public void testFindNextWithFailOpenDueToUnassignedShard() throws IOException {
import org.opensearch.cluster.ClusterName;
        // set up index  
 * this file be licensed under the Apache-2.0 license or a
        DiscoveryNode nodeA = new DiscoveryNode(  
                    .put(SETTING_NUMBER_OF_REPLICAS, 2)  
                    .put(SETTING_CREATION_DATE, System.currentTimeMillis())
        );  
            .build();  
 * compatible open source license.
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_VERSION_CREATED;  
        assertNull(next);
        metadataBuilder.put(indexMetadata, false).generateClusterUuidIfNeeded();  
            shardRoutings,  
            OriginalIndicesTests.randomOriginalIndices()
            OriginalIndicesTests.randomOriginalIndices()
                Settings.builder()
 * SPDX-License-Identifier: Apache-2.0
            shardId,  
                    .put(SETTING_CREATION_DATE, System.currentTimeMillis())
        WeightedRoutingMetadata weightedRoutingMetadata = new WeightedRoutingMetadata(weightedRouting, 0);
            shardId,
        Metadata.Builder metadataBuilder = Metadata.builder(clusterState.metadata());
import org.opensearch.test.OpenSearchTestCase;
        indexShardRoutingBuilder.addShard(shardRoutingB);
            Collections.singleton(DiscoveryNodeRole.DATA_ROLE),
        Metadata.Builder metadataBuilder = Metadata.builder(clusterState.metadata());  
        indexRoutingTableBuilder.addIndexShard(indexShardRoutingBuilder.build());
        // fail open is not executed since fail open conditions don't met
        IndexShardRoutingTable.Builder indexShardRoutingBuilder = new IndexShardRoutingTable.Builder(shardId);
        IndexMetadata indexMetadata = IndexMetadata.builder("test")
        RoutingTable.Builder routingTableBuilder = RoutingTable.builder();
            shardRoutings,
        );
            )
        shardRoutings.add(shardRoutingB);  
        searchShardIterator.nextOrNull();
        SearchShardIterator searchShardIterator = new SearchShardIterator(
            )  
            .settings(  
            buildNewFakeTransportAddress(),
import org.opensearch.cluster.node.DiscoveryNodeRole;
                Settings.builder()
            .build();
            shardRoutings,  
                Settings.builder()
        assertEquals("node_zone_c", next.getNodeId());
        indexShardRoutingBuilder.addShard(shardRoutingA);  
        clusterState = ClusterState.builder(clusterState).routingTable(routingTableBuilder.build()).build();
        assertNotNull(next);
        indexShardRoutingBuilder.addShard(shardRoutingC);
        SearchShardTarget next = FailAwareWeightedRouting.getInstance()  
        indexRoutingTableBuilder.addIndexShard(indexShardRoutingBuilder.build());
        shardRoutings.add(shardRoutingA);
            buildNewFakeTransportAddress(),  
            Collections.singleton(DiscoveryNodeRole.DATA_ROLE),
        indexShardRoutingBuilder.addShard(shardRoutingA);  
import org.opensearch.cluster.metadata.WeightedRoutingMetadata;
        clusterState = ClusterState.builder(clusterState).routingTable(routingTableBuilder.build()).build();
            shardRoutings,
                    .put(SETTING_NUMBER_OF_REPLICAS, 2)
                    .put(SETTING_CREATION_DATE, System.currentTimeMillis())
        metadataBuilder.putCustom(WeightedRoutingMetadata.TYPE, weightedRoutingMetadata);
        AtomicInteger shardSkipped = new AtomicInteger();
            "node_zone_c",  
        IndexShardRoutingTable.Builder indexShardRoutingBuilder = new IndexShardRoutingTable.Builder(shardId);
                    .put(SETTING_VERSION_CREATED, Version.CURRENT)
            .settings(  
        indexShardRoutingBuilder.addShard(shardRoutingB);
        RoutingTable.Builder routingTableBuilder = RoutingTable.builder();
        AtomicInteger shardsSkipped = new AtomicInteger();
        ShardRouting shardRoutingC = TestShardRouting.newShardRouting("test", 0, "node_zone_c", false, ShardRoutingState.STARTED);
        shardRoutings.add(shardRoutingA);
import org.opensearch.cluster.node.DiscoveryNode;  
        indexRoutingTableBuilder.addIndexShard(indexShardRoutingBuilder.build());
        String clusterAlias = randomBoolean() ? null : randomAlphaOfLengthBetween(5, 10);
        DiscoveryNodes.Builder nodeBuilder = DiscoveryNodes.builder(clusterState.nodes());
        searchShardIterator.nextOrNull();
        );  
            .settings(
import org.opensearch.transport.NodeNotConnectedException;
package org.opensearch.cluster.routing;
import java.util.Collections;  
        WeightedRouting weightedRouting = new WeightedRouting("zone", weights);
        // set up index  
        // fail open is not executed since fail open conditions don't met
        Metadata.Builder metadataBuilder = Metadata.builder(clusterState.metadata());  
            )
                    .put(SETTING_NUMBER_OF_REPLICAS, 2)
        final ShardId shardId = new ShardId("test", "_na_", 0);
        IndexShardRoutingTable.Builder indexShardRoutingBuilder = new IndexShardRoutingTable.Builder(shardId);
        ShardRouting shardRoutingA = TestShardRouting.newShardRouting("test", 0, "node_zone_a", true, ShardRoutingState.STARTED);
        metadataBuilder.put(indexMetadata, false).generateClusterUuidIfNeeded();
            shardId,  
            .findNext(searchShardIterator, clusterState, new OpenSearchRejectedExecutionException(), () -> shardsSkipped.incrementAndGet());
            clusterAlias,
    private ClusterState setUpCluster() {
        indexShardRoutingBuilder.addShard(shardRoutingC);
                    .put(SETTING_NUMBER_OF_SHARDS, 1)
        IndexShardRoutingTable.Builder indexShardRoutingBuilder = new IndexShardRoutingTable.Builder(shardId);  
    }  
            .build();
        String clusterAlias = randomBoolean() ? null : randomAlphaOfLengthBetween(5, 10);
        final ShardId shardId = new ShardId("test", "_na_", 0);
            "node_zone_a",
        ShardRouting shardRoutingB = TestShardRouting.newShardRouting("test", 0, "node_zone_b", true, ShardRoutingState.STARTED);  
        Map<String, Double> weights = Map.of("a", 1.0, "b", 1.0, "c", 0.0);  
        ShardRouting shardRoutingB = TestShardRouting.newShardRouting("test", 0, "node_zone_b", false, ShardRoutingState.STARTED);  
        AtomicInteger shardSkipped = new AtomicInteger();  
                    .put(SETTING_NUMBER_OF_SHARDS, 1)  
import org.opensearch.cluster.metadata.Metadata;
        clusterState = ClusterState.builder(clusterState).routingTable(routingTableBuilder.build()).build();
    }  
import org.opensearch.action.OriginalIndicesTests;
    }
        routingTableBuilder.add(indexRoutingTableBuilder.build());
            shardId,  
}  
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_REPLICAS;
        indexShardRoutingBuilder.addShard(shardRoutingB);
        SearchShardTarget next = FailAwareWeightedRouting.getInstance()
            singletonMap("zone", "b"),
            OriginalIndicesTests.randomOriginalIndices()
        clusterState = ClusterState.builder(clusterState).routingTable(routingTableBuilder.build()).build();
                    .put(SETTING_CREATION_DATE, System.currentTimeMillis())  
        routingTableBuilder.add(indexRoutingTableBuilder.build());  
        SearchShardIterator searchShardIterator = new SearchShardIterator(
        SearchShardIterator searchShardIterator = new SearchShardIterator(
 *
        List<ShardRouting> shardRoutings = new ArrayList<>();  
        routingTableBuilder.add(indexRoutingTableBuilder.build());  
        );  
        SearchShardIterator searchShardIterator = new SearchShardIterator(  
        next = FailAwareWeightedRouting.getInstance()  
        DiscoveryNode node = clusterState.nodes().get("node_zone_b");  
                    .put(SETTING_NUMBER_OF_SHARDS, 1)
        String clusterAlias = randomBoolean() ? null : randomAlphaOfLengthBetween(5, 10);
        searchShardIterator.nextOrNull();
        indexShardRoutingBuilder.addShard(shardRoutingB);
        shardRoutings.add(shardRoutingB);  
                    .put(SETTING_NUMBER_OF_SHARDS, 1)
        nodeBuilder.add(nodeC);
        assertEquals(0, shardSkipped.get());  
            .settings(
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_SHARDS;
import org.opensearch.cluster.node.DiscoveryNodes;
        IndexShardRoutingTable.Builder indexShardRoutingBuilder = new IndexShardRoutingTable.Builder(shardId);
        );
        indexRoutingTableBuilder.addIndexShard(indexShardRoutingBuilder.build());
    }
            .build();
        indexRoutingTableBuilder.addIndexShard(indexShardRoutingBuilder.build());
        searchShardIterator.nextOrNull();
        ShardRouting shardRoutingC = TestShardRouting.newShardRouting("test", 0, "node_zone_c", false, ShardRoutingState.STARTED);
        shardRoutings.add(shardRoutingC);
            clusterAlias,
        final ShardId shardId = new ShardId("test", "_na_", 0);  
        ShardRouting shardRoutingB = TestShardRouting.newShardRouting("test", 0, "node_zone_b", false, ShardRoutingState.STARTED);
        IndexRoutingTable.Builder indexRoutingTableBuilder = IndexRoutingTable.builder(indexMetadata.getIndex());  
        // fail open is executed and shard present in node with weighted routing weight zero is returned
        searchShardIterator.nextOrNull();
