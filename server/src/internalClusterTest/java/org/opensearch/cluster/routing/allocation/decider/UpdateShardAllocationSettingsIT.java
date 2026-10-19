 * KIND, either express or implied.  See the License for the
        client().admin()  
            "all shards should be assigned",
 *  
 * SPDX-License-Identifier: Apache-2.0
            .setTransientSettings(  
 * ownership. Elasticsearch licenses this file to you under  
            )
        final String indexName = "idx";  
                Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0).put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, numShards)  
            prepareCreate("test_1").setSettings(
                    .put(EnableAllocationDecider.CLUSTER_ROUTING_REBALANCE_ENABLE_SETTING.getKey(), EnableAllocationDecider.Rebalance.NONE)
            .get();
        ensureGreen();  
            .prepareUpdateSettings()  
            .indices()  
        client().admin().cluster().prepareReroute().get();
                Settings.builder()
 * this work for additional information regarding copyright
        // flip the cluster wide setting such that we can also balance for index
        assertAllShardsOnNodes("test_1", firstNode);
 *
                Settings.builder()
/*  
 * software distributed under the License is distributed on an
        assertAllShardsOnNodes("test", firstNode);
            .get();
            .indices()
            .get();
    /**  
            "replica should be unassigned",
        );
            .prepareUpdateSettings("test")
 */  
                        EnableAllocationDecider.CLUSTER_ROUTING_REBALANCE_ENABLE_SETTING.getKey(),  
            .cluster()
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;  
        logger.info("--> balance index [test]");
        assertAcked(
        ensureGreen();  
}  
 */  
 * license agreements. See the NOTICE file distributed with
 * The OpenSearch Contributors require contributions made to  
            .setTransientSettings(  
        // prevent via index setting but only on index test
        clusterState = client().admin().cluster().prepareState().get().getState();  
        ensureGreen("test");  
                        randomBoolean() ? EnableAllocationDecider.Rebalance.PRIMARIES : EnableAllocationDecider.Rebalance.ALL  
    public void testEnableRebalance() throws InterruptedException {
 * GitHub history for details.
                Settings.builder()  
        logger.info("--> balance index [test_1]");
            )
            )  
            .setTransientSettings(Settings.builder().put(CLUSTER_ROUTING_ALLOCATION_SAME_HOST_SETTING.getKey(), true))
        assertTrue(
/**  
        // test_1 eventually we should have one shard of each index on each node
        client().admin()
import static org.opensearch.cluster.routing.allocation.decider.SameShardAllocationDecider.CLUSTER_ROUTING_ALLOCATION_SAME_HOST_SETTING;
package org.opensearch.cluster.routing.allocation.decider;
                Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0).put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, numShards)
                        EnableAllocationDecider.INDEX_ROUTING_REBALANCE_ENABLE_SETTING.getKey(),
 * Modifications Copyright OpenSearch Contributors. See  
        assertThat("index: [test] expected to be rebalanced on both nodes", test.size(), equalTo(2));  
                        randomBoolean() ? EnableAllocationDecider.Rebalance.PRIMARIES : EnableAllocationDecider.Rebalance.ALL
        Set<String> test_1 = assertAllShardsOnNodes("test_1", firstNode, secondNode);
 * Licensed to Elasticsearch under one or more contributor  
        // all shards are relocated to the second node which is not what we want here. It's solely a test for the settings to take effect  
import static org.hamcrest.Matchers.equalTo;
            .prepareUpdateSettings()
            .prepareCreate(indexName)  
import org.opensearch.cluster.routing.ShardRoutingState;
        assertThat("index: [test_1] expected to be rebalanced on both nodes", test_1.size(), equalTo(2));  
            .get();
 * specific language governing permissions and limitations
        final String firstNode = internalCluster().startNode();
        test = assertAllShardsOnNodes("test", firstNode, secondNode);
        client().admin()
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * this file be licensed under the Apache-2.0 license or a
        client().admin()
            .get();
            .setSettings(  
        // same same_host to true, since 2 nodes are started on the same host,
            .setTransientSettings(Settings.builder().put(CLUSTER_ROUTING_ALLOCATION_SAME_HOST_SETTING.getKey(), false))
            .get();  
 */
    /**
        client().admin()
 * An integration test for testing updating shard allocation/routing settings and
        );  
        client().admin()  
        );
import java.util.Set;  
            .setSettings(
     */
            .prepareUpdateSettings("test")
            clusterState.getRoutingTable().index(indexName).shardsWithState(ShardRoutingState.UNASSIGNED).isEmpty()  
        client().admin().cluster().prepareReroute().get();  
        assertAllShardsOnNodes("test", firstNode);
                    )
            clusterState.getRoutingTable().index(indexName).shardsWithState(ShardRoutingState.UNASSIGNED).isEmpty()  
            )  
import org.opensearch.cluster.ClusterState;  
                    .put(EnableAllocationDecider.INDEX_ROUTING_REBALANCE_ENABLE_SETTING.getKey(), EnableAllocationDecider.Rebalance.NONE)
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.cluster.metadata.IndexMetadata;
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)
/*
            .cluster()
        // only primaries should be assigned  
            .prepareUpdateSettings()
 * ensuring the updated settings take effect as expected.
            .prepareUpdateSettings()  
 *    http://www.apache.org/licenses/LICENSE-2.0
                    .put(
public class UpdateShardAllocationSettingsIT extends OpenSearchIntegTestCase {
    }
            .get();
        client().admin().cluster().prepareReroute().get();
            .cluster()
        client().admin()  
            .setSettings(Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1).put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1))
 *
        final int numShards = 2;
 * Unless required by applicable law or agreed to in writing,
        assertAllShardsOnNodes("test_1", firstNode);
    }
            .cluster()
     * Tests that updating the {@link SameShardAllocationDecider#CLUSTER_ROUTING_ALLOCATION_SAME_HOST_SETTING} setting works as expected.
                    .put(
 * not use this file except in compliance with the License.
        );
        ClusterState clusterState = client().admin().cluster().prepareState().get().getState();  
        assertThat("index: [test] expected to be rebalanced on both nodes", test.size(), equalTo(2));
     */  
import org.opensearch.common.settings.Settings;  
            )
                Settings.builder()
import org.opensearch.test.OpenSearchIntegTestCase;
            )  
        assertAcked(
 * compatible open source license.
        // the same host - the replica should get assigned  
        Set<String> test = assertAllShardsOnNodes("test", firstNode, secondNode);
        internalCluster().startNodes(2);
        final String secondNode = internalCluster().startNode();
 */
 * You may obtain a copy of the License at  
/*
                    )
 * under the License.  
        // now enable the index test to relocate since index settings override cluster settings
        assertFalse(
     * Tests that updating the {@link EnableAllocationDecider} related settings works as expected.
            .indices()
            prepareCreate("test").setSettings(  
    public void testUpdateSameHostSetting() {  
        // now, update the same_host setting to allow shards to be allocated to multiple nodes on
        // we test with 2 shards since otherwise it's pretty fragile if there are difference in the num or shards such that
        ensureGreen("test_1");
