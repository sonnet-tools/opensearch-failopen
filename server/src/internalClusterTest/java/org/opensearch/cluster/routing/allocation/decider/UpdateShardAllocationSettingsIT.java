            .prepareUpdateSettings()
 *
 * The OpenSearch Contributors require contributions made to
                    )
 * license agreements. See the NOTICE file distributed with
                Settings.builder()
                        EnableAllocationDecider.INDEX_ROUTING_REBALANCE_ENABLE_SETTING.getKey(),
            )
}
 * this work for additional information regarding copyright
        Set<String> test_1 = assertAllShardsOnNodes("test_1", firstNode, secondNode);
            )
import org.opensearch.cluster.metadata.IndexMetadata;
                Settings.builder()
        final int numShards = 2;
 * software distributed under the License is distributed on an
import org.opensearch.common.settings.Settings;
        assertThat("index: [test] expected to be rebalanced on both nodes", test.size(), equalTo(2));
        );
        logger.info("--> balance index [test_1]");
    /**
 *
        client().admin().cluster().prepareReroute().get();
        assertTrue(
 * KIND, either express or implied.  See the License for the
 *    http://www.apache.org/licenses/LICENSE-2.0
        client().admin()
            .prepareUpdateSettings()
                    .put(EnableAllocationDecider.CLUSTER_ROUTING_REBALANCE_ENABLE_SETTING.getKey(), EnableAllocationDecider.Rebalance.NONE)
     */
                Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0).put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, numShards)
 * the Apache License, Version 2.0 (the "License"); you may
    public void testEnableRebalance() throws InterruptedException {
        ensureGreen("test_1");
 * Licensed to Elasticsearch under one or more contributor
        assertAllShardsOnNodes("test", firstNode);
            prepareCreate("test").setSettings(
        client().admin().cluster().prepareReroute().get();
        ClusterState clusterState = client().admin().cluster().prepareState().get().getState();
        // prevent via index setting but only on index test
            .get();
                    .put(
        assertAllShardsOnNodes("test_1", firstNode);
 *
        client().admin()
        assertFalse(
 * under the License.
 * Unless required by applicable law or agreed to in writing,
                Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0).put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, numShards)
        final String secondNode = internalCluster().startNode();
            .cluster()
        test = assertAllShardsOnNodes("test", firstNode, secondNode);
            .setTransientSettings(Settings.builder().put(CLUSTER_ROUTING_ALLOCATION_SAME_HOST_SETTING.getKey(), false))
 * SPDX-License-Identifier: Apache-2.0
            clusterState.getRoutingTable().index(indexName).shardsWithState(ShardRoutingState.UNASSIGNED).isEmpty()
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
package org.opensearch.cluster.routing.allocation.decider;
        // only primaries should be assigned
                Settings.builder()
/*
    }
 * GitHub history for details.
        clusterState = client().admin().cluster().prepareState().get().getState();
 * An integration test for testing updating shard allocation/routing settings and
                    .put(
import static org.opensearch.cluster.routing.allocation.decider.SameShardAllocationDecider.CLUSTER_ROUTING_ALLOCATION_SAME_HOST_SETTING;
        );
/**
     * Tests that updating the {@link SameShardAllocationDecider#CLUSTER_ROUTING_ALLOCATION_SAME_HOST_SETTING} setting works as expected.
 * Modifications Copyright OpenSearch Contributors. See
                    )
        assertThat("index: [test] expected to be rebalanced on both nodes", test.size(), equalTo(2));
            .setSettings(Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1).put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1))
            .setSettings(
            .setTransientSettings(
 * ownership. Elasticsearch licenses this file to you under
            prepareCreate("test_1").setSettings(
            .get();
 */
            .indices()
            .setTransientSettings(
        ensureGreen();
            .prepareUpdateSettings("test")
            .prepareUpdateSettings()
            .get();
        ensureGreen();
 * You may obtain a copy of the License at
import org.opensearch.test.OpenSearchIntegTestCase;
    /**
            "replica should be unassigned",
import java.util.Set;
 * not use this file except in compliance with the License.
    public void testUpdateSameHostSetting() {
        // all shards are relocated to the second node which is not what we want here. It's solely a test for the settings to take effect
            .get();
            .prepareUpdateSettings("test")
        logger.info("--> balance index [test]");
        assertAcked(
                        randomBoolean() ? EnableAllocationDecider.Rebalance.PRIMARIES : EnableAllocationDecider.Rebalance.ALL
        internalCluster().startNodes(2);
     * Tests that updating the {@link EnableAllocationDecider} related settings works as expected.
        // we test with 2 shards since otherwise it's pretty fragile if there are difference in the num or shards such that
            .prepareUpdateSettings()
        // now, update the same_host setting to allow shards to be allocated to multiple nodes on
                Settings.builder()
        client().admin()
        Set<String> test = assertAllShardsOnNodes("test", firstNode, secondNode);
            .cluster()
        assertAllShardsOnNodes("test", firstNode);
 * specific language governing permissions and limitations
        client().admin()
 */
            )
            )
 * compatible open source license.
            .indices()
            clusterState.getRoutingTable().index(indexName).shardsWithState(ShardRoutingState.UNASSIGNED).isEmpty()
            .prepareCreate(indexName)
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        assertThat("index: [test_1] expected to be rebalanced on both nodes", test_1.size(), equalTo(2));
    }
 */
public class UpdateShardAllocationSettingsIT extends OpenSearchIntegTestCase {
 * ensuring the updated settings take effect as expected.
                        randomBoolean() ? EnableAllocationDecider.Rebalance.PRIMARIES : EnableAllocationDecider.Rebalance.ALL
        assertAllShardsOnNodes("test_1", firstNode);
            .get();
            .cluster()
        // now enable the index test to relocate since index settings override cluster settings
            .cluster()
            .indices()
                    .put(EnableAllocationDecider.INDEX_ROUTING_REBALANCE_ENABLE_SETTING.getKey(), EnableAllocationDecider.Rebalance.NONE)
        );
                        EnableAllocationDecider.CLUSTER_ROUTING_REBALANCE_ENABLE_SETTING.getKey(),
            .setSettings(
import org.opensearch.cluster.routing.ShardRoutingState;
        // same same_host to true, since 2 nodes are started on the same host,
        // the same host - the replica should get assigned
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)
        );
            "all shards should be assigned",
            )
        ensureGreen("test");
import org.opensearch.cluster.ClusterState;
        client().admin().cluster().prepareReroute().get();
        // flip the cluster wide setting such that we can also balance for index
        client().admin()
        assertAcked(
     */
            .setTransientSettings(Settings.builder().put(CLUSTER_ROUTING_ALLOCATION_SAME_HOST_SETTING.getKey(), true))
/*
/*
import static org.hamcrest.Matchers.equalTo;
 * this file be licensed under the Apache-2.0 license or a
        client().admin()
            .get();
        client().admin()
        // test_1 eventually we should have one shard of each index on each node
 */
            )
        final String indexName = "idx";
        final String firstNode = internalCluster().startNode();
            .get();
