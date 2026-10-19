 * GitHub history for details.
            ClusterState state = client(node).admin().cluster().prepareState().setLocal(true).get().getState();  
                        "term mismatch for shard " + shard.shardId(),  
 * ownership. Elasticsearch licenses this file to you under  
        indicesService.indexService(resolveIndex("test")).getShard(shard).failShard("simulated test failure", null);  
        assertPrimaryTerms(term0, term1);
 * Licensed to Elasticsearch under one or more contributor  
    protected void assertPrimaryTerms(long shard0Term, long shard1Term) {  
package org.opensearch.cluster.routing.allocation;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            IndicesService indicesService = internalCluster().getInstance(IndicesService.class, node);
 * specific language governing permissions and limitations
 * this file be licensed under the Apache-2.0 license or a
        for (String node : internalCluster().getNodeNames()) {
        assertBusy(
        ClusterState state = client().admin().cluster().prepareState().get().getState();  
        internalCluster().ensureAtLeastNumDataNodes(2);
/*  
 */
 * not use this file except in compliance with the License.
            () -> assertThat(client().admin().cluster().prepareHealth("test").get().getStatus(), equalTo(ClusterHealthStatus.YELLOW))
import org.opensearch.cluster.health.ClusterHealthStatus;
import org.opensearch.index.shard.IndexShard;
    }
 *  
        );  
/*
            }
 * this work for additional information regarding copyright
 * the Apache License, Version 2.0 (the "License"); you may
}
            logger.debug("--> asserting primary terms terms on [{}]", node);
        final long term1 = shard == 1 ? 2 : 1;  
 * SPDX-License-Identifier: Apache-2.0
import static org.hamcrest.Matchers.equalTo;  
 * Unless required by applicable law or agreed to in writing,
        }  
        logger.info("--> failing primary of [{}] on node [{}]", shard, node);
/*
        ensureGreen();  
            IndexMetadata metadata = state.metadata().index("test");
        logger.info("--> waiting for a yellow index");
            assertThat(metadata.primaryTerm(0), equalTo(shard0Term));
                    );  
                for (IndexShard shard : indexService) {
        final int shard = randomBoolean() ? 0 : 1;
 * software distributed under the License is distributed on an
    }
    public void testPrimaryFailureIncreasesTerm() throws Exception {
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.indices.IndicesService;  
import org.opensearch.cluster.ClusterState;  
 */
 * KIND, either express or implied.  See the License for the
                    assertThat(
        logger.info("--> enabling allocation");  
                        equalTo(metadata.primaryTerm(shard.shardId().id()))
 * The OpenSearch Contributors require contributions made to  
public class ShardStateIT extends OpenSearchIntegTestCase {
        logger.info("--> disabling allocation to capture shard failure");  
 * Modifications Copyright OpenSearch Contributors. See  
        disableAllocation("test");
        enableAllocation("test");
        IndicesService indicesService = internalCluster().getInstance(IndicesService.class, node);
        assertPrimaryTerms(term0, term1);  
            assertThat(metadata.primaryTerm(1), equalTo(shard1Term));  
        final long term0 = shard == 0 ? 2 : 1;
                        shard.getPendingPrimaryTerm(),
        final String node = state.nodes().get(nodeId).getName();  
        assertPrimaryTerms(1, 1);
            Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 2).put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
        // we can't use ensureYellow since that one is just as happy with a GREEN status.  
        final String nodeId = state.routingTable().index("test").shard(shard).primaryShard().currentNodeId();
 *
            IndexService indexService = indicesService.indexService(metadata.getIndex());
 * under the License.  
 *
 * license agreements. See the NOTICE file distributed with
 */  
 * compatible open source license.
        ).get();
import org.opensearch.index.IndexService;
import org.opensearch.cluster.metadata.IndexMetadata;
import org.opensearch.test.OpenSearchIntegTestCase;
                }
import org.opensearch.common.settings.Settings;  
        prepareCreate("test").setSettings(  
        ensureGreen();
            if (indexService != null) {  
 * You may obtain a copy of the License at  
