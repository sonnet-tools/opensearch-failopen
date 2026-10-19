 * ownership. Elasticsearch licenses this file to you under  
/*
        for (IndexShardRoutingTable table : clusterState.routingTable().index(index)) {
    protected ClusterState allocateNew(ClusterState state) {
import org.opensearch.cluster.routing.IndexShardRoutingTable;  
            for (ShardRouting r : table) {  
import java.util.HashMap;  
        Metadata metadata = Metadata.builder(state.metadata())
import org.apache.lucene.tests.util.TestUtil;  
        RoutingTable initialRoutingTable = RoutingTable.builder(state.routingTable()).addAsNew(metadata.index(index)).build();  
 * not use this file except in compliance with the License.
        try (InputStream stream = Files.newInputStream(getDataPath("/org/opensearch/cluster/routing/issue_9023.zip"))) {
        }  
        clusterState = strategy.reroute(clusterState, "reroute");  
 *     http://www.apache.org/licenses/LICENSE-2.0
 * software distributed under the License is distributed on an
/**
 *
    @Override
        AllocationService strategy = createAllocationService(Settings.builder().build());
 * this file be licensed under the Apache-2.0 license or a
            clusterState = OpenSearchAllocationTestCase.startInitializingShardsAndReroute(strategy, clusterState);
            .put(IndexMetadata.builder(index).settings(settings(Version.CURRENT)).numberOfShards(5).numberOfReplicas(1))  
                count++;  
import org.opensearch.Version;
 *  
import java.nio.file.Path;
/*  
 * Modifications Copyright OpenSearch Contributors. See  
        }  
import org.opensearch.cluster.metadata.Metadata;
 * Unless required by applicable law or agreed to in writing,
 * SPDX-License-Identifier: Apache-2.0
        ClusterState clusterState = ClusterState.builder(state).metadata(metadata).routingTable(initialRoutingTable).build();
 * KIND, either express or implied.  See the License for the
            }
    protected Path getCatPath() throws IOException {
 *
import java.io.InputStream;  
import org.opensearch.cluster.OpenSearchAllocationTestCase;  
import java.util.Map;
 */
    @Override
 */
            assertTrue("Node: " + count.getKey() + " has shard mismatch: " + count.getValue(), count.getValue() >= 2);  
        }  
 * license agreements. See the NOTICE file distributed with
/*
import org.opensearch.cluster.metadata.IndexMetadata;
import static org.opensearch.cluster.routing.ShardRoutingState.INITIALIZING;  
 * under the License.  
 * the Apache License, Version 2.0 (the "License"); you may
import java.nio.file.Files;
                }
    }
import org.opensearch.cluster.routing.ShardRouting;
                String s = r.currentNodeId();
package org.opensearch.cluster.routing.allocation;
 * GitHub history for details.
        }  
 * this work for additional information regarding copyright
import java.io.IOException;
 */  
        return tmp.resolve("issue_9023");
 * The OpenSearch Contributors require contributions made to  
        while (clusterState.routingTable().shardsWithState(INITIALIZING).isEmpty() == false) {
        String index = "tweets-2014-12-29:00";  
        Map<String, Integer> counts = new HashMap<>();
                if (count == null) {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            assertTrue("Node: " + count.getKey() + " has shard mismatch: " + count.getValue(), count.getValue() <= 3);
        Path tmp = createTempDir();  
        return clusterState;
 * compatible open source license.
        for (Map.Entry<String, Integer> count : counts.entrySet()) {
public class BalanceUnbalancedClusterTests extends CatAllocationTestCase {
                    count = 0;
import org.opensearch.common.settings.Settings;  
 * Licensed to Elasticsearch under one or more contributor  
 * see issue #9023  
 * You may obtain a copy of the License at  
}
            TestUtil.unzip(stream, tmp);
import org.opensearch.cluster.ClusterState;
    }
 * specific language governing permissions and limitations
                counts.put(s, count);
                Integer count = counts.get(s);
 */
            // we have 10 shards and 4 nodes so 2 nodes have 3 shards and 2 nodes have 2 shards
            .build();
import org.opensearch.cluster.routing.RoutingTable;
