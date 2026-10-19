                waitForDocs(numOfDocs, indexer);
        ClusterState state = client(internalCluster().getClusterManagerName()).admin().cluster().prepareState().get().getState();  
    }  
        assertHitCount(client().prepareSearch(indexName).setSize(0).get(), numOfDocs);  
 *  
import org.opensearch.cluster.ClusterState;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
public class ReplicaToPrimaryPromotionIT extends OpenSearchIntegTestCase {  
            }
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;
 * specific language governing permissions and limitations
    public void testPromoteReplicaToPrimary() throws Exception {  
import static org.hamcrest.Matchers.equalTo;
/*
        if (indexState == IndexMetadata.State.CLOSE) {
            try (BackgroundIndexer indexer = new BackgroundIndexer(indexName, "_doc", client(), numOfDocs)) {  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * GitHub history for details.
    protected int numberOfReplicas() {  
    }
 * ownership. Elasticsearch licenses this file to you under  
        final String indexName = randomAlphaOfLength(5).toLowerCase(Locale.ROOT);
            ensureYellowAndNoInitializingShards(indexName);  
}
import org.opensearch.test.InternalTestCluster;
 * not use this file except in compliance with the License.
            assertAcked(client().admin().indices().prepareOpen(indexName));
            ensureGreen(indexName);
        }
    public boolean useRandomReplicationStrategy() {
    }
        for (IndexShardRoutingTable shardRoutingTable : state.routingTable().index(indexName)) {
        }  
import static org.hamcrest.Matchers.is;  
        final IndexMetadata.State indexState = randomFrom(IndexMetadata.State.OPEN, IndexMetadata.State.CLOSE);
        createIndex(indexName);
import org.opensearch.action.admin.indices.close.CloseIndexResponse;  
            }
/*  
 * under the License.  
        final int numShards = state.metadata().index(indexName).getNumberOfShards();
 */  
import java.util.Locale;
        return true;  
 * the Apache License, Version 2.0 (the "License"); you may
 * The OpenSearch Contributors require contributions made to  
        final int numOfDocs = scaledRandomIntBetween(0, 200);
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;  
/*
 * this file be licensed under the Apache-2.0 license or a
    @Override
        ensureGreen(indexName);
        assertHitCount(client().prepareSearch(indexName).setSize(0).get(), numOfDocs);
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(randomNode.getName()));  
        if (indexState == IndexMetadata.State.CLOSE) {
 *
 * compatible open source license.
 * license agreements. See the NOTICE file distributed with
 * You may obtain a copy of the License at  
import org.opensearch.cluster.routing.ShardRouting;
            assertThat("close index not acked - " + closeIndexResponse, closeIndexResponse.isAcknowledged(), equalTo(true));
 */
        final ShardRouting primaryShard = state.routingTable().index(indexName).shard(randomIntBetween(0, numShards - 1)).primaryShard();
 *
        state = client(internalCluster().getClusterManagerName()).admin().cluster().prepareState().get().getState();  
            refreshAndWaitForReplication(indexName);  
        // pick up a data node that contains a random primary shard
import org.opensearch.cluster.routing.IndexShardRoutingTable;
        }
 * Modifications Copyright OpenSearch Contributors. See  
 */
import org.opensearch.test.OpenSearchIntegTestCase;
 * SPDX-License-Identifier: Apache-2.0
        if (numOfDocs > 0) {
        final DiscoveryNode randomNode = state.nodes().resolveNode(primaryShard.currentNodeId());  
 * this work for additional information regarding copyright
 * Licensed to Elasticsearch under one or more contributor  
        ensureYellowAndNoInitializingShards(indexName);
            CloseIndexResponse closeIndexResponse = client().admin().indices().prepareClose(indexName).get();  
        }
@OpenSearchIntegTestCase.ClusterScope(numDataNodes = 2)
                assertThat(shardRouting + " should be promoted as a primary", shardRouting.primary(), is(true));  
        // stop the random data node, all remaining shards are promoted to primaries
import org.opensearch.cluster.metadata.IndexMetadata;
            for (ShardRouting shardRouting : shardRoutingTable.activeShards()) {
import org.opensearch.cluster.node.DiscoveryNode;  
        return 1;
    @Override
 * Unless required by applicable law or agreed to in writing,
        // sometimes test with a closed index  
 * KIND, either express or implied.  See the License for the
 * software distributed under the License is distributed on an
import org.opensearch.test.BackgroundIndexer;  
package org.opensearch.indices.recovery;
