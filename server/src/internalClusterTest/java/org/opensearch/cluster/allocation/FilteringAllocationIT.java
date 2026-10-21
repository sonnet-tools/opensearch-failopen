        state = client().admin().cluster().prepareState().get().getState();
                .setSize(0)
    }
        }
    }
 * Modifications Copyright OpenSearch Contributors. See
 * license agreements. See the NOTICE file distributed with
        indexRoutingTable = clusterState.routingTable().index("test");
                .setTransientSettings(Settings.builder().put("cluster.routing.allocation.exclude._name", node_1))
        assertThat(
        final boolean closed = randomBoolean();
            for (IndexShardRoutingTable indexShardRoutingTable : indexRoutingTable) {
import org.opensearch.core.common.Strings;
        client().admin().cluster().prepareUpdateSettings().setTransientSettings(exclude).get();
        }
        ensureGreen("test");
        if (closed) {
        final String node_0 = nodesIds.get(0);
@ClusterScope(scope = Scope.TEST, numDataNodes = 0)
        client().admin().indices().prepareRefresh().execute().actionGet();
            .prepareUpdateSettings("test")
 * the Apache License, Version 2.0 (the "License"); you may
                .execute()
                    + node
        assertEquals("invalid IP address [192.168.1.1.] for [" + filterSetting.getKey() + ipKey + "]", e.getMessage());
        ClusterState state = client().admin().cluster().prepareState().get().getState();
        ensureGreen("test");
/*
                .cluster()
        );
 * ownership. Elasticsearch licenses this file to you under
            FilterAllocationDecider.CLUSTER_ROUTING_REQUIRE_GROUP_SETTING,
        for (IndexShardRoutingTable indexShardRoutingTable : indexRoutingTable) {
                .actionGet()
import java.util.List;
        List<String> nodes = internalCluster().startNodes(6);
        logger.info("--> remove index from the first node");
        );
        if (randomBoolean()) {
        for (ShardRouting shard : state.getRoutingTable().shardsWithState(ShardRoutingState.STARTED)) {
                .prepareUpdateSettings("test")
        ensureGreen("test");
        clusterState = client().admin().cluster().prepareState().execute().actionGet().getState();
            }
        logger.info("--> creating an index with no replicas");
            assertTrue(
import org.opensearch.test.OpenSearchIntegTestCase.ClusterScope;
        List<String> nodesIds = internalCluster().startNodes(2);
        createIndex(
        assertThat(
 * GitHub history for details.
        assertThat(state.metadata().transientSettings(), equalTo(exclude));
        final String node_1 = nodesIds.get(1);
 * software distributed under the License is distributed on an
        ClusterState clusterState = client().admin().cluster().prepareState().execute().actionGet().getState();
        for (IndexRoutingTable indexRoutingTable : clusterState.routingTable()) {
 * this work for additional information regarding copyright
import org.opensearch.cluster.metadata.IndexMetadata;
 * Unless required by applicable law or agreed to in writing,
 * under the License.
import org.opensearch.cluster.routing.IndexShardRoutingTable;
            "--> exclude: [{}], include: [{}]",
        assertThat(clusterState.metadata().index("test").getNumberOfReplicas(), equalTo(0));
            assertTrue(
            );
                .setQuery(QueryBuilders.matchAllQuery())
        ensureStableCluster(6);
import java.util.Set;
                    + " but should only be on the include node list: "
                for (ShardRouting shardRouting : indexShardRoutingTable) {
            .actionGet();
            // make sure we can recover all the nodes at once otherwise we might run into a state where
        );
        );
            client().admin()
            Strings.collectionToCommaDelimitedString(excludeNodes),
 * this file be licensed under the Apache-2.0 license or a
                if ("node1".equals(clusterState.nodes().get(shardRouting.currentNodeId()).getName())) {
        client().admin()
        assertThat(clusterState.routingTable().index("test").numberOfNodesShardsAreAllocatedOn(), equalTo(2));
 * KIND, either express or implied.  See the License for the
 * SPDX-License-Identifier: Apache-2.0
        for (ShardRouting shard : state.getRoutingTable().shardsWithState(ShardRoutingState.STARTED)) {
                includeNodes.contains(node)
            client().prepareSearch()
        final String node_0 = nodesIds.get(0);
                    + Strings.collectionToCommaDelimitedString(includeNodes),
            .prepareUpdateSettings("test")
        }
                .execute()
import org.opensearch.cluster.routing.allocation.decider.FilterAllocationDecider;
/*
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
            .indices()
                .value(),
            .execute()
                .prepareUpdateSettings()
        client().admin().indices().prepareRefresh().execute().actionGet();
        logger.info("--> filter out the second node");
        ensureGreen("test");
        logger.info("--> starting 2 nodes");
        }
import org.opensearch.cluster.metadata.AutoExpandReplicas;
        }
                    assertThat(clusterState.nodes().get(shardRouting.currentNodeId()).getName(), equalTo(node_0));
            logger.info("--> shard on {} - {}", node, shard);
            assertAcked(client().admin().indices().prepareClose("test"));
                "shard on "
    public void testAutoExpandReplicasToFilteredNodes() {
        assertThat(cluster().size(), equalTo(2));
    }
 *
        logger.info("--> creating an index with no replicas");
        logger.info("--> verify all are allocated on node1 now");
            equalTo(100L)
            .execute()
 * Licensed to Elasticsearch under one or more contributor
                .actionGet();
import org.opensearch.test.OpenSearchIntegTestCase.Scope;
            ensureGreen("test");
            .setSettings(Settings.builder().put("index.routing.allocation.exclude._name", ""))
                .execute()
        final String node_1 = nodesIds.get(1);
 * The OpenSearch Contributors require contributions made to
        int numShardsOnNode1 = 0;
import java.util.HashSet;
import static org.hamcrest.Matchers.equalTo;
        Settings other = Settings.builder().put("cluster.info.update.interval", "45s").build();
        logger.info("--> starting 2 nodes");
import org.opensearch.cluster.ClusterState;
    public void testDisablingAllocationFiltering() {
        final boolean closed = randomBoolean();
import org.opensearch.test.OpenSearchIntegTestCase;
        final String node_1 = nodesIds.get(1);
                .execute()
        client().admin().indices().prepareRefresh().execute().actionGet();
            "test",
            IllegalArgumentException.class,
        ensureGreen("test");
 */
            assertAcked(client().admin().indices().prepareClose("test"));
        if (randomBoolean()) {
        clusterState = client().admin().cluster().prepareState().execute().actionGet().getState();
        logger.info("--> waiting for relocation");
        logger.info("--> index some data");
            }
        Setting<String> filterSetting = randomFrom(
        // The transient settings still exist in the state
        assertThat(clusterState.metadata().index("test").getNumberOfReplicas(), equalTo(1));
import org.opensearch.index.query.QueryBuilders;
        }
        logger.info("--> decommission the second node");
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            FilterAllocationDecider.CLUSTER_ROUTING_EXCLUDE_GROUP_SETTING
            .cluster()
        assertThat(cluster().size(), equalTo(2));
        logger.info("--> updating settings");
            Strings.collectionToCommaDelimitedString(includeNodes)
            .execute()
            .actionGet();
            String node = state.getRoutingNodes().node(shard.currentNodeId()).node().getName();
                }
        for (int i = 0; i < 100; i++) {
        logger.info("--> verify all are allocated on node1 now");
                .getHits()
            client().prepareSearch()
        }
            for (ShardRouting shardRouting : indexShardRoutingTable) {
        } else {
        }
        );
                .actionGet()
        if (numShardsOnNode1 > ThrottlingAllocationDecider.DEFAULT_CLUSTER_ROUTING_ALLOCATION_NODE_CONCURRENT_RECOVERIES) {
                    + Strings.collectionToCommaDelimitedString(includeNodes),
            client().prepareSearch()
                .actionGet();
        waitForRelocation(ClusterHealthStatus.GREEN);
        }
        assertThat(
            client().prepareIndex("test").setId(Integer.toString(i)).setSource("field", "value" + i).execute().actionGet();
        waitForRelocation(ClusterHealthStatus.GREEN);
        client().admin().cluster().prepareReroute().get();
        ensureGreen("test");
        String ipKey = randomFrom("_ip", "_host_ip", "_publish_ip");
        createIndex("test", Settings.builder().put(AutoExpandReplicas.SETTING.getKey(), "0-all").build());
            assertAcked(client().admin().indices().prepareOpen("test"));
        ensureGreen("test");
        }
                .prepareUpdateSettings()
        Set<String> excludeNodes = new HashSet<>(nodes.subList(0, 3));
public class FilteringAllocationIT extends OpenSearchIntegTestCase {
                .actionGet()
        clusterState = client().admin().cluster().prepareState().execute().actionGet().getState();
                    numShardsOnNode1++;
            .setTransientSettings(Settings.builder().put("cluster.routing.allocation.exclude._name", node_1))
        }
        client().admin().indices().prepareCreate("test").get();
            for (IndexShardRoutingTable indexShardRoutingTable : indexRoutingTable) {
        );
                includeNodes.contains(node)
            );
                .getTotalHits()
                .cluster()
    public void testDecommissionNodeNoReplicas() {
            assertAcked(client().admin().indices().prepareClose("test"));
        logger.info("--> creating an index with auto-expand replicas");
 */
 */
        }
/*
        client().admin()
        logger.info("--> disable allocation filtering ");
                .indices()
        logger.info(
        for (IndexShardRoutingTable indexShardRoutingTable : indexRoutingTable) {
        Set<String> includeNodes = new HashSet<>(nodes.subList(3, 6));
                .setSettings(Settings.builder().put("index.routing.allocation.exclude._name", node_1))
import org.opensearch.cluster.routing.IndexRoutingTable;
            equalTo(100L)
            logger.info("--> shard on {} - {}", node, shard);
        IllegalArgumentException e = expectThrows(
                .execute()
                .actionGet()
                .setTransientSettings(Settings.builder().put(filterSetting.getKey() + ipKey, "192.168.1.1."))
            ensureGreen("test");
        if (closed) {
                .cluster()
        client().admin()
            equalTo(100L)
package org.opensearch.cluster.allocation;
        }
 * not use this file except in compliance with the License.
                .actionGet();
        client().admin().cluster().prepareUpdateSettings().setPersistentSettings(other).setTransientSettings(exclude).get();
                .setSize(0)
import org.opensearch.cluster.routing.allocation.decider.ThrottlingAllocationDecider;
        logger.info("--> index some data");
                .getHits()
                .getHits()
import org.opensearch.common.settings.Settings;
        if (closed) {
        ensureGreen("test");
            .setSettings(Settings.builder().put("index.routing.allocation.exclude._name", node_0))
            }
        List<String> nodesIds = internalCluster().startNodes(2);
            .indices()
            }
        createIndex("test", Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0).build());
}
                .setTransientSettings(Settings.builder().put("cluster.routing.allocation.node_concurrent_recoveries", numShardsOnNode1))
                .setQuery(QueryBuilders.matchAllQuery())
        for (IndexRoutingTable indexRoutingTable : clusterState.routingTable()) {
                .setQuery(QueryBuilders.matchAllQuery())
        client().admin().cluster().prepareReroute().get();
            .put("cluster.routing.allocation.exclude._name", Strings.collectionToCommaDelimitedString(excludeNodes))
        List<String> nodesIds = internalCluster().startNodes(2);
            FilterAllocationDecider.CLUSTER_ROUTING_INCLUDE_GROUP_SETTING,
        ClusterState clusterState = client().admin().cluster().prepareState().execute().actionGet().getState();
                .getTotalHits()
                .setSize(0)
                }
    }
                .execute()
 *
import org.opensearch.common.settings.Setting;
import org.opensearch.cluster.health.ClusterHealthStatus;
                for (ShardRouting shardRouting : indexShardRoutingTable) {
 * compatible open source license.
                }
        ClusterState clusterState = client().admin().cluster().prepareState().execute().actionGet().getState();
        logger.info("--> verify all shards are allocated on node_1 now");
            Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 2).put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0).build()
                .value(),
        for (int i = 0; i < 100; i++) {
 * You may obtain a copy of the License at
                .prepareUpdateSettings()
                "shard on "
            String node = state.getRoutingNodes().node(shard.currentNodeId()).node().getName();
        logger.info("--> verify that there are shards allocated on both nodes now");
                .execute()
                    + " but should only be on the include node list: "
            client().admin()
        logger.info("--> waiting for relocation");
        IndexRoutingTable indexRoutingTable = clusterState.routingTable().index("test");
        }
            () -> client().admin()
                .getTotalHits()
        assertThat(cluster().size(), equalTo(2));
import org.opensearch.cluster.routing.ShardRoutingState;
            client().prepareIndex("test").setId(Integer.toString(i)).setSource("field", "value" + i).execute().actionGet();
    public void testTransientSettingsStillApplied() {
            .actionGet();
    public void testInvalidIPFilterClusterSettings() {
        logger.info("--> updating settings with random persistent setting");
        Settings exclude = Settings.builder()
 *
        logger.info("--> starting 2 nodes");
            .build();
            .prepareUpdateSettings()
        final String node_0 = nodesIds.get(0);
            // one of the shards has not yet started relocating but we already fired up the request to wait for 0 relocating shards.
 * specific language governing permissions and limitations
                    + node
                .value(),
            for (ShardRouting shardRouting : indexShardRoutingTable) {
import org.opensearch.cluster.routing.ShardRouting;
                    assertThat(clusterState.nodes().get(shardRouting.currentNodeId()).getName(), equalTo(node_0));
        );
 *    http://www.apache.org/licenses/LICENSE-2.0
    }
            client().admin()
                assertThat(clusterState.nodes().get(shardRouting.currentNodeId()).getName(), equalTo(node_1));
