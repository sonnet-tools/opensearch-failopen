import org.opensearch.common.Randomness;
import org.opensearch.test.OpenSearchTestCase;  
        response = new ClusterHealthResponse("", indices, clusterState);  
                i -> shardRoutingStates.add(
import java.util.List;  
        }  
import org.opensearch.cluster.ClusterName;  
        final ClusterHealthRequest request = new ClusterHealthRequest();  
            .routingTable(RoutingTable.builder().add(routingTable.build()).build())
 * this work for additional information regarding copyright
        request.waitForNoInitializingShards(true);
import org.opensearch.core.index.shard.ShardId;
import org.opensearch.action.support.ActiveShardCount;
 * license agreements. See the NOTICE file distributed with
 *  
                )
            );
        IntStream.range(0, initializingShards).forEach(i -> shardRoutingStates.add(ShardRoutingState.INITIALIZING));  
 * You may obtain a copy of the License at  
        response = new ClusterHealthResponse("", indices, clusterState);
            String node = state == ShardRoutingState.UNASSIGNED ? null : "node";  
        clusterState = randomClusterStateWithInitializingShards("test", between(1, 10));
/*
        final IndexMetadata indexMetadata = IndexMetadata.builder(index)
 * KIND, either express or implied.  See the License for the
        ClusterState clusterState = randomClusterStateWithInitializingShards("test", 1);
            String node = state == ShardRoutingState.UNASSIGNED ? null : "node" + i;
package org.opensearch.action.admin.cluster.health;
}
import org.opensearch.cluster.routing.TestShardRouting;
        clusterState = ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY)).build();
 * this file be licensed under the Apache-2.0 license or a
        return ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
    }  
 * SPDX-License-Identifier: Apache-2.0
        assertThat(TransportClusterHealthAction.prepareResponse(request, response, clusterState, null), equalTo(0));
            ShardRoutingState state = shardRoutingStates.get(i);  
        }
 *
 */  
 * specific language governing permissions and limitations
import org.opensearch.Version;
        final IndexRoutingTable.Builder routingTable = new IndexRoutingTable.Builder(indexMetadata.getIndex());
/*  
    }
import static org.hamcrest.core.IsEqual.equalTo;  
import org.opensearch.cluster.routing.IndexRoutingTable;
        for (int i = 0; i < shardRoutingStates.size(); i++) {
        request.waitForNoInitializingShards(true);  
import java.util.stream.IntStream;
            .build();  
        Randomness.shuffle(shardRoutingStates);
            routingTable.addShard(TestShardRouting.newShardRouting(shardId, node, "relocating" + i, randomBoolean(), state));
            .numberOfReplicas(randomInt(20))
        clusterState = randomClusterStateWithInitializingShards("test", randomInt(20));  
 * not use this file except in compliance with the License.
        request.waitForNoInitializingShards(false);
    ClusterState randomClusterStateWithInitializingShards(String index, final int initializingShards) {
            .numberOfShards(between(1, 10))
import org.opensearch.core.index.Index;
 * Modifications Copyright OpenSearch Contributors. See
    }  
        request.waitForActiveShards(ActiveShardCount.ALL);
import org.opensearch.common.settings.Settings;  
import org.opensearch.cluster.ClusterState;
        ClusterHealthResponse response = new ClusterHealthResponse("", indices, clusterState);
import org.opensearch.cluster.metadata.IndexMetadata;
        assertThat(TransportClusterHealthAction.prepareResponse(request, response, clusterState, null), equalTo(1));
        final String[] indices = { "test" };
 * The OpenSearch Contributors require contributions made to  
            .build();
        final String[] indices = { "test" };  
 * Licensed to Elasticsearch under one or more contributor  
 * under the License.  
 * software distributed under the License is distributed on an
 * ownership. Elasticsearch licenses this file to you under  
            ShardRoutingState state = shardRoutingStates.remove(0);
        ClusterHealthResponse response = new ClusterHealthResponse("", indices, clusterState);  
            .settings(settings(Version.CURRENT))  
 * compatible open source license.
public class TransportClusterHealthActionTests extends OpenSearchTestCase {
            .forEach(
        assertThat(TransportClusterHealthAction.prepareResponse(request, response, clusterState, null), equalTo(0));  
import org.opensearch.cluster.routing.ShardRoutingState;  
 *
 * the Apache License, Version 2.0 (the "License"); you may
        IntStream.range(0, between(1, 30))  
        {
        response = new ClusterHealthResponse("", indices, clusterState);
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.cluster.metadata.Metadata;  
                    randomFrom(ShardRoutingState.STARTED, ShardRoutingState.UNASSIGNED, ShardRoutingState.RELOCATING)  
            .metadata(Metadata.builder().put(indexMetadata, true))  
        final List<ShardRoutingState> shardRoutingStates = new ArrayList<>();
 */
 * GitHub history for details.
import java.util.ArrayList;
 * Unless required by applicable law or agreed to in writing,
            routingTable.addShard(TestShardRouting.newShardRouting(shardId, node, "relocating", true, state));
        // Replicas
    public void testWaitForInitializingShards() throws Exception {
        ClusterState clusterState = randomClusterStateWithInitializingShards("test", 0);
/*  
    public void testWaitForAllShards() {
 */  
        final ClusterHealthRequest request = new ClusterHealthRequest();
        final ShardId shardId = new ShardId(new Index("index", "uuid"), 0);  
        assertThat(TransportClusterHealthAction.prepareResponse(request, response, clusterState, null), equalTo(0));  
        assertThat(TransportClusterHealthAction.prepareResponse(request, response, clusterState, null), equalTo(1));
        // Primary  
import org.opensearch.cluster.routing.RoutingTable;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
