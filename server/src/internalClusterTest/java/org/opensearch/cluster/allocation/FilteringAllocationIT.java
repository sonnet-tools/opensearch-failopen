        indexRoutingTable = clusterState.routingTable().index("test");
import org.opensearch.cluster.routing.ShardRouting;
                }
                    + node  
        logger.info("--> decommission the second node");
 * compatible open source license.
            .execute()
                .execute()  
                .setQuery(QueryBuilders.matchAllQuery())
        createIndex(  
        logger.info("--> creating an index with no replicas");
        }
            .cluster()
                    numShardsOnNode1++;
                .actionGet()
                }
            equalTo(100L)
        assertEquals("invalid IP address [192.168.1.1.] for [" + filterSetting.getKey() + ipKey + "]", e.getMessage());
 * ownership. Elasticsearch licenses this file to you under  
                .getTotalHits()  
        }
                .prepareUpdateSettings()
 *  
        final boolean closed = randomBoolean();
import org.opensearch.common.settings.Setting;
        }
        logger.info("--> verify that there are shards allocated on both nodes now");
@ClusterScope(scope = Scope.TEST, numDataNodes = 0)
 * under the License.  
 *    http://www.apache.org/licenses/LICENSE-2.0
                .getHits()
        for (IndexRoutingTable indexRoutingTable : clusterState.routingTable()) {
            "test",
        logger.info("--> index some data");  
        if (randomBoolean()) {
            () -> client().admin()  
                    + node
        assertThat(cluster().size(), equalTo(2));
        }  
        List<String> nodesIds = internalCluster().startNodes(2);
        assertThat(clusterState.metadata().index("test").getNumberOfReplicas(), equalTo(1));
 * Modifications Copyright OpenSearch Contributors. See
            client().prepareSearch()  
        Setting<String> filterSetting = randomFrom(
        logger.info("--> index some data");  
    public void testTransientSettingsStillApplied() {
                .value(),
import org.opensearch.cluster.routing.allocation.decider.FilterAllocationDecider;  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
                .value(),
 * specific language governing permissions and limitations
        ensureStableCluster(6);
        Set<String> includeNodes = new HashSet<>(nodes.subList(3, 6));
    public void testDecommissionNodeNoReplicas() {
        for (ShardRouting shard : state.getRoutingTable().shardsWithState(ShardRoutingState.STARTED)) {  
            Strings.collectionToCommaDelimitedString(includeNodes)
            }  
        ensureGreen("test");
            IllegalArgumentException.class,
        logger.info("--> creating an index with no replicas");  
                .getTotalHits()  
        final String node_0 = nodesIds.get(0);
                .setSize(0)
                assertThat(clusterState.nodes().get(shardRouting.currentNodeId()).getName(), equalTo(node_1));
        final String node_1 = nodesIds.get(1);
import org.opensearch.test.OpenSearchIntegTestCase.ClusterScope;
        for (IndexShardRoutingTable indexShardRoutingTable : indexRoutingTable) {  
        if (closed) {  
                .prepareUpdateSettings()
        assertThat(cluster().size(), equalTo(2));
        }  
                .cluster()
        logger.info(
            .actionGet();
            assertAcked(client().admin().indices().prepareClose("test"));
        ensureGreen("test");
        );  
    }
            String node = state.getRoutingNodes().node(shard.currentNodeId()).node().getName();
            logger.info("--> shard on {} - {}", node, shard);
            .indices()
    }
            FilterAllocationDecider.CLUSTER_ROUTING_INCLUDE_GROUP_SETTING,
                    + " but should only be on the include node list: "  
 * this work for additional information regarding copyright
        assertThat(state.metadata().transientSettings(), equalTo(exclude));
                .actionGet();  
                .indices()
            for (ShardRouting shardRouting : indexShardRoutingTable) {  
        client().admin().indices().prepareRefresh().execute().actionGet();
                .execute()
 * not use this file except in compliance with the License.
        String ipKey = randomFrom("_ip", "_host_ip", "_publish_ip");
        for (int i = 0; i < 100; i++) {
        for (ShardRouting shard : state.getRoutingTable().shardsWithState(ShardRoutingState.STARTED)) {
        int numShardsOnNode1 = 0;
            logger.info("--> shard on {} - {}", node, shard);  
        );  
            Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 2).put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0).build()
 * You may obtain a copy of the License at  
            client().admin()
        }
package org.opensearch.cluster.allocation;
            .put("cluster.routing.allocation.exclude._name", Strings.collectionToCommaDelimitedString(excludeNodes))
                .cluster()
            }  
        ClusterState state = client().admin().cluster().prepareState().get().getState();
 * GitHub history for details.
                "shard on "
                .prepareUpdateSettings("test")  
        List<String> nodes = internalCluster().startNodes(6);
import java.util.List;
        );  
        client().admin().indices().prepareCreate("test").get();
                    assertThat(clusterState.nodes().get(shardRouting.currentNodeId()).getName(), equalTo(node_0));
import org.opensearch.cluster.routing.IndexShardRoutingTable;  
        client().admin().indices().prepareRefresh().execute().actionGet();
        client().admin()
        }
public class FilteringAllocationIT extends OpenSearchIntegTestCase {  
        );  
                .getHits()
import org.opensearch.cluster.metadata.AutoExpandReplicas;  
        final String node_0 = nodesIds.get(0);
            client().prepareSearch()  
                .execute()
            }  
 * license agreements. See the NOTICE file distributed with
            "--> exclude: [{}], include: [{}]",  
                .actionGet();
        IndexRoutingTable indexRoutingTable = clusterState.routingTable().index("test");  
                }  
            ensureGreen("test");
                .setTransientSettings(Settings.builder().put("cluster.routing.allocation.node_concurrent_recoveries", numShardsOnNode1))
                .execute()
            .execute()
                for (ShardRouting shardRouting : indexShardRoutingTable) {  
 * this file be licensed under the Apache-2.0 license or a
            client().admin()  
            FilterAllocationDecider.CLUSTER_ROUTING_REQUIRE_GROUP_SETTING,  
import org.opensearch.cluster.ClusterState;
        state = client().admin().cluster().prepareState().get().getState();
        }
            .actionGet();
            assertAcked(client().admin().indices().prepareClose("test"));
            }
        clusterState = client().admin().cluster().prepareState().execute().actionGet().getState();
        for (IndexShardRoutingTable indexShardRoutingTable : indexRoutingTable) {
        logger.info("--> updating settings");
            String node = state.getRoutingNodes().node(shard.currentNodeId()).node().getName();
                    assertThat(clusterState.nodes().get(shardRouting.currentNodeId()).getName(), equalTo(node_0));
 * KIND, either express or implied.  See the License for the
        }
        logger.info("--> updating settings with random persistent setting");
        client().admin().cluster().prepareReroute().get();
        waitForRelocation(ClusterHealthStatus.GREEN);
        assertThat(
 */  
                .actionGet();
            client().admin()
        ClusterState clusterState = client().admin().cluster().prepareState().execute().actionGet().getState();  
            .prepareUpdateSettings("test")  
            for (IndexShardRoutingTable indexShardRoutingTable : indexRoutingTable) {
        assertThat(clusterState.metadata().index("test").getNumberOfReplicas(), equalTo(0));  
        );  
            assertTrue(  
        assertThat(
 *
 * software distributed under the License is distributed on an
            .execute()
        if (closed) {  
        for (int i = 0; i < 100; i++) {
        client().admin().indices().prepareRefresh().execute().actionGet();
        Settings other = Settings.builder().put("cluster.info.update.interval", "45s").build();  
    public void testAutoExpandReplicasToFilteredNodes() {  
                .actionGet()
    }
    }
                .value(),
            Strings.collectionToCommaDelimitedString(excludeNodes),
 * SPDX-License-Identifier: Apache-2.0
                .actionGet()
import org.opensearch.test.OpenSearchIntegTestCase;  
        final String node_1 = nodesIds.get(1);  
    public void testDisablingAllocationFiltering() {
        }  
        clusterState = client().admin().cluster().prepareState().execute().actionGet().getState();
                if ("node1".equals(clusterState.nodes().get(shardRouting.currentNodeId()).getName())) {
        client().admin().cluster().prepareUpdateSettings().setTransientSettings(exclude).get();
 * Licensed to Elasticsearch under one or more contributor  
                "shard on "
        clusterState = client().admin().cluster().prepareState().execute().actionGet().getState();
        ensureGreen("test");  
        assertThat(
            .actionGet();  
            // make sure we can recover all the nodes at once otherwise we might run into a state where
        final String node_0 = nodesIds.get(0);  
        logger.info("--> remove index from the first node");
            ensureGreen("test");
                .setQuery(QueryBuilders.matchAllQuery())
            FilterAllocationDecider.CLUSTER_ROUTING_EXCLUDE_GROUP_SETTING
            .setSettings(Settings.builder().put("index.routing.allocation.exclude._name", node_0))  
            assertTrue(
                .prepareUpdateSettings()
import org.opensearch.cluster.routing.allocation.decider.ThrottlingAllocationDecider;
        createIndex("test", Settings.builder().put(AutoExpandReplicas.SETTING.getKey(), "0-all").build());
import org.opensearch.cluster.metadata.IndexMetadata;
        ClusterState clusterState = client().admin().cluster().prepareState().execute().actionGet().getState();
                for (ShardRouting shardRouting : indexShardRoutingTable) {  
                .setQuery(QueryBuilders.matchAllQuery())
            equalTo(100L)
import org.opensearch.cluster.routing.ShardRoutingState;
                .actionGet()
import org.opensearch.common.settings.Settings;  
        } else {  
            );  
        ClusterState clusterState = client().admin().cluster().prepareState().execute().actionGet().getState();  
                .setSettings(Settings.builder().put("index.routing.allocation.exclude._name", node_1))
            .setTransientSettings(Settings.builder().put("cluster.routing.allocation.exclude._name", node_1))  
            for (IndexShardRoutingTable indexShardRoutingTable : indexRoutingTable) {
/*  
import org.opensearch.cluster.routing.IndexRoutingTable;
            assertAcked(client().admin().indices().prepareOpen("test"));
                .setSize(0)
        Settings exclude = Settings.builder()  
            // one of the shards has not yet started relocating but we already fired up the request to wait for 0 relocating shards.  
                .execute()  
                .execute()  
import org.opensearch.cluster.health.ClusterHealthStatus;
        ensureGreen("test");
import java.util.Set;  
 * Unless required by applicable law or agreed to in writing,
        logger.info("--> starting 2 nodes");
                .setTransientSettings(Settings.builder().put("cluster.routing.allocation.exclude._name", node_1))  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        ensureGreen("test");  
 * The OpenSearch Contributors require contributions made to  
    public void testInvalidIPFilterClusterSettings() {  
            .build();
        );  
        logger.info("--> waiting for relocation");
                    + Strings.collectionToCommaDelimitedString(includeNodes),
            .prepareUpdateSettings()
        if (randomBoolean()) {
        logger.info("--> disable allocation filtering ");  
import java.util.HashSet;
 */
 */  
        }
            client().prepareSearch()  
                .getTotalHits()  
            assertAcked(client().admin().indices().prepareClose("test"));  
import org.opensearch.test.OpenSearchIntegTestCase.Scope;
            for (ShardRouting shardRouting : indexShardRoutingTable) {
        }
            client().prepareIndex("test").setId(Integer.toString(i)).setSource("field", "value" + i).execute().actionGet();
        // The transient settings still exist in the state
        client().admin()  
        client().admin()  
/*
        if (numShardsOnNode1 > ThrottlingAllocationDecider.DEFAULT_CLUSTER_ROUTING_ALLOCATION_NODE_CONCURRENT_RECOVERIES) {
        for (IndexRoutingTable indexRoutingTable : clusterState.routingTable()) {
    }  
import static org.hamcrest.Matchers.equalTo;  
        logger.info("--> verify all shards are allocated on node_1 now");  
                    + " but should only be on the include node list: "
 *
}
        createIndex("test", Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0).build());
                .execute()  
        logger.info("--> waiting for relocation");
        if (closed) {  
        }
                .setTransientSettings(Settings.builder().put(filterSetting.getKey() + ipKey, "192.168.1.1."))  
        List<String> nodesIds = internalCluster().startNodes(2);
        assertThat(cluster().size(), equalTo(2));  
                includeNodes.contains(node)
import org.opensearch.core.common.Strings;
        logger.info("--> creating an index with auto-expand replicas");
        IllegalArgumentException e = expectThrows(
        final String node_1 = nodesIds.get(1);
        );  
        client().admin().cluster().prepareUpdateSettings().setPersistentSettings(other).setTransientSettings(exclude).get();  
        ensureGreen("test");
            .prepareUpdateSettings("test")
import org.opensearch.index.query.QueryBuilders;
        logger.info("--> starting 2 nodes");  
        ensureGreen("test");
        logger.info("--> filter out the second node");
        logger.info("--> starting 2 nodes");
        Set<String> excludeNodes = new HashSet<>(nodes.subList(0, 3));  
            equalTo(100L)
        logger.info("--> verify all are allocated on node1 now");
/*  
            .setSettings(Settings.builder().put("index.routing.allocation.exclude._name", ""))
                    + Strings.collectionToCommaDelimitedString(includeNodes),
        }  
        ensureGreen("test");
        List<String> nodesIds = internalCluster().startNodes(2);  
            client().prepareIndex("test").setId(Integer.toString(i)).setSource("field", "value" + i).execute().actionGet();
        client().admin().cluster().prepareReroute().get();  
        logger.info("--> verify all are allocated on node1 now");
        waitForRelocation(ClusterHealthStatus.GREEN);  
            .indices()
                .getHits()
 * the Apache License, Version 2.0 (the "License"); you may
                .cluster()  
            );
                includeNodes.contains(node)  
                .setSize(0)
        final boolean closed = randomBoolean();
        assertThat(clusterState.routingTable().index("test").numberOfNodesShardsAreAllocatedOn(), equalTo(2));  
