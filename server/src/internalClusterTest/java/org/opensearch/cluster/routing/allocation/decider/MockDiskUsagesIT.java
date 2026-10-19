    }
                .setTransientSettings(
import static org.hamcrest.Matchers.not;
 * SPDX-License-Identifier: Apache-2.0
            .count();  
                discoveryNode.getId().equals(nodeIds.get(2)) ? between(0, 9) : between(10, 100)
    public void testDoesNotExceedLowWatermarkWhenRebalancing() throws Exception {  
                    .put(IndexMetadata.INDEX_ROUTING_EXCLUDE_GROUP_SETTING.getConcreteSettingForNamespace("_id").getKey(), nodeIds.get(2))
            client().admin().cluster().prepareState().get().getState().getRoutingNodes().spliterator(),  
        assertAcked(
                    Settings.builder()
import java.util.Arrays;
        {  
            assertThat("node2 has 2 shards", shardCountByNodeId.get(nodeIds.get(2)), equalTo(2));
        assertAcked(
        // ensure that indices do not use custom data paths
        ).map(RoutingNode::nodeId).collect(Collectors.toList());
                        .put(CLUSTER_ROUTING_ALLOCATION_HIGH_DISK_WATERMARK_SETTING.getKey(), "90%")
import java.util.List;
    public Settings indexSettings() {
            } catch (ClusterBlockException e) {
                    .put("number_of_shards", 6)
 * compatible open source license.
                )
        });
 * The OpenSearch Contributors require contributions made to  
                    shardStats -> shardStats.getShardRouting().currentNodeId().equals(nodeWithTwoPaths)
        );
                fsInfoPath.getPath().startsWith(pathOverWatermark.toString()) ? between(0, 9) : between(10, 100)  
        assertSearchHits(client().prepareSearch("test").get(), "1", "3");
            (discoveryNode, fsInfoPath) -> setDiskUsage(
            try {
        for (int i = 0; i < 3; i++) {
 */  
import org.opensearch.action.admin.indices.stats.ShardStats;
package org.opensearch.cluster.routing.allocation.decider;
            client().prepareIndex().setIndex("test").setId("2").setSource("foo", "bar"),
                fsInfoPath,  
 *
                        .put(CLUSTER_ROUTING_ALLOCATION_HIGH_DISK_WATERMARK_SETTING.getKey(), "90%")
        logger.info("--> waiting for shards to relocate off path [{}]", pathOverWatermark);
 * this work for additional information regarding copyright
            twoPathSettings.putList(Environment.PATH_DATA_SETTING.getKey(), pathOverWatermark.toString(), createTempDir().toString());
        clusterInfoService.setDiskUsageFunctionAndRefresh((discoveryNode, fsInfoPath) -> setDiskUsage(fsInfoPath, 100, between(10, 100)));
        clusterInfoService.setUpdateFrequency(TimeValue.timeValueMillis(200));
        ensureGreen("test");
                    Settings.builder().put(CLUSTER_ROUTING_REBALANCE_ENABLE_SETTING.getKey(), EnableAllocationDecider.Rebalance.NONE)  
        );
        // prevent any effects from in-flight recoveries, since we are only simulating a 100-byte disk  
                        .put(CLUSTER_ROUTING_ALLOCATION_DISK_FLOOD_STAGE_WATERMARK_SETTING.getKey(), "100%")
        clusterInfoService.setDiskUsageFunctionAndRefresh(
        final String nodeWithTwoPaths = client().admin().cluster().prepareNodesInfo().get().getNodes().get(0).getNode().getId();
        logger.info("--> waiting for shards to relocate onto node [{}]", nodeIds.get(2));
import org.opensearch.action.support.WriteRequest;
                .prepareUpdateSettings()
        final List<String> nodeIds = StreamSupport.stream(
                )  
 * specific language governing permissions and limitations
        );  
            assertThat("node1 has at least 3 shards", shardCountByNodeId.get(nodeIds.get(1)), greaterThanOrEqualTo(3));
        });
    public void testMovesShardsOffSpecificDataPathAboveWatermark() throws Exception {
        clusterInfoService.setShardSizeFunctionAndRefresh(shardRouting -> 1L);
        }
            assertThat("node1 has 2 shards", shardCountByNodeId.get(nodeIds.get(1)), equalTo(2));
                        .put(CLUSTER_ROUTING_ALLOCATION_LOW_DISK_WATERMARK_SETTING.getKey(), "85%")  
            final Map<String, Integer> shardCountByNodeId = getShardCountByNodeId();
                    && shardStats.getDataPath().startsWith(pathOverWatermark.toString()) == false
    public void testRerouteOccursOnDiskPassingHighWatermark() throws Exception {
 * the Apache License, Version 2.0 (the "License"); you may
            )
            false
        // Create an index with 10 shards so we can check allocation for it
        final List<String> nodeIds = StreamSupport.stream(  
        internalCluster().getCurrentClusterManagerNodeInstance(ClusterService.class).addListener(event -> {  
                    .setId("3")  
            client().admin().cluster().prepareState().get().getState().getRoutingNodes().spliterator(),
 * Unless required by applicable law or agreed to in writing,
        assertSearchHits(client().prepareSearch("test").get(), "1");
                        .put(CLUSTER_ROUTING_ALLOCATION_DISK_FLOOD_STAGE_WATERMARK_SETTING.getKey(), "100%")
            client().admin().cluster().prepareState().get().getState().getRoutingNodes().spliterator(),
        assertBusy(() -> {  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSearchHits;  
        prepareCreate("test").setSettings(Settings.builder().put("number_of_shards", 6).put("number_of_replicas", 0)).get();  
        ).map(RoutingNode::nodeId).collect(Collectors.toList());  
                .cluster()  
    }
                .cluster()  
                    Settings.builder()  
        assertFalse(client().admin().cluster().prepareHealth("test").setWaitForEvents(Priority.LANGUID).get().isTimedOut());  
                .count(),
        });
        final AtomicReference<ClusterState> clusterManagerAppliedClusterState = new AtomicReference<>();
        // start one node with two data paths
        assertBusy(() -> {
                fsInfoPath,
        for (int i = 0; i < 3; i++) {
import java.util.Collection;
            false  
        final List<String> nodeIds = StreamSupport.stream(
        }  
            logger.info(
import org.opensearch.env.Environment;
        assertThat("node2 has 1 shard", getShardCountByNodeId().get(nodeIds.get(2)), equalTo(1));
                discoveryNode.getId().equals(nodeIds.get(2))
        );  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertBlocked;
                        .put(CLUSTER_ROUTING_ALLOCATION_REROUTE_INTERVAL_SETTING.getKey(), "150ms")
                .setTransientSettings(
                        .put(CLUSTER_ROUTING_ALLOCATION_HIGH_DISK_WATERMARK_SETTING.getKey(), watermarkBytes ? "10b" : "90%")
public class MockDiskUsagesIT extends OpenSearchIntegTestCase {
                node.nodeId(),  
                        .put(CLUSTER_ROUTING_ALLOCATION_LOW_DISK_WATERMARK_SETTING.getKey(), "90%")  
            )  
                    Settings.builder()  
        // Move all nodes above the low watermark so no shard movement can occur, and at least one node above the flood stage watermark so
            internalCluster().startNode(Settings.builder().put(Environment.PATH_DATA_SETTING.getKey(), createTempDir()));
        );
                        .put(CLUSTER_ROUTING_ALLOCATION_LOW_DISK_WATERMARK_SETTING.getKey(), watermarkBytes ? "10b" : "90%")
        }
                        && shardStats.getDataPath().startsWith(pathOverWatermark.toString()) == false
        });
            )
        // move all nodes below watermark again  
                    ? 101L - clusterManagerAppliedClusterState.get().getRoutingNodes().node(nodeIds.get(2)).numberOfOwningShards()
        internalCluster().startNode(Settings.builder().put(Environment.PATH_DATA_SETTING.getKey(), createTempDir()));
                        .putNull(IndexMetadata.INDEX_ROUTING_EXCLUDE_GROUP_SETTING.getConcreteSettingForNamespace("_id").getKey())
    }  
            assertThat("node0 has at least 3 shards", shardCountByNodeId.get(nodeIds.get(0)), greaterThanOrEqualTo(3));
        clusterInfoService.setDiskUsageFunctionAndRefresh((discoveryNode, fsInfoPath) -> setDiskUsage(fsInfoPath, 100, between(10, 100)));
        );  
                        .put(CLUSTER_ROUTING_ALLOCATION_DISK_FLOOD_STAGE_WATERMARK_SETTING.getKey(), watermarkBytes ? "5b" : "95%")  
        );
        ensureGreen("test");  
            internalCluster().startNode(Settings.builder().put(Environment.PATH_DATA_SETTING.getKey(), createTempDir()));
            assertThat("node0 has 3 shards", shardCountByNodeId.get(nodeIds.get(0)), equalTo(3));
                        .put(CLUSTER_ROUTING_ALLOCATION_REROUTE_INTERVAL_SETTING.getKey(), "0ms")
        clusterInfoService.setShardSizeFunctionAndRefresh(shardRouting -> 0L);
import org.opensearch.cluster.metadata.IndexMetadata;
                )
import static org.opensearch.cluster.routing.allocation.DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_LOW_DISK_WATERMARK_SETTING;
import org.opensearch.common.Priority;
        );  
                shardStats -> shardStats.getShardRouting().currentNodeId().equals(nodeWithTwoPaths)  
            // ensure that each node has a single data path
import static org.hamcrest.Matchers.equalTo;
        logger.info("--> waiting for shards to relocate off node [{}]", nodeIds.get(2));
        assertThat("node2 has 1 shard", getShardCountByNodeId().get(nodeIds.get(2)), equalTo(1));  
            assertThat("node1 has 3 shards", shardCountByNodeId.get(nodeIds.get(1)), equalTo(3));  
        clusterInfoService.setDiskUsageFunctionAndRefresh((discoveryNode, fsInfoPath) -> setDiskUsage(fsInfoPath, 100, between(10, 100)));
            assertThat(shardStats.getDataPath(), not(startsWith(pathOverWatermark.toString())));  
        final MockInternalClusterInfoService clusterInfoService = getMockInternalClusterInfoService();
        });
            )
    private MockInternalClusterInfoService getMockInternalClusterInfoService() {
                )
                    ? 150L - clusterManagerAppliedClusterState.get().getRoutingNodes().node(nodeIds.get(2)).numberOfOwningShards()  
    }
    private Map<String, Integer> getShardCountByNodeId() {  
        ensureGreen("test");
        for (int i = 0; i < 3; i++) {  
 * GitHub history for details.
        ensureGreen("test");
        logger.info("--> waiting for shards to relocate off node [{}]", nodeIds.get(2));  
            assertThat("node0 has 2 shards", shardCountByNodeId.get(nodeIds.get(0)), equalTo(2));
        );
                    .get();  
            assertThat("node1 has at least 3 shards", shardCountByNodeId.get(nodeIds.get(1)), greaterThanOrEqualTo(3));
            Arrays.stream(client().admin().indices().prepareStats("test").get().getShards())
        internalCluster().getCurrentClusterManagerNodeInstance(ClusterService.class).addListener(event -> {
            assertThat("node2 has at least 3 shards", shardCountByNodeId.get(nodeIds.get(2)), greaterThanOrEqualTo(3));  
            client().admin()
import static org.opensearch.cluster.routing.allocation.decider.EnableAllocationDecider.CLUSTER_ROUTING_REBALANCE_ENABLE_SETTING;  
        final Map<String, Integer> shardCountByNodeId = new HashMap<>();
            // ensure that each node has a single data path
 * software distributed under the License is distributed on an
                )  
                )  
    }
        ).map(RoutingNode::nodeId).collect(Collectors.toList());
            clusterInfoService.refresh(); // so that a subsequent reroute sees disk usage according to the current state  
 * not use this file except in compliance with the License.
        }
            final Map<String, Integer> shardCountByNodeId = getShardCountByNodeId();
            )  
        ensureGreen("test");
        // start with all paths below the watermark  
        assertBusy(() -> assertThat("node2 has 1 shard", getShardCountByNodeId().get(nodeIds.get(2)), equalTo(1)));
 * under the License.  
            false  
        }
        // Attempt to create a new document until DiskUsageMonitor unblocks the index
        final boolean watermarkBytes = randomBoolean(); // we have to consistently use bytes or percentage for the disk watermark settings  
        // shards are 1 byte large  
                assertThat(shardStats.getDataPath(), not(startsWith(pathOverWatermark.toString())));
        for (int i = 0; i < 3; i++) {
        // other two nodes have one data path each  
/*  
            )  
        assertAcked(
import org.opensearch.test.OpenSearchIntegTestCase;
import static org.hamcrest.Matchers.lessThanOrEqualTo;  
                        .put(CLUSTER_ROUTING_ALLOCATION_DISK_FLOOD_STAGE_WATERMARK_SETTING.getKey(), "100%")  
                .prepareUpdateSettings()  
import org.opensearch.cluster.service.ClusterService;  
    @Override  
        final Path pathOverWatermark = createTempDir();
            }  
        // start with all nodes below the low watermark  
        // Cannot add further documents
        assertAcked(prepareCreate("test").setSettings(Settings.builder().put("number_of_shards", 10).put("number_of_replicas", 0)));
                .cluster()
 * KIND, either express or implied.  See the License for the
 */  
 * license agreements. See the NOTICE file distributed with
    }  
        clusterInfoService.setDiskUsageFunctionAndRefresh(
        return (MockInternalClusterInfoService) internalCluster().getCurrentClusterManagerNodeInstance(ClusterInfoService.class);  
                        .put(CLUSTER_ROUTING_ALLOCATION_HIGH_DISK_WATERMARK_SETTING.getKey(), "100%")
        logger.info("--> index is confirmed read-only, releasing disk space");  
/*  
            assertThat("node2 has 0 shards", shardCountByNodeId.get(nodeIds.get(2)), equalTo(0));  
                    .setSource("foo", "bar")
        });
        ensureGreen("test");
 * ownership. Elasticsearch licenses this file to you under  
                .prepareUpdateSettings()
        final MockInternalClusterInfoService clusterInfoService = getMockInternalClusterInfoService();  
 * Licensed to Elasticsearch under one or more contributor  
        clusterInfoService.setDiskUsageFunctionAndRefresh(  
                    Settings.builder()  
                )
import java.util.Map;  
                    : 1000L
        ensureGreen("test");  
                    .put("number_of_replicas", 0)  
import org.opensearch.plugins.Plugin;  
        // must wait for relocation to start
        final MockInternalClusterInfoService clusterInfoService = getMockInternalClusterInfoService();
        // Create an index with 6 shards so we can check allocation for it
/*
        return Collections.singletonList(MockInternalClusterInfoService.TestPlugin.class);  
        final ClusterState clusterState = client().admin().cluster().prepareState().get().getState();
            // ensure that each node has a single data path  
        assertAcked(prepareCreate("test").setSettings(Settings.builder().put("number_of_shards", 6).put("number_of_replicas", 0)));
 *  
                1000L,
                discoveryNode.getId().equals(nodeIds.get(2))  
        if (randomBoolean()) {
        final List<String> nodeIds = StreamSupport.stream(
                .indices()  
        for (final ShardStats shardStats : client().admin().indices().prepareStats("test").get().getShards()) {
import java.util.stream.Collectors;
        }
                .cluster()  
                client().prepareIndex().setIndex("test").setId("1").setSource("foo", "bar"),
import org.opensearch.cluster.MockInternalClusterInfoService;
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)
    }  
                        .put(CLUSTER_ROUTING_ALLOCATION_LOW_DISK_WATERMARK_SETTING.getKey(), "90%")
 * this file be licensed under the Apache-2.0 license or a
        final MockInternalClusterInfoService clusterInfoService = getMockInternalClusterInfoService();  
        assertAcked(prepareCreate("test").setSettings(Settings.builder().put("number_of_shards", 6).put("number_of_replicas", 0)));
                        .put(CLUSTER_ROUTING_ALLOCATION_DISK_FLOOD_STAGE_WATERMARK_SETTING.getKey(), watermarkBytes ? "0b" : "100%")  
        final AtomicReference<ClusterState> clusterManagerAppliedClusterState = new AtomicReference<>();  
        // ensure that relocations finished without moving any more shards
    }
        assertAcked(
        // prevent any effects from in-flight recoveries, since we are only simulating a 100-byte disk  
                .setTransientSettings(
 * Modifications Copyright OpenSearch Contributors. See
            assertThat(event.state().getRoutingNodes().node(nodeIds.get(2)).size(), lessThanOrEqualTo(1));
        clusterInfoService.setDiskUsageFunctionAndRefresh((discoveryNode, fsInfoPath) -> setDiskUsage(fsInfoPath, 100, between(10, 100)));  
        clusterInfoService.setDiskUsageFunctionAndRefresh(
 *    http://www.apache.org/licenses/LICENSE-2.0
        });
                1000L,
                .prepareUpdateSettings()
                100L,
        assertBusy(() -> {
        final long shardsOnGoodPath = Arrays.stream(client().admin().indices().prepareStats("test").get().getShards())
            (discoveryNode, fsInfoPath) -> setDiskUsage(
                fsInfoPath,  
            client().admin()
        ).map(RoutingNode::nodeId).collect(Collectors.toList());
 */
        clusterInfoService.setShardSizeFunctionAndRefresh(shardRouting -> 1L);
            assertThat("node0 has 2 shards", shardCountByNodeId.get(nodeIds.get(0)), equalTo(2));
                .setTransientSettings(
        // shards are 1 byte large
            prepareCreate("test").setSettings(  
import java.util.Collections;  
import static org.opensearch.cluster.routing.allocation.DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_HIGH_DISK_WATERMARK_SETTING;  
        }
            .filter(
            assertThat("node2 has at least 3 shards", shardCountByNodeId.get(nodeIds.get(2)), greaterThanOrEqualTo(3));  
            // ensure that each node has a single data path  
            twoPathSettings.putList(Environment.PATH_DATA_SETTING.getKey(), createTempDir().toString(), pathOverWatermark.toString());
            )
        clusterInfoService.setDiskUsageFunctionAndRefresh(
            for (final ShardStats shardStats : client().admin().indices().prepareStats("test").get().getShards()) {
        );
                        .put(CLUSTER_ROUTING_ALLOCATION_HIGH_DISK_WATERMARK_SETTING.getKey(), watermarkBytes ? "10b" : "90%")
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
        assertSearchHits(client().prepareSearch("test").get(), "1");
        clusterInfoService.setDiskUsageFunctionAndRefresh((discoveryNode, fsInfoPath) -> setDiskUsage(fsInfoPath, 1000L, 1000L));
        clusterInfoService.setShardSizeFunctionAndRefresh(shardRouting -> 0L);
        // one of the paths on node0 suddenly exceeds the high watermark
            assertThat("node2 has 2 shards", shardCountByNodeId.get(nodeIds.get(2)), equalTo(2));  
import org.opensearch.cluster.ClusterState;
                        .put(CLUSTER_ROUTING_ALLOCATION_LOW_DISK_WATERMARK_SETTING.getKey(), watermarkBytes ? "10b" : "90%")
        final MockInternalClusterInfoService clusterInfoService = getMockInternalClusterInfoService();
        );  
        ensureGreen("test");  
            (discoveryNode, fsInfoPath) -> setDiskUsage(
                .setTransientSettings(
import java.util.stream.StreamSupport;  
        // prevent any effects from in-flight recoveries, since we are only simulating a 100-byte disk  
                )
        clusterInfoService.setUpdateFrequency(TimeValue.timeValueMillis(200));
            clusterInfoService.refresh(); // so that a subsequent reroute sees disk usage according to the current state
        // Move all nodes below the high watermark so that the index is unblocked
            internalCluster().startNode(Settings.builder().put(Environment.PATH_DATA_SETTING.getKey(), createTempDir()));  
            false
            final Map<String, Integer> shardCountByNodeId = getShardCountByNodeId();  
                .prepareUpdateSettings()  
            final Map<String, Integer> shardCountByNodeId = getShardCountByNodeId();
        assertBusy(
            )
            clusterManagerAppliedClusterState.set(event.state());  
                .prepareUpdateSettings()
            assertThat("node0 has 5 shards", shardCountByNodeId.get(nodeIds.get(0)), equalTo(5));
            client().admin()
        // node 2 only has space for one shard  
            internalCluster().startNode(Settings.builder().put(Environment.PATH_DATA_SETTING.getKey(), createTempDir()));
        client().prepareIndex("test").setId("1").setSource("foo", "bar").setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE).get();
                .prepareUpdateSettings()
                100,
            client().admin()
            (discoveryNode, fsInfoPath) -> setDiskUsage(  
        clusterInfoService.setDiskUsageFunctionAndRefresh((discoveryNode, fsInfoPath) -> setDiskUsage(fsInfoPath, 100, between(15, 100)));
        assertThat(  
            client().admin()
    private static FsInfo.Path setDiskUsage(FsInfo.Path original, long totalBytes, long freeBytes) {  
            assertThat("node2 has 2 shards", shardCountByNodeId.get(nodeIds.get(2)), equalTo(2));
            }  
        // start with all nodes below the watermark  
                clusterState.getRoutingNodes().node(node.nodeId()).numberOfOwningShards()
                .setSettings(
        }
            IndexMetadata.INDEX_READ_ONLY_ALLOW_DELETE_BLOCK
                .cluster()  
        final Settings.Builder twoPathSettings = Settings.builder();  
        // start with all nodes below the watermark
            assertThat("node0 has at least 3 shards", shardCountByNodeId.get(nodeIds.get(0)), greaterThanOrEqualTo(3));
        for (final RoutingNode node : clusterState.getRoutingNodes()) {  
            );
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
    @Override
            (discoveryNode, fsInfoPath) -> setDiskUsage(  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                    Settings.builder()
                .cluster()  
            shardCountByNodeId.put(node.nodeId(), clusterState.getRoutingNodes().node(node.nodeId()).numberOfOwningShards());  
import static org.hamcrest.Matchers.startsWith;
                fsInfoPath,
import java.util.HashMap;
                client().prepareIndex("test")
        return new FsInfo.Path(original.getPath(), original.getMount(), totalBytes, freeBytes, freeBytes);
                throw new AssertionError("retrying", e);
                .filter(  
            assertThat("node1 has 5 shards", shardCountByNodeId.get(nodeIds.get(1)), equalTo(5));
        );  
        // the index is blocked
import static org.opensearch.cluster.routing.allocation.DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_DISK_FLOOD_STAGE_WATERMARK_SETTING;
                discoveryNode.getId().equals(nodeIds.get(2)) ? between(0, 4) : between(0, 9)
        assertBusy(() -> {
                    Settings.builder()  
            assertThat("node0 has 2 shards", shardCountByNodeId.get(nodeIds.get(0)), equalTo(2));
        );
            equalTo(shardsOnGoodPath)
        final List<String> nodeIds = StreamSupport.stream(
        logger.info("--> shards on good path: [{}]", shardsOnGoodPath);
        );
        assertBusy(() -> {  
        final boolean watermarkBytes = randomBoolean(); // we have to consistently use bytes or percentage for the disk watermark settings  
            assertThat("node1 has 2 shards", shardCountByNodeId.get(nodeIds.get(1)), equalTo(2));  
        assertAcked(  
        assertBlocked(  
        ).map(RoutingNode::nodeId).collect(Collectors.toList());
import static org.opensearch.cluster.routing.allocation.DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_REROUTE_INTERVAL_SETTING;
 *
import org.opensearch.common.settings.Settings;
        assertBusy(() -> {  
            final Map<String, Integer> shardCountByNodeId = getShardCountByNodeId();  
            assertThat("node2 has 0 shards", shardCountByNodeId.get(nodeIds.get(2)), equalTo(0));
        assertAcked(
import org.opensearch.cluster.routing.RoutingNode;
                .cluster()
                .setTransientSettings(
    }
                fsInfoPath,
        internalCluster().startNode(twoPathSettings);  
}  
                    : 1000L
                    .setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE)
        // disable rebalancing, or else we might move shards back onto the over-full path since we're not faking that  
            client().admin()
        assertBusy(() -> {
                .prepareUpdateSettings("test")
        clusterInfoService.refresh();  
            client().admin().cluster().prepareState().get().getState().getRoutingNodes().spliterator(),
        } else {  
                IndexMetadata.INDEX_READ_ONLY_ALLOW_DELETE_BLOCK
import org.opensearch.cluster.block.ClusterBlockException;  
            final Map<String, Integer> shardCountByNodeId = getShardCountByNodeId();  
        // move node2 above high watermark  
                100,  
            () -> assertBlocked(  
import java.nio.file.Path;  
    public void testAutomaticReleaseOfIndexBlock() throws Exception {
        assertAcked(  
        });
        }
        );  
                "----> node {} has {} shards",
    public void testOnlyMovesEnoughShardsToDropBelowHighWatermark() throws Exception {
            clusterManagerAppliedClusterState.set(event.state());
                .setTransientSettings(
            client().admin()
        return shardCountByNodeId;
        internalCluster().startNode(Settings.builder().put(Environment.PATH_DATA_SETTING.getKey(), createTempDir()));
        );  
import org.opensearch.cluster.ClusterInfoService;  
        assertAcked(
        assertAcked(
    protected Collection<Class<? extends Plugin>> nodePlugins() {
            "should not have moved any shards off of the path that wasn't too full",
    }
import org.opensearch.monitor.fs.FsInfo;
 * You may obtain a copy of the License at  
                )
            assertThat("node1 has 2 shards", shardCountByNodeId.get(nodeIds.get(1)), equalTo(2));  
import java.util.concurrent.atomic.AtomicReference;
            client().admin()
            false  
                        .put(CLUSTER_ROUTING_ALLOCATION_REROUTE_INTERVAL_SETTING.getKey(), "0ms")
                    Settings.builder().put(CLUSTER_ROUTING_REBALANCE_ENABLE_SETTING.getKey(), EnableAllocationDecider.Rebalance.NONE)  
            final Map<String, Integer> shardCountByNodeId = getShardCountByNodeId();  
        // node2 suddenly has 99 bytes free, less than 10%, but moving one shard is enough to bring it up to 100 bytes free:
        {  
        clusterInfoService.setShardSizeFunctionAndRefresh(shardRouting -> 0L);
        // disable rebalancing, or else we might move too many shards away and then rebalance them back again  
        logger.info("--> waiting for shards to rebalance back onto node [{}]", nodeIds.get(2));  
        });
                Settings.builder()
            client().admin().cluster().prepareState().get().getState().getRoutingNodes().spliterator(),
        return Settings.builder().put(super.indexSettings()).putNull(IndexMetadata.SETTING_DATA_PATH).build();  
import org.opensearch.common.unit.TimeValue;  
        );  
