                .setTransientSettings(
                .setTransientSettings(
        final List<String> nodeIds = StreamSupport.stream(
            final Map<String, Integer> shardCountByNodeId = getShardCountByNodeId();
            final Map<String, Integer> shardCountByNodeId = getShardCountByNodeId();
                shardStats -> shardStats.getShardRouting().currentNodeId().equals(nodeWithTwoPaths)
        // disable rebalancing, or else we might move shards back onto the over-full path since we're not faking that
        internalCluster().startNode(twoPathSettings);
        assertBusy(() -> {
            assertThat("node1 has at least 3 shards", shardCountByNodeId.get(nodeIds.get(1)), greaterThanOrEqualTo(3));
    }
                .prepareUpdateSettings()
            );
 * the Apache License, Version 2.0 (the "License"); you may
                )
        clusterInfoService.setUpdateFrequency(TimeValue.timeValueMillis(200));
            assertThat("node1 has 2 shards", shardCountByNodeId.get(nodeIds.get(1)), equalTo(2));
 * compatible open source license.
        final List<String> nodeIds = StreamSupport.stream(
            twoPathSettings.putList(Environment.PATH_DATA_SETTING.getKey(), pathOverWatermark.toString(), createTempDir().toString());
                assertThat(shardStats.getDataPath(), not(startsWith(pathOverWatermark.toString())));
        });
            clusterManagerAppliedClusterState.set(event.state());
        assertBusy(() -> {
import static org.opensearch.cluster.routing.allocation.DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_DISK_FLOOD_STAGE_WATERMARK_SETTING;
    public Settings indexSettings() {
        assertAcked(prepareCreate("test").setSettings(Settings.builder().put("number_of_shards", 10).put("number_of_replicas", 0)));
                        .put(CLUSTER_ROUTING_ALLOCATION_HIGH_DISK_WATERMARK_SETTING.getKey(), "90%")
            assertThat("node2 has at least 3 shards", shardCountByNodeId.get(nodeIds.get(2)), greaterThanOrEqualTo(3));
                "----> node {} has {} shards",
        for (int i = 0; i < 3; i++) {
                )
            client().admin().cluster().prepareState().get().getState().getRoutingNodes().spliterator(),
        );
 */
            client().admin()
                    Settings.builder()
 * Unless required by applicable law or agreed to in writing,
                        .put(CLUSTER_ROUTING_ALLOCATION_DISK_FLOOD_STAGE_WATERMARK_SETTING.getKey(), "100%")
            client().admin()
 * You may obtain a copy of the License at
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            assertThat("node1 has 5 shards", shardCountByNodeId.get(nodeIds.get(1)), equalTo(5));
        // shards are 1 byte large
package org.opensearch.cluster.routing.allocation.decider;
import java.nio.file.Path;
            assertThat("node0 has at least 3 shards", shardCountByNodeId.get(nodeIds.get(0)), greaterThanOrEqualTo(3));
import static org.hamcrest.Matchers.equalTo;
        );
        assertBusy(() -> assertThat("node2 has 1 shard", getShardCountByNodeId().get(nodeIds.get(2)), equalTo(1)));
            internalCluster().startNode(Settings.builder().put(Environment.PATH_DATA_SETTING.getKey(), createTempDir()));
        );
                        .put(CLUSTER_ROUTING_ALLOCATION_REROUTE_INTERVAL_SETTING.getKey(), "0ms")
        clusterInfoService.setDiskUsageFunctionAndRefresh(
        ensureGreen("test");
            )
import static org.hamcrest.Matchers.startsWith;
            for (final ShardStats shardStats : client().admin().indices().prepareStats("test").get().getShards()) {
                )
                    Settings.builder()
        ensureGreen("test");
            clusterManagerAppliedClusterState.set(event.state());
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)
            client().admin()
import static org.hamcrest.Matchers.not;
        // Move all nodes below the high watermark so that the index is unblocked
        logger.info("--> waiting for shards to relocate off node [{}]", nodeIds.get(2));
                        .put(CLUSTER_ROUTING_ALLOCATION_HIGH_DISK_WATERMARK_SETTING.getKey(), "100%")
            )
import java.util.Map;
import org.opensearch.action.admin.indices.stats.ShardStats;
        assertBusy(() -> {
                    ? 101L - clusterManagerAppliedClusterState.get().getRoutingNodes().node(nodeIds.get(2)).numberOfOwningShards()
                )
            .count();
/*
                    && shardStats.getDataPath().startsWith(pathOverWatermark.toString()) == false
        }
 * specific language governing permissions and limitations
        // start with all nodes below the low watermark
        assertAcked(
            )
    protected Collection<Class<? extends Plugin>> nodePlugins() {
        assertFalse(client().admin().cluster().prepareHealth("test").setWaitForEvents(Priority.LANGUID).get().isTimedOut());
import org.opensearch.monitor.fs.FsInfo;
                    .get();
/*
            assertThat("node0 has at least 3 shards", shardCountByNodeId.get(nodeIds.get(0)), greaterThanOrEqualTo(3));
        });
    }
            } catch (ClusterBlockException e) {
            (discoveryNode, fsInfoPath) -> setDiskUsage(
            (discoveryNode, fsInfoPath) -> setDiskUsage(
    }
            assertThat("node2 has 0 shards", shardCountByNodeId.get(nodeIds.get(2)), equalTo(0));
                    Settings.builder().put(CLUSTER_ROUTING_REBALANCE_ENABLE_SETTING.getKey(), EnableAllocationDecider.Rebalance.NONE)
            logger.info(
        // Move all nodes above the low watermark so no shard movement can occur, and at least one node above the flood stage watermark so
                100,
                .setTransientSettings(
        // shards are 1 byte large
            final Map<String, Integer> shardCountByNodeId = getShardCountByNodeId();
        final AtomicReference<ClusterState> clusterManagerAppliedClusterState = new AtomicReference<>();
                fsInfoPath,
        }
        for (int i = 0; i < 3; i++) {
            client().admin().cluster().prepareState().get().getState().getRoutingNodes().spliterator(),
        logger.info("--> shards on good path: [{}]", shardsOnGoodPath);
        });
import org.opensearch.common.unit.TimeValue;
                fsInfoPath,
            )
                        .put(CLUSTER_ROUTING_ALLOCATION_LOW_DISK_WATERMARK_SETTING.getKey(), watermarkBytes ? "10b" : "90%")
        ).map(RoutingNode::nodeId).collect(Collectors.toList());
 *    http://www.apache.org/licenses/LICENSE-2.0
        // start with all nodes below the watermark
import org.opensearch.common.settings.Settings;
        final Map<String, Integer> shardCountByNodeId = new HashMap<>();
        clusterInfoService.setDiskUsageFunctionAndRefresh(
    @Override
    }
            // ensure that each node has a single data path
 *
                fsInfoPath.getPath().startsWith(pathOverWatermark.toString()) ? between(0, 9) : between(10, 100)
        assertAcked(prepareCreate("test").setSettings(Settings.builder().put("number_of_shards", 6).put("number_of_replicas", 0)));
        );
                        .put(CLUSTER_ROUTING_ALLOCATION_LOW_DISK_WATERMARK_SETTING.getKey(), "85%")
import java.util.Arrays;
        });
        // Attempt to create a new document until DiskUsageMonitor unblocks the index
        final boolean watermarkBytes = randomBoolean(); // we have to consistently use bytes or percentage for the disk watermark settings
        return Collections.singletonList(MockInternalClusterInfoService.TestPlugin.class);
            internalCluster().startNode(Settings.builder().put(Environment.PATH_DATA_SETTING.getKey(), createTempDir()));
        if (randomBoolean()) {
import org.opensearch.cluster.service.ClusterService;
                100,
        }
import org.opensearch.cluster.ClusterInfoService;
        final Path pathOverWatermark = createTempDir();
                .cluster()
        clusterInfoService.setShardSizeFunctionAndRefresh(shardRouting -> 1L);
        );
                IndexMetadata.INDEX_READ_ONLY_ALLOW_DELETE_BLOCK
            client().prepareIndex().setIndex("test").setId("2").setSource("foo", "bar"),
        clusterInfoService.setDiskUsageFunctionAndRefresh((discoveryNode, fsInfoPath) -> setDiskUsage(fsInfoPath, 100, between(10, 100)));
import static org.opensearch.cluster.routing.allocation.decider.EnableAllocationDecider.CLUSTER_ROUTING_REBALANCE_ENABLE_SETTING;
                clusterState.getRoutingNodes().node(node.nodeId()).numberOfOwningShards()
        final MockInternalClusterInfoService clusterInfoService = getMockInternalClusterInfoService();
public class MockDiskUsagesIT extends OpenSearchIntegTestCase {
                        .put(CLUSTER_ROUTING_ALLOCATION_REROUTE_INTERVAL_SETTING.getKey(), "150ms")
        // move all nodes below watermark again
import java.util.stream.StreamSupport;
        for (final ShardStats shardStats : client().admin().indices().prepareStats("test").get().getShards()) {
                .prepareUpdateSettings()
        // one of the paths on node0 suddenly exceeds the high watermark
 * this file be licensed under the Apache-2.0 license or a
        {
    @Override
        assertAcked(
                        .put(CLUSTER_ROUTING_ALLOCATION_HIGH_DISK_WATERMARK_SETTING.getKey(), watermarkBytes ? "10b" : "90%")
        clusterInfoService.setDiskUsageFunctionAndRefresh((discoveryNode, fsInfoPath) -> setDiskUsage(fsInfoPath, 1000L, 1000L));
        final MockInternalClusterInfoService clusterInfoService = getMockInternalClusterInfoService();
                        .put(CLUSTER_ROUTING_ALLOCATION_LOW_DISK_WATERMARK_SETTING.getKey(), "90%")
                discoveryNode.getId().equals(nodeIds.get(2))
            final Map<String, Integer> shardCountByNodeId = getShardCountByNodeId();
                .prepareUpdateSettings()
                .cluster()
        });
        });
                .prepareUpdateSettings()
            assertThat("node0 has 2 shards", shardCountByNodeId.get(nodeIds.get(0)), equalTo(2));
                .indices()
            (discoveryNode, fsInfoPath) -> setDiskUsage(
        logger.info("--> waiting for shards to relocate off path [{}]", pathOverWatermark);
        assertAcked(prepareCreate("test").setSettings(Settings.builder().put("number_of_shards", 6).put("number_of_replicas", 0)));
            assertThat("node0 has 5 shards", shardCountByNodeId.get(nodeIds.get(0)), equalTo(5));
        assertAcked(
    }
        clusterInfoService.setShardSizeFunctionAndRefresh(shardRouting -> 0L);
                    Settings.builder()
 * license agreements. See the NOTICE file distributed with
import org.opensearch.cluster.block.ClusterBlockException;
/*
            client().admin()
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertBlocked;
        );
        }
            (discoveryNode, fsInfoPath) -> setDiskUsage(
            false
                        .put(CLUSTER_ROUTING_ALLOCATION_LOW_DISK_WATERMARK_SETTING.getKey(), "90%")
        final boolean watermarkBytes = randomBoolean(); // we have to consistently use bytes or percentage for the disk watermark settings
        } else {
 * ownership. Elasticsearch licenses this file to you under
        ensureGreen("test");
        ).map(RoutingNode::nodeId).collect(Collectors.toList());
                client().prepareIndex().setIndex("test").setId("1").setSource("foo", "bar"),
            shardCountByNodeId.put(node.nodeId(), clusterState.getRoutingNodes().node(node.nodeId()).numberOfOwningShards());
                    shardStats -> shardStats.getShardRouting().currentNodeId().equals(nodeWithTwoPaths)
 * not use this file except in compliance with the License.
        clusterInfoService.setDiskUsageFunctionAndRefresh((discoveryNode, fsInfoPath) -> setDiskUsage(fsInfoPath, 100, between(10, 100)));
            client().admin()
        internalCluster().startNode(Settings.builder().put(Environment.PATH_DATA_SETTING.getKey(), createTempDir()));
        );
        assertBlocked(
            assertThat(shardStats.getDataPath(), not(startsWith(pathOverWatermark.toString())));
 *
            client().admin().cluster().prepareState().get().getState().getRoutingNodes().spliterator(),
                        .put(CLUSTER_ROUTING_ALLOCATION_DISK_FLOOD_STAGE_WATERMARK_SETTING.getKey(), "100%")
        // start with all paths below the watermark
        ).map(RoutingNode::nodeId).collect(Collectors.toList());
import java.util.concurrent.atomic.AtomicReference;
        clusterInfoService.setShardSizeFunctionAndRefresh(shardRouting -> 0L);
            }
                )
        prepareCreate("test").setSettings(Settings.builder().put("number_of_shards", 6).put("number_of_replicas", 0)).get();
                    .put(IndexMetadata.INDEX_ROUTING_EXCLUDE_GROUP_SETTING.getConcreteSettingForNamespace("_id").getKey(), nodeIds.get(2))
 * under the License.
        final long shardsOnGoodPath = Arrays.stream(client().admin().indices().prepareStats("test").get().getShards())
                .cluster()
import java.util.List;
        assertBusy(() -> {
        return shardCountByNodeId;
        final AtomicReference<ClusterState> clusterManagerAppliedClusterState = new AtomicReference<>();
            prepareCreate("test").setSettings(
}
            )
        logger.info("--> waiting for shards to relocate onto node [{}]", nodeIds.get(2));
import org.opensearch.cluster.ClusterState;
        logger.info("--> waiting for shards to rebalance back onto node [{}]", nodeIds.get(2));
        assertBusy(() -> {
 */
        internalCluster().getCurrentClusterManagerNodeInstance(ClusterService.class).addListener(event -> {
        assertAcked(
        );
        clusterInfoService.setDiskUsageFunctionAndRefresh((discoveryNode, fsInfoPath) -> setDiskUsage(fsInfoPath, 100, between(10, 100)));
                        .put(CLUSTER_ROUTING_ALLOCATION_REROUTE_INTERVAL_SETTING.getKey(), "0ms")
            // ensure that each node has a single data path
            clusterInfoService.refresh(); // so that a subsequent reroute sees disk usage according to the current state
        return new FsInfo.Path(original.getPath(), original.getMount(), totalBytes, freeBytes, freeBytes);
            false
            final Map<String, Integer> shardCountByNodeId = getShardCountByNodeId();
        for (int i = 0; i < 3; i++) {
        final ClusterState clusterState = client().admin().cluster().prepareState().get().getState();
 * software distributed under the License is distributed on an
                fsInfoPath,
            // ensure that each node has a single data path
            // ensure that each node has a single data path
import org.opensearch.plugins.Plugin;
        assertThat("node2 has 1 shard", getShardCountByNodeId().get(nodeIds.get(2)), equalTo(1));
        // the index is blocked
        // must wait for relocation to start
        // ensure that indices do not use custom data paths
        ).map(RoutingNode::nodeId).collect(Collectors.toList());
        final MockInternalClusterInfoService clusterInfoService = getMockInternalClusterInfoService();
        final String nodeWithTwoPaths = client().admin().cluster().prepareNodesInfo().get().getNodes().get(0).getNode().getId();
                discoveryNode.getId().equals(nodeIds.get(2))
        final MockInternalClusterInfoService clusterInfoService = getMockInternalClusterInfoService();
        // move node2 above high watermark
        assertThat(
                    .setId("3")
import static org.hamcrest.Matchers.lessThanOrEqualTo;
                        .put(CLUSTER_ROUTING_ALLOCATION_HIGH_DISK_WATERMARK_SETTING.getKey(), "90%")
        logger.info("--> waiting for shards to relocate off node [{}]", nodeIds.get(2));
        assertThat("node2 has 1 shard", getShardCountByNodeId().get(nodeIds.get(2)), equalTo(1));
                        .put(CLUSTER_ROUTING_ALLOCATION_HIGH_DISK_WATERMARK_SETTING.getKey(), watermarkBytes ? "10b" : "90%")
        assertAcked(
                .cluster()
                1000L,
            assertThat("node0 has 3 shards", shardCountByNodeId.get(nodeIds.get(0)), equalTo(3));
        }
                        .put(CLUSTER_ROUTING_ALLOCATION_LOW_DISK_WATERMARK_SETTING.getKey(), watermarkBytes ? "10b" : "90%")
        ensureGreen("test");
        final MockInternalClusterInfoService clusterInfoService = getMockInternalClusterInfoService();
                fsInfoPath,
        return (MockInternalClusterInfoService) internalCluster().getCurrentClusterManagerNodeInstance(ClusterInfoService.class);
        }
                1000L,
                .setTransientSettings(
                .filter(
                    ? 150L - clusterManagerAppliedClusterState.get().getRoutingNodes().node(nodeIds.get(2)).numberOfOwningShards()
        internalCluster().startNode(Settings.builder().put(Environment.PATH_DATA_SETTING.getKey(), createTempDir()));
        clusterInfoService.setDiskUsageFunctionAndRefresh(
        assertSearchHits(client().prepareSearch("test").get(), "1", "3");
                        && shardStats.getDataPath().startsWith(pathOverWatermark.toString()) == false
        clusterInfoService.refresh();
                100L,
                Settings.builder()
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
        );
import static org.opensearch.cluster.routing.allocation.DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_HIGH_DISK_WATERMARK_SETTING;
            assertThat("node0 has 2 shards", shardCountByNodeId.get(nodeIds.get(0)), equalTo(2));
        assertSearchHits(client().prepareSearch("test").get(), "1");
            assertThat("node2 has 2 shards", shardCountByNodeId.get(nodeIds.get(2)), equalTo(2));
            internalCluster().startNode(Settings.builder().put(Environment.PATH_DATA_SETTING.getKey(), createTempDir()));
    public void testRerouteOccursOnDiskPassingHighWatermark() throws Exception {
            IndexMetadata.INDEX_READ_ONLY_ALLOW_DELETE_BLOCK
            client().admin().cluster().prepareState().get().getState().getRoutingNodes().spliterator(),
            client().admin()
            (discoveryNode, fsInfoPath) -> setDiskUsage(
        clusterInfoService.setUpdateFrequency(TimeValue.timeValueMillis(200));
        clusterInfoService.setShardSizeFunctionAndRefresh(shardRouting -> 1L);
        // node 2 only has space for one shard
        });
import java.util.stream.Collectors;
    private Map<String, Integer> getShardCountByNodeId() {
        ensureGreen("test");
            )
        );
        );
        for (final RoutingNode node : clusterState.getRoutingNodes()) {
                .count(),
 * GitHub history for details.
                )
        final List<String> nodeIds = StreamSupport.stream(
        );
            assertThat("node1 has 3 shards", shardCountByNodeId.get(nodeIds.get(1)), equalTo(3));
        // Cannot add further documents
        final Settings.Builder twoPathSettings = Settings.builder();
            false
 * SPDX-License-Identifier: Apache-2.0
        // prevent any effects from in-flight recoveries, since we are only simulating a 100-byte disk
                throw new AssertionError("retrying", e);
            client().admin()
                client().prepareIndex("test")
        });
            )
        // start one node with two data paths
 */
            assertThat("node0 has 2 shards", shardCountByNodeId.get(nodeIds.get(0)), equalTo(2));
        );
            internalCluster().startNode(Settings.builder().put(Environment.PATH_DATA_SETTING.getKey(), createTempDir()));
                .cluster()
                .setTransientSettings(
        // disable rebalancing, or else we might move too many shards away and then rebalance them back again
                .setTransientSettings(
                node.nodeId(),
 * The OpenSearch Contributors require contributions made to
        return Settings.builder().put(super.indexSettings()).putNull(IndexMetadata.SETTING_DATA_PATH).build();
        }
    private MockInternalClusterInfoService getMockInternalClusterInfoService() {
        );
import org.opensearch.cluster.metadata.IndexMetadata;
            final Map<String, Integer> shardCountByNodeId = getShardCountByNodeId();
import org.opensearch.action.support.WriteRequest;
        assertBusy(
                .prepareUpdateSettings("test")
        ensureGreen("test");
        });
                    .setSource("foo", "bar")
 * Licensed to Elasticsearch under one or more contributor
        assertAcked(
            assertThat("node2 has at least 3 shards", shardCountByNodeId.get(nodeIds.get(2)), greaterThanOrEqualTo(3));
        internalCluster().getCurrentClusterManagerNodeInstance(ClusterService.class).addListener(event -> {
import static org.opensearch.cluster.routing.allocation.DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_LOW_DISK_WATERMARK_SETTING;
            assertThat("node2 has 2 shards", shardCountByNodeId.get(nodeIds.get(2)), equalTo(2));
                        .putNull(IndexMetadata.INDEX_ROUTING_EXCLUDE_GROUP_SETTING.getConcreteSettingForNamespace("_id").getKey())
                    .setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE)
        assertSearchHits(client().prepareSearch("test").get(), "1");
 * Modifications Copyright OpenSearch Contributors. See
        {
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
                    : 1000L
import java.util.Collections;
            Arrays.stream(client().admin().indices().prepareStats("test").get().getShards())
        // node2 suddenly has 99 bytes free, less than 10%, but moving one shard is enough to bring it up to 100 bytes free:
                    Settings.builder()
                fsInfoPath,
    public void testAutomaticReleaseOfIndexBlock() throws Exception {
                    .put("number_of_replicas", 0)
        // prevent any effects from in-flight recoveries, since we are only simulating a 100-byte disk
            clusterInfoService.refresh(); // so that a subsequent reroute sees disk usage according to the current state
        ).map(RoutingNode::nodeId).collect(Collectors.toList());
        clusterInfoService.setDiskUsageFunctionAndRefresh((discoveryNode, fsInfoPath) -> setDiskUsage(fsInfoPath, 100, between(15, 100)));
                        .put(CLUSTER_ROUTING_ALLOCATION_DISK_FLOOD_STAGE_WATERMARK_SETTING.getKey(), watermarkBytes ? "5b" : "95%")
    }
        client().prepareIndex("test").setId("1").setSource("foo", "bar").setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE).get();
        // ensure that relocations finished without moving any more shards
                .cluster()
                discoveryNode.getId().equals(nodeIds.get(2)) ? between(0, 9) : between(10, 100)
            assertThat("node2 has 2 shards", shardCountByNodeId.get(nodeIds.get(2)), equalTo(2));
    public void testDoesNotExceedLowWatermarkWhenRebalancing() throws Exception {
                )
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSearchHits;
            }
                .prepareUpdateSettings()
        );
        logger.info("--> index is confirmed read-only, releasing disk space");
                discoveryNode.getId().equals(nodeIds.get(2)) ? between(0, 4) : between(0, 9)
import org.opensearch.env.Environment;
            assertThat("node1 has at least 3 shards", shardCountByNodeId.get(nodeIds.get(1)), greaterThanOrEqualTo(3));
                .setTransientSettings(
import org.opensearch.common.Priority;
                    : 1000L
        // start with all nodes below the watermark
                        .put(CLUSTER_ROUTING_ALLOCATION_DISK_FLOOD_STAGE_WATERMARK_SETTING.getKey(), watermarkBytes ? "0b" : "100%")
        assertBusy(() -> {
import org.opensearch.cluster.MockInternalClusterInfoService;
            assertThat("node1 has 2 shards", shardCountByNodeId.get(nodeIds.get(1)), equalTo(2));
    }
            twoPathSettings.putList(Environment.PATH_DATA_SETTING.getKey(), createTempDir().toString(), pathOverWatermark.toString());
                .cluster()
            assertThat("node2 has 0 shards", shardCountByNodeId.get(nodeIds.get(2)), equalTo(0));
    public void testMovesShardsOffSpecificDataPathAboveWatermark() throws Exception {
            .filter(
            false
import static org.opensearch.cluster.routing.allocation.DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_REROUTE_INTERVAL_SETTING;
    }
import org.opensearch.test.OpenSearchIntegTestCase;
        // prevent any effects from in-flight recoveries, since we are only simulating a 100-byte disk
            )
            try {
        assertBusy(() -> {
                    Settings.builder().put(CLUSTER_ROUTING_REBALANCE_ENABLE_SETTING.getKey(), EnableAllocationDecider.Rebalance.NONE)
                    Settings.builder()
import java.util.Collection;
        ensureGreen("test");
                    .put("number_of_shards", 6)
            final Map<String, Integer> shardCountByNodeId = getShardCountByNodeId();
    private static FsInfo.Path setDiskUsage(FsInfo.Path original, long totalBytes, long freeBytes) {
        assertAcked(
        }
import org.opensearch.cluster.routing.RoutingNode;
        assertAcked(
            client().admin().cluster().prepareState().get().getState().getRoutingNodes().spliterator(),
            "should not have moved any shards off of the path that wasn't too full",
    }
        clusterInfoService.setDiskUsageFunctionAndRefresh((discoveryNode, fsInfoPath) -> setDiskUsage(fsInfoPath, 100, between(10, 100)));
        clusterInfoService.setDiskUsageFunctionAndRefresh(
        final List<String> nodeIds = StreamSupport.stream(
        final List<String> nodeIds = StreamSupport.stream(
            client().admin()
    }
            false
        // Create an index with 10 shards so we can check allocation for it
                )
 * KIND, either express or implied.  See the License for the
        // other two nodes have one data path each
        // Create an index with 6 shards so we can check allocation for it
 *
                    Settings.builder()
        }
            assertThat(event.state().getRoutingNodes().node(nodeIds.get(2)).size(), lessThanOrEqualTo(1));
        );
        for (int i = 0; i < 3; i++) {
    public void testOnlyMovesEnoughShardsToDropBelowHighWatermark() throws Exception {
                        .put(CLUSTER_ROUTING_ALLOCATION_DISK_FLOOD_STAGE_WATERMARK_SETTING.getKey(), "100%")
        clusterInfoService.setDiskUsageFunctionAndRefresh(
            assertThat("node1 has 2 shards", shardCountByNodeId.get(nodeIds.get(1)), equalTo(2));
 * this work for additional information regarding copyright
            equalTo(shardsOnGoodPath)
                .prepareUpdateSettings()
                )
        ensureGreen("test");
import java.util.HashMap;
        );
            () -> assertBlocked(
        assertAcked(
                .setSettings(
                .prepareUpdateSettings()
        clusterInfoService.setShardSizeFunctionAndRefresh(shardRouting -> 0L);
